package com.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reader.Entity.Book;

/**
 * @author: lijinhao
 * @date: 2022/03/08 14:57
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 更新图书评分/评价数量
     */
    void updateEvaluation();
}
