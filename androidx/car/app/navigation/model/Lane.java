package androidx.car.app.navigation.model;

import U4.x;
import androidx.car.app.utils.g;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Lane {
    private final List mDirections;

    private Lane() {
        this.mDirections = Collections.EMPTY_LIST;
    }

    public Lane(List list0) {
        this.mDirections = g.g(list0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Lane ? Objects.equals(this.mDirections, ((Lane)object0).mDirections) : false;
    }

    public List getDirections() {
        return this.mDirections == null ? Collections.EMPTY_LIST : this.mDirections;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.mDirections);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[direction count: ");
        return this.mDirections == null ? "[direction count: 0]" : x.g(this.mDirections.size(), "]", stringBuilder0);
    }
}

