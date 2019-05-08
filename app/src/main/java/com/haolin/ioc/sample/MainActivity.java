package com.haolin.ioc.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.haolin.ioclibrary.annotation.ContentView;
import com.haolin.ioclibrary.annotation.InjectView;
import com.haolin.ioclibrary.annotation.OnClick;
import com.haolin.ioclibrary.annotation.OnLongClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @InjectView(R.id.tv)
    private TextView tv;
    @InjectView(R.id.btn)
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

    }

    @OnClick({R.id.tv, R.id.btn})
    public void onClickView(View view) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
    }
    @OnLongClick({R.id.tv, R.id.btn})
    public Boolean onLongClick(View view) {
        Toast.makeText(this, "长按事件", Toast.LENGTH_SHORT).show();
        return true;
    }

//    @OnClick({R.id.tv, R.id.btn})
//    public void onClickView() {
//
//        Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
//    }

}
