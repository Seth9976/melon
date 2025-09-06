package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DtsReader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 18;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private String formatId;
    private final ParsableByteArray headerScratchBytes;
    private final String language;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private int syncBytes;
    private long timeUs;

    public DtsReader(String s) {
        this.headerScratchBytes = new ParsableByteArray(new byte[18]);
        this.state = 0;
        this.language = s;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        while(parsableByteArray0.bytesLeft() > 0) {
            int v = this.state;
            if(v != 0) {
                switch(v) {
                    case 1: {
                        if(!this.continueRead(parsableByteArray0, this.headerScratchBytes.data, 18)) {
                            break;
                        }
                        this.parseHeader();
                        this.headerScratchBytes.setPosition(0);
                        this.output.sampleData(this.headerScratchBytes, 18);
                        this.state = 2;
                        break;
                    }
                    case 2: {
                        int v1 = Math.min(parsableByteArray0.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(parsableByteArray0, v1);
                        int v2 = this.bytesRead + v1;
                        this.bytesRead = v2;
                        int v3 = this.sampleSize;
                        if(v2 != v3) {
                            break;
                        }
                        this.output.sampleMetadata(this.timeUs, 1, v3, 0, null);
                        this.timeUs += this.sampleDurationUs;
                        this.state = 0;
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
            else if(this.skipToNextSync(parsableByteArray0)) {
                this.state = 1;
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
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.timeUs = v;
    }

    private void parseHeader() {
        byte[] arr_b = this.headerScratchBytes.data;
        if(this.format == null) {
            Format format0 = DtsUtil.parseDtsFormat(arr_b, this.formatId, this.language, null);
            this.format = format0;
            this.output.format(format0);
        }
        this.sampleSize = DtsUtil.getDtsFrameSize(arr_b);
        this.sampleDurationUs = (long)(((int)(((long)DtsUtil.parseDtsAudioSampleCount(arr_b)) * 1000000L / ((long)this.format.sampleRate))));
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.syncBytes = 0;
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray0) {
        while(parsableByteArray0.bytesLeft() > 0) {
            int v = this.syncBytes << 8;
            this.syncBytes = v;
            int v1 = v | parsableByteArray0.readUnsignedByte();
            this.syncBytes = v1;
            if(DtsUtil.isSyncWord(v1)) {
                byte[] arr_b = this.headerScratchBytes.data;
                int v2 = this.syncBytes;
                arr_b[0] = (byte)(v2 >> 24 & 0xFF);
                arr_b[1] = (byte)(v2 >> 16 & 0xFF);
                arr_b[2] = (byte)(v2 >> 8 & 0xFF);
                arr_b[3] = (byte)(v2 & 0xFF);
                this.bytesRead = 4;
                this.syncBytes = 0;
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }
}

