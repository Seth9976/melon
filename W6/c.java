package w6;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import e1.u;

public final class c extends u {
    public final Context e;
    public final TextPaint f;
    public final u g;
    public final d h;

    public c(d d0, Context context0, TextPaint textPaint0, u u0) {
        this.h = d0;
        this.e = context0;
        this.f = textPaint0;
        this.g = u0;
    }

    @Override  // e1.u
    public final void K(int v) {
        this.g.K(v);
    }

    @Override  // e1.u
    public final void L(Typeface typeface0, boolean z) {
        this.h.g(this.e, this.f, typeface0);
        this.g.L(typeface0, z);
    }
}

