package J0;

import H0.b;
import java.util.concurrent.CancellationException;

public final class p extends CancellationException {
    public p(long v) {
        super(b.g(v, "Timed out waiting for ", " ms"));
    }

    @Override
    public final Throwable fillInStackTrace() {
        this.setStackTrace(u.c);
        return this;
    }
}

