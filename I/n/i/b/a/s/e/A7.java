package i.n.i.b.a.s.e;

import android.util.Log;

public final class a7 {
    public final boolean a;
    public final String b;
    public final he c;
    public final int d;
    public final byte[] e;

    public a7(boolean z, String s, int v, byte[] arr_b, int v1, int v2, byte[] arr_b1) {
        int v3 = 1;
        M7.u(((boolean)((v == 0 ? 1 : 0) ^ (arr_b1 == null ? 1 : 0))));
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
                    Log.w("TrackEncryptionBox", "Unsupported protection scheme type \'" + s + "\'. Assuming AES-CTR crypto mode.");
                }
            }
        }
        this.c = new he(v3, arr_b, v1, v2);
    }
}

