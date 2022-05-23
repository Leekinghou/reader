package com.reader.service;

import com.reader.Entity.Evaluation;
import com.reader.Entity.Member;
import com.reader.Entity.MemberReadState;

/**
 * @author: lijinhao
 * @date: 2022/04/12 19:40
 */
public interface MemberService {
    /**
     * 会员注册，创建新会员
     * @param username
     * @param password
     * @param nickname
     * return 新会员对象
     */
    public Member createMember(String username, String password, String nickname);

    Member checkLogin(String username, String password);

    /**
     * 获取阅读状态
     * @param memberId 会员编号
     * @param bookId 图书编号
     * @return 阅读状态对象
     */
    MemberReadState selectMemberReadState(Long memberId, Long bookId);

    /**
     * 更新阅读状态
     * @param memberId 会员编号
     * @param bookId 图书编号
     * @param readState 阅读状态
     * @return 阅读状态对象
     */
    MemberReadState updateMemberReadState(Long memberId , Long bookId , Integer readState);

    /**
     * 发布新的短评
     * @param memberId 会员编号
     * @param bookId 图书编号
     * @param score 评分
     * @param content 短评内容
     * @return 短评对象
     */
    Evaluation evaluate(Long memberId, Long bookId, Integer score, String content);

    /**
     * 短评点赞
     * @param evaluationId 短评编号
     * @return 短评对象
     */
    Evaluation enjoy(Long evaluationId);
}
