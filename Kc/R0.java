package kc;

import Qb.z;
import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playlist.b;
import e.k;
import ie.H;
import je.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.i;
import sc.P0;
import we.n;

public final class r0 extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public final Mutex M;
    public final L0 N;
    public final Mutex S;
    public final DevLog T;
    public final b V;
    public int W;
    public Mutex r;
    public Object w;

    public r0(Mutex mutex0, Continuation continuation0, L0 l00, Mutex mutex1, DevLog devLog0, b b0) {
        this.M = mutex0;
        this.N = l00;
        this.S = mutex1;
        this.T = devLog0;
        this.V = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r0(this.M, continuation0, this.N, this.S, this.T, this.V);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Mutex mutex1;
        Object object1;
        long v1;
        Object object4;
        int v10;
        Mutex mutex3;
        int v9;
        Object object3;
        int v8;
        int v7;
        Mutex mutex2;
        Object object2;
        long v3;
        long v19;
        int v18;
        int v17;
        int v16;
        Mutex mutex4;
        Object object5;
        int v15;
        long v12;
        int v25;
        int v24;
        int v23;
        int v21;
        H h0;
        Object object6;
        int v27;
        long v26;
        a a0 = a.a;
        int v = this.E;
        DevLog devLog0 = this.T;
        L0 l00 = this.N;
        Mutex mutex0 = this.S;
        b b0 = this.V;
        switch(v) {
            case 0: {
                d5.n.D(object0);
                Mutex mutex5 = this.M;
                this.r = mutex5;
                object1 = null;
                this.w = null;
                this.B = 0;
                this.E = 1;
                if(mutex5.lock(null, this) != a0) {
                    mutex1 = mutex5;
                    v18 = 0;
                    try {
                    label_84:
                        v26 = System.currentTimeMillis();
                        if(l00 != null) {
                            goto label_86;
                        }
                        goto label_87;
                    }
                    catch(Throwable throwable1) {
                        mutex1.unlock(object1);
                        throw throwable1;
                    }
                    try {
                    label_86:
                        l00.a(" onLoginStateChanged-logout", true);
                    label_87:
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : onLoginStateChanged-logout", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : onLoginStateChanged-logout");
                        Iterable iterable0 = k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.DRAWER});
                        z z0 = b0.h;
                        if(p.d0(iterable0, b0.p.getValue())) {
                            z0.r();
                            this.r = mutex1;
                            this.w = object1;
                            this.B = v18;
                            this.D = 0;
                            this.G = 0;
                            this.I = v26;
                            this.W = 0;
                            this.E = 2;
                            if(b.b(b0, PlaylistId.MUSIC, this) != a0) {
                                v25 = v18;
                                object5 = object1;
                                mutex4 = mutex1;
                                v3 = v26;
                                v21 = 0;
                                v24 = 0;
                                v23 = 0;
                            label_109:
                                v27 = v23;
                                v9 = v24;
                                mutex3 = mutex4;
                                object6 = object5;
                                goto label_148;
                            }
                        }
                        else if(b0.p.getValue() == PlaylistId.LIVE) {
                            z0.r();
                            this.r = mutex1;
                            this.w = object1;
                            this.B = v18;
                            this.D = 0;
                            this.G = 0;
                            this.I = v26;
                            this.W = 0;
                            this.E = 3;
                            if(b.b(b0, PlaylistId.MUSIC, this) != a0) {
                                goto label_125;
                            }
                        }
                        else {
                            goto label_141;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        goto label_201;
                    }
                label_125:
                    mutex3 = mutex1;
                    v12 = v26;
                    v17 = 0;
                    v16 = 0;
                    v15 = 0;
                    try {
                    label_130:
                        ToastManager.show(0x7F130390);  // string:end_live "로그아웃으로 LIVE 재생이 종료됩니다."
                        v21 = v17;
                        v25 = v18;
                        object6 = object1;
                        v3 = v12;
                        v9 = v16;
                        v27 = v15;
                        goto label_148;
                    }
                    catch(Throwable throwable0) {
                        v1 = v12;
                        mutex1 = mutex3;
                        goto label_202;
                    }
                    try {
                    label_141:
                        v25 = v18;
                        object6 = object1;
                        v9 = 0;
                        v27 = 0;
                        mutex3 = mutex1;
                        v3 = v26;
                        v21 = 0;
                    }
                    catch(Throwable throwable0) {
                        goto label_201;
                    }
                    try {
                    label_148:
                        this.r = mutex3;
                        this.w = object6;
                        this.B = v25;
                        this.D = v21;
                        this.G = v27;
                        this.I = v3;
                        this.W = v9;
                        this.E = 4;
                        object4 = b0.b.h(false, this);
                    }
                    catch(Throwable throwable0) {
                        v1 = v3;
                        mutex1 = mutex3;
                        object1 = object6;
                        goto label_202;
                    }
                    if(object4 != a0) {
                        v7 = v21;
                        v10 = v27;
                        object3 = object6;
                        v8 = v25;
                        try {
                        label_168:
                            this.r = mutex3;
                            this.w = object3;
                            this.B = v8;
                            this.D = v7;
                            this.G = v10;
                            this.I = v3;
                            this.W = v9;
                            this.E = 5;
                            if(((P0)object4).M(this) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable0) {
                            v1 = v3;
                            object1 = object3;
                            mutex1 = mutex3;
                            goto label_202;
                        }
                        v1 = v3;
                        object1 = object3;
                        mutex1 = mutex3;
                        try {
                        label_187:
                            b0.r.setValue(Boolean.FALSE);
                            h0 = H.a;
                        }
                        catch(Throwable throwable0) {
                            goto label_202;
                        }
                        try {
                            long v28 = System.currentTimeMillis() - v1;
                            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-logout (" + v28 + "ms)", null, false, 6, null);
                            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-logout (" + v28 + "ms)");
                            if(l00 != null) {
                                l00.a(" onLoginStateChanged-logout", false);
                            }
                        }
                        catch(Throwable throwable1) {
                            mutex1.unlock(object1);
                            throw throwable1;
                        }
                        mutex1.unlock(object1);
                        return h0;
                    }
                }
                break;
            }
            case 1: {
                v18 = this.B;
                object1 = this.w;
                mutex1 = this.r;
                d5.n.D(object0);
                goto label_84;
            }
            case 2: {
                try {
                    int v20 = this.W;
                    v3 = this.I;
                    v21 = this.D;
                    int v22 = this.B;
                    v23 = this.G;
                    object5 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    v24 = v20;
                    v25 = v22;
                    goto label_109;
                }
                catch(Throwable throwable0) {
                    v19 = v3;
                }
                mutex1 = mutex4;
                v1 = v19;
                object1 = object5;
                goto label_202;
            }
            case 3: {
                try {
                    int v11 = this.W;
                    v12 = this.I;
                    int v13 = this.D;
                    int v14 = this.B;
                    v15 = this.G;
                    object5 = this.w;
                    mutex4 = this.r;
                    d5.n.D(object0);
                    v16 = v11;
                    v17 = v13;
                    mutex3 = mutex4;
                    v18 = v14;
                    object1 = object5;
                    goto label_130;
                }
                catch(Throwable throwable0) {
                    v19 = v12;
                    mutex1 = mutex4;
                    v1 = v19;
                    object1 = object5;
                    goto label_202;
                }
            }
            case 4: {
                try {
                    int v2 = this.W;
                    v3 = this.I;
                    int v4 = this.D;
                    int v5 = this.B;
                    int v6 = this.G;
                    object2 = this.w;
                    mutex2 = this.r;
                    d5.n.D(object0);
                    v7 = v4;
                    v8 = v5;
                    object3 = object2;
                    v9 = v2;
                    mutex3 = mutex2;
                    v10 = v6;
                    object4 = object0;
                    goto label_168;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex2;
                    v1 = v3;
                    object1 = object2;
                    goto label_202;
                }
            }
            default: {
                if(v == 5) {
                    try {
                        v1 = this.I;
                        object1 = this.w;
                        mutex1 = this.r;
                        d5.n.D(object0);
                        goto label_187;
                    }
                    catch(Throwable throwable0) {
                        goto label_202;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            return a0;
        }
        catch(Throwable throwable0) {
        label_201:
            v1 = v26;
        }
        try {
        label_202:
            long v29 = System.currentTimeMillis() - v1;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-logout (" + v29 + "ms)", null, false, 6, null);
            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock return : onLoginStateChanged-logout (" + v29 + "ms)");
            if(l00 != null) {
                l00.a(" onLoginStateChanged-logout", false);
            }
            throw throwable0;
        }
        catch(Throwable throwable1) {
            mutex1.unlock(object1);
            throw throwable1;
        }
    }
}

