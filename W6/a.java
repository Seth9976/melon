package w6;

import android.graphics.Typeface;
import com.google.android.material.internal.b;
import e1.u;

public final class a extends u {
    public final Typeface e;
    public final b f;
    public boolean g;

    public a(b b0, Typeface typeface0) {
        this.e = typeface0;
        this.f = b0;
    }

    @Override  // e1.u
    public final void K(int v) {
        if(!this.g) {
            this.f.a(this.e);
        }
    }

    @Override  // e1.u
    public final void L(Typeface typeface0, boolean z) {
        if(!this.g) {
            this.f.a(typeface0);
        }
    }
}

