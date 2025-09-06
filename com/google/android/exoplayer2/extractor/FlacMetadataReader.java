package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.FlacStreamMetadata.SeekTable;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FlacMetadataReader {
    public static final class FlacStreamMetadataHolder {
        public FlacStreamMetadata flacStreamMetadata;

        public FlacStreamMetadataHolder(FlacStreamMetadata flacStreamMetadata0) {
            this.flacStreamMetadata = flacStreamMetadata0;
        }
    }

    private static final int SEEK_POINT_SIZE = 18;
    private static final int STREAM_MARKER = 0x664C6143;
    private static final int SYNC_CODE = 0x3FFE;

    public static boolean checkAndPeekStreamMarker(ExtractorInput extractorInput0) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(4);
        extractorInput0.peekFully(parsableByteArray0.data, 0, 4);
        return parsableByteArray0.readUnsignedInt() == 0x664C6143L;
    }

    public static int getFrameStartMarker(ExtractorInput extractorInput0) {
        extractorInput0.resetPeekPosition();
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(2);
        extractorInput0.peekFully(parsableByteArray0.data, 0, 2);
        int v = parsableByteArray0.readUnsignedShort();
        if(v >> 2 == 0x3FFE) {
            extractorInput0.resetPeekPosition();
            return v;
        }
        extractorInput0.resetPeekPosition();
        throw new ParserException("First frame does not start with sync code.");
    }

    public static Metadata peekId3Metadata(ExtractorInput extractorInput0, boolean z) {
        Metadata metadata0 = new Id3Peeker().peekId3Data(extractorInput0, (z ? null : Id3Decoder.NO_FRAMES_PREDICATE));
        return metadata0 == null || metadata0.length() == 0 ? null : metadata0;
    }

    public static Metadata readId3Metadata(ExtractorInput extractorInput0, boolean z) {
        extractorInput0.resetPeekPosition();
        long v = extractorInput0.getPeekPosition();
        Metadata metadata0 = FlacMetadataReader.peekId3Metadata(extractorInput0, z);
        extractorInput0.skipFully(((int)(extractorInput0.getPeekPosition() - v)));
        return metadata0;
    }

    public static boolean readMetadataBlock(ExtractorInput extractorInput0, FlacStreamMetadataHolder flacMetadataReader$FlacStreamMetadataHolder0) {
        extractorInput0.resetPeekPosition();
        ParsableBitArray parsableBitArray0 = new ParsableBitArray(new byte[4]);
        extractorInput0.peekFully(parsableBitArray0.data, 0, 4);
        boolean z = parsableBitArray0.readBit();
        int v = parsableBitArray0.readBits(7);
        int v1 = parsableBitArray0.readBits(24);
        if(v == 0) {
            flacMetadataReader$FlacStreamMetadataHolder0.flacStreamMetadata = FlacMetadataReader.readStreamInfoBlock(extractorInput0);
            return z;
        }
        FlacStreamMetadata flacStreamMetadata0 = flacMetadataReader$FlacStreamMetadataHolder0.flacStreamMetadata;
        if(flacStreamMetadata0 != null) {
            switch(v) {
                case 3: {
                    flacMetadataReader$FlacStreamMetadataHolder0.flacStreamMetadata = flacStreamMetadata0.copyWithSeekTable(FlacMetadataReader.readSeekTableMetadataBlock(extractorInput0, v1 + 4));
                    return z;
                }
                case 4: {
                    flacMetadataReader$FlacStreamMetadataHolder0.flacStreamMetadata = flacStreamMetadata0.copyWithVorbisComments(FlacMetadataReader.readVorbisCommentMetadataBlock(extractorInput0, v1 + 4));
                    return z;
                }
                case 6: {
                    flacMetadataReader$FlacStreamMetadataHolder0.flacStreamMetadata = flacStreamMetadata0.copyWithPictureFrames(Collections.singletonList(FlacMetadataReader.readPictureMetadataBlock(extractorInput0, v1 + 4)));
                    return z;
                }
                default: {
                    extractorInput0.skipFully(v1 + 4);
                    return z;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private static PictureFrame readPictureMetadataBlock(ExtractorInput extractorInput0, int v) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(v);
        extractorInput0.readFully(parsableByteArray0.data, 0, v);
        parsableByteArray0.skipBytes(4);
        int v1 = parsableByteArray0.readInt();
        String s = parsableByteArray0.readString(parsableByteArray0.readInt(), Charset.forName("US-ASCII"));
        String s1 = parsableByteArray0.readString(parsableByteArray0.readInt());
        int v2 = parsableByteArray0.readInt();
        int v3 = parsableByteArray0.readInt();
        int v4 = parsableByteArray0.readInt();
        int v5 = parsableByteArray0.readInt();
        int v6 = parsableByteArray0.readInt();
        byte[] arr_b = new byte[v6];
        parsableByteArray0.readBytes(arr_b, 0, v6);
        return new PictureFrame(v1, s, s1, v2, v3, v4, v5, arr_b);
    }

    private static SeekTable readSeekTableMetadataBlock(ExtractorInput extractorInput0, int v) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(v);
        extractorInput0.readFully(parsableByteArray0.data, 0, v);
        return FlacMetadataReader.readSeekTableMetadataBlock(parsableByteArray0);
    }

    public static SeekTable readSeekTableMetadataBlock(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.skipBytes(1);
        int v = parsableByteArray0.readUnsignedInt24();
        int v1 = parsableByteArray0.getPosition();
        long[] arr_v = new long[v / 18];
        long[] arr_v1 = new long[v / 18];
        for(int v2 = 0; v2 < v / 18; ++v2) {
            long v3 = parsableByteArray0.readLong();
            if(v3 == -1L) {
                arr_v = Arrays.copyOf(arr_v, v2);
                arr_v1 = Arrays.copyOf(arr_v1, v2);
                break;
            }
            arr_v[v2] = v3;
            arr_v1[v2] = parsableByteArray0.readLong();
            parsableByteArray0.skipBytes(2);
        }
        parsableByteArray0.skipBytes(((int)(((long)(v1 + v)) - ((long)parsableByteArray0.getPosition()))));
        return new SeekTable(arr_v, arr_v1);
    }

    private static FlacStreamMetadata readStreamInfoBlock(ExtractorInput extractorInput0) {
        byte[] arr_b = new byte[38];
        extractorInput0.readFully(arr_b, 0, 38);
        return new FlacStreamMetadata(arr_b, 4);
    }

    public static void readStreamMarker(ExtractorInput extractorInput0) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(4);
        extractorInput0.readFully(parsableByteArray0.data, 0, 4);
        if(parsableByteArray0.readUnsignedInt() != 0x664C6143L) {
            throw new ParserException("Failed to read FLAC stream marker.");
        }
    }

    private static List readVorbisCommentMetadataBlock(ExtractorInput extractorInput0, int v) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(v);
        extractorInput0.readFully(parsableByteArray0.data, 0, v);
        parsableByteArray0.skipBytes(4);
        return Arrays.asList(VorbisUtil.readVorbisCommentHeader(parsableByteArray0, false, false).comments);
    }
}

