package l3;

import de.c;
import java.util.Arrays;
import t3.a;

public final class d extends a {
    public byte[] j;
    public volatile boolean k;
    public byte[] l;

    @Override  // w3.h
    public final void cancelLoad() {
        this.k = true;
    }

    @Override  // w3.h
    public final void load() {
        try {
            this.i.p(this.b);
            int v1 = 0;
            int v2 = 0;
            while(v1 != -1 && !this.k) {
                byte[] arr_b = this.j;
                if(arr_b.length < v2 + 0x4000) {
                    this.j = Arrays.copyOf(arr_b, arr_b.length + 0x4000);
                }
                v1 = this.i.read(this.j, v2, 0x4000);
                if(v1 != -1) {
                    v2 += v1;
                }
            }
            if(!this.k) {
                this.l = Arrays.copyOf(this.j, v2);
            }
        }
        finally {
            c.n(this.i);
        }
    }
}

