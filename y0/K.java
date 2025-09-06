package y0;

import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import androidx.appcompat.app.o;

public final class k extends t {
    public final long b;
    public final int c;

    public k(long v, int v1) {
        BlendModeColorFilter blendModeColorFilter0 = Build.VERSION.SDK_INT >= 29 ? a.c(M.z(v), M.u(v1)) : new PorterDuffColorFilter(M.z(v), M.C(v1));
        super(blendModeColorFilter0);
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        return s.d(this.b, ((k)object0).b) ? this.c == ((k)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + Long.hashCode(this.b) * 0x1F;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("BlendModeColorFilter(color=");
        o.x(this.b, ", blendMode=", stringBuilder0);
        switch(this.c) {
            case 0: {
                s = "Clear";
                break;
            }
            case 1: {
                s = "Src";
                break;
            }
            case 2: {
                s = "Dst";
                break;
            }
            case 3: {
                s = "SrcOver";
                break;
            }
            case 4: {
                s = "DstOver";
                break;
            }
            case 5: {
                s = "SrcIn";
                break;
            }
            case 6: {
                s = "DstIn";
                break;
            }
            case 7: {
                s = "SrcOut";
                break;
            }
            case 8: {
                s = "DstOut";
                break;
            }
            case 9: {
                s = "SrcAtop";
                break;
            }
            case 10: {
                s = "DstAtop";
                break;
            }
            case 11: {
                s = "Xor";
                break;
            }
            case 12: {
                s = "Plus";
                break;
            }
            case 13: {
                s = "Modulate";
                break;
            }
            case 14: {
                s = "Screen";
                break;
            }
            case 15: {
                s = "Overlay";
                break;
            }
            case 16: {
                s = "Darken";
                break;
            }
            case 17: {
                s = "Lighten";
                break;
            }
            case 18: {
                s = "ColorDodge";
                break;
            }
            case 19: {
                s = "ColorBurn";
                break;
            }
            case 20: {
                s = "HardLight";
                break;
            }
            case 21: {
                s = "Softlight";
                break;
            }
            case 22: {
                s = "Difference";
                break;
            }
            case 23: {
                s = "Exclusion";
                break;
            }
            case 24: {
                s = "Multiply";
                break;
            }
            case 25: {
                s = "Hue";
                break;
            }
            case 26: {
                s = "Saturation";
                break;
            }
            case 27: {
                s = "Color";
                break;
            }
            case 28: {
                s = "Luminosity";
                break;
            }
            default: {
                s = "Unknown";
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

