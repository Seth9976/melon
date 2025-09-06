package l5;

import A3.c;
import Tf.n;
import Tf.o;
import Tf.v;
import e2.a;
import hd.i;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

public final class f implements Closeable, Flushable {
    public final Path a;
    public final long b;
    public final Path c;
    public final Path d;
    public final Path e;
    public final LinkedHashMap f;
    public final CoroutineScope g;
    public long h;
    public int i;
    public BufferedSink j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final d r;
    public static final n w;

    static {
        f.w = new n("[a-z0-9_-]{1,120}");
    }

    public f(long v, CoroutineDispatcher coroutineDispatcher0, FileSystem fileSystem0, Path path0) {
        this.a = path0;
        this.b = v;
        if(v <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = path0.resolve("journal");
        this.d = path0.resolve("journal.tmp");
        this.e = path0.resolve("journal.bkp");
        this.f = new LinkedHashMap(0, 0.75f, true);
        this.g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(coroutineDispatcher0.limitedParallelism(1)));
        this.r = new d(fileSystem0);  // 初始化器: Lokio/ForwardingFileSystem;-><init>(Lokio/FileSystem;)V
    }

    public final void A() {
        while(this.h > this.b) {
            Iterator iterator0 = this.f.values().iterator();
        label_2:
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                b b0 = (b)object0;
                if(!b0.f) {
                    this.s(b0);
                    continue;
                }
                goto label_2;
            }
            return;
        }
        this.n = false;
    }

    public static void B(String s) {
        if(!f.w.b(s)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + s + '\"').toString());
        }
    }

    public final void C() {
        Throwable throwable2;
        synchronized(this) {
            BufferedSink bufferedSink0 = this.j;
            if(bufferedSink0 != null) {
                bufferedSink0.close();
            }
            BufferedSink bufferedSink1 = Okio.buffer(this.r.sink(this.d, false));
            try {
                bufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                bufferedSink1.writeUtf8("1").writeByte(10);
                bufferedSink1.writeDecimalLong(1L).writeByte(10);
                bufferedSink1.writeDecimalLong(2L).writeByte(10);
                bufferedSink1.writeByte(10);
                Iterator iterator0 = this.f.values().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        goto label_41;
                    }
                    Object object0 = iterator0.next();
                    b b0 = (b)object0;
                    if(b0.g == null) {
                        bufferedSink1.writeUtf8("CLEAN");
                        bufferedSink1.writeByte(0x20);
                        bufferedSink1.writeUtf8(b0.a);
                        long[] arr_v = b0.b;
                        for(int v1 = 0; v1 < arr_v.length; ++v1) {
                            long v2 = arr_v[v1];
                            bufferedSink1.writeByte(0x20).writeDecimalLong(v2);
                        }
                        bufferedSink1.writeByte(10);
                        continue;
                    }
                    bufferedSink1.writeUtf8("DIRTY");
                    bufferedSink1.writeByte(0x20);
                    bufferedSink1.writeUtf8(b0.a);
                    bufferedSink1.writeByte(10);
                    continue;
                label_34:
                    if(bufferedSink1 != null) {
                        break;
                    }
                    throwable2 = throwable0;
                    goto label_45;
                }
            }
            catch(Throwable throwable0) {
                goto label_34;
            }
            try {
                bufferedSink1.close();
            }
            catch(Throwable throwable1) {
                a.q(throwable0, throwable1);
            }
            throwable2 = throwable0;
            goto label_45;
            try {
            label_41:
                bufferedSink1.close();
                throwable2 = null;
            }
            catch(Throwable throwable2) {
            }
        label_45:
            if(throwable2 == null) {
                if(this.r.exists(this.c)) {
                    this.r.atomicMove(this.c, this.e);
                    this.r.atomicMove(this.d, this.c);
                    this.r.delete(this.e);
                }
                else {
                    this.r.atomicMove(this.d, this.c);
                }
                this.j = Okio.buffer(new g(this.r.appendingSink(this.c), new i(this, 14)));
                this.i = 0;
                this.k = false;
                this.o = false;
                return;
            }
        }
        throw throwable2;
    }

    public static final void c(f f0, c c0, boolean z) {
        synchronized(f0) {
            b b0 = (b)c0.b;
            if(q.b(b0.g, c0)) {
                if(!z || b0.f) {
                    for(int v5 = 0; v5 < 2; ++v5) {
                        Path path4 = (Path)b0.d.get(v5);
                        f0.r.delete(path4);
                    }
                }
                else {
                    for(int v1 = 0; v1 < 2; ++v1) {
                        if(((boolean[])c0.c)[v1]) {
                            Path path0 = (Path)b0.d.get(v1);
                            if(!f0.r.exists(path0)) {
                                c0.c(false);
                                return;
                            }
                        }
                    }
                    for(int v2 = 0; v2 < 2; ++v2) {
                        Path path1 = (Path)b0.d.get(v2);
                        Path path2 = (Path)b0.c.get(v2);
                        if(f0.r.exists(path1)) {
                            f0.r.atomicMove(path1, path2);
                        }
                        else {
                            d d0 = f0.r;
                            Path path3 = (Path)b0.c.get(v2);
                            if(!d0.exists(path3)) {
                                x5.g.a(d0.sink(path3));
                            }
                        }
                        long v3 = b0.b[v2];
                        Long long0 = f0.r.metadata(path2).getSize();
                        long v4 = long0 == null ? 0L : ((long)long0);
                        b0.b[v2] = v4;
                        f0.h = f0.h - v3 + v4;
                    }
                }
                b0.g = null;
                if(b0.f) {
                    f0.s(b0);
                    return;
                }
                ++f0.i;
                BufferedSink bufferedSink0 = f0.j;
                q.d(bufferedSink0);
                if(z || b0.e) {
                    b0.e = true;
                    bufferedSink0.writeUtf8("CLEAN");
                    bufferedSink0.writeByte(0x20);
                    bufferedSink0.writeUtf8(b0.a);
                    long[] arr_v = b0.b;
                    for(int v6 = 0; v6 < arr_v.length; ++v6) {
                        long v7 = arr_v[v6];
                        bufferedSink0.writeByte(0x20).writeDecimalLong(v7);
                    }
                }
                else {
                    f0.f.remove(b0.a);
                    bufferedSink0.writeUtf8("REMOVE");
                    bufferedSink0.writeByte(0x20);
                    bufferedSink0.writeUtf8(b0.a);
                }
                bufferedSink0.writeByte(10);
                bufferedSink0.flush();
                if(f0.h > f0.b || f0.i >= 2000) {
                    f0.o();
                }
                return;
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override
    public final void close() {
        synchronized(this) {
            if(this.l && !this.m) {
                b[] arr_b = (b[])this.f.values().toArray(new b[0]);
                for(int v1 = 0; v1 < arr_b.length; ++v1) {
                    c c0 = arr_b[v1].g;
                    if(c0 != null) {
                        b b0 = (b)c0.b;
                        if(q.b(b0.g, c0)) {
                            b0.f = true;
                        }
                    }
                }
                this.A();
                CoroutineScopeKt.cancel$default(this.g, null, 1, null);
                BufferedSink bufferedSink0 = this.j;
                q.d(bufferedSink0);
                bufferedSink0.close();
                this.j = null;
                this.m = true;
                return;
            }
            this.m = true;
        }
    }

    @Override
    public final void flush() {
        synchronized(this) {
            if(!this.l) {
                return;
            }
            if(!this.m) {
                this.A();
                BufferedSink bufferedSink0 = this.j;
                q.d(bufferedSink0);
                bufferedSink0.flush();
                return;
            }
        }
        throw new IllegalStateException("cache is closed");
    }

    public final c g(String s) {
        synchronized(this) {
            if(!this.m) {
                f.B(s);
                this.m();
                b b0 = (b)this.f.get(s);
                if((b0 == null ? null : b0.g) != null) {
                    return null;
                }
                if(b0 != null && b0.h != 0) {
                    return null;
                }
                if(!this.n && !this.o) {
                    BufferedSink bufferedSink0 = this.j;
                    q.d(bufferedSink0);
                    bufferedSink0.writeUtf8("DIRTY");
                    bufferedSink0.writeByte(0x20);
                    bufferedSink0.writeUtf8(s);
                    bufferedSink0.writeByte(10);
                    bufferedSink0.flush();
                    if(this.k) {
                        return null;
                    }
                    if(b0 == null) {
                        b0 = new b(this, s);
                        this.f.put(s, b0);
                    }
                    c c0 = new c(this, b0);
                    b0.g = c0;
                    return c0;
                }
                this.o();
                return null;
            }
        }
        throw new IllegalStateException("cache is closed");
    }

    public final l5.c h(String s) {
        synchronized(this) {
            if(!this.m) {
                f.B(s);
                this.m();
                b b0 = (b)this.f.get(s);
                if(b0 != null) {
                    l5.c c0 = b0.a();
                    if(c0 != null) {
                        ++this.i;
                        BufferedSink bufferedSink0 = this.j;
                        q.d(bufferedSink0);
                        bufferedSink0.writeUtf8("READ");
                        bufferedSink0.writeByte(0x20);
                        bufferedSink0.writeUtf8(s);
                        bufferedSink0.writeByte(10);
                        if(this.i >= 2000) {
                            this.o();
                        }
                        return c0;
                    }
                }
                return null;
            }
        }
        throw new IllegalStateException("cache is closed");
    }

    public final void m() {
        synchronized(this) {
            if(this.l) {
                return;
            }
            this.r.delete(this.d);
            if(this.r.exists(this.e)) {
                if(this.r.exists(this.c)) {
                    this.r.delete(this.e);
                }
                else {
                    this.r.atomicMove(this.e, this.c);
                }
            }
            if(this.r.exists(this.c)) {
                try {
                    this.q();
                    this.p();
                    this.l = true;
                    return;
                }
                catch(IOException unused_ex) {
                    try {
                        this.close();
                        a.y(this.r, this.a);
                        this.m = false;
                    }
                    catch(Throwable throwable0) {
                        this.m = false;
                        throw throwable0;
                    }
                }
            }
            this.C();
            this.l = true;
        }
    }

    public final void o() {
        e e0 = new e(this, null);
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, e0, 3, null);
    }

    public final void p() {
        long v = 0L;
        Iterator iterator0 = this.f.values().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            b b0 = (b)object0;
            int v1 = 0;
            if(b0.g == null) {
                while(v1 < 2) {
                    v += b0.b[v1];
                    ++v1;
                }
            }
            else {
                b0.g = null;
                while(v1 < 2) {
                    Path path0 = (Path)b0.c.get(v1);
                    this.r.delete(path0);
                    Path path1 = (Path)b0.d.get(v1);
                    this.r.delete(path1);
                    ++v1;
                }
                iterator0.remove();
            }
        }
        this.h = v;
    }

    public final void q() {
        d d0 = this.r;
        Path path0 = this.c;
        BufferedSource bufferedSource0 = Okio.buffer(d0.source(path0));
        try {
            String s = bufferedSource0.readUtf8LineStrict();
            String s1 = bufferedSource0.readUtf8LineStrict();
            String s2 = bufferedSource0.readUtf8LineStrict();
            String s3 = bufferedSource0.readUtf8LineStrict();
            String s4 = bufferedSource0.readUtf8LineStrict();
            if(!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !q.b("1", s2) || !q.b("2", s3) || s4.length() > 0) {
                throw new IOException("unexpected journal header: [" + s + ", " + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ']');
            }
            int v = 0;
            try {
                while(true) {
                    this.r(bufferedSource0.readUtf8LineStrict());
                    ++v;
                }
            }
            catch(EOFException unused_ex) {
                this.i = v - this.f.size();
                if(bufferedSource0.exhausted()) {
                    this.j = Okio.buffer(new g(d0.appendingSink(path0), new i(this, 14)));
                }
                else {
                    this.C();
                }
                try {
                    bufferedSource0.close();
                    throwable0 = null;
                }
                catch(Throwable throwable0) {
                }
            }
        }
        catch(Throwable throwable0) {
            if(bufferedSource0 != null) {
                try {
                    bufferedSource0.close();
                }
                catch(Throwable throwable1) {
                    a.q(throwable0, throwable1);
                }
            }
        }
        if(throwable0 != null) {
            throw throwable0;
        }
    }

    public final void r(String s) {
        List list0;
        String s1;
        int v1 = o.E0(s, ' ', 0, 6);
        if(v1 == -1) {
            throw new IOException("unexpected journal line: " + s);
        }
        int v2 = o.E0(s, ' ', v1 + 1, 4);
        LinkedHashMap linkedHashMap0 = this.f;
        if(v2 == -1) {
            s1 = s.substring(v1 + 1);
            q.f(s1, "substring(...)");
            if(v1 == 6 && v.r0(s, "REMOVE", false)) {
                linkedHashMap0.remove(s1);
                return;
            }
        }
        else {
            s1 = s.substring(v1 + 1, v2);
            q.f(s1, "substring(...)");
        }
        b b0 = linkedHashMap0.get(s1);
        if(b0 == null) {
            b0 = new b(this, s1);
            linkedHashMap0.put(s1, b0);
        }
        if(v2 != -1 && v1 == 5 && v.r0(s, "CLEAN", false)) {
            String s2 = s.substring(v2 + 1);
            q.f(s2, "substring(...)");
            list0 = o.S0(s2, new char[]{' '});
            b0.e = true;
            b0.g = null;
            if(list0.size() != 2) {
                throw new IOException("unexpected journal line: " + list0);
            }
            try {
                int v3 = list0.size();
                for(int v = 0; v < v3; ++v) {
                    b0.b[v] = Long.parseLong(((String)list0.get(v)));
                }
            }
            catch(NumberFormatException unused_ex) {
                throw new IOException("unexpected journal line: " + list0);
            }
            return;
        }
        if(v2 == -1 && v1 == 5 && v.r0(s, "DIRTY", false)) {
            b0.g = new c(this, b0);
            return;
        }
        if(v2 == -1 && v1 == 4 && v.r0(s, "READ", false)) {
            try {
                return;
            }
            catch(NumberFormatException unused_ex) {
                throw new IOException("unexpected journal line: " + list0);
            }
        }
        throw new IOException("unexpected journal line: " + s);
    }

    public final void s(b b0) {
        String s = b0.a;
        if(b0.h > 0) {
            BufferedSink bufferedSink0 = this.j;
            if(bufferedSink0 != null) {
                bufferedSink0.writeUtf8("DIRTY");
                bufferedSink0.writeByte(0x20);
                bufferedSink0.writeUtf8(s);
                bufferedSink0.writeByte(10);
                bufferedSink0.flush();
            }
        }
        if(b0.h <= 0 && b0.g == null) {
            for(int v = 0; v < 2; ++v) {
                Path path0 = (Path)b0.c.get(v);
                this.r.delete(path0);
                this.h -= b0.b[v];
                b0.b[v] = 0L;
            }
            ++this.i;
            BufferedSink bufferedSink1 = this.j;
            if(bufferedSink1 != null) {
                bufferedSink1.writeUtf8("REMOVE");
                bufferedSink1.writeByte(0x20);
                bufferedSink1.writeUtf8(s);
                bufferedSink1.writeByte(10);
            }
            this.f.remove(s);
            if(this.i >= 2000) {
                this.o();
            }
            return;
        }
        b0.f = true;
    }
}

