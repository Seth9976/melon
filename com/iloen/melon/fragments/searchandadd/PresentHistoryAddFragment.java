package com.iloen.melon.fragments.searchandadd;

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
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.friend.FriendBaseSelectFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.GiftListUserByGiftBoxReq.Params;
import com.iloen.melon.net.v4x.request.GiftListUserByGiftBoxReq;
import com.iloen.melon.net.v4x.response.GiftListUserByGiftBoxRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v4x.response.GiftListUserByGiftBoxRes.RESPONSE;
import com.iloen.melon.net.v4x.response.GiftListUserByGiftBoxRes;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import e1.u;
import java.util.ArrayList;
import java.util.List;
import l8.a;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class PresentHistoryAddFragment extends FriendBaseSelectFragment {
    public static class ItemViewHolder extends O0 {
        private ImageView checkIcon;
        private TextView date;
        private ImageView defaultUserImage;
        private ImageView djIcon;
        private ImageView snsIcon;
        private BorderImageView userImage;
        private TextView userName;

        public ItemViewHolder(View view0, Context context0) {
            super(view0);
            this.userImage = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
            this.defaultUserImage = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
            this.djIcon = (ImageView)view0.findViewById(0x7F0A06A7);  // id:iv_thumbnail_circle_badge
            this.snsIcon = (ImageView)view0.findViewById(0x7F0A068D);  // id:iv_sns_icon
            this.userName = (TextView)view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
            TextView textView0 = (TextView)view0.findViewById(0x7F0A0C59);  // id:tv_date
            this.date = textView0;
            ViewUtils.showWhen(textView0, true);
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
            this.checkIcon = imageView0;
            ViewUtils.showWhen(imageView0, true);
        }
    }

    public static class PresentHistoryAdatper extends p {
        public interface ItemMarkedListener {
            boolean onItemMarked(USERLIST arg1, boolean arg2);
        }

        public interface OnItemViewClickListener {
            void onItemViewClick(View arg1, int arg2);
        }

        private static final int VIEW_TYPE_ITEM;
        private ItemMarkedListener mOnItemMarkedListener;
        private OnItemViewClickListener mOnItemViewClickListener;
        private int mUserImageWidth;

        public PresentHistoryAdatper(Context context0, List list0) {
            super(context0, list0);
            this.mOnItemViewClickListener = null;
            this.setMarkedMode(true);
            this.mUserImageWidth = ScreenUtils.dipToPixel(context0, 65.0f);
        }

        private int getGroupResId(String s) {
            if("F".equals(s)) {
                return 0x7F0803EA;  // drawable:ic_common_facebook_16
            }
            if("P".equals(s)) {
                return 0x7F0803E3;  // drawable:ic_common_contact_16
            }
            return "K".equals(s) ? 0x7F0803F7 : -1;  // drawable:ic_common_kakao_16
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(!(o00 instanceof ItemViewHolder)) {
                return;
            }
            USERLIST giftListUserByGiftBoxRes$RESPONSE$USERLIST0 = (USERLIST)this.getItem(v1);
            String s = TextUtils.isEmpty(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.myPageImg) ? giftListUserByGiftBoxRes$RESPONSE$USERLIST0.fbImageUrl : giftListUserByGiftBoxRes$RESPONSE$USERLIST0.myPageImg;
            if(((ItemViewHolder)o00).userImage != null) {
                Glide.with(((ItemViewHolder)o00).userImage.getContext()).load(s).apply(RequestOptions.circleCropTransform()).into(((ItemViewHolder)o00).userImage);
            }
            int v2 = ResourceUtils.getDjIconResId(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.memberDjType);
            ViewUtils.showWhen(((ItemViewHolder)o00).djIcon, v2 > 0);
            if(v2 > 0) {
                ((ItemViewHolder)o00).djIcon.setImageResource(v2);
            }
            ViewUtils.setDefaultImage(((ItemViewHolder)o00).defaultUserImage, this.mUserImageWidth, true);
            int v3 = this.getGroupResId(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.frendAddOrigin);
            if(v3 > 0) {
                ViewUtils.showWhen(((ItemViewHolder)o00).snsIcon, true);
                ((ItemViewHolder)o00).snsIcon.setBackgroundResource(v3);
            }
            else {
                ViewUtils.showWhen(((ItemViewHolder)o00).snsIcon, false);
            }
            if(TextUtils.isEmpty(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.phoneNumber)) {
                ((ItemViewHolder)o00).userName.setText(StringUtils.getFriendDisplayName(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.memberKey, giftListUserByGiftBoxRes$RESPONSE$USERLIST0.memberNickName, giftListUserByGiftBoxRes$RESPONSE$USERLIST0.fbNickName));
            }
            else {
                ((ItemViewHolder)o00).userName.setText(StringUtils.getNonVisibleCenterPhoneNumber(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.phoneNumber));
            }
            ((ItemViewHolder)o00).date.setText(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.sendDate);
            com.iloen.melon.fragments.searchandadd.PresentHistoryAddFragment.PresentHistoryAdatper.1 presentHistoryAddFragment$PresentHistoryAdatper$10 = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(PresentHistoryAdatper.this.mOnItemViewClickListener != null) {
                        PresentHistoryAdatper.this.mOnItemViewClickListener.onItemViewClick(view0, v);
                    }
                }
            };
            ViewUtils.setOnClickListener(((ItemViewHolder)o00).itemView, presentHistoryAddFragment$PresentHistoryAdatper$10);
            if(this.isMarked(v1)) {
                ((ItemViewHolder)o00).checkIcon.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                int v4 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                ((ItemViewHolder)o00).itemView.setBackgroundColor(v4);
                return;
            }
            ((ItemViewHolder)o00).checkIcon.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
            int v5 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
            ((ItemViewHolder)o00).itemView.setBackgroundColor(v5);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return new ItemViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04B9, viewGroup0, false), this.getContext());  // layout:listitem_user
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void setMarked(int v, boolean z) {
            if(this.mOnItemMarkedListener != null && this.mOnItemMarkedListener.onItemMarked(((USERLIST)this.getItem(v)), z)) {
                super.setMarked(v, z);
            }
        }

        public void setOnItemMarkedListener(ItemMarkedListener presentHistoryAddFragment$PresentHistoryAdatper$ItemMarkedListener0) {
            this.mOnItemMarkedListener = presentHistoryAddFragment$PresentHistoryAdatper$ItemMarkedListener0;
        }

        public void setOnItemViewClickListener(OnItemViewClickListener presentHistoryAddFragment$PresentHistoryAdatper$OnItemViewClickListener0) {
            this.mOnItemViewClickListener = presentHistoryAddFragment$PresentHistoryAdatper$OnItemViewClickListener0;
        }
    }

    private static final String PAGE_SIZE = "100";
    private static final String TAG = "PresentHistoryAddFragment";
    private String lastIndexKey;

    public PresentHistoryAddFragment() {
        this.lastIndexKey = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 504);  // id:toolbar_layout
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new PresentHistoryAdatper(context0, null);
        ((PresentHistoryAdatper)j00).setOnItemMarkedListener(new ItemMarkedListener() {
            @Override  // com.iloen.melon.fragments.searchandadd.PresentHistoryAddFragment$PresentHistoryAdatper$ItemMarkedListener
            public boolean onItemMarked(USERLIST giftListUserByGiftBoxRes$RESPONSE$USERLIST0, boolean z) {
                Receiver toReceiverView$Receiver0;
                LogU.d("PresentHistoryAddFragment", "setMarked() marked : " + z);
                if(PresentHistoryAddFragment.this.getOnAddedFriendListListener() != null && giftListUserByGiftBoxRes$RESPONSE$USERLIST0 != null) {
                    if("1".equals(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.memberStatus)) {
                        l0 l00 = PresentHistoryAddFragment.this.getChildFragmentManager();
                        String s = PresentHistoryAddFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                        String s1 = PresentHistoryAddFragment.this.getString(0x7F130472);  // string:friend_is_withidraw_member "탈퇴한 회원입니다."
                        b.a.c(l00, s, s1);
                        return false;
                    }
                    if(TextUtils.isEmpty(giftListUserByGiftBoxRes$RESPONSE$USERLIST0.phoneNumber)) {
                        String s2 = giftListUserByGiftBoxRes$RESPONSE$USERLIST0.memberKey;
                        String s3 = giftListUserByGiftBoxRes$RESPONSE$USERLIST0.memberNickName;
                        toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
                        toReceiverView$Receiver0.a = s2;
                        toReceiverView$Receiver0.b = null;
                        toReceiverView$Receiver0.c = s3;
                    }
                    else {
                        String s4 = giftListUserByGiftBoxRes$RESPONSE$USERLIST0.memberKey;
                        String s5 = giftListUserByGiftBoxRes$RESPONSE$USERLIST0.phoneNumber;
                        toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
                        toReceiverView$Receiver0.a = s4;
                        toReceiverView$Receiver0.b = s5;
                        toReceiverView$Receiver0.c = null;
                    }
                    toReceiverView$Receiver0.d = null;
                    toReceiverView$Receiver0.e = null;
                    if(z) {
                        return ((a)PresentHistoryAddFragment.this.getOnAddedFriendListListener()).a(PresentHistoryAddFragment.this.getActivity(), toReceiverView$Receiver0);
                    }
                    ((a)PresentHistoryAddFragment.this.getOnAddedFriendListListener()).b(toReceiverView$Receiver0);
                    return true;
                }
                return false;
            }
        });
        ((PresentHistoryAdatper)j00).setOnItemViewClickListener(new OnItemViewClickListener() {
            @Override  // com.iloen.melon.fragments.searchandadd.PresentHistoryAddFragment$PresentHistoryAdatper$OnItemViewClickListener
            public void onItemViewClick(View view0, int v) {
                PresentHistoryAddFragment.this.onItemClick(view0, v);
            }
        });
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.G.buildUpon().appendPath("giftRecentlyFriends").appendPath(u.v(((e0)o.a()).j())).build().toString();
    }

    public static PresentHistoryAddFragment newInstance(ArrayList arrayList0, int v) {
        PresentHistoryAddFragment presentHistoryAddFragment0 = new PresentHistoryAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelableArrayList("argFriendReceiverList", arrayList0);
        bundle0.putInt("argFriendMaxCount", v);
        bundle0.putInt("argToolbarType", 504);
        presentHistoryAddFragment0.setArguments(bundle0);
        return presentHistoryAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D05B6, viewGroup0, false);  // layout:present_history_add
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Params giftListUserByGiftBoxReq$Params0 = new Params();
        giftListUserByGiftBoxReq$Params0.lastIndexKey = this.lastIndexKey;
        giftListUserByGiftBoxReq$Params0.pageSize = "100";
        RequestBuilder.newInstance(new GiftListUserByGiftBoxReq(this.getContext(), giftListUserByGiftBoxReq$Params0)).tag("PresentHistoryAddFragment").listener(new Listener() {
            public void onResponse(GiftListUserByGiftBoxRes giftListUserByGiftBoxRes0) {
                if(!PresentHistoryAddFragment.this.prepareFetchComplete(giftListUserByGiftBoxRes0)) {
                    return;
                }
                if(giftListUserByGiftBoxRes0 != null) {
                    RESPONSE giftListUserByGiftBoxRes$RESPONSE0 = giftListUserByGiftBoxRes0.response;
                    if(giftListUserByGiftBoxRes$RESPONSE0 != null) {
                        PresentHistoryAddFragment.this.lastIndexKey = giftListUserByGiftBoxRes$RESPONSE0.lastIndexKey;
                    }
                }
                PresentHistoryAddFragment.this.performFetchComplete(i0, giftListUserByGiftBoxRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((GiftListUserByGiftBoxRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        if(v == 9 && this.getOnAddedFriendListListener() != null) {
            ((a)this.getOnAddedFriendListListener()).c(this.getActivity());
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle("최근 보낸 친구 선택하기");
            titleBar0.f(true);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

