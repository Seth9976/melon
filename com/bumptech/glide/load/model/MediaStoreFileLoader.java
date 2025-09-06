package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import jeb.synthetic.TWR;

public final class MediaStoreFileLoader implements ModelLoader {
    public static final class Factory implements ModelLoaderFactory {
        private final Context context;

        public Factory(Context context0) {
            this.context = context0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new MediaStoreFileLoader(this.context);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    static class FilePathFetcher implements DataFetcher {
        private static final String[] PROJECTION;
        private final Context context;
        private final Uri uri;

        static {
            FilePathFetcher.PROJECTION = new String[]{"_data"};
        }

        public FilePathFetcher(Context context0, Uri uri0) {
            this.context = context0;
            this.uri = uri0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return File.class;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            Cursor cursor0 = this.context.getContentResolver().query(this.uri, FilePathFetcher.PROJECTION, null, null, null);
            CharSequence charSequence0 = null;
            if(cursor0 != null) {
                try {
                    if(cursor0.moveToFirst()) {
                        charSequence0 = cursor0.getString(cursor0.getColumnIndexOrThrow("_data"));
                    }
                }
                catch(Throwable throwable0) {
                    TWR.safeClose$NT(cursor0, throwable0);
                    throw throwable0;
                }
                cursor0.close();
            }
            if(TextUtils.isEmpty(charSequence0)) {
                dataFetcher$DataCallback0.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.uri));
                return;
            }
            dataFetcher$DataCallback0.onDataReady(new File(((String)charSequence0)));
        }
    }

    private final Context context;

    public MediaStoreFileLoader(Context context0) {
        this.context = context0;
    }

    public LoadData buildLoadData(Uri uri0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(uri0), new FilePathFetcher(this.context, uri0));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Uri)object0), v, v1, options0);
    }

    public boolean handles(Uri uri0) {
        return MediaStoreUtil.isMediaStoreUri(uri0);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Uri)object0));
    }
}

