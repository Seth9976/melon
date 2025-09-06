package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 E2\u00020\u0001:\u0002EFB5\b\u0002\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\u0006\u00A2\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\t\u0010\u0016J\u000F\u0010\u0017\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR$\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0005\u0010\u001E\u001A\u0004\b\u001F\u0010\u0018\"\u0004\b \u0010!R\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0007\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010\u0014R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010&R\u0017\u0010\n\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\n\u0010\"\u001A\u0004\b\'\u0010$R$\u0010)\u001A\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0017\u00100\u001A\u00020/8\u0006\u00A2\u0006\f\n\u0004\b0\u00101\u001A\u0004\b2\u00103R\"\u00105\u001A\u0002048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b5\u00106\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010;\u001A\u00020/8\u0006\u00A2\u0006\f\n\u0004\b;\u00101\u001A\u0004\b<\u00103R\"\u0010>\u001A\u00020=8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010?\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010D\u001A\u0002048F\u00A2\u0006\u0006\u001A\u0004\bD\u00108\u00A8\u0006G"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "Ljava/io/RandomAccessFile;", "file", "Lokio/Source;", "upstream", "", "upstreamPos", "Lokio/ByteString;", "metadata", "bufferMaxSize", "<init>", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "prefix", "upstreamSize", "metadataSize", "Lie/H;", "writeHeader", "(Lokio/ByteString;JJ)V", "writeMetadata", "(J)V", "commit", "()Lokio/ByteString;", "newSource", "()Lokio/Source;", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "Lokio/Source;", "getUpstream", "setUpstream", "(Lokio/Source;)V", "J", "getUpstreamPos", "()J", "setUpstreamPos", "Lokio/ByteString;", "getBufferMaxSize", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "Lokio/Buffer;", "upstreamBuffer", "Lokio/Buffer;", "getUpstreamBuffer", "()Lokio/Buffer;", "", "complete", "Z", "getComplete", "()Z", "setComplete", "(Z)V", "buffer", "getBuffer", "", "sourceCount", "I", "getSourceCount", "()I", "setSourceCount", "(I)V", "isClosed", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Relay {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0004J\u000E\u0010\u0013\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000ER\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Relay edit(@NotNull File file0, @NotNull Source source0, @NotNull ByteString byteString0, long v) {
            q.g(file0, "file");
            q.g(source0, "upstream");
            q.g(byteString0, "metadata");
            RandomAccessFile randomAccessFile0 = new RandomAccessFile(file0, "rw");
            Relay relay0 = new Relay(randomAccessFile0, source0, 0L, byteString0, v, null);
            randomAccessFile0.setLength(0L);
            relay0.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay0;
        }

        @NotNull
        public final Relay read(@NotNull File file0) {
            q.g(file0, "file");
            RandomAccessFile randomAccessFile0 = new RandomAccessFile(file0, "rw");
            FileChannel fileChannel0 = randomAccessFile0.getChannel();
            q.f(fileChannel0, "randomAccessFile.channel");
            FileOperator fileOperator0 = new FileOperator(fileChannel0);
            Buffer buffer0 = new Buffer();
            fileOperator0.read(0L, buffer0, 0x20L);
            if(!q.b(buffer0.readByteString(((long)Relay.PREFIX_CLEAN.size())), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long v = buffer0.readLong();
            long v1 = buffer0.readLong();
            Buffer buffer1 = new Buffer();
            fileOperator0.read(v + 0x20L, buffer1, v1);
            return new Relay(randomAccessFile0, null, v, buffer1.readByteString(), 0L, null);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\u0010R\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lie/H;", "close", "()V", "Lokio/Timeout;", "Lokhttp3/internal/cache2/FileOperator;", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class RelaySource implements Source {
        @Nullable
        private FileOperator fileOperator;
        private long sourcePos;
        @NotNull
        private final Timeout timeout;

        public RelaySource() {
            this.timeout = new Timeout();
            RandomAccessFile randomAccessFile0 = relay0.getFile();
            q.d(randomAccessFile0);
            FileChannel fileChannel0 = randomAccessFile0.getChannel();
            q.f(fileChannel0, "file!!.channel");
            this.fileOperator = new FileOperator(fileChannel0);
        }

        @Override  // okio.Source
        public void close() {
            if(this.fileOperator != null) {
                RandomAccessFile randomAccessFile0 = null;
                this.fileOperator = null;
                Relay relay0 = Relay.this;
                synchronized(relay0) {
                    relay0.setSourceCount(relay0.getSourceCount() - 1);
                    if(relay0.getSourceCount() == 0) {
                        relay0.setFile(null);
                        randomAccessFile0 = relay0.getFile();
                    }
                }
                if(randomAccessFile0 != null) {
                    Util.closeQuietly(randomAccessFile0);
                }
            }
        }

        @Override  // okio.Source
        public long read(@NotNull Buffer buffer0, long v) {
            int v3;
            long v2;
            q.g(buffer0, "sink");
            if(this.fileOperator != null) {
                Relay relay0 = Relay.this;
                __monitor_enter(relay0);
                while(true) {
                    try {
                    label_4:
                        if(Long.compare(this.sourcePos, relay0.getUpstreamPos()) != 0) {
                            long v1 = relay0.getUpstreamPos() - relay0.getBuffer().size();
                            if(this.sourcePos >= v1) {
                                v2 = Math.min(v, relay0.getUpstreamPos() - this.sourcePos);
                                relay0.getBuffer().copyTo(buffer0, this.sourcePos - v1, v2);
                                this.sourcePos += v2;
                                goto label_10;
                            }
                            v3 = 2;
                            break;
                        }
                        goto label_14;
                    }
                    catch(Throwable throwable0) {
                        __monitor_exit(relay0);
                        throw throwable0;
                    }
                label_10:
                    __monitor_exit(relay0);
                    return v2;
                    try {
                        v3 = 2;
                        break;
                    }
                    catch(Throwable throwable0) {
                        __monitor_exit(relay0);
                        throw throwable0;
                    }
                label_14:
                    if(relay0.getComplete()) {
                        __monitor_exit(relay0);
                        return -1L;
                    }
                    try {
                        if(relay0.getUpstreamReader() != null) {
                            this.timeout.waitUntilNotified(relay0);
                            goto label_4;
                        }
                        relay0.setUpstreamReader(Thread.currentThread());
                        v3 = 1;
                        break;
                    }
                    catch(Throwable throwable0) {
                    }
                    __monitor_exit(relay0);
                    throw throwable0;
                }
                __monitor_exit(relay0);
                if(v3 == 2) {
                    long v4 = Math.min(v, Relay.this.getUpstreamPos() - this.sourcePos);
                    FileOperator fileOperator0 = this.fileOperator;
                    q.d(fileOperator0);
                    fileOperator0.read(this.sourcePos + 0x20L, buffer0, v4);
                    this.sourcePos += v4;
                    return v4;
                }
                try {
                    Source source0 = Relay.this.getUpstream();
                    q.d(source0);
                    long v6 = source0.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if(v6 == -1L) {
                        Relay.this.commit(Relay.this.getUpstreamPos());
                        return -1L;
                    }
                    long v8 = Math.min(v6, v);
                    Relay.this.getUpstreamBuffer().copyTo(buffer0, 0L, v8);
                    this.sourcePos += v8;
                    FileOperator fileOperator1 = this.fileOperator;
                    q.d(fileOperator1);
                    Buffer buffer1 = Relay.this.getUpstreamBuffer().clone();
                    fileOperator1.write(Relay.this.getUpstreamPos() + 0x20L, buffer1, v6);
                    Relay relay1 = Relay.this;
                    synchronized(relay1) {
                        relay1.getBuffer().write(relay1.getUpstreamBuffer(), v6);
                        if(relay1.getBuffer().size() > relay1.getBufferMaxSize()) {
                            relay1.getBuffer().skip(relay1.getBuffer().size() - relay1.getBufferMaxSize());
                        }
                        relay1.setUpstreamPos(relay1.getUpstreamPos() + v6);
                        return v8;
                    }
                }
                finally {
                    synchronized(Relay.this) {
                        Relay.this.setUpstreamReader(null);
                        Relay.this.notifyAll();
                    }
                }
            }
            throw new IllegalStateException("Check failed.");
        }

        @Override  // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final long FILE_HEADER_SIZE = 0x20L;
    @NotNull
    public static final ByteString PREFIX_CLEAN = null;
    @NotNull
    public static final ByteString PREFIX_DIRTY = null;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    @Nullable
    private RandomAccessFile file;
    @NotNull
    private final ByteString metadata;
    private int sourceCount;
    @Nullable
    private Source upstream;
    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    @Nullable
    private Thread upstreamReader;

    static {
        Relay.Companion = new Companion(null);
        Relay.PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
        Relay.PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile0, Source source0, long v, ByteString byteString0, long v1) {
        this.file = randomAccessFile0;
        this.upstream = source0;
        this.upstreamPos = v;
        this.metadata = byteString0;
        this.bufferMaxSize = v1;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    public Relay(RandomAccessFile randomAccessFile0, Source source0, long v, ByteString byteString0, long v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(randomAccessFile0, source0, v, byteString0, v1);
    }

    public final void commit(long v) {
        this.writeMetadata(v);
        RandomAccessFile randomAccessFile0 = this.file;
        q.d(randomAccessFile0);
        randomAccessFile0.getChannel().force(false);
        this.writeHeader(Relay.PREFIX_CLEAN, v, ((long)this.metadata.size()));
        RandomAccessFile randomAccessFile1 = this.file;
        q.d(randomAccessFile1);
        randomAccessFile1.getChannel().force(false);
        synchronized(this) {
            this.complete = true;
        }
        Source source0 = this.upstream;
        if(source0 != null) {
            Util.closeQuietly(source0);
        }
        this.upstream = null;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    @NotNull
    public final ByteString metadata() {
        return this.metadata;
    }

    @Nullable
    public final Source newSource() {
        synchronized(this) {
            if(this.file == null) {
                return null;
            }
            ++this.sourceCount;
        }
        return new RelaySource(this);
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile0) {
        this.file = randomAccessFile0;
    }

    public final void setSourceCount(int v) {
        this.sourceCount = v;
    }

    public final void setUpstream(@Nullable Source source0) {
        this.upstream = source0;
    }

    public final void setUpstreamPos(long v) {
        this.upstreamPos = v;
    }

    public final void setUpstreamReader(@Nullable Thread thread0) {
        this.upstreamReader = thread0;
    }

    private final void writeHeader(ByteString byteString0, long v, long v1) {
        Buffer buffer0 = new Buffer();
        buffer0.write(byteString0);
        buffer0.writeLong(v);
        buffer0.writeLong(v1);
        if(buffer0.size() != 0x20L) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        RandomAccessFile randomAccessFile0 = this.file;
        q.d(randomAccessFile0);
        FileChannel fileChannel0 = randomAccessFile0.getChannel();
        q.f(fileChannel0, "file!!.channel");
        new FileOperator(fileChannel0).write(0L, buffer0, 0x20L);
    }

    private final void writeMetadata(long v) {
        Buffer buffer0 = new Buffer();
        buffer0.write(this.metadata);
        RandomAccessFile randomAccessFile0 = this.file;
        q.d(randomAccessFile0);
        FileChannel fileChannel0 = randomAccessFile0.getChannel();
        q.f(fileChannel0, "file!!.channel");
        new FileOperator(fileChannel0).write(v + 0x20L, buffer0, ((long)this.metadata.size()));
    }
}

