package com.reader.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.reader.Entity.Book;

/**
 * @author: lijinhao
 * @date: 2022/03/08 14:59
 */
public interface BookService {
    /**
     * 分页查询图书
     * @param categoryId 分类编号
     * @param order 排序方式
     * @param page 页号
     * @param rows 每页记录数
     * @return 分页对象
     */
    IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows);

    /**
     * 根据图书编号查询图书对象
     * @param bookId 图书编号
     * @return 图书对象
     */
    Book selectById(Long bookId);

    /**
     * 更新图书评分/评价数量
     */
    void updateEvaluation();

    /**
     * 创建新的图书
     */
    Book createBook(Book book);

    /**
     * 更新图书
     * @param book 新图书数据
     * @return 更新后的数据
     */
    Book updateBook(Book book);

    /**
     * 删除图书及相关数据
     * @param bookId 图书编号
     */
    void deleteBook(Long bookId);
}
