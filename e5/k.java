package e5;

import U4.F;
import U4.a;
import U4.w;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.internal.q;

public abstract class k {
    public static final String a;

    // 去混淆评级： 低(20)
    static {
        q.f("WM-ProcessUtils", "tagWithPrefix(\"ProcessUtils\")");
        k.a = "WM-ProcessUtils";
    }

    public static final boolean a(Context context0, a a0) {
        String s;
        q.g(context0, "context");
        q.g(a0, "configuration");
        if(Build.VERSION.SDK_INT >= 28) {
            return q.b(e5.a.a(), context0.getApplicationInfo().processName);
        }
        try {
            s = null;
            Method method0 = Class.forName("android.app.ActivityThread", false, F.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            method0.setAccessible(true);
            Object object0 = method0.invoke(null, null);
            q.d(object0);
            if(object0 instanceof String) {
                return q.b(((String)object0), context0.getApplicationInfo().processName);
            }
        }
        catch(Throwable throwable0) {
            w.e().b("WM-ProcessUtils", "Unable to check ActivityThread for processName", throwable0);
        }
        int v = Process.myPid();
        Object object1 = context0.getSystemService("activity");
        q.e(object1, "null cannot be cast to non-null type android.app.ActivityManager");
        List list0 = ((ActivityManager)object1).getRunningAppProcesses();
        if(list0 != null) {
            Object object2 = null;
            for(Object object3: list0) {
                if(((ActivityManager.RunningAppProcessInfo)object3).pid == v) {
                    object2 = object3;
                    break;
                }
            }
            if(((ActivityManager.RunningAppProcessInfo)object2) != null) {
                s = ((ActivityManager.RunningAppProcessInfo)object2).processName;
            }
        }
        return q.b(s, context0.getApplicationInfo().processName);
    }
}

