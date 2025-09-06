package androidx.constraintlayout.widget;

import A1.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

public final class n {
    public String a;
    public String b;
    public String[] c;
    public int d;
    public final HashMap e;
    public boolean f;
    public final HashMap g;
    public static final int[] h;
    public static final SparseIntArray i;
    public static final SparseIntArray j;

    static {
        n.h = new int[]{0, 4, 8};
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        n.i = sparseIntArray0;
        SparseIntArray sparseIntArray1 = new SparseIntArray();
        n.j = sparseIntArray1;
        sparseIntArray0.append(82, 25);
        sparseIntArray0.append(83, 26);
        sparseIntArray0.append(85, 29);
        sparseIntArray0.append(86, 30);
        sparseIntArray0.append(92, 36);
        sparseIntArray0.append(91, 35);
        sparseIntArray0.append(0x3F, 4);
        sparseIntArray0.append(62, 3);
        sparseIntArray0.append(58, 1);
        sparseIntArray0.append(60, 91);
        sparseIntArray0.append(59, 92);
        sparseIntArray0.append(101, 6);
        sparseIntArray0.append(102, 7);
        sparseIntArray0.append(70, 17);
        sparseIntArray0.append(71, 18);
        sparseIntArray0.append(72, 19);
        sparseIntArray0.append(54, 99);
        sparseIntArray0.append(0, 27);
        sparseIntArray0.append(87, 0x20);
        sparseIntArray0.append(88, 33);
        sparseIntArray0.append(69, 10);
        sparseIntArray0.append(68, 9);
        sparseIntArray0.append(106, 13);
        sparseIntArray0.append(109, 16);
        sparseIntArray0.append(107, 14);
        sparseIntArray0.append(104, 11);
        sparseIntArray0.append(108, 15);
        sparseIntArray0.append(105, 12);
        sparseIntArray0.append(0x5F, 40);
        sparseIntArray0.append(80, 39);
        sparseIntArray0.append(0x4F, 41);
        sparseIntArray0.append(94, 42);
        sparseIntArray0.append(78, 20);
        sparseIntArray0.append(93, 37);
        sparseIntArray0.append(67, 5);
        sparseIntArray0.append(81, 87);
        sparseIntArray0.append(90, 87);
        sparseIntArray0.append(84, 87);
        sparseIntArray0.append(61, 87);
        sparseIntArray0.append(57, 87);
        sparseIntArray0.append(5, 24);
        sparseIntArray0.append(7, 28);
        sparseIntArray0.append(23, 0x1F);
        sparseIntArray0.append(24, 8);
        sparseIntArray0.append(6, 34);
        sparseIntArray0.append(8, 2);
        sparseIntArray0.append(3, 23);
        sparseIntArray0.append(4, 21);
        sparseIntArray0.append(0x60, 0x5F);
        sparseIntArray0.append(73, 0x60);
        sparseIntArray0.append(2, 22);
        sparseIntArray0.append(13, 43);
        sparseIntArray0.append(26, 44);
        sparseIntArray0.append(21, 45);
        sparseIntArray0.append(22, 46);
        sparseIntArray0.append(20, 60);
        sparseIntArray0.append(18, 0x2F);
        sparseIntArray0.append(19, 0x30);
        sparseIntArray0.append(14, 49);
        sparseIntArray0.append(15, 50);
        sparseIntArray0.append(16, 51);
        sparseIntArray0.append(17, 52);
        sparseIntArray0.append(25, 53);
        sparseIntArray0.append(97, 54);
        sparseIntArray0.append(74, 55);
        sparseIntArray0.append(98, 56);
        sparseIntArray0.append(75, 57);
        sparseIntArray0.append(99, 58);
        sparseIntArray0.append(76, 59);
        sparseIntArray0.append(0x40, 61);
        sparseIntArray0.append(66, 62);
        sparseIntArray0.append(65, 0x3F);
        sparseIntArray0.append(28, 0x40);
        sparseIntArray0.append(0x79, 65);
        sparseIntArray0.append(35, 66);
        sparseIntArray0.append(0x7A, 67);
        sparseIntArray0.append(0x71, 0x4F);
        sparseIntArray0.append(1, 38);
        sparseIntArray0.append(0x70, 68);
        sparseIntArray0.append(100, 69);
        sparseIntArray0.append(77, 70);
        sparseIntArray0.append(0x6F, 97);
        sparseIntArray0.append(0x20, 71);
        sparseIntArray0.append(30, 72);
        sparseIntArray0.append(0x1F, 73);
        sparseIntArray0.append(33, 74);
        sparseIntArray0.append(29, 75);
        sparseIntArray0.append(0x72, 76);
        sparseIntArray0.append(89, 77);
        sparseIntArray0.append(0x7B, 78);
        sparseIntArray0.append(56, 80);
        sparseIntArray0.append(55, 81);
        sparseIntArray0.append(0x74, 82);
        sparseIntArray0.append(120, 83);
        sparseIntArray0.append(0x77, 84);
        sparseIntArray0.append(0x76, 85);
        sparseIntArray0.append(0x75, 86);
        sparseIntArray1.append(85, 6);
        sparseIntArray1.append(85, 7);
        sparseIntArray1.append(0, 27);
        sparseIntArray1.append(89, 13);
        sparseIntArray1.append(92, 16);
        sparseIntArray1.append(90, 14);
        sparseIntArray1.append(87, 11);
        sparseIntArray1.append(91, 15);
        sparseIntArray1.append(88, 12);
        sparseIntArray1.append(78, 40);
        sparseIntArray1.append(71, 39);
        sparseIntArray1.append(70, 41);
        sparseIntArray1.append(77, 42);
        sparseIntArray1.append(69, 20);
        sparseIntArray1.append(76, 37);
        sparseIntArray1.append(60, 5);
        sparseIntArray1.append(72, 87);
        sparseIntArray1.append(75, 87);
        sparseIntArray1.append(73, 87);
        sparseIntArray1.append(57, 87);
        sparseIntArray1.append(56, 87);
        sparseIntArray1.append(5, 24);
        sparseIntArray1.append(7, 28);
        sparseIntArray1.append(23, 0x1F);
        sparseIntArray1.append(24, 8);
        sparseIntArray1.append(6, 34);
        sparseIntArray1.append(8, 2);
        sparseIntArray1.append(3, 23);
        sparseIntArray1.append(4, 21);
        sparseIntArray1.append(0x4F, 0x5F);
        sparseIntArray1.append(0x40, 0x60);
        sparseIntArray1.append(2, 22);
        sparseIntArray1.append(13, 43);
        sparseIntArray1.append(26, 44);
        sparseIntArray1.append(21, 45);
        sparseIntArray1.append(22, 46);
        sparseIntArray1.append(20, 60);
        sparseIntArray1.append(18, 0x2F);
        sparseIntArray1.append(19, 0x30);
        sparseIntArray1.append(14, 49);
        sparseIntArray1.append(15, 50);
        sparseIntArray1.append(16, 51);
        sparseIntArray1.append(17, 52);
        sparseIntArray1.append(25, 53);
        sparseIntArray1.append(80, 54);
        sparseIntArray1.append(65, 55);
        sparseIntArray1.append(81, 56);
        sparseIntArray1.append(66, 57);
        sparseIntArray1.append(82, 58);
        sparseIntArray1.append(67, 59);
        sparseIntArray1.append(59, 62);
        sparseIntArray1.append(58, 0x3F);
        sparseIntArray1.append(28, 0x40);
        sparseIntArray1.append(105, 65);
        sparseIntArray1.append(34, 66);
        sparseIntArray1.append(106, 67);
        sparseIntArray1.append(0x60, 0x4F);
        sparseIntArray1.append(1, 38);
        sparseIntArray1.append(97, 98);
        sparseIntArray1.append(0x5F, 68);
        sparseIntArray1.append(83, 69);
        sparseIntArray1.append(68, 70);
        sparseIntArray1.append(0x20, 71);
        sparseIntArray1.append(30, 72);
        sparseIntArray1.append(0x1F, 73);
        sparseIntArray1.append(33, 74);
        sparseIntArray1.append(29, 75);
        sparseIntArray1.append(98, 76);
        sparseIntArray1.append(74, 77);
        sparseIntArray1.append(107, 78);
        sparseIntArray1.append(55, 80);
        sparseIntArray1.append(54, 81);
        sparseIntArray1.append(100, 82);
        sparseIntArray1.append(104, 83);
        sparseIntArray1.append(103, 84);
        sparseIntArray1.append(102, 85);
        sparseIntArray1.append(101, 86);
        sparseIntArray1.append(94, 97);
    }

    public n() {
        this.b = "";
        this.c = new String[0];
        this.d = 0;
        this.e = new HashMap();
        this.f = true;
        this.g = new HashMap();
    }

    public final void a(MotionLayout motionLayout0) {
        int v = motionLayout0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = motionLayout0.getChildAt(v1);
            int v2 = view0.getId();
            HashMap hashMap0 = this.g;
            if(hashMap0.containsKey(v2)) {
                if(this.f && v2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if(hashMap0.containsKey(v2)) {
                    i i0 = (i)hashMap0.get(v2);
                    if(i0 != null) {
                        a.e(view0, i0.g);
                    }
                }
            }
            else {
                Log.w("ConstraintSet", "id unknown " + ye.a.G(view0));
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout0) {
        this.c(constraintLayout0);
        constraintLayout0.setConstraintSet(null);
        constraintLayout0.requestLayout();
    }

    public final void c(ConstraintLayout constraintLayout0) {
        int v = constraintLayout0.getChildCount();
        HashMap hashMap0 = this.g;
        HashSet hashSet0 = new HashSet(hashMap0.keySet());
        for(int v2 = 0; v2 < v; ++v2) {
            View view0 = constraintLayout0.getChildAt(v2);
            int v3 = view0.getId();
            if(hashMap0.containsKey(v3)) {
                if(this.f && v3 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if(v3 != -1) {
                    if(hashMap0.containsKey(v3)) {
                        hashSet0.remove(v3);
                        i i0 = (i)hashMap0.get(v3);
                        if(i0 != null) {
                            l l0 = i0.c;
                            j j0 = i0.e;
                            m m0 = i0.f;
                            if(view0 instanceof Barrier) {
                                j0.i0 = 1;
                                ((Barrier)view0).setId(v3);
                                ((Barrier)view0).setType(j0.g0);
                                ((Barrier)view0).setMargin(j0.h0);
                                ((Barrier)view0).setAllowsGoneWidget(j0.o0);
                                int[] arr_v = j0.j0;
                                if(arr_v == null) {
                                    String s = j0.k0;
                                    if(s != null) {
                                        int[] arr_v1 = n.j(((Barrier)view0), s);
                                        j0.j0 = arr_v1;
                                        ((Barrier)view0).setReferencedIds(arr_v1);
                                    }
                                }
                                else {
                                    ((Barrier)view0).setReferencedIds(arr_v);
                                }
                            }
                            LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                            constraintLayout$LayoutParams0.a();
                            i0.a(constraintLayout$LayoutParams0);
                            a.e(view0, i0.g);
                            view0.setLayoutParams(constraintLayout$LayoutParams0);
                            if(l0.c == 0) {
                                view0.setVisibility(l0.b);
                            }
                            view0.setAlpha(l0.d);
                            view0.setRotation(m0.b);
                            view0.setRotationX(m0.c);
                            view0.setRotationY(m0.d);
                            view0.setScaleX(m0.e);
                            view0.setScaleY(m0.f);
                            if(m0.i == -1) {
                                if(!Float.isNaN(m0.g)) {
                                    view0.setPivotX(m0.g);
                                }
                                if(!Float.isNaN(m0.h)) {
                                    view0.setPivotY(m0.h);
                                }
                            }
                            else {
                                View view1 = ((View)view0.getParent()).findViewById(m0.i);
                                if(view1 != null) {
                                    int v4 = view1.getTop();
                                    float f = ((float)(view1.getBottom() + v4)) / 2.0f;
                                    int v5 = view1.getLeft();
                                    float f1 = ((float)(view1.getRight() + v5)) / 2.0f;
                                    if(view0.getRight() - view0.getLeft() > 0 && view0.getBottom() - view0.getTop() > 0) {
                                        float f2 = f1 - ((float)view0.getLeft());
                                        float f3 = f - ((float)view0.getTop());
                                        view0.setPivotX(f2);
                                        view0.setPivotY(f3);
                                    }
                                }
                            }
                            view0.setTranslationX(m0.j);
                            view0.setTranslationY(m0.k);
                            view0.setTranslationZ(m0.l);
                            if(m0.m) {
                                view0.setElevation(m0.n);
                            }
                        }
                    }
                    else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + v3);
                    }
                }
            }
            else {
                Log.w("ConstraintSet", "id unknown " + ye.a.G(view0));
            }
        }
        for(Object object0: hashSet0) {
            Integer integer0 = (Integer)object0;
            i i1 = (i)hashMap0.get(integer0);
            if(i1 != null) {
                j j1 = i1.e;
                if(j1.i0 == 1) {
                    Barrier barrier0 = new Barrier(constraintLayout0.getContext());
                    barrier0.setId(((int)integer0));
                    int[] arr_v2 = j1.j0;
                    if(arr_v2 == null) {
                        String s1 = j1.k0;
                        if(s1 != null) {
                            int[] arr_v3 = n.j(barrier0, s1);
                            j1.j0 = arr_v3;
                            barrier0.setReferencedIds(arr_v3);
                        }
                    }
                    else {
                        barrier0.setReferencedIds(arr_v2);
                    }
                    barrier0.setType(j1.g0);
                    barrier0.setMargin(j1.h0);
                    LayoutParams constraintLayout$LayoutParams1 = constraintLayout0.generateDefaultLayoutParams();
                    barrier0.p();
                    i1.a(constraintLayout$LayoutParams1);
                    constraintLayout0.addView(barrier0, constraintLayout$LayoutParams1);
                }
                if(j1.a) {
                    Guideline guideline0 = new Guideline(constraintLayout0.getContext());
                    guideline0.setId(((int)integer0));
                    LayoutParams constraintLayout$LayoutParams2 = constraintLayout0.generateDefaultLayoutParams();
                    i1.a(constraintLayout$LayoutParams2);
                    constraintLayout0.addView(guideline0, constraintLayout$LayoutParams2);
                }
            }
        }
        for(int v1 = 0; v1 < v; ++v1) {
            View view2 = constraintLayout0.getChildAt(v1);
            if(view2 instanceof ConstraintHelper) {
                ((ConstraintHelper)view2).f(constraintLayout0);
            }
        }
    }

    public static i d(Context context0, XmlResourceParser xmlResourceParser0) {
        AttributeSet attributeSet0 = Xml.asAttributeSet(xmlResourceParser0);
        i i0 = new i();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.f);
        n.s(i0, typedArray0);
        typedArray0.recycle();
        return i0;
    }

    public final void e(int v, int v1) {
        HashMap hashMap0 = this.g;
        if(hashMap0.containsKey(v)) {
            i i0 = (i)hashMap0.get(v);
            if(i0 != null) {
                j j0 = i0.e;
                switch(v1) {
                    case 1: {
                        j0.j = -1;
                        j0.i = -1;
                        j0.G = -1;
                        j0.N = 0x80000000;
                        break;
                    }
                    case 2: {
                        j0.l = -1;
                        j0.k = -1;
                        j0.H = -1;
                        j0.P = 0x80000000;
                        return;
                    }
                    case 3: {
                        j0.n = -1;
                        j0.m = -1;
                        j0.I = 0;
                        j0.O = 0x80000000;
                        return;
                    }
                    case 4: {
                        j0.o = -1;
                        j0.p = -1;
                        j0.J = 0;
                        j0.Q = 0x80000000;
                        return;
                    }
                    case 5: {
                        j0.q = -1;
                        j0.r = -1;
                        j0.s = -1;
                        j0.M = 0;
                        j0.T = 0x80000000;
                        return;
                    }
                    case 6: {
                        j0.t = -1;
                        j0.u = -1;
                        j0.L = 0;
                        j0.S = 0x80000000;
                        return;
                    }
                    case 7: {
                        j0.v = -1;
                        j0.w = -1;
                        j0.K = 0;
                        j0.R = 0x80000000;
                        return;
                    }
                    case 8: {
                        j0.C = -1.0f;
                        j0.B = -1;
                        j0.A = -1;
                        return;
                    }
                    default: {
                        throw new IllegalArgumentException("unknown constraint");
                    }
                }
            }
        }
    }

    public final void f(ConstraintLayout constraintLayout0) {
        int v3;
        int v = constraintLayout0.getChildCount();
        HashMap hashMap0 = this.g;
        hashMap0.clear();
        int v1 = 0;
        while(v1 < v) {
            View view0 = constraintLayout0.getChildAt(v1);
            LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            int v2 = view0.getId();
            if(this.f && v2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if(!hashMap0.containsKey(v2)) {
                hashMap0.put(v2, new i());
            }
            i i0 = (i)hashMap0.get(v2);
            if(i0 == null) {
                v3 = v1;
            }
            else {
                l l0 = i0.c;
                j j0 = i0.e;
                m m0 = i0.f;
                HashMap hashMap1 = new HashMap();
                Class class0 = view0.getClass();
                v3 = v1;
                HashMap hashMap2 = this.e;
                for(Object object0: hashMap2.keySet()) {
                    String s = (String)object0;
                    a a0 = (a)hashMap2.get(s);
                    try {
                        if(s.equals("BackgroundColor")) {
                            hashMap1.put(s, new a(a0, ((ColorDrawable)view0.getBackground()).getColor()));
                            continue;
                        }
                        hashMap1.put(s, new a(a0, class0.getMethod("getMap" + s, null).invoke(view0, null)));
                        continue;
                    }
                    catch(NoSuchMethodException noSuchMethodException0) {
                    }
                    catch(IllegalAccessException illegalAccessException0) {
                        goto label_40;
                    }
                    catch(InvocationTargetException invocationTargetException0) {
                        goto label_44;
                    }
                    Log.e("TransitionLayout", class0.getName() + " must have a method " + s, noSuchMethodException0);
                    continue;
                label_40:
                    StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n(" Custom Attribute \"", s, "\" not found on ");
                    stringBuilder0.append(class0.getName());
                    Log.e("TransitionLayout", stringBuilder0.toString(), illegalAccessException0);
                    continue;
                label_44:
                    StringBuilder stringBuilder1 = com.iloen.melon.utils.a.n(" Custom Attribute \"", s, "\" not found on ");
                    stringBuilder1.append(class0.getName());
                    Log.e("TransitionLayout", stringBuilder1.toString(), invocationTargetException0);
                }
                i0.g = hashMap1;
                i0.c(v2, constraintLayout$LayoutParams0);
                l0.b = view0.getVisibility();
                l0.d = view0.getAlpha();
                m0.b = view0.getRotation();
                m0.c = view0.getRotationX();
                m0.d = view0.getRotationY();
                m0.e = view0.getScaleX();
                m0.f = view0.getScaleY();
                float f = view0.getPivotX();
                float f1 = view0.getPivotY();
                if(((double)f) != 0.0 || ((double)f1) != 0.0) {
                    m0.g = f;
                    m0.h = f1;
                }
                m0.j = view0.getTranslationX();
                m0.k = view0.getTranslationY();
                m0.l = view0.getTranslationZ();
                if(m0.m) {
                    m0.n = view0.getElevation();
                }
                if(view0 instanceof Barrier) {
                    j0.o0 = ((Barrier)view0).getAllowsGoneWidget();
                    j0.j0 = ((Barrier)view0).getReferencedIds();
                    j0.g0 = ((Barrier)view0).getType();
                    j0.h0 = ((Barrier)view0).getMargin();
                }
            }
            v1 = v3 + 1;
        }
    }

    public final void g(n n0) {
        HashMap hashMap0 = this.g;
        hashMap0.clear();
        for(Object object0: n0.g.keySet()) {
            Integer integer0 = (Integer)object0;
            i i0 = (i)n0.g.get(integer0);
            if(i0 != null) {
                hashMap0.put(integer0, i0.b());
            }
        }
    }

    public final void h(int v, int v1, int v2, int v3) {
        HashMap hashMap0 = this.g;
        if(!hashMap0.containsKey(v)) {
            hashMap0.put(v, new i());
        }
        i i0 = (i)hashMap0.get(v);
        if(i0 == null) {
            return;
        }
        j j0 = i0.e;
        switch(v1) {
            case 1: {
                if(v3 == 1) {
                    j0.i = v2;
                    j0.j = -1;
                    return;
                }
                if(v3 != 2) {
                    throw new IllegalArgumentException("left to " + n.u(v3) + " undefined");
                }
                j0.j = v2;
                j0.i = -1;
                return;
            }
            case 2: {
                if(v3 == 1) {
                    j0.k = v2;
                    j0.l = -1;
                    return;
                }
                if(v3 != 2) {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.l = v2;
                j0.k = -1;
                return;
            }
            case 3: {
                if(v3 == 3) {
                    j0.m = v2;
                    j0.n = -1;
                    j0.q = -1;
                    j0.r = -1;
                    j0.s = -1;
                    return;
                }
                if(v3 != 4) {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.n = v2;
                j0.m = -1;
                j0.q = -1;
                j0.r = -1;
                j0.s = -1;
                return;
            }
            case 4: {
                if(v3 == 4) {
                    j0.p = v2;
                    j0.o = -1;
                    j0.q = -1;
                    j0.r = -1;
                    j0.s = -1;
                    return;
                }
                if(v3 != 3) {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.o = v2;
                j0.p = -1;
                j0.q = -1;
                j0.r = -1;
                j0.s = -1;
                return;
            }
            case 5: {
                switch(v3) {
                    case 3: {
                        j0.r = v2;
                        j0.p = -1;
                        j0.o = -1;
                        j0.m = -1;
                        j0.n = -1;
                        return;
                    }
                    case 4: {
                        j0.s = v2;
                        j0.p = -1;
                        j0.o = -1;
                        j0.m = -1;
                        j0.n = -1;
                        return;
                    }
                    case 5: {
                        j0.q = v2;
                        j0.p = -1;
                        j0.o = -1;
                        j0.m = -1;
                        j0.n = -1;
                        return;
                    }
                    default: {
                        throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                    }
                }
            }
            case 6: {
                if(v3 == 6) {
                    j0.u = v2;
                    j0.t = -1;
                    return;
                }
                if(v3 != 7) {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.t = v2;
                j0.u = -1;
                return;
            }
            case 7: {
                if(v3 == 7) {
                    j0.w = v2;
                    j0.v = -1;
                    return;
                }
                if(v3 != 6) {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.v = v2;
                j0.w = -1;
                return;
            }
            default: {
                throw new IllegalArgumentException(n.u(v1) + " to " + n.u(v3) + " unknown");
            }
        }
    }

    public final void i(int v, int v1, int v2, int v3, int v4) {
        HashMap hashMap0 = this.g;
        if(!hashMap0.containsKey(v)) {
            hashMap0.put(v, new i());
        }
        i i0 = (i)hashMap0.get(v);
        if(i0 == null) {
            return;
        }
        j j0 = i0.e;
        switch(v1) {
            case 1: {
                if(v3 == 1) {
                    j0.i = v2;
                    j0.j = -1;
                }
                else if(v3 == 2) {
                    j0.j = v2;
                    j0.i = -1;
                }
                else {
                    throw new IllegalArgumentException("Left to " + n.u(v3) + " undefined");
                }
                j0.G = v4;
                return;
            }
            case 2: {
                if(v3 == 1) {
                    j0.k = v2;
                    j0.l = -1;
                }
                else if(v3 == 2) {
                    j0.l = v2;
                    j0.k = -1;
                }
                else {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.H = v4;
                return;
            }
            case 3: {
                if(v3 == 3) {
                    j0.m = v2;
                    j0.n = -1;
                    j0.q = -1;
                    j0.r = -1;
                    j0.s = -1;
                }
                else if(v3 == 4) {
                    j0.n = v2;
                    j0.m = -1;
                    j0.q = -1;
                    j0.r = -1;
                    j0.s = -1;
                }
                else {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.I = v4;
                return;
            }
            case 4: {
                if(v3 == 4) {
                    j0.p = v2;
                    j0.o = -1;
                    j0.q = -1;
                    j0.r = -1;
                    j0.s = -1;
                }
                else if(v3 == 3) {
                    j0.o = v2;
                    j0.p = -1;
                    j0.q = -1;
                    j0.r = -1;
                    j0.s = -1;
                }
                else {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.J = v4;
                return;
            }
            case 5: {
                switch(v3) {
                    case 3: {
                        j0.r = v2;
                        j0.p = -1;
                        j0.o = -1;
                        j0.m = -1;
                        j0.n = -1;
                        return;
                    }
                    case 4: {
                        j0.s = v2;
                        j0.p = -1;
                        j0.o = -1;
                        j0.m = -1;
                        j0.n = -1;
                        return;
                    }
                    case 5: {
                        j0.q = v2;
                        j0.p = -1;
                        j0.o = -1;
                        j0.m = -1;
                        j0.n = -1;
                        return;
                    }
                    default: {
                        throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                    }
                }
            }
            case 6: {
                if(v3 == 6) {
                    j0.u = v2;
                    j0.t = -1;
                }
                else if(v3 == 7) {
                    j0.t = v2;
                    j0.u = -1;
                }
                else {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.L = v4;
                return;
            }
            case 7: {
                if(v3 == 7) {
                    j0.w = v2;
                    j0.v = -1;
                }
                else if(v3 == 6) {
                    j0.v = v2;
                    j0.w = -1;
                }
                else {
                    throw new IllegalArgumentException("right to " + n.u(v3) + " undefined");
                }
                j0.K = v4;
                return;
            }
            default: {
                throw new IllegalArgumentException(n.u(v1) + " to " + n.u(v3) + " unknown");
            }
        }
    }

    public static int[] j(Barrier barrier0, String s) {
        int v2;
        String[] arr_s = s.split(",");
        Context context0 = barrier0.getContext();
        int[] arr_v = new int[arr_s.length];
        int v = 0;
        int v1;
        for(v1 = 0; v < arr_s.length; ++v1) {
            String s1 = arr_s[v].trim();
            try {
                v2 = 0;
                v2 = p.class.getField(s1).getInt(null);
            }
            catch(Exception unused_ex) {
            }
            if(v2 == 0) {
                v2 = context0.getResources().getIdentifier(s1, "id", "com.iloen.melon");
            }
            if(v2 == 0 && barrier0.isInEditMode() && barrier0.getParent() instanceof ConstraintLayout) {
                Object object0 = ((ConstraintLayout)barrier0.getParent()).getDesignInformation(0, s1);
                if(object0 != null && object0 instanceof Integer) {
                    v2 = (int)(((Integer)object0));
                }
            }
            arr_v[v1] = v2;
            ++v;
        }
        return v1 == arr_s.length ? arr_v : Arrays.copyOf(arr_v, v1);
    }

    public static i k(Context context0, AttributeSet attributeSet0, boolean z) {
        j j0;
        i i0 = new i();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, (z ? q.f : q.b));
        if(z) {
            n.s(i0, typedArray0);
        }
        else {
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; true; ++v1) {
                j0 = i0.e;
                if(v1 >= v) {
                    break;
                }
                int v2 = typedArray0.getIndex(v1);
                l l0 = i0.c;
                m m0 = i0.f;
                k k0 = i0.d;
                if(v2 != 1 && 23 != v2 && 24 != v2) {
                    k0.a = true;
                    j0.b = true;
                    l0.a = true;
                    m0.a = true;
                }
                SparseIntArray sparseIntArray0 = n.i;
                switch(sparseIntArray0.get(v2)) {
                    case 1: {
                        j0.q = n.p(typedArray0, v2, j0.q);
                        break;
                    }
                    case 2: {
                        j0.J = typedArray0.getDimensionPixelSize(v2, j0.J);
                        break;
                    }
                    case 3: {
                        j0.p = n.p(typedArray0, v2, j0.p);
                        break;
                    }
                    case 4: {
                        j0.o = n.p(typedArray0, v2, j0.o);
                        break;
                    }
                    case 5: {
                        j0.z = typedArray0.getString(v2);
                        break;
                    }
                    case 6: {
                        j0.D = typedArray0.getDimensionPixelOffset(v2, j0.D);
                        break;
                    }
                    case 7: {
                        j0.E = typedArray0.getDimensionPixelOffset(v2, j0.E);
                        break;
                    }
                    case 8: {
                        j0.K = typedArray0.getDimensionPixelSize(v2, j0.K);
                        break;
                    }
                    case 9: {
                        j0.w = n.p(typedArray0, v2, j0.w);
                        break;
                    }
                    case 10: {
                        j0.v = n.p(typedArray0, v2, j0.v);
                        break;
                    }
                    case 11: {
                        j0.Q = typedArray0.getDimensionPixelSize(v2, j0.Q);
                        break;
                    }
                    case 12: {
                        j0.R = typedArray0.getDimensionPixelSize(v2, j0.R);
                        break;
                    }
                    case 13: {
                        j0.N = typedArray0.getDimensionPixelSize(v2, j0.N);
                        break;
                    }
                    case 14: {
                        j0.P = typedArray0.getDimensionPixelSize(v2, j0.P);
                        break;
                    }
                    case 15: {
                        j0.S = typedArray0.getDimensionPixelSize(v2, j0.S);
                        break;
                    }
                    case 16: {
                        j0.O = typedArray0.getDimensionPixelSize(v2, j0.O);
                        break;
                    }
                    case 17: {
                        j0.e = typedArray0.getDimensionPixelOffset(v2, j0.e);
                        break;
                    }
                    case 18: {
                        j0.f = typedArray0.getDimensionPixelOffset(v2, j0.f);
                        break;
                    }
                    case 19: {
                        j0.g = typedArray0.getFloat(v2, j0.g);
                        break;
                    }
                    case 20: {
                        j0.x = typedArray0.getFloat(v2, j0.x);
                        break;
                    }
                    case 21: {
                        j0.d = typedArray0.getLayoutDimension(v2, j0.d);
                        break;
                    }
                    case 22: {
                        l0.b = n.h[typedArray0.getInt(v2, l0.b)];
                        break;
                    }
                    case 23: {
                        j0.c = typedArray0.getLayoutDimension(v2, j0.c);
                        break;
                    }
                    case 24: {
                        j0.G = typedArray0.getDimensionPixelSize(v2, j0.G);
                        break;
                    }
                    case 25: {
                        j0.i = n.p(typedArray0, v2, j0.i);
                        break;
                    }
                    case 26: {
                        j0.j = n.p(typedArray0, v2, j0.j);
                        break;
                    }
                    case 27: {
                        j0.F = typedArray0.getInt(v2, j0.F);
                        break;
                    }
                    case 28: {
                        j0.H = typedArray0.getDimensionPixelSize(v2, j0.H);
                        break;
                    }
                    case 29: {
                        j0.k = n.p(typedArray0, v2, j0.k);
                        break;
                    }
                    case 30: {
                        j0.l = n.p(typedArray0, v2, j0.l);
                        break;
                    }
                    case 0x1F: {
                        j0.L = typedArray0.getDimensionPixelSize(v2, j0.L);
                        break;
                    }
                    case 0x20: {
                        j0.t = n.p(typedArray0, v2, j0.t);
                        break;
                    }
                    case 33: {
                        j0.u = n.p(typedArray0, v2, j0.u);
                        break;
                    }
                    case 34: {
                        j0.I = typedArray0.getDimensionPixelSize(v2, j0.I);
                        break;
                    }
                    case 35: {
                        j0.n = n.p(typedArray0, v2, j0.n);
                        break;
                    }
                    case 36: {
                        j0.m = n.p(typedArray0, v2, j0.m);
                        break;
                    }
                    case 37: {
                        j0.y = typedArray0.getFloat(v2, j0.y);
                        break;
                    }
                    case 38: {
                        i0.a = typedArray0.getResourceId(v2, i0.a);
                        break;
                    }
                    case 39: {
                        j0.V = typedArray0.getFloat(v2, j0.V);
                        break;
                    }
                    case 40: {
                        j0.U = typedArray0.getFloat(v2, j0.U);
                        break;
                    }
                    case 41: {
                        j0.W = typedArray0.getInt(v2, j0.W);
                        break;
                    }
                    case 42: {
                        j0.X = typedArray0.getInt(v2, j0.X);
                        break;
                    }
                    case 43: {
                        l0.d = typedArray0.getFloat(v2, l0.d);
                        break;
                    }
                    case 44: {
                        m0.m = true;
                        m0.n = typedArray0.getDimension(v2, m0.n);
                        break;
                    }
                    case 45: {
                        m0.c = typedArray0.getFloat(v2, m0.c);
                        break;
                    }
                    case 46: {
                        m0.d = typedArray0.getFloat(v2, m0.d);
                        break;
                    }
                    case 0x2F: {
                        m0.e = typedArray0.getFloat(v2, m0.e);
                        break;
                    }
                    case 0x30: {
                        m0.f = typedArray0.getFloat(v2, m0.f);
                        break;
                    }
                    case 49: {
                        m0.g = typedArray0.getDimension(v2, m0.g);
                        break;
                    }
                    case 50: {
                        m0.h = typedArray0.getDimension(v2, m0.h);
                        break;
                    }
                    case 51: {
                        m0.j = typedArray0.getDimension(v2, m0.j);
                        break;
                    }
                    case 52: {
                        m0.k = typedArray0.getDimension(v2, m0.k);
                        break;
                    }
                    case 53: {
                        m0.l = typedArray0.getDimension(v2, m0.l);
                        break;
                    }
                    case 54: {
                        j0.Y = typedArray0.getInt(v2, j0.Y);
                        break;
                    }
                    case 55: {
                        j0.Z = typedArray0.getInt(v2, j0.Z);
                        break;
                    }
                    case 56: {
                        j0.a0 = typedArray0.getDimensionPixelSize(v2, j0.a0);
                        break;
                    }
                    case 57: {
                        j0.b0 = typedArray0.getDimensionPixelSize(v2, j0.b0);
                        break;
                    }
                    case 58: {
                        j0.c0 = typedArray0.getDimensionPixelSize(v2, j0.c0);
                        break;
                    }
                    case 59: {
                        j0.d0 = typedArray0.getDimensionPixelSize(v2, j0.d0);
                        break;
                    }
                    case 60: {
                        m0.b = typedArray0.getFloat(v2, m0.b);
                        break;
                    }
                    case 61: {
                        j0.A = n.p(typedArray0, v2, j0.A);
                        break;
                    }
                    case 62: {
                        j0.B = typedArray0.getDimensionPixelSize(v2, j0.B);
                        break;
                    }
                    case 0x3F: {
                        j0.C = typedArray0.getFloat(v2, j0.C);
                        break;
                    }
                    case 0x40: {
                        k0.b = n.p(typedArray0, v2, k0.b);
                        break;
                    }
                    case 65: {
                        k0.d = typedArray0.peekValue(v2).type == 3 ? typedArray0.getString(v2) : e.d[typedArray0.getInteger(v2, 0)];
                        break;
                    }
                    case 66: {
                        k0.f = typedArray0.getInt(v2, 0);
                        break;
                    }
                    case 67: {
                        k0.h = typedArray0.getFloat(v2, k0.h);
                        break;
                    }
                    case 68: {
                        l0.e = typedArray0.getFloat(v2, l0.e);
                        break;
                    }
                    case 69: {
                        j0.e0 = typedArray0.getFloat(v2, 1.0f);
                        break;
                    }
                    case 70: {
                        j0.f0 = typedArray0.getFloat(v2, 1.0f);
                        break;
                    }
                    case 71: {
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    }
                    case 72: {
                        j0.g0 = typedArray0.getInt(v2, j0.g0);
                        break;
                    }
                    case 73: {
                        j0.h0 = typedArray0.getDimensionPixelSize(v2, j0.h0);
                        break;
                    }
                    case 74: {
                        j0.k0 = typedArray0.getString(v2);
                        break;
                    }
                    case 75: {
                        j0.o0 = typedArray0.getBoolean(v2, j0.o0);
                        break;
                    }
                    case 76: {
                        k0.e = typedArray0.getInt(v2, k0.e);
                        break;
                    }
                    case 77: {
                        j0.l0 = typedArray0.getString(v2);
                        break;
                    }
                    case 78: {
                        l0.c = typedArray0.getInt(v2, l0.c);
                        break;
                    }
                    case 0x4F: {
                        k0.g = typedArray0.getFloat(v2, k0.g);
                        break;
                    }
                    case 80: {
                        j0.m0 = typedArray0.getBoolean(v2, j0.m0);
                        break;
                    }
                    case 81: {
                        j0.n0 = typedArray0.getBoolean(v2, j0.n0);
                        break;
                    }
                    case 82: {
                        k0.c = typedArray0.getInteger(v2, k0.c);
                        break;
                    }
                    case 83: {
                        m0.i = n.p(typedArray0, v2, m0.i);
                        break;
                    }
                    case 84: {
                        k0.j = typedArray0.getInteger(v2, k0.j);
                        break;
                    }
                    case 85: {
                        k0.i = typedArray0.getFloat(v2, k0.i);
                        break;
                    }
                    case 86: {
                        int v3 = typedArray0.peekValue(v2).type;
                        if(v3 == 1) {
                            int v4 = typedArray0.getResourceId(v2, -1);
                            k0.m = v4;
                            if(v4 != -1) {
                                k0.l = -2;
                            }
                        }
                        else if(v3 == 3) {
                            String s = typedArray0.getString(v2);
                            k0.k = s;
                            if(s.indexOf("/") > 0) {
                                k0.m = typedArray0.getResourceId(v2, -1);
                                k0.l = -2;
                            }
                            else {
                                k0.l = -1;
                            }
                        }
                        else {
                            k0.l = typedArray0.getInteger(v2, k0.m);
                        }
                        break;
                    }
                    case 87: {
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                        break;
                    }
                    case 91: {
                        j0.r = n.p(typedArray0, v2, j0.r);
                        break;
                    }
                    case 92: {
                        j0.s = n.p(typedArray0, v2, j0.s);
                        break;
                    }
                    case 93: {
                        j0.M = typedArray0.getDimensionPixelSize(v2, j0.M);
                        break;
                    }
                    case 94: {
                        j0.T = typedArray0.getDimensionPixelSize(v2, j0.T);
                        break;
                    }
                    case 0x5F: {
                        n.q(j0, typedArray0, v2, 0);
                        break;
                    }
                    case 0x60: {
                        n.q(j0, typedArray0, v2, 1);
                        break;
                    }
                    case 97: {
                        j0.p0 = typedArray0.getInt(v2, j0.p0);
                        break;
                    }
                    default: {
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                    }
                }
            }
            if(j0.k0 != null) {
                j0.j0 = null;
            }
        }
        typedArray0.recycle();
        return i0;
    }

    public final i l(int v) {
        HashMap hashMap0 = this.g;
        if(!hashMap0.containsKey(v)) {
            hashMap0.put(v, new i());
        }
        return (i)hashMap0.get(v);
    }

    // 去混淆评级： 低(20)
    public final i m(int v) {
        return this.g.containsKey(v) ? ((i)this.g.get(v)) : null;
    }

    public final void n(Context context0, int v) {
        XmlResourceParser xmlResourceParser0 = context0.getResources().getXml(v);
        try {
            int v1 = xmlResourceParser0.getEventType();
            while(true) {
                switch(v1) {
                    case 1: {
                        return;
                    }
                    case 2: {
                        String s = xmlResourceParser0.getName();
                        i i0 = n.k(context0, Xml.asAttributeSet(xmlResourceParser0), false);
                        if(s.equalsIgnoreCase("Guideline")) {
                            i0.e.a = true;
                        }
                        this.g.put(i0.a, i0);
                        v1 = xmlResourceParser0.next();
                        break;
                    }
                    default: {
                        v1 = xmlResourceParser0.next();
                        break;
                    }
                }
            }
            goto label_16;
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        catch(IOException iOException0) {
            goto label_16;
        }
        Log.e("ConstraintSet", "Error parsing resource: " + v, xmlPullParserException0);
        return;
    label_16:
        Log.e("ConstraintSet", "Error parsing resource: " + v, iOException0);
    }

    public final void o(Context context0, XmlResourceParser xmlResourceParser0) {
        try {
            int v = xmlResourceParser0.getEventType();
            i i0 = null;
            while(true) {
                switch(v) {
                    case 0: {
                        xmlResourceParser0.getName();
                        v = xmlResourceParser0.next();
                        break;
                    }
                    case 1: {
                        return;
                    }
                    case 2: {
                        switch(xmlResourceParser0.getName()) {
                            case "Barrier": {
                                i0 = n.k(context0, Xml.asAttributeSet(xmlResourceParser0), false);
                                i0.e.i0 = 1;
                                break;
                            }
                            case "Constraint": {
                                i0 = n.k(context0, Xml.asAttributeSet(xmlResourceParser0), false);
                                break;
                            }
                            case "ConstraintOverride": {
                                i0 = n.k(context0, Xml.asAttributeSet(xmlResourceParser0), true);
                                break;
                            }
                            case "CustomAttribute": {
                            label_38:
                                if(i0 == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser0.getLineNumber());
                                }
                                a.d(context0, xmlResourceParser0, i0.g);
                                break;
                            }
                            case "CustomMethod": {
                                goto label_38;
                            }
                            case "Guideline": {
                                i0 = n.k(context0, Xml.asAttributeSet(xmlResourceParser0), false);
                                i0.e.a = true;
                                i0.e.b = true;
                                break;
                            }
                            case "Layout": {
                                if(i0 == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser0.getLineNumber());
                                }
                                AttributeSet attributeSet0 = Xml.asAttributeSet(xmlResourceParser0);
                                i0.e.b(context0, attributeSet0);
                                break;
                            }
                            case "Motion": {
                                if(i0 == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser0.getLineNumber());
                                }
                                AttributeSet attributeSet1 = Xml.asAttributeSet(xmlResourceParser0);
                                i0.d.b(context0, attributeSet1);
                                break;
                            }
                            case "PropertySet": {
                                if(i0 == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser0.getLineNumber());
                                }
                                AttributeSet attributeSet2 = Xml.asAttributeSet(xmlResourceParser0);
                                i0.c.a(context0, attributeSet2);
                                break;
                            }
                            case "Transform": {
                                if(i0 == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser0.getLineNumber());
                                }
                                AttributeSet attributeSet3 = Xml.asAttributeSet(xmlResourceParser0);
                                i0.f.b(context0, attributeSet3);
                            }
                        }
                        v = xmlResourceParser0.next();
                        break;
                    }
                    case 3: {
                        switch(xmlResourceParser0.getName().toLowerCase(Locale.ROOT)) {
                            case "constraint": 
                            case "constraintoverride": 
                            case "guideline": {
                                this.g.put(i0.a, i0);
                                i0 = null;
                                break;
                            }
                            case "constraintset": {
                                return;
                            }
                        }
                        v = xmlResourceParser0.next();
                        break;
                    }
                    default: {
                        v = xmlResourceParser0.next();
                        break;
                    }
                }
            }
            goto label_57;
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        catch(IOException iOException0) {
            goto label_57;
        }
        Log.e("ConstraintSet", "Error parsing XML resource", xmlPullParserException0);
        return;
    label_57:
        Log.e("ConstraintSet", "Error parsing XML resource", iOException0);
    }

    public static int p(TypedArray typedArray0, int v, int v1) {
        int v2 = typedArray0.getResourceId(v, v1);
        return v2 == -1 ? typedArray0.getInt(v, -1) : v2;
    }

    public static void q(Object object0, TypedArray typedArray0, int v, int v1) {
        if(object0 != null) {
            boolean z = true;
            int v2 = 0;
            switch(typedArray0.peekValue(v).type) {
                case 3: {
                    String s = typedArray0.getString(v);
                    if(s != null) {
                        int v4 = s.indexOf(61);
                        if(v4 > 0 && v4 < s.length() - 1) {
                            String s1 = s.substring(0, v4);
                            String s2 = s.substring(v4 + 1);
                            if(s2.length() > 0) {
                                String s3 = s1.trim();
                                String s4 = s2.trim();
                                if("ratio".equalsIgnoreCase(s3)) {
                                    if(object0 instanceof LayoutParams) {
                                        if(v1 == 0) {
                                            ((LayoutParams)object0).width = 0;
                                        }
                                        else {
                                            ((LayoutParams)object0).height = 0;
                                        }
                                        n.r(((LayoutParams)object0), s4);
                                        return;
                                    }
                                    if(object0 instanceof j) {
                                        ((j)object0).z = s4;
                                        return;
                                    }
                                    if(object0 instanceof h) {
                                        ((h)object0).c(5, s4);
                                        return;
                                    }
                                }
                                else if("weight".equalsIgnoreCase(s3)) {
                                    try {
                                        float f = Float.parseFloat(s4);
                                        if(object0 instanceof LayoutParams) {
                                            if(v1 == 0) {
                                                ((LayoutParams)object0).width = 0;
                                                ((LayoutParams)object0).H = f;
                                                return;
                                            }
                                            ((LayoutParams)object0).height = 0;
                                            ((LayoutParams)object0).I = f;
                                            return;
                                        }
                                        if(object0 instanceof j) {
                                            if(v1 == 0) {
                                                ((j)object0).c = 0;
                                                ((j)object0).V = f;
                                                return;
                                            }
                                            ((j)object0).d = 0;
                                            ((j)object0).U = f;
                                            return;
                                        }
                                        if(object0 instanceof h) {
                                            if(v1 == 0) {
                                                ((h)object0).b(23, 0);
                                                ((h)object0).a(f, 39);
                                                return;
                                            }
                                            ((h)object0).b(21, 0);
                                            ((h)object0).a(f, 40);
                                            return;
                                        }
                                    }
                                    catch(NumberFormatException unused_ex) {
                                    }
                                }
                                else if("parent".equalsIgnoreCase(s3)) {
                                    try {
                                        float f1 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(s4)));
                                        if(object0 instanceof LayoutParams) {
                                            if(v1 == 0) {
                                                ((LayoutParams)object0).width = 0;
                                                ((LayoutParams)object0).R = f1;
                                                ((LayoutParams)object0).L = 2;
                                                return;
                                            }
                                            ((LayoutParams)object0).height = 0;
                                            ((LayoutParams)object0).S = f1;
                                            ((LayoutParams)object0).M = 2;
                                            return;
                                        }
                                        if(object0 instanceof j) {
                                            if(v1 == 0) {
                                                ((j)object0).c = 0;
                                                ((j)object0).e0 = f1;
                                                ((j)object0).Y = 2;
                                                return;
                                            }
                                            ((j)object0).d = 0;
                                            ((j)object0).f0 = f1;
                                            ((j)object0).Z = 2;
                                            return;
                                        }
                                        if(object0 instanceof h) {
                                            if(v1 == 0) {
                                                ((h)object0).b(23, 0);
                                                ((h)object0).b(54, 2);
                                                return;
                                            }
                                            ((h)object0).b(21, 0);
                                            ((h)object0).b(55, 2);
                                            return;
                                        }
                                    }
                                    catch(NumberFormatException unused_ex) {
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    z = false;
                    v2 = typedArray0.getDimensionPixelSize(v, 0);
                label_101:
                    if(object0 instanceof LayoutParams) {
                        if(v1 == 0) {
                            ((LayoutParams)object0).width = v2;
                            ((LayoutParams)object0).W = z;
                            return;
                        }
                        ((LayoutParams)object0).height = v2;
                        ((LayoutParams)object0).X = z;
                        return;
                    }
                    if(object0 instanceof j) {
                        if(v1 == 0) {
                            ((j)object0).c = v2;
                            ((j)object0).m0 = z;
                            return;
                        }
                        ((j)object0).d = v2;
                        ((j)object0).n0 = z;
                        return;
                    }
                    if(object0 instanceof h) {
                        if(v1 == 0) {
                            ((h)object0).b(23, v2);
                            ((h)object0).d(80, z);
                            return;
                        }
                        ((h)object0).b(21, v2);
                        ((h)object0).d(81, z);
                        return;
                    }
                    break;
                }
                default: {
                    int v3 = typedArray0.getInt(v, 0);
                    if(v3 == -4) {
                        v2 = -2;
                        goto label_101;
                    }
                    else {
                        switch(v3) {
                            case -3: {
                                z = false;
                                goto label_101;
                            }
                            case -2: {
                                z = false;
                                v2 = -2;
                                goto label_101;
                            }
                            default: {
                                if(v3 == -1) {
                                    z = false;
                                    v2 = -1;
                                }
                                else {
                                    z = false;
                                }
                                goto label_101;
                            }
                        }
                    }
                }
            }
        }
        try {
        }
        catch(NumberFormatException unused_ex) {
        }
    }

    public static void r(LayoutParams constraintLayout$LayoutParams0, String s) {
        if(s != null) {
            int v = s.length();
            int v1 = s.indexOf(44);
            int v2 = 0;
            int v3 = -1;
            if(v1 > 0 && v1 < v - 1) {
                String s1 = s.substring(0, v1);
                if(!s1.equalsIgnoreCase("W")) {
                    v2 = s1.equalsIgnoreCase("H") ? 1 : -1;
                }
                v3 = v2;
                v2 = v1 + 1;
            }
            int v4 = s.indexOf(58);
            if(v4 < 0 || v4 >= v - 1) {
                String s4 = s.substring(v2);
                if(s4.length() > 0) {
                    try {
                        Float.parseFloat(s4);
                        constraintLayout$LayoutParams0.G = s;
                        return;
                    }
                    catch(NumberFormatException unused_ex) {
                    }
                }
            }
            else {
                String s2 = s.substring(v2, v4);
                String s3 = s.substring(v4 + 1);
                if(s2.length() > 0 && s3.length() > 0) {
                    try {
                        float f = Float.parseFloat(s2);
                        float f1 = Float.parseFloat(s3);
                        if(f > 0.0f && f1 > 0.0f) {
                            if(v3 == 1) {
                                float f2 = f1 / f;
                            }
                            else {
                                float f3 = f / f1;
                            }
                        }
                    }
                    catch(NumberFormatException unused_ex) {
                    }
                }
            }
        }
        constraintLayout$LayoutParams0.G = s;
    }

    public static void s(i i0, TypedArray typedArray0) {
        int v = typedArray0.getIndexCount();
        h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = new int[10];
        h0.b = new int[10];
        h0.c = 0;
        h0.d = new int[10];
        h0.e = new float[10];
        h0.f = 0;
        h0.g = new int[5];
        h0.h = new String[5];
        h0.i = 0;
        h0.j = new int[4];
        h0.k = new boolean[4];
        h0.l = 0;
        i0.h = h0;
        k k0 = i0.d;
        k0.a = false;
        j j0 = i0.e;
        j0.b = false;
        l l0 = i0.c;
        l0.a = false;
        m m0 = i0.f;
        m0.a = false;
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            int v3 = n.j.get(v2);
            SparseIntArray sparseIntArray0 = n.i;
            switch(v3) {
                case 2: {
                    h0.b(2, typedArray0.getDimensionPixelSize(v2, j0.J));
                    break;
                }
                case 5: {
                    h0.c(5, typedArray0.getString(v2));
                    break;
                }
                case 6: {
                    h0.b(6, typedArray0.getDimensionPixelOffset(v2, j0.D));
                    break;
                }
                case 7: {
                    h0.b(7, typedArray0.getDimensionPixelOffset(v2, j0.E));
                    break;
                }
                case 8: {
                    h0.b(8, typedArray0.getDimensionPixelSize(v2, j0.K));
                    break;
                }
                case 11: {
                    h0.b(11, typedArray0.getDimensionPixelSize(v2, j0.Q));
                    break;
                }
                case 12: {
                    h0.b(12, typedArray0.getDimensionPixelSize(v2, j0.R));
                    break;
                }
                case 13: {
                    h0.b(13, typedArray0.getDimensionPixelSize(v2, j0.N));
                    break;
                }
                case 14: {
                    h0.b(14, typedArray0.getDimensionPixelSize(v2, j0.P));
                    break;
                }
                case 15: {
                    h0.b(15, typedArray0.getDimensionPixelSize(v2, j0.S));
                    break;
                }
                case 16: {
                    h0.b(16, typedArray0.getDimensionPixelSize(v2, j0.O));
                    break;
                }
                case 17: {
                    h0.b(17, typedArray0.getDimensionPixelOffset(v2, j0.e));
                    break;
                }
                case 18: {
                    h0.b(18, typedArray0.getDimensionPixelOffset(v2, j0.f));
                    break;
                }
                case 19: {
                    h0.a(typedArray0.getFloat(v2, j0.g), 19);
                    break;
                }
                case 20: {
                    h0.a(typedArray0.getFloat(v2, j0.x), 20);
                    break;
                }
                case 21: {
                    h0.b(21, typedArray0.getLayoutDimension(v2, j0.d));
                    break;
                }
                case 22: {
                    h0.b(22, n.h[typedArray0.getInt(v2, l0.b)]);
                    break;
                }
                case 23: {
                    h0.b(23, typedArray0.getLayoutDimension(v2, j0.c));
                    break;
                }
                case 24: {
                    h0.b(24, typedArray0.getDimensionPixelSize(v2, j0.G));
                    break;
                }
                case 27: {
                    h0.b(27, typedArray0.getInt(v2, j0.F));
                    break;
                }
                case 28: {
                    h0.b(28, typedArray0.getDimensionPixelSize(v2, j0.H));
                    break;
                }
                case 0x1F: {
                    h0.b(0x1F, typedArray0.getDimensionPixelSize(v2, j0.L));
                    break;
                }
                case 34: {
                    h0.b(34, typedArray0.getDimensionPixelSize(v2, j0.I));
                    break;
                }
                case 37: {
                    h0.a(typedArray0.getFloat(v2, j0.y), 37);
                    break;
                }
                case 38: {
                    int v4 = typedArray0.getResourceId(v2, i0.a);
                    i0.a = v4;
                    h0.b(38, v4);
                    break;
                }
                case 39: {
                    h0.a(typedArray0.getFloat(v2, j0.V), 39);
                    break;
                }
                case 40: {
                    h0.a(typedArray0.getFloat(v2, j0.U), 40);
                    break;
                }
                case 41: {
                    h0.b(41, typedArray0.getInt(v2, j0.W));
                    break;
                }
                case 42: {
                    h0.b(42, typedArray0.getInt(v2, j0.X));
                    break;
                }
                case 43: {
                    h0.a(typedArray0.getFloat(v2, l0.d), 43);
                    break;
                }
                case 44: {
                    h0.d(44, true);
                    h0.a(typedArray0.getDimension(v2, m0.n), 44);
                    break;
                }
                case 45: {
                    h0.a(typedArray0.getFloat(v2, m0.c), 45);
                    break;
                }
                case 46: {
                    h0.a(typedArray0.getFloat(v2, m0.d), 46);
                    break;
                }
                case 0x2F: {
                    h0.a(typedArray0.getFloat(v2, m0.e), 0x2F);
                    break;
                }
                case 0x30: {
                    h0.a(typedArray0.getFloat(v2, m0.f), 0x30);
                    break;
                }
                case 49: {
                    h0.a(typedArray0.getDimension(v2, m0.g), 49);
                    break;
                }
                case 50: {
                    h0.a(typedArray0.getDimension(v2, m0.h), 50);
                    break;
                }
                case 51: {
                    h0.a(typedArray0.getDimension(v2, m0.j), 51);
                    break;
                }
                case 52: {
                    h0.a(typedArray0.getDimension(v2, m0.k), 52);
                    break;
                }
                case 53: {
                    h0.a(typedArray0.getDimension(v2, m0.l), 53);
                    break;
                }
                case 54: {
                    h0.b(54, typedArray0.getInt(v2, j0.Y));
                    break;
                }
                case 55: {
                    h0.b(55, typedArray0.getInt(v2, j0.Z));
                    break;
                }
                case 56: {
                    h0.b(56, typedArray0.getDimensionPixelSize(v2, j0.a0));
                    break;
                }
                case 57: {
                    h0.b(57, typedArray0.getDimensionPixelSize(v2, j0.b0));
                    break;
                }
                case 58: {
                    h0.b(58, typedArray0.getDimensionPixelSize(v2, j0.c0));
                    break;
                }
                case 59: {
                    h0.b(59, typedArray0.getDimensionPixelSize(v2, j0.d0));
                    break;
                }
                case 60: {
                    h0.a(typedArray0.getFloat(v2, m0.b), 60);
                    break;
                }
                case 62: {
                    h0.b(62, typedArray0.getDimensionPixelSize(v2, j0.B));
                    break;
                }
                case 0x3F: {
                    h0.a(typedArray0.getFloat(v2, j0.C), 0x3F);
                    break;
                }
                case 0x40: {
                    h0.b(0x40, n.p(typedArray0, v2, k0.b));
                    break;
                }
                case 65: {
                    if(typedArray0.peekValue(v2).type == 3) {
                        h0.c(65, typedArray0.getString(v2));
                    }
                    else {
                        h0.c(65, e.d[typedArray0.getInteger(v2, 0)]);
                    }
                    break;
                }
                case 66: {
                    h0.b(66, typedArray0.getInt(v2, 0));
                    break;
                }
                case 67: {
                    h0.a(typedArray0.getFloat(v2, k0.h), 67);
                    break;
                }
                case 68: {
                    h0.a(typedArray0.getFloat(v2, l0.e), 68);
                    break;
                }
                case 69: {
                    h0.a(typedArray0.getFloat(v2, 1.0f), 69);
                    break;
                }
                case 70: {
                    h0.a(typedArray0.getFloat(v2, 1.0f), 70);
                    break;
                }
                case 71: {
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                }
                case 72: {
                    h0.b(72, typedArray0.getInt(v2, j0.g0));
                    break;
                }
                case 73: {
                    h0.b(73, typedArray0.getDimensionPixelSize(v2, j0.h0));
                    break;
                }
                case 74: {
                    h0.c(74, typedArray0.getString(v2));
                    break;
                }
                case 75: {
                    h0.d(75, typedArray0.getBoolean(v2, j0.o0));
                    break;
                }
                case 76: {
                    h0.b(76, typedArray0.getInt(v2, k0.e));
                    break;
                }
                case 77: {
                    h0.c(77, typedArray0.getString(v2));
                    break;
                }
                case 78: {
                    h0.b(78, typedArray0.getInt(v2, l0.c));
                    break;
                }
                case 0x4F: {
                    h0.a(typedArray0.getFloat(v2, k0.g), 0x4F);
                    break;
                }
                case 80: {
                    h0.d(80, typedArray0.getBoolean(v2, j0.m0));
                    break;
                }
                case 81: {
                    h0.d(81, typedArray0.getBoolean(v2, j0.n0));
                    break;
                }
                case 82: {
                    h0.b(82, typedArray0.getInteger(v2, k0.c));
                    break;
                }
                case 83: {
                    h0.b(83, n.p(typedArray0, v2, m0.i));
                    break;
                }
                case 84: {
                    h0.b(84, typedArray0.getInteger(v2, k0.j));
                    break;
                }
                case 85: {
                    h0.a(typedArray0.getFloat(v2, k0.i), 85);
                    break;
                }
                case 86: {
                    int v5 = typedArray0.peekValue(v2).type;
                    if(v5 == 1) {
                        int v6 = typedArray0.getResourceId(v2, -1);
                        k0.m = v6;
                        h0.b(89, v6);
                        if(k0.m != -1) {
                            k0.l = -2;
                            h0.b(88, -2);
                        }
                    }
                    else if(v5 == 3) {
                        String s = typedArray0.getString(v2);
                        k0.k = s;
                        h0.c(90, s);
                        if(k0.k.indexOf("/") > 0) {
                            int v7 = typedArray0.getResourceId(v2, -1);
                            k0.m = v7;
                            h0.b(89, v7);
                            k0.l = -2;
                            h0.b(88, -2);
                        }
                        else {
                            k0.l = -1;
                            h0.b(88, -1);
                        }
                    }
                    else {
                        int v8 = typedArray0.getInteger(v2, k0.m);
                        k0.l = v8;
                        h0.b(88, v8);
                    }
                    break;
                }
                case 87: {
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                    break;
                }
                case 93: {
                    h0.b(93, typedArray0.getDimensionPixelSize(v2, j0.M));
                    break;
                }
                case 94: {
                    h0.b(94, typedArray0.getDimensionPixelSize(v2, j0.T));
                    break;
                }
                case 0x5F: {
                    n.q(h0, typedArray0, v2, 0);
                    break;
                }
                case 0x60: {
                    n.q(h0, typedArray0, v2, 1);
                    break;
                }
                case 97: {
                    h0.b(97, typedArray0.getInt(v2, j0.p0));
                    break;
                }
                case 98: {
                    if(MotionLayout.IS_IN_EDIT_MODE) {
                        int v9 = typedArray0.getResourceId(v2, i0.a);
                        i0.a = v9;
                        if(v9 == -1) {
                            i0.b = typedArray0.getString(v2);
                        }
                    }
                    else if(typedArray0.peekValue(v2).type == 3) {
                        i0.b = typedArray0.getString(v2);
                    }
                    else {
                        i0.a = typedArray0.getResourceId(v2, i0.a);
                    }
                    break;
                }
                case 99: {
                    h0.d(99, typedArray0.getBoolean(v2, j0.h));
                    break;
                }
                default: {
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                }
            }
        }
    }

    public final void t(int v, int v1) {
        this.l(v).e.J = v1;
    }

    public static String u(int v) {
        switch(v) {
            case 1: {
                return "left";
            }
            case 2: {
                return "right";
            }
            case 3: {
                return "top";
            }
            case 4: {
                return "bottom";
            }
            case 5: {
                return "baseline";
            }
            case 6: {
                return "start";
            }
            case 7: {
                return "end";
            }
            default: {
                return "undefined";
            }
        }
    }
}

