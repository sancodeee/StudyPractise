package com.ws.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "名称不能为空！")
    @TableField("name")
    private String name;

    @NotNull(message = "类型不能为空！")
    @TableField("type")
    private String type;

    @TableField("description")
    private String description;

}
