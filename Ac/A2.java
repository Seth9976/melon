package Ac;

import E9.w;
import Pc.d;
import Pc.e;
import W.p;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.interfaces.StringProviderImpl;
import ie.H;
import p8.s;
import we.k;

public final class a2 implements k {
    public final int a;
    public final k b;
    public final p c;
    public final g2 d;
    public final d e;
    public final e f;

    public a2(k k0, p p0, g2 g20, d d0, e e0, int v) {
        this.a = v;
        this.b = k0;
        this.c = p0;
        this.d = g20;
        this.e = d0;
        this.f = e0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            this.b.invoke(((V3)object0));
            s s0 = (s)this.c.a;
            CommentConfig commentConfig0 = this.d.d;
            String s1 = ((StringProviderImpl)this.e).a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
            String s2 = (String)this.c.b;
            String s3 = ((StringProviderImpl)this.e).a(0x7F130D8B);  // string:tiara_click_copy_recommend "추천"
            w.G(s0, commentConfig0, ((StringProviderImpl)this.e), s1, ActionKind.Like, s2, s3, false, String.valueOf(((L1)this.f).b.getCommentSeq()), null, ((L1)this.f).b.getUserNickname());
            return H.a;
        }
        this.b.invoke(((V3)object0));
        s s4 = (s)this.c.a;
        CommentConfig commentConfig1 = this.d.d;
        String s5 = ((StringProviderImpl)this.e).a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        String s6 = (String)this.c.b;
        String s7 = ((StringProviderImpl)this.e).a(0x7F130D8B);  // string:tiara_click_copy_recommend "추천"
        w.G(s4, commentConfig1, ((StringProviderImpl)this.e), s5, ActionKind.Like, s6, s7, true, String.valueOf(((N1)this.f).b.getCommentSeq()), null, ((N1)this.f).b.getUserNickname());
        return H.a;
    }
}

