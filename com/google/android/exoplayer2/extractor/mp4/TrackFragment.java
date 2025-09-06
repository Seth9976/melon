package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int[] sampleCompositionTimeOffsetUsTable;
    public int sampleCount;
    public long[] sampleDecodingTimeUsTable;
    public ParsableByteArray sampleEncryptionData;
    public int sampleEncryptionDataLength;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable;
    public boolean[] sampleIsSyncFrameTable;
    public int[] sampleSizeTable;
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition;
    public int[] trunLength;

    public void fillEncryptionData(ExtractorInput extractorInput0) {
        extractorInput0.readFully(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public void fillEncryptionData(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.readBytes(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public long getSamplePresentationTimeUs(int v) {
        return this.sampleDecodingTimeUsTable[v] + ((long)this.sampleCompositionTimeOffsetUsTable[v]);
    }

    public void initEncryptionData(int v) {
        if(this.sampleEncryptionData == null || this.sampleEncryptionData.limit() < v) {
            this.sampleEncryptionData = new ParsableByteArray(v);
        }
        this.sampleEncryptionDataLength = v;
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public void initTables(int v, int v1) {
        this.trunCount = v;
        this.sampleCount = v1;
        if(this.trunLength == null || this.trunLength.length < v) {
            this.trunDataPosition = new long[v];
            this.trunLength = new int[v];
        }
        if(this.sampleSizeTable != null && this.sampleSizeTable.length >= v1) {
            return;
        }
        int v2 = v1 * 0x7D / 100;
        this.sampleSizeTable = new int[v2];
        this.sampleCompositionTimeOffsetUsTable = new int[v2];
        this.sampleDecodingTimeUsTable = new long[v2];
        this.sampleIsSyncFrameTable = new boolean[v2];
        this.sampleHasSubsampleEncryptionTable = new boolean[v2];
    }

    public void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0L;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    // 去混淆评级： 低(20)
    public boolean sampleHasSubsampleEncryptionTable(int v) {
        return this.definesEncryptionData && this.sampleHasSubsampleEncryptionTable[v];
    }
}

