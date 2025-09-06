package u5;

import Gf.j;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import com.iloen.melon.custom.MelonImageView;
import e1.m;
import e1.u;
import i5.k;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class e implements h {
    public final MelonImageView a;

    public e(MelonImageView melonImageView0) {
        this.a = melonImageView0;
    }

    public static m a(int v, int v1, int v2) {
        if(v == -2) {
            return b.e;
        }
        int v3 = v - v2;
        if(v3 > 0) {
            return new a(v3);
        }
        int v4 = v1 - v2;
        return v4 > 0 ? new a(v4) : null;
    }

    public g b() {
        MelonImageView melonImageView0 = this.a;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = melonImageView0.getLayoutParams();
        int v = -1;
        int v1 = viewGroup$LayoutParams0 == null ? -1 : viewGroup$LayoutParams0.width;
        int v2 = melonImageView0.getWidth();
        int v3 = melonImageView0.getPaddingLeft();
        m m0 = e.a(v1, v2, melonImageView0.getPaddingRight() + v3);
        if(m0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = melonImageView0.getLayoutParams();
            if(viewGroup$LayoutParams1 != null) {
                v = viewGroup$LayoutParams1.height;
            }
            int v4 = melonImageView0.getHeight();
            int v5 = melonImageView0.getPaddingTop();
            m m1 = e.a(v, v4, melonImageView0.getPaddingBottom() + v5);
            return m1 == null ? null : new g(m0, m1);
        }
        return null;
    }

    @Override  // u5.h
    public Object c(k k0) {
        g g0 = this.b();
        if(g0 != null) {
            return g0;
        }
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(k0), 1);
        cancellableContinuationImpl0.initCancellability();
        ViewTreeObserver viewTreeObserver0 = this.a.getViewTreeObserver();
        i i0 = new i(this, viewTreeObserver0, cancellableContinuationImpl0);
        viewTreeObserver0.addOnPreDrawListener(i0);
        cancellableContinuationImpl0.invokeOnCancellation(new j(this, viewTreeObserver0, i0, 4));
        return cancellableContinuationImpl0.getResult();
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof e && this.a.equals(((e)object0).a);
    }

    @Override
    public final int hashCode() {
        return 0x4CF + this.a.hashCode() * 0x1F;
    }
}

