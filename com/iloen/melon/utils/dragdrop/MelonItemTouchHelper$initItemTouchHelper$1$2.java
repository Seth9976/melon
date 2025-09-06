package com.iloen.melon.utils.dragdrop;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\n\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"com/iloen/melon/utils/dragdrop/MelonItemTouchHelper$initItemTouchHelper$1$2", "Lcom/paulburke/android/itemtouchhelperdemo/ItemTouchHelperAdapter;", "", "onItemCheckEnable", "()Z", "", "currentDragPosition", "()I", "fromPosition", "toPosition", "onItemMove", "(II)Z", "position", "Lie/H;", "onItemDismiss", "(I)V", "onItemMoveStart", "()V", "onItemMoveFinish", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonItemTouchHelper.initItemTouchHelper.1.2 implements ItemTouchHelperAdapter {
    public final MelonItemTouchHelper a;
    public final RecyclerView b;

    public MelonItemTouchHelper.initItemTouchHelper.1.2(MelonItemTouchHelper melonItemTouchHelper0, RecyclerView recyclerView0) {
        this.a = melonItemTouchHelper0;
        this.b = recyclerView0;
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter
    public int currentDragPosition() {
        return MelonItemTouchHelper.access$getEndPos$p(this.a) >= 0 ? MelonItemTouchHelper.access$getEndPos$p(this.a) : MelonItemTouchHelper.access$getBeginPos$p(this.a);
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter
    public boolean onItemCheckEnable() {
        MelonItemTouchHelper melonItemTouchHelper0 = this.a;
        View view0 = MelonItemTouchHelper.access$getLastSelectedItemView$p(melonItemTouchHelper0);
        if(view0 != null) {
            ItemMoveListener melonItemTouchHelper$ItemMoveListener0 = MelonItemTouchHelper.access$getItemMoveListener$p(melonItemTouchHelper0);
            Boolean boolean0 = melonItemTouchHelper$ItemMoveListener0 == null ? null : Boolean.valueOf(melonItemTouchHelper$ItemMoveListener0.onItemCheckEnable(this.b.getChildAdapterPosition(view0)));
            return boolean0 == null ? true : boolean0.booleanValue();
        }
        return true;
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter
    public void onItemDismiss(int v) {
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter
    public boolean onItemMove(int v, int v1) {
        if(v >= 0 && v1 >= 0 && v != v1) {
            j0 j00 = this.b.getAdapter();
            if(j00 != null) {
                j00.notifyItemMoved(v, v1);
            }
        }
        MelonItemTouchHelper melonItemTouchHelper0 = this.a;
        if(MelonItemTouchHelper.access$getBeginPos$p(melonItemTouchHelper0) < 0) {
            MelonItemTouchHelper.access$setBeginPos$p(melonItemTouchHelper0, v);
            MelonItemTouchHelper.access$setEndPos$p(melonItemTouchHelper0, v1);
            return false;
        }
        MelonItemTouchHelper.access$setEndPos$p(melonItemTouchHelper0, v1);
        return false;
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter
    public void onItemMoveFinish() {
        MelonItemTouchHelper melonItemTouchHelper0 = this.a;
        if(MelonItemTouchHelper.access$getBeginPos$p(melonItemTouchHelper0) >= 0 && MelonItemTouchHelper.access$getEndPos$p(melonItemTouchHelper0) >= 0) {
            ItemMoveListener melonItemTouchHelper$ItemMoveListener0 = MelonItemTouchHelper.access$getItemMoveListener$p(melonItemTouchHelper0);
            if(melonItemTouchHelper$ItemMoveListener0 != null) {
                melonItemTouchHelper$ItemMoveListener0.onItemMoved(MelonItemTouchHelper.access$getBeginPos$p(melonItemTouchHelper0), MelonItemTouchHelper.access$getEndPos$p(melonItemTouchHelper0));
            }
        }
        if(MelonItemTouchHelper.access$getCustomSelectorListener$p(melonItemTouchHelper0) != null && MelonItemTouchHelper.access$getLastSelectedItemView$p(melonItemTouchHelper0) != null) {
            CustomSelectorListener melonItemTouchHelper$CustomSelectorListener0 = MelonItemTouchHelper.access$getCustomSelectorListener$p(melonItemTouchHelper0);
            if(melonItemTouchHelper$CustomSelectorListener0 != null) {
                melonItemTouchHelper$CustomSelectorListener0.onItemSelectStateChanged(false, MelonItemTouchHelper.access$getLastSelectedItemView$p(melonItemTouchHelper0));
            }
            return;
        }
        MelonItemTouchHelper.access$changeViewAlpha(melonItemTouchHelper0, MelonItemTouchHelper.access$getSavedAlpha$p(melonItemTouchHelper0));
        MelonItemTouchHelper.access$changeViewBackground(melonItemTouchHelper0, MelonItemTouchHelper.access$getSavedBgColor$p(melonItemTouchHelper0));
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter
    public void onItemMoveStart() {
        MelonItemTouchHelper melonItemTouchHelper0 = this.a;
        MelonItemTouchHelper.access$setBeginPos$p(melonItemTouchHelper0, -1);
        MelonItemTouchHelper.access$setEndPos$p(melonItemTouchHelper0, -1);
        View view0 = MelonItemTouchHelper.access$getLastSelectedItemView$p(melonItemTouchHelper0);
        if(view0 != null) {
            MelonItemTouchHelper.access$setSavedAlpha$p(melonItemTouchHelper0, view0.getAlpha());
            Drawable drawable0 = view0.getBackground();
            if(drawable0 instanceof ColorDrawable) {
                MelonItemTouchHelper.access$setSavedBgColor$p(melonItemTouchHelper0, ((ColorDrawable)drawable0).getColor());
            }
            if(MelonItemTouchHelper.access$getCustomSelectorListener$p(melonItemTouchHelper0) == null) {
                MelonItemTouchHelper.access$changeViewAlpha(melonItemTouchHelper0, MelonItemTouchHelper.access$getFloatAlpha$p(melonItemTouchHelper0));
                MelonItemTouchHelper.access$changeViewBackground(melonItemTouchHelper0, MelonItemTouchHelper.access$getBgColor$p(melonItemTouchHelper0));
            }
            else {
                CustomSelectorListener melonItemTouchHelper$CustomSelectorListener0 = MelonItemTouchHelper.access$getCustomSelectorListener$p(melonItemTouchHelper0);
                if(melonItemTouchHelper$CustomSelectorListener0 != null) {
                    melonItemTouchHelper$CustomSelectorListener0.onItemSelectStateChanged(true, MelonItemTouchHelper.access$getLastSelectedItemView$p(melonItemTouchHelper0));
                }
            }
            MelonItemTouchHelper.access$setBeginPos$p(melonItemTouchHelper0, this.b.getChildAdapterPosition(view0));
        }
    }
}

