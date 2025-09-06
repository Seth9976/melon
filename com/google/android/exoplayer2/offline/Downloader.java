package com.google.android.exoplayer2.offline;

public interface Downloader {
    public interface ProgressListener {
        void onProgress(long arg1, long arg2, float arg3);
    }

    void cancel();

    void download(ProgressListener arg1);

    void remove();
}

