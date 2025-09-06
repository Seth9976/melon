package com.iloen.melon.player.playlist.drawernew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.o0;
import com.melon.ui.w0;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import de.c;
import ee.i;
import fe.b;
import h7.u0;

public abstract class Hilt_DrawerBtmSheetFragment extends w0 implements b {
    public ViewComponentManager.FragmentContextWrapper d;
    public boolean e;
    public volatile i f;
    public final Object g;
    public boolean h;

    public Hilt_DrawerBtmSheetFragment() {
        this.g = new Object();
        this.h = false;
    }

    public final i componentManager() {
        if(this.f == null) {
            Object object0 = this.g;
            synchronized(object0) {
                if(this.f == null) {
                    this.f = this.createComponentManager();
                }
            }
        }
        return this.f;
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
        if(super.getContext() == null && !this.e) {
            return null;
        }
        this.m();
        return this.d;
    }

    @Override  // androidx.fragment.app.I
    public o0 getDefaultViewModelProviderFactory() {
        return c.u(this, super.getDefaultViewModelProviderFactory());
    }

    public void inject() {
        if(!this.h) {
            this.h = true;
            ((DrawerBtmSheetFragment_GeneratedInjector)this.generatedComponent()).injectDrawerBtmSheetFragment(((DrawerBtmSheetFragment)this));
        }
    }

    public final void m() {
        if(this.d == null) {
            this.d = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.e = u0.I(super.getContext());
        }
    }

    @Override  // androidx.fragment.app.I
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.d == null || i.b(this.d) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
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

