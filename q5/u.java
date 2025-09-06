package Q5;

import V5.c;
import W5.h;
import W5.j;
import Z5.a;
import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;

public final class u {
    public final a a;
    public final a b;
    public final c c;
    public final h d;
    public static volatile l e;

    public u(a a0, a a1, c c0, h h0, j j0) {
        this.a = a0;
        this.b = a1;
        this.c = c0;
        this.d = h0;
        A3.l l0 = new A3.l(j0, 14);
        j0.a.execute(l0);
    }

    public static u a() {
        l l0 = u.e;
        if(l0 == null) {
            throw new IllegalStateException("Not initialized!");
        }
        return (u)l0.g.get();
    }

    public static void b(Context context0) {
        if(u.e == null) {
            Class class0 = u.class;
            synchronized(class0) {
                if(u.e == null) {
                    k k0 = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
                    context0.getClass();
                    k0.a = context0;
                    u.e = k0.b();
                }
            }
        }
    }

    public final t c(m m0) {
        byte[] arr_b;
        Set set0 = m0 == null ? Collections.singleton(new N5.c("proto")) : Collections.unmodifiableSet(O5.a.d);
        d5.m m1 = Q5.j.a();
        m0.getClass();
        m1.b = "cct";
        String s = ((O5.a)m0).a;
        String s1 = ((O5.a)m0).b;
        if(s1 != null || s != null) {
            if(s1 == null) {
                s1 = "";
            }
            arr_b = ("1$" + s + "\\" + s1).getBytes(Charset.forName("UTF-8"));
        }
        else {
            arr_b = null;
        }
        m1.c = arr_b;
        return new t(set0, m1.e(), this);
    }
}

