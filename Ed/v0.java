package ed;

import com.iloen.melon.net.v6x.response.SearchTagBase;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.SearchMainContentRes.TextOffering;
import ie.H;
import je.p;
import kotlin.jvm.internal.q;
import p8.g;
import we.n;

public final class v0 implements n {
    public final int a;
    public final F0 b;

    public v0(F0 f00, int v) {
        this.a = v;
        this.b = f00;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        F0 f00 = this.b;
        if(this.a != 0) {
            F0.d(f00, ((TextOffering)object0), ((int)(((Integer)object1))));
            return h0;
        }
        int v = (int)(((Integer)object1));
        q.g(((SearchTagBase)object0), "selectedKeyword");
        int v1 = f00.k.size();
        M0 m00 = (M0)p.s0(f00.k);
        String s = "";
        if(m00 instanceof K0) {
            String s1 = ((K0)m00).a.a;
            if(s1 != null) {
                s = s1;
            }
        }
        switch(v1) {
            case 1: {
                N0 n00 = f00.k();
                n00.getClass();
                String s2 = q.b(((SearchTagBase)object0).priorityYn, "Y") ? "1" : "0";
                g g0 = n00.a();
                g0.d = ActionKind.ClickContent;
                g0.a = "";
                g0.y = "";
                g0.H = "melon_recommend";
                g0.z = ((SearchTagBase)object0).tagType;
                g0.D = s2;
                g0.C = String.valueOf(v + 1);
                g0.F = ((SearchTagBase)object0).disPlayKeyword;
                g0.e = ((SearchTagBase)object0).disPlayKeyword;
                g0.f = "";
                g0.J = ((SearchTagBase)object0).rangeCode;
                g0.a().track();
                return h0;
            }
            case 2: {
                N0 n01 = f00.k();
                n01.getClass();
                g g1 = n01.a();
                g1.d = ActionKind.ClickContent;
                g1.a = "";
                g1.y = "";
                g1.z = s;
                g1.C = String.valueOf(v + 1);
                g1.F = ((SearchTagBase)object0).disPlayKeyword;
                g1.e = ((SearchTagBase)object0).disPlayKeyword;
                g1.f = "";
                g1.J = ((SearchTagBase)object0).rangeCode;
                g1.a().track();
                return h0;
            }
            case 3: {
                N0 n02 = f00.k();
                n02.getClass();
                g g2 = n02.a();
                g2.d = ActionKind.ClickContent;
                g2.a = "";
                g2.y = "";
                g2.z = s;
                g2.A = s;
                g2.C = String.valueOf(v + 1);
                g2.F = ((SearchTagBase)object0).disPlayKeyword;
                g2.e = ((SearchTagBase)object0).disPlayKeyword;
                g2.f = "";
                g2.J = ((SearchTagBase)object0).rangeCode;
                g2.a().track();
                return h0;
            }
            default: {
                return h0;
            }
        }
    }
}

