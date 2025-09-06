package androidx.lifecycle;

import android.os.Handler;
import android.widget.FrameLayout;
import androidx.viewpager2.adapter.b;
import androidx.viewpager2.adapter.i;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import kotlin.jvm.internal.q;

public final class h implements B {
    public final int a;
    public final Object b;
    public final Object c;

    public h(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public h(C c0) {
        this.a = 2;
        super();
        this.b = c0;
        e e0 = e.c;
        Class class0 = c0.getClass();
        c c1 = (c)e0.a.get(class0);
        if(c1 == null) {
            c1 = e0.a(class0, null);
        }
        this.c = c1;
    }

    public h(f f0, B b0) {
        this.a = 0;
        q.g(f0, "defaultLifecycleObserver");
        super();
        this.b = f0;
        this.c = b0;
    }

    public h(androidx.viewpager2.adapter.h h0, i i0) {
        this.a = 3;
        super();
        this.c = h0;
        this.b = i0;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        switch(this.a) {
            case 0: {
                f f0 = (f)this.b;
                switch(r0) {
                    case 1: {
                        f0.c(d0);
                        break;
                    }
                    case 2: {
                        f0.onStart(d0);
                        break;
                    }
                    case 3: {
                        f0.onResume(d0);
                        break;
                    }
                    case 4: {
                        f0.onPause(d0);
                        break;
                    }
                    case 5: {
                        f0.onStop(d0);
                        break;
                    }
                    case 6: {
                        f0.onDestroy(d0);
                        break;
                    }
                    case 7: {
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                B b0 = (B)this.c;
                if(b0 != null) {
                    b0.onStateChanged(d0, r0);
                }
                return;
            }
            case 1: {
                if(r0 == r.ON_START) {
                    ((t)this.b).c(this);
                    ((E4.e)this.c).d();
                }
                return;
            }
            case 2: {
                c.a(((List)((c)this.c).a.get(r0)), d0, r0, this.b);
                c.a(((List)((c)this.c).a.get(r.ON_ANY)), d0, r0, this.b);
                return;
            }
            case 3: {
                i i0 = (i)this.b;
                androidx.viewpager2.adapter.h h0 = (androidx.viewpager2.adapter.h)this.c;
                if(!h0.shouldDelayFragmentTransactions()) {
                    d0.getLifecycle().c(this);
                    if(((FrameLayout)i0.itemView).isAttachedToWindow()) {
                        h0.placeFragmentInViewHolder(i0);
                    }
                }
                return;
            }
            default: {
                if(r0 == r.ON_DESTROY) {
                    ((Handler)this.b).removeCallbacks(((b)this.c));
                    d0.getLifecycle().c(this);
                }
            }
        }
    }
}

