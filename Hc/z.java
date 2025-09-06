package Hc;

import Dd.g2;
import Jc.e;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result.CMTLIST;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.SPAMINFO;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import p8.f;
import we.a;

public final class z implements a {
    public final boolean a;
    public final N b;
    public final boolean c;
    public final SPAMINFO d;
    public final Ua.a e;
    public final CHNLINFO f;
    public final String g;
    public final CMTLIST h;

    public z(boolean z, N n0, boolean z1, SPAMINFO loadPgnRes$result$SPAMINFO0, Ua.a a0, CHNLINFO loadPgnRes$result$CHNLINFO0, String s, CMTLIST listCmtRes$result$CMTLIST0) {
        this.a = z;
        this.b = n0;
        this.c = z1;
        this.d = loadPgnRes$result$SPAMINFO0;
        this.e = a0;
        this.f = loadPgnRes$result$CHNLINFO0;
        this.g = s;
        this.h = listCmtRes$result$CMTLIST0;
    }

    @Override  // we.a
    public final Object invoke() {
        N n0 = this.b;
        CMTLIST listCmtRes$result$CMTLIST0 = this.h;
        int v = -1;
        if(this.a) {
            String s = n0.f(this.c);
            f f0 = n0.j;
            if(f0 != null) {
                f0.a = n0.e(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.F = n0.e(0x7F130D17);  // string:tiara_click_copy_comment_reply "답글"
                int v1 = listCmtRes$result$CMTLIST0.cmtinfo.cmtseq;
                if(v1 > -1) {
                    f0.e = String.valueOf(v1);
                }
                f0.y = s;
                f0.a().track();
            }
        }
        Ua.a a0 = this.e;
        if(this.d != null && this.d.breakmemberflag) {
            n0.h(a0.a);
            return H.a;
        }
        g2 g20 = n0.d;
        CHNLINFO loadPgnRes$result$CHNLINFO0 = this.f;
        if(loadPgnRes$result$CHNLINFO0 != null) {
            v = loadPgnRes$result$CHNLINFO0.chnlseq;
        }
        g20.invoke(new e(v, this.g, a0.a, listCmtRes$result$CMTLIST0.cmtinfo.cmtseq));
        return H.a;
    }
}

