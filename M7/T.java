package M7;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import kotlin.jvm.internal.q;

public abstract class t {
    public static final u a;
    public static final u b;

    static {
        t.a = new u(0);
        t.b = new u(1);
    }

    public static ArrayList a(Context context0) {
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
            String s1 = ((ActivityManager.RunningAppProcessInfo)object2).processName;
            q.f(s1, "runningAppProcessInfo.processName");
            arrayList2.add(new D(s1, ((ActivityManager.RunningAppProcessInfo)object2).pid, ((ActivityManager.RunningAppProcessInfo)object2).importance, q.b(((ActivityManager.RunningAppProcessInfo)object2).processName, s)));
        }
        return arrayList2;
    }
}

