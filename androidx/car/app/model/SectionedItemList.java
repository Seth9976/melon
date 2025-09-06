package androidx.car.app.model;

import androidx.appcompat.app.o;
import java.util.List;
import java.util.Objects;
import v.c;

public final class SectionedItemList {
    private final CarText mHeader;
    private final ItemList mItemList;

    private SectionedItemList() {
        this.mItemList = null;
        this.mHeader = null;
    }

    private SectionedItemList(ItemList itemList0, CarText carText0) {
        this.mItemList = itemList0;
        this.mHeader = carText0;
    }

    public static SectionedItemList create(ItemList itemList0, CharSequence charSequence0) {
        Objects.requireNonNull(charSequence0);
        CarText carText0 = CarText.create(charSequence0);
        c c0 = c.b;
        c0.getClass();
        c0.a(carText0.getSpans());
        for(Object object0: carText0.getSpansForVariants()) {
            c0.a(((List)object0));
        }
        Objects.requireNonNull(itemList0);
        return new SectionedItemList(itemList0, carText0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof SectionedItemList ? Objects.equals(this.mItemList, ((SectionedItemList)object0).mItemList) && Objects.equals(this.mHeader, ((SectionedItemList)object0).mHeader) : false;
    }

    public CarText getHeader() {
        Objects.requireNonNull(this.mHeader);
        return this.mHeader;
    }

    public ItemList getItemList() {
        Objects.requireNonNull(this.mItemList);
        return this.mItemList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mItemList, this.mHeader});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[ items: ");
        stringBuilder0.append(this.mItemList);
        stringBuilder0.append(", has header: ");
        return this.mHeader == null ? o.s(stringBuilder0, false, "]") : o.s(stringBuilder0, true, "]");
    }
}

