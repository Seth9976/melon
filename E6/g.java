package e6;

import U4.x;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public final class g {
    public long a;
    public long b;
    public TimeInterpolator c;
    public int d;
    public int e;

    public g(long v) {
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.a = v;
        this.b = 150L;
    }

    public final void a(Animator animator0) {
        animator0.setStartDelay(this.a);
        animator0.setDuration(this.b);
        animator0.setInterpolator(this.b());
        if(animator0 instanceof ValueAnimator) {
            ((ValueAnimator)animator0).setRepeatCount(this.d);
            ((ValueAnimator)animator0).setRepeatMode(this.e);
        }
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator0 = this.c;
        return timeInterpolator0 != null ? timeInterpolator0 : a.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        if(this.a != ((g)object0).a) {
            return false;
        }
        if(this.b != ((g)object0).b) {
            return false;
        }
        if(this.d != ((g)object0).d) {
            return false;
        }
        return this.e == ((g)object0).e ? this.b().getClass().equals(((g)object0).b().getClass()) : false;
    }

    @Override
    public final int hashCode() {
        int v = (((int)(this.a ^ this.a >>> 0x20)) * 0x1F + ((int)(this.b >>> 0x20 ^ this.b))) * 0x1F;
        return ((this.b().getClass().hashCode() + v) * 0x1F + this.d) * 0x1F + this.e;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("\n");
        stringBuilder0.append("e6.g");
        stringBuilder0.append('{');
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder0.append(" delay: ");
        stringBuilder0.append(this.a);
        stringBuilder0.append(" duration: ");
        stringBuilder0.append(this.b);
        stringBuilder0.append(" interpolator: ");
        stringBuilder0.append(this.b().getClass());
        stringBuilder0.append(" repeatCount: ");
        stringBuilder0.append(this.d);
        stringBuilder0.append(" repeatMode: ");
        return x.g(this.e, "}\n", stringBuilder0);
    }
}

