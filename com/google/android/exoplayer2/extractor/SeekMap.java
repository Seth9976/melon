package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public interface SeekMap {
    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint0) {
            this(seekPoint0, seekPoint0);
        }

        public SeekPoints(SeekPoint seekPoint0, SeekPoint seekPoint1) {
            this.first = (SeekPoint)Assertions.checkNotNull(seekPoint0);
            this.second = (SeekPoint)Assertions.checkNotNull(seekPoint1);
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return SeekPoints.class == class0 && this.first.equals(((SeekPoints)object0).first) && this.second.equals(((SeekPoints)object0).second);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.second.hashCode() + this.first.hashCode() * 0x1F;
        }

        @Override
        public String toString() {
            String s = String.valueOf(this.first);
            return this.first.equals(this.second) ? "[" + s + "" + "]" : "[" + s + (", " + this.second) + "]";
        }
    }

    public static class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        public Unseekable(long v) {
            this(v, 0L);
        }

        public Unseekable(long v, long v1) {
            this.durationUs = v;
            this.startSeekPoints = new SeekPoints((v1 == 0L ? SeekPoint.START : new SeekPoint(0L, v1)));
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long v) {
            return this.startSeekPoints;
        }

        @Override  // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long arg1);

    boolean isSeekable();
}

