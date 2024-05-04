package com.exchange.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("collection_task")
public class CollectionTask {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "api_id")
    private String apiId;

    @TableField(value = "task_name")
    private String taskName;

    @TableField(value = "task_description")
    private String taskDescription;

    @TableField(value = "data_category")
    private String dataCategory;

    @TableField(value = "schedule_cycle")
    private String scheduleCycle;

    @TableField(value = "status")
    private String status;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_user_id", select = false)
    private String createUserId;

    @TableField(value = "update_user_id", select = false)
    private String updateUserId;
}
