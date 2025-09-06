package n3;

import android.graphics.Bitmap;
import h3.f;

public final class a extends f {
    public Bitmap e;
    public final b f;

    public a(b b0) {
        super(2);
        this.f = b0;
    }

    @Override  // h3.f
    public final void o() {
        this.e = null;
        this.b = 0;
        this.c = 0L;
        this.d = false;
    }

    @Override  // h3.f
    public final void p() {
        this.f.h(this);
    }
}

