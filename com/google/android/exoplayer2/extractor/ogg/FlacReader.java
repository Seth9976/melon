package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FlacStreamMetadata.SeekTable;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

final class FlacReader extends StreamReader {
    class FlacOggSeeker implements OggSeeker {
        private long firstFrameOffset;
        private long pendingSeekGranule;

        public FlacOggSeeker() {
            this.firstFrameOffset = -1L;
            this.pendingSeekGranule = -1L;
        }

        @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            Assertions.checkState(this.firstFrameOffset != -1L);
            return new FlacSeekTableSeekMap(FlacReader.this.streamMetadata, this.firstFrameOffset);
        }

        @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput extractorInput0) {
            long v = this.pendingSeekGranule;
            if(Long.compare(v, 0L) >= 0) {
                this.pendingSeekGranule = -1L;
                return -(v + 2L);
            }
            return -1L;
        }

        public void setFirstFrameOffset(long v) {
            this.firstFrameOffset = v;
        }

        @Override  // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void startSeek(long v) {
            Assertions.checkNotNull(FlacReader.this.streamMetadata.seekTable);
            FlacStreamMetadata flacStreamMetadata0 = FlacReader.this.streamMetadata;
            this.pendingSeekGranule = flacStreamMetadata0.seekTable.pointSampleNumbers[Util.binarySearchFloor(flacStreamMetadata0.seekTable.pointSampleNumbers, v, true, true)];
        }
    }

    private static final byte AUDIO_PACKET_TYPE = -1;
    private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
    private FlacOggSeeker flacOggSeeker;
    private FlacStreamMetadata streamMetadata;

    private int getFlacFrameBlockSize(ParsableByteArray parsableByteArray0) {
        int v = (parsableByteArray0.data[2] & 0xFF) >> 4;
        if(v == 6 || v == 7) {
            parsableByteArray0.skipBytes(4);
            parsableByteArray0.readUtf8EncodedLong();
        }
        int v1 = FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray0, v);
        parsableByteArray0.setPosition(0);
        return v1;
    }

    private static boolean isAudioPacket(byte[] arr_b) {
        return arr_b[0] == -1;
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(ParsableByteArray parsableByteArray0) {
        return FlacReader.isAudioPacket(parsableByteArray0.data) ? ((long)this.getFlacFrameBlockSize(parsableByteArray0)) : -1L;
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean readHeaders(ParsableByteArray parsableByteArray0, long v, SetupData streamReader$SetupData0) {
        byte[] arr_b = parsableByteArray0.data;
        if(this.streamMetadata == null) {
            this.streamMetadata = new FlacStreamMetadata(arr_b, 17);
            byte[] arr_b1 = Arrays.copyOfRange(arr_b, 9, parsableByteArray0.limit());
            streamReader$SetupData0.format = this.streamMetadata.getFormat(arr_b1, null);
            return true;
        }
        if((arr_b[0] & 0x7F) == 3) {
            this.flacOggSeeker = new FlacOggSeeker(this);
            SeekTable flacStreamMetadata$SeekTable0 = FlacMetadataReader.readSeekTableMetadataBlock(parsableByteArray0);
            this.streamMetadata = this.streamMetadata.copyWithSeekTable(flacStreamMetadata$SeekTable0);
            return true;
        }
        if(FlacReader.isAudioPacket(arr_b)) {
            FlacOggSeeker flacReader$FlacOggSeeker0 = this.flacOggSeeker;
            if(flacReader$FlacOggSeeker0 != null) {
                flacReader$FlacOggSeeker0.setFirstFrameOffset(v);
                streamReader$SetupData0.oggSeeker = this.flacOggSeeker;
            }
            return false;
        }
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if(z) {
            this.streamMetadata = null;
            this.flacOggSeeker = null;
        }
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray0) {
        return parsableByteArray0.bytesLeft() >= 5 && parsableByteArray0.readUnsignedByte() == 0x7F && parsableByteArray0.readUnsignedInt() == 1179402563L;
    }
}

