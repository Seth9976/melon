package jd;

import Na.f;
import Pc.e;
import com.iloen.melon.custom.L0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import k8.Y;
import kb.D;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class v2 extends i implements n {
    public w2 B;
    public int D;
    public int E;
    public int G;
    public final w2 I;
    public final e M;
    public L0 r;
    public String w;

    public v2(w2 w20, e e0, Continuation continuation0) {
        this.I = w20;
        this.M = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v2(this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        String s2;
        L0 l00;
        String s1;
        Object object2;
        int v4;
        int v3;
        L0 l01;
        String s3;
        Object object3;
        Object object4;
        int v7;
        w2 w20 = this.I;
        D d0 = w20.a;
        a a0 = a.a;
        String s = "";
        int v = 0;
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                L0 l02 = w20.getProgressUpdater();
                s2 = "MusicWaveImageViewerViewModel";
                e e0 = this.M;
                if(l02 == null) {
                    this.r = null;
                    this.w = null;
                    this.B = w20;
                    this.D = 0;
                    this.E = 0;
                    this.G = 1;
                    object4 = d0.g(((r2)e0).a, this);
                    if(object4 != a0) {
                        v7 = 0;
                    label_59:
                        switch(((f)object4).getResult().ordinal()) {
                            case 0: {
                                D d1 = w20.a;
                                String s4 = w20.e == null ? "" : w20.e;
                                String s5 = w20.f;
                                if(s5 != null) {
                                    s = s5;
                                }
                                this.r = null;
                                this.w = null;
                                this.B = w20;
                                this.D = v;
                                this.E = v7;
                                this.G = 2;
                                object3 = d1.j(s4, s, "1757130017", this);
                                if(object3 != a0) {
                                    w2.b(w20, ((f)object3));
                                    return H.a;
                                }
                                break;
                            }
                            case 1: {
                                return H.a;
                            }
                            default: {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                    }
                }
                else {
                    l02.a("MusicWaveImageViewerViewModel true", true);
                    try {
                        this.r = l02;
                        this.w = "MusicWaveImageViewerViewModel";
                        this.B = w20;
                        this.D = 0;
                        this.E = 0;
                        this.G = 3;
                        object2 = d0.g(((r2)e0).a, this);
                    }
                    catch(Throwable throwable0) {
                        l00 = l02;
                        goto label_117;
                    }
                    if(object2 != a0) {
                        l01 = l02;
                        v3 = 0;
                        v4 = 0;
                        try {
                        label_92:
                            int v8 = ((f)object2).getResult().ordinal();
                            if(v8 != 0) {
                                goto label_113;
                            }
                            D d2 = w20.a;
                            String s6 = w20.e == null ? "" : w20.e;
                            String s7 = w20.f;
                            if(s7 != null) {
                                s = s7;
                            }
                            this.r = l01;
                            this.w = s2;
                            this.B = w20;
                            this.D = v4;
                            this.E = v3;
                            this.G = 4;
                            object1 = d2.j(s6, s, "1757130017", this);
                            if(object1 != a0) {
                                goto label_107;
                            }
                            break;
                        }
                        catch(Throwable throwable0) {
                            goto label_116;
                        }
                    label_107:
                        l00 = l01;
                        try {
                        label_108:
                            w2.b(w20, ((f)object1));
                            l01 = l00;
                            goto label_120;
                        }
                        catch(Throwable throwable0) {
                            goto label_117;
                        }
                    label_113:
                        if(v8 != 1) {
                            try {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            label_116:
                                l00 = l01;
                            label_117:
                                s1 = s2;
                            }
                            catch(Throwable throwable0) {
                                goto label_116;
                            }
                            Y.v(s1, " false", l00, false);
                            throw throwable0;
                        }
                    label_120:
                        Y.v(s2, " false", l01, false);
                        return H.a;
                    }
                }
                break;
            }
            case 1: {
                int v5 = this.E;
                int v6 = this.D;
                w2 w22 = this.B;
                d5.n.D(object0);
                v7 = v5;
                v = v6;
                w20 = w22;
                object4 = object0;
                goto label_59;
            }
            case 2: {
                w20 = this.B;
                d5.n.D(object0);
                object3 = object0;
                w2.b(w20, ((f)object3));
                return H.a;
            }
            case 3: {
                try {
                    int v1 = this.E;
                    int v2 = this.D;
                    w2 w21 = this.B;
                    s3 = this.w;
                    l01 = this.r;
                    d5.n.D(object0);
                    v3 = v1;
                    w20 = w21;
                    s2 = s3;
                    v4 = v2;
                    object2 = object0;
                    goto label_92;
                }
                catch(Throwable throwable0) {
                    s1 = s3;
                    l00 = l01;
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 4: {
                try {
                    w20 = this.B;
                    s1 = this.w;
                    l00 = this.r;
                    d5.n.D(object0);
                    s2 = s1;
                    object1 = object0;
                    goto label_108;
                }
                catch(Throwable throwable0) {
                    Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

