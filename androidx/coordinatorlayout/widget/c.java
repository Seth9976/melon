package androidx.coordinatorlayout.widget;

import K1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public final class c extends ViewGroup.MarginLayoutParams {
    public Behavior a;
    public boolean b;
    public final int c;
    public int d;
    public final int e;
    public final int f;
    public final int g;
    public int h;
    public int i;
    public int j;
    public View k;
    public View l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final Rect p;

    public c() {
        super(-2, -2);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }

    public c(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        Behavior coordinatorLayout$Behavior0;
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.b);
        this.c = typedArray0.getInteger(0, 0);
        this.f = typedArray0.getResourceId(1, -1);
        this.d = typedArray0.getInteger(2, 0);
        this.e = typedArray0.getInteger(6, -1);
        this.g = typedArray0.getInt(5, 0);
        this.h = typedArray0.getInt(4, 0);
        boolean z = typedArray0.hasValue(3);
        this.b = z;
        if(z) {
            String s = typedArray0.getString(3);
            if(TextUtils.isEmpty(s)) {
                coordinatorLayout$Behavior0 = null;
            }
            else {
                if(s.startsWith(".")) {
                    s = "com.iloen.melon" + s;
                }
                else if(s.indexOf(46) < 0) {
                    String s1 = CoordinatorLayout.E;
                    if(!TextUtils.isEmpty(s1)) {
                        s = s1 + '.' + s;
                    }
                }
                try {
                    ThreadLocal threadLocal0 = CoordinatorLayout.I;
                    Map map0 = (Map)threadLocal0.get();
                    if(map0 == null) {
                        map0 = new HashMap();
                        threadLocal0.set(map0);
                    }
                    Constructor constructor0 = (Constructor)map0.get(s);
                    if(constructor0 == null) {
                        constructor0 = Class.forName(s, false, context0.getClassLoader()).getConstructor(CoordinatorLayout.G);
                        constructor0.setAccessible(true);
                        map0.put(s, constructor0);
                    }
                    coordinatorLayout$Behavior0 = (Behavior)constructor0.newInstance(context0, attributeSet0);
                    goto label_44;
                }
                catch(Exception exception0) {
                }
                throw new RuntimeException("Could not inflate Behavior subclass " + s, exception0);
            }
        label_44:
            this.a = coordinatorLayout$Behavior0;
        }
        typedArray0.recycle();
        Behavior coordinatorLayout$Behavior1 = this.a;
        if(coordinatorLayout$Behavior1 != null) {
            coordinatorLayout$Behavior1.g(this);
        }
    }

    public c(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super(viewGroup$LayoutParams0);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }

    public c(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
        super(viewGroup$MarginLayoutParams0);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }

    public c(c c0) {
        super(c0);
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.p = new Rect();
    }

    public final boolean a(int v) {
        switch(v) {
            case 0: {
                return this.m;
            }
            case 1: {
                return this.n;
            }
            default: {
                return false;
            }
        }
    }
}

