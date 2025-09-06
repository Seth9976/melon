package i.n.i.b.a.s.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.z;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class rc {
    public int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public static rc e;
    public static final byte[] f;

    static {
        rc.f = new byte[0];
    }

    public rc(int v, Object object0, Object object1, Object[] arr_object) {
        this.b = object0;
        this.c = object1;
        this.d = arr_object;
        this.a = v;
        super();
    }

    public rc(int v, String s, Map map0, byte[] arr_b) {
        this.b = s;
        this.a = v;
        this.c = map0;
        this.d = arr_b;
    }

    public rc(Context context0) {
        this.b = new Handler(Looper.getMainLooper());
        this.c = new CopyOnWriteArrayList();
        this.d = new Object();
        this.a = 0;
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context0.registerReceiver(new z(this, 5), intentFilter0);
    }

    public String a(long v, String s, int v1, long v2) {
        int v4;
        String[] arr_s = (String[])this.b;
        String[] arr_s1 = (String[])this.d;
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v3 = 0; true; ++v3) {
            v4 = this.a;
            if(v3 >= v4) {
                break;
            }
            stringBuilder0.append(arr_s[v3]);
            int v5 = ((int[])this.c)[v3];
            if(v5 == 1) {
                stringBuilder0.append(s);
            }
            else {
                switch(v5) {
                    case 2: {
                        stringBuilder0.append(String.format(Locale.US, arr_s1[v3], v));
                        break;
                    }
                    case 3: {
                        stringBuilder0.append(String.format(Locale.US, arr_s1[v3], v1));
                        break;
                    }
                    case 4: {
                        stringBuilder0.append(String.format(Locale.US, arr_s1[v3], v2));
                    }
                }
            }
        }
        stringBuilder0.append(arr_s[v4]);
        return stringBuilder0.toString();
    }

    public static void b(rc rc0, int v) {
        synchronized(rc0.d) {
            if(rc0.a == v) {
                return;
            }
            rc0.a = v;
        }
        for(Object object1: ((CopyOnWriteArrayList)rc0.c)) {
            WeakReference weakReference0 = (WeakReference)object1;
            k4 k40 = (k4)weakReference0.get();
            if(k40 == null) {
                ((CopyOnWriteArrayList)rc0.c).remove(weakReference0);
            }
            else {
                k40.a(v);
            }
        }
    }

    public static rc c(Context context0) {
        synchronized(rc.class) {
            if(rc.e == null) {
                rc.e = new rc(context0);
            }
            return rc.e;
        }
    }
}

