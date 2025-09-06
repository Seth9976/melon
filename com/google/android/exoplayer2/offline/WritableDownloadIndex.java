package com.google.android.exoplayer2.offline;

public interface WritableDownloadIndex extends DownloadIndex {
    void putDownload(Download arg1);

    void removeDownload(String arg1);

    void setDownloadingStatesToQueued();

    void setStatesToRemoving();

    void setStopReason(int arg1);

    void setStopReason(String arg1, int arg2);
}

