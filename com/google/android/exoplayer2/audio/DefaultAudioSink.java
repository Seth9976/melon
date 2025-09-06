package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.iloen.melon.utils.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public final class DefaultAudioSink implements AudioSink {
    public interface AudioProcessorChain {
        PlaybackParameters applyPlaybackParameters(PlaybackParameters arg1);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long arg1);

        long getSkippedOutputFrameCount();
    }

    static final class Configuration {
        public final AudioProcessor[] availableAudioProcessors;
        public final int bufferSize;
        public final boolean canApplyPlaybackParameters;
        public final int inputPcmFrameSize;
        public final int inputSampleRate;
        public final boolean isInputPcm;
        public final int outputChannelConfig;
        public final int outputEncoding;
        public final int outputPcmFrameSize;
        public final int outputSampleRate;
        public final boolean processingEnabled;

        public Configuration(boolean z, int v, int v1, int v2, int v3, int v4, int v5, int v6, boolean z1, boolean z2, AudioProcessor[] arr_audioProcessor) {
            this.isInputPcm = z;
            this.inputPcmFrameSize = v;
            this.inputSampleRate = v1;
            this.outputPcmFrameSize = v2;
            this.outputSampleRate = v3;
            this.outputChannelConfig = v4;
            this.outputEncoding = v5;
            if(v6 == 0) {
                v6 = this.getDefaultBufferSize();
            }
            this.bufferSize = v6;
            this.processingEnabled = z1;
            this.canApplyPlaybackParameters = z2;
            this.availableAudioProcessors = arr_audioProcessor;
        }

        public AudioTrack buildAudioTrack(boolean z, AudioAttributes audioAttributes0, int v) {
            AudioTrack audioTrack0;
            if(Util.SDK_INT >= 21) {
                audioTrack0 = this.createAudioTrackV21(z, audioAttributes0, v);
            }
            else {
                int v1 = Util.getStreamTypeForAudioUsage(audioAttributes0.usage);
                audioTrack0 = v == 0 ? new AudioTrack(v1, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1) : new AudioTrack(v1, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, v);
            }
            int v2 = audioTrack0.getState();
            if(v2 == 1) {
                return audioTrack0;
            }
            try {
                audioTrack0.release();
            }
            catch(Exception unused_ex) {
            }
            throw new InitializationException(v2, this.outputSampleRate, this.outputChannelConfig, this.bufferSize);
        }

        public boolean canReuseAudioTrack(Configuration defaultAudioSink$Configuration0) {
            return defaultAudioSink$Configuration0.outputEncoding == this.outputEncoding && defaultAudioSink$Configuration0.outputSampleRate == this.outputSampleRate && defaultAudioSink$Configuration0.outputChannelConfig == this.outputChannelConfig;
        }

        @TargetApi(21)
        private AudioTrack createAudioTrackV21(boolean z, AudioAttributes audioAttributes0, int v) {
            android.media.AudioAttributes audioAttributes1 = z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : audioAttributes0.getAudioAttributesV21();
            AudioFormat audioFormat0 = new AudioFormat.Builder().setChannelMask(this.outputChannelConfig).setEncoding(this.outputEncoding).setSampleRate(this.outputSampleRate).build();
            return v == 0 ? new AudioTrack(audioAttributes1, audioFormat0, this.bufferSize, 1, 0) : new AudioTrack(audioAttributes1, audioFormat0, this.bufferSize, 1, v);
        }

        public long durationUsToFrames(long v) {
            return v * ((long)this.outputSampleRate) / 1000000L;
        }

        public long framesToDurationUs(long v) {
            return v * 1000000L / ((long)this.outputSampleRate);
        }

        private int getDefaultBufferSize() {
            if(this.isInputPcm) {
                int v = AudioTrack.getMinBufferSize(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
                Assertions.checkState(v != -2);
                return Util.constrainValue(v * 4, ((int)this.durationUsToFrames(250000L)) * this.outputPcmFrameSize, ((int)Math.max(v, this.durationUsToFrames(750000L) * ((long)this.outputPcmFrameSize))));
            }
            int v1 = DefaultAudioSink.getMaximumEncodedRateBytesPerSecond(this.outputEncoding);
            if(this.outputEncoding == 5) {
                v1 *= 2;
            }
            return (int)(((long)v1) * 250000L / 1000000L);
        }

        public long inputFramesToDurationUs(long v) {
            return v * 1000000L / ((long)this.inputSampleRate);
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
        private final SonicAudioProcessor sonicAudioProcessor;

        public DefaultAudioProcessorChain(AudioProcessor[] arr_audioProcessor) {
            this(arr_audioProcessor, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        public DefaultAudioProcessorChain(AudioProcessor[] arr_audioProcessor, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor0, SonicAudioProcessor sonicAudioProcessor0) {
            AudioProcessor[] arr_audioProcessor1 = new AudioProcessor[arr_audioProcessor.length + 2];
            this.audioProcessors = arr_audioProcessor1;
            System.arraycopy(arr_audioProcessor, 0, arr_audioProcessor1, 0, arr_audioProcessor.length);
            this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor0;
            this.sonicAudioProcessor = sonicAudioProcessor0;
            arr_audioProcessor1[arr_audioProcessor.length] = silenceSkippingAudioProcessor0;
            arr_audioProcessor1[arr_audioProcessor.length + 1] = sonicAudioProcessor0;
        }

        @Override  // com.google.android.exoplayer2.audio.DefaultAudioSink$AudioProcessorChain
        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters0) {
            this.silenceSkippingAudioProcessor.setEnabled(playbackParameters0.skipSilence);
            return new PlaybackParameters(this.sonicAudioProcessor.setSpeed(playbackParameters0.speed), this.sonicAudioProcessor.setPitch(playbackParameters0.pitch), playbackParameters0.skipSilence);
        }

        @Override  // com.google.android.exoplayer2.audio.DefaultAudioSink$AudioProcessorChain
        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        @Override  // com.google.android.exoplayer2.audio.DefaultAudioSink$AudioProcessorChain
        public long getMediaDuration(long v) {
            return this.sonicAudioProcessor.scaleDurationForSpeedup(v);
        }

        @Override  // com.google.android.exoplayer2.audio.DefaultAudioSink$AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String s) {
            super(s);
        }

        public InvalidAudioTrackTimestampException(String s, com.google.android.exoplayer2.audio.DefaultAudioSink.1 defaultAudioSink$10) {
            this(s);
        }
    }

    static final class PlaybackParametersCheckpoint {
        private final long mediaTimeUs;
        private final PlaybackParameters playbackParameters;
        private final long positionUs;

        private PlaybackParametersCheckpoint(PlaybackParameters playbackParameters0, long v, long v1) {
            this.playbackParameters = playbackParameters0;
            this.mediaTimeUs = v;
            this.positionUs = v1;
        }

        public PlaybackParametersCheckpoint(PlaybackParameters playbackParameters0, long v, long v1, com.google.android.exoplayer2.audio.DefaultAudioSink.1 defaultAudioSink$10) {
            this(playbackParameters0, v, v1);
        }

        public static PlaybackParameters access$100(PlaybackParametersCheckpoint defaultAudioSink$PlaybackParametersCheckpoint0) {
            return defaultAudioSink$PlaybackParametersCheckpoint0.playbackParameters;
        }

        public static long access$400(PlaybackParametersCheckpoint defaultAudioSink$PlaybackParametersCheckpoint0) {
            return defaultAudioSink$PlaybackParametersCheckpoint0.positionUs;
        }

        public static long access$500(PlaybackParametersCheckpoint defaultAudioSink$PlaybackParametersCheckpoint0) {
            return defaultAudioSink$PlaybackParametersCheckpoint0.mediaTimeUs;
        }
    }

    final class PositionTrackerListener implements Listener {
        private PositionTrackerListener() {
        }

        public PositionTrackerListener(com.google.android.exoplayer2.audio.DefaultAudioSink.1 defaultAudioSink$10) {
        }

        @Override  // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
        public void onInvalidLatency(long v) {
            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + v);
        }

        @Override  // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
        public void onPositionFramesMismatch(long v, long v1, long v2, long v3) {
            long v4 = DefaultAudioSink.this.getSubmittedFrames();
            long v5 = DefaultAudioSink.this.getWrittenFrames();
            StringBuilder stringBuilder0 = new StringBuilder(0xB6);
            stringBuilder0.append("Spurious audio timestamp (frame position mismatch): ");
            stringBuilder0.append(v);
            stringBuilder0.append(", ");
            stringBuilder0.append(v1);
            a.s(v2, ", ", ", ", stringBuilder0);
            stringBuilder0.append(v3);
            a.s(v4, ", ", ", ", stringBuilder0);
            stringBuilder0.append(v5);
            String s = stringBuilder0.toString();
            if(DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(s, null);
            }
            Log.w("AudioTrack", s);
        }

        @Override  // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
        public void onSystemTimeUsMismatch(long v, long v1, long v2, long v3) {
            long v4 = DefaultAudioSink.this.getSubmittedFrames();
            long v5 = DefaultAudioSink.this.getWrittenFrames();
            StringBuilder stringBuilder0 = new StringBuilder(180);
            stringBuilder0.append("Spurious audio timestamp (system clock mismatch): ");
            stringBuilder0.append(v);
            stringBuilder0.append(", ");
            stringBuilder0.append(v1);
            a.s(v2, ", ", ", ", stringBuilder0);
            stringBuilder0.append(v3);
            a.s(v4, ", ", ", ", stringBuilder0);
            stringBuilder0.append(v5);
            String s = stringBuilder0.toString();
            if(DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(s, null);
            }
            Log.w("AudioTrack", s);
        }

        @Override  // com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener
        public void onUnderrun(int v, long v1) {
            if(DefaultAudioSink.this.listener != null) {
                long v2 = SystemClock.elapsedRealtime();
                DefaultAudioSink.this.listener.onUnderrun(v, v1, v2 - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final int ERROR_BAD_VALUE = -2;
    private static final long MAX_BUFFER_DURATION_US = 750000L;
    private static final long MIN_BUFFER_DURATION_US = 250000L;
    private static final int MODE_STATIC = 0;
    private static final int MODE_STREAM = 1;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000L;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final String TAG = "AudioTrack";
    @SuppressLint({"InlinedApi"})
    private static final int WRITE_NON_BLOCKING = 1;
    private AudioProcessor[] activeAudioProcessors;
    private PlaybackParameters afterDrainPlaybackParameters;
    private AudioAttributes audioAttributes;
    private final AudioCapabilities audioCapabilities;
    private final AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    private AudioTrack audioTrack;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private AuxEffectInfo auxEffectInfo;
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private Configuration configuration;
    private int drainingAudioProcessorIndex;
    private final boolean enableFloatOutput;
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private ByteBuffer inputBuffer;
    private AudioTrack keepSessionIdAudioTrack;
    private long lastFeedElapsedRealtimeMs;
    private com.google.android.exoplayer2.audio.AudioSink.Listener listener;
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private Configuration pendingConfiguration;
    private PlaybackParameters playbackParameters;
    private final ArrayDeque playbackParametersCheckpoints;
    private long playbackParametersOffsetUs;
    private long playbackParametersPositionUs;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private final ConditionVariable releasingConditionVariable;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public DefaultAudioSink(AudioCapabilities audioCapabilities0, AudioProcessorChain defaultAudioSink$AudioProcessorChain0, boolean z) {
        this.audioCapabilities = audioCapabilities0;
        this.audioProcessorChain = (AudioProcessorChain)Assertions.checkNotNull(defaultAudioSink$AudioProcessorChain0);
        this.enableFloatOutput = z;
        this.releasingConditionVariable = new ConditionVariable(true);
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener(this, null));
        ChannelMappingAudioProcessor channelMappingAudioProcessor0 = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor0;
        TrimmingAudioProcessor trimmingAudioProcessor0 = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor0;
        ArrayList arrayList0 = new ArrayList();
        Collections.addAll(arrayList0, new BaseAudioProcessor[]{new ResamplingAudioProcessor(), channelMappingAudioProcessor0, trimmingAudioProcessor0});
        Collections.addAll(arrayList0, defaultAudioSink$AudioProcessorChain0.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (AudioProcessor[])arrayList0.toArray(new AudioProcessor[0]);
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.startMediaTimeState = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.auxEffectInfo = new AuxEffectInfo(0, 0.0f);
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.playbackParametersCheckpoints = new ArrayDeque();
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities0, AudioProcessor[] arr_audioProcessor) {
        this(audioCapabilities0, arr_audioProcessor, false);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities0, AudioProcessor[] arr_audioProcessor, boolean z) {
        this(audioCapabilities0, new DefaultAudioProcessorChain(arr_audioProcessor), z);
    }

    private void applyPlaybackParameters(PlaybackParameters playbackParameters0, long v) {
        PlaybackParametersCheckpoint defaultAudioSink$PlaybackParametersCheckpoint0 = new PlaybackParametersCheckpoint((this.configuration.canApplyPlaybackParameters ? this.audioProcessorChain.applyPlaybackParameters(playbackParameters0) : PlaybackParameters.DEFAULT), Math.max(0L, v), this.configuration.framesToDurationUs(this.getWrittenFrames()), null);
        this.playbackParametersCheckpoints.add(defaultAudioSink$PlaybackParametersCheckpoint0);
        this.setupAudioProcessors();
    }

    private long applySkipping(long v) {
        return v + this.configuration.framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private long applySpeedup(long v) {
        PlaybackParametersCheckpoint defaultAudioSink$PlaybackParametersCheckpoint0;
        for(defaultAudioSink$PlaybackParametersCheckpoint0 = null; !this.playbackParametersCheckpoints.isEmpty() && v >= PlaybackParametersCheckpoint.access$400(((PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getFirst())); defaultAudioSink$PlaybackParametersCheckpoint0 = (PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.remove()) {
        }
        if(defaultAudioSink$PlaybackParametersCheckpoint0 != null) {
            this.playbackParameters = PlaybackParametersCheckpoint.access$100(defaultAudioSink$PlaybackParametersCheckpoint0);
            this.playbackParametersPositionUs = PlaybackParametersCheckpoint.access$400(defaultAudioSink$PlaybackParametersCheckpoint0);
            this.playbackParametersOffsetUs = PlaybackParametersCheckpoint.access$500(defaultAudioSink$PlaybackParametersCheckpoint0) - this.startMediaTimeUs;
        }
        if(this.playbackParameters.speed == 1.0f) {
            return v + this.playbackParametersOffsetUs - this.playbackParametersPositionUs;
        }
        if(this.playbackParametersCheckpoints.isEmpty()) {
            long v1 = this.playbackParametersOffsetUs;
            return this.audioProcessorChain.getMediaDuration(v - this.playbackParametersPositionUs) + v1;
        }
        return Util.getMediaDurationForPlayoutDuration(v - this.playbackParametersPositionUs, this.playbackParameters.speed) + this.playbackParametersOffsetUs;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void configure(int v, int v1, int v2, int v3, int[] arr_v, int v4, int v5) {
        int v10;
        int v9;
        int v8;
        int[] arr_v1;
        if(Util.SDK_INT >= 21 || v1 != 8 || arr_v != null) {
            arr_v1 = arr_v;
        }
        else {
            arr_v1 = new int[6];
            for(int v6 = 0; v6 < 6; ++v6) {
                arr_v1[v6] = v6;
            }
        }
        boolean z = Util.isEncodingLinearPcm(v);
        boolean z1 = this.enableFloatOutput && this.supportsOutput(v1, 4) && Util.isEncodingHighResolutionPcm(v);
        AudioProcessor[] arr_audioProcessor = z1 ? this.toFloatPcmAvailableAudioProcessors : this.toIntPcmAvailableAudioProcessors;
        if(z) {
            this.trimmingAudioProcessor.setTrimFrameCount(v4, v5);
            this.channelMappingAudioProcessor.setChannelMap(arr_v1);
            com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioProcessor$AudioFormat0 = new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(v2, v1, v);
            for(int v7 = 0; v7 < arr_audioProcessor.length; ++v7) {
                AudioProcessor audioProcessor0 = arr_audioProcessor[v7];
                try {
                    com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioProcessor$AudioFormat1 = audioProcessor0.configure(audioProcessor$AudioFormat0);
                    if(audioProcessor0.isActive()) {
                        audioProcessor$AudioFormat0 = audioProcessor$AudioFormat1;
                    }
                }
                catch(UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException0) {
                    throw new ConfigurationException(audioProcessor$UnhandledAudioFormatException0);
                }
            }
            v8 = audioProcessor$AudioFormat0.sampleRate;
            v9 = audioProcessor$AudioFormat0.channelCount;
            v10 = audioProcessor$AudioFormat0.encoding;
        }
        else {
            v9 = v1;
            v10 = v;
            v8 = v2;
        }
        int v11 = -1;
        int v12 = DefaultAudioSink.getChannelConfig(v9, z);
        if(v12 == 0) {
            throw new ConfigurationException("Unsupported channel count: " + v9);
        }
        int v13 = z ? Util.getPcmFrameSize(v, v1) : -1;
        if(z) {
            v11 = Util.getPcmFrameSize(v10, v9);
        }
        Configuration defaultAudioSink$Configuration0 = new Configuration(z, v13, v2, v11, v8, v12, v10, v3, z, z && !z1, arr_audioProcessor);
        if(this.isInitialized()) {
            this.pendingConfiguration = defaultAudioSink$Configuration0;
            return;
        }
        this.configuration = defaultAudioSink$Configuration0;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if(this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            this.flush();
        }
    }

    private boolean drainAudioProcessorsToEndOfStream() {
        if(this.drainingAudioProcessorIndex == -1) {
            this.drainingAudioProcessorIndex = this.configuration.processingEnabled ? 0 : this.activeAudioProcessors.length;
        }
        for(boolean z = false; true; z = true) {
            int v = this.drainingAudioProcessorIndex;
            AudioProcessor[] arr_audioProcessor = this.activeAudioProcessors;
            if(v >= arr_audioProcessor.length) {
                break;
            }
            AudioProcessor audioProcessor0 = arr_audioProcessor[v];
            if(z) {
                audioProcessor0.queueEndOfStream();
            }
            this.processBuffers(0x8000000000000001L);
            if(!audioProcessor0.isEnded()) {
                return false;
            }
            ++this.drainingAudioProcessorIndex;
        }
        ByteBuffer byteBuffer0 = this.outputBuffer;
        if(byteBuffer0 != null) {
            this.writeBuffer(byteBuffer0, 0x8000000000000001L);
            if(this.outputBuffer != null) {
                return false;
            }
        }
        this.drainingAudioProcessorIndex = -1;
        return true;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int v) {
        Assertions.checkState(Util.SDK_INT >= 21);
        if(this.tunneling && this.audioSessionId == v) {
            return;
        }
        this.tunneling = true;
        this.audioSessionId = v;
        this.flush();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if(this.isInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.writtenPcmBytes = 0L;
            this.writtenEncodedFrames = 0L;
            this.framesPerEncodedSample = 0;
            PlaybackParameters playbackParameters0 = this.afterDrainPlaybackParameters;
            if(playbackParameters0 != null) {
                this.playbackParameters = playbackParameters0;
                this.afterDrainPlaybackParameters = null;
            }
            else if(!this.playbackParametersCheckpoints.isEmpty()) {
                this.playbackParameters = PlaybackParametersCheckpoint.access$100(((PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getLast()));
            }
            this.playbackParametersCheckpoints.clear();
            this.playbackParametersOffsetUs = 0L;
            this.playbackParametersPositionUs = 0L;
            this.trimmingAudioProcessor.resetTrimmedFrameCount();
            this.flushAudioProcessors();
            this.inputBuffer = null;
            this.outputBuffer = null;
            this.stoppedAudioTrack = false;
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            this.startMediaTimeState = 0;
            if(this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            AudioTrack audioTrack0 = this.audioTrack;
            this.audioTrack = null;
            Configuration defaultAudioSink$Configuration0 = this.pendingConfiguration;
            if(defaultAudioSink$Configuration0 != null) {
                this.configuration = defaultAudioSink$Configuration0;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            new Thread() {
                @Override
                public void run() {
                    try {
                        audioTrack0.flush();
                        audioTrack0.release();
                    }
                    finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    private void flushAudioProcessors() {
        for(int v = 0; true; ++v) {
            AudioProcessor[] arr_audioProcessor = this.activeAudioProcessors;
            if(v >= arr_audioProcessor.length) {
                break;
            }
            AudioProcessor audioProcessor0 = arr_audioProcessor[v];
            audioProcessor0.flush();
            ByteBuffer[] arr_byteBuffer = this.outputBuffers;
            arr_byteBuffer[v] = audioProcessor0.getOutput();
        }
    }

    private static int getChannelConfig(int v, boolean z) {
        int v1 = Util.SDK_INT;
        if(v1 <= 28 && !z) {
            switch(v) {
                case 3: 
                case 4: 
                case 5: {
                    v = 6;
                    break;
                }
                case 7: {
                    v = 8;
                }
            }
        }
        if(v1 <= 26 && "fugu".equals(Util.DEVICE) && !z && v == 1) {
            v = 2;
        }
        return Util.getAudioTrackChannelConfig(v);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        if(this.isInitialized() && this.startMediaTimeState != 0) {
            long v = Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z), this.configuration.framesToDurationUs(this.getWrittenFrames()));
            return this.startMediaTimeUs + this.applySkipping(this.applySpeedup(v));
        }
        return 0x8000000000000000L;
    }

    private static int getFramesPerEncodedSample(int v, ByteBuffer byteBuffer0) {
        switch(v) {
            case 7: 
            case 8: {
                return DtsUtil.parseDtsAudioSampleCount(byteBuffer0);
            }
            case 9: {
                return MpegAudioHeader.getFrameSampleCount(byteBuffer0.get(byteBuffer0.position()));
            }
            case 14: {
                int v1 = Ac3Util.findTrueHdSyncframeOffset(byteBuffer0);
                return v1 == -1 ? 0 : Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer0, v1) * 16;
            }
            case 17: {
                return Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer0);
            }
            case 5: 
            case 6: 
            case 18: {
                return Ac3Util.parseAc3SyncframeAudioSampleCount(byteBuffer0);
            }
            default: {
                throw new IllegalStateException("Unexpected audio encoding: " + v);
            }
        }
    }

    private static int getMaximumEncodedRateBytesPerSecond(int v) {
        switch(v) {
            case 5: {
                return 80000;
            }
            case 7: {
                return 192000;
            }
            case 8: {
                return 2250000;
            }
            case 14: {
                return 3062500;
            }
            case 17: {
                return 336000;
            }
            case 6: 
            case 18: {
                return 768000;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        PlaybackParameters playbackParameters0 = this.afterDrainPlaybackParameters;
        if(playbackParameters0 != null) {
            return playbackParameters0;
        }
        return this.playbackParametersCheckpoints.isEmpty() ? this.playbackParameters : PlaybackParametersCheckpoint.access$100(((PlaybackParametersCheckpoint)this.playbackParametersCheckpoints.getLast()));
    }

    // 去混淆评级： 低(20)
    private long getSubmittedFrames() {
        return this.configuration.isInputPcm ? this.submittedPcmBytes / ((long)this.configuration.inputPcmFrameSize) : this.submittedEncodedFrames;
    }

    // 去混淆评级： 低(20)
    private long getWrittenFrames() {
        return this.configuration.isInputPcm ? this.writtenPcmBytes / ((long)this.configuration.outputPcmFrameSize) : this.writtenEncodedFrames;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer0, long v) {
        Assertions.checkArgument(this.inputBuffer == null || byteBuffer0 == this.inputBuffer);
        if(this.pendingConfiguration != null) {
            if(!this.drainAudioProcessorsToEndOfStream()) {
                return false;
            }
            if(this.pendingConfiguration.canReuseAudioTrack(this.configuration)) {
                this.configuration = this.pendingConfiguration;
                this.pendingConfiguration = null;
            }
            else {
                this.playPendingData();
                if(this.hasPendingData()) {
                    return false;
                }
                this.flush();
            }
            this.applyPlaybackParameters(this.playbackParameters, v);
        }
        if(!this.isInitialized()) {
            this.initialize(v);
            if(this.playing) {
                this.play();
            }
        }
        long v1 = this.getWrittenFrames();
        if(!this.audioTrackPositionTracker.mayHandleBuffer(v1)) {
            return false;
        }
        if(this.inputBuffer == null) {
            if(!byteBuffer0.hasRemaining()) {
                return true;
            }
            Configuration defaultAudioSink$Configuration0 = this.configuration;
            if(!defaultAudioSink$Configuration0.isInputPcm && this.framesPerEncodedSample == 0) {
                int v2 = DefaultAudioSink.getFramesPerEncodedSample(defaultAudioSink$Configuration0.outputEncoding, byteBuffer0);
                this.framesPerEncodedSample = v2;
                if(v2 == 0) {
                    return true;
                }
            }
            if(this.afterDrainPlaybackParameters != null) {
                if(!this.drainAudioProcessorsToEndOfStream()) {
                    return false;
                }
                PlaybackParameters playbackParameters0 = this.afterDrainPlaybackParameters;
                this.afterDrainPlaybackParameters = null;
                this.applyPlaybackParameters(playbackParameters0, v);
            }
            if(this.startMediaTimeState == 0) {
                this.startMediaTimeUs = Math.max(0L, v);
                this.startMediaTimeState = 1;
            }
            else {
                long v3 = this.startMediaTimeUs + this.configuration.inputFramesToDurationUs(this.getSubmittedFrames() - this.trimmingAudioProcessor.getTrimmedFrameCount());
                if(this.startMediaTimeState == 1 && Math.abs(v3 - v) > 200000L) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + v3 + ", got " + v + "]");
                    this.startMediaTimeState = 2;
                }
                if(this.startMediaTimeState == 2) {
                    long v4 = v - v3;
                    this.startMediaTimeUs += v4;
                    this.startMediaTimeState = 1;
                    com.google.android.exoplayer2.audio.AudioSink.Listener audioSink$Listener0 = this.listener;
                    if(audioSink$Listener0 != null && v4 != 0L) {
                        audioSink$Listener0.onPositionDiscontinuity();
                    }
                }
            }
            if(this.configuration.isInputPcm) {
                this.submittedPcmBytes += (long)byteBuffer0.remaining();
            }
            else {
                this.submittedEncodedFrames += (long)this.framesPerEncodedSample;
            }
            this.inputBuffer = byteBuffer0;
        }
        if(this.configuration.processingEnabled) {
            this.processBuffers(v);
        }
        else {
            this.writeBuffer(this.inputBuffer, v);
        }
        if(!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            return true;
        }
        long v5 = this.getWrittenFrames();
        if(this.audioTrackPositionTracker.isStalled(v5)) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            this.flush();
            return true;
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        if(this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        if(this.isInitialized()) {
            long v = this.getWrittenFrames();
            return this.audioTrackPositionTracker.hasPendingData(v);
        }
        return false;
    }

    private void initialize(long v) {
        this.releasingConditionVariable.block();
        AudioTrack audioTrack0 = ((Configuration)Assertions.checkNotNull(this.configuration)).buildAudioTrack(this.tunneling, this.audioAttributes, this.audioSessionId);
        this.audioTrack = audioTrack0;
        int v1 = audioTrack0.getAudioSessionId();
        if(DefaultAudioSink.enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            if(this.keepSessionIdAudioTrack != null && v1 != this.keepSessionIdAudioTrack.getAudioSessionId()) {
                this.releaseKeepSessionIdAudioTrack();
            }
            if(this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = DefaultAudioSink.initializeKeepSessionIdAudioTrack(v1);
            }
        }
        if(this.audioSessionId != v1) {
            this.audioSessionId = v1;
            com.google.android.exoplayer2.audio.AudioSink.Listener audioSink$Listener0 = this.listener;
            if(audioSink$Listener0 != null) {
                audioSink$Listener0.onAudioSessionId(v1);
            }
        }
        this.applyPlaybackParameters(this.playbackParameters, v);
        this.audioTrackPositionTracker.setAudioTrack(this.audioTrack, this.configuration.outputEncoding, this.configuration.outputPcmFrameSize, this.configuration.bufferSize);
        this.setVolumeInternal();
        int v2 = this.auxEffectInfo.effectId;
        if(v2 != 0) {
            this.audioTrack.attachAuxEffect(v2);
            this.audioTrack.setAuxEffectSendLevel(this.auxEffectInfo.sendLevel);
        }
    }

    private static AudioTrack initializeKeepSessionIdAudioTrack(int v) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, v);
    }

    // 去混淆评级： 低(30)
    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !this.isInitialized() || this.handledEndOfStream && !this.hasPendingData();
    }

    private boolean isInitialized() {
        return this.audioTrack != null;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.playing = false;
        if(this.isInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.playing = true;
        if(this.isInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    private void playPendingData() {
        if(!this.stoppedAudioTrack) {
            this.stoppedAudioTrack = true;
            long v = this.getWrittenFrames();
            this.audioTrackPositionTracker.handleEndOfStream(v);
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() {
        if(!this.handledEndOfStream && this.isInitialized() && this.drainAudioProcessorsToEndOfStream()) {
            this.playPendingData();
            this.handledEndOfStream = true;
        }
    }

    private void processBuffers(long v) {
        ByteBuffer byteBuffer0;
        int v1 = this.activeAudioProcessors.length;
        int v2 = v1;
        while(v2 >= 0) {
            if(v2 > 0) {
                byteBuffer0 = this.outputBuffers[v2 - 1];
            }
            else {
                byteBuffer0 = this.inputBuffer == null ? AudioProcessor.EMPTY_BUFFER : this.inputBuffer;
            }
            if(v2 == v1) {
                this.writeBuffer(byteBuffer0, v);
            }
            else {
                AudioProcessor audioProcessor0 = this.activeAudioProcessors[v2];
                audioProcessor0.queueInput(byteBuffer0);
                ByteBuffer byteBuffer1 = audioProcessor0.getOutput();
                this.outputBuffers[v2] = byteBuffer1;
                if(byteBuffer1.hasRemaining()) {
                    ++v2;
                    continue;
                }
            }
            if(byteBuffer0.hasRemaining()) {
                break;
            }
            --v2;
        }
    }

    private void releaseKeepSessionIdAudioTrack() {
        AudioTrack audioTrack0 = this.keepSessionIdAudioTrack;
        if(audioTrack0 == null) {
            return;
        }
        this.keepSessionIdAudioTrack = null;
        new Thread() {
            @Override
            public void run() {
                audioTrack0.release();
            }
        }.start();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        this.flush();
        this.releaseKeepSessionIdAudioTrack();
        AudioProcessor[] arr_audioProcessor = this.toIntPcmAvailableAudioProcessors;
        for(int v = 0; v < arr_audioProcessor.length; ++v) {
            arr_audioProcessor[v].reset();
        }
        AudioProcessor[] arr_audioProcessor1 = this.toFloatPcmAvailableAudioProcessors;
        for(int v1 = 0; v1 < arr_audioProcessor1.length; ++v1) {
            arr_audioProcessor1[v1].reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes0) {
        if(!this.audioAttributes.equals(audioAttributes0)) {
            this.audioAttributes = audioAttributes0;
            if(!this.tunneling) {
                this.flush();
                this.audioSessionId = 0;
            }
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int v) {
        if(this.audioSessionId != v) {
            this.audioSessionId = v;
            this.flush();
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo0) {
        if(this.auxEffectInfo.equals(auxEffectInfo0)) {
            return;
        }
        int v = auxEffectInfo0.effectId;
        float f = auxEffectInfo0.sendLevel;
        AudioTrack audioTrack0 = this.audioTrack;
        if(audioTrack0 != null) {
            if(this.auxEffectInfo.effectId != v) {
                audioTrack0.attachAuxEffect(v);
            }
            if(v != 0) {
                this.audioTrack.setAuxEffectSendLevel(f);
            }
        }
        this.auxEffectInfo = auxEffectInfo0;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(com.google.android.exoplayer2.audio.AudioSink.Listener audioSink$Listener0) {
        this.listener = audioSink$Listener0;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        if(this.configuration != null && !this.configuration.canApplyPlaybackParameters) {
            this.playbackParameters = PlaybackParameters.DEFAULT;
            return;
        }
        if(!playbackParameters0.equals(this.getPlaybackParameters())) {
            if(this.isInitialized()) {
                this.afterDrainPlaybackParameters = playbackParameters0;
                return;
            }
            this.playbackParameters = playbackParameters0;
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if(this.volume != f) {
            this.volume = f;
            this.setVolumeInternal();
        }
    }

    private void setVolumeInternal() {
        if(!this.isInitialized()) {
            return;
        }
        if(Util.SDK_INT >= 21) {
            DefaultAudioSink.setVolumeInternalV21(this.audioTrack, this.volume);
            return;
        }
        DefaultAudioSink.setVolumeInternalV3(this.audioTrack, this.volume);
    }

    @TargetApi(21)
    private static void setVolumeInternalV21(AudioTrack audioTrack0, float f) {
        audioTrack0.setVolume(f);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack0, float f) {
        audioTrack0.setStereoVolume(f, f);
    }

    private void setupAudioProcessors() {
        AudioProcessor[] arr_audioProcessor = this.configuration.availableAudioProcessors;
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_audioProcessor.length; ++v) {
            AudioProcessor audioProcessor0 = arr_audioProcessor[v];
            if(audioProcessor0.isActive()) {
                arrayList0.add(audioProcessor0);
            }
            else {
                audioProcessor0.flush();
            }
        }
        int v1 = arrayList0.size();
        this.activeAudioProcessors = (AudioProcessor[])arrayList0.toArray(new AudioProcessor[v1]);
        this.outputBuffers = new ByteBuffer[v1];
        this.flushAudioProcessors();
    }

    // 去混淆评级： 低(40)
    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsOutput(int v, int v1) {
        return Util.isEncodingLinearPcm(v1) ? v1 != 4 || Util.SDK_INT >= 21 : this.audioCapabilities != null && this.audioCapabilities.supportsEncoding(v1) && (v == -1 || v <= this.audioCapabilities.getMaxChannelCount());
    }

    private void writeBuffer(ByteBuffer byteBuffer0, long v) {
        if(byteBuffer0.hasRemaining()) {
            ByteBuffer byteBuffer1 = this.outputBuffer;
            boolean z = true;
            int v1 = 0;
            if(byteBuffer1 == null) {
                this.outputBuffer = byteBuffer0;
                if(Util.SDK_INT < 21) {
                    int v2 = byteBuffer0.remaining();
                    if(this.preV21OutputBuffer == null || this.preV21OutputBuffer.length < v2) {
                        this.preV21OutputBuffer = new byte[v2];
                    }
                    byteBuffer0.get(this.preV21OutputBuffer, 0, v2);
                    byteBuffer0.position(byteBuffer0.position());
                    this.preV21OutputBufferOffset = 0;
                }
            }
            else {
                Assertions.checkArgument(byteBuffer1 == byteBuffer0);
            }
            int v3 = byteBuffer0.remaining();
            if(Util.SDK_INT < 21) {
                int v4 = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if(v4 > 0) {
                    v1 = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(v3, v4));
                    if(v1 > 0) {
                        this.preV21OutputBufferOffset += v1;
                        byteBuffer0.position(byteBuffer0.position() + v1);
                    }
                }
            }
            else if(this.tunneling) {
                if(v == 0x8000000000000001L) {
                    z = false;
                }
                Assertions.checkState(z);
                v1 = this.writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer0, v3, v);
            }
            else {
                v1 = DefaultAudioSink.writeNonBlockingV21(this.audioTrack, byteBuffer0, v3);
            }
            this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            if(v1 < 0) {
                throw new WriteException(v1);
            }
            boolean z1 = this.configuration.isInputPcm;
            if(z1) {
                this.writtenPcmBytes += (long)v1;
            }
            if(v1 == v3) {
                if(!z1) {
                    this.writtenEncodedFrames += (long)this.framesPerEncodedSample;
                }
                this.outputBuffer = null;
            }
        }
    }

    @TargetApi(21)
    private static int writeNonBlockingV21(AudioTrack audioTrack0, ByteBuffer byteBuffer0, int v) {
        return audioTrack0.write(byteBuffer0, v, 1);
    }

    @TargetApi(21)
    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack0, ByteBuffer byteBuffer0, int v, long v1) {
        if(Util.SDK_INT >= 26) {
            return audioTrack0.write(byteBuffer0, v, 1, v1 * 1000L);
        }
        if(this.avSyncHeader == null) {
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(16);
            this.avSyncHeader = byteBuffer1;
            byteBuffer1.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(0x55550001);
        }
        if(this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, v);
            this.avSyncHeader.putLong(8, v1 * 1000L);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = v;
        }
        int v2 = this.avSyncHeader.remaining();
        if(v2 > 0) {
            int v3 = audioTrack0.write(this.avSyncHeader, v2, 1);
            if(v3 < 0) {
                this.bytesUntilNextAvSync = 0;
                return v3;
            }
            if(v3 < v2) {
                return 0;
            }
        }
        int v4 = DefaultAudioSink.writeNonBlockingV21(audioTrack0, byteBuffer0, v);
        if(v4 < 0) {
            this.bytesUntilNextAvSync = 0;
            return v4;
        }
        this.bytesUntilNextAvSync -= v4;
        return v4;
    }
}

