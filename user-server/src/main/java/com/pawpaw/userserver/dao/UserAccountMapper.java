package com.pawpaw.userserver.dao;

import com.pawpaw.userserver.dao.entity.UserAccount;
import org.apache.ibatis.annotations.*;

public interface UserAccountMapper {
    static final String TABLE = "user_account";

    static final String[] FIELDS = {"user_id", "source", "mobile", "weixin_open_id", "nick_name", "gender", "update_time", "create_time", "status", "type"};

    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    @Insert({"insert into " + TABLE,
            "(source, mobile, weixin_open_id, nick_name, gender, update_time, create_time, status, type)",
            "values(#{source},#{mobile},#{weixinOpenId},#{nickName},#{gender},#{updateTime},#{createTime},#{status},#{type})"
    })
    public void insert(UserAccount userAccount);

    @Select("select * from " + TABLE + " where mobile=#{mobile}")
    UserAccount getByMobile(@Param("mobile") String mobile);


    @Select("select * from " + TABLE + " where weixin_open_id=#{openId}")
    UserAccount getByWXOpenId(@Param("openId") String openId);

    @Update("update " + TABLE + " set status=#{statusToUpdate} where user_id=#{userId}")
    void updateStatusById(@Param("userId") long userId, @Param("statusToUpdate") int statusToUpdate);

}