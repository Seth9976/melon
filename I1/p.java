package I1;

import A1.e;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class p extends q {
    public boolean k;

    @Override  // I1.q
    public final boolean d(float f, long v, e e0, View view0) {
        Method method0;
        if(view0 instanceof MotionLayout) {
            ((MotionLayout)view0).setProgress(this.b(f, v, e0, view0));
            return this.h;
        }
        if(this.k) {
            return false;
        }
        try {
            method0 = view0.getClass().getMethod("setProgress", Float.TYPE);
        }
        catch(NoSuchMethodException unused_ex) {
            this.k = true;
            method0 = null;
        }
        if(method0 != null) {
            try {
                method0.invoke(view0, this.b(f, v, e0, view0));
            }
            catch(IllegalAccessException illegalAccessException0) {
                Log.e("ViewTimeCycle", "unable to setProgress", illegalAccessException0);
            }
            catch(InvocationTargetException invocationTargetException0) {
                Log.e("ViewTimeCycle", "unable to setProgress", invocationTargetException0);
            }
            return this.h;
        }
        return this.h;
    }
}

