package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FlacStreamMetadata {
    public static class SeekTable {
        public final long[] pointOffsets;
        public final long[] pointSampleNumbers;

        public SeekTable(long[] arr_v, long[] arr_v1) {
            this.pointSampleNumbers = arr_v;
            this.pointOffsets = arr_v1;
        }
    }

    public static final int NOT_IN_LOOKUP_TABLE = -1;
    private static final String SEPARATOR = "=";
    private static final String TAG = "FlacStreamMetadata";
    public final int bitsPerSample;
    public final int bitsPerSampleLookupKey;
    public final int channels;
    public final int maxBlockSizeSamples;
    public final int maxFrameSize;
    private final Metadata metadata;
    public final int minBlockSizeSamples;
    public final int minFrameSize;
    public final int sampleRate;
    public final int sampleRateLookupKey;
    public final SeekTable seekTable;
    public final long totalSamples;

    private FlacStreamMetadata(int v, int v1, int v2, int v3, int v4, int v5, int v6, long v7, SeekTable flacStreamMetadata$SeekTable0, Metadata metadata0) {
        this.minBlockSizeSamples = v;
        this.maxBlockSizeSamples = v1;
        this.minFrameSize = v2;
        this.maxFrameSize = v3;
        this.sampleRate = v4;
        this.sampleRateLookupKey = FlacStreamMetadata.getSampleRateLookupKey(v4);
        this.channels = v5;
        this.bitsPerSample = v6;
        this.bitsPerSampleLookupKey = FlacStreamMetadata.getBitsPerSampleLookupKey(v6);
        this.totalSamples = v7;
        this.seekTable = flacStreamMetadata$SeekTable0;
        this.metadata = metadata0;
    }

    public FlacStreamMetadata(int v, int v1, int v2, int v3, int v4, int v5, int v6, long v7, ArrayList arrayList0, ArrayList arrayList1) {
        this(v, v1, v2, v3, v4, v5, v6, v7, null, FlacStreamMetadata.buildMetadata(arrayList0, arrayList1));
    }

    public FlacStreamMetadata(byte[] arr_b, int v) {
        ParsableBitArray parsableBitArray0 = new ParsableBitArray(arr_b);
        parsableBitArray0.setPosition(v * 8);
        this.minBlockSizeSamples = parsableBitArray0.readBits(16);
        this.maxBlockSizeSamples = parsableBitArray0.readBits(16);
        this.minFrameSize = parsableBitArray0.readBits(24);
        this.maxFrameSize = parsableBitArray0.readBits(24);
        int v1 = parsableBitArray0.readBits(20);
        this.sampleRate = v1;
        this.sampleRateLookupKey = FlacStreamMetadata.getSampleRateLookupKey(v1);
        this.channels = parsableBitArray0.readBits(3) + 1;
        int v2 = parsableBitArray0.readBits(5);
        this.bitsPerSample = v2 + 1;
        this.bitsPerSampleLookupKey = FlacStreamMetadata.getBitsPerSampleLookupKey(v2 + 1);
        this.totalSamples = parsableBitArray0.readBitsToLong(36);
        this.seekTable = null;
        this.metadata = null;
    }

    private static Metadata buildMetadata(List list0, List list1) {
        if(list0.isEmpty() && list1.isEmpty()) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            String s = (String)list0.get(v);
            String[] arr_s = Util.splitAtFirst(s, "=");
            if(arr_s.length == 2) {
                arrayList0.add(new VorbisComment(arr_s[0], arr_s[1]));
            }
            else {
                String s1 = String.valueOf(s);
                Log.w("FlacStreamMetadata", (s1.length() == 0 ? new String("Failed to parse Vorbis comment: ") : "Failed to parse Vorbis comment: " + s1));
            }
        }
        arrayList0.addAll(list1);
        return arrayList0.isEmpty() ? null : new Metadata(arrayList0);
    }

    public FlacStreamMetadata copyWithPictureFrames(List list0) {
        Metadata metadata0 = this.getMetadataCopyWithAppendedEntriesFrom(FlacStreamMetadata.buildMetadata(Collections.EMPTY_LIST, list0));
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, metadata0);
    }

    public FlacStreamMetadata copyWithSeekTable(SeekTable flacStreamMetadata$SeekTable0) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, flacStreamMetadata$SeekTable0, this.metadata);
    }

    public FlacStreamMetadata copyWithVorbisComments(List list0) {
        Metadata metadata0 = this.getMetadataCopyWithAppendedEntriesFrom(FlacStreamMetadata.buildMetadata(list0, Collections.EMPTY_LIST));
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, metadata0);
    }

    public long getApproxBytesPerFrame() {
        int v = this.maxFrameSize;
        if(v > 0) {
            return (((long)v) + ((long)this.minFrameSize)) / 2L + 1L;
        }
        return this.minBlockSizeSamples != this.maxBlockSizeSamples || this.minBlockSizeSamples <= 0 ? 0x1000L * ((long)this.channels) * ((long)this.bitsPerSample) / 8L + 0x40L : ((long)this.minBlockSizeSamples) * ((long)this.channels) * ((long)this.bitsPerSample) / 8L + 0x40L;
    }

    public int getBitRate() {
        return this.bitsPerSample * this.sampleRate * this.channels;
    }

    private static int getBitsPerSampleLookupKey(int v) {
        switch(v) {
            case 8: {
                return 1;
            }
            case 12: {
                return 2;
            }
            case 16: {
                return 4;
            }
            case 20: {
                return 5;
            }
            case 24: {
                return 6;
            }
            default: {
                return -1;
            }
        }
    }

    public long getDurationUs() {
        return this.totalSamples == 0L ? 0x8000000000000001L : this.totalSamples * 1000000L / ((long)this.sampleRate);
    }

    public Format getFormat(byte[] arr_b, Metadata metadata0) {
        arr_b[4] = (byte)0x80;
        Metadata metadata1 = this.getMetadataCopyWithAppendedEntriesFrom(metadata0);
        List list0 = Collections.singletonList(arr_b);
        return Format.createAudioSampleFormat(null, "audio/flac", null, this.getBitRate(), (this.maxFrameSize > 0 ? this.maxFrameSize : -1), this.channels, this.sampleRate, -1, 0, 0, list0, null, 0, null, metadata1);
    }

    public int getMaxDecodedFrameSize() {
        return this.bitsPerSample / 8 * (this.maxBlockSizeSamples * this.channels);
    }

    public Metadata getMetadataCopyWithAppendedEntriesFrom(Metadata metadata0) {
        return this.metadata == null ? metadata0 : this.metadata.copyWithAppendedEntriesFrom(metadata0);
    }

    public long getSampleNumber(long v) {
        return Util.constrainValue(v * ((long)this.sampleRate) / 1000000L, 0L, this.totalSamples - 1L);
    }

    private static int getSampleRateLookupKey(int v) {
        switch(v) {
            case 8000: {
                return 4;
            }
            case 16000: {
                return 5;
            }
            case 22050: {
                return 6;
            }
            case 24000: {
                return 7;
            }
            case 32000: {
                return 8;
            }
            case 44100: {
                return 9;
            }
            case 48000: {
                return 10;
            }
            case 88200: {
                return 1;
            }
            case 96000: {
                return 11;
            }
            case 176400: {
                return 2;
            }
            case 192000: {
                return 3;
            }
            default: {
                return -1;
            }
        }
    }
}

