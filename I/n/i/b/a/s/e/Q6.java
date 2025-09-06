package i.n.i.b.a.s.e;

import B3.N;
import com.iloen.melon.utils.a;
import e0.b;
import java.nio.ByteBuffer;

public final class q6 implements T9 {
    public int a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public byte[] h;

    public final int a(byte[] arr_b, int v, int v1) {
        int v4;
        int v2 = a.a((arr_b[(arr_b[2] == 1 ? 3 : 4) + v] & 0x7F) >> 1);
        switch(p6.a[b.b(v2)]) {
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: {
                N n0 = new N(v + (arr_b[2] == 1 ? 3 : 4) + 2, v1, 7, arr_b);
                boolean z = n0.q();
                switch(v2) {
                    case 1: {
                        v4 = -1;
                        break;
                    }
                    case 2: {
                        v4 = 0;
                        break;
                    }
                    case 3: {
                        v4 = 1;
                        break;
                    }
                    case 4: {
                        v4 = 2;
                        break;
                    }
                    case 5: {
                        v4 = 3;
                        break;
                    }
                    case 6: {
                        v4 = 4;
                        break;
                    }
                    case 7: {
                        v4 = 5;
                        break;
                    }
                    case 8: {
                        v4 = 6;
                        break;
                    }
                    case 9: {
                        v4 = 7;
                        break;
                    }
                    case 10: {
                        v4 = 8;
                        break;
                    }
                    case 11: {
                        v4 = 9;
                        break;
                    }
                    case 12: {
                        v4 = 16;
                        break;
                    }
                    case 13: {
                        v4 = 17;
                        break;
                    }
                    case 14: {
                        v4 = 18;
                        break;
                    }
                    case 15: {
                        v4 = 19;
                        break;
                    }
                    case 16: {
                        v4 = 20;
                        break;
                    }
                    case 17: {
                        v4 = 21;
                        break;
                    }
                    case 18: {
                        v4 = 0x20;
                        break;
                    }
                    case 19: {
                        v4 = 33;
                        break;
                    }
                    case 20: {
                        v4 = 34;
                        break;
                    }
                    case 21: {
                        v4 = 35;
                        break;
                    }
                    case 22: {
                        v4 = 36;
                        break;
                    }
                    case 23: {
                        v4 = 37;
                        break;
                    }
                    case 24: {
                        v4 = 38;
                        break;
                    }
                    case 25: {
                        v4 = 39;
                        break;
                    }
                    case 26: {
                        v4 = 40;
                        break;
                    }
                    default: {
                        throw null;
                    }
                }
                if(v4 >= 16 && v4 <= 23) {
                    n0.q();
                }
                if(n0.l()) {
                    n0.u();
                    if(!z && this.c) {
                        this.e = n0.q();
                        n0.v(((int)(Math.log(((float)(this.a * this.b - 1)) * 2.0f) / 0.693147)));
                    }
                    if(!this.e) {
                        n0.v(this.d);
                        if(n0.l()) {
                            switch(n0.u()) {
                                case 0: {
                                    return 3;
                                }
                                case 1: {
                                    return 2;
                                }
                                default: {
                                    return 4;
                                }
                            }
                        }
                    }
                }
                return 4;
            }
            case 1: 
            case 2: 
            case 19: 
            case 20: 
            case 21: {
                int v3 = q6.c(arr_b, v + 1, v1 - 1);
                return v3 == v1 ? 4 : this.a(arr_b, v3, v1);
            }
            default: {
                return 4;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.T9
    public final boolean b(ByteBuffer byteBuffer0, h3.b b0, int v) {
        try {
            int v1 = this.d(byteBuffer0, b0, v);
            return v1 != 1 && v1 != 4 && v1 != 6;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return false;
        }
    }

    public static int c(byte[] arr_b, int v, int v1) {
        while(v < v1 - 4) {
            if(arr_b[v] == 0 && arr_b[v + 1] == 0 && arr_b[v + 2] == 0 && arr_b[v + 3] == 1) {
                return v;
            }
            ++v;
        }
        return v1 + 1;
    }

    public final int d(ByteBuffer byteBuffer0, h3.b b0, int v) {
        int v1 = 0;
        if(this.f && this.g && b0 != null && b0.f > 0) {
            int v2 = byteBuffer0.position();
            boolean z = false;
            boolean z1 = false;
            boolean z2 = false;
            while(v1 < b0.f) {
                byteBuffer0.position(v + 4);
                int v3 = (byteBuffer0.get() & 0x7F) >> 1;
                if(v3 == 0) {
                    z2 = true;
                }
                else if(v3 == 1) {
                    z1 = true;
                }
                else if(v3 <= 0x20) {
                    z = true;
                }
                v = v + b0.d[v1] + b0.e[v1];
                ++v1;
            }
            byteBuffer0.position(v2);
            if(z) {
                return 4;
            }
            if(z1) {
                return 2;
            }
            return z2 ? 3 : 4;
        }
        int v4 = byteBuffer0.position();
        int v5 = v4 - v;
        byteBuffer0.position(v);
        if(this.h.length < v5) {
            this.h = new byte[v5];
        }
        byteBuffer0.get(this.h, 0, v5);
        byteBuffer0.position(v4);
        if(this.f && this.g) {
            if(b0 != null && b0.f > 0) {
                byte[] arr_b = this.h;
                boolean z3 = false;
                int v6 = 0;
                boolean z4 = false;
                boolean z5 = false;
                while(v1 < b0.f) {
                    int v7 = (arr_b[v6 + 4] & 0x7F) >> 1;
                    if(v7 == 0) {
                        z5 = true;
                    }
                    else if(v7 == 1) {
                        z4 = true;
                    }
                    else if(v7 <= 0x20) {
                        z3 = true;
                    }
                    v6 = v6 + b0.d[v1] + b0.e[v1];
                    ++v1;
                }
                if(!z3) {
                    if(z4) {
                        return 2;
                    }
                    return z5 ? 3 : 4;
                }
                return 4;
            }
            try {
                return this.a(this.h, 0, v4);
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
                return 4;
            }
        }
        this.e(v5, this.h);
        return 4;
    }

    public final void e(int v, byte[] arr_b) {
        int v1 = 0;
        while(v1 < v) {
            int v2 = q6.c(arr_b, v1, v);
            v1 = q6.c(arr_b, v1 + 1, v - 1);
            switch(p6.a[b.b(a.a((arr_b[v2 + 4] & 0x7F) >> 1))]) {
                case 1: {
                    try {
                        this.f(arr_b, v2, v1);
                        this.f = true;
                        continue;
                    }
                    catch(Exception exception0) {
                        exception0.printStackTrace();
                        break;
                    }
                }
                case 2: {
                    try {
                        N n0 = new N(v2, v1, 7, arr_b);
                        n0.v(0x30);
                        if(n0.l()) {
                            n0.u();
                            if(n0.l()) {
                                n0.u();
                                this.c = n0.q();
                                n0.v(1);
                                this.d = n0.i(3);
                            }
                        }
                        this.g = true;
                    }
                    catch(Exception exception1) {
                        exception1.printStackTrace();
                    }
                }
            }
        }
    }

    // This method was un-flattened
    public final void f(byte[] arr_b, int v, int v1) {
        N n0 = new N(v, v1, 7, arr_b);
        n0.v(0x30);
        n0.i(4);
        int v2 = n0.i(3);
        n0.v(1);
        n0.v(88);
        n0.v(8);
        int v4 = 0;
        for(int v3 = 0; v3 < v2; ++v3) {
            if(n0.q()) {
                v4 += 89;
            }
            if(n0.q()) {
                v4 += 8;
            }
        }
        n0.v(v4);
        if(v2 > 0) {
            n0.v((8 - v2) * 2);
        }
        long v5 = (long)n0.u();
        int v6 = n0.u();
        if(v6 == 3) {
            n0.v(1);
        }
        if(v2 == 0 && v6 == 1 && v5 == 0L) {
            int v7 = n0.u();
            int v8 = n0.u();
            if(n0.q()) {
                n0.u();
                n0.u();
                n0.u();
                n0.u();
            }
            n0.u();
            n0.u();
            n0.u();
            boolean z = !n0.q();
            n0.u();
            n0.u();
            n0.u();
            int v9 = n0.u();
            int v10 = n0.u() + (v9 + 3);
            this.a = v7 + (1 << v10) - 1 >> v10;
            this.b = v8 + (1 << v10) - 1 >> v10;
        }
    }
}

