package v4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public final class c {
    public final ArrayList a;
    public final Object b;

    public c(List list0, ArrayList arrayList0) {
        this.a = arrayList0;
        this.b = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof c) {
                Object object1 = ((c)object0).b;
                return this.a.size() == ((c)object0).a.size() && (((List)this.b).size() == ((List)object1).size() && new HashSet(this.a).equals(new HashSet(((c)object0).a)) && new HashSet(((Collection)this.b)).equals(new HashSet(((Collection)object1))));
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b});
    }

    @Override
    public final String toString() {
        return "GetTopicsResponse: Topics=" + this.a + ", EncryptedTopics=" + this.b;
    }
}

