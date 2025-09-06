package gd;

import De.I;
import F8.o;
import Hd.S;
import J8.b;
import J8.p2;
import Q4.a;
import Ud.j;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.l0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.G4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.o1;
import d3.g;
import ed.f;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lgd/q6;", "Lcom/melon/ui/o1;", "Lgd/C6;", "LJ8/p2;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class q6 extends o1 {
    public final r a;
    public static final int b;

    static {
        LogU logU0 = new LogU("MelonDjTagHubTabFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
    }

    public q6() {
        this.a = g.Q(new r5(2));
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D04EA, null, false);  // layout:melondj_tag_hub_tab_fragment
        int v = 0x7F0A00AB;  // id:appbar_layout
        AppBarLayout appBarLayout0 = (AppBarLayout)I.C(view0, 0x7F0A00AB);  // id:appbar_layout
        if(appBarLayout0 != null && ((FrameLayout)I.C(view0, 0x7F0A011B)) != null && ((CollapsingToolbarLayout)I.C(view0, 0x7F0A02DD)) != null) {  // id:bottom_fragment_container
            v = 0x7F0A030B;  // id:compose_view_collapsable
            ComposeView composeView0 = (ComposeView)I.C(view0, 0x7F0A030B);  // id:compose_view_collapsable
            if(composeView0 != null && ((CoordinatorLayout)I.C(view0, 0x7F0A0348)) != null) {  // id:coordinator_layout
                v = 0x7F0A0BAE;  // id:titlebar_container
                View view1 = I.C(view0, 0x7F0A0BAE);  // id:titlebar_container
                if(view1 != null) {
                    return new p2(((FrameLayout)view0), appBarLayout0, composeView0, new b(((TitleBar)view1), ((TitleBar)view1), 12));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return C6.class;
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        C6 c60 = (C6)this.getViewModel();
        String s = bundle0.getString("argTagSeq");
        if(s == null) {
            s = "";
        }
        c60.getClass();
        c60.g = s;
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argTagSeq", ((C6)this.getViewModel()).g);
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof G4) {
            com.melon.ui.popup.b.k(this.getContext(), this.getParentFragmentManager(), 28);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        p2 p20 = (p2)this.getBinding();
        if(p20 != null) {
            o o0 = B.a.s(0);
            ((TitleBar)p20.d.c).a(o0);
            j j0 = (j)this.a.getValue();
            f f0 = new f(this, 21);
            j.a(j0, ((TitleBar)p20.d.c), f0);
        }
        p2 p21 = (p2)this.getBinding();
        if(p21 == null) {
            return;
        }
        S s0 = new S(ResourceUtilsKt.getDimension(0x7F07046D), this, p21, 1);  // dimen:top_container_height
        p21.b.a(s0);
        androidx.fragment.app.I i0 = this.getChildFragmentManager().E("MelonDjTagHubBottomFragment");
        if(i0 == null) {
            String s1 = ((C6)this.getViewModel()).g;
            R5 r50 = new R5();
            Bundle bundle1 = new Bundle();
            bundle1.putString("argTagSeq", s1);
            r50.setArguments(bundle1);
            i0 = r50;
        }
        l0 l00 = this.getChildFragmentManager();
        l00.getClass();
        androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
        a0.g(0x7F0A011B, i0, "MelonDjTagHubBottomFragment");  // id:bottom_fragment_container
        a0.k();
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        p2 p20 = (p2)this.getBinding();
        if(p20 != null) {
            ComposeView composeView0 = p20.c;
            if(k40 instanceof u6) {
                int v = M.z(s.f);
                ((TitleBar)p20.d.c).setBackgroundColor(v);
                ((TitleBar)p20.d.c).setTitle(((u6)k40).a);
                composeView0.setContent(new m0.b(0x3834EC66, new p6(k40, this, 0), true));
                return;
            }
            if(k40 instanceof s6) {
                composeView0.setContent(new m0.b(443900701, new p6(k40, this, 1), true));
                return;
            }
            if(k40 instanceof t6) {
                composeView0.setContent(new m0.b(0x378C651F, new L(k40, 15), true));
            }
        }
    }
}

