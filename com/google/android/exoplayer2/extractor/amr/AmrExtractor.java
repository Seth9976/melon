package com.google.android.exoplayer2.extractor.amr;

import b3.z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class AmrExtractor implements Extractor {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_FRAME_SIZE_BYTES = 0;
    private static final int NUM_SAME_SIZE_CONSTANT_BIT_RATE_THRESHOLD = 20;
    private static final int SAMPLE_RATE_NB = 8000;
    private static final int SAMPLE_RATE_WB = 16000;
    private static final int SAMPLE_TIME_PER_FRAME_US = 20000;
    private static final byte[] amrSignatureNb;
    private static final byte[] amrSignatureWb;
    private int currentSampleBytesRemaining;
    private int currentSampleSize;
    private long currentSampleTimeUs;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private int firstSampleSize;
    private final int flags;
    private static final int[] frameSizeBytesByTypeNb;
    private static final int[] frameSizeBytesByTypeWb;
    private boolean hasOutputFormat;
    private boolean hasOutputSeekMap;
    private boolean isWideBand;
    private int numSamplesWithSameSize;
    private final byte[] scratch;
    private SeekMap seekMap;
    private long timeOffsetUs;
    private TrackOutput trackOutput;

    static {
        AmrExtractor.FACTORY = new z(8);
        AmrExtractor.frameSizeBytesByTypeNb = new int[]{13, 14, 16, 18, 20, 21, 27, 0x20, 6, 7, 6, 6, 1, 1, 1, 1};
        AmrExtractor.frameSizeBytesByTypeWb = new int[]{18, 24, 33, 37, 41, 0x2F, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        AmrExtractor.amrSignatureNb = new byte[]{35, 33, 65, 77, 82, 10};
        AmrExtractor.amrSignatureWb = new byte[]{35, 33, 65, 77, 82, 45, 87, 66, 10};
        AmrExtractor.MAX_FRAME_SIZE_BYTES = 61;
    }

    public AmrExtractor() {
        this(0);
    }

    public AmrExtractor(int v) {
        this.flags = v;
        this.scratch = new byte[1];
        this.firstSampleSize = -1;
    }

    public static Extractor[] a() {
        return AmrExtractor.lambda$static$0();
    }

    public static byte[] amrSignatureNb() {
        return Arrays.copyOf(AmrExtractor.amrSignatureNb, AmrExtractor.amrSignatureNb.length);
    }

    public static byte[] amrSignatureWb() {
        return Arrays.copyOf(AmrExtractor.amrSignatureWb, AmrExtractor.amrSignatureWb.length);
    }

    public static int frameSizeBytesByTypeNb(int v) {
        return AmrExtractor.frameSizeBytesByTypeNb[v];
    }

    public static int frameSizeBytesByTypeWb(int v) {
        return AmrExtractor.frameSizeBytesByTypeWb[v];
    }

    private static int getBitrateFromFrameSize(int v, long v1) [...] // Inlined contents

    private SeekMap getConstantBitrateSeekMap(long v) {
        return new ConstantBitrateSeekMap(v, this.firstSamplePosition, ((int)(((long)(this.firstSampleSize * 8)) * 1000000L / 20000L)), this.firstSampleSize);
    }

    private int getFrameSizeInBytes(int v) {
        if(!this.isValidFrameType(v)) {
            throw new ParserException("Illegal AMR " + (this.isWideBand ? "WB" : "NB") + " frame type " + v);
        }
        return this.isWideBand ? AmrExtractor.frameSizeBytesByTypeWb[v] : AmrExtractor.frameSizeBytesByTypeNb[v];
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
        this.trackOutput = extractorOutput0.track(0, 1);
        extractorOutput0.endTracks();
    }

    // 去混淆评级： 低(20)
    private boolean isNarrowBandValidFrameType(int v) {
        return !this.isWideBand && (v < 12 || v > 14);
    }

    // 去混淆评级： 低(20)
    private boolean isValidFrameType(int v) {
        return v >= 0 && v <= 15 && (this.isWideBandValidFrameType(v) || this.isNarrowBandValidFrameType(v));
    }

    // 去混淆评级： 低(20)
    private boolean isWideBandValidFrameType(int v) {
        return this.isWideBand && (v < 10 || v > 13);
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new AmrExtractor()};
    }

    private void maybeOutputFormat() {
        if(!this.hasOutputFormat) {
            this.hasOutputFormat = true;
            this.trackOutput.format(Format.createAudioSampleFormat(null, (this.isWideBand ? "audio/amr-wb" : "audio/3gpp"), null, -1, AmrExtractor.MAX_FRAME_SIZE_BYTES, 1, (this.isWideBand ? 16000 : 8000), -1, null, null, 0, null));
        }
    }

    private void maybeOutputSeekMap(long v, int v1) {
        if(!this.hasOutputSeekMap) {
            if((this.flags & 1) == 0 || v == -1L || this.firstSampleSize != -1 && this.firstSampleSize != this.currentSampleSize) {
                Unseekable seekMap$Unseekable0 = new Unseekable(0x8000000000000001L);
                this.seekMap = seekMap$Unseekable0;
                this.extractorOutput.seekMap(seekMap$Unseekable0);
                this.hasOutputSeekMap = true;
            }
            else if(this.numSamplesWithSameSize >= 20 || v1 == -1) {
                SeekMap seekMap0 = this.getConstantBitrateSeekMap(v);
                this.seekMap = seekMap0;
                this.extractorOutput.seekMap(seekMap0);
                this.hasOutputSeekMap = true;
            }
        }
    }

    private boolean peekAmrSignature(ExtractorInput extractorInput0, byte[] arr_b) {
        extractorInput0.resetPeekPosition();
        byte[] arr_b1 = new byte[arr_b.length];
        extractorInput0.peekFully(arr_b1, 0, arr_b.length);
        return Arrays.equals(arr_b1, arr_b);
    }

    private int peekNextSampleSize(ExtractorInput extractorInput0) {
        extractorInput0.resetPeekPosition();
        extractorInput0.peekFully(this.scratch, 0, 1);
        int v = this.scratch[0];
        if((v & 0x83) > 0) {
            throw new ParserException("Invalid padding bits for frame header " + v);
        }
        return this.getFrameSizeInBytes(v >> 3 & 15);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        if(extractorInput0.getPosition() == 0L && !this.readAmrHeader(extractorInput0)) {
            throw new ParserException("Could not find AMR header.");
        }
        this.maybeOutputFormat();
        int v = this.readSample(extractorInput0);
        this.maybeOutputSeekMap(extractorInput0.getLength(), v);
        return v;
    }

    private boolean readAmrHeader(ExtractorInput extractorInput0) {
        byte[] arr_b = AmrExtractor.amrSignatureNb;
        if(this.peekAmrSignature(extractorInput0, arr_b)) {
            this.isWideBand = false;
            extractorInput0.skipFully(arr_b.length);
            return true;
        }
        byte[] arr_b1 = AmrExtractor.amrSignatureWb;
        if(this.peekAmrSignature(extractorInput0, arr_b1)) {
            this.isWideBand = true;
            extractorInput0.skipFully(arr_b1.length);
            return true;
        }
        return false;
    }

    private int readSample(ExtractorInput extractorInput0) {
        if(this.currentSampleBytesRemaining == 0) {
            try {
                int v = this.peekNextSampleSize(extractorInput0);
                this.currentSampleSize = v;
                this.currentSampleBytesRemaining = v;
            }
            catch(EOFException unused_ex) {
                return -1;
            }
            if(this.firstSampleSize == -1) {
                this.firstSamplePosition = extractorInput0.getPosition();
                this.firstSampleSize = this.currentSampleSize;
            }
            if(this.firstSampleSize == this.currentSampleSize) {
                ++this.numSamplesWithSameSize;
            }
        }
        int v1 = this.trackOutput.sampleData(extractorInput0, this.currentSampleBytesRemaining, true);
        if(v1 == -1) {
            return -1;
        }
        int v2 = this.currentSampleBytesRemaining - v1;
        this.currentSampleBytesRemaining = v2;
        if(v2 > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.timeOffsetUs + this.currentSampleTimeUs, 1, this.currentSampleSize, 0, null);
        this.currentSampleTimeUs += 20000L;
        return 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.currentSampleTimeUs = 0L;
        this.currentSampleSize = 0;
        this.currentSampleBytesRemaining = 0;
        if(v != 0L) {
            SeekMap seekMap0 = this.seekMap;
            if(seekMap0 instanceof ConstantBitrateSeekMap) {
                this.timeOffsetUs = ((ConstantBitrateSeekMap)seekMap0).getTimeUsAtPosition(v);
                return;
            }
        }
        this.timeOffsetUs = 0L;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        return this.readAmrHeader(extractorInput0);
    }
}

