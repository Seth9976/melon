package e7;

import android.os.Bundle;
import java.util.concurrent.Callable;

public final class j implements Callable {
    public final long a;
    public final k b;

    public j(k k0, long v) {
        this.b = k0;
        this.a = v;
    }

    @Override
    public final Object call() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("fatal", 1);
        bundle0.putLong("timestamp", this.a);
        this.b.k.u(bundle0);
        return null;
    }
}

