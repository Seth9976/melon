package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.widget.EmoticonPullToRefreshLayout;

public final class LayoutEmoticonDownloadBinding implements a {
    private final EmoticonPullToRefreshLayout rootView;
    public final RecyclerView rvDownload;
    public final EmoticonPullToRefreshLayout swipeLayout;

    private LayoutEmoticonDownloadBinding(EmoticonPullToRefreshLayout emoticonPullToRefreshLayout0, RecyclerView recyclerView0, EmoticonPullToRefreshLayout emoticonPullToRefreshLayout1) {
        this.rootView = emoticonPullToRefreshLayout0;
        this.rvDownload = recyclerView0;
        this.swipeLayout = emoticonPullToRefreshLayout1;
    }

    public static LayoutEmoticonDownloadBinding bind(View view0) {
        RecyclerView recyclerView0 = (RecyclerView)view0.findViewById(id.rv_download);
        if(recyclerView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0A1A));  // id:rv_download
        }
        return new LayoutEmoticonDownloadBinding(((EmoticonPullToRefreshLayout)view0), recyclerView0, ((EmoticonPullToRefreshLayout)view0));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public EmoticonPullToRefreshLayout getRoot() {
        return this.rootView;
    }

    public static LayoutEmoticonDownloadBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutEmoticonDownloadBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutEmoticonDownloadBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_emoticon_download, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutEmoticonDownloadBinding.bind(view0);
    }
}

