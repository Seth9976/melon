package com.google.android.exoplayer2.extractor.ts;

import b3.Z;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PesReader implements TsPayloadReader {
    private static final int HEADER_SIZE = 9;
    private static final int MAX_HEADER_EXTENSION_SIZE = 10;
    private static final int PES_SCRATCH_SIZE = 10;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_BODY = 3;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_HEADER_EXTENSION = 2;
    private static final String TAG = "PesReader";
    private int bytesRead;
    private boolean dataAlignmentIndicator;
    private boolean dtsFlag;
    private int extendedHeaderLength;
    private int payloadSize;
    private final ParsableBitArray pesScratch;
    private boolean ptsFlag;
    private final ElementaryStreamReader reader;
    private boolean seenFirstDts;
    private int state;
    private long timeUs;
    private TimestampAdjuster timestampAdjuster;

    public PesReader(ElementaryStreamReader elementaryStreamReader0) {
        this.reader = elementaryStreamReader0;
        this.pesScratch = new ParsableBitArray(new byte[10]);
        this.state = 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void consume(ParsableByteArray parsableByteArray0, int v) {
        if((v & 1) != 0) {
            int v1 = this.state;
            if(v1 != 0 && v1 != 1) {
                switch(v1) {
                    case 2: {
                        Log.w("PesReader", "Unexpected start indicator reading extended header");
                        break;
                    }
                    case 3: {
                        int v2 = this.payloadSize;
                        if(v2 != -1) {
                            Log.w("PesReader", "Unexpected start indicator: expected " + v2 + " more bytes");
                        }
                        this.reader.packetFinished();
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
            this.setState(1);
        }
        while(parsableByteArray0.bytesLeft() > 0) {
            int v3 = 0;
            int v4 = this.state;
            if(v4 == 0) {
                parsableByteArray0.skipBytes(parsableByteArray0.bytesLeft());
            }
            else {
                switch(v4) {
                    case 1: {
                        if(!this.continueRead(parsableByteArray0, this.pesScratch.data, 9)) {
                            break;
                        }
                        if(this.parseHeader()) {
                            v3 = 2;
                        }
                        this.setState(v3);
                        break;
                    }
                    case 2: {
                        if(!this.continueRead(parsableByteArray0, this.pesScratch.data, Math.min(10, this.extendedHeaderLength)) || !this.continueRead(parsableByteArray0, null, this.extendedHeaderLength)) {
                            break;
                        }
                        this.parseHeaderExtension();
                        if(this.dataAlignmentIndicator) {
                            v3 = 4;
                        }
                        v |= v3;
                        this.reader.packetStarted(this.timeUs, v);
                        this.setState(3);
                        break;
                    }
                    case 3: {
                        int v5 = parsableByteArray0.bytesLeft();
                        int v6 = this.payloadSize;
                        if(v6 != -1) {
                            v3 = v5 - v6;
                        }
                        if(v3 > 0) {
                            v5 -= v3;
                            parsableByteArray0.setLimit(parsableByteArray0.getPosition() + v5);
                        }
                        this.reader.consume(parsableByteArray0);
                        int v7 = this.payloadSize;
                        if(v7 == -1) {
                            break;
                        }
                        int v8 = v7 - v5;
                        this.payloadSize = v8;
                        if(v8 != 0) {
                            break;
                        }
                        this.reader.packetFinished();
                        this.setState(1);
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
        }
    }

    private boolean continueRead(ParsableByteArray parsableByteArray0, byte[] arr_b, int v) {
        int v1 = Math.min(parsableByteArray0.bytesLeft(), v - this.bytesRead);
        if(v1 <= 0) {
            return true;
        }
        if(arr_b == null) {
            parsableByteArray0.skipBytes(v1);
        }
        else {
            parsableByteArray0.readBytes(arr_b, this.bytesRead, v1);
        }
        int v2 = this.bytesRead + v1;
        this.bytesRead = v2;
        return v2 == v;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster0, ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        this.timestampAdjuster = timestampAdjuster0;
        this.reader.createTracks(extractorOutput0, tsPayloadReader$TrackIdGenerator0);
    }

    private boolean parseHeader() {
        this.pesScratch.setPosition(0);
        int v = this.pesScratch.readBits(24);
        if(v != 1) {
            Z.q(41, v, "Unexpected start code prefix: ", "PesReader");
            this.payloadSize = -1;
            return false;
        }
        this.pesScratch.skipBits(8);
        int v1 = this.pesScratch.readBits(16);
        this.pesScratch.skipBits(5);
        this.dataAlignmentIndicator = this.pesScratch.readBit();
        this.pesScratch.skipBits(2);
        this.ptsFlag = this.pesScratch.readBit();
        this.dtsFlag = this.pesScratch.readBit();
        this.pesScratch.skipBits(6);
        int v2 = this.pesScratch.readBits(8);
        this.extendedHeaderLength = v2;
        if(v1 == 0) {
            this.payloadSize = -1;
            return true;
        }
        this.payloadSize = v1 - 3 - v2;
        return true;
    }

    private void parseHeaderExtension() {
        this.pesScratch.setPosition(0);
        this.timeUs = 0x8000000000000001L;
        if(this.ptsFlag) {
            this.pesScratch.skipBits(4);
            long v = ((long)this.pesScratch.readBits(3)) << 30;
            this.pesScratch.skipBits(1);
            int v1 = this.pesScratch.readBits(15);
            this.pesScratch.skipBits(1);
            long v2 = v | ((long)(v1 << 15)) | ((long)this.pesScratch.readBits(15));
            this.pesScratch.skipBits(1);
            if(!this.seenFirstDts && this.dtsFlag) {
                this.pesScratch.skipBits(4);
                long v3 = ((long)this.pesScratch.readBits(3)) << 30;
                this.pesScratch.skipBits(1);
                int v4 = this.pesScratch.readBits(15);
                this.pesScratch.skipBits(1);
                long v5 = v3 | ((long)(v4 << 15)) | ((long)this.pesScratch.readBits(15));
                this.pesScratch.skipBits(1);
                this.timestampAdjuster.adjustTsTimestamp(v5);
                this.seenFirstDts = true;
            }
            this.timeUs = this.timestampAdjuster.adjustTsTimestamp(v2);
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.seenFirstDts = false;
        this.reader.seek();
    }

    private void setState(int v) {
        this.state = v;
        this.bytesRead = 0;
    }
}

