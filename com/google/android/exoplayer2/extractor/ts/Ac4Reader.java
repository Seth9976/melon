package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.Ac4Util.SyncFrameInfo;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Ac4Reader implements ElementaryStreamReader {
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private boolean hasCRC;
    private final ParsableBitArray headerScratchBits;
    private final ParsableByteArray headerScratchBytes;
    private final String language;
    private boolean lastByteWasAC;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;
    private String trackFormatId;

    public Ac4Reader() {
        this(null);
    }

    public Ac4Reader(String s) {
        ParsableBitArray parsableBitArray0 = new ParsableBitArray(new byte[16]);
        this.headerScratchBits = parsableBitArray0;
        this.headerScratchBytes = new ParsableByteArray(parsableBitArray0.data);
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWasAC = false;
        this.hasCRC = false;
        this.language = s;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        int v2;
        while(parsableByteArray0.bytesLeft() > 0) {
            switch(this.state) {
                case 0: {
                    if(!this.skipToNextSync(parsableByteArray0)) {
                        continue;
                    }
                    this.state = 1;
                    byte[] arr_b = this.headerScratchBytes.data;
                    arr_b[0] = -84;
                    arr_b[1] = (byte)(this.hasCRC ? 65 : 0x40);
                    this.bytesRead = 2;
                    continue;
                }
                case 1: {
                    if(!this.continueRead(parsableByteArray0, this.headerScratchBytes.data, 16)) {
                        continue;
                    }
                    this.parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 16);
                    this.state = 2;
                    continue;
                }
                case 2: {
                    int v = Math.min(parsableByteArray0.bytesLeft(), this.sampleSize - this.bytesRead);
                    this.output.sampleData(parsableByteArray0, v);
                    int v1 = this.bytesRead + v;
                    this.bytesRead = v1;
                    v2 = this.sampleSize;
                    if(v1 == v2) {
                        break;
                    }
                    continue;
                }
                default: {
                    continue;
                }
            }
            this.output.sampleMetadata(this.timeUs, 1, v2, 0, null);
            this.timeUs += this.sampleDurationUs;
            this.state = 0;
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
        this.trackFormatId = tsPayloadReader$TrackIdGenerator0.getFormatId();
        this.output = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 1);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.timeUs = v;
    }

    private void parseHeader() {
        this.headerScratchBits.setPosition(0);
        SyncFrameInfo ac4Util$SyncFrameInfo0 = Ac4Util.parseAc4SyncframeInfo(this.headerScratchBits);
        if(this.format == null || ac4Util$SyncFrameInfo0.channelCount != this.format.channelCount || ac4Util$SyncFrameInfo0.sampleRate != this.format.sampleRate || !"audio/ac4".equals(this.format.sampleMimeType)) {
            Format format0 = Format.createAudioSampleFormat(this.trackFormatId, "audio/ac4", null, -1, -1, ac4Util$SyncFrameInfo0.channelCount, ac4Util$SyncFrameInfo0.sampleRate, null, null, 0, this.language);
            this.format = format0;
            this.output.format(format0);
        }
        this.sampleSize = ac4Util$SyncFrameInfo0.frameSize;
        this.sampleDurationUs = ((long)ac4Util$SyncFrameInfo0.sampleCount) * 1000000L / ((long)this.format.sampleRate);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWasAC = false;
        this.hasCRC = false;
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray0) {
        while(true) {
            boolean z = false;
            if(parsableByteArray0.bytesLeft() <= 0) {
                break;
            }
            if(this.lastByteWasAC) {
                int v = parsableByteArray0.readUnsignedByte();
                this.lastByteWasAC = v == 0xAC;
                if(v == 0x40 || v == 65) {
                    if(v == 65) {
                        z = true;
                    }
                    this.hasCRC = z;
                    return true;
                }
            }
            else {
                if(parsableByteArray0.readUnsignedByte() == 0xAC) {
                    z = true;
                }
                this.lastByteWasAC = z;
            }
        }
        return false;
    }
}

