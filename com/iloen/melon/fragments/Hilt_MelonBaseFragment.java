package com.iloen.melon.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.I;
import androidx.lifecycle.o0;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import de.c;
import ee.i;
import fe.b;
import h7.u0;

abstract class Hilt_MelonBaseFragment extends I implements b {
    private ContextWrapper componentContext;
    private volatile i componentManager;
    private final Object componentManagerLock;
    private boolean disableGetContextFix;
    private boolean injected;

    public Hilt_MelonBaseFragment() {
        this.componentManagerLock = new Object();
        this.injected = false;
    }

    public Hilt_MelonBaseFragment(int v) {
        super(v);
        this.componentManagerLock = new Object();
        this.injected = false;
    }

    public final i componentManager() {
        if(this.componentManager == null) {
            Object object0 = this.componentManagerLock;
            synchronized(object0) {
                if(this.componentManager == null) {
                    this.componentManager = this.createComponentManager();
                }
            }
        }
        return this.componentManager;
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
        if(super.getContext() == null && !this.disableGetContextFix) {
            return null;
        }
        this.initializeComponentContext();
        return this.componentContext;
    }

    @Override  // androidx.fragment.app.I
    public o0 getDefaultViewModelProviderFactory() {
        return c.u(this, super.getDefaultViewModelProviderFactory());
    }

    private void initializeComponentContext() {
        if(this.componentContext == null) {
            this.componentContext = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.disableGetContextFix = u0.I(super.getContext());
        }
    }

    public void inject() {
        if(!this.injected) {
            this.injected = true;
            ((MelonBaseFragment_GeneratedInjector)this.generatedComponent()).injectMelonBaseFragment(((MelonBaseFragment)this));
        }
    }

    @Override  // androidx.fragment.app.I
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.componentContext == null || i.b(this.componentContext) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.initializeComponentContext();
        this.inject();
    }

    @Override  // androidx.fragment.app.I
    public void onAttach(Context context0) {
        super.onAttach(context0);
        this.initializeComponentContext();
        this.inject();
    }

    @Override  // androidx.fragment.app.I
    public LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

