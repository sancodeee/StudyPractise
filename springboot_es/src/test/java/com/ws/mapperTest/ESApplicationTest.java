package com.ws.mapperTest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ws.dao.BookMapper;
import com.ws.pojo.Book;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootTest
public class ESApplicationTest {

    @Autowired
    private BookMapper bookMapper;
      //旧版本
//    @Autowired
//    private ElasticsearchTemplate template;
      //新版本

    @Test
    void add(){
        int result = bookMapper.insert(new Book(7, "狂人日记", "_doc", "作者以彻底的“革命民主主义”的立场对中国的文化进行了深刻的反思，同时对中国的甚至是人类的前途表达了深广的忧愤。"));
        System.out.println("插入是否成功：" + result);
    }

    @Test
    void selectById(){
        Book book = bookMapper.selectById(2);
        System.out.println("查询结果----------》"+book);
    }

    @Test
    void update(){
        UpdateWrapper<Book> bookUpdateWrapper = new UpdateWrapper<>();
        bookUpdateWrapper.eq("id", 1);
        Book book = new Book().setName("老人与海v2");
        bookMapper.update(book,bookUpdateWrapper);
    }

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    //创建索引
    @Test
    void esIndexTest() throws IOException {

        //获取数据库索引对象
        IndicesClient indices = restHighLevelClient.indices();

        //通过创建索引请求对象创建索引 创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("books");

        //设置mappings信息，先构建json字符串
        String json = "{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        createIndexRequest.source(json, XContentType.JSON);

       //执行创建索引请求
        CreateIndexResponse response = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println("-----------------------");
        System.out.println(response.toString());

    }

    //向索引中添加文档
    @Test
    void esDocTest() throws IOException {

        Book book = bookMapper.selectById(1);

        //创建请求对象
        IndexRequest indexRequest = new IndexRequest("books").id(book.getId().toString());

        String json = JSON.toJSONString(book) ;
        indexRequest.source(json,XContentType.JSON).type("_doc");
        restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);

    }

    @Test
    //批量向索引中添加文档
    void esDocBulk() throws IOException{
        Book book3 = bookMapper.selectById(3);
        Book book4 = bookMapper.selectById(4);

        IndexRequest indexRequest1 = new IndexRequest("books").id(book3.getId().toString());
        String json = JSON.toJSONString(book3);
        indexRequest1.source(json,XContentType.JSON).type("_doc");

        IndexRequest indexRequest2 = new IndexRequest("books").id(book4.getId().toString());
        String json2 = JSON.toJSONString(book3);
        indexRequest2.source(json2,XContentType.JSON).type("_doc");

        //Bulk相当于一个容器 用来存各个请求的容器
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(indexRequest1);
        bulkRequest.add(indexRequest2);

        restHighLevelClient.bulk(bulkRequest,RequestOptions.DEFAULT);

    }

    @Test
    //根据id查询索引下的文档
    void queryById() throws IOException{

        GetRequest getRequest = new GetRequest("books","_doc","1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        String sourceAsString = getResponse.getSourceAsString();
        System.out.println("查询到的json字符串"+sourceAsString);

    }

    @Test
    //条件查询
    void search() throws IOException{

        SearchRequest searchRequest = new SearchRequest();

        //查询条件api
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("name","百年"));
        //将查询条件添加到请求中
        searchRequest.source(builder);

        //将请求通过客户端提交 会返回一个响应值
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //查询结果会放到hit里
        SearchHits hits = searchResponse.getHits();
        for(SearchHit hit : hits){
            String sourceAsString = hit.getSourceAsString();
//            System.out.println("查询结果："+sourceAsString);
            Book book = JSON.parseObject(sourceAsString, Book.class);
            System.out.println(book);

        }


    }

}
