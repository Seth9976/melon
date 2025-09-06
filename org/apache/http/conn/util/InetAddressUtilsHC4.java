package org.apache.http.conn.util;

import java.util.regex.Pattern;
import org.apache.http.annotation.Immutable;

@Immutable
public class InetAddressUtilsHC4 {
    private static final char COLON_CHAR = ':';
    private static final String IPV4_BASIC_PATTERN_STRING = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    private static final Pattern IPV4_MAPPED_IPV6_PATTERN = null;
    private static final Pattern IPV4_PATTERN = null;
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = null;
    private static final Pattern IPV6_STD_PATTERN = null;
    private static final int MAX_COLON_COUNT = 7;

    static {
        InetAddressUtilsHC4.IPV4_PATTERN = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
        InetAddressUtilsHC4.IPV4_MAPPED_IPV6_PATTERN = Pattern.compile("^::[fF]{4}:(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
        InetAddressUtilsHC4.IPV6_STD_PATTERN = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");
        InetAddressUtilsHC4.IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");
    }

    public static boolean isIPv4Address(String s) {
        return InetAddressUtilsHC4.IPV4_PATTERN.matcher(s).matches();
    }

    public static boolean isIPv4MappedIPv64Address(String s) {
        return InetAddressUtilsHC4.IPV4_MAPPED_IPV6_PATTERN.matcher(s).matches();
    }

    // 去混淆评级： 低(20)
    public static boolean isIPv6Address(String s) {
        return InetAddressUtilsHC4.isIPv6StdAddress(s) || InetAddressUtilsHC4.isIPv6HexCompressedAddress(s);
    }

    public static boolean isIPv6HexCompressedAddress(String s) {
        int v1 = 0;
        for(int v = 0; v < s.length(); ++v) {
            if(s.charAt(v) == 58) {
                ++v1;
            }
        }
        return v1 <= 7 && InetAddressUtilsHC4.IPV6_HEX_COMPRESSED_PATTERN.matcher(s).matches();
    }

    public static boolean isIPv6StdAddress(String s) {
        return InetAddressUtilsHC4.IPV6_STD_PATTERN.matcher(s).matches();
    }
}

