package y0;

import A0.b;
import B0.e;
import B0.h;
import B0.j;
import B0.l;
import Q0.u;
import android.os.Build.VERSION;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;

public final class d implements z {
    public final u a;
    public final Object b;
    public ViewLayerContainer c;
    public static boolean d = true;

    public d(u u0) {
        this.a = u0;
        this.b = new Object();
    }

    @Override  // y0.z
    public final e a() {
        j j0;
        synchronized(this.b) {
            u u0 = this.a;
            int v1 = Build.VERSION.SDK_INT;
            if(v1 >= 29) {
                u0.getUniqueDrawingId();
            }
            if(v1 >= 29) {
                j0 = new j();
            }
            else if(d.d) {
                try {
                    r r0 = new r();
                    b b0 = new b();
                    j0 = new h(this.a, r0, b0);
                }
                catch(Throwable unused_ex) {
                    d.d = false;
                    u u1 = this.a;
                    ViewLayerContainer viewLayerContainer0 = this.c;
                    if(viewLayerContainer0 == null) {
                        ViewLayerContainer viewLayerContainer1 = new ViewLayerContainer(u1.getContext());
                        u1.addView(viewLayerContainer1, -1);
                        this.c = viewLayerContainer1;
                        viewLayerContainer0 = viewLayerContainer1;
                    }
                    j0 = new l(viewLayerContainer0);
                }
            }
            else {
                u u2 = this.a;
                ViewLayerContainer viewLayerContainer2 = this.c;
                if(viewLayerContainer2 == null) {
                    ViewLayerContainer viewLayerContainer3 = new ViewLayerContainer(u2.getContext());
                    u2.addView(viewLayerContainer3, -1);
                    this.c = viewLayerContainer3;
                    viewLayerContainer2 = viewLayerContainer3;
                }
                j0 = new l(viewLayerContainer2);
            }
            return new e(j0);
        }
    }

    @Override  // y0.z
    public final void b(e e0) {
        synchronized(this.b) {
            if(!e0.s) {
                e0.s = true;
                e0.b();
            }
        }
    }
}

