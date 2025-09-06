package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import java.util.Map;

public interface HlsExtractorFactory {
    public static final class Result {
        public final Extractor extractor;
        public final boolean isPackedAudioExtractor;
        public final boolean isReusable;

        public Result(Extractor extractor0, boolean z, boolean z1) {
            this.extractor = extractor0;
            this.isPackedAudioExtractor = z;
            this.isReusable = z1;
        }
    }

    public static final HlsExtractorFactory DEFAULT;

    static {
        HlsExtractorFactory.DEFAULT = new DefaultHlsExtractorFactory();
    }

    Result createExtractor(Extractor arg1, Uri arg2, Format arg3, List arg4, TimestampAdjuster arg5, Map arg6, ExtractorInput arg7);
}

