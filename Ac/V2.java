package Ac;

import Cc.c1;
import De.I;
import E9.h;
import J8.b;
import J8.t;
import J8.u;
import M.j0;
import O.F;
import Ud.j;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.comments.CommentInputPopup;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.e;
import d3.g;
import ie.r;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import we.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000B²\u0006\f\u0010\t\u001A\u00020\b8\nX\u008A\u0084\u0002²\u0006\f\u0010\n\u001A\u00020\b8\nX\u008A\u0084\u0002"}, d2 = {"LAc/v2;", "LAc/N0;", "LAc/N2;", "LJ8/t;", "Lcom/melon/ui/a;", "", "<init>", "()V", "", "isFirst", "offSetZero", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class v2 extends v4 implements a {
    public final e f;
    public final O3 g;
    public final LogU h;
    public final r i;
    public CommentInputPopup j;
    public final t2 k;

    public v2() {
        this.f = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = new O3();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = new LogU("CommentInfoFragment");
        logU0.setCategory(Category.UI);
        this.h = logU0;
        this.i = g.Q(new A9.a(5));
        this.k = new t2(this);
    }

    @Override  // com.melon.ui.o1
    public final String getPvDummyLogAction() {
        return "reply";
    }

    @Override  // com.melon.ui.o1
    public final Map getPvDummyLogParams() {
        Map map0 = new HashMap();
        map0.put("type", "view");
        map0.put("chnlSeq", String.valueOf(((N2)this.getViewModel()).d()));
        map0.put("contsRefValue", ((N2)this.getViewModel()).f());
        map0.put("cmtSeq", String.valueOf(((N2)this.getViewModel()).e()));
        return map0;
    }

    @Override  // com.melon.ui.c0
    public final boolean getShouldIgnoreSetUIOnForegroundEvent() {
        return this.getParentFragment() instanceof a9.a;
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D018C, null, false);  // layout:comment_info_fragment
        int v = 0x7F0A02F8;  // id:comment_input_layout
        View view1 = I.C(view0, 0x7F0A02F8);  // id:comment_input_layout
        if(view1 != null) {
            u u0 = u.a(view1);
            int v1 = 0x7F0A0309;  // id:compose_view
            ComposeView composeView0 = (ComposeView)I.C(view0, 0x7F0A0309);  // id:compose_view
            if(composeView0 != null) {
                v1 = 0x7F0A0BAE;  // id:titlebar_container
                View view2 = I.C(view0, 0x7F0A0BAE);  // id:titlebar_container
                if(view2 != null) {
                    return new t(((LinearLayoutCompat)view0), u0, composeView0, new b(((TitleBar)view2), ((TitleBar)view2), 12));
                }
            }
            v = v1;
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return N2.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.f.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void o(r0.q q0, F f0, O2 o20, List list0, k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1002618027);
        int v1 = v | (p0.g(f0) ? 0x20 : 16) | (p0.i(o20) ? 0x100 : 0x80) | (p0.i(list0) ? 0x800 : 0x400) | (p0.i(k0) ? 0x4000 : 0x2000) | (p0.i(this) ? 0x20000 : 0x10000);
        boolean z = false;
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = w.i(new M(f0, 2));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = w.i(new M(f0, 3));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.getClass();
            Boolean boolean1 = (Boolean)e1.getValue();
            boolean1.getClass();
            if((0xE000 & v1) == 0x4000) {
                z = true;
            }
            n2 n20 = p0.N();
            if(z || n20 == v2) {
                n20 = new n2(k0, e0, e1, null);
                p0.l0(n20);
            }
            J.f(boolean0, boolean1, n20, p0);
            r0.q q1 = androidx.compose.foundation.layout.a.n(q0, 0.0f, 6.0f, 0.0f, 0.0f, 13);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = p0.i(o20);
            boolean z2 = p0.i(list0);
            boolean z3 = p0.i(this);
            m2 m20 = p0.N();
            if((z1 | z2 | z3) != 0 || m20 == v2) {
                m20 = new m2(list0, o20, this, 0);
                p0.l0(m20);
            }
            c1.o(q1, f0, j00, false, null, null, null, false, m20, p0, v1 & 0x70, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new h2(this, q0, f0, o20, list0, k0, v);
        }
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        CommentInputPopup commentInputPopup0 = this.j;
        if(commentInputPopup0 != null) {
            commentInputPopup0.dismiss();
        }
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        LogU.debug$default(this.h, "CommentInfoFragment onUiEvent: " + i40, null, false, 6, null);
        Editable editable0 = null;
        if(i40 instanceof y1) {
            this.p(this.getChildFragmentManager(), ((B1)i40), new o2(1, this, v2.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 2), null);
        }
        else if(i40 instanceof U1) {
            t t0 = (t)this.getBinding();
            if(t0 != null) {
                editable0 = ((MelonEditText)t0.b.d).getText();
            }
            CommentInputPopup commentInputPopup0 = this.j;
            if(commentInputPopup0 != null) {
                commentInputPopup0.setInputText(editable0);
                commentInputPopup0.show();
            }
        }
        else if(i40 instanceof A1) {
            this.p(this.requireActivity().getSupportFragmentManager(), ((B1)i40), new o2(1, this, v2.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 3), this.getParentFragmentManager());
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        t t0 = (t)this.getBinding();
        if(t0 == null) {
            return;
        }
        TitleBar titleBar0 = (TitleBar)t0.d.c;
        if(this.getParentFragment() instanceof a9.a) {
            titleBar0.setPadding(0, ScreenUtils.dipToPixel(this.requireContext(), 6.0f), 0, 0);
            titleBar0.c(60.0f);
            q.f("답글", "getString(...)");
            titleBar0.a(new F8.q("답글"));
        }
        else {
            titleBar0.a(B.a.s(2));
            titleBar0.setTitle(this.getString(0x7F1308CF));  // string:reply_text "답글"
        }
        titleBar0.f(false);
        j.a(((j)this.i.getValue()), titleBar0, new U(this, 3));
        CommentConfig commentConfig0 = ((N2)this.getViewModel()).b.d;
        String s = commentConfig0 == null ? null : commentConfig0.getReplyPlaceholder();
        if(s == null || s.length() == 0) {
            s = null;
        }
        if(s == null) {
            s = this.getString(0x7F130022);  // string:adcmt_write_hint_msg "답글을 입력해주세요."
            q.f(s, "getString(...)");
        }
        t t1 = (t)this.getBinding();
        if(t1 != null) {
            ((MelonEditText)t1.b.d).setHint(s);
            j2 j20 = new j2(this, 0);
            x1.a.N(((MelonEditText)t1.b.d), j20);
        }
        t t2 = (t)this.getBinding();
        x1.a.N((t2 == null ? null : ((MelonTextView)t2.b.b)), new j2(this, 1));
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        t t3 = (t)this.getBinding();
        CommentInputPopup commentInputPopup0 = new CommentInputPopup(context0, (t3 == null ? null : ((MelonEditText)t3.b.d).getText()), this.k, false);
        this.j = commentInputPopup0;
        commentInputPopup0.setHint(0x7F130022);  // string:adcmt_write_hint_msg "답글을 입력해주세요."
        CommentInputPopup commentInputPopup1 = this.j;
        if(commentInputPopup1 != null) {
            commentInputPopup1.setOnShowListener(new k2(this, 0));
        }
        CommentInputPopup commentInputPopup2 = this.j;
        if(commentInputPopup2 != null) {
            commentInputPopup2.setOnDismissListener(new l2(this, 0));
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new s2(this, null), 3, null);
    }

    public final void p(l0 l00, B1 b10, k k0, l0 l01) {
        q.g(b10, "uiEvent");
        this.g.b(l00, b10, k0, l01);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        t t0 = (t)this.getBinding();
        if(t0 == null) {
            return;
        }
        m0.b b0 = new m0.b(0xC5C2ABFC, new z(k40, this, 8), true);
        t0.c.setContent(b0);
    }

    @Override  // com.melon.ui.c0
    public final void setShouldIgnoreSetUIOnForegroundEvent(boolean z) {
    }
}

