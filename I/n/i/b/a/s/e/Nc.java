package i.n.i.b.a.s.e;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import g3.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class nc implements kd {
    public static final Pattern B;
    public static final Pattern D;
    public static final Pattern E;
    public static final Pattern G;
    public static final Pattern I;
    public static final Pattern M;
    public static final Pattern N;
    public static final Pattern S;
    public static final Pattern T;
    public static final Pattern V;
    public static final Pattern W;
    public static final Pattern X;
    public static final Pattern Y;
    public static final Pattern Z;
    public final va a;
    public final Ua b;
    public static final Pattern b0;
    public final Gd c;
    public static final Pattern c0;
    public static final Pattern d;
    public static final Pattern d0;
    public static final Pattern e;
    public static final Pattern e0;
    public static final Pattern f;
    public static final Pattern f0;
    public static final Pattern g;
    public static final Pattern g0;
    public static final Pattern h;
    public static final Pattern h0;
    public static final Pattern i;
    public static final Pattern i0;
    public static final Pattern j;
    public static final Pattern j0;
    public static final Pattern k;
    public static final Pattern k0;
    public static final Pattern l;
    public static final Pattern l0;
    public static final Pattern m;
    public static final Pattern m0;
    public static final Pattern n;
    public static final Pattern n0;
    public static final Pattern o;
    public static final Pattern o0;
    public static final Pattern p0;
    public static final Pattern q0;
    public static final Pattern r;
    public static final Pattern r0;
    public static final Pattern s0;
    public static final Pattern t0;
    public static final Pattern u0;
    public static final Pattern v0;
    public static final Pattern w;
    public static final Pattern w0;
    public static final Pattern x0;
    public static final Pattern y0;

    static {
        nc.d = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
        nc.e = Pattern.compile("VIDEO=\"(.+?)\"");
        nc.f = Pattern.compile("AUDIO=\"(.+?)\"");
        nc.g = Pattern.compile("SUBTITLES=\"(.+?)\"");
        nc.h = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
        nc.i = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
        nc.j = Pattern.compile("CHANNELS=\"(.+?)\"");
        nc.k = Pattern.compile("CODECS=\"(.+?)\"");
        nc.l = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
        nc.m = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
        nc.n = Pattern.compile("HDCP-LEVEL=\"(.+?)\"");
        nc.o = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        nc.r = Pattern.compile("DURATION=([\\d\\.]+)\\b");
        nc.w = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
        nc.B = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        nc.D = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
        nc.E = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
        nc.G = nc.g("CAN-SKIP-DATERANGES");
        nc.I = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
        nc.M = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
        nc.N = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
        nc.S = nc.g("CAN-BLOCK-RELOAD");
        nc.T = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        nc.V = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        nc.W = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
        nc.X = Pattern.compile("LAST-MSN=(\\d+)\\b");
        nc.Y = Pattern.compile("LAST-PART=(\\d+)\\b");
        nc.Z = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
        nc.b0 = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
        nc.c0 = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
        nc.d0 = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
        nc.e0 = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
        nc.f0 = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
        nc.g0 = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        nc.h0 = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
        nc.i0 = Pattern.compile("URI=\"(.+?)\"");
        nc.j0 = Pattern.compile("IV=([^,.*]+)");
        nc.k0 = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
        nc.l0 = Pattern.compile("TYPE=(PART|MAP)");
        nc.m0 = Pattern.compile("LANGUAGE=\"(.+?)\"");
        nc.n0 = Pattern.compile("NAME=\"(.+?)\"");
        nc.o0 = Pattern.compile("GROUP-ID=\"(.+?)\"");
        nc.p0 = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
        nc.q0 = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
        nc.r0 = nc.g("AUTOSELECT");
        nc.s0 = nc.g("DEFAULT");
        nc.t0 = nc.g("FORCED");
        nc.u0 = nc.g("INDEPENDENT");
        nc.v0 = nc.g("GAP");
        nc.w0 = Pattern.compile("VALUE=\"(.+?)\"");
        nc.x0 = Pattern.compile("IMPORT=\"(.+?)\"");
        nc.y0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    }

    public nc(Gd gd0) {
        this(va.m, null, gd0);
    }

    public nc(va va0, Ua ua0, Gd gd0) {
        this.a = va0;
        this.b = ua0;
        this.c = gd0;
    }

    public static long a(String s, Pattern pattern0, long v) {
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            return Long.parseLong(s1);
        }
        return v;
    }

    public static b b(String s, String s1, HashMap hashMap0) {
        String s2 = nc.f(s, nc.h0, "1", hashMap0);
        Pattern pattern0 = nc.i0;
        if("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(s1)) {
            String s3 = nc.l(s, pattern0, hashMap0);
            byte[] arr_b = Base64.decode(s3.substring(s3.indexOf(44)), 0);
            return new b(b4.d, null, "video/mp4", arr_b);
        }
        if("com.widevine".equals(s1)) {
            return new b(b4.d, null, "hls", s.getBytes(b9.c));
        }
        if("com.microsoft.playready".equals(s1) && "1".equals(s2)) {
            String s4 = nc.l(s, pattern0, hashMap0);
            byte[] arr_b1 = Base64.decode(s4.substring(s4.indexOf(44)), 0);
            byte[] arr_b2 = Ja.J(b4.e, null, arr_b1);
            return new b(b4.e, null, "video/mp4", arr_b2);
        }
        return null;
    }

    public static c3 c(String s, b[] arr_c3$b) {
        b[] arr_c3$b1 = new b[arr_c3$b.length];
        for(int v = 0; v < arr_c3$b.length; ++v) {
            b c3$b0 = arr_c3$b[v];
            arr_c3$b1[v] = new b(c3$b0.b, c3$b0.c, c3$b0.d, null);
        }
        return new c3(s, true, arr_c3$b1);
    }

    // This method was un-flattened
    public static va d(sa sa0, String s, Gd gd0) {
        ua ua5;
        ArrayList arrayList15;
        String s18;
        ua ua1;
        ArrayList arrayList14;
        Pattern pattern2;
        String s20;
        int v14;
        String s22;
        ua ua3;
        int v12;
        int v11;
        Uri uri0;
        int v7;
        int v6;
        int v5;
        ArrayList arrayList8;
        int v2;
        Pattern pattern1;
        Pattern pattern0;
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        int v = 0;
        boolean z = false;
        while(true) {
            boolean z1 = sa0.i();
            pattern0 = nc.i0;
            pattern1 = nc.n0;
            if(!z1) {
                break;
            }
            String s1 = sa0.j();
            if(s1.startsWith("#EXT")) {
                arrayList7.add(s1);
            }
            boolean z2 = s1.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            if(s1.startsWith("#EXT-X-DEFINE")) {
                hashMap1.put(nc.l(s1, pattern1, hashMap1), nc.l(s1, nc.w0, hashMap1));
            }
            else if(s1.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z = true;
            }
            else if(s1.startsWith("#EXT-X-MEDIA")) {
                arrayList5.add(s1);
            }
            else if(s1.startsWith("#EXT-X-SESSION-KEY")) {
                b c3$b0 = nc.b(s1, nc.f(s1, nc.g0, "identity", hashMap1), hashMap1);
                if(c3$b0 == null) {
                    continue;
                }
                String s2 = nc.l(s1, nc.f0, hashMap1);
                arrayList6.add(new c3(("SAMPLE-AES-CENC".equals(s2) || "SAMPLE-AES-CTR".equals(s2) ? "cenc" : "cbcs"), true, new b[]{c3$b0}));
            }
            else {
                if(!s1.startsWith("#EXT-X-STREAM-INF") && !z2) {
                    if(s1.startsWith("#EXT-X-PLAYREADYHEADER")) {
                        throw new H4("Does not support #EXT-X-PLAYREADYHEADER TAG");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    continue;
                }
                boolean z3 = s1.contains("CLOSED-CAPTIONS=NONE");
                int v1 = Integer.parseInt(nc.l(s1, nc.i, Collections.EMPTY_MAP));
                Matcher matcher0 = nc.d.matcher(s1);
                if(matcher0.find()) {
                    String s3 = matcher0.group(1);
                    s3.getClass();
                    v2 = Integer.parseInt(s3);
                }
                else {
                    v2 = -1;
                }
                String s4 = nc.f(s1, nc.k, null, hashMap1);
                String s5 = nc.f(s1, nc.l, null, hashMap1);
                if(s5 == null) {
                    arrayList8 = arrayList2;
                }
                else {
                    arrayList8 = arrayList2;
                    String[] arr_s = s5.split("x", -1);
                    int v3 = Integer.parseInt(arr_s[0]);
                    int v4 = Integer.parseInt(arr_s[1]);
                    if(v3 > 0 && v4 > 0) {
                        v5 = v3;
                        v6 = v4;
                        goto label_61;
                    }
                }
                v6 = -1;
                v5 = -1;
            label_61:
                String s6 = nc.f(s1, nc.m, null, hashMap1);
                float f = s6 == null ? -1.0f : Float.parseFloat(s6);
                String s7 = nc.f(s1, nc.n, null, hashMap1);
                if(s7 == null) {
                    v7 = -1;
                }
                else if(s7.equals("TYPE-0")) {
                    v7 = 0;
                }
                else if(s7.equals("TYPE-1")) {
                    v7 = 1;
                }
                String s8 = nc.f(s1, nc.e, null, hashMap1);
                String s9 = nc.f(s1, nc.f, null, hashMap1);
                String s10 = nc.f(s1, nc.g, null, hashMap1);
                String s11 = nc.f(s1, nc.h, null, hashMap1);
                if(z2) {
                    uri0 = Ja.T(s, nc.l(s1, pattern0, hashMap1));
                }
                else {
                    if(!sa0.i()) {
                        throw new H4("#EXT-X-STREAM-INF must be followed by another line");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    uri0 = Ja.T(s, nc.k(sa0.j(), hashMap1));
                }
                ob ob0 = new ob();
                ob0.a = Integer.toString(arrayList0.size());
                ob0.j = "application/x-mpegURL";
                ob0.h = s4;
                ob0.f = v2;
                ob0.g = v1;
                ob0.p = v5;
                ob0.q = v6;
                ob0.r = f;
                ob0.e = z2 ? 0x4000 : 0;
                ob0.G = v7;
                arrayList0.add(new ua(uri0, new u(ob0), s8, s9, s10, s11));
                ArrayList arrayList9 = (ArrayList)hashMap0.get(uri0);
                if(arrayList9 == null) {
                    arrayList9 = new ArrayList();
                    hashMap0.put(uri0, arrayList9);
                }
                arrayList9.add(new i.n.i.b.a.s.e.hf.b(v2, v1, s8, s9, s10, s11));
                v |= z3;
                arrayList2 = arrayList8;
            }
        }
        ArrayList arrayList10 = arrayList2;
        ArrayList arrayList11 = arrayList3;
        M7.t(arrayList0, new Ma(21), gd0);
        int v8 = 0;
        while(v8 < arrayList0.size() && arrayList0.size() > 1) {
            if(((ua)arrayList0.get(v8)).b.h <= 0xFA00) {
                arrayList0.remove(v8);
            }
            else {
                ++v8;
            }
        }
        ArrayList arrayList12 = new ArrayList();
        HashSet hashSet0 = new HashSet();
        for(int v9 = 0; v9 < arrayList0.size(); ++v9) {
            ua ua0 = (ua)arrayList0.get(v9);
            u u0 = ua0.b;
            if(hashSet0.add(ua0.a)) {
                M7.J(u0.j == null);
                ArrayList arrayList13 = (ArrayList)hashMap0.get(ua0.a);
                arrayList13.getClass();
                x8 x80 = new x8(new i.n.i.b.a.s.e.x8.b[]{new hf(null, null, arrayList13)});
                ob ob1 = u0.a();
                ob1.i = x80;
                u u1 = new u(ob1);
                arrayList12.add(new ua(ua0.a, u1, ua0.c, ua0.d, ua0.e, ua0.f));
            }
        }
        int v10 = 0;
        u u2 = null;
        List list0 = null;
        while(v10 < arrayList5.size()) {
            String s12 = (String)arrayList5.get(v10);
            String s13 = nc.l(s12, nc.o0, hashMap1);
            String s14 = nc.l(s12, pattern1, hashMap1);
            ob ob2 = new ob();
            ob2.a = s13 + ":" + s14;
            ob2.b = s14;
            ob2.j = "application/x-mpegURL";
            boolean z4 = nc.h(s12, nc.s0);
            if(nc.h(s12, nc.t0)) {
                z4 |= 2;
            }
            if(nc.h(s12, nc.r0)) {
                z4 |= 4;
            }
            ob2.d = z4;
            String s15 = nc.f(s12, nc.p0, null, hashMap1);
            if(TextUtils.isEmpty(s15)) {
                v11 = v10;
                v12 = 0;
            }
            else {
                v11 = v10;
                String[] arr_s1 = s15.split(",", -1);
                v12 = L7.q("public.accessibility.describes-video", arr_s1) ? 0x200 : 0;
                if(L7.q("public.accessibility.transcribes-spoken-dialog", arr_s1)) {
                    v12 |= 0x1000;
                }
                if(L7.q("public.accessibility.describes-music-and-sound", arr_s1)) {
                    v12 |= 0x400;
                }
                if(L7.q("public.easy-to-read", arr_s1)) {
                    v12 |= 0x2000;
                }
            }
            ob2.e = v12;
            ob2.c = nc.f(s12, nc.m0, null, hashMap1);
            String s16 = nc.f(s12, pattern0, null, hashMap1);
            Uri uri1 = s16 == null ? null : Ja.T(s, s16);
            x8 x81 = new x8(new i.n.i.b.a.s.e.x8.b[]{new hf(s13, s14, Collections.EMPTY_LIST)});
            switch(nc.l(s12, nc.k0, hashMap1)) {
                case "AUDIO": {
                    int v15 = 0;
                    while(true) {
                        ua3 = null;
                        if(v15 < arrayList0.size()) {
                            ua ua4 = (ua)arrayList0.get(v15);
                            if(s13.equals(ua4.d)) {
                                ua3 = ua4;
                            }
                            else {
                                ++v15;
                                continue;
                            }
                        }
                        break;
                    }
                    if(ua3 == null) {
                        s22 = null;
                    }
                    else {
                        String s21 = L7.D(1, ua3.b.i);
                        ob2.h = s21;
                        s22 = mb.b(s21);
                    }
                    pattern2 = pattern1;
                    String s23 = nc.f(s12, nc.j, null, hashMap1);
                    if(s23 != null) {
                        ob2.x = Integer.parseInt(s23.split("/", 2)[0]);
                        if("audio/eac3".equals(s22) && s23.endsWith("/JOC")) {
                            s22 = "audio/eac3-joc";
                        }
                    }
                    ob2.k = s22;
                    if(uri1 == null) {
                        arrayList14 = arrayList10;
                        if(ua3 != null) {
                            u2 = new u(ob2);
                        }
                    }
                    else {
                        ob2.i = x81;
                        arrayList14 = arrayList10;
                        arrayList14.add(new ta(uri1, new u(ob2), s13, s14));
                    }
                    arrayList15 = arrayList11;
                    break;
                }
                case "CLOSED-CAPTIONS": {
                    pattern2 = pattern1;
                    arrayList14 = arrayList10;
                    String s19 = nc.l(s12, nc.q0, hashMap1);
                    if(s19.startsWith("CC")) {
                        v14 = Integer.parseInt(s19.substring(2));
                        s20 = "application/cea-608";
                    }
                    else {
                        v14 = Integer.parseInt(s19.substring(7));
                        s20 = "application/cea-708";
                    }
                    if(list0 == null) {
                        list0 = new ArrayList();
                    }
                    ob2.k = s20;
                    ob2.C = v14;
                    list0.add(new u(ob2));
                    arrayList15 = arrayList11;
                    break;
                }
                case "SUBTITLES": {
                    pattern2 = pattern1;
                    arrayList14 = arrayList10;
                    int v13 = 0;
                    while(true) {
                        ua1 = null;
                        if(v13 < arrayList0.size()) {
                            ua ua2 = (ua)arrayList0.get(v13);
                            if(s13.equals(ua2.e)) {
                                ua1 = ua2;
                            }
                            else {
                                ++v13;
                                continue;
                            }
                        }
                        break;
                    }
                    if(ua1 == null) {
                        s18 = null;
                    }
                    else {
                        String s17 = L7.D(3, ua1.b.i);
                        ob2.h = s17;
                        s18 = mb.b(s17);
                    }
                    if(s18 == null) {
                        s18 = "text/vtt";
                    }
                    ob2.k = s18;
                    ob2.i = x81;
                    if(uri1 == null) {
                        arrayList15 = arrayList11;
                        Log.w("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                    }
                    else {
                        arrayList15 = arrayList11;
                        arrayList15.add(new ta(uri1, new u(ob2), s13, s14));
                    }
                    break;
                }
                case "VIDEO": {
                    int v16 = 0;
                    while(true) {
                        ua5 = null;
                        if(v16 < arrayList0.size()) {
                            ua ua6 = (ua)arrayList0.get(v16);
                            if(s13.equals(ua6.c)) {
                                ua5 = ua6;
                            }
                            else {
                                ++v16;
                                continue;
                            }
                        }
                        break;
                    }
                    if(ua5 != null) {
                        String s24 = L7.D(2, ua5.b.i);
                        ob2.h = s24;
                        ob2.k = mb.b(s24);
                        ob2.p = ua5.b.w;
                        ob2.q = ua5.b.B;
                        ob2.r = ua5.b.D;
                    }
                    if(uri1 != null) {
                        ob2.i = x81;
                        arrayList1.add(new ta(uri1, new u(ob2), s13, s14));
                    }
                    pattern2 = pattern1;
                    arrayList15 = arrayList11;
                    arrayList14 = arrayList10;
                    break;
                }
                default: {
                    pattern2 = pattern1;
                    arrayList15 = arrayList11;
                    arrayList14 = arrayList10;
                    break;
                }
            }
            v10 = v11 + 1;
            arrayList10 = arrayList14;
            arrayList11 = arrayList15;
            pattern1 = pattern2;
        }
        if(v) {
            list0 = Collections.EMPTY_LIST;
        }
        return new va(s, arrayList7, arrayList12, arrayList1, arrayList10, arrayList11, arrayList4, u2, list0, z, hashMap1, arrayList6);
    }

    public static Ua e(va va0, Ua ua0, sa sa0, String s) {
        c3 c311;
        c3 c310;
        Ra ra6;
        String s25;
        long v36;
        long v35;
        c3 c38;
        long v32;
        String s22;
        c3 c36;
        c3 c35;
        String s21;
        h9 h92;
        Pa pa1;
        String s9;
        boolean z5;
        long v16;
        String s8;
        String s7;
        Ra ra1;
        c3 c32;
        Ta ta1;
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Ta ta0 = new Ta(0x8000000000000001L, false, 0x8000000000000001L, 0x8000000000000001L, false);
        TreeMap treeMap0 = new TreeMap();
        boolean z = va0.c;
        String s1 = "";
        int v = 0;
        int v1 = 0;
        boolean z1 = false;
        int v2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        long v3 = 0x8000000000000001L;
        long v4 = 0x8000000000000001L;
        long v5 = 0L;
        long v6 = 0L;
        long v7 = 0L;
        long v8 = 0L;
        long v9 = 0L;
        long v10 = 0L;
        long v11 = 0L;
        long v12 = 0L;
        Pa pa0 = null;
        c3 c30 = null;
        c3 c31 = null;
        Ra ra0 = null;
        String s2 = null;
        String s3 = null;
        long v13 = -1L;
        boolean z4 = false;
        long v14 = 0x8000000000000001L;
        String s4 = null;
        int v15 = 1;
        while(sa0.i()) {
            String s5 = sa0.j();
            if(s5.startsWith("#EXT")) {
                arrayList2.add(s5);
            }
            if(s5.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String s6 = nc.l(s5, nc.D, hashMap0);
                if("VOD".equals(s6)) {
                    v = 1;
                    continue;
                }
                else if("EVENT".equals(s6)) {
                    v = 2;
                    continue;
                }
                else {
                    ta1 = ta0;
                    c32 = c30;
                    ra1 = ra0;
                    s7 = s2;
                    s8 = s3;
                    v16 = v10;
                    z5 = z3;
                    s9 = s1;
                    pa1 = pa0;
                    goto label_390;
                }
                goto label_59;
            }
            else {
            label_59:
                if(s5.equals("#EXT-X-I-FRAMES-ONLY")) {
                    z2 = true;
                    continue;
                }
                else if(s5.startsWith("#EXT-X-START")) {
                    v3 = (long)(Double.parseDouble(nc.l(s5, nc.Z, Collections.EMPTY_MAP)) * 1000000.0);
                    continue;
                }
                else if(s5.startsWith("#EXT-X-SERVER-CONTROL")) {
                    double f = nc.i(s5, nc.E);
                    boolean z6 = nc.h(s5, nc.G);
                    double f1 = nc.i(s5, nc.M);
                    double f2 = nc.i(s5, nc.N);
                    ta0 = new Ta((f == -9223372036854776000.0 ? 0x8000000000000001L : ((long)(f * 1000000.0))), z6, (f1 == -9223372036854776000.0 ? 0x8000000000000001L : ((long)(f1 * 1000000.0))), (f2 == -9223372036854776000.0 ? 0x8000000000000001L : ((long)(f2 * 1000000.0))), nc.h(s5, nc.S));
                    continue;
                }
                else if(s5.startsWith("#EXT-X-PART-INF")) {
                    v4 = (long)(Double.parseDouble(nc.l(s5, nc.w, Collections.EMPTY_MAP)) * 1000000.0);
                    continue;
                }
                else {
                    Pattern pattern0 = nc.c0;
                    ta1 = ta0;
                    Pattern pattern1 = nc.i0;
                    if(s5.startsWith("#EXT-X-MAP")) {
                        String s10 = nc.l(s5, pattern1, hashMap0);
                        String s11 = nc.f(s5, pattern0, null, hashMap0);
                        if(s11 != null) {
                            String[] arr_s = s11.split("@", -1);
                            v13 = Long.parseLong(arr_s[0]);
                            if(arr_s.length > 1) {
                                v9 = Long.parseLong(arr_s[1]);
                            }
                        }
                        int v17 = Long.compare(v13, -1L);
                        if(v17 == 0) {
                            v9 = 0L;
                        }
                        if(s2 != null && s3 == null) {
                            throw new H4("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        Ra ra2 = new Ra(s10, v9, v13, s2, s3);
                        if(v17 != 0) {
                            v9 += v13;
                        }
                        ra0 = ra2;
                        v13 = -1L;
                        ta0 = ta1;
                        continue;
                    }
                    else {
                        s8 = s3;
                        if(s5.startsWith("#EXT-X-TARGETDURATION")) {
                            v14 = ((long)Integer.parseInt(nc.l(s5, nc.o, Collections.EMPTY_MAP))) * 1000000L;
                            ta0 = ta1;
                            s3 = s8;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                            v8 = Long.parseLong(nc.l(s5, nc.T, Collections.EMPTY_MAP));
                            v7 = v8;
                            ta0 = ta1;
                            s3 = s8;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-VERSION")) {
                            v15 = Integer.parseInt(nc.l(s5, nc.B, Collections.EMPTY_MAP));
                            ta0 = ta1;
                            s3 = s8;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-DEFINE")) {
                            String s12 = nc.f(s5, nc.x0, null, hashMap0);
                            if(s12 == null) {
                                hashMap0.put(nc.l(s5, nc.n0, hashMap0), nc.l(s5, nc.w0, hashMap0));
                            }
                            else {
                                String s13 = (String)va0.k.get(s12);
                                if(s13 != null) {
                                    hashMap0.put(s12, s13);
                                }
                            }
                            pa1 = pa0;
                            goto label_282;
                        }
                        else if(s5.startsWith("#EXTINF")) {
                            double f3 = Double.parseDouble(nc.l(s5, nc.V, Collections.EMPTY_MAP));
                            s1 = nc.f(s5, nc.W, "", hashMap0);
                            v11 = (long)(f3 * 1000000.0);
                            ta0 = ta1;
                            s3 = s8;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-SKIP")) {
                            int v18 = Integer.parseInt(nc.l(s5, nc.I, Collections.EMPTY_MAP));
                            M7.J(((boolean)(ua0 == null || !arrayList0.isEmpty() ? 0 : 1)));
                            h9 h90 = ua0.p;
                            int v19 = (int)(v7 - ua0.i);
                            int v20 = v18 + v19;
                            if(v19 < 0 || v20 > h90.size()) {
                                throw new lc();  // 初始化器: Ljava/io/IOException;-><init>()V
                            }
                            long v21 = v10;
                            s3 = s8;
                            while(v19 < v20) {
                                Ra ra3 = (Ra)h90.get(v19);
                                if(v7 == ua0.i) {
                                    h92 = h90;
                                }
                                else {
                                    int v22 = ua0.h - v2 + ra3.d;
                                    h9 h91 = ra3.m;
                                    ArrayList arrayList3 = new ArrayList();
                                    long v24 = v21;
                                    for(int v23 = 0; v23 < h91.size(); ++v23) {
                                        Pa pa2 = (Pa)h91.get(v23);
                                        arrayList3.add(new Pa(pa2.a, pa2.b, pa2.c, v22, v24, pa2.f, pa2.g, pa2.h, pa2.i, pa2.j, pa2.k, pa2.l, pa2.m));
                                        v24 += pa2.c;
                                    }
                                    h92 = h90;
                                    ra3 = new Ra(ra3.a, ra3.b, ra3.l, ra3.c, v22, v21, ra3.f, ra3.g, ra3.h, ra3.i, ra3.j, ra3.k, arrayList3);
                                }
                                arrayList0.add(ra3);
                                String s14 = ra3.h;
                                v21 += ra3.c;
                                long v25 = ra3.j;
                                if(v25 != -1L) {
                                    v9 = ra3.i + v25;
                                }
                                int v26 = ra3.d;
                                Ra ra4 = ra3.b;
                                c3 c33 = ra3.f;
                                String s15 = ra3.g;
                                if(s14 == null || !s14.equals(Long.toHexString(v8))) {
                                    s3 = s14;
                                }
                                ++v8;
                                ++v19;
                                v1 = v26;
                                ra0 = ra4;
                                c30 = c33;
                                s2 = s15;
                                h90 = h92;
                                v5 = v21;
                            }
                            ta0 = ta1;
                            v10 = v21;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-KEY")) {
                            String s16 = nc.l(s5, nc.f0, hashMap0);
                            String s17 = nc.f(s5, nc.g0, "identity", hashMap0);
                            if("NONE".equals(s16)) {
                                treeMap0.clear();
                                c30 = null;
                                s2 = null;
                                s3 = null;
                            }
                            else {
                                String s18 = nc.f(s5, nc.j0, null, hashMap0);
                                if(!"identity".equals(s17)) {
                                    if(s4 == null) {
                                        s4 = "SAMPLE-AES-CENC".equals(s16) || "SAMPLE-AES-CTR".equals(s16) ? "cenc" : "cbcs";
                                    }
                                    b c3$b0 = nc.b(s5, s17, hashMap0);
                                    if(c3$b0 != null) {
                                        treeMap0.put(s17, c3$b0);
                                        s3 = s18;
                                        c30 = null;
                                    }
                                }
                                else if("AES-128".equals(s16)) {
                                    s2 = nc.l(s5, pattern1, hashMap0);
                                    s3 = s18;
                                    goto label_201;
                                }
                                else {
                                    s3 = s18;
                                }
                                s2 = null;
                            }
                        label_201:
                            ta0 = ta1;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-BYTERANGE")) {
                            String[] arr_s1 = nc.l(s5, nc.b0, hashMap0).split("@", -1);
                            v13 = Long.parseLong(arr_s1[0]);
                            if(arr_s1.length > 1) {
                                v9 = Long.parseLong(arr_s1[1]);
                            }
                            ta0 = ta1;
                            s3 = s8;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                            v2 = Integer.parseInt(s5.substring(s5.indexOf(58) + 1));
                            ta0 = ta1;
                            s3 = s8;
                            z1 = true;
                            continue;
                        }
                        else if(s5.equals("#EXT-X-DISCONTINUITY")) {
                            ++v1;
                            ta0 = ta1;
                            s3 = s8;
                            continue;
                        }
                        else if(s5.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                            if(v6 == 0L) {
                                v6 = b4.a(L7.I(s5.substring(s5.indexOf(58) + 1))) - v10;
                                ta0 = ta1;
                                s3 = s8;
                                continue;
                            }
                            else {
                                pa1 = pa0;
                                goto label_282;
                            }
                            goto label_226;
                        }
                        else {
                        label_226:
                            if(s5.equals("#EXT-X-GAP")) {
                                ta0 = ta1;
                                s3 = s8;
                                z3 = true;
                                continue;
                            }
                            else if(s5.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                ta0 = ta1;
                                s3 = s8;
                                z = true;
                                continue;
                            }
                            else if(s5.equals("#EXT-X-ENDLIST")) {
                                ta0 = ta1;
                                s3 = s8;
                                z4 = true;
                                continue;
                            }
                            else if(s5.startsWith("#EXT-X-RENDITION-REPORT")) {
                                long v27 = nc.a(s5, nc.X, v7 + ((long)arrayList0.size()) - ((long)arrayList1.isEmpty()));
                                h9 h93 = arrayList1.isEmpty() ? ((Ra)M7.A(arrayList0)).m : arrayList1;
                                int v28 = v4 == 0x8000000000000001L ? -1 : h93.size() - 1;
                                Matcher matcher0 = nc.Y.matcher(s5);
                                if(matcher0.find()) {
                                    String s19 = matcher0.group(1);
                                    s19.getClass();
                                    v28 = Integer.parseInt(s19);
                                }
                                hashMap2.put(Uri.parse(Ja.r(s, nc.l(s5, pattern1, hashMap0))), new Qa(v27, v28));
                                pa1 = pa0;
                                goto label_282;
                            }
                            else if(s5.startsWith("#EXT-X-PRELOAD-HINT")) {
                                if(pa0 != null || !"PART".equals(nc.l(s5, nc.l0, hashMap0))) {
                                    pa1 = pa0;
                                }
                                else {
                                    String s20 = nc.l(s5, pattern1, hashMap0);
                                    long v29 = nc.a(s5, nc.d0, -1L);
                                    long v30 = nc.a(s5, nc.e0, -1L);
                                    if(s2 == null) {
                                        s21 = null;
                                    }
                                    else {
                                        s21 = s8 == null ? Long.toHexString(v8) : s8;
                                    }
                                    if(c30 != null || treeMap0.isEmpty()) {
                                    label_274:
                                        c36 = c30;
                                    }
                                    else {
                                        b[] arr_c3$b = (b[])treeMap0.values().toArray(new b[0]);
                                        c3 c34 = new c3(s4, true, arr_c3$b);
                                        if(c31 == null) {
                                            c35 = nc.c(s4, arr_c3$b);
                                            c36 = c34;
                                            goto label_276;
                                        }
                                        else {
                                            c36 = c34;
                                            goto label_275;
                                        }
                                        goto label_274;
                                    }
                                label_275:
                                    c35 = c31;
                                label_276:
                                    int v31 = Long.compare(v29, -1L);
                                    if(v31 == 0 || v30 != -1L) {
                                        pa0 = new Pa(s20, ra0, 0L, v1, v5, c36, s2, s21, (v31 == 0 ? 0L : v29), v30, false, false, true);
                                    }
                                    c31 = c35;
                                    c30 = c36;
                                    ta0 = ta1;
                                    s3 = s8;
                                    continue;
                                }
                            label_282:
                                c32 = c30;
                                ra1 = ra0;
                                s7 = s2;
                                v16 = v10;
                                z5 = z3;
                                s9 = s1;
                            }
                            else if(s5.startsWith("#EXT-X-PART")) {
                                if(s2 == null) {
                                    s22 = null;
                                }
                                else {
                                    s22 = s8 == null ? Long.toHexString(v8) : s8;
                                }
                                String s23 = nc.l(s5, pattern1, hashMap0);
                                double f4 = Double.parseDouble(nc.l(s5, nc.r, Collections.EMPTY_MAP));
                                boolean z7 = nc.h(s5, nc.u0);
                                boolean z8 = z && arrayList1.isEmpty();
                                boolean z9 = nc.h(s5, nc.v0);
                                String s24 = nc.f(s5, pattern0, null, hashMap0);
                                if(s24 == null) {
                                    v32 = -1L;
                                }
                                else {
                                    String[] arr_s2 = s24.split("@", -1);
                                    v32 = Long.parseLong(arr_s2[0]);
                                    if(arr_s2.length > 1) {
                                        v12 = Long.parseLong(arr_s2[1]);
                                    }
                                }
                                int v33 = Long.compare(v32, -1L);
                                long v34 = v33 == 0 ? 0L : v12;
                                if(c30 != null || treeMap0.isEmpty()) {
                                label_322:
                                    c36 = c30;
                                    v36 = v5;
                                    v35 = v32;
                                }
                                else {
                                    b[] arr_c3$b1 = (b[])treeMap0.values().toArray(new b[0]);
                                    c3 c37 = new c3(s4, true, arr_c3$b1);
                                    if(c31 == null) {
                                        c38 = nc.c(s4, arr_c3$b1);
                                        v35 = v32;
                                        v36 = v5;
                                        c36 = c37;
                                        goto label_326;
                                    }
                                    else {
                                        v35 = v32;
                                        v36 = v5;
                                        c36 = c37;
                                        goto label_325;
                                    }
                                    goto label_322;
                                }
                            label_325:
                                c38 = c31;
                            label_326:
                                arrayList1.add(new Pa(s23, ra0, ((long)(f4 * 1000000.0)), v1, v36, c36, s2, s22, v34, v35, z9, ((boolean)(z7 | z8)), false));
                                v5 = v36 + ((long)(f4 * 1000000.0));
                                if(v33 != 0) {
                                    v34 += v35;
                                }
                                v12 = v34;
                                c31 = c38;
                                c30 = c36;
                                ta0 = ta1;
                                s3 = s8;
                                continue;
                            }
                            else {
                                c32 = c30;
                                pa1 = pa0;
                                ra1 = ra0;
                                if(s5.startsWith("#")) {
                                    s7 = s2;
                                    v16 = v10;
                                    z5 = z3;
                                    s9 = s1;
                                }
                                else {
                                    if(s2 == null) {
                                        s25 = null;
                                    }
                                    else {
                                        s25 = s8 == null ? Long.toHexString(v8) : s8;
                                    }
                                    String s26 = nc.k(s5, hashMap0);
                                    Ra ra5 = (Ra)hashMap1.get(s26);
                                    int v37 = Long.compare(v13, -1L);
                                    if(v37 == 0) {
                                        ra6 = ra5;
                                        v9 = 0L;
                                    }
                                    else {
                                        if(z2 && ra1 == null && ra5 == null) {
                                            ra5 = new Ra(s26, 0L, v9, null, null);
                                            hashMap1.put(s26, ra5);
                                        }
                                        ra6 = ra5;
                                    }
                                    if(c32 != null || treeMap0.isEmpty()) {
                                        ++v8;
                                        c310 = c31;
                                        c311 = c32;
                                    }
                                    else {
                                        ++v8;
                                        b[] arr_c3$b2 = (b[])treeMap0.values().toArray(new b[0]);
                                        c3 c39 = new c3(s4, true, arr_c3$b2);
                                        if(c31 == null) {
                                            c310 = nc.c(s4, arr_c3$b2);
                                            c311 = c39;
                                        }
                                        else {
                                            c311 = c39;
                                            c310 = c31;
                                        }
                                    }
                                    arrayList0.add(new Ra(s26, (ra1 == null ? ra6 : ra1), s1, v11, v1, v10, c311, s2, s25, v9, v13, z3, arrayList1));
                                    v5 = v10 + v11;
                                    arrayList1 = new ArrayList();
                                    if(v37 != 0) {
                                        v9 += v13;
                                    }
                                    c31 = c310;
                                    pa0 = pa1;
                                    ra0 = ra1;
                                    z3 = false;
                                    c30 = c311;
                                    v10 = v5;
                                    v11 = 0L;
                                    v13 = -1L;
                                    ta0 = ta1;
                                    s3 = s8;
                                    s1 = "";
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        label_390:
            pa0 = pa1;
            s1 = s9;
            c30 = c32;
            v10 = v16;
            s2 = s7;
            z3 = z5;
            ta0 = ta1;
            s3 = s8;
            ra0 = ra1;
        }
        if(pa0 != null) {
            arrayList1.add(pa0);
        }
        return v6 == 0L ? new Ua(v, s, arrayList2, v3, 0L, z1, v2, v7, v15, v14, v4, z, z4, false, c31, arrayList0, arrayList1, ta0, hashMap2) : new Ua(v, s, arrayList2, v3, v6, z1, v2, v7, v15, v14, v4, z, z4, true, c31, arrayList0, arrayList1, ta0, hashMap2);
    }

    public static String f(String s, Pattern pattern0, String s1, Map map0) {
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            s1 = matcher0.group(1);
            s1.getClass();
        }
        return map0.isEmpty() || s1 == null ? s1 : nc.k(s1, map0);
    }

    public static Pattern g(String s) {
        return Pattern.compile((s + "=(NO|YES)"));
    }

    public static boolean h(String s, Pattern pattern0) {
        Matcher matcher0 = pattern0.matcher(s);
        return matcher0.find() ? "YES".equals(matcher0.group(1)) : false;
    }

    public static double i(String s, Pattern pattern0) {
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            return Double.parseDouble(s1);
        }
        return -9223372036854776000.0;
    }

    @Override  // i.n.i.b.a.s.e.kd
    public final Object j(Uri uri0, h h0) {
        va va0;
        Ua ua0;
        String s1;
        Gd gd0 = this.c;
        long v = SystemClock.elapsedRealtime();
        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(h0));
        ArrayDeque arrayDeque0 = new ArrayDeque();
        try {
            int v1 = bufferedReader0.read();
            if(v1 == 0xEF) {
                if(bufferedReader0.read() != 0xBB || bufferedReader0.read() != 0xBF) {
                    throw new xd("Input does not start with the #EXTM3U header.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                }
                v1 = bufferedReader0.read();
            }
            while(v1 != -1 && Character.isWhitespace(v1)) {
                v1 = bufferedReader0.read();
            }
            for(int v2 = 0; v2 < 7; ++v2) {
                if(v1 != "#EXTM3U".charAt(v2)) {
                    throw new xd("Input does not start with the #EXTM3U header.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                }
                v1 = bufferedReader0.read();
            }
            while(v1 != -1 && Character.isWhitespace(v1) && (v1 != 10 && v1 != 13)) {
                v1 = bufferedReader0.read();
            }
            if(v1 != 10 && v1 != 13) {
                throw new xd("Input does not start with the #EXTM3U header.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            while(true) {
            label_22:
                String s = bufferedReader0.readLine();
                if(s == null) {
                    goto label_46;
                }
                s1 = s.trim();
                if(!s1.isEmpty()) {
                    if(!s1.startsWith("#EXT-X-STREAM-INF")) {
                        if(!s1.startsWith("#EXT-X-TARGETDURATION") && !s1.startsWith("#EXT-X-MEDIA-SEQUENCE") && !s1.startsWith("#EXTINF") && !s1.startsWith("#EXT-X-KEY") && !s1.startsWith("#EXT-X-BYTERANGE") && !s1.equals("#EXT-X-DISCONTINUITY") && !s1.equals("#EXT-X-DISCONTINUITY-SEQUENCE") && !s1.equals("#EXT-X-ENDLIST")) {
                            arrayDeque0.add(s1);
                            goto label_39;
                        }
                        arrayDeque0.add(s1);
                        sa sa0 = new sa(arrayDeque0, bufferedReader0);
                        ua0 = nc.e(this.a, this.b, sa0, uri0.toString());
                        break;
                    }
                    goto label_35;
                }
                goto label_39;
            }
        }
        catch(Throwable throwable0) {
            goto label_43;
        }
        try {
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        return ua0;
        try {
        label_35:
            arrayDeque0.add(s1);
            va0 = nc.d(new sa(arrayDeque0, bufferedReader0), uri0.toString(), gd0);
        }
        catch(Throwable throwable0) {
            goto label_43;
        }
        try {
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        return va0;
        try {
        label_39:
            long v3 = SystemClock.elapsedRealtime() - v;
            if(v3 >= 0x7FFFFFFFFFFFFFFFL) {
                throw new mc("Download time exceeds. Maximum timeout duration is " + 0x7FFFFFFFFFFFFFFFL + ", but actually we have spent " + v3 + " milliseconds.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            goto label_22;
        }
        catch(Throwable throwable0) {
        }
        try {
        label_43:
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        throw throwable0;
        try {
        label_46:
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        throw new H4("Failed to parse the playlist, could not identify any tags.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    }

    public static String k(String s, Map map0) {
        Matcher matcher0 = nc.y0.matcher(s);
        StringBuffer stringBuffer0 = new StringBuffer();
        while(matcher0.find()) {
            String s1 = matcher0.group(1);
            if(map0.containsKey(s1)) {
                matcher0.appendReplacement(stringBuffer0, Matcher.quoteReplacement(((String)map0.get(s1))));
            }
        }
        matcher0.appendTail(stringBuffer0);
        return stringBuffer0.toString();
    }

    public static String l(String s, Pattern pattern0, Map map0) {
        String s1 = nc.f(s, pattern0, null, map0);
        if(s1 == null) {
            throw new H4("Couldn\'t match " + pattern0.pattern() + " in " + s);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        return s1;
    }
}

