package androidx.transition;

import N4.D;
import N4.L;
import N4.Z;
import N4.b0;
import N4.b;
import N4.h;
import N4.i;
import N4.j;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.HashMap;

public class ChangeImageTransform extends Transition {
    public static final String[] b0;
    public static final h c0;
    public static final b d0;

    static {
        ChangeImageTransform.b0 = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
        ChangeImageTransform.c0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        ChangeImageTransform.d0 = new b("animatedTransform", 5, Matrix.class);
    }

    public ChangeImageTransform(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public static void O(b0 b00, boolean z) {
        Matrix matrix1;
        View view0 = b00.b;
        if(view0 instanceof ImageView && view0.getVisibility() == 0 && ((ImageView)view0).getDrawable() != null) {
            HashMap hashMap0 = b00.a;
            hashMap0.put("android:changeImageTransform:bounds", new Rect(view0.getLeft(), view0.getTop(), view0.getRight(), view0.getBottom()));
            Matrix matrix0 = z ? ((Matrix)((ImageView)view0).getTag(0x7F0A0BE0)) : null;  // id:transition_image_transform
            if(matrix0 == null) {
                Drawable drawable0 = ((ImageView)view0).getDrawable();
                if(drawable0.getIntrinsicWidth() <= 0 || drawable0.getIntrinsicHeight() <= 0) {
                    matrix0 = new Matrix(((ImageView)view0).getImageMatrix());
                }
                else {
                    switch(i.a[((ImageView)view0).getScaleType().ordinal()]) {
                        case 1: {
                            Drawable drawable1 = ((ImageView)view0).getDrawable();
                            matrix1 = new Matrix();
                            matrix1.postScale(((float)((ImageView)view0).getWidth()) / ((float)drawable1.getIntrinsicWidth()), ((float)((ImageView)view0).getHeight()) / ((float)drawable1.getIntrinsicHeight()));
                            break;
                        }
                        case 2: {
                            Drawable drawable2 = ((ImageView)view0).getDrawable();
                            int v = drawable2.getIntrinsicWidth();
                            float f = (float)((ImageView)view0).getWidth();
                            int v1 = drawable2.getIntrinsicHeight();
                            float f1 = (float)((ImageView)view0).getHeight();
                            float f2 = Math.max(f / ((float)v), f1 / ((float)v1));
                            matrix1 = new Matrix();
                            matrix1.postScale(f2, f2);
                            matrix1.postTranslate(((float)Math.round((f - ((float)v) * f2) / 2.0f)), ((float)Math.round((f1 - ((float)v1) * f2) / 2.0f)));
                            break;
                        }
                        default: {
                            matrix0 = new Matrix(((ImageView)view0).getImageMatrix());
                            hashMap0.put("android:changeImageTransform:matrix", matrix0);
                            return;
                        }
                    }
                    matrix0 = matrix1;
                }
            }
            hashMap0.put("android:changeImageTransform:matrix", matrix0);
        }
    }

    @Override  // androidx.transition.Transition
    public final void d(b0 b00) {
        ChangeImageTransform.O(b00, false);
    }

    @Override  // androidx.transition.Transition
    public final void g(b0 b00) {
        ChangeImageTransform.O(b00, true);
    }

    @Override  // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        if(b00 != null) {
            HashMap hashMap0 = b00.a;
            if(b01 != null) {
                HashMap hashMap1 = b01.a;
                Rect rect0 = (Rect)hashMap0.get("android:changeImageTransform:bounds");
                Rect rect1 = (Rect)hashMap1.get("android:changeImageTransform:bounds");
                if(rect0 != null && rect1 != null) {
                    Matrix matrix0 = (Matrix)hashMap0.get("android:changeImageTransform:matrix");
                    Matrix matrix1 = (Matrix)hashMap1.get("android:changeImageTransform:matrix");
                    boolean z = matrix0 == null && matrix1 == null || matrix0 != null && matrix0.equals(matrix1);
                    if(!rect0.equals(rect1) || !z) {
                        ImageView imageView0 = (ImageView)b01.b;
                        Drawable drawable0 = imageView0.getDrawable();
                        int v = drawable0.getIntrinsicWidth();
                        int v1 = drawable0.getIntrinsicHeight();
                        b b0 = ChangeImageTransform.d0;
                        if(v > 0 && v1 > 0) {
                            if(matrix0 == null) {
                                matrix0 = D.a;
                            }
                            if(matrix1 == null) {
                                matrix1 = D.a;
                            }
                            b0.getClass();
                            L.c(imageView0, matrix0);
                            Animator animator0 = ObjectAnimator.ofObject(imageView0, b0, new Z(), new Matrix[]{matrix0, matrix1});
                            j j0 = new j(imageView0, matrix0, matrix1);
                            animator0.addListener(j0);
                            animator0.addPauseListener(j0);
                            this.a(j0);
                            return animator0;
                        }
                        return ObjectAnimator.ofObject(imageView0, b0, ChangeImageTransform.c0, new Matrix[]{D.a, D.a});
                    }
                }
            }
        }
        return null;
    }

    @Override  // androidx.transition.Transition
    public final String[] q() {
        return ChangeImageTransform.b0;
    }

    @Override  // androidx.transition.Transition
    public final boolean t() {
        return true;
    }
}

