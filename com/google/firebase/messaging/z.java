package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

public final class z {
    public final String a;
    public final String b;
    public final String c;
    public static final Pattern d;

    static {
        z.d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    }

    public z(String s, String s1) {
        String s2;
        if(s1 == null || !s1.startsWith("/topics/")) {
            s2 = s1;
        }
        else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only \'topic-name\' should be used in " + s + ".");
            s2 = s1.substring(8);
        }
        if(s2 == null || !z.d.matcher(s2).matches()) {
            throw new IllegalArgumentException("Invalid topic name: " + s2 + " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}.");
        }
        this.a = s2;
        this.b = s;
        this.c = s + "!" + s1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof z ? this.a.equals(((z)object0).a) && this.b.equals(((z)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.b, this.a});
    }
}

