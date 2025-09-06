package Nb;

import M6.B;
import Q1.c;
import Qb.z;
import android.content.Intent;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playback.MelonIntentService;
import ie.H;
import k8.t;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import pb.l;
import we.n;
import y8.s;

public final class k extends i implements n {
    public final int B;
    public final MelonIntentService D;
    public final Intent E;
    public final int G;
    public final Intent I;
    public boolean r;
    public int w;

    public k(int v, MelonIntentService melonIntentService0, Intent intent0, int v1, Intent intent1, Continuation continuation0) {
        this.B = v;
        this.D = melonIntentService0;
        this.E = intent0;
        this.G = v1;
        this.I = intent1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k(this.B, this.D, this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z;
        a a0 = a.a;
        int v = this.G;
        MelonIntentService melonIntentService0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                PlaylistId playlistId0 = PlaylistId.Companion.makePlaylistId(this.B);
                s2 s20 = melonIntentService0.f;
                if(s20 != null) {
                    B b0 = ((d3)s20).a(playlistId0);
                    this.w = 1;
                    if(ListenableFutureKt.await(b0, this) == a0) {
                        return a0;
                    }
                label_23:
                    z = this.E.getBooleanExtra("excludeAdultContent", false);
                    if(z) {
                        s2 s21 = melonIntentService0.f;
                        if(s21 == null) {
                            q.m("playlistManager");
                            throw null;
                        }
                        l l0 = new l(s21, 0);
                        this.r = true;
                        this.w = 2;
                        if(l0.c(null, this) == a0) {
                            return a0;
                        }
                    }
                label_34:
                    if(v >= 0) {
                        s s0 = melonIntentService0.i;
                        if(s0 != null) {
                            this.r = z;
                            this.w = 3;
                            object0 = s0.o(this);
                            if(object0 != a0) {
                            label_41:
                                if(!((Boolean)object0).booleanValue()) {
                                    goto label_57;
                                }
                                s s1 = melonIntentService0.i;
                                if(s1 == null) {
                                    q.m("playerUseCase");
                                    throw null;
                                }
                                this.r = z;
                                this.w = 4;
                                object0 = s1.m(v, this);
                                if(object0 != a0) {
                                label_48:
                                    if(!((Boolean)object0).booleanValue()) {
                                        Intent intent0 = new Intent();
                                        c.Z(intent0, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", 2);
                                        intent0.putExtra("alertdialogtype", 20);
                                        intent0.putExtra("typekey", v);
                                        melonIntentService0.sendBroadcast(intent0);
                                        goto label_69;
                                    }
                                label_57:
                                    s s2 = melonIntentService0.i;
                                    if(s2 != null) {
                                        ((z)s2.a).u(v);
                                        goto label_69;
                                    }
                                    q.m("playerUseCase");
                                    throw null;
                                }
                            }
                            return a0;
                        }
                        q.m("playerUseCase");
                        throw null;
                    }
                    s s3 = melonIntentService0.i;
                    if(s3 != null) {
                        ((z)s3.a).s();
                    label_69:
                        Intent intent1 = this.I;
                        if(intent1 != null) {
                            MelonAppBase.Companion.getClass();
                            t.a().getContext().sendBroadcast(intent1);
                        }
                        return H.a;
                    }
                    q.m("playerUseCase");
                    throw null;
                }
                q.m("playlistManager");
                throw null;
            }
            case 1: {
                d5.n.D(object0);
                goto label_23;
            }
            case 2: {
                z = this.r;
                d5.n.D(object0);
                goto label_34;
            }
            case 3: {
                z = this.r;
                d5.n.D(object0);
                goto label_41;
            }
            case 4: {
                d5.n.D(object0);
                goto label_48;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

