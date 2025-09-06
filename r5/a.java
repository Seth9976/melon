package R5;

import U4.x;
import e0.b;

public final class a {
    public final int a;
    public final long b;

    public a(int v, long v1) {
        if(v == 0) {
            throw new NullPointerException("Null status");
        }
        this.a = v;
        this.b = v1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof a && b.a(this.a, ((a)object0).a) && this.b == ((a)object0).b;
    }

    @Override
    public final int hashCode() {
        return (b.b(this.a) ^ 1000003) * 1000003 ^ ((int)(this.b >>> 0x20 ^ this.b));
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("BackendResponse{status=");
        switch(this.a) {
            case 1: {
                s = "OK";
                break;
            }
            case 2: {
                s = "TRANSIENT_ERROR";
                break;
            }
            case 3: {
                s = "FATAL_ERROR";
                break;
            }
            case 4: {
                s = "INVALID_PAYLOAD";
                break;
            }
            default: {
                s = "null";
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(", nextRequestWaitMillis=");
        return x.h(this.b, "}", stringBuilder0);
    }
}

