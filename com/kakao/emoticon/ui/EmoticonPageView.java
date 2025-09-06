package com.kakao.emoticon.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.widget.EmoticonGridAdapter;
import com.kakao.emoticon.util.ScreenUtils;

@SuppressLint({"ViewConstructor"})
public class EmoticonPageView extends FrameLayout {
    public EmoticonPageView(Context context0, Emoticon emoticon0, EmoticonClickListener emoticonClickListener0) {
        super(context0, null, 0);
        this.init(context0, emoticon0, emoticonClickListener0);
    }

    private static int getMaxSpanSize(Context context0) {
        int v = ScreenUtils.INSTANCE.getWidth(context0);
        int v1 = context0.getResources().getDimensionPixelSize(dimen.emoticon_width);
        int v2 = context0.getResources().getDimensionPixelSize(dimen.emoticon_keyboard_grid_horizontal_space);
        return (v - context0.getResources().getDimensionPixelSize(dimen.emoticon_keyboard_side_margin) * 2) / (v1 + v2);
    }

    private void init(Context context0, Emoticon emoticon0, EmoticonClickListener emoticonClickListener0) {
        View.inflate(context0, layout.emoticon_grid_view, this);
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(id.emoticon_grid);
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new GridLayoutManager(context0, EmoticonPageView.getMaxSpanSize(context0)));
        recyclerView0.setAdapter(new EmoticonGridAdapter(emoticon0, emoticonClickListener0));
    }
}

