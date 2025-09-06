package Z1;

import java.util.List;
import java.util.Objects;

public final class b {
    public String a;
    public String b;
    public List c;

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? Objects.equals(this.a, ((b)object0).a) && Objects.equals(this.b, ((b)object0).b) && Objects.equals(this.c, ((b)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, this.c});
    }
}

