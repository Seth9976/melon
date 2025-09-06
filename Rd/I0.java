package rd;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.I;
import androidx.lifecycle.o0;
import cd.V2;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.player.TransformableFrameLayout;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerPageData;
import d3.g;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import de.c;
import ee.i;
import fe.b;
import h7.u0;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lrd/i0;", "Landroidx/fragment/app/I;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class i0 extends I implements b {
    public ViewComponentManager.FragmentContextWrapper a;
    public boolean b;
    public volatile i c;
    public final Object d;
    public boolean e;
    public final LogU f;
    public final MutableStateFlow g;
    public final MutableStateFlow h;
    public final r i;
    public final h0 j;

    public i0() {
        this.d = new Object();
        this.e = false;
        this.f = new LogU("DjMalrangPlayerPagerFragment");
        this.g = StateFlowKt.MutableStateFlow(null);
        this.h = StateFlowKt.MutableStateFlow(0.0f);
        this.i = g.Q(new g0(this, 0));
        this.j = new h0(this, 0);
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.c == null) {
            Object object0 = this.d;
            synchronized(object0) {
                if(this.c == null) {
                    this.c = new i(this);
                }
            }
        }
        return this.c.generatedComponent();
    }

    @Override  // androidx.fragment.app.I
    public final Context getContext() {
        if(super.getContext() == null && !this.b) {
            return null;
        }
        this.m();
        return this.a;
    }

    @Override  // androidx.fragment.app.I
    public final o0 getDefaultViewModelProviderFactory() {
        return c.u(this, super.getDefaultViewModelProviderFactory());
    }

    public final void l(DjMalrangPlayerPageData djMalrangPlayerPageData0) {
        LogU.debug$default(this.f, "changeBgData() bgData=" + djMalrangPlayerPageData0, null, false, 6, null);
        this.g.setValue(djMalrangPlayerPageData0);
    }

    public final void m() {
        if(this.a == null) {
            this.a = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.b = u0.I(super.getContext());
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.a == null || i.b(this.a) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.m();
        if(!this.e) {
            this.e = true;
            ((s0)this.generatedComponent()).getClass();
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onAttach(Context context0) {
        super.onAttach(context0);
        this.m();
        if(!this.e) {
            this.e = true;
            ((s0)this.generatedComponent()).getClass();
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        DjMalrangPlayerPageData djMalrangPlayerPageData0 = bundle1 == null ? null : ((DjMalrangPlayerPageData)(((Parcelable)com.google.firebase.b.F(bundle1, "arg_page_data", DjMalrangPlayerPageData.class))));
        if(djMalrangPlayerPageData0 != null) {
            this.l(djMalrangPlayerPageData0);
        }
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        View view0 = new TransformableFrameLayout(context0);
        view0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Context context1 = this.requireContext();
        q.f(context1, "requireContext(...)");
        ComposeView composeView0 = new ComposeView(context1, null, 6, 0);
        composeView0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup)view0).addView(composeView0);
        return view0;
    }

    @Override  // androidx.fragment.app.I
    public final LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }

    @Override  // androidx.fragment.app.I
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        ComposeView composeView0 = null;
        TransformableFrameLayout transformableFrameLayout0 = view0 instanceof TransformableFrameLayout ? ((TransformableFrameLayout)view0) : null;
        if(transformableFrameLayout0 != null) {
            transformableFrameLayout0.setTransformationListener(this.j);
        }
        View view1 = transformableFrameLayout0 == null ? null : transformableFrameLayout0.getChildAt(0);
        if(view1 instanceof ComposeView) {
            composeView0 = (ComposeView)view1;
        }
        if(composeView0 == null) {
            return;
        }
        composeView0.setContent(new m0.b(0x99449EB0, new V2(this, 23), true));
    }
}

