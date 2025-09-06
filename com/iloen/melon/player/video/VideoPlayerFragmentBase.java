package com.iloen.melon.player.video;

import Bc.h;
import De.I;
import J8.o2;
import Ld.v;
import M6.B;
import U4.F;
import Ub.s;
import Ub.t;
import a9.f;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.ControllerVideoListView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.P0;
import com.iloen.melon.custom.Q0;
import com.iloen.melon.custom.R0;
import com.iloen.melon.custom.SeekBarForNewVideoPlayer;
import com.iloen.melon.custom.VideoEndingView;
import com.iloen.melon.custom.VideoOverlayView;
import com.iloen.melon.custom.x1;
import com.iloen.melon.custom.y1;
import com.iloen.melon.eventbus.EventVideo.Completed;
import com.iloen.melon.eventbus.EventVideo.Started;
import com.iloen.melon.eventbus.EventVideo;
import com.iloen.melon.net.v4x.request.UaLogDummyFilterReq.Params;
import com.iloen.melon.net.v4x.request.UaLogDummyFilterReq;
import com.iloen.melon.net.v4x.response.MelonTvVdoRelateVdoListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MelonTvVdoRelateVdoListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.StateView;
import com.iloen.melon.playback.VideoSurfaceView;
import com.iloen.melon.popup.RemoteConnectPopup;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.playback.VideoControllerHelper;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import d3.g;
import d5.n;
import e.k;
import gc.G;
import hc.l;
import i.n.i.b.a.s.e.M3;
import ie.m;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import je.p;
import k8.Y;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ob.z;
import oc.H;
import oc.w;
import oe.c;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.O;
import pd.i;
import pe.a;
import pe.b;
import zd.Q;

@Metadata(d1 = {"\u0000\u00B4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u0000 \u00C3\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u00C4\u0001\u00C5\u0001\u00C3\u0001B\u0007\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b\n\u0010\u0005J\u000F\u0010\u000B\u001A\u00020\tH&\u00A2\u0006\u0004\b\u000B\u0010\u0005J\u0011\u0010\r\u001A\u0004\u0018\u00010\fH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u001D\u0010\u0012\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001E\u001A\u00020\u00062\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ+\u0010&\u001A\u00020%2\u0006\u0010!\u001A\u00020 2\b\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010$\u001A\u0004\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\b&\u0010\'J!\u0010)\u001A\u00020\t2\u0006\u0010(\u001A\u00020%2\b\u0010$\u001A\u0004\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010-\u001A\u00020\t2\u0006\u0010,\u001A\u00020+H\u0016\u00A2\u0006\u0004\b-\u0010.J\u0017\u00101\u001A\u00020\t2\u0006\u00100\u001A\u00020/H\u0016\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b3\u0010\u0005J\u000F\u00104\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b4\u0010\u0005J\u000F\u00105\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b5\u0010\u0005J\u000F\u00106\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b6\u0010\u0005J\u000F\u00107\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b7\u0010\u0005J\u000F\u00108\u001A\u00020\tH&\u00A2\u0006\u0004\b8\u0010\u0005J\u0010\u00109\u001A\u00020\tH\u0084@\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010;\u001A\u00020\tH\u0004\u00A2\u0006\u0004\b;\u0010\u0005J\u000F\u0010<\u001A\u00020\tH\u0004\u00A2\u0006\u0004\b<\u0010\u0005J\u000F\u0010=\u001A\u00020\tH\u0004\u00A2\u0006\u0004\b=\u0010\u0005J\u000F\u0010>\u001A\u00020\tH\u0004\u00A2\u0006\u0004\b>\u0010\u0005J\u001F\u0010B\u001A\u0012\u0012\u0004\u0012\u00020@0?j\b\u0012\u0004\u0012\u00020@`AH&\u00A2\u0006\u0004\bB\u0010CJ\u0017\u0010G\u001A\u00020F2\u0006\u0010E\u001A\u00020DH&\u00A2\u0006\u0004\bG\u0010HJ\u000F\u0010I\u001A\u00020\tH\u0004\u00A2\u0006\u0004\bI\u0010\u0005J\u001F\u0010K\u001A\u00020\t2\u0006\u0010(\u001A\u00020%2\u0006\u0010J\u001A\u00020\u001CH\u0004\u00A2\u0006\u0004\bK\u0010LJ+\u0010Q\u001A\u00020\t2\u0006\u0010N\u001A\u00020M2\b\b\u0002\u0010\u0019\u001A\u00020O2\b\b\u0002\u0010P\u001A\u00020\u0006H\u0004\u00A2\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001A\u00020\u00062\u0006\u0010(\u001A\u00020SH\u0016\u00A2\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001A\u00020\t2\u0006\u0010(\u001A\u00020SH\u0016\u00A2\u0006\u0004\bV\u0010WJ\u000F\u0010X\u001A\u00020\u0006H\u0004\u00A2\u0006\u0004\bX\u0010\bJ\u0017\u0010[\u001A\u00020\t2\u0006\u0010Z\u001A\u00020YH\u0007\u00A2\u0006\u0004\b[\u0010\\R\"\u0010^\u001A\u00020]8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b^\u0010_\u001A\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001A\u00020d8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\be\u0010f\u001A\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001A\u00020k8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bl\u0010m\u001A\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010s\u001A\u00020r8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bs\u0010t\u001A\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010z\u001A\u00020y8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bz\u0010{\u001A\u0004\b|\u0010}\"\u0004\b~\u0010\u007FR*\u0010\u0081\u0001\u001A\u00030\u0080\u00018\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001A\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u008C\u0001\u001A\u00030\u0087\u00018DX\u0084\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001A\u0006\b\u008A\u0001\u0010\u008B\u0001R,\u0010\u0094\u0001\u001A\u0005\u0018\u00010\u008D\u00018\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0018\n\u0006\b\u008E\u0001\u0010\u008F\u0001\u001A\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R,\u0010\u009C\u0001\u001A\u0005\u0018\u00010\u0095\u00018\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001A\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009A\u0001\u0010\u009B\u0001R,\u0010\u00A4\u0001\u001A\u0005\u0018\u00010\u009D\u00018\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u009E\u0001\u0010\u009F\u0001\u001A\u0006\b\u00A0\u0001\u0010\u00A1\u0001\"\u0006\b\u00A2\u0001\u0010\u00A3\u0001R,\u0010\u00AC\u0001\u001A\u0005\u0018\u00010\u00A5\u00018\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u00A6\u0001\u0010\u00A7\u0001\u001A\u0006\b\u00A8\u0001\u0010\u00A9\u0001\"\u0006\b\u00AA\u0001\u0010\u00AB\u0001R\u001D\u0010\u00B2\u0001\u001A\u00030\u00AD\u00018\u0006\u00A2\u0006\u0010\n\u0006\b\u00AE\u0001\u0010\u00AF\u0001\u001A\u0006\b\u00B0\u0001\u0010\u00B1\u0001R\u0015\u0010\u00B6\u0001\u001A\u00030\u00B3\u00018F\u00A2\u0006\b\u001A\u0006\b\u00B4\u0001\u0010\u00B5\u0001R\u0019\u0010\u00B9\u0001\u001A\u0004\u0018\u00010D8DX\u0084\u0004\u00A2\u0006\b\u001A\u0006\b\u00B7\u0001\u0010\u00B8\u0001R#\u0010\u00BE\u0001\u001A\u000E\u0012\u0007\b\u0001\u0012\u00030\u00BB\u0001\u0018\u00010\u00BA\u00018DX\u0084\u0004\u00A2\u0006\b\u001A\u0006\b\u00BC\u0001\u0010\u00BD\u0001R\u0018\u0010\u00C2\u0001\u001A\u00030\u00BF\u00018DX\u0084\u0004\u00A2\u0006\b\u001A\u0006\b\u00C0\u0001\u0010\u00C1\u0001\u00A8\u0006\u00C6\u0001"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerFragmentBase;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "La9/f;", "Lpd/i;", "<init>", "()V", "", "shouldIgnoreSetUIOnForegroundEvent", "()Z", "Lie/H;", "setBindSeekBar", "onPlaybackComplete", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/iloen/melon/player/video/VideoStatus;", "status", "initVideoStatusUI", "(Lcom/iloen/melon/player/video/VideoStatus;)V", "onStart", "onStop", "onDestroyView", "onDestroy", "initController", "performMoreClick", "showEndingView", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showEndingViewCase1", "showEndingViewCase2", "showEndingViewCase3", "hideEndingView1AndDoAutoCnt", "Ljava/util/ArrayList;", "Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "Lkotlin/collections/ArrayList;", "getMoreBottomSheetItem", "()Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "playable", "Lzd/Q;", "getMoreBottomSheetType", "(Lcom/iloen/melon/playback/Playable;)Lzd/Q;", "showMoreBottomSheet", "songId", "updateLikeInfo", "(Landroid/view/View;Ljava/lang/String;)V", "", "stringResource", "Lcom/iloen/melon/player/video/VideoPlayerFragmentBase$TiaraLogType;", "isOn", "sendTiaraLogPlayer", "(ILcom/iloen/melon/player/video/VideoPlayerFragmentBase$TiaraLogType;Z)V", "Lcom/iloen/melon/playback/StateView;", "onViewPreClick", "(Lcom/iloen/melon/playback/StateView;)Z", "onViewPostClick", "(Lcom/iloen/melon/playback/StateView;)V", "isForeground", "Lcom/iloen/melon/eventbus/EventVideo;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventVideo;)V", "LUb/q;", "playbackManager", "LUb/q;", "getPlaybackManager", "()LUb/q;", "setPlaybackManager", "(LUb/q;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "LUb/s;", "remotePlayerManager", "LUb/s;", "getRemotePlayerManager", "()LUb/s;", "setRemotePlayerManager", "(LUb/s;)V", "Lhc/l;", "remoteDeviceUseCase", "Lhc/l;", "getRemoteDeviceUseCase", "()Lhc/l;", "setRemoteDeviceUseCase", "(Lhc/l;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "LPd/i;", "appVisibilityManager", "LPd/i;", "getAppVisibilityManager", "()LPd/i;", "setAppVisibilityManager", "(LPd/i;)V", "Lcom/iloen/melon/player/video/LiveViewModel;", "e", "Lie/j;", "getLiveViewModel", "()Lcom/iloen/melon/player/video/LiveViewModel;", "liveViewModel", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration;", "f", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration;", "getSeekBarView", "()Lcom/iloen/melon/player/video/VideoSeekBarAndDuration;", "setSeekBarView", "(Lcom/iloen/melon/player/video/VideoSeekBarAndDuration;)V", "seekBarView", "Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment;", "h", "Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment;", "getSongListBottomSheet", "()Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment;", "setSongListBottomSheet", "(Lcom/iloen/melon/player/video/VideoSongListBottomSheetFragment;)V", "songListBottomSheet", "Lcom/iloen/melon/custom/ControllerVideoListView;", "j", "Lcom/iloen/melon/custom/ControllerVideoListView;", "getVideoListView", "()Lcom/iloen/melon/custom/ControllerVideoListView;", "setVideoListView", "(Lcom/iloen/melon/custom/ControllerVideoListView;)V", "videoListView", "Landroid/widget/RelativeLayout;", "k", "Landroid/widget/RelativeLayout;", "getSongListView", "()Landroid/widget/RelativeLayout;", "setSongListView", "(Landroid/widget/RelativeLayout;)V", "songListView", "Lcom/iloen/melon/utils/log/LogU;", "n", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "LJ8/o2;", "getBinding", "()LJ8/o2;", "binding", "getCurrentPlayable", "()Lcom/iloen/melon/playback/Playable;", "currentPlayable", "Loc/H;", "Loc/Q;", "getPlaylist", "()Loc/H;", "playlist", "Lcom/iloen/melon/player/video/VideoViewModel;", "getVideoViewModel", "()Lcom/iloen/melon/player/video/VideoViewModel;", "videoViewModel", "Companion", "EndingViewCase", "TiaraLogType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class VideoPlayerFragmentBase extends Hilt_VideoPlayerFragmentBase implements f, i {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerFragmentBase$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "STANDARD_SCALE_TYPE_VALUE", "F", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerFragmentBase$EndingViewCase;", "", "CASE_1", "CASE_2", "CASE_3", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static enum EndingViewCase {
        CASE_1,
        CASE_2,
        CASE_3;

        public static final EndingViewCase[] a;
        public static final b b;

        static {
            EndingViewCase.a = arr_videoPlayerFragmentBase$EndingViewCase;
            q.g(arr_videoPlayerFragmentBase$EndingViewCase, "entries");
            EndingViewCase.b = new b(arr_videoPlayerFragmentBase$EndingViewCase);
        }

        @NotNull
        public static a getEntries() {
            return EndingViewCase.b;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerFragmentBase$TiaraLogType;", "", "DEFAULT", "AUTO_PLAY", "PLAY_VIDEO", "SHOW_CHAT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum TiaraLogType {
        DEFAULT,
        AUTO_PLAY,
        PLAY_VIDEO,
        SHOW_CHAT;

        public static final TiaraLogType[] a;
        public static final b b;

        static {
            TiaraLogType.a = arr_videoPlayerFragmentBase$TiaraLogType;
            q.g(arr_videoPlayerFragmentBase$TiaraLogType, "entries");
            TiaraLogType.b = new b(arr_videoPlayerFragmentBase$TiaraLogType);
        }

        @NotNull
        public static a getEntries() {
            return TiaraLogType.b;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[ControllerVisibleStatus.values().length];
            try {
                arr_v[ControllerVisibleStatus.All_VISIBLE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ControllerVisibleStatus.ONLY_SEEK.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ControllerVisibleStatus.ONLY_TITLE.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ControllerVisibleStatus.ALL_GONE.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[EndingViewCase.values().length];
            try {
                arr_v1[EndingViewCase.CASE_1.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[EndingViewCase.CASE_2.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[EndingViewCase.CASE_3.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Inject
    public Pd.i appVisibilityManager;
    public o2 d;
    public final r e;
    public VideoSeekBarAndDuration f;
    public VideoMoreBottomSheetFragment g;
    public VideoSongListBottomSheetFragment h;
    public VideoEndingView i;
    public ControllerVideoListView j;
    public RelativeLayout k;
    public BottomSheetBehavior l;
    public VideoControllerHelper m;
    public final LogU n;
    public CoroutineScope o;
    @Inject
    public Ub.q playbackManager;
    @Inject
    public h playerUiHelper;
    @Inject
    public z playerUseCase;
    public final r r;
    @Inject
    public l remoteDeviceUseCase;
    @Inject
    public s remotePlayerManager;
    public final r w;

    static {
        VideoPlayerFragmentBase.Companion = new Companion(null);
        VideoPlayerFragmentBase.$stable = 8;
    }

    public VideoPlayerFragmentBase() {
        this.e = g.Q(new k0(this, 2));
        LogU logU0 = Z.g("VideoPlayerFragmentBase", true);
        logU0.setCategory(Category.UI);
        this.n = logU0;
        this.r = g.Q(new k0(this, 3));
        this.w = g.Q(new k0(this, 4));
    }

    public static final Object access$getEndingViewCase(VideoPlayerFragmentBase videoPlayerFragmentBase0, Continuation continuation0) {
        return videoPlayerFragmentBase0.i0(continuation0);
    }

    // 去混淆评级： 低(20)
    public static final int access$getRecommendedListPeekHeight(VideoPlayerFragmentBase videoPlayerFragmentBase0, boolean z) {
        return z ? ScreenUtils.dipToPixel(videoPlayerFragmentBase0.getContext(), 72.0f) : ScreenUtils.dipToPixel(videoPlayerFragmentBase0.getContext(), 48.0f);
    }

    public static final void access$handleIsPlaying(VideoPlayerFragmentBase videoPlayerFragmentBase0, boolean z) {
        videoPlayerFragmentBase0.getBinding().q.setKeepScreenOn(z);
        if(z && ((t)videoPlayerFragmentBase0.getRemotePlayerManager()).c()) {
            LogU.debug$default(videoPlayerFragmentBase0.n, "resetVideoPortrait - playing on GoogleCast", null, false, 6, null);
            videoPlayerFragmentBase0.getVideoViewModel().updateIsPortraitRatioVideo(false);
        }
        if(!g.N(videoPlayerFragmentBase0.getPlaybackManager().a())) {
            videoPlayerFragmentBase0.n0(true);
        }
    }

    public static final void access$handlePlaybackStateChanged(VideoPlayerFragmentBase videoPlayerFragmentBase0, int v) {
        LogU.info$default(videoPlayerFragmentBase0.n, "handlePlaybackStateChanged() state: " + F.a0(v), null, false, 6, null);
        m m0 = v == 2 ? new m(0, 4) : new m(8, 0);
        videoPlayerFragmentBase0.getBinding().d.setVisibility(((Number)m0.a).intValue());
        ((View)videoPlayerFragmentBase0.r.getValue()).setVisibility(((Number)m0.b).intValue());
    }

    public static final void access$sendTiaraLogCurationVideo(VideoPlayerFragmentBase videoPlayerFragmentBase0, int v, String s, String s1) {
        Playable playable0 = videoPlayerFragmentBase0.getCurrentPlayable();
        if(playable0 == null) {
            return;
        }
        e1.m.F(new v(videoPlayerFragmentBase0, v + 1, playable0, s, s1, 2)).track();
    }

    public static final void access$setScaleType(VideoPlayerFragmentBase videoPlayerFragmentBase0, Float float0, boolean z, VideoStatus videoStatus0) {
        LogU.debug$default(videoPlayerFragmentBase0.n, "offset:" + float0 + ",isOrientationPortrait:" + z + ",videoStatus:" + videoStatus0, null, false, 6, null);
        int v = 1001;
        if(videoStatus0 != VideoStatus.MiniMode) {
            if(float0 == null || !z || videoStatus0 == VideoStatus.FullScreen || videoStatus0 == VideoStatus.Undefined) {
                v = 1000;
            }
            else if(((float)float0) >= 0.4f) {
                v = 1002;
            }
        }
        videoPlayerFragmentBase0.getBinding().q.setScaleType(v);
    }

    public static final void access$showControllerView(VideoPlayerFragmentBase videoPlayerFragmentBase0, ControllerVisibleStatus controllerVisibleStatus0) {
        LogConstantsKt.infoOnlyDebugMode(videoPlayerFragmentBase0.n, "showControllerView() " + controllerVisibleStatus0);
        videoPlayerFragmentBase0.m0(true);
        videoPlayerFragmentBase0.getBinding().g.m.setVisibility(0);
        videoPlayerFragmentBase0.getBinding().d.setVisibility((((Boolean)videoPlayerFragmentBase0.getVideoViewModel().isSeekingByUser().getValue()).booleanValue() ? 0 : 8));
        switch(WhenMappings.$EnumSwitchMapping$0[controllerVisibleStatus0.ordinal()]) {
            case 1: {
                videoPlayerFragmentBase0.getBinding().g.a.setVisibility(0);
                videoPlayerFragmentBase0.l0(false);
                return;
            }
            case 2: {
                videoPlayerFragmentBase0.getBinding().g.a.setVisibility(0);
                videoPlayerFragmentBase0.m0(false);
                return;
            }
            case 3: {
                videoPlayerFragmentBase0.getBinding().g.a.setVisibility(0);
                videoPlayerFragmentBase0.getBinding().g.m.setVisibility(8);
                videoPlayerFragmentBase0.getBinding().g.d.setVisibility(8);
                videoPlayerFragmentBase0.getBinding().g.o.setVisibility(8);
                videoPlayerFragmentBase0.getBinding().g.b.setVisibility(8);
                videoPlayerFragmentBase0.getBinding().g.q.setVisibility(8);
                return;
            }
            case 4: {
                videoPlayerFragmentBase0.getBinding().g.a.setVisibility(8);
                return;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final void access$showVideoList(VideoPlayerFragmentBase videoPlayerFragmentBase0, RESPONSE melonTvVdoRelateVdoListRes$RESPONSE0) {
        if(!videoPlayerFragmentBase0.getVideoViewModel().isPipMode() && !videoPlayerFragmentBase0.getVideoViewModel().isMiniPlayerMode() && videoPlayerFragmentBase0.getVideoViewModel().isFullScreen()) {
            ArrayList arrayList0 = melonTvVdoRelateVdoListRes$RESPONSE0 == null ? null : melonTvVdoRelateVdoListRes$RESPONSE0.mvlist;
            if(arrayList0 == null || arrayList0.isEmpty()) {
                LogU.debug$default(videoPlayerFragmentBase0.n, "showVideoList - video list null or empty", null, false, 6, null);
                ControllerVideoListView controllerVideoListView1 = videoPlayerFragmentBase0.j;
                if(controllerVideoListView1 != null) {
                    controllerVideoListView1.setVisibility(8);
                }
            }
            else if(melonTvVdoRelateVdoListRes$RESPONSE0 != null) {
                videoPlayerFragmentBase0.getBinding().g.c.setVisibility(0);
                if(videoPlayerFragmentBase0.j == null) {
                    View view0 = videoPlayerFragmentBase0.getBinding().g.n.inflate();
                    q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ControllerVideoListView");
                    videoPlayerFragmentBase0.j = (ControllerVideoListView)view0;
                    View view1 = ((ControllerVideoListView)view0).findViewById(0x7F0A0127);  // id:bottom_sheet_container
                    q.e(view1, "null cannot be cast to non-null type android.widget.RelativeLayout");
                    BottomSheetBehavior bottomSheetBehavior0 = BottomSheetBehavior.D(((RelativeLayout)view1));
                    videoPlayerFragmentBase0.l = bottomSheetBehavior0;
                    if(bottomSheetBehavior0 != null) {
                        bottomSheetBehavior0.w(new VideoPlayerFragmentBase.showVideoList.1.1.1(((ControllerVideoListView)view0), videoPlayerFragmentBase0));
                    }
                    ((ControllerVideoListView)view0).setOnItemClickListener(new VideoPlayerFragmentBase.showVideoList.1.1.2(videoPlayerFragmentBase0));
                    ((RelativeLayout)view1).post(new com.iloen.melon.player.video.q(videoPlayerFragmentBase0, 2));
                }
                ControllerVideoListView controllerVideoListView0 = videoPlayerFragmentBase0.j;
                if(controllerVideoListView0 != null) {
                    ArrayList arrayList1 = melonTvVdoRelateVdoListRes$RESPONSE0.mvlist;
                    q.f(arrayList1, "mvlist");
                    controllerVideoListView0.setData(arrayList1);
                    controllerVideoListView0.setVisibility(0);
                }
            }
        }
    }

    public static final void access$updateControllerVisibleWithFadeOut(VideoPlayerFragmentBase videoPlayerFragmentBase0, boolean z) {
        videoPlayerFragmentBase0.n0(z);
    }

    public static final void access$updateThumbImageForGoogleCast(VideoPlayerFragmentBase videoPlayerFragmentBase0, Playable playable0) {
        Context context0 = videoPlayerFragmentBase0.getContext();
        if(context0 != null) {
            Glide.with(context0).clear(videoPlayerFragmentBase0.getBinding().p);
            String s = null;
            ((RequestBuilder)Glide.with(context0).load((playable0 == null ? null : "")).placeholder(0x7F0808A5)).into(videoPlayerFragmentBase0.getBinding().p);  // drawable:shape_rectangle_black
            LogU logU0 = videoPlayerFragmentBase0.n;
            if(playable0 != null) {
                s = "";
            }
            LogU.debug$default(logU0, "updateThumbImageForGoogleCast() - " + s, null, false, 6, null);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    public static String e0(VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        if(q.b(videoPlayerFragmentBase0.mMenuId, "1000002977")) {
            return videoPlayerFragmentBase0.getString(0x7F131032);  // string:tiara_video_player_page_live_preview "영상플레이어_LIVE예고"
        }
        return q.b(videoPlayerFragmentBase0.mMenuId, "1000002967") ? videoPlayerFragmentBase0.getString(0x7F131031) : videoPlayerFragmentBase0.getString(0x7F131034);  // string:tiara_video_player_page_live_onair "영상플레이어_LIVE"
    }

    public static String f0(VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        if(q.b(videoPlayerFragmentBase0.mMenuId, "1000002977")) {
            return videoPlayerFragmentBase0.getString(0x7F131032);  // string:tiara_video_player_page_live_preview "영상플레이어_LIVE예고"
        }
        return q.b(videoPlayerFragmentBase0.mMenuId, "1000002967") ? videoPlayerFragmentBase0.getString(0x7F131031) : videoPlayerFragmentBase0.getString(0x7F131034);  // string:tiara_video_player_page_live_onair "영상플레이어_LIVE"
    }

    public static String g0(VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        String s = videoPlayerFragmentBase0.mMenuId;
        q.f(s, "mMenuId");
        return s;
    }

    @NotNull
    public final Pd.i getAppVisibilityManager() {
        Pd.i i0 = this.appVisibilityManager;
        if(i0 != null) {
            return i0;
        }
        q.m("appVisibilityManager");
        throw null;
    }

    @NotNull
    public final o2 getBinding() {
        o2 o20 = this.d;
        q.d(o20);
        return o20;
    }

    @Nullable
    public final Playable getCurrentPlayable() {
        return (Playable)this.getVideoViewModel().getCurrentVideoPlayable().getValue();
    }

    @NotNull
    public final LiveViewModel getLiveViewModel() {
        return (LiveViewModel)this.e.getValue();
    }

    @NotNull
    public final LogU getLog() {
        return this.n;
    }

    @NotNull
    public abstract ArrayList getMoreBottomSheetItem();

    @NotNull
    public abstract Q getMoreBottomSheetType(@NotNull Playable arg1);

    @NotNull
    public final Ub.q getPlaybackManager() {
        Ub.q q0 = this.playbackManager;
        if(q0 != null) {
            return q0;
        }
        q.m("playbackManager");
        throw null;
    }

    @NotNull
    public final h getPlayerUiHelper() {
        h h0 = this.playerUiHelper;
        if(h0 != null) {
            return h0;
        }
        q.m("playerUiHelper");
        throw null;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    @Nullable
    public final H getPlaylist() {
        return ((d3)this.playlistManager).k();
    }

    @NotNull
    public final l getRemoteDeviceUseCase() {
        l l0 = this.remoteDeviceUseCase;
        if(l0 != null) {
            return l0;
        }
        q.m("remoteDeviceUseCase");
        throw null;
    }

    @NotNull
    public final s getRemotePlayerManager() {
        s s0 = this.remotePlayerManager;
        if(s0 != null) {
            return s0;
        }
        q.m("remotePlayerManager");
        throw null;
    }

    @Nullable
    public VideoSeekBarAndDuration getSeekBarView() {
        return this.f;
    }

    @Nullable
    public final VideoSongListBottomSheetFragment getSongListBottomSheet() {
        return this.h;
    }

    @Nullable
    public final RelativeLayout getSongListView() {
        return this.k;
    }

    @Nullable
    public final ControllerVideoListView getVideoListView() {
        return this.j;
    }

    @NotNull
    public final VideoViewModel getVideoViewModel() {
        VideoViewModel videoViewModel0 = this.getLiveViewModel();
        q.e(videoViewModel0, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoViewModel");
        return videoViewModel0;
    }

    public static String h0(VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        String s = videoPlayerFragmentBase0.mMenuId;
        q.f(s, "mMenuId");
        return s;
    }

    public final void hideEndingView1AndDoAutoCnt() {
        VideoEndingView videoEndingView0 = this.i;
        if(videoEndingView0 != null) {
            videoEndingView0.setVisibility(8);
        }
    }

    public final Enum i0(Continuation continuation0) {
        Enum enum1;
        boolean z2;
        VideoPlayerFragmentBase.getEndingViewCase.1 videoPlayerFragmentBase$getEndingViewCase$10;
        if(continuation0 instanceof VideoPlayerFragmentBase.getEndingViewCase.1) {
            videoPlayerFragmentBase$getEndingViewCase$10 = (VideoPlayerFragmentBase.getEndingViewCase.1)continuation0;
            int v = videoPlayerFragmentBase$getEndingViewCase$10.D;
            if((v & 0x80000000) == 0) {
                videoPlayerFragmentBase$getEndingViewCase$10 = new VideoPlayerFragmentBase.getEndingViewCase.1(this, continuation0);
            }
            else {
                videoPlayerFragmentBase$getEndingViewCase$10.D = v ^ 0x80000000;
            }
        }
        else {
            videoPlayerFragmentBase$getEndingViewCase$10 = new VideoPlayerFragmentBase.getEndingViewCase.1(this, continuation0);
        }
        Object object0 = videoPlayerFragmentBase$getEndingViewCase$10.w;
        Enum enum0 = ne.a.a;
        boolean z = true;
        switch(videoPlayerFragmentBase$getEndingViewCase$10.D) {
            case 0: {
                n.D(object0);
                boolean z1 = ((Ub.v)this.vodRepeatManager).a();
                B b0 = ((d3)this.playlistManager).g();
                videoPlayerFragmentBase$getEndingViewCase$10.r = z1;
                videoPlayerFragmentBase$getEndingViewCase$10.D = 1;
                Object object1 = ListenableFutureKt.await(b0, videoPlayerFragmentBase$getEndingViewCase$10);
                if(object1 == enum0) {
                    return enum0;
                }
                z2 = z1;
                object0 = object1;
                break;
            }
            case 1: {
                z2 = videoPlayerFragmentBase$getEndingViewCase$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v1 = ((H)object0).p();
        if(((H)object0).getState().b() >= v1) {
            z = false;
        }
        if(!this.getVideoViewModel().isFullScreen()) {
            enum1 = !z2 || !z ? EndingViewCase.CASE_3 : EndingViewCase.CASE_1;
        }
        else if(!z) {
            enum1 = EndingViewCase.CASE_3;
        }
        else if(z2) {
            enum1 = EndingViewCase.CASE_1;
        }
        else {
            enum1 = EndingViewCase.CASE_2;
        }
        LogConstantsKt.debugOnlyDebugMode(this.n, "EndingViewCase: " + enum1);
        return enum1;
    }

    public void initController() {
        float f;
        o2 o20 = this.getBinding();
        com.iloen.melon.player.video.j0 j00 = new com.iloen.melon.player.video.j0(this, 3);
        o20.g.k.setOnClickListener(j00);
        this.setBindSeekBar();
        LogU.info$default(this.n, "setBindController()", null, false, 6, null);
        VideoControllerHelper videoControllerHelper0 = this.m;
        boolean z = true;
        if(videoControllerHelper0 != null) {
            videoControllerHelper0.l.clear();
            Playable playable0 = (Playable)this.getVideoViewModel().getCurrentVideoPlayable().getValue();
            boolean z1 = playable0 == null ? false : playable0.isLiveContent();
            if(((playable0 == null || !playable0.isLivePreView() ? 0 : 1) | !z1) != 0) {
                VideoSeekBarAndDuration videoSeekBarAndDuration0 = this.getSeekBarView();
                VideoSeekBarAndDuration videoSeekBarAndDuration1 = this.getSeekBarView();
                for(Object object0: k.C(new m[]{new m(0, StateView.getView(this.findViewById(0x7F0A0671))), new m(1, StateView.getView(this.findViewById(0x7F0A0655))), new m(10, StateView.getView(this.findViewById(0x7F0A0D30))), new m(11, StateView.getView(this.findViewById(0x7F0A0C55))), new m(12, StateView.getView((videoSeekBarAndDuration0 == null ? null : videoSeekBarAndDuration0.getTvSeekThumbDuration()))), new m(13, StateView.getView((videoSeekBarAndDuration1 == null ? null : videoSeekBarAndDuration1.getVideoSeekBar())))})) {  // id:iv_prev
                    q.d(((StateView)((m)object0).b));
                    videoControllerHelper0.a(((Number)((m)object0).a).intValue(), ((StateView)((m)object0).b));
                }
            }
            m m0 = z1 ? new m(2, StateView.getToggleView(((View)this.r.getValue()), 0x7F080234, 0x7F080235)) : new m(3, StateView.getToggleViewWithReply(((View)this.r.getValue()), 0x7F080234, 0x7F080235, 0x7F08023B));  // drawable:btn_player_pause
            q.d(((StateView)m0.b));
            videoControllerHelper0.a(((Number)m0.a).intValue(), ((StateView)m0.b));
            StateView stateView0 = StateView.getView(this.findViewById(0x7F0A0663));  // id:iv_player_autoplay
            q.f(stateView0, "getView(...)");
            videoControllerHelper0.a(20, stateView0);
            StateView stateView1 = StateView.getToggleView(((View)this.w.getValue()), 0x7F08022C, 0x7F08022B);  // drawable:btn_player_connect_on
            q.f(stateView1, "getToggleView(...)");
            videoControllerHelper0.a(21, stateView1);
            androidx.lifecycle.s s0 = this.getViewLifecycleOwner().getLifecycle().b();
            if(s0.compareTo(androidx.lifecycle.s.d) >= 0) {
                LogU.debug$default(this.n, "setBindController() lifecycleState: " + s0, null, false, 6, null);
                videoControllerHelper0.c();
            }
            o2 o21 = this.getBinding();
            com.iloen.melon.player.video.j0 j01 = new com.iloen.melon.player.video.j0(this, 0);
            o21.g.j.setOnClickListener(j01);
            o2 o22 = this.getBinding();
            com.iloen.melon.player.video.j0 j02 = new com.iloen.melon.player.video.j0(this, 1);
            o22.g.i.setOnClickListener(j02);
        }
        VideoOverlayView videoOverlayView0 = this.getBinding().h;
        if(this.getVideoViewModel().getVideoStatus().getValue() != VideoStatus.FullScreen) {
            z = false;
        }
        boolean z2 = ((Boolean)this.getVideoViewModel().isVideoPortraitRatio().getValue()).booleanValue();
        if(!z) {
            f = 10.0f;
        }
        else if(!z2) {
            f = 16.0f;
        }
        else {
            f = 20.0f;
        }
        float f1 = (float)ScreenUtils.dipToPixel(videoOverlayView0.getContext(), f);
        videoOverlayView0.E.setArcSize(f1);
        videoOverlayView0.setViewModel(this.getVideoViewModel());
        VideoSeekBarAndDuration videoSeekBarAndDuration2 = this.getSeekBarView();
        if(videoSeekBarAndDuration2 != null) {
            SeekBarForNewVideoPlayer seekBarForNewVideoPlayer0 = videoSeekBarAndDuration2.getVideoSeekBar();
            if(seekBarForNewVideoPlayer0 != null) {
                videoOverlayView0.setSeekBarForVideoPlayer(seekBarForNewVideoPlayer0);
            }
        }
        videoOverlayView0.setPerformListener(new VideoPlayerFragmentBase.setUpGestureView.2(this, videoOverlayView0));
    }

    public void initVideoStatusUI(@NotNull VideoStatus videoStatus0) {
        q.g(videoStatus0, "status");
        this.getBinding().g.j.setImageResource((this.getVideoViewModel().isFullScreen() ? 0x7F08022F : 0x7F08022E));  // drawable:btn_player_fullscreen_exit
        if(videoStatus0 == VideoStatus.MiniMode) {
            VideoMoreBottomSheetFragment videoMoreBottomSheetFragment0 = this.g;
            if(videoMoreBottomSheetFragment0 != null) {
                videoMoreBottomSheetFragment0.dismiss();
            }
            this.hideEndingView1AndDoAutoCnt();
        }
        if(videoStatus0 == VideoStatus.Expand && this.getVideoViewModel().isEndingViewShow1()) {
            VideoEndingView videoEndingView0 = this.i;
            if(videoEndingView0 != null) {
                videoEndingView0.setVisibility(0);
            }
        }
        if(this.getVideoViewModel().isMiniPlayerMode()) {
            return;
        }
        boolean z = ((Boolean)this.getVideoViewModel().isOrientationPortrait().getValue()).booleanValue();
        MelonTextView melonTextView0 = this.getBinding().g.r;
        if(!this.getVideoViewModel().isFullScreen() || !z) {
            melonTextView0.setTextSize(1, 16.0f);
        }
        else {
            melonTextView0.setTextSize(1, 22.0f);
        }
        melonTextView0.requestLayout();
        melonTextView0.setFocusableInTouchMode(true);
        melonTextView0.setSelected(true);
    }

    public final boolean isForeground() {
        return ((AppVisibilityManagerImpl)this.getAppVisibilityManager()).e;
    }

    public final void j0() {
        this.getVideoViewModel().setEndingViewShow1(false);
        VideoEndingView videoEndingView0 = this.i;
        if(videoEndingView0 != null) {
            videoEndingView0.c();
        }
        VideoEndingView videoEndingView1 = this.i;
        if(videoEndingView1 != null) {
            videoEndingView1.setVisibility(8);
        }
    }

    public final void k0(VideoSurfaceView videoSurfaceView0) {
        z z0 = this.getPlayerUseCase();
        fc.a a0 = z0.d(z0.c.a());
        LogU.debug$default(this.n, "setSurfaceView() renderer: " + a0.i, null, false, 6, null);
        z z1 = this.getPlayerUseCase();
        G g0 = z1.d(z1.c.a()).i;
        if(g0 != null) {
            q.g(videoSurfaceView0, "view");
            LogConstantsKt.infoOnlyDebugMode(((gc.l)g0).b, "setSurfaceView()");
            ((gc.l)g0).f.setSurfaceView(videoSurfaceView0);
        }
    }

    public final void l0(boolean z) {
        ControllerVideoListView controllerVideoListView0 = this.j;
        if(controllerVideoListView0 != null) {
            controllerVideoListView0.b(z);
        }
        BottomSheetBehavior bottomSheetBehavior0 = this.l;
        if(bottomSheetBehavior0 != null) {
            bottomSheetBehavior0.M((z ? 3 : 4));
        }
    }

    public final void m0(boolean z) {
        int v = 0;
        this.getBinding().g.o.setVisibility((z ? 0 : 8));
        this.getBinding().g.d.setVisibility((z ? 0 : 8));
        this.getBinding().g.b.setVisibility((z ? 0 : 8));
        this.getBinding().g.i.setVisibility((z ? 0 : 8));
        this.getBinding().g.q.setVisibility((z ? 0 : 8));
        if(this.getVideoViewModel().isFullScreen()) {
            this.getBinding().g.r.setVisibility((z ? 0 : 8));
            this.getBinding().g.p.setVisibility((z ? 0 : 8));
        }
        Playable playable0 = (Playable)this.getVideoViewModel().getCurrentVideoPlayable().getValue();
        if(playable0 != null && playable0.isLivePreView()) {
            if(!this.getVideoViewModel().isFullScreen()) {
                return;
            }
            MelonImageView melonImageView0 = this.getBinding().g.h;
            if(!z) {
                v = 8;
            }
            melonImageView0.setVisibility(v);
            return;
        }
        if(this.getVideoViewModel().isSuccessVdoList()) {
            if(this.getVideoViewModel().isFullScreen()) {
                CoordinatorLayout coordinatorLayout0 = this.getBinding().g.c;
                if(!z) {
                    v = 8;
                }
                coordinatorLayout0.setVisibility(v);
            }
            return;
        }
        this.getBinding().g.c.setVisibility(8);
    }

    public final void n0(boolean z) {
        VideoViewModel videoViewModel0 = this.getVideoViewModel();
        videoViewModel0.updateUseControllerHideJob(z);
        videoViewModel0.updateControllerAllVisible(Boolean.TRUE);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.l0(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D04E4, viewGroup0, false);  // layout:melon_video_player_layout
        int v = 0x7F0A0119;  // id:bottom_dim
        View view1 = I.C(view0, 0x7F0A0119);  // id:bottom_dim
        if(view1 != null) {
            v = 0x7F0A019C;  // id:btn_reaction
            View view2 = I.C(view0, 0x7F0A019C);  // id:btn_reaction
            if(((ImageButton)view2) != null) {
                v = 0x7F0A01C7;  // id:bufferingprogress
                View view3 = I.C(view0, 0x7F0A01C7);  // id:bufferingprogress
                if(((ConstraintLayout)view3) != null && ((ImageView)I.C(view0, 0x7F0A0550)) != null) {  // id:icon_rotate
                    v = 0x7F0A063A;  // id:iv_like
                    View view4 = I.C(view0, 0x7F0A063A);  // id:iv_like
                    if(((CheckableImageView)view4) != null) {
                        v = 0x7F0A0895;  // id:navigation_bar
                        View view5 = I.C(view0, 0x7F0A0895);  // id:navigation_bar
                        if(view5 != null && ((Guideline)I.C(view0, 0x7F0A08E9)) != null) {  // id:orientaion_change_guidline
                            v = 0x7F0A0927;  // id:player_controller_container
                            View view6 = I.C(view0, 0x7F0A0927);  // id:player_controller_container
                            if(view6 != null) {
                                int v1 = 0x7F0A0121;  // id:bottom_meta_container
                                View view7 = I.C(view6, 0x7F0A0121);  // id:bottom_meta_container
                                if(((Group)view7) == null || ((FrameLayout)I.C(view6, 0x7F0A0129)) == null || ((LottieAnimationView)I.C(view6, 0x7F0A018C)) == null) {  // id:bottom_song_container
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0337;  // id:content_container
                                View view8 = I.C(view6, 0x7F0A0337);  // id:content_container
                                if(((CoordinatorLayout)view8) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0344;  // id:control_container
                                View view9 = I.C(view6, 0x7F0A0344);  // id:control_container
                                if(((ConstraintLayout)view9) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A03C8;  // id:dimmed
                                View view10 = I.C(view6, 0x7F0A03C8);  // id:dimmed
                                if(view10 == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A05E0;  // id:iv_19_badge
                                View view11 = I.C(view6, 0x7F0A05E0);  // id:iv_19_badge
                                if(((ImageView)view11) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0648;  // id:iv_live_badge
                                View view12 = I.C(view6, 0x7F0A0648);  // id:iv_live_badge
                                if(((MelonImageView)view12) == null || ((MelonImageView)I.C(view6, 0x7F0A0655)) == null || (((MelonImageView)I.C(view6, 0x7F0A0663)) == null || ((MelonImageView)I.C(view6, 0x7F0A0664)) == null)) {  // id:iv_next
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0665;  // id:iv_player_close
                                View view13 = I.C(view6, 0x7F0A0665);  // id:iv_player_close
                                if(((MelonImageView)view13) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0666;  // id:iv_player_fullscreen
                                View view14 = I.C(view6, 0x7F0A0666);  // id:iv_player_fullscreen
                                if(((MelonImageView)view14) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0667;  // id:iv_player_more
                                View view15 = I.C(view6, 0x7F0A0667);  // id:iv_player_more
                                if(((MelonImageView)view15) == null || ((MelonImageView)I.C(view6, 0x7F0A0668)) == null || (((MelonImageView)I.C(view6, 0x7F0A0669)) == null || ((MelonImageView)I.C(view6, 0x7F0A066A)) == null) || (((MelonImageView)I.C(view6, 0x7F0A0671)) == null || ((MelonImageView)I.C(view6, 0x7F0A0679)) == null || ((MelonImageView)I.C(view6, 0x7F0A06B4)) == null)) {  // id:iv_player_play_pause
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A09BF;  // id:reaction_container
                                View view16 = I.C(view6, 0x7F0A09BF);  // id:reaction_container
                                if(((RelativeLayout)view16) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0A53;  // id:seekbar_container
                                View view17 = I.C(view6, 0x7F0A0A53);  // id:seekbar_container
                                if(((RelativeLayout)view17) == null || ((ViewStub)I.C(view6, 0x7F0A0AF5)) == null) {  // id:stub_song_list
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0AF6;  // id:stub_video_list
                                View view18 = I.C(view6, 0x7F0A0AF6);  // id:stub_video_list
                                if(((ViewStub)view18) == null || ((LinearLayout)I.C(view6, 0x7F0A0B96)) == null) {  // id:title_container
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0BCD;  // id:top_btn_container
                                View view19 = I.C(view6, 0x7F0A0BCD);  // id:top_btn_container
                                if(((RelativeLayout)view19) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0C12;  // id:tv_artist
                                View view20 = I.C(view6, 0x7F0A0C12);  // id:tv_artist
                                if(((MelonTextView)view20) == null || ((MelonTextView)I.C(view6, 0x7F0A0C55)) == null || ((MelonTextView)I.C(view6, 0x7F0A0CF8)) == null) {  // id:tv_current_time
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0CFB;  // id:tv_remote_device_name_noti
                                View view21 = I.C(view6, 0x7F0A0CFB);  // id:tv_remote_device_name_noti
                                if(((MelonTextView)view21) == null || ((MelonTextView)I.C(view6, 0x7F0A0D11)) == null || ((MelonTextView)I.C(view6, 0x7F0A0D30)) == null) {  // id:tv_slash
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0D50;  // id:tv_video_title
                                View view22 = I.C(view6, 0x7F0A0D50);  // id:tv_video_title
                                if(((MelonTextView)view22) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0D52;  // id:tv_view_count
                                View view23 = I.C(view6, 0x7F0A0D52);  // id:tv_view_count
                                if(((MelonTextView)view23) == null || ((MelonTextView)I.C(view6, 0x7F0A0D54)) == null) {  // id:tv_vote_time
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                v1 = 0x7F0A0DC0;  // id:view_cnt_container
                                View view24 = I.C(view6, 0x7F0A0DC0);  // id:view_cnt_container
                                if(((RelativeLayout)view24) == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
                                }
                                J8.M3 m30 = new J8.M3(((ConstraintLayout)view6), ((Group)view7), ((CoordinatorLayout)view8), ((ConstraintLayout)view9), ((ConstraintLayout)view6), view10, ((ImageView)view11), ((MelonImageView)view12), ((MelonImageView)view13), ((MelonImageView)view14), ((MelonImageView)view15), ((RelativeLayout)view16), ((RelativeLayout)view17), ((ViewStub)view18), ((RelativeLayout)view19), ((MelonTextView)view20), ((MelonTextView)view21), ((MelonTextView)view22), ((MelonTextView)view23), ((RelativeLayout)view24));
                                v = 0x7F0A092A;  // id:player_gestureView
                                View view25 = I.C(view0, 0x7F0A092A);  // id:player_gestureView
                                if(((VideoOverlayView)view25) != null) {
                                    v = 0x7F0A0A0F;  // id:rotate_guide_container
                                    View view26 = I.C(view0, 0x7F0A0A0F);  // id:rotate_guide_container
                                    if(((ConstraintLayout)view26) != null) {
                                        v = 0x7F0A0AAC;  // id:song_list_container
                                        View view27 = I.C(view0, 0x7F0A0AAC);  // id:song_list_container
                                        if(((ConstraintLayout)view27) != null && ((RelativeLayout)I.C(view0, 0x7F0A0AAE)) != null) {  // id:song_meta_container
                                            v = 0x7F0A0AF2;  // id:stub_ending_view
                                            View view28 = I.C(view0, 0x7F0A0AF2);  // id:stub_ending_view
                                            if(((ViewStub)view28) != null) {
                                                v = 0x7F0A0B72;  // id:thumb_container
                                                View view29 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                                                if(view29 != null) {
                                                    MelonImageView melonImageView0 = (MelonImageView)I.C(view29, 0x7F0A069A);  // id:iv_thumb
                                                    if(melonImageView0 == null || ((ImageView)I.C(view29, 0x7F0A069E)) == null || ((ImageView)I.C(view29, 0x7F0A06A4)) == null) {  // id:iv_thumb_default
                                                        throw new NullPointerException("Missing required view with ID: " + view29.getResources().getResourceName(0x7F0A069A));  // id:iv_thumb
                                                    }
                                                    J8.b b0 = new J8.b(((FrameLayout)view29), melonImageView0, 10);
                                                    View view30 = I.C(view0, 0x7F0A0D15);  // id:tv_song_artist
                                                    if(((MelonTextView)view30) == null) {
                                                        v = 0x7F0A0D15;  // id:tv_song_artist
                                                        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
                                                    }
                                                    else {
                                                        View view31 = I.C(view0, 0x7F0A0D1B);  // id:tv_song_title
                                                        if(((MelonTextView)view31) == null || ((FrameLayout)I.C(view0, 0x7F0A0DB0)) == null) {  // id:video_container
                                                            v = 0x7F0A0D1B;  // id:tv_song_title
                                                        }
                                                        else {
                                                            int v2 = 0x7F0A0DB9;  // id:video_thumbnail
                                                            View view32 = I.C(view0, 0x7F0A0DB9);  // id:video_thumbnail
                                                            if(((MelonImageView)view32) != null) {
                                                                v2 = 0x7F0A0DCC;  // id:view_surface
                                                                View view33 = I.C(view0, 0x7F0A0DCC);  // id:view_surface
                                                                if(((VideoSurfaceView)view33) != null) {
                                                                    this.d = new o2(((ConstraintLayout)view0), view1, ((ImageButton)view2), ((ConstraintLayout)view3), ((CheckableImageView)view4), view5, m30, ((VideoOverlayView)view25), ((ConstraintLayout)view26), ((ConstraintLayout)view27), ((ViewStub)view28), b0, ((MelonTextView)view30), ((MelonTextView)view31), ((ConstraintLayout)view0), ((MelonImageView)view32), ((VideoSurfaceView)view33));
                                                                    VideoSurfaceView videoSurfaceView0 = this.getBinding().q;
                                                                    if(A8.b.d()) {
                                                                        videoSurfaceView0.setSecure(true);
                                                                    }
                                                                    o2 o20 = this.getBinding();
                                                                    q.f(o20.a, "getRoot(...)");
                                                                    return o20.a;
                                                                }
                                                            }
                                                            v = v2;
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
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        super.onDestroy();
        CoroutineScope coroutineScope0 = this.o;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "Fragment destroyed", null, 2, null);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        VideoControllerHelper videoControllerHelper0 = this.m;
        if(videoControllerHelper0 != null) {
            LogU.info$default(videoControllerHelper0.b, "onUiDestroy()", null, false, 6, null);
            videoControllerHelper0.l.clear();
        }
        this.m = null;
        boolean z = !A8.b.d();
        z z1 = this.getPlayerUseCase();
        fc.a a0 = z1.d(z1.c.a());
        LogU.debug$default(this.n, "onDestroyView() renderer: " + a0.i, null, false, 6, null);
        z z2 = this.getPlayerUseCase();
        G g0 = z2.d(z2.c.a()).i;
        if(g0 != null) {
            LogConstantsKt.infoOnlyDebugMode(((gc.l)g0).b, "releaseSurfaceView()");
            ((gc.l)g0).f.setSurfaceView(null);
        }
        CoroutineScope coroutineScope0 = this.o;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "View destroyed", null, 2, null);
        }
        VideoEndingView videoEndingView0 = this.i;
        if(videoEndingView0 != null) {
            videoEndingView0.c();
        }
        VideoEndingView videoEndingView1 = this.i;
        if(videoEndingView1 != null) {
            videoEndingView1.removeAllViews();
        }
        this.i = null;
        ControllerVideoListView controllerVideoListView0 = this.j;
        if(controllerVideoListView0 != null) {
            controllerVideoListView0.removeAllViews();
        }
        this.j = null;
        this.l = null;
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0 = this.h;
        if(videoSongListBottomSheetFragment0 != null) {
            videoSongListBottomSheetFragment0.dismiss();
        }
        RelativeLayout relativeLayout0 = this.k;
        if(relativeLayout0 != null) {
            relativeLayout0.removeAllViews();
        }
        this.k = null;
        VideoMoreBottomSheetFragment videoMoreBottomSheetFragment0 = this.g;
        if(videoMoreBottomSheetFragment0 != null) {
            videoMoreBottomSheetFragment0.dismiss();
        }
        this.g = null;
        this.getBinding().h.setPerformListener(null);
        this.setSeekBarView(null);
        this.d = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventVideo eventVideo0) {
        q.g(eventVideo0, "event");
        boolean z = this.isForeground();
        LogConstantsKt.debugOnlyDebugMode(this.n, "onEventMainThread() isForeground: " + z);
        if(eventVideo0.equals(Started.INSTANCE)) {
            this.n0(true);
            return;
        }
        if(!eventVideo0.equals(Completed.INSTANCE)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        this.onPlaybackComplete();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        return false;
    }

    public abstract void onPlaybackComplete();

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        VideoControllerHelper videoControllerHelper0 = this.m;
        if(videoControllerHelper0 != null) {
            videoControllerHelper0.c();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        LogU.info$default(this.n, "onStop()", null, false, 6, null);
        VideoControllerHelper videoControllerHelper0 = this.m;
        if(videoControllerHelper0 != null) {
            LogU.info$default(videoControllerHelper0.b, "onUiStop()", null, false, 6, null);
            CoroutineScope coroutineScope0 = videoControllerHelper0.i;
            if(coroutineScope0 != null) {
                CoroutineScopeKt.cancel$default(coroutineScope0, "cancelCollectControllerState() Cancel", null, 2, null);
            }
            videoControllerHelper0.i = null;
        }
        this.j0();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        VideoControllerHelper videoControllerHelper0 = new VideoControllerHelper(context0);
        videoControllerHelper0.k = this;
        this.m = videoControllerHelper0;
        boolean z = !A8.b.d();
        this.k0(this.getBinding().q);
        o2 o20 = this.getBinding();
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(-2, -1, 17);
        o20.q.setLayoutParams(frameLayout$LayoutParams0);
        this.getBinding().g.e.loadLayoutDescription(0x7F160016);  // xml:video_controller_state
        this.getBinding().g.e.setClipChildren(false);
        this.getBinding().g.m.setClipChildren(false);
        o2 o21 = this.getBinding();
        com.iloen.melon.player.video.j0 j00 = new com.iloen.melon.player.video.j0(this, 2);
        o21.o.setOnClickListener(j00);
        kotlin.jvm.internal.F f0 = new kotlin.jvm.internal.F();  // 初始化器: Ljava/lang/Object;-><init>()V
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        f0.f(d0).a(new we.n(null, f0) {
            public final kotlin.jvm.internal.F B;
            public int r;
            public final VideoPlayerFragmentBase w;

            {
                this.w = videoPlayerFragmentBase0;
                this.B = f0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3(this.w, continuation0, this.B);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        this.w.initController();
                        StateFlow stateFlow0 = this.w.getVideoViewModel().getControllerState();
                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1 videoPlayerFragmentBase$onViewCreated$3$10 = new we.n(null, this.B) {
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                            public static final class com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.WhenMappings {
                                public static final int[] $EnumSwitchMapping$0;

                                static {
                                    int[] arr_v = new int[ControllerStatus.values().length];
                                    try {
                                        arr_v[ControllerStatus.LIVE_NORMAL.ordinal()] = 1;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.LIVE_NORMAL_LAND.ordinal()] = 2;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.LIVE_FULL.ordinal()] = 3;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.LIVE_FULL_LAND.ordinal()] = 4;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.VOD_NORMAL.ordinal()] = 5;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.VOD_NORMAL_LAND.ordinal()] = 6;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.VOD_FULL.ordinal()] = 7;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.VOD_FULL_LAND.ordinal()] = 8;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.PREVIEW_NORMAL.ordinal()] = 9;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.PREVIEW_NORMAL_LAND.ordinal()] = 10;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.PREVIEW_FULL.ordinal()] = 11;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.PREVIEW_FULL_LAND.ordinal()] = 12;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                }
                            }

                            public final VideoPlayerFragmentBase B;
                            public Object r;
                            public final kotlin.jvm.internal.F w;

                            {
                                this.w = f0;
                                this.B = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1(this.B, continuation0, this.w);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(ControllerStatus controllerStatus0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1)this.create(controllerStatus0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((ControllerStatus)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ControllerStatus controllerStatus0 = (ControllerStatus)this.r;
                                n.D(object0);
                                kotlin.jvm.internal.F f0 = this.w;
                                switch(com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.WhenMappings.$EnumSwitchMapping$0[controllerStatus0.ordinal()]) {
                                    case 1: {
                                        f0.a = 0x7F0A078C;  // id:live_normal
                                        break;
                                    }
                                    case 2: {
                                        f0.a = 0x7F0A078D;  // id:live_normal_land
                                        break;
                                    }
                                    case 3: {
                                        f0.a = 0x7F0A0787;  // id:live_full
                                        break;
                                    }
                                    case 4: {
                                        f0.a = 0x7F0A0788;  // id:live_full_land
                                        break;
                                    }
                                    case 5: {
                                        f0.a = 0x7F0A0DDB;  // id:vod_normal
                                        break;
                                    }
                                    case 6: {
                                        f0.a = 0x7F0A0DDC;  // id:vod_normal_land
                                        break;
                                    }
                                    case 7: {
                                        f0.a = 0x7F0A0DD9;  // id:vod_full
                                        break;
                                    }
                                    case 8: {
                                        f0.a = 0x7F0A0DDA;  // id:vod_full_land
                                        break;
                                    }
                                    case 9: {
                                        f0.a = 0x7F0A0DDB;  // id:vod_normal
                                        break;
                                    }
                                    case 10: {
                                        f0.a = 0x7F0A0DDC;  // id:vod_normal_land
                                        break;
                                    }
                                    case 11: {
                                        f0.a = 0x7F0A0DD9;  // id:vod_full
                                        break;
                                    }
                                    case 12: {
                                        f0.a = 0x7F0A0DDA;  // id:vod_full_land
                                        break;
                                    }
                                    default: {
                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                    }
                                }
                                VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.B;
                                videoPlayerFragmentBase0.getBinding().g.e.setState(f0.a, 0, 0);
                                CoroutineScope coroutineScope0 = videoPlayerFragmentBase0.o;
                                if(coroutineScope0 != null) {
                                    CoroutineScopeKt.cancel$default(coroutineScope0, "Controller changed.", null, 2, null);
                                }
                                CoroutineScope coroutineScope1 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new we.n(null) {
                                    public int r;
                                    public final VideoPlayerFragmentBase w;

                                    {
                                        this.w = videoPlayerFragmentBase0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                D d0 = this.w.getViewLifecycleOwner();
                                                q.f(d0, "getViewLifecycleOwner(...)");
                                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1.1 videoPlayerFragmentBase$onViewCreated$3$1$1$1$10 = new we.n(null) {
                                                    public int r;
                                                    public final VideoPlayerFragmentBase w;

                                                    {
                                                        this.w = videoPlayerFragmentBase0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1.1(this.w, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.r) {
                                                            case 0: {
                                                                n.D(object0);
                                                                StateFlow stateFlow0 = this.w.getVideoViewModel().getVideoStatus();
                                                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1.1.1 videoPlayerFragmentBase$onViewCreated$3$1$1$1$1$10 = new we.n(null) {
                                                                    public Object r;
                                                                    public final VideoPlayerFragmentBase w;

                                                                    {
                                                                        this.w = videoPlayerFragmentBase0;
                                                                        super(2, continuation0);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1.1.1(this.w, continuation0);
                                                                        continuation1.r = object0;
                                                                        return continuation1;
                                                                    }

                                                                    public final Object invoke(VideoStatus videoStatus0, Continuation continuation0) {
                                                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.1.1.1)this.create(videoStatus0, continuation0)).invokeSuspend(ie.H.a);
                                                                    }

                                                                    @Override  // we.n
                                                                    public Object invoke(Object object0, Object object1) {
                                                                        return this.invoke(((VideoStatus)object0), ((Continuation)object1));
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Object invokeSuspend(Object object0) {
                                                                        VideoStatus videoStatus0 = (VideoStatus)this.r;
                                                                        n.D(object0);
                                                                        this.w.initVideoStatusUI(videoStatus0);
                                                                        return ie.H.a;
                                                                    }
                                                                };
                                                                this.r = 1;
                                                                return FlowKt.collectLatest(stateFlow0, videoPlayerFragmentBase$onViewCreated$3$1$1$1$1$10, this) == a0 ? a0 : ie.H.a;
                                                            }
                                                            case 1: {
                                                                n.D(object0);
                                                                return ie.H.a;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                    }
                                                };
                                                this.r = 1;
                                                return f0.j(d0, androidx.lifecycle.s.d, videoPlayerFragmentBase$onViewCreated$3$1$1$1$10, this) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }, 3, null);
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new we.n(null) {
                                    public int r;
                                    public final VideoPlayerFragmentBase w;

                                    {
                                        this.w = videoPlayerFragmentBase0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                D d0 = this.w.getViewLifecycleOwner();
                                                q.f(d0, "getViewLifecycleOwner(...)");
                                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2.1 videoPlayerFragmentBase$onViewCreated$3$1$1$2$10 = new we.n(null) {
                                                    public int r;
                                                    public final VideoPlayerFragmentBase w;

                                                    {
                                                        this.w = videoPlayerFragmentBase0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2.1(this.w, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.r) {
                                                            case 0: {
                                                                n.D(object0);
                                                                StateFlow stateFlow0 = this.w.getVideoViewModel().getControllerVisibleType();
                                                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2.1.1 videoPlayerFragmentBase$onViewCreated$3$1$1$2$1$10 = new we.n(null) {
                                                                    public Object r;
                                                                    public final VideoPlayerFragmentBase w;

                                                                    {
                                                                        this.w = videoPlayerFragmentBase0;
                                                                        super(2, continuation0);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2.1.1(this.w, continuation0);
                                                                        continuation1.r = object0;
                                                                        return continuation1;
                                                                    }

                                                                    public final Object invoke(ControllerVisibleStatus controllerVisibleStatus0, Continuation continuation0) {
                                                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.2.1.1)this.create(controllerVisibleStatus0, continuation0)).invokeSuspend(ie.H.a);
                                                                    }

                                                                    @Override  // we.n
                                                                    public Object invoke(Object object0, Object object1) {
                                                                        return this.invoke(((ControllerVisibleStatus)object0), ((Continuation)object1));
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Object invokeSuspend(Object object0) {
                                                                        ControllerVisibleStatus controllerVisibleStatus0 = (ControllerVisibleStatus)this.r;
                                                                        n.D(object0);
                                                                        VideoPlayerFragmentBase.access$showControllerView(this.w, controllerVisibleStatus0);
                                                                        return ie.H.a;
                                                                    }
                                                                };
                                                                this.r = 1;
                                                                return FlowKt.collectLatest(stateFlow0, videoPlayerFragmentBase$onViewCreated$3$1$1$2$1$10, this) == a0 ? a0 : ie.H.a;
                                                            }
                                                            case 1: {
                                                                n.D(object0);
                                                                return ie.H.a;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                    }
                                                };
                                                this.r = 1;
                                                return f0.j(d0, androidx.lifecycle.s.d, videoPlayerFragmentBase$onViewCreated$3$1$1$2$10, this) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }, 3, null);
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new we.n(null) {
                                    public int r;
                                    public final VideoPlayerFragmentBase w;

                                    {
                                        this.w = videoPlayerFragmentBase0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                D d0 = this.w.getViewLifecycleOwner();
                                                q.f(d0, "getViewLifecycleOwner(...)");
                                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3.1 videoPlayerFragmentBase$onViewCreated$3$1$1$3$10 = new we.n(null) {
                                                    public int r;
                                                    public final VideoPlayerFragmentBase w;

                                                    {
                                                        this.w = videoPlayerFragmentBase0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3.1(this.w, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.r) {
                                                            case 0: {
                                                                n.D(object0);
                                                                StateFlow stateFlow0 = ((t)this.w.getRemotePlayerManager()).g;
                                                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3.1.1 videoPlayerFragmentBase$onViewCreated$3$1$1$3$1$10 = new we.n(null) {
                                                                    public Object r;
                                                                    public final VideoPlayerFragmentBase w;

                                                                    {
                                                                        this.w = videoPlayerFragmentBase0;
                                                                        super(2, continuation0);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3.1.1(this.w, continuation0);
                                                                        continuation1.r = object0;
                                                                        return continuation1;
                                                                    }

                                                                    public final Object invoke(ic.a a0, Continuation continuation0) {
                                                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.3.1.1)this.create(a0, continuation0)).invokeSuspend(ie.H.a);
                                                                    }

                                                                    @Override  // we.n
                                                                    public Object invoke(Object object0, Object object1) {
                                                                        return this.invoke(((ic.a)object0), ((Continuation)object1));
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Object invokeSuspend(Object object0) {
                                                                        ic.a a0 = (ic.a)this.r;
                                                                        n.D(object0);
                                                                        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.w;
                                                                        LogConstantsKt.debugOnlyDebugMode(videoPlayerFragmentBase0.getLog(), "remoteConnectState: " + a0);
                                                                        if(a0 == ic.a.c) {
                                                                            videoPlayerFragmentBase0.getBinding().p.setVisibility(0);
                                                                            o2 o20 = videoPlayerFragmentBase0.getBinding();
                                                                            String s = videoPlayerFragmentBase0.getRemoteDeviceUseCase().a();
                                                                            o20.g.q.setText(s);
                                                                            return ie.H.a;
                                                                        }
                                                                        videoPlayerFragmentBase0.getBinding().p.setVisibility(8);
                                                                        videoPlayerFragmentBase0.getBinding().g.q.setText("");
                                                                        videoPlayerFragmentBase0.getBinding().h.d();
                                                                        return ie.H.a;
                                                                    }
                                                                };
                                                                this.r = 1;
                                                                return FlowKt.collectLatest(stateFlow0, videoPlayerFragmentBase$onViewCreated$3$1$1$3$1$10, this) == a0 ? a0 : ie.H.a;
                                                            }
                                                            case 1: {
                                                                n.D(object0);
                                                                return ie.H.a;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                    }
                                                };
                                                this.r = 1;
                                                return f0.j(d0, androidx.lifecycle.s.d, videoPlayerFragmentBase$onViewCreated$3$1$1$3$10, this) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }, 3, null);
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new we.n(null) {
                                    public int r;
                                    public final VideoPlayerFragmentBase w;

                                    {
                                        this.w = videoPlayerFragmentBase0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.4(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.4)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                StateFlow stateFlow0 = this.w.getVideoViewModel().getVdoRelateListRes();
                                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.4.1 videoPlayerFragmentBase$onViewCreated$3$1$1$4$10 = new we.n(null) {
                                                    public Object r;
                                                    public final VideoPlayerFragmentBase w;

                                                    {
                                                        this.w = videoPlayerFragmentBase0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.4.1(this.w, continuation0);
                                                        continuation1.r = object0;
                                                        return continuation1;
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((v8.i)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(v8.i i0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.3.1.1.4.1)this.create(i0, continuation0)).invokeSuspend(ie.H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        v8.i i0 = (v8.i)this.r;
                                                        n.D(object0);
                                                        MelonTvVdoRelateVdoListRes melonTvVdoRelateVdoListRes0 = (MelonTvVdoRelateVdoListRes)i0.c;
                                                        VideoPlayerFragmentBase.access$showVideoList(this.w, (melonTvVdoRelateVdoListRes0 == null ? null : melonTvVdoRelateVdoListRes0.response));
                                                        return ie.H.a;
                                                    }
                                                };
                                                this.r = 1;
                                                return FlowKt.collectLatest(stateFlow0, videoPlayerFragmentBase$onViewCreated$3$1$1$4$10, this) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }, 3, null);
                                videoPlayerFragmentBase0.o = coroutineScope1;
                                return ie.H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoPlayerFragmentBase$onViewCreated$3$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        });
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new we.n(null) {
            public int r;
            public final VideoPlayerFragmentBase w;

            {
                this.w = videoPlayerFragmentBase0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.4(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.4)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.4.1 videoPlayerFragmentBase$onViewCreated$4$10 = new we.n(null) {
                            public int r;
                            public final VideoPlayerFragmentBase w;

                            {
                                this.w = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.4.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        StateFlow stateFlow0 = this.w.getVideoViewModel().isOrientationPortrait();
                                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.4.1.1 videoPlayerFragmentBase$onViewCreated$4$1$10 = new FlowCollector() {
                                            public final VideoPlayerFragmentBase a;

                                            {
                                                this.a = videoPlayerFragmentBase0;
                                            }

                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                            }

                                            public final Object emit(boolean z, Continuation continuation0) {
                                                VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.a;
                                                BottomSheetBehavior bottomSheetBehavior0 = videoPlayerFragmentBase0.l;
                                                if(bottomSheetBehavior0 != null) {
                                                    bottomSheetBehavior0.L(VideoPlayerFragmentBase.access$getRecommendedListPeekHeight(videoPlayerFragmentBase0, z));
                                                }
                                                return ie.H.a;
                                            }
                                        };
                                        this.r = 1;
                                        if(stateFlow0.collect(videoPlayerFragmentBase$onViewCreated$4$1$10, this) == a0) {
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
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        };
                        this.r = 1;
                        return f0.j(d0, androidx.lifecycle.s.d, videoPlayerFragmentBase$onViewCreated$4$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
        this.getVideoViewModel().getVdoGetMvProgInfoRes().observe(this.getViewLifecycleOwner(), new VideoPlayerFragmentBase.sam.androidx_lifecycle_Observer.0(new i0(this, 3)));
        D d2 = this.getViewLifecycleOwner();
        q.f(d2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d2), Dispatchers.getMain(), null, new we.n(null) {
            public int r;
            public final VideoPlayerFragmentBase w;

            {
                this.w = videoPlayerFragmentBase0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
                            @Override  // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6.invokeSuspend..inlined.map.1.2 videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public final Object emit(Object object0, Continuation continuation0) {
                                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6.invokeSuspend..inlined.map.1.2.1 videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10;
                                        if(continuation0 instanceof com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6.invokeSuspend..inlined.map.1.2.1) {
                                            videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6.invokeSuspend..inlined.map.1.2.1)continuation0;
                                            int v = videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10.w;
                                            if((v & 0x80000000) == 0) {
                                                videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                            }
                                        }
                                        else {
                                            videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                        Object object1 = videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10.r;
                                        ne.a a0 = ne.a.a;
                                        switch(videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10.w) {
                                            case 0: {
                                                n.D(object1);
                                                m m0 = new m(new Integer(((fc.a)object0).a), ((fc.a)object0).i);
                                                videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                                return this.a.emit(m0, videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                n.D(object1);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                Object object0 = this.a.collect(videoPlayerFragmentBase$onViewCreated$6$invokeSuspend$$inlined$map$1$20, continuation0);
                                return object0 == ne.a.a ? object0 : ie.H.a;
                            }
                        });
                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6.2 videoPlayerFragmentBase$onViewCreated$6$20 = new we.n(null) {
                            public Object r;
                            public final VideoPlayerFragmentBase w;

                            {
                                this.w = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6.2(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(m m0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.6.2)this.create(m0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((m)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                m m0 = (m)this.r;
                                n.D(object0);
                                G g0 = (G)m0.b;
                                if(((Number)m0.a).intValue() == 3 && g0 != null) {
                                    this.w.getVideoViewModel().updateVideoSize(((gc.l)g0).f.getVideoWidth(), ((gc.l)g0).f.getVideoHeight());
                                    o2 o20 = this.w.getBinding();
                                    q.f(o20.q, "viewSurface");
                                    this.w.k0(o20.q);
                                    Float float0 = (Float)this.w.getVideoViewModel().getSlideOffset().getValue();
                                    boolean z = ((Boolean)this.w.getVideoViewModel().isOrientationPortrait().getValue()).booleanValue();
                                    VideoStatus videoStatus0 = (VideoStatus)this.w.getVideoViewModel().getVideoStatus().getValue();
                                    VideoPlayerFragmentBase.access$setScaleType(this.w, float0, z, videoStatus0);
                                    VideoOverlayView videoOverlayView0 = this.w.getBinding().h;
                                    Playable playable0 = this.w.getCurrentPlayable();
                                    videoOverlayView0.setCanSeeking(!(playable0 == null ? false : playable0.isOnAir()));
                                }
                                return ie.H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, videoPlayerFragmentBase$onViewCreated$6$20, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        D d3 = this.getViewLifecycleOwner();
        q.f(d3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d3), Dispatchers.getMain(), null, new we.n(null) {
            public int r;
            public final VideoPlayerFragmentBase w;

            {
                this.w = videoPlayerFragmentBase0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
                            @Override  // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7.invokeSuspend..inlined.map.1.2 videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public final Object emit(Object object0, Continuation continuation0) {
                                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7.invokeSuspend..inlined.map.1.2.1 videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10;
                                        if(continuation0 instanceof com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7.invokeSuspend..inlined.map.1.2.1) {
                                            videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7.invokeSuspend..inlined.map.1.2.1)continuation0;
                                            int v = videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10.w;
                                            if((v & 0x80000000) == 0) {
                                                videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                            }
                                        }
                                        else {
                                            videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                        Object object1 = videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10.r;
                                        ne.a a0 = ne.a.a;
                                        switch(videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10.w) {
                                            case 0: {
                                                n.D(object1);
                                                videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                                return this.a.emit(new Integer(((fc.a)object0).a), videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                n.D(object1);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                Object object0 = this.a.collect(videoPlayerFragmentBase$onViewCreated$7$invokeSuspend$$inlined$map$1$20, continuation0);
                                return object0 == ne.a.a ? object0 : ie.H.a;
                            }
                        });
                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7.2 videoPlayerFragmentBase$onViewCreated$7$20 = new we.n(null) {
                            public int r;
                            public final VideoPlayerFragmentBase w;

                            {
                                this.w = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7.2(this.w, continuation0);
                                continuation1.r = ((Number)object0).intValue();
                                return continuation1;
                            }

                            public final Object invoke(int v, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.7.2)this.create(v, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                int v = this.r;
                                n.D(object0);
                                VideoPlayerFragmentBase.access$handlePlaybackStateChanged(this.w, v);
                                return ie.H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, videoPlayerFragmentBase$onViewCreated$7$20, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        D d4 = this.getViewLifecycleOwner();
        q.f(d4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d4), Dispatchers.getMain(), null, new we.n(null) {
            public int r;
            public final VideoPlayerFragmentBase w;

            {
                this.w = videoPlayerFragmentBase0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.8(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.8)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        Flow flow0 = this.w.getPlayerUseCase().h();
                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.8.1 videoPlayerFragmentBase$onViewCreated$8$10 = new we.n(null) {
                            public boolean r;
                            public final VideoPlayerFragmentBase w;

                            {
                                this.w = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.8.1(this.w, continuation0);
                                continuation1.r = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.8.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.r;
                                n.D(object0);
                                VideoPlayerFragmentBase.access$handleIsPlaying(this.w, z);
                                return ie.H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, videoPlayerFragmentBase$onViewCreated$8$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        D d5 = this.getViewLifecycleOwner();
        q.f(d5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d5), Dispatchers.getMain(), null, new we.n(null) {
            public int r;
            public final VideoPlayerFragmentBase w;

            {
                this.w = videoPlayerFragmentBase0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9.1 videoPlayerFragmentBase$onViewCreated$9$10 = new we.n(null) {
                            public int r;
                            public final VideoPlayerFragmentBase w;

                            {
                                this.w = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        StateFlow stateFlow0 = this.w.getVideoViewModel().getCurrentVideoPlayable();
                                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9.1.1 videoPlayerFragmentBase$onViewCreated$9$1$10 = new we.n(null) {
                                            public Object r;
                                            public final VideoPlayerFragmentBase w;

                                            {
                                                this.w = videoPlayerFragmentBase0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9.1.1(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(Playable playable0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.9.1.1)this.create(playable0, continuation0)).invokeSuspend(ie.H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Playable)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                Playable playable0 = (Playable)this.r;
                                                n.D(object0);
                                                VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.w;
                                                VideoPlayerFragmentBase.access$updateThumbImageForGoogleCast(videoPlayerFragmentBase0, playable0);
                                                VideoMoreBottomSheetFragment videoMoreBottomSheetFragment0 = videoPlayerFragmentBase0.g;
                                                if(videoMoreBottomSheetFragment0 != null) {
                                                    videoMoreBottomSheetFragment0.dismiss();
                                                }
                                                videoPlayerFragmentBase0.l0(false);
                                                videoPlayerFragmentBase0.j0();
                                                return ie.H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, videoPlayerFragmentBase$onViewCreated$9$1$10, this) == a0 ? a0 : ie.H.a;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return ie.H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.r = 1;
                        return f0.j(d0, androidx.lifecycle.s.e, videoPlayerFragmentBase$onViewCreated$9$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        o2 o22 = this.getBinding();
        P0 p00 = new P0(new Q0() {
            public final VideoPlayerFragmentBase a;

            {
                this.a = videoPlayerFragmentBase0;
            }

            @Override  // com.iloen.melon.custom.Q0
            public void onChanged(R0 r00, R0 r01) {
                q.g(r00, "ratio");
                q.g(r01, "oldRatio");
                Playable playable0 = (Playable)this.a.getVideoViewModel().getCurrentVideoPlayable().getValue();
                VideoPlayerFragmentBase.access$updateThumbImageForGoogleCast(this.a, playable0);
            }
        }, 0);
        o22.p.addOnLayoutChangeListener(p00);
        D d6 = this.getViewLifecycleOwner();
        q.f(d6, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d6), null, null, new we.n(null) {
            public int r;
            public final VideoPlayerFragmentBase w;

            {
                this.w = videoPlayerFragmentBase0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.11(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.11)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.11.1 videoPlayerFragmentBase$onViewCreated$11$10 = new we.n(null) {
                            public int r;
                            public final VideoPlayerFragmentBase w;

                            {
                                this.w = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.11.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.11.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        StateFlow stateFlow0 = this.w.getVideoViewModel().getSurfaceViewScaleInfo();
                                        com.iloen.melon.player.video.VideoPlayerFragmentBase.onViewCreated.11.1.1 videoPlayerFragmentBase$onViewCreated$11$1$10 = new FlowCollector() {
                                            public final VideoPlayerFragmentBase a;

                                            {
                                                this.a = videoPlayerFragmentBase0;
                                            }

                                            public final Object emit(SurfaceViewScaleInfo videoViewModel$SurfaceViewScaleInfo0, Continuation continuation0) {
                                                VideoPlayerFragmentBase.access$setScaleType(this.a, new Float(videoViewModel$SurfaceViewScaleInfo0.getSlideOffset()), videoViewModel$SurfaceViewScaleInfo0.isOrientationPortrait(), videoViewModel$SurfaceViewScaleInfo0.getVideoStatus());
                                                return ie.H.a;
                                            }

                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((SurfaceViewScaleInfo)object0), continuation0);
                                            }
                                        };
                                        this.r = 1;
                                        if(stateFlow0.collect(videoPlayerFragmentBase$onViewCreated$11$1$10, this) == a0) {
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
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        };
                        this.r = 1;
                        return f0.j(d0, androidx.lifecycle.s.d, videoPlayerFragmentBase$onViewCreated$11$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    @Override  // pd.i
    public void onViewPostClick(@NotNull StateView stateView0) {
        q.g(stateView0, "view");
        this.n0(true);
        if(stateView0.getId() == 21) {
            LogU.info$default(this.n, "onViewPostClick() REMOTE_CONNECT", null, false, 6, null);
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            View view0 = (View)this.w.getValue();
            LottieAnimationView lottieAnimationView0 = view0 instanceof LottieAnimationView ? ((LottieAnimationView)view0) : null;
            com.melon.ui.popup.b.r(lottieAnimationView0, true);
            RemoteConnectPopup remoteConnectPopup0 = RemoteConnectPopup.Companion.newInstance();
            remoteConnectPopup0.setDismissListener(new vd.H(lottieAnimationView0));
            remoteConnectPopup0.show(l00, "VideoPlayerFragmentBase");
        }
    }

    @Override  // pd.i
    public boolean onViewPreClick(@NotNull StateView stateView0) {
        q.g(stateView0, "view");
        this.n0(false);
        switch(stateView0.getId()) {
            case 0: {
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this, 0x7F130D78, null, false, 6, null);  // string:tiara_click_copy_player_prev "이전"
                return false;
            }
            case 1: {
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this, 0x7F130D74, null, false, 6, null);  // string:tiara_click_copy_player_next "다음"
                return false;
            }
            case 2: 
            case 3: {
                if(this.getPlayerUseCase().n()) {
                    VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this, 0x7F130D76, null, false, 6, null);  // string:tiara_click_copy_player_pause "멈춤"
                    return false;
                }
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this, (stateView0.getCurrentBgId() == 0x7F08023B ? 0x7F130D7B : 0x7F130D77), TiaraLogType.PLAY_VIDEO, false, 4, null);  // drawable:btn_player_replay
                return false;
            }
            case 20: {
                boolean z = ((Ub.v)this.vodRepeatManager).a();
                this.sendTiaraLogPlayer(0x7F130D6C, TiaraLogType.AUTO_PLAY, !z);  // string:tiara_click_copy_player_autoplay "자동재생"
                Context context0 = Y.a(MelonAppBase.Companion);
                Params uaLogDummyFilterReq$Params0 = new Params();
                uaLogDummyFilterReq$Params0.filterType = z ? "SET01" : "SET02";
                O.a(new UaLogDummyFilterReq(context0, "videoPlayerAutoPlaySetup", uaLogDummyFilterReq$Params0));
                return false;
            }
            case 21: {
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this, 0x7F130D7A, null, false, 6, null);  // string:tiara_click_copy_player_remote "연결기기"
                return false;
            }
            default: {
                return false;
            }
        }
    }

    public abstract void performMoreClick();

    public final void sendTiaraLogPlayer(int v, @NotNull TiaraLogType videoPlayerFragmentBase$TiaraLogType0, boolean z) {
        q.g(videoPlayerFragmentBase$TiaraLogType0, "type");
        Playable playable0 = this.getCurrentPlayable();
        if(playable0 == null) {
            return;
        }
        e1.m.F(new com.iloen.melon.player.video.l0(this, videoPlayerFragmentBase$TiaraLogType0, v, playable0.isLiveContent(), playable0, z)).track();
    }

    public static void sendTiaraLogPlayer$default(VideoPlayerFragmentBase videoPlayerFragmentBase0, int v, TiaraLogType videoPlayerFragmentBase$TiaraLogType0, boolean z, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTiaraLogPlayer");
        }
        if((v1 & 2) != 0) {
            videoPlayerFragmentBase$TiaraLogType0 = TiaraLogType.DEFAULT;
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        videoPlayerFragmentBase0.sendTiaraLogPlayer(v, videoPlayerFragmentBase$TiaraLogType0, z);
    }

    public final void setAppVisibilityManager(@NotNull Pd.i i0) {
        q.g(i0, "<set-?>");
        this.appVisibilityManager = i0;
    }

    public abstract void setBindSeekBar();

    public final void setPlaybackManager(@NotNull Ub.q q0) {
        q.g(q0, "<set-?>");
        this.playbackManager = q0;
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setRemoteDeviceUseCase(@NotNull l l0) {
        q.g(l0, "<set-?>");
        this.remoteDeviceUseCase = l0;
    }

    public final void setRemotePlayerManager(@NotNull s s0) {
        q.g(s0, "<set-?>");
        this.remotePlayerManager = s0;
    }

    public void setSeekBarView(@Nullable VideoSeekBarAndDuration videoSeekBarAndDuration0) {
        this.f = videoSeekBarAndDuration0;
    }

    public final void setSongListBottomSheet(@Nullable VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0) {
        this.h = videoSongListBottomSheetFragment0;
    }

    public final void setSongListView(@Nullable RelativeLayout relativeLayout0) {
        this.k = relativeLayout0;
    }

    public final void setVideoListView(@Nullable ControllerVideoListView controllerVideoListView0) {
        this.j = controllerVideoListView0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return true;
    }

    @Nullable
    public final Object showEndingView(@NotNull Continuation continuation0) {
        com.iloen.melon.player.video.VideoPlayerFragmentBase.showEndingView.1 videoPlayerFragmentBase$showEndingView$10;
        if(continuation0 instanceof com.iloen.melon.player.video.VideoPlayerFragmentBase.showEndingView.1) {
            videoPlayerFragmentBase$showEndingView$10 = (com.iloen.melon.player.video.VideoPlayerFragmentBase.showEndingView.1)continuation0;
            int v = videoPlayerFragmentBase$showEndingView$10.B;
            if((v & 0x80000000) == 0) {
                videoPlayerFragmentBase$showEndingView$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.showEndingView(this);
                    }
                };
            }
            else {
                videoPlayerFragmentBase$showEndingView$10.B = v ^ 0x80000000;
            }
        }
        else {
            videoPlayerFragmentBase$showEndingView$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.showEndingView(this);
                }
            };
        }
        Enum enum0 = videoPlayerFragmentBase$showEndingView$10.r;
        ne.a a0 = ne.a.a;
        switch(videoPlayerFragmentBase$showEndingView$10.B) {
            case 0: {
                n.D(enum0);
                LogU.info$default(this.n, "showEndingView()", null, false, 6, null);
                videoPlayerFragmentBase$showEndingView$10.B = 1;
                enum0 = this.i0(videoPlayerFragmentBase$showEndingView$10);
                if(enum0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(enum0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        switch(WhenMappings.$EnumSwitchMapping$1[((EndingViewCase)enum0).ordinal()]) {
            case 1: {
                this.showEndingViewCase1();
                return ie.H.a;
            }
            case 2: {
                this.showEndingViewCase2();
                return ie.H.a;
            }
            case 3: {
                this.showEndingViewCase3();
                return ie.H.a;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public final void showEndingViewCase1() {
        LogU.info$default(this.n, "showEndingViewCase1()", null, false, 6, null);
        this.getVideoViewModel().setEndingViewShow1(true);
        this.getVideoViewModel().updateControllerAllVisible(Boolean.FALSE);
        if(this.i == null) {
            this.i = (VideoEndingView)this.getBinding().k.inflate();
        }
        w w0 = ((d3)this.playlistManager).k();
        if(w0 != null) {
            List list0 = w0.getState().c();
            int v = w0.p();
            VideoEndingView videoEndingView0 = this.i;
            if(videoEndingView0 != null) {
                videoEndingView0.setData(new x1(((PlayableData)p.n0(v, list0)), this.getVideoViewModel()));
            }
            VideoEndingView videoEndingView1 = this.i;
            if(videoEndingView1 != null) {
                videoEndingView1.setBtnClickListener(new y1() {
                    public final VideoPlayerFragmentBase a;

                    {
                        this.a = videoPlayerFragmentBase0;
                    }

                    @Override  // com.iloen.melon.custom.y1
                    public void onCancel() {
                        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.a;
                        if(videoPlayerFragmentBase0.getVideoViewModel().isFullScreen()) {
                            videoPlayerFragmentBase0.showEndingViewCase2();
                            return;
                        }
                        videoPlayerFragmentBase0.showEndingViewCase3();
                    }

                    @Override  // com.iloen.melon.custom.y1
                    public void onPlay(Playable playable0) {
                        if(playable0 == null) {
                            return;
                        }
                        D d0 = this.a.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(null) {
                            public int r;
                            public final VideoPlayerFragmentBase w;

                            {
                                this.w = videoPlayerFragmentBase0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerFragmentBase.showEndingViewCase1.1.onPlay.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerFragmentBase.showEndingViewCase1.1.onPlay.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        this.w.j0();
                                        z z0 = this.w.getPlayerUseCase();
                                        this.r = 1;
                                        return z0.q(this) == a0 ? a0 : ie.H.a;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return ie.H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        }, 3, null);
                    }
                });
            }
            VideoEndingView videoEndingView2 = this.i;
            if(videoEndingView2 != null) {
                videoEndingView2.setVisibility(0);
            }
        }
    }

    public final void showEndingViewCase2() {
        LogU.info$default(this.n, "showEndingViewCase2()", null, false, 6, null);
        this.j0();
        this.l0(true);
    }

    public final void showEndingViewCase3() {
        LogU.info$default(this.n, "showEndingViewCase3()", null, false, 6, null);
        this.j0();
        this.n0(false);
    }

    public final void showMoreBottomSheet() {
        VideoMoreBottomSheetFragment videoMoreBottomSheetFragment0 = this.g;
        if(videoMoreBottomSheetFragment0 != null) {
            videoMoreBottomSheetFragment0.dismiss();
        }
        ArrayList arrayList0 = this.getMoreBottomSheetItem();
        Playable playable0 = (Playable)this.getVideoViewModel().getCurrentVideoPlayable().getValue();
        if(playable0 != null) {
            Q q0 = this.getMoreBottomSheetType(playable0);
            VideoMoreBottomSheetFragment videoMoreBottomSheetFragment1 = new VideoMoreBottomSheetFragment(this.getVideoViewModel(), arrayList0, q0);
            videoMoreBottomSheetFragment1.setParentFragment(this);
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    videoMoreBottomSheetFragment1.show(l00, "VideoMoreBottomSheetFragment");
                    this.g = videoMoreBottomSheetFragment1;
                }
            }
        }
    }

    public final void updateLikeInfo(@NotNull View view0, @NotNull String s) {
        q.g(view0, "view");
        q.g(s, "songId");
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        this.updateLike(s, "N10001", !q.b(this.getLiveViewModel().isLiked().getValue(), Boolean.TRUE), this.getMenuId(), new OnJobFinishListener() {
            public final View a;
            public final VideoPlayerFragmentBase b;

            {
                View view0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = view0;
                this.b = videoPlayerFragmentBase0;
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                this.a.setEnabled(true);
                this.a.setClickable(true);
                if(TextUtils.isEmpty(s)) {
                    VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.b;
                    if(videoPlayerFragmentBase0.isFragmentValid()) {
                        videoPlayerFragmentBase0.getLiveViewModel().updateLiked(z);
                    }
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
                this.a.setEnabled(false);
                this.a.setClickable(false);
            }
        });
    }
}

