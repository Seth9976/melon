package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer.UnsafeCursor;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u001F\u0010\u001A\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u000E2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u001A\u0010\u0014J\u001D\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u0010\u00A2\u0006\u0004\b\u001D\u0010\u0014J\u000F\u0010\u001E\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010 R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010!\u001A\u0004\b\"\u0010#R\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010$\u001A\u0004\b%\u0010&R\u0014\u0010\b\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010 R\u0014\u0010\t\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010 R\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010\'R\u0014\u0010)\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010,\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010 R\u0018\u0010.\u001A\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001A\u0004\u0018\u0001008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001A\u0004\u0018\u0001038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00105\u00A8\u00066"}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "", "isClient", "Lokio/BufferedSink;", "sink", "Ljava/util/Random;", "random", "perMessageDeflate", "noContextTakeover", "", "minimumDeflateSize", "<init>", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "", "opcode", "Lokio/ByteString;", "payload", "Lie/H;", "writeControlFrame", "(ILokio/ByteString;)V", "writePing", "(Lokio/ByteString;)V", "writePong", "code", "reason", "writeClose", "formatOpcode", "data", "writeMessageFrame", "close", "()V", "Z", "Lokio/BufferedSink;", "getSink", "()Lokio/BufferedSink;", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "J", "Lokio/Buffer;", "messageBuffer", "Lokio/Buffer;", "sinkBuffer", "writerClosed", "Lokhttp3/internal/ws/MessageDeflater;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "", "maskKey", "[B", "Lokio/Buffer$UnsafeCursor;", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    @Nullable
    private final UnsafeCursor maskCursor;
    @Nullable
    private final byte[] maskKey;
    @NotNull
    private final Buffer messageBuffer;
    @Nullable
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    @NotNull
    private final Random random;
    @NotNull
    private final BufferedSink sink;
    @NotNull
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z, @NotNull BufferedSink bufferedSink0, @NotNull Random random0, boolean z1, boolean z2, long v) {
        q.g(bufferedSink0, "sink");
        q.g(random0, "random");
        super();
        this.isClient = z;
        this.sink = bufferedSink0;
        this.random = random0;
        this.perMessageDeflate = z1;
        this.noContextTakeover = z2;
        this.minimumDeflateSize = v;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = bufferedSink0.getBuffer();
        UnsafeCursor buffer$UnsafeCursor0 = null;
        this.maskKey = z ? new byte[4] : null;
        if(z) {
            buffer$UnsafeCursor0 = new UnsafeCursor();
        }
        this.maskCursor = buffer$UnsafeCursor0;
    }

    @Override
    public void close() {
        MessageDeflater messageDeflater0 = this.messageDeflater;
        if(messageDeflater0 != null) {
            messageDeflater0.close();
        }
    }

    @NotNull
    public final Random getRandom() {
        return this.random;
    }

    @NotNull
    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int v, @Nullable ByteString byteString0) {
        ByteString byteString1 = ByteString.EMPTY;
        if(v != 0 || byteString0 != null) {
            if(v != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(v);
            }
            Buffer buffer0 = new Buffer();
            buffer0.writeShort(v);
            if(byteString0 != null) {
                buffer0.write(byteString0);
            }
            byteString1 = buffer0.readByteString();
        }
        try {
            this.writeControlFrame(8, byteString1);
            this.writerClosed = true;
        }
        catch(Throwable throwable0) {
            this.writerClosed = true;
            throw throwable0;
        }
    }

    private final void writeControlFrame(int v, ByteString byteString0) {
        if(this.writerClosed) {
            throw new IOException("closed");
        }
        int v1 = byteString0.size();
        if(((long)v1) > 0x7DL) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.writeByte(v | 0x80);
        if(this.isClient) {
            this.sinkBuffer.writeByte(v1 | 0x80);
            q.d(this.maskKey);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if(v1 > 0) {
                this.sinkBuffer.write(byteString0);
                q.d(this.maskCursor);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(this.sinkBuffer.size());
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        else {
            this.sinkBuffer.writeByte(v1);
            this.sinkBuffer.write(byteString0);
        }
        this.sink.flush();
    }

    public final void writeMessageFrame(int v, @NotNull ByteString byteString0) {
        q.g(byteString0, "data");
        if(this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.write(byteString0);
        int v1 = v | 0x80;
        if(this.perMessageDeflate && ((long)byteString0.size()) >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater0 = this.messageDeflater;
            if(messageDeflater0 == null) {
                messageDeflater0 = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater0;
            }
            messageDeflater0.deflate(this.messageBuffer);
            v1 = v | 0xC0;
        }
        long v2 = this.messageBuffer.size();
        this.sinkBuffer.writeByte(v1);
        int v3 = this.isClient ? 0x80 : 0;
        if(v2 <= 0x7DL) {
            this.sinkBuffer.writeByte(v3 | ((int)v2));
        }
        else if(v2 <= 0xFFFFL) {
            this.sinkBuffer.writeByte(v3 | 0x7E);
            this.sinkBuffer.writeShort(((int)v2));
        }
        else {
            this.sinkBuffer.writeByte(v3 | 0x7F);
            this.sinkBuffer.writeLong(v2);
        }
        if(this.isClient) {
            q.d(this.maskKey);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if(v2 > 0L) {
                q.d(this.maskCursor);
                this.messageBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, v2);
        this.sink.emit();
    }

    public final void writePing(@NotNull ByteString byteString0) {
        q.g(byteString0, "payload");
        this.writeControlFrame(9, byteString0);
    }

    public final void writePong(@NotNull ByteString byteString0) {
        q.g(byteString0, "payload");
        this.writeControlFrame(10, byteString0);
    }
}

