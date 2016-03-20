package com.example.mvptest.model;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mvptest.entity.UserEntity;

/*******************************************************************************
 * Author  : Yankai
 * Date    : 2016-02-18 17:33
 * Email   : yk_yang@wesugarfree.com
 * Company : 上海无糖运动
 ******************************************************************************/
public class UserModel implements IUserModel {
    UserEntity userBean;

    @Override
    public void setID(int id) {

    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public void setUser(Context context, UserEntity user) {
        Log.e("mvp", " " + user.getFirstName() + ":" + user.getLastName());

        //打开或创建test.db数据库
        SQLiteDatabase db = context.openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS person");

        //创建person表
        db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, firstName VARCHAR, lastName VARCHAR)");
        //插入数据
        db.execSQL("INSERT INTO person VALUES (NULL, ?, ?)", new Object[]{user.getFirstName(), user.getLastName()});
        db.close();

    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public UserEntity load(Context context, int id) {


        //打开或创建test.db数据库
        SQLiteDatabase db = context.openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);

        Cursor c = db.rawQuery("SELECT * FROM person WHERE _id = ?", new String[]{"" + id});
        while (c.moveToNext()) {
            int _id = c.getInt(c.getColumnIndex("_id"));
            String name = c.getString(c.getColumnIndex("firstName"));
            String lastName = c.getString(c.getColumnIndex("lastName"));
            Log.i("db", "_id=>" + _id + ", name=>" + name);
            UserEntity user = new UserEntity(name, lastName);
            return user;
        }
        c.close();
        db.close();
        return null;
    }
}
