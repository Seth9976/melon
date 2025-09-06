package androidx.car.app.model;

import U4.x;
import androidx.car.app.utils.g;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ItemList {
    private final List mItems;
    private final CarText mNoItemsMessage;
    private final F mOnItemVisibilityChangedDelegate;
    private final H mOnSelectedDelegate;
    private final int mSelectedIndex;

    private ItemList() {
        this.mSelectedIndex = 0;
        this.mItems = Collections.EMPTY_LIST;
        this.mNoItemsMessage = null;
        this.mOnSelectedDelegate = null;
        this.mOnItemVisibilityChangedDelegate = null;
    }

    public ItemList(r r0) {
        this.mSelectedIndex = r0.b;
        this.mItems = g.g(r0.a);
        this.mNoItemsMessage = r0.e;
        this.mOnSelectedDelegate = r0.c;
        this.mOnItemVisibilityChangedDelegate = r0.d;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ItemList)) {
            return false;
        }
        return this.mSelectedIndex != ((ItemList)object0).mSelectedIndex || !Objects.equals(this.mItems, ((ItemList)object0).mItems) || !Boolean.valueOf(this.mOnSelectedDelegate == null).equals(Boolean.valueOf(((ItemList)object0).mOnSelectedDelegate == null)) ? false : Boolean.valueOf(this.mOnItemVisibilityChangedDelegate == null).equals(Boolean.valueOf(((ItemList)object0).mOnItemVisibilityChangedDelegate == null)) && Objects.equals(this.mNoItemsMessage, ((ItemList)object0).mNoItemsMessage);
    }

    public List getItems() {
        return this.mItems == null ? Collections.EMPTY_LIST : this.mItems;
    }

    public CarText getNoItemsMessage() {
        return this.mNoItemsMessage;
    }

    public static B getOnClickDelegate(q q0) {
        if(q0 instanceof Row) {
            return ((Row)q0).getOnClickDelegate();
        }
        return q0 instanceof GridItem ? ((GridItem)q0).getOnClickDelegate() : null;
    }

    public F getOnItemVisibilityChangedDelegate() {
        return this.mOnItemVisibilityChangedDelegate;
    }

    public H getOnSelectedDelegate() {
        return this.mOnSelectedDelegate;
    }

    public int getSelectedIndex() {
        return this.mSelectedIndex;
    }

    // 去混淆评级： 低(20)
    public static Toggle getToggle(q q0) {
        return q0 instanceof Row ? ((Row)q0).getToggle() : null;
    }

    @Override
    public int hashCode() {
        Integer integer0 = this.mSelectedIndex;
        List list0 = this.mItems;
        boolean z = false;
        Boolean boolean0 = Boolean.valueOf(this.mOnSelectedDelegate == null);
        if(this.mOnItemVisibilityChangedDelegate == null) {
            z = true;
        }
        return Objects.hash(new Object[]{integer0, list0, boolean0, Boolean.valueOf(z), this.mNoItemsMessage});
    }

    public r toBuilder() {
        return new r(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[ items: ");
        stringBuilder0.append((this.mItems == null ? null : this.mItems.toString()));
        stringBuilder0.append(", selected: ");
        return x.g(this.mSelectedIndex, "]", stringBuilder0);
    }
}

