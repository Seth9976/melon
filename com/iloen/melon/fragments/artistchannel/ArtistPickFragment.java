package com.iloen.melon.fragments.artistchannel;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.NonSwipeableViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.fragment.app.u0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.viewpager.widget.j;
import com.android.volley.VolleyError;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.GestureTouchListener;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment.OnDismissListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.ArtistPickReq.Params;
import com.iloen.melon.net.v6x.request.ArtistPickReq;
import com.iloen.melon.net.v6x.response.ArtistPickRes.RESPONSE.ARTISTPICK;
import com.iloen.melon.net.v6x.response.ArtistPickRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistPickRes;
import com.iloen.melon.player.trackzero.SinglePlayer.SinglePlayerCallback;
import com.iloen.melon.player.trackzero.SinglePlayer;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import d8.d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u008A\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u0002:\u0004\u0099\u0001\u009A\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\nJ\u001D\u0010\u000F\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u000E2\u0006\u0010\r\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0011\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0014\u0010\nJ\u000F\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001CJ\u0019\u0010 \u001A\u00020\u001A2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0018H\u0016\u00A2\u0006\u0004\b \u0010\u001CJ-\u0010&\u001A\u0004\u0018\u00010%2\u0006\u0010\"\u001A\u00020!2\b\u0010$\u001A\u0004\u0018\u00010#2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0018H\u0016\u00A2\u0006\u0004\b&\u0010\'J!\u0010)\u001A\u00020\u001A2\u0006\u0010(\u001A\u00020%2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0018H\u0017\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\u001AH\u0017\u00A2\u0006\u0004\b+\u0010\u0004J\u000F\u0010,\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b,\u0010\u0004J\u000F\u0010-\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b-\u0010\u0004J\u000F\u0010.\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b.\u0010\u0004J-\u00104\u001A\u00020\b2\b\u00100\u001A\u0004\u0018\u00010/2\b\u00102\u001A\u0004\u0018\u0001012\b\u00103\u001A\u0004\u0018\u00010\u0015H\u0014\u00A2\u0006\u0004\b4\u00105J\u0017\u00108\u001A\u00020\u001A2\u0006\u00107\u001A\u000206H\u0016\u00A2\u0006\u0004\b8\u00109J\u000F\u0010:\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b:\u0010\u0004J\u000F\u0010;\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b;\u0010\u0004J\u000F\u0010<\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b<\u0010\u0004J\u000F\u0010=\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b=\u0010\u0004J\u000F\u0010>\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b>\u0010\u0004J\u000F\u0010?\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b?\u0010\u0004J\u0017\u0010A\u001A\u00020\u001A2\u0006\u0010@\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010C\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bC\u0010\u0004J\u000F\u0010D\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bD\u0010\u0004J\u000F\u0010E\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bE\u0010\u0004J\u000F\u0010F\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bF\u0010\u0004J\u000F\u0010G\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bG\u0010\u0004J\u0011\u0010I\u001A\u0004\u0018\u00010HH\u0002\u00A2\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001A\u00020\u001A2\u0006\u0010K\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bL\u0010BJ\u0017\u0010M\u001A\u00020\u001A2\u0006\u0010K\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bM\u0010BJ!\u0010Q\u001A\u00020\u001A2\b\u0010O\u001A\u0004\u0018\u00010N2\u0006\u0010P\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001A\u00020T2\u0006\u0010S\u001A\u00020#H\u0002\u00A2\u0006\u0004\bU\u0010VJ\u000F\u0010W\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bW\u0010\u0004J\u000F\u0010X\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bX\u0010\u0004J\u000F\u0010Y\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bY\u0010\u0004J\u0017\u0010[\u001A\u00020\u001A2\u0006\u0010Z\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b[\u0010BR\"\u0010]\u001A\u00020\\8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b]\u0010^\u001A\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0018\u0010c\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\be\u0010dR\u0018\u0010f\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bf\u0010dR\u0018\u0010h\u001A\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001A\u00020j8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001A\u00020j8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bm\u0010lR\u0016\u0010o\u001A\u00020n8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010r\u001A\u00020q8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010u\u001A\u00020t8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001A\u00020w8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001A\u00020w8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bz\u0010yR$\u0010}\u001A\u0012\u0012\u0004\u0012\u00020T0{j\b\u0012\u0004\u0012\u00020T`|8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b}\u0010~R\u0017\u0010\u0080\u0001\u001A\u00020\u007F8\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0082\u0001\u001A\u0002068\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001A\u0002068\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001A\u00030\u0085\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\"\u0010\u008A\u0001\u001A\r \u0089\u0001*\u0005\u0018\u00010\u0088\u00010\u0088\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008A\u0001\u0010\u008B\u0001R \u0010\u008D\u0001\u001A\t\u0012\u0002\b\u0003\u0018\u00010\u008C\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008E\u0001R\u001A\u0010\u0090\u0001\u001A\u00030\u008F\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001A\u0010\u0093\u0001\u001A\u00030\u0092\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001A\u00030\u0095\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0098\u0001\u001A\u00030\u0095\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001\u00A8\u0006\u009B\u0001"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "<init>", "()V", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "", "shouldShowMiniPlayer", "()Z", "isBottomTabFragment", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "isScreenLandscapeSupported", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "onDestroyView", "onDestroy", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "", "focusChange", "onAudioFocusChange", "(I)V", "updateNavigationBar", "reverseNavigationBar", "initVideoPlayer", "initAudioFocus", "requestAudioFocus", "abandonAudioFocus", "active", "setActiveWidgets", "(Z)V", "mute", "cancelMute", "startUpdateSeekBar", "updateProgress", "stopUpdateSeekBar", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes;", "fetchData", "()Lcom/iloen/melon/net/v6x/response/ArtistPickRes;", "userAction", "reqNextPage", "reqPrevPage", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE;", "response", "forceUpdate", "updateUi", "(Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE;Z)V", "parentView", "Landroid/widget/ProgressBar;", "addProgressBar", "(Landroid/view/ViewGroup;)Landroid/widget/ProgressBar;", "clearProgressBar", "sendTiaraLogMute", "sendTiaraLogDismiss", "isPrev", "sendTiaraLogMovePage", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "artistId", "Ljava/lang/String;", "viewType", "artistPickSeq", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickFragment$ArtistPickPagerAdapter;", "viewpagerAdapter", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickFragment$ArtistPickPagerAdapter;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "ctlMuteContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "ctlTop", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "videoPlayer", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "Landroid/support/v4/view/NonSwipeableViewPager;", "vpVideo", "Landroid/support/v4/view/NonSwipeableViewPager;", "Landroid/widget/LinearLayout;", "llProgressContainer", "Landroid/widget/LinearLayout;", "Landroid/widget/ImageView;", "ivStateMute", "Landroid/widget/ImageView;", "ivStateDeaf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "progressBarList", "Ljava/util/ArrayList;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isVisibleWidgets", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageCount", "I", "currentPageIndex", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "scheduleExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "scheduleFuture", "Ljava/util/concurrent/ScheduledFuture;", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioManager;", "Landroid/media/AudioFocusRequest;", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "Landroid/content/BroadcastReceiver;", "becomingNoisyAll", "Landroid/content/BroadcastReceiver;", "headSetReceiver", "Companion", "ArtistPickPagerAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistPickFragment extends Hilt_ArtistPickFragment implements AudioManager.OnAudioFocusChangeListener {
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\r\u001A\u00020\n¢\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\r\u001A\u00020\n¢\u0006\u0004\b\u001E\u0010\u001FJ\u0015\u0010\"\u001A\u00020\u00172\u0006\u0010!\u001A\u00020 ¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u001C\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u001A0&8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickFragment$ArtistPickPagerAdapter;", "Landroidx/fragment/app/u0;", "Landroidx/fragment/app/l0;", "fragmentManager", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE;", "artistPickRes", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$OnArtistPickItemListener;", "artistPickClickListener", "<init>", "(Landroidx/fragment/app/l0;Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE;Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$OnArtistPickItemListener;)V", "", "getCount", "()I", "position", "Landroidx/fragment/app/I;", "getItem", "(I)Landroidx/fragment/app/I;", "Landroid/view/ViewGroup;", "container", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "any", "Lie/H;", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment;", "getRegisteredFragment", "(I)Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment;", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE$ARTISTPICK;", "getArtistPickByPosition", "(I)Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE$ARTISTPICK;", "", "visible", "activateWidgets", "(Z)V", "Lcom/iloen/melon/net/v6x/response/ArtistPickRes$RESPONSE;", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickItemFragment$OnArtistPickItemListener;", "Landroid/util/SparseArray;", "registeredFragments", "Landroid/util/SparseArray;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArtistPickPagerAdapter extends u0 {
        public static final int $stable = 8;
        @NotNull
        private final OnArtistPickItemListener artistPickClickListener;
        @NotNull
        private final RESPONSE artistPickRes;
        @NotNull
        private SparseArray registeredFragments;

        public ArtistPickPagerAdapter(@NotNull l0 l00, @NotNull RESPONSE artistPickRes$RESPONSE0, @NotNull OnArtistPickItemListener artistPickItemFragment$OnArtistPickItemListener0) {
            q.g(l00, "fragmentManager");
            q.g(artistPickRes$RESPONSE0, "artistPickRes");
            q.g(artistPickItemFragment$OnArtistPickItemListener0, "artistPickClickListener");
            super(l00);
            this.artistPickRes = artistPickRes$RESPONSE0;
            this.artistPickClickListener = artistPickItemFragment$OnArtistPickItemListener0;
            this.registeredFragments = new SparseArray();
        }

        public final void activateWidgets(boolean z) {
            SparseArray sparseArray0 = this.registeredFragments;
            int v = sparseArray0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                sparseArray0.keyAt(v1);
                ((ArtistPickItemFragment)sparseArray0.valueAt(v1)).activateWidgets(z);
            }
        }

        @Override  // androidx.fragment.app.u0
        public void destroyItem(@NotNull ViewGroup viewGroup0, int v, @NotNull Object object0) {
            q.g(viewGroup0, "container");
            q.g(object0, "any");
            this.registeredFragments.remove(v);
            super.destroyItem(viewGroup0, v, object0);
        }

        @Nullable
        public final ARTISTPICK getArtistPickByPosition(int v) {
            return (ARTISTPICK)this.artistPickRes.artistPickList.get(v);
        }

        @Override  // androidx.viewpager.widget.a
        public int getCount() {
            return this.artistPickRes.artistPickList.size();
        }

        @Override  // androidx.fragment.app.u0
        @NotNull
        public I getItem(int v) {
            Object object0 = this.artistPickRes.artistPickList.get(v);
            q.f(object0, "get(...)");
            String s = this.artistPickRes.bbsChannelSeq;
            q.f(s, "bbsChannelSeq");
            return ArtistPickItemFragment.Companion.newInstance(((ARTISTPICK)object0), s, this.artistPickRes.section, this.artistPickRes.page, (this.artistPickRes.menuId == null ? "" : this.artistPickRes.menuId), this.artistPickClickListener);
        }

        @NotNull
        public final ArtistPickItemFragment getRegisteredFragment(int v) {
            Object object0 = this.registeredFragments.get(v);
            q.f(object0, "get(...)");
            return (ArtistPickItemFragment)object0;
        }

        @Override  // androidx.fragment.app.u0
        @NotNull
        public Object instantiateItem(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "container");
            ArtistPickItemFragment artistPickItemFragment0 = (ArtistPickItemFragment)super.instantiateItem(viewGroup0, v);
            this.registeredFragments.put(v, artistPickItemFragment0);
            return artistPickItemFragment0;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00052\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_ARTIST_ID", "ARG_VIEW_TYPE", "ARG_ARTIST_PICK_SEQ", "UPDATE_INITIAL_INTERNAL", "", "UPDATE_INTERNAL", "UNINITIALIZED_DURATION", "", "SINGLE", "ROLLING", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickFragment;", "artistId", "type", "artistPickSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistPickFragment newInstance(@NotNull String s, @Nullable String s1, @Nullable String s2) {
            q.g(s, "artistId");
            ArtistPickFragment artistPickFragment0 = new ArtistPickFragment();
            Bundle bundle0 = Y.c("argArtistId", s, "argArtistPickType", s1);
            bundle0.putString("argArtistPickSeq", s2);
            artistPickFragment0.setArguments(bundle0);
            return artistPickFragment0;
        }

        public static ArtistPickFragment newInstance$default(Companion artistPickFragment$Companion0, String s, String s1, String s2, int v, Object object0) {
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            return artistPickFragment$Companion0.newInstance(s, s1, s2);
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_ARTIST_ID = "argArtistId";
    @NotNull
    private static final String ARG_ARTIST_PICK_SEQ = "argArtistPickSeq";
    @NotNull
    private static final String ARG_VIEW_TYPE = "argArtistPickType";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String ROLLING = "rolling";
    @NotNull
    public static final String SINGLE = "single";
    @NotNull
    private static final String TAG = "ArtistPickFragment";
    private static final int UNINITIALIZED_DURATION = 1;
    private static final long UPDATE_INITIAL_INTERNAL = 0L;
    private static final long UPDATE_INTERNAL = 500L;
    @Nullable
    private String artistId;
    @Nullable
    private String artistPickSeq;
    private AudioFocusRequest audioFocusRequest;
    private AudioManager audioManager;
    @NotNull
    private final BroadcastReceiver becomingNoisyAll;
    private ConstraintLayout ctlMuteContainer;
    private ConstraintLayout ctlTop;
    private int currentPageIndex;
    @NotNull
    private final Handler handler;
    @NotNull
    private final BroadcastReceiver headSetReceiver;
    @NotNull
    private final AtomicBoolean isVisibleWidgets;
    private ImageView ivStateDeaf;
    private ImageView ivStateMute;
    private LinearLayout llProgressContainer;
    private int pageCount;
    @Inject
    public z playerUseCase;
    @NotNull
    private final ArrayList progressBarList;
    private final ScheduledExecutorService scheduleExecutor;
    @Nullable
    private ScheduledFuture scheduleFuture;
    private SinglePlayer videoPlayer;
    @Nullable
    private String viewType;
    @Nullable
    private ArtistPickPagerAdapter viewpagerAdapter;
    private NonSwipeableViewPager vpVideo;

    static {
        ArtistPickFragment.Companion = new Companion(null);
        ArtistPickFragment.$stable = 8;
    }

    public ArtistPickFragment() {
        this.progressBarList = new ArrayList();
        this.isVisibleWidgets = new AtomicBoolean(true);
        this.pageCount = -1;
        this.currentPageIndex = -1;
        this.handler = new Handler(Looper.getMainLooper());
        this.scheduleExecutor = Executors.newSingleThreadScheduledExecutor();
        this.becomingNoisyAll = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "intent");
                String s = intent0.getAction();
                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                Y.w("onReceive action : ", s, logU$Companion0, "ArtistPickFragment");
                if("android.media.AUDIO_BECOMING_NOISY".equals(s)) {
                    logU$Companion0.d("ArtistPickFragment", "becomingNoisyAll - ACTION_AUDIO_BECOMING_NOISY");
                    ArtistPickFragment.access$abandonAudioFocus(ArtistPickFragment.this);
                }
            }
        };
        this.headSetReceiver = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "intent");
                if(q.b(intent0.getAction(), "android.intent.action.HEADSET_PLUG")) {
                    switch(intent0.getIntExtra("state", -1)) {
                        case 0: {
                            LogU.Companion.d("ArtistPickFragment", "headSetReceiver - Headset unplugged");
                            ArtistPickFragment.access$abandonAudioFocus(ArtistPickFragment.this);
                            break;
                        }
                        case 1: {
                            LogU.Companion.d("ArtistPickFragment", "headSetReceiver - Headset plugged");
                        }
                    }
                }
            }
        };
    }

    private final void abandonAudioFocus() {
        AudioManager audioManager0 = this.audioManager;
        if(audioManager0 != null) {
            int v = audioManager0.abandonAudioFocus(this);
            Y.t("abandonAudioFocus() result : ", v, LogU.Companion, "ArtistPickFragment");
            if(1 == v) {
                this.mute();
            }
            return;
        }
        q.m("audioManager");
        throw null;
    }

    public static final void access$abandonAudioFocus(ArtistPickFragment artistPickFragment0) {
        artistPickFragment0.abandonAudioFocus();
    }

    private final ProgressBar addProgressBar(ViewGroup viewGroup0) {
        Context context0 = this.getContext();
        Object object0 = context0 == null ? null : context0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D0056, viewGroup0, false);  // layout:artist_pick_progress_item
        q.f(view0, "inflate(...)");
        viewGroup0.addView(view0, new LinearLayout.LayoutParams(0, -2, 1.0f));
        View view1 = view0.findViewById(0x7F0A0909);  // id:pb_video
        q.f(view1, "findViewById(...)");
        return (ProgressBar)view1;
    }

    private final void cancelMute() {
        ImageView imageView0 = this.ivStateMute;
        if(imageView0 != null) {
            imageView0.setVisibility(8);
            ImageView imageView1 = this.ivStateDeaf;
            if(imageView1 != null) {
                imageView1.setVisibility(0);
                SinglePlayer singlePlayer0 = this.videoPlayer;
                if(singlePlayer0 != null) {
                    singlePlayer0.setVolume(1.0f);
                    return;
                }
                q.m("videoPlayer");
                throw null;
            }
            q.m("ivStateDeaf");
            throw null;
        }
        q.m("ivStateMute");
        throw null;
    }

    private final void clearProgressBar() {
        this.progressBarList.clear();
        LinearLayout linearLayout0 = this.llProgressContainer;
        if(linearLayout0 != null) {
            linearLayout0.removeAllViews();
            return;
        }
        q.m("llProgressContainer");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    private final ArtistPickRes fetchData() {
        ArtistPickRes artistPickRes0;
        Closeable closeable0 = a.f(this.getContext(), this.getCacheKey());
        try {
            artistPickRes0 = (ArtistPickRes)a.d(((Cursor)closeable0), ArtistPickRes.class);
        }
        catch(Throwable throwable0) {
            d.l(closeable0, throwable0);
            throw throwable0;
        }
        if(artistPickRes0 == null) {
            artistPickRes0 = null;
        }
        d.l(closeable0, null);
        return artistPickRes0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.S0.buildUpon(), this.artistId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
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

    private final void initAudioFocus() {
        Object object0 = this.requireContext().getSystemService("audio");
        q.e(object0, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager)object0;
        AudioAttributes audioAttributes0 = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AudioFocusRequest audioFocusRequest0 = new AudioFocusRequest.Builder(1).setAudioAttributes(audioAttributes0).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build();
        q.f(audioFocusRequest0, "build(...)");
        this.audioFocusRequest = audioFocusRequest0;
    }

    private final void initVideoPlayer() {
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        SinglePlayer singlePlayer0 = new SinglePlayer(context0);
        singlePlayer0.setVolume(0.0f);
        singlePlayer0.setCallback(new SinglePlayerCallback() {
            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onCompletion() {
                singlePlayer0.reqNextPage(false);
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onError(String s) {
                q.g(s, "error");
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onPlaybackStateChanged(boolean z, int v) {
                if(v == 3 && z) {
                    this.$this_apply.start();
                }
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onPlaybackTransitions() {
            }
        });
        this.videoPlayer = singlePlayer0;
        singlePlayer0.getPlayer().addVideoListener(new VideoListener() {
            @Override  // com.google.android.exoplayer2.video.VideoListener
            public void onRenderedFirstFrame() {
                ArtistPickPagerAdapter artistPickFragment$ArtistPickPagerAdapter0 = ArtistPickFragment.this.viewpagerAdapter;
                if(artistPickFragment$ArtistPickPagerAdapter0 != null) {
                    ArtistPickItemFragment artistPickItemFragment0 = artistPickFragment$ArtistPickPagerAdapter0.getRegisteredFragment(ArtistPickFragment.this.currentPageIndex);
                    if(artistPickItemFragment0 != null && artistPickItemFragment0.getSinglePlayer() != null) {
                        artistPickItemFragment0.getStillView().setVisibility(8);
                    }
                }
                VideoListener.super.onRenderedFirstFrame();
            }
        });
        SinglePlayer singlePlayer1 = this.videoPlayer;
        if(singlePlayer1 != null) {
            singlePlayer1.getPlayer().addListener(new EventListener() {
                @Override  // com.google.android.exoplayer2.Player$EventListener
                public void onPlayerStateChanged(boolean z, int v) {
                    if(v == 3) {
                        ProgressBar progressBar0 = (ProgressBar)p.n0(ArtistPickFragment.this.currentPageIndex, ArtistPickFragment.this.progressBarList);
                        if(progressBar0 != null) {
                            ArtistPickFragment artistPickFragment0 = ArtistPickFragment.this;
                            if(progressBar0.getMax() <= 1) {
                                SinglePlayer singlePlayer0 = artistPickFragment0.videoPlayer;
                                if(singlePlayer0 != null) {
                                    progressBar0.setMax(((int)singlePlayer0.getDuration()));
                                    return;
                                }
                                q.m("videoPlayer");
                                throw null;
                            }
                        }
                    }
                }
            });
            return;
        }
        q.m("videoPlayer");
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

    private final void mute() {
        ImageView imageView0 = this.ivStateMute;
        if(imageView0 != null) {
            imageView0.setVisibility(0);
            ImageView imageView1 = this.ivStateDeaf;
            if(imageView1 != null) {
                imageView1.setVisibility(8);
                SinglePlayer singlePlayer0 = this.videoPlayer;
                if(singlePlayer0 != null) {
                    singlePlayer0.setVolume(0.0f);
                    return;
                }
                q.m("videoPlayer");
                throw null;
            }
            q.m("ivStateDeaf");
            throw null;
        }
        q.m("ivStateMute");
        throw null;
    }

    @NotNull
    public static final ArtistPickFragment newInstance(@NotNull String s, @Nullable String s1, @Nullable String s2) {
        return ArtistPickFragment.Companion.newInstance(s, s1, s2);
    }

    @Override  // android.media.AudioManager$OnAudioFocusChangeListener
    public void onAudioFocusChange(int v) {
        Y.t("onAudioFocusChange() focusChange : ", v, LogU.Companion, "ArtistPickFragment");
        if(v != -2 && v != -1) {
            return;
        }
        this.mute();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        this.initVideoPlayer();
        this.initAudioFocus();
        super.onCreate(bundle0);
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
        return layoutInflater0.inflate(0x7F0D0297, viewGroup0, false);  // layout:fragment_artist_pick
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        SinglePlayer singlePlayer0 = this.videoPlayer;
        if(singlePlayer0 != null) {
            singlePlayer0.release();
            super.onDestroy();
            return;
        }
        q.m("videoPlayer");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        this.abandonAudioFocus();
        super.onDestroyView();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        Params artistPickReq$Params0 = new Params();
        String s1 = this.artistId;
        artistPickReq$Params0.artistId = s1;
        artistPickReq$Params0.viewType = this.viewType;
        artistPickReq$Params0.artistPickSeq = this.artistPickSeq;
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("ArtistPickFragment", "onFetchStart() params.artistId:" + s1);
        Context context0 = this.getContext();
        if(a.e(300000L, this.getCacheKey(), context0)) {
            logU$Companion0.d("ArtistPickFragment", "onFetchStart() is isExpired");
            RequestBuilder.newInstance(new ArtistPickReq(this.getContext(), artistPickReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.artistchannel.I(this)).errorListener(new com.iloen.melon.fragments.artistchannel.I(this)).request();
            return true;
        }
        logU$Companion0.d("ArtistPickFragment", "onFetchStart() is not isExpired");
        ArtistPickRes artistPickRes0 = this.fetchData();
        this.updateUi((artistPickRes0 == null ? null : artistPickRes0.response), false);
        return false;
    }

    private static final void onFetchStart$lambda$10(ArtistPickFragment artistPickFragment0, VolleyError volleyError0) {
        artistPickFragment0.clearProgressBar();
        artistPickFragment0.currentPageIndex = -1;
        artistPickFragment0.viewpagerAdapter = null;
        NonSwipeableViewPager nonSwipeableViewPager0 = artistPickFragment0.vpVideo;
        if(nonSwipeableViewPager0 != null) {
            nonSwipeableViewPager0.setAdapter(null);
            ConstraintLayout constraintLayout0 = artistPickFragment0.ctlMuteContainer;
            if(constraintLayout0 != null) {
                constraintLayout0.setVisibility(8);
                artistPickFragment0.performFetchError(volleyError0);
                return;
            }
            q.m("ctlMuteContainer");
            throw null;
        }
        q.m("vpVideo");
        throw null;
    }

    private static final void onFetchStart$lambda$9(ArtistPickFragment artistPickFragment0, ArtistPickRes artistPickRes0) {
        if(!artistPickFragment0.prepareFetchComplete(artistPickRes0)) {
            LogU.Companion.e("ArtistPickFragment", "onFetchStart()");
            return;
        }
        artistPickFragment0.mMelonTiaraProperty = new s(artistPickRes0.response.section, artistPickRes0.response.page, artistPickRes0.getMenuId(), null);
        a.a(artistPickFragment0.getContext(), artistPickRes0, artistPickFragment0.getCacheKey());
        artistPickFragment0.updateUi(artistPickRes0.response, true);
        artistPickFragment0.performFetchCompleteOnlyViews();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.artistId = bundle0.getString("argArtistId");
        this.viewType = bundle0.getString("argArtistPickType");
        this.artistPickSeq = bundle0.getString("argArtistPickSeq");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argArtistPickType", this.viewType);
        bundle0.putString("argArtistPickSeq", this.artistPickSeq);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public void onStart() {
        super.onStart();
        this.updateNavigationBar();
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.media.AUDIO_BECOMING_NOISY");
        Context context0 = this.getContext();
        if(context0 != null) {
            context0.registerReceiver(this.becomingNoisyAll, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION", null);
        }
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("android.intent.action.HEADSET_PLUG");
        Context context1 = this.getContext();
        if(context1 != null) {
            context1.registerReceiver(this.headSetReceiver, intentFilter1, "com.iloen.melon.permission.SIG_PERMISSION", null);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        Context context0 = this.getContext();
        if(context0 != null) {
            context0.unregisterReceiver(this.becomingNoisyAll);
        }
        Context context1 = this.getContext();
        if(context1 != null) {
            context1.unregisterReceiver(this.headSetReceiver);
        }
        this.reverseNavigationBar();
        this.stopUpdateSeekBar();
        SinglePlayer singlePlayer0 = this.videoPlayer;
        if(singlePlayer0 != null) {
            singlePlayer0.stop(false);
            super.onStop();
            return;
        }
        q.m("videoPlayer");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        View view1 = view0.findViewById(0x7F0A0372);  // id:ctl_root
        q.f(view1, "findViewById(...)");
        View view2 = view0.findViewById(0x7F0A0DC7);  // id:view_left
        q.f(view2, "findViewById(...)");
        View view3 = view0.findViewById(0x7F0A0DBE);  // id:view_center
        q.f(view3, "findViewById(...)");
        View view4 = view0.findViewById(0x7F0A0DCB);  // id:view_right
        q.f(view4, "findViewById(...)");
        View view5 = view0.findViewById(0x7F0A0613);  // id:iv_close
        q.f(view5, "findViewById(...)");
        View view6 = view0.findViewById(0x7F0A0487);  // id:fake
        q.f(view6, "findViewById(...)");
        View view7 = view0.findViewById(0x7F0A0374);  // id:ctl_top
        q.f(view7, "findViewById(...)");
        this.ctlTop = (ConstraintLayout)view7;
        View view8 = view0.findViewById(0x7F0A0692);  // id:iv_state_deaf
        q.f(view8, "findViewById(...)");
        this.ivStateDeaf = (ImageView)view8;
        View view9 = view0.findViewById(0x7F0A0693);  // id:iv_state_mute
        q.f(view9, "findViewById(...)");
        this.ivStateMute = (ImageView)view9;
        View view10 = view0.findViewById(0x7F0A0DE5);  // id:vp_video
        q.f(view10, "findViewById(...)");
        this.vpVideo = (NonSwipeableViewPager)view10;
        View view11 = view0.findViewById(0x7F0A0798);  // id:ll_progress_container
        q.f(view11, "findViewById(...)");
        this.llProgressContainer = (LinearLayout)view11;
        View view12 = view0.findViewById(0x7F0A0370);  // id:ctl_mute_container
        q.f(view12, "findViewById(...)");
        this.ctlMuteContainer = (ConstraintLayout)view12;
        SinglePlayer singlePlayer0 = this.videoPlayer;
        if(singlePlayer0 != null) {
            boolean z = Float.compare(singlePlayer0.getPlayer().getVolume(), 0.0f) == 0;
            int v = 8;
            ImageView imageView0 = this.ivStateMute;
            if(imageView0 != null) {
                imageView0.setVisibility((z ? 0 : 8));
                ImageView imageView1 = this.ivStateDeaf;
                if(imageView1 != null) {
                    if(!z) {
                        v = 0;
                    }
                    imageView1.setVisibility(v);
                    NonSwipeableViewPager nonSwipeableViewPager0 = this.vpVideo;
                    if(nonSwipeableViewPager0 != null) {
                        nonSwipeableViewPager0.setPagingEnabled(false);
                        int v1 = ScreenUtils.getStatusBarHeight(this.getContext());
                        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view6.getLayoutParams();
                        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin += v1;
                        View view13 = view0.findViewById(0x7F0A08A5);  // id:network_error_layout
                        this.mEmptyView = view13;
                        view13.setOnClickListener(null);
                        view2.setOnClickListener(new J(this, 0));
                        view4.setOnClickListener(new J(this, 1));
                        ((ImageView)view5).setOnClickListener(new J(this, 2));
                        ViewUtils.setContentDescriptionWithButtonClassName(((ImageView)view5), this.getString(0x7F130AE8));  // string:talkback_close "닫기"
                        view3.setOnClickListener(new J(this, 3));
                        ImageView imageView2 = this.ivStateMute;
                        if(imageView2 != null) {
                            imageView2.setOnClickListener(new J(this, 4));
                            ImageView imageView3 = this.ivStateMute;
                            if(imageView3 != null) {
                                ViewUtils.setContentDescriptionWithButtonClassName(imageView3, this.getString(0x7F130C76));  // string:talkback_turn_on_sound "소리 켜기"
                                ImageView imageView4 = this.ivStateDeaf;
                                if(imageView4 != null) {
                                    imageView4.setOnClickListener(new J(this, 5));
                                    ImageView imageView5 = this.ivStateDeaf;
                                    if(imageView5 != null) {
                                        ViewUtils.setContentDescriptionWithButtonClassName(imageView5, this.getString(0x7F130C75));  // string:talkback_turn_off_sound "소리 끄기"
                                        ((ConstraintLayout)view1).setOnTouchListener(new GestureTouchListener(/*ERROR_MISSING_ARG_1/*) {
                                            @Override  // com.iloen.melon.custom.GestureTouchListener
                                            public void onSingleTouchUp() {
                                            }

                                            @Override  // com.iloen.melon.custom.GestureTouchListener
                                            public void onSwipeBottom() {
                                                this.getContext().performBackPress();
                                            }

                                            @Override  // com.iloen.melon.custom.GestureTouchListener
                                            public void onSwipeLeft() {
                                            }

                                            @Override  // com.iloen.melon.custom.GestureTouchListener
                                            public void onSwipeRight() {
                                            }

                                            @Override  // com.iloen.melon.custom.GestureTouchListener
                                            public void onSwipeTop() {
                                            }
                                        });
                                        return;
                                    }
                                    q.m("ivStateDeaf");
                                    throw null;
                                }
                                q.m("ivStateDeaf");
                                throw null;
                            }
                            q.m("ivStateMute");
                            throw null;
                        }
                        q.m("ivStateMute");
                        throw null;
                    }
                    q.m("vpVideo");
                    throw null;
                }
                q.m("ivStateDeaf");
                throw null;
            }
            q.m("ivStateMute");
            throw null;
        }
        q.m("videoPlayer");
        throw null;
    }

    private static final void onViewCreated$lambda$0(ArtistPickFragment artistPickFragment0, View view0) {
        artistPickFragment0.reqPrevPage(true);
    }

    private static final void onViewCreated$lambda$1(ArtistPickFragment artistPickFragment0, View view0) {
        artistPickFragment0.reqNextPage(true);
    }

    private static final void onViewCreated$lambda$2(ArtistPickFragment artistPickFragment0, View view0) {
        artistPickFragment0.sendTiaraLogDismiss();
        artistPickFragment0.performBackPress();
    }

    private static final void onViewCreated$lambda$3(ArtistPickFragment artistPickFragment0, View view0) {
        boolean z = artistPickFragment0.isVisibleWidgets.get();
        artistPickFragment0.setActiveWidgets(!z);
        artistPickFragment0.isVisibleWidgets.set(!z);
    }

    private static final void onViewCreated$lambda$4(ArtistPickFragment artistPickFragment0, View view0) {
        artistPickFragment0.sendTiaraLogMute();
        artistPickFragment0.requestAudioFocus();
    }

    private static final void onViewCreated$lambda$5(ArtistPickFragment artistPickFragment0, View view0) {
        artistPickFragment0.sendTiaraLogMute();
        artistPickFragment0.abandonAudioFocus();
    }

    private final void reqNextPage(boolean z) {
        if(this.currentPageIndex == this.pageCount - 1) {
            this.performBackPress();
            return;
        }
        if(z) {
            this.sendTiaraLogMovePage(false);
        }
        NonSwipeableViewPager nonSwipeableViewPager0 = this.vpVideo;
        if(nonSwipeableViewPager0 != null) {
            nonSwipeableViewPager0.setCurrentItem(this.currentPageIndex + 1, false);
            return;
        }
        q.m("vpVideo");
        throw null;
    }

    private final void reqPrevPage(boolean z) {
        if(this.currentPageIndex <= 0) {
            return;
        }
        if(z) {
            this.sendTiaraLogMovePage(true);
        }
        NonSwipeableViewPager nonSwipeableViewPager0 = this.vpVideo;
        if(nonSwipeableViewPager0 != null) {
            nonSwipeableViewPager0.setCurrentItem(this.currentPageIndex - 1, false);
            return;
        }
        q.m("vpVideo");
        throw null;
    }

    private final void requestAudioFocus() {
        this.getPlayerUseCase().s();
        AudioManager audioManager0 = this.audioManager;
        if(audioManager0 != null) {
            AudioFocusRequest audioFocusRequest0 = this.audioFocusRequest;
            if(audioFocusRequest0 != null) {
                int v = audioManager0.requestAudioFocus(audioFocusRequest0);
                Y.t("requestAudioFocus() result : ", v, LogU.Companion, "ArtistPickFragment");
                if(1 == v) {
                    this.cancelMute();
                }
                return;
            }
            q.m("audioFocusRequest");
            throw null;
        }
        q.m("audioManager");
        throw null;
    }

    private final void reverseNavigationBar() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
        if(musicBrowserActivity0 != null) {
            musicBrowserActivity0.setRootViewBackgroundColor(ColorUtils.getColor(musicBrowserActivity0, 0x7F06047D));  // color:status_bar_bg
            boolean z = ScreenUtils.isDarkMode(musicBrowserActivity0);
            Window window0 = musicBrowserActivity0.getWindow();
            q.f(window0, "getWindow(...)");
            ScreenUtils.setAppearanceLightNavigationBars(window0, !z);
        }
    }

    private final void sendTiaraLogDismiss() {
        ArtistPickPagerAdapter artistPickFragment$ArtistPickPagerAdapter0 = this.viewpagerAdapter;
        if(artistPickFragment$ArtistPickPagerAdapter0 != null) {
            ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = artistPickFragment$ArtistPickPagerAdapter0.getArtistPickByPosition(this.currentPageIndex);
            if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = "선택";
                String s = null;
                g0.b = this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.a;
                g0.c = this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.b;
                g0.y = "GNB";
                g0.F = "닫기";
                g0.C = String.valueOf(this.currentPageIndex);
                g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
                g0.p = "아티스트";
                g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
                s s1 = this.mMelonTiaraProperty;
                if(s1 != null) {
                    s = s1.c;
                }
                g0.I = s;
                g0.a().track();
            }
        }
    }

    private final void sendTiaraLogMovePage(boolean z) {
        ArtistPickPagerAdapter artistPickFragment$ArtistPickPagerAdapter0 = this.viewpagerAdapter;
        if(artistPickFragment$ArtistPickPagerAdapter0 != null) {
            ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = artistPickFragment$ArtistPickPagerAdapter0.getArtistPickByPosition(this.currentPageIndex);
            if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = "선택";
                String s = null;
                g0.b = this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.a;
                g0.c = this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.b;
                g0.d = ActionKind.ClickContent;
                g0.y = "GNB";
                g0.F = this.getResources().getString((z ? 0x7F130CE4 : 0x7F130CE3));  // string:tiara_artist_pick_copy_prev "이전"
                g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
                g0.p = "아티스트";
                g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
                s s1 = this.mMelonTiaraProperty;
                if(s1 != null) {
                    s = s1.c;
                }
                g0.I = s;
                g0.a().track();
            }
        }
    }

    private final void sendTiaraLogMute() {
        ArtistPickPagerAdapter artistPickFragment$ArtistPickPagerAdapter0 = this.viewpagerAdapter;
        if(artistPickFragment$ArtistPickPagerAdapter0 != null) {
            ARTISTPICK artistPickRes$RESPONSE$ARTISTPICK0 = artistPickFragment$ArtistPickPagerAdapter0.getArtistPickByPosition(this.currentPageIndex);
            if(artistPickRes$RESPONSE$ARTISTPICK0 != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = "선택";
                String s = null;
                g0.b = this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.a;
                g0.c = this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.b;
                g0.y = "GNB";
                g0.F = "음소거";
                g0.o = artistPickRes$RESPONSE$ARTISTPICK0.artistId;
                g0.p = "아티스트";
                g0.q = artistPickRes$RESPONSE$ARTISTPICK0.artistName;
                s s1 = this.mMelonTiaraProperty;
                if(s1 != null) {
                    s = s1.c;
                }
                g0.I = s;
                g0.a().track();
            }
        }
    }

    private final void setActiveWidgets(boolean z) {
        ConstraintLayout constraintLayout0 = this.ctlTop;
        if(constraintLayout0 != null) {
            constraintLayout0.setVisibility((z ? 0 : 8));
            ArtistPickPagerAdapter artistPickFragment$ArtistPickPagerAdapter0 = this.viewpagerAdapter;
            if(artistPickFragment$ArtistPickPagerAdapter0 != null) {
                artistPickFragment$ArtistPickPagerAdapter0.activateWidgets(z);
            }
            return;
        }
        q.m("ctlTop");
        throw null;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private final void startUpdateSeekBar() {
        this.stopUpdateSeekBar();
        if(!this.scheduleExecutor.isShutdown()) {
            K k0 = new K(this, 1);
            this.scheduleFuture = this.scheduleExecutor.scheduleAtFixedRate(k0, 0L, 500L, TimeUnit.MILLISECONDS);
        }
    }

    private static final void startUpdateSeekBar$lambda$15(ArtistPickFragment artistPickFragment0) {
        K k0 = new K(artistPickFragment0, 0);
        artistPickFragment0.handler.post(k0);
    }

    private static final void startUpdateSeekBar$lambda$15$lambda$14(ArtistPickFragment artistPickFragment0) {
        artistPickFragment0.updateProgress();
    }

    private final void stopUpdateSeekBar() {
        ScheduledFuture scheduledFuture0 = this.scheduleFuture;
        if(scheduledFuture0 != null) {
            scheduledFuture0.cancel(false);
        }
    }

    private final void updateNavigationBar() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
        if(musicBrowserActivity0 != null) {
            musicBrowserActivity0.setRootViewBackgroundColor(0xFF000000);
            Window window0 = musicBrowserActivity0.getWindow();
            q.f(window0, "getWindow(...)");
            ScreenUtils.setAppearanceLightNavigationBars(window0, false);
        }
    }

    private final void updateProgress() {
        Object object0 = this.progressBarList.get(this.currentPageIndex);
        q.f(object0, "get(...)");
        SinglePlayer singlePlayer0 = this.videoPlayer;
        if(singlePlayer0 != null) {
            ((ProgressBar)object0).setProgress(((int)singlePlayer0.getCurrentPosition()));
            return;
        }
        q.m("videoPlayer");
        throw null;
    }

    private final void updateUi(RESPONSE artistPickRes$RESPONSE0, boolean z) {
        ConstraintLayout constraintLayout0 = this.ctlMuteContainer;
        if(constraintLayout0 != null) {
            int v = -1;
            constraintLayout0.setVisibility(0);
            if(artistPickRes$RESPONSE0 != null && (artistPickRes$RESPONSE0.artistPickList != null && !artistPickRes$RESPONSE0.artistPickList.isEmpty())) {
                if(z || this.currentPageIndex == -1) {
                    ArrayList arrayList0 = artistPickRes$RESPONSE0.artistPickList;
                    q.f(arrayList0, "artistPickList");
                    int v1 = 0;
                    for(Object object0: arrayList0) {
                        if(q.b(((ARTISTPICK)object0).artistPickSeq, this.artistPickSeq)) {
                            v = v1;
                            break;
                        }
                        ++v1;
                    }
                    this.currentPageIndex = Math.max(v, 0);
                    this.pageCount = artistPickRes$RESPONSE0.artistPickList.size();
                    l0 l00 = this.getChildFragmentManager();
                    q.f(l00, "getChildFragmentManager(...)");
                    this.viewpagerAdapter = new ArtistPickPagerAdapter(l00, artistPickRes$RESPONSE0, new OnArtistPickItemListener() {
                        @Override  // com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment$OnArtistPickItemListener
                        public void onShareClickListener(Sharable sharable0) {
                            q.g(sharable0, "sharable");
                            com.iloen.melon.fragments.artistchannel.ArtistPickFragment.updateUi.1.2.onShareClickListener.1 artistPickFragment$updateUi$1$2$onShareClickListener$10 = new OnDismissListener() {
                                @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment$OnDismissListener
                                public void dismiss() {
                                    SinglePlayer singlePlayer0 = ArtistPickFragment.this.videoPlayer;
                                    if(singlePlayer0 != null) {
                                        singlePlayer0.start();
                                        return;
                                    }
                                    q.m("videoPlayer");
                                    throw null;
                                }
                            };
                            ArtistPickFragment.this.showSNSListPopup(sharable0, artistPickFragment$updateUi$1$2$onShareClickListener$10);
                        }
                    });
                }
                this.clearProgressBar();
                int v2 = artistPickRes$RESPONSE0.artistPickList.size();
                int v3 = 0;
                while(v3 < v2) {
                    LinearLayout linearLayout0 = this.llProgressContainer;
                    if(linearLayout0 != null) {
                        ProgressBar progressBar0 = this.addProgressBar(linearLayout0);
                        progressBar0.setMax(1);
                        if(this.currentPageIndex > v3) {
                            progressBar0.setProgress(progressBar0.getMax());
                        }
                        this.progressBarList.add(progressBar0);
                        ++v3;
                        continue;
                    }
                    q.m("llProgressContainer");
                    throw null;
                }
                NonSwipeableViewPager nonSwipeableViewPager0 = this.vpVideo;
                if(nonSwipeableViewPager0 != null) {
                    nonSwipeableViewPager0.setOffscreenPageLimit(3);
                    nonSwipeableViewPager0.setSaveFromParentEnabled(false);
                    nonSwipeableViewPager0.setAdapter(this.viewpagerAdapter);
                    nonSwipeableViewPager0.clearOnPageChangeListeners();
                    nonSwipeableViewPager0.addOnPageChangeListener(new j() {
                        @Override  // androidx.viewpager.widget.j
                        public void onPageScrollStateChanged(int v) {
                        }

                        @Override  // androidx.viewpager.widget.j
                        public void onPageScrolled(int v, float f, int v1) {
                            ArtistPickFragment.this.stopUpdateSeekBar();
                            int v2 = 0;
                            boolean z = ArtistPickFragment.this.currentPageIndex < v;
                            ArtistPickPagerAdapter artistPickFragment$ArtistPickPagerAdapter0 = ArtistPickFragment.this.viewpagerAdapter;
                            if(artistPickFragment$ArtistPickPagerAdapter0 != null) {
                                ArtistPickItemFragment artistPickItemFragment0 = artistPickFragment$ArtistPickPagerAdapter0.getRegisteredFragment(ArtistPickFragment.this.currentPageIndex);
                                if(artistPickItemFragment0 != null) {
                                    artistPickItemFragment0.getStillView().setVisibility(0);
                                    artistPickItemFragment0.setSinglePlayer(null);
                                }
                            }
                            ArtistPickPagerAdapter artistPickFragment$ArtistPickPagerAdapter1 = ArtistPickFragment.this.viewpagerAdapter;
                            if(artistPickFragment$ArtistPickPagerAdapter1 != null) {
                                ArtistPickItemFragment artistPickItemFragment1 = artistPickFragment$ArtistPickPagerAdapter1.getRegisteredFragment(v);
                                if(artistPickItemFragment1 != null) {
                                    ArtistPickFragment artistPickFragment0 = ArtistPickFragment.this;
                                    artistPickItemFragment1.getStillView().setVisibility(0);
                                    SinglePlayer singlePlayer0 = artistPickFragment0.videoPlayer;
                                    if(singlePlayer0 != null) {
                                        Uri uri0 = Uri.parse(artistPickItemFragment1.getMvUrl());
                                        q.f(uri0, "parse(...)");
                                        singlePlayer0.setDataSource(uri0, false);
                                        SinglePlayer singlePlayer1 = artistPickFragment0.videoPlayer;
                                        if(singlePlayer1 != null) {
                                            artistPickItemFragment1.setSinglePlayer(singlePlayer1);
                                            SinglePlayer singlePlayer2 = artistPickFragment0.videoPlayer;
                                            if(singlePlayer2 != null) {
                                                singlePlayer2.start();
                                                goto label_33;
                                            }
                                            q.m("videoPlayer");
                                            throw null;
                                        }
                                        q.m("videoPlayer");
                                        throw null;
                                    }
                                    q.m("videoPlayer");
                                    throw null;
                                }
                            }
                        label_33:
                            ProgressBar progressBar0 = (ProgressBar)ArtistPickFragment.this.progressBarList.get(ArtistPickFragment.this.currentPageIndex);
                            if(z) {
                                v2 = ((ProgressBar)ArtistPickFragment.this.progressBarList.get(ArtistPickFragment.this.currentPageIndex)).getMax();
                            }
                            progressBar0.setProgress(v2);
                            ArtistPickFragment.this.currentPageIndex = v;
                            ArtistPickFragment.this.startUpdateSeekBar();
                        }

                        @Override  // androidx.viewpager.widget.j
                        public void onPageSelected(int v) {
                        }
                    });
                    SinglePlayer singlePlayer0 = this.videoPlayer;
                    if(singlePlayer0 != null) {
                        Uri uri0 = Uri.parse(((ARTISTPICK)artistPickRes$RESPONSE0.artistPickList.get(this.currentPageIndex)).artistPickVideoUrl);
                        q.f(uri0, "parse(...)");
                        singlePlayer0.setDataSource(uri0, false);
                        NonSwipeableViewPager nonSwipeableViewPager1 = this.vpVideo;
                        if(nonSwipeableViewPager1 != null) {
                            nonSwipeableViewPager1.setCurrentItem(this.currentPageIndex, false);
                            return;
                        }
                        q.m("vpVideo");
                        throw null;
                    }
                    q.m("videoPlayer");
                    throw null;
                }
                q.m("vpVideo");
                throw null;
            }
            return;
        }
        q.m("ctlMuteContainer");
        throw null;
    }
}

