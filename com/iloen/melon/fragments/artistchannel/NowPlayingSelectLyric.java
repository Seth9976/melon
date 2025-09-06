package com.iloen.melon.fragments.artistchannel;

import F8.B;
import F8.m;
import F8.o;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.NowplayingInformSongInfoReq;
import com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import v9.h;
import v9.i;

public class NowPlayingSelectLyric extends MetaContentBaseFragment {
    public static class LyricAdapter extends p {
        public interface OnItemSelectListener {
            void onItemSelect(int arg1);
        }

        private static final int VIEW_ITEM_LYRIC = 1;
        private int mDefaultTextCololr;
        private OnItemSelectListener mItemSelectListener;
        private int mSelectPosition;
        private int mSelectedTextColor;

        public LyricAdapter(Context context0, List list0) {
            super(context0, list0);
            this.mSelectPosition = -2;
            this.mSelectedTextColor = ColorUtils.getColor(context0, 0x7F06017C);  // color:green500s_support_high_contrast
            this.mDefaultTextCololr = ColorUtils.getColor(context0, 0x7F060169);  // color:gray850s
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(1 == o00.getItemViewType()) {
                String s = (String)this.getItem(v1);
                ((LyricItemViewHolder)o00).itemRow.setText(s);
                if(v1 == this.mSelectPosition || v1 == this.mSelectPosition + 1) {
                    ((LyricItemViewHolder)o00).itemRow.setTextColor(this.mSelectedTextColor);
                }
                else {
                    ((LyricItemViewHolder)o00).itemRow.setTextColor(this.mDefaultTextCololr);
                }
                ViewUtils.setOnClickListener(((LyricItemViewHolder)o00).itemRow, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        LyricAdapter.this.mSelectPosition = v1;
                        if(LyricAdapter.this.mItemSelectListener != null) {
                            LyricAdapter.this.mItemSelectListener.onItemSelect(v1);
                        }
                        LyricAdapter.this.notifyDataSetChanged();
                    }
                });
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return 1 == v ? new LyricItemViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0589, viewGroup0, false)) : null;  // layout:nowplaying_lyric_item
        }

        public void setOnItemSelectListener(OnItemSelectListener nowPlayingSelectLyric$LyricAdapter$OnItemSelectListener0) {
            this.mItemSelectListener = nowPlayingSelectLyric$LyricAdapter$OnItemSelectListener0;
        }
    }

    public static class LyricItemViewHolder extends O0 {
        public TextView itemRow;

        public LyricItemViewHolder(View view0) {
            super(view0);
            this.itemRow = (TextView)view0.findViewById(0x7F0A059A);  // id:item
        }
    }

    public static final String ARG_FIRST_SELECTED_LYRIC = "argFirstSelectedLyric";
    public static final String ARG_SECOND_SELECTED_LYRIC = "argSecondSelectedLyric";
    public static final String ARG_SONG_ID = "argSongId";
    private static final int INVALID_POSITION = -2;
    private static final String TAG = "ArtistChannelNowPlayingSelectLyric";
    private int mSelectPosition;
    private String mSongId;

    public NowPlayingSelectLyric() {
        this.mSelectPosition = -2;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new LyricAdapter(context0, null);
        ((LyricAdapter)j00).setOnItemSelectListener(new OnItemSelectListener() {
            @Override  // com.iloen.melon.fragments.artistchannel.NowPlayingSelectLyric$LyricAdapter$OnItemSelectListener
            public void onItemSelect(int v) {
                NowPlayingSelectLyric.this.mSelectPosition = v;
            }
        });
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.b.buildUpon().appendPath("nowPlayingSelectLyric").appendQueryParameter("songId", this.mSongId).build().toString();
    }

    private List getLyricArrayList(String s) {
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        List list0 = new ArrayList();
        String[] arr_s = s.split("\\n");
        if(arr_s != null) {
            for(int v = 0; v < arr_s.length; ++v) {
                String s1 = arr_s[v];
                if(!TextUtils.isEmpty(s1)) {
                    ((ArrayList)list0).add(s1);
                }
            }
        }
        return list0;
    }

    public static NowPlayingSelectLyric newInstance(String s) {
        NowPlayingSelectLyric nowPlayingSelectLyric0 = new NowPlayingSelectLyric();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argSongId", s);
        nowPlayingSelectLyric0.setArguments(bundle0);
        return nowPlayingSelectLyric0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mSongId = bundle0.getString("argSongId");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D058A, viewGroup0, false);  // layout:nowplaying_select_lyric
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        j0 j00 = this.mAdapter;
        if(!(j00 instanceof LyricAdapter)) {
            return false;
        }
        ((LyricAdapter)j00).clear();
        RequestBuilder.newInstance(new NowplayingInformSongInfoReq(this.getContext(), this.mSongId)).tag("ArtistChannelNowPlayingSelectLyric").listener(new Listener() {
            public void onResponse(NowplayingInformSongInfoRes nowplayingInformSongInfoRes0) {
                if(!NowPlayingSelectLyric.this.prepareFetchComplete(nowplayingInformSongInfoRes0)) {
                    return;
                }
                RESPONSE nowplayingInformSongInfoRes$RESPONSE0 = nowplayingInformSongInfoRes0.response;
                if(nowplayingInformSongInfoRes$RESPONSE0 != null) {
                    List list0 = NowPlayingSelectLyric.this.getLyricArrayList(nowplayingInformSongInfoRes$RESPONSE0.lyric);
                    if(list0 != null) {
                        ((LyricAdapter)j00).addAll(list0);
                    }
                    ((LyricAdapter)j00).setHasMore(false);
                    String s = NowPlayingSelectLyric.this.getCacheKey();
                    ((LyricAdapter)j00).updateModifiedTime(s);
                }
                NowPlayingSelectLyric.this.performFetchCompleteOnlyViews();
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((NowplayingInformSongInfoRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            F8.p p0 = new F8.p(1);
            m m0 = new m(2, false);
            B b0 = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
            b0.h(this.getString(0x7F130AF8));  // string:talkback_complete_btn "완료 버튼"
            b0.c = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(NowPlayingSelectLyric.this.mSelectPosition == -2) {
                        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(NowPlayingSelectLyric.this.getActivity(), 0, "안내", "가사를 선택하세요.", null);
                        melonTextPopup0.setOnDismissListener(NowPlayingSelectLyric.this.mDialogDismissListener);
                        NowPlayingSelectLyric.this.mRetainDialog = melonTextPopup0;
                        melonTextPopup0.show();
                        return;
                    }
                    NowPlayingSelectLyric.this.setResult();
                }
            };
            o[] arr_o = {p0, m0, b0};
            o o0 = null;
            for(int v = 0; v < 3; ++v) {
                o o1 = arr_o[v];
                if(o0 == null) {
                    o0 = o1;
                }
                else {
                    o0.g(o1);
                }
            }
            titleBar0.a(o0);
            titleBar0.setTitle(this.getString(0x7F13014F));  // string:artist_info_select_lyric "가사 선택"
            titleBar0.f(true);
        }
    }

    private void setResult() {
        String s2;
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            LogU.w("ArtistChannelNowPlayingSelectLyric", "addResult() invalid activity");
            return;
        }
        j0 j00 = this.mAdapter;
        String s = null;
        if(j00 instanceof LyricAdapter) {
            int v = ((LyricAdapter)j00).getItemCount();
            String s1 = v <= this.mSelectPosition ? null : ((String)((LyricAdapter)j00).getItem(this.mSelectPosition));
            int v1 = this.mSelectPosition;
            if(v > v1 + 1) {
                s = (String)((LyricAdapter)j00).getItem(v1 + 1);
            }
            s2 = s;
            s = s1;
        }
        else {
            s2 = null;
        }
        Intent intent0 = new Intent();
        intent0.putExtra("argFirstSelectedLyric", s);
        intent0.putExtra("argSecondSelectedLyric", s2);
        if(fragmentActivity0.getParent() == null) {
            fragmentActivity0.setResult(-1, intent0);
        }
        else {
            fragmentActivity0.getParent().setResult(-1, intent0);
        }
        fragmentActivity0.getOnBackPressedDispatcher().c();
    }
}

