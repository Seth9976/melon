package j;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.j1;
import c2.c0;
import c2.d0;
import java.util.ArrayList;

public final class h {
    public final ArrayList a;
    public long b;
    public Interpolator c;
    public d0 d;
    public boolean e;
    public final j1 f;

    public h() {
        this.b = -1L;
        this.f = new j1(this);
        this.a = new ArrayList();
    }

    public final void a() {
        if(!this.e) {
            return;
        }
        for(Object object0: this.a) {
            ((c0)object0).b();
        }
        this.e = false;
    }

    public final void b() {
        if(this.e) {
            return;
        }
        for(Object object0: this.a) {
            c0 c00 = (c0)object0;
            long v = this.b;
            if(v >= 0L) {
                c00.c(v);
            }
            Interpolator interpolator0 = this.c;
            if(interpolator0 != null) {
                View view0 = (View)c00.a.get();
                if(view0 != null) {
                    view0.animate().setInterpolator(interpolator0);
                }
            }
            if(this.d != null) {
                c00.d(this.f);
            }
            View view1 = (View)c00.a.get();
            if(view1 != null) {
                view1.animate().start();
            }
        }
        this.e = true;
    }
}

