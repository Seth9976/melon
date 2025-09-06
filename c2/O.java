package c2;

import android.view.MenuItem;
import androidx.fragment.app.a0;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class o {
    public final Runnable a;
    public final CopyOnWriteArrayList b;
    public final HashMap c;

    public o(Runnable runnable0) {
        this.b = new CopyOnWriteArrayList();
        this.c = new HashMap();
        this.a = runnable0;
    }

    public final boolean a(MenuItem menuItem0) {
        for(Object object0: this.b) {
            if(((a0)(((p)object0))).a.p(menuItem0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void b(p p0) {
        this.b.remove(p0);
        n n0 = (n)this.c.remove(p0);
        if(n0 != null) {
            n0.a.c(n0.b);
            n0.b = null;
        }
        this.a.run();
    }
}

