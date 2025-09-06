package com.iloen.melon.fragments.present;

import Gd.f;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.session.H0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.GiftListGiftBoxReceiveReq;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxReceiveRes.RESPONSE.GIFTLIST;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxReceiveRes.RESPONSE;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxReceiveRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e1.u;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000 )2\u00020\u0001:\u0005)*+,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001B\u0010\u001D\u001A\u0006\u0012\u0002\b\u00030\u001C2\u0006\u0010\u001B\u001A\u00020\u001AH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u0011\u0010 \u001A\u0004\u0018\u00010\u001FH\u0014¢\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#R$\u0010$\u001A\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b$\u0010%\u001A\u0004\b&\u0010#\"\u0004\b\'\u0010(¨\u0006."}, d2 = {"Lcom/iloen/melon/fragments/present/PresentReceivedListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCacheKey", "()Ljava/lang/String;", "mLastIndexKey", "Ljava/lang/String;", "getMLastIndexKey", "setMLastIndexKey", "(Ljava/lang/String;)V", "Companion", "PresentReceiveAdapter", "PresentReceiveViewHolder", "HeaderViewHolder", "SpacesItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PresentReceivedListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentReceivedListFragment$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "ROW_SIZE", "", "newInstance", "Lcom/iloen/melon/fragments/present/PresentReceivedListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PresentReceivedListFragment newInstance() {
            return new PresentReceivedListFragment();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\r\u001A\u00020\f8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentReceivedListFragment$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/present/PresentReceivedListFragment;Landroid/view/View;)V", "btnSend", "Landroid/view/View;", "getBtnSend", "()Landroid/view/View;", "setBtnSend", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "refreshIv", "Landroid/widget/ImageView;", "getRefreshIv", "()Landroid/widget/ImageView;", "setRefreshIv", "(Landroid/widget/ImageView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class HeaderViewHolder extends O0 {
        @NotNull
        private View btnSend;
        @NotNull
        private ImageView refreshIv;

        public HeaderViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            PresentReceivedListFragment.this = presentReceivedListFragment0;
            super(view0);
            View view1 = view0.findViewById(0x7F0A01AC);  // id:btn_send
            q.f(view1, "findViewById(...)");
            this.btnSend = view1;
            View view2 = view0.findViewById(0x7F0A09D7);  // id:refresh_iv
            q.f(view2, "findViewById(...)");
            this.refreshIv = (ImageView)view2;
        }

        @NotNull
        public final View getBtnSend() {
            return this.btnSend;
        }

        @NotNull
        public final ImageView getRefreshIv() {
            return this.refreshIv;
        }

        public final void setBtnSend(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.btnSend = view0;
        }

        public final void setRefreshIv(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.refreshIv = imageView0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001A\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\fR\u001A\u0010\u001D\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001D\u0010\u001B\u001A\u0004\b\u001E\u0010\f¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentReceivedListFragment$PresentReceiveAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/GiftListGiftBoxReceiveRes$RESPONSE$GIFTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/present/PresentReceivedListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "getVIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "getVIEW_TYPE_ITEM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class PresentReceiveAdapter extends p {
        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_ITEM;

        public PresentReceiveAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            PresentReceivedListFragment.this = presentReceivedListFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ITEM = 1;
        }

        public static void c(GIFTLIST giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0, View view0) {
            PresentReceiveAdapter.onBindViewImpl$lambda$2(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? this.VIEW_TYPE_HEADER : this.VIEW_TYPE_ITEM;
        }

        public final int getVIEW_TYPE_HEADER() {
            return this.VIEW_TYPE_HEADER;
        }

        public final int getVIEW_TYPE_ITEM() {
            return this.VIEW_TYPE_ITEM;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            int v3;
            q.g(o00, "viewHolder");
            if(o00 instanceof HeaderViewHolder) {
                ViewUtils.setOnClickListener(((HeaderViewHolder)o00).getBtnSend(), new f(6));
                ViewUtils.setOnClickListener(((HeaderViewHolder)o00).getRefreshIv(), new a(0, PresentReceivedListFragment.this, this));
                return;
            }
            if(o00 instanceof PresentReceiveViewHolder) {
                PresentReceiveViewHolder presentReceivedListFragment$PresentReceiveViewHolder0 = (PresentReceiveViewHolder)o00;
                Object object0 = this.getItem(v1);
                q.f(object0, "getItem(...)");
                GIFTLIST giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0 = (GIFTLIST)object0;
                presentReceivedListFragment$PresentReceiveViewHolder0.getName().setText(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.sendMemNickName);
                presentReceivedListFragment$PresentReceiveViewHolder0.getDate().setText(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.recvDate2);
                presentReceivedListFragment$PresentReceiveViewHolder0.getExpireDate().setText("선물 사용 유효기간ㅣ " + giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.expireDate);
                int v2 = giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.giftProdGubun == null || giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.giftProdGubun.length() == 0 ? 0 : StringUtils.getNumberFromString(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.giftProdGubun);
                ViewUtils.showWhen(presentReceivedListFragment$PresentReceiveViewHolder0.getThumbContainer(), v2 == 1);
                ViewUtils.showWhen(presentReceivedListFragment$PresentReceiveViewHolder0.getGiftBackground(), v2 == 0);
                ViewUtils.showWhen(presentReceivedListFragment$PresentReceiveViewHolder0.getProductContainer(), v2 == 0);
                ViewUtils.showWhen(presentReceivedListFragment$PresentReceiveViewHolder0.getGiftConfirm(), "N".equals(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.giftCHK));
                if(v2 == 1) {
                    Glide.with(this.getContext()).load(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.albumImg).into(presentReceivedListFragment$PresentReceiveViewHolder0.getItemThumbnail());
                    StringBuilder stringBuilder0 = new StringBuilder(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.songName);
                    String s = ProtocolUtils.getArtistNames(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.artistList);
                    if(!TextUtils.isEmpty(s)) {
                        stringBuilder0.append(String.format(" - %s", Arrays.copyOf(new Object[]{s}, 1)));
                    }
                    presentReceivedListFragment$PresentReceiveViewHolder0.getTitle().setText(stringBuilder0);
                    if("Y".equals(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.giftCHK)) {
                        try {
                            Integer integer0 = Integer.valueOf(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.songCnt);
                            q.f(integer0, "valueOf(...)");
                            v3 = 0;
                            v3 = integer0.intValue();
                        }
                        catch(NumberFormatException unused_ex) {
                        }
                        if(v3 > 1) {
                            presentReceivedListFragment$PresentReceiveViewHolder0.getSongCount().setVisibility(0);
                            q.f(" 외 %d곡", "getString(...)");
                            Z.y(new Object[]{((int)(v3 - 1))}, 1, " 외 %d곡", presentReceivedListFragment$PresentReceiveViewHolder0.getSongCount());
                        }
                        else {
                            presentReceivedListFragment$PresentReceiveViewHolder0.getSongCount().setVisibility(8);
                        }
                    }
                    else {
                        presentReceivedListFragment$PresentReceiveViewHolder0.getSongCount().setVisibility(8);
                    }
                }
                else {
                    presentReceivedListFragment$PresentReceiveViewHolder0.getSongCount().setVisibility(8);
                    presentReceivedListFragment$PresentReceiveViewHolder0.getTitle().setText(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.prodName);
                    if("1B0006".equalsIgnoreCase(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.statusCode)) {
                        presentReceivedListFragment$PresentReceiveViewHolder0.getGiftBackground().setImageResource(0x7F0808BC);  // drawable:shape_rectangle_gray100a_0_5dp_stroke_gray400s_bg_round4
                        presentReceivedListFragment$PresentReceiveViewHolder0.getGiftIcon().setAlpha(0.6f);
                        presentReceivedListFragment$PresentReceiveViewHolder0.getProductUseText().setText("사용");
                    }
                    else {
                        presentReceivedListFragment$PresentReceiveViewHolder0.getGiftBackground().setImageResource(0x7F0808B9);  // drawable:shape_rectangle_gray100a_0_5dp_blue400s_bg_round4
                        presentReceivedListFragment$PresentReceiveViewHolder0.getGiftIcon().setAlpha(0.8f);
                        presentReceivedListFragment$PresentReceiveViewHolder0.getProductUseText().setText("선물 사용 : 미사용");
                    }
                }
                ViewUtils.setOnClickListener(presentReceivedListFragment$PresentReceiveViewHolder0.getThumbnailContainer(), new com.iloen.melon.fragments.detail.viewholder.p(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0, 7));
            }
        }

        private static final void onBindViewImpl$lambda$0(View view0) {
            Navigator.openPresentSongSendFragment$default(null, null, null, 7, null);
        }

        private static final void onBindViewImpl$lambda$1(PresentReceivedListFragment presentReceivedListFragment0, PresentReceiveAdapter presentReceivedListFragment$PresentReceiveAdapter0, View view0) {
            if(presentReceivedListFragment0.mAdapter instanceof PresentReceiveAdapter) {
                j0 j00 = presentReceivedListFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentReceivedListFragment.PresentReceiveAdapter");
                ((PresentReceiveAdapter)j00).clearCache(presentReceivedListFragment$PresentReceiveAdapter0.getCacheKey());
            }
            presentReceivedListFragment0.startFetch("refresh");
        }

        private static final void onBindViewImpl$lambda$2(GIFTLIST giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0, View view0) {
            giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.giftCHK = "Y";
            Navigator.openGiftBoxDetailById(giftListGiftBoxReceiveRes$RESPONSE$GIFTLIST0.giftNo);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05B5, viewGroup0, false);  // layout:present_header
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(PresentReceivedListFragment.this, view0);
            }
            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05B8, viewGroup0, false);  // layout:present_receive_list_item
            q.f(view1, "inflate(...)");
            return new PresentReceiveViewHolder(PresentReceivedListFragment.this, view1);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\f\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\f\u0010\u0007\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000BR\"\u0010\u0010\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001A\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001A\u0004\b\u001A\u0010\u0013\"\u0004\b\u001B\u0010\u0015R\"\u0010\u001C\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001C\u0010\u0007\u001A\u0004\b\u001D\u0010\t\"\u0004\b\u001E\u0010\u000BR\"\u0010 \u001A\u00020\u001F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001A\u00020\u001F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b&\u0010!\u001A\u0004\b\'\u0010#\"\u0004\b(\u0010%R\"\u0010)\u001A\u00020\u001F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010!\u001A\u0004\b*\u0010#\"\u0004\b+\u0010%R\"\u0010,\u001A\u00020\u001F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b,\u0010!\u001A\u0004\b-\u0010#\"\u0004\b.\u0010%R\"\u0010/\u001A\u00020\u001F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b/\u0010!\u001A\u0004\b0\u0010#\"\u0004\b1\u0010%R\"\u00102\u001A\u00020\u001F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b2\u0010!\u001A\u0004\b3\u0010#\"\u0004\b4\u0010%R\u0017\u00105\u001A\u00020\u001F8\u0006\u00A2\u0006\f\n\u0004\b5\u0010!\u001A\u0004\b6\u0010#\u00A8\u00067"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentReceivedListFragment$PresentReceiveViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/present/PresentReceivedListFragment;Landroid/view/View;)V", "thumbnailContainer", "Landroid/view/View;", "getThumbnailContainer", "()Landroid/view/View;", "setThumbnailContainer", "(Landroid/view/View;)V", "thumbContainer", "getThumbContainer", "setThumbContainer", "Landroid/widget/ImageView;", "itemThumbnail", "Landroid/widget/ImageView;", "getItemThumbnail", "()Landroid/widget/ImageView;", "setItemThumbnail", "(Landroid/widget/ImageView;)V", "giftBackground", "getGiftBackground", "setGiftBackground", "giftIcon", "getGiftIcon", "setGiftIcon", "productContainer", "getProductContainer", "setProductContainer", "Landroid/widget/TextView;", "productUseText", "Landroid/widget/TextView;", "getProductUseText", "()Landroid/widget/TextView;", "setProductUseText", "(Landroid/widget/TextView;)V", "title", "getTitle", "setTitle", "songCount", "getSongCount", "setSongCount", "giftConfirm", "getGiftConfirm", "setGiftConfirm", "date", "getDate", "setDate", "name", "getName", "setName", "expireDate", "getExpireDate", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PresentReceiveViewHolder extends O0 {
        @NotNull
        private TextView date;
        @NotNull
        private final TextView expireDate;
        @NotNull
        private ImageView giftBackground;
        @NotNull
        private TextView giftConfirm;
        @NotNull
        private ImageView giftIcon;
        @NotNull
        private ImageView itemThumbnail;
        @NotNull
        private TextView name;
        @NotNull
        private View productContainer;
        @NotNull
        private TextView productUseText;
        @NotNull
        private TextView songCount;
        @NotNull
        private View thumbContainer;
        @NotNull
        private View thumbnailContainer;
        @NotNull
        private TextView title;

        public PresentReceiveViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            PresentReceivedListFragment.this = presentReceivedListFragment0;
            super(view0);
            View view1 = view0.findViewById(0x7F0A0B84);  // id:thumbnail_container
            q.f(view1, "findViewById(...)");
            this.thumbnailContainer = view1;
            View view2 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
            q.f(view2, "findViewById(...)");
            this.thumbContainer = view2;
            View view3 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
            q.f(view3, "findViewById(...)");
            this.itemThumbnail = (ImageView)view3;
            View view4 = view0.findViewById(0x7F0A04F0);  // id:gift_bg
            q.f(view4, "findViewById(...)");
            this.giftBackground = (ImageView)view4;
            View view5 = view0.findViewById(0x7F0A04F1);  // id:gift_icon
            q.f(view5, "findViewById(...)");
            this.giftIcon = (ImageView)view5;
            View view6 = view0.findViewById(0x7F0A0968);  // id:product_gift_container
            q.f(view6, "findViewById(...)");
            this.productContainer = view6;
            View view7 = view0.findViewById(0x7F0A0D84);  // id:use_text
            q.f(view7, "findViewById(...)");
            this.productUseText = (TextView)view7;
            View view8 = view0.findViewById(0x7F0A0B8D);  // id:title
            q.f(view8, "findViewById(...)");
            this.title = (TextView)view8;
            View view9 = view0.findViewById(0x7F0A0AA5);  // id:song_count
            q.f(view9, "findViewById(...)");
            this.songCount = (TextView)view9;
            View view10 = view0.findViewById(0x7F0A0B9C);  // id:title_icon
            q.f(view10, "findViewById(...)");
            this.giftConfirm = (TextView)view10;
            View view11 = view0.findViewById(0x7F0A037A);  // id:date
            q.f(view11, "findViewById(...)");
            this.date = (TextView)view11;
            View view12 = view0.findViewById(0x7F0A08B4);  // id:nick_name
            q.f(view12, "findViewById(...)");
            this.name = (TextView)view12;
            View view13 = view0.findViewById(0x7F0A047B);  // id:expire_date
            q.f(view13, "findViewById(...)");
            this.expireDate = (TextView)view13;
        }

        @NotNull
        public final TextView getDate() {
            return this.date;
        }

        @NotNull
        public final TextView getExpireDate() {
            return this.expireDate;
        }

        @NotNull
        public final ImageView getGiftBackground() {
            return this.giftBackground;
        }

        @NotNull
        public final TextView getGiftConfirm() {
            return this.giftConfirm;
        }

        @NotNull
        public final ImageView getGiftIcon() {
            return this.giftIcon;
        }

        @NotNull
        public final ImageView getItemThumbnail() {
            return this.itemThumbnail;
        }

        @NotNull
        public final TextView getName() {
            return this.name;
        }

        @NotNull
        public final View getProductContainer() {
            return this.productContainer;
        }

        @NotNull
        public final TextView getProductUseText() {
            return this.productUseText;
        }

        @NotNull
        public final TextView getSongCount() {
            return this.songCount;
        }

        @NotNull
        public final View getThumbContainer() {
            return this.thumbContainer;
        }

        @NotNull
        public final View getThumbnailContainer() {
            return this.thumbnailContainer;
        }

        @NotNull
        public final TextView getTitle() {
            return this.title;
        }

        public final void setDate(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.date = textView0;
        }

        public final void setGiftBackground(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.giftBackground = imageView0;
        }

        public final void setGiftConfirm(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.giftConfirm = textView0;
        }

        public final void setGiftIcon(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.giftIcon = imageView0;
        }

        public final void setItemThumbnail(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.itemThumbnail = imageView0;
        }

        public final void setName(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.name = textView0;
        }

        public final void setProductContainer(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.productContainer = view0;
        }

        public final void setProductUseText(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.productUseText = textView0;
        }

        public final void setSongCount(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.songCount = textView0;
        }

        public final void setThumbContainer(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.thumbContainer = view0;
        }

        public final void setThumbnailContainer(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.thumbnailContainer = view0;
        }

        public final void setTitle(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.title = textView0;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\"\u0010\u0012\u001A\u00020\u00118\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentReceivedListFragment$SpacesItemDecoration;", "Landroidx/recyclerview/widget/r0;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/present/PresentReceivedListFragment;Landroid/content/Context;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "", "margin", "I", "getMargin", "()I", "setMargin", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class SpacesItemDecoration extends r0 {
        private int margin;

        public SpacesItemDecoration(@Nullable Context context0) {
            this.margin = ScreenUtils.dipToPixel(context0, 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            int v = recyclerView0.getChildLayoutPosition(view0);
            if(v == 0) {
                rect0.left = 0;
                rect0.right = 0;
                return;
            }
            if(v % 2 == 1) {
                rect0.left = this.margin;
                rect0.right = this.margin / 2;
                return;
            }
            rect0.left = this.margin / 2;
            rect0.right = this.margin;
        }

        public final int getMargin() {
            return this.margin;
        }

        public final void setMargin(int v) {
            this.margin = v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PAGE_SIZE = "10";
    private static final int ROW_SIZE = 2;
    @NotNull
    private static final String TAG = "PresentReceivedListFragment";
    @Nullable
    private String mLastIndexKey;

    static {
        PresentReceivedListFragment.Companion = new Companion(null);
        PresentReceivedListFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new PresentReceiveAdapter(this, context0, null);
    }

    public static void d0(PresentReceivedListFragment presentReceivedListFragment0, i i0, GiftListGiftBoxReceiveRes giftListGiftBoxReceiveRes0) {
        PresentReceivedListFragment.onFetchStart$lambda$1(presentReceivedListFragment0, i0, giftListGiftBoxReceiveRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.d0.buildUpon().appendQueryParameter("memberKey", u.v(((e0)o.a()).j())).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Nullable
    public final String getMLastIndexKey() {
        return this.mLastIndexKey;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), 2);
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                if(PresentReceivedListFragment.this.mAdapter instanceof p) {
                    j0 j00 = PresentReceivedListFragment.this.mAdapter;
                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MelonArrayAdapter<*, *>");
                    return !((p)j00).isReservedPosition(v) && v != 0 ? 1 : 2;
                }
                return 1;
            }
        };
        if(recyclerView0 != null) {
            recyclerView0.setLayoutManager(gridLayoutManager0);
        }
        if(recyclerView0 != null) {
            recyclerView0.addItemDecoration(new SpacesItemDecoration(this, this.getContext()));
        }
        if(recyclerView0 != null) {
            recyclerView0.setAdapter(this.mAdapter);
        }
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D05B7, viewGroup0, false);  // layout:present_list
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        if(i.b.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentReceivedListFragment.PresentReceiveAdapter");
            ((PresentReceiveAdapter)j00).clear();
            this.mLastIndexKey = null;
        }
        RequestBuilder.newInstance(new GiftListGiftBoxReceiveReq(this.getContext(), this.mLastIndexKey, "10")).tag("PresentReceivedListFragment").listener(new H0(13, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(PresentReceivedListFragment presentReceivedListFragment0, i i0, GiftListGiftBoxReceiveRes giftListGiftBoxReceiveRes0) {
        if(!presentReceivedListFragment0.prepareFetchComplete(giftListGiftBoxReceiveRes0)) {
            return;
        }
        if(giftListGiftBoxReceiveRes0 != null) {
            RESPONSE giftListGiftBoxReceiveRes$RESPONSE0 = giftListGiftBoxReceiveRes0.response;
            if(giftListGiftBoxReceiveRes$RESPONSE0 != null) {
                presentReceivedListFragment0.mLastIndexKey = giftListGiftBoxReceiveRes$RESPONSE0.lastIndexKey;
            }
        }
        presentReceivedListFragment0.performFetchComplete(i0, giftListGiftBoxReceiveRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    public final void setMLastIndexKey(@Nullable String s) {
        this.mLastIndexKey = s;
    }
}

