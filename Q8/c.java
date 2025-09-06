package q8;

import java.util.LinkedHashMap;
import we.a;

public final class c {
    public final LinkedHashMap a;

    public c() {
        this.a = new LinkedHashMap();
    }

    public final void a(a a0) {
        Object object0 = a0.invoke();
        this.a.put("menuid", object0);
    }

    public final void b(a a0) {
        String s = (String)a0.invoke();
        if(s == null) {
            s = "";
        }
        this.a.put("mixup", s);
    }

    public final void c(a a0) {
        String s = (String)a0.invoke();
        if(s == null) {
            s = "";
        }
        this.a.put("toros_event_meta_id", s);
    }

    public final void d(a a0) {
        Object object0 = a0.invoke();
        this.a.put("liketype", object0);
    }
}

