package Yb;

import Sb.b;
import kotlinx.coroutines.TimeoutCancellationException;

public final class w extends b {
    public final String d;

    public w(String s, TimeoutCancellationException timeoutCancellationException0) {
        super(s, timeoutCancellationException0);
        this.d = "PrepareTimeoutException";
    }

    @Override  // Sb.b
    public final String b() {
        return this.d;
    }
}

