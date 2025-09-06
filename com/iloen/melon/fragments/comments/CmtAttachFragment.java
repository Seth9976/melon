package com.iloen.melon.fragments.comments;

import a9.d;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.android.volley.Response.Listener;
import com.iloen.melon.activity.CmtAttachActivity;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.RecyclerViewWithEmptyView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.V0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.ListMusicReq.Params;
import com.iloen.melon.net.v3x.comments.ListMusicReq.SortType;
import com.iloen.melon.net.v3x.comments.ListMusicReq;
import com.iloen.melon.net.v3x.comments.ListMusicRes.result.MUSICLIST;
import com.iloen.melon.net.v3x.comments.ListMusicRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.SPAMINFO;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import v9.b;
import v9.e;
import v9.h;
import v9.i;

public class CmtAttachFragment extends CmtBaseFragment {
    class CmtAttachListAdapter extends p {
        private static final int VIEW_TYPE_ALBUM = 3;
        private static final int VIEW_TYPE_ARTIST = 4;
        private static final int VIEW_TYPE_SONG = 2;
        private static final int VIEW_TYPE_SORTBAR = 1;
        private static final int VIEW_TYPE_VIDEO = 5;

        public CmtAttachListAdapter(Context context0, List list0, MetaContentBaseFragment metaContentBaseFragment0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return !this.getList().isEmpty();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getHeaderViewItemCount() > 0 && v == this.getAvailableHeaderPosition()) {
                return 1;
            }
            if(CmtAttachFragment.this.mSearchType.equals("song")) {
                return 2;
            }
            if(CmtAttachFragment.this.mSearchType.equals("album")) {
                return 3;
            }
            if(CmtAttachFragment.this.mSearchType.equals("artist")) {
                return 4;
            }
            return CmtAttachFragment.this.mSearchType.equals("video") ? 5 : 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() != 1) {
                if(o00 instanceof CmtBaseViewHolder) {
                    ((CmtBaseViewHolder)o00).bindView(((MUSICLIST)this.getItem(v1)), v, v1);
                }
                return;
            }
            ((CmtAttachSortbarViewHolder)o00).setOnSortSelectionListener(new d() {
                @Override  // a9.d
                public void onSelected(int v) {
                    CmtAttachFragment cmtAttachFragment0 = CmtAttachFragment.this;
                    if(v == cmtAttachFragment0.mSortType) {
                        return;
                    }
                    cmtAttachFragment0.mSortType = v;
                    cmtAttachFragment0.mOrderBy = cmtAttachFragment0.convertSortTypeToOrderBy(v);
                    CmtAttachFragment.this.searchKeyword();
                }
            });
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    View view0 = this.mInflater.inflate(CmtAttachSortbarViewHolder.getLayoutRsId(CmtAttachFragment.this.mParam.theme), viewGroup0, false);
                    String[] arr_s = CmtAttachFragment.this.getSortingBarItems();
                    return new CmtAttachSortbarViewHolder(view0, CmtAttachFragment.this, arr_s);
                }
                case 2: {
                    return new CmtAttachSongViewHolder(this.mInflater.inflate(CmtAttachSongViewHolder.getLayoutRsId(CmtAttachFragment.this.mParam.theme), viewGroup0, false), CmtAttachFragment.this);
                }
                case 3: {
                    return new CmtAttachAlbumViewHolder(this.mInflater.inflate(CmtAttachAlbumViewHolder.getLayoutRsId(CmtAttachFragment.this.mParam.theme), viewGroup0, false), CmtAttachFragment.this);
                }
                case 4: {
                    return new CmtAttachArtistViewHolder(this.mInflater.inflate(CmtAttachArtistViewHolder.getLayoutRsId(CmtAttachFragment.this.mParam.theme), viewGroup0, false), CmtAttachFragment.this);
                }
                case 5: {
                    return new CmtAttachVideoViewHolder(this.mInflater.inflate(CmtAttachVideoViewHolder.getLayoutRsId(CmtAttachFragment.this.mParam.theme), viewGroup0, false), CmtAttachFragment.this);
                }
                default: {
                    return null;
                }
            }
        }
    }

    public static class CmtAttachViewType {
        public static final int LINKVIDEO = 2;
        public static final int MUSIC = 0;
        public static final int VIDEO = 1;

    }

    public interface OnCmtSearchAttachListener {
        void onSearch();
    }

    public static class Param extends com.iloen.melon.fragments.comments.CmtBaseFragment.Param {
        public String searchType;
        private static final long serialVersionUID = 0x227ADBCF8761D81AL;
        public SPAMINFO spamInfo;
        public int viewType;

        public Param() {
            this.viewType = 0;
            this.searchType = "song";
        }
    }

    private static final String TAG = "CmtAttachFragment";
    protected FrameLayout mFixedView;
    private String mKeyword;
    private int mNextPageNo;
    private OnCmtSearchAttachListener mOnCmtSearchAttachListener;
    protected int mOrderBy;
    private String mPrevKeyword;
    private SearchBarView mSearchBarView;
    protected String mSearchType;
    protected int mSortType;
    protected int mViewType;
    private static HashMap sMapArtistOrderBy;
    private static HashMap sMapArtistSortType;
    protected static HashMap sMapSearchOrderBy;
    protected static HashMap sMapSearchSortType;

    static {
        HashMap hashMap0 = new HashMap();
        CmtAttachFragment.sMapArtistOrderBy = hashMap0;
        hashMap0.put(0, SortType.ACCURACY);
        CmtAttachFragment.sMapArtistOrderBy.put(1, SortType.POPULARITY);
        CmtAttachFragment.sMapArtistOrderBy.put(2, SortType.ALPHABETICAL);
        CmtAttachFragment.sMapArtistOrderBy.put(3, SortType.RECENTLY);
        CmtAttachFragment.sMapArtistSortType = new HashMap();
        HashMap hashMap1 = CmtAttachFragment.sMapArtistOrderBy;
        if(hashMap1 != null) {
            for(Object object0: hashMap1.keySet()) {
                Integer integer0 = (Integer)object0;
                integer0.intValue();
                if(CmtAttachFragment.sMapArtistOrderBy.containsKey(integer0)) {
                    CmtAttachFragment.sMapArtistSortType.put(((Integer)CmtAttachFragment.sMapArtistOrderBy.get(integer0)), integer0);
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        CmtAttachFragment.sMapSearchOrderBy = hashMap2;
        hashMap2.put(0, SortType.ACCURACY);
        CmtAttachFragment.sMapSearchOrderBy.put(1, SortType.POPULARITY);
        CmtAttachFragment.sMapSearchOrderBy.put(2, SortType.RECENTLY);
        CmtAttachFragment.sMapArtistOrderBy.put(3, SortType.ALPHABETICAL);
        CmtAttachFragment.sMapSearchSortType = new HashMap();
        HashMap hashMap3 = CmtAttachFragment.sMapSearchOrderBy;
        if(hashMap3 != null) {
            for(Object object1: hashMap3.keySet()) {
                Integer integer1 = (Integer)object1;
                integer1.intValue();
                if(CmtAttachFragment.sMapSearchOrderBy.containsKey(integer1)) {
                    CmtAttachFragment.sMapSearchSortType.put(((Integer)CmtAttachFragment.sMapSearchOrderBy.get(integer1)), integer1);
                }
            }
        }
    }

    public CmtAttachFragment() {
        int v = this.getSortingBarDefaultOption();
        this.mSortType = v;
        this.mOrderBy = this.convertSortTypeToOrderBy(v);
        this.mNextPageNo = 1;
    }

    public void addAttachInfo(MUSICLIST listMusicRes$result$MUSICLIST0) {
        MediaAttachType mediaAttachType0;
        LogU.d("CmtAttachFragment", "addAttachInfo");
        if(listMusicRes$result$MUSICLIST0 != null) {
            MediaAttachInfo mediaAttachInfo0 = new MediaAttachInfo();
            String s = this.mSearchType;
            MediaAttachType[] arr_mediaAttachType = MediaAttachType.l;
            for(int v = 0; true; ++v) {
                mediaAttachType0 = null;
                if(v >= 10) {
                    break;
                }
                MediaAttachType mediaAttachType1 = arr_mediaAttachType[v];
                if(mediaAttachType1.b.equals(s)) {
                    mediaAttachType0 = mediaAttachType1;
                    break;
                }
            }
            mediaAttachInfo0.a = mediaAttachType0;
            mediaAttachInfo0.c = listMusicRes$result$MUSICLIST0.albumid;
            mediaAttachInfo0.d = listMusicRes$result$MUSICLIST0.artistid;
            mediaAttachInfo0.e = listMusicRes$result$MUSICLIST0.songid;
            mediaAttachInfo0.f = listMusicRes$result$MUSICLIST0.videoid;
            mediaAttachInfo0.i = listMusicRes$result$MUSICLIST0.albumname;
            mediaAttachInfo0.j = listMusicRes$result$MUSICLIST0.songname;
            String s1 = ListMusicRes.getArtistNames(listMusicRes$result$MUSICLIST0.artistlist);
            mediaAttachInfo0.k = s1;
            if(TextUtils.isEmpty(s1)) {
                mediaAttachInfo0.k = listMusicRes$result$MUSICLIST0.artistname;
            }
            mediaAttachInfo0.m = listMusicRes$result$MUSICLIST0.nationalityname;
            mediaAttachInfo0.o = listMusicRes$result$MUSICLIST0.sex;
            mediaAttachInfo0.n = listMusicRes$result$MUSICLIST0.acttypename;
            mediaAttachInfo0.r = listMusicRes$result$MUSICLIST0.gnr;
            mediaAttachInfo0.w = listMusicRes$result$MUSICLIST0.fancnt;
            mediaAttachInfo0.B = listMusicRes$result$MUSICLIST0.dsplyissuedate;
            mediaAttachInfo0.G = listMusicRes$result$MUSICLIST0.videoviewcnt;
            mediaAttachInfo0.I = listMusicRes$result$MUSICLIST0.adultflag;
            mediaAttachInfo0.M = listMusicRes$result$MUSICLIST0.holdbackflag;
            mediaAttachInfo0.N = listMusicRes$result$MUSICLIST0.freezoneflag;
            mediaAttachInfo0.W = this.mParam.theme;
            if(MediaAttachType.c.equals(mediaAttachInfo0.a) || MediaAttachType.d.equals(mediaAttachInfo0.a)) {
                if(!TextUtils.isEmpty(listMusicRes$result$MUSICLIST0.albumimagepath)) {
                    mediaAttachInfo0.g = listMusicRes$result$MUSICLIST0.albumimagepath;
                }
            }
            else if(!MediaAttachType.e.equals(mediaAttachInfo0.a)) {
                if(MediaAttachType.h.equals(mediaAttachInfo0.a)) {
                    if(!TextUtils.isEmpty(listMusicRes$result$MUSICLIST0.videoimagepath)) {
                        mediaAttachInfo0.g = listMusicRes$result$MUSICLIST0.videoimagepath;
                    }
                    mediaAttachInfo0.E = ListMusicRes.getMvTitle(listMusicRes$result$MUSICLIST0);
                    mediaAttachInfo0.I = listMusicRes$result$MUSICLIST0.videoadultflag;
                    mediaAttachInfo0.B = listMusicRes$result$MUSICLIST0.dsplyvideoissuedate;
                    mediaAttachInfo0.D = listMusicRes$result$MUSICLIST0.dsplyplaytime;
                    mediaAttachInfo0.S = b.c(listMusicRes$result$MUSICLIST0.videoagelevel);
                }
                else {
                    LogU.w("CmtAttachFragment", "addAttachInfo() invalid type:" + mediaAttachInfo0.a);
                }
            }
            else if(!TextUtils.isEmpty(listMusicRes$result$MUSICLIST0.artistimagepath)) {
                mediaAttachInfo0.g = listMusicRes$result$MUSICLIST0.artistimagepath;
            }
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null && fragmentActivity0 instanceof CmtAttachActivity) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(mediaAttachInfo0);
                Intent intent0 = new Intent();
                intent0.putExtra("attachResultValues", arrayList0);
                if(fragmentActivity0.getParent() == null) {
                    fragmentActivity0.setResult(-1, intent0);
                }
                else {
                    fragmentActivity0.getParent().setResult(-1, intent0);
                }
                fragmentActivity0.getOnBackPressedDispatcher().c();
                ToastManager.show(0x7F1301D9);  // string:cmt_attachment_add_message "첨부 되었습니다."
                return;
            }
            LogU.e("CmtAttachFragment", "addAttachInfo() invalid actvitiy");
        }
    }

    public void changeKeyword(String s) {
        Z.w("changeKeyword() keyword:", s, "CmtAttachFragment");
        this.mKeyword = s;
    }

    private void clearData() {
        if(this.getMelonArrayAdapter() != null) {
            this.getMelonArrayAdapter().clear(false);
        }
    }

    // 去混淆评级： 低(30)
    public int convertOrderByToSortType(int v) {
        return this.mSearchType == null || !this.mSearchType.equals("artist") ? ((int)(((Integer)CmtAttachFragment.sMapSearchSortType.get(v)))) : ((int)(((Integer)CmtAttachFragment.sMapArtistSortType.get(v))));
    }

    // 去混淆评级： 低(30)
    public int convertSortTypeToOrderBy(int v) {
        return this.mSearchType == null || !this.mSearchType.equals("artist") ? ((int)(((Integer)CmtAttachFragment.sMapSearchOrderBy.get(v)))) : ((int)(((Integer)CmtAttachFragment.sMapArtistOrderBy.get(v))));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new CmtAttachListAdapter(this, context0, null, this);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F1301DB);  // string:cmt_attachment_search_empty_text "검색 후 첨부할 콘텐츠를 선택하세요."
        ((p)j00).setEmptyViewResId(0x7F0D0023);  // layout:adapter_empty_view_search
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.g.buildUpon().appendPath("cmtattach").appendQueryParameter("viewType", String.valueOf(this.mViewType)).appendQueryParameter("searchType", this.mSearchType).appendQueryParameter("orderBy", String.valueOf(this.mOrderBy)).appendQueryParameter("keyword", this.mKeyword).build().toString();
    }

    // 去混淆评级： 低(20)
    public int getSortingBarDefaultOption() {
        if(this.mSearchType == null || this.mSearchType.equals("song")) {
            return this.convertOrderByToSortType(SortType.ACCURACY);
        }
        if(this.mSearchType.equals("video")) {
            return this.convertOrderByToSortType(SortType.ACCURACY);
        }
        if(this.mSearchType.equals("album")) {
            return this.convertOrderByToSortType(SortType.ACCURACY);
        }
        return this.mSearchType.equals("artist") ? this.convertOrderByToSortType(SortType.ACCURACY) : this.convertOrderByToSortType(SortType.ACCURACY);
    }

    // 去混淆评级： 低(30)
    public String[] getSortingBarItems() {
        return this.mSearchType == null || !this.mSearchType.equals("artist") ? this.getResources().getStringArray(0x7F03004B) : this.getResources().getStringArray(0x7F030033);  // array:sortingbar_search
    }

    public static CmtAttachFragment newInstance(Param cmtAttachFragment$Param0) {
        CmtAttachFragment cmtAttachFragment0 = new CmtAttachFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("argCmtParam", cmtAttachFragment$Param0);
        cmtAttachFragment0.setArguments(bundle0);
        return cmtAttachFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        LogU.d("CmtAttachFragment", "onCreate()");
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        LogU.d("CmtAttachFragment", "Layout theme = " + this.mParam.theme);
        return layoutInflater0.inflate(0x7F0D02A0, viewGroup0, false);  // layout:fragment_cmt_attach_list
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Z.x(a.n("onFetchStart reason:", s, " , keyword = "), this.mKeyword, "CmtAttachFragment");
        if(this.mKeyword != null && !this.mKeyword.trim().equals("")) {
            if(i.b.equals(i0)) {
                this.mNextPageNo = 1;
            }
            Params listMusicReq$Params0 = new Params();
            listMusicReq$Params0.srchWord = this.mKeyword;
            listMusicReq$Params0.musicType = this.mSearchType;
            listMusicReq$Params0.sortType = this.mOrderBy;
            listMusicReq$Params0.pageNo = this.mNextPageNo;
            listMusicReq$Params0.pageSize = 100;
            RequestBuilder.newInstance(new ListMusicReq(this.getContext(), listMusicReq$Params0)).tag("CmtAttachFragment").listener(new Listener() {
                public void onResponse(ListMusicRes listMusicRes0) {
                    if(!CmtAttachFragment.this.prepareFetchComplete(listMusicRes0)) {
                        return;
                    }
                    if(listMusicRes0.isSuccessful()) {
                        CmtAttachListAdapter cmtAttachFragment$CmtAttachListAdapter0 = (CmtAttachListAdapter)CmtAttachFragment.this.getMelonArrayAdapter();
                        if(i.b.equals(i0)) {
                            CmtAttachFragment.this.clearData();
                        }
                        cmtAttachFragment$CmtAttachListAdapter0.addAll(listMusicRes0.result.musiclist);
                        cmtAttachFragment$CmtAttachListAdapter0.setHasMore(listMusicRes0.result.pageinfo.pageno < listMusicRes0.result.paginginfo.nextpageno);
                        cmtAttachFragment$CmtAttachListAdapter0.updateModifiedTime(CmtAttachFragment.this.getCacheKey());
                        CmtAttachFragment.this.mNextPageNo = listMusicRes0.result.paginginfo.nextpageno;
                        ArrayList arrayList0 = listMusicRes0.result.musiclist;
                        if(arrayList0 == null || arrayList0.size() == 0) {
                            e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                            e0.d = -1;
                            e0.e = -1;
                            e0.g = -1;
                            e0.i = -1;
                            e0.k = -1;
                            e0.l = -1;
                            e0.f = CmtAttachFragment.this.getString(0x7F13078F);  // string:no_search_result "검색 결과가 없습니다."
                            cmtAttachFragment$CmtAttachListAdapter0.setEmptyViewInfo(e0);
                        }
                        CmtAttachFragment.this.performFetchCompleteOnlyViews();
                        return;
                    }
                    CmtAttachFragment.this.performCmtFetchErrorToast(listMusicRes0.errormessage);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((ListMusicRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        LogU.d("CmtAttachFragment", "onFetchStart : Invalid mKeyword.");
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        SearchBarView searchBarView0 = this.mSearchBarView;
        if(searchBarView0 != null) {
            searchBarView0.a();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        com.iloen.melon.fragments.comments.CmtBaseFragment.Param cmtBaseFragment$Param0 = (com.iloen.melon.fragments.comments.CmtBaseFragment.Param)CompatUtils.getSerializable(bundle0, "argCmtParam", Param.class);
        this.mParam = cmtBaseFragment$Param0;
        if(cmtBaseFragment$Param0 != null) {
            this.mViewType = ((Param)cmtBaseFragment$Param0).viewType;
            this.mSearchType = ((Param)cmtBaseFragment$Param0).searchType;
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putSerializable("argCmtParam", this.mParam);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        View view1 = this.findViewById(0x7F0A042C);  // id:empty_or_error_layout
        this.mEmptyView = view1;
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 instanceof RecyclerViewWithEmptyView) {
            ((RecyclerViewWithEmptyView)recyclerView0).setEmptyView(view1);
        }
        if(this.mViewType == 1) {
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                titleBar0.a(B.a.s(1));
                titleBar0.setTitle("비디오첨부");
                titleBar0.f(true);
            }
            this.mFixedView = (FrameLayout)this.findViewById(0x7F0A04B8);  // id:fixed_view
            LayoutInflater.from(this.getActivity()).inflate(0x7F0D080A, this.mFixedView, true);  // layout:search_bar_view_layout
            SearchBarView searchBarView0 = (SearchBarView)this.findViewById(0x7F0A0A36);  // id:search_bar
            this.mSearchBarView = searchBarView0;
            searchBarView0.setOnSearchBarListener(new V0() {
                @Override  // com.iloen.melon.custom.Y
                public void onActionClick(InputBarView inputBarView0) {
                }

                @Override  // com.iloen.melon.custom.Y
                public void onClearClick(InputBarView inputBarView0) {
                    CmtAttachFragment.this.changeKeyword(CmtAttachFragment.this.mPrevKeyword);
                }

                @Override  // com.iloen.melon.custom.V0
                public void onClearKeyword(SearchBarView searchBarView0) {
                    CmtAttachFragment.this.changeKeyword(CmtAttachFragment.this.mPrevKeyword);
                }

                @Override  // com.iloen.melon.custom.V0
                public void onSearchClick(SearchBarView searchBarView0, String s) {
                    CmtAttachFragment.this.searchKeyword();
                }

                @Override  // com.iloen.melon.custom.V0
                public void onSearchKeyword(SearchBarView searchBarView0, String s) {
                    CmtAttachFragment.this.changeKeyword(s);
                }
            });
            return;
        }
        ViewUtils.hideWhen(this.getTitleBar(), true);
    }

    private void searchKeyword() {
        Z.x(new StringBuilder("searchKeyword() keyword:"), this.mKeyword, "CmtAttachFragment");
        this.mPrevKeyword = this.mKeyword;
        this.changeKeyword(this.mKeyword);
        SearchBarView searchBarView0 = this.mSearchBarView;
        if(searchBarView0 != null) {
            searchBarView0.setInputText(this.mPrevKeyword);
            this.mSearchBarView.a();
        }
        OnCmtSearchAttachListener cmtAttachFragment$OnCmtSearchAttachListener0 = this.mOnCmtSearchAttachListener;
        if(cmtAttachFragment$OnCmtSearchAttachListener0 != null) {
            cmtAttachFragment$OnCmtSearchAttachListener0.onSearch();
        }
        this.startFetchWithKeyword();
    }

    public void setOnCmtSearchAttachListener(OnCmtSearchAttachListener cmtAttachFragment$OnCmtSearchAttachListener0) {
        this.mOnCmtSearchAttachListener = cmtAttachFragment$OnCmtSearchAttachListener0;
    }

    public void startFetchWithKeyword() {
        Z.x(new StringBuilder("startFetchWithKeyword() keyword:"), this.mKeyword, "CmtAttachFragment");
        if(TextUtils.isEmpty(this.mKeyword)) {
            ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
            return;
        }
        this.startFetch("startFetchWithKeyword");
    }
}

