package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.VorbisUtil.CommentHeader;
import com.google.android.exoplayer2.extractor.VorbisUtil.Mode;
import com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;

final class VorbisReader extends StreamReader {
    static final class VorbisSetup {
        public final CommentHeader commentHeader;
        public final int iLogModes;
        public final VorbisIdHeader idHeader;
        public final Mode[] modes;
        public final byte[] setupHeaderData;

        public VorbisSetup(VorbisIdHeader vorbisUtil$VorbisIdHeader0, CommentHeader vorbisUtil$CommentHeader0, byte[] arr_b, Mode[] arr_vorbisUtil$Mode, int v) {
            this.idHeader = vorbisUtil$VorbisIdHeader0;
            this.commentHeader = vorbisUtil$CommentHeader0;
            this.setupHeaderData = arr_b;
            this.modes = arr_vorbisUtil$Mode;
            this.iLogModes = v;
        }
    }

    private CommentHeader commentHeader;
    private int previousPacketBlockSize;
    private boolean seenFirstAudioPacket;
    private VorbisIdHeader vorbisIdHeader;
    private VorbisSetup vorbisSetup;

    public static void appendNumberOfSamples(ParsableByteArray parsableByteArray0, long v) {
        parsableByteArray0.setLimit(parsableByteArray0.limit() + 4);
        parsableByteArray0.data[parsableByteArray0.limit() - 4] = (byte)(((int)(v & 0xFFL)));
        parsableByteArray0.data[parsableByteArray0.limit() - 3] = (byte)(((int)(v >>> 8 & 0xFFL)));
        parsableByteArray0.data[parsableByteArray0.limit() - 2] = (byte)(((int)(v >>> 16 & 0xFFL)));
        parsableByteArray0.data[parsableByteArray0.limit() - 1] = (byte)(((int)(v >>> 24 & 0xFFL)));
    }

    private static int decodeBlockSize(byte b, VorbisSetup vorbisReader$VorbisSetup0) {
        return vorbisReader$VorbisSetup0.modes[b >> 1 & 0xFF >>> 8 - vorbisReader$VorbisSetup0.iLogModes].blockFlag ? vorbisReader$VorbisSetup0.idHeader.blockSize1 : vorbisReader$VorbisSetup0.idHeader.blockSize0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void onSeekEnd(long v) {
        super.onSeekEnd(v);
        int v1 = 0;
        this.seenFirstAudioPacket = Long.compare(v, 0L) != 0;
        VorbisIdHeader vorbisUtil$VorbisIdHeader0 = this.vorbisIdHeader;
        if(vorbisUtil$VorbisIdHeader0 != null) {
            v1 = vorbisUtil$VorbisIdHeader0.blockSize0;
        }
        this.previousPacketBlockSize = v1;
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(ParsableByteArray parsableByteArray0) {
        int v = 0;
        int v1 = parsableByteArray0.data[0];
        if((v1 & 1) == 1) {
            return -1L;
        }
        int v2 = VorbisReader.decodeBlockSize(((byte)v1), this.vorbisSetup);
        if(this.seenFirstAudioPacket) {
            v = (this.previousPacketBlockSize + v2) / 4;
        }
        VorbisReader.appendNumberOfSamples(parsableByteArray0, ((long)v));
        this.seenFirstAudioPacket = true;
        this.previousPacketBlockSize = v2;
        return (long)v;
    }

    public static int readBits(byte b, int v, int v1) [...] // Inlined contents

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean readHeaders(ParsableByteArray parsableByteArray0, long v, SetupData streamReader$SetupData0) {
        if(this.vorbisSetup != null) {
            return false;
        }
        VorbisSetup vorbisReader$VorbisSetup0 = this.readSetupHeaders(parsableByteArray0);
        this.vorbisSetup = vorbisReader$VorbisSetup0;
        if(vorbisReader$VorbisSetup0 == null) {
            return true;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(this.vorbisSetup.idHeader.data);
        arrayList0.add(this.vorbisSetup.setupHeaderData);
        streamReader$SetupData0.format = Format.createAudioSampleFormat(null, "audio/vorbis", null, this.vorbisSetup.idHeader.bitrateNominal, -1, this.vorbisSetup.idHeader.channels, ((int)this.vorbisSetup.idHeader.sampleRate), arrayList0, null, 0, null);
        return true;
    }

    public VorbisSetup readSetupHeaders(ParsableByteArray parsableByteArray0) {
        if(this.vorbisIdHeader == null) {
            this.vorbisIdHeader = VorbisUtil.readVorbisIdentificationHeader(parsableByteArray0);
            return null;
        }
        if(this.commentHeader == null) {
            this.commentHeader = VorbisUtil.readVorbisCommentHeader(parsableByteArray0);
            return null;
        }
        byte[] arr_b = new byte[parsableByteArray0.limit()];
        System.arraycopy(parsableByteArray0.data, 0, arr_b, 0, parsableByteArray0.limit());
        Mode[] arr_vorbisUtil$Mode = VorbisUtil.readVorbisModes(parsableByteArray0, this.vorbisIdHeader.channels);
        return new VorbisSetup(this.vorbisIdHeader, this.commentHeader, arr_b, arr_vorbisUtil$Mode, VorbisUtil.iLog(arr_vorbisUtil$Mode.length - 1));
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if(z) {
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray0) {
        try {
            return VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray0, true);
        }
        catch(ParserException unused_ex) {
            return false;
        }
    }
}

