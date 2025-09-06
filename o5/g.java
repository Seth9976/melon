package o5;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.memory.MemoryCache.Key;
import e1.G;
import i5.c;
import ie.H;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import r5.b;
import t5.j;
import t5.o;
import t5.s;
import we.n;

public final class g extends i implements n {
    public final j B;
    public final Object D;
    public final o E;
    public final c G;
    public final MemoryCache.Key I;
    public final l M;
    public int r;
    public final o5.i w;

    public g(o5.i i0, j j0, Object object0, o o0, c c0, MemoryCache.Key memoryCache$Key0, l l0, Continuation continuation0) {
        this.w = i0;
        this.B = j0;
        this.D = object0;
        this.E = o0;
        this.G = c0;
        this.I = memoryCache$Key0;
        this.M = l0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z;
        Object object1;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object1 = o5.i.c(this.w, this.B, this.D, this.E, this.G, this);
                if(object1 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                object1 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        x5.l l0 = this.w.b;
        synchronized(l0) {
            i5.n n0 = (i5.n)l0.a.get();
            if(n0 == null) {
                l0.b();
            }
            else if(l0.b == null) {
                l0.b = n0.a;
                n0.a.registerComponentCallbacks(l0);
            }
        }
        E9.g g0 = this.w.e;
        MemoryCache.Key memoryCache$Key0 = this.I;
        if(this.B.q.b) {
            b b0 = (b)((i5.n)g0.a).c.getValue();
            if(b0 == null || memoryCache$Key0 == null) {
                z = false;
            }
            else {
                Drawable drawable0 = ((o5.a)object1).a;
                BitmapDrawable bitmapDrawable0 = drawable0 instanceof BitmapDrawable ? ((BitmapDrawable)drawable0) : null;
                if(bitmapDrawable0 == null) {
                    z = false;
                }
                else {
                    Bitmap bitmap0 = bitmapDrawable0.getBitmap();
                    if(bitmap0 == null) {
                        z = false;
                    }
                    else {
                        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                        linkedHashMap0.put("coil#is_sampled", Boolean.valueOf(((o5.a)object1).b));
                        String s = ((o5.a)object1).d;
                        if(s != null) {
                            linkedHashMap0.put("coil#disk_cache_key", s);
                        }
                        Map map0 = G.I(memoryCache$Key0.b);
                        MemoryCache.Key memoryCache$Key1 = new MemoryCache.Key(memoryCache$Key0.a, map0);
                        Map map1 = G.I(linkedHashMap0);
                        b0.a.b(memoryCache$Key1, bitmap0, map1);
                        z = true;
                    }
                }
            }
        }
        else {
            z = false;
        }
        Drawable drawable1 = ((o5.a)object1).a;
        k5.g g1 = ((o5.a)object1).c;
        MemoryCache.Key memoryCache$Key2 = z ? this.I : null;
        String s1 = ((o5.a)object1).d;
        boolean z1 = ((o5.a)object1).b;
        return this.M == null || !this.M.g ? new s(drawable1, this.B, g1, memoryCache$Key2, s1, z1, false) : new s(drawable1, this.B, g1, memoryCache$Key2, s1, z1, true);
    }
}

