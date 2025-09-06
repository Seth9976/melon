package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher implements DataFetcher {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private Object data;
    private final Uri uri;

    public LocalUriFetcher(ContentResolver contentResolver0, Uri uri0) {
        this.contentResolver = contentResolver0;
        this.uri = uri0;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        Object object0 = this.data;
        if(object0 != null) {
            try {
                this.close(object0);
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public abstract void close(Object arg1);

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
        try {
            Object object0 = this.loadResource(this.uri, this.contentResolver);
            this.data = object0;
            dataFetcher$DataCallback0.onDataReady(object0);
        }
        catch(FileNotFoundException fileNotFoundException0) {
            if(Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", fileNotFoundException0);
            }
            dataFetcher$DataCallback0.onLoadFailed(fileNotFoundException0);
        }
    }

    public abstract Object loadResource(Uri arg1, ContentResolver arg2);
}

