package f6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeState.State;
import com.google.android.material.internal.B;
import com.google.android.material.internal.x;
import com.google.android.material.internal.y;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import w6.d;
import z6.i;
import z6.m;
import z6.o;

public final class a extends Drawable implements x {
    public final WeakReference a;
    public final i b;
    public final y c;
    public final Rect d;
    public final b e;
    public float f;
    public float g;
    public final int h;
    public float i;
    public float j;
    public float k;
    public WeakReference l;
    public WeakReference m;

    public a(Context context0, BadgeState.State badgeState$State0) {
        WeakReference weakReference0 = new WeakReference(context0);
        this.a = weakReference0;
        B.e(context0, "Theme.MaterialComponents", B.b);
        this.d = new Rect();
        y y0 = new y(this);
        this.c = y0;
        TextPaint textPaint0 = y0.a;
        textPaint0.setTextAlign(Paint.Align.CENTER);
        b b0 = new b(context0, badgeState$State0);
        this.e = b0;
        BadgeState.State badgeState$State1 = b0.b;
        i i0 = new i(o.a(context0, (this.f() ? ((int)badgeState$State1.g) : ((int)badgeState$State1.e)), (this.f() ? ((int)badgeState$State1.h) : ((int)badgeState$State1.f))).a());
        this.b = i0;
        this.h();
        Context context1 = (Context)weakReference0.get();
        if(context1 != null) {
            d d0 = new d(context1, ((int)badgeState$State1.d));
            if(y0.g != d0) {
                y0.c(d0, context1);
                textPaint0.setColor(((int)badgeState$State1.c));
                this.invalidateSelf();
                this.j();
                this.invalidateSelf();
            }
        }
        int v = badgeState$State1.l;
        this.h = v == -2 ? badgeState$State1.m : ((int)Math.pow(10.0, ((double)v) - 1.0)) - 1;
        y0.e = true;
        this.j();
        this.invalidateSelf();
        y0.e = true;
        this.h();
        this.j();
        this.invalidateSelf();
        textPaint0.setAlpha(this.getAlpha());
        this.invalidateSelf();
        ColorStateList colorStateList0 = ColorStateList.valueOf(((int)badgeState$State1.b));
        if(i0.a.c != colorStateList0) {
            i0.m(colorStateList0);
            this.invalidateSelf();
        }
        textPaint0.setColor(((int)badgeState$State1.c));
        this.invalidateSelf();
        if(this.l != null && this.l.get() != null) {
            this.i(((View)this.l.get()), (this.m == null ? null : ((FrameLayout)this.m.get())));
        }
        this.j();
        this.setVisible(badgeState$State1.E.booleanValue(), false);
    }

    @Override  // com.google.android.material.internal.x
    public final void a() {
        this.invalidateSelf();
    }

    public final String b() {
        BadgeState.State badgeState$State0 = this.e.b;
        BadgeState.State badgeState$State1 = this.e.b;
        String s = badgeState$State0.j;
        WeakReference weakReference0 = this.a;
        if(s != null) {
            int v = badgeState$State0.l;
            if(v != -2 && s != null && s.length() > v) {
                return ((Context)weakReference0.get()) == null ? "" : String.format("%1$s%2$s", s.substring(0, v - 1), "…");
            }
            return s;
        }
        if(this.g()) {
            if(this.h != -2 && this.e() > this.h) {
                return ((Context)weakReference0.get()) == null ? "" : String.format(badgeState$State1.n, "%1$d%2$s", this.h, "+");
            }
            return NumberFormat.getInstance(badgeState$State1.n).format(((long)this.e()));
        }
        return null;
    }

    public final CharSequence c() {
        if(this.isVisible()) {
            b b0 = this.e;
            BadgeState.State badgeState$State0 = b0.b;
            BadgeState.State badgeState$State1 = b0.b;
            if(badgeState$State0.j != null) {
                CharSequence charSequence0 = badgeState$State0.o;
                return charSequence0 != null ? charSequence0 : b0.b.j;
            }
            if(!this.g()) {
                return badgeState$State1.r;
            }
            if(badgeState$State1.w != 0) {
                Context context0 = (Context)this.a.get();
                if(context0 != null) {
                    if(this.h != -2) {
                        return this.e() <= this.h ? context0.getResources().getQuantityString(badgeState$State1.w, this.e(), new Object[]{this.e()}) : context0.getString(badgeState$State1.B, new Object[]{this.h});
                    }
                    return context0.getResources().getQuantityString(badgeState$State1.w, this.e(), new Object[]{this.e()});
                }
            }
        }
        return null;
    }

    public final FrameLayout d() {
        return this.m == null ? null : ((FrameLayout)this.m.get());
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        if(!this.getBounds().isEmpty() && this.getAlpha() != 0 && this.isVisible()) {
            this.b.draw(canvas0);
            if(this.f()) {
                String s = this.b();
                if(s != null) {
                    Rect rect0 = new Rect();
                    this.c.a.getTextBounds(s, 0, s.length(), rect0);
                    float f = this.g - rect0.exactCenterY();
                    canvas0.drawText(s, this.f, ((float)(rect0.bottom > 0 ? Math.round(f) : ((int)f))), this.c.a);
                }
            }
        }
    }

    public final int e() {
        int v = this.e.b.k;
        return v == -1 ? 0 : v;
    }

    // 去混淆评级： 低(20)
    public final boolean f() {
        return this.e.b.j != null || this.g();
    }

    public final boolean g() {
        BadgeState.State badgeState$State0 = this.e.b;
        return badgeState$State0.j == null && badgeState$State0.k != -1;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.e.b.i;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.d.height();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.d.width();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h() {
        Context context0 = (Context)this.a.get();
        if(context0 == null) {
            return;
        }
        o o0 = o.a(context0, (this.f() ? ((int)this.e.b.g) : ((int)this.e.b.e)), (this.f() ? ((int)this.e.b.h) : ((int)this.e.b.f))).a();
        this.b.setShapeAppearanceModel(o0);
        this.invalidateSelf();
    }

    public final void i(View view0, FrameLayout frameLayout0) {
        this.l = new WeakReference(view0);
        this.m = new WeakReference(frameLayout0);
        ViewGroup viewGroup0 = (ViewGroup)view0.getParent();
        viewGroup0.setClipChildren(false);
        viewGroup0.setClipToPadding(false);
        this.j();
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    public final void j() {
        float f7;
        float f6;
        float f13;
        float f12;
        float f2;
        WeakReference weakReference0 = this.a;
        Context context0 = (Context)weakReference0.get();
        ViewGroup viewGroup0 = null;
        View view0 = this.l == null ? null : ((View)this.l.get());
        if(context0 != null && view0 != null) {
            Rect rect0 = new Rect();
            Rect rect1 = this.d;
            rect0.set(rect1);
            Rect rect2 = new Rect();
            view0.getDrawingRect(rect2);
            WeakReference weakReference1 = this.m;
            if(weakReference1 != null) {
                viewGroup0 = (ViewGroup)weakReference1.get();
            }
            if(viewGroup0 != null) {
                viewGroup0.offsetDescendantRectToMyCoords(view0, rect2);
            }
            b b0 = this.e;
            float f = this.f() ? b0.d : b0.c;
            this.i = f;
            if(Float.compare(f, -1.0f) == 0) {
                this.j = (float)Math.round((this.f() ? b0.g : b0.e) / 2.0f);
                this.k = (float)Math.round((this.f() ? b0.h : b0.f) / 2.0f);
            }
            else {
                this.j = f;
                this.k = f;
            }
            if(this.f()) {
                String s = this.b();
                y y0 = this.c;
                this.j = Math.max(this.j, y0.a(s) / 2.0f + ((float)(((int)b0.b.G))));
                float f1 = this.k;
                if(y0.e) {
                    y0.b(s);
                }
                f2 = y0.d;
                float f3 = Math.max(f1, f2 / 2.0f + ((float)(((int)b0.b.I))));
                this.k = f3;
                this.j = Math.max(this.j, f3);
            }
            BadgeState.State badgeState$State0 = b0.b;
            BadgeState.State badgeState$State1 = b0.b;
            int v = b0.k;
            int v1 = (int)badgeState$State0.N;
            if(this.f()) {
                v1 = (int)badgeState$State0.T;
                Context context1 = (Context)weakReference0.get();
                if(context1 != null) {
                    float f4 = e6.a.b(0.0f, 1.0f, 0.3f, 1.0f, context1.getResources().getConfiguration().fontScale - 1.0f);
                    v1 = e6.a.c(v1, v1 - ((int)badgeState$State0.X), f4);
                }
            }
            if(v == 0) {
                v1 -= Math.round(this.k);
            }
            int v2 = ((int)badgeState$State0.W) + v1;
            switch(((int)badgeState$State1.D)) {
                case 0x800053: 
                case 0x800055: {
                    this.g = (float)(rect2.bottom - v2);
                    break;
                }
                default: {
                    this.g = (float)(rect2.top + v2);
                }
            }
            int v3 = this.f() ? ((int)badgeState$State0.S) : ((int)badgeState$State1.M);
            if(v == 1) {
                v3 += (this.f() ? b0.j : b0.i);
            }
            int v4 = ((int)badgeState$State0.V) + v3;
            switch(((int)badgeState$State1.D)) {
                case 0x800033: 
                case 0x800053: {
                    this.f = view0.getLayoutDirection() == 0 ? ((float)rect2.left) - this.j + ((float)v4) : ((float)rect2.right) + this.j - ((float)v4);
                    break;
                }
                default: {
                    this.f = view0.getLayoutDirection() == 0 ? ((float)rect2.right) + this.j - ((float)v4) : ((float)rect2.left) - this.j + ((float)v4);
                }
            }
            if(badgeState$State0.Y.booleanValue()) {
                View view1 = this.d();
                if(view1 != null) {
                    FrameLayout frameLayout0 = this.d();
                    if(frameLayout0 == null || frameLayout0.getId() != 0x7F0A086A) {  // id:mtrl_anchor_parent
                        f7 = 0.0f;
                        f6 = 0.0f;
                    label_80:
                        float f8 = this.g - this.k;
                        float f9 = view1.getY() + f8 + f7;
                        float f10 = this.f - this.j;
                        float f11 = view1.getX() + f10 + f6;
                        if(view1.getParent() instanceof View) {
                            View view2 = (View)view1.getParent();
                            f12 = this.g + this.k - (((float)view2.getHeight()) - view1.getY()) + f7;
                        }
                        else {
                            f12 = 0.0f;
                        }
                        if(view1.getParent() instanceof View) {
                            View view3 = (View)view1.getParent();
                            f13 = this.f + this.j - (((float)view3.getWidth()) - view1.getX()) + f6;
                        }
                        else {
                            f13 = 0.0f;
                        }
                        if(f9 < 0.0f) {
                            this.g = Math.abs(f9) + this.g;
                        }
                        if(f11 < 0.0f) {
                            this.f = Math.abs(f11) + this.f;
                        }
                        if(f12 > 0.0f) {
                            this.g -= Math.abs(f12);
                        }
                        if(f13 > 0.0f) {
                            this.f -= Math.abs(f13);
                        }
                    }
                    else if(view1.getParent() instanceof View) {
                        f7 = view1.getY();
                        f6 = view1.getX();
                        view1 = (View)view1.getParent();
                        goto label_80;
                    }
                }
                else if(view0.getParent() instanceof View) {
                    float f5 = view0.getY();
                    f6 = view0.getX();
                    f7 = f5;
                    view1 = (View)view0.getParent();
                    goto label_80;
                }
            }
            rect1.set(((int)(this.f - this.j)), ((int)(this.g - this.k)), ((int)(this.f + this.j)), ((int)(this.g + this.k)));
            float f14 = this.i;
            i i0 = this.b;
            if(Float.compare(f14, -1.0f) != 0) {
                m m0 = i0.a.a.g();
                m0.c(f14);
                i0.setShapeAppearanceModel(m0.a());
            }
            if(!rect0.equals(rect1)) {
                i0.setBounds(rect1);
            }
        }
    }

    @Override  // android.graphics.drawable.Drawable, com.google.android.material.internal.x
    public final boolean onStateChange(int[] arr_v) {
        return super.onStateChange(arr_v);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
        this.e.a.i = v;
        this.e.b.i = v;
        this.c.a.setAlpha(this.getAlpha());
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
    }
}

