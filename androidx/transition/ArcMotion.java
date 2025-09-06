package androidx.transition;

import N4.L;
import R1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    public final float a;
    public final float b;
    public final float c;
    public static final float d;

    static {
        ArcMotion.d = 0.700208f;
    }

    public ArcMotion(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        float f = 0.0f;
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = ArcMotion.d;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.h);
        this.b = ArcMotion.b((a.f(((XmlPullParser)attributeSet0), "minimumVerticalAngle") ? typedArray0.getFloat(1, 0.0f) : 0.0f));
        if(((XmlPullParser)attributeSet0).getAttributeValue("http://schemas.android.com/apk/res/android", "minimumHorizontalAngle") != null) {
            f = typedArray0.getFloat(0, 0.0f);
        }
        this.a = ArcMotion.b(f);
        this.c = ArcMotion.b((((XmlPullParser)attributeSet0).getAttributeValue("http://schemas.android.com/apk/res/android", "maximumAngle") == null ? 70.0f : typedArray0.getFloat(2, 70.0f)));
        typedArray0.recycle();
    }

    @Override  // androidx.transition.PathMotion
    public final Path a(float f, float f1, float f2, float f3) {
        float f12;
        float f11;
        float f10;
        Path path0 = new Path();
        path0.moveTo(f, f1);
        float f4 = f2 - f;
        float f5 = f3 - f1;
        float f6 = f5 * f5 + f4 * f4;
        float f7 = (f + f2) / 2.0f;
        float f8 = (f1 + f3) / 2.0f;
        boolean z = f1 > f3;
        if(Math.abs(f4) < Math.abs(f5)) {
            float f9 = Math.abs(f6 / (f5 * 2.0f));
            if(z) {
                f10 = f9 + f3;
                f11 = f2;
            }
            else {
                f10 = f9 + f1;
                f11 = f;
            }
            f12 = this.b;
        }
        else {
            float f13 = f6 / (f4 * 2.0f);
            if(z) {
                f10 = f1;
                f11 = f13 + f;
            }
            else {
                f11 = f2 - f13;
                f10 = f3;
            }
            f12 = this.a;
        }
        float f14 = 0.25f * f6 * f12 * f12;
        float f15 = (f8 - f10) * (f8 - f10) + (f7 - f11) * (f7 - f11);
        float f16 = 0.25f * f6 * this.c * this.c;
        if(Float.compare(f15, f14) >= 0) {
            f14 = f15 > f16 ? f16 : 0.0f;
        }
        if(f14 != 0.0f) {
            float f17 = (float)Math.sqrt(f14 / f15);
            f11 = (f11 - f7) * f17 + f7;
            f10 = (f10 - f8) * f17 + f8;
        }
        path0.cubicTo((f + f11) / 2.0f, (f1 + f10) / 2.0f, (f11 + f2) / 2.0f, (f10 + f3) / 2.0f, f2, f3);
        return path0;
    }

    public static float b(float f) {
        if(f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float)Math.tan(Math.toRadians(f / 2.0f));
    }
}

