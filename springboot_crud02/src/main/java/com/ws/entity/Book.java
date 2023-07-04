package com.ws.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "书籍信息")
@TableName(value = "book")
public class Book {

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "书籍名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "书籍类型")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty(value = "书籍描述")
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "书籍作者编号")
    @TableField(value = "book_author")
    private Integer bookAuthor;

    @ApiModelProperty(value = "删除标志位")
    @TableField(value = "delete_flag")
    private Integer deleteFlag;


}
