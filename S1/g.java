package S1;

import A3.m;
import R1.a;
import R1.c;
import Z1.d;
import Z1.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import androidx.collection.V;
import androidx.collection.u;
import d5.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import jeb.synthetic.FIN;

public abstract class g {
    public static final f a;
    public static final u b;

    static {
        Trace.beginSection("TypefaceCompat static init");
        int v = Build.VERSION.SDK_INT;
        if(v >= 29) {
            g.a = new j();  // 初始化器: Ld5/f;-><init>()V
        }
        else if(v >= 28) {
            g.a = new i();  // 初始化器: LS1/h;-><init>()V
        }
        else {
            g.a = new h();
        }
        g.b = new u(16);
        Trace.endSection();
    }

    public static Typeface a(Context context0, c c0, Resources resources0, int v, String s, int v1, int v2, a a0, boolean z) {
        Typeface typeface4;
        Object object5;
        Future future0;
        List list0;
        boolean z1;
        Typeface typeface1;
        if(c0 instanceof R1.f) {
            String s1 = ((R1.f)c0).e;
            Typeface typeface0 = null;
            if(s1 == null || s1.isEmpty()) {
                typeface1 = null;
            }
            else {
                typeface1 = Typeface.create(s1, 0);
                if(typeface1 == null || typeface1.equals(Typeface.create(Typeface.DEFAULT, 0))) {
                    typeface1 = null;
                }
            }
            if(typeface1 != null) {
                if(a0 != null) {
                    new Handler(Looper.getMainLooper()).post(new m(3, a0, typeface1));
                }
                return typeface1;
            }
            if(!z) {
                z1 = a0 == null;
            }
            else if(((R1.f)c0).d == 0) {
                z1 = true;
            }
            else {
                z1 = false;
            }
            int v3 = z ? ((R1.f)c0).c : -1;
            Handler handler0 = new Handler(Looper.getMainLooper());
            I7.c c1 = new I7.c(20, false);
            c1.b = a0;
            d d0 = ((R1.f)c0).b;
            if(d0 == null) {
                ArrayList arrayList1 = new ArrayList(1);
                Object object1 = new Object[]{((R1.f)c0).a}[0];
                Objects.requireNonNull(object1);
                arrayList1.add(object1);
                list0 = Collections.unmodifiableList(arrayList1);
            }
            else {
                Object[] arr_object = {((R1.f)c0).a, d0};
                ArrayList arrayList0 = new ArrayList(2);
                for(int v4 = 0; v4 < 2; ++v4) {
                    Object object0 = arr_object[v4];
                    Objects.requireNonNull(object0);
                    arrayList0.add(object0);
                }
                list0 = Collections.unmodifiableList(arrayList0);
            }
            Y1.d d1 = new Y1.d(handler0, 1);
            E9.g g0 = new E9.g(c1, d1);
            if(z1) {
                if(list0.size() > 1) {
                    throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
                }
                Object object2 = list0.get(0);
                ArrayList arrayList2 = new ArrayList(1);
                Object object3 = new Object[]{((d)object2)}[0];
                Objects.requireNonNull(object3);
                arrayList2.add(object3);
                String s2 = Z1.h.a(v2, Collections.unmodifiableList(arrayList2));
                Typeface typeface2 = (Typeface)Z1.h.a.get(s2);
                if(typeface2 != null) {
                    d1.execute(new M6.u(7, c1, typeface2));
                    typeface0 = typeface2;
                }
                else if(v3 == -1) {
                    ArrayList arrayList3 = new ArrayList(1);
                    Object object4 = new Object[]{((d)object2)}[0];
                    Objects.requireNonNull(object4);
                    arrayList3.add(object4);
                    Z1.g g1 = Z1.h.b(s2, context0, Collections.unmodifiableList(arrayList3), v2);
                    g0.y(g1);
                    typeface0 = g1.a;
                }
                else {
                    e e0 = new e(s2, context0, ((d)object2), v2, 0);
                    try {
                        future0 = Z1.h.b.submit(e0);
                    }
                    catch(InterruptedException unused_ex) {
                        goto label_77;
                    }
                    try {
                        object5 = future0.get(((long)v3), TimeUnit.MILLISECONDS);
                        goto label_74;
                    }
                    catch(ExecutionException executionException0) {
                    }
                    catch(InterruptedException interruptedException0) {
                        throw interruptedException0;
                    }
                    catch(TimeoutException unused_ex) {
                        goto label_77;
                    }
                    try {
                        throw new RuntimeException(executionException0);
                    label_74:
                        g0.y(((Z1.g)object5));
                        typeface0 = ((Z1.g)object5).a;
                    }
                    catch(InterruptedException unused_ex) {
                    label_77:
                        ((Y1.d)g0.b).execute(new Z1.a(((I7.c)g0.a), -3, 0));
                    }
                }
            }
            else {
                String s3 = Z1.h.a(v2, list0);
                Typeface typeface3 = (Typeface)Z1.h.a.get(s3);
                if(typeface3 == null) {
                    Z1.f f0 = new Z1.f(g0, 0);
                    Object object6 = Z1.h.c;
                    __monitor_enter(object6);
                    int v5 = FIN.finallyOpen$NT();
                    V v6 = Z1.h.d;
                    ArrayList arrayList4 = (ArrayList)v6.get(s3);
                    if(arrayList4 == null) {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(f0);
                        v6.put(s3, arrayList5);
                        FIN.finallyCodeBegin$NT(v5);
                        __monitor_exit(object6);
                        FIN.finallyCodeEnd$NT(v5);
                        e e1 = new e(s3, context0, list0, v2, 1);
                        Z1.f f1 = new Z1.f(s3, 1);
                        Handler handler1 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                        X4.d d2 = new X4.d();
                        d2.b = e1;
                        d2.c = f1;
                        d2.d = handler1;
                        Z1.h.b.execute(d2);
                    }
                    else {
                        arrayList4.add(f0);
                        FIN.finallyExec$NT(v5);
                    }
                }
                else {
                    d1.execute(new M6.u(7, c1, typeface3));
                    typeface0 = typeface3;
                }
            }
            typeface4 = typeface0;
        }
        else {
            typeface4 = g.a.o(context0, ((R1.d)c0), resources0, v2);
            if(a0 != null) {
                if(typeface4 == null) {
                    a0.a(-3);
                }
                else {
                    new Handler(Looper.getMainLooper()).post(new m(3, a0, typeface4));
                }
            }
        }
        if(typeface4 != null) {
            String s4 = g.b(resources0, v, s, v1, v2);
            g.b.put(s4, typeface4);
        }
        return typeface4;
    }

    public static String b(Resources resources0, int v, String s, int v1, int v2) {
        return resources0.getResourcePackageName(v) + '-' + s + '-' + v1 + '-' + v + '-' + v2;
    }
}

