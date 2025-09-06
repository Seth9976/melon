package com.iloen.melon.fragments.friend;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.G;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.response.GiftListFollowingAlphabetRes;
import com.iloen.melon.net.v4x.response.ListFollowingAlphabetBaseRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v4x.response.ListFollowingAlphabetBaseRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ListFollowingAlphabetBaseRes;
import com.iloen.melon.net.v4x.response.MessageListFollowingAlphabetRes;
import com.iloen.melon.net.v6x.request.GiftListFollowingAlphabetReq;
import com.iloen.melon.net.v6x.request.ListFollowingAlphabetBaseReq.Params;
import com.iloen.melon.net.v6x.request.MessageListFollowingAlphabetReq;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import l8.a;
import v9.e;
import v9.h;
import v9.i;

public class FollowingSelectFragment extends FriendBaseSelectFragment {
    class AlphabetAdapter extends p {
        class AlphabetHolder extends O0 {
            private ImageView checkIv;
            private ImageView defaultThumbIv;
            private TextView djBadge;
            private ImageView djOfficial;
            private View extraContainer;
            private ImageView newIv;
            private View rootView;
            private ImageView snsIconIv;
            private BorderImageView thumbIv;
            private TextView userNicknameTv;

            public AlphabetHolder(View view0) {
                super(view0);
                this.rootView = view0;
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.defaultThumbIv = imageView0;
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(followingSelectFragment$AlphabetAdapter0.getContext(), 65.0f), true);
                this.thumbIv = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
                this.newIv = imageView1;
                imageView1.setVisibility(8);
                this.snsIconIv = (ImageView)view0.findViewById(0x7F0A068D);  // id:iv_sns_icon
                this.userNicknameTv = (TextView)view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
                ImageView imageView2 = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
                this.checkIv = imageView2;
                imageView2.setVisibility(0);
                View view1 = view0.findViewById(0x7F0A0483);  // id:extra_container
                this.extraContainer = view1;
                view1.setVisibility(8);
                this.djBadge = (TextView)view0.findViewById(0x7F0A03DA);  // id:dj_badge
                this.djOfficial = (ImageView)view0.findViewById(0x7F0A03DC);  // id:dj_official
            }

            public static ImageView a(AlphabetHolder followingSelectFragment$AlphabetAdapter$AlphabetHolder0) {
                return followingSelectFragment$AlphabetAdapter$AlphabetHolder0.checkIv;
            }

            public static TextView b(AlphabetHolder followingSelectFragment$AlphabetAdapter$AlphabetHolder0) {
                return followingSelectFragment$AlphabetAdapter$AlphabetHolder0.djBadge;
            }

            public static ImageView c(AlphabetHolder followingSelectFragment$AlphabetAdapter$AlphabetHolder0) {
                return followingSelectFragment$AlphabetAdapter$AlphabetHolder0.djOfficial;
            }

            public static View d(AlphabetHolder followingSelectFragment$AlphabetAdapter$AlphabetHolder0) {
                return followingSelectFragment$AlphabetAdapter$AlphabetHolder0.rootView;
            }

            public static ImageView e(AlphabetHolder followingSelectFragment$AlphabetAdapter$AlphabetHolder0) {
                return followingSelectFragment$AlphabetAdapter$AlphabetHolder0.snsIconIv;
            }

            public static BorderImageView f(AlphabetHolder followingSelectFragment$AlphabetAdapter$AlphabetHolder0) {
                return followingSelectFragment$AlphabetAdapter$AlphabetHolder0.thumbIv;
            }

            public static TextView g(AlphabetHolder followingSelectFragment$AlphabetAdapter$AlphabetHolder0) {
                return followingSelectFragment$AlphabetAdapter$AlphabetHolder0.userNicknameTv;
            }
        }

        class FilterHolder extends O0 {
            private FilterDropDownView filterLayout;

            public FilterHolder(View view0) {
                super(view0);
                this.filterLayout = (FilterDropDownView)view0.findViewById(0x7F0A049E);  // id:filter_layout
            }

            public static FilterDropDownView a(FilterHolder followingSelectFragment$AlphabetAdapter$FilterHolder0) {
                return followingSelectFragment$AlphabetAdapter$FilterHolder0.filterLayout;
            }
        }

        private static final int VIEW_TYPE_FRIEND = 2;
        private static final int VIEW_TYPE_HEADER = 1;

        public AlphabetAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? 1 : 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ListFollowingAlphabetBaseRes) {
                RESPONSE listFollowingAlphabetBaseRes$RESPONSE0 = ((ListFollowingAlphabetBaseRes)httpResponse0).response;
                if(listFollowingAlphabetBaseRes$RESPONSE0 != null) {
                    if(listFollowingAlphabetBaseRes$RESPONSE0.userList != null && listFollowingAlphabetBaseRes$RESPONSE0.userList.size() > 0) {
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object0: ((ListFollowingAlphabetBaseRes)httpResponse0).response.userList) {
                            USERLIST listFollowingAlphabetBaseRes$RESPONSE$USERLIST0 = (USERLIST)object0;
                            if(!"Y".equals(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.withDrawYn)) {
                                arrayList0.add(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0);
                            }
                        }
                        this.addAll(arrayList0);
                    }
                    this.setHasMore((httpResponse0 instanceof MessageListFollowingAlphabetRes ? ((MessageListFollowingAlphabetRes)httpResponse0).hasMore() : ((GiftListFollowingAlphabetRes)httpResponse0).hasMore()));
                    this.setMenuId(((ListFollowingAlphabetBaseRes)httpResponse0).getMenuId());
                    this.updateModifiedTime(s);
                }
                String s1 = "A".equals(FollowingSelectFragment.h0(FollowingSelectFragment.this)) ? FollowingSelectFragment.this.getString(0x7F130446) : FollowingSelectFragment.this.getString(0x7F130389);  // string:following_empty_msg "친구가 없습니다. 친구를 추가하고 친구들과 음악을 공유해 보세요."
                e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                e0.d = -1;
                e0.e = -1;
                e0.g = -1;
                e0.i = -1;
                e0.k = -1;
                e0.l = -1;
                e0.f = s1;
                this.setEmptyViewInfo(e0);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 1: {
                    FilterHolder.a(((FilterHolder)o00)).setOnDropDownListener(new G() {
                        private H lambda$onClick$0(FilterHolder followingSelectFragment$AlphabetAdapter$FilterHolder0, Integer integer0, Integer integer1, Integer integer2) {
                            if(FollowingSelectFragment.this.mCurrentFilterIndex != ((int)integer0)) {
                                FollowingSelectFragment.this.mCurrentFilterIndex = (int)integer0;
                                FilterHolder.a(followingSelectFragment$AlphabetAdapter$FilterHolder0).setText(FollowingSelectFragment.g0(FollowingSelectFragment.this));
                                FollowingSelectFragment.this.clearSelection();
                                FollowingSelectFragment.this.startFetch("filter change");
                            }
                            return H.a;
                        }

                        @Override  // com.iloen.melon.custom.G
                        public void onClick(FilterDropDownView filterDropDownView0) {
                            if(FollowingSelectFragment.this.mFilterList != null && !FollowingSelectFragment.this.isRetainedPopupShowing()) {
                                k k0 = new k(this, ((FilterHolder)o00), 1);
                                CommonFilterPopup commonFilterPopup0 = CommonFilterPopup.newInstance(0x7F1307D1, "LIST_TYPE_DEPTH_ONE_BASIC", FollowingSelectFragment.this.mFilterList, FollowingSelectFragment.this.mCurrentFilterIndex, 0, 0, k0);  // string:order_by "정렬"
                                FragmentActivity fragmentActivity0 = FollowingSelectFragment.this.getActivity();
                                if(fragmentActivity0 != null) {
                                    commonFilterPopup0.setDismissFragment(FollowingSelectFragment.this);
                                    commonFilterPopup0.show(fragmentActivity0.getSupportFragmentManager(), "ComposeBottomSheet");
                                }
                            }
                        }
                    });
                    FilterHolder.a(((FilterHolder)o00)).setText(FollowingSelectFragment.g0(FollowingSelectFragment.this));
                    return;
                }
                case 2: {
                    USERLIST listFollowingAlphabetBaseRes$RESPONSE$USERLIST0 = (USERLIST)this.getItem(v1);
                    if(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0 != null) {
                        com.iloen.melon.fragments.friend.FollowingSelectFragment.AlphabetAdapter.2 followingSelectFragment$AlphabetAdapter$20 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                FollowingSelectFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((AlphabetHolder)o00).itemView, followingSelectFragment$AlphabetAdapter$20);
                        if(this.isMarked(v1)) {
                            AlphabetHolder.a(((AlphabetHolder)o00)).setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                            AlphabetHolder.d(((AlphabetHolder)o00)).setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                        }
                        else {
                            AlphabetHolder.a(((AlphabetHolder)o00)).setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                            AlphabetHolder.d(((AlphabetHolder)o00)).setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        }
                        int v2 = ResourceUtils.getDjIconColorId(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.memberDjIconType);
                        if(v2 > -1) {
                            AlphabetHolder.b(((AlphabetHolder)o00)).setTextColor(ColorUtils.getColor(this.getContext(), v2));
                            ViewUtils.showWhen(AlphabetHolder.b(((AlphabetHolder)o00)), true);
                        }
                        else {
                            ViewUtils.hideWhen(AlphabetHolder.b(((AlphabetHolder)o00)), true);
                        }
                        ViewUtils.showWhen(AlphabetHolder.c(((AlphabetHolder)o00)), listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.isOfficial);
                        AlphabetHolder.e(((AlphabetHolder)o00)).setVisibility(0);
                        String s = listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.myPageImg;
                        String s1 = listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.frendAddOrigin;
                        if("F".equals(s1)) {
                            if(TextUtils.isEmpty(s) && !TextUtils.isEmpty(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.fbImageUrl)) {
                                s = listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.fbImageUrl;
                            }
                            AlphabetHolder.e(((AlphabetHolder)o00)).setBackgroundResource(0x7F0803EA);  // drawable:ic_common_facebook_16
                        }
                        else if("K".equals(s1)) {
                            AlphabetHolder.e(((AlphabetHolder)o00)).setBackgroundResource(0x7F0803F7);  // drawable:ic_common_kakao_16
                        }
                        else if("P".equals(s1)) {
                            AlphabetHolder.e(((AlphabetHolder)o00)).setBackgroundResource(0x7F0803EE);  // drawable:ic_common_friend_16
                        }
                        else {
                            AlphabetHolder.e(((AlphabetHolder)o00)).setVisibility(8);
                        }
                        if(AlphabetHolder.f(((AlphabetHolder)o00)) != null) {
                            Glide.with(AlphabetHolder.f(((AlphabetHolder)o00)).getContext()).load(s).apply(RequestOptions.circleCropTransform()).into(AlphabetHolder.f(((AlphabetHolder)o00)));
                        }
                        AlphabetHolder.g(((AlphabetHolder)o00)).setText(StringUtils.getFriendDisplayName(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.memberKey, listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.memberNickName));
                        AlphabetHolder.g(((AlphabetHolder)o00)).requestLayout();
                    }
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    return new FilterHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D026D, viewGroup0, false));  // layout:filter_list_common_dropdown_item
                }
                case 2: {
                    return new AlphabetHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D04B9, viewGroup0, false));  // layout:listitem_user
                }
                default: {
                    return null;
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void setMarked(int v, boolean z) {
            if(FollowingSelectFragment.this.getOnAddedFriendListListener() != null) {
                USERLIST listFollowingAlphabetBaseRes$RESPONSE$USERLIST0 = (USERLIST)this.getItem(v);
                if(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0 == null) {
                    LogU.d("FollowingSelectFragment", "setMarked() invalid data");
                    return;
                }
                String s = listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.memberKey;
                String s1 = StringUtils.getFriendDisplayName(s, listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.memberNickName);
                String s2 = listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.myPageImg;
                String s3 = "Y".equals(listFollowingAlphabetBaseRes$RESPONSE$USERLIST0.withDrawYn) ? "Y" : "N";
                Receiver toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
                toReceiverView$Receiver0.a = s;
                toReceiverView$Receiver0.b = null;
                toReceiverView$Receiver0.c = s1;
                toReceiverView$Receiver0.d = s2;
                toReceiverView$Receiver0.e = s3;
                if(!z) {
                    ((a)FollowingSelectFragment.this.getOnAddedFriendListListener()).b(toReceiverView$Receiver0);
                }
                else if(!((a)FollowingSelectFragment.this.getOnAddedFriendListListener()).a(FollowingSelectFragment.this.getActivity(), toReceiverView$Receiver0)) {
                    return;
                }
            }
            super.setMarked(v, z);
        }
    }

    private static final String TAG = "FollowingSelectFragment";
    private int mCurrentFilterIndex;
    private ArrayList mFilterList;
    private int mFrom;

    public FollowingSelectFragment() {
        this.mCurrentFilterIndex = 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        ToolBar toolBar0 = (ToolBar)this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        this.mToolBar = toolBar0;
        return this.mFrom == 0 ? ToolBar.f(toolBar0, 506) : ToolBar.f(toolBar0, 504);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new AlphabetAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        return j00;
    }

    // 去混淆评级： 低(20)
    public static String g0(FollowingSelectFragment followingSelectFragment0) {
        return "";
    }

    private String getFilterName() [...] // 潜在的解密器

    private String getOrigin() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static String h0(FollowingSelectFragment followingSelectFragment0) {
        return "";
    }

    public static FollowingSelectFragment newInstance(ArrayList arrayList0, Sharable sharable0, int v, int v1) {
        FollowingSelectFragment followingSelectFragment0 = new FollowingSelectFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelableArrayList("argFriendReceiverList", arrayList0);
        bundle0.putParcelable("argAttachedSharable", ((Parcelable)sharable0));
        bundle0.putInt("argFriendMaxCount", v);
        bundle0.putInt("argWhereRUFrom", v1);
        followingSelectFragment0.setArguments(bundle0);
        return followingSelectFragment0;
    }

    @Override  // com.iloen.melon.fragments.friend.FriendBaseSelectFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D027F, viewGroup0, false);  // layout:following_search_and_add
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        j0 j00 = this.mAdapter;
        if(!(j00 instanceof AlphabetAdapter)) {
            return false;
        }
        boolean z = i.b.equals(i0);
        if(z) {
            ((AlphabetAdapter)j00).clear(false);
        }
        Params listFollowingAlphabetBaseReq$Params0 = new Params();
        listFollowingAlphabetBaseReq$Params0.startIndex = z ? 1 : ((AlphabetAdapter)j00).getCount() + 1;
        listFollowingAlphabetBaseReq$Params0.pageSize = 100;
        listFollowingAlphabetBaseReq$Params0.originCode = "";
        MessageListFollowingAlphabetReq messageListFollowingAlphabetReq0 = this.mFrom == 0 ? new MessageListFollowingAlphabetReq(this.getContext(), listFollowingAlphabetBaseReq$Params0) : new GiftListFollowingAlphabetReq(this.getContext(), listFollowingAlphabetBaseReq$Params0);
        RequestBuilder.newInstance(messageListFollowingAlphabetReq0).tag("FollowingSelectFragment").listener(new Listener() {
            public void onResponse(ListFollowingAlphabetBaseRes listFollowingAlphabetBaseRes0) {
                if(!FollowingSelectFragment.this.prepareFetchComplete(listFollowingAlphabetBaseRes0)) {
                    if(FollowingSelectFragment.this.mAdapter != null) {
                        FollowingSelectFragment.this.mAdapter.notifyDataSetChanged();
                    }
                    return;
                }
                FollowingSelectFragment.this.performFetchComplete(i0, listFollowingAlphabetBaseRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ListFollowingAlphabetBaseRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                FollowingSelectFragment.this.performFetchError(volleyError0);
                if(FollowingSelectFragment.this.mAdapter != null) {
                    FollowingSelectFragment.this.mAdapter.notifyDataSetChanged();
                }
            }
        }).request();
        return true;
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
        this.mFilterList = new ArrayList();
        v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.b = this.getString(0x7F13024E);  // string:ctx_menu_friend_all "전체"
        j0.c = "A";
        this.mFilterList.add(j0);
        v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j1.b = this.getString(0x7F130252);  // string:ctx_menu_friend_melon "멜론친구"
        j1.c = "M";
        this.mFilterList.add(j1);
        v9.j j2 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j2.b = this.getString(0x7F130250);  // string:ctx_menu_friend_facebook "페이스북친구"
        j2.c = "F";
        this.mFilterList.add(j2);
        v9.j j3 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j3.b = this.getString(0x7F130251);  // string:ctx_menu_friend_kakaotalk "카카오톡친구"
        j3.c = "K";
        this.mFilterList.add(j3);
        v9.j j4 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j4.b = this.getString(0x7F13024F);  // string:ctx_menu_friend_contact "연락처친구"
        j4.c = "P";
        this.mFilterList.add(j4);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

