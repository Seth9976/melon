package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class CeaDecoder implements SubtitleDecoder {
    static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable {
        private long queuedInputBufferCount;

        private CeaInputBuffer() {
        }

        public CeaInputBuffer(com.google.android.exoplayer2.text.cea.CeaDecoder.1 ceaDecoder$10) {
        }

        public int compareTo(CeaInputBuffer ceaDecoder$CeaInputBuffer0) {
            if(this.isEndOfStream() != ceaDecoder$CeaInputBuffer0.isEndOfStream()) {
                return this.isEndOfStream() ? 1 : -1;
            }
            long v = this.timeUs - ceaDecoder$CeaInputBuffer0.timeUs;
            if(v == 0L) {
                v = this.queuedInputBufferCount - ceaDecoder$CeaInputBuffer0.queuedInputBufferCount;
                if(v == 0L) {
                    return 0;
                }
            }
            return v <= 0L ? -1 : 1;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((CeaInputBuffer)object0));
        }
    }

    final class CeaOutputBuffer extends SubtitleOutputBuffer {
        private CeaOutputBuffer() {
        }

        public CeaOutputBuffer(com.google.android.exoplayer2.text.cea.CeaDecoder.1 ceaDecoder$10) {
        }

        @Override  // com.google.android.exoplayer2.text.SubtitleOutputBuffer
        public final void release() {
            CeaDecoder.this.releaseOutputBuffer(this);
        }
    }

    private static final int NUM_INPUT_BUFFERS = 10;
    private static final int NUM_OUTPUT_BUFFERS = 2;
    private final ArrayDeque availableInputBuffers;
    private final ArrayDeque availableOutputBuffers;
    private CeaInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private long queuedInputBufferCount;
    private final PriorityQueue queuedInputBuffers;

    public CeaDecoder() {
        this.availableInputBuffers = new ArrayDeque();
        for(int v1 = 0; v1 < 10; ++v1) {
            CeaInputBuffer ceaDecoder$CeaInputBuffer0 = new CeaInputBuffer(null);
            this.availableInputBuffers.add(ceaDecoder$CeaInputBuffer0);
        }
        this.availableOutputBuffers = new ArrayDeque();
        for(int v = 0; v < 2; ++v) {
            CeaOutputBuffer ceaDecoder$CeaOutputBuffer0 = new CeaOutputBuffer(this, null);
            this.availableOutputBuffers.add(ceaDecoder$CeaOutputBuffer0);
        }
        this.queuedInputBuffers = new PriorityQueue();
    }

    public abstract Subtitle createSubtitle();

    public abstract void decode(SubtitleInputBuffer arg1);

    public SubtitleInputBuffer dequeueInputBuffer() {
        Assertions.checkState(this.dequeuedInputBuffer == null);
        if(this.availableInputBuffers.isEmpty()) {
            return null;
        }
        CeaInputBuffer ceaDecoder$CeaInputBuffer0 = (CeaInputBuffer)this.availableInputBuffers.pollFirst();
        this.dequeuedInputBuffer = ceaDecoder$CeaInputBuffer0;
        return ceaDecoder$CeaInputBuffer0;
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public Object dequeueInputBuffer() {
        return this.dequeueInputBuffer();
    }

    public SubtitleOutputBuffer dequeueOutputBuffer() {
        if(this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while(!this.queuedInputBuffers.isEmpty() && ((CeaInputBuffer)this.queuedInputBuffers.peek()).timeUs <= this.playbackPositionUs) {
            CeaInputBuffer ceaDecoder$CeaInputBuffer0 = (CeaInputBuffer)this.queuedInputBuffers.poll();
            if(ceaDecoder$CeaInputBuffer0.isEndOfStream()) {
                SubtitleOutputBuffer subtitleOutputBuffer0 = (SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst();
                subtitleOutputBuffer0.addFlag(4);
                this.releaseInputBuffer(ceaDecoder$CeaInputBuffer0);
                return subtitleOutputBuffer0;
            }
            this.decode(ceaDecoder$CeaInputBuffer0);
            if(this.isNewSubtitleDataAvailable()) {
                Subtitle subtitle0 = this.createSubtitle();
                if(!ceaDecoder$CeaInputBuffer0.isDecodeOnly()) {
                    Object object0 = this.availableOutputBuffers.pollFirst();
                    ((SubtitleOutputBuffer)object0).setContent(ceaDecoder$CeaInputBuffer0.timeUs, subtitle0, 0x7FFFFFFFFFFFFFFFL);
                    this.releaseInputBuffer(ceaDecoder$CeaInputBuffer0);
                    return (SubtitleOutputBuffer)object0;
                }
            }
            this.releaseInputBuffer(ceaDecoder$CeaInputBuffer0);
        }
        return null;
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public Object dequeueOutputBuffer() {
        return this.dequeueOutputBuffer();
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.queuedInputBufferCount = 0L;
        this.playbackPositionUs = 0L;
        while(!this.queuedInputBuffers.isEmpty()) {
            this.releaseInputBuffer(((CeaInputBuffer)this.queuedInputBuffers.poll()));
        }
        CeaInputBuffer ceaDecoder$CeaInputBuffer0 = this.dequeuedInputBuffer;
        if(ceaDecoder$CeaInputBuffer0 != null) {
            this.releaseInputBuffer(ceaDecoder$CeaInputBuffer0);
            this.dequeuedInputBuffer = null;
        }
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public abstract String getName();

    public abstract boolean isNewSubtitleDataAvailable();

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer0) {
        Assertions.checkArgument(subtitleInputBuffer0 == this.dequeuedInputBuffer);
        if(subtitleInputBuffer0.isDecodeOnly()) {
            this.releaseInputBuffer(this.dequeuedInputBuffer);
        }
        else {
            long v = this.queuedInputBufferCount;
            this.queuedInputBufferCount = v + 1L;
            this.dequeuedInputBuffer.queuedInputBufferCount = v;
            this.queuedInputBuffers.add(this.dequeuedInputBuffer);
        }
        this.dequeuedInputBuffer = null;
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(Object object0) {
        this.queueInputBuffer(((SubtitleInputBuffer)object0));
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    private void releaseInputBuffer(CeaInputBuffer ceaDecoder$CeaInputBuffer0) {
        ceaDecoder$CeaInputBuffer0.clear();
        this.availableInputBuffers.add(ceaDecoder$CeaInputBuffer0);
    }

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer0) {
        subtitleOutputBuffer0.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer0);
    }

    @Override  // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long v) {
        this.playbackPositionUs = v;
    }

    class com.google.android.exoplayer2.text.cea.CeaDecoder.1 {
    }

}

