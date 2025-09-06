package d1;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

public final class k extends CharacterStyle {
    public final boolean a;
    public final boolean b;

    public k(boolean z, boolean z1) {
        this.a = z;
        this.b = z1;
    }

    @Override  // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint0) {
        textPaint0.setUnderlineText(this.a);
        textPaint0.setStrikeThruText(this.b);
    }
}

