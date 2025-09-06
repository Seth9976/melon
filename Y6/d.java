package Y6;

import java.util.Set;
import y7.b;

public interface d {
    q a(s arg1);

    default b b(Class class0) {
        return this.c(s.a(class0));
    }

    b c(s arg1);

    default Object d(s s0) {
        b b0 = this.c(s0);
        return b0 == null ? null : b0.get();
    }

    default Set e(s s0) {
        return (Set)this.f(s0).get();
    }

    b f(s arg1);

    default Object get(Class class0) {
        return this.d(s.a(class0));
    }
}

