package androidx.appcompat.widget;

import D6.f;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import g.a;
import java.lang.reflect.Method;
import k.A;

public class ListPopupWindow implements A {
    public final v0 B;
    public final x0 D;
    public final w0 E;
    public final v0 G;
    public final Handler I;
    public final Rect M;
    public Rect N;
    public boolean S;
    public final PopupWindow T;
    public static final Method V;
    public static final Method W;
    public final Context a;
    public ListAdapter b;
    public o0 c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public final int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public final int m;
    public f n;
    public View o;
    public AdapterView.OnItemClickListener r;
    public AdapterView.OnItemSelectedListener w;

    static {
        Class class0 = PopupWindow.class;
        if(Build.VERSION.SDK_INT <= 28) {
            try {
                ListPopupWindow.V = class0.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            }
            catch(NoSuchMethodException unused_ex) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                ListPopupWindow.W = class0.getDeclaredMethod("setEpicenterBounds", Rect.class);
            }
            catch(NoSuchMethodException unused_ex) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context0) {
        this(context0, null, 0x7F0403C0);  // attr:listPopupWindowStyle
    }

    public ListPopupWindow(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0403C0);  // attr:listPopupWindowStyle
    }

    public ListPopupWindow(Context context0, AttributeSet attributeSet0, int v) {
        this(context0, attributeSet0, v, 0);
    }

    public ListPopupWindow(Context context0, AttributeSet attributeSet0, int v, int v1) {
        this.d = -2;
        this.e = -2;
        this.h = 1002;
        this.l = 0;
        this.m = 0x7FFFFFFF;
        this.B = new v0(this, 1);
        this.D = new x0(this);
        this.E = new w0(this);
        this.G = new v0(this, 0);
        this.M = new Rect();
        this.a = context0;
        this.I = new Handler(context0.getMainLooper());
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.q, v, 0);
        this.f = typedArray0.getDimensionPixelOffset(0, 0);
        int v2 = typedArray0.getDimensionPixelOffset(1, 0);
        this.g = v2;
        if(v2 != 0) {
            this.i = true;
        }
        typedArray0.recycle();
        AppCompatPopupWindow appCompatPopupWindow0 = new AppCompatPopupWindow(context0, attributeSet0, v, 0);  // 初始化器: Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
        appCompatPopupWindow0.a(context0, attributeSet0, v);
        this.T = appCompatPopupWindow0;
        appCompatPopupWindow0.setInputMethodMode(1);
    }

    @Override  // k.A
    public final boolean a() {
        return this.T.isShowing();
    }

    public final int b() {
        return this.f;
    }

    public final void c(int v) {
        this.f = v;
    }

    @Override  // k.A
    public final void dismiss() {
        this.T.dismiss();
        this.T.setContentView(null);
        this.c = null;
        this.I.removeCallbacks(this.B);
    }

    public final Drawable e() {
        return this.T.getBackground();
    }

    public final void h(int v) {
        this.g = v;
        this.i = true;
    }

    public final int k() {
        return this.i ? this.g : 0;
    }

    public void l(ListAdapter listAdapter0) {
        f f0 = this.n;
        if(f0 == null) {
            this.n = new f(this, 1);
        }
        else {
            ListAdapter listAdapter1 = this.b;
            if(listAdapter1 != null) {
                listAdapter1.unregisterDataSetObserver(f0);
            }
        }
        this.b = listAdapter0;
        if(listAdapter0 != null) {
            listAdapter0.registerDataSetObserver(this.n);
        }
        o0 o00 = this.c;
        if(o00 != null) {
            o00.setAdapter(this.b);
        }
    }

    @Override  // k.A
    public final o0 n() {
        return this.c;
    }

    public final void o(Drawable drawable0) {
        this.T.setBackgroundDrawable(drawable0);
    }

    public o0 p(Context context0, boolean z) {
        return new o0(context0, z);
    }

    public final void q(int v) {
        Drawable drawable0 = this.T.getBackground();
        if(drawable0 != null) {
            drawable0.getPadding(this.M);
            this.e = this.M.left + this.M.right + v;
            return;
        }
        this.e = v;
    }

    @Override  // k.A
    public final void show() {
        int v10;
        int v7;
        int v5;
        int v2;
        Context context0 = this.a;
        PopupWindow popupWindow0 = this.T;
        if(this.c == null) {
            o0 o00 = this.p(context0, !this.S);
            this.c = o00;
            o00.setAdapter(this.b);
            this.c.setOnItemClickListener(this.r);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new s0(this, 0));
            this.c.setOnScrollListener(this.E);
            AdapterView.OnItemSelectedListener adapterView$OnItemSelectedListener0 = this.w;
            if(adapterView$OnItemSelectedListener0 != null) {
                this.c.setOnItemSelectedListener(adapterView$OnItemSelectedListener0);
            }
            popupWindow0.setContentView(this.c);
        }
        else {
            ViewGroup viewGroup0 = (ViewGroup)popupWindow0.getContentView();
        }
        Drawable drawable0 = popupWindow0.getBackground();
        Rect rect0 = this.M;
        int v = 0;
        if(drawable0 == null) {
            rect0.setEmpty();
            v2 = 0;
        }
        else {
            drawable0.getPadding(rect0);
            int v1 = rect0.top;
            v2 = rect0.bottom + v1;
            if(!this.i) {
                this.g = -v1;
            }
        }
        boolean z = popupWindow0.getInputMethodMode() == 2;
        int v3 = t0.a(popupWindow0, this.o, this.g, z);
        int v4 = this.d;
        if(v4 == -1) {
            v5 = v3 + v2;
        }
        else {
            int v6 = this.e;
            switch(v6) {
                case -2: {
                    v7 = View.MeasureSpec.makeMeasureSpec(context0.getResources().getDisplayMetrics().widthPixels - (rect0.left + rect0.right), 0x80000000);
                    break;
                }
                case -1: {
                    v7 = View.MeasureSpec.makeMeasureSpec(context0.getResources().getDisplayMetrics().widthPixels - (rect0.left + rect0.right), 0x40000000);
                    break;
                }
                default: {
                    v7 = View.MeasureSpec.makeMeasureSpec(v6, 0x40000000);
                }
            }
            int v8 = this.c.a(v7, v3);
            if(v8 > 0) {
                int v9 = this.c.getPaddingTop();
                v10 = this.c.getPaddingBottom() + v9 + v2;
            }
            else {
                v10 = 0;
            }
            v5 = v8 + v10;
        }
        boolean z1 = this.T.getInputMethodMode() == 2;
        popupWindow0.setWindowLayoutType(this.h);
        if(!popupWindow0.isShowing()) {
            int v14 = this.e;
            if(v14 == -1) {
                v14 = -1;
            }
            else if(v14 == -2) {
                v14 = this.o.getWidth();
            }
            if(v4 == -1) {
                v4 = -1;
            }
            else if(v4 == -2) {
                v4 = v5;
            }
            popupWindow0.setWidth(v14);
            popupWindow0.setHeight(v4);
            if(Build.VERSION.SDK_INT <= 28) {
                Method method0 = ListPopupWindow.V;
                if(method0 != null) {
                    try {
                        method0.invoke(popupWindow0, Boolean.TRUE);
                    }
                    catch(Exception unused_ex) {
                        Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    }
                }
            }
            else {
                u0.b(popupWindow0, true);
            }
            popupWindow0.setOutsideTouchable(true);
            popupWindow0.setTouchInterceptor(this.D);
            if(this.k) {
                popupWindow0.setOverlapAnchor(this.j);
            }
            if(Build.VERSION.SDK_INT <= 28) {
                Method method1 = ListPopupWindow.W;
                if(method1 != null) {
                    try {
                        method1.invoke(popupWindow0, this.N);
                    }
                    catch(Exception exception0) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", exception0);
                    }
                }
            }
            else {
                u0.a(popupWindow0, this.N);
            }
            popupWindow0.showAsDropDown(this.o, this.f, this.g, this.l);
            this.c.setSelection(-1);
            if(!this.S || this.c.isInTouchMode()) {
                o0 o01 = this.c;
                if(o01 != null) {
                    o01.setListSelectionHidden(true);
                    o01.requestLayout();
                }
            }
            if(!this.S) {
                this.I.post(this.G);
            }
        }
        else if(this.o.isAttachedToWindow()) {
            int v11 = this.e;
            if(v11 == -1) {
                v11 = -1;
            }
            else if(v11 == -2) {
                v11 = this.o.getWidth();
            }
            if(v4 == -1) {
                v4 = z1 ? v5 : -1;
                if(z1) {
                    popupWindow0.setWidth((this.e == -1 ? -1 : 0));
                    popupWindow0.setHeight(0);
                }
                else {
                    if(this.e == -1) {
                        v = -1;
                    }
                    popupWindow0.setWidth(v);
                    popupWindow0.setHeight(-1);
                }
            }
            else if(v4 == -2) {
                v4 = v5;
            }
            popupWindow0.setOutsideTouchable(true);
            View view0 = this.o;
            int v12 = this.f;
            int v13 = this.g;
            if(v4 < 0) {
                v4 = -1;
            }
            popupWindow0.update(view0, v12, v13, (v11 >= 0 ? v11 : -1), v4);
        }
    }
}

