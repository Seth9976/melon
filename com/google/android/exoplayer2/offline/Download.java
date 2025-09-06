package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Download {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static final int FAILURE_REASON_NONE = 0;
    public static final int FAILURE_REASON_UNKNOWN = 1;
    public static final int STATE_COMPLETED = 3;
    public static final int STATE_DOWNLOADING = 2;
    public static final int STATE_FAILED = 4;
    public static final int STATE_QUEUED = 0;
    public static final int STATE_REMOVING = 5;
    public static final int STATE_RESTARTING = 7;
    public static final int STATE_STOPPED = 1;
    public static final int STOP_REASON_NONE;
    public final long contentLength;
    public final int failureReason;
    final DownloadProgress progress;
    public final DownloadRequest request;
    public final long startTimeMs;
    public final int state;
    public final int stopReason;
    public final long updateTimeMs;

    public Download(DownloadRequest downloadRequest0, int v, long v1, long v2, long v3, int v4, int v5) {
        this(downloadRequest0, v, v1, v2, v3, v4, v5, new DownloadProgress());
    }

    public Download(DownloadRequest downloadRequest0, int v, long v1, long v2, long v3, int v4, int v5, DownloadProgress downloadProgress0) {
        Assertions.checkNotNull(downloadProgress0);
        boolean z = false;
        Assertions.checkArgument((v5 == 0 ? 1 : 0) == (v == 4 ? 0 : 1));
        if(v4 != 0) {
            if(v != 0 && v != 2) {
                z = true;
            }
            Assertions.checkArgument(z);
        }
        this.request = downloadRequest0;
        this.state = v;
        this.startTimeMs = v1;
        this.updateTimeMs = v2;
        this.contentLength = v3;
        this.stopReason = v4;
        this.failureReason = v5;
        this.progress = downloadProgress0;
    }

    public long getBytesDownloaded() {
        return this.progress.bytesDownloaded;
    }

    public float getPercentDownloaded() {
        return this.progress.percentDownloaded;
    }

    public boolean isTerminalState() {
        return this.state == 3 || this.state == 4;
    }
}

