package com.reader.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author: lijinhao
 * @date: 2022/03/07 21:01
 */

@TableName("test") //说明实体对应哪一张表
public class Test {
    @TableId(type = IdType.AUTO)
    @TableField("id") //说明实体对应哪一个字段
    private Integer id;

    @TableField("content")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
