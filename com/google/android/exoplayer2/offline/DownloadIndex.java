package com.google.android.exoplayer2.offline;

public interface DownloadIndex {
    Download getDownload(String arg1);

    DownloadCursor getDownloads(int[] arg1);
}

