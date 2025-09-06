package Hc;

import com.iloen.melon.fragments.comments.CommentActionImplKt;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.SPAMINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.utils.Navigator;
import com.melon.ui.s4;
import ie.H;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;
import we.a;

public final class y implements a {
    public final int a;
    public final N b;
    public final String c;
    public final String d;
    public final CHNLINFO e;
    public final SPAMINFO f;
    public final Ua.a g;

    public y(N n0, String s, String s1, CHNLINFO loadPgnRes$result$CHNLINFO0, SPAMINFO loadPgnRes$result$SPAMINFO0, Ua.a a0, int v) {
        this.a = v;
        this.b = n0;
        this.c = s;
        this.d = s1;
        this.e = loadPgnRes$result$CHNLINFO0;
        this.f = loadPgnRes$result$SPAMINFO0;
        this.g = a0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            boolean z = ((e0)o.a()).m();
            N n0 = this.b;
            if(!z) {
                n0.d.invoke(s4.a);
                return H.a;
            }
            if(this.e != null && this.e.blindContsCmtWriteFlag) {
                n0.e(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                return H.a;
            }
            Ua.a a0 = this.g;
            if(this.f != null && this.f.breakmemberflag) {
                n0.h(a0.a);
                return H.a;
            }
            int v = this.c == null ? -1 : Integer.parseInt(this.c);
            result loadPgnRes$result0 = a0.a.result;
            q.f(loadPgnRes$result0, "result");
            Navigator.openCommentWrite$default(v, (this.d == null ? "" : this.d), CommentActionImplKt.toUiModel(loadPgnRes$result0), null, 0, 24, null);
            return H.a;
        }
        boolean z1 = ((e0)o.a()).m();
        N n1 = this.b;
        if(!z1) {
            n1.d.invoke(s4.a);
            return H.a;
        }
        if(this.e != null && this.e.blindContsCmtWriteFlag) {
            n1.e(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            return H.a;
        }
        Ua.a a1 = this.g;
        if(this.f != null && this.f.breakmemberflag) {
            n1.h(a1.a);
            return H.a;
        }
        int v1 = this.c == null ? -1 : Integer.parseInt(this.c);
        result loadPgnRes$result1 = a1.a.result;
        q.f(loadPgnRes$result1, "result");
        Navigator.openCommentWrite$default(v1, (this.d == null ? "" : this.d), CommentActionImplKt.toUiModel(loadPgnRes$result1), null, 0, 24, null);
        return H.a;
    }
}

