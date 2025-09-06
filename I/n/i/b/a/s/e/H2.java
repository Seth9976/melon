package i.n.i.b.a.s.e;

import U4.x;
import V3.o;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.util.Xml;
import d5.c;
import g3.h;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h2 extends DefaultHandler implements kd {
    public final XmlPullParserFactory a;
    public final Gd b;
    public static final Pattern c;
    public static final Pattern d;
    public static final Pattern e;
    public static final int[] f;

    static {
        h2.c = Pattern.compile("(\\d+)(?:/(\\d+))?");
        h2.d = Pattern.compile("CC([1-4])=.*");
        h2.e = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
        h2.f = new int[]{-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    }

    public h2(Gd gd0) {
        this.b = gd0;
        try {
            this.a = XmlPullParserFactory.newInstance();
        }
        catch(XmlPullParserException xmlPullParserException0) {
            throw new RuntimeException("Couldn\'t create XmlPullParserFactory instance", xmlPullParserException0);
        }
    }

    public static float a(XmlPullParser xmlPullParser0, float f) {
        String s = xmlPullParser0.getAttributeValue(null, "frameRate");
        if(s != null) {
            Matcher matcher0 = h2.c.matcher(s);
            if(matcher0.matches()) {
                int v = Integer.parseInt(matcher0.group(1));
                String s1 = matcher0.group(2);
                return TextUtils.isEmpty(s1) ? ((float)v) : ((float)v) / ((float)Integer.parseInt(s1));
            }
        }
        return f;
    }

    public static int b(String s) {
        if(s != null) {
            switch(s) {
                case "alternate": {
                    return 2;
                }
                case "caption": {
                    return 0x40;
                }
                case "commentary": {
                    return 8;
                }
                case "description": {
                    return 0x200;
                }
                case "dub": {
                    return 16;
                }
                case "emergency": {
                    return 0x20;
                }
                case "enhanced-audio-intelligibility": {
                    return 0x800;
                }
                case "forced_subtitle": {
                    return 0x80;
                }
                case "main": {
                    return 1;
                }
                case "sign": {
                    return 0x100;
                }
                case "subtitle": {
                    return 0x80;
                }
                case "supplementary": {
                    return 4;
                }
                default: {
                    return 0;
                }
            }
        }
        return 0;
    }

    public static long c(ArrayList arrayList0, long v, long v1, int v2, long v3) {
        int v4 = v2 < 0 ? ((int)((v3 - v + v1 - 1L) / v1)) : v2 + 1;
        for(int v5 = 0; v5 < v4; ++v5) {
            arrayList0.add(new i6(v, v1));
            v += v1;
        }
        return v;
    }

    public static long d(XmlPullParser xmlPullParser0, long v) {
        String s = xmlPullParser0.getAttributeValue(null, "availabilityTimeOffset");
        if(s == null) {
            return v;
        }
        return "INF".equals(s) ? 0x7FFFFFFFFFFFFFFFL : ((long)(Float.parseFloat(s) * 1000000.0f));
    }

    public static R4 e(XmlPullParser xmlPullParser0, String s, String s1) {
        String s2 = xmlPullParser0.getAttributeValue(null, s);
        String s3 = xmlPullParser0.getAttributeValue(null, s1);
        long v = -1L;
        if(s3 != null) {
            String[] arr_s = s3.split("-");
            long v1 = Long.parseLong(arr_s[0]);
            if(arr_s.length == 2) {
                v = Long.parseLong(arr_s[1]) - v1 + 1L;
            }
            return new R4(s2, v1, v);
        }
        return new R4(s2, 0L, -1L);
    }

    public static g6 f(XmlPullParser xmlPullParser0, g6 g60, long v, long v1, long v2, long v3, long v4) {
        long v5 = 1L;
        long v6 = g60 == null ? 1L : g60.b;
        List list0 = null;
        String s = xmlPullParser0.getAttributeValue(null, "timescale");
        if(s != null) {
            v6 = Long.parseLong(s);
        }
        long v7 = g60 == null ? 0L : g60.c;
        String s1 = xmlPullParser0.getAttributeValue(null, "presentationTimeOffset");
        if(s1 != null) {
            v7 = Long.parseLong(s1);
        }
        long v8 = g60 == null ? 0x8000000000000001L : g60.e;
        String s2 = xmlPullParser0.getAttributeValue(null, "duration");
        if(s2 != null) {
            v8 = Long.parseLong(s2);
        }
        if(g60 != null) {
            v5 = g60.d;
        }
        String s3 = xmlPullParser0.getAttributeValue(null, "startNumber");
        if(s3 != null) {
            v5 = Long.parseLong(s3);
        }
        long v9 = v3 == 0x8000000000000001L ? v2 : v3;
        long v10 = v9 == 0x7FFFFFFFFFFFFFFFL ? 0x8000000000000001L : v9;
        R4 r40 = null;
        List list1 = null;
        do {
            xmlPullParser0.next();
            if(M7.N(xmlPullParser0, "Initialization")) {
                r40 = h2.e(xmlPullParser0, "sourceURL", "range");
            }
            else if(M7.N(xmlPullParser0, "SegmentTimeline")) {
                list1 = h2.k(xmlPullParser0, v6, v1);
            }
            else if(M7.N(xmlPullParser0, "SegmentURL")) {
                if(list0 == null) {
                    list0 = new ArrayList();
                }
                list0.add(h2.e(xmlPullParser0, "media", "mediaRange"));
            }
            else {
                h2.l(xmlPullParser0);
            }
        }
        while(!M7.L(xmlPullParser0, "SegmentList"));
        if(g60 != null) {
            if(r40 == null) {
                r40 = g60.a;
            }
            if(list1 == null) {
                list1 = g60.f;
            }
            return list0 == null ? new g6(r40, v6, v7, v5, v8, list1, v10, g60.j, b4.a(v4), b4.a(v)) : new g6(r40, v6, v7, v5, v8, list1, v10, list0, b4.a(v4), b4.a(v));
        }
        return new g6(r40, v6, v7, v5, v8, list1, v10, list0, b4.a(v4), b4.a(v));
    }

    public static h6 g(XmlPullParser xmlPullParser0, h6 h60, List list0, long v, long v1, long v2, long v3, long v4) {
        long v10;
        long v5 = 1L;
        long v6 = h60 == null ? 1L : h60.b;
        R4 r40 = null;
        String s = xmlPullParser0.getAttributeValue(null, "timescale");
        if(s != null) {
            v6 = Long.parseLong(s);
        }
        long v7 = h60 == null ? 0L : h60.c;
        String s1 = xmlPullParser0.getAttributeValue(null, "presentationTimeOffset");
        if(s1 != null) {
            v7 = Long.parseLong(s1);
        }
        long v8 = h60 == null ? 0x8000000000000001L : h60.e;
        String s2 = xmlPullParser0.getAttributeValue(null, "duration");
        if(s2 != null) {
            v8 = Long.parseLong(s2);
        }
        if(h60 != null) {
            v5 = h60.d;
        }
        String s3 = xmlPullParser0.getAttributeValue(null, "startNumber");
        if(s3 != null) {
            v5 = Long.parseLong(s3);
        }
        for(int v9 = 0; true; ++v9) {
            v10 = -1L;
            if(v9 >= list0.size()) {
                break;
            }
            O2 o20 = (O2)list0.get(v9);
            if(M7.w("http://dashif.org/guidelines/last-segment-number", o20.a)) {
                v10 = Long.parseLong(o20.b);
                break;
            }
        }
        long v11 = v3 == 0x8000000000000001L ? v2 : v3;
        long v12 = v11 == 0x7FFFFFFFFFFFFFFFL ? 0x8000000000000001L : v11;
        rc rc0 = h2.i(xmlPullParser0, "media", (h60 == null ? null : h60.k));
        rc rc1 = h2.i(xmlPullParser0, "initialization", (h60 == null ? null : h60.j));
        List list1 = null;
        do {
            xmlPullParser0.next();
            if(M7.N(xmlPullParser0, "Initialization")) {
                r40 = h2.e(xmlPullParser0, "sourceURL", "range");
            }
            else if(M7.N(xmlPullParser0, "SegmentTimeline")) {
                list1 = h2.k(xmlPullParser0, v6, v1);
            }
            else {
                h2.l(xmlPullParser0);
            }
        }
        while(!M7.L(xmlPullParser0, "SegmentTemplate"));
        if(h60 != null) {
            if(r40 == null) {
                r40 = h60.a;
            }
            return list1 == null ? new h6(r40, v6, v7, v5, v10, v8, h60.f, v12, rc1, rc0, b4.a(v4), b4.a(v)) : new h6(r40, v6, v7, v5, v10, v8, list1, v12, rc1, rc0, b4.a(v4), b4.a(v));
        }
        return new h6(r40, v6, v7, v5, v10, v8, list1, v12, rc1, rc0, b4.a(v4), b4.a(v));
    }

    public static j6 h(XmlPullParser xmlPullParser0, j6 j60) {
        long v = j60 == null ? 1L : j60.b;
        R4 r40 = null;
        String s = xmlPullParser0.getAttributeValue(null, "timescale");
        if(s != null) {
            v = Long.parseLong(s);
        }
        long v1 = 0L;
        long v2 = j60 == null ? 0L : j60.c;
        String s1 = xmlPullParser0.getAttributeValue(null, "presentationTimeOffset");
        if(s1 != null) {
            v2 = Long.parseLong(s1);
        }
        long v3 = j60 == null ? 0L : j60.d;
        if(j60 != null) {
            v1 = j60.e;
        }
        String s2 = xmlPullParser0.getAttributeValue(null, "indexRange");
        if(s2 != null) {
            String[] arr_s = s2.split("-");
            v3 = Long.parseLong(arr_s[0]);
            v1 = Long.parseLong(arr_s[1]) - v3 + 1L;
        }
        if(j60 != null) {
            r40 = j60.a;
        }
        do {
            xmlPullParser0.next();
            if(M7.N(xmlPullParser0, "Initialization")) {
                r40 = h2.e(xmlPullParser0, "sourceURL", "range");
            }
            else {
                h2.l(xmlPullParser0);
            }
        }
        while(!M7.L(xmlPullParser0, "SegmentBase"));
        return new j6(r40, v, v2, v3, v1);
    }

    public static rc i(XmlPullParser xmlPullParser0, String s, rc rc0) {
        String s3;
        String s1 = xmlPullParser0.getAttributeValue(null, s);
        if(s1 != null) {
            String[] arr_s = new String[5];
            int[] arr_v = new int[4];
            String[] arr_s1 = new String[4];
            arr_s[0] = "";
            int v = 0;
            int v1 = 0;
            while(v < s1.length()) {
                int v2 = s1.indexOf("$", v);
                if(v2 == -1) {
                    arr_s[v1] = arr_s[v1] + s1.substring(v);
                    v = s1.length();
                }
                else if(v2 != v) {
                    arr_s[v1] = arr_s[v1] + s1.substring(v, v2);
                    v = v2;
                }
                else if(s1.startsWith("$$", v)) {
                    arr_s[v1] = x.m(new StringBuilder(), arr_s[v1], "$");
                    v += 2;
                }
                else {
                    int v3 = s1.indexOf("$", v + 1);
                    String s2 = s1.substring(v + 1, v3);
                    if(s2.equals("RepresentationID")) {
                        arr_v[v1] = 1;
                    }
                    else {
                        int v4 = s2.indexOf("%0");
                        if(v4 == -1) {
                            s3 = "%01d";
                        }
                        else {
                            s3 = s2.substring(v4);
                            s3 = s3.endsWith("d") || s3.endsWith("x") ? s2.substring(v4) : s3 + "d";
                            s2 = s2.substring(0, v4);
                        }
                        switch(s2) {
                            case "Bandwidth": {
                                arr_v[v1] = 3;
                                break;
                            }
                            case "Number": {
                                arr_v[v1] = 2;
                                break;
                            }
                            case "Time": {
                                arr_v[v1] = 4;
                                break;
                            }
                            default: {
                                throw new IllegalArgumentException("Invalid template: " + s1);
                            }
                        }
                        arr_s1[v1] = s3;
                    }
                    ++v1;
                    arr_s[v1] = "";
                    v = v3 + 1;
                }
            }
            return new rc(v1, arr_s, arr_v, arr_s1);
        }
        return rc0;
    }

    @Override  // i.n.i.b.a.s.e.kd
    public final Object j(Uri uri0, h h0) {
        try {
            XmlPullParser xmlPullParser0 = this.a.newPullParser();
            xmlPullParser0.setInput(h0, null);
            if(xmlPullParser0.next() != 2 || !"MPD".equals(xmlPullParser0.getName())) {
                throw new H4("inputStream does not contain a valid media presentation description");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            return this.p(xmlPullParser0, uri0.toString());
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        throw new H4(xmlPullParserException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
    }

    public static ArrayList k(XmlPullParser xmlPullParser0, long v, long v1) {
        long v6;
        ArrayList arrayList0 = new ArrayList();
        long v2 = 0L;
        long v3 = 0x8000000000000001L;
        boolean z = false;
        int v4 = 0;
        do {
            xmlPullParser0.next();
            if(M7.N(xmlPullParser0, "S")) {
                String s = xmlPullParser0.getAttributeValue(null, "t");
                long v5 = s == null ? 0x8000000000000001L : Long.parseLong(s);
                if(z) {
                    v6 = v5;
                    v2 = h2.c(arrayList0, v2, v3, v4, v6);
                }
                else {
                    v6 = v5;
                }
                if(v6 != 0x8000000000000001L) {
                    v2 = v6;
                }
                String s1 = xmlPullParser0.getAttributeValue(null, "d");
                v3 = s1 == null ? 0x8000000000000001L : Long.parseLong(s1);
                String s2 = xmlPullParser0.getAttributeValue(null, "r");
                v4 = s2 == null ? 0 : Integer.parseInt(s2);
                z = true;
            }
            else {
                h2.l(xmlPullParser0);
            }
        }
        while(!M7.L(xmlPullParser0, "SegmentTimeline"));
        if(z) {
            h2.c(arrayList0, v2, v3, v4, L7.C(v1, v, 1000L));
        }
        return arrayList0;
    }

    public static void l(XmlPullParser xmlPullParser0) {
        if(xmlPullParser0.getEventType() == 2) {
            int v = 1;
            while(v != 0) {
                xmlPullParser0.next();
                if(xmlPullParser0.getEventType() == 2) {
                    ++v;
                }
                else if(xmlPullParser0.getEventType() == 3) {
                    --v;
                }
            }
        }
    }

    public static long m(XmlPullParser xmlPullParser0, String s, long v) {
        String s1 = xmlPullParser0.getAttributeValue(null, s);
        if(s1 == null) {
            return v;
        }
        Matcher matcher0 = L7.i.matcher(s1);
        if(matcher0.matches()) {
            boolean z = TextUtils.isEmpty(matcher0.group(1));
            String s2 = matcher0.group(3);
            double f = 0.0;
            double f1 = s2 == null ? 0.0 : Double.parseDouble(s2) * 31556908.0;
            String s3 = matcher0.group(5);
            double f2 = s3 == null ? 0.0 : Double.parseDouble(s3) * 2629739.0;
            String s4 = matcher0.group(7);
            double f3 = s4 == null ? 0.0 : Double.parseDouble(s4) * 86400.0;
            String s5 = matcher0.group(10);
            double f4 = s5 == null ? 0.0 : Double.parseDouble(s5) * 3600.0;
            String s6 = matcher0.group(12);
            double f5 = s6 == null ? 0.0 : Double.parseDouble(s6) * 60.0;
            String s7 = matcher0.group(14);
            if(s7 != null) {
                f = Double.parseDouble(s7);
            }
            long v1 = (long)((f1 + f2 + f3 + f4 + f5 + f) * 1000.0);
            return z ? v1 : -v1;
        }
        return (long)(Double.parseDouble(s1) * 3600000.0);
    }

    public static O2 n(XmlPullParser xmlPullParser0, String s) {
        String s1 = null;
        String s2 = xmlPullParser0.getAttributeValue(null, "schemeIdUri");
        if(s2 == null) {
            s2 = "";
        }
        String s3 = xmlPullParser0.getAttributeValue(null, "value");
        if(s3 == null) {
            s3 = null;
        }
        String s4 = xmlPullParser0.getAttributeValue(null, "id");
        if(s4 != null) {
            s1 = s4;
        }
        do {
            xmlPullParser0.next();
        }
        while(!M7.L(xmlPullParser0, s));
        return new O2(s2, s3, s1);
    }

    public static int o(XmlPullParser xmlPullParser0) {
        String s = xmlPullParser0.getAttributeValue(null, "schemeIdUri");
        if(s == null) {
            s = null;
        }
        s.getClass();
        int v = 2;
        int v1 = -1;
        switch(s) {
            case "tag:dolby.com,2014:dash:audio_channel_configuration:2011": {
                goto label_20;
            }
            case "urn:dolby:dash:audio_channel_configuration:2011": {
            label_20:
                String s3 = xmlPullParser0.getAttributeValue(null, "value");
                if(s3 == null) {
                    v = -1;
                }
                else {
                    String s4 = M7.j(s3);
                    s4.getClass();
                    switch(s4) {
                        case "4000": {
                            v = 1;
                            break;
                        }
                        case "a000": {
                            break;
                        }
                        case "f801": {
                            v = 6;
                            break;
                        }
                        case "fa01": {
                            v = 8;
                            break;
                        }
                        default: {
                            v = -1;
                        }
                    }
                }
                v1 = v;
                break;
            }
            case "urn:mpeg:dash:23003:3:audio_channel_configuration:2011": {
                String s1 = xmlPullParser0.getAttributeValue(null, "value");
                if(s1 != null) {
                    v1 = Integer.parseInt(s1);
                }
                break;
            }
            case "urn:mpeg:mpegB:cicp:ChannelConfiguration": {
                String s2 = xmlPullParser0.getAttributeValue(null, "value");
                int v2 = s2 == null ? -1 : Integer.parseInt(s2);
                if(v2 >= 0) {
                    int[] arr_v = h2.f;
                    if(v2 < arr_v.length) {
                        v1 = arr_v[v2];
                    }
                }
            }
        }
        do {
            xmlPullParser0.next();
        }
        while(!M7.L(xmlPullParser0, "AudioChannelConfiguration"));
        return v1;
    }

    // This method was un-flattened
    public final p1 p(XmlPullParser xmlPullParser0, String s) {
        String s76;
        String s75;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream1;
        ArrayList arrayList42;
        long v92;
        y5 y50;
        String s64;
        long v85;
        int v84;
        ArrayList arrayList38;
        int v78;
        int v71;
        int v66;
        String s55;
        String s53;
        long v57;
        String s52;
        String s51;
        int v54;
        int v53;
        int v52;
        ArrayList arrayList31;
        String s49;
        ArrayList arrayList30;
        ArrayList arrayList29;
        ArrayList arrayList28;
        long v56;
        long v55;
        ArrayList arrayList33;
        ArrayList arrayList32;
        String s50;
        int v45;
        float f5;
        ArrayList arrayList22;
        String s36;
        long v42;
        ArrayList arrayList21;
        ArrayList arrayList20;
        ArrayList arrayList19;
        ArrayList arrayList18;
        long v41;
        int v40;
        String s35;
        float f4;
        String s33;
        ArrayList arrayList17;
        int v38;
        ArrayList arrayList16;
        String s32;
        long v37;
        long v24;
        ArrayList arrayList6;
        long v23;
        ArrayList arrayList5;
        ArrayList arrayList4;
        long v22;
        String s19;
        long v17;
        long v16;
        ArrayList arrayList1;
        String s6;
        long v10;
        String s5;
        long v9;
        long v11;
        String s1 = null;
        String s2 = xmlPullParser0.getAttributeValue(null, "availabilityStartTime");
        long v = s2 == null ? 0x8000000000000001L : L7.I(s2);
        long v1 = h2.m(xmlPullParser0, "mediaPresentationDuration", 0x8000000000000001L);
        long v2 = h2.m(xmlPullParser0, "minBufferTime", 0x8000000000000001L);
        boolean z = "dynamic".equals(xmlPullParser0.getAttributeValue(null, "type"));
        long v3 = z ? h2.m(xmlPullParser0, "minimumUpdatePeriod", 0x8000000000000001L) : 0x8000000000000001L;
        long v4 = z ? h2.m(xmlPullParser0, "timeShiftBufferDepth", 0x8000000000000001L) : 0x8000000000000001L;
        long v5 = z ? h2.m(xmlPullParser0, "suggestedPresentationDelay", 0x8000000000000001L) : 0x8000000000000001L;
        String s3 = xmlPullParser0.getAttributeValue(null, "publishTime");
        long v6 = s3 == null ? 0x8000000000000001L : L7.I(s3);
        long v7 = z ? 0L : 0x8000000000000001L;
        ArrayList arrayList0 = new ArrayList();
        long v8 = z ? 0x8000000000000001L : 0L;
        String s4 = s;
        x4 x40 = null;
        c c0 = null;
        Uri uri0 = null;
        b3.x x0 = null;
        boolean z1 = false;
        boolean z2 = false;
        while(true) {
            xmlPullParser0.next();
            if(M7.N(xmlPullParser0, "BaseURL")) {
                if(z1) {
                    v11 = v7;
                    v9 = v8;
                    s5 = s4;
                    s6 = s1;
                    arrayList1 = arrayList0;
                    v10 = v4;
                    goto label_1033;
                }
                else {
                    v7 = h2.d(xmlPullParser0, v7);
                    v9 = v8;
                    s5 = Ja.r(s4, h2.r(xmlPullParser0, "BaseURL"));
                    v10 = v4;
                    s6 = s1;
                    arrayList1 = arrayList0;
                    z1 = true;
                    goto label_1052;
                }
                goto label_39;
            }
            else {
            label_39:
                if(M7.N(xmlPullParser0, "ProgramInformation")) {
                    String s7 = xmlPullParser0.getAttributeValue(s1, "moreInformationURL");
                    String s8 = xmlPullParser0.getAttributeValue(s1, "lang");
                    String s9 = s1;
                    String s10 = s9;
                    String s11 = s10;
                    do {
                        xmlPullParser0.next();
                        if(M7.N(xmlPullParser0, "Title")) {
                            s9 = xmlPullParser0.nextText();
                        }
                        else if(M7.N(xmlPullParser0, "Source")) {
                            s10 = xmlPullParser0.nextText();
                        }
                        else if(M7.N(xmlPullParser0, "Copyright")) {
                            s11 = xmlPullParser0.nextText();
                        }
                        else {
                            h2.l(xmlPullParser0);
                        }
                    }
                    while(!M7.L(xmlPullParser0, "ProgramInformation"));
                    v9 = v8;
                    s5 = s4;
                    s6 = s1;
                    arrayList1 = arrayList0;
                    x40 = new x4(s9, s10, s11, (s7 == null ? s1 : s7), (s8 == null ? s1 : s8));
                    goto label_109;
                }
                else if(M7.N(xmlPullParser0, "UTCTiming")) {
                    v9 = v8;
                    c0 = new c(11, xmlPullParser0.getAttributeValue(s1, "schemeIdUri"), xmlPullParser0.getAttributeValue(s1, "value"));
                    s5 = s4;
                    s6 = s1;
                    arrayList1 = arrayList0;
                    goto label_109;
                }
                else if(M7.N(xmlPullParser0, "Location")) {
                    uri0 = Uri.parse(xmlPullParser0.nextText());
                    v9 = v8;
                    s5 = s4;
                    s6 = s1;
                    arrayList1 = arrayList0;
                    goto label_109;
                }
                else if(M7.N(xmlPullParser0, "ServiceDescription")) {
                    long v12 = 0x8000000000000001L;
                    long v13 = 0x8000000000000001L;
                    long v14 = 0x8000000000000001L;
                    float f = -3.402823E+38f;
                    float f1 = -3.402823E+38f;
                    do {
                        xmlPullParser0.next();
                        if(M7.N(xmlPullParser0, "Latency")) {
                            String s12 = xmlPullParser0.getAttributeValue(null, "target");
                            v12 = s12 == null ? 0x8000000000000001L : Long.parseLong(s12);
                            String s13 = xmlPullParser0.getAttributeValue(null, "min");
                            v13 = s13 == null ? 0x8000000000000001L : Long.parseLong(s13);
                            String s14 = xmlPullParser0.getAttributeValue(null, "max");
                            v14 = s14 == null ? 0x8000000000000001L : Long.parseLong(s14);
                        }
                        else if(M7.N(xmlPullParser0, "PlaybackRate")) {
                            String s15 = xmlPullParser0.getAttributeValue(null, "min");
                            f = s15 == null ? -3.402823E+38f : Float.parseFloat(s15);
                            String s16 = xmlPullParser0.getAttributeValue(null, "max");
                            f1 = s16 == null ? -3.402823E+38f : Float.parseFloat(s16);
                        }
                    }
                    while(!M7.L(xmlPullParser0, "ServiceDescription"));
                    b3.x x1 = new b3.x();  // 初始化器: Ljava/lang/Object;-><init>()V
                    x1.a = v12;
                    x1.b = v13;
                    x1.c = v14;
                    x1.d = f;
                    x1.e = f1;
                    v9 = v8;
                    x0 = x1;
                    s5 = s4;
                    arrayList1 = arrayList0;
                    s6 = null;
                label_109:
                    v10 = v4;
                }
                else {
                    v11 = v7;
                    if(!M7.N(xmlPullParser0, "Period") || z2) {
                        v9 = v8;
                        s5 = s4;
                        arrayList1 = arrayList0;
                        s6 = null;
                        v10 = v4;
                        h2.l(xmlPullParser0);
                        v7 = v11;
                    }
                    else {
                        String s17 = xmlPullParser0.getAttributeValue(null, "id");
                        long v15 = h2.m(xmlPullParser0, "start", v8);
                        if(v == 0x8000000000000001L) {
                            v16 = v8;
                            v17 = 0x8000000000000001L;
                        }
                        else {
                            v16 = v8;
                            v17 = v + v15;
                        }
                        long v18 = h2.m(xmlPullParser0, "duration", 0x8000000000000001L);
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        String s18 = s4;
                        boolean z3 = false;
                        long v19 = v11;
                        j6 j60 = null;
                        long v20 = 0x8000000000000001L;
                        while(true) {
                            xmlPullParser0.next();
                            if(M7.N(xmlPullParser0, "BaseURL")) {
                                if(z3) {
                                    v22 = v17;
                                    arrayList4 = arrayList2;
                                    arrayList5 = arrayList3;
                                    s19 = s18;
                                    s5 = s4;
                                    v23 = v19;
                                    arrayList6 = arrayList0;
                                    s6 = null;
                                    v10 = v4;
                                    v9 = v16;
                                    v24 = v18;
                                    goto label_879;
                                }
                                else {
                                    long v21 = h2.d(xmlPullParser0, v19);
                                    s18 = Ja.r(s18, h2.r(xmlPullParser0, "BaseURL"));
                                    v22 = v17;
                                    arrayList4 = arrayList2;
                                    arrayList5 = arrayList3;
                                    s5 = s4;
                                    v23 = v21;
                                    arrayList6 = arrayList0;
                                    s6 = null;
                                    z3 = true;
                                    v10 = v4;
                                    v9 = v16;
                                    v24 = v18;
                                    goto label_1019;
                                }
                                goto label_158;
                            }
                            else {
                            label_158:
                                v23 = v19;
                                s5 = s4;
                                if(M7.N(xmlPullParser0, "AdaptationSet")) {
                                    String s20 = xmlPullParser0.getAttributeValue(null, "id");
                                    int v25 = s20 == null ? -1 : Integer.parseInt(s20);
                                    int v26 = h2.s(xmlPullParser0);
                                    long v27 = v17;
                                    String s21 = xmlPullParser0.getAttributeValue(null, "mimeType");
                                    String s22 = xmlPullParser0.getAttributeValue(null, "codecs");
                                    String s23 = xmlPullParser0.getAttributeValue(null, "width");
                                    int v28 = s23 == null ? -1 : Integer.parseInt(s23);
                                    String s24 = xmlPullParser0.getAttributeValue(null, "height");
                                    int v29 = s24 == null ? -1 : Integer.parseInt(s24);
                                    float f2 = h2.a(xmlPullParser0, -1.0f);
                                    ArrayList arrayList7 = arrayList2;
                                    ArrayList arrayList8 = arrayList3;
                                    String s25 = xmlPullParser0.getAttributeValue(null, "audioSamplingRate");
                                    int v30 = s25 == null ? -1 : Integer.parseInt(s25);
                                    String s26 = xmlPullParser0.getAttributeValue(null, "lang");
                                    s19 = s18;
                                    String s27 = xmlPullParser0.getAttributeValue(null, "label");
                                    ArrayList arrayList9 = new ArrayList();
                                    String s28 = s27;
                                    ArrayList arrayList10 = new ArrayList();
                                    ArrayList arrayList11 = new ArrayList();
                                    long v31 = v4;
                                    ArrayList arrayList12 = new ArrayList();
                                    ArrayList arrayList13 = new ArrayList();
                                    ArrayList arrayList14 = new ArrayList();
                                    float f3 = f2;
                                    boolean z4 = false;
                                    j6 j61 = j60;
                                    long v32 = v20;
                                    long v33 = v23;
                                    String s29 = s26;
                                    String s30 = s19;
                                    int v34 = -1;
                                    ArrayList arrayList15 = new ArrayList();
                                    int v35 = v26;
                                    String s31 = null;
                                    while(true) {
                                        xmlPullParser0.next();
                                        if(M7.N(xmlPullParser0, "BaseURL")) {
                                            if(z4) {
                                                v37 = v33;
                                                goto label_280;
                                            }
                                            else {
                                                long v36 = h2.d(xmlPullParser0, v33);
                                                s30 = Ja.r(s30, h2.r(xmlPullParser0, "BaseURL"));
                                                v37 = v36;
                                                s32 = s29;
                                                arrayList16 = arrayList9;
                                                v38 = v35;
                                                arrayList4 = arrayList7;
                                                arrayList5 = arrayList8;
                                                arrayList17 = arrayList15;
                                                s33 = s28;
                                                f4 = f3;
                                                z4 = true;
                                                goto label_263;
                                            }
                                            goto label_216;
                                        }
                                        else {
                                        label_216:
                                            if(M7.N(xmlPullParser0, "ContentProtection")) {
                                                Pair pair0 = h2.q(xmlPullParser0);
                                                v37 = v33;
                                                Object object0 = pair0.first;
                                                if(object0 != null) {
                                                    s31 = (String)object0;
                                                }
                                                Object object1 = pair0.second;
                                                if(object1 != null) {
                                                    arrayList9.add(((b)object1));
                                                }
                                                goto label_280;
                                            }
                                            else {
                                                v37 = v33;
                                                if(M7.N(xmlPullParser0, "ContentComponent")) {
                                                    String s34 = xmlPullParser0.getAttributeValue(null, "lang");
                                                    if(s29 == null) {
                                                        s29 = s34;
                                                    }
                                                    else if(s34 != null) {
                                                        M7.J(s29.equals(s34));
                                                    }
                                                    int v39 = h2.s(xmlPullParser0);
                                                    if(v35 == -1) {
                                                        v35 = v39;
                                                    }
                                                    else if(v39 != -1) {
                                                        M7.J(v35 == v39);
                                                    }
                                                    goto label_255;
                                                }
                                                else if(M7.N(xmlPullParser0, "Role")) {
                                                    arrayList12.add(h2.n(xmlPullParser0, "Role"));
                                                    s35 = s30;
                                                    s32 = s29;
                                                    arrayList16 = arrayList9;
                                                    v40 = v35;
                                                    arrayList4 = arrayList7;
                                                    arrayList5 = arrayList8;
                                                    arrayList17 = arrayList15;
                                                    f4 = f3;
                                                    v41 = v32;
                                                    goto label_296;
                                                }
                                                else if(M7.N(xmlPullParser0, "AudioChannelConfiguration")) {
                                                    v34 = h2.o(xmlPullParser0);
                                                label_255:
                                                    s32 = s29;
                                                    arrayList16 = arrayList9;
                                                    v38 = v35;
                                                    arrayList4 = arrayList7;
                                                    arrayList5 = arrayList8;
                                                    arrayList17 = arrayList15;
                                                    s33 = s28;
                                                    f4 = f3;
                                                label_263:
                                                    arrayList18 = arrayList11;
                                                    arrayList19 = arrayList14;
                                                    arrayList6 = arrayList0;
                                                    arrayList20 = arrayList10;
                                                    arrayList21 = arrayList12;
                                                    v42 = v27;
                                                    v9 = v16;
                                                    v24 = v18;
                                                    s36 = s22;
                                                    arrayList22 = arrayList13;
                                                    v10 = v31;
                                                    goto label_798;
                                                }
                                                else if(M7.N(xmlPullParser0, "Accessibility")) {
                                                    arrayList11.add(h2.n(xmlPullParser0, "Accessibility"));
                                                    goto label_280;
                                                }
                                                else if(M7.N(xmlPullParser0, "EssentialProperty")) {
                                                    arrayList13.add(h2.n(xmlPullParser0, "EssentialProperty"));
                                                label_280:
                                                    s35 = s30;
                                                    s32 = s29;
                                                    arrayList16 = arrayList9;
                                                    v40 = v35;
                                                    goto label_291;
                                                }
                                                else {
                                                    v40 = v35;
                                                    if(M7.N(xmlPullParser0, "SupplementalProperty")) {
                                                        arrayList14.add(h2.n(xmlPullParser0, "SupplementalProperty"));
                                                        s35 = s30;
                                                        s32 = s29;
                                                        arrayList16 = arrayList9;
                                                    label_291:
                                                        arrayList4 = arrayList7;
                                                        arrayList5 = arrayList8;
                                                        arrayList17 = arrayList15;
                                                        f4 = f3;
                                                        v41 = v32;
                                                    label_296:
                                                        arrayList18 = arrayList11;
                                                        arrayList19 = arrayList14;
                                                        arrayList6 = arrayList0;
                                                        arrayList20 = arrayList10;
                                                        arrayList21 = arrayList12;
                                                        v42 = v27;
                                                        v9 = v16;
                                                        v24 = v18;
                                                        s36 = s22;
                                                        arrayList22 = arrayList13;
                                                        v10 = v31;
                                                    }
                                                    else if(M7.N(xmlPullParser0, "Representation")) {
                                                        String s37 = xmlPullParser0.getAttributeValue(null, "id");
                                                        String s38 = xmlPullParser0.getAttributeValue(null, "bandwidth");
                                                        int v43 = s38 == null ? -1 : Integer.parseInt(s38);
                                                        String s39 = xmlPullParser0.getAttributeValue(null, "mimeType");
                                                        String s40 = s39 == null ? s21 : s39;
                                                        String s41 = xmlPullParser0.getAttributeValue(null, "codecs");
                                                        String s42 = s41 == null ? s22 : s41;
                                                        String s43 = xmlPullParser0.getAttributeValue(null, "width");
                                                        int v44 = s43 == null ? v28 : Integer.parseInt(s43);
                                                        String s44 = xmlPullParser0.getAttributeValue(null, "height");
                                                        if(s44 == null) {
                                                            f5 = f3;
                                                            v45 = v29;
                                                        }
                                                        else {
                                                            f5 = f3;
                                                            v45 = Integer.parseInt(s44);
                                                        }
                                                        float f6 = h2.a(xmlPullParser0, f5);
                                                        f4 = f5;
                                                        String s45 = xmlPullParser0.getAttributeValue(null, "audioSamplingRate");
                                                        int v46 = s45 == null ? v30 : Integer.parseInt(s45);
                                                        ArrayList arrayList23 = new ArrayList();
                                                        ArrayList arrayList24 = new ArrayList();
                                                        ArrayList arrayList25 = new ArrayList(arrayList13);
                                                        int v47 = v46;
                                                        int v48 = v43;
                                                        String s46 = s29;
                                                        ArrayList arrayList26 = arrayList9;
                                                        ArrayList arrayList27 = new ArrayList(arrayList14);
                                                        boolean z5 = false;
                                                        int v49 = v34;
                                                        j6 j62 = j61;
                                                        long v50 = v32;
                                                        long v51 = v37;
                                                        String s47 = s30;
                                                        String s48 = null;
                                                        while(true) {
                                                            xmlPullParser0.next();
                                                            if(M7.N(xmlPullParser0, "BaseURL")) {
                                                                if(z5) {
                                                                    arrayList28 = arrayList12;
                                                                    s50 = s47;
                                                                    arrayList4 = arrayList7;
                                                                    arrayList5 = arrayList8;
                                                                    arrayList29 = arrayList10;
                                                                    arrayList30 = arrayList25;
                                                                    arrayList16 = arrayList26;
                                                                    s49 = s46;
                                                                    arrayList31 = arrayList24;
                                                                    v52 = v48;
                                                                    v53 = v47;
                                                                    arrayList32 = arrayList11;
                                                                    arrayList19 = arrayList14;
                                                                    arrayList6 = arrayList0;
                                                                    arrayList33 = arrayList27;
                                                                    v9 = v16;
                                                                    s36 = s22;
                                                                    arrayList22 = arrayList13;
                                                                    v10 = v31;
                                                                    v55 = v51;
                                                                    v56 = v18;
                                                                    goto label_514;
                                                                }
                                                                else {
                                                                    v51 = h2.d(xmlPullParser0, v51);
                                                                    s47 = Ja.r(s47, h2.r(xmlPullParser0, "BaseURL"));
                                                                    arrayList28 = arrayList12;
                                                                    arrayList4 = arrayList7;
                                                                    arrayList5 = arrayList8;
                                                                    arrayList29 = arrayList10;
                                                                    arrayList30 = arrayList25;
                                                                    arrayList16 = arrayList26;
                                                                    s49 = s46;
                                                                    arrayList31 = arrayList24;
                                                                    v52 = v48;
                                                                    v53 = v47;
                                                                    v54 = v49;
                                                                    z5 = true;
                                                                    goto label_400;
                                                                }
                                                                goto label_384;
                                                            }
                                                            else {
                                                            label_384:
                                                                if(M7.N(xmlPullParser0, "AudioChannelConfiguration")) {
                                                                    v49 = h2.o(xmlPullParser0);
                                                                    goto label_389;
                                                                }
                                                                else if(M7.N(xmlPullParser0, "SegmentBase")) {
                                                                    j62 = h2.h(xmlPullParser0, j62);
                                                                label_389:
                                                                    arrayList28 = arrayList12;
                                                                    arrayList4 = arrayList7;
                                                                    arrayList5 = arrayList8;
                                                                    arrayList29 = arrayList10;
                                                                    arrayList30 = arrayList25;
                                                                    arrayList16 = arrayList26;
                                                                    s49 = s46;
                                                                    arrayList31 = arrayList24;
                                                                    v52 = v48;
                                                                    v53 = v47;
                                                                    v54 = v49;
                                                                label_400:
                                                                    arrayList32 = arrayList11;
                                                                    arrayList19 = arrayList14;
                                                                    arrayList6 = arrayList0;
                                                                    s51 = s48;
                                                                    arrayList33 = arrayList27;
                                                                    s52 = s47;
                                                                    v57 = v50;
                                                                    v9 = v16;
                                                                    s36 = s22;
                                                                    arrayList22 = arrayList13;
                                                                    v10 = v31;
                                                                    v55 = v51;
                                                                    v56 = v18;
                                                                    goto label_518;
                                                                }
                                                                else if(M7.N(xmlPullParser0, "SegmentList")) {
                                                                    arrayList32 = arrayList11;
                                                                    long v58 = h2.d(xmlPullParser0, v50);
                                                                    arrayList28 = arrayList12;
                                                                    v9 = v16;
                                                                    s36 = s22;
                                                                    arrayList4 = arrayList7;
                                                                    arrayList5 = arrayList8;
                                                                    arrayList29 = arrayList10;
                                                                    arrayList16 = arrayList26;
                                                                    s49 = s46;
                                                                    v52 = v48;
                                                                    v53 = v47;
                                                                    arrayList22 = arrayList13;
                                                                    j62 = h2.f(xmlPullParser0, ((g6)j62), v27, v18, v51, v58, v31);
                                                                    v56 = v18;
                                                                    v57 = v58;
                                                                    v55 = v51;
                                                                    arrayList6 = arrayList0;
                                                                    s51 = s48;
                                                                    arrayList31 = arrayList24;
                                                                    arrayList33 = arrayList27;
                                                                    v54 = v49;
                                                                    s52 = s47;
                                                                    arrayList19 = arrayList14;
                                                                    v10 = v31;
                                                                    arrayList30 = arrayList25;
                                                                    goto label_518;
                                                                }
                                                                else {
                                                                    arrayList32 = arrayList11;
                                                                    arrayList28 = arrayList12;
                                                                    s50 = s47;
                                                                    arrayList4 = arrayList7;
                                                                    arrayList5 = arrayList8;
                                                                    arrayList29 = arrayList10;
                                                                    arrayList16 = arrayList26;
                                                                    s49 = s46;
                                                                    v52 = v48;
                                                                    v53 = v47;
                                                                    v9 = v16;
                                                                    v56 = v18;
                                                                    s36 = s22;
                                                                    arrayList22 = arrayList13;
                                                                    if(M7.N(xmlPullParser0, "SegmentTemplate")) {
                                                                        long v59 = h2.d(xmlPullParser0, v50);
                                                                        arrayList6 = arrayList0;
                                                                        v10 = v31;
                                                                        j62 = h2.g(xmlPullParser0, ((h6)j62), arrayList14, v27, v56, v51, v59, v10);
                                                                        arrayList19 = arrayList14;
                                                                        v55 = v51;
                                                                        s51 = s48;
                                                                        arrayList33 = arrayList27;
                                                                        v54 = v49;
                                                                        s52 = s50;
                                                                        v57 = v59;
                                                                        arrayList30 = arrayList25;
                                                                        arrayList31 = arrayList24;
                                                                        goto label_518;
                                                                    }
                                                                    else {
                                                                        arrayList19 = arrayList14;
                                                                        arrayList6 = arrayList0;
                                                                        v10 = v31;
                                                                        if(M7.N(xmlPullParser0, "ContentProtection")) {
                                                                            Pair pair1 = h2.q(xmlPullParser0);
                                                                            Object object2 = pair1.first;
                                                                            if(object2 != null) {
                                                                                s48 = (String)object2;
                                                                            }
                                                                            Object object3 = pair1.second;
                                                                            if(object3 != null) {
                                                                                arrayList23.add(((b)object3));
                                                                            }
                                                                            v55 = v51;
                                                                            arrayList30 = arrayList25;
                                                                            s51 = s48;
                                                                            arrayList31 = arrayList24;
                                                                            arrayList33 = arrayList27;
                                                                            v54 = v49;
                                                                            s52 = s50;
                                                                            v57 = v50;
                                                                            goto label_518;
                                                                        }
                                                                        else if(M7.N(xmlPullParser0, "InbandEventStream")) {
                                                                            arrayList31 = arrayList24;
                                                                            arrayList31.add(h2.n(xmlPullParser0, "InbandEventStream"));
                                                                            v55 = v51;
                                                                            arrayList30 = arrayList25;
                                                                            arrayList33 = arrayList27;
                                                                        }
                                                                        else {
                                                                            arrayList31 = arrayList24;
                                                                            if(M7.N(xmlPullParser0, "EssentialProperty")) {
                                                                                arrayList30 = arrayList25;
                                                                                arrayList30.add(h2.n(xmlPullParser0, "EssentialProperty"));
                                                                                v55 = v51;
                                                                                arrayList33 = arrayList27;
                                                                            }
                                                                            else {
                                                                                arrayList30 = arrayList25;
                                                                                if(M7.N(xmlPullParser0, "SupplementalProperty")) {
                                                                                    v55 = v51;
                                                                                    arrayList33 = arrayList27;
                                                                                    arrayList33.add(h2.n(xmlPullParser0, "SupplementalProperty"));
                                                                                }
                                                                                else {
                                                                                    v55 = v51;
                                                                                    arrayList33 = arrayList27;
                                                                                    h2.l(xmlPullParser0);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        label_514:
                                                            v57 = v50;
                                                            s51 = s48;
                                                            v54 = v49;
                                                            s52 = s50;
                                                        label_518:
                                                            s53 = null;
                                                            if(M7.L(xmlPullParser0, "Representation")) {
                                                                break;
                                                            }
                                                            v49 = v54;
                                                            arrayList27 = arrayList33;
                                                            arrayList24 = arrayList31;
                                                            arrayList25 = arrayList30;
                                                            arrayList0 = arrayList6;
                                                            arrayList7 = arrayList4;
                                                            arrayList8 = arrayList5;
                                                            s46 = s49;
                                                            v48 = v52;
                                                            v47 = v53;
                                                            arrayList12 = arrayList28;
                                                            v51 = v55;
                                                            v50 = v57;
                                                            arrayList10 = arrayList29;
                                                            v31 = v10;
                                                            arrayList13 = arrayList22;
                                                            arrayList14 = arrayList19;
                                                            arrayList11 = arrayList32;
                                                            s47 = s52;
                                                            s48 = s51;
                                                            arrayList26 = arrayList16;
                                                            s22 = s36;
                                                            v16 = v9;
                                                            v18 = v56;
                                                        }
                                                        if(mb.h(s40)) {
                                                            if(s42 != null) {
                                                                String[] arr_s = L7.J(s42);
                                                                int v60 = 0;
                                                                while(v60 < arr_s.length) {
                                                                    String s54 = mb.b(arr_s[v60]);
                                                                    if(s54 == null || !mb.h(s54)) {
                                                                        ++v60;
                                                                        continue;
                                                                    }
                                                                    s53 = s54;
                                                                    s55 = s40;
                                                                    goto label_594;
                                                                }
                                                            }
                                                            s55 = s40;
                                                        }
                                                        else if(mb.j(s40)) {
                                                            if(s42 != null) {
                                                                String[] arr_s1 = L7.J(s42);
                                                                int v61 = 0;
                                                                while(v61 < arr_s1.length) {
                                                                    String s56 = mb.b(arr_s1[v61]);
                                                                    if(s56 != null && mb.j(s56)) {
                                                                        s53 = s56;
                                                                        s55 = s40;
                                                                        goto label_594;
                                                                    }
                                                                    ++v61;
                                                                }
                                                            }
                                                            s55 = s40;
                                                        }
                                                        else if(mb.i(s40)) {
                                                            s55 = s40;
                                                            if(!"application/x-rawcc".equals(s55)) {
                                                                s53 = s55;
                                                            }
                                                            else if(s42 != null) {
                                                                String[] arr_s2 = L7.J(s42);
                                                                for(int v62 = 0; v62 < arr_s2.length; ++v62) {
                                                                    String s57 = mb.b(arr_s2[v62]);
                                                                    if(s57 != null && mb.i(s57)) {
                                                                        s53 = s57;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        else {
                                                            s55 = s40;
                                                            if("application/mp4".equals(s55)) {
                                                                String s58 = mb.b(s42);
                                                                s53 = "text/vtt".equals(s58) ? "application/x-mp4-vtt" : s58;
                                                            }
                                                        }
                                                    label_594:
                                                        if("audio/eac3".equals(s53)) {
                                                            int v63 = 0;
                                                            while(true) {
                                                                s53 = "audio/eac3";
                                                                if(v63 < arrayList33.size()) {
                                                                    O2 o20 = (O2)arrayList33.get(v63);
                                                                    if((!"tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(o20.a) || !"JOC".equals(o20.b)) && (!"tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(o20.a) || !"ec+3".equals(o20.b))) {
                                                                        ++v63;
                                                                        continue;
                                                                    }
                                                                    else {
                                                                        s53 = "audio/eac3-joc";
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        int v65 = 0;
                                                        for(int v64 = 0; v64 < arrayList28.size(); ++v64) {
                                                            O2 o21 = (O2)arrayList28.get(v64);
                                                            if(M7.w("urn:mpeg:dash:role:2011", o21.a)) {
                                                                String s59 = o21.b;
                                                                if(s59 == null) {
                                                                    v66 = 0;
                                                                }
                                                                else {
                                                                    switch(s59) {
                                                                        case "forced_subtitle": {
                                                                            v65 |= 2;
                                                                            continue;
                                                                        }
                                                                        case "main": {
                                                                            v66 = 1;
                                                                        }
                                                                    }
                                                                }
                                                                v65 |= v66;
                                                            }
                                                        }
                                                        ArrayList arrayList34 = arrayList28;
                                                        int v68 = 0;
                                                        for(int v67 = 0; v67 < arrayList34.size(); ++v67) {
                                                            O2 o22 = (O2)arrayList34.get(v67);
                                                            if(M7.w("urn:mpeg:dash:role:2011", o22.a)) {
                                                                v68 |= h2.b(o22.b);
                                                            }
                                                        }
                                                        int v69 = 0;
                                                        int v70 = 0;
                                                        while(v69 < arrayList32.size()) {
                                                            O2 o23 = (O2)arrayList32.get(v69);
                                                            String s60 = o23.b;
                                                            if(M7.w("urn:mpeg:dash:role:2011", o23.a)) {
                                                                v71 = h2.b(s60);
                                                                goto label_655;
                                                            }
                                                            else if(M7.w("urn:tva:metadata:cs:AudioPurposeCS:2007", o23.a)) {
                                                                if(s60 == null) {
                                                                    v71 = 0;
                                                                }
                                                                else {
                                                                    switch(s60) {
                                                                        case "1": {
                                                                            v71 = 0x200;
                                                                            break;
                                                                        }
                                                                        case "2": {
                                                                            v71 = 0x800;
                                                                            break;
                                                                        }
                                                                        case "3": {
                                                                            v71 = 4;
                                                                            break;
                                                                        }
                                                                        case "4": {
                                                                            v71 = 8;
                                                                            break;
                                                                        }
                                                                        case "6": {
                                                                            v71 = 1;
                                                                        }
                                                                    }
                                                                }
                                                            label_655:
                                                                v70 |= v71;
                                                            }
                                                            ++v69;
                                                        }
                                                        int v72 = -1;
                                                        ArrayList arrayList35 = arrayList32;
                                                        int v73 = h2.t(arrayList30);
                                                        int v74 = h2.t(arrayList33);
                                                        ob ob0 = new ob();
                                                        ob0.a = s37;
                                                        ob0.j = s55;
                                                        ob0.k = s53;
                                                        ob0.h = s42;
                                                        ob0.g = v52;
                                                        ob0.d = v65;
                                                        ob0.e = v68 | v70 | v73 | v74;
                                                        ob0.c = s49;
                                                        if(mb.j(s53)) {
                                                            ob0.p = v44;
                                                            ob0.q = v45;
                                                            ob0.r = f6;
                                                        }
                                                        else if(mb.h(s53)) {
                                                            ob0.x = v54;
                                                            ob0.y = v53;
                                                        }
                                                        else if(mb.i(s53)) {
                                                            if("application/cea-608".equals(s53)) {
                                                                for(int v75 = 0; v75 < arrayList35.size(); ++v75) {
                                                                    O2 o24 = (O2)arrayList35.get(v75);
                                                                    String s61 = o24.b;
                                                                    if("urn:scte:dash:cc:cea-608:2015".equals(o24.a) && s61 != null) {
                                                                        Matcher matcher0 = h2.d.matcher(s61);
                                                                        if(matcher0.matches()) {
                                                                            v72 = Integer.parseInt(matcher0.group(1));
                                                                            break;
                                                                        }
                                                                        else {
                                                                            Log.w("MpdParser", "Unable to parse CEA-608 channel number from: " + s61);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            else if("application/cea-708".equals(s53)) {
                                                                for(int v76 = 0; v76 < arrayList35.size(); ++v76) {
                                                                    O2 o25 = (O2)arrayList35.get(v76);
                                                                    String s62 = o25.b;
                                                                    if("urn:scte:dash:cc:cea-708:2015".equals(o25.a) && s62 != null) {
                                                                        Matcher matcher1 = h2.e.matcher(s62);
                                                                        if(matcher1.matches()) {
                                                                            v72 = Integer.parseInt(matcher1.group(1));
                                                                            break;
                                                                        }
                                                                        else {
                                                                            Log.w("MpdParser", "Unable to parse CEA-708 service block number from: " + s62);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            ob0.C = v72;
                                                        }
                                                        u u0 = new u(ob0);
                                                        g2 g20 = new g2(u0, s52, (j62 == null ? new j6(null, 1L, 0L, 0L, 0L) : j62), s51, arrayList23, arrayList31);
                                                        int v77 = mb.g(u0.l);
                                                        if(v40 == -1) {
                                                            v78 = v77;
                                                        }
                                                        else {
                                                            if(v77 != -1) {
                                                                M7.J(v40 == v77);
                                                            }
                                                            v78 = v40;
                                                        }
                                                        arrayList15.add(g20);
                                                        s32 = s49;
                                                        arrayList18 = arrayList35;
                                                        arrayList21 = arrayList34;
                                                        v38 = v78;
                                                        v42 = v27;
                                                        s33 = s28;
                                                        v24 = v56;
                                                        arrayList20 = arrayList29;
                                                        arrayList17 = arrayList15;
                                                        goto label_798;
                                                    }
                                                    else {
                                                        s35 = s30;
                                                        arrayList16 = arrayList9;
                                                        arrayList4 = arrayList7;
                                                        arrayList5 = arrayList8;
                                                        f4 = f3;
                                                        arrayList18 = arrayList11;
                                                        arrayList19 = arrayList14;
                                                        arrayList6 = arrayList0;
                                                        v9 = v16;
                                                        s36 = s22;
                                                        arrayList21 = arrayList12;
                                                        arrayList22 = arrayList13;
                                                        v10 = v31;
                                                        if(M7.N(xmlPullParser0, "SegmentBase")) {
                                                            j61 = h2.h(xmlPullParser0, j61);
                                                            s32 = s29;
                                                            arrayList17 = arrayList15;
                                                            v38 = v40;
                                                            s33 = s28;
                                                            v24 = v18;
                                                            s30 = s35;
                                                            arrayList20 = arrayList10;
                                                            v42 = v27;
                                                            goto label_798;
                                                        }
                                                        else if(M7.N(xmlPullParser0, "SegmentList")) {
                                                            long v79 = h2.d(xmlPullParser0, v32);
                                                            s32 = s29;
                                                            arrayList17 = arrayList15;
                                                            j61 = h2.f(xmlPullParser0, ((g6)j61), v27, v18, v37, v79, v10);
                                                            v24 = v18;
                                                            v42 = v27;
                                                            v32 = v79;
                                                            v38 = v40;
                                                            s33 = s28;
                                                            s30 = s35;
                                                            arrayList20 = arrayList10;
                                                            goto label_798;
                                                        }
                                                        else {
                                                            s32 = s29;
                                                            arrayList17 = arrayList15;
                                                            v41 = v32;
                                                            v24 = v18;
                                                            if(M7.N(xmlPullParser0, "SegmentTemplate")) {
                                                                long v80 = h2.d(xmlPullParser0, v41);
                                                                j61 = h2.g(xmlPullParser0, ((h6)j61), arrayList19, v27, v24, v37, v80, v10);
                                                                v42 = v27;
                                                                v32 = v80;
                                                                s33 = s28;
                                                                v38 = v40;
                                                                s30 = s35;
                                                                arrayList20 = arrayList10;
                                                                goto label_798;
                                                            }
                                                            else {
                                                                v42 = v27;
                                                                if(M7.N(xmlPullParser0, "InbandEventStream")) {
                                                                    arrayList20 = arrayList10;
                                                                    arrayList20.add(h2.n(xmlPullParser0, "InbandEventStream"));
                                                                }
                                                                else {
                                                                    arrayList20 = arrayList10;
                                                                    if(M7.N(xmlPullParser0, "Label")) {
                                                                        s33 = h2.r(xmlPullParser0, "Label");
                                                                        v32 = v41;
                                                                        v38 = v40;
                                                                        s30 = s35;
                                                                        goto label_798;
                                                                    }
                                                                    else if(xmlPullParser0.getEventType() == 2) {
                                                                        h2.l(xmlPullParser0);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        v32 = v41;
                                        s33 = s28;
                                        v38 = v40;
                                        s30 = s35;
                                    label_798:
                                        if(M7.L(xmlPullParser0, "AdaptationSet")) {
                                            break;
                                        }
                                        s28 = s33;
                                        arrayList10 = arrayList20;
                                        v31 = v10;
                                        arrayList15 = arrayList17;
                                        arrayList12 = arrayList21;
                                        v35 = v38;
                                        arrayList13 = arrayList22;
                                        arrayList14 = arrayList19;
                                        arrayList0 = arrayList6;
                                        arrayList11 = arrayList18;
                                        arrayList7 = arrayList4;
                                        arrayList8 = arrayList5;
                                        arrayList9 = arrayList16;
                                        v27 = v42;
                                        s22 = s36;
                                        v16 = v9;
                                        v33 = v37;
                                        f3 = f4;
                                        v18 = v24;
                                        s29 = s32;
                                    }
                                    if(v38 == 2) {
                                        M7.t(arrayList17, new Ma(2), this.b);
                                    }
                                    ArrayList arrayList36 = new ArrayList(arrayList17.size());
                                    int v81 = 0;
                                    while(v81 < arrayList17.size()) {
                                        g2 g21 = (g2)arrayList17.get(v81);
                                        ob ob1 = g21.a.a();
                                        if(s33 != null) {
                                            ob1.b = s33;
                                        }
                                        String s63 = g21.d == null ? s31 : g21.d;
                                        ArrayList arrayList37 = g21.e;
                                        arrayList37.addAll(arrayList16);
                                        if(arrayList37.isEmpty()) {
                                            arrayList38 = arrayList16;
                                            v85 = v24;
                                            s64 = s33;
                                        }
                                        else {
                                            arrayList38 = arrayList16;
                                            int v82 = arrayList37.size() - 1;
                                            while(v82 >= 0) {
                                                b c3$b0 = (b)arrayList37.get(v82);
                                                if(!c3$b0.d()) {
                                                    int v83 = 0;
                                                    while(v83 < arrayList37.size()) {
                                                        b c3$b1 = (b)arrayList37.get(v83);
                                                        if(!c3$b1.d() || c3$b0.d()) {
                                                        label_847:
                                                            v84 = v83;
                                                        }
                                                        else {
                                                            if(c3$b1.a(c3$b0.b)) {
                                                                arrayList37.remove(v82);
                                                                break;
                                                            }
                                                            else {
                                                                v84 = v83;
                                                                goto label_848;
                                                            }
                                                            goto label_847;
                                                        }
                                                    label_848:
                                                        v83 = v84 + 1;
                                                    }
                                                }
                                                --v82;
                                            }
                                            v85 = v24;
                                            s64 = s33;
                                            ob1.n = new c3(s63, arrayList37);
                                        }
                                        ArrayList arrayList39 = g21.f;
                                        arrayList39.addAll(arrayList20);
                                        u u1 = new u(ob1);
                                        String s65 = g21.b;
                                        k6 k60 = g21.c;
                                        if(k60 instanceof j6) {
                                            y50 = new y5(u1, s65, ((j6)k60), arrayList39);
                                        }
                                        else {
                                            if(!(k60 instanceof f6)) {
                                                throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
                                            }
                                            y50 = new x5(u1, s65, ((f6)k60), arrayList39);
                                        }
                                        arrayList36.add(y50);
                                        ++v81;
                                        s33 = s64;
                                        v24 = v85;
                                        arrayList16 = arrayList38;
                                    }
                                    arrayList4.add(new x0(v25, v38, arrayList36, arrayList18, arrayList22, arrayList19));
                                    v22 = v42;
                                    s6 = null;
                                label_879:
                                    s18 = s19;
                                }
                                else {
                                    ArrayList arrayList40 = arrayList2;
                                    arrayList5 = arrayList3;
                                    arrayList6 = arrayList0;
                                    v9 = v16;
                                    v10 = v4;
                                    if(M7.N(xmlPullParser0, "EventStream")) {
                                        String s66 = xmlPullParser0.getAttributeValue(null, "schemeIdUri");
                                        String s67 = s66 == null ? "" : s66;
                                        String s68 = xmlPullParser0.getAttributeValue(null, "value");
                                        String s69 = s68 == null ? "" : s68;
                                        String s70 = xmlPullParser0.getAttributeValue(null, "timescale");
                                        long v86 = s70 == null ? 1L : Long.parseLong(s70);
                                        ArrayList arrayList41 = new ArrayList();
                                        for(ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x200); true; byteArrayOutputStream0 = byteArrayOutputStream2) {
                                            xmlPullParser0.next();
                                            if(M7.N(xmlPullParser0, "Event")) {
                                                String s71 = xmlPullParser0.getAttributeValue(null, "id");
                                                long v87 = s71 == null ? 0L : Long.parseLong(s71);
                                                String s72 = xmlPullParser0.getAttributeValue(null, "duration");
                                                long v88 = s72 == null ? 0x8000000000000001L : Long.parseLong(s72);
                                                String s73 = xmlPullParser0.getAttributeValue(null, "presentationTime");
                                                long v89 = s73 == null ? 0L : Long.parseLong(s73);
                                                long v90 = L7.C(v88, 1000L, v86);
                                                long v91 = L7.C(v89, 1000000L, v86);
                                                v92 = v86;
                                                String s74 = xmlPullParser0.getAttributeValue(null, "messageData");
                                                if(s74 == null) {
                                                    s74 = null;
                                                }
                                                byteArrayOutputStream0.reset();
                                                XmlSerializer xmlSerializer0 = Xml.newSerializer();
                                                xmlSerializer0.setOutput(byteArrayOutputStream0, "UTF-8");
                                                xmlPullParser0.nextToken();
                                                while(!M7.L(xmlPullParser0, "Event")) {
                                                    switch(xmlPullParser0.getEventType()) {
                                                        case 0: {
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            xmlSerializer0.startDocument(null, Boolean.FALSE);
                                                            break;
                                                        }
                                                        case 1: {
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            xmlSerializer0.endDocument();
                                                            break;
                                                        }
                                                        case 2: {
                                                            arrayList42 = arrayList40;
                                                            xmlSerializer0.startTag(xmlPullParser0.getNamespace(), xmlPullParser0.getName());
                                                            for(int v93 = 0; v93 < xmlPullParser0.getAttributeCount(); ++v93) {
                                                                xmlSerializer0.attribute(xmlPullParser0.getAttributeNamespace(v93), xmlPullParser0.getAttributeName(v93), xmlPullParser0.getAttributeValue(v93));
                                                            }
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 3: {
                                                            arrayList42 = arrayList40;
                                                            xmlSerializer0.endTag(xmlPullParser0.getNamespace(), xmlPullParser0.getName());
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 4: {
                                                            xmlSerializer0.text(xmlPullParser0.getText());
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 5: {
                                                            xmlSerializer0.cdsect(xmlPullParser0.getText());
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 6: {
                                                            xmlSerializer0.entityRef(xmlPullParser0.getText());
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 7: {
                                                            xmlSerializer0.ignorableWhitespace(xmlPullParser0.getText());
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 8: {
                                                            xmlSerializer0.processingInstruction(xmlPullParser0.getText());
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 9: {
                                                            xmlSerializer0.comment(xmlPullParser0.getText());
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        case 10: {
                                                            xmlSerializer0.docdecl(xmlPullParser0.getText());
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                        default: {
                                                            arrayList42 = arrayList40;
                                                            byteArrayOutputStream1 = byteArrayOutputStream0;
                                                            break;
                                                        }
                                                    }
                                                    xmlPullParser0.nextToken();
                                                    byteArrayOutputStream0 = byteArrayOutputStream1;
                                                    arrayList40 = arrayList42;
                                                }
                                                arrayList4 = arrayList40;
                                                byteArrayOutputStream2 = byteArrayOutputStream0;
                                                xmlSerializer0.flush();
                                                byte[] arr_b = byteArrayOutputStream2.toByteArray();
                                                Long long0 = v91;
                                                if(s74 != null) {
                                                    arr_b = s74.getBytes(b9.c);
                                                }
                                                s75 = s67;
                                                s76 = s69;
                                                arrayList41.add(Pair.create(long0, new g9(s67, s69, v90, v87, arr_b)));
                                            }
                                            else {
                                                arrayList4 = arrayList40;
                                                byteArrayOutputStream2 = byteArrayOutputStream0;
                                                s75 = s67;
                                                s76 = s69;
                                                v92 = v86;
                                                h2.l(xmlPullParser0);
                                            }
                                            if(M7.L(xmlPullParser0, "EventStream")) {
                                                break;
                                            }
                                            s67 = s75;
                                            s69 = s76;
                                            v86 = v92;
                                            arrayList40 = arrayList4;
                                        }
                                        long[] arr_v = new long[arrayList41.size()];
                                        g9[] arr_g9 = new g9[arrayList41.size()];
                                        for(int v94 = 0; v94 < arrayList41.size(); ++v94) {
                                            Pair pair2 = (Pair)arrayList41.get(v94);
                                            arr_v[v94] = (long)(((Long)pair2.first));
                                            arr_g9[v94] = (g9)pair2.second;
                                        }
                                        arrayList5.add(new y3(s75, s76, arr_v, arr_g9));
                                        v22 = v17;
                                        v24 = v18;
                                        s6 = null;
                                    }
                                    else {
                                        s6 = null;
                                        arrayList4 = arrayList40;
                                        if(M7.N(xmlPullParser0, "SegmentBase")) {
                                            j60 = h2.h(xmlPullParser0, null);
                                            v22 = v17;
                                            v24 = v18;
                                        }
                                        else if(M7.N(xmlPullParser0, "SegmentList")) {
                                            long v95 = h2.d(xmlPullParser0, 0x8000000000000001L);
                                            v24 = v18;
                                            j60 = h2.f(xmlPullParser0, null, v17, v18, v23, v95, v10);
                                            v22 = v17;
                                            v20 = v95;
                                        }
                                        else {
                                            v22 = v17;
                                            v24 = v18;
                                            if(M7.N(xmlPullParser0, "SegmentTemplate")) {
                                                long v96 = h2.d(xmlPullParser0, 0x8000000000000001L);
                                                j60 = h2.g(xmlPullParser0, null, c5.e, v22, v24, v23, v96, v10);
                                                v20 = v96;
                                            }
                                            else if(M7.N(xmlPullParser0, "AssetIdentifier")) {
                                                h2.n(xmlPullParser0, "AssetIdentifier");
                                            }
                                            else {
                                                h2.l(xmlPullParser0);
                                            }
                                        }
                                    }
                                }
                            }
                        label_1019:
                            if(M7.L(xmlPullParser0, "Period")) {
                                Pair pair3 = Pair.create(new g4(s17, v15, arrayList4, arrayList5), v24);
                                g4 g40 = (g4)pair3.first;
                                if(g40.b == 0x8000000000000001L) {
                                    if(!z) {
                                        throw new H4("Unable to determine start of period " + arrayList6.size());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                    }
                                    v7 = v11;
                                    z2 = true;
                                    arrayList1 = arrayList6;
                                    break;
                                }
                                else {
                                    long v97 = (long)(((Long)pair3.second));
                                    arrayList1 = arrayList6;
                                    arrayList1.add(g40);
                                    v9 = v97 == 0x8000000000000001L ? 0x8000000000000001L : g40.b + v97;
                                }
                            label_1033:
                                v7 = v11;
                                break;
                            }
                            v4 = v10;
                            v16 = v9;
                            v19 = v23;
                            s4 = s5;
                            v17 = v22;
                            arrayList0 = arrayList6;
                            arrayList3 = arrayList5;
                            v18 = v24;
                            arrayList2 = arrayList4;
                        }
                    }
                }
            }
        label_1052:
            if(M7.L(xmlPullParser0, "MPD")) {
                if(v1 == 0x8000000000000001L) {
                    if(v9 != 0x8000000000000001L) {
                        v1 = v9;
                    }
                    else if(!z) {
                        throw new H4("Unable to determine duration of static manifest.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                }
                if(arrayList1.isEmpty()) {
                    throw new H4("No periods found.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                }
                return new p1(v, v1, v2, z, v3, v10, v5, v6, x40, c0, x0, uri0, arrayList1);
            }
            arrayList0 = arrayList1;
            v4 = v10;
            s1 = s6;
            v8 = v9;
            s4 = s5;
        }
    }

    public static Pair q(XmlPullParser xmlPullParser0) {
        String s2;
        byte[] arr_b;
        String s1;
        UUID uUID0;
        CharSequence charSequence0;
        b c3$b0 = null;
        String s = xmlPullParser0.getAttributeValue(null, "schemeIdUri");
        if(s == null) {
            uUID0 = null;
            s1 = null;
            arr_b = null;
            s2 = null;
        }
        else {
            switch(M7.j(s)) {
                case "urn:mpeg:dash:mp4protection:2011": {
                    String s3 = xmlPullParser0.getAttributeValue(null, "value");
                    int v = xmlPullParser0.getAttributeCount();
                    for(int v1 = 0; true; ++v1) {
                        charSequence0 = null;
                        if(v1 >= v) {
                            break;
                        }
                        String s4 = xmlPullParser0.getAttributeName(v1);
                        int v2 = s4.indexOf(58);
                        if(v2 != -1) {
                            s4 = s4.substring(v2 + 1);
                        }
                        if(s4.equals("default_KID")) {
                            charSequence0 = xmlPullParser0.getAttributeValue(v1);
                            break;
                        }
                    }
                    if(TextUtils.isEmpty(charSequence0) || "00000000-0000-0000-0000-000000000000".equals(charSequence0)) {
                        s1 = s3;
                        uUID0 = null;
                        arr_b = null;
                    }
                    else {
                        String[] arr_s = ((String)charSequence0).split("\\s+");
                        UUID[] arr_uUID = new UUID[arr_s.length];
                        for(int v3 = 0; v3 < arr_s.length; ++v3) {
                            arr_uUID[v3] = UUID.fromString(arr_s[v3]);
                        }
                        arr_b = Ja.J(b4.b, arr_uUID, null);
                        s1 = s3;
                        uUID0 = b4.b;
                    }
                    s2 = null;
                    break;
                }
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95": {
                    uUID0 = b4.e;
                    s1 = null;
                    arr_b = null;
                    s2 = null;
                    break;
                }
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed": {
                    uUID0 = b4.d;
                    s1 = null;
                    arr_b = null;
                    s2 = null;
                    break;
                }
                default: {
                    uUID0 = null;
                    s1 = null;
                    arr_b = null;
                    s2 = null;
                }
            }
        }
        do {
            xmlPullParser0.next();
            if(M7.N(xmlPullParser0, "ms:laurl")) {
                s2 = xmlPullParser0.getAttributeValue(null, "licenseUrl");
            }
            else {
                if(arr_b == null && xmlPullParser0.getEventType() == 2) {
                    String s5 = xmlPullParser0.getName();
                    int v4 = s5.indexOf(58);
                    if(v4 != -1) {
                        s5 = s5.substring(v4 + 1);
                    }
                    if(s5.equals("pssh") && xmlPullParser0.next() == 4) {
                        byte[] arr_b1 = Base64.decode(xmlPullParser0.getText(), 0);
                        o o0 = Ja.S(arr_b1);
                        UUID uUID1 = o0 == null ? null : o0.a;
                        if(uUID1 == null) {
                            Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                            uUID0 = null;
                            arr_b = null;
                        }
                        else {
                            arr_b = arr_b1;
                            uUID0 = uUID1;
                        }
                        continue;
                    }
                }
                if(arr_b == null) {
                    UUID uUID2 = b4.e;
                    if(uUID2.equals(uUID0) && M7.N(xmlPullParser0, "mspr:pro") && xmlPullParser0.next() == 4) {
                        arr_b = Ja.J(uUID2, null, Base64.decode(xmlPullParser0.getText(), 0));
                        continue;
                    }
                }
                h2.l(xmlPullParser0);
            }
        }
        while(!M7.L(xmlPullParser0, "ContentProtection"));
        if(uUID0 != null) {
            c3$b0 = new b(uUID0, s2, "video/mp4", arr_b);
        }
        return Pair.create(s1, c3$b0);
    }

    public static String r(XmlPullParser xmlPullParser0, String s) {
        String s1 = "";
        do {
            xmlPullParser0.next();
            if(xmlPullParser0.getEventType() == 4) {
                s1 = xmlPullParser0.getText();
            }
            else {
                h2.l(xmlPullParser0);
            }
        }
        while(!M7.L(xmlPullParser0, s));
        return s1;
    }

    public static int s(XmlPullParser xmlPullParser0) {
        String s = xmlPullParser0.getAttributeValue(null, "contentType");
        if(!TextUtils.isEmpty(s)) {
            if("audio".equals(s)) {
                return 1;
            }
            if("video".equals(s)) {
                return 2;
            }
            return "text".equals(s) ? 3 : -1;
        }
        return -1;
    }

    public static int t(ArrayList arrayList0) {
        int v1 = 0;
        for(int v = 0; v < arrayList0.size(); ++v) {
            if(M7.w("http://dashif.org/guidelines/trickmode", ((O2)arrayList0.get(v)).a)) {
                v1 = 0x4000;
            }
        }
        return v1;
    }
}

