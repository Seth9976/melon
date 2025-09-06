package okio;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002?@B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000B\u00A2\u0006\u0004\b\u000E\u0010\u000FJ%\u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u0007\u00A2\u0006\u0004\b\u000E\u0010\u0012J\r\u0010\u0013\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0013\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0018\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0018\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0018\u0010\u001BJ\r\u0010\u001C\u001A\u00020\u0015\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001A\u001A\u00020\u001E2\b\b\u0002\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\u001A\u0010\u001FJ\u0015\u0010 \u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u001E\u00A2\u0006\u0004\b \u0010!J\u001D\u0010\"\u001A\u00020\u00152\u0006\u0010\u001A\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u0007\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010\u0011\u001A\u00020$2\b\b\u0002\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0011\u0010%J\r\u0010&\u001A\u00020$\u00A2\u0006\u0004\b&\u0010\'J\u0015\u0010 \u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020$\u00A2\u0006\u0004\b \u0010(J\u001D\u0010\"\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020$2\u0006\u0010 \u001A\u00020\u0007\u00A2\u0006\u0004\b\"\u0010)J\r\u0010*\u001A\u00020\u0015\u00A2\u0006\u0004\b*\u0010\u001DJ/\u0010+\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH$\u00A2\u0006\u0004\b+\u0010\u000FJ/\u0010,\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH$\u00A2\u0006\u0004\b,\u0010\u0019J\u000F\u0010-\u001A\u00020\u0015H$\u00A2\u0006\u0004\b-\u0010\u001DJ\u0017\u0010.\u001A\u00020\u00152\u0006\u0010\u0013\u001A\u00020\u0007H$\u00A2\u0006\u0004\b.\u0010\u0017J\u000F\u0010/\u001A\u00020\u0007H$\u00A2\u0006\u0004\b/\u0010\u0014J\u000F\u00100\u001A\u00020\u0015H$\u00A2\u0006\u0004\b0\u0010\u001DJ\'\u00101\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b1\u0010\u0012J\'\u00102\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b2\u0010\u001BR\u0017\u0010\u0004\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0004\u00103\u001A\u0004\b4\u00105R\u0016\u00106\u001A\u00020\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00103R\u0016\u00107\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u001B\u0010;\u001A\u000609j\u0002`:8\u0006\u00A2\u0006\f\n\u0004\b;\u0010<\u001A\u0004\b=\u0010>\u00A8\u0006A"}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "readWrite", "<init>", "(Z)V", "", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "read", "(J[BII)I", "Lokio/Buffer;", "sink", "(JLokio/Buffer;J)J", "size", "()J", "Lie/H;", "resize", "(J)V", "write", "(J[BII)V", "source", "(JLokio/Buffer;J)V", "flush", "()V", "Lokio/Source;", "(J)Lokio/Source;", "position", "(Lokio/Source;)J", "reposition", "(Lokio/Source;J)V", "Lokio/Sink;", "(J)Lokio/Sink;", "appendingSink", "()Lokio/Sink;", "(Lokio/Sink;)J", "(Lokio/Sink;J)V", "close", "protectedRead", "protectedWrite", "protectedFlush", "protectedResize", "protectedSize", "protectedClose", "readNoCloseCheck", "writeNoCloseCheck", "Z", "getReadWrite", "()Z", "closed", "openStreamCount", "I", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class FileHandle implements Closeable {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u000FR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\"\u0010\u001D\u001A\u00020\u001C8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "Lokio/FileHandle;", "fileHandle", "", "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "source", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "J", "getPosition", "()J", "setPosition", "(J)V", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class FileHandleSink implements Sink {
        private boolean closed;
        @NotNull
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(@NotNull FileHandle fileHandle0, long v) {
            q.g(fileHandle0, "fileHandle");
            super();
            this.fileHandle = fileHandle0;
            this.position = v;
        }

        @Override  // okio.Sink
        public void close() {
            if(this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock reentrantLock0 = this.fileHandle.getLock();
            reentrantLock0.lock();
            try {
                --this.fileHandle.openStreamCount;
                if(this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    this.fileHandle.protectedClose();
                }
            }
            finally {
                reentrantLock0.unlock();
            }
        }

        @Override  // okio.Sink
        public void flush() {
            if(this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.protectedFlush();
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setPosition(long v) {
            this.position = v;
        }

        @Override  // okio.Sink
        @NotNull
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override  // okio.Sink
        public void write(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "source");
            if(this.closed) {
                throw new IllegalStateException("closed");
            }
            this.fileHandle.writeNoCloseCheck(this.position, buffer0, v);
            this.position += v;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\"\u0010\u001C\u001A\u00020\u001B8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "Lokio/FileHandle;", "fileHandle", "", "position", "<init>", "(Lokio/FileHandle;J)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lie/H;", "close", "()V", "Lokio/FileHandle;", "getFileHandle", "()Lokio/FileHandle;", "J", "getPosition", "()J", "setPosition", "(J)V", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class FileHandleSource implements Source {
        private boolean closed;
        @NotNull
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(@NotNull FileHandle fileHandle0, long v) {
            q.g(fileHandle0, "fileHandle");
            super();
            this.fileHandle = fileHandle0;
            this.position = v;
        }

        @Override  // okio.Source
        public void close() {
            if(this.closed) {
                return;
            }
            this.closed = true;
            ReentrantLock reentrantLock0 = this.fileHandle.getLock();
            reentrantLock0.lock();
            try {
                --this.fileHandle.openStreamCount;
                if(this.fileHandle.openStreamCount == 0 && this.fileHandle.closed) {
                    this.fileHandle.protectedClose();
                }
            }
            finally {
                reentrantLock0.unlock();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        @Override  // okio.Source
        public long read(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "sink");
            if(this.closed) {
                throw new IllegalStateException("closed");
            }
            long v1 = this.fileHandle.readNoCloseCheck(this.position, buffer0, v);
            if(v1 != -1L) {
                this.position += v1;
            }
            return v1;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setPosition(long v) {
            this.position = v;
        }

        @Override  // okio.Source
        @NotNull
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    private boolean closed;
    @NotNull
    private final ReentrantLock lock;
    private int openStreamCount;
    private final boolean readWrite;

    public FileHandle(boolean z) {
        this.readWrite = z;
        this.lock = _JvmPlatformKt.newLock();
    }

    @NotNull
    public final Sink appendingSink() {
        return this.sink(this.size());
    }

    @Override
    public final void close() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        if(this.closed) {
            reentrantLock0.unlock();
            return;
        }
        this.closed = true;
        if(this.openStreamCount != 0) {
            reentrantLock0.unlock();
            return;
        }
        reentrantLock0.unlock();
        this.protectedClose();
    }

    public final void flush() {
        if(!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                this.protectedFlush();
                return;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(@NotNull Sink sink0) {
        long v;
        q.g(sink0, "sink");
        if(sink0 instanceof RealBufferedSink) {
            v = ((RealBufferedSink)sink0).bufferField.size();
            sink0 = ((RealBufferedSink)sink0).sink;
        }
        else {
            v = 0L;
        }
        if(!(sink0 instanceof FileHandleSink) || ((FileHandleSink)sink0).getFileHandle() != this) {
            throw new IllegalArgumentException("sink was not created by this FileHandle");
        }
        if(((FileHandleSink)sink0).getClosed()) {
            throw new IllegalStateException("closed");
        }
        return ((FileHandleSink)sink0).getPosition() + v;
    }

    public final long position(@NotNull Source source0) {
        long v;
        q.g(source0, "source");
        if(source0 instanceof RealBufferedSource) {
            v = ((RealBufferedSource)source0).bufferField.size();
            source0 = ((RealBufferedSource)source0).source;
        }
        else {
            v = 0L;
        }
        if(!(source0 instanceof FileHandleSource) || ((FileHandleSource)source0).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        if(((FileHandleSource)source0).getClosed()) {
            throw new IllegalStateException("closed");
        }
        return ((FileHandleSource)source0).getPosition() - v;
    }

    public abstract void protectedClose();

    public abstract void protectedFlush();

    public abstract int protectedRead(long arg1, @NotNull byte[] arg2, int arg3, int arg4);

    public abstract void protectedResize(long arg1);

    public abstract long protectedSize();

    public abstract void protectedWrite(long arg1, @NotNull byte[] arg2, int arg3, int arg4);

    public final int read(long v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(arr_b, "array");
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                return this.protectedRead(v, arr_b, v1, v2);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    public final long read(long v, @NotNull Buffer buffer0, long v1) {
        q.g(buffer0, "sink");
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                return this.readNoCloseCheck(v, buffer0, v1);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    private final long readNoCloseCheck(long v, Buffer buffer0, long v1) {
        if(v1 < 0L) {
            throw new IllegalArgumentException(e.a(v1, "byteCount < 0: ").toString());
        }
        long v2 = v1 + v;
        long v3 = v;
        while(v3 < v2) {
            Segment segment0 = buffer0.writableSegment$okio(1);
            int v4 = this.protectedRead(v3, segment0.data, segment0.limit, ((int)Math.min(v2 - v3, 0x2000 - segment0.limit)));
            if(v4 == -1) {
                if(segment0.pos == segment0.limit) {
                    buffer0.head = segment0.pop();
                    SegmentPool.recycle(segment0);
                }
                return v == v3 ? -1L : v3 - v;
            }
            segment0.limit += v4;
            v3 += (long)v4;
            buffer0.setSize$okio(buffer0.size() + ((long)v4));
        }
        return v3 - v;
    }

    public final void reposition(@NotNull Sink sink0, long v) {
        q.g(sink0, "sink");
        if(sink0 instanceof RealBufferedSink) {
            Sink sink1 = ((RealBufferedSink)sink0).sink;
            if(!(sink1 instanceof FileHandleSink) || ((FileHandleSink)sink1).getFileHandle() != this) {
                throw new IllegalArgumentException("sink was not created by this FileHandle");
            }
            if(((FileHandleSink)sink1).getClosed()) {
                throw new IllegalStateException("closed");
            }
            ((RealBufferedSink)sink0).emit();
            ((FileHandleSink)sink1).setPosition(v);
            return;
        }
        if(!(sink0 instanceof FileHandleSink) || ((FileHandleSink)sink0).getFileHandle() != this) {
            throw new IllegalArgumentException("sink was not created by this FileHandle");
        }
        if(((FileHandleSink)sink0).getClosed()) {
            throw new IllegalStateException("closed");
        }
        ((FileHandleSink)sink0).setPosition(v);
    }

    public final void reposition(@NotNull Source source0, long v) {
        q.g(source0, "source");
        if(source0 instanceof RealBufferedSource) {
            Source source1 = ((RealBufferedSource)source0).source;
            if(!(source1 instanceof FileHandleSource) || ((FileHandleSource)source1).getFileHandle() != this) {
                throw new IllegalArgumentException("source was not created by this FileHandle");
            }
            if(((FileHandleSource)source1).getClosed()) {
                throw new IllegalStateException("closed");
            }
            long v1 = ((RealBufferedSource)source0).bufferField.size();
            long v2 = v - (((FileHandleSource)source1).getPosition() - v1);
            if(0L <= v2 && v2 < v1) {
                ((RealBufferedSource)source0).skip(v2);
                return;
            }
            ((RealBufferedSource)source0).bufferField.clear();
            ((FileHandleSource)source1).setPosition(v);
            return;
        }
        if(!(source0 instanceof FileHandleSource) || ((FileHandleSource)source0).getFileHandle() != this) {
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        if(((FileHandleSource)source0).getClosed()) {
            throw new IllegalStateException("closed");
        }
        ((FileHandleSource)source0).setPosition(v);
    }

    public final void resize(long v) {
        if(!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                this.protectedResize(v);
                return;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public final Sink sink(long v) {
        if(!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                ++this.openStreamCount;
                return new FileHandleSink(this, v);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    public static Sink sink$default(FileHandle fileHandle0, long v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if((v1 & 1) != 0) {
            v = 0L;
        }
        return fileHandle0.sink(v);
    }

    public final long size() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                return this.protectedSize();
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public final Source source(long v) {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                ++this.openStreamCount;
                return new FileHandleSource(this, v);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    public static Source source$default(FileHandle fileHandle0, long v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if((v1 & 1) != 0) {
            v = 0L;
        }
        return fileHandle0.source(v);
    }

    public final void write(long v, @NotNull Buffer buffer0, long v1) {
        q.g(buffer0, "source");
        if(!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                this.writeNoCloseCheck(v, buffer0, v1);
                return;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    public final void write(long v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(arr_b, "array");
        if(!this.readWrite) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.closed) {
                this.protectedWrite(v, arr_b, v1, v2);
                return;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("closed");
    }

    private final void writeNoCloseCheck(long v, Buffer buffer0, long v1) {
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v1);
        long v2 = v + v1;
        long v3 = v;
        while(v3 < v2) {
            Segment segment0 = buffer0.head;
            q.d(segment0);
            int v4 = (int)Math.min(v2 - v3, segment0.limit - segment0.pos);
            this.protectedWrite(v3, segment0.data, segment0.pos, v4);
            segment0.pos += v4;
            v3 += (long)v4;
            buffer0.setSize$okio(buffer0.size() - ((long)v4));
            if(segment0.pos == segment0.limit) {
                buffer0.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
        }
    }
}

