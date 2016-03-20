package com.example.mvptest.model;


import android.content.Context;

import com.example.mvptest.entity.UserEntity;

/*******************************************************************************
 * Author  : Yankai
 * Date    : 2016-02-18 17:33
 * Email   : yk_yang@wesugarfree.com
 * Company : 上海无糖运动
 ******************************************************************************/
public interface IUserModel {
    void setID(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setUser(Context context,UserEntity user);
    int getID();

    UserEntity load(Context context, int id);// 通过id读取user信息,返回一个UserBean
}

