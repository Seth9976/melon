package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

public abstract class AssetPathFetcher implements DataFetcher {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private Object data;

    public AssetPathFetcher(AssetManager assetManager0, String s) {
        this.assetManager = assetManager0;
        this.assetPath = s;
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
    public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
        try {
            Object object0 = this.loadResource(this.assetManager, this.assetPath);
            this.data = object0;
            dataFetcher$DataCallback0.onDataReady(object0);
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", iOException0);
            }
            dataFetcher$DataCallback0.onLoadFailed(iOException0);
        }
    }

    public abstract Object loadResource(AssetManager arg1, String arg2);
}

