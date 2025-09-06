package com.kakao.emoticon.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.db.model.EmoticonResource;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.widget.EmoticonView;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.ScreenUtils;
import java.util.ArrayList;
import java.util.List;

public class DefaultEmoticonAdapter extends a {
    private static final int MAX_ROW_COUNT = 3;
    private Context context;
    private Emoticon emoticon;
    private int emoticonCountPerPage;
    private LayoutInflater inflater;
    private List list;
    private EmoticonClickListener listener;
    private int pageCount;

    public DefaultEmoticonAdapter(Context context0) {
        this.inflater = LayoutInflater.from(context0);
        this.context = context0;
    }

    @Override  // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup0, int v, Object object0) {
        viewGroup0.removeView(((View)object0));
    }

    @Override  // androidx.viewpager.widget.a
    public int getCount() {
        return this.pageCount;
    }

    public Emoticon getEmoticon() {
        return this.emoticon;
    }

    public EmoticonResource getItem(int v) {
        return (EmoticonResource)this.getItems().get(v);
    }

    private List getItems() {
        return this.list;
    }

    private View getView(int v, ViewGroup viewGroup0) {
        View view0 = this.inflater.inflate(layout.default_emoticon_grid_item, viewGroup0, false);
        EmoticonView emoticonView0 = (EmoticonView)view0.findViewById(id.emoticon_icon);
        if(v < this.getItems().size()) {
            EmoticonResource emoticonResource0 = this.getItem(v);
            if(emoticonResource0 != null) {
                EmoticonViewParam emoticonViewParam0 = EmoticonResource.convertToEmoticonParam(emoticonResource0, this.emoticon.getVersion(), this.emoticon.getItemSubType());
                emoticonView0.loadThumbnail(emoticonViewParam0, null);
                view0.setOnClickListener(new DoubleClickListener() {
                    @Override  // com.kakao.emoticon.ui.DoubleClickListener
                    public void onDoubleClick(View view0) {
                        ActionTracker.incrementContentCount();
                        DefaultEmoticonAdapter.this.onEmoticonClicked(emoticonViewParam0, true);
                    }

                    @Override  // com.kakao.emoticon.ui.DoubleClickListener
                    public void onSingleClick(View view0) {
                        ActionTracker.incrementContentCount();
                        DefaultEmoticonAdapter.this.onEmoticonClicked(emoticonViewParam0, false);
                    }
                });
                return view0;
            }
        }
        return view0;
    }

    @Override  // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup0, int v) {
        int v1 = this.emoticonCountPerPage;
        View view0 = this.inflater.inflate(layout.default_emoticon_view, viewGroup0, false);
        FloatingLayout floatingLayout0 = (FloatingLayout)view0.findViewById(id.root);
        for(int v2 = 0; v2 < v1; ++v2) {
            floatingLayout0.addView(this.getView(v * v1 + v2, floatingLayout0));
        }
        viewGroup0.addView(view0);
        return view0;
    }

    @Override  // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view0, Object object0) {
        return view0 == object0;
    }

    private void makeEmoticonResources(Emoticon emoticon0) {
        List list0 = this.list;
        if(list0 != null) {
            list0.clear();
            this.list = null;
        }
        if(emoticon0 == null) {
            this.pageCount = 0;
            this.emoticonCountPerPage = 0;
            return;
        }
        int v = emoticon0.getResourceCount();
        this.list = new ArrayList();
        for(int v1 = 1; v1 <= v; ++v1) {
            this.list.add(new EmoticonResource(emoticon0.getId(), v1));
        }
        this.recalcPageCount();
    }

    private void onEmoticonClicked(EmoticonViewParam emoticonViewParam0, boolean z) {
        EmoticonClickListener emoticonClickListener0 = this.listener;
        if(emoticonClickListener0 == null) {
            return;
        }
        if(z) {
            emoticonClickListener0.onEmoticonDoubleClick(emoticonViewParam0);
            return;
        }
        emoticonClickListener0.onEmoticonClick(emoticonViewParam0);
    }

    public void reCalcLayout(int v, int v1) {
        int v2 = this.context.getResources().getDimensionPixelSize(dimen.emoticon_grid_padding);
        int v3 = this.context.getResources().getDimensionPixelSize(dimen.emoticon_view_padding);
        int v4 = this.context.getResources().getDimensionPixelSize((ScreenUtils.INSTANCE.isLandscape() ? dimen.emoticon_width_land : dimen.emoticon_width));
        int v5 = v1 / (this.context.getResources().getDimensionPixelSize((ScreenUtils.INSTANCE.isLandscape() ? dimen.emoticon_height_land : dimen.emoticon_height)) + v2 * 2);
        if(v5 > 3) {
            v5 = 3;
        }
        else if(v5 == 0) {
            v5 = 1;
        }
        this.emoticonCountPerPage = v5 * ((v - v3 * 2) / (v4 + v2 * 2));
        this.recalcPageCount();
        stringBuilder0.toString();
    }

    private void recalcPageCount() {
        if(this.getItems() != null && !this.getItems().isEmpty() && this.emoticonCountPerPage != 0) {
            this.pageCount = (int)Math.ceil(((double)this.getItems().size()) / ((double)this.emoticonCountPerPage));
            return;
        }
        this.pageCount = 0;
    }

    public void setEmoticon(Emoticon emoticon0) {
        this.emoticon = emoticon0;
        this.makeEmoticonResources(emoticon0);
    }

    public void setEmoticonViewListener(EmoticonClickListener emoticonClickListener0) {
        this.listener = emoticonClickListener0;
    }
}

