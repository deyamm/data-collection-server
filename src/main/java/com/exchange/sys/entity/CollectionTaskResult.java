package com.exchange.sys.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("collection_task_result")
public class CollectionTaskResult {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "task_id")
    private String taskId;

    @TableField(value = "exe_method")
    private int exeMethod;

    @TableField(value = "exe_result")
    private int exeResult;

    @TableField(value = "batch_num")
    private int batchNum;

    @TableField(value = "plan_time")
    private String planTime;

    @TableField(value = "start_time")
    private String startTime;

    @TableField(value = "end_time")
    private String  endTime;
}
