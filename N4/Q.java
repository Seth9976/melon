package N4;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import com.iloen.melon.utils.a;

public final class q implements TypeEvaluator {
    public final int a;
    public Object b;

    public q(int v) {
        this.a = v;
        super();
    }

    @Override  // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object object0, Object object1) {
        if(this.a != 0) {
            float f1 = (float)((FloatEvaluator)this.b).evaluate(f, ((Float)object0), ((Float)object1));
            if(f1 < 0.1f) {
                f1 = 0.0f;
            }
            return f1;
        }
        float[] arr_f = (float[])this.b;
        if(arr_f == null) {
            arr_f = new float[((float[])object0).length];
        }
        for(int v = 0; v < arr_f.length; ++v) {
            float f2 = ((float[])object0)[v];
            arr_f[v] = a.c(((float[])object1)[v], f2, f, f2);
        }
        return arr_f;
    }
}

