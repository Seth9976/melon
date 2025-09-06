package i.n.i.b.a.s.e;

import java.io.IOException;

public final class lb extends IOException {
    public lb(Throwable throwable0) {
        super("Unexpected " + throwable0.getClass().getSimpleName() + ": " + throwable0.getMessage(), throwable0);
    }
}

