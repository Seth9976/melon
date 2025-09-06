package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader implements ModelLoader {
    public static class ByteBufferFactory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new ByteArrayLoader(new Converter() {
                @Override  // com.bumptech.glide.load.model.ByteArrayLoader$Converter
                public Object convert(byte[] arr_b) {
                    return this.convert(arr_b);
                }

                public ByteBuffer convert(byte[] arr_b) {
                    return ByteBuffer.wrap(arr_b);
                }

                @Override  // com.bumptech.glide.load.model.ByteArrayLoader$Converter
                public Class getDataClass() {
                    return ByteBuffer.class;
                }
            });
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public interface Converter {
        Object convert(byte[] arg1);

        Class getDataClass();
    }

    static class Fetcher implements DataFetcher {
        private final Converter converter;
        private final byte[] model;

        public Fetcher(byte[] arr_b, Converter byteArrayLoader$Converter0) {
            this.model = arr_b;
            this.converter = byteArrayLoader$Converter0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return this.converter.getDataClass();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            dataFetcher$DataCallback0.onDataReady(this.converter.convert(this.model));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new ByteArrayLoader(new Converter() {
                public InputStream convert(byte[] arr_b) {
                    return new ByteArrayInputStream(arr_b);
                }

                @Override  // com.bumptech.glide.load.model.ByteArrayLoader$Converter
                public Object convert(byte[] arr_b) {
                    return this.convert(arr_b);
                }

                @Override  // com.bumptech.glide.load.model.ByteArrayLoader$Converter
                public Class getDataClass() {
                    return InputStream.class;
                }
            });
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private final Converter converter;

    public ByteArrayLoader(Converter byteArrayLoader$Converter0) {
        this.converter = byteArrayLoader$Converter0;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((byte[])object0), v, v1, options0);
    }

    public LoadData buildLoadData(byte[] arr_b, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(arr_b), new Fetcher(arr_b, this.converter));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((byte[])object0));
    }

    public boolean handles(byte[] arr_b) {
        return true;
    }
}

