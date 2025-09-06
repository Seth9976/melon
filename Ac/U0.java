package Ac;

import A0.c;
import A9.a;
import Cc.c1;
import De.I;
import E9.h;
import F8.o;
import J8.U0;
import J8.b;
import M.j0;
import O.F;
import Ud.j;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.ComposeView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.k1;
import d3.g;
import ie.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import va.e;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LAc/u0;", "Lcom/melon/ui/o1;", "LAc/G0;", "LJ8/U0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class u0 extends u4 {
    public final LogU d;
    public final r e;
    public SearchBarView f;

    public u0() {
        LogU logU0 = new LogU("CommentAttachVideoFragment");
        logU0.setCategory(Category.UI);
        this.d = logU0;
        this.e = g.Q(new a(3));
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02A4, null, false);  // layout:fragment_comment_attach_video
        int v = 0x7F0A0309;  // id:compose_view
        ComposeView composeView0 = (ComposeView)I.C(view0, 0x7F0A0309);  // id:compose_view
        if(composeView0 != null) {
            v = 0x7F0A0A37;  // id:search_bar_container
            View view1 = I.C(view0, 0x7F0A0A37);  // id:search_bar_container
            if(view1 != null) {
                SearchBarView searchBarView0 = (SearchBarView)I.C(view1, 0x7F0A0A36);  // id:search_bar
                if(searchBarView0 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(0x7F0A0A36));  // id:search_bar
                }
                b b0 = new b(((RelativeLayout)view1), searchBarView0, 7);
                View view2 = I.C(view0, 0x7F0A0BAE);  // id:titlebar_container
                if(view2 != null) {
                    return new U0(((LinearLayoutCompat)view0), composeView0, b0, new b(((TitleBar)view2), ((TitleBar)view2), 12));
                }
                v = 0x7F0A0BAE;  // id:titlebar_container
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return G0.class;
    }

    public final void n(F f0, List list0, l l0, int v) {
        ((p)l0).c0(0xDEE522F2);
        int v1 = v | (((p)l0).g(f0) ? 4 : 2) | (((p)l0).i(list0) ? 0x20 : 16) | (((p)l0).i(this) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, h.t(((p)l0), 0x7F070057), 7);  // dimen:bottom_tab_height
            boolean z = ((p)l0).i(list0);
            boolean z1 = ((p)l0).i(this);
            D d0 = ((p)l0).N();
            if(z || z1 || d0 == k.a) {
                d0 = new D(2, list0, this);
                ((p)l0).l0(d0);
            }
            c1.o(null, f0, j00, false, null, null, null, false, d0, ((p)l0), v1 << 3 & 0x70, 0xF9);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new E(this, f0, list0, v, 1);
        }
    }

    public final void o() {
        com.melon.ui.n0 n00 = this.getViewModel();
        LogU.debug$default(((G0)n00).d, e.b("searchKeyword() keyword : ", ((G0)n00).f), null, false, 6, null);
        ((G0)n00).e = ((G0)n00).f;
        this.p();
        LogU.debug$default(((G0)n00).d, e.b("startFetch() reason : searchKeyword, keyword : ", ((G0)n00).f), null, false, 6, null);
        if(((G0)n00).f.length() == 0) {
            ((G0)n00).c.a(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
        }
        k1.startFetch$default(((G0)n00), true, null, null, 6, null);
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        SearchBarView searchBarView0 = this.f;
        if(searchBarView0 != null) {
            searchBarView0.a();
        }
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof z4) {
            this.o();
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        U0 u00 = (U0)this.getBinding();
        if(u00 == null) {
            return;
        }
        o o0 = B.a.s(1);
        ((TitleBar)u00.d.c).a(o0);
        String s = this.getString(0x7F1301EF);  // string:cmt_video_attachment_title "비디오첨부"
        ((TitleBar)u00.d.c).setTitle(s);
        ((TitleBar)u00.d.c).f(true);
        j j0 = (j)this.e.getValue();
        U u0 = new U(this, 2);
        j.a(j0, ((TitleBar)u00.d.c), u0);
        this.f = (SearchBarView)u00.c.c;
        c c0 = new c(this, 4);
        ((SearchBarView)u00.c.c).setOnSearchBarListener(c0);
        this.p();
    }

    public final void p() {
        SearchBarView searchBarView0 = this.f;
        if(searchBarView0 != null) {
            searchBarView0.setInputText(((G0)this.getViewModel()).e);
            searchBarView0.a();
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        U0 u00 = (U0)this.getBinding();
        if(u00 == null) {
            return;
        }
        m0.b b0 = new m0.b(0xD0DF7A78, new z(k40, this, 7), true);
        u00.b.setContent(b0);
    }
}

