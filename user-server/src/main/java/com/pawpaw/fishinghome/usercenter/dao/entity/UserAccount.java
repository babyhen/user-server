package com.pawpaw.fishinghome.usercenter.dao.entity;

import java.util.Date;

public class UserAccount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.user_id
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.source
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private Integer source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.mobile
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.weixin_open_id
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private String weixinOpenId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.nick_name
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.gender
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.update_time
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.create_time
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.status
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.type
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.user_id
     *
     * @return the value of user_account.user_id
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.user_id
     *
     * @param userId the value for user_account.user_id
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.source
     *
     * @return the value of user_account.source
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public Integer getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.source
     *
     * @param source the value for user_account.source
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.mobile
     *
     * @return the value of user_account.mobile
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.mobile
     *
     * @param mobile the value for user_account.mobile
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.weixin_open_id
     *
     * @return the value of user_account.weixin_open_id
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.weixin_open_id
     *
     * @param weixinOpenId the value for user_account.weixin_open_id
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId == null ? null : weixinOpenId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.nick_name
     *
     * @return the value of user_account.nick_name
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.nick_name
     *
     * @param nickName the value for user_account.nick_name
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.gender
     *
     * @return the value of user_account.gender
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.gender
     *
     * @param gender the value for user_account.gender
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.update_time
     *
     * @return the value of user_account.update_time
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.update_time
     *
     * @param updateTime the value for user_account.update_time
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.create_time
     *
     * @return the value of user_account.create_time
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.create_time
     *
     * @param createTime the value for user_account.create_time
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.status
     *
     * @return the value of user_account.status
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.status
     *
     * @param status the value for user_account.status
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.type
     *
     * @return the value of user_account.type
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.type
     *
     * @param type the value for user_account.type
     *
     * @mbg.generated Tue Sep 11 00:12:09 CST 2018
     */
    public void setType(Integer type) {
        this.type = type;
    }
}