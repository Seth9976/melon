package m8;

import E9.h;
import M6.B;
import Ma.m;
import Na.f;
import android.app.Activity;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.melon.playlist.mixup.DjMalrangInfo;
import db.c;
import db.d;
import ie.H;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import k8.Y;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import pc.N0;
import pc.P0;
import pc.Z;
import pc.z0;
import we.n;

public final class d0 extends i implements n {
    public String B;
    public String D;
    public String E;
    public boolean G;
    public int I;
    public Object M;
    public final boolean N;
    public final boolean S;
    public final Activity T;
    public final boolean V;
    public final String W;
    public s2 r;
    public String w;

    public d0(boolean z, boolean z1, Activity activity0, boolean z2, String s, Continuation continuation0) {
        this.N = z;
        this.S = z1;
        this.T = activity0;
        this.V = z2;
        this.W = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d0(this.N, this.S, this.T, this.V, this.W, continuation0);
        continuation1.M = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        String s1;
        Object object2;
        String s9;
        String s8;
        String s7;
        String s6;
        Object object3;
        String s11;
        s2 s20;
        boolean z;
        Object object4;
        s2 s21;
        N0 n00;
        String s15;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.M;
        a a0 = a.a;
        switch(this.I) {
            case 0: {
                d5.n.D(object0);
                s21 = (d3)(((s2)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).w.get()));
                Flow flow0 = ((d3)s21).t();
                this.M = coroutineScope0;
                this.r = s21;
                this.I = 1;
                object4 = FlowKt.first(flow0, this);
                if(object4 != a0) {
                label_39:
                    boolean z1 = ((Boolean)object4).booleanValue();
                    String s12 = !this.N || !this.S ? "N" : "Y";
                    if(s12.equals("Y")) {
                        c c0 = (c)d.a.getValue();
                        this.M = coroutineScope0;
                        this.r = s21;
                        this.w = s12;
                        this.G = z1;
                        this.I = 2;
                        object3 = c.a(c0, this);
                        if(object3 != a0) {
                            s20 = s21;
                            z = z1;
                            s11 = s12;
                        label_53:
                            db.a a1 = (db.a)h.H(((f)object3));
                            String s13 = String.valueOf((a1 == null ? null : new Double(a1.a)));
                            String s14 = String.valueOf((a1 == null ? null : new Double(a1.b)));
                            long v = a1 == null ? Cb.i.c(coroutineScope0) : a1.c;
                            try {
                                s15 = null;
                                s15 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA).format(new Date(v));
                            }
                            catch(Exception unused_ex) {
                            }
                            if(!z) {
                                n00 = new P0(false, s11, s13, s14, s15, null, 97);
                                goto label_96;
                            }
                            B b0 = ((d3)s20).n();
                            this.M = null;
                            this.r = null;
                            this.w = s11;
                            this.B = s13;
                            this.D = s14;
                            this.E = s15;
                            this.G = true;
                            this.I = 3;
                            object2 = ListenableFutureKt.await(b0, this);
                            if(object2 != a0) {
                                s9 = s11;
                                s8 = s13;
                                s7 = s14;
                                s6 = s15;
                            label_75:
                                z0 z00 = ((Z)(((pc.d)object2))).m();
                                q.e(z00.c, "null cannot be cast to non-null type com.melon.playlist.mixup.DjMalrangInfo");
                                n00 = new N0(s9, s8, s7, s6, ((DjMalrangInfo)z00.c).e, ((DjMalrangInfo)z00.c).f, ((DjMalrangInfo)z00.c).g, null, 0x80);
                                goto label_96;
                            }
                        }
                    }
                    else {
                        if(!z1) {
                            goto label_95;
                        }
                        B b1 = ((d3)s21).n();
                        this.M = null;
                        this.r = null;
                        this.w = s12;
                        this.G = true;
                        this.I = 4;
                        object1 = ListenableFutureKt.await(b1, this);
                        if(object1 != a0) {
                            s1 = s12;
                        label_91:
                            z0 z01 = ((Z)(((pc.d)object1))).m();
                            q.e(z01.c, "null cannot be cast to non-null type com.melon.playlist.mixup.DjMalrangInfo");
                            n00 = new N0(s1, null, null, null, ((DjMalrangInfo)z01.c).e, ((DjMalrangInfo)z01.c).f, ((DjMalrangInfo)z01.c).g, null, 0x8E);
                            goto label_96;
                        label_95:
                            n00 = new P0(false, s12, null, null, null, null, 0x7D);
                        label_96:
                            AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = this.V ? new AddPlayOpenPlayer(false) : new AddPlay(false);
                            AddServerContent addServerContent0 = new AddServerContent(addAction$AddPlayOpenPlayer0, false, false, null, new MixUp(n00, (this.W == null ? "1000003215" : this.W), null), 14, null);
                            AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(this.T, addServerContent0, false, 2, null);
                            return H.a;
                        }
                    }
                }
                break;
            }
            case 1: {
                s21 = this.r;
                d5.n.D(object0);
                object4 = object0;
                goto label_39;
            }
            case 2: {
                z = this.G;
                String s10 = this.w;
                s20 = this.r;
                d5.n.D(object0);
                s11 = s10;
                object3 = object0;
                goto label_53;
            }
            case 3: {
                String s2 = this.E;
                String s3 = this.D;
                String s4 = this.B;
                String s5 = this.w;
                d5.n.D(object0);
                s6 = s2;
                s7 = s3;
                s8 = s4;
                s9 = s5;
                object2 = object0;
                goto label_75;
            }
            case 4: {
                String s = this.w;
                d5.n.D(object0);
                s1 = s;
                object1 = object0;
                goto label_91;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

