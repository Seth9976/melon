package z9;

import com.iloen.melon.utils.log.LogU;
import java.util.HashMap;

public final class h {
    public final LogU a;
    public final HashMap b;
    public final HashMap c;

    public h() {
        this.a = new LogU("UserDataHelper.CacheItem");
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public final void a() {
        synchronized(this.b) {
            this.b.clear();
        }
        synchronized(this.c) {
            this.c.clear();
        }
    }
}

