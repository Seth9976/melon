package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public abstract class BinarySearchSeeker {
    public static class BinarySearchSeekMap implements SeekMap {
        private final long approxBytesPerFrame;
        private final long ceilingBytePosition;
        private final long ceilingTimePosition;
        private final long durationUs;
        private final long floorBytePosition;
        private final long floorTimePosition;
        private final SeekTimestampConverter seekTimestampConverter;

        public BinarySearchSeekMap(SeekTimestampConverter binarySearchSeeker$SeekTimestampConverter0, long v, long v1, long v2, long v3, long v4, long v5) {
            this.seekTimestampConverter = binarySearchSeeker$SeekTimestampConverter0;
            this.durationUs = v;
            this.floorTimePosition = v1;
            this.ceilingTimePosition = v2;
            this.floorBytePosition = v3;
            this.ceilingBytePosition = v4;
            this.approxBytesPerFrame = v5;
        }

        public static long access$1000(BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap0) {
            return binarySearchSeeker$BinarySearchSeekMap0.floorTimePosition;
        }

        public static long access$1100(BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap0) {
            return binarySearchSeeker$BinarySearchSeekMap0.ceilingTimePosition;
        }

        public static long access$1200(BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap0) {
            return binarySearchSeeker$BinarySearchSeekMap0.floorBytePosition;
        }

        public static long access$1300(BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap0) {
            return binarySearchSeeker$BinarySearchSeekMap0.ceilingBytePosition;
        }

        public static long access$1400(BinarySearchSeekMap binarySearchSeeker$BinarySearchSeekMap0) {
            return binarySearchSeeker$BinarySearchSeekMap0.approxBytesPerFrame;
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long v) {
            return new SeekPoints(new SeekPoint(v, SeekOperationParams.calculateNextSearchBytePosition(this.seekTimestampConverter.timeUsToTargetTime(v), this.floorTimePosition, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame)));
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public long timeUsToTargetTime(long v) {
            return this.seekTimestampConverter.timeUsToTargetTime(v);
        }
    }

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekTimestampConverter
        public long timeUsToTargetTime(long v) {
            return v;
        }
    }

    public static class SeekOperationParams {
        private final long approxBytesPerFrame;
        private long ceilingBytePosition;
        private long ceilingTimePosition;
        private long floorBytePosition;
        private long floorTimePosition;
        private long nextSearchBytePosition;
        private final long seekTimeUs;
        private final long targetTimePosition;

        public SeekOperationParams(long v, long v1, long v2, long v3, long v4, long v5, long v6) {
            this.seekTimeUs = v;
            this.targetTimePosition = v1;
            this.floorTimePosition = v2;
            this.ceilingTimePosition = v3;
            this.floorBytePosition = v4;
            this.ceilingBytePosition = v5;
            this.approxBytesPerFrame = v6;
            this.nextSearchBytePosition = SeekOperationParams.calculateNextSearchBytePosition(v1, v2, v3, v4, v5, v6);
        }

        public static long access$000(SeekOperationParams binarySearchSeeker$SeekOperationParams0) {
            return binarySearchSeeker$SeekOperationParams0.getSeekTimeUs();
        }

        public static long access$100(SeekOperationParams binarySearchSeeker$SeekOperationParams0) {
            return binarySearchSeeker$SeekOperationParams0.getFloorBytePosition();
        }

        public static long access$200(SeekOperationParams binarySearchSeeker$SeekOperationParams0) {
            return binarySearchSeeker$SeekOperationParams0.getCeilingBytePosition();
        }

        public static long access$300(SeekOperationParams binarySearchSeeker$SeekOperationParams0) {
            return binarySearchSeeker$SeekOperationParams0.getNextSearchBytePosition();
        }

        public static long access$400(SeekOperationParams binarySearchSeeker$SeekOperationParams0) {
            return binarySearchSeeker$SeekOperationParams0.getTargetTimePosition();
        }

        public static void access$800(SeekOperationParams binarySearchSeeker$SeekOperationParams0, long v, long v1) {
            binarySearchSeeker$SeekOperationParams0.updateSeekCeiling(v, v1);
        }

        public static void access$900(SeekOperationParams binarySearchSeeker$SeekOperationParams0, long v, long v1) {
            binarySearchSeeker$SeekOperationParams0.updateSeekFloor(v, v1);
        }

        public static long calculateNextSearchBytePosition(long v, long v1, long v2, long v3, long v4, long v5) {
            if(v3 + 1L < v4 && v1 + 1L < v2) {
                long v6 = (long)(((float)(v - v1)) * (((float)(v4 - v3)) / ((float)(v2 - v1))));
                return Util.constrainValue(v6 + v3 - v5 - v6 / 20L, v3, v4 - 1L);
            }
            return v3;
        }

        private long getCeilingBytePosition() {
            return this.ceilingBytePosition;
        }

        private long getFloorBytePosition() {
            return this.floorBytePosition;
        }

        private long getNextSearchBytePosition() {
            return this.nextSearchBytePosition;
        }

        private long getSeekTimeUs() {
            return this.seekTimeUs;
        }

        private long getTargetTimePosition() {
            return this.targetTimePosition;
        }

        private void updateNextSearchBytePosition() {
            this.nextSearchBytePosition = SeekOperationParams.calculateNextSearchBytePosition(this.targetTimePosition, this.floorTimePosition, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame);
        }

        private void updateSeekCeiling(long v, long v1) {
            this.ceilingTimePosition = v;
            this.ceilingBytePosition = v1;
            this.updateNextSearchBytePosition();
        }

        private void updateSeekFloor(long v, long v1) {
            this.floorTimePosition = v;
            this.floorBytePosition = v1;
            this.updateNextSearchBytePosition();
        }
    }

    public interface SeekTimestampConverter {
        long timeUsToTargetTime(long arg1);
    }

    public static final class TimestampSearchResult {
        public static final TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = null;
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND;
        private final long bytePositionToUpdate;
        private final long timestampToUpdate;
        private final int type;

        static {
            TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT = new TimestampSearchResult(-3, 0x8000000000000001L, -1L);
        }

        private TimestampSearchResult(int v, long v1, long v2) {
            this.type = v;
            this.timestampToUpdate = v1;
            this.bytePositionToUpdate = v2;
        }

        public static int access$500(TimestampSearchResult binarySearchSeeker$TimestampSearchResult0) {
            return binarySearchSeeker$TimestampSearchResult0.type;
        }

        public static long access$600(TimestampSearchResult binarySearchSeeker$TimestampSearchResult0) {
            return binarySearchSeeker$TimestampSearchResult0.timestampToUpdate;
        }

        public static long access$700(TimestampSearchResult binarySearchSeeker$TimestampSearchResult0) {
            return binarySearchSeeker$TimestampSearchResult0.bytePositionToUpdate;
        }

        public static TimestampSearchResult overestimatedResult(long v, long v1) {
            return new TimestampSearchResult(-1, v, v1);
        }

        public static TimestampSearchResult targetFoundResult(long v) {
            return new TimestampSearchResult(0, 0x8000000000000001L, v);
        }

        public static TimestampSearchResult underestimatedResult(long v, long v1) {
            return new TimestampSearchResult(-2, v, v1);
        }
    }

    public interface TimestampSeeker {
        default void onSeekFinished() {
        }

        TimestampSearchResult searchForTimestamp(ExtractorInput arg1, long arg2);
    }

    private static final long MAX_SKIP_BYTES = 0x40000L;
    private final int minimumSearchRange;
    protected final BinarySearchSeekMap seekMap;
    protected SeekOperationParams seekOperationParams;
    protected final TimestampSeeker timestampSeeker;

    public BinarySearchSeeker(SeekTimestampConverter binarySearchSeeker$SeekTimestampConverter0, TimestampSeeker binarySearchSeeker$TimestampSeeker0, long v, long v1, long v2, long v3, long v4, long v5, int v6) {
        this.timestampSeeker = binarySearchSeeker$TimestampSeeker0;
        this.minimumSearchRange = v6;
        this.seekMap = new BinarySearchSeekMap(binarySearchSeeker$SeekTimestampConverter0, v, v1, v2, v3, v4, v5);
    }

    public SeekOperationParams createSeekParamsForTargetTimeUs(long v) {
        return new SeekOperationParams(v, this.seekMap.timeUsToTargetTime(v), BinarySearchSeekMap.access$1000(this.seekMap), BinarySearchSeekMap.access$1100(this.seekMap), BinarySearchSeekMap.access$1200(this.seekMap), BinarySearchSeekMap.access$1300(this.seekMap), BinarySearchSeekMap.access$1400(this.seekMap));
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public int handlePendingSeek(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        TimestampSeeker binarySearchSeeker$TimestampSeeker0 = (TimestampSeeker)Assertions.checkNotNull(this.timestampSeeker);
        while(true) {
            SeekOperationParams binarySearchSeeker$SeekOperationParams0 = (SeekOperationParams)Assertions.checkNotNull(this.seekOperationParams);
            long v = SeekOperationParams.access$100(binarySearchSeeker$SeekOperationParams0);
            long v1 = SeekOperationParams.access$200(binarySearchSeeker$SeekOperationParams0);
            long v2 = SeekOperationParams.access$300(binarySearchSeeker$SeekOperationParams0);
            if(Long.compare(v1 - v, this.minimumSearchRange) <= 0) {
                this.markSeekOperationFinished(false, v);
                return this.seekToPosition(extractorInput0, v, positionHolder0);
            }
            if(!this.skipInputUntilPosition(extractorInput0, v2)) {
                return this.seekToPosition(extractorInput0, v2, positionHolder0);
            }
            extractorInput0.resetPeekPosition();
            TimestampSearchResult binarySearchSeeker$TimestampSearchResult0 = binarySearchSeeker$TimestampSeeker0.searchForTimestamp(extractorInput0, SeekOperationParams.access$400(binarySearchSeeker$SeekOperationParams0));
            switch(TimestampSearchResult.access$500(binarySearchSeeker$TimestampSearchResult0)) {
                case -3: {
                    this.markSeekOperationFinished(false, v2);
                    return this.seekToPosition(extractorInput0, v2, positionHolder0);
                }
                case -2: {
                    SeekOperationParams.access$900(binarySearchSeeker$SeekOperationParams0, TimestampSearchResult.access$600(binarySearchSeeker$TimestampSearchResult0), TimestampSearchResult.access$700(binarySearchSeeker$TimestampSearchResult0));
                    break;
                }
                case -1: {
                    SeekOperationParams.access$800(binarySearchSeeker$SeekOperationParams0, TimestampSearchResult.access$600(binarySearchSeeker$TimestampSearchResult0), TimestampSearchResult.access$700(binarySearchSeeker$TimestampSearchResult0));
                    break;
                }
                case 0: {
                    this.markSeekOperationFinished(true, TimestampSearchResult.access$700(binarySearchSeeker$TimestampSearchResult0));
                    this.skipInputUntilPosition(extractorInput0, TimestampSearchResult.access$700(binarySearchSeeker$TimestampSearchResult0));
                    return this.seekToPosition(extractorInput0, TimestampSearchResult.access$700(binarySearchSeeker$TimestampSearchResult0), positionHolder0);
                }
                default: {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final boolean isSeeking() {
        return this.seekOperationParams != null;
    }

    public final void markSeekOperationFinished(boolean z, long v) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        this.onSeekOperationFinished(z, v);
    }

    public void onSeekOperationFinished(boolean z, long v) {
    }

    public final int seekToPosition(ExtractorInput extractorInput0, long v, PositionHolder positionHolder0) {
        if(v == extractorInput0.getPosition()) {
            return 0;
        }
        positionHolder0.position = v;
        return 1;
    }

    public final void setSeekTargetUs(long v) {
        if(this.seekOperationParams != null && SeekOperationParams.access$000(this.seekOperationParams) == v) {
            return;
        }
        this.seekOperationParams = this.createSeekParamsForTargetTimeUs(v);
    }

    public final boolean skipInputUntilPosition(ExtractorInput extractorInput0, long v) {
        long v1 = v - extractorInput0.getPosition();
        if(v1 >= 0L && v1 <= 0x40000L) {
            extractorInput0.skipFully(((int)v1));
            return true;
        }
        return false;
    }
}

