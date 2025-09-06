package androidx.constraintlayout.motion.widget;

public final class y {
    public float a;
    public float b;
    public int c;
    public int d;
    public final MotionLayout e;

    public y(MotionLayout motionLayout0) {
        this.e = motionLayout0;
        this.a = NaNf;
        this.b = NaNf;
        this.c = -1;
        this.d = -1;
    }

    public final void a() {
        int v = this.c;
        MotionLayout motionLayout0 = this.e;
        if(v != -1 || this.d != -1) {
            if(v == -1) {
                motionLayout0.transitionToState(this.d);
            }
            else {
                int v1 = this.d;
                if(v1 == -1) {
                    motionLayout0.setState(v, -1, -1);
                }
                else {
                    motionLayout0.setTransition(v, v1);
                }
            }
            motionLayout0.setState(A.b);
        }
        if(Float.isNaN(this.b)) {
            if(Float.isNaN(this.a)) {
                return;
            }
            motionLayout0.setProgress(this.a);
            return;
        }
        motionLayout0.setProgress(this.a, this.b);
        this.a = NaNf;
        this.b = NaNf;
        this.c = -1;
        this.d = -1;
    }
}

