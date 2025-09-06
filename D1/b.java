package d1;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public final class b extends MetricAffectingSpan {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        super();
        this.b = object0;
    }

    @Override  // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint0) {
        if(this.a != 0) {
            textPaint0.setTypeface(((Typeface)this.b));
            return;
        }
        textPaint0.setFontFeatureSettings(((String)this.b));
    }

    @Override  // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint0) {
        if(this.a != 0) {
            textPaint0.setTypeface(((Typeface)this.b));
            return;
        }
        textPaint0.setFontFeatureSettings(((String)this.b));
    }
}

