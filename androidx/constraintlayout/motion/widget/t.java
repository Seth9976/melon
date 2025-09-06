package androidx.constraintlayout.motion.widget;

public final class t extends r {
    public float a;
    public float b;
    public float c;
    public final MotionLayout d;

    public t(MotionLayout motionLayout0) {
        this.d = motionLayout0;
        this.a = 0.0f;
        this.b = 0.0f;
    }

    @Override  // androidx.constraintlayout.motion.widget.r
    public final float a() {
        return this.d.B;
    }

    @Override  // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f1 = this.a;
        MotionLayout motionLayout0 = this.d;
        if(Float.compare(f1, 0.0f) > 0) {
            float f2 = this.c;
            if(f1 / f2 < f) {
                f = f1 / f2;
            }
            motionLayout0.B = f1 - f2 * f;
            return f1 * f - f2 * f * f / 2.0f + this.b;
        }
        float f3 = this.c;
        if(-f1 / f3 < f) {
            f = -f1 / f3;
        }
        motionLayout0.B = f3 * f + f1;
        return f3 * f * f / 2.0f + f1 * f + this.b;
    }
}

