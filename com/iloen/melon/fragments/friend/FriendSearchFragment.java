package com.iloen.melon.fragments.friend;

import B.a;
import a9.d;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.V0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.SearchMemberListReq.Params;
import com.iloen.melon.net.v4x.request.SearchMemberListReq;
import com.iloen.melon.net.v4x.response.SearchMemberListRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v4x.response.SearchMemberListRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import d3.g;
import e1.u;
import java.util.List;
import v9.e;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class FriendSearchFragment extends MetaContentBaseFragment {
    public class FriendSearchAdapter extends p {
        public class FriendSearchHolder extends O0 {
            private TextView countHomeTv;
            private TextView countSongTv;
            private ImageView defaultThumbIv;
            private ImageView djIconIv;
            private View extraContainer;
            private ImageView friendAddIv;
            private TextView genreTv;
            private ImageView newIv;
            private View rootView;
            private ImageView snsIconIv;
            private BorderImageView thumbIv;
            private TextView userNicknameTv;

            public FriendSearchHolder(View view0) {
                super(view0);
                this.rootView = view0;
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.defaultThumbIv = imageView0;
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(friendSearchFragment$FriendSearchAdapter0.getContext(), 65.0f), true);
                this.thumbIv = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
                this.newIv = imageView1;
                imageView1.setVisibility(8);
                this.djIconIv = (ImageView)view0.findViewById(0x7F0A06A7);  // id:iv_thumbnail_circle_badge
                ImageView imageView2 = (ImageView)view0.findViewById(0x7F0A068D);  // id:iv_sns_icon
                this.snsIconIv = imageView2;
                imageView2.setVisibility(8);
                this.userNicknameTv = (TextView)view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
                ImageView imageView3 = (ImageView)view0.findViewById(0x7F0A0163);  // id:btn_friend_add
                this.friendAddIv = imageView3;
                imageView3.setVisibility(0);
                this.extraContainer = view0.findViewById(0x7F0A0483);  // id:extra_container
                this.genreTv = (TextView)view0.findViewById(0x7F0A0C83);  // id:tv_genre
                this.countSongTv = (TextView)view0.findViewById(0x7F0A0C52);  // id:tv_count_song
                TextView textView0 = (TextView)view0.findViewById(0x7F0A0C51);  // id:tv_count_home
                this.countHomeTv = textView0;
                textView0.setVisibility(8);
            }

            public static TextView e(FriendSearchHolder friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0) {
                return friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0.genreTv;
            }

            public static View f(FriendSearchHolder friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0) {
                return friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0.rootView;
            }

            public static BorderImageView g(FriendSearchHolder friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0) {
                return friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0.thumbIv;
            }

            public static TextView h(FriendSearchHolder friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0) {
                return friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0.userNicknameTv;
            }
        }

        private static final int VIEW_TYPE_FRIEND = 1;

        public FriendSearchAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 1) {
                CONTENTSLIST searchMemberListRes$RESPONSE$CONTENTSLIST0 = (CONTENTSLIST)this.getItem(v1);
                if(searchMemberListRes$RESPONSE$CONTENTSLIST0 != null) {
                    ViewUtils.setOnClickListener(FriendSearchHolder.f(((FriendSearchHolder)o00)), new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            Navigator.openUserMain(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberkey);
                        }
                    });
                    ViewUtils.showWhen(((FriendSearchHolder)o00).djIconIv, g.M(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberDjType));
                    int v2 = ResourceUtils.getDjIconResId(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberDjType);
                    if(v2 > 0) {
                        ((FriendSearchHolder)o00).djIconIv.setImageResource(v2);
                    }
                    if(FriendSearchHolder.g(((FriendSearchHolder)o00)) != null) {
                        Glide.with(FriendSearchHolder.g(((FriendSearchHolder)o00)).getContext()).load(searchMemberListRes$RESPONSE$CONTENTSLIST0.mypageimg).apply(RequestOptions.circleCropTransform()).into(FriendSearchHolder.g(((FriendSearchHolder)o00)));
                    }
                    FriendSearchHolder.h(((FriendSearchHolder)o00)).setText(searchMemberListRes$RESPONSE$CONTENTSLIST0.membernickname);
                    FriendSearchHolder.h(((FriendSearchHolder)o00)).requestLayout();
                    if(searchMemberListRes$RESPONSE$CONTENTSLIST0.ismyfriend) {
                        ((FriendSearchHolder)o00).friendAddIv.setImageResource(0x7F080146);  // drawable:btn_common_follow_29_on
                    }
                    else {
                        ((FriendSearchHolder)o00).friendAddIv.setImageResource(0x7F080145);  // drawable:btn_common_follow_29_off_tint
                    }
                    ViewUtils.showWhen(((FriendSearchHolder)o00).friendAddIv, !u.v(((e0)o.a()).j()).equals(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberkey));
                    ViewUtils.setOnClickListener(((FriendSearchHolder)o00).friendAddIv, new View.OnClickListener() {
                        private void lambda$onClick$0(CONTENTSLIST searchMemberListRes$RESPONSE$CONTENTSLIST0, FriendSearchHolder friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0, String s) {
                            if(FriendSearchFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                                searchMemberListRes$RESPONSE$CONTENTSLIST0.ismyfriend = true;
                                FriendSearchHolder.d(friendSearchFragment$FriendSearchAdapter$FriendSearchHolder0).setImageResource(0x7F080146);  // drawable:btn_common_follow_29_on
                            }
                        }

                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            CONTENTSLIST searchMemberListRes$RESPONSE$CONTENTSLIST0 = searchMemberListRes$RESPONSE$CONTENTSLIST0;
                            if(searchMemberListRes$RESPONSE$CONTENTSLIST0.ismyfriend) {
                                return;
                            }
                            String s = searchMemberListRes$RESPONSE$CONTENTSLIST0.memberkey;
                            String s1 = FriendSearchAdapter.this.getMenuId();
                            m m0 = new m(this, searchMemberListRes$RESPONSE$CONTENTSLIST0, ((FriendSearchHolder)o00), 2);
                            FriendSearchFragment.this.addOrDeleteFriend(s, s1, true, m0);
                        }
                    });
                    ((FriendSearchHolder)o00).extraContainer.setVisibility(0);
                    ViewUtils.showWhen(FriendSearchHolder.e(((FriendSearchHolder)o00)), ((boolean)(true ^ TextUtils.isEmpty(searchMemberListRes$RESPONSE$CONTENTSLIST0.gnrname))));
                    FriendSearchHolder.e(((FriendSearchHolder)o00)).setText(searchMemberListRes$RESPONSE$CONTENTSLIST0.gnrname);
                    if(g.M(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberDjType)) {
                        ((FriendSearchHolder)o00).countSongTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803E9, 0, 0, 0);  // drawable:ic_common_dj_playlist_13
                    }
                    else {
                        ((FriendSearchHolder)o00).countSongTv.setCompoundDrawablesWithIntrinsicBounds(0x7F080407, 0, 0, 0);  // drawable:ic_common_playlist_13
                    }
                    ((FriendSearchHolder)o00).countSongTv.setText(StringUtils.getCountString(searchMemberListRes$RESPONSE$CONTENTSLIST0.playlistcnt, 0xF423F));
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v == 1 ? new FriendSearchHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D04B9, viewGroup0, false)) : null;  // layout:listitem_user
        }
    }

    private static final int SORT_ALPHABET = 1;
    private static final int SORT_CORRECT = 0;
    private static final String TAG = "FriendSearchFragment";
    private int mCurrentSortIndex;
    private SearchBarView mSearchBarView;
    private String mSearchKeyword;

    public FriendSearchFragment() {
        this.mCurrentSortIndex = 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new FriendSearchAdapter(this, context0, null);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F13046D);  // string:friend_add_first_come_notice "멜론 닉네임을 두글자 이상 입력 후 검색해 주세요."
        ((p)j00).setEmptyViewInfo(e0);
        ((p)j00).setEmptyViewResId(0x7F0D0023);  // layout:adapter_empty_view_search
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.F0.toString();
    }

    private boolean isVaildKeyword(String s) {
        if(!TextUtils.isEmpty(s) && s.length() < 2) {
            l0 l00 = this.getChildFragmentManager();
            String s1 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s2 = this.getString(0x7F130476);  // string:friend_search_min_keyword_count "두 글자 이상 입력해주세요."
            b.a.c(l00, s1, s2);
            return false;
        }
        return true;
    }

    public static FriendSearchFragment newInstance() {
        FriendSearchFragment friendSearchFragment0 = new FriendSearchFragment();
        friendSearchFragment0.setArguments(new Bundle());
        return friendSearchFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
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

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02CF, viewGroup0, false);  // layout:friend_search
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        SearchBarView searchBarView0 = this.mSearchBarView;
        if(searchBarView0 != null) {
            searchBarView0.a();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(!TextUtils.isEmpty(this.mSearchKeyword)) {
            FriendSearchAdapter friendSearchFragment$FriendSearchAdapter0 = (FriendSearchAdapter)this.mAdapter;
            i i1 = i.b;
            if(i1.equals(i0)) {
                friendSearchFragment$FriendSearchAdapter0.clear(false);
                SearchBarView searchBarView0 = this.mSearchBarView;
                if(searchBarView0 != null) {
                    String s1 = searchBarView0.getInputText();
                    if(!s1.equals(this.mSearchKeyword) && !TextUtils.isEmpty(s1)) {
                        if(!this.isVaildKeyword(s1)) {
                            return false;
                        }
                        this.mSearchKeyword = s1;
                    }
                    this.mSearchBarView.setInputText(this.mSearchKeyword);
                    if(this.mSearchBarView.getInputTextView() != null) {
                        this.mSearchBarView.getInputTextView().setSelection(this.mSearchKeyword.length());
                    }
                }
            }
            Params searchMemberListReq$Params0 = new Params();
            searchMemberListReq$Params0.startIndex = i1.equals(i0) ? 1 : friendSearchFragment$FriendSearchAdapter0.getCount() + 1;
            searchMemberListReq$Params0.pageSize = 100;
            searchMemberListReq$Params0.orderBy = this.mCurrentSortIndex == 0 ? 1 : 4;
            RequestBuilder.newInstance(new SearchMemberListReq(this.getContext(), this.mSearchKeyword, searchMemberListReq$Params0, 2)).tag("FriendSearchFragment").listener(new Listener() {
                public void onResponse(SearchMemberListRes searchMemberListRes0) {
                    if(!FriendSearchFragment.this.prepareFetchComplete(searchMemberListRes0)) {
                        return;
                    }
                    FriendSearchFragment.this.performFetchComplete(i0, searchMemberListRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((SearchMemberListRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = (TitleBar)view0.findViewById(0x7F0A0BAD);  // id:titlebar
        titleBar0.a(a.s(1));
        titleBar0.setTitle(this.getString(0x7F1308F4));  // string:search_melon_member "멜론회원 친구추가"
        titleBar0.f(true);
        SearchBarView searchBarView0 = (SearchBarView)this.findViewById(0x7F0A0A36);  // id:search_bar
        this.mSearchBarView = searchBarView0;
        searchBarView0.setHint(0x7F1300AC);  // string:alert_dlg_body_melon_nickname_empty "멜론 닉네임을 입력해주세요."
        this.mSearchBarView.setOnSearchBarListener(new V0() {
            @Override  // com.iloen.melon.custom.Y
            public void onActionClick(InputBarView inputBarView0) {
            }

            @Override  // com.iloen.melon.custom.Y
            public void onClearClick(InputBarView inputBarView0) {
            }

            @Override  // com.iloen.melon.custom.V0
            public void onClearKeyword(SearchBarView searchBarView0) {
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchClick(SearchBarView searchBarView0, String s) {
                if(!FriendSearchFragment.this.isVaildKeyword(s)) {
                    return;
                }
                FriendSearchFragment.this.mSearchKeyword = s;
                FriendSearchFragment.this.startFetchWithClearAdapterItems("search keyword");
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchKeyword(SearchBarView searchBarView0, String s) {
            }
        });
        SortingBarView sortingBarView0 = (SortingBarView)this.findViewById(0x7F0A0AB8);  // id:sort_bar
        sortingBarView0.setSelection(this.mCurrentSortIndex);
        sortingBarView0.setOnSortSelectionListener(new d() {
            @Override  // a9.d
            public void onSelected(int v) {
                if(FriendSearchFragment.this.mCurrentSortIndex == v) {
                    return;
                }
                FriendSearchFragment.this.mCurrentSortIndex = v;
                FriendSearchFragment.this.startFetchWithClearAdapterItems("sortbar change");
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private void startFetchWithClearAdapterItems(String s) {
        j0 j00 = this.mAdapter;
        if(j00 == null) {
            return;
        }
        if(j00 instanceof FriendSearchAdapter) {
            LogU.d("FriendSearchFragment", "startFetchWithClearAdapterItems() - clear adapter items.");
            ((FriendSearchAdapter)this.mAdapter).clear(true);
        }
        this.startFetch(s);
    }
}

