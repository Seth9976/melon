package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {
    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = 0xC3CAFB6C37664863L;

        public InvalidMarkException(String s) {
            super(s);
        }
    }

    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public RecyclableBufferedInputStream(InputStream inputStream0, ArrayPool arrayPool0) {
        this(inputStream0, arrayPool0, 0x10000);
    }

    public RecyclableBufferedInputStream(InputStream inputStream0, ArrayPool arrayPool0, int v) {
        super(inputStream0);
        this.markpos = -1;
        this.byteArrayPool = arrayPool0;
        this.buf = (byte[])arrayPool0.get(v, byte[].class);
    }

    @Override
    public int available() {
        synchronized(this) {
            InputStream inputStream0 = this.in;
            if(this.buf != null && inputStream0 != null) {
                int v1 = this.count - this.pos;
                int v2 = inputStream0.available();
                return v1 + v2;
            }
        }
        throw RecyclableBufferedInputStream.streamClosed();
    }

    @Override
    public void close() {
        if(this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
        InputStream inputStream0 = this.in;
        this.in = null;
        if(inputStream0 != null) {
            inputStream0.close();
        }
    }

    private int fillbuf(InputStream inputStream0, byte[] arr_b) {
        int v = this.markpos;
        if(v != -1) {
            int v1 = this.marklimit;
            if(this.pos - v < v1) {
                if(v == 0 && v1 > arr_b.length && this.count == arr_b.length) {
                    int v2 = arr_b.length * 2;
                    if(v2 <= v1) {
                        v1 = v2;
                    }
                    byte[] arr_b1 = (byte[])this.byteArrayPool.get(v1, byte[].class);
                    System.arraycopy(arr_b, 0, arr_b1, 0, arr_b.length);
                    this.buf = arr_b1;
                    this.byteArrayPool.put(arr_b);
                    arr_b = arr_b1;
                }
                else if(v > 0) {
                    System.arraycopy(arr_b, v, arr_b, 0, arr_b.length - v);
                }
                int v3 = this.pos - this.markpos;
                this.pos = v3;
                this.markpos = 0;
                this.count = 0;
                int v4 = inputStream0.read(arr_b, v3, arr_b.length - v3);
                this.count = v4 <= 0 ? this.pos : this.pos + v4;
                return v4;
            }
        }
        int v5 = inputStream0.read(arr_b);
        if(v5 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = v5;
        }
        return v5;
    }

    public void fixMarkLimit() {
        synchronized(this) {
            this.marklimit = this.buf.length;
        }
    }

    @Override
    public void mark(int v) {
        synchronized(this) {
            this.marklimit = Math.max(this.marklimit, v);
            this.markpos = this.pos;
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public int read() {
        synchronized(this) {
            byte[] arr_b = this.buf;
            InputStream inputStream0 = this.in;
            if(arr_b != null && inputStream0 != null) {
                if(this.pos >= this.count && this.fillbuf(inputStream0, arr_b) == -1) {
                    return -1;
                }
                if(arr_b != this.buf) {
                    arr_b = this.buf;
                    if(arr_b == null) {
                        throw RecyclableBufferedInputStream.streamClosed();
                    }
                }
                int v1 = this.pos;
                if(this.count - v1 > 0) {
                    this.pos = v1 + 1;
                    int v2 = arr_b[v1];
                    return v2 & 0xFF;
                }
                return -1;
            }
        }
        throw RecyclableBufferedInputStream.streamClosed();
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        int v8;
        int v6;
        synchronized(this) {
            byte[] arr_b1 = this.buf;
            if(arr_b1 != null) {
                if(v1 == 0) {
                    return 0;
                }
                InputStream inputStream0 = this.in;
                if(inputStream0 != null) {
                    int v3 = this.pos;
                    int v4 = this.count;
                    if(v3 < v4) {
                        int v5 = v4 - v3 < v1 ? v4 - v3 : v1;
                        System.arraycopy(arr_b1, v3, arr_b, v, v5);
                        this.pos += v5;
                        if(v5 != v1 && inputStream0.available() != 0) {
                            v += v5;
                            v6 = v1 - v5;
                            goto label_24;
                        }
                        return v5;
                    }
                    else {
                        v6 = v1;
                    }
                    while(true) {
                    label_24:
                        int v7 = -1;
                        if(this.markpos != -1 || v6 < arr_b1.length) {
                            if(this.fillbuf(inputStream0, arr_b1) == -1) {
                                if(v6 != v1) {
                                    v7 = v1 - v6;
                                }
                                return v7;
                            }
                            if(arr_b1 != this.buf) {
                                arr_b1 = this.buf;
                                if(arr_b1 == null) {
                                    throw RecyclableBufferedInputStream.streamClosed();
                                }
                            }
                            v8 = this.count - this.pos < v6 ? this.count - this.pos : v6;
                            System.arraycopy(arr_b1, this.pos, arr_b, v, v8);
                            this.pos += v8;
                        }
                        else {
                            v8 = inputStream0.read(arr_b, v, v6);
                            if(v8 == -1) {
                                if(v6 != v1) {
                                    v7 = v1 - v6;
                                }
                                return v7;
                            }
                        }
                        v6 -= v8;
                        if(v6 == 0) {
                            return v1;
                        }
                        if(inputStream0.available() == 0) {
                            return v1 - v6;
                        }
                        v += v8;
                    }
                }
                throw RecyclableBufferedInputStream.streamClosed();
            }
        }
        throw RecyclableBufferedInputStream.streamClosed();
    }

    public void release() {
        synchronized(this) {
            if(this.buf != null) {
                this.byteArrayPool.put(this.buf);
                this.buf = null;
            }
        }
    }

    @Override
    public void reset() {
        synchronized(this) {
            if(this.buf != null) {
                int v1 = this.markpos;
                if(-1 == v1) {
                    throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
                }
                this.pos = v1;
                return;
            }
        }
        throw new IOException("Stream is closed");
    }

    @Override
    public long skip(long v) {
        synchronized(this) {
            if(Long.compare(v, 1L) < 0) {
                return 0L;
            }
            byte[] arr_b = this.buf;
            if(arr_b != null) {
                InputStream inputStream0 = this.in;
                if(inputStream0 == null) {
                    throw RecyclableBufferedInputStream.streamClosed();
                }
                int v2 = this.count;
                int v3 = this.pos;
                if(((long)(v2 - v3)) >= v) {
                    this.pos = (int)(((long)v3) + v);
                    return v;
                }
                long v4 = ((long)v2) - ((long)v3);
                this.pos = v2;
                if(this.markpos != -1 && v <= ((long)this.marklimit)) {
                    if(this.fillbuf(inputStream0, arr_b) == -1) {
                        return v4;
                    }
                    int v5 = this.count;
                    int v6 = this.pos;
                    if(((long)(v5 - v6)) >= v - v4) {
                        this.pos = (int)(((long)v6) + v - v4);
                        return v;
                    }
                    this.pos = v5;
                    return v4 + ((long)v5) - ((long)v6);
                }
                long v7 = inputStream0.skip(v - v4);
                if(v7 > 0L) {
                    this.markpos = -1;
                }
                return v4 + v7;
            }
        }
        throw RecyclableBufferedInputStream.streamClosed();
    }

    private static IOException streamClosed() {
        throw new IOException("BufferedInputStream is closed");
    }
}

