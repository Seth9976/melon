package d1;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public final class g implements LineHeightSpan {
    public final float a;

    public g(float f) {
        this.a = f;
    }

    @Override  // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence0, int v, int v1, int v2, int v3, Paint.FontMetricsInt paint$FontMetricsInt0) {
        int v4 = paint$FontMetricsInt0.descent - paint$FontMetricsInt0.ascent;
        if(v4 <= 0) {
            return;
        }
        int v5 = (int)(((float)Math.ceil(this.a)));
        int v6 = (int)Math.ceil(((double)paint$FontMetricsInt0.descent) * ((double)(((float)v5) * 1.0f / ((float)v4))));
        paint$FontMetricsInt0.descent = v6;
        paint$FontMetricsInt0.ascent = v6 - v5;
    }
}

