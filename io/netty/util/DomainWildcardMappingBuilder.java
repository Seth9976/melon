package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import k8.Y;

public class DomainWildcardMappingBuilder {
    static final class ImmutableDomainWildcardMapping implements Mapping {
        private static final String REPR_HEADER = "ImmutableDomainWildcardMapping(default: ";
        private static final String REPR_MAP_CLOSING = ")";
        private static final String REPR_MAP_OPENING = ", map: ";
        private final Object defaultValue;
        private final Map map;

        public ImmutableDomainWildcardMapping(Object object0, Map map0) {
            this.defaultValue = object0;
            this.map = new LinkedHashMap(map0);
        }

        @Override  // io.netty.util.Mapping
        public Object map(Object object0) {
            return this.map(((String)object0));
        }

        public Object map(String s) {
            if(s != null) {
                String s1 = ImmutableDomainWildcardMapping.normalize(s);
                Object object0 = this.map.get(s1);
                if(object0 != null) {
                    return object0;
                }
                int v = s1.indexOf(46);
                if(v != -1) {
                    Object object1 = this.map.get(s1.substring(v));
                    return object1 == null ? this.defaultValue : object1;
                }
            }
            return this.defaultValue;
        }

        public static String normalize(String s) {
            return DomainNameMapping.normalizeHostname(s);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder0 = Y.p("ImmutableDomainWildcardMapping(default: ");
            stringBuilder0.append(this.defaultValue);
            stringBuilder0.append(", map: {");
            for(Object object0: this.map.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                if(s.charAt(0) == 46) {
                    s = "*" + s;
                }
                stringBuilder0.append(s);
                stringBuilder0.append('=');
                stringBuilder0.append(((Map.Entry)object0).getValue());
                stringBuilder0.append(", ");
            }
            stringBuilder0.setLength(stringBuilder0.length() - 2);
            stringBuilder0.append('}');
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    private final Object defaultValue;
    private final Map map;

    public DomainWildcardMappingBuilder(int v, Object object0) {
        this.defaultValue = ObjectUtil.checkNotNull(object0, "defaultValue");
        this.map = new LinkedHashMap(v);
    }

    public DomainWildcardMappingBuilder(Object object0) {
        this(4, object0);
    }

    public DomainWildcardMappingBuilder add(String s, Object object0) {
        String s1 = this.normalizeHostName(s);
        Object object1 = ObjectUtil.checkNotNull(object0, "output");
        this.map.put(s1, object1);
        return this;
    }

    public Mapping build() {
        return new ImmutableDomainWildcardMapping(this.defaultValue, this.map);
    }

    private String normalizeHostName(String s) {
        ObjectUtil.checkNotNull(s, "hostname");
        if(s.isEmpty() || s.charAt(0) == 46) {
            throw new IllegalArgumentException("Hostname \'" + s + "\' not valid");
        }
        String s1 = ImmutableDomainWildcardMapping.normalize(((String)ObjectUtil.checkNotNull(s, "hostname")));
        if(s1.charAt(0) == 42) {
            if(s1.length() < 3 || s1.charAt(1) != 46) {
                throw new IllegalArgumentException("Wildcard Hostname \'" + s1 + "\'not valid");
            }
            return s1.substring(1);
        }
        return s1;
    }
}

