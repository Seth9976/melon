package b;

import androidx.activity.ComponentActivity;
import kotlin.jvm.internal.q;

public final class c implements Runnable {
    public final int a;
    public final ComponentActivity b;

    public c(ComponentActivity componentActivity0, int v) {
        this.a = v;
        this.b = componentActivity0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            try {
                this.b.super.onBackPressed();
                return;
            }
            catch(IllegalStateException illegalStateException0) {
                if(!q.b(illegalStateException0.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw illegalStateException0;
                }
            }
            catch(NullPointerException nullPointerException0) {
                if(!q.b(nullPointerException0.getMessage(), "Attempt to invoke virtual method \'android.os.Handler android.app.FragmentHostCallback.getHandler()\' on a null object reference")) {
                    throw nullPointerException0;
                }
            }
            return;
        }
        ComponentActivity.menuHostHelper$lambda$0(this.b);
    }
}

