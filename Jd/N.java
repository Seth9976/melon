package jd;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.o0;
import com.melon.ui.C0;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import de.c;
import ee.i;
import fe.b;
import h7.u0;

public abstract class n extends C0 implements b {
    public ViewComponentManager.FragmentContextWrapper g;
    public boolean h;
    public volatile i i;
    public final Object j;
    public boolean k;

    public n() {
        this.j = new Object();
        this.k = false;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.i == null) {
            Object object0 = this.j;
            synchronized(object0) {
                if(this.i == null) {
                    this.i = new i(this);
                }
            }
        }
        return this.i.generatedComponent();
    }

    @Override  // androidx.fragment.app.I
    public final Context getContext() {
        if(super.getContext() == null && !this.h) {
            return null;
        }
        this.m();
        return this.g;
    }

    @Override  // androidx.fragment.app.I
    public final o0 getDefaultViewModelProviderFactory() {
        return c.u(this, super.getDefaultViewModelProviderFactory());
    }

    public final void m() {
        if(this.g == null) {
            this.g = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.h = u0.I(super.getContext());
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onAttach(Activity activity0) {
        super.onAttach(activity0);
        d5.n.n(this.g == null || i.b(this.g) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.m();
        if(!this.k) {
            this.k = true;
            o2 o20 = (o2)this.generatedComponent();
            a2 a20 = (a2)this;
            o20.getClass();
        }
    }

    @Override  // androidx.fragment.app.w
    public final void onAttach(Context context0) {
        super.onAttach(context0);
        this.m();
        if(!this.k) {
            this.k = true;
            o2 o20 = (o2)this.generatedComponent();
            a2 a20 = (a2)this;
            o20.getClass();
        }
    }

    @Override  // androidx.fragment.app.w
    public final LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

