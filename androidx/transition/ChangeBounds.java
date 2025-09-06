package androidx.transition;

import N4.E;
import N4.G;
import N4.L;
import N4.b0;
import N4.b;
import N4.c;
import N4.d;
import N4.e0;
import N4.e;
import N4.f;
import R1.a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

public class ChangeBounds extends Transition {
    public boolean b0;
    public static final String[] c0;
    public static final b d0;
    public static final b e0;
    public static final b f0;
    public static final b g0;
    public static final b h0;
    public static final G i0;

    static {
        ChangeBounds.c0 = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
        ChangeBounds.d0 = new b("topLeft", 0, PointF.class);
        ChangeBounds.e0 = new b("bottomRight", 1, PointF.class);
        ChangeBounds.f0 = new b("bottomRight", 2, PointF.class);
        ChangeBounds.g0 = new b("topLeft", 3, PointF.class);
        ChangeBounds.h0 = new b("position", 4, PointF.class);
        ChangeBounds.i0 = new G();
    }

    public ChangeBounds(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        boolean z = false;
        this.b0 = false;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.b);
        if(a.f(((XmlResourceParser)attributeSet0), "resizeClip")) {
            z = typedArray0.getBoolean(0, false);
        }
        typedArray0.recycle();
        this.b0 = z;
    }

    public final void O(b0 b00) {
        View view0 = b00.b;
        HashMap hashMap0 = b00.a;
        if(view0.isLaidOut() || view0.getWidth() != 0 || view0.getHeight() != 0) {
            hashMap0.put("android:changeBounds:bounds", new Rect(view0.getLeft(), view0.getTop(), view0.getRight(), view0.getBottom()));
            hashMap0.put("android:changeBounds:parent", b00.b.getParent());
            if(this.b0) {
                hashMap0.put("android:changeBounds:clip", view0.getClipBounds());
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
        if(this.b0) {
            Rect rect0 = (Rect)b00.b.getTag(0x7F0A0BDE);  // id:transition_clip
            if(rect0 != null) {
                b00.a.put("android:changeBounds:clip", rect0);
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        Animator animator0;
        ObjectAnimator objectAnimator3;
        int v15;
        int v14;
        int v13;
        int v12;
        if(b00 != null) {
            HashMap hashMap0 = b00.a;
            if(b01 != null) {
                HashMap hashMap1 = b01.a;
                if(((ViewGroup)hashMap0.get("android:changeBounds:parent")) != null && ((ViewGroup)hashMap1.get("android:changeBounds:parent")) != null) {
                    View view0 = b01.b;
                    Rect rect0 = (Rect)hashMap0.get("android:changeBounds:bounds");
                    Rect rect1 = (Rect)hashMap1.get("android:changeBounds:bounds");
                    int v = rect0.left;
                    int v1 = rect1.left;
                    int v2 = rect0.top;
                    int v3 = rect1.top;
                    int v4 = rect0.right;
                    int v5 = rect1.right;
                    int v6 = rect0.bottom;
                    int v7 = rect1.bottom;
                    int v8 = v4 - v;
                    int v9 = v6 - v2;
                    int v10 = v5 - v1;
                    int v11 = v7 - v3;
                    Rect rect2 = (Rect)hashMap0.get("android:changeBounds:clip");
                    Rect rect3 = (Rect)hashMap1.get("android:changeBounds:clip");
                    if((v8 == 0 || v9 == 0) && (v10 == 0 || v11 == 0)) {
                        v12 = 0;
                    }
                    else {
                        v12 = v != v1 || v2 != v3 ? 1 : 0;
                        if(v4 != v5 || v6 != v7) {
                            ++v12;
                        }
                    }
                    if(rect2 != null && !rect2.equals(rect3) || rect2 == null && rect3 != null) {
                        ++v12;
                    }
                    if(v12 > 0) {
                        b b0 = ChangeBounds.h0;
                        if(this.b0) {
                            e0.a(view0, v, v2, v + Math.max(v8, v10), v2 + Math.max(v9, v11));
                            if(v != v1 || v2 != v3) {
                                v13 = v6;
                                v15 = v5;
                                v14 = v1;
                                animator0 = E.a(view0, b0, this.N.a(((float)v), ((float)v2), ((float)v1), ((float)v3)));
                            }
                            else {
                                animator0 = null;
                                v13 = v6;
                                v14 = v1;
                                v15 = v5;
                            }
                            Rect rect4 = rect2 == null ? rect2 : new Rect(0, 0, v8, v9);
                            Rect rect5 = rect3 == null ? rect3 : new Rect(0, 0, v10, v11);
                            if(rect4.equals(rect5)) {
                                objectAnimator3 = null;
                            }
                            else {
                                view0.setClipBounds(rect4);
                                ObjectAnimator objectAnimator2 = ObjectAnimator.ofObject(view0, "clipBounds", ChangeBounds.i0, new Object[]{rect4, rect5});
                                d d0 = new d(view0, rect4, rect2 == null, rect5, rect3 == null, v, v2, v4, v13, v14, v3, v15, v7);
                                objectAnimator2.addListener(d0);
                                this.a(d0);
                                objectAnimator3 = objectAnimator2;
                            }
                            if(animator0 == null) {
                                animator0 = objectAnimator3;
                            }
                            else if(objectAnimator3 != null) {
                                AnimatorSet animatorSet1 = new AnimatorSet();
                                animatorSet1.playTogether(new Animator[]{animator0, objectAnimator3});
                                animator0 = animatorSet1;
                            }
                        }
                        else {
                            e0.a(view0, v, v2, v4, v6);
                            if(v12 != 2) {
                                if(v != v1 || v2 != v3) {
                                    Path path3 = this.N.a(((float)v), ((float)v2), ((float)v1), ((float)v3));
                                    animator0 = E.a(view0, ChangeBounds.g0, path3);
                                }
                                else {
                                    Path path2 = this.N.a(((float)v4), ((float)v6), ((float)v5), ((float)v7));
                                    animator0 = E.a(view0, ChangeBounds.f0, path2);
                                }
                            }
                            else if(v8 == v10 && v9 == v11) {
                                animator0 = E.a(view0, b0, this.N.a(((float)v), ((float)v2), ((float)v1), ((float)v3)));
                            }
                            else {
                                f f0 = new f(view0);
                                Path path0 = this.N.a(((float)v), ((float)v2), ((float)v1), ((float)v3));
                                ObjectAnimator objectAnimator0 = E.a(f0, ChangeBounds.d0, path0);
                                Path path1 = this.N.a(((float)v4), ((float)v6), ((float)v5), ((float)v7));
                                ObjectAnimator objectAnimator1 = E.a(f0, ChangeBounds.e0, path1);
                                AnimatorSet animatorSet0 = new AnimatorSet();
                                animatorSet0.playTogether(new Animator[]{objectAnimator0, objectAnimator1});
                                animatorSet0.addListener(new c(f0));
                                animator0 = animatorSet0;
                            }
                        }
                        if(view0.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup1 = (ViewGroup)view0.getParent();
                            L.l(viewGroup1, true);
                            this.o().a(new e(viewGroup1));
                        }
                        return animator0;
                    }
                }
            }
        }
        return null;
    }

    @Override  // androidx.transition.Transition
    public final String[] q() {
        return ChangeBounds.c0;
    }
}

