package androidx.transition;

import N4.L;
import R1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import com.google.firebase.b;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    public final Path a;
    public final Matrix b;

    public PatternPathMotion(Context context0, AttributeSet attributeSet0) {
        this.a = new Path();
        this.b = new Matrix();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.i);
        try {
            String s = a.e(typedArray0, ((XmlPullParser)attributeSet0), "patternPathData", 0);
            if(s != null) {
                this.b(b.y(s));
                return;
            }
        }
        finally {
            typedArray0.recycle();
        }
        throw new RuntimeException("pathData must be supplied for patternPathMotion");
    }

    @Override  // androidx.transition.PathMotion
    public final Path a(float f, float f1, float f2, float f3) {
        float f4 = f2 - f;
        float f5 = f3 - f1;
        float f6 = (float)Math.sqrt(f5 * f5 + f4 * f4);
        this.b.setScale(f6, f6);
        this.b.postRotate(((float)Math.toDegrees(Math.atan2(f5, f4))));
        this.b.postTranslate(f, f1);
        Path path0 = new Path();
        this.a.transform(this.b, path0);
        return path0;
    }

    public final void b(Path path0) {
        PathMeasure pathMeasure0 = new PathMeasure(path0, false);
        float f = pathMeasure0.getLength();
        float[] arr_f = new float[2];
        pathMeasure0.getPosTan(f, arr_f, null);
        float f1 = arr_f[0];
        float f2 = arr_f[1];
        pathMeasure0.getPosTan(0.0f, arr_f, null);
        float f3 = arr_f[0];
        float f4 = arr_f[1];
        if(f3 == f1 && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.b.setTranslate(-f3, -f4);
        float f5 = f1 - f3;
        float f6 = f2 - f4;
        float f7 = 1.0f / ((float)Math.sqrt(f6 * f6 + f5 * f5));
        this.b.postScale(f7, f7);
        this.b.postRotate(((float)Math.toDegrees(-Math.atan2(f6, f5))));
        path0.transform(this.b, this.a);
    }
}

