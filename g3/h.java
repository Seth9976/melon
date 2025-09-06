package g3;

import e3.b;
import i.n.i.b.a.s.e.D0;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.W2;
import java.io.InputStream;

public final class h extends InputStream {
    public final int a;
    public final byte[] b;
    public boolean c;
    public boolean d;
    public final Object e;
    public final Object f;

    public h(f f0, j j0) {
        this.a = 0;
        super();
        this.c = false;
        this.d = false;
        this.e = f0;
        this.f = j0;
        this.b = new byte[1];
    }

    public h(D0 d00, W2 w20) {
        this.a = 1;
        super();
        this.c = false;
        this.d = false;
        this.e = d00;
        this.f = w20;
        this.b = new byte[1];
    }

    public void b() {
        if(!this.c) {
            ((D0)this.e).b(((W2)this.f));
            this.c = true;
        }
    }

    @Override
    public final void close() {
        if(this.a != 0) {
            if(!this.d) {
                ((D0)this.e).close();
                this.d = true;
            }
            return;
        }
        if(!this.d) {
            ((f)this.e).close();
            this.d = true;
        }
    }

    public void h() {
        if(!this.c) {
            ((f)this.e).p(((j)this.f));
            this.c = true;
        }
    }

    @Override
    public final int read() {
        if(this.a != 0) {
            return this.read(this.b, 0, this.b.length) == -1 ? -1 : this.b[0] & 0xFF;
        }
        return this.read(this.b, 0, this.b.length) == -1 ? -1 : this.b[0] & 0xFF;
    }

    @Override
    public final int read(byte[] arr_b) {
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override
    public final int read(byte[] arr_b, int v, int v1) {
        if(this.a != 0) {
            M7.J(!this.d);
            this.b();
            int v2 = ((D0)this.e).o(arr_b, v, v1);
            return v2 == -1 ? -1 : v2;
        }
        b.j(!this.d);
        this.h();
        int v3 = ((f)this.e).read(arr_b, v, v1);
        return v3 == -1 ? -1 : v3;
    }
}

