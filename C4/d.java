package c4;

import android.graphics.Color;
import com.iloen.melon.utils.a;
import e3.b;

public final class d {
    public final String a;
    public final int b;
    public final Integer c;
    public final Integer d;
    public final float e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;

    public d(String s, int v, Integer integer0, Integer integer1, float f, boolean z, boolean z1, boolean z2, boolean z3, int v1) {
        this.a = s;
        this.b = v;
        this.c = integer0;
        this.d = integer1;
        this.e = f;
        this.f = z;
        this.g = z1;
        this.h = z2;
        this.i = z3;
        this.j = v1;
    }

    public static int a(String s) {
        boolean z;
        try {
            int v = Integer.parseInt(s.trim());
            switch(v) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: {
                    z = true;
                    break;
                }
                default: {
                    z = false;
                }
            }
            if(z) {
                return v;
            }
        }
        catch(NumberFormatException unused_ex) {
        }
        a.w("Ignoring unknown alignment: ", s, "SsaStyle");
        return -1;
    }

    public static boolean b(String s) {
        try {
            int v = Integer.parseInt(s);
            return v == -1 || v == 1;
        }
        catch(NumberFormatException numberFormatException0) {
            b.E("SsaStyle", "Failed to parse boolean value: \'" + s + "\'", numberFormatException0);
            return false;
        }
    }

    public static Integer c(String s) {
        long v;
        try {
            v = s.startsWith("&H") ? Long.parseLong(s.substring(2), 16) : Long.parseLong(s);
            b.c(v <= 0xFFFFFFFFL);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            b.E("SsaStyle", "Failed to parse color expression: \'" + s + "\'", illegalArgumentException0);
            return null;
        }
        int v1 = ye.a.t(v >> 24 & 0xFFL ^ 0xFFL);
        int v2 = ye.a.t(v >> 16 & 0xFFL);
        int v3 = ye.a.t(v >> 8 & 0xFFL);
        return Color.argb(v1, ye.a.t(v & 0xFFL), v3, v2);
    }
}

