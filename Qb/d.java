package qb;

import M6.B;
import com.iloen.melon.playback.playlist.PlaylistId;
import d5.n;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import td.Y0;
import td.t1;
import we.o;
import x9.c;

public final class d extends i implements o {
    public FlowCollector B;
    public Object D;
    public final Object E;
    public Object G;
    public Object I;
    public final int r;
    public int w;

    public d(String s, Continuation continuation0, H h0, c c0) {
        this.r = 0;
        this.E = h0;
        this.G = s;
        this.I = c0;
        super(3, continuation0);
    }

    public d(Continuation continuation0, t1 t10) {
        this.r = 1;
        this.E = t10;
        super(3, continuation0);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.r != 0) {
            d d0 = new d(((Continuation)object2), ((t1)this.E));
            d0.B = (FlowCollector)object0;
            d0.D = object1;
            return d0.invokeSuspend(ie.H.a);
        }
        d d1 = new d(((String)this.G), ((Continuation)object2), ((H)this.E), ((c)this.I));
        d1.B = (FlowCollector)object0;
        d1.D = object1;
        return d1.invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        FlowCollector flowCollector1;
        PlaylistId playlistId0;
        if(this.r != 0) {
            t1 t10 = (t1)this.E;
            a a0 = a.a;
            switch(this.w) {
                case 0: {
                    n.D(object0);
                    FlowCollector flowCollector0 = this.B;
                    playlistId0 = (PlaylistId)this.D;
                    B b0 = ((d3)t10.c).p(playlistId0);
                    this.B = null;
                    this.D = null;
                    this.G = flowCollector0;
                    this.I = playlistId0;
                    this.w = 1;
                    Object object1 = ListenableFutureKt.await(b0, this);
                    if(object1 != a0) {
                        flowCollector1 = flowCollector0;
                        object0 = object1;
                        goto label_24;
                    }
                    break;
                }
                case 1: {
                    playlistId0 = (PlaylistId)this.I;
                    flowCollector1 = (FlowCollector)this.G;
                    n.D(object0);
                label_24:
                    Flow flow0 = FlowKt.mapLatest(((oc.H)object0).d(), new Y0(t10, playlistId0, null));
                    this.B = null;
                    this.D = null;
                    this.G = null;
                    this.I = null;
                    this.w = 2;
                    if(FlowKt.emitAll(flowCollector1, flow0, this) != a0) {
                        return ie.H.a;
                    }
                    break;
                }
                case 2: {
                    n.D(object0);
                    return ie.H.a;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return a0;
        }
        a a1 = a.a;
        switch(this.w) {
            case 0: {
                n.D(object0);
                FlowCollector flowCollector2 = this.B;
                Flow flow1 = FlowKt.flow(new e(((bb.o)this.D), ((H)this.E), ((String)this.G), ((c)this.I), null));
                this.B = null;
                this.D = null;
                this.w = 1;
                return FlowKt.emitAll(flowCollector2, flow1, this) != a1 ? ie.H.a : a1;
            }
            case 1: {
                n.D(object0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

