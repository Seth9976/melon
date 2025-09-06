package b;

import A3.l;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver.OnDrawListener;
import androidx.activity.ComponentActivity;
import kotlin.jvm.internal.q;

public final class i implements ViewTreeObserver.OnDrawListener, h, Runnable {
    public final long a;
    public Runnable b;
    public boolean c;
    public final ComponentActivity d;

    public i(ComponentActivity componentActivity0) {
        this.d = componentActivity0;
        this.a = SystemClock.uptimeMillis() + 10000L;
    }

    public final void a(View view0) {
        if(!this.c) {
            this.c = true;
            view0.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    @Override
    public final void execute(Runnable runnable0) {
        q.g(runnable0, "runnable");
        this.b = runnable0;
        View view0 = this.d.getWindow().getDecorView();
        q.f(view0, "window.decorView");
        if(this.c) {
            if(q.b(Looper.myLooper(), Looper.getMainLooper())) {
                view0.invalidate();
                return;
            }
            view0.postInvalidate();
            return;
        }
        view0.postOnAnimation(new l(this, 26));
    }

    @Override  // android.view.ViewTreeObserver$OnDrawListener
    public final void onDraw() {
        Runnable runnable0 = this.b;
        if(runnable0 != null) {
            runnable0.run();
            this.b = null;
            if(this.d.getFullyDrawnReporter().c) {
                this.c = false;
                this.d.getWindow().getDecorView().post(this);
            }
        }
        else if(SystemClock.uptimeMillis() > this.a) {
            this.c = false;
            this.d.getWindow().getDecorView().post(this);
        }
    }

    @Override
    public final void run() {
        this.d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}

