package androidx.media3.common;

import I6.V;
import I6.w;
import android.os.Bundle;
import android.text.TextUtils;
import b3.H;
import b3.h;
import b3.i;
import b3.n;
import b3.q;
import e3.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import k8.Y;

public final class b {
    public final int A;
    public final i B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public int M;
    public static final b N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final String T;
    public static final String U;
    public static final String V;
    public static final String W;
    public static final String X;
    public static final String Y;
    public static final String Z;
    public final String a;
    public static final String a0;
    public final String b;
    public static final String b0;
    public final V c;
    public static final String c0;
    public final String d;
    public static final String d0;
    public final int e;
    public static final String e0;
    public final int f;
    public static final String f0;
    public final int g;
    public static final String g0;
    public final int h;
    public static final String h0;
    public final int i;
    public static final String i0;
    public final int j;
    public static final String j0;
    public final String k;
    public static final String k0;
    public final Metadata l;
    public static final String l0;
    public final String m;
    public static final String m0;
    public final String n;
    public static final String n0;
    public final int o;
    public static final String o0;
    public final int p;
    public static final String p0;
    public final List q;
    public static final String q0;
    public final DrmInitData r;
    public static final String r0;
    public final long s;
    public static final String s0;
    public final boolean t;
    public static final String t0;
    public final int u;
    public static final String u0;
    public final int v;
    public static final String v0;
    public final float w;
    public final int x;
    public final float y;
    public final byte[] z;

    static {
        b.N = new b(new n());
        b.O = "0";
        b.P = "1";
        b.Q = "2";
        b.R = "3";
        b.S = "4";
        b.T = "5";
        b.U = "6";
        b.V = "7";
        b.W = "8";
        b.X = "9";
        b.Y = "a";
        b.Z = "b";
        b.a0 = "c";
        b.b0 = "d";
        b.c0 = "e";
        b.d0 = "f";
        b.e0 = "g";
        b.f0 = "h";
        b.g0 = "i";
        b.h0 = "j";
        b.i0 = "k";
        b.j0 = "l";
        b.k0 = "m";
        b.l0 = "n";
        b.m0 = "o";
        b.n0 = "p";
        b.o0 = "q";
        b.p0 = "r";
        b.q0 = "s";
        b.r0 = "t";
        b.s0 = "u";
        b.t0 = "v";
        b.u0 = "w";
        b.v0 = "x";
    }

    public b(n n0) {
        String s1;
        boolean z;
        this.a = n0.a;
        String s = x.N(n0.d);
        this.d = s;
        int v = 0;
        if(n0.c.isEmpty() && n0.b != null) {
            this.c = V.t(new q(s, n0.b));
            this.b = n0.b;
        }
        else if(n0.c.isEmpty() || n0.b != null) {
            if(!n0.c.isEmpty() || n0.b != null) {
                z = false;
                int v2 = 0;
                while(v2 < n0.c.size()) {
                    if(((q)n0.c.get(v2)).b.equals(n0.b)) {
                        goto label_30;
                    }
                    ++v2;
                }
            }
            else {
            label_30:
                z = true;
            }
            e3.b.j(z);
            this.c = n0.c;
            this.b = n0.b;
        }
        else {
            V v1 = n0.c;
            this.c = v1;
            for(Object object0: v1) {
                q q0 = (q)object0;
                if(!TextUtils.equals(q0.a, s)) {
                    continue;
                }
                s1 = q0.b;
                goto label_20;
            }
            s1 = ((q)v1.get(0)).b;
        label_20:
            this.b = s1;
        }
        this.e = n0.e;
        e3.b.i("Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set", n0.g == 0 || (n0.f & 0x8000) != 0);
        this.f = n0.f;
        this.g = n0.g;
        int v3 = n0.h;
        this.h = v3;
        int v4 = n0.i;
        this.i = v4;
        if(v4 != -1) {
            v3 = v4;
        }
        this.j = v3;
        this.k = n0.j;
        this.l = n0.k;
        this.m = n0.l;
        this.n = n0.m;
        this.o = n0.n;
        this.p = n0.o;
        this.q = n0.p == null ? Collections.EMPTY_LIST : n0.p;
        DrmInitData drmInitData0 = n0.q;
        this.r = drmInitData0;
        this.s = n0.r;
        this.t = n0.s;
        this.u = n0.t;
        this.v = n0.u;
        this.w = n0.v;
        this.x = n0.w == -1 ? 0 : n0.w;
        this.y = n0.x == -1.0f ? 1.0f : n0.x;
        this.z = n0.y;
        this.A = n0.z;
        this.B = n0.A;
        this.C = n0.B;
        this.D = n0.C;
        this.E = n0.D;
        this.F = n0.E == -1 ? 0 : n0.E;
        int v5 = n0.F;
        if(v5 != -1) {
            v = v5;
        }
        this.G = v;
        this.H = n0.G;
        this.I = n0.H;
        this.J = n0.I;
        this.K = n0.J;
        int v6 = n0.K;
        if(v6 == 0 && drmInitData0 != null) {
            this.L = 1;
            return;
        }
        this.L = v6;
    }

    public final n a() {
        n n0 = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
        n0.a = this.a;
        n0.b = this.b;
        n0.c = this.c;
        n0.d = this.d;
        n0.e = this.e;
        n0.f = this.f;
        n0.h = this.h;
        n0.i = this.i;
        n0.j = this.k;
        n0.k = this.l;
        n0.l = this.m;
        n0.m = this.n;
        n0.n = this.o;
        n0.o = this.p;
        n0.p = this.q;
        n0.q = this.r;
        n0.r = this.s;
        n0.s = this.t;
        n0.t = this.u;
        n0.u = this.v;
        n0.v = this.w;
        n0.w = this.x;
        n0.x = this.y;
        n0.y = this.z;
        n0.z = this.A;
        n0.A = this.B;
        n0.B = this.C;
        n0.C = this.D;
        n0.D = this.E;
        n0.E = this.F;
        n0.F = this.G;
        n0.G = this.H;
        n0.H = this.I;
        n0.I = this.J;
        n0.J = this.K;
        n0.K = this.L;
        return n0;
    }

    public final boolean b(b b0) {
        List list0 = this.q;
        if(list0.size() != b0.q.size()) {
            return false;
        }
        for(int v = 0; v < list0.size(); ++v) {
            if(!Arrays.equals(((byte[])list0.get(v)), ((byte[])b0.q.get(v)))) {
                return false;
            }
        }
        return true;
    }

    public final Bundle c(boolean z) {
        Bundle bundle0 = new Bundle();
        bundle0.putString(b.O, this.a);
        bundle0.putString(b.P, this.b);
        ArrayList arrayList0 = new ArrayList(this.c.size());
        for(Object object0: this.c) {
            ((q)object0).getClass();
            Bundle bundle1 = new Bundle();
            String s = ((q)object0).a;
            if(s != null) {
                bundle1.putString("0", s);
            }
            bundle1.putString("1", ((q)object0).b);
            arrayList0.add(bundle1);
        }
        bundle0.putParcelableArrayList(b.u0, arrayList0);
        bundle0.putString(b.Q, this.d);
        bundle0.putInt(b.R, this.e);
        bundle0.putInt(b.S, this.f);
        int v = this.g;
        if(v != b.N.g) {
            bundle0.putInt(b.v0, v);
        }
        bundle0.putInt(b.T, this.h);
        bundle0.putInt(b.U, this.i);
        bundle0.putString(b.V, this.k);
        if(!z) {
            bundle0.putParcelable(b.W, this.l);
        }
        bundle0.putString(b.X, this.m);
        bundle0.putString(b.Y, this.n);
        bundle0.putInt(b.Z, this.o);
        for(int v1 = 0; true; ++v1) {
            List list0 = this.q;
            if(v1 >= list0.size()) {
                break;
            }
            bundle0.putByteArray(b.a0 + "_" + Integer.toString(v1, 36), ((byte[])list0.get(v1)));
        }
        bundle0.putParcelable(b.b0, this.r);
        bundle0.putLong(b.c0, this.s);
        bundle0.putInt(b.d0, this.u);
        bundle0.putInt(b.e0, this.v);
        bundle0.putFloat(b.f0, this.w);
        bundle0.putInt(b.g0, this.x);
        bundle0.putFloat(b.h0, this.y);
        bundle0.putByteArray(b.i0, this.z);
        bundle0.putInt(b.j0, this.A);
        i i0 = this.B;
        if(i0 != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("0", i0.a);
            bundle2.putInt("1", i0.b);
            bundle2.putInt("2", i0.c);
            bundle2.putByteArray("3", i0.d);
            bundle2.putInt("4", i0.e);
            bundle2.putInt("5", i0.f);
            bundle0.putBundle(b.k0, bundle2);
        }
        bundle0.putInt(b.l0, this.C);
        bundle0.putInt(b.m0, this.D);
        bundle0.putInt(b.n0, this.E);
        bundle0.putInt(b.o0, this.F);
        bundle0.putInt(b.p0, this.G);
        bundle0.putInt(b.q0, this.H);
        bundle0.putInt(b.s0, this.J);
        bundle0.putInt(b.t0, this.K);
        bundle0.putInt(b.r0, this.L);
        return bundle0;
    }

    public static String d(b b0) {
        String s3;
        int v11;
        DrmInitData drmInitData1;
        if(b0 == null) {
            return "null";
        }
        String s = b0.d;
        int v = b0.D;
        int v1 = b0.C;
        float f = b0.w;
        i i0 = b0.B;
        float f1 = b0.y;
        int v2 = b0.v;
        int v3 = b0.u;
        DrmInitData drmInitData0 = b0.r;
        String s1 = b0.k;
        int v4 = b0.j;
        String s2 = b0.m;
        int v5 = b0.e;
        int v6 = b0.f;
        B3.q q0 = new B3.q(",");
        StringBuilder stringBuilder0 = Y.p("id=");
        V v7 = b0.c;
        stringBuilder0.append(b0.a);
        stringBuilder0.append(", mimeType=");
        stringBuilder0.append(b0.n);
        if(s2 != null) {
            stringBuilder0.append(", container=");
            stringBuilder0.append(s2);
        }
        if(v4 != -1) {
            stringBuilder0.append(", bitrate=");
            stringBuilder0.append(v4);
        }
        if(s1 != null) {
            stringBuilder0.append(", codecs=");
            stringBuilder0.append(s1);
        }
        if(drmInitData0 != null) {
            LinkedHashSet linkedHashSet0 = new LinkedHashSet();
            int v8 = 0;
            while(v8 < drmInitData0.d) {
                UUID uUID0 = drmInitData0.a[v8].b;
                if(uUID0.equals(h.b)) {
                    linkedHashSet0.add("cenc");
                    drmInitData1 = drmInitData0;
                }
                else if(uUID0.equals(h.c)) {
                    linkedHashSet0.add("clearkey");
                    drmInitData1 = drmInitData0;
                }
                else if(uUID0.equals(h.e)) {
                    linkedHashSet0.add("playready");
                    drmInitData1 = drmInitData0;
                }
                else if(uUID0.equals(h.d)) {
                    linkedHashSet0.add("widevine");
                    drmInitData1 = drmInitData0;
                }
                else if(uUID0.equals(h.a)) {
                    linkedHashSet0.add("universal");
                    drmInitData1 = drmInitData0;
                }
                else {
                    drmInitData1 = drmInitData0;
                    linkedHashSet0.add("unknown (" + uUID0 + ")");
                }
                ++v8;
                drmInitData0 = drmInitData1;
            }
            stringBuilder0.append(", drm=[");
            q0.b(stringBuilder0, linkedHashSet0.iterator());
            stringBuilder0.append(']');
        }
        if(v3 != -1 && v2 != -1) {
            stringBuilder0.append(", res=");
            stringBuilder0.append(v3);
            stringBuilder0.append("x");
            stringBuilder0.append(v2);
        }
        if(Math.copySign(((double)f1) - 1.0, 1.0) > 0.001 && ((double)f1) != 1.0) {
            stringBuilder0.append(", par=");
            stringBuilder0.append(String.format(Locale.US, "%.3f", f1));
        }
        if(i0 != null) {
            int v9 = i0.f;
            int v10 = i0.e;
            if(v10 != -1 && v9 != -1 || i0.d()) {
                stringBuilder0.append(", color=");
                stringBuilder0.append((i0.d() ? U4.x.l(i.b(i0.a), "/", i.a(i0.b), "/", i.c(i0.c)) : "NA/NA/NA") + "/" + (v10 == -1 || v9 == -1 ? "NA/NA" : v10 + "/" + v9));
            }
        }
        if(f != -1.0f) {
            stringBuilder0.append(", fps=");
            stringBuilder0.append(f);
        }
        if(v1 != -1) {
            stringBuilder0.append(", channels=");
            stringBuilder0.append(v1);
        }
        if(v != -1) {
            stringBuilder0.append(", sample_rate=");
            stringBuilder0.append(v);
        }
        if(s != null) {
            stringBuilder0.append(", language=");
            stringBuilder0.append(s);
        }
        if(!v7.isEmpty()) {
            stringBuilder0.append(", labels=[");
            q0.b(stringBuilder0, w.w(new androidx.media3.exoplayer.x(29), v7).iterator());
            stringBuilder0.append("]");
        }
        if(v5 != 0) {
            stringBuilder0.append(", selectionFlags=[");
            ArrayList arrayList0 = new ArrayList();
            if((v5 & 4) != 0) {
                arrayList0.add("auto");
            }
            if((v5 & 1) != 0) {
                arrayList0.add("default");
            }
            if((v5 & 2) != 0) {
                arrayList0.add("forced");
            }
            q0.b(stringBuilder0, arrayList0.iterator());
            stringBuilder0.append("]");
        }
        if(v6 == 0) {
            v11 = 0;
        }
        else {
            stringBuilder0.append(", roleFlags=[");
            ArrayList arrayList1 = new ArrayList();
            if((v6 & 1) != 0) {
                arrayList1.add("main");
            }
            if((v6 & 2) != 0) {
                arrayList1.add("alt");
            }
            if((v6 & 4) != 0) {
                arrayList1.add("supplementary");
            }
            if((v6 & 8) != 0) {
                arrayList1.add("commentary");
            }
            if((v6 & 16) != 0) {
                arrayList1.add("dub");
            }
            if((v6 & 0x20) != 0) {
                arrayList1.add("emergency");
            }
            if((v6 & 0x40) != 0) {
                arrayList1.add("caption");
            }
            v11 = v6;
            if((v11 & 0x80) != 0) {
                arrayList1.add("subtitle");
            }
            if((v11 & 0x100) != 0) {
                arrayList1.add("sign");
            }
            if((v11 & 0x200) != 0) {
                arrayList1.add("describes-video");
            }
            if((v11 & 0x400) != 0) {
                arrayList1.add("describes-music");
            }
            if((v11 & 0x800) != 0) {
                arrayList1.add("enhanced-intelligibility");
            }
            if((v11 & 0x1000) != 0) {
                arrayList1.add("transcribes-dialog");
            }
            if((v11 & 0x2000) != 0) {
                arrayList1.add("easy-read");
            }
            if((v11 & 0x4000) != 0) {
                arrayList1.add("trick-play");
            }
            if((v11 & 0x8000) != 0) {
                arrayList1.add("auxiliary");
            }
            q0.b(stringBuilder0, arrayList1.iterator());
            stringBuilder0.append("]");
        }
        if((v11 & 0x8000) != 0) {
            stringBuilder0.append(", auxiliaryTrackType=");
            int v12 = b0.g;
            if(v12 == 0) {
                s3 = "undefined";
            }
            else {
                switch(v12) {
                    case 1: {
                        s3 = "original";
                        break;
                    }
                    case 2: {
                        s3 = "depth-linear";
                        break;
                    }
                    case 3: {
                        s3 = "depth-inverse";
                        break;
                    }
                    case 4: {
                        s3 = "depth metadata";
                        break;
                    }
                    default: {
                        throw new IllegalStateException("Unsupported auxiliary track type");
                    }
                }
            }
            stringBuilder0.append(s3);
        }
        return stringBuilder0.toString();
    }

    public final b e(b b0) {
        int v13;
        int v11;
        String s6;
        String s2;
        if(this == b0) {
            return this;
        }
        int v = H.g(this.n);
        String s = b0.a;
        Metadata metadata0 = b0.l;
        V v1 = b0.c;
        int v2 = b0.J;
        int v3 = b0.K;
        String s1 = b0.b == null ? this.b : b0.b;
        if(v1.isEmpty()) {
            v1 = this.c;
        }
        if(v != 1 && v != 3) {
            s2 = this.d;
        }
        else {
            s2 = b0.d;
            if(s2 == null) {
                s2 = this.d;
            }
        }
        int v4 = this.h == -1 ? b0.h : this.h;
        int v5 = this.i == -1 ? b0.i : this.i;
        String s3 = this.k;
        if(s3 == null) {
            String s4 = x.s(b0.k, v);
            if(x.W(s4).length == 1) {
                s3 = s4;
            }
        }
        Metadata metadata1 = this.l;
        if(metadata1 != null) {
            metadata0 = metadata1.b(metadata0);
        }
        float f = this.w != -1.0f || v != 2 ? this.w : b0.w;
        int v6 = this.e | b0.e;
        int v7 = this.f | b0.f;
        DrmInitData drmInitData0 = b0.r;
        ArrayList arrayList0 = new ArrayList();
        if(drmInitData0 == null) {
            s6 = null;
        }
        else {
            String s5 = drmInitData0.c;
            SchemeData[] arr_drmInitData$SchemeData = drmInitData0.a;
            for(int v8 = 0; v8 < drmInitData0.a.length; ++v8) {
                SchemeData drmInitData$SchemeData0 = arr_drmInitData$SchemeData[v8];
                if(drmInitData$SchemeData0.e != null) {
                    arrayList0.add(drmInitData$SchemeData0);
                }
            }
            s6 = s5;
        }
        DrmInitData drmInitData1 = this.r;
        if(drmInitData1 != null) {
            if(s6 == null) {
                s6 = drmInitData1.c;
            }
            int v9 = arrayList0.size();
            SchemeData[] arr_drmInitData$SchemeData1 = drmInitData1.a;
            int v10 = 0;
            while(v10 < drmInitData1.a.length) {
                SchemeData drmInitData$SchemeData1 = arr_drmInitData$SchemeData1[v10];
                if(drmInitData$SchemeData1.e == null) {
                    v13 = v9;
                    v11 = v3;
                }
                else {
                    UUID uUID0 = drmInitData$SchemeData1.b;
                    v11 = v3;
                    int v12 = 0;
                    while(v12 < v9) {
                        v13 = v9;
                        if(((SchemeData)arrayList0.get(v12)).b.equals(uUID0)) {
                            goto label_69;
                        }
                        ++v12;
                        v9 = v13;
                    }
                    v13 = v9;
                    arrayList0.add(drmInitData$SchemeData1);
                }
            label_69:
                ++v10;
                v3 = v11;
                v9 = v13;
            }
        }
        DrmInitData drmInitData2 = arrayList0.isEmpty() ? null : new DrmInitData(s6, false, ((SchemeData[])arrayList0.toArray(new SchemeData[0])));
        n n0 = this.a();
        n0.a = s;
        n0.b = s1;
        n0.c = V.p(v1);
        n0.d = s2;
        n0.e = v6;
        n0.f = v7;
        n0.h = v4;
        n0.i = v5;
        n0.j = s3;
        n0.k = metadata0;
        n0.q = drmInitData2;
        n0.v = f;
        n0.I = v2;
        n0.J = v3;
        return new b(n0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(b.class == class0) {
                b b0 = (b)object0;
                return (this.M == 0 || (b0.M == 0 || this.M == b0.M)) && (this.e == b0.e && this.f == b0.f && this.g == b0.g && this.h == b0.h && this.i == b0.i && this.o == b0.o && this.s == b0.s && this.u == b0.u && this.v == b0.v && this.x == b0.x && this.A == b0.A && this.C == b0.C && this.D == b0.D && this.E == b0.E && this.F == b0.F && this.G == b0.G && this.H == b0.H && this.J == b0.J && this.K == b0.K && this.L == b0.L && Float.compare(this.w, b0.w) == 0 && Float.compare(this.y, b0.y) == 0 && Objects.equals(this.a, b0.a) && Objects.equals(this.b, b0.b) && this.c.equals(b0.c) && Objects.equals(this.k, b0.k) && Objects.equals(this.m, b0.m) && Objects.equals(this.n, b0.n) && Objects.equals(this.d, b0.d) && Arrays.equals(this.z, b0.z) && Objects.equals(this.l, b0.l) && Objects.equals(this.B, b0.B) && Objects.equals(this.r, b0.r) && this.b(b0));
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.M == 0) {
            int v = 0;
            int v1 = (((((((this.c.hashCode() + (((this.a == null ? 0 : this.a.hashCode()) + 0x20F) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F) * 0x1F + (this.d == null ? 0 : this.d.hashCode())) * 0x1F + this.e) * 0x1F + this.f) * 0x1F + this.g) * 0x1F + this.h) * 0x1F + this.i) * 0x1F;
            int v2 = this.k == null ? 0 : this.k.hashCode();
            int v3 = this.l == null ? 0 : this.l.hashCode();
            int v4 = this.m == null ? 0 : this.m.hashCode();
            String s = this.n;
            if(s != null) {
                v = s.hashCode();
            }
            this.M = ((((((((((Float.floatToIntBits(this.y) + ((Float.floatToIntBits(this.w) + ((((((((v1 + v2) * 0x1F + v3) * 961 + v4) * 0x1F + v) * 0x1F + this.o) * 0x1F + ((int)this.s)) * 0x1F + this.u) * 0x1F + this.v) * 0x1F) * 0x1F + this.x) * 0x1F) * 0x1F + this.A) * 0x1F + this.C) * 0x1F + this.D) * 0x1F + this.E) * 0x1F + this.F) * 0x1F + this.G) * 0x1F + this.H) * 0x1F + this.J) * 0x1F + this.K) * 0x1F + this.L;
        }
        return this.M;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Format(");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.n);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", [");
        stringBuilder0.append(this.u);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.v);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.w);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.B);
        stringBuilder0.append("], [");
        stringBuilder0.append(this.C);
        stringBuilder0.append(", ");
        return U4.x.g(this.D, "])", stringBuilder0);
    }
}

