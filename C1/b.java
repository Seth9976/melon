package c1;

import Qc.l;
import android.text.TextPaint;
import ye.a;

public final class b extends a {
    public final CharSequence m;
    public final TextPaint n;

    public b(CharSequence charSequence0, TextPaint textPaint0) {
        this.m = charSequence0;
        this.n = textPaint0;
    }

    @Override  // ye.a
    public final int P(int v) {
        int v1 = this.m.length();
        return l.B(this.n, this.m, v1, v);
    }

    @Override  // ye.a
    public final int Q(int v) {
        int v1 = this.m.length();
        return l.c(this.n, this.m, v1, v);
    }
}

