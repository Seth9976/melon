package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

public abstract class SimpleDecoder implements Decoder {
    private int availableInputBufferCount;
    private final DecoderInputBuffer[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final OutputBuffer[] availableOutputBuffers;
    private final Thread decodeThread;
    private DecoderInputBuffer dequeuedInputBuffer;
    private Exception exception;
    private boolean flushed;
    private final Object lock;
    private final ArrayDeque queuedInputBuffers;
    private final ArrayDeque queuedOutputBuffers;
    private boolean released;
    private int skippedOutputBufferCount;

    public SimpleDecoder(DecoderInputBuffer[] arr_decoderInputBuffer, OutputBuffer[] arr_outputBuffer) {
        this.lock = new Object();
        this.queuedInputBuffers = new ArrayDeque();
        this.queuedOutputBuffers = new ArrayDeque();
        this.availableInputBuffers = arr_decoderInputBuffer;
        this.availableInputBufferCount = arr_decoderInputBuffer.length;
        for(int v1 = 0; v1 < this.availableInputBufferCount; ++v1) {
            this.availableInputBuffers[v1] = this.createInputBuffer();
        }
        this.availableOutputBuffers = arr_outputBuffer;
        this.availableOutputBufferCount = arr_outputBuffer.length;
        for(int v = 0; v < this.availableOutputBufferCount; ++v) {
            this.availableOutputBuffers[v] = this.createOutputBuffer();
        }
        com.google.android.exoplayer2.decoder.SimpleDecoder.1 simpleDecoder$10 = new Thread() {
            @Override
            public void run() {
                SimpleDecoder.access$000(SimpleDecoder.this);
            }
        };
        this.decodeThread = simpleDecoder$10;
        simpleDecoder$10.start();
    }

    public static void access$000(SimpleDecoder simpleDecoder0) {
        simpleDecoder0.run();
    }

    private boolean canDecodeBuffer() {
        return !this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0;
    }

    public abstract DecoderInputBuffer createInputBuffer();

    public abstract OutputBuffer createOutputBuffer();

    public abstract Exception createUnexpectedDecodeException(Throwable arg1);

    private boolean decode() {
        boolean z;
        OutputBuffer outputBuffer0;
        DecoderInputBuffer decoderInputBuffer0;
        Exception exception0;
        synchronized(this.lock) {
            while(!this.released && !this.canDecodeBuffer()) {
                this.lock.wait();
            }
            if(this.released) {
                return false;
            }
            decoderInputBuffer0 = (DecoderInputBuffer)this.queuedInputBuffers.removeFirst();
            int v1 = this.availableOutputBufferCount - 1;
            this.availableOutputBufferCount = v1;
            outputBuffer0 = this.availableOutputBuffers[v1];
            z = this.flushed;
            this.flushed = false;
        }
        if(decoderInputBuffer0.isEndOfStream()) {
            outputBuffer0.addFlag(4);
        }
        else {
            if(decoderInputBuffer0.isDecodeOnly()) {
                outputBuffer0.addFlag(0x80000000);
            }
            try {
                exception0 = this.decode(decoderInputBuffer0, outputBuffer0, z);
            }
            catch(RuntimeException runtimeException0) {
                exception0 = this.createUnexpectedDecodeException(runtimeException0);
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                exception0 = this.createUnexpectedDecodeException(outOfMemoryError0);
            }
            if(exception0 != null) {
                synchronized(this.lock) {
                    this.exception = exception0;
                }
                return false;
            }
        }
        synchronized(this.lock) {
            if(this.flushed) {
                outputBuffer0.release();
            }
            else if(outputBuffer0.isDecodeOnly()) {
                ++this.skippedOutputBufferCount;
                outputBuffer0.release();
            }
            else {
                outputBuffer0.skippedOutputBufferCount = this.skippedOutputBufferCount;
                this.skippedOutputBufferCount = 0;
                this.queuedOutputBuffers.addLast(outputBuffer0);
            }
            this.releaseInputBufferInternal(decoderInputBuffer0);
            return true;
        }
    }

    public abstract Exception decode(DecoderInputBuffer arg1, OutputBuffer arg2, boolean arg3);

    public final DecoderInputBuffer dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer0;
        synchronized(this.lock) {
            this.maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            int v1 = this.availableInputBufferCount;
            if(v1 == 0) {
                decoderInputBuffer0 = null;
            }
            else {
                this.availableInputBufferCount = v1 - 1;
                decoderInputBuffer0 = this.availableInputBuffers[v1 - 1];
            }
            this.dequeuedInputBuffer = decoderInputBuffer0;
            return decoderInputBuffer0;
        }
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public Object dequeueInputBuffer() {
        return this.dequeueInputBuffer();
    }

    public final OutputBuffer dequeueOutputBuffer() {
        synchronized(this.lock) {
            this.maybeThrowException();
            if(this.queuedOutputBuffers.isEmpty()) {
                return null;
            }
        }
        return (OutputBuffer)this.queuedOutputBuffers.removeFirst();
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public Object dequeueOutputBuffer() {
        return this.dequeueOutputBuffer();
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized(this.lock) {
            this.flushed = true;
            this.skippedOutputBufferCount = 0;
            DecoderInputBuffer decoderInputBuffer0 = this.dequeuedInputBuffer;
            if(decoderInputBuffer0 != null) {
                this.releaseInputBufferInternal(decoderInputBuffer0);
                this.dequeuedInputBuffer = null;
            }
            while(!this.queuedInputBuffers.isEmpty()) {
                this.releaseInputBufferInternal(((DecoderInputBuffer)this.queuedInputBuffers.removeFirst()));
            }
            while(!this.queuedOutputBuffers.isEmpty()) {
                ((OutputBuffer)this.queuedOutputBuffers.removeFirst()).release();
            }
            this.exception = null;
        }
    }

    private void maybeNotifyDecodeLoop() {
        if(this.canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    private void maybeThrowException() {
        Exception exception0 = this.exception;
        if(exception0 != null) {
            throw exception0;
        }
    }

    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer0) {
        synchronized(this.lock) {
            this.maybeThrowException();
            Assertions.checkArgument(decoderInputBuffer0 == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(decoderInputBuffer0);
            this.maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(Object object0) {
        this.queueInputBuffer(((DecoderInputBuffer)object0));
    }

    @Override  // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        synchronized(this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        }
        catch(InterruptedException unused_ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void releaseInputBufferInternal(DecoderInputBuffer decoderInputBuffer0) {
        decoderInputBuffer0.clear();
        int v = this.availableInputBufferCount;
        this.availableInputBufferCount = v + 1;
        this.availableInputBuffers[v] = decoderInputBuffer0;
    }

    public void releaseOutputBuffer(OutputBuffer outputBuffer0) {
        synchronized(this.lock) {
            this.releaseOutputBufferInternal(outputBuffer0);
            this.maybeNotifyDecodeLoop();
        }
    }

    private void releaseOutputBufferInternal(OutputBuffer outputBuffer0) {
        outputBuffer0.clear();
        int v = this.availableOutputBufferCount;
        this.availableOutputBufferCount = v + 1;
        this.availableOutputBuffers[v] = outputBuffer0;
    }

    private void run() {
        while(true) {
            try {
                if(!this.decode()) {
                    break;
                }
            }
            catch(InterruptedException interruptedException0) {
                throw new IllegalStateException(interruptedException0);
            }
        }
    }

    public final void setInitialInputBufferSize(int v) {
        Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length);
        DecoderInputBuffer[] arr_decoderInputBuffer = this.availableInputBuffers;
        for(int v1 = 0; v1 < arr_decoderInputBuffer.length; ++v1) {
            arr_decoderInputBuffer[v1].ensureSpaceForWrite(v);
        }
    }
}

