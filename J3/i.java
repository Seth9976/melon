package j3;

import U4.x;
import androidx.appcompat.app.o;
import androidx.media3.common.b;

public final class i extends Exception {
    public final int a;
    public final boolean b;

    public i(int v, int v1, int v2, int v3, b b0, boolean z, RuntimeException runtimeException0) {
        StringBuilder stringBuilder0 = o.t(v, v1, "AudioTrack init failed ", " Config(", ", ");
        x.x(stringBuilder0, v2, ", ", v3, ") ");
        stringBuilder0.append(b0);
        stringBuilder0.append((z ? " (recoverable)" : ""));
        super(stringBuilder0.toString(), runtimeException0);
        this.a = v;
        this.b = z;
    }
}

