package com.kakao.emoticon.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.fragments.present.a;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.activity.helper.DragSortTouchHelperAdapter;
import com.kakao.emoticon.activity.helper.OnStartDragListener;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.net.response.Emoticon;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmoticonEditAdapter extends j0 implements DragSortTouchHelperAdapter {
    public static class EmoticonHeaderViewHolder extends O0 {
        public EmoticonHeaderViewHolder(View view0) {
            super(view0);
            view0.findViewById(id.tv_list_guide).setVisibility(8);
        }
    }

    public static class EmoticonSetViewHolder extends O0 {
        ImageView emoticonIcon;
        TextView emoticonName;
        View handleView;
        LinearLayout layout;

        public EmoticonSetViewHolder(View view0) {
            super(view0);
            this.layout = (LinearLayout)view0.findViewById(id.layout_edit);
            this.emoticonIcon = (ImageView)view0.findViewById(id.emoticon_icon);
            this.emoticonName = (TextView)view0.findViewById(id.emoticon_set_name);
            this.handleView = view0.findViewById(id.emoticon_handler);
        }
    }

    private final OnStartDragListener dragStartListener;
    private boolean isHandleSelected;
    private boolean isReOrder;
    private List items;
    private final LayoutInflater layoutInflater;
    private final Set selectedItemIds;

    public EmoticonEditAdapter(Context context0, List list0, OnStartDragListener onStartDragListener0) {
        this.selectedItemIds = new HashSet();
        this.isReOrder = false;
        this.isHandleSelected = false;
        this.items = list0;
        this.dragStartListener = onStartDragListener0;
        this.layoutInflater = (LayoutInflater)context0.getSystemService("layout_inflater");
    }

    public static void b(EmoticonEditAdapter emoticonEditAdapter0, O0 o00, View view0) {
        emoticonEditAdapter0.lambda$onBindViewHolder$0(o00, view0);
    }

    public void clearSelectedItems() {
        this.selectedItemIds.clear();
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        return this.items == null ? 0 : this.items.size() + 1;
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemViewType(int v) {
        return v == 0 ? 0 : 1;
    }

    public Set getSelectedItems() {
        return this.selectedItemIds;
    }

    public boolean isReOrder() {
        return this.isReOrder;
    }

    private void lambda$onBindViewHolder$0(O0 o00, View view0) {
        if(!this.isHandleSelected) {
            Emoticon emoticon0 = (Emoticon)this.items.get(o00.getAdapterPosition() - 1);
            if(emoticon0 != null) {
                this.setSelectedItem(emoticon0.getId());
                this.notifyItemRangeChanged(o00.getAdapterPosition(), 1);
            }
        }
    }

    // 检测为 Lambda 实现
    private boolean lambda$onBindViewHolder$1(O0 o00, View view0, MotionEvent motionEvent0) [...]

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v) {
        if(o00 instanceof EmoticonSetViewHolder) {
            Emoticon emoticon0 = (Emoticon)this.items.get(o00.getAdapterPosition() - 1);
            ((EmoticonSetViewHolder)o00).emoticonName.setText(emoticon0.getTitle());
            if(this.selectedItemIds.contains(emoticon0.getId())) {
                ((EmoticonSetViewHolder)o00).layout.setBackgroundResource(drawable.bar_select);
            }
            else {
                ((EmoticonSetViewHolder)o00).layout.setBackgroundResource(drawable.bar_default);
            }
            if(((EmoticonSetViewHolder)o00).emoticonIcon.getTag() == null || !((EmoticonSetViewHolder)o00).emoticonIcon.getTag().equals(emoticon0.getId())) {
                ((EmoticonSetViewHolder)o00).emoticonIcon.setTag(emoticon0.getId());
                EmoticonResourceLoader.INSTANCE.loadTitle(((EmoticonSetViewHolder)o00).emoticonIcon, emoticon0);
            }
            a a0 = new a(5, this, ((EmoticonSetViewHolder)o00));
            o00.itemView.setOnClickListener(a0);
            ((EmoticonSetViewHolder)o00).handleView.setOnTouchListener((View view0, MotionEvent motionEvent0) -> {
                if(motionEvent0.getAction() == 0) {
                    this.isHandleSelected = true;
                    this.dragStartListener.onStartDrag(((EmoticonSetViewHolder)o00));
                }
                return false;
            });
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        return v == 0 ? new EmoticonHeaderViewHolder(this.layoutInflater.inflate(layout.layout_list_guide, viewGroup0, false)) : new EmoticonSetViewHolder(this.layoutInflater.inflate(layout.emoticon_edit_item, viewGroup0, false));
    }

    @Override  // com.kakao.emoticon.activity.helper.DragSortTouchHelperAdapter
    public void onItemClear() {
        this.isHandleSelected = false;
    }

    @Override  // com.kakao.emoticon.activity.helper.DragSortTouchHelperAdapter
    public void onItemMove(int v, int v1) {
        Emoticon emoticon0 = (Emoticon)this.items.remove(v - 1);
        this.items.add(v1 - 1, emoticon0);
        this.isReOrder = true;
        this.notifyItemMoved(v, v1);
    }

    public void setEmoticonList(List list0) {
        this.items = list0;
        this.notifyDataSetChanged();
    }

    private void setSelectedItem(String s) {
        if(this.selectedItemIds.contains(s)) {
            this.selectedItemIds.remove(s);
            return;
        }
        this.selectedItemIds.add(s);
    }
}

