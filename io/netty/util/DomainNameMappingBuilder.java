package io.netty.util;

import b3.Z;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

@Deprecated
public final class DomainNameMappingBuilder {
    static final class ImmutableDomainNameMapping extends DomainNameMapping {
        private static final int REPR_CONST_PART_LENGTH = 46;
        private static final String REPR_HEADER = "ImmutableDomainNameMapping(default: ";
        private static final String REPR_MAP_CLOSING = "})";
        private static final String REPR_MAP_OPENING = ", map: {";
        private final String[] domainNamePatterns;
        private final Map map;
        private final Object[] values;

        private ImmutableDomainNameMapping(Object object0, Map map0) {
            super(null, object0);
            Set set0 = map0.entrySet();
            int v = set0.size();
            this.domainNamePatterns = new String[v];
            this.values = new Object[v];
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(map0.size());
            int v1 = 0;
            for(Object object1: set0) {
                String s = DomainNameMapping.normalizeHostname(((String)((Map.Entry)object1).getKey()));
                Object object2 = ((Map.Entry)object1).getValue();
                this.domainNamePatterns[v1] = s;
                this.values[v1] = object2;
                linkedHashMap0.put(s, object2);
                ++v1;
            }
            this.map = Collections.unmodifiableMap(linkedHashMap0);
        }

        public ImmutableDomainNameMapping(Object object0, Map map0, io.netty.util.DomainNameMappingBuilder.1 domainNameMappingBuilder$10) {
            this(object0, map0);
        }

        @Override  // io.netty.util.DomainNameMapping
        @Deprecated
        public DomainNameMapping add(String s, Object object0) {
            throw new UnsupportedOperationException("Immutable DomainNameMapping does not support modification after initial creation");
        }

        private StringBuilder appendMapping(StringBuilder stringBuilder0, int v) {
            return ImmutableDomainNameMapping.appendMapping(stringBuilder0, this.domainNamePatterns[v], this.values[v].toString());
        }

        private static StringBuilder appendMapping(StringBuilder stringBuilder0, String s, String s1) {
            stringBuilder0.append(s);
            stringBuilder0.append('=');
            stringBuilder0.append(s1);
            return stringBuilder0;
        }

        @Override  // io.netty.util.DomainNameMapping
        public Map asMap() {
            return this.map;
        }

        private static int estimateBufferSize(int v, int v1, int v2) {
            return ImmutableDomainNameMapping.REPR_CONST_PART_LENGTH + v + ((int)(((double)(v2 * v1)) * 1.1));
        }

        @Override  // io.netty.util.DomainNameMapping
        public Object map(Object object0) {
            return this.map(((String)object0));
        }

        @Override  // io.netty.util.DomainNameMapping
        public Object map(String s) {
            if(s != null) {
                String s1 = DomainNameMapping.normalizeHostname(s);
                for(int v = 0; v < this.domainNamePatterns.length; ++v) {
                    if(DomainNameMapping.matches(this.domainNamePatterns[v], s1)) {
                        return this.values[v];
                    }
                }
            }
            return this.defaultValue;
        }

        @Override  // io.netty.util.DomainNameMapping
        public String toString() {
            String s = this.defaultValue.toString();
            String[] arr_s = this.domainNamePatterns;
            if(arr_s.length == 0) {
                return "ImmutableDomainNameMapping(default: " + s + ", map: {})";
            }
            String s1 = arr_s[0];
            String s2 = this.values[0].toString();
            StringBuilder stringBuilder0 = new StringBuilder(ImmutableDomainNameMapping.estimateBufferSize(s.length(), arr_s.length, Z.d(s1.length(), 3, s2)));
            stringBuilder0.append("ImmutableDomainNameMapping(default: ");
            stringBuilder0.append(s);
            stringBuilder0.append(", map: {");
            ImmutableDomainNameMapping.appendMapping(stringBuilder0, s1, s2);
            for(int v = 1; v < arr_s.length; ++v) {
                stringBuilder0.append(", ");
                this.appendMapping(stringBuilder0, v);
            }
            stringBuilder0.append("})");
            return stringBuilder0.toString();
        }
    }

    private final Object defaultValue;
    private final Map map;

    public DomainNameMappingBuilder(int v, Object object0) {
        this.defaultValue = ObjectUtil.checkNotNull(object0, "defaultValue");
        this.map = new LinkedHashMap(v);
    }

    public DomainNameMappingBuilder(Object object0) {
        this(4, object0);
    }

    public DomainNameMappingBuilder add(String s, Object object0) {
        Object object1 = ObjectUtil.checkNotNull(s, "hostname");
        Object object2 = ObjectUtil.checkNotNull(object0, "output");
        this.map.put(object1, object2);
        return this;
    }

    public DomainNameMapping build() {
        return new ImmutableDomainNameMapping(this.defaultValue, this.map, null);
    }

    class io.netty.util.DomainNameMappingBuilder.1 {
    }

}

