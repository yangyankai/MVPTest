package com.example.mvptest.presenter;


import android.content.Context;

import com.example.mvptest.entity.UserEntity;
import com.example.mvptest.model.IUserModel;
import com.example.mvptest.model.UserModel;
import com.example.mvptest.view.IUserView;

/*******************************************************************************
 * Author  : Yankai
 * Date    : 2016-02-18 17:34
 * Email   : yk_yang@wesugarfree.com
 * Company : 上海无糖运动
 ******************************************************************************/
public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view) {
        mUserView = view;
        mUserModel = new UserModel();
    }

    public void saveUser(Context context,UserEntity user) {
        mUserModel.setUser(context,user);
    }

    public void loadUser(Context context, int id) {
        UserEntity user = mUserModel.load(context,id);
        mUserView.setFirstName(user.getFirstName()); // 通过调用IUserView的方法来更新显示
        mUserView.setLastName(user.getLastName());
    }
}
