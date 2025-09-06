package com.kakaoent.trevi.ad.ui.fragment;

import Q4.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001A\u00028\u00002\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH&¢\u0006\u0004\b\r\u0010\u000EJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0005R\u0018\u0010\u0016\u001A\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001A\u001A\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/BaseViewFragment;", "LQ4/a;", "BINDING", "Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment;", "<init>", "()V", "", "isInitBinding", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "inflateBinding", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)LQ4/a;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lie/H;", "onDestroyView", "_binding", "LQ4/a;", "getBinding", "()LQ4/a;", "binding", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class BaseViewFragment extends BaseFragment {
    @Nullable
    private a _binding;

    @Nullable
    public final a getBinding() {
        return this._binding;
    }

    @NotNull
    public abstract a inflateBinding(@NotNull LayoutInflater arg1, @Nullable ViewGroup arg2);

    public final boolean isInitBinding() {
        return this._binding != null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        this._binding = this.inflateBinding(layoutInflater0, viewGroup0);
        a a0 = this.getBinding();
        return a0 == null ? null : a0.getRoot();
    }

    @Override  // androidx.fragment.app.I
    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }
}

