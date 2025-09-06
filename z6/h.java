package z6;

import android.content.res.ColorStateList;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import com.google.android.material.elevation.ElevationOverlayProvider;

public class h extends Drawable.ConstantState {
    public o a;
    public ElevationOverlayProvider b;
    public ColorStateList c;
    public ColorStateList d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public Rect g;
    public final float h;
    public float i;
    public float j;
    public int k;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public final int q;
    public Paint.Style r;

    public h(h h0) {
        this.g = null;
        this.a = h0.a;
        this.b = h0.b;
        this.j = h0.j;
        this.c = h0.c;
        this.d = h0.d;
        this.f = h0.f;
        this.e = h0.e;
        this.k = h0.k;
        this.h = h0.h;
        this.p = h0.p;
        this.n = h0.n;
        this.i = h0.i;
        this.l = h0.l;
        this.m = h0.m;
        this.o = h0.o;
        this.q = h0.q;
        this.r = h0.r;
        if(h0.g != null) {
            this.g = new Rect(h0.g);
        }
    }

    public h(o o0) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.g = null;
        this.h = 1.0f;
        this.i = 1.0f;
        this.k = 0xFF;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = Paint.Style.FILL_AND_STROKE;
        this.a = o0;
        this.b = null;
    }

    @Override  // android.graphics.drawable.Drawable$ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override  // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable() {
        Drawable drawable0 = new i(this);
        drawable0.e = true;
        return drawable0;
    }
}

