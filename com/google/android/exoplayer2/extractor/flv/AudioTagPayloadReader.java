package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int AUDIO_FORMAT_AAC = 10;
    private static final int AUDIO_FORMAT_ALAW = 7;
    private static final int AUDIO_FORMAT_MP3 = 2;
    private static final int AUDIO_FORMAT_ULAW = 8;
    private static final int[] AUDIO_SAMPLING_RATE_TABLE;
    private int audioFormat;
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;

    static {
        AudioTagPayloadReader.AUDIO_SAMPLING_RATE_TABLE = new int[]{5512, 11025, 22050, 44100};
    }

    public AudioTagPayloadReader(TrackOutput trackOutput0) {
        super(trackOutput0);
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(ParsableByteArray parsableByteArray0) {
        if(!this.hasParsedAudioDataHeader) {
            int v = parsableByteArray0.readUnsignedByte();
            int v1 = v >> 4 & 15;
            this.audioFormat = v1;
            if(v1 == 2) {
                Format format0 = Format.createAudioSampleFormat(null, "audio/mpeg", null, -1, -1, 1, AudioTagPayloadReader.AUDIO_SAMPLING_RATE_TABLE[v >> 2 & 3], null, null, 0, null);
                this.output.format(format0);
                this.hasOutputFormat = true;
            }
            else {
                switch(v1) {
                    case 7: 
                    case 8: {
                        Format format1 = Format.createAudioSampleFormat(null, (v1 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw"), null, -1, -1, 1, 8000, -1, null, null, 0, null);
                        this.output.format(format1);
                        this.hasOutputFormat = true;
                        break;
                    }
                    case 10: {
                        break;
                    }
                    default: {
                        throw new UnsupportedFormatException("Audio format not supported: " + this.audioFormat);
                    }
                }
            }
            this.hasParsedAudioDataHeader = true;
            return true;
        }
        parsableByteArray0.skipBytes(1);
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parsePayload(ParsableByteArray parsableByteArray0, long v) {
        if(this.audioFormat == 2) {
            int v1 = parsableByteArray0.bytesLeft();
            this.output.sampleData(parsableByteArray0, v1);
            this.output.sampleMetadata(v, 1, v1, 0, null);
            return true;
        }
        int v2 = parsableByteArray0.readUnsignedByte();
        if(v2 == 0 && !this.hasOutputFormat) {
            int v3 = parsableByteArray0.bytesLeft();
            byte[] arr_b = new byte[v3];
            parsableByteArray0.readBytes(arr_b, 0, v3);
            Pair pair0 = CodecSpecificDataUtil.parseAacAudioSpecificConfig(arr_b);
            Format format0 = Format.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((int)(((Integer)pair0.second))), ((int)(((Integer)pair0.first))), Collections.singletonList(arr_b), null, 0, null);
            this.output.format(format0);
            this.hasOutputFormat = true;
            return false;
        }
        if(this.audioFormat == 10 && v2 != 1) {
            return false;
        }
        int v4 = parsableByteArray0.bytesLeft();
        this.output.sampleData(parsableByteArray0, v4);
        this.output.sampleMetadata(v, 1, v4, 0, null);
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }
}

