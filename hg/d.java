package hg;

import J0.h;
import com.iloen.melon.mcache.util.CacheTrackingLog;
import h9.f;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d implements Closeable {
    public final File a;
    public final File b;
    public final File c;
    public final int d;
    public final long e;
    public final int f;
    public long g;
    public BufferedWriter h;
    public final LinkedHashMap i;
    public int j;
    public int k;
    public long l;
    public final ThreadPoolExecutor m;
    public final V2.d n;
    public static final Charset o;

    static {
        d.o = Charset.forName("UTF-8");
    }

    public d(File file0, long v) {
        this.g = 0L;
        this.i = new LinkedHashMap(0, 0.75f, true);
        this.k = -1;
        this.l = 0L;
        this.m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.n = new V2.d(this, 3);
        this.a = file0;
        this.d = 1;
        this.b = new File(file0, "journal");
        this.c = new File(file0, "journal.tmp");
        this.f = 2;
        this.e = v;
    }

    public final boolean A(String s) {
        synchronized(this) {
            if(this.h != null) {
                d.C(s);
                b b0 = (b)this.i.get(s);
                if(b0 != null && b0.d == null) {
                    for(int v1 = 0; v1 < this.f; ++v1) {
                        File file0 = b0.b(v1);
                        if(file0.exists() && !file0.delete()) {
                            throw new IOException("failed to delete " + file0);
                        }
                        this.g -= b0.b[v1];
                        b0.b[v1] = 0L;
                    }
                    ++this.j;
                    this.h.append("REMOVE " + s + '\n');
                    this.i.remove(s);
                    if(this.m()) {
                        this.m.submit(this.n);
                    }
                    return true;
                }
                return false;
            }
        }
        throw new IllegalStateException("cache is closed");
    }

    public final void B() {
        while(true) {
            long v = this.e;
            if(this.g <= v) {
                break;
            }
            Object object0 = this.i.entrySet().iterator().next();
            String s = (String)((Map.Entry)object0).getKey();
            if(this.A(s)) {
                CacheTrackingLog.i(("Cache deleted: " + s + "[cause: maximum cache size exceeded - maxSize: " + v + "]"));
            }
        }
    }

    public static void C(String s) {
        if(s.contains(" ") || s.contains("\n") || s.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + s + "\"");
        }
    }

    public static void c(d d0, h h0, boolean z) {
        synchronized(d0) {
            b b0 = (b)h0.c;
            if(b0.d == h0) {
                if(z && !b0.c) {
                    int v2 = 0;
                    while(v2 < d0.f) {
                        if(b0.b(v2).exists()) {
                            ++v2;
                            continue;
                        }
                        h0.f();
                        throw new IllegalStateException("edit didn\'t create file " + v2);
                    }
                }
                for(int v1 = 0; v1 < d0.f; ++v1) {
                    File file0 = b0.b(v1);
                    if(file0.exists()) {
                        long v3 = b0.b[v1];
                        long v4 = file0.length();
                        b0.b[v1] = v4;
                        d0.g = d0.g - v3 + v4;
                    }
                }
                ++d0.j;
                b0.d = null;
                if((b0.c | z) == 0) {
                    b0.c = true;
                    d0.h.write("DIRTY " + b0.a + b0.c() + '\n');
                }
                else {
                    b0.c = true;
                    d0.h.write((z ? "CLEAN" : "DIRTY") + ' ' + b0.a + b0.c() + '\n');
                }
                ++d0.l;
                d0.h.flush();
                if(d0.g <= d0.e && !d0.m()) {
                    return;
                }
                d0.m.submit(d0.n);
                return;
            }
        }
        throw new IllegalStateException();
    }

    @Override
    public final void close() {
        synchronized(this) {
            if(this.h == null) {
                return;
            }
            for(Object object0: new ArrayList(this.i.values())) {
                h h0 = ((b)object0).d;
                if(h0 != null) {
                    h0.f();
                }
            }
            this.B();
            this.h.close();
            this.h = null;
        }
    }

    public static Object[] f(int v, Object[] arr_object) {
        if(2 > v) {
            throw new IllegalArgumentException();
        }
        if(2 > arr_object.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] arr_object1 = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), v - 2);
        System.arraycopy(arr_object, 2, arr_object1, 0, Math.min(v - 2, arr_object.length - 2));
        return arr_object1;
    }

    public static void g(File file0) {
        File[] arr_file = file0.listFiles();
        if(arr_file == null) {
            throw new IllegalArgumentException("not a directory: " + file0);
        }
        for(int v = 0; v < arr_file.length; ++v) {
            File file1 = arr_file[v];
            if(file1.isDirectory()) {
                d.g(file1);
            }
            if(!file1.delete()) {
                throw new IOException("failed to delete file: " + file1);
            }
        }
    }

    public final h h(String s) {
        synchronized(this) {
            if(this.h != null) {
                d.C(s);
                b b0 = (b)this.i.get(s);
                if(b0 == null) {
                    b0 = new b(this, s);
                    this.i.put(s, b0);
                }
                else if(b0.d != null) {
                    return null;
                }
                h h0 = new h(this, b0);
                b0.d = h0;
                this.h.flush();
                return h0;
            }
        }
        throw new IllegalStateException("cache is closed");
    }

    public final c i(String s, boolean z) {
        synchronized(this) {
            if(this.h != null) {
                d.C(s);
                b b0 = (b)this.i.get(s);
                if(b0 == null) {
                    return null;
                }
                if(!b0.c) {
                    return null;
                }
                InputStream[] arr_inputStream = new InputStream[this.f];
                for(int v1 = 0; true; ++v1) {
                    try {
                        if(v1 >= this.f) {
                            break;
                        }
                        arr_inputStream[v1] = new FileInputStream(b0.b(v1));
                    }
                    catch(FileNotFoundException unused_ex) {
                        return null;
                    }
                }
                if(z) {
                    ++this.j;
                    this.h.append("READ " + s + '\n');
                }
                if(this.m()) {
                    this.m.submit(this.n);
                }
                return new c(arr_inputStream, 0);
            }
        }
        throw new IllegalStateException("cache is closed");
    }

    public final boolean m() {
        return this.j >= 2000 && this.j >= this.i.size();
    }

    public static d n(File file0, long v) {
        if(v <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        d d0 = new d(file0, v);
        File file1 = d0.b;
        if(file1.exists()) {
            try {
                d0.q();
                d0.o();
                d0.h = new BufferedWriter(new FileWriter(file1, true), 0x2000);
                return d0;
            }
            catch(IOException unused_ex) {
                CacheTrackingLog.i("Cache all deleted[cause: invalid journal file]");
                d0.close();
                d.g(d0.a);
            }
        }
        file0.mkdirs();
        d d1 = new d(file0, v);
        d1.s();
        return d1;
    }

    public final void o() {
        if(this.c.exists() && !this.c.delete()) {
            throw new IOException();
        }
        for(Object object0: this.i.values()) {
            b b0 = (b)object0;
            for(int v = 0; v < this.f; ++v) {
                this.g += b0.b[v];
            }
            if(b0.d != null) {
                b0.d = null;
            }
        }
    }

    public static String p(BufferedInputStream bufferedInputStream0) {
        StringBuilder stringBuilder0 = new StringBuilder(80);
        while(true) {
            int v = bufferedInputStream0.read();
            switch(v) {
                case -1: {
                    throw new EOFException();
                }
                case 10: {
                    int v1 = stringBuilder0.length();
                    if(v1 > 0 && stringBuilder0.charAt(v1 - 1) == 13) {
                        stringBuilder0.setLength(v1 - 1);
                    }
                    return stringBuilder0.toString();
                }
                default: {
                    stringBuilder0.append(((char)v));
                    break;
                }
            }
        }
    }

    public final void q() {
        BufferedInputStream bufferedInputStream0 = new BufferedInputStream(new FileInputStream(this.b), 0x2000);
        try {
            String s = d.p(bufferedInputStream0);
            String s1 = d.p(bufferedInputStream0);
            this.k = Integer.parseInt(s1);
            f.b("DiskLruCache", "readJournal() - savedJournalFileVersion: " + this.k);
            String s2 = d.p(bufferedInputStream0);
            String s3 = d.p(bufferedInputStream0);
            String s4 = d.p(bufferedInputStream0);
            if(!"libcore.io.DiskLruCache".equals(s) || !Integer.toString(this.d).equals(s2) || !Integer.toString(this.f).equals(s3) || !"".equals(s4)) {
                throw new IOException("unexpected journal header: [" + s + ", " + s1 + ", " + s3 + ", " + s4 + "]");
            }
            try {
                while(true) {
                    this.r(d.p(bufferedInputStream0));
                }
            }
            catch(EOFException unused_ex) {
            }
        }
        catch(Throwable throwable0) {
            goto label_18;
        }
        try {
            bufferedInputStream0.close();
            return;
        }
        catch(RuntimeException runtimeException0) {
            throw runtimeException0;
        }
        catch(Exception unused_ex) {
            return;
        }
        try {
        label_18:
            bufferedInputStream0.close();
            throw throwable0;
        }
        catch(RuntimeException runtimeException1) {
            throw runtimeException1;
        }
        catch(Exception unused_ex) {
            throw throwable0;
        }
    }

    public final void r(String s) {
        String[] arr_s = s.split(" ");
        if(arr_s.length < 2) {
            throw new IOException("unexpected journal line: " + s);
        }
        String s1 = arr_s[1];
        LinkedHashMap linkedHashMap0 = this.i;
        if(arr_s[0].equals("REMOVE") && arr_s.length == 2) {
            linkedHashMap0.remove(s1);
            CacheTrackingLog.i(("Cache deleted: " + s1 + "[cause: meta is \'REMOVE\' state]"));
            return;
        }
        b b0 = (b)linkedHashMap0.get(s1);
        if(b0 == null) {
            b0 = new b(this, s1);
            linkedHashMap0.put(s1, b0);
        }
        int v = this.f;
        if(arr_s[0].equals("CLEAN") && arr_s.length == v + 2) {
            b0.c = true;
            b0.d = null;
            b.a(b0, ((String[])d.f(arr_s.length, arr_s)));
            return;
        }
        if(arr_s[0].equals("DIRTY")) {
            if(arr_s.length == v + 2) {
                b0.c = true;
                b0.d = new h(this, b0);
                b.a(b0, ((String[])d.f(arr_s.length, arr_s)));
                return;
            }
            linkedHashMap0.remove(s1);
            return;
        }
        if(!arr_s[0].equals("READ") || arr_s.length != 2) {
            throw new IOException("unexpected journal line: " + s);
        }
    }

    public final void s() {
        synchronized(this) {
            BufferedWriter bufferedWriter0 = this.h;
            if(bufferedWriter0 != null) {
                bufferedWriter0.close();
            }
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(this.c), 0x2000);
            bufferedWriter1.write("libcore.io.DiskLruCache");
            bufferedWriter1.write("\n");
            bufferedWriter1.write("2");
            this.k = 2;
            bufferedWriter1.write("\n");
            bufferedWriter1.write(Integer.toString(this.d));
            bufferedWriter1.write("\n");
            bufferedWriter1.write(Integer.toString(this.f));
            bufferedWriter1.write("\n");
            bufferedWriter1.write("\n");
            for(Object object0: this.i.values()) {
                b b0 = (b)object0;
                if(b0.d == null) {
                    bufferedWriter1.write("CLEAN " + b0.a + b0.c() + '\n');
                }
                else {
                    if((b0.b.length <= 1 ? 0L : b0.b[1]) <= 0L) {
                        File file0 = b0.b(0);
                        File file1 = b0.b(1);
                        b.a(b0, new String[]{String.valueOf(file0.length()), String.valueOf(file1.length())});
                    }
                    bufferedWriter1.write("DIRTY " + b0.a + b0.c() + '\n');
                }
            }
            bufferedWriter1.close();
            this.c.renameTo(this.b);
            this.h = new BufferedWriter(new FileWriter(this.b, true), 0x2000);
        }
    }
}

