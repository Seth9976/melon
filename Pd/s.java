package pd;

import D2.S;
import X.k;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;
import ne.a;
import pc.h0;

public final class s implements Flow {
    public final int a;
    public final Object b;

    public s(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector0, Continuation continuation0) {
        switch(this.a) {
            case 0: {
                h0 h00 = new h0(flowCollector0, 2);
                H h1 = ((Flow)this.b).collect(h00, continuation0);
                return h1 == a.a ? h1 : H.a;
            }
            case 1: {
                h0 h01 = new h0(flowCollector0, 3);
                H h2 = ((Flow)this.b).collect(h01, continuation0);
                return h2 == a.a ? h2 : H.a;
            }
            case 2: {
                h0 h02 = new h0(flowCollector0, 4);
                H h3 = ((Flow)this.b).collect(h02, continuation0);
                return h3 == a.a ? h3 : H.a;
            }
            case 3: {
                h0 h03 = new h0(flowCollector0, 5);
                H h4 = ((Flow)this.b).collect(h03, continuation0);
                return h4 == a.a ? h4 : H.a;
            }
            case 4: {
                h0 h04 = new h0(flowCollector0, 6);
                H h5 = ((Flow)this.b).collect(h04, continuation0);
                return h5 == a.a ? h5 : H.a;
            }
            case 5: {
                h0 h05 = new h0(flowCollector0, 7);
                H h6 = ((Flow)this.b).collect(h05, continuation0);
                return h6 == a.a ? h6 : H.a;
            }
            case 6: {
                h0 h06 = new h0(flowCollector0, 8);
                H h7 = ((Flow)this.b).collect(h06, continuation0);
                return h7 == a.a ? h7 : H.a;
            }
            case 7: {
                h0 h07 = new h0(flowCollector0, 9);
                H h8 = ((Flow)this.b).collect(h07, continuation0);
                return h8 == a.a ? h8 : H.a;
            }
            case 8: {
                h0 h08 = new h0(flowCollector0, 10);
                H h9 = ((Flow)this.b).collect(h08, continuation0);
                return h9 == a.a ? h9 : H.a;
            }
            case 9: {
                h0 h09 = new h0(flowCollector0, 11);
                H h10 = ((Flow)this.b).collect(h09, continuation0);
                return h10 == a.a ? h10 : H.a;
            }
            case 10: {
                h0 h010 = new h0(flowCollector0, 12);
                H h11 = ((Flow)this.b).collect(h010, continuation0);
                return h11 == a.a ? h11 : H.a;
            }
            case 11: {
                h0 h011 = new h0(flowCollector0, 13);
                H h12 = ((Flow)this.b).collect(h011, continuation0);
                return h12 == a.a ? h12 : H.a;
            }
            case 12: {
                h0 h012 = new h0(flowCollector0, 14);
                H h13 = ((Flow)this.b).collect(h012, continuation0);
                return h13 == a.a ? h13 : H.a;
            }
            case 13: {
                h0 h013 = new h0(flowCollector0, 15);
                H h14 = ((Flow)this.b).collect(h013, continuation0);
                return h14 == a.a ? h14 : H.a;
            }
            case 14: {
                h0 h014 = new h0(flowCollector0, 16);
                H h15 = ((Flow)this.b).collect(h014, continuation0);
                return h15 == a.a ? h15 : H.a;
            }
            case 15: {
                h0 h015 = new h0(flowCollector0, 17);
                H h16 = ((Flow)this.b).collect(h015, continuation0);
                return h16 == a.a ? h16 : H.a;
            }
            case 16: {
                h0 h016 = new h0(flowCollector0, 18);
                H h17 = ((Flow)this.b).collect(h016, continuation0);
                return h17 == a.a ? h17 : H.a;
            }
            case 17: {
                h0 h017 = new h0(flowCollector0, 19);
                H h18 = ((Flow)this.b).collect(h017, continuation0);
                return h18 == a.a ? h18 : H.a;
            }
            default: {
                k k0 = new k(((Flow[])this.b), 2);
                S s0 = new S(3, null);
                H h0 = CombineKt.combineInternal(flowCollector0, ((Flow[])this.b), k0, s0, continuation0);
                return h0 == a.a ? h0 : H.a;
            }
        }
    }
}

