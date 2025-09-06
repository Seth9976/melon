package Cb;

import P4.a;
import Tf.o;
import Tf.v;
import android.content.Context;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;

public abstract class k {
    public static final List a;

    static {
        k.a = e.k.A(new Character.UnicodeBlock[]{Character.UnicodeBlock.HANGUL_JAMO, Character.UnicodeBlock.HANGUL_JAMO_EXTENDED_A, Character.UnicodeBlock.HANGUL_JAMO_EXTENDED_B, Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO, Character.UnicodeBlock.HANGUL_SYLLABLES});
    }

    public static final String a(Context context0, String s) {
        q.g(s, "<this>");
        q.g(context0, "context");
        long v = Util.toLongOrDefault(s, 0L);
        if(Long.compare(0L, v) <= 0 && v < 1000000L) {
            return StringUtils.INSTANCE.getFormattedStringNumber(v);
        }
        if(1000000L <= v && v < 100000000L) {
            String s1 = new DecimalFormat("#,###.0").format(Math.floor(((double)v) / 10000.0 * 10.0) / 10.0);
            q.d(s1);
            if(v.i0(s1, ".0", false)) {
                String s2 = s1.substring(0, o.F0(s1, ".0", 0, false, 6));
                q.f(s2, "substring(...)");
                return s2 + "만";
            }
            return s1 + "만";
        }
        return "1억+";
    }

    public static final String b(Context context0, String s) {
        q.g(s, "<this>");
        q.g(context0, "context");
        long v = Util.toLongOrDefault(s, 0L);
        if(Long.compare(0L, v) <= 0 && v < 10000000L) {
            return StringUtils.INSTANCE.getFormattedStringNumber(v);
        }
        if(10000000L <= v && v < 100000000L) {
            String s1 = new DecimalFormat("#,###.0").format(Math.floor(((double)v) / 10000.0 * 10.0) / 10.0);
            q.d(s1);
            if(v.i0(s1, ".0", false)) {
                String s2 = s1.substring(0, o.F0(s1, ".0", 0, false, 6));
                q.f(s2, "substring(...)");
                return s2 + "만";
            }
            return s1 + "만";
        }
        return "1억+";
    }

    public static final String c(String s, String s1, String s2) {
        q.g(s, "<this>");
        q.g(s1, "key");
        q.g(s2, "replaceText");
        return s.length() != 0 && s1.length() != 0 && o.v0(s, s1, false) ? v.p0(s, s1, s2) : s;
    }

    public static final String d(String s, String s1, String s2) {
        q.g(s, "<this>");
        if(s.length() != 0) {
            int v = s.charAt(o.B0(s));
            if(v >= 0xAC00 && v <= 55203) {
                return (v - 0xAC00) % 28 <= 0 ? s2 : s1;
            }
        }
        return "";
    }

    public static final String e(String s) {
        if(s == null) {
            return "";
        }
        try {
            long v = Long.parseLong(s);
            return StringUtils.INSTANCE.getTimeContentDescriptionForSec(v);
        }
        catch(NumberFormatException numberFormatException0) {
            String s1 = s.getClass().getSimpleName();
            LogU.Companion.w(s1, "toTimeContentDescriptionForSec()", numberFormatException0);
            return "";
        }
    }

    public static final String f(String s) {
        q.g(s, "<this>");
        long v = Util.toLongOrDefault(s, 0L);
        long v1 = v < 60L ? 0L : v / 60L % 60L;
        long v2 = v < a.c ? 0L : v / 3600L;
        return v2 <= 0L ? String.format(Locale.getDefault(), "%d:%02d", Arrays.copyOf(new Object[]{v1, ((long)(v % 60L))}, 2)) : String.format(Locale.getDefault(), "%d:%02d:%02d", Arrays.copyOf(new Object[]{v2, v1, ((long)(v % 60L))}, 3));
    }
}

