package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public interface TsPayloadReader {
    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String s, int v, byte[] arr_b) {
            this.language = s;
            this.type = v;
            this.initializationData = arr_b;
        }
    }

    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final List dvbSubtitleInfos;
        public final String language;
        public final int streamType;

        public EsInfo(int v, String s, List list0, byte[] arr_b) {
            this.streamType = v;
            this.language = s;
            this.dvbSubtitleInfos = list0 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list0);
            this.descriptorBytes = arr_b;
        }
    }

    public interface Factory {
        SparseArray createInitialPayloadReaders();

        TsPayloadReader createPayloadReader(int arg1, EsInfo arg2);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class TrackIdGenerator {
        private static final int ID_UNSET = 0x80000000;
        private final int firstTrackId;
        private String formatId;
        private final String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int v, int v1) {
            this(0x80000000, v, v1);
        }

        public TrackIdGenerator(int v, int v1, int v2) {
            this.formatIdPrefix = v == 0x80000000 ? "" : v + "/";
            this.firstTrackId = v1;
            this.trackIdIncrement = v2;
            this.trackId = 0x80000000;
        }

        public void generateNewId() {
            int v = this.trackId == 0x80000000 ? this.firstTrackId : this.trackId + this.trackIdIncrement;
            this.trackId = v;
            this.formatId = this.formatIdPrefix + v;
        }

        public String getFormatId() {
            this.maybeThrowUninitializedError();
            return this.formatId;
        }

        public int getTrackId() {
            this.maybeThrowUninitializedError();
            return this.trackId;
        }

        private void maybeThrowUninitializedError() {
            if(this.trackId == 0x80000000) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }

    public static final int FLAG_DATA_ALIGNMENT_INDICATOR = 4;
    public static final int FLAG_PAYLOAD_UNIT_START_INDICATOR = 1;
    public static final int FLAG_RANDOM_ACCESS_INDICATOR = 2;

    void consume(ParsableByteArray arg1, int arg2);

    void init(TimestampAdjuster arg1, ExtractorOutput arg2, TrackIdGenerator arg3);

    void seek();
}

