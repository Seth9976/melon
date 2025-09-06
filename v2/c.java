package v2;

import android.text.TextPaint;

public final class c implements e {
    public final TextPaint a;
    public static final ThreadLocal b;

    static {
        c.b = new ThreadLocal();
    }

    public c() {
        TextPaint textPaint0 = new TextPaint();
        this.a = textPaint0;
        textPaint0.setTextSize(10.0f);
    }
}

