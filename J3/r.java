package j3;

import android.os.SystemClock;

public final class r {
    public Exception a;
    public long b;
    public long c;

    public r() {
        this.b = 0x8000000000000001L;
        this.c = 0x8000000000000001L;
    }

    public final void a(Exception exception0) {
        long v = SystemClock.elapsedRealtime();
        if(this.a == null) {
            this.a = exception0;
        }
        if(this.b == 0x8000000000000001L && s.l0 <= 0) {
            this.b = v + 200L;
        }
        if(this.b != 0x8000000000000001L && v >= this.b) {
            Exception exception1 = this.a;
            if(exception1 != exception0) {
                exception1.addSuppressed(exception0);
            }
            Exception exception2 = this.a;
            this.a = null;
            this.b = 0x8000000000000001L;
            this.c = 0x8000000000000001L;
            throw exception2;
        }
        this.c = v + 50L;
    }
}

