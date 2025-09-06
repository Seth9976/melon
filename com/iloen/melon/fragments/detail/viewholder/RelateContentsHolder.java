package com.iloen.melon.fragments.detail.viewholder;

import Cb.k;
import De.I;
import J8.E;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.O;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.RelatContsInfo.RelatContsList;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.RelatContsInfo;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0004!\"#$B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u001F\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0010J\u001F\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u001F\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u001F\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u001D\u0010\u001C\u001A\u00020\u000E2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u001E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 ¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$RelatContsInfo;", "LJ8/E;", "binding", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/E;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$RelatContsInfo$RelatContsList;", "data", "", "position", "Lie/H;", "contentClickLog", "(Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$RelatContsInfo$RelatContsList;I)V", "contentPlayClickLog", "playlistClickLog", "playlistPlayClickLog", "videoClickLog", "linkClickLog", "albumClickLog", "albumPlayClickLog", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "InnerRecyclerAdapter", "ViewType", "ItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RelateContentsHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RelateContentsHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "actionListener");
            View view0 = o.e(viewGroup0, 0x7F0D01E3, viewGroup0, false);  // layout:deatil_station_episode_relate_contents
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09CF;  // id:recycler_horizontal
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
                if(recyclerView0 != null) {
                    return new RelateContentsHolder(new E(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0001B!\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0012\u001A\u00060\u0003R\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0017\u001A\u00020\u00162\f\u0010\u0014\u001A\b\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$RelatContsInfo$RelatContsList;", "Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder$ItemViewHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder;Landroid/content/Context;Ljava/util/List;)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder$ItemViewHolder;", "viewHolder", "rawPosition", "Lie/H;", "onBindViewHolder", "(Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder$ItemViewHolder;II)V", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "actionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "getActionListener", "()Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "setActionListener", "(Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends y {
        @Nullable
        private OnViewHolderActionBaseListener actionListener;

        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Nullable
        public final OnViewHolderActionBaseListener getActionListener() {
            return this.actionListener;
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            String s = ((RelatContsList)this.getItem(v)).contsTypeCode;
            if(q.b(s, "N10003")) {
                return 1;
            }
            if(q.b(s, "N10007")) {
                return 2;
            }
            return q.b(s, "") ? 3 : 0;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ItemViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@Nullable ItemViewHolder relateContentsHolder$ItemViewHolder0, int v, int v1) {
            if(relateContentsHolder$ItemViewHolder0 != null) {
                Object object0 = this.getItem(v1);
                q.f(object0, "getItem(...)");
                relateContentsHolder$ItemViewHolder0.bind(((RelatContsList)object0), v1);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            int v1;
            q.g(viewGroup0, "parent");
            switch(v) {
                case 1: {
                    v1 = 0x7F0D04B1;  // layout:listitem_tab_music_common_video
                    break;
                }
                case 2: {
                    v1 = 0x7F0D04B0;  // layout:listitem_tab_music_common_magazine
                    break;
                }
                case 3: {
                    v1 = 0x7F0D04B2;  // layout:listitem_tab_music_common_web
                    break;
                }
                default: {
                    v1 = 0x7F0D04AF;  // layout:listitem_tab_music_common_default
                }
            }
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(v1, viewGroup0, false);
            q.f(view0, "inflate(...)");
            return new ItemViewHolder(RelateContentsHolder.this, view0, this.actionListener);
        }

        public final void setActionListener(@Nullable OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            this.actionListener = onViewHolderActionBaseListener0;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u000F\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000F\u0010\u000EJ\u001D\u0010\u0010\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u000ER$\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0018\u001A\u0004\b\u001C\u0010\u001AR\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u001D8\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u0019\u0010#\u001A\u0004\u0018\u00010\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&R\u0019\u0010(\u001A\u0004\u0018\u00010\'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder$ItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "actionListener", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder;Landroid/view/View;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$RelatContsInfo$RelatContsList;", "data", "", "position", "Lie/H;", "clickPlayButton", "(Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$RelatContsInfo$RelatContsList;I)V", "clickItemView", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "getActionListener", "()Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "setActionListener", "(Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvSubTitle", "getTvSubTitle", "Lcom/iloen/melon/custom/CoverView;", "coverView", "Lcom/iloen/melon/custom/CoverView;", "getCoverView", "()Lcom/iloen/melon/custom/CoverView;", "Lcom/iloen/melon/custom/MelonTextView;", "playTime", "Lcom/iloen/melon/custom/MelonTextView;", "getPlayTime", "()Lcom/iloen/melon/custom/MelonTextView;", "Landroid/widget/ImageView;", "magazineLogo", "Landroid/widget/ImageView;", "getMagazineLogo", "()Landroid/widget/ImageView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ItemViewHolder extends O0 {
        @Nullable
        private OnViewHolderActionBaseListener actionListener;
        @Nullable
        private final CoverView coverView;
        @Nullable
        private final ImageView magazineLogo;
        @Nullable
        private final MelonTextView playTime;
        @Nullable
        private final TextView tvSubTitle;
        @Nullable
        private final TextView tvTitle;

        public ItemViewHolder(@NotNull View view0, @Nullable OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(view0, "itemView");
            RelateContentsHolder.this = relateContentsHolder0;
            super(view0);
            this.actionListener = onViewHolderActionBaseListener0;
            TextView textView0 = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.tvTitle = textView0;
            TextView textView1 = (TextView)view0.findViewById(0x7F0A0D1E);  // id:tv_sub_title
            this.tvSubTitle = textView1;
            this.coverView = (CoverView)view0.findViewById(0x7F0A0355);  // id:cover_view
            this.playTime = (MelonTextView)view0.findViewById(0x7F0A0921);  // id:play_time
            this.magazineLogo = (ImageView)view0.findViewById(0x7F0A07C5);  // id:magazine_logo
            if(textView0 != null) {
                textView0.setMaxLines(2);
            }
            if(textView1 != null) {
                textView1.setMaxLines(1);
            }
        }

        public final void bind(@NotNull RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
            q.g(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, "data");
            TextView textView0 = this.tvTitle;
            if(textView0 != null) {
                textView0.setText(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.title);
            }
            TextView textView1 = this.tvSubTitle;
            if(textView1 != null) {
                textView1.setText(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.subTitle);
            }
            CoverView coverView0 = this.coverView;
            if(coverView0 != null) {
                Glide.with(this.itemView.getContext()).load(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.imgUrl).into(coverView0.getThumbnailView());
            }
            if(q.b(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode, "N10003")) {
                MelonTextView melonTextView0 = this.playTime;
                if(melonTextView0 != null) {
                    melonTextView0.setText(k.f(String.valueOf(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.playTime)));
                }
            }
            if(q.b(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode, "N10007")) {
                ImageView imageView0 = this.magazineLogo;
                if(imageView0 != null) {
                    imageView0.setVisibility(0);
                }
            }
            CoverView coverView1 = this.coverView;
            if(coverView1 != null) {
                View view0 = coverView1.getPlayButtonView();
                if(view0 != null) {
                    view0.setOnClickListener(new z(this, castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v, 0));
                }
            }
            z z0 = new z(this, castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v, 1);
            this.itemView.setOnClickListener(z0);
        }

        private static final void bind$lambda$1(ItemViewHolder relateContentsHolder$ItemViewHolder0, RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v, View view0) {
            relateContentsHolder$ItemViewHolder0.clickPlayButton(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
        }

        private static final void bind$lambda$2(ItemViewHolder relateContentsHolder$ItemViewHolder0, RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v, View view0) {
            relateContentsHolder$ItemViewHolder0.clickItemView(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
        }

        private final void clickItemView(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
            String s = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode;
            if(q.b(s, "N10002")) {
                Navigator.openAlbumInfo(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId);
                RelateContentsHolder.this.albumClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
                return;
            }
            if(q.b(s, "N10005")) {
                Navigator.INSTANCE.openPlaylistDetail(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId);
                RelateContentsHolder.this.playlistClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
                return;
            }
            if(q.b(s, "N10009")) {
                Navigator.openDjPlaylistDetail(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId);
                RelateContentsHolder.this.playlistClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
                return;
            }
            if(q.b(s, "N10003")) {
                Navigator.openMvInfo$default(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId, RelateContentsHolder.this.getMenuId(), null, false, 12, null);
                RelateContentsHolder.this.videoClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
                return;
            }
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.a = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.linkType;
            melonLinkInfo0.b = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.linkUrl;
            MelonLinkExecutor.open(melonLinkInfo0);
            RelateContentsHolder.this.linkClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
        }

        private final void clickPlayButton(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
            String s = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode;
            if(q.b(s, "N10002")) {
                OnViewHolderActionBaseListener onViewHolderActionBaseListener0 = this.actionListener;
                if(onViewHolderActionBaseListener0 != null) {
                    onViewHolderActionBaseListener0.onPlayAlbumListener(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId);
                }
                RelateContentsHolder.this.albumPlayClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
                return;
            }
            if(!q.b(s, "N10005") && !q.b(s, "N10009")) {
                return;
            }
            OnViewHolderActionBaseListener onViewHolderActionBaseListener1 = this.actionListener;
            if(onViewHolderActionBaseListener1 != null) {
                onViewHolderActionBaseListener1.onPlayDjPlaylistListener(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId, castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode);
            }
            RelateContentsHolder.this.playlistPlayClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
        }

        @Nullable
        public final OnViewHolderActionBaseListener getActionListener() {
            return this.actionListener;
        }

        @Nullable
        public final CoverView getCoverView() {
            return this.coverView;
        }

        @Nullable
        public final ImageView getMagazineLogo() {
            return this.magazineLogo;
        }

        @Nullable
        public final MelonTextView getPlayTime() {
            return this.playTime;
        }

        @Nullable
        public final TextView getTvSubTitle() {
            return this.tvSubTitle;
        }

        @Nullable
        public final TextView getTvTitle() {
            return this.tvTitle;
        }

        public final void setActionListener(@Nullable OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            this.actionListener = onViewHolderActionBaseListener0;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/RelateContentsHolder$ViewType;", "", "<init>", "()V", "DEFAULT", "", "VIDEO", "MAGAZINE", "WEB_LINK", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewType {
        public static final int DEFAULT = 0;
        @NotNull
        public static final ViewType INSTANCE = null;
        public static final int MAGAZINE = 2;
        public static final int VIDEO = 1;
        public static final int WEB_LINK = 3;

        static {
            ViewType.INSTANCE = new ViewType();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private RecyclerView recyclerView;

    static {
        RelateContentsHolder.Companion = new Companion(null);
        RelateContentsHolder.$stable = 8;
    }

    public RelateContentsHolder(@NotNull E e0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(e0, "binding");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(e0, onViewHolderActionBaseListener0);
        this.setTitleView(e0.b);
        this.recyclerView = e0.c;
        e0.c.setHasFixedSize(true);
        e0.c.setNestedScrollingEnabled(false);
        O o0 = new O(12.0f);
        e0.c.addItemDecoration(o0);
        e0.c.getContext();
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(0, false);
        e0.c.setLayoutManager(linearLayoutManager0);
    }

    private final void albumClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        this.contentClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
    }

    private final void albumPlayClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        this.contentPlayClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
    }

    private final void contentClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F131009);  // string:tiara_station_layer1_related_contents "연관컨텐츠"
            f0.c(v + 1);
            f0.E = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.imgUrl;
            f0.e = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId;
            f0.f = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode;
            f0.g = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.title;
            f0.a().track();
        }
    }

    private final void contentPlayClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getString(0x7F131009);  // string:tiara_station_layer1_related_contents "연관컨텐츠"
            f0.c(v + 1);
            f0.E = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.imgUrl;
            f0.e = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId;
            f0.f = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode;
            f0.g = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.title;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    private final void linkClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F131009);  // string:tiara_station_layer1_related_contents "연관컨텐츠"
            f0.c(v + 1);
            f0.E = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.imgUrl;
            if(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode.equals("N10007")) {
                f0.d = ActionKind.ClickContent;
                f0.e = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsId;
                f0.f = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.contsTypeCode;
                f0.g = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.title;
            }
            else {
                f0.B = castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0.linkUrl;
            }
            f0.a().track();
        }
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        RelatContsInfo castEpsdDetailRes$Response$RelatContsInfo0 = (RelatContsInfo)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(castEpsdDetailRes$Response$RelatContsInfo0.title);
        }
        ArrayList arrayList0 = castEpsdDetailRes$Response$RelatContsInfo0.relatContsList;
        if(arrayList0 != null) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                InnerRecyclerAdapter relateContentsHolder$InnerRecyclerAdapter0 = new InnerRecyclerAdapter(this, this.getContext(), arrayList0);
                relateContentsHolder$InnerRecyclerAdapter0.setActionListener(this.getOnViewHolderActionListener());
                recyclerView0.setAdapter(relateContentsHolder$InnerRecyclerAdapter0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final void playlistClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        this.contentClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
    }

    private final void playlistPlayClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        this.contentPlayClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
    }

    private final void videoClickLog(RelatContsList castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, int v) {
        this.contentClickLog(castEpsdDetailRes$Response$RelatContsInfo$RelatContsList0, v);
    }
}

