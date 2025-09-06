package com.iloen.melon.utils.log.error;

import Q1.c;
import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.EnvironmentUtils;
import va.e;

public class ErrorReportManager {
    static class Holder {
        public static final ErrorReportManager a;

        static {
            ErrorReportManager errorReportManager0 = new ErrorReportManager();  // 初始化器: Ljava/lang/Object;-><init>()V
            errorReportManager0.c = new com.iloen.melon.utils.log.error.ErrorReportManager.1(errorReportManager0);
            errorReportManager0.a = MelonAppBase.instance.getContext();
            Holder.a = errorReportManager0;
        }
    }

    public static final String EXTRA_CRASH_REPORT = "extraCrashReport";
    public Context a;
    public Handler b;
    public Handler.Callback c;

    public void cancelForceError() {
        if(this.b != null && this.b.hasMessages(99)) {
            this.b.removeMessages(99);
        }
    }

    public void forceError(long v) {
        if(this.b == null) {
            this.b = new Handler(Looper.myLooper(), this.c);
        }
        if(this.b.hasMessages(99)) {
            this.b.removeMessages(99);
        }
        this.b.sendEmptyMessageDelayed(99, v);
    }

    public static ErrorReportManager getInstance() {
        return Holder.a;
    }

    public static String getStackTraceInfoFrom(Throwable throwable0) {
        if(throwable0 == null) {
            return "";
        }
        StringBuilder stringBuilder0 = new StringBuilder("---------- Stack trace ----------\r\n");
        StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
        for(int v1 = 0; v1 < arr_stackTraceElement.length; ++v1) {
            stringBuilder0.append(arr_stackTraceElement[v1].toString());
            stringBuilder0.append("\r\n");
        }
        Throwable throwable1 = throwable0.getCause();
        if(throwable1 != null) {
            stringBuilder0.append("\r\n---------- Cause ----------\r\n");
            stringBuilder0.append(throwable1.toString());
            stringBuilder0.append("\r\n\r\n");
            StackTraceElement[] arr_stackTraceElement1 = throwable1.getStackTrace();
            for(int v = 0; v < arr_stackTraceElement1.length; ++v) {
                stringBuilder0.append(arr_stackTraceElement1[v].toString());
                stringBuilder0.append("\r\n");
            }
            return stringBuilder0.toString();
        }
        stringBuilder0.append("\r\n---------- Cause ----------\r\n");
        stringBuilder0.append(throwable0.getMessage());
        return stringBuilder0.toString();
    }

    public void sendExceptionReport(Thread thread0, Throwable throwable0) {
        String s = e.c(("---------- Environment ----------\r\n" + EnvironmentUtils.getEnvironmentInfo(MelonAppBase.instance.getContext())), "\r\n\r\n", ErrorReportManager.getStackTraceInfoFrom(throwable0));
        if(!TextUtils.isEmpty(s)) {
            try {
                Intent intent0 = new Intent();
                c.Y(intent0, "com.iloen.melon.ERROR_REPORT", true);
                intent0.putExtra("extraCrashReport", s);
                intent0.setFlags(0x10008000);
                PendingIntent.getActivity(this.a, 0, intent0, 0x4000000).send();
            }
            catch(PendingIntent.CanceledException unused_ex) {
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(2);
    }

    class com.iloen.melon.utils.log.error.ErrorReportManager.1 implements Handler.Callback {
        public final ErrorReportManager a;

        public com.iloen.melon.utils.log.error.ErrorReportManager.1() {
            this.a = errorReportManager0;
        }

        @Override  // android.os.Handler$Callback
        public boolean handleMessage(Message message0) {
            if(message0.what != 99) {
                return false;
            }
            this.a.getClass();
            throw new RuntimeException("FORCE ERROR !!");
        }
    }

}

