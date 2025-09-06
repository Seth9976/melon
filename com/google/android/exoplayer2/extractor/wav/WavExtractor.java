package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class WavExtractor implements Extractor {
    static final class ImaAdPcmOutputWriter implements OutputWriter {
        private static final int[] INDEX_TABLE;
        private static final int[] STEP_TABLE;
        private final ParsableByteArray decodedData;
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final int framesPerBlock;
        private final WavHeader header;
        private final byte[] inputData;
        private long outputFrameCount;
        private int pendingInputBytes;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeFrames;
        private final TrackOutput trackOutput;

        static {
            ImaAdPcmOutputWriter.INDEX_TABLE = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
            ImaAdPcmOutputWriter.STEP_TABLE = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 0x1F, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 0x76, 130, 0x8F, 0x9D, 0xAD, 190, 209, 230, 0xFD, 279, 307, 337, 371, 408, 449, 494, 0x220, 598, 658, 724, 796, 876, 963, 1060, 0x48E, 0x502, 0x583, 0x610, 1707, 0x756, 2066, 0x8E0, 0x9C3, 0xABD, 0xBD0, 0xCFF, 3660, 0xFBA, 4428, 0x1307, 5358, 0x1706, 6484, 7132, 7845, 8630, 9493, 10442, 0x2CDF, 0x315B, 0x364B, 0x3BB9, 0x41B2, 18500, 20350, 0x5771, 0x602F, 27086, 0x7462, 0x7FFF};
        }

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput0, TrackOutput trackOutput0, WavHeader wavHeader0) {
            this.extractorOutput = extractorOutput0;
            this.trackOutput = trackOutput0;
            this.header = wavHeader0;
            int v = Math.max(1, wavHeader0.frameRateHz / 10);
            this.targetSampleSizeFrames = v;
            ParsableByteArray parsableByteArray0 = new ParsableByteArray(wavHeader0.extraData);
            parsableByteArray0.readLittleEndianUnsignedShort();
            int v1 = parsableByteArray0.readLittleEndianUnsignedShort();
            this.framesPerBlock = v1;
            int v2 = wavHeader0.numChannels;
            int v3 = (wavHeader0.blockSize - v2 * 4) * 8 / (wavHeader0.bitsPerSample * v2) + 1;
            if(v1 != v3) {
                throw new ParserException("Expected frames per block: " + v3 + "; got: " + v1);
            }
            int v4 = (v + v1 - 1) / v1;
            this.inputData = new byte[wavHeader0.blockSize * v4];
            this.decodedData = new ParsableByteArray(v4 * (v1 * 2 * v2));
            this.format = Format.createAudioSampleFormat(null, "audio/raw", null, wavHeader0.frameRateHz * wavHeader0.blockSize * 8 / v1, v * 2 * v2, wavHeader0.numChannels, wavHeader0.frameRateHz, 2, null, null, 0, null);
        }

        private void decode(byte[] arr_b, int v, ParsableByteArray parsableByteArray0) {
            for(int v1 = 0; v1 < v; ++v1) {
                for(int v2 = 0; v2 < this.header.numChannels; ++v2) {
                    this.decodeBlockForChannel(arr_b, v1, v2, parsableByteArray0.data);
                }
            }
            parsableByteArray0.reset(this.numOutputFramesToBytes(this.framesPerBlock * v));
        }

        private void decodeBlockForChannel(byte[] arr_b, int v, int v1, byte[] arr_b1) {
            int v2 = this.header.numChannels;
            int v3 = v1 * 4 + v * this.header.blockSize;
            int v4 = this.header.blockSize / v2 - 4;
            int v5 = (short)((arr_b[v3 + 1] & 0xFF) << 8 | arr_b[v3] & 0xFF);
            int v6 = Math.min(arr_b[v3 + 2] & 0xFF, 88);
            int v7 = ImaAdPcmOutputWriter.STEP_TABLE[v6];
            int v8 = (v * this.framesPerBlock * v2 + v1) * 2;
            arr_b1[v8] = (byte)(v5 & 0xFF);
            arr_b1[v8 + 1] = (byte)(v5 >> 8);
            for(int v9 = 0; v9 < v4 * 2; ++v9) {
                int v10 = arr_b[v9 / 8 * v2 * 4 + (v2 * 4 + v3) + v9 / 2 % 4];
                int v11 = v9 % 2 == 0 ? v10 & 15 : (v10 & 0xFF) >> 4;
                v5 = Util.constrainValue(v5 + ((v11 & 8) == 0 ? ((v11 & 7) * 2 + 1) * v7 >> 3 : -(((v11 & 7) * 2 + 1) * v7 >> 3)), 0xFFFF8000, 0x7FFF);
                v8 += v2 * 2;
                arr_b1[v8] = (byte)(v5 & 0xFF);
                arr_b1[v8 + 1] = (byte)(v5 >> 8);
                v6 = Util.constrainValue(v6 + ImaAdPcmOutputWriter.INDEX_TABLE[v11], 0, ImaAdPcmOutputWriter.STEP_TABLE.length - 1);
                v7 = ImaAdPcmOutputWriter.STEP_TABLE[v6];
            }
        }

        @Override  // com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter
        public void init(int v, long v1) {
            WavSeekMap wavSeekMap0 = new WavSeekMap(this.header, this.framesPerBlock, ((long)v), v1);
            this.extractorOutput.seekMap(wavSeekMap0);
            this.trackOutput.format(this.format);
        }

        private int numOutputBytesToFrames(int v) {
            return v / (this.header.numChannels * 2);
        }

        private int numOutputFramesToBytes(int v) {
            return v * 2 * this.header.numChannels;
        }

        private static int numOutputFramesToBytes(int v, int v1) [...] // Inlined contents

        @Override  // com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter
        public void reset(long v) {
            this.pendingInputBytes = 0;
            this.startTimeUs = v;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0L;
        }

        @Override  // com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter
        public boolean sampleData(ExtractorInput extractorInput0, long v) {
            boolean z;
            int v1 = this.numOutputBytesToFrames(this.pendingOutputBytes);
            int v2 = (this.targetSampleSizeFrames - v1 + this.framesPerBlock - 1) / this.framesPerBlock * this.header.blockSize;
            if(Long.compare(v, 0L) != 0) {
                z = false;
                goto label_6;
            }
            while(true) {
                z = true;
            label_6:
                if(z) {
                    break;
                }
                int v3 = this.pendingInputBytes;
                if(v3 >= v2) {
                    break;
                }
                int v4 = extractorInput0.read(this.inputData, this.pendingInputBytes, ((int)Math.min(v2 - v3, v)));
                if(v4 == -1) {
                    continue;
                }
                this.pendingInputBytes += v4;
                goto label_6;
            }
            int v5 = this.pendingInputBytes / this.header.blockSize;
            if(v5 > 0) {
                this.decode(this.inputData, v5, this.decodedData);
                this.pendingInputBytes -= v5 * this.header.blockSize;
                int v6 = this.decodedData.limit();
                this.trackOutput.sampleData(this.decodedData, v6);
                int v7 = this.pendingOutputBytes + v6;
                this.pendingOutputBytes = v7;
                int v8 = this.numOutputBytesToFrames(v7);
                int v9 = this.targetSampleSizeFrames;
                if(v8 >= v9) {
                    this.writeSampleMetadata(v9);
                }
            }
            if(z) {
                int v10 = this.numOutputBytesToFrames(this.pendingOutputBytes);
                if(v10 > 0) {
                    this.writeSampleMetadata(v10);
                }
            }
            return z;
        }

        private void writeSampleMetadata(int v) {
            long v1 = this.startTimeUs;
            long v2 = Util.scaleLargeTimestamp(this.outputFrameCount, 1000000L, this.header.frameRateHz);
            int v3 = this.numOutputFramesToBytes(v);
            this.trackOutput.sampleMetadata(v1 + v2, 1, v3, this.pendingOutputBytes - v3, null);
            this.outputFrameCount += (long)v;
            this.pendingOutputBytes -= v3;
        }
    }

    interface OutputWriter {
        void init(int arg1, long arg2);

        void reset(long arg1);

        boolean sampleData(ExtractorInput arg1, long arg2);
    }

    static final class PassthroughOutputWriter implements OutputWriter {
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final WavHeader header;
        private long outputFrameCount;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeBytes;
        private final TrackOutput trackOutput;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput0, TrackOutput trackOutput0, WavHeader wavHeader0, String s, int v) {
            this.extractorOutput = extractorOutput0;
            this.trackOutput = trackOutput0;
            this.header = wavHeader0;
            int v1 = wavHeader0.numChannels * wavHeader0.bitsPerSample / 8;
            if(wavHeader0.blockSize != v1) {
                throw new ParserException("Expected block size: " + v1 + "; got: " + wavHeader0.blockSize);
            }
            int v2 = Math.max(v1, wavHeader0.frameRateHz * v1 / 10);
            this.targetSampleSizeBytes = v2;
            this.format = Format.createAudioSampleFormat(null, s, null, v1 * wavHeader0.frameRateHz * 8, v2, wavHeader0.numChannels, wavHeader0.frameRateHz, v, null, null, 0, null);
        }

        @Override  // com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter
        public void init(int v, long v1) {
            WavSeekMap wavSeekMap0 = new WavSeekMap(this.header, 1, ((long)v), v1);
            this.extractorOutput.seekMap(wavSeekMap0);
            this.trackOutput.format(this.format);
        }

        @Override  // com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter
        public void reset(long v) {
            this.startTimeUs = v;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0L;
        }

        @Override  // com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter
        public boolean sampleData(ExtractorInput extractorInput0, long v) {
            int v1;
            while((v1 = Long.compare(v, 0L)) > 0) {
                int v2 = this.pendingOutputBytes;
                int v3 = this.targetSampleSizeBytes;
                if(v2 >= v3) {
                    break;
                }
                int v4 = this.trackOutput.sampleData(extractorInput0, ((int)Math.min(v3 - v2, v)), true);
                if(v4 == -1) {
                    v = 0L;
                }
                else {
                    this.pendingOutputBytes += v4;
                    v -= (long)v4;
                }
            }
            WavHeader wavHeader0 = this.header;
            int v5 = wavHeader0.blockSize;
            int v6 = this.pendingOutputBytes / v5;
            if(v6 > 0) {
                long v7 = this.startTimeUs;
                long v8 = Util.scaleLargeTimestamp(this.outputFrameCount, 1000000L, wavHeader0.frameRateHz);
                int v9 = v6 * v5;
                int v10 = this.pendingOutputBytes - v9;
                this.trackOutput.sampleMetadata(v7 + v8, 1, v9, v10, null);
                this.outputFrameCount += (long)v6;
                this.pendingOutputBytes = v10;
            }
            return v1 <= 0;
        }
    }

    public static final ExtractorsFactory FACTORY = null;
    private static final int TARGET_SAMPLES_PER_SECOND = 10;
    private long dataEndPosition;
    private int dataStartPosition;
    private ExtractorOutput extractorOutput;
    private OutputWriter outputWriter;
    private TrackOutput trackOutput;

    static {
        WavExtractor.FACTORY = new b(26);
    }

    public WavExtractor() {
        this.dataStartPosition = -1;
        this.dataEndPosition = -1L;
    }

    public static Extractor[] a() {
        return WavExtractor.lambda$static$0();
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
        this.trackOutput = extractorOutput0.track(0, 1);
        extractorOutput0.endTracks();
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new WavExtractor()};
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        this.assertInitialized();
        if(this.outputWriter == null) {
            WavHeader wavHeader0 = WavHeaderReader.peek(extractorInput0);
            if(wavHeader0 == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            int v = wavHeader0.formatType;
            if(v == 17) {
                this.outputWriter = new ImaAdPcmOutputWriter(this.extractorOutput, this.trackOutput, wavHeader0);
            }
            else {
                switch(v) {
                    case 6: {
                        this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavHeader0, "audio/g711-alaw", -1);
                        break;
                    }
                    case 7: {
                        this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavHeader0, "audio/g711-mlaw", -1);
                        break;
                    }
                    default: {
                        int v1 = WavUtil.getPcmEncodingForType(v, wavHeader0.bitsPerSample);
                        if(v1 == 0) {
                            throw new ParserException("Unsupported WAV format type: " + wavHeader0.formatType);
                        }
                        this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavHeader0, "audio/raw", v1);
                        break;
                    }
                }
            }
        }
        if(this.dataStartPosition == -1) {
            Pair pair0 = WavHeaderReader.skipToData(extractorInput0);
            this.dataStartPosition = ((Long)pair0.first).intValue();
            long v2 = (long)(((Long)pair0.second));
            this.dataEndPosition = v2;
            this.outputWriter.init(this.dataStartPosition, v2);
        }
        else if(extractorInput0.getPosition() == 0L) {
            extractorInput0.skipFully(this.dataStartPosition);
        }
        Assertions.checkState(Long.compare(this.dataEndPosition, -1L) != 0);
        long v3 = this.dataEndPosition;
        long v4 = extractorInput0.getPosition();
        return this.outputWriter.sampleData(extractorInput0, v3 - v4) ? -1 : 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        OutputWriter wavExtractor$OutputWriter0 = this.outputWriter;
        if(wavExtractor$OutputWriter0 != null) {
            wavExtractor$OutputWriter0.reset(v1);
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        return WavHeaderReader.peek(extractorInput0) != null;
    }
}

