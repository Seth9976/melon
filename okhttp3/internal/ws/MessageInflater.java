package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import okio.InflaterSource;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u000E\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0011\u001A\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "Lokio/Buffer;", "buffer", "Lie/H;", "inflate", "(Lokio/Buffer;)V", "close", "()V", "Z", "deflatedBytes", "Lokio/Buffer;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/InflaterSource;", "inflaterSource", "Lokio/InflaterSource;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MessageInflater implements Closeable {
    @NotNull
    private final Buffer deflatedBytes;
    @NotNull
    private final Inflater inflater;
    @NotNull
    private final InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z) {
        this.noContextTakeover = z;
        Buffer buffer0 = new Buffer();
        this.deflatedBytes = buffer0;
        Inflater inflater0 = new Inflater(true);
        this.inflater = inflater0;
        this.inflaterSource = new InflaterSource(buffer0, inflater0);
    }

    @Override
    public void close() {
        this.inflaterSource.close();
    }

    public final void inflate(@NotNull Buffer buffer0) {
        q.g(buffer0, "buffer");
        if(this.deflatedBytes.size() != 0L) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if(this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.writeAll(buffer0);
        this.deflatedBytes.writeInt(0xFFFF);
        long v = this.inflater.getBytesRead();
        long v1 = this.deflatedBytes.size();
        do {
            this.inflaterSource.readOrInflate(buffer0, 0x7FFFFFFFFFFFFFFFL);
        }
        while(this.inflater.getBytesRead() < v1 + v);
    }
}

