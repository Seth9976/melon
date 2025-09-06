package d1;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public final class a extends MetricAffectingSpan {
    public final int a;
    public final float b;

    public a(float f, int v) {
        this.a = v;
        super();
        this.b = f;
    }

    @Override  // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint0) {
        if(this.a != 0) {
            textPaint0.setTextSkewX(textPaint0.getTextSkewX() + this.b);
            return;
        }
        textPaint0.baselineShift += (int)(((float)Math.ceil(textPaint0.ascent() * this.b)));
    }

    @Override  // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint0) {
        if(this.a != 0) {
            textPaint0.setTextSkewX(textPaint0.getTextSkewX() + this.b);
            return;
        }
        textPaint0.baselineShift += (int)(((float)Math.ceil(textPaint0.ascent() * this.b)));
    }
}

