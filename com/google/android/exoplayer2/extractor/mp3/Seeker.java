package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;

interface Seeker extends SeekMap {
    public static class UnseekableSeeker extends Unseekable implements Seeker {
        public UnseekableSeeker() {
            super(0x8000000000000001L);
        }

        @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
        public long getDataEndPosition() {
            return -1L;
        }

        @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
        public long getTimeUs(long v) {
            return 0L;
        }
    }

    long getDataEndPosition();

    long getTimeUs(long arg1);
}

