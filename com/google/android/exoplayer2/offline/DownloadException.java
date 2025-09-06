package com.google.android.exoplayer2.offline;

import java.io.IOException;

public final class DownloadException extends IOException {
    public DownloadException(String s) {
        super(s);
    }

    public DownloadException(Throwable throwable0) {
        super(throwable0);
    }
}

