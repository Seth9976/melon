package com.melon.ui;

import De.d;
import H0.e;
import Q4.a;
import S2.c;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import b.t;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import o9.b;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/melon/ui/C0;", "Lcom/melon/ui/n0;", "VM", "LQ4/a;", "BINDING", "Lcom/melon/ui/a0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class C0 extends a0 {
    public n0 e;
    public a f;

    public C0() {
        LogU logU0 = new LogU("BaseViewModelDialogFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
    }

    public abstract a getViewBinding(LayoutInflater arg1);

    public final n0 getViewModel() {
        n0 n00 = this.e;
        if(n00 != null) {
            return n00;
        }
        q.m("viewModel");
        throw null;
    }

    public abstract Class getViewModelClass();

    @Override  // com.melon.ui.a0
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        q0 q00 = this.getViewModelStore();
        o0 o00 = this.getDefaultViewModelProviderFactory();
        c c0 = this.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        d d0 = df.d.y(this.getViewModelClass());
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.e = (n0)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
        L0 l00 = e.G(this);
        if(l00 != null) {
            this.getViewModel().registerProgressUpdater(l00);
        }
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        a a0 = this.getViewBinding(layoutInflater0);
        this.f = a0;
        return a0.getRoot();
    }

    @Override  // com.melon.ui.a0
    public final void onDestroyView() {
        this.f = null;
        super.onDestroyView();
    }

    public void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof t4) {
            ToastManager.show(((t4)i40).a);
            return;
        }
        if(i40 instanceof q4) {
            l0 l00 = this.getChildFragmentManager();
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, ((q4)i40).a, ((q4)i40).b, false, false, false, null, null, ((q4)i40).d, null, null, 0x6E8);
            return;
        }
        if(i40 instanceof r4) {
            com.melon.ui.popup.b.x(this.getChildFragmentManager(), ((r4)i40).a, ((r4)i40).b, false, ((r4)i40).c, ((r4)i40).f, ((r4)i40).d, ((r4)i40).e, ((r4)i40).g, null, null, 0xC28);
            return;
        }
        if(i40 instanceof s4) {
            com.melon.ui.popup.b.l(this.getContext(), this.getChildFragmentManager(), null, 12);
            return;
        }
        if(i40 instanceof p4) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null) {
                t t0 = fragmentActivity0.getOnBackPressedDispatcher();
                if(t0 != null) {
                    t0.c();
                }
            }
        }
    }

    @Override  // com.melon.ui.a0
    public void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new z0(this, null), 3, null);
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new B0(this, null), 3, null);
    }

    public abstract void renderUi(K4 arg1);

    public final void sendUserEvent(Pc.e e0) {
        q.g(e0, "userEvent");
        this.getViewModel().updateUserEvent(e0);
    }
}

