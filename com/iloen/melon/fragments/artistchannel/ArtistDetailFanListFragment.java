package com.iloen.melon.fragments.artistchannel;

import Cb.j;
import Ce.g;
import Dd.g0;
import H0.b;
import Tf.o;
import U4.x;
import X8.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.O;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.request.ArtistFanFanListReq;
import com.iloen.melon.net.v6x.request.ArtistFanFollowYnListReq;
import com.iloen.melon.net.v6x.request.ArtistTemperatureGetMemorialCardRelayReq;
import com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE.RECENTLYLIKEFANLIST;
import com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE.RISINGFANLIST;
import com.iloen.melon.net.v6x.response.ArtistFanFanListRes;
import com.iloen.melon.net.v6x.response.ArtistFanFollowYnListRes.RESPONSE.FOLLOWYNLIST;
import com.iloen.melon.net.v6x.response.ArtistFanFollowYnListRes;
import com.iloen.melon.net.v6x.response.ArtistTemperatureGetMemorialCardRelayRes.RESPONSE.MEMORIALCARDRELAYLIST;
import com.iloen.melon.net.v6x.response.ArtistTemperatureGetMemorialCardRelayRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistTemperatureGetMemorialCardRelayRes;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import com.iloen.melon.utils.ui.MemorialCardUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.h;
import v9.i;
import va.e0;
import va.e;
import we.n;

@Metadata(d1 = {"\u0000\u00B0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000B\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0016\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000EH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001CJ-\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010 \u001A\u00020\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010#\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b%\u0010&J!\u0010(\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020$2\b\u0010#\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010-\u001A\u0006\u0012\u0002\b\u00030,2\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u000F\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b0\u00101J-\u00107\u001A\u00020\u00132\b\u00103\u001A\u0004\u0018\u0001022\b\u00105\u001A\u0004\u0018\u0001042\b\u00106\u001A\u0004\u0018\u00010\u0016H\u0014\u00A2\u0006\u0004\b7\u00108R\u0014\u0010:\u001A\u0002098\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001A\u00020<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010@R\"\u0010D\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020C0B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001A\u00020F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010H\u00A8\u0006K"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureGetMemorialCardRelayRes;", "requestMemorialCardAsync", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/ArtistFanFanListRes;", "requestFanListAsync", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ArtistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST;", "Lkotlin/collections/ArrayList;", "fanList", "Lie/H;", "getFollowYNInfoFromServer", "(Ljava/util/ArrayList;)V", "", "hasScrolledLine", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "defaultDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "artistId", "Ljava/lang/String;", "artistName", "", "Landroid/graphics/Bitmap;", "blurViewBgMap", "Ljava/util/Map;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Companion", "FanListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailFanListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\b\u0010\f\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$Companion;", "", "<init>", "()V", "TAG", "", "CACHE_KEY_SUB_NAME", "ARG_ARTIST_NAME", "MEMORIAL_CARD_RELAY_PAGE_SIZE", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment;", "artistId", "artistName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailFanListFragment newInstance(@NotNull String s, @Nullable String s1) {
            q.g(s, "artistId");
            ArtistDetailFanListFragment artistDetailFanListFragment0 = new ArtistDetailFanListFragment();
            Bundle bundle0 = Y.c("argItemId", s, "argArtistName", s1);
            bundle0.putBoolean("argIsLoginRequired", true);
            artistDetailFanListFragment0.setArguments(bundle0);
            return artistDetailFanListFragment0;
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0082\u0004\u0018\u00002\u0016\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u00076789:;<B;\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012*\u0010\t\u001A&\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u0003\u0018\u00010\u0007j\u0012\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u0003\u0018\u0001`\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0010J-\u0010\u001B\u001A\u00020\u001A2\b\u0010\u0015\u001A\u0004\u0018\u00010\f2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001F\u0010 \u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b \u0010!J#\u0010%\u001A\u0004\u0018\u00010\u00042\b\u0010#\u001A\u0004\u0018\u00010\"2\u0006\u0010$\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b%\u0010&J\'\u0010(\u001A\u00020\u000E2\u0006\u0010\'\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b(\u0010)J\u0019\u0010*\u001A\u00020\u000E2\b\u0010\u0015\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b*\u0010\u0010R\u0014\u0010+\u001A\u00020\u001D8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001A\u00020\u001D8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001A\u00020\u001D8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b.\u0010,R$\u00100\u001A\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b0\u00101\u001A\u0004\b2\u00103\"\u0004\b4\u00105\u00A8\u0006="}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$ServerDataWrapper;", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "memberKey", "Lie/H;", "moveProfile", "(Ljava/lang/String;)V", "trackTiaraMoveProfile", "()V", "propsOnOff", "trackTiaraFollow", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "vh", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "clearCache", "VIEW_TYPE_CARD_RELAY", "I", "VIEW_TYPE_RECENTLY_LIKE_FAN_LIST", "VIEW_TYPE_RISING_FAN_LIST", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureGetMemorialCardRelayRes$RESPONSE;", "memorialCardRelay", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureGetMemorialCardRelayRes$RESPONSE;", "getMemorialCardRelay", "()Lcom/iloen/melon/net/v6x/response/ArtistTemperatureGetMemorialCardRelayRes$RESPONSE;", "setMemorialCardRelay", "(Lcom/iloen/melon/net/v6x/response/ArtistTemperatureGetMemorialCardRelayRes$RESPONSE;)V", "MemorialCardRelayAdapter", "MemorialCardRelayViewHolder", "RecentlyLikeFanListAdapter", "RecentlyLikeFanListViewHolder", "RisingFanListAdapter", "RisingFanListViewHolder", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class FanListAdapter extends p {
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001EB\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0016\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001C\u001A\u00020\u00102\b\u0010\u0019\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "imageUrl", "Landroid/widget/ImageView;", "thumbIv", "bgIv", "Lie/H;", "drawBlurImage", "(Ljava/lang/String;Landroid/widget/ImageView;Landroid/widget/ImageView;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "MemorialCardItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MemorialCardRelayAdapter extends y {
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\f\u001A\u0004\b\u0017\u0010\u000ER\u0017\u0010\u0018\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001A\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001A\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0013\u001A\u0004\b\u001B\u0010\u0015R\u0017\u0010\u001C\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u0013\u001A\u0004\b\u001D\u0010\u0015R\u0017\u0010\u001E\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u0013\u001A\u0004\b\u001F\u0010\u0015R\u0017\u0010 \u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\f\u001A\u0004\b!\u0010\u000ER\u0017\u0010\"\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\f\u001A\u0004\b#\u0010\u000ER\u0017\u0010$\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b$\u0010\b\u001A\u0004\b%\u0010\nR\u0017\u0010&\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b&\u0010\b\u001A\u0004\b\'\u0010\nR\u0017\u0010(\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b(\u0010\u0013\u001A\u0004\b)\u0010\u0015¨\u0006*"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "bgIv", "Landroid/widget/ImageView;", "getBgIv", "()Landroid/widget/ImageView;", "thumbnailBorderLayout", "Landroid/view/View;", "getThumbnailBorderLayout", "()Landroid/view/View;", "thumbnailLayout", "getThumbnailLayout", "Landroid/widget/TextView;", "centerTv", "Landroid/widget/TextView;", "getCenterTv", "()Landroid/widget/TextView;", "temperatureLayout", "getTemperatureLayout", "temperatureTv", "getTemperatureTv", "titleTv", "getTitleTv", "desc1Tv", "getDesc1Tv", "desc2Tv", "getDesc2Tv", "profileLayout", "getProfileLayout", "profileThumbnail", "getProfileThumbnail", "profileIv", "getProfileIv", "profileDefaultIv", "getProfileDefaultIv", "profileTv", "getProfileTv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class MemorialCardItemViewHolder extends O0 {
                @NotNull
                private final ImageView bgIv;
                @NotNull
                private final TextView centerTv;
                @NotNull
                private final TextView desc1Tv;
                @NotNull
                private final TextView desc2Tv;
                @NotNull
                private final ImageView profileDefaultIv;
                @NotNull
                private final ImageView profileIv;
                @NotNull
                private final View profileLayout;
                @NotNull
                private final View profileThumbnail;
                @NotNull
                private final TextView profileTv;
                @NotNull
                private final View temperatureLayout;
                @NotNull
                private final TextView temperatureTv;
                @NotNull
                private final View thumbnailBorderLayout;
                @NotNull
                private final View thumbnailLayout;
                @NotNull
                private final TextView titleTv;

                public MemorialCardItemViewHolder(@NotNull View view0) {
                    q.g(view0, "view");
                    MemorialCardRelayAdapter.this = artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter0;
                    super(view0);
                    View view1 = view0.findViewById(0x7F0A0105);  // id:bg_iv
                    q.f(view1, "findViewById(...)");
                    this.bgIv = (ImageView)view1;
                    View view2 = view0.findViewById(0x7F0A0B83);  // id:thumbnail_border_layout
                    q.f(view2, "findViewById(...)");
                    this.thumbnailBorderLayout = view2;
                    View view3 = view0.findViewById(0x7F0A0B85);  // id:thumbnail_layout
                    q.f(view3, "findViewById(...)");
                    this.thumbnailLayout = view3;
                    View view4 = view0.findViewById(0x7F0A0240);  // id:center_tv
                    q.f(view4, "findViewById(...)");
                    this.centerTv = (TextView)view4;
                    View view5 = this.itemView.findViewById(0x7F0A0B46);  // id:temperature_layout
                    q.f(view5, "findViewById(...)");
                    this.temperatureLayout = view5;
                    View view6 = this.itemView.findViewById(0x7F0A0B47);  // id:temperature_tv
                    q.f(view6, "findViewById(...)");
                    this.temperatureTv = (TextView)view6;
                    View view7 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                    q.f(view7, "findViewById(...)");
                    this.titleTv = (TextView)view7;
                    View view8 = view0.findViewById(0x7F0A03A4);  // id:desc1_tv
                    q.f(view8, "findViewById(...)");
                    this.desc1Tv = (TextView)view8;
                    View view9 = view0.findViewById(0x7F0A03A6);  // id:desc2_tv
                    q.f(view9, "findViewById(...)");
                    this.desc2Tv = (TextView)view9;
                    View view10 = view0.findViewById(0x7F0A096D);  // id:profile_layout
                    q.f(view10, "findViewById(...)");
                    this.profileLayout = view10;
                    View view11 = view0.findViewById(0x7F0A096E);  // id:profile_thumbnail
                    q.f(view11, "findViewById(...)");
                    this.profileThumbnail = view11;
                    View view12 = view11.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                    q.f(view12, "findViewById(...)");
                    this.profileIv = (ImageView)view12;
                    View view13 = view11.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                    q.f(view13, "findViewById(...)");
                    this.profileDefaultIv = (ImageView)view13;
                    View view14 = view0.findViewById(0x7F0A096F);  // id:profile_tv
                    q.f(view14, "findViewById(...)");
                    this.profileTv = (TextView)view14;
                    ViewUtils.setDefaultImage(((ImageView)view13), ScreenUtils.dipToPixel(artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter0.getContext(), 30.0f), true);
                }

                @NotNull
                public final ImageView getBgIv() {
                    return this.bgIv;
                }

                @NotNull
                public final TextView getCenterTv() {
                    return this.centerTv;
                }

                @NotNull
                public final TextView getDesc1Tv() {
                    return this.desc1Tv;
                }

                @NotNull
                public final TextView getDesc2Tv() {
                    return this.desc2Tv;
                }

                @NotNull
                public final ImageView getProfileDefaultIv() {
                    return this.profileDefaultIv;
                }

                @NotNull
                public final ImageView getProfileIv() {
                    return this.profileIv;
                }

                @NotNull
                public final View getProfileLayout() {
                    return this.profileLayout;
                }

                @NotNull
                public final View getProfileThumbnail() {
                    return this.profileThumbnail;
                }

                @NotNull
                public final TextView getProfileTv() {
                    return this.profileTv;
                }

                @NotNull
                public final View getTemperatureLayout() {
                    return this.temperatureLayout;
                }

                @NotNull
                public final TextView getTemperatureTv() {
                    return this.temperatureTv;
                }

                @NotNull
                public final View getThumbnailBorderLayout() {
                    return this.thumbnailBorderLayout;
                }

                @NotNull
                public final View getThumbnailLayout() {
                    return this.thumbnailLayout;
                }

                @NotNull
                public final TextView getTitleTv() {
                    return this.titleTv;
                }
            }

            public MemorialCardRelayAdapter(@NotNull Context context0, @NotNull ArrayList arrayList0) {
                q.g(context0, "context");
                q.g(arrayList0, "list");
                FanListAdapter.this = artistDetailFanListFragment$FanListAdapter0;
                super(context0, arrayList0);
            }

            private final void drawBlurImage(String s, ImageView imageView0, ImageView imageView1) {
                Glide.with(this.getContext()).asBitmap().load(s).into(new CustomTarget() {
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                        q.g(bitmap0, "resource");
                        ImageView imageView0 = this;
                        if(imageView0 instanceof BorderImageView) {
                            q.d(Glide.with(ArtistDetailFanListFragment.this.getContext()).load(bitmap0).apply(RequestOptions.circleCropTransform()).into(this));
                        }
                        else {
                            imageView0.setImageBitmap(bitmap0);
                        }
                        Bitmap bitmap1 = (Bitmap)s.blurViewBgMap.get(imageView1);
                        if(bitmap1 != null) {
                            this.$bgIv.setImageBitmap(bitmap1);
                            return;
                        }
                        ArtistDetailFanListFragment artistDetailFanListFragment0 = s;
                        MemorialCardRelayAdapter artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter0 = ArtistDetailFanListFragment.this;
                        String s = imageView1;
                        ImageView imageView1 = this.$bgIv;
                        if(artistDetailFanListFragment0.getView() != null) {
                            D d0 = artistDetailFanListFragment0.getViewLifecycleOwner();
                            q.f(d0, "getViewLifecycleOwner(...)");
                            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getDefault(), null, new n(bitmap0, artistDetailFanListFragment0, s, imageView1, null) {
                                final ImageView $bgIv;
                                final String $imageUrl;
                                final Bitmap $resource;
                                int label;

                                {
                                    MemorialCardRelayAdapter.this = artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter0;
                                    this.$resource = bitmap0;
                                    ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
                                    this.$imageUrl = s;
                                    this.$bgIv = imageView0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.MemorialCardRelayAdapter.drawBlurImage.1.onResourceReady.2.1(MemorialCardRelayAdapter.this, this.$resource, ArtistDetailFanListFragment.this, this.$imageUrl, this.$bgIv, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.MemorialCardRelayAdapter.drawBlurImage.1.onResourceReady.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    Context context0 = MemorialCardRelayAdapter.this.getContext();
                                    q.f(context0, "access$getContext(...)");
                                    Bitmap bitmap0 = com.iloen.melon.utils.ui.LyricHighlightUtils.Companion.drawPalette$default(LyricHighlightUtils.Companion, context0, this.$resource, false, false, 12, null);
                                    ArtistDetailFanListFragment.this.blurViewBgMap.put(this.$imageUrl, bitmap0);
                                    H h0 = H.a;
                                    if(ArtistDetailFanListFragment.this.getView() == null) {
                                        return h0;
                                    }
                                    D d0 = ArtistDetailFanListFragment.this.getViewLifecycleOwner();
                                    q.f(d0, "getViewLifecycleOwner(...)");
                                    BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new n(bitmap0, null) {
                                        final Bitmap $bgBitmap;
                                        final ImageView $bgIv;
                                        int label;

                                        {
                                            this.$bgIv = imageView0;
                                            this.$bgBitmap = bitmap0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.MemorialCardRelayAdapter.drawBlurImage.1.onResourceReady.2.1.1(this.$bgIv, this.$bgBitmap, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.MemorialCardRelayAdapter.drawBlurImage.1.onResourceReady.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            if(this.label != 0) {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                            d5.n.D(object0);
                                            this.$bgIv.setImageBitmap(this.$bgBitmap);
                                            return H.a;
                                        }
                                    }, 2, null);
                                    return h0;
                                }
                            }, 2, null);
                        }
                    }

                    @Override  // com.bumptech.glide.request.target.Target
                    public void onResourceReady(Object object0, Transition transition0) {
                        this.onResourceReady(((Bitmap)object0), transition0);
                    }
                });
            }

            @Override  // com.iloen.melon.adapters.common.y
            public void onBindViewHolder(@Nullable O0 o00, int v, int v1) {
                String s7;
                MEMORIALCARDRELAYLIST artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0 = (MEMORIALCARDRELAYLIST)this.getItem(v1);
                q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.MemorialCardRelayAdapter.MemorialCardItemViewHolder");
                MemorialCardItemViewHolder artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0 = (MemorialCardItemViewHolder)o00;
                FanListAdapter artistDetailFanListFragment$FanListAdapter0 = FanListAdapter.this;
                ArtistDetailFanListFragment artistDetailFanListFragment0 = ArtistDetailFanListFragment.this;
                TextView textView0 = ((MemorialCardItemViewHolder)o00).getTitleTv();
                String s = artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.type;
                q.f(s, "type");
                textView0.setText(MemorialCardUtils.Companion.getMemorialTitle(this.getContext(), s));
                if(q.b(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.type, "DEBUT_DAY")) {
                    TextView textView1 = ((MemorialCardItemViewHolder)o00).getTitleTv();
                    q.f("%1$s ANNIVERSARY", "getString(...)");
                    Z.y(new Object[]{artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.years}, 1, "%1$s ANNIVERSARY", textView1);
                }
                else if(q.b(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.type, "BIRTH_DAY")) {
                    ((MemorialCardItemViewHolder)o00).getTitleTv().setText(artistDetailFanListFragment0.getString(0x7F13015F));  // string:artist_memorial_happy_birthday "HAPPY BIRTHDAY"
                }
                ((MemorialCardItemViewHolder)o00).getThumbnailBorderLayout().setVisibility(8);
                ((MemorialCardItemViewHolder)o00).getThumbnailLayout().setVisibility(8);
                ((MemorialCardItemViewHolder)o00).getCenterTv().setVisibility(8);
                ((MemorialCardItemViewHolder)o00).getTemperatureLayout().setVisibility(8);
                String s1 = artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.type;
                if(s1 == null) {
                    artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getCenterTv().setVisibility(0);
                    Glide.with(this.getContext()).load(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.bgImg).into(artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getBgIv());
                    artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getCenterTv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date);
                }
                else {
                    switch(s1) {
                        case "BIRTH_DAY": 
                        case "DEBUT_DAY": 
                        case "FAN_DAY": {
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getThumbnailBorderLayout().setVisibility(0);
                            View view0 = artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getThumbnailBorderLayout().findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                            q.f(view0, "findViewById(...)");
                            View view1 = artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getThumbnailBorderLayout().findViewById(0x7F0A069B);  // id:iv_thumb_circle
                            q.f(view1, "findViewById(...)");
                            ViewUtils.setDefaultImage(((ImageView)view0), ScreenUtils.dipToPixel(this.getContext(), 84.0f), true);
                            String s2 = artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.artistImg;
                            q.f(s2, "artistImg");
                            this.drawBlurImage(s2, ((ImageView)view1), artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getBgIv());
                            break;
                        }
                        case "FIRST_LIKE_SONG": 
                        case "FIRST_SONG": 
                        case "LAST_SONG": {
                            ((MemorialCardItemViewHolder)o00).getThumbnailLayout().setVisibility(0);
                            View view2 = ((MemorialCardItemViewHolder)o00).getThumbnailLayout().findViewById(0x7F0A069E);  // id:iv_thumb_default
                            q.f(view2, "findViewById(...)");
                            View view3 = ((MemorialCardItemViewHolder)o00).getThumbnailLayout().findViewById(0x7F0A069A);  // id:iv_thumb
                            q.f(view3, "findViewById(...)");
                            ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(this.getContext(), 84.0f));
                            String s3 = artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.albumImg;
                            q.f(s3, "albumImg");
                            this.drawBlurImage(s3, ((ImageView)view3), artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getBgIv());
                            break;
                        }
                        case "HOT_DAY": {
                            ((MemorialCardItemViewHolder)o00).getTemperatureLayout().setVisibility(0);
                            Glide.with(this.getContext()).load(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.bgImg).into(((MemorialCardItemViewHolder)o00).getBgIv());
                            ((MemorialCardItemViewHolder)o00).getTemperatureTv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.userMaxTemper);
                            ((MemorialCardItemViewHolder)o00).getTemperatureTv().setContentDescription(artistDetailFanListFragment0.getString(0x7F130C6D, new Object[]{artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.userMaxTemper}));  // string:talkback_temperature_degree "친밀도 %1$s도"
                            break;
                        }
                        default: {
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getCenterTv().setVisibility(0);
                            Glide.with(this.getContext()).load(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.bgImg).into(artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getBgIv());
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getCenterTv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date);
                        }
                    }
                }
                String s4 = artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.type;
                if(s4 != null) {
                    switch(s4) {
                        case "BIRTH_DAY": {
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc1Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date);
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv().setText(artistDetailFanListFragment0.getString(0x7F130160));  // string:artist_memorial_happy_birthday2 "생일을 축하합니다 ♡"
                            break;
                        }
                        case "DEBUT_DAY": {
                            String s5 = artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date;
                            if(s5.length() >= 10) {
                                String s6 = artistDetailFanListFragment0.getString(0x7F130170);  // string:artist_memorial_year_month_day "%1$s년 %2$s월 %3$s일"
                                q.f(s6, "getString(...)");
                                s5 = String.format(s6, Arrays.copyOf(new Object[]{o.V0(s5, new g(0, 3, 1)), o.V0(s5, new g(5, 6, 1)), o.V0(s5, new g(8, 9, 1))}, 3));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                            }
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc1Tv().setText(s5);
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv().setText(artistDetailFanListFragment0.getString(0x7F130169));  // string:artist_memorial_of_debut_day2 "오늘은 데뷔기념일"
                            break;
                        }
                        case "FAN_DAY": {
                            String s10 = artistDetailFanListFragment0.getString(0x7F13015B);  // string:artist_memorial_fan_day_desc "만난지 %1$s일 째"
                            q.f(s10, "getString(...)");
                            Z.y(new Object[]{artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.days}, 1, s10, artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc1Tv());
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date);
                            break;
                        }
                        case "FIRST_LIKE_SONG": 
                        case "FIRST_SONG": 
                        case "LAST_SONG": {
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc1Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.songName);
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date);
                            break;
                        }
                        case "HOT_DAY": {
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc1Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.artistName);
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date);
                            break;
                        }
                        case "MAX_MONTH": {
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc1Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.artistName);
                            String s9 = artistDetailFanListFragment0.getString(0x7F130166);  // string:artist_memorial_max_month_desc "%1$s회 감상"
                            q.f(s9, "getString(...)");
                            Z.y(new Object[]{artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.streamCnt}, 1, s9, artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv());
                            break;
                        }
                        case "TEMPERATURE_TOP": {
                            artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc1Tv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.artistName);
                            TextView textView2 = artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv();
                            if(q.b(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.days, "0")) {
                                s7 = artistDetailFanListFragment0.getString(0x7F13016C);  // string:artist_memorial_temperature_top_desc "1% 달성!"
                            }
                            else {
                                String s8 = artistDetailFanListFragment0.getString(0x7F13016D);  // string:artist_memorial_temperature_top_maintain_desc "%1$s일 동안 유지중"
                                q.f(s8, "getString(...)");
                                s7 = String.format(s8, Arrays.copyOf(new Object[]{artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.days}, 1));
                            }
                            textView2.setText(s7);
                        }
                    }
                }
                artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv().setContentDescription(artistDetailFanListFragment0.getString(0x7F130B27, new Object[]{artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getDesc2Tv().getText(), artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.memberName}));  // string:talkback_fanlist_cardrelay "%1$s, 닉네임 : %2$s"
                artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getProfileLayout().setOnClickListener(new d(artistDetailFanListFragment$FanListAdapter0, artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0, artistDetailFanListFragment0, 6));
                ViewUtils.setContentDescriptionWithButtonClassName(artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getProfileLayout(), x.l(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.memberName, " ", artistDetailFanListFragment0.getString(0x7F130899), " ", artistDetailFanListFragment0.getString(0x7F130B8B)));  // string:profile "프로필"
                Glide.with(this.getContext()).load(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.memberImg).apply(RequestOptions.circleCropTransform()).into(artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getProfileIv());
                artistDetailFanListFragment$FanListAdapter$MemorialCardRelayAdapter$MemorialCardItemViewHolder0.getProfileTv().setText(artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.memberName);
            }

            private static final void onBindViewHolder$lambda$2$lambda$1(FanListAdapter artistDetailFanListFragment$FanListAdapter0, MEMORIALCARDRELAYLIST artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0, ArtistDetailFanListFragment artistDetailFanListFragment0, View view0) {
                String s = artistTemperatureGetMemorialCardRelayRes$RESPONSE$MEMORIALCARDRELAYLIST0.memberKey;
                q.f(s, "memberKey");
                artistDetailFanListFragment$FanListAdapter0.moveProfile(s);
                s s1 = artistDetailFanListFragment0.mMelonTiaraProperty;
                if(s1 != null) {
                    p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                    g0.I = s1.c;
                    g0.a = artistDetailFanListFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                    g0.b = s1.a;
                    g0.c = s1.b;
                    g0.d = ActionKind.ClickContent;
                    g0.y = artistDetailFanListFragment0.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
                    g0.F = artistDetailFanListFragment0.getString(0x7F130D82);  // string:tiara_click_copy_profile "프로필"
                    g0.o = artistDetailFanListFragment0.artistId;
                    g0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
                    g0.q = artistDetailFanListFragment0.artistName;
                    g0.a().track();
                }
            }

            @Override  // androidx.recyclerview.widget.j0
            @NotNull
            public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
                q.g(viewGroup0, "parent");
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0459, viewGroup0, false);  // layout:listitem_artist_fan_list_memorial_card
                q.f(view0, "inflate(...)");
                return new MemorialCardItemViewHolder(this, view0);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001A\u0004\b\u0011\u0010\nR\u0017\u0010\u0012\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\b\u001A\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$MemorialCardRelayViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "Landroidx/recyclerview/widget/RecyclerView;", "itemContainer", "Landroidx/recyclerview/widget/RecyclerView;", "getItemContainer", "()Landroidx/recyclerview/widget/RecyclerView;", "tvJoinCardRelay", "getTvJoinCardRelay", "emptyLayout", "Landroid/view/View;", "getEmptyLayout", "()Landroid/view/View;", "temperatureBtn", "getTemperatureBtn", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MemorialCardRelayViewHolder extends O0 {
            @NotNull
            private final View emptyLayout;
            @NotNull
            private final RecyclerView itemContainer;
            @NotNull
            private final TextView temperatureBtn;
            @NotNull
            private final TextView tvJoinCardRelay;
            @NotNull
            private final TextView tvTitle;

            public MemorialCardRelayViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                FanListAdapter.this = artistDetailFanListFragment$FanListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view1, "findViewById(...)");
                this.tvTitle = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A05A7);  // id:item_container
                q.f(view2, "findViewById(...)");
                this.itemContainer = (RecyclerView)view2;
                View view3 = view0.findViewById(0x7F0A0C95);  // id:tv_join_card_relay
                q.f(view3, "findViewById(...)");
                this.tvJoinCardRelay = (TextView)view3;
                View view4 = view0.findViewById(0x7F0A042B);  // id:empty_layout
                q.f(view4, "findViewById(...)");
                this.emptyLayout = view4;
                View view5 = view0.findViewById(0x7F0A0B42);  // id:temperature_btn
                q.f(view5, "findViewById(...)");
                this.temperatureBtn = (TextView)view5;
                ((RecyclerView)view2).setHasFixedSize(true);
                ((RecyclerView)view2).addItemDecoration(new O());  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @NotNull
            public final View getEmptyLayout() {
                return this.emptyLayout;
            }

            @NotNull
            public final RecyclerView getItemContainer() {
                return this.itemContainer;
            }

            @NotNull
            public final TextView getTemperatureBtn() {
                return this.temperatureBtn;
            }

            @NotNull
            public final TextView getTvJoinCardRelay() {
                return this.tvJoinCardRelay;
            }

            @NotNull
            public final TextView getTvTitle() {
                return this.tvTitle;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001BB\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0016\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00020\u00032\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ArtistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_FAN_LIST", "I", "FanItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class RecentlyLikeFanListAdapter extends p {
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001A\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001A\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0007\u001A\u0004\b\u001B\u0010\tR\u0017\u0010\u001C\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u0007\u001A\u0004\b\u001D\u0010\t¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter;Landroid/view/View;)V", "itemContainer", "Landroid/view/View;", "getItemContainer", "()Landroid/view/View;", "Landroid/widget/ImageView;", "defaultIv", "Landroid/widget/ImageView;", "getDefaultIv", "()Landroid/widget/ImageView;", "thumbIv", "getThumbIv", "Landroid/widget/TextView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "detailLeftTv", "getDetailLeftTv", "detailRightTv", "getDetailRightTv", "followLayout", "getFollowLayout", "followingLayout", "getFollowingLayout", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class FanItemViewHolder extends O0 {
                @NotNull
                private final ImageView defaultIv;
                @NotNull
                private final TextView detailLeftTv;
                @NotNull
                private final TextView detailRightTv;
                @NotNull
                private final View followLayout;
                @NotNull
                private final View followingLayout;
                @NotNull
                private final View itemContainer;
                @NotNull
                private final TextView nameTv;
                @NotNull
                private final ImageView thumbIv;

                public FanItemViewHolder(@NotNull View view0) {
                    q.g(view0, "view");
                    RecentlyLikeFanListAdapter.this = artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0;
                    super(view0);
                    View view1 = view0.findViewById(0x7F0A05A7);  // id:item_container
                    q.f(view1, "findViewById(...)");
                    this.itemContainer = view1;
                    View view2 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                    q.f(view2, "findViewById(...)");
                    this.defaultIv = (ImageView)view2;
                    View view3 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                    q.f(view3, "findViewById(...)");
                    this.thumbIv = (ImageView)view3;
                    View view4 = view0.findViewById(0x7F0A0894);  // id:name_tv
                    q.f(view4, "findViewById(...)");
                    this.nameTv = (TextView)view4;
                    View view5 = view0.findViewById(0x7F0A03BD);  // id:detail_left_tv
                    q.f(view5, "findViewById(...)");
                    this.detailLeftTv = (TextView)view5;
                    View view6 = view0.findViewById(0x7F0A03BE);  // id:detail_right_tv
                    q.f(view6, "findViewById(...)");
                    this.detailRightTv = (TextView)view6;
                    View view7 = view0.findViewById(0x7F0A04D2);  // id:follow_layout
                    q.f(view7, "findViewById(...)");
                    this.followLayout = view7;
                    View view8 = view0.findViewById(0x7F0A04D6);  // id:following_layout
                    q.f(view8, "findViewById(...)");
                    this.followingLayout = view8;
                    ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0.getContext(), 64.0f), true);
                    ((ImageView)view3).setImportantForAccessibility(2);
                }

                @NotNull
                public final ImageView getDefaultIv() {
                    return this.defaultIv;
                }

                @NotNull
                public final TextView getDetailLeftTv() {
                    return this.detailLeftTv;
                }

                @NotNull
                public final TextView getDetailRightTv() {
                    return this.detailRightTv;
                }

                @NotNull
                public final View getFollowLayout() {
                    return this.followLayout;
                }

                @NotNull
                public final View getFollowingLayout() {
                    return this.followingLayout;
                }

                @NotNull
                public final View getItemContainer() {
                    return this.itemContainer;
                }

                @NotNull
                public final TextView getNameTv() {
                    return this.nameTv;
                }

                @NotNull
                public final ImageView getThumbIv() {
                    return this.thumbIv;
                }
            }

            private final int VIEW_TYPE_FAN_LIST;

            public RecentlyLikeFanListAdapter(@NotNull Context context0, @NotNull ArrayList arrayList0) {
                q.g(context0, "context");
                q.g(arrayList0, "list");
                FanListAdapter.this = artistDetailFanListFragment$FanListAdapter0;
                super(context0, arrayList0);
                this.VIEW_TYPE_FAN_LIST = 1;
            }

            @Override  // com.iloen.melon.adapters.common.p
            public int getItemViewTypeImpl(int v, int v1) {
                return this.VIEW_TYPE_FAN_LIST;
            }

            @Override  // com.iloen.melon.adapters.common.p
            public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
                Object object0 = this.getItem(v1);
                q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RecentlyLikeFanListAdapter.FanItemViewHolder");
                FanListAdapter artistDetailFanListFragment$FanListAdapter0 = FanListAdapter.this;
                ArtistDetailFanListFragment artistDetailFanListFragment0 = ArtistDetailFanListFragment.this;
                Glide.with(this.getContext()).load(((RECENTLYLIKEFANLIST)object0).myPageImg).apply(RequestOptions.circleCropTransform()).into(((FanItemViewHolder)o00).getThumbIv());
                ((FanItemViewHolder)o00).getNameTv().setText(((RECENTLYLIKEFANLIST)object0).memberNickname);
                ((FanItemViewHolder)o00).getDetailLeftTv().setText(((RECENTLYLIKEFANLIST)object0).recmdText);
                ((FanItemViewHolder)o00).getDetailRightTv().setText(((RECENTLYLIKEFANLIST)object0).contsName);
                ((FanItemViewHolder)o00).getThumbIv().setOnClickListener(new u(((RECENTLYLIKEFANLIST)object0), artistDetailFanListFragment$FanListAdapter0, 0));
                ((FanItemViewHolder)o00).getNameTv().setOnClickListener(new u(((RECENTLYLIKEFANLIST)object0), artistDetailFanListFragment$FanListAdapter0, 1));
                if(q.b(((RECENTLYLIKEFANLIST)object0).followYN, "Y")) {
                    ((FanItemViewHolder)o00).getFollowLayout().setVisibility(8);
                    ((FanItemViewHolder)o00).getFollowingLayout().setVisibility(0);
                }
                else if(q.b(((RECENTLYLIKEFANLIST)object0).followYN, "N")) {
                    ((FanItemViewHolder)o00).getFollowLayout().setVisibility(0);
                    ((FanItemViewHolder)o00).getFollowingLayout().setVisibility(8);
                }
                ((FanItemViewHolder)o00).getFollowingLayout().setOnClickListener(new v(artistDetailFanListFragment0, ((RECENTLYLIKEFANLIST)object0), this, artistDetailFanListFragment$FanListAdapter0, ((FanItemViewHolder)o00), 0));
                ((FanItemViewHolder)o00).getFollowLayout().setOnClickListener(new v(artistDetailFanListFragment0, ((RECENTLYLIKEFANLIST)object0), this, artistDetailFanListFragment$FanListAdapter0, ((FanItemViewHolder)o00), 1));
                ((FanItemViewHolder)o00).getItemContainer().setAccessibilityDelegate(new View.AccessibilityDelegate() {
                    @Override  // android.view.View$AccessibilityDelegate
                    public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                        q.g(view0, "host");
                        q.g(accessibilityNodeInfo0, "info");
                        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                        if(artistDetailFanListFragment0.getContext() == null) {
                            return;
                        }
                        ArtistDetailFanListFragment artistDetailFanListFragment0 = ((RECENTLYLIKEFANLIST)object0);
                        RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0 = ((FanItemViewHolder)o00);
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130B91, artistDetailFanListFragment0.getString(0x7F130B91)));  // string:talkback_move_profile "프로필 이동"
                        if(q.b(artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.followYN, "Y")) {
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130AE0, artistDetailFanListFragment0.getString(0x7F130AE0)));  // string:talkback_cancle_follow "팔로우 취소하기"
                            String s = artistDetailFanListFragment0.getString(0x7F130C1A);  // string:talkback_recently_like_fan_item_follow "%1$s, 팬 정보 : %2$s %3$s, 팔로우 상태"
                            q.f(s, "getString(...)");
                            accessibilityNodeInfo0.setContentDescription(String.format(s, Arrays.copyOf(new Object[]{artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.memberNickname, artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.recmdText, artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.contsName}, 3)));
                        }
                        else {
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130B18, artistDetailFanListFragment0.getString(0x7F130B18)));  // string:talkback_do_follow "팔로우 하기"
                            String s1 = artistDetailFanListFragment0.getString(0x7F130C19);  // string:talkback_recently_like_fan_item "%1$s, 팬 정보 : %2$s %3$s"
                            q.f(s1, "getString(...)");
                            accessibilityNodeInfo0.setContentDescription(String.format(s1, Arrays.copyOf(new Object[]{artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.memberNickname, artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.recmdText, artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.contsName}, 3)));
                        }
                        accessibilityNodeInfo0.setClassName("android.widget.Button");
                    }

                    @Override  // android.view.View$AccessibilityDelegate
                    public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                        q.g(view0, "host");
                        switch(v) {
                            case 0x7F130AE0: {  // string:talkback_cancle_follow "팔로우 취소하기"
                                this.$this_apply.getFollowingLayout().performClick();
                                return true;
                            }
                            case 0x7F130B18: {  // string:talkback_do_follow "팔로우 하기"
                                this.$this_apply.getFollowLayout().performClick();
                                return true;
                            }
                            case 0x7F130B91: {  // string:talkback_move_profile "프로필 이동"
                                this.$this_apply.getThumbIv().performClick();
                                return true;
                            }
                            default: {
                                return super.performAccessibilityAction(view0, v, bundle0);
                            }
                        }
                    }
                });

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$onBindViewImpl$1$3$1", "LX8/a;", "", "errorMsg", "Lie/H;", "onJobComplete", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public final class com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RecentlyLikeFanListAdapter.onBindViewImpl.1.3.1 implements a {
                    public com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RecentlyLikeFanListAdapter.onBindViewImpl.1.3.1(ArtistDetailFanListFragment artistDetailFanListFragment0, RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, FanItemViewHolder artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0) {
                    }

                    @Override  // X8.a
                    public void onJobComplete(String s) {
                        if(ArtistDetailFanListFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                            this.$item.followYN = "N";
                            this.$this_apply.getFollowLayout().setVisibility(0);
                            this.$this_apply.getFollowingLayout().setVisibility(8);
                        }
                    }
                }


                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$onBindViewImpl$1$4$1", "LX8/a;", "", "errorMsg", "Lie/H;", "onJobComplete", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public final class com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RecentlyLikeFanListAdapter.onBindViewImpl.1.4.1 implements a {
                    public com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RecentlyLikeFanListAdapter.onBindViewImpl.1.4.1(ArtistDetailFanListFragment artistDetailFanListFragment0, RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, FanItemViewHolder artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0) {
                    }

                    @Override  // X8.a
                    public void onJobComplete(String s) {
                        if(ArtistDetailFanListFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                            this.$item.followYN = "Y";
                            this.$this_apply.getFollowLayout().setVisibility(8);
                            this.$this_apply.getFollowingLayout().setVisibility(0);
                        }
                    }
                }

            }

            private static final void onBindViewImpl$lambda$4$lambda$0(RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, FanListAdapter artistDetailFanListFragment$FanListAdapter0, View view0) {
                Navigator.openUserMain(artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.memberKey);
                artistDetailFanListFragment$FanListAdapter0.trackTiaraMoveProfile();
            }

            private static final void onBindViewImpl$lambda$4$lambda$1(RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, FanListAdapter artistDetailFanListFragment$FanListAdapter0, View view0) {
                Navigator.openUserMain(artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.memberKey);
                artistDetailFanListFragment$FanListAdapter0.trackTiaraMoveProfile();
            }

            private static final void onBindViewImpl$lambda$4$lambda$2(ArtistDetailFanListFragment artistDetailFanListFragment0, RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, RecentlyLikeFanListAdapter artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0, FanListAdapter artistDetailFanListFragment$FanListAdapter0, FanItemViewHolder artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0, View view0) {
                artistDetailFanListFragment0.addOrDeleteFriend(artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.memberKey, artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0.getMenuId(), false, new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RecentlyLikeFanListAdapter.onBindViewImpl.1.3.1(artistDetailFanListFragment0, artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0));
                String s = artistDetailFanListFragment0.getString(0x7F130FCE);  // string:tiara_props_off "off"
                q.f(s, "getString(...)");
                artistDetailFanListFragment$FanListAdapter0.trackTiaraFollow(s);
            }

            private static final void onBindViewImpl$lambda$4$lambda$3(ArtistDetailFanListFragment artistDetailFanListFragment0, RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, RecentlyLikeFanListAdapter artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0, FanListAdapter artistDetailFanListFragment$FanListAdapter0, FanItemViewHolder artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0, View view0) {
                artistDetailFanListFragment0.addOrDeleteFriend(artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.memberKey, artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter0.getMenuId(), true, new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RecentlyLikeFanListAdapter.onBindViewImpl.1.4.1(artistDetailFanListFragment0, artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0, artistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListAdapter$FanItemViewHolder0));
                String s = artistDetailFanListFragment0.getString(0x7F130FCF);  // string:tiara_props_on "on"
                q.f(s, "getString(...)");
                artistDetailFanListFragment$FanListAdapter0.trackTiaraFollow(s);
            }

            @Override  // com.iloen.melon.adapters.common.p
            @NotNull
            public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D048A, viewGroup0, false);  // layout:listitem_detail_user
                q.f(view0, "inflate(...)");
                return new FanItemViewHolder(this, view0);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RecentlyLikeFanListViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "titleView", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "getTitleView", "()Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "Landroidx/recyclerview/widget/RecyclerView;", "itemContainer", "Landroidx/recyclerview/widget/RecyclerView;", "getItemContainer", "()Landroidx/recyclerview/widget/RecyclerView;", "emptyLayout", "Landroid/view/View;", "getEmptyLayout", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class RecentlyLikeFanListViewHolder extends O0 {
            @NotNull
            private final View emptyLayout;
            @NotNull
            private final RecyclerView itemContainer;
            @NotNull
            private final MainTabTitleView titleView;

            public RecentlyLikeFanListViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                FanListAdapter.this = artistDetailFanListFragment$FanListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A07CA);  // id:main_contents_title
                q.f(view1, "findViewById(...)");
                this.titleView = (MainTabTitleView)view1;
                View view2 = view0.findViewById(0x7F0A05A7);  // id:item_container
                q.f(view2, "findViewById(...)");
                this.itemContainer = (RecyclerView)view2;
                View view3 = view0.findViewById(0x7F0A042B);  // id:empty_layout
                q.f(view3, "findViewById(...)");
                this.emptyLayout = view3;
            }

            @NotNull
            public final View getEmptyLayout() {
                return this.emptyLayout;
            }

            @NotNull
            public final RecyclerView getItemContainer() {
                return this.itemContainer;
            }

            @NotNull
            public final MainTabTitleView getTitleView() {
                return this.titleView;
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0016\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000F\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J)\u0010\u0015\u001A\u00020\u00142\b\u0010\u0011\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RisingFanListAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/net/v6x/response/ArtistFanFanListRes$RESPONSE$RISINGFANLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;Landroid/content/Context;Ljava/util/ArrayList;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "RisingFanItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class RisingFanListAdapter extends y {
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\f\u001A\u0004\b\u0019\u0010\u000ER\u0017\u0010\u001A\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0013\u001A\u0004\b\u001B\u0010\u0015¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RisingFanListAdapter$RisingFanItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RisingFanListAdapter;Landroid/view/View;)V", "profileLayout", "Landroid/view/View;", "getProfileLayout", "()Landroid/view/View;", "Landroid/widget/ImageView;", "defaultIv", "Landroid/widget/ImageView;", "getDefaultIv", "()Landroid/widget/ImageView;", "thumbIv", "getThumbIv", "Landroid/widget/TextView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "temperatureTv", "getTemperatureTv", "temperatureIv", "getTemperatureIv", "temperatureGapTv", "getTemperatureGapTv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class RisingFanItemViewHolder extends O0 {
                @NotNull
                private final ImageView defaultIv;
                @NotNull
                private final TextView nameTv;
                @NotNull
                private final View profileLayout;
                @NotNull
                private final TextView temperatureGapTv;
                @NotNull
                private final ImageView temperatureIv;
                @NotNull
                private final TextView temperatureTv;
                @NotNull
                private final ImageView thumbIv;

                public RisingFanItemViewHolder(@NotNull View view0) {
                    q.g(view0, "view");
                    RisingFanListAdapter.this = artistDetailFanListFragment$FanListAdapter$RisingFanListAdapter0;
                    super(view0);
                    View view1 = view0.findViewById(0x7F0A096D);  // id:profile_layout
                    q.f(view1, "findViewById(...)");
                    this.profileLayout = view1;
                    View view2 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                    q.f(view2, "findViewById(...)");
                    this.defaultIv = (ImageView)view2;
                    View view3 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                    q.f(view3, "findViewById(...)");
                    this.thumbIv = (ImageView)view3;
                    View view4 = view0.findViewById(0x7F0A0894);  // id:name_tv
                    q.f(view4, "findViewById(...)");
                    this.nameTv = (TextView)view4;
                    View view5 = view0.findViewById(0x7F0A0B47);  // id:temperature_tv
                    q.f(view5, "findViewById(...)");
                    this.temperatureTv = (TextView)view5;
                    View view6 = view0.findViewById(0x7F0A0B45);  // id:temperature_iv
                    q.f(view6, "findViewById(...)");
                    this.temperatureIv = (ImageView)view6;
                    View view7 = view0.findViewById(0x7F0A0B44);  // id:temperature_gap_tv
                    q.f(view7, "findViewById(...)");
                    this.temperatureGapTv = (TextView)view7;
                    ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(artistDetailFanListFragment$FanListAdapter$RisingFanListAdapter0.getContext(), 100.0f), true);
                }

                @NotNull
                public final ImageView getDefaultIv() {
                    return this.defaultIv;
                }

                @NotNull
                public final TextView getNameTv() {
                    return this.nameTv;
                }

                @NotNull
                public final View getProfileLayout() {
                    return this.profileLayout;
                }

                @NotNull
                public final TextView getTemperatureGapTv() {
                    return this.temperatureGapTv;
                }

                @NotNull
                public final ImageView getTemperatureIv() {
                    return this.temperatureIv;
                }

                @NotNull
                public final TextView getTemperatureTv() {
                    return this.temperatureTv;
                }

                @NotNull
                public final ImageView getThumbIv() {
                    return this.thumbIv;
                }
            }

            public RisingFanListAdapter(@NotNull Context context0, @NotNull ArrayList arrayList0) {
                q.g(context0, "context");
                q.g(arrayList0, "list");
                FanListAdapter.this = artistDetailFanListFragment$FanListAdapter0;
                super(context0, arrayList0);
            }

            @Override  // com.iloen.melon.adapters.common.y
            public void onBindViewHolder(@Nullable O0 o00, int v, int v1) {
                RISINGFANLIST artistFanFanListRes$RESPONSE$RISINGFANLIST0 = (RISINGFANLIST)this.getItem(v1);
                q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.RisingFanListAdapter.RisingFanItemViewHolder");
                ((RisingFanItemViewHolder)o00).getProfileLayout().setOnClickListener(new d(FanListAdapter.this, artistFanFanListRes$RESPONSE$RISINGFANLIST0, ArtistDetailFanListFragment.this, 7));
                Glide.with(this.getContext()).load(artistFanFanListRes$RESPONSE$RISINGFANLIST0.myPageImg).apply(RequestOptions.circleCropTransform()).into(((RisingFanItemViewHolder)o00).getThumbIv());
                ((RisingFanItemViewHolder)o00).getNameTv().setText(artistFanFanListRes$RESPONSE$RISINGFANLIST0.memberNickname);
                ((RisingFanItemViewHolder)o00).getTemperatureTv().setText(artistFanFanListRes$RESPONSE$RISINGFANLIST0.temperature);
                TextView textView0 = ((RisingFanItemViewHolder)o00).getTemperatureTv();
                String s = artistFanFanListRes$RESPONSE$RISINGFANLIST0.temperature;
                q.f(s, "temperature");
                textView0.setTextColor(ResourceUtils.getFriendlyColorId(this.getContext(), Integer.parseInt(s)));
                ImageView imageView0 = ((RisingFanItemViewHolder)o00).getTemperatureIv();
                String s1 = artistFanFanListRes$RESPONSE$RISINGFANLIST0.temperature;
                q.f(s1, "temperature");
                imageView0.setImageResource(ResourceUtils.get4dpDegreeImageResId(Integer.parseInt(s1)));
                TextView textView1 = ((RisingFanItemViewHolder)o00).getTemperatureGapTv();
                String s2 = ArtistDetailFanListFragment.this.getString(0x7F13013D);  // string:artist_fan_list_rising_temperature_gap "+%1$s"
                q.f(s2, "getString(...)");
                Z.y(new Object[]{artistFanFanListRes$RESPONSE$RISINGFANLIST0.temperatureGap}, 1, s2, textView1);
                Context context0 = this.getContext();
                String s3 = context0 == null ? null : context0.getString(0x7F130C24, new Object[]{artistFanFanListRes$RESPONSE$RISINGFANLIST0.memberNickname, artistFanFanListRes$RESPONSE$RISINGFANLIST0.temperature, artistFanFanListRes$RESPONSE$RISINGFANLIST0.temperatureGap});  // string:talkback_rising_fan_item "%1$s, 친밀도 %2$s도, +%3$s도 상승"
                ViewUtils.setContentDescriptionWithButtonClassName(((RisingFanItemViewHolder)o00).itemView, s3);
            }

            private static final void onBindViewHolder$lambda$2$lambda$1(FanListAdapter artistDetailFanListFragment$FanListAdapter0, RISINGFANLIST artistFanFanListRes$RESPONSE$RISINGFANLIST0, ArtistDetailFanListFragment artistDetailFanListFragment0, View view0) {
                String s = artistFanFanListRes$RESPONSE$RISINGFANLIST0.memberKey;
                q.f(s, "memberKey");
                artistDetailFanListFragment$FanListAdapter0.moveProfile(s);
                s s1 = artistDetailFanListFragment0.mMelonTiaraProperty;
                if(s1 != null) {
                    p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                    g0.I = s1.c;
                    g0.a = artistDetailFanListFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                    g0.b = s1.a;
                    g0.c = s1.b;
                    g0.d = ActionKind.ClickContent;
                    g0.y = artistDetailFanListFragment0.getString(0x7F130E9F);  // string:tiara_fanlist_layer1_this_week_rising "이번주 급상승"
                    g0.o = artistDetailFanListFragment0.artistId;
                    g0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
                    g0.q = artistDetailFanListFragment0.artistName;
                    g0.a().track();
                }
            }

            @Override  // androidx.recyclerview.widget.j0
            @NotNull
            public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
                q.g(viewGroup0, "parent");
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D045A, viewGroup0, false);  // layout:listitem_artist_fan_list_rising_fan
                q.f(view0, "inflate(...)");
                return new RisingFanItemViewHolder(this, view0);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$RisingFanListViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "titleView", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "getTitleView", "()Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "Landroidx/recyclerview/widget/RecyclerView;", "itemContainer", "Landroidx/recyclerview/widget/RecyclerView;", "getItemContainer", "()Landroidx/recyclerview/widget/RecyclerView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class RisingFanListViewHolder extends O0 {
            @NotNull
            private final RecyclerView itemContainer;
            @NotNull
            private final MainTabTitleView titleView;

            public RisingFanListViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                FanListAdapter.this = artistDetailFanListFragment$FanListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A07CA);  // id:main_contents_title
                q.f(view1, "findViewById(...)");
                this.titleView = (MainTabTitleView)view1;
                View view2 = view0.findViewById(0x7F0A05A7);  // id:item_container
                q.f(view2, "findViewById(...)");
                this.itemContainer = (RecyclerView)view2;
                ((RecyclerView)view2).setHasFixedSize(true);
                ((RecyclerView)view2).addItemDecoration(new O(11.0f));
            }

            @NotNull
            public final RecyclerView getItemContainer() {
                return this.itemContainer;
            }

            @NotNull
            public final MainTabTitleView getTitleView() {
                return this.titleView;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter$ServerDataWrapper;", "", "viewType", "", "data", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailFanListFragment$FanListAdapter;ILjava/lang/Object;)V", "getViewType", "()I", "getData", "()Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ServerDataWrapper {
            @NotNull
            private final Object data;
            private final int viewType;

            public ServerDataWrapper(int v, @NotNull Object object0) {
                q.g(object0, "data");
                FanListAdapter.this = artistDetailFanListFragment$FanListAdapter0;
                super();
                this.viewType = v;
                this.data = object0;
            }

            @NotNull
            public final Object getData() {
                return this.data;
            }

            public final int getViewType() {
                return this.viewType;
            }
        }

        private final int VIEW_TYPE_CARD_RELAY;
        private final int VIEW_TYPE_RECENTLY_LIKE_FAN_LIST;
        private final int VIEW_TYPE_RISING_FAN_LIST;
        @Nullable
        private RESPONSE memorialCardRelay;

        public FanListAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_CARD_RELAY = 1;
            this.VIEW_TYPE_RECENTLY_LIKE_FAN_LIST = 2;
            this.VIEW_TYPE_RISING_FAN_LIST = 3;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void clearCache(@Nullable String s) {
            this.memorialCardRelay = null;
            super.clearCache(s);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return ((ServerDataWrapper)this.getItem(v1)).getViewType();
        }

        @Nullable
        public final RESPONSE getMemorialCardRelay() {
            return this.memorialCardRelay;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            ArrayList arrayList1;
            if(httpResponse0 instanceof ArtistFanFanListRes) {
                com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE artistFanFanListRes$RESPONSE0 = ((ArtistFanFanListRes)httpResponse0).response;
                if(artistFanFanListRes$RESPONSE0 != null) {
                    this.setMenuId(artistFanFanListRes$RESPONSE0.menuId);
                    this.updateModifiedTime(this.getCacheKey());
                    RESPONSE artistTemperatureGetMemorialCardRelayRes$RESPONSE0 = this.memorialCardRelay;
                    if(artistTemperatureGetMemorialCardRelayRes$RESPONSE0 != null) {
                        this.add(new ServerDataWrapper(this, this.VIEW_TYPE_CARD_RELAY, artistTemperatureGetMemorialCardRelayRes$RESPONSE0));
                    }
                    if(ArtistDetailFanListFragment.this.isLoginUser()) {
                        ArrayList arrayList0 = artistFanFanListRes$RESPONSE0.recentlyLikeFanList;
                        if(arrayList0 == null) {
                            arrayList1 = null;
                        }
                        else {
                            arrayList1 = new ArrayList();
                            for(Object object0: arrayList0) {
                                if(!q.b(((RECENTLYLIKEFANLIST)object0).memberKey, e1.u.v(((e0)va.o.a()).j()))) {
                                    arrayList1.add(object0);
                                }
                            }
                        }
                    }
                    else {
                        arrayList1 = artistFanFanListRes$RESPONSE0.recentlyLikeFanList;
                    }
                    if(arrayList1 != null) {
                        this.add(new ServerDataWrapper(this, this.VIEW_TYPE_RECENTLY_LIKE_FAN_LIST, arrayList1));
                    }
                    if(artistFanFanListRes$RESPONSE0.risingFanList != null && !artistFanFanListRes$RESPONSE0.risingFanList.isEmpty()) {
                        ArrayList arrayList2 = artistFanFanListRes$RESPONSE0.risingFanList;
                        q.f(arrayList2, "risingFanList");
                        this.add(new ServerDataWrapper(this, this.VIEW_TYPE_RISING_FAN_LIST, arrayList2));
                    }
                }
            }
            return true;
        }

        private final void moveProfile(String s) {
            if(StringIds.a(s, StringIds.h)) {
                q.g(s, "targetMemberKey");
                g0 g00 = new g0();
                Bundle bundle0 = Y.b("argMemberKey", s);
                bundle0.putBoolean("argIsMySelf", e1.u.o(s) && s.equals(e1.u.v(((e0)va.o.a()).j())));
                g00.setArguments(bundle0);
                Navigator.INSTANCE.open(g00);
                return;
            }
            Navigator.openUserMain(s);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "vh");
            if(o00 instanceof MemorialCardRelayViewHolder) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.ServerDataWrapper");
                Object object1 = ((ServerDataWrapper)object0).getData();
                q.e(object1, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureGetMemorialCardRelayRes.RESPONSE");
                String s = ((RESPONSE)object1).artistMemorialCardRelayCnt;
                if(s == null || s.length() == 0 || q.b(((RESPONSE)object1).artistMemorialCardRelayCnt, "0")) {
                    ((MemorialCardRelayViewHolder)o00).getTvTitle().setText(ArtistDetailFanListFragment.this.getString(0x7F13013A));  // string:artist_fan_list_card_relay_of_fan "팬들의 카드릴레이"
                }
                else {
                    String s1 = e.c(ArtistDetailFanListFragment.this.getString(0x7F13013A), " ", ((RESPONSE)object1).artistMemorialCardRelayCnt);  // string:artist_fan_list_card_relay_of_fan "팬들의 카드릴레이"
                    ((MemorialCardRelayViewHolder)o00).getTvTitle().setText(s1);
                    ((MemorialCardRelayViewHolder)o00).getTvTitle().setContentDescription(s1 + ArtistDetailFanListFragment.this.getString(0x7F130753));  // string:musicdna_count_hangle "개"
                }
                ArrayList arrayList0 = ((RESPONSE)object1).memorialCardRelayList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    ((MemorialCardRelayViewHolder)o00).getTvJoinCardRelay().setVisibility(0);
                    RecyclerView recyclerView0 = ((MemorialCardRelayViewHolder)o00).getItemContainer();
                    Context context0 = this.getContext();
                    q.f(context0, "getContext(...)");
                    ArrayList arrayList1 = ((RESPONSE)object1).memorialCardRelayList;
                    q.f(arrayList1, "memorialCardRelayList");
                    recyclerView0.setAdapter(new MemorialCardRelayAdapter(this, context0, arrayList1));
                    ((MemorialCardRelayViewHolder)o00).getTvJoinCardRelay().setOnClickListener(new t(ArtistDetailFanListFragment.this, 1));
                    ViewUtils.setContentDescriptionWithButtonClassName(((MemorialCardRelayViewHolder)o00).getTvJoinCardRelay(), ((MemorialCardRelayViewHolder)o00).getTvJoinCardRelay().getText());
                    return;
                }
                ((MemorialCardRelayViewHolder)o00).getItemContainer().setVisibility(8);
                ((MemorialCardRelayViewHolder)o00).getTvJoinCardRelay().setVisibility(8);
                ((MemorialCardRelayViewHolder)o00).getEmptyLayout().setVisibility(0);
                ((MemorialCardRelayViewHolder)o00).getTemperatureBtn().setOnClickListener(new t(ArtistDetailFanListFragment.this, 0));
                ViewUtils.setContentDescriptionWithButtonClassName(((MemorialCardRelayViewHolder)o00).getTemperatureBtn(), ((MemorialCardRelayViewHolder)o00).getTemperatureBtn().getText());
                return;
            }
            if(o00 instanceof RecentlyLikeFanListViewHolder) {
                ((RecentlyLikeFanListViewHolder)o00).getTitleView().setTitle(ArtistDetailFanListFragment.this.getString(0x7F13013C));  // string:artist_fan_list_recently_like_title "최근 좋아요한 팬"
                Object object2 = this.getItem(v1);
                q.e(object2, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.ServerDataWrapper");
                Object object3 = ((ServerDataWrapper)object2).getData();
                q.e(object3, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE.RECENTLYLIKEFANLIST>");
                if(((ArrayList)object3).isEmpty()) {
                    ((RecentlyLikeFanListViewHolder)o00).getEmptyLayout().setVisibility(0);
                    return;
                }
                RecyclerView recyclerView1 = ((RecentlyLikeFanListViewHolder)o00).getItemContainer();
                Context context1 = this.getContext();
                q.f(context1, "getContext(...)");
                recyclerView1.setAdapter(new RecentlyLikeFanListAdapter(this, context1, ((ArrayList)object3)));
                return;
            }
            if(o00 instanceof RisingFanListViewHolder) {
                ((RisingFanListViewHolder)o00).getTitleView().setTitle(ArtistDetailFanListFragment.this.getString(0x7F13013E));  // string:artist_fan_list_this_week_rising "이번주 급상승"
                Object object4 = this.getItem(v1);
                q.e(object4, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter.ServerDataWrapper");
                Object object5 = ((ServerDataWrapper)object4).getData();
                q.e(object5, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE.RISINGFANLIST>");
                RecyclerView recyclerView2 = ((RisingFanListViewHolder)o00).getItemContainer();
                Context context2 = this.getContext();
                q.f(context2, "getContext(...)");
                recyclerView2.setAdapter(new RisingFanListAdapter(this, context2, ((ArrayList)object5)));
            }
        }

        private static final void onBindViewImpl$lambda$3(ArtistDetailFanListFragment artistDetailFanListFragment0, View view0) {
            Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(artistDetailFanListFragment0.artistId));
        }

        private static final void onBindViewImpl$lambda$5(ArtistDetailFanListFragment artistDetailFanListFragment0, View view0) {
            Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(artistDetailFanListFragment0.artistId));
            s s0 = artistDetailFanListFragment0.mMelonTiaraProperty;
            if(s0 != null) {
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = s0.c;
                g0.a = artistDetailFanListFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                g0.b = s0.a;
                g0.c = s0.b;
                g0.d = ActionKind.ClickContent;
                g0.y = artistDetailFanListFragment0.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
                g0.F = artistDetailFanListFragment0.getString(0x7F131027);  // string:tiara_temperature_copy_join "참여하기"
                g0.o = artistDetailFanListFragment0.artistId;
                g0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
                g0.q = artistDetailFanListFragment0.artistName;
                g0.a().track();
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_CARD_RELAY) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0048, viewGroup0, false);  // layout:artist_fan_list_card_relay
                q.f(view0, "inflate(...)");
                return new MemorialCardRelayViewHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_RECENTLY_LIKE_FAN_LIST) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0049, viewGroup0, false);  // layout:artist_fan_list_recently_like
                q.f(view1, "inflate(...)");
                return new RecentlyLikeFanListViewHolder(this, view1);
            }
            if(v == this.VIEW_TYPE_RISING_FAN_LIST) {
                View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D004A, viewGroup0, false);  // layout:artist_fan_list_rising
                q.f(view2, "inflate(...)");
                return new RisingFanListViewHolder(this, view2);
            }
            return null;
        }

        public final void setMemorialCardRelay(@Nullable RESPONSE artistTemperatureGetMemorialCardRelayRes$RESPONSE0) {
            this.memorialCardRelay = artistTemperatureGetMemorialCardRelayRes$RESPONSE0;
        }

        private final void trackTiaraFollow(String s) {
            s s1 = ArtistDetailFanListFragment.this.mMelonTiaraProperty;
            if(s1 != null) {
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = s1.c;
                g0.a = ArtistDetailFanListFragment.this.getString(0x7F130DD2);  // string:tiara_common_action_name_subscription "구독"
                g0.b = s1.a;
                g0.c = s1.b;
                g0.d = ActionKind.Follow;
                g0.y = ArtistDetailFanListFragment.this.getString(0x7F130E9E);  // string:tiara_fanlist_layer1_recently_like_fan "최근 좋아요한 팬"
                g0.F = ArtistDetailFanListFragment.this.getString(0x7F130E9C);  // string:tiara_fanlist_copy_follow "팔로우"
                g0.o = ArtistDetailFanListFragment.this.artistId;
                g0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
                g0.q = ArtistDetailFanListFragment.this.artistName;
                g0.V = s;
                g0.a().track();
            }
        }

        private final void trackTiaraMoveProfile() {
            s s0 = ArtistDetailFanListFragment.this.mMelonTiaraProperty;
            if(s0 != null) {
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = s0.c;
                g0.a = ArtistDetailFanListFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                g0.b = s0.a;
                g0.c = s0.b;
                g0.d = ActionKind.ClickContent;
                g0.y = ArtistDetailFanListFragment.this.getString(0x7F130E9E);  // string:tiara_fanlist_layer1_recently_like_fan "최근 좋아요한 팬"
                g0.o = ArtistDetailFanListFragment.this.artistId;
                g0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
                g0.q = ArtistDetailFanListFragment.this.artistName;
                g0.a().track();
            }
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_ARTIST_NAME = "argArtistName";
    @NotNull
    private static final String CACHE_KEY_SUB_NAME = "fanList";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String MEMORIAL_CARD_RELAY_PAGE_SIZE = "50";
    @NotNull
    private static final String TAG = "ArtistDetailFanListFragment";
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private Map blurViewBgMap;
    @NotNull
    private final MainCoroutineDispatcher defaultDispatcher;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;

    static {
        ArtistDetailFanListFragment.Companion = new Companion(null);
        ArtistDetailFanListFragment.$stable = 8;
    }

    public ArtistDetailFanListFragment() {
        this.defaultDispatcher = Dispatchers.getMain();
        this.ioDispatcher = Dispatchers.getIO();
        this.artistId = "";
        this.artistName = "";
        this.blurViewBgMap = new LinkedHashMap();
        this.exceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                b.w("onFetchStart() error, exceptionHandler ", throwable0.getMessage(), LogU.Companion, "ArtistDetailFanListFragment");
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ArtistDetailFanListFragment.access$getDefaultDispatcher$p(ArtistDetailFanListFragment.this)), null, null, new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.exceptionHandler.1.1(throwable0, ArtistDetailFanListFragment.this, null), 3, null);
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment$exceptionHandler$1$1", f = "ArtistDetailFanListFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.exceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.exceptionHandler.1.1(Throwable throwable0, ArtistDetailFanListFragment artistDetailFanListFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.exceptionHandler.1.1(this.$throwable, ArtistDetailFanListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.exceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    ArtistDetailFanListFragment.access$getMResponseErrorListener$p$s508273161(ArtistDetailFanListFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s508273161(ArtistDetailFanListFragment artistDetailFanListFragment0) {
        return artistDetailFanListFragment0.mResponseErrorListener;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new FanListAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.b.buildUpon().appendPath("fanList").appendPath(this.artistId).appendQueryParameter("memberKey", e1.u.v(((e0)va.o.a()).j())).toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final void getFollowYNInfoFromServer(ArrayList arrayList0) {
        if(this.isLoginUser()) {
            StringBuilder stringBuilder0 = new StringBuilder();
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0 = (RECENTLYLIKEFANLIST)object0;
                try {
                    stringBuilder0.append(artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.memberKey);
                    stringBuilder0.append(",");
                }
                catch(Exception unused_ex) {
                }
            }
            int v = stringBuilder0.length();
            if(v != 0) {
                stringBuilder0.setLength(v - 1);
                RequestBuilder.newInstance(new ArtistFanFollowYnListReq(this.getContext(), stringBuilder0.toString())).tag(this.getRequestTag()).listener(new c(13, this, arrayList0)).errorListener(new com.iloen.melon.fragments.artistchannel.s(3)).request();
            }
        }
    }

    private static final void getFollowYNInfoFromServer$lambda$3(ArtistDetailFanListFragment artistDetailFanListFragment0, ArrayList arrayList0, ArtistFanFollowYnListRes artistFanFollowYnListRes0) {
        if(artistDetailFanListFragment0.isFragmentValid()) {
            j.b(artistFanFollowYnListRes0.notification, false, 3);
            if(j.d(artistFanFollowYnListRes0) && artistFanFollowYnListRes0.response != null) {
                int v1 = arrayList0.size();
                for(int v = 0; v < v1; ++v) {
                    try {
                        RECENTLYLIKEFANLIST artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0 = (RECENTLYLIKEFANLIST)arrayList0.get(v);
                        artistFanFanListRes$RESPONSE$RECENTLYLIKEFANLIST0.followYN = ((FOLLOWYNLIST)artistFanFollowYnListRes0.response.followYNList.get(v)).followYN;
                    }
                    catch(Exception unused_ex) {
                    }
                }
                artistDetailFanListFragment0.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private static final void getFollowYNInfoFromServer$lambda$4(VolleyError volleyError0) {
        LogU.Companion.w("ArtistDetailFanListFragment", "getFollowYNInfoFromServer() error : " + volleyError0.getMessage());
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ArtistDetailFanListFragment newInstance(@NotNull String s, @Nullable String s1) {
        return ArtistDetailFanListFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(false);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0293, viewGroup0, false);  // layout:fragment_artist_detail_fan_list
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.FanListAdapter");
        if(q.b(i0, i.b)) {
            ((FanListAdapter)j00).clear();
        }
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(this.ioDispatcher);
        com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1 artistDetailFanListFragment$onFetchStart$10 = new n(i0, ((FanListAdapter)j00), null) {
            final FanListAdapter $adapter;
            final i $type;
            int label;

            {
                ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
                this.$type = i0;
                this.$adapter = artistDetailFanListFragment$FanListAdapter0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1(ArtistDetailFanListFragment.this, this.$type, this.$adapter, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1.1 artistDetailFanListFragment$onFetchStart$1$10 = new n(this.$type, this.$adapter, null) {
                            final FanListAdapter $adapter;
                            final i $type;
                            private Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;

                            {
                                ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
                                this.$type = i0;
                                this.$adapter = artistDetailFanListFragment$FanListAdapter0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1.1(ArtistDetailFanListFragment.this, this.$type, this.$adapter, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ArtistTemperatureGetMemorialCardRelayRes artistTemperatureGetMemorialCardRelayRes1;
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Deferred deferred0 = ArtistDetailFanListFragment.this.requestMemorialCardAsync(coroutineScope0);
                                        this.L$0 = coroutineScope0;
                                        this.label = 1;
                                        object0 = deferred0.await(this);
                                        if(object0 == a0) {
                                            return a0;
                                        }
                                        goto label_16;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                    label_16:
                                        Deferred deferred1 = ArtistDetailFanListFragment.this.requestFanListAsync(coroutineScope0);
                                        this.L$0 = null;
                                        this.L$1 = (ArtistTemperatureGetMemorialCardRelayRes)object0;
                                        this.label = 2;
                                        Object object1 = deferred1.await(this);
                                        if(object1 == a0) {
                                            return a0;
                                        }
                                        artistTemperatureGetMemorialCardRelayRes1 = (ArtistTemperatureGetMemorialCardRelayRes)object0;
                                        object0 = object1;
                                        break;
                                    }
                                    case 2: {
                                        ArtistTemperatureGetMemorialCardRelayRes artistTemperatureGetMemorialCardRelayRes2 = (ArtistTemperatureGetMemorialCardRelayRes)this.L$1;
                                        d5.n.D(object0);
                                        artistTemperatureGetMemorialCardRelayRes1 = artistTemperatureGetMemorialCardRelayRes2;
                                        break;
                                    }
                                    case 3: {
                                        ArtistFanFanListRes artistFanFanListRes0 = (ArtistFanFanListRes)this.L$2;
                                        ArtistTemperatureGetMemorialCardRelayRes artistTemperatureGetMemorialCardRelayRes0 = (ArtistTemperatureGetMemorialCardRelayRes)this.L$1;
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1.1.1 artistDetailFanListFragment$onFetchStart$1$1$10 = new n(((ArtistFanFanListRes)object0), this.$type, artistTemperatureGetMemorialCardRelayRes1, this.$adapter, null) {
                                    final FanListAdapter $adapter;
                                    final ArtistFanFanListRes $artistFanFanListRes;
                                    final ArtistTemperatureGetMemorialCardRelayRes $memorialCardRelayRes;
                                    final i $type;
                                    int label;

                                    {
                                        ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
                                        this.$artistFanFanListRes = artistFanFanListRes0;
                                        this.$type = i0;
                                        this.$memorialCardRelayRes = artistTemperatureGetMemorialCardRelayRes0;
                                        this.$adapter = artistDetailFanListFragment$FanListAdapter0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1.1.1(ArtistDetailFanListFragment.this, this.$artistFanFanListRes, this.$type, this.$memorialCardRelayRes, this.$adapter, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.onFetchStart.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        if(this.label != 0) {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                        d5.n.D(object0);
                                        boolean z = ArtistDetailFanListFragment.this.prepareFetchComplete(this.$artistFanFanListRes);
                                        H h0 = H.a;
                                        if(!z) {
                                            return h0;
                                        }
                                        ArtistFanFanListRes artistFanFanListRes0 = this.$artistFanFanListRes;
                                        if((artistFanFanListRes0 == null ? null : artistFanFanListRes0.response) == null) {
                                            ArtistDetailFanListFragment.this.performFetchCompleteOnlyViews();
                                            return h0;
                                        }
                                        com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE artistFanFanListRes$RESPONSE0 = artistFanFanListRes0.response;
                                        if(artistFanFanListRes$RESPONSE0 != null) {
                                            ArtistTemperatureGetMemorialCardRelayRes artistTemperatureGetMemorialCardRelayRes0 = this.$memorialCardRelayRes;
                                            FanListAdapter artistDetailFanListFragment$FanListAdapter0 = this.$adapter;
                                            ArtistDetailFanListFragment artistDetailFanListFragment0 = ArtistDetailFanListFragment.this;
                                            if((artistTemperatureGetMemorialCardRelayRes0 == null ? null : artistTemperatureGetMemorialCardRelayRes0.response) != null) {
                                                artistDetailFanListFragment$FanListAdapter0.setMemorialCardRelay(artistTemperatureGetMemorialCardRelayRes0.response);
                                            }
                                            artistDetailFanListFragment0.mMelonTiaraProperty = new s(artistFanFanListRes$RESPONSE0.section, artistFanFanListRes$RESPONSE0.page, artistFanFanListRes$RESPONSE0.menuId, null);
                                            if(artistFanFanListRes$RESPONSE0.recentlyLikeFanList != null && !artistFanFanListRes$RESPONSE0.recentlyLikeFanList.isEmpty()) {
                                                ArrayList arrayList0 = artistFanFanListRes$RESPONSE0.recentlyLikeFanList;
                                                q.f(arrayList0, "recentlyLikeFanList");
                                                artistDetailFanListFragment0.getFollowYNInfoFromServer(arrayList0);
                                            }
                                        }
                                        ArtistDetailFanListFragment.this.performFetchComplete(this.$type, this.$artistFanFanListRes);
                                        return h0;
                                    }
                                };
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 3;
                                return BuildersKt.withContext(ArtistDetailFanListFragment.this.defaultDispatcher, artistDetailFanListFragment$onFetchStart$1$1$10, this) == a0 ? a0 : H.a;
                            }
                        };
                        this.label = 1;
                        return SupervisorKt.supervisorScope(artistDetailFanListFragment$onFetchStart$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, this.exceptionHandler, null, artistDetailFanListFragment$onFetchStart$10, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argItemId");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.artistId = s;
        String s2 = bundle0.getString("argArtistName");
        if(s2 != null) {
            s1 = s2;
        }
        this.artistName = s1;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.artistId);
        bundle0.putString("argArtistName", this.artistName);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().a(B.a.s(1));
        TitleBar titleBar0 = this.getTitleBar();
        String s = this.getString(0x7F13013F);  // string:artist_fan_list_title "%1$s 팬"
        q.f(s, "getString(...)");
        titleBar0.setTitle(String.format(s, Arrays.copyOf(new Object[]{this.artistName}, 1)));
    }

    private final Deferred requestFanListAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.requestFanListAsync.1(ArtistDetailFanListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.requestFanListAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistFanFanListReq(ArtistDetailFanListFragment.this.getContext(), ArtistDetailFanListFragment.this.artistId)).tag(ArtistDetailFanListFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistFanFanListRes");
                return (ArtistFanFanListRes)httpResponse0;
            }
        }, 3, null);
    }

    private final Deferred requestMemorialCardAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                ArtistDetailFanListFragment.this = artistDetailFanListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.requestMemorialCardAsync.1(ArtistDetailFanListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.requestMemorialCardAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistTemperatureGetMemorialCardRelayReq(ArtistDetailFanListFragment.this.getContext(), "50", ArtistDetailFanListFragment.this.artistId)).tag(ArtistDetailFanListFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureGetMemorialCardRelayRes");
                return (ArtistTemperatureGetMemorialCardRelayRes)httpResponse0;
            }
        }, 3, null);
    }
}

