package j3;

import c3.b;
import c3.c;
import c3.e;
import java.nio.ByteBuffer;

public final class x extends e {
    public static final int i;

    static {
        x.i = 0x7FC00000;
    }

    @Override  // c3.e
    public final b b(b b0) {
        int v = b0.c;
        if(v != 21 && v != 22 && v != 0x50000000 && (v != 4 && v != 0x60000000)) {
            throw new c(b0);
        }
        return v == 4 ? b.e : new b(b0.a, b0.b, 4);
    }

    public static void g(int v, ByteBuffer byteBuffer0) {
        byteBuffer0.putInt((Float.floatToIntBits(((float)(((double)v) * 4.656613E-10))) == x.i ? 0 : Float.floatToIntBits(((float)(((double)v) * 4.656613E-10)))));
    }

    @Override  // c3.d
    public final void queueInput(ByteBuffer byteBuffer0) {
        ByteBuffer byteBuffer1;
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        int v2 = v1 - v;
    alab1:
        switch(this.b.c) {
            case 21: {
                byteBuffer1 = this.f(v2 / 3 * 4);
                while(v < v1) {
                    x.g((byteBuffer0.get(v) & 0xFF) << 8 | (byteBuffer0.get(v + 1) & 0xFF) << 16 | (byteBuffer0.get(v + 2) & 0xFF) << 24, byteBuffer1);
                    v += 3;
                }
                break;
            }
            case 22: {
                byteBuffer1 = this.f(v2);
                while(v < v1) {
                    x.g(byteBuffer0.get(v) & 0xFF | (byteBuffer0.get(v + 1) & 0xFF) << 8 | (byteBuffer0.get(v + 2) & 0xFF) << 16 | (byteBuffer0.get(v + 3) & 0xFF) << 24, byteBuffer1);
                    v += 4;
                }
                break;
            }
            case 0x50000000: {
                byteBuffer1 = this.f(v2 / 3 * 4);
                while(v < v1) {
                    x.g((byteBuffer0.get(v + 2) & 0xFF) << 8 | (byteBuffer0.get(v + 1) & 0xFF) << 16 | (byteBuffer0.get(v) & 0xFF) << 24, byteBuffer1);
                    v += 3;
                }
                break;
            }
            case 0x60000000: {
                byteBuffer1 = this.f(v2);
                while(true) {
                    if(v >= v1) {
                        break alab1;
                    }
                    x.g(byteBuffer0.get(v + 3) & 0xFF | (byteBuffer0.get(v + 2) & 0xFF) << 8 | (byteBuffer0.get(v + 1) & 0xFF) << 16 | (byteBuffer0.get(v) & 0xFF) << 24, byteBuffer1);
                    v += 4;
                }
            }
            default: {
                throw new IllegalStateException();
            }
        }
        byteBuffer0.position(byteBuffer0.limit());
        byteBuffer1.flip();
    }
}

