package com.google.android.exoplayer2.util;

import U4.x;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display.Mode;
import android.view.Display;
import android.view.WindowManager;
import b3.Z;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class Util {
    private static final int[] CRC32_BYTES_MSBF = null;
    private static final int[] CRC8_BYTES_MSBF = null;
    public static final String DEVICE = null;
    public static final String DEVICE_DEBUG_INFO = null;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final Pattern ESCAPED_CHARACTER_PATTERN = null;
    public static final String MANUFACTURER = null;
    public static final String MODEL = null;
    public static final int SDK_INT = 0;
    private static final String TAG = "Util";
    private static final Pattern XS_DATE_TIME_PATTERN;
    private static final Pattern XS_DURATION_PATTERN;
    private static final String[] additionalIsoLanguageReplacements;
    private static final String[] isoGrandfatheredTagReplacements;
    private static HashMap languageTagReplacementMap;

    static {
        int v = Build.VERSION.SDK_INT;
        Util.SDK_INT = v;
        String s = Build.DEVICE;
        Util.DEVICE = s;
        String s1 = Build.MANUFACTURER;
        Util.MANUFACTURER = s1;
        String s2 = Build.MODEL;
        Util.MODEL = s2;
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(17, s), s2), s1), s, ", ", s2, ", ");
        stringBuilder0.append(s1);
        stringBuilder0.append(", ");
        stringBuilder0.append(v);
        Util.DEVICE_DEBUG_INFO = stringBuilder0.toString();
        Util.EMPTY_BYTE_ARRAY = new byte[0];
        Util.XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Util.XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Util.ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
        Util.additionalIsoLanguageReplacements = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        Util.isoGrandfatheredTagReplacements = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        Util.CRC32_BYTES_MSBF = new int[]{0, 0x4C11DB7, 0x9823B6E, 222504665, 0x130476DC, 398814059, 445009330, 507990021, 0x2608EDB8, 0x22C9F00F, 0x2F8AD6D6, 0x2B4BCB61, 890018660, 0x31CD86D3, 1015980042, 944750013, 0x4C11DB70, 0x48D0C6C7, 1167319070, 0x4152FDA9, 0x5F15ADAC, 0x5BD4B01B, 1452775106, 1381403509, 1780037320, 0x6ED82B7F, 0x639B0DA6, 0x675A1011, 2031960084, 0x7DDC5DA3, 1889500026, 0x745E66CD, 0x9823B6E0, -1662866601, 0x91A18D8E, 0x95609039, 0x8B27C03C, 0x8FE6DD8B, -2103051438, -2040207643, -1104454824, -1159051537, 0xB7A96036, 0xB3687D81, 0xAD2F2D84, -1444007885, -1532160278, 0xA06C0B5D, 0xD4326D90, 0xD0F37027, 0xDDB056FE, 0xD9714B49, -952755380, 0xC3F706FB, -827056094, 0xCA753D95, 0xF23A8028, 0xF6FB9D9F, 0xFBB8BB46, 0xFF79A6F1, 0xE13EF6F4, 0xE5FFEB43, -390279782, 0xEC7DD02D, 0x34867077, 0x30476DC0, 0x3D044B19, 969234094, 0x278206AB, 591600412, 0x2E003DC5, 0x2AC12072, 0x128E9DCF, 0x164F8078, 0x1B0CA6A1, 0x1FCDBB16, 0x18AEB13, 0x54BF6A4, 0x808D07D, 214552010, 2023205639, 2086057648, 0x71159069, 0x75D48DDE, 1804852699, 0x6F52C06C, 1645340341, 0x66D0FB02, 0x5E9F46BF, 0x5A5E5B08, 1461550545, 0x53DC6066, 1302016099, 1230646740, 0x44190B0D, 1087903418, 0xACA5C697, 0xA864DB20, 0xA527FDF9, 0xA1E6E04E, 0xBFA1B04B, 0xBB60ADFC, -1239184603, 0xB2E29692, -1968362705, -1905510760, 0x832F1041, 0x87EE0DF6, 0x99A95DF3, 0x9D684044, 0x902B669D, 0x94EA7B2A, 0xE0B41DE7, 0xE4750050, 0xE9362689, 0xEDF73B3E, -206542021, -143559028, 0xFA325055, 0xFEF34DE2, 0xC6BCF05F, -1031934488, 0xCF3ECB31, 0xCBFFD686, -709327229, -780559564, -600130067, 0xD8FBA05A, 0x690CE0EE, 0x6DCDFD59, 0x608EDB80, 0x644FC637, 2047383090, 0x7EC98B85, 0x738AAD5C, 2001449195, 0x4F040D56, 0x4BC510E1, 1183200824, 0x42472B8F, 0x5C007B8A, 1489069629, 0x558240E4, 0x51435D53, 0x251D3B9E, 568075817, 0x2C9F00F0, 0x285E1D47, 907627842, 0x32D850F5, 1067152940, 0x3B5A6B9B, 0x315D626, 0x7D4CB91, 177728840, 0xE56F0FF, 0x1011A0FA, 0x14D0BD4D, 429104020, 0x1D528623, 0xF12F560E, 0xF5EE4BB9, -122852000, -60002089, -500490030, -420856475, 0xEBA91BBC, 0xEF68060B, 0xD727BBB6, 0xD3E6A601, 0xDEA580D8, -630940305, -1004286614, 0xC0E2D0DD, 0xCDA1F604, 0xC960EBB3, -1119974018, 0xB9FF90C9, -1262701040, 0xB07DABA7, 0xAE3AFBA2, 0xAAFBE615, 0xA7B8C0CC, 0xA379DD7B, -1690935098, 0x9FF77D71, 0x92B45BA8, -1770699233, -2009983462, 0x8CF30BAD, -2119160460, 0x857130C3, 0x5D8A9099, 0x594B8D2E, 0x5408ABF7, 0x50C9B640, 1317987909, 0x4A4FFBF2, 0x470CDD2B, 0x43CDC09C, 2072149281, 0x7F436096, 0x7200464F, 0x76C15BF8, 0x68860BFD, 1816598090, 0x61043093, 1707420964, 295390185, 0x155A565E, 404320391, 0x1CD86D30, 0x29F3D35, 106832002, 0xB1D065B, 266083308, 0x3793A651, 861060070, 0x3E119D3F, 0x3AD08088, 0x2497D08D, 0x2056CD3A, 0x2D15EBE3, 0x29D4F654, -978770311, -1050133554, 0xCC2B1D17, 0xC8EA00A0, 0xD6AD50A5, 0xD26C4D12, 0xDF2F6BCB, -605129092, 0xE3A1CBC1, -413084042, 0xEA23F0AF, -287118056, 0xF0A5BD1D, 0xF464A0AA, -114850189, 0xFDE69BC4, 0x89B8FD09, 0x8D79E0BE, 0x803AC667, 0x84FBDBD0, 0x9ABC8BD5, -1635936670, -1824608069, 0x97FFAD0C, 0xAFB010B1, 0xAB710D06, -1506661409, 0xA2F33668, -1129027987, -1200260134, 0xB5365D03, 0xB1F740B4};
        Util.CRC8_BYTES_MSBF = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 0x3F, 54, 49, 36, 35, 42, 45, 0x70, 0x77, 0x7E, 0x79, 108, 107, 98, 101, 72, 0x4F, 70, 65, 84, 83, 90, 93, 0xE0, 0xE7, 0xEE, 0xE9, 0xFC, 0xFB, 0xF2, 0xF5, 0xD8, 0xDF, 0xD6, 209, 0xC4, 0xC3, 202, 205, 0x90, 0x97, 0x9E, 0x99, 140, 0x8B, 130, 0x85, 0xA8, 0xAF, 0xA6, 0xA1, 180, 0xB3, 0xBA, 0xBD, 0xC7, 0xC0, 201, 206, 0xDB, 220, 0xD5, 210, 0xFF, 0xF8, 0xF1, 0xF6, 0xE3, 0xE4, 0xED, 0xEA, 0xB7, 0xB0, 0xB9, 190, 0xAB, 0xAC, 0xA5, 0xA2, 0x8F, 0x88, 0x81, 0x86, 0x93, 0x94, 0x9D, 0x9A, 39, 0x20, 41, 46, 59, 60, 53, 50, 0x1F, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 0x6F, 104, 97, 102, 0x73, 0x74, 0x7D, 0x7A, 0x89, 0x8E, 0x87, 0x80, 0x95, 0x92, 0x9B, 0x9C, 0xB1, 0xB6, 0xBF, 0xB8, 0xAD, 170, 0xA3, 0xA4, 0xF9, 0xFE, 0xF7, 0xF0, 0xE5, 0xE2, 0xEB, 0xEC, 0xC1, 0xC6, 0xCF, 200, 0xDD, 0xDA, 0xD3, 0xD4, 105, 110, 103, 0x60, 0x75, 0x72, 0x7B, 0x7C, 81, 86, 0x5F, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 0x2F, 40, 61, 58, 51, 52, 78, 73, 0x40, 71, 82, 85, 92, 91, 0x76, 0x71, 120, 0x7F, 106, 109, 100, 99, 62, 57, 0x30, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 0xAE, 0xA9, 0xA0, 0xA7, 0xB2, 0xB5, 0xBC, 0xBB, 150, 0x91, 0x98, 0x9F, 0x8A, 0x8D, 0x84, 0x83, 0xDE, 0xD9, 0xD0, 0xD7, 0xC2, 0xC5, 204, 203, 230, 0xE1, 0xE8, 0xEF, 0xFA, 0xFD, 0xF4, 0xF3};
    }

    public static void a(List list0) {
    }

    public static long addWithOverflowDefault(long v, long v1, long v2) {
        long v3 = v + v1;
        return ((v ^ v3) & (v1 ^ v3)) >= 0L ? v3 : v2;
    }

    public static boolean areEqual(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }

    public static void b(Metadata metadata0) {
    }

    public static int binarySearchCeil(List list0, Comparable comparable0, boolean z, boolean z1) {
        int v1;
        int v = Collections.binarySearch(list0, comparable0);
        if(v < 0) {
            v1 = ~v;
            return z1 ? Math.min(list0.size() - 1, v1) : v1;
        }
        int v2 = list0.size();
        while(v + 1 < v2 && ((Comparable)list0.get(v + 1)).compareTo(comparable0) == 0) {
            ++v;
        }
        v1 = z ? v : v + 1;
        return z1 ? Math.min(list0.size() - 1, v1) : v1;
    }

    public static int binarySearchCeil(int[] arr_v, int v, boolean z, boolean z1) {
        int v2;
        int v1 = Arrays.binarySearch(arr_v, v);
        if(v1 < 0) {
            v2 = ~v1;
            return z1 ? Math.min(arr_v.length - 1, v2) : v2;
        }
        while(v1 + 1 < arr_v.length && arr_v[v1 + 1] == v) {
            ++v1;
        }
        v2 = z ? v1 : v1 + 1;
        return z1 ? Math.min(arr_v.length - 1, v2) : v2;
    }

    public static int binarySearchCeil(long[] arr_v, long v, boolean z, boolean z1) {
        int v2;
        int v1 = Arrays.binarySearch(arr_v, v);
        if(v1 < 0) {
            v2 = ~v1;
            return z1 ? Math.min(arr_v.length - 1, v2) : v2;
        }
        while(v1 + 1 < arr_v.length && arr_v[v1 + 1] == v) {
            ++v1;
        }
        v2 = z ? v1 : v1 + 1;
        return z1 ? Math.min(arr_v.length - 1, v2) : v2;
    }

    public static int binarySearchFloor(List list0, Comparable comparable0, boolean z, boolean z1) {
        int v1;
        int v = Collections.binarySearch(list0, comparable0);
        if(v < 0) {
            v1 = -(v + 2);
            return z1 ? Math.max(0, v1) : v1;
        }
        while(v - 1 >= 0 && ((Comparable)list0.get(v - 1)).compareTo(comparable0) == 0) {
            --v;
        }
        v1 = z ? v : v - 1;
        return z1 ? Math.max(0, v1) : v1;
    }

    public static int binarySearchFloor(int[] arr_v, int v, boolean z, boolean z1) {
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

    public static int binarySearchFloor(long[] arr_v, long v, boolean z, boolean z1) {
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

    @EnsuresNonNull({"#1"})
    public static Object castNonNull(Object object0) [...] // Inlined contents

    @EnsuresNonNull({"#1"})
    public static Object[] castNonNullTypeArray(Object[] arr_object) [...] // Inlined contents

    public static int ceilDivide(int v, int v1) [...] // Inlined contents

    public static long ceilDivide(long v, long v1) {
        return (v + v1 - 1L) / v1;
    }

    @TargetApi(24)
    public static boolean checkCleartextTrafficPermitted(Uri[] arr_uri) {
        if(Util.SDK_INT < 24) {
            return true;
        }
        for(int v = 0; v < arr_uri.length; ++v) {
            Uri uri0 = arr_uri[v];
            if("http".equals(uri0.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(((String)Assertions.checkNotNull(uri0.getHost())))) {
                return false;
            }
        }
        return true;
    }

    public static void closeQuietly(DataSource dataSource0) {
        if(dataSource0 != null) {
            try {
                dataSource0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public static void closeQuietly(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public static int compareLong(long v, long v1) {
        int v2 = Long.compare(v, v1);
        if(v2 < 0) {
            return -1;
        }
        return v2 == 0 ? 0 : 1;
    }

    public static float constrainValue(float f, float f1, float f2) {
        return Math.max(f1, Math.min(f, f2));
    }

    public static int constrainValue(int v, int v1, int v2) {
        return Math.max(v1, Math.min(v, v2));
    }

    public static long constrainValue(long v, long v1, long v2) {
        return Math.max(v1, Math.min(v, v2));
    }

    public static boolean contains(Object[] arr_object, Object object0) {
        for(int v = 0; v < arr_object.length; ++v) {
            if(Util.areEqual(arr_object[v], object0)) {
                return true;
            }
        }
        return false;
    }

    public static int crc32(byte[] arr_b, int v, int v1, int v2) {
        while(v < v1) {
            v2 = Util.CRC32_BYTES_MSBF[(v2 >>> 24 ^ arr_b[v] & 0xFF) & 0xFF] ^ v2 << 8;
            ++v;
        }
        return v2;
    }

    public static int crc8(byte[] arr_b, int v, int v1, int v2) {
        while(v < v1) {
            v2 = Util.CRC8_BYTES_MSBF[v2 ^ arr_b[v] & 0xFF];
            ++v;
        }
        return v2;
    }

    public static Handler createHandler(Handler.Callback handler$Callback0) {
        return Util.createHandler(Util.getLooper(), handler$Callback0);
    }

    public static Handler createHandler(Looper looper0, Handler.Callback handler$Callback0) {
        return new Handler(looper0, handler$Callback0);
    }

    private static HashMap createIsoLanguageReplacementMap() {
        String[] arr_s = Locale.getISOLanguages();
        HashMap hashMap0 = new HashMap(arr_s.length + Util.additionalIsoLanguageReplacements.length);
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            String s = arr_s[v1];
            try {
                String s1 = new Locale(s).getISO3Language();
                if(!TextUtils.isEmpty(s1)) {
                    hashMap0.put(s1, s);
                }
            }
            catch(MissingResourceException unused_ex) {
            }
        }
        for(int v = 0; true; v += 2) {
            String[] arr_s1 = Util.additionalIsoLanguageReplacements;
            if(v >= arr_s1.length) {
                break;
            }
            hashMap0.put(arr_s1[v], arr_s1[v + 1]);
        }
        return hashMap0;
    }

    public static File createTempDirectory(Context context0, String s) {
        File file0 = Util.createTempFile(context0, s);
        file0.delete();
        file0.mkdir();
        return file0;
    }

    public static File createTempFile(Context context0, String s) {
        return File.createTempFile(s, null, context0.getCacheDir());
    }

    public static String escapeFileName(String s) {
        int v = s.length();
        int v1 = 0;
        int v3 = 0;
        for(int v2 = 0; v2 < v; ++v2) {
            if(Util.shouldEscapeCharacter(s.charAt(v2))) {
                ++v3;
            }
        }
        if(v3 == 0) {
            return s;
        }
        StringBuilder stringBuilder0 = new StringBuilder(v3 * 2 + v);
        while(v3 > 0) {
            int v4 = s.charAt(v1);
            if(Util.shouldEscapeCharacter(((char)v4))) {
                stringBuilder0.append('%');
                stringBuilder0.append(Integer.toHexString(v4));
                --v3;
            }
            else {
                stringBuilder0.append(((char)v4));
            }
            ++v1;
        }
        if(v1 < v) {
            stringBuilder0.append(s, v1, v);
        }
        return stringBuilder0.toString();
    }

    public static String formatInvariant(String s, Object[] arr_object) [...] // 潜在的解密器

    public static String fromUtf8Bytes(byte[] arr_b) {
        return new String(arr_b, Charset.forName("UTF-8"));
    }

    public static String fromUtf8Bytes(byte[] arr_b, int v, int v1) {
        return new String(arr_b, v, v1, Charset.forName("UTF-8"));
    }

    public static int getAudioContentTypeForStreamType(int v) {
        switch(v) {
            case 0: {
                return 1;
            }
            case 1: {
                return 4;
            }
            default: {
                return v == 2 || v == 4 || (v == 5 || v == 8) ? 4 : 2;
            }
        }
    }

    public static int getAudioTrackChannelConfig(int v) {
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
                int v1 = Util.SDK_INT;
                if(v1 >= 23) {
                    return 0x18FC;
                }
                return v1 < 21 ? 0 : 0x18FC;
            }
            default: {
                return 0;
            }
        }
    }

    public static int getAudioUsageForStreamType(int v) {
        int v1 = 4;
        if(v != 0) {
            switch(v) {
                case 1: {
                    return 13;
                }
                case 2: {
                    return 6;
                label_6:
                    v1 = 5;
                    switch(v) {
                        case 5: {
                            return v1;
                        }
                        case 8: {
                            return 3;
                        }
                        default: {
                            return 1;
                        }
                    }
                }
                case 4: {
                    return v1;
                }
                default: {
                    goto label_6;
                }
            }
        }
        return 2;
    }

    public static byte[] getBytesFromHexString(String s) {
        int v = s.length();
        byte[] arr_b = new byte[v / 2];
        for(int v1 = 0; v1 < v / 2; ++v1) {
            arr_b[v1] = (byte)(Character.digit(s.charAt(v1 * 2 + 1), 16) + (Character.digit(s.charAt(v1 * 2), 16) << 4));
        }
        return arr_b;
    }

    public static String getCodecsOfType(String s, int v) {
        String[] arr_s = Util.splitCodecs(s);
        if(arr_s.length == 0) {
            return null;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            String s1 = arr_s[v1];
            if(v == MimeTypes.getTrackTypeOfCodec(s1)) {
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(s1);
            }
        }
        return stringBuilder0.length() <= 0 ? null : stringBuilder0.toString();
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] arr_object) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < arr_object.length; ++v) {
            stringBuilder0.append(arr_object[v].getClass().getSimpleName());
            if(v < arr_object.length - 1) {
                stringBuilder0.append(", ");
            }
        }
        return stringBuilder0.toString();
    }

    public static String getCountryCode(Context context0) {
        if(context0 != null) {
            TelephonyManager telephonyManager0 = (TelephonyManager)context0.getSystemService("phone");
            if(telephonyManager0 != null) {
                String s = telephonyManager0.getNetworkCountryIso();
                return TextUtils.isEmpty(s) ? Util.toUpperInvariant(Locale.getDefault().getCountry()) : Util.toUpperInvariant(s);
            }
        }
        return Util.toUpperInvariant(Locale.getDefault().getCountry());
    }

    public static Point getCurrentDisplayModeSize(Context context0) {
        return Util.getCurrentDisplayModeSize(context0, ((WindowManager)context0.getSystemService("window")).getDefaultDisplay());
    }

    public static Point getCurrentDisplayModeSize(Context context0, Display display0) {
        int v = Util.SDK_INT;
        if(v <= 29 && display0.getDisplayId() == 0 && Util.isTv(context0)) {
            if("Sony".equals(Util.MANUFACTURER) && Util.MODEL.startsWith("BRAVIA") && context0.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(0xF00, 0x870);
            }
            String s = v >= 28 ? Util.getSystemProperty("vendor.display-size") : Util.getSystemProperty("sys.display-size");
            if(!TextUtils.isEmpty(s)) {
                try {
                    String[] arr_s = Util.split(s.trim(), "x");
                    if(arr_s.length == 2) {
                        int v1 = Integer.parseInt(arr_s[0]);
                        int v2 = Integer.parseInt(arr_s[1]);
                        if(v1 > 0 && v2 > 0) {
                            return new Point(v1, v2);
                        }
                    }
                }
                catch(NumberFormatException unused_ex) {
                }
                String s1 = String.valueOf(s);
                Log.e("Util", (s1.length() == 0 ? new String("Invalid display size: ") : "Invalid display size: " + s1));
            }
        }
        Point point0 = new Point();
        int v3 = Util.SDK_INT;
        if(v3 >= 23) {
            Util.getDisplaySizeV23(display0, point0);
            return point0;
        }
        if(v3 >= 17) {
            Util.getDisplaySizeV17(display0, point0);
            return point0;
        }
        Util.getDisplaySizeV16(display0, point0);
        return point0;
    }

    private static void getDisplaySizeV16(Display display0, Point point0) {
        display0.getSize(point0);
    }

    @TargetApi(17)
    private static void getDisplaySizeV17(Display display0, Point point0) {
        display0.getRealSize(point0);
    }

    @TargetApi(23)
    private static void getDisplaySizeV23(Display display0, Point point0) {
        Display.Mode display$Mode0 = display0.getMode();
        point0.x = display$Mode0.getPhysicalWidth();
        point0.y = display$Mode0.getPhysicalHeight();
    }

    public static UUID getDrmUuid(String s) {
        String s1 = Util.toLowerInvariant(s);
        s1.getClass();
        switch(s1) {
            case "clearkey": {
                return C.CLEARKEY_UUID;
            }
            case "playready": {
                return C.PLAYREADY_UUID;
            }
            case "widevine": {
                return C.WIDEVINE_UUID;
            }
            default: {
                try {
                    return UUID.fromString(s);
                }
                catch(RuntimeException unused_ex) {
                    return null;
                }
            }
        }
    }

    public static int getIntegerCodeForString(String s) {
        int v = s.length();
        Assertions.checkArgument(v <= 4);
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 = v2 << 8 | s.charAt(v1);
        }
        return v2;
    }

    public static String getLocaleLanguageTag(Locale locale0) {
        return Util.SDK_INT < 21 ? locale0.toString() : Util.getLocaleLanguageTagV21(locale0);
    }

    @TargetApi(21)
    private static String getLocaleLanguageTagV21(Locale locale0) {
        return locale0.toLanguageTag();
    }

    public static Looper getLooper() {
        Looper looper0 = Looper.myLooper();
        return looper0 == null ? Looper.getMainLooper() : looper0;
    }

    public static long getMediaDurationForPlayoutDuration(long v, float f) {
        return f == 1.0f ? v : Math.round(((double)v) * ((double)f));
    }

    private static int getMobileNetworkType(NetworkInfo networkInfo0) {
        switch(networkInfo0.getSubtype()) {
            case 1: 
            case 2: {
                return 3;
            }
            case 13: {
                return 5;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 14: 
            case 15: 
            case 17: {
                return 4;
            }
            case 18: {
                return 2;
            }
            case 20: {
                return 9;
            }
            default: {
                return 6;
            }
        }
    }

    public static int getNetworkType(Context context0) {
        NetworkInfo networkInfo0;
        int v = 0;
        if(context0 == null) {
            return 0;
        }
        ConnectivityManager connectivityManager0 = (ConnectivityManager)context0.getSystemService("connectivity");
        if(connectivityManager0 == null) {
            return 0;
        }
        try {
            networkInfo0 = connectivityManager0.getActiveNetworkInfo();
        }
        catch(SecurityException unused_ex) {
            return v;
        }
        v = 1;
        if(networkInfo0 != null && networkInfo0.isConnected()) {
            switch(networkInfo0.getType()) {
                case 1: {
                    return 2;
                }
                case 0: 
                case 4: 
                case 5: {
                    return Util.getMobileNetworkType(networkInfo0);
                }
                case 6: {
                    return 5;
                }
                case 9: {
                    return 7;
                }
                default: {
                    return 8;
                }
            }
        }
        return v;
    }

    public static int getPcmEncoding(int v) {
        switch(v) {
            case 8: {
                return 3;
            }
            case 16: {
                return 2;
            }
            case 24: {
                return 0x20000000;
            }
            case 0x20: {
                return 0x30000000;
            }
            default: {
                return 0;
            }
        }
    }

    public static int getPcmFrameSize(int v, int v1) {
        switch(v) {
            case 3: {
                return v1;
            }
            case 2: 
            case 0x10000000: {
                return v1 * 2;
            }
            case 0x20000000: {
                return v1 * 3;
            }
            case 4: 
            case 0x30000000: {
                return v1 * 4;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public static long getPlayoutDurationForMediaDuration(long v, float f) {
        return f == 1.0f ? v : Math.round(((double)v) / ((double)f));
    }

    public static RendererCapabilities[] getRendererCapabilities(RenderersFactory renderersFactory0) {
        Renderer[] arr_renderer = renderersFactory0.createRenderers(new Handler(), new VideoRendererEventListener() {
        }, new AudioRendererEventListener() {
        }, new c(), new d(), null);  // 初始化器: Ljava/lang/Object;-><init>()V / 初始化器: Ljava/lang/Object;-><init>()V
        RendererCapabilities[] arr_rendererCapabilities = new RendererCapabilities[arr_renderer.length];
        for(int v = 0; v < arr_renderer.length; ++v) {
            arr_rendererCapabilities[v] = arr_renderer[v].getCapabilities();
        }
        return arr_rendererCapabilities;
    }

    public static int getStreamTypeForAudioUsage(int v) {
        if(v != 13) {
            switch(v) {
                case 2: {
                    return 0;
                }
                case 3: {
                    return 8;
                }
                case 4: {
                    return 4;
                }
                case 6: {
                    return 2;
                }
                case 5: 
                case 7: 
                case 8: 
                case 9: 
                case 10: {
                    return 5;
                }
                default: {
                    return 3;
                }
            }
        }
        return 1;
    }

    public static String getStringForTime(StringBuilder stringBuilder0, Formatter formatter0, long v) {
        if(Long.compare(v, 0x8000000000000001L) == 0) {
            v = 0L;
        }
        long v1 = (v + 500L) / 1000L;
        long v2 = v1 / 60L % 60L;
        stringBuilder0.setLength(0);
        return v1 / 3600L <= 0L ? formatter0.format("%02d:%02d", v2, ((long)(v1 % 60L))).toString() : formatter0.format("%d:%02d:%02d", ((long)(v1 / 3600L)), v2, ((long)(v1 % 60L))).toString();
    }

    public static String[] getSystemLanguageCodes() {
        String[] arr_s = Util.getSystemLocales();
        for(int v = 0; v < arr_s.length; ++v) {
            arr_s[v] = Util.normalizeLanguageCode(arr_s[v]);
        }
        return arr_s;
    }

    private static String[] getSystemLocales() {
        Configuration configuration0 = Resources.getSystem().getConfiguration();
        return Util.SDK_INT < 24 ? new String[]{Util.getLocaleLanguageTag(configuration0.locale)} : Util.getSystemLocalesV24(configuration0);
    }

    @TargetApi(24)
    private static String[] getSystemLocalesV24(Configuration configuration0) {
        return Util.split(configuration0.getLocales().toLanguageTags(), ",");
    }

    private static String getSystemProperty(String s) {
        try {
            Class class0 = Class.forName("android.os.SystemProperties");
            return (String)class0.getMethod("get", String.class).invoke(class0, s);
        }
        catch(Exception exception0) {
            String s1 = String.valueOf(s);
            Log.e("Util", (s1.length() == 0 ? new String("Failed to read system property ") : "Failed to read system property " + s1), exception0);
            return null;
        }
    }

    public static String getTrackTypeString(int v) {
        switch(v) {
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
                return "metadata";
            }
            case 5: {
                return "camera motion";
            }
            case 6: {
                return "none";
            }
            default: {
                return v < 10000 ? "?" : "custom (" + v + ")";
            }
        }
    }

    public static String getUserAgent(Context context0, String s) {
        String s1 = "?";
        try {
            s1 = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        String s2 = Build.VERSION.RELEASE;
        return x.m(Z.o(Z.e(Z.e(Z.e(38, s), s1), s2), s, "/", s1, " (Linux;Android "), s2, ") ExoPlayerLib/2.11.7");
    }

    public static byte[] getUtf8Bytes(String s) [...] // 潜在的解密器

    public static int inferContentType(Uri uri0) {
        String s = uri0.getPath();
        return s == null ? 3 : Util.inferContentType(s);
    }

    public static int inferContentType(Uri uri0, String s) {
        if(TextUtils.isEmpty(s)) {
            return Util.inferContentType(uri0);
        }
        String s1 = String.valueOf(s);
        return s1.length() == 0 ? 3 : Util.inferContentType(("." + s1));
    }

    public static int inferContentType(String s) [...] // 潜在的解密器

    public static boolean inflate(ParsableByteArray parsableByteArray0, ParsableByteArray parsableByteArray1, Inflater inflater0) {
        if(parsableByteArray0.bytesLeft() <= 0) {
            return false;
        }
        byte[] arr_b = parsableByteArray1.data.length >= parsableByteArray0.bytesLeft() ? parsableByteArray1.data : new byte[parsableByteArray0.bytesLeft() * 2];
        if(inflater0 == null) {
            inflater0 = new Inflater();
        }
        inflater0.setInput(parsableByteArray0.data, parsableByteArray0.getPosition(), parsableByteArray0.bytesLeft());
        int v = 0;
        try {
            while(true) {
                v += inflater0.inflate(arr_b, v, arr_b.length - v);
                if(inflater0.finished()) {
                    break;
                }
                if(inflater0.needsDictionary() || inflater0.needsInput()) {
                    return false;
                }
                if(v == arr_b.length) {
                    arr_b = Arrays.copyOf(arr_b, arr_b.length * 2);
                }
            }
            parsableByteArray1.reset(arr_b, v);
            return true;
        }
        catch(DataFormatException unused_ex) {
            return false;
        }
        finally {
            inflater0.reset();
        }
    }

    public static boolean isEncodingHighResolutionPcm(int v) {
        return v == 4 || v == 0x20000000 || v == 0x30000000;
    }

    public static boolean isEncodingLinearPcm(int v) {
        switch(v) {
            case 2: 
            case 3: 
            case 4: 
            case 0x10000000: 
            case 0x20000000: 
            case 0x30000000: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isLinebreak(int v) {
        return v == 10 || v == 13;
    }

    public static boolean isLocalFileUri(Uri uri0) {
        String s = uri0.getScheme();
        return TextUtils.isEmpty(s) || "file".equals(s);
    }

    public static boolean isTv(Context context0) {
        UiModeManager uiModeManager0 = (UiModeManager)context0.getApplicationContext().getSystemService("uimode");
        return uiModeManager0 != null && uiModeManager0.getCurrentModeType() == 4;
    }

    private static void lambda$getRendererCapabilities$1(List list0) {
    }

    private static void lambda$getRendererCapabilities$2(Metadata metadata0) {
    }

    private static Thread lambda$newSingleThreadExecutor$0(String s, Runnable runnable0) {
        return new Thread(runnable0, s);
    }

    public static int linearSearch(int[] arr_v, int v) {
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(arr_v[v1] == v) {
                return v1;
            }
        }
        return -1;
    }

    public static int linearSearch(long[] arr_v, long v) {
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(arr_v[v1] == v) {
                return v1;
            }
        }
        return -1;
    }

    private static String maybeReplaceGrandfatheredLanguageTags(String s) {
        for(int v = 0; true; v += 2) {
            String[] arr_s = Util.isoGrandfatheredTagReplacements;
            if(v >= arr_s.length) {
                break;
            }
            if(s.startsWith(arr_s[v])) {
                String s1 = String.valueOf(arr_s[v + 1]);
                String s2 = s.substring(arr_s[v].length());
                return s2.length() == 0 ? new String(s1) : s1 + s2;
            }
        }
        return s;
    }

    @TargetApi(23)
    public static boolean maybeRequestReadExternalStoragePermission(Activity activity0, Uri[] arr_uri) {
        if(Util.SDK_INT < 23) {
            return false;
        }
        for(int v = 0; v < arr_uri.length; ++v) {
            if(Util.isLocalFileUri(arr_uri[v])) {
                if(activity0.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                    break;
                }
                activity0.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                return true;
            }
        }
        return false;
    }

    public static ExecutorService newSingleThreadExecutor(String s) {
        return Executors.newSingleThreadExecutor(new e(s, 0));
    }

    public static String normalizeLanguageCode(String s) {
        if(s == null) {
            return null;
        }
        String s1 = s.replace('_', '-');
        if(!s1.isEmpty() && !"und".equals(s1)) {
            s = s1;
        }
        String s2 = Util.toLowerInvariant(s);
        String s3 = Util.splitAtFirst(s2, "-")[0];
        if(Util.languageTagReplacementMap == null) {
            Util.languageTagReplacementMap = Util.createIsoLanguageReplacementMap();
        }
        String s4 = (String)Util.languageTagReplacementMap.get(s3);
        if(s4 != null) {
            String s5 = s2.substring(s3.length());
            s2 = s5.length() == 0 ? new String(s4) : s4 + s5;
            s3 = s4;
        }
        return "no".equals(s3) || "i".equals(s3) || "zh".equals(s3) ? Util.maybeReplaceGrandfatheredLanguageTags(s2) : s2;
    }

    public static Object[] nullSafeArrayAppend(Object[] arr_object, Object object0) {
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length + 1);
        arr_object1[arr_object.length] = object0;
        return arr_object1;
    }

    public static Object[] nullSafeArrayConcatenation(Object[] arr_object, Object[] arr_object1) {
        Object[] arr_object2 = Arrays.copyOf(arr_object, arr_object.length + arr_object1.length);
        System.arraycopy(arr_object1, 0, arr_object2, arr_object.length, arr_object1.length);
        return arr_object2;
    }

    public static Object[] nullSafeArrayCopy(Object[] arr_object, int v) {
        Assertions.checkArgument(v <= arr_object.length);
        return Arrays.copyOf(arr_object, v);
    }

    public static Object[] nullSafeArrayCopyOfRange(Object[] arr_object, int v, int v1) {
        boolean z = false;
        Assertions.checkArgument(v >= 0);
        if(v1 <= arr_object.length) {
            z = true;
        }
        Assertions.checkArgument(z);
        return Arrays.copyOfRange(arr_object, v, v1);
    }

    public static long parseXsDateTime(String s) {
        int v = 0;
        Matcher matcher0 = Util.XS_DATE_TIME_PATTERN.matcher(s);
        if(!matcher0.matches()) {
            String s1 = String.valueOf(s);
            throw new ParserException((s1.length() == 0 ? new String("Invalid date/time format: ") : "Invalid date/time format: " + s1));
        }
        if(matcher0.group(9) != null && !matcher0.group(9).equalsIgnoreCase("Z")) {
            int v1 = Integer.parseInt(matcher0.group(12));
            v = Integer.parseInt(matcher0.group(13)) + v1 * 60;
            if("-".equals(matcher0.group(11))) {
                v = -v;
            }
        }
        GregorianCalendar gregorianCalendar0 = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar0.clear();
        gregorianCalendar0.set(Integer.parseInt(matcher0.group(1)), Integer.parseInt(matcher0.group(2)) - 1, Integer.parseInt(matcher0.group(3)), Integer.parseInt(matcher0.group(4)), Integer.parseInt(matcher0.group(5)), Integer.parseInt(matcher0.group(6)));
        if(!TextUtils.isEmpty(matcher0.group(8))) {
            String s2 = matcher0.group(8);
            gregorianCalendar0.set(14, new BigDecimal((s2.length() == 0 ? new String("0.") : "0." + s2)).movePointRight(3).intValue());
        }
        long v2 = gregorianCalendar0.getTimeInMillis();
        return v == 0 ? v2 : v2 - ((long)(v * 60000));
    }

    public static long parseXsDuration(String s) {
        Matcher matcher0 = Util.XS_DURATION_PATTERN.matcher(s);
        if(matcher0.matches()) {
            boolean z = TextUtils.isEmpty(matcher0.group(1));
            String s1 = matcher0.group(3);
            double f = 0.0;
            double f1 = s1 == null ? 0.0 : Double.parseDouble(s1) * 31556908.0;
            String s2 = matcher0.group(5);
            double f2 = s2 == null ? 0.0 : Double.parseDouble(s2) * 2629739.0;
            String s3 = matcher0.group(7);
            double f3 = s3 == null ? 0.0 : Double.parseDouble(s3) * 86400.0;
            String s4 = matcher0.group(10);
            double f4 = s4 == null ? 0.0 : Double.parseDouble(s4) * 3600.0;
            String s5 = matcher0.group(12);
            double f5 = s5 == null ? 0.0 : Double.parseDouble(s5) * 60.0;
            String s6 = matcher0.group(14);
            if(s6 != null) {
                f = Double.parseDouble(s6);
            }
            long v = (long)((f1 + f2 + f3 + f4 + f5 + f) * 1000.0);
            return z ? v : -v;
        }
        return (long)(Double.parseDouble(s) * 3600000.0);
    }

    public static boolean readBoolean(Parcel parcel0) {
        return parcel0.readInt() != 0;
    }

    public static void recursiveDelete(File file0) {
        File[] arr_file = file0.listFiles();
        if(arr_file != null) {
            for(int v = 0; v < arr_file.length; ++v) {
                Util.recursiveDelete(arr_file[v]);
            }
        }
        file0.delete();
    }

    public static void removeRange(List list0, int v, int v1) {
        if(v < 0 || v1 > list0.size() || v > v1) {
            throw new IllegalArgumentException();
        }
        if(v != v1) {
            list0.subList(v, v1).clear();
        }
    }

    public static long resolveSeekPositionUs(long v, SeekParameters seekParameters0, long v1, long v2) {
        if(SeekParameters.EXACT.equals(seekParameters0)) {
            return v;
        }
        long v3 = Util.subtractWithOverflowDefault(v, seekParameters0.toleranceBeforeUs, 0x8000000000000000L);
        long v4 = Util.addWithOverflowDefault(v, seekParameters0.toleranceAfterUs, 0x7FFFFFFFFFFFFFFFL);
        boolean z = false;
        boolean z1 = Long.compare(v3, v1) <= 0 && v1 <= v4;
        if(v3 <= v2 && v2 <= v4) {
            z = true;
        }
        if(z1 && z) {
            return Math.abs(v1 - v) > Math.abs(v2 - v) ? v2 : v1;
        }
        if(z1) {
            return v1;
        }
        return z ? v2 : v3;
    }

    public static long scaleLargeTimestamp(long v, long v1, long v2) {
        int v3 = Long.compare(v2, v1);
        if(v3 >= 0 && v2 % v1 == 0L) {
            return v / (v2 / v1);
        }
        return v3 >= 0 || v1 % v2 != 0L ? ((long)(((double)v) * (((double)v1) / ((double)v2)))) : v1 / v2 * v;
    }

    public static long[] scaleLargeTimestamps(List list0, long v, long v1) {
        int v2 = list0.size();
        long[] arr_v = new long[v2];
        int v3 = Long.compare(v1, v);
        int v4 = 0;
        if(v3 >= 0 && v1 % v == 0L) {
            while(v4 < v2) {
                arr_v[v4] = ((long)(((Long)list0.get(v4)))) / (v1 / v);
                ++v4;
            }
            return arr_v;
        }
        if(v3 < 0 && v % v1 == 0L) {
            while(v4 < v2) {
                arr_v[v4] = ((long)(((Long)list0.get(v4)))) * (v / v1);
                ++v4;
            }
            return arr_v;
        }
        while(v4 < v2) {
            arr_v[v4] = (long)(((double)(((long)(((Long)list0.get(v4)))))) * (((double)v) / ((double)v1)));
            ++v4;
        }
        return arr_v;
    }

    public static void scaleLargeTimestampsInPlace(long[] arr_v, long v, long v1) {
        int v2 = Long.compare(v1, v);
        int v3 = 0;
        if(v2 >= 0 && v1 % v == 0L) {
            while(v3 < arr_v.length) {
                arr_v[v3] /= v1 / v;
                ++v3;
            }
            return;
        }
        if(v2 < 0 && v % v1 == 0L) {
            while(v3 < arr_v.length) {
                arr_v[v3] *= v / v1;
                ++v3;
            }
            return;
        }
        while(v3 < arr_v.length) {
            arr_v[v3] = (long)(((double)arr_v[v3]) * (((double)v) / ((double)v1)));
            ++v3;
        }
    }

    private static boolean shouldEscapeCharacter(char c) {
        switch(c) {
            case 34: 
            case 37: 
            case 42: 
            case 0x2F: 
            case 58: 
            case 60: 
            case 62: 
            case 0x3F: 
            case 92: 
            case 0x7C: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static void sneakyThrow(Throwable throwable0) {
        Util.sneakyThrowInternal(throwable0);
    }

    private static void sneakyThrowInternal(Throwable throwable0) {
        throw throwable0;
    }

    public static String[] split(String s, String s1) {
        return s.split(s1, -1);
    }

    public static String[] splitAtFirst(String s, String s1) {
        return s.split(s1, 2);
    }

    // 去混淆评级： 低(20)
    public static String[] splitCodecs(String s) {
        return TextUtils.isEmpty(s) ? new String[0] : Util.split(s.trim(), "(\\s*,\\s*)");
    }

    public static ComponentName startForegroundService(Context context0, Intent intent0) {
        return Util.SDK_INT < 26 ? context0.startService(intent0) : context0.startForegroundService(intent0);
    }

    public static long subtractWithOverflowDefault(long v, long v1, long v2) {
        long v3 = v - v1;
        return ((v ^ v3) & (v1 ^ v)) >= 0L ? v3 : v2;
    }

    public static int[] toArray(List list0) {
        if(list0 == null) {
            return null;
        }
        int v = list0.size();
        int[] arr_v = new int[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_v[v1] = (int)(((Integer)list0.get(v1)));
        }
        return arr_v;
    }

    public static byte[] toByteArray(InputStream inputStream0) {
        byte[] arr_b = new byte[0x1000];
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        int v;
        while((v = inputStream0.read(arr_b)) != -1) {
            byteArrayOutputStream0.write(arr_b, 0, v);
        }
        return byteArrayOutputStream0.toByteArray();
    }

    public static long toLong(int v, int v1) [...] // Inlined contents

    public static String toLowerInvariant(String s) {
        return s == null ? null : s.toLowerCase(Locale.US);
    }

    public static long toUnsignedLong(int v) [...] // Inlined contents

    public static String toUpperInvariant(String s) {
        return s == null ? null : s.toUpperCase(Locale.US);
    }

    public static String unescapeFileName(String s) {
        int v = s.length();
        int v1 = 0;
        int v3 = 0;
        for(int v2 = 0; v2 < v; ++v2) {
            if(s.charAt(v2) == 37) {
                ++v3;
            }
        }
        if(v3 == 0) {
            return s;
        }
        int v4 = v - v3 * 2;
        StringBuilder stringBuilder0 = new StringBuilder(v4);
        Matcher matcher0 = Util.ESCAPED_CHARACTER_PATTERN.matcher(s);
        while(v3 > 0 && matcher0.find()) {
            int v5 = (char)Integer.parseInt(matcher0.group(1), 16);
            stringBuilder0.append(s, v1, matcher0.start());
            stringBuilder0.append(((char)v5));
            v1 = matcher0.end();
            --v3;
        }
        if(v1 < v) {
            stringBuilder0.append(s, v1, v);
        }
        return stringBuilder0.length() == v4 ? stringBuilder0.toString() : null;
    }

    public static void writeBoolean(Parcel parcel0, boolean z) {
        parcel0.writeInt(((int)z));
    }
}

