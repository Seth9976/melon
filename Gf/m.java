package Gf;

import A0.c;
import U4.x;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.q;
import we.k;

public class m implements p {
    public final o a;
    public final a b;
    public final String c;
    public static final String d;
    public static final b e;

    static {
        String s1;
        String s = m.class.getCanonicalName();
        q.g(s, "<this>");
        int v = Tf.o.K0(s, ".", 0, 6);
        if(v == -1) {
            s1 = "";
        }
        else {
            s1 = s.substring(0, v);
            q.f(s1, "substring(...)");
        }
        m.d = s1;
        m.e = new b("NO_LOCKS", a.a);  // 初始化器: LGf/m;-><init>(Ljava/lang/String;LGf/o;)V
    }

    public m(String s) {
        this(s, new c(new ReentrantLock(), 23));
    }

    public m(String s, o o0) {
        this.a = o0;
        this.b = a.b;
        this.c = s;
    }

    public final i a(we.a a0) {
        return new i(this, a0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    public final e b(k k0) {
        return new e(this, new ConcurrentHashMap(3, 1.0f, 2), k0, 1);
    }

    public final j c(k k0) {
        return new j(this, new ConcurrentHashMap(3, 1.0f, 2), k0, 0);
    }

    public l d(Object object0, String s) {
        AssertionError assertionError0 = new AssertionError("Recursion detected " + s + (object0 == null ? "" : "on input: " + object0) + " under " + this);
        m.e(assertionError0);
        throw assertionError0;
    }

    public static void e(AssertionError assertionError0) {
        StackTraceElement[] arr_stackTraceElement = assertionError0.getStackTrace();
        int v;
        for(v = 0; true; ++v) {
            if(v >= arr_stackTraceElement.length) {
                v = -1;
                break;
            }
            if(!arr_stackTraceElement[v].getClassName().startsWith(m.d)) {
                break;
            }
        }
        List list0 = Arrays.asList(arr_stackTraceElement).subList(v, arr_stackTraceElement.length);
        assertionError0.setStackTrace(((StackTraceElement[])list0.toArray(new StackTraceElement[list0.size()])));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.getClass().getSimpleName());
        stringBuilder0.append("@");
        stringBuilder0.append(Integer.toHexString(this.hashCode()));
        stringBuilder0.append(" (");
        return x.m(stringBuilder0, this.c, ")");
    }
}

