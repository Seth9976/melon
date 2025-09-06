package e7;

import A1.g;
import A7.d;
import P0.d0;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import d5.c;
import h7.T;
import h7.U;
import h7.V;
import h7.X;
import h7.b0;
import h7.c0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import o9.b;

public final class p {
    public final Context a;
    public final u b;
    public final d0 c;
    public final c d;
    public final g e;
    public static final HashMap f;
    public static final String g;

    static {
        HashMap hashMap0 = new HashMap();
        p.f = hashMap0;
        d.r(5, hashMap0, "armeabi", 6, "armeabi-v7a");
        d.r(9, hashMap0, "arm64-v8a", 0, "x86");
        hashMap0.put("x86_64", 1);
        p.g = "Crashlytics Android SDK/19.4.4";
    }

    public p(Context context0, u u0, d0 d00, c c0, g g0) {
        this.a = context0;
        this.b = u0;
        this.c = d00;
        this.d = c0;
        this.e = g0;
    }

    public final List a() {
        d0 d00 = this.c;
        String s = (String)d00.f;
        if(s == null) {
            throw new NullPointerException("Null name");
        }
        return Collections.singletonList(new T(0L, s, ((String)d00.c), 0L));
    }

    public final c0 b(int v) {
        int v4;
        Float float0;
        boolean z1;
        Double double0;
        boolean z;
        Context context0;
        try {
            context0 = this.a;
            z = false;
            double0 = null;
            Intent intent0 = context0.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if(intent0 == null) {
                z1 = false;
                goto label_25;
            }
            else {
                int v1 = intent0.getIntExtra("status", -1);
                if(v1 == -1) {
                    z1 = false;
                }
                else if(v1 == 2 || v1 == 5) {
                    z1 = true;
                }
                else {
                    z1 = false;
                }
                try {
                    int v2 = intent0.getIntExtra("level", -1);
                    int v3 = intent0.getIntExtra("scale", -1);
                    if(v2 == -1 || v3 == -1) {
                        goto label_25;
                    }
                    else {
                        float0 = (float)(((float)v2) / ((float)v3));
                    }
                }
                catch(IllegalStateException illegalStateException0) {
                    goto label_24;
                }
            }
            goto label_26;
        }
        catch(IllegalStateException illegalStateException0) {
            z1 = false;
        }
    label_24:
        Log.e("FirebaseCrashlytics", "An error occurred getting battery state.", illegalStateException0);
    label_25:
        float0 = null;
    label_26:
        if(float0 != null) {
            double0 = float0.doubleValue();
        }
        if(!z1 || float0 == null) {
            v4 = 1;
        }
        else if(((double)(((float)float0))) < 0.99) {
            v4 = 2;
        }
        else {
            v4 = 3;
        }
        if(!f.f() && ((SensorManager)context0.getSystemService("sensor")).getDefaultSensor(8) != null) {
            z = true;
        }
        long v5 = f.a(context0);
        ActivityManager.MemoryInfo activityManager$MemoryInfo0 = new ActivityManager.MemoryInfo();
        ((ActivityManager)context0.getSystemService("activity")).getMemoryInfo(activityManager$MemoryInfo0);
        long v6 = v5 - activityManager$MemoryInfo0.availMem > 0L ? v5 - activityManager$MemoryInfo0.availMem : 0L;
        StatFs statFs0 = new StatFs(Environment.getDataDirectory().getPath());
        long v7 = (long)statFs0.getBlockSize();
        long v8 = ((long)statFs0.getBlockCount()) * v7 - v7 * ((long)statFs0.getAvailableBlocks());
        b0 b00 = new b0();  // 初始化器: Ljava/lang/Object;-><init>()V
        b00.a = double0;
        b00.b = v4;
        b00.c = z;
        b00.d = v;
        b00.e = v6;
        b00.f = v8;
        b00.g = (byte)(((byte)(((byte)(((byte)(((byte)(b00.g | 1)) | 2)) | 4)) | 8)) | 16);
        return b00.a();
    }

    public static U c(b b0, int v) {
        String s = (String)b0.b;
        String s1 = (String)b0.a;
        StackTraceElement[] arr_stackTraceElement = (StackTraceElement[])b0.c;
        int v1 = 0;
        if(arr_stackTraceElement == null) {
            arr_stackTraceElement = new StackTraceElement[0];
        }
        b b1 = (b)b0.d;
        if(v >= 8) {
            b b2 = b1;
            while(b2 != null) {
                b2 = (b)b2.d;
                ++v1;
            }
        }
        U u0 = null;
        List list0 = p.d(arr_stackTraceElement, 4);
        if(list0 == null) {
            throw new NullPointerException("Null frames");
        }
        if(b1 != null && v1 == 0) {
            u0 = p.c(b1, v + 1);
        }
        return new U(s, s1, list0, u0, v1);
    }

    public static List d(StackTraceElement[] arr_stackTraceElement, int v) {
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < arr_stackTraceElement.length; ++v1) {
            StackTraceElement stackTraceElement0 = arr_stackTraceElement[v1];
            X x0 = new X();  // 初始化器: Ljava/lang/Object;-><init>()V
            x0.e = v;
            x0.f = (byte)(x0.f | 4);
            long v2 = 0L;
            long v3 = stackTraceElement0.isNativeMethod() ? Math.max(stackTraceElement0.getLineNumber(), 0L) : 0L;
            String s = stackTraceElement0.getClassName() + "." + stackTraceElement0.getMethodName();
            String s1 = stackTraceElement0.getFileName();
            if(!stackTraceElement0.isNativeMethod() && stackTraceElement0.getLineNumber() > 0) {
                v2 = (long)stackTraceElement0.getLineNumber();
            }
            x0.a = v3;
            byte b = (byte)(x0.f | 1);
            x0.f = b;
            if(s == null) {
                throw new NullPointerException("Null symbol");
            }
            x0.b = s;
            x0.c = s1;
            x0.d = v2;
            x0.f = (byte)(b | 2);
            arrayList0.add(x0.a());
        }
        return Collections.unmodifiableList(arrayList0);
    }

    public static V e() {
        return new V("0", "0", 0L);
    }
}

