package com.iloen.melon.activity;

import E9.w;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.h;
import androidx.lifecycle.o0;
import de.g;
import ee.j;
import fe.b;
import k8.e;
import kc.s2;
import l8.u;
import x9.a;

public abstract class Hilt_MelonAppSvcActivity extends AppCompatActivity implements b {
    private volatile ee.b componentManager;
    private final Object componentManagerLock;
    private boolean injected;
    private j savedStateHandleHolder;

    public Hilt_MelonAppSvcActivity() {
        this.componentManagerLock = new Object();
        this.injected = false;
        this._initHiltInternal();
    }

    public Hilt_MelonAppSvcActivity(int v) {
        super(v);
        this.componentManagerLock = new Object();
        this.injected = false;
        this._initHiltInternal();
    }

    private void _initHiltInternal() {
        this.addOnContextAvailableListener(new h(this, 4));
    }

    public final ee.b componentManager() {
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

    public ee.b createComponentManager() {
        return new ee.b(this);
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        return this.componentManager().generatedComponent();
    }

    @Override  // androidx.activity.ComponentActivity
    public o0 getDefaultViewModelProviderFactory() {
        o0 o00 = super.getDefaultViewModelProviderFactory();
        a a0 = ((e)(((de.a)w.s(this, de.a.class)))).a();
        C9.e e0 = (C9.e)a0.a;
        o00.getClass();
        return new g(e0, o00, ((ea.a)a0.b));
    }

    private void initSavedStateHandleHolder() {
        if(this.getApplication() instanceof b) {
            j j0 = this.componentManager().b();
            this.savedStateHandleHolder = j0;
            if(j0.a == null) {
                j0.a = this.getDefaultViewModelCreationExtras();
            }
        }
    }

    public void inject() {
        if(!this.injected) {
            this.injected = true;
            u u0 = (u)this.generatedComponent();
            ((MelonAppSvcActivity)this).playlistManager = (s2)((e)u0).b.w.get();
            ((MelonAppSvcActivity)this).playerUseCase = ((e)u0).b.k();
            ((MelonAppSvcActivity)this).shuffleRepeatChangeNotifier = ((e)u0).b.s();
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.initSavedStateHandleHolder();
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onDestroy() {
        super.onDestroy();
        j j0 = this.savedStateHandleHolder;
        if(j0 != null) {
            j0.a = null;
        }
    }
}

