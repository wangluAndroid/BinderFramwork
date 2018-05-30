package com.zcbl.ssvs.otherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zcbl.ssvs.binderframwork.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void textview(View view) {
        Log.e(TAG, "textview: client调用远端进程服务");
        Intent intent = new Intent();
        intent.setAction("com.zcbl.ssvs.binderframwork.MyService");
        intent.setPackage("com.zcbl.ssvs.binderframwork");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                //将Binder引用转换为远端引用(也就是app中的IMyAidlInterface）
                //asInterface()返回的是一个Proxy  IMyAidlInterface是Proxy的父类
                IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
                try {
                    //修改远端Server进程中的name属性
                    iMyAidlInterface.setName("ANDROID");

                    //打印远端Server进程中的name属性，如果打印出来，说明跨进程通信（修改远端Server中的属性，获取属性）成功
                    Log.e(TAG, "onServiceConnected: "+iMyAidlInterface.getName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }
}
