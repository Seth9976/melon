package com.iloen.melon.player.video;

import A7.d;
import A9.f;
import Cb.g;
import Cc.P;
import T2.a;
import android.content.Context;
import android.util.Rational;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.f0;
import androidx.lifecycle.m0;
import androidx.window.layout.FoldingFeature.Orientation;
import androidx.window.layout.FoldingFeature;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.B1;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq.Params;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes;
import com.iloen.melon.net.v4x.response.MelonTvVdoRelateVdoListRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AndroidSettings;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import javax.inject.Inject;
import k8.Y;
import k8.t;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.b;
import u8.e;
import v8.i;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000\u00E2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 \u00D1\u00012\u00020\u0001:\b\u00D1\u0001\u00D2\u0001\u00D3\u0001\u00D4\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\fJ\r\u0010\u000E\u001A\u00020\n\u00A2\u0006\u0004\b\u000E\u0010\fJ\r\u0010\u000F\u001A\u00020\n\u00A2\u0006\u0004\b\u000F\u0010\fJ\r\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\n\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u001C\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0015\u0010!\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\n\u00A2\u0006\u0004\b!\u0010\u001BJ\u0017\u0010#\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b#\u0010\u001BJ\u0019\u0010%\u001A\u00020\u00102\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b%\u0010&J\u001D\u0010)\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u001C2\u0006\u0010(\u001A\u00020\u001C\u00A2\u0006\u0004\b)\u0010*J\u0015\u0010,\u001A\u00020\u00102\u0006\u0010+\u001A\u00020\n\u00A2\u0006\u0004\b,\u0010\u001BJ\u0015\u0010.\u001A\u00020\u00102\u0006\u0010-\u001A\u00020\n\u00A2\u0006\u0004\b.\u0010\u001BJ\u0015\u00100\u001A\u00020\u00102\u0006\u0010/\u001A\u00020\n\u00A2\u0006\u0004\b0\u0010\u001BJ\r\u00102\u001A\u000201\u00A2\u0006\u0004\b2\u00103J\u0017\u00106\u001A\u00020\u00102\b\u00105\u001A\u0004\u0018\u000104\u00A2\u0006\u0004\b6\u00107J\u0015\u00109\u001A\u00020\u00102\u0006\u00108\u001A\u00020\n\u00A2\u0006\u0004\b9\u0010\u001BJ\u0015\u0010<\u001A\u00020\u00102\u0006\u0010;\u001A\u00020:\u00A2\u0006\u0004\b<\u0010=J\u0015\u0010?\u001A\u00020\u00102\u0006\u0010>\u001A\u00020\n\u00A2\u0006\u0004\b?\u0010\u001BJ\u0015\u0010A\u001A\u00020\u00102\u0006\u0010@\u001A\u00020\n\u00A2\u0006\u0004\bA\u0010\u001BJ\u0015\u0010D\u001A\u00020\u00102\u0006\u0010C\u001A\u00020B\u00A2\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001A\u00020\u00102\u0006\u0010F\u001A\u00020\n\u00A2\u0006\u0004\bG\u0010\u001BJ\r\u0010H\u001A\u00020\u0010\u00A2\u0006\u0004\bH\u0010\u0012J\u0015\u0010J\u001A\u00020\u00102\u0006\u0010I\u001A\u00020\u0015\u00A2\u0006\u0004\bJ\u0010KJ!\u0010O\u001A\u00020\u00102\b\u0010M\u001A\u0004\u0018\u00010L2\b\u0010N\u001A\u0004\u0018\u00010\u0015\u00A2\u0006\u0004\bO\u0010PJ\u000F\u0010Q\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\bQ\u0010\u0012J\r\u0010R\u001A\u00020\u0010\u00A2\u0006\u0004\bR\u0010\u0012J\r\u0010S\u001A\u00020\u0010\u00A2\u0006\u0004\bS\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\bT\u0010U\u001A\u0004\bV\u0010WR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\bX\u0010Y\u001A\u0004\bZ\u0010[R\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\\\u0010]\u001A\u0004\b^\u0010_R\u001F\u0010f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010a0`8\u0006\u00A2\u0006\f\n\u0004\bb\u0010c\u001A\u0004\bd\u0010eR\u001D\u0010h\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\f\n\u0004\bg\u0010c\u001A\u0004\bh\u0010eR\u001D\u0010k\u001A\b\u0012\u0004\u0012\u00020\u00130`8\u0006\u00A2\u0006\f\n\u0004\bi\u0010c\u001A\u0004\bj\u0010eR\u001D\u0010o\u001A\b\u0012\u0004\u0012\u00020l0`8\u0006\u00A2\u0006\f\n\u0004\bm\u0010c\u001A\u0004\bn\u0010eR\u001D\u0010q\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\f\n\u0004\bp\u0010c\u001A\u0004\bq\u0010eR\u001D\u0010s\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\f\n\u0004\br\u0010c\u001A\u0004\bs\u0010eR\u001D\u0010y\u001A\b\u0012\u0004\u0012\u00020\u001C0t8\u0006\u00A2\u0006\f\n\u0004\bu\u0010v\u001A\u0004\bw\u0010xR\u001D\u0010|\u001A\b\u0012\u0004\u0012\u00020\u001C0`8\u0006\u00A2\u0006\f\n\u0004\bz\u0010c\u001A\u0004\b{\u0010eR\u001F\u0010\u007F\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001040`8\u0006\u00A2\u0006\f\n\u0004\b}\u0010c\u001A\u0004\b~\u0010eR \u0010\u0082\u0001\u001A\b\u0012\u0004\u0012\u00020:0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u0080\u0001\u0010c\u001A\u0005\b\u0081\u0001\u0010eR!\u0010\u0086\u0001\u001A\t\u0012\u0005\u0012\u00030\u0083\u00010`8\u0006\u00A2\u0006\u000E\n\u0005\b\u0084\u0001\u0010c\u001A\u0005\b\u0085\u0001\u0010eR(\u0010\u008B\u0001\u001A\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0088\u00010\u0087\u00010`8\u0006\u00A2\u0006\u000E\n\u0005\b\u0089\u0001\u0010c\u001A\u0005\b\u008A\u0001\u0010eR,\u0010\u0093\u0001\u001A\u0005\u0018\u00010\u008C\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u008D\u0001\u0010\u008E\u0001\u001A\u0006\b\u008F\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R(\u0010\u0098\u0001\u001A\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u00010t8\u0006\u00A2\u0006\u000E\n\u0005\b\u0096\u0001\u0010v\u001A\u0005\b\u0097\u0001\u0010xR \u0010\u009A\u0001\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u0099\u0001\u0010c\u001A\u0005\b\u009A\u0001\u0010eR!\u0010\u009E\u0001\u001A\t\u0012\u0005\u0012\u00030\u009B\u00010`8\u0006\u00A2\u0006\u000E\n\u0005\b\u009C\u0001\u0010c\u001A\u0005\b\u009D\u0001\u0010eR \u0010\u00A0\u0001\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u009F\u0001\u0010c\u001A\u0005\b\u00A0\u0001\u0010eR \u0010\u00A3\u0001\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00A1\u0001\u0010c\u001A\u0005\b\u00A2\u0001\u0010eR \u0010\u00A5\u0001\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00A4\u0001\u0010c\u001A\u0005\b\u00A5\u0001\u0010eR \u0010\u00A7\u0001\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00A6\u0001\u0010c\u001A\u0005\b\u00A7\u0001\u0010eR\'\u0010\u00AA\u0001\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0016\n\u0006\b\u00A8\u0001\u0010\u00A9\u0001\u001A\u0005\b\u00AA\u0001\u0010\f\"\u0005\b\u00AB\u0001\u0010\u001BR!\u0010\u00AF\u0001\u001A\t\u0012\u0005\u0012\u00030\u00AC\u00010`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00AD\u0001\u0010c\u001A\u0005\b\u00AE\u0001\u0010eR \u0010\u00B2\u0001\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00B0\u0001\u0010c\u001A\u0005\b\u00B1\u0001\u0010eR \u0010\u00B5\u0001\u001A\b\u0012\u0004\u0012\u00020\n0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00B3\u0001\u0010c\u001A\u0005\b\u00B4\u0001\u0010eR \u0010\u00B8\u0001\u001A\b\u0012\u0004\u0012\u00020B0`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00B6\u0001\u0010c\u001A\u0005\b\u00B7\u0001\u0010eR+\u0010\u00BE\u0001\u001A\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00BA\u00010\u0094\u00010\u00B9\u00018\u0006\u00A2\u0006\u0010\n\u0006\b\u00A9\u0001\u0010\u00BB\u0001\u001A\u0006\b\u00BC\u0001\u0010\u00BD\u0001R\u001E\u0010@\u001A\b\u0012\u0004\u0012\u00020\n0t8\u0006\u00A2\u0006\r\n\u0005\b\u00BF\u0001\u0010v\u001A\u0004\b@\u0010xR!\u0010\u00C3\u0001\u001A\t\u0012\u0005\u0012\u00030\u00C0\u00010`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00C1\u0001\u0010c\u001A\u0005\b\u00C2\u0001\u0010eR!\u0010\u00C7\u0001\u001A\t\u0012\u0005\u0012\u00030\u00C4\u00010`8\u0006\u00A2\u0006\u000E\n\u0005\b\u00C5\u0001\u0010c\u001A\u0005\b\u00C6\u0001\u0010eR\u0015\u0010\u00CB\u0001\u001A\u00030\u00C8\u00018F\u00A2\u0006\b\u001A\u0006\b\u00C9\u0001\u0010\u00CA\u0001R\u0013\u0010\u00CC\u0001\u001A\u00020\n8F\u00A2\u0006\u0007\u001A\u0005\b\u00CC\u0001\u0010\fR\u0013\u0010\u00CD\u0001\u001A\u00020\n8F\u00A2\u0006\u0007\u001A\u0005\b\u00CD\u0001\u0010\fR\u0014\u0010\u00D0\u0001\u001A\u00020\u00158F\u00A2\u0006\b\u001A\u0006\b\u00CE\u0001\u0010\u00CF\u0001\u00A8\u0006\u00D5\u0001"}, d2 = {"Lcom/iloen/melon/player/video/VideoViewModel;", "Landroidx/lifecycle/m0;", "Lcom/iloen/melon/player/video/VideoPipPvLogManager;", "vidoePipPvLogManager", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "<init>", "(Lcom/iloen/melon/player/video/VideoPipPvLogManager;Lkc/s2;Lob/z;)V", "", "isMiniPlayerMode", "()Z", "isFullScreen", "isExpendedPlayerMode", "isPipMode", "Lie/H;", "toggleFullScreenMode", "()V", "Lcom/iloen/melon/player/video/VideoStatus;", "newVideoStatus", "", "caller", "updateCurrentVideoStatus", "(Lcom/iloen/melon/player/video/VideoStatus;Ljava/lang/String;)V", "newIsPortrait", "updateScreenOrientation", "(Z)V", "", "newHeight", "updateScreenHeight", "(I)V", "newIdVideoFocusMode", "updateVideoFocusState", "newIsPip", "updatePipState", "visible", "updateControllerAllVisible", "(Ljava/lang/Boolean;)V", "width", "height", "updateVideoSize", "(II)V", "isVideoListDraggingExpanding", "updateVideoListDraggingOrExpanded", "useHideJob", "updateUseControllerHideJob", "isPortrait", "updateIsPortraitRatioVideo", "Landroid/util/Rational;", "getVideoRatio", "()Landroid/util/Rational;", "Lcom/iloen/melon/player/video/VideoViewModel$FoldingFeatureAndScreenLayout;", "state", "updateFoldingState", "(Lcom/iloen/melon/player/video/VideoViewModel$FoldingFeatureAndScreenLayout;)V", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "", "newOffset", "updateSlideOffset", "(F)V", "isPlaying", "updateIsMotionPlaying", "isLiked", "updateLiked", "Lcom/iloen/melon/player/video/MotionProgress;", "newMotionProgress", "updateMotionProgress", "(Lcom/iloen/melon/player/video/MotionProgress;)V", "isSeeking", "updateIsSeekingByUser", "requestVideoList", "mvId", "requestVideoInfo", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "songId", "requestLikeInfo", "(Landroid/content/Context;Ljava/lang/String;)V", "onCleared", "collectPipPvLog", "changeToDefaultPlaylist", "a", "Lcom/iloen/melon/player/video/VideoPipPvLogManager;", "getVidoePipPvLogManager", "()Lcom/iloen/melon/player/video/VideoPipPvLogManager;", "b", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "c", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/iloen/melon/playback/Playable;", "h", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentVideoPlayable", "()Lkotlinx/coroutines/flow/StateFlow;", "currentVideoPlayable", "j", "isPip", "l", "getVideoStatus", "videoStatus", "Lcom/iloen/melon/player/video/VideoOneDepthContentType;", "m", "getOneDepthContentType", "oneDepthContentType", "o", "isVideoPortraitRatio", "q", "isOrientationPortrait", "Landroidx/lifecycle/K;", "s", "Landroidx/lifecycle/K;", "getOrientationSetter", "()Landroidx/lifecycle/K;", "orientationSetter", "u", "getScreenHeight", "screenHeight", "w", "getFoldingFeature", "foldingFeature", "y", "getSlideOffset", "slideOffset", "", "z", "getRequestVdoRelateListSubscription", "requestVdoRelateListSubscription", "Lv8/i;", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoRelateVdoListRes;", "B", "getVdoRelateListRes", "vdoRelateListRes", "Lkotlinx/coroutines/Job;", "C", "Lkotlinx/coroutines/Job;", "getRelatedVdoListReqJob", "()Lkotlinx/coroutines/Job;", "setRelatedVdoListReqJob", "(Lkotlinx/coroutines/Job;)V", "relatedVdoListReqJob", "Lu8/d;", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoGetMvProgInfoRes;", "E", "getVdoGetMvProgInfoRes", "vdoGetMvProgInfoRes", "F", "isTopBottomSplit", "Lcom/iloen/melon/player/video/VideoViewModel$BottomSheetState;", "G", "getBottomSheetState", "bottomSheetState", "J", "isVideoFocusMode", "L", "getControllerAllVisible", "controllerAllVisible", "N", "isVideoListDraggingOrExpanded", "P", "isSeekingByUser", "Q", "Z", "isEndingViewShow1", "setEndingViewShow1", "Lcom/iloen/melon/player/video/ControllerVisibleStatus;", "R", "getControllerVisibleType", "controllerVisibleType", "U", "getBorderSeekbarVisible", "borderSeekbarVisible", "V", "getBorderSeekbarThumbVisible", "borderSeekbarThumbVisible", "X", "getMotionProgress", "motionProgress", "Landroidx/lifecycle/L;", "Lcom/iloen/melon/net/v4x/response/MyMusicLikeInformContentsLikeRes;", "Landroidx/lifecycle/L;", "getLikeInfoRes", "()Landroidx/lifecycle/L;", "likeInfoRes", "b0", "Lcom/iloen/melon/player/video/ControllerStatus;", "c0", "getControllerState", "controllerState", "Lcom/iloen/melon/player/video/VideoViewModel$SurfaceViewScaleInfo;", "d0", "getSurfaceViewScaleInfo", "surfaceViewScaleInfo", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getCurrentPlaylistId", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "currentPlaylistId", "isSuccessVdoList", "isBottomSheetDraggable", "getPlayerType", "()Ljava/lang/String;", "playerType", "Companion", "BottomSheetState", "SurfaceViewScaleInfo", "FoldingFeatureAndScreenLayout", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class VideoViewModel extends m0 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001A\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001A\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J\u001A\u0010\u0019\u001A\u00020\u00022\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001AR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0003\u0010\fR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001C\u001A\u0004\b\u0004\u0010\fR\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010\u000FR\u0017\u0010\b\u001A\u00020\u00078\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lcom/iloen/melon/player/video/VideoViewModel$BottomSheetState;", "", "", "isOrientationPortrait", "isVideoPortraitRatio", "Landroidx/window/layout/FoldingFeature;", "foldingFeature", "", "screenHeight", "<init>", "(ZZLandroidx/window/layout/FoldingFeature;I)V", "component1", "()Z", "component2", "component3", "()Landroidx/window/layout/FoldingFeature;", "component4", "()I", "copy", "(ZZLandroidx/window/layout/FoldingFeature;I)Lcom/iloen/melon/player/video/VideoViewModel$BottomSheetState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "b", "c", "Landroidx/window/layout/FoldingFeature;", "getFoldingFeature", "d", "I", "getScreenHeight", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BottomSheetState {
        public static final int $stable = 8;
        public final boolean a;
        public final boolean b;
        public final FoldingFeature c;
        public final int d;

        public BottomSheetState(boolean z, boolean z1, @Nullable FoldingFeature foldingFeature0, int v) {
            this.a = z;
            this.b = z1;
            this.c = foldingFeature0;
            this.d = v;
        }

        public final boolean component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @Nullable
        public final FoldingFeature component3() {
            return this.c;
        }

        public final int component4() {
            return this.d;
        }

        @NotNull
        public final BottomSheetState copy(boolean z, boolean z1, @Nullable FoldingFeature foldingFeature0, int v) {
            return new BottomSheetState(z, z1, foldingFeature0, v);
        }

        public static BottomSheetState copy$default(BottomSheetState videoViewModel$BottomSheetState0, boolean z, boolean z1, FoldingFeature foldingFeature0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                z = videoViewModel$BottomSheetState0.a;
            }
            if((v1 & 2) != 0) {
                z1 = videoViewModel$BottomSheetState0.b;
            }
            if((v1 & 4) != 0) {
                foldingFeature0 = videoViewModel$BottomSheetState0.c;
            }
            if((v1 & 8) != 0) {
                v = videoViewModel$BottomSheetState0.d;
            }
            return videoViewModel$BottomSheetState0.copy(z, z1, foldingFeature0, v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof BottomSheetState)) {
                return false;
            }
            if(this.a != ((BottomSheetState)object0).a) {
                return false;
            }
            if(this.b != ((BottomSheetState)object0).b) {
                return false;
            }
            return q.b(this.c, ((BottomSheetState)object0).c) ? this.d == ((BottomSheetState)object0).d : false;
        }

        @Nullable
        public final FoldingFeature getFoldingFeature() {
            return this.c;
        }

        public final int getScreenHeight() {
            return this.d;
        }

        @Override
        public int hashCode() {
            int v = d.e(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b);
            return this.c == null ? this.d + v * 0x1F : this.d + (v + this.c.hashCode()) * 0x1F;
        }

        public final boolean isOrientationPortrait() {
            return this.a;
        }

        public final boolean isVideoPortraitRatio() {
            return this.b;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = Y.q("BottomSheetState(isOrientationPortrait=", ", isVideoPortraitRatio=", this.a, ", foldingFeature=", this.b);
            stringBuilder0.append(this.c);
            stringBuilder0.append(", screenHeight=");
            stringBuilder0.append(this.d);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/VideoViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "CONTROLLER_HIDE_DELAY_TIME", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ&\u0010\f\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000BJ\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u000B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/video/VideoViewModel$FoldingFeatureAndScreenLayout;", "", "Landroidx/window/layout/FoldingFeature;", "foldingFeature", "", "screenLayout", "<init>", "(Landroidx/window/layout/FoldingFeature;I)V", "component1", "()Landroidx/window/layout/FoldingFeature;", "component2", "()I", "copy", "(Landroidx/window/layout/FoldingFeature;I)Lcom/iloen/melon/player/video/VideoViewModel$FoldingFeatureAndScreenLayout;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroidx/window/layout/FoldingFeature;", "getFoldingFeature", "b", "I", "getScreenLayout", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class FoldingFeatureAndScreenLayout {
        public static final int $stable = 8;
        public final FoldingFeature a;
        public final int b;

        public FoldingFeatureAndScreenLayout(@Nullable FoldingFeature foldingFeature0, int v) {
            this.a = foldingFeature0;
            this.b = v;
        }

        @Nullable
        public final FoldingFeature component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final FoldingFeatureAndScreenLayout copy(@Nullable FoldingFeature foldingFeature0, int v) {
            return new FoldingFeatureAndScreenLayout(foldingFeature0, v);
        }

        public static FoldingFeatureAndScreenLayout copy$default(FoldingFeatureAndScreenLayout videoViewModel$FoldingFeatureAndScreenLayout0, FoldingFeature foldingFeature0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                foldingFeature0 = videoViewModel$FoldingFeatureAndScreenLayout0.a;
            }
            if((v1 & 2) != 0) {
                v = videoViewModel$FoldingFeatureAndScreenLayout0.b;
            }
            return videoViewModel$FoldingFeatureAndScreenLayout0.copy(foldingFeature0, v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof FoldingFeatureAndScreenLayout)) {
                return false;
            }
            return q.b(this.a, ((FoldingFeatureAndScreenLayout)object0).a) ? this.b == ((FoldingFeatureAndScreenLayout)object0).b : false;
        }

        @Nullable
        public final FoldingFeature getFoldingFeature() {
            return this.a;
        }

        public final int getScreenLayout() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.a == null ? this.b : this.b + this.a.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "FoldingFeatureAndScreenLayout(foldingFeature=" + this.a + ", screenLayout=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000E\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000E\u0010\u000FJ.\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001A\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001A\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001A\u0010\u0019\u001A\u00020\u00022\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001AR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0003\u0010\u000BR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010\rR\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010\u000F¨\u0006#"}, d2 = {"Lcom/iloen/melon/player/video/VideoViewModel$SurfaceViewScaleInfo;", "", "", "isOrientationPortrait", "", "slideOffset", "Lcom/iloen/melon/player/video/VideoStatus;", "videoStatus", "<init>", "(ZFLcom/iloen/melon/player/video/VideoStatus;)V", "component1", "()Z", "component2", "()F", "component3", "()Lcom/iloen/melon/player/video/VideoStatus;", "copy", "(ZFLcom/iloen/melon/player/video/VideoStatus;)Lcom/iloen/melon/player/video/VideoViewModel$SurfaceViewScaleInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "b", "F", "getSlideOffset", "c", "Lcom/iloen/melon/player/video/VideoStatus;", "getVideoStatus", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SurfaceViewScaleInfo {
        public static final int $stable;
        public final boolean a;
        public final float b;
        public final VideoStatus c;

        public SurfaceViewScaleInfo(boolean z, float f, @NotNull VideoStatus videoStatus0) {
            q.g(videoStatus0, "videoStatus");
            super();
            this.a = z;
            this.b = f;
            this.c = videoStatus0;
        }

        public final boolean component1() {
            return this.a;
        }

        public final float component2() {
            return this.b;
        }

        @NotNull
        public final VideoStatus component3() {
            return this.c;
        }

        @NotNull
        public final SurfaceViewScaleInfo copy(boolean z, float f, @NotNull VideoStatus videoStatus0) {
            q.g(videoStatus0, "videoStatus");
            return new SurfaceViewScaleInfo(z, f, videoStatus0);
        }

        public static SurfaceViewScaleInfo copy$default(SurfaceViewScaleInfo videoViewModel$SurfaceViewScaleInfo0, boolean z, float f, VideoStatus videoStatus0, int v, Object object0) {
            if((v & 1) != 0) {
                z = videoViewModel$SurfaceViewScaleInfo0.a;
            }
            if((v & 2) != 0) {
                f = videoViewModel$SurfaceViewScaleInfo0.b;
            }
            if((v & 4) != 0) {
                videoStatus0 = videoViewModel$SurfaceViewScaleInfo0.c;
            }
            return videoViewModel$SurfaceViewScaleInfo0.copy(z, f, videoStatus0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SurfaceViewScaleInfo)) {
                return false;
            }
            if(this.a != ((SurfaceViewScaleInfo)object0).a) {
                return false;
            }
            return Float.compare(this.b, ((SurfaceViewScaleInfo)object0).b) == 0 ? this.c == ((SurfaceViewScaleInfo)object0).c : false;
        }

        public final float getSlideOffset() {
            return this.b;
        }

        @NotNull
        public final VideoStatus getVideoStatus() {
            return this.c;
        }

        @Override
        public int hashCode() {
            return this.c.hashCode() + d.a(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
        }

        public final boolean isOrientationPortrait() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "SurfaceViewScaleInfo(isOrientationPortrait=" + this.a + ", slideOffset=" + this.b + ", videoStatus=" + this.c + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[VideoStatus.values().length];
            try {
                arr_v[VideoStatus.FullScreen.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[VideoStatus.Expand.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable;
    public final MutableStateFlow A;
    public final MutableStateFlow B;
    public Job C;
    @NotNull
    public static final Companion Companion;
    public final L D;
    public final L E;
    public final StateFlow F;
    public final StateFlow G;
    public final MutableStateFlow H;
    public final MutableStateFlow I;
    public final MutableStateFlow J;
    public final MutableStateFlow K;
    public final MutableStateFlow L;
    public final MutableStateFlow M;
    public final MutableStateFlow N;
    public final MutableStateFlow O;
    public final MutableStateFlow P;
    public boolean Q;
    public final StateFlow R;
    public Job S;
    public boolean T;
    public final StateFlow U;
    public final StateFlow V;
    public final MutableStateFlow W;
    public final MutableStateFlow X;
    public final L Y;
    public final L Z;
    public final VideoPipPvLogManager a;
    public final L a0;
    public final s2 b;
    public final L b0;
    public final z c;
    public final StateFlow c0;
    public final LogU d;
    public final StateFlow d0;
    public final MutableStateFlow e;
    public final MutableStateFlow f;
    public final MutableStateFlow g;
    public final MutableStateFlow h;
    public final MutableStateFlow i;
    public final MutableStateFlow j;
    public final MutableStateFlow k;
    public final MutableStateFlow l;
    public final StateFlow m;
    public final MutableStateFlow n;
    public final MutableStateFlow o;
    public final MutableStateFlow p;
    public final MutableStateFlow q;
    public final L r;
    public final L s;
    public final MutableStateFlow t;
    public final MutableStateFlow u;
    public final MutableStateFlow v;
    public final MutableStateFlow w;
    public final MutableStateFlow x;
    public final MutableStateFlow y;
    public final StateFlow z;

    static {
        VideoViewModel.Companion = new Companion(null);
        VideoViewModel.$stable = 8;
    }

    @Inject
    public VideoViewModel(@NotNull VideoPipPvLogManager videoPipPvLogManager0, @NotNull s2 s20, @NotNull z z0) {
        q.g(videoPipPvLogManager0, "vidoePipPvLogManager");
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        super();
        this.a = videoPipPvLogManager0;
        this.b = s20;
        this.c = z0;
        this.d = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "VideoViewModel", false, null, 6, null);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(PlaylistId.EMPTY);
        this.e = mutableStateFlow0;
        this.f = mutableStateFlow0;
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(((d3)s20).f());
        this.g = mutableStateFlow1;
        this.h = mutableStateFlow1;
        MelonAppBase.Companion.getClass();
        MutableStateFlow mutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.valueOf(t.a().isAppPip()));
        this.i = mutableStateFlow2;
        this.j = mutableStateFlow2;
        MutableStateFlow mutableStateFlow3 = StateFlowKt.MutableStateFlow(VideoStatus.Expand);
        this.k = mutableStateFlow3;
        this.l = mutableStateFlow3;
        a a0 = f0.h(this);
        h h0 = new h(17);
        q.g(mutableStateFlow1, "<this>");
        g g0 = new g(mutableStateFlow1, h0, 0);
        Object object0 = h0.invoke(mutableStateFlow1.getValue());
        StateFlow stateFlow0 = FlowKt.stateIn(g0, a0, SharingStarted.Companion.getEagerly(), object0);
        this.m = stateFlow0;
        MutableStateFlow mutableStateFlow4 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.n = mutableStateFlow4;
        this.o = mutableStateFlow4;
        MutableStateFlow mutableStateFlow5 = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.p = mutableStateFlow5;
        this.q = mutableStateFlow5;
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.r = l0;
        this.s = l0;
        MutableStateFlow mutableStateFlow6 = StateFlowKt.MutableStateFlow(0);
        this.t = mutableStateFlow6;
        this.u = mutableStateFlow6;
        MutableStateFlow mutableStateFlow7 = StateFlowKt.MutableStateFlow(null);
        this.v = mutableStateFlow7;
        this.w = mutableStateFlow7;
        MutableStateFlow mutableStateFlow8 = StateFlowKt.MutableStateFlow(0.0f);
        this.x = mutableStateFlow8;
        this.y = mutableStateFlow8;
        this.z = FlowKt.stateIn(FlowKt.onCompletion(new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.player.video.VideoViewModel.special..inlined.map.1.2 videoViewModel$special$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.player.video.VideoViewModel.special..inlined.map.1.2.1 videoViewModel$special$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.player.video.VideoViewModel.special..inlined.map.1.2.1) {
                            videoViewModel$special$$inlined$map$1$2$10 = (com.iloen.melon.player.video.VideoViewModel.special..inlined.map.1.2.1)continuation0;
                            int v = videoViewModel$special$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                videoViewModel$special$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                videoViewModel$special$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            videoViewModel$special$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = videoViewModel$special$$inlined$map$1$2$10.r;
                        ne.a a0 = ne.a.a;
                        H h0 = H.a;
                        switch(videoViewModel$special$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                VideoStatus videoStatus0 = (VideoStatus)object0;
                                this.b.requestVideoList();
                                videoViewModel$special$$inlined$map$1$2$10.w = 1;
                                return this.b.emit(h0, videoViewModel$special$$inlined$map$1$2$10) == a0 ? a0 : h0;
                            }
                            case 1: {
                                n.D(object1);
                                return h0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.collect(videoViewModel$special$$inlined$map$1$20, continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        }, new o(null) {
            public final VideoViewModel r;

            {
                this.r = videoViewModel0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoViewModel.requestVdoRelateListSubscription.3(this.r, continuation0).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                n.D(object0);
                i i0 = new i(v8.h.d, v9.i.b, null, null);
                VideoViewModel.access$get_vdoRelateListRes$p(this.r).setValue(i0);
                return H.a;
            }
        }), f0.h(this), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), Boolean.FALSE);
        MutableStateFlow mutableStateFlow9 = StateFlowKt.MutableStateFlow(new i(v8.h.d, v9.i.b, null, null));
        this.A = mutableStateFlow9;
        this.B = mutableStateFlow9;
        L l1 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.D = l1;
        this.E = l1;
        StateFlow stateFlow1 = Cb.h.b(mutableStateFlow5, mutableStateFlow7, f0.h(this), new B1(11));
        this.F = stateFlow1;
        this.G = Cb.h.c(mutableStateFlow5, mutableStateFlow4, mutableStateFlow7, mutableStateFlow6, f0.h(this), new com.iloen.melon.fragments.shortform.a(1));
        MutableStateFlow mutableStateFlow10 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.H = mutableStateFlow10;
        MutableStateFlow mutableStateFlow11 = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.I = mutableStateFlow11;
        this.J = mutableStateFlow11;
        MutableStateFlow mutableStateFlow12 = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.K = mutableStateFlow12;
        this.L = mutableStateFlow12;
        MutableStateFlow mutableStateFlow13 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.M = mutableStateFlow13;
        this.N = mutableStateFlow13;
        MutableStateFlow mutableStateFlow14 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.O = mutableStateFlow14;
        this.P = mutableStateFlow14;
        StateFlow stateFlow2 = Cb.h.d(mutableStateFlow12, mutableStateFlow13, mutableStateFlow14, f0.h(this), new q0(this));
        this.R = stateFlow2;
        this.T = true;
        this.U = Cb.h.c(mutableStateFlow3, stateFlow1, mutableStateFlow7, mutableStateFlow10, f0.h(this), new com.iloen.melon.fragments.shortform.a(2));
        this.V = Cb.h.b(stateFlow0, stateFlow2, f0.h(this), new B1(12));
        MutableStateFlow mutableStateFlow15 = StateFlowKt.MutableStateFlow(new MotionProgress(0, 0, 0.0f, 7, null));
        this.W = mutableStateFlow15;
        this.X = mutableStateFlow15;
        L l2 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.Y = l2;
        this.Z = l2;
        L l3 = new L(Boolean.FALSE);  // 初始化器: Landroidx/lifecycle/K;-><init>(Ljava/lang/Object;)V
        this.a0 = l3;
        this.b0 = l3;
        this.c0 = Cb.h.c(stateFlow1, mutableStateFlow3, mutableStateFlow1, mutableStateFlow7, f0.h(this), new r0(this));
        this.d0 = Cb.h.d(mutableStateFlow5, mutableStateFlow8, mutableStateFlow3, f0.h(this), new P(22));
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(null) {
            public int r;
            public final VideoViewModel w;

            {
                this.w = videoViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoViewModel.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                VideoViewModel videoViewModel0 = this.w;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        this.r = 1;
                        if(VideoViewModel.access$collectPlaylistId(videoViewModel0, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    case 2: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                this.r = 2;
                return VideoViewModel.access$collectVideoPlayable(videoViewModel0, this) == a0 ? a0 : H.a;
            }
        }, 3, null);

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001E\u0010\u0005\u001A\u00020\u00042\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "Lie/H;", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.video.VideoViewModel.special..inlined.filter.1 implements Flow {
            public com.iloen.melon.player.video.VideoViewModel.special..inlined.filter.1(Flow flow0) {
            }

            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.player.video.VideoViewModel.special..inlined.filter.1.2 videoViewModel$special$$inlined$filter$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.player.video.VideoViewModel.special..inlined.filter.1.2.1 videoViewModel$special$$inlined$filter$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.player.video.VideoViewModel.special..inlined.filter.1.2.1) {
                            videoViewModel$special$$inlined$filter$1$2$10 = (com.iloen.melon.player.video.VideoViewModel.special..inlined.filter.1.2.1)continuation0;
                            int v = videoViewModel$special$$inlined$filter$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                videoViewModel$special$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                videoViewModel$special$$inlined$filter$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            videoViewModel$special$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = videoViewModel$special$$inlined$filter$1$2$10.r;
                        ne.a a0 = ne.a.a;
                        switch(videoViewModel$special$$inlined$filter$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                if(((VideoStatus)object0) == VideoStatus.FullScreen) {
                                    videoViewModel$special$$inlined$filter$1$2$10.w = 1;
                                    if(this.a.emit(object0, videoViewModel$special$$inlined$filter$1$2$10) == a0) {
                                        return a0;
                                    }
                                }
                                return H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.a.collect(videoViewModel$special$$inlined$filter$1$20, continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        }

    }

    public static final Object access$collectPlaylistId(VideoViewModel videoViewModel0, Continuation continuation0) {
        videoViewModel0.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(continuation0.getContext()), null, null, new VideoViewModel.collectPlaylistId.2(videoViewModel0, null), 3, null);
        return H.a;
    }

    public static final Object access$collectVideoPlayable(VideoViewModel videoViewModel0, Continuation continuation0) {
        videoViewModel0.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(continuation0.getContext()), null, null, new VideoViewModel.collectVideoPlayable.2(videoViewModel0, null), 3, null);
        return H.a;
    }

    public final void b(FoldingFeatureAndScreenLayout videoViewModel$FoldingFeatureAndScreenLayout0) {
        if(VideoViewModelKt.isHalfOpened(videoViewModel$FoldingFeatureAndScreenLayout0)) {
            q.d(videoViewModel$FoldingFeatureAndScreenLayout0);
            FoldingFeature foldingFeature0 = videoViewModel$FoldingFeatureAndScreenLayout0.getFoldingFeature();
            q.d(foldingFeature0);
            Orientation foldingFeature$Orientation0 = foldingFeature0.getOrientation();
            if(q.b(foldingFeature$Orientation0, Orientation.VERTICAL)) {
                MelonAppBase.Companion.getClass();
                switch(t.a().getContext().getResources().getConfiguration().orientation) {
                    case 1: {
                        this.c(6);
                        return;
                    }
                    case 2: {
                        this.c(7);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            if(q.b(foldingFeature$Orientation0, Orientation.HORIZONTAL)) {
                MelonAppBase.Companion.getClass();
                switch(t.a().getContext().getResources().getConfiguration().orientation) {
                    case 1: {
                        this.c(7);
                        break;
                    }
                    case 2: {
                        this.c(6);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            return;
        }
        this.c(2);
    }

    public final void c(int v) {
        this.r.setValue(v);
    }

    public final void changeToDefaultPlaylist() {
        this.c.t();
    }

    public final void collectPipPvLog() {
        a a0 = f0.h(this);
        this.a.init(this.j, a0, this.h);
    }

    @NotNull
    public final StateFlow getBorderSeekbarThumbVisible() {
        return this.V;
    }

    @NotNull
    public final StateFlow getBorderSeekbarVisible() {
        return this.U;
    }

    @NotNull
    public final StateFlow getBottomSheetState() {
        return this.G;
    }

    @NotNull
    public final StateFlow getControllerAllVisible() {
        return this.L;
    }

    @NotNull
    public final StateFlow getControllerState() {
        return this.c0;
    }

    @NotNull
    public final StateFlow getControllerVisibleType() {
        return this.R;
    }

    @NotNull
    public final PlaylistId getCurrentPlaylistId() {
        return (PlaylistId)this.f.getValue();
    }

    @NotNull
    public final StateFlow getCurrentVideoPlayable() {
        return this.h;
    }

    @NotNull
    public final StateFlow getFoldingFeature() {
        return this.w;
    }

    @NotNull
    public final L getLikeInfoRes() {
        return this.Z;
    }

    @NotNull
    public final StateFlow getMotionProgress() {
        return this.X;
    }

    @NotNull
    public final StateFlow getOneDepthContentType() {
        return this.m;
    }

    @NotNull
    public final K getOrientationSetter() {
        return this.s;
    }

    @NotNull
    public final String getPlayerType() {
        switch(WhenMappings.$EnumSwitchMapping$0[((VideoStatus)this.l.getValue()).ordinal()]) {
            case 1: {
                return ((Boolean)this.q.getValue()).booleanValue() ? "3" : "4";
            }
            case 2: {
                return ((Boolean)this.F.getValue()).booleanValue() ? "1" : "2";
            }
            default: {
                return "5";
            }
        }
    }

    @NotNull
    public final z getPlayerUseCase() {
        return this.c;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        return this.b;
    }

    @Nullable
    public final Job getRelatedVdoListReqJob() {
        return this.C;
    }

    @NotNull
    public final StateFlow getRequestVdoRelateListSubscription() {
        return this.z;
    }

    @NotNull
    public final StateFlow getScreenHeight() {
        return this.u;
    }

    @NotNull
    public final StateFlow getSlideOffset() {
        return this.y;
    }

    @NotNull
    public final StateFlow getSurfaceViewScaleInfo() {
        return this.d0;
    }

    @NotNull
    public final K getVdoGetMvProgInfoRes() {
        return this.E;
    }

    @NotNull
    public final StateFlow getVdoRelateListRes() {
        return this.B;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final Rational getVideoRatio() {
        return ((Boolean)this.o.getValue()).booleanValue() ? new Rational(9, 16) : new Rational(16, 9);
    }

    @NotNull
    public final StateFlow getVideoStatus() {
        return this.l;
    }

    @NotNull
    public final VideoPipPvLogManager getVidoePipPvLogManager() {
        return this.a;
    }

    public final boolean isBottomSheetDraggable() {
        return ((Boolean)this.F.getValue()).booleanValue();
    }

    public final boolean isEndingViewShow1() {
        return this.Q;
    }

    public final boolean isExpendedPlayerMode() {
        return this.l.getValue() != VideoStatus.MiniMode;
    }

    public final boolean isFullScreen() {
        return this.l.getValue() == VideoStatus.FullScreen;
    }

    @NotNull
    public final K isLiked() {
        return this.b0;
    }

    public final boolean isMiniPlayerMode() {
        return this.l.getValue() == VideoStatus.MiniMode;
    }

    @NotNull
    public final StateFlow isOrientationPortrait() {
        return this.q;
    }

    @NotNull
    public final StateFlow isPip() {
        return this.j;
    }

    public final boolean isPipMode() {
        return ((Boolean)this.j.getValue()).booleanValue();
    }

    @NotNull
    public final StateFlow isSeekingByUser() {
        return this.P;
    }

    public final boolean isSuccessVdoList() {
        return ((i)this.B.getValue()).a == v8.h.a;
    }

    @NotNull
    public final StateFlow isTopBottomSplit() {
        return this.F;
    }

    @NotNull
    public final StateFlow isVideoFocusMode() {
        return this.J;
    }

    @NotNull
    public final StateFlow isVideoListDraggingOrExpanded() {
        return this.N;
    }

    @NotNull
    public final StateFlow isVideoPortraitRatio() {
        return this.o;
    }

    @Override  // androidx.lifecycle.m0
    public void onCleared() {
        super.onCleared();
        f.a("onCleared() ViewModel Cleared");
    }

    public final void onPictureInPictureModeChanged(boolean z) {
        this.updatePipState(z);
    }

    public final void requestLikeInfo(@Nullable Context context0, @Nullable String s) {
        if(context0 == null && (s == null || s.length() == 0)) {
            LogU.debug$default(this.d, "requestLikeInfo required parameter error", null, false, 6, null);
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(this, s, null) {
            public final VideoViewModel B;
            public final String D;
            public int r;
            public final Context w;

            {
                this.w = context0;
                this.B = videoViewModel0;
                this.D = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s;
                ne.a a0 = ne.a.a;
                int v = this.r;
                e e0 = null;
                switch(v) {
                    case 0: {
                        n.D(object0);
                        Params myMusicLikeInformContentsLikeReq$Params0 = new Params();
                        myMusicLikeInformContentsLikeReq$Params0.contsId = this.D;
                        myMusicLikeInformContentsLikeReq$Params0.contsTypeCode = "N10001";
                        myMusicLikeInformContentsLikeReq$Params0.actTypeCode = "N20001";
                        com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$10 = new we.n(null) {
                            public int r;
                            public final v8.g w;

                            {
                                this.w = g0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.2 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$1$20 = new we.n("DataAccessStrategy", "MyMusicLikeInformContentsLikeRes", null) {
                                            public final String B;
                                            public final String D;
                                            public int r;
                                            public final k w;

                                            {
                                                this.w = k0;
                                                this.B = s;
                                                this.D = s1;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.2(this.w, this.B, this.D, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                u8.d d0;
                                                ne.a a0 = ne.a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        n.D(object0);
                                                        this.r = 1;
                                                        object0 = this.w.invoke(this);
                                                        if(object0 == a0) {
                                                            return a0;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        n.D(object0);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                }
                                                switch(((u8.d)object0).a.ordinal()) {
                                                    case 0: {
                                                        HttpResponse httpResponse0 = ((u8.d)object0).b;
                                                        if(httpResponse0 == null) {
                                                            VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                            d0 = new u8.d(e.b, null, volleyError0);
                                                        }
                                                        else {
                                                            d0 = new u8.d(e.a, httpResponse0, null);
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d0 = new u8.d(e.b, null, ((u8.d)object0).c);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                                LogU.Companion.d(this.B, "getData() " + this.D + " " + d0);
                                                return d0;
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$1$20, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }

                                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                                public final class com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.1 extends oe.i implements k {
                                    public int r;
                                    public final v8.g w;

                                    public com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.1(v8.g g0, Continuation continuation0) {
                                        this.w = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.1(this.w, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                b.b();
                                                com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.1.1 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$1$1$10 = new we.n(null) {
                                                    public final v8.g r;

                                                    {
                                                        this.r = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.1.1(this.r, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        n.D(object0);
                                                        try {
                                                            LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                            RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                            HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                            if(httpResponse0 != null && httpResponse0 instanceof MyMusicLikeInformContentsLikeRes) {
                                                                return new u8.d(e.a, httpResponse0, null);
                                                            }
                                                            VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                            return new u8.d(e.b, null, volleyError1);
                                                        }
                                                        catch(VolleyError volleyError0) {
                                                            return new u8.d(e.b, null, volleyError0);
                                                        }
                                                    }
                                                };
                                                this.r = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$1$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }

                            }
                        };
                        this.r = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$10, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        if(v != 2) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        break;
                    }
                }
                VideoViewModel videoViewModel0 = this.B;
                videoViewModel0.getLikeInfoRes().setValue(((u8.d)object0));
                u8.d d0 = (u8.d)videoViewModel0.getLikeInfoRes().getValue();
                if(d0 == null) {
                    s = null;
                }
                else {
                    MyMusicLikeInformContentsLikeRes myMusicLikeInformContentsLikeRes0 = (MyMusicLikeInformContentsLikeRes)d0.b;
                    if(myMusicLikeInformContentsLikeRes0 == null) {
                        s = null;
                    }
                    else {
                        RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = myMusicLikeInformContentsLikeRes0.response;
                        s = myMusicLikeInformContentsLikeRes$RESPONSE0 == null ? null : myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn;
                    }
                }
                videoViewModel0.updateLiked(ProtocolUtils.parseBoolean(s));
                LogU logU0 = videoViewModel0.d;
                u8.d d1 = (u8.d)videoViewModel0.Y.getValue();
                if(d1 != null) {
                    e0 = d1.a;
                }
                LogU.debug$default(logU0, "requestLikeInfo status - " + e0, null, false, 6, null);
                return H.a;

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                public final class com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2 extends oe.i implements we.n {
                    public final int B;
                    public final v8.g D;
                    public int r;
                    public final u8.c w;

                    public com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2(u8.c c0, int v, v8.g g0, Continuation continuation0) {
                        this.w = c0;
                        this.B = v;
                        this.D = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2(this.w, this.B, this.D, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.1 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$10 = new k(null) {
                                    public int r;
                                    public final v8.g w;

                                    {
                                        this.w = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.1(this.w, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                b.b();
                                                com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.1.1 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$1$10 = new we.n(null) {
                                                    public final v8.g r;

                                                    {
                                                        this.r = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.1.1(this.r, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        n.D(object0);
                                                        try {
                                                            LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                            RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                            HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                            if(httpResponse0 != null && httpResponse0 instanceof MyMusicLikeInformContentsLikeRes) {
                                                                return new u8.d(e.a, httpResponse0, null);
                                                            }
                                                            VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                            return new u8.d(e.b, null, volleyError1);
                                                        }
                                                        catch(VolleyError volleyError0) {
                                                            return new u8.d(e.b, null, volleyError0);
                                                        }
                                                    }
                                                };
                                                this.r = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.2 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$20 = new we.a() {
                                    @Override  // we.a
                                    public Object invoke() {
                                        return this.invoke();
                                    }

                                    public final s8.b invoke() {
                                        return b.a().a(this.a.a);
                                    }
                                };
                                com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.3 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$30 = new k() {
                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        this.invoke(((HttpResponse)object0));
                                        return H.a;
                                    }

                                    public final void invoke(HttpResponse httpResponse0) {
                                        q.g(httpResponse0, "it");
                                        s8.a a0 = b.a();
                                        String s = b.c.k(httpResponse0);
                                        q.f(s, "toJson(...)");
                                        a0.b(new s8.b(this.b, this.B.a, s, System.currentTimeMillis()));
                                    }
                                };
                                com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.4 videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$40 = new we.n(new Integer(this.B), this.w.b, videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$10, videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$30, null) {
                                    public int B;
                                    public Object D;
                                    public final we.a E;
                                    public final Integer G;
                                    public final long I;
                                    public final k M;
                                    public final k N;
                                    public String r;
                                    public String w;

                                    {
                                        this.E = a0;
                                        this.G = integer0;
                                        this.I = v;
                                        this.M = k0;
                                        this.N = k1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.4(this.E, this.G, this.I, this.M, this.N, continuation0);
                                        continuation1.D = object0;
                                        return continuation1;
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        u8.d d0;
                                        String s1;
                                        String s;
                                        CoroutineScope coroutineScope0 = (CoroutineScope)this.D;
                                        ne.a a0 = ne.a.a;
                                        switch(this.B) {
                                            case 0: {
                                                n.D(object0);
                                                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                                logU$Companion0.d("DataAccessStrategy", "getData() MyMusicLikeInformContentsLikeRes");
                                                s8.b b0 = this.E == null ? null : ((s8.b)this.E.invoke());
                                                if(b0 != null && !u.H(b0, this.G, this.I)) {
                                                    HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, MyMusicLikeInformContentsLikeRes.class);
                                                    if(httpResponse0 != null) {
                                                        logU$Companion0.d("DataAccessStrategy", "getData() MyMusicLikeInformContentsLikeRes cacheEntity not expired. > return cachedRes");
                                                        return new u8.d(e.a, httpResponse0, null);
                                                    }
                                                }
                                                logU$Companion0.d("DataAccessStrategy", "getData() MyMusicLikeInformContentsLikeRes cacheEntity expired.");
                                                this.D = coroutineScope0;
                                                this.r = "DataAccessStrategy";
                                                this.w = "MyMusicLikeInformContentsLikeRes";
                                                this.B = 1;
                                                Object object1 = this.M.invoke(this);
                                                if(object1 == a0) {
                                                    return a0;
                                                }
                                                s = "MyMusicLikeInformContentsLikeRes";
                                                object0 = object1;
                                                s1 = "DataAccessStrategy";
                                                break;
                                            }
                                            case 1: {
                                                s = this.w;
                                                String s2 = this.r;
                                                n.D(object0);
                                                s1 = s2;
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        switch(((u8.d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse1 = ((u8.d)object0).b;
                                                if(httpResponse1 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new u8.d(e.b, null, volleyError0);
                                                }
                                                else {
                                                    u8.d d1 = new u8.d(e.a, httpResponse1, null);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(((u8.d)object0), null) {
                                                        public final k r;
                                                        public final u8.d w;

                                                        {
                                                            this.r = k0;
                                                            this.w = d0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.4.1(this.r, this.w, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.player.video.VideoViewModel.requestLikeInfo.1.invokeSuspend..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            n.D(object0);
                                                            k k0 = this.r;
                                                            if(k0 != null) {
                                                                k0.invoke(this.w.b);
                                                            }
                                                            return H.a;
                                                        }
                                                    }, 2, null);
                                                    d0 = d1;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new u8.d(e.b, null, ((u8.d)object0).c);
                                                break;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                        LogU.Companion.d(s1, "getData() " + s + " " + d0);
                                        return d0;
                                    }
                                };
                                this.r = 1;
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestLikeInfo$1$invokeSuspend$$inlined$request$default$2$40, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                }

            }
        }, 3, null);
    }

    public final void requestVideoInfo(@NotNull String s) {
        q.g(s, "mvId");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(this, null) {
            public final VideoViewModel B;
            public int r;
            public final String w;

            {
                this.w = s;
                this.B = videoViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                int v = this.r;
                e e0 = null;
                switch(v) {
                    case 0: {
                        n.D(object0);
                        com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$10 = new we.n(null) {
                            public int r;
                            public final v8.g w;

                            {
                                this.w = g0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.2 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$1$20 = new we.n("DataAccessStrategy", "MelonTvVdoGetMvProgInfoRes", null) {
                                            public final String B;
                                            public final String D;
                                            public int r;
                                            public final k w;

                                            {
                                                this.w = k0;
                                                this.B = s;
                                                this.D = s1;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.2(this.w, this.B, this.D, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                u8.d d0;
                                                ne.a a0 = ne.a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        n.D(object0);
                                                        this.r = 1;
                                                        object0 = this.w.invoke(this);
                                                        if(object0 == a0) {
                                                            return a0;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        n.D(object0);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                }
                                                switch(((u8.d)object0).a.ordinal()) {
                                                    case 0: {
                                                        HttpResponse httpResponse0 = ((u8.d)object0).b;
                                                        if(httpResponse0 == null) {
                                                            VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                            d0 = new u8.d(e.b, null, volleyError0);
                                                        }
                                                        else {
                                                            d0 = new u8.d(e.a, httpResponse0, null);
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d0 = new u8.d(e.b, null, ((u8.d)object0).c);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                                LogU.Companion.d(this.B, "getData() " + this.D + " " + d0);
                                                return d0;
                                            }
                                        };
                                        this.r = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$1$20, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }

                                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                                public final class com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.1 extends oe.i implements k {
                                    public int r;
                                    public final v8.g w;

                                    public com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.1(v8.g g0, Continuation continuation0) {
                                        this.w = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.1(this.w, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                b.b();
                                                com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.1.1 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$1$1$10 = new we.n(null) {
                                                    public final v8.g r;

                                                    {
                                                        this.r = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.1.1(this.r, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        n.D(object0);
                                                        try {
                                                            LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                            RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                            HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                            if(httpResponse0 != null && httpResponse0 instanceof MelonTvVdoGetMvProgInfoRes) {
                                                                return new u8.d(e.a, httpResponse0, null);
                                                            }
                                                            VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                            return new u8.d(e.b, null, volleyError1);
                                                        }
                                                        catch(VolleyError volleyError0) {
                                                            return new u8.d(e.b, null, volleyError0);
                                                        }
                                                    }
                                                };
                                                this.r = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$1$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }

                            }
                        };
                        this.r = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$10, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        if(v != 2) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        break;
                    }
                }
                this.B.D.setValue(((u8.d)object0));
                LogU logU0 = this.B.d;
                u8.d d0 = (u8.d)this.B.D.getValue();
                if(d0 != null) {
                    e0 = d0.a;
                }
                LogU.debug$default(logU0, "requestVideoInfo status - " + e0, null, false, 6, null);
                return H.a;

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                public final class com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2 extends oe.i implements we.n {
                    public final int B;
                    public final v8.g D;
                    public int r;
                    public final u8.c w;

                    public com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2(u8.c c0, int v, v8.g g0, Continuation continuation0) {
                        this.w = c0;
                        this.B = v;
                        this.D = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2(this.w, this.B, this.D, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.1 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$10 = new k(null) {
                                    public int r;
                                    public final v8.g w;

                                    {
                                        this.w = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.1(this.w, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                b.b();
                                                com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.1.1 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$1$10 = new we.n(null) {
                                                    public final v8.g r;

                                                    {
                                                        this.r = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.1.1(this.r, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        n.D(object0);
                                                        try {
                                                            LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                            RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                            HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                            if(httpResponse0 != null && httpResponse0 instanceof MelonTvVdoGetMvProgInfoRes) {
                                                                return new u8.d(e.a, httpResponse0, null);
                                                            }
                                                            VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                            return new u8.d(e.b, null, volleyError1);
                                                        }
                                                        catch(VolleyError volleyError0) {
                                                            return new u8.d(e.b, null, volleyError0);
                                                        }
                                                    }
                                                };
                                                this.r = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.2 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$20 = new we.a() {
                                    @Override  // we.a
                                    public Object invoke() {
                                        return this.invoke();
                                    }

                                    public final s8.b invoke() {
                                        return b.a().a(this.a.a);
                                    }
                                };
                                com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.3 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$30 = new k() {
                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        this.invoke(((HttpResponse)object0));
                                        return H.a;
                                    }

                                    public final void invoke(HttpResponse httpResponse0) {
                                        q.g(httpResponse0, "it");
                                        s8.a a0 = b.a();
                                        String s = b.c.k(httpResponse0);
                                        q.f(s, "toJson(...)");
                                        a0.b(new s8.b(this.b, this.B.a, s, System.currentTimeMillis()));
                                    }
                                };
                                com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.4 videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$40 = new we.n(new Integer(this.B), this.w.b, videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$10, videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$30, null) {
                                    public int B;
                                    public Object D;
                                    public final we.a E;
                                    public final Integer G;
                                    public final long I;
                                    public final k M;
                                    public final k N;
                                    public String r;
                                    public String w;

                                    {
                                        this.E = a0;
                                        this.G = integer0;
                                        this.I = v;
                                        this.M = k0;
                                        this.N = k1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.4(this.E, this.G, this.I, this.M, this.N, continuation0);
                                        continuation1.D = object0;
                                        return continuation1;
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        u8.d d0;
                                        String s1;
                                        String s;
                                        CoroutineScope coroutineScope0 = (CoroutineScope)this.D;
                                        ne.a a0 = ne.a.a;
                                        switch(this.B) {
                                            case 0: {
                                                n.D(object0);
                                                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                                logU$Companion0.d("DataAccessStrategy", "getData() MelonTvVdoGetMvProgInfoRes");
                                                s8.b b0 = this.E == null ? null : ((s8.b)this.E.invoke());
                                                if(b0 != null && !u.H(b0, this.G, this.I)) {
                                                    HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, MelonTvVdoGetMvProgInfoRes.class);
                                                    if(httpResponse0 != null) {
                                                        logU$Companion0.d("DataAccessStrategy", "getData() MelonTvVdoGetMvProgInfoRes cacheEntity not expired. > return cachedRes");
                                                        return new u8.d(e.a, httpResponse0, null);
                                                    }
                                                }
                                                logU$Companion0.d("DataAccessStrategy", "getData() MelonTvVdoGetMvProgInfoRes cacheEntity expired.");
                                                this.D = coroutineScope0;
                                                this.r = "DataAccessStrategy";
                                                this.w = "MelonTvVdoGetMvProgInfoRes";
                                                this.B = 1;
                                                Object object1 = this.M.invoke(this);
                                                if(object1 == a0) {
                                                    return a0;
                                                }
                                                s = "MelonTvVdoGetMvProgInfoRes";
                                                object0 = object1;
                                                s1 = "DataAccessStrategy";
                                                break;
                                            }
                                            case 1: {
                                                s = this.w;
                                                String s2 = this.r;
                                                n.D(object0);
                                                s1 = s2;
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        switch(((u8.d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse1 = ((u8.d)object0).b;
                                                if(httpResponse1 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new u8.d(e.b, null, volleyError0);
                                                }
                                                else {
                                                    u8.d d1 = new u8.d(e.a, httpResponse1, null);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(((u8.d)object0), null) {
                                                        public final k r;
                                                        public final u8.d w;

                                                        {
                                                            this.r = k0;
                                                            this.w = d0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.4.1(this.r, this.w, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.player.video.VideoViewModel.requestVideoInfo.1.invokeSuspend..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            n.D(object0);
                                                            k k0 = this.r;
                                                            if(k0 != null) {
                                                                k0.invoke(this.w.b);
                                                            }
                                                            return H.a;
                                                        }
                                                    }, 2, null);
                                                    d0 = d1;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new u8.d(e.b, null, ((u8.d)object0).c);
                                                break;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                        LogU.Companion.d(s1, "getData() " + s + " " + d0);
                                        return d0;
                                    }
                                };
                                this.r = 1;
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoInfo$1$invokeSuspend$$inlined$request$default$2$40, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                }

            }
        }, 3, null);
    }

    public final void requestVideoList() {
        Job job0 = this.C;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.C = BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(null) {
            public int r;
            public final VideoViewModel w;

            {
                this.w = videoViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1 videoViewModel$requestVideoList$1$10 = new we.n(null) {
                            public final VideoViewModel B;
                            public int r;
                            public Object w;

                            {
                                this.B = videoViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1(this.B, continuation0);
                                continuation1.w = object0;
                                return continuation1;
                            }

                            public final Object invoke(Playable playable0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1)this.create(playable0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Playable)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Playable playable0 = (Playable)this.w;
                                int v = this.r;
                                H h0 = H.a;
                                v9.i i0 = v9.i.b;
                                VideoViewModel videoViewModel0 = this.B;
                                switch(v) {
                                    case 0: {
                                        n.D(object0);
                                        videoViewModel0.A.setValue(new i(v8.h.d, i0, null, null));
                                        return h0;
                                    label_10:
                                        if(v != 2) {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                        n.D(object0);
                                        break;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        break;
                                    }
                                    default: {
                                        goto label_10;
                                    }
                                }
                                videoViewModel0.A.setValue(e1.n.g(((u8.d)object0), i0));
                                LogU.debug$default(videoViewModel0.d, "requestVideoList status - " + ((i)videoViewModel0.A.getValue()).a, null, false, 6, null);
                                return h0;

                                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2", f = "ApiRepository.kt", l = {84}, m = "invokeSuspend")
                                public final class com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1 extends oe.i implements we.n {
                                    public int r;
                                    public final v8.g w;

                                    public com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1(v8.g g0, Continuation continuation0) {
                                        this.w = g0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.2 videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$1$20 = new we.n("DataAccessStrategy", "MelonTvVdoRelateVdoListRes", null) {
                                                    public final String B;
                                                    public final String D;
                                                    public int r;
                                                    public final k w;

                                                    {
                                                        this.w = k0;
                                                        this.B = s;
                                                        this.D = s1;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.2(this.w, this.B, this.D, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        u8.d d0;
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.r) {
                                                            case 0: {
                                                                n.D(object0);
                                                                this.r = 1;
                                                                object0 = this.w.invoke(this);
                                                                if(object0 == a0) {
                                                                    return a0;
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
                                                                n.D(object0);
                                                                break;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                        switch(((u8.d)object0).a.ordinal()) {
                                                            case 0: {
                                                                HttpResponse httpResponse0 = ((u8.d)object0).b;
                                                                if(httpResponse0 == null) {
                                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                                    d0 = new u8.d(e.b, null, volleyError0);
                                                                }
                                                                else {
                                                                    d0 = new u8.d(e.a, httpResponse0, null);
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
                                                                d0 = new u8.d(e.b, null, ((u8.d)object0).c);
                                                                break;
                                                            }
                                                            default: {
                                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                            }
                                                        }
                                                        LogU.Companion.d(this.B, "getData() " + this.D + " " + d0);
                                                        return d0;
                                                    }
                                                };
                                                this.r = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$1$20, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }

                                        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                        @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                                        public final class com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.1 extends oe.i implements k {
                                            public int r;
                                            public final v8.g w;

                                            public com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.1(v8.g g0, Continuation continuation0) {
                                                this.w = g0;
                                                super(1, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Continuation continuation0) {
                                                return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.1(this.w, continuation0);
                                            }

                                            @Override  // we.k
                                            public Object invoke(Object object0) {
                                                return this.invoke(((Continuation)object0));
                                            }

                                            public final Object invoke(Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                ne.a a0 = ne.a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        n.D(object0);
                                                        b.b();
                                                        com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.1.1 videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$1$1$10 = new we.n(null) {
                                                            public final v8.g r;

                                                            {
                                                                this.r = g0;
                                                                super(2, continuation0);
                                                            }

                                                            @Override  // oe.a
                                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                                return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.1.1(this.r, continuation0);
                                                            }

                                                            @Override  // we.n
                                                            public Object invoke(Object object0, Object object1) {
                                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                            }

                                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                            }

                                                            @Override  // oe.a
                                                            public final Object invokeSuspend(Object object0) {
                                                                n.D(object0);
                                                                try {
                                                                    LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                    HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                    if(httpResponse0 != null && httpResponse0 instanceof MelonTvVdoRelateVdoListRes) {
                                                                        return new u8.d(e.a, httpResponse0, null);
                                                                    }
                                                                    VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                    return new u8.d(e.b, null, volleyError1);
                                                                }
                                                                catch(VolleyError volleyError0) {
                                                                    return new u8.d(e.b, null, volleyError0);
                                                                }
                                                            }
                                                        };
                                                        this.r = 1;
                                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$1$1$10, this);
                                                        return object1 == a0 ? a0 : object1;
                                                    }
                                                    case 1: {
                                                        n.D(object0);
                                                        return object0;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }


                                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                                public final class com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2 extends oe.i implements we.n {
                                    public final int B;
                                    public final v8.g D;
                                    public int r;
                                    public final u8.c w;

                                    public com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2(u8.c c0, int v, v8.g g0, Continuation continuation0) {
                                        this.w = c0;
                                        this.B = v;
                                        this.D = g0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2(this.w, this.B, this.D, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.1 videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$10 = new k(null) {
                                                    public int r;
                                                    public final v8.g w;

                                                    {
                                                        this.w = g0;
                                                        super(1, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.1(this.w, continuation0);
                                                    }

                                                    @Override  // we.k
                                                    public Object invoke(Object object0) {
                                                        return this.invoke(((Continuation)object0));
                                                    }

                                                    public final Object invoke(Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.r) {
                                                            case 0: {
                                                                n.D(object0);
                                                                b.b();
                                                                com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.1.1 videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$1$10 = new we.n(null) {
                                                                    public final v8.g r;

                                                                    {
                                                                        this.r = g0;
                                                                        super(2, continuation0);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                        return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.1.1(this.r, continuation0);
                                                                    }

                                                                    @Override  // we.n
                                                                    public Object invoke(Object object0, Object object1) {
                                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                    }

                                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Object invokeSuspend(Object object0) {
                                                                        n.D(object0);
                                                                        try {
                                                                            LogU.Companion.d("RemoteDataSource", "request.tag:" + this.r.b);
                                                                            RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                            HttpResponse httpResponse0 = RequestBuilder.newInstance(this.r.a).listener(requestFuture0).tag(this.r.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                            if(httpResponse0 != null && httpResponse0 instanceof MelonTvVdoRelateVdoListRes) {
                                                                                return new u8.d(e.a, httpResponse0, null);
                                                                            }
                                                                            VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                            return new u8.d(e.b, null, volleyError1);
                                                                        }
                                                                        catch(VolleyError volleyError0) {
                                                                            return new u8.d(e.b, null, volleyError0);
                                                                        }
                                                                    }
                                                                };
                                                                this.r = 1;
                                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$1$10, this);
                                                                return object1 == a0 ? a0 : object1;
                                                            }
                                                            case 1: {
                                                                n.D(object0);
                                                                return object0;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                    }
                                                };
                                                com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.2 videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$20 = new we.a() {
                                                    @Override  // we.a
                                                    public Object invoke() {
                                                        return this.invoke();
                                                    }

                                                    public final s8.b invoke() {
                                                        return b.a().a(this.a.a);
                                                    }
                                                };
                                                com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.3 videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$30 = new k() {
                                                    @Override  // we.k
                                                    public Object invoke(Object object0) {
                                                        this.invoke(((HttpResponse)object0));
                                                        return H.a;
                                                    }

                                                    public final void invoke(HttpResponse httpResponse0) {
                                                        q.g(httpResponse0, "it");
                                                        s8.a a0 = b.a();
                                                        String s = b.c.k(httpResponse0);
                                                        q.f(s, "toJson(...)");
                                                        a0.b(new s8.b(this.b, this.B.a, s, System.currentTimeMillis()));
                                                    }
                                                };
                                                com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.4 videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$40 = new we.n(new Integer(this.B), this.w.b, videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$10, videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$30, null) {
                                                    public int B;
                                                    public Object D;
                                                    public final we.a E;
                                                    public final Integer G;
                                                    public final long I;
                                                    public final k M;
                                                    public final k N;
                                                    public String r;
                                                    public String w;

                                                    {
                                                        this.E = a0;
                                                        this.G = integer0;
                                                        this.I = v;
                                                        this.M = k0;
                                                        this.N = k1;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.4(this.E, this.G, this.I, this.M, this.N, continuation0);
                                                        continuation1.D = object0;
                                                        return continuation1;
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        u8.d d0;
                                                        String s1;
                                                        String s;
                                                        CoroutineScope coroutineScope0 = (CoroutineScope)this.D;
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.B) {
                                                            case 0: {
                                                                n.D(object0);
                                                                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                                                logU$Companion0.d("DataAccessStrategy", "getData() MelonTvVdoRelateVdoListRes");
                                                                s8.b b0 = this.E == null ? null : ((s8.b)this.E.invoke());
                                                                if(b0 != null && !u.H(b0, this.G, this.I)) {
                                                                    HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, MelonTvVdoRelateVdoListRes.class);
                                                                    if(httpResponse0 != null) {
                                                                        logU$Companion0.d("DataAccessStrategy", "getData() MelonTvVdoRelateVdoListRes cacheEntity not expired. > return cachedRes");
                                                                        return new u8.d(e.a, httpResponse0, null);
                                                                    }
                                                                }
                                                                logU$Companion0.d("DataAccessStrategy", "getData() MelonTvVdoRelateVdoListRes cacheEntity expired.");
                                                                this.D = coroutineScope0;
                                                                this.r = "DataAccessStrategy";
                                                                this.w = "MelonTvVdoRelateVdoListRes";
                                                                this.B = 1;
                                                                Object object1 = this.M.invoke(this);
                                                                if(object1 == a0) {
                                                                    return a0;
                                                                }
                                                                s = "MelonTvVdoRelateVdoListRes";
                                                                object0 = object1;
                                                                s1 = "DataAccessStrategy";
                                                                break;
                                                            }
                                                            case 1: {
                                                                s = this.w;
                                                                String s2 = this.r;
                                                                n.D(object0);
                                                                s1 = s2;
                                                                break;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                        switch(((u8.d)object0).a.ordinal()) {
                                                            case 0: {
                                                                HttpResponse httpResponse1 = ((u8.d)object0).b;
                                                                if(httpResponse1 == null) {
                                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                                    d0 = new u8.d(e.b, null, volleyError0);
                                                                }
                                                                else {
                                                                    u8.d d1 = new u8.d(e.a, httpResponse1, null);
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(((u8.d)object0), null) {
                                                                        public final k r;
                                                                        public final u8.d w;

                                                                        {
                                                                            this.r = k0;
                                                                            this.w = d0;
                                                                            super(2, continuation0);
                                                                        }

                                                                        @Override  // oe.a
                                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                                            return new com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.4.1(this.r, this.w, continuation0);
                                                                        }

                                                                        @Override  // we.n
                                                                        public Object invoke(Object object0, Object object1) {
                                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                        }

                                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                            return ((com.iloen.melon.player.video.VideoViewModel.requestVideoList.1.1.invokeSuspend..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                        }

                                                                        @Override  // oe.a
                                                                        public final Object invokeSuspend(Object object0) {
                                                                            n.D(object0);
                                                                            k k0 = this.r;
                                                                            if(k0 != null) {
                                                                                k0.invoke(this.w.b);
                                                                            }
                                                                            return H.a;
                                                                        }
                                                                    }, 2, null);
                                                                    d0 = d1;
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
                                                                d0 = new u8.d(e.b, null, ((u8.d)object0).c);
                                                                break;
                                                            }
                                                            default: {
                                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                            }
                                                        }
                                                        LogU.Companion.d(s1, "getData() " + s + " " + d0);
                                                        return d0;
                                                    }
                                                };
                                                this.r = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), videoViewModel$requestVideoList$1$1$invokeSuspend$$inlined$request$default$2$40, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }

                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(this.w.getCurrentVideoPlayable(), videoViewModel$requestVideoList$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    public final void setEndingViewShow1(boolean z) {
        this.Q = z;
    }

    public final void setRelatedVdoListReqJob(@Nullable Job job0) {
        this.C = job0;
    }

    public final void toggleFullScreenMode() {
        Object object0 = this.l.getValue();
        VideoStatus videoStatus0 = VideoStatus.FullScreen;
        if(object0 == videoStatus0) {
            this.updateCurrentVideoStatus(VideoStatus.Expand, "VideoViewModel - toggleFullScreenMode");
            return;
        }
        this.updateCurrentVideoStatus(videoStatus0, "VideoViewModel - toggleFullScreenMode");
    }

    public final void updateControllerAllVisible(@Nullable Boolean boolean0) {
        boolean z = ((Boolean)this.j.getValue()).booleanValue();
        MutableStateFlow mutableStateFlow0 = this.K;
        if(z) {
            mutableStateFlow0.setValue(Boolean.FALSE);
            return;
        }
        if(((Boolean)this.H.getValue()).booleanValue()) {
            mutableStateFlow0.setValue(Boolean.FALSE);
            return;
        }
        if(this.isMiniPlayerMode()) {
            mutableStateFlow0.setValue(Boolean.FALSE);
            return;
        }
        if(this.Q) {
            mutableStateFlow0.setValue(Boolean.FALSE);
            return;
        }
        if(boolean0 != null) {
            mutableStateFlow0.setValue(boolean0);
            Job job0 = this.S;
            if(job0 != null) {
                DefaultImpls.cancel$default(job0, null, 1, null);
            }
            if(boolean0.booleanValue() && this.T) {
                this.S = BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(null) {
                    public int r;
                    public final VideoViewModel w;

                    {
                        this.w = videoViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.VideoViewModel.updateControllerAllVisible.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoViewModel.updateControllerAllVisible.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                this.r = 1;
                                if(DelayKt.delay(3000L, this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        this.w.updateControllerAllVisible(Boolean.FALSE);
                        return H.a;
                    }
                }, 3, null);
                return;
            }
            Job job1 = this.S;
            if(job1 != null) {
                DefaultImpls.cancel$default(job1, null, 1, null);
            }
        }
    }

    public static void updateControllerAllVisible$default(VideoViewModel videoViewModel0, Boolean boolean0, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateControllerAllVisible");
        }
        if((v & 1) != 0) {
            boolean0 = null;
        }
        videoViewModel0.updateControllerAllVisible(boolean0);
    }

    public void updateCurrentVideoStatus(@NotNull VideoStatus videoStatus0, @NotNull String s) {
        q.g(videoStatus0, "newVideoStatus");
        q.g(s, "caller");
        LogU.debug$default(this.d, "updateCurrentVideoStatus() newVideoStatus: " + videoStatus0 + ", caller = " + s, null, false, 6, null);
        this.k.setValue(videoStatus0);
        MelonAppBase.Companion.getClass();
        MelonAppBase melonAppBase0 = t.a();
        VideoStatus videoStatus1 = VideoStatus.MiniMode;
        boolean z = false;
        melonAppBase0.setVideoMiniPlayer(videoStatus0 == videoStatus1);
        switch(WhenMappings.$EnumSwitchMapping$0[videoStatus0.ordinal()]) {
            case 1: {
                if(AndroidSettings.isAutoRotation() || this.isPipMode()) {
                    this.c(2);
                }
                else if(((Boolean)this.o.getValue()).booleanValue()) {
                    this.c(7);
                }
                else {
                    this.c(6);
                }
                break;
            }
            case 2: {
                this.b(((FoldingFeatureAndScreenLayout)this.w.getValue()));
            }
        }
        if(videoStatus0 != videoStatus1) {
            z = true;
        }
        this.updateControllerAllVisible(Boolean.valueOf(z));
    }

    public final void updateFoldingState(@Nullable FoldingFeatureAndScreenLayout videoViewModel$FoldingFeatureAndScreenLayout0) {
        if(this.l.getValue() == VideoStatus.Expand) {
            this.b(videoViewModel$FoldingFeatureAndScreenLayout0);
        }
        this.v.setValue(videoViewModel$FoldingFeatureAndScreenLayout0);
    }

    public final void updateIsMotionPlaying(boolean z) {
        this.H.setValue(Boolean.valueOf(z));
    }

    public final void updateIsPortraitRatioVideo(boolean z) {
        this.n.setValue(Boolean.valueOf(z));
    }

    public final void updateIsSeekingByUser(boolean z) {
        LogU.debug$default(this.d, "updateIsSeekingByUser : isSeeking-" + z, null, false, 6, null);
        this.O.setValue(Boolean.valueOf(z));
        if(!z) {
            this.updateControllerAllVisible(Boolean.TRUE);
        }
    }

    public final void updateLiked(boolean z) {
        this.a0.setValue(Boolean.valueOf(z));
    }

    public final void updateMotionProgress(@NotNull MotionProgress motionProgress0) {
        q.g(motionProgress0, "newMotionProgress");
        this.W.setValue(motionProgress0);
    }

    public void updatePipState(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
        if(z) {
            this.updateCurrentVideoStatus(VideoStatus.FullScreen, "videoViewModel - updatePipState");
            this.updateControllerAllVisible(Boolean.FALSE);
            return;
        }
        if(this.l.getValue() == VideoStatus.FullScreen) {
            this.updateCurrentVideoStatus(VideoStatus.Expand, "videoViewModel - updatePipState");
        }
    }

    public final void updateScreenHeight(int v) {
        this.t.setValue(v);
    }

    public final void updateScreenOrientation(boolean z) {
        this.p.setValue(Boolean.valueOf(z));
    }

    public final void updateSlideOffset(float f) {
        this.x.setValue(f);
    }

    public final void updateUseControllerHideJob(boolean z) {
        this.T = z;
    }

    public final void updateVideoFocusState(boolean z) {
        this.I.setValue(Boolean.valueOf(z));
    }

    public final void updateVideoListDraggingOrExpanded(boolean z) {
        this.M.setValue(Boolean.valueOf(z));
    }

    public final void updateVideoSize(int v, int v1) {
        Playable playable0 = (Playable)this.h.getValue();
        if(playable0 != null) {
            playable0.setIsLandscapeMv(v > v1);
            playable0.setMvWidth(v);
            playable0.setMvHeight(v1);
            this.updateIsPortraitRatioVideo(!playable0.isLandscapeMv());
        }
    }
}

