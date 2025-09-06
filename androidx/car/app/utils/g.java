package androidx.car.app.utils;

import H7.c;
import I7.k;
import android.os.RemoteException;
import android.util.Log;
import androidx.car.app.IOnDoneCallback;
import androidx.lifecycle.t;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class g {
    public static IOnDoneCallback a() {
        return new RemoteUtils.1(null);
    }

    public static void b(IOnDoneCallback iOnDoneCallback0, String s, a a0) {
        h.a(new k(iOnDoneCallback0, s, a0, 7));
    }

    public static void c(t t0, IOnDoneCallback iOnDoneCallback0, String s, a a0) {
        h.a(new D5.a(t0, iOnDoneCallback0, s, a0));
    }

    public static void d(String s, b b0) {
        try {
            g.e(s, b0);
        }
        catch(RemoteException remoteException0) {
            Log.e("CarApp.Dispatch", "Host unresponsive when dispatching call " + s, remoteException0);
        }
    }

    public static void e(String s, b b0) {
        try {
            if(Log.isLoggable("CarApp", 3)) {
                Log.d("CarApp", "Dispatching call " + s + " to host");
            }
            b0.call();
            return;
        }
        catch(SecurityException securityException0) {
        }
        catch(RuntimeException runtimeException0) {
            throw new M3("Remote " + s + " call failed", runtimeException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        throw securityException0;
    }

    public static void f(IOnDoneCallback iOnDoneCallback0, String s, Exception exception0) {
        g.d((s + " onFailure"), new c(iOnDoneCallback0, exception0, s, 11));
    }

    public static List g(List list0) {
        return list0 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list0));
    }
}

