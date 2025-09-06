package androidx.car.app.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ActionStrip {
    private final List mActions;

    private ActionStrip() {
        this.mActions = Collections.EMPTY_LIST;
    }

    public ActionStrip(b b0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ActionStrip ? Objects.equals(this.mActions, ((ActionStrip)object0).mActions) : false;
    }

    public List getActions() {
        return this.mActions == null ? Collections.EMPTY_LIST : this.mActions;
    }

    public Action getFirstActionOfType(int v) {
        for(Object object0: this.mActions) {
            if(object0 instanceof Action && ((Action)object0).getType() == v) {
                return (Action)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.mActions);
    }

    @Override
    public String toString() {
        return "[action count: " + this.mActions.size() + "]";
    }
}

