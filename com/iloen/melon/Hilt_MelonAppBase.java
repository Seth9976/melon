package com.iloen.melon;

import Ac.h0;
import Pd.i;
import Ub.q;
import Ub.s;
import android.app.Application;
import com.melon.data.database.MelonDatabase;
import d5.t;
import ee.g;
import fe.b;
import i.n.i.b.a.s.e.Ga;
import k8.E;
import k8.o;
import kc.s2;
import kotlinx.coroutines.CoroutineDispatcher;
import w8.V0;

public abstract class Hilt_MelonAppBase extends Application implements b {
    public boolean a;
    public final g b;

    public Hilt_MelonAppBase() {
        this.a = false;
        this.b = new g(new Ga(this, 25));
    }

    public final g componentManager() {
        return this.b;
    }

    public b componentManager() {
        return this.componentManager();
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        return this.componentManager().generatedComponent();
    }

    public void hiltInternalInject() {
        if(!this.a) {
            this.a = true;
            E e0 = (E)this.generatedComponent();
            ((MelonAppBase)this).deviceData = ((o)e0).e();
            ((MelonAppBase)this).playlistManager = (s2)((o)e0).w.get();
            ((MelonAppBase)this).remoteManager = (s)((o)e0).z.get();
            ((MelonAppBase)this).playbackManager = (q)((o)e0).u.get();
            ((MelonAppBase)this).playerUseCase = ((o)e0).k();
            ((MelonAppBase)this).appVisibilityManager = (i)((o)e0).A.get();
            t.e(((o)e0).a.a);
            CoroutineDispatcher coroutineDispatcher0 = h0.C();
            q q0 = (q)((o)e0).u.get();
            s2 s20 = (s2)((o)e0).w.get();
            ((MelonAppBase)this).appWidgetUpdater = new V0(((o)e0).a.a, coroutineDispatcher0, q0, s20);
            ((MelonAppBase)this).melonDatabase = (MelonDatabase)((o)e0).B.get();
        }
    }

    @Override  // android.app.Application
    public void onCreate() {
        this.hiltInternalInject();
        super.onCreate();
    }
}

