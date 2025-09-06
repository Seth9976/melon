package w3;

import java.io.IOException;

public final class j extends IOException {
    public j(Throwable throwable0) {
        super("Unexpected " + throwable0.getClass().getSimpleName() + (throwable0.getMessage() == null ? "" : ": " + throwable0.getMessage()), throwable0);
    }
}

