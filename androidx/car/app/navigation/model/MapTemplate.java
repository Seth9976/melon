package androidx.car.app.navigation.model;

import androidx.car.app.model.ActionStrip;
import androidx.car.app.model.Header;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.Pane;
import androidx.car.app.model.Y;
import java.util.Objects;

public final class MapTemplate implements Y {
    private final ActionStrip mActionStrip;
    private final Header mHeader;
    private final ItemList mItemList;
    private final MapController mMapController;
    private final Pane mPane;

    private MapTemplate() {
        this.mMapController = null;
        this.mPane = null;
        this.mItemList = null;
        this.mHeader = null;
        this.mActionStrip = null;
    }

    public MapTemplate(c c0) {
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MapTemplate ? Objects.equals(this.mPane, ((MapTemplate)object0).mPane) && Objects.equals(this.mItemList, ((MapTemplate)object0).mItemList) && Objects.equals(this.mHeader, ((MapTemplate)object0).mHeader) && Objects.equals(this.mMapController, ((MapTemplate)object0).mMapController) && Objects.equals(this.mActionStrip, ((MapTemplate)object0).mActionStrip) : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public Header getHeader() {
        return this.mHeader;
    }

    public ItemList getItemList() {
        return this.mItemList;
    }

    public MapController getMapController() {
        return this.mMapController;
    }

    public Pane getPane() {
        return this.mPane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mMapController, this.mPane, this.mItemList, this.mHeader, this.mActionStrip});
    }
}

