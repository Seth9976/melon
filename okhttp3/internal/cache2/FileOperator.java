package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\rR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "Ljava/nio/channels/FileChannel;", "fileChannel", "<init>", "(Ljava/nio/channels/FileChannel;)V", "", "pos", "Lokio/Buffer;", "source", "byteCount", "Lie/H;", "write", "(JLokio/Buffer;J)V", "sink", "read", "Ljava/nio/channels/FileChannel;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FileOperator {
    @NotNull
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel fileChannel0) {
        q.g(fileChannel0, "fileChannel");
        super();
        this.fileChannel = fileChannel0;
    }

    public final void read(long v, @NotNull Buffer buffer0, long v1) {
        q.g(buffer0, "sink");
        if(v1 < 0L) {
            throw new IndexOutOfBoundsException();
        }
        long v2 = v;
        for(long v3 = v1; v3 > 0L; v3 -= v4) {
            long v4 = this.fileChannel.transferTo(v2, v3, buffer0);
            v2 += v4;
        }
    }

    public final void write(long v, @NotNull Buffer buffer0, long v1) {
        q.g(buffer0, "source");
        if(v1 < 0L || v1 > buffer0.size()) {
            throw new IndexOutOfBoundsException();
        }
        long v2 = v;
        for(long v3 = v1; v3 > 0L; v3 -= v4) {
            long v4 = this.fileChannel.transferFrom(buffer0, v2, v3);
            v2 += v4;
        }
    }
}

