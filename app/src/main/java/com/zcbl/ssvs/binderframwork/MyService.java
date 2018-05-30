package com.zcbl.ssvs.binderframwork;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by serenitynanian on 2018/5/25.
 * 进程间通信：被访问者一定是Sevice，因为只有Service里面才有Binder对象
 */

public class MyService extends Service {

    /**
     * 提供给客户端
     * @param intent
     * @return Server返回值是什么，Client就拿到什么
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {



        IMyAidlInterface myAidlInterface ;
        return new MyAppImpl(this);
    }




}
