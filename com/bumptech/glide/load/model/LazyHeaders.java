package com.bumptech.glide.load.model;

import U4.x;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public final class LazyHeaders implements Headers {
    public static final class Builder {
        private static final Map DEFAULT_HEADERS = null;
        private static final String DEFAULT_USER_AGENT = null;
        private static final String USER_AGENT_HEADER = "User-Agent";
        private boolean copyOnModify;
        private Map headers;
        private boolean isUserAgentDefault;

        static {
            Builder.DEFAULT_USER_AGENT = "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)";
            HashMap hashMap0 = new HashMap(2);
            if(!TextUtils.isEmpty("Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)")) {
                hashMap0.put("User-Agent", Collections.singletonList(new StringHeaderFactory("Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)")));
            }
            Builder.DEFAULT_HEADERS = Collections.unmodifiableMap(hashMap0);
        }

        public Builder() {
            this.copyOnModify = true;
            this.headers = Builder.DEFAULT_HEADERS;
            this.isUserAgentDefault = true;
        }

        public Builder addHeader(String s, LazyHeaderFactory lazyHeaderFactory0) {
            if(this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(s)) {
                return this.setHeader(s, lazyHeaderFactory0);
            }
            this.copyIfNecessary();
            this.getFactories(s).add(lazyHeaderFactory0);
            return this;
        }

        public Builder addHeader(String s, String s1) {
            return this.addHeader(s, new StringHeaderFactory(s1));
        }

        public LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }

        private Map copyHeaders() {
            Map map0 = new HashMap(this.headers.size());
            for(Object object0: this.headers.entrySet()) {
                ArrayList arrayList0 = new ArrayList(((Collection)((Map.Entry)object0).getValue()));
                ((HashMap)map0).put(((Map.Entry)object0).getKey(), arrayList0);
            }
            return map0;
        }

        private void copyIfNecessary() {
            if(this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = this.copyHeaders();
            }
        }

        private List getFactories(String s) {
            List list0 = (List)this.headers.get(s);
            if(list0 == null) {
                list0 = new ArrayList();
                this.headers.put(s, list0);
            }
            return list0;
        }

        public static String getSanitizedUserAgent() {
            if(TextUtils.isEmpty("Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)")) {
                return "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)";
            }
            StringBuilder stringBuilder0 = new StringBuilder(67);
            for(int v = 0; v < 67; ++v) {
                int v1 = "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)".charAt(v);
                if(v1 <= 0x1F && v1 != 9 || v1 >= 0x7F) {
                    stringBuilder0.append('?');
                }
                else {
                    stringBuilder0.append(((char)v1));
                }
            }
            return "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 4a Build/TQ2A.230405.003)";
        }

        public Builder setHeader(String s, LazyHeaderFactory lazyHeaderFactory0) {
            this.copyIfNecessary();
            if(lazyHeaderFactory0 == null) {
                this.headers.remove(s);
            }
            else {
                List list0 = this.getFactories(s);
                list0.clear();
                list0.add(lazyHeaderFactory0);
            }
            if(this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(s)) {
                this.isUserAgentDefault = false;
            }
            return this;
        }

        public Builder setHeader(String s, String s1) {
            return s1 == null ? this.setHeader(s, null) : this.setHeader(s, new StringHeaderFactory(s1));
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String value;

        public StringHeaderFactory(String s) {
            this.value = s;
        }

        @Override  // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.value;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            return object0 instanceof StringHeaderFactory ? this.value.equals(((StringHeaderFactory)object0).value) : false;
        }

        @Override
        public int hashCode() {
            return this.value.hashCode();
        }

        @Override
        public String toString() {
            return x.m(new StringBuilder("StringHeaderFactory{value=\'"), this.value, "\'}");
        }
    }

    private volatile Map combinedHeaders;
    private final Map headers;

    public LazyHeaders(Map map0) {
        this.headers = Collections.unmodifiableMap(map0);
    }

    private String buildHeaderValue(List list0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = ((LazyHeaderFactory)list0.get(v1)).buildHeader();
            if(!TextUtils.isEmpty(s)) {
                stringBuilder0.append(s);
                if(v1 != list0.size() - 1) {
                    stringBuilder0.append(',');
                }
            }
        }
        return stringBuilder0.toString();
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof LazyHeaders ? this.headers.equals(((LazyHeaders)object0).headers) : false;
    }

    private Map generateHeaders() {
        Map map0 = new HashMap();
        for(Object object0: this.headers.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            String s = this.buildHeaderValue(((List)map$Entry0.getValue()));
            if(!TextUtils.isEmpty(s)) {
                ((HashMap)map0).put(map$Entry0.getKey(), s);
            }
        }
        return map0;
    }

    @Override  // com.bumptech.glide.load.model.Headers
    public Map getHeaders() {
        if(this.combinedHeaders == null) {
            synchronized(this) {
                if(this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap(this.generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }

    @Override
    public int hashCode() {
        return this.headers.hashCode();
    }

    @Override
    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }
}

