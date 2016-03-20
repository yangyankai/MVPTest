package com.example.mvptest.entity;

/*******************************************************************************
 * Author  : Yankai
 * Date    : 2016-02-18 17:32
 * Email   : yk_yang@wesugarfree.com
 * Company : 上海无糖运动
 ******************************************************************************/
public class UserEntity {
    private String mFirstName;
    private String mLastName;

    public UserEntity(String firstName, String lastName) {
        this. mFirstName = firstName;
        this. mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }
}
