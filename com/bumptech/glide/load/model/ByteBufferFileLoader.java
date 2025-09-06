package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader {
    static final class ByteBufferFetcher implements DataFetcher {
        private final File file;

        public ByteBufferFetcher(File file0) {
            this.file = file0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return ByteBuffer.class;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            try {
                dataFetcher$DataCallback0.onDataReady(ByteBufferUtil.fromFile(this.file));
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", iOException0);
                }
                dataFetcher$DataCallback0.onLoadFailed(iOException0);
            }
        }
    }

    public static class Factory implements ModelLoaderFactory {
        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new ByteBufferFileLoader();
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    private static final String TAG = "ByteBufferFileLoader";

    public LoadData buildLoadData(File file0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(file0), new ByteBufferFetcher(file0));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((File)object0), v, v1, options0);
    }

    public boolean handles(File file0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((File)object0));
    }
}

