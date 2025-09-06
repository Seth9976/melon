package b;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.i0;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;

public final class k extends r implements a {
    public final int f;
    public final ComponentActivity g;

    public k(ComponentActivity componentActivity0, int v) {
        this.f = v;
        this.g = componentActivity0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                Application application0 = this.g.getApplication();
                return this.g.getIntent() == null ? new i0(application0, this.g, null) : new i0(application0, this.g, this.g.getIntent().getExtras());
            }
            case 1: {
                this.g.reportFullyDrawn();
                return H.a;
            }
            case 2: {
                k k0 = new k(this.g, 1);
                return new m(this.g.reportFullyDrawnExecutor, k0);
            }
            default: {
                ComponentActivity componentActivity0 = this.g;
                t t0 = new t(new c(componentActivity0, 1));
                if(Build.VERSION.SDK_INT >= 33) {
                    if(!q.b(Looper.myLooper(), Looper.getMainLooper())) {
                        new Handler(Looper.getMainLooper()).post(new l(0, componentActivity0, t0));
                        return t0;
                    }
                    componentActivity0.addObserverForBackInvoker(t0);
                }
                return t0;
            }
        }
    }
}

