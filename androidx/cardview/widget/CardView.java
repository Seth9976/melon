package androidx.cardview.widget;

import C.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import ea.c;
import z6.f;

public class CardView extends FrameLayout {
    public boolean a;
    public boolean b;
    public final Rect c;
    public final Rect d;
    public final c e;
    public static final int[] f;
    public static final f g;

    static {
        CardView.f = new int[]{0x1010031};
        CardView.g = new f(8);
    }

    public CardView(Context context0) {
        this(context0, null);
    }

    public CardView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0400C8);  // attr:cardViewStyle
    }

    public CardView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        ColorStateList colorStateList0;
        Rect rect0 = new Rect();
        this.c = rect0;
        this.d = new Rect();
        c c0 = new c(this);
        this.e = c0;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.a, v, 0x7F14012B);  // style:CardView
        if(typedArray0.hasValue(2)) {
            colorStateList0 = typedArray0.getColorStateList(2);
        }
        else {
            TypedArray typedArray1 = this.getContext().obtainStyledAttributes(CardView.f);
            int v1 = typedArray1.getColor(0, 0);
            typedArray1.recycle();
            float[] arr_f = new float[3];
            Color.colorToHSV(v1, arr_f);
            colorStateList0 = ColorStateList.valueOf((arr_f[2] > 0.5f ? this.getResources().getColor(0x7F06005B) : this.getResources().getColor(0x7F06005A)));  // color:cardview_light_background
        }
        float f = typedArray0.getDimension(3, 0.0f);
        float f1 = typedArray0.getDimension(4, 0.0f);
        float f2 = typedArray0.getDimension(5, 0.0f);
        this.a = typedArray0.getBoolean(7, false);
        this.b = typedArray0.getBoolean(6, true);
        int v2 = typedArray0.getDimensionPixelSize(8, 0);
        rect0.left = typedArray0.getDimensionPixelSize(10, v2);
        rect0.top = typedArray0.getDimensionPixelSize(12, v2);
        rect0.right = typedArray0.getDimensionPixelSize(11, v2);
        rect0.bottom = typedArray0.getDimensionPixelSize(9, v2);
        if(f1 > f2) {
            f2 = f1;
        }
        typedArray0.getDimensionPixelSize(0, 0);
        typedArray0.getDimensionPixelSize(1, 0);
        typedArray0.recycle();
        D.a a0 = new D.a(colorStateList0, f);
        c0.b = a0;
        this.setBackgroundDrawable(a0);
        this.setClipToOutline(true);
        this.setElevation(f1);
        CardView.g.s(c0, f2);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((D.a)(((Drawable)this.e.b))).h;
    }

    public float getCardElevation() {
        return ((CardView)this.e.c).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.c.left;
    }

    public int getContentPaddingRight() {
        return this.c.right;
    }

    public int getContentPaddingTop() {
        return this.c.top;
    }

    public float getMaxCardElevation() {
        return ((D.a)(((Drawable)this.e.b))).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.b;
    }

    public float getRadius() {
        return ((D.a)(((Drawable)this.e.b))).a;
    }

    public boolean getUseCompatPadding() {
        return this.a;
    }

    @Override  // android.widget.FrameLayout
    public void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
    }

    public void setCardBackgroundColor(int v) {
        ColorStateList colorStateList0 = ColorStateList.valueOf(v);
        D.a a0 = (D.a)(((Drawable)this.e.b));
        if(colorStateList0 == null) {
            a0.getClass();
            colorStateList0 = ColorStateList.valueOf(0);
        }
        a0.h = colorStateList0;
        int v1 = colorStateList0.getColorForState(a0.getState(), a0.h.getDefaultColor());
        a0.b.setColor(v1);
        a0.invalidateSelf();
    }

    public void setCardBackgroundColor(ColorStateList colorStateList0) {
        D.a a0 = (D.a)(((Drawable)this.e.b));
        if(colorStateList0 == null) {
            a0.getClass();
            colorStateList0 = ColorStateList.valueOf(0);
        }
        a0.h = colorStateList0;
        int v = colorStateList0.getColorForState(a0.getState(), a0.h.getDefaultColor());
        a0.b.setColor(v);
        a0.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView)this.e.c).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        CardView.g.s(this.e, f);
    }

    @Override  // android.view.View
    public void setMinimumHeight(int v) {
        super.setMinimumHeight(v);
    }

    @Override  // android.view.View
    public void setMinimumWidth(int v) {
        super.setMinimumWidth(v);
    }

    @Override  // android.view.View
    public final void setPadding(int v, int v1, int v2, int v3) {
    }

    @Override  // android.view.View
    public final void setPaddingRelative(int v, int v1, int v2, int v3) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if(z != this.b) {
            this.b = z;
            CardView.g.s(this.e, ((D.a)(((Drawable)this.e.b))).e);
        }
    }

    public void setRadius(float f) {
        D.a a0 = (D.a)(((Drawable)this.e.b));
        if(f == a0.a) {
            return;
        }
        a0.a = f;
        a0.b(null);
        a0.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if(this.a != z) {
            this.a = z;
            CardView.g.s(this.e, ((D.a)(((Drawable)this.e.b))).e);
        }
    }
}

