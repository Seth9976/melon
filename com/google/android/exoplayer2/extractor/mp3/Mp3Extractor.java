package com.google.android.exoplayer2.extractor.mp3;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Mp3Extractor implements Extractor {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_DISABLE_ID3_METADATA = 2;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_SNIFF_BYTES = 0x4000;
    private static final int MAX_SYNC_BYTES = 0x20000;
    private static final int MPEG_AUDIO_HEADER_MASK = 0xFFFE0C00;
    private static final FramePredicate REQUIRED_ID3_FRAME_PREDICATE = null;
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_INFO = 0x496E666F;
    private static final int SEEK_HEADER_UNSET = 0;
    private static final int SEEK_HEADER_VBRI = 1447187017;
    private static final int SEEK_HEADER_XING = 1483304551;
    private long basisTimeUs;
    private boolean disableSeeking;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private Metadata metadata;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private Seeker seeker;
    private final MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;

    static {
        Mp3Extractor.FACTORY = new b(16);
        Mp3Extractor.REQUIRED_ID3_FRAME_PREDICATE = new b(17);
    }

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int v) {
        this(v, 0x8000000000000001L);
    }

    public Mp3Extractor(int v, long v1) {
        this.flags = v;
        this.forcedFirstSampleTimestampUs = v1;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioHeader();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = 0x8000000000000001L;
        this.id3Peeker = new Id3Peeker();
    }

    public static Extractor[] a() {
        return Mp3Extractor.lambda$static$0();
    }

    public static boolean b(int v, int v1, int v2, int v3, int v4) {
        return Mp3Extractor.lambda$static$1(v, v1, v2, v3, v4);
    }

    public void disableSeeking() {
        this.disableSeeking = true;
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput0) {
        extractorInput0.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
        return new ConstantBitrateSeeker(extractorInput0.getLength(), extractorInput0.getPosition(), this.synchronizedHeader);
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray0, int v) {
        if(parsableByteArray0.limit() >= v + 4) {
            parsableByteArray0.setPosition(v);
            int v1 = parsableByteArray0.readInt();
            if(v1 == 0x496E666F || v1 == 1483304551) {
                return v1;
            }
        }
        if(parsableByteArray0.limit() >= 40) {
            parsableByteArray0.setPosition(36);
            return parsableByteArray0.readInt() == 1447187017 ? 1447187017 : 0;
        }
        return 0;
    }

    private static boolean headersMatch(int v, long v1) {
        return ((long)(v & 0xFFFE0C00)) == (v1 & 0xFFFFFFFFFFFE0C00L);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
        this.trackOutput = extractorOutput0.track(0, 1);
        this.extractorOutput.endTracks();
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp3Extractor()};
    }

    // 去混淆评级： 低(30)
    private static boolean lambda$static$1(int v, int v1, int v2, int v3, int v4) {
        return v1 == 67 && v2 == 0x4F && v3 == 77 && (v4 == 77 || v == 2) || v1 == 77 && v2 == 76 && v3 == 76 && (v4 == 84 || v == 2);
    }

    private static MlltSeeker maybeHandleSeekMetadata(Metadata metadata0, long v) {
        if(metadata0 != null) {
            int v1 = metadata0.length();
            for(int v2 = 0; v2 < v1; ++v2) {
                Entry metadata$Entry0 = metadata0.get(v2);
                if(metadata$Entry0 instanceof MlltFrame) {
                    return MlltSeeker.create(v, ((MlltFrame)metadata$Entry0));
                }
            }
        }
        return null;
    }

    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput0) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput0.peekFully(parsableByteArray0.data, 0, this.synchronizedHeader.frameSize);
        MpegAudioHeader mpegAudioHeader0 = this.synchronizedHeader;
        int v = 21;
        if((mpegAudioHeader0.version & 1) == 0) {
            if(mpegAudioHeader0.channels == 1) {
                v = 13;
            }
        }
        else if(mpegAudioHeader0.channels != 1) {
            v = 36;
        }
        int v1 = Mp3Extractor.getSeekFrameHeader(parsableByteArray0, v);
        if(v1 != 0x496E666F && v1 != 1483304551) {
            if(v1 == 1447187017) {
                Seeker seeker0 = VbriSeeker.create(extractorInput0.getLength(), extractorInput0.getPosition(), this.synchronizedHeader, parsableByteArray0);
                extractorInput0.skipFully(this.synchronizedHeader.frameSize);
                return seeker0;
            }
            extractorInput0.resetPeekPosition();
            return null;
        }
        Seeker seeker1 = XingSeeker.create(extractorInput0.getLength(), extractorInput0.getPosition(), this.synchronizedHeader, parsableByteArray0);
        if(seeker1 != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
            extractorInput0.resetPeekPosition();
            extractorInput0.advancePeekPosition(v + 0x8D);
            extractorInput0.peekFully(this.scratch.data, 0, 3);
            this.scratch.setPosition(0);
            int v2 = this.scratch.readUnsignedInt24();
            this.gaplessInfoHolder.setFromXingHeaderValue(v2);
        }
        extractorInput0.skipFully(this.synchronizedHeader.frameSize);
        return seeker1 == null || seeker1.isSeekable() || v1 != 0x496E666F ? seeker1 : this.getConstantBitrateSeeker(extractorInput0);
    }

    private boolean peekEndOfStreamOrHeader(ExtractorInput extractorInput0) {
        Seeker seeker0 = this.seeker;
        if(seeker0 != null) {
            long v = seeker0.getDataEndPosition();
            if(v != -1L && extractorInput0.getPeekPosition() > v - 4L) {
                return true;
            }
        }
        try {
            return !extractorInput0.peekFully(this.scratch.data, 0, 4, true);
        }
        catch(EOFException unused_ex) {
            return true;
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        if(this.synchronizedHeaderData == 0) {
            try {
                this.synchronize(extractorInput0, false);
            }
            catch(EOFException unused_ex) {
                return -1;
            }
        }
        if(this.seeker == null) {
            Seeker seeker0 = this.maybeReadSeekFrame(extractorInput0);
            MlltSeeker mlltSeeker0 = Mp3Extractor.maybeHandleSeekMetadata(this.metadata, extractorInput0.getPosition());
            if(this.disableSeeking) {
                this.seeker = new UnseekableSeeker();
            }
            else {
                if(mlltSeeker0 != null) {
                    this.seeker = mlltSeeker0;
                }
                else if(seeker0 != null) {
                    this.seeker = seeker0;
                }
                if(this.seeker == null || !this.seeker.isSeekable() && (this.flags & 1) != 0) {
                    this.seeker = this.getConstantBitrateSeeker(extractorInput0);
                }
            }
            this.extractorOutput.seekMap(this.seeker);
            this.trackOutput.format(Format.createAudioSampleFormat(null, this.synchronizedHeader.mimeType, null, -1, 0x1000, this.synchronizedHeader.channels, this.synchronizedHeader.sampleRate, -1, this.gaplessInfoHolder.encoderDelay, this.gaplessInfoHolder.encoderPadding, null, null, 0, null, ((this.flags & 2) == 0 ? this.metadata : null)));
            this.firstSamplePosition = extractorInput0.getPosition();
            return this.readSample(extractorInput0);
        }
        if(this.firstSamplePosition != 0L) {
            long v = extractorInput0.getPosition();
            long v1 = this.firstSamplePosition;
            if(v < v1) {
                extractorInput0.skipFully(((int)(v1 - v)));
            }
        }
        return this.readSample(extractorInput0);
    }

    private int readSample(ExtractorInput extractorInput0) {
        if(this.sampleBytesRemaining == 0) {
            extractorInput0.resetPeekPosition();
            if(this.peekEndOfStreamOrHeader(extractorInput0)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int v = this.scratch.readInt();
            if(Mp3Extractor.headersMatch(v, ((long)this.synchronizedHeaderData)) && MpegAudioHeader.getFrameSize(v) != -1) {
                MpegAudioHeader.populateHeader(v, this.synchronizedHeader);
                if(this.basisTimeUs == 0x8000000000000001L) {
                    this.basisTimeUs = this.seeker.getTimeUs(extractorInput0.getPosition());
                    if(this.forcedFirstSampleTimestampUs != 0x8000000000000001L) {
                        long v1 = this.seeker.getTimeUs(0L);
                        this.basisTimeUs = this.forcedFirstSampleTimestampUs - v1 + this.basisTimeUs;
                    }
                }
                this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
                goto label_18;
            }
            extractorInput0.skipFully(1);
            this.synchronizedHeaderData = 0;
            return 0;
        }
    label_18:
        int v2 = this.trackOutput.sampleData(extractorInput0, this.sampleBytesRemaining, true);
        if(v2 == -1) {
            return -1;
        }
        int v3 = this.sampleBytesRemaining - v2;
        this.sampleBytesRemaining = v3;
        if(v3 > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.samplesRead * 1000000L / ((long)this.synchronizedHeader.sampleRate) + this.basisTimeUs, 1, this.synchronizedHeader.frameSize, 0, null);
        this.samplesRead += (long)this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = 0x8000000000000001L;
        this.samplesRead = 0L;
        this.sampleBytesRemaining = 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        return this.synchronize(extractorInput0, true);
    }

    private boolean synchronize(ExtractorInput extractorInput0, boolean z) {
        int v1;
        int v;
        extractorInput0.resetPeekPosition();
        if(Long.compare(extractorInput0.getPosition(), 0L) == 0) {
            Metadata metadata0 = this.id3Peeker.peekId3Data(extractorInput0, ((this.flags & 2) == 0 ? null : Mp3Extractor.REQUIRED_ID3_FRAME_PREDICATE));
            this.metadata = metadata0;
            if(metadata0 != null) {
                this.gaplessInfoHolder.setFromMetadata(metadata0);
            }
            v = (int)extractorInput0.getPeekPosition();
            if(!z) {
                extractorInput0.skipFully(v);
            }
        }
        else {
            v = 0;
        }
        v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(true) {
            if(this.peekEndOfStreamOrHeader(extractorInput0)) {
                if(v2 <= 0) {
                    throw new EOFException();
                }
                goto label_29;
            }
            this.scratch.setPosition(0);
            int v4 = this.scratch.readInt();
            if(v1 == 0 || Mp3Extractor.headersMatch(v4, ((long)v1))) {
                int v5 = MpegAudioHeader.getFrameSize(v4);
                if(v5 != -1) {
                    ++v2;
                    if(v2 == 1) {
                        MpegAudioHeader.populateHeader(v4, this.synchronizedHeader);
                        v1 = v4;
                    }
                    else if(v2 == 4) {
                        goto label_29;
                    }
                    extractorInput0.advancePeekPosition(v5 - 4);
                    continue;
                label_29:
                    if(z) {
                        extractorInput0.skipFully(v + v3);
                    }
                    else {
                        extractorInput0.resetPeekPosition();
                    }
                    this.synchronizedHeaderData = v1;
                    return true;
                }
            }
            if(v3 == (z ? 0x4000 : 0x20000)) {
                if(!z) {
                    throw new ParserException("Searched too many bytes.");
                }
                return false;
            }
            if(z) {
                extractorInput0.resetPeekPosition();
                extractorInput0.advancePeekPosition(v + (v3 + 1));
            }
            else {
                extractorInput0.skipFully(1);
            }
            v2 = 0;
            ++v3;
            v1 = 0;
        }
    }
}

