package com.iloen.melon.fragments.melonchart;

import E8.c;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.exoplayer2.upstream.cache.a;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.ArtistChartListReq.Params;
import com.iloen.melon.net.v4x.request.ArtistChartListReq;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.ArtistChartListRes.RESPONSE.CHARTINFO;
import com.iloen.melon.net.v4x.response.ArtistChartListRes.RESPONSE.CHARTLIST;
import com.iloen.melon.net.v4x.response.ArtistChartListRes.RESPONSE.SEARCHTYPELIST;
import com.iloen.melon.net.v4x.response.ArtistChartListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ArtistChartListRes;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.n;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.O;
import p8.g;
import p8.s;
import v9.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ!\u0010\u0011\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001B\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001D2\u0006\u0010\u001C\u001A\u00020\u001BH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001A\u00020\t2\u0006\u0010$\u001A\u00020#H\u0016\u00A2\u0006\u0004\b%\u0010&J\u001F\u0010*\u001A\u00020\t2\u0006\u0010\'\u001A\u00020 2\u0006\u0010)\u001A\u00020(H\u0016\u00A2\u0006\u0004\b*\u0010+R\u0018\u0010,\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001A\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R&\u00104\u001A\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`38\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001A\u0002068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b9\u0010\u0006\u00A8\u0006="}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment;", "Lcom/iloen/melon/fragments/melonchart/MelonChartBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "recyclerView", "", "positions", "onReadyToFetchPartially", "(Landroidx/recyclerview/widget/RecyclerView;[I)V", "mDatetime", "Ljava/lang/String;", "Lcom/iloen/melon/net/v4x/response/ArtistChartListRes$RESPONSE$CHARTINFO;", "mCharInfo", "Lcom/iloen/melon/net/v4x/response/ArtistChartListRes$RESPONSE$CHARTINFO;", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "mFilterList", "Ljava/util/ArrayList;", "", "mCurrentFilterIndex", "I", "getFilterName", "filterName", "Companion", "ArtistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartArtistFragment extends MelonChartBaseFragment {
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002()B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010!R\u001E\u0010&\u001A\n0$R\u00060\u0000R\u00020%8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'¨\u0006*"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/ArtistChartListRes$RESPONSE$CHARTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "Lie/H;", "screenRotated", "()V", "", "isVisible", "updateHeaderLayout", "(Z)V", "getHeaderViewItemCount", "()I", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_ARTIST", "VIEW_TYPE_ARTIST_LAND", "Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter$ArtistHeaderHolder;", "Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment;", "headerHolder", "Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter$ArtistHeaderHolder;", "ArtistHeaderHolder", "ArtistAllHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ArtistAdapter extends p {
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001A\u0004\b\u0011\u0010\u000FR\u0017\u0010\u0012\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001A\u0004\b\u0013\u0010\u000FR\u0017\u0010\u0015\u001A\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001A\u0004\b\u001A\u0010\u000FR\u0017\u0010\u001B\u001A\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0016\u001A\u0004\b\u001C\u0010\u0018R\u0017\u0010\u001D\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u001D\u0010\r\u001A\u0004\b\u001E\u0010\u000FR\u0017\u0010\u001F\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u001F\u0010\r\u001A\u0004\b \u0010\u000FR\u0017\u0010!\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b!\u0010\r\u001A\u0004\b\"\u0010\u000FR\u0017\u0010#\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001A\u0004\b$\u0010\u000FR\u0017\u0010%\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b%\u0010\r\u001A\u0004\b&\u0010\u000FR\u0017\u0010\'\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\'\u0010\r\u001A\u0004\b(\u0010\u000FR\u0017\u0010)\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b)\u0010\r\u001A\u0004\b*\u0010\u000F¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter$ArtistAllHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/BorderImageView;", "thumbIv", "Lcom/iloen/melon/custom/BorderImageView;", "getThumbIv", "()Lcom/iloen/melon/custom/BorderImageView;", "Landroid/widget/TextView;", "rankTv", "Landroid/widget/TextView;", "getRankTv", "()Landroid/widget/TextView;", "listChangeTv", "getListChangeTv", "titleTv", "getTitleTv", "Landroid/widget/ImageView;", "fanIv", "Landroid/widget/ImageView;", "getFanIv", "()Landroid/widget/ImageView;", "topRankTv", "getTopRankTv", "increaseFanIv", "getIncreaseFanIv", "increaseFanTv", "getIncreaseFanTv", "stackFanTv", "getStackFanTv", "songIndexTv", "getSongIndexTv", "fanIndexTv", "getFanIndexTv", "likeIndexTv", "getLikeIndexTv", "photoIndexTv", "getPhotoIndexTv", "mvIndexTv", "getMvIndexTv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ArtistAllHolder extends O0 {
            @NotNull
            private final TextView fanIndexTv;
            @NotNull
            private final ImageView fanIv;
            @NotNull
            private final ImageView increaseFanIv;
            @NotNull
            private final TextView increaseFanTv;
            @NotNull
            private final TextView likeIndexTv;
            @NotNull
            private final TextView listChangeTv;
            @NotNull
            private final TextView mvIndexTv;
            @NotNull
            private final TextView photoIndexTv;
            @NotNull
            private final TextView rankTv;
            @NotNull
            private final TextView songIndexTv;
            @NotNull
            private final TextView stackFanTv;
            @NotNull
            private final BorderImageView thumbIv;
            @NotNull
            private final TextView titleTv;
            @NotNull
            private final TextView topRankTv;

            public ArtistAllHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistAdapter.this = melonChartArtistFragment$ArtistAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
                q.f(view1, "findViewById(...)");
                View view2 = view1.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                q.f(view2, "findViewById(...)");
                ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(melonChartArtistFragment$ArtistAdapter0.getContext(), 65.0f), true);
                View view3 = view1.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                q.f(view3, "findViewById(...)");
                this.thumbIv = (BorderImageView)view3;
                ((BorderImageView)view3).setBorderWidth(ScreenUtils.dipToPixel(melonChartArtistFragment$ArtistAdapter0.getContext(), 1.0f));
                ((BorderImageView)view3).setBorderColor(ColorUtils.getColor(melonChartArtistFragment$ArtistAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                View view4 = view0.findViewById(0x7F0A09B4);  // id:rank_tv
                q.f(view4, "findViewById(...)");
                this.rankTv = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A0C9C);  // id:tv_list_change
                q.f(view5, "findViewById(...)");
                this.listChangeTv = (TextView)view5;
                View view6 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view6, "findViewById(...)");
                this.titleTv = (TextView)view6;
                View view7 = view0.findViewById(0x7F0A0490);  // id:fan_iv
                q.f(view7, "findViewById(...)");
                this.fanIv = (ImageView)view7;
                View view8 = view0.findViewById(0x7F0A0BD8);  // id:toprank_tv
                q.f(view8, "findViewById(...)");
                this.topRankTv = (TextView)view8;
                View view9 = view0.findViewById(0x7F0A056F);  // id:increase_fan_iv
                q.f(view9, "findViewById(...)");
                this.increaseFanIv = (ImageView)view9;
                View view10 = view0.findViewById(0x7F0A0570);  // id:increase_fan_tv
                q.f(view10, "findViewById(...)");
                this.increaseFanTv = (TextView)view10;
                View view11 = view0.findViewById(0x7F0A0ADB);  // id:stack_fan_tv
                q.f(view11, "findViewById(...)");
                this.stackFanTv = (TextView)view11;
                View view12 = view0.findViewById(0x7F0A0AA9);  // id:song_index_tv
                q.f(view12, "findViewById(...)");
                this.songIndexTv = (TextView)view12;
                View view13 = view0.findViewById(0x7F0A048F);  // id:fan_index_tv
                q.f(view13, "findViewById(...)");
                this.fanIndexTv = (TextView)view13;
                View view14 = view0.findViewById(0x7F0A0768);  // id:like_index_tv
                q.f(view14, "findViewById(...)");
                this.likeIndexTv = (TextView)view14;
                View view15 = view0.findViewById(0x7F0A0917);  // id:photo_index_tv
                q.f(view15, "findViewById(...)");
                this.photoIndexTv = (TextView)view15;
                View view16 = view0.findViewById(0x7F0A088D);  // id:mv_index_tv
                q.f(view16, "findViewById(...)");
                this.mvIndexTv = (TextView)view16;
            }

            @NotNull
            public final TextView getFanIndexTv() {
                return this.fanIndexTv;
            }

            @NotNull
            public final ImageView getFanIv() {
                return this.fanIv;
            }

            @NotNull
            public final ImageView getIncreaseFanIv() {
                return this.increaseFanIv;
            }

            @NotNull
            public final TextView getIncreaseFanTv() {
                return this.increaseFanTv;
            }

            @NotNull
            public final TextView getLikeIndexTv() {
                return this.likeIndexTv;
            }

            @NotNull
            public final TextView getListChangeTv() {
                return this.listChangeTv;
            }

            @NotNull
            public final TextView getMvIndexTv() {
                return this.mvIndexTv;
            }

            @NotNull
            public final TextView getPhotoIndexTv() {
                return this.photoIndexTv;
            }

            @NotNull
            public final TextView getRankTv() {
                return this.rankTv;
            }

            @NotNull
            public final TextView getSongIndexTv() {
                return this.songIndexTv;
            }

            @NotNull
            public final TextView getStackFanTv() {
                return this.stackFanTv;
            }

            @NotNull
            public final BorderImageView getThumbIv() {
                return this.thumbIv;
            }

            @NotNull
            public final TextView getTitleTv() {
                return this.titleTv;
            }

            @NotNull
            public final TextView getTopRankTv() {
                return this.topRankTv;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\"\u0010\r\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\b\u001A\u0004\b\u000E\u0010\n\"\u0004\b\u000F\u0010\fR\"\u0010\u0011\u001A\u00020\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter$ArtistHeaderHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "datetimeTv", "Landroid/widget/TextView;", "getDatetimeTv", "()Landroid/widget/TextView;", "setDatetimeTv", "(Landroid/widget/TextView;)V", "chartInfoTv", "getChartInfoTv", "setChartInfoTv", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "scAlyacFilterView", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "getScAlyacFilterView", "()Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "setScAlyacFilterView", "(Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ArtistHeaderHolder extends O0 {
            @NotNull
            private TextView chartInfoTv;
            @NotNull
            private TextView datetimeTv;
            @NotNull
            private ScrollableAlyacFilter scAlyacFilterView;

            public ArtistHeaderHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistAdapter.this = melonChartArtistFragment$ArtistAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A037F);  // id:datetime_tv
                q.f(view1, "findViewById(...)");
                this.datetimeTv = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A024A);  // id:chart_info_tv
                q.f(view2, "findViewById(...)");
                this.chartInfoTv = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A0A31);  // id:scrollable_alyac_filter
                q.f(view3, "findViewById(...)");
                this.scAlyacFilterView = (ScrollableAlyacFilter)view3;
                String s = MelonChartArtistFragment.this.mDatetime;
                boolean z = false;
                ViewUtils.showWhen(this.datetimeTv, ((boolean)((s == null || s.length() == 0 ? 1 : 0) ^ 1)));
                this.datetimeTv.setText(MelonChartArtistFragment.this.mDatetime);
                TextView textView0 = this.chartInfoTv;
                if(MelonChartArtistFragment.this.mCharInfo != null) {
                    z = true;
                }
                ViewUtils.showWhen(textView0, z);
                ViewUtils.setOnClickListener(this.chartInfoTv, new j(MelonChartArtistFragment.this, 1));
            }

            private static final void _init_$lambda$1(MelonChartArtistFragment melonChartArtistFragment0, View view0) {
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                CHARTINFO artistChartListRes$RESPONSE$CHARTINFO0 = melonChartArtistFragment0.mCharInfo;
                String s = null;
                melonLinkInfo0.a = artistChartListRes$RESPONSE$CHARTINFO0 == null ? null : artistChartListRes$RESPONSE$CHARTINFO0.openType;
                CHARTINFO artistChartListRes$RESPONSE$CHARTINFO1 = melonChartArtistFragment0.mCharInfo;
                melonLinkInfo0.b = artistChartListRes$RESPONSE$CHARTINFO1 == null ? null : artistChartListRes$RESPONSE$CHARTINFO1.openLink;
                MelonLinkExecutor.open(melonLinkInfo0);
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartArtistFragment0.mMenuId;
                g0.a = "페이지이동";
                s s1 = melonChartArtistFragment0.mMelonTiaraProperty;
                g0.b = s1 == null ? null : s1.a;
                s s2 = melonChartArtistFragment0.mMelonTiaraProperty;
                if(s2 != null) {
                    s = s2.b;
                }
                g0.c = s;
                g0.y = "Pagemenu";
                g0.z = "페이지이동";
                g0.F = "차트안내";
                g0.a().track();
            }

            @NotNull
            public final TextView getChartInfoTv() {
                return this.chartInfoTv;
            }

            @NotNull
            public final TextView getDatetimeTv() {
                return this.datetimeTv;
            }

            @NotNull
            public final ScrollableAlyacFilter getScAlyacFilterView() {
                return this.scAlyacFilterView;
            }

            public final void setChartInfoTv(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.chartInfoTv = textView0;
            }

            public final void setDatetimeTv(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.datetimeTv = textView0;
            }

            public final void setScAlyacFilterView(@NotNull ScrollableAlyacFilter scrollableAlyacFilter0) {
                q.g(scrollableAlyacFilter0, "<set-?>");
                this.scAlyacFilterView = scrollableAlyacFilter0;
            }
        }

        private final int VIEW_TYPE_ARTIST;
        private final int VIEW_TYPE_ARTIST_LAND;
        private final int VIEW_TYPE_HEADER;
        @NotNull
        private ArtistHeaderHolder headerHolder;

        public ArtistAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonChartArtistFragment.this = melonChartArtistFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ARTIST = 1;
            this.VIEW_TYPE_ARTIST_LAND = 2;
            View view0 = LayoutInflater.from(context0).inflate(0x7F0D0262, null, false);  // layout:filter_alyac_date_info
            q.f(view0, "inflate(...)");
            this.headerHolder = new ArtistHeaderHolder(this, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            if(this.mResponse != null) {
                View view0 = this.headerHolder.itemView;
                q.f(view0, "itemView");
                return view0.getVisibility() == 0 ? 1 : 0;
            }
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getItemCount() > 0 && v == this.getAvailableHeaderPosition()) {
                return this.VIEW_TYPE_HEADER;
            }
            return ScreenUtils.isPortrait(this.getContext()) ? this.VIEW_TYPE_ARTIST : this.VIEW_TYPE_ARTIST_LAND;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            boolean z = true;
            if(v2 == this.VIEW_TYPE_HEADER) {
                ResponseBase responseBase0 = this.mResponse.getResponse();
                q.e(responseBase0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.ArtistChartListRes.RESPONSE");
                MelonChartArtistFragment.this.mDatetime = ((RESPONSE)responseBase0).rankDay;
                String s = MelonChartArtistFragment.this.mDatetime;
                ViewUtils.showWhen(((ArtistHeaderHolder)o00).getDatetimeTv(), ((boolean)((s == null || s.length() == 0 ? 1 : 0) ^ 1)));
                ((ArtistHeaderHolder)o00).getDatetimeTv().setText(MelonChartArtistFragment.this.mDatetime);
                MelonChartArtistFragment.this.mCharInfo = ((RESPONSE)responseBase0).chartInfo;
                TextView textView0 = ((ArtistHeaderHolder)o00).getChartInfoTv();
                if(MelonChartArtistFragment.this.mCharInfo == null) {
                    z = false;
                }
                ViewUtils.showWhen(textView0, z);
                return;
            }
            if(v2 != this.VIEW_TYPE_ARTIST && v2 != this.VIEW_TYPE_ARTIST_LAND) {
                return;
            }
            ArtistAllHolder melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0 = (ArtistAllHolder)o00;
            Object object0 = this.getItem(v1);
            i i0 = new i(MelonChartArtistFragment.this, ((CHARTLIST)object0), v1, 1);
            ViewUtils.setOnClickListener(melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.itemView, i0);
            Glide.with(this.getContext()).load(((CHARTLIST)object0).artistImg).apply(RequestOptions.circleCropTransform()).into(melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getThumbIv());
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getRankTv().setText(((CHARTLIST)object0).currRank);
            String s1 = ((CHARTLIST)object0).rankType;
            int v3 = 0x7F0803DC;  // drawable:ic_common_arrow_up
            if(s1 != null) {
                switch(s1) {
                    case "DOWN": {
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setCompoundDrawablesWithIntrinsicBounds(0x7F0803D7, 0, 0, 0);  // drawable:ic_common_arrow_down
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060046));  // color:blue400s_support_high_contrast
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setText(((CHARTLIST)object0).rankGap);
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setTextSize(1, 12.0f);
                        break;
                    }
                    case "NEW": {
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060459));  // color:rank_new_color
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setText("NEW");
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setTextSize(1, 10.0f);
                        break;
                    }
                    case "NONE": {
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setCompoundDrawablesWithIntrinsicBounds(0x7F0803DB, 0, 0, 0);  // drawable:ic_common_arrow_equal_tint
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setText("");
                        break;
                    }
                    case "UP": {
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setCompoundDrawablesWithIntrinsicBounds(0x7F0803DC, 0, 0, 0);  // drawable:ic_common_arrow_up
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06045A));  // color:rank_up_color
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setText(((CHARTLIST)object0).rankGap);
                        melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getListChangeTv().setTextSize(1, 12.0f);
                    }
                }
            }
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getTitleTv().setText(((CHARTLIST)object0).artistName);
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getTopRankTv().setText(((CHARTLIST)object0).topRank);
            String s2 = ((CHARTLIST)object0).incremType;
            if(!q.b(s2, "UP")) {
                v3 = q.b(s2, "DOWN") ? 0x7F0803D7 : 0x7F0803DB;  // drawable:ic_common_arrow_down
            }
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getIncreaseFanIv().setBackgroundResource(v3);
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getIncreaseFanTv().setText(StringUtils.getCountString(((CHARTLIST)object0).incremFanCnt, 0x3B9AC9FF));
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getStackFanTv().setText(StringUtils.getCountString(((CHARTLIST)object0).totFanCnt, 0x3B9AC9FF));
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getSongIndexTv().setText(((CHARTLIST)object0).songIdx);
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getFanIndexTv().setText(((CHARTLIST)object0).fanIdx);
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getLikeIndexTv().setText(((CHARTLIST)object0).likeIdx);
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getPhotoIndexTv().setText(((CHARTLIST)object0).photoIdx);
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getMvIndexTv().setText(((CHARTLIST)object0).mvIdx);
            melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getFanIv().setImageResource(("Y".equals(((CHARTLIST)object0).isFan) ? 0x7F08013E : 0x7F08013C));  // drawable:btn_common_fan_22_on
            ViewUtils.setOnClickListener(melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0.getFanIv(), new k(((CHARTLIST)object0), MelonChartArtistFragment.this, this, v1, melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0));

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\u000B\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"com/iloen/melon/fragments/melonchart/MelonChartArtistFragment$ArtistAdapter$onBindViewImpl$2$1", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "Lie/H;", "onStartAsyncTask", "()V", "", "errorMsg", "", "sumCount", "", "isLike", "onJobComplete", "(Ljava/lang/String;IZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public final class com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter.onBindViewImpl.2.1 implements OnJobFinishListener {
                public com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter.onBindViewImpl.2.1(MelonChartArtistFragment melonChartArtistFragment0, CHARTLIST artistChartListRes$RESPONSE$CHARTLIST0, ArtistAdapter melonChartArtistFragment$ArtistAdapter0, ArtistAllHolder melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0) {
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onJobComplete(String s, int v, boolean z) {
                    q.g(s, "errorMsg");
                    if(!MelonChartArtistFragment.this.isFragmentValid()) {
                        return;
                    }
                    if(s.length() == 0) {
                        MelonChartArtistFragment.this.showRecommendContentsPopup(this.$data.artistId, "C");
                        O.a(new UaLogDummyReq(ArtistAdapter.this.getContext(), "recmChartFanPopup"));
                        this.$data.isFan = "Y";
                        this.$vh.getFanIv().setImageResource(0x7F08013E);  // drawable:btn_common_fan_22_on
                    }
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onStartAsyncTask() {
                }
            }

        }

        private static final void onBindViewImpl$lambda$1(MelonChartArtistFragment melonChartArtistFragment0, CHARTLIST artistChartListRes$RESPONSE$CHARTLIST0, int v, View view0) {
            melonChartArtistFragment0.showArtistInfoPage(artistChartListRes$RESPONSE$CHARTLIST0.artistId);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartArtistFragment0.mMenuId;
            g0.a = "페이지이동";
            s s0 = melonChartArtistFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            s s2 = melonChartArtistFragment0.mMelonTiaraProperty;
            if(s2 != null) {
                s1 = s2.b;
            }
            g0.c = s1;
            g0.d = ActionKind.ClickContent;
            g0.y = "아티스트리스트";
            g0.z = MelonChartArtistFragment.access$getFilterName(melonChartArtistFragment0);
            g0.F = "아티스트페이지이동";
            g0.C = String.valueOf(v + 1);
            g0.E = artistChartListRes$RESPONSE$CHARTLIST0.artistImg;
            g0.e = artistChartListRes$RESPONSE$CHARTLIST0.artistId;
            g0.f = Y.i(ContsTypeCode.ARTIST, "code(...)");
            g0.g = artistChartListRes$RESPONSE$CHARTLIST0.artistName;
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$2(CHARTLIST artistChartListRes$RESPONSE$CHARTLIST0, MelonChartArtistFragment melonChartArtistFragment0, ArtistAdapter melonChartArtistFragment$ArtistAdapter0, int v, ArtistAllHolder melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0, View view0) {
            if("Y".equals(artistChartListRes$RESPONSE$CHARTLIST0.isFan)) {
                return;
            }
            ContsTypeCode contsTypeCode0 = ContsTypeCode.ARTIST;
            melonChartArtistFragment0.updateFan(artistChartListRes$RESPONSE$CHARTLIST0.artistId, "N10006", true, melonChartArtistFragment$ArtistAdapter0.getMenuId(), new com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter.onBindViewImpl.2.1(melonChartArtistFragment0, artistChartListRes$RESPONSE$CHARTLIST0, melonChartArtistFragment$ArtistAdapter0, melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0));
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartArtistFragment0.mMenuId;
            g0.a = "팬맺기";
            s s0 = melonChartArtistFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            s s2 = melonChartArtistFragment0.mMelonTiaraProperty;
            if(s2 != null) {
                s1 = s2.b;
            }
            g0.c = s1;
            g0.d = ActionKind.Follow;
            g0.y = "아티스트리스트";
            g0.z = MelonChartArtistFragment.access$getFilterName(melonChartArtistFragment0);
            g0.F = "팬맺기";
            g0.C = String.valueOf(v + 1);
            g0.E = artistChartListRes$RESPONSE$CHARTLIST0.artistImg;
            g0.e = artistChartListRes$RESPONSE$CHARTLIST0.artistId;
            g0.f = Y.i(contsTypeCode0, "code(...)");
            g0.g = artistChartListRes$RESPONSE$CHARTLIST0.artistName;
            g0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HEADER) {
                O0 o00 = this.headerHolder;
                int v1 = ColorUtils.getColor(this.getContext(), 0x7F0604AA);  // color:white000s_support_high_contrast
                o00.itemView.setBackgroundColor(v1);
                if(!MelonChartArtistFragment.this.mFilterList.isEmpty() && MelonChartArtistFragment.this.mFilterList.size() > 0) {
                    ((ArtistHeaderHolder)o00).getScAlyacFilterView().setPadding(ScreenUtils.dipToPixel(this.getContext(), 20.0f));
                    if(((ArtistHeaderHolder)o00).getScAlyacFilterView().d(MelonChartArtistFragment.this.mFilterList)) {
                        ((ArtistHeaderHolder)o00).getScAlyacFilterView().e(new l(MelonChartArtistFragment.this, 0), new c());  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                }
                return o00;
            }
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04E5, viewGroup0, false);  // layout:melonchart_artist_all_listitem
            q.f(view0, "inflate(...)");
            return new ArtistAllHolder(this, view0);
        }

        private static final void onCreateViewHolderImpl$lambda$0(MelonChartArtistFragment melonChartArtistFragment0, int v) {
            if(melonChartArtistFragment0.mCurrentFilterIndex == v) {
                return;
            }
            melonChartArtistFragment0.mCurrentFilterIndex = v;
            melonChartArtistFragment0.startFetch("filter change");
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartArtistFragment0.mMenuId;
            g0.a = "페이지이동";
            s s0 = melonChartArtistFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            s s2 = melonChartArtistFragment0.mMelonTiaraProperty;
            if(s2 != null) {
                s1 = s2.b;
            }
            g0.c = s1;
            g0.y = "Pagemenu";
            g0.F = MelonChartArtistFragment.access$getFilterName(melonChartArtistFragment0);
            g0.a().track();
        }

        public final void screenRotated() {
            this.headerHolder.getScAlyacFilterView().c(MelonChartArtistFragment.this.mCurrentFilterIndex);
        }

        public final void updateHeaderLayout(boolean z) {
            View view0 = this.headerHolder.itemView;
            q.f(view0, "itemView");
            view0.setVisibility((z ? 0 : 8));
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001A\u00020\bH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_FILTER_INDEX", "newInstance", "Lcom/iloen/melon/fragments/melonchart/MelonChartArtistFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonChartArtistFragment newInstance() {
            MelonChartArtistFragment melonChartArtistFragment0 = new MelonChartArtistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argHasPersonalizedContent", true);
            melonChartArtistFragment0.setArguments(bundle0);
            return melonChartArtistFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_FILTER_INDEX = "argFilterIndex";
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    @Nullable
    private CHARTINFO mCharInfo;
    private int mCurrentFilterIndex;
    @Nullable
    private String mDatetime;
    @NotNull
    private ArrayList mFilterList;

    static {
        MelonChartArtistFragment.Companion = new Companion(null);
        MelonChartArtistFragment.$stable = 8;
        MelonChartArtistFragment.TAG = "MelonChartArtistFragment";
    }

    public MelonChartArtistFragment() {
        this.mFilterList = new ArrayList();
    }

    // 去混淆评级： 低(20)
    public static final String access$getFilterName(MelonChartArtistFragment melonChartArtistFragment0) {
        return "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new ArtistAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.r0.buildUpon().appendQueryParameter("filterIndex", String.valueOf(this.mCurrentFilterIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final String getFilterName() [...] // 潜在的解密器

    @NotNull
    public static final MelonChartArtistFragment newInstance() {
        return MelonChartArtistFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter");
        ((ArtistAdapter)j00).screenRotated();
        this.onUpdateParallaxHeader();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter");
        ((ArtistAdapter)j00).clear();
        Params artistChartListReq$Params0 = new Params();
        artistChartListReq$Params0.startIndex = 1;
        artistChartListReq$Params0.pageSize = 50;
        artistChartListReq$Params0.searchType = this.mFilterList.isEmpty() ? "DP0000" : ((v9.j)this.mFilterList.get(this.mCurrentFilterIndex)).c;
        RequestBuilder.newInstance(new ArtistChartListReq(this.getActivity(), artistChartListReq$Params0)).tag(this.getRequestTag()).listener(new J(this, i0, 2)).errorListener(new l(this, 1)).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(MelonChartArtistFragment melonChartArtistFragment0, v9.i i0, ArtistChartListRes artistChartListRes0) {
        if(!melonChartArtistFragment0.prepareFetchComplete(artistChartListRes0)) {
            j0 j00 = melonChartArtistFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter");
            ((ArtistAdapter)j00).updateHeaderLayout(false);
            return;
        }
        if((artistChartListRes0 == null ? null : artistChartListRes0.response) != null) {
            ArrayList arrayList0 = artistChartListRes0.response.searchtypelists;
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                if(!melonChartArtistFragment0.mFilterList.isEmpty()) {
                    melonChartArtistFragment0.mFilterList.clear();
                }
                Iterator iterator0 = arrayList0.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j0.c = ((SEARCHTYPELIST)object0).typeCode;
                    j0.b = ((SEARCHTYPELIST)object0).typeCodeName;
                    melonChartArtistFragment0.mFilterList.add(j0);
                }
                j0 j01 = melonChartArtistFragment0.mAdapter;
                q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter");
                ((ArtistAdapter)j01).updateHeaderLayout(true);
            }
            melonChartArtistFragment0.mMelonTiaraProperty = new s(artistChartListRes0.response.section, artistChartListRes0.response.page, "", null);
        }
        melonChartArtistFragment0.performFetchComplete(i0, artistChartListRes0);
    }

    private static final void onFetchStart$lambda$4(MelonChartArtistFragment melonChartArtistFragment0, VolleyError volleyError0) {
        melonChartArtistFragment0.performFetchError(volleyError0);
        j0 j00 = melonChartArtistFragment0.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartArtistFragment.ArtistAdapter");
        ((ArtistAdapter)j00).updateHeaderLayout(false);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onReadyToFetchPartially(@NotNull RecyclerView recyclerView0, @NotNull int[] arr_v) {
        q.g(recyclerView0, "recyclerView");
        q.g(arr_v, "positions");
        if(this.isLoginUser()) {
            j0 j00 = recyclerView0.getAdapter();
            if(j00 instanceof ArtistAdapter) {
                ArrayList arrayList0 = new ArrayList();
                int v = arr_v[0];
                if(v > 0) {
                    arrayList0.add(((int)(v - 1)));
                }
                arrayList0.addAll(n.y0(arr_v));
                StringBuilder stringBuilder0 = new StringBuilder();
                Iterator iterator0 = arrayList0.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    q.f(object0, "next(...)");
                    int v1 = ((Number)object0).intValue();
                    try {
                        stringBuilder0.append(((CHARTLIST)((ArtistAdapter)j00).getItem(v1)).artistId);
                        stringBuilder0.append(",");
                    }
                    catch(Exception unused_ex) {
                    }
                }
                int v2 = stringBuilder0.length();
                if(v2 != 0) {
                    stringBuilder0.setLength(v2 - 1);
                    com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0 = new com.iloen.melon.net.v4x.request.UserActionsReq.Params();
                    userActionsReq$Params0.fields = "fan";
                    userActionsReq$Params0.contsTypeCode = "N10006";
                    userActionsReq$Params0.contsId = stringBuilder0.toString();
                    RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.melonchart.p(this, arrayList0, j00, 1)).errorListener(new a(21)).request();
                }
            }
        }
    }

    private static final void onReadyToFetchPartially$lambda$7(MelonChartArtistFragment melonChartArtistFragment0, ArrayList arrayList0, j0 j00, UserActionsRes userActionsRes0) {
        if(melonChartArtistFragment0.isFragmentValid() && userActionsRes0.isSuccessful() && userActionsRes0.response != null) {
            Object object0 = arrayList0.get(0);
            q.f(object0, "get(...)");
            int v = ((Number)object0).intValue();
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                q.f(object1, "next(...)");
                int v1 = ((Number)object1).intValue();
                try {
                    CHARTLIST artistChartListRes$RESPONSE$CHARTLIST0 = (CHARTLIST)((ArtistAdapter)j00).getItem(v1);
                    artistChartListRes$RESPONSE$CHARTLIST0.isFan = ((RelationList)userActionsRes0.response.relationList.get(v1 - v)).fields.fan;
                }
                catch(Exception unused_ex) {
                }
            }
            ((ArtistAdapter)j00).notifyDataSetChanged();
        }
    }

    private static final void onReadyToFetchPartially$lambda$8(VolleyError volleyError0) {
        com.iloen.melon.utils.a.v("error : ", volleyError0.getMessage(), LogU.Companion, "MelonChartArtistFragment");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.mCurrentFilterIndex = bundle0.getInt("argFilterIndex");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argFilterIndex", this.mCurrentFilterIndex);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
    }

    public static void t0(MelonChartArtistFragment melonChartArtistFragment0, v9.i i0, ArtistChartListRes artistChartListRes0) {
        MelonChartArtistFragment.onFetchStart$lambda$3(melonChartArtistFragment0, i0, artistChartListRes0);
    }

    public static void u0(VolleyError volleyError0) {
        MelonChartArtistFragment.onReadyToFetchPartially$lambda$8(volleyError0);
    }
}

