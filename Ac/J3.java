package Ac;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import E9.h;
import F8.O;
import F8.o;
import F8.x;
import J8.b;
import J8.u;
import J8.v;
import M.j0;
import M.p0;
import O.F;
import P0.i;
import Ud.j;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.compose.foundation.y;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.ComposeView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.comments.CommentInputPopup;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.s4;
import com.melon.ui.t4;
import d3.g;
import d5.f;
import ie.m;
import ie.r;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import r0.d;
import r0.n;
import we.k;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"LAc/j3;", "LAc/N0;", "LAc/L3;", "LJ8/v;", "Lcom/melon/ui/a;", "", "<init>", "()V", "Ac/V2", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class j3 extends w4 implements a {
    public final e f;
    public final O3 g;
    public final LogU h;
    public CommentInputPopup i;
    public final r j;

    static {
    }

    public j3() {
        this.f = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = new O3();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = new LogU("CommentListFragment");
        logU0.setCategory(Category.UI);
        this.h = logU0;
        this.j = g.Q(new A9.a(7));
    }

    @Override  // com.melon.ui.o1
    public final String getPvDummyLogAction() {
        return "reply";
    }

    @Override  // com.melon.ui.o1
    public final Map getPvDummyLogParams() {
        Map map0 = new HashMap();
        map0.put("type", "list");
        map0.put("chnlSeq", String.valueOf(((L3)this.getViewModel()).d()));
        map0.put("contsRefValue", ((L3)this.getViewModel()).f());
        map0.put("cmtSeq", "");
        return map0;
    }

    @Override  // com.melon.ui.c0
    public final boolean getShouldIgnoreSetUIOnForegroundEvent() {
        return this.getParentFragment() instanceof a9.a;
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D018F, null, false);  // layout:comment_list_fragment
        int v = 0x7F0A00AB;  // id:appbar_layout
        if(((AppBarLayout)I.C(view0, 0x7F0A00AB)) != null && ((CollapsingToolbarLayout)I.C(view0, 0x7F0A02DD)) != null) {  // id:appbar_layout
            v = 0x7F0A02F8;  // id:comment_input_layout
            View view1 = I.C(view0, 0x7F0A02F8);  // id:comment_input_layout
            if(view1 != null) {
                u u0 = u.a(view1);
                v = 0x7F0A0309;  // id:compose_view
                View view2 = I.C(view0, 0x7F0A0309);  // id:compose_view
                if(((ComposeView)view2) != null && ((CoordinatorLayout)I.C(view0, 0x7F0A0348)) != null) {  // id:coordinator_layout
                    v = 0x7F0A049A;  // id:filter_compose_view
                    View view3 = I.C(view0, 0x7F0A049A);  // id:filter_compose_view
                    if(((ComposeView)view3) != null) {
                        v = 0x7F0A097E;  // id:progress
                        View view4 = I.C(view0, 0x7F0A097E);  // id:progress
                        if(((ProgressBar)view4) != null) {
                            v = 0x7F0A0ABA;  // id:sort_compose_view
                            View view5 = I.C(view0, 0x7F0A0ABA);  // id:sort_compose_view
                            if(((ComposeView)view5) != null) {
                                v = 0x7F0A0BAE;  // id:titlebar_container
                                View view6 = I.C(view0, 0x7F0A0BAE);  // id:titlebar_container
                                if(view6 != null) {
                                    return new v(((RelativeLayout)view0), u0, ((ComposeView)view2), ((ComposeView)view3), ((ProgressBar)view4), ((ComposeView)view5), new b(((TitleBar)view6), ((TitleBar)view6), 12));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return L3.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.f.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    public final CommentInputPopup initInputPopup(Editable editable0) {
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        CommentInputPopup commentInputPopup0 = new CommentInputPopup(context0, editable0, new a3(this), false, 8, null);
        commentInputPopup0.setOnShowListener(new k2(this, 1));
        commentInputPopup0.setOnDismissListener(new l2(this, 1));
        return commentInputPopup0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return this.getParentFragment() instanceof a9.a ? false : super.isShowTabAndMiniPlayer();
    }

    public final void o(r0.q q0, F f0, List list0, l l0, int v) {
        ((p)l0).c0(0x8AFFD7BB);
        int v1 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).g(f0) ? 0x20 : 16) | (((p)l0).i(list0) ? 0x100 : 0x80) | (((p)l0).i(this) ? 0x800 : 0x400);
        if(((p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, h.t(((p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z = ((p)l0).i(list0);
            boolean z1 = ((p)l0).i(this);
            D d0 = ((p)l0).N();
            if(z || z1 || d0 == androidx.compose.runtime.k.a) {
                d0 = new D(8, list0, this);
                ((p)l0).l0(d0);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, d0, ((p)l0), v1 & 0x7E, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U2(this, q0, f0, list0, v, 0);
        }
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        L3 l30 = (L3)this.getViewModel();
        l30.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.h(l30), null, null, new K3(l30, null), 3, null);
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        CommentInputPopup commentInputPopup0 = this.i;
        if(commentInputPopup0 != null) {
            commentInputPopup0.dismiss();
        }
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof x3) {
            l0 l00 = this.getChildFragmentManager();
            D d0 = new D(7, this, i40);
            com.melon.ui.popup.b.g(l00, ((x3)i40).a, true, ((x3)i40).d, ((x3)i40).b, d0);
            return;
        }
        if(i40 instanceof B1) {
            if(((B1)i40) instanceof T1) {
                this.r(((T1)i40).a);
                return;
            }
            if(((B1)i40) instanceof W1) {
                this.startActivity(new Intent("android.intent.action.VIEW", ((W1)i40).a));
                return;
            }
            if(((B1)i40) instanceof Q1) {
                String s = ((Q1)i40).a.getContentRefValue();
                q.g(s, "contentRefValue");
                v2 v20 = new v2();
                v20.setArguments(f.j(new m[]{new m("key_cmt_seq", ((Q1)i40).b.getCommentSeq()), new m("key_channel_seq", ((Q1)i40).a.getChannelSeq()), new m("key_content_ref_value", s), new m("key_cmt_config", ((Q1)i40).a)}));
                v20.m(this.getParentFragment());
                return;
            }
            l0 l01 = this.getChildFragmentManager();
            o2 o20 = new o2(1, this, j3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 8);
            l0 l02 = this.getParentFragmentManager();
            q.g(((B1)i40), "uiEvent");
            this.g.b(l01, ((B1)i40), o20, l02);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l03 = this.getChildFragmentManager();
            q.f(l03, "getChildFragmentManager(...)");
            a.f(this, l03, ((com.melon.ui.b)i40), this.getContext(), new o2(1, this, j3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9));
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        v v0 = (v)this.getBinding();
        if(v0 == null) {
            return;
        }
        O o0 = new O((this.getParentFragment() instanceof a9.a ? 16.0f : 20.0f));
        o0.c = new R2(this, 0);
        x x0 = new x(1);
        x0.c = new R2(this, 1);
        TitleBar titleBar0 = (TitleBar)v0.g.c;
        String s = "";
        if(this.getParentFragment() instanceof a9.a) {
            titleBar0.setPadding(0, ScreenUtils.dipToPixel(titleBar0.getContext(), this.b), 0, 0);
            titleBar0.c(this.a);
            String s2 = (String)((L3)this.getViewModel()).c.a("key_cmt_title");
            if(s2 != null) {
                s = s2;
            }
            if(s.length() == 0) {
                s = ((L3)this.getViewModel()).e();
            }
            F8.q q0 = new F8.q(s);
            q0.g(o0);
            titleBar0.a(q0);
        }
        else {
            o o1 = B.a.s(1);
            o1.g(o0);
            o1.g(x0);
            titleBar0.a(o1);
            String s1 = (String)((L3)this.getViewModel()).c.a("key_cmt_title");
            if(s1 != null) {
                s = s1;
            }
            if(s.length() == 0) {
                s = ((L3)this.getViewModel()).e();
            }
            titleBar0.setTitle(s);
        }
        titleBar0.f(false);
        j.a(((j)this.j.getValue()), titleBar0, new U(this, 5));
        if(this.getParentFragment() instanceof a9.a) {
            v v1 = (v)this.getBinding();
            if(v1 != null) {
                ((LinearLayout)v1.b.c).setVisibility(0);
            }
            this.i = this.initInputPopup(null);
            v v2 = (v)this.getBinding();
            x1.a.N((v2 == null ? null : ((MelonEditText)v2.b.d)), new R2(this, 2));
            v v3 = (v)this.getBinding();
            x1.a.N((v3 == null ? null : ((MelonTextView)v3.b.b)), new R2(this, 3));
        }
        androidx.lifecycle.D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new d3(this, v0, null), 3, null);
        androidx.lifecycle.D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new g3(this, v0, null), 3, null);
    }

    public final void p(v3 v30, l l0, int v) {
        int v7;
        int v6;
        int v5;
        int v4;
        r0.h h0 = d.k;
        p p0 = (p)l0;
        p0.c0(0x68F6C840);
        int v1 = (p0.i(v30) ? 4 : 2) | v | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            p0 p00 = M.n0.a(M.j.a, h0, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            w.x(p0, q1, P0.j.d);
            p0.a0(0x58ADA08D);
            int v3 = 0;
            for(Object object0: ((Iterable)v30.a)) {
                if(v3 >= 0) {
                    r0.q q2 = androidx.compose.foundation.layout.a.n(n0, ((float)(v3 == 0 ? 20 : 8)), 0.0f, 0.0f, 0.0f, 14);
                    if(((u3)object0).c) {
                        v4 = -978066713;
                        v5 = 0x7F06017F;  // color:green502s_support_high_contrast
                    }
                    else {
                        v4 = 0xC5B3EBD1;
                        v5 = 0x7F06048A;  // color:transparent
                    }
                    r0.q q3 = androidx.compose.foundation.q.f(q2, A7.d.f(p0, v4, v5, p0, false), T.e.b(100.0f));
                    y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
                    T.d d0 = T.e.b(100.0f);
                    r0.q q4 = androidx.compose.foundation.layout.a.m(androidx.compose.foundation.layout.d.t(r0.a.a(androidx.compose.foundation.q.j(q3, y0.a, y0.b, d0), new X2(this, ((u3)object0), v3, 0)), 2), 15.0f, 7.0f, 15.0f, 7.0f);
                    String s = ((u3)object0).a;
                    if(((u3)object0).c) {
                        v6 = 0xC5B46211;
                        v7 = 0x7F0604A1;  // color:white000e
                    }
                    else {
                        v6 = -978032578;
                        v7 = 0x7F060163;  // color:gray700s
                    }
                    N1.b(s, q4, A7.d.f(p0, v6, v7, p0, false), 13.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);
                    ++v3;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T2(this, v30, v);
        }
    }

    public final void performRegister(String s) {
        L3 l30 = (L3)this.getViewModel();
        A2 a20 = new A2(this, 1);
        StringProviderImpl stringProviderImpl0 = l30.e;
        if(!((va.e0)l30.g).m()) {
            l30.sendUiEvent(s4.a);
            return;
        }
        int v = s.length() - 1;
        int v1 = 0;
        boolean z = false;
        while(v1 <= v) {
            boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
            if(z) {
                if(!z1) {
                    break;
                }
                --v;
            }
            else if(z1) {
                ++v1;
            }
            else {
                z = true;
            }
        }
        int v2 = s.subSequence(v1, v + 1).toString().length();
        CommentConfig commentConfig0 = l30.b.d;
        int v3 = commentConfig0 == null ? -1 : commentConfig0.getWriteMinLength();
        if(v3 <= 0) {
            v3 = 3;
        }
        if(v2 < v3) {
            l30.sendUiEvent(new t4((v2 == 0 ? stringProviderImpl0.a(0x7F1301F1) : String.format(stringProviderImpl0.a(0x7F13084C), Arrays.copyOf(new Object[]{v3}, 1)))));  // string:cmt_write_hint_msg "내용을 입력해주세요."
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(l30), Dispatchers.getIO(), null, new H3(l30, s, a20, null), 2, null);
    }

    public final void q(B3 b30, l l0, int v) {
        Object object1;
        n n1;
        r0.h h0 = d.k;
        p p0 = (p)l0;
        p0.c0(0x50701180);
        int v1 = (p0.i(b30) ? 4 : 2) | v | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), 1.0f);
            p0 p00 = M.n0.a(M.j.a, h0, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            w.x(p0, q1, P0.j.d);
            if(((L3)this.getViewModel()).m != 0 || b30.a <= -1) {
                n1 = n0;
                p0.a0(1460806022);
            }
            else {
                p0.a0(0x58268535);
                r0.q q2 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.t(n0, 2), 0.0f, 10.5f, 1);
                C0 c00 = p0.N();
                if(c00 == androidx.compose.runtime.k.a) {
                    c00 = new C0(4);
                    p0.l0(c00);
                }
                r0.q q3 = X0.n.b(q2, c00);
                n1 = n0;
                N1.b(va.e.c(H0.e.Y(p0, 0x7F1301D6), " ", StringUtils.getCountFormattedString(b30.a)), q3, e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // string:cmt_all "전체"
            }
            p0.p(false);
            Object object0 = null;
            l1.x(1.0f, true, p0);
            r0.q q4 = androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n1, 0.0f, 0.0f, 3.0f, 0.0f, 11), 14.0f);
            androidx.compose.foundation.q.c(I.Q(0x7F08017C, p0, 6), null, q4, null, N0.j.f, 0.0f, null, p0, 25008, 104);  // drawable:btn_common_toggle_14
            Iterator iterator0 = b30.b.iterator();
            while(true) {
                object1 = null;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object2 = iterator0.next();
                if(((A3)object2).c) {
                    object0 = object2;
                    break;
                }
            }
            String s = ((A3)object0) == null ? "" : ((A3)object0).a;
            for(Object object3: b30.b) {
                if(((A3)object3).c) {
                    object1 = object3;
                    break;
                }
                if(false) {
                    break;
                }
            }
            N1.b(s, r0.a.a(androidx.compose.foundation.layout.d.t(n1, 2), new Z2(this, s, (((A3)object1) == null ? 0 : ((A3)object1).b), b30, 0)), e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // color:gray800s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new S2(this, b30, v);
        }
    }

    public final void r(boolean z) {
        v v0 = (v)this.getBinding();
        if(v0 != null) {
            v0.e.setVisibility((z ? 0 : 8));
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        v v0 = (v)this.getBinding();
        if(v0 == null) {
            return;
        }
        m0.b b0 = new m0.b(0x61FAC41C, new E(k40, this, v0, 3), true);
        v0.c.setContent(b0);
    }

    public final void s(v v0, boolean z) {
        ComposeView composeView0 = v0.f;
        ComposeView composeView1 = v0.d;
        if(z) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = composeView1.getLayoutParams();
            viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(this.getContext(), 56.0f);
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = composeView0.getLayoutParams();
            viewGroup$LayoutParams1.height = ScreenUtils.dipToPixel(this.getContext(), 38.0f);
        }
        else {
            composeView1.getLayoutParams().height = 0;
            composeView0.getLayoutParams().height = 0;
        }
        composeView1.requestLayout();
        composeView0.requestLayout();
    }

    @Override  // com.melon.ui.c0
    public final void setShouldIgnoreSetUIOnForegroundEvent(boolean z) {
    }
}

