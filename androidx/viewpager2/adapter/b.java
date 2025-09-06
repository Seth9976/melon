package androidx.viewpager2.adapter;

public final class b implements Runnable {
    public final h a;

    public b(h h0) {
        this.a = h0;
    }

    @Override
    public final void run() {
        this.a.mIsInGracePeriod = false;
        this.a.gcFragments();
    }
}

