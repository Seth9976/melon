package g7;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class l implements Closeable {
    public final RandomAccessFile a;
    public int b;
    public int c;
    public i d;
    public i e;
    public final byte[] f;
    public static final Logger g;

    static {
        l.g = Logger.getLogger("g7.l");
    }

    public l(File file0) {
        byte[] arr_b = new byte[16];
        this.f = arr_b;
        if(!file0.exists()) {
            File file1 = new File(file0.getPath() + ".tmp");
            try(RandomAccessFile randomAccessFile0 = new RandomAccessFile(file1, "rwd")) {
                randomAccessFile0.setLength(0x1000L);
                randomAccessFile0.seek(0L);
                byte[] arr_b1 = new byte[16];
                int v = 0;
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= 4) {
                        break;
                    }
                    l.s(arr_b1, v, new int[]{0x1000, 0, 0, 0}[v1]);
                    v += 4;
                }
                randomAccessFile0.write(arr_b1);
            }
            if(!file1.renameTo(file0)) {
                throw new IOException("Rename failed!");
            }
        }
        RandomAccessFile randomAccessFile1 = new RandomAccessFile(file0, "rwd");
        this.a = randomAccessFile1;
        randomAccessFile1.seek(0L);
        randomAccessFile1.readFully(arr_b);
        int v2 = l.j(0, arr_b);
        this.b = v2;
        if(((long)v2) > randomAccessFile1.length()) {
            throw new IOException("File is truncated. Expected length: " + this.b + ", Actual length: " + randomAccessFile1.length());
        }
        this.c = l.j(4, arr_b);
        int v3 = l.j(8, arr_b);
        int v4 = l.j(12, arr_b);
        this.d = this.i(v3);
        this.e = this.i(v4);
    }

    public final void c(byte[] arr_b) {
        synchronized(this) {
            if(arr_b.length >= 0 && arr_b.length <= arr_b.length) {
                this.f(arr_b.length);
                boolean z = this.h();
                int v1 = z ? 16 : this.q(this.e.a + 4 + this.e.b);
                i i0 = new i(v1, arr_b.length);
                l.s(this.f, 0, arr_b.length);
                this.o(this.f, v1, 4);
                this.o(arr_b, v1 + 4, arr_b.length);
                this.r(this.b, this.c + 1, (z ? v1 : this.d.a), v1);
                this.e = i0;
                ++this.c;
                if(z) {
                    this.d = i0;
                }
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public final void close() {
        synchronized(this) {
            this.a.close();
        }
    }

    public final void f(int v) {
        int v1 = this.b - this.p();
        if(v1 >= v + 4) {
            return;
        }
        int v2 = this.b;
        do {
            v1 += v2;
            v2 <<= 1;
        }
        while(v1 < v + 4);
        RandomAccessFile randomAccessFile0 = this.a;
        randomAccessFile0.setLength(((long)v2));
        randomAccessFile0.getChannel().force(true);
        int v3 = this.q(this.e.a + 4 + this.e.b);
        if(v3 < this.d.a) {
            FileChannel fileChannel0 = randomAccessFile0.getChannel();
            fileChannel0.position(((long)this.b));
            if(fileChannel0.transferTo(16L, ((long)(v3 - 4)), fileChannel0) != ((long)(v3 - 4))) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int v4 = this.e.a;
        int v5 = this.d.a;
        if(v4 < v5) {
            int v6 = this.b + v4 - 16;
            this.r(v2, this.c, v5, v6);
            this.e = new i(v6, this.e.b);
        }
        else {
            this.r(v2, this.c, v5, v4);
        }
        this.b = v2;
    }

    public final void g(k k0) {
        synchronized(this) {
            int v1 = this.d.a;
            for(int v2 = 0; v2 < this.c; ++v2) {
                i i0 = this.i(v1);
                k0.a(new j(this, i0), i0.b);
                v1 = this.q(i0.a + 4 + i0.b);
            }
        }
    }

    public final boolean h() {
        synchronized(this) {
        }
        return this.c == 0;
    }

    public final i i(int v) {
        if(v == 0) {
            return i.c;
        }
        this.a.seek(((long)v));
        return new i(v, this.a.readInt());
    }

    public static int j(int v, byte[] arr_b) {
        return ((arr_b[v] & 0xFF) << 24) + ((arr_b[v + 1] & 0xFF) << 16) + ((arr_b[v + 2] & 0xFF) << 8) + (arr_b[v + 3] & 0xFF);
    }

    public final void m() {
        synchronized(this) {
            if(!this.h()) {
                if(this.c == 1) {
                    synchronized(this) {
                        this.r(0x1000, 0, 0, 0);
                        this.c = 0;
                        this.d = i.c;
                        this.e = i.c;
                        if(this.b > 0x1000) {
                            this.a.setLength(0x1000L);
                            this.a.getChannel().force(true);
                        }
                        this.b = 0x1000;
                    }
                }
                else {
                    int v1 = this.q(this.d.a + 4 + this.d.b);
                    this.n(v1, 0, 4, this.f);
                    int v2 = l.j(0, this.f);
                    this.r(this.b, this.c - 1, v1, this.e.a);
                    --this.c;
                    this.d = new i(v1, v2);
                }
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public final void n(int v, int v1, int v2, byte[] arr_b) {
        int v3 = this.q(v);
        int v4 = this.b;
        RandomAccessFile randomAccessFile0 = this.a;
        if(v3 + v2 <= v4) {
            randomAccessFile0.seek(((long)v3));
            randomAccessFile0.readFully(arr_b, v1, v2);
            return;
        }
        int v5 = v4 - v3;
        randomAccessFile0.seek(((long)v3));
        randomAccessFile0.readFully(arr_b, v1, v5);
        randomAccessFile0.seek(16L);
        randomAccessFile0.readFully(arr_b, v1 + v5, v2 - v5);
    }

    public final void o(byte[] arr_b, int v, int v1) {
        int v2 = this.q(v);
        int v3 = this.b;
        RandomAccessFile randomAccessFile0 = this.a;
        if(v2 + v1 <= v3) {
            randomAccessFile0.seek(((long)v2));
            randomAccessFile0.write(arr_b, 0, v1);
            return;
        }
        int v4 = v3 - v2;
        randomAccessFile0.seek(((long)v2));
        randomAccessFile0.write(arr_b, 0, v4);
        randomAccessFile0.seek(16L);
        randomAccessFile0.write(arr_b, v4, v1 - v4);
    }

    public final int p() {
        if(this.c == 0) {
            return 16;
        }
        int v = this.e.a;
        int v1 = this.d.a;
        return v < v1 ? v + 4 + this.e.b + this.b - v1 : v - v1 + 4 + this.e.b + 16;
    }

    public final int q(int v) {
        return v >= this.b ? v + 16 - this.b : v;
    }

    public final void r(int v, int v1, int v2, int v3) {
        byte[] arr_b;
        int[] arr_v = {v, v1, v2, v3};
        int v5 = 0;
        for(int v4 = 0; true; ++v4) {
            arr_b = this.f;
            if(v4 >= 4) {
                break;
            }
            l.s(arr_b, v5, arr_v[v4]);
            v5 += 4;
        }
        this.a.seek(0L);
        this.a.write(arr_b);
    }

    public static void s(byte[] arr_b, int v, int v1) {
        arr_b[v] = (byte)(v1 >> 24);
        arr_b[v + 1] = (byte)(v1 >> 16);
        arr_b[v + 2] = (byte)(v1 >> 8);
        arr_b[v + 3] = (byte)v1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("l");
        stringBuilder0.append("[fileLength=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", size=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", first=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", last=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", element lengths=[");
        try {
            this.g(new Gf.l(stringBuilder0));
        }
        catch(IOException iOException0) {
            l.g.log(Level.WARNING, "read error", iOException0);
        }
        stringBuilder0.append("]]");
        return stringBuilder0.toString();
    }
}

