package i.n.i.b.a.s.e;

import B3.N;
import P3.b;
import U4.x;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public final class Db extends Ja {
    public final Ma K;
    public static final Ma L;

    static {
        Db.L = new Ma(20);
    }

    public Db(Ma ma0) {
        this.K = ma0;
    }

    public static o9 Z(wb wb0, int v, int v1) {
        int v3;
        String s1;
        int v2 = wb0.z();
        String s = Db.m0(v2);
        byte[] arr_b = new byte[v - 1];
        wb0.j(arr_b, 0, v - 1);
        if(v1 == 2) {
            s1 = "image/" + M7.j(new String(arr_b, 0, 3, "ISO-8859-1"));
            if("image/jpg".equals(s1)) {
                s1 = "image/jpeg";
            }
            v3 = 2;
        }
        else {
            v3 = Db.h0(0, arr_b);
            s1 = M7.j(new String(arr_b, 0, v3, "ISO-8859-1"));
            if(s1.indexOf(0x2F) == -1) {
                s1 = "image/" + s1;
            }
        }
        int v4 = arr_b[v3 + 1] & 0xFF;
        int v5 = Db.i0(arr_b, v3 + 2, v2);
        String s2 = new String(arr_b, v3 + 2, v5 - (v3 + 2), s);
        int v6 = Db.a(v2) + v5;
        return v - 1 > v6 ? new o9(s1, s2, v4, Arrays.copyOfRange(arr_b, v6, v - 1)) : new o9(s1, s2, v4, L7.g);
    }

    @Override  // i.n.i.b.a.s.e.Ja
    public static int a(int v) {
        return v == 0 || v == 3 ? 1 : 2;
    }

    public static q9 a0(wb wb0, int v, int v1, boolean z, int v2, Ma ma0) {
        int v3 = wb0.b;
        int v4 = Db.h0(v3, wb0.a);
        String s = new String(wb0.a, v3, v4 - v3, "ISO-8859-1");
        wb0.n(v4 + 1);
        int v5 = wb0.p();
        int v6 = wb0.p();
        long v7 = wb0.A();
        if(Long.compare(v7, 0xFFFFFFFFL) == 0) {
            v7 = -1L;
        }
        long v8 = wb0.A();
        ArrayList arrayList0 = new ArrayList();
        while(wb0.b < v3 + v) {
            v9 v90 = Db.c0(v1, wb0, z, v2, ma0);
            if(v90 != null) {
                arrayList0.add(v90);
            }
        }
        return new q9(s, v5, v6, v7, (v8 == 0xFFFFFFFFL ? -1L : v8), ((v9[])arrayList0.toArray(new v9[0])));
    }

    public static s9 b0(int v, wb wb0) {
        if(v < 4) {
            return null;
        }
        int v1 = wb0.z();
        String s = Db.m0(v1);
        byte[] arr_b = new byte[3];
        wb0.j(arr_b, 0, 3);
        String s1 = new String(arr_b, 0, 3);
        byte[] arr_b1 = new byte[v - 4];
        wb0.j(arr_b1, 0, v - 4);
        int v2 = Db.i0(arr_b1, 0, v1);
        int v3 = Db.a(v1) + v2;
        return new s9(s1, new String(arr_b1, 0, v2, s), Db.f0(s, arr_b1, v3, Db.i0(arr_b1, v3, v1)));
    }

    public static v9 c0(int v, wb wb0, boolean z, int v1, Ma ma0) {
        v9 v90;
        boolean z1;
        int v12;
        int v11;
        int v10;
        int v9;
        int v6;
        int v2 = wb0.z();
        int v3 = wb0.z();
        int v4 = wb0.z();
        int v5 = v < 3 ? 0 : wb0.z();
        switch(v) {
            case 3: {
                v6 = wb0.C();
                break;
            }
            case 4: {
                v6 = wb0.C();
                if(!z) {
                    v6 = (v6 >> 24 & 0xFF) << 21 | (v6 & 0xFF | (v6 >> 8 & 0xFF) << 7 | (v6 >> 16 & 0xFF) << 14);
                }
                break;
            }
            default: {
                v6 = wb0.B();
            }
        }
        int v7 = v < 3 ? 0 : wb0.b();
        if(v2 == 0 && v3 == 0 && v4 == 0 && v5 == 0 && v6 == 0 && v7 == 0) {
            wb0.n(wb0.c);
            return null;
        }
        int v8 = wb0.b + v6;
        if(v8 > wb0.c) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            wb0.n(wb0.c);
            return null;
        }
        if(ma0 != null && (ma0.a == 20 || (v2 != 67 || v3 != 0x4F || v4 != 77 || v5 != 77 && v != 2) && (v2 != 77 || v3 != 76 || v4 != 76 || v5 != 84 && v != 2))) {
            wb0.n(v8);
            return null;
        }
        switch(v) {
            case 3: {
                v9 = (v7 & 0x80) == 0 ? 0 : 1;
                v11 = (v7 & 0x20) == 0 ? 0 : 1;
                v12 = (v7 & 0x40) == 0 ? 0 : 1;
                z1 = false;
                v10 = v9;
                break;
            }
            case 4: {
                int v13 = (v7 & 0x40) == 0 ? 0 : 1;
                int v14 = (v7 & 8) == 0 ? 0 : 1;
                v12 = (v7 & 4) == 0 ? 0 : 1;
                z1 = (v7 & 2) != 0;
                if((v7 & 1) == 0) {
                    v11 = v13;
                    v9 = v14;
                    v10 = 0;
                }
                else {
                    v11 = v13;
                    v9 = v14;
                    v10 = 1;
                }
                break;
            }
            default: {
                v9 = 0;
                v10 = 0;
                v11 = 0;
                v12 = 0;
                z1 = false;
            }
        }
        if(v9 == 0 && v12 == 0) {
            if(v11 != 0) {
                --v6;
                wb0.o(1);
            }
            if(v10 != 0) {
                v6 -= 4;
                wb0.o(4);
            }
            if(z1) {
                v6 = Db.s0(v6, wb0);
            }
            try {
                if(v2 == 84 && v3 == 88 && v4 == 88 && (v == 2 || v5 == 88)) {
                    v90 = Db.q0(v6, wb0);
                }
                else if(v2 == 84) {
                    v90 = Db.l0(v6, wb0, Db.e0(v, 84, v3, v4, v5));
                }
                else if(v2 == 87 && v3 == 88 && v4 == 88 && (v == 2 || v5 == 88)) {
                    v90 = Db.r0(v6, wb0);
                }
                else if(v2 == 87) {
                    v90 = Db.n0(v6, wb0, Db.e0(v, 87, v3, v4, v5));
                }
                else if(v2 == 80 && v3 == 82 && v4 == 73 && v5 == 86) {
                    v90 = Db.p0(v6, wb0);
                }
                else if(v2 == 71 && v3 == 69 && v4 == 0x4F && (v5 == 66 || v == 2)) {
                    v90 = Db.k0(v6, wb0);
                }
                else if(v != 2) {
                    if(v2 == 65 && v3 == 80 && v4 == 73 && v5 == 67) {
                        v90 = Db.Z(wb0, v6, v);
                    }
                    else {
                    label_69:
                        if(v2 == 67 && v3 == 0x4F && v4 == 77 && (v5 == 77 || v == 2)) {
                            v90 = Db.b0(v6, wb0);
                        }
                        else if(v2 == 67 && v3 == 72 && v4 == 65 && v5 == 80) {
                            v90 = Db.a0(wb0, v6, v, z, v1, ma0);
                        }
                        else if(v2 == 67 && v3 == 84 && v4 == 0x4F && v5 == 67) {
                            v90 = Db.j0(wb0, v6, v, z, v1, ma0);
                        }
                        else if(v2 == 77 && v3 == 76 && v4 == 76 && v5 == 84) {
                            v90 = Db.o0(v6, wb0);
                        }
                        else {
                            String s = Db.e0(v, v2, v3, v4, v5);
                            byte[] arr_b = new byte[v6];
                            wb0.j(arr_b, 0, v6);
                            v90 = new p9(s, arr_b);
                        }
                    }
                }
                else if(v2 == 80 && v3 == 73 && v4 == 67) {
                    v90 = Db.Z(wb0, v6, 2);
                }
                else {
                    goto label_69;
                }
            }
            catch(UnsupportedEncodingException unused_ex) {
                goto label_104;
            }
            catch(Throwable throwable0) {
                wb0.n(v8);
                throw throwable0;
            }
            if(v90 == null) {
                try {
                    try {
                        Log.w("Id3Decoder", "Failed to decode frame: id=" + Db.e0(v, v2, v3, v4, v5) + ", frameSize=" + v6);
                        goto label_109;
                    }
                    catch(UnsupportedEncodingException unused_ex) {
                    }
                label_104:
                    Log.w("Id3Decoder", "Unsupported character encoding");
                }
                catch(Throwable throwable0) {
                    wb0.n(v8);
                    throw throwable0;
                }
                wb0.n(v8);
                return null;
            }
        label_109:
            wb0.n(v8);
            return v90;
        }
        Log.w("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
        wb0.n(v8);
        return null;
    }

    public final x8 d0(int v, byte[] arr_b) {
        b b0;
        ArrayList arrayList0 = new ArrayList();
        wb wb0 = new wb(arr_b, v);
        boolean z = false;
        int v1 = 10;
        if(wb0.d() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            b0 = null;
        }
        else {
            int v2 = wb0.B();
            if(v2 == 4801587) {
                int v3 = wb0.z();
                wb0.o(1);
                int v4 = wb0.z();
                int v5 = wb0.y();
                if(v3 != 2) {
                    switch(v3) {
                        case 3: {
                            if((v4 & 0x40) != 0) {
                                int v6 = wb0.p();
                                wb0.o(v6);
                                v5 -= v6 + 4;
                            }
                            b0 = new b(3, (v4 & 0x80) != 0, v5);
                            break;
                        }
                        case 4: {
                            if((v4 & 0x40) != 0) {
                                int v7 = wb0.y();
                                wb0.o(v7 - 4);
                                v5 -= v7;
                            }
                            if((v4 & 16) != 0) {
                                v5 -= 10;
                            }
                            b0 = new b(4, false, v5);
                            break;
                        }
                        default: {
                            x.u(v3, "Skipped ID3 tag with unsupported majorVersion=", "Id3Decoder");
                            b0 = null;
                        }
                    }
                }
                else if((v4 & 0x40) != 0) {
                    Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    b0 = null;
                }
                else {
                    b0 = new b(2, (v4 & 0x80) != 0, v5);
                }
            }
            else {
                Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", v2));
                b0 = null;
            }
        }
        if(b0 == null) {
            return null;
        }
        int v8 = b0.a;
        int v9 = wb0.b;
        if(v8 == 2) {
            v1 = 6;
        }
        wb0.m(v9 + (b0.b ? Db.s0(b0.c, wb0) : b0.c));
        if(!Db.g0(wb0, v8, v1, false)) {
            if(v8 == 4 && Db.g0(wb0, 4, v1, true)) {
                z = true;
                goto label_54;
            }
            x.u(v8, "Failed to validate ID3 tag with majorVersion=", "Id3Decoder");
            return null;
        }
    label_54:
        while(wb0.d() >= v1) {
            v9 v90 = Db.c0(v8, wb0, z, v1, this.K);
            if(v90 != null) {
                arrayList0.add(v90);
            }
        }
        return new x8(arrayList0);
    }

    public static String e0(int v, int v1, int v2, int v3, int v4) {
        return v == 2 ? String.format(Locale.US, "%c%c%c", v1, v2, v3) : String.format(Locale.US, "%c%c%c%c", v1, v2, v3, v4);
    }

    public static String f0(String s, byte[] arr_b, int v, int v1) {
        return v1 <= v || v1 > arr_b.length ? "" : new String(arr_b, v, v1 - v, s);
    }

    // This method was un-flattened
    public static boolean g0(wb wb0, int v, int v1, boolean z) {
        int v6;
        int v5;
        long v4;
        int v3;
        int v2 = wb0.b;
        try {
            while(true) {
            label_1:
                if(wb0.d() < v1) {
                    goto label_40;
                }
                if(v >= 3) {
                    v3 = wb0.p();
                    v4 = wb0.A();
                    v5 = wb0.b();
                }
                else {
                    v3 = wb0.B();
                    v4 = (long)wb0.B();
                    v5 = 0;
                }
                break;
            }
        }
        catch(Throwable throwable0) {
            wb0.n(v2);
            throw throwable0;
        }
        if(v3 == 0 && v4 == 0L && v5 == 0) {
            wb0.n(v2);
            return true;
        }
        if(v == 4 && !z) {
            if((0x808080L & v4) != 0L) {
                wb0.n(v2);
                return false;
            }
            v4 = (v4 >> 24 & 0xFFL) << 21 | (v4 & 0xFFL | (v4 >> 8 & 0xFFL) << 7 | (v4 >> 16 & 0xFFL) << 14);
        }
        if(v == 4) {
            v6 = (v5 & 0x40) == 0 ? 0 : 1;
            if((v5 & 1) != 0) {
                v6 += 4;
            }
        }
        else if(v == 3) {
            v6 = (v5 & 0x20) == 0 ? 0 : 1;
            if((v5 & 0x80) != 0) {
                v6 += 4;
            }
        }
        else {
            v6 = 0;
        }
        if(v4 < ((long)v6)) {
            wb0.n(v2);
            return false;
        }
        if(((long)wb0.d()) < v4) {
            wb0.n(v2);
            return false;
        }
        try {
            wb0.o(((int)v4));
            goto label_1;
        }
        catch(Throwable throwable0) {
        }
        wb0.n(v2);
        throw throwable0;
    label_40:
        wb0.n(v2);
        return true;
    }

    public static int h0(int v, byte[] arr_b) {
        while(v < arr_b.length) {
            if(arr_b[v] == 0) {
                return v;
            }
            ++v;
        }
        return arr_b.length;
    }

    public static int i0(byte[] arr_b, int v, int v1) {
        int v2 = Db.h0(v, arr_b);
        if(v1 != 0 && v1 != 3) {
            while(v2 < arr_b.length - 1) {
                if(v2 % 2 == 0 && arr_b[v2 + 1] == 0) {
                    return v2;
                }
                v2 = Db.h0(v2 + 1, arr_b);
            }
            return arr_b.length;
        }
        return v2;
    }

    public static r9 j0(wb wb0, int v, int v1, boolean z, int v2, Ma ma0) {
        int v3 = wb0.b;
        int v4 = Db.h0(v3, wb0.a);
        String s = new String(wb0.a, v3, v4 - v3, "ISO-8859-1");
        wb0.n(v4 + 1);
        int v5 = wb0.z();
        int v6 = wb0.z();
        String[] arr_s = new String[v6];
        for(int v7 = 0; v7 < v6; ++v7) {
            int v8 = wb0.b;
            int v9 = Db.h0(v8, wb0.a);
            arr_s[v7] = new String(wb0.a, v8, v9 - v8, "ISO-8859-1");
            wb0.n(v9 + 1);
        }
        ArrayList arrayList0 = new ArrayList();
        while(wb0.b < v3 + v) {
            v9 v90 = Db.c0(v1, wb0, z, v2, ma0);
            if(v90 != null) {
                arrayList0.add(v90);
            }
        }
        return new r9(s, (v5 & 2) != 0, (v5 & 1) != 0, arr_s, ((v9[])arrayList0.toArray(new v9[0])));
    }

    public static t9 k0(int v, wb wb0) {
        int v1 = wb0.z();
        String s = Db.m0(v1);
        byte[] arr_b = new byte[v - 1];
        wb0.j(arr_b, 0, v - 1);
        int v2 = Db.h0(0, arr_b);
        String s1 = new String(arr_b, 0, v2, "ISO-8859-1");
        int v3 = Db.i0(arr_b, v2 + 1, v1);
        String s2 = Db.f0(s, arr_b, v2 + 1, v3);
        int v4 = Db.a(v1) + v3;
        int v5 = Db.i0(arr_b, v4, v1);
        String s3 = Db.f0(s, arr_b, v4, v5);
        int v6 = Db.a(v1) + v5;
        return v - 1 > v6 ? new t9(s1, s2, s3, Arrays.copyOfRange(arr_b, v6, v - 1)) : new t9(s1, s2, s3, L7.g);
    }

    public static z9 l0(int v, wb wb0, String s) {
        if(v < 1) {
            return null;
        }
        int v1 = wb0.z();
        byte[] arr_b = new byte[v - 1];
        wb0.j(arr_b, 0, v - 1);
        return new z9(s, null, new String(arr_b, 0, Db.i0(arr_b, 0, v1), Db.m0(v1)));
    }

    public static String m0(int v) {
        switch(v) {
            case 1: {
                return "UTF-16";
            }
            case 2: {
                return "UTF-16BE";
            }
            case 3: {
                return "UTF-8";
            }
            default: {
                return "ISO-8859-1";
            }
        }
    }

    public static aa n0(int v, wb wb0, String s) {
        byte[] arr_b = new byte[v];
        wb0.j(arr_b, 0, v);
        return new aa(s, null, new String(arr_b, 0, Db.h0(0, arr_b), "ISO-8859-1"));
    }

    public static x9 o0(int v, wb wb0) {
        int v1 = wb0.b();
        int v2 = wb0.B();
        int v3 = wb0.B();
        int v4 = wb0.z();
        int v5 = wb0.z();
        N n0 = new N(6);
        n0.c(wb0.c, wb0.a);
        n0.p(wb0.b * 8);
        int v6 = (v - 10) * 8 / (v4 + v5);
        int[] arr_v = new int[v6];
        int[] arr_v1 = new int[v6];
        for(int v7 = 0; v7 < v6; ++v7) {
            int v8 = n0.a(v4);
            int v9 = n0.a(v5);
            arr_v[v7] = v8;
            arr_v1[v7] = v9;
        }
        return new x9(v1, v2, v3, arr_v, arr_v1);
    }

    @Override  // i.n.i.b.a.s.e.Ja
    public final x8 p(s s0, ByteBuffer byteBuffer0) {
        return this.d0(byteBuffer0.limit(), byteBuffer0.array());
    }

    public static y9 p0(int v, wb wb0) {
        byte[] arr_b = new byte[v];
        wb0.j(arr_b, 0, v);
        int v1 = Db.h0(0, arr_b);
        String s = new String(arr_b, 0, v1, "ISO-8859-1");
        return v > v1 + 1 ? new y9(s, Arrays.copyOfRange(arr_b, v1 + 1, v)) : new y9(s, L7.g);
    }

    public static z9 q0(int v, wb wb0) {
        if(v < 1) {
            return null;
        }
        int v1 = wb0.z();
        String s = Db.m0(v1);
        byte[] arr_b = new byte[v - 1];
        wb0.j(arr_b, 0, v - 1);
        int v2 = Db.i0(arr_b, 0, v1);
        int v3 = Db.a(v1) + v2;
        return new z9("TXXX", new String(arr_b, 0, v2, s), Db.f0(s, arr_b, v3, Db.i0(arr_b, v3, v1)));
    }

    public static aa r0(int v, wb wb0) {
        if(v < 1) {
            return null;
        }
        int v1 = wb0.z();
        byte[] arr_b = new byte[v - 1];
        wb0.j(arr_b, 0, v - 1);
        int v2 = Db.i0(arr_b, 0, v1);
        int v3 = Db.a(v1) + v2;
        return new aa("WXXX", new String(arr_b, 0, v2, Db.m0(v1)), Db.f0("ISO-8859-1", arr_b, v3, Db.h0(v3, arr_b)));
    }

    public static int s0(int v, wb wb0) {
        byte[] arr_b = wb0.a;
        int v1 = wb0.b;
        for(int v2 = v1; v2 + 1 < v1 + v; ++v2) {
            if((arr_b[v2] & 0xFF) == 0xFF && arr_b[v2 + 1] == 0) {
                System.arraycopy(arr_b, v2 + 2, arr_b, v2 + 1, v - (v2 - v1) - 2);
                --v;
            }
        }
        return v;
    }
}

