package com.iloen.melon.adapters.common;

import androidx.recyclerview.widget.O0;
import com.iloen.melon.fragments.main.common.DetailViewHolderInterface;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolder;

public abstract class b extends p {
    private static final String TAG = "AdapterInViewHolder";

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return this.getItem(v1) instanceof AdapterInViewHolder.Row ? ((AdapterInViewHolder.Row)this.getItem(v1)).getItemViewType() : this.getItemViewType(v1);
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(O0 o00, int v, int v1) {
        Object object0 = this.getItem(v1);
        if(object0 instanceof AdapterInViewHolder.Row && o00 instanceof DetailViewHolderInterface) {
            ((DetailViewHolderInterface)o00).onBindView(object0);
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onViewRecycled(O0 o00) {
        super.onViewRecycled(o00);
        if(o00 instanceof ViewableCheckViewHolder) {
            ((ViewableCheckViewHolder)o00).onViewRecycled();
        }
    }
}

