package androidx.car.app.model;

import java.util.Objects;

public final class PaneTemplate implements Y {
    private final ActionStrip mActionStrip;
    private final Action mHeaderAction;
    private final Pane mPane;
    private final CarText mTitle;

    private PaneTemplate() {
        this.mTitle = null;
        this.mPane = null;
        this.mHeaderAction = null;
        this.mActionStrip = null;
    }

    public PaneTemplate(J j0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof PaneTemplate ? Objects.equals(this.mTitle, ((PaneTemplate)object0).mTitle) && Objects.equals(this.mPane, ((PaneTemplate)object0).mPane) && Objects.equals(this.mHeaderAction, ((PaneTemplate)object0).mHeaderAction) && Objects.equals(this.mActionStrip, ((PaneTemplate)object0).mActionStrip) : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public Pane getPane() {
        Objects.requireNonNull(this.mPane);
        return this.mPane;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTitle, this.mPane, this.mHeaderAction, this.mActionStrip});
    }

    @Override
    public String toString() {
        return "PaneTemplate";
    }
}

