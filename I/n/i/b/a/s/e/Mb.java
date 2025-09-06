package i.n.i.b.a.s.e;

import android.text.TextUtils;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.p0;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class mb {
    public static final ArrayList a;
    public static final Pattern b;

    static {
        mb.a = new ArrayList();
        mb.b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");
    }

    public static String a(int v) {
        switch(v) {
            case 0x20: {
                return "video/mp4v-es";
            }
            case 33: {
                return "video/avc";
            }
            case 35: {
                return "video/hevc";
            }
            case 0x60: 
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: {
                return "video/mpeg2";
            }
            case 0x40: 
            case 102: 
            case 103: 
            case 104: {
                return "audio/mp4a-latm";
            }
            case 106: {
                return "video/mpeg";
            }
            case 105: 
            case 107: {
                return "audio/mpeg";
            }
            case 0xA3: {
                return "video/wvc1";
            }
            case 0xA5: {
                return "audio/ac3";
            }
            case 0xA6: {
                return "audio/eac3";
            }
            case 170: 
            case 0xAB: {
                return "audio/vnd.dts.hd";
            }
            case 0xA9: 
            case 0xAC: {
                return "audio/vnd.dts";
            }
            case 0xAD: {
                return "audio/opus";
            }
            case 0xAE: {
                return "audio/ac4";
            }
            case 0xB1: {
                return "video/x-vnd.on2.vp9";
            }
            default: {
                return null;
            }
        }
    }

    public static String b(String s) {
        String s1 = null;
        if(s != null) {
            String s2 = M7.j(s.trim());
            if(s2.startsWith("avc1") || s2.startsWith("avc3")) {
                return "video/avc";
            }
            if(s2.startsWith("hev1") || s2.startsWith("hvc1")) {
                return "video/hevc";
            }
            if(s2.startsWith("dvav") || s2.startsWith("dva1") || s2.startsWith("dvhe") || s2.startsWith("dvh1")) {
                return "video/dolby-vision";
            }
            if(s2.startsWith("av01")) {
                return "video/av01";
            }
            if(s2.startsWith("vp9") || s2.startsWith("vp09")) {
                return "video/x-vnd.on2.vp9";
            }
            if(s2.startsWith("vp8") || s2.startsWith("vp08")) {
                return "video/x-vnd.on2.vp8";
            }
            if(s2.startsWith("mp4a")) {
                if(s2.startsWith("mp4a.")) {
                    p0 p00 = mb.e(s2);
                    if(p00 != null) {
                        s1 = mb.a(p00.a);
                    }
                }
                return s1 == null ? "audio/mp4a-latm" : s1;
            }
            if(s2.startsWith("ac-3") || s2.startsWith("dac3")) {
                return "audio/ac3";
            }
            if(s2.startsWith("ec-3") || s2.startsWith("dec3")) {
                return "audio/eac3";
            }
            if(s2.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if(s2.startsWith("ac-4") || s2.startsWith("dac4")) {
                return "audio/ac4";
            }
            if(s2.startsWith("dtsc") || s2.startsWith("dtse")) {
                return "audio/vnd.dts";
            }
            if(s2.startsWith("dtsh") || s2.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if(s2.startsWith("opus")) {
                return "audio/opus";
            }
            if(s2.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if(s2.startsWith("flac")) {
                return "audio/flac";
            }
            if(s2.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if(s2.startsWith("wvtt")) {
                return "text/vtt";
            }
            if(s2.contains("cea708")) {
                return "application/cea-708";
            }
            if(s2.contains("eia608") || s2.contains("cea608")) {
                return "application/cea-608";
            }
            ArrayList arrayList0 = mb.a;
            if(arrayList0.size() > 0) {
                throw o.g(0, arrayList0);
            }
        }
        return null;
    }

    public static String c(String s, String s1) {
        if(s != null && s1 != null) {
            String[] arr_s = L7.J(s);
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < arr_s.length; ++v) {
                String s2 = arr_s[v];
                if(s1.equals(mb.b(s2))) {
                    if(stringBuilder0.length() > 0) {
                        stringBuilder0.append(",");
                    }
                    stringBuilder0.append(s2);
                }
            }
            return stringBuilder0.length() <= 0 ? null : stringBuilder0.toString();
        }
        return null;
    }

    public static int d(String s, String s1) {
        s.getClass();
        switch(s) {
            case "audio/ac3": {
                return 5;
            }
            case "audio/ac4": {
                return 17;
            }
            case "audio/eac3": {
                return 6;
            }
            case "audio/eac3-joc": {
                return 18;
            }
            case "audio/mp4a-latm": {
                if(s1 == null) {
                    return 0;
                }
                p0 p00 = mb.e(s1);
                return p00 == null ? 0 : Ja.a(p00.b);
            }
            case "audio/mpeg": {
                return 9;
            }
            case "audio/true-hd": {
                return 14;
            }
            case "audio/vnd.dts": {
                return 7;
            }
            case "audio/vnd.dts.hd": {
                return 8;
            }
            default: {
                return 0;
            }
        }
    }

    public static p0 e(String s) {
        int v1;
        int v;
        Matcher matcher0 = mb.b.matcher(s);
        if(matcher0.matches()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            String s2 = matcher0.group(2);
            try {
                v = Integer.parseInt(s1, 16);
                if(s2 != null) {
                    v1 = Integer.parseInt(s2);
                    return new p0(v, v1);
                }
                return new p0(v, 0);
            }
            catch(NumberFormatException unused_ex) {
                return null;
            }
            return new p0(v, v1);
        }
        return null;
    }

    public static String f(String s) {
        if(s == null) {
            return null;
        }
        int v = s.indexOf(0x2F);
        return v == -1 ? null : s.substring(0, v);
    }

    public static int g(String s) {
        if(!TextUtils.isEmpty(s)) {
            if(mb.h(s)) {
                return 1;
            }
            if(mb.j(s)) {
                return 2;
            }
            if(mb.i(s)) {
                return 3;
            }
            if("application/id3".equals(s) || "application/x-emsg".equals(s) || "application/x-scte35".equals(s)) {
                return 5;
            }
            if("application/x-camera-motion".equals(s)) {
                return 6;
            }
            ArrayList arrayList0 = mb.a;
            if(arrayList0.size() > 0) {
                throw o.g(0, arrayList0);
            }
        }
        return -1;
    }

    public static boolean h(String s) {
        return "audio".equals(mb.f(s));
    }

    // 去混淆评级： 中等(120)
    public static boolean i(String s) {
        return "text".equals(mb.f(s)) || "application/cea-608".equals(s) || "application/cea-708".equals(s) || "application/x-mp4-cea-608".equals(s) || "application/x-subrip".equals(s) || "application/ttml+xml".equals(s) || "application/x-quicktime-tx3g".equals(s) || "application/x-mp4-vtt".equals(s) || "application/x-rawcc".equals(s) || "application/vobsub".equals(s) || "application/pgs".equals(s) || "application/dvbsubs".equals(s);
    }

    public static boolean j(String s) {
        return "video".equals(mb.f(s));
    }
}

