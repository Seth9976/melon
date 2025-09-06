package v2;

import Q1.c;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;
import w2.a;

public final class t extends ReplacementSpan {
    public final Paint.FontMetricsInt a;
    public final s b;
    public short c;
    public float d;
    public TextPaint e;

    public t(s s0) {
        this.a = new Paint.FontMetricsInt();
        this.c = -1;
        this.d = 1.0f;
        c.o(s0, "rasterizer cannot be null");
        this.b = s0;
    }

    @Override  // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas0, CharSequence charSequence0, int v, int v1, float f, int v2, int v3, int v4, Paint paint0) {
        TextPaint textPaint0 = null;
        if(charSequence0 instanceof Spanned) {
            CharacterStyle[] arr_characterStyle = (CharacterStyle[])((Spanned)charSequence0).getSpans(v, v1, CharacterStyle.class);
            if(arr_characterStyle.length != 0 && (arr_characterStyle.length != 1 || arr_characterStyle[0] != this)) {
                TextPaint textPaint1 = this.e;
                if(textPaint1 == null) {
                    textPaint1 = new TextPaint();
                    this.e = textPaint1;
                }
                textPaint0 = textPaint1;
                textPaint0.set(paint0);
                for(int v5 = 0; v5 < arr_characterStyle.length; ++v5) {
                    CharacterStyle characterStyle0 = arr_characterStyle[v5];
                    if(!(characterStyle0 instanceof MetricAffectingSpan)) {
                        characterStyle0.updateDrawState(textPaint0);
                    }
                }
            }
            else if(paint0 instanceof TextPaint) {
                textPaint0 = (TextPaint)paint0;
            }
        }
        else if(paint0 instanceof TextPaint) {
            textPaint0 = (TextPaint)paint0;
        }
        Paint paint1 = textPaint0;
        if(paint1 != null && paint1.bgColor != 0) {
            float f1 = f + ((float)this.c);
            int v6 = paint1.getColor();
            Paint.Style paint$Style0 = paint1.getStyle();
            paint1.setColor(paint1.bgColor);
            paint1.setStyle(Paint.Style.FILL);
            canvas0.drawRect(f, ((float)v2), f1, ((float)v4), paint1);
            paint1.setStyle(paint$Style0);
            paint1.setColor(v6);
        }
        h.a().getClass();
        if(paint1 == null) {
            paint1 = paint0;
        }
        Typeface typeface0 = (Typeface)this.b.b.d;
        Typeface typeface1 = paint1.getTypeface();
        paint1.setTypeface(typeface0);
        canvas0.drawText(((char[])this.b.b.b), this.b.a * 2, 2, f, ((float)v3), paint1);
        paint1.setTypeface(typeface1);
    }

    @Override  // android.text.style.ReplacementSpan
    public final int getSize(Paint paint0, CharSequence charSequence0, int v, int v1, Paint.FontMetricsInt paint$FontMetricsInt0) {
        Paint.FontMetricsInt paint$FontMetricsInt1 = this.a;
        paint0.getFontMetricsInt(paint$FontMetricsInt1);
        float f = ((float)Math.abs(paint$FontMetricsInt1.descent - paint$FontMetricsInt1.ascent)) * 1.0f;
        s s0 = this.b;
        a a0 = s0.b();
        int v2 = a0.a(14);
        int v3 = 0;
        this.d = f / ((float)(v2 == 0 ? 0 : ((ByteBuffer)a0.d).getShort(v2 + a0.a)));
        a a1 = s0.b();
        int v4 = a1.a(14);
        if(v4 != 0) {
            ((ByteBuffer)a1.d).getShort(v4 + a1.a);
        }
        a a2 = s0.b();
        int v5 = a2.a(12);
        if(v5 != 0) {
            v3 = ((ByteBuffer)a2.d).getShort(v5 + a2.a);
        }
        short v6 = (short)(((int)(((float)v3) * this.d)));
        this.c = v6;
        if(paint$FontMetricsInt0 != null) {
            paint$FontMetricsInt0.ascent = paint$FontMetricsInt1.ascent;
            paint$FontMetricsInt0.descent = paint$FontMetricsInt1.descent;
            paint$FontMetricsInt0.top = paint$FontMetricsInt1.top;
            paint$FontMetricsInt0.bottom = paint$FontMetricsInt1.bottom;
        }
        return v6;
    }
}

