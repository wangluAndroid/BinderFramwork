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
        //获取本地Binder对象，然后进行返回----->通过Binder驱动，在内核空间中保存Binder本地对象的引用，然后注册到ServiceMananger中，
        //          ServiceMananger中维护着这个Binder本地对象的引用，Client可以通过ServiceManager查找到这个引用，通过Binder驱动来调用到真实
        //          Binder对象中的本地方法；
        //
        return new MyAppImpl(this);
    }




}
