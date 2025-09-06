package coil.request;

import D2.E0;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap.Config;
import android.widget.ImageView.ScaleType;
import androidx.lifecycle.D;
import androidx.lifecycle.t;
import coil.memory.MemoryCache.Key;
import coil.size.DisplaySizeResolver;
import com.iloen.melon.custom.MelonImageView;
import e1.G;
import java.util.LinkedHashMap;
import java.util.List;
import je.C;
import je.w;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers.Builder;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
import t5.c;
import t5.i;
import t5.j;
import t5.l;
import t5.q;
import u5.d;
import u5.f;
import u5.h;
import v5.a;
import v5.b;
import w5.e;
import x5.g;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"coil/request/ImageRequest$Builder", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ImageRequest.Builder {
    public final Context a;
    public c b;
    public Object c;
    public b d;
    public i e;
    public MemoryCache.Key f;
    public u5.c g;
    public k5.i h;
    public final List i;
    public e j;
    public final Builder k;
    public final LinkedHashMap l;
    public final boolean m;
    public Boolean n;
    public final boolean o;
    public E0 p;
    public MemoryCache.Key q;
    public h r;
    public f s;
    public t t;
    public h u;
    public f v;

    public ImageRequest.Builder(@NotNull Context context0) {
        this.a = context0;
        this.b = x5.e.a;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = w.a;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = true;
        this.n = null;
        this.o = true;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
    }

    public ImageRequest.Builder(j j0, Context context0) {
        this.a = context0;
        this.b = j0.D;
        this.c = j0.b;
        this.d = j0.c;
        this.e = j0.d;
        this.f = j0.e;
        this.g = j0.C.d;
        this.h = j0.h;
        this.i = j0.i;
        this.j = j0.C.c;
        this.k = j0.k.newBuilder();
        this.l = C.a0(j0.l.a);
        this.m = j0.m;
        this.n = j0.C.e;
        this.o = j0.p;
        this.p = new E0(j0.A);
        this.q = j0.B;
        this.r = j0.C.a;
        this.s = j0.C.b;
        if(j0.a == context0) {
            this.t = j0.x;
            this.u = j0.y;
            this.v = j0.z;
            return;
        }
        this.t = null;
        this.u = null;
        this.v = null;
    }

    public final j a() {
        MelonImageView melonImageView1;
        l l1;
        CoroutineDispatcher coroutineDispatcher4;
        boolean z;
        l l0 = this.c;
        if(l0 == null) {
            l0 = l.b;
        }
        b b0 = this.d;
        i i0 = this.e;
        MemoryCache.Key memoryCache$Key0 = this.f;
        Bitmap.Config bitmap$Config0 = this.b.g;
        u5.c c0 = this.g == null ? this.b.f : this.g;
        k5.i i1 = this.h;
        e e0 = this.j == null ? this.b.e : this.j;
        Headers headers0 = this.k == null ? null : this.k.build();
        if(headers0 == null) {
            headers0 = g.c;
        }
        t5.t t0 = this.l == null ? null : new t5.t(G.I(this.l));
        if(t0 == null) {
            t0 = t5.t.b;
        }
        Boolean boolean0 = this.n;
        if(boolean0 == null) {
            this.b.getClass();
            z = true;
        }
        else {
            z = boolean0.booleanValue();
        }
        this.b.getClass();
        t5.b b1 = this.b.h;
        t5.b b2 = this.b.i;
        t5.b b3 = this.b.j;
        CoroutineDispatcher coroutineDispatcher0 = this.b.b;
        CoroutineDispatcher coroutineDispatcher1 = this.b.d;
        CoroutineDispatcher coroutineDispatcher2 = this.b.c;
        t t1 = this.t;
        CoroutineDispatcher coroutineDispatcher3 = this.b.a;
        Context context0 = this.a;
        if(t1 == null) {
            coroutineDispatcher4 = coroutineDispatcher1;
            for(Context context1 = this.d instanceof a ? ((a)this.d).b.getContext() : context0; true; context1 = ((ContextWrapper)context1).getBaseContext()) {
                if(context1 instanceof D) {
                    t1 = ((D)context1).getLifecycle();
                }
                else if(context1 instanceof ContextWrapper) {
                    continue;
                }
                else {
                    t1 = null;
                }
                if(t1 != null) {
                    break;
                }
                t1 = t5.h.b;
                break;
            }
        }
        else {
            coroutineDispatcher4 = coroutineDispatcher1;
        }
        h h0 = this.r;
        if(h0 == null) {
            h0 = this.u;
            if(h0 == null) {
                b b4 = this.d;
                if(b4 instanceof a) {
                    MelonImageView melonImageView0 = ((a)b4).b;
                    ImageView.ScaleType imageView$ScaleType0 = melonImageView0.getScaleType();
                    l1 = l0;
                    h0 = imageView$ScaleType0 == ImageView.ScaleType.CENTER || imageView$ScaleType0 == ImageView.ScaleType.MATRIX ? new d() : new u5.e(melonImageView0);
                }
                else {
                    l1 = l0;
                    h0 = new DisplaySizeResolver(context0);
                }
            }
            else {
                l1 = l0;
            }
        }
        else {
            l1 = l0;
        }
        f f0 = this.s;
        if(f0 == null) {
            f0 = this.v;
            if(f0 == null) {
                u5.e e1 = this.r instanceof u5.e ? ((u5.e)this.r) : null;
                if(e1 == null) {
                    a a0 = this.d instanceof a ? ((a)this.d) : null;
                    melonImageView1 = a0 == null ? null : a0.b;
                }
                else {
                    melonImageView1 = e1.a;
                }
                if(melonImageView1 == null) {
                    f0 = f.b;
                }
                else {
                    ImageView.ScaleType imageView$ScaleType1 = melonImageView1.getScaleType();
                    int v = imageView$ScaleType1 == null ? -1 : x5.f.a[imageView$ScaleType1.ordinal()];
                    f0 = v == 1 || v == 2 || v == 3 || v == 4 ? f.b : f.a;
                }
            }
        }
        q q0 = this.p == null ? null : new q(G.I(this.p.a));
        if(q0 == null) {
            q0 = q.b;
        }
        MemoryCache.Key memoryCache$Key1 = this.q;
        t5.d d0 = new t5.d(this.r, this.s, this.j, this.g, this.n);
        return new j(context0, l1, b0, i0, memoryCache$Key0, bitmap$Config0, c0, i1, this.i, e0, headers0, t0, this.m, z, false, this.o, b1, b2, b3, coroutineDispatcher3, coroutineDispatcher0, coroutineDispatcher2, coroutineDispatcher4, t1, h0, f0, q0, memoryCache$Key1, d0, this.b);
    }

    public final void b() {
        this.t = null;
        this.u = null;
        this.v = null;
    }
}

