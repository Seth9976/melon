package c3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class e implements d {
    public b b;
    public b c;
    public b d;
    public b e;
    public ByteBuffer f;
    public ByteBuffer g;
    public boolean h;

    public e() {
        this.f = d.a;
        this.g = d.a;
        this.d = b.e;
        this.e = b.e;
        this.b = b.e;
        this.c = b.e;
    }

    @Override  // c3.d
    public final b a(b b0) {
        this.d = b0;
        this.e = this.b(b0);
        return this.isActive() ? this.e : b.e;
    }

    public abstract b b(b arg1);

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public final ByteBuffer f(int v) {
        if(this.f.capacity() < v) {
            this.f = ByteBuffer.allocateDirect(v).order(ByteOrder.nativeOrder());
        }
        else {
            this.f.clear();
        }
        this.g = this.f;
        return this.f;
    }

    @Override  // c3.d
    public final void flush() {
        this.g = d.a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        this.c();
    }

    @Override  // c3.d
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer0 = this.g;
        this.g = d.a;
        return byteBuffer0;
    }

    @Override  // c3.d
    public boolean isActive() {
        return this.e != b.e;
    }

    @Override  // c3.d
    public boolean isEnded() {
        return this.h && this.g == d.a;
    }

    @Override  // c3.d
    public final void queueEndOfStream() {
        this.h = true;
        this.d();
    }

    @Override  // c3.d
    public final void reset() {
        this.flush();
        this.f = d.a;
        this.d = b.e;
        this.e = b.e;
        this.b = b.e;
        this.c = b.e;
        this.e();
    }
}

