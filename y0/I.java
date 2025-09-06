package y0;

import android.graphics.PathMeasure;

public final class i {
    public final PathMeasure a;
    public float[] b;
    public float[] c;

    public i(PathMeasure pathMeasure0) {
        this.a = pathMeasure0;
    }

    public final void a(float f, float f1, g g0) {
        if(g0 == null) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        this.a.getSegment(f, f1, g0.a, true);
    }

    public final void b(g g0) {
        this.a.setPath((g0 == null ? null : g0.a), false);
    }
}

