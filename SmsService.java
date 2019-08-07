package com.cdhgold.shop.sender;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
public class SmsService extends Service {

    private String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private IBinder mIBinder = new MyBinder();
    private BroadcastReceiver mReceiver;
    class MyBinder extends Binder{
        SmsService getService(){
            return SmsService.this; // 서비스 객체를 리턴
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("LOG", "onBind()");
        return mIBinder;
    }

    @Override
    public void onCreate() {
        Log.e("LOG", "onCreate()");
        super.onCreate();
        IntentFilter filter = new IntentFilter(SMS_RECEIVED);
        filter.addAction(SMS_RECEIVED);
        mReceiver = new SmsReceiver();
        registerReceiver(mReceiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("LOG", "서비스 시작 onStartCommand()");
        IntentFilter filter = new IntentFilter(SMS_RECEIVED);
        filter.addAction(SMS_RECEIVED);
        mReceiver = new SmsReceiver();
        registerReceiver(mReceiver, filter);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("LOG", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("LOG", "onUnbind()");
        return super.onUnbind(intent);
    }

}
