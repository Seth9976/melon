package zd;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.o0;
import com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import de.c;
import ee.i;
import fe.b;
import h7.u0;
import kc.s2;

public abstract class r extends h implements b {
    public ViewComponentManager.FragmentContextWrapper i;
    public boolean j;
    public volatile i k;
    public final Object l;
    public boolean m;

    public r() {
        this.l = new Object();
        this.m = false;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.k == null) {
            Object object0 = this.l;
            synchronized(object0) {
                if(this.k == null) {
                    this.k = new i(this);
                }
            }
        }
        return this.k.generatedComponent();
    }

    @Override  // androidx.fragment.app.I
    public final Context getContext() {
        if(super.getContext() == null && !this.j) {
            return null;
        }
        this.n();
        return this.i;
    }

    @Override  // androidx.fragment.app.I
    public final o0 getDefaultViewModelProviderFactory() {
        return c.u(this, super.getDefaultViewModelProviderFactory());
    }

    public final void inject() {
        if(!this.m) {
            this.m = true;
            ((MelonBottomSheetComposeDialogFragment)this).o = (s2)((k8.h)(((w)this.generatedComponent()))).b.w.get();
        }
    }

    public final void n() {
        if(this.i == null) {
            this.i = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.j = u0.I(super.getContext());
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.i == null || i.b(this.i) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.n();
        this.inject();
    }

    @Override  // androidx.fragment.app.w
    public final void onAttach(Context context0) {
        super.onAttach(context0);
        this.n();
        this.inject();
    }

    @Override  // androidx.fragment.app.w
    public final LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

