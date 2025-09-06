package se;

import android.os.Build.VERSION;

public abstract class a {
    public static final Integer a;

    static {
        Integer integer0 = null;
        Integer integer1 = Build.VERSION.SDK_INT;
        Integer integer2 = integer1 instanceof Integer ? integer1 : null;
        if(integer2 != null && integer2.intValue() > 0) {
            integer0 = integer2;
        }
        a.a = integer0;
    }
}

