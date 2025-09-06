package g3;

import java.util.regex.Pattern;

public abstract class u {
    public static final Pattern a;
    public static final Pattern b;

    static {
        u.a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
        u.b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");
    }
}

