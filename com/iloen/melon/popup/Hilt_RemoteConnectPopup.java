package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.o0;
import com.melon.ui.a0;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import de.c;
import ee.i;
import fe.b;
import h7.u0;

public abstract class Hilt_RemoteConnectPopup extends a0 implements b {
    public ViewComponentManager.FragmentContextWrapper e;
    public boolean f;
    public volatile i g;
    public final Object h;
    public boolean i;

    public Hilt_RemoteConnectPopup() {
        this.h = new Object();
        this.i = false;
    }

    public final i componentManager() {
        if(this.g == null) {
            Object object0 = this.h;
            synchronized(object0) {
                if(this.g == null) {
                    this.g = this.createComponentManager();
                }
            }
        }
        return this.g;
    }

    public b componentManager() {
        return this.componentManager();
    }

    public i createComponentManager() {
        return new i(this);
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        return this.componentManager().generatedComponent();
    }

    @Override  // androidx.fragment.app.I
    public Context getContext() {
        if(super.getContext() == null && !this.f) {
            return null;
        }
        this.m();
        return this.e;
    }

    @Override  // androidx.fragment.app.I
    public o0 getDefaultViewModelProviderFactory() {
        return c.u(this, super.getDefaultViewModelProviderFactory());
    }

    public void inject() {
        if(!this.i) {
            this.i = true;
            ((RemoteConnectPopup_GeneratedInjector)this.generatedComponent()).injectRemoteConnectPopup(((RemoteConnectPopup)this));
        }
    }

    public final void m() {
        if(this.e == null) {
            this.e = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.f = u0.I(super.getContext());
        }
    }

    @Override  // androidx.fragment.app.I
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.e == null || i.b(this.e) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.m();
        this.inject();
    }

    @Override  // androidx.fragment.app.w
    public void onAttach(Context context0) {
        super.onAttach(context0);
        this.m();
        this.inject();
    }

    @Override  // androidx.fragment.app.w
    public LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

