package d1;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

public final class j extends CharacterStyle {
    public final int a;
    public final float b;
    public final float c;
    public final float d;

    public j(float f, float f1, float f2, int v) {
        this.a = v;
        this.b = f;
        this.c = f1;
        this.d = f2;
    }

    @Override  // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint0) {
        textPaint0.setShadowLayer(this.d, this.b, this.c, this.a);
    }
}

