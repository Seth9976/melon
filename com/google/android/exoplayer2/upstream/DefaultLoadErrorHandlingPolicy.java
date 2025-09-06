package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {
    private static final int DEFAULT_BEHAVIOR_MIN_LOADABLE_RETRY_COUNT = -1;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000L;
    private final int minimumLoadableRetryCount;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public DefaultLoadErrorHandlingPolicy(int v) {
        this.minimumLoadableRetryCount = v;
    }

    @Override  // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getBlacklistDurationMsFor(int v, long v1, IOException iOException0, int v2) {
        if(iOException0 instanceof InvalidResponseCodeException) {
            switch(((InvalidResponseCodeException)iOException0).responseCode) {
                case 404: 
                case 410: 
                case 0x1A0: {
                    return 60000L;
                }
                default: {
                    return 0x8000000000000001L;
                }
            }
        }
        return 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public int getMinimumLoadableRetryCount(int v) {
        int v1 = this.minimumLoadableRetryCount;
        if(v1 == -1) {
            return v == 7 ? 6 : 3;
        }
        return v1;
    }

    // 去混淆评级： 低(30)
    @Override  // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(int v, long v1, IOException iOException0, int v2) {
        return iOException0 instanceof ParserException || iOException0 instanceof FileNotFoundException || iOException0 instanceof UnexpectedLoaderException ? 0x8000000000000001L : ((long)Math.min((v2 - 1) * 1000, 5000));
    }
}

