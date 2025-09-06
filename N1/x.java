package N1;

import android.content.ComponentName;
import android.support.v4.app.INotificationSideChannel;
import java.util.ArrayDeque;

public final class x {
    public final ComponentName a;
    public boolean b;
    public INotificationSideChannel c;
    public final ArrayDeque d;
    public int e;

    public x(ComponentName componentName0) {
        this.b = false;
        this.d = new ArrayDeque();
        this.e = 0;
        this.a = componentName0;
    }
}

