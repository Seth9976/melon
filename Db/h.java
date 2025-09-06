package Db;

import A0.c;
import A9.a;
import De.I;
import Hb.j;
import Tf.o;
import com.melon.log.data.b;
import d3.g;
import d5.n;
import ie.H;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

public final class h {
    public static final h a;
    public static b b;
    public static final c c;
    public static final CoroutineScope d;
    public static final Semaphore e;
    public static final Channel f;
    public static final ArrayList g;
    public static final Mutex h;

    static {
        h.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h.c = new c(26);
        h.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        h.e = SemaphoreKt.Semaphore$default(3, 0, 2, null);
        g.Q(new a(12));
        h.f = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
        h.g = new ArrayList();
        h.h = MutexKt.Mutex$default(false, 1, null);
    }

    public static final Object a(long v, oe.c c0) {
        Db.b b0;
        if(c0 instanceof Db.b) {
            b0 = (Db.b)c0;
            int v1 = b0.B;
            if((v1 & 0x80000000) == 0) {
                b0 = new Db.b(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                b0.B = v1 ^ 0x80000000;
            }
        }
        else {
            b0 = new Db.b(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = b0.w;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                break;
            }
            case 1: 
            case 2: {
                v = b0.r;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(object0);
        do {
            do {
                ArrayList arrayList0 = h.g;
                if(arrayList0 != null && arrayList0.isEmpty()) {
                    return H.a;
                }
                Iterator iterator0 = arrayList0.iterator();
            label_18:
                if(!iterator0.hasNext()) {
                    return H.a;
                }
                Object object1 = iterator0.next();
                if(((Gb.a)object1).a >= v) {
                    goto label_18;
                }
                if(arrayList0.size() < 300) {
                    goto label_26;
                }
                b0.r = v;
                b0.B = 1;
            }
            while(DelayKt.delay(100L, b0) != a0);
            return a0;
        label_26:
            b0.r = v;
            b0.B = 2;
        }
        while(h.a.c(b0) != a0);
        return a0;
    }

    public static final void b(h h0, BufferedWriter bufferedWriter0, List list0) {
        h0.getClass();
        for(Object object0: list0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(I.b0(((Gb.a)object0).a));
            stringBuilder0.append(" ");
            stringBuilder0.append(((Gb.a)object0).b);
            stringBuilder0.append(" ");
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(o.d1(1, ((Gb.a)object0).c.name()) + "/" + ((Gb.a)object0).d);
            j j0 = ((Gb.a)object0).f;
            if(!q.b(j0, Hb.g.b)) {
                stringBuilder1.append("[" + j0.a + "]");
            }
            stringBuilder0.append(stringBuilder1.toString());
            stringBuilder0.append(" ");
            stringBuilder0.append(((Gb.a)object0).e);
            stringBuilder0.append("\n");
            bufferedWriter0.write(stringBuilder0.toString());
        }
    }

    public final Object c(oe.c c0) {
        Mutex mutex0;
        Db.c c1;
        if(c0 instanceof Db.c) {
            c1 = (Db.c)c0;
            int v = c1.D;
            if((v & 0x80000000) == 0) {
                c1 = new Db.c(this, c0);
            }
            else {
                c1.D = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Db.c(this, c0);
        }
        Object object0 = c1.w;
        ne.a a0 = ne.a.a;
        switch(c1.D) {
            case 0: {
                n.D(object0);
                mutex0 = h.h;
                c1.r = mutex0;
                c1.D = 1;
                if(mutex0.lock(null, c1) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                Mutex mutex1 = c1.r;
                n.D(object0);
                mutex0 = mutex1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            ArrayList arrayList0 = h.g;
            List list0 = p.K0(300, arrayList0);
            if(!list0.isEmpty()) {
                arrayList0.removeAll(p.T0(list0));
                d d0 = new d(list0, null);
                BuildersKt__Builders_commonKt.launch$default(h.d, Dispatchers.getIO(), null, d0, 2, null);
            }
            return H.a;
        }
        finally {
            mutex0.unlock(null);
        }
    }
}

