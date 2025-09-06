package kc;

import Ac.F2;
import Vb.d0;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playlist.b;
import ea.c;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import nc.D0;
import nc.u0;
import ne.a;
import oc.A;
import oc.J;
import oc.M;
import oc.Q;
import oc.w;
import oc.y;
import oc.z;
import oe.i;
import we.n;

public final class q extends i implements n {
    public PlaylistId B;
    public int D;
    public final PlaylistId E;
    public final PlaylistId G;
    public final w I;
    public final b M;
    public w r;
    public Object w;

    public q(PlaylistId playlistId0, PlaylistId playlistId1, w w0, b b0, Continuation continuation0) {
        this.E = playlistId0;
        this.G = playlistId1;
        this.I = w0;
        this.M = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        PlaylistId playlistId1;
        e e2;
        w w5;
        Object object4;
        w w4;
        A a1;
        w w3;
        Object object3;
        y y0;
        w w2;
        Object object2;
        w w1;
        PlaylistId playlistId0;
        b b0;
        w w0;
        a a0;
        try {
            a0 = a.a;
            w0 = this.I;
            b0 = this.M;
            playlistId0 = this.E;
            switch(this.D) {
                case 0: {
                    goto label_10;
                }
                case 1: {
                    goto label_23;
                }
                case 2: {
                    goto label_30;
                }
                case 3: {
                    goto label_35;
                }
                case 4: {
                    goto label_48;
                }
                case 5: {
                    goto label_58;
                }
                case 6: {
                    goto label_70;
                }
                case 7: {
                    goto label_80;
                }
                case 8: {
                    goto label_89;
                }
                case 9: {
                    goto label_105;
                }
                case 10: {
                    goto label_120;
                }
                case 11: {
                    goto label_6;
                }
                case 12: {
                    goto label_8;
                }
            }
        }
        catch(Exception exception0) {
            LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
            ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
            return false;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        try {
        label_6:
            d5.n.D(object0);
            return true;
        }
        catch(Exception exception0) {
            LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
            ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
            return false;
        }
    label_8:
        d5.n.D(object0);
        return true;
    label_10:
        d5.n.D(object0);
        if(playlistId0 == this.G) {
            e e0 = b0.t;
            if(e0 != null) {
                Q q0 = w0.getState();
                long v = w0.k();
                this.D = 12;
                if(((d0)e0).b(q0, v, true, this) == a0) {
                    return a0;
                    try {
                    label_23:
                        d5.n.D(object0);
                    label_24:
                        if(w0 instanceof J) {
                            ((J)w0).f();
                        }
                        if(w0 instanceof D0) {
                            this.D = 2;
                            if(((u0)(((D0)w0))).E(playlistId0, this) == a0) {
                                return a0;
                            }
                            goto label_31;
                        label_30:
                            d5.n.D(object0);
                        }
                    label_31:
                        this.D = 3;
                        Object object1 = b0.G(playlistId0, this);
                        if(object1 == a0) {
                            return a0;
                        }
                        goto label_37;
                    label_35:
                        d5.n.D(object0);
                        object1 = object0;
                    label_37:
                        w1 = (w)object1;
                        if(w1 instanceof y) {
                            F2 f20 = b0.c.n();
                            this.r = w1;
                            this.w = (y)w1;
                            this.D = 4;
                            object2 = FlowKt.first(f20, this);
                            if(object2 == a0) {
                                return a0;
                            }
                            w2 = w1;
                            y0 = (y)w1;
                            goto label_52;
                        }
                        goto label_60;
                    }
                    catch(Exception exception0) {
                        LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
                        ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
                        return false;
                    }
                label_48:
                    y0 = (y)this.w;
                    w2 = this.r;
                    try {
                        d5.n.D(object0);
                        object2 = object0;
                    label_52:
                        this.r = w2;
                        this.w = null;
                        this.D = 5;
                        if(y0.o(((M)object2), this) == a0) {
                            return a0;
                        }
                        w1 = w2;
                        goto label_60;
                    label_58:
                        w1 = this.r;
                        d5.n.D(object0);
                    label_60:
                        if(w1 instanceof A) {
                            F2 f21 = b0.c.o();
                            this.r = w1;
                            this.w = (A)w1;
                            this.D = 6;
                            object3 = FlowKt.first(f21, this);
                            if(object3 == a0) {
                                return a0;
                            }
                            w3 = w1;
                            a1 = (A)w1;
                            goto label_74;
                        }
                        goto label_82;
                    }
                    catch(Exception exception0) {
                        LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
                        ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
                        return false;
                    }
                label_70:
                    a1 = (A)this.w;
                    w3 = this.r;
                    try {
                        d5.n.D(object0);
                        object3 = object0;
                    label_74:
                        this.r = w3;
                        this.w = null;
                        this.D = 7;
                        if(a1.m(((Boolean)object3).booleanValue(), this) == a0) {
                            return a0;
                        }
                        w1 = w3;
                        goto label_82;
                    label_80:
                        w1 = this.r;
                        d5.n.D(object0);
                    label_82:
                        w4 = w1;
                        if(w4 instanceof J) {
                            ((J)w4).j(new c(12, b0, playlistId0));
                        }
                        b0.p.setValue(playlistId0);
                        if(playlistId0.isAudioType()) {
                            b0.q.setValue(playlistId0);
                        }
                        goto label_93;
                    }
                    catch(Exception exception0) {
                        LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
                        ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
                        return false;
                    }
                label_89:
                    MutableStateFlow mutableStateFlow0 = (MutableStateFlow)this.w;
                    w4 = this.r;
                    try {
                        d5.n.D(object0);
                        mutableStateFlow0.setValue(object0);
                    label_93:
                        e e1 = b0.t;
                        if(e1 != null) {
                            this.r = w4;
                            this.w = e1;
                            this.B = playlistId0;
                            this.D = 9;
                            object4 = w4.b(this);
                            if(object4 == a0) {
                                return a0;
                            }
                            w5 = w4;
                            e2 = e1;
                            playlistId1 = playlistId0;
                            goto label_113;
                        }
                        goto label_121;
                    }
                    catch(Exception exception0) {
                        LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
                        ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
                        return false;
                    }
                label_105:
                    PlaylistId playlistId2 = this.B;
                    e e3 = (e)this.w;
                    w w6 = this.r;
                    try {
                        d5.n.D(object0);
                        w5 = w6;
                        e2 = e3;
                        playlistId1 = playlistId2;
                        object4 = object0;
                    label_113:
                        long v1 = w5.k();
                        this.r = null;
                        this.w = null;
                        this.B = null;
                        this.D = 10;
                        if(((d0)e2).c(playlistId1, ((Q)object4), v1, this) == a0) {
                            return a0;
                        label_120:
                            d5.n.D(object0);
                        }
                    label_121:
                        this.r = null;
                        this.w = null;
                        this.D = 11;
                        H h0 = BuildersKt.withContext(Dispatchers.getIO(), new c2(playlistId0, null), this);
                        if(h0 != a0) {
                            h0 = H.a;
                        }
                    }
                    catch(Exception exception0) {
                        LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
                        ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
                        return false;
                    }
                    if(h0 == a0) {
                        return a0;
                    }
                }
            }
        }
        else {
            try {
                if(w0 instanceof z) {
                    this.D = 1;
                    if(((z)w0).t(this) != a0) {
                        goto label_24;
                    }
                    return a0;
                }
                else {
                    goto label_24;
                }
                return true;
            }
            catch(Exception exception0) {
                LogU.error$default(b0.l, "changePlaylistInternal failed. - " + exception0.getMessage(), null, false, 6, null);
                ToastManager.debug(("changePlaylistInternal invalid playlist id " + playlistId0));
                return false;
            }
            goto label_24;
        }
        return true;
    }
}

