package pc;

import androidx.appcompat.app.o;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import e.k;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import je.p;
import k8.Y;
import kc.r2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oc.I;
import oe.i;
import we.n;

public final class x extends i implements n {
    public Z B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public z0 I;
    public List M;
    public List N;
    public int S;
    public int T;
    public int V;
    public int W;
    public int X;
    public int Y;
    public long Z;
    public int b0;
    public final Z c0;
    public Mutex r;
    public String w;

    public x(Z z0, Continuation continuation0) {
        this.c0 = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.c0, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v50;
        Object object9;
        Mutex mutex13;
        List list14;
        Z z5;
        long v49;
        Object object8;
        int v48;
        int v47;
        Iterator iterator1;
        long v46;
        String s7;
        DevLog devLog6;
        Object object7;
        long v42;
        Mutex mutex12;
        Object object6;
        List list8;
        Mutex mutex11;
        long v39;
        List list7;
        Object object5;
        long v38;
        u u0;
        List list10;
        List list9;
        Iterator iterator0;
        int v37;
        int v36;
        long v35;
        String s6;
        DevLog devLog5;
        Object object3;
        Mutex mutex10;
        long v31;
        DevLog devLog4;
        String s5;
        long v28;
        List list5;
        int v27;
        int v26;
        int v25;
        Mutex mutex9;
        int v24;
        int v23;
        long v22;
        int v21;
        List list4;
        int v20;
        int v19;
        List list3;
        long v16;
        LinkedList linkedList0;
        List list1;
        String s4;
        String s3;
        DevLog devLog3;
        Object object2;
        Mutex mutex8;
        int v10;
        long v9;
        String s2;
        int v8;
        z0 z02;
        Mutex mutex7;
        Mutex mutex6;
        int v7;
        int v6;
        DevLog devLog2;
        Object object1;
        Mutex mutex5;
        Mutex mutex4;
        z0 z00;
        long v4;
        int v1;
        DevLog devLog1;
        int v;
        String s1;
        String s;
        Mutex mutex1;
        Z z1;
        Mutex mutex0;
        a a0 = a.a;
        switch(this.b0) {
            case 0: {
                d5.n.D(object0);
                Z z0 = this.c0;
                mutex0 = z0.e;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "Lock[", "]  try : mixup_checkAndAddToWaitListAsync"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                Y.u("Lock[", mutex0.hashCode(), "]  try : mixup_checkAndAddToWaitListAsync", devLog0);
                this.r = mutex0;
                this.w = "mixup_checkAndAddToWaitListAsync";
                this.B = z0;
                this.D = devLog0;
                this.E = "";
                this.G = mutex0;
                this.S = 0;
                this.T = 0;
                this.b0 = 1;
                if(mutex0.lock(null, this) == a0) {
                    return a0;
                }
                z1 = z0;
                mutex1 = mutex0;
                s = "mixup_checkAndAddToWaitListAsync";
                s1 = "";
                v = 0;
                devLog1 = devLog0;
                v1 = 0;
                goto label_40;
            }
            case 1: {
                int v2 = this.S;
                Mutex mutex2 = this.G;
                s1 = this.E;
                devLog1 = this.D;
                z1 = this.B;
                s = this.w;
                int v3 = this.T;
                Mutex mutex3 = this.r;
                d5.n.D(object0);
                v1 = v2;
                mutex0 = mutex2;
                mutex1 = mutex3;
                v = v3;
                try {
                label_40:
                    v4 = System.currentTimeMillis();
                }
                catch(Throwable throwable0) {
                    mutex0.unlock(null);
                    throw throwable0;
                }
                try {
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s, null, false, 6, null);
                    devLog1.put("Lock[" + mutex1.hashCode() + "] " + s1 + " Lock obtain : " + s);
                    z00 = (z0)z1.f.getValue();
                    int v5 = b.B(z00).size();
                }
                catch(Throwable throwable1) {
                    mutex4 = mutex1;
                    devLog2 = devLog1;
                    s4 = s;
                    goto label_519;
                }
                if(z00.d + 3 >= v5) {
                    try {
                        z0 z01 = (z0)z1.f.getValue();
                        ArrayList arrayList0 = b.B(z01);
                        mutex5 = mutex1;
                        List list0 = p.K0(z01.d, arrayList0);
                        mutex5 = mutex1;
                        this.r = mutex5;
                        this.w = s;
                        this.B = z1;
                        this.D = devLog1;
                        this.E = s1;
                        this.G = mutex0;
                        this.I = z00;
                        this.S = v1;
                        this.T = v;
                        this.V = 0;
                        this.Z = v4;
                        this.W = 0;
                        this.b0 = 2;
                        object1 = ((y0)z1.c).h(list0, this);
                    }
                    catch(Throwable throwable1) {
                        mutex4 = mutex5;
                        devLog2 = devLog1;
                        s4 = s;
                        goto label_519;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    v6 = v;
                    v7 = 0;
                    mutex6 = mutex5;
                    devLog2 = devLog1;
                    mutex7 = mutex0;
                    z02 = z00;
                    object0 = object1;
                    v8 = v1;
                    s2 = s1;
                    v9 = v4;
                    v10 = 0;
                    goto label_120;
                }
                else {
                    mutex8 = mutex1;
                }
                goto label_524;
            }
            case 2: {
                try {
                    v9 = this.Z;
                    int v11 = this.T;
                    int v12 = this.S;
                    z0 z03 = this.I;
                    mutex7 = this.G;
                    int v13 = this.V;
                    object2 = this.E;
                    int v14 = this.W;
                    Z z2 = this.B;
                    devLog3 = this.D;
                    s3 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    mutex6 = mutex4;
                    v7 = v14;
                    devLog2 = devLog3;
                    z02 = z03;
                    v10 = v13;
                    s2 = object2;
                    v6 = v11;
                    z1 = z2;
                    v8 = v12;
                    s = s3;
                }
                catch(Throwable throwable1) {
                    s1 = object2;
                    v4 = v9;
                    mutex0 = mutex7;
                    devLog2 = devLog3;
                    s4 = s3;
                    goto label_519;
                }
                try {
                label_120:
                    int v15 = b.B(z02).size();
                    list1 = (List)object0;
                    r2 r20 = z1.k;
                    linkedList0 = z1.i;
                    if(v15 + ((List)object0).size() > z1.j) {
                        goto label_129;
                    }
                    else {
                        goto label_163;
                    }
                    goto label_523;
                }
                catch(Throwable throwable1) {
                    v16 = v9;
                    goto label_182;
                }
                try {
                label_129:
                    int v17 = b.B(z02).size() + list1.size() - z1.j;
                    int v18 = z02.b >= v17 ? 0 : 1;
                    List list2 = p.K0(v17, linkedList0);
                    linkedList0.subList(0, v17).clear();
                    v16 = v9;
                    linkedList0.addAll(list1);
                    this.r = mutex6;
                    this.w = s;
                    this.B = z1;
                    this.D = devLog2;
                    this.E = s2;
                    this.G = mutex7;
                    this.I = null;
                    this.M = list1;
                    this.N = list2;
                    this.S = v8;
                    this.T = v6;
                    this.V = v10;
                    list3 = list2;
                    v19 = v10;
                    v16 = v9;
                    this.Z = v16;
                    this.W = v7;
                    this.X = v17;
                    this.Y = v18;
                    this.b0 = 3;
                    v20 = v18;
                    if(r20.a(list1, "MixUpPlaylistImpl, checkAndAddToWaitListInternal", this) == a0) {
                        return a0;
                    }
                    list4 = list1;
                    v21 = v17;
                    v22 = v16;
                    v23 = v8;
                    v24 = v7;
                    goto label_235;
                label_163:
                    v16 = v9;
                    linkedList0.addAll(list1);
                    this.r = mutex6;
                    this.w = s;
                    this.B = z1;
                    this.D = devLog2;
                    this.E = s2;
                    this.G = mutex7;
                    this.I = null;
                    this.M = list1;
                    this.S = v8;
                    this.T = v6;
                    this.V = v10;
                    this.Z = v16;
                    this.W = v7;
                    this.b0 = 6;
                    if(r20.a(list1, "MixUpPlaylistImpl, checkAndAddToWaitListInternal", this) == a0) {
                        return a0;
                    }
                    goto label_188;
                }
                catch(Throwable throwable1) {
                }
            label_182:
                s1 = s2;
                v4 = v16;
                mutex4 = mutex6;
                mutex0 = mutex7;
                s4 = s;
                goto label_519;
            label_188:
                mutex9 = mutex7;
                s4 = s;
                v25 = v10;
                v26 = v7;
                v27 = v8;
                list5 = list1;
                v28 = v16;
                s5 = s2;
                devLog4 = devLog2;
                goto label_421;
            }
            case 3: {
                try {
                    int v29 = this.X;
                    int v30 = this.W;
                    v31 = this.Z;
                    int v32 = this.V;
                    int v33 = this.T;
                    int v34 = this.S;
                    v20 = this.Y;
                    list3 = this.N;
                    mutex10 = this.G;
                    object3 = this.E;
                    devLog5 = this.D;
                    List list6 = this.M;
                    Z z3 = this.B;
                    s6 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    v23 = v34;
                    s = s6;
                    v22 = v31;
                    v21 = v29;
                    s2 = object3;
                    devLog2 = devLog5;
                    v19 = v32;
                    mutex7 = mutex10;
                    v24 = v30;
                    v6 = v33;
                    list4 = list6;
                    z1 = z3;
                    mutex6 = mutex4;
                }
                catch(Throwable throwable1) {
                    mutex0 = mutex10;
                    s4 = s6;
                    v4 = v31;
                    s1 = object3;
                    devLog2 = devLog5;
                    goto label_519;
                }
                try {
                label_235:
                    v35 = System.currentTimeMillis();
                    v36 = 0;
                    v37 = 0;
                    iterator0 = z1.i.iterator();
                label_239:
                    while(!iterator0.hasNext()) {
                        goto label_259;
                    }
                }
                catch(Throwable throwable1) {
                    v38 = v22;
                    goto label_314;
                }
                try {
                    Object object4 = iterator0.next();
                    if(v37 < 0) {
                        k.O();
                        throw null;
                    }
                    if(((Playable)object4).getCreatedSeq() == -1) {
                        ((Playable)object4).setCreatedSeq(v36);
                        ++v36;
                    }
                    if(((Playable)object4).getCreatedAt() == 0L) {
                        ((Playable)object4).setCreatedAt(v35);
                    }
                    ((Playable)object4).setOrder(v37);
                    ++v37;
                    goto label_239;
                }
                catch(Throwable throwable1) {
                    s1 = s2;
                    mutex4 = mutex6;
                    mutex0 = mutex7;
                    s4 = s;
                    v4 = v22;
                    goto label_519;
                }
            label_259:
                if(v20 == 0) {
                    goto label_292;
                label_314:
                    s1 = s2;
                    mutex0 = mutex7;
                    s4 = s;
                    v4 = v38;
                    mutex4 = mutex6;
                    goto label_519;
                label_320:
                    if(object6 == a0) {
                        return a0;
                    }
                    list9 = list4;
                    v39 = v38;
                    s1 = s2;
                    mutex11 = mutex7;
                    list10 = list3;
                    goto label_372;
                }
                else {
                    try {
                        z1.g = -1L;
                        u0 = new u(z1, v21, null);
                        this.r = mutex6;
                        this.w = s;
                        this.B = z1;
                        this.D = devLog2;
                        this.E = s2;
                        this.G = mutex7;
                        this.I = null;
                        this.M = list4;
                        this.N = list3;
                        this.S = v23;
                        this.T = v6;
                        this.V = v19;
                        v38 = v22;
                    }
                    catch(Throwable throwable1) {
                        v38 = v22;
                        goto label_314;
                    }
                    try {
                        this.Z = v38;
                        this.W = v24;
                        this.X = v21;
                        this.Y = v20;
                        this.b0 = 4;
                        object5 = z1.A(u0, this);
                        if(object5 == a0) {
                            return a0;
                        }
                        list7 = list4;
                        v39 = v38;
                        s1 = s2;
                        mutex11 = mutex7;
                        list8 = list3;
                        goto label_341;
                    label_292:
                        v38 = v22;
                        v v40 = new v(z1, v21, null);
                        this.r = mutex6;
                        this.w = s;
                        this.B = z1;
                        this.D = devLog2;
                        this.E = s2;
                        this.G = mutex7;
                        this.I = null;
                        this.M = list4;
                        this.N = list3;
                        this.S = v23;
                        this.T = v6;
                        this.V = v19;
                        this.Z = v38;
                        this.W = v24;
                        this.X = v21;
                        this.Y = 0;
                        this.b0 = 5;
                        object6 = z1.A(v40, this);
                        goto label_320;
                    }
                    catch(Throwable throwable1) {
                    }
                    goto label_314;
                }
                goto label_379;
            }
            case 4: {
                try {
                    List list11 = this.N;
                    list7 = this.M;
                    mutex11 = this.G;
                    s1 = this.E;
                    devLog1 = this.D;
                    z1 = this.B;
                    s = this.w;
                    v39 = this.Z;
                    mutex12 = this.r;
                    d5.n.D(object0);
                    devLog2 = devLog1;
                    mutex6 = mutex12;
                    list8 = list11;
                    object5 = object0;
                }
                catch(Throwable throwable1) {
                    goto label_366;
                }
                try {
                label_341:
                    s4 = s;
                    ((y0)z1.c).d(list8, list7, z1.i);
                    ((y0)z1.c).g(z1.g, "checkAndAddToWaitListInternal");
                    ((y0)z1.c).f(((z0)object5).b, "checkAndAddToWaitListInternal");
                    ((y0)z1.c).e(((z0)object5).d);
                    I i0 = z1.m;
                    if(i0 != null) {
                        i0.c(((z0)object5), z1.g);
                    }
                    goto label_379;
                }
                catch(Throwable throwable1) {
                    mutex0 = mutex11;
                    mutex4 = mutex6;
                    v4 = v39;
                    goto label_519;
                }
            }
            case 5: {
                try {
                    List list12 = this.N;
                    list9 = this.M;
                    mutex11 = this.G;
                    s1 = this.E;
                    devLog1 = this.D;
                    z1 = this.B;
                    s = this.w;
                    v39 = this.Z;
                    mutex12 = this.r;
                    d5.n.D(object0);
                    devLog2 = devLog1;
                    mutex6 = mutex12;
                    list10 = list12;
                    object6 = object0;
                    goto label_372;
                }
                catch(Throwable throwable1) {
                label_366:
                    mutex4 = mutex12;
                    mutex0 = mutex11;
                    v4 = v39;
                }
                devLog2 = devLog1;
                s4 = s;
                goto label_519;
                try {
                label_372:
                    s4 = s;
                    ((y0)z1.c).d(list10, list9, z1.i);
                    ((y0)z1.c).f(((z0)object6).b, "checkAndAddToWaitListInternal");
                    ((y0)z1.c).e(((z0)object6).d);
                    I i1 = z1.m;
                    if(i1 != null) {
                        i1.c(((z0)object6), z1.g);
                    }
                label_379:
                    mutex0 = mutex11;
                    s = s4;
                    v4 = v39;
                    devLog1 = devLog2;
                    goto label_523;
                }
                catch(Throwable throwable1) {
                    mutex0 = mutex11;
                    mutex4 = mutex6;
                    v4 = v39;
                    goto label_519;
                }
            }
            case 6: {
                try {
                    int v41 = this.W;
                    v42 = this.Z;
                    int v43 = this.V;
                    int v44 = this.T;
                    int v45 = this.S;
                    List list13 = this.M;
                    mutex9 = this.G;
                    object7 = this.E;
                    Z z4 = this.B;
                    devLog6 = this.D;
                    s7 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    z1 = z4;
                    list5 = list13;
                    s5 = object7;
                    v25 = v43;
                    v26 = v41;
                    mutex6 = mutex4;
                    v28 = v42;
                    devLog4 = devLog6;
                    v6 = v44;
                    v27 = v45;
                    s4 = s7;
                }
                catch(Throwable throwable1) {
                    mutex0 = mutex9;
                    s4 = s7;
                    v4 = v42;
                    s1 = object7;
                    devLog2 = devLog6;
                    goto label_519;
                }
                try {
                label_421:
                    v46 = System.currentTimeMillis();
                    iterator1 = z1.i.iterator();
                    v47 = 0;
                    v48 = 0;
                    while(true) {
                    label_425:
                        if(!iterator1.hasNext()) {
                            w w0 = new w(z1, null);
                            this.r = mutex6;
                            this.w = s4;
                            this.B = z1;
                            this.D = devLog4;
                            this.E = s5;
                            this.G = mutex9;
                            this.I = null;
                            this.M = list5;
                            this.N = null;
                            this.S = v27;
                            this.T = v6;
                            this.V = v25;
                            this.Z = v28;
                            this.W = v26;
                            this.b0 = 7;
                            object8 = z1.A(w0, this);
                            break;
                        }
                        goto label_458;
                    }
                }
                catch(Throwable throwable1) {
                    v4 = v28;
                    devLog2 = devLog4;
                    mutex4 = mutex6;
                    mutex0 = mutex9;
                    goto label_511;
                }
                if(object8 == a0) {
                    return a0;
                }
                v49 = v28;
                z5 = z1;
                mutex0 = mutex9;
                list14 = list5;
                mutex13 = mutex6;
                goto label_497;
                try {
                label_458:
                    object9 = iterator1.next();
                }
                catch(Throwable throwable1) {
                    v50 = v28;
                    goto label_514;
                }
                if(v47 < 0) {
                    goto label_474;
                }
                try {
                    v50 = v28;
                    if(((Playable)object9).getCreatedSeq() == -1) {
                        ((Playable)object9).setCreatedSeq(v48);
                        ++v48;
                    }
                    if(((Playable)object9).getCreatedAt() == 0L) {
                        ((Playable)object9).setCreatedAt(v46);
                    }
                    ((Playable)object9).setOrder(v47);
                    ++v47;
                    v28 = v50;
                    goto label_425;
                label_474:
                    v50 = v28;
                    k.O();
                    throw null;
                }
                catch(Throwable throwable1) {
                    goto label_514;
                }
            }
            case 7: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v51 = this.Z;
        F f0 = (F)this.N;
        List list15 = this.M;
        mutex0 = this.G;
        s5 = this.E;
        devLog4 = this.D;
        z5 = this.B;
        s4 = this.w;
        mutex13 = this.r;
        try {
            d5.n.D(object0);
            v49 = v51;
            list14 = list15;
            object8 = object0;
        }
        catch(Throwable throwable1) {
            devLog2 = devLog4;
            s1 = s5;
            mutex4 = mutex13;
            v4 = v51;
            goto label_519;
        }
        try {
        label_497:
            ((y0)z5.c).d(je.w.a, list14, z5.i);
            I i2 = z5.m;
            if(i2 != null) {
                i2.c(((z0)object8), z5.g);
            }
            v4 = v49;
            s = s4;
            mutex6 = mutex13;
            devLog1 = devLog4;
            s1 = s5;
            goto label_523;
        }
        catch(Throwable throwable1) {
            v4 = v49;
            devLog2 = devLog4;
            mutex4 = mutex13;
        }
        try {
            while(true) {
            label_511:
                s1 = s5;
                break;
            label_514:
                devLog2 = devLog4;
                mutex4 = mutex6;
                mutex0 = mutex9;
                v4 = v50;
            }
        }
        catch(Throwable throwable1) {
            goto label_514;
        }
        try {
        label_519:
            long v52 = System.currentTimeMillis() - v4;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s4 + " (" + v52 + "ms)", null, false, 6, null);
            devLog2.put("Lock[" + mutex4.hashCode() + "] " + s1 + " Lock return : " + s4 + " (" + v52 + "ms)");
            throw throwable1;
        label_523:
            mutex8 = mutex6;
        label_524:
            long v53 = System.currentTimeMillis() - v4;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex8.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v53 + "ms)", null, false, 6, null);
            devLog1.put("Lock[" + mutex8.hashCode() + "] " + s1 + " Lock return : " + s + " (" + v53 + "ms)");
        }
        catch(Throwable throwable0) {
            mutex0.unlock(null);
            throw throwable0;
        }
        mutex0.unlock(null);
        return H.a;
    }
}

