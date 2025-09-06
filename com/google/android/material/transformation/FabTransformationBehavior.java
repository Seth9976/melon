package com.google.android.material.transformation;

import D6.b;
import E9.g;
import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.collection.V;
import androidx.coordinatorlayout.widget.c;
import c2.M;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d5.n;
import e1.G;
import e6.a;
import e6.d;
import e6.f;
import e6.h;
import java.util.ArrayList;
import m6.e;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    public FabTransformationBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    public final float A(View view0, View view1, h h0) {
        this.C(view0, this.d);
        this.d.offset(this.g, this.h);
        this.C(view1, this.e);
        h0.getClass();
        return this.e.centerY() - this.d.centerY() + 0.0f;
    }

    public static float B(g g0, e6.g g1, float f) {
        long v = g1.a;
        long v1 = g1.b;
        e6.g g2 = ((f)g0.a).f("expansion");
        return a.a(f, 0.0f, g1.b().getInterpolation(((float)(g2.a + g2.b + 17L - v)) / ((float)v1)));
    }

    public final void C(View view0, RectF rectF0) {
        rectF0.set(0.0f, 0.0f, ((float)view0.getWidth()), ((float)view0.getHeight()));
        view0.getLocationInWindow(this.f);
        rectF0.offsetTo(((float)this.f[0]), ((float)this.f[1]));
        rectF0.offset(((float)(((int)(-view0.getTranslationX())))), ((float)(((int)(-view0.getTranslationY())))));
    }

    public abstract g D(Context arg1, boolean arg2);

    @Override  // com.google.android.material.transformation.ExpandableBehavior
    public final boolean f(View view0, View view1) {
        if(view0.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if(view1 instanceof FloatingActionButton) {
            int v = ((FloatingActionButton)view1).getExpandedComponentIdHint();
            return v == 0 || v == view0.getId();
        }
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void g(c c0) {
        if(c0.h == 0) {
            c0.h = 80;
        }
    }

    @Override  // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet x(View view0, View view1, boolean z, boolean z1) {
        ObjectAnimator objectAnimator9;
        ObjectAnimator objectAnimator8;
        boolean z2;
        AnimatorSet animatorSet2;
        AnimatorSet animatorSet1;
        ArrayList arrayList3;
        ObjectAnimator objectAnimator7;
        ObjectAnimator objectAnimator4;
        ObjectAnimator objectAnimator3;
        ArrayList arrayList2;
        ObjectAnimator objectAnimator0;
        g g0 = this.D(view1.getContext(), z);
        if(z) {
            this.g = view0.getTranslationX();
            this.h = view0.getTranslationY();
        }
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        float f = M.e(view1) - M.e(view0);
        if(z) {
            if(!z1) {
                view1.setTranslationZ(-f);
            }
            objectAnimator0 = ObjectAnimator.ofFloat(view1, View.TRANSLATION_Z, new float[]{0.0f});
        }
        else {
            objectAnimator0 = ObjectAnimator.ofFloat(view1, View.TRANSLATION_Z, new float[]{-f});
        }
        ((f)g0.a).f("elevation").a(objectAnimator0);
        arrayList0.add(objectAnimator0);
        float f1 = this.z(view0, view1, ((h)g0.b));
        float f2 = this.A(view0, view1, ((h)g0.b));
        Pair pair0 = FabTransformationBehavior.y(f1, f2, z, g0);
        e6.g g1 = (e6.g)pair0.first;
        e6.g g2 = (e6.g)pair0.second;
        RectF rectF0 = this.e;
        Rect rect0 = this.c;
        RectF rectF1 = this.d;
        if(z) {
            if(!z1) {
                view1.setTranslationX(-f1);
                view1.setTranslationY(-f2);
            }
            arrayList2 = arrayList1;
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view1, View.TRANSLATION_X, new float[]{0.0f});
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view1, View.TRANSLATION_Y, new float[]{0.0f});
            float f3 = FabTransformationBehavior.B(g0, g1, -f1);
            float f4 = FabTransformationBehavior.B(g0, g2, -f2);
            view1.getWindowVisibleDisplayFrame(rect0);
            rectF1.set(rect0);
            this.C(view1, rectF0);
            rectF0.offset(f3, f4);
            rectF0.intersect(rectF1);
            rectF1.set(rectF0);
            objectAnimator3 = objectAnimator2;
            objectAnimator4 = objectAnimator1;
        }
        else {
            arrayList2 = arrayList1;
            objectAnimator4 = ObjectAnimator.ofFloat(view1, View.TRANSLATION_X, new float[]{-f1});
            objectAnimator3 = ObjectAnimator.ofFloat(view1, View.TRANSLATION_Y, new float[]{-f2});
        }
        g1.a(objectAnimator4);
        g2.a(objectAnimator3);
        arrayList0.add(objectAnimator4);
        arrayList0.add(objectAnimator3);
        float f5 = rectF1.width();
        float f6 = rectF1.height();
        float f7 = this.z(view0, view1, ((h)g0.b));
        float f8 = this.A(view0, view1, ((h)g0.b));
        Pair pair1 = FabTransformationBehavior.y(f7, f8, z, g0);
        e6.g g3 = (e6.g)pair1.first;
        e6.g g4 = (e6.g)pair1.second;
        Property property0 = View.TRANSLATION_X;
        if(!z) {
            f7 = this.g;
        }
        float f9 = f8;
        ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(view0, property0, new float[]{f7});
        Property property1 = View.TRANSLATION_Y;
        if(!z) {
            f9 = this.h;
        }
        ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(view0, property1, new float[]{f9});
        g3.a(objectAnimator5);
        g4.a(objectAnimator6);
        arrayList0.add(objectAnimator5);
        arrayList0.add(objectAnimator6);
        if(view1 instanceof e && view0 instanceof ImageView) {
            Drawable drawable0 = ((ImageView)view0).getDrawable();
            if(drawable0 == null) {
                arrayList3 = arrayList2;
            }
            else {
                drawable0.mutate();
                if(z) {
                    if(!z1) {
                        drawable0.setAlpha(0xFF);
                    }
                    objectAnimator7 = ObjectAnimator.ofInt(drawable0, d.a, new int[]{0});
                }
                else {
                    objectAnimator7 = ObjectAnimator.ofInt(drawable0, d.a, new int[]{0xFF});
                }
                objectAnimator7.addUpdateListener(new b(view1, 1));
                ((f)g0.a).f("iconFade").a(objectAnimator7);
                arrayList0.add(objectAnimator7);
                arrayList3 = arrayList2;
                arrayList3.add(new G6.c(0, ((e)view1), drawable0));
            }
        }
        else {
            arrayList3 = arrayList2;
        }
        if(view1 instanceof e) {
            h h0 = (h)g0.b;
            this.C(view0, rectF1);
            rectF1.offset(this.g, this.h);
            this.C(view1, rectF0);
            rectF0.offset(-this.z(view0, view1, h0), 0.0f);
            float f10 = rectF1.centerX() - rectF0.left;
            h h1 = (h)g0.b;
            this.C(view0, rectF1);
            z2 = view1 instanceof e;
            rectF1.offset(this.g, this.h);
            this.C(view1, rectF0);
            rectF0.offset(0.0f, -this.A(view0, view1, h1));
            float f11 = rectF1.centerY() - rectF0.top;
            if(((FloatingActionButton)view0).isLaidOut()) {
                rect0.set(0, 0, ((FloatingActionButton)view0).getWidth(), ((FloatingActionButton)view0).getHeight());
                ((FloatingActionButton)view0).j(rect0);
            }
            float f12 = ((float)rect0.width()) / 2.0f;
            e6.g g5 = ((f)g0.a).f("expansion");
            if(z) {
                if(!z1) {
                    ((e)view1).setRevealInfo(new m6.d(f10, f11, f12));
                }
                if(z1) {
                    f12 = ((e)view1).getRevealInfo().c;
                }
                AnimatorSet animatorSet0 = G.l(((e)view1), f10, f11, e2.a.A(f10, f11, f5, f6));
                animatorSet0.addListener(new G6.d(((e)view1), 0));
                long v = g5.a;
                if(v > 0L) {
                    Animator animator0 = ViewAnimationUtils.createCircularReveal(view1, ((int)f10), ((int)f11), f12, f12);
                    animatorSet1 = animatorSet0;
                    animator0.setStartDelay(0L);
                    animator0.setDuration(v);
                    arrayList0.add(animator0);
                }
                else {
                    animatorSet1 = animatorSet0;
                }
                animatorSet2 = animatorSet1;
            }
            else {
                float f13 = ((e)view1).getRevealInfo().c;
                AnimatorSet animatorSet3 = G.l(((e)view1), f10, f11, f12);
                long v1 = g5.a;
                if(v1 > 0L) {
                    Animator animator1 = ViewAnimationUtils.createCircularReveal(view1, ((int)f10), ((int)f11), f13, f13);
                    animator1.setStartDelay(0L);
                    animator1.setDuration(v1);
                    arrayList0.add(animator1);
                }
                long v2 = g5.a;
                long v3 = g5.b;
                V v4 = ((f)g0.a).a;
                int v5 = v4.size();
                long v6 = 0L;
                for(int v7 = 0; v7 < v5; ++v7) {
                    Object object0 = v4.valueAt(v7);
                    v6 = Math.max(v6, ((e6.g)object0).a + ((e6.g)object0).b);
                }
                long v8 = v2 + v3;
                if(v8 < v6) {
                    Animator animator2 = ViewAnimationUtils.createCircularReveal(view1, ((int)f10), ((int)f11), f12, f12);
                    animator2.setStartDelay(v8);
                    animator2.setDuration(v6 - v8);
                    arrayList0.add(animator2);
                }
                animatorSet2 = animatorSet3;
            }
            g5.a(animatorSet2);
            arrayList0.add(animatorSet2);
            arrayList3.add(new G6.d(((e)view1), 1));
        }
        else {
            z2 = view1 instanceof e;
        }
        if(z2) {
            ColorStateList colorStateList0 = M.c(view0);
            int v9 = colorStateList0 == null ? 0 : colorStateList0.getColorForState(view0.getDrawableState(), colorStateList0.getDefaultColor());
            if(z) {
                if(!z1) {
                    ((e)view1).setCircularRevealScrimColor(v9);
                }
                objectAnimator8 = ObjectAnimator.ofInt(((e)view1), m6.c.a, new int[]{0xFFFFFF & v9});
            }
            else {
                objectAnimator8 = ObjectAnimator.ofInt(((e)view1), m6.c.a, new int[]{v9});
            }
            objectAnimator8.setEvaluator(e6.b.a);
            ((f)g0.a).f("color").a(objectAnimator8);
            arrayList0.add(objectAnimator8);
        }
        if(view1 instanceof ViewGroup) {
            View view2 = view1.findViewById(0x7F0A0874);  // id:mtrl_child_content_container
            ViewGroup viewGroup0 = null;
            if(view2 == null) {
                if(view1 instanceof TransformationChildLayout || view1 instanceof TransformationChildCard) {
                    View view3 = ((ViewGroup)view1).getChildAt(0);
                    if(view3 instanceof ViewGroup) {
                        viewGroup0 = (ViewGroup)view3;
                    }
                }
                else {
                    viewGroup0 = (ViewGroup)view1;
                }
            }
            else if(view2 instanceof ViewGroup) {
                viewGroup0 = (ViewGroup)view2;
            }
            if(viewGroup0 != null) {
                if(z) {
                    if(!z1) {
                        e6.c.a.set(viewGroup0, 0.0f);
                    }
                    objectAnimator9 = ObjectAnimator.ofFloat(viewGroup0, e6.c.a, new float[]{1.0f});
                }
                else {
                    objectAnimator9 = ObjectAnimator.ofFloat(viewGroup0, e6.c.a, new float[]{0.0f});
                }
                ((f)g0.a).f("contentFade").a(objectAnimator9);
                arrayList0.add(objectAnimator9);
            }
        }
        AnimatorSet animatorSet4 = new AnimatorSet();
        n.y(animatorSet4, arrayList0);
        animatorSet4.addListener(new G6.b(z, view1, view0));
        int v10 = arrayList3.size();
        for(int v11 = 0; v11 < v10; ++v11) {
            animatorSet4.addListener(((Animator.AnimatorListener)arrayList3.get(v11)));
        }
        return animatorSet4;
    }

    public static Pair y(float f, float f1, boolean z, g g0) {
        if(f != 0.0f) {
            int v = Float.compare(f1, 0.0f);
            if(v != 0) {
                return (!z || f1 >= 0.0f) && (z || v <= 0) ? new Pair(((f)g0.a).f("translationXCurveDownwards"), ((f)g0.a).f("translationYCurveDownwards")) : new Pair(((f)g0.a).f("translationXCurveUpwards"), ((f)g0.a).f("translationYCurveUpwards"));
            }
        }
        return new Pair(((f)g0.a).f("translationXLinear"), ((f)g0.a).f("translationYLinear"));
    }

    public final float z(View view0, View view1, h h0) {
        this.C(view0, this.d);
        this.d.offset(this.g, this.h);
        this.C(view1, this.e);
        h0.getClass();
        return this.e.centerX() - this.d.centerX() + 0.0f;
    }
}

