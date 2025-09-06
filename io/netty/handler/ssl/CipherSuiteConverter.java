package io.netty.handler.ssl;

import H0.b;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CipherSuiteConverter {
    static final class CachedValue {
        private static final CachedValue NULL;
        final String value;

        static {
            CachedValue.NULL = new CachedValue(null);
        }

        private CachedValue(String s) {
            this.value = s;
        }

        public static CachedValue of(String s) {
            return s == null ? CachedValue.NULL : new CachedValue(s);
        }
    }

    private static final Pattern JAVA_AES_CBC_PATTERN;
    private static final Pattern JAVA_AES_PATTERN;
    private static final Pattern JAVA_CIPHERSUITE_PATTERN;
    private static final Pattern OPENSSL_AES_CBC_PATTERN;
    private static final Pattern OPENSSL_AES_PATTERN;
    private static final Pattern OPENSSL_CIPHERSUITE_PATTERN;
    private static final ConcurrentMap j2o;
    private static final Map j2oTls13;
    private static final InternalLogger logger;
    private static final ConcurrentMap o2j;
    private static final Map o2jTls13;

    static {
        CipherSuiteConverter.logger = InternalLoggerFactory.getInstance(CipherSuiteConverter.class);
        CipherSuiteConverter.JAVA_CIPHERSUITE_PATTERN = Pattern.compile("^(?:TLS|SSL)_((?:(?!_WITH_).)+)_WITH_(.*)_(.*)$");
        CipherSuiteConverter.OPENSSL_CIPHERSUITE_PATTERN = Pattern.compile("^(?:((?:(?:EXP-)?(?:(?:DHE|EDH|ECDH|ECDHE|SRP|RSA)-(?:DSS|RSA|ECDSA|PSK)|(?:ADH|AECDH|KRB5|PSK|SRP)))|EXP)-)?(.*)-(.*)$");
        CipherSuiteConverter.JAVA_AES_CBC_PATTERN = Pattern.compile("^(AES)_([0-9]+)_CBC$");
        CipherSuiteConverter.JAVA_AES_PATTERN = Pattern.compile("^(AES)_([0-9]+)_(.*)$");
        CipherSuiteConverter.OPENSSL_AES_CBC_PATTERN = Pattern.compile("^(AES)([0-9]+)$");
        CipherSuiteConverter.OPENSSL_AES_PATTERN = Pattern.compile("^(AES)([0-9]+)-(.*)$");
        CipherSuiteConverter.j2o = PlatformDependent.newConcurrentHashMap();
        CipherSuiteConverter.o2j = PlatformDependent.newConcurrentHashMap();
        HashMap hashMap0 = new HashMap();
        hashMap0.put("TLS_AES_128_GCM_SHA256", "AEAD-AES128-GCM-SHA256");
        hashMap0.put("TLS_AES_256_GCM_SHA384", "AEAD-AES256-GCM-SHA384");
        hashMap0.put("TLS_CHACHA20_POLY1305_SHA256", "AEAD-CHACHA20-POLY1305-SHA256");
        CipherSuiteConverter.j2oTls13 = Collections.unmodifiableMap(hashMap0);
        HashMap hashMap1 = new HashMap();
        hashMap1.put("TLS_AES_128_GCM_SHA256", Collections.singletonMap("TLS", "TLS_AES_128_GCM_SHA256"));
        hashMap1.put("TLS_AES_256_GCM_SHA384", Collections.singletonMap("TLS", "TLS_AES_256_GCM_SHA384"));
        hashMap1.put("TLS_CHACHA20_POLY1305_SHA256", Collections.singletonMap("TLS", "TLS_CHACHA20_POLY1305_SHA256"));
        hashMap1.put("AEAD-AES128-GCM-SHA256", Collections.singletonMap("TLS", "TLS_AES_128_GCM_SHA256"));
        hashMap1.put("AEAD-AES256-GCM-SHA384", Collections.singletonMap("TLS", "TLS_AES_256_GCM_SHA384"));
        hashMap1.put("AEAD-CHACHA20-POLY1305-SHA256", Collections.singletonMap("TLS", "TLS_CHACHA20_POLY1305_SHA256"));
        CipherSuiteConverter.o2jTls13 = Collections.unmodifiableMap(hashMap1);
    }

    private static String cacheFromJava(String s, boolean z) {
        String s1 = (String)CipherSuiteConverter.j2oTls13.get(s);
        if(s1 != null) {
            return z ? s1 : s;
        }
        String s2 = CipherSuiteConverter.toOpenSslUncached(s, z);
        CachedValue cipherSuiteConverter$CachedValue0 = CachedValue.of(s2);
        CipherSuiteConverter.j2o.putIfAbsent(s, cipherSuiteConverter$CachedValue0);
        if(s2 == null) {
            return null;
        }
        String s3 = s.substring(4);
        HashMap hashMap0 = new HashMap(4);
        hashMap0.put("", s3);
        hashMap0.put("SSL", "SSL_" + s3);
        hashMap0.put("TLS", "TLS_" + s3);
        CipherSuiteConverter.o2j.put(s2, hashMap0);
        CipherSuiteConverter.logger.debug("Cipher suite mapping: {} => {}", s, s2);
        return s2;
    }

    private static Map cacheFromOpenSsl(String s) {
        Map map0 = (Map)CipherSuiteConverter.o2jTls13.get(s);
        if(map0 != null) {
            return map0;
        }
        String s1 = CipherSuiteConverter.toJavaUncached0(s, false);
        if(s1 == null) {
            return null;
        }
        Map map1 = new HashMap(4);
        ((HashMap)map1).put("", s1);
        ((HashMap)map1).put("SSL", "SSL_" + s1);
        ((HashMap)map1).put("TLS", "TLS_" + s1);
        CipherSuiteConverter.o2j.putIfAbsent(s, map1);
        CachedValue cipherSuiteConverter$CachedValue0 = CachedValue.of(s);
        CipherSuiteConverter.j2o.putIfAbsent("TLS_" + s1, cipherSuiteConverter$CachedValue0);
        CipherSuiteConverter.j2o.putIfAbsent("SSL_" + s1, cipherSuiteConverter$CachedValue0);
        CipherSuiteConverter.logger.debug("Cipher suite mapping: {} => {}", "TLS_" + s1, s);
        CipherSuiteConverter.logger.debug("Cipher suite mapping: {} => {}", "SSL_" + s1, s);
        return map1;
    }

    public static void clearCache() {
        CipherSuiteConverter.j2o.clear();
        CipherSuiteConverter.o2j.clear();
    }

    public static void convertToCipherStrings(Iterable iterable0, StringBuilder stringBuilder0, StringBuilder stringBuilder1, boolean z) {
        for(Object object0: iterable0) {
            String s = (String)object0;
            if(s == null) {
                break;
            }
            String s1 = CipherSuiteConverter.toOpenSsl(s, z);
            if(s1 == null) {
                s1 = s;
            }
            if(!OpenSsl.isCipherSuiteAvailable(s1)) {
                throw new IllegalArgumentException("unsupported cipher suite: " + s + '(' + s1 + ')');
            }
            if(!SslUtils.isTLSv13Cipher(s1) && !SslUtils.isTLSv13Cipher(s)) {
                stringBuilder0.append(s1);
                stringBuilder0.append(':');
            }
            else {
                stringBuilder1.append(s1);
                stringBuilder1.append(':');
            }
        }
        if(stringBuilder0.length() == 0 && stringBuilder1.length() == 0) {
            throw new IllegalArgumentException("empty cipher suites");
        }
        if(stringBuilder0.length() > 0) {
            stringBuilder0.setLength(stringBuilder0.length() - 1);
        }
        if(stringBuilder1.length() > 0) {
            stringBuilder1.setLength(stringBuilder1.length() - 1);
        }
    }

    public static boolean isJ2OCached(String s, String s1) {
        CachedValue cipherSuiteConverter$CachedValue0 = (CachedValue)CipherSuiteConverter.j2o.get(s);
        return cipherSuiteConverter$CachedValue0 != null && s1.equals(cipherSuiteConverter$CachedValue0.value);
    }

    public static boolean isO2JCached(String s, String s1, String s2) {
        Map map0 = (Map)CipherSuiteConverter.o2j.get(s);
        return map0 == null ? false : s2.equals(map0.get(s1));
    }

    public static String toJava(String s, String s1) {
        Map map0 = (Map)CipherSuiteConverter.o2j.get(s);
        if(map0 == null) {
            map0 = CipherSuiteConverter.cacheFromOpenSsl(s);
            if(map0 == null) {
                return null;
            }
        }
        String s2 = (String)map0.get(s1);
        if(s2 == null) {
            String s3 = (String)map0.get("");
            return s3 == null ? null : s1 + '_' + s3;
        }
        return s2;
    }

    private static String toJavaBulkCipher(String s, boolean z) {
        if(s.startsWith("AES")) {
            Matcher matcher0 = CipherSuiteConverter.OPENSSL_AES_CBC_PATTERN.matcher(s);
            if(matcher0.matches()) {
                return matcher0.replaceFirst("$1_$2_CBC");
            }
            Matcher matcher1 = CipherSuiteConverter.OPENSSL_AES_PATTERN.matcher(s);
            if(matcher1.matches()) {
                return matcher1.replaceFirst("$1_$2_$3");
            }
        }
        if("DES-CBC3".equals(s)) {
            return "3DES_EDE_CBC";
        }
        if("RC4".equals(s)) {
            return z ? "RC4_40" : "RC4_128";
        }
        if("DES-CBC".equals(s)) {
            return z ? "DES_CBC_40" : "DES_CBC";
        }
        if("RC2-CBC".equals(s)) {
            return z ? "RC2_CBC_40" : "RC2_CBC";
        }
        return s.replace('-', '_');
    }

    private static String toJavaHandshakeAlgo(String s, boolean z) {
        if(s.isEmpty()) {
            s = "RSA";
        }
        else if("ADH".equals(s)) {
            s = "DH_anon";
        }
        else if("AECDH".equals(s)) {
            s = "ECDH_anon";
        }
        String s1 = s.replace('-', '_');
        return z ? s1 + "_EXPORT" : s1;
    }

    private static String toJavaHmacAlgo(String s) {
        return s;
    }

    public static String toJavaUncached(String s) {
        return CipherSuiteConverter.toJavaUncached0(s, true);
    }

    private static String toJavaUncached0(String s, boolean z) {
        if(z) {
            Map map0 = (Map)CipherSuiteConverter.o2jTls13.get(s);
            if(map0 != null) {
                return (String)map0.get("TLS");
            }
        }
        Matcher matcher0 = CipherSuiteConverter.OPENSSL_CIPHERSUITE_PATTERN.matcher(s);
        if(!matcher0.matches()) {
            return null;
        }
        boolean z1 = true;
        String s1 = matcher0.group(1);
        if(s1 == null) {
            z1 = false;
            s1 = "";
        }
        else if(s1.startsWith("EXP-")) {
            s1 = s1.substring(4);
        }
        else if("EXP".equals(s1)) {
            s1 = "";
        }
        else {
            z1 = false;
        }
        String s2 = CipherSuiteConverter.toJavaHandshakeAlgo(s1, z1);
        String s3 = CipherSuiteConverter.toJavaBulkCipher(matcher0.group(2), z1);
        String s4 = s2 + "_WITH_" + s3 + '_' + CipherSuiteConverter.toJavaHmacAlgo(matcher0.group(3));
        return s3.contains("CHACHA20") ? s4 + "_SHA256" : s4;
    }

    public static String toOpenSsl(String s, boolean z) {
        CachedValue cipherSuiteConverter$CachedValue0 = (CachedValue)CipherSuiteConverter.j2o.get(s);
        return cipherSuiteConverter$CachedValue0 == null ? CipherSuiteConverter.cacheFromJava(s, z) : cipherSuiteConverter$CachedValue0.value;
    }

    private static String toOpenSslBulkCipher(String s) {
        if(s.startsWith("AES_")) {
            Matcher matcher0 = CipherSuiteConverter.JAVA_AES_CBC_PATTERN.matcher(s);
            if(matcher0.matches()) {
                return matcher0.replaceFirst("$1$2");
            }
            Matcher matcher1 = CipherSuiteConverter.JAVA_AES_PATTERN.matcher(s);
            if(matcher1.matches()) {
                return matcher1.replaceFirst("$1$2-$3");
            }
        }
        if("3DES_EDE_CBC".equals(s)) {
            return "DES-CBC3";
        }
        if(!"RC4_128".equals(s) && !"RC4_40".equals(s)) {
            if(!"DES40_CBC".equals(s) && !"DES_CBC_40".equals(s)) {
                return "RC2_CBC_40".equals(s) ? "RC2-CBC" : s.replace('_', '-');
            }
            return "DES-CBC";
        }
        return "RC4";
    }

    private static String toOpenSslHandshakeAlgo(String s) {
        boolean z = s.endsWith("_EXPORT");
        if(z) {
            s = b.d(7, 0, s);
        }
        if("RSA".equals(s)) {
            s = "";
        }
        else if(s.endsWith("_anon")) {
            s = "A" + s.substring(0, s.length() - 5);
        }
        if(z) {
            if(s.isEmpty()) {
                return "EXP";
            }
            s = "EXP-" + s;
        }
        return s.replace('_', '-');
    }

    private static String toOpenSslHmacAlgo(String s) {
        return s;
    }

    public static String toOpenSslUncached(String s, boolean z) {
        String s1 = (String)CipherSuiteConverter.j2oTls13.get(s);
        if(s1 != null) {
            return z ? s1 : s;
        }
        Matcher matcher0 = CipherSuiteConverter.JAVA_CIPHERSUITE_PATTERN.matcher(s);
        if(!matcher0.matches()) {
            return null;
        }
        String s2 = CipherSuiteConverter.toOpenSslHandshakeAlgo(matcher0.group(1));
        String s3 = CipherSuiteConverter.toOpenSslBulkCipher(matcher0.group(2));
        String s4 = CipherSuiteConverter.toOpenSslHmacAlgo(matcher0.group(3));
        if(s2.isEmpty()) {
            return s3 + '-' + s4;
        }
        return s3.contains("CHACHA20") ? s2 + '-' + s3 : s2 + '-' + s3 + '-' + s4;
    }
}

