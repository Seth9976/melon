package com.iloen.melon.fragments.melontv;

import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import androidx.viewpager.widget.j;
import androidx.viewpager.widget.k;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v5x.request.MelonTvTodayPersonalContsReq;
import com.iloen.melon.net.v5x.request.MelonTvTodayReq;
import com.iloen.melon.net.v5x.response.MelonTvTodayPersonalContsRes.RESPONSE.PERSONALCONTS;
import com.iloen.melon.net.v5x.response.MelonTvTodayPersonalContsRes.RESPONSE;
import com.iloen.melon.net.v5x.response.MelonTvTodayPersonalContsRes;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.BANNERLIST;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.MENUPROGINFO.PROGLIST.MV;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.MENUPROGINFO.PROGLIST;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.MENUPROGINFO;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.NEWMV;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.POPMV;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.RECMMV;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.THEMEMV;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase.REPARTIST;
import com.melon.net.res.common.MvInfoBase;
import d3.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 22\u00020\u0001:\u00042345B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0011\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ-\u0010!\u001A\u00020 2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010\'\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\u0018H\u0014¢\u0006\u0004\b\'\u0010(J\u001B\u0010,\u001A\u0006\u0012\u0002\b\u00030+2\u0006\u0010*\u001A\u00020)H\u0014¢\u0006\u0004\b,\u0010-R\u0014\u0010/\u001A\u00020.8\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001A\u00020.8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b1\u00100¨\u00066"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment;", "Lcom/iloen/melon/fragments/melontv/MelonTvBaseFragment;", "<init>", "()V", "Lv9/i;", "type", "Lie/H;", "fetchPersonalConts", "(Lv9/i;)V", "fetchToday", "Lcom/iloen/melon/net/v5x/response/MelonTvTodayRes;", "fetchCacheData", "()Lcom/iloen/melon/net/v5x/response/MelonTvTodayRes;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "getTodayMainCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "", "BANNER_DEFAULT_POS", "I", "bannerCurrentPos", "Companion", "MvItemDecoration", "MelonTvTodayAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MelonTvTodayFragment extends MelonTvBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonTvTodayFragment newInstance() {
            return new MelonTvTodayFragment();
        }
    }

    @Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\bUVWXYZ[\\B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001A\u001A\u00020\u00102\u0016\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019\u00A2\u0006\u0004\b\u001A\u0010\u001BJ-\u0010\"\u001A\u00020\n2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\b\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010&\u001A\u00020\u00132\u0006\u0010$\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b&\u0010\'J#\u0010*\u001A\u0004\u0018\u00010\u00032\b\u0010)\u001A\u0004\u0018\u00010(2\u0006\u0010\u0014\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b*\u0010+J)\u0010-\u001A\u00020\u00102\b\u0010,\u001A\u0004\u0018\u00010\u00032\u0006\u0010$\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b-\u0010.J\u001F\u00102\u001A\u00020\u00102\u0006\u00100\u001A\u00020/2\u0006\u00101\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b2\u00103J\u0017\u00104\u001A\u00020\u00102\u0006\u0010%\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b4\u00105R\u0014\u00106\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010:\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b:\u00107R\u0014\u0010;\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010<\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u00107R\u0014\u0010=\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b=\u00107R\u0014\u0010>\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b>\u00107R\u0014\u0010?\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b?\u00107R\u0014\u0010@\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b@\u00107R\u0014\u0010A\u001A\u00020\u00138\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bA\u00107R\u001A\u0010B\u001A\u00020\u00138\u0006X\u0086D\u00A2\u0006\f\n\u0004\bB\u00107\u001A\u0004\bC\u0010DR\u0016\u0010F\u001A\u00020E8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001A\u00020E8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010J\u001A\u00020I8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u001E\u0010N\u001A\n0LR\u00060\u0000R\u00020M8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bN\u0010OR$\u0010P\u001A\u0012\u0012\u0004\u0012\u00020I0\u0017j\b\u0012\u0004\u0012\u00020I`\u00198\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001A\u00020\u000E8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bR\u0010SR&\u0010T\u001A\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bT\u0010Q\u00A8\u0006]"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$ServerDataWrapper;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment;Landroid/content/Context;Ljava/util/List;)V", "", "isPersonalData", "()Z", "isBannerData", "Lcom/iloen/melon/net/v5x/response/MelonTvTodayPersonalContsRes$RESPONSE;", "data", "Lie/H;", "setPersonalData", "(Lcom/iloen/melon/net/v5x/response/MelonTvTodayPersonalContsRes$RESPONSE;)V", "", "viewType", "getSpanSize", "(I)I", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/MelonTvTodayRes$RESPONSE$BANNERLIST;", "Lkotlin/collections/ArrayList;", "createViewPagerAdapter", "(Ljava/util/ArrayList;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Landroid/widget/LinearLayout;", "parentView", "bannerSize", "initBannerDotLayout", "(Landroid/widget/LinearLayout;I)V", "updateDotView", "(I)V", "VIEW_TYPE_BANNER", "I", "VIEW_TYPE_RECM_MV", "VIEW_TYPE_PROGRAM", "VIEW_TYPE_PROGRAM_LAND", "VIEW_TYPE_PROGRAM_LAND_WIDE", "VIEW_TYPE_NEW_MV", "VIEW_TYPE_THEME", "VIEW_TYPE_THEME_LAND", "VIEW_TYPE_THEME_LAND_WIDE", "VIEW_TYPE_PERSONAL_VIDEO", "VIEW_TYPE_POP_MV_TITLE", "VIEW_TYPE_POP_MV", "getVIEW_TYPE_POP_MV", "()I", "Landroid/view/View;", "bannerContainer", "Landroid/view/View;", "bannerTextContainer", "Landroid/widget/ImageView;", "ivBanner", "Landroid/widget/ImageView;", "Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter;", "Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment;", "bannerViewPagerAdapter", "Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter;", "dotViewList", "Ljava/util/ArrayList;", "personalConts", "Lcom/iloen/melon/net/v5x/response/MelonTvTodayPersonalContsRes$RESPONSE;", "bannerConts", "ViewPagerAdapter", "BannerPageTransformer", "BannerViewHolder", "HorizontalMvViewHolder", "ProgramThemeViewHolder", "ProgramThemeLandViewHolder", "PopMvTitleViewHolder", "PopMvViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MelonTvTodayAdapter extends p {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$BannerPageTransformer;", "Landroidx/viewpager/widget/k;", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;)V", "Landroid/view/View;", "page", "", "position", "Lie/H;", "transformPage", "(Landroid/view/View;F)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class BannerPageTransformer implements k {
            @Override  // androidx.viewpager.widget.k
            public void transformPage(@NotNull View view0, float f) {
                q.g(view0, "page");
                int v = view0.getWidth();
                if(f <= 1.0f && f >= -1.0f) {
                    view0.setAlpha(1.0f - Math.abs(f));
                    double f1 = ((double)(f * ((float)v))) * 0.7;
                    view0.findViewById(0x7F0A00F4).setTranslationX(((float)f1));  // id:banner_text_container
                    ((ImageView)view0.findViewById(0x7F0A05FA)).setTranslationX(((float)(-f1)));  // id:iv_banner
                }
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;Landroid/view/View;)V", "Landroidx/viewpager/widget/ViewPager;", "kotlin.jvm.PlatformType", "bannerPager", "Landroidx/viewpager/widget/ViewPager;", "getBannerPager", "()Landroidx/viewpager/widget/ViewPager;", "Landroid/widget/LinearLayout;", "dotContainer", "Landroid/widget/LinearLayout;", "getDotContainer", "()Landroid/widget/LinearLayout;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class BannerViewHolder extends O0 {
            private final ViewPager bannerPager;
            private final LinearLayout dotContainer;

            public BannerViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                MelonTvTodayAdapter.this = melonTvTodayFragment$MelonTvTodayAdapter0;
                super(view0);
                ViewPager viewPager0 = (ViewPager)view0.findViewById(0x7F0A00F3);  // id:banner_pager
                this.bannerPager = viewPager0;
                this.dotContainer = (LinearLayout)view0.findViewById(0x7F0A03E3);  // id:dot_container
                ViewPagerAdapter melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0 = melonTvTodayFragment$MelonTvTodayAdapter0.bannerViewPagerAdapter;
                if(melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0 != null) {
                    viewPager0.setAdapter(melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0);
                    return;
                }
                q.m("bannerViewPagerAdapter");
                throw null;
            }

            public final ViewPager getBannerPager() {
                return this.bannerPager;
            }

            public final LinearLayout getDotContainer() {
                return this.dotContainer;
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\f\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001F\u0010\u0011\u001A\n \u0007*\u0004\u0018\u00010\u00100\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u001F\u0010\u0016\u001A\n \u0007*\u0004\u0018\u00010\u00150\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u001F\u0010\u001B\u001A\n \u0007*\u0004\u0018\u00010\u001A0\u001A8\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u001F\u0010 \u001A\n \u0007*\u0004\u0018\u00010\u001F0\u001F8\u0006¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u001F\u0010$\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b$\u0010\t\u001A\u0004\b%\u0010\u000B¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$HorizontalMvViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;Landroid/view/View;)V", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "titleContainer", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "thumbBorderLayout", "Landroid/view/View;", "getThumbBorderLayout", "()Landroid/view/View;", "Lcom/iloen/melon/custom/BorderImageView;", "ivProfile", "Lcom/iloen/melon/custom/BorderImageView;", "getIvProfile", "()Lcom/iloen/melon/custom/BorderImageView;", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "Landroid/widget/ImageView;", "ivTitleArrow", "Landroid/widget/ImageView;", "getIvTitleArrow", "()Landroid/widget/ImageView;", "Landroid/widget/HorizontalScrollView;", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "getHorizontalScrollView", "()Landroid/widget/HorizontalScrollView;", "itemContainer", "getItemContainer", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HorizontalMvViewHolder extends O0 {
            private final HorizontalScrollView horizontalScrollView;
            private final LinearLayout itemContainer;
            private final BorderImageView ivProfile;
            private final ImageView ivTitleArrow;
            private final View thumbBorderLayout;
            private final LinearLayout titleContainer;
            private final MelonTextView tvTitle;

            public HorizontalMvViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                MelonTvTodayAdapter.this = melonTvTodayFragment$MelonTvTodayAdapter0;
                super(view0);
                this.titleContainer = (LinearLayout)view0.findViewById(0x7F0A0B96);  // id:title_container
                View view1 = view0.findViewById(0x7F0A0B6E);  // id:thumb_border_layout
                this.thumbBorderLayout = view1;
                BorderImageView borderImageView0 = (BorderImageView)view1.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivProfile = borderImageView0;
                this.tvTitle = (MelonTextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.ivTitleArrow = (ImageView)view0.findViewById(0x7F0A06AA);  // id:iv_title_arrow
                HorizontalScrollView horizontalScrollView0 = (HorizontalScrollView)view0.findViewById(0x7F0A053D);  // id:horizontal_scrollview
                this.horizontalScrollView = horizontalScrollView0;
                this.itemContainer = (LinearLayout)horizontalScrollView0.findViewById(0x7F0A05A7);  // id:item_container
                borderImageView0.setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                borderImageView0.setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
            }

            public final HorizontalScrollView getHorizontalScrollView() {
                return this.horizontalScrollView;
            }

            public final LinearLayout getItemContainer() {
                return this.itemContainer;
            }

            public final BorderImageView getIvProfile() {
                return this.ivProfile;
            }

            public final ImageView getIvTitleArrow() {
                return this.ivTitleArrow;
            }

            public final View getThumbBorderLayout() {
                return this.thumbBorderLayout;
            }

            public final LinearLayout getTitleContainer() {
                return this.titleContainer;
            }

            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0012\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$PopMvTitleViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;Landroid/view/View;)V", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "titleContainer", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "Landroid/widget/ImageView;", "ivTitleArrow", "Landroid/widget/ImageView;", "getIvTitleArrow", "()Landroid/widget/ImageView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class PopMvTitleViewHolder extends O0 {
            private final ImageView ivTitleArrow;
            private final LinearLayout titleContainer;
            private final MelonTextView tvTitle;

            public PopMvTitleViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                MelonTvTodayAdapter.this = melonTvTodayFragment$MelonTvTodayAdapter0;
                super(view0);
                this.titleContainer = (LinearLayout)view0.findViewById(0x7F0A0B96);  // id:title_container
                this.tvTitle = (MelonTextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.ivTitleArrow = (ImageView)view0.findViewById(0x7F0A06AA);  // id:iv_title_arrow
            }

            public final ImageView getIvTitleArrow() {
                return this.ivTitleArrow;
            }

            public final LinearLayout getTitleContainer() {
                return this.titleContainer;
            }

            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006\u00A2\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\f\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006\u00A2\u0006\f\n\u0004\b\f\u0010\t\u001A\u0004\b\r\u0010\u000BR\u001F\u0010\u000E\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010\t\u001A\u0004\b\u000F\u0010\u000BR\u001F\u0010\u0011\u001A\n \u0007*\u0004\u0018\u00010\u00100\u00108\u0006\u00A2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u001F\u0010\u0016\u001A\n \u0007*\u0004\u0018\u00010\u00150\u00158\u0006\u00A2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u001F\u0010\u001B\u001A\n \u0007*\u0004\u0018\u00010\u001A0\u001A8\u0006\u00A2\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u001F\u0010\u001F\u001A\n \u0007*\u0004\u0018\u00010\u001A0\u001A8\u0006\u00A2\u0006\f\n\u0004\b\u001F\u0010\u001C\u001A\u0004\b \u0010\u001ER\u001F\u0010!\u001A\n \u0007*\u0004\u0018\u00010\u00100\u00108\u0006\u00A2\u0006\f\n\u0004\b!\u0010\u0012\u001A\u0004\b\"\u0010\u0014R\u001F\u0010#\u001A\n \u0007*\u0004\u0018\u00010\u001A0\u001A8\u0006\u00A2\u0006\f\n\u0004\b#\u0010\u001C\u001A\u0004\b$\u0010\u001ER\u001F\u0010%\u001A\n \u0007*\u0004\u0018\u00010\u001A0\u001A8\u0006\u00A2\u0006\f\n\u0004\b%\u0010\u001C\u001A\u0004\b&\u0010\u001ER\u001F\u0010\'\u001A\n \u0007*\u0004\u0018\u00010\u00100\u00108\u0006\u00A2\u0006\f\n\u0004\b\'\u0010\u0012\u001A\u0004\b(\u0010\u0014R\u001F\u0010)\u001A\n \u0007*\u0004\u0018\u00010\u001A0\u001A8\u0006\u00A2\u0006\f\n\u0004\b)\u0010\u001C\u001A\u0004\b*\u0010\u001ER\u001F\u0010+\u001A\n \u0007*\u0004\u0018\u00010\u001A0\u001A8\u0006\u00A2\u0006\f\n\u0004\b+\u0010\u001C\u001A\u0004\b,\u0010\u001ER\u001F\u0010-\u001A\n \u0007*\u0004\u0018\u00010\u00100\u00108\u0006\u00A2\u0006\f\n\u0004\b-\u0010\u0012\u001A\u0004\b.\u0010\u0014\u00A8\u0006/"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$PopMvViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;Landroid/view/View;)V", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "wrapperLayout", "Landroid/widget/RelativeLayout;", "getWrapperLayout", "()Landroid/widget/RelativeLayout;", "topContainer", "getTopContainer", "bottomContainer", "getBottomContainer", "Landroid/widget/ImageView;", "ivThumb", "Landroid/widget/ImageView;", "getIvThumb", "()Landroid/widget/ImageView;", "Landroid/widget/LinearLayout;", "videoTimeContainer", "Landroid/widget/LinearLayout;", "getVideoTimeContainer", "()Landroid/widget/LinearLayout;", "Lcom/iloen/melon/custom/MelonTextView;", "tvPlayTime", "Lcom/iloen/melon/custom/MelonTextView;", "getTvPlayTime", "()Lcom/iloen/melon/custom/MelonTextView;", "tvLiveIcon", "getTvLiveIcon", "ivDefaultImage", "getIvDefaultImage", "tvTitle", "getTvTitle", "tvArtist", "getTvArtist", "ivDot", "getIvDot", "tvDate", "getTvDate", "tvRound", "getTvRound", "btnInfo", "getBtnInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class PopMvViewHolder extends O0 {
            private final RelativeLayout bottomContainer;
            private final ImageView btnInfo;
            private final ImageView ivDefaultImage;
            private final ImageView ivDot;
            private final ImageView ivThumb;
            private final RelativeLayout topContainer;
            private final MelonTextView tvArtist;
            private final MelonTextView tvDate;
            private final MelonTextView tvLiveIcon;
            private final MelonTextView tvPlayTime;
            private final MelonTextView tvRound;
            private final MelonTextView tvTitle;
            private final LinearLayout videoTimeContainer;
            private final RelativeLayout wrapperLayout;

            public PopMvViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                MelonTvTodayAdapter.this = melonTvTodayFragment$MelonTvTodayAdapter0;
                super(view0);
                this.wrapperLayout = (RelativeLayout)view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
                this.topContainer = (RelativeLayout)view0.findViewById(0x7F0A0BCE);  // id:top_container
                this.bottomContainer = (RelativeLayout)view0.findViewById(0x7F0A0118);  // id:bottom_container
                this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                this.videoTimeContainer = (LinearLayout)view0.findViewById(0x7F0A093A);  // id:playtime_container
                MelonTextView melonTextView0 = (MelonTextView)view0.findViewById(0x7F0A0CDF);  // id:tv_play_time
                this.tvPlayTime = melonTextView0;
                this.tvLiveIcon = (MelonTextView)view0.findViewById(0x7F0A0D2F);  // id:tv_thumb_live
                this.ivDefaultImage = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.tvTitle = (MelonTextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.tvArtist = (MelonTextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
                this.ivDot = (ImageView)view0.findViewById(0x7F0A0627);  // id:iv_dot
                this.tvDate = (MelonTextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
                this.tvRound = (MelonTextView)view0.findViewById(0x7F0A0CFF);  // id:tv_round
                this.btnInfo = (ImageView)view0.findViewById(0x7F0A0169);  // id:btn_info
                ViewUtils.showWhen(melonTextView0, true);
            }

            public final RelativeLayout getBottomContainer() {
                return this.bottomContainer;
            }

            public final ImageView getBtnInfo() {
                return this.btnInfo;
            }

            public final ImageView getIvDefaultImage() {
                return this.ivDefaultImage;
            }

            public final ImageView getIvDot() {
                return this.ivDot;
            }

            public final ImageView getIvThumb() {
                return this.ivThumb;
            }

            public final RelativeLayout getTopContainer() {
                return this.topContainer;
            }

            public final MelonTextView getTvArtist() {
                return this.tvArtist;
            }

            public final MelonTextView getTvDate() {
                return this.tvDate;
            }

            public final MelonTextView getTvLiveIcon() {
                return this.tvLiveIcon;
            }

            public final MelonTextView getTvPlayTime() {
                return this.tvPlayTime;
            }

            public final MelonTextView getTvRound() {
                return this.tvRound;
            }

            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }

            public final LinearLayout getVideoTimeContainer() {
                return this.videoTimeContainer;
            }

            public final RelativeLayout getWrapperLayout() {
                return this.wrapperLayout;
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bI\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006\u00A2\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0012\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u001F\u0010\u0016\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u001F\u0010\u001A\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001A\u0010\u0017\u001A\u0004\b\u001B\u0010\u0019R\u001F\u0010\u001C\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b\u001C\u0010\u0013\u001A\u0004\b\u001D\u0010\u0015R\u001F\u0010\u001F\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"R\u001F\u0010$\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\'R\u001F\u0010)\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,R\u001F\u0010-\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\b-\u0010%\u001A\u0004\b.\u0010\'R\u001F\u0010/\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\b/\u0010\u000E\u001A\u0004\b0\u0010\u0010R\u001F\u00101\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\b1\u0010\u000E\u001A\u0004\b2\u0010\u0010R\u001F\u00103\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b3\u0010\u0013\u001A\u0004\b4\u0010\u0015R\u001F\u00105\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b5\u0010\u0017\u001A\u0004\b6\u0010\u0019R\u001F\u00107\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b7\u0010\u0017\u001A\u0004\b8\u0010\u0019R\u001F\u00109\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b9\u0010\u0013\u001A\u0004\b:\u0010\u0015R\u001F\u0010;\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\b;\u0010 \u001A\u0004\b<\u0010\"R\u001F\u0010=\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\b=\u0010%\u001A\u0004\b>\u0010\'R\u001F\u0010?\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\b?\u0010*\u001A\u0004\b@\u0010,R\u001F\u0010A\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bA\u0010%\u001A\u0004\bB\u0010\'R\u001F\u0010C\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bC\u0010\u000E\u001A\u0004\bD\u0010\u0010R\u001F\u0010E\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bE\u0010\u000E\u001A\u0004\bF\u0010\u0010R\u001F\u0010G\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\bG\u0010\u0013\u001A\u0004\bH\u0010\u0015R\u001F\u0010I\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\bI\u0010\u0017\u001A\u0004\bJ\u0010\u0019R\u001F\u0010K\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\bK\u0010\u0017\u001A\u0004\bL\u0010\u0019R\u001F\u0010M\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\bM\u0010\u0013\u001A\u0004\bN\u0010\u0015R\u001F\u0010O\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\bO\u0010 \u001A\u0004\bP\u0010\"R\u001F\u0010Q\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bQ\u0010%\u001A\u0004\bR\u0010\'R\u001F\u0010S\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\bS\u0010*\u001A\u0004\bT\u0010,R\u001F\u0010U\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bU\u0010%\u001A\u0004\bV\u0010\'R\u001F\u0010W\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bW\u0010\u000E\u001A\u0004\bX\u0010\u0010R\u001F\u0010Y\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bY\u0010\u000E\u001A\u0004\bZ\u0010\u0010R\u001F\u0010[\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b[\u0010\u0013\u001A\u0004\b\\\u0010\u0015R\u001F\u0010]\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b]\u0010\u0017\u001A\u0004\b^\u0010\u0019R\u001F\u0010_\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b_\u0010\u0017\u001A\u0004\b`\u0010\u0019R\u001F\u0010a\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\ba\u0010\u0013\u001A\u0004\bb\u0010\u0015R\u001F\u0010c\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\bc\u0010 \u001A\u0004\bd\u0010\"R\u001F\u0010e\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\be\u0010%\u001A\u0004\bf\u0010\'R\u001F\u0010g\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\bg\u0010*\u001A\u0004\bh\u0010,R\u001F\u0010i\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bi\u0010%\u001A\u0004\bj\u0010\'R\u001F\u0010k\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bk\u0010\u000E\u001A\u0004\bl\u0010\u0010R\u001F\u0010m\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bm\u0010\u000E\u001A\u0004\bn\u0010\u0010R\u001F\u0010o\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\bo\u0010\u0013\u001A\u0004\bp\u0010\u0015\u00A8\u0006q"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;Landroid/view/View;)V", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "titleContainer", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "Landroid/widget/ImageView;", "ivTitleArrow", "Landroid/widget/ImageView;", "getIvTitleArrow", "()Landroid/widget/ImageView;", "item1", "Landroid/view/View;", "getItem1", "()Landroid/view/View;", "item1ProgramTitleContainer", "getItem1ProgramTitleContainer", "ivDefaultThumb1", "getIvDefaultThumb1", "Lcom/iloen/melon/custom/BorderImageView;", "ivThumb1", "Lcom/iloen/melon/custom/BorderImageView;", "getIvThumb1", "()Lcom/iloen/melon/custom/BorderImageView;", "Landroid/widget/TextView;", "item1TvProgramTitle", "Landroid/widget/TextView;", "getItem1TvProgramTitle", "()Landroid/widget/TextView;", "Lcom/iloen/melon/custom/MelonImageView;", "item1IvThumb", "Lcom/iloen/melon/custom/MelonImageView;", "getItem1IvThumb", "()Lcom/iloen/melon/custom/MelonImageView;", "item1TvPlayTime", "getItem1TvPlayTime", "item1TvMvName", "getItem1TvMvName", "item1TvMvArtist", "getItem1TvMvArtist", "item1BtnInfo", "getItem1BtnInfo", "item2", "getItem2", "item2ProgramTitleContainer", "getItem2ProgramTitleContainer", "ivDefaultThumb2", "getIvDefaultThumb2", "ivThumb2", "getIvThumb2", "item2TvProgramTitle", "getItem2TvProgramTitle", "item2IvThumb", "getItem2IvThumb", "item2TvPlayTime", "getItem2TvPlayTime", "item2TvMvName", "getItem2TvMvName", "item2TvMvArtist", "getItem2TvMvArtist", "item2BtnInfo", "getItem2BtnInfo", "item3", "getItem3", "item3ProgramTitleContainer", "getItem3ProgramTitleContainer", "ivDefaultThumb3", "getIvDefaultThumb3", "ivThumb3", "getIvThumb3", "item3TvProgramTitle", "getItem3TvProgramTitle", "item3IvThumb", "getItem3IvThumb", "item3TvPlayTime", "getItem3TvPlayTime", "item3TvMvName", "getItem3TvMvName", "item3TvMvArtist", "getItem3TvMvArtist", "item3BtnInfo", "getItem3BtnInfo", "item4", "getItem4", "item4ProgramTitleContainer", "getItem4ProgramTitleContainer", "ivDefaultThumb4", "getIvDefaultThumb4", "ivThumb4", "getIvThumb4", "item4TvProgramTitle", "getItem4TvProgramTitle", "item4IvThumb", "getItem4IvThumb", "item4TvPlayTime", "getItem4TvPlayTime", "item4TvMvName", "getItem4TvMvName", "item4TvMvArtist", "getItem4TvMvArtist", "item4BtnInfo", "getItem4BtnInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ProgramThemeLandViewHolder extends O0 {
            private final View item1;
            private final ImageView item1BtnInfo;
            private final MelonImageView item1IvThumb;
            private final View item1ProgramTitleContainer;
            private final MelonTextView item1TvMvArtist;
            private final MelonTextView item1TvMvName;
            private final TextView item1TvPlayTime;
            private final TextView item1TvProgramTitle;
            private final View item2;
            private final ImageView item2BtnInfo;
            private final MelonImageView item2IvThumb;
            private final View item2ProgramTitleContainer;
            private final MelonTextView item2TvMvArtist;
            private final MelonTextView item2TvMvName;
            private final TextView item2TvPlayTime;
            private final TextView item2TvProgramTitle;
            private final View item3;
            private final ImageView item3BtnInfo;
            private final MelonImageView item3IvThumb;
            private final View item3ProgramTitleContainer;
            private final MelonTextView item3TvMvArtist;
            private final MelonTextView item3TvMvName;
            private final TextView item3TvPlayTime;
            private final TextView item3TvProgramTitle;
            private final View item4;
            private final ImageView item4BtnInfo;
            private final MelonImageView item4IvThumb;
            private final View item4ProgramTitleContainer;
            private final MelonTextView item4TvMvArtist;
            private final MelonTextView item4TvMvName;
            private final TextView item4TvPlayTime;
            private final TextView item4TvProgramTitle;
            private final ImageView ivDefaultThumb1;
            private final ImageView ivDefaultThumb2;
            private final ImageView ivDefaultThumb3;
            private final ImageView ivDefaultThumb4;
            private final BorderImageView ivThumb1;
            private final BorderImageView ivThumb2;
            private final BorderImageView ivThumb3;
            private final BorderImageView ivThumb4;
            private final ImageView ivTitleArrow;
            private final LinearLayout titleContainer;
            private final MelonTextView tvTitle;

            public ProgramThemeLandViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                MelonTvTodayAdapter.this = melonTvTodayFragment$MelonTvTodayAdapter0;
                super(view0);
                this.titleContainer = (LinearLayout)view0.findViewById(0x7F0A0B96);  // id:title_container
                this.tvTitle = (MelonTextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.ivTitleArrow = (ImageView)view0.findViewById(0x7F0A06AA);  // id:iv_title_arrow
                View view1 = view0.findViewById(0x7F0A059B);  // id:item1
                this.item1 = view1;
                this.item1ProgramTitleContainer = view1.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView0 = (ImageView)view1.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb1 = imageView0;
                BorderImageView borderImageView0 = (BorderImageView)view1.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb1 = borderImageView0;
                this.item1TvProgramTitle = (TextView)view1.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item1IvThumb = (MelonImageView)view1.findViewById(0x7F0A069A);  // id:iv_thumb
                TextView textView0 = (TextView)view1.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item1TvPlayTime = textView0;
                this.item1TvMvName = (MelonTextView)view1.findViewById(0x7F0A0D34);  // id:tv_title
                this.item1TvMvArtist = (MelonTextView)view1.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView1 = (ImageView)view1.findViewById(0x7F0A0169);  // id:btn_info
                this.item1BtnInfo = imageView1;
                View view2 = view0.findViewById(0x7F0A059C);  // id:item2
                this.item2 = view2;
                this.item2ProgramTitleContainer = view2.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView2 = (ImageView)view2.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb2 = imageView2;
                View view3 = view2.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb2 = (BorderImageView)view3;
                this.item2TvProgramTitle = (TextView)view2.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item2IvThumb = (MelonImageView)view2.findViewById(0x7F0A069A);  // id:iv_thumb
                TextView textView1 = (TextView)view2.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item2TvPlayTime = textView1;
                this.item2TvMvName = (MelonTextView)view2.findViewById(0x7F0A0D34);  // id:tv_title
                this.item2TvMvArtist = (MelonTextView)view2.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView3 = (ImageView)view2.findViewById(0x7F0A0169);  // id:btn_info
                this.item2BtnInfo = imageView3;
                View view4 = view0.findViewById(0x7F0A059D);  // id:item3
                this.item3 = view4;
                this.item3ProgramTitleContainer = view4.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView4 = (ImageView)view4.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb3 = imageView4;
                View view5 = view4.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb3 = (BorderImageView)view5;
                this.item3TvProgramTitle = (TextView)view4.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item3IvThumb = (MelonImageView)view4.findViewById(0x7F0A069A);  // id:iv_thumb
                View view6 = view4.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item3TvPlayTime = (TextView)view6;
                this.item3TvMvName = (MelonTextView)view4.findViewById(0x7F0A0D34);  // id:tv_title
                this.item3TvMvArtist = (MelonTextView)view4.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView5 = (ImageView)view4.findViewById(0x7F0A0169);  // id:btn_info
                this.item3BtnInfo = imageView5;
                View view7 = view0.findViewById(0x7F0A059E);  // id:item4
                this.item4 = view7;
                this.item4ProgramTitleContainer = view7.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView6 = (ImageView)view7.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb4 = imageView6;
                BorderImageView borderImageView1 = (BorderImageView)view7.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb4 = borderImageView1;
                this.item4TvProgramTitle = (TextView)view7.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item4IvThumb = (MelonImageView)view7.findViewById(0x7F0A069A);  // id:iv_thumb
                TextView textView2 = (TextView)view7.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item4TvPlayTime = textView2;
                this.item4TvMvName = (MelonTextView)view7.findViewById(0x7F0A0D34);  // id:tv_title
                this.item4TvMvArtist = (MelonTextView)view7.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView7 = (ImageView)view7.findViewById(0x7F0A0169);  // id:btn_info
                this.item4BtnInfo = imageView7;
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                borderImageView0.setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                borderImageView0.setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(textView0, true);
                ViewUtils.hideWhen(imageView1, true);
                ViewUtils.setDefaultImage(imageView2, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                ((BorderImageView)view3).setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                ((BorderImageView)view3).setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(textView1, true);
                ViewUtils.hideWhen(imageView3, true);
                ViewUtils.setDefaultImage(imageView4, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                ((BorderImageView)view5).setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                ((BorderImageView)view5).setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(((TextView)view6), true);
                ViewUtils.hideWhen(imageView5, true);
                ViewUtils.setDefaultImage(imageView6, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                borderImageView1.setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                borderImageView1.setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(textView2, true);
                ViewUtils.hideWhen(imageView7, true);
            }

            public final View getItem1() {
                return this.item1;
            }

            public final ImageView getItem1BtnInfo() {
                return this.item1BtnInfo;
            }

            public final MelonImageView getItem1IvThumb() {
                return this.item1IvThumb;
            }

            public final View getItem1ProgramTitleContainer() {
                return this.item1ProgramTitleContainer;
            }

            public final MelonTextView getItem1TvMvArtist() {
                return this.item1TvMvArtist;
            }

            public final MelonTextView getItem1TvMvName() {
                return this.item1TvMvName;
            }

            public final TextView getItem1TvPlayTime() {
                return this.item1TvPlayTime;
            }

            public final TextView getItem1TvProgramTitle() {
                return this.item1TvProgramTitle;
            }

            public final View getItem2() {
                return this.item2;
            }

            public final ImageView getItem2BtnInfo() {
                return this.item2BtnInfo;
            }

            public final MelonImageView getItem2IvThumb() {
                return this.item2IvThumb;
            }

            public final View getItem2ProgramTitleContainer() {
                return this.item2ProgramTitleContainer;
            }

            public final MelonTextView getItem2TvMvArtist() {
                return this.item2TvMvArtist;
            }

            public final MelonTextView getItem2TvMvName() {
                return this.item2TvMvName;
            }

            public final TextView getItem2TvPlayTime() {
                return this.item2TvPlayTime;
            }

            public final TextView getItem2TvProgramTitle() {
                return this.item2TvProgramTitle;
            }

            public final View getItem3() {
                return this.item3;
            }

            public final ImageView getItem3BtnInfo() {
                return this.item3BtnInfo;
            }

            public final MelonImageView getItem3IvThumb() {
                return this.item3IvThumb;
            }

            public final View getItem3ProgramTitleContainer() {
                return this.item3ProgramTitleContainer;
            }

            public final MelonTextView getItem3TvMvArtist() {
                return this.item3TvMvArtist;
            }

            public final MelonTextView getItem3TvMvName() {
                return this.item3TvMvName;
            }

            public final TextView getItem3TvPlayTime() {
                return this.item3TvPlayTime;
            }

            public final TextView getItem3TvProgramTitle() {
                return this.item3TvProgramTitle;
            }

            public final View getItem4() {
                return this.item4;
            }

            public final ImageView getItem4BtnInfo() {
                return this.item4BtnInfo;
            }

            public final MelonImageView getItem4IvThumb() {
                return this.item4IvThumb;
            }

            public final View getItem4ProgramTitleContainer() {
                return this.item4ProgramTitleContainer;
            }

            public final MelonTextView getItem4TvMvArtist() {
                return this.item4TvMvArtist;
            }

            public final MelonTextView getItem4TvMvName() {
                return this.item4TvMvName;
            }

            public final TextView getItem4TvPlayTime() {
                return this.item4TvPlayTime;
            }

            public final TextView getItem4TvProgramTitle() {
                return this.item4TvProgramTitle;
            }

            public final ImageView getIvDefaultThumb1() {
                return this.ivDefaultThumb1;
            }

            public final ImageView getIvDefaultThumb2() {
                return this.ivDefaultThumb2;
            }

            public final ImageView getIvDefaultThumb3() {
                return this.ivDefaultThumb3;
            }

            public final ImageView getIvDefaultThumb4() {
                return this.ivDefaultThumb4;
            }

            public final BorderImageView getIvThumb1() {
                return this.ivThumb1;
            }

            public final BorderImageView getIvThumb2() {
                return this.ivThumb2;
            }

            public final BorderImageView getIvThumb3() {
                return this.ivThumb3;
            }

            public final BorderImageView getIvThumb4() {
                return this.ivThumb4;
            }

            public final ImageView getIvTitleArrow() {
                return this.ivTitleArrow;
            }

            public final LinearLayout getTitleContainer() {
                return this.titleContainer;
            }

            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bK\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006\u00A2\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0012\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u001F\u0010\u0016\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u001F\u0010\u001A\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001A\u0010\u0017\u001A\u0004\b\u001B\u0010\u0019R\u001F\u0010\u001C\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b\u001C\u0010\u0013\u001A\u0004\b\u001D\u0010\u0015R\u001F\u0010\u001F\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"R\u001F\u0010$\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\'R\u001F\u0010)\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,R\u001F\u0010-\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\b-\u0010%\u001A\u0004\b.\u0010\'R\u001F\u0010/\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\b/\u0010\u000E\u001A\u0004\b0\u0010\u0010R\u001F\u00101\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\b1\u0010\u000E\u001A\u0004\b2\u0010\u0010R\u001F\u00103\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b3\u0010\u0013\u001A\u0004\b4\u0010\u0015R\u001F\u00105\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b5\u0010\u0017\u001A\u0004\b6\u0010\u0019R\u001F\u00107\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b7\u0010\u0017\u001A\u0004\b8\u0010\u0019R\u001F\u00109\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b9\u0010\u0013\u001A\u0004\b:\u0010\u0015R\u001F\u0010;\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\b;\u0010 \u001A\u0004\b<\u0010\"R\u001F\u0010=\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\b=\u0010%\u001A\u0004\b>\u0010\'R\u001F\u0010?\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\b?\u0010*\u001A\u0004\b@\u0010,R\u001F\u0010A\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bA\u0010%\u001A\u0004\bB\u0010\'R\u001F\u0010C\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bC\u0010\u000E\u001A\u0004\bD\u0010\u0010R\u001F\u0010E\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bE\u0010\u000E\u001A\u0004\bF\u0010\u0010R\u001F\u0010G\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\bG\u0010\u0013\u001A\u0004\bH\u0010\u0015R\u001F\u0010I\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006\u00A2\u0006\f\n\u0004\bI\u0010\t\u001A\u0004\bJ\u0010\u000BR\u001F\u0010K\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\bK\u0010\u0017\u001A\u0004\bL\u0010\u0019R\u001F\u0010M\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\bM\u0010\u0017\u001A\u0004\bN\u0010\u0019R\u001F\u0010O\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\bO\u0010\u0013\u001A\u0004\bP\u0010\u0015R\u001F\u0010Q\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\bQ\u0010 \u001A\u0004\bR\u0010\"R\u001F\u0010S\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bS\u0010%\u001A\u0004\bT\u0010\'R\u001F\u0010U\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\bU\u0010*\u001A\u0004\bV\u0010,R\u001F\u0010W\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bW\u0010%\u001A\u0004\bX\u0010\'R\u001F\u0010Y\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bY\u0010\u000E\u001A\u0004\bZ\u0010\u0010R\u001F\u0010[\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\b[\u0010\u000E\u001A\u0004\b\\\u0010\u0010R\u001F\u0010]\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\b]\u0010\u0013\u001A\u0004\b^\u0010\u0015R\u001F\u0010_\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b_\u0010\u0017\u001A\u0004\b`\u0010\u0019R\u001F\u0010a\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\ba\u0010\u0017\u001A\u0004\bb\u0010\u0019R\u001F\u0010c\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\bc\u0010\u0013\u001A\u0004\bd\u0010\u0015R\u001F\u0010e\u001A\n \u0007*\u0004\u0018\u00010\u001E0\u001E8\u0006\u00A2\u0006\f\n\u0004\be\u0010 \u001A\u0004\bf\u0010\"R\u001F\u0010g\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bg\u0010%\u001A\u0004\bh\u0010\'R\u001F\u0010i\u001A\n \u0007*\u0004\u0018\u00010(0(8\u0006\u00A2\u0006\f\n\u0004\bi\u0010*\u001A\u0004\bj\u0010,R\u001F\u0010k\u001A\n \u0007*\u0004\u0018\u00010#0#8\u0006\u00A2\u0006\f\n\u0004\bk\u0010%\u001A\u0004\bl\u0010\'R\u001F\u0010m\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bm\u0010\u000E\u001A\u0004\bn\u0010\u0010R\u001F\u0010o\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006\u00A2\u0006\f\n\u0004\bo\u0010\u000E\u001A\u0004\bp\u0010\u0010R\u001F\u0010q\u001A\n \u0007*\u0004\u0018\u00010\u00110\u00118\u0006\u00A2\u0006\f\n\u0004\bq\u0010\u0013\u001A\u0004\br\u0010\u0015\u00A8\u0006s"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;Landroid/view/View;)V", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "titleContainer", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "Landroid/widget/ImageView;", "ivTitleArrow", "Landroid/widget/ImageView;", "getIvTitleArrow", "()Landroid/widget/ImageView;", "item1", "Landroid/view/View;", "getItem1", "()Landroid/view/View;", "item1ProgramTitleContainer", "getItem1ProgramTitleContainer", "ivDefaultThumb1", "getIvDefaultThumb1", "Lcom/iloen/melon/custom/BorderImageView;", "ivThumb1", "Lcom/iloen/melon/custom/BorderImageView;", "getIvThumb1", "()Lcom/iloen/melon/custom/BorderImageView;", "Landroid/widget/TextView;", "item1TvProgramTitle", "Landroid/widget/TextView;", "getItem1TvProgramTitle", "()Landroid/widget/TextView;", "Lcom/iloen/melon/custom/MelonImageView;", "item1IvThumb", "Lcom/iloen/melon/custom/MelonImageView;", "getItem1IvThumb", "()Lcom/iloen/melon/custom/MelonImageView;", "item1TvPlayTime", "getItem1TvPlayTime", "item1TvMvName", "getItem1TvMvName", "item1TvMvArtist", "getItem1TvMvArtist", "item1BtnInfo", "getItem1BtnInfo", "item2", "getItem2", "item2ProgramTitleContainer", "getItem2ProgramTitleContainer", "ivDefaultThumb2", "getIvDefaultThumb2", "ivThumb2", "getIvThumb2", "item2TvProgramTitle", "getItem2TvProgramTitle", "item2IvThumb", "getItem2IvThumb", "item2TvPlayTime", "getItem2TvPlayTime", "item2TvMvName", "getItem2TvMvName", "item2TvMvArtist", "getItem2TvMvArtist", "item2BtnInfo", "getItem2BtnInfo", "secondContainer", "getSecondContainer", "item3", "getItem3", "item3ProgramTitleContainer", "getItem3ProgramTitleContainer", "ivDefaultThumb3", "getIvDefaultThumb3", "ivThumb3", "getIvThumb3", "item3TvProgramTitle", "getItem3TvProgramTitle", "item3IvThumb", "getItem3IvThumb", "item3TvPlayTime", "getItem3TvPlayTime", "item3TvMvName", "getItem3TvMvName", "item3TvMvArtist", "getItem3TvMvArtist", "item3BtnInfo", "getItem3BtnInfo", "item4", "getItem4", "item4ProgramTitleContainer", "getItem4ProgramTitleContainer", "ivDefaultThumb4", "getIvDefaultThumb4", "ivThumb4", "getIvThumb4", "item4TvProgramTitle", "getItem4TvProgramTitle", "item4IvThumb", "getItem4IvThumb", "item4TvPlayTime", "getItem4TvPlayTime", "item4TvMvName", "getItem4TvMvName", "item4TvMvArtist", "getItem4TvMvArtist", "item4BtnInfo", "getItem4BtnInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ProgramThemeViewHolder extends O0 {
            private final View item1;
            private final ImageView item1BtnInfo;
            private final MelonImageView item1IvThumb;
            private final View item1ProgramTitleContainer;
            private final MelonTextView item1TvMvArtist;
            private final MelonTextView item1TvMvName;
            private final TextView item1TvPlayTime;
            private final TextView item1TvProgramTitle;
            private final View item2;
            private final ImageView item2BtnInfo;
            private final MelonImageView item2IvThumb;
            private final View item2ProgramTitleContainer;
            private final MelonTextView item2TvMvArtist;
            private final MelonTextView item2TvMvName;
            private final TextView item2TvPlayTime;
            private final TextView item2TvProgramTitle;
            private final View item3;
            private final ImageView item3BtnInfo;
            private final MelonImageView item3IvThumb;
            private final View item3ProgramTitleContainer;
            private final MelonTextView item3TvMvArtist;
            private final MelonTextView item3TvMvName;
            private final TextView item3TvPlayTime;
            private final TextView item3TvProgramTitle;
            private final View item4;
            private final ImageView item4BtnInfo;
            private final MelonImageView item4IvThumb;
            private final View item4ProgramTitleContainer;
            private final MelonTextView item4TvMvArtist;
            private final MelonTextView item4TvMvName;
            private final TextView item4TvPlayTime;
            private final TextView item4TvProgramTitle;
            private final ImageView ivDefaultThumb1;
            private final ImageView ivDefaultThumb2;
            private final ImageView ivDefaultThumb3;
            private final ImageView ivDefaultThumb4;
            private final BorderImageView ivThumb1;
            private final BorderImageView ivThumb2;
            private final BorderImageView ivThumb3;
            private final BorderImageView ivThumb4;
            private final ImageView ivTitleArrow;
            private final LinearLayout secondContainer;
            private final LinearLayout titleContainer;
            private final MelonTextView tvTitle;

            public ProgramThemeViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                MelonTvTodayAdapter.this = melonTvTodayFragment$MelonTvTodayAdapter0;
                super(view0);
                this.titleContainer = (LinearLayout)view0.findViewById(0x7F0A0B96);  // id:title_container
                this.tvTitle = (MelonTextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.ivTitleArrow = (ImageView)view0.findViewById(0x7F0A06AA);  // id:iv_title_arrow
                View view1 = view0.findViewById(0x7F0A059B);  // id:item1
                this.item1 = view1;
                this.item1ProgramTitleContainer = view1.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView0 = (ImageView)view1.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb1 = imageView0;
                BorderImageView borderImageView0 = (BorderImageView)view1.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb1 = borderImageView0;
                this.item1TvProgramTitle = (TextView)view1.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item1IvThumb = (MelonImageView)view1.findViewById(0x7F0A069A);  // id:iv_thumb
                TextView textView0 = (TextView)view1.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item1TvPlayTime = textView0;
                this.item1TvMvName = (MelonTextView)view1.findViewById(0x7F0A0D34);  // id:tv_title
                this.item1TvMvArtist = (MelonTextView)view1.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView1 = (ImageView)view1.findViewById(0x7F0A0169);  // id:btn_info
                this.item1BtnInfo = imageView1;
                View view2 = view0.findViewById(0x7F0A059C);  // id:item2
                this.item2 = view2;
                this.item2ProgramTitleContainer = view2.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView2 = (ImageView)view2.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb2 = imageView2;
                View view3 = view2.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb2 = (BorderImageView)view3;
                this.item2TvProgramTitle = (TextView)view2.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item2IvThumb = (MelonImageView)view2.findViewById(0x7F0A069A);  // id:iv_thumb
                TextView textView1 = (TextView)view2.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item2TvPlayTime = textView1;
                this.item2TvMvName = (MelonTextView)view2.findViewById(0x7F0A0D34);  // id:tv_title
                this.item2TvMvArtist = (MelonTextView)view2.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView3 = (ImageView)view2.findViewById(0x7F0A0169);  // id:btn_info
                this.item2BtnInfo = imageView3;
                this.secondContainer = (LinearLayout)view0.findViewById(0x7F0A0A4B);  // id:second_container
                View view4 = view0.findViewById(0x7F0A059D);  // id:item3
                this.item3 = view4;
                this.item3ProgramTitleContainer = view4.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView4 = (ImageView)view4.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb3 = imageView4;
                View view5 = view4.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb3 = (BorderImageView)view5;
                this.item3TvProgramTitle = (TextView)view4.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item3IvThumb = (MelonImageView)view4.findViewById(0x7F0A069A);  // id:iv_thumb
                View view6 = view4.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item3TvPlayTime = (TextView)view6;
                this.item3TvMvName = (MelonTextView)view4.findViewById(0x7F0A0D34);  // id:tv_title
                this.item3TvMvArtist = (MelonTextView)view4.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView5 = (ImageView)view4.findViewById(0x7F0A0169);  // id:btn_info
                this.item3BtnInfo = imageView5;
                View view7 = view0.findViewById(0x7F0A059E);  // id:item4
                this.item4 = view7;
                this.item4ProgramTitleContainer = view7.findViewById(0x7F0A097B);  // id:program_title_container
                ImageView imageView6 = (ImageView)view7.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb4 = imageView6;
                BorderImageView borderImageView1 = (BorderImageView)view7.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb4 = borderImageView1;
                this.item4TvProgramTitle = (TextView)view7.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.item4IvThumb = (MelonImageView)view7.findViewById(0x7F0A069A);  // id:iv_thumb
                TextView textView2 = (TextView)view7.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.item4TvPlayTime = textView2;
                this.item4TvMvName = (MelonTextView)view7.findViewById(0x7F0A0D34);  // id:tv_title
                this.item4TvMvArtist = (MelonTextView)view7.findViewById(0x7F0A0C12);  // id:tv_artist
                ImageView imageView7 = (ImageView)view7.findViewById(0x7F0A0169);  // id:btn_info
                this.item4BtnInfo = imageView7;
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                borderImageView0.setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                borderImageView0.setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(textView0, true);
                ViewUtils.hideWhen(imageView1, true);
                ViewUtils.setDefaultImage(imageView2, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                ((BorderImageView)view3).setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                ((BorderImageView)view3).setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(textView1, true);
                ViewUtils.hideWhen(imageView3, true);
                ViewUtils.setDefaultImage(imageView4, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                ((BorderImageView)view5).setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                ((BorderImageView)view5).setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(((TextView)view6), true);
                ViewUtils.hideWhen(imageView5, true);
                ViewUtils.setDefaultImage(imageView6, ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 47.0f));
                borderImageView1.setBorderWidth(ScreenUtils.dipToPixel(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0.5f));
                borderImageView1.setBorderColor(ColorUtils.getColor(melonTvTodayFragment$MelonTvTodayAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ViewUtils.showWhen(textView2, true);
                ViewUtils.hideWhen(imageView7, true);
            }

            public final View getItem1() {
                return this.item1;
            }

            public final ImageView getItem1BtnInfo() {
                return this.item1BtnInfo;
            }

            public final MelonImageView getItem1IvThumb() {
                return this.item1IvThumb;
            }

            public final View getItem1ProgramTitleContainer() {
                return this.item1ProgramTitleContainer;
            }

            public final MelonTextView getItem1TvMvArtist() {
                return this.item1TvMvArtist;
            }

            public final MelonTextView getItem1TvMvName() {
                return this.item1TvMvName;
            }

            public final TextView getItem1TvPlayTime() {
                return this.item1TvPlayTime;
            }

            public final TextView getItem1TvProgramTitle() {
                return this.item1TvProgramTitle;
            }

            public final View getItem2() {
                return this.item2;
            }

            public final ImageView getItem2BtnInfo() {
                return this.item2BtnInfo;
            }

            public final MelonImageView getItem2IvThumb() {
                return this.item2IvThumb;
            }

            public final View getItem2ProgramTitleContainer() {
                return this.item2ProgramTitleContainer;
            }

            public final MelonTextView getItem2TvMvArtist() {
                return this.item2TvMvArtist;
            }

            public final MelonTextView getItem2TvMvName() {
                return this.item2TvMvName;
            }

            public final TextView getItem2TvPlayTime() {
                return this.item2TvPlayTime;
            }

            public final TextView getItem2TvProgramTitle() {
                return this.item2TvProgramTitle;
            }

            public final View getItem3() {
                return this.item3;
            }

            public final ImageView getItem3BtnInfo() {
                return this.item3BtnInfo;
            }

            public final MelonImageView getItem3IvThumb() {
                return this.item3IvThumb;
            }

            public final View getItem3ProgramTitleContainer() {
                return this.item3ProgramTitleContainer;
            }

            public final MelonTextView getItem3TvMvArtist() {
                return this.item3TvMvArtist;
            }

            public final MelonTextView getItem3TvMvName() {
                return this.item3TvMvName;
            }

            public final TextView getItem3TvPlayTime() {
                return this.item3TvPlayTime;
            }

            public final TextView getItem3TvProgramTitle() {
                return this.item3TvProgramTitle;
            }

            public final View getItem4() {
                return this.item4;
            }

            public final ImageView getItem4BtnInfo() {
                return this.item4BtnInfo;
            }

            public final MelonImageView getItem4IvThumb() {
                return this.item4IvThumb;
            }

            public final View getItem4ProgramTitleContainer() {
                return this.item4ProgramTitleContainer;
            }

            public final MelonTextView getItem4TvMvArtist() {
                return this.item4TvMvArtist;
            }

            public final MelonTextView getItem4TvMvName() {
                return this.item4TvMvName;
            }

            public final TextView getItem4TvPlayTime() {
                return this.item4TvPlayTime;
            }

            public final TextView getItem4TvProgramTitle() {
                return this.item4TvProgramTitle;
            }

            public final ImageView getIvDefaultThumb1() {
                return this.ivDefaultThumb1;
            }

            public final ImageView getIvDefaultThumb2() {
                return this.ivDefaultThumb2;
            }

            public final ImageView getIvDefaultThumb3() {
                return this.ivDefaultThumb3;
            }

            public final ImageView getIvDefaultThumb4() {
                return this.ivDefaultThumb4;
            }

            public final BorderImageView getIvThumb1() {
                return this.ivThumb1;
            }

            public final BorderImageView getIvThumb2() {
                return this.ivThumb2;
            }

            public final BorderImageView getIvThumb3() {
                return this.ivThumb3;
            }

            public final BorderImageView getIvThumb4() {
                return this.ivThumb4;
            }

            public final ImageView getIvTitleArrow() {
                return this.ivTitleArrow;
            }

            public final LinearLayout getSecondContainer() {
                return this.secondContainer;
            }

            public final LinearLayout getTitleContainer() {
                return this.titleContainer;
            }

            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001F\u0012\u0016\u0010\u0005\u001A\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\t\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001A\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter;", "Landroidx/viewpager/widget/a;", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/MelonTvTodayRes$RESPONSE$BANNERLIST;", "Lkotlin/collections/ArrayList;", "bannerList", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MelonTvTodayAdapter;Ljava/util/ArrayList;)V", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "Landroid/view/View;", "view", "object", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "getCount", "()I", "Lie/H;", "destroyItem", "(Landroid/view/View;ILjava/lang/Object;)V", "Ljava/util/ArrayList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ViewPagerAdapter extends a {
            @NotNull
            private ArrayList bannerList;

            public ViewPagerAdapter(@NotNull ArrayList arrayList0) {
                q.g(arrayList0, "bannerList");
                MelonTvTodayAdapter.this = melonTvTodayFragment$MelonTvTodayAdapter0;
                super();
                this.bannerList = arrayList0;
            }

            public static void a(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, ViewPagerAdapter melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0, int v, View view0) {
                ViewPagerAdapter.instantiateItem$lambda$1(melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0, v, view0);
            }

            @Override  // androidx.viewpager.widget.a
            public void destroyItem(@NotNull View view0, int v, @NotNull Object object0) {
                q.g(view0, "container");
                q.g(object0, "object");
                if(object0 instanceof View && view0 instanceof ViewPager) {
                    ((ViewPager)view0).removeView(((View)object0));
                }
            }

            @Override  // androidx.viewpager.widget.a
            public int getCount() {
                return this.bannerList.size();
            }

            @Override  // androidx.viewpager.widget.a
            @NotNull
            public Object instantiateItem(@NotNull ViewGroup viewGroup0, int v) {
                q.g(viewGroup0, "container");
                View view0 = LayoutInflater.from(MelonTvTodayAdapter.this.getContext()).inflate(0x7F0D04FF, null, false);  // layout:melontv_today_banner_item
                viewGroup0.addView(view0);
                View view1 = view0.findViewById(0x7F0A05FA);  // id:iv_banner
                q.f(view1, "findViewById(...)");
                MelonTvTodayAdapter.this.ivBanner = (ImageView)view1;
                View view2 = view0.findViewById(0x7F0A00EE);  // id:banner_container
                q.f(view2, "findViewById(...)");
                MelonTvTodayAdapter.this.bannerContainer = view2;
                View view3 = view0.findViewById(0x7F0A00F4);  // id:banner_text_container
                q.f(view3, "findViewById(...)");
                MelonTvTodayAdapter.this.bannerTextContainer = view3;
                if(this.getCount() < 2) {
                    AlphaAnimation alphaAnimation0 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation0.setStartOffset(500L);
                    alphaAnimation0.setDuration(300L);
                    View view4 = MelonTvTodayAdapter.this.bannerTextContainer;
                    if(view4 != null) {
                        view4.setAnimation(alphaAnimation0);
                        Animation animation0 = AnimationUtils.loadAnimation(MelonTvTodayAdapter.this.getContext(), 0x7F01003E);  // anim:melontv_banner_animation
                        animation0.setStartOffset(300L);
                        animation0.setDuration(500L);
                        animation0.setFillAfter(true);
                        ImageView imageView0 = MelonTvTodayAdapter.this.ivBanner;
                        if(imageView0 != null) {
                            imageView0.startAnimation(animation0);
                            goto label_31;
                        }
                        q.m("ivBanner");
                        throw null;
                    }
                    q.m("bannerTextContainer");
                    throw null;
                }
            label_31:
                int[] arr_v = {ColorUtils.getColorFromHexStr(((BANNERLIST)this.bannerList.get(v)).bgColorStart), ColorUtils.getColorFromHexStr(((BANNERLIST)this.bannerList.get(v)).bgColorEnd)};
                GradientDrawable gradientDrawable0 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, arr_v);
                View view5 = MelonTvTodayAdapter.this.bannerContainer;
                if(view5 != null) {
                    view5.setBackground(gradientDrawable0);
                    RequestBuilder requestBuilder0 = Glide.with(MelonTvTodayAdapter.this.getContext()).load(((BANNERLIST)this.bannerList.get(v)).imgurl);
                    ImageView imageView1 = MelonTvTodayAdapter.this.ivBanner;
                    if(imageView1 != null) {
                        requestBuilder0.into(imageView1);
                        View view6 = MelonTvTodayAdapter.this.bannerContainer;
                        if(view6 != null) {
                            ViewUtils.setOnClickListener(view6, new e(MelonTvTodayAdapter.this, this, v));
                            TextView textView0 = (TextView)view0.findViewById(0x7F0A0C20);  // id:tv_banner_bullet
                            String s = ((BANNERLIST)this.bannerList.get(v)).bulletTitle;
                            if(s == null || s.length() == 0) {
                                ViewUtils.hideWhen(textView0, true);
                            }
                            else {
                                ViewUtils.showWhen(textView0, true);
                                ViewUtils.setText(textView0, ((BANNERLIST)this.bannerList.get(v)).bulletTitle);
                            }
                            ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0C25)), ((BANNERLIST)this.bannerList.get(v)).title);  // id:tv_banner_title
                            ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0C21)), ((BANNERLIST)this.bannerList.get(v)).text);  // id:tv_banner_desc
                            return view0;
                        }
                        q.m("bannerContainer");
                        throw null;
                    }
                    q.m("ivBanner");
                    throw null;
                }
                q.m("bannerContainer");
                throw null;
            }

            private static final void instantiateItem$lambda$1(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, ViewPagerAdapter melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0, int v, View view0) {
                g.c0("3", melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "Z11", "", "V1", "", ((BANNERLIST)melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0.bannerList.get(v)).contentTypeCode, ((BANNERLIST)melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0.bannerList.get(v)).contentId, ((BANNERLIST)melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0.bannerList.get(v)).banerseq);
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                melonLinkInfo0.a = ((BANNERLIST)melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0.bannerList.get(v)).linktype;
                melonLinkInfo0.b = ((BANNERLIST)melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0.bannerList.get(v)).linkurl;
                melonLinkInfo0.c = ((BANNERLIST)melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0.bannerList.get(v)).scheme;
                MelonLinkExecutor.open(melonLinkInfo0);
            }

            @Override  // androidx.viewpager.widget.a
            public boolean isViewFromObject(@NotNull View view0, @NotNull Object object0) {
                q.g(view0, "view");
                q.g(object0, "object");
                return view0.equals(object0);
            }
        }

        private final int VIEW_TYPE_BANNER;
        private final int VIEW_TYPE_NEW_MV;
        private final int VIEW_TYPE_PERSONAL_VIDEO;
        private final int VIEW_TYPE_POP_MV;
        private final int VIEW_TYPE_POP_MV_TITLE;
        private final int VIEW_TYPE_PROGRAM;
        private final int VIEW_TYPE_PROGRAM_LAND;
        private final int VIEW_TYPE_PROGRAM_LAND_WIDE;
        private final int VIEW_TYPE_RECM_MV;
        private final int VIEW_TYPE_THEME;
        private final int VIEW_TYPE_THEME_LAND;
        private final int VIEW_TYPE_THEME_LAND_WIDE;
        private View bannerContainer;
        private ArrayList bannerConts;
        private View bannerTextContainer;
        private ViewPagerAdapter bannerViewPagerAdapter;
        @NotNull
        private final ArrayList dotViewList;
        private ImageView ivBanner;
        private RESPONSE personalConts;

        public MelonTvTodayAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonTvTodayFragment.this = melonTvTodayFragment0;
            super(context0, list0);
            this.VIEW_TYPE_BANNER = 1;
            this.VIEW_TYPE_RECM_MV = 2;
            this.VIEW_TYPE_PROGRAM = 3;
            this.VIEW_TYPE_PROGRAM_LAND = 4;
            this.VIEW_TYPE_PROGRAM_LAND_WIDE = 5;
            this.VIEW_TYPE_NEW_MV = 6;
            this.VIEW_TYPE_THEME = 7;
            this.VIEW_TYPE_THEME_LAND = 8;
            this.VIEW_TYPE_THEME_LAND_WIDE = 9;
            this.VIEW_TYPE_PERSONAL_VIDEO = 10;
            this.VIEW_TYPE_POP_MV_TITLE = 11;
            this.VIEW_TYPE_POP_MV = 12;
            this.dotViewList = new ArrayList();
        }

        public static void A(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$26("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        public static void B(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$39("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        public static void C(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$23("3", melonTvTodayFragment$MelonTvTodayAdapter0, view0);
        }

        public static void D(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$29("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }

        public static void E(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$40("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }

        // 检测为 Lambda 实现
        public static void a(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, H h0, H h1, int v, ArrayList arrayList0, View view0) [...]

        public static void c(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$50("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        public final void createViewPagerAdapter(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "data");
            this.bannerConts = arrayList0;
            this.bannerViewPagerAdapter = new ViewPagerAdapter(this, arrayList0);
        }

        public static void d(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$25("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }

        public static void e(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, ServerDataWrapper melonTvTodayFragment$ServerDataWrapper0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$59$lambda$58$lambda$56(melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayFragment$ServerDataWrapper0, mvInfoBase0, view0);
        }

        public static void f(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$47("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        public static void g(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$22$lambda$21$lambda$17("3", melonTvTodayFragment$MelonTvTodayAdapter0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            int v2 = ((ServerDataWrapper)this.getItem(v1)).getViewType();
            if(v2 == this.VIEW_TYPE_PROGRAM) {
                String s = MelonTvTodayFragment.this.getDeviceUiType();
                if(s != null) {
                    switch(s) {
                        case "mobileLandscape": 
                        case "tabletPortrait": {
                            return this.VIEW_TYPE_PROGRAM_LAND;
                        }
                        case "mobilePortrait": {
                            return this.VIEW_TYPE_PROGRAM;
                        }
                        case "tabletLandscape": {
                            return this.VIEW_TYPE_PROGRAM_LAND_WIDE;
                        }
                        default: {
                            return this.VIEW_TYPE_PROGRAM;
                        }
                    }
                }
                return this.VIEW_TYPE_PROGRAM;
            }
            if(v2 == this.VIEW_TYPE_THEME) {
                String s1 = MelonTvTodayFragment.this.getDeviceUiType();
                if(s1 != null) {
                    switch(s1) {
                        case "mobileLandscape": 
                        case "tabletPortrait": {
                            return this.VIEW_TYPE_THEME_LAND;
                        }
                        case "mobilePortrait": {
                            return this.VIEW_TYPE_THEME;
                        }
                        case "tabletLandscape": {
                            return this.VIEW_TYPE_THEME_LAND_WIDE;
                        }
                        default: {
                            return this.VIEW_TYPE_THEME;
                        }
                    }
                }
                return this.VIEW_TYPE_THEME;
            }
            return v2;
        }

        public final int getSpanSize(int v) {
            if(v == this.VIEW_TYPE_POP_MV) {
                String s = MelonTvTodayFragment.this.getDeviceUiType();
                if(s != null) {
                    switch(s) {
                        case "mobileLandscape": {
                            return 3;
                        }
                        case "tabletLandscape": {
                            return 2;
                        }
                        case "tabletPortrait": {
                            return 3;
                        }
                        default: {
                            return 6;
                        }
                    }
                }
            }
            return 6;
        }

        public final int getVIEW_TYPE_POP_MV() {
            return this.VIEW_TYPE_POP_MV;
        }

        public static void h(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$44("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof MelonTvTodayRes) {
                com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE melonTvTodayRes$RESPONSE0 = ((MelonTvTodayRes)httpResponse0).response;
                if(melonTvTodayRes$RESPONSE0 == null) {
                    return false;
                }
                this.setMenuId(melonTvTodayRes$RESPONSE0.menuId);
                ArrayList arrayList0 = melonTvTodayRes$RESPONSE0.bannerList;
                if(arrayList0 != null && arrayList0.size() > 0) {
                    ServerDataWrapper melonTvTodayFragment$ServerDataWrapper0 = new ServerDataWrapper();
                    melonTvTodayFragment$ServerDataWrapper0.setViewType(this.VIEW_TYPE_BANNER);
                    this.createViewPagerAdapter(arrayList0);
                    melonTvTodayFragment$ServerDataWrapper0.setBannerList(arrayList0);
                    this.add(melonTvTodayFragment$ServerDataWrapper0);
                }
                RECMMV melonTvTodayRes$RESPONSE$RECMMV0 = melonTvTodayRes$RESPONSE0.recmMv;
                if(melonTvTodayRes$RESPONSE$RECMMV0 != null && (melonTvTodayRes$RESPONSE$RECMMV0.mvList == null ? 0 : melonTvTodayRes$RESPONSE$RECMMV0.mvList.size()) > 0) {
                    ServerDataWrapper melonTvTodayFragment$ServerDataWrapper1 = new ServerDataWrapper();
                    melonTvTodayFragment$ServerDataWrapper1.setViewType(this.VIEW_TYPE_RECM_MV);
                    String s1 = melonTvTodayRes$RESPONSE$RECMMV0.title;
                    q.f(s1, "title");
                    melonTvTodayFragment$ServerDataWrapper1.setTitle(s1);
                    ArrayList arrayList1 = melonTvTodayRes$RESPONSE$RECMMV0.mvList;
                    q.f(arrayList1, "mvList");
                    melonTvTodayFragment$ServerDataWrapper1.setMvList(arrayList1);
                    this.add(melonTvTodayFragment$ServerDataWrapper1);
                }
                MENUPROGINFO melonTvTodayRes$RESPONSE$MENUPROGINFO0 = melonTvTodayRes$RESPONSE0.menuProgInfo;
                if(melonTvTodayRes$RESPONSE$MENUPROGINFO0 != null && (melonTvTodayRes$RESPONSE$MENUPROGINFO0.progList == null ? 0 : melonTvTodayRes$RESPONSE$MENUPROGINFO0.progList.size()) > 0) {
                    ServerDataWrapper melonTvTodayFragment$ServerDataWrapper2 = new ServerDataWrapper();
                    melonTvTodayFragment$ServerDataWrapper2.setViewType(this.VIEW_TYPE_PROGRAM);
                    String s2 = melonTvTodayRes$RESPONSE$MENUPROGINFO0.title;
                    q.f(s2, "title");
                    melonTvTodayFragment$ServerDataWrapper2.setTitle(s2);
                    ArrayList arrayList2 = melonTvTodayRes$RESPONSE$MENUPROGINFO0.progList;
                    q.f(arrayList2, "progList");
                    melonTvTodayFragment$ServerDataWrapper2.setProgList(arrayList2);
                    this.add(melonTvTodayFragment$ServerDataWrapper2);
                }
                NEWMV melonTvTodayRes$RESPONSE$NEWMV0 = melonTvTodayRes$RESPONSE0.newMv;
                if(melonTvTodayRes$RESPONSE$NEWMV0 != null && (melonTvTodayRes$RESPONSE$NEWMV0.mvList == null ? 0 : melonTvTodayRes$RESPONSE$NEWMV0.mvList.size()) > 0) {
                    ServerDataWrapper melonTvTodayFragment$ServerDataWrapper3 = new ServerDataWrapper();
                    melonTvTodayFragment$ServerDataWrapper3.setViewType(this.VIEW_TYPE_NEW_MV);
                    String s3 = melonTvTodayRes$RESPONSE$NEWMV0.title;
                    q.f(s3, "title");
                    melonTvTodayFragment$ServerDataWrapper3.setTitle(s3);
                    ArrayList arrayList3 = melonTvTodayRes$RESPONSE$NEWMV0.mvList;
                    q.f(arrayList3, "mvList");
                    melonTvTodayFragment$ServerDataWrapper3.setMvList(arrayList3);
                    this.add(melonTvTodayFragment$ServerDataWrapper3);
                }
                THEMEMV melonTvTodayRes$RESPONSE$THEMEMV0 = melonTvTodayRes$RESPONSE0.themeMv;
                if(melonTvTodayRes$RESPONSE$THEMEMV0 != null && (melonTvTodayRes$RESPONSE$THEMEMV0.mvList == null ? 0 : melonTvTodayRes$RESPONSE$THEMEMV0.mvList.size()) > 0) {
                    ServerDataWrapper melonTvTodayFragment$ServerDataWrapper4 = new ServerDataWrapper();
                    melonTvTodayFragment$ServerDataWrapper4.setViewType(this.VIEW_TYPE_THEME);
                    String s4 = melonTvTodayRes$RESPONSE$THEMEMV0.title;
                    q.f(s4, "title");
                    melonTvTodayFragment$ServerDataWrapper4.setTitle(s4);
                    ArrayList arrayList4 = melonTvTodayRes$RESPONSE$THEMEMV0.mvList;
                    q.f(arrayList4, "mvList");
                    melonTvTodayFragment$ServerDataWrapper4.setMvList(arrayList4);
                    this.add(melonTvTodayFragment$ServerDataWrapper4);
                }
                if(MelonTvTodayFragment.this.isLoginUser()) {
                    RESPONSE melonTvTodayPersonalContsRes$RESPONSE0 = this.personalConts;
                    if(melonTvTodayPersonalContsRes$RESPONSE0 != null) {
                        PERSONALCONTS melonTvTodayPersonalContsRes$RESPONSE$PERSONALCONTS0 = melonTvTodayPersonalContsRes$RESPONSE0.personalConts;
                        if(melonTvTodayPersonalContsRes$RESPONSE$PERSONALCONTS0 != null && (melonTvTodayPersonalContsRes$RESPONSE$PERSONALCONTS0.mvList == null ? 0 : melonTvTodayPersonalContsRes$RESPONSE$PERSONALCONTS0.mvList.size()) > 0) {
                            ServerDataWrapper melonTvTodayFragment$ServerDataWrapper5 = new ServerDataWrapper();
                            melonTvTodayFragment$ServerDataWrapper5.setViewType(this.VIEW_TYPE_PERSONAL_VIDEO);
                            String s5 = melonTvTodayPersonalContsRes$RESPONSE$PERSONALCONTS0.title;
                            q.f(s5, "title");
                            melonTvTodayFragment$ServerDataWrapper5.setTitle(s5);
                            String s6 = melonTvTodayPersonalContsRes$RESPONSE$PERSONALCONTS0.myPageImg;
                            q.f(s6, "myPageImg");
                            melonTvTodayFragment$ServerDataWrapper5.setProfileImg(s6);
                            ArrayList arrayList5 = melonTvTodayPersonalContsRes$RESPONSE$PERSONALCONTS0.mvList;
                            q.f(arrayList5, "mvList");
                            melonTvTodayFragment$ServerDataWrapper5.setMvList(arrayList5);
                            this.add(melonTvTodayFragment$ServerDataWrapper5);
                        }
                    }
                }
                POPMV melonTvTodayRes$RESPONSE$POPMV0 = melonTvTodayRes$RESPONSE0.popMv;
                if(melonTvTodayRes$RESPONSE$POPMV0 != null) {
                    int v1 = melonTvTodayRes$RESPONSE$POPMV0.mvList == null ? 0 : melonTvTodayRes$RESPONSE$POPMV0.mvList.size();
                    if(v1 > 0) {
                        ServerDataWrapper melonTvTodayFragment$ServerDataWrapper6 = new ServerDataWrapper();
                        melonTvTodayFragment$ServerDataWrapper6.setViewType(this.VIEW_TYPE_POP_MV_TITLE);
                        String s7 = melonTvTodayRes$RESPONSE$POPMV0.title;
                        q.f(s7, "title");
                        melonTvTodayFragment$ServerDataWrapper6.setTitle(s7);
                        this.add(melonTvTodayFragment$ServerDataWrapper6);
                        for(int v = 0; v < v1; ++v) {
                            ServerDataWrapper melonTvTodayFragment$ServerDataWrapper7 = new ServerDataWrapper();
                            melonTvTodayFragment$ServerDataWrapper7.setViewType(this.VIEW_TYPE_POP_MV);
                            Object object0 = melonTvTodayRes$RESPONSE$POPMV0.mvList.get(v);
                            q.f(object0, "get(...)");
                            melonTvTodayFragment$ServerDataWrapper7.setPopMvList(((MvInfoBase)object0));
                            melonTvTodayFragment$ServerDataWrapper7.setPopMvClickLogPos(v);
                            this.add(melonTvTodayFragment$ServerDataWrapper7);
                        }
                    }
                }
            }
            return true;
        }

        public static void i(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$45("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        private final void initBannerDotLayout(LinearLayout linearLayout0, int v) {
            if(v < 2) {
                return;
            }
            int v1 = ScreenUtils.dipToPixel(this.getContext(), 4.0f);
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(v1, v1);
            linearLayout$LayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
            this.dotViewList.clear();
            for(int v2 = 0; v2 < v; ++v2) {
                ImageView imageView0 = new ImageView(this.getContext());
                imageView0.setImageResource(0x7F08087A);  // drawable:shape_circle_white30
                imageView0.setLayoutParams(linearLayout$LayoutParams0);
                this.dotViewList.add(imageView0);
                linearLayout0.addView(imageView0);
            }
            this.updateDotView(MelonTvTodayFragment.this.BANNER_DEFAULT_POS);
        }

        public final boolean isBannerData() {
            if(this.bannerViewPagerAdapter != null) {
                ArrayList arrayList0 = this.bannerConts;
                if(arrayList0 != null) {
                    return !arrayList0.isEmpty();
                }
                q.m("bannerConts");
                throw null;
            }
            return false;
        }

        public final boolean isPersonalData() {
            RESPONSE melonTvTodayPersonalContsRes$RESPONSE0 = this.personalConts;
            if(melonTvTodayPersonalContsRes$RESPONSE0 != null) {
                ArrayList arrayList0 = melonTvTodayPersonalContsRes$RESPONSE0.personalConts.mvList;
                return arrayList0 != null && !arrayList0.isEmpty();
            }
            return false;
        }

        public static void j(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$42("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }

        public static void k(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$31("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }

        public static void m(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$38("3", melonTvTodayFragment$MelonTvTodayAdapter0, view0);
        }

        public static void n(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$24("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        public static void o(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$35("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            String s = "";
            int v2 = 0;
            if(o00 instanceof BannerViewHolder) {
                MelonTvTodayFragment melonTvTodayFragment0 = MelonTvTodayFragment.this;
                int v3 = ((ServerDataWrapper)this.getItem(v1)).getBannerList().size();
                LinearLayout linearLayout0 = ((BannerViewHolder)o00).getDotContainer();
                if(linearLayout0 != null) {
                    v2 = linearLayout0.getChildCount();
                }
                if(v2 <= 0) {
                    LinearLayout linearLayout1 = ((BannerViewHolder)o00).getDotContainer();
                    q.f(linearLayout1, "<get-dotContainer>(...)");
                    this.initBannerDotLayout(linearLayout1, v3);
                    if(v3 > 1) {
                        ((BannerViewHolder)o00).getBannerPager().setPageTransformer(true, new BannerPageTransformer(this));
                    }
                    ((BannerViewHolder)o00).getBannerPager().addOnPageChangeListener(new j() {
                        @Override  // androidx.viewpager.widget.j
                        public void onPageScrollStateChanged(int v) {
                        }

                        @Override  // androidx.viewpager.widget.j
                        public void onPageScrolled(int v, float f, int v1) {
                        }

                        @Override  // androidx.viewpager.widget.j
                        public void onPageSelected(int v) {
                            this.bannerCurrentPos = v;
                            MelonTvTodayAdapter.this.updateDotView(this.bannerCurrentPos);
                        }
                    });
                }
            }
            else if(o00 instanceof HorizontalMvViewHolder) {
                Object object0 = this.getItem(v1);
                ViewUtils.setTypeface(((HorizontalMvViewHolder)o00).getTvTitle(), (((ServerDataWrapper)object0).getViewType() == this.VIEW_TYPE_PERSONAL_VIDEO ? 0 : 1));
                ViewUtils.setText(((HorizontalMvViewHolder)o00).getTvTitle(), "");
                ViewUtils.showWhen(((HorizontalMvViewHolder)o00).getIvTitleArrow(), ((ServerDataWrapper)object0).getViewType() == this.VIEW_TYPE_NEW_MV);
                ViewUtils.hideWhen(((HorizontalMvViewHolder)o00).getThumbBorderLayout(), true);
                if(((ServerDataWrapper)object0).getViewType() == this.VIEW_TYPE_NEW_MV) {
                    ViewUtils.setOnClickListener(((HorizontalMvViewHolder)o00).getTitleContainer(), new com.iloen.melon.fragments.melontv.j(this, 0));
                }
                if(((ServerDataWrapper)object0).getViewType() == this.VIEW_TYPE_PERSONAL_VIDEO) {
                    ViewUtils.hideWhen(((HorizontalMvViewHolder)o00).getThumbBorderLayout(), true);
                }
                ArrayList arrayList0 = ((ServerDataWrapper)object0).getMvList();
                int v4 = arrayList0.size();
                if(((HorizontalMvViewHolder)o00).getItemContainer() != null && ((HorizontalMvViewHolder)o00).getItemContainer().getChildCount() <= 0) {
                    for(int v5 = 0; v5 < v4; ++v5) {
                        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0502, ((HorizontalMvViewHolder)o00).getHorizontalScrollView(), false);  // layout:melontv_today_horizontal_video_item
                        RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(0x7F0A088F);  // id:mv_item_container
                        ViewUtils.setEnable(view0.findViewById(0x7F0A0DF5), ((MvInfoBase)arrayList0.get(v5)).canService);  // id:wrapper_layout
                        if(((MvInfoBase)arrayList0.get(v5)).canService) {
                            ViewUtils.setEnable(view0.findViewById(0x7F0A0DF5), true);  // id:wrapper_layout
                            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                            h0.a = "";
                            H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                            h1.a = "";
                            int v6 = ((ServerDataWrapper)object0).getViewType();
                            if(v6 == this.VIEW_TYPE_RECM_MV) {
                                h0.a = "A24";
                            }
                            else if(v6 == this.VIEW_TYPE_NEW_MV) {
                                h0.a = "O57";
                                h1.a = "T01";
                            }
                            else if(v6 == this.VIEW_TYPE_PERSONAL_VIDEO) {
                                h0.a = "A23";
                                h1.a = "T01";
                            }
                            ViewUtils.setOnClickListener(relativeLayout0, (View view0) -> MelonTvTodayAdapter.onBindViewImpl$lambda$22$lambda$21$lambda$20$lambda$18("3", this, h0, h1, v5, arrayList0, view0));
                        }
                        else {
                            ViewUtils.setEnable(view0.findViewById(0x7F0A0DF5), false);  // id:wrapper_layout
                            ViewUtils.setOnClickListener(((HorizontalMvViewHolder)o00).itemView, null);
                        }
                        Glide.with(this.getContext()).load(((MvInfoBase)arrayList0.get(v5)).mv169Img).into(((ImageView)view0.findViewById(0x7F0A069A)));  // id:iv_thumb
                        TextView textView0 = (TextView)view0.findViewById(0x7F0A0CDF);  // id:tv_play_time
                        ViewUtils.showWhen(textView0, !TextUtils.isEmpty(((MvInfoBase)arrayList0.get(v5)).playTime));
                        String s1 = ((MvInfoBase)arrayList0.get(v5)).playTime;
                        if(s1 == null) {
                            s1 = "";
                        }
                        ViewUtils.setText(textView0, Cb.k.f(s1));
                        ViewUtils.showWhen(view0.findViewById(0x7F0A0D2F), false);  // id:tv_thumb_live
                        ViewUtils.hideWhen(view0.findViewById(0x7F0A093A), false);  // id:playtime_container
                        ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0CC6)), ((MvInfoBase)arrayList0.get(v5)).mvName);  // id:tv_mv_name
                        ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0CC5)), ((MvInfoBase)arrayList0.get(v5)).getArtistNames());  // id:tv_mv_artist
                        ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
                        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0;
                        if(v5 == 0) {
                            viewGroup$MarginLayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                            viewGroup$MarginLayoutParams0.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                        }
                        else if(v5 == v4 - 1) {
                            viewGroup$MarginLayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                            viewGroup$MarginLayoutParams0.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        }
                        else {
                            viewGroup$MarginLayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                            viewGroup$MarginLayoutParams0.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                        }
                        ((HorizontalMvViewHolder)o00).getItemContainer().addView(view0);
                    }
                }
            }
            else if(o00 instanceof ProgramThemeViewHolder) {
                ProgramThemeViewHolder melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0 = (ProgramThemeViewHolder)o00;
                ServerDataWrapper melonTvTodayFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
                ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getTvTitle(), "");
                if(melonTvTodayFragment$ServerDataWrapper0.getViewType() == this.VIEW_TYPE_PROGRAM) {
                    ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getIvTitleArrow(), true);
                    ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getTitleContainer(), new com.iloen.melon.fragments.melontv.j(this, 2));
                    int v7 = melonTvTodayFragment$ServerDataWrapper0.getProgList().size();
                    Object object1 = melonTvTodayFragment$ServerDataWrapper0.getProgList().get(0);
                    q.f(object1, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0 = ((PROGLIST)object1).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvProgramTitle(), ((PROGLIST)object1).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object1).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getIvThumb1());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.playTime));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvPlayTime(), Cb.k.f((melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.playTime == null ? "" : melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1ProgramTitleContainer(), new m(this, ((PROGLIST)object1), 2));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, 4));  // id:grid_item_container
                    }
                    if(v7 < 2) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getSecondContainer(), true);
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2().setVisibility(0);
                    Object object2 = melonTvTodayFragment$ServerDataWrapper0.getProgList().get(1);
                    q.f(object2, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1 = ((PROGLIST)object2).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvProgramTitle(), ((PROGLIST)object2).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object2).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getIvThumb2());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1.playTime));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvPlayTime(), Cb.k.f((melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1.playTime == null ? "" : melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2ProgramTitleContainer(), new m(this, ((PROGLIST)object2), 3));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV1, 5));  // id:grid_item_container
                    }
                    if(v7 < 3) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getSecondContainer(), true);
                        return;
                    }
                    ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getSecondContainer(), true);
                    Object object3 = melonTvTodayFragment$ServerDataWrapper0.getProgList().get(2);
                    q.f(object3, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2 = ((PROGLIST)object3).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvProgramTitle(), ((PROGLIST)object3).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object3).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getIvThumb3());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2.playTime));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvPlayTime(), Cb.k.f((melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2.playTime == null ? "" : melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3ProgramTitleContainer(), new m(this, ((PROGLIST)object3), 4));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV2, 6));  // id:grid_item_container
                    }
                    if(v7 < 4) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4().setVisibility(0);
                    Object object4 = melonTvTodayFragment$ServerDataWrapper0.getProgList().get(3);
                    q.f(object4, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3 = ((PROGLIST)object4).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvProgramTitle(), ((PROGLIST)object4).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object4).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getIvThumb4());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3.playTime));
                        String s2 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3.playTime;
                        if(s2 != null) {
                            s = s2;
                        }
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvPlayTime(), Cb.k.f(s));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4ProgramTitleContainer(), new m(this, ((PROGLIST)object4), 5));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV3, 3));  // id:grid_item_container
                    }
                }
                else {
                    ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getIvTitleArrow(), true);
                    int v8 = melonTvTodayFragment$ServerDataWrapper0.getMvList().size();
                    MvInfoBase mvInfoBase0 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper0.getMvList().get(0);
                    if(mvInfoBase0 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase0.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1IvThumb());
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvPlayTime(), Cb.k.f((mvInfoBase0.playTime == null ? "" : mvInfoBase0.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvMvName(), mvInfoBase0.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1TvMvArtist(), mvInfoBase0.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem1().findViewById(0x7F0A04FB), new n(this, mvInfoBase0, 4));  // id:grid_item_container
                    }
                    if(v8 < 2) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getSecondContainer(), true);
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2().setVisibility(0);
                    MvInfoBase mvInfoBase1 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper0.getMvList().get(1);
                    if(mvInfoBase1 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase1.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2IvThumb());
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvPlayTime(), Cb.k.f((mvInfoBase1.playTime == null ? "" : mvInfoBase1.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvMvName(), mvInfoBase1.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2TvMvArtist(), mvInfoBase1.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem2().findViewById(0x7F0A04FB), new n(this, mvInfoBase1, 5));  // id:grid_item_container
                    }
                    if(v8 < 3) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getSecondContainer(), true);
                        return;
                    }
                    ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getSecondContainer(), true);
                    MvInfoBase mvInfoBase2 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper0.getMvList().get(2);
                    if(mvInfoBase2 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase2.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3IvThumb());
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvPlayTime(), Cb.k.f((mvInfoBase2.playTime == null ? "" : mvInfoBase2.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvMvName(), mvInfoBase2.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3TvMvArtist(), mvInfoBase2.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem3().findViewById(0x7F0A04FB), new n(this, mvInfoBase2, 6));  // id:grid_item_container
                    }
                    if(v8 < 4) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4().setVisibility(0);
                    MvInfoBase mvInfoBase3 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper0.getMvList().get(3);
                    if(mvInfoBase3 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase3.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4IvThumb());
                        String s3 = mvInfoBase3.playTime;
                        if(s3 != null) {
                            s = s3;
                        }
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvPlayTime(), Cb.k.f(s));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvMvName(), mvInfoBase3.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4TvMvArtist(), mvInfoBase3.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeViewHolder0.getItem4().findViewById(0x7F0A04FB), new n(this, mvInfoBase3, 7));  // id:grid_item_container
                    }
                }
            }
            else if(o00 instanceof ProgramThemeLandViewHolder) {
                ProgramThemeLandViewHolder melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0 = (ProgramThemeLandViewHolder)o00;
                ServerDataWrapper melonTvTodayFragment$ServerDataWrapper1 = (ServerDataWrapper)this.getItem(v1);
                ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getTvTitle(), "");
                if(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItemViewType() == this.VIEW_TYPE_PROGRAM_LAND || melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItemViewType() == this.VIEW_TYPE_PROGRAM_LAND_WIDE) {
                    ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getIvTitleArrow(), true);
                    ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getTitleContainer(), new com.iloen.melon.fragments.melontv.j(this, 3));
                    int v10 = melonTvTodayFragment$ServerDataWrapper1.getProgList().size();
                    Object object5 = melonTvTodayFragment$ServerDataWrapper1.getProgList().get(0);
                    q.f(object5, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4 = ((PROGLIST)object5).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvProgramTitle(), ((PROGLIST)object5).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object5).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getIvThumb1());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4.playTime));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvPlayTime(), Cb.k.f((melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4.playTime == null ? "" : melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1ProgramTitleContainer(), new m(this, ((PROGLIST)object5), 6));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV4, 7));  // id:grid_item_container
                    }
                    if(v10 < 2) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2().setVisibility(4);
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().setVisibility(4);
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2().setVisibility(0);
                    Object object6 = melonTvTodayFragment$ServerDataWrapper1.getProgList().get(1);
                    q.f(object6, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5 = ((PROGLIST)object6).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvProgramTitle(), ((PROGLIST)object6).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object6).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getIvThumb2());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5.playTime));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvPlayTime(), Cb.k.f((melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5.playTime == null ? "" : melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2ProgramTitleContainer(), new m(this, ((PROGLIST)object6), 7));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV5, 0));  // id:grid_item_container
                    }
                    if(v10 < 3) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().setVisibility(4);
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().setVisibility(0);
                    Object object7 = melonTvTodayFragment$ServerDataWrapper1.getProgList().get(2);
                    q.f(object7, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6 = ((PROGLIST)object7).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvProgramTitle(), ((PROGLIST)object7).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object7).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getIvThumb3());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6.playTime));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvPlayTime(), Cb.k.f((melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6.playTime == null ? "" : melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3ProgramTitleContainer(), new m(this, ((PROGLIST)object7), 0));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV6, 1));  // id:grid_item_container
                    }
                    if(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItemViewType() != this.VIEW_TYPE_PROGRAM_LAND_WIDE) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().setVisibility(8);
                        return;
                    }
                    if(v10 < 4) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().setVisibility(4);
                        return;
                    }
                    Object object8 = melonTvTodayFragment$ServerDataWrapper1.getProgList().get(3);
                    q.f(object8, "get(...)");
                    MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7 = ((PROGLIST)object8).mv;
                    if(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7 != null) {
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4ProgramTitleContainer(), true);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvProgramTitle(), ((PROGLIST)object8).progName);
                        Glide.with(this.getContext()).load(((PROGLIST)object8).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getIvThumb4());
                        Glide.with(this.getContext()).load(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7.mv169Img).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4IvThumb());
                        ViewUtils.showWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvPlayTime(), !TextUtils.isEmpty(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7.playTime));
                        String s5 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7.playTime;
                        if(s5 != null) {
                            s = s5;
                        }
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvPlayTime(), Cb.k.f(s));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvMvName(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvMvArtist(), melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4ProgramTitleContainer(), new m(this, ((PROGLIST)object8), 1));
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().findViewById(0x7F0A04FB), new com.iloen.melon.fragments.melontv.k(this, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV7, 2));  // id:grid_item_container
                    }
                }
                else {
                    ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getIvTitleArrow(), true);
                    int v9 = melonTvTodayFragment$ServerDataWrapper1.getMvList().size();
                    MvInfoBase mvInfoBase4 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper1.getMvList().get(0);
                    if(mvInfoBase4 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase4.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1IvThumb());
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvPlayTime(), Cb.k.f((mvInfoBase4.playTime == null ? "" : mvInfoBase4.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvMvName(), mvInfoBase4.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1TvMvArtist(), mvInfoBase4.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem1().findViewById(0x7F0A04FB), new n(this, mvInfoBase4, 0));  // id:grid_item_container
                    }
                    if(v9 < 2) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2().setVisibility(4);
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2().setVisibility(0);
                    MvInfoBase mvInfoBase5 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper1.getMvList().get(1);
                    if(mvInfoBase5 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase5.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2IvThumb());
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvPlayTime(), Cb.k.f((mvInfoBase5.playTime == null ? "" : mvInfoBase5.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvMvName(), mvInfoBase5.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2TvMvArtist(), mvInfoBase5.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem2().findViewById(0x7F0A04FB), new n(this, mvInfoBase5, 1));  // id:grid_item_container
                    }
                    if(v9 < 3) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().setVisibility(4);
                        return;
                    }
                    melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().setVisibility(0);
                    MvInfoBase mvInfoBase6 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper1.getMvList().get(2);
                    if(mvInfoBase6 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase6.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3IvThumb());
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvPlayTime(), Cb.k.f((mvInfoBase6.playTime == null ? "" : mvInfoBase6.playTime)));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvMvName(), mvInfoBase6.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3TvMvArtist(), mvInfoBase6.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem3().findViewById(0x7F0A04FB), new n(this, mvInfoBase6, 2));  // id:grid_item_container
                    }
                    if(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItemViewType() != this.VIEW_TYPE_THEME_LAND_WIDE) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().setVisibility(8);
                        return;
                    }
                    if(v9 < 4) {
                        melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().setVisibility(4);
                        return;
                    }
                    MvInfoBase mvInfoBase7 = (MvInfoBase)melonTvTodayFragment$ServerDataWrapper1.getMvList().get(3);
                    if(mvInfoBase7 != null) {
                        ViewUtils.hideWhen(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4ProgramTitleContainer(), true);
                        Glide.with(this.getContext()).load(mvInfoBase7.mvImg).into(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4IvThumb());
                        String s4 = mvInfoBase7.playTime;
                        if(s4 != null) {
                            s = s4;
                        }
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvPlayTime(), Cb.k.f(s));
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvMvName(), mvInfoBase7.mvName);
                        ViewUtils.setText(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4TvMvArtist(), mvInfoBase7.getArtistNames());
                        ViewUtils.setOnClickListener(melonTvTodayFragment$MelonTvTodayAdapter$ProgramThemeLandViewHolder0.getItem4().findViewById(0x7F0A04FB), new n(this, mvInfoBase7, 3));  // id:grid_item_container
                    }
                }
            }
            else {
                if(o00 instanceof PopMvTitleViewHolder) {
                    ViewUtils.setText(((PopMvTitleViewHolder)o00).getTvTitle(), "");
                    ViewUtils.setOnClickListener(((PopMvTitleViewHolder)o00).getTitleContainer(), new com.iloen.melon.fragments.melontv.j(this, 1));
                    return;
                }
                if(o00 instanceof PopMvViewHolder) {
                    MelonTvTodayFragment melonTvTodayFragment1 = MelonTvTodayFragment.this;
                    ServerDataWrapper melonTvTodayFragment$ServerDataWrapper2 = (ServerDataWrapper)this.getItem(v1);
                    MvInfoBase mvInfoBase8 = melonTvTodayFragment$ServerDataWrapper2.getPopMvList();
                    ViewUtils.setEnable(((PopMvViewHolder)o00).getWrapperLayout(), mvInfoBase8.canService);
                    h h2 = new h(this, melonTvTodayFragment$ServerDataWrapper2, mvInfoBase8, 1);
                    ViewUtils.setOnClickListener(((PopMvViewHolder)o00).itemView, h2);
                    Glide.with(this.getContext()).load(mvInfoBase8.mv169Img).into(((PopMvViewHolder)o00).getIvThumb());
                    String s6 = mvInfoBase8.playTime;
                    if(s6 != null) {
                        s = s6;
                    }
                    ViewUtils.setText(((PopMvViewHolder)o00).getTvPlayTime(), Cb.k.f(s));
                    ViewUtils.showWhen(((PopMvViewHolder)o00).getTvLiveIcon(), false);
                    ViewUtils.hideWhen(((PopMvViewHolder)o00).getVideoTimeContainer(), false);
                    ViewUtils.setText(((PopMvViewHolder)o00).getTvTitle(), mvInfoBase8.mvName);
                    ViewUtils.setText(((PopMvViewHolder)o00).getTvArtist(), mvInfoBase8.getArtistNames());
                    ViewUtils.hideWhen(((PopMvViewHolder)o00).getIvDot(), TextUtils.isEmpty(mvInfoBase8.issueDate));
                    ViewUtils.setText(((PopMvViewHolder)o00).getTvDate(), mvInfoBase8.issueDate);
                    ViewUtils.showWhen(((PopMvViewHolder)o00).getTvRound(), !TextUtils.isEmpty(mvInfoBase8.epsdName));
                    ViewUtils.setText(((PopMvViewHolder)o00).getTvRound(), mvInfoBase8.epsdName);
                    ViewUtils.setOnClickListener(((PopMvViewHolder)o00).getBtnInfo(), new h(mvInfoBase8, this, melonTvTodayFragment1, 2));
                }
            }
        }

        private static final void onBindViewImpl$lambda$22$lambda$21$lambda$17(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O57", "T05", "V2", "", "", "", "");
            Navigator.INSTANCE.openMelonTvMain(1);
        }

        private static final void onBindViewImpl$lambda$22$lambda$21$lambda$20$lambda$18(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, H h0, H h1, int v, ArrayList arrayList0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), ((String)h0.a), ((String)h1.a), "V1", String.valueOf(v), "N10003", ((MvInfoBase)arrayList0.get(v)).mvId, "");
            Navigator.openMvInfo$default(((MvInfoBase)arrayList0.get(v)).mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$23(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T05", "V2", "", "", "", "");
            Navigator.INSTANCE.openMelonTvMain(5);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$24(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "0", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$25(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "0", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$26(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "1", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$27(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "1", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$28(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "2", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$29(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "2", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$30(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "3", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$31(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "3", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$32(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "0", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$33(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "1", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$34(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "2", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$37$lambda$36$lambda$35(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "3", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$38(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T05", "V2", "", "", "", "");
            Navigator.INSTANCE.openMelonTvMain(5);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$39(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "0", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$40(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "0", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$41(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "1", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$42(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "1", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$43(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "2", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$44(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "2", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$45(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T27", "V2", "3", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.contsTypeCode, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq, "");
            String s1 = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0.progSeq;
            q.f(s1, "progSeq");
            Navigator.INSTANCE.openMelonTvProgram(s1);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$46(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "O58", "T01", "V1", "3", "N10003", melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, "");
            Navigator.openMvInfo$default(melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$47(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "0", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$48(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "1", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$49(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "2", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$52$lambda$51$lambda$50(String s, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            g.c0(s, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C07", "T01", "V1", "3", "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$55$lambda$54$lambda$53(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, View view0) {
            g.c0("3", melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C39", "T05", "V2", "", "", "", "");
            Navigator.INSTANCE.openMelonTvMain(2, 0);
        }

        private static final void onBindViewImpl$lambda$59$lambda$58$lambda$56(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, ServerDataWrapper melonTvTodayFragment$ServerDataWrapper0, MvInfoBase mvInfoBase0, View view0) {
            g.c0("3", melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), "C39", "T01", "V1", String.valueOf(melonTvTodayFragment$ServerDataWrapper0.getPopMvClickLogPos()), "N10003", mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null, false, 12, null);
        }

        private static final void onBindViewImpl$lambda$59$lambda$58$lambda$57(MvInfoBase mvInfoBase0, MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MelonTvTodayFragment melonTvTodayFragment0, View view0) {
            Playable playable0 = Playable.from(mvInfoBase0, melonTvTodayFragment$MelonTvTodayAdapter0.getMenuId(), null);
            REPARTIST mvInfoBase$REPARTIST0 = mvInfoBase0.repArtist;
            if(mvInfoBase$REPARTIST0 != null && mvInfoBase$REPARTIST0.isBrandDjs) {
                playable0.setArtist(mvInfoBase$REPARTIST0.getArtistId(), mvInfoBase$REPARTIST0.getArtistName());
                playable0.setBrandDj(mvInfoBase$REPARTIST0.isBrandDjs);
            }
            melonTvTodayFragment0.showContextPopupMv(playable0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_BANNER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04FE, viewGroup0, false);  // layout:melontv_today_banner
                q.f(view0, "inflate(...)");
                return new BannerViewHolder(this, view0);
            }
            if(v != this.VIEW_TYPE_RECM_MV && v != this.VIEW_TYPE_NEW_MV && v != this.VIEW_TYPE_PERSONAL_VIDEO) {
                if(v != this.VIEW_TYPE_PROGRAM && v != this.VIEW_TYPE_THEME) {
                    if(v != this.VIEW_TYPE_PROGRAM_LAND && v != this.VIEW_TYPE_PROGRAM_LAND_WIDE && v != this.VIEW_TYPE_THEME_LAND && v != this.VIEW_TYPE_THEME_LAND_WIDE) {
                        if(v == this.VIEW_TYPE_POP_MV_TITLE) {
                            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0503, viewGroup0, false);  // layout:melontv_today_pop_mv_title
                            q.f(view1, "inflate(...)");
                            return new PopMvTitleViewHolder(this, view1);
                        }
                        if(v == this.VIEW_TYPE_POP_MV) {
                            View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0500, viewGroup0, false);  // layout:melontv_today_fullitem
                            q.f(view2, "inflate(...)");
                            return new PopMvViewHolder(this, view2);
                        }
                        View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04FE, viewGroup0, false);  // layout:melontv_today_banner
                        q.f(view3, "inflate(...)");
                        return new BannerViewHolder(this, view3);
                    }
                    View view4 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0506, viewGroup0, false);  // layout:melontv_today_program_theme_land
                    q.f(view4, "inflate(...)");
                    return new ProgramThemeLandViewHolder(this, view4);
                }
                View view5 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0504, viewGroup0, false);  // layout:melontv_today_program_theme
                q.f(view5, "inflate(...)");
                return new ProgramThemeViewHolder(this, view5);
            }
            View view6 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0501, viewGroup0, false);  // layout:melontv_today_horizontal_video
            q.f(view6, "inflate(...)");
            return new HorizontalMvViewHolder(this, view6);
        }

        public static void p(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$34("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        public static void q(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$27("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }

        public static void r(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$41("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        public static void s(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$32("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        public final void setPersonalData(@NotNull RESPONSE melonTvTodayPersonalContsRes$RESPONSE0) {
            q.g(melonTvTodayPersonalContsRes$RESPONSE0, "data");
            this.personalConts = melonTvTodayPersonalContsRes$RESPONSE0;
        }

        public static void t(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$30("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        public static void u(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$49("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        private final void updateDotView(int v) {
            if(this.dotViewList != null && !this.dotViewList.isEmpty() || v <= this.dotViewList.size()) {
                int v1 = this.dotViewList.size();
                for(int v2 = 0; v2 < v1; ++v2) {
                    ((ImageView)this.dotViewList.get(v2)).setImageResource((v2 == v ? 0x7F08087B : 0x7F08087A));  // drawable:shape_circle_white60
                }
            }
        }

        public static void v(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$28("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        public static void w(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$43("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, view0);
        }

        public static void x(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$37$lambda$36$lambda$33("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        public static void y(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$48("3", melonTvTodayFragment$MelonTvTodayAdapter0, mvInfoBase0, view0);
        }

        public static void z(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, View view0) {
            MelonTvTodayAdapter.onBindViewImpl$lambda$52$lambda$51$lambda$46("3", melonTvTodayFragment$MelonTvTodayAdapter0, melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, view0);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\u0010\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$MvItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "", "spacingPixel", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MvItemDecoration extends r0 {
        private int spacingPixel;

        public MvItemDecoration() {
            this.spacingPixel = ScreenUtils.dipToPixel(melonTvTodayFragment0.getContext(), 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            super.getItemOffsets(rect0, view0, recyclerView0, k00);
            j0 j00 = MelonTvTodayFragment.this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melontv.MelonTvTodayFragment.MelonTvTodayAdapter");
            int v = recyclerView0.getChildAdapterPosition(view0);
            if(((MelonTvTodayAdapter)j00).getItemViewType(v) == ((MelonTvTodayAdapter)j00).getVIEW_TYPE_POP_MV()) {
                String s = MelonTvTodayFragment.this.getDeviceUiType();
                if(q.b(s, "tabletLandscape")) {
                    if(((MelonTvTodayAdapter)j00).isPersonalData()) {
                        --v;
                    }
                    if(((MelonTvTodayAdapter)j00).isBannerData()) {
                        --v;
                    }
                    int v1 = (v - 2) % 3;
                    rect0.left = this.spacingPixel - v1 * this.spacingPixel / 3;
                    rect0.right = (v1 + 1) * this.spacingPixel / 3;
                }
                else if(q.b(s, "mobilePortrait")) {
                    rect0.left = this.spacingPixel;
                    rect0.right = this.spacingPixel;
                }
                else {
                    if(((MelonTvTodayAdapter)j00).isPersonalData()) {
                        ++v;
                    }
                    if(((MelonTvTodayAdapter)j00).isBannerData()) {
                        ++v;
                    }
                    int v2 = (v + 1) % 2;
                    rect0.left = this.spacingPixel - v2 * this.spacingPixel / 2;
                    rect0.right = (v2 + 1) * this.spacingPixel / 2;
                }
                int v3 = rect0.right;
                StringBuilder stringBuilder0 = o.t(v, rect0.left, "GridSpacingItemDecoration >> [position: ", " ] >> left: ", ", right: ");
                stringBuilder0.append(v3);
                LogU.Companion.d("MelonTvTodayFragment", stringBuilder0.toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001A\u0010\u0013\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR*\u0010\u0016\u001A\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR*\u0010\u001E\u001A\u0012\u0012\u0004\u0012\u00020\u001F0\u0017j\b\u0012\u0004\u0012\u00020\u001F`\u0019X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u001B\"\u0004\b!\u0010\u001DR*\u0010\"\u001A\u0012\u0012\u0004\u0012\u00020#0\u0017j\b\u0012\u0004\u0012\u00020#`\u0019X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u001B\"\u0004\b%\u0010\u001DR\u001A\u0010&\u001A\u00020\u001FX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvTodayFragment$ServerDataWrapper;", "", "<init>", "()V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "profileImg", "getProfileImg", "setProfileImg", "popMvClickLogPos", "getPopMvClickLogPos", "setPopMvClickLogPos", "bannerList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/MelonTvTodayRes$RESPONSE$BANNERLIST;", "Lkotlin/collections/ArrayList;", "getBannerList", "()Ljava/util/ArrayList;", "setBannerList", "(Ljava/util/ArrayList;)V", "mvList", "Lcom/melon/net/res/common/MvInfoBase;", "getMvList", "setMvList", "progList", "Lcom/iloen/melon/net/v5x/response/MelonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST;", "getProgList", "setProgList", "popMvList", "getPopMvList", "()Lcom/melon/net/res/common/MvInfoBase;", "setPopMvList", "(Lcom/melon/net/res/common/MvInfoBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ServerDataWrapper {
        public ArrayList bannerList;
        public ArrayList mvList;
        private int popMvClickLogPos;
        public MvInfoBase popMvList;
        @NotNull
        private String profileImg;
        public ArrayList progList;
        @NotNull
        private String title;
        private int viewType;

        public ServerDataWrapper() {
            this.viewType = -1;
            this.title = "";
            this.profileImg = "";
            this.popMvClickLogPos = -1;
        }

        @NotNull
        public final ArrayList getBannerList() {
            ArrayList arrayList0 = this.bannerList;
            if(arrayList0 != null) {
                return arrayList0;
            }
            q.m("bannerList");
            throw null;
        }

        @NotNull
        public final ArrayList getMvList() {
            ArrayList arrayList0 = this.mvList;
            if(arrayList0 != null) {
                return arrayList0;
            }
            q.m("mvList");
            throw null;
        }

        public final int getPopMvClickLogPos() {
            return this.popMvClickLogPos;
        }

        @NotNull
        public final MvInfoBase getPopMvList() {
            MvInfoBase mvInfoBase0 = this.popMvList;
            if(mvInfoBase0 != null) {
                return mvInfoBase0;
            }
            q.m("popMvList");
            throw null;
        }

        @NotNull
        public final String getProfileImg() [...] // 潜在的解密器

        @NotNull
        public final ArrayList getProgList() {
            ArrayList arrayList0 = this.progList;
            if(arrayList0 != null) {
                return arrayList0;
            }
            q.m("progList");
            throw null;
        }

        @NotNull
        public final String getTitle() [...] // 潜在的解密器

        public final int getViewType() {
            return this.viewType;
        }

        public final void setBannerList(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "<set-?>");
            this.bannerList = arrayList0;
        }

        public final void setMvList(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "<set-?>");
            this.mvList = arrayList0;
        }

        public final void setPopMvClickLogPos(int v) {
            this.popMvClickLogPos = v;
        }

        public final void setPopMvList(@NotNull MvInfoBase mvInfoBase0) {
            q.g(mvInfoBase0, "<set-?>");
            this.popMvList = mvInfoBase0;
        }

        public final void setProfileImg(@NotNull String s) {
            q.g(s, "<set-?>");
            this.profileImg = s;
        }

        public final void setProgList(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "<set-?>");
            this.progList = arrayList0;
        }

        public final void setTitle(@NotNull String s) {
            q.g(s, "<set-?>");
            this.title = s;
        }

        public final void setViewType(int v) {
            this.viewType = v;
        }
    }

    public static final int $stable = 0;
    private final int BANNER_DEFAULT_POS;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MelonTvTodayFragment";
    private int bannerCurrentPos;

    static {
        MelonTvTodayFragment.Companion = new Companion(null);
        MelonTvTodayFragment.$stable = 8;
    }

    public MelonTvTodayFragment() {
        this.bannerCurrentPos = this.BANNER_DEFAULT_POS;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new MelonTvTodayAdapter(this, context0, null);
    }

    private final MelonTvTodayRes fetchCacheData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.getTodayMainCacheKey());
        if(cursor0 == null) {
            LogU.Companion.w("MelonTvTodayFragment", "fetchData() invalid cursor");
            return null;
        }
        MelonTvTodayRes melonTvTodayRes0 = (MelonTvTodayRes)com.iloen.melon.responsecache.a.d(cursor0, MelonTvTodayRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(melonTvTodayRes0 == null) {
            LogU.Companion.w("MelonTvTodayFragment", "fetchData() failed to extract contents");
            return null;
        }
        return melonTvTodayRes0;
    }

    private final void fetchPersonalConts(i i0) {
        com.iloen.melon.net.RequestBuilder.newInstance(new MelonTvTodayPersonalContsReq(this.getContext())).tag("MelonTvTodayFragment").listener(new com.iloen.melon.fragments.melontv.i(this, i0, 0)).errorListener(new com.iloen.melon.fragments.melontv.i(this, i0, 1)).request();
    }

    private static final void fetchPersonalConts$lambda$2(MelonTvTodayFragment melonTvTodayFragment0, i i0, MelonTvTodayPersonalContsRes melonTvTodayPersonalContsRes0) {
        if((melonTvTodayPersonalContsRes0 == null ? null : melonTvTodayPersonalContsRes0.response) != null) {
            Cb.j.b(melonTvTodayPersonalContsRes0.notification, false, 3);
            if(Cb.j.d(melonTvTodayPersonalContsRes0)) {
                j0 j00 = melonTvTodayFragment0.getAdapter();
                if(j00 instanceof MelonTvTodayAdapter) {
                    RESPONSE melonTvTodayPersonalContsRes$RESPONSE0 = melonTvTodayPersonalContsRes0.response;
                    q.f(melonTvTodayPersonalContsRes$RESPONSE0, "response");
                    ((MelonTvTodayAdapter)j00).setPersonalData(melonTvTodayPersonalContsRes$RESPONSE0);
                }
            }
        }
        melonTvTodayFragment0.fetchToday(i0);
    }

    private static final void fetchPersonalConts$lambda$3(MelonTvTodayFragment melonTvTodayFragment0, i i0, VolleyError volleyError0) {
        melonTvTodayFragment0.fetchToday(i0);
    }

    private final void fetchToday(i i0) {
        Context context0 = this.getContext();
        if(com.iloen.melon.responsecache.a.e(300000L, this.getTodayMainCacheKey(), context0)) {
            com.iloen.melon.net.RequestBuilder.newInstance(new MelonTvTodayReq(this.getContext())).tag("MelonTvTodayFragment").listener(new com.iloen.melon.fragments.melontv.i(this, i0, 2)).errorListener(this.mResponseErrorListener).request();
            return;
        }
        this.performFetchComplete(this.fetchCacheData());
    }

    private static final void fetchToday$lambda$5(MelonTvTodayFragment melonTvTodayFragment0, i i0, MelonTvTodayRes melonTvTodayRes0) {
        if(!melonTvTodayFragment0.prepareFetchComplete(melonTvTodayRes0)) {
            return;
        }
        if(melonTvTodayRes0.response != null) {
            Cb.j.b(melonTvTodayRes0.notification, false, 3);
            if(Cb.j.d(melonTvTodayRes0)) {
                com.iloen.melon.responsecache.a.a(melonTvTodayFragment0.getContext(), melonTvTodayRes0, melonTvTodayFragment0.getTodayMainCacheKey());
            }
        }
        melonTvTodayFragment0.performFetchComplete(i0, melonTvTodayRes0);
    }

    @NotNull
    public String getTodayMainCacheKey() {
        String s = Uri.withAppendedPath(MelonContentUris.f, "today").toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public static final MelonTvTodayFragment newInstance() {
        return MelonTvTodayFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.melontv.MelonTvBaseFragment
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
        ((RecyclerView)view0).setHasFixedSize(false);
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(((RecyclerView)view0).getContext(), 6);
        gridLayoutManager0.g = new androidx.recyclerview.widget.H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                if(MelonTvTodayFragment.this.mAdapter instanceof MelonTvTodayAdapter) {
                    j0 j00 = MelonTvTodayFragment.this.mAdapter;
                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melontv.MelonTvTodayFragment.MelonTvTodayAdapter");
                    return ((MelonTvTodayAdapter)j00).getSpanSize(((MelonTvTodayAdapter)j00).getItemViewType(v));
                }
                return 6;
            }
        };
        ((RecyclerView)view0).addItemDecoration(new MvItemDecoration(this));
        ((RecyclerView)view0).setLayoutManager(gridLayoutManager0);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D04FD, viewGroup0, false);  // layout:melontv_today
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable v9.h h0, @Nullable String s) {
        if(this.isLoginUser()) {
            this.fetchPersonalConts(i0);
            return true;
        }
        this.fetchToday(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }
}

