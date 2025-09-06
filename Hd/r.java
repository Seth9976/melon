package hd;

import A8.L;
import A8.m;
import android.content.Context;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import com.iloen.melon.custom.l1;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.kakao.tiara.data.Meta;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.LIKETOPINFO.LIKEIMGINFO;
import java.util.List;
import jd.q2;
import jd.t2;
import kotlin.jvm.internal.q;
import w0.h;
import we.a;
import we.k;

public final class r implements a {
    public final int a;
    public final h b;
    public final Object c;
    public final k d;
    public final Context e;
    public final Object f;
    public final Object g;

    public r(h h0, Object object0, k k0, Context context0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = h0;
        this.c = object0;
        this.d = k0;
        this.e = context0;
        this.f = object1;
        this.g = object2;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                LIKEIMGINFO musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0 = (LIKEIMGINFO)this.c;
                if(musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.isService) {
                    String s = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.likeScheme;
                    q.f(s, "likeScheme");
                    m m0 = new m(23, null, null, null, s);
                    String s1 = l1.m("월간Log", "getString(...)", this.e, 0x7F130E6D, "getString(...)");  // string:tiara_dna_copy_like_card "좋아요 카드"
                    String s2 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.id;
                    q.f(s2, "id");
                    String s3 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.contsTypeCode;
                    q.f(s3, "contsTypeCode");
                    Object object0 = H.A(s3) ? this.f : this.g;
                    String s4 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0.name;
                    q.f(s4, "name");
                    O o0 = new O(m0, "SCHEME_BTN", new L("월간Log", null, "1", s1, s2, ((String)object0), s4, null, 0x20B));
                    this.d.invoke(o0);
                }
                return ie.H.a;
            }
            case 1: {
                h.a(this.b);
                LIKEIMGINFO musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO1 = (LIKEIMGINFO)this.c;
                if(musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO1.isService) {
                    String s5 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO1.likeScheme;
                    q.f(s5, "likeScheme");
                    m m1 = new m(23, null, null, null, s5);
                    String s6 = l1.m("월간Log", "getString(...)", this.e, 0x7F130E6D, "getString(...)");  // string:tiara_dna_copy_like_card "좋아요 카드"
                    String s7 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO1.id;
                    q.f(s7, "id");
                    String s8 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO1.contsTypeCode;
                    q.f(s8, "contsTypeCode");
                    Object object1 = H.A(s8) ? this.f : this.g;
                    String s9 = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO1.name;
                    q.f(s9, "name");
                    O o1 = new O(m1, "SCHEME_BTN", new L("월간Log", null, "2", s6, s7, ((String)object1), s9, null, 0x20B));
                    this.d.invoke(o1);
                }
                return ie.H.a;
            }
            default: {
                h.a(this.b);
                Boolean boolean0 = Boolean.valueOf(!((Boolean)((b0)this.c).getValue()).booleanValue());
                ((b0)this.c).setValue(boolean0);
                Builder meta$Builder0 = new Builder();
                int v = ((K0)(((a0)this.g))).m();
                Meta meta0 = meta$Builder0.id(((jd.a)((List)((q2)this.f).b).get(v)).a).type("이미지").build();
                t2 t20 = new t2(ActionKind.ClickContent, "선택", "이미지뷰어", "뷰어이미지", meta0);
                this.d.invoke(t20);
                return ie.H.a;
            }
        }
    }
}

