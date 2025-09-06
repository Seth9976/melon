package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

public final class AdtsReader implements ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER = null;
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 0x200;
    private static final int MATCH_STATE_I = 0x300;
    private static final int MATCH_STATE_ID = 0x400;
    private static final int MATCH_STATE_START = 0x100;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_CHECKING_ADTS_HEADER = 1;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 3;
    private static final int STATE_READING_ID3_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 4;
    private static final String TAG = "AdtsReader";
    private static final int VERSION_UNSET = -1;
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private int currentFrameVersion;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private int firstFrameSampleRateIndex;
    private int firstFrameVersion;
    private String formatId;
    private boolean foundFirstFrame;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;
    private final String language;
    private int matchState;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    static {
        AdtsReader.ID3_IDENTIFIER = new byte[]{73, 68, 51};
    }

    public AdtsReader(boolean z) {
        this(z, null);
    }

    public AdtsReader(boolean z, String s) {
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(AdtsReader.ID3_IDENTIFIER, 10));
        this.setFindingSampleState();
        this.firstFrameVersion = -1;
        this.firstFrameSampleRateIndex = -1;
        this.sampleDurationUs = 0x8000000000000001L;
        this.exposeId3 = z;
        this.language = s;
    }

    private void checkAdtsHeader(ParsableByteArray parsableByteArray0) {
        if(parsableByteArray0.bytesLeft() == 0) {
            return;
        }
        this.adtsScratch.data[0] = parsableByteArray0.data[parsableByteArray0.getPosition()];
        this.adtsScratch.setPosition(2);
        int v = this.adtsScratch.readBits(4);
        if(this.firstFrameSampleRateIndex != -1 && v != this.firstFrameSampleRateIndex) {
            this.resetSync();
            return;
        }
        if(!this.foundFirstFrame) {
            this.foundFirstFrame = true;
            this.firstFrameVersion = this.currentFrameVersion;
            this.firstFrameSampleRateIndex = v;
        }
        this.setReadingAdtsHeaderState();
    }

    private boolean checkSyncPositionValid(ParsableByteArray parsableByteArray0, int v) {
        parsableByteArray0.setPosition(v + 1);
        if(!this.tryRead(parsableByteArray0, this.adtsScratch.data, 1)) {
            return false;
        }
        this.adtsScratch.setPosition(4);
        int v1 = this.adtsScratch.readBits(1);
        if(this.firstFrameVersion != -1 && v1 != this.firstFrameVersion) {
            return false;
        }
        if(this.firstFrameSampleRateIndex != -1) {
            if(!this.tryRead(parsableByteArray0, this.adtsScratch.data, 1)) {
                return true;
            }
            this.adtsScratch.setPosition(2);
            if(this.adtsScratch.readBits(4) != this.firstFrameSampleRateIndex) {
                return false;
            }
            parsableByteArray0.setPosition(v + 2);
        }
        if(!this.tryRead(parsableByteArray0, this.adtsScratch.data, 4)) {
            return true;
        }
        this.adtsScratch.setPosition(14);
        int v2 = this.adtsScratch.readBits(13);
        if(v2 < 7) {
            return false;
        }
        byte[] arr_b = parsableByteArray0.data;
        int v3 = parsableByteArray0.limit();
        int v4 = v + v2;
        if(v4 >= v3) {
            return true;
        }
        int v5 = arr_b[v4];
        if(v5 == -1) {
            return v4 + 1 == v3 ? true : this.isAdtsSyncBytes(-1, arr_b[v4 + 1]) && (arr_b[v4 + 1] & 8) >> 3 == v1;
        }
        if(v5 != 73) {
            return false;
        }
        if(v4 + 1 == v3) {
            return true;
        }
        if(arr_b[v4 + 1] != 68) {
            return false;
        }
        return v4 + 2 == v3 ? true : arr_b[v4 + 2] == 51;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        while(parsableByteArray0.bytesLeft() > 0) {
            switch(this.state) {
                case 0: {
                    this.findNextSample(parsableByteArray0);
                    break;
                }
                case 1: {
                    this.checkAdtsHeader(parsableByteArray0);
                    break;
                }
                case 2: {
                    if(!this.continueRead(parsableByteArray0, this.id3HeaderBuffer.data, 10)) {
                        continue;
                    }
                    this.parseId3Header();
                    break;
                }
                case 3: {
                    if(!this.continueRead(parsableByteArray0, this.adtsScratch.data, (this.hasCrc ? 7 : 5))) {
                        continue;
                    }
                    this.parseAdtsHeader();
                    break;
                }
                case 4: {
                    this.readSample(parsableByteArray0);
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
    }

    private boolean continueRead(ParsableByteArray parsableByteArray0, byte[] arr_b, int v) {
        int v1 = Math.min(parsableByteArray0.bytesLeft(), v - this.bytesRead);
        parsableByteArray0.readBytes(arr_b, this.bytesRead, v1);
        int v2 = this.bytesRead + v1;
        this.bytesRead = v2;
        return v2 == v;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        this.formatId = tsPayloadReader$TrackIdGenerator0.getFormatId();
        this.output = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 1);
        if(this.exposeId3) {
            tsPayloadReader$TrackIdGenerator0.generateNewId();
            TrackOutput trackOutput0 = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 4);
            this.id3Output = trackOutput0;
            trackOutput0.format(Format.createSampleFormat(tsPayloadReader$TrackIdGenerator0.getFormatId(), "application/id3", null, -1, null));
            return;
        }
        this.id3Output = new DummyTrackOutput();
    }

    private void findNextSample(ParsableByteArray parsableByteArray0) {
        byte[] arr_b = parsableByteArray0.data;
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        while(v < v1) {
            int v2 = arr_b[v];
            if(this.matchState == 0x200 && this.isAdtsSyncBytes(-1, ((byte)(v2 & 0xFF))) && (this.foundFirstFrame || this.checkSyncPositionValid(parsableByteArray0, v - 1))) {
                this.currentFrameVersion = (v2 & 8) >> 3;
                this.hasCrc = (v2 & 1) == 0;
                if(this.foundFirstFrame) {
                    this.setReadingAdtsHeaderState();
                }
                else {
                    this.setCheckingAdtsHeaderState();
                }
                parsableByteArray0.setPosition(v + 1);
                return;
            }
            int v3 = this.matchState;
            switch(v2 & 0xFF | v3) {
                case 329: {
                    this.matchState = 0x300;
                    break;
                }
                case 0x1FF: {
                    this.matchState = 0x200;
                    break;
                }
                case 836: {
                    this.matchState = 0x400;
                    break;
                }
                case 1075: {
                    this.setReadingId3HeaderState();
                    parsableByteArray0.setPosition(v + 1);
                    return;
                label_20:
                    if(v3 != 0x100) {
                        this.matchState = 0x100;
                        continue;
                    }
                    break;
                }
                default: {
                    goto label_20;
                }
            }
            ++v;
        }
        parsableByteArray0.setPosition(v);
    }

    public long getSampleDurationUs() {
        return this.sampleDurationUs;
    }

    private boolean isAdtsSyncBytes(byte b, byte b1) {
        return AdtsReader.isAdtsSyncWord((b & 0xFF) << 8 | b1 & 0xFF);
    }

    public static boolean isAdtsSyncWord(int v) {
        return (v & 0xFFF6) == 0xFFF0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.timeUs = v;
    }

    private void parseAdtsHeader() {
        this.adtsScratch.setPosition(0);
        if(this.hasOutputFormat) {
            this.adtsScratch.skipBits(10);
        }
        else {
            int v = this.adtsScratch.readBits(2);
            if(v + 1 != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + (v + 1) + ", but assuming AAC LC.");
            }
            this.adtsScratch.skipBits(5);
            int v1 = this.adtsScratch.readBits(3);
            byte[] arr_b = CodecSpecificDataUtil.buildAacAudioSpecificConfig(2, this.firstFrameSampleRateIndex, v1);
            Pair pair0 = CodecSpecificDataUtil.parseAacAudioSpecificConfig(arr_b);
            Format format0 = Format.createAudioSampleFormat(this.formatId, "audio/mp4a-latm", null, -1, -1, ((int)(((Integer)pair0.second))), ((int)(((Integer)pair0.first))), Collections.singletonList(arr_b), null, 0, this.language);
            this.sampleDurationUs = 1024000000L / ((long)format0.sampleRate);
            this.output.format(format0);
            this.hasOutputFormat = true;
        }
        this.adtsScratch.skipBits(4);
        int v2 = this.adtsScratch.readBits(13);
        this.setReadingSampleState(this.output, this.sampleDurationUs, 0, (this.hasCrc ? v2 - 9 : v2 - 7));
    }

    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        this.setReadingSampleState(this.id3Output, 0L, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    private void readSample(ParsableByteArray parsableByteArray0) {
        int v = Math.min(parsableByteArray0.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(parsableByteArray0, v);
        int v1 = this.bytesRead + v;
        this.bytesRead = v1;
        int v2 = this.sampleSize;
        if(v1 == v2) {
            this.currentOutput.sampleMetadata(this.timeUs, 1, v2, 0, null);
            this.timeUs += this.currentSampleDuration;
            this.setFindingSampleState();
        }
    }

    private void resetSync() {
        this.foundFirstFrame = false;
        this.setFindingSampleState();
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.resetSync();
    }

    private void setCheckingAdtsHeaderState() {
        this.state = 1;
        this.bytesRead = 0;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 0x100;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 3;
        this.bytesRead = 0;
    }

    private void setReadingId3HeaderState() {
        this.state = 2;
        this.bytesRead = AdtsReader.ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput trackOutput0, long v, int v1, int v2) {
        this.state = 4;
        this.bytesRead = v1;
        this.currentOutput = trackOutput0;
        this.currentSampleDuration = v;
        this.sampleSize = v2;
    }

    private boolean tryRead(ParsableByteArray parsableByteArray0, byte[] arr_b, int v) {
        if(parsableByteArray0.bytesLeft() < v) {
            return false;
        }
        parsableByteArray0.readBytes(arr_b, 0, v);
        return true;
    }
}

