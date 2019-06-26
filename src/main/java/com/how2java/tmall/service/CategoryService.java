package com.how2java.tmall.service;
 
import java.util.List;

import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
 
import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.pojo.Category;
 
@Service
public class CategoryService {
    @Autowired CategoryDAO categoryDAO;

    /**
     * 排序查询
     * @return
     */
    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    /**
     * 分页查询
     * @param start
     * @param size
     * @param navigatePages
     * @return
     */
    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =categoryDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    /**
     * 新增
     * @param bean
     */
    public void add(Category bean) {
        categoryDAO.save(bean);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id) {
        categoryDAO.delete(id);
    }

    /**
     * 根据ID查询并返回
     * @param id
     * @return
     */
    public Category get(int id) {
        Category c= categoryDAO.findOne(id);
        return c;
    }

    /**
     * 修改数据
     * @param bean
     */
    public void update(Category bean) {
        categoryDAO.save(bean);
    }
}