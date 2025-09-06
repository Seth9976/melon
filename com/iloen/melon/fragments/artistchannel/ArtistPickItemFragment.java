package com.iloen.melon.fragments.artistchannel;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.firebase.b;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.UserActionsReq.Params;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.request.ArtistPickUserActionCntReq;
import com.iloen.melon.net.v6x.response.ArtistPickRes.RESPONSE.ARTISTPICK;
import com.iloen.melon.net.v6x.response.ArtistPickUserActionCntRes.RESPONSE.USERACTIONCNTLIST;
import com.iloen.melon.net.v6x.response.ArtistPickUserActionCntRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistPickUserActionCntRes;
import com.iloen.melon.player.trackzero.SinglePlayer;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableArtistPick;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.AlbumInfoBase;
import ie.H;
import java.util.ArrayList;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import m4.e;
import m4.g;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.c;
import v9.h;
import we.n;

@Metadata(d1 = {"\u0000\u00AE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0002qpB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\b\u0010\u0007J\u000F\u0010\t\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\t\u0010\u0007J\u001D\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0011\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0007J-\u0010\u0019\u001A\u00020\u00052\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001BH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b!\u0010\u001FJ-\u0010(\u001A\u0004\u0018\u00010\'2\u0006\u0010#\u001A\u00020\"2\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010&\u001A\u0004\u0018\u00010\u001BH\u0016\u00A2\u0006\u0004\b(\u0010)J!\u0010+\u001A\u00020\u001D2\u0006\u0010*\u001A\u00020\'2\b\u0010&\u001A\u0004\u0018\u00010\u001BH\u0016\u00A2\u0006\u0004\b+\u0010,J\u0017\u0010/\u001A\u00020\u001D2\u0006\u0010.\u001A\u00020-H\u0016\u00A2\u0006\u0004\b/\u00100J\u000F\u00101\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b1\u0010\u0004J\u000F\u00103\u001A\u000202H\u0014\u00A2\u0006\u0004\b3\u00104J\u0015\u00106\u001A\u00020\u001D2\u0006\u00105\u001A\u00020\u0005\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\b8\u0010\u0004J\u001A\u0010:\u001A\u0004\u0018\u00010\u001D2\u0006\u00109\u001A\u00020\u0002H\u0082@\u00A2\u0006\u0004\b:\u0010;J\u001A\u0010<\u001A\u0004\u0018\u00010\u001D2\u0006\u00109\u001A\u00020\u0002H\u0082@\u00A2\u0006\u0004\b<\u0010;J\u0017\u0010=\u001A\u00020\u001D2\u0006\u0010*\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b=\u0010>J\u000F\u0010?\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\b?\u0010\u0004J#\u0010B\u001A\u00020\u001D2\b\u0010@\u001A\u0004\u0018\u00010\u00172\b\u0010A\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\bB\u0010CJ\u000F\u0010D\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\bD\u0010\u0004J\u000F\u0010E\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\bE\u0010\u0004J\u000F\u0010F\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\bF\u0010\u0004J\u000F\u0010G\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\bG\u0010\u0004J\u000F\u0010H\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\bH\u0010\u0004R\u0018\u0010J\u001A\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010O\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010MR\u0018\u0010Q\u001A\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001A\u00020S8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001A\u00020V8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001A\u00020\'8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bY\u0010ZR.\u0010]\u001A\u0004\u0018\u00010[2\b\u0010\\\u001A\u0004\u0018\u00010[8\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b]\u0010^\u001A\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0014\u0010d\u001A\u00020c8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bd\u0010eR\u0013\u0010h\u001A\u0004\u0018\u00010\u00178F\u00A2\u0006\u0006\u001A\u0004\bf\u0010gR\u0011\u0010k\u001A\u00020V8F\u00A2\u0006\u0006\u001A\u0004\bi\u0010jR\u0014\u0010o\u001A\u00020l8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bm\u0010n\u00A8\u0006r"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment;", "Lcom/iloen/melon/fragments/FetcherBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "shouldIgnoreSetUIOnForegroundEvent", "()Z", "shouldShowMiniPlayer", "isBottomTabFragment", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "isScreenLandscapeSupported", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroy", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "visible", "activateWidgets", "(Z)V", "setCommonContentsMargin", "scope", "requestUserActionCountApi", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUserActionApi", "onClickLike", "(Landroid/view/View;)V", "onClickComment", "likeCount", "isLike", "updateLikeView", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "sendTiaraLogAlbumDetail", "sendTiaraLogLike", "sendTiaraLogComment", "sendTiaraLogViewAll", "sendTiaraLogShare", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE$ARTISTPICK;", "artistPick", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE$ARTISTPICK;", "section", "Ljava/lang/String;", "page", "bbsChannelSeq", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$OnArtistPickItemListener;", "onArtistPickItemListener", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$OnArtistPickItemListener;", "Lcom/google/android/exoplayer2/ui/PlayerView;", "exoPlayerView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "Landroid/widget/ImageView;", "imgStill", "Landroid/widget/ImageView;", "commonContents", "Landroid/view/View;", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "value", "singlePlayer", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "getSinglePlayer", "()Lcom/iloen/melon/player/trackzero/SinglePlayer;", "setSinglePlayer", "(Lcom/iloen/melon/player/trackzero/SinglePlayer;)V", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "subExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getMvUrl", "()Ljava/lang/String;", "mvUrl", "getStillView", "()Landroid/widget/ImageView;", "stillView", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "OnArtistPickItemListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistPickItemFragment extends FetcherBaseFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_ARTIST_PICK", "ARG_BBS_CHANNEL_SEQ", "ARG_SECTION", "ARG_PAGE", "ALBUM_IMAGE_WIDTH", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment;", "slotItem", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE$ARTISTPICK;", "bbsChannelSeq", "section", "page", "menuId", "onArtistPickItemListener", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$OnArtistPickItemListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistPickItemFragment newInstance(@NotNull ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0, @NotNull String s, @Nullable String s1, @Nullable String s2, @NotNull String s3, @NotNull OnArtistPickItemListener artistPickItemFragment$OnArtistPickItemListener0) {
            q.g(artistPickRes$RESPONSE$ARTISTPICK0, "slotItem");
            q.g(s, "bbsChannelSeq");
            q.g(s3, "menuId");
            q.g(artistPickItemFragment$OnArtistPickItemListener0, "onArtistPickItemListener");
            ArtistPickItemFragment artistPickItemFragment0 = new ArtistPickItemFragment();
            artistPickItemFragment0.onArtistPickItemListener = artistPickItemFragment$OnArtistPickItemListener0;
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("argArtistPick", artistPickRes$RESPONSE$ARTISTPICK0);
            bundle0.putString("argSection", s1);
            bundle0.putString("argPage", s2);
            bundle0.putString("argMenuId", s3);
            bundle0.putString("argBbsChannelSeq", s);
            artistPickItemFragment0.setArguments(bundle0);
            return artistPickItemFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$OnArtistPickItemListener;", "", "Lcom/iloen/melon/sns/model/Sharable;", "sharable", "Lie/H;", "onShareClickListener", "(Lcom/iloen/melon/sns/model/Sharable;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnArtistPickItemListener {
        void onShareClickListener(@NotNull Sharable arg1);
    }

    public static final int $stable = 0;
    private static final float ALBUM_IMAGE_WIDTH = 44.0f;
    @NotNull
    private static final String ARG_ARTIST_PICK = "argArtistPick";
    @NotNull
    private static final String ARG_BBS_CHANNEL_SEQ = "argBbsChannelSeq";
    @NotNull
    private static final String ARG_PAGE = "argPage";
    @NotNull
    private static final String ARG_SECTION = "argSection";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistPickItemFragment";
    @Nullable
    private ARTISTPICK artistPick;
    @NotNull
    private String bbsChannelSeq;
    private View commonContents;
    private PlayerView exoPlayerView;
    private ImageView imgStill;
    @Nullable
    private OnArtistPickItemListener onArtistPickItemListener;
    @NotNull
    private String page;
    @NotNull
    private String section;
    @Nullable
    private SinglePlayer singlePlayer;
    @NotNull
    private final CoroutineExceptionHandler subExceptionHandler;

    static {
        ArtistPickItemFragment.Companion = new Companion(null);
        ArtistPickItemFragment.$stable = 8;
    }

    public ArtistPickItemFragment() {
        this.section = "";
        this.page = "";
        this.bbsChannelSeq = "";
        this.subExceptionHandler = new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(i i0, Throwable throwable0) {
                Y.w("subExceptionHandler message = ", throwable0.getMessage(), LogU.Companion, "ArtistPickItemFragment");
            }
        };
    }

    public final void activateWidgets(boolean z) {
        View view0 = this.findViewById(0x7F0A032B);  // id:container_gradient
        View view1 = this.findViewById(0x7F0A036B);  // id:ctl_album_info
        View view2 = this.findViewById(0x7F0A02FE);  // id:common_contents
        View view3 = this.findViewById(0x7F0A0DD5);  // id:view_underline
        int v = 8;
        view0.setVisibility((z ? 0 : 8));
        view1.setVisibility((z ? 0 : 8));
        view2.setVisibility((z ? 0 : 8));
        if(z) {
            v = 0;
        }
        view3.setVisibility(v);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Nullable
    public final String getMvUrl() {
        return this.artistPick == null ? null : this.artistPick.artistPickVideoUrl;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public Sharable getSNSSharable() {
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        String s = null;
        String s1 = artistPickRes$RESPONSE$ARTISTPICK0 == null ? null : artistPickRes$RESPONSE$ARTISTPICK0.artistName;
        String s2 = artistPickRes$RESPONSE$ARTISTPICK0 == null ? null : artistPickRes$RESPONSE$ARTISTPICK0.artistId;
        String s3 = artistPickRes$RESPONSE$ARTISTPICK0 == null ? null : artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
        String s4 = artistPickRes$RESPONSE$ARTISTPICK0 == null ? null : artistPickRes$RESPONSE$ARTISTPICK0.artistPickThumbUrl;
        String s5 = artistPickRes$RESPONSE$ARTISTPICK0 == null ? null : artistPickRes$RESPONSE$ARTISTPICK0.artistPickThumbUrl;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            s = artistPickRes$RESPONSE$ARTISTPICK0.artistPickTitle;
        }
        Sharable sharable0 = new SharableArtistPick();  // 初始化器: Ljava/lang/Object;-><init>()V
        sharable0.a = s2;
        sharable0.b = s1;
        sharable0.d = s3;
        sharable0.e = s4;
        sharable0.f = s5;
        sharable0.g = s;
        return sharable0;
    }

    @Nullable
    public final SinglePlayer getSinglePlayer() {
        return this.singlePlayer;
    }

    @NotNull
    public final ImageView getStillView() {
        ImageView imageView0 = this.imgStill;
        if(imageView0 != null) {
            return imageView0;
        }
        q.m("imgStill");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isBottomTabFragment() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    private final void onClickComment() {
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            Param cmtListFragment$Param0 = new Param();
            cmtListFragment$Param0.chnlSeq = Integer.parseInt(this.bbsChannelSeq);
            cmtListFragment$Param0.contsRefValue = artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
            cmtListFragment$Param0.theme = c.c;
            cmtListFragment$Param0.showTitle = true;
            cmtListFragment$Param0.headerTitle = this.getString(0x7F130212);  // string:comments "댓글"
            cmtListFragment$Param0.cacheKeyOfTargetPage = "" + artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
            Navigator.INSTANCE.openCommentRenewalVersion(cmtListFragment$Param0);
        }
    }

    private final void onClickLike(View view0) {
        boolean z = ((CheckableImageView)view0.findViewById(0x7F0A0170)).a;  // id:btn_liked
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            this.updateLike(artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq, "N10091", !z, this.getMenuId(), new OnJobFinishListener() {
                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onJobComplete(String s, int v, boolean z) {
                    q.g(s, "errorMsg");
                    this.setEnabled(true);
                    this.setClickable(true);
                    if(ArtistPickItemFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                        ArtistPickItemFragment.this.sendTiaraLogLike();
                        ArtistPickItemFragment.this.updateLikeView(String.valueOf(v), Boolean.valueOf(z));
                    }
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onStartAsyncTask() {
                    this.setEnabled(false);
                    this.setClickable(false);
                }
            });
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.setCommonContentsMargin();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0298, viewGroup0, false);  // layout:fragment_artist_pick_item
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroy() {
        Dialog dialog0 = this.mRetainDialog;
        if(dialog0 != null) {
            dialog0.dismiss();
        }
        super.onDestroy();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.artistPick = (ARTISTPICK)b.G(bundle0, "argArtistPick", ARTISTPICK.class);
        String s = bundle0.getString("argBbsChannelSeq", "");
        q.f(s, "getString(...)");
        this.bbsChannelSeq = s;
        String s1 = bundle0.getString("argSection", "");
        q.f(s1, "getString(...)");
        this.section = s1;
        String s2 = bundle0.getString("argPage", "");
        q.f(s2, "getString(...)");
        this.page = s2;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putSerializable("argArtistPick", this.artistPick);
        bundle0.putString("argBbsChannelSeq", this.bbsChannelSeq);
        bundle0.putString("argSection", this.section);
        bundle0.putString("argPage", this.page);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        ConstraintLayout constraintLayout0 = (ConstraintLayout)view0.findViewById(0x7F0A036C);  // id:ctl_background
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0D50);  // id:tv_video_title
        ConstraintLayout constraintLayout1 = (ConstraintLayout)view0.findViewById(0x7F0A036B);  // id:ctl_album_info
        View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        ImageView imageView0 = (ImageView)constraintLayout1.findViewById(0x7F0A069E);  // id:iv_thumb_default
        ImageView imageView1 = (ImageView)constraintLayout1.findViewById(0x7F0A069A);  // id:iv_thumb
        View view2 = view0.findViewById(0x7F0A05F1);  // id:iv_arrow
        View view3 = view0.findViewById(0x7F0A032B);  // id:container_gradient
        View view4 = view0.findViewById(0x7F0A076C);  // id:liked_container
        View view5 = view0.findViewById(0x7F0A02CF);  // id:cmt_container
        View view6 = view0.findViewById(0x7F0A01C4);  // id:btn_view_all
        View view7 = view0.findViewById(0x7F0A01B7);  // id:btn_share
        View view8 = view0.findViewById(0x7F0A0465);  // id:exo_player_view
        q.f(view8, "findViewById(...)");
        this.exoPlayerView = (PlayerView)view8;
        View view9 = view0.findViewById(0x7F0A0565);  // id:img_still
        q.f(view9, "findViewById(...)");
        this.imgStill = (ImageView)view9;
        View view10 = view0.findViewById(0x7F0A02FE);  // id:common_contents
        q.f(view10, "findViewById(...)");
        this.commonContents = view10;
        ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(this.getContext(), 44.0f));
        PlayerView playerView0 = this.exoPlayerView;
        if(playerView0 != null) {
            playerView0.setUseController(false);
            constraintLayout0.setOutlineProvider(new ViewOutlineProvider() {
                @Override  // android.view.ViewOutlineProvider
                public void getOutline(View view0, Outline outline0) {
                    q.g(view0, "view");
                    q.g(outline0, "outline");
                    float f = (float)ScreenUtils.dipToPixel(ArtistPickItemFragment.this.getContext(), 12.0f);
                    outline0.setRoundRect(0, 0, view0.getWidth(), view0.getHeight(), f);
                }
            });
            constraintLayout0.setClipToOutline(true);
            this.setCommonContentsMargin();
            ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
            if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
                ImageView imageView2 = this.imgStill;
                if(imageView2 != null) {
                    Glide.with(imageView2.getContext()).asBitmap().load(artistPickRes$RESPONSE$ARTISTPICK0.artistPickThumbUrl).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                            q.g(bitmap0, "bitmap");
                            e e0 = new e(bitmap0);
                            e0.a = 24;
                            m4.h h0 = e0.a();
                            g g0 = h0.a(m4.i.d);
                            g g1 = h0.a(m4.i.h);
                            if(g0 != null && g1 != null) {
                                GradientDrawable gradientDrawable0 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{g0.d, g1.d});
                                this.setBackground(gradientDrawable0);
                            }
                            ImageView imageView0 = ArtistPickItemFragment.this.imgStill;
                            if(imageView0 != null) {
                                imageView0.setImageBitmap(bitmap0);
                                ImageView imageView1 = ArtistPickItemFragment.this.imgStill;
                                if(imageView1 != null) {
                                    imageView1.setImageTintList(ColorStateList.valueOf(ColorUtils.getColor(ArtistPickItemFragment.this.getContext(), 0x7F060149)));  // color:gray080e
                                    return;
                                }
                                q.m("imgStill");
                                throw null;
                            }
                            q.m("imgStill");
                            throw null;
                        }

                        @Override  // com.bumptech.glide.request.target.Target
                        public void onResourceReady(Object object0, Transition transition0) {
                            this.onResourceReady(((Bitmap)object0), transition0);
                        }
                    });
                    AlbumInfoBase albumInfoBase0 = artistPickRes$RESPONSE$ARTISTPICK0.albumInfo;
                    if(albumInfoBase0 != null) {
                        constraintLayout1.setVisibility(0);
                        view3.setVisibility(0);
                        if(albumInfoBase0.albumImg == null || albumInfoBase0.albumImg.length() == 0) {
                            view1.setVisibility(8);
                            view2.setVisibility(8);
                        }
                        else {
                            view1.setVisibility(0);
                            view2.setVisibility(0);
                            q.d(Glide.with(imageView1.getContext()).load(albumInfoBase0.albumImg).into(imageView1));
                        }
                        textView0.setText(artistPickRes$RESPONSE$ARTISTPICK0.artistPickTitle);
                        constraintLayout1.setOnClickListener(new j(6, this, albumInfoBase0));
                        ViewUtils.setContentDescriptionWithButtonClassName(constraintLayout1, textView0.getText());
                    }
                    BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO().plus(this.subExceptionHandler), null, new n(null) {
                        private Object L$0;
                        int label;

                        {
                            ArtistPickItemFragment.this = artistPickItemFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.onViewCreated.2.3(ArtistPickItemFragment.this, continuation0);
                            continuation1.L$0 = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.onViewCreated.2.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    this.L$0 = coroutineScope0;
                                    this.label = 1;
                                    if(ArtistPickItemFragment.this.requestUserActionCountApi(coroutineScope0, this) == a0) {
                                        return a0;
                                    }
                                    break;
                                }
                                case 1: {
                                    d5.n.D(object0);
                                    break;
                                }
                                case 2: {
                                    d5.n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            this.L$0 = null;
                            this.label = 2;
                            return ArtistPickItemFragment.this.requestUserActionApi(coroutineScope0, this) == a0 ? a0 : H.a;
                        }
                    }, 2, null);
                    view4.setOnClickListener(new L(this, 0));
                    view5.setOnClickListener(new L(this, 1));
                    view6.setVisibility(0);
                    view6.setOnClickListener(new j(7, artistPickRes$RESPONSE$ARTISTPICK0, this));
                    view7.setOnClickListener(new L(this, 2));
                    return;
                }
                q.m("imgStill");
                throw null;
            }
            return;
        }
        q.m("exoPlayerView");
        throw null;
    }

    private static final void onViewCreated$lambda$7$lambda$2$lambda$1(ArtistPickItemFragment artistPickItemFragment0, AlbumInfoBase albumInfoBase0, View view0) {
        artistPickItemFragment0.sendTiaraLogAlbumDetail();
        Navigator.openAlbumInfo(albumInfoBase0.albumId);
    }

    private static final void onViewCreated$lambda$7$lambda$3(ArtistPickItemFragment artistPickItemFragment0, View view0) {
        q.d(view0);
        artistPickItemFragment0.onClickLike(view0);
    }

    private static final void onViewCreated$lambda$7$lambda$4(ArtistPickItemFragment artistPickItemFragment0, View view0) {
        artistPickItemFragment0.onClickComment();
        artistPickItemFragment0.sendTiaraLogComment();
    }

    private static final void onViewCreated$lambda$7$lambda$5(ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0, ArtistPickItemFragment artistPickItemFragment0, View view0) {
        String s = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
        q.f(s, "artistId");
        Navigator.open(ArtistPickGridFragment.Companion.newInstance(s));
        artistPickItemFragment0.sendTiaraLogViewAll();
    }

    private static final void onViewCreated$lambda$7$lambda$6(ArtistPickItemFragment artistPickItemFragment0, View view0) {
        OnArtistPickItemListener artistPickItemFragment$OnArtistPickItemListener0 = artistPickItemFragment0.onArtistPickItemListener;
        if(artistPickItemFragment$OnArtistPickItemListener0 != null) {
            artistPickItemFragment$OnArtistPickItemListener0.onShareClickListener(artistPickItemFragment0.getSNSSharable());
        }
        SinglePlayer singlePlayer0 = artistPickItemFragment0.singlePlayer;
        if(singlePlayer0 != null) {
            singlePlayer0.pause();
        }
        artistPickItemFragment0.sendTiaraLogShare();
    }

    private final Object requestUserActionApi(CoroutineScope coroutineScope0, Continuation continuation0) {
        return BuildersKt.withContext(coroutineScope0.getCoroutineContext(), new n(null) {
            int label;

            {
                ArtistPickItemFragment.this = artistPickItemFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionApi.2(ArtistPickItemFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionApi.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = ArtistPickItemFragment.this.artistPick;
                if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
                    String s = artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
                    if(s != null) {
                        Params userActionsReq$Params0 = new Params();
                        userActionsReq$Params0.fields = "like";
                        userActionsReq$Params0.contsTypeCode = "N10091";
                        userActionsReq$Params0.contsId = s;
                        RequestBuilder.newInstance(new UserActionsReq(ArtistPickItemFragment.this.getContext(), userActionsReq$Params0)).listener(new r(ArtistPickItemFragment.this, 1)).errorListener(new s(1)).request();
                        return H.a;
                    }
                }
                return null;
            }

            private static final void invokeSuspend$lambda$4$lambda$2(ArtistPickItemFragment artistPickItemFragment0, Object object0) {
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.UserActionsRes");
                Cb.j.b(((UserActionsRes)object0).notification, false, 3);
                if(Cb.j.d(((HttpResponse)object0))) {
                    Response userActionsRes$Response0 = ((UserActionsRes)object0).response;
                    artistPickItemFragment0.updateLikeView(null, Boolean.valueOf(MelonDetailInfoUtils.getUserActionLikeInfo((userActionsRes$Response0 == null ? null : userActionsRes$Response0.relationList))));
                }
            }

            private static final void invokeSuspend$lambda$4$lambda$3(VolleyError volleyError0) {
                LogU.Companion.e("ArtistPickItemFragment", "requestUserActionCountApi() - errorListener() : " + volleyError0);
            }
        }, continuation0);
    }

    private final Object requestUserActionCountApi(CoroutineScope coroutineScope0, Continuation continuation0) {
        return BuildersKt.withContext(coroutineScope0.getCoroutineContext(), new n(null) {
            int label;

            {
                ArtistPickItemFragment.this = artistPickItemFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionCountApi.2(ArtistPickItemFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionCountApi.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                View view0 = ArtistPickItemFragment.this.findViewById(0x7F0A0C9A);  // id:tv_liked_cnt
                q.e(view0, "null cannot be cast to non-null type android.widget.TextView");
                View view1 = ArtistPickItemFragment.this.findViewById(0x7F0A0C47);  // id:tv_comment_cnt
                q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
                ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = ArtistPickItemFragment.this.artistPick;
                if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
                    String s = artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
                    if(s != null) {
                        RequestBuilder.newInstance(new ArtistPickUserActionCntReq(ArtistPickItemFragment.this.getContext(), s)).listener(new com.iloen.melon.fragments.artistchannel.e(((TextView)view0), ((TextView)view1), ArtistPickItemFragment.this)).errorListener(new com.iloen.melon.fragments.artistchannel.c(3, ((TextView)view0), ((TextView)view1))).request();
                        return H.a;
                    }
                }
                return null;
            }

            private static final void invokeSuspend$lambda$4$lambda$2(TextView textView0, TextView textView1, ArtistPickItemFragment artistPickItemFragment0, Object object0) {
                boolean z;
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistPickUserActionCntRes");
                Cb.j.b(((ArtistPickUserActionCntRes)object0).notification, false, 3);
                if(Cb.j.d(((HttpResponse)object0))) {
                    RESPONSE artistPickUserActionCntRes$RESPONSE0 = ((ArtistPickUserActionCntRes)object0).response;
                    ArrayList arrayList0 = artistPickUserActionCntRes$RESPONSE0 == null ? null : artistPickUserActionCntRes$RESPONSE0.userActionCntList;
                    z = arrayList0 == null || arrayList0.isEmpty() ? false : true;
                }
                else {
                    z = false;
                }
                int v = 8;
                textView0.setVisibility((z ? 0 : 8));
                if(z) {
                    v = 0;
                }
                textView1.setVisibility(v);
                if(z) {
                    USERACTIONCNTLIST artistPickUserActionCntRes$RESPONSE$USERACTIONCNTLIST0 = (USERACTIONCNTLIST)((ArtistPickUserActionCntRes)object0).response.userActionCntList.get(0);
                    String s = StringUtils.getCountString(artistPickUserActionCntRes$RESPONSE$USERACTIONCNTLIST0.cmtCnt, 0x1869F);
                    artistPickItemFragment0.updateLikeView(artistPickUserActionCntRes$RESPONSE$USERACTIONCNTLIST0.likeCnt, null);
                    textView1.setText(s);
                    Context context0 = artistPickItemFragment0.getContext();
                    if(context0 != null) {
                        ViewUtils.setContentDescriptionWithButtonClassName(artistPickItemFragment0.findViewById(0x7F0A02CF), context0.getString(0x7F130AEA, new Object[]{textView1.getText()}));  // id:cmt_container
                    }
                }
            }

            private static final void invokeSuspend$lambda$4$lambda$3(TextView textView0, TextView textView1, VolleyError volleyError0) {
                textView0.setVisibility(8);
                textView1.setVisibility(8);
            }
        }, continuation0);
    }

    private final void sendTiaraLogAlbumDetail() {
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "페이지이동";
            g0.c = this.page;
            g0.b = this.section;
            g0.d = ActionKind.ClickContent;
            g0.y = "GNB";
            g0.C = "1";
            g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
            g0.p = "아티스트";
            g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
            g0.e = artistPickRes$RESPONSE$ARTISTPICK0.albumInfo.albumId;
            g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            g0.g = artistPickRes$RESPONSE$ARTISTPICK0.albumInfo.albumName;
            g0.I = this.getMenuId();
            g0.a().track();
        }
    }

    private final void sendTiaraLogComment() {
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "페이지이동";
            g0.b = this.section;
            g0.c = this.page;
            g0.y = "GNB";
            g0.C = "1";
            g0.F = "댓글";
            g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
            g0.p = "아티스트";
            g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
            g0.e = artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
            g0.I = this.getMenuId();
            g0.a().track();
        }
    }

    private final void sendTiaraLogLike() {
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "좋아요";
            g0.b = this.section;
            g0.c = this.page;
            g0.d = ActionKind.Like;
            g0.y = "GNB";
            g0.C = "1";
            g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
            g0.p = "아티스트";
            g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
            g0.e = artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
            g0.I = this.getMenuId();
            g0.a().track();
        }
    }

    private final void sendTiaraLogShare() {
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "공유";
            g0.b = this.section;
            g0.c = this.page;
            g0.d = ActionKind.Share;
            g0.y = "GNB";
            g0.C = "1";
            g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
            g0.p = "아티스트";
            g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
            g0.e = artistPickRes$RESPONSE$ARTISTPICK0.artistPickSeq;
            g0.I = this.getMenuId();
            g0.a().track();
        }
    }

    private final void sendTiaraLogViewAll() {
        ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = this.artistPick;
        if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "페이지이동";
            g0.b = this.section;
            g0.c = this.page;
            g0.y = "GNB";
            g0.C = "1";
            g0.F = "전체로이동";
            g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
            g0.p = "아티스트";
            g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
            g0.I = this.getMenuId();
            g0.a().track();
        }
    }

    private final void setCommonContentsMargin() {
        if(ScreenUtils.isOrientationPortrait(this.getContext())) {
            int v = ScreenUtils.getScreenHeight(this.getContext());
            int v1 = ScreenUtils.getScreenWidth(this.getContext()) / 9 * 16;
            int v2 = v1 <= v ? ScreenUtils.dipToPixel(this.getContext(), 20.0f) : ScreenUtils.dipToPixel(this.getContext(), 20.0f) + (v1 - v) / 2;
            View view0 = this.commonContents;
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = null;
            if(view0 == null) {
                q.m("commonContents");
                throw null;
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0;
            }
            if(viewGroup$MarginLayoutParams0 != null) {
                viewGroup$MarginLayoutParams0.bottomMargin = v2;
            }
        }
    }

    public final void setSinglePlayer(@Nullable SinglePlayer singlePlayer0) {
        PlayerView playerView0 = this.exoPlayerView;
        SimpleExoPlayer simpleExoPlayer0 = null;
        if(playerView0 != null) {
            if(singlePlayer0 != null) {
                simpleExoPlayer0 = singlePlayer0.getPlayer();
            }
            playerView0.setPlayer(simpleExoPlayer0);
            this.singlePlayer = singlePlayer0;
            return;
        }
        q.m("exoPlayerView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private final void updateLikeView(String s, Boolean boolean0) {
        View view0 = this.findViewById(0x7F0A076C);  // id:liked_container
        View view1 = this.findViewById(0x7F0A0C9A);  // id:tv_liked_cnt
        CharSequence charSequence0 = null;
        TextView textView0 = view1 instanceof TextView ? ((TextView)view1) : null;
        View view2 = this.findViewById(0x7F0A0170);  // id:btn_liked
        CheckableImageView checkableImageView0 = view2 instanceof CheckableImageView ? ((CheckableImageView)view2) : null;
        if(s != null && textView0 != null) {
            textView0.setText(StringUtils.getCountString(s, 0x1869F));
        }
        if(boolean0 != null && checkableImageView0 != null) {
            checkableImageView0.setChecked(boolean0.booleanValue());
        }
        Context context0 = this.getContext();
        if(context0 != null) {
            int v = checkableImageView0 == null || !checkableImageView0.a ? 0x7F130B61 : 0x7F130B5E;  // string:talkback_like_on_with_cnt "좋아요, %1$s명, 좋아요 선택하기"
            if(textView0 != null) {
                charSequence0 = textView0.getText();
            }
            ViewUtils.setContentDescriptionWithButtonClassName(view0, context0.getString(v, new Object[]{charSequence0}));
        }
    }
}

