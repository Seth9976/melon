package androidx.recyclerview.widget;

import android.text.TextUtils;
import e3.b;
import h7.u0;
import i.n.i.b.a.s.e.M7;

public final class X0 {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public X0(int v, int v1, int v2, int v3, int v4) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = v4;
        super();
    }

    // This method was un-flattened
    public static X0 a(String s) {
        M7.u(s.startsWith("Format:"));
        String[] arr_s = TextUtils.split(s.substring(7), ",");
        int v = -1;
        int v1 = -1;
        int v2 = -1;
        int v3 = -1;
        for(int v4 = 0; v4 < arr_s.length; ++v4) {
            String s1 = M7.j(arr_s[v4].trim());
            s1.getClass();
            switch(s1) {
                case "end": {
                    v1 = v4;
                    break;
                }
                case "start": {
                    v = v4;
                    break;
                }
                case "style": {
                    v2 = v4;
                    break;
                }
                case "text": {
                    v3 = v4;
                }
            }
        }
        return v == -1 || v1 == -1 || v3 == -1 ? null : new X0(v, v1, v2, v3, arr_s.length);
    }

    public boolean b() {
        int v10;
        int v7;
        int v4;
        int v = this.a;
        int v1 = 2;
        if((v & 7) != 0) {
            int v2 = this.d;
            int v3 = this.b;
            if(v2 > v3) {
                v4 = 1;
            }
            else {
                v4 = v2 == v3 ? 2 : 4;
            }
            if((v4 & v) != 0) {
                goto label_10;
            }
            return false;
        }
    label_10:
        if((v & 0x70) != 0) {
            int v5 = this.d;
            int v6 = this.c;
            if(v5 > v6) {
                v7 = 1;
            }
            else {
                v7 = v5 == v6 ? 2 : 4;
            }
            if((v7 << 4 & v) != 0) {
                goto label_18;
            }
            return false;
        }
    label_18:
        if((v & 0x700) != 0) {
            int v8 = this.e;
            int v9 = this.b;
            if(v8 > v9) {
                v10 = 1;
            }
            else {
                v10 = v8 == v9 ? 2 : 4;
            }
            if((v10 << 8 & v) == 0) {
                return false;
            }
        }
        if((v & 0x7000) != 0) {
            int v11 = this.e;
            int v12 = this.c;
            if(v11 > v12) {
                return (v & 0x1000) != 0;
            }
            if(v11 != v12) {
                v1 = 4;
            }
            return (v & v1 << 12) != 0;
        }
        return true;
    }

    // This method was un-flattened
    public static X0 c(String s) {
        b.c(s.startsWith("Format:"));
        String[] arr_s = TextUtils.split(s.substring(7), ",");
        int v = -1;
        int v1 = -1;
        int v2 = -1;
        int v3 = -1;
        for(int v4 = 0; v4 < arr_s.length; ++v4) {
            String s1 = u0.U(arr_s[v4].trim());
            s1.getClass();
            switch(s1) {
                case "end": {
                    v1 = v4;
                    break;
                }
                case "start": {
                    v = v4;
                    break;
                }
                case "style": {
                    v2 = v4;
                    break;
                }
                case "text": {
                    v3 = v4;
                }
            }
        }
        return v == -1 || v1 == -1 || v3 == -1 ? null : new X0(v, v1, v2, v3, arr_s.length);
    }
}

