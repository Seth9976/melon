package e6;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.collection.V;
import java.util.ArrayList;

public final class f {
    public final V a;
    public final V b;

    public f() {
        this.a = new V(0);
        this.b = new V(0);
    }

    public static f a(Context context0, TypedArray typedArray0, int v) {
        if(typedArray0.hasValue(v)) {
            int v1 = typedArray0.getResourceId(v, 0);
            return v1 == 0 ? null : f.b(context0, v1);
        }
        return null;
    }

    public static f b(Context context0, int v) {
        try {
            Animator animator0 = AnimatorInflater.loadAnimator(context0, v);
            if(animator0 instanceof AnimatorSet) {
                return f.c(((AnimatorSet)animator0).getChildAnimations());
            }
            if(animator0 != null) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(animator0);
                return f.c(arrayList0);
            }
            return null;
        }
        catch(Exception exception0) {
        }
        Log.w("MotionSpec", "Can\'t load animation resource ID #0x" + Integer.toHexString(v), exception0);
        return null;
    }

    public static f c(ArrayList arrayList0) {
        f f0 = new f();
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Animator animator0 = (Animator)arrayList0.get(v1);
            if(!(animator0 instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator0);
            }
            f0.h(((ObjectAnimator)animator0).getPropertyName(), ((ObjectAnimator)animator0).getValues());
            String s = ((ObjectAnimator)animator0).getPropertyName();
            long v2 = ((ObjectAnimator)animator0).getStartDelay();
            long v3 = ((ObjectAnimator)animator0).getDuration();
            TimeInterpolator timeInterpolator0 = ((ObjectAnimator)animator0).getInterpolator();
            if(timeInterpolator0 instanceof AccelerateDecelerateInterpolator || timeInterpolator0 == null) {
                timeInterpolator0 = a.b;
            }
            else if(timeInterpolator0 instanceof AccelerateInterpolator) {
                timeInterpolator0 = a.c;
            }
            else if(timeInterpolator0 instanceof DecelerateInterpolator) {
                timeInterpolator0 = a.d;
            }
            g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
            g0.e = 1;
            g0.a = v2;
            g0.b = v3;
            g0.c = timeInterpolator0;
            g0.d = ((ObjectAnimator)animator0).getRepeatCount();
            g0.e = ((ObjectAnimator)animator0).getRepeatMode();
            f0.a.put(s, g0);
        }
        return f0;
    }

    public final ObjectAnimator d(String s, Object object0, Property property0) {
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofPropertyValuesHolder(object0, this.e(s));
        objectAnimator0.setProperty(property0);
        this.f(s).a(objectAnimator0);
        return objectAnimator0;
    }

    public final PropertyValuesHolder[] e(String s) {
        if(!this.g(s)) {
            throw new IllegalArgumentException();
        }
        PropertyValuesHolder[] arr_propertyValuesHolder = (PropertyValuesHolder[])this.b.get(s);
        PropertyValuesHolder[] arr_propertyValuesHolder1 = new PropertyValuesHolder[arr_propertyValuesHolder.length];
        for(int v = 0; v < arr_propertyValuesHolder.length; ++v) {
            arr_propertyValuesHolder1[v] = arr_propertyValuesHolder[v].clone();
        }
        return arr_propertyValuesHolder1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? this.a.equals(((f)object0).a) : false;
    }

    public final g f(String s) {
        V v0 = this.a;
        if(v0.get(s) == null) {
            throw new IllegalArgumentException();
        }
        return (g)v0.get(s);
    }

    public final boolean g(String s) {
        return this.b.get(s) != null;
    }

    public final void h(String s, PropertyValuesHolder[] arr_propertyValuesHolder) {
        this.b.put(s, arr_propertyValuesHolder);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    // 去混淆评级： 低(40)
    @Override
    public final String toString() {
        return "\ne6.f" + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }
}

