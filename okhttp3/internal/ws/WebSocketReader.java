package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer.UnsafeCursor;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00011B/\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u000F\u0010\u0011\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u000EJ\u000F\u0010\u0012\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u000EJ\r\u0010\u0013\u001A\u00020\f\u00A2\u0006\u0004\b\u0013\u0010\u000EJ\u000F\u0010\u0014\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u000ER\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\b\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010\t\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0016\u0010\u001A\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u0015R\u0016\u0010\u001C\u001A\u00020\u001B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0016\u0010\u001F\u001A\u00020\u001E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001F\u0010 R\u0016\u0010!\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b!\u0010\u0015R\u0016\u0010\"\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0016\u0010#\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b#\u0010\u0015R\u0014\u0010%\u001A\u00020$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010&R\u0018\u0010)\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001A\u0004\u0018\u00010+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001A\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u00100\u00A8\u00062"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "", "isClient", "Lokio/BufferedSource;", "source", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "frameCallback", "perMessageDeflate", "noContextTakeover", "<init>", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "Lie/H;", "readHeader", "()V", "readControlFrame", "readMessageFrame", "readUntilNonControlFrame", "readMessage", "processNextFrame", "close", "Z", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "closed", "", "opcode", "I", "", "frameLength", "J", "isFinalFrame", "isControlFrame", "readingCompressedMessage", "Lokio/Buffer;", "controlFrameBuffer", "Lokio/Buffer;", "messageFrameBuffer", "Lokhttp3/internal/ws/MessageInflater;", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "", "maskKey", "[B", "Lokio/Buffer$UnsafeCursor;", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "FrameCallback", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WebSocketReader implements Closeable {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0007H&¢\u0006\u0004\b\u000B\u0010\tJ\u0017\u0010\f\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0007H&¢\u0006\u0004\b\f\u0010\tJ\u001F\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "", "text", "Lie/H;", "onReadMessage", "(Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)V", "payload", "onReadPing", "onReadPong", "", "code", "reason", "onReadClose", "(ILjava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface FrameCallback {
        void onReadClose(int arg1, @NotNull String arg2);

        void onReadMessage(@NotNull String arg1);

        void onReadMessage(@NotNull ByteString arg1);

        void onReadPing(@NotNull ByteString arg1);

        void onReadPong(@NotNull ByteString arg1);
    }

    private boolean closed;
    @NotNull
    private final Buffer controlFrameBuffer;
    @NotNull
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    @Nullable
    private final UnsafeCursor maskCursor;
    @Nullable
    private final byte[] maskKey;
    @NotNull
    private final Buffer messageFrameBuffer;
    @Nullable
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    @NotNull
    private final BufferedSource source;

    public WebSocketReader(boolean z, @NotNull BufferedSource bufferedSource0, @NotNull FrameCallback webSocketReader$FrameCallback0, boolean z1, boolean z2) {
        q.g(bufferedSource0, "source");
        q.g(webSocketReader$FrameCallback0, "frameCallback");
        super();
        this.isClient = z;
        this.source = bufferedSource0;
        this.frameCallback = webSocketReader$FrameCallback0;
        this.perMessageDeflate = z1;
        this.noContextTakeover = z2;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        UnsafeCursor buffer$UnsafeCursor0 = null;
        this.maskKey = z ? null : new byte[4];
        if(!z) {
            buffer$UnsafeCursor0 = new UnsafeCursor();
        }
        this.maskCursor = buffer$UnsafeCursor0;
    }

    @Override
    public void close() {
        MessageInflater messageInflater0 = this.messageInflater;
        if(messageInflater0 != null) {
            messageInflater0.close();
        }
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() {
        this.readHeader();
        if(this.isControlFrame) {
            this.readControlFrame();
            return;
        }
        this.readMessageFrame();
    }

    private final void readControlFrame() {
        int v2;
        long v = this.frameLength;
        if(v > 0L) {
            this.source.readFully(this.controlFrameBuffer, v);
            if(!this.isClient) {
                q.d(this.maskCursor);
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                q.d(this.maskKey);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch(this.opcode) {
            case 8: {
                long v1 = this.controlFrameBuffer.size();
                if(v1 == 1L) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if(v1 == 0L) {
                    v2 = 1005;
                }
                else {
                    v2 = this.controlFrameBuffer.readShort();
                    String s = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(v2);
                    if(s != null) {
                        throw new ProtocolException(s);
                    }
                }
                this.frameCallback.onReadClose(v2, "");
                this.closed = true;
                return;
            }
            case 9: {
                ByteString byteString0 = this.controlFrameBuffer.readByteString();
                this.frameCallback.onReadPing(byteString0);
                return;
            }
            case 10: {
                ByteString byteString1 = this.controlFrameBuffer.readByteString();
                this.frameCallback.onReadPong(byteString1);
                return;
            }
            default: {
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
            }
        }
    }

    private final void readHeader() {
        int v2;
        boolean z4;
        if(this.closed) {
            throw new IOException("closed");
        }
        long v = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            v2 = Util.and(this.source.readByte(), ((byte)0xFF));
        }
        finally {
            this.source.timeout().timeout(v, TimeUnit.NANOSECONDS);
        }
        this.opcode = v2 & 15;
        boolean z = false;
        boolean z1 = (v2 & 0x80) != 0;
        this.isFinalFrame = z1;
        boolean z2 = (v2 & 8) != 0;
        this.isControlFrame = z2;
        if(z2 && !z1) {
            throw new ProtocolException("Control frames must be final.");
        }
        boolean z3 = (v2 & 0x40) != 0;
        if((v2 & 15) == 1 || (v2 & 15) == 2) {
            if(z3) {
                if(!this.perMessageDeflate) {
                    throw new ProtocolException("Unexpected rsv1 flag");
                }
                z4 = true;
            }
            else {
                z4 = false;
            }
            this.readingCompressedMessage = z4;
        }
        else if(z3) {
            throw new ProtocolException("Unexpected rsv1 flag");
        }
        if((v2 & 0x20) != 0) {
            throw new ProtocolException("Unexpected rsv2 flag");
        }
        if((v2 & 16) != 0) {
            throw new ProtocolException("Unexpected rsv3 flag");
        }
        int v3 = Util.and(this.source.readByte(), ((byte)0xFF));
        if((v3 & 0x80) != 0) {
            z = true;
        }
        if(z == this.isClient) {
            throw new ProtocolException((this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked."));
        }
        this.frameLength = (long)(v3 & 0x7F);
        if(((long)(v3 & 0x7F)) == 0x7EL) {
            this.frameLength = (long)Util.and(this.source.readShort(), ((short)0xFFFF));
        }
        else if(((long)(v3 & 0x7F)) == 0x7FL) {
            long v4 = this.source.readLong();
            this.frameLength = v4;
            if(v4 < 0L) {
                throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
            }
        }
        if(this.isControlFrame && this.frameLength > 0x7DL) {
            throw new ProtocolException("Control frame must be less than 125B.");
        }
        if(z) {
            q.d(this.maskKey);
            this.source.readFully(this.maskKey);
        }
    }

    private final void readMessage() {
        while(!this.closed) {
            long v = this.frameLength;
            if(v > 0L) {
                this.source.readFully(this.messageFrameBuffer, v);
                if(!this.isClient) {
                    q.d(this.maskCursor);
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    q.d(this.maskKey);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if(!this.isFinalFrame) {
                this.readUntilNonControlFrame();
                if(this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
                }
                continue;
            }
            return;
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() {
        int v = this.opcode;
        if(v != 1 && v != 2) {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(v));
        }
        this.readMessage();
        if(this.readingCompressedMessage) {
            MessageInflater messageInflater0 = this.messageInflater;
            if(messageInflater0 == null) {
                messageInflater0 = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater0;
            }
            messageInflater0.inflate(this.messageFrameBuffer);
        }
        if(v == 1) {
            this.frameCallback.onReadMessage("");
            return;
        }
        ByteString byteString0 = this.messageFrameBuffer.readByteString();
        this.frameCallback.onReadMessage(byteString0);
    }

    private final void readUntilNonControlFrame() {
        while(!this.closed) {
            this.readHeader();
            if(!this.isControlFrame) {
                break;
            }
            this.readControlFrame();
        }
    }
}

