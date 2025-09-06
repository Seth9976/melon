package com.kakao.emoticon.ui;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.ui.tab.EmoticonTabAdapter.TabListener;
import com.kakao.emoticon.ui.tab.EmoticonTabAdapter;
import java.util.List;
import java.util.Objects;

public class EmoticonViewPagerCoordinator implements j {
    private EmoticonTabAdapter tabAdapter;
    private RecyclerView tabRecyclerView;
    private EmoticonViewPagerAdapter viewAdapter;
    private ViewPager viewPager;

    public EmoticonViewPagerCoordinator(Context context0, EmoticonClickListener emoticonClickListener0, ViewPager viewPager0, RecyclerView recyclerView0, EmoticonTabAdapter emoticonTabAdapter0) {
        this.viewPager = viewPager0;
        EmoticonViewPagerAdapter emoticonViewPagerAdapter0 = new EmoticonViewPagerAdapter(context0);
        this.viewAdapter = emoticonViewPagerAdapter0;
        emoticonViewPagerAdapter0.setEmoticonClickListener(emoticonClickListener0);
        this.viewPager.setOffscreenPageLimit(1);
        this.viewPager.setAdapter(this.viewAdapter);
        this.viewPager.addOnPageChangeListener(this);
        this.tabRecyclerView = recyclerView0;
        this.tabAdapter = emoticonTabAdapter0;
        com.kakao.emoticon.ui.EmoticonViewPagerCoordinator.1 emoticonViewPagerCoordinator$10 = new TabListener() {
            @Override  // com.kakao.emoticon.ui.tab.EmoticonTabAdapter$TabListener
            public void onTabClicked(int v) {
                viewPager0.setCurrentItem(v, false);
            }

            @Override  // com.kakao.emoticon.ui.tab.EmoticonTabAdapter$TabListener
            public void onTabDeleted(List list0, int v) {
                EmoticonViewPagerCoordinator.access$000(EmoticonViewPagerCoordinator.this).setItems(list0);
                viewPager0.setCurrentItem(v);
            }

            @Override  // com.kakao.emoticon.ui.tab.EmoticonTabAdapter$TabListener
            public void onTabMoved(List list0, int v) {
                EmoticonViewPagerCoordinator.this.viewAdapter.setItems(list0);
                if(viewPager0.getCurrentItem() != v) {
                    viewPager0.setCurrentItem(v);
                    return;
                }
                EmoticonViewPagerCoordinator.access$100(EmoticonViewPagerCoordinator.this, v);
            }
        };
        this.tabAdapter.setOnTabListener(emoticonViewPagerCoordinator$10);
    }

    public static void access$100(EmoticonViewPagerCoordinator emoticonViewPagerCoordinator0, int v) {
        emoticonViewPagerCoordinator0.itemSelectionChanged(v);
    }

    private void itemSelectionChanged(int v) {
        boolean z = this.tabAdapter.getItem(v) == null;
    }

    public void onConfigurationChanged() {
        this.reloadView();
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageScrollStateChanged(int v) {
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageScrolled(int v, float f, int v1) {
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageSelected(int v) {
        if(this.tabAdapter != null) {
            RecyclerView recyclerView0 = this.tabRecyclerView;
            if(recyclerView0 != null) {
                int v1 = 3;
                w0 w00 = recyclerView0.getLayoutManager();
                Objects.requireNonNull(w00);
                if(v < ((LinearLayoutManager)w00).findLastCompletelyVisibleItemPosition()) {
                    this.tabRecyclerView.getLayoutManager().scrollToPosition(v);
                }
                else {
                    if(v != this.tabAdapter.getItemCount() - 3) {
                        v1 = 2;
                    }
                    int v2 = this.tabRecyclerView.getWidth();
                    int v3 = this.tabRecyclerView.getContext().getResources().getDimensionPixelSize(dimen.emoticon_tab_width);
                    ((LinearLayoutManager)this.tabRecyclerView.getLayoutManager()).scrollToPositionWithOffset(v, v2 - v3 * v1);
                }
            }
            this.tabAdapter.getItem(v).actionTrack();
            this.tabAdapter.updateSelectedPosition(v);
            this.itemSelectionChanged(v);
        }
    }

    private void reloadView() {
        if(this.viewAdapter != null) {
            int v = this.viewPager.getCurrentItem();
            this.viewPager.setAdapter(this.viewAdapter);
            this.viewAdapter.notifyDataSetChanged();
            this.viewPager.setCurrentItem(v);
        }
    }

    public void setCurrentItem(int v) {
        this.viewPager.setCurrentItem(v, false);
    }

    public void setItems(List list0) {
        this.viewAdapter.setItems(list0);
    }
}

