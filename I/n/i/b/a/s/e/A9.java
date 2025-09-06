package i.n.i.b.a.s.e;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k8.Y;

public abstract class a9 {
    public static final Pattern a;
    public static final Pattern b;

    static {
        a9.a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
        a9.b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");
    }

    public static long a(String s) {
        if(TextUtils.isEmpty(s)) {
            return -1L;
        }
        Matcher matcher0 = a9.b.matcher(s);
        if(matcher0.matches()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            return Long.parseLong(s1);
        }
        return -1L;
    }

    public static String b(long v, long v1) {
        if(Long.compare(v, 0L) == 0 && v1 == -1L) {
            return null;
        }
        StringBuilder stringBuilder0 = Y.o(v, "bytes=", "-");
        if(v1 != -1L) {
            stringBuilder0.append(v + v1 - 1L);
        }
        return stringBuilder0.toString();
    }
}

