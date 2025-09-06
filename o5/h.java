package o5;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d5.w;
import i5.c;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import oe.i;
import t5.j;
import t5.o;
import we.n;
import x5.g;
import x5.k;

public final class h extends i implements n {
    public int B;
    public int D;
    public int E;
    public Object G;
    public final o5.i I;
    public final a M;
    public final o N;
    public final List S;
    public final c T;
    public final j V;
    public List r;
    public o w;

    public h(o5.i i0, a a0, o o0, List list0, c c0, j j0, Continuation continuation0) {
        this.I = i0;
        this.M = a0;
        this.N = o0;
        this.S = list0;
        this.T = c0;
        this.V = j0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.I, this.M, this.N, this.S, this.T, this.V, continuation0);
        continuation1.G = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        Bitmap bitmap2;
        o o1;
        int v;
        Bitmap bitmap1;
        List list0;
        CoroutineScope coroutineScope0;
        c c0 = this.T;
        a a0 = this.M;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                coroutineScope0 = (CoroutineScope)this.G;
                Drawable drawable0 = a0.a;
                k k0 = this.I.d;
                list0 = this.S;
                o o0 = this.N;
                if(drawable0 instanceof BitmapDrawable) {
                    Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
                    Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
                    if(bitmap$Config0 == null) {
                        bitmap$Config0 = Bitmap.Config.ARGB_8888;
                    }
                    if(je.n.Q(g.a, bitmap$Config0)) {
                        bitmap1 = bitmap0;
                    }
                    else {
                        if(k0 != null) {
                            k.a("EngineInterceptor", 4, "Converting bitmap with config " + bitmap$Config0 + " to apply transformations: " + list0 + '.', null);
                        }
                        bitmap1 = w.s(drawable0, o0.b, o0.d, o0.e, o0.f);
                    }
                }
                else {
                    if(k0 != null) {
                        k.a("EngineInterceptor", 4, "Converting drawable of type " + drawable0.getClass().getCanonicalName() + " to apply transformations: " + list0 + '.', null);
                    }
                    bitmap1 = w.s(drawable0, o0.b, o0.d, o0.e, o0.f);
                }
                c0.getClass();
                v = 0;
                o1 = o0;
                bitmap2 = bitmap1;
                v1 = list0.size();
                break;
            }
            case 1: {
                v1 = this.D;
                int v2 = this.B;
                o1 = this.w;
                list0 = this.r;
                coroutineScope0 = (CoroutineScope)this.G;
                d5.n.D(object0);
                bitmap2 = (Bitmap)object0;
                CoroutineScopeKt.ensureActive(coroutineScope0);
                v = v2 + 1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(v >= v1) {
            c0.getClass();
            return new a(new BitmapDrawable(this.V.a.getResources(), bitmap2), a0.b, a0.c, a0.d);
        }
        if(list0.get(v) != null) {
            throw new ClassCastException();
        }
        this.G = coroutineScope0;
        this.r = list0;
        this.w = o1;
        this.B = v;
        this.D = v1;
        this.E = 1;
        throw null;
    }
}

