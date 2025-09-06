package e8;

import U4.x;
import a8.b;
import d5.w;
import java.util.EnumMap;

public final class f extends w {
    public final int g;

    public f(int v) {
        this.g = v;
        super();
    }

    @Override  // d5.w
    public final int A() {
        return 9;
    }

    @Override  // d5.w
    public final b p(String s, int v, EnumMap enumMap0) {
        switch(this.g) {
            case 0: {
                if(v != 8) {
                    throw new IllegalArgumentException("Can only encode EAN_13, but got " + x.C(v));
                }
                return super.p(s, 8, enumMap0);
            }
            case 1: {
                if(v != 7) {
                    throw new IllegalArgumentException("Can only encode EAN_8, but got " + x.C(v));
                }
                return super.p(s, 7, enumMap0);
            }
            default: {
                if(v != 16) {
                    throw new IllegalArgumentException("Can only encode UPC_E, but got " + x.C(v));
                }
                return super.p(s, 16, enumMap0);
            }
        }
    }

    @Override  // d5.w
    public final boolean[] w(String s) {
        switch(this.g) {
            case 0: {
                int v5 = s.length();
                switch(v5) {
                    case 12: {
                        try {
                            s = s + h.v(s);
                            break;
                        }
                        catch(X7.b b1) {
                            throw new IllegalArgumentException(b1);
                        }
                    }
                    case 13: {
                        try {
                            if(!h.u(s)) {
                                throw new IllegalArgumentException("Contents do not pass checksum");
                            }
                            break;
                        }
                        catch(X7.b unused_ex) {
                            throw new IllegalArgumentException("Illegal contents");
                        }
                    }
                    default: {
                        throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + v5);
                    }
                }
                int v6 = e.n[Character.digit(s.charAt(0), 10)];
                boolean[] arr_z1 = new boolean[0x5F];
                int v7 = w.o(arr_z1, 0, h.i, true);
                for(int v8 = 1; v8 <= 6; ++v8) {
                    v7 += w.o(arr_z1, v7, h.m[((v6 >> 6 - v8 & 1) == 1 ? Character.digit(s.charAt(v8), 10) + 10 : Character.digit(s.charAt(v8), 10))], false);
                }
                int v9 = w.o(arr_z1, v7, h.j, false) + v7;
                for(int v10 = 7; v10 <= 12; ++v10) {
                    v9 += w.o(arr_z1, v9, h.l[Character.digit(s.charAt(v10), 10)], true);
                }
                w.o(arr_z1, v9, h.i, true);
                return arr_z1;
            }
            case 1: {
                int v11 = s.length();
                switch(v11) {
                    case 7: {
                        try {
                            s = s + h.v(s);
                            break;
                        }
                        catch(X7.b b2) {
                            throw new IllegalArgumentException(b2);
                        }
                    }
                    case 8: {
                        try {
                            if(!h.u(s)) {
                                throw new IllegalArgumentException("Contents do not pass checksum");
                            }
                            break;
                        }
                        catch(X7.b unused_ex) {
                            throw new IllegalArgumentException("Illegal contents");
                        }
                    }
                    default: {
                        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + v11);
                    }
                }
                boolean[] arr_z2 = new boolean[67];
                int v12 = w.o(arr_z2, 0, h.i, true);
                for(int v13 = 0; v13 <= 3; ++v13) {
                    v12 += w.o(arr_z2, v12, h.l[Character.digit(s.charAt(v13), 10)], false);
                }
                int v14 = w.o(arr_z2, v12, h.j, false) + v12;
                for(int v15 = 4; v15 <= 7; ++v15) {
                    v14 += w.o(arr_z2, v14, h.l[Character.digit(s.charAt(v15), 10)], true);
                }
                w.o(arr_z2, v14, h.i, true);
                return arr_z2;
            }
            default: {
                int v = s.length();
                switch(v) {
                    case 7: {
                        try {
                            s = s + h.v(e.w(s));
                            break;
                        }
                        catch(X7.b b0) {
                            throw new IllegalArgumentException(b0);
                        }
                    }
                    case 8: {
                        try {
                            if(!h.u(s)) {
                                throw new IllegalArgumentException("Contents do not pass checksum");
                            }
                            break;
                        }
                        catch(X7.b unused_ex) {
                            throw new IllegalArgumentException("Illegal contents");
                        }
                    }
                    default: {
                        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + v);
                    }
                }
                int v1 = Character.digit(s.charAt(0), 10);
                if(v1 != 0 && v1 != 1) {
                    throw new IllegalArgumentException("Number system must be 0 or 1");
                }
                int v2 = e.o[v1][Character.digit(s.charAt(7), 10)];
                boolean[] arr_z = new boolean[51];
                int v3 = w.o(arr_z, 0, h.i, true);
                for(int v4 = 1; v4 <= 6; ++v4) {
                    v3 += w.o(arr_z, v3, h.m[((v2 >> 6 - v4 & 1) == 1 ? Character.digit(s.charAt(v4), 10) + 10 : Character.digit(s.charAt(v4), 10))], false);
                }
                w.o(arr_z, v3, h.k, false);
                return arr_z;
            }
        }
    }
}

