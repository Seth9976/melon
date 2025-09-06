package com.melon.ui.playermusic;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import cd.V2;
import com.google.firebase.b;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.player.TransformableFrameLayout;
import d3.g;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;
import pc.t;
import td.a;
import td.e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/melon/ui/playermusic/d;", "Landroidx/fragment/app/I;", "<init>", "()V", "pc/t", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class d extends a {
    public t f;
    public final LogU g;
    public z h;
    public final MutableStateFlow i;
    public final MutableStateFlow j;
    public final MutableStateFlow k;
    public final MutableStateFlow l;
    public final r m;
    public final e n;

    public d() {
        this.g = new LogU("MusicPlayerBG-Fragment");
        this.i = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.j = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.k = StateFlowKt.MutableStateFlow(null);
        this.l = StateFlowKt.MutableStateFlow(0.0f);
        this.m = g.Q(new td.d(this, 0));
        this.n = new e(this, 0);
    }

    public final void m(BgType bgType0) {
        LogU.debug$default(this.g, "changeBgData() bgData=" + bgType0, null, false, 6, null);
        this.k.setValue(bgType0);
        View view0 = this.getView();
        if(view0 != null) {
            view0.setTag((bgType0 instanceof Album ? "album_type_view_tag" : null));
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        BgType bgType0 = bundle1 == null ? null : ((BgType)(((Parcelable)b.F(bundle1, "arg_bg_data", BgType.class))));
        if(bgType0 != null) {
            this.m(bgType0);
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
    public final void onDestroyView() {
        View view0 = this.getView();
        TransformableFrameLayout transformableFrameLayout0 = view0 instanceof TransformableFrameLayout ? ((TransformableFrameLayout)view0) : null;
        if(transformableFrameLayout0 != null) {
            transformableFrameLayout0.a = null;
        }
        super.onDestroyView();
    }

    @Override  // androidx.fragment.app.I
    public final void onPause() {
        super.onPause();
        this.i.setValue(Boolean.FALSE);
    }

    @Override  // androidx.fragment.app.I
    public final void onResume() {
        super.onResume();
        this.i.setValue(Boolean.TRUE);
    }

    @Override  // androidx.fragment.app.I
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TransformableFrameLayout transformableFrameLayout0 = view0 instanceof TransformableFrameLayout ? ((TransformableFrameLayout)view0) : null;
        if(transformableFrameLayout0 != null) {
            transformableFrameLayout0.setTransformationListener(this.n);
        }
        View view1 = transformableFrameLayout0 == null ? null : transformableFrameLayout0.getChildAt(0);
        ComposeView composeView0 = view1 instanceof ComposeView ? ((ComposeView)view1) : null;
        if(composeView0 == null) {
            return;
        }
        composeView0.setContent(new m0.b(-1799274903, new V2(this, 25), true));
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new td.g(this, null), 3, null);
    }
}

