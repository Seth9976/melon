package a2;

import B0.q;
import android.os.Build.VERSION;
import android.text.PrecomputedText.Params;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.Objects;

public final class c {
    public final TextPaint a;
    public final TextDirectionHeuristic b;
    public final int c;
    public final int d;

    public c(PrecomputedText.Params precomputedText$Params0) {
        this.a = precomputedText$Params0.getTextPaint();
        this.b = precomputedText$Params0.getTextDirection();
        this.c = precomputedText$Params0.getBreakStrategy();
        this.d = precomputedText$Params0.getHyphenationFrequency();
    }

    public c(TextPaint textPaint0, TextDirectionHeuristic textDirectionHeuristic0, int v, int v1) {
        if(Build.VERSION.SDK_INT >= 29) {
            q.h(textPaint0).setBreakStrategy(v).setHyphenationFrequency(v1).setTextDirection(textDirectionHeuristic0).build();
        }
        this.a = textPaint0;
        this.b = textDirectionHeuristic0;
        this.c = v;
        this.d = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof c && this.c == ((c)object0).c && this.d == ((c)object0).d) {
                TextPaint textPaint0 = this.a;
                float f = textPaint0.getTextSize();
                TextPaint textPaint1 = ((c)object0).a;
                if(f == textPaint1.getTextSize() && textPaint0.getTextScaleX() == textPaint1.getTextScaleX() && textPaint0.getTextSkewX() == textPaint1.getTextSkewX() && textPaint0.getLetterSpacing() == textPaint1.getLetterSpacing() && TextUtils.equals(textPaint0.getFontFeatureSettings(), textPaint1.getFontFeatureSettings()) && textPaint0.getFlags() == textPaint1.getFlags() && textPaint0.getTextLocales().equals(textPaint1.getTextLocales())) {
                    if(textPaint0.getTypeface() == null) {
                        return textPaint1.getTypeface() == null ? this.b == ((c)object0).b : false;
                    }
                    return textPaint0.getTypeface().equals(textPaint1.getTypeface()) ? this.b == ((c)object0).b : false;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a.getTextSize(), this.a.getTextScaleX(), this.a.getTextSkewX(), this.a.getLetterSpacing(), this.a.getFlags(), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, this.c, this.d});
    }

    @Override
    public final String toString() {
        return "{" + ("textSize=" + this.a.getTextSize()) + (", textScaleX=" + this.a.getTextScaleX()) + (", textSkewX=" + this.a.getTextSkewX()) + (", letterSpacing=" + this.a.getLetterSpacing()) + (", elegantTextHeight=" + this.a.isElegantTextHeight()) + (", textLocale=" + this.a.getTextLocales()) + (", typeface=" + this.a.getTypeface()) + (", variationSettings=" + this.a.getFontVariationSettings()) + (", textDir=" + this.b) + (", breakStrategy=" + this.c) + (", hyphenationFrequency=" + this.d) + "}";
    }
}

