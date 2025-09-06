package androidx.car.app.model;

import java.util.ArrayList;

public final class u {
    public final boolean a;
    public final ItemList b;
    public final ArrayList c;
    public final CarText d;
    public final Action e;
    public final ActionStrip f;
    public final ArrayList g;

    public u(ListTemplate listTemplate0) {
        this.a = listTemplate0.isLoading();
        this.e = listTemplate0.getHeaderAction();
        this.d = listTemplate0.getTitle();
        this.b = listTemplate0.getSingleList();
        this.c = new ArrayList(listTemplate0.getSectionedLists());
        this.f = listTemplate0.getActionStrip();
        this.g = new ArrayList(listTemplate0.getActions());
    }
}

