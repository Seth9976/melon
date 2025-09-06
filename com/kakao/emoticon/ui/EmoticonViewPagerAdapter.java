package com.kakao.emoticon.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.ui.tab.EmoticonTabItem;
import java.util.ArrayList;
import java.util.List;

public class EmoticonViewPagerAdapter extends a {
    private Context context;
    private EmoticonClickListener emoticonClickListener;
    private List tabItems;

    public EmoticonViewPagerAdapter(Context context0) {
        this.tabItems = new ArrayList();
        this.context = context0;
    }

    @Override  // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup0, int v, Object object0) {
        if(object0 instanceof View) {
            viewGroup0.removeView(((View)object0));
        }
    }

    @Override  // androidx.viewpager.widget.a
    public int getCount() {
        return this.tabItems.size();
    }

    @Override  // androidx.viewpager.widget.a
    public int getItemPosition(Object object0) {
        return -2;
    }

    @Override  // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup0, int v) {
        View view0 = ((EmoticonTabItem)this.tabItems.get(v)).provideView(this.context);
        if(view0 != null) {
            viewGroup0.addView(view0);
        }
        return view0;
    }

    @Override  // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view0, Object object0) {
        return view0 == object0;
    }

    public void setEmoticonClickListener(EmoticonClickListener emoticonClickListener0) {
        this.emoticonClickListener = emoticonClickListener0;
    }

    public void setItems(List list0) {
        this.tabItems.clear();
        for(Object object0: list0) {
            EmoticonTabItem emoticonTabItem0 = (EmoticonTabItem)object0;
            if(emoticonTabItem0.hasContentsView()) {
                this.tabItems.add(emoticonTabItem0);
            }
        }
        this.notifyDataSetChanged();
    }
}

