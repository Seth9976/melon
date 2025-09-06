package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;

@Deprecated
public class DomainNameMapping implements Mapping {
    final Object defaultValue;
    private final Map map;
    private final Map unmodifiableMap;

    @Deprecated
    public DomainNameMapping(int v, Object object0) {
        this(new LinkedHashMap(v), object0);
    }

    @Deprecated
    public DomainNameMapping(Object object0) {
        this(4, object0);
    }

    public DomainNameMapping(Map map0, Object object0) {
        this.defaultValue = ObjectUtil.checkNotNull(object0, "defaultValue");
        this.map = map0;
        this.unmodifiableMap = map0 == null ? null : Collections.unmodifiableMap(map0);
    }

    @Deprecated
    public DomainNameMapping add(String s, Object object0) {
        String s1 = DomainNameMapping.normalizeHostname(((String)ObjectUtil.checkNotNull(s, "hostname")));
        Object object1 = ObjectUtil.checkNotNull(object0, "output");
        this.map.put(s1, object1);
        return this;
    }

    public Map asMap() {
        return this.unmodifiableMap;
    }

    @Override  // io.netty.util.Mapping
    public Object map(Object object0) {
        return this.map(((String)object0));
    }

    public Object map(String s) {
        if(s != null) {
            String s1 = DomainNameMapping.normalizeHostname(s);
            for(Object object0: this.map.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(DomainNameMapping.matches(((String)map$Entry0.getKey()), s1)) {
                    return map$Entry0.getValue();
                }
                if(false) {
                    break;
                }
            }
        }
        return this.defaultValue;
    }

    // 去混淆评级： 低(40)
    public static boolean matches(String s, String s1) {
        return s.startsWith("*.") ? s.regionMatches(2, s1, 0, s1.length()) || StringUtil.commonSuffixOfLength(s1, s, s.length() - 1) : s.equals(s1);
    }

    private static boolean needsNormalization(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            if(s.charAt(v1) > 0x7F) {
                return true;
            }
        }
        return false;
    }

    public static String normalizeHostname(String s) {
        if(DomainNameMapping.needsNormalization(s)) {
            s = IDN.toASCII(s, 1);
        }
        return s.toLowerCase(Locale.US);
    }

    @Override
    public String toString() {
        return StringUtil.simpleClassName(this) + "(default: " + this.defaultValue + ", map: " + this.map + ')';
    }
}

