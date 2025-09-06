package w6;

import R1.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import d6.a;
import e1.n;
import e1.u;
import e1.x;

public final class d {
    public final ColorStateList a;
    public final String b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;
    public final float g;
    public final boolean h;
    public final float i;
    public ColorStateList j;
    public float k;
    public final int l;
    public boolean m;
    public Typeface n;

    public d(Context context0, int v) {
        this.m = false;
        TypedArray typedArray0 = context0.obtainStyledAttributes(v, a.f0);
        this.k = typedArray0.getDimension(0, 0.0f);
        this.j = n.r(context0, typedArray0, 3);
        n.r(context0, typedArray0, 4);
        n.r(context0, typedArray0, 5);
        this.c = typedArray0.getInt(2, 0);
        this.d = typedArray0.getInt(1, 1);
        int v1 = typedArray0.hasValue(12) ? 12 : 10;
        this.l = typedArray0.getResourceId(v1, 0);
        this.b = typedArray0.getString(v1);
        typedArray0.getBoolean(14, false);
        this.a = n.r(context0, typedArray0, 6);
        this.e = typedArray0.getFloat(7, 0.0f);
        this.f = typedArray0.getFloat(8, 0.0f);
        this.g = typedArray0.getFloat(9, 0.0f);
        typedArray0.recycle();
        TypedArray typedArray1 = context0.obtainStyledAttributes(v, a.K);
        this.h = typedArray1.hasValue(0);
        this.i = typedArray1.getFloat(0, 0.0f);
        typedArray1.recycle();
    }

    public final void a() {
        int v = this.c;
        if(this.n == null) {
            String s = this.b;
            if(s != null) {
                this.n = Typeface.create(s, v);
            }
        }
        if(this.n == null) {
            switch(this.d) {
                case 1: {
                    this.n = Typeface.SANS_SERIF;
                    break;
                }
                case 2: {
                    this.n = Typeface.SERIF;
                    break;
                }
                case 3: {
                    this.n = Typeface.MONOSPACE;
                    break;
                }
                default: {
                    this.n = Typeface.DEFAULT;
                }
            }
            this.n = Typeface.create(this.n, v);
        }
    }

    public final Typeface b(Context context0) {
        if(this.m) {
            return this.n;
        }
        if(!context0.isRestricted()) {
            try {
                Typeface typeface0 = j.a(context0, this.l);
                this.n = typeface0;
                if(typeface0 != null) {
                    this.n = Typeface.create(typeface0, this.c);
                }
                goto label_10;
            }
            catch(UnsupportedOperationException exception0) {
            }
            catch(Resources.NotFoundException | Exception unused_ex) {
                goto label_10;
            }
            Log.d("TextAppearance", "Error loading font " + this.b, exception0);
        }
    label_10:
        this.a();
        this.m = true;
        return this.n;
    }

    public final void c(Context context0, u u0) {
        if(this.d(context0)) {
            this.b(context0);
        }
        else {
            this.a();
        }
        int v = this.l;
        if(v == 0) {
            this.m = true;
        }
        if(this.m) {
            u0.L(this.n, true);
            return;
        }
        try {
            b b0 = new b(this, u0);
            if(context0.isRestricted()) {
                b0.a(-4);
                return;
            }
            j.b(context0, v, new TypedValue(), 0, b0, false, false);
        }
        catch(Resources.NotFoundException unused_ex) {
            this.m = true;
            u0.K(1);
        }
        catch(Exception exception0) {
            Log.d("TextAppearance", "Error loading font " + this.b, exception0);
            this.m = true;
            u0.K(-3);
        }
    }

    public final boolean d(Context context0) {
        Typeface typeface0 = null;
        int v = this.l;
        if(v != 0 && !context0.isRestricted()) {
            typeface0 = j.b(context0, v, new TypedValue(), 0, null, false, true);
        }
        return typeface0 != null;
    }

    public final void e(Context context0, TextPaint textPaint0, u u0) {
        this.f(context0, textPaint0, u0);
        textPaint0.setColor((this.j == null ? 0xFF000000 : this.j.getColorForState(textPaint0.drawableState, this.j.getDefaultColor())));
        int v = this.a == null ? 0 : this.a.getColorForState(textPaint0.drawableState, this.a.getDefaultColor());
        textPaint0.setShadowLayer(this.g, this.e, this.f, v);
    }

    public final void f(Context context0, TextPaint textPaint0, u u0) {
        if(this.d(context0)) {
            this.g(context0, textPaint0, this.b(context0));
            return;
        }
        this.a();
        this.g(context0, textPaint0, this.n);
        this.c(context0, new c(this, context0, textPaint0, u0));
    }

    public final void g(Context context0, TextPaint textPaint0, Typeface typeface0) {
        Typeface typeface1 = x.K(context0.getResources().getConfiguration(), typeface0);
        if(typeface1 != null) {
            typeface0 = typeface1;
        }
        textPaint0.setTypeface(typeface0);
        int v = ~typeface0.getStyle() & this.c;
        textPaint0.setFakeBoldText((v & 1) != 0);
        textPaint0.setTextSkewX(((v & 2) == 0 ? 0.0f : -0.25f));
        textPaint0.setTextSize(this.k);
        if(this.h) {
            textPaint0.setLetterSpacing(this.i);
        }
    }
}

