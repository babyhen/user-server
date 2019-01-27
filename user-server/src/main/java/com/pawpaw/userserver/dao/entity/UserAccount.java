package com.pawpaw.userserver.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserAccount {

    private long userId;


    private Integer source;


    private String mobile;


    private String weixinOpenId;


    private String nickName;


    private Integer gender;


    private Date updateTime;


    private Date createTime;


    private Integer status;


    private Integer type;


    /////////////////////////////////////////

    public static enum Gender {
        MALE(1), FEMALE(2);
        int value;

        Gender(int value) {
            this.value = value;
        }

        public int intValue() {
            return this.value;
        }

        public static Gender fromIntValue(int value) {
            for (Gender g : Gender.values()) {
                if (g.value == value) {
                    return g;
                }
            }
            throw new RuntimeException("非法的gender值");
        }
    }

    public static enum Source {
        PAWPAW(1), WEIXIN(2);
        public final int value;

        Source(int value) {
            this.value = value;
        }


    }

    public static enum Status {
        NORMAL(1), DELETE(2);
        public final int value;

        Status(int value) {
            this.value = value;
        }


    }

    /**
     * 用户类型，真实用户还是虚拟用户
     */

    public static enum Type {
        NORMAL(1), VIRTUAL(2);
        public final int value;

        Type(int value) {
            this.value = value;
        }


    }
}