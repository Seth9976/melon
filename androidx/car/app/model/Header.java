package androidx.car.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Header {
    private final List mEndHeaderActions;
    private final Action mStartHeaderAction;
    private final CarText mTitle;

    private Header() {
        this.mTitle = null;
        this.mStartHeaderAction = null;
        this.mEndHeaderActions = new ArrayList();
    }

    public Header(m m0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Header ? Objects.equals(this.mTitle, ((Header)object0).mTitle) && Objects.equals(this.mEndHeaderActions, ((Header)object0).mEndHeaderActions) && Objects.equals(this.mStartHeaderAction, ((Header)object0).mStartHeaderAction) : false;
    }

    public List getEndHeaderActions() {
        return this.mEndHeaderActions;
    }

    public Action getStartHeaderAction() {
        return this.mStartHeaderAction;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTitle, this.mEndHeaderActions, this.mStartHeaderAction});
    }

    @Override
    public String toString() {
        return "Header: " + this.mTitle;
    }
}

