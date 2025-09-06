package com.iloen.melon.fragments.artistchannel.viewholder;

import De.I;
import J8.A1;
import J8.f3;
import J8.l;
import J8.z1;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.o;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.HIGHLIGHTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.b;
import p8.f;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 %2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0004%&\'(B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0014\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u00132\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0016\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u0018\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000F\u0010\u001A\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ#\u0010\u001D\u001A\u00020\u00102\u0012\u0010\u001C\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0018\u0010 \u001A\u0004\u0018\u00010\u001F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u001C\u0010#\u001A\b\u0018\u00010\"R\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIGHLIGHTLIST;", "LJ8/l;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/l;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightRectangleViewHolder;", "vh", "item", "", "position", "Lie/H;", "bindHighlightRectangleItem", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightRectangleViewHolder;Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIGHLIGHTLIST;I)V", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightSquareViewHolder;", "bindHighlightSquareItem", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightSquareViewHolder;Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIGHLIGHTLIST;I)V", "trackTiaraMovePage", "(Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIGHLIGHTLIST;I)V", "trackTiaraPlayMusic", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightRecyclerAdapter;", "Companion", "HighlightRecyclerAdapter", "HighlightSquareViewHolder", "HighlightRectangleViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistHighlightHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_NEWRELEASE", "TYPE_WEEKAWARD", "TYPE_RISINGSONG", "TYPE_SPOTLIGHT", "TYPE_HIRISING", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_MOVE_DETAIL", "TALKBACK_ACTION_PLAYBACK", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistHighlightHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D003A, viewGroup0, false);  // layout:artist_detail_highlight
            RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
            if(recyclerView0 == null) {
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A09CF));  // id:recycler_horizontal
            }
            return new ArtistHighlightHolder(new l(((LinearLayout)view0), recyclerView0), onViewHolderActionBaseListener0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightRectangleViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/z1;", "bind", "<init>", "(LJ8/z1;)V", "LJ8/z1;", "getBind", "()LJ8/z1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class HighlightRectangleViewHolder extends O0 {
        @NotNull
        private final z1 bind;

        public HighlightRectangleViewHolder(@NotNull z1 z10) {
            q.g(z10, "bind");
            super(z10.a);
            this.bind = z10;
        }

        @NotNull
        public final z1 getBind() {
            return this.bind;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001B\u0010\u0014\u001A\u00020\u00132\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001E\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIGHLIGHTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder;Landroid/content/Context;Ljava/util/List;)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Landroidx/recyclerview/widget/O0;)V", "rawPosition", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HIGHLIGHT_SQUARE", "I", "VIEW_TYPE_HIGHLIGHT_RECTANGLE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class HighlightRecyclerAdapter extends c {
        private final int VIEW_TYPE_HIGHLIGHT_RECTANGLE;
        private final int VIEW_TYPE_HIGHLIGHT_SQUARE;

        public HighlightRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.VIEW_TYPE_HIGHLIGHT_SQUARE = 1;
            this.VIEW_TYPE_HIGHLIGHT_RECTANGLE = 2;
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            String s = ((HIGHLIGHTLIST)this.getItem(v)).highlightType;
            return q.b(s, "SPOTLIGHT") || q.b(s, "HIRISING") ? this.VIEW_TYPE_HIGHLIGHT_RECTANGLE : this.VIEW_TYPE_HIGHLIGHT_SQUARE;
        }

        public void initViewHolder(@NotNull O0 o00) {
            q.g(o00, "vh");
            if(o00 instanceof HighlightSquareViewHolder) {
                int v = ScreenUtils.dipToPixel(this.getContext(), 120.0f);
                ViewUtils.setDefaultImage(((HighlightSquareViewHolder)o00).getBind().g.c, v);
            }
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "vh");
            this.initViewHolder(o00);
            HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0 = (HIGHLIGHTLIST)this.getItem(v1);
            if(o00 instanceof HighlightRectangleViewHolder) {
                q.d(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0);
                ArtistHighlightHolder.this.bindHighlightRectangleItem(((HighlightRectangleViewHolder)o00), artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v1);
                return;
            }
            if(o00 instanceof HighlightSquareViewHolder) {
                q.d(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0);
                ArtistHighlightHolder.this.bindHighlightSquareItem(((HighlightSquareViewHolder)o00), artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v1);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HIGHLIGHT_RECTANGLE) {
                View view0 = o.e(viewGroup0, 0x7F0D045B, viewGroup0, false);  // layout:listitem_artist_highlight_rectangle
                int v1 = 0x7F0A0213;  // id:cardview_item
                View view1 = I.C(view0, 0x7F0A0213);  // id:cardview_item
                if(((CardView)view1) != null) {
                    v1 = 0x7F0A0637;  // id:iv_image
                    View view2 = I.C(view0, 0x7F0A0637);  // id:iv_image
                    if(((MelonImageView)view2) != null) {
                        v1 = 0x7F0A064A;  // id:iv_logo
                        View view3 = I.C(view0, 0x7F0A064A);  // id:iv_logo
                        if(((MelonImageView)view3) != null) {
                            v1 = 0x7F0A0BA1;  // id:title_logo
                            View view4 = I.C(view0, 0x7F0A0BA1);  // id:title_logo
                            if(((ImageView)view4) != null) {
                                return new HighlightRectangleViewHolder(new z1(((LinearLayout)view0), ((CardView)view1), ((MelonImageView)view2), ((MelonImageView)view3), ((ImageView)view4)));
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
            }
            View view5 = o.e(viewGroup0, 0x7F0D045C, viewGroup0, false);  // layout:listitem_artist_highlight_square
            int v2 = 0x7F0A00C2;  // id:artist_tv
            View view6 = I.C(view5, 0x7F0A00C2);  // id:artist_tv
            if(((MelonTextView)view6) != null) {
                v2 = 0x7F0A00E3;  // id:award_tv
                View view7 = I.C(view5, 0x7F0A00E3);  // id:award_tv
                if(((MelonTextView)view7) != null) {
                    v2 = 0x7F0A037E;  // id:date_tv
                    View view8 = I.C(view5, 0x7F0A037E);  // id:date_tv
                    if(((MelonTextView)view8) != null) {
                        v2 = 0x7F0A03B1;  // id:description_layout
                        View view9 = I.C(view5, 0x7F0A03B1);  // id:description_layout
                        if(((LinearLayout)view9) != null) {
                            v2 = 0x7F0A03D4;  // id:divided_point_iv
                            View view10 = I.C(view5, 0x7F0A03D4);  // id:divided_point_iv
                            if(((ImageView)view10) != null) {
                                v2 = 0x7F0A056B;  // id:include_thumbnail_layout
                                View view11 = I.C(view5, 0x7F0A056B);  // id:include_thumbnail_layout
                                if(view11 != null) {
                                    f3 f30 = f3.a(view11);
                                    v2 = 0x7F0A05B7;  // id:item_layout
                                    if(((RelativeLayout)I.C(view5, 0x7F0A05B7)) != null) {  // id:item_layout
                                        v2 = 0x7F0A07CA;  // id:main_contents_title
                                        View view12 = I.C(view5, 0x7F0A07CA);  // id:main_contents_title
                                        if(((MainTabTitleView)view12) != null) {
                                            v2 = 0x7F0A091D;  // id:play_button
                                            View view13 = I.C(view5, 0x7F0A091D);  // id:play_button
                                            if(((ImageView)view13) != null) {
                                                v2 = 0x7F0A0B59;  // id:text_layout
                                                View view14 = I.C(view5, 0x7F0A0B59);  // id:text_layout
                                                if(((LinearLayout)view14) != null) {
                                                    v2 = 0x7F0A0BAA;  // id:title_tv
                                                    View view15 = I.C(view5, 0x7F0A0BAA);  // id:title_tv
                                                    if(((MelonTextView)view15) != null) {
                                                        v2 = 0x7F0A0D67;  // id:type_tv
                                                        View view16 = I.C(view5, 0x7F0A0D67);  // id:type_tv
                                                        if(((MelonTextView)view16) != null) {
                                                            return new HighlightSquareViewHolder(new A1(((LinearLayout)view5), ((MelonTextView)view6), ((MelonTextView)view7), ((MelonTextView)view8), ((LinearLayout)view9), ((ImageView)view10), f30, ((MainTabTitleView)view12), ((ImageView)view13), ((LinearLayout)view14), ((MelonTextView)view15), ((MelonTextView)view16)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(v2));
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder$HighlightSquareViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/A1;", "bind", "<init>", "(LJ8/A1;)V", "LJ8/A1;", "getBind", "()LJ8/A1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class HighlightSquareViewHolder extends O0 {
        @NotNull
        private final A1 bind;

        public HighlightSquareViewHolder(@NotNull A1 a10) {
            q.g(a10, "bind");
            super(a10.a);
            this.bind = a10;
        }

        @NotNull
        public final A1 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistHighlightHolder";
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_MOVE_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    @NotNull
    private static final String TYPE_HIRISING = "HIRISING";
    @NotNull
    private static final String TYPE_NEWRELEASE = "NEWRELEASE";
    @NotNull
    private static final String TYPE_RISINGSONG = "RISINGSONG";
    @NotNull
    private static final String TYPE_SPOTLIGHT = "SPOTLIGHT";
    @NotNull
    private static final String TYPE_WEEKAWARD = "WEEKAWARD";
    @Nullable
    private HighlightRecyclerAdapter innerAdapter;
    @Nullable
    private RecyclerView recyclerView;

    static {
        ArtistHighlightHolder.Companion = new Companion(null);
        ArtistHighlightHolder.$stable = 8;
    }

    public ArtistHighlightHolder(@NotNull l l0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(l0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(l0, onViewHolderActionBaseListener0);
        l0.b.setHasFixedSize(true);
        l0.b.setNestedScrollingEnabled(false);
        com.iloen.melon.fragments.artistchannel.viewholder.ArtistHighlightHolder.1.1 artistHighlightHolder$1$10 = new r0() {
            @Override  // androidx.recyclerview.widget.r0
            public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                q.g(rect0, "outRect");
                q.g(view0, "view");
                q.g(recyclerView0, "parent");
                q.g(k00, "state");
                int v = recyclerView0.getChildAdapterPosition(view0);
                int v1 = ScreenUtils.dipToPixel(this.$this_apply.getContext(), 20.0f);
                if(v == 0) {
                    rect0.left = v1;
                }
                rect0.right = v1;
            }
        };
        l0.b.addItemDecoration(artistHighlightHolder$1$10);
        l0.b.getContext();
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(0, false);
        l0.b.setLayoutManager(linearLayoutManager0);
        this.recyclerView = l0.b;
        this.innerAdapter = new HighlightRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final void bindHighlightRectangleItem(HighlightRectangleViewHolder artistHighlightHolder$HighlightRectangleViewHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = artistHighlightHolder$HighlightRectangleViewHolder0.itemView.getLayoutParams();
        viewGroup$LayoutParams0.width = this.innerAdapter == null || this.innerAdapter.getCount() != 1 ? ScreenUtils.dipToPixel(this.getContext(), 295.0f) : -1;
        boolean z = q.b(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.highlightType, "SPOTLIGHT");
        int v1 = z ? ScreenUtils.dipToPixel(this.getContext(), 11.0f) : 0;
        artistHighlightHolder$HighlightRectangleViewHolder0.getBind().e.setImageResource((z ? 0x7F08064A : 0x7F080648));  // drawable:img_logo_spotlight
        artistHighlightHolder$HighlightRectangleViewHolder0.getBind().e.setPadding(0, v1, 0, v1);
        Context context0 = this.getContext();
        if(context0 != null) {
            Glide.with(context0).load(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.imageUrl).into(new CustomTarget() {
                @Override  // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable0) {
                }

                public void onResourceReady(Drawable drawable0, Transition transition0) {
                    q.g(drawable0, "resource");
                    this.$vh.getBind().c.setImageDrawable(drawable0);
                }

                @Override  // com.bumptech.glide.request.target.Target
                public void onResourceReady(Object object0, Transition transition0) {
                    this.onResourceReady(((Drawable)object0), transition0);
                }
            });
            Glide.with(context0).load(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.logoImageUrl).into(artistHighlightHolder$HighlightRectangleViewHolder0.getBind().d);
            String s = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.imageBgColor;
            if(s != null) {
                int v2 = ColorUtils.getColorFromHexStr(s);
                artistHighlightHolder$HighlightRectangleViewHolder0.getBind().b.setCardBackgroundColor(v2);
            }
        }
        k k0 = new k(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, this, v, 0);
        artistHighlightHolder$HighlightRectangleViewHolder0.getBind().b.setOnClickListener(k0);
        z1 z10 = artistHighlightHolder$HighlightRectangleViewHolder0.getBind();
        q.f(z10.a, "getRoot(...)");
        ViewUtilsKt.setAccessibilityButtonClassName(z10.a);
    }

    private static final void bindHighlightRectangleItem$lambda$4(HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, ArtistHighlightHolder artistHighlightHolder0, int v, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.link));
        artistHighlightHolder0.trackTiaraMovePage(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v);
    }

    private final void bindHighlightSquareItem(HighlightSquareViewHolder artistHighlightHolder$HighlightSquareViewHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = artistHighlightHolder$HighlightSquareViewHolder0.itemView.getLayoutParams();
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = artistHighlightHolder$HighlightSquareViewHolder0.getBind().j.getLayoutParams();
        q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        if(this.innerAdapter == null || this.innerAdapter.getCount() != 1) {
            viewGroup$LayoutParams0.width = ScreenUtils.dipToPixel(this.getContext(), 295.0f);
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1).setMarginEnd(ScreenUtils.dipToPixel(this.getContext(), 14.0f));
        }
        else {
            viewGroup$LayoutParams0.width = -1;
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1).setMarginEnd(0);
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        artistHighlightHolder$HighlightSquareViewHolder0.getBind().h.setTitle(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.highlightTitle);
        stringBuilder0.append(artistHighlightHolder$HighlightSquareViewHolder0.getBind().h.getBinding().e.getText());
        Context context0 = this.getContext();
        if(context0 != null) {
            Glide.with(context0).load(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.albumImg).into(artistHighlightHolder$HighlightSquareViewHolder0.getBind().g.b);
        }
        boolean z = q.b("N10002", artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsTypeCode);
        if(z) {
            k k0 = new k(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, this, v, 1);
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().g.a.setOnClickListener(k0);
            k k1 = new k(this, artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v, 2);
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().i.setOnClickListener(k1);
        }
        else {
            k k2 = new k(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, this, v, 3);
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().g.a.setOnClickListener(k2);
            k k3 = new k(this, artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v, 4);
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().i.setOnClickListener(k3);
        }
        artistHighlightHolder$HighlightSquareViewHolder0.getBind().k.setText(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsName);
        artistHighlightHolder$HighlightSquareViewHolder0.getBind().b.setText(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.artistName);
        stringBuilder0.append(", ");
        stringBuilder0.append(artistHighlightHolder$HighlightSquareViewHolder0.getBind().k.getText());
        stringBuilder0.append(", ");
        stringBuilder0.append(artistHighlightHolder$HighlightSquareViewHolder0.getBind().b.getText());
        if(q.b(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.highlightType, "WEEKAWARD")) {
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().c.setVisibility(0);
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().e.setVisibility(8);
            String s = String.format(this.getString(0x7F130117), Arrays.copyOf(new Object[]{artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.awardMonth, artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.awardWeek, artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.awardRank}, 3));  // string:artist_channel_week_award_format "%1$s %2$s %3$s"
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().c.setText(s);
            stringBuilder0.append(", ");
            stringBuilder0.append(artistHighlightHolder$HighlightSquareViewHolder0.getBind().c.getText());
        }
        else {
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().c.setVisibility(8);
            artistHighlightHolder$HighlightSquareViewHolder0.getBind().e.setVisibility(0);
            if(q.b(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.highlightType, "NEWRELEASE")) {
                artistHighlightHolder$HighlightSquareViewHolder0.getBind().l.setText(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.albumType);
                artistHighlightHolder$HighlightSquareViewHolder0.getBind().l.setVisibility(0);
                artistHighlightHolder$HighlightSquareViewHolder0.getBind().f.setVisibility(0);
                stringBuilder0.append(", ");
                stringBuilder0.append(artistHighlightHolder$HighlightSquareViewHolder0.getBind().l.getText());
            }
            else {
                artistHighlightHolder$HighlightSquareViewHolder0.getBind().l.setVisibility(8);
                artistHighlightHolder$HighlightSquareViewHolder0.getBind().f.setVisibility(8);
            }
            String s1 = this.getString(0x7F13012F);  // string:artist_detail_highlight_release "%1$s 발매"
            l1.D(new Object[]{artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.issueDate}, 1, s1, artistHighlightHolder$HighlightSquareViewHolder0.getBind().d);
            stringBuilder0.append(", ");
            stringBuilder0.append(artistHighlightHolder$HighlightSquareViewHolder0.getBind().d.getText());
        }
        com.iloen.melon.fragments.artistchannel.viewholder.ArtistHighlightHolder.bindHighlightSquareItem.6 artistHighlightHolder$bindHighlightSquareItem$60 = new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                CharSequence charSequence0 = null;
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, (z.getContext() == null ? null : "재생")));
                Context context0 = z.getContext();
                if(context0 != null) {
                    charSequence0 = context0.getString((stringBuilder0 ? 0x7F130C54 : 0x7F130C52));  // string:talkback_songlist_album_info "앨범 정보"
                }
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, charSequence0));
                accessibilityNodeInfo0.setContentDescription(artistHighlightHolder$HighlightSquareViewHolder0);
                accessibilityNodeInfo0.setClassName("android.widget.Button");
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        return this.$vh.getBind().g.a.performClick();
                    }
                    case 100000002: {
                        return this.$vh.getBind().i.performClick();
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        };
        artistHighlightHolder$HighlightSquareViewHolder0.getBind().a.setAccessibilityDelegate(artistHighlightHolder$bindHighlightSquareItem$60);
    }

    private static final void bindHighlightSquareItem$lambda$6(HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, ArtistHighlightHolder artistHighlightHolder0, int v, View view0) {
        Navigator.openAlbumInfo(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsId);
        artistHighlightHolder0.trackTiaraMovePage(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v);
    }

    private static final void bindHighlightSquareItem$lambda$7(ArtistHighlightHolder artistHighlightHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v, View view0) {
        artistHighlightHolder0.getOnViewHolderActionListener().onPlayAlbumListener(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsId);
        artistHighlightHolder0.trackTiaraPlayMusic(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v);
    }

    private static final void bindHighlightSquareItem$lambda$8(HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, ArtistHighlightHolder artistHighlightHolder0, int v, View view0) {
        String s = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsId;
        q.f(s, "contsId");
        Navigator.openSongInfo(s);
        artistHighlightHolder0.trackTiaraMovePage(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v);
    }

    private static final void bindHighlightSquareItem$lambda$9(ArtistHighlightHolder artistHighlightHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v, View view0) {
        artistHighlightHolder0.getOnViewHolderActionListener().onPlaySongListener(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsId);
        artistHighlightHolder0.trackTiaraPlayMusic(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, v);
    }

    public static void c(ArtistHighlightHolder artistHighlightHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v, View view0) {
        ArtistHighlightHolder.bindHighlightRectangleItem$lambda$4(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, artistHighlightHolder0, v, view0);
    }

    public static void d(ArtistHighlightHolder artistHighlightHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v, View view0) {
        ArtistHighlightHolder.bindHighlightSquareItem$lambda$8(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, artistHighlightHolder0, v, view0);
    }

    public static void e(ArtistHighlightHolder artistHighlightHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v, View view0) {
        ArtistHighlightHolder.bindHighlightSquareItem$lambda$6(artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, artistHighlightHolder0, v, view0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            HighlightRecyclerAdapter artistHighlightHolder$HighlightRecyclerAdapter0 = this.innerAdapter;
            if(artistHighlightHolder$HighlightRecyclerAdapter0 != null) {
                artistHighlightHolder$HighlightRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final void trackTiaraMovePage(HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130CDC);  // string:tiara_artist_layer1_highlight "하이라이트"
            f0.c(v + 1);
            f0.e = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsId;
            String s = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsTypeCode;
            q.f(s, "contsTypeCode");
            f0.f = b.a(s);
            f0.g = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsName;
            f0.a().track();
        }
    }

    private final void trackTiaraPlayMusic(HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getString(0x7F130CDC);  // string:tiara_artist_layer1_highlight "하이라이트"
            f0.c(v + 1);
            f0.e = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsId;
            String s = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsTypeCode;
            q.f(s, "contsTypeCode");
            f0.f = b.a(s);
            f0.g = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0.contsName;
            f0.a().track();
        }
    }
}

