package com.reader.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reader.Entity.Category;
import com.reader.Entity.Test;

import java.util.List;

/**
 * @author: lijinhao
 * @date: 2022/03/08 09:50
 */

public interface CategoryService{
    public List<Category> selectAll();
}
