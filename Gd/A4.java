package gd;

import je.n;
import kotlin.jvm.internal.q;
import we.a;

public final class a4 implements a {
    public final int a;
    public final f4 b;

    public a4(f4 f40, int v) {
        this.a = v;
        this.b = f40;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        f4 f40 = this.b;
        if(this.a != 0) {
            String[] arr_s = f40.d().getResources().getStringArray(0x7F030017);  // array:melondj_playlist_power_dj
            q.f(arr_s, "getStringArray(...)");
            return n.N(arr_s);
        }
        String[] arr_s1 = f40.d().getResources().getStringArray(0x7F030015);  // array:melondj_playlist_all
        q.f(arr_s1, "getStringArray(...)");
        return n.N(arr_s1);
    }
}

