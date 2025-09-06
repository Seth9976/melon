package V3;

import B3.K;
import e3.b;

public final class t {
    public final boolean a;
    public final String b;
    public final K c;
    public final int d;
    public final byte[] e;

    public t(boolean z, String s, int v, byte[] arr_b, int v1, int v2, byte[] arr_b1) {
        int v3 = 1;
        b.c(((boolean)((v == 0 ? 1 : 0) ^ (arr_b1 == null ? 1 : 0))));
        this.a = z;
        this.b = s;
        this.d = v;
        this.e = arr_b1;
        if(s != null) {
            switch(s) {
                case "cbc1": 
                case "cbcs": {
                    v3 = 2;
                    break;
                }
                case "cenc": 
                case "cens": {
                    break;
                }
                default: {
                    b.D("TrackEncryptionBox", "Unsupported protection scheme type \'" + s + "\'. Assuming AES-CTR crypto mode.");
                }
            }
        }
        this.c = new K(v3, arr_b, v1, v2);
    }
}

