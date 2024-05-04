package com.exchange.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("data_category")
public class DataCategory {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "data_name")
    private String tableName;

    @TableField(value = "description")
    private String description;

    @TableField(value = "data_label")
    private String dataLabel;

    @TableField(value = "node_code")
    private String nodeCode;

    @TableField(value = "parent_id")
    private String parentId;

    @TableField(value = "node_type")
    private String nodeType;

    @TableField(value = "create_time", select = false, fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "update_time", select = false, fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

    @TableField(value = "create_user_id", select = false)
    private String createUserId;

    @TableField(value = "update_user_id", select = false)
    private String updateUserId;

}
