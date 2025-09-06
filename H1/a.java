package h1;

import java.util.Locale;
import kotlin.jvm.internal.q;

public final class a {
    public final Locale a;

    public a(Locale locale0) {
        this.a = locale0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof a)) {
            return false;
        }
        return this == object0 ? true : q.b(this.a.toLanguageTag(), ((a)object0).a.toLanguageTag());
    }

    @Override
    public final int hashCode() {
        return this.a.toLanguageTag().hashCode();
    }

    @Override
    public final String toString() {
        return this.a.toLanguageTag();
    }
}

