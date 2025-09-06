package androidx.car.app.model;

import java.util.ArrayList;

public final class r {
    public final ArrayList a;
    public final int b;
    public final H c;
    public final F d;
    public final CarText e;

    public r(ItemList itemList0) {
        this.b = itemList0.getSelectedIndex();
        this.c = itemList0.getOnSelectedDelegate();
        this.d = itemList0.getOnItemVisibilityChangedDelegate();
        this.e = itemList0.getNoItemsMessage();
        this.a = new ArrayList(itemList0.getItems());
    }
}

