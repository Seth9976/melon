package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.view.ContextThemeWrapper;
import d5.m;
import d5.w;
import g.a;

public class AppCompatSpinner extends Spinner {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean a;

        static {
            SavedState.CREATOR = new L();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeByte(((byte)this.a));
        }
    }

    public final v a;
    public final Context b;
    public final E c;
    public SpinnerAdapter d;
    public final boolean e;
    public final M f;
    public int g;
    public final Rect h;
    public static final int[] i;

    static {
        AppCompatSpinner.i = new int[]{0x10102F1};
    }

    public AppCompatSpinner(Context context0) {
        this(context0, null);
    }

    public AppCompatSpinner(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04057C);  // attr:spinnerStyle
    }

    public AppCompatSpinner(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        TypedArray typedArray2;
        TypedArray typedArray1;
        int v2;
        this.h = new Rect();
        a1.a(this.getContext(), this);
        int[] arr_v = a.x;
        m m0 = m.r(context0, attributeSet0, arr_v, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.a = new v(this);
        int v1 = typedArray0.getResourceId(4, 0);
        this.b = v1 == 0 ? context0 : new ContextThemeWrapper(context0, v1);
        try {
            v2 = -1;
            typedArray1 = null;
            typedArray2 = null;
            typedArray2 = context0.obtainStyledAttributes(attributeSet0, AppCompatSpinner.i, v, 0);
            goto label_19;
        }
        catch(Exception exception0) {
            goto label_23;
        }
        catch(Throwable throwable0) {
        }
        goto label_28;
        try {
            try {
            label_19:
                if(typedArray2.hasValue(0)) {
                    v2 = typedArray2.getInt(0, 0);
                    goto label_31;
                }
                else {
                    goto label_33;
                }
            }
            catch(Exception exception0) {
            label_23:
                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", exception0);
                if(typedArray2 != null) {
                    goto label_31;
                }
            }
            goto label_34;
        }
        catch(Throwable throwable0) {
            typedArray1 = typedArray2;
        }
    label_28:
        if(typedArray1 != null) {
            typedArray1.recycle();
        }
        throw throwable0;
    label_31:
        typedArray2.recycle();
        goto label_34;
    label_33:
        typedArray2.recycle();
    label_34:
        switch(v2) {
            case 0: {
                G g0 = new G(this);
                this.f = g0;
                g0.c = typedArray0.getString(2);
                break;
            }
            case 1: {
                K k0 = new K(this, this.b, attributeSet0, v);
                m m1 = m.r(this.b, attributeSet0, arr_v, v);
                this.g = ((TypedArray)m1.c).getLayoutDimension(3, -2);
                k0.o(m1.k(1));
                k0.X = typedArray0.getString(2);
                m1.t();
                this.f = k0;
                this.c = new E(this, this, k0);
            }
        }
        CharSequence[] arr_charSequence = typedArray0.getTextArray(0);
        if(arr_charSequence != null) {
            ArrayAdapter arrayAdapter0 = new ArrayAdapter(context0, 0x1090008, arr_charSequence);
            arrayAdapter0.setDropDownViewResource(0x7F0D0868);  // layout:support_simple_spinner_dropdown_item
            this.setAdapter(arrayAdapter0);
        }
        m0.t();
        this.e = true;
        SpinnerAdapter spinnerAdapter0 = this.d;
        if(spinnerAdapter0 != null) {
            this.setAdapter(spinnerAdapter0);
            this.d = null;
        }
        this.a.d(attributeSet0, v);
    }

    public final int a(SpinnerAdapter spinnerAdapter0, Drawable drawable0) {
        int v = 0;
        if(spinnerAdapter0 == null) {
            return 0;
        }
        int v1 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
        int v2 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
        int v3 = Math.max(0, this.getSelectedItemPosition());
        int v4 = Math.min(spinnerAdapter0.getCount(), v3 + 15);
        int v5 = Math.max(0, v4 - 15);
        View view0 = null;
        int v6 = 0;
        while(v5 < v4) {
            int v7 = spinnerAdapter0.getItemViewType(v5);
            if(v7 != v) {
                view0 = null;
                v = v7;
            }
            view0 = spinnerAdapter0.getView(v5, view0, this);
            if(view0.getLayoutParams() == null) {
                view0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view0.measure(v1, v2);
            v6 = Math.max(v6, view0.getMeasuredWidth());
            ++v5;
        }
        if(drawable0 != null) {
            drawable0.getPadding(this.h);
            return this.h.left + this.h.right + v6;
        }
        return v6;
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        v v0 = this.a;
        if(v0 != null) {
            v0.a();
        }
    }

    @Override  // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        return this.f == null ? super.getDropDownHorizontalOffset() : this.f.b();
    }

    @Override  // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        return this.f == null ? super.getDropDownVerticalOffset() : this.f.k();
    }

    @Override  // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f == null ? super.getDropDownWidth() : this.g;
    }

    public final M getInternalPopup() {
        return this.f;
    }

    @Override  // android.widget.Spinner
    public Drawable getPopupBackground() {
        return this.f == null ? super.getPopupBackground() : this.f.e();
    }

    @Override  // android.widget.Spinner
    public Context getPopupContext() {
        return this.b;
    }

    @Override  // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.f == null ? super.getPrompt() : this.f.d();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.a == null ? null : this.a.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.a == null ? null : this.a.c();
    }

    @Override  // android.widget.Spinner
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        M m0 = this.f;
        if(m0 != null && m0.a()) {
            m0.dismiss();
        }
    }

    @Override  // android.widget.Spinner
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.f != null && View.MeasureSpec.getMode(v) == 0x80000000) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.a(this.getAdapter(), this.getBackground())), View.MeasureSpec.getSize(v)), this.getMeasuredHeight());
        }
    }

    @Override  // android.widget.Spinner
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        if(((SavedState)parcelable0).a) {
            ViewTreeObserver viewTreeObserver0 = this.getViewTreeObserver();
            if(viewTreeObserver0 != null) {
                viewTreeObserver0.addOnGlobalLayoutListener(new r(this, 1));
            }
        }
    }

    @Override  // android.widget.Spinner
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.f != null && this.f.a();
        return parcelable0;
    }

    @Override  // android.widget.Spinner
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        return this.c == null || !this.c.onTouch(this, motionEvent0) ? super.onTouchEvent(motionEvent0) : true;
    }

    @Override  // android.widget.Spinner
    public final boolean performClick() {
        M m0 = this.f;
        if(m0 != null) {
            if(!m0.a()) {
                int v = this.getTextDirection();
                int v1 = this.getTextAlignment();
                this.f.j(v, v1);
            }
            return true;
        }
        return super.performClick();
    }

    @Override  // android.widget.Spinner
    public void setAdapter(Adapter adapter0) {
        this.setAdapter(((SpinnerAdapter)adapter0));
    }

    @Override  // android.widget.Spinner
    public void setAdapter(SpinnerAdapter spinnerAdapter0) {
        if(!this.e) {
            this.d = spinnerAdapter0;
            return;
        }
        super.setAdapter(spinnerAdapter0);
        M m0 = this.f;
        if(m0 != null) {
            Resources.Theme resources$Theme0 = (this.b == null ? this.getContext() : this.b).getTheme();
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            h0.a = spinnerAdapter0;
            if(spinnerAdapter0 instanceof ListAdapter) {
                h0.b = (ListAdapter)spinnerAdapter0;
            }
            if(resources$Theme0 != null && spinnerAdapter0 instanceof ThemedSpinnerAdapter) {
                F.a(((ThemedSpinnerAdapter)spinnerAdapter0), resources$Theme0);
            }
            m0.l(h0);
        }
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        v v0 = this.a;
        if(v0 != null) {
            v0.e();
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        v v1 = this.a;
        if(v1 != null) {
            v1.f(v);
        }
    }

    @Override  // android.widget.Spinner
    public void setDropDownHorizontalOffset(int v) {
        M m0 = this.f;
        if(m0 != null) {
            m0.i(v);
            m0.c(v);
            return;
        }
        super.setDropDownHorizontalOffset(v);
    }

    @Override  // android.widget.Spinner
    public void setDropDownVerticalOffset(int v) {
        M m0 = this.f;
        if(m0 != null) {
            m0.h(v);
            return;
        }
        super.setDropDownVerticalOffset(v);
    }

    @Override  // android.widget.Spinner
    public void setDropDownWidth(int v) {
        if(this.f != null) {
            this.g = v;
            return;
        }
        super.setDropDownWidth(v);
    }

    @Override  // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable0) {
        M m0 = this.f;
        if(m0 != null) {
            m0.o(drawable0);
            return;
        }
        super.setPopupBackgroundDrawable(drawable0);
    }

    @Override  // android.widget.Spinner
    public void setPopupBackgroundResource(int v) {
        this.setPopupBackgroundDrawable(w.B(this.getPopupContext(), v));
    }

    @Override  // android.widget.Spinner
    public void setPrompt(CharSequence charSequence0) {
        M m0 = this.f;
        if(m0 != null) {
            m0.g(charSequence0);
            return;
        }
        super.setPrompt(charSequence0);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        v v0 = this.a;
        if(v0 != null) {
            v0.h(colorStateList0);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        v v0 = this.a;
        if(v0 != null) {
            v0.i(porterDuff$Mode0);
        }
    }
}

