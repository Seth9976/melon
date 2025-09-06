package N1;

import U4.x;
import android.app.Notification;

public final class v {
    public final String a;
    public final int b;
    public final Notification c;

    public v(String s, int v, Notification notification0) {
        this.a = s;
        this.b = v;
        this.c = notification0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("NotifyTask[packageName:");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", id:");
        return x.g(this.b, ", tag:null]", stringBuilder0);
    }
}

