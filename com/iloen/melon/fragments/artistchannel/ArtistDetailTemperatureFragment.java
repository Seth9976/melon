package com.iloen.melon.fragments.artistchannel;

import Cb.j;
import F8.m;
import F8.x;
import H0.b;
import Tf.o;
import Tf.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.request.ArtistTemperatureDetailHistoryReq;
import com.iloen.melon.net.v6x.request.ArtistTemperatureDetailReq;
import com.iloen.melon.net.v6x.request.ArtistTemperatureShareImgReq;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes.RESPONSE.HISTORYLIST.HISTORYINFO;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes.RESPONSE.HISTORYLIST;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.GUIDE;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.MEMORIALLIST;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.TOPSTREAMINGSONG;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.USERTEMPERCARD.USERRANKINFO;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.USERTEMPERCARD;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes;
import com.iloen.melon.net.v6x.response.ArtistTemperatureShareImgRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableTemperatureCard;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.LyricHighlightUtils.Companion;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import com.iloen.melon.utils.ui.MemorialCardUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.ResponseBase;
import d5.w;
import e.k;
import ie.H;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.SupervisorKt;
import ne.a;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;
import we.n;

@Metadata(d1 = {"\u0000\u00B8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0003QRSB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u000FJ-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001B\u0010 \u001A\u0006\u0012\u0002\b\u00030\u001F2\u0006\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b#\u0010$J-\u0010*\u001A\u00020\u00042\b\u0010&\u001A\u0004\u0018\u00010%2\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010)\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u001D\u00103\u001A\b\u0012\u0004\u0012\u000202012\u0006\u00100\u001A\u00020/H\u0002\u00A2\u0006\u0004\b3\u00104J)\u00108\u001A\n\u0012\u0006\u0012\u0004\u0018\u000107012\u0006\u00100\u001A\u00020/2\b\b\u0002\u00106\u001A\u000205H\u0002\u00A2\u0006\u0004\b8\u00109J\u0011\u0010;\u001A\u0004\u0018\u00010:H\u0002\u00A2\u0006\u0004\b;\u0010<R\u0016\u0010=\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010>R\"\u0010B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020A0@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001A\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001A\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010FR\u0018\u0010I\u001A\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001A\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010JR\u0016\u0010L\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001A\u00020N8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bO\u0010P\u00A8\u0006T"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "hasScrolledLine", "()Z", "isScreenLandscapeSupported", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes;", "requestArtistTemperatureDetailAsync", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Deferred;", "", "startIdx", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailHistoryRes;", "requestArtistTemperatureDetailHistoryAsync", "(Lkotlinx/coroutines/CoroutineScope;I)Lkotlinx/coroutines/Deferred;", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "artistId", "Ljava/lang/String;", "artistName", "", "Landroid/graphics/Bitmap;", "blurViewBgMap", "Ljava/util/Map;", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ShareImageData;", "shareRankOnImageData", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ShareImageData;", "shareRankOffImageData", "Landroid/net/Uri;", "savedRankOnImageUri", "Landroid/net/Uri;", "savedRankOffImageUri", "isRankOn", "Z", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Companion", "ArtistDetailTemperatureAdapter", "ShareImageData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailTemperatureFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b&\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\tWXYZ[\\]^_B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ-\u0010\u0014\u001A\u00020\u00132\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001E\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ)\u0010!\u001A\u00020\f2\b\u0010 \u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b!\u0010\"J#\u0010&\u001A\u00020\f2\b\b\u0002\u0010$\u001A\u00020#2\b\b\u0002\u0010%\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010,\u001A\u00020\f2\u0006\u0010+\u001A\u00020*H\u0002\u00A2\u0006\u0004\b,\u0010-J\u0017\u0010.\u001A\u00020\f2\u0006\u0010+\u001A\u00020*H\u0002\u00A2\u0006\u0004\b.\u0010-J)\u00100\u001A\u00020\u00132\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010+\u001A\u00020*2\b\b\u0002\u0010/\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b0\u00101J\'\u00107\u001A\u00020\f2\u0006\u00102\u001A\u00020\n2\u0006\u00104\u001A\u0002032\u0006\u00106\u001A\u000205H\u0002\u00A2\u0006\u0004\b7\u00108R,\u0010;\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u0001098\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001A\u00020\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bA\u0010B\u001A\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010G\u001A\u00020\u00168\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bG\u0010H\u001A\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001A\u00020\u00168\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bM\u0010H\u001A\u0004\bN\u0010J\"\u0004\bO\u0010LR\u0014\u0010P\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bP\u0010HR\u0014\u0010Q\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bQ\u0010HR\u0014\u0010R\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bR\u0010HR\u0014\u0010S\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bS\u0010HR\u0014\u0010T\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bT\u0010HR\u0014\u0010U\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bU\u0010HR\u0014\u0010V\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bV\u0010H\u00A8\u0006`"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lie/H;", "clearCache", "(Ljava/lang/String;)V", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "vh", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes$RESPONSE;", "res", "isFolding", "updateAdapter", "(Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes$RESPONSE;Z)V", "fetchMoreHistoryDate", "()V", "Landroid/view/View;", "view", "shareTemperatureCard", "(Landroid/view/View;)V", "saveTemperCard", "usePrivateStorage", "saveCardFileFromView", "(Landroid/content/Context;Landroid/view/View;Z)Z", "imageUrl", "Landroid/graphics/Bitmap;", "source", "Landroid/widget/ImageView;", "bgIv", "drawBlurImage", "(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/widget/ImageView;)V", "", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST;", "fetchedHistoryList", "Ljava/util/List;", "getFetchedHistoryList", "()Ljava/util/List;", "setFetchedHistoryList", "(Ljava/util/List;)V", "hasMoreHistory", "Z", "getHasMoreHistory", "()Z", "setHasMoreHistory", "(Z)V", "nextIdx", "I", "getNextIdx", "()I", "setNextIdx", "(I)V", "displayHistoryDateCount", "getDisplayHistoryDateCount", "setDisplayHistoryDateCount", "VIEW_TYPE_USERTEMPERCARD", "VIEW_TYPE_TITLE", "VIEW_TYPE_HISTORY_DATE", "VIEW_TYPE_HISTORY_INFO", "VIEW_TYPE_HISTORY_MORE_BUTTON", "VIEW_TYPE_MEMORIALLIST", "VIEW_TYPE_TOPSTREAMINGSONG", "MemorialGridAdapter", "UserTemperCardViewHolder", "TitleViewHolder", "HistoryDateViewHolder", "HistoryInfoViewHolder", "HistoryMoreButtonViewHolder", "MemorialListViewHolder", "TopStreamingSongViewHolder", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ArtistDetailTemperatureAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001A\u0004\b\u000B\u0010\tR\u0017\u0010\r\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0011\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$HistoryDateViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/view/View;)V", "upperLine", "Landroid/view/View;", "getUpperLine", "()Landroid/view/View;", "bottomLine", "getBottomLine", "Landroid/widget/TextView;", "temperature", "Landroid/widget/TextView;", "getTemperature", "()Landroid/widget/TextView;", "date", "getDate", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HistoryDateViewHolder extends O0 {
            @NotNull
            private final View bottomLine;
            @NotNull
            private final TextView date;
            @NotNull
            private final TextView temperature;
            @NotNull
            private final View upperLine;

            public HistoryDateViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D7A);  // id:upper_line
                q.f(view1, "findViewById(...)");
                this.upperLine = view1;
                View view2 = view0.findViewById(0x7F0A011F);  // id:bottom_line
                q.f(view2, "findViewById(...)");
                this.bottomLine = view2;
                View view3 = view0.findViewById(0x7F0A0B40);  // id:temperature
                q.f(view3, "findViewById(...)");
                this.temperature = (TextView)view3;
                View view4 = view0.findViewById(0x7F0A037A);  // id:date
                q.f(view4, "findViewById(...)");
                this.date = (TextView)view4;
            }

            @NotNull
            public final View getBottomLine() {
                return this.bottomLine;
            }

            @NotNull
            public final TextView getDate() {
                return this.date;
            }

            @NotNull
            public final TextView getTemperature() {
                return this.temperature;
            }

            @NotNull
            public final View getUpperLine() {
                return this.upperLine;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0092\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001A\u0004\b\u000B\u0010\tR\u0017\u0010\f\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001A\u0004\b\r\u0010\tR\u0017\u0010\u000F\u001A\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001A\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001A\u0004\b\u0019\u0010\u0012¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$HistoryInfoViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/view/View;)V", "line", "Landroid/view/View;", "getLine", "()Landroid/view/View;", "textLayout", "getTextLayout", "icon", "getIcon", "Landroid/widget/TextView;", "message", "Landroid/widget/TextView;", "getMessage", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "gapArrow", "Landroid/widget/ImageView;", "getGapArrow", "()Landroid/widget/ImageView;", "gapTemperature", "getGapTemperature", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        class HistoryInfoViewHolder extends O0 {
            @NotNull
            private final ImageView gapArrow;
            @NotNull
            private final TextView gapTemperature;
            @NotNull
            private final View icon;
            @NotNull
            private final View line;
            @NotNull
            private final TextView message;
            @NotNull
            private final View textLayout;

            public HistoryInfoViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A076F);  // id:line
                q.f(view1, "findViewById(...)");
                this.line = view1;
                View view2 = view0.findViewById(0x7F0A0B59);  // id:text_layout
                q.f(view2, "findViewById(...)");
                this.textLayout = view2;
                View view3 = view0.findViewById(0x7F0A0546);  // id:icon
                q.f(view3, "findViewById(...)");
                this.icon = view3;
                View view4 = view0.findViewById(0x7F0A07FB);  // id:message
                q.f(view4, "findViewById(...)");
                this.message = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A04E7);  // id:gap_arrow
                q.f(view5, "findViewById(...)");
                this.gapArrow = (ImageView)view5;
                View view6 = view0.findViewById(0x7F0A04E8);  // id:gap_temperature
                q.f(view6, "findViewById(...)");
                this.gapTemperature = (TextView)view6;
            }

            @NotNull
            public final ImageView getGapArrow() {
                return this.gapArrow;
            }

            @NotNull
            public final TextView getGapTemperature() {
                return this.gapTemperature;
            }

            @NotNull
            public final View getIcon() {
                return this.icon;
            }

            @NotNull
            public final View getLine() {
                return this.line;
            }

            @NotNull
            public final TextView getMessage() {
                return this.message;
            }

            @NotNull
            public final View getTextLayout() {
                return this.textLayout;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001A\u0004\b\u000B\u0010\tR\u0017\u0010\r\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$HistoryMoreButtonViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/view/View;)V", "line", "Landroid/view/View;", "getLine", "()Landroid/view/View;", "moreLayout", "getMoreLayout", "Landroid/widget/TextView;", "more", "Landroid/widget/TextView;", "getMore", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HistoryMoreButtonViewHolder extends O0 {
            @NotNull
            private final View line;
            @NotNull
            private final TextView more;
            @NotNull
            private final View moreLayout;

            public HistoryMoreButtonViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A076F);  // id:line
                q.f(view1, "findViewById(...)");
                this.line = view1;
                View view2 = view0.findViewById(0x7F0A081C);  // id:more_layout
                q.f(view2, "findViewById(...)");
                this.moreLayout = view2;
                View view3 = view0.findViewById(0x7F0A0817);  // id:more
                q.f(view3, "findViewById(...)");
                this.more = (TextView)view3;
            }

            @NotNull
            public final View getLine() {
                return this.line;
            }

            @NotNull
            public final TextView getMore() {
                return this.more;
            }

            @NotNull
            public final View getMoreLayout() {
                return this.moreLayout;
            }
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002 !B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0016\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001A\u00020\u00032\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001B\u001A\u00020\u001A2\b\u0010\u0019\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010\u001E¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes$RESPONSE$MEMORIALLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "type", "getClickCopy", "(Ljava/lang/String;)Ljava/lang/String;", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_ITEM_MEMORIAL_ABLE", "I", "VIEW_ITEM_MEMORIAL_DISABLE", "MemorialAbleViewHolder", "MemorialDisableViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MemorialGridAdapter extends p {
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001A\u0004\b\u0011\u0010\nR\u0017\u0010\u0012\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\b\u001A\u0004\b\u0013\u0010\nR\u0017\u0010\u0014\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001A\u0004\b\u0015\u0010\u000FR\u0017\u0010\u0016\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001A\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u001A\u0010\r\u001A\u0004\b\u001B\u0010\u000FR\u0017\u0010\u001C\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\r\u001A\u0004\b\u001D\u0010\u000F¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "bgIv", "Landroid/widget/ImageView;", "getBgIv", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "defaultIv", "getDefaultIv", "thumbIv", "getThumbIv", "desc1Tv", "getDesc1Tv", "temperatureLayout", "Landroid/view/View;", "getTemperatureLayout", "()Landroid/view/View;", "temperatureTv", "getTemperatureTv", "desc2Tv", "getDesc2Tv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class MemorialAbleViewHolder extends O0 {
                @NotNull
                private final ImageView bgIv;
                @NotNull
                private final ImageView defaultIv;
                @NotNull
                private final TextView desc1Tv;
                @NotNull
                private final TextView desc2Tv;
                @NotNull
                private final View temperatureLayout;
                @NotNull
                private final TextView temperatureTv;
                @NotNull
                private final ImageView thumbIv;
                @NotNull
                private final TextView titleTv;

                public MemorialAbleViewHolder(@NotNull View view0) {
                    q.g(view0, "itemView");
                    MemorialGridAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter0;
                    super(view0);
                    View view1 = view0.findViewById(0x7F0A0105);  // id:bg_iv
                    q.f(view1, "findViewById(...)");
                    this.bgIv = (ImageView)view1;
                    View view2 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                    q.f(view2, "findViewById(...)");
                    this.titleTv = (TextView)view2;
                    View view3 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
                    q.f(view3, "findViewById(...)");
                    this.defaultIv = (ImageView)view3;
                    View view4 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
                    q.f(view4, "findViewById(...)");
                    this.thumbIv = (ImageView)view4;
                    View view5 = view0.findViewById(0x7F0A03A4);  // id:desc1_tv
                    q.f(view5, "findViewById(...)");
                    this.desc1Tv = (TextView)view5;
                    View view6 = view0.findViewById(0x7F0A0B46);  // id:temperature_layout
                    q.f(view6, "findViewById(...)");
                    this.temperatureLayout = view6;
                    View view7 = view0.findViewById(0x7F0A0B47);  // id:temperature_tv
                    q.f(view7, "findViewById(...)");
                    this.temperatureTv = (TextView)view7;
                    View view8 = view0.findViewById(0x7F0A03A6);  // id:desc2_tv
                    q.f(view8, "findViewById(...)");
                    this.desc2Tv = (TextView)view8;
                    ViewUtils.setDefaultImage(((ImageView)view3), ScreenUtils.dipToPixel(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter0.getContext(), 70.0f));
                }

                @NotNull
                public final ImageView getBgIv() {
                    return this.bgIv;
                }

                @NotNull
                public final ImageView getDefaultIv() {
                    return this.defaultIv;
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
                public final View getTemperatureLayout() {
                    return this.temperatureLayout;
                }

                @NotNull
                public final TextView getTemperatureTv() {
                    return this.temperatureTv;
                }

                @NotNull
                public final ImageView getThumbIv() {
                    return this.thumbIv;
                }

                @NotNull
                public final TextView getTitleTv() {
                    return this.titleTv;
                }
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001A\u0004\b\u0011\u0010\nR\u0017\u0010\u0012\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\b\u001A\u0004\b\u0013\u0010\nR\u0017\u0010\u0014\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\b\u001A\u0004\b\u0015\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialDisableViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "messageTv", "getMessageTv", "dateTv", "getDateTv", "dateMessageTv", "getDateMessageTv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class MemorialDisableViewHolder extends O0 {
                @NotNull
                private final TextView dateMessageTv;
                @NotNull
                private final TextView dateTv;
                @NotNull
                private final ImageView iconIv;
                @NotNull
                private final TextView messageTv;
                @NotNull
                private final TextView titleTv;

                public MemorialDisableViewHolder(@NotNull View view0) {
                    q.g(view0, "itemView");
                    MemorialGridAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter0;
                    super(view0);
                    View view1 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                    q.f(view1, "findViewById(...)");
                    this.titleTv = (TextView)view1;
                    View view2 = view0.findViewById(0x7F0A054C);  // id:icon_iv
                    q.f(view2, "findViewById(...)");
                    this.iconIv = (ImageView)view2;
                    View view3 = view0.findViewById(0x7F0A07FD);  // id:message_tv
                    q.f(view3, "findViewById(...)");
                    this.messageTv = (TextView)view3;
                    View view4 = view0.findViewById(0x7F0A037E);  // id:date_tv
                    q.f(view4, "findViewById(...)");
                    this.dateTv = (TextView)view4;
                    View view5 = view0.findViewById(0x7F0A037C);  // id:date_message_tv
                    q.f(view5, "findViewById(...)");
                    this.dateMessageTv = (TextView)view5;
                }

                @NotNull
                public final TextView getDateMessageTv() {
                    return this.dateMessageTv;
                }

                @NotNull
                public final TextView getDateTv() {
                    return this.dateTv;
                }

                @NotNull
                public final ImageView getIconIv() {
                    return this.iconIv;
                }

                @NotNull
                public final TextView getMessageTv() {
                    return this.messageTv;
                }

                @NotNull
                public final TextView getTitleTv() {
                    return this.titleTv;
                }
            }

            private final int VIEW_ITEM_MEMORIAL_ABLE;
            private final int VIEW_ITEM_MEMORIAL_DISABLE;

            public MemorialGridAdapter(@NotNull Context context0, @NotNull ArrayList arrayList0) {
                q.g(context0, "context");
                q.g(arrayList0, "list");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(context0, arrayList0);
                this.VIEW_ITEM_MEMORIAL_ABLE = 1;
                this.VIEW_ITEM_MEMORIAL_DISABLE = 2;
            }

            private final String getClickCopy(String s) {
                int v;
                switch(s) {
                    case "DEBUT_DAY": {
                        v = 0x7F131021;  // string:tiara_temperature_copy_debut_day "데뷔한 날"
                        break;
                    }
                    case "FAN_DAY": {
                        v = 0x7F131022;  // string:tiara_temperature_copy_fan_day "팬이된날"
                        break;
                    }
                    case "FIRST_LIKE_SONG": {
                        v = 0x7F131023;  // string:tiara_temperature_copy_first_like_song "처음 좋아한 곡"
                        break;
                    }
                    case "FIRST_SONG": {
                        v = 0x7F131024;  // string:tiara_temperature_copy_first_song "처음 들은 곡"
                        break;
                    }
                    case "HOT_DAY": {
                        v = 0x7F131026;  // string:tiara_temperature_copy_hot_day "가장 뜨거웠던 날"
                        break;
                    }
                    case "LAST_SONG": {
                        v = 0x7F131028;  // string:tiara_temperature_copy_last_song "마지막으로 들은곡"
                        break;
                    }
                    case "MAX_MONTH": {
                        v = 0x7F131029;  // string:tiara_temperature_copy_max_month "가장 많이 들은 달"
                        break;
                    }
                    case "TEMPERATURE_TOP": {
                        v = 0x7F13102C;  // string:tiara_temperature_copy_temperature_top "친밀도 상위 1%"
                        break;
                    }
                    default: {
                        v = 0x7F131020;  // string:tiara_temperature_copy_birth_day "아티스트 생일"
                    }
                }
                String s1 = ArtistDetailTemperatureFragment.this.getString(v);
                q.f(s1, "getString(...)");
                return s1;
            }

            // 去混淆评级： 低(20)
            @Override  // com.iloen.melon.adapters.common.p
            public int getItemViewTypeImpl(int v, int v1) {
                return q.b(((MEMORIALLIST)this.getItem(v1)).active, "Y") ? this.VIEW_ITEM_MEMORIAL_ABLE : this.VIEW_ITEM_MEMORIAL_DISABLE;
            }

            @Override  // com.iloen.melon.adapters.common.p
            public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
                int v2;
                String s3;
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.MEMORIALLIST");
                MEMORIALLIST artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0 = (MEMORIALLIST)object0;
                if(o00 != null) {
                    ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0 = ArtistDetailTemperatureAdapter.this;
                    ArtistDetailTemperatureFragment artistDetailTemperatureFragment0 = ArtistDetailTemperatureFragment.this;
                    if(o00 instanceof MemorialAbleViewHolder) {
                        String s = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
                        if(s == null) {
                            q.d(Glide.with(this.getContext()).load(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.bgImg).into(((MemorialAbleViewHolder)o00).getBgIv()));
                        }
                        else {
                            switch(s) {
                                case "BIRTH_DAY": 
                                case "DEBUT_DAY": 
                                case "FAN_DAY": {
                                    q.d(Glide.with(this.getContext()).asBitmap().load(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistImg).into(new CustomTarget() {
                                        @Override  // com.bumptech.glide.request.target.Target
                                        public void onLoadCleared(Drawable drawable0) {
                                        }

                                        public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                                            q.g(bitmap0, "resource");
                                            String s = o00.info.artistImg;
                                            q.f(s, "artistImg");
                                            ImageView imageView0 = ((MemorialAbleViewHolder)this.$this_apply).getBgIv();
                                            artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.drawBlurImage(s, bitmap0, imageView0);
                                        }

                                        @Override  // com.bumptech.glide.request.target.Target
                                        public void onResourceReady(Object object0, Transition transition0) {
                                            this.onResourceReady(((Bitmap)object0), transition0);
                                        }
                                    }));
                                    break;
                                }
                                case "FIRST_LIKE_SONG": 
                                case "FIRST_SONG": 
                                case "LAST_SONG": {
                                    q.d(Glide.with(this.getContext()).asBitmap().load(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.albumImg).into(new CustomTarget() {
                                        @Override  // com.bumptech.glide.request.target.Target
                                        public void onLoadCleared(Drawable drawable0) {
                                        }

                                        public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                                            q.g(bitmap0, "resource");
                                            ((MemorialAbleViewHolder)artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0).getThumbIv().setImageBitmap(bitmap0);
                                            String s = this.$item.info.albumImg;
                                            q.f(s, "albumImg");
                                            ImageView imageView0 = ((MemorialAbleViewHolder)artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0).getBgIv();
                                            artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.drawBlurImage(s, bitmap0, imageView0);
                                        }

                                        @Override  // com.bumptech.glide.request.target.Target
                                        public void onResourceReady(Object object0, Transition transition0) {
                                            this.onResourceReady(((Bitmap)object0), transition0);
                                        }
                                    }));
                                    break;
                                }
                                default: {
                                    q.d(Glide.with(this.getContext()).load(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.bgImg).into(((MemorialAbleViewHolder)o00).getBgIv()));
                                }
                            }
                        }
                        MemorialAbleViewHolder artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0 = (MemorialAbleViewHolder)o00;
                        String s1 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
                        q.f(s1, "type");
                        ((MemorialAbleViewHolder)o00).getTitleTv().setText(MemorialCardUtils.Companion.getMemorialTitle(this.getContext(), s1));
                        if(q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "HOT_DAY")) {
                            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv().setVisibility(8);
                            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getTemperatureLayout().setVisibility(0);
                        }
                        else {
                            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv().setVisibility(0);
                            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getTemperatureLayout().setVisibility(8);
                        }
                        String s2 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
                        if(s2 != null) {
                            switch(s2) {
                                case "BIRTH_DAY": 
                                case "DEBUT_DAY": {
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.defaultMsg);
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getThumbIv().setImageResource((q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "DEBUT_DAY") ? 0x7F080613 : 0x7F080612));  // drawable:img_artist_memories_debut
                                    break;
                                }
                                case "FAN_DAY": {
                                    String s6 = artistDetailTemperatureFragment0.getString(0x7F13015B);  // string:artist_memorial_fan_day_desc "만난지 %1$s일 째"
                                    q.f(s6, "getString(...)");
                                    Z.y(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.days}, 1, s6, artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv());
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getThumbIv().setImageResource(0x7F080614);  // drawable:img_artist_memories_fan
                                    break;
                                }
                                case "FIRST_LIKE_SONG": 
                                case "FIRST_SONG": 
                                case "LAST_SONG": {
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.songName);
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                                    break;
                                }
                                case "HOT_DAY": {
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getTemperatureTv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.userMaxTemper);
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getThumbIv().setImageResource(0x7F080616);  // drawable:img_artist_memories_hot
                                    break;
                                }
                                case "MAX_MONTH": {
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                                    String s5 = artistDetailTemperatureFragment0.getString(0x7F130166);  // string:artist_memorial_max_month_desc "%1$s회 감상"
                                    q.f(s5, "getString(...)");
                                    Z.y(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.streamCnt}, 1, s5, artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv());
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getThumbIv().setImageResource(0x7F080615);  // drawable:img_artist_memories_hear
                                    break;
                                }
                                case "TEMPERATURE_TOP": {
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                                    TextView textView0 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv();
                                    if(q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.days, "0")) {
                                        s3 = artistDetailTemperatureFragment0.getString(0x7F13016C);  // string:artist_memorial_temperature_top_desc "1% 달성!"
                                    }
                                    else {
                                        String s4 = artistDetailTemperatureFragment0.getString(0x7F13016D);  // string:artist_memorial_temperature_top_maintain_desc "%1$s일 동안 유지중"
                                        q.f(s4, "getString(...)");
                                        s3 = String.format(s4, Arrays.copyOf(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.days}, 1));
                                    }
                                    textView0.setText(s3);
                                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getThumbIv().setImageResource(0x7F080611);  // drawable:img_artist_memories_1percent
                                }
                            }
                        }
                        d d0 = new d(artistDetailTemperatureFragment0, artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0, this, 8);
                        o00.itemView.setOnClickListener(d0);
                        String s7 = q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "HOT_DAY") ? artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getTitleTv().getText() + ", " + artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getTemperatureTv().getText() + artistDetailTemperatureFragment0.getString(0x7F130B0B) + " " + artistDetailTemperatureFragment0.getString(0x7F130162) + ", " + artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv().getText() : artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getTitleTv().getText() + ", " + artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc1Tv().getText() + ", " + artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter$MemorialAbleViewHolder0.getDesc2Tv().getText();  // string:talkback_degree "도"
                        ViewUtils.setContentDescriptionWithButtonClassName(o00.itemView, s7);
                        return;
                    }
                    if(o00 instanceof MemorialDisableViewHolder) {
                        TextView textView1 = ((MemorialDisableViewHolder)o00).getTitleTv();
                        String s8 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
                        q.f(s8, "type");
                        textView1.setText(MemorialCardUtils.Companion.getMemorialTitle(this.getContext(), s8));
                        String s9 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
                        if(s9 == null) {
                            v2 = 0x7F0804BC;  // drawable:ic_moment_birthday_38
                        }
                        else {
                            switch(s9) {
                                case "DEBUT_DAY": {
                                    v2 = 0x7F0804BD;  // drawable:ic_moment_debut_38
                                    break;
                                }
                                case "FAN_DAY": {
                                    v2 = 0x7F0804BE;  // drawable:ic_moment_fan_38
                                    break;
                                }
                                case "FIRST_LIKE_SONG": {
                                    v2 = 0x7F0804C2;  // drawable:ic_moment_like_38
                                    break;
                                }
                                case "FIRST_SONG": {
                                    v2 = 0x7F0804BF;  // drawable:ic_moment_first_38
                                    break;
                                }
                                case "HOT_DAY": {
                                    v2 = 0x7F0804C0;  // drawable:ic_moment_hot_38
                                    break;
                                }
                                case "LAST_SONG": {
                                    v2 = 0x7F0804C1;  // drawable:ic_moment_last_38
                                    break;
                                }
                                case "MAX_MONTH": {
                                    v2 = 0x7F0804C3;  // drawable:ic_moment_listen_38
                                    break;
                                }
                                case "TEMPERATURE_TOP": {
                                    v2 = 0x7F0804BB;  // drawable:ic_moment_1_percent_38
                                    break;
                                }
                                default: {
                                    v2 = 0x7F0804BC;  // drawable:ic_moment_birthday_38
                                }
                            }
                        }
                        ((MemorialDisableViewHolder)o00).getIconIv().setImageResource(v2);
                        if(!q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "DEBUT_DAY") && !q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "BIRTH_DAY")) {
                            ((MemorialDisableViewHolder)o00).getMessageTv().setVisibility(0);
                            ((MemorialDisableViewHolder)o00).getDateTv().setVisibility(8);
                            ((MemorialDisableViewHolder)o00).getDateMessageTv().setVisibility(8);
                            ((MemorialDisableViewHolder)o00).getMessageTv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.defaultMsg);
                            return;
                        }
                        ((MemorialDisableViewHolder)o00).getMessageTv().setVisibility(8);
                        ((MemorialDisableViewHolder)o00).getDateTv().setVisibility(0);
                        ((MemorialDisableViewHolder)o00).getDateMessageTv().setVisibility(0);
                        ((MemorialDisableViewHolder)o00).getDateTv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                        ((MemorialDisableViewHolder)o00).getDateMessageTv().setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.defaultMsg);
                    }
                }
            }

            private static final void onBindViewImpl$lambda$2$lambda$1(ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, MEMORIALLIST artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0, MemorialGridAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter0, View view0) {
                String s = artistDetailTemperatureFragment0.getCacheKey();
                String s1 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
                q.f(s1, "type");
                Navigator.open(ArtistDetailMemorialCardFragment.Companion.newInstance(s, artistDetailTemperatureFragment0.artistId, artistDetailTemperatureFragment0.artistName, s1));
                f f0 = artistDetailTemperatureFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    f0.a = artistDetailTemperatureFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = artistDetailTemperatureFragment0.getString(0x7F13102E);  // string:tiara_temperature_layer1_memorial_card "메모리얼카드"
                    String s2 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
                    q.f(s2, "type");
                    f0.F = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialGridAdapter0.getClickCopy(s2);
                    f0.h = artistDetailTemperatureFragment0.artistName;
                    f0.a().track();
                }
            }

            @Override  // com.iloen.melon.adapters.common.p
            @NotNull
            public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
                if(v == this.VIEW_ITEM_MEMORIAL_ABLE) {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0041, viewGroup0, false);  // layout:artist_detail_temperature_memorial_card_able
                    q.f(view0, "inflate(...)");
                    return new MemorialAbleViewHolder(this, view0);
                }
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0042, viewGroup0, false);  // layout:artist_detail_temperature_memorial_card_disable
                q.f(view1, "inflate(...)");
                return new MemorialDisableViewHolder(this, view1);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialListViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/view/View;)V", "Landroidx/recyclerview/widget/RecyclerView;", "itemContainer", "Landroidx/recyclerview/widget/RecyclerView;", "getItemContainer", "()Landroidx/recyclerview/widget/RecyclerView;", "", "SPAN_COUNT", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MemorialListViewHolder extends O0 {
            private final int SPAN_COUNT;
            @NotNull
            private final RecyclerView itemContainer;

            public MemorialListViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A05A7);  // id:item_container
                q.f(view1, "findViewById(...)");
                this.itemContainer = (RecyclerView)view1;
                this.SPAN_COUNT = 2;
                GridLayoutManager gridLayoutManager0 = new GridLayoutManager(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.getContext(), 2);
                com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.MemorialListViewHolder.itemDecoration.1 artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialListViewHolder$itemDecoration$10 = new r0() {
                    @Override  // androidx.recyclerview.widget.r0
                    public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                        q.g(rect0, "outRect");
                        q.g(view0, "view");
                        q.g(recyclerView0, "parent");
                        q.g(k00, "state");
                        int v = recyclerView0.getChildAdapterPosition(view0);
                        if(v % MemorialListViewHolder.access$getSPAN_COUNT$p(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0) == 0) {
                            rect0.left = 0;
                            rect0.right = ScreenUtils.dipToPixel(ArtistDetailTemperatureAdapter.this.getContext(), 6.0f);
                        }
                        else {
                            rect0.left = ScreenUtils.dipToPixel(ArtistDetailTemperatureAdapter.this.getContext(), 6.0f);
                            rect0.right = 0;
                        }
                        j0 j00 = recyclerView0.getAdapter();
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.MemorialGridAdapter");
                        rect0.bottom = v / MemorialListViewHolder.access$getSPAN_COUNT$p(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0) >= (((MemorialGridAdapter)j00).getCount() - 1) / MemorialListViewHolder.access$getSPAN_COUNT$p(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0) ? 0 : ScreenUtils.dipToPixel(ArtistDetailTemperatureAdapter.this.getContext(), 11.0f);
                        rect0.top = 0;
                    }
                };
                ((RecyclerView)view1).setLayoutManager(gridLayoutManager0);
                ((RecyclerView)view1).addItemDecoration(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialListViewHolder$itemDecoration$10);
            }

            public static final int access$getSPAN_COUNT$p(MemorialListViewHolder artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialListViewHolder0) {
                return artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$MemorialListViewHolder0.SPAN_COUNT;
            }

            @NotNull
            public final RecyclerView getItemContainer() {
                return this.itemContainer;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$ServerDataWrapper;", "", "viewType", "", "data", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;ILjava/lang/Object;)V", "getViewType", "()I", "getData", "()Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ServerDataWrapper {
            @Nullable
            private final Object data;
            private final int viewType;

            public ServerDataWrapper(int v, @Nullable Object object0) {
                this.viewType = v;
                this.data = object0;
            }

            @Nullable
            public final Object getData() {
                return this.data;
            }

            public final int getViewType() {
                return this.viewType;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class TitleViewHolder extends O0 {
            @NotNull
            private final TextView title;

            public TitleViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0B8D);  // id:title
                q.f(view1, "findViewById(...)");
                this.title = (TextView)view1;
            }

            @NotNull
            public final TextView getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$TopStreamingSongViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/view/View;)V", "Landroid/widget/LinearLayout;", "itemContainer", "Landroid/widget/LinearLayout;", "getItemContainer", "()Landroid/widget/LinearLayout;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class TopStreamingSongViewHolder extends O0 {
            @NotNull
            private final LinearLayout itemContainer;

            public TopStreamingSongViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A05A7);  // id:item_container
                q.f(view1, "findViewById(...)");
                this.itemContainer = (LinearLayout)view1;
            }

            @NotNull
            public final LinearLayout getItemContainer() {
                return this.itemContainer;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0010\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0014\u0010\u0007\u001A\u0004\b\u0015\u0010\tR\u0017\u0010\u0016\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001A\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001A\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001A\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001A\u0010\u0007\u001A\u0004\b\u001B\u0010\tR\u0017\u0010\u001C\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b\u001C\u0010\f\u001A\u0004\b\u001D\u0010\u000ER\u0017\u0010\u001F\u001A\u00020\u001E8\u0006\u00A2\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"R\u0017\u0010#\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b#\u0010\u0011\u001A\u0004\b$\u0010\u0013R\u0017\u0010%\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b%\u0010\u0011\u001A\u0004\b&\u0010\u0013R\u0017\u0010\'\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b\'\u0010\u0011\u001A\u0004\b(\u0010\u0013R\u0017\u0010)\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b)\u0010\u0011\u001A\u0004\b*\u0010\u0013R\u0017\u0010+\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b+\u0010\u0007\u001A\u0004\b,\u0010\tR\u0017\u0010-\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b-\u0010\u0007\u001A\u0004\b.\u0010\tR\u0017\u0010/\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b/\u0010\u0007\u001A\u0004\b0\u0010\tR\u0017\u00102\u001A\u0002018\u0006\u00A2\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u00105\u00A8\u00066"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ArtistDetailTemperatureAdapter;Landroid/view/View;)V", "frameLayout", "Landroid/view/View;", "getFrameLayout", "()Landroid/view/View;", "Landroid/widget/ImageView;", "bgIv", "Landroid/widget/ImageView;", "getBgIv", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "temperatureTv", "Landroid/widget/TextView;", "getTemperatureTv", "()Landroid/widget/TextView;", "rankLayout", "getRankLayout", "rankTv", "getRankTv", "rankGapTv", "getRankGapTv", "defaultThumbBg", "getDefaultThumbBg", "defaultThumbIv", "getDefaultThumbIv", "Lcom/iloen/melon/custom/BorderImageView;", "thumbIv", "Lcom/iloen/melon/custom/BorderImageView;", "getThumbIv", "()Lcom/iloen/melon/custom/BorderImageView;", "artistTv", "getArtistTv", "streamingTv", "getStreamingTv", "likeTv", "getLikeTv", "shareTv", "getShareTv", "downloadIv", "getDownloadIv", "shareIv", "getShareIv", "rankToggleLayout", "getRankToggleLayout", "Landroid/widget/ToggleButton;", "rankToggleBtn", "Landroid/widget/ToggleButton;", "getRankToggleBtn", "()Landroid/widget/ToggleButton;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class UserTemperCardViewHolder extends O0 {
            @NotNull
            private final TextView artistTv;
            @NotNull
            private final ImageView bgIv;
            @NotNull
            private final View defaultThumbBg;
            @NotNull
            private final ImageView defaultThumbIv;
            @NotNull
            private final View downloadIv;
            @NotNull
            private final View frameLayout;
            @NotNull
            private final TextView likeTv;
            @NotNull
            private final TextView rankGapTv;
            @NotNull
            private final View rankLayout;
            @NotNull
            private final ToggleButton rankToggleBtn;
            @NotNull
            private final View rankToggleLayout;
            @NotNull
            private final TextView rankTv;
            @NotNull
            private final View shareIv;
            @NotNull
            private final TextView shareTv;
            @NotNull
            private final TextView streamingTv;
            @NotNull
            private final TextView temperatureTv;
            @NotNull
            private final BorderImageView thumbIv;

            public UserTemperCardViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A04DF);  // id:frame_layout
                q.f(view1, "findViewById(...)");
                this.frameLayout = view1;
                View view2 = view0.findViewById(0x7F0A0105);  // id:bg_iv
                q.f(view2, "findViewById(...)");
                this.bgIv = (ImageView)view2;
                View view3 = view0.findViewById(0x7F0A0B47);  // id:temperature_tv
                q.f(view3, "findViewById(...)");
                this.temperatureTv = (TextView)view3;
                View view4 = view0.findViewById(0x7F0A09B1);  // id:rank_layout
                q.f(view4, "findViewById(...)");
                this.rankLayout = view4;
                View view5 = view0.findViewById(0x7F0A09B4);  // id:rank_tv
                q.f(view5, "findViewById(...)");
                this.rankTv = (TextView)view5;
                View view6 = view0.findViewById(0x7F0A09AF);  // id:rank_gap_tv
                q.f(view6, "findViewById(...)");
                this.rankGapTv = (TextView)view6;
                View view7 = view0.findViewById(0x7F0A069D);  // id:iv_thumb_circle_default_bg
                q.f(view7, "findViewById(...)");
                this.defaultThumbBg = view7;
                View view8 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                q.f(view8, "findViewById(...)");
                this.defaultThumbIv = (ImageView)view8;
                View view9 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                q.f(view9, "findViewById(...)");
                this.thumbIv = (BorderImageView)view9;
                View view10 = view0.findViewById(0x7F0A00C2);  // id:artist_tv
                q.f(view10, "findViewById(...)");
                this.artistTv = (TextView)view10;
                View view11 = view0.findViewById(0x7F0A0784);  // id:listen_tv
                q.f(view11, "findViewById(...)");
                this.streamingTv = (TextView)view11;
                View view12 = view0.findViewById(0x7F0A076A);  // id:like_tv
                q.f(view12, "findViewById(...)");
                this.likeTv = (TextView)view12;
                View view13 = view0.findViewById(0x7F0A0A84);  // id:share_tv
                q.f(view13, "findViewById(...)");
                this.shareTv = (TextView)view13;
                View view14 = view0.findViewById(0x7F0A03ED);  // id:download_iv
                q.f(view14, "findViewById(...)");
                this.downloadIv = view14;
                View view15 = view0.findViewById(0x7F0A0A83);  // id:share_iv
                q.f(view15, "findViewById(...)");
                this.shareIv = view15;
                View view16 = view0.findViewById(0x7F0A09B3);  // id:rank_toggle_layout
                q.f(view16, "findViewById(...)");
                this.rankToggleLayout = view16;
                View view17 = view0.findViewById(0x7F0A09B2);  // id:rank_toggle_btn
                q.f(view17, "findViewById(...)");
                this.rankToggleBtn = (ToggleButton)view17;
                ((ImageView)view8).setImageResource(0x7F080788);  // drawable:noimage_logo_medium
                ((BorderImageView)view9).setBorderWidth(0);
            }

            @NotNull
            public final TextView getArtistTv() {
                return this.artistTv;
            }

            @NotNull
            public final ImageView getBgIv() {
                return this.bgIv;
            }

            @NotNull
            public final View getDefaultThumbBg() {
                return this.defaultThumbBg;
            }

            @NotNull
            public final ImageView getDefaultThumbIv() {
                return this.defaultThumbIv;
            }

            @NotNull
            public final View getDownloadIv() {
                return this.downloadIv;
            }

            @NotNull
            public final View getFrameLayout() {
                return this.frameLayout;
            }

            @NotNull
            public final TextView getLikeTv() {
                return this.likeTv;
            }

            @NotNull
            public final TextView getRankGapTv() {
                return this.rankGapTv;
            }

            @NotNull
            public final View getRankLayout() {
                return this.rankLayout;
            }

            @NotNull
            public final ToggleButton getRankToggleBtn() {
                return this.rankToggleBtn;
            }

            @NotNull
            public final View getRankToggleLayout() {
                return this.rankToggleLayout;
            }

            @NotNull
            public final TextView getRankTv() {
                return this.rankTv;
            }

            @NotNull
            public final View getShareIv() {
                return this.shareIv;
            }

            @NotNull
            public final TextView getShareTv() {
                return this.shareTv;
            }

            @NotNull
            public final TextView getStreamingTv() {
                return this.streamingTv;
            }

            @NotNull
            public final TextView getTemperatureTv() {
                return this.temperatureTv;
            }

            @NotNull
            public final BorderImageView getThumbIv() {
                return this.thumbIv;
            }
        }

        private final int VIEW_TYPE_HISTORY_DATE;
        private final int VIEW_TYPE_HISTORY_INFO;
        private final int VIEW_TYPE_HISTORY_MORE_BUTTON;
        private final int VIEW_TYPE_MEMORIALLIST;
        private final int VIEW_TYPE_TITLE;
        private final int VIEW_TYPE_TOPSTREAMINGSONG;
        private final int VIEW_TYPE_USERTEMPERCARD;
        private int displayHistoryDateCount;
        @Nullable
        private List fetchedHistoryList;
        private boolean hasMoreHistory;
        private int nextIdx;

        public ArtistDetailTemperatureAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
            super(context0, list0);
            this.VIEW_TYPE_USERTEMPERCARD = 1;
            this.VIEW_TYPE_TITLE = 2;
            this.VIEW_TYPE_HISTORY_DATE = 3;
            this.VIEW_TYPE_HISTORY_INFO = 4;
            this.VIEW_TYPE_HISTORY_MORE_BUTTON = 5;
            this.VIEW_TYPE_MEMORIALLIST = 6;
            this.VIEW_TYPE_TOPSTREAMINGSONG = 7;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void clearCache(@Nullable String s) {
            this.fetchedHistoryList = null;
            this.hasMoreHistory = false;
            this.nextIdx = 0;
            this.displayHistoryDateCount = 0;
            super.clearCache(s);
        }

        private final void drawBlurImage(String s, Bitmap bitmap0, ImageView imageView0) {
            Bitmap bitmap1 = (Bitmap)ArtistDetailTemperatureFragment.this.blurViewBgMap.get(s);
            if(bitmap1 != null) {
                imageView0.setImageBitmap(bitmap1);
                return;
            }
            ArtistDetailTemperatureFragment artistDetailTemperatureFragment0 = ArtistDetailTemperatureFragment.this;
            if(artistDetailTemperatureFragment0.getView() != null) {
                D d0 = artistDetailTemperatureFragment0.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getDefault(), null, new n(bitmap0, artistDetailTemperatureFragment0, s, imageView0, null) {
                    final ImageView $bgIv;
                    final String $imageUrl;
                    final Bitmap $source;
                    final ArtistDetailTemperatureAdapter $this_run;
                    int label;

                    {
                        this.$this_run = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                        this.$source = bitmap0;
                        ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
                        this.$imageUrl = s;
                        this.$bgIv = imageView0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.drawBlurImage.2.1(this.$this_run, this.$source, ArtistDetailTemperatureFragment.this, this.$imageUrl, this.$bgIv, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.drawBlurImage.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        Context context0 = this.$this_run.getContext();
                        q.f(context0, "access$getContext(...)");
                        Bitmap bitmap0 = Companion.drawPalette$default(LyricHighlightUtils.Companion, context0, this.$source, false, false, 12, null);
                        ArtistDetailTemperatureFragment.this.blurViewBgMap.put(this.$imageUrl, bitmap0);
                        H h0 = H.a;
                        if(ArtistDetailTemperatureFragment.this.getView() == null) {
                            return h0;
                        }
                        D d0 = ArtistDetailTemperatureFragment.this.getViewLifecycleOwner();
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
                                return new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.drawBlurImage.2.1.1(this.$bgIv, this.$bgBitmap, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.drawBlurImage.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
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

        private final void fetchMoreHistoryDate() {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(this, null) {
                private Object L$0;
                Object L$1;
                Object L$2;
                int label;

                {
                    ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
                    ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.fetchMoreHistoryDate.1(ArtistDetailTemperatureFragment.this, ArtistDetailTemperatureAdapter.this, continuation0);
                    continuation1.L$0 = object0;
                    return continuation1;
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.fetchMoreHistoryDate.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                    a a0 = a.a;
                    H h0 = H.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            Deferred deferred1 = ArtistDetailTemperatureFragment.this.requestArtistTemperatureDetailHistoryAsync(coroutineScope0, ArtistDetailTemperatureAdapter.this.getNextIdx());
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 1;
                            object0 = deferred1.await(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            Deferred deferred2 = (Deferred)this.L$1;
                            d5.n.D(object0);
                            break;
                        }
                        case 2: {
                            RESPONSE artistTemperatureDetailHistoryRes$RESPONSE0 = (RESPONSE)this.L$2;
                            Deferred deferred0 = (Deferred)this.L$1;
                            d5.n.D(object0);
                            return h0;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    if(((ArtistTemperatureDetailHistoryRes)object0) != null) {
                        RESPONSE artistTemperatureDetailHistoryRes$RESPONSE1 = ((ArtistTemperatureDetailHistoryRes)object0).response;
                        if(artistTemperatureDetailHistoryRes$RESPONSE1 != null) {
                            boolean z = q.b(artistTemperatureDetailHistoryRes$RESPONSE1.hasMore, "Y");
                            ArtistDetailTemperatureAdapter.this.setHasMoreHistory(z);
                            int v = 0;
                            try {
                                int v1 = artistTemperatureDetailHistoryRes$RESPONSE1.nextIdx == null ? 0 : Integer.parseInt(artistTemperatureDetailHistoryRes$RESPONSE1.nextIdx);
                                ArtistDetailTemperatureAdapter.this.setNextIdx(v1);
                            }
                            catch(NumberFormatException numberFormatException0) {
                                LogU.Companion.e("ArtistDetailTemperatureFragment", numberFormatException0.toString());
                            }
                            List list0 = artistTemperatureDetailHistoryRes$RESPONSE1.historyList;
                            if(list0 != null) {
                                ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0 = ArtistDetailTemperatureAdapter.this;
                                for(Object object1: list0) {
                                    HISTORYLIST artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0 = (HISTORYLIST)object1;
                                    List list1 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.getFetchedHistoryList();
                                    if(list1 != null) {
                                        list1.add(artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0);
                                    }
                                }
                            }
                            ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter1 = ArtistDetailTemperatureAdapter.this;
                            List list2 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter1.getFetchedHistoryList();
                            if(list2 != null) {
                                v = list2.size();
                            }
                            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter1.setDisplayHistoryDateCount(v);
                            com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.fetchMoreHistoryDate.1.2 artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$fetchMoreHistoryDate$1$20 = new n(null) {
                                int label;

                                {
                                    ArtistDetailTemperatureAdapter.this = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.fetchMoreHistoryDate.1.2(ArtistDetailTemperatureAdapter.this, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.fetchMoreHistoryDate.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    ArtistDetailTemperatureAdapter.updateAdapter$default(ArtistDetailTemperatureAdapter.this, null, false, 3, null);
                                    return H.a;
                                }
                            };
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 2;
                            if(BuildersKt.withContext(Dispatchers.getMain(), artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$fetchMoreHistoryDate$1$20, this) == a0) {
                                return a0;
                            }
                        }
                    }
                    return h0;
                }
            }, 3, null);
        }

        public final int getDisplayHistoryDateCount() {
            return this.displayHistoryDateCount;
        }

        @Nullable
        public final List getFetchedHistoryList() {
            return this.fetchedHistoryList;
        }

        public final boolean getHasMoreHistory() {
            return this.hasMoreHistory;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.ServerDataWrapper");
            return ((ServerDataWrapper)object0).getViewType();
        }

        public final int getNextIdx() {
            return this.nextIdx;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE artistTemperatureDetailRes$RESPONSE0 = ((ArtistTemperatureDetailRes)httpResponse0) == null ? null : ((ArtistTemperatureDetailRes)httpResponse0).response;
            if(artistTemperatureDetailRes$RESPONSE0 != null) {
                this.setMenuId(artistTemperatureDetailRes$RESPONSE0.menuId);
                this.updateModifiedTime(this.getCacheKey());
                ArtistDetailTemperatureAdapter.updateAdapter$default(this, artistTemperatureDetailRes$RESPONSE0, false, 2, null);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            int v3;
            int v2 = 8;
            if(o00 instanceof UserTemperCardViewHolder) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.ServerDataWrapper");
                Object object1 = ((ServerDataWrapper)object0).getData();
                q.e(object1, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE");
                USERTEMPERCARD artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0 = ((com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE)object1).userTemperCard;
                USERRANKINFO artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0 = artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0 == null ? null : artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.userRankInfo;
                if(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0 == null) {
                    v3 = -1;
                }
                else {
                    String s = artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.userTemper;
                    if(s == null) {
                        v3 = -1;
                    }
                    else {
                        Integer integer0 = v.t0(s);
                        v3 = integer0 == null ? -1 : ((int)integer0);
                    }
                }
                boolean z = v3 > 0 && (artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0 != null && (artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.totalUserRank != null && !o.H0(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.totalUserRank) == 1)) && (artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.userRank != null && !o.H0(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.userRank) == 1);
                ArtistDetailTemperatureFragment artistDetailTemperatureFragment0 = ArtistDetailTemperatureFragment.this;
                UserTemperCardViewHolder artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0 = (UserTemperCardViewHolder)o00;
                Glide.with(this.getContext()).asBitmap().load(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.artistImg).into(new CustomTarget() {
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                        q.g(bitmap0, "resource");
                        Glide.with(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getContext()).load(bitmap0).apply(RequestOptions.circleCropTransform()).into(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.getThumbIv());
                        artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.getDefaultThumbBg().setVisibility(8);
                        int v = ScreenUtils.dipToPixel(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getContext(), 0.5f);
                        artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.getThumbIv().setBorderWidth(v);
                        String s = this.$userTemperCard.artistImg;
                        q.f(s, "artistImg");
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.drawBlurImage(s, bitmap0, artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.getBgIv());
                    }

                    @Override  // com.bumptech.glide.request.target.Target
                    public void onResourceReady(Object object0, Transition transition0) {
                        this.onResourceReady(((Bitmap)object0), transition0);
                    }
                });
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getTemperatureTv().setText(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.userTemper);
                String s1 = artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.artistName;
                q.f(s1, "artistName");
                artistDetailTemperatureFragment0.artistName = s1;
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getArtistTv().setText(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.artistName);
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getTemperatureTv().setContentDescription(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.userTemper + artistDetailTemperatureFragment0.getString(0x7F130B0B));  // string:talkback_degree "도"
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankLayout().setVisibility((!z || !artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankToggleBtn().isChecked() ? 8 : 0));
                artistDetailTemperatureFragment0.isRankOn = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankLayout().getVisibility() == 0;
                if(z && artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0 != null) {
                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankTv().setText(artistDetailTemperatureFragment0.getString(0x7F130174, new Object[]{artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.totalUserRank, artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.userRank}));  // string:artist_temperature_fan_rank "%1$s명 중 %2$s번째 팬"
                    if(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.userRankCmpPrvDay != null && !o.H0(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.userRankCmpPrvDay) == 1) {
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankGapTv().setText(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD$USERRANKINFO0.userRankCmpPrvDay);
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankGapTv().setVisibility(0);
                    }
                }
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getStreamingTv().setText(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.streamingCnt);
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getLikeTv().setText(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.likeCnt);
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getShareTv().setText(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.shareCnt);
                String s2 = artistDetailTemperatureFragment0.getString(0x7F130C6E);  // string:talkback_times_count "회"
                q.f(s2, "getString(...)");
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getStreamingTv().setContentDescription(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.streamingCnt + s2);
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getLikeTv().setContentDescription(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.likeCnt + s2);
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getShareTv().setContentDescription(artistTemperatureDetailRes$RESPONSE$USERTEMPERCARD0.shareCnt + s2);
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getDownloadIv().setOnClickListener(new F(this, artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0, artistDetailTemperatureFragment0, 0));
                ViewUtils.setContentDescriptionWithButtonClassName(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getDownloadIv(), artistDetailTemperatureFragment0.getString(0x7F130C6C) + " " + artistDetailTemperatureFragment0.getString(0x7F130B1B));  // string:talkback_temperature_card "친밀도 카드"
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getShareIv().setOnClickListener(new F(this, artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0, artistDetailTemperatureFragment0, 1));
                ViewUtils.setContentDescriptionWithButtonClassName(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getShareIv(), artistDetailTemperatureFragment0.getString(0x7F130C6C) + " " + artistDetailTemperatureFragment0.getString(0x7F130C47));  // string:talkback_temperature_card "친밀도 카드"
                View view0 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankToggleLayout();
                if(z) {
                    v2 = 0;
                }
                view0.setVisibility(v2);
                if(z) {
                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankToggleBtn().setOnCheckedChangeListener((CompoundButton compoundButton0, boolean z) -> {
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getRankLayout().setVisibility((z ? 0 : 8));
                        artistDetailTemperatureFragment0.isRankOn = z;
                    });
                }
            }
            else {
                if(o00 instanceof TitleViewHolder) {
                    TextView textView0 = ((TitleViewHolder)o00).getTitle();
                    Object object2 = this.getItem(v1);
                    q.e(object2, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.ServerDataWrapper");
                    Object object3 = ((ServerDataWrapper)object2).getData();
                    q.e(object3, "null cannot be cast to non-null type kotlin.String");
                    textView0.setText(((String)object3));
                    return;
                }
                if(o00 instanceof HistoryDateViewHolder) {
                    Object object4 = this.getItem(v1);
                    q.e(object4, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.ServerDataWrapper");
                    Object object5 = ((ServerDataWrapper)object4).getData();
                    q.e(object5, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes.RESPONSE.HISTORYLIST");
                    HISTORYLIST artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0 = (HISTORYLIST)object5;
                    ((HistoryDateViewHolder)o00).getUpperLine().setVisibility((artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0.isFirstDate ? 8 : 0));
                    View view1 = ((HistoryDateViewHolder)o00).getBottomLine();
                    if(!artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0.isLastDate) {
                        v2 = 0;
                    }
                    view1.setVisibility(v2);
                    ((HistoryDateViewHolder)o00).getTemperature().setText(this.getContext().getString(0x7F1302E4, new Object[]{artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0.temperatureScore}));  // string:degree_symbol "%1$s°"
                    ((HistoryDateViewHolder)o00).getDate().setText(artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0.disPlayText);
                    try {
                        String s3 = artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST0.temperatureScore;
                        q.f(s3, "temperatureScore");
                        ((HistoryDateViewHolder)o00).getTemperature().setTextColor(ResourceUtils.getFriendlyColorId(this.getContext(), Integer.parseInt(s3)));
                    }
                    catch(NumberFormatException numberFormatException0) {
                        LogU.Companion.e("ArtistDetailTemperatureFragment", numberFormatException0.toString());
                    }
                    return;
                }
                if(o00 instanceof HistoryInfoViewHolder) {
                    Object object6 = this.getItem(v1);
                    q.e(object6, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.ServerDataWrapper");
                    Object object7 = ((ServerDataWrapper)object6).getData();
                    q.e(object7, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes.RESPONSE.HISTORYLIST.HISTORYINFO");
                    ((HistoryInfoViewHolder)o00).getLine().setVisibility((((HISTORYINFO)object7).isLastDate ? 8 : 0));
                    ((HistoryInfoViewHolder)o00).getMessage().setText(((HISTORYINFO)object7).historyText);
                    if(!q.b(((HISTORYINFO)object7).historyCode, "T01") && !q.b(((HISTORYINFO)object7).historyCode, "T02")) {
                        ((HistoryInfoViewHolder)o00).getTextLayout().setBackground(w.B(this.getContext(), 0x7F080890));  // drawable:shape_gradient_temperature_history_info
                        ((HistoryInfoViewHolder)o00).getIcon().setVisibility(0);
                        ((HistoryInfoViewHolder)o00).getMessage().setTypeface(d5.f.F(this.getContext()));
                        ((HistoryInfoViewHolder)o00).getMessage().setTextColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
                        ((HistoryInfoViewHolder)o00).getGapArrow().setVisibility(8);
                        ((HistoryInfoViewHolder)o00).getGapTemperature().setVisibility(8);
                        return;
                    }
                    ((HistoryInfoViewHolder)o00).getTextLayout().setBackground(w.B(this.getContext(), 0x7F0808AB));  // drawable:shape_rectangle_gray031s_0_5dp_stroke_round4_gray075a
                    ((HistoryInfoViewHolder)o00).getIcon().setVisibility(8);
                    ((HistoryInfoViewHolder)o00).getMessage().setTypeface(d5.f.G(this.getContext()));
                    ((HistoryInfoViewHolder)o00).getMessage().setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06016D));  // color:gray900s
                    boolean z1 = q.b(((HISTORYINFO)object7).historyCode, "T01");
                    ImageView imageView0 = ((HistoryInfoViewHolder)o00).getGapArrow();
                    imageView0.setVisibility(0);
                    imageView0.setImageResource((z1 ? 0x7F0803D7 : 0x7F0803DC));  // drawable:ic_common_arrow_down
                    TextView textView1 = ((HistoryInfoViewHolder)o00).getGapTemperature();
                    textView1.setVisibility(0);
                    textView1.setText(((HISTORYINFO)object7).scoreGap);
                    textView1.setTextColor(ColorUtils.getColor(textView1.getContext(), (z1 ? 0x7F060046 : 0x7F060447)));  // color:blue400s_support_high_contrast
                    return;
                }
                if(o00 instanceof HistoryMoreButtonViewHolder) {
                    ((HistoryMoreButtonViewHolder)o00).getLine().setVisibility((this.hasMoreHistory ? 0 : 4));
                    CharSequence charSequence0 = this.getContext().getText((this.hasMoreHistory ? 0x7F1306AE : 0x7F130104));  // string:more_title "더보기"
                    q.f(charSequence0, "getText(...)");
                    ((HistoryMoreButtonViewHolder)o00).getMore().setText(charSequence0);
                    ((HistoryMoreButtonViewHolder)o00).getMore().setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, (this.hasMoreHistory ? 0x7F080098 : 0x7F080095), 0);  // drawable:arrow_list_open_s
                    ViewUtils.setContentDescriptionWithButtonClassName(((HistoryMoreButtonViewHolder)o00).getMoreLayout(), charSequence0);
                    ((HistoryMoreButtonViewHolder)o00).getMoreLayout().setOnClickListener(new com.iloen.melon.fragments.artistchannel.q(this, 1));
                    return;
                }
                if(o00 instanceof MemorialListViewHolder) {
                    Object object8 = this.getItem(v1);
                    q.e(object8, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.ServerDataWrapper");
                    Object object9 = ((ServerDataWrapper)object8).getData();
                    q.e(object9, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.MEMORIALLIST>");
                    RecyclerView recyclerView0 = ((MemorialListViewHolder)o00).getItemContainer();
                    Context context0 = this.getContext();
                    q.f(context0, "getContext(...)");
                    recyclerView0.setAdapter(new MemorialGridAdapter(this, context0, ((ArrayList)object9)));
                    return;
                }
                if(o00 instanceof TopStreamingSongViewHolder) {
                    ((TopStreamingSongViewHolder)o00).getItemContainer().removeAllViews();
                    Object object10 = this.getItem(v1);
                    q.e(object10, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.ArtistDetailTemperatureAdapter.ServerDataWrapper");
                    Object object11 = ((ServerDataWrapper)object10).getData();
                    q.e(object11, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.TOPSTREAMINGSONG>");
                    int v4 = ((ArrayList)object11).size();
                    for(int v5 = 0; v5 < v4; ++v5) {
                        Object object12 = ((ArrayList)object11).get(v5);
                        q.f(object12, "get(...)");
                        LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
                        q.e(((TopStreamingSongViewHolder)o00).itemView, "null cannot be cast to non-null type android.view.ViewGroup");
                        View view2 = layoutInflater0.inflate(0x7F0D044F, ((ViewGroup)((TopStreamingSongViewHolder)o00).itemView), false);  // layout:list_item_artist_channel_favorite_song
                        ViewUtils.setDefaultImage(((ImageView)view2.findViewById(0x7F0A069E)), ScreenUtils.dipToPixel(this.getContext(), 44.0f));  // id:iv_thumb_default
                        Glide.with(this.getContext()).load(((TOPSTREAMINGSONG)object12).albumImg).into(((ImageView)view2.findViewById(0x7F0A069A)));  // id:iv_thumb
                        ((TextView)view2.findViewById(0x7F0A0BFE)).setText(((TOPSTREAMINGSONG)object12).songName);  // id:tvSongName
                        ((TextView)view2.findViewById(0x7F0A0BF4)).setText(((TOPSTREAMINGSONG)object12).artistName);  // id:tvArtistName
                        String s4 = StringUtils.getCountString(((TOPSTREAMINGSONG)object12).streamingCnt, 0x270F);
                        ((TextView)view2.findViewById(0x7F0A0BFB)).setText(s4);  // id:tvListenCount
                        ViewUtils.setOnClickListener(view2, new com.iloen.melon.fragments.artistchannel.p(ArtistDetailTemperatureFragment.this, ((TOPSTREAMINGSONG)object12), this, v5, 1));
                        String s5 = ArtistDetailTemperatureFragment.this.getString(0x7F130C74);  // string:talkback_top_streaming_song "%1$s, 아티스트 : %2$s, 음악감상 : %3$s회, 곡 재생하기"
                        q.f(s5, "getString(...)");
                        ViewUtils.setContentDescriptionWithButtonClassName(view2, String.format(s5, Arrays.copyOf(new Object[]{((TOPSTREAMINGSONG)object12).songName, ((TOPSTREAMINGSONG)object12).artistName, s4}, 3)));
                        ((TopStreamingSongViewHolder)o00).getItemContainer().addView(view2);
                    }
                }
            }
        }

        private static final void onBindViewImpl$lambda$12$lambda$10(ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, UserTemperCardViewHolder artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0, ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, View view0) {
            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.shareTemperatureCard(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getFrameLayout());
            f f0 = artistDetailTemperatureFragment0.getTiaraEventBuilder();
            if(f0 != null) {
                f0.a = artistDetailTemperatureFragment0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                f0.d = ActionKind.Share;
                f0.y = artistDetailTemperatureFragment0.getString(0x7F13102F);  // string:tiara_temperature_layer1_temperature_card "친밀도카드"
                f0.F = artistDetailTemperatureFragment0.getString(0x7F13102B);  // string:tiara_temperature_copy_share "공유"
                f0.a().track();
            }
        }

        // 检测为 Lambda 实现
        private static final void onBindViewImpl$lambda$12$lambda$11(UserTemperCardViewHolder artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0, ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, CompoundButton compoundButton0, boolean z) [...]

        private static final void onBindViewImpl$lambda$12$lambda$8(ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, UserTemperCardViewHolder artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0, ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, View view0) {
            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.saveTemperCard(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter$UserTemperCardViewHolder0.getFrameLayout());
            f f0 = artistDetailTemperatureFragment0.getTiaraEventBuilder();
            if(f0 != null) {
                f0.a = artistDetailTemperatureFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                f0.d = ActionKind.ClickContent;
                f0.y = artistDetailTemperatureFragment0.getString(0x7F13102F);  // string:tiara_temperature_layer1_temperature_card "친밀도카드"
                f0.F = artistDetailTemperatureFragment0.getString(0x7F13102A);  // string:tiara_temperature_copy_save "저장"
                f0.a().track();
            }
        }

        private static final void onBindViewImpl$lambda$15(ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, View view0) {
            if(!artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.hasMoreHistory) {
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.displayHistoryDateCount = 3;
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.hasMoreHistory = true;
                ArtistDetailTemperatureAdapter.updateAdapter$default(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, null, true, 1, null);
                return;
            }
            List list0 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.fetchedHistoryList;
            if(list0 != null) {
                int v = list0.size();
                int v1 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.displayHistoryDateCount;
                if(v > v1) {
                    if(v > v1 + 5) {
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.displayHistoryDateCount = v1 + 5;
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.hasMoreHistory = true;
                    }
                    else {
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.displayHistoryDateCount = v;
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.hasMoreHistory = false;
                    }
                    ArtistDetailTemperatureAdapter.updateAdapter$default(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, null, false, 3, null);
                    return;
                }
                artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.fetchMoreHistoryDate();
            }
        }

        private static final void onBindViewImpl$lambda$17(ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, TOPSTREAMINGSONG artistTemperatureDetailRes$RESPONSE$TOPSTREAMINGSONG0, ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, int v, View view0) {
            artistDetailTemperatureFragment0.playSong(artistTemperatureDetailRes$RESPONSE$TOPSTREAMINGSONG0.songId, artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.getMenuId());
            f f0 = artistDetailTemperatureFragment0.getTiaraEventBuilder();
            if(f0 != null) {
                f0.a = artistDetailTemperatureFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                f0.d = ActionKind.PlayMusic;
                f0.y = artistDetailTemperatureFragment0.getString(0x7F13102D);  // string:tiara_temperature_layer1_many_listen_song "많이들은곡"
                f0.c(v + 1);
                f0.e = artistTemperatureDetailRes$RESPONSE$TOPSTREAMINGSONG0.songId;
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                f0.g = artistTemperatureDetailRes$RESPONSE$TOPSTREAMINGSONG0.songName;
                f0.h = artistTemperatureDetailRes$RESPONSE$TOPSTREAMINGSONG0.artistName;
                f0.a().track();
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_USERTEMPERCARD) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0046, viewGroup0, false);  // layout:artist_detail_temperature_user_temper_card
                q.f(view0, "inflate(...)");
                return new UserTemperCardViewHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_TITLE) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0044, viewGroup0, false);  // layout:artist_detail_temperature_title
                q.f(view1, "inflate(...)");
                return new TitleViewHolder(this, view1);
            }
            if(v == this.VIEW_TYPE_HISTORY_DATE) {
                View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D003E, viewGroup0, false);  // layout:artist_detail_temperature_history_date
                q.f(view2, "inflate(...)");
                return new HistoryDateViewHolder(this, view2);
            }
            if(v == this.VIEW_TYPE_HISTORY_INFO) {
                View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D003F, viewGroup0, false);  // layout:artist_detail_temperature_history_info
                q.f(view3, "inflate(...)");
                return new HistoryInfoViewHolder(this, view3);
            }
            if(v == this.VIEW_TYPE_HISTORY_MORE_BUTTON) {
                View view4 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0040, viewGroup0, false);  // layout:artist_detail_temperature_history_more_button
                q.f(view4, "inflate(...)");
                return new HistoryMoreButtonViewHolder(this, view4);
            }
            if(v == this.VIEW_TYPE_MEMORIALLIST) {
                View view5 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0043, viewGroup0, false);  // layout:artist_detail_temperature_memorial_list
                q.f(view5, "inflate(...)");
                return new MemorialListViewHolder(this, view5);
            }
            if(v == this.VIEW_TYPE_TOPSTREAMINGSONG) {
                View view6 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0045, viewGroup0, false);  // layout:artist_detail_temperature_top_streaming_song
                q.f(view6, "inflate(...)");
                return new TopStreamingSongViewHolder(this, view6);
            }
            return null;
        }

        private final boolean saveCardFileFromView(Context context0, View view0, boolean z) {
            Bitmap bitmap0 = ViewUtils.getViewCapture(view0);
            Uri uri0 = null;
            if(bitmap0 != null) {
                try {
                    uri0 = FileUtils.INSTANCE.saveImageFile(context0, bitmap0, "melon_frcard_" + ArtistDetailTemperatureFragment.this.artistId + "_", z);
                }
                catch(IOException unused_ex) {
                }
                if(ArtistDetailTemperatureFragment.this.isRankOn) {
                    ArtistDetailTemperatureFragment.this.savedRankOnImageUri = uri0;
                    return uri0 != null;
                }
                ArtistDetailTemperatureFragment.this.savedRankOffImageUri = uri0;
            }
            return uri0 != null;
        }

        public static boolean saveCardFileFromView$default(ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, Context context0, View view0, boolean z, int v, Object object0) {
            if((v & 4) != 0) {
                z = false;
            }
            return artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.saveCardFileFromView(context0, view0, z);
        }

        private final void saveTemperCard(View view0) {
            Context context0 = this.getContext();
            if(context0 != null) {
                ArtistDetailTemperatureFragment artistDetailTemperatureFragment0 = ArtistDetailTemperatureFragment.this;
                if(ArtistDetailTemperatureAdapter.saveCardFileFromView$default(this, context0, view0, false, 4, null)) {
                    ToastManager.show(artistDetailTemperatureFragment0.getString(0x7F130172));  // string:artist_temperature_card_save "친밀도 카드가 저장되었습니다."
                    return;
                }
                ToastManager.show(artistDetailTemperatureFragment0.getString(0x7F130173));  // string:artist_temperature_card_save_fail "친밀도 카드 저장이 실패하였습니다."
            }
        }

        public final void setDisplayHistoryDateCount(int v) {
            this.displayHistoryDateCount = v;
        }

        public final void setFetchedHistoryList(@Nullable List list0) {
            this.fetchedHistoryList = list0;
        }

        public final void setHasMoreHistory(boolean z) {
            this.hasMoreHistory = z;
        }

        public final void setNextIdx(int v) {
            this.nextIdx = v;
        }

        private final void shareTemperatureCard(View view0) {
            Uri uri0 = ArtistDetailTemperatureFragment.this.isRankOn ? ArtistDetailTemperatureFragment.this.savedRankOnImageUri : ArtistDetailTemperatureFragment.this.savedRankOffImageUri;
            if((ArtistDetailTemperatureFragment.this.isRankOn ? ArtistDetailTemperatureFragment.this.shareRankOnImageData : ArtistDetailTemperatureFragment.this.shareRankOffImageData) != null) {
                Sharable sharable0 = ArtistDetailTemperatureFragment.this.getSNSSharable();
                ArtistDetailTemperatureFragment.this.showSNSListPopup(sharable0);
                return;
            }
            Context context0 = this.getContext();
            if(context0 != null) {
                ArtistDetailTemperatureFragment artistDetailTemperatureFragment0 = ArtistDetailTemperatureFragment.this;
                if(this.saveCardFileFromView(context0, view0, true)) {
                    uri0 = artistDetailTemperatureFragment0.isRankOn ? artistDetailTemperatureFragment0.savedRankOnImageUri : artistDetailTemperatureFragment0.savedRankOffImageUri;
                }
                else {
                    ToastManager.show(artistDetailTemperatureFragment0.getString(0x7F130173));  // string:artist_temperature_card_save_fail "친밀도 카드 저장이 실패하였습니다."
                }
            }
            if(uri0 != null) {
                ArtistDetailTemperatureFragment artistDetailTemperatureFragment1 = ArtistDetailTemperatureFragment.this;
                artistDetailTemperatureFragment1.showProgress(true);
                String s = FileUtils.INSTANCE.getImageFilePathForUri(this.getContext(), uri0);
                if(s != null) {
                    RequestBuilder.newInstance(new ArtistTemperatureShareImgReq(this.getContext(), "TEMPERATURE_CARD")).tag(artistDetailTemperatureFragment1.getRequestTag()).file("imgFile", new File(s)).listener(new com.iloen.melon.fragments.artistchannel.H(artistDetailTemperatureFragment1)).errorListener(new com.iloen.melon.fragments.artistchannel.H(artistDetailTemperatureFragment1)).request();
                    return;
                }
                artistDetailTemperatureFragment1.showProgress(false);
                ToastManager.show(artistDetailTemperatureFragment1.getString(0x7F130173));  // string:artist_temperature_card_save_fail "친밀도 카드 저장이 실패하였습니다."
            }
        }

        private static final void shareTemperatureCard$lambda$22$lambda$20(ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, ArtistTemperatureShareImgRes artistTemperatureShareImgRes0) {
            if(artistDetailTemperatureFragment0.isFragmentValid()) {
                artistDetailTemperatureFragment0.showProgress(false);
                if(artistTemperatureShareImgRes0.response != null) {
                    j.b(artistTemperatureShareImgRes0.notification, false, 3);
                    if(j.d(artistTemperatureShareImgRes0)) {
                        if(artistDetailTemperatureFragment0.isRankOn) {
                            artistDetailTemperatureFragment0.shareRankOnImageData = new ShareImageData(artistTemperatureShareImgRes0.response.imgUrl, artistTemperatureShareImgRes0.response.kageAccessKey);
                        }
                        else {
                            artistDetailTemperatureFragment0.shareRankOffImageData = new ShareImageData(artistTemperatureShareImgRes0.response.imgUrl, artistTemperatureShareImgRes0.response.kageAccessKey);
                        }
                        artistDetailTemperatureFragment0.showSNSListPopup(artistDetailTemperatureFragment0.getSNSSharable());
                    }
                }
            }
        }

        private static final void shareTemperatureCard$lambda$22$lambda$21(ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, VolleyError volleyError0) {
            artistDetailTemperatureFragment0.showProgress(false);
            ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }

        private final void updateAdapter(com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE artistTemperatureDetailRes$RESPONSE0, boolean z) {
            this.clear();
            if(artistTemperatureDetailRes$RESPONSE0.userTemperCard != null) {
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_USERTEMPERCARD, artistTemperatureDetailRes$RESPONSE0));
            }
            if(this.fetchedHistoryList != null && !this.fetchedHistoryList.isEmpty()) {
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_TITLE, "친밀도 히스토리"));
            }
            List list0 = this.fetchedHistoryList;
            if(list0 != null) {
                int v = 0;
                for(Object object0: list0) {
                    if(v >= 0) {
                        if(v >= this.displayHistoryDateCount) {
                            break;
                        }
                        if(((HISTORYLIST)object0) != null) {
                            List list1 = ((HISTORYLIST)object0).historyInfo;
                            if(list1 != null) {
                                boolean z1 = !this.hasMoreHistory && (this.fetchedHistoryList != null && v == k.s(this.fetchedHistoryList));
                                ((HISTORYLIST)object0).isLastDate = z1;
                                ((HISTORYLIST)object0).isFirstDate = v == 0;
                                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_HISTORY_DATE, ((HISTORYLIST)object0)));
                                for(Object object1: list1) {
                                    HISTORYINFO artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST$HISTORYINFO0 = (HISTORYINFO)object1;
                                    if(artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST$HISTORYINFO0 != null) {
                                        artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST$HISTORYINFO0.isLastDate = z1;
                                        this.add(new ServerDataWrapper(this, this.VIEW_TYPE_HISTORY_INFO, artistTemperatureDetailHistoryRes$RESPONSE$HISTORYLIST$HISTORYINFO0));
                                    }
                                }
                            }
                        }
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
            if(this.hasMoreHistory || this.displayHistoryDateCount > 3) {
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_HISTORY_MORE_BUTTON, null));
            }
            ArrayList arrayList0 = artistTemperatureDetailRes$RESPONSE0.memorialList;
            if(arrayList0 != null) {
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_TITLE, "기억되는 순간들"));
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_MEMORIALLIST, arrayList0));
            }
            ArrayList arrayList1 = artistTemperatureDetailRes$RESPONSE0.topStreamingSong;
            if(arrayList1 != null && !arrayList1.isEmpty()) {
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_TITLE, "많이 들은 곡"));
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_TOPSTREAMINGSONG, arrayList1));
            }
            if(z) {
                ArtistDetailTemperatureFragment.this.getRecyclerView().scrollToPosition(1);
            }
        }

        public static void updateAdapter$default(ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0, com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE artistTemperatureDetailRes$RESPONSE0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                ResponseBase responseBase0 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.getResponse().getResponse();
                q.e(responseBase0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE");
                artistTemperatureDetailRes$RESPONSE0 = (com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE)responseBase0;
            }
            if((v & 2) != 0) {
                z = false;
            }
            artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.updateAdapter(artistTemperatureDetailRes$RESPONSE0, z);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$Companion;", "", "<init>", "()V", "TAG", "", "CACHE_KEY_SUB_NAME", "FR_FILE_NAME", "INITIAL_HISTORY_DATE_SIZE", "", "MORE_HISTORY_DATE_SIZE", "HISTORY_TITLE_INDEX", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment;", "artistId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.Companion {
        private com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.Companion() {
        }

        public com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailTemperatureFragment newInstance(@NotNull String s) {
            q.g(s, "artistId");
            ArtistDetailTemperatureFragment artistDetailTemperatureFragment0 = new ArtistDetailTemperatureFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            bundle0.putBoolean("argIsLoginRequired", true);
            artistDetailTemperatureFragment0.setArguments(bundle0);
            return artistDetailTemperatureFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailTemperatureFragment$ShareImageData;", "", "shareImagePath", "", "shareImageAccessKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getShareImagePath", "()Ljava/lang/String;", "getShareImageAccessKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ShareImageData {
        @Nullable
        private final String shareImageAccessKey;
        @Nullable
        private final String shareImagePath;

        public ShareImageData(@Nullable String s, @Nullable String s1) {
            this.shareImagePath = s;
            this.shareImageAccessKey = s1;
        }

        @Nullable
        public final String getShareImageAccessKey() {
            return this.shareImageAccessKey;
        }

        @Nullable
        public final String getShareImagePath() {
            return this.shareImagePath;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String CACHE_KEY_SUB_NAME = "temperature";
    @NotNull
    public static final com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.Companion Companion = null;
    @NotNull
    private static final String FR_FILE_NAME = "melon_frcard_";
    private static final int HISTORY_TITLE_INDEX = 1;
    private static final int INITIAL_HISTORY_DATE_SIZE = 3;
    private static final int MORE_HISTORY_DATE_SIZE = 5;
    @NotNull
    private static final String TAG = "ArtistDetailTemperatureFragment";
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private Map blurViewBgMap;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    private boolean isRankOn;
    @Nullable
    private Uri savedRankOffImageUri;
    @Nullable
    private Uri savedRankOnImageUri;
    @Nullable
    private ShareImageData shareRankOffImageData;
    @Nullable
    private ShareImageData shareRankOnImageData;

    static {
        ArtistDetailTemperatureFragment.Companion = new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.Companion(null);
        ArtistDetailTemperatureFragment.$stable = 8;
    }

    public ArtistDetailTemperatureFragment() {
        this.artistId = "";
        this.artistName = "";
        this.blurViewBgMap = new LinkedHashMap();
        this.exceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                LogU.Companion.e("ArtistDetailTemperatureFragment", "onFetchStart() error, exceptionHandler " + throwable0.getMessage());
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.exceptionHandler.1.1(throwable0, ArtistDetailTemperatureFragment.this, null), 3, null);
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment$exceptionHandler$1$1", f = "ArtistDetailTemperatureFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.exceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.exceptionHandler.1.1(Throwable throwable0, ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.exceptionHandler.1.1(this.$throwable, ArtistDetailTemperatureFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.exceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Throwable throwable0 = this.$throwable;
                if(throwable0 instanceof VolleyError) {
                    ArtistDetailTemperatureFragment.access$performFetchError(ArtistDetailTemperatureFragment.this, ((VolleyError)throwable0));
                }
                return H.a;
            }
        }

    }

    public static final void access$performFetchError(ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, VolleyError volleyError0) {
        artistDetailTemperatureFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new ArtistDetailTemperatureAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.b.buildUpon().appendPath("temperature"), this.artistId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public Sharable getSNSSharable() {
        String s3;
        ShareImageData artistDetailTemperatureFragment$ShareImageData0 = this.isRankOn ? this.shareRankOnImageData : this.shareRankOffImageData;
        Uri uri0 = this.isRankOn ? this.savedRankOnImageUri : this.savedRankOffImageUri;
        String s = this.artistId;
        q.g(s, "artistId");
        String s1 = this.artistName;
        q.g(s1, "artistName");
        String s2 = "";
        if(artistDetailTemperatureFragment$ShareImageData0 == null) {
            s3 = "";
        }
        else {
            s3 = artistDetailTemperatureFragment$ShareImageData0.getShareImagePath();
            if(s3 == null) {
                s3 = "";
            }
        }
        if(artistDetailTemperatureFragment$ShareImageData0 != null) {
            String s4 = artistDetailTemperatureFragment$ShareImageData0.getShareImageAccessKey();
            if(s4 != null) {
                s2 = s4;
            }
        }
        Sharable sharable0 = new SharableTemperatureCard();  // 初始化器: Ljava/lang/Object;-><init>()V
        sharable0.a = s;
        sharable0.b = s3;
        sharable0.d = s1;
        sharable0.e = s2;
        sharable0.f = String.valueOf(uri0);
        return sharable0;
    }

    private final f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.artistId;
        f0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
        f0.q = this.artistName;
        f0.I = this.mMelonTiaraProperty.c;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @NotNull
    public static final ArtistDetailTemperatureFragment newInstance(@NotNull String s) {
        return ArtistDetailTemperatureFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(false);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0295, viewGroup0, false);  // layout:fragment_artist_detail_temperature
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.getAdapter();
        com.iloen.melon.responsecache.a.c(this.getContext(), this.getCacheKey(), true);
        if(((ArtistDetailTemperatureAdapter)j00) != null) {
            ((ArtistDetailTemperatureAdapter)j00).clear();
        }
        this.savedRankOnImageUri = null;
        this.savedRankOffImageUri = null;
        this.shareRankOnImageData = null;
        this.shareRankOffImageData = null;
        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), completableJob0.plus(this.exceptionHandler), null, new n(((ArtistDetailTemperatureAdapter)j00), completableJob0, i0, null) {
            final ArtistDetailTemperatureAdapter $adapter;
            final CompletableJob $supervisor;
            final i $type;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;

            {
                ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
                this.$adapter = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0;
                this.$supervisor = completableJob0;
                this.$type = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.onFetchStart.1(ArtistDetailTemperatureFragment.this, this.$adapter, this.$supervisor, this.$type, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                int v1;
                ArtistTemperatureDetailRes artistTemperatureDetailRes1;
                Deferred deferred3;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                a a0 = a.a;
                int v = 0;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred2 = ArtistDetailTemperatureFragment.this.requestArtistTemperatureDetailAsync(coroutineScope0);
                        deferred3 = ArtistDetailTemperatureFragment.requestArtistTemperatureDetailHistoryAsync$default(ArtistDetailTemperatureFragment.this, coroutineScope0, 0, 2, null);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = deferred3;
                        this.label = 1;
                        object0 = deferred2.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_24;
                    }
                    case 1: {
                        deferred3 = (Deferred)this.L$2;
                        Deferred deferred4 = (Deferred)this.L$1;
                        d5.n.D(object0);
                    label_24:
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = (ArtistTemperatureDetailRes)object0;
                        this.label = 2;
                        Object object1 = deferred3.await(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        artistTemperatureDetailRes1 = (ArtistTemperatureDetailRes)object0;
                        object0 = object1;
                        break;
                    }
                    case 2: {
                        ArtistTemperatureDetailRes artistTemperatureDetailRes2 = (ArtistTemperatureDetailRes)this.L$3;
                        Deferred deferred5 = (Deferred)this.L$2;
                        Deferred deferred6 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        artistTemperatureDetailRes1 = artistTemperatureDetailRes2;
                        break;
                    }
                    case 3: {
                        ArtistTemperatureDetailHistoryRes artistTemperatureDetailHistoryRes0 = (ArtistTemperatureDetailHistoryRes)this.L$4;
                        ArtistTemperatureDetailRes artistTemperatureDetailRes0 = (ArtistTemperatureDetailRes)this.L$3;
                        Deferred deferred0 = (Deferred)this.L$2;
                        Deferred deferred1 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                ArtistTemperatureDetailHistoryRes artistTemperatureDetailHistoryRes1 = (ArtistTemperatureDetailHistoryRes)object0;
                ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0 = this.$adapter;
                if(artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0 != null) {
                    RESPONSE artistTemperatureDetailHistoryRes$RESPONSE0 = artistTemperatureDetailHistoryRes1 == null ? null : artistTemperatureDetailHistoryRes1.response;
                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.setFetchedHistoryList((artistTemperatureDetailHistoryRes$RESPONSE0 == null ? null : artistTemperatureDetailHistoryRes$RESPONSE0.historyList));
                    if(artistTemperatureDetailHistoryRes$RESPONSE0 == null) {
                        v1 = 0;
                    }
                    else {
                        List list0 = artistTemperatureDetailHistoryRes$RESPONSE0.historyList;
                        v1 = list0 == null ? 0 : list0.size();
                    }
                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.setDisplayHistoryDateCount(v1);
                    artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.setHasMoreHistory(q.b((artistTemperatureDetailHistoryRes$RESPONSE0 == null ? null : artistTemperatureDetailHistoryRes$RESPONSE0.hasMore), "Y"));
                    try {
                        if(artistTemperatureDetailHistoryRes1 != null) {
                            RESPONSE artistTemperatureDetailHistoryRes$RESPONSE1 = artistTemperatureDetailHistoryRes1.response;
                            if(artistTemperatureDetailHistoryRes$RESPONSE1 != null) {
                                String s = artistTemperatureDetailHistoryRes$RESPONSE1.nextIdx;
                                if(s != null) {
                                    v = Integer.parseInt(s);
                                }
                            }
                        }
                        artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.setNextIdx(v);
                    }
                    catch(NumberFormatException numberFormatException0) {
                        LogU.Companion.e("ArtistDetailTemperatureFragment", numberFormatException0.toString());
                    }
                }
                com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.onFetchStart.1.2 artistDetailTemperatureFragment$onFetchStart$1$20 = new n(artistTemperatureDetailRes1, this.$supervisor, this.$type, null) {
                    final ArtistTemperatureDetailRes $artistTemperatureDetailRes;
                    final CompletableJob $supervisor;
                    final i $type;
                    int label;

                    {
                        ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
                        this.$artistTemperatureDetailRes = artistTemperatureDetailRes0;
                        this.$supervisor = completableJob0;
                        this.$type = i0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.onFetchStart.1.2(ArtistDetailTemperatureFragment.this, this.$artistTemperatureDetailRes, this.$supervisor, this.$type, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.onFetchStart.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        boolean z = ArtistDetailTemperatureFragment.this.prepareFetchComplete(this.$artistTemperatureDetailRes);
                        H h0 = H.a;
                        if(!z) {
                            DefaultImpls.cancel$default(this.$supervisor, null, 1, null);
                            return h0;
                        }
                        com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE artistTemperatureDetailRes$RESPONSE0 = this.$artistTemperatureDetailRes.response;
                        if(artistTemperatureDetailRes$RESPONSE0 == null) {
                            DefaultImpls.cancel$default(this.$supervisor, null, 1, null);
                            return h0;
                        }
                        s s0 = new s(artistTemperatureDetailRes$RESPONSE0.section, artistTemperatureDetailRes$RESPONSE0.page, artistTemperatureDetailRes$RESPONSE0.menuId, null);
                        ArtistDetailTemperatureFragment.this.mMelonTiaraProperty = s0;
                        Context context0 = ArtistDetailTemperatureFragment.this.getContext();
                        String s1 = ArtistDetailTemperatureFragment.this.getCacheKey();
                        com.iloen.melon.responsecache.a.a(context0, this.$artistTemperatureDetailRes, s1);
                        ArtistDetailTemperatureFragment.this.performFetchComplete(this.$type, this.$artistTemperatureDetailRes);
                        return h0;
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                return BuildersKt.withContext(Dispatchers.getMain(), artistDetailTemperatureFragment$onFetchStart$1$20, this) == a0 ? a0 : H.a;
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        if(bundle0.containsKey("argItemId")) {
            String s = bundle0.getString("argItemId");
            if(s == null) {
                s = "";
            }
            this.artistId = s;
        }
        Y.w("onRestoreInstanceState() >> artistId: ", this.artistId, LogU.Companion, "ArtistDetailTemperatureFragment");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.artistId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        F8.p p0 = new F8.p(1);
        m m0 = new m(2, false);
        x x0 = new x(2);
        x0.c = new com.iloen.melon.fragments.artistchannel.q(this, 3);
        TitleBar titleBar0 = this.getTitleBar();
        p0.g(m0);
        p0.g(x0);
        titleBar0.a(p0);
        this.getTitleBar().setTitle(this.getString(0x7F130176));  // string:artist_temperature_title "나와의 친밀도"
    }

    private static final void onViewCreated$lambda$4(ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, View view0) {
        j0 j00 = artistDetailTemperatureFragment0.getAdapter();
        com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE artistTemperatureDetailRes$RESPONSE0 = null;
        ArtistDetailTemperatureAdapter artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0 = j00 instanceof ArtistDetailTemperatureAdapter ? ((ArtistDetailTemperatureAdapter)j00) : null;
        HttpResponse httpResponse0 = artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0 == null ? null : artistDetailTemperatureFragment$ArtistDetailTemperatureAdapter0.getResponse();
        ArtistTemperatureDetailRes artistTemperatureDetailRes0 = httpResponse0 instanceof ArtistTemperatureDetailRes ? ((ArtistTemperatureDetailRes)httpResponse0) : null;
        if(artistTemperatureDetailRes0 != null) {
            artistTemperatureDetailRes$RESPONSE0 = artistTemperatureDetailRes0.response;
        }
        if(artistTemperatureDetailRes$RESPONSE0 != null) {
            GUIDE artistTemperatureDetailRes$RESPONSE$GUIDE0 = artistTemperatureDetailRes$RESPONSE0.guide;
            if(artistTemperatureDetailRes$RESPONSE$GUIDE0 != null) {
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                melonLinkInfo0.a = artistTemperatureDetailRes$RESPONSE$GUIDE0.linkType;
                melonLinkInfo0.b = artistTemperatureDetailRes$RESPONSE$GUIDE0.linkUrl;
                MelonLinkExecutor.open(melonLinkInfo0);
                f f0 = artistDetailTemperatureFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    f0.a = artistDetailTemperatureFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = artistDetailTemperatureFragment0.getString(0x7F13102F);  // string:tiara_temperature_layer1_temperature_card "친밀도카드"
                    f0.F = artistDetailTemperatureFragment0.getString(0x7F131025);  // string:tiara_temperature_copy_guide "안내"
                    f0.a().track();
                }
            }
        }
    }

    private final Deferred requestArtistTemperatureDetailAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.requestArtistTemperatureDetailAsync.1(ArtistDetailTemperatureFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.requestArtistTemperatureDetailAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistTemperatureDetailReq(ArtistDetailTemperatureFragment.this.getContext(), ArtistDetailTemperatureFragment.this.artistId, true)).tag(ArtistDetailTemperatureFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes");
                return (ArtistTemperatureDetailRes)httpResponse0;
            }
        }, 3, null);
    }

    private final Deferred requestArtistTemperatureDetailHistoryAsync(CoroutineScope coroutineScope0, int v) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(v, null) {
            final int $startIdx;
            int label;

            {
                ArtistDetailTemperatureFragment.this = artistDetailTemperatureFragment0;
                this.$startIdx = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.requestArtistTemperatureDetailHistoryAsync.1(ArtistDetailTemperatureFragment.this, this.$startIdx, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment.requestArtistTemperatureDetailHistoryAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    try {
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistTemperatureDetailHistoryReq(ArtistDetailTemperatureFragment.this.getContext(), ArtistDetailTemperatureFragment.this.artistId, String.valueOf(this.$startIdx))).tag(ArtistDetailTemperatureFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes");
                        return (ArtistTemperatureDetailHistoryRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        b.w("requestArtistTemperatureDetailHistoryAsync() exception, ", exception0.getMessage(), LogU.Companion, "ArtistDetailTemperatureFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    public static Deferred requestArtistTemperatureDetailHistoryAsync$default(ArtistDetailTemperatureFragment artistDetailTemperatureFragment0, CoroutineScope coroutineScope0, int v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        return artistDetailTemperatureFragment0.requestArtistTemperatureDetailHistoryAsync(coroutineScope0, v);
    }
}

