package com.exchange.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.google.protobuf.Api;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName("collection_api")
public class CollectionApi {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "title")
    private String title;

    @TableField(value = "description")
    private String description;

    @TableField(value = "status")
    private int status;

    @TableField(value = "type")
    private String type;

    @TableField(value = "source")
    private String source;

    @TableField(value = "source_page")
    private String sourcePage;

    @TableField(exist = false)
    private List<ApiParam> requestParams;

    @TableField(exist = false)
    private List<ApiParam> responseParams;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_user_id", select = false)
    private String createUserId;

    @TableField(value = "update_user_id", select = false)
    private String updateUSerId;

}
