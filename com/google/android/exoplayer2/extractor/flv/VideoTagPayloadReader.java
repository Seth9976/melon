package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;

final class VideoTagPayloadReader extends TagPayloadReader {
    private static final int AVC_PACKET_TYPE_AVC_NALU = 1;
    private static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int VIDEO_CODEC_AVC = 7;
    private static final int VIDEO_FRAME_KEYFRAME = 1;
    private static final int VIDEO_FRAME_VIDEO_INFO = 5;
    private int frameType;
    private boolean hasOutputFormat;
    private boolean hasOutputKeyframe;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;

    public VideoTagPayloadReader(TrackOutput trackOutput0) {
        super(trackOutput0);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readUnsignedByte();
        int v1 = v >> 4 & 15;
        if((v & 15) != 7) {
            throw new UnsupportedFormatException("Video format not supported: " + (v & 15));
        }
        this.frameType = v1;
        return v1 != 5;
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parsePayload(ParsableByteArray parsableByteArray0, long v) {
        int v1 = parsableByteArray0.readUnsignedByte();
        long v2 = ((long)parsableByteArray0.readInt24()) * 1000L + v;
        if(v1 == 0 && !this.hasOutputFormat) {
            ParsableByteArray parsableByteArray1 = new ParsableByteArray(new byte[parsableByteArray0.bytesLeft()]);
            parsableByteArray0.readBytes(parsableByteArray1.data, 0, parsableByteArray0.bytesLeft());
            AvcConfig avcConfig0 = AvcConfig.parse(parsableByteArray1);
            this.nalUnitLengthFieldLength = avcConfig0.nalUnitLengthFieldLength;
            Format format0 = Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, avcConfig0.width, avcConfig0.height, -1.0f, avcConfig0.initializationData, -1, avcConfig0.pixelWidthAspectRatio, null);
            this.output.format(format0);
            this.hasOutputFormat = true;
            return false;
        }
        if(v1 == 1 && this.hasOutputFormat) {
            int v3 = this.frameType == 1 ? 1 : 0;
            if(!this.hasOutputKeyframe && v3 == 0) {
                return false;
            }
            byte[] arr_b = this.nalLength.data;
            arr_b[0] = 0;
            arr_b[1] = 0;
            arr_b[2] = 0;
            int v4 = 4 - this.nalUnitLengthFieldLength;
            int v5;
            for(v5 = 0; parsableByteArray0.bytesLeft() > 0; v5 = v5 + 4 + v6) {
                parsableByteArray0.readBytes(this.nalLength.data, v4, this.nalUnitLengthFieldLength);
                this.nalLength.setPosition(0);
                int v6 = this.nalLength.readUnsignedIntToInt();
                this.nalStartCode.setPosition(0);
                this.output.sampleData(this.nalStartCode, 4);
                this.output.sampleData(parsableByteArray0, v6);
            }
            this.output.sampleMetadata(v2, v3, v5, 0, null);
            this.hasOutputKeyframe = true;
            return true;
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
        this.hasOutputKeyframe = false;
    }
}

