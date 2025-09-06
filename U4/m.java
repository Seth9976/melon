package U4;

import android.app.Notification;

public final class m {
    public final int a;
    public final int b;
    public final Notification c;

    public m(int v, Notification notification0, int v1) {
        this.a = v;
        this.c = notification0;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(m.class != class0 || this.a != ((m)object0).a) {
                return false;
            }
            return this.b == ((m)object0).b ? this.c.equals(((m)object0).c) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.a * 0x1F + this.b) * 0x1F;
    }

    @Override
    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}

