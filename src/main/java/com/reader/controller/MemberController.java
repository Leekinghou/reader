package com.reader.controller;

import com.reader.Entity.Evaluation;
import com.reader.Entity.Member;
import com.reader.service.MemberService;
import com.reader.service.exception.BussinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lijinhao
 * @date: 2022/04/12 15:34
 */

@Controller
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/register.html")  // 有利于百度爬虫
    public ModelAndView showRegister(){
        return new ModelAndView("/register");
    }

    @GetMapping("/login.html")
    public ModelAndView showLogin() {
        return new ModelAndView("/login");
    }


    @PostMapping("/register")
    @ResponseBody
    public Map register(String vc, String username, String password, String nickname, HttpServletRequest request){
        // 正确的验证码
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        // 验证码对比
        Map result = new HashMap();
        if(vc == null || verifyCode == null || !vc.equalsIgnoreCase(verifyCode)){
            result.put("code", "VC01");
            result.put("msg", "验证码错误");
        }else{
            try{
                memberService.createMember(username, password, nickname);
                result.put("code", 0);
                result.put("msg", "success");
            }catch (BussinessException e){
                e.printStackTrace();
                result.put("code", e.getCode());
                result.put("msg", e.getMsg());
            }
        }
        return result;
    }

    @PostMapping("/check_login")
    @ResponseBody
    public Map checkLogin(String username, String password, String vc, HttpSession session) {
        String verifyCode = (String) session.getAttribute("kaptchaVerifyCode");
        // 验证码对比
        Map result = new HashMap();
        if(vc == null || !vc.equalsIgnoreCase(verifyCode)){
            result.put("code", "VC01");
            result.put("msg", "验证码错误");
        }else{
            try {
                Member member = memberService.checkLogin(username, password);
                session.setAttribute("loginMember", member);
                result.put("code", "0");
                result.put("msg", "success");
            }catch (BussinessException ex){
                ex.printStackTrace();
                result.put("code", ex.getCode());
                result.put("msg", ex.getMsg());
            }
        }
        return result;
    }

    /**
     * 更新想看/看过阅读状态
     * @param memberId 会员id
     * @param bookId 图书id
     * @param readState 阅读状态
     * @return 处理结果
     */
    @PostMapping("/update_read_state")
    @ResponseBody
    public Map updateReadState(Long memberId , Long bookId , Integer readState){
        Map result = new HashMap();
        try {
            memberService.updateMemberReadState(memberId, bookId, readState);
            result.put("code", "0");
            result.put("msg", "success");
        }catch(BussinessException ex){
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }
        return result;
    }

    @PostMapping("/evaluate")
    @ResponseBody
    public Map evaluate(Long memberId, Long bookId, Integer score, String content) {
        Map result = new HashMap();
        try {
            Evaluation eva = memberService.evaluate(memberId, bookId, score, content);
            result.put("code", "0");
            result.put("msg", "success");
            result.put("evaluation", eva);
        }catch (BussinessException ex){
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }
        return result;
    }

    /**
     * 评论点赞
     * @param evaluationId
     * @return
     */
    @PostMapping("/enjoy")
    @ResponseBody
    public Map enjoy(Long evaluationId) {
        Map result = new HashMap();
        try {
            Evaluation enj = memberService.enjoy(evaluationId);
            result.put("code", "0");
            result.put("msg", "success");
            result.put("evaluation", enj);
        }catch (BussinessException ex){
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }
        return result;
    }

}
