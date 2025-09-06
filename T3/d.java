package T3;

import B3.A;
import B3.K;
import B3.L;
import B3.M;
import B3.N;
import B3.e;
import B3.l;
import B3.m;
import B3.q;
import B3.r;
import B3.s;
import B3.t;
import B3.v;
import B3.w;
import I6.V;
import K0.b;
import Y3.j;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.DrmInitData.SchemeData;
import androidx.media3.common.DrmInitData;
import b3.H;
import b3.I;
import b3.h;
import b3.i;
import b3.n;
import e3.p;
import e3.x;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public final class d implements r {
    public boolean A;
    public long B;
    public long C;
    public long D;
    public b E;
    public b F;
    public boolean G;
    public boolean H;
    public int I;
    public long J;
    public long K;
    public int L;
    public int M;
    public int[] N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public long T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public final T3.b a;
    public int a0;
    public final f b;
    public byte b0;
    public final SparseArray c;
    public boolean c0;
    public final boolean d;
    public t d0;
    public final boolean e;
    public static final byte[] e0;
    public final j f;
    public static final byte[] f0;
    public final p g;
    public static final byte[] g0;
    public final p h;
    public static final byte[] h0;
    public final p i;
    public static final UUID i0;
    public final p j;
    public static final Map j0;
    public final p k;
    public final p l;
    public final p m;
    public final p n;
    public final p o;
    public final p p;
    public ByteBuffer q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public c w;
    public boolean x;
    public int y;
    public long z;

    static {
        d.e0 = new byte[]{49, 10, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44, 0x30, 0x30, 0x30, 0x20, 45, 45, 62, 0x20, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44, 0x30, 0x30, 0x30, 10};
        d.f0 = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        d.g0 = new byte[]{68, 105, 97, 108, 0x6F, 103, 0x75, 101, 58, 0x20, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44};
        d.h0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 46, 0x30, 0x30, 0x30, 0x20, 45, 45, 62, 0x20, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 46, 0x30, 0x30, 0x30, 10};
        d.i0 = new UUID(0x100000000001000L, 0x800000AA00389B71L);
        HashMap hashMap0 = new HashMap();
        A7.d.r(0, hashMap0, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        A7.d.r(180, hashMap0, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        d.j0 = Collections.unmodifiableMap(hashMap0);
    }

    public d(j j0, int v) {
        T3.b b0 = new T3.b(0);
        super();
        this.s = -1L;
        this.t = 0x8000000000000001L;
        this.u = 0x8000000000000001L;
        this.v = 0x8000000000000001L;
        this.B = -1L;
        this.C = -1L;
        this.D = 0x8000000000000001L;
        this.a = b0;
        b0.g = new I7.c(this, 23);
        this.f = j0;
        boolean z = false;
        this.d = (v & 1) == 0;
        if((v & 2) == 0) {
            z = true;
        }
        this.e = z;
        this.b = new f();
        this.c = new SparseArray();
        this.i = new p(4);
        this.j = new p(ByteBuffer.allocate(4).putInt(-1).array());
        this.k = new p(4);
        this.g = new p(f3.j.a);
        this.h = new p(4);
        this.l = new p();
        this.m = new p();
        this.n = new p(8);
        this.o = new p();
        this.p = new p();
        this.N = new int[1];
    }

    // This method was un-flattened
    @Override  // B3.r
    public final int a(s s0, v v0) {
        String s4;
        int v46;
        I7.c c5;
        long v45;
        int v44;
        int v43;
        w w0;
        long[] arr_v5;
        d d1;
        int v24;
        i i0;
        byte[] arr_b7;
        float f1;
        int v20;
        Pair pair0;
        String s3;
        int v15;
        List list0;
        String s2;
        d d5;
        int v5;
        d d2;
        t t1;
        List list1;
        d d3;
        d d4;
        this.H = false;
        boolean z = true;
        while(z && !this.H) {
            T3.b b0 = this.a;
            f f0 = (f)b0.f;
            ArrayDeque arrayDeque0 = b0.b;
            e3.b.k(((I7.c)b0.g));
        alab1:
            while(true) {
                a a0 = (a)arrayDeque0.peek();
                if(a0 == null || s0.getPosition() < a0.b) {
                    goto label_507;
                }
                I7.c c0 = (I7.c)b0.g;
                int v1 = ((a)arrayDeque0.pop()).a;
                d d0 = (d)c0.b;
                SparseArray sparseArray0 = d0.c;
                e3.b.k(d0.d0);
                if(v1 != 0xA0) {
                    switch(v1) {
                        case 0xAE: {
                            c c1 = d0.w;
                            e3.b.k(c1);
                            String s1 = c1.b;
                            if(s1 == null) {
                                throw I.a(null, "CodecId is missing in TrackEntry element");
                            }
                            switch(s1) {
                                case "A_AAC": 
                                case "A_AC3": 
                                case "A_DTS": 
                                case "A_DTS/EXPRESS": 
                                case "A_DTS/LOSSLESS": 
                                case "A_EAC3": 
                                case "A_FLAC": 
                                case "A_MPEG/L2": 
                                case "A_MPEG/L3": 
                                case "A_MS/ACM": 
                                case "A_OPUS": 
                                case "A_PCM/FLOAT/IEEE": 
                                case "A_PCM/INT/BIG": 
                                case "A_PCM/INT/LIT": 
                                case "A_TRUEHD": 
                                case "A_VORBIS": 
                                case "S_DVBSUB": 
                                case "S_HDMV/PGS": 
                                case "S_TEXT/ASS": 
                                case "S_TEXT/UTF8": 
                                case "S_TEXT/WEBVTT": 
                                case "S_VOBSUB": 
                                case "V_AV1": 
                                case "V_MPEG2": 
                                case "V_MPEG4/ISO/AP": 
                                case "V_MPEG4/ISO/ASP": 
                                case "V_MPEG4/ISO/AVC": 
                                case "V_MPEG4/ISO/SP": 
                                case "V_MPEGH/ISO/HEVC": 
                                case "V_MS/VFW/FOURCC": 
                                case "V_THEORA": 
                                case "V_VP8": 
                                case "V_VP9": {
                                    t t0 = d0.d0;
                                    int v2 = c1.c;
                                    switch(s1) {
                                        case "A_AAC": {
                                            t1 = t0;
                                            list0 = Collections.singletonList(c1.a(s1));
                                            B3.a a1 = B3.b.m(new N(c1.k, c1.k.length, 2, 0), false);
                                            c1.R = a1.b;
                                            c1.P = a1.c;
                                            s2 = "audio/mp4a-latm";
                                            s3 = a1.a;
                                            d2 = d0;
                                            v15 = -1;
                                            list1 = list0;
                                            v5 = -1;
                                            break;
                                        }
                                        case "A_AC3": {
                                            t1 = t0;
                                            d4 = d0;
                                            s2 = "audio/ac3";
                                            d2 = d4;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "A_DTS": {
                                            goto label_203;
                                        }
                                        case "A_DTS/EXPRESS": {
                                        label_203:
                                            t1 = t0;
                                            d4 = d0;
                                            s2 = "audio/vnd.dts";
                                            d2 = d4;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "A_DTS/LOSSLESS": {
                                            t1 = t0;
                                            d4 = d0;
                                            s2 = "audio/vnd.dts.hd";
                                            d2 = d4;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "A_EAC3": {
                                            t1 = t0;
                                            s2 = "audio/eac3";
                                            d2 = d0;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "A_FLAC": {
                                            t1 = t0;
                                            s2 = "audio/flac";
                                            list1 = Collections.singletonList(c1.a(s1));
                                            d2 = d0;
                                            v5 = -1;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "A_MPEG/L2": {
                                            t1 = t0;
                                            d3 = d0;
                                            s2 = "audio/mpeg-L2";
                                            goto label_100;
                                        }
                                        case "A_MPEG/L3": {
                                            t1 = t0;
                                            d3 = d0;
                                            s2 = "audio/mpeg";
                                        label_100:
                                            d2 = d3;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = 0x1000;
                                            s3 = null;
                                            break;
                                        }
                                        case "A_MS/ACM": {
                                            t1 = t0;
                                            d2 = d0;
                                            p p0 = new p(c1.a(c1.b));
                                            try {
                                                int v3 = p0.n();
                                                if(v3 != 1) {
                                                    if(v3 == 0xFFFE) {
                                                        p0.G(24);
                                                        if(p0.o() == d.i0.getMostSignificantBits() && p0.o() == d.i0.getLeastSignificantBits()) {
                                                            goto label_42;
                                                        }
                                                    }
                                                    goto label_40;
                                                }
                                                goto label_42;
                                            }
                                            catch(ArrayIndexOutOfBoundsException unused_ex) {
                                                throw I.a(null, "Error parsing MS/ACM codec private");
                                            }
                                        label_40:
                                            e3.b.D("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                                            s2 = "audio/x-unknown";
                                            goto label_279;
                                        label_42:
                                            int v4 = x.z(c1.Q);
                                            if(v4 == 0) {
                                                e3.b.D("MatroskaExtractor", "Unsupported PCM bit depth: " + c1.Q + ". Setting mimeType to audio/x-unknown");
                                                s2 = "audio/x-unknown";
                                                goto label_279;
                                            }
                                            else {
                                                v5 = v4;
                                                s2 = "audio/raw";
                                                list1 = null;
                                                v15 = -1;
                                                s3 = null;
                                                break;
                                            }
                                            goto label_48;
                                        }
                                        case "A_OPUS": {
                                            list0 = new ArrayList(3);
                                            ((ArrayList)list0).add(c1.a(c1.b));
                                            ByteBuffer byteBuffer0 = ByteBuffer.allocate(8);
                                            ByteOrder byteOrder0 = ByteOrder.LITTLE_ENDIAN;
                                            t1 = t0;
                                            ((ArrayList)list0).add(byteBuffer0.order(byteOrder0).putLong(c1.S).array());
                                            ((ArrayList)list0).add(ByteBuffer.allocate(8).order(byteOrder0).putLong(c1.T).array());
                                            s2 = "audio/opus";
                                            d2 = d0;
                                            s3 = null;
                                            v15 = 5760;
                                            list1 = list0;
                                            v5 = -1;
                                            break;
                                        }
                                        case "A_PCM/FLOAT/IEEE": {
                                            t1 = t0;
                                            d5 = d0;
                                            if(c1.Q == 0x20) {
                                                d2 = d5;
                                                s2 = "audio/raw";
                                                v5 = 4;
                                                list1 = null;
                                                v15 = -1;
                                                s3 = null;
                                                break;
                                            }
                                            else {
                                                e3.b.D("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + c1.Q + ". Setting mimeType to audio/x-unknown");
                                                d2 = d5;
                                                s2 = "audio/x-unknown";
                                                goto label_279;
                                            }
                                            goto label_216;
                                        }
                                        case "A_PCM/INT/BIG": {
                                        label_216:
                                            t1 = t0;
                                            d5 = d0;
                                            int v18 = c1.Q;
                                            if(v18 == 8) {
                                                d2 = d5;
                                                s2 = "audio/raw";
                                                v5 = 3;
                                                list1 = null;
                                                v15 = -1;
                                                s3 = null;
                                                break;
                                            }
                                            else {
                                                switch(v18) {
                                                    case 16: {
                                                        v5 = 0x10000000;
                                                        d2 = d5;
                                                        break;
                                                    }
                                                    case 24: {
                                                        v5 = 0x50000000;
                                                        d2 = d5;
                                                        break;
                                                    }
                                                    case 0x20: {
                                                        v5 = 0x60000000;
                                                        d2 = d5;
                                                        break;
                                                    }
                                                    default: {
                                                        e3.b.D("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + c1.Q + ". Setting mimeType to audio/x-unknown");
                                                        d2 = d5;
                                                        s2 = "audio/x-unknown";
                                                        goto label_279;
                                                    }
                                                }
                                            }
                                            s2 = "audio/raw";
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "A_PCM/INT/LIT": {
                                            t1 = t0;
                                            int v19 = x.z(c1.Q);
                                            if(v19 == 0) {
                                                e3.b.D("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + c1.Q + ". Setting mimeType to audio/x-unknown");
                                                d2 = d0;
                                                s2 = "audio/x-unknown";
                                                goto label_279;
                                            }
                                            else {
                                                v5 = v19;
                                                d2 = d0;
                                                s2 = "audio/raw";
                                                list1 = null;
                                                v15 = -1;
                                                s3 = null;
                                                break;
                                            }
                                            goto label_250;
                                        }
                                        case "A_TRUEHD": {
                                        label_48:
                                            t1 = t0;
                                            d2 = d0;
                                            c1.U = new M(0);
                                            s2 = "audio/true-hd";
                                            goto label_279;
                                        }
                                        case "A_VORBIS": {
                                            t1 = t0;
                                            byte[] arr_b = c1.a(s1);
                                            try {
                                                if(arr_b[0] != 2) {
                                                    throw I.a(null, "Error parsing vorbis codec private");
                                                }
                                                int v6 = 0;
                                                int v7 = 1;
                                                int v8;
                                                while((v8 = arr_b[v7] & 0xFF) == 0xFF) {
                                                    v6 += 0xFF;
                                                    ++v7;
                                                }
                                                int v9 = v7 + 1;
                                                int v10 = v6 + v8;
                                                d2 = d0;
                                                int v11 = 0;
                                                int v12;
                                                while((v12 = arr_b[v9] & 0xFF) == 0xFF) {
                                                    v11 += 0xFF;
                                                    ++v9;
                                                }
                                                if(arr_b[v9 + 1] != 1) {
                                                    throw I.a(null, "Error parsing vorbis codec private");
                                                }
                                                byte[] arr_b1 = new byte[v10];
                                                System.arraycopy(arr_b, v9 + 1, arr_b1, 0, v10);
                                                int v13 = v9 + 1 + v10;
                                                if(arr_b[v13] != 3) {
                                                    throw I.a(null, "Error parsing vorbis codec private");
                                                }
                                                int v14 = v13 + (v11 + v12);
                                                if(arr_b[v14] != 5) {
                                                    throw I.a(null, "Error parsing vorbis codec private");
                                                }
                                                byte[] arr_b2 = new byte[arr_b.length - v14];
                                                System.arraycopy(arr_b, v14, arr_b2, 0, arr_b.length - v14);
                                                list0 = new ArrayList(2);
                                                ((ArrayList)list0).add(arr_b1);
                                                ((ArrayList)list0).add(arr_b2);
                                                s2 = "audio/vorbis";
                                                v15 = 0x2000;
                                                s3 = null;
                                                list1 = list0;
                                                v5 = -1;
                                                break;
                                            }
                                            catch(ArrayIndexOutOfBoundsException unused_ex) {
                                                throw I.a(null, "Error parsing vorbis codec private");
                                            }
                                        }
                                        case "S_DVBSUB": {
                                            t1 = t0;
                                            byte[] arr_b4 = new byte[4];
                                            System.arraycopy(c1.a(s1), 0, arr_b4, 0, 4);
                                            list1 = V.t(arr_b4);
                                            d2 = d0;
                                            s2 = "application/dvbsubs";
                                            v5 = -1;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "S_HDMV/PGS": {
                                            t1 = t0;
                                            d2 = d0;
                                            s2 = "application/pgs";
                                            goto label_279;
                                        }
                                        case "S_TEXT/ASS": {
                                        label_250:
                                            t1 = t0;
                                            byte[] arr_b5 = c1.a(s1);
                                            list1 = V.u(d.f0, arr_b5);
                                            d2 = d0;
                                            s2 = "text/x-ssa";
                                            v5 = -1;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "S_TEXT/UTF8": {
                                            t1 = t0;
                                            d2 = d0;
                                            s2 = "application/x-subrip";
                                            goto label_279;
                                        }
                                        case "S_TEXT/WEBVTT": {
                                            t1 = t0;
                                            d2 = d0;
                                            s2 = "text/vtt";
                                            goto label_279;
                                        }
                                        case "S_VOBSUB": {
                                            t1 = t0;
                                            list1 = V.t(c1.a(s1));
                                            d2 = d0;
                                            s2 = "application/vobsub";
                                            v5 = -1;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "V_AV1": {
                                            t1 = t0;
                                            d4 = d0;
                                            s2 = "video/av01";
                                            d2 = d4;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "V_MPEG2": {
                                            t1 = t0;
                                            d4 = d0;
                                            s2 = "video/mpeg2";
                                            d2 = d4;
                                        label_279:
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "V_MPEG4/ISO/AP": {
                                            goto label_142;
                                        }
                                        case "V_MPEG4/ISO/ASP": {
                                        label_142:
                                            t1 = t0;
                                            d2 = d0;
                                            s2 = "video/mp4v-es";
                                            list1 = c1.k == null ? null : Collections.singletonList(c1.k);
                                            v5 = -1;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "V_MPEG4/ISO/AVC": {
                                            t1 = t0;
                                            e e0 = e.a(new p(c1.a(c1.b)));
                                            list1 = e0.a;
                                            c1.Z = e0.b;
                                            s2 = "video/avc";
                                            s3 = e0.l;
                                            d2 = d0;
                                            v5 = -1;
                                            v15 = -1;
                                            break;
                                        }
                                        case "V_MPEG4/ISO/SP": {
                                            goto label_142;
                                        }
                                        case "V_MPEGH/ISO/HEVC": {
                                            t1 = t0;
                                            A a2 = A.a(new p(c1.a(c1.b)), false, null);
                                            list1 = a2.a;
                                            c1.Z = a2.b;
                                            s2 = "video/hevc";
                                            s3 = a2.k;
                                            d2 = d0;
                                            v5 = -1;
                                            v15 = -1;
                                            break;
                                        }
                                        case "V_MS/VFW/FOURCC": {
                                            t1 = t0;
                                            p p1 = new p(c1.a(c1.b));
                                            try {
                                                p1.H(16);
                                                long v16 = p1.l();
                                                if(v16 == 1482049860L) {
                                                    pair0 = new Pair("video/divx", null);
                                                    s3 = null;
                                                    s2 = (String)pair0.first;
                                                    d2 = d0;
                                                    list1 = (List)pair0.second;
                                                    v5 = -1;
                                                    v15 = -1;
                                                    break;
                                                }
                                                else if(v16 == 0x33363248L) {
                                                    pair0 = new Pair("video/3gpp", null);
                                                    s3 = null;
                                                    s2 = (String)pair0.first;
                                                    d2 = d0;
                                                    list1 = (List)pair0.second;
                                                    v5 = -1;
                                                    v15 = -1;
                                                    break;
                                                }
                                                else if(v16 == 0x31435657L) {
                                                    int v17 = p1.b + 20;
                                                    byte[] arr_b3 = p1.a;
                                                    while(true) {
                                                        if(v17 >= arr_b3.length - 4) {
                                                            throw I.a(null, "Failed to find FourCC VC1 initialization data");
                                                        }
                                                        if(arr_b3[v17] == 0 && arr_b3[v17 + 1] == 0 && arr_b3[v17 + 2] == 1 && arr_b3[v17 + 3] == 15) {
                                                            break;
                                                        }
                                                        ++v17;
                                                    }
                                                    pair0 = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(arr_b3, v17, arr_b3.length)));
                                                    s3 = null;
                                                    s2 = (String)pair0.first;
                                                    d2 = d0;
                                                    list1 = (List)pair0.second;
                                                    v5 = -1;
                                                    v15 = -1;
                                                    break;
                                                }
                                                else {
                                                    goto label_128;
                                                }
                                                s2 = (String)pair0.first;
                                                d2 = d0;
                                                list1 = (List)pair0.second;
                                                v5 = -1;
                                                v15 = -1;
                                                break;
                                            }
                                            catch(ArrayIndexOutOfBoundsException unused_ex) {
                                                throw I.a(null, "Error parsing FourCC private data");
                                            }
                                            s3 = null;
                                            s2 = (String)pair0.first;
                                            d2 = d0;
                                            list1 = (List)pair0.second;
                                            v5 = -1;
                                            v15 = -1;
                                            break;
                                        label_128:
                                            e3.b.D("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                                            s3 = null;
                                            pair0 = new Pair("video/x-unknown", null);
                                            s2 = (String)pair0.first;
                                            d2 = d0;
                                            list1 = (List)pair0.second;
                                            v5 = -1;
                                            v15 = -1;
                                            break;
                                        }
                                        case "V_THEORA": {
                                            s2 = "video/x-unknown";
                                            t1 = t0;
                                            d2 = d0;
                                            goto label_279;
                                        }
                                        case "V_VP8": {
                                            t1 = t0;
                                            d4 = d0;
                                            s2 = "video/x-vnd.on2.vp8";
                                            d2 = d4;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        case "V_VP9": {
                                            t1 = t0;
                                            d4 = d0;
                                            s2 = "video/x-vnd.on2.vp9";
                                            d2 = d4;
                                            v5 = -1;
                                            list1 = null;
                                            v15 = -1;
                                            s3 = null;
                                            break;
                                        }
                                        default: {
                                            throw I.a(null, "Unrecognized codec identifier.");
                                        }
                                    }
                                    if(c1.O != null) {
                                        q q0 = q.g(new p(c1.O));
                                        if(q0 != null) {
                                            s3 = q0.b;
                                            s2 = "video/dolby-vision";
                                        }
                                    }
                                    boolean z1 = c1.W;
                                    n n0 = new n();
                                    Map map0 = d.j0;
                                    if(H.h(s2)) {
                                        n0.B = c1.P;
                                        n0.C = c1.R;
                                        n0.D = v5;
                                        v20 = 1;
                                    }
                                    else if(H.k(s2)) {
                                        if(c1.r == 0) {
                                            c1.p = c1.p == -1 ? c1.m : c1.p;
                                            c1.q = c1.q == -1 ? c1.n : c1.q;
                                        }
                                        int v21 = c1.p;
                                        if(v21 == -1) {
                                            f1 = -1.0f;
                                        }
                                        else {
                                            int v22 = c1.q;
                                            if(v22 != -1) {
                                                f1 = ((float)(c1.n * v21)) / ((float)(c1.m * v22));
                                            }
                                        }
                                        if(c1.y) {
                                            if(c1.E == -1.0f || c1.F == -1.0f || c1.G == -1.0f || c1.H == -1.0f || c1.I == -1.0f || c1.J == -1.0f || c1.K == -1.0f || c1.L == -1.0f || c1.M == -1.0f || c1.N == -1.0f) {
                                                arr_b7 = null;
                                            }
                                            else {
                                                byte[] arr_b6 = new byte[25];
                                                ByteBuffer byteBuffer1 = ByteBuffer.wrap(arr_b6).order(ByteOrder.LITTLE_ENDIAN);
                                                byteBuffer1.put(0);
                                                byteBuffer1.putShort(((short)(((int)(c1.E * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.F * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.G * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.H * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.I * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.J * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.K * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.L * 50000.0f + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.M + 0.5f)))));
                                                byteBuffer1.putShort(((short)(((int)(c1.N + 0.5f)))));
                                                byteBuffer1.putShort(((short)c1.C));
                                                byteBuffer1.putShort(((short)c1.D));
                                                arr_b7 = arr_b6;
                                            }
                                            i0 = new i(c1.z, c1.B, c1.A, c1.o, c1.o, arr_b7);
                                        }
                                        else {
                                            i0 = null;
                                        }
                                        int v23 = c1.a == null || !map0.containsKey(c1.a) ? -1 : ((int)(((Integer)map0.get(c1.a))));
                                        if(c1.s != 0 || Float.compare(c1.t, 0.0f) != 0 || Float.compare(c1.u, 0.0f) != 0) {
                                            v24 = v23;
                                        }
                                        else if(Float.compare(c1.v, 0.0f) == 0) {
                                            v24 = 0;
                                        }
                                        else if(Float.compare(c1.v, 90.0f) == 0) {
                                            v24 = 90;
                                        }
                                        else if(Float.compare(c1.v, -180.0f) == 0 || Float.compare(c1.v, 180.0f) == 0) {
                                            v24 = 180;
                                        }
                                        else if(Float.compare(c1.v, -90.0f) == 0) {
                                            v24 = 270;
                                        }
                                        n0.t = c1.m;
                                        n0.u = c1.n;
                                        n0.x = f1;
                                        n0.w = v24;
                                        n0.y = c1.w;
                                        n0.z = c1.x;
                                        n0.A = i0;
                                        v20 = 2;
                                    }
                                    else {
                                        if(!"application/x-subrip".equals(s2) && !"text/x-ssa".equals(s2) && !"text/vtt".equals(s2) && !"application/vobsub".equals(s2) && !"application/pgs".equals(s2) && !"application/dvbsubs".equals(s2)) {
                                            throw I.a(null, "Unexpected MIME type.");
                                        }
                                        v20 = 3;
                                    }
                                    if(c1.a != null && !map0.containsKey(c1.a)) {
                                        n0.b = c1.a;
                                    }
                                    n0.a = Integer.toString(v2);
                                    n0.m = H.l(s2);
                                    n0.n = v15;
                                    n0.d = c1.X;
                                    n0.e = z1;
                                    n0.p = list1;
                                    n0.j = s3;
                                    n0.q = c1.l;
                                    androidx.media3.common.b b1 = new androidx.media3.common.b(n0);
                                    L l0 = t1.track(c1.c, v20);
                                    c1.Y = l0;
                                    l0.b(b1);
                                    sparseArray0.put(c1.c, c1);
                                    d1 = d2;
                                    break;
                                }
                                default: {
                                    d1 = d0;
                                }
                            }
                            d1.w = null;
                            goto label_711;
                        }
                        case 0x4DBB: {
                            int v25 = d0.y;
                            if(v25 == -1) {
                                throw I.a(null, "Mandatory element SeekID or SeekPosition not found");
                            }
                            long v26 = d0.z;
                            if(v26 == -1L) {
                                throw I.a(null, "Mandatory element SeekID or SeekPosition not found");
                            }
                            if(v25 == 0x1C53BB6B) {
                                d0.B = v26;
                            }
                            goto label_711;
                        }
                        case 0x6240: {
                            d0.f(0x6240);
                            c c2 = d0.w;
                            if(c2.h) {
                                K k0 = c2.j;
                                if(k0 == null) {
                                    throw I.a(null, "Encrypted Track found but ContentEncKeyID was not found");
                                }
                                c2.l = new DrmInitData(null, true, new SchemeData[]{new SchemeData(h.a, null, "video/webm", k0.b)});
                            }
                            goto label_711;
                        }
                        case 0x6D80: {
                            d0.f(0x6D80);
                            if(d0.w.h && d0.w.i != null) {
                                throw I.a(null, "Combining encryption and compression is not supported");
                            }
                            goto label_711;
                        }
                        case 357149030: {
                            if(d0.t == 0x8000000000000001L) {
                                d0.t = 1000000L;
                            }
                            long v27 = d0.u;
                            if(v27 != 0x8000000000000001L) {
                                d0.v = d0.k(v27);
                            }
                            goto label_711;
                        }
                        case 0x1654AE6B: {
                            if(sparseArray0.size() == 0) {
                                throw I.a(null, "No valid tracks were found");
                            }
                            d0.d0.endTracks();
                            goto label_711;
                        }
                        case 0x1C53BB6B: {
                            break;
                        }
                        default: {
                            goto label_711;
                        }
                    }
                    if(!d0.x) {
                        t t2 = d0.d0;
                        b b2 = d0.E;
                        b b3 = d0.F;
                        if(d0.s == -1L || d0.v == 0x8000000000000001L || b2 == null) {
                            w0 = new w(d0.v);
                        }
                        else {
                            int v28 = b2.b;
                            if(v28 != 0 && b3 != null && b3.b == v28) {
                                int[] arr_v = new int[v28];
                                long[] arr_v1 = new long[v28];
                                long[] arr_v2 = new long[v28];
                                long[] arr_v3 = new long[v28];
                                for(int v29 = 0; v29 < v28; ++v29) {
                                    arr_v3[v29] = b2.f(v29);
                                    long v30 = d0.s;
                                    arr_v1[v29] = b3.f(v29) + v30;
                                }
                                long[] arr_v4 = arr_v2;
                                for(int v31 = 0; v31 < v28 - 1; ++v31) {
                                    arr_v[v31] = (int)(arr_v1[v31 + 1] - arr_v1[v31]);
                                    arr_v4[v31] = arr_v3[v31 + 1] - arr_v3[v31];
                                }
                                int v32;
                                for(v32 = v28 - 1; v32 > 0 && arr_v3[v32] > d0.v; --v32) {
                                }
                                arr_v[v32] = (int)(d0.s + d0.r - arr_v1[v32]);
                                arr_v4[v32] = d0.v - arr_v3[v32];
                                if(v32 < v28 - 1) {
                                    e3.b.D("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration");
                                    arr_v = Arrays.copyOf(arr_v, v32 + 1);
                                    arr_v1 = Arrays.copyOf(arr_v1, v32 + 1);
                                    arr_v5 = Arrays.copyOf(arr_v4, v32 + 1);
                                    arr_v3 = Arrays.copyOf(arr_v3, v32 + 1);
                                }
                                else {
                                    arr_v5 = arr_v4;
                                }
                                w0 = new l(arr_v, arr_v1, arr_v5, arr_v3);
                            }
                        }
                        t2.n(w0);
                        d0.x = true;
                    }
                    d0.E = null;
                    d0.F = null;
                    goto label_711;
                }
                d d6 = d0;
                if(d6.I == 2) {
                    c c3 = (c)sparseArray0.get(d6.O);
                    c3.Y.getClass();
                    if(d6.T > 0L && "A_OPUS".equals(c3.b)) {
                        byte[] arr_b8 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(d6.T).array();
                        d6.p.getClass();
                        d6.p.E(arr_b8, arr_b8.length);
                    }
                    int v34 = 0;
                    for(int v33 = 0; v33 < d6.M; ++v33) {
                        v34 += d6.N[v33];
                    }
                    int v35 = 0;
                    while(v35 < d6.M) {
                        long v36 = d6.J + ((long)(c3.e * v35 / 1000));
                        int v37 = v35 != 0 || d6.S ? d6.Q : d6.Q | 1;
                        int v38 = d6.N[v35];
                        int v39 = v34 - v38;
                        d6.g(c3, v36, v37, v38, v39);
                        ++v35;
                        v34 = v39;
                    }
                    d6.I = 0;
                    goto label_711;
                label_507:
                    if(b0.c == 0) {
                        long v40 = f0.b(s0, true, false, 4);
                        if(v40 == -2L) {
                            byte[] arr_b9 = b0.a;
                            s0.resetPeekPosition();
                            while(true) {
                                s0.peekFully(arr_b9, 0, 4);
                                int v41 = arr_b9[0];
                                int v42 = 0;
                                while(true) {
                                    v43 = -1;
                                    if(v42 < 8) {
                                        if((f.d[v42] & ((long)v41)) == 0L) {
                                            ++v42;
                                            continue;
                                        }
                                        else {
                                            v43 = v42 + 1;
                                        }
                                    }
                                    break;
                                }
                                if(v43 != -1 && v43 <= 4) {
                                    v44 = (int)f.a(arr_b9, v43, false);
                                    I7.c c4 = (I7.c)b0.g;
                                    if(v44 != 357149030 && v44 != 0x1F43B675 && v44 != 0x1C53BB6B && v44 != 0x1654AE6B) {
                                        goto label_527;
                                    }
                                    break;
                                }
                            label_527:
                                s0.skipFully(1);
                            }
                            s0.skipFully(v43);
                            v45 = (long)v44;
                        }
                        else {
                            v45 = v40;
                        }
                        if(v45 == -1L) {
                            z = false;
                            goto label_712;
                        }
                        else {
                            b0.d = (int)v45;
                            b0.c = 1;
                        }
                    }
                    if(b0.c == 1) {
                        b0.e = f0.b(s0, false, true, 8);
                        b0.c = 2;
                    }
                    c5 = (I7.c)b0.g;
                    v46 = b0.d;
                    switch(v46) {
                        case 0xA1: 
                        case 0xA3: 
                        case 0xA5: 
                        case 0x41ED: 
                        case 0x4255: 
                        case 18402: 
                        case 0x53AB: 
                        case 25506: 
                        case 30322: {
                            c5.w(v46, ((int)b0.e), s0);
                            b0.c = 0;
                            break;
                        }
                        case 0xB5: 
                        case 0x4489: 
                        case 0x55D1: 
                        case 21970: 
                        case 0x55D3: 
                        case 0x55D4: 
                        case 0x55D5: 
                        case 0x55D6: 
                        case 0x55D7: 
                        case 0x55D8: 
                        case 0x55D9: 
                        case 0x55DA: 
                        case 30323: 
                        case 30324: 
                        case 30325: {
                            goto label_659;
                        }
                        case 0x86: 
                        case 17026: 
                        case 0x536E: 
                        case 0x22B59C: {
                            goto label_553;
                        }
                        case 0x83: 
                        case 0x88: 
                        case 0x9B: 
                        case 0x9F: 
                        case 0xB0: 
                        case 0xB3: 
                        case 0xBA: 
                        case 0xD7: 
                        case 0xE7: 
                        case 0xEE: 
                        case 0xF1: 
                        case 0xFB: 
                        case 0x41E7: 
                        case 16980: 
                        case 17029: 
                        case 0x42F7: 
                        case 18401: 
                        case 18408: 
                        case 0x5031: 
                        case 20530: 
                        case 21420: 
                        case 0x53B8: 
                        case 0x54B0: 
                        case 0x54B2: 
                        case 21690: 
                        case 21930: 
                        case 0x55B2: 
                        case 0x55B9: 
                        case 0x55BA: 
                        case 0x55BB: 
                        case 0x55BC: 
                        case 0x55BD: 
                        case 0x55EE: 
                        case 0x56AA: 
                        case 22203: 
                        case 0x6264: 
                        case 30114: 
                        case 30321: 
                        case 2352003: 
                        case 2807729: {
                            break alab1;
                        }
                        case 0xA0: 
                        case 0xA6: 
                        case 0xAE: 
                        case 0xB7: 
                        case 0xBB: 
                        case 0xE0: 
                        case 0xE1: 
                        case 0x41E4: 
                        case 18407: 
                        case 0x4DBB: 
                        case 0x5034: 
                        case 0x5035: 
                        case 0x55B0: 
                        case 0x55D0: 
                        case 0x6240: 
                        case 0x6D80: 
                        case 30113: 
                        case 30320: 
                        case 290298740: 
                        case 357149030: 
                        case 0x1654AE6B: 
                        case 0x18538067: 
                        case 0x1A45DFA3: 
                        case 0x1C53BB6B: 
                        case 0x1F43B675: {
                            goto label_580;
                        }
                        default: {
                            s0.skipFully(((int)b0.e));
                            b0.c = 0;
                            continue;
                        }
                    }
                }
                goto label_711;
            }
            long v47 = b0.e;
            if(v47 <= 8L) {
                c5.M(v46, b0.b(s0, ((int)v47)));
            }
            else {
                throw I.a(null, "Invalid integer size: " + b0.e);
            label_553:
                long v48 = b0.e;
                if(v48 > 0x7FFFFFFFL) {
                    throw I.a(null, "String element size: " + b0.e);
                }
                int v49 = (int)v48;
                if(v49 == 0) {
                    s4 = "";
                }
                else {
                    byte[] arr_b10 = new byte[v49];
                    s0.readFully(arr_b10, 0, v49);
                    while(v49 > 0 && arr_b10[v49 - 1] == 0) {
                        --v49;
                    }
                    s4 = new String(arr_b10, 0, v49);
                }
                d d7 = (d)c5.b;
                switch(v46) {
                    case 0x86: {
                        d7.f(0x86);
                        d7.w.b = s4;
                        break;
                    }
                    case 17026: {
                        if(!"webm".equals(s4) && !"matroska".equals(s4)) {
                            throw I.a(null, "DocType " + s4 + " not supported");
                        }
                        break;
                    }
                    case 0x536E: {
                        d7.f(0x536E);
                        d7.w.a = s4;
                        break;
                    }
                    case 0x22B59C: {
                        d7.f(0x22B59C);
                        d7.w.X = s4;
                        break;
                    label_580:
                        long v50 = s0.getPosition();
                        arrayDeque0.push(new a(b0.d, b0.e + v50));
                        int v51 = b0.d;
                        long v52 = b0.e;
                        d d8 = (d)((I7.c)b0.g).b;
                        e3.b.k(d8.d0);
                        switch(v51) {
                            case 0xA0: {
                                d8.S = false;
                                d8.T = 0L;
                                break;
                            }
                            case 0xAE: {
                                c c6 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
                                c6.m = -1;
                                c6.n = -1;
                                c6.o = -1;
                                c6.p = -1;
                                c6.q = -1;
                                c6.r = 0;
                                c6.s = -1;
                                c6.t = 0.0f;
                                c6.u = 0.0f;
                                c6.v = 0.0f;
                                c6.w = null;
                                c6.x = -1;
                                c6.y = false;
                                c6.z = -1;
                                c6.A = -1;
                                c6.B = -1;
                                c6.C = 1000;
                                c6.D = 200;
                                c6.E = -1.0f;
                                c6.F = -1.0f;
                                c6.G = -1.0f;
                                c6.H = -1.0f;
                                c6.I = -1.0f;
                                c6.J = -1.0f;
                                c6.K = -1.0f;
                                c6.L = -1.0f;
                                c6.M = -1.0f;
                                c6.N = -1.0f;
                                c6.P = 1;
                                c6.Q = -1;
                                c6.R = 8000;
                                c6.S = 0L;
                                c6.T = 0L;
                                c6.W = true;
                                c6.X = "eng";
                                d8.w = c6;
                                break;
                            }
                            case 0xBB: {
                                d8.G = false;
                                break;
                            }
                            case 0x4DBB: {
                                d8.y = -1;
                                d8.z = -1L;
                                break;
                            }
                            case 0x5035: {
                                d8.f(0x5035);
                                d8.w.h = true;
                                break;
                            }
                            case 0x55D0: {
                                d8.f(0x55D0);
                                d8.w.y = true;
                                break;
                            }
                            case 0x18538067: {
                                if(d8.s != -1L && d8.s != v50) {
                                    throw I.a(null, "Multiple Segment elements not supported");
                                }
                                d8.s = v50;
                                d8.r = v52;
                                break;
                            }
                            case 0x1C53BB6B: {
                                d8.E = new b(1, 0);
                                d8.F = new b(1, 0);
                                break;
                            }
                            case 0x1F43B675: {
                                if(!d8.x) {
                                    if(!d8.d || d8.B == -1L) {
                                        d8.d0.n(new w(d8.v));
                                        d8.x = true;
                                    }
                                    else {
                                        d8.A = true;
                                    }
                                }
                            }
                        }
                        b0.c = 0;
                        goto label_711;
                    label_659:
                        long v53 = b0.e;
                        if(v53 != 4L && v53 != 8L) {
                            throw I.a(null, "Invalid float size: " + b0.e);
                        }
                        long v54 = b0.b(s0, ((int)v53));
                        double f2 = ((int)v53) == 4 ? ((double)Float.intBitsToFloat(((int)v54))) : Double.longBitsToDouble(v54);
                        d d9 = (d)c5.b;
                        switch(v46) {
                            case 0xB5: {
                                d9.f(0xB5);
                                d9.w.R = (int)f2;
                                break;
                            }
                            case 0x4489: {
                                d9.u = (long)f2;
                                break;
                            }
                            case 0x55D1: {
                                d9.f(0x55D1);
                                d9.w.E = (float)f2;
                                break;
                            }
                            case 21970: {
                                d9.f(21970);
                                d9.w.F = (float)f2;
                                break;
                            }
                            case 0x55D3: {
                                d9.f(0x55D3);
                                d9.w.G = (float)f2;
                                break;
                            }
                            case 0x55D4: {
                                d9.f(0x55D4);
                                d9.w.H = (float)f2;
                                break;
                            }
                            case 0x55D5: {
                                d9.f(0x55D5);
                                d9.w.I = (float)f2;
                                break;
                            }
                            case 0x55D6: {
                                d9.f(0x55D6);
                                d9.w.J = (float)f2;
                                break;
                            }
                            case 0x55D7: {
                                d9.f(0x55D7);
                                d9.w.K = (float)f2;
                                break;
                            }
                            case 0x55D8: {
                                d9.f(0x55D8);
                                d9.w.L = (float)f2;
                                break;
                            }
                            case 0x55D9: {
                                d9.f(0x55D9);
                                d9.w.M = (float)f2;
                                break;
                            }
                            case 0x55DA: {
                                d9.f(0x55DA);
                                d9.w.N = (float)f2;
                                break;
                            }
                            case 30323: {
                                d9.f(30323);
                                d9.w.t = (float)f2;
                                break;
                            }
                            case 30324: {
                                d9.f(30324);
                                d9.w.u = (float)f2;
                                break;
                            }
                            case 30325: {
                                d9.f(30325);
                                d9.w.v = (float)f2;
                            }
                        }
                    }
                }
            }
            b0.c = 0;
        label_711:
            z = true;
        label_712:
            if(z) {
                long v55 = s0.getPosition();
                if(this.A) {
                    this.C = v55;
                    v0.a = this.B;
                    this.A = false;
                    return 1;
                }
                if(this.x) {
                    long v56 = this.C;
                    if(v56 != -1L) {
                        v0.a = v56;
                        this.C = -1L;
                        return 1;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        if(!z) {
            for(int v57 = 0; true; ++v57) {
                SparseArray sparseArray1 = this.c;
                if(v57 >= sparseArray1.size()) {
                    break;
                }
                c c7 = (c)sparseArray1.valueAt(v57);
                c7.Y.getClass();
                M m0 = c7.U;
                if(m0 != null) {
                    m0.a(c7.Y, c7.j);
                }
            }
            return -1;
        }
        return 0;
    }

    @Override  // B3.r
    public final boolean c(s s0) {
        T3.e e0 = new T3.e(0);
        p p0 = (p)e0.b;
        long v = ((m)s0).c;
        int v1 = Long.compare(v, -1L);
        ((m)s0).peekFully(p0.a, 0, 4, false);
        long v2 = p0.w();
        e0.a = 4;
        while(Long.compare(v2, 0x1A45DFA3L) != 0) {
            int v3 = e0.a + 1;
            e0.a = v3;
            if(v3 == ((int)(v1 == 0 || v > 0x400L ? 0x400L : v))) {
                return false;
            }
            ((m)s0).peekFully(p0.a, 0, 1, false);
            v2 = v2 << 8 & 0xFFFFFFFFFFFFFF00L | ((long)(p0.a[0] & 0xFF));
        }
        long v4 = e0.i(((m)s0));
        long v5 = (long)e0.a;
        if(v4 != 0x8000000000000000L && (v1 == 0 || v5 + v4 < v)) {
            while(true) {
                int v6 = Long.compare(e0.a, v5 + v4);
                if(v6 < 0) {
                    if(e0.i(((m)s0)) == 0x8000000000000000L) {
                        break;
                    }
                    long v7 = e0.i(((m)s0));
                    int v8 = Long.compare(v7, 0L);
                    if(v8 < 0 || v7 > 0x7FFFFFFFL) {
                        break;
                    }
                    if(v8 == 0) {
                        continue;
                    }
                    ((m)s0).a(((int)v7), false);
                    e0.a += (int)v7;
                    continue;
                }
                return v6 == 0;
            }
        }
        return false;
    }

    @Override  // B3.r
    public final void d(t t0) {
        if(this.e) {
            t0 = new d5.m(t0, this.f);
        }
        this.d0 = t0;
    }

    public final void e(int v) {
        if(this.E == null || this.F == null) {
            throw I.a(null, "Element " + v + " must be in a Cues");
        }
    }

    public final void f(int v) {
        if(this.w == null) {
            throw I.a(null, "Element " + v + " must be in a TrackEntry");
        }
    }

    public final void g(c c0, long v, int v1, int v2, int v3) {
        int v6;
        byte[] arr_b1;
        int v4;
        M m0 = c0.U;
        if(m0 == null) {
            if(!"S_TEXT/UTF8".equals(c0.b) && !"S_TEXT/ASS".equals(c0.b) && !"S_TEXT/WEBVTT".equals(c0.b)) {
                v4 = v2;
            }
            else if(this.M > 1) {
                e3.b.D("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                v4 = v2;
            }
            else {
                long v5 = this.K;
                if(v5 == 0x8000000000000001L) {
                    e3.b.D("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    v4 = v2;
                }
                else {
                    String s = c0.b;
                    p p0 = this.m;
                    byte[] arr_b = p0.a;
                    s.getClass();
                    switch(s) {
                        case "S_TEXT/ASS": {
                            arr_b1 = d.h(v5, "%01d:%02d:%02d:%02d", 10000L);
                            v6 = 21;
                            break;
                        }
                        case "S_TEXT/UTF8": {
                            arr_b1 = d.h(v5, "%02d:%02d:%02d,%03d", 1000L);
                            v6 = 19;
                            break;
                        }
                        case "S_TEXT/WEBVTT": {
                            arr_b1 = d.h(v5, "%02d:%02d:%02d.%03d", 1000L);
                            v6 = 25;
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException();
                        }
                    }
                    System.arraycopy(arr_b1, 0, arr_b, v6, arr_b1.length);
                    for(int v7 = p0.b; v7 < p0.c; ++v7) {
                        if(p0.a[v7] == 0) {
                            p0.F(v7);
                            break;
                        }
                    }
                    c0.Y.d(p0, p0.c, 0);
                    v4 = v2 + p0.c;
                }
            }
            if((v1 & 0x10000000) != 0) {
                p p1 = this.p;
                if(this.M > 1) {
                    p1.D(0);
                }
                else {
                    int v8 = p1.c;
                    c0.Y.d(p1, v8, 2);
                    v4 += v8;
                }
            }
            c0.Y.c(v, v1, v4, v3, c0.j);
        }
        else {
            m0.b(c0.Y, v, v1, v2, v3, c0.j);
        }
        this.H = true;
    }

    public static byte[] h(long v, String s, long v1) {
        e3.b.c(v != 0x8000000000000001L);
        long v2 = v - ((long)(((int)(v / 3600000000L)))) * 3600000000L;
        long v3 = v2 - ((long)(((int)(v2 / 60000000L)))) * 60000000L;
        return String.format(Locale.US, s, ((int)(v / 3600000000L)), ((int)(v2 / 60000000L)), ((int)(v3 / 1000000L)), ((int)((v3 - ((long)(((int)(v3 / 1000000L)))) * 1000000L) / v1))).getBytes(StandardCharsets.UTF_8);
    }

    public final void i(s s0, int v) {
        p p0 = this.i;
        if(p0.c >= v) {
            return;
        }
        byte[] arr_b = p0.a;
        if(arr_b.length < v) {
            p0.b(Math.max(arr_b.length * 2, v));
        }
        s0.readFully(p0.a, p0.c, v - p0.c);
        p0.F(v);
    }

    public final void j() {
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = false;
        this.l.D(0);
    }

    public final long k(long v) {
        long v1 = this.t;
        if(v1 == 0x8000000000000001L) {
            throw I.a(null, "Can\'t scale timecode prior to timecodeScale being set.");
        }
        return x.T(v, v1, 1000L, RoundingMode.DOWN);
    }

    public final int l(s s0, c c0, int v, boolean z) {
        int v19;
        int v24;
        if("S_TEXT/UTF8".equals(c0.b)) {
            this.m(s0, d.e0, v);
            int v1 = this.V;
            this.j();
            return v1;
        }
        if("S_TEXT/ASS".equals(c0.b)) {
            this.m(s0, d.g0, v);
            int v2 = this.V;
            this.j();
            return v2;
        }
        if("S_TEXT/WEBVTT".equals(c0.b)) {
            this.m(s0, d.h0, v);
            int v3 = this.V;
            this.j();
            return v3;
        }
        L l0 = c0.Y;
        p p0 = this.l;
        boolean z1 = true;
        if(!this.X) {
            p p1 = this.i;
            if(c0.h) {
                this.Q &= 0xBFFFFFFF;
                int v4 = 0x80;
                if(!this.Y) {
                    s0.readFully(p1.a, 0, 1);
                    ++this.U;
                    byte b = p1.a[0];
                    if((b & 0x80) == 0x80) {
                        throw I.a(null, "Extension bit is set in signal byte");
                    }
                    this.b0 = b;
                    this.Y = true;
                }
                int v5 = this.b0;
                if((v5 & 1) == 1) {
                    boolean z2 = (v5 & 2) == 2;
                    this.Q |= 0x40000000;
                    if(!this.c0) {
                        p p2 = this.n;
                        s0.readFully(p2.a, 0, 8);
                        this.U += 8;
                        this.c0 = true;
                        byte[] arr_b = p1.a;
                        if(!z2) {
                            v4 = 0;
                        }
                        arr_b[0] = (byte)(v4 | 8);
                        p1.G(0);
                        l0.d(p1, 1, 1);
                        ++this.V;
                        p2.G(0);
                        l0.d(p2, 8, 1);
                        this.V += 8;
                    }
                    if(z2) {
                        if(!this.Z) {
                            s0.readFully(p1.a, 0, 1);
                            ++this.U;
                            p1.G(0);
                            this.a0 = p1.u();
                            this.Z = true;
                        }
                        int v6 = this.a0 * 4;
                        p1.D(v6);
                        s0.readFully(p1.a, 0, v6);
                        this.U += v6;
                        int v7 = (short)(this.a0 / 2 + 1);
                        int v8 = v7 * 6 + 2;
                        if(this.q == null || this.q.capacity() < v8) {
                            this.q = ByteBuffer.allocate(v8);
                        }
                        this.q.position(0);
                        this.q.putShort(((short)v7));
                        int v9 = 0;
                        int v10;
                        for(v10 = 0; true; v10 = v12) {
                            int v11 = this.a0;
                            if(v9 >= v11) {
                                break;
                            }
                            int v12 = p1.y();
                            if(v9 % 2 == 0) {
                                this.q.putShort(((short)(v12 - v10)));
                            }
                            else {
                                this.q.putInt(v12 - v10);
                            }
                            ++v9;
                        }
                        int v13 = v - this.U - v10;
                        if(v11 % 2 == 1) {
                            this.q.putInt(v13);
                        }
                        else {
                            this.q.putShort(((short)v13));
                            this.q.putInt(0);
                        }
                        byte[] arr_b1 = this.q.array();
                        this.o.E(arr_b1, v8);
                        l0.d(this.o, v8, 1);
                        this.V += v8;
                    }
                }
            }
            else {
                byte[] arr_b2 = c0.i;
                if(arr_b2 != null) {
                    p0.E(arr_b2, arr_b2.length);
                }
            }
            if(("A_OPUS".equals(c0.b) ? z : c0.f > 0)) {
                this.Q |= 0x10000000;
                this.p.D(0);
                int v14 = p0.c + v - this.U;
                p1.D(4);
                byte[] arr_b3 = p1.a;
                arr_b3[0] = (byte)(v14 >> 24 & 0xFF);
                arr_b3[1] = (byte)(v14 >> 16 & 0xFF);
                arr_b3[2] = (byte)(v14 >> 8 & 0xFF);
                arr_b3[3] = (byte)(v14 & 0xFF);
                l0.d(p1, 4, 2);
                this.V += 4;
            }
            this.X = true;
        }
        int v15 = v + p0.c;
        if("V_MPEG4/ISO/AVC".equals(c0.b) || "V_MPEGH/ISO/HEVC".equals(c0.b)) {
            p p3 = this.h;
            byte[] arr_b4 = p3.a;
            arr_b4[0] = 0;
            arr_b4[1] = 0;
            arr_b4[2] = 0;
            int v20 = c0.Z;
            while(this.U < v15) {
                int v21 = this.W;
                if(v21 == 0) {
                    int v22 = Math.min(v20, p0.a());
                    s0.readFully(arr_b4, 4 - v20 + v22, v20 - v22);
                    if(v22 > 0) {
                        p0.e(arr_b4, 4 - v20, v22);
                    }
                    this.U += v20;
                    p3.G(0);
                    this.W = p3.y();
                    this.g.G(0);
                    l0.d(this.g, 4, 0);
                    this.V += 4;
                }
                else {
                    int v23 = p0.a();
                    if(v23 > 0) {
                        v24 = Math.min(v21, v23);
                        l0.d(p0, v24, 0);
                    }
                    else {
                        v24 = l0.a(s0, v21, false);
                    }
                    this.U += v24;
                    this.V += v24;
                    this.W -= v24;
                }
            }
        }
        else {
            if(c0.U != null) {
                if(p0.c != 0) {
                    z1 = false;
                }
                e3.b.j(z1);
                c0.U.c(s0);
            }
            int v16;
            while((v16 = this.U) < v15) {
                int v17 = v15 - v16;
                int v18 = p0.a();
                if(v18 > 0) {
                    v19 = Math.min(v17, v18);
                    l0.d(p0, v19, 0);
                }
                else {
                    v19 = l0.a(s0, v17, false);
                }
                this.U += v19;
                this.V += v19;
            }
        }
        if("A_VORBIS".equals(c0.b)) {
            this.j.G(0);
            l0.d(this.j, 4, 0);
            this.V += 4;
        }
        int v25 = this.V;
        this.j();
        return v25;
    }

    public final void m(s s0, byte[] arr_b, int v) {
        int v1 = arr_b.length + v;
        p p0 = this.m;
        byte[] arr_b1 = p0.a;
        if(arr_b1.length < v1) {
            byte[] arr_b2 = Arrays.copyOf(arr_b, v1 + v);
            p0.getClass();
            p0.E(arr_b2, arr_b2.length);
        }
        else {
            System.arraycopy(arr_b, 0, arr_b1, 0, arr_b.length);
        }
        s0.readFully(p0.a, arr_b.length, v);
        p0.G(0);
        p0.F(v1);
    }

    @Override  // B3.r
    public final void release() {
    }

    @Override  // B3.r
    public final void seek(long v, long v1) {
        this.D = 0x8000000000000001L;
        this.I = 0;
        this.a.c = 0;
        this.a.b.clear();
        ((f)this.a.f).b = 0;
        ((f)this.a.f).c = 0;
        this.b.b = 0;
        this.b.c = 0;
        this.j();
        for(int v2 = 0; true; ++v2) {
            SparseArray sparseArray0 = this.c;
            if(v2 >= sparseArray0.size()) {
                break;
            }
            M m0 = ((c)sparseArray0.valueAt(v2)).U;
            if(m0 != null) {
                m0.b = false;
                m0.c = 0;
            }
        }
    }
}

