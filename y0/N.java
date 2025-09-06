package y0;

import A7.d;
import android.graphics.RenderEffect;
import t0.b;

public final class n {
    public RenderEffect a;
    public final float b;
    public final float c;
    public final int d;

    public n(float f, float f1, int v) {
        this.b = f;
        this.c = f1;
        this.d = v;
    }

    public final RenderEffect a() {
        RenderEffect renderEffect0 = this.a;
        if(renderEffect0 == null) {
            renderEffect0 = Float.compare(this.b, 0.0f) != 0 || this.c != 0.0f ? RenderEffect.createBlurEffect(this.b, this.c, M.y(this.d)) : b.a();
            this.a = renderEffect0;
        }
        return renderEffect0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n && this.b == ((n)object0).b && this.c == ((n)object0).c && this.d == ((n)object0).d;
    }

    @Override
    public final int hashCode() {
        return this.d + d.a(this.c, Float.hashCode(this.b) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("BlurEffect(renderEffect=null, radiusX=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", radiusY=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", edgeTreatment=");
        int v = this.d;
        if(v == 0) {
            s = "Clamp";
        }
        else {
            switch(v) {
                case 1: {
                    s = "Repeated";
                    break;
                }
                case 2: {
                    s = "Mirror";
                    break;
                }
                case 3: {
                    s = "Decal";
                    break;
                }
                default: {
                    s = "Unknown";
                }
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

