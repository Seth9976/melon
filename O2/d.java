package o2;

import D2.v0;
import android.content.Context;
import android.content.SharedPreferences;
import d3.g;
import ie.r;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import je.p;
import kotlin.jvm.internal.q;
import oe.c;
import oe.i;
import p2.j;
import we.n;
import we.o;

public final class d {
    public final n a;
    public final i b;
    public final Context c;
    public final String d;
    public final r e;
    public final Set f;

    public d(Context context0, String s, Set set0, j j0, o o0, int v) {
        if((v & 4) != 0) {
            set0 = e.a;
        }
        if((v & 8) != 0) {
            j0 = new a(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        }
        this(context0, s, set0, j0, o0);
    }

    public d(Context context0, String s, Set set0, n n0, o o0) {
        q.g(context0, "context");
        q.g(s, "sharedPreferencesName");
        q.g(set0, "keysToMigrate");
        q.g(n0, "shouldRunMigration");
        v0 v00 = new v0(context0, s, 2);
        super();
        this.a = n0;
        this.b = (i)o0;
        this.c = context0;
        this.d = s;
        this.e = g.Q(v00);
        this.f = set0 == e.a ? null : p.S0(set0);
    }

    public final Object a(Object object0, c c0) {
        d d0;
        o2.c c1;
        if(c0 instanceof o2.c) {
            c1 = (o2.c)c0;
            int v = c1.D;
            if((v & 0x80000000) == 0) {
                c1 = new o2.c(this, c0);
            }
            else {
                c1.D = v ^ 0x80000000;
            }
        }
        else {
            c1 = new o2.c(this, c0);
        }
        Object object1 = c1.w;
        ne.a a0 = ne.a.a;
        switch(c1.D) {
            case 0: {
                d5.n.D(object1);
                c1.r = this;
                c1.D = 1;
                object1 = this.a.invoke(object0, c1);
                if(object1 == a0) {
                    return a0;
                }
                d0 = this;
                break;
            }
            case 1: {
                d0 = c1.r;
                d5.n.D(object1);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Boolean)object1).booleanValue()) {
            return false;
        }
        Set set0 = d0.f;
        r r0 = d0.e;
        if(set0 == null) {
            Map map0 = ((SharedPreferences)r0.getValue()).getAll();
            q.f(map0, "sharedPrefs.all");
            return map0.isEmpty() ? false : true;
        }
        SharedPreferences sharedPreferences0 = (SharedPreferences)r0.getValue();
        if(!(set0 instanceof Collection) || !set0.isEmpty()) {
            for(Object object2: set0) {
                if(sharedPreferences0.contains(((String)object2))) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }
}

