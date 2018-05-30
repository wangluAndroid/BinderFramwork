package com.zcbl.ssvs.binderframwork;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by serenitynanian on 2018/5/25.
 * 这个Stub是IMyAidlInterface接口静态内部类，实现了IMyAidlInterface implements IInterface接口（IMyAidlInterface这个接口是client与server调用的接口规范），
 *          来表明远程Server具有的能力（提供哪些方法（功能））----->供Client使用的能力；
 *          Stub是一个抽象类，具体的IInterface的相关实现需要我们手动完成，这里使用了策略模式；
 */

public  class MyAppImpl extends IMyAidlInterface.Stub{

    private String name ;

    private Context context ;
    public MyAppImpl(Context context) {
        this.context = context ;
    }

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public String getName() throws RemoteException {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        return name;
    }

    @Override
    public String setName(String name) throws RemoteException {
        this.name = name ;
        Log.e("TAG", "setName: ");
        return "";
    }
}
