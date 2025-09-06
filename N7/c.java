package N7;

import d5.n;
import e7.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import je.D;
import jeb.synthetic.FIN;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.sync.Mutex;

public final class c {
    public static final c a;
    public static final Map b;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = Collections.synchronizedMap(new LinkedHashMap());
    }

    public static a a(d d0) {
        q.f(c.b, "dependencies");
        Object object0 = c.b.get(d0);
        if(object0 == null) {
            throw new IllegalStateException("Cannot get dependency " + d0 + ". Dependencies should be added at class load time.");
        }
        return (a)object0;
    }

    public final Object b(oe.c c0) {
        int v1;
        Map map1;
        d d0;
        Mutex mutex0;
        Object object1;
        Iterator iterator0;
        Map map0;
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v = b0.N;
            if((v & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.N = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Object object0 = b0.I;
        ne.a a0 = ne.a.a;
        switch(b0.N) {
            case 0: {
                n.D(object0);
                q.f(c.b, "dependencies");
                map0 = new LinkedHashMap(D.N(c.b.size()));
                iterator0 = c.b.entrySet().iterator();
                goto label_34;
            }
            case 1: {
                object1 = b0.G;
                map0 = b0.E;
                mutex0 = b0.D;
                d0 = b0.B;
                iterator0 = b0.w;
                map1 = b0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            v1 = FIN.finallyOpen$NT();
            q.g(d0, "subscriberName");
            h h0 = c.a(d0).b;
            if(h0 == null) {
                break;
            }
            FIN.finallyCodeBegin$NT(v1);
            mutex0.unlock(null);
            FIN.finallyCodeEnd$NT(v1);
            map0.put(object1, h0);
            map0 = map1;
        label_34:
            if(iterator0.hasNext()) {
                Object object2 = iterator0.next();
                object1 = ((Map.Entry)object2).getKey();
                d0 = (d)((Map.Entry)object2).getKey();
                mutex0 = ((a)((Map.Entry)object2).getValue()).a;
                b0.r = map0;
                b0.w = iterator0;
                b0.B = d0;
                b0.D = mutex0;
                b0.E = map0;
                b0.G = object1;
                b0.N = 1;
                if(mutex0.lock(null, b0) == a0) {
                    return a0;
                }
                map1 = map0;
                continue;
            }
            return map0;
        }
        FIN.finallyExec$NT(v1);
        throw new IllegalStateException("Subscriber " + d0 + " has not been registered.");
    }
}

