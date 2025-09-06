package okio;

import java.io.Closeable;
import java.io.Flushable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH&¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0007H&¢\u0006\u0004\b\u000F\u0010\u000Bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lokio/Sink;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Sink extends Closeable, Flushable {
    @Override
    void close();

    @Override
    void flush();

    @NotNull
    Timeout timeout();

    void write(@NotNull Buffer arg1, long arg2);
}

