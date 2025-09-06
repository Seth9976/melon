package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class QMediaStoreUriLoader implements ModelLoader {
    static abstract class Factory implements ModelLoaderFactory {
        private final Context context;
        private final Class dataClass;

        public Factory(Context context0, Class class0) {
            this.context = context0;
            this.dataClass = class0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            ModelLoader modelLoader0 = multiModelLoaderFactory0.build(File.class, this.dataClass);
            ModelLoader modelLoader1 = multiModelLoaderFactory0.build(Uri.class, this.dataClass);
            return new QMediaStoreUriLoader(this.context, modelLoader0, modelLoader1, this.dataClass);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    public static final class FileDescriptorFactory extends Factory {
        public FileDescriptorFactory(Context context0) {
            super(context0, ParcelFileDescriptor.class);
        }
    }

    public static final class InputStreamFactory extends Factory {
        public InputStreamFactory(Context context0) {
            super(context0, InputStream.class);
        }
    }

    static final class QMediaStoreUriFetcher implements DataFetcher {
        private static final String[] PROJECTION;
        private final Context context;
        private final Class dataClass;
        private volatile DataFetcher delegate;
        private final ModelLoader fileDelegate;
        private final int height;
        private volatile boolean isCancelled;
        private final Options options;
        private final Uri uri;
        private final ModelLoader uriDelegate;
        private final int width;

        static {
            QMediaStoreUriFetcher.PROJECTION = new String[]{"_data"};
        }

        public QMediaStoreUriFetcher(Context context0, ModelLoader modelLoader0, ModelLoader modelLoader1, Uri uri0, int v, int v1, Options options0, Class class0) {
            this.context = context0.getApplicationContext();
            this.fileDelegate = modelLoader0;
            this.uriDelegate = modelLoader1;
            this.uri = uri0;
            this.width = v;
            this.height = v1;
            this.options = options0;
            this.dataClass = class0;
        }

        private LoadData buildDelegateData() {
            if(Environment.isExternalStorageLegacy()) {
                File file0 = this.queryForFilePath(this.uri);
                return this.fileDelegate.buildLoadData(file0, this.width, this.height, this.options);
            }
            if(MediaStoreUtil.isAndroidPickerUri(this.uri)) {
                return this.uriDelegate.buildLoadData(this.uri, this.width, this.height, this.options);
            }
            if(this.isAccessMediaLocationGranted()) {
                Uri uri0 = MediaStore.setRequireOriginal(this.uri);
                return this.uriDelegate.buildLoadData(uri0, this.width, this.height, this.options);
            }
            return this.uriDelegate.buildLoadData(this.uri, this.width, this.height, this.options);
        }

        private DataFetcher buildDelegateFetcher() {
            LoadData modelLoader$LoadData0 = this.buildDelegateData();
            return modelLoader$LoadData0 == null ? null : modelLoader$LoadData0.fetcher;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            DataFetcher dataFetcher0 = this.delegate;
            if(dataFetcher0 != null) {
                dataFetcher0.cancel();
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher dataFetcher0 = this.delegate;
            if(dataFetcher0 != null) {
                dataFetcher0.cleanup();
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return this.dataClass;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        private boolean isAccessMediaLocationGranted() {
            return this.context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            try {
                DataFetcher dataFetcher0 = this.buildDelegateFetcher();
                if(dataFetcher0 == null) {
                    dataFetcher$DataCallback0.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.uri));
                    return;
                }
                this.delegate = dataFetcher0;
                if(this.isCancelled) {
                    this.cancel();
                    return;
                }
                dataFetcher0.loadData(priority0, dataFetcher$DataCallback0);
                return;
            }
            catch(FileNotFoundException fileNotFoundException0) {
            }
            dataFetcher$DataCallback0.onLoadFailed(fileNotFoundException0);
        }

        private File queryForFilePath(Uri uri0) {
            try(Cursor cursor0 = this.context.getContentResolver().query(uri0, QMediaStoreUriFetcher.PROJECTION, null, null, null)) {
                if(cursor0 == null || !cursor0.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri0);
                }
                String s = cursor0.getString(cursor0.getColumnIndexOrThrow("_data"));
                if(TextUtils.isEmpty(s)) {
                    throw new FileNotFoundException("File path was empty in media store for: " + uri0);
                }
                return new File(s);
            }
        }
    }

    private final Context context;
    private final Class dataClass;
    private final ModelLoader fileDelegate;
    private final ModelLoader uriDelegate;

    public QMediaStoreUriLoader(Context context0, ModelLoader modelLoader0, ModelLoader modelLoader1, Class class0) {
        this.context = context0.getApplicationContext();
        this.fileDelegate = modelLoader0;
        this.uriDelegate = modelLoader1;
        this.dataClass = class0;
    }

    public LoadData buildLoadData(Uri uri0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(uri0), new QMediaStoreUriFetcher(this.context, this.fileDelegate, this.uriDelegate, uri0, v, v1, options0, this.dataClass));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((Uri)object0), v, v1, options0);
    }

    public boolean handles(Uri uri0) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.isMediaStoreUri(uri0);
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((Uri)object0));
    }
}

