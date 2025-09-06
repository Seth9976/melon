package b1;

import android.os.Build.VERSION;
import android.text.BoringLayout.Metrics;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.q;

public final class e {
    public final CharSequence a;
    public final TextPaint b;
    public final int c;
    public float d;
    public float e;
    public BoringLayout.Metrics f;
    public boolean g;
    public CharSequence h;

    public e(CharSequence charSequence0, TextPaint textPaint0, int v) {
        this.a = charSequence0;
        this.b = textPaint0;
        this.c = v;
        this.d = NaNf;
        this.e = NaNf;
    }

    public final BoringLayout.Metrics a() {
        BoringLayout.Metrics boringLayout$Metrics0;
        if(!this.g) {
            TextDirectionHeuristic textDirectionHeuristic0 = j.a(this.c);
            CharSequence charSequence0 = this.a;
            TextPaint textPaint0 = this.b;
            if(Build.VERSION.SDK_INT >= 33) {
                boringLayout$Metrics0 = Gd.e.f(charSequence0, textPaint0, textDirectionHeuristic0);
            }
            else {
                boringLayout$Metrics0 = textDirectionHeuristic0.isRtl(charSequence0, 0, charSequence0.length()) ? null : BoringLayout.isBoring(charSequence0, textPaint0, null);
            }
            this.f = boringLayout$Metrics0;
            this.g = true;
        }
        return this.f;
    }

    public final CharSequence b() {
        CharSequence charSequence0 = this.h;
        if(charSequence0 == null) {
            CharSequence charSequence1 = this.a;
            if(charSequence1 instanceof Spanned) {
                Class class0 = CharacterStyle.class;
                if(f.f(((Spanned)charSequence1), class0)) {
                    CharacterStyle[] arr_characterStyle = (CharacterStyle[])((Spanned)charSequence1).getSpans(0, charSequence1.length(), class0);
                    if(arr_characterStyle != null && arr_characterStyle.length != 0) {
                        CharSequence charSequence2 = null;
                        for(int v = 0; v < arr_characterStyle.length; ++v) {
                            CharacterStyle characterStyle0 = arr_characterStyle[v];
                            if(!(characterStyle0 instanceof MetricAffectingSpan)) {
                                if(charSequence2 == null) {
                                    charSequence2 = new SpannableString(charSequence1);
                                }
                                ((SpannableString)charSequence2).removeSpan(characterStyle0);
                            }
                        }
                        if(charSequence2 != null) {
                            charSequence1 = charSequence2;
                        }
                    }
                }
            }
            this.h = charSequence1;
            return charSequence1;
        }
        q.d(charSequence0);
        return charSequence0;
    }

    public final float c() {
        if(!Float.isNaN(this.d)) {
            return this.d;
        }
        BoringLayout.Metrics boringLayout$Metrics0 = this.a();
        float f = (float)(boringLayout$Metrics0 == null ? -1 : boringLayout$Metrics0.width);
        TextPaint textPaint0 = this.b;
        if(Float.compare(f, 0.0f) < 0) {
            int v = this.b().length();
            f = (float)Math.ceil(Layout.getDesiredWidth(this.b(), 0, v, textPaint0));
        }
        if(f != 0.0f && (this.a instanceof Spanned && (f.f(((Spanned)this.a), d1.f.class) || f.f(((Spanned)this.a), d1.e.class)) || textPaint0.getLetterSpacing() != 0.0f)) {
            f += 0.5f;
        }
        this.d = f;
        return f;
    }
}

