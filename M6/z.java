package M6;

import B.a;
import T7.b;
import android.os.Trace;
import com.gaa.sdk.iap.j;

public final class z implements Runnable {
    public final int a;

    public z(int v) {
        this.a = v;
        super();
    }

    public z(j j0, b b0) {
        this.a = 1;
        super();
    }

    private final void a() {
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                break;
            }
            case 1: {
                b.b(a.Z(1009));
                break;
            }
            default: {
                try {
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                }
                finally {
                    Trace.endSection();
                }
            }
        }
    }
}

