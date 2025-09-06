package i.n.i.b.a.s.e;

import java.util.regex.Pattern;

public abstract class f0 {
    public static final Pattern a;

    static {
        f0.a = Pattern.compile("^NOTE([ \t].*)?$");
    }

    public static float a(String s) {
        if(!s.endsWith("%")) {
            throw new NumberFormatException("Percentages must end with %");
        }
        return Float.parseFloat(s.substring(0, s.length() - 1)) / 100.0f;
    }

    public static long b(String s) {
        String[] arr_s = s.split("\\.", 2);
        String[] arr_s1 = arr_s[0].split(":", -1);
        long v1 = 0L;
        for(int v = 0; v < arr_s1.length; ++v) {
            v1 = v1 * 60L + Long.parseLong(arr_s1[v]);
        }
        return (arr_s.length == 2 ? v1 * 1000L + Long.parseLong(arr_s[1]) : v1 * 1000L) * 1000L;
    }

    public static void c(wb wb0) {
        int v = wb0.b;
        String s = wb0.q();
        if(s != null && s.startsWith("WEBVTT")) {
            return;
        }
        wb0.n(v);
        throw new H4("Expected WEBVTT. Got " + wb0.q());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    }
}

