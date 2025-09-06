package i6;

import android.view.View;
import androidx.datastore.preferences.protobuf.m;
import c2.B0;
import c2.l0;
import e6.a;
import java.util.List;
import x9.c;

public final class e extends m {
    public final View c;
    public int d;
    public int e;
    public final int[] f;

    public e(View view0) {
        super(0);
        this.f = new int[2];
        this.c = view0;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void d(l0 l00) {
        this.c.setTranslationY(0.0f);
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void e(l0 l00) {
        this.c.getLocationOnScreen(this.f);
        this.d = this.f[1];
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final B0 f(B0 b00, List list0) {
        for(Object object0: list0) {
            l0 l00 = (l0)object0;
            if((l00.a.d() & 8) != 0) {
                int v = this.e;
                float f = l00.a.c();
                this.c.setTranslationY(((float)a.c(v, 0, f)));
                return b00;
            }
            if(false) {
                break;
            }
        }
        return b00;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final c g(l0 l00, c c0) {
        this.c.getLocationOnScreen(this.f);
        int v = this.d - this.f[1];
        this.e = v;
        this.c.setTranslationY(((float)v));
        return c0;
    }
}

