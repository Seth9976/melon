package androidx.transition;

import N4.A;
import N4.D;
import N4.F;
import N4.L;
import N4.b0;
import N4.b;
import N4.d0;
import N4.e0;
import N4.k;
import N4.l;
import N4.m;
import N4.n;
import N4.q;
import N4.x;
import N4.y;
import N4.z;
import R1.a;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import c2.M;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    public final boolean b0;
    public final boolean c0;
    public final Matrix d0;
    public static final String[] e0;
    public static final b f0;
    public static final b g0;
    public static final boolean h0;

    static {
        ChangeTransform.e0 = new String[]{"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
        ChangeTransform.f0 = new b("nonTranslations", 6, float[].class);
        ChangeTransform.g0 = new b("translations", 7, PointF.class);
        ChangeTransform.h0 = true;
    }

    public ChangeTransform(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        boolean z = true;
        this.b0 = true;
        this.c0 = true;
        this.d0 = new Matrix();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.e);
        this.b0 = a.f(((XmlPullParser)attributeSet0), "reparentWithOverlay") ? typedArray0.getBoolean(1, true) : true;
        if(a.f(((XmlPullParser)attributeSet0), "reparent")) {
            z = typedArray0.getBoolean(0, true);
        }
        this.c0 = z;
        typedArray0.recycle();
    }

    public final void O(b0 b00) {
        View view0 = b00.b;
        HashMap hashMap0 = b00.a;
        if(view0.getVisibility() != 8) {
            hashMap0.put("android:changeTransform:parent", view0.getParent());
            hashMap0.put("android:changeTransform:transforms", new n(view0));
            Matrix matrix0 = view0.getMatrix();
            hashMap0.put("android:changeTransform:matrix", (matrix0 == null || matrix0.isIdentity() ? null : new Matrix(matrix0)));
            if(this.c0) {
                Matrix matrix1 = new Matrix();
                ViewGroup viewGroup0 = (ViewGroup)view0.getParent();
                e0.a.o(viewGroup0, matrix1);
                matrix1.preTranslate(((float)(-viewGroup0.getScrollX())), ((float)(-viewGroup0.getScrollY())));
                hashMap0.put("android:changeTransform:parentMatrix", matrix1);
                hashMap0.put("android:changeTransform:intermediateMatrix", view0.getTag(0x7F0A0BE5));  // id:transition_transform
                hashMap0.put("android:changeTransform:intermediateParentMatrix", view0.getTag(0x7F0A0903));  // id:parent_matrix
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final void d(b0 b00) {
        this.O(b00);
    }

    @Override  // androidx.transition.Transition
    public final void g(b0 b00) {
        this.O(b00);
        View view0 = b00.b;
        if(!ChangeTransform.h0) {
            ((ViewGroup)view0.getParent()).startViewTransition(view0);
        }
    }

    @Override  // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        ArrayList arrayList3;
        ArrayList arrayList2;
        Integer integer0;
        int v20;
        int v19;
        int v18;
        boolean z4;
        ObjectAnimator objectAnimator1;
        int v;
        A a0;
        boolean z3;
        Animator animator0;
        ObjectAnimator objectAnimator0;
        boolean z;
        if(b00 != null) {
            View view0 = b00.b;
            HashMap hashMap0 = b00.a;
            if(b01 != null) {
                View view1 = b01.b;
                HashMap hashMap1 = b01.a;
                if(hashMap0.containsKey("android:changeTransform:parent") && hashMap1.containsKey("android:changeTransform:parent")) {
                    Object object0 = hashMap0.get("android:changeTransform:parent");
                    ViewGroup viewGroup1 = (ViewGroup)hashMap1.get("android:changeTransform:parent");
                    if(!this.c0) {
                        z = false;
                    }
                    else if(this.v(((ViewGroup)object0)) && this.v(viewGroup1)) {
                        b0 b02 = this.n(((ViewGroup)object0), true);
                        z = b02 != null && viewGroup1 == b02.b ? false : true;
                    }
                    else if(((ViewGroup)object0) == viewGroup1) {
                        z = false;
                    }
                    else {
                        z = true;
                    }
                    Matrix matrix0 = (Matrix)hashMap0.get("android:changeTransform:intermediateMatrix");
                    if(matrix0 != null) {
                        hashMap0.put("android:changeTransform:matrix", matrix0);
                    }
                    Matrix matrix1 = (Matrix)hashMap0.get("android:changeTransform:intermediateParentMatrix");
                    if(matrix1 != null) {
                        hashMap0.put("android:changeTransform:parentMatrix", matrix1);
                    }
                    if(z) {
                        Matrix matrix2 = (Matrix)hashMap1.get("android:changeTransform:parentMatrix");
                        view1.setTag(0x7F0A0903, matrix2);  // id:parent_matrix
                        Matrix matrix3 = this.d0;
                        matrix3.reset();
                        matrix2.invert(matrix3);
                        Matrix matrix4 = (Matrix)hashMap0.get("android:changeTransform:matrix");
                        if(matrix4 == null) {
                            matrix4 = new Matrix();
                            hashMap0.put("android:changeTransform:matrix", matrix4);
                        }
                        matrix4.postConcat(((Matrix)hashMap0.get("android:changeTransform:parentMatrix")));
                        matrix4.postConcat(matrix3);
                    }
                    Matrix matrix5 = (Matrix)hashMap0.get("android:changeTransform:matrix");
                    Matrix matrix6 = (Matrix)hashMap1.get("android:changeTransform:matrix");
                    if(matrix5 == null) {
                        matrix5 = D.a;
                    }
                    if(matrix6 == null) {
                        matrix6 = D.a;
                    }
                    if(matrix5.equals(matrix6)) {
                        objectAnimator0 = null;
                    }
                    else {
                        n n0 = (n)hashMap1.get("android:changeTransform:transforms");
                        view1.setTranslationX(0.0f);
                        view1.setTranslationY(0.0f);
                        M.p(view1, 0.0f);
                        view1.setScaleX(1.0f);
                        view1.setScaleY(1.0f);
                        view1.setRotationX(0.0f);
                        view1.setRotationY(0.0f);
                        view1.setRotation(0.0f);
                        float[] arr_f = new float[9];
                        matrix5.getValues(arr_f);
                        float[] arr_f1 = new float[9];
                        matrix6.getValues(arr_f1);
                        m m0 = new m(view1, arr_f);
                        q q0 = new q(0);
                        q0.b = new float[9];
                        PropertyValuesHolder propertyValuesHolder0 = PropertyValuesHolder.ofObject(ChangeTransform.f0, q0, new float[][]{arr_f, arr_f1});
                        Path path0 = this.N.a(arr_f[2], arr_f[5], arr_f1[2], arr_f1[5]);
                        objectAnimator0 = ObjectAnimator.ofPropertyValuesHolder(m0, new PropertyValuesHolder[]{propertyValuesHolder0, F.a(ChangeTransform.g0, path0)});
                        l l0 = new l(view1, n0, m0, matrix6, z, this.b0);
                        objectAnimator0.addListener(l0);
                        objectAnimator0.addPauseListener(l0);
                    }
                    boolean z1 = ChangeTransform.h0;
                    if(!z || objectAnimator0 == null || !this.b0) {
                        animator0 = objectAnimator0;
                        if(!z1) {
                            ((ViewGroup)object0).endViewTransition(view0);
                        }
                    }
                    else {
                        Matrix matrix7 = new Matrix(((Matrix)hashMap1.get("android:changeTransform:parentMatrix")));
                        e0.a.p(viewGroup0, matrix7);
                        Class class0 = ViewGroup.class;
                        if(Build.VERSION.SDK_INT == 28) {
                            if(!z.e) {
                                try {
                                    z.b();
                                    Method method0 = z.b.getDeclaredMethod("addGhost", View.class, class0, Matrix.class);
                                    z.d = method0;
                                    method0.setAccessible(true);
                                }
                                catch(NoSuchMethodException noSuchMethodException0) {
                                    Log.i("GhostViewApi21", "Failed to retrieve addGhost method", noSuchMethodException0);
                                }
                                z.e = true;
                            }
                            Method method1 = z.d;
                            z z2 = null;
                            if(method1 != null) {
                                try {
                                    z2 = new z(((View)method1.invoke(null, view1, viewGroup0, matrix7)));
                                    goto label_92;
                                }
                                catch(IllegalAccessException unused_ex) {
                                    goto label_92;
                                }
                                catch(InvocationTargetException invocationTargetException0) {
                                }
                                throw new RuntimeException(invocationTargetException0.getCause());
                            }
                        label_92:
                            animator0 = objectAnimator0;
                            z3 = z1;
                            a0 = z2;
                        }
                        else {
                            if(!(view1.getParent() instanceof ViewGroup)) {
                                throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
                            }
                            y y0 = (y)viewGroup0.getTag(0x7F0A04EF);  // id:ghost_view_holder
                            a0 = (A)view1.getTag(0x7F0A04EE);  // id:ghost_view
                            if(a0 == null) {
                                v = 0;
                            }
                            else {
                                y y1 = (y)a0.getParent();
                                if(y1 == y0) {
                                    v = 0;
                                }
                                else {
                                    v = a0.d;
                                    y1.removeView(a0);
                                    a0 = null;
                                }
                            }
                            if(a0 == null) {
                                a0 = new A(view1);
                                a0.e = matrix7;
                                if(y0 == null) {
                                    y0 = new y(viewGroup0.getContext());  // 初始化器: Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
                                    y0.setClipChildren(false);
                                    y0.a = viewGroup0;
                                    viewGroup0.setTag(0x7F0A04EF, y0);  // id:ghost_view_holder
                                    viewGroup0.getOverlay().add(y0);
                                    y0.b = true;
                                    goto label_124;
                                }
                                else {
                                    ViewGroup viewGroup2 = y0.a;
                                    if(!y0.b) {
                                        throw new IllegalStateException("This GhostViewHolder is detached!");
                                    }
                                    viewGroup2.getOverlay().remove(y0);
                                    viewGroup2.getOverlay().add(y0);
                                label_124:
                                    int v1 = y0.getLeft();
                                    int v2 = y0.getTop();
                                    int v3 = y0.getLeft();
                                    int v4 = viewGroup0.getWidth();
                                    int v5 = y0.getTop();
                                    e0.a(y0, v1, v2, v4 + v3, viewGroup0.getHeight() + v5);
                                    int v6 = a0.getLeft();
                                    int v7 = a0.getTop();
                                    int v8 = a0.getLeft();
                                    int v9 = viewGroup0.getWidth();
                                    int v10 = a0.getTop();
                                    e0.a(a0, v6, v7, v9 + v8, viewGroup0.getHeight() + v10);
                                    ArrayList arrayList0 = new ArrayList();
                                    y.a(a0.c, arrayList0);
                                    ArrayList arrayList1 = new ArrayList();
                                    int v11 = y0.getChildCount() - 1;
                                    int v12 = 0;
                                    while(v12 <= v11) {
                                        int v13 = (v12 + v11) / 2;
                                        y.a(((A)y0.getChildAt(v13)).c, arrayList1);
                                        if(arrayList0.isEmpty() || arrayList1.isEmpty()) {
                                            arrayList2 = arrayList0;
                                            arrayList3 = arrayList1;
                                            objectAnimator1 = objectAnimator0;
                                            z4 = z1;
                                        }
                                        else {
                                            objectAnimator1 = objectAnimator0;
                                            z4 = z1;
                                            if(arrayList0.get(0) == arrayList1.get(0)) {
                                                int v14 = Math.min(arrayList0.size(), arrayList1.size());
                                                int v15 = 1;
                                                while(v15 < v14) {
                                                    View view2 = (View)arrayList0.get(v15);
                                                    arrayList2 = arrayList0;
                                                    View view3 = (View)arrayList1.get(v15);
                                                    if(view2 != view3) {
                                                        ViewGroup viewGroup3 = (ViewGroup)view2.getParent();
                                                        int v16 = viewGroup3.getChildCount();
                                                        if(x.a(view2) == x.a(view3)) {
                                                        label_167:
                                                            arrayList3 = arrayList1;
                                                            int v17 = 0;
                                                            while(v17 < v16) {
                                                                v18 = v11;
                                                                if(Build.VERSION.SDK_INT >= 29) {
                                                                    v19 = d0.a(viewGroup3, v17);
                                                                    v20 = v17;
                                                                }
                                                                else {
                                                                    if(!L.q) {
                                                                        try {
                                                                            Method method2 = class0.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                                                                            L.p = method2;
                                                                            method2.setAccessible(true);
                                                                        }
                                                                        catch(NoSuchMethodException unused_ex) {
                                                                        }
                                                                        L.q = true;
                                                                    }
                                                                    Method method3 = L.p;
                                                                    if(method3 == null) {
                                                                        v20 = v17;
                                                                    label_187:
                                                                        v19 = v20;
                                                                    }
                                                                    else {
                                                                        try {
                                                                            integer0 = viewGroup3.getChildCount();
                                                                            v20 = v17;
                                                                        }
                                                                        catch(IllegalAccessException | InvocationTargetException unused_ex) {
                                                                            v20 = v17;
                                                                            goto label_187;
                                                                        }
                                                                        try {
                                                                            v19 = (int)(((Integer)method3.invoke(viewGroup3, integer0, v20)));
                                                                            goto label_188;
                                                                        }
                                                                        catch(IllegalAccessException | InvocationTargetException unused_ex) {
                                                                        }
                                                                        goto label_187;
                                                                    }
                                                                }
                                                            label_188:
                                                                View view4 = viewGroup3.getChildAt(v19);
                                                                if(view4 == view2) {
                                                                    v11 = v13 - 1;
                                                                    goto label_210;
                                                                }
                                                                if(view4 == view3) {
                                                                    goto label_208;
                                                                }
                                                                v17 = v20 + 1;
                                                                v11 = v18;
                                                            }
                                                            goto label_207;
                                                        }
                                                        else {
                                                            if(x.a(view2) > x.a(view3)) {
                                                                arrayList3 = arrayList1;
                                                                goto label_207;
                                                            }
                                                            else {
                                                                arrayList3 = arrayList1;
                                                                v11 = v13 - 1;
                                                                goto label_210;
                                                            }
                                                            goto label_167;
                                                        }
                                                    }
                                                    ++v15;
                                                    arrayList0 = arrayList2;
                                                }
                                                arrayList2 = arrayList0;
                                                arrayList3 = arrayList1;
                                                if(arrayList3.size() != v14) {
                                                    v11 = v13 - 1;
                                                    goto label_210;
                                                }
                                            }
                                            else {
                                                arrayList2 = arrayList0;
                                                arrayList3 = arrayList1;
                                                v12 = v13 + 1;
                                                goto label_210;
                                            }
                                        }
                                    label_207:
                                        v18 = v11;
                                    label_208:
                                        v12 = v13 + 1;
                                        v11 = v18;
                                    label_210:
                                        arrayList3.clear();
                                        arrayList0 = arrayList2;
                                        objectAnimator0 = objectAnimator1;
                                        arrayList1 = arrayList3;
                                        z1 = z4;
                                    }
                                    animator0 = objectAnimator0;
                                    z3 = z1;
                                    if(v12 < 0 || v12 >= y0.getChildCount()) {
                                        y0.addView(a0);
                                    }
                                    else {
                                        y0.addView(a0, v12);
                                    }
                                    a0.d = v;
                                }
                            }
                            else {
                                animator0 = objectAnimator0;
                                z3 = z1;
                                a0.e = matrix7;
                            }
                            ++a0.d;
                        }
                        if(a0 != null) {
                            a0.a(((ViewGroup)hashMap0.get("android:changeTransform:parent")), view0);
                            ChangeTransform changeTransform0 = this;
                            TransitionSet transitionSet0;
                            while((transitionSet0 = changeTransform0.i) != null) {
                                changeTransform0 = transitionSet0;
                            }
                            k k0 = new k();
                            k0.b = view1;
                            k0.c = a0;
                            changeTransform0.a(k0);
                            if(z3) {
                                if(view0 != view1) {
                                    e0.b(view0, 0.0f);
                                }
                                e0.b(view1, 1.0f);
                                return animator0;
                            }
                        }
                    }
                    return animator0;
                }
            }
        }
        return null;
    }

    @Override  // androidx.transition.Transition
    public final String[] q() {
        return ChangeTransform.e0;
    }
}

