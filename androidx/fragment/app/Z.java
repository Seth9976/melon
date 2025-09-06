package androidx.fragment.app;

public final class z implements Runnable {
    public final int a;
    public final I b;

    public z(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.callStartTransitionListener(false);
            return;
        }
        this.b.startPostponedEnterTransition();
    }
}

