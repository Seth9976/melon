package io.netty.handler.ssl;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SignatureAlgorithmConverter {
    private static final Pattern PATTERN;

    static {
        SignatureAlgorithmConverter.PATTERN = Pattern.compile("(?:(^[a-zA-Z].+)With(.+)Encryption$)|(?:(^[a-zA-Z].+)(?:_with_|-with-|_pkcs1_|_pss_rsae_)(.+$))|(?:(^[a-zA-Z].+)_(.+$))");
    }

    public static String toJavaName(String s) {
        if(s == null) {
            return null;
        }
        Matcher matcher0 = SignatureAlgorithmConverter.PATTERN.matcher(s);
        if(matcher0.matches()) {
            String s1 = matcher0.group(1);
            if(s1 != null) {
                Locale locale0 = Locale.ROOT;
                return s1.toUpperCase(locale0) + "with" + matcher0.group(2).toUpperCase(locale0);
            }
            if(matcher0.group(3) != null) {
                String s2 = matcher0.group(4);
                Locale locale1 = Locale.ROOT;
                return s2.toUpperCase(locale1) + "with" + matcher0.group(3).toUpperCase(locale1);
            }
            if(matcher0.group(5) != null) {
                String s3 = matcher0.group(6);
                Locale locale2 = Locale.ROOT;
                return s3.toUpperCase(locale2) + "with" + matcher0.group(5).toUpperCase(locale2);
            }
        }
        return null;
    }
}

