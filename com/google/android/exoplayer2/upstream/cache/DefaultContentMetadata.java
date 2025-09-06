package com.google.android.exoplayer2.upstream.cache;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class DefaultContentMetadata implements ContentMetadata {
    public static final DefaultContentMetadata EMPTY;
    private int hashCode;
    private final Map metadata;

    static {
        DefaultContentMetadata.EMPTY = new DefaultContentMetadata(Collections.EMPTY_MAP);
    }

    public DefaultContentMetadata() {
        this(Collections.EMPTY_MAP);
    }

    public DefaultContentMetadata(Map map0) {
        this.metadata = Collections.unmodifiableMap(map0);
    }

    private static void addValues(HashMap hashMap0, Map map0) {
        for(Object object0: map0.keySet()) {
            hashMap0.put(((String)object0), DefaultContentMetadata.getBytes(map0.get(((String)object0))));
        }
    }

    private static Map applyMutations(Map map0, ContentMetadataMutations contentMetadataMutations0) {
        Map map1 = new HashMap(map0);
        DefaultContentMetadata.removeValues(((HashMap)map1), contentMetadataMutations0.getRemovedValues());
        DefaultContentMetadata.addValues(((HashMap)map1), contentMetadataMutations0.getEditedValues());
        return map1;
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final boolean contains(String s) {
        return this.metadata.containsKey(s);
    }

    public DefaultContentMetadata copyWithMutationsApplied(ContentMetadataMutations contentMetadataMutations0) {
        Map map0 = DefaultContentMetadata.applyMutations(this.metadata, contentMetadataMutations0);
        return DefaultContentMetadata.isMetadataEqual(this.metadata, map0) ? this : new DefaultContentMetadata(map0);
    }

    public Set entrySet() {
        return this.metadata.entrySet();
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return DefaultContentMetadata.class == class0 ? DefaultContentMetadata.isMetadataEqual(this.metadata, ((DefaultContentMetadata)object0).metadata) : false;
        }
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final long get(String s, long v) {
        return this.metadata.containsKey(s) ? ByteBuffer.wrap(((byte[])this.metadata.get(s))).getLong() : v;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final String get(String s, String s1) {
        return this.metadata.containsKey(s) ? new String(((byte[])this.metadata.get(s)), Charset.forName("UTF-8")) : s1;
    }

    @Override  // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final byte[] get(String s, byte[] arr_b) {
        if(this.metadata.containsKey(s)) {
            byte[] arr_b1 = (byte[])this.metadata.get(s);
            return Arrays.copyOf(arr_b1, arr_b1.length);
        }
        return arr_b;
    }

    private static byte[] getBytes(Object object0) {
        if(object0 instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((long)(((Long)object0)))).array();
        }
        if(object0 instanceof String) {
            return ((String)object0).getBytes(Charset.forName("UTF-8"));
        }
        if(!(object0 instanceof byte[])) {
            throw new IllegalArgumentException();
        }
        return (byte[])object0;
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            int v = 0;
            for(Object object0: this.metadata.entrySet()) {
                int v1 = ((String)((Map.Entry)object0).getKey()).hashCode();
                v += Arrays.hashCode(((byte[])((Map.Entry)object0).getValue())) ^ v1;
            }
            this.hashCode = v;
        }
        return this.hashCode;
    }

    private static boolean isMetadataEqual(Map map0, Map map1) {
        if(map0.size() != map1.size()) {
            return false;
        }
        for(Object object0: map0.entrySet()) {
            if(!Arrays.equals(((byte[])((Map.Entry)object0).getValue()), ((byte[])map1.get(((Map.Entry)object0).getKey())))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    private static void removeValues(HashMap hashMap0, List list0) {
        for(int v = 0; v < list0.size(); ++v) {
            hashMap0.remove(list0.get(v));
        }
    }
}

