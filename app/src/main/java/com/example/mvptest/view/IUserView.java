package com.example.mvptest.view;

/*******************************************************************************
 * Author  : Yankai
 * Date    : 2016-02-18 17:34
 * Email   : yk_yang@wesugarfree.com
 * Company : 上海无糖运动
 ******************************************************************************/
public interface IUserView {
    int getID();

    String getFristName();

    String getLastName();

    void setFirstName(String firstName);

    void setLastName(String lastName);
}
