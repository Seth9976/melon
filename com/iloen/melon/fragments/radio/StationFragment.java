package com.iloen.melon.fragments.radio;

import F8.m;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.session.H0;
import androidx.recyclerview.widget.D0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import androidx.viewpager.widget.j;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.ProgramDetailFragment;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UserActionsReq.Params;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v5x.request.StationHomeReq;
import com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE.PROGRAMLIST;
import com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE.TOPOFFERLIST;
import com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE;
import com.iloen.melon.net.v5x.response.StationHomeRes;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.b;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 P2\u00020\u0001:\u0004PQRSB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u000FJ-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ-\u0010#\u001A\u00020\"2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010!\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010+\u001A\u0006\u0012\u0002\b\u00030*2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b+\u0010,J\u001F\u00100\u001A\u00020\t2\u0006\u0010-\u001A\u00020%2\u0006\u0010/\u001A\u00020.H\u0016\u00A2\u0006\u0004\b0\u00101J\u001F\u00104\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\u00172\u0006\u00103\u001A\u000202H\u0002\u00A2\u0006\u0004\b4\u00105J\u0017\u00107\u001A\u00020\t2\u0006\u00106\u001A\u00020\"H\u0002\u00A2\u0006\u0004\b7\u00108R\u0014\u00109\u001A\u00020\u00048\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001A\u00020\u00048\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010<\u001A\u00020\u00048\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010=\u001A\u0002028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001A\u0002028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010@\u001A\u00020\"8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001A\u0002028\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bB\u0010>R\u0014\u0010C\u001A\u0002028\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bC\u0010>R\u0016\u0010D\u001A\u0002028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010>R&\u0010H\u001A\u0012\u0012\u0004\u0012\u00020F0Ej\b\u0012\u0004\u0012\u00020F`G8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010:R\u0016\u0010K\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010:R \u0010N\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010L8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010O\u00A8\u0006T"}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "recyclerView", "", "positions", "onReadyToFetchPartially", "(Landroidx/recyclerview/widget/RecyclerView;[I)V", "", "color", "setOfferingContentsBgColor", "(Landroid/view/View;I)V", "isWhiteType", "setTitleBarWhiteType", "(Z)V", "OFFERING_VIEWTYPE_PROGRAM", "Ljava/lang/String;", "OFFERING_VIEWTYPE_CAST", "OFFERING_VIEWTYPE_OUTLINK", "selectedIndex", "I", "pagerAdapterSize", "isTitleBarWhiteType", "Z", "roundThumbDefaultColor", "rectThumbDefaultColor", "currentHeaderBgColor", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/StationHomeRes$RESPONSE$TOPOFFERLIST;", "Lkotlin/collections/ArrayList;", "topOfferList", "Ljava/util/ArrayList;", "section", "page", "", "Landroid/graphics/drawable/GradientDrawable;", "headerDrawable", "[Landroid/graphics/drawable/GradientDrawable;", "Companion", "ScrollLayoutManager", "StationAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StationFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_IS_WHITE_TITLE_BAR", "newInstance", "Lcom/iloen/melon/fragments/radio/StationFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final StationFragment newInstance() {
            StationFragment stationFragment0 = new StationFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argHasPersonalizedContent", true);
            stationFragment0.setArguments(bundle0);
            return stationFragment0;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\f\u0010\n\u001A\b\u0018\u00010\bR\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment$ScrollLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/radio/StationFragment;Landroid/content/Context;)V", "", "dy", "Landroidx/recyclerview/widget/D0;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/K0;", "state", "scrollVerticallyBy", "(ILandroidx/recyclerview/widget/D0;Landroidx/recyclerview/widget/K0;)I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ScrollLayoutManager extends LinearLayoutManager {
        public ScrollLayoutManager(@NotNull Context context0) {
            q.g(context0, "context");
            StationFragment.this = stationFragment0;
            super(context0);
        }

        @Override  // androidx.recyclerview.widget.LinearLayoutManager
        public int scrollVerticallyBy(int v, @Nullable D0 d00, @Nullable K0 k00) {
            if(!StationFragment.this.topOfferList.isEmpty()) {
                if(this.findFirstVisibleItemPosition() > 0) {
                    if(!StationFragment.this.isTitleBarWhiteType) {
                        StationFragment.this.setTitleBarWhiteType(true);
                        return super.scrollVerticallyBy(v, d00, k00);
                    }
                }
                else if(StationFragment.this.isTitleBarWhiteType) {
                    StationFragment.this.setTitleBarWhiteType(false);
                }
            }
            return super.scrollVerticallyBy(v, d00, k00);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0001X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment$ServerDataWrapper;", "", "<init>", "()V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ServerDataWrapper {
        public Object data;
        private int viewType;

        public ServerDataWrapper() {
            this.viewType = -1;
        }

        @NotNull
        public final Object getData() {
            Object object0 = this.data;
            if(object0 != null) {
                return object0;
            }
            q.m("data");
            throw null;
        }

        public final int getViewType() {
            return this.viewType;
        }

        public final void setData(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.data = object0;
        }

        public final void setViewType(int v) {
            this.viewType = v;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001B\u001A\u0004\u0018\u00010\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\"R\u001A\u0010$\u001A\u00020\u00138\u0006X\u0086D¢\u0006\f\n\u0004\b$\u0010\"\u001A\u0004\b%\u0010&R\u001A\u0010\'\u001A\u00020\u00138\u0006X\u0086D¢\u0006\f\n\u0004\b\'\u0010\"\u001A\u0004\b(\u0010&¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/radio/StationFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_UNKNOWN", "I", "VIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "getVIEW_TYPE_ITEM", "()I", "VIEW_TYPE_ITEM_LAND", "getVIEW_TYPE_ITEM_LAND", "HeaderViewHolder", "ItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class StationAdapter extends p {
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR$\u0010\u0013\u001A\u0010\u0018\u00010\u0010R\n0\u0000R\u00060\u0011R\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter;Landroid/view/View;)V", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "Landroid/widget/LinearLayout;", "dotLayout", "Landroid/widget/LinearLayout;", "getDotLayout", "()Landroid/widget/LinearLayout;", "Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter;", "Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter;", "Lcom/iloen/melon/fragments/radio/StationFragment;", "headerPagerAdapter", "Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter;", "HeaderPagerAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class HeaderViewHolder extends O0 {
            @SuppressLint({"CheckResult"})
            @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0013\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0012\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter;", "Landroidx/viewpager/widget/a;", "<init>", "(Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter$HeaderViewHolder;)V", "Lcom/iloen/melon/net/v5x/response/StationHomeRes$RESPONSE$TOPOFFERLIST;", "topOfferData", "", "position", "Lie/H;", "topItemClickLog", "(Lcom/iloen/melon/net/v5x/response/StationHomeRes$RESPONSE$TOPOFFERLIST;I)V", "Landroid/view/ViewGroup;", "container", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "getCount", "()I", "object", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Landroid/view/View;", "view", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class HeaderPagerAdapter extends a {
                public static void a(TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0, StationAdapter stationFragment$StationAdapter0, HeaderPagerAdapter stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, int v, View view0) {
                    HeaderPagerAdapter.instantiateItem$lambda$0(stationHomeRes$RESPONSE$TOPOFFERLIST0, stationFragment$StationAdapter0, stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, v, view0);
                }

                public static void b(StationFragment stationFragment0, TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0, HeaderPagerAdapter stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, int v, View view0) {
                    HeaderPagerAdapter.instantiateItem$lambda$2(stationFragment0, stationHomeRes$RESPONSE$TOPOFFERLIST0, stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, v, view0);
                }

                @Override  // androidx.viewpager.widget.a
                public void destroyItem(@NotNull ViewGroup viewGroup0, int v, @NotNull Object object0) {
                    q.g(viewGroup0, "container");
                    q.g(object0, "object");
                    viewGroup0.removeView(((View)object0));
                }

                @Override  // androidx.viewpager.widget.a
                public int getCount() {
                    return StationFragment.this.pagerAdapterSize;
                }

                @Override  // androidx.viewpager.widget.a
                @NotNull
                public Object instantiateItem(@NotNull ViewGroup viewGroup0, int v) {
                    String s2;
                    String s1;
                    q.g(viewGroup0, "container");
                    boolean z = false;
                    View view0 = LayoutInflater.from(StationFragment.this.getActivity()).inflate(0x7F0D0864, null, false);  // layout:starcast_viewpager_item
                    viewGroup0.addView(view0);
                    View view1 = view0.findViewById(0x7F0A0B78);  // id:thumb_iv
                    q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
                    View view2 = view0.findViewById(0x7F0A02BD);  // id:circle_iv
                    q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
                    View view3 = view0.findViewById(0x7F0A091E);  // id:play_iv
                    q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
                    View view4 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                    q.e(view4, "null cannot be cast to non-null type android.widget.TextView");
                    View view5 = view0.findViewById(0x7F0A00C2);  // id:artist_tv
                    q.e(view5, "null cannot be cast to non-null type android.widget.TextView");
                    View view6 = view0.findViewById(0x7F0A03E6);  // id:dot_iv
                    q.e(view6, "null cannot be cast to non-null type android.widget.ImageView");
                    View view7 = view0.findViewById(0x7F0A037E);  // id:date_tv
                    q.e(view7, "null cannot be cast to non-null type android.widget.TextView");
                    GradientDrawable[] arr_gradientDrawable = StationFragment.this.headerDrawable;
                    if(arr_gradientDrawable != null) {
                        Drawable drawable0 = ((ImageView)view2).getBackground().mutate();
                        q.e(drawable0, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                        arr_gradientDrawable[v] = drawable0;
                    }
                    Object object0 = je.p.n0(v, StationFragment.this.topOfferList);
                    Glide.with(StationAdapter.this.getContext()).load((((TOPOFFERLIST)object0) == null ? null : ((TOPOFFERLIST)object0).imgUrl)).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                            q.g(drawable0, "resource");
                            int v = ColorUtils.getColor(((ImageView)view1).getContext(), 0x7F06048A);  // color:transparent
                            StationAdapter.this.setImageResource(v);
                            StationFragment.this.setImageDrawable(drawable0);
                            GradientDrawable[] arr_gradientDrawable = v.headerDrawable;
                            if(arr_gradientDrawable != null) {
                                GradientDrawable gradientDrawable0 = arr_gradientDrawable[((TOPOFFERLIST)object0)];
                                if(gradientDrawable0 != null) {
                                    gradientDrawable0.setColor(ColorUtils.getColorFromHexStr(((ImageView)view1).getContext(), (this.$topOfferData == null ? null : this.$topOfferData.bgColor), v.roundThumbDefaultColor));
                                }
                            }
                        }

                        @Override  // com.bumptech.glide.request.target.Target
                        public void onResourceReady(Object object0, Transition transition0) {
                            this.onResourceReady(((Drawable)object0), transition0);
                        }
                    });
                    String s = "";
                    if(((TOPOFFERLIST)object0) == null) {
                        s1 = "";
                    }
                    else {
                        s1 = ((TOPOFFERLIST)object0).title;
                        if(s1 == null) {
                            s1 = "";
                        }
                    }
                    ((TextView)view4).setText(s1);
                    if(((TOPOFFERLIST)object0) == null) {
                        s2 = "";
                    }
                    else {
                        s2 = ((TOPOFFERLIST)object0).contsTitle;
                        if(s2 == null) {
                            s2 = "";
                        }
                    }
                    ((TextView)view5).setText(s2);
                    if(((TOPOFFERLIST)object0) != null) {
                        String s3 = ((TOPOFFERLIST)object0).subTitle;
                        if(s3 != null) {
                            s = s3;
                        }
                    }
                    ((TextView)view7).setText(s);
                    ViewUtils.showWhen(((ImageView)view3), q.b(StationFragment.this.OFFERING_VIEWTYPE_CAST, (((TOPOFFERLIST)object0) == null ? null : ((TOPOFFERLIST)object0).viewType)));
                    if(q.b(StationFragment.this.OFFERING_VIEWTYPE_OUTLINK, (((TOPOFFERLIST)object0) == null ? null : ((TOPOFFERLIST)object0).viewType))) {
                        z = true;
                    }
                    else {
                        CharSequence charSequence0 = ((TextView)view7).getText();
                        q.f(charSequence0, "getText(...)");
                        if(charSequence0.length() == 0) {
                            z = true;
                        }
                        else {
                            CharSequence charSequence1 = ((TextView)view5).getText();
                            q.f(charSequence1, "getText(...)");
                            if(charSequence1.length() == 0) {
                                z = true;
                            }
                        }
                    }
                    ViewUtils.hideWhen(((ImageView)view6), z);
                    ViewUtils.hideWhen(((TextView)view5), q.b(StationFragment.this.OFFERING_VIEWTYPE_OUTLINK, (((TOPOFFERLIST)object0) == null ? null : ((TOPOFFERLIST)object0).viewType)));
                    if(q.b(StationFragment.this.OFFERING_VIEWTYPE_CAST, (((TOPOFFERLIST)object0) == null ? null : ((TOPOFFERLIST)object0).viewType))) {
                        ViewUtils.setOnClickListener(((ImageView)view3), new c(((TOPOFFERLIST)object0), StationAdapter.this, this, v));
                    }
                    ViewUtils.setOnClickListener(view0, new c(StationFragment.this, ((TOPOFFERLIST)object0), this, v));
                    return view0;
                }

                private static final void instantiateItem$lambda$0(TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0, StationAdapter stationFragment$StationAdapter0, HeaderPagerAdapter stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, int v, View view0) {
                    if(stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId != null && stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId.length() != 0) {
                        String s = stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId;
                        String s1 = stationFragment$StationAdapter0.getMenuId();
                        Navigator.INSTANCE.openStationListen(s, s1);
                    }
                    stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0.topItemClickLog(stationHomeRes$RESPONSE$TOPOFFERLIST0, v);
                }

                private static final void instantiateItem$lambda$2(StationFragment stationFragment0, TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0, HeaderPagerAdapter stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0, int v, View view0) {
                    String s = null;
                    if(!q.b(stationFragment0.OFFERING_VIEWTYPE_CAST, (stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.viewType))) {
                        if(q.b(stationFragment0.OFFERING_VIEWTYPE_PROGRAM, (stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.viewType))) {
                            String s1 = stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId;
                            q.f(s1, "contsId");
                            ProgramDetailFragment.Companion.newInstance(s1).open();
                        }
                        else {
                            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                            melonLinkInfo0.a = stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.linktype;
                            melonLinkInfo0.b = stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.linkurl;
                            if(stationHomeRes$RESPONSE$TOPOFFERLIST0 != null) {
                                s = stationHomeRes$RESPONSE$TOPOFFERLIST0.scheme;
                            }
                            melonLinkInfo0.c = s;
                            MelonLinkExecutor.open(melonLinkInfo0);
                        }
                    }
                    else if(stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId != null && stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId.length() != 0) {
                        Navigator.INSTANCE.openCastEpisodeDetail(stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId);
                    }
                    stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0.topItemClickLog(stationHomeRes$RESPONSE$TOPOFFERLIST0, v);
                }

                @Override  // androidx.viewpager.widget.a
                public boolean isViewFromObject(@NotNull View view0, @NotNull Object object0) {
                    q.g(view0, "view");
                    q.g(object0, "object");
                    return view0 == object0;
                }

                private final void topItemClickLog(TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0, int v) {
                    String s1;
                    g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                    g0.I = StationAdapter.this.getMenuId();
                    g0.d = ActionKind.ClickContent;
                    g0.a = "페이지이동";
                    g0.b = StationFragment.this.section;
                    g0.c = StationFragment.this.page;
                    g0.y = "메인피처링";
                    g0.z = "페이지이동";
                    String s = null;
                    g0.E = stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.imgUrl;
                    g0.C = String.valueOf(v + 1);
                    g0.e = stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.contsId;
                    if(stationHomeRes$RESPONSE$TOPOFFERLIST0 == null) {
                        s1 = "";
                    }
                    else {
                        s1 = stationHomeRes$RESPONSE$TOPOFFERLIST0.contsTypeCode;
                        if(s1 == null) {
                            s1 = "";
                        }
                    }
                    g0.f = b.a(s1);
                    if(stationHomeRes$RESPONSE$TOPOFFERLIST0 != null) {
                        s = stationHomeRes$RESPONSE$TOPOFFERLIST0.title;
                    }
                    g0.g = s;
                    g0.a().track();
                }
            }

            @NotNull
            private final LinearLayout dotLayout;
            @Nullable
            private HeaderPagerAdapter headerPagerAdapter;
            @NotNull
            private final ViewPager viewPager;

            public HeaderViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                StationAdapter.this = stationFragment$StationAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0DC9);  // id:view_pager
                q.e(view1, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
                this.viewPager = (ViewPager)view1;
                View view2 = view0.findViewById(0x7F0A03E7);  // id:dot_layout
                q.e(view2, "null cannot be cast to non-null type android.widget.LinearLayout");
                this.dotLayout = (LinearLayout)view2;
                HeaderPagerAdapter stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0 = new HeaderPagerAdapter(this);
                this.headerPagerAdapter = stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0;
                ((ViewPager)view1).setAdapter(stationFragment$StationAdapter$HeaderViewHolder$HeaderPagerAdapter0);
                ((ViewPager)view1).setCurrentItem(StationFragment.this.selectedIndex);
                ((ViewPager)view1).setOffscreenPageLimit(StationFragment.this.pagerAdapterSize);
                ((ViewPager)view1).addOnPageChangeListener(new j() {
                    @Override  // androidx.viewpager.widget.j
                    public void onPageScrollStateChanged(int v) {
                    }

                    @Override  // androidx.viewpager.widget.j
                    public void onPageScrolled(int v, float f, int v1) {
                    }

                    @Override  // androidx.viewpager.widget.j
                    public void onPageSelected(int v) {
                        this.selectedIndex = v;
                        TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0 = (TOPOFFERLIST)je.p.n0(this.selectedIndex, this.topOfferList);
                        q.f(stationFragment$StationAdapter0.itemView, "itemView");
                        Context context0 = StationAdapter.this.getContext();
                        String s = null;
                        this.setOfferingContentsBgColor(stationFragment$StationAdapter0.itemView, ColorUtils.getColorFromHexStr(context0, (stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.bgColor), this.rectThumbDefaultColor));
                        GradientDrawable[] arr_gradientDrawable = this.headerDrawable;
                        if(arr_gradientDrawable != null) {
                            GradientDrawable gradientDrawable0 = arr_gradientDrawable[v];
                            if(gradientDrawable0 != null) {
                                Context context1 = StationAdapter.this.getContext();
                                if(stationHomeRes$RESPONSE$TOPOFFERLIST0 != null) {
                                    s = stationHomeRes$RESPONSE$TOPOFFERLIST0.bgColor;
                                }
                                gradientDrawable0.setColor(ColorUtils.getColorFromHexStr(context1, s, this.roundThumbDefaultColor));
                            }
                        }
                        int v1 = stationFragment$StationAdapter0.getDotLayout().getChildCount();
                        for(int v2 = 0; v2 < v1; ++v2) {
                            View view0 = stationFragment$StationAdapter0.getDotLayout().getChildAt(v2);
                            q.e(view0, "null cannot be cast to non-null type android.widget.ImageView");
                            ImageView imageView0 = (ImageView)view0;
                            if(v2 == v) {
                                imageView0.setImageResource(0x7F080855);  // drawable:shape_circle_green500s
                            }
                            else {
                                imageView0.setImageResource(0x7F080878);  // drawable:shape_circle_white000e
                            }
                        }
                    }
                });
            }

            @NotNull
            public final LinearLayout getDotLayout() {
                return this.dotLayout;
            }

            @NotNull
            public final ViewPager getViewPager() {
                return this.viewPager;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001A\u0004\b\u000B\u0010\tR\u0017\u0010\r\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0011\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000E\u001A\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000E\u001A\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0018\u001A\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u0017\u0010\u001C\u001A\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u0019\u001A\u0004\b\u001D\u0010\u001BR\u0017\u0010\u001E\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u000E\u001A\u0004\b\u001F\u0010\u0010¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/radio/StationFragment$StationAdapter;Landroid/view/View;)V", "spaceLayout", "Landroid/view/View;", "getSpaceLayout", "()Landroid/view/View;", "bottomSpaceLayout", "getBottomSpaceLayout", "Landroid/widget/ImageView;", "colorBgIv", "Landroid/widget/ImageView;", "getColorBgIv", "()Landroid/widget/ImageView;", "dimIv", "getDimIv", "thumbIv", "getThumbIv", "newIv", "getNewIv", "Landroid/widget/TextView;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "dateTv", "getDateTv", "subscribeIv", "getSubscribeIv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemViewHolder extends O0 {
            @NotNull
            private final View bottomSpaceLayout;
            @NotNull
            private final ImageView colorBgIv;
            @NotNull
            private final TextView dateTv;
            @NotNull
            private final TextView descTv;
            @NotNull
            private final ImageView dimIv;
            @NotNull
            private final ImageView newIv;
            @NotNull
            private final View spaceLayout;
            @NotNull
            private final ImageView subscribeIv;
            @NotNull
            private final ImageView thumbIv;

            public ItemViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                StationAdapter.this = stationFragment$StationAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0AC2);  // id:space_layout
                q.e(view1, "null cannot be cast to non-null type android.view.View");
                this.spaceLayout = view1;
                View view2 = view0.findViewById(0x7F0A012A);  // id:bottom_space_layout
                q.e(view2, "null cannot be cast to non-null type android.view.View");
                this.bottomSpaceLayout = view2;
                View view3 = view0.findViewById(0x7F0A02DE);  // id:color_bg_iv
                q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
                this.colorBgIv = (ImageView)view3;
                View view4 = view0.findViewById(0x7F0A03C6);  // id:dim_iv
                q.e(view4, "null cannot be cast to non-null type android.widget.ImageView");
                this.dimIv = (ImageView)view4;
                View view5 = view0.findViewById(0x7F0A0B78);  // id:thumb_iv
                q.e(view5, "null cannot be cast to non-null type android.widget.ImageView");
                this.thumbIv = (ImageView)view5;
                View view6 = view0.findViewById(0x7F0A08AF);  // id:new_iv
                q.e(view6, "null cannot be cast to non-null type android.widget.ImageView");
                this.newIv = (ImageView)view6;
                View view7 = view0.findViewById(0x7F0A03AE);  // id:desc_tv
                q.e(view7, "null cannot be cast to non-null type android.widget.TextView");
                this.descTv = (TextView)view7;
                View view8 = view0.findViewById(0x7F0A037E);  // id:date_tv
                q.e(view8, "null cannot be cast to non-null type android.widget.TextView");
                this.dateTv = (TextView)view8;
                View view9 = view0.findViewById(0x7F0A0B04);  // id:subscribe_iv
                q.e(view9, "null cannot be cast to non-null type android.widget.ImageView");
                this.subscribeIv = (ImageView)view9;
            }

            @NotNull
            public final View getBottomSpaceLayout() {
                return this.bottomSpaceLayout;
            }

            @NotNull
            public final ImageView getColorBgIv() {
                return this.colorBgIv;
            }

            @NotNull
            public final TextView getDateTv() {
                return this.dateTv;
            }

            @NotNull
            public final TextView getDescTv() {
                return this.descTv;
            }

            @NotNull
            public final ImageView getDimIv() {
                return this.dimIv;
            }

            @NotNull
            public final ImageView getNewIv() {
                return this.newIv;
            }

            @NotNull
            public final View getSpaceLayout() {
                return this.spaceLayout;
            }

            @NotNull
            public final ImageView getSubscribeIv() {
                return this.subscribeIv;
            }

            @NotNull
            public final ImageView getThumbIv() {
                return this.thumbIv;
            }
        }

        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_ITEM;
        private final int VIEW_TYPE_ITEM_LAND;
        private final int VIEW_TYPE_UNKNOWN;

        public StationAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            StationFragment.this = stationFragment0;
            super(context0, list0);
            this.VIEW_TYPE_UNKNOWN = -1;
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_ITEM = 2;
            this.VIEW_TYPE_ITEM_LAND = 3;
        }

        public static void a(StationFragment stationFragment0, PROGRAMLIST stationHomeRes$RESPONSE$PROGRAMLIST0, StationAdapter stationFragment$StationAdapter0, int v, View view0) {
            StationAdapter.onBindViewImpl$lambda$4(stationFragment0, stationHomeRes$RESPONSE$PROGRAMLIST0, stationFragment$StationAdapter0, v, view0);
        }

        public static void b(StationFragment stationFragment0, PROGRAMLIST stationHomeRes$RESPONSE$PROGRAMLIST0, StationAdapter stationFragment$StationAdapter0, int v, View view0) {
            StationAdapter.onBindViewImpl$lambda$3(stationHomeRes$RESPONSE$PROGRAMLIST0, stationFragment$StationAdapter0, stationFragment0, v, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof ServerDataWrapper) {
                int v2 = ((ServerDataWrapper)object0).getViewType();
                if(v2 != this.VIEW_TYPE_ITEM && v2 != this.VIEW_TYPE_ITEM_LAND) {
                    return v2;
                }
                return ScreenUtils.isPortrait(this.getContext()) ? this.VIEW_TYPE_ITEM : this.VIEW_TYPE_ITEM_LAND;
            }
            return this.VIEW_TYPE_UNKNOWN;
        }

        public final int getVIEW_TYPE_ITEM() {
            return this.VIEW_TYPE_ITEM;
        }

        public final int getVIEW_TYPE_ITEM_LAND() {
            return this.VIEW_TYPE_ITEM_LAND;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof StationHomeRes) {
                RESPONSE stationHomeRes$RESPONSE0 = ((StationHomeRes)httpResponse0).response;
                if(stationHomeRes$RESPONSE0 == null) {
                    return false;
                }
                this.setMenuId(stationHomeRes$RESPONSE0.menuId);
                this.updateModifiedTime(this.getCacheKey());
                StationFragment stationFragment0 = StationFragment.this;
                String s1 = stationHomeRes$RESPONSE0.section;
                String s2 = "";
                if(s1 == null) {
                    s1 = "";
                }
                stationFragment0.section = s1;
                StationFragment stationFragment1 = StationFragment.this;
                String s3 = stationHomeRes$RESPONSE0.page;
                if(s3 != null) {
                    s2 = s3;
                }
                stationFragment1.page = s2;
                ArrayList arrayList0 = stationHomeRes$RESPONSE0.topOfferList;
                if(arrayList0 != null) {
                    q.f(arrayList0, "topOfferList");
                    StationFragment.this.topOfferList = arrayList0;
                    if(!StationFragment.this.topOfferList.isEmpty()) {
                        ServerDataWrapper stationFragment$ServerDataWrapper0 = new ServerDataWrapper();
                        stationFragment$ServerDataWrapper0.setViewType(this.VIEW_TYPE_HEADER);
                        stationFragment$ServerDataWrapper0.setData(StationFragment.this.topOfferList);
                        this.add(stationFragment$ServerDataWrapper0);
                        StationFragment.this.pagerAdapterSize = StationFragment.this.topOfferList.size();
                        StationFragment.this.headerDrawable = new GradientDrawable[StationFragment.this.pagerAdapterSize];
                    }
                }
                ArrayList arrayList1 = stationHomeRes$RESPONSE0.programList;
                if(arrayList1 != null && !arrayList1.isEmpty()) {
                    int v1 = arrayList1.size();
                    for(int v = 0; v < v1; ++v) {
                        ServerDataWrapper stationFragment$ServerDataWrapper1 = new ServerDataWrapper();
                        if(v == 0) {
                            ((PROGRAMLIST)arrayList1.get(0)).isFirst = true;
                        }
                        else if(v == v1 - 1) {
                            ((PROGRAMLIST)arrayList1.get(v)).isLast = true;
                        }
                        stationFragment$ServerDataWrapper1.setViewType((ScreenUtils.isPortrait(this.getContext()) ? this.VIEW_TYPE_ITEM : this.VIEW_TYPE_ITEM_LAND));
                        Object object0 = arrayList1.get(v);
                        q.f(object0, "get(...)");
                        stationFragment$ServerDataWrapper1.setData(object0);
                        this.add(stationFragment$ServerDataWrapper1);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_HEADER) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.radio.StationFragment.ServerDataWrapper");
                Object object1 = ((ServerDataWrapper)object0).getData();
                q.e(object1, "null cannot be cast to non-null type java.util.ArrayList<*>");
                Object object2 = je.p.n0(StationFragment.this.selectedIndex, ((ArrayList)object1));
                String s = null;
                TOPOFFERLIST stationHomeRes$RESPONSE$TOPOFFERLIST0 = object2 instanceof TOPOFFERLIST ? ((TOPOFFERLIST)object2) : null;
                q.f(((HeaderViewHolder)o00).itemView, "itemView");
                StationFragment.this.setOfferingContentsBgColor(((HeaderViewHolder)o00).itemView, ColorUtils.getColorFromHexStr(this.getContext(), (stationHomeRes$RESPONSE$TOPOFFERLIST0 == null ? null : stationHomeRes$RESPONSE$TOPOFFERLIST0.bgColor), StationFragment.this.rectThumbDefaultColor));
                GradientDrawable[] arr_gradientDrawable = StationFragment.this.headerDrawable;
                if(arr_gradientDrawable != null) {
                    GradientDrawable gradientDrawable0 = arr_gradientDrawable[v1];
                    if(gradientDrawable0 != null) {
                        Context context0 = this.getContext();
                        if(stationHomeRes$RESPONSE$TOPOFFERLIST0 != null) {
                            s = stationHomeRes$RESPONSE$TOPOFFERLIST0.bgColor;
                        }
                        gradientDrawable0.setColor(ColorUtils.getColorFromHexStr(context0, s, StationFragment.this.roundThumbDefaultColor));
                    }
                }
                ((HeaderViewHolder)o00).getDotLayout().removeAllViews();
                int v3 = ScreenUtils.dipToPixel(this.getContext(), 5.0f);
                int v4 = StationFragment.this.pagerAdapterSize;
                for(int v5 = 0; v5 < v4; ++v5) {
                    LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(v3, v3);
                    linearLayout$LayoutParams0.leftMargin = v5 == 0 ? 0 : ScreenUtils.dipToPixel(this.getContext(), 4.0f);
                    ImageView imageView0 = new ImageView(this.getContext());
                    imageView0.setLayoutParams(linearLayout$LayoutParams0);
                    if(v5 == StationFragment.this.selectedIndex) {
                        imageView0.setImageResource(0x7F080855);  // drawable:shape_circle_green500s
                    }
                    else {
                        imageView0.setImageResource(0x7F080878);  // drawable:shape_circle_white000e
                    }
                    ((HeaderViewHolder)o00).getDotLayout().addView(imageView0);
                }
                return;
            }
            if(v2 != this.VIEW_TYPE_ITEM && v2 != this.VIEW_TYPE_ITEM_LAND) {
                return;
            }
            Object object3 = this.getItem(v1);
            q.e(object3, "null cannot be cast to non-null type com.iloen.melon.fragments.radio.StationFragment.ServerDataWrapper");
            Object object4 = ((ServerDataWrapper)object3).getData();
            q.e(object4, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE.PROGRAMLIST");
            Drawable drawable0 = ((ItemViewHolder)o00).getColorBgIv().getBackground().mutate();
            q.e(drawable0, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ViewUtils.hideWhen(((ItemViewHolder)o00).getSpaceLayout(), true);
            ViewUtils.hideWhen(((ItemViewHolder)o00).getBottomSpaceLayout(), true);
            ViewUtils.showWhen(((ItemViewHolder)o00).getSpaceLayout(), ((PROGRAMLIST)object4).isFirst);
            ViewUtils.showWhen(((ItemViewHolder)o00).getBottomSpaceLayout(), ((PROGRAMLIST)object4).isLast);
            ((GradientDrawable)drawable0).setColor(ColorUtils.getColorFromHexStr(this.getContext(), ((PROGRAMLIST)object4).bgColor, StationFragment.this.rectThumbDefaultColor));
            Glide.with(this.getContext()).load(((PROGRAMLIST)object4).progImgUrl).into(((ItemViewHolder)o00).getThumbIv());
            ViewUtils.showWhen(((ItemViewHolder)o00).getNewIv(), q.b(((PROGRAMLIST)object4).newYn, "Y"));
            ((ItemViewHolder)o00).getDescTv().setText(((PROGRAMLIST)object4).progTitle);
            ((ItemViewHolder)o00).getDateTv().setText(((PROGRAMLIST)object4).progSubTitle);
            int v6 = 0x7F0801A7;  // drawable:btn_follow_23_off_02
            if(q.b(((PROGRAMLIST)object4).subscribeYn, "Y")) {
                ((ItemViewHolder)o00).getSubscribeIv().setImageResource(0x7F0801A9);  // drawable:btn_follow_23_on_02
                ((ItemViewHolder)o00).getSubscribeIv().setContentDescription(StationFragment.this.getString(0x7F13066F));  // string:melondj_use_subscribe "구독 중"
            }
            else {
                ((ItemViewHolder)o00).getSubscribeIv().setImageResource(0x7F0801A7);  // drawable:btn_follow_23_off_02
                ((ItemViewHolder)o00).getSubscribeIv().setContentDescription(StationFragment.this.getString(0x7F130662));  // string:melondj_subscribe "구독하기"
            }
            ImageView imageView1 = ((ItemViewHolder)o00).getSubscribeIv();
            if(q.b(((PROGRAMLIST)object4).subscribeYn, "Y")) {
                v6 = 0x7F0801A9;  // drawable:btn_follow_23_on_02
            }
            imageView1.setImageResource(v6);
            com.iloen.melon.fragments.radio.b b0 = new com.iloen.melon.fragments.radio.b(((PROGRAMLIST)object4), this, StationFragment.this, v1);
            ViewUtils.setOnClickListener(((ItemViewHolder)o00).itemView, b0);
            ViewUtils.setOnClickListener(((ItemViewHolder)o00).getSubscribeIv(), new com.iloen.melon.fragments.radio.b(StationFragment.this, ((PROGRAMLIST)object4), this, v1));

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\u000B\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"com/iloen/melon/fragments/radio/StationFragment$StationAdapter$onBindViewImpl$2$1", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "Lie/H;", "onStartAsyncTask", "()V", "", "errorMsg", "", "sumCount", "", "isLike", "onJobComplete", "(Ljava/lang/String;IZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public final class com.iloen.melon.fragments.radio.StationFragment.StationAdapter.onBindViewImpl.2.1 implements OnJobFinishListener {
                public com.iloen.melon.fragments.radio.StationFragment.StationAdapter.onBindViewImpl.2.1(StationFragment stationFragment0, PROGRAMLIST stationHomeRes$RESPONSE$PROGRAMLIST0, StationAdapter stationFragment$StationAdapter0, int v) {
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onJobComplete(String s, int v, boolean z) {
                    q.g(s, "errorMsg");
                    if(StationFragment.this.isFragmentValid()) {
                        if(s.length() != 0) {
                            StationFragment.this.showErrorPopup(s, false);
                            return;
                        }
                        this.$data.subscribeYn = z ? "Y" : "N";
                        StationAdapter.this.notifyDataSetChanged();
                        if(z) {
                            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                            g0.I = StationAdapter.this.getMenuId();
                            g0.d = ActionKind.Follow;
                            g0.a = "구독";
                            g0.b = StationFragment.this.section;
                            g0.c = StationFragment.this.page;
                            g0.y = "프로그램목록";
                            g0.z = "구독";
                            g0.C = String.valueOf(this.$position);
                            g0.e = this.$data.progSeq;
                            g0.f = b.a((this.$data.contsTypeCode == null ? "" : this.$data.contsTypeCode));
                            g0.g = this.$data.progTitle;
                            g0.a().track();
                        }
                    }
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onStartAsyncTask() {
                }
            }

        }

        private static final void onBindViewImpl$lambda$3(PROGRAMLIST stationHomeRes$RESPONSE$PROGRAMLIST0, StationAdapter stationFragment$StationAdapter0, StationFragment stationFragment0, int v, View view0) {
            String s = stationHomeRes$RESPONSE$PROGRAMLIST0.progSeq;
            q.f(s, "progSeq");
            ProgramDetailFragment.Companion.newInstance(s).open();
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = stationFragment$StationAdapter0.getMenuId();
            g0.d = ActionKind.ClickContent;
            g0.a = "페이지이동";
            g0.b = stationFragment0.section;
            g0.c = stationFragment0.page;
            g0.y = "프로그램목록";
            g0.z = "페이지이동";
            g0.C = String.valueOf(v);
            g0.e = stationHomeRes$RESPONSE$PROGRAMLIST0.progSeq;
            g0.f = b.a((stationHomeRes$RESPONSE$PROGRAMLIST0.contsTypeCode == null ? "" : stationHomeRes$RESPONSE$PROGRAMLIST0.contsTypeCode));
            g0.g = stationHomeRes$RESPONSE$PROGRAMLIST0.progTitle;
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$4(StationFragment stationFragment0, PROGRAMLIST stationHomeRes$RESPONSE$PROGRAMLIST0, StationAdapter stationFragment$StationAdapter0, int v, View view0) {
            stationFragment0.updateSubscribe(stationHomeRes$RESPONSE$PROGRAMLIST0.progSeq, "N10083", !ProtocolUtils.parseBoolean(stationHomeRes$RESPONSE$PROGRAMLIST0.subscribeYn), stationFragment$StationAdapter0.getMenuId(), new com.iloen.melon.fragments.radio.StationFragment.StationAdapter.onBindViewImpl.2.1(stationFragment0, stationHomeRes$RESPONSE$PROGRAMLIST0, stationFragment$StationAdapter0, v));
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0861, viewGroup0, false);  // layout:starcast_header_item
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_ITEM) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0862, viewGroup0, false);  // layout:starcast_list_item
                q.f(view1, "inflate(...)");
                return new ItemViewHolder(this, view1);
            }
            if(v == this.VIEW_TYPE_ITEM_LAND) {
                View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0863, viewGroup0, false);  // layout:starcast_list_item_land
                q.f(view2, "inflate(...)");
                return new ItemViewHolder(this, view2);
            }
            return null;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_IS_WHITE_TITLE_BAR = "argIsWhiteTitleBar";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String OFFERING_VIEWTYPE_CAST;
    @NotNull
    private final String OFFERING_VIEWTYPE_OUTLINK;
    @NotNull
    private final String OFFERING_VIEWTYPE_PROGRAM;
    @NotNull
    private static final String TAG = "StationFragment";
    private int currentHeaderBgColor;
    @Nullable
    private GradientDrawable[] headerDrawable;
    private boolean isTitleBarWhiteType;
    @NotNull
    private String page;
    private int pagerAdapterSize;
    private final int rectThumbDefaultColor;
    private final int roundThumbDefaultColor;
    @NotNull
    private String section;
    private int selectedIndex;
    @NotNull
    private ArrayList topOfferList;

    static {
        StationFragment.Companion = new Companion(null);
        StationFragment.$stable = 8;
    }

    public StationFragment() {
        this.OFFERING_VIEWTYPE_PROGRAM = "program";
        this.OFFERING_VIEWTYPE_CAST = "cast";
        this.OFFERING_VIEWTYPE_OUTLINK = "outlink";
        this.isTitleBarWhiteType = true;
        this.roundThumbDefaultColor = 0x7F060145;  // color:gray050s
        this.rectThumbDefaultColor = 0x7F060161;  // color:gray601s
        this.currentHeaderBgColor = -1;
        this.topOfferList = new ArrayList();
        this.section = "";
        this.page = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new StationAdapter(this, context0, null);
    }

    public static void d0(VolleyError volleyError0) {
        StationFragment.onReadyToFetchPartially$lambda$7(volleyError0);
    }

    public static void e0(StationFragment stationFragment0, ArrayList arrayList0, j0 j00, UserActionsRes userActionsRes0) {
        StationFragment.onReadyToFetchPartially$lambda$6(stationFragment0, arrayList0, j00, userActionsRes0);
    }

    public static void f0(StationFragment stationFragment0, VolleyError volleyError0) {
        StationFragment.onFetchStart$lambda$1(stationFragment0, volleyError0);
    }

    public static void g0(StationFragment stationFragment0, i i0, StationHomeRes stationHomeRes0) {
        StationFragment.onFetchStart$lambda$0(stationFragment0, i0, stationHomeRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.U0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        Context context0 = ((RecyclerView)view0).getContext();
        q.f(context0, "getContext(...)");
        ((RecyclerView)view0).setLayoutManager(new ScrollLayoutManager(this, context0));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0620, viewGroup0, false);  // layout:radio_starcast
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.radio.StationFragment.StationAdapter");
        if(i.b.equals(i0)) {
            ((StationAdapter)j00).clear();
        }
        RequestBuilder.newInstance(new StationHomeReq(this.getContext())).tag(this.getRequestTag()).listener(new H0(15, this, i0)).errorListener(new com.iloen.melon.fragments.radio.a(this, 0)).request();
        return true;
    }

    private static final void onFetchStart$lambda$0(StationFragment stationFragment0, i i0, StationHomeRes stationHomeRes0) {
        if(!stationFragment0.prepareFetchComplete(stationHomeRes0)) {
            return;
        }
        stationFragment0.performFetchComplete(i0, stationHomeRes0);
    }

    private static final void onFetchStart$lambda$1(StationFragment stationFragment0, VolleyError volleyError0) {
        stationFragment0.setTitleBarWhiteType(true);
        stationFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onReadyToFetchPartially(@NotNull RecyclerView recyclerView0, @NotNull int[] arr_v) {
        q.g(recyclerView0, "recyclerView");
        q.g(arr_v, "positions");
        if(this.isLoginUser()) {
            j0 j00 = recyclerView0.getAdapter();
            if(j00 instanceof StationAdapter && arr_v.length > 0) {
                ArrayList arrayList0 = new ArrayList();
                StringBuilder stringBuilder0 = new StringBuilder();
                for(int v = 0; v < arr_v.length; ++v) {
                    int v1 = arr_v[v];
                    int v2 = ((StationAdapter)j00).getItemViewType(v1);
                    if(v2 == ((StationAdapter)j00).getVIEW_TYPE_ITEM() || v2 == ((StationAdapter)j00).getVIEW_TYPE_ITEM_LAND()) {
                        arrayList0.add(v1);
                        try {
                            Object object0 = ((StationAdapter)j00).getItem(v1);
                            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.radio.StationFragment.ServerDataWrapper");
                            Object object1 = ((ServerDataWrapper)object0).getData();
                            q.e(object1, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE.PROGRAMLIST");
                            stringBuilder0.append(((PROGRAMLIST)object1).progSeq);
                            stringBuilder0.append(",");
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                }
                int v3 = stringBuilder0.length();
                if(v3 != 0) {
                    stringBuilder0.setLength(v3 - 1);
                    Params userActionsReq$Params0 = new Params();
                    userActionsReq$Params0.fields = "like";
                    userActionsReq$Params0.contsTypeCode = "N10083";
                    userActionsReq$Params0.contsId = stringBuilder0.toString();
                    RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag(this.getRequestTag()).listener(new H7.c(this, arrayList0, j00, 18)).errorListener(new e(7)).request();
                }
            }
        }
    }

    private static final void onReadyToFetchPartially$lambda$6(StationFragment stationFragment0, ArrayList arrayList0, j0 j00, UserActionsRes userActionsRes0) {
        if(stationFragment0.isFragmentValid() && userActionsRes0 != null && userActionsRes0.isSuccessful() && userActionsRes0.response != null) {
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
                    Object object2 = ((StationAdapter)j00).getItem(v1);
                    q.e(object2, "null cannot be cast to non-null type com.iloen.melon.fragments.radio.StationFragment.ServerDataWrapper");
                    Object object3 = ((ServerDataWrapper)object2).getData();
                    q.e(object3, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE.PROGRAMLIST");
                    ((PROGRAMLIST)object3).subscribeYn = ((RelationList)userActionsRes0.response.relationList.get(v1 - v)).fields.like;
                }
                catch(Exception unused_ex) {
                }
            }
            ((StationAdapter)j00).notifyDataSetChanged();
        }
    }

    private static final void onReadyToFetchPartially$lambda$7(VolleyError volleyError0) {
        com.iloen.melon.utils.a.v("error : ", volleyError0.getMessage(), LogU.Companion, "StationFragment");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.isTitleBarWhiteType = bundle0.getBoolean("argIsWhiteTitleBar");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("argIsWhiteTitleBar", this.isTitleBarWhiteType);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        if(this.currentHeaderBgColor == -1) {
            this.setTitleBarWhiteType(true);
            return;
        }
        this.setTitleBarWhiteType(this.isTitleBarWhiteType);
    }

    private final void setOfferingContentsBgColor(View view0, int v) {
        this.currentHeaderBgColor = v;
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setBackgroundColor(v);
        }
        view0.setBackgroundColor(v);
        if(this.isTitleBarWhiteType) {
            this.setTitleBarWhiteType(false);
        }
    }

    private final void setTitleBarWhiteType(boolean z) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.radio.StationFragment.StationAdapter");
        String s = ((StationAdapter)j00).getMenuId();
        if(z) {
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                titleBar0.a(B.a.s(1));
                titleBar0.setTiaraProperty(new s(this.section, this.page, s, null));
                titleBar0.setTitle(this.getString(0x7F130AA4));  // string:station_title "스테이션"
                titleBar0.setDimColor(ColorUtils.getColor(titleBar0.getContext(), 0x7F06048A));  // color:transparent
                titleBar0.f(true);
                titleBar0.setTitleColor(ColorUtils.getColor(titleBar0.getContext(), 0x7F06016D));  // color:gray900s
                titleBar0.setBackgroundColor(ColorUtils.getColor(titleBar0.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
            }
        }
        else {
            TitleBar titleBar1 = this.getTitleBar();
            if(titleBar1 != null) {
                F8.p p0 = new F8.p(0);
                p0.g(new m(0, false));
                titleBar1.a(p0);
                titleBar1.setTiaraProperty(new s(this.section, this.page, s, null));
                titleBar1.setTitle(this.getString(0x7F130AA4));  // string:station_title "스테이션"
                titleBar1.setBackgroundColor(this.currentHeaderBgColor);
                titleBar1.setDimColor(ColorUtils.getColor(titleBar1.getContext(), 0x7F060151));  // color:gray160e
                titleBar1.f(false);
            }
        }
        this.isTitleBarWhiteType = z;
    }
}

