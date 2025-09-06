package com.iloen.melon.utils.dragdrop.scroll;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewScrollStrategy extends ScrollStrategyBase {
    public ListViewScrollStrategy(RecyclerView recyclerView0, boolean z) {
        super(recyclerView0);
        this.isHorizontal = z;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getFirstVisiblePosition() {
        return this.recyclerView.getLayoutManager() instanceof LinearLayoutManager ? ((LinearLayoutManager)this.recyclerView.getLayoutManager()).findFirstVisibleItemPosition() : 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getLastVisiblePosition() {
        return this.recyclerView.getLayoutManager() instanceof LinearLayoutManager ? ((LinearLayoutManager)this.recyclerView.getLayoutManager()).findLastVisibleItemPosition() : 0;
    }

    // 去混淆评级： 中等(60)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getMovementFlags() {
        return this.isHorizontal ? 0xC303C : 0x33033;
    }
}

