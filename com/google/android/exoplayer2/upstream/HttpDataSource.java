package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface HttpDataSource extends DataSource {
    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties;

        public BaseFactory() {
            this.defaultRequestProperties = new RequestProperties();
        }

        @Override  // com.google.android.exoplayer2.upstream.HttpDataSource$Factory
        @Deprecated
        public final void clearAllDefaultRequestProperties() {
            this.defaultRequestProperties.clear();
        }

        @Override  // com.google.android.exoplayer2.upstream.HttpDataSource$Factory
        @Deprecated
        public final void clearDefaultRequestProperty(String s) {
            this.defaultRequestProperties.remove(s);
        }

        @Override  // com.google.android.exoplayer2.upstream.HttpDataSource$Factory
        public DataSource createDataSource() {
            return this.createDataSource();
        }

        @Override  // com.google.android.exoplayer2.upstream.HttpDataSource$Factory
        public final HttpDataSource createDataSource() {
            return this.createDataSourceInternal(this.defaultRequestProperties);
        }

        public abstract HttpDataSource createDataSourceInternal(RequestProperties arg1);

        @Override  // com.google.android.exoplayer2.upstream.HttpDataSource$Factory
        public final RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        @Override  // com.google.android.exoplayer2.upstream.HttpDataSource$Factory
        @Deprecated
        public final void setDefaultRequestProperty(String s, String s1) {
            this.defaultRequestProperties.set(s, s1);
        }
    }

    public interface Factory extends com.google.android.exoplayer2.upstream.DataSource.Factory {
        @Deprecated
        void clearAllDefaultRequestProperties();

        @Deprecated
        void clearDefaultRequestProperty(String arg1);

        @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
        default DataSource createDataSource() {
            return this.createDataSource();
        }

        HttpDataSource createDataSource();

        RequestProperties getDefaultRequestProperties();

        @Deprecated
        void setDefaultRequestProperty(String arg1, String arg2);
    }

    public static class HttpDataSourceException extends IOException {
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        public HttpDataSourceException(DataSpec dataSpec0, int v) {
            this.dataSpec = dataSpec0;
            this.type = v;
        }

        public HttpDataSourceException(IOException iOException0, DataSpec dataSpec0, int v) {
            super(iOException0);
            this.dataSpec = dataSpec0;
            this.type = v;
        }

        public HttpDataSourceException(String s, DataSpec dataSpec0, int v) {
            super(s);
            this.dataSpec = dataSpec0;
            this.type = v;
        }

        public HttpDataSourceException(String s, IOException iOException0, DataSpec dataSpec0, int v) {
            super(s, iOException0);
            this.dataSpec = dataSpec0;
            this.type = v;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String s, DataSpec dataSpec0) {
            String s1 = String.valueOf(s);
            super((s1.length() == 0 ? new String("Invalid content type: ") : "Invalid content type: " + s1), dataSpec0, 1);
            this.contentType = s;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map headerFields;
        public final int responseCode;
        public final String responseMessage;

        public InvalidResponseCodeException(int v, String s, Map map0, DataSpec dataSpec0) {
            super("Response code: " + v, dataSpec0, 1);
            this.responseCode = v;
            this.responseMessage = s;
            this.headerFields = map0;
        }

        @Deprecated
        public InvalidResponseCodeException(int v, Map map0, DataSpec dataSpec0) {
            this(v, null, map0, dataSpec0);
        }
    }

    public static final class RequestProperties {
        private final Map requestProperties;
        private Map requestPropertiesSnapshot;

        public RequestProperties() {
            this.requestProperties = new HashMap();
        }

        public void clear() {
            synchronized(this) {
                this.requestPropertiesSnapshot = null;
                this.requestProperties.clear();
            }
        }

        public void clearAndSet(Map map0) {
            synchronized(this) {
                this.requestPropertiesSnapshot = null;
                this.requestProperties.clear();
                this.requestProperties.putAll(map0);
            }
        }

        public Map getSnapshot() {
            synchronized(this) {
                if(this.requestPropertiesSnapshot == null) {
                    this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
                }
                return this.requestPropertiesSnapshot;
            }
        }

        public void remove(String s) {
            synchronized(this) {
                this.requestPropertiesSnapshot = null;
                this.requestProperties.remove(s);
            }
        }

        public void set(String s, String s1) {
            synchronized(this) {
                this.requestPropertiesSnapshot = null;
                this.requestProperties.put(s, s1);
            }
        }

        public void set(Map map0) {
            synchronized(this) {
                this.requestPropertiesSnapshot = null;
                this.requestProperties.putAll(map0);
            }
        }
    }

    public static final Predicate REJECT_PAYWALL_TYPES;

    static {
        HttpDataSource.REJECT_PAYWALL_TYPES = new b(29);
    }

    static boolean a(String s) {
        return HttpDataSource.lambda$static$0(s);
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String arg1);

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    void close();

    int getResponseCode();

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    Map getResponseHeaders();

    // 去混淆评级： 低(25)
    private static boolean lambda$static$0(String s) {
        String s1 = Util.toLowerInvariant(s);
        return !TextUtils.isEmpty(s1) && (!s1.contains("text") || s1.contains("text/vtt")) && !s1.contains("html") && !s1.contains("xml");
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    long open(DataSpec arg1);

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    int read(byte[] arg1, int arg2, int arg3);

    void setRequestProperty(String arg1, String arg2);
}

