package com.iloen.melon.fragments.friend;

import a9.d;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.V0;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.SearchMemberListReq.Params;
import com.iloen.melon.net.v4x.request.SearchMemberListReq;
import com.iloen.melon.net.v4x.response.SearchMemberListRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v4x.response.SearchMemberListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.SearchMemberListRes;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e1.u;
import java.util.ArrayList;
import java.util.List;
import l8.a;
import v9.e;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class FriendSelectFragment extends FriendBaseSelectFragment {
    class FriendSearchAdapter extends p {
        public class FriendSearchHolder extends O0 {
            private ImageView checkIv;
            private ImageView defaultThumbIv;
            private TextView djBadge;
            private ImageView djOfficial;
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
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(friendSelectFragment$FriendSearchAdapter0.getContext(), 65.0f), true);
                this.thumbIv = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
                this.newIv = imageView1;
                imageView1.setVisibility(8);
                ImageView imageView2 = (ImageView)view0.findViewById(0x7F0A068D);  // id:iv_sns_icon
                this.snsIconIv = imageView2;
                imageView2.setVisibility(8);
                this.userNicknameTv = (TextView)view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
                ImageView imageView3 = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
                this.checkIv = imageView3;
                imageView3.setVisibility(0);
                this.djBadge = (TextView)view0.findViewById(0x7F0A03DA);  // id:dj_badge
                this.djOfficial = (ImageView)view0.findViewById(0x7F0A03DC);  // id:dj_official
            }
        }

        private static final int VIEW_TYPE_FRIEND;

        public FriendSearchAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00.getItemViewType() == 0) {
                CONTENTSLIST searchMemberListRes$RESPONSE$CONTENTSLIST0 = (CONTENTSLIST)this.getItem(v1);
                if(searchMemberListRes$RESPONSE$CONTENTSLIST0 != null) {
                    com.iloen.melon.fragments.friend.FriendSelectFragment.FriendSearchAdapter.1 friendSelectFragment$FriendSearchAdapter$10 = new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            FriendSelectFragment.this.onItemClick(view0, v);
                        }
                    };
                    ViewUtils.setOnClickListener(((FriendSearchHolder)o00).itemView, friendSelectFragment$FriendSearchAdapter$10);
                    if(this.isMarked(v1)) {
                        ((FriendSearchHolder)o00).checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                        ((FriendSearchHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                    }
                    else {
                        ((FriendSearchHolder)o00).checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        ((FriendSearchHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                    }
                    if(((FriendSearchHolder)o00).thumbIv != null) {
                        Glide.with(((FriendSearchHolder)o00).thumbIv.getContext()).load(searchMemberListRes$RESPONSE$CONTENTSLIST0.mypageimg).apply(RequestOptions.circleCropTransform()).into(((FriendSearchHolder)o00).thumbIv);
                    }
                    int v2 = ResourceUtils.getDjIconColorId(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberDjIconType);
                    if(v2 > -1) {
                        ((FriendSearchHolder)o00).djBadge.setTextColor(ColorUtils.getColor(this.getContext(), v2));
                        ViewUtils.showWhen(((FriendSearchHolder)o00).djBadge, true);
                    }
                    else {
                        ViewUtils.hideWhen(((FriendSearchHolder)o00).djBadge, true);
                    }
                    ViewUtils.showWhen(((FriendSearchHolder)o00).djOfficial, searchMemberListRes$RESPONSE$CONTENTSLIST0.isOfficial);
                    ((FriendSearchHolder)o00).userNicknameTv.setText(searchMemberListRes$RESPONSE$CONTENTSLIST0.membernickname);
                    ((FriendSearchHolder)o00).userNicknameTv.requestLayout();
                    ViewUtils.showWhen(((FriendSearchHolder)o00).checkIv, !u.v(((e0)o.a()).j()).equals(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberkey));
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v == 0 ? new FriendSearchHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D04B9, viewGroup0, false)) : null;  // layout:listitem_user
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void setMarked(int v, boolean z) {
            if(FriendSelectFragment.this.getOnAddedFriendListListener() != null) {
                CONTENTSLIST searchMemberListRes$RESPONSE$CONTENTSLIST0 = (CONTENTSLIST)this.getItem(v);
                if(searchMemberListRes$RESPONSE$CONTENTSLIST0 == null) {
                    LogU.d("FriendSelectFragment", "setMarked() invalid data");
                    return;
                }
                if(u.v(((e0)o.a()).j()).equals(searchMemberListRes$RESPONSE$CONTENTSLIST0.memberkey)) {
                    return;
                }
                String s = searchMemberListRes$RESPONSE$CONTENTSLIST0.memberkey;
                String s1 = StringUtils.getFriendDisplayName(s, searchMemberListRes$RESPONSE$CONTENTSLIST0.membernickname);
                String s2 = searchMemberListRes$RESPONSE$CONTENTSLIST0.mypageimg;
                String s3 = searchMemberListRes$RESPONSE$CONTENTSLIST0.memberstatus;
                Receiver toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
                toReceiverView$Receiver0.a = s;
                toReceiverView$Receiver0.b = null;
                toReceiverView$Receiver0.c = s1;
                toReceiverView$Receiver0.d = s2;
                toReceiverView$Receiver0.e = s3;
                if(!z) {
                    ((a)FriendSelectFragment.this.getOnAddedFriendListListener()).b(toReceiverView$Receiver0);
                }
                else if(!((a)FriendSelectFragment.this.getOnAddedFriendListListener()).a(FriendSelectFragment.this.getActivity(), toReceiverView$Receiver0)) {
                    return;
                }
            }
            super.setMarked(v, z);
        }
    }

    private static final int SORT_ALPHABET = 1;
    private static final int SORT_CORRECT = 0;
    private static final String TAG = "FriendSelectFragment";
    private int mCurrentSortIndex;
    private int mFrom;
    private String mSearchKeyword;
    private SortingBarView mSortingBarView;

    public FriendSelectFragment() {
        this.mCurrentSortIndex = 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        ToolBar toolBar0 = (ToolBar)this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        this.mToolBar = toolBar0;
        return this.mFrom == 0 ? ToolBar.f(toolBar0, 506) : ToolBar.f(toolBar0, 504);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new FriendSearchAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
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
        return MelonContentUris.I0.buildUpon().appendQueryParameter("sortIndex", String.valueOf(this.mCurrentSortIndex)).appendQueryParameter("searchKeyword", String.valueOf(this.mSearchKeyword)).build().toString();
    }

    private boolean isVaildKeyword(String s) {
        if(!TextUtils.isEmpty(s) && s.length() < 2) {
            MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(this.getActivity(), 0, "안내", "두 글자 이상 입력해주세요.", new DialogInterface.OnClickListener() {
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface dialogInterface0, int v) {
                }
            });
            if(melonTextPopup0 != null) {
                this.mRetainDialog = melonTextPopup0;
                melonTextPopup0.setCentFlag(true);
                melonTextPopup0.setOnDismissListener(this.mDialogDismissListener);
                melonTextPopup0.show();
            }
            return false;
        }
        return true;
    }

    public static FriendSelectFragment newInstance(ArrayList arrayList0, Sharable sharable0, int v, int v1) {
        FriendSelectFragment friendSelectFragment0 = new FriendSelectFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelableArrayList("argFriendReceiverList", arrayList0);
        bundle0.putParcelable("argAttachedSharable", ((Parcelable)sharable0));
        bundle0.putInt("argFriendMaxCount", v);
        bundle0.putInt("argWhereRUFrom", v1);
        friendSelectFragment0.setArguments(bundle0);
        return friendSelectFragment0;
    }

    @Override  // com.iloen.melon.fragments.friend.FriendBaseSelectFragment
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
        return layoutInflater0.inflate(0x7F0D02D0, viewGroup0, false);  // layout:friend_search_and_select
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(!TextUtils.isEmpty(this.mSearchKeyword)) {
            FriendSearchAdapter friendSelectFragment$FriendSearchAdapter0 = (FriendSearchAdapter)this.mAdapter;
            i i1 = i.b;
            if(i1.equals(i0)) {
                this.clearSelection();
                friendSelectFragment$FriendSearchAdapter0.clear();
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
            searchMemberListReq$Params0.startIndex = i1.equals(i0) ? 1 : friendSelectFragment$FriendSearchAdapter0.getCount() + 1;
            searchMemberListReq$Params0.pageSize = 100;
            searchMemberListReq$Params0.orderBy = this.mCurrentSortIndex == 0 ? 1 : 4;
            RequestBuilder.newInstance(new SearchMemberListReq(this.getContext(), this.mSearchKeyword, searchMemberListReq$Params0, this.mFrom)).tag("FriendSelectFragment").listener(new Listener() {
                public void onResponse(SearchMemberListRes searchMemberListRes0) {
                    if(!FriendSelectFragment.this.prepareFetchComplete(searchMemberListRes0)) {
                        return;
                    }
                    if(searchMemberListRes0 != null) {
                        RESPONSE searchMemberListRes$RESPONSE0 = searchMemberListRes0.response;
                        if(searchMemberListRes$RESPONSE0 != null) {
                            if(searchMemberListRes$RESPONSE0.contentslist == null || searchMemberListRes$RESPONSE0.contentslist.size() <= 0) {
                                FriendSelectFragment.this.mSortingBarView.setVisibility(8);
                            }
                            else {
                                FriendSelectFragment.this.mSortingBarView.setVisibility(0);
                            }
                        }
                    }
                    FriendSelectFragment.this.performFetchComplete(i0, searchMemberListRes0);
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
        this.mFrom = bundle0.getInt("argWhereRUFrom");
    }

    @Override  // com.iloen.melon.fragments.friend.FriendBaseSelectFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putInt("argWhereRUFrom", this.mFrom);
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        if((15 == v || 9 == v) && this.getOnAddedFriendListListener() != null) {
            ((a)this.getOnAddedFriendListListener()).c(this.getActivity());
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
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
                if(!FriendSelectFragment.this.isVaildKeyword(s)) {
                    return;
                }
                FriendSelectFragment.this.mSearchKeyword = s;
                FriendSelectFragment.this.startFetch("search keyword");
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchKeyword(SearchBarView searchBarView0, String s) {
            }
        });
        SortingBarView sortingBarView0 = (SortingBarView)this.findViewById(0x7F0A0AB8);  // id:sort_bar
        this.mSortingBarView = sortingBarView0;
        sortingBarView0.setSelection(this.mCurrentSortIndex);
        this.mSortingBarView.setOnSortSelectionListener(new d() {
            @Override  // a9.d
            public void onSelected(int v) {
                if(FriendSelectFragment.this.mCurrentSortIndex == v) {
                    return;
                }
                FriendSelectFragment.this.mCurrentSortIndex = v;
                FriendSelectFragment.this.startFetch("sortbar change");
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

