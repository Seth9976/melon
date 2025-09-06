package s3;

import e3.b;
import java.io.IOException;

public final class f extends IOException {
    public f(int v) {
        this(v, 0x8000000000000001L, 0x8000000000000001L);
    }

    public f(int v, long v1, long v2) {
        String s;
        boolean z = true;
        StringBuilder stringBuilder0 = new StringBuilder("Illegal clipping: ");
        switch(v) {
            case 0: {
                s = "invalid period count";
                break;
            }
            case 1: {
                s = "not seekable to start";
                break;
            }
            case 2: {
                if(v1 == 0x8000000000000001L || v2 == 0x8000000000000001L) {
                    z = false;
                }
                b.j(z);
                s = "start exceeds end. Start time: " + v1 + ", End time: " + v2;
                break;
            }
            default: {
                s = "unknown";
            }
        }
        stringBuilder0.append(s);
        super(stringBuilder0.toString());
    }
}

