package b7;

import Gd.e;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import h7.D0;
import h7.Z;
import h7.a0;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import kotlin.jvm.internal.q;

public final class c {
    public static final c a;
    public static final c b;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public boolean a(int v) {
        return 4 <= v || Log.isLoggable("FirebaseCrashlytics", v);
    }

    public void b(String s) {
        if(this.a(3)) {
            Log.d("FirebaseCrashlytics", s, null);
        }
    }

    public static ArrayList c(Context context0) {
        q.g(context0, "context");
        int v = context0.getApplicationInfo().uid;
        String s = context0.getApplicationInfo().processName;
        Object object0 = context0.getSystemService("activity");
        List list0 = null;
        ActivityManager activityManager0 = object0 instanceof ActivityManager ? ((ActivityManager)object0) : null;
        if(activityManager0 != null) {
            list0 = activityManager0.getRunningAppProcesses();
        }
        if(list0 == null) {
            list0 = w.a;
        }
        ArrayList arrayList0 = p.i0(list0);
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            if(((ActivityManager.RunningAppProcessInfo)object1).uid == v) {
                arrayList1.add(object1);
            }
        }
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
        for(Object object2: arrayList1) {
            Z z0 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
            String s1 = ((ActivityManager.RunningAppProcessInfo)object2).processName;
            if(s1 == null) {
                throw new NullPointerException("Null processName");
            }
            z0.a = s1;
            z0.b = ((ActivityManager.RunningAppProcessInfo)object2).pid;
            int v1 = (byte)(z0.e | 1);
            z0.c = ((ActivityManager.RunningAppProcessInfo)object2).importance;
            z0.e = (byte)(v1 | 2);
            z0.d = q.b(s1, s);
            z0.e = (byte)(z0.e | 4);
            arrayList2.add(z0.a());
        }
        return arrayList2;
    }

    public D0 d(Context context0) {
        String s;
        Object object0 = null;
        q.g(context0, "context");
        int v = Process.myPid();
        for(Object object1: c.c(context0)) {
            if(((a0)(((D0)object1))).b == v) {
                object0 = object1;
                break;
            }
        }
        if(((D0)object0) == null) {
            int v1 = Build.VERSION.SDK_INT;
            if(v1 > 33) {
                s = e.t();
                q.f(s, "{\n      Process.myProcessName()\n    }");
            }
            else if(v1 >= 28) {
                s = Application.getProcessName();
                if(s == null) {
                    s = "";
                }
            }
            else {
                s = "";
            }
            q.g(s, "processName");
            Z z0 = new Z();  // 初始化器: Ljava/lang/Object;-><init>()V
            z0.a = s;
            z0.b = v;
            z0.c = 0;
            z0.d = false;
            z0.e = (byte)(((byte)(((byte)(z0.e | 1)) | 2)) | 4);
            return z0.a();
        }
        return (D0)object0;
    }

    public void e(String s) {
        if(this.a(2)) {
            Log.v("FirebaseCrashlytics", s, null);
        }
    }

    public void f(String s, Exception exception0) {
        if(this.a(5)) {
            Log.w("FirebaseCrashlytics", s, exception0);
        }
    }
}

