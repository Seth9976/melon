package v3;

import b3.q0;
import e3.b;

public final class n {
    public final q0 a;
    public final int[] b;

    public n(int v, q0 q00, int[] arr_v) {
        if(arr_v.length == 0) {
            b.q("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.a = q00;
        this.b = arr_v;
    }
}

