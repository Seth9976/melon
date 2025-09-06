package com.iloen.melon.fragments.detail;

import F8.m;
import F8.o;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FollowToggleButton;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.UserInfoBase;
import com.iloen.melon.net.v4x.request.MyMusicLikeListUserWithLikeReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeListUserWithLikeReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListUserWithLikeRes;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import k8.Y;
import v9.h;

public class DetailLikePersonListFragment extends MetaContentBaseFragment {
    public class ItemHolder extends O0 {
        private TextView djBadge;
        private ImageView djOfficial;
        private FollowToggleButton followButton;
        private ImageView ivNewIcon;
        private ImageView ivThumbCicleDefault;
        private ImageView ivThumbCircle;
        private LinearLayout layoutWrapper;
        private TextView tvUserNickname;

        public ItemHolder(View view0) {
            super(view0);
            this.layoutWrapper = (LinearLayout)view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
            this.ivThumbCicleDefault = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
            this.ivThumbCircle = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
            this.ivNewIcon = imageView0;
            imageView0.setVisibility(8);
            TextView textView0 = (TextView)view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
            this.tvUserNickname = textView0;
            textView0.setVisibility(0);
            this.djBadge = (TextView)view0.findViewById(0x7F0A03DA);  // id:dj_badge
            this.djOfficial = (ImageView)view0.findViewById(0x7F0A03DC);  // id:dj_official
            FollowToggleButton followToggleButton0 = (FollowToggleButton)view0.findViewById(0x7F0A04D3);  // id:follow_toggle_button
            this.followButton = followToggleButton0;
            followToggleButton0.setVisibility(0);
        }
    }

    public class LikePersonListAdapter extends p {
        public static final String TAG = "LikePersonListAdapter";

        public LikePersonListAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            UserInfoBase userInfoBase0 = (UserInfoBase)this.getItem(v1);
            if(userInfoBase0 != null && o00 instanceof ItemHolder) {
                ViewUtils.setOnClickListener(((ItemHolder)o00).layoutWrapper, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        Navigator.openUserMain(userInfoBase0.memberkey);
                    }
                });
                int v2 = ResourceUtils.getDjIconColorId(userInfoBase0.memberDjIconType);
                if(v2 > -1) {
                    ((ItemHolder)o00).djBadge.setTextColor(ColorUtils.getColor(this.getContext(), v2));
                    ViewUtils.showWhen(((ItemHolder)o00).djBadge, true);
                }
                else {
                    ViewUtils.hideWhen(((ItemHolder)o00).djBadge, true);
                }
                ViewUtils.showWhen(((ItemHolder)o00).djOfficial, userInfoBase0.isOfficial);
                ((ItemHolder)o00).tvUserNickname.setText(userInfoBase0.membernickname);
                boolean z = StringIds.a(userInfoBase0.memberkey, StringIds.h);
                ViewUtils.hideWhen(((ItemHolder)o00).followButton, z);
                if(!z) {
                    if(userInfoBase0.ismyfriend) {
                        ((ItemHolder)o00).followButton.setType(1);
                    }
                    else {
                        ((ItemHolder)o00).followButton.setType(0);
                    }
                    ViewUtils.setOnClickListener(((ItemHolder)o00).followButton, new View.OnClickListener() {
                        private void lambda$onClick$0(UserInfoBase userInfoBase0, ItemHolder detailLikePersonListFragment$ItemHolder0, String s) {
                            if(DetailLikePersonListFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                                userInfoBase0.ismyfriend = false;
                                detailLikePersonListFragment$ItemHolder0.followButton.setType(0);
                            }
                        }

                        private void lambda$onClick$1(UserInfoBase userInfoBase0, ItemHolder detailLikePersonListFragment$ItemHolder0, String s) {
                            if(DetailLikePersonListFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                                userInfoBase0.ismyfriend = true;
                                detailLikePersonListFragment$ItemHolder0.followButton.setType(1);
                            }
                        }

                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            UserInfoBase userInfoBase0 = userInfoBase0;
                            if(userInfoBase0.ismyfriend) {
                                String s = userInfoBase0.memberkey;
                                String s1 = LikePersonListAdapter.this.getMenuId();
                                i i0 = new i(this, userInfoBase0, ((ItemHolder)o00), 0);
                                DetailLikePersonListFragment.this.addOrDeleteFriend(s, s1, false, i0);
                                return;
                            }
                            String s2 = userInfoBase0.memberkey;
                            String s3 = LikePersonListAdapter.this.getMenuId();
                            i i1 = new i(this, userInfoBase0, ((ItemHolder)o00), 1);
                            DetailLikePersonListFragment.this.addOrDeleteFriend(s2, s3, true, i1);
                        }
                    });
                }
                ((ItemHolder)o00).ivThumbCicleDefault.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ViewUtils.setDefaultImage(((ItemHolder)o00).ivThumbCicleDefault, DetailLikePersonListFragment.this.mProfilePixel, true);
                Glide.with(this.getContext()).load(userInfoBase0.mypageimg).apply(RequestOptions.circleCropTransform()).into(((ItemHolder)o00).ivThumbCircle);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04B9, viewGroup0, false);  // layout:listitem_user
            return new ItemHolder(DetailLikePersonListFragment.this, view0);
        }
    }

    public static final String ARG_ACT_TYPE_CODE = "argActTypeCode";
    public static final String ARG_CONTENTS_TYPE_CODE = "argContentsTypeCode";
    public static final String ARG_CONTS_ID = "argContsId";
    public static final String CACHE_KEY_SUB_NAME = "personList";
    public static final String TAG = "DetailLikePersonListFragment";
    private String mActTypeCode;
    private String mContsId;
    private String mContsTypeCode;
    private int mProfilePixel;
    private TitleBar mTitleBarLayout;

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return new LikePersonListAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.j.buildUpon().appendPath("personList").build().toString();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    public static DetailLikePersonListFragment newInstance(String s, String s1, String s2) {
        DetailLikePersonListFragment detailLikePersonListFragment0 = new DetailLikePersonListFragment();
        Bundle bundle0 = Y.c("argContentsTypeCode", s, "argActTypeCode", s1);
        bundle0.putString("argContsId", s2);
        detailLikePersonListFragment0.setArguments(bundle0);
        return detailLikePersonListFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.mProfilePixel = (int)this.getResources().getDimension(0x7F07041B);  // dimen:profile_image_detail_default_pixel
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02A9, viewGroup0, false);  // layout:fragment_detail_basic
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(v9.i i0, h h0, String s) {
        LikePersonListAdapter detailLikePersonListFragment$LikePersonListAdapter0 = (LikePersonListAdapter)this.mAdapter;
        Params myMusicLikeListUserWithLikeReq$Params0 = new Params();
        myMusicLikeListUserWithLikeReq$Params0.startIndex = v9.i.b.equals(i0) ? 1 : detailLikePersonListFragment$LikePersonListAdapter0.getCount() + 1;
        myMusicLikeListUserWithLikeReq$Params0.pageSize = 100;
        myMusicLikeListUserWithLikeReq$Params0.contsTypeCode = this.mContsTypeCode;
        myMusicLikeListUserWithLikeReq$Params0.actTypeCode = this.mActTypeCode;
        myMusicLikeListUserWithLikeReq$Params0.contsId = this.mContsId;
        RequestBuilder.newInstance(new MyMusicLikeListUserWithLikeReq(this.getContext(), myMusicLikeListUserWithLikeReq$Params0)).tag("DetailLikePersonListFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeListUserWithLikeRes myMusicLikeListUserWithLikeRes0) {
                if(!DetailLikePersonListFragment.this.prepareFetchComplete(myMusicLikeListUserWithLikeRes0)) {
                    return;
                }
                DetailLikePersonListFragment.this.performFetchComplete(i0, myMusicLikeListUserWithLikeRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeListUserWithLikeRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        if(bundle0.containsKey("argContentsTypeCode")) {
            this.mContsTypeCode = bundle0.getString("argContentsTypeCode");
        }
        if(bundle0.containsKey("argActTypeCode")) {
            this.mActTypeCode = bundle0.getString("argActTypeCode");
        }
        if(bundle0.containsKey("argContsId")) {
            this.mContsId = bundle0.getString("argContsId");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argContentsTypeCode", this.mContsTypeCode);
            bundle0.putString("argActTypeCode", this.mActTypeCode);
            bundle0.putString("argContsId", this.mContsId);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.mTitleBarLayout = this.getTitleBar();
        F8.p p0 = new F8.p(1);
        p0.h(this.getString(0x7F130809));  // string:playList_talkback_detail_info_close "상세정보 닫기"
        p0.c = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                DetailLikePersonListFragment.this.performBackPress();
            }
        };
        m m0 = new m(2, false);
        TitleBar titleBar0 = this.mTitleBarLayout;
        o[] arr_o = {p0, m0};
        o o0 = null;
        for(int v = 0; v < 2; ++v) {
            o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        titleBar0.a(o0);
        this.mTitleBarLayout.setTitle(this.getString(0x7F130351));  // string:dlg_like_person "좋아요 한 사람"
        this.mTitleBarLayout.f(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }
}

