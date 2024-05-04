package com.exchange.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("api_param")
public class ApiParam {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "api_id")
    private String apiId;

    @TableField(value = "name")
    private String paramName;

    @TableField(value = "type")
    private String paramType;

    @TableField(value = "not_null")
    private int notNull;

    @TableField(value = "description")
    private String description;

    @TableField(value = "example")
    private String example;

    @TableField(value = "position")
    private int position;

    @TableField(value = "sort_num")
    private int sortNum;

    @TableField(value = "create_time", fill = FieldFill.INSERT, select = false)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, select = false)
    private LocalDateTime updateTime;

    @TableField(value = "create_user_id", select = false)
    private String createUserId;

    @TableField(value = "update_user_id", select = false)
    private String updateUserId;
}
