package X5;

import S5.b;
import android.content.Context;
import javax.inject.Provider;

public final class e implements b {
    public final int a;
    public final Provider b;

    public e(Provider provider0, int v) {
        this.a = v;
        this.b = provider0;
        super();
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        return this.a != 0 ? new l(((Context)this.b.get()), "com.google.android.datatransport.events", l.d) : "com.iloen.melon";
    }
}

