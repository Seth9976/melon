package b3;

import U4.x;
import java.util.Arrays;

public final class i {
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    public final int e;
    public final int f;
    public int g;
    public static final i h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;

    static {
        i.h = new i(1, 2, 3, -1, -1, null);
        i.i = "0";
        i.j = "1";
        i.k = "2";
        i.l = "3";
        i.m = "4";
        i.n = "5";
    }

    public i(int v, int v1, int v2, int v3, int v4, byte[] arr_b) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = arr_b;
        this.e = v3;
        this.f = v4;
    }

    public static String a(int v) {
        switch(v) {
            case -1: {
                return "Unset color range";
            }
            case 1: {
                return "Full range";
            }
            case 2: {
                return "Limited range";
            }
            default: {
                return "Undefined color range " + v;
            }
        }
    }

    public static String b(int v) {
        switch(v) {
            case -1: {
                return "Unset color space";
            }
            case 1: {
                return "BT709";
            }
            case 2: {
                return "BT601";
            }
            case 6: {
                return "BT2020";
            }
            default: {
                return "Undefined color space " + v;
            }
        }
    }

    public static String c(int v) {
        switch(v) {
            case -1: {
                return "Unset color transfer";
            }
            case 1: {
                return "Linear";
            }
            case 2: {
                return "sRGB";
            }
            case 3: {
                return "SDR SMPTE 170M";
            }
            case 6: {
                return "ST2084 PQ";
            }
            case 7: {
                return "HLG";
            }
            case 10: {
                return "Gamma 2.2";
            }
            default: {
                return "Undefined color transfer " + v;
            }
        }
    }

    public final boolean d() {
        return this.a != -1 && this.b != -1 && this.c != -1;
    }

    public static boolean e(i i0) {
        return i0 == null ? true : (i0.a == -1 || i0.a == 1 || i0.a == 2) && (i0.b == -1 || i0.b == 2) && (i0.c == -1 || i0.c == 3) && i0.d == null && (i0.f == -1 || i0.f == 8) && (i0.e == -1 || i0.e == 8);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return i.class == class0 && this.a == ((i)object0).a && this.b == ((i)object0).b && this.c == ((i)object0).c && Arrays.equals(this.d, ((i)object0).d) && this.e == ((i)object0).e && this.f == ((i)object0).f;
        }
        return false;
    }

    public static int f(int v) {
        switch(v) {
            case 1: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 9: {
                return 6;
            }
            default: {
                return v == 5 || v == 6 || v == 7 ? 2 : -1;
            }
        }
    }

    public static int g(int v) {
        switch(v) {
            case 4: {
                return 10;
            }
            case 1: 
            case 6: 
            case 7: {
                return 3;
            }
            case 13: {
                return 2;
            }
            case 16: {
                return 6;
            }
            case 18: {
                return 7;
            }
            default: {
                return -1;
            }
        }
    }

    @Override
    public final int hashCode() {
        if(this.g == 0) {
            this.g = ((Arrays.hashCode(this.d) + (((this.a + 0x20F) * 0x1F + this.b) * 0x1F + this.c) * 0x1F) * 0x1F + this.e) * 0x1F + this.f;
        }
        return this.g;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ColorInfo(");
        stringBuilder0.append(i.b(this.a));
        stringBuilder0.append(", ");
        stringBuilder0.append(i.a(this.b));
        stringBuilder0.append(", ");
        stringBuilder0.append(i.c(this.c));
        stringBuilder0.append(", ");
        stringBuilder0.append(this.d != null);
        stringBuilder0.append(", ");
        String s = "NA";
        stringBuilder0.append((this.e == -1 ? "NA" : this.e + "bit Luma"));
        stringBuilder0.append(", ");
        int v = this.f;
        if(v != -1) {
            s = v + "bit Chroma";
        }
        return x.m(stringBuilder0, s, ")");
    }
}

