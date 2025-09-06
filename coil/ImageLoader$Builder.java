package coil;

import android.content.Context;
import gd.r5;
import i5.b;
import i5.d;
import i5.n;
import ie.g;
import ie.r;
import je.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t5.c;
import x5.e;
import x5.j;
import x5.k;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"coil/ImageLoader$Builder", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ImageLoader.Builder {
    public final Context a;
    public c b;
    public g c;
    public g d;
    public b e;
    public final j f;
    public k g;

    public ImageLoader.Builder(@NotNull Context context0) {
        this.a = context0.getApplicationContext();
        this.b = e.a;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new j();
        this.g = null;
    }

    public final n a() {
        c c0 = this.b;
        r r0 = d3.g.Q(new d(this, 0));
        g g0 = this.c;
        if(g0 == null) {
            g0 = d3.g.Q(new d(this, 1));
        }
        g g1 = this.d;
        if(g1 == null) {
            g1 = d3.g.Q(new r5(8));
        }
        b b0 = this.e;
        if(b0 == null) {
            b b1 = new b(w.a, w.a, w.a, w.a, w.a);
            return new n(this.a, c0, r0, g0, g1, b1, this.f, this.g);
        }
        return new n(this.a, c0, r0, g0, g1, b0, this.f, this.g);
    }
}

