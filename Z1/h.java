package Z1;

import P.z;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Trace;
import androidx.collection.V;
import androidx.collection.u;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class h {
    public static final u a;
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final V d;

    static {
        h.a = new u(16);
        k k0 = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(0, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), k0);
        threadPoolExecutor0.allowCoreThreadTimeOut(true);
        h.b = threadPoolExecutor0;
        h.c = new Object();
        h.d = new V(0);
    }

    public static String a(int v, List list0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            stringBuilder0.append(((d)list0.get(v1)).e);
            stringBuilder0.append("-");
            stringBuilder0.append(v);
            if(v1 < list0.size() - 1) {
                stringBuilder0.append(";");
            }
        }
        return stringBuilder0.toString();
    }

    public static g b(String s, Context context0, List list0, int v) {
        Typeface typeface1;
        List list1;
        u u0 = h.a;
        Trace.beginSection("getFontSync");
        try {
            Typeface typeface0 = (Typeface)u0.get(s);
            if(typeface0 != null) {
                return new g(typeface0);
            }
            try {
                z z0 = c.a(context0, list0);
                list1 = z0.b;
                switch(z0.a) {
                    case 0: {
                        goto label_19;
                    }
                    case 1: {
                        goto label_35;
                    }
                }
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                return new g(-1);
            }
            int v2 = -3;
            goto label_36;
        label_19:
            i[] arr_i = (i[])list1.get(0);
            if(arr_i == null || arr_i.length == 0) {
                v2 = 1;
                goto label_36;
            label_35:
                v2 = -2;
            }
            else {
                v2 = 0;
                for(int v3 = 0; v3 < arr_i.length; ++v3) {
                    int v4 = arr_i[v3].e;
                    if(v4 != 0) {
                        if(v4 >= 0) {
                            v2 = v4;
                            break;
                        }
                        v2 = -3;
                        break;
                    }
                }
            }
        label_36:
            if(v2 != 0) {
                return new g(v2);
            }
            if(list1.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                i[] arr_i1 = (i[])list1.get(0);
                Trace.beginSection("TypefaceCompat.createFromFontInfo");
                try {
                    typeface1 = S1.g.a.p(context0, arr_i1, v);
                }
                catch(Throwable throwable1) {
                    Trace.endSection();
                    throw throwable1;
                }
            }
            else {
                Trace.beginSection("TypefaceCompat.createFromFontInfoWithFallback");
                try {
                    typeface1 = S1.g.a.q(context0, list1, v);
                }
                catch(Throwable throwable0) {
                    Trace.endSection();
                    throw throwable0;
                }
            }
            Trace.endSection();
            if(typeface1 != null) {
                u0.put(s, typeface1);
                return new g(typeface1);
            }
            return new g(-3);
        }
        finally {
            Trace.endSection();
        }
    }
}

