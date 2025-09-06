package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher {
    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        private final ContentResolver contentResolver;

        static {
            ImageThumbnailQuery.PATH_PROJECTION = new String[]{"_data"};
        }

        public ImageThumbnailQuery(ContentResolver contentResolver0) {
            this.contentResolver = contentResolver0;
        }

        @Override  // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri0) {
            String[] arr_s = {uri0.getLastPathSegment()};
            return this.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, ImageThumbnailQuery.PATH_PROJECTION, "kind = 1 AND image_id = ?", arr_s, null);
        }
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        private final ContentResolver contentResolver;

        static {
            VideoThumbnailQuery.PATH_PROJECTION = new String[]{"_data"};
        }

        public VideoThumbnailQuery(ContentResolver contentResolver0) {
            this.contentResolver = contentResolver0;
        }

        @Override  // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri0) {
            String[] arr_s = {uri0.getLastPathSegment()};
            return this.contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, VideoThumbnailQuery.PATH_PROJECTION, "kind = 1 AND video_id = ?", arr_s, null);
        }
    }

    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final ThumbnailStreamOpener opener;

    public ThumbFetcher(Uri uri0, ThumbnailStreamOpener thumbnailStreamOpener0) {
        this.mediaStoreImageUri = uri0;
        this.opener = thumbnailStreamOpener0;
    }

    private static ThumbFetcher build(Context context0, Uri uri0, ThumbnailQuery thumbnailQuery0) {
        ArrayPool arrayPool0 = Glide.get(context0).getArrayPool();
        return new ThumbFetcher(uri0, new ThumbnailStreamOpener(Glide.get(context0).getRegistry().getImageHeaderParsers(), thumbnailQuery0, arrayPool0, context0.getContentResolver()));
    }

    public static ThumbFetcher buildImageFetcher(Context context0, Uri uri0) {
        return ThumbFetcher.build(context0, uri0, new ImageThumbnailQuery(context0.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context context0, Uri uri0) {
        return ThumbFetcher.build(context0, uri0, new VideoThumbnailQuery(context0.getContentResolver()));
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream0 = this.inputStream;
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return InputStream.class;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
        try {
            InputStream inputStream0 = this.openThumbInputStream();
            this.inputStream = inputStream0;
            dataFetcher$DataCallback0.onDataReady(inputStream0);
        }
        catch(FileNotFoundException fileNotFoundException0) {
            if(Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", fileNotFoundException0);
            }
            dataFetcher$DataCallback0.onLoadFailed(fileNotFoundException0);
        }
    }

    private InputStream openThumbInputStream() {
        InputStream inputStream0 = this.opener.open(this.mediaStoreImageUri);
        int v = inputStream0 == null ? -1 : this.opener.getOrientation(this.mediaStoreImageUri);
        return v != -1 ? new ExifOrientationStream(inputStream0, v) : inputStream0;
    }
}

