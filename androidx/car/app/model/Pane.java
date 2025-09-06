package androidx.car.app.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import k8.Y;

public final class Pane {
    private final List mActionList;
    private final CarIcon mImage;
    private final boolean mIsLoading;
    private final List mRows;

    private Pane() {
        this.mRows = Collections.EMPTY_LIST;
        this.mActionList = Collections.EMPTY_LIST;
        this.mIsLoading = false;
        this.mImage = null;
    }

    public Pane(I i0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Pane ? this.mIsLoading == ((Pane)object0).mIsLoading && Objects.equals(this.mActionList, ((Pane)object0).mActionList) && Objects.equals(this.mRows, ((Pane)object0).mRows) && Objects.equals(this.mImage, ((Pane)object0).mImage) : false;
    }

    public List getActions() {
        return this.mActionList == null ? Collections.EMPTY_LIST : this.mActionList;
    }

    public CarIcon getImage() {
        return this.mImage;
    }

    public List getRows() {
        return this.mRows == null ? Collections.EMPTY_LIST : this.mRows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mRows, this.mActionList, Boolean.valueOf(this.mIsLoading), this.mImage});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[ rows: ");
        stringBuilder0.append((this.mRows == null ? null : this.mRows.toString()));
        stringBuilder0.append(", action list: ");
        return Y.m(stringBuilder0, this.mActionList, "]");
    }
}

