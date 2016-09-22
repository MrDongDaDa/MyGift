package com.androidxx.yangjw.day22_notification_helloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Notification的基本使用
 */
public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        //1、获取NotificationManager对象
        //getSystemService获取系统服务
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //2、创建一个Notification对象
        //创建通知的构建者对象
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);
        //设置图标：如果没有设置图标，则通知不会出现
        builder.setSmallIcon(R.drawable.ic_night_on);
        //设置是否显示时间
        builder.setShowWhen(false);
        //设置标题
        builder.setContentTitle("通知的标题");
        //设置内容
        builder.setContentText("这是通知的内容XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXSSSSSSSSSSSSSS");
        //设置通知的个数
        builder.setNumber(counter++);

        Notification notification = builder.build();
        //3、发送（提交）通知
        //参数1：通知的ID，标识.
        //参数2：Notification对象
        //注意：如果发送多个通知，但是通知的ID一样，则不会显示多条通知；
        // 如果需要显示多条通知，则需要修改ID为不一样
        mNotificationManager.notify(counter,notification);
    }
}
