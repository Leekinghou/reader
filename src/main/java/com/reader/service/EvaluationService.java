package com.reader.service;

import com.reader.Entity.Evaluation;

import java.util.List;

/**
 * @author: lijinhao
 * @date: 2022/04/11 19:50
 */
public interface EvaluationService{
    /**
     * 按图书编号查询有效短评
     * @param bookId 图书编号
     * @return 评论列表
     */
    public List<Evaluation> selectByBookId(Long bookId);
}
