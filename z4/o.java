package z4;

import G4.c;
import h7.u0;
import kotlin.jvm.internal.q;

public final class o implements c {
    public final c a;
    public final long b;
    public final u c;

    public o(u u0, c c0) {
        q.g(c0, "delegate");
        this.c = u0;
        this.a = c0;
        this.b = 0x6F223L;
    }

    @Override  // G4.c
    public final String S(int v) {
        if(!this.c.d.get()) {
            if(this.b == 0x6F5A7L) {
                return this.a.S(v);
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final void a(int v, long v1) {
        if(!this.c.d.get()) {
            if(this.b == 0x6F4A7L) {
                this.a.a(v, v1);
                return;
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final void b(int v) {
        if(!this.c.d.get()) {
            if(this.b == 0x70B9BL) {
                this.a.b(v);
                return;
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override
    public final void close() {
        if(!this.c.d.get()) {
            if(this.b == 0x6F49BL) {
                this.a.close();
                return;
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final void e(int v, String s) {
        q.g(s, "value");
        if(!this.c.d.get()) {
            if(this.b == 0x6F1A6L) {
                this.a.e(v, s);
                return;
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final int getColumnCount() {
        if(!this.c.d.get()) {
            if(this.b == 0x6F510L) {
                return this.a.getColumnCount();
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final String getColumnName(int v) {
        if(!this.c.d.get()) {
            if(this.b == 0x6F2AFL) {
                return this.a.getColumnName(v);
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final long getLong(int v) {
        if(!this.c.d.get()) {
            if(this.b == 0x6EF5AL) {
                return this.a.getLong(v);
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final boolean isNull(int v) {
        if(!this.c.d.get()) {
            if(this.b == 0x6F4A3L) {
                return this.a.isNull(v);
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final boolean j0() {
        if(!this.c.d.get()) {
            if(this.b == 0x6F07EL) {
                return this.a.j0();
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }

    @Override  // G4.c
    public final void reset() {
        if(!this.c.d.get()) {
            if(this.b == 0x6F217L) {
                this.a.reset();
                return;
            }
            u0.S(21, "Attempted to use statement on a different thread");
            throw null;
        }
        u0.S(21, "Statement is recycled");
        throw null;
    }
}

