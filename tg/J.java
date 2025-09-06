package tg;

import java.util.concurrent.CompletableFuture;

public final class j extends CompletableFuture {
    public final z a;

    public j(z z0) {
        this.a = z0;
    }

    @Override
    public final boolean cancel(boolean z) {
        if(z) {
            this.a.cancel();
        }
        return super.cancel(z);
    }
}

