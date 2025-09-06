package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil {
    static class ByteBufferStream extends InputStream {
        private static final int UNSET = -1;
        private final ByteBuffer byteBuffer;
        private int markPos;

        public ByteBufferStream(ByteBuffer byteBuffer0) {
            this.markPos = -1;
            this.byteBuffer = byteBuffer0;
        }

        @Override
        public int available() {
            return this.byteBuffer.remaining();
        }

        @Override
        public void mark(int v) {
            synchronized(this) {
                this.markPos = this.byteBuffer.position();
            }
        }

        @Override
        public boolean markSupported() {
            return true;
        }

        @Override
        public int read() {
            return this.byteBuffer.hasRemaining() ? this.byteBuffer.get() & 0xFF : -1;
        }

        @Override
        public int read(byte[] arr_b, int v, int v1) {
            if(!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            int v2 = Math.min(v1, this.available());
            this.byteBuffer.get(arr_b, v, v2);
            return v2;
        }

        @Override
        public void reset() {
            synchronized(this) {
                int v1 = this.markPos;
                if(v1 != -1) {
                    this.byteBuffer.position(v1);
                    return;
                }
            }
            throw new IOException("Cannot reset to unset mark position");
        }

        @Override
        public long skip(long v) {
            if(!this.byteBuffer.hasRemaining()) {
                return -1L;
            }
            long v1 = Math.min(v, this.available());
            this.byteBuffer.position(((int)(((long)this.byteBuffer.position()) + v1)));
            return v1;
        }
    }

    static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        public SafeArray(byte[] arr_b, int v, int v1) {
            this.data = arr_b;
            this.offset = v;
            this.limit = v1;
        }
    }

    private static final AtomicReference BUFFER_REF = null;
    private static final int BUFFER_SIZE = 0x4000;

    static {
        ByteBufferUtil.BUFFER_REF = new AtomicReference();
    }

    public static ByteBuffer fromFile(File file0) {
        ByteBuffer byteBuffer0;
        FileChannel fileChannel0;
        Throwable throwable1;
        RandomAccessFile randomAccessFile0;
        long v;
        AbstractInterruptibleChannel abstractInterruptibleChannel0 = null;
        try {
            v = file0.length();
            if(v > 0x7FFFFFFFL) {
                throw new IOException("File too large to map into memory");
            }
            if(v == 0L) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile0 = new RandomAccessFile(file0, "r");
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            randomAccessFile0 = null;
            goto label_22;
        }
        try {
            fileChannel0 = randomAccessFile0.getChannel();
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            goto label_22;
        }
        try {
            byteBuffer0 = fileChannel0.map(FileChannel.MapMode.READ_ONLY, 0L, v).load();
            goto label_27;
        }
        catch(Throwable throwable3) {
            throwable1 = throwable3;
            abstractInterruptibleChannel0 = fileChannel0;
        }
    label_22:
        if(abstractInterruptibleChannel0 != null) {
            try {
                abstractInterruptibleChannel0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        if(randomAccessFile0 != null) {
            try {
                randomAccessFile0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable1;
        try {
        label_27:
            fileChannel0.close();
        }
        catch(IOException unused_ex) {
        }
        try {
            randomAccessFile0.close();
        }
        catch(IOException unused_ex) {
        }
        return byteBuffer0;
    }

    public static ByteBuffer fromStream(InputStream inputStream0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x4000);
        byte[] arr_b = (byte[])ByteBufferUtil.BUFFER_REF.getAndSet(null);
        if(arr_b == null) {
            arr_b = new byte[0x4000];
        }
        int v;
        while((v = inputStream0.read(arr_b)) >= 0) {
            byteArrayOutputStream0.write(arr_b, 0, v);
        }
        ByteBufferUtil.BUFFER_REF.set(arr_b);
        byte[] arr_b1 = byteArrayOutputStream0.toByteArray();
        return ByteBufferUtil.rewind(ByteBuffer.allocateDirect(arr_b1.length).put(arr_b1));
    }

    // 去混淆评级： 低(20)
    private static SafeArray getSafeArray(ByteBuffer byteBuffer0) {
        return byteBuffer0.isReadOnly() || !byteBuffer0.hasArray() ? null : new SafeArray(byteBuffer0.array(), byteBuffer0.arrayOffset(), byteBuffer0.limit());
    }

    public static ByteBuffer rewind(ByteBuffer byteBuffer0) {
        return (ByteBuffer)byteBuffer0.position(0);
    }

    public static byte[] toBytes(ByteBuffer byteBuffer0) {
        SafeArray byteBufferUtil$SafeArray0 = ByteBufferUtil.getSafeArray(byteBuffer0);
        if(byteBufferUtil$SafeArray0 != null && byteBufferUtil$SafeArray0.offset == 0 && byteBufferUtil$SafeArray0.limit == byteBufferUtil$SafeArray0.data.length) {
            return byteBuffer0.array();
        }
        ByteBuffer byteBuffer1 = byteBuffer0.asReadOnlyBuffer();
        byte[] arr_b = new byte[byteBuffer1.limit()];
        ByteBufferUtil.rewind(byteBuffer1);
        byteBuffer1.get(arr_b);
        return arr_b;
    }

    public static void toFile(ByteBuffer byteBuffer0, File file0) {
        RandomAccessFile randomAccessFile0;
        ByteBufferUtil.rewind(byteBuffer0);
        FileChannel fileChannel0 = null;
        try {
            randomAccessFile0 = null;
            randomAccessFile0 = new RandomAccessFile(file0, "rw");
            fileChannel0 = randomAccessFile0.getChannel();
            fileChannel0.write(byteBuffer0);
            fileChannel0.force(false);
            fileChannel0.close();
            randomAccessFile0.close();
        }
        catch(Throwable throwable0) {
            if(fileChannel0 != null) {
                try {
                    fileChannel0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            if(randomAccessFile0 != null) {
                try {
                    randomAccessFile0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
        }
        try {
            fileChannel0.close();
        }
        catch(IOException unused_ex) {
        }
        try {
            randomAccessFile0.close();
        }
        catch(IOException unused_ex) {
        }
    }

    public static InputStream toStream(ByteBuffer byteBuffer0) {
        return new ByteBufferStream(byteBuffer0);
    }

    public static void toStream(ByteBuffer byteBuffer0, OutputStream outputStream0) {
        SafeArray byteBufferUtil$SafeArray0 = ByteBufferUtil.getSafeArray(byteBuffer0);
        if(byteBufferUtil$SafeArray0 != null) {
            outputStream0.write(byteBufferUtil$SafeArray0.data, byteBufferUtil$SafeArray0.offset, byteBufferUtil$SafeArray0.limit + byteBufferUtil$SafeArray0.offset);
            return;
        }
        byte[] arr_b = (byte[])ByteBufferUtil.BUFFER_REF.getAndSet(null);
        if(arr_b == null) {
            arr_b = new byte[0x4000];
        }
        while(byteBuffer0.remaining() > 0) {
            int v = Math.min(byteBuffer0.remaining(), arr_b.length);
            byteBuffer0.get(arr_b, 0, v);
            outputStream0.write(arr_b, 0, v);
        }
        ByteBufferUtil.BUFFER_REF.set(arr_b);
    }
}

