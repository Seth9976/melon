package io.netty.channel;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import k8.Y;

public class DefaultFileRegion extends AbstractReferenceCounted implements FileRegion {
    private final long count;
    private final File f;
    private FileChannel file;
    private static final InternalLogger logger;
    private final long position;
    private long transferred;

    static {
        DefaultFileRegion.logger = InternalLoggerFactory.getInstance(DefaultFileRegion.class);
    }

    public DefaultFileRegion(File file0, long v, long v1) {
        this.f = (File)ObjectUtil.checkNotNull(file0, "file");
        this.position = ObjectUtil.checkPositiveOrZero(v, "position");
        this.count = ObjectUtil.checkPositiveOrZero(v1, "count");
    }

    public DefaultFileRegion(FileChannel fileChannel0, long v, long v1) {
        this.file = (FileChannel)ObjectUtil.checkNotNull(fileChannel0, "fileChannel");
        this.position = ObjectUtil.checkPositiveOrZero(v, "position");
        this.count = ObjectUtil.checkPositiveOrZero(v1, "count");
        this.f = null;
    }

    @Override  // io.netty.channel.FileRegion
    public long count() {
        return this.count;
    }

    @Override  // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        FileChannel fileChannel0 = this.file;
        if(fileChannel0 == null) {
            return;
        }
        try {
            this.file = null;
            fileChannel0.close();
        }
        catch(IOException iOException0) {
            DefaultFileRegion.logger.warn("Failed to close a file.", iOException0);
        }
    }

    public boolean isOpen() {
        return this.file != null;
    }

    public void open() {
        if(!this.isOpen() && this.refCnt() > 0) {
            this.file = new RandomAccessFile(this.f, "r").getChannel();
        }
    }

    @Override  // io.netty.channel.FileRegion
    public long position() {
        return this.position;
    }

    @Override  // io.netty.channel.FileRegion
    public FileRegion retain() {
        super.retain();
        return this;
    }

    @Override  // io.netty.channel.FileRegion
    public FileRegion retain(int v) {
        super.retain(v);
        return this;
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.channel.FileRegion
    public FileRegion touch() [...] // Inlined contents

    @Override  // io.netty.channel.FileRegion
    public FileRegion touch(Object object0) [...] // Inlined contents

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this;
    }

    @Override  // io.netty.channel.FileRegion
    public long transferTo(WritableByteChannel writableByteChannel0, long v) {
        long v1 = this.count - v;
        int v2 = Long.compare(v1, 0L);
        if(v2 >= 0 && v >= 0L) {
            if(v2 == 0) {
                return 0L;
            }
            if(this.refCnt() == 0) {
                throw new IllegalReferenceCountException(0);
            }
            this.open();
            long v3 = this.file.transferTo(this.position + v, v1, writableByteChannel0);
            int v4 = Long.compare(v3, 0L);
            if(v4 > 0) {
                this.transferred += v3;
                return v3;
            }
            if(v4 == 0) {
                DefaultFileRegion.validate(this, v);
            }
            return v3;
        }
        StringBuilder stringBuilder0 = Y.o(v, "position out of range: ", " (expected: 0 - ");
        stringBuilder0.append(this.count - 1L);
        stringBuilder0.append(')');
        throw new IllegalArgumentException(stringBuilder0.toString());
    }

    @Override  // io.netty.channel.FileRegion
    @Deprecated
    public long transfered() {
        return this.transferred;
    }

    @Override  // io.netty.channel.FileRegion
    public long transferred() {
        return this.transferred;
    }

    public static void validate(DefaultFileRegion defaultFileRegion0, long v) {
        long v1 = defaultFileRegion0.file.size();
        if(defaultFileRegion0.position + (defaultFileRegion0.count - v) + v <= v1) {
            return;
        }
        StringBuilder stringBuilder0 = Y.o(v1, "Underlying file size ", " smaller then requested count ");
        stringBuilder0.append(defaultFileRegion0.count);
        throw new IOException(stringBuilder0.toString());
    }
}

