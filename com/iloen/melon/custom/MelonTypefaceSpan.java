package com.iloen.melon.custom;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class MelonTypefaceSpan extends TypefaceSpan {
    public final Typeface a;

    public MelonTypefaceSpan(Typeface typeface0) {
        super("");
        this.a = typeface0;
    }

    public static void a(TextPaint textPaint0, Typeface typeface0) {
        Typeface typeface1 = textPaint0.getTypeface();
        int v = (typeface1 == null ? 0 : typeface1.getStyle()) & ~typeface0.getStyle();
        if((v & 1) != 0) {
            textPaint0.setFakeBoldText(true);
        }
        if((v & 2) != 0) {
            textPaint0.setTextSkewX(-0.25f);
        }
        textPaint0.setTypeface(typeface0);
    }

    @Override  // android.text.style.TypefaceSpan
    public final void updateDrawState(TextPaint textPaint0) {
        MelonTypefaceSpan.a(textPaint0, this.a);
    }

    @Override  // android.text.style.TypefaceSpan
    public final void updateMeasureState(TextPaint textPaint0) {
        MelonTypefaceSpan.a(textPaint0, this.a);
    }
}

