package androidx.car.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Alert {
    private static final int MAX_ACTION_COUNT = 2;
    private final List mActions;
    private final e mCallbackDelegate;
    private final long mDuration;
    private final CarIcon mIcon;
    private final int mId;
    private final CarText mSubtitle;
    private final CarText mTitle;

    private Alert() {
        this.mId = 0;
        this.mTitle = CarText.create("");
        this.mSubtitle = null;
        this.mIcon = null;
        this.mActions = new ArrayList();
        this.mDuration = 0L;
        this.mCallbackDelegate = null;
    }

    public Alert(c c0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Alert ? this.mId == ((Alert)object0).mId : false;
    }

    public List getActions() {
        return this.mActions;
    }

    public e getCallbackDelegate() {
        return this.mCallbackDelegate;
    }

    public long getDurationMillis() {
        return this.mDuration;
    }

    public CarIcon getIcon() {
        return this.mIcon;
    }

    public int getId() {
        return this.mId;
    }

    public CarText getSubtitle() {
        return this.mSubtitle;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mId});
    }

    @Override
    public String toString() {
        return "[id: " + this.mId + ", title: " + this.mTitle + ", icon: " + this.mIcon + "]";
    }
}

