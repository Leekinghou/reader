package com.reader.task;

import com.reader.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 完成计算任务
 */
@Component
public class ComputeTask {
    @Resource
    private BookService bookService;

    // 任务调度
    @Scheduled(cron = "0 * * * * ?") // 秒 分钟 小时 日 月 星期
    public void updateEvaluation(){
        bookService.updateEvaluation();
        System.out.println("已更新所有评分");
    }
}
