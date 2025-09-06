package m3;

import I6.V;
import I6.w;
import V3.r;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.media3.common.DrmInitData.SchemeData;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.Metadata;
import androidx.media3.exoplayer.hls.HlsTrackMetadataEntry.VariantInfo;
import androidx.media3.exoplayer.hls.HlsTrackMetadataEntry;
import b3.H;
import b3.I;
import e3.b;
import e3.x;
import i.n.i.b.a.s.e.Ta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w3.l;
import y8.s;

public final class n implements l {
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
    public final k a;
    public final h b;
    public static final Pattern b0;
    public static final Pattern c;
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

    static {
        n.c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
        n.d = Pattern.compile("VIDEO=\"(.+?)\"");
        n.e = Pattern.compile("AUDIO=\"(.+?)\"");
        n.f = Pattern.compile("SUBTITLES=\"(.+?)\"");
        n.g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
        n.h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
        n.i = Pattern.compile("CHANNELS=\"(.+?)\"");
        n.j = Pattern.compile("CODECS=\"(.+?)\"");
        n.k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
        n.l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
        n.m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        n.n = Pattern.compile("DURATION=([\\d\\.]+)\\b");
        n.o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
        n.r = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        n.w = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
        n.B = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
        n.D = n.a("CAN-SKIP-DATERANGES");
        n.E = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
        n.G = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
        n.I = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
        n.M = n.a("CAN-BLOCK-RELOAD");
        n.N = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        n.S = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        n.T = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
        n.V = Pattern.compile("LAST-MSN=(\\d+)\\b");
        n.W = Pattern.compile("LAST-PART=(\\d+)\\b");
        n.X = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
        n.Y = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
        n.Z = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
        n.b0 = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
        n.c0 = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
        n.d0 = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
        n.e0 = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        n.f0 = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
        n.g0 = Pattern.compile("URI=\"(.+?)\"");
        n.h0 = Pattern.compile("IV=([^,.*]+)");
        n.i0 = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
        n.j0 = Pattern.compile("TYPE=(PART|MAP)");
        n.k0 = Pattern.compile("LANGUAGE=\"(.+?)\"");
        n.l0 = Pattern.compile("NAME=\"(.+?)\"");
        n.m0 = Pattern.compile("GROUP-ID=\"(.+?)\"");
        n.n0 = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
        n.o0 = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
        n.p0 = n.a("AUTOSELECT");
        n.q0 = n.a("DEFAULT");
        n.r0 = n.a("FORCED");
        n.s0 = n.a("INDEPENDENT");
        n.t0 = n.a("GAP");
        n.u0 = n.a("PRECISE");
        n.v0 = Pattern.compile("VALUE=\"(.+?)\"");
        n.w0 = Pattern.compile("IMPORT=\"(.+?)\"");
        n.x0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    }

    public n(k k0, h h0) {
        this.a = k0;
        this.b = h0;
    }

    public static Pattern a(String s) {
        return Pattern.compile((s + "=(NO|YES)"));
    }

    public static DrmInitData b(String s, SchemeData[] arr_drmInitData$SchemeData) {
        SchemeData[] arr_drmInitData$SchemeData1 = new SchemeData[arr_drmInitData$SchemeData.length];
        for(int v = 0; v < arr_drmInitData$SchemeData.length; ++v) {
            SchemeData drmInitData$SchemeData0 = arr_drmInitData$SchemeData[v];
            arr_drmInitData$SchemeData1[v] = new SchemeData(drmInitData$SchemeData0.b, drmInitData$SchemeData0.c, drmInitData$SchemeData0.d, null);
        }
        return new DrmInitData(s, true, arr_drmInitData$SchemeData1);
    }

    public static SchemeData c(String s, String s1, HashMap hashMap0) {
        String s2 = n.j(s, n.f0, "1", hashMap0);
        Pattern pattern0 = n.g0;
        if("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(s1)) {
            String s3 = n.k(s, pattern0, hashMap0);
            byte[] arr_b = Base64.decode(s3.substring(s3.indexOf(44)), 0);
            return new SchemeData(b3.h.d, null, "video/mp4", arr_b);
        }
        if("com.widevine".equals(s1)) {
            return new SchemeData(b3.h.d, null, "hls", s.getBytes(StandardCharsets.UTF_8));
        }
        if("com.microsoft.playready".equals(s1) && "1".equals(s2)) {
            String s4 = n.k(s, pattern0, hashMap0);
            byte[] arr_b1 = Base64.decode(s4.substring(s4.indexOf(44)), 0);
            byte[] arr_b2 = r.a(b3.h.e, arr_b1);
            return new SchemeData(b3.h.e, null, "video/mp4", arr_b2);
        }
        return null;
    }

    public static h d(k k0, h h0, s s0, String s1) {
        DrmInitData drmInitData11;
        String s29;
        DrmInitData drmInitData9;
        f f11;
        String s27;
        DrmInitData drmInitData8;
        long v39;
        String s24;
        DrmInitData drmInitData5;
        String s23;
        int v34;
        ArrayList arrayList5;
        String s20;
        boolean z7;
        int v31;
        int v28;
        String s13;
        long v18;
        String s12;
        long v17;
        f f6;
        Ta ta1;
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Ta ta0 = new Ta(0x8000000000000001L, false, 0x8000000000000001L, 0x8000000000000001L, false);
        TreeMap treeMap0 = new TreeMap();
        boolean z = k0.c;
        String s2 = "";
        long v = 0x8000000000000001L;
        long v1 = 0L;
        long v2 = 0L;
        long v3 = 0L;
        long v4 = 0L;
        long v5 = 0L;
        long v6 = 0L;
        long v7 = 0L;
        long v8 = -1L;
        boolean z1 = false;
        d d0 = null;
        int v9 = 0;
        DrmInitData drmInitData0 = null;
        f f0 = null;
        DrmInitData drmInitData1 = null;
        int v10 = 0;
        String s3 = null;
        String s4 = null;
        boolean z2 = false;
        boolean z3 = false;
        int v11 = 0;
        String s5 = null;
        boolean z4 = false;
        boolean z5 = false;
        long v12 = 0x8000000000000001L;
        long v13 = 0x8000000000000001L;
        long v14 = 0L;
        int v15 = 1;
        while(s0.j()) {
            String s6 = s0.q();
            if(s6.startsWith("#EXT")) {
                arrayList3.add(s6);
            }
            if(s6.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String s7 = n.k(s6, n.w, hashMap0);
                if("VOD".equals(s7)) {
                    v9 = 1;
                }
                else {
                    if(!"EVENT".equals(s7)) {
                        continue;
                    }
                    v9 = 2;
                }
            }
            else if(s6.equals("#EXT-X-I-FRAMES-ONLY")) {
                z4 = true;
            }
            else {
                if(s6.startsWith("#EXT-X-START")) {
                    double f1 = Double.parseDouble(n.k(s6, n.X, Collections.EMPTY_MAP));
                    ta1 = ta0;
                    z1 = n.g(s6, n.u0);
                    v = (long)(f1 * 1000000.0);
                    goto label_237;
                }
                ta1 = ta0;
                if(s6.startsWith("#EXT-X-SERVER-CONTROL")) {
                    double f2 = n.h(s6, n.B);
                    boolean z6 = n.g(s6, n.D);
                    double f3 = n.h(s6, n.G);
                    double f4 = n.h(s6, n.I);
                    ta1 = new Ta((f2 == -9223372036854776000.0 ? 0x8000000000000001L : ((long)(f2 * 1000000.0))), z6, (f3 == -9223372036854776000.0 ? 0x8000000000000001L : ((long)(f3 * 1000000.0))), (f4 == -9223372036854776000.0 ? 0x8000000000000001L : ((long)(f4 * 1000000.0))), n.g(s6, n.M));
                    goto label_237;
                }
                if(s6.startsWith("#EXT-X-PART-INF")) {
                    v13 = (long)(Double.parseDouble(n.k(s6, n.o, Collections.EMPTY_MAP)) * 1000000.0);
                    goto label_237;
                }
                Pattern pattern0 = n.Z;
                Pattern pattern1 = n.g0;
                if(s6.startsWith("#EXT-X-MAP")) {
                    String s8 = n.k(s6, pattern1, hashMap0);
                    String s9 = n.j(s6, pattern0, null, hashMap0);
                    if(s9 != null) {
                        String[] arr_s = s9.split("@", -1);
                        v8 = Long.parseLong(arr_s[0]);
                        if(arr_s.length > 1) {
                            v4 = Long.parseLong(arr_s[1]);
                        }
                    }
                    int v16 = Long.compare(v8, -1L);
                    if(v16 == 0) {
                        v4 = 0L;
                    }
                    if(s3 != null && s4 == null) {
                        throw I.b("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                    }
                    f f5 = new f(s8, v4, v8, s3, s4);
                    if(v16 != 0) {
                        v4 += v8;
                    }
                    f0 = f5;
                    v8 = -1L;
                }
                else {
                    if(s6.startsWith("#EXT-X-TARGETDURATION")) {
                        v12 = ((long)Integer.parseInt(n.k(s6, n.m, Collections.EMPTY_MAP))) * 1000000L;
                        goto label_237;
                    }
                    if(s6.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        v3 = Long.parseLong(n.k(s6, n.N, Collections.EMPTY_MAP));
                        v14 = v3;
                        goto label_237;
                    }
                    if(s6.startsWith("#EXT-X-VERSION")) {
                        v15 = Integer.parseInt(n.k(s6, n.r, Collections.EMPTY_MAP));
                        goto label_237;
                    }
                    if(s6.startsWith("#EXT-X-DEFINE")) {
                        String s10 = n.j(s6, n.w0, null, hashMap0);
                        if(s10 == null) {
                            hashMap0.put(n.k(s6, n.l0, hashMap0), n.k(s6, n.v0, hashMap0));
                        }
                        else {
                            String s11 = (String)k0.l.get(s10);
                            if(s11 != null) {
                                hashMap0.put(s10, s11);
                            }
                        }
                        f6 = f0;
                        v17 = v1;
                        s12 = s3;
                        v18 = v8;
                        s13 = s5;
                        goto label_244;
                    }
                    else if(s6.startsWith("#EXTINF")) {
                        v6 = new BigDecimal(n.k(s6, n.S, Collections.EMPTY_MAP)).multiply(new BigDecimal(1000000L)).longValue();
                        s2 = n.j(s6, n.T, "", hashMap0);
                        goto label_237;
                    }
                    else if(s6.startsWith("#EXT-X-SKIP")) {
                        int v19 = Integer.parseInt(n.k(s6, n.E, Collections.EMPTY_MAP));
                        b.j(h0 != null && arrayList0.isEmpty());
                        V v20 = h0.r;
                        int v21 = (int)(v14 - h0.k);
                        int v22 = v19 + v21;
                        if(v21 < 0 || v22 > v20.size()) {
                            throw new m();  // 初始化器: Ljava/io/IOException;-><init>()V
                        }
                        long v23 = v5;
                        while(v21 < v22) {
                            f f7 = (f)v20.get(v21);
                            if(v14 == h0.k) {
                                v28 = v22;
                            }
                            else {
                                int v24 = h0.j - v11 + f7.d;
                                V v25 = f7.m;
                                ArrayList arrayList4 = new ArrayList();
                                long v27 = v23;
                                for(int v26 = 0; v26 < v25.size(); ++v26) {
                                    d d1 = (d)v25.get(v26);
                                    arrayList4.add(new d(d1.a, d1.b, d1.c, v24, v27, d1.f, d1.g, d1.h, d1.i, d1.j, d1.k, d1.l, d1.m));
                                    v27 += d1.c;
                                }
                                v28 = v22;
                                f7 = new f(f7.a, f7.b, f7.l, f7.c, v24, v23, f7.f, f7.g, f7.h, f7.i, f7.j, f7.k, arrayList4);
                            }
                            arrayList0.add(f7);
                            String s14 = f7.h;
                            v23 += f7.c;
                            long v29 = f7.j;
                            if(v29 != -1L) {
                                v4 = f7.i + v29;
                            }
                            int v30 = f7.d;
                            f f8 = f7.b;
                            DrmInitData drmInitData2 = f7.f;
                            String s15 = f7.g;
                            if(s14 == null || !s14.equals(Long.toHexString(v3))) {
                                s4 = s14;
                            }
                            ++v3;
                            ++v21;
                            v10 = v30;
                            f0 = f8;
                            s3 = s15;
                            drmInitData0 = drmInitData2;
                            v22 = v28;
                            v1 = v23;
                        }
                        ta0 = ta1;
                        v5 = v23;
                        continue;
                    }
                    else if(s6.startsWith("#EXT-X-KEY")) {
                        String s16 = n.k(s6, n.d0, hashMap0);
                        String s17 = n.j(s6, n.e0, "identity", hashMap0);
                        if("NONE".equals(s16)) {
                            treeMap0.clear();
                            drmInitData0 = null;
                            s3 = null;
                            s4 = null;
                        }
                        else {
                            String s18 = n.j(s6, n.h0, null, hashMap0);
                            if(!"identity".equals(s17)) {
                                if(s5 == null) {
                                    s5 = "SAMPLE-AES-CENC".equals(s16) || "SAMPLE-AES-CTR".equals(s16) ? "cenc" : "cbcs";
                                }
                                SchemeData drmInitData$SchemeData0 = n.c(s6, s17, hashMap0);
                                if(drmInitData$SchemeData0 != null) {
                                    treeMap0.put(s17, drmInitData$SchemeData0);
                                    s4 = s18;
                                    drmInitData0 = null;
                                }
                            }
                            else if("AES-128".equals(s16)) {
                                s3 = n.k(s6, pattern1, hashMap0);
                                s4 = s18;
                                goto label_237;
                            }
                            else {
                                s4 = s18;
                            }
                            s3 = null;
                        }
                        goto label_237;
                    }
                    else {
                        s13 = s5;
                        if(s6.startsWith("#EXT-X-BYTERANGE")) {
                            String[] arr_s1 = n.k(s6, n.Y, hashMap0).split("@", -1);
                            v8 = Long.parseLong(arr_s1[0]);
                            if(arr_s1.length > 1) {
                                v4 = Long.parseLong(arr_s1[1]);
                            }
                            s5 = s13;
                            ta0 = ta1;
                            continue;
                        }
                        else if(s6.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                            v11 = Integer.parseInt(s6.substring(s6.indexOf(58) + 1));
                            s5 = s13;
                            ta0 = ta1;
                            z3 = true;
                            continue;
                        }
                        else if(s6.equals("#EXT-X-DISCONTINUITY")) {
                            ++v10;
                            s5 = s13;
                            ta0 = ta1;
                            continue;
                        }
                        else if(s6.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                            if(v2 == 0L) {
                                String s19 = s6.substring(s6.indexOf(58) + 1);
                                Matcher matcher0 = x.h.matcher(s19);
                                if(!matcher0.matches()) {
                                    throw I.a(null, "Invalid date/time format: " + s19);
                                }
                                if(matcher0.group(9) == null) {
                                    v31 = 0;
                                }
                                else if(!matcher0.group(9).equalsIgnoreCase("Z")) {
                                    v31 = Integer.parseInt(matcher0.group(12)) * 60 + Integer.parseInt(matcher0.group(13));
                                    if("-".equals(matcher0.group(11))) {
                                        v31 = -v31;
                                    }
                                }
                                else {
                                    v31 = 0;
                                }
                                GregorianCalendar gregorianCalendar0 = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                                gregorianCalendar0.clear();
                                gregorianCalendar0.set(Integer.parseInt(matcher0.group(1)), Integer.parseInt(matcher0.group(2)) - 1, Integer.parseInt(matcher0.group(3)), Integer.parseInt(matcher0.group(4)), Integer.parseInt(matcher0.group(5)), Integer.parseInt(matcher0.group(6)));
                                if(!TextUtils.isEmpty(matcher0.group(8))) {
                                    gregorianCalendar0.set(14, new BigDecimal("0." + matcher0.group(8)).movePointRight(3).intValue());
                                }
                                long v32 = gregorianCalendar0.getTimeInMillis();
                                if(v31 != 0) {
                                    v32 -= ((long)v31) * 60000L;
                                }
                                v2 = x.M(v32) - v5;
                                s5 = s13;
                            label_237:
                                ta0 = ta1;
                                continue;
                            }
                            else {
                                f6 = f0;
                                v17 = v1;
                                s12 = s3;
                                v18 = v8;
                            }
                        label_244:
                            z7 = z5;
                            s20 = s2;
                            arrayList5 = arrayList1;
                        }
                        else if(s6.equals("#EXT-X-GAP")) {
                            s5 = s13;
                            ta0 = ta1;
                            z5 = true;
                            continue;
                        }
                        else if(s6.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                            s5 = s13;
                            ta0 = ta1;
                            z = true;
                            continue;
                        }
                        else if(s6.equals("#EXT-X-ENDLIST")) {
                            s5 = s13;
                            ta0 = ta1;
                            z2 = true;
                            continue;
                        }
                        else if(s6.startsWith("#EXT-X-RENDITION-REPORT")) {
                            long v33 = n.i(s6, n.V);
                            Matcher matcher1 = n.W.matcher(s6);
                            if(matcher1.find()) {
                                String s21 = matcher1.group(1);
                                s21.getClass();
                                v34 = Integer.parseInt(s21);
                            }
                            else {
                                v34 = -1;
                            }
                            arrayList2.add(new e(Uri.parse(b.z(s1, n.k(s6, pattern1, hashMap0))), v33, v34));
                            goto label_300;
                        }
                        else if(s6.startsWith("#EXT-X-PRELOAD-HINT")) {
                            if(d0 == null && "PART".equals(n.k(s6, n.j0, hashMap0))) {
                                DrmInitData drmInitData3 = drmInitData1;
                                String s22 = n.k(s6, pattern1, hashMap0);
                                long v35 = n.i(s6, n.b0);
                                long v36 = n.i(s6, n.c0);
                                if(s3 == null) {
                                    s23 = null;
                                }
                                else {
                                    s23 = s4 == null ? Long.toHexString(v3) : s4;
                                }
                                if(drmInitData0 != null || treeMap0.isEmpty()) {
                                    drmInitData5 = drmInitData0;
                                }
                                else {
                                    SchemeData[] arr_drmInitData$SchemeData = (SchemeData[])treeMap0.values().toArray(new SchemeData[0]);
                                    DrmInitData drmInitData4 = new DrmInitData(s13, true, arr_drmInitData$SchemeData);
                                    if(drmInitData3 == null) {
                                        drmInitData3 = n.b(s13, arr_drmInitData$SchemeData);
                                    }
                                    drmInitData5 = drmInitData4;
                                }
                                int v37 = Long.compare(v35, -1L);
                                if(v37 == 0 || v36 != -1L) {
                                    d0 = new d(s22, f0, 0L, v10, v1, drmInitData5, s3, s23, (v37 == 0 ? 0L : v35), v36, false, false, true);
                                }
                                s5 = s13;
                                drmInitData0 = drmInitData5;
                                ta0 = ta1;
                                drmInitData1 = drmInitData3;
                                continue;
                            }
                        label_300:
                            f6 = f0;
                            v17 = v1;
                            s12 = s3;
                            v18 = v8;
                            z7 = z5;
                            s20 = s2;
                            arrayList5 = arrayList1;
                        }
                        else {
                            DrmInitData drmInitData6 = drmInitData1;
                            if(s6.startsWith("#EXT-X-PART")) {
                                if(s3 == null) {
                                    s24 = null;
                                }
                                else {
                                    s24 = s4 == null ? Long.toHexString(v3) : s4;
                                }
                                String s25 = n.k(s6, pattern1, hashMap0);
                                double f9 = Double.parseDouble(n.k(s6, n.n, Collections.EMPTY_MAP));
                                boolean z8 = n.g(s6, n.s0);
                                boolean z9 = z && arrayList1.isEmpty();
                                boolean z10 = n.g(s6, n.t0);
                                String s26 = n.j(s6, pattern0, null, hashMap0);
                                if(s26 == null) {
                                    v39 = -1L;
                                }
                                else {
                                    String[] arr_s2 = s26.split("@", -1);
                                    long v38 = Long.parseLong(arr_s2[0]);
                                    if(arr_s2.length > 1) {
                                        v7 = Long.parseLong(arr_s2[1]);
                                    }
                                    v39 = v38;
                                }
                                int v40 = Long.compare(v39, -1L);
                                long v41 = v40 == 0 ? 0L : v7;
                                if(drmInitData0 != null || treeMap0.isEmpty()) {
                                    drmInitData8 = drmInitData0;
                                }
                                else {
                                    SchemeData[] arr_drmInitData$SchemeData1 = (SchemeData[])treeMap0.values().toArray(new SchemeData[0]);
                                    DrmInitData drmInitData7 = new DrmInitData(s13, true, arr_drmInitData$SchemeData1);
                                    if(drmInitData6 == null) {
                                        drmInitData6 = n.b(s13, arr_drmInitData$SchemeData1);
                                    }
                                    drmInitData8 = drmInitData7;
                                }
                                arrayList1.add(new d(s25, f0, ((long)(f9 * 1000000.0)), v10, v1, drmInitData8, s3, s24, v41, v39, z10, ((boolean)(z8 | z9)), false));
                                v1 += (long)(f9 * 1000000.0);
                                if(v40 != 0) {
                                    v41 += v39;
                                }
                                v7 = v41;
                                drmInitData1 = drmInitData6;
                                s5 = s13;
                                drmInitData0 = drmInitData8;
                                ta0 = ta1;
                                continue;
                            }
                            else {
                                f6 = f0;
                                v17 = v1;
                                arrayList5 = arrayList1;
                                if(s6.startsWith("#")) {
                                    drmInitData1 = drmInitData6;
                                    s12 = s3;
                                    v18 = v8;
                                    z7 = z5;
                                    s20 = s2;
                                }
                                else {
                                    if(s3 == null) {
                                        s27 = null;
                                    }
                                    else {
                                        s27 = s4 == null ? Long.toHexString(v3) : s4;
                                    }
                                    String s28 = n.l(s6, hashMap0);
                                    f f10 = (f)hashMap1.get(s28);
                                    int v42 = Long.compare(v8, -1L);
                                    if(v42 == 0) {
                                        f11 = f10;
                                        v4 = 0L;
                                    }
                                    else {
                                        if(z4 && f6 == null && f10 == null) {
                                            f10 = new f(s28, 0L, v4, null, null);
                                            hashMap1.put(s28, f10);
                                        }
                                        f11 = f10;
                                    }
                                    if(drmInitData0 != null || treeMap0.isEmpty()) {
                                    label_378:
                                        drmInitData9 = drmInitData6;
                                        s29 = s28;
                                    }
                                    else {
                                        drmInitData9 = drmInitData6;
                                        s29 = s28;
                                        SchemeData[] arr_drmInitData$SchemeData2 = (SchemeData[])treeMap0.values().toArray(new SchemeData[0]);
                                        DrmInitData drmInitData10 = new DrmInitData(s13, true, arr_drmInitData$SchemeData2);
                                        if(drmInitData9 == null) {
                                            drmInitData11 = n.b(s13, arr_drmInitData$SchemeData2);
                                            drmInitData0 = drmInitData10;
                                            goto label_381;
                                        }
                                        else {
                                            drmInitData0 = drmInitData10;
                                            goto label_380;
                                        }
                                        goto label_378;
                                    }
                                label_380:
                                    drmInitData11 = drmInitData9;
                                label_381:
                                    arrayList0.add(new f(s29, (f6 == null ? f11 : f6), s2, v6, v10, v5, drmInitData0, s3, s27, v4, v8, z5, arrayList5));
                                    v1 = v5 + v6;
                                    ArrayList arrayList6 = new ArrayList();
                                    if(v42 != 0) {
                                        v4 += v8;
                                    }
                                    drmInitData1 = drmInitData11;
                                    f0 = f6;
                                    ++v3;
                                    s5 = s13;
                                    s2 = "";
                                    v5 = v1;
                                    v6 = 0L;
                                    v8 = -1L;
                                    ta0 = ta1;
                                    z5 = false;
                                    arrayList1 = arrayList6;
                                    continue;
                                }
                            }
                        }
                    }
                    f0 = f6;
                    arrayList1 = arrayList5;
                    s5 = s13;
                    s2 = s20;
                    v1 = v17;
                    s3 = s12;
                    v8 = v18;
                    z5 = z7;
                }
                ta0 = ta1;
            }
        }
        HashMap hashMap2 = new HashMap();
        for(int v43 = 0; v43 < arrayList2.size(); ++v43) {
            e e0 = (e)arrayList2.get(v43);
            long v44 = e0.b == -1L ? v14 + ((long)arrayList0.size()) - ((long)arrayList1.isEmpty()) : e0.b;
            int v45 = e0.c;
            if(v45 == -1 && v13 != 0x8000000000000001L) {
                V v46 = arrayList1.isEmpty() ? ((f)w.j(arrayList0)).m : arrayList1;
                v45 = v46.size() - 1;
            }
            e e1 = new e(e0.a, v44, v45);
            hashMap2.put(e0.a, e1);
        }
        if(d0 != null) {
            arrayList1.add(d0);
        }
        return v2 == 0L ? new h(v9, s1, arrayList3, v, z1, 0L, z3, v11, v14, v15, v12, v13, z, z2, false, drmInitData1, arrayList0, arrayList1, ta0, hashMap2) : new h(v9, s1, arrayList3, v, z1, v2, z3, v11, v14, v15, v12, v13, z, z2, true, drmInitData1, arrayList0, arrayList1, ta0, hashMap2);
    }

    // This method was un-flattened
    public static k e(s s0, String s1) {
        ArrayList arrayList16;
        ArrayList arrayList15;
        j j5;
        String s18;
        j j1;
        String s20;
        int v12;
        String s22;
        j j3;
        int v10;
        int v9;
        Uri uri0;
        int v6;
        int v5;
        int v4;
        int v2;
        ArrayList arrayList9;
        ArrayList arrayList8;
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
            boolean z1 = s0.j();
            pattern0 = n.g0;
            pattern1 = n.l0;
            if(!z1) {
                break;
            }
            String s2 = s0.q();
            if(s2.startsWith("#EXT")) {
                arrayList7.add(s2);
            }
            boolean z2 = s2.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            if(s2.startsWith("#EXT-X-DEFINE")) {
                hashMap1.put(n.k(s2, pattern1, hashMap1), n.k(s2, n.v0, hashMap1));
                goto label_36;
            }
            else if(s2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                arrayList8 = arrayList2;
                arrayList9 = arrayList3;
                z = true;
            }
            else if(s2.startsWith("#EXT-X-MEDIA")) {
                arrayList5.add(s2);
                goto label_36;
            }
            else if(s2.startsWith("#EXT-X-SESSION-KEY")) {
                SchemeData drmInitData$SchemeData0 = n.c(s2, n.j(s2, n.e0, "identity", hashMap1), hashMap1);
                if(drmInitData$SchemeData0 != null) {
                    String s3 = n.k(s2, n.d0, hashMap1);
                    arrayList6.add(new DrmInitData(("SAMPLE-AES-CENC".equals(s3) || "SAMPLE-AES-CTR".equals(s3) ? "cenc" : "cbcs"), true, new SchemeData[]{drmInitData$SchemeData0}));
                }
            label_36:
                arrayList8 = arrayList2;
                arrayList9 = arrayList3;
            }
            else if(s2.startsWith("#EXT-X-STREAM-INF") || z2) {
                boolean z3 = s2.contains("CLOSED-CAPTIONS=NONE");
                int v1 = Integer.parseInt(n.k(s2, n.h, Collections.EMPTY_MAP));
                Matcher matcher0 = n.c.matcher(s2);
                if(matcher0.find()) {
                    String s4 = matcher0.group(1);
                    s4.getClass();
                    v2 = Integer.parseInt(s4);
                }
                else {
                    v2 = -1;
                }
                String s5 = n.j(s2, n.j, null, hashMap1);
                String s6 = n.j(s2, n.k, null, hashMap1);
                if(s6 == null) {
                    arrayList9 = arrayList3;
                    v6 = -1;
                    v4 = -1;
                }
                else {
                    arrayList9 = arrayList3;
                    String[] arr_s = s6.split("x", -1);
                    int v3 = Integer.parseInt(arr_s[0]);
                    v4 = Integer.parseInt(arr_s[1]);
                    if(v3 <= 0 || v4 <= 0) {
                        v4 = -1;
                        v5 = -1;
                    }
                    else {
                        v5 = v3;
                    }
                    v6 = v5;
                }
                arrayList8 = arrayList2;
                String s7 = n.j(s2, n.l, null, hashMap1);
                float f = s7 == null ? -1.0f : Float.parseFloat(s7);
                String s8 = n.j(s2, n.d, null, hashMap1);
                String s9 = n.j(s2, n.e, null, hashMap1);
                String s10 = n.j(s2, n.f, null, hashMap1);
                String s11 = n.j(s2, n.g, null, hashMap1);
                if(z2) {
                    uri0 = b.A(s1, n.k(s2, pattern0, hashMap1));
                }
                else {
                    if(!s0.j()) {
                        throw I.b("#EXT-X-STREAM-INF must be followed by another line");
                    }
                    uri0 = b.A(s1, n.l(s0.q(), hashMap1));
                }
                b3.n n0 = new b3.n();
                n0.a = Integer.toString(arrayList0.size());
                n0.l = "application/x-mpegURL";
                n0.j = s5;
                n0.h = v2;
                n0.i = v1;
                n0.t = v6;
                n0.u = v4;
                n0.v = f;
                n0.f = z2 ? 0x4000 : 0;
                arrayList0.add(new j(uri0, new androidx.media3.common.b(n0), s8, s9, s10, s11));
                ArrayList arrayList10 = (ArrayList)hashMap0.get(uri0);
                if(arrayList10 == null) {
                    arrayList10 = new ArrayList();
                    hashMap0.put(uri0, arrayList10);
                }
                arrayList10.add(new VariantInfo(v2, v1, s8, s9, s10, s11));
                v |= z3;
            }
            else {
                arrayList8 = arrayList2;
                arrayList9 = arrayList3;
            }
            arrayList3 = arrayList9;
            arrayList2 = arrayList8;
        }
        ArrayList arrayList11 = arrayList2;
        ArrayList arrayList12 = arrayList3;
        ArrayList arrayList13 = new ArrayList();
        HashSet hashSet0 = new HashSet();
        for(int v7 = 0; v7 < arrayList0.size(); ++v7) {
            j j0 = (j)arrayList0.get(v7);
            androidx.media3.common.b b0 = j0.b;
            if(hashSet0.add(j0.a)) {
                b.j(b0.l == null);
                ArrayList arrayList14 = (ArrayList)hashMap0.get(j0.a);
                arrayList14.getClass();
                Metadata metadata0 = new Metadata(new Entry[]{new HlsTrackMetadataEntry(null, null, arrayList14)});
                b3.n n1 = b0.a();
                n1.k = metadata0;
                androidx.media3.common.b b1 = new androidx.media3.common.b(n1);
                arrayList13.add(new j(j0.a, b1, j0.c, j0.d, j0.e, j0.f));
            }
        }
        int v8 = 0;
        androidx.media3.common.b b2 = null;
        List list0 = null;
        while(v8 < arrayList5.size()) {
            String s12 = (String)arrayList5.get(v8);
            String s13 = n.k(s12, n.m0, hashMap1);
            String s14 = n.k(s12, pattern1, hashMap1);
            b3.n n2 = new b3.n();
            n2.a = s13 + ":" + s14;
            n2.b = s14;
            n2.l = "application/x-mpegURL";
            boolean z4 = n.g(s12, n.q0);
            if(n.g(s12, n.r0)) {
                z4 |= 2;
            }
            if(n.g(s12, n.p0)) {
                z4 |= 4;
            }
            n2.e = z4;
            String s15 = n.j(s12, n.n0, null, hashMap1);
            if(TextUtils.isEmpty(s15)) {
                v9 = v8;
                v10 = 0;
            }
            else {
                v9 = v8;
                String[] arr_s1 = s15.split(",", -1);
                v10 = x.j(arr_s1, "public.accessibility.describes-video") ? 0x200 : 0;
                if(x.j(arr_s1, "public.accessibility.transcribes-spoken-dialog")) {
                    v10 |= 0x1000;
                }
                if(x.j(arr_s1, "public.accessibility.describes-music-and-sound")) {
                    v10 |= 0x400;
                }
                if(x.j(arr_s1, "public.easy-to-read")) {
                    v10 |= 0x2000;
                }
            }
            n2.f = v10;
            n2.d = n.j(s12, n.k0, null, hashMap1);
            String s16 = n.j(s12, pattern0, null, hashMap1);
            Uri uri1 = s16 == null ? null : b.A(s1, s16);
            Metadata metadata1 = new Metadata(new Entry[]{new HlsTrackMetadataEntry(s13, s14, Collections.EMPTY_LIST)});
            switch(n.k(s12, n.i0, hashMap1)) {
                case "AUDIO": {
                    int v13 = 0;
                    while(true) {
                        j3 = null;
                        if(v13 < arrayList0.size()) {
                            j j4 = (j)arrayList0.get(v13);
                            if(s13.equals(j4.d)) {
                                j3 = j4;
                            }
                            else {
                                ++v13;
                                continue;
                            }
                        }
                        break;
                    }
                    if(j3 == null) {
                        s22 = null;
                    }
                    else {
                        String s21 = x.s(j3.b.k, 1);
                        n2.j = s21;
                        s22 = H.c(s21);
                    }
                    String s23 = n.j(s12, n.i, null, hashMap1);
                    if(s23 != null) {
                        n2.B = Integer.parseInt(s23.split("/", 2)[0]);
                        if("audio/eac3".equals(s22) && s23.endsWith("/JOC")) {
                            n2.j = "ec+3";
                            s22 = "audio/eac3-joc";
                        }
                    }
                    n2.m = H.l(s22);
                    if(uri1 == null) {
                        arrayList16 = arrayList11;
                        if(j3 != null) {
                            b2 = new androidx.media3.common.b(n2);
                        }
                    }
                    else {
                        n2.k = metadata1;
                        arrayList16 = arrayList11;
                        arrayList16.add(new i(uri1, new androidx.media3.common.b(n2), s14));
                    }
                    arrayList15 = arrayList12;
                    break;
                }
                case "CLOSED-CAPTIONS": {
                    arrayList16 = arrayList11;
                    String s19 = n.k(s12, n.o0, hashMap1);
                    if(s19.startsWith("CC")) {
                        v12 = Integer.parseInt(s19.substring(2));
                        s20 = "application/cea-608";
                    }
                    else {
                        v12 = Integer.parseInt(s19.substring(7));
                        s20 = "application/cea-708";
                    }
                    if(list0 == null) {
                        list0 = new ArrayList();
                    }
                    n2.m = H.l(s20);
                    n2.G = v12;
                    list0.add(new androidx.media3.common.b(n2));
                    arrayList15 = arrayList12;
                    break;
                }
                case "SUBTITLES": {
                    arrayList16 = arrayList11;
                    int v11 = 0;
                    while(true) {
                        j1 = null;
                        if(v11 < arrayList0.size()) {
                            j j2 = (j)arrayList0.get(v11);
                            if(s13.equals(j2.e)) {
                                j1 = j2;
                            }
                            else {
                                ++v11;
                                continue;
                            }
                        }
                        break;
                    }
                    if(j1 == null) {
                        s18 = null;
                    }
                    else {
                        String s17 = x.s(j1.b.k, 3);
                        n2.j = s17;
                        s18 = H.c(s17);
                    }
                    if(s18 == null) {
                        s18 = "text/vtt";
                    }
                    n2.m = H.l(s18);
                    n2.k = metadata1;
                    if(uri1 == null) {
                        arrayList15 = arrayList12;
                        b.D("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                    }
                    else {
                        arrayList15 = arrayList12;
                        arrayList15.add(new i(uri1, new androidx.media3.common.b(n2), s14));
                    }
                    break;
                }
                case "VIDEO": {
                    int v14 = 0;
                    while(true) {
                        j5 = null;
                        if(v14 < arrayList0.size()) {
                            j j6 = (j)arrayList0.get(v14);
                            if(s13.equals(j6.c)) {
                                j5 = j6;
                            }
                            else {
                                ++v14;
                                continue;
                            }
                        }
                        break;
                    }
                    if(j5 != null) {
                        String s24 = x.s(j5.b.k, 2);
                        n2.j = s24;
                        n2.m = H.l(H.c(s24));
                        n2.t = j5.b.u;
                        n2.u = j5.b.v;
                        n2.v = j5.b.w;
                    }
                    if(uri1 != null) {
                        n2.k = metadata1;
                        arrayList1.add(new i(uri1, new androidx.media3.common.b(n2), s14));
                    }
                    arrayList15 = arrayList12;
                    arrayList16 = arrayList11;
                    break;
                }
                default: {
                    arrayList15 = arrayList12;
                    arrayList16 = arrayList11;
                }
            }
            v8 = v9 + 1;
            arrayList11 = arrayList16;
            arrayList12 = arrayList15;
        }
        if(v) {
            list0 = Collections.EMPTY_LIST;
        }
        return new k(s1, arrayList7, arrayList13, arrayList1, arrayList11, arrayList12, arrayList4, b2, list0, z, hashMap1, arrayList6);
    }

    @Override  // w3.l
    public final m3.l f(Uri uri0, g3.h h0) {
        m3.l l1;
        m3.l l0;
        String s1;
        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(h0));
        ArrayDeque arrayDeque0 = new ArrayDeque();
        try {
            int v = bufferedReader0.read();
            boolean z = false;
            if(v != 0xEF) {
            label_7:
                while(v != -1 && Character.isWhitespace(v)) {
                    v = bufferedReader0.read();
                }
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= 7) {
                        while(v != -1 && Character.isWhitespace(v) && !x.J(v)) {
                            v = bufferedReader0.read();
                        }
                        z = x.J(v);
                        break;
                    }
                    if(v != "#EXTM3U".charAt(v1)) {
                        break;
                    }
                    v = bufferedReader0.read();
                }
            label_21:
                if(!z) {
                    throw I.b("Input does not start with the #EXTM3U header.");
                }
            }
            else if(bufferedReader0.read() == 0xBB && bufferedReader0.read() == 0xBF) {
                v = bufferedReader0.read();
                goto label_7;
            }
            else {
                goto label_21;
            }
            while(true) {
                String s = bufferedReader0.readLine();
                if(s == null) {
                    goto label_44;
                }
                s1 = s.trim();
                if(!s1.isEmpty()) {
                    if(s1.startsWith("#EXT-X-STREAM-INF")) {
                        goto label_36;
                    }
                    if(s1.startsWith("#EXT-X-TARGETDURATION") || s1.startsWith("#EXT-X-MEDIA-SEQUENCE") || s1.startsWith("#EXTINF") || s1.startsWith("#EXT-X-KEY") || s1.startsWith("#EXT-X-BYTERANGE") || s1.equals("#EXT-X-DISCONTINUITY") || s1.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || s1.equals("#EXT-X-ENDLIST")) {
                        break;
                    }
                    arrayDeque0.add(s1);
                }
            }
            arrayDeque0.add(s1);
            s s2 = new s(arrayDeque0, bufferedReader0);
            l0 = n.d(this.a, this.b, s2, uri0.toString());
        }
        catch(Throwable throwable0) {
            goto label_40;
        }
        try {
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        return l0;
        try {
        label_36:
            arrayDeque0.add(s1);
            l1 = n.e(new s(arrayDeque0, bufferedReader0), uri0.toString());
        }
        catch(Throwable throwable0) {
            try {
            label_40:
                bufferedReader0.close();
            }
            catch(IOException unused_ex) {
            }
            throw throwable0;
        }
        try {
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        return l1;
        try {
        label_44:
            bufferedReader0.close();
        }
        catch(IOException unused_ex) {
        }
        throw I.b("Failed to parse the playlist, could not identify any tags.");
    }

    public static boolean g(String s, Pattern pattern0) {
        Matcher matcher0 = pattern0.matcher(s);
        return matcher0.find() ? "YES".equals(matcher0.group(1)) : false;
    }

    public static double h(String s, Pattern pattern0) {
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            return Double.parseDouble(s1);
        }
        return -9223372036854776000.0;
    }

    public static long i(String s, Pattern pattern0) {
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            return Long.parseLong(s1);
        }
        return -1L;
    }

    public static String j(String s, Pattern pattern0, String s1, Map map0) {
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            s1 = matcher0.group(1);
            s1.getClass();
        }
        return map0.isEmpty() || s1 == null ? s1 : n.l(s1, map0);
    }

    public static String k(String s, Pattern pattern0, Map map0) {
        String s1 = n.j(s, pattern0, null, map0);
        if(s1 == null) {
            throw I.b(("Couldn\'t match " + pattern0.pattern() + " in " + s));
        }
        return s1;
    }

    public static String l(String s, Map map0) {
        Matcher matcher0 = n.x0.matcher(s);
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
}

