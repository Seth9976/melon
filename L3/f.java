package l3;

import android.os.SystemClock;
import java.util.List;
import v3.c;

public final class f extends c {
    public int g;

    @Override  // v3.o
    public final void d(long v, long v1, long v2, List list0, t3.c[] arr_c) {
        long v3 = SystemClock.elapsedRealtime();
        if(!this.a(this.g, v3)) {
            return;
        }
        for(int v4 = this.b - 1; v4 >= 0; --v4) {
            if(!this.a(v4, v3)) {
                this.g = v4;
                return;
            }
        }
        throw new IllegalStateException();
    }

    @Override  // v3.o
    public final int getSelectedIndex() {
        return this.g;
    }

    @Override  // v3.o
    public final Object getSelectionData() {
        return null;
    }

    @Override  // v3.o
    public final int getSelectionReason() {
        return 0;
    }
}

