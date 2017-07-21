package com.example.administrator.my_ali_im;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.wxlib.util.SysUtil;
import com.example.administrator.my_ali_im.IMsample.InitHelper;


/**
 * 项目：OkHttp_Retrofit
 * 作者：nbcei
 * 时间：2017/7/4
 * 功能：
 */

public class MyApplication extends Application{

    /***
     * 经常使用的对象在MyApplication中初始化
     */
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

//todo Application.onCreate中，首先执行这部分代码，以下代码固定在此处，不要改动，这里return是为了退出Application.onCreate！！！
        if(mustRunFirstInsideApplicationOnCreate()){
            //todo 如果在":TCMSSevice"进程中，无需进行openIM和app业务的初始化，以节省内存
            return;
        }

        //初始化云旺SDK
        InitHelper.initYWSDK(this);

        //初始化反馈功能(未使用反馈功能的用户无需调用该初始化)

        InitHelper.initFeedBack(this);





    }
    public static  Context getContext(){
        return context;
    }



    private boolean mustRunFirstInsideApplicationOnCreate() {
        //必须的初始化
        SysUtil.setApplication(this);

        return SysUtil.isTCMSServiceProcess(context);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
