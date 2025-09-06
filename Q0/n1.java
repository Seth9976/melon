package Q0;

import A3.c;
import android.view.View;
import androidx.compose.runtime.u0;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

public final class n1 implements B {
    public final CoroutineScope a;
    public final b0 b;
    public final u0 c;
    public final H d;
    public final View e;

    public n1(CoroutineScope coroutineScope0, b0 b00, u0 u00, H h0, View view0) {
        this.a = coroutineScope0;
        this.b = b00;
        this.c = u00;
        this.d = h0;
        this.e = view0;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        CancellableContinuation cancellableContinuation0;
        switch(r0) {
            case 1: {
                m1 m10 = new m1(this.d, this.c, d0, this, this.e, null);
                BuildersKt__Builders_commonKt.launch$default(this.a, null, CoroutineStart.UNDISPATCHED, m10, 1, null);
                return;
            }
            case 2: {
                b0 b00 = this.b;
                if(b00 != null) {
                    c c0 = (c)b00.c;
                    synchronized(c0.b) {
                        if(!c0.a) {
                            ArrayList arrayList0 = (ArrayList)c0.c;
                            c0.c = (ArrayList)c0.d;
                            c0.d = arrayList0;
                            c0.a = true;
                            int v1 = arrayList0.size();
                            for(int v2 = 0; v2 < v1; ++v2) {
                                ((Continuation)arrayList0.get(v2)).resumeWith(ie.H.a);
                            }
                            arrayList0.clear();
                        }
                    }
                }
                u0 u00 = this.c;
                synchronized(u00.c) {
                    if(u00.t) {
                        u00.t = false;
                        cancellableContinuation0 = u00.u();
                    }
                    else {
                        cancellableContinuation0 = null;
                    }
                }
                if(cancellableContinuation0 != null) {
                    cancellableContinuation0.resumeWith(ie.H.a);
                }
                return;
            }
            case 3: {
                synchronized(this.c.c) {
                    this.c.t = true;
                }
                return;
            }
            case 4: {
                this.c.t();
            }
        }
    }
}

