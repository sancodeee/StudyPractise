package com.ws.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("book")
public class Book {

    @TableId(value = "id" , type = IdType.AUTO)
    @ExcelProperty(value ={"书籍信息","ID"} ,index = 0)
    private Integer id;

    @TableField("name")
    @ExcelProperty(value = {"书籍信息","名称"},index = 1)
    private String name;

    @TableField("type")
    @ExcelProperty(value = {"书籍信息","类型"},index = 2)
    private String type;

    @TableField("description")
    @ExcelProperty(value = {"书籍信息","描述"},index = 3)
    private String description;

}
