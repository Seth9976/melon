package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import De.I;
import J8.S1;
import J8.T1;
import J8.g0;
import android.content.Context;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.O;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.RELATIONCONTENT;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 -2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0004-./0B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ#\u0010\u001D\u001A\u00020\u00102\u0012\u0010\u001C\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ7\u0010#\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u00142\u0006\u0010\"\u001A\u00020\u00142\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b#\u0010$R\u0018\u0010&\u001A\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'R\u001C\u0010)\u001A\b\u0018\u00010(R\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$RELATIONCONTENT;", "LJ8/g0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/g0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Landroidx/recyclerview/widget/O0;", "viewHolder", "", "position", "item", "Lie/H;", "bindItem", "(Landroidx/recyclerview/widget/O0;ILcom/iloen/melon/net/v5x/response/DetailBaseRes$RELATIONCONTENT;)V", "vh", "", "title", "subTitle", "contsTypeCode", "setContentDescription", "(Landroidx/recyclerview/widget/O0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "eventMetaType", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;ILcom/iloen/melon/net/v5x/response/DetailBaseRes$RELATIONCONTENT;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder$InnerRecyclerAdapter;", "holderBind", "LJ8/g0;", "Companion", "InnerRecyclerAdapter", "LongViewHolder", "WideViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PlaylistRelationContentHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder$Companion;", "", "<init>", "()V", "TAG", "", "VIEW_TYPE_CAST", "", "VIEW_TYPE_VIDEO", "VIEW_TYPE_MAGAZINE", "TALKBACK_ACTION_DEFAULT", "TALKBACK_ACTION_NAVIGATE_STATION_DETAIL", "TALKBACK_ACTION_PLAYBACK", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistRelationContentHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D021E, viewGroup0, false);  // layout:detail_item_playlist_relation_content
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09CF;  // id:recycler_horizontal
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
                if(recyclerView0 != null) {
                    return new PlaylistRelationContentHolder(new g0(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$RELATIONCONTENT;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "position", "getItemViewType", "(I)I", "vh", "initViewHolder", "(Landroidx/recyclerview/widget/O0;)V", "rawPosition", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends c {
        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            RELATIONCONTENT detailBaseRes$RELATIONCONTENT0 = (RELATIONCONTENT)this.getItem(v);
            String s = detailBaseRes$RELATIONCONTENT0 == null ? null : detailBaseRes$RELATIONCONTENT0.contsTypeCode;
            if(q.b(s, "N10082")) {
                return 1;
            }
            if(q.b(s, "N10003")) {
                return 2;
            }
            return q.b(s, "N10007") ? 3 : 1;
        }

        public void initViewHolder(@NotNull O0 o00) {
            q.g(o00, "vh");
            if(o00 instanceof WideViewHolder) {
                T1 t10 = ((WideViewHolder)o00).getBind();
                t10.g.setImageDrawable(null);
                t10.j.setText("");
                t10.i.setText("");
                t10.h.setText("");
                t10.d.setVisibility(8);
                t10.e.setVisibility(8);
                return;
            }
            if(o00 instanceof LongViewHolder) {
                S1 s10 = ((LongViewHolder)o00).getBind();
                s10.d.setImageDrawable(null);
                s10.f.setText("");
            }
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "vh");
            this.initViewHolder(o00);
            RELATIONCONTENT detailBaseRes$RELATIONCONTENT0 = (RELATIONCONTENT)this.getItem(v1);
            if(detailBaseRes$RELATIONCONTENT0 != null) {
                PlaylistRelationContentHolder.this.bindItem(o00, v1, detailBaseRes$RELATIONCONTENT0);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            int v1 = 0x7F0A0D34;  // id:tv_title
            if(v == 1) {
                View view0 = o.e(viewGroup0, 0x7F0D0482, viewGroup0, false);  // layout:listitem_detail_playlist_content_long
                View view1 = I.C(view0, 0x7F0A065F);  // id:iv_play
                if(((ImageView)view1) == null) {
                    v1 = 0x7F0A065F;  // id:iv_play
                }
                else {
                    View view2 = I.C(view0, 0x7F0A0694);  // id:iv_station_logo
                    if(((ImageView)view2) == null) {
                        v1 = 0x7F0A0694;  // id:iv_station_logo
                    }
                    else {
                        View view3 = I.C(view0, 0x7F0A069A);  // id:iv_thumb
                        if(((MelonImageView)view3) == null) {
                            v1 = 0x7F0A069A;  // id:iv_thumb
                        }
                        else if(((ImageView)I.C(view0, 0x7F0A069E)) != null) {  // id:iv_thumb_default
                            View view4 = I.C(view0, 0x7F0A0D1E);  // id:tv_sub_title
                            if(((MelonTextView)view4) == null) {
                                v1 = 0x7F0A0D1E;  // id:tv_sub_title
                            }
                            else {
                                View view5 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                if(((MelonTextView)view5) != null) {
                                    return new LongViewHolder(new S1(((ConstraintLayout)view0), ((ImageView)view1), ((ImageView)view2), ((MelonImageView)view3), ((MelonTextView)view4), ((MelonTextView)view5)));
                                }
                            }
                        }
                        else {
                            v1 = 0x7F0A069E;  // id:iv_thumb_default
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
            }
            View view6 = o.e(viewGroup0, 0x7F0D0483, viewGroup0, false);  // layout:listitem_detail_playlist_content_wide
            View view7 = I.C(view6, 0x7F0A011C);  // id:bottom_gradation
            if(view7 == null) {
                v1 = 0x7F0A011C;  // id:bottom_gradation
            }
            else {
                View view8 = I.C(view6, 0x7F0A063B);  // id:iv_list_19
                if(((ImageView)view8) == null) {
                    v1 = 0x7F0A063B;  // id:iv_list_19
                }
                else {
                    View view9 = I.C(view6, 0x7F0A064D);  // id:iv_magazine_logo
                    if(((ImageView)view9) == null) {
                        v1 = 0x7F0A064D;  // id:iv_magazine_logo
                    }
                    else {
                        View view10 = I.C(view6, 0x7F0A065F);  // id:iv_play
                        if(((ImageView)view10) == null) {
                            v1 = 0x7F0A065F;  // id:iv_play
                        }
                        else {
                            View view11 = I.C(view6, 0x7F0A069A);  // id:iv_thumb
                            if(((MelonImageView)view11) == null) {
                                v1 = 0x7F0A069A;  // id:iv_thumb
                            }
                            else if(((ImageView)I.C(view6, 0x7F0A069E)) != null) {  // id:iv_thumb_default
                                View view12 = I.C(view6, 0x7F0A0CE5);  // id:tv_playtime
                                if(((MelonTextView)view12) == null) {
                                    v1 = 0x7F0A0CE5;  // id:tv_playtime
                                }
                                else {
                                    View view13 = I.C(view6, 0x7F0A0D1E);  // id:tv_sub_title
                                    if(((MelonTextView)view13) == null) {
                                        v1 = 0x7F0A0D1E;  // id:tv_sub_title
                                    }
                                    else {
                                        View view14 = I.C(view6, 0x7F0A0D34);  // id:tv_title
                                        if(((MelonTextView)view14) != null) {
                                            return new WideViewHolder(new T1(((ConstraintLayout)view6), view7, ((ConstraintLayout)view6), ((ImageView)view8), ((ImageView)view9), ((ImageView)view10), ((MelonImageView)view11), ((MelonTextView)view12), ((MelonTextView)view13), ((MelonTextView)view14)));
                                        }
                                    }
                                }
                            }
                            else {
                                v1 = 0x7F0A069E;  // id:iv_thumb_default
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder$LongViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/S1;", "listItemDetailPlaylistRelationContentLongBinding", "<init>", "(LJ8/S1;)V", "bind", "LJ8/S1;", "getBind", "()LJ8/S1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class LongViewHolder extends O0 {
        @NotNull
        private final S1 bind;

        public LongViewHolder(@NotNull S1 s10) {
            q.g(s10, "listItemDetailPlaylistRelationContentLongBinding");
            super(s10.a);
            this.bind = s10;
        }

        @NotNull
        public final S1 getBind() {
            return this.bind;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder$WideViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/T1;", "listItemDetailPlaylistRelationContentWideBinding", "<init>", "(LJ8/T1;)V", "bind", "LJ8/T1;", "getBind", "()LJ8/T1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class WideViewHolder extends O0 {
        @NotNull
        private final T1 bind;

        public WideViewHolder(@NotNull T1 t10) {
            q.g(t10, "listItemDetailPlaylistRelationContentWideBinding");
            super(t10.a);
            this.bind = t10;
        }

        @NotNull
        public final T1 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistRelationContentHolder";
    public static final int TALKBACK_ACTION_DEFAULT = 100000000;
    public static final int TALKBACK_ACTION_NAVIGATE_STATION_DETAIL = 100000001;
    public static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    public static final int VIEW_TYPE_CAST = 1;
    public static final int VIEW_TYPE_MAGAZINE = 3;
    public static final int VIEW_TYPE_VIDEO = 2;
    @NotNull
    private g0 holderBind;
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    @Nullable
    private RecyclerView recyclerView;

    static {
        PlaylistRelationContentHolder.Companion = new Companion(null);
        PlaylistRelationContentHolder.$stable = 8;
    }

    public PlaylistRelationContentHolder(@NotNull g0 g00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(g00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(g00, onViewHolderActionBaseListener0);
        this.holderBind = g00;
        this.setTitleView(g00.b);
        this.recyclerView = this.holderBind.c;
        this.holderBind.c.setHasFixedSize(true);
        RecyclerView recyclerView0 = this.recyclerView;
        if(recyclerView0 != null) {
            recyclerView0.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView1 = this.recyclerView;
        if(recyclerView1 != null) {
            recyclerView1.addItemDecoration(new O());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if(recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
        }
        this.innerAdapter = new InnerRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void b(PlaylistRelationContentHolder playlistRelationContentHolder0, RELATIONCONTENT detailBaseRes$RELATIONCONTENT0, int v, View view0) {
        PlaylistRelationContentHolder.bindItem$lambda$7$lambda$6(detailBaseRes$RELATIONCONTENT0, playlistRelationContentHolder0, v, view0);
    }

    private final void bindItem(O0 o00, int v, RELATIONCONTENT detailBaseRes$RELATIONCONTENT0) {
        if(o00 instanceof LongViewHolder) {
            S1 s10 = ((LongViewHolder)o00).getBind();
            Context context0 = this.getContext();
            if(context0 != null) {
                Glide.with(context0).load(detailBaseRes$RELATIONCONTENT0.imagePath).into(s10.d);
            }
            s10.f.setText(detailBaseRes$RELATIONCONTENT0.title);
            s10.e.setText(detailBaseRes$RELATIONCONTENT0.description);
            ViewUtils.showWhen(s10.c, true);
            x x0 = q.b(detailBaseRes$RELATIONCONTENT0.contsTypeCode, "N10082") ? new x(this, detailBaseRes$RELATIONCONTENT0, v) : null;
            ViewUtils.setOnClickListener(s10.b, x0);
            x x1 = new x(detailBaseRes$RELATIONCONTENT0, this, v, 1);
            o00.itemView.setOnClickListener(x1);
            String s = detailBaseRes$RELATIONCONTENT0.title;
            q.f(s, "title");
            String s1 = detailBaseRes$RELATIONCONTENT0.description;
            q.f(s1, "description");
            String s2 = detailBaseRes$RELATIONCONTENT0.contsTypeCode;
            q.f(s2, "contsTypeCode");
            this.setContentDescription(o00, s, s1, s2);
        }
        if(o00 instanceof WideViewHolder) {
            T1 t10 = ((WideViewHolder)o00).getBind();
            Context context1 = this.getContext();
            if(context1 != null) {
                Glide.with(context1).load(detailBaseRes$RELATIONCONTENT0.imagePath).into(t10.g);
            }
            ImageView imageView0 = t10.e;
            t10.j.setText(detailBaseRes$RELATIONCONTENT0.title);
            t10.i.setText(detailBaseRes$RELATIONCONTENT0.description);
            t10.h.setText(detailBaseRes$RELATIONCONTENT0.playTime);
            if(q.b(detailBaseRes$RELATIONCONTENT0.contsTypeCode, "N10007")) {
                ViewUtils.showWhen(imageView0, true);
                String s3 = String.format(this.getString(0x7F130BE9), Arrays.copyOf(new Object[]{detailBaseRes$RELATIONCONTENT0.title, detailBaseRes$RELATIONCONTENT0.description}, 2));  // string:talkback_playlist_magazine_event "매거진, %1$s, 코너명, %2$s"
                ViewUtils.setContentDescriptionWithButtonClassName(t10.c, s3);
            }
            else {
                ViewUtils.hideWhen(imageView0, true);
            }
            x x2 = new x(detailBaseRes$RELATIONCONTENT0, this, v, 2);
            o00.itemView.setOnClickListener(x2);
            String s4 = detailBaseRes$RELATIONCONTENT0.title;
            q.f(s4, "title");
            String s5 = detailBaseRes$RELATIONCONTENT0.description;
            q.f(s5, "description");
            String s6 = detailBaseRes$RELATIONCONTENT0.contsTypeCode;
            q.f(s6, "contsTypeCode");
            this.setContentDescription(o00, s4, s5, s6);
        }
    }

    private static final void bindItem$lambda$4$lambda$2(PlaylistRelationContentHolder playlistRelationContentHolder0, RELATIONCONTENT detailBaseRes$RELATIONCONTENT0, int v, View view0) {
        playlistRelationContentHolder0.getOnViewHolderActionListener().onPlayRadioCast(detailBaseRes$RELATIONCONTENT0.contsId);
        String s = playlistRelationContentHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        String s1 = playlistRelationContentHolder0.getString(0x7F130F03);  // string:tiara_meta_type_station "스테이션"
        playlistRelationContentHolder0.itemClickLog(ActionKind.PlayMusic, s, s1, v, detailBaseRes$RELATIONCONTENT0);
    }

    private static final void bindItem$lambda$4$lambda$3(RELATIONCONTENT detailBaseRes$RELATIONCONTENT0, PlaylistRelationContentHolder playlistRelationContentHolder0, int v, View view0) {
        if(q.b(detailBaseRes$RELATIONCONTENT0.contsTypeCode, "N10082")) {
            playlistRelationContentHolder0.getOnViewHolderActionListener().onOpenCastEpisodeDetailView(detailBaseRes$RELATIONCONTENT0.contsId);
            String s = playlistRelationContentHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s1 = playlistRelationContentHolder0.getString(0x7F130F03);  // string:tiara_meta_type_station "스테이션"
            playlistRelationContentHolder0.itemClickLog(ActionKind.ClickContent, s, s1, v, detailBaseRes$RELATIONCONTENT0);
        }
    }

    private static final void bindItem$lambda$7$lambda$6(RELATIONCONTENT detailBaseRes$RELATIONCONTENT0, PlaylistRelationContentHolder playlistRelationContentHolder0, int v, View view0) {
        String s = detailBaseRes$RELATIONCONTENT0.contsTypeCode;
        if(q.b(s, "N10003")) {
            Navigator.openMvInfo$default(detailBaseRes$RELATIONCONTENT0.contsId, playlistRelationContentHolder0.getMenuId(), null, false, 12, null);
            String s1 = playlistRelationContentHolder0.getString(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
            String s2 = playlistRelationContentHolder0.getString(0x7F130F04);  // string:tiara_meta_type_video "뮤직비디오"
            playlistRelationContentHolder0.itemClickLog(ActionKind.PlayVideo, s1, s2, v, detailBaseRes$RELATIONCONTENT0);
            return;
        }
        if(q.b(s, "N10007")) {
            MelonLinkExecutor.open(MelonLinkInfo.b(detailBaseRes$RELATIONCONTENT0.option));
            String s3 = playlistRelationContentHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s4 = playlistRelationContentHolder0.getString(0x7F130EFB);  // string:tiara_meta_type_magazine "매거진"
            playlistRelationContentHolder0.itemClickLog(ActionKind.ClickContent, s3, s4, v, detailBaseRes$RELATIONCONTENT0);
        }
    }

    public static void c(PlaylistRelationContentHolder playlistRelationContentHolder0, RELATIONCONTENT detailBaseRes$RELATIONCONTENT0, int v, View view0) {
        PlaylistRelationContentHolder.bindItem$lambda$4$lambda$3(detailBaseRes$RELATIONCONTENT0, playlistRelationContentHolder0, v, view0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130348);  // string:dj_playlist_title_relation_content "연관 콘텐츠"
    }

    public final void itemClickLog(@NotNull ActionKind actionKind0, @NotNull String s, @NotNull String s1, int v, @Nullable RELATIONCONTENT detailBaseRes$RELATIONCONTENT0) {
        q.g(actionKind0, "actionKind");
        q.g(s, "actionName");
        q.g(s1, "eventMetaType");
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.d = actionKind0;
            f0.a = s;
            f0.y = this.getString(0x7F130E66);  // string:tiara_djplaylist_layer1_relation_content "연관콘텐츠"
            f0.c(v + 1);
            String s2 = null;
            f0.e = detailBaseRes$RELATIONCONTENT0 == null ? null : detailBaseRes$RELATIONCONTENT0.contsId;
            f0.f = s1;
            if(detailBaseRes$RELATIONCONTENT0 != null) {
                s2 = detailBaseRes$RELATIONCONTENT0.title;
            }
            f0.g = s2;
            f0.a().track();
        }
    }

    @NotNull
    public static final PlaylistRelationContentHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return PlaylistRelationContentHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            InnerRecyclerAdapter playlistRelationContentHolder$InnerRecyclerAdapter0 = this.innerAdapter;
            if(playlistRelationContentHolder$InnerRecyclerAdapter0 != null) {
                playlistRelationContentHolder$InnerRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final void setContentDescription(O0 o00, String s, String s1, String s2) {
        q.f(o00.itemView, "itemView");
        ImageView imageView0 = o00 instanceof LongViewHolder ? ((LongViewHolder)o00).getBind().b : ((WideViewHolder)o00).getBind().f;
        q.f(imageView0, "ivPlay");
        String s3 = ContsTypeCode.getAccessibilityName(s2);
        imageView0.setImportantForAccessibility(2);
        o00.itemView.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                String s = s.getString(0x7F130AF1);  // string:talkback_common_navigate_detail "상세보기"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, this + s));
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, s.getString(0x7F130C59)));  // string:talkback_songlist_song_play "재생"
                String s1 = s.getString(0x7F130AD8);  // string:talkback_author "제작자"
                String s2 = s.getString(0x7F130AF1);  // string:talkback_common_navigate_detail "상세보기"
                accessibilityNodeInfo0.setContentDescription(d.n(a.o(this, ", ", s1, ", ", s1), ": ", o00.itemView, ", ", s2));
                accessibilityNodeInfo0.setClassName("android.widget.Button");
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        imageView0.performClick();
                        return true;
                    }
                    case 100000002: {
                        this.$ivPlay.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        });
    }
}

