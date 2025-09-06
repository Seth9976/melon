package com.iloen.melon.activity;

import androidx.appcompat.app.h;
import k8.a;
import k8.e;
import l8.l;
import mb.k;

public abstract class Hilt_BaseActivity extends PermissionSupportActivity {
    private boolean injected;

    public Hilt_BaseActivity() {
        this.injected = false;
        this._initHiltInternal();
    }

    private void _initHiltInternal() {
        this.addOnContextAvailableListener(new h(this, 2));
    }

    @Override  // com.iloen.melon.activity.Hilt_PermissionSupportActivity
    public void inject() {
        if(!this.injected) {
            this.injected = true;
            l l0 = (l)this.generatedComponent();
            ((BaseActivity)this).blockingProgressDialogManage = (a)((e)l0).b.l.get();
            ((BaseActivity)this).playerUseCase = ((e)l0).b.k();
            ((BaseActivity)this).loginUseCase = (k)((e)l0).b.m.get();
            ((BaseActivity)this).kakaoLoginUseCase = ((e)l0).b.f();
            ((BaseActivity)this).tokenCheckUseCase = ((e)l0).b();
        }
    }
}

