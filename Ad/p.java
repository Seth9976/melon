package ad;

import Gd.F;
import Vb.i;
import Vb.p0;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ViewImpContent;
import d3.g;
import e1.n;
import ie.r;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import p8.s;
import q8.c;
import q8.f;
import q8.h;

public final class p {
    public String a;
    public s b;
    public final r c;

    public p() {
        new HashMap();
        this.c = g.Q(new i(8));
    }

    public final Uc.p a(String s, StatsElementsBase statsElementsBase0, int v, ActionKind actionKind0, String s1, int v1, int v2, String s2, boolean z, boolean z1) {
        q.g(s, "layer1");
        String s3 = null;
        Uc.p p0 = new Uc.p(s, actionKind0, v, this.b, (this.b == null ? null : this.b.c), this.a);
        if(s1 != null) {
            ((h)p0.b).a = s1;
        }
        p0.b(new o(statsElementsBase0, v2, v1, z1, 0));
        p0.e(new F(z, statsElementsBase0, s2, 5));
        LinkedHashMap linkedHashMap0 = (LinkedHashMap)p0.g;
        c c0 = new c();
        if(statsElementsBase0 != null) {
            s3 = statsElementsBase0.rangeCode;
        }
        if(s3 == null) {
            s3 = "";
        }
        c0.a.put("Rangecode", s3);
        linkedHashMap0.putAll(c0.a);
        return p0;
    }

    public static Uc.p b(p p0, String s, StatsElementsBase statsElementsBase0, int v, ActionKind actionKind0, String s1, boolean z, boolean z1, int v1) {
        String s2 = (v1 & 16) == 0 ? s1 : null;
        boolean z2 = (v1 & 0x100) == 0 ? z : true;
        return (v1 & 0x200) == 0 ? p0.a(s, statsElementsBase0, v, actionKind0, s2, -1, -1, null, z2, z1) : p0.a(s, statsElementsBase0, v, actionKind0, s2, -1, -1, null, z2, true);
    }

    public final void c(int v, String s) {
        q.g(s, "id");
        q8.i i0 = new q8.i();
        i0.h = "melon_recommend";
        i0.d = String.valueOf(v + 1);
        i0.i = "";
        i0.b = s;
        this.e(i0.build());
    }

    public final void d(String s, String s1, String s2) {
        q.g(s, "clickCopy");
        Uc.p p0 = new Uc.p("", null, 0, this.b, (this.b == null ? null : this.b.c), this.a);
        p0.b(new Nb.i(s1, s, 1));
        f f0 = (f)p0.e;
        if(f0 == null) {
            f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
            f1.a = s2;
            p0.e = f1;
        }
        else {
            f0.a = s2;
        }
        p0.p().track();
    }

    public final void e(ViewImpContent viewImpContent0) {
        n.D(new p0(4, this, viewImpContent0)).track();
    }
}

