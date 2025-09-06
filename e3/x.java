package e3;

import E9.h;
import H0.e;
import I7.k;
import M6.B;
import M6.H;
import M6.r;
import M6.s;
import android.app.UiModeManager;
import android.content.Context;
import android.media.AudioFormat.Builder;
import android.media.AudioFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.media3.session.h0;
import b3.M;
import b3.N;
import b3.S;
import b3.f;
import b3.l;
import com.iloen.melon.utils.a;
import h7.u0;
import i.n.i.b.a.s.e.H0;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import k8.Y;

public abstract class x {
    public static final int a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final byte[] f;
    public static final long[] g;
    public static final Pattern h;
    public static final Pattern i;
    public static HashMap j;
    public static final String[] k;
    public static final String[] l;
    public static final int[] m;
    public static final int[] n;
    public static final int[] o;

    static {
        x.a = Build.VERSION.SDK_INT;
        x.b = Build.DEVICE;
        x.c = Build.MANUFACTURER;
        x.d = Build.MODEL;
        x.e = a.k(Build.VERSION.SDK_INT, ", ", a.o(Build.DEVICE, ", ", Build.MODEL, ", ", Build.MANUFACTURER));
        x.f = new byte[0];
        x.g = new long[0];
        x.h = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        x.i = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        x.k = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        x.l = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        x.m = new int[]{0, 0x4C11DB7, 0x9823B6E, 222504665, 0x130476DC, 398814059, 445009330, 507990021, 0x2608EDB8, 0x22C9F00F, 0x2F8AD6D6, 0x2B4BCB61, 890018660, 0x31CD86D3, 1015980042, 944750013, 0x4C11DB70, 0x48D0C6C7, 1167319070, 0x4152FDA9, 0x5F15ADAC, 0x5BD4B01B, 1452775106, 1381403509, 1780037320, 0x6ED82B7F, 0x639B0DA6, 0x675A1011, 2031960084, 0x7DDC5DA3, 1889500026, 0x745E66CD, 0x9823B6E0, -1662866601, 0x91A18D8E, 0x95609039, 0x8B27C03C, 0x8FE6DD8B, -2103051438, -2040207643, -1104454824, -1159051537, 0xB7A96036, 0xB3687D81, 0xAD2F2D84, -1444007885, -1532160278, 0xA06C0B5D, 0xD4326D90, 0xD0F37027, 0xDDB056FE, 0xD9714B49, -952755380, 0xC3F706FB, -827056094, 0xCA753D95, 0xF23A8028, 0xF6FB9D9F, 0xFBB8BB46, 0xFF79A6F1, 0xE13EF6F4, 0xE5FFEB43, -390279782, 0xEC7DD02D, 0x34867077, 0x30476DC0, 0x3D044B19, 969234094, 0x278206AB, 591600412, 0x2E003DC5, 0x2AC12072, 0x128E9DCF, 0x164F8078, 0x1B0CA6A1, 0x1FCDBB16, 0x18AEB13, 0x54BF6A4, 0x808D07D, 214552010, 2023205639, 2086057648, 0x71159069, 0x75D48DDE, 1804852699, 0x6F52C06C, 1645340341, 0x66D0FB02, 0x5E9F46BF, 0x5A5E5B08, 1461550545, 0x53DC6066, 1302016099, 1230646740, 0x44190B0D, 1087903418, 0xACA5C697, 0xA864DB20, 0xA527FDF9, 0xA1E6E04E, 0xBFA1B04B, 0xBB60ADFC, -1239184603, 0xB2E29692, -1968362705, -1905510760, 0x832F1041, 0x87EE0DF6, 0x99A95DF3, 0x9D684044, 0x902B669D, 0x94EA7B2A, 0xE0B41DE7, 0xE4750050, 0xE9362689, 0xEDF73B3E, -206542021, -143559028, 0xFA325055, 0xFEF34DE2, 0xC6BCF05F, -1031934488, 0xCF3ECB31, 0xCBFFD686, -709327229, -780559564, -600130067, 0xD8FBA05A, 0x690CE0EE, 0x6DCDFD59, 0x608EDB80, 0x644FC637, 2047383090, 0x7EC98B85, 0x738AAD5C, 2001449195, 0x4F040D56, 0x4BC510E1, 1183200824, 0x42472B8F, 0x5C007B8A, 1489069629, 0x558240E4, 0x51435D53, 0x251D3B9E, 568075817, 0x2C9F00F0, 0x285E1D47, 907627842, 0x32D850F5, 1067152940, 0x3B5A6B9B, 0x315D626, 0x7D4CB91, 177728840, 0xE56F0FF, 0x1011A0FA, 0x14D0BD4D, 429104020, 0x1D528623, 0xF12F560E, 0xF5EE4BB9, -122852000, -60002089, -500490030, -420856475, 0xEBA91BBC, 0xEF68060B, 0xD727BBB6, 0xD3E6A601, 0xDEA580D8, -630940305, -1004286614, 0xC0E2D0DD, 0xCDA1F604, 0xC960EBB3, -1119974018, 0xB9FF90C9, -1262701040, 0xB07DABA7, 0xAE3AFBA2, 0xAAFBE615, 0xA7B8C0CC, 0xA379DD7B, -1690935098, 0x9FF77D71, 0x92B45BA8, -1770699233, -2009983462, 0x8CF30BAD, -2119160460, 0x857130C3, 0x5D8A9099, 0x594B8D2E, 0x5408ABF7, 0x50C9B640, 1317987909, 0x4A4FFBF2, 0x470CDD2B, 0x43CDC09C, 2072149281, 0x7F436096, 0x7200464F, 0x76C15BF8, 0x68860BFD, 1816598090, 0x61043093, 1707420964, 295390185, 0x155A565E, 404320391, 0x1CD86D30, 0x29F3D35, 106832002, 0xB1D065B, 266083308, 0x3793A651, 861060070, 0x3E119D3F, 0x3AD08088, 0x2497D08D, 0x2056CD3A, 0x2D15EBE3, 0x29D4F654, -978770311, -1050133554, 0xCC2B1D17, 0xC8EA00A0, 0xD6AD50A5, 0xD26C4D12, 0xDF2F6BCB, -605129092, 0xE3A1CBC1, -413084042, 0xEA23F0AF, -287118056, 0xF0A5BD1D, 0xF464A0AA, -114850189, 0xFDE69BC4, 0x89B8FD09, 0x8D79E0BE, 0x803AC667, 0x84FBDBD0, 0x9ABC8BD5, -1635936670, -1824608069, 0x97FFAD0C, 0xAFB010B1, 0xAB710D06, -1506661409, 0xA2F33668, -1129027987, -1200260134, 0xB5365D03, 0xB1F740B4};
        x.n = new int[]{0, 0x1021, 0x2042, 0x3063, 0x4084, 0x50A5, 0x60C6, 0x70E7, 0x8108, 0x9129, 41290, 0xB16B, 0xC18C, 0xD1AD, 57806, 0xF1EF};
        x.o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 0x3F, 54, 49, 36, 35, 42, 45, 0x70, 0x77, 0x7E, 0x79, 108, 107, 98, 101, 72, 0x4F, 70, 65, 84, 83, 90, 93, 0xE0, 0xE7, 0xEE, 0xE9, 0xFC, 0xFB, 0xF2, 0xF5, 0xD8, 0xDF, 0xD6, 209, 0xC4, 0xC3, 202, 205, 0x90, 0x97, 0x9E, 0x99, 140, 0x8B, 130, 0x85, 0xA8, 0xAF, 0xA6, 0xA1, 180, 0xB3, 0xBA, 0xBD, 0xC7, 0xC0, 201, 206, 0xDB, 220, 0xD5, 210, 0xFF, 0xF8, 0xF1, 0xF6, 0xE3, 0xE4, 0xED, 0xEA, 0xB7, 0xB0, 0xB9, 190, 0xAB, 0xAC, 0xA5, 0xA2, 0x8F, 0x88, 0x81, 0x86, 0x93, 0x94, 0x9D, 0x9A, 39, 0x20, 41, 46, 59, 60, 53, 50, 0x1F, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 0x6F, 104, 97, 102, 0x73, 0x74, 0x7D, 0x7A, 0x89, 0x8E, 0x87, 0x80, 0x95, 0x92, 0x9B, 0x9C, 0xB1, 0xB6, 0xBF, 0xB8, 0xAD, 170, 0xA3, 0xA4, 0xF9, 0xFE, 0xF7, 0xF0, 0xE5, 0xE2, 0xEB, 0xEC, 0xC1, 0xC6, 0xCF, 200, 0xDD, 0xDA, 0xD3, 0xD4, 105, 110, 103, 0x60, 0x75, 0x72, 0x7B, 0x7C, 81, 86, 0x5F, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 0x2F, 40, 61, 58, 51, 52, 78, 73, 0x40, 71, 82, 85, 92, 91, 0x76, 0x71, 120, 0x7F, 106, 109, 100, 99, 62, 57, 0x30, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 0xAE, 0xA9, 0xA0, 0xA7, 0xB2, 0xB5, 0xBC, 0xBB, 150, 0x91, 0x98, 0x9F, 0x8A, 0x8D, 0x84, 0x83, 0xDE, 0xD9, 0xD0, 0xD7, 0xC2, 0xC5, 204, 203, 230, 0xE1, 0xE8, 0xEF, 0xFA, 0xFD, 0xF4, 0xF3};
    }

    public static int A(int v, int v1) {
        int v2 = 2;
        switch(v) {
            case 3: {
                v2 = 1;
                break;
            }
            case 2: 
            case 0x10000000: {
                break;
            }
            case 21: 
            case 0x50000000: {
                return 3 * v1;
            }
            case 4: 
            case 22: 
            case 0x60000000: {
                return 4 * v1;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return v2 * v1;
    }

    public static long B(long v, float f) {
        return f == 1.0f ? v : Math.round(((double)v) / ((double)f));
    }

    public static String C(String s) {
        try {
            Class class0 = Class.forName("android.os.SystemProperties");
            return (String)class0.getMethod("get", String.class).invoke(class0, s);
        }
        catch(Exception exception0) {
            b.q("Util", "Failed to read system property " + s, exception0);
            return null;
        }
    }

    public static String D(int v) {
        switch(v) {
            case -2: {
                return "none";
            }
            case -1: {
                return "unknown";
            }
            case 0: {
                return "default";
            }
            case 1: {
                return "audio";
            }
            case 2: {
                return "video";
            }
            case 3: {
                return "text";
            }
            case 4: {
                return "image";
            }
            case 5: {
                return "metadata";
            }
            case 6: {
                return "camera motion";
            }
            default: {
                return v < 10000 ? "?" : "custom (" + v + ")";
            }
        }
    }

    public static boolean E(S s0) {
        boolean z = false;
        if(s0 == null) {
            return false;
        }
        int v = s0.getPlaybackState();
        if(v == 1 && s0.Y(2)) {
            s0.prepare();
            z = true;
        }
        else if(v == 4 && s0.Y(4)) {
            s0.seekToDefaultPosition();
            z = true;
        }
        if(s0.Y(1)) {
            s0.play();
            return true;
        }
        return z;
    }

    public static int F(Uri uri0) {
        int v1;
        String s = uri0.getScheme();
        if(s != null && u0.v("rtsp", s)) {
            return 3;
        }
        String s1 = uri0.getLastPathSegment();
        if(s1 != null) {
            int v = s1.lastIndexOf(46);
            if(v >= 0) {
                String s2 = u0.U(s1.substring(v + 1));
                s2.getClass();
                switch(s2) {
                    case "ism": {
                        v1 = 1;
                        break;
                    }
                    case "isml": {
                        v1 = 1;
                        break;
                    }
                    case "m3u8": {
                        v1 = 2;
                        break;
                    }
                    case "mpd": {
                        v1 = 0;
                        break;
                    }
                    default: {
                        v1 = 4;
                    }
                }
                if(v1 != 4) {
                    return v1;
                }
            }
            String s3 = uri0.getPath();
            s3.getClass();
            Matcher matcher0 = x.i.matcher(s3);
            if(matcher0.matches()) {
                String s4 = matcher0.group(2);
                if(s4 != null) {
                    if(s4.contains("format=mpd-time-csf")) {
                        return 0;
                    }
                    return s4.contains("format=m3u8-aapl") ? 2 : 1;
                }
                return 1;
            }
        }
        return 4;
    }

    public static boolean G(p p0, p p1, Inflater inflater0) {
        if(p0.a() <= 0) {
            return false;
        }
        if(p1.a.length < p0.a()) {
            p1.b(p0.a() * 2);
        }
        if(inflater0 == null) {
            inflater0 = new Inflater();
        }
        inflater0.setInput(p0.a, p0.b, p0.a());
        int v = 0;
        try {
            while(true) {
                v += inflater0.inflate(p1.a, v, p1.a.length - v);
                if(inflater0.finished()) {
                    break;
                }
                if(inflater0.needsDictionary() || inflater0.needsInput()) {
                    return false;
                }
                byte[] arr_b = p1.a;
                if(v == arr_b.length) {
                    p1.b(arr_b.length * 2);
                }
            }
            p1.F(v);
            return true;
        }
        catch(DataFormatException unused_ex) {
            return false;
        }
        finally {
            inflater0.reset();
        }
    }

    public static boolean H(int v) {
        switch(v) {
            case 2: 
            case 3: 
            case 4: 
            case 21: 
            case 22: 
            case 0x10000000: 
            case 0x50000000: 
            case 0x60000000: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean I(Context context0) {
        return false;
    }

    public static boolean J(int v) {
        return v == 10 || v == 13;
    }

    public static boolean K(Context context0) {
        UiModeManager uiModeManager0 = (UiModeManager)context0.getApplicationContext().getSystemService("uimode");
        return uiModeManager0 != null && uiModeManager0.getCurrentModeType() == 4;
    }

    public static void L(int v, int v1, int v2, ArrayList arrayList0) {
        ArrayDeque arrayDeque0 = new ArrayDeque();
        for(int v3 = v1 - v - 1; v3 >= 0; --v3) {
            arrayDeque0.addFirst(arrayList0.remove(v + v3));
        }
        arrayList0.addAll(Math.min(v2, arrayList0.size()), arrayDeque0);
    }

    public static long M(long v) {
        return v == 0x8000000000000001L || v == 0x8000000000000000L ? v : v * 1000L;
    }

    public static String N(String s) {
        if(s == null) {
            return null;
        }
        String s1 = s.replace('_', '-');
        if(!s1.isEmpty() && !s1.equals("und")) {
            s = s1;
        }
        String s2 = u0.U(s);
        String s3 = s2.split("-", 2)[0];
        if(x.j == null) {
            String[] arr_s = Locale.getISOLanguages();
            String[] arr_s1 = x.k;
            HashMap hashMap0 = new HashMap(arr_s.length + arr_s1.length);
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                String s4 = arr_s[v1];
                try {
                    String s5 = new Locale(s4).getISO3Language();
                    if(!TextUtils.isEmpty(s5)) {
                        hashMap0.put(s5, s4);
                    }
                }
                catch(MissingResourceException unused_ex) {
                }
            }
            for(int v2 = 0; v2 < arr_s1.length; v2 += 2) {
                hashMap0.put(arr_s1[v2], arr_s1[v2 + 1]);
            }
            x.j = hashMap0;
        }
        String s6 = (String)x.j.get(s3);
        if(s6 != null) {
            StringBuilder stringBuilder0 = Y.p(s6);
            stringBuilder0.append(s2.substring(s3.length()));
            s2 = stringBuilder0.toString();
            s3 = s6;
        }
        if("no".equals(s3) || "i".equals(s3) || "zh".equals(s3)) {
            for(int v = 0; true; v += 2) {
                String[] arr_s2 = x.l;
                if(v >= arr_s2.length) {
                    break;
                }
                if(s2.startsWith(arr_s2[v])) {
                    return arr_s2[v + 1] + s2.substring(arr_s2[v].length());
                }
            }
        }
        return s2;
    }

    public static Object[] O(Object[] arr_object, int v) {
        b.c(v <= arr_object.length);
        return Arrays.copyOf(arr_object, v);
    }

    public static void P(Handler handler0, Runnable runnable0) {
        if(!handler0.getLooper().getThread().isAlive()) {
            return;
        }
        if(handler0.getLooper() == Looper.myLooper()) {
            runnable0.run();
            return;
        }
        handler0.post(runnable0);
    }

    public static void Q(ArrayList arrayList0, int v, int v1) {
        if(v < 0 || v1 > arrayList0.size() || v > v1) {
            throw new IllegalArgumentException();
        }
        if(v != v1) {
            arrayList0.subList(v, v1).clear();
        }
    }

    public static long R(int v, long v1) {
        return x.T(v1, 1000000L, v, RoundingMode.DOWN);
    }

    public static void S(long[] arr_v, long v) {
        RoundingMode roundingMode0 = RoundingMode.DOWN;
        int v1 = Long.compare(v, 1000000L);
        int v2 = 0;
        if(v1 >= 0 && v % 1000000L == 0L) {
            long v3 = e.C(v, 1000000L, RoundingMode.UNNECESSARY);
            while(v2 < arr_v.length) {
                arr_v[v2] = e.C(arr_v[v2], v3, roundingMode0);
                ++v2;
            }
            return;
        }
        if(v1 < 0 && 1000000L % v == 0L) {
            long v4 = e.C(1000000L, v, RoundingMode.UNNECESSARY);
            while(v2 < arr_v.length) {
                arr_v[v2] = e.U(arr_v[v2], v4);
                ++v2;
            }
            return;
        }
        for(int v5 = 0; v5 < arr_v.length; ++v5) {
            long v6 = arr_v[v5];
            if(v6 != 0L) {
                int v7 = Long.compare(v, v6);
                if(v7 >= 0 && v % v6 == 0L) {
                    arr_v[v5] = e.C(1000000L, e.C(v, v6, RoundingMode.UNNECESSARY), roundingMode0);
                }
                else if(v7 >= 0 || v6 % v != 0L) {
                    arr_v[v5] = x.U(v6, 1000000L, v, roundingMode0);
                }
                else {
                    arr_v[v5] = e.U(1000000L, e.C(v6, v, RoundingMode.UNNECESSARY));
                }
            }
        }
    }

    public static long T(long v, long v1, long v2, RoundingMode roundingMode0) {
        if(v != 0L && v1 != 0L) {
            int v3 = Long.compare(v2, v1);
            if(v3 >= 0 && v2 % v1 == 0L) {
                return e.C(v, e.C(v2, v1, RoundingMode.UNNECESSARY), roundingMode0);
            }
            if(v3 < 0 && v1 % v2 == 0L) {
                return e.U(v, e.C(v1, v2, RoundingMode.UNNECESSARY));
            }
            int v4 = Long.compare(v2, v);
            if(v4 >= 0 && v2 % v == 0L) {
                return e.C(v1, e.C(v2, v, RoundingMode.UNNECESSARY), roundingMode0);
            }
            return v4 >= 0 || v % v2 != 0L ? x.U(v, v1, v2, roundingMode0) : e.U(v1, e.C(v, v2, RoundingMode.UNNECESSARY));
        }
        return 0L;
    }

    public static long U(long v, long v1, long v2, RoundingMode roundingMode0) {
        double f1;
        long v3 = e.U(v, v1);
        if(Long.compare(v3, 0x7FFFFFFFFFFFFFFFL) != 0 && v3 != 0x8000000000000000L) {
            return e.C(v3, v2, roundingMode0);
        }
        long v4 = e.H(Math.abs(v1), Math.abs(v2));
        RoundingMode roundingMode1 = RoundingMode.UNNECESSARY;
        long v5 = e.C(v1, v4, roundingMode1);
        long v6 = e.C(v2, v4, roundingMode1);
        long v7 = e.H(Math.abs(v), Math.abs(v6));
        long v8 = e.C(v, v7, roundingMode1);
        long v9 = e.C(v6, v7, roundingMode1);
        long v10 = e.U(v8, v5);
        if(v10 != 0x7FFFFFFFFFFFFFFFL && v10 != 0x8000000000000000L) {
            return e.C(v10, v9, roundingMode0);
        }
        double f = ((double)v8) * (((double)v5) / ((double)v9));
        if(f > 9223372036854776000.0) {
            return 0x7FFFFFFFFFFFFFFFL;
        }
        if(f < -9223372036854776000.0) {
            return 0x8000000000000000L;
        }
        if(!h.P(f)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        int v11 = 1;
        switch(K6.a.a[roundingMode0.ordinal()]) {
            case 1: {
                if(!K6.b.a(f)) {
                    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                }
                f1 = f;
                break;
            }
            case 2: {
                f1 = f >= 0.0 || K6.b.a(f) ? f : ((double)(((long)f) - 1L));
                break;
            }
            case 3: {
                f1 = f <= 0.0 || K6.b.a(f) ? f : ((double)(((long)f) + 1L));
                break;
            }
            case 4: {
                f1 = f;
                break;
            }
            case 5: {
                f1 = K6.b.a(f) ? f : ((double)(((long)f) + ((long)(f > 0.0 ? 1 : -1))));
                break;
            }
            case 6: {
                f1 = Math.rint(f);
                break;
            }
            case 7: {
                f1 = Math.rint(f);
                if(Math.abs(f - f1) == 0.5) {
                    f1 = Math.copySign(0.5, f) + f;
                }
                break;
            }
            case 8: {
                f1 = Math.rint(f);
                if(Math.abs(f - f1) == 0.5) {
                    f1 = f;
                }
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        int v12 = Double.compare(-9223372036854776000.0 - f1, 1.0) >= 0 ? 0 : 1;
        if(f1 >= 9223372036854776000.0) {
            v11 = 0;
        }
        if((v12 & v11) == 0) {
            throw new ArithmeticException("rounded value is out of range for input " + f + " and rounding mode " + roundingMode0);
        }
        return (long)f1;
    }

    public static boolean V(S s0, boolean z) {
        if(s0 != null && s0.getPlayWhenReady()) {
            switch(s0.getPlaybackState()) {
                case 1: 
                case 4: {
                    break;
                }
                default: {
                    return z && s0.getPlaybackSuppressionReason() != 0;
                }
            }
        }
        return true;
    }

    // 去混淆评级： 低(20)
    public static String[] W(String s) {
        return TextUtils.isEmpty(s) ? new String[0] : s.trim().split("(\\s*,\\s*)", -1);
    }

    public static String X(byte[] arr_b) {
        StringBuilder stringBuilder0 = new StringBuilder(arr_b.length * 2);
        for(int v = 0; v < arr_b.length; ++v) {
            stringBuilder0.append(Character.forDigit(arr_b[v] >> 4 & 15, 16));
            stringBuilder0.append(Character.forDigit(arr_b[v] & 15, 16));
        }
        return stringBuilder0.toString();
    }

    public static H Y(B b0, r r0) {
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.addListener(new h0(h0, b0, 1), s.a);
        b0.addListener(new k(b0, h0, r0, 25), s.a);
        return h0;
    }

    public static long Z(long v) {
        return v == 0x8000000000000001L || v == 0x8000000000000000L ? v : v / 1000L;
    }

    public static int a(long[] arr_v, long v, boolean z) {
        int v1 = Arrays.binarySearch(arr_v, v);
        if(v1 < 0) {
            return ~v1;
        }
        while(v1 + 1 < arr_v.length && arr_v[v1 + 1] == v) {
            ++v1;
        }
        return z ? v1 : v1 + 1;
    }

    public static int b(K0.b b0, long v) {
        int v1 = b0.b - 1;
        int v2 = 0;
        while(v2 <= v1) {
            int v3 = v2 + v1 >>> 1;
            if(b0.f(v3) < v) {
                v2 = v3 + 1;
            }
            else {
                v1 = v3 - 1;
            }
        }
        if(v1 + 1 < b0.b && b0.f(v1 + 1) == v) {
            return v1 + 1;
        }
        return v1 == -1 ? 0 : v1;
    }

    public static int c(List list0, Long long0, boolean z) {
        int v = Collections.binarySearch(list0, long0);
        if(v < 0) {
            int v1 = -(v + 2);
            return z ? Math.max(0, v1) : v1;
        }
        while(v - 1 >= 0 && ((Comparable)list0.get(v - 1)).compareTo(long0) == 0) {
            --v;
        }
        return z ? Math.max(0, v) : v;
    }

    public static int d(int[] arr_v, int v, boolean z, boolean z1) {
        int v2;
        int v1 = Arrays.binarySearch(arr_v, v);
        if(v1 < 0) {
            v2 = -(v1 + 2);
            return z1 ? Math.max(0, v2) : v2;
        }
        while(v1 - 1 >= 0 && arr_v[v1 - 1] == v) {
            --v1;
        }
        v2 = z ? v1 : v1 - 1;
        return z1 ? Math.max(0, v2) : v2;
    }

    public static int e(long[] arr_v, long v, boolean z) {
        int v1 = Arrays.binarySearch(arr_v, v);
        if(v1 < 0) {
            int v2 = -(v1 + 2);
            return z ? Math.max(0, v2) : v2;
        }
        while(v1 - 1 >= 0 && arr_v[v1 - 1] == v) {
            --v1;
        }
        return z ? Math.max(0, v1) : v1;
    }

    public static int f(int v, int v1) [...] // Inlined contents

    public static float g(float f, float f1, float f2) {
        return Math.max(f1, Math.min(f, f2));
    }

    public static int h(int v, int v1, int v2) {
        return Math.max(v1, Math.min(v, v2));
    }

    public static long i(long v, long v1, long v2) {
        return Math.max(v1, Math.min(v, v2));
    }

    public static boolean j(Object[] arr_object, Object object0) {
        for(int v = 0; v < arr_object.length; ++v) {
            if(Objects.equals(arr_object[v], object0)) {
                return true;
            }
        }
        return false;
    }

    public static int k(byte[] arr_b, int v, int v1, int v2) {
        while(v < v1) {
            v2 = x.m[(v2 >>> 24 ^ arr_b[v] & 0xFF) & 0xFF] ^ v2 << 8;
            ++v;
        }
        return v2;
    }

    public static Handler l(H0 h00) {
        Looper looper0 = Looper.myLooper();
        b.k(looper0);
        return new Handler(looper0, h00);
    }

    public static String m(byte[] arr_b) {
        return new String(arr_b, StandardCharsets.UTF_8);
    }

    public static int n(int v) {
        if(v != 20) {
            switch(v) {
                case 2: 
                case 3: {
                    return 3;
                }
                case 4: 
                case 5: 
                case 6: {
                    return 21;
                }
                case 7: 
                case 8: {
                    return 23;
                }
                case 14: {
                    return 25;
                }
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 15: 
                case 16: 
                case 17: 
                case 18: {
                    return 28;
                }
                case 22: {
                    return 0x1F;
                }
                case 30: {
                    return 34;
                }
                default: {
                    return 0x7FFFFFFF;
                }
            }
        }
        return 30;
    }

    public static AudioFormat o(int v, int v1, int v2) {
        return new AudioFormat.Builder().setSampleRate(v).setChannelMask(v1).setEncoding(v2).build();
    }

    public static int p(int v) {
        switch(v) {
            case 1: {
                return 4;
            }
            case 2: {
                return 12;
            }
            case 3: {
                return 28;
            }
            case 4: {
                return 204;
            }
            case 5: {
                return 220;
            }
            case 6: {
                return 0xFC;
            }
            case 7: {
                return 0x4FC;
            }
            case 8: {
                return 0x18FC;
            }
            case 10: {
                return 0xB40FC;
            }
            case 12: {
                return 0xB58FC;
            }
            case 24: {
                return 0x3FFFFFC;
            }
            default: {
                return 0;
            }
        }
    }

    public static N q(f f0, N n0) {
        boolean z = f0.isPlayingAd();
        boolean z1 = f0.a0();
        boolean z2 = f0.f0();
        boolean z3 = f0.e0();
        boolean z4 = f0.c0();
        boolean z5 = f0.Z();
        boolean z6 = f0.getCurrentTimeline().p();
        M m0 = new M();  // 初始化器: Ljava/lang/Object;-><init>()V
        m0.a = new l(0);
        l l0 = (l)m0.a;
        l0.d(n0.a);
        m0.a(4, !z);
        boolean z7 = false;
        m0.a(5, z1 && !z);
        m0.a(6, z2 && !z);
        m0.a(7, !z6 && (z2 || !z4 || z1) && !z);
        m0.a(8, z3 && !z);
        m0.a(9, !z6 && (z3 || z4 && z5) && !z);
        m0.a(10, !z);
        m0.a(11, z1 && !z);
        if(z1 && !z) {
            z7 = true;
        }
        m0.a(12, z7);
        return new N(l0.f());
    }

    public static int r(int v, String s) {
        String[] arr_s = x.W(s);
        int v2 = 0;
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            if(v == b3.H.g(b3.H.c(arr_s[v1]))) {
                ++v2;
            }
        }
        return v2;
    }

    public static String s(String s, int v) {
        String[] arr_s = x.W(s);
        if(arr_s.length != 0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                String s1 = arr_s[v1];
                if(v == b3.H.g(b3.H.c(s1))) {
                    if(stringBuilder0.length() > 0) {
                        stringBuilder0.append(",");
                    }
                    stringBuilder0.append(s1);
                }
            }
            return stringBuilder0.length() <= 0 ? null : stringBuilder0.toString();
        }
        return null;
    }

    public static String t(Context context0) {
        if(context0 != null) {
            TelephonyManager telephonyManager0 = (TelephonyManager)context0.getSystemService("phone");
            if(telephonyManager0 != null) {
                String s = telephonyManager0.getNetworkCountryIso();
                return TextUtils.isEmpty(s) ? u0.V(Locale.getDefault().getCountry()) : u0.V(s);
            }
        }
        return u0.V(Locale.getDefault().getCountry());
    }

    public static Looper u() {
        Looper looper0 = Looper.myLooper();
        return looper0 == null ? Looper.getMainLooper() : looper0;
    }

    public static int v(int v) {
        switch(v) {
            case 8: 
            case 15: {
                return 6003;
            }
            case 2: 
            case 4: 
            case 7: 
            case 16: 
            case 18: {
                return 6005;
            }
            case 10: 
            case 17: 
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                return 6004;
            }
            default: {
                return v == 24 || v == 25 || v == 26 || v == 27 || v == 28 ? 6002 : 6006;
            }
        }
    }

    public static int w(String s) {
        int v = 0;
        if(s == null) {
            return 0;
        }
        String[] arr_s = s.split("_", -1);
        if(arr_s.length < 2) {
            return 0;
        }
        String s1 = arr_s[arr_s.length - 1];
        boolean z = arr_s.length >= 3 && "neg".equals(arr_s[arr_s.length - 2]);
        try {
            s1.getClass();
            v = Integer.parseInt(s1);
            if(z) {
                return -v;
            }
        }
        catch(NumberFormatException unused_ex) {
        }
        return v;
    }

    public static long x(long v, float f) {
        return f == 1.0f ? v : Math.round(((double)v) * ((double)f));
    }

    public static long y(long v) {
        return v == 0x8000000000000001L ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + v;
    }

    public static int z(int v) {
        switch(v) {
            case 8: {
                return 3;
            }
            case 16: {
                return 2;
            }
            case 24: {
                return 21;
            }
            case 0x20: {
                return 22;
            }
            default: {
                return 0;
            }
        }
    }
}

