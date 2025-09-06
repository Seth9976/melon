package u2;

import B3.n;
import F.b0;
import N4.P;
import N4.Q;
import N4.T;
import android.os.SystemClock;
import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;
import androidx.collection.V;
import androidx.fragment.app.l;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import pc.t;
import y8.s;

public final class a implements Choreographer.FrameCallback {
    public final s a;

    public a(s s0) {
        this.a = s0;
    }

    // This method was un-flattened
    @Override  // android.view.Choreographer$FrameCallback
    public final void doFrame(long v) {
        long v14;
        long v13;
        long v12;
        long v11;
        float f4;
        int v7;
        b b0 = (b)((t)this.a.a).b;
        long v1 = SystemClock.uptimeMillis();
        ArrayList arrayList0 = b0.b;
        long v2 = SystemClock.uptimeMillis();
        int v3 = 0;
        while(v3 < arrayList0.size()) {
            e e0 = (e)arrayList0.get(v3);
            if(e0 != null) {
                V v4 = b0.a;
                Long long0 = (Long)v4.get(e0);
                if(long0 == null) {
                label_13:
                    long v5 = e0.i;
                    if(v5 == 0L) {
                        e0.i = v1;
                        e0.b(e0.b);
                    }
                    else {
                        long v6 = v1 - v5;
                        e0.i = v1;
                        if(e0.o) {
                            float f = e0.n;
                            if(f != 3.402823E+38f) {
                                e0.m.i = (double)f;
                                e0.n = 3.402823E+38f;
                            }
                            e0.b = (float)e0.m.i;
                            e0.a = 0.0f;
                            e0.o = false;
                            v7 = v3;
                            goto label_51;
                        }
                        else {
                            if(e0.n == 3.402823E+38f) {
                                v7 = v3;
                                b0 b02 = e0.m.b(((double)e0.b), ((double)e0.a), v6);
                                e0.b = b02.a;
                                e0.a = b02.b;
                            }
                            else {
                                v7 = v3;
                                b0 b00 = e0.m.b(((double)e0.b), ((double)e0.a), v6 / 2L);
                                e0.m.i = (double)e0.n;
                                e0.n = 3.402823E+38f;
                                b0 b01 = e0.m.b(((double)b00.a), ((double)b00.b), v6 / 2L);
                                e0.b = b01.a;
                                e0.a = b01.b;
                            }
                            float f1 = Math.min(Math.max(e0.b, e0.h), e0.g);
                            e0.b = f1;
                            float f2 = e0.a;
                            f f3 = e0.m;
                            f3.getClass();
                            if(((double)Math.abs(f2)) >= f3.e || ((double)Math.abs(f1 - ((float)f3.i))) >= f3.d) {
                                f4 = Math.max(Math.min(e0.b, e0.g), e0.h);
                                e0.b = f4;
                                e0.b(f4);
                                v13 = v1;
                                v14 = v2;
                            }
                            else {
                                e0.b = (float)e0.m.i;
                                e0.a = 0.0f;
                            label_51:
                                f4 = Math.max(Math.min(e0.b, e0.g), e0.h);
                                e0.b = f4;
                                e0.b(f4);
                                ArrayList arrayList1 = e0.k;
                                e0.f = false;
                                ThreadLocal threadLocal0 = b.f;
                                if(threadLocal0.get() == null) {
                                    threadLocal0.set(new b());
                                }
                                b b1 = (b)threadLocal0.get();
                                b1.a.remove(e0);
                                ArrayList arrayList2 = b1.b;
                                int v8 = arrayList2.indexOf(e0);
                                if(v8 >= 0) {
                                    arrayList2.set(v8, null);
                                    b1.e = true;
                                }
                                e0.i = 0L;
                                e0.c = false;
                                int v9 = 0;
                                while(v9 < arrayList1.size()) {
                                    if(arrayList1.get(v9) == null) {
                                        v11 = v1;
                                        v12 = v2;
                                    }
                                    else {
                                        Q q0 = ((P)arrayList1.get(v9)).a;
                                        TransitionSet transitionSet0 = q0.g;
                                        n n0 = T.t;
                                        if(Float.compare(e0.b, 1.0f) < 0) {
                                            long v10 = transitionSet0.S;
                                            Transition transition0 = transitionSet0.P(0);
                                            Transition transition1 = transition0.D;
                                            v11 = v1;
                                            transition0.D = null;
                                            v12 = v2;
                                            transitionSet0.F(-1L, q0.a);
                                            transitionSet0.F(v10, -1L);
                                            q0.a = v10;
                                            l l0 = q0.f;
                                            if(l0 != null) {
                                                l0.run();
                                            }
                                            transitionSet0.G.clear();
                                            if(transition1 != null) {
                                                transition1.x(transition1, n0, true);
                                            }
                                        }
                                        else {
                                            v11 = v1;
                                            v12 = v2;
                                            transitionSet0.x(transitionSet0, n0, false);
                                        }
                                    }
                                    ++v9;
                                    v1 = v11;
                                    v2 = v12;
                                }
                                v13 = v1;
                                v14 = v2;
                                for(int v15 = arrayList1.size() - 1; v15 >= 0; --v15) {
                                    if(arrayList1.get(v15) == null) {
                                        arrayList1.remove(v15);
                                    }
                                }
                            }
                            goto label_119;
                        }
                    }
                }
                else if(((long)long0) < v2) {
                    v4.remove(e0);
                    goto label_13;
                }
            }
            v13 = v1;
            v14 = v2;
            v7 = v3;
        label_119:
            v3 = v7 + 1;
            v1 = v13;
            v2 = v14;
        }
        if(b0.e) {
            for(int v16 = arrayList0.size() - 1; v16 >= 0; --v16) {
                if(arrayList0.get(v16) == null) {
                    arrayList0.remove(v16);
                }
            }
            b0.e = false;
        }
        if(arrayList0.size() > 0) {
            if(b0.d == null) {
                b0.d = new s(b0.c);
            }
            ((Choreographer)b0.d.b).postFrameCallback(((a)b0.d.c));
        }
    }
}

