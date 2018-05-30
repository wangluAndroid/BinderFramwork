// IMyAidlInterface.aidl
package com.zcbl.ssvs.binderframwork;

// Declare any non-default types here with import statements
/**
*  定义语法规范 完全实现java规范
*  模板文件,用来生成java文件
*/
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     * 演示一些基本类型，您可以在AIDL中用作参数和返回值
     */
    void basicTypes(int aInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    //必须是基本数据类型
    /**
     * basicTypes
     * int
     * long
     * double
     * float
     * boolean
     * String
     */
    String getName();
    String setName(String name);
}
