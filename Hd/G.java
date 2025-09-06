package hd;

import A8.L;
import A8.m;
import android.content.Context;
import com.iloen.melon.custom.l1;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;

public final class g implements a {
    public final int a;
    public final Context b;
    public final String c;
    public final Kd.g d;
    public final k e;

    public g(Context context0, String s, Kd.g g0, k k0, int v) {
        this.a = v;
        this.b = context0;
        this.c = s;
        this.d = g0;
        this.e = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            String s = l1.m("마이감상차트", "getString(...)", this.b, 0x7F130E76, "getString(...)");  // string:tiara_dna_copy_my_chart "감상차트"
            q.f("곡", "getString(...)");
            L l0 = new L("마이감상차트", null, this.c, s, this.d.a, "곡", this.d.b, null, 0x20B);
            Q q0 = new Q(this.d, l0);
            this.e.invoke(q0);
            return H.a;
        }
        String s1 = l1.m("마이감상차트", "getString(...)", this.b, 0x7F130E76, "getString(...)");  // string:tiara_dna_copy_my_chart "감상차트"
        q.f("앨범", "getString(...)");
        L l1 = new L("마이감상차트", null, this.c, s1, this.d.c, "앨범", this.d.d, null, 0x20B);
        O o0 = new O(new m(30, this.d.c, null, null, null), "ALBUM_THUMB", l1);
        this.e.invoke(o0);
        return H.a;
    }
}

