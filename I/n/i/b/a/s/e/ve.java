package i.n.i.b.a.s.e;

import U4.x;
import android.text.Layout.Alignment;

public final class ve {
    public long a;
    public long b;
    public CharSequence c;
    public int d;
    public float e;
    public int f;
    public int g;
    public float h;
    public int i;
    public float j;
    public int k;
    public String l;

    public ve() {
        this.a = 0L;
        this.b = 0L;
        this.d = 2;
        this.e = -3.402823E+38f;
        this.f = 1;
        this.g = 0;
        this.h = -3.402823E+38f;
        this.i = 0x80000000;
        this.j = 1.0f;
        this.k = 0x80000000;
        this.l = null;
    }

    public final E3 a() {
        Layout.Alignment layout$Alignment0;
        float f = this.h;
        float f1 = -3.402823E+38f;
        if(Float.compare(f, -3.402823E+38f) == 0) {
            switch(this.d) {
                case 4: {
                    f = 0.0f;
                    break;
                }
                case 5: {
                    f = 1.0f;
                    break;
                }
                default: {
                    f = 0.5f;
                }
            }
        }
        int v = this.i;
        if(v == 0x80000000) {
            switch(this.d) {
                case 1: 
                case 4: {
                    v = 0;
                    break;
                }
                case 3: 
                case 5: {
                    v = 2;
                    break;
                }
                default: {
                    v = 1;
                }
            }
        }
        E3 e30 = new E3();
        int v1 = this.d;
        switch(v1) {
            case 2: {
                layout$Alignment0 = Layout.Alignment.ALIGN_CENTER;
                break;
            }
            case 1: 
            case 4: {
                layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                break;
            }
            case 3: 
            case 5: {
                layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                break;
            }
            default: {
                x.u(v1, "Unknown textAlignment: ", "WebvttCueParser");
                layout$Alignment0 = null;
            }
        }
        e30.c = layout$Alignment0;
        float f2 = this.e;
        int v2 = this.f;
        int v3 = Float.compare(f2, -3.402823E+38f);
        if(v3 != 0 && v2 == 0 && (f2 < 0.0f || f2 > 1.0f)) {
            f1 = 1.0f;
        }
        else if(v3 != 0) {
            f1 = f2;
        }
        else if(v2 == 0) {
            f1 = 1.0f;
        }
        e30.e = f1;
        e30.f = v2;
        e30.g = this.g;
        e30.h = f;
        e30.i = v;
        float f3 = this.j;
        switch(v) {
            case 0: {
                f = 1.0f - f;
                break;
            }
            case 1: {
                f = Float.compare(f, 0.5f) > 0 ? (1.0f - f) * 2.0f : f * 2.0f;
                break;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException(String.valueOf(v));
            }
        }
        e30.l = Math.min(f3, f);
        e30.p = this.k;
        e30.r = this.l;
        CharSequence charSequence0 = this.c;
        if(charSequence0 != null) {
            e30.a = charSequence0;
        }
        return e30;
    }
}

