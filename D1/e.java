package d1;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public final class e extends MetricAffectingSpan {
    public final float a;

    public e(float f) {
        this.a = f;
    }

    @Override  // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint0) {
        textPaint0.setLetterSpacing(this.a);
    }

    @Override  // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint0) {
        textPaint0.setLetterSpacing(this.a);
    }
}

