package com.iloen.melon.player.playlist.drawernew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.o0;
import com.iloen.melon.player.playlist.PlaylistViewPagerBaseFragment;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import de.c;
import ee.i;
import fe.b;
import h7.u0;

public abstract class Hilt_DrawerPlaylistViewPagerFragment extends PlaylistViewPagerBaseFragment implements b {
    public ViewComponentManager.FragmentContextWrapper a;
    public boolean b;
    public volatile i c;
    public final Object d;
    public boolean e;

    public Hilt_DrawerPlaylistViewPagerFragment() {
        this.d = new Object();
        this.e = false;
    }

    public final i componentManager() {
        if(this.c == null) {
            Object object0 = this.d;
            synchronized(object0) {
                if(this.c == null) {
                    this.c = this.createComponentManager();
                }
            }
        }
        return this.c;
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
        if(super.getContext() == null && !this.b) {
            return null;
        }
        this.l();
        return this.a;
    }

    @Override  // androidx.fragment.app.I
    public o0 getDefaultViewModelProviderFactory() {
        return c.u(this, super.getDefaultViewModelProviderFactory());
    }

    public void inject() {
        if(!this.e) {
            this.e = true;
            ((DrawerPlaylistViewPagerFragment_GeneratedInjector)this.generatedComponent()).injectDrawerPlaylistViewPagerFragment(((DrawerPlaylistViewPagerFragment)this));
        }
    }

    public final void l() {
        if(this.a == null) {
            this.a = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.b = u0.I(super.getContext());
        }
    }

    @Override  // androidx.fragment.app.I
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.a == null || i.b(this.a) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.l();
        this.inject();
    }

    @Override  // androidx.fragment.app.I
    public void onAttach(Context context0) {
        super.onAttach(context0);
        this.l();
        this.inject();
    }

    @Override  // androidx.fragment.app.I
    public LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

