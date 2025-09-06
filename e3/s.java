package e3;

import android.os.Message;
import java.util.ArrayList;

public final class s {
    public Message a;

    public final void a() {
        this.a = null;
        ArrayList arrayList0 = t.b;
        synchronized(arrayList0) {
            if(arrayList0.size() < 50) {
                arrayList0.add(this);
            }
        }
    }

    public final void b() {
        Message message0 = this.a;
        message0.getClass();
        message0.sendToTarget();
        this.a();
    }
}

