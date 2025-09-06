package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class SystemPropertyUtil {
    private static final InternalLogger logger;

    static {
        SystemPropertyUtil.logger = InternalLoggerFactory.getInstance(SystemPropertyUtil.class);
    }

    public static boolean contains(String s) {
        return SystemPropertyUtil.get(s) != null;
    }

    public static String get(String s) [...] // 潜在的解密器

    public static String get(String s, String s1) [...] // 潜在的解密器

    public static boolean getBoolean(String s, boolean z) {
        String s1 = SystemPropertyUtil.get(s);
        if(s1 != null) {
            String s2 = s1.trim().toLowerCase();
            if(!s2.isEmpty()) {
                if(!"true".equals(s2) && !"yes".equals(s2) && !"1".equals(s2)) {
                    if(!"false".equals(s2) && !"no".equals(s2) && !"0".equals(s2)) {
                        SystemPropertyUtil.logger.warn("Unable to parse the boolean system property \'{}\':{} - using the default value: {}", new Object[]{s, s2, Boolean.valueOf(z)});
                        return z;
                    }
                    return false;
                }
                return true;
            }
        }
        return z;
    }

    public static int getInt(String s, int v) {
        String s1 = SystemPropertyUtil.get(s);
        if(s1 == null) {
            return v;
        }
        String s2 = s1.trim();
        try {
            return Integer.parseInt(s2);
        }
        catch(Exception unused_ex) {
            SystemPropertyUtil.logger.warn("Unable to parse the integer system property \'{}\':{} - using the default value: {}", new Object[]{s, s2, v});
            return v;
        }
    }

    public static long getLong(String s, long v) {
        String s1 = SystemPropertyUtil.get(s);
        if(s1 == null) {
            return v;
        }
        String s2 = s1.trim();
        try {
            return Long.parseLong(s2);
        }
        catch(Exception unused_ex) {
            SystemPropertyUtil.logger.warn("Unable to parse the long integer system property \'{}\':{} - using the default value: {}", new Object[]{s, s2, v});
            return v;
        }
    }
}

