package Se;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import kotlin.jvm.internal.q;

public final class t extends v {
    public final Field a;

    public t(Field field0) {
        q.g(field0, "member");
        super();
        this.a = field0;
    }

    @Override  // Se.v
    public final Member b() {
        return this.a;
    }
}

