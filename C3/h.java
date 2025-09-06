package c3;

import e3.x;
import java.nio.ByteBuffer;

public final class h extends e {
    @Override  // c3.e
    public final b b(b b0) {
        int v = b0.c;
        if(v != 2 && v != 3) {
            switch(v) {
                case 4: 
                case 21: 
                case 22: 
                case 0x10000000: 
                case 0x50000000: 
                case 0x60000000: {
                    break;
                }
                default: {
                    throw new c(b0);
                }
            }
        }
        return v == 2 ? b.e : new b(b0.a, b0.b, 2);
    }

    @Override  // c3.d
    public final void queueInput(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        int v2 = v1 - v;
        switch(this.b.c) {
            case 3: {
                v2 *= 2;
                break;
            }
            case 0x10000000: {
                break;
            }
            case 21: 
            case 0x50000000: {
                v2 = v2 / 3 * 2;
                break;
            }
            case 4: 
            case 22: 
            case 0x60000000: {
                v2 /= 2;
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        ByteBuffer byteBuffer1 = this.f(v2);
    alab1:
        switch(this.b.c) {
            case 3: {
                while(true) {
                    if(v >= v1) {
                        break alab1;
                    }
                    byteBuffer1.put(0);
                    byteBuffer1.put(((byte)((byteBuffer0.get(v) & 0xFF) - 0x80)));
                    ++v;
                }
            }
            case 4: {
                while(v < v1) {
                    int v3 = (short)(((int)(x.g(byteBuffer0.getFloat(v), -1.0f, 1.0f) * 32767.0f)));
                    byteBuffer1.put(((byte)(v3 & 0xFF)));
                    byteBuffer1.put(((byte)(v3 >> 8 & 0xFF)));
                    v += 4;
                }
                break;
            }
            case 21: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 1));
                    byteBuffer1.put(byteBuffer0.get(v + 2));
                    v += 3;
                }
                break;
            }
            case 22: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 2));
                    byteBuffer1.put(byteBuffer0.get(v + 3));
                    v += 4;
                }
                break;
            }
            case 0x10000000: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 1));
                    byteBuffer1.put(byteBuffer0.get(v));
                    v += 2;
                }
                break;
            }
            case 0x50000000: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 1));
                    byteBuffer1.put(byteBuffer0.get(v));
                    v += 3;
                }
                break;
            }
            case 0x60000000: {
                while(v < v1) {
                    byteBuffer1.put(byteBuffer0.get(v + 1));
                    byteBuffer1.put(byteBuffer0.get(v));
                    v += 4;
                }
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        byteBuffer0.position(byteBuffer0.limit());
        byteBuffer1.flip();
    }
}

