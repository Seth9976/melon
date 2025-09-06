package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

public final class H262Reader implements ElementaryStreamReader {
    static final class CsdBuffer {
        private static final byte[] START_CODE;
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        static {
            CsdBuffer.START_CODE = new byte[]{0, 0, 1};
        }

        public CsdBuffer(int v) {
            this.data = new byte[v];
        }

        public void onData(byte[] arr_b, int v, int v1) {
            if(!this.isFilling) {
                return;
            }
            int v2 = v1 - v;
            byte[] arr_b1 = this.data;
            int v3 = this.length;
            if(arr_b1.length < v3 + v2) {
                this.data = Arrays.copyOf(arr_b1, (v3 + v2) * 2);
            }
            System.arraycopy(arr_b, v, this.data, this.length, v2);
            this.length += v2;
        }

        public boolean onStartCode(int v, int v1) {
            if(this.isFilling) {
                int v2 = this.length - v1;
                this.length = v2;
                if(this.sequenceExtensionPosition == 0 && v == 0xB5) {
                    this.sequenceExtensionPosition = v2;
                    this.onData(CsdBuffer.START_CODE, 0, CsdBuffer.START_CODE.length);
                    return false;
                }
                this.isFilling = false;
                return true;
            }
            else if(v == 0xB3) {
                this.isFilling = true;
            }
            this.onData(CsdBuffer.START_CODE, 0, CsdBuffer.START_CODE.length);
            return false;
        }

        public void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }
    }

    private static final double[] FRAME_RATE_VALUES = null;
    private static final int START_EXTENSION = 0xB5;
    private static final int START_GROUP = 0xB8;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 0xB3;
    private static final int START_USER_DATA = 0xB2;
    private final CsdBuffer csdBuffer;
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags;
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer userData;
    private final ParsableByteArray userDataParsable;
    private final UserDataReader userDataReader;

    static {
        H262Reader.FRAME_RATE_VALUES = new double[]{23.976024, 24.0, 25.0, 29.97003, 30.0, 50.0, 59.94006, 60.0};
    }

    public H262Reader() {
        this(null);
    }

    public H262Reader(UserDataReader userDataReader0) {
        this.userDataReader = userDataReader0;
        this.prefixFlags = new boolean[4];
        this.csdBuffer = new CsdBuffer(0x80);
        if(userDataReader0 != null) {
            this.userData = new NalUnitTargetBuffer(0xB2, 0x80);
            this.userDataParsable = new ParsableByteArray();
            return;
        }
        this.userData = null;
        this.userDataParsable = null;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        int v5;
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        byte[] arr_b = parsableByteArray0.data;
        this.totalBytesWritten += (long)parsableByteArray0.bytesLeft();
        this.output.sampleData(parsableByteArray0, parsableByteArray0.bytesLeft());
        int v2;
        while((v2 = NalUnitUtil.findNalUnit(arr_b, v, v1, this.prefixFlags)) != v1) {
            int v3 = parsableByteArray0.data[v2 + 3] & 0xFF;
            int v4 = v2 - v;
            boolean z = false;
            if(!this.hasOutputFormat) {
                if(v4 > 0) {
                    this.csdBuffer.onData(arr_b, v, v2);
                }
                if(this.csdBuffer.onStartCode(v3, (v4 >= 0 ? 0 : -v4))) {
                    Pair pair0 = H262Reader.parseCsdBuffer(this.csdBuffer, this.formatId);
                    this.output.format(((Format)pair0.first));
                    this.frameDurationUs = (long)(((Long)pair0.second));
                    this.hasOutputFormat = true;
                }
            }
            if(this.userDataReader != null) {
                if(v4 > 0) {
                    this.userData.appendToNalUnit(arr_b, v, v2);
                    v5 = 0;
                }
                else {
                    v5 = -v4;
                }
                if(this.userData.endNalUnit(v5)) {
                    int v6 = NalUnitUtil.unescapeStream(this.userData.nalData, this.userData.nalLength);
                    this.userDataParsable.reset(this.userData.nalData, v6);
                    this.userDataReader.consume(this.sampleTimeUs, this.userDataParsable);
                }
                if(v3 == 0xB2 && parsableByteArray0.data[v2 + 2] == 1) {
                    this.userData.startNalUnit(0xB2);
                }
            }
            switch(v3) {
                case 0: 
                case 0xB3: {
                    int v7 = v1 - v2;
                    if(this.startedFirstSample && this.sampleHasPicture && this.hasOutputFormat) {
                        this.output.sampleMetadata(this.sampleTimeUs, ((int)this.sampleIsKeyframe), ((int)(this.totalBytesWritten - this.samplePosition)) - v7, v7, null);
                    }
                    boolean z1 = this.startedFirstSample;
                    if(!z1 || this.sampleHasPicture) {
                        this.samplePosition = this.totalBytesWritten - ((long)v7);
                        long v8 = this.pesTimeUs;
                        if(v8 == 0x8000000000000001L) {
                            v8 = z1 ? this.sampleTimeUs + this.frameDurationUs : 0L;
                        }
                        this.sampleTimeUs = v8;
                        this.sampleIsKeyframe = false;
                        this.pesTimeUs = 0x8000000000000001L;
                        this.startedFirstSample = true;
                    }
                    if(v3 == 0) {
                        z = true;
                    }
                    this.sampleHasPicture = z;
                    break;
                }
                case 0xB8: {
                    this.sampleIsKeyframe = true;
                }
            }
            v = v2 + 3;
        }
        if(!this.hasOutputFormat) {
            this.csdBuffer.onData(arr_b, v, v1);
        }
        if(this.userDataReader != null) {
            this.userData.appendToNalUnit(arr_b, v, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        this.formatId = tsPayloadReader$TrackIdGenerator0.getFormatId();
        this.output = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 2);
        UserDataReader userDataReader0 = this.userDataReader;
        if(userDataReader0 != null) {
            userDataReader0.createTracks(extractorOutput0, tsPayloadReader$TrackIdGenerator0);
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.pesTimeUs = v;
    }

    private static Pair parseCsdBuffer(CsdBuffer h262Reader$CsdBuffer0, String s) {
        float f;
        byte[] arr_b = Arrays.copyOf(h262Reader$CsdBuffer0.data, h262Reader$CsdBuffer0.length);
        int v = (arr_b[4] & 0xFF) << 4 | (arr_b[5] & 0xFF) >> 4;
        int v1 = (arr_b[5] & 15) << 8 | arr_b[6] & 0xFF;
        int v2 = (arr_b[7] & 0xF0) >> 4;
        if(v2 == 2) {
            f = ((float)(v1 * 4)) / ((float)(v * 3));
        }
        else {
            switch(v2) {
                case 3: {
                    f = ((float)(v1 * 16)) / ((float)(v * 9));
                    break;
                }
                case 4: {
                    f = ((float)(v1 * 0x79)) / ((float)(v * 100));
                    break;
                }
                default: {
                    f = 1.0f;
                }
            }
        }
        Format format0 = Format.createVideoSampleFormat(s, "video/mpeg2", null, -1, -1, v, v1, -1.0f, Collections.singletonList(arr_b), -1, f, null);
        int v3 = (arr_b[7] & 15) - 1;
        if(v3 >= 0) {
            double[] arr_f = H262Reader.FRAME_RATE_VALUES;
            if(v3 < arr_f.length) {
                double f1 = arr_f[v3];
                int v4 = arr_b[h262Reader$CsdBuffer0.sequenceExtensionPosition + 9];
                int v5 = (v4 & 0x60) >> 5;
                if(v5 != (v4 & 0x1F)) {
                    f1 *= (((double)v5) + 1.0) / ((double)((v4 & 0x1F) + 1));
                }
                return Pair.create(format0, ((long)(1000000.0 / f1)));
            }
        }
        return Pair.create(format0, 0L);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        if(this.userDataReader != null) {
            this.userData.reset();
        }
        this.totalBytesWritten = 0L;
        this.startedFirstSample = false;
    }
}

