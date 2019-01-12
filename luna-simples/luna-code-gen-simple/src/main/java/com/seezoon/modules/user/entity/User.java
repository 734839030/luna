package com.seezoon.modules.user.entity;

import com.seezoon.luna.entity.BaseEntity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
/**
 * 用户信息
 * Copyright &copy; 2018 powered by huangdf, All rights reserved.
 * @author hdf 2019-1-12 19:03:37
 */
public class User extends BaseEntity {

   private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @NotNull
    @Length(min = 1, max = 30)
    private String name;
    /**
     * 
     */
    private Integer age;
    /**
     * 
     */
    private Date birthday;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
}