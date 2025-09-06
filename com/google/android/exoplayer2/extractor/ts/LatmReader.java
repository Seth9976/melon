package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

public final class LatmReader implements ElementaryStreamReader {
    private static final int INITIAL_BUFFER_SIZE = 0x400;
    private static final int STATE_FINDING_SYNC_1 = 0;
    private static final int STATE_FINDING_SYNC_2 = 1;
    private static final int STATE_READING_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 3;
    private static final int SYNC_BYTE_FIRST = 86;
    private static final int SYNC_BYTE_SECOND = 0xE0;
    private int audioMuxVersionA;
    private int bytesRead;
    private int channelCount;
    private Format format;
    private String formatId;
    private int frameLengthType;
    private final String language;
    private int numSubframes;
    private long otherDataLenBits;
    private boolean otherDataPresent;
    private TrackOutput output;
    private final ParsableBitArray sampleBitArray;
    private final ParsableByteArray sampleDataBuffer;
    private long sampleDurationUs;
    private int sampleRateHz;
    private int sampleSize;
    private int secondHeaderByte;
    private int state;
    private boolean streamMuxRead;
    private long timeUs;

    public LatmReader(String s) {
        this.language = s;
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(0x400);
        this.sampleDataBuffer = parsableByteArray0;
        this.sampleBitArray = new ParsableBitArray(parsableByteArray0.data);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        while(parsableByteArray0.bytesLeft() > 0) {
            switch(this.state) {
                case 0: {
                    if(parsableByteArray0.readUnsignedByte() != 86) {
                        continue;
                    }
                    this.state = 1;
                    continue;
                }
                case 1: {
                    int v = parsableByteArray0.readUnsignedByte();
                    if((v & 0xE0) == 0xE0) {
                        this.secondHeaderByte = v;
                        this.state = 2;
                    }
                    else {
                        if(v == 86) {
                            continue;
                        }
                        this.state = 0;
                    }
                    continue;
                }
                case 2: {
                    int v1 = (this.secondHeaderByte & 0xFFFFFF1F) << 8 | parsableByteArray0.readUnsignedByte();
                    this.sampleSize = v1;
                    if(v1 > this.sampleDataBuffer.data.length) {
                        this.resetBufferForSize(v1);
                    }
                    this.bytesRead = 0;
                    this.state = 3;
                    continue;
                }
                case 3: {
                    int v2 = Math.min(parsableByteArray0.bytesLeft(), this.sampleSize - this.bytesRead);
                    parsableByteArray0.readBytes(this.sampleBitArray.data, this.bytesRead, v2);
                    int v3 = this.bytesRead + v2;
                    this.bytesRead = v3;
                    if(v3 == this.sampleSize) {
                        break;
                    }
                    continue;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            this.sampleBitArray.setPosition(0);
            this.parseAudioMuxElement(this.sampleBitArray);
            this.state = 0;
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        this.output = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 1);
        this.formatId = tsPayloadReader$TrackIdGenerator0.getFormatId();
    }

    private static long latmGetValue(ParsableBitArray parsableBitArray0) {
        return (long)parsableBitArray0.readBits((parsableBitArray0.readBits(2) + 1) * 8);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.timeUs = v;
    }

    private void parseAudioMuxElement(ParsableBitArray parsableBitArray0) {
        if(!parsableBitArray0.readBit()) {
            this.streamMuxRead = true;
            this.parseStreamMuxConfig(parsableBitArray0);
            goto label_5;
        }
        else if(this.streamMuxRead) {
        label_5:
            if(this.audioMuxVersionA != 0 || this.numSubframes != 0) {
                throw new ParserException();
            }
            this.parsePayloadMux(parsableBitArray0, this.parsePayloadLengthInfo(parsableBitArray0));
            if(this.otherDataPresent) {
                parsableBitArray0.skipBits(((int)this.otherDataLenBits));
            }
        }
    }

    private int parseAudioSpecificConfig(ParsableBitArray parsableBitArray0) {
        Pair pair0 = CodecSpecificDataUtil.parseAacAudioSpecificConfig(parsableBitArray0, true);
        this.sampleRateHz = (int)(((Integer)pair0.first));
        this.channelCount = (int)(((Integer)pair0.second));
        return 0;
    }

    private void parseFrameLength(ParsableBitArray parsableBitArray0) {
        int v = parsableBitArray0.readBits(3);
        this.frameLengthType = v;
        switch(v) {
            case 0: {
                parsableBitArray0.skipBits(8);
                return;
            }
            case 1: {
                parsableBitArray0.skipBits(9);
                return;
            }
            case 3: 
            case 4: 
            case 5: {
                parsableBitArray0.skipBits(6);
                return;
            label_10:
                if(v != 7) {
                    throw new IllegalStateException();
                }
                break;
            }
            case 6: {
                break;
            }
            default: {
                goto label_10;
            }
        }
        parsableBitArray0.skipBits(1);
    }

    private int parsePayloadLengthInfo(ParsableBitArray parsableBitArray0) {
        if(this.frameLengthType != 0) {
            throw new ParserException();
        }
        int v = 0;
        do {
            int v1 = parsableBitArray0.readBits(8);
            v += v1;
        }
        while(v1 == 0xFF);
        return v;
    }

    private void parsePayloadMux(ParsableBitArray parsableBitArray0, int v) {
        int v1 = parsableBitArray0.getPosition();
        if((v1 & 7) == 0) {
            this.sampleDataBuffer.setPosition(v1 >> 3);
        }
        else {
            parsableBitArray0.readBits(this.sampleDataBuffer.data, 0, v * 8);
            this.sampleDataBuffer.setPosition(0);
        }
        this.output.sampleData(this.sampleDataBuffer, v);
        this.output.sampleMetadata(this.timeUs, 1, v, 0, null);
        this.timeUs += this.sampleDurationUs;
    }

    private void parseStreamMuxConfig(ParsableBitArray parsableBitArray0) {
        int v = parsableBitArray0.readBits(1);
        int v1 = v == 1 ? parsableBitArray0.readBits(1) : 0;
        this.audioMuxVersionA = v1;
        if(v1 != 0) {
            throw new ParserException();
        }
        if(v == 1) {
            LatmReader.latmGetValue(parsableBitArray0);
        }
        if(!parsableBitArray0.readBit()) {
            throw new ParserException();
        }
        this.numSubframes = parsableBitArray0.readBits(6);
        if(parsableBitArray0.readBits(4) != 0 || parsableBitArray0.readBits(3) != 0) {
            throw new ParserException();
        }
        if(v == 0) {
            int v2 = this.parseAudioSpecificConfig(parsableBitArray0);
            parsableBitArray0.setPosition(parsableBitArray0.getPosition());
            byte[] arr_b = new byte[(v2 + 7) / 8];
            parsableBitArray0.readBits(arr_b, 0, v2);
            Format format0 = Format.createAudioSampleFormat(this.formatId, "audio/mp4a-latm", null, -1, -1, this.channelCount, this.sampleRateHz, Collections.singletonList(arr_b), null, 0, this.language);
            if(!format0.equals(this.format)) {
                this.format = format0;
                this.sampleDurationUs = 1024000000L / ((long)format0.sampleRate);
                this.output.format(format0);
            }
        }
        else {
            parsableBitArray0.skipBits(((int)LatmReader.latmGetValue(parsableBitArray0)) - this.parseAudioSpecificConfig(parsableBitArray0));
        }
        this.parseFrameLength(parsableBitArray0);
        boolean z = parsableBitArray0.readBit();
        this.otherDataPresent = z;
        this.otherDataLenBits = 0L;
        if(z) {
            if(v == 1) {
                this.otherDataLenBits = LatmReader.latmGetValue(parsableBitArray0);
            }
            else {
                while(true) {
                    boolean z1 = parsableBitArray0.readBit();
                    this.otherDataLenBits = (this.otherDataLenBits << 8) + ((long)parsableBitArray0.readBits(8));
                    if(!z1) {
                        break;
                    }
                }
            }
        }
        if(parsableBitArray0.readBit()) {
            parsableBitArray0.skipBits(8);
        }
    }

    private void resetBufferForSize(int v) {
        this.sampleDataBuffer.reset(v);
        this.sampleBitArray.reset(this.sampleDataBuffer.data);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.streamMuxRead = false;
    }
}

