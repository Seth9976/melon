package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.q;
import e0.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public final class n extends c {
    public float e;
    public int f;
    public int g;
    public int h;
    public RectF i;
    public RectF j;
    public HashMap k;
    public String l;
    public int m;
    public String n;
    public String o;
    public int p;
    public int q;
    public View r;
    public boolean s;
    public boolean t;
    public boolean u;
    public float v;
    public float w;
    public boolean x;

    public n() {
        this.e = 0.1f;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = new RectF();
        this.j = new RectF();
        this.k = new HashMap();
        this.l = null;
        this.m = -1;
        this.n = null;
        this.o = null;
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = true;
        this.t = true;
        this.u = true;
        this.v = NaNf;
        this.x = false;
        this.d = new HashMap();
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void a(HashMap hashMap0) {
        throw null;
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final c b() {
        c c0 = new n();
        c0.super.c(this);
        c0.l = this.l;
        c0.m = this.m;
        c0.n = this.n;
        c0.o = this.o;
        c0.p = this.p;
        c0.q = this.q;
        c0.r = this.r;
        c0.e = this.e;
        c0.s = this.s;
        c0.t = this.t;
        c0.u = this.u;
        c0.v = this.v;
        c0.w = this.w;
        c0.x = this.x;
        c0.i = this.i;
        c0.j = this.j;
        c0.k = this.k;
        return c0;
    }

    @Override
    public final Object clone() {
        return this.b();
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void d(HashSet hashSet0) {
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void e(Context context0, AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.o);
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            SparseIntArray sparseIntArray0 = m.a;
            switch(sparseIntArray0.get(v2)) {
                case 1: {
                    this.n = typedArray0.getString(v2);
                    break;
                }
                case 2: {
                    this.o = typedArray0.getString(v2);
                    break;
                }
                case 4: {
                    this.l = typedArray0.getString(v2);
                    break;
                }
                case 5: {
                    this.e = typedArray0.getFloat(v2, this.e);
                    break;
                }
                case 6: {
                    this.p = typedArray0.getResourceId(v2, this.p);
                    break;
                }
                case 7: {
                    if(MotionLayout.IS_IN_EDIT_MODE) {
                        int v3 = typedArray0.getResourceId(v2, this.b);
                        this.b = v3;
                        if(v3 == -1) {
                            this.c = typedArray0.getString(v2);
                        }
                    }
                    else if(typedArray0.peekValue(v2).type == 3) {
                        this.c = typedArray0.getString(v2);
                    }
                    else {
                        this.b = typedArray0.getResourceId(v2, this.b);
                    }
                    break;
                }
                case 8: {
                    int v4 = typedArray0.getInteger(v2, this.a);
                    this.a = v4;
                    this.v = (((float)v4) + 0.5f) / 100.0f;
                    break;
                }
                case 9: {
                    this.q = typedArray0.getResourceId(v2, this.q);
                    break;
                }
                case 10: {
                    this.x = typedArray0.getBoolean(v2, this.x);
                    break;
                }
                case 11: {
                    this.m = typedArray0.getResourceId(v2, this.m);
                    break;
                }
                case 12: {
                    this.h = typedArray0.getResourceId(v2, this.h);
                    break;
                }
                case 13: {
                    this.f = typedArray0.getResourceId(v2, this.f);
                    break;
                }
                case 14: {
                    this.g = typedArray0.getResourceId(v2, this.g);
                    break;
                }
                default: {
                    Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                }
            }
        }
    }

    public final void h(View view0, float f) {
        int v1;
        boolean z2;
        boolean z1;
        int v2;
        boolean z = true;
        int v = 0;
        if(this.q == -1) {
            if(!this.s) {
                if(Math.abs(f - this.v) > this.e) {
                    this.s = true;
                }
                z1 = false;
            }
            else if((this.w - this.v) * (f - this.v) < 0.0f) {
                this.s = false;
                z1 = true;
            }
            else {
                z1 = false;
            }
            if(this.t) {
                float f1 = f - this.v;
                if((this.w - this.v) * f1 >= 0.0f || f1 >= 0.0f) {
                    v2 = 0;
                }
                else {
                    this.t = false;
                    v2 = 1;
                }
            }
            else {
                if(Math.abs(f - this.v) > this.e) {
                    this.t = true;
                }
                v2 = 0;
            }
            if(this.u) {
                float f2 = f - this.v;
                if((this.w - this.v) * f2 >= 0.0f || f2 <= 0.0f) {
                    z = false;
                }
                else {
                    this.u = false;
                }
            }
            else {
                if(Math.abs(f - this.v) > this.e) {
                    this.u = true;
                }
                z = false;
            }
            v = v2;
        }
        else {
            if(this.r == null) {
                this.r = ((ViewGroup)view0.getParent()).findViewById(this.q);
            }
            n.j(this.i, this.r, this.x);
            n.j(this.j, view0, this.x);
            if(this.i.intersect(this.j)) {
                if(this.s) {
                    this.s = false;
                    z1 = true;
                }
                else {
                    z1 = false;
                }
                if(this.u) {
                    this.u = false;
                    z2 = true;
                }
                else {
                    z2 = false;
                }
                this.t = true;
            }
            else {
                if(this.s) {
                    z1 = false;
                }
                else {
                    this.s = true;
                    z1 = true;
                }
                if(this.t) {
                    this.t = false;
                    v1 = 1;
                }
                else {
                    v1 = 0;
                }
                this.u = true;
                z2 = false;
                v = v1;
            }
            z = z2;
        }
        this.w = f;
        if(v != 0 || z1 || z) {
            ((MotionLayout)view0.getParent()).fireTrigger(this.p, z, f);
        }
        View view1 = this.m == -1 ? view0 : ((MotionLayout)view0.getParent()).findViewById(this.m);
        if(v != 0) {
            String s = this.n;
            if(s != null) {
                this.i(view1, s);
            }
            if(this.f != -1) {
                ((MotionLayout)view0.getParent()).viewTransition(this.f, new View[]{view1});
            }
        }
        if(z) {
            String s1 = this.o;
            if(s1 != null) {
                this.i(view1, s1);
            }
            if(this.g != -1) {
                ((MotionLayout)view0.getParent()).viewTransition(this.g, new View[]{view1});
            }
        }
        if(z1) {
            String s2 = this.l;
            if(s2 != null) {
                this.i(view1, s2);
            }
            if(this.h != -1) {
                ((MotionLayout)view0.getParent()).viewTransition(this.h, new View[]{view1});
            }
        }
    }

    public final void i(View view0, String s) {
        Method method1;
        if(s != null) {
            if(s.startsWith(".")) {
                boolean z = s.length() == 1;
                if(!z) {
                    s = s.substring(1).toLowerCase(Locale.ROOT);
                }
                for(Object object0: this.d.keySet()) {
                    String s1 = (String)object0;
                    if(z || s1.toLowerCase(Locale.ROOT).matches(s)) {
                        a a0 = (a)this.d.get(s1);
                        if(a0 != null) {
                            Class class0 = view0.getClass();
                            String s2 = a0.b;
                            String s3 = a0.a ? s2 : "set" + s2;
                            try {
                                int v = b.b(a0.c);
                                Class class1 = Integer.TYPE;
                                Class class2 = Float.TYPE;
                                switch(v) {
                                    case 1: {
                                        class0.getMethod(s3, class2).invoke(view0, a0.e);
                                        continue;
                                    }
                                    case 2: {
                                        class0.getMethod(s3, class1).invoke(view0, a0.h);
                                        continue;
                                    }
                                    case 3: {
                                        Method method0 = class0.getMethod(s3, Drawable.class);
                                        ColorDrawable colorDrawable0 = new ColorDrawable();
                                        colorDrawable0.setColor(a0.h);
                                        method0.invoke(view0, colorDrawable0);
                                        continue;
                                    }
                                    case 4: {
                                        class0.getMethod(s3, CharSequence.class).invoke(view0, a0.f);
                                        continue;
                                    }
                                    case 5: {
                                        class0.getMethod(s3, Boolean.TYPE).invoke(view0, Boolean.valueOf(a0.g));
                                        continue;
                                    }
                                    case 6: {
                                        class0.getMethod(s3, class2).invoke(view0, a0.e);
                                        continue;
                                    }
                                    case 0: 
                                    case 7: {
                                        class0.getMethod(s3, class1).invoke(view0, a0.d);
                                        continue;
                                    }
                                    default: {
                                        continue;
                                    }
                                }
                            }
                            catch(NoSuchMethodException noSuchMethodException0) {
                            }
                            catch(IllegalAccessException illegalAccessException0) {
                                goto label_44;
                            }
                            catch(InvocationTargetException invocationTargetException0) {
                                goto label_49;
                            }
                            Log.e("TransitionLayout", class0.getName() + " must have a method " + s3, noSuchMethodException0);
                            continue;
                        label_44:
                            StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n(" Custom Attribute \"", s2, "\" not found on ");
                            stringBuilder0.append(class0.getName());
                            Log.e("TransitionLayout", stringBuilder0.toString(), illegalAccessException0);
                            continue;
                        label_49:
                            StringBuilder stringBuilder1 = com.iloen.melon.utils.a.n(" Custom Attribute \"", s2, "\" not found on ");
                            stringBuilder1.append(class0.getName());
                            Log.e("TransitionLayout", stringBuilder1.toString(), invocationTargetException0);
                        }
                    }
                }
                return;
            }
            if(this.k.containsKey(s)) {
                method1 = (Method)this.k.get(s);
                if(method1 == null) {
                    return;
                }
            }
            else {
                method1 = null;
            }
            if(method1 == null) {
                try {
                    method1 = view0.getClass().getMethod(s, null);
                    this.k.put(s, method1);
                }
                catch(NoSuchMethodException unused_ex) {
                    this.k.put(s, null);
                    Log.e("KeyTrigger", "Could not find method \"" + s + "\"on class " + view0.getClass().getSimpleName() + " " + ye.a.G(view0));
                    return;
                }
            }
            try {
                method1.invoke(view0, null);
            }
            catch(Exception unused_ex) {
                Log.e("KeyTrigger", "Exception in call \"" + this.l + "\"on class " + view0.getClass().getSimpleName() + " " + ye.a.G(view0));
            }
        }
    }

    public static void j(RectF rectF0, View view0, boolean z) {
        rectF0.top = (float)view0.getTop();
        rectF0.bottom = (float)view0.getBottom();
        rectF0.left = (float)view0.getLeft();
        rectF0.right = (float)view0.getRight();
        if(z) {
            view0.getMatrix().mapRect(rectF0);
        }
    }
}

