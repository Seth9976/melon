package hd;

import A8.L;
import A8.m;
import android.content.Context;
import com.iloen.melon.custom.l1;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.LIKETOPINFO.LIKEIMGINFO;
import kotlin.jvm.internal.q;
import w0.h;
import we.a;
import we.k;

public final class p implements a {
    public final int a;
    public final h b;
    public final boolean c;
    public final k d;
    public final LIKEIMGINFO e;
    public final Context f;
    public final String g;
    public final String h;

    public p(h h0, boolean z, k k0, LIKEIMGINFO musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0, Context context0, String s, String s1, int v) {
        this.a = v;
        this.b = h0;
        this.c = z;
        this.d = k0;
        this.e = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0;
        this.f = context0;
        this.g = s;
        this.h = s1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        String s1;
        if(this.a != 0) {
            h.a(this.b);
            if(this.c) {
                LIKEIMGINFO musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0 = this.e;
                if(musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0 == null) {
                    s1 = "";
                }
                else {
                    String s = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.likeScheme;
                    s1 = s == null ? "" : s;
                }
                m m0 = new m(23, null, null, null, s1);
                String s2 = l1.m("월간Log", "getString(...)", this.f, 0x7F130E6D, "getString(...)");  // string:tiara_dna_copy_like_card "좋아요 카드"
                String s3 = null;
                String s4 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0 == null ? null : musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.id;
                String s5 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0 == null ? null : musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.contsTypeCode;
                if(s5 == null) {
                    s5 = "";
                }
                String s6 = H.A(s5) ? this.g : this.h;
                if(musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0 != null) {
                    s3 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.name;
                }
                O o0 = new O(m0, "SCHEME_BTN", new L("월간Log", null, "3", s2, (s4 == null ? "" : s4), s6, (s3 == null ? "" : s3), null, 0x20B));
                this.d.invoke(o0);
            }
            return ie.H.a;
        }
        h.a(this.b);
        if(this.c) {
            String s7 = this.e.likeScheme;
            q.f(s7, "likeScheme");
            m m1 = new m(23, null, null, null, s7);
            String s8 = l1.m("월간Log", "getString(...)", this.f, 0x7F130E6D, "getString(...)");  // string:tiara_dna_copy_like_card "좋아요 카드"
            String s9 = this.e.id;
            q.f(s9, "id");
            String s10 = this.e.contsTypeCode;
            q.f(s10, "contsTypeCode");
            String s11 = H.A(s10) ? this.g : this.h;
            String s12 = this.e.name;
            q.f(s12, "name");
            O o1 = new O(m1, "SCHEME_BTN", new L("월간Log", null, "1", s8, s9, s11, s12, null, 0x20B));
            this.d.invoke(o1);
        }
        return ie.H.a;
    }
}

