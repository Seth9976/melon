package zc;

import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHCHARTINFO;
import ie.H;
import w0.h;
import we.a;
import we.k;

public final class m implements a {
    public final int a;
    public final h b;
    public final GRAPHCHARTINFO c;
    public final k d;

    public m(h h0, GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO0, k k0, int v) {
        this.a = v;
        this.b = h0;
        this.c = graphDataListInfo$GRAPHCHARTINFO0;
        this.d = k0;
        super();
    }

    public m(h h0, k k0, GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO0, int v) {
        this.a = v;
        this.b = h0;
        this.d = k0;
        this.c = graphDataListInfo$GRAPHCHARTINFO0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO1 = this.c;
                if(graphDataListInfo$GRAPHCHARTINFO1 != null) {
                    k k1 = this.d;
                    if(k1 != null) {
                        k1.invoke(graphDataListInfo$GRAPHCHARTINFO1);
                    }
                }
                return H.a;
            }
            case 1: {
                h.a(this.b);
                GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO2 = this.c;
                if(graphDataListInfo$GRAPHCHARTINFO2 != null) {
                    k k2 = this.d;
                    if(k2 != null) {
                        k2.invoke(graphDataListInfo$GRAPHCHARTINFO2);
                    }
                }
                return H.a;
            }
            case 2: {
                h.a(this.b);
                GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO3 = this.c;
                if(graphDataListInfo$GRAPHCHARTINFO3 != null) {
                    k k3 = this.d;
                    if(k3 != null) {
                        k3.invoke(graphDataListInfo$GRAPHCHARTINFO3);
                    }
                }
                return H.a;
            }
            case 3: {
                h.a(this.b);
                k k4 = this.d;
                if(k4 != null) {
                    GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO4 = this.c;
                    if(graphDataListInfo$GRAPHCHARTINFO4 != null) {
                        k4.invoke(graphDataListInfo$GRAPHCHARTINFO4);
                    }
                }
                return H.a;
            }
            default: {
                h.a(this.b);
                k k0 = this.d;
                if(k0 != null) {
                    GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO0 = this.c;
                    if(graphDataListInfo$GRAPHCHARTINFO0 != null) {
                        k0.invoke(graphDataListInfo$GRAPHCHARTINFO0);
                    }
                }
                return H.a;
            }
        }
    }
}

