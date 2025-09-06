package c1;

import android.text.SegmentFinder;
import x9.b;

public final class a extends SegmentFinder {
    public final b a;

    public a(b b0) {
        this.a = b0;
        super();
    }

    @Override  // android.text.SegmentFinder
    public final int nextEndBoundary(int v) {
        return this.a.d(v);
    }

    @Override  // android.text.SegmentFinder
    public final int nextStartBoundary(int v) {
        return this.a.b(v);
    }

    @Override  // android.text.SegmentFinder
    public final int previousEndBoundary(int v) {
        return this.a.g(v);
    }

    @Override  // android.text.SegmentFinder
    public final int previousStartBoundary(int v) {
        return this.a.c(v);
    }
}

