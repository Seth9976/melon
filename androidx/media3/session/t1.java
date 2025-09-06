package androidx.media3.session;

import I6.b0;
import android.os.Bundle;
import e3.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public final class t1 {
    public final b0 a;
    public static final t1 b;
    public static final String c;

    static {
        t1.b = new t1(new HashSet());
        t1.c = "0";
    }

    public t1(HashSet hashSet0) {
        this.a = b0.p(hashSet0);
    }

    public final boolean a(int v) {
        b.d(v != 0, "Use contains(Command) for custom command");
        for(Object object0: this.a) {
            if(((s1)object0).a == v) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public static t1 b(Bundle bundle0) {
        ArrayList arrayList0 = bundle0.getParcelableArrayList("0");
        if(arrayList0 == null) {
            b.D("SessionCommands", "Missing commands. Creating an empty SessionCommands");
            return t1.b;
        }
        HashSet hashSet0 = new HashSet();
        for(int v = 0; v < arrayList0.size(); ++v) {
            hashSet0.add(s1.a(((Bundle)arrayList0.get(v))));
        }
        return new t1(hashSet0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t1 ? this.a.equals(((t1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a});
    }
}

