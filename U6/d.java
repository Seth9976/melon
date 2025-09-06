package u6;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import b.a;

public final class d implements OnBackAnimationCallback {
    public final b a;
    public final e b;

    public d(e e0, b b0) {
        this.b = e0;
        this.a = b0;
    }

    @Override  // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        if(this.b.a != null) {
            this.a.b();
        }
    }

    @Override  // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.a.d();
    }

    @Override  // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent0) {
        if(this.b.a != null) {
            a a0 = new a(backEvent0);
            this.a.c(a0);
        }
    }

    @Override  // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent0) {
        if(this.b.a != null) {
            a a0 = new a(backEvent0);
            this.a.a(a0);
        }
    }
}

