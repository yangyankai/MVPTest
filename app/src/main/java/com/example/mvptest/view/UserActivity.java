package com.example.mvptest.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvptest.R;
import com.example.mvptest.entity.UserEntity;
import com.example.mvptest.presenter.UserPresenter;


/*******************************************************************************
 * Author  : Yankai
 * Date    : 2016-02-18 17:34
 * Email   : yk_yang@wesugarfree.com
 * Company : 上海无糖运动
 ******************************************************************************/
public class UserActivity extends Activity implements View.OnClickListener, IUserView {

    /** MVC
     *
     Model（模型）是应用程序中用于处理应用程序数据逻辑的部分。
     　　通常模型对象负责在数据库中存取数据。
     View（视图）是应用程序中处理数据显示的部分。
     　　通常视图是依据模型数据创建的。
     Controller（控制器）是应用程序中处理用户交互的部分。
     　　通常控制器负责从视图读取数据，控制用户输入，并向模型发送数据。
     */

    /**
     * MVP
     * MVP 是从经典的模式MVC演变而来，它们的基本思想有相通的地方：
     * Controller/Presenter负责逻辑的处理，Model提供数据，View负责显示。作为一种新的模式，
     * MVP与MVC有着一个重大的区别：在MVP中View并不直接使用Model，它们之间的通信是通过Presenter
     * (MVC中的Controller)来进行的，所有的交互都发生在Presenter内部，而在MVC中View会直接从Model中读取数据而不是通过 Controller。
     * <p>
     * <p>
     * 在MVC里，View是可以直接访问Model的！
     * 从而，View里会包含Model信息，不可避免的还要包括一些业务逻辑。
     * 在MVC模型里，更关注的Model的不变，而同时有多个对Model的不同显示，及View。
     * 所以，在MVC模型里，Model不依赖于View，但是View是依赖于Model的。
     * 不仅如此，因为有一些业务逻辑在View里实现了，
     * 导致要更改View也是比较困难的，至少那些业务逻辑是无法重用的。
     * <p>
     * MVC    Model -> View -> Controller ->Model
     * <p>
     * MVP       View  <->  Presenter  <->   Model
     */

    private UserPresenter presenter;
    private EditText id, first, last;
    private Button buttonSave;
    private Button buttonLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLoad = (Button) findViewById(R.id.save);
        buttonSave = (Button) findViewById(R.id.load);
        id = (EditText) findViewById(R.id.id);
        first = (EditText) findViewById(R.id.first);
        last = (EditText) findViewById(R.id.last);
        presenter = new UserPresenter(this);

        buttonLoad.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                presenter.saveUser(getApplicationContext(),new UserEntity( getFristName(), getLastName()));
                break;
            case R.id.load:
                presenter.loadUser(getApplicationContext(),getID());
                break;
            default:
                break;
        }
    }

    @Override
    public int getID() {
        return new Integer(id.getText().toString());
    }

    @Override
    public String getFristName() {
        return first.getText().toString();
    }

    @Override
    public String getLastName() {
        return last.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        first.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        last.setText(lastName);
    }

}
