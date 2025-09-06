package i.n.i.b.a.s.e;

import U4.x;
import androidx.appcompat.app.o;

public final class t7 extends Exception {
    public final boolean a;
    public final u b;

    public t7(int v, int v1, int v2, int v3, u u0, boolean z, RuntimeException runtimeException0) {
        StringBuilder stringBuilder0 = o.t(v, v1, "AudioTrack init failed ", " Config(", ", ");
        x.x(stringBuilder0, v2, ", ", v3, ")");
        stringBuilder0.append((z ? " (recoverable)" : ""));
        super(stringBuilder0.toString(), runtimeException0);
        this.a = z;
        this.b = u0;
    }
}

