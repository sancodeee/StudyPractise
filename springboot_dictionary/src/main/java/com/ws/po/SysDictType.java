package com.ws.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_dict_type")
public class SysDictType {

    @TableId(value = "dict_id", type = IdType.AUTO)
    private Integer dictId;

    @TableField("dict_name")
    private String dictName;

    @TableField("dict_type")
    private String dictType;

    @TableField("status")
    private String status;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;

    @TableField("remark")
    private String remark;

}
