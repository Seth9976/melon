package gd;

import Cb.i;
import De.I;
import E9.h;
import J8.X0;
import Ma.m;
import R6.c;
import R6.d;
import Ub.s;
import Ud.j;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.B4;
import com.melon.ui.F4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.n;
import com.melon.ui.o1;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.u4;
import com.melon.ui.v4;
import com.melon.ui.x3;
import com.melon.ui.x4;
import d3.g;
import d5.f;
import dd.v;
import e.b;
import ie.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import va.e0;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lgd/u1;", "Lcom/melon/ui/o1;", "Lgd/V1;", "LJ8/X0;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "", "Lcom/melon/ui/k3;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class u1 extends o1 implements M2, a, k3 {
    public final d a;
    public final e b;
    public final c c;
    public final p3 d;
    public final r e;
    public ToolBar f;
    public final b g;

    public u1() {
        this.a = new d(25);
        this.b = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = new c(26);
        this.d = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = g.Q(new v(21));
        this.g = H0.e.T(this, new Z0(1, this, u1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9));
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02A7, null, false);  // layout:fragment_compose_view_with_title_toolbar
        int v = 0x7F0A0309;  // id:compose_view
        ComposeView composeView0 = (ComposeView)I.C(view0, 0x7F0A0309);  // id:compose_view
        if(composeView0 != null) {
            v = 0x7F0A0BAE;  // id:titlebar_container
            View view1 = I.C(view0, 0x7F0A0BAE);  // id:titlebar_container
            if(view1 != null) {
                J8.b b0 = new J8.b(((TitleBar)view1), ((TitleBar)view1), 12);
                View view2 = I.C(view0, 0x7F0A0BC6);  // id:toolbar_layout
                if(view2 != null) {
                    return new X0(((ConstraintLayout)view0), composeView0, b0, new J8.b(((ToolBar)view2), ((ToolBar)view2), 13));
                }
                v = 0x7F0A0BC6;  // id:toolbar_layout
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return V1.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.b.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, androidx.fragment.app.I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.a.handleMorePopupUiEvent(m20, i0, null);
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, androidx.fragment.app.I i0, we.a a0, k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.d.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        String s1;
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        V1 v10 = (V1)this.getViewModel();
        String s = "";
        if(bundle0 == null) {
            s1 = "";
        }
        else {
            s1 = bundle0.getString("argBrandDjKey");
            if(s1 == null) {
                s1 = "";
            }
        }
        v10.getClass();
        v10.i = s1;
        V1 v11 = (V1)this.getViewModel();
        if(bundle0 != null) {
            String s2 = bundle0.getString("argBrandDjNickname");
            if(s2 != null) {
                s = s2;
            }
        }
        v11.getClass();
        v11.j = s;
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        ((V1)this.getViewModel()).d(false);
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = ((V1)this.getViewModel()).i;
        if(s != null) {
            bundle0.putString("argBrandDjKey", s);
            String s1 = ((V1)this.getViewModel()).j;
            if(s1 != null) {
                bundle0.putString("argBrandDjNickname", s1);
                return;
            }
            q.m("brandDjNickname");
            throw null;
        }
        q.m("brandDjKey");
        throw null;
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof A1) {
            MelonAppBase.Companion.getClass();
            if(!t.a().isCarConnected()) {
                Context context0 = this.requireContext();
                q.f(context0, "requireContext(...)");
                Context context1 = context0.getApplicationContext();
                q.d(context1);
                if(!((Ub.t)(((s)((k8.o)(((m)com.google.firebase.b.B(context1, m.class)))).z.get()))).f()) {
                    InstantPlayPopup instantPlayPopup0 = new InstantPlayPopup(((A1)i40).a);
                    l0 l00 = this.getChildFragmentManager();
                    q.f(l00, "getChildFragmentManager(...)");
                    instantPlayPopup0.show(l00, "InstantPlayPopup");
                    return;
                }
            }
            ToastManager.show(i.k(this, 0x7F1304B4));  // string:instant_play_other_device "기기 연동 중 상태에서는 해당 기능을 지원하지 않습니다."
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            ((V1)this.getViewModel()).getClass();
            boolean z = ((e0)va.o.a()).m();
            Z0 z00 = new Z0(1, this, u1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 4);
            this.c.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.g, z00);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l01 = this.getChildFragmentManager();
            q.f(l01, "getChildFragmentManager(...)");
            a.f(this, l01, ((com.melon.ui.b)i40), this.getContext(), new Z0(1, this, u1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 5));
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, null);
            return;
        }
        if(i40 instanceof F4) {
            String s = ((V1)this.getViewModel()).getMenuId();
            Z0 z01 = new Z0(1, this, u1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 6);
            this.a.A(((F4)i40).a, this, s, z01);
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new s1(this, 0), new Z0(1, this, u1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 7), false, 0x30);
            return;
        }
        if(i40 instanceof B4) {
            s1 s10 = new s1(this, 1);
            this.sendUserEvent(new n(((B4)i40).a, ((B4)i40).b, false, false, s10, 92));
            return;
        }
        if(i40 instanceof x4) {
            this.sendUserEvent(new com.melon.ui.i(((x4)i40).a, ((x4)i40).b));
            if(((x4)i40).c) {
                ((V1)this.getViewModel()).d(false);
            }
            return;
        }
        if(i40 instanceof v4) {
            ((V1)this.getViewModel()).d(false);
            ArrayList arrayList0 = h.W(((v4)i40).b);
            ArrayList arrayList1 = h.W(((v4)i40).c);
            Navigator.openPresentSongSendFragment(((v4)i40).a, arrayList0, arrayList1);
            return;
        }
        if(i40 instanceof u4) {
            ((V1)this.getViewModel()).d(false);
            Navigator.openUrl("", ((u4)i40).a, OpenType.FullScreen, ((u4)i40).b);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        X0 x00 = (X0)this.getBinding();
        if(x00 != null) {
            F8.o o0 = B.a.s(1);
            ((TitleBar)x00.c.c).a(o0);
            String s = this.getString(0x7F13062C);  // string:melondj_brand_recom_song_detail_title "추천 곡"
            ((TitleBar)x00.c.c).setTitle(s);
            j j0 = (j)this.e.getValue();
            s1 s10 = new s1(this, 2);
            j.a(j0, ((TitleBar)x00.c.c), s10);
        }
        X0 x01 = (X0)this.getBinding();
        if(x01 == null) {
            return;
        }
        ToolBar toolBar0 = ToolBar.f(((ToolBar)x01.d.c), 1000);
        toolBar0.setOnToolBarListener(new com.iloen.melon.fragments.radio.a(this, 10));
        this.f = toolBar0;
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        X0 x00 = (X0)this.getBinding();
        if(x00 != null) {
            ComposeView composeView0 = x00.b;
            if(k40 instanceof D1) {
                composeView0.setContent(new m0.b(0x7FE9332, new t1(k40, this, 0), true));
                Iterable iterable0 = ((D1)k40).d;
                int v = 0;
                if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                    for(Object object0: iterable0) {
                        if(((z1)object0).k) {
                            ++v;
                            if(v < 0) {
                                e.k.N();
                                throw null;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                }
                ToolBar toolBar0 = this.f;
                if(toolBar0 != null) {
                    if(v > 0) {
                        toolBar0.setOnToolBarAnimationListener(new Cb.n(this, 1));
                        toolBar0.h(true);
                        toolBar0.l(v);
                        return;
                    }
                    f.J(toolBar0, this);
                    toolBar0.d();
                }
            }
            else {
                if(k40 instanceof B1) {
                    composeView0.setContent(new m0.b(1746496041, new t1(k40, this, 1), true));
                    return;
                }
                if(k40 instanceof C1) {
                    composeView0.setContent(new m0.b(0xFD88AFAB, new L(k40, 5), true));
                }
            }
        }
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(androidx.fragment.app.I i0, String s, List list0, we.a a0, k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.d.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }
}

