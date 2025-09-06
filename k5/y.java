package k5;

import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import d5.n;
import e.k;
import ed.w0;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import m5.b;
import ne.a;
import oe.c;
import okio.Path;
import t5.o;

public final class y implements j {
    public final z a;
    public final o b;

    public y(z z0, o o0) {
        this.a = z0;
        this.b = o0;
    }

    @Override  // k5.j
    public final Object a(Continuation continuation0) {
        y y0;
        C c2;
        u u0;
        if(continuation0 instanceof u) {
            u0 = (u)continuation0;
            int v = u0.E;
            if((v & 0x80000000) == 0) {
                u0 = new u(this, ((c)continuation0));
            }
            else {
                u0.E = v ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, ((c)continuation0));
        }
        Object object0 = u0.B;
        a a0 = a.a;
        switch(u0.E) {
            case 0: {
                n.D(object0);
                C c1 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                w0 w00 = new w0(19, this, c1);
                u0.r = this;
                u0.w = c1;
                u0.E = 1;
                Object object1 = InterruptibleKt.runInterruptible$default(null, w00, u0, 1, null);
                if(object1 == a0) {
                    return a0;
                }
                c2 = c1;
                object0 = object1;
                y0 = this;
                break;
            }
            case 1: {
                c2 = u0.w;
                y0 = (y)u0.r;
                n.D(object0);
                break;
            }
            case 2: {
                C c0 = (C)u0.r;
                n.D(object0);
                return new h(((Drawable)object0), c0.a);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        u0.r = c2;
        u0.w = null;
        u0.E = 2;
        object0 = y0.c(((Drawable)object0), u0);
        return object0 == a0 ? a0 : new h(((Drawable)object0), c2.a);
    }

    public final ImageDecoder.Source b(z z0) {
        Path path0 = z0.m();
        if(path0 != null) {
            return com.iloen.melon.utils.system.a.e(path0.toFile());
        }
        k k0 = z0.o();
        o o0 = this.b;
        if(k0 instanceof k5.a) {
            return com.iloen.melon.utils.system.a.d(o0.a.getAssets(), ((k5.a)k0).f);
        }
        if(k0 instanceof f) {
            return com.iloen.melon.utils.system.a.c(o0.a.getContentResolver(), ((f)k0).f);
        }
        if(k0 instanceof A && ((A)k0).f.equals("com.iloen.melon")) {
            return ImageDecoder.createSource(o0.a.getResources(), ((A)k0).g);
        }
        int v = Build.VERSION.SDK_INT;
        if(v >= 0x1F) {
            return ImageDecoder.createSource(z0.p().readByteArray());
        }
        return v == 30 ? com.iloen.melon.utils.system.a.f(ByteBuffer.wrap(z0.p().readByteArray())) : com.iloen.melon.utils.system.a.e(z0.h().toFile());
    }

    public final Object c(Drawable drawable0, c c0) {
        w w0;
        if(c0 instanceof w) {
            w0 = (w)c0;
            int v = w0.E;
            if((v & 0x80000000) == 0) {
                w0 = new w(this, c0);
            }
            else {
                w0.E = v ^ 0x80000000;
            }
        }
        else {
            w0 = new w(this, c0);
        }
        Object object0 = w0.B;
        a a0 = a.a;
        switch(w0.E) {
            case 0: {
                n.D(object0);
                if(!com.iloen.melon.utils.system.a.w(drawable0)) {
                    return drawable0;
                }
                Integer integer0 = (Integer)this.b.l.a("coil#repeat_count");
                com.iloen.melon.utils.system.a.r(((AnimatedImageDrawable)drawable0), (integer0 == null ? -1 : ((int)integer0)));
                we.a a1 = (we.a)this.b.l.a("coil#animation_start_callback");
                we.a a2 = (we.a)this.b.l.a("coil#animation_end_callback");
                if(a1 != null || a2 != null) {
                    MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain().getImmediate();
                    x x0 = new x(drawable0, a1, a2, null);
                    w0.r = this;
                    w0.w = drawable0;
                    w0.E = 1;
                    if(BuildersKt.withContext(mainCoroutineDispatcher0, x0, w0) == a0) {
                        return a0;
                    }
                }
                return new b(drawable0, this.b.e);
            }
            case 1: {
                drawable0 = w0.w;
                y y0 = w0.r;
                n.D(object0);
                return new b(drawable0, y0.b.e);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

