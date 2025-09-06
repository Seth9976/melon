package bd;

import U4.F;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.b0;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.jvm.internal.q;
import m4.e;
import m4.g;

public final class b extends CustomTarget {
    public final int a;
    public final b0 b;

    public b(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    private final void a(Drawable drawable0) {
    }

    private final void b(Drawable drawable0) {
    }

    private final void c(Drawable drawable0) {
    }

    private final void d(Drawable drawable0) {
    }

    private final void e(Drawable drawable0) {
    }

    private final void f(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        switch(this.a) {
            case 0: {
                q.g(((Drawable)object0), "resource");
                if(((Drawable)object0) instanceof WebpDrawable) {
                    ((WebpDrawable)(((Drawable)object0))).setLoopCount(0);
                    ((WebpDrawable)(((Drawable)object0))).start();
                }
                this.b.setValue(((Drawable)object0));
                return;
            }
            case 1: {
                q.g(((Drawable)object0), "resource");
                if(((Drawable)object0) instanceof WebpDrawable) {
                    ((WebpDrawable)(((Drawable)object0))).setLoopCount(0);
                    ((WebpDrawable)(((Drawable)object0))).start();
                }
                this.b.setValue(((Drawable)object0));
                return;
            }
            case 2: {
                q.g(((Drawable)object0), "resource");
                if(((Drawable)object0) instanceof WebpDrawable) {
                    ((WebpDrawable)(((Drawable)object0))).setLoopCount(0);
                    ((WebpDrawable)(((Drawable)object0))).start();
                }
                this.b.setValue(((Drawable)object0));
                return;
            }
            case 3: {
                q.g(((Drawable)object0), "resource");
                if(((Drawable)object0) instanceof WebpDrawable) {
                    ((WebpDrawable)(((Drawable)object0))).setLoopCount(0);
                    ((WebpDrawable)(((Drawable)object0))).start();
                }
                this.b.setValue(((Drawable)object0));
                return;
            }
            case 4: {
                q.g(((Bitmap)object0), "bitmap");
                e e1 = new e(((Bitmap)object0));
                e1.a = 24;
                g g1 = e1.a().e;
                if(g1 != null) {
                    Integer integer1 = F.C(g1);
                    this.b.setValue(integer1);
                }
                return;
            }
            default: {
                q.g(((Bitmap)object0), "bitmap");
                e e0 = new e(((Bitmap)object0));
                e0.a = 24;
                g g0 = e0.a().e;
                if(g0 != null) {
                    Integer integer0 = F.C(g0);
                    this.b.setValue(integer0);
                }
            }
        }
    }
}

