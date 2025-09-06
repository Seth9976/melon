package v6;

import e1.b;

public final class i extends b {
    @Override  // e1.b
    public final float C(j j0) {
        return j0.o.b * 10000.0f;
    }

    @Override  // e1.b
    public final void K(j j0, float f) {
        j0.o.b = f / 10000.0f;
        j0.invalidateSelf();
    }
}

