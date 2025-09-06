package Fc;

import A6.b;
import B3.n;
import Cb.i;
import De.I;
import J8.C;
import Q4.a;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import c2.M;
import com.bumptech.glide.Glide;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import d9.h;
import d9.j;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LFc/k;", "Lcom/melon/ui/J0;", "LFc/p;", "LJ8/C;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class k extends E {
    public final LogU d;
    public boolean e;

    public k() {
        LogU logU0 = new LogU("CoverScreenLyricFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.d = logU0;
        this.e = true;
    }

    @Override  // com.melon.ui.c0
    public final boolean getShouldIgnoreForegroundEvent() {
        return this.e;
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D01AE, null, false);  // layout:cover_screen_lyric
        int v = 0x7F0A00E5;  // id:back
        View view1 = I.C(view0, 0x7F0A00E5);  // id:back
        if(((ImageView)view1) != null) {
            v = 0x7F0A00E6;  // id:background
            View view2 = I.C(view0, 0x7F0A00E6);  // id:background
            if(((ImageView)view2) != null) {
                v = 0x7F0A03C4;  // id:dim
                View view3 = I.C(view0, 0x7F0A03C4);  // id:dim
                if(((ImageView)view3) != null) {
                    v = 0x7F0A07C3;  // id:lyricview
                    View view4 = I.C(view0, 0x7F0A07C3);  // id:lyricview
                    if(((ComposeView)view4) != null) {
                        return new C(((ConstraintLayout)view0), ((ImageView)view1), ((ImageView)view2), ((ImageView)view3), ((ComposeView)view4));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return p.class;
    }

    @Override  // com.melon.ui.J0
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        LayoutInflater layoutInflater1 = LayoutInflater.from(this.requireActivity());
        q.d(layoutInflater1);
        return super.onCreateView(layoutInflater1, viewGroup0, bundle0);
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        ((p)this.getViewModel()).getClass();
        j.d("CoverScreenLyricViewModel");
        l0 l00 = this.requireActivity().getSupportFragmentManager();
        l00.getClass();
        androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
        a0.f(this);
        a0.k();
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            fragmentActivity0.finish();
        }
    }

    @Override  // com.melon.ui.c0
    public final void onResume() {
        super.onResume();
        p p0 = (p)this.getViewModel();
        p0.getClass();
        h h0 = j.b("CoverScreenLyricViewModel");
        MutableStateFlow mutableStateFlow0 = p0.b;
        if(mutableStateFlow0.getValue() != h0) {
            mutableStateFlow0.setValue(h0);
        }
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        C c0 = (C)this.getBinding();
        if(c0 != null) {
            n n0 = new n(8);
            M.n(c0.b, n0);
            c0.b.requestApplyInsets();
            b b0 = new b(this, 4);
            c0.b.setOnClickListener(b0);
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        String s = "renderUi() uiState: " + i.o(k40);
        LogU.debug$default(this.d, s, null, false, 6, null);
        if(k40 instanceof m) {
            C c0 = (C)this.getBinding();
            if(c0 != null) {
                m0.b b0 = new m0.b(1735109396, new C8.a(this, 7), true);
                c0.e.setContent(b0);
                Uri uri0 = ((m)k40).a;
                if(uri0 == null || uri0.equals(Uri.EMPTY)) {
                    c0.c.setImageBitmap(null);
                    c0.d.setVisibility(8);
                    return;
                }
                Context context0 = this.getContext();
                if(context0 != null) {
                    Fc.j j0 = (Fc.j)Glide.with(context0).asBitmap().load(uri0).into(new Fc.j(c0, ((ViewComponentManager.FragmentContextWrapper)context0)));
                }
            }
        }
    }

    @Override  // com.melon.ui.c0
    public final void setShouldIgnoreForegroundEvent(boolean z) {
        this.e = z;
    }
}

