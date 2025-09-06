package com.kakao.emoticon.ui.tab;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.controller.EmoticonManager;
import com.kakao.emoticon.util.ActionTracker;
import java.util.List;

public class EmoticonTabAdapter extends j0 implements TabItemTouchHelperAdapter {
    public interface TabListener {
        void onTabClicked(int arg1);

        void onTabDeleted(List arg1, int arg2);

        void onTabMoved(List arg1, int arg2);
    }

    static class TabViewHolder extends O0 {
        FrameLayout emoticonBg;
        ImageView emoticonBtn;

        public TabViewHolder(View view0) {
            super(view0);
            this.emoticonBg = (FrameLayout)view0.findViewById(id.fl_emoticon_set_bg);
            this.emoticonBtn = (ImageView)view0.findViewById(id.img_emoticon_set_icon);
        }
    }

    private static final String ITEM_UPDATE = "item_update";
    private List items;
    private int selectedPosition;
    private int startDraggingPosition;
    private TabListener tabListener;

    public EmoticonTabAdapter() {
        this.selectedPosition = 0;
        this.startDraggingPosition = -1;
    }

    private int findRightNearSelectableItem(int v) {
        while(v > 0) {
            EmoticonTabItem emoticonTabItem0 = (EmoticonTabItem)this.items.get(v);
            if(!(emoticonTabItem0 instanceof DefaultItem) && !(emoticonTabItem0 instanceof ExpiredItem)) {
                --v;
                continue;
            }
            return v;
        }
        return 1;
    }

    public EmoticonTabItem getItem(int v) {
        return v < 0 || (this.items == null || v > this.items.size() - 1) ? null : ((EmoticonTabItem)this.items.get(v));
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        return this.items == null ? 0 : this.items.size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public long getItemId(int v) {
        return this.getItem(v) == null ? 0L : ((long)this.getItem(v).getItemId().hashCode());
    }

    public EmoticonTabItem getSelectedItem() {
        return this.getItem(this.selectedPosition);
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    // 检测为 Lambda 实现
    private void lambda$onBindViewHolder$0(TabViewHolder emoticonTabAdapter$TabViewHolder0, EmoticonTabItem emoticonTabItem0, View view0) [...]

    // 检测为 Lambda 实现
    private void lambda$onItemIdle$1(int v, int v1) [...]

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v) {
        this.onBindViewHolder(((TabViewHolder)o00), v);
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v, List list0) {
        this.onBindViewHolder(((TabViewHolder)o00), v, list0);
    }

    public void onBindViewHolder(TabViewHolder emoticonTabAdapter$TabViewHolder0, int v) {
        EmoticonTabItem emoticonTabItem0 = this.getItem(emoticonTabAdapter$TabViewHolder0.getAdapterPosition());
        emoticonTabAdapter$TabViewHolder0.emoticonBtn.setOnClickListener((View view0) -> if(this.selectedPosition != emoticonTabAdapter$TabViewHolder0.getAdapterPosition()) {
            if(emoticonTabItem0.isSelectable()) {
                TabListener emoticonTabAdapter$TabListener0 = this.tabListener;
                if(emoticonTabAdapter$TabListener0 != null) {
                    emoticonTabAdapter$TabListener0.onTabClicked(emoticonTabAdapter$TabViewHolder0.getAdapterPosition());
                }
            }
            else {
                emoticonTabItem0.doClick(emoticonTabAdapter$TabViewHolder0.itemView.getContext(), emoticonTabAdapter$TabViewHolder0.itemView);
            }
        });
        emoticonTabAdapter$TabViewHolder0.emoticonBtn.setContentDescription(emoticonTabItem0.getDisplayName());
        boolean z = false;
        if(this.selectedPosition == v) {
            emoticonTabAdapter$TabViewHolder0.emoticonBg.setSelected(true);
            emoticonTabItem0.setIconOnImage(emoticonTabAdapter$TabViewHolder0.emoticonBtn);
        }
        else {
            emoticonTabAdapter$TabViewHolder0.emoticonBg.setSelected(false);
            emoticonTabItem0.setIconImage(emoticonTabAdapter$TabViewHolder0.emoticonBtn);
        }
        FrameLayout frameLayout0 = emoticonTabAdapter$TabViewHolder0.emoticonBg;
        if(this.selectedPosition == v) {
            z = true;
        }
        frameLayout0.setSelected(z);
    }

    public void onBindViewHolder(TabViewHolder emoticonTabAdapter$TabViewHolder0, int v, List list0) {
        this.onBindViewHolder(emoticonTabAdapter$TabViewHolder0, v);
    }

    @Override  // androidx.recyclerview.widget.j0
    public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        return this.onCreateViewHolder(viewGroup0, v);
    }

    public TabViewHolder onCreateViewHolder(ViewGroup viewGroup0, int v) {
        return new TabViewHolder(LayoutInflater.from(viewGroup0.getContext()).inflate(layout.emoticon_set_item, viewGroup0, false));
    }

    @Override  // com.kakao.emoticon.ui.tab.TabItemTouchHelperAdapter
    public void onItemDismiss(int v) {
        this.remove(v);
        ActionTracker.pushLog("A001", "14", null);
    }

    public void onItemDismiss(String s) {
        int v;
        for(v = 0; true; ++v) {
            if(v >= this.items.size()) {
                v = -1;
                break;
            }
            if(((EmoticonTabItem)this.items.get(v)).getItemId().equals(s)) {
                break;
            }
        }
        if(v > -1) {
            this.remove(v);
        }
    }

    @Override  // com.kakao.emoticon.ui.tab.TabItemTouchHelperAdapter
    public void onItemIdle(int v) {
        ActionTracker.pushLog("A001", "13", null);
        int v1 = this.selectedPosition;
        if(v1 != v) {
            this.selectedPosition = v;
            new Handler().post(() -> {
                this.notifyItemChanged(v);
                this.notifyItemChanged(v1);
            });
        }
        TabListener emoticonTabAdapter$TabListener0 = this.tabListener;
        if(emoticonTabAdapter$TabListener0 != null && this.startDraggingPosition != v) {
            emoticonTabAdapter$TabListener0.onTabMoved(this.items, v);
        }
        EmoticonManager.INSTANCE.updateEmoticonTab(this.items);
    }

    @Override  // com.kakao.emoticon.ui.tab.TabItemTouchHelperAdapter
    public void onItemMove(int v, int v1) {
        EmoticonTabItem emoticonTabItem0 = (EmoticonTabItem)this.items.get(v);
        if(emoticonTabItem0 != null) {
            this.items.remove(v);
            this.items.add(v1, emoticonTabItem0);
        }
        int v2 = this.selectedPosition;
        if(v == v2) {
            this.selectedPosition = v1;
        }
        else if(v < v2 && v1 >= v2) {
            this.selectedPosition = v2 - 1;
        }
        else if(v > v2 && v1 <= v2) {
            this.selectedPosition = v2 + 1;
        }
        this.notifyItemMoved(v, v1);
    }

    @Override  // com.kakao.emoticon.ui.tab.TabItemTouchHelperAdapter
    public void onItemSelected(int v) {
        this.startDraggingPosition = v;
    }

    public void release() {
        List list0 = this.items;
        if(list0 == null) {
            return;
        }
        list0.clear();
        this.items = null;
    }

    public void remove(int v) {
        this.items.remove(v);
        this.notifyItemRemoved(v);
        EmoticonManager.INSTANCE.updateEmoticonTab(this.items);
        int v1 = this.selectedPosition;
        if(v < v1) {
            this.selectedPosition = v1 - 1;
        }
        else if(v1 == v) {
            int v2 = this.findRightNearSelectableItem(v - 1);
            this.selectedPosition = v2;
            if(v2 != -1) {
                this.notifyItemChanged(v2);
            }
        }
        TabListener emoticonTabAdapter$TabListener0 = this.tabListener;
        if(emoticonTabAdapter$TabListener0 != null) {
            emoticonTabAdapter$TabListener0.onTabDeleted(this.items, this.selectedPosition);
        }
    }

    public void scrollToTabPageIndex(LinearLayoutManager linearLayoutManager0, String s) {
        if(this.items != null && !this.items.isEmpty()) {
            for(int v = 0; v < this.items.size(); ++v) {
                if(s.equals(((EmoticonTabItem)this.items.get(v)).getItemId())) {
                    this.selectedPosition = v;
                    linearLayoutManager0.scrollToPosition(v);
                    return;
                }
            }
        }
    }

    public void setItems(List list0) {
        this.items = list0;
    }

    public void setOnTabListener(TabListener emoticonTabAdapter$TabListener0) {
        this.tabListener = emoticonTabAdapter$TabListener0;
    }

    public void setSelectedPosition(String s) {
        if(this.items == null) {
            this.selectedPosition = -1;
            return;
        }
        if(s != null) {
            for(int v1 = 0; v1 < this.items.size(); ++v1) {
                if(s.equals(((EmoticonTabItem)this.items.get(v1)).getItemId())) {
                    this.selectedPosition = v1;
                    return;
                }
            }
        }
        for(int v = 0; v < this.items.size(); ++v) {
            if(((EmoticonTabItem)this.items.get(v)) instanceof DefaultItem) {
                this.selectedPosition = v;
                return;
            }
        }
        this.selectedPosition = -1;
    }

    public void updateSelectedPosition(int v) {
        if(this.items.size() > v) {
            int v1 = this.selectedPosition;
            if(((EmoticonTabItem)this.items.get(v)).isSelectable()) {
                this.selectedPosition = v;
            }
            this.notifyItemChanged(v1, "item_update");
            this.notifyItemChanged(this.selectedPosition, "item_update");
        }
    }
}

