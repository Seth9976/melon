package androidx.transition;

import N4.L;
import N4.Y;
import N4.a0;
import N4.b0;
import N4.e0;
import N4.l0;
import N4.m0;
import N4.n0;
import R1.a;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import java.util.HashMap;

public abstract class Visibility extends Transition {
    public int b0;
    public static final String[] c0;

    static {
        Visibility.c0 = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    }

    public Visibility() {
        this.b0 = 3;
    }

    public Visibility(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b0 = 3;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.c);
        int v = a.d(typedArray0, ((XmlResourceParser)attributeSet0), "transitionVisibilityMode", 0, 0);
        typedArray0.recycle();
        if(v != 0) {
            this.S(v);
        }
    }

    public static void O(b0 b00) {
        Integer integer0 = b00.b.getVisibility();
        b00.a.put("android:visibility:visibility", integer0);
        ViewParent viewParent0 = b00.b.getParent();
        b00.a.put("android:visibility:parent", viewParent0);
        int[] arr_v = new int[2];
        b00.b.getLocationOnScreen(arr_v);
        b00.a.put("android:visibility:screenLocation", arr_v);
    }

    public static n0 P(b0 b00, b0 b01) {
        n0 n00 = new n0();  // 初始化器: Ljava/lang/Object;-><init>()V
        n00.a = false;
        n00.b = false;
        if(b00 == null) {
            n00.c = -1;
            n00.e = null;
        }
        else {
            HashMap hashMap0 = b00.a;
            if(hashMap0.containsKey("android:visibility:visibility")) {
                n00.c = (int)(((Integer)hashMap0.get("android:visibility:visibility")));
                n00.e = (ViewGroup)hashMap0.get("android:visibility:parent");
            }
            else {
                n00.c = -1;
                n00.e = null;
            }
        }
        if(b01 == null) {
            n00.d = -1;
            n00.f = null;
        }
        else {
            HashMap hashMap1 = b01.a;
            if(hashMap1.containsKey("android:visibility:visibility")) {
                n00.d = (int)(((Integer)hashMap1.get("android:visibility:visibility")));
                n00.f = (ViewGroup)hashMap1.get("android:visibility:parent");
            }
            else {
                n00.d = -1;
                n00.f = null;
            }
        }
        if(b00 == null || b01 == null) {
            if(b00 == null && n00.d == 0) {
                n00.b = true;
                n00.a = true;
                return n00;
            }
            if(b01 == null && n00.c == 0) {
                n00.b = false;
                n00.a = true;
            }
        }
        else {
            int v = n00.c;
            int v1 = n00.d;
            if(v != v1 || n00.e != n00.f) {
                if(v == v1) {
                    if(n00.f == null) {
                        n00.b = false;
                        n00.a = true;
                        return n00;
                    }
                    if(n00.e == null) {
                        n00.b = true;
                        n00.a = true;
                        return n00;
                    }
                }
                else {
                    if(v == 0) {
                        n00.b = false;
                        n00.a = true;
                        return n00;
                    }
                    if(v1 == 0) {
                        n00.b = true;
                        n00.a = true;
                        return n00;
                    }
                }
            }
        }
        return n00;
    }

    public Animator Q(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        return null;
    }

    public Animator R(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        return null;
    }

    public final void S(int v) {
        if((v & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.b0 = v;
    }

    @Override  // androidx.transition.Transition
    public void d(b0 b00) {
        Visibility.O(b00);
    }

    @Override  // androidx.transition.Transition
    public void g(b0 b00) {
        Visibility.O(b00);
    }

    @Override  // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        View view5;
        int v1;
        ViewGroup viewGroup1;
        int v7;
        boolean z4;
        Bitmap bitmap0;
        View view8;
        View view6;
        boolean z1;
        boolean z = true;
        n0 n00 = Visibility.P(b00, b01);
        if(n00.a && (n00.e != null || n00.f != null)) {
            if(!n00.b) {
                int v = n00.d;
                if((this.b0 & 2) == 2 && b00 != null) {
                    View view2 = b00.b;
                    View view3 = b01 == null ? null : b01.b;
                    View view4 = (View)view2.getTag(0x7F0A0A1F);  // id:save_overlay_view
                    if(view4 == null) {
                        if(view3 == null || view3.getParent() == null) {
                            if(view3 == null) {
                                z1 = true;
                                view3 = null;
                            }
                            else {
                                z1 = false;
                            }
                            view6 = null;
                        }
                        else if(v == 4 || view2 == view3) {
                            z1 = false;
                            view6 = view3;
                            view3 = null;
                        }
                        else {
                            z1 = true;
                            view3 = null;
                            view6 = null;
                        }
                        if(!z1) {
                            v1 = v;
                            view4 = view3;
                            z = false;
                            view5 = view6;
                        }
                        else if(view2.getParent() == null) {
                            v1 = v;
                            z = false;
                            view5 = view6;
                            view4 = view2;
                        }
                        else {
                            if(view2.getParent() instanceof View) {
                                View view7 = (View)view2.getParent();
                                if(Visibility.P(this.r(view7, true), this.n(view7, true)).a) {
                                    v1 = v;
                                    view8 = view6;
                                    int v12 = view7.getId();
                                    if(view7.getParent() == null && v12 != -1) {
                                        viewGroup0.findViewById(v12);
                                    }
                                    view4 = view3;
                                }
                                else {
                                    Matrix matrix0 = new Matrix();
                                    matrix0.setTranslate(((float)(-view7.getScrollX())), ((float)(-view7.getScrollY())));
                                    e0.a.o(view2, matrix0);
                                    e0.a.p(viewGroup0, matrix0);
                                    RectF rectF0 = new RectF(0.0f, 0.0f, ((float)view2.getWidth()), ((float)view2.getHeight()));
                                    matrix0.mapRect(rectF0);
                                    int v2 = Math.round(rectF0.left);
                                    int v3 = Math.round(rectF0.top);
                                    int v4 = Math.round(rectF0.right);
                                    int v5 = Math.round(rectF0.bottom);
                                    ImageView imageView0 = new ImageView(view2.getContext());
                                    imageView0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    boolean z2 = view2.isAttachedToWindow();
                                    boolean z3 = viewGroup0 != null && viewGroup0.isAttachedToWindow();
                                    if(z2) {
                                        z4 = true;
                                        viewGroup1 = null;
                                        v7 = 0;
                                    label_75:
                                        view8 = view6;
                                        int v8 = Math.round(rectF0.width());
                                        v1 = v;
                                        int v9 = Math.round(rectF0.height());
                                        if(v8 <= 0 || v9 <= 0) {
                                            bitmap0 = null;
                                        }
                                        else {
                                            float f = Math.min(1.0f, 1048576.0f / ((float)(v8 * v9)));
                                            int v10 = Math.round(((float)v8) * f);
                                            int v11 = Math.round(((float)v9) * f);
                                            matrix0.postTranslate(-rectF0.left, -rectF0.top);
                                            matrix0.postScale(f, f);
                                            if(a0.a) {
                                                Picture picture0 = new Picture();
                                                Canvas canvas0 = picture0.beginRecording(v10, v11);
                                                canvas0.concat(matrix0);
                                                view2.draw(canvas0);
                                                picture0.endRecording();
                                                bitmap0 = Y.a(picture0);
                                            }
                                            else {
                                                bitmap0 = Bitmap.createBitmap(v10, v11, Bitmap.Config.ARGB_8888);
                                                Canvas canvas1 = new Canvas(bitmap0);
                                                canvas1.concat(matrix0);
                                                view2.draw(canvas1);
                                            }
                                        }
                                        if(!z4) {
                                            viewGroup0.getOverlay().remove(view2);
                                            viewGroup1.addView(view2, v7);
                                        }
                                    }
                                    else if(!z3) {
                                        v1 = v;
                                        view8 = view6;
                                        bitmap0 = null;
                                    }
                                    else {
                                        ViewParent viewParent0 = view2.getParent();
                                        int v6 = ((ViewGroup)viewParent0).indexOfChild(view2);
                                        viewGroup0.getOverlay().add(view2);
                                        z4 = false;
                                        v7 = v6;
                                        viewGroup1 = (ViewGroup)viewParent0;
                                        goto label_75;
                                    }
                                    if(bitmap0 != null) {
                                        imageView0.setImageBitmap(bitmap0);
                                    }
                                    imageView0.measure(View.MeasureSpec.makeMeasureSpec(v4 - v2, 0x40000000), View.MeasureSpec.makeMeasureSpec(v5 - v3, 0x40000000));
                                    imageView0.layout(v2, v3, v4, v5);
                                    view4 = imageView0;
                                }
                            }
                            else {
                                v1 = v;
                                view8 = view6;
                                view4 = view3;
                            }
                            z = false;
                            view5 = view8;
                        }
                    }
                    else {
                        v1 = v;
                        view5 = null;
                    }
                    if(view4 != null) {
                        if(!z) {
                            int[] arr_v = (int[])b00.a.get("android:visibility:screenLocation");
                            int v13 = arr_v[0];
                            int v14 = arr_v[1];
                            int[] arr_v1 = new int[2];
                            viewGroup0.getLocationOnScreen(arr_v1);
                            view4.offsetLeftAndRight(v13 - arr_v1[0] - view4.getLeft());
                            view4.offsetTopAndBottom(v14 - arr_v1[1] - view4.getTop());
                            viewGroup0.getOverlay().add(view4);
                        }
                        Animator animator0 = this.R(viewGroup0, view4, b00, b01);
                        if(!z) {
                            if(animator0 == null) {
                                viewGroup0.getOverlay().remove(view4);
                                return null;
                            }
                            view2.setTag(0x7F0A0A1F, view4);  // id:save_overlay_view
                            m0 m00 = new m0(this, viewGroup0, view4, view2);
                            animator0.addListener(m00);
                            animator0.addPauseListener(m00);
                            this.o().a(m00);
                        }
                        return animator0;
                    }
                    if(view5 != null) {
                        int v15 = view5.getVisibility();
                        e0.c(view5, 0);
                        Animator animator1 = this.R(viewGroup0, view5, b00, b01);
                        if(animator1 != null) {
                            l0 l00 = new l0(view5, v1);
                            animator1.addListener(l00);
                            this.o().a(l00);
                            return animator1;
                        }
                        e0.c(view5, v15);
                        return null;
                    }
                }
            }
            else if((this.b0 & 1) == 1 && b01 != null) {
                View view0 = b01.b;
                if(b00 == null) {
                    View view1 = (View)view0.getParent();
                    return Visibility.P(this.n(view1, false), this.r(view1, false)).a ? null : this.Q(viewGroup0, view0, null, b01);
                }
                return this.Q(viewGroup0, view0, b00, b01);
            }
        }
        return null;
    }

    @Override  // androidx.transition.Transition
    public final String[] q() {
        return Visibility.c0;
    }

    @Override  // androidx.transition.Transition
    public final boolean u(b0 b00, b0 b01) {
        if((b00 != null || b01 != null) && (b00 == null || b01 == null || b01.a.containsKey("android:visibility:visibility") == b00.a.containsKey("android:visibility:visibility"))) {
            n0 n00 = Visibility.P(b00, b01);
            return n00.a && (n00.c == 0 || n00.d == 0);
        }
        return false;
    }
}

