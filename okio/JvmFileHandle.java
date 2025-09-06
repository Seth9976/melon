package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\u000EJ/\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0012H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\nH\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u001B\u0010\u001AR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001C¨\u0006\u001D"}, d2 = {"Lokio/JvmFileHandle;", "Lokio/FileHandle;", "", "readWrite", "Ljava/io/RandomAccessFile;", "randomAccessFile", "<init>", "(ZLjava/io/RandomAccessFile;)V", "", "size", "Lie/H;", "protectedResize", "(J)V", "protectedSize", "()J", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "protectedRead", "(J[BII)I", "protectedWrite", "(J[BII)V", "protectedFlush", "()V", "protectedClose", "Ljava/io/RandomAccessFile;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class JvmFileHandle extends FileHandle {
    @NotNull
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean z, @NotNull RandomAccessFile randomAccessFile0) {
        q.g(randomAccessFile0, "randomAccessFile");
        super(z);
        this.randomAccessFile = randomAccessFile0;
    }

    @Override  // okio.FileHandle
    public void protectedClose() {
        synchronized(this) {
            this.randomAccessFile.close();
        }
    }

    @Override  // okio.FileHandle
    public void protectedFlush() {
        synchronized(this) {
            this.randomAccessFile.getFD().sync();
        }
    }

    @Override  // okio.FileHandle
    public int protectedRead(long v, @NotNull byte[] arr_b, int v1, int v2) {
        synchronized(this) {
            q.g(arr_b, "array");
            this.randomAccessFile.seek(v);
            int v4;
            for(v4 = 0; v4 < v2; v4 += v5) {
                int v5 = this.randomAccessFile.read(arr_b, v1, v2 - v4);
                if(v5 == -1) {
                    if(v4 != 0) {
                        break;
                    }
                    return -1;
                }
            }
            return v4;
        }
    }

    @Override  // okio.FileHandle
    public void protectedResize(long v) {
        synchronized(this) {
            long v2 = this.size();
            long v3 = v - v2;
            if(v3 > 0L) {
                this.protectedWrite(v2, new byte[((int)v3)], 0, ((int)v3));
            }
            else {
                this.randomAccessFile.setLength(v);
            }
        }
    }

    @Override  // okio.FileHandle
    public long protectedSize() {
        synchronized(this) {
            return this.randomAccessFile.length();
        }
    }

    @Override  // okio.FileHandle
    public void protectedWrite(long v, @NotNull byte[] arr_b, int v1, int v2) {
        synchronized(this) {
            q.g(arr_b, "array");
            this.randomAccessFile.seek(v);
            this.randomAccessFile.write(arr_b, v1, v2);
        }
    }
}

