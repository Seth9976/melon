package okhttp3.internal.ws;

import d8.d;
import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer.UnsafeCursor;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\t\u001A\u00020\u0002*\u00020\u00062\u0006\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0006¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001A\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "Lokio/Buffer;", "Lokio/ByteString;", "suffix", "endsWith", "(Lokio/Buffer;Lokio/ByteString;)Z", "buffer", "Lie/H;", "deflate", "(Lokio/Buffer;)V", "close", "()V", "Z", "deflatedBytes", "Lokio/Buffer;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "Lokio/DeflaterSink;", "deflaterSink", "Lokio/DeflaterSink;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MessageDeflater implements Closeable {
    @NotNull
    private final Buffer deflatedBytes;
    @NotNull
    private final Deflater deflater;
    @NotNull
    private final DeflaterSink deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z) {
        this.noContextTakeover = z;
        Buffer buffer0 = new Buffer();
        this.deflatedBytes = buffer0;
        Deflater deflater0 = new Deflater(-1, true);
        this.deflater = deflater0;
        this.deflaterSink = new DeflaterSink(buffer0, deflater0);
    }

    @Override
    public void close() {
        this.deflaterSink.close();
    }

    public final void deflate(@NotNull Buffer buffer0) {
        q.g(buffer0, "buffer");
        if(this.deflatedBytes.size() != 0L) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if(this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer0, buffer0.size());
        this.deflaterSink.flush();
        if(this.endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            long v = this.deflatedBytes.size();
            UnsafeCursor buffer$UnsafeCursor0 = Buffer.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
            try {
                buffer$UnsafeCursor0.resizeBuffer(v - 4L);
            }
            catch(Throwable throwable0) {
                d.l(buffer$UnsafeCursor0, throwable0);
                throw throwable0;
            }
            buffer$UnsafeCursor0.close();
        }
        else {
            this.deflatedBytes.writeByte(0);
        }
        buffer0.write(this.deflatedBytes, this.deflatedBytes.size());
    }

    private final boolean endsWith(Buffer buffer0, ByteString byteString0) {
        return buffer0.rangeEquals(buffer0.size() - ((long)byteString0.size()), byteString0);
    }
}

