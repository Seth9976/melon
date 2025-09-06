package com.iloen.melon.activity;

import androidx.appcompat.app.h;
import androidx.fragment.app.I;
import b.a;
import l8.o;

public abstract class Hilt_CoverScreenActivity extends PopupFragmentActivity {
    private boolean injected;

    public Hilt_CoverScreenActivity() {
        this.injected = false;
        this._initHiltInternal();
    }

    private void _initHiltInternal() {
        this.addOnContextAvailableListener(new h(this, 3));
    }

    @Override  // com.iloen.melon.activity.Hilt_PermissionSupportActivity
    public void inject() {
        if(!this.injected) {
            this.injected = true;
            o o0 = (o)this.generatedComponent();
            CoverScreenActivity coverScreenActivity0 = (CoverScreenActivity)this;
            o0.getClass();
        }
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }
}

