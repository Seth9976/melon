package androidx.appcompat.widget;

import N4.b;
import P1.c;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.text.AllCapsTransformationMethod;
import c2.H;
import c2.W;
import d5.m;
import d5.w;
import e1.u;
import g.a;
import v2.h;

public class SwitchCompat extends CompoundButton {
    public CharSequence B;
    public boolean D;
    public int E;
    public final int G;
    public float I;
    public float M;
    public final VelocityTracker N;
    public final int S;
    public float T;
    public int V;
    public int W;
    public Drawable a;
    public ColorStateList b;
    public int b0;
    public PorterDuff.Mode c;
    public int c0;
    public boolean d;
    public int d0;
    public boolean e;
    public int e0;
    public Drawable f;
    public int f0;
    public ColorStateList g;
    public boolean g0;
    public PorterDuff.Mode h;
    public final TextPaint h0;
    public boolean i;
    public final ColorStateList i0;
    public boolean j;
    public StaticLayout j0;
    public int k;
    public StaticLayout k0;
    public int l;
    public final AllCapsTransformationMethod l0;
    public int m;
    public ObjectAnimator m0;
    public boolean n;
    public z n0;
    public CharSequence o;
    public Z0 o0;
    public final Rect p0;
    public static final b q0;
    public CharSequence r;
    public static final int[] r0;
    public CharSequence w;

    static {
        SwitchCompat.q0 = new b("thumbPos", 10, Float.class);
        SwitchCompat.r0 = new int[]{0x10100A0};
    }

    public SwitchCompat(Context context0) {
        this(context0, null);
    }

    public SwitchCompat(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0405BF);  // attr:switchStyle
    }

    public SwitchCompat(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Typeface typeface0;
        ColorStateList colorStateList2;
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.N = VelocityTracker.obtain();
        boolean z = true;
        this.g0 = true;
        this.p0 = new Rect();
        a1.a(this.getContext(), this);
        TextPaint textPaint0 = new TextPaint(1);
        this.h0 = textPaint0;
        textPaint0.density = this.getResources().getDisplayMetrics().density;
        m m0 = m.r(context0, attributeSet0, a.y, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        W.n(this, context0, a.y, attributeSet0, typedArray0, v);
        Drawable drawable0 = m0.k(2);
        this.a = drawable0;
        if(drawable0 != null) {
            drawable0.setCallback(this);
        }
        Drawable drawable1 = m0.k(11);
        this.f = drawable1;
        if(drawable1 != null) {
            drawable1.setCallback(this);
        }
        this.setTextOnInternal(typedArray0.getText(0));
        this.setTextOffInternal(typedArray0.getText(1));
        this.D = typedArray0.getBoolean(3, true);
        this.k = typedArray0.getDimensionPixelSize(8, 0);
        this.l = typedArray0.getDimensionPixelSize(5, 0);
        this.m = typedArray0.getDimensionPixelSize(6, 0);
        this.n = typedArray0.getBoolean(4, false);
        ColorStateList colorStateList0 = m0.j(9);
        if(colorStateList0 != null) {
            this.b = colorStateList0;
            this.d = true;
        }
        PorterDuff.Mode porterDuff$Mode0 = h0.c(typedArray0.getInt(10, -1), null);
        if(this.c != porterDuff$Mode0) {
            this.c = porterDuff$Mode0;
            this.e = true;
        }
        if(this.d || this.e) {
            this.a();
        }
        ColorStateList colorStateList1 = m0.j(12);
        if(colorStateList1 != null) {
            this.g = colorStateList1;
            this.i = true;
        }
        PorterDuff.Mode porterDuff$Mode1 = h0.c(typedArray0.getInt(13, -1), null);
        if(this.h != porterDuff$Mode1) {
            this.h = porterDuff$Mode1;
            this.j = true;
        }
        if(this.i || this.j) {
            this.b();
        }
        int v1 = typedArray0.getResourceId(7, 0);
        if(v1 != 0) {
            TypedArray typedArray1 = context0.obtainStyledAttributes(v1, a.z);
            if(typedArray1.hasValue(3)) {
                int v2 = typedArray1.getResourceId(3, 0);
                if(v2 == 0) {
                    colorStateList2 = typedArray1.getColorStateList(3);
                }
                else {
                    colorStateList2 = c.getColorStateList(context0, v2);
                    if(colorStateList2 == null) {
                        colorStateList2 = typedArray1.getColorStateList(3);
                    }
                }
            }
            else {
                colorStateList2 = typedArray1.getColorStateList(3);
            }
            this.i0 = colorStateList2 == null ? this.getTextColors() : colorStateList2;
            int v3 = typedArray1.getDimensionPixelSize(0, 0);
            if(v3 != 0 && ((float)v3) != textPaint0.getTextSize()) {
                textPaint0.setTextSize(((float)v3));
                this.requestLayout();
            }
            int v4 = typedArray1.getInt(1, -1);
            int v5 = typedArray1.getInt(2, -1);
            switch(v4) {
                case 1: {
                    typeface0 = Typeface.SANS_SERIF;
                    break;
                }
                case 2: {
                    typeface0 = Typeface.SERIF;
                    break;
                }
                case 3: {
                    typeface0 = Typeface.MONOSPACE;
                    break;
                }
                default: {
                    typeface0 = null;
                }
            }
            float f = 0.0f;
            if(v5 > 0) {
                Typeface typeface1 = typeface0 == null ? Typeface.defaultFromStyle(v5) : Typeface.create(typeface0, v5);
                this.setSwitchTypeface(typeface1);
                int v6 = ~(typeface1 == null ? 0 : typeface1.getStyle()) & v5;
                if((v6 & 1) == 0) {
                    z = false;
                }
                textPaint0.setFakeBoldText(z);
                if((2 & v6) != 0) {
                    f = -0.25f;
                }
                textPaint0.setTextSkewX(f);
            }
            else {
                textPaint0.setFakeBoldText(false);
                textPaint0.setTextSkewX(0.0f);
                this.setSwitchTypeface(typeface0);
            }
            this.l0 = typedArray1.getBoolean(14, false) ? new AllCapsTransformationMethod(this.getContext()) : null;
            this.setTextOnInternal(this.o);
            this.setTextOffInternal(this.w);
            typedArray1.recycle();
        }
        new T(this).f(attributeSet0, v);
        m0.t();
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
        this.G = viewConfiguration0.getScaledTouchSlop();
        this.S = viewConfiguration0.getScaledMinimumFlingVelocity();
        this.getEmojiTextViewHelper().b(attributeSet0, v);
        this.refreshDrawableState();
        this.setChecked(this.isChecked());
    }

    public final void a() {
        Drawable drawable0 = this.a;
        if(drawable0 != null && (this.d || this.e)) {
            Drawable drawable1 = drawable0.mutate();
            this.a = drawable1;
            if(this.d) {
                drawable1.setTintList(this.b);
            }
            if(this.e) {
                this.a.setTintMode(this.c);
            }
            if(this.a.isStateful()) {
                this.a.setState(this.getDrawableState());
            }
        }
    }

    public final void b() {
        Drawable drawable0 = this.f;
        if(drawable0 != null && (this.i || this.j)) {
            Drawable drawable1 = drawable0.mutate();
            this.f = drawable1;
            if(this.i) {
                drawable1.setTintList(this.g);
            }
            if(this.j) {
                this.f.setTintMode(this.h);
            }
            if(this.f.isStateful()) {
                this.f.setState(this.getDrawableState());
            }
        }
    }

    public final void c() {
        this.setTextOnInternal(this.o);
        this.setTextOffInternal(this.w);
        this.requestLayout();
    }

    public final void d() {
        if(this.o0 == null && ((u)this.n0.b.a).G() && false) {
            h h0 = h.a();
            switch(h0.c()) {
                case 0: 
                case 3: {
                    Z0 z00 = new Z0(this);
                    this.o0 = z00;
                    h0.h(z00);
                    break;
                }
            }
        }
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        int v12;
        int v7;
        int v = this.c0;
        int v1 = this.d0;
        int v2 = this.e0;
        int v3 = this.f0;
        int v4 = this.getThumbOffset() + v;
        Rect rect0 = this.a == null ? h0.c : h0.b(this.a);
        Drawable drawable0 = this.f;
        Rect rect1 = this.p0;
        if(drawable0 != null) {
            drawable0.getPadding(rect1);
            int v5 = rect1.left;
            v4 += v5;
            if(rect0 == null) {
                v7 = v1;
                v12 = v3;
            }
            else {
                int v6 = rect0.left;
                if(v6 > v5) {
                    v += v6 - v5;
                }
                v7 = rect0.top <= rect1.top ? v1 : rect0.top - rect1.top + v1;
                int v8 = rect0.right;
                int v9 = rect1.right;
                if(v8 > v9) {
                    v2 -= v8 - v9;
                }
                int v10 = rect0.bottom;
                int v11 = rect1.bottom;
                v12 = v10 > v11 ? v3 - (v10 - v11) : v3;
            }
            this.f.setBounds(v, v7, v2, v12);
        }
        Drawable drawable1 = this.a;
        if(drawable1 != null) {
            drawable1.getPadding(rect1);
            int v13 = v4 - rect1.left;
            int v14 = v4 + this.b0 + rect1.right;
            this.a.setBounds(v13, v1, v14, v3);
            Drawable drawable2 = this.getBackground();
            if(drawable2 != null) {
                drawable2.setHotspotBounds(v13, v1, v14, v3);
            }
        }
        super.draw(canvas0);
    }

    @Override  // android.widget.CompoundButton
    public final void drawableHotspotChanged(float f, float f1) {
        super.drawableHotspotChanged(f, f1);
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.setHotspot(f, f1);
        }
        Drawable drawable1 = this.f;
        if(drawable1 != null) {
            drawable1.setHotspot(f, f1);
        }
    }

    @Override  // android.widget.CompoundButton
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] arr_v = this.getDrawableState();
        Drawable drawable0 = this.a;
        boolean z = drawable0 == null || !drawable0.isStateful() ? false : drawable0.setState(arr_v);
        Drawable drawable1 = this.f;
        if(drawable1 != null && drawable1.isStateful()) {
            z |= drawable1.setState(arr_v);
        }
        if(z) {
            this.invalidate();
        }
    }

    @Override  // android.widget.CompoundButton
    public int getCompoundPaddingLeft() {
        if(this.getLayoutDirection() == 1) {
            int v = super.getCompoundPaddingLeft() + this.V;
            return TextUtils.isEmpty(this.getText()) ? v : v + this.m;
        }
        return super.getCompoundPaddingLeft();
    }

    @Override  // android.widget.CompoundButton
    public int getCompoundPaddingRight() {
        if(this.getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int v = super.getCompoundPaddingRight() + this.V;
        return TextUtils.isEmpty(this.getText()) ? v : v + this.m;
    }

    @Override  // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return B.a.a0(super.getCustomSelectionActionModeCallback());
    }

    private z getEmojiTextViewHelper() {
        if(this.n0 == null) {
            this.n0 = new z(this);
        }
        return this.n0;
    }

    public boolean getShowText() {
        return this.D;
    }

    public boolean getSplitTrack() {
        return this.n;
    }

    public int getSwitchMinWidth() {
        return this.l;
    }

    public int getSwitchPadding() {
        return this.m;
    }

    private boolean getTargetCheckedState() {
        return this.T > 0.5f;
    }

    public CharSequence getTextOff() {
        return this.w;
    }

    public CharSequence getTextOn() {
        return this.o;
    }

    public Drawable getThumbDrawable() {
        return this.a;
    }

    private int getThumbOffset() {
        return this.getLayoutDirection() == 1 ? ((int)((1.0f - this.T) * ((float)this.getThumbScrollRange()) + 0.5f)) : ((int)(this.T * ((float)this.getThumbScrollRange()) + 0.5f));
    }

    public final float getThumbPosition() {
        return this.T;
    }

    private int getThumbScrollRange() {
        Drawable drawable0 = this.f;
        if(drawable0 != null) {
            Rect rect0 = this.p0;
            drawable0.getPadding(rect0);
            Drawable drawable1 = this.a;
            if(drawable1 != null) {
                Rect rect1 = h0.b(drawable1);
                return this.V - this.b0 - rect0.left - rect0.right - rect1.left - rect1.right;
            }
            return this.V - this.b0 - rect0.left - rect0.right - h0.c.left - h0.c.right;
        }
        return 0;
    }

    public int getThumbTextPadding() {
        return this.k;
    }

    public ColorStateList getThumbTintList() {
        return this.b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.c;
    }

    public Drawable getTrackDrawable() {
        return this.f;
    }

    public ColorStateList getTrackTintList() {
        return this.g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.h;
    }

    @Override  // android.widget.CompoundButton
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable0 = this.a;
        if(drawable0 != null) {
            drawable0.jumpToCurrentState();
        }
        Drawable drawable1 = this.f;
        if(drawable1 != null) {
            drawable1.jumpToCurrentState();
        }
        if(this.m0 != null && this.m0.isStarted()) {
            this.m0.end();
            this.m0 = null;
        }
    }

    @Override  // android.widget.CompoundButton
    public int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.isChecked()) {
            View.mergeDrawableStates(arr_v, SwitchCompat.r0);
        }
        return arr_v;
    }

    @Override  // android.widget.CompoundButton
    public final void onDraw(Canvas canvas0) {
        int v4;
        super.onDraw(canvas0);
        Drawable drawable0 = this.f;
        Rect rect0 = this.p0;
        if(drawable0 == null) {
            rect0.setEmpty();
        }
        else {
            drawable0.getPadding(rect0);
        }
        int v = this.d0 + rect0.top;
        int v1 = this.f0 - rect0.bottom;
        Drawable drawable1 = this.a;
        if(drawable0 != null) {
            if(!this.n || drawable1 == null) {
                drawable0.draw(canvas0);
            }
            else {
                Rect rect1 = h0.b(drawable1);
                drawable1.copyBounds(rect0);
                rect0.left += rect1.left;
                rect0.right -= rect1.right;
                int v2 = canvas0.save();
                canvas0.clipRect(rect0, Region.Op.DIFFERENCE);
                drawable0.draw(canvas0);
                canvas0.restoreToCount(v2);
            }
        }
        int v3 = canvas0.save();
        if(drawable1 != null) {
            drawable1.draw(canvas0);
        }
        StaticLayout staticLayout0 = this.getTargetCheckedState() ? this.j0 : this.k0;
        if(staticLayout0 != null) {
            int[] arr_v = this.getDrawableState();
            TextPaint textPaint0 = this.h0;
            ColorStateList colorStateList0 = this.i0;
            if(colorStateList0 != null) {
                textPaint0.setColor(colorStateList0.getColorForState(arr_v, 0));
            }
            textPaint0.drawableState = arr_v;
            if(drawable1 == null) {
                v4 = this.getWidth();
            }
            else {
                Rect rect2 = drawable1.getBounds();
                v4 = rect2.left + rect2.right;
            }
            canvas0.translate(((float)(v4 / 2 - staticLayout0.getWidth() / 2)), ((float)((v + v1) / 2 - staticLayout0.getHeight() / 2)));
            staticLayout0.draw(canvas0);
        }
        canvas0.restoreToCount(v3);
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("android.widget.Switch");
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("android.widget.Switch");
        if(Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence0 = this.isChecked() ? this.o : this.w;
            if(!TextUtils.isEmpty(charSequence0)) {
                CharSequence charSequence1 = accessibilityNodeInfo0.getText();
                if(TextUtils.isEmpty(charSequence1)) {
                    accessibilityNodeInfo0.setText(charSequence0);
                    return;
                }
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append(charSequence1);
                stringBuilder0.append(' ');
                stringBuilder0.append(charSequence0);
                accessibilityNodeInfo0.setText(stringBuilder0);
            }
        }
    }

    @Override  // android.widget.TextView
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        super.onLayout(z, v, v1, v2, v3);
        int v4 = 0;
        if(this.a == null) {
            v5 = 0;
        }
        else {
            Drawable drawable0 = this.f;
            Rect rect0 = this.p0;
            if(drawable0 == null) {
                rect0.setEmpty();
            }
            else {
                drawable0.getPadding(rect0);
            }
            Rect rect1 = h0.b(this.a);
            v5 = Math.max(0, rect1.left - rect0.left);
            v4 = Math.max(0, rect1.right - rect0.right);
        }
        if(this.getLayoutDirection() == 1) {
            v6 = this.getPaddingLeft() + v5;
            v7 = this.V + v6 - v5 - v4;
        }
        else {
            v7 = this.getWidth() - this.getPaddingRight() - v4;
            v6 = v7 - this.V + v5 + v4;
        }
        switch(this.getGravity() & 0x70) {
            case 16: {
                int v10 = this.getPaddingTop();
                int v11 = (this.getHeight() + v10 - this.getPaddingBottom()) / 2 - this.W / 2;
                v9 = this.W + v11;
                v8 = v11;
                break;
            }
            case 80: {
                v9 = this.getHeight() - this.getPaddingBottom();
                v8 = v9 - this.W;
                break;
            }
            default: {
                v8 = this.getPaddingTop();
                v9 = this.W + v8;
            }
        }
        this.c0 = v6;
        this.d0 = v8;
        this.f0 = v9;
        this.e0 = v7;
    }

    @Override  // android.widget.TextView
    public final void onMeasure(int v, int v1) {
        int v6;
        int v4;
        int v3;
        int v2 = 0;
        if(this.D) {
            TextPaint textPaint0 = this.h0;
            if(this.j0 == null) {
                this.j0 = new StaticLayout(this.r, textPaint0, (this.r == null ? 0 : ((int)Math.ceil(Layout.getDesiredWidth(this.r, textPaint0)))), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if(this.k0 == null) {
                this.k0 = new StaticLayout(this.B, textPaint0, (this.B == null ? 0 : ((int)Math.ceil(Layout.getDesiredWidth(this.B, textPaint0)))), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable0 = this.a;
        Rect rect0 = this.p0;
        if(drawable0 == null) {
            v3 = 0;
            v4 = 0;
        }
        else {
            drawable0.getPadding(rect0);
            v3 = this.a.getIntrinsicWidth() - rect0.left - rect0.right;
            v4 = this.a.getIntrinsicHeight();
        }
        if(this.D) {
            int v5 = Math.max(this.j0.getWidth(), this.k0.getWidth());
            v6 = this.k * 2 + v5;
        }
        else {
            v6 = 0;
        }
        this.b0 = Math.max(v6, v3);
        Drawable drawable1 = this.f;
        if(drawable1 == null) {
            rect0.setEmpty();
        }
        else {
            drawable1.getPadding(rect0);
            v2 = this.f.getIntrinsicHeight();
        }
        int v7 = rect0.left;
        int v8 = rect0.right;
        Drawable drawable2 = this.a;
        if(drawable2 != null) {
            Rect rect1 = h0.b(drawable2);
            v7 = Math.max(v7, rect1.left);
            v8 = Math.max(v8, rect1.right);
        }
        int v9 = Math.max(v2, v4);
        this.V = this.g0 ? Math.max(this.l, this.b0 * 2 + v7 + v8) : this.l;
        this.W = v9;
        super.onMeasure(v, v1);
        if(this.getMeasuredHeight() < v9) {
            this.setMeasuredDimension(this.getMeasuredWidthAndState(), v9);
        }
    }

    @Override  // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onPopulateAccessibilityEvent(accessibilityEvent0);
        CharSequence charSequence0 = this.isChecked() ? this.o : this.w;
        if(charSequence0 != null) {
            accessibilityEvent0.getText().add(charSequence0);
        }
    }

    @Override  // android.widget.TextView
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z2;
        float f4;
        VelocityTracker velocityTracker0 = this.N;
        velocityTracker0.addMovement(motionEvent0);
        int v = motionEvent0.getActionMasked();
        int v1 = this.G;
        if(v == 0) {
            float f9 = motionEvent0.getX();
            float f10 = motionEvent0.getY();
            if(this.isEnabled() && this.a != null) {
                int v3 = this.getThumbOffset();
                this.a.getPadding(this.p0);
                int v4 = this.c0 + v3 - v1;
                if(f9 > ((float)v4) && f9 < ((float)(this.b0 + v4 + this.p0.left + this.p0.right + v1)) && f10 > ((float)(this.d0 - v1)) && f10 < ((float)(this.f0 + v1))) {
                    this.E = 1;
                    this.I = f9;
                    this.M = f10;
                }
            }
        }
        else {
            float f = 0.0f;
        alab1:
            switch(v) {
                case 2: {
                    switch(this.E) {
                        case 1: {
                            break alab1;
                        }
                        case 2: {
                            goto label_44;
                        }
                    }
                    return super.onTouchEvent(motionEvent0);
                label_44:
                    float f2 = motionEvent0.getX();
                    int v2 = this.getThumbScrollRange();
                    float f3 = f2 - this.I;
                    if(v2 == 0) {
                        f4 = f3 > 0.0f ? 1.0f : -1.0f;
                    }
                    else {
                        f4 = f3 / ((float)v2);
                    }
                    if(this.getLayoutDirection() == 1) {
                        f4 = -f4;
                    }
                    float f5 = this.T;
                    float f6 = f4 + f5;
                    if(f6 >= 0.0f) {
                        f = f6 > 1.0f ? 1.0f : f6;
                    }
                    if(f != f5) {
                        this.I = f2;
                        this.setThumbPosition(f);
                    }
                    return true;
                }
                case 1: 
                case 3: {
                    if(this.E == 2) {
                        this.E = 0;
                        boolean z = motionEvent0.getAction() == 1 && this.isEnabled();
                        boolean z1 = this.isChecked();
                        if(z) {
                            velocityTracker0.computeCurrentVelocity(1000);
                            float f1 = velocityTracker0.getXVelocity();
                            if(Math.abs(f1) <= ((float)this.S)) {
                                z2 = this.getTargetCheckedState();
                            }
                            else if(this.getLayoutDirection() != 1) {
                                z2 = f1 > 0.0f;
                            }
                            else if(f1 < 0.0f) {
                                z2 = true;
                            }
                            else {
                                z2 = false;
                            }
                        }
                        else {
                            z2 = z1;
                        }
                        if(z2 != z1) {
                            this.playSoundEffect(0);
                        }
                        this.setChecked(z2);
                        MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
                        motionEvent1.setAction(3);
                        super.onTouchEvent(motionEvent1);
                        motionEvent1.recycle();
                        super.onTouchEvent(motionEvent0);
                        return true;
                    }
                    this.E = 0;
                    velocityTracker0.clear();
                    return super.onTouchEvent(motionEvent0);
                }
                default: {
                    return super.onTouchEvent(motionEvent0);
                }
            }
            float f7 = motionEvent0.getX();
            float f8 = motionEvent0.getY();
            if(Math.abs(f7 - this.I) > ((float)v1) || Math.abs(f8 - this.M) > ((float)v1)) {
                this.E = 2;
                this.getParent().requestDisallowInterceptTouchEvent(true);
                this.I = f7;
                this.M = f8;
                return true;
            }
        }
        return super.onTouchEvent(motionEvent0);
    }

    @Override  // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        this.getEmojiTextViewHelper().c(z);
    }

    @Override  // android.widget.CompoundButton
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean z1 = this.isChecked();
        Class class0 = CharSequence.class;
        if(!z1) {
            if(Build.VERSION.SDK_INT >= 30) {
                CharSequence charSequence1 = this.w;
                if(charSequence1 == null) {
                    charSequence1 = "OFF";
                }
                new H(0x7F0A0B2F, class0, 0x40, 30, 2).h(this, charSequence1);  // id:tag_state_description
            }
        }
        else if(Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence0 = this.o;
            if(charSequence0 == null) {
                charSequence0 = "ON";
            }
            new H(0x7F0A0B2F, class0, 0x40, 30, 2).h(this, charSequence0);  // id:tag_state_description
        }
        float f = 0.0f;
        if(this.getWindowToken() != null && this.isLaidOut()) {
            if(z1) {
                f = 1.0f;
            }
            ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this, SwitchCompat.q0, new float[]{f});
            this.m0 = objectAnimator0;
            objectAnimator0.setDuration(0xFAL);
            this.m0.setAutoCancel(true);
            this.m0.start();
            return;
        }
        ObjectAnimator objectAnimator1 = this.m0;
        if(objectAnimator1 != null) {
            objectAnimator1.cancel();
        }
        if(z1) {
            f = 1.0f;
        }
        this.setThumbPosition(f);
    }

    @Override  // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(B.a.b0(actionMode$Callback0, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.getEmojiTextViewHelper().d(z);
        this.setTextOnInternal(this.o);
        this.setTextOffInternal(this.w);
        this.requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.g0 = z;
        this.invalidate();
    }

    @Override  // android.widget.TextView
    public void setFilters(InputFilter[] arr_inputFilter) {
        super.setFilters(this.getEmojiTextViewHelper().a(arr_inputFilter));
    }

    public void setShowText(boolean z) {
        if(this.D != z) {
            this.D = z;
            this.requestLayout();
            if(z) {
                this.d();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.n = z;
        this.invalidate();
    }

    public void setSwitchMinWidth(int v) {
        this.l = v;
        this.requestLayout();
    }

    public void setSwitchPadding(int v) {
        this.m = v;
        this.requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface0) {
        TextPaint textPaint0 = this.h0;
        if(textPaint0.getTypeface() != null && !textPaint0.getTypeface().equals(typeface0) || textPaint0.getTypeface() == null && typeface0 != null) {
            textPaint0.setTypeface(typeface0);
            this.requestLayout();
            this.invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence0) {
        this.setTextOffInternal(charSequence0);
        this.requestLayout();
        if(!this.isChecked() && Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence1 = this.w;
            if(charSequence1 == null) {
                charSequence1 = "OFF";
            }
            new H(0x7F0A0B2F, CharSequence.class, 0x40, 30, 2).h(this, charSequence1);  // id:tag_state_description
        }
    }

    private void setTextOffInternal(CharSequence charSequence0) {
        this.w = charSequence0;
        TransformationMethod transformationMethod0 = ((u)this.getEmojiTextViewHelper().b.a).W(this.l0);
        if(transformationMethod0 != null) {
            charSequence0 = transformationMethod0.getTransformation(charSequence0, this);
        }
        this.B = charSequence0;
        this.k0 = null;
        if(this.D) {
            this.d();
        }
    }

    public void setTextOn(CharSequence charSequence0) {
        this.setTextOnInternal(charSequence0);
        this.requestLayout();
        if(this.isChecked() && Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence1 = this.o;
            if(charSequence1 == null) {
                charSequence1 = "ON";
            }
            new H(0x7F0A0B2F, CharSequence.class, 0x40, 30, 2).h(this, charSequence1);  // id:tag_state_description
        }
    }

    private void setTextOnInternal(CharSequence charSequence0) {
        this.o = charSequence0;
        TransformationMethod transformationMethod0 = ((u)this.getEmojiTextViewHelper().b.a).W(this.l0);
        if(transformationMethod0 != null) {
            charSequence0 = transformationMethod0.getTransformation(charSequence0, this);
        }
        this.r = charSequence0;
        this.j0 = null;
        if(this.D) {
            this.d();
        }
    }

    public void setThumbDrawable(Drawable drawable0) {
        Drawable drawable1 = this.a;
        if(drawable1 != null) {
            drawable1.setCallback(null);
        }
        this.a = drawable0;
        if(drawable0 != null) {
            drawable0.setCallback(this);
        }
        this.requestLayout();
    }

    public void setThumbPosition(float f) {
        this.T = f;
        this.invalidate();
    }

    public void setThumbResource(int v) {
        this.setThumbDrawable(w.B(this.getContext(), v));
    }

    public void setThumbTextPadding(int v) {
        this.k = v;
        this.requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList0) {
        this.b = colorStateList0;
        this.d = true;
        this.a();
    }

    public void setThumbTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.c = porterDuff$Mode0;
        this.e = true;
        this.a();
    }

    public void setTrackDrawable(Drawable drawable0) {
        Drawable drawable1 = this.f;
        if(drawable1 != null) {
            drawable1.setCallback(null);
        }
        this.f = drawable0;
        if(drawable0 != null) {
            drawable0.setCallback(this);
        }
        this.requestLayout();
    }

    public void setTrackResource(int v) {
        this.setTrackDrawable(w.B(this.getContext(), v));
    }

    public void setTrackTintList(ColorStateList colorStateList0) {
        this.g = colorStateList0;
        this.i = true;
        this.b();
    }

    public void setTrackTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.h = porterDuff$Mode0;
        this.j = true;
        this.b();
    }

    @Override  // android.widget.CompoundButton
    public final void toggle() {
        this.setChecked(!this.isChecked());
    }

    @Override  // android.widget.CompoundButton
    public final boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.a || drawable0 == this.f;
    }
}

