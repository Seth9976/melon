package androidx.constraintlayout.motion.widget;

import android.view.View;

public final class s implements Runnable {
    public final int a;
    public final View b;

    public s(View view0, int v) {
        this.a = v;
        this.b = view0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((MotionLayout)this.b).N0.a();
                return;
            }
            case 1: {
                ((MotionLayout)this.b).R0 = false;
                return;
            }
            case 2: {
                ((MotionLayout)this.b).N0.a();
                return;
            }
            default: {
                this.b.setNestedScrollingEnabled(true);
            }
        }
    }
}

