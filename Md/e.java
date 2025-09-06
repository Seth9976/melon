package md;

import I0.a;
import O.F;
import O.v;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.lifecycle.y;
import cd.V2;
import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import r1.q;

public final class e implements a {
    public final F a;
    public final h b;
    public final float c;

    public e(F f0, h h0, float f1) {
        this.a = f0;
        this.b = h0;
        this.c = f1;
    }

    @Override  // I0.a
    public final Object onPostFling-RZ2iAVY(long v, long v1, Continuation continuation0) {
        this.b.c = f.c;
        return new q(0L);
    }

    @Override  // I0.a
    public final long onPostScroll-DzOQY0M(long v, long v1, int v2) {
        return 0L;
    }

    @Override  // I0.a
    public final Object onPreFling-QWom1Mo(long v, Continuation continuation0) {
        h h0 = this.b;
        if(Float.compare(q.c(v), 0.0f) < 0) {
            h0.c = f.a;
            return new q(0L);
        }
        if(q.c(v) > 0.0f) {
            h0.c = f.b;
        }
        return new q(0L);
    }

    @Override  // I0.a
    public final long onPreScroll-OzD1aCk(long v, int v1) {
        if(Float.intBitsToFloat(((int)(v >> 0x20))) == 0.0f) {
            F f0 = this.a;
            int v2 = f0.h().n;
            h h0 = this.b;
            boolean z = false;
            if(Float.compare(h0.q, 0.0f) == 0) {
                for(Object object0: ((Iterable)f0.h().k)) {
                    HashMap hashMap0 = h0.r;
                    hashMap0.put(((v)object0).a, ((v)object0).n);
                    if(h0.q == 0.0f && hashMap0.size() >= v2) {
                        int v3 = 0;
                        for(Object object1: hashMap0.entrySet()) {
                            v3 += ((Number)((Map.Entry)object1).getValue()).intValue();
                        }
                        h0.q = -(((float)v3) - h0.i + h0.f + h0.k + ((float)h0.l) + (h0.d ? 0.0f : h0.h));
                    }
                }
            }
            if(v1 == 2 && (Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) < 0.0f && h0.c == f.a || Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) > 0.0f && h0.c == f.b)) {
                f0.e(-Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
                if(h0.c() > 0.0f) {
                    h0.e(0.0f);
                }
                else if(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) > 0.0f) {
                    h0.e(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + h0.c());
                    if(h0.c() > 0.0f) {
                        h0.e(0.0f);
                    }
                }
                else if(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) < 0.0f) {
                    h0.e(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + h0.c());
                    if(h0.q != 0.0f) {
                        float f1 = h0.c();
                        float f2 = h0.q;
                        if(f1 < f2) {
                            h0.e(f2);
                            y y0 = h0.a;
                            if(y0 != null) {
                                BuildersKt__Builders_commonKt.launch$default(y0, null, null, new c(f0, null), 3, null);
                            }
                        }
                    }
                }
            }
            else if(v1 == 1) {
                h0.c = f.c;
                f0.e(-Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
                if(h0.c() > 0.0f) {
                    h0.e(0.0f);
                }
                else if(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) > 0.0f) {
                    h0.e(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + h0.c());
                    if(h0.c() > 0.0f) {
                        h0.e(0.0f);
                    }
                }
                else if(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) < 0.0f) {
                    h0.e(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + h0.c());
                    if(h0.q != 0.0f) {
                        float f3 = h0.c();
                        float f4 = h0.q;
                        if(f3 < f4) {
                            h0.e(f4);
                            y y1 = h0.a;
                            if(y1 != null) {
                                BuildersKt__Builders_commonKt.launch$default(y1, null, null, new d(f0, null), 3, null);
                            }
                        }
                    }
                }
            }
            else if(h0.c() > h0.e) {
                f0.e(-Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
                h0.e(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + h0.c());
            }
            float f5 = h0.c();
            float f6 = this.c;
            if(f5 < -f6) {
                z = true;
            }
            if(z != ((Boolean)((O0)h0.p).getValue()).booleanValue()) {
                ((O0)h0.p).setValue(Boolean.valueOf(z));
                V2 v20 = h0.w;
                if(v20 != null) {
                    v20.invoke(0.0f, Boolean.valueOf(z));
                    goto label_78;
                }
                kotlin.jvm.internal.q.m("onCollapsed");
                throw null;
            }
        label_78:
            b0 b00 = h0.p;
            float f7 = h0.o;
            if(h0.c() <= f6 * -1.0f) {
                h0.o = 1.0f;
                V2 v21 = h0.w;
                if(v21 != null) {
                    v21.invoke(1.0f, ((O0)b00).getValue());
                    goto label_93;
                }
                kotlin.jvm.internal.q.m("onCollapsed");
                throw null;
            }
            float f8 = h0.c() / (f6 * -1.0f);
            h0.o = f8;
            V2 v22 = h0.w;
            if(v22 != null) {
                v22.invoke(f8, ((O0)b00).getValue());
            label_93:
                if(v1 == 2 && f7 > 0.0f && h0.o == 0.0f) {
                    y y2 = h0.a;
                    if(y2 != null) {
                        BuildersKt__Builders_commonKt.launch$default(y2, null, null, new g(f0, null), 3, null);
                    }
                }
                return v;
            }
            kotlin.jvm.internal.q.m("onCollapsed");
            throw null;
        }
        return 0L;
    }
}

