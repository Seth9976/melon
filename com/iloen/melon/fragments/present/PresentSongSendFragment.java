package com.iloen.melon.fragments.present;

import Ac.Z1;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.media3.session.a0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.q;
import com.iloen.melon.custom.ToReceiverViewForPresent;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.GiftListSongGiftBoxReq;
import com.iloen.melon.net.v4x.response.GiftListSongGiftBoxRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v4x.response.GiftListSongGiftBoxRes;
import com.iloen.melon.utils.Presentable.Builder;
import com.iloen.melon.utils.Presentable;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000E\b\u0007\u0018\u0000 *2\u00020\u0001:\u0004*+,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u0013\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001B\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001A\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\u001D\u0010\u0003J\r\u0010\u001E\u001A\u00020\u0012¢\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\"\u0010#\u001A\u00020\u00128\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b%\u0010\u001F\"\u0004\b&\u0010\'R\"\u0010(\u001A\u00020\u00128\u0016@\u0016X\u0096\u000E¢\u0006\u0012\n\u0004\b(\u0010$\u001A\u0004\b(\u0010\u001F\"\u0004\b)\u0010\'¨\u0006."}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSongSendFragment;", "Lcom/iloen/melon/fragments/present/PresentSendFragment;", "<init>", "()V", "", "Lcom/iloen/melon/net/v4x/response/GiftListSongGiftBoxRes$RESPONSE$SONGLIST;", "list", "Lie/H;", "sendInformPaymenttView", "(Ljava/util/List;)V", "getGiftableSongList", "()Ljava/util/List;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "sendMessage", "checkAdultContent", "()Z", "", "getPresentCount", "()I", "mIsContainAdult", "Z", "getMIsContainAdult", "setMIsContainAdult", "(Z)V", "isSongPresent", "setSongPresent", "Companion", "OnItemRemoveListener", "SongSendAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PresentSongSendFragment extends PresentSendFragment {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00052\u001A\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\u000B\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000B\u0018\u0001`\f2\u001A\u0010\r\u001A\u0016\u0012\u0004\u0012\u00020\u000E\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000E\u0018\u0001`\fH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSongSendFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/present/PresentSongSendFragment;", "menuId", "receivers", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/ToReceiverView$Receiver;", "Lkotlin/collections/ArrayList;", "presentDataList", "Lcom/iloen/melon/fragments/present/PresentData;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PresentSongSendFragment newInstance(@Nullable String s, @Nullable ArrayList arrayList0, @Nullable ArrayList arrayList1) {
            PresentSongSendFragment presentSongSendFragment0 = new PresentSongSendFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("menuId", s);
            bundle0.putInt("argFragmentTitle", 0x7F13088D);  // string:present_send_title "선물하기"
            bundle0.putParcelableArrayList("presentDataList", arrayList1);
            bundle0.putParcelableArrayList("presentReceiverList", arrayList0);
            presentSongSendFragment0.setArguments(bundle0);
            return presentSongSendFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSongSendFragment$OnItemRemoveListener;", "", "Lcom/iloen/melon/net/v4x/response/GiftListSongGiftBoxRes$RESPONSE$SONGLIST;", "c", "Lie/H;", "onRemoveButtonClick", "(Lcom/iloen/melon/net/v4x/response/GiftListSongGiftBoxRes$RESPONSE$SONGLIST;)V", "onItemClear", "()V", "onItemRemove", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnItemRemoveListener {
        void onItemClear();

        void onItemRemove(@NotNull SONGLIST arg1);

        void onRemoveButtonClick(@NotNull SONGLIST arg1);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020\f2\u0006\u0010!\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#R\u0018\u0010$\u001A\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSongSendFragment$SongSendAdapter;", "Lcom/iloen/melon/adapters/common/q;", "Lcom/iloen/melon/net/v4x/response/GiftListSongGiftBoxRes$RESPONSE$SONGLIST;", "Lcom/iloen/melon/fragments/present/PresentSongSendFragment$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/present/PresentSongSendFragment;Landroid/content/Context;Ljava/util/List;)V", "Lcom/iloen/melon/fragments/present/PresentSongSendFragment$OnItemRemoveListener;", "l", "Lie/H;", "setOnRemoveButtonClickListener", "(Lcom/iloen/melon/fragments/present/PresentSongSendFragment$OnItemRemoveListener;)V", "", "getHeaderViewCount", "()I", "getFooterViewCount", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/present/PresentSongSendFragment$ViewHolder;", "vh", "rawPosition", "onBindViewHolder", "(Lcom/iloen/melon/fragments/present/PresentSongSendFragment$ViewHolder;II)V", "clear", "()V", "c", "remove", "(Lcom/iloen/melon/net/v4x/response/GiftListSongGiftBoxRes$RESPONSE$SONGLIST;)V", "mRemoveListener", "Lcom/iloen/melon/fragments/present/PresentSongSendFragment$OnItemRemoveListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class SongSendAdapter extends q {
        @Nullable
        private OnItemRemoveListener mRemoveListener;

        public SongSendAdapter(@NotNull Context context0, @Nullable List list0) {
            kotlin.jvm.internal.q.g(context0, "context");
            PresentSongSendFragment.this = presentSongSendFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void clear() {
            super.clear();
            OnItemRemoveListener presentSongSendFragment$OnItemRemoveListener0 = this.mRemoveListener;
            if(presentSongSendFragment$OnItemRemoveListener0 != null) {
                presentSongSendFragment$OnItemRemoveListener0.onItemClear();
            }
        }

        @Override  // com.iloen.melon.adapters.common.y
        public int getFooterViewCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.y
        public int getHeaderViewCount() [...] // Inlined contents

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            if(v == 0) {
                return 0;
            }
            int v1 = this.getItemCount();
            if(v == v1 - 2) {
                return 2;
            }
            return v == v1 - 1 ? 3 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder presentSongSendFragment$ViewHolder0, int v, int v1) {
            kotlin.jvm.internal.q.g(presentSongSendFragment$ViewHolder0, "vh");
            if(this.getItemViewType(v) == 1) {
                SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0 = (SONGLIST)this.getItem(v1);
                if(giftListSongGiftBoxRes$RESPONSE$SONGLIST0 != null) {
                    ViewUtils.showWhen(presentSongSendFragment$ViewHolder0.getGradeIcon(), giftListSongGiftBoxRes$RESPONSE$SONGLIST0.isAdult);
                    ViewUtils.showWhen(presentSongSendFragment$ViewHolder0.getFreeIcon(), giftListSongGiftBoxRes$RESPONSE$SONGLIST0.isFree);
                    ViewUtils.showWhen(presentSongSendFragment$ViewHolder0.getHoldbackIcon(), giftListSongGiftBoxRes$RESPONSE$SONGLIST0.isHoldback);
                    ImageView imageView0 = presentSongSendFragment$ViewHolder0.getAlbumImage();
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(giftListSongGiftBoxRes$RESPONSE$SONGLIST0.albumImg).into(imageView0);
                    }
                    ViewUtils.setEnable(presentSongSendFragment$ViewHolder0.getLeftLayout(), giftListSongGiftBoxRes$RESPONSE$SONGLIST0.isGifTallOk);
                    ViewUtils.setEnable(presentSongSendFragment$ViewHolder0.getTitleContainer(), giftListSongGiftBoxRes$RESPONSE$SONGLIST0.isGifTallOk);
                    ViewUtils.showWhen(presentSongSendFragment$ViewHolder0.getGradeIcon(), giftListSongGiftBoxRes$RESPONSE$SONGLIST0.isAdult);
                    TextView textView0 = presentSongSendFragment$ViewHolder0.getSongName();
                    if(textView0 != null) {
                        textView0.setText(giftListSongGiftBoxRes$RESPONSE$SONGLIST0.songName);
                    }
                    TextView textView1 = presentSongSendFragment$ViewHolder0.getArtistName();
                    if(textView1 != null) {
                        textView1.setText(ProtocolUtils.getArtistNames(giftListSongGiftBoxRes$RESPONSE$SONGLIST0.artistList));
                    }
                    ViewUtils.setOnClickListener(presentSongSendFragment$ViewHolder0.getBtnRemove(), new a(3, this, giftListSongGiftBoxRes$RESPONSE$SONGLIST0));
                    ViewUtils.showWhen(presentSongSendFragment$ViewHolder0.getUnderLine(), v1 < this.getCount() - 1);
                }
            }
        }

        private static final void onBindViewHolder$lambda$2(SongSendAdapter presentSongSendFragment$SongSendAdapter0, SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0, View view0) {
            OnItemRemoveListener presentSongSendFragment$OnItemRemoveListener0 = presentSongSendFragment$SongSendAdapter0.mRemoveListener;
            if(presentSongSendFragment$OnItemRemoveListener0 != null) {
                presentSongSendFragment$OnItemRemoveListener0.onRemoveButtonClick(giftListSongGiftBoxRes$RESPONSE$SONGLIST0);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            View view0;
            kotlin.jvm.internal.q.g(viewGroup0, "parent");
            if(v == 0) {
                return new ViewHolder(PresentSongSendFragment.this.getMHeaderView());
            }
            switch(v) {
                case 1: {
                    view0 = this.mInflater.inflate(0x7F0D04A8, null);  // layout:listitem_song
                    kotlin.jvm.internal.q.f(view0, "inflate(...)");
                    return new ViewHolder(view0);
                }
                case 2: {
                    return new ViewHolder(PresentSongSendFragment.this.getMMessageContainer());
                }
                case 3: {
                    return new ViewHolder(PresentSongSendFragment.this.getMDescriptionContainer());
                }
                default: {
                    view0 = this.mInflater.inflate(0x7F0D04A8, null);  // layout:listitem_song
                    kotlin.jvm.internal.q.f(view0, "inflate(...)");
                    return new ViewHolder(view0);
                }
            }
        }

        public void remove(@NotNull SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0) {
            kotlin.jvm.internal.q.g(giftListSongGiftBoxRes$RESPONSE$SONGLIST0, "c");
            super.remove(giftListSongGiftBoxRes$RESPONSE$SONGLIST0);
            OnItemRemoveListener presentSongSendFragment$OnItemRemoveListener0 = this.mRemoveListener;
            if(presentSongSendFragment$OnItemRemoveListener0 != null) {
                presentSongSendFragment$OnItemRemoveListener0.onItemRemove(giftListSongGiftBoxRes$RESPONSE$SONGLIST0);
            }
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void remove(Object object0) {
            this.remove(((SONGLIST)object0));
        }

        public final void setOnRemoveButtonClickListener(@NotNull OnItemRemoveListener presentSongSendFragment$OnItemRemoveListener0) {
            kotlin.jvm.internal.q.g(presentSongSendFragment$OnItemRemoveListener0, "l");
            this.mRemoveListener = presentSongSendFragment$OnItemRemoveListener0;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0019\u0010\n\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001A\u0004\b\u000B\u0010\tR\u0019\u0010\r\u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0011\u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000E\u001A\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0015\u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000E\u001A\u0004\b\u0016\u0010\u0010R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000E\u001A\u0004\b\u0018\u0010\u0010R\u0019\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001B\u001A\u0004\b\u001F\u0010\u001DR\u0019\u0010 \u001A\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b \u0010\u000E\u001A\u0004\b!\u0010\u0010R\u0019\u0010\"\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u0007\u001A\u0004\b#\u0010\t¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentSongSendFragment$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "leftLayout", "Landroid/view/View;", "getLeftLayout", "()Landroid/view/View;", "titleContainer", "getTitleContainer", "Landroid/widget/ImageView;", "defaultImage", "Landroid/widget/ImageView;", "getDefaultImage", "()Landroid/widget/ImageView;", "albumImage", "getAlbumImage", "gradeIcon", "getGradeIcon", "holdbackIcon", "getHoldbackIcon", "freeIcon", "getFreeIcon", "Landroid/widget/TextView;", "songName", "Landroid/widget/TextView;", "getSongName", "()Landroid/widget/TextView;", "artistName", "getArtistName", "btnRemove", "getBtnRemove", "underLine", "getUnderLine", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ViewHolder extends O0 {
        public static final int $stable = 8;
        @Nullable
        private final ImageView albumImage;
        @Nullable
        private final TextView artistName;
        @Nullable
        private final ImageView btnRemove;
        @Nullable
        private final ImageView defaultImage;
        @Nullable
        private final ImageView freeIcon;
        @Nullable
        private final ImageView gradeIcon;
        @Nullable
        private final ImageView holdbackIcon;
        @Nullable
        private final View leftLayout;
        @Nullable
        private final TextView songName;
        @Nullable
        private final View titleContainer;
        @Nullable
        private final View underLine;

        public ViewHolder(@NotNull View view0) {
            kotlin.jvm.internal.q.g(view0, "view");
            super(view0);
            this.leftLayout = view0.findViewById(0x7F0A075A);  // id:left_layout
            this.titleContainer = view0.findViewById(0x7F0A0B96);  // id:title_container
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
            this.defaultImage = imageView0;
            this.albumImage = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.gradeIcon = (ImageView)view0.findViewById(0x7F0A063B);  // id:iv_list_19
            this.holdbackIcon = (ImageView)view0.findViewById(0x7F0A0641);  // id:iv_list_holdback
            this.freeIcon = (ImageView)view0.findViewById(0x7F0A0640);  // id:iv_list_free
            this.songName = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.artistName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
            ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A0680);  // id:iv_remove
            this.btnRemove = imageView1;
            this.underLine = view0.findViewById(0x7F0A0D6B);  // id:underline
            if(imageView0 != null) {
                imageView0.setImageResource(0x7F08078B);  // drawable:noimage_logo_mini
            }
            ViewUtils.hideWhen(view0.findViewById(0x7F0A0182), true);  // id:btn_play
            ViewUtils.hideWhen(view0.findViewById(0x7F0A0169), true);  // id:btn_info
            ViewUtils.showWhen(imageView1, true);
        }

        @Nullable
        public final ImageView getAlbumImage() {
            return this.albumImage;
        }

        @Nullable
        public final TextView getArtistName() {
            return this.artistName;
        }

        @Nullable
        public final ImageView getBtnRemove() {
            return this.btnRemove;
        }

        @Nullable
        public final ImageView getDefaultImage() {
            return this.defaultImage;
        }

        @Nullable
        public final ImageView getFreeIcon() {
            return this.freeIcon;
        }

        @Nullable
        public final ImageView getGradeIcon() {
            return this.gradeIcon;
        }

        @Nullable
        public final ImageView getHoldbackIcon() {
            return this.holdbackIcon;
        }

        @Nullable
        public final View getLeftLayout() {
            return this.leftLayout;
        }

        @Nullable
        public final TextView getSongName() {
            return this.songName;
        }

        @Nullable
        public final View getTitleContainer() {
            return this.titleContainer;
        }

        @Nullable
        public final View getUnderLine() {
            return this.underLine;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "PresentSongSendFragment";
    private boolean isSongPresent;
    private boolean mIsContainAdult;

    static {
        PresentSongSendFragment.Companion = new Companion(null);
        PresentSongSendFragment.$stable = 8;
    }

    public PresentSongSendFragment() {
        this.isSongPresent = true;
    }

    public final boolean checkAdultContent() {
        ArrayList arrayList0 = this.getPresentDataList();
        if(arrayList0 != null) {
            Iterator iterator0 = arrayList0.iterator();
            kotlin.jvm.internal.q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                kotlin.jvm.internal.q.f(object0, "next(...)");
                if(((PresentData)object0).isAdult()) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        kotlin.jvm.internal.q.g(context0, "context");
        j0 j00 = new SongSendAdapter(this, context0, null);
        ((SongSendAdapter)j00).setOnRemoveButtonClickListener(new OnItemRemoveListener() {
            @Override  // com.iloen.melon.fragments.present.PresentSongSendFragment$OnItemRemoveListener
            public void onItemClear() {
                ((SongSendAdapter)j00).setMIsContainAdult(false);
            }

            @Override  // com.iloen.melon.fragments.present.PresentSongSendFragment$OnItemRemoveListener
            public void onItemRemove(SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0) {
                kotlin.jvm.internal.q.g(giftListSongGiftBoxRes$RESPONSE$SONGLIST0, "c");
                ArrayList arrayList0 = ((SongSendAdapter)j00).getPresentDataList();
                if(arrayList0 != null) {
                    Iterator iterator0 = arrayList0.iterator();
                    kotlin.jvm.internal.q.f(iterator0, "iterator(...)");
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        kotlin.jvm.internal.q.f(object0, "next(...)");
                        PresentData presentData0 = (PresentData)object0;
                        if(giftListSongGiftBoxRes$RESPONSE$SONGLIST0.songId != null && giftListSongGiftBoxRes$RESPONSE$SONGLIST0.songId.equals(presentData0.getSongId())) {
                            arrayList0.remove(presentData0);
                            return;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }

            @Override  // com.iloen.melon.fragments.present.PresentSongSendFragment$OnItemRemoveListener
            public void onRemoveButtonClick(SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0) {
                kotlin.jvm.internal.q.g(giftListSongGiftBoxRes$RESPONSE$SONGLIST0, "c");
                b.x(((SongSendAdapter)j00).getChildFragmentManager(), ((SongSendAdapter)j00).getString(0x7F1300D0), ((SongSendAdapter)j00).getString(0x7F130088), false, false, null, null, new Z1(this.$adapter, giftListSongGiftBoxRes$RESPONSE$SONGLIST0, ((SongSendAdapter)j00), 17), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
            }

            private static final H onRemoveButtonClick$lambda$0(SongSendAdapter presentSongSendFragment$SongSendAdapter0, SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0, PresentSongSendFragment presentSongSendFragment0) {
                presentSongSendFragment$SongSendAdapter0.remove(giftListSongGiftBoxRes$RESPONSE$SONGLIST0);
                presentSongSendFragment$SongSendAdapter0.notifyDataSetChanged();
                OnListViewChangedListener presentSendFragment$OnListViewChangedListener0 = presentSongSendFragment0.getMOnChangedListener();
                if(presentSendFragment$OnListViewChangedListener0 != null) {
                    presentSendFragment$OnListViewChangedListener0.onDataChanged();
                }
                presentSongSendFragment0.setMIsContainAdult(presentSongSendFragment0.checkAdultContent());
                return H.a;
            }
        });
        return j00;
    }

    private final List getGiftableSongList() {
        j0 j00 = this.mAdapter;
        if(j00 instanceof SongSendAdapter) {
            kotlin.jvm.internal.q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentSongSendFragment.SongSendAdapter");
            int v = ((SongSendAdapter)j00).getCount();
            List list0 = new ArrayList();
            for(int v1 = 0; v1 < v; ++v1) {
                SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0 = (SONGLIST)((SongSendAdapter)j00).getItem(v1);
                if(giftListSongGiftBoxRes$RESPONSE$SONGLIST0 != null && giftListSongGiftBoxRes$RESPONSE$SONGLIST0.isGifTallOk) {
                    ((ArrayList)list0).add(giftListSongGiftBoxRes$RESPONSE$SONGLIST0);
                }
            }
            return list0;
        }
        return null;
    }

    public final boolean getMIsContainAdult() {
        return this.mIsContainAdult;
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public int getPresentCount() {
        j0 j00 = this.mAdapter;
        if(j00 instanceof SongSendAdapter) {
            kotlin.jvm.internal.q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentSongSendFragment.SongSendAdapter");
            return ((SongSendAdapter)j00).getCount();
        }
        return 0;
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public boolean isSongPresent() {
        return this.isSongPresent;
    }

    @NotNull
    public static final PresentSongSendFragment newInstance(@Nullable String s, @Nullable ArrayList arrayList0, @Nullable ArrayList arrayList1) {
        return PresentSongSendFragment.Companion.newInstance(s, arrayList0, arrayList1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A0779);  // id:list
        kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).getContext();
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(1, false));
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        kotlin.jvm.internal.q.g(i0, "type");
        kotlin.jvm.internal.q.g(h0, "param");
        kotlin.jvm.internal.q.g(s, "reason");
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = this.getPresentDataList();
        if(arrayList1 != null) {
            for(Object object0: arrayList1) {
                arrayList0.add(((PresentData)object0).getSongId());
            }
        }
        Object[] arr_object = arrayList0.toArray(new String[arrayList0.size()]);
        kotlin.jvm.internal.q.f(arr_object, "toArray(...)");
        if(((String[])arr_object).length == 0) {
            OnListViewChangedListener presentSendFragment$OnListViewChangedListener0 = this.getMOnChangedListener();
            if(presentSendFragment$OnListViewChangedListener0 != null) {
                presentSendFragment$OnListViewChangedListener0.onDataChanged();
            }
            this.performFetchCompleteOnlyViews();
            return true;
        }
        RequestBuilder.newInstance(new GiftListSongGiftBoxReq(this.getContext(), arrayList0)).tag(this.getTAG()).listener(new a0(this, 29)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(PresentSongSendFragment presentSongSendFragment0, GiftListSongGiftBoxRes giftListSongGiftBoxRes0) {
        SongSendAdapter presentSongSendFragment$SongSendAdapter0;
        if(presentSongSendFragment0.prepareFetchComplete(giftListSongGiftBoxRes0)) {
            j0 j00 = presentSongSendFragment0.mAdapter;
            if(j00 instanceof SongSendAdapter) {
                kotlin.jvm.internal.q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentSongSendFragment.SongSendAdapter");
                presentSongSendFragment$SongSendAdapter0 = (SongSendAdapter)j00;
            }
            else {
                presentSongSendFragment$SongSendAdapter0 = null;
            }
            if(presentSongSendFragment$SongSendAdapter0 != null) {
                presentSongSendFragment$SongSendAdapter0.clear();
                if(giftListSongGiftBoxRes0.response != null) {
                    ArrayList arrayList0 = new ArrayList();
                    ArrayList arrayList1 = giftListSongGiftBoxRes0.response.songList;
                    if(arrayList1 != null) {
                        Iterator iterator0 = arrayList1.iterator();
                        kotlin.jvm.internal.q.f(iterator0, "iterator(...)");
                        while(iterator0.hasNext()) {
                            Object object0 = iterator0.next();
                            SONGLIST giftListSongGiftBoxRes$RESPONSE$SONGLIST0 = (SONGLIST)object0;
                            if(giftListSongGiftBoxRes$RESPONSE$SONGLIST0.canService) {
                                arrayList0.add(giftListSongGiftBoxRes$RESPONSE$SONGLIST0);
                            }
                        }
                    }
                    presentSongSendFragment0.mIsContainAdult = false;
                    Iterator iterator1 = arrayList0.iterator();
                    kotlin.jvm.internal.q.f(iterator1, "iterator(...)");
                    while(iterator1.hasNext()) {
                        Object object1 = iterator1.next();
                        kotlin.jvm.internal.q.f(object1, "next(...)");
                        if(((SONGLIST)object1).isAdult) {
                            presentSongSendFragment0.mIsContainAdult = true;
                        }
                        presentSongSendFragment$SongSendAdapter0.add(((SONGLIST)object1));
                    }
                    OnListViewChangedListener presentSendFragment$OnListViewChangedListener0 = presentSongSendFragment0.getMOnChangedListener();
                    if(presentSendFragment$OnListViewChangedListener0 != null) {
                        presentSendFragment$OnListViewChangedListener0.onDataChanged();
                    }
                }
                presentSongSendFragment0.performFetchCompleteOnlyViews();
            }
        }
    }

    public static void p0(PresentSongSendFragment presentSongSendFragment0, GiftListSongGiftBoxRes giftListSongGiftBoxRes0) {
        PresentSongSendFragment.onFetchStart$lambda$1(presentSongSendFragment0, giftListSongGiftBoxRes0);
    }

    public static H q0(PresentSongSendFragment presentSongSendFragment0) {
        return PresentSongSendFragment.sendMessage$lambda$3(presentSongSendFragment0);
    }

    private final void sendInformPaymenttView(List list0) {
        Editable editable0;
        ArrayList arrayList0;
        int v = 0;
        if((list0 == null ? 0 : list0.size()) <= 0) {
            ToastManager.show(0x7F13088F);  // string:present_unavailable_contents "권리사의 요청에 의해 선물할 수 없는 곡입니다."
            return;
        }
        j0 j00 = this.mAdapter;
        if(j00 instanceof SongSendAdapter) {
            kotlin.jvm.internal.q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentSongSendFragment.SongSendAdapter");
            int v1 = ((SongSendAdapter)j00).getCount();
            Integer integer0 = list0 == null ? null : list0.size();
            if(list0 != null) {
                v = list0.size();
            }
            if(v < v1) {
                String s = this.getString(0x7F130876);  // string:present_part_unavailable_contents "선물 불가능한 곡을 제외하고 %1$d곡을 보낼 선물 리스트에 추가하였습니다."
                kotlin.jvm.internal.q.f(s, "getString(...)");
                ToastManager.show(String.format(s, Arrays.copyOf(new Object[]{integer0}, 1)));
            }
        }
        Builder presentable$Builder0 = Presentable.newBuilder(list0, this.getMenuId());
        ToReceiverViewForPresent toReceiverViewForPresent0 = this.getMToSendersView();
        if(toReceiverViewForPresent0 == null) {
            arrayList0 = new ArrayList();
        }
        else {
            arrayList0 = toReceiverViewForPresent0.getList();
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
            }
        }
        presentable$Builder0.setReceiver(arrayList0);
        EditText editText0 = this.getMMessageView();
        if(editText0 == null) {
            editable0 = "";
        }
        else {
            editable0 = editText0.getText();
            if(editable0 == null) {
                editable0 = "";
            }
        }
        presentable$Builder0.sendMsgCont(editable0.toString());
        Presentable presentable0 = presentable$Builder0.build();
        if(presentable0 != null) {
            presentable0.openPaymentPage();
            this.setMIsCloseConfirm(true);
            this.performBackPress();
        }
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public void sendMessage() {
        if(this.mAdapter instanceof SongSendAdapter) {
            if(this.mIsContainAdult) {
                l0 l00 = this.getChildFragmentManager();
                String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                String s1 = this.getString(0x7F13087F);  // string:present_send_adult_song_info_message "19세 미만 청소년은 청소년유해매체물을 제외한 선물 받기만 가능합니다. 
                                                         // 결제를 진행하시겠습니까?"
                b9.a a0 = new b9.a(this, 19);
                b.d(b.a, l00, s, s1, false, false, false, null, null, a0, null, null, 0x6F8);
                return;
            }
            this.sendInformPaymenttView(this.getGiftableSongList());
        }
    }

    private static final H sendMessage$lambda$3(PresentSongSendFragment presentSongSendFragment0) {
        presentSongSendFragment0.sendInformPaymenttView(presentSongSendFragment0.getGiftableSongList());
        return H.a;
    }

    public final void setMIsContainAdult(boolean z) {
        this.mIsContainAdult = z;
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public void setSongPresent(boolean z) {
        this.isSongPresent = z;
    }
}

