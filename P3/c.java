package P3;

import B3.N;
import B3.n;
import De.I;
import I6.Q;
import I6.V;
import I6.p0;
import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.BinaryFrame;
import androidx.media3.extractor.metadata.id3.ChapterFrame;
import androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.GeobFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.extractor.metadata.id3.UrlLinkFrame;
import b3.H;
import e3.p;
import e3.x;
import h7.u0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public final class c extends I {
    public final a j;
    public static final n k;

    static {
        c.k = new n(25);
    }

    public c(a a0) {
        this.j = a0;
    }

    public static int A0(int v, p p0) {
        byte[] arr_b = p0.a;
        int v1 = p0.b;
        for(int v2 = v1; v2 + 1 < v1 + v; ++v2) {
            if((arr_b[v2] & 0xFF) == 0xFF && arr_b[v2 + 1] == 0) {
                System.arraycopy(arr_b, v2 + 2, arr_b, v2 + 1, v - (v2 - v1) - 2);
                --v;
            }
        }
        return v;
    }

    // This method was un-flattened
    public static boolean B0(p p0, int v, int v1, boolean z) {
        int v6;
        int v5;
        long v4;
        int v3;
        int v2 = p0.b;
        try {
            while(true) {
            label_1:
                if(p0.a() < v1) {
                    goto label_40;
                }
                if(v >= 3) {
                    v3 = p0.g();
                    v4 = p0.w();
                    v5 = p0.A();
                }
                else {
                    v3 = p0.x();
                    v4 = (long)p0.x();
                    v5 = 0;
                }
                break;
            }
        }
        catch(Throwable throwable0) {
            p0.G(v2);
            throw throwable0;
        }
        if(v3 == 0 && v4 == 0L && v5 == 0) {
            p0.G(v2);
            return true;
        }
        if(v == 4 && !z) {
            if((0x808080L & v4) != 0L) {
                p0.G(v2);
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
            p0.G(v2);
            return false;
        }
        if(((long)p0.a()) < v4) {
            p0.G(v2);
            return false;
        }
        try {
            p0.H(((int)v4));
            goto label_1;
        }
        catch(Throwable throwable0) {
        }
        p0.G(v2);
        throw throwable0;
    label_40:
        p0.G(v2);
        return true;
    }

    public final Metadata g0(int v, byte[] arr_b) {
        b b0;
        ArrayList arrayList0 = new ArrayList();
        p p0 = new p(arr_b, v);
        boolean z = false;
        int v1 = 10;
        if(p0.a() < 10) {
            e3.b.D("Id3Decoder", "Data too short to be an ID3 tag");
            b0 = null;
        }
        else {
            int v2 = p0.x();
            if(v2 == 4801587) {
                int v3 = p0.u();
                p0.H(1);
                int v4 = p0.u();
                int v5 = p0.t();
                if(v3 != 2) {
                    switch(v3) {
                        case 3: {
                            if((v4 & 0x40) != 0) {
                                int v6 = p0.g();
                                p0.H(v6);
                                v5 -= v6 + 4;
                            }
                            b0 = new b(3, (v4 & 0x80) != 0, v5);
                            break;
                        }
                        case 4: {
                            if((v4 & 0x40) != 0) {
                                int v7 = p0.t();
                                p0.H(v7 - 4);
                                v5 -= v7;
                            }
                            if((v4 & 16) != 0) {
                                v5 -= 10;
                            }
                            b0 = new b(4, false, v5);
                            break;
                        }
                        default: {
                            com.iloen.melon.utils.a.r(v3, "Skipped ID3 tag with unsupported majorVersion=", "Id3Decoder");
                            b0 = null;
                        }
                    }
                }
                else if((v4 & 0x40) != 0) {
                    e3.b.D("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    b0 = null;
                }
                else {
                    b0 = new b(2, (v4 & 0x80) != 0, v5);
                }
            }
            else {
                e3.b.D("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", v2));
                b0 = null;
            }
        }
        if(b0 == null) {
            return null;
        }
        int v8 = b0.a;
        int v9 = p0.b;
        if(v8 == 2) {
            v1 = 6;
        }
        p0.F(v9 + (b0.b ? c.A0(b0.c, p0) : b0.c));
        if(!c.B0(p0, v8, v1, false)) {
            if(v8 == 4 && c.B0(p0, 4, v1, true)) {
                z = true;
                goto label_54;
            }
            com.iloen.melon.utils.a.r(v8, "Failed to validate ID3 tag with majorVersion=", "Id3Decoder");
            return null;
        }
    label_54:
        while(p0.a() >= v1) {
            Id3Frame id3Frame0 = c.l0(v8, p0, z, v1, this.j);
            if(id3Frame0 != null) {
                arrayList0.add(id3Frame0);
            }
        }
        return new Metadata(arrayList0);
    }

    public static ApicFrame h0(p p0, int v, int v1) {
        int v3;
        String s;
        int v2 = p0.u();
        Charset charset0 = c.w0(v2);
        byte[] arr_b = new byte[v - 1];
        p0.e(arr_b, 0, v - 1);
        if(v1 == 2) {
            s = "image/" + u0.U(new String(arr_b, 0, 3, StandardCharsets.ISO_8859_1));
            if("image/jpg".equals(s)) {
                s = "image/jpeg";
            }
            v3 = 2;
        }
        else {
            v3 = c.z0(arr_b, 0);
            String s1 = u0.U(new String(arr_b, 0, v3, StandardCharsets.ISO_8859_1));
            s = s1.indexOf(0x2F) == -1 ? "image/" + s1 : s1;
        }
        int v4 = arr_b[v3 + 1] & 0xFF;
        int v5 = c.y0(arr_b, v3 + 2, v2);
        String s2 = new String(arr_b, v3 + 2, v5 - (v3 + 2), charset0);
        int v6 = c.v0(v2) + v5;
        return v - 1 > v6 ? new ApicFrame(s, s2, v4, Arrays.copyOfRange(arr_b, v6, v - 1)) : new ApicFrame(s, s2, v4, x.f);
    }

    public static ChapterFrame i0(p p0, int v, int v1, boolean z, int v2, a a0) {
        int v3 = p0.b;
        int v4 = c.z0(p0.a, v3);
        String s = new String(p0.a, v3, v4 - v3, StandardCharsets.ISO_8859_1);
        p0.G(v4 + 1);
        int v5 = p0.g();
        int v6 = p0.g();
        long v7 = p0.w();
        if(Long.compare(v7, 0xFFFFFFFFL) == 0) {
            v7 = -1L;
        }
        long v8 = p0.w();
        ArrayList arrayList0 = new ArrayList();
        while(p0.b < v3 + v) {
            Id3Frame id3Frame0 = c.l0(v1, p0, z, v2, a0);
            if(id3Frame0 != null) {
                arrayList0.add(id3Frame0);
            }
        }
        return new ChapterFrame(s, v5, v6, v7, (v8 == 0xFFFFFFFFL ? -1L : v8), ((Id3Frame[])arrayList0.toArray(new Id3Frame[0])));
    }

    public static ChapterTocFrame j0(p p0, int v, int v1, boolean z, int v2, a a0) {
        int v3 = p0.b;
        int v4 = c.z0(p0.a, v3);
        String s = new String(p0.a, v3, v4 - v3, StandardCharsets.ISO_8859_1);
        p0.G(v4 + 1);
        int v5 = p0.u();
        int v6 = p0.u();
        String[] arr_s = new String[v6];
        for(int v7 = 0; v7 < v6; ++v7) {
            int v8 = p0.b;
            int v9 = c.z0(p0.a, v8);
            arr_s[v7] = new String(p0.a, v8, v9 - v8, StandardCharsets.ISO_8859_1);
            p0.G(v9 + 1);
        }
        ArrayList arrayList0 = new ArrayList();
        while(p0.b < v3 + v) {
            Id3Frame id3Frame0 = c.l0(v1, p0, z, v2, a0);
            if(id3Frame0 != null) {
                arrayList0.add(id3Frame0);
            }
        }
        return new ChapterTocFrame(s, (v5 & 2) != 0, (v5 & 1) != 0, arr_s, ((Id3Frame[])arrayList0.toArray(new Id3Frame[0])));
    }

    public static CommentFrame k0(int v, p p0) {
        if(v < 4) {
            return null;
        }
        int v1 = p0.u();
        Charset charset0 = c.w0(v1);
        byte[] arr_b = new byte[3];
        p0.e(arr_b, 0, 3);
        String s = new String(arr_b, 0, 3);
        byte[] arr_b1 = new byte[v - 4];
        p0.e(arr_b1, 0, v - 4);
        int v2 = c.y0(arr_b1, 0, v1);
        int v3 = c.v0(v1) + v2;
        return new CommentFrame(s, new String(arr_b1, 0, v2, charset0), c.p0(arr_b1, v3, c.y0(arr_b1, v3, v1), charset0));
    }

    public static Id3Frame l0(int v, p p0, boolean z, int v1, a a0) {
        int v15;
        int v14;
        TextInformationFrame textInformationFrame0;
        boolean z1;
        int v13;
        int v12;
        int v11;
        int v10;
        int v6;
        int v2 = p0.u();
        int v3 = p0.u();
        int v4 = p0.u();
        int v5 = v < 3 ? 0 : p0.u();
        switch(v) {
            case 3: {
                v6 = p0.y();
                break;
            }
            case 4: {
                v6 = p0.y();
                if(!z) {
                    v6 = (v6 >> 24 & 0xFF) << 21 | (v6 & 0xFF | (v6 >> 8 & 0xFF) << 7 | (v6 >> 16 & 0xFF) << 14);
                }
                break;
            }
            default: {
                v6 = p0.x();
            }
        }
        int v7 = v6;
        int v8 = v < 3 ? 0 : p0.A();
        if(v2 == 0 && v3 == 0 && v4 == 0 && v5 == 0 && v7 == 0 && v8 == 0) {
            p0.G(p0.c);
            return null;
        }
        int v9 = p0.b + v7;
        if(v9 > p0.c) {
            e3.b.D("Id3Decoder", "Frame size exceeds remaining tag data");
            p0.G(p0.c);
            return null;
        }
        if(a0 != null && !a0.evaluate(v, v2, v3, v4, v5)) {
            p0.G(v9);
            return null;
        }
        switch(v) {
            case 3: {
                v10 = (v8 & 0x80) == 0 ? 0 : 1;
                v13 = (v8 & 0x40) == 0 ? 0 : 1;
                z1 = false;
                v12 = (v8 & 0x20) == 0 ? 0 : 1;
                v11 = v10;
                break;
            }
            case 4: {
                v13 = (v8 & 4) == 0 ? 0 : 1;
                z1 = (v8 & 2) != 0;
                v11 = (v8 & 1) == 0 ? 0 : 1;
                v12 = (v8 & 0x40) == 0 ? 0 : 1;
                v10 = (v8 & 8) == 0 ? 0 : 1;
                break;
            }
            default: {
                v10 = 0;
                v11 = 0;
                v12 = 0;
                v13 = 0;
                z1 = false;
            }
        }
        if(v10 != 0 || v13 != 0) {
            e3.b.D("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            p0.G(v9);
            return null;
        }
        if(v12 != 0) {
            --v7;
            p0.H(1);
        }
        if(v11 != 0) {
            v7 -= 4;
            p0.H(4);
        }
        if(z1) {
            v7 = c.A0(v7, p0);
        }
        try {
            try {
                if(v2 == 84 && v3 == 88 && v4 == 88 && (v == 2 || v5 == 88)) {
                    textInformationFrame0 = c.s0(v7, p0);
                    v14 = v7;
                    v15 = v5;
                }
                else if(v2 == 84) {
                    textInformationFrame0 = c.q0(v7, p0, c.x0(v, 84, v3, v4, v5));
                    v14 = v7;
                    v15 = v5;
                }
                else if(v2 == 87 && v3 == 88 && v4 == 88 && (v == 2 || v5 == 88)) {
                    textInformationFrame0 = c.u0(v7, p0);
                    v14 = v7;
                    v15 = v5;
                }
                else if(v2 == 87) {
                    textInformationFrame0 = c.t0(v7, p0, c.x0(v, 87, v3, v4, v5));
                    v14 = v7;
                    v15 = v5;
                }
                else {
                    if(v2 == 80 && v3 == 82 && v4 == 73 && v5 == 86) {
                        textInformationFrame0 = c.o0(v7, p0);
                        v14 = v7;
                        v15 = v5;
                        goto label_121;
                    }
                    goto label_66;
                }
                goto label_121;
            }
            catch(OutOfMemoryError | Exception outOfMemoryError0) {
                goto label_114;
            }
            try {
            label_66:
                if(v2 == 71 && v3 == 69 && v4 == 0x4F && (v5 == 66 || v == 2)) {
                    textInformationFrame0 = c.m0(v7, p0);
                    v14 = v7;
                    v15 = v5;
                }
                else if(v != 2) {
                    if(v2 != 65 || v3 != 80 || v4 != 73 || v5 != 67) {
                    label_74:
                        if(v2 == 67 && v3 == 0x4F && v4 == 77 && (v5 == 77 || v == 2)) {
                            textInformationFrame0 = c.k0(v7, p0);
                            v14 = v7;
                            v15 = v5;
                            goto label_121;
                        }
                        goto label_77;
                    }
                    else {
                        textInformationFrame0 = c.h0(p0, v7, v);
                        v14 = v7;
                        v15 = v5;
                    }
                }
                else if(v2 == 80 && v3 == 73 && v4 == 67) {
                    textInformationFrame0 = c.h0(p0, v7, 2);
                    v14 = v7;
                    v15 = v5;
                }
                else {
                    goto label_74;
                }
                goto label_121;
            }
            catch(OutOfMemoryError | Exception outOfMemoryError0) {
                v14 = v7;
                v15 = v5;
                goto label_116;
            }
            try {
            label_77:
                if(v2 == 67 && v3 == 72 && v4 == 65 && v5 == 80) {
                    v14 = v7;
                    v15 = 80;
                    textInformationFrame0 = c.i0(p0, v14, v, z, v1, a0);
                }
                else {
                    v14 = v7;
                    v15 = v5;
                    if(v2 == 67 && v3 == 84 && v4 == 0x4F && v15 == 67) {
                        textInformationFrame0 = c.j0(p0, v14, v, z, v1, a0);
                    }
                    else if(v2 == 77 && v3 == 76 && v4 == 76 && v15 == 84) {
                        textInformationFrame0 = c.n0(v14, p0);
                    }
                    else {
                        String s = c.x0(v, v2, v3, v4, v15);
                        byte[] arr_b = new byte[v14];
                        p0.e(arr_b, 0, v14);
                        textInformationFrame0 = new BinaryFrame(s, arr_b);
                    }
                }
                goto label_121;
            }
            catch(OutOfMemoryError | Exception outOfMemoryError0) {
                goto label_116;
            }
            try {
                textInformationFrame0 = c.m0(v7, p0);
                v14 = v7;
                v15 = v5;
                goto label_121;
            }
            catch(OutOfMemoryError | Exception outOfMemoryError0) {
            }
            v14 = v7;
            v15 = v5;
            goto label_116;
            try {
                textInformationFrame0 = c.q0(v7, p0, c.x0(v, 84, v3, v4, v5));
                v14 = v7;
                v15 = v5;
                goto label_121;
            label_114:
                v14 = v7;
                v15 = v5;
            }
            catch(OutOfMemoryError | Exception outOfMemoryError0) {
                goto label_114;
            }
        }
        catch(Throwable throwable0) {
            p0.G(v9);
            throw throwable0;
        }
    label_116:
        p0.G(v9);
        Id3Frame id3Frame0 = null;
        goto label_124;
    label_121:
        p0.G(v9);
        id3Frame0 = textInformationFrame0;
        outOfMemoryError0 = null;
    label_124:
        if(id3Frame0 == null) {
            e3.b.E("Id3Decoder", "Failed to decode frame: id=" + c.x0(v, v2, v3, v4, v15) + ", frameSize=" + v14, outOfMemoryError0);
        }
        return id3Frame0;
    }

    public static GeobFrame m0(int v, p p0) {
        int v1 = p0.u();
        Charset charset0 = c.w0(v1);
        byte[] arr_b = new byte[v - 1];
        p0.e(arr_b, 0, v - 1);
        int v2 = c.z0(arr_b, 0);
        String s = H.l(new String(arr_b, 0, v2, StandardCharsets.ISO_8859_1));
        int v3 = c.y0(arr_b, v2 + 1, v1);
        String s1 = c.p0(arr_b, v2 + 1, v3, charset0);
        int v4 = c.v0(v1) + v3;
        int v5 = c.y0(arr_b, v4, v1);
        String s2 = c.p0(arr_b, v4, v5, charset0);
        int v6 = c.v0(v1) + v5;
        return v - 1 > v6 ? new GeobFrame(s, s1, s2, Arrays.copyOfRange(arr_b, v6, v - 1)) : new GeobFrame(s, s1, s2, x.f);
    }

    public static MlltFrame n0(int v, p p0) {
        int v1 = p0.A();
        int v2 = p0.x();
        int v3 = p0.x();
        int v4 = p0.u();
        int v5 = p0.u();
        N n0 = new N(2);
        n0.J(p0);
        int v6 = (v - 10) * 8 / (v4 + v5);
        int[] arr_v = new int[v6];
        int[] arr_v1 = new int[v6];
        for(int v7 = 0; v7 < v6; ++v7) {
            int v8 = n0.D(v4);
            int v9 = n0.D(v5);
            arr_v[v7] = v8;
            arr_v1[v7] = v9;
        }
        return new MlltFrame(v1, v2, v3, arr_v, arr_v1);
    }

    public static PrivFrame o0(int v, p p0) {
        byte[] arr_b = new byte[v];
        p0.e(arr_b, 0, v);
        int v1 = c.z0(arr_b, 0);
        String s = new String(arr_b, 0, v1, StandardCharsets.ISO_8859_1);
        return v > v1 + 1 ? new PrivFrame(s, Arrays.copyOfRange(arr_b, v1 + 1, v)) : new PrivFrame(s, x.f);
    }

    public static String p0(byte[] arr_b, int v, int v1, Charset charset0) {
        return v1 <= v || v1 > arr_b.length ? "" : new String(arr_b, v, v1 - v, charset0);
    }

    public static TextInformationFrame q0(int v, p p0, String s) {
        if(v < 1) {
            return null;
        }
        int v1 = p0.u();
        byte[] arr_b = new byte[v - 1];
        p0.e(arr_b, 0, v - 1);
        return new TextInformationFrame(s, null, c.r0(arr_b, v1, 0));
    }

    public static p0 r0(byte[] arr_b, int v, int v1) {
        if(v1 >= arr_b.length) {
            return V.t("");
        }
        Q q0 = V.o();
        for(int v2 = c.y0(arr_b, v1, v); v1 < v2; v2 = c.y0(arr_b, v1, v)) {
            q0.a(new String(arr_b, v1, v2 - v1, c.w0(v)));
            v1 = c.v0(v) + v2;
        }
        p0 p00 = q0.g();
        return p00.isEmpty() ? V.t("") : p00;
    }

    public static TextInformationFrame s0(int v, p p0) {
        if(v < 1) {
            return null;
        }
        int v1 = p0.u();
        byte[] arr_b = new byte[v - 1];
        p0.e(arr_b, 0, v - 1);
        int v2 = c.y0(arr_b, 0, v1);
        return new TextInformationFrame("TXXX", new String(arr_b, 0, v2, c.w0(v1)), c.r0(arr_b, v1, c.v0(v1) + v2));
    }

    public static UrlLinkFrame t0(int v, p p0, String s) {
        byte[] arr_b = new byte[v];
        p0.e(arr_b, 0, v);
        return new UrlLinkFrame(s, null, new String(arr_b, 0, c.z0(arr_b, 0), StandardCharsets.ISO_8859_1));
    }

    public static UrlLinkFrame u0(int v, p p0) {
        if(v < 1) {
            return null;
        }
        int v1 = p0.u();
        byte[] arr_b = new byte[v - 1];
        p0.e(arr_b, 0, v - 1);
        int v2 = c.y0(arr_b, 0, v1);
        int v3 = c.v0(v1) + v2;
        return new UrlLinkFrame("WXXX", new String(arr_b, 0, v2, c.w0(v1)), c.p0(arr_b, v3, c.z0(arr_b, v3), StandardCharsets.ISO_8859_1));
    }

    public static int v0(int v) {
        return v == 0 || v == 3 ? 1 : 2;
    }

    public static Charset w0(int v) {
        switch(v) {
            case 1: {
                return StandardCharsets.UTF_16;
            }
            case 2: {
                return StandardCharsets.UTF_16BE;
            }
            case 3: {
                return StandardCharsets.UTF_8;
            }
            default: {
                return StandardCharsets.ISO_8859_1;
            }
        }
    }

    public static String x0(int v, int v1, int v2, int v3, int v4) {
        return v == 2 ? String.format(Locale.US, "%c%c%c", v1, v2, v3) : String.format(Locale.US, "%c%c%c%c", v1, v2, v3, v4);
    }

    public static int y0(byte[] arr_b, int v, int v1) {
        int v2 = c.z0(arr_b, v);
        if(v1 != 0 && v1 != 3) {
            while(v2 < arr_b.length - 1) {
                if((v2 - v) % 2 == 0 && arr_b[v2 + 1] == 0) {
                    return v2;
                }
                v2 = c.z0(arr_b, v2 + 1);
            }
            return arr_b.length;
        }
        return v2;
    }

    @Override  // De.I
    public final Metadata z(K3.a a0, ByteBuffer byteBuffer0) {
        return this.g0(byteBuffer0.limit(), byteBuffer0.array());
    }

    public static int z0(byte[] arr_b, int v) {
        while(v < arr_b.length) {
            if(arr_b[v] == 0) {
                return v;
            }
            ++v;
        }
        return arr_b.length;
    }
}

