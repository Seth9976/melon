package g4;

import b3.I;
import e3.p;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public abstract class i {
    public static final Pattern a;

    static {
        i.a = Pattern.compile("^NOTE([ \t].*)?$");
    }

    public static boolean a(p p0) {
        p0.getClass();
        String s = p0.h(StandardCharsets.UTF_8);
        return s != null && s.startsWith("WEBVTT");
    }

    public static float b(String s) {
        if(!s.endsWith("%")) {
            throw new NumberFormatException("Percentages must end with %");
        }
        return Float.parseFloat(s.substring(0, s.length() - 1)) / 100.0f;
    }

    public static long c(String s) {
        String[] arr_s = s.split("\\.", 2);
        String[] arr_s1 = arr_s[0].split(":", -1);
        long v1 = 0L;
        for(int v = 0; v < arr_s1.length; ++v) {
            v1 = v1 * 60L + Long.parseLong(arr_s1[v]);
        }
        return (arr_s.length == 2 ? v1 * 1000L + Long.parseLong(arr_s[1]) : v1 * 1000L) * 1000L;
    }

    public static void d(p p0) {
        int v = p0.b;
        if(i.a(p0)) {
            return;
        }
        p0.G(v);
        throw I.a(null, "Expected WEBVTT. Got " + p0.h(StandardCharsets.UTF_8));
    }
}

