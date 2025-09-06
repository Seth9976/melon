package com.iloen.melon.fragments.present;

import Gd.f;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.session.H0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.GiftListGiftBoxSendReq;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxSendRes.RESPONSE.GIFTLIST;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxSendRes.RESPONSE;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxSendRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
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
import va.e;
import va.o;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0004,-./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\u001B\u0010 \u001A\u0006\u0012\u0002\b\u00030\u001F2\u0006\u0010\u001E\u001A\u00020\u001DH\u0014¢\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0014¢\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0018H\u0016¢\u0006\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001A\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010+\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b+\u0010(¨\u00060"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCacheKey", "()Ljava/lang/String;", "TAG", "Ljava/lang/String;", "PAGE_SIZE", "ARG_LAST_INDEX_KEY", "mLastIndexKey", "Companion", "PresentSendAdapter", "PresentSendViewHolder", "HeaderViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PresentSendListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendListFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/present/PresentSendListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PresentSendListFragment newInstance() {
            return new PresentSendListFragment();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0019\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendListFragment$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "btnSend", "Landroid/view/View;", "getBtnSend", "()Landroid/view/View;", "Landroid/widget/ImageView;", "refreshIv", "Landroid/widget/ImageView;", "getRefreshIv", "()Landroid/widget/ImageView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class HeaderViewHolder extends O0 {
        public static final int $stable = 8;
        @Nullable
        private final View btnSend;
        @Nullable
        private final ImageView refreshIv;

        public HeaderViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            super(view0);
            this.btnSend = view0.findViewById(0x7F0A01AC);  // id:btn_send
            this.refreshIv = (ImageView)view0.findViewById(0x7F0A09D7);  // id:refresh_iv
            ViewUtils.hideWhen(view0.findViewById(0x7F0A0A69), true);  // id:separator
        }

        @Nullable
        public final View getBtnSend() {
            return this.btnSend;
        }

        @Nullable
        public final ImageView getRefreshIv() {
            return this.refreshIv;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001A\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\fR\u001A\u0010\u001D\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001D\u0010\u001B\u001A\u0004\b\u001E\u0010\f¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendListFragment$PresentSendAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/GiftListGiftBoxSendRes$RESPONSE$GIFTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/present/PresentSendListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "getVIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "getVIEW_TYPE_ITEM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class PresentSendAdapter extends p {
        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_ITEM;

        public PresentSendAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            PresentSendListFragment.this = presentSendListFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ITEM = 1;
        }

        public static void a(GIFTLIST giftListGiftBoxSendRes$RESPONSE$GIFTLIST0, View view0) {
            PresentSendAdapter.onBindViewImpl$lambda$3(giftListGiftBoxSendRes$RESPONSE$GIFTLIST0, view0);
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
            int v2;
            String s1;
            q.g(o00, "viewHolder");
            if(o00 instanceof HeaderViewHolder) {
                ViewUtils.setOnClickListener(((HeaderViewHolder)o00).getBtnSend(), new f(7));
                ViewUtils.setOnClickListener(((HeaderViewHolder)o00).getRefreshIv(), new a(2, PresentSendListFragment.this, this));
                return;
            }
            if(o00 instanceof PresentSendViewHolder) {
                GIFTLIST giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 = (GIFTLIST)this.getItem(v1);
                String s = null;
                boolean z = false;
                if(TextUtils.isEmpty((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.giftProdGubun))) {
                    v2 = 0;
                }
                else {
                    if(giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null) {
                        s1 = "";
                    }
                    else {
                        s1 = giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.giftProdGubun;
                        if(s1 == null) {
                            s1 = "";
                        }
                    }
                    Integer integer0 = Integer.valueOf(s1);
                    q.f(integer0, "valueOf(...)");
                    v2 = integer0.intValue();
                }
                ViewUtils.showWhen(((PresentSendViewHolder)o00).getThumbnail(), v2 == 1);
                ViewUtils.showWhen(((PresentSendViewHolder)o00).getProductThumbnail(), v2 == 0);
                ImageView imageView0 = ((PresentSendViewHolder)o00).getProductIcon();
                if(v2 == 0) {
                    z = true;
                }
                ViewUtils.showWhen(imageView0, z);
                TextView textView0 = ((PresentSendViewHolder)o00).getSongCount();
                if(textView0 != null) {
                    textView0.setText("");
                }
                if(v2 == 1) {
                    StringBuilder stringBuilder0 = new StringBuilder();
                    stringBuilder0.append((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.songName));
                    String s2 = ProtocolUtils.getArtistNames((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.artistList));
                    if(!TextUtils.isEmpty(s2)) {
                        stringBuilder0.append(String.format(" - %s", Arrays.copyOf(new Object[]{s2}, 1)));
                    }
                    TextView textView1 = ((PresentSendViewHolder)o00).getTitle();
                    if(textView1 != null) {
                        textView1.setText(stringBuilder0);
                    }
                    int v3 = StringUtils.getNumberFromString((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.songCnt));
                    if(v3 > 1) {
                        TextView textView2 = ((PresentSendViewHolder)o00).getSongCount();
                        if(textView2 != null) {
                            String s3 = PresentSendListFragment.this.getString(0x7F13001B);  // string:abount_song_count " 외 %d곡"
                            q.f(s3, "getString(...)");
                            Z.y(new Object[]{((int)(v3 - 1))}, 1, s3, textView2);
                        }
                    }
                    if(((PresentSendViewHolder)o00).getThumbnail() != null) {
                        Glide.with(((PresentSendViewHolder)o00).getThumbnail().getContext()).load((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.albumImg)).into(((PresentSendViewHolder)o00).getThumbnail());
                    }
                }
                else {
                    TextView textView3 = ((PresentSendViewHolder)o00).getTitle();
                    if(textView3 != null) {
                        textView3.setText((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.prodName));
                    }
                    ImageView imageView1 = ((PresentSendViewHolder)o00).getProductThumbnail();
                    if(imageView1 != null) {
                        imageView1.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060046));  // color:blue400s_support_high_contrast
                    }
                }
                TextView textView4 = ((PresentSendViewHolder)o00).getTitle();
                if(textView4 != null) {
                    textView4.requestLayout();
                }
                ViewUtils.showWhen(((PresentSendViewHolder)o00).getGiftConfirm(), "N".equals((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.giftCHK)));
                View view0 = ((PresentSendViewHolder)o00).getTitleContainer();
                if(view0 != null) {
                    view0.requestLayout();
                }
                ViewUtils.showWhen(((PresentSendViewHolder)o00).getSeparator(), true);
                StringBuilder stringBuilder1 = new StringBuilder();
                String s4 = giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.recvCntCtmdnNo;
                String s5 = giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.recvMemNickName;
                if(!TextUtils.isEmpty(s5)) {
                    stringBuilder1.append(s5);
                }
                if(!TextUtils.isEmpty(s4)) {
                    String s6 = StringUtils.getNonVisibleCenterPhoneNumber(s4);
                    if(stringBuilder1.length() > 0) {
                        e.g(stringBuilder1, " (", s6, ")");
                    }
                    else {
                        stringBuilder1.append(s6);
                    }
                }
                TextView textView5 = ((PresentSendViewHolder)o00).getName();
                if(textView5 != null) {
                    textView5.setText(stringBuilder1);
                }
                TextView textView6 = ((PresentSendViewHolder)o00).getDate();
                if(textView6 != null) {
                    textView6.setText((giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 == null ? null : giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.sendDate2));
                }
                if(giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 != null) {
                    s = giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.expireDate;
                }
                TextView textView7 = ((PresentSendViewHolder)o00).getExpireDate();
                if(textView7 != null) {
                    textView7.setText("선물 사용 유효기간ㅣ " + s);
                }
                ViewUtils.setOnClickListener(((PresentSendViewHolder)o00).getItemContainer(), new com.iloen.melon.fragments.detail.viewholder.p(giftListGiftBoxSendRes$RESPONSE$GIFTLIST0, 8));
            }
        }

        private static final void onBindViewImpl$lambda$0(View view0) {
            Navigator.openPresentSongSendFragment$default(null, null, null, 7, null);
        }

        private static final void onBindViewImpl$lambda$1(PresentSendListFragment presentSendListFragment0, PresentSendAdapter presentSendListFragment$PresentSendAdapter0, View view0) {
            if(presentSendListFragment0.mAdapter instanceof PresentSendAdapter) {
                j0 j00 = presentSendListFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentSendListFragment.PresentSendAdapter");
                ((PresentSendAdapter)j00).clearCache(presentSendListFragment$PresentSendAdapter0.getCacheKey());
            }
            presentSendListFragment0.startFetch("refresh");
        }

        private static final void onBindViewImpl$lambda$3(GIFTLIST giftListGiftBoxSendRes$RESPONSE$GIFTLIST0, View view0) {
            if(giftListGiftBoxSendRes$RESPONSE$GIFTLIST0 != null) {
                Navigator.INSTANCE.openPresentSendDetail(giftListGiftBoxSendRes$RESPONSE$GIFTLIST0.giftNo);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05B5, viewGroup0, false);  // layout:present_header
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(view0);
            }
            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05BD, viewGroup0, false);  // layout:present_sent_list_item
            q.f(view1, "inflate(...)");
            return new PresentSendViewHolder(view1);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0019\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0019\u0010\u000F\u001A\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0019\u0010\u0011\u001A\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001A\u0004\b\u0012\u0010\u000ER\u0019\u0010\u0013\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001A\u0004\b\u0014\u0010\tR\u0019\u0010\u0016\u001A\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001A\u001A\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0017\u001A\u0004\b\u001B\u0010\u0019R\u0019\u0010\u001C\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u0007\u001A\u0004\b\u001D\u0010\tR\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u0017\u001A\u0004\b\u001F\u0010\u0019R\u0019\u0010 \u001A\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b \u0010\u0017\u001A\u0004\b!\u0010\u0019R\u0019\u0010\"\u001A\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\"\u0010\u0017\u001A\u0004\b#\u0010\u0019R\u0019\u0010$\u001A\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b$\u0010\u0017\u001A\u0004\b%\u0010\u0019¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSendListFragment$PresentSendViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "itemContainer", "Landroid/view/View;", "getItemContainer", "()Landroid/view/View;", "Landroid/widget/ImageView;", "thumbnail", "Landroid/widget/ImageView;", "getThumbnail", "()Landroid/widget/ImageView;", "productThumbnail", "getProductThumbnail", "productIcon", "getProductIcon", "titleContainer", "getTitleContainer", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "songCount", "getSongCount", "separator", "getSeparator", "name", "getName", "date", "getDate", "expireDate", "getExpireDate", "giftConfirm", "getGiftConfirm", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PresentSendViewHolder extends O0 {
        public static final int $stable = 8;
        @Nullable
        private final TextView date;
        @Nullable
        private final TextView expireDate;
        @Nullable
        private final TextView giftConfirm;
        @Nullable
        private final View itemContainer;
        @Nullable
        private final TextView name;
        @Nullable
        private final ImageView productIcon;
        @Nullable
        private final ImageView productThumbnail;
        @Nullable
        private final View separator;
        @Nullable
        private final TextView songCount;
        @Nullable
        private final ImageView thumbnail;
        @Nullable
        private final TextView title;
        @Nullable
        private final View titleContainer;

        public PresentSendViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            super(view0);
            this.itemContainer = view0.findViewById(0x7F0A05A7);  // id:item_container
            this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.productThumbnail = (ImageView)view0.findViewById(0x7F0A096B);  // id:product_thumbnail
            this.productIcon = (ImageView)view0.findViewById(0x7F0A0969);  // id:product_icon
            this.titleContainer = view0.findViewById(0x7F0A0B96);  // id:title_container
            this.title = (TextView)view0.findViewById(0x7F0A0B8D);  // id:title
            this.songCount = (TextView)view0.findViewById(0x7F0A0AA5);  // id:song_count
            this.separator = view0.findViewById(0x7F0A0A69);  // id:separator
            this.name = (TextView)view0.findViewById(0x7F0A0D89);  // id:user_nick_name
            this.date = (TextView)view0.findViewById(0x7F0A0A65);  // id:sent_date
            this.expireDate = (TextView)view0.findViewById(0x7F0A047B);  // id:expire_date
            this.giftConfirm = (TextView)view0.findViewById(0x7F0A0B9C);  // id:title_icon
        }

        @Nullable
        public final TextView getDate() {
            return this.date;
        }

        @Nullable
        public final TextView getExpireDate() {
            return this.expireDate;
        }

        @Nullable
        public final TextView getGiftConfirm() {
            return this.giftConfirm;
        }

        @Nullable
        public final View getItemContainer() {
            return this.itemContainer;
        }

        @Nullable
        public final TextView getName() {
            return this.name;
        }

        @Nullable
        public final ImageView getProductIcon() {
            return this.productIcon;
        }

        @Nullable
        public final ImageView getProductThumbnail() {
            return this.productThumbnail;
        }

        @Nullable
        public final View getSeparator() {
            return this.separator;
        }

        @Nullable
        public final TextView getSongCount() {
            return this.songCount;
        }

        @Nullable
        public final ImageView getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final TextView getTitle() {
            return this.title;
        }

        @Nullable
        public final View getTitleContainer() {
            return this.titleContainer;
        }
    }

    public static final int $stable;
    @NotNull
    private final String ARG_LAST_INDEX_KEY;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String PAGE_SIZE;
    @NotNull
    private final String TAG;
    @Nullable
    private String mLastIndexKey;

    static {
        PresentSendListFragment.Companion = new Companion(null);
        PresentSendListFragment.$stable = 8;
    }

    public PresentSendListFragment() {
        this.TAG = "PresentSentFragment";
        this.PAGE_SIZE = "10";
        this.ARG_LAST_INDEX_KEY = "argLastIndexKey";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new PresentSendAdapter(this, context0, null);
    }

    public static void d0(PresentSendListFragment presentSendListFragment0, i i0, GiftListGiftBoxSendRes giftListGiftBoxSendRes0) {
        PresentSendListFragment.onFetchStart$lambda$2(presentSendListFragment0, i0, giftListGiftBoxSendRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.d0.buildUpon().appendQueryParameter("memberKey", u.v(((e0)o.a()).j())).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public static final PresentSendListFragment newInstance() {
        return PresentSendListFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null && bundle0.containsKey(this.ARG_LAST_INDEX_KEY)) {
            this.mLastIndexKey = bundle0.getString(this.ARG_LAST_INDEX_KEY);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D05B7, viewGroup0, false);  // layout:present_list
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        if(i.b.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentSendListFragment.PresentSendAdapter");
            ((PresentSendAdapter)j00).clear();
            this.mLastIndexKey = null;
        }
        RequestBuilder.newInstance(new GiftListGiftBoxSendReq(this.getContext(), this.mLastIndexKey, this.PAGE_SIZE)).tag(this.TAG).listener(new H0(14, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$2(PresentSendListFragment presentSendListFragment0, i i0, GiftListGiftBoxSendRes giftListGiftBoxSendRes0) {
        if(!presentSendListFragment0.prepareFetchComplete(giftListGiftBoxSendRes0)) {
            return;
        }
        if(giftListGiftBoxSendRes0 != null) {
            RESPONSE giftListGiftBoxSendRes$RESPONSE0 = giftListGiftBoxSendRes0.response;
            if(giftListGiftBoxSendRes$RESPONSE0 != null) {
                presentSendListFragment0.mLastIndexKey = giftListGiftBoxSendRes$RESPONSE0.lastIndexKey;
            }
        }
        presentSendListFragment0.performFetchComplete(i0, giftListGiftBoxSendRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString(this.ARG_LAST_INDEX_KEY, this.mLastIndexKey);
    }
}

