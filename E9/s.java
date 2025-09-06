package E9;

import U4.x;
import i.n.i.b.a.s.e.Sd;
import i.n.i.b.a.s.e.Z;

public final class s {
    public final com.kakaoent.leonplayer.core.LeonPlayerImpl.1.9 a;

    public s(com.kakaoent.leonplayer.core.LeonPlayerImpl.1.9 leonPlayerImpl$1$90) {
        this.a = leonPlayerImpl$1$90;
    }

    public static b a(Sd sd0) {
        return new b(sd0.a.b, sd0.e, sd0.f);
    }

    public static c b(Z z0) {
        int v = z0.a;
        int v1 = 1;
        switch(v) {
            case 0: {
                v = 0;
                break;
            }
            case 1: {
                v = 1;
                break;
            }
            case 2: {
                v = 2;
                break;
            }
            case 3: {
                v = 3;
                break;
            }
            case 4: {
                v = 4;
                break;
            }
            case 5: {
                v = 5;
                break;
            }
            case 6: {
                v = 6;
                break;
            }
            default: {
                if(v < 10000) {
                    x.u(v, "unknown exo data type ", "AnalyticsProxy");
                    v = 0;
                }
            }
        }
        int v2 = z0.b;
        switch(v2) {
            case -1: {
                v1 = -1;
                break;
            }
            case 0: {
                return new c(v, 0, z0.e);
            }
            case 1: {
                break;
            }
            case 2: {
                return new c(v, 2, z0.e);
            }
            case 5: {
                return new c(v, 4, z0.e);
            }
            default: {
                if(v2 != 7) {
                    if(v2 >= 10000) {
                        return new c(v, v2, z0.e);
                    }
                    x.u(v2, "unknown exo track type ", "AnalyticsProxy");
                }
                return new c(v, 5, z0.e);
            }
        }
        return new c(v, v1, z0.e);
    }
}

