package com.iloen.melon.utils.log.error;

import A8.b;
import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Debug;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.FileLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.melon.utils.system.DeviceData;
import java.io.File;
import java.io.IOException;

public final class MelonDebug {
    public static final String TAG = "MelonDebug";

    public static String getThrowableStackTrace(Throwable throwable0) {
        StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
        if(arr_stackTraceElement == null) {
            return throwable0.toString();
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < arr_stackTraceElement.length; ++v) {
            stringBuilder0.append(arr_stackTraceElement[v].toString());
            stringBuilder0.append("\n");
        }
        return stringBuilder0.toString();
    }

    public static void handleOutOfMemoryError(OutOfMemoryError outOfMemoryError0) {
        if(b.d()) {
            OomeFileLog.getInstance().write("OOME", "==================================\n" + MelonDebug.getThrowableStackTrace(outOfMemoryError0));
        }
        else {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(FileLog.getPath());
            stringBuilder0.append("/");
            stringBuilder0.append("dump_");
            stringBuilder0.append("20250906_113332");
            stringBuilder0.append(".hprof");
            try {
                Debug.dumpHprofData(FileUtils.getSafetyPath(new File(stringBuilder0.toString())));
            }
            catch(IOException iOException0) {
                LogU.e("MelonDebug", "handleOutOfMemoryError() " + iOException0);
                iOException0.printStackTrace();
            }
        }
        Glide.get(MelonAppBase.instance.getContext()).clearMemory();
        System.gc();
    }

    public static void sendCrashReportToEmail(Thread thread0, Throwable throwable0) {
        StringBuilder stringBuilder0 = new StringBuilder("==============================\nMODEL:");
        stringBuilder0.append(Build.MODEL);
        stringBuilder0.append(", RELEASE:");
        stringBuilder0.append(Build.VERSION.RELEASE);
        stringBuilder0.append(", APPVER:");
        stringBuilder0.append(AppUtils.getVersionName(MelonAppBase.instance.getContext()));
        stringBuilder0.append(", DRM:");
        MelonAppBase.instance.getDeviceData().getClass();
        stringBuilder0.append(DeviceData.d().a);
        stringBuilder0.append(", SKT:");
        stringBuilder0.append(MelonAppBase.instance.getDeviceData().f());
        stringBuilder0.append("\r\n\r\n");
        StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
        stringBuilder0.append(throwable0.toString());
        stringBuilder0.append("\r\n\r\n--------- Stack trace ---------\n\n");
        for(int v = 0; v < arr_stackTraceElement.length; ++v) {
            stringBuilder0.append(arr_stackTraceElement[v].toString());
            stringBuilder0.append("\r\n");
        }
        Throwable throwable1 = throwable0.getCause();
        if(throwable1 != null) {
            stringBuilder0.append("-------------------------------\n\n--------- Cause ---------\n\n");
            stringBuilder0.append(throwable1.toString());
            stringBuilder0.append("\r\n\r\n");
            StackTraceElement[] arr_stackTraceElement1 = throwable1.getStackTrace();
            for(int v1 = 0; v1 < arr_stackTraceElement1.length; ++v1) {
                stringBuilder0.append(arr_stackTraceElement1[v1].toString());
                stringBuilder0.append("\r\n");
            }
        }
        String s = stringBuilder0.toString();
        LogU.e("MelonDebug", s);
        FatalFileLog.getInstance().write("", s);
        Intent intent0 = new Intent("android.intent.action.SEND");
        intent0.setFlags(0x10008000);
        intent0.setType("message/rfc822");
        intent0.putExtra("android.intent.extra.SUBJECT", "MelOn Crash Report");
        intent0.putExtra("android.intent.extra.TEXT", s);
        try {
            PendingIntent.getActivity(MelonAppBase.instance.getContext(), 0, Intent.createChooser(intent0, "Unfortunately MelOn has stopped. Please send email..."), 0x4000000).send();
        }
        catch(PendingIntent.CanceledException unused_ex) {
            Toast.makeText(MelonAppBase.instance.getContext(), "There are no email clients installed.", 1).show();
        }
        System.exit(2);
    }
}

