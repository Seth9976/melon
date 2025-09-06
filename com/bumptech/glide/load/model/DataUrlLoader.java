package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader implements ModelLoader {
    public interface DataDecoder {
        void close(Object arg1);

        Object decode(String arg1);

        Class getDataClass();
    }

    static final class DataUriFetcher implements DataFetcher {
        private Object data;
        private final String dataUri;
        private final DataDecoder reader;

        public DataUriFetcher(String s, DataDecoder dataUrlLoader$DataDecoder0) {
            this.dataUri = s;
            this.reader = dataUrlLoader$DataDecoder0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            try {
                this.reader.close(this.data);
            }
            catch(IOException unused_ex) {
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return this.reader.getDataClass();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            try {
                Object object0 = this.reader.decode(this.dataUri);
                this.data = object0;
                dataFetcher$DataCallback0.onDataReady(object0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                dataFetcher$DataCallback0.onLoadFailed(illegalArgumentException0);
            }
        }
    }

    public static final class StreamFactory implements ModelLoaderFactory {
        private final DataDecoder opener;

        public StreamFactory() {
            this.opener = new DataDecoder() {
                public void close(InputStream inputStream0) {
                    inputStream0.close();
                }

                @Override  // com.bumptech.glide.load.model.DataUrlLoader$DataDecoder
                public void close(Object object0) {
                    this.close(((InputStream)object0));
                }

                public InputStream decode(String s) {
                    if(!s.startsWith("data:image")) {
                        throw new IllegalArgumentException("Not a valid image data URL.");
                    }
                    int v = s.indexOf(44);
                    if(v == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    }
                    if(!s.substring(0, v).endsWith(";base64")) {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    return new ByteArrayInputStream(Base64.decode(s.substring(v + 1), 0));
                }

                @Override  // com.bumptech.glide.load.model.DataUrlLoader$DataDecoder
                public Object decode(String s) {
                    return this.decode(s);
                }

                @Override  // com.bumptech.glide.load.model.DataUrlLoader$DataDecoder
                public Class getDataClass() {
                    return InputStream.class;
                }
            };
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new DataUrlLoader(this.opener);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private static final String BASE64_TAG = ";base64";
    private static final String DATA_SCHEME_IMAGE = "data:image";
    private final DataDecoder dataDecoder;

    public DataUrlLoader(DataDecoder dataUrlLoader$DataDecoder0) {
        this.dataDecoder = dataUrlLoader$DataDecoder0;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(object0), new DataUriFetcher(object0.toString(), this.dataDecoder));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return object0.toString().startsWith("data:image");
    }
}

