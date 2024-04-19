package com.ws.interviewIssue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * MetaApp问题
 *
 * @author wangsen
 * @date 2024/01/22
 */
@Slf4j
public class MetaAppIssue {

    //log文件路径
    String filePath = "D:\\workspace\\log.txt";

    /**
     * 测试结果
     */
    @Test
    public void test() {
        // 提取https的url
        List<String> httpsUrls = extractFileCharacter(filePath, urlRegex);
        System.out.println("去重前的HTTPS URL:");
        // 日志文件中的https url
        for (String httpsUrl : httpsUrls) {
            System.out.println(httpsUrl);
        }
        int beforeDRSize = httpsUrls.size();
        System.out.println("去重前https Url的个数为：" + beforeDRSize);
        int afterDRSize = httpsUrls.stream().distinct().collect(Collectors.toList()).size();
        System.out.println("去重后https Url的个数为：" + afterDRSize);
        System.out.println("去重前和去重后的总个数为" + (beforeDRSize + afterDRSize));

        // 日志文件中提取ipv4
        List<String> ipv4List = extractFileCharacter(filePath, ipv4Regex);
        System.out.println("去重后IPv4地址：");
        List<String> afterDRIp = ipv4List.stream().distinct().collect(Collectors.toList());
        for (String ip : afterDRIp) {
            // 去重后的ipv4地址
            System.out.println(ip);
        }
        System.out.println("去重后ipv4地址个数：" + afterDRIp.size());

        // 日志文件中的进度信息
        Map<Integer, String> scheMap = extractFileCharacter(filePath, scheRegex, 0);
        System.out.println("进度信息所在行信息结果：");
        // 根据key值从小到大排序后打印日志行
        scheMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.println("行数：" + entry.getKey() + "，进度日志信息：" + entry.getValue());
        });

    }


    // https url正则表达式
    String urlRegex = "(?:https:\\/\\/)(?:'([^']+)'|\"([^\"]+)\"|([^'\"\\s]+))";
    // IPv4正则表达式
    String ipv4Regex = "\\b(?:25[0-5]|(?:2[0-4]|1\\d|[1-9])?\\d)(?:\\.(?:25[0-5]|(?:2[0-4]|1\\d|[1-9])?\\d)){3}\\b";
    // 进度信息正则表达式
    String scheRegex = "(?:\\(|\\[)(\\d+\\/\\d+)(?:\\)|\\])";


    /**
     * 提取文件字符串
     *
     * @param filePath 文件路径
     * @param regex    正则表达式
     * @return {@link List}<{@link String}>
     */
    public static List<String> extractFileCharacter(String filePath, String regex) {
        // 存放结果
        List<String> result = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                // 得到每行匹配到的结果
                List<String> strInLine = extractCharacter(line, regex);
                result.addAll(strInLine);
            }
        } catch (IOException e) {
            log.error("捕获异常:", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("捕获异常：", e);
                }
            }
        }
        return result;
    }

    /**
     * 提取文件字符
     *
     * @param filePath 文件路径
     * @param regex    正则表达式
     * @param group    组
     * @return {@link List}<{@link String}>
     */
    public static Map<Integer, String> extractFileCharacter(String filePath, String regex, int group) {
        // 存放结果
        Map<Integer, String> resultMap = new HashMap<>();
        String line;
        int lineNumber = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lineNumber++;
                // 得到每行匹配到的结果
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String str = matcher.group(group);
                    // 获取匹配的开始和结束索引
                    int startIndex = matcher.start();
                    int endIndex = matcher.end();
                    // 截取整行文本
                    String fullLine = line.substring(0, startIndex) + str + line.substring(endIndex);
                    resultMap.put(lineNumber, fullLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMap;
    }

    /**
     * 提取文本字符
     *
     * @param text  文本
     * @param regex 正则表达式
     * @return {@link List}<{@link String}>
     */
    public static List<String> extractCharacter(String text, String regex) {
        List<String> str = new ArrayList<>();
        // 读取正则表达式
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            str.add(matcher.group());
        }
        return str;
    }

    /**
     * 提取文本字符串所在的组
     *
     * @param text  文本
     * @param regex 正则表达式
     * @return {@link List}<{@link String}>
     */
    public static List<String> extractCharacter(String text, String regex, int group) {
        List<String> str = new ArrayList<>();
        // 读取正则表达式
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            str.add(matcher.group(group));
        }
        return str;
    }


}
