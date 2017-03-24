package io.virtualapp.my;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lody.virtual.client.core.VirtualCore;

import java.util.ArrayList;
import java.util.List;

import io.virtualapp.R;
import io.virtualapp.VCommends;
import io.virtualapp.abs.ui.VActivity;
import io.virtualapp.home.models.AppInfo;
import io.virtualapp.home.models.AppInfoLite;

/**
 * 717219917@qq.com  2017/3/24 15:02
 */

public class MainActivity extends VActivity {
    EditText my__main_package,my__main_path;
    Button my__main_btn1,my__main_btn2;
    String mPackage,mPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my__activity_main);
        initView();
    }

    private void initView(){
        my__main_package =(EditText)findViewById(R.id.my__main_edit1);
        my__main_path =(EditText)findViewById(R.id.my__main_edit2);

        my__main_btn1 =(Button) findViewById(R.id.my__main_btn1);
        my__main_btn2 =(Button) findViewById(R.id.my__main_btn2);
        my__main_package.setText("com.test.test");
        my__main_path.setText(Environment.getExternalStorageDirectory()+"/");
        initData();


    }

    private void initData(){
        my__main_btn1.setOnClickListener(v -> {
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
        });

        my__main_btn2.setOnClickListener(v -> {
            ArrayList dataList = new ArrayList<AppInfoLite>(1);
            dataList.add(new AppInfoLite(mPackage,mPath, true));

            Intent data = new Intent();
            data.putParcelableArrayListExtra(VCommends.EXTRA_APP_INFO_LIST, dataList);
            getActivity().setResult(Activity.RESULT_OK, data);

//            getActivity().finish();
        });
    }

}
