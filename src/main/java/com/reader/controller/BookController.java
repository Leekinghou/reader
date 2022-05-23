package com.reader.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.reader.Entity.*;
import com.reader.service.BookService;
import com.reader.service.CategoryService;
import com.reader.service.EvaluationService;
import com.reader.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: lijinhao
 * @date: 2022/03/08 10:33
 */
@Controller
public class BookController {
    @Resource
    private CategoryService categoryService;

    @Resource
    private BookService bookService;

    @Resource
    private EvaluationService evaluationService;

    @Resource
    private MemberService memberService;

    @GetMapping("/")
    public ModelAndView showIndex(){

        // 只需要文件名，不需要后缀
        ModelAndView mav = new ModelAndView("/index");
        List<Category> categoryList = categoryService.selectAll();
        mav.addObject("categoryList", categoryList);
        return mav;
    }

    /**
     * 分页查询图书列表
     * @param p 页号
     * @return 分页对象
     */
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> selectBook(Long categoryId, String order, Integer p){
        if(p == null){
            p = 1;
        }
        IPage<Book> pageObject = bookService.paging(categoryId, order, p, 10);
        return pageObject;
    }

    /**
     *    该对象中包含了一个model属性和一个view属性
     * 　　model：其实是一个ModelMap类型。其实ModelMap是一个LinkedHashMap的子类
     * 　　view：包含了一些视图信息
     * 　　当视图解释器解析ModelAndVIew是，其中model本身就是一个Map的实现类的子类。
     *    视图解析器将model中的每个元素都通过request.setAttribute(name, value);添加request请求域中。
     *    这样就可以在JSP页面中通过EL表达式来获取对应的值
     */
    @GetMapping("/book/{id}")
    @ResponseBody
    public ModelAndView showDetail(@PathVariable("id") Long id, HttpSession session){
        Book book = bookService.selectById(id);
        List<Evaluation> evaluationList = evaluationService.selectByBookId(id);
        ModelAndView mav = new ModelAndView("/detail");
        Member member = (Member)session.getAttribute("loginMember");
        // 用户之前点击过
        if(member != null) {
            MemberReadState memberReadState = memberService.selectMemberReadState(member.getMemberId(), id);
            mav.addObject("memberReadState", memberReadState);
        }

        mav.addObject("book", book);
        mav.addObject("evaluationList", evaluationList);
        return mav;
    }
}

