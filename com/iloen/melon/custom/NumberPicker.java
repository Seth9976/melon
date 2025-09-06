package com.iloen.melon.custom;

import E9.t;
import P1.c;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.media3.session.H0;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;
import k8.t1;

public class NumberPicker extends LinearLayout {
    public static class CustomEditText extends AppCompatEditText {
        public CustomEditText(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        @Override  // android.widget.TextView
        public final void onEditorAction(int v) {
            super.onEditorAction(v);
            if(v == 6) {
                this.clearFocus();
            }
        }
    }

    public boolean A0;
    public int B;
    public int B0;
    public final boolean C0;
    public int D;
    public boolean D0;
    public int E;
    public float E0;
    public float F0;
    public B0 G;
    public int G0;
    public boolean H0;
    public boolean I;
    public final Context I0;
    public NumberFormat J0;
    public final ViewConfiguration K0;
    public int L0;
    public z0 M;
    public t M0;
    public long N;
    public boolean N0;
    public static final D0 O0;
    public static final char[] P0;
    public final SparseArray S;
    public final int[] T;
    public final Paint V;
    public int W;
    public final EditText a;
    public float b;
    public int b0;
    public final int c;
    public int c0;
    public final int d;
    public final Scroller d0;
    public final int e;
    public final Scroller e0;
    public int f;
    public int f0;
    public final boolean g;
    public C0 g0;
    public final int h;
    public y0 h0;
    public int i;
    public float i0;
    public float j;
    public long j0;
    public Typeface k;
    public float k0;
    public final int l;
    public VelocityTracker l0;
    public int m;
    public final int m0;
    public float n;
    public final int n0;
    public Typeface o;
    public int o0;
    public boolean p0;
    public boolean q0;
    public int r;
    public Drawable r0;
    public int s0;
    public int t0;
    public final int u0;
    public int v0;
    public String[] w;
    public int w0;
    public int x0;
    public int y0;
    public boolean z0;

    static {
        NumberPicker.O0 = new D0();
        NumberPicker.P0 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩', '۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹', '०', '१', '२', '३', '४', '५', '६', '७', '८', '९', '০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯', '೦', '೧', '೨', '೩', '೪', '೫', '೬', '೭', '೮', '೯', '-'};
    }

    public NumberPicker(Context context0) {
        this(context0, null);
    }

    public NumberPicker(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public NumberPicker(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0);
        this.h = 1;
        this.i = 0xFF000000;
        this.j = 38.0f;
        this.l = 1;
        this.m = 0xFF000000;
        this.n = 38.0f;
        this.B = 1;
        this.D = 59;
        this.I = true;
        this.N = 300L;
        this.S = new SparseArray();
        this.T = new int[3];
        this.b0 = 0x80000000;
        this.q0 = true;
        this.s0 = 0xFF000000;
        this.y0 = 0;
        this.B0 = -1;
        this.D0 = true;
        this.E0 = 0.9f;
        this.F0 = 1.0f;
        this.G0 = 8;
        this.H0 = true;
        this.L0 = 0;
        this.N0 = false;
        this.I0 = context0;
        this.J0 = NumberFormat.getInstance();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.v, v, 0);
        Drawable drawable0 = typedArray0.getDrawable(13);
        if(drawable0 == null) {
            int v1 = typedArray0.getColor(14, this.s0);
            this.s0 = v1;
            this.setDividerColor(v1);
        }
        else {
            drawable0.setCallback(this);
            if(drawable0.isStateful()) {
                drawable0.setState(this.getDrawableState());
            }
            this.r0 = drawable0;
        }
        DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
        int v2 = (int)TypedValue.applyDimension(1, 48.0f, displayMetrics0);
        int v3 = (int)TypedValue.applyDimension(1, 2.0f, displayMetrics0);
        this.t0 = typedArray0.getDimensionPixelSize(17, v2);
        this.u0 = typedArray0.getDimensionPixelSize(16, 0);
        this.v0 = typedArray0.getDimensionPixelSize(15, v3);
        float f = (float)typedArray0.getDimensionPixelSize(22, -1);
        float f1 = (float)typedArray0.getDimensionPixelSize(3, -1);
        this.c = -1;
        this.d = (int)(180.0f * this.getResources().getDisplayMetrics().density);
        this.e = (int)(45.0f * this.getResources().getDisplayMetrics().density);
        this.f = -1;
        this.g = true;
        this.E = typedArray0.getInt(21, this.E);
        this.D = typedArray0.getInt(7, this.D);
        this.B = typedArray0.getInt(9, this.B);
        this.i = typedArray0.getColor(10, this.i);
        this.j = typedArray0.getDimension(11, this.j * this.getResources().getDisplayMetrics().density);
        this.k = Typeface.create(typedArray0.getString(12), 0);
        this.m = typedArray0.getColor(18, this.m);
        this.n = typedArray0.getDimension(19, this.n * this.getResources().getDisplayMetrics().density);
        this.o = Typeface.create(typedArray0.getString(20), 0);
        this.D0 = typedArray0.getBoolean(1, this.D0);
        this.E0 = typedArray0.getFloat(2, this.E0);
        this.F0 = typedArray0.getFloat(6, this.F0);
        this.G0 = typedArray0.getInt(8, this.G0);
        this.C0 = typedArray0.getBoolean(4, false);
        this.H0 = typedArray0.getBoolean(0, true);
        this.L0 = typedArray0.getDimensionPixelSize(5, 0);
        this.setWillNotDraw(false);
        ((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(0x7F0D058B, this, true);  // layout:number_picker_material
        EditText editText0 = (EditText)this.findViewById(0x7F0A08C6);  // id:np_numberpicker_input
        this.a = editText0;
        editText0.setOnFocusChangeListener(new w(this, 1));
        editText0.setFilters(new InputFilter[]{new x(this, 1)});
        editText0.setRawInputType(2);
        editText0.setImeOptions(6);
        editText0.setVisibility(4);
        Paint paint0 = new Paint();
        paint0.setAntiAlias(true);
        paint0.setTextAlign(Paint.Align.CENTER);
        this.V = paint0;
        this.setSelectedTextColor(this.i);
        this.setTextColor(this.m);
        this.setTextSize(this.n);
        this.setSelectedTextSize(this.j);
        this.setTypeface(this.o);
        this.setSelectedTypeface(this.k);
        this.setFormatter(this.M);
        this.p();
        this.setValue(this.E);
        this.setMaxValue(this.D);
        this.setMinValue(this.B);
        boolean z = typedArray0.getBoolean(23, this.p0);
        this.p0 = z;
        this.setWrapSelectorWheel(z);
        int v4 = Float.compare(f, -1.0f);
        if(v4 != 0 && f1 != -1.0f) {
            this.setScaleX(f / ((float)this.e));
            this.setScaleY(f1 / ((float)this.d));
        }
        else if(v4 != 0) {
            float f2 = f / ((float)this.e);
            this.setScaleX(f2);
            this.setScaleY(f2);
        }
        else if(f1 != -1.0f) {
            float f3 = f1 / ((float)this.d);
            this.setScaleX(f3);
            this.setScaleY(f3);
        }
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
        this.K0 = viewConfiguration0;
        this.m0 = viewConfiguration0.getScaledTouchSlop();
        this.n0 = viewConfiguration0.getScaledMinimumFlingVelocity();
        this.o0 = viewConfiguration0.getScaledMaximumFlingVelocity() / this.G0;
        this.d0 = new Scroller(context0, null, true);
        this.e0 = new Scroller(context0, new DecelerateInterpolator(2.5f));
        if(this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
        if(this.getFocusable() == 16) {
            this.setFocusable(1);
            this.setFocusableInTouchMode(true);
        }
        typedArray0.recycle();
    }

    public final void a(boolean z) {
        this.g();
        Scroller scroller0 = this.d0;
        if(!this.j(scroller0)) {
            this.j(this.e0);
        }
        this.f0 = 0;
        if(z) {
            scroller0.startScroll(0, 0, 0, -this.r, 300);
        }
        else {
            scroller0.startScroll(0, 0, 0, this.r, 300);
        }
        this.invalidate();
    }

    public final void b(int v) {
        String s;
        SparseArray sparseArray0 = this.S;
        if(((String)sparseArray0.get(v)) != null) {
            return;
        }
        int v1 = this.B;
        if(v < v1 || v > this.D) {
            s = "";
        }
        else {
            String[] arr_s = this.w;
            if(arr_s == null) {
                s = this.d(v);
            }
            else {
                int v2 = v - v1;
                if(v2 >= arr_s.length) {
                    sparseArray0.remove(v);
                    return;
                }
                s = arr_s[v2];
            }
        }
        sparseArray0.put(v, s);
    }

    public final void c() {
        int v = this.b0 - this.c0;
        if(v == 0) {
            return;
        }
        int v1 = this.W;
        if(Math.abs(v) > v1 / 2) {
            if(v > 0) {
                v1 = -v1;
            }
            v += v1;
        }
        this.f0 = 0;
        this.e0.startScroll(0, 0, 0, v, 800);
        this.invalidate();
    }

    @Override  // android.view.View
    public final void computeScroll() {
        Scroller scroller0 = this.d0;
        if(scroller0.isFinished()) {
            scroller0 = this.e0;
            if(scroller0.isFinished()) {
                return;
            }
        }
        scroller0.computeScrollOffset();
        int v = scroller0.getCurrY();
        if(this.f0 == 0) {
            this.f0 = scroller0.getStartY();
        }
        this.scrollBy(0, v - this.f0);
        this.f0 = v;
        if(scroller0.isFinished()) {
            this.k(scroller0);
            return;
        }
        this.postInvalidate();
    }

    @Override  // android.view.View
    public final int computeVerticalScrollExtent() {
        return this.getHeight();
    }

    public final String d(int v) {
        z0 z00 = this.M;
        if(z00 != null) {
            StringBuilder stringBuilder0 = ((D0)z00).a;
            Object[] arr_object = ((D0)z00).d;
            Locale locale0 = Locale.getDefault();
            if(((D0)z00).b != new DecimalFormatSymbols(locale0).getZeroDigit()) {
                ((D0)z00).c = new Formatter(stringBuilder0, locale0);
                ((D0)z00).b = new DecimalFormatSymbols(locale0).getZeroDigit();
            }
            arr_object[0] = v;
            stringBuilder0.delete(0, stringBuilder0.length());
            ((D0)z00).c.format("%02d", arr_object);
            return ((D0)z00).c.toString();
        }
        return this.J0.format(((long)v));
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        int v = keyEvent0.getKeyCode();
        if(v == 19 || v == 20) {
            switch(keyEvent0.getAction()) {
                case 0: {
                    if(this.p0 || (v == 20 ? this.getValue() < this.getMaxValue() : this.getValue() > this.getMinValue())) {
                        this.requestFocus();
                        this.B0 = v;
                        this.l();
                        if(this.d0.isFinished()) {
                            this.a(v == 20);
                        }
                        return true;
                    }
                    break;
                }
                case 1: {
                    if(this.B0 == v) {
                        this.B0 = -1;
                        return true;
                    }
                    break;
                }
                default: {
                    return super.dispatchKeyEvent(keyEvent0);
                }
            }
        }
        else if(v == 23 || v == 66) {
            this.l();
            return super.dispatchKeyEvent(keyEvent0);
        }
        return super.dispatchKeyEvent(keyEvent0);
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getAction() & 0xFF) {
            case 1: 
            case 3: {
                this.l();
                return super.dispatchTouchEvent(motionEvent0);
            }
            default: {
                return super.dispatchTouchEvent(motionEvent0);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getAction() & 0xFF) {
            case 1: 
            case 3: {
                this.l();
                return super.dispatchTrackballEvent(motionEvent0);
            }
            default: {
                return super.dispatchTrackballEvent(motionEvent0);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.r0 != null && this.r0.isStateful() && this.r0.setState(this.getDrawableState())) {
            this.invalidateDrawable(this.r0);
        }
    }

    public final int e(String s) {
        if(this.w == null) {
            try {
                return Integer.parseInt(s);
            }
            catch(NumberFormatException unused_ex) {
                return this.B;
            }
        }
        for(int v = 0; v < this.w.length; ++v) {
            s = s.toLowerCase();
            if(this.w[v].toLowerCase().startsWith(s)) {
                return this.B + v;
            }
        }
        try {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
            return this.B;
        }
    }

    public final int f(int v) {
        int v1 = this.D;
        if(v > v1) {
            return (v - v1) % (v1 - this.B) + this.B - 1;
        }
        return v >= this.B ? v : v1 - (this.B - v) % (v1 - this.B) + 1;
    }

    public final void g() {
        InputMethodManager inputMethodManager0 = (InputMethodManager)this.getContext().getSystemService(InputMethodManager.class);
        EditText editText0 = this.a;
        if(inputMethodManager0 != null && inputMethodManager0.isActive(editText0)) {
            inputMethodManager0.hideSoftInputFromWindow(this.getWindowToken(), 0);
        }
        editText0.setVisibility(4);
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public float getBottomFadingEdgeStrength() {
        return this.D0 ? this.E0 : 0.0f;
    }

    public String[] getDisplayedValues() {
        return this.w;
    }

    public int getDividerColor() {
        return this.s0;
    }

    public float getDividerDistance() {
        return ((float)this.t0) / this.getResources().getDisplayMetrics().density;
    }

    public float getDividerHeight() {
        return ((float)this.v0) / this.getResources().getDisplayMetrics().density;
    }

    public float getFadingEdgeStrength() {
        return this.E0;
    }

    public z0 getFormatter() {
        return this.M;
    }

    public float getLineSpacingMultiplier() {
        return this.F0;
    }

    public int getMaxFlingVelocityCoefficient() {
        return this.G0;
    }

    private float getMaxTextSize() {
        return Math.max(this.n, this.j);
    }

    public int getMaxValue() {
        return this.D;
    }

    public int getMinValue() {
        return this.B;
    }

    public int getSelectedTextAlign() {
        return this.h;
    }

    public int getSelectedTextColor() {
        return this.i;
    }

    public float getSelectedTextSize() {
        return this.j;
    }

    private int[] getSelectorIndices() {
        return this.T;
    }

    public int getTextAlign() {
        return this.l;
    }

    public int getTextColor() {
        return this.m;
    }

    public float getTextSize() {
        return this.n;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public float getTopFadingEdgeStrength() {
        return this.D0 ? this.E0 : 0.0f;
    }

    private int getTransparentColor() [...] // Inlined contents

    public static z0 getTwoDigitFormatter() {
        return NumberPicker.O0;
    }

    public Typeface getTypeface() {
        return this.o;
    }

    public int getValue() {
        return this.E;
    }

    public int getWheelItemCount() {
        return 3;
    }

    public boolean getWrapSelectorWheel() {
        return this.p0;
    }

    public final void h() {
        this.S.clear();
        int[] arr_v = this.getSelectorIndices();
        int v = this.getValue();
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            int v2 = this.p0 ? this.f(v1 - 1 + v) : v1 - 1 + v;
            arr_v[v1] = v2;
            this.b(v2);
        }
    }

    public static int i(int v, int v1) {
        if(v1 != -1) {
            int v2 = View.MeasureSpec.getSize(v);
            int v3 = View.MeasureSpec.getMode(v);
            switch(v3) {
                case 0x80000000: {
                    return View.MeasureSpec.makeMeasureSpec(Math.min(v2, v1), 0x40000000);
                }
                case 0: {
                    return View.MeasureSpec.makeMeasureSpec(v1, 0x40000000);
                }
                case 0x40000000: {
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown measure mode: " + v3);
                }
            }
        }
        return v;
    }

    public final boolean j(Scroller scroller0) {
        scroller0.forceFinished(true);
        int v = scroller0.getFinalY() - scroller0.getCurrY();
        int v1 = this.b0 - (this.c0 + v) % this.W;
        if(v1 != 0) {
            int v2 = this.W;
            if(Math.abs(v1) > v2 / 2) {
                v1 = v1 <= 0 ? v1 + v2 : v1 - v2;
            }
            this.scrollBy(0, v + v1);
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable0 = this.r0;
        if(drawable0 != null) {
            drawable0.jumpToCurrentState();
        }
    }

    public final void k(Scroller scroller0) {
        if(scroller0 == this.d0) {
            this.c();
            this.p();
            if(this.y0 != 0) {
                this.y0 = 0;
            }
        }
        else if(this.y0 != 1) {
            this.p();
        }
    }

    public final void l() {
        y0 y00 = this.h0;
        if(y00 != null) {
            this.removeCallbacks(y00);
        }
        C0 c00 = this.g0;
        if(c00 != null && c00.d) {
            ((EditText)c00.e).removeCallbacks(c00);
            c00.d = false;
        }
        t t0 = this.M0;
        if(t0 != null) {
            this.removeCallbacks(t0);
        }
    }

    public static int m(int v, int v1, int v2) {
        if(v != -1) {
            int v3 = Math.max(v, v1);
            int v4 = View.MeasureSpec.getMode(v2);
            int v5 = View.MeasureSpec.getSize(v2);
            switch(v4) {
                case 0x80000000: {
                    return v5 >= v3 ? v3 : 0x1000000 | v5;
                }
                case 0x40000000: {
                    return v5;
                }
                default: {
                    return v3;
                }
            }
        }
        return v1;
    }

    public final void n(int v, boolean z) {
        if(this.E == v) {
            return;
        }
        int v1 = this.p0 ? this.f(v) : Math.min(Math.max(v, this.B), this.D);
        int v2 = this.E;
        this.E = v1;
        if(this.y0 != 2) {
            this.p();
        }
        if(z) {
            B0 b00 = this.G;
            if(b00 != null) {
                SettingMusicAlarmFragment.Z(((SettingMusicAlarmFragment)((H0)b00).b), ((NumberPicker)((H0)b00).c), this, v2, v1);
            }
        }
        this.h();
        if(this.H0) {
            this.setContentDescription(String.valueOf(this.getValue()));
        }
        this.invalidate();
    }

    public final void o() {
        int v3;
        if(this.g) {
            Paint paint0 = this.V;
            paint0.setTextSize(this.getMaxTextSize());
            String[] arr_s = this.w;
            int v = 0;
            if(arr_s == null) {
                float f = 0.0f;
                for(int v1 = 0; v1 <= 9; ++v1) {
                    float f1 = paint0.measureText(this.d(v1));
                    if(f1 > f) {
                        f = f1;
                    }
                }
                for(int v2 = this.D; v2 > 0; v2 /= 10) {
                    ++v;
                }
                v3 = (int)(((float)v) * f);
            }
            else {
                int v4 = 0;
                while(v < arr_s.length) {
                    float f2 = paint0.measureText(arr_s[v]);
                    if(f2 > ((float)v4)) {
                        v4 = (int)f2;
                    }
                    ++v;
                }
                v3 = v4;
            }
            int v5 = this.a.getPaddingLeft();
            int v6 = this.a.getPaddingRight() + v5 + v3;
            if(this.f != v6) {
                this.f = Math.max(v6, this.e);
                this.invalidate();
            }
        }
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.J0 = NumberFormat.getInstance();
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l();
    }

    @Override  // android.widget.LinearLayout
    public final void onDraw(Canvas canvas0) {
        int v8;
        int v7;
        int v4;
        canvas0.save();
        boolean z = !this.C0 || this.hasFocus();
        int v1 = this.getRight();
        int v2 = this.getLeft();
        float f = (float)this.c0;
        int[] arr_v = this.getSelectorIndices();
        int v3 = 0;
        for(int v = 0; v3 < arr_v.length; v = 0) {
            Paint paint0 = this.V;
            if(v3 == 1) {
                Paint.Align[] arr_paint$Align = Paint.Align.values();
                paint0.setTextAlign(arr_paint$Align[this.h]);
                paint0.setTextSize(this.j);
                paint0.setColor(this.i);
                paint0.setTypeface(this.k);
            }
            else {
                Paint.Align[] arr_paint$Align1 = Paint.Align.values();
                paint0.setTextAlign(arr_paint$Align1[this.l]);
                paint0.setTextSize(this.n);
                paint0.setColor((this.N0 ? 0 : this.m));
                paint0.setTypeface(this.o);
            }
            String s = (String)this.S.get(arr_v[v3]);
            if(s != null) {
                if(z && v3 != 1 || v3 == 1 && this.a.getVisibility() != 0) {
                    Paint.FontMetrics paint$FontMetrics0 = paint0.getFontMetrics();
                    float f1 = paint$FontMetrics0 == null ? 0.0f : Math.abs(paint$FontMetrics0.top + paint$FontMetrics0.bottom) / 2.0f;
                    if(v3 == 1) {
                        v4 = 0;
                    }
                    else {
                        v4 = this.L0;
                        if(v4 == 0) {
                            v4 = 0;
                        }
                        else if(v3 <= 1) {
                            v4 = -v4;
                        }
                    }
                    float f2 = 0.0f + ((float)(v1 - v2)) / 2.0f;
                    float f3 = f1 + f + ((float)v4);
                    if(s.contains("\n")) {
                        String[] arr_s = s.split("\n");
                        float f4 = paint0.descent();
                        float f5 = Math.abs(paint0.ascent() + f4) * this.F0;
                        float f6 = f3 - ((float)(arr_s.length - 1)) * f5 / 2.0f;
                        while(v < arr_s.length) {
                            canvas0.drawText(arr_s[v], f2, f6, paint0);
                            f6 += f5;
                            ++v;
                        }
                    }
                    else {
                        canvas0.drawText(s, f2, f3, paint0);
                    }
                }
                f += (float)this.W;
            }
            ++v3;
        }
        canvas0.restore();
        if(z && this.r0 != null) {
            int v5 = this.u0;
            if(v5 > 0) {
                int v6 = this.f;
                if(v5 <= v6) {
                    v7 = (v6 - v5) / 2;
                    v8 = v5 + v7;
                }
                else {
                    v8 = this.getRight();
                    v7 = 0;
                }
            }
            else {
                v8 = this.getRight();
                v7 = 0;
            }
            this.r0.setBounds(v7, this.w0, v8, this.v0 + this.w0);
            this.r0.draw(canvas0);
            this.r0.setBounds(v7, this.x0 - this.v0, v8, this.x0);
            this.r0.draw(canvas0);
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("com.iloen.melon.custom.NumberPicker");
        int v = (this.D - this.B) * this.W;
        accessibilityEvent0.setScrollY((this.E + this.B) * this.W);
        accessibilityEvent0.setMaxScrollY(v);
    }

    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        if(!this.isEnabled() || motionEvent0.getActionMasked() != 0) {
            return false;
        }
        this.l();
        if(!this.N0) {
            this.g();
        }
        float f = motionEvent0.getY();
        this.i0 = f;
        this.k0 = f;
        this.j0 = motionEvent0.getEventTime();
        this.z0 = false;
        this.A0 = false;
        this.getParent().requestDisallowInterceptTouchEvent(true);
        Scroller scroller0 = this.d0;
        boolean z = scroller0.isFinished();
        Scroller scroller1 = this.e0;
        if(!z) {
            scroller0.forceFinished(true);
            scroller1.forceFinished(true);
            this.k(scroller0);
            if(this.y0 == 0) {
                return true;
            }
            this.y0 = 0;
            return true;
        }
        if(!scroller1.isFinished()) {
            scroller0.forceFinished(true);
            scroller1.forceFinished(true);
            this.k(scroller1);
            return true;
        }
        float f1 = this.i0;
        if(f1 < ((float)this.w0)) {
            long v = (long)ViewConfiguration.getLongPressTimeout();
            y0 y00 = this.h0;
            if(y00 == null) {
                this.h0 = new y0(this);
            }
            else {
                this.removeCallbacks(y00);
            }
            this.h0.b = false;
            this.postDelayed(this.h0, v);
            return true;
        }
        if(f1 > ((float)this.x0)) {
            long v1 = (long)ViewConfiguration.getLongPressTimeout();
            y0 y01 = this.h0;
            if(y01 == null) {
                this.h0 = new y0(this);
            }
            else {
                this.removeCallbacks(y01);
            }
            this.h0.b = true;
            this.postDelayed(this.h0, v1);
            return true;
        }
        this.A0 = true;
        t t0 = this.M0;
        if(t0 == null) {
            this.M0 = new t(this, 15);
        }
        else {
            this.removeCallbacks(t0);
        }
        this.postDelayed(this.M0, ((long)ViewConfiguration.getLongPressTimeout()));
        return true;
    }

    @Override  // android.widget.LinearLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getMeasuredWidth();
        int v5 = this.getMeasuredHeight();
        int v6 = this.a.getMeasuredWidth();
        int v7 = this.a.getMeasuredHeight();
        int v8 = (v4 - v6) / 2;
        int v9 = (v5 - v7) / 2;
        this.a.layout(v8, v9, v6 + v8, v7 + v9);
        this.a.getX();
        this.a.getMeasuredWidth();
        float f = this.a.getY();
        this.b = ((float)this.a.getMeasuredHeight()) / 2.0f + f - 5.0f;
        if(z) {
            this.h();
            int[] arr_v = this.getSelectorIndices();
            int v10 = (int)(((float)(arr_v.length - 1)) * this.n + this.j);
            this.r = (int)(((float)(this.getBottom() - this.getTop() - v10)) / ((float)arr_v.length));
            int v11 = ((int)this.getMaxTextSize()) + this.r;
            this.W = v11;
            int v12 = (int)(this.b - ((float)v11));
            this.b0 = v12;
            this.c0 = v12;
            this.p();
            this.setHorizontalFadingEdgeEnabled(false);
            this.setVerticalFadingEdgeEnabled(true);
            this.setFadingEdgeLength((this.getBottom() - this.getTop() - ((int)this.n)) / 2);
            int v13 = this.v0 * 2 + this.t0;
            int v14 = (this.getHeight() - this.t0) / 2 - this.v0;
            this.w0 = v14;
            this.x0 = v14 + v13;
        }
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(NumberPicker.i(v, this.f), NumberPicker.i(v1, this.d));
        int v2 = this.getMeasuredWidth();
        int v3 = NumberPicker.m(this.e, v2, v);
        int v4 = this.getMeasuredHeight();
        this.setMeasuredDimension(v3, NumberPicker.m(this.c, v4, v1));
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(!this.isEnabled()) {
            return false;
        }
        if(this.l0 == null) {
            this.l0 = VelocityTracker.obtain();
        }
        this.l0.addMovement(motionEvent0);
        int v = motionEvent0.getActionMasked();
        int v1 = this.m0;
        switch(v) {
            case 1: {
                t t0 = this.M0;
                if(t0 != null) {
                    this.removeCallbacks(t0);
                }
                y0 y00 = this.h0;
                if(y00 != null) {
                    this.removeCallbacks(y00);
                }
                VelocityTracker velocityTracker0 = this.l0;
                velocityTracker0.computeCurrentVelocity(1000, ((float)this.o0));
                int v2 = (int)velocityTracker0.getYVelocity();
                if(Math.abs(v2) <= this.n0 || !this.I) {
                    if(((int)Math.abs(((float)(((int)motionEvent0.getY()))) - this.i0)) > v1 || motionEvent0.getEventTime() - this.j0 >= 100L) {
                        this.c();
                    }
                    else if(this.A0) {
                        this.A0 = false;
                        this.performClick();
                    }
                    if(this.y0 != 0) {
                        this.y0 = 0;
                    }
                }
                else {
                    this.f0 = 0;
                    Scroller scroller0 = this.d0;
                    if(v2 > 0) {
                        scroller0.fling(0, 0, 0, v2, 0, 0, 0, 0x7FFFFFFF);
                    }
                    else {
                        scroller0.fling(0, 0x7FFFFFFF, 0, v2, 0, 0, 0, 0x7FFFFFFF);
                    }
                    this.invalidate();
                    if(this.y0 != 2) {
                        this.y0 = 2;
                    }
                }
                this.l0.recycle();
                this.l0 = null;
                return true;
            }
            case 2: {
                if(!this.z0 && this.I) {
                    float f = motionEvent0.getY();
                    if(this.y0 == 1) {
                        this.scrollBy(0, ((int)(f - this.k0)));
                        this.invalidate();
                    }
                    else if(((int)Math.abs(f - this.i0)) > v1) {
                        this.l();
                        if(this.y0 != 1) {
                            this.y0 = 1;
                        }
                    }
                    this.k0 = f;
                }
                return true;
            }
            default: {
                return true;
            }
        }
    }

    public final void p() {
        String s = this.w == null ? this.d(this.E) : this.w[this.E - this.B];
        if(!TextUtils.isEmpty(s)) {
            EditText editText0 = this.a;
            if(!s.equals(editText0.getText().toString())) {
                editText0.setText(s);
            }
        }
    }

    @Override  // android.view.View
    public final boolean performClick() {
        if(!super.performClick()) {
            InputMethodManager inputMethodManager0 = (InputMethodManager)this.getContext().getSystemService(InputMethodManager.class);
            if(inputMethodManager0 != null) {
                this.a.setVisibility(0);
                this.a.requestFocus();
                inputMethodManager0.showSoftInput(this.a, 0);
            }
        }
        return true;
    }

    @Override  // android.view.View
    public final boolean performLongClick() {
        if(!super.performLongClick()) {
            InputMethodManager inputMethodManager0 = (InputMethodManager)this.getContext().getSystemService(InputMethodManager.class);
            if(inputMethodManager0 != null) {
                this.a.setVisibility(0);
                this.a.requestFocus();
                inputMethodManager0.showSoftInput(this.a, 0);
            }
            this.z0 = true;
        }
        return true;
    }

    public final void q() {
        this.p0 = this.D - this.B >= this.T.length - 1 && this.q0;
    }

    @Override  // android.view.View
    public final void scrollBy(int v, int v1) {
        int v7;
        int[] arr_v = this.getSelectorIndices();
        int v2 = this.c0;
        int v3 = (int)this.getMaxTextSize();
        boolean z = this.p0;
        if(!z && v1 > 0 && arr_v[1] <= this.B) {
            this.c0 = this.b0;
            return;
        }
        if(!z && v1 < 0 && arr_v[1] >= this.D) {
            this.c0 = this.b0;
            return;
        }
        this.c0 += v1;
        while(true) {
            int v4 = this.c0;
            if(v4 - this.b0 <= v3) {
                break;
            }
            this.c0 = v4 - this.W;
            for(int v5 = arr_v.length - 1; v5 > 0; --v5) {
                arr_v[v5] = arr_v[v5 - 1];
            }
            int v6 = arr_v[1] - 1;
            if(this.p0 && v6 < this.B) {
                v6 = this.D;
            }
            arr_v[0] = v6;
            this.b(v6);
            this.n(arr_v[1], true);
            if(!this.p0 && arr_v[1] < this.B) {
                this.c0 = this.b0;
            }
        }
        while(true) {
            v7 = this.c0;
            if(v7 - this.b0 >= -v3) {
                break;
            }
            this.c0 = v7 + this.W;
            for(int v8 = 0; v8 < arr_v.length - 1; ++v8) {
                arr_v[v8] = arr_v[v8 + 1];
            }
            int v9 = arr_v[arr_v.length - 2] + 1;
            if(this.p0 && v9 > this.D) {
                v9 = this.B;
            }
            arr_v[arr_v.length - 1] = v9;
            this.b(v9);
            this.n(arr_v[1], true);
            if(!this.p0 && arr_v[1] > this.D) {
                this.c0 = this.b0;
            }
        }
        if(v2 != v7) {
            this.onScrollChanged(0, v7, 0, v2);
        }
    }

    public void setAccessibilityDescriptionEnabled(boolean z) {
        this.H0 = z;
    }

    public void setDisplayedValues(String[] arr_s) {
        if(this.w == arr_s) {
            return;
        }
        this.w = arr_s;
        EditText editText0 = this.a;
        if(arr_s == null) {
            editText0.setRawInputType(2);
        }
        else {
            editText0.setRawInputType(0xA0000);
        }
        this.p();
        this.h();
        this.o();
    }

    public void setDividerColor(int v) {
        this.s0 = v;
        this.r0 = new ColorDrawable(v);
    }

    public void setDividerColorResource(int v) {
        this.setDividerColor(c.getColor(this.I0, v));
    }

    public void setDividerDistance(int v) {
        this.t0 = v;
    }

    public void setDividerDistanceResource(int v) {
        this.setDividerDistance(this.getResources().getDimensionPixelSize(v));
    }

    public void setDividerHeight(int v) {
        this.v0 = v;
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.a.setEnabled(z);
    }

    public void setFadingEdgeEnabled(boolean z) {
        this.D0 = z;
    }

    public void setFadingEdgeStrength(float f) {
        this.E0 = f;
    }

    public void setFormatter(z0 z00) {
        if(z00 == this.M) {
            return;
        }
        this.M = z00;
        this.h();
        this.p();
    }

    public void setItemHide(boolean z) {
        this.N0 = z;
        this.setScrollable(!z);
        this.a.setVisibility((z ? 0 : 4));
        this.invalidate();
    }

    public void setItemSpacing(int v) {
        this.L0 = v;
    }

    public void setLineSpacingMultiplier(float f) {
        this.F0 = f;
    }

    public void setMaxFlingVelocityCoefficient(int v) {
        this.G0 = v;
        this.o0 = this.K0.getScaledMaximumFlingVelocity() / this.G0;
    }

    public void setMaxValue(int v) {
        if(this.D == v) {
            return;
        }
        if(v < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.D = v;
        if(v < this.E) {
            this.E = v;
        }
        this.q();
        this.h();
        this.p();
        this.o();
        this.invalidate();
    }

    public void setMinValue(int v) {
        if(this.B == v) {
            return;
        }
        if(v < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.B = v;
        if(v > this.E) {
            this.E = v;
        }
        this.q();
        this.h();
        this.p();
        this.o();
        this.invalidate();
    }

    public void setOnLongPressUpdateInterval(long v) {
        this.N = v;
    }

    public void setOnScrollListener(A0 a00) {
    }

    public void setOnValueChangedListener(B0 b00) {
        this.G = b00;
    }

    public void setScrollable(boolean z) {
        this.I = z;
    }

    public void setSelectedTextColor(int v) {
        this.i = v;
        this.a.setTextColor(v);
    }

    public void setSelectedTextColorResource(int v) {
        this.setSelectedTextColor(c.getColor(this.I0, v));
    }

    public void setSelectedTextSize(float f) {
        this.j = f;
        this.a.setTextSize(0, f);
    }

    public void setSelectedTypeface(int v) {
        String s = this.getResources().getString(v);
        if(TextUtils.isEmpty(s)) {
            return;
        }
        this.setSelectedTypeface(Typeface.create(s, 0));
    }

    public void setSelectedTypeface(Typeface typeface0) {
        this.k = typeface0;
        Paint paint0 = this.V;
        if(typeface0 != null) {
            paint0.setTypeface(typeface0);
            return;
        }
        Typeface typeface1 = this.o;
        if(typeface1 != null) {
            paint0.setTypeface(typeface1);
            return;
        }
        paint0.setTypeface(Typeface.MONOSPACE);
    }

    public void setSelectedTypeface(String s) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        this.setSelectedTypeface(Typeface.create(s, 0));
    }

    public void setSelectorFocusable(boolean z) {
        this.a.setEnabled(z);
        this.a.setFocusable(z);
        this.a.setFocusableInTouchMode(z);
    }

    public void setTextColor(int v) {
        this.m = v;
        this.V.setColor(v);
    }

    public void setTextColorResource(int v) {
        this.setTextColor(c.getColor(this.I0, v));
    }

    public void setTextSize(float f) {
        this.n = f;
        this.V.setTextSize(f);
    }

    public void setTypeface(int v) {
        String s = this.getResources().getString(v);
        if(TextUtils.isEmpty(s)) {
            return;
        }
        this.setTypeface(Typeface.create(s, 0));
    }

    public void setTypeface(Typeface typeface0) {
        this.o = typeface0;
        EditText editText0 = this.a;
        if(typeface0 != null) {
            editText0.setTypeface(typeface0);
            this.setSelectedTypeface(this.k);
            return;
        }
        editText0.setTypeface(Typeface.MONOSPACE);
    }

    public void setTypeface(String s) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        this.setTypeface(Typeface.create(s, 0));
    }

    public void setValue(int v) {
        this.n(v, false);
    }

    public void setWrapSelectorWheel(boolean z) {
        this.q0 = z;
        this.q();
    }
}

