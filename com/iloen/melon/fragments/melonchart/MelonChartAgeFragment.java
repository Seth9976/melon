package com.iloen.melon.fragments.melonchart;

import B9.b;
import B9.c;
import Tf.v;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.analytics.ClickLog;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.NewChartFilterLayout;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.AgeSongChartListReq.Params;
import com.iloen.melon.net.v4x.request.AgeSongChartListReq;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.CHARTLIST;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.REVIEW;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.YEARLIST.SUBLIST;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.YEARLIST;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.kakao.tiara.data.ActionKind;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.i;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 `2\u00020\u0001:\u0002`aB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010%J\u001B\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0017\u00100\u001A\u00020\f2\u0006\u0010/\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b0\u00101J\u0017\u00103\u001A\u00020\f2\u0006\u00102\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b3\u00101J\u001F\u00106\u001A\u00020\f2\u0006\u00104\u001A\u00020\u00072\u0006\u00105\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b6\u00107J\u0017\u00108\u001A\u00020\f2\u0006\u00102\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b8\u00101J\u0017\u0010;\u001A\u00020\f2\u0006\u0010:\u001A\u000209H\u0002\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010>\u001A\u00020\u00072\u0006\u0010=\u001A\u00020#H\u0002\u00A2\u0006\u0004\b>\u0010?R\u0018\u0010@\u001A\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001A\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010DR\u0016\u0010F\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010DRR\u0010L\u001A>\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`J0Gj\u001E\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`J`K8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR&\u0010N\u001A\u0012\u0012\u0004\u0012\u00020\u00070Hj\b\u0012\u0004\u0012\u00020\u0007`J8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bP\u0010DR\u0016\u0010R\u001A\u00020Q8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001A\u00020\u00158\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001A\u00020V8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bY\u0010UR\u0018\u0010Z\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010UR&\u0010[\u001A\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`J8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b[\u0010OR\u0014\u0010]\u001A\u00020\u00078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\\\u0010\tR\u0014\u0010_\u001A\u00020\u00078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b^\u0010\t\u00A8\u0006b"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartAgeFragment;", "Lcom/iloen/melon/fragments/melonchart/MelonChartBaseFragment;", "<init>", "()V", "", "isGenreExclude", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "show", "updateToolBar", "(Z)V", "isVisible", "setAllCheckButtonVisibility", "actionTypeCode", "actionLayer2", "playLog", "(Ljava/lang/String;Ljava/lang/String;)V", "updateHeaderLayout", "Lcom/iloen/melon/net/v4x/response/AgeSongChartListRes$RESPONSE;", "res", "processData", "(Lcom/iloen/melon/net/v4x/response/AgeSongChartListRes$RESPONSE;)V", "sortIndex", "getClickAreaCode", "(I)Ljava/lang/String;", "mAgeType", "Ljava/lang/String;", "mAgeYear", "mCurrentSortIndex", "I", "mCurrent1DepthFilterIndex", "mCurrent2DepthFilterIndex", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "mFilterMap", "Ljava/util/LinkedHashMap;", "mYearList", "Ljava/util/ArrayList;", "mFooterCount", "Lcom/iloen/melon/custom/NewChartFilterLayout;", "mFilterLayout", "Lcom/iloen/melon/custom/NewChartFilterLayout;", "headerContainer", "Landroid/view/View;", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "scrollableAlyacFilter", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "playShuffleButton", "playAllButton", "alaycFilterData", "getFilterName", "filterName", "getFilterYearText", "filterYearText", "Companion", "AgeAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartAgeFragment extends MelonChartBaseFragment {
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u0012\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ!\u0010 \u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\nH\u0016¢\u0006\u0004\b \u0010!J\'\u0010$\u001A\u00020#2\u0006\u0010\"\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010\'R\u0018\u0010*\u001A\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartAgeFragment$AgeAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartAgeFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getFooterViewItemCount", "()I", "position", "", "key", "", "marked", "setMarked", "(ILjava/lang/String;Z)Z", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "rawPosition", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "VIEW_TYPE_FOOTER", "Lcom/iloen/melon/net/v4x/response/AgeSongChartListRes$RESPONSE$REVIEW;", "mReview", "Lcom/iloen/melon/net/v4x/response/AgeSongChartListRes$RESPONSE$REVIEW;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class AgeAdapter extends p {
        private final int VIEW_TYPE_FOOTER;
        private final int VIEW_TYPE_SONG;
        @Nullable
        private REVIEW mReview;

        public AgeAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonChartAgeFragment.this = melonChartAgeFragment0;
            super(context0, list0);
            this.VIEW_TYPE_SONG = 1;
            this.VIEW_TYPE_FOOTER = 12;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getFooterViewItemCount() {
            return MelonChartAgeFragment.this.mFooterCount;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getFooterViewItemCount() <= 0 || v != this.getAvailableFooterPosition() ? this.VIEW_TYPE_SONG : this.VIEW_TYPE_FOOTER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            if(httpResponse0 instanceof AgeSongChartListRes) {
                RESPONSE ageSongChartListRes$RESPONSE0 = ((AgeSongChartListRes)httpResponse0).response;
                if(ageSongChartListRes$RESPONSE0 != null) {
                    int v = 0;
                    this.setHasMore(false);
                    this.setMenuId(ageSongChartListRes$RESPONSE0.menuId);
                    this.updateModifiedTime(this.getCacheKey());
                    ArrayList arrayList0 = ageSongChartListRes$RESPONSE0.chartList;
                    Integer integer0 = arrayList0 == null ? null : arrayList0.size();
                    if(integer0 != null && ((int)integer0) > 0) {
                        this.addAll(arrayList0);
                    }
                    this.mReview = ageSongChartListRes$RESPONSE0.review;
                    MelonChartAgeFragment melonChartAgeFragment0 = MelonChartAgeFragment.this;
                    if(ageSongChartListRes$RESPONSE0.review != null) {
                        v = 1;
                    }
                    melonChartAgeFragment0.mFooterCount = v;
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_SONG) {
                SongHolder songHolder0 = (SongHolder)o00;
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.AgeSongChartListRes.RESPONSE.CHARTLIST");
                boolean z = ((CHARTLIST)object0).canService;
                ViewUtils.setEnable(songHolder0.wrapperLayout, z);
                if(z) {
                    f f0 = new f(MelonChartAgeFragment.this, v, this, v1, ((CHARTLIST)object0), 0);
                    ViewUtils.setOnClickListener(songHolder0.itemView, f0);
                    if(this.isMarked(v1)) {
                        int v3 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                        songHolder0.itemView.setBackgroundColor(v3);
                    }
                    else {
                        int v4 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                        songHolder0.itemView.setBackgroundColor(v4);
                    }
                }
                else {
                    ViewUtils.setOnClickListener(songHolder0.itemView, null);
                    int v5 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    songHolder0.itemView.setBackgroundColor(v5);
                }
                g g0 = new g(MelonChartAgeFragment.this, ((CHARTLIST)object0), this, v1, 0);
                ViewUtils.setOnLongClickListener(songHolder0.itemView, g0);
                Glide.with(this.getContext()).load(((CHARTLIST)object0).albumImg).into(songHolder0.thumbnailIv);
                ViewUtils.showWhen(songHolder0.btnPlay, z);
                ViewUtils.setOnClickListener(songHolder0.btnPlay, new h(MelonChartAgeFragment.this, ((CHARTLIST)object0), this, v1, 0));
                ViewUtils.showWhen(songHolder0.btnInfo, true);
                ViewUtils.setOnClickListener(songHolder0.btnInfo, new h(MelonChartAgeFragment.this, ((CHARTLIST)object0), this, v1, 1));
                ViewUtils.setOnClickListener(songHolder0.thumbContainer, new com.iloen.melon.fragments.melonchart.i(MelonChartAgeFragment.this, ((CHARTLIST)object0), v1, 0));
                ViewUtils.setTextViewMarquee(songHolder0.titleTv, this.isMarqueeNeeded(v1));
                songHolder0.titleTv.setText(((CHARTLIST)object0).songName);
                songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(((CHARTLIST)object0).artistList));
                ViewUtils.showWhen(songHolder0.list19Iv, ((CHARTLIST)object0).isAdult);
                ViewUtils.showWhen(songHolder0.listFreeIv, ((CHARTLIST)object0).isFree);
                ViewUtils.showWhen(songHolder0.listHoldbackIv, ((CHARTLIST)object0).isHoldback);
                songHolder0.updownLayout.setVisibility(0);
                songHolder0.rankGapTv.setVisibility(8);
                songHolder0.rankTv.setText(((CHARTLIST)object0).currentRank);
                return;
            }
            if(v2 == this.VIEW_TYPE_FOOTER) {
                ViewUtils.setOnClickListener(((b)o00).a, new j(this, 0));
            }
        }

        private static final void onBindViewImpl$lambda$0(MelonChartAgeFragment melonChartAgeFragment0, int v, AgeAdapter melonChartAgeFragment$AgeAdapter0, int v1, CHARTLIST ageSongChartListRes$RESPONSE$CHARTLIST0, View view0) {
            melonChartAgeFragment0.onItemClick(view0, v);
            if(melonChartAgeFragment$AgeAdapter0.isMarked(v1)) {
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartAgeFragment0.mMenuId;
                g0.a = "선택";
                s s0 = melonChartAgeFragment0.mMelonTiaraProperty;
                String s1 = null;
                g0.b = s0 == null ? null : s0.a;
                s s2 = melonChartAgeFragment0.mMelonTiaraProperty;
                if(s2 != null) {
                    s1 = s2.b;
                }
                g0.c = s1;
                g0.d = ActionKind.ClickContent;
                g0.y = "곡리스트";
                g0.z = melonChartAgeFragment0.getFilterName();
                g0.A = melonChartAgeFragment0.getFilterYearText();
                g0.F = "곡선택";
                g0.C = String.valueOf(v1 + 1);
                g0.E = ageSongChartListRes$RESPONSE$CHARTLIST0.albumImg;
                g0.e = ageSongChartListRes$RESPONSE$CHARTLIST0.songId;
                g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                g0.g = ageSongChartListRes$RESPONSE$CHARTLIST0.songName;
                g0.h = ageSongChartListRes$RESPONSE$CHARTLIST0.getArtistNames();
                g0.a().track();
            }
        }

        private static final boolean onBindViewImpl$lambda$1(MelonChartAgeFragment melonChartAgeFragment0, CHARTLIST ageSongChartListRes$RESPONSE$CHARTLIST0, AgeAdapter melonChartAgeFragment$AgeAdapter0, int v, View view0) {
            String s = null;
            melonChartAgeFragment0.showContextPopupSongOrInstantPlay(Playable.from(ageSongChartListRes$RESPONSE$CHARTLIST0, melonChartAgeFragment$AgeAdapter0.getMenuId(), null));
            d5.s s1 = d3.g.K(melonChartAgeFragment0.mMenuId, "R21", "V9");
            s1.f = melonChartAgeFragment0.getClickAreaCode(melonChartAgeFragment0.mCurrentSortIndex);
            new ClickLog(s1).a();
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartAgeFragment0.mMenuId;
            g0.a = "페이지이동";
            s s2 = melonChartAgeFragment0.mMelonTiaraProperty;
            g0.b = s2 == null ? null : s2.a;
            s s3 = melonChartAgeFragment0.mMelonTiaraProperty;
            if(s3 != null) {
                s = s3.b;
            }
            g0.c = s;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.z = melonChartAgeFragment0.getFilterName();
            g0.A = melonChartAgeFragment0.getFilterYearText();
            g0.F = "더보기";
            g0.C = String.valueOf(v + 1);
            g0.E = ageSongChartListRes$RESPONSE$CHARTLIST0.albumImg;
            g0.e = ageSongChartListRes$RESPONSE$CHARTLIST0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = ageSongChartListRes$RESPONSE$CHARTLIST0.songName;
            g0.h = ageSongChartListRes$RESPONSE$CHARTLIST0.getArtistNames();
            g0.a().track();
            return true;
        }

        private static final void onBindViewImpl$lambda$2(MelonChartAgeFragment melonChartAgeFragment0, CHARTLIST ageSongChartListRes$RESPONSE$CHARTLIST0, AgeAdapter melonChartAgeFragment$AgeAdapter0, int v, View view0) {
            String s = null;
            melonChartAgeFragment0.playSong(Playable.from(ageSongChartListRes$RESPONSE$CHARTLIST0, melonChartAgeFragment$AgeAdapter0.getMenuId(), null), true);
            d5.s s1 = d3.g.K(melonChartAgeFragment0.mMenuId, "R21", "P1");
            s1.f = melonChartAgeFragment0.getClickAreaCode(melonChartAgeFragment0.mCurrentSortIndex);
            new ClickLog(s1).a();
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartAgeFragment0.mMenuId;
            g0.a = "음악재생";
            s s2 = melonChartAgeFragment0.mMelonTiaraProperty;
            g0.b = s2 == null ? null : s2.a;
            s s3 = melonChartAgeFragment0.mMelonTiaraProperty;
            if(s3 != null) {
                s = s3.b;
            }
            g0.c = s;
            g0.d = ActionKind.PlayMusic;
            g0.y = "곡리스트";
            g0.z = melonChartAgeFragment0.getFilterName();
            g0.A = melonChartAgeFragment0.getFilterYearText();
            g0.F = "음악재생";
            g0.C = String.valueOf(v + 1);
            g0.E = ageSongChartListRes$RESPONSE$CHARTLIST0.albumImg;
            g0.e = ageSongChartListRes$RESPONSE$CHARTLIST0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = ageSongChartListRes$RESPONSE$CHARTLIST0.songName;
            g0.h = ageSongChartListRes$RESPONSE$CHARTLIST0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$3(MelonChartAgeFragment melonChartAgeFragment0, CHARTLIST ageSongChartListRes$RESPONSE$CHARTLIST0, AgeAdapter melonChartAgeFragment$AgeAdapter0, int v, View view0) {
            String s = null;
            melonChartAgeFragment0.showContextPopupSong(Playable.from(ageSongChartListRes$RESPONSE$CHARTLIST0, melonChartAgeFragment$AgeAdapter0.getMenuId(), null));
            d5.s s1 = d3.g.K(melonChartAgeFragment0.mMenuId, "R21", "V9");
            s1.f = melonChartAgeFragment0.getClickAreaCode(melonChartAgeFragment0.mCurrentSortIndex);
            new ClickLog(s1).a();
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartAgeFragment0.mMenuId;
            g0.a = "페이지이동";
            s s2 = melonChartAgeFragment0.mMelonTiaraProperty;
            g0.b = s2 == null ? null : s2.a;
            s s3 = melonChartAgeFragment0.mMelonTiaraProperty;
            if(s3 != null) {
                s = s3.b;
            }
            g0.c = s;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.z = melonChartAgeFragment0.getFilterName();
            g0.A = melonChartAgeFragment0.getFilterYearText();
            g0.F = "더보기";
            g0.C = String.valueOf(v + 1);
            g0.E = ageSongChartListRes$RESPONSE$CHARTLIST0.albumImg;
            g0.e = ageSongChartListRes$RESPONSE$CHARTLIST0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = ageSongChartListRes$RESPONSE$CHARTLIST0.songName;
            g0.h = ageSongChartListRes$RESPONSE$CHARTLIST0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$4(MelonChartAgeFragment melonChartAgeFragment0, CHARTLIST ageSongChartListRes$RESPONSE$CHARTLIST0, int v, View view0) {
            melonChartAgeFragment0.showAlbumInfoPage(ageSongChartListRes$RESPONSE$CHARTLIST0);
            d5.s s0 = d3.g.K(melonChartAgeFragment0.mMenuId, "R21", "V1");
            s0.f = melonChartAgeFragment0.getClickAreaCode(melonChartAgeFragment0.mCurrentSortIndex);
            ContsTypeCode contsTypeCode0 = ContsTypeCode.ALBUM;
            s0.j = "N10002";
            s0.k = ageSongChartListRes$RESPONSE$CHARTLIST0.albumId;
            new ClickLog(s0).a();
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartAgeFragment0.mMenuId;
            g0.a = "페이지이동";
            s s1 = melonChartAgeFragment0.mMelonTiaraProperty;
            String s2 = null;
            g0.b = s1 == null ? null : s1.a;
            s s3 = melonChartAgeFragment0.mMelonTiaraProperty;
            if(s3 != null) {
                s2 = s3.b;
            }
            g0.c = s2;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.z = melonChartAgeFragment0.getFilterName();
            g0.A = melonChartAgeFragment0.getFilterYearText();
            g0.F = "앨범페이지이동";
            g0.C = String.valueOf(v + 1);
            g0.E = ageSongChartListRes$RESPONSE$CHARTLIST0.albumImg;
            g0.e = ageSongChartListRes$RESPONSE$CHARTLIST0.albumId;
            g0.f = Y.i(contsTypeCode0, "code(...)");
            g0.g = ageSongChartListRes$RESPONSE$CHARTLIST0.albumName;
            g0.h = ageSongChartListRes$RESPONSE$CHARTLIST0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$5(AgeAdapter melonChartAgeFragment$AgeAdapter0, View view0) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            REVIEW ageSongChartListRes$RESPONSE$REVIEW0 = melonChartAgeFragment$AgeAdapter0.mReview;
            String s = null;
            melonLinkInfo0.a = ageSongChartListRes$RESPONSE$REVIEW0 == null ? null : ageSongChartListRes$RESPONSE$REVIEW0.reviewOpenType;
            if(ageSongChartListRes$RESPONSE$REVIEW0 != null) {
                s = ageSongChartListRes$RESPONSE$REVIEW0.reviewUrl;
            }
            melonLinkInfo0.b = s;
            MelonLinkExecutor.open(melonLinkInfo0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_SONG) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false);  // layout:listitem_song
                q.f(view0, "inflate(...)");
                return new c(view0);
            }
            if(v == this.VIEW_TYPE_FOOTER) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04E6, viewGroup0, false);  // layout:melonchart_artist_all_review_listitem
                O0 o00 = new b(view1);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
                o00.a = view1.findViewById(0x7F0A024B);  // id:chart_layout
                ((TextView)view1.findViewById(0x7F0A024D)).setText(0x7F1305BA);  // id:chart_tv
                return o00;
            }
            return null;
        }

        @Override  // com.iloen.melon.adapters.common.q
        public boolean setMarked(int v, @NotNull String s, boolean z) {
            q.g(s, "key");
            return this.getItem(v) instanceof REVIEW ? false : super.setMarked(v, s, z);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\fH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartAgeFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_AGE_TYPE", "ARG_AGE_YEAR", "ARG_AGE_SORT", "AGE_TYPE_AG", "AGE_TYPE_YG", "SORT_DOMESTIC", "", "SORT_OVERSEAS", "newInstance", "Lcom/iloen/melon/fragments/melonchart/MelonChartAgeFragment;", "ageType", "ageYear", "sortType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonChartAgeFragment newInstance(@NotNull String s, @NotNull String s1, int v) {
            q.g(s, "ageType");
            q.g(s1, "ageYear");
            MelonChartAgeFragment melonChartAgeFragment0 = new MelonChartAgeFragment();
            Bundle bundle0 = Y.c("argAgeType", s, "argAgeYear", s1);
            bundle0.putInt("argAgeSort", v);
            melonChartAgeFragment0.setArguments(bundle0);
            return melonChartAgeFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String AGE_TYPE_AG = "AG";
    @NotNull
    private static final String AGE_TYPE_YG = "YE";
    @NotNull
    private static final String ARG_AGE_SORT = "argAgeSort";
    @NotNull
    private static final String ARG_AGE_TYPE = "argAgeType";
    @NotNull
    private static final String ARG_AGE_YEAR = "argAgeYear";
    @NotNull
    public static final Companion Companion = null;
    public static final int SORT_DOMESTIC = 0;
    public static final int SORT_OVERSEAS = 1;
    @NotNull
    private static final String TAG = "MelonChartAgeFragment";
    private ArrayList alaycFilterData;
    private View headerContainer;
    @Nullable
    private String mAgeType;
    @Nullable
    private String mAgeYear;
    private int mCurrent1DepthFilterIndex;
    private int mCurrent2DepthFilterIndex;
    private int mCurrentSortIndex;
    private NewChartFilterLayout mFilterLayout;
    @NotNull
    private LinkedHashMap mFilterMap;
    private int mFooterCount;
    @NotNull
    private ArrayList mYearList;
    @Nullable
    private View playAllButton;
    @Nullable
    private View playShuffleButton;
    private ScrollableAlyacFilter scrollableAlyacFilter;

    static {
        MelonChartAgeFragment.Companion = new Companion(null);
        MelonChartAgeFragment.$stable = 8;
    }

    public MelonChartAgeFragment() {
        this.mFilterMap = new LinkedHashMap();
        this.mYearList = new ArrayList();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0263, null, false);  // layout:filter_chart_age_hottrack
        q.f(view0, "inflate(...)");
        this.headerContainer = view0;
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new AgeAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setMarkedMode(true);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(1);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.q0.buildUpon().appendQueryParameter("sortIndex", String.valueOf(this.mCurrentSortIndex)).appendQueryParameter("filterIndex", String.valueOf(this.mCurrent1DepthFilterIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final String getClickAreaCode(int v) {
        return v == 0 ? "T09" : "T10";
    }

    private final String getFilterName() {
        ArrayList arrayList0 = this.alaycFilterData;
        if(arrayList0 != null) {
            v9.j j0 = (v9.j)je.p.n0(this.mCurrentSortIndex, arrayList0);
            if(j0 != null) {
                return j0.b == null ? "" : j0.b;
            }
            return "";
        }
        return "";
    }

    private final String getFilterYearText() {
        if(!this.mFilterMap.isEmpty() && !this.mYearList.isEmpty()) {
            String s = (String)je.p.n0(this.mCurrent1DepthFilterIndex, this.mYearList);
            ArrayList arrayList0 = (ArrayList)this.mFilterMap.get(s);
            String s1 = null;
            if(arrayList0 != null) {
                Object object0 = null;
                for(Object object1: arrayList0) {
                    if(v.j0(((v9.j)object1).d, this.mAgeType, true) && q.b(((v9.j)object1).c, this.mAgeYear)) {
                        object0 = object1;
                        break;
                    }
                }
                if(((v9.j)object0) != null) {
                    s1 = ((v9.j)object0).b;
                }
            }
            return s1 == null ? "" : s1;
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        if(ScreenUtils.isOrientationPortrait(this.getContext())) {
            View view0 = this.headerContainer;
            if(view0 == null) {
                q.m("headerContainer");
                throw null;
            }
            else if(view0.getVisibility() == 0) {
                Context context0 = this.getContext();
                if(context0 != null) {
                    Resources resources0 = context0.getResources();
                    return resources0 == null ? 0 : resources0.getDimensionPixelSize(0x7F07008C);  // dimen:chart_parallax_header_fixed_height
                }
                return 0;
            }
        }
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        View view0 = this.headerContainer;
        if(view0 != null) {
            return view0.getVisibility() == 0 ? ScreenUtils.dipToPixel(this.getContext(), 168.0f) : 0;
        }
        q.m("headerContainer");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isGenreExclude() {
        return true;
    }

    @NotNull
    public static final MelonChartAgeFragment newInstance(@NotNull String s, @NotNull String s1, int v) {
        return MelonChartAgeFragment.Companion.newInstance(s, s1, v);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
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
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        this.setAllCheckButtonVisibility(false);
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartAgeFragment.AgeAdapter");
        ((AgeAdapter)j00).clear();
        Params ageSongChartListReq$Params0 = new Params();
        ageSongChartListReq$Params0.startIndex = 1;
        ageSongChartListReq$Params0.pageSize = 100;
        ageSongChartListReq$Params0.isRecom = "N";
        ageSongChartListReq$Params0.genre = this.mCurrentSortIndex == 0 ? "KPOP" : "POP";
        ageSongChartListReq$Params0.year = this.mAgeYear;
        ageSongChartListReq$Params0.type = this.mAgeType;
        if(!this.mFilterMap.isEmpty() && !this.mYearList.isEmpty()) {
            String s1 = (String)je.p.n0(this.mCurrent1DepthFilterIndex, this.mYearList);
            if(s1 == null) {
                s1 = "";
            }
            ArrayList arrayList0 = (ArrayList)this.mFilterMap.get(s1);
            if(arrayList0 != null) {
                v9.j j0 = (v9.j)je.p.n0(this.mCurrent2DepthFilterIndex, arrayList0);
                if(j0 != null) {
                    ageSongChartListReq$Params0.year = j0.c;
                    ageSongChartListReq$Params0.type = j0.d;
                }
            }
        }
        RequestBuilder.newInstance(new AgeSongChartListReq(this.getContext(), ageSongChartListReq$Params0)).tag(this.getRequestTag()).listener(new J(this, i0, 1)).errorListener(new com.iloen.melon.fragments.melonchart.c(this)).request();
        return true;
    }

    private static final void onFetchStart$lambda$16(MelonChartAgeFragment melonChartAgeFragment0, i i0, AgeSongChartListRes ageSongChartListRes0) {
        if(!melonChartAgeFragment0.prepareFetchComplete(ageSongChartListRes0)) {
            melonChartAgeFragment0.setAllCheckButtonVisibility(false);
            if(!melonChartAgeFragment0.mFilterMap.isEmpty() && !melonChartAgeFragment0.mYearList.isEmpty()) {
                melonChartAgeFragment0.mCurrent1DepthFilterIndex = 0;
                melonChartAgeFragment0.mCurrent2DepthFilterIndex = 0;
                melonChartAgeFragment0.startFetch("filter initialize");
            }
            return;
        }
        if((ageSongChartListRes0 == null ? null : ageSongChartListRes0.response) != null) {
            RESPONSE ageSongChartListRes$RESPONSE0 = ageSongChartListRes0.response;
            q.d(ageSongChartListRes$RESPONSE0);
            melonChartAgeFragment0.processData(ageSongChartListRes$RESPONSE0);
            Integer integer0 = ageSongChartListRes$RESPONSE0.chartList == null ? null : ageSongChartListRes$RESPONSE0.chartList.size();
            if(integer0 != null && ((int)integer0) > 0) {
                melonChartAgeFragment0.setAllCheckButtonVisibility(true);
                melonChartAgeFragment0.updateHeaderLayout(true);
            }
            melonChartAgeFragment0.mMelonTiaraProperty = new s(ageSongChartListRes0.response.section, ageSongChartListRes0.response.page, "", null);
        }
        melonChartAgeFragment0.performFetchComplete(i0, ageSongChartListRes0);
    }

    private static final void onFetchStart$lambda$17(MelonChartAgeFragment melonChartAgeFragment0, VolleyError volleyError0) {
        melonChartAgeFragment0.performFetchError(volleyError0);
        melonChartAgeFragment0.updateHeaderLayout(false);
        melonChartAgeFragment0.setAllCheckButtonVisibility(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.mAgeType = bundle0.getString("argAgeType");
        this.mAgeYear = bundle0.getString("argAgeYear");
        this.mCurrentSortIndex = bundle0.getInt("argAgeSort");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argAgeType", this.mAgeType);
        bundle0.putString("argAgeYear", this.mAgeYear);
        bundle0.putInt("argAgeSort", this.mCurrentSortIndex);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
        View view1 = view0.findViewById(0x7F0A0A31);  // id:scrollable_alyac_filter
        q.f(view1, "findViewById(...)");
        this.scrollableAlyacFilter = (ScrollableAlyacFilter)view1;
        v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.b = this.getString(0x7F1305D6);  // string:melon_chart_domestic "국내"
        j0.c = "0";
        v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j1.b = this.getString(0x7F1305EC);  // string:melon_chart_overseas "해외"
        j1.c = "1";
        ArrayList arrayList0 = k.e(new v9.j[]{j0, j1});
        this.alaycFilterData = arrayList0;
        ((ScrollableAlyacFilter)view1).d(arrayList0);
        ((ScrollableAlyacFilter)view1).setSelectedIndex(this.mCurrentSortIndex);
        ((ScrollableAlyacFilter)view1).setPadding(ScreenUtils.dipToPixel(this.getContext(), 20.0f));
        ((ScrollableAlyacFilter)view1).e(new com.iloen.melon.fragments.melonchart.c(this), new E8.c());  // 初始化器: Ljava/lang/Object;-><init>()V
        View view2 = view0.findViewById(0x7F0A01BB);  // id:btn_shuffle
        this.playShuffleButton = view2;
        if(view2 != null) {
            view2.setOnClickListener(new d(this, 0));
        }
        View view3 = view0.findViewById(0x7F0A0183);  // id:btn_play_all
        this.playAllButton = view3;
        if(view3 != null) {
            view3.setOnClickListener(new d(this, 1));
        }
        View view4 = view0.findViewById(0x7F0A0248);  // id:chart_filter_layout
        q.f(view4, "findViewById(...)");
        this.mFilterLayout = (NewChartFilterLayout)view4;
        ((NewChartFilterLayout)view4).setOnDropDownListener(new e(this, 0));
        NewChartFilterLayout newChartFilterLayout0 = this.mFilterLayout;
        if(newChartFilterLayout0 != null) {
            newChartFilterLayout0.setDropDownText(this.getFilterYearText());
            this.setAllCheckButtonVisibility(this.getItemCount() > 0);
            return;
        }
        q.m("mFilterLayout");
        throw null;
    }

    private static final H onViewCreated$lambda$11(MelonChartAgeFragment melonChartAgeFragment0, View view0) {
        q.g(view0, "it");
        if(!melonChartAgeFragment0.mFilterMap.isEmpty() && !melonChartAgeFragment0.mYearList.isEmpty() && !melonChartAgeFragment0.isRetainedPopupShowing()) {
            com.iloen.melon.popup.CommonFilterPopup.Companion commonFilterPopup$Companion0 = CommonFilterPopup.Companion;
            ArrayList arrayList0 = melonChartAgeFragment0.mYearList;
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object0: arrayList0) {
                v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                j0.b = (String)object0;
                j0.e = (List)melonChartAgeFragment0.mFilterMap.get(((String)object0));
                arrayList1.add(j0);
            }
            CommonFilterPopup commonFilterPopup0 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(commonFilterPopup$Companion0, 0x7F1307D1, "LIST_TYPE_DEPTH_TWO_HORIZONTAL", je.p.P0(arrayList1), melonChartAgeFragment0.mCurrent1DepthFilterIndex, melonChartAgeFragment0.mCurrent2DepthFilterIndex, 0, new com.iloen.melon.fragments.melonchart.b(melonChartAgeFragment0, 0), 0x20, null);  // string:order_by "정렬"
            FragmentActivity fragmentActivity0 = melonChartAgeFragment0.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    commonFilterPopup0.setDismissFragment(melonChartAgeFragment0);
                    commonFilterPopup0.show(l00, "ComposeBottomSheet");
                }
            }
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartAgeFragment0.mMenuId;
            g0.a = "페이지이동";
            s s0 = melonChartAgeFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            if(s0 != null) {
                s1 = s0.b;
            }
            g0.c = s1;
            g0.y = "곡리스트";
            g0.z = melonChartAgeFragment0.getFilterName();
            g0.A = melonChartAgeFragment0.getFilterYearText();
            g0.F = "연도선택";
            g0.a().track();
        }
        return H.a;
    }

    private static final H onViewCreated$lambda$11$lambda$9(MelonChartAgeFragment melonChartAgeFragment0, int v, int v1, int v2) {
        LogU.Companion.d("MelonChartAgeFragment", "onFilterSelectionListener oneDepthIndex" + v + ", twoDepthIndex:" + v1);
        H h0 = H.a;
        if(v == melonChartAgeFragment0.mCurrent1DepthFilterIndex && v1 == melonChartAgeFragment0.mCurrent2DepthFilterIndex) {
            return h0;
        }
        String s = melonChartAgeFragment0.getFilterYearText();
        melonChartAgeFragment0.mCurrent1DepthFilterIndex = v;
        melonChartAgeFragment0.mCurrent2DepthFilterIndex = v1;
        ArrayList arrayList0 = (ArrayList)melonChartAgeFragment0.mFilterMap.get(je.p.n0(v, melonChartAgeFragment0.mYearList));
        if(arrayList0 != null) {
            v9.j j0 = (v9.j)je.p.n0(melonChartAgeFragment0.mCurrent2DepthFilterIndex, arrayList0);
            if(j0 != null) {
                melonChartAgeFragment0.mAgeType = j0.d;
                melonChartAgeFragment0.mAgeYear = j0.c;
            }
        }
        String s1 = melonChartAgeFragment0.getFilterYearText();
        NewChartFilterLayout newChartFilterLayout0 = melonChartAgeFragment0.mFilterLayout;
        String s2 = null;
        if(newChartFilterLayout0 != null) {
            newChartFilterLayout0.setDropDownText(s1);
            melonChartAgeFragment0.startFetch("filter change");
            d5.s s3 = d3.g.K(melonChartAgeFragment0.mMenuId, "R21", "V23");
            s3.f = melonChartAgeFragment0.getClickAreaCode(melonChartAgeFragment0.mCurrentSortIndex);
            new ClickLog(s3).a();
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartAgeFragment0.mMenuId;
            g0.a = "페이지이동";
            s s4 = melonChartAgeFragment0.mMelonTiaraProperty;
            g0.b = s4 == null ? null : s4.a;
            if(s4 != null) {
                s2 = s4.b;
            }
            g0.c = s2;
            g0.y = "곡리스트";
            g0.z = melonChartAgeFragment0.getFilterName();
            g0.A = s;
            g0.F = s1;
            g0.a().track();
            return h0;
        }
        q.m("mFilterLayout");
        throw null;
    }

    private static final void onViewCreated$lambda$3$lambda$2(MelonChartAgeFragment melonChartAgeFragment0, int v) {
        if(melonChartAgeFragment0.mCurrentSortIndex == v) {
            return;
        }
        melonChartAgeFragment0.mCurrentSortIndex = v;
        melonChartAgeFragment0.startFetch("sortbar change");
        d5.s s0 = d3.g.K(melonChartAgeFragment0.mMenuId, "R21", "V1");
        s0.f = melonChartAgeFragment0.getClickAreaCode(melonChartAgeFragment0.mCurrentSortIndex);
        new ClickLog(s0).a();
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = melonChartAgeFragment0.mMenuId;
        g0.a = "페이지이동";
        s s1 = melonChartAgeFragment0.mMelonTiaraProperty;
        String s2 = null;
        g0.b = s1 == null ? null : s1.a;
        if(s1 != null) {
            s2 = s1.b;
        }
        g0.c = s2;
        g0.y = "Pagemenu";
        g0.F = melonChartAgeFragment0.getFilterName();
        g0.a().track();
    }

    private static final void onViewCreated$lambda$4(MelonChartAgeFragment melonChartAgeFragment0, View view0) {
        melonChartAgeFragment0.checkAndShowBanPopup();
        melonChartAgeFragment0.playShuffleAll();
        String s = melonChartAgeFragment0.getString(0x7F130E33);  // string:tiara_common_layer2_play_shuffle "셔플재생"
        q.f(s, "getString(...)");
        melonChartAgeFragment0.playLog("P13", s);
    }

    private static final void onViewCreated$lambda$5(MelonChartAgeFragment melonChartAgeFragment0, View view0) {
        melonChartAgeFragment0.checkAndShowBanPopup();
        melonChartAgeFragment0.playAll();
        String s = melonChartAgeFragment0.getString(0x7F130E31);  // string:tiara_common_layer2_play_all "전체재생"
        q.f(s, "getString(...)");
        melonChartAgeFragment0.playLog("P2", s);
    }

    private final void playLog(String s, String s1) {
        d5.s s2 = d3.g.K(this.mMenuId, "R21", s);
        s2.f = this.getClickAreaCode(this.mCurrentSortIndex);
        new ClickLog(s2).a();
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = this.mMenuId;
        g0.a = "음악재생";
        s s3 = this.mMelonTiaraProperty;
        String s4 = null;
        g0.b = s3 == null ? null : s3.a;
        if(s3 != null) {
            s4 = s3.b;
        }
        g0.c = s4;
        g0.y = "곡리스트";
        g0.z = this.getFilterName();
        g0.A = this.getFilterYearText();
        g0.F = s1;
        g0.a().track();
    }

    private final void processData(RESPONSE ageSongChartListRes$RESPONSE0) {
        String s;
        if(!this.mFilterMap.isEmpty() && !this.mYearList.isEmpty()) {
            this.mFilterMap.clear();
            this.mYearList.clear();
        }
        ArrayList arrayList0 = ageSongChartListRes$RESPONSE0.yearlist;
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            if(this.mAgeYear == null || this.mAgeYear.length() == 0 || (this.mAgeType == null || this.mAgeType.length() == 0)) {
                this.mAgeType = "YE";
                YEARLIST ageSongChartListRes$RESPONSE$YEARLIST0 = (YEARLIST)je.p.m0(arrayList0);
                if(ageSongChartListRes$RESPONSE$YEARLIST0 == null) {
                    s = null;
                }
                else {
                    ArrayList arrayList1 = ageSongChartListRes$RESPONSE$YEARLIST0.subList;
                    if(arrayList1 == null) {
                        s = null;
                    }
                    else {
                        SUBLIST ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST0 = (SUBLIST)je.p.m0(arrayList1);
                        s = ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST0 == null ? null : ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST0.year;
                    }
                }
                this.mAgeYear = s;
            }
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                YEARLIST ageSongChartListRes$RESPONSE$YEARLIST1 = (YEARLIST)arrayList0.get(v1);
                String s1 = ageSongChartListRes$RESPONSE$YEARLIST1.name;
                this.mYearList.add(s1);
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = ageSongChartListRes$RESPONSE$YEARLIST1.subList;
                if(arrayList3 != null && !arrayList3.isEmpty()) {
                    int v2 = arrayList3.size();
                    for(int v3 = 0; v3 < v2; ++v3) {
                        SUBLIST ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST1 = (SUBLIST)arrayList3.get(v3);
                        v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j0.b = ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST1.name;
                        j0.c = ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST1.year;
                        j0.d = ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST1.type;
                        arrayList2.add(j0);
                        if(q.b(this.mAgeYear, ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST1.year) && q.b(this.mAgeType, ageSongChartListRes$RESPONSE$YEARLIST$SUBLIST1.type)) {
                            this.mCurrent1DepthFilterIndex = v1;
                            this.mCurrent2DepthFilterIndex = v3;
                        }
                    }
                }
                this.mFilterMap.put(s1, arrayList2);
            }
            NewChartFilterLayout newChartFilterLayout0 = this.mFilterLayout;
            if(newChartFilterLayout0 != null) {
                newChartFilterLayout0.setDropDownText(this.getFilterYearText());
                return;
            }
            q.m("mFilterLayout");
            throw null;
        }
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(z) {
            View view0 = this.playShuffleButton;
            if(view0 != null) {
                view0.setVisibility(0);
            }
            View view1 = this.playAllButton;
            if(view1 != null) {
                view1.setVisibility(0);
            }
            NewChartFilterLayout newChartFilterLayout0 = this.mFilterLayout;
            if(newChartFilterLayout0 != null) {
                newChartFilterLayout0.setOnCheckedListener(new com.iloen.melon.fragments.melonchart.c(this));
                NewChartFilterLayout newChartFilterLayout1 = this.mFilterLayout;
                if(newChartFilterLayout1 != null) {
                    newChartFilterLayout1.e(true);
                    return;
                }
                q.m("mFilterLayout");
                throw null;
            }
            q.m("mFilterLayout");
            throw null;
        }
        View view2 = this.playShuffleButton;
        if(view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.playAllButton;
        if(view3 != null) {
            view3.setVisibility(4);
        }
        NewChartFilterLayout newChartFilterLayout2 = this.mFilterLayout;
        if(newChartFilterLayout2 != null) {
            newChartFilterLayout2.setOnCheckedListener(null);
            NewChartFilterLayout newChartFilterLayout3 = this.mFilterLayout;
            if(newChartFilterLayout3 != null) {
                newChartFilterLayout3.setLeftButton(null);
                NewChartFilterLayout newChartFilterLayout4 = this.mFilterLayout;
                if(newChartFilterLayout4 != null) {
                    newChartFilterLayout4.e(false);
                    return;
                }
                q.m("mFilterLayout");
                throw null;
            }
            q.m("mFilterLayout");
            throw null;
        }
        q.m("mFilterLayout");
        throw null;
    }

    private static final void setAllCheckButtonVisibility$lambda$12(MelonChartAgeFragment melonChartAgeFragment0, S s0, boolean z) {
        melonChartAgeFragment0.toggleSelectAll();
        d5.s s1 = d3.g.K(melonChartAgeFragment0.mMenuId, "R21", (melonChartAgeFragment0.mMarkedAll ? "C1" : "C2"));
        s1.f = melonChartAgeFragment0.getClickAreaCode(melonChartAgeFragment0.mCurrentSortIndex);
        a.t(s1);
        if(melonChartAgeFragment0.mMarkedAll) {
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartAgeFragment0.mMenuId;
            g0.a = "선택";
            s s2 = melonChartAgeFragment0.mMelonTiaraProperty;
            String s3 = null;
            g0.b = s2 == null ? null : s2.a;
            if(s2 != null) {
                s3 = s2.b;
            }
            g0.c = s3;
            g0.y = "곡리스트";
            g0.z = melonChartAgeFragment0.getFilterName();
            g0.A = melonChartAgeFragment0.getFilterYearText();
            g0.F = "전체선택";
            g0.a().track();
        }
    }

    public static void u0(MelonChartAgeFragment melonChartAgeFragment0, i i0, AgeSongChartListRes ageSongChartListRes0) {
        MelonChartAgeFragment.onFetchStart$lambda$16(melonChartAgeFragment0, i0, ageSongChartListRes0);
    }

    private final void updateHeaderLayout(boolean z) {
        int v = 0;
        View view0 = this.headerContainer;
        if(view0 != null) {
            if(view0.getVisibility() == 0 != z) {
                View view1 = this.headerContainer;
                if(view1 != null) {
                    if(!z) {
                        v = 8;
                    }
                    view1.setVisibility(v);
                    this.onUpdateParallaxHeader();
                    return;
                }
                q.m("headerContainer");
                throw null;
            }
            return;
        }
        q.m("headerContainer");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateToolBar(boolean z) {
        super.updateToolBar(z);
        if(z && !this.isToolBarShowing() && this.getMarkedItemCount() == 1) {
            d5.s s0 = d3.g.K(this.mMenuId, "R21", "V20");
            s0.f = this.getClickAreaCode(this.mCurrentSortIndex);
            a.t(s0);
        }
    }
}

