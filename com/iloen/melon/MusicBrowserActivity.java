package com.iloen.melon;

import Ac.G;
import Ac.Z1;
import Ac.l2;
import Cc.E;
import Cc.T;
import G.S;
import H0.e;
import R8.m;
import R8.r;
import R8.y;
import Tf.o;
import Ub.q;
import Ub.s;
import Ub.u;
import Ub.v;
import Vb.t0;
import Y8.h;
import Z8.k;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.PictureInPictureParams;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.support.v4.view.NonSwipeableViewPager;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.n;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import androidx.lifecycle.s0;
import c2.M;
import cd.V2;
import co.ab180.airbridge.Airbridge;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iloen.melon.constants.AppVersionInfo;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.d1;
import com.iloen.melon.custom.x0;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.eventbus.EventAlertDialog;
import com.iloen.melon.eventbus.EventAppFinish;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventConfirmDialog;
import com.iloen.melon.eventbus.EventDismissOnboarding;
import com.iloen.melon.eventbus.EventDownloadFailed;
import com.iloen.melon.eventbus.EventDrmAutoExtensionNotAllowed;
import com.iloen.melon.eventbus.EventLoginDialog.AppUpdate;
import com.iloen.melon.eventbus.EventLoginDialog.Event;
import com.iloen.melon.eventbus.EventLoginDialog;
import com.iloen.melon.eventbus.EventLoginError.KakaoSignUp;
import com.iloen.melon.eventbus.EventLoginError;
import com.iloen.melon.eventbus.EventLoginErrorDialog.PwdErrorExceed;
import com.iloen.melon.eventbus.EventLoginErrorDialog;
import com.iloen.melon.eventbus.EventLoginPromotionDialog;
import com.iloen.melon.eventbus.EventOptionDialog;
import com.iloen.melon.eventbus.EventPlaybackScheme;
import com.iloen.melon.eventbus.EventPlaylist.EventAddSongIds;
import com.iloen.melon.eventbus.EventPlaylist.EventDeleteSong;
import com.iloen.melon.eventbus.EventPlaylist;
import com.iloen.melon.eventbus.EventPopup.EventShowApplyMelonDjPopup;
import com.iloen.melon.eventbus.EventPopup.EventShowFolderSettingPopup;
import com.iloen.melon.eventbus.EventPopup.EventShowWifiSettingPopup;
import com.iloen.melon.eventbus.EventPremiumDevice.ConsentOfUserDownload;
import com.iloen.melon.eventbus.EventPremiumDevice.NoUseLteForDownload;
import com.iloen.melon.eventbus.EventPremiumDevice;
import com.iloen.melon.eventbus.EventSmartAlertDialog;
import com.iloen.melon.eventbus.EventSmartAppUpdateNeedDialog;
import com.iloen.melon.eventbus.EventSmartDialog;
import com.iloen.melon.eventbus.EventSmartRestoreFailedDialog;
import com.iloen.melon.eventbus.EventSmartUserSelectDialog;
import com.iloen.melon.eventbus.EventSplashDismiss;
import com.iloen.melon.eventbus.EventToastMessage;
import com.iloen.melon.eventbus.EventWebView.OpenUri;
import com.iloen.melon.eventbus.EventWebView.WebViewChromeSslCertIssueAlert;
import com.iloen.melon.eventbus.EventWebViewClose.CloseAllView;
import com.iloen.melon.fragments.DcfExtensionFailBrowserFragment;
import com.iloen.melon.fragments.DcfExtensionNeededBrowserFragment;
import com.iloen.melon.fragments.FragmentStack;
import com.iloen.melon.fragments.IFragmentContainer;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.local.LocalContentPagerFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;
import com.iloen.melon.fragments.mymusic.LockerFragment;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;
import com.iloen.melon.fragments.tabs.BottomTabPagerAdapter;
import com.iloen.melon.mediastore.MelonMediaProvider;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.DjApplyMainReq;
import com.iloen.melon.net.v4x.request.SearchIntentListReq.Params;
import com.iloen.melon.net.v4x.request.SearchIntentListReq;
import com.iloen.melon.net.v4x.response.NotificationLoginRes;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistPlayListSongReq;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddContentUri;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.player.video.FloatingFragment;
import com.iloen.melon.player.video.Pipable;
import com.iloen.melon.player.video.VideoMainFrameFragment;
import com.iloen.melon.player.video.VideoStatus;
import com.iloen.melon.popup.MainBottomPopup;
import com.iloen.melon.popup.MelonProgressPopup;
import com.iloen.melon.popup.MelonSplashPopup;
import com.iloen.melon.popup.MelonTextNCheckPopup;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.MelonUpgradePopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.task.TaskState;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.SchemeAction;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.billing.BillingUtils;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.datastore.BundleTrackingPreferenceSerializerKt;
import com.iloen.melon.utils.image.ImageCacheManager;
import com.iloen.melon.utils.log.AdIdManager;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.MelonDevReportKt;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.network.UrlUtil;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import com.iloen.melon.utils.shortcut.DynamicShortcutKt;
import com.iloen.melon.utils.shortcut.ShortcutManager;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.BadgeUtils;
import com.iloen.melon.utils.system.GooglePlayServiceUtils;
import com.iloen.melon.utils.system.NotificationHelper;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.system.VolumeUtils;
import com.iloen.melon.utils.ui.FloatingLyricHelper;
import com.iloen.melon.utils.ui.MusicBrowserPopupHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.LogBuilder;
import com.kakao.tiara.data.TrafficSource;
import com.melon.playback.melon.drm.c;
import com.melon.ui.c0;
import d5.w;
import ed.w0;
import gd.R7;
import gd.r5;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import jeb.synthetic.TWR;
import k8.B0;
import k8.F0;
import k8.I0;
import k8.K;
import k8.L0;
import k8.N;
import k8.O0;
import k8.O;
import k8.P0;
import k8.Q0;
import k8.Q;
import k8.R0;
import k8.S0;
import k8.U0;
import k8.U;
import k8.V0;
import k8.W0;
import k8.W;
import k8.X;
import k8.Y0;
import k8.Y;
import k8.Z0;
import k8.Z;
import k8.a0;
import k8.b0;
import k8.d0;
import k8.e0;
import k8.f1;
import k8.g0;
import k8.h0;
import k8.i0;
import k8.i1;
import k8.j0;
import k8.k0;
import k8.k1;
import k8.l1;
import k8.m0;
import k8.m1;
import k8.n0;
import k8.o0;
import k8.o1;
import k8.p0;
import k8.p1;
import k8.q0;
import k8.r0;
import k8.t;
import k8.v0;
import k8.y0;
import kc.a1;
import kc.b1;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.I;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import l2.i;
import m8.g;
import mb.b;
import ob.A;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.d;
import qd.V;
import r8.f;
import sd.P;
import vd.B;

@Metadata(d1 = {"\u0000\u00AE\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00CA\u00032\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u00CB\u0003\u008E\u0003\u0091\u0003B\u0007\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0014\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000E\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u000E\u0010\nJ\u0017\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00020\b\u00A2\u0006\u0004\b\u0013\u0010\u0005J\u0017\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001A\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u0018\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0005J\u000F\u0010\u001D\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0005J\u000F\u0010\u001E\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u0005J\u0017\u0010!\u001A\u00020\b2\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b#\u0010\u0005J\u000F\u0010$\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b$\u0010\u0005J\u0017\u0010&\u001A\u00020\b2\b\b\u0001\u0010%\u001A\u00020\u0018\u00A2\u0006\u0004\b&\u0010\u001BJ\u0015\u0010)\u001A\u00020\b2\u0006\u0010(\u001A\u00020\'\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010-\u001A\u00020\b2\u0006\u0010,\u001A\u00020+2\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b/\u0010\u0005J\u0017\u00101\u001A\u00020\b2\u0006\u00100\u001A\u00020+H\u0016\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b3\u0010\u0005J\u000F\u00104\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b4\u0010\u0005J\u000F\u00106\u001A\u000205H\u0016\u00A2\u0006\u0004\b6\u00107J\u0011\u00109\u001A\u0004\u0018\u000108H\u0016\u00A2\u0006\u0004\b9\u0010:J\u0011\u0010<\u001A\u0004\u0018\u00010;H\u0016\u00A2\u0006\u0004\b<\u0010=J\r\u0010>\u001A\u00020\b\u00A2\u0006\u0004\b>\u0010\u0005J\'\u0010B\u001A\u00020\b2\u0006\u0010?\u001A\u00020\u00182\u0006\u0010@\u001A\u00020+2\u0006\u0010A\u001A\u00020+H\u0016\u00A2\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001A\u00020\b2\u0006\u0010?\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\bD\u0010\u001BJ\u000F\u0010E\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\bE\u0010FJ\r\u0010G\u001A\u00020+\u00A2\u0006\u0004\bG\u0010HJ\u000F\u0010I\u001A\u00020\bH\u0016\u00A2\u0006\u0004\bI\u0010\u0005J\u0017\u0010L\u001A\u00020\b2\u0006\u0010K\u001A\u00020JH\u0016\u00A2\u0006\u0004\bL\u0010MJ\'\u0010Q\u001A\u00020\b2\u0006\u0010N\u001A\u00020+2\u0006\u0010O\u001A\u00020+2\u0006\u0010P\u001A\u00020+H\u0016\u00A2\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001A\u00020+2\u0006\u0010T\u001A\u00020SH\u0016\u00A2\u0006\u0004\bU\u0010VJ\u000F\u0010W\u001A\u00020+H\u0016\u00A2\u0006\u0004\bW\u0010HJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020XH\u0007\u00A2\u0006\u0004\bY\u0010ZJ\u0019\u0010Y\u001A\u00020\b2\b\u0010T\u001A\u0004\u0018\u00010[H\u0007\u00A2\u0006\u0004\bY\u0010\\J\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020]H\u0007\u00A2\u0006\u0004\bY\u0010^J\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020_H\u0007\u00A2\u0006\u0004\bY\u0010`J\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020aH\u0007\u00A2\u0006\u0004\bY\u0010bJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020cH\u0007\u00A2\u0006\u0004\bY\u0010dJ\u0019\u0010Y\u001A\u00020\b2\b\u0010T\u001A\u0004\u0018\u00010eH\u0007\u00A2\u0006\u0004\bY\u0010fJ\u0019\u0010Y\u001A\u00020\b2\b\u0010T\u001A\u0004\u0018\u00010gH\u0007\u00A2\u0006\u0004\bY\u0010hJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020iH\u0007\u00A2\u0006\u0004\bY\u0010jJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020kH\u0007\u00A2\u0006\u0004\bY\u0010lJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020mH\u0007\u00A2\u0006\u0004\bY\u0010nJ\u0019\u0010Y\u001A\u00020\b2\b\u0010T\u001A\u0004\u0018\u00010oH\u0007\u00A2\u0006\u0004\bY\u0010pJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020qH\u0007\u00A2\u0006\u0004\bY\u0010rJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020sH\u0007\u00A2\u0006\u0004\bY\u0010tJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020uH\u0007\u00A2\u0006\u0004\bY\u0010vJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020wH\u0007\u00A2\u0006\u0004\bY\u0010xJ\u0017\u0010Y\u001A\u00020\b2\u0006\u0010T\u001A\u00020yH\u0007\u00A2\u0006\u0004\bY\u0010zJ\u001F\u0010}\u001A\u00020+2\u0006\u0010{\u001A\u00020\u00182\u0006\u0010T\u001A\u00020|H\u0016\u00A2\u0006\u0004\b}\u0010~J\u0019\u0010\u0080\u0001\u001A\u00020\b2\u0006\u0010\u007F\u001A\u00020+H\u0016\u00A2\u0006\u0005\b\u0080\u0001\u00102J\u001B\u0010Y\u001A\u00020\b2\t\u0010T\u001A\u0005\u0018\u00010\u0081\u0001H\u0007\u00A2\u0006\u0005\bY\u0010\u0082\u0001J\u001B\u0010Y\u001A\u00020\b2\t\u0010T\u001A\u0005\u0018\u00010\u0083\u0001H\u0007\u00A2\u0006\u0005\bY\u0010\u0084\u0001J\u001B\u0010Y\u001A\u00020\b2\t\u0010T\u001A\u0005\u0018\u00010\u0085\u0001H\u0007\u00A2\u0006\u0005\bY\u0010\u0086\u0001J\u001B\u0010Y\u001A\u00020\b2\t\u0010T\u001A\u0005\u0018\u00010\u0087\u0001H\u0007\u00A2\u0006\u0005\bY\u0010\u0088\u0001J\u0019\u0010Y\u001A\u00020\b2\u0007\u0010T\u001A\u00030\u0089\u0001H\u0007\u00A2\u0006\u0005\bY\u0010\u008A\u0001J\u001B\u0010Y\u001A\u00020\b2\t\u0010T\u001A\u0005\u0018\u00010\u008B\u0001H\u0007\u00A2\u0006\u0005\bY\u0010\u008C\u0001J!\u0010\u008D\u0001\u001A\u00020+2\u0006\u0010{\u001A\u00020\u00182\u0006\u0010T\u001A\u00020|H\u0016\u00A2\u0006\u0005\b\u008D\u0001\u0010~J\u0011\u0010\u008E\u0001\u001A\u00020+H\u0016\u00A2\u0006\u0005\b\u008E\u0001\u0010HJ\u0011\u0010\u008F\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u008F\u0001\u0010\u0005J\u0011\u0010\u0090\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u0090\u0001\u0010\u0005J\u0011\u0010\u0091\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u0091\u0001\u0010\u0005J\u001C\u0010\u0094\u0001\u001A\u00020\b2\b\u0010\u0093\u0001\u001A\u00030\u0092\u0001H\u0002\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001C\u0010\u0096\u0001\u001A\u00020\b2\b\u0010\u0093\u0001\u001A\u00030\u0092\u0001H\u0002\u00A2\u0006\u0006\b\u0096\u0001\u0010\u0095\u0001J\u0011\u0010\u0097\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u0097\u0001\u0010\u0005J\u0011\u0010\u0098\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u0098\u0001\u0010\u0005J\u0011\u0010\u0099\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u0099\u0001\u0010\u0005J\u0011\u0010\u009A\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u009A\u0001\u0010\u0005J\u0011\u0010\u009B\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u009B\u0001\u0010\u0005J\u0011\u0010\u009C\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u009C\u0001\u0010\u0005J\u0011\u0010\u009D\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u009D\u0001\u0010\u0005J\u0011\u0010\u009E\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u009E\u0001\u0010\u0005J\u0011\u0010\u009F\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u009F\u0001\u0010\u0005J\u0011\u0010\u00A0\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0005\b\u00A0\u0001\u0010HJ\u0011\u0010\u00A1\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00A1\u0001\u0010\u0005J\u0011\u0010\u00A2\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0005\b\u00A2\u0001\u0010HJ\u0011\u0010\u00A3\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00A3\u0001\u0010\u0005J\u0011\u0010\u00A4\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00A4\u0001\u0010\u0005J\u0011\u0010\u00A5\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00A5\u0001\u0010\u0005J\u001C\u0010\u00A7\u0001\u001A\u00020\b2\t\b\u0002\u0010\u00A6\u0001\u001A\u00020\u0018H\u0002\u00A2\u0006\u0005\b\u00A7\u0001\u0010\u001BJ\u001A\u0010\u00A9\u0001\u001A\u00020\b2\u0007\u0010\u00A8\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0005\b\u00A9\u0001\u00102J\u0019\u0010\u00AA\u0001\u001A\u00020\b2\u0006\u0010?\u001A\u00020\u0018H\u0002\u00A2\u0006\u0005\b\u00AA\u0001\u0010\u001BJ\u0011\u0010\u00AB\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00AB\u0001\u0010\u0005J\u0019\u0010\u00AC\u0001\u001A\u00020\b2\u0006\u0010?\u001A\u00020\u0018H\u0002\u00A2\u0006\u0005\b\u00AC\u0001\u0010\u001BJ\u0018\u0010B\u001A\u00020\b2\u0007\u0010\u00AD\u0001\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bB\u0010\u001BJ\u0019\u0010\u00AE\u0001\u001A\u00020\b2\u0006\u0010?\u001A\u00020\u0018H\u0002\u00A2\u0006\u0005\b\u00AE\u0001\u0010\u001BJ\u0011\u0010\u00AF\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00AF\u0001\u0010\u0005J\u0011\u0010\u00B0\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00B0\u0001\u0010\u0005J\u001B\u0010\u00B1\u0001\u001A\u00020\b2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0002\u00A2\u0006\u0005\b\u00B1\u0001\u0010\u0012J\u0011\u0010\u00B2\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00B2\u0001\u0010\u0005J\u0011\u0010\u00B3\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00B3\u0001\u0010\u0005J\u0011\u0010\u00B4\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00B4\u0001\u0010\u0005J\u0011\u0010\u00B5\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00B5\u0001\u0010\u0005J\u001C\u0010\u00B8\u0001\u001A\u00020\b2\b\u0010\u00B7\u0001\u001A\u00030\u00B6\u0001H\u0002\u00A2\u0006\u0006\b\u00B8\u0001\u0010\u00B9\u0001J\u001C\u0010\u00BA\u0001\u001A\u00020\b2\b\u0010\u00B7\u0001\u001A\u00030\u00B6\u0001H\u0002\u00A2\u0006\u0006\b\u00BA\u0001\u0010\u00B9\u0001J\u0011\u0010\u00BB\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00BB\u0001\u0010\u0005J\u0011\u0010\u00BC\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00BC\u0001\u0010\u0005J\u001A\u0010\u00BE\u0001\u001A\u00020\b2\u0007\u0010\u00BD\u0001\u001A\u00020\u0018H\u0002\u00A2\u0006\u0005\b\u00BE\u0001\u0010\u001BJ\u001E\u0010\u00C1\u0001\u001A\u00020\b2\n\u0010\u00C0\u0001\u001A\u0005\u0018\u00010\u00BF\u0001H\u0002\u00A2\u0006\u0006\b\u00C1\u0001\u0010\u00C2\u0001J\u001B\u0010\u00C3\u0001\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0082@\u00A2\u0006\u0006\b\u00C3\u0001\u0010\u00C4\u0001J\u001D\u0010\u00C7\u0001\u001A\u00030\u00C5\u00012\b\u0010\u00C6\u0001\u001A\u00030\u00C5\u0001H\u0002\u00A2\u0006\u0006\b\u00C7\u0001\u0010\u00C8\u0001J\u0011\u0010\u00C9\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00C9\u0001\u0010\u0005J\u001C\u0010\u00CC\u0001\u001A\u00020\b2\b\u0010\u00CB\u0001\u001A\u00030\u00CA\u0001H\u0002\u00A2\u0006\u0006\b\u00CC\u0001\u0010\u00CD\u0001J\u0011\u0010\u00CE\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00CE\u0001\u0010\u0005J\u0011\u0010\u00CF\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00CF\u0001\u0010\u0005J&\u0010\u00D2\u0001\u001A\u00020\b2\u0007\u0010\u00D0\u0001\u001A\u00020+2\t\b\u0002\u0010\u00D1\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0006\b\u00D2\u0001\u0010\u00D3\u0001J\u001A\u0010\u00D4\u0001\u001A\u00020\b2\u0007\u0010\u00D0\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0005\b\u00D4\u0001\u00102J\u001C\u0010\u00D6\u0001\u001A\u00020\b2\b\u0010\u00C6\u0001\u001A\u00030\u00D5\u0001H\u0002\u00A2\u0006\u0006\b\u00D6\u0001\u0010\u00D7\u0001J\u0011\u0010\u00D8\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00D8\u0001\u0010\u0005J\u0011\u0010\u00D9\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00D9\u0001\u0010\u0005J\u0011\u0010\u00DA\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00DA\u0001\u0010\u0005J\u0011\u0010\u00DB\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00DB\u0001\u0010\u0005J\u0011\u0010\u00DC\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00DC\u0001\u0010\u0005J#\u0010\u00E0\u0001\u001A\u00020\b2\u000F\u0010\u00DF\u0001\u001A\n\u0012\u0005\u0012\u00030\u00DE\u00010\u00DD\u0001H\u0002\u00A2\u0006\u0006\b\u00E0\u0001\u0010\u00E1\u0001J\u001C\u0010\u00E4\u0001\u001A\u00020\b2\b\u0010\u00E3\u0001\u001A\u00030\u00E2\u0001H\u0002\u00A2\u0006\u0006\b\u00E4\u0001\u0010\u00E5\u0001J\u001C\u0010\u00E6\u0001\u001A\u00020\b2\b\u0010\u00E3\u0001\u001A\u00030\u00E2\u0001H\u0002\u00A2\u0006\u0006\b\u00E6\u0001\u0010\u00E5\u0001J\u001B\u0010\u00E8\u0001\u001A\u00020\b2\u0007\u0010T\u001A\u00030\u00E7\u0001H\u0002\u00A2\u0006\u0006\b\u00E8\u0001\u0010\u00E9\u0001J\u001B\u0010\u00EB\u0001\u001A\u00020\b2\u0007\u0010T\u001A\u00030\u00EA\u0001H\u0002\u00A2\u0006\u0006\b\u00EB\u0001\u0010\u00EC\u0001J>\u0010\u00F1\u0001\u001A\u00020\b2\u000F\u0010\u00ED\u0001\u001A\n\u0012\u0005\u0012\u00030\u00DE\u00010\u00DD\u00012\u000F\u0010\u00EF\u0001\u001A\n\u0012\u0005\u0012\u00030\u00EE\u00010\u00DD\u00012\b\u0010\u00F0\u0001\u001A\u00030\u00EE\u0001H\u0002\u00A2\u0006\u0006\b\u00F1\u0001\u0010\u00F2\u0001J\u0011\u0010\u00F3\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00F3\u0001\u0010\u0005J\u0011\u0010\u00F4\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00F4\u0001\u0010\u0005J\u0011\u0010\u00F5\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00F5\u0001\u0010\u0005J\u0011\u0010\u00F6\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00F6\u0001\u0010\u0005J\u0011\u0010\u00F7\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00F7\u0001\u0010\u0005J\u001C\u0010\u00F8\u0001\u001A\u00020+2\b\u0010\u00C6\u0001\u001A\u00030\u00C5\u0001H\u0002\u00A2\u0006\u0006\b\u00F8\u0001\u0010\u00F9\u0001J\u001C\u0010\u00FB\u0001\u001A\u00020\b2\t\b\u0002\u0010\u00FA\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0005\b\u00FB\u0001\u00102J\u0011\u0010\u00FC\u0001\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u00FC\u0001\u0010\u0005J1\u0010\u0081\u0002\u001A\u00020\b2\b\u0010\u00FD\u0001\u001A\u00030\u00EE\u00012\b\u0010\u00FF\u0001\u001A\u00030\u00FE\u00012\b\u0010\u0080\u0002\u001A\u00030\u00FE\u0001H\u0082@\u00A2\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002J\u0011\u0010\u0083\u0002\u001A\u00020\bH\u0002\u00A2\u0006\u0005\b\u0083\u0002\u0010\u0005J%\u0010\u0085\u0002\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000F2\t\b\u0002\u0010\u0084\u0002\u001A\u00020+H\u0002\u00A2\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002J(\u0010\u008A\u0002\u001A\u00020\b2\n\u0010\u0088\u0002\u001A\u0005\u0018\u00010\u0087\u00022\b\u0010\u0089\u0002\u001A\u00030\u00EE\u0001H\u0002\u00A2\u0006\u0006\b\u008A\u0002\u0010\u008B\u0002J\u001C\u0010\u008D\u0002\u001A\u00020\b2\b\u0010\u008C\u0002\u001A\u00030\u00EE\u0001H\u0002\u00A2\u0006\u0006\b\u008D\u0002\u0010\u008E\u0002R\u0018\u0010\u0090\u0002\u001A\u00030\u008F\u00028\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R*\u0010\u0093\u0002\u001A\u00030\u0092\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u0093\u0002\u0010\u0094\u0002\u001A\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R*\u0010\u009A\u0002\u001A\u00030\u0099\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u009A\u0002\u0010\u009B\u0002\u001A\u0006\b\u009C\u0002\u0010\u009D\u0002\"\u0006\b\u009E\u0002\u0010\u009F\u0002R*\u0010\u00A1\u0002\u001A\u00030\u00A0\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00A1\u0002\u0010\u00A2\u0002\u001A\u0006\b\u00A3\u0002\u0010\u00A4\u0002\"\u0006\b\u00A5\u0002\u0010\u00A6\u0002R*\u0010\u00A8\u0002\u001A\u00030\u00A7\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00A8\u0002\u0010\u00A9\u0002\u001A\u0006\b\u00AA\u0002\u0010\u00AB\u0002\"\u0006\b\u00AC\u0002\u0010\u00AD\u0002R*\u0010\u00AF\u0002\u001A\u00030\u00AE\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00AF\u0002\u0010\u00B0\u0002\u001A\u0006\b\u00B1\u0002\u0010\u00B2\u0002\"\u0006\b\u00B3\u0002\u0010\u00B4\u0002R*\u0010\u00B6\u0002\u001A\u00030\u00B5\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00B6\u0002\u0010\u00B7\u0002\u001A\u0006\b\u00B8\u0002\u0010\u00B9\u0002\"\u0006\b\u00BA\u0002\u0010\u00BB\u0002R*\u0010\u00BD\u0002\u001A\u00030\u00BC\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00BD\u0002\u0010\u00BE\u0002\u001A\u0006\b\u00BF\u0002\u0010\u00C0\u0002\"\u0006\b\u00C1\u0002\u0010\u00C2\u0002R*\u0010\u00C4\u0002\u001A\u00030\u00C3\u00028\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00C4\u0002\u0010\u00C5\u0002\u001A\u0006\b\u00C6\u0002\u0010\u00C7\u0002\"\u0006\b\u00C8\u0002\u0010\u00C9\u0002R!\u0010\u00CF\u0002\u001A\u00030\u00CA\u00028BX\u0082\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u00CB\u0002\u0010\u00CC\u0002\u001A\u0006\b\u00CD\u0002\u0010\u00CE\u0002R\u001B\u0010\u00D0\u0002\u001A\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D0\u0002\u0010\u00D1\u0002R\u001B\u0010\u00D2\u0002\u001A\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D2\u0002\u0010\u00D1\u0002R\u001B\u0010\u00D3\u0002\u001A\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D3\u0002\u0010\u00D1\u0002R\u001C\u0010\u00D5\u0002\u001A\u0005\u0018\u00010\u00D4\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D5\u0002\u0010\u00D6\u0002R\u001C\u0010\u00D8\u0002\u001A\u0005\u0018\u00010\u00D7\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D8\u0002\u0010\u00D9\u0002R\u001C\u0010\u00DB\u0002\u001A\u0005\u0018\u00010\u00DA\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00DB\u0002\u0010\u00DC\u0002R\u001B\u0010\u00DD\u0002\u001A\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00DD\u0002\u0010\u00D1\u0002R\u001C\u0010\u00DE\u0002\u001A\u0005\u0018\u00010\u00D5\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00DE\u0002\u0010\u00DF\u0002R\u001C\u0010\u00E1\u0002\u001A\u0005\u0018\u00010\u00E0\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00E1\u0002\u0010\u00E2\u0002R\u001C\u0010\u00E4\u0002\u001A\u0005\u0018\u00010\u00E3\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00E4\u0002\u0010\u00E5\u0002R\u001C\u0010\u00E7\u0002\u001A\u0005\u0018\u00010\u00E6\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00E7\u0002\u0010\u00E8\u0002R\u001C\u0010\u00E9\u0002\u001A\u0005\u0018\u00010\u00E6\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00E9\u0002\u0010\u00E8\u0002R\'\u0010\u00EA\u0002\u001A\u00020+8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0016\n\u0006\b\u00EA\u0002\u0010\u00EB\u0002\u001A\u0005\b\u00EC\u0002\u0010H\"\u0005\b\u00ED\u0002\u00102R\u001C\u0010\u00EF\u0002\u001A\u0005\u0018\u00010\u00EE\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00EF\u0002\u0010\u00F0\u0002R0\u0010\u00F3\u0002\u001A\u0005\u0018\u00010\u00F1\u00022\n\u0010\u00F2\u0002\u001A\u0005\u0018\u00010\u00F1\u00028\u0006@BX\u0086\u000E\u00A2\u0006\u0010\n\u0006\b\u00F3\u0002\u0010\u00F4\u0002\u001A\u0006\b\u00F5\u0002\u0010\u00F6\u0002R\u0018\u0010\u00F8\u0002\u001A\u00030\u00F7\u00028\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00F8\u0002\u0010\u00F9\u0002R\u001A\u0010\u00FB\u0002\u001A\u00030\u00FA\u00028\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u00FB\u0002\u0010\u00FC\u0002R\u001B\u0010\u00FD\u0002\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00FD\u0002\u0010\u00FE\u0002R,\u0010\u0080\u0003\u001A\u0005\u0018\u00010\u00FF\u00028\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u0080\u0003\u0010\u0081\u0003\u001A\u0006\b\u0082\u0003\u0010\u0083\u0003\"\u0006\b\u0084\u0003\u0010\u0085\u0003R\u001B\u0010\u0086\u0003\u001A\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0086\u0003\u0010\u00D1\u0002R\u001A\u0010\u00C0\u0001\u001A\u00030\u00BF\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u00C0\u0001\u0010\u0087\u0003R\u001A\u0010\u0089\u0003\u001A\u00030\u0088\u00038\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u0089\u0003\u0010\u008A\u0003R\u0019\u0010\u008B\u0003\u001A\u0002058\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u008B\u0003\u0010\u008C\u0003R!\u0010\u008F\u0003\u001A\n\u0012\u0005\u0012\u00030\u008E\u00030\u008D\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008F\u0003\u0010\u0090\u0003R\u001C\u0010\u0092\u0003\u001A\u0005\u0018\u00010\u0091\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0092\u0003\u0010\u0093\u0003R\u001C\u0010\u0095\u0003\u001A\u0005\u0018\u00010\u0094\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0095\u0003\u0010\u0096\u0003R\u001C\u0010\u0098\u0003\u001A\u0005\u0018\u00010\u0097\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0098\u0003\u0010\u0099\u0003R\u0019\u0010\u009A\u0003\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009A\u0003\u0010\u009B\u0003R\u001A\u0010\u009C\u0003\u001A\u00030\u00CA\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009C\u0003\u0010\u009D\u0003R\u001C\u0010\u009F\u0003\u001A\u0005\u0018\u00010\u009E\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009F\u0003\u0010\u00A0\u0003R\u001C\u0010\u00A2\u0003\u001A\u0005\u0018\u00010\u00A1\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A2\u0003\u0010\u00A3\u0003R\u001C\u0010\u00A5\u0003\u001A\u0005\u0018\u00010\u00A4\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A5\u0003\u0010\u00A6\u0003R\u001C\u0010\u00A8\u0003\u001A\u0005\u0018\u00010\u00A7\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A8\u0003\u0010\u00A9\u0003R\u001C\u0010\u00AB\u0003\u001A\u0005\u0018\u00010\u00AA\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AB\u0003\u0010\u00AC\u0003R\u001C\u0010\u00AE\u0003\u001A\u0005\u0018\u00010\u00AD\u00038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AE\u0003\u0010\u00AF\u0003R)\u0010\u00B0\u0003\u001A\u00020+2\u0007\u0010\u00F2\u0002\u001A\u00020+8\u0006@BX\u0086\u000E\u00A2\u0006\u000F\n\u0006\b\u00B0\u0003\u0010\u00EB\u0002\u001A\u0005\b\u00B0\u0003\u0010HR\u0019\u0010\u00B1\u0003\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B1\u0003\u0010\u00EB\u0002R\u0019\u0010\u00B2\u0003\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B2\u0003\u0010\u00EB\u0002R*\u0010\u00B4\u0003\u001A\u00030\u00B3\u00038\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00B4\u0003\u0010\u00B5\u0003\u001A\u0006\b\u00B6\u0003\u0010\u00B7\u0003\"\u0006\b\u00B8\u0003\u0010\u00B9\u0003R\u001F\u0010\u00BC\u0003\u001A\n\u0012\u0005\u0012\u00030\u00BB\u00030\u00BA\u00038\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BC\u0003\u0010\u00BD\u0003R\u0018\u0010\u00BF\u0003\u001A\u00030\u00BE\u00038\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BF\u0003\u0010\u00C0\u0003R\u0018\u0010\u00C2\u0003\u001A\u00030\u00C1\u00038\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C2\u0003\u0010\u00C3\u0003R\u0018\u0010\u00C4\u0003\u001A\u00030\u00C1\u00038\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C4\u0003\u0010\u00C3\u0003R\u0018\u0010\u00C8\u0003\u001A\u00030\u00C5\u00038VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00C6\u0003\u0010\u00C7\u0003R\u0013\u0010\u00C9\u0003\u001A\u00020+8F\u00A2\u0006\u0007\u001A\u0005\b\u00C9\u0003\u0010H\u00A8\u0006\u00CC\u0003"}, d2 = {"Lcom/iloen/melon/MusicBrowserActivity;", "Lcom/iloen/melon/activity/BaseActivity;", "Lcom/iloen/melon/player/video/Pipable;", "Lpd/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "outState", "onSaveInstanceState", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "handlePendingIntent", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "inCase", "onChangedPermissionView", "(I)V", "onDestroy", "onBackPressedCallback", "onUserLeaveHint", "Landroid/app/PictureInPictureParams;", "params", "setPictureInPictureParams", "(Landroid/app/PictureInPictureParams;)V", "onPipModeOn", "onStart", "color", "setRootViewBackgroundColor", "Lc2/v;", "listener", "setMainContainerWindowInsetsListener", "(Lc2/v;)V", "", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "(ZLandroid/content/res/Configuration;)V", "onStop", "hasFocus", "onWindowFocusChanged", "(Z)V", "onResume", "onPause", "Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter;", "getBottomTabPagerAdapter", "()Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter;", "Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "getCurrentTabContainerFragment", "()Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "Landroid/view/View;", "getCtlBottom", "()Landroid/view/View;", "clearAllTabStackWithoutCurrentTab", "tabIndex", "clearAllStack", "isScrollTop", "selectTab", "(IZZ)V", "selectTabAndClear", "getMiniPlayerHeight", "()I", "isFullyCoveredByFloatingFragment", "()Z", "setVideoMiniPlayer", "Lcom/iloen/melon/custom/f1;", "type", "updateSystemUiFit", "(Lcom/iloen/melon/custom/f1;)V", "showTabAndMiniPlayer", "useAnimation", "showToolbar", "setTabAndMiniPlayerVisible", "(ZZZ)V", "LXb/j;", "event", "shouldSkipEvent", "(LXb/j;)Z", "dismissDialogOnStop", "Lcom/iloen/melon/eventbus/EventPremiumDevice;", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventPremiumDevice;)V", "Lcom/iloen/melon/eventbus/EventLoginDialog;", "(Lcom/iloen/melon/eventbus/EventLoginDialog;)V", "Lcom/iloen/melon/eventbus/EventLoginErrorDialog;", "(Lcom/iloen/melon/eventbus/EventLoginErrorDialog;)V", "Lcom/iloen/melon/eventbus/EventLoginError;", "(Lcom/iloen/melon/eventbus/EventLoginError;)V", "Lcom/iloen/melon/eventbus/EventAlertDialog;", "(Lcom/iloen/melon/eventbus/EventAlertDialog;)V", "Lcom/iloen/melon/eventbus/EventConfirmDialog;", "(Lcom/iloen/melon/eventbus/EventConfirmDialog;)V", "Lcom/iloen/melon/eventbus/EventAppFinish;", "(Lcom/iloen/melon/eventbus/EventAppFinish;)V", "Lcom/iloen/melon/eventbus/EventDownloadFailed;", "(Lcom/iloen/melon/eventbus/EventDownloadFailed;)V", "Lcom/iloen/melon/eventbus/EventOptionDialog;", "(Lcom/iloen/melon/eventbus/EventOptionDialog;)V", "Lcom/iloen/melon/eventbus/EventPlaylist;", "(Lcom/iloen/melon/eventbus/EventPlaylist;)V", "Lcom/iloen/melon/eventbus/EventWebViewClose$CloseAllView;", "(Lcom/iloen/melon/eventbus/EventWebViewClose$CloseAllView;)V", "Lcom/iloen/melon/eventbus/EventWebView$WebViewChromeSslCertIssueAlert;", "(Lcom/iloen/melon/eventbus/EventWebView$WebViewChromeSslCertIssueAlert;)V", "Lcom/iloen/melon/eventbus/EventLoginPromotionDialog;", "(Lcom/iloen/melon/eventbus/EventLoginPromotionDialog;)V", "Lcom/iloen/melon/eventbus/EventPlaybackScheme;", "(Lcom/iloen/melon/eventbus/EventPlaybackScheme;)V", "Lcom/iloen/melon/eventbus/EventDrmAutoExtensionNotAllowed;", "(Lcom/iloen/melon/eventbus/EventDrmAutoExtensionNotAllowed;)V", "Lx8/g;", "(Lx8/g;)V", "Lcom/iloen/melon/eventbus/EventSmartDialog;", "(Lcom/iloen/melon/eventbus/EventSmartDialog;)V", "keyCode", "Landroid/view/KeyEvent;", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "isBottomTabFragmentForeground", "setBottomTabFragmentForeground", "Lcom/iloen/melon/eventbus/EventPopup$EventShowApplyMelonDjPopup;", "(Lcom/iloen/melon/eventbus/EventPopup$EventShowApplyMelonDjPopup;)V", "Lcom/iloen/melon/eventbus/EventPopup$EventShowWifiSettingPopup;", "(Lcom/iloen/melon/eventbus/EventPopup$EventShowWifiSettingPopup;)V", "Lcom/iloen/melon/eventbus/EventToastMessage;", "(Lcom/iloen/melon/eventbus/EventToastMessage;)V", "Lcom/iloen/melon/eventbus/EventSplashDismiss;", "(Lcom/iloen/melon/eventbus/EventSplashDismiss;)V", "Lcom/iloen/melon/eventbus/EventWebView$OpenUri;", "(Lcom/iloen/melon/eventbus/EventWebView$OpenUri;)V", "Lcom/iloen/melon/eventbus/EventPopup$EventShowFolderSettingPopup;", "(Lcom/iloen/melon/eventbus/EventPopup$EventShowFolderSettingPopup;)V", "onKeyUp", "isTabInitialized", "initDebugViewIfNeed", "registerIntentFilter", "setScreenFlagsOnWindow", "Landroid/view/Window;", "window", "setScreenOnByIntent", "(Landroid/view/Window;)V", "setScreenOnByPlayback", "handleLaunchIntent", "checkAndUpdateScreenResolution", "onCreateMiniPlayer", "showSplashPopup", "initIap", "initGoogleIap", "initOneStoreIap", "handlePendingIntentAsync", "resetBackKeyTimer", "isSplashShowing", "processBackKey", "enterPipMode", "registerIsLoginFlow", "registerTokenCheckAtForeground", "handleScreenCapture", "delay", "checkRuntimePermission", "hasPhonePermission", "showPermissionFailPopup", "clearTabStack", "clearAllTabStack", "clearAllTabStackWithoutIndex", "selectedTabIndex", "selectBottomNavigation", "checkGooglePlayService", "initDatabaseFile", "showDialogOfflinePayback", "showDialogOnAirplane", "showDialogOnNetworkOff", "showDialogOnUpdate", "initViewPager", "LTc/c;", "uiState", "initBottomNavigationIconView", "(LTc/c;)V", "initBottomNavigationBadgeView", "initBottomNavigationListener", "initBottomNavigation", "index", "hideAnimationAndBadge", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "bottomNavigationView", "ignoreBottomNavigationLongClick", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;)V", "handleIntent", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/fragment/app/I;", "fragment", "getCurrTabIfPagerFragment", "(Landroidx/fragment/app/I;)Landroidx/fragment/app/I;", "setPlaylistIdObserver", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "setVideoUIAndMiniPlayerUI", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)V", "initFloatingFragment", "detachFloatingFragment", "isFullScreen", "openPlaylist", "openVideoPlayer", "(ZZ)V", "attachVideoPlayer", "Lcom/iloen/melon/player/video/FloatingFragment;", "connectVideoAndBottomTabLayout", "(Lcom/iloen/melon/player/video/FloatingFragment;)V", "detachVideoPlayer", "dismissPlaybackUiDialog", "dismissOfflinePlaybackDialog", "dismissSmartPlaylistDialog", "migrateLocalPlaylist", "", "Lcom/iloen/melon/playback/Playable;", "list", "checkPrimiumDownload", "(Ljava/util/List;)V", "LYb/h;", "exception", "handleAutoExtensionNotAllowedError", "(LYb/h;)V", "tryExtendDrmContents", "Lcom/iloen/melon/eventbus/EventPlaylist$EventAddSongIds;", "addToMyPlaylist", "(Lcom/iloen/melon/eventbus/EventPlaylist$EventAddSongIds;)V", "Lcom/iloen/melon/eventbus/EventPlaylist$EventDeleteSong;", "deleteDrawerPlaylistFromMyPlaylist", "(Lcom/iloen/melon/eventbus/EventPlaylist$EventDeleteSong;)V", "plist", "", "addList", "seq", "triggerPremiumDownload", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "initHighContrastColor", "showRuntimePermissionGuide", "hideRuntimePermissionGuide", "buildGoogleApiClient", "syncStatusBarModeWithCurrentFragment", "getShouldShowMiniPlayer", "(Landroidx/fragment/app/I;)Z", "needAutoLogin", "onCompleteCheckPermission", "startFlipLoops", "iconUrl", "Landroid/widget/ImageView;", "serverIconView", "tabIconView", "flipIconWithAnimation", "(Ljava/lang/String;Landroid/widget/ImageView;Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inflatePermissionCheckView", "usePageMeta", "trackTiaraForCoverWidget", "(Landroid/content/Intent;Z)V", "Lcom/iloen/melon/playback/Actor;", "actor", "copy", "trackTiaraForHomeWidget", "(Lcom/iloen/melon/playback/Actor;Ljava/lang/String;)V", "clickCopy", "trackBottomTab", "(Ljava/lang/String;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "LUb/q;", "playbackManager", "LUb/q;", "getPlaybackManager", "()LUb/q;", "setPlaybackManager", "(LUb/q;)V", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "LUb/u;", "vodRepeatManager", "LUb/u;", "getVodRepeatManager", "()LUb/u;", "setVodRepeatManager", "(LUb/u;)V", "LVb/t0;", "playerRules", "LVb/t0;", "getPlayerRules", "()LVb/t0;", "setPlayerRules", "(LVb/t0;)V", "Lsd/P;", "miniPlayerViewModel", "Lsd/P;", "getMiniPlayerViewModel", "()Lsd/P;", "setMiniPlayerViewModel", "(Lsd/P;)V", "Lcom/melon/playback/melon/drm/c;", "drmContentsHelper", "Lcom/melon/playback/melon/drm/c;", "getDrmContentsHelper", "()Lcom/melon/playback/melon/drm/c;", "setDrmContentsHelper", "(Lcom/melon/playback/melon/drm/c;)V", "LUb/s;", "remotePlayerManager", "LUb/s;", "getRemotePlayerManager", "()LUb/s;", "setRemotePlayerManager", "(LUb/s;)V", "Lqd/V;", "shuffleRepeatChangeNotifier", "Lqd/V;", "getShuffleRepeatChangeNotifier", "()Lqd/V;", "setShuffleRepeatChangeNotifier", "(Lqd/V;)V", "LTc/g;", "mainBottomTabViewModel$delegate", "Lie/j;", "getMainBottomTabViewModel", "()LTc/g;", "mainBottomTabViewModel", "rootView", "Landroid/view/View;", "mainContainer", "otherLayoutContainer", "Landroid/view/ViewStub;", "viewStubLayoutPermission", "Landroid/view/ViewStub;", "Landroid/os/CountDownTimer;", "countDownTimer", "Landroid/os/CountDownTimer;", "Landroid/view/ViewGroup;", "miniPlayerContainer", "Landroid/view/ViewGroup;", "videoMiniPlayerGap", "floatingFragment", "Lcom/iloen/melon/player/video/FloatingFragment;", "Lcom/iloen/melon/popup/MelonSplashPopup;", "splashPopup", "Lcom/iloen/melon/popup/MelonSplashPopup;", "Lcom/iloen/melon/popup/MelonProgressPopup;", "melonProgressDlg", "Lcom/iloen/melon/popup/MelonProgressPopup;", "Landroid/app/Dialog;", "offlinePlaybackPopup", "Landroid/app/Dialog;", "smartPlaylistPopup", "skipTmpCall", "Z", "getSkipTmpCall", "setSkipTmpCall", "Lcom/iloen/melon/custom/MelonTextView;", "agreeBtn", "Lcom/iloen/melon/custom/MelonTextView;", "Lcom/google/android/gms/common/api/GoogleApiClient;", "value", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "getGoogleApiClient", "()Lcom/google/android/gms/common/api/GoogleApiClient;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/iloen/melon/utils/system/NotificationHelper;", "notificationHelper", "Lcom/iloen/melon/utils/system/NotificationHelper;", "pendingIntent", "Landroid/content/Intent;", "Landroid/net/Uri;", "pendingPlayScheme", "Landroid/net/Uri;", "getPendingPlayScheme", "()Landroid/net/Uri;", "setPendingPlayScheme", "(Landroid/net/Uri;)V", "bottomNavigationContainer", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "Landroid/support/v4/view/NonSwipeableViewPager;", "viewPager", "Landroid/support/v4/view/NonSwipeableViewPager;", "tabPagerAdapter", "Lcom/iloen/melon/fragments/tabs/BottomTabPagerAdapter;", "", "Lk8/Z;", "bottomTabViewGroup", "Ljava/util/List;", "Lk8/b0;", "onBottomTabSelectedListener", "Lk8/b0;", "Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper;", "musicBrowserPopupHelper", "Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper;", "Lcom/iloen/melon/net/v4x/response/NotificationLoginRes;", "pendingNotificationLoginRes", "Lcom/iloen/melon/net/v4x/response/NotificationLoginRes;", "lastTabIndex", "I", "prevPlaylistId", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "ctlBottom", "Landroidx/constraintlayout/widget/ConstraintLayout;", "LY8/h;", "googleIapViewModel", "LY8/h;", "LY8/d;", "googleIapClientLifecycle", "LY8/d;", "LZ8/k;", "oneStoreIapViewModel", "LZ8/k;", "LZ8/g;", "oneStoreIapClientLifecycle", "LZ8/g;", "Lm8/g;", "deeplinkManager", "Lm8/g;", "isTabAndMiniPlayerVisibilityAnimationPlaying", "lastHighContrastMode", "checkingNotificationPermission", "Lmb/b;", "blockStoreRetrieveAndLoginUseCase", "Lmb/b;", "getBlockStoreRetrieveAndLoginUseCase", "()Lmb/b;", "setBlockStoreRetrieveAndLoginUseCase", "(Lmb/b;)V", "Ll2/i;", "Lcom/iloen/melon/BundleTrackingPreference;", "bundleTrackingDataStore", "Ll2/i;", "LSd/d;", "screenCaptureHelper", "LSd/d;", "Landroid/content/BroadcastReceiver;", "mPageActionReceiver", "Landroid/content/BroadcastReceiver;", "mAlertDialogBroadcastReceiver", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "isShowRuntimePermissionGuide", "Companion", "k8/a0", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MusicBrowserActivity extends Hilt_MusicBrowserActivity implements Pipable, d {
    public static final int $stable = 8;
    @NotNull
    private static final String ARG_LAST_HIGH_CONTRAST_MODE = "ARG_LAST_HIGH_CONTRAST_MODE";
    @NotNull
    private static final String ARG_LAST_TAB_INDEX = "ARG_LAST_TAB_INDEX";
    private static final int CASE_PERMISSION_CHANGE = 0;
    private static final int CASE_REJECT_PAGE_GONE = 2;
    private static final int CASE_REJECT_PAGE_VISIBLE = 1;
    @NotNull
    public static final a0 Companion = null;
    private static final boolean LOGV = false;
    @NotNull
    private static final String MELON_PREFNAME = "com.iloen.melon.Preference";
    @NotNull
    private static final String TAG = "MusicBrowserActivity";
    @Nullable
    private MelonTextView agreeBtn;
    @Inject
    public b blockStoreRetrieveAndLoginUseCase;
    @Nullable
    private View bottomNavigationContainer;
    private BottomNavigationView bottomNavigationView;
    @NotNull
    private List bottomTabViewGroup;
    private static int bundleLimitSize;
    @NotNull
    private final i bundleTrackingDataStore;
    private boolean checkingNotificationPermission;
    @Nullable
    private CountDownTimer countDownTimer;
    @Nullable
    private ConstraintLayout ctlBottom;
    @Nullable
    private g deeplinkManager;
    @Inject
    public c drmContentsHelper;
    @Nullable
    private FloatingFragment floatingFragment;
    @Nullable
    private GoogleApiClient googleApiClient;
    @Nullable
    private Y8.d googleIapClientLifecycle;
    @Nullable
    private h googleIapViewModel;
    @NotNull
    private final Handler handler;
    private static boolean isBundleSizeDanger;
    private boolean isTabAndMiniPlayerVisibilityAnimationPlaying;
    private static int lastBundleSize;
    private boolean lastHighContrastMode;
    private int lastTabIndex;
    @NotNull
    private final LogU log;
    @NotNull
    private final BroadcastReceiver mAlertDialogBroadcastReceiver;
    @NotNull
    private final BroadcastReceiver mPageActionReceiver;
    @NotNull
    private final j mainBottomTabViewModel$delegate;
    @Nullable
    private View mainContainer;
    @Nullable
    private MelonProgressPopup melonProgressDlg;
    @Nullable
    private ViewGroup miniPlayerContainer;
    @Inject
    public P miniPlayerViewModel;
    @Nullable
    private MusicBrowserPopupHelper musicBrowserPopupHelper;
    private NotificationHelper notificationHelper;
    @Nullable
    private Dialog offlinePlaybackPopup;
    @Nullable
    private b0 onBottomTabSelectedListener;
    @Nullable
    private Z8.g oneStoreIapClientLifecycle;
    @Nullable
    private k oneStoreIapViewModel;
    @Nullable
    private View otherLayoutContainer;
    @Nullable
    private Intent pendingIntent;
    @Nullable
    private NotificationLoginRes pendingNotificationLoginRes;
    @Nullable
    private Uri pendingPlayScheme;
    @Inject
    public q playbackManager;
    @Inject
    public t0 playerRules;
    @Inject
    public s2 playlistManager;
    @NotNull
    private PlaylistId prevPlaylistId;
    @Inject
    public s remotePlayerManager;
    @Nullable
    private View rootView;
    @NotNull
    private final Sd.d screenCaptureHelper;
    @Inject
    public V shuffleRepeatChangeNotifier;
    private boolean skipTmpCall;
    @Nullable
    private Dialog smartPlaylistPopup;
    @Nullable
    private MelonSplashPopup splashPopup;
    private BottomTabPagerAdapter tabPagerAdapter;
    @Nullable
    private View videoMiniPlayerGap;
    private NonSwipeableViewPager viewPager;
    @Nullable
    private ViewStub viewStubLayoutPermission;
    @Inject
    public u vodRepeatManager;

    static {
        MusicBrowserActivity.Companion = new a0();  // 初始化器: Ljava/lang/Object;-><init>()V
        MusicBrowserActivity.LOGV = false;
        MusicBrowserActivity.bundleLimitSize = 0x80000;
    }

    public MusicBrowserActivity() {
        this.log = Companion.create$default(LogU.Companion, "MusicBrowserActivity", false, null, 6, null);
        m1 m10 = new m1(this, 0);
        this.mainBottomTabViewModel$delegate = new H8.i(I.a.b(Tc.g.class), new m1(this, 1), m10, new m1(this, 2));
        this.handler = new Handler(Looper.getMainLooper());
        this.bottomTabViewGroup = new ArrayList();
        this.prevPlaylistId = PlaylistId.EMPTY;
        MelonAppBase.Companion.getClass();
        this.bundleTrackingDataStore = BundleTrackingPreferenceSerializerKt.getBundleTrackingPreferenceDataStore(t.a().getContext());
        this.screenCaptureHelper = new Sd.d();
        this.mPageActionReceiver = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public final void onReceive(Context context0, Intent intent0) {
                kotlin.jvm.internal.q.g(context0, "context");
                kotlin.jvm.internal.q.g(intent0, "intent");
                String s = intent0.getAction();
                if(s == null) {
                    LogU.Companion.e("MusicBrowserActivity", "mPageActionReceiver action is null!");
                    return;
                }
                boolean z = true;
                LogU.Companion.v("MusicBrowserActivity", "action : " + s);
                if("com.iloen.melon.intent.action.gologin".equals(s)) {
                    Navigator.openLoginView(f.i);
                    return;
                }
                if("com.iloen.melon.MELON20_PLAYER_START".equals(s)) {
                    Navigator.openNowPlayer$default(Navigator.INSTANCE, 0, 1, null);
                    return;
                }
                if("com.iloen.melon.NOWPLAYING_PLAYER_START".equals(s)) {
                    Bundle bundle0 = intent0.getBundleExtra("com.iloen.melon.nowplaying.argments");
                    Navigator.INSTANCE.openNowPlayList(bundle0);
                    return;
                }
                if("com.iloen.melon.MUSICVIDEO_VIEWER".equals(s)) {
                    boolean z1 = intent0.getBooleanExtra("argIsFullScreen", false);
                    if(intent0.getIntExtra("argOpenType", -1) != 1) {
                        z = false;
                    }
                    MusicBrowserActivity.access$openVideoPlayer(this.a, z1, z);
                    return;
                }
                if("com.iloen.melon.MELON_RADIO_CAST_PLAYER_START".equals(s)) {
                    Bundle bundle1 = intent0.getBundleExtra("com.iloen.melon.castPlayer.argments");
                    Navigator.INSTANCE.openStationPlayer(bundle1);
                }
            }
        };
        this.mAlertDialogBroadcastReceiver = new BroadcastReceiver() {
            public static final int b;

            @Override  // android.content.BroadcastReceiver
            public final void onReceive(Context context0, Intent intent0) {
                kotlin.jvm.internal.q.g(context0, "context");
                kotlin.jvm.internal.q.g(intent0, "intent");
                String s = intent0.getAction();
                if(s != null && s.equals("com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action")) {
                    androidx.fragment.app.I i0 = MelonFragmentManager.getInstance().getCurrentFragment();
                    if(i0 == null) {
                        LogU.Companion.e("MusicBrowserActivity", "Alert Dialog BroadcastReceiver currentFragment is null! ");
                        return;
                    }
                    if(Y.z(MelonAppBase.Companion)) {
                        LogU.Companion.d("MusicBrowserActivity", "skipped because now we are in the pip.");
                        return;
                    }
                    int v = intent0.getIntExtra("alertdialogtype", -1);
                    com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
                    MusicBrowserActivity musicBrowserActivity0 = this.a;
                    switch(v) {
                        case 0: 
                        case 1: {
                            int v1 = intent0.getIntExtra("titlekey", 0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            String s1 = musicBrowserActivity0.getResources().getString(v1);
                            kotlin.jvm.internal.q.f(s1, "getString(...)");
                            String s2 = intent0.getStringExtra("messagekey");
                            if(v == 1) {
                                com.melon.ui.popup.b.x(musicBrowserActivity0.getSupportFragmentManager(), s1, s2, false, false, null, null, null, null, null, null, 0xFF8);
                                return;
                            }
                            com.melon.ui.popup.b.d(b0, musicBrowserActivity0.getSupportFragmentManager(), s1, s2, false, false, false, null, null, null, null, null, 2040);
                            return;
                        }
                        case 2: {
                            if(i0 instanceof x0) {
                                String s5 = intent0.getStringExtra("titlekey");
                                if(TextUtils.isEmpty(s5)) {
                                    s5 = "장르별";
                                }
                                ((x0)i0).showGenreListPopup(s5, intent0.getStringArrayExtra("key_ids"), intent0.getStringArrayExtra("key_names"));
                                return;
                            }
                            break;
                        }
                        case 3: {
                            if(i0 instanceof x0) {
                                String[] arr_s = intent0.getStringArrayExtra("key_title");
                                ((x0)i0).showAddSongsToPlaylistPopup(intent0.getStringArrayExtra("key_id"), arr_s, intent0.getStringArrayExtra("myalbum_songid"));
                                return;
                            }
                            break;
                        }
                        case 4: {
                            if(i0 instanceof x0) {
                                ((x0)i0).showSNSListPopup(intent0.getStringArrayExtra("sns_share"), intent0.getStringExtra("sns_type"));
                                return;
                            }
                            break;
                        }
                        case 5: {
                            if(i0 instanceof MelonBaseFragment) {
                                String s6 = intent0.getStringExtra("titlekey");
                                String s7 = intent0.getStringExtra("messagekey");
                                if(!TextUtils.isEmpty(s6) && !TextUtils.isEmpty(s7)) {
                                    com.melon.ui.popup.b.x(musicBrowserActivity0.getSupportFragmentManager(), s6, s7, false, false, null, null, new r5(19), null, null, null, 0xEF8);
                                    return;
                                }
                                ((MelonBaseFragment)i0).showLoginPopup();
                                return;
                            }
                            break;
                        }
                        case 6: {
                            if(i0 instanceof x0) {
                                String s8 = intent0.getStringExtra("longtabtype");
                                String s9 = intent0.getStringExtra("longtap_menuid");
                                String s10 = intent0.getStringExtra("longtap_title");
                                String s11 = intent0.getStringExtra("longtap_id");
                                String s12 = intent0.getStringExtra("longtap_album_id");
                                String s13 = intent0.getStringExtra("longtap_artist_id");
                                String s14 = intent0.getStringExtra("longtap_mv_id");
                                String s15 = intent0.getStringExtra("longtap_mv_songid");
                                String s16 = intent0.getStringExtra("longtap_artist_name");
                                String s17 = intent0.getStringExtra("longtap_adultflg");
                                String s18 = intent0.getStringExtra("longtap_is_mv");
                                String s19 = intent0.getStringExtra("longtap_prodsclascode");
                                String s20 = intent0.getStringExtra("longtap_isservice");
                                boolean z = ProtocolUtils.parseBoolean(intent0.getStringExtra("longtap_mv_isbrandjs"));
                                String s21 = intent0.getStringExtra("longtap_mv_brandkey");
                                String s22 = intent0.getStringExtra("longtap_thumbnail");
                                Y.w("webview thumbanil = ", s22, LogU.Companion, "MusicBrowserActivity");
                                ((x0)i0).showMediaContextListPopup(s8, s9, s10, s11, s12, (z ? s21 : s13), s14, s15, s16, s17, s18, s19, ProtocolUtils.parseBoolean(s20), z, s22);
                                return;
                            }
                            break;
                        }
                        case 7: {
                            if(i0 instanceof MelonBaseFragment) {
                                ((MelonBaseFragment)i0).showRatingPopup(intent0.getStringExtra("albumid"));
                                return;
                            }
                            break;
                        }
                        case 8: {
                            String s23 = intent0.getStringExtra("typekey");
                            int v2 = intent0.getIntExtra("titlekey", 0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            String s24 = musicBrowserActivity0.getResources().getString(v2);
                            kotlin.jvm.internal.q.f(s24, "getString(...)");
                            String s25 = intent0.getStringExtra("messagekey");
                            if(kotlin.jvm.internal.q.b(s23, "alert")) {
                                com.melon.ui.popup.b.d(b0, musicBrowserActivity0.getSupportFragmentManager(), s24, s25, false, false, false, null, null, null, null, null, 2040);
                                return;
                            }
                            if(kotlin.jvm.internal.q.b(s23, "confirm")) {
                                com.melon.ui.popup.b.x(musicBrowserActivity0.getSupportFragmentManager(), s24, s25, false, false, null, null, new r5(20), null, null, null, 0xEF8);
                                return;
                            }
                            break;
                        }
                        case 9: {
                            String s26 = intent0.getStringExtra("typekey");
                            boolean z1 = intent0.getBooleanExtra("showtoast", false);
                            if(i0 instanceof MelonBaseFragment) {
                                if(z1) {
                                    ToastManager.show(0x7F1300AE);  // string:alert_dlg_body_mobile_data_network_check_toast "데이터 네트워크 차단 시\n단말에 저장된 콘텐츠만 
                                                                    // 재생됩니다."
                                    return;
                                }
                                if(kotlin.jvm.internal.q.b(s26, "mobile")) {
                                    ((MelonBaseFragment)i0).showNetwokSettingPopup();
                                    return;
                                }
                                if(kotlin.jvm.internal.q.b(s26, "melon")) {
                                    ((MelonBaseFragment)i0).showNetworkCheckPopup();
                                    return;
                                }
                            }
                            else if(i0 instanceof c0) {
                                if(z1) {
                                    ToastManager.show(0x7F1300AE);  // string:alert_dlg_body_mobile_data_network_check_toast "데이터 네트워크 차단 시\n단말에 저장된 콘텐츠만 
                                                                    // 재생됩니다."
                                    return;
                                }
                                kotlin.jvm.internal.q.f("안내", "getString(...)");
                                if(kotlin.jvm.internal.q.b(s26, "mobile")) {
                                    MusicBrowserActivity.access$showDialogOnNetworkOff(musicBrowserActivity0);
                                    return;
                                }
                                if(kotlin.jvm.internal.q.b(s26, "melon")) {
                                    com.melon.ui.popup.b.x(musicBrowserActivity0.getSupportFragmentManager(), "안내", "데이터 네트워크 차단 상태입니다.\n데이터 네트워크를 사용하시겠습니까?\n(사용중인 데이터 요금제에 따라 데이터 통화료가 부과될 수 있습니다)", false, false, null, null, new r5(21), null, null, null, 0xEF8);
                                    return;
                                }
                            }
                            break;
                        }
                        case 12: {
                            if(i0 instanceof x0) {
                                ((x0)i0).showCategoryListPopup(intent0.getStringExtra("titlekey"), intent0.getStringArrayExtra("key_ids"), intent0.getStringArrayExtra("key_names"));
                                return;
                            }
                            break;
                        }
                        case 13: {
                            com.melon.ui.popup.b.d(b0, musicBrowserActivity0.getSupportFragmentManager(), intent0.getStringExtra("titlekey"), intent0.getStringExtra("messagekey"), false, false, false, null, null, null, null, null, 2040);
                            return;
                        }
                        case 14: {
                            com.melon.ui.popup.b.x(musicBrowserActivity0.getSupportFragmentManager(), intent0.getStringExtra("titlekey"), intent0.getStringExtra("messagekey"), false, false, null, null, null, null, null, null, 0xFF8);
                            return;
                        }
                        case 16: {
                            if(i0 instanceof x0) {
                                String[] arr_s1 = intent0.getStringArrayExtra("key_title");
                                ((x0)i0).showAddSongsToDjPlaylistPopup(intent0.getStringArrayExtra("key_id"), arr_s1, intent0.getStringArrayExtra("djlist_songid"));
                                return;
                            }
                            break;
                        }
                        case 17: {
                            String s3 = intent0.getStringExtra("valuekey");
                            String s4 = intent0.getStringExtra("messagekey");
                            MelonTextNCheckPopup melonTextNCheckPopup0 = new MelonTextNCheckPopup(musicBrowserActivity0, 0x7F0D0138);  // layout:check_popup_layout
                            melonTextNCheckPopup0.setTitleName("안내");
                            melonTextNCheckPopup0.setBodyMsg(s4);
                            melonTextNCheckPopup0.setCheckMsg("다시 보지 않기");
                            melonTextNCheckPopup0.setPopupOnClickListener(new com.facebook.login.b(s3, 3));
                            melonTextNCheckPopup0.show();
                            return;
                        }
                        case 18: {
                            if(i0 instanceof x0) {
                                ((x0)i0).showDjPlylstPopup(intent0.getStringExtra("longtap_plylst_seq"), intent0.getStringExtra("longtap_title"), intent0.getStringExtra("longtap_owner_member_key"), intent0.getStringExtra("longtap_owner_nickname"), intent0.getStringExtra("longtap_withdrawyn"), intent0.getStringExtra("longtap_thumbnail"));
                                return;
                            }
                            break;
                        }
                        case 19: {
                            com.melon.ui.popup.b.s(musicBrowserActivity0, musicBrowserActivity0.getSupportFragmentManager(), new w0(21, musicBrowserActivity0, intent0.getStringExtra("typekey")), null);
                            return;
                        }
                        case 20: {
                            int v3 = intent0.getIntExtra("typekey", -1);
                            if(v3 >= 0) {
                                com.melon.ui.popup.b.s(musicBrowserActivity0, musicBrowserActivity0.getSupportFragmentManager(), new T(musicBrowserActivity0, v3, 4), null);
                                return;
                            }
                            break;
                        }
                        case 21: {
                            BuildersKt__Builders_commonKt.launch$default(f0.f(musicBrowserActivity0), null, null, new O0(musicBrowserActivity0, null), 3, null);
                            return;
                        }
                        case 22: {
                            com.melon.ui.popup.b.d(b0, musicBrowserActivity0.getSupportFragmentManager(), "알림", "Googleplay 스토어 앱 캐시를 삭제하시거나 PC 또는 모바일 웹에서 구매해주세요.\n(자세한 내용은 FAQ 참조)", false, false, false, null, null, null, null, null, 2040);
                        }
                    }
                }
            }
        };
    }

    public static boolean B(View view0) {
        return true;
    }

    public static void N(Uri uri0) {
        MusicBrowserActivity.onCreate$lambda$1(uri0);
    }

    public static void O(MusicBrowserActivity musicBrowserActivity0, EventPremiumDevice eventPremiumDevice0, DialogInterface dialogInterface0, int v) {
        MusicBrowserActivity.onEventMainThread$lambda$69(eventPremiumDevice0, musicBrowserActivity0, dialogInterface0, v);
    }

    public static final void access$attachVideoPlayer(MusicBrowserActivity musicBrowserActivity0, boolean z) {
        musicBrowserActivity0.attachVideoPlayer(z);
    }

    public static final boolean access$getLOGV$cp() [...] // 潜在的解密器

    public static final void access$openVideoPlayer(MusicBrowserActivity musicBrowserActivity0, boolean z, boolean z1) {
        musicBrowserActivity0.openVideoPlayer(z, z1);
    }

    public static final void access$showDialogOnNetworkOff(MusicBrowserActivity musicBrowserActivity0) {
        musicBrowserActivity0.showDialogOnNetworkOff();
    }

    private final void addToMyPlaylist(EventAddSongIds eventPlaylist$EventAddSongIds0) {
        String s = eventPlaylist$EventAddSongIds0.playlistSeq;
        List list0 = eventPlaylist$EventAddSongIds0.addList;
        if(!TextUtils.isEmpty(s) && list0 != null && !list0.isEmpty()) {
            if(k9.j.a() == 5 && k9.h.c(PlaylistId.DRAWER, new String[]{s})) {
                RequestBuilder.newInstance(new MyMusicPlaylistPlayListSongReq(Y.a(MelonAppBase.Companion), s)).tag("MusicBrowserActivity").listener(new d0(this, list0, s)).request();
            }
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new e0(this, s, null), 3, null);
        }
    }

    private final void attachVideoPlayer(boolean z) {
        LogU.info$default(this.log, "attachVideoPlayer() isFullScreen:" + z, null, false, 6, null);
        if(this.getCurrentFragment() instanceof td.b0) {
            this.onBackPressed();
        }
        if((this.floatingFragment instanceof VideoMainFrameFragment ? ((VideoMainFrameFragment)this.floatingFragment) : null) == null) {
            VideoMainFrameFragment videoMainFrameFragment0 = VideoMainFrameFragment.Companion.newInstance(z);
            this.connectVideoAndBottomTabLayout(videoMainFrameFragment0);
            l0 l00 = this.getSupportFragmentManager();
            a a0 = com.iloen.melon.utils.a.f(l00, "getSupportFragmentManager(...)", l00);
            a0.g(0x7F0A07CD, videoMainFrameFragment0, null);  // id:main_player_container
            a0.l(true, true);
            this.floatingFragment = videoMainFrameFragment0;
        }
    }

    private final void buildGoogleApiClient() {
        Builder googleApiClient$Builder0 = new Builder(Y.a(MelonAppBase.Companion)).addConnectionCallbacks(new k8.f0()).addOnConnectionFailedListener(new k8.V()).addApi(LocationServices.API);  // 初始化器: Ljava/lang/Object;-><init>()V / 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.q.f(googleApiClient$Builder0, "addApi(...)");
        try {
            this.googleApiClient = googleApiClient$Builder0.build();
        }
        catch(Exception unused_ex) {
            LogU.Companion.e("MusicBrowserActivity", "GoogleApiClient build exception");
            this.googleApiClient = null;
        }
        catch(Error unused_ex) {
            LogU.Companion.e("MusicBrowserActivity", "GoogleApiClient build error");
            this.googleApiClient = null;
        }
    }

    private static final void buildGoogleApiClient$lambda$82(ConnectionResult connectionResult0) {
        kotlin.jvm.internal.q.g(connectionResult0, "it");
        LogU.Companion.d("MusicBrowserActivity", "GoogleApiClient failed");
    }

    private final void checkAndUpdateScreenResolution() {
        String s = MelonPrefs.getInstance().getString("prevScreenResolution", "");
        DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
        String s1 = displayMetrics0.widthPixels + "x" + displayMetrics0.heightPixels;
        if(s != null && s.length() == 0) {
            MelonPrefs.getInstance().setString("prevScreenResolution", s1);
            return;
        }
        if(!TextUtils.equals(s1, s)) {
            MelonAppBase.Companion.getClass();
            Glide.get(t.a().getContext()).clearMemory();
            MelonPrefs.getInstance().setString("prevScreenResolution", s1);
        }
    }

    private final void checkGooglePlayService() {
        if(GooglePlayServiceUtils.isEnable(this.getApplicationContext())) {
            new Handler(Looper.getMainLooper()).postDelayed(new Q(this, 0), 100L);
            return;
        }
        if(!MelonPrefs.getInstance().getBoolean("GOOGLECAST_GOOGLEPLAYSERVICE_POPUP_SHOWN", false)) {
            MelonPrefs.getInstance().setBoolean("GOOGLECAST_GOOGLEPLAYSERVICE_POPUP_SHOWN", true);
            com.melon.ui.popup.b.x(this.getSupportFragmentManager(), "안내", "멜론에서 Google Chrome Cast를 이용하시려면 Google Play 서비스를 업데이트 해주세요.", false, false, "취소", "업데이트", new r5(17), new N(this, 3), null, null, 0xC38);
            return;
        }
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.onEventShowMainPopups();
        }
    }

    private static final void checkGooglePlayService$lambda$29(MusicBrowserActivity musicBrowserActivity0) {
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = musicBrowserActivity0.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.onEventShowMainPopups();
        }
    }

    private static final H checkGooglePlayService$lambda$30() {
        Navigator.INSTANCE.installGooglePlayService();
        return H.a;
    }

    private static final H checkGooglePlayService$lambda$31(MusicBrowserActivity musicBrowserActivity0) {
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = musicBrowserActivity0.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.onEventShowMainPopups();
        }
        return H.a;
    }

    private final void checkPrimiumDownload(List list0) {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new g0(this, list0, null), 3, null);
    }

    private final void checkRuntimePermission(int v) {
        new h0(this, Looper.getMainLooper()).sendEmptyMessageDelayed(0, ((long)v));
    }

    public static void checkRuntimePermission$default(MusicBrowserActivity musicBrowserActivity0, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkRuntimePermission");
        }
        if((v1 & 1) != 0) {
            v = 0;
        }
        musicBrowserActivity0.checkRuntimePermission(v);
    }

    private final void clearAllTabStack() {
        BottomTabPagerAdapter bottomTabPagerAdapter0 = this.tabPagerAdapter;
        if(bottomTabPagerAdapter0 != null) {
            for(int v = 0; v < 5; ++v) {
                BottomTabBaseFragment bottomTabBaseFragment0 = bottomTabPagerAdapter0.getFragment(v);
                if(bottomTabBaseFragment0 != null) {
                    bottomTabBaseFragment0.removeFragmentByIndex(1);
                }
            }
            return;
        }
        kotlin.jvm.internal.q.m("tabPagerAdapter");
        throw null;
    }

    public final void clearAllTabStackWithoutCurrentTab() {
        NonSwipeableViewPager nonSwipeableViewPager0 = this.viewPager;
        if(nonSwipeableViewPager0 != null) {
            this.clearAllTabStackWithoutIndex(nonSwipeableViewPager0.getCurrentItem());
            return;
        }
        kotlin.jvm.internal.q.m("viewPager");
        throw null;
    }

    private final void clearAllTabStackWithoutIndex(int v) {
        BottomTabPagerAdapter bottomTabPagerAdapter0 = this.tabPagerAdapter;
        if(bottomTabPagerAdapter0 != null) {
            for(int v1 = 0; v1 < 5; ++v1) {
                if(v1 != v) {
                    BottomTabBaseFragment bottomTabBaseFragment0 = bottomTabPagerAdapter0.getFragment(v1);
                    if(bottomTabBaseFragment0 != null) {
                        bottomTabBaseFragment0.removeFragmentByIndex(1);
                    }
                }
            }
            return;
        }
        kotlin.jvm.internal.q.m("tabPagerAdapter");
        throw null;
    }

    private final void clearTabStack(int v) {
        BottomTabPagerAdapter bottomTabPagerAdapter0 = this.tabPagerAdapter;
        if(bottomTabPagerAdapter0 != null) {
            BottomTabBaseFragment bottomTabBaseFragment0 = bottomTabPagerAdapter0.getFragment(v);
            if(bottomTabBaseFragment0 != null) {
                bottomTabBaseFragment0.removeFragmentByIndex(1);
            }
            return;
        }
        kotlin.jvm.internal.q.m("tabPagerAdapter");
        throw null;
    }

    private final void connectVideoAndBottomTabLayout(FloatingFragment floatingFragment0) {
        if(floatingFragment0 instanceof VideoMainFrameFragment) {
            ((VideoMainFrameFragment)floatingFragment0).setVideoStatusListener(new O(this, 1));
        }
    }

    private static final H connectVideoAndBottomTabLayout$lambda$56(MusicBrowserActivity musicBrowserActivity0, VideoStatus videoStatus0) {
        kotlin.jvm.internal.q.g(videoStatus0, "videoStatus");
        if(videoStatus0 == VideoStatus.MiniMode) {
            n n0 = new n();
            n0.f(musicBrowserActivity0.ctlBottom);
            n0.h(0x7F0A07CD, 4, 0x7F0A0123, 4);  // id:main_player_container
            n0.b(musicBrowserActivity0.ctlBottom);
            return H.a;
        }
        n n1 = new n();
        n1.f(musicBrowserActivity0.ctlBottom);
        n1.h(0x7F0A07CD, 4, 0, 4);  // id:main_player_container
        n1.b(musicBrowserActivity0.ctlBottom);
        return H.a;
    }

    public static String d0() [...] // 潜在的解密器

    private final void deleteDrawerPlaylistFromMyPlaylist(EventDeleteSong eventPlaylist$EventDeleteSong0) {
        String s = eventPlaylist$EventDeleteSong0.playlistSeq;
        List list0 = eventPlaylist$EventDeleteSong0.delList;
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new i0(this, s, list0, null), 3, null);
    }

    private final void detachFloatingFragment() {
        FloatingFragment floatingFragment0 = this.floatingFragment;
        if(floatingFragment0 != null) {
            l0 l00 = this.getSupportFragmentManager();
            a a0 = com.iloen.melon.utils.a.f(l00, "getSupportFragmentManager(...)", l00);
            a0.b = 0;
            a0.c = 0;
            a0.d = 0;
            a0.e = 0;
            a0.d(floatingFragment0);
            a0.f(floatingFragment0);
            a0.l(true, true);
        }
    }

    private final void detachVideoPlayer() {
        LogU.Companion.d("MusicBrowserActivity", "detachVideoPlayer()");
        VideoMainFrameFragment videoMainFrameFragment0 = this.floatingFragment instanceof VideoMainFrameFragment ? ((VideoMainFrameFragment)this.floatingFragment) : null;
        if(videoMainFrameFragment0 != null) {
            l0 l00 = this.getSupportFragmentManager();
            a a0 = com.iloen.melon.utils.a.f(l00, "getSupportFragmentManager(...)", l00);
            a0.b = 0;
            a0.c = 0;
            a0.d = 0;
            a0.e = 0;
            a0.d(videoMainFrameFragment0);
            a0.f(videoMainFrameFragment0);
            a0.l(true, true);
        }
        this.floatingFragment = null;
    }

    @Override  // pd.b
    public boolean dismissDialogOnStop() {
        return true;
    }

    private final void dismissOfflinePlaybackDialog() {
        if(this.offlinePlaybackPopup != null && this.offlinePlaybackPopup.isShowing()) {
            Dialog dialog0 = this.offlinePlaybackPopup;
            if(dialog0 != null) {
                dialog0.dismiss();
            }
        }
    }

    private final void dismissPlaybackUiDialog() {
        w.v(this);
    }

    private final void dismissSmartPlaylistDialog() {
        if(this.smartPlaylistPopup != null && this.smartPlaylistPopup.isShowing()) {
            Dialog dialog0 = this.smartPlaylistPopup;
            if(dialog0 != null) {
                dialog0.dismiss();
            }
        }
    }

    private final boolean enterPipMode() {
        if(this.getLifecycle().b().compareTo(androidx.lifecycle.s.e) >= 0) {
            if(this.getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
                VideoMainFrameFragment videoMainFrameFragment0 = this.floatingFragment instanceof VideoMainFrameFragment ? ((VideoMainFrameFragment)this.floatingFragment) : null;
                if(!e.N(videoMainFrameFragment0)) {
                    LogU.debug$default(this.log, "enterPipMode() - skipped because VideoFragment Lifecycle isn\'t valid.", null, false, 6, null);
                    return false;
                }
                if(videoMainFrameFragment0 != null && this.getPlayerUseCase().n()) {
                    if(((Ub.t)this.getRemotePlayerManager()).d()) {
                        LogU.debug$default(this.log, "enterPipMode() - skipped because GoogleCast is being connected.", null, false, 6, null);
                        return false;
                    }
                    A a0 = this.getPlayerUseCase().j();
                    boolean z = ((v)this.getVodRepeatManager()).a();
                    Playable playable0 = ((d3)this.getPlaylistManager()).f();
                    if(playable0 == null || playable0.isLiveContent() || z || a0.b <= 0L || a0.a < a0.b - 2000L) {
                        this.dismissPlaybackUiDialog();
                        this.dismissEventNotificationDialog();
                        this.dismissSmartPlaylistDialog();
                        this.hideAllPopup();
                        PictureInPictureParams pictureInPictureParams0 = VideoMainFrameFragment.getPictureInPictureParams$default(videoMainFrameFragment0, null, false, 3, null);
                        this.setPictureInPictureParams(pictureInPictureParams0);
                        try {
                            boolean z1 = this.enterPictureInPictureMode(pictureInPictureParams0);
                            MelonAppBase.Companion.getClass();
                            t.a().setAppPip(z1);
                            return z1;
                        }
                        catch(Throwable throwable0) {
                            d5.n.t(throwable0);
                        }
                    }
                }
            }
            return false;
        }
        LogU.debug$default(this.log, "enterPipMode() - skipped because not in resumed.", null, false, 6, null);
        return false;
    }

    private final Object flipIconWithAnimation(String s, ImageView imageView0, ImageView imageView1, Continuation continuation0) {
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView6;
        String s1;
        j0 j00;
        if(continuation0 instanceof j0) {
            j00 = (j0)continuation0;
            int v = j00.G;
            if((v & 0x80000000) == 0) {
                j00 = new j0(this, continuation0);
            }
            else {
                j00.G = v ^ 0x80000000;
            }
        }
        else {
            j00 = new j0(this, continuation0);
        }
        Object object0 = j00.D;
        ne.a a0 = ne.a.a;
        switch(j00.G) {
            case 0: {
                d5.n.D(object0);
                j00.r = s;
                j00.w = imageView0;
                imageView6 = imageView1;
                j00.B = imageView6;
                j00.G = 1;
                if(Nd.a.a(imageView0, 90.0f, 180.0f, j00) != a0) {
                    s1 = s;
                label_41:
                    j00.r = s1;
                    j00.w = imageView0;
                    j00.B = imageView6;
                    j00.G = 2;
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(e1.u.D(j00), 1);
                    cancellableContinuationImpl0.initCancellability();
                    cancellableContinuationImpl0.invokeOnCancellation(new G(9, this, imageView0));
                    if(this.isFinishing() || this.isDestroyed()) {
                        cancellableContinuationImpl0.resumeWith(new ColorDrawable(0));
                    }
                    else {
                        Glide.with(this).asDrawable().load(s1).transition(DrawableTransitionOptions.withCrossFade(0)).into(new com.iloen.melon.custom.a(cancellableContinuationImpl0, 2));
                    }
                    object0 = cancellableContinuationImpl0.getResult();
                    if(object0 != a0) {
                        imageView3 = imageView0;
                        imageView2 = imageView6;
                    label_56:
                        imageView3.setImageDrawable(((Drawable)object0));
                        if(((Drawable)object0) instanceof WebpDrawable) {
                            ((WebpDrawable)(((Drawable)object0))).setLoopCount(1);
                            ((WebpDrawable)(((Drawable)object0))).start();
                            j00.r = null;
                            j00.w = imageView3;
                            j00.B = imageView2;
                            j00.G = 3;
                            CancellableContinuationImpl cancellableContinuationImpl1 = new CancellableContinuationImpl(e1.u.D(j00), 1);
                            cancellableContinuationImpl1.initCancellability();
                            k0 k00 = new k0(new AtomicBoolean(false), ((WebpDrawable)(((Drawable)object0))), cancellableContinuationImpl1);
                            cancellableContinuationImpl1.invokeOnCancellation(new G(8, ((WebpDrawable)(((Drawable)object0))), k00));
                            ((WebpDrawable)(((Drawable)object0))).registerAnimationCallback(k00);
                            if(cancellableContinuationImpl1.getResult() != a0) {
                                goto label_70;
                            }
                        }
                        else {
                        label_70:
                            j00.r = null;
                            j00.w = null;
                            j00.B = imageView2;
                            j00.G = 4;
                            if(Nd.a.a(imageView3, 180.0f, 90.0f, j00) != a0) {
                            label_75:
                                j00.r = null;
                                j00.w = null;
                                j00.B = null;
                                j00.G = 5;
                                if(Nd.a.a(imageView2, 90.0f, 0.0f, j00) != a0) {
                                    return H.a;
                                }
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                ImageView imageView4 = j00.B;
                ImageView imageView5 = j00.w;
                s1 = j00.r;
                d5.n.D(object0);
                imageView6 = imageView4;
                imageView0 = imageView5;
                goto label_41;
            }
            case 2: {
                imageView2 = j00.B;
                imageView3 = j00.w;
                d5.n.D(object0);
                goto label_56;
            }
            case 3: {
                imageView2 = j00.B;
                imageView3 = j00.w;
                d5.n.D(object0);
                goto label_70;
            }
            case 4: {
                imageView2 = j00.B;
                d5.n.D(object0);
                goto label_75;
            }
            case 5: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    @Override  // pd.d
    @NotNull
    public Activity getActivity() [...] // Inlined contents

    @NotNull
    public final b getBlockStoreRetrieveAndLoginUseCase() {
        b b0 = this.blockStoreRetrieveAndLoginUseCase;
        if(b0 != null) {
            return b0;
        }
        kotlin.jvm.internal.q.m("blockStoreRetrieveAndLoginUseCase");
        throw null;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    @NotNull
    public BottomTabPagerAdapter getBottomTabPagerAdapter() {
        BottomTabPagerAdapter bottomTabPagerAdapter0 = this.tabPagerAdapter;
        if(bottomTabPagerAdapter0 != null) {
            return bottomTabPagerAdapter0;
        }
        kotlin.jvm.internal.q.m("tabPagerAdapter");
        throw null;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    @Nullable
    public View getCtlBottom() {
        return this.ctlBottom;
    }

    private final androidx.fragment.app.I getCurrTabIfPagerFragment(androidx.fragment.app.I i0) {
        if(i0 instanceof IFragmentContainer) {
            androidx.fragment.app.I i1 = ((IFragmentContainer)i0).getCurrentFragment();
            return i1 == null ? i0 : i1;
        }
        return i0;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    @Nullable
    public BottomTabBaseFragment getCurrentTabContainerFragment() {
        BottomTabPagerAdapter bottomTabPagerAdapter0 = this.tabPagerAdapter;
        if(bottomTabPagerAdapter0 != null) {
            NonSwipeableViewPager nonSwipeableViewPager0 = this.viewPager;
            if(nonSwipeableViewPager0 != null) {
                return bottomTabPagerAdapter0.getFragment(nonSwipeableViewPager0.getCurrentItem());
            }
            kotlin.jvm.internal.q.m("viewPager");
            throw null;
        }
        kotlin.jvm.internal.q.m("tabPagerAdapter");
        throw null;
    }

    @NotNull
    public final c getDrmContentsHelper() {
        c c0 = this.drmContentsHelper;
        if(c0 != null) {
            return c0;
        }
        kotlin.jvm.internal.q.m("drmContentsHelper");
        throw null;
    }

    @Nullable
    public final GoogleApiClient getGoogleApiClient() {
        return this.googleApiClient;
    }

    private final Tc.g getMainBottomTabViewModel() {
        return (Tc.g)this.mainBottomTabViewModel$delegate.getValue();
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public int getMiniPlayerHeight() {
        int v = this.getResources().getDimensionPixelSize(0x7F070057);  // dimen:bottom_tab_height
        return this.getResources().getDimensionPixelSize(0x7F070315) + v;  // dimen:mini_player_height
    }

    @NotNull
    public final P getMiniPlayerViewModel() {
        P p0 = this.miniPlayerViewModel;
        if(p0 != null) {
            return p0;
        }
        kotlin.jvm.internal.q.m("miniPlayerViewModel");
        throw null;
    }

    @Nullable
    public final Uri getPendingPlayScheme() {
        return this.pendingPlayScheme;
    }

    @NotNull
    public final q getPlaybackManager() {
        q q0 = this.playbackManager;
        if(q0 != null) {
            return q0;
        }
        kotlin.jvm.internal.q.m("playbackManager");
        throw null;
    }

    @NotNull
    public final t0 getPlayerRules() {
        t0 t00 = this.playerRules;
        if(t00 != null) {
            return t00;
        }
        kotlin.jvm.internal.q.m("playerRules");
        throw null;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        s2 s20 = this.playlistManager;
        if(s20 != null) {
            return s20;
        }
        kotlin.jvm.internal.q.m("playlistManager");
        throw null;
    }

    @NotNull
    public final s getRemotePlayerManager() {
        s s0 = this.remotePlayerManager;
        if(s0 != null) {
            return s0;
        }
        kotlin.jvm.internal.q.m("remotePlayerManager");
        throw null;
    }

    // 去混淆评级： 低(20)
    private final boolean getShouldShowMiniPlayer(androidx.fragment.app.I i0) {
        return i0 instanceof K ? ((K)i0).isShowMiniPlayer() : false;
    }

    @NotNull
    public final V getShuffleRepeatChangeNotifier() {
        V v0 = this.shuffleRepeatChangeNotifier;
        if(v0 != null) {
            return v0;
        }
        kotlin.jvm.internal.q.m("shuffleRepeatChangeNotifier");
        throw null;
    }

    public final boolean getSkipTmpCall() {
        return this.skipTmpCall;
    }

    @NotNull
    public final u getVodRepeatManager() {
        u u0 = this.vodRepeatManager;
        if(u0 != null) {
            return u0;
        }
        kotlin.jvm.internal.q.m("vodRepeatManager");
        throw null;
    }

    private final void handleAutoExtensionNotAllowedError(Yb.h h0) {
        LogU.info$default(this.log, "handleAutoExtensionNotAllowedError()", null, false, 6, null);
        boolean z = kotlin.jvm.internal.q.b(CType.SONG, h0.e.a);
        l0 l00 = this.getSupportFragmentManager();
        String s = this.getString((z ? 0x7F1302AC : 0x7F1302A9), new Object[]{h0.e.f, h0.e.e});  // string:dcf_auto_extension_deduct_confirm_popup_song_msg1 "기간이 만료된 파일입니다.\n재생을 위해서는 
                                                                                                 // DCF파일의\n재생 기간을 연장하셔야 합니다.\n\n기간연장 진행 시에는\n다운로드 보유 곡 수가 차감됩니다.\n진행하시겠습니까?\n(잔여 %1$d/전체 
                                                                                                 // %2$d)"
        w0 w00 = new w0(20, this, h0);
        Hb.k k0 = new Hb.k(z, 3);
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(com.melon.ui.popup.b.b(l00, "showAutoExtendDcfConfirmPopup", null, null, 12) == null) {
                B b0 = new B();
                b0.e = s;
                b0.g = w00;
                b0.h = k0;
                b0.show(l00, "showAutoExtendDcfConfirmPopup");
            }
        }
    }

    private static final H handleAutoExtensionNotAllowedError$lambda$65(MusicBrowserActivity musicBrowserActivity0, Yb.h h0) {
        musicBrowserActivity0.tryExtendDrmContents(h0);
        return H.a;
    }

    private static final H handleAutoExtensionNotAllowedError$lambda$66(boolean z) {
        DcfExtensionNeededBrowserFragment.newInstance(!z).open();
        return H.a;
    }

    private final Object handleIntent(Intent intent0, Continuation continuation0) {
        List list0;
        Intent intent1;
        Uri uri0;
        String s;
        k8.l0 l00;
        if(continuation0 instanceof k8.l0) {
            l00 = (k8.l0)continuation0;
            int v = l00.G;
            if((v & 0x80000000) == 0) {
                l00 = new k8.l0(this, continuation0);
            }
            else {
                l00.G = v ^ 0x80000000;
            }
        }
        else {
            l00 = new k8.l0(this, continuation0);
        }
        Object object0 = l00.D;
        ne.a a0 = ne.a.a;
        switch(l00.G) {
            case 0: {
                d5.n.D(object0);
                s = intent0.getAction();
                uri0 = intent0.getData();
                if("android.intent.action.MAIN".equals(s)) {
                    intent1 = intent0;
                }
                else {
                    androidx.lifecycle.t t0 = this.getLifecycle();
                    androidx.lifecycle.s s1 = androidx.lifecycle.s.e;
                    if(s1.compareTo(androidx.lifecycle.s.c) < 0) {
                        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + s1).toString());
                    }
                    MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain().getImmediate();
                    boolean z = mainCoroutineDispatcher0.isDispatchNeeded(l00.getContext());
                    if(z) {
                    label_29:
                        df.e e0 = new df.e(this, 2);
                        intent1 = intent0;
                        l00.r = intent1;
                        l00.w = s;
                        l00.B = uri0;
                        l00.G = 1;
                        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(e1.u.D(l00), 1);
                        cancellableContinuationImpl0.initCancellability();
                        androidx.lifecycle.t0 t00 = new androidx.lifecycle.t0(t0, cancellableContinuationImpl0, e0);
                        if(z) {
                            s0 s00 = new s0(t0, t00, 0);
                            mainCoroutineDispatcher0.dispatch(me.j.a, s00);
                        }
                        else {
                            t0.a(t00);
                        }
                        cancellableContinuationImpl0.invokeOnCancellation(new Gf.j(mainCoroutineDispatcher0, t0, t00, 1));
                        if(cancellableContinuationImpl0.getResult() == a0) {
                            return a0;
                        }
                    }
                    else {
                        if(t0.b() == androidx.lifecycle.s.a) {
                            throw new S(null, 5);
                        }
                        if(t0.b().compareTo(s1) >= 0) {
                            this.setVideoMiniPlayer();
                            intent1 = intent0;
                            break;
                        }
                        else {
                            goto label_29;
                        }
                    }
                }
                break;
            }
            case 1: {
                Uri uri1 = l00.B;
                s = l00.w;
                Intent intent2 = l00.r;
                d5.n.D(object0);
                intent1 = intent2;
                uri0 = uri1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        boolean z1 = "com.iloen.melon.MELON_PUSH_ACT_START".equals(s) && kotlin.jvm.internal.q.b(intent1.getStringExtra("msgType"), "INFO") || intent1.getBooleanExtra("fromInfoPusH", false);
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 == null) {
            androidx.fragment.app.I i0 = this.getCurrentFragment();
            if(i0 != null) {
                this.musicBrowserPopupHelper = new MusicBrowserPopupHelper(this, this.getShouldShowMiniPlayer(i0), z1, this.lastTabIndex);
                NotificationLoginRes notificationLoginRes0 = this.pendingNotificationLoginRes;
                if(notificationLoginRes0 != null) {
                    LogU.debug$default(this.log, "showLoginPopup using PendingNotificationLoginRes...", null, false, 6, null);
                    MusicBrowserPopupHelper musicBrowserPopupHelper1 = this.musicBrowserPopupHelper;
                    if(musicBrowserPopupHelper1 != null) {
                        musicBrowserPopupHelper1.showLoginPopup(notificationLoginRes0);
                    }
                    this.pendingNotificationLoginRes = null;
                }
            }
        }
        else {
            musicBrowserPopupHelper0.setLock(z1);
        }
        EventBusHelper.post(new EventDismissOnboarding());
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("MusicBrowserActivity", "handleIntent action: " + s + ", uri:" + uri0);
        if(TextUtils.isEmpty(s)) {
            logU$Companion0.i("MusicBrowserActivity", "action is null set to default: com.iloen.melon.MELON_PLAYER_START");
            s = "com.iloen.melon.MELON_PLAYER_START";
        }
        else if((intent1.getFlags() & 0x100000) > 0) {
            logU$Companion0.i("MusicBrowserActivity", "launch from history - change action: com.iloen.melon.MELON_PLAYER_START");
            s = "com.iloen.melon.MELON_PLAYER_START";
        }
        else if(kotlin.jvm.internal.q.b(intent1.getAction(), "android.nfc.action.NDEF_DISCOVERED") && uri0 != null) {
            Uri uri2 = !kotlin.jvm.internal.q.b(uri0.getScheme(), "https") || !kotlin.jvm.internal.q.b(uri0.getHost(), "into.melon.com") || !kotlin.jvm.internal.q.b(uri0.getPath(), "/simplemode.html") ? uri0 : f.n.buildUpon().appendQueryParameter("ctype", "simplemode").appendQueryParameter("openplayer", "Y").build();
            kotlin.jvm.internal.q.d(uri2);
            w.x(this, uri2);
        }
        boolean z2 = "com.iloen.melon.intent.action.MAIN".equals(s);
        H h0 = H.a;
        if(z2) {
            Actor actor0 = Actor.Normal;
            if(intent1.hasExtra("com.iloen.melon.intent.extra.actor")) {
                Serializable serializable0 = com.kakao.sdk.common.util.a.h(intent1);
                if(((Actor)serializable0) == null) {
                    logU$Companion0.w("MusicBrowserActivity", "handleIntent() - actor is null");
                }
                else {
                    actor0 = (Actor)serializable0;
                }
            }
            if(Actor.Widget_2x1 == actor0 || Actor.Widget_2x2 == actor0 || Actor.Widget_4x1 == actor0 || Actor.Widget_4x2 == actor0) {
                BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new m0(this, null), 2, null);
                kotlin.jvm.internal.q.f("멜론홈", "getString(...)");
                this.trackTiaraForHomeWidget(actor0, "멜론홈");
                return h0;
            }
            else if(Actor.Widget_cover == actor0) {
                Navigator.openMainMusicAndClearStack();
                this.trackTiaraForCoverWidget(intent1, false);
                return h0;
            }
        }
        else if("com.iloen.melon.intent.action.widget.search".equals(s)) {
            Navigator.INSTANCE.openMainSearchAndClearStack();
            if(intent1.hasExtra("com.iloen.melon.intent.extra.actor")) {
                Serializable serializable1 = com.kakao.sdk.common.util.a.h(intent1);
                if(Actor.Widget_4x2 == ((Actor)serializable1)) {
                    kotlin.jvm.internal.q.f("검색", "getString(...)");
                    this.trackTiaraForHomeWidget(((Actor)serializable1), "검색");
                    return h0;
                }
            }
        }
        else {
            if("com.iloen.melon.ALBUM_INFO".equals(s)) {
                String s2 = intent1.getStringExtra("com.iloen.melon.intent.extra.widget.album_id");
                if(s2 != null && s2.length() != 0) {
                    Navigator.openAlbumInfo(s2);
                }
                Serializable serializable2 = com.kakao.sdk.common.util.a.h(intent1);
                if(((Actor)serializable2) == Actor.Widget_cover) {
                    MusicBrowserActivity.trackTiaraForCoverWidget$default(this, intent1, false, 2, null);
                    return h0;
                }
                kotlin.jvm.internal.q.f("앨범정보", "getString(...)");
                this.trackTiaraForHomeWidget(((Actor)serializable2), "앨범정보");
                return h0;
            }
            if(!"com.iloen.melon.MELON_PLAYER_START".equals(s) && !"com.iloen.melon.MELON_RADIO_PLAYER_START".equals(s) && !"com.iloen.melon.MELON_NOWPLAYING_START_ACTION".equals(s) && !"com.iloen.melon.MELON_LYRIC_START_ACTION".equals(s)) {
                if("com.iloen.melon.MELON_DOWNLOAD".equals(s)) {
                    Navigator.INSTANCE.openDownloadManager();
                    return h0;
                }
                if("com.iloen.melon.intent.action.download.song".equals(s) || "com.iloen.melon.intent.action.download.flac".equals(s) || "com.iloen.melon.intent.action.download.mv".equals(s)) {
                    goto label_263;
                }
                if("com.iloen.melon.MELON_START_STREAMING_ACTION".equals(s)) {
                    Bundle bundle0 = intent1.getExtras();
                    if(bundle0 != null) {
                        String s3 = bundle0.getString("com.iloen.melon.MELON_START_STREAMING_ACTION_EXTRA_SONGID");
                        if(s3 != null) {
                            Bundle bundle1 = intent1.getExtras();
                            if(bundle1 != null) {
                                String s4 = bundle1.getString("com.iloen.melon.MELON_START_STREAMING_ACTION_EXTRA_MENUID");
                                if(s4 != null) {
                                    Bundle bundle2 = intent1.getExtras();
                                    CType cType0 = CType.get((bundle2 == null ? null : bundle2.getString("com.iloen.melon.MELON_START_STREAMING_ACTION_EXTRA_CTYPE")));
                                    kotlin.jvm.internal.q.f(cType0, "get(...)");
                                    AddPlay addAction$AddPlay0 = new AddPlay(false);
                                    k8.a a1 = this.getBlockingProgressDialogManage();
                                    AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(this, AddServerContent.Companion.with(cType0, s3, s4, addAction$AddPlay0, a1), false, 2, null);
                                    return h0;
                                }
                            }
                        }
                    }
                }
                else if("com.iloen.melon.MELON_PUSH_ACT_START".equals(s)) {
                    String s5 = intent1.getStringExtra("source");
                    String s6 = intent1.getStringExtra("channel");
                    String s7 = intent1.getStringExtra("messageId");
                    String s8 = intent1.getStringExtra("object");
                    String s9 = intent1.getStringExtra("menuId");
                    boolean z3 = kotlin.jvm.internal.q.b(intent1.getStringExtra("msgType"), "INFO");
                    TrafficSource trafficSource0 = new com.kakao.tiara.data.TrafficSource.Builder().source(s5).channel(s6).object(s8).messageId(s7).build();
                    p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                    g0.I = s9;
                    g0.c = s9;
                    g0.a = "페이지 이동";
                    g0.d = ActionKind.ViewContent;
                    LogBuilder logBuilder0 = g0.a();
                    logBuilder0.trafficSource(trafficSource0);
                    logBuilder0.track();
                    if(this.getCurrentFragment() instanceof MusicMessageEditorFragment) {
                        MelonAppBase.Companion.getClass();
                        t.a().setMusicMsgFragmentVisualStatus(t.a().isMusicMessageForeground(), true);
                    }
                    else {
                        MelonAppBase.Companion.getClass();
                        t.a().setMusicMsgFragmentVisualStatus(t.a().isMusicMessageForeground(), false);
                    }
                    String s10 = intent1.getStringExtra("pid");
                    String s11 = intent1.getStringExtra("val");
                    String s12 = intent1.getStringExtra("seq");
                    String s13 = intent1.getStringExtra("from");
                    if(!TextUtils.isEmpty(s10) || !TextUtils.isEmpty(s11)) {
                        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                        melonLinkInfo0.r = z3;
                        melonLinkInfo0.a = s10;
                        if(s11 != null && Tf.v.r0(s11, "melonapp", false)) {
                            melonLinkInfo0.c = s11;
                        }
                        else if(URLUtil.isNetworkUrl(s11)) {
                            melonLinkInfo0.b = s11;
                        }
                        else if(s11 != null) {
                            Pattern pattern0 = Pattern.compile("/");
                            kotlin.jvm.internal.q.f(pattern0, "compile(...)");
                            o.P0(0);
                            Matcher matcher0 = pattern0.matcher(s11);
                            if(matcher0.find()) {
                                ArrayList arrayList0 = new ArrayList(10);
                                int v1 = 0;
                                do {
                                    v1 = androidx.appcompat.app.o.c(matcher0, s11, v1, arrayList0);
                                }
                                while(matcher0.find());
                                androidx.appcompat.app.o.w(v1, s11, arrayList0);
                                list0 = arrayList0;
                            }
                            else {
                                list0 = e.k.z(s11.toString());
                            }
                            String[] arr_s = (String[])list0.toArray(new String[0]);
                            if(arr_s.length > 2) {
                                melonLinkInfo0.g = arr_s[0];
                                melonLinkInfo0.h = "";
                            }
                            else if(arr_s.length > 1) {
                                melonLinkInfo0.g = arr_s[0];
                                melonLinkInfo0.h = arr_s[1];
                            }
                            else {
                                melonLinkInfo0.g = arr_s[0];
                                melonLinkInfo0.h = "";
                            }
                            melonLinkInfo0.i = arr_s;
                        }
                        MelonLinkExecutor.open(melonLinkInfo0);
                        if(!TextUtils.isEmpty(s13)) {
                            String s14 = kotlin.jvm.internal.q.b(s13, "popup") ? "Z14" : "Z15";
                            d5.s s15 = new d5.s();
                            s15.a = "5";
                            s15.d = s14;
                            s15.h = "V1";
                            s15.n = s12;
                            com.iloen.melon.utils.a.t(s15);
                            return h0;
                        }
                    }
                }
                else if(!"com.iloen.melon.MELON_FEED".equals(s)) {
                    if("com.iloen.melon.intent.action.setting.alarm.list".equals(s)) {
                        Navigator.INSTANCE.openMusicAlarmList();
                        return h0;
                    }
                    if("android.media.action.MEDIA_PLAY_FROM_SEARCH".equals(s)) {
                        intent1.getStringExtra("android.intent.extra.focus");
                        String s16 = intent1.getStringExtra("query");
                        String s17 = intent1.getStringExtra("android.intent.extra.album");
                        String s18 = intent1.getStringExtra("android.intent.extra.artist");
                        String s19 = intent1.getStringExtra("android.intent.extra.genre");
                        String s20 = intent1.getStringExtra("android.intent.extra.playlist");
                        String s21 = intent1.getStringExtra("android.intent.extra.title");
                        Params searchIntentListReq$Params0 = new Params();
                        searchIntentListReq$Params0.query = s16;
                        searchIntentListReq$Params0.searchSongKwd = s21;
                        searchIntentListReq$Params0.searchArtistKwd = s18;
                        searchIntentListReq$Params0.searchAlbumKwd = s17;
                        searchIntentListReq$Params0.searchGnrKwd = s19;
                        searchIntentListReq$Params0.searchPlystKwd = s20;
                        RequestBuilder.newInstance(new SearchIntentListReq(Y.a(MelonAppBase.Companion), searchIntentListReq$Params0)).tag("MusicBrowserActivity").listener(new p0(this)).errorListener(new i3.d(13)).request();
                        return h0;
                    }
                    if("com.iloen.melon.intent.action.appshortcut.search".equals(s)) {
                        f.d(uri0);
                        Navigator.openSoundSearch();
                        return h0;
                    }
                    String s22 = intent1.getStringExtra("launchMode");
                    Y.w("-launchMode : ", s22, logU$Companion0, "MusicBrowserActivity");
                    if(s22 != null) {
                        if(s22.equals("melonweburl")) {
                            Navigator.openUrl(intent1.getStringExtra("url"), OpenType.DefaultWebViewWithMiniPlayer);
                            return h0;
                        }
                    }
                    else if("android.intent.action.VIEW".equals(s) && uri0 != null) {
                        String s23 = uri0.getScheme();
                        if(s23 != null) {
                            switch(s23) {
                                case "content": 
                                case "file": {
                                    if(!Td.b.e(this, "android.permission.READ_MEDIA_AUDIO")) {
                                        this.pendingPlayScheme = uri0;
                                        return h0;
                                    }
                                    AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(this, new AddContentUri("", null, new AddPlay(false), null, uri0, 8, null), false, 2, null);
                                    return h0;
                                }
                            }
                        }
                        g g1 = this.deeplinkManager;
                        if(g1 != null) {
                            g1.c(uri0);
                            return h0;
                        label_263:
                            if("com.iloen.melon.intent.action.download.mv".equals(s)) {
                                Navigator.INSTANCE.openLocalContentMv();
                                return h0;
                            }
                            if(kotlin.jvm.internal.q.b(s, "com.iloen.melon.intent.action.download.flac")) {
                                LocalContentPagerFragment.newInstanceForFlac().open();
                                return h0;
                            }
                            LocalContentPagerFragment.newInstanceForSong().open();
                            return h0;
                        }
                    }
                }
            }
            else if("player".equals(intent1.getStringExtra("activitystartactionname"))) {
                F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                if("com.iloen.melon.MELON_NOWPLAYING_START_ACTION".equals(s)) {
                    f0.a = 1;
                }
                else if("com.iloen.melon.MELON_LYRIC_START_ACTION".equals(s)) {
                    f0.a = 2;
                }
                Serializable serializable3 = com.kakao.sdk.common.util.a.h(intent1);
                switch((((Actor)serializable3) == null ? -1 : k8.c0.a[((Actor)serializable3).ordinal()])) {
                    case 1: {
                        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new n0(this, f0, null), 2, null);
                        MusicBrowserActivity.trackTiaraForCoverWidget$default(this, intent1, false, 2, null);
                        return h0;
                    }
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: {
                        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new o0(this, f0, null), 2, null);
                        if("com.iloen.melon.MELON_PLAYER_START".equals(s)) {
                            kotlin.jvm.internal.q.f("플레이어 전환", "getString(...)");
                            this.trackTiaraForHomeWidget(((Actor)serializable3), "플레이어 전환");
                            return h0;
                        }
                        if("com.iloen.melon.MELON_LYRIC_START_ACTION".equals(s)) {
                            kotlin.jvm.internal.q.f("가사보기", "getString(...)");
                            this.trackTiaraForHomeWidget(((Actor)serializable3), "가사보기");
                            return h0;
                        }
                        if(Actor.Widget_4x2 == ((Actor)serializable3) && "com.iloen.melon.MELON_NOWPLAYING_START_ACTION".equals(s)) {
                            kotlin.jvm.internal.q.f("재생목록", "getString(...)");
                            this.trackTiaraForHomeWidget(((Actor)serializable3), "재생목록");
                            return h0;
                        }
                        break;
                    }
                    default: {
                        int v2 = f0.a;
                        if(v2 == 1) {
                            Navigator.INSTANCE.openNowPlayList();
                            return h0;
                        }
                        Navigator.INSTANCE.openNowPlayer(v2);
                        return h0;
                    }
                }
            }
        }
        return h0;
    }

    private static final void handleIntent$lambda$50(VolleyError volleyError0) {
        String s = HttpResponse.Companion.getErrorMessage(volleyError0);
        LogU.Companion.w("MusicBrowserActivity", "onErrorResponse() " + s);
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void handleLaunchIntent() {
        if(this.getIntent() == null || this.getIntent().hasCategory("android.intent.category.LAUNCHER")) {
            if(!NetUtils.isConnected() && k9.j.a() != 1) {
                this.showDialogOfflinePayback(this.getIntent());
            }
            else if(AndroidSettings.isAirplaneMode()) {
                this.showDialogOnAirplane();
            }
            else if(!NetUtils.isConnected()) {
                this.showDialogOnNetworkOff();
            }
            if(Td.b.d(this)) {
                MusicBrowserActivity.checkRuntimePermission$default(this, 0, 1, null);
            }
        }
        else if(!this.isFinishing()) {
            if(!NetUtils.isConnected() && k9.j.a() != 1) {
                this.showDialogOfflinePayback(this.getIntent());
            }
            else if(AndroidSettings.isAirplaneMode()) {
                this.showDialogOnAirplane();
            }
            else if(!NetUtils.isConnected()) {
                this.showDialogOnNetworkOff();
            }
            if(Td.b.d(this)) {
                this.checkRuntimePermission(500);
            }
        }
    }

    public final void handlePendingIntent() {
        if(this.pendingIntent != null && !Airbridge.handleDeeplink(this.pendingIntent, new i3.d(14))) {
            BottomTabPagerAdapter bottomTabPagerAdapter0 = this.getBottomTabPagerAdapter();
            if(bottomTabPagerAdapter0.isAllTabFragmentCreated()) {
                this.handlePendingIntentAsync();
                return;
            }
            bottomTabPagerAdapter0.setBottomTabPagerEventListener(new q0(this));
        }
    }

    private static final void handlePendingIntent$lambda$16$lambda$13(Uri uri0) {
        kotlin.jvm.internal.q.g(uri0, "uri");
        MelonLinkExecutor.open(uri0.toString());
    }

    private final void handlePendingIntentAsync() {
        Intent intent0 = this.pendingIntent;
        this.pendingIntent = null;
        if(intent0 != null) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new r0(this, intent0, null), 2, null);
        }
    }

    private final void handleScreenCapture() {
        androidx.fragment.app.I i0 = this.floatingFragment == null || !this.floatingFragment.isFullCover() ? this.getFragment() : this.floatingFragment;
        if(i0 != null) {
            Sd.d d0 = this.screenCaptureHelper;
            d0.getClass();
            if(i0 instanceof IFragmentContainer) {
                i0 = ((IFragmentContainer)i0).getCurrentFragment();
            }
            Nc.f f0 = new Nc.f(i0, 10);
            Sd.a a0 = null;
            Db.i.a(d0.a, null, f0, 3);
            if(i0 instanceof Sd.a) {
                a0 = (Sd.a)i0;
            }
            if(a0 != null) {
                a0.onScreenCaptured();
            }
        }
    }

    private final void hideAnimationAndBadge(int v) {
        BottomNavigationView bottomNavigationView0 = this.bottomNavigationView;
        if(bottomNavigationView0 != null) {
            Object object0 = null;
            View view0 = bottomNavigationView0.getChildAt(0);
            kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationMenuView");
            View view1 = ((BottomNavigationMenuView)view0).getChildAt(v);
            kotlin.jvm.internal.q.e(view1, "null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationItemView");
            for(Object object1: this.bottomTabViewGroup) {
                if(((Z)object1).a == v) {
                    object0 = object1;
                    break;
                }
            }
            if(((Z)object0) != null) {
                Job job0 = ((Z)object0).g;
                if(job0 != null) {
                    DefaultImpls.cancel$default(job0, null, 1, null);
                }
            }
            ViewUtils.hideWhen(((BottomNavigationItemView)view1).findViewById(0x7F0A0D94), true);  // id:v_badge
            return;
        }
        kotlin.jvm.internal.q.m("bottomNavigationView");
        throw null;
    }

    private final void hideRuntimePermissionGuide() {
        this.viewStubLayoutPermission = null;
        ViewUtils.hideWhen(this.findViewById(0x7F0A0734), true);  // id:layout_permission_check_container
    }

    private final void ignoreBottomNavigationLongClick(BottomNavigationView bottomNavigationView0) {
        if(bottomNavigationView0 != null && bottomNavigationView0.getChildCount() > 0) {
            View view0 = bottomNavigationView0.getChildAt(0);
            kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type android.view.ViewGroup");
            int v = ((ViewGroup)view0).getChildCount();
            if(v > 0) {
                for(int v1 = 0; v1 < v && ((ViewGroup)view0).getChildAt(v1) != null; ++v1) {
                    ((ViewGroup)view0).getChildAt(v1).setOnLongClickListener(new X());  // 初始化器: Ljava/lang/Object;-><init>()V
                    ((ViewGroup)view0).getChildAt(v1).setHapticFeedbackEnabled(false);
                }
            }
        }
    }

    private static final boolean ignoreBottomNavigationLongClick$lambda$45(View view0) [...] // Inlined contents

    private final void inflatePermissionCheckView() {
        if(this.viewStubLayoutPermission == null) {
            ViewStub viewStub0 = (ViewStub)this.findViewById(0x7F0A0AF4);  // id:stub_layout_permission_check_container
            this.viewStubLayoutPermission = viewStub0;
            if(viewStub0 != null) {
                viewStub0.inflate();
            }
        }
    }

    private final void initBottomNavigation() {
        BottomNavigationView bottomNavigationView0 = this.bottomNavigationView;
        if(bottomNavigationView0 != null) {
            M.n(bottomNavigationView0, null);
            BottomNavigationView bottomNavigationView1 = this.bottomNavigationView;
            if(bottomNavigationView1 != null) {
                bottomNavigationView1.setOnItemSelectedListener(new j3.n(this, 1));
                BottomNavigationView bottomNavigationView2 = this.bottomNavigationView;
                if(bottomNavigationView2 != null) {
                    View view0 = bottomNavigationView2.getChildAt(0);
                    kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationMenuView");
                    int v1 = ((BottomNavigationMenuView)view0).getChildCount();
                    for(int v = 0; v < v1; ++v) {
                        View view1 = ((BottomNavigationMenuView)view0).getChildAt(v);
                        BottomNavigationItemView bottomNavigationItemView0 = view1 instanceof BottomNavigationItemView ? ((BottomNavigationItemView)view1) : null;
                        if(bottomNavigationItemView0 != null) {
                            bottomNavigationItemView0.setAccessibilityDelegate(new com.google.android.material.textfield.n(this, 1));
                        }
                    }
                    BottomNavigationView bottomNavigationView3 = this.bottomNavigationView;
                    if(bottomNavigationView3 != null) {
                        this.ignoreBottomNavigationLongClick(bottomNavigationView3);
                        return;
                    }
                    kotlin.jvm.internal.q.m("bottomNavigationView");
                    throw null;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
            kotlin.jvm.internal.q.m("bottomNavigationView");
            throw null;
        }
        kotlin.jvm.internal.q.m("bottomNavigationView");
        throw null;
    }

    private static final boolean initBottomNavigation$lambda$42(MusicBrowserActivity musicBrowserActivity0, MenuItem menuItem0) {
        String s;
        kotlin.jvm.internal.q.g(menuItem0, "item");
        switch(menuItem0.getItemId()) {
            case 0x7F0A089C: {  // id:navigation_foryou
                musicBrowserActivity0.lastTabIndex = 1;
                s = "ForYou";
                kotlin.jvm.internal.q.f("ForYou", "getString(...)");
                break;
            }
            case 0x7F0A089E: {  // id:navigation_home
                musicBrowserActivity0.lastTabIndex = 0;
                s = "홈";
                kotlin.jvm.internal.q.f("홈", "getString(...)");
                break;
            }
            case 0x7F0A089F: {  // id:navigation_library
                musicBrowserActivity0.lastTabIndex = 3;
                s = "음악서랍";
                kotlin.jvm.internal.q.f("음악서랍", "getString(...)");
                break;
            }
            case 0x7F0A08A0: {  // id:navigation_menu
                musicBrowserActivity0.lastTabIndex = 4;
                s = "바로가기";
                kotlin.jvm.internal.q.f("바로가기", "getString(...)");
                break;
            }
            case 0x7F0A08A1: {  // id:navigation_search
                musicBrowserActivity0.lastTabIndex = 2;
                s = "탐색";
                kotlin.jvm.internal.q.f("탐색", "getString(...)");
                break;
            }
            default: {
                s = "";
            }
        }
        b0 b00 = musicBrowserActivity0.onBottomTabSelectedListener;
        if(b00 != null) {
            ((MusicBrowserActivity)((Ga)b00).b).hideAnimationAndBadge(musicBrowserActivity0.lastTabIndex);
        }
        musicBrowserActivity0.getMainBottomTabViewModel().g.put(musicBrowserActivity0.lastTabIndex, Boolean.TRUE);
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = musicBrowserActivity0.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.setLastTabIndexIndex(musicBrowserActivity0.lastTabIndex);
        }
        NonSwipeableViewPager nonSwipeableViewPager0 = musicBrowserActivity0.viewPager;
        if(nonSwipeableViewPager0 != null) {
            int v = musicBrowserActivity0.lastTabIndex;
            if(nonSwipeableViewPager0.getCurrentItem() == v) {
                BottomTabBaseFragment bottomTabBaseFragment0 = musicBrowserActivity0.getCurrentTabContainerFragment();
                if(bottomTabBaseFragment0 == null) {
                    musicBrowserActivity0.trackBottomTab(s);
                    return true;
                }
                if(bottomTabBaseFragment0.isRootFragment()) {
                    if(AppUtils.isAccessibilityTalkbackOn()) {
                        bottomTabBaseFragment0.forceRefresh();
                        musicBrowserActivity0.trackBottomTab(s);
                        return true;
                    }
                    bottomTabBaseFragment0.scrollToTop(false);
                    musicBrowserActivity0.trackBottomTab(s);
                    return true;
                }
                musicBrowserActivity0.clearTabStack(musicBrowserActivity0.lastTabIndex);
                musicBrowserActivity0.trackBottomTab(s);
                return true;
            }
            NonSwipeableViewPager nonSwipeableViewPager1 = musicBrowserActivity0.viewPager;
            if(nonSwipeableViewPager1 != null) {
                nonSwipeableViewPager1.setCurrentItem(v, false);
                musicBrowserActivity0.trackBottomTab(s);
                return true;
            }
            kotlin.jvm.internal.q.m("viewPager");
            throw null;
        }
        kotlin.jvm.internal.q.m("viewPager");
        throw null;
    }

    private final void initBottomNavigationBadgeView(Tc.c c0) {
        if(!c0.b.isEmpty()) {
            for(Object object0: c0.b) {
                Tc.a a0 = (Tc.a)object0;
                if(a0.a == 0 || !a0.b) {
                    continue;
                }
                BottomNavigationView bottomNavigationView0 = this.bottomNavigationView;
                if(bottomNavigationView0 != null) {
                    View view0 = bottomNavigationView0.getChildAt(0);
                    kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationMenuView");
                    View view1 = ((BottomNavigationMenuView)view0).getChildAt(a0.a);
                    kotlin.jvm.internal.q.e(view1, "null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationItemView");
                    View view2 = LayoutInflater.from(this).inflate(0x7F0D005C, ((BottomNavigationMenuView)view0), false);  // layout:bottom_tab_badge
                    FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(view2.getLayoutParams());
                    frameLayout$LayoutParams0.gravity = 1;
                    ((BottomNavigationItemView)view1).addView(view2, frameLayout$LayoutParams0);
                    continue;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
        }
    }

    private final void initBottomNavigationIconView(Tc.c c0) {
        if(!c0.a.isEmpty()) {
            this.bottomTabViewGroup.clear();
            for(Object object0: c0.a) {
                String s = ((Tc.b)object0).b.getVisible();
                BottomNavigationView bottomNavigationView0 = this.bottomNavigationView;
                if(bottomNavigationView0 != null) {
                    View view0 = bottomNavigationView0.getChildAt(0);
                    kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationMenuView");
                    View view1 = ((BottomNavigationMenuView)view0).getChildAt(((Tc.b)object0).a);
                    kotlin.jvm.internal.q.e(view1, "null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationItemView");
                    View view2 = LayoutInflater.from(this).inflate(0x7F0D0512, ((BottomNavigationMenuView)view0), false);  // layout:menu_tab_layout
                    View view3 = view2.findViewById(0x7F0A07FA);  // id:menu_tab_icon
                    FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(view2.getLayoutParams());
                    frameLayout$LayoutParams0.gravity = 1;
                    View view4 = ((BottomNavigationItemView)view1).findViewById(0x7F0A0898);  // id:navigation_bar_item_icon_view
                    ((BottomNavigationItemView)view1).addView(view2, frameLayout$LayoutParams0);
                    List list0 = this.bottomTabViewGroup;
                    String s1 = ((Tc.b)object0).b.getIconUrl();
                    kotlin.jvm.internal.q.d(((ImageView)view4));
                    kotlin.jvm.internal.q.d(((MelonImageView)view3));
                    list0.add(new Z(((Tc.b)object0).a, (s == null ? "" : s), (s1 == null ? "" : s1), view2, ((ImageView)view4), ((MelonImageView)view3), null));
                    continue;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
        }
    }

    private final void initBottomNavigationListener() {
        this.onBottomTabSelectedListener = new Ga(this, 26);
    }

    private final void initDatabaseFile() {
        ContentProviderClient contentProviderClient0;
        LogU.Companion.d("MusicBrowserActivity", "initDatabaseFile() CALL");
        if(!StorageUtils.isScopedStorage()) {
            m.b(this.getApplicationContext());
            synchronized(R8.q.a) {
                LogU.i("DrmHelper", "reInitDeviceDrmType()");
                R8.q.a.a = -1;
                R8.q.a.b();
            }
            m.a(this.getApplicationContext(), m.a);
            ContentProvider contentProvider0 = null;
            try {
                contentProviderClient0 = this.getApplicationContext().getContentResolver().acquireContentProviderClient(i9.n.a);
                goto label_19;
            }
            catch(Exception exception0) {
                try {
                    contentProviderClient0 = null;
                    exception0.printStackTrace();
                    goto label_28;
                label_19:
                    if(contentProviderClient0 == null) {
                        goto label_21;
                    }
                    else {
                        try {
                            contentProvider0 = contentProviderClient0.getLocalContentProvider();
                        label_21:
                            if(((MelonMediaProvider)contentProvider0) != null) {
                                ((MelonMediaProvider)contentProvider0).o();
                            }
                            if(((MelonMediaProvider)contentProvider0) != null) {
                                ((MelonMediaProvider)contentProvider0).j();
                            }
                            goto label_34;
                        }
                        catch(Exception exception1) {
                        }
                    }
                    exception1.printStackTrace();
                }
                catch(Throwable throwable0) {
                    goto label_32;
                }
            }
        label_28:
            if(contentProviderClient0 != null) {
                contentProviderClient0.close();
                return;
            label_32:
                TWR.safeClose$NT(contentProviderClient0, throwable0);
                throw throwable0;
            label_34:
                if(contentProviderClient0 != null) {
                    contentProviderClient0.close();
                }
            }
        }
    }

    private final void initDebugViewIfNeed() {
        if(!A8.b.e()) {
            View view0 = ((ViewStub)this.findViewById(0x7F0A0AF1)).inflate();  // id:stub_debug_container
            if(MelonPrefs.getInstance().getBoolean("SHOW_SP_DEBUGGING_INFO", false)) {
                TextView textView0 = (TextView)view0.findViewById(0x7F0A07ED);  // id:mcp_debug_tv
                textView0.setVisibility(0);
                BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new v0(this, textView0, null), 3, null);
            }
            TextView textView1 = (TextView)view0.findViewById(0x7F0A01C8);  // id:build_info
            textView1.setText(A8.b.a + "-20250902(72f18bf)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new y0(this, textView1, null), 3, null);
            TextView textView2 = (TextView)view0.findViewById(0x7F0A00CF);  // id:audio_effect_loudness_info
            TextView textView3 = (TextView)view0.findViewById(0x7F0A00D0);  // id:audio_effect_setting_info
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new B0(this, textView2, textView3, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new F0(this, textView2, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new I0(this, textView3, null), 3, null);
        }
    }

    private final void initFloatingFragment() {
        FloatingFragment floatingFragment0 = (FloatingFragment)this.getSupportFragmentManager().D(0x7F0A07CD);  // id:main_player_container
        this.floatingFragment = floatingFragment0;
        if(floatingFragment0 != null) {
            this.connectVideoAndBottomTabLayout(floatingFragment0);
        }
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new L0(this, null), 2, null);
    }

    private final void initGoogleIap() {
        Application application0 = this.getApplication();
        kotlin.jvm.internal.q.e(application0, "null cannot be cast to non-null type com.iloen.melon.MelonAppBase");
        Y8.d d0 = ((MelonAppBase)application0).getGoogleIapLifecycle();
        this.googleIapClientLifecycle = d0;
        if(d0 != null) {
            androidx.lifecycle.q0 q00 = this.getViewModelStore();
            androidx.lifecycle.o0 o00 = this.getDefaultViewModelProviderFactory();
            S2.c c0 = this.getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.q.g(q00, "store");
            kotlin.jvm.internal.q.g(o00, "factory");
            o9.b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
            De.d d1 = df.d.y(h.class);
            String s = d1.l();
            if(s == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.googleIapViewModel = (h)b0.s(d1, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
            this.getLifecycle().a(d0);
            h h0 = this.googleIapViewModel;
            if(h0 != null) {
                SingleLiveEvent singleLiveEvent0 = h0.f;
                if(singleLiveEvent0 != null) {
                    singleLiveEvent0.observe(this, new d1(1, new R7(20, d0, this)));
                }
            }
            d1 d10 = new d1(1, new O(this, 0));
            d0.c.observe(this, d10);
        }
    }

    private static final H initGoogleIap$lambda$9$lambda$7(Y8.d d0, MusicBrowserActivity musicBrowserActivity0, BillingFlowParams billingFlowParams0) {
        kotlin.jvm.internal.q.g(billingFlowParams0, "billingFlowParams");
        LogU.Companion.d("MusicBrowserActivity", "initGoogleIap()#getEventBuy()#onChanged");
        d0.getClass();
        kotlin.jvm.internal.q.g(musicBrowserActivity0, "activity");
        BillingClient billingClient0 = d0.b;
        if(billingClient0 != null) {
            if(!billingClient0.isReady()) {
                Log.e("BillingClientLifecycle", "launchBillingFlow: BillingClient is not ready");
            }
            BillingClient billingClient1 = d0.b;
            if(billingClient1 != null) {
                BillingResult billingResult0 = billingClient1.launchBillingFlow(musicBrowserActivity0, billingFlowParams0);
                kotlin.jvm.internal.q.f(billingResult0, "launchBillingFlow(...)");
                String s = billingResult0.getDebugMessage();
                kotlin.jvm.internal.q.f(s, "getDebugMessage(...)");
                Log.d("BillingClientLifecycle", "launchBillingFlow: BillingResponse " + billingResult0.getResponseCode() + " " + s);
                return H.a;
            }
            kotlin.jvm.internal.q.m("billingClient");
            throw null;
        }
        kotlin.jvm.internal.q.m("billingClient");
        throw null;
    }

    private static final H initGoogleIap$lambda$9$lambda$8(MusicBrowserActivity musicBrowserActivity0, Y8.e e0) {
        kotlin.jvm.internal.q.g(e0, "purchaseUpdateData");
        int v = e0.a;
        Y.t("initGoogleIap()#getPurchaseUpdateEvent()#onChanged resultCode:", v, LogU.Companion, "MusicBrowserActivity");
        h h0 = musicBrowserActivity0.googleIapViewModel;
        if(h0 != null) {
            h0.b(v, e0.b);
        }
        return H.a;
    }

    private final void initHighContrastColor() {
        A8.i.a = ColorUtils.getColor(this, 0x7F060189);  // color:hc_green500e
        A8.i.b = ColorUtils.getColor(this, 0x7F06018A);  // color:hc_green500s
        A8.i.c = ColorUtils.getColor(this, 0x7F06018C);  // color:hc_green502s
        A8.i.f = ColorUtils.getColor(this, 0x7F060185);  // color:hc_gray500s
        A8.i.g = ColorUtils.getColor(this, 0x7F060184);  // color:hc_gray400s
        A8.i.h = ColorUtils.getColor(this, 0x7F060183);  // color:hc_gray200s
        A8.i.i = ColorUtils.getColor(this, 0x7F060182);  // color:hc_gray100s
        A8.i.j = ColorUtils.getColor(this, 0x7F06018D);  // color:hc_white000s
        A8.i.k = ColorUtils.getColor(this, 0x7F060187);  // color:hc_gray920e
        A8.i.l = ColorUtils.getColor(this, 0x7F060188);  // color:hc_gray920e_10
        A8.i.m = ColorUtils.getColor(this, 0x7F060181);  // color:hc_gray001e
        A8.i.n = ColorUtils.getColor(this, 0x7F060191);  // color:hc_white500e
        A8.i.o = ColorUtils.getColor(this, 0x7F060190);  // color:hc_white400e
        A8.i.p = ColorUtils.getColor(this, 0x7F06018F);  // color:hc_white300e
        A8.i.q = ColorUtils.getColor(this, 0x7F06018E);  // color:hc_white160e
        A8.i.r = ColorUtils.getColor(this, 0x7F060180);  // color:hc_blue400s
    }

    private final void initIap() {
        if(kotlin.jvm.internal.q.b(BillingUtils.getBillingType(), "GOOGLE")) {
            this.initGoogleIap();
            return;
        }
        if(kotlin.jvm.internal.q.b(BillingUtils.getBillingType(), "ONE_STORE")) {
            this.initOneStoreIap();
        }
    }

    private final void initOneStoreIap() {
        Application application0 = this.getApplication();
        kotlin.jvm.internal.q.e(application0, "null cannot be cast to non-null type com.iloen.melon.MelonAppBase");
        Z8.g g0 = ((MelonAppBase)application0).getOneStoreIapLifecycle();
        this.oneStoreIapClientLifecycle = g0;
        if(g0 != null) {
            androidx.lifecycle.q0 q00 = this.getViewModelStore();
            androidx.lifecycle.o0 o00 = this.getDefaultViewModelProviderFactory();
            S2.c c0 = this.getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.q.g(q00, "store");
            kotlin.jvm.internal.q.g(o00, "factory");
            o9.b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
            De.d d0 = df.d.y(k.class);
            String s = d0.l();
            if(s == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.oneStoreIapViewModel = (k)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
            this.getLifecycle().a(g0);
            k k0 = this.oneStoreIapViewModel;
            if(k0 != null) {
                SingleLiveEvent singleLiveEvent0 = k0.b;
                if(singleLiveEvent0 != null) {
                    singleLiveEvent0.observe(this, new d1(1, new k8.S(g0, this, 0)));
                }
            }
            d1 d10 = new d1(1, new k8.S(g0, this, 1));
            g0.e.observe(this, d10);
        }
    }

    private static final H initOneStoreIap$lambda$12$lambda$10(Z8.g g0, MusicBrowserActivity musicBrowserActivity0, Z8.h h0) {
        kotlin.jvm.internal.q.d(h0);
        g0.getClass();
        kotlin.jvm.internal.q.g(musicBrowserActivity0, "activity");
        Log.i("OneStoreIapClientLifecycle", "launchPurchaseFlow()");
        if(!g0.h) {
            Log.w("OneStoreIapClientLifecycle", "launchPurchaseFlow() purchaseFlowParamsInProgress ERROR_NEED_TO_LOGIN");
            Z8.g.f(g0, 20003, true, null, 10);
            return H.a;
        }
        g0.b(new Z1(h0, g0, musicBrowserActivity0, 13));
        return H.a;
    }

    private static final H initOneStoreIap$lambda$12$lambda$11(Z8.g g0, MusicBrowserActivity musicBrowserActivity0, Z8.i i0) {
        kotlin.jvm.internal.q.g(i0, "refreshData");
        int v = i0.a;
        Y.t("initOneStoreIap()#refreshEvent()#onChanged resultCode:", v, LogU.Companion, "MusicBrowserActivity");
        switch(v) {
            case 20003: {
                g0.getClass();
                kotlin.jvm.internal.q.g(musicBrowserActivity0, "activity");
                com.gaa.sdk.auth.d d0 = g0.c;
                if(d0 != null) {
                    d0.b(new com.gaa.sdk.auth.a(d0, new Z8.b(g0, 2), musicBrowserActivity0, 0));
                    break;
                }
                kotlin.jvm.internal.q.m("signInClient");
                throw null;
            }
            case 20004: {
                g0.getClass();
                kotlin.jvm.internal.q.g(musicBrowserActivity0, "activity");
                g0.b(new Dc.i(27, g0, musicBrowserActivity0));
            }
        }
        k k0 = musicBrowserActivity0.oneStoreIapViewModel;
        if(k0 != null) {
            k0.c.postValue(i0);
        }
        return H.a;
    }

    private final void initViewPager() {
        View view0 = this.findViewById(0x7F0A0DD6);  // id:viewpager
        kotlin.jvm.internal.q.f(view0, "findViewById(...)");
        this.viewPager = (NonSwipeableViewPager)view0;
        l0 l00 = this.getSupportFragmentManager();
        kotlin.jvm.internal.q.f(l00, "getSupportFragmentManager(...)");
        this.tabPagerAdapter = new BottomTabPagerAdapter(l00);
        NonSwipeableViewPager nonSwipeableViewPager0 = this.viewPager;
        if(nonSwipeableViewPager0 != null) {
            nonSwipeableViewPager0.setPagingEnabled(false);
            NonSwipeableViewPager nonSwipeableViewPager1 = this.viewPager;
            if(nonSwipeableViewPager1 != null) {
                nonSwipeableViewPager1.setOffscreenPageLimit(4);
                this.initBottomNavigation();
                return;
            }
            kotlin.jvm.internal.q.m("viewPager");
            throw null;
        }
        kotlin.jvm.internal.q.m("viewPager");
        throw null;
    }

    public final boolean isFullyCoveredByFloatingFragment() {
        return this.floatingFragment == null ? false : this.floatingFragment.isFullCover();
    }

    public final boolean isShowRuntimePermissionGuide() {
        MelonAppBase.Companion.getClass();
        return !Td.b.d(t.a().getContext()) || this.viewStubLayoutPermission != null;
    }

    private final boolean isSplashShowing() {
        return this.splashPopup == null ? false : this.splashPopup.isShowing();
    }

    public final boolean isTabAndMiniPlayerVisibilityAnimationPlaying() {
        return this.isTabAndMiniPlayerVisibilityAnimationPlaying;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public boolean isTabInitialized() {
        return this.getMainBottomTabViewModel().f;
    }

    public static void k0(VolleyError volleyError0) {
        MusicBrowserActivity.handleIntent$lambda$50(volleyError0);
    }

    public static boolean m0(MusicBrowserActivity musicBrowserActivity0, MenuItem menuItem0) {
        return MusicBrowserActivity.initBottomNavigation$lambda$42(musicBrowserActivity0, menuItem0);
    }

    private final void migrateLocalPlaylist() {
        if(!MelonPrefs.getInstance().getBoolean("LOCAL_PLAYLIST_MIGRATION", false)) {
            MelonAppBase.Companion.getClass();
            Context context0 = t.a().getContext();
            kotlin.jvm.internal.q.g(context0, "context");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new G8.j(context0, null), 3, null);
        }
    }

    @Override  // com.iloen.melon.activity.BaseActivity
    public void onBackPressedCallback() {
        if(this.floatingFragment != null && this.floatingFragment.onBackPressed()) {
            return;
        }
        BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
        if(bottomTabBaseFragment0 == null) {
        label_9:
            if(bottomTabBaseFragment0 != null) {
                l0 l00 = bottomTabBaseFragment0.getChildFragmentManager();
                if(l00 != null) {
                    if(l00.J() <= 1) {
                        this.processBackKey();
                        return;
                    }
                    this.resetBackKeyTimer();
                    this.removeFragment();
                }
            }
        }
        else {
            androidx.fragment.app.I i0 = bottomTabBaseFragment0.getFragment();
            if(i0 instanceof MelonBaseFragment) {
                if(!((MelonBaseFragment)i0).onBackPressed()) {
                    goto label_9;
                }
            }
            else if(!(i0 instanceof c0) || !((c0)i0).onBackPressed()) {
                goto label_9;
            }
        }
    }

    public final void onChangedPermissionView(int v) {
        View view0 = this.findViewById(0x7F0A0911);  // id:permission_reject_container
        View view1 = this.findViewById(0x7F0A02CA);  // id:close_btn
        switch(v) {
            case 1: {
                View view2 = this.findViewById(0x7F0A0913);  // id:permission_required_container
                TextView textView0 = (TextView)this.findViewById(0x7F0A0914);  // id:permission_required_description
                View view3 = this.findViewById(0x7F0A0118);  // id:bottom_container
                view2.setVisibility(8);
                view3.setVisibility(8);
                ViewUtils.hideWhen(textView0, true);
                View view4 = this.findViewById(0x7F0A0A75);  // id:setting_btn
                view0.setVisibility(0);
                view1.setVisibility(0);
                ViewUtils.setOnClickListener(view1, new k8.P(this, 0));
                ViewUtils.setOnClickListener(view4, new k8.P(this, 1));
                return;
            }
            case 2: {
                view0.setVisibility(8);
                view1.setVisibility(8);
            }
        }
    }

    private static final void onChangedPermissionView$lambda$17(MusicBrowserActivity musicBrowserActivity0, View view0) {
        musicBrowserActivity0.finish();
    }

    private static final void onChangedPermissionView$lambda$18(MusicBrowserActivity musicBrowserActivity0, View view0) {
        musicBrowserActivity0.startActivity(SystemSettingUtils.getLaunchAppInfoIntent("com.iloen.melon"));
    }

    private final void onCompleteCheckPermission(boolean z) {
        this.checkingNotificationPermission = false;
        this.initDatabaseFile();
        this.checkGooglePlayService();
        if(z) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new P0(this, null), 3, null);
        }
        ViewUtils.setOrientation(this, 13);
        this.hideRuntimePermissionGuide();
        this.syncStatusBarModeWithCurrentFragment();
        MelonDevReportKt.reportAppPreferenceIfNeed(this.getBaseContext(), "MusicBrowserActivity");
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new Q0(this, null), 3, null);
        this.migrateLocalPlaylist();
        if(this.pendingPlayScheme != null) {
            AddPlay addAction$AddPlay0 = new AddPlay(false);
            Uri uri0 = this.pendingPlayScheme;
            kotlin.jvm.internal.q.d(uri0);
            AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(this, new AddContentUri("", null, addAction$AddPlay0, null, uri0, 8, null), false, 2, null);
            this.pendingPlayScheme = null;
        }
        MelonAppBase.Companion.getClass();
        Context context0 = t.a().getContext();
        u9.f.g.b(context0, "lyric").b();
    }

    public static void onCompleteCheckPermission$default(MusicBrowserActivity musicBrowserActivity0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCompleteCheckPermission");
        }
        if((v & 1) != 0) {
            z = false;
        }
        musicBrowserActivity0.onCompleteCheckPermission(z);
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        kotlin.jvm.internal.q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        BottomTabBaseFragment bottomTabBaseFragment0 = this.getCurrentTabContainerFragment();
        if(bottomTabBaseFragment0 != null) {
            bottomTabBaseFragment0.onConfigurationChanged(configuration0);
        }
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.onConfigurationChanged(configuration0);
        }
    }

    @Override  // com.iloen.melon.activity.BaseActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        LogU.Companion.v("MusicBrowserActivity", "onCreate() savedInstanceState: " + bundle0);
        if(!this.lastHighContrastMode && ScreenUtils.INSTANCE.isHighContrastMode()) {
            this.setTheme(0x7F140171);  // style:HighContrastAppTheme
        }
        this.initHighContrastColor();
        FloatingLyricHelper.requestStopFloatingLyric();
        MelonFragmentManager.getInstance().initialize(this);
        BadgeUtils.setBadge(this, 0);
        this.pendingIntent = this.getIntent();
        this.deeplinkManager = new g(this);
        MelonAppBase.Companion.getClass();
        t.a().setAppPip(this.isInPictureInPictureMode());
        this.setContentView(0x7F0D001E);  // layout:activity_main
        this.rootView = this.findViewById(0x7F0A0A0E);  // id:root_view
        this.mainContainer = this.findViewById(0x7F0A07C8);  // id:main_container
        this.otherLayoutContainer = this.findViewById(0x7F0A08EC);  // id:other_layout_container
        this.ctlBottom = (ConstraintLayout)this.findViewById(0x7F0A036D);  // id:ctl_bottom
        this.videoMiniPlayerGap = this.findViewById(0x7F0A0DB6);  // id:video_mini_player_gap
        this.bottomNavigationContainer = this.findViewById(0x7F0A0123);  // id:bottom_navigation_container
        View view0 = this.findViewById(0x7F0A0122);  // id:bottom_navigation
        kotlin.jvm.internal.q.f(view0, "findViewById(...)");
        this.bottomNavigationView = (BottomNavigationView)view0;
        this.setScreenFlagsOnWindow();
        if(bundle0 == null) {
            this.handleLaunchIntent();
        }
        this.registerIntentFilter();
        this.buildGoogleApiClient();
        if(bundle0 == null) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new R0(this, null), 2, null);
        }
        this.checkAndUpdateScreenResolution();
        this.initIap();
        this.initFloatingFragment();
        this.setPlaylistIdObserver();
        DynamicShortcutKt.pushMelonDynamicShortcut(t.a().getContext());
        this.notificationHelper = new NotificationHelper(this);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new S0(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new Md.b(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        MusicAlarmPrefsHelper.INSTANCE.migrationSingleToMultiple(this);
        this.initDebugViewIfNeed();
        this.registerIsLoginFlow();
        this.registerTokenCheckAtForeground();
        this.initViewPager();
        if(bundle0 != null) {
            BottomTabPagerAdapter bottomTabPagerAdapter0 = this.tabPagerAdapter;
            if(bottomTabPagerAdapter0 != null) {
                l0 l00 = this.getSupportFragmentManager();
                kotlin.jvm.internal.q.f(l00, "getSupportFragmentManager(...)");
                bottomTabPagerAdapter0.restoreBottomTabState(l00);
                goto label_51;
            }
            kotlin.jvm.internal.q.m("tabPagerAdapter");
            throw null;
        }
    label_51:
        if(bundle0 == null || !bundle0.containsKey("ARG_LAST_TAB_INDEX")) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new U0(this, null), 3, null);
        }
        else {
            this.lastTabIndex = bundle0.getInt("ARG_LAST_TAB_INDEX");
            NonSwipeableViewPager nonSwipeableViewPager0 = this.viewPager;
            if(nonSwipeableViewPager0 != null) {
                BottomTabPagerAdapter bottomTabPagerAdapter1 = this.tabPagerAdapter;
                if(bottomTabPagerAdapter1 != null) {
                    nonSwipeableViewPager0.setAdapter(bottomTabPagerAdapter1);
                    this.getMainBottomTabViewModel().f = true;
                    this.selectBottomNavigation(this.lastTabIndex);
                    View view1 = this.bottomNavigationContainer;
                    if(view1 != null) {
                        view1.setVisibility(0);
                    }
                    this.onCreateMiniPlayer();
                    this.handlePendingIntent();
                    Airbridge.handleDeferredDeeplink(new i3.d(15));
                    return;
                }
                kotlin.jvm.internal.q.m("tabPagerAdapter");
                throw null;
            }
            kotlin.jvm.internal.q.m("viewPager");
            throw null;
        }
        Airbridge.handleDeferredDeeplink(new i3.d(15));
    }

    private static final void onCreate$lambda$1(Uri uri0) {
        if(uri0 != null) {
            MelonLinkExecutor.open(uri0.toString());
        }
    }

    private final void onCreateMiniPlayer() {
        View view0;
        LogU.debug$default(this.log, "onCreateMiniPlayer()", null, false, 6, null);
        ViewGroup viewGroup0 = (ViewGroup)this.findViewById(0x7F0A080B);  // id:miniplayer_container
        this.miniPlayerContainer = viewGroup0;
        if(viewGroup0 == null) {
            view0 = null;
        }
        else {
            c2.Y y0 = new c2.Y(viewGroup0, 0);
            view0 = (View)(y0.hasNext() ? y0.next() : null);
        }
        ComposeView composeView0 = view0 instanceof ComposeView ? ((ComposeView)view0) : null;
        if(composeView0 != null) {
            LogU.debug$default(this.log, "onCreateMiniPlayer() - disposeComposition", null, false, 6, null);
            composeView0.c();
        }
        ViewGroup viewGroup1 = this.miniPlayerContainer;
        if(viewGroup1 != null) {
            viewGroup1.removeAllViews();
        }
        ComposeView composeView1 = new ComposeView(this, null, 6, 0);
        composeView1.setContent(new m0.b(0x69E247F2, new V2(this, 19), true));
        ViewGroup viewGroup2 = this.miniPlayerContainer;
        if(viewGroup2 != null) {
            viewGroup2.addView(composeView1);
        }
    }

    private static final H onCreateMiniPlayer$lambda$4(MusicBrowserActivity musicBrowserActivity0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            sd.o.c(musicBrowserActivity0.getMiniPlayerViewModel(), ((p)l0), 0);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    @Override  // com.iloen.melon.activity.BaseActivity
    public void onDestroy() {
        Q8.j j0 = Q8.d.a.e;
        if(j0 == null || !j0.g) {
            k9.j.d();
        }
        BadgeUtils.setBadge(this, 0);
        this.deeplinkManager = null;
        NonSwipeableViewPager nonSwipeableViewPager0 = this.viewPager;
        if(nonSwipeableViewPager0 != null) {
            nonSwipeableViewPager0.setAdapter(null);
            ImageCacheManager.INSTANCE.flush();
            this.miniPlayerContainer = null;
            this.detachFloatingFragment();
            Intent intent0 = this.getIntent();
            if(intent0 != null) {
                intent0.setAction("com.iloen.melon.intent.action.NONE");
                intent0.setData(null);
                intent0.removeCategory("android.intent.category.LAUNCHER");
            }
            this.unregisterReceiver(this.mPageActionReceiver);
            this.unregisterReceiver(this.mAlertDialogBroadcastReceiver);
            if(ShortcutManager.getInstance().hasRegistedReceiver()) {
                ShortcutManager.getInstance().unregisterReceiver();
            }
            MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
            if(musicBrowserPopupHelper0 != null) {
                musicBrowserPopupHelper0.onDestroy();
                this.musicBrowserPopupHelper = null;
            }
            this.pendingNotificationLoginRes = null;
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new u8.a(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            MelonAppBase.Companion.getClass();
            t.a().setAppPip(false);
            MainBottomPopup.Companion.setHideBannerId("");
            super.onDestroy();
            return;
        }
        kotlin.jvm.internal.q.m("viewPager");
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventAlertDialog eventAlertDialog0) {
        kotlin.jvm.internal.q.g(eventAlertDialog0, "event");
        com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, this.getSupportFragmentManager(), eventAlertDialog0.title, eventAlertDialog0.message, false, false, false, null, null, null, null, null, 2040);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventAppFinish eventAppFinish0) {
        this.finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventConfirmDialog eventConfirmDialog0) {
        kotlin.jvm.internal.q.g(eventConfirmDialog0, "event");
        PopupHelper.showConfirmPopup(this, eventConfirmDialog0.title, eventConfirmDialog0.message, eventConfirmDialog0.clickListener);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventDownloadFailed eventDownloadFailed0) {
        com.melon.ui.popup.b.x(this.getSupportFragmentManager(), "안내", "다운로드가 완료되지 못한 곡이 있습니다. 다운로드 관리자에서 다시 시도하시겠습니까?", false, false, null, null, new r5(18), null, null, null, 0xEF8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventDrmAutoExtensionNotAllowed eventDrmAutoExtensionNotAllowed0) {
        kotlin.jvm.internal.q.g(eventDrmAutoExtensionNotAllowed0, "event");
        this.handleAutoExtensionNotAllowedError(eventDrmAutoExtensionNotAllowed0.getException());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventLoginDialog eventLoginDialog0) {
        if(eventLoginDialog0 instanceof AppUpdate) {
            if(!this.isFinishing()) {
                this.showDialogOnUpdate();
            }
        }
        else if(eventLoginDialog0 instanceof Event) {
            int v = AppUtils.getVersionCode(this);
            SharedPreferences sharedPreferences0 = this.getSharedPreferences("com.iloen.melon.Preference", 0);
            if(v > sharedPreferences0.getInt("versioncode", 0)) {
                T t0 = new T(sharedPreferences0, v, 3);
                com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, this.getSupportFragmentManager(), "안내", ((Event)eventLoginDialog0).message, false, false, false, null, null, null, t0, null, 0x5F8);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventLoginError eventLoginError0) {
        kotlin.jvm.internal.q.g(eventLoginError0, "event");
        if(eventLoginError0 instanceof KakaoSignUp) {
            LogU.verbose$default(this.log, "EventLoginError.KakaoSignUp", null, false, 6, null);
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new Y0(this, null), 3, null);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventLoginErrorDialog eventLoginErrorDialog0) {
        kotlin.jvm.internal.q.g(eventLoginErrorDialog0, "event");
        if(eventLoginErrorDialog0 instanceof PwdErrorExceed && eventLoginErrorDialog0.showDialog) {
            r5 r50 = new r5(14);
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, this.getSupportFragmentManager(), eventLoginErrorDialog0.title, eventLoginErrorDialog0.message, false, false, false, "비밀번호 찾기", null, null, r50, null, 0x5B8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventLoginPromotionDialog eventLoginPromotionDialog0) {
        kotlin.jvm.internal.q.g(eventLoginPromotionDialog0, "event");
        LogU.Companion.v("MusicBrowserActivity", "EventLoginPromotionDialog");
        NotificationLoginRes notificationLoginRes0 = eventLoginPromotionDialog0.getResponse();
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.showLoginPopup(notificationLoginRes0);
            return;
        }
        LogU.debug$default(this.log, "EventLoginPromotionDialog pending...", null, false, 6, null);
        this.pendingNotificationLoginRes = notificationLoginRes0;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventOptionDialog eventOptionDialog0) {
        kotlin.jvm.internal.q.g(eventOptionDialog0, "event");
        int v = eventOptionDialog0.button;
        switch(v) {
            case 0: {
                MelonTextPopup melonTextPopup1 = new MelonTextPopup(this, 1);
                melonTextPopup1.setTitleName("안내");
                melonTextPopup1.setBodyMsg(eventOptionDialog0.message);
                melonTextPopup1.setPopupOnClickListener(new k8.M(eventOptionDialog0, 0));
                melonTextPopup1.show();
                return;
            }
            case 1: {
                MelonTextPopup melonTextPopup2 = new MelonTextPopup(this, 1);
                melonTextPopup2.setTitleName("안내");
                melonTextPopup2.setBodyMsg(eventOptionDialog0.message);
                melonTextPopup2.setCenterBtnName("취소");
                melonTextPopup2.setPopupOnClickListener(new Xb.a(4));
                melonTextPopup2.show();
                return;
            }
            default: {
                if(v != 2) {
                    return;
                }
                MelonTextPopup melonTextPopup0 = new MelonTextPopup(this, 2);
                melonTextPopup0.setTitleName("안내");
                melonTextPopup0.setBodyMsg(eventOptionDialog0.message);
                melonTextPopup0.setPopupOnClickListener(new k8.M(eventOptionDialog0, 1));
                melonTextPopup0.show();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPlaybackScheme eventPlaybackScheme0) {
        kotlin.jvm.internal.q.g(eventPlaybackScheme0, "event");
        LogU.Companion.d("MusicBrowserActivity", "onEventMainThread::EventPlaybackScheme()");
        kotlin.jvm.internal.q.f(eventPlaybackScheme0.uri, "uri");
        SchemeAction.INSTANCE.playback(eventPlaybackScheme0.uri);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPlaylist eventPlaylist0) {
        kotlin.jvm.internal.q.g(eventPlaylist0, "event");
        if(eventPlaylist0 instanceof EventAddSongIds) {
            this.addToMyPlaylist(((EventAddSongIds)eventPlaylist0));
            return;
        }
        if(eventPlaylist0 instanceof EventDeleteSong) {
            this.deleteDrawerPlaylistFromMyPlaylist(((EventDeleteSong)eventPlaylist0));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventShowApplyMelonDjPopup eventPopup$EventShowApplyMelonDjPopup0) {
        if(!this.isFinishing()) {
            if(((va.e0)this.getLoginUseCase()).m()) {
                RequestBuilder.newInstance(new DjApplyMainReq(Y.a(MelonAppBase.Companion), e1.u.v(((va.e0)this.getLoginUseCase()).j()), "terms")).tag("MusicBrowserActivity").listener(new V0(this)).request();
                return;
            }
            androidx.fragment.app.I i0 = this.getCurrentFragment();
            if(i0 instanceof MelonBaseFragment) {
                ((MelonBaseFragment)i0).showLoginPopup();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventShowFolderSettingPopup eventPopup$EventShowFolderSettingPopup0) {
        MelonAppBase.Companion.getClass();
        if(t.a().isAppForeground()) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new W0(this, null), 3, null);
            return;
        }
        ToastManager.show(0x7F1303C2);  // string:error_file_not_exist "파일이 존재하지 않습니다."
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventShowWifiSettingPopup eventPopup$EventShowWifiSettingPopup0) {
        this.selectBottomNavigation(3);
        try {
            LockerFragment.Companion.newInstance(false, true).open();
        }
        catch(Exception unused_ex) {
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPremiumDevice eventPremiumDevice0) {
        kotlin.jvm.internal.q.g(eventPremiumDevice0, "event");
        if(eventPremiumDevice0 instanceof NoUseLteForDownload) {
            if(this.offlinePlaybackPopup != null) {
                this.dismissOfflinePlaybackDialog();
            }
            MelonTextPopup melonTextPopup0 = PopupHelper.showConfirmPopup(this, 0x7F1300D0, 0x7F1300AB, new k8.T(this, eventPremiumDevice0));  // string:alert_dlg_title_info "안내"
            this.offlinePlaybackPopup = melonTextPopup0;
            if(melonTextPopup0 != null) {
                melonTextPopup0.setOnDismissListener(new U());  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
        else if(eventPremiumDevice0 instanceof ConsentOfUserDownload) {
            if(this.offlinePlaybackPopup != null) {
                this.dismissOfflinePlaybackDialog();
            }
            kotlin.jvm.internal.q.f("재생목록에 담긴 %1$d곡을 저장합니다.\n\n데이터 통신 상태인 경우 통신요금이 부과될 수 있습니다.\nLTE 데이터 사용을 원치 않으시면 Wi-Fi로 설정해주세요.", "getString(...)");
            this.offlinePlaybackPopup = PopupHelper.showTwoButtonPopup(this, "안내", String.format("재생목록에 담긴 %1$d곡을 저장합니다.\n\n데이터 통신 상태인 경우 통신요금이 부과될 수 있습니다.\nLTE 데이터 사용을 원치 않으시면 Wi-Fi로 설정해주세요.", Arrays.copyOf(new Object[]{eventPremiumDevice0.realSize}, 1)), "확인", "취소", new k8.T(eventPremiumDevice0, this));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventSmartDialog eventSmartDialog0) {
        kotlin.jvm.internal.q.g(eventSmartDialog0, "event");
        this.dismissSmartPlaylistDialog();
        if(eventSmartDialog0 instanceof EventSmartUserSelectDialog) {
            com.melon.ui.popup.b.x(this.getSupportFragmentManager(), "안내", "", false, false, "유지하기", "변경하기", new N(this, 0), new N(this, 1), null, null, 0xC30);
            return;
        }
        com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
        if(eventSmartDialog0 instanceof EventSmartAlertDialog) {
            com.melon.ui.popup.b.d(b0, this.getSupportFragmentManager(), "안내", "", false, false, false, null, null, null, null, null, 2040);
            return;
        }
        if(eventSmartDialog0 instanceof EventSmartRestoreFailedDialog) {
            com.melon.ui.popup.b.d(b0, this.getSupportFragmentManager(), "안내", "데이터 네트워크 차단 상태에서는 스마트 재생목록 사용이 불가합니다. 네트워크 상태 확인 후 다시 시도해 주세요.", false, false, false, null, null, null, null, null, 2040);
            return;
        }
        if(!(eventSmartDialog0 instanceof EventSmartAppUpdateNeedDialog)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        com.melon.ui.popup.b.d(b0, this.getSupportFragmentManager(), "안내", ((EventSmartAppUpdateNeedDialog)eventSmartDialog0).getDesc(), false, false, false, null, null, new N(this, 2), null, null, 0x6F8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventSplashDismiss eventSplashDismiss0) {
        if(this.isSplashShowing()) {
            MelonSplashPopup melonSplashPopup0 = this.splashPopup;
            if(melonSplashPopup0 != null) {
                melonSplashPopup0.dismiss();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventToastMessage eventToastMessage0) {
        if(eventToastMessage0 != null && !TextUtils.isEmpty(eventToastMessage0.message)) {
            ToastManager.show(eventToastMessage0.message);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull OpenUri eventWebView$OpenUri0) {
        kotlin.jvm.internal.q.g(eventWebView$OpenUri0, "event");
        Uri uri0 = eventWebView$OpenUri0.getUri();
        g g0 = new g(null);
        kotlin.jvm.internal.q.d(uri0);
        if(g0.a(uri0)) {
            LogU.Companion.i("MusicBrowserActivity", "checkMemberKeyFromOtherApp MemberKey Not Equal - Logout!");
            return;
        }
        f.d(uri0);
        df.d.o(this, uri0, false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable WebViewChromeSslCertIssueAlert eventWebView$WebViewChromeSslCertIssueAlert0) {
        LogU.Companion.v("MusicBrowserActivity", "WebViewChromeSslCertIssueAlert called");
        l0 l00 = this.getSupportFragmentManager();
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(com.melon.ui.popup.b.b(l00, "showChromeSslCertAlertPopup", null, null, 12) == null) {
                new vd.g().show(l00, "showChromeSslCertAlertPopup");
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull CloseAllView eventWebViewClose$CloseAllView0) {
        kotlin.jvm.internal.q.g(eventWebViewClose$CloseAllView0, "event");
        LogU.verbose$default(this.log, "EventWebViewClose.CloseAllView", null, false, 6, null);
        this.closeAllPopupWebView();
        Uri uri0 = eventWebViewClose$CloseAllView0.openUri;
        if(uri0 != null) {
            EventBusHelper.post(new OpenUri(uri0));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull x8.g g0) {
        boolean z = false;
        kotlin.jvm.internal.q.g(g0, "event");
        x8.b b0 = g0.a;
        TaskState taskState0 = g0.b;
        if(b0 instanceof y) {
            if(kotlin.jvm.internal.q.b(TaskState.STARTED, taskState0)) {
                if(this.melonProgressDlg == null) {
                    MelonProgressPopup melonProgressPopup0 = new MelonProgressPopup(this);
                    melonProgressPopup0.setCancelable(false);
                    melonProgressPopup0.setBodyMsg("DCF 파일의 재생 기간을 연장 합니다. 잠시만 기다려 주세요.");
                    melonProgressPopup0.setMax(((y)b0).a.size());
                    melonProgressPopup0.show();
                    this.melonProgressDlg = melonProgressPopup0;
                }
            }
            else if(TaskState.RUNNING.statusEquals(taskState0)) {
                MelonProgressPopup melonProgressPopup1 = this.melonProgressDlg;
                if(melonProgressPopup1 != null) {
                    melonProgressPopup1.setProgress(taskState0.mProgress);
                }
            }
            else if(kotlin.jvm.internal.q.b(TaskState.FINISHED, taskState0)) {
                MelonProgressPopup melonProgressPopup2 = this.melonProgressDlg;
                if(melonProgressPopup2 != null) {
                    melonProgressPopup2.dismiss();
                }
                this.melonProgressDlg = null;
                if(!(b0 instanceof R8.A)) {
                    ArrayList arrayList0 = ((y)b0).c;
                    if(arrayList0 == null) {
                        LogU.Companion.e("MusicBrowserActivity", "onEventMainThread::EventCoroutineAsyncTask :: TaskExtendDueDateForMrCap :: listDcfExtendResultInSync is null - error = " + ((y)b0).f);
                        if(((y)b0).f != null) {
                            MelonTextPopup melonTextPopup0 = new MelonTextPopup(this, 1);
                            melonTextPopup0.setTitleName("안내");
                            Exception exception0 = ((y)b0).f;
                            kotlin.jvm.internal.q.d(exception0);
                            melonTextPopup0.setBodyMsg(exception0.getMessage());
                            melonTextPopup0.setPopupOnClickListener(new Xb.a(5));
                            melonTextPopup0.show();
                        }
                    }
                    else {
                        DcfFile dcfFile0 = null;
                        int v = 0;
                        for(Object object0: arrayList0) {
                            DcfExtendResult dcfExtendResult0 = (DcfExtendResult)object0;
                            if(dcfExtendResult0.b.a != 0) {
                                ++v;
                                dcfFile0 = dcfExtendResult0.a;
                            }
                        }
                        if(v == 0) {
                            kotlin.jvm.internal.q.f("요청하신 DCF 파일의 재생 기간연장을 완료했습니다.", "getString(...)");
                            ToastManager.show("요청하신 DCF 파일의 재생 기간연장을 완료했습니다.");
                            return;
                        }
                        androidx.fragment.app.I i0 = MelonFragmentManager.getInstance().getCurrentFragment();
                        if(i0 != null && "DcfExtensionFailBrowserFragment".equals(i0.getClass().getSimpleName())) {
                            this.navigateBack();
                        }
                        Navigator.open(DcfExtensionFailBrowserFragment.newInstance(arrayList0));
                        if(dcfFile0 != null) {
                            File file0 = dcfFile0.f;
                            if(file0 == null) {
                                r2.a a0 = dcfFile0.g;
                                if(a0 != null) {
                                    z = a0.c();
                                }
                            }
                            else {
                                z = file0.exists();
                            }
                            if(z) {
                                r.d(3, dcfFile0.c(), null);
                            }
                        }
                    }
                }
            }
        }
    }

    private static final void onEventMainThread$lambda$67(MusicBrowserActivity musicBrowserActivity0, EventPremiumDevice eventPremiumDevice0, DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            ToastManager.show(0x7F1310E9);  // string:use_3g_setting_on "Wi-Fi가 연결되지 않았을 경우 데이터 네트워크를 사용합니다."
            MelonSettingInfo.setUseDataNetwork(true);
            Collection collection0 = ((NoUseLteForDownload)eventPremiumDevice0).downloadList;
            kotlin.jvm.internal.q.f(collection0, "downloadList");
            musicBrowserActivity0.checkPrimiumDownload(je.p.P0(collection0));
            return;
        }
        synchronized(Q8.d.a.h) {
            Q8.d.a.g.clear();
        }
    }

    private static final void onEventMainThread$lambda$68(DialogInterface dialogInterface0) {
        synchronized(Q8.d.a.h) {
            Q8.d.a.g.clear();
        }
    }

    private static final void onEventMainThread$lambda$69(EventPremiumDevice eventPremiumDevice0, MusicBrowserActivity musicBrowserActivity0, DialogInterface dialogInterface0, int v) {
        MelonSettingInfo.setPremiumOfflineDownloadPopupShown(true);
        if(-1 == v) {
            MelonSettingInfo.setPremiumOfflineDownloadOnlyWiFi(false);
            List list0 = eventPremiumDevice0.list;
            kotlin.jvm.internal.q.e(list0, "null cannot be cast to non-null type kotlin.collections.List<com.iloen.melon.playback.Playable>");
            Q8.d.a.c(list0);
        }
        else {
            MelonSettingInfo.setPremiumOfflineDownloadOnlyWiFi(true);
        }
        musicBrowserActivity0.dismissOfflinePlaybackDialog();
    }

    private static final H onEventMainThread$lambda$70(SharedPreferences sharedPreferences0, int v) {
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        sharedPreferences$Editor0.putInt("versioncode", v);
        sharedPreferences$Editor0.commit();
        return H.a;
    }

    private static final H onEventMainThread$lambda$71() {
        Navigator.openUrlFullScreenView(A8.M.U);
        return H.a;
    }

    private static final H onEventMainThread$lambda$72() {
        Navigator.INSTANCE.openDownloadManager();
        return H.a;
    }

    private static final void onEventMainThread$lambda$73(EventOptionDialog eventOptionDialog0, DialogInterface dialogInterface0, int v) {
        if(!TextUtils.isEmpty(eventOptionDialog0.pageUrl)) {
            MelonLinkExecutor.INSTANCE.openWithTitleName(eventOptionDialog0.title, eventOptionDialog0.linkType, eventOptionDialog0.pageUrl);
        }
        dialogInterface0.dismiss();
    }

    private static final void onEventMainThread$lambda$74(DialogInterface dialogInterface0, int v) {
        dialogInterface0.dismiss();
    }

    private static final void onEventMainThread$lambda$75(EventOptionDialog eventOptionDialog0, DialogInterface dialogInterface0, int v) {
        if(v == -1 && !TextUtils.isEmpty(eventOptionDialog0.pageUrl)) {
            MelonLinkExecutor.INSTANCE.openWithTitleName(eventOptionDialog0.title, eventOptionDialog0.linkType, eventOptionDialog0.pageUrl);
        }
        dialogInterface0.dismiss();
    }

    private static final void onEventMainThread$lambda$76(DialogInterface dialogInterface0, int v) {
        androidx.fragment.app.I i0 = MelonFragmentManager.getInstance().getCurrentFragment();
        if(i0 instanceof MelonBaseFragment) {
            ((MelonBaseFragment)i0).onBackPressed();
            return;
        }
        if(i0 instanceof c0) {
            ((c0)i0).onBackPressed();
        }
    }

    private static final H onEventMainThread$lambda$77(MusicBrowserActivity musicBrowserActivity0) {
        com.melon.playlist.b b0 = (com.melon.playlist.b)((d3)musicBrowserActivity0.getPlaylistManager()).a;
        b1 b10 = new b1(b0, null);
        BuildersKt__Builders_commonKt.launch$default(b0.m, null, null, b10, 3, null);
        return H.a;
    }

    private static final H onEventMainThread$lambda$78(MusicBrowserActivity musicBrowserActivity0) {
        com.melon.playlist.b b0 = (com.melon.playlist.b)((d3)musicBrowserActivity0.getPlaylistManager()).a;
        a1 a10 = new a1(b0, null);
        BuildersKt__Builders_commonKt.launch$default(b0.m, null, null, a10, 3, null);
        return H.a;
    }

    private static final H onEventMainThread$lambda$80(MusicBrowserActivity musicBrowserActivity0) {
        Intent intent0 = new Intent("android.intent.action.VIEW");
        intent0.setFlags(0x10000000);
        intent0.setData(UrlUtil.getMelonAppMarketUri());
        musicBrowserActivity0.startActivity(intent0);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public boolean onKeyDown(int v, @NotNull KeyEvent keyEvent0) {
        kotlin.jvm.internal.q.g(keyEvent0, "event");
        return VolumeUtils.Companion.onVolumeKeyDown(this, v) ? true : super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.app.Activity
    public boolean onKeyUp(int v, @NotNull KeyEvent keyEvent0) {
        kotlin.jvm.internal.q.g(keyEvent0, "event");
        if(this.getCurrentFocus() instanceof EditText) {
            return super.onKeyUp(v, keyEvent0);
        }
        if(v == 62) {
            if(this.getPlayerUseCase().n()) {
                this.getPlayerUseCase().s();
                return true;
            }
            this.getPlayerUseCase().u();
            return true;
        }
        return super.onKeyUp(v, keyEvent0);
    }

    @Override  // androidx.activity.ComponentActivity
    public void onNewIntent(@NotNull Intent intent0) {
        kotlin.jvm.internal.q.g(intent0, "intent");
        super.onNewIntent(intent0);
        this.pendingIntent = intent0;
        this.handlePendingIntent();
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onPause() {
        LogU.Companion.v("MusicBrowserActivity", "onPause()");
        super.onPause();
        MenuIdQueue.getInstance().setSkipAction(true);
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.onPause();
        }
    }

    @Override  // androidx.activity.ComponentActivity
    public void onPictureInPictureModeChanged(boolean z, @NotNull Configuration configuration0) {
        kotlin.jvm.internal.q.g(configuration0, "newConfig");
        super.onPictureInPictureModeChanged(z, configuration0);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new Z0(this, z, null), 3, null);
    }

    @Override  // com.iloen.melon.player.video.Pipable
    public void onPipModeOn() {
        this.dismissPlaybackUiDialog();
        this.dismissEventNotificationDialog();
        this.dismissSmartPlaylistDialog();
        this.hideAllPopup();
    }

    @Override  // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        kotlin.jvm.internal.q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        this.lastHighContrastMode = bundle0.getBoolean("ARG_LAST_HIGH_CONTRAST_MODE", false);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onResume() {
        LogU.Companion.v("MusicBrowserActivity", "onResume()");
        super.onResume();
        if(Td.b.d(this)) {
            boolean z = Td.b.e(this.getApplicationContext(), "android.permission.POST_NOTIFICATIONS");
            if(!this.checkingNotificationPermission || z) {
                this.hideRuntimePermissionGuide();
                BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new k8.a1(this, null), 3, null);
            }
            else {
                MusicBrowserActivity.checkRuntimePermission$default(this, 0, 1, null);
            }
        }
        else {
            boolean z1 = Td.b.e(this, "android.permission.READ_PHONE_NUMBERS");
            boolean z2 = Td.b.e(this, "android.permission.READ_PHONE_STATE");
            if((!z1 || z2) && (z1 || !z2)) {
                this.showRuntimePermissionGuide();
            }
            else {
                MusicBrowserActivity.checkRuntimePermission$default(this, 0, 1, null);
            }
        }
        AdIdManager.INSTANCE.refresh();
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.onResume();
        }
        NotificationHelper notificationHelper0 = this.notificationHelper;
        if(notificationHelper0 != null) {
            notificationHelper0.deleteChannel("106");
            return;
        }
        kotlin.jvm.internal.q.m("notificationHelper");
        throw null;
    }

    @Override  // androidx.activity.ComponentActivity
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        kotlin.jvm.internal.q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("ARG_LAST_TAB_INDEX", this.lastTabIndex);
        bundle0.putBoolean("ARG_LAST_HIGH_CONTRAST_MODE", this.lastHighContrastMode);
        Parcel parcel0 = Parcel.obtain();
        kotlin.jvm.internal.q.f(parcel0, "obtain(...)");
        bundle0.writeToParcel(parcel0, 0);
        int v = parcel0.dataSize();
        parcel0.recycle();
        Md.e.b = v;
        double f = ((double)Md.e.a) * 0.9;
        try {
            Parcel parcel1 = Parcel.obtain();
            kotlin.jvm.internal.q.f(parcel1, "obtain(...)");
            bundle0.writeToParcel(parcel1, 0);
            int v1 = parcel1.dataSize();
            parcel1.recycle();
        }
        catch(Exception exception0) {
            com.iloen.melon.utils.a.v("isActivityBundleSizeDanger() - Err: ", exception0.getMessage(), LogU.Companion, "BundleTrackingUtils");
            return;
        }
        if(((double)v1) > f) {
            Md.e.c = true;
        }
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onStart() {
        LogU.Companion.v("MusicBrowserActivity", "onStart()");
        super.onStart();
        MenuIdQueue.getInstance().setSkipAction(false);
        if(Md.e.a <= 0x80000 && Md.e.b > Md.e.a) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new Md.d(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        }
        if(Md.e.c) {
            Md.e.c = false;
            this.clearAllTabStackWithoutCurrentTab();
        }
        if(!A8.b.e() && y5.a.c) {
            TextView textView0 = (TextView)this.findViewById(0x7F0A01C9);  // id:bundle_info_tv
            if(textView0 != null) {
                textView0.setVisibility(0);
                textView0.setText(StringUtils.getCountFormattedString(Md.e.b) + " bytes / " + StringUtils.getCountFormattedString(Md.e.a) + " bytes\n\n" + ((double)ye.a.V(((float)Md.e.b) / ((float)Md.e.a) * 10000.0f)) / 100.0 + "%");
            }
        }
        MelonAppBase.Companion.getClass();
        t.a().setAppPip(this.isInPictureInPictureMode());
        GoogleApiClient googleApiClient0 = this.googleApiClient;
        if(googleApiClient0 != null) {
            googleApiClient0.connect();
        }
        Ic.h h0 = new Ic.h(0, this, MusicBrowserActivity.class, "handleScreenCapture", "handleScreenCapture()V", 0, 20);
        this.screenCaptureHelper.getClass();
        Z1 z10 = new Z1(this.screenCaptureHelper, h0, this, 3);
        this.screenCaptureHelper.a(this, z10);
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onStop() {
        LogU.Companion.v("MusicBrowserActivity", "onStop()");
        MelonAppBase.Companion.getClass();
        t.a().setAppPip(false);
        vd.e e0 = null;
        this.handler.removeCallbacksAndMessages(null);
        if(this.isSplashShowing()) {
            MelonSplashPopup melonSplashPopup0 = this.splashPopup;
            if(melonSplashPopup0 != null) {
                melonSplashPopup0.dismiss();
            }
            this.splashPopup = null;
        }
        this.dismissMelonProgressDialog();
        this.dismissPlaybackUiDialog();
        this.dismissSmartPlaylistDialog();
        l0 l00 = this.getSupportFragmentManager();
        if(l00 != null && !l00.T() && !l00.K) {
            l00.C();
            androidx.fragment.app.w w0 = com.melon.ui.popup.b.b(l00, "BlockingProgressDialogFragment", null, null, 12);
            if(w0 != null) {
                if(w0 instanceof vd.e) {
                    e0 = (vd.e)w0;
                }
                if(e0 != null) {
                    e0.dismissAllowingStateLoss();
                }
            }
        }
        super.onStop();
        GoogleApiClient googleApiClient0 = this.googleApiClient;
        if(googleApiClient0 != null) {
            googleApiClient0.disconnect();
        }
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
        if(musicBrowserPopupHelper0 != null) {
            musicBrowserPopupHelper0.onStop();
        }
        E.a.clear();
        this.screenCaptureHelper.getClass();
        Dc.i i0 = new Dc.i(13, this.screenCaptureHelper, this);
        this.screenCaptureHelper.a(this, i0);
    }

    @Override  // androidx.activity.ComponentActivity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.enterPipMode();
    }

    @Override  // android.app.Activity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        FloatingFragment floatingFragment0 = this.floatingFragment;
        if(floatingFragment0 != null) {
            floatingFragment0.onWindowFocusChanged(z);
        }
    }

    private final void openVideoPlayer(boolean z, boolean z1) {
        LogU.info$default(this.log, "openVideoPlayer() isFullScreen:" + z + ", openPlaylist:" + z1, null, false, 6, null);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new k8.b1(this, z, z1, null), 2, null);
    }

    public static void openVideoPlayer$default(MusicBrowserActivity musicBrowserActivity0, boolean z, boolean z1, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openVideoPlayer");
        }
        if((v & 2) != 0) {
            z1 = false;
        }
        musicBrowserActivity0.openVideoPlayer(z, z1);
    }

    private final void processBackKey() {
        CountDownTimer countDownTimer0 = this.countDownTimer;
        if(countDownTimer0 != null) {
            countDownTimer0.cancel();
            if(!this.enterPipMode()) {
                EventBusHelper.post(new EventAppFinish());
            }
            return;
        }
        ToastManager.showShort(0x7F1300EB);  // string:app_exit_confirm "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다."
        this.countDownTimer = new Rc.f0(this).start();
    }

    private final void registerIntentFilter() {
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.iloen.melon.intent.action.gologin");
        intentFilter0.addAction("com.iloen.melon.intent.action.goSNSlogin");
        intentFilter0.addAction("com.iloen.melon.MELON20_PLAYER_START");
        intentFilter0.addAction("com.iloen.melon.MELON_RADIO_PLAYER_START");
        intentFilter0.addAction("com.iloen.melon.NOWPLAYING_PLAYER_START");
        intentFilter0.addAction("com.iloen.melon.MUSICVIDEO_VIEWER");
        intentFilter0.addAction("com.iloen.melon.MELON_RADIO_CAST_PLAYER_START");
        E9.w.S(this, this.mPageActionReceiver, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION");
        IntentFilter intentFilter1 = new IntentFilter("com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action");
        E9.w.S(this, this.mAlertDialogBroadcastReceiver, intentFilter1, "com.iloen.melon.permission.SIG_PERMISSION");
    }

    private final void registerIsLoginFlow() {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new k8.d1(this, null), 3, null);
    }

    private final void registerTokenCheckAtForeground() {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new f1(this, null), 3, null);
    }

    private final void resetBackKeyTimer() {
        CountDownTimer countDownTimer0 = this.countDownTimer;
        if(countDownTimer0 != null) {
            countDownTimer0.cancel();
        }
        this.countDownTimer = null;
    }

    private final void selectBottomNavigation(int v) {
        switch(v) {
            case 0: {
                BottomNavigationView bottomNavigationView4 = this.bottomNavigationView;
                if(bottomNavigationView4 != null) {
                    bottomNavigationView4.setSelectedItemId(0x7F0A089E);  // id:navigation_home
                    return;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
            case 1: {
                BottomNavigationView bottomNavigationView3 = this.bottomNavigationView;
                if(bottomNavigationView3 != null) {
                    bottomNavigationView3.setSelectedItemId(0x7F0A089C);  // id:navigation_foryou
                    return;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
            case 2: {
                BottomNavigationView bottomNavigationView2 = this.bottomNavigationView;
                if(bottomNavigationView2 != null) {
                    bottomNavigationView2.setSelectedItemId(0x7F0A08A1);  // id:navigation_search
                    return;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
            case 3: {
                BottomNavigationView bottomNavigationView1 = this.bottomNavigationView;
                if(bottomNavigationView1 != null) {
                    bottomNavigationView1.setSelectedItemId(0x7F0A089F);  // id:navigation_library
                    return;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
            case 4: {
                BottomNavigationView bottomNavigationView0 = this.bottomNavigationView;
                if(bottomNavigationView0 != null) {
                    bottomNavigationView0.setSelectedItemId(0x7F0A08A0);  // id:navigation_menu
                    return;
                }
                kotlin.jvm.internal.q.m("bottomNavigationView");
                throw null;
            }
        }
    }

    private final void selectTab(int v) {
        this.lastTabIndex = v;
        NonSwipeableViewPager nonSwipeableViewPager0 = this.viewPager;
        if(nonSwipeableViewPager0 != null) {
            if(nonSwipeableViewPager0.getCurrentItem() == v) {
                this.clearTabStack(v);
                return;
            }
            if(this.tabPagerAdapter != null) {
                for(int v1 = 0; v1 < 5; ++v1) {
                    if(v1 != v) {
                        BottomTabPagerAdapter bottomTabPagerAdapter0 = this.tabPagerAdapter;
                        if(bottomTabPagerAdapter0 == null) {
                            kotlin.jvm.internal.q.m("tabPagerAdapter");
                            throw null;
                        }
                        BottomTabBaseFragment bottomTabBaseFragment0 = bottomTabPagerAdapter0.getFragment(v1);
                        if(bottomTabBaseFragment0 != null) {
                            androidx.fragment.app.I i0 = bottomTabBaseFragment0.getFragment();
                            if(i0 instanceof FragmentStack && (((FragmentStack)i0).isPlayerFragment() || ((FragmentStack)i0).isPlaylistFragment())) {
                                bottomTabBaseFragment0.removeFragmentByIndex(bottomTabBaseFragment0.getFragmentCount() - 1);
                            }
                        }
                    }
                }
                this.selectBottomNavigation(v);
                return;
            }
            kotlin.jvm.internal.q.m("tabPagerAdapter");
            throw null;
        }
        kotlin.jvm.internal.q.m("viewPager");
        throw null;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public void selectTab(int v, boolean z, boolean z1) {
        if(z) {
            this.clearAllTabStack();
        }
        if(z1) {
            NonSwipeableViewPager nonSwipeableViewPager0 = this.viewPager;
            if(nonSwipeableViewPager0 != null) {
                nonSwipeableViewPager0.post(new A6.d(this, v, 15));
                return;
            }
            kotlin.jvm.internal.q.m("viewPager");
            throw null;
        }
        this.selectTab(v);
    }

    private static final void selectTab$lambda$28(MusicBrowserActivity musicBrowserActivity0, int v) {
        BottomTabPagerAdapter bottomTabPagerAdapter0 = musicBrowserActivity0.tabPagerAdapter;
        if(bottomTabPagerAdapter0 != null) {
            BottomTabBaseFragment bottomTabBaseFragment0 = bottomTabPagerAdapter0.getFragment(v);
            if(bottomTabBaseFragment0 != null) {
                bottomTabBaseFragment0.scrollToTop(false);
                musicBrowserActivity0.selectTab(v);
            }
            return;
        }
        kotlin.jvm.internal.q.m("tabPagerAdapter");
        throw null;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public void selectTabAndClear(int v) {
        this.clearTabStack(v);
        this.selectTab(v);
    }

    public final void setBlockStoreRetrieveAndLoginUseCase(@NotNull b b0) {
        kotlin.jvm.internal.q.g(b0, "<set-?>");
        this.blockStoreRetrieveAndLoginUseCase = b0;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public void setBottomTabFragmentForeground(boolean z) {
    }

    public final void setDrmContentsHelper(@NotNull c c0) {
        kotlin.jvm.internal.q.g(c0, "<set-?>");
        this.drmContentsHelper = c0;
    }

    public final void setMainContainerWindowInsetsListener(@NotNull c2.v v0) {
        kotlin.jvm.internal.q.g(v0, "listener");
        View view0 = this.mainContainer;
        if(view0 != null) {
            M.n(view0, v0);
            view0.requestApplyInsets();
        }
    }

    public final void setMiniPlayerViewModel(@NotNull P p0) {
        kotlin.jvm.internal.q.g(p0, "<set-?>");
        this.miniPlayerViewModel = p0;
    }

    public final void setPendingPlayScheme(@Nullable Uri uri0) {
        this.pendingPlayScheme = uri0;
    }

    @Override  // android.app.Activity
    public void setPictureInPictureParams(@NotNull PictureInPictureParams pictureInPictureParams0) {
        kotlin.jvm.internal.q.g(pictureInPictureParams0, "params");
        if(!this.getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
            return;
        }
        try {
            super.setPictureInPictureParams(pictureInPictureParams0);
        }
        catch(Throwable throwable0) {
            d5.n.t(throwable0);
        }
    }

    public final void setPlaybackManager(@NotNull q q0) {
        kotlin.jvm.internal.q.g(q0, "<set-?>");
        this.playbackManager = q0;
    }

    public final void setPlayerRules(@NotNull t0 t00) {
        kotlin.jvm.internal.q.g(t00, "<set-?>");
        this.playerRules = t00;
    }

    private final void setPlaylistIdObserver() {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new i1(this, null), 3, null);
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        kotlin.jvm.internal.q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }

    public final void setRemotePlayerManager(@NotNull s s0) {
        kotlin.jvm.internal.q.g(s0, "<set-?>");
        this.remotePlayerManager = s0;
    }

    public final void setRootViewBackgroundColor(int v) {
        View view0 = this.rootView;
        if(view0 != null) {
            view0.setBackgroundColor(v);
        }
    }

    private final void setScreenFlagsOnWindow() {
        Window window0 = this.getWindow();
        if(window0 != null) {
            this.setScreenOnByIntent(window0);
            this.setScreenOnByPlayback(window0);
        }
    }

    private final void setScreenOnByIntent(Window window0) {
        Intent intent0 = this.getIntent();
        if(intent0 != null && !intent0.getBooleanExtra("screenOff", true)) {
            T4.d.g(this);
            window0.addFlags(0x80);
        }
    }

    private final void setScreenOnByPlayback(Window window0) {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new k1(this, window0, null), 3, null);
    }

    public final void setShuffleRepeatChangeNotifier(@NotNull V v0) {
        kotlin.jvm.internal.q.g(v0, "<set-?>");
        this.shuffleRepeatChangeNotifier = v0;
    }

    public final void setSkipTmpCall(boolean z) {
        this.skipTmpCall = z;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public void setTabAndMiniPlayerVisible(boolean z, boolean z1, boolean z2) {
        StringBuilder stringBuilder0 = Y.q("setTabAndMiniPlayerVisible() isShowTabAndMiniPlayer:", ", useAnimation:", z, ", isShowToolbar:", z1);
        stringBuilder0.append(z2);
        LogU.Companion.d("MusicBrowserActivity", stringBuilder0.toString());
        BottomNavigationView bottomNavigationView0 = this.bottomNavigationView;
        if(bottomNavigationView0 != null) {
            int v = 0;
            bottomNavigationView0.setPadding(bottomNavigationView0.getPaddingLeft(), bottomNavigationView0.getPaddingTop(), bottomNavigationView0.getPaddingRight(), 0);
            if(z1) {
                AutoTransition autoTransition0 = new AutoTransition();
                autoTransition0.setDuration(200L);
                autoTransition0.addListener(new l1(this));
                this.isTabAndMiniPlayerVisibilityAnimationPlaying = true;
                TransitionManager.beginDelayedTransition(this.ctlBottom, autoTransition0);
            }
            androidx.fragment.app.I i0 = this.getCurrentFragment();
            if(i0 != null) {
                boolean z3 = this.getShouldShowMiniPlayer(i0);
                MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.musicBrowserPopupHelper;
                if(musicBrowserPopupHelper0 != null) {
                    musicBrowserPopupHelper0.setShouldShowMiniPlayer(z3);
                }
                MusicBrowserPopupHelper musicBrowserPopupHelper1 = this.musicBrowserPopupHelper;
                if(musicBrowserPopupHelper1 != null) {
                    musicBrowserPopupHelper1.setLastTabIndexIndex(this.lastTabIndex);
                }
            }
            n n0 = new n();
            if(z) {
                n0.f(this.ctlBottom);
                n0.i(0x7F0A032A, 4, 0x7F0A0809, 3, 0);  // id:container_free_user_popup
                n0.t(0x7F0A0123, 0);  // id:bottom_navigation_container
                n0.b(this.ctlBottom);
                return;
            }
            n0.f(this.ctlBottom);
            if(z2) {
                n0.h(0x7F0A032A, 4, 0, 4);  // id:container_free_user_popup
                v = this.getResources().getDimensionPixelSize(0x7F070464);  // dimen:toolbar_height
            }
            n0.t(0x7F0A032A, v);  // id:container_free_user_popup
            int v1 = this.getResources().getDimensionPixelSize(0x7F070057);  // dimen:bottom_tab_height
            n0.t(0x7F0A0123, -(this.getResources().getDimensionPixelSize(0x7F070315) + v1));  // id:bottom_navigation_container
            n0.b(this.ctlBottom);
            return;
        }
        kotlin.jvm.internal.q.m("bottomNavigationView");
        throw null;
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public void setVideoMiniPlayer() {
        VideoMainFrameFragment videoMainFrameFragment0 = this.floatingFragment instanceof VideoMainFrameFragment ? ((VideoMainFrameFragment)this.floatingFragment) : null;
        if(videoMainFrameFragment0 != null) {
            videoMainFrameFragment0.setMiniPlayerMode();
        }
    }

    private final void setVideoUIAndMiniPlayerUI(PlaylistId playlistId0) {
        ViewUtils.showWhen(this.miniPlayerContainer, true);
        ViewUtils.hideWhen(this.videoMiniPlayerGap, true);
        this.detachVideoPlayer();
    }

    public final void setVodRepeatManager(@NotNull u u0) {
        kotlin.jvm.internal.q.g(u0, "<set-?>");
        this.vodRepeatManager = u0;
    }

    @Override  // pd.b
    public boolean shouldSkipEvent(@NotNull Xb.j j0) {
        ie.m m0;
        kotlin.jvm.internal.q.g(j0, "event");
        MelonAppBase.Companion.getClass();
        MelonAppBase melonAppBase0 = t.a();
        if(melonAppBase0.isLockScreenForeground()) {
            m0 = new ie.m(Boolean.TRUE, "Skip event in lock screen foreground");
        }
        else {
            m0 = melonAppBase0.isAppPip() ? new ie.m(Boolean.TRUE, "Skip event in PIP mode") : new ie.m(Boolean.FALSE, "");
        }
        boolean z = ((Boolean)m0.a).booleanValue();
        LogConstantsKt.debugOnlyDebugMode(this.log, "shouldSkipEvent() skipEvent:" + z + ", reason:" + ((String)m0.b));
        return z;
    }

    private final void showDialogOfflinePayback(Intent intent0) {
        if(intent0 != null) {
            String s = intent0.getAction();
            String s1 = intent0.getStringExtra("activitystartactionname");
            if(s != null && s1 != null && "com.iloen.melon.MELON_NOWPLAYING_START_ACTION".equals(s) && "player".equals(s1)) {
                com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, this.getSupportFragmentManager(), "안내", "데이터 차단 상태에서 오프라인 재생이 가능합니다.", false, false, false, null, null, null, null, null, 2040);
                return;
            }
        }
        com.melon.ui.popup.b.x(this.getSupportFragmentManager(), "안내", "데이터 차단 상태에서 오프라인 재생이 가능합니다.\n재생목록으로 이동하시겠습니까?", false, false, null, null, new r5(12), null, null, null, 0xEF8);
    }

    private static final H showDialogOfflinePayback$lambda$32() {
        Navigator.INSTANCE.openNowPlayList();
        return H.a;
    }

    private final void showDialogOnAirplane() {
        com.melon.ui.popup.b.x(this.getSupportFragmentManager(), "안내", "비행기 모드 사용 중에는 단말에\n저장된 콘텐츠만 재생이 가능합니다.\n음악서랍>다운로드 로 이동하시겠습니까?", false, false, null, null, new N(this, 4), null, null, null, 0xEF8);
    }

    private static final H showDialogOnAirplane$lambda$33(MusicBrowserActivity musicBrowserActivity0) {
        musicBrowserActivity0.selectBottomNavigation(3);
        LockerFragment.Companion.newInstance(false, true).open();
        return H.a;
    }

    private final void showDialogOnNetworkOff() {
        com.melon.ui.popup.b.x(this.getSupportFragmentManager(), "안내", "데이터 네트워크 차단 상태에서는\n단말에 저장된 콘텐츠만 재생이 가능합니다. 음악서랍>다운로드 로 이동하시겠습니까?", false, false, null, null, new r5(16), null, null, null, 0xEF8);
    }

    private static final H showDialogOnNetworkOff$lambda$34() {
        EventBusHelper.post(new EventShowWifiSettingPopup());
        return H.a;
    }

    private final void showDialogOnUpdate() {
        MelonUpgradePopup melonUpgradePopup0 = new MelonUpgradePopup(this, 0x7F0D05B1);  // layout:popup_upgrade
        melonUpgradePopup0.setTitleName("안내");
        AppVersionInfo appVersionInfo0 = MelonSettingInfo.getAppVersionInfo();
        if(appVersionInfo0 == null) {
            LogU.Companion.w("MusicBrowserActivity", "onCreateDialog() - invalid upgradeInfo");
            return;
        }
        if(!kotlin.jvm.internal.q.b(appVersionInfo0.c, "")) {
            melonUpgradePopup0.setBodyMsg(appVersionInfo0.c);
        }
        melonUpgradePopup0.setUpgradeInfo(appVersionInfo0);
        melonUpgradePopup0.setPopupOnClickListener(new Qd.a(2, this, appVersionInfo0));
        melonUpgradePopup0.setOnKeyListener(new W(melonUpgradePopup0, appVersionInfo0, this));
        melonUpgradePopup0.show();
    }

    private static final void showDialogOnUpdate$lambda$36(MusicBrowserActivity musicBrowserActivity0, AppVersionInfo appVersionInfo0, DialogInterface dialogInterface0, int v) {
        kotlin.jvm.internal.q.e(dialogInterface0, "null cannot be cast to non-null type com.iloen.melon.popup.MelonUpgradePopup");
        try {
            switch(v) {
                case 0: {
                    goto label_3;
                }
                case 1: {
                    goto label_18;
                }
                case 2: {
                    goto label_8;
                }
                case 3: {
                    goto label_13;
                }
            }
        }
        catch(ActivityNotFoundException unused_ex) {
            return;
        }
        return;
    label_3:
        Intent intent0 = ((MelonUpgradePopup)dialogInterface0).getUpdateIntent();
        if(intent0 != null) {
            musicBrowserActivity0.startActivity(intent0);
        }
        musicBrowserActivity0.finish();
        return;
        try {
        label_8:
            Intent intent1 = new Intent("android.intent.action.VIEW");
            intent1.setData(Uri.parse(appVersionInfo0.f));
            musicBrowserActivity0.startActivity(intent1);
            musicBrowserActivity0.finish();
        }
        catch(ActivityNotFoundException unused_ex) {
        }
        return;
    label_13:
        if(kotlin.jvm.internal.q.b(appVersionInfo0.a, "2")) {
            musicBrowserActivity0.finish();
            return;
        }
        LogU.Companion.e("i", "DIALOG_UPDATE / Next / onClick / send DO_LOGIN");
        return;
        try {
        label_18:
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(appVersionInfo0.d));
            musicBrowserActivity0.startActivity(intent2);
            musicBrowserActivity0.finish();
        }
        catch(ActivityNotFoundException unused_ex) {
        }
    }

    private static final boolean showDialogOnUpdate$lambda$37(MelonUpgradePopup melonUpgradePopup0, AppVersionInfo appVersionInfo0, MusicBrowserActivity musicBrowserActivity0, DialogInterface dialogInterface0, int v, KeyEvent keyEvent0) {
        if(v == 4) {
            melonUpgradePopup0.dismiss();
            if(kotlin.jvm.internal.q.b(appVersionInfo0.a, "2")) {
                musicBrowserActivity0.finish();
            }
        }
        return false;
    }

    private final void showPermissionFailPopup(boolean z) {
        LogU.Companion.d("MusicBrowserActivity", "showPermissionFailPopup() CALL");
        this.inflatePermissionCheckView();
        this.onChangedPermissionView(1);
        if(!z) {
            String[] arr_s = l9.a.c;
            boolean z1 = false;
            for(int v = 0; v < arr_s.length; ++v) {
                z1 |= N1.b.b(this, arr_s[v]);
            }
            ViewUtils.setEnable(this.agreeBtn, z1);
        }
        else if(!N1.b.b(this, "android.permission.READ_MEDIA_AUDIO")) {
            ViewUtils.setEnable(this.agreeBtn, false);
        }
        ViewUtils.setOnClickListener(this.agreeBtn, new k8.P(this, 3));
    }

    private static final void showPermissionFailPopup$lambda$24(MusicBrowserActivity musicBrowserActivity0, View view0) {
        if(Td.b.d(musicBrowserActivity0.getApplicationContext())) {
            MusicBrowserActivity.onCompleteCheckPermission$default(musicBrowserActivity0, false, 1, null);
            return;
        }
        musicBrowserActivity0.onChangedPermissionView(2);
        MusicBrowserActivity.checkRuntimePermission$default(musicBrowserActivity0, 0, 1, null);
    }

    private final void showRuntimePermissionGuide() {
        this.inflatePermissionCheckView();
        this.agreeBtn = (MelonTextView)this.findViewById(0x7F0A007C);  // id:agree_btn
        ViewUtils.setOrientation(this, 1);
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0312), new k8.P(this, 2));  // id:confirm_tv
    }

    private static final void showRuntimePermissionGuide$lambda$81(MusicBrowserActivity musicBrowserActivity0, View view0) {
        View view1 = musicBrowserActivity0.findViewById(0x7F0A0913);  // id:permission_required_container
        TextView textView0 = (TextView)musicBrowserActivity0.findViewById(0x7F0A0914);  // id:permission_required_description
        View view2 = musicBrowserActivity0.findViewById(0x7F0A0118);  // id:bottom_container
        view1.setVisibility(8);
        view2.setVisibility(8);
        ViewUtils.hideWhen(textView0, true);
        if(!Td.b.d(musicBrowserActivity0)) {
            musicBrowserActivity0.onChangedPermissionView(0);
        }
        MusicBrowserActivity.checkRuntimePermission$default(musicBrowserActivity0, 0, 1, null);
    }

    private final void showSplashPopup() {
        MelonSplashPopup melonSplashPopup0 = new MelonSplashPopup(this);
        melonSplashPopup0.setOnDismissListener(new l2(this, 3));
        melonSplashPopup0.show();
        this.splashPopup = melonSplashPopup0;
    }

    private static final void showSplashPopup$lambda$6$lambda$5(MusicBrowserActivity musicBrowserActivity0, DialogInterface dialogInterface0) {
        if(!musicBrowserActivity0.isFinishing()) {
            if(!NetUtils.isConnected() && k9.j.a() != 1) {
                musicBrowserActivity0.showDialogOfflinePayback(musicBrowserActivity0.getIntent());
                return;
            }
            if(AndroidSettings.isAirplaneMode()) {
                musicBrowserActivity0.showDialogOnAirplane();
                return;
            }
            if(!NetUtils.isConnected()) {
                musicBrowserActivity0.showDialogOnNetworkOff();
            }
        }
    }

    private final void startFlipLoops() {
        int v = 0;
        for(Object object0: this.bottomTabViewGroup) {
            if(v >= 0) {
                Job job0 = BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new o1(this, ((Z)object0), null), 2, null);
                List list0 = this.bottomTabViewGroup;
                Z z0 = (Z)list0.get(v);
                z0.getClass();
                kotlin.jvm.internal.q.g(z0.b, "visibleMode");
                kotlin.jvm.internal.q.g(z0.c, "iconUrl");
                kotlin.jvm.internal.q.g(z0.d, "tabContainer");
                kotlin.jvm.internal.q.g(z0.e, "tabIconView");
                kotlin.jvm.internal.q.g(z0.f, "serverIconView");
                list0.set(v, new Z(z0.a, z0.b, z0.c, z0.d, z0.e, z0.f, job0));
                ++v;
                continue;
            }
            e.k.O();
            throw null;
        }
    }

    private final void syncStatusBarModeWithCurrentFragment() {
        androidx.fragment.app.I i0 = this.getCurrentFragment();
        if(i0 instanceof MelonBaseFragment) {
            com.iloen.melon.custom.f1 f10 = ((MelonBaseFragment)i0).getInsetHandlingType();
            kotlin.jvm.internal.q.f(f10, "getInsetHandlingType(...)");
            this.updateSystemUiFit(f10);
        }
    }

    private final void trackBottomTab(String s) {
        q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
        MusicBrowserActivity.trackBottomTab$lambda$122(this, s, d0);
        ((com.kakao.tiara.track.Event)d0.p()).track();
    }

    private static final H trackBottomTab$lambda$122(MusicBrowserActivity musicBrowserActivity0, String s, q8.d d0) {
        kotlin.jvm.internal.q.g(d0, "$this$tiaraEventLogBuilder");
        MusicBrowserActivity.trackBottomTab$lambda$122$lambda$115(musicBrowserActivity0, ((q8.h)d0.b));
        q8.b b0 = (q8.b)d0.c;
        if(b0 == null) {
            q8.b b1 = new q8.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            MusicBrowserActivity.trackBottomTab$lambda$122$lambda$118(musicBrowserActivity0, b1);
            d0.c = b1;
        }
        else {
            MusicBrowserActivity.trackBottomTab$lambda$122$lambda$118(musicBrowserActivity0, b0);
        }
        q8.a a0 = (q8.a)d0.d;
        if(a0 != null) {
            MusicBrowserActivity.trackBottomTab$lambda$122$lambda$121(musicBrowserActivity0, s, a0);
            return H.a;
        }
        q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
        MusicBrowserActivity.trackBottomTab$lambda$122$lambda$121(musicBrowserActivity0, s, a1);
        d0.d = a1;
        return H.a;
    }

    private static final H trackBottomTab$lambda$122$lambda$115(MusicBrowserActivity musicBrowserActivity0, q8.h h0) {
        kotlin.jvm.internal.q.g(h0, "$this$track");
        String s = MusicBrowserActivity.trackBottomTab$lambda$122$lambda$115$lambda$114(musicBrowserActivity0);
        if(s == null) {
            s = "";
        }
        h0.a = s;
        return H.a;
    }

    private static final String trackBottomTab$lambda$122$lambda$115$lambda$114(MusicBrowserActivity musicBrowserActivity0) {
        return "페이지이동";
    }

    private static final H trackBottomTab$lambda$122$lambda$118(MusicBrowserActivity musicBrowserActivity0, q8.b b0) {
        kotlin.jvm.internal.q.g(b0, "$this$common");
        b0.a = MusicBrowserActivity.trackBottomTab$lambda$122$lambda$118$lambda$116(musicBrowserActivity0);
        b0.b = MusicBrowserActivity.trackBottomTab$lambda$122$lambda$118$lambda$117(musicBrowserActivity0);
        return H.a;
    }

    private static final String trackBottomTab$lambda$122$lambda$118$lambda$116(MusicBrowserActivity musicBrowserActivity0) {
        return "GNB";
    }

    private static final String trackBottomTab$lambda$122$lambda$118$lambda$117(MusicBrowserActivity musicBrowserActivity0) {
        return "하단탭바";
    }

    private static final H trackBottomTab$lambda$122$lambda$121(MusicBrowserActivity musicBrowserActivity0, String s, q8.a a0) {
        kotlin.jvm.internal.q.g(a0, "$this$click");
        a0.a = MusicBrowserActivity.trackBottomTab$lambda$122$lambda$121$lambda$119(musicBrowserActivity0);
        a0.g = s;
        return H.a;
    }

    private static final String trackBottomTab$lambda$122$lambda$121$lambda$119(MusicBrowserActivity musicBrowserActivity0) {
        return "하단탭바";
    }

    private static final String trackBottomTab$lambda$122$lambda$121$lambda$120(String s) [...] // Inlined contents

    private final void trackTiaraForCoverWidget(Intent intent0, boolean z) {
        q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
        MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101(z, this, intent0, d0);
        ((com.kakao.tiara.track.Event)d0.p()).track();
    }

    public static void trackTiaraForCoverWidget$default(MusicBrowserActivity musicBrowserActivity0, Intent intent0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackTiaraForCoverWidget");
        }
        if((v & 2) != 0) {
            z = true;
        }
        musicBrowserActivity0.trackTiaraForCoverWidget(intent0, z);
    }

    private static final H trackTiaraForCoverWidget$lambda$101(boolean z, MusicBrowserActivity musicBrowserActivity0, Intent intent0, q8.d d0) {
        kotlin.jvm.internal.q.g(d0, "$this$tiaraEventLogBuilder");
        MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$87(musicBrowserActivity0, ((q8.h)d0.b));
        q8.b b0 = (q8.b)d0.c;
        if(b0 == null) {
            q8.b b1 = new q8.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$91(musicBrowserActivity0, b1);
            d0.c = b1;
        }
        else {
            MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$91(musicBrowserActivity0, b0);
        }
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$94(musicBrowserActivity0, a1);
            d0.d = a1;
        }
        else {
            MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$94(musicBrowserActivity0, a0);
        }
        if(z) {
            q8.f f0 = (q8.f)d0.f;
            if(f0 == null) {
                q8.f f1 = new q8.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$98(intent0, f1);
                d0.f = f1;
            }
            else {
                MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$98(intent0, f0);
            }
        }
        q8.c c0 = new q8.c();
        MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$100(c0);
        ((LinkedHashMap)d0.g).putAll(c0.a);
        return H.a;
    }

    private static final H trackTiaraForCoverWidget$lambda$101$lambda$100(q8.c c0) {
        kotlin.jvm.internal.q.g(c0, "$this$customProps");
        c0.a(new r5(13));
        return H.a;
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$100$lambda$99() [...] // Inlined contents

    private static final H trackTiaraForCoverWidget$lambda$101$lambda$87(MusicBrowserActivity musicBrowserActivity0, q8.h h0) {
        kotlin.jvm.internal.q.g(h0, "$this$track");
        String s = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$87$lambda$86(musicBrowserActivity0);
        if(s == null) {
            s = "";
        }
        h0.a = s;
        return H.a;
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$87$lambda$86(MusicBrowserActivity musicBrowserActivity0) {
        return "페이지이동";
    }

    private static final H trackTiaraForCoverWidget$lambda$101$lambda$91(MusicBrowserActivity musicBrowserActivity0, q8.b b0) {
        kotlin.jvm.internal.q.g(b0, "$this$common");
        b0.c = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$91$lambda$88();
        b0.a = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$91$lambda$89(musicBrowserActivity0);
        b0.b = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$91$lambda$90(musicBrowserActivity0);
        return H.a;
    }

    private static final ActionKind trackTiaraForCoverWidget$lambda$101$lambda$91$lambda$88() {
        return ActionKind.ClickContent;
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$91$lambda$89(MusicBrowserActivity musicBrowserActivity0) {
        return "위젯";
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$91$lambda$90(MusicBrowserActivity musicBrowserActivity0) {
        return "위젯_aos_z플립위젯";
    }

    private static final H trackTiaraForCoverWidget$lambda$101$lambda$94(MusicBrowserActivity musicBrowserActivity0, q8.a a0) {
        kotlin.jvm.internal.q.g(a0, "$this$click");
        a0.a = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$94$lambda$92(musicBrowserActivity0);
        a0.g = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$94$lambda$93(musicBrowserActivity0);
        return H.a;
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$94$lambda$92(MusicBrowserActivity musicBrowserActivity0) {
        return "플레이어";
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$94$lambda$93(MusicBrowserActivity musicBrowserActivity0) {
        return "현재재생목록";
    }

    private static final H trackTiaraForCoverWidget$lambda$101$lambda$98(Intent intent0, q8.f f0) {
        kotlin.jvm.internal.q.g(f0, "$this$pageMeta");
        f0.a = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$98$lambda$95(intent0);
        f0.b = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$98$lambda$96();
        f0.c = MusicBrowserActivity.trackTiaraForCoverWidget$lambda$101$lambda$98$lambda$97(intent0);
        return H.a;
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$98$lambda$95(Intent intent0) {
        return String.valueOf(intent0.getIntExtra("com.iloen.melon.intent.extra.widget.page_meta_id", -1));
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$98$lambda$96() {
        return Y.i(ContsTypeCode.SONG, "code(...)");
    }

    private static final String trackTiaraForCoverWidget$lambda$101$lambda$98$lambda$97(Intent intent0) {
        String s = intent0.getStringExtra("com.iloen.melon.intent.extra.widget.page_meta_name");
        return s == null ? "" : s;
    }

    private final void trackTiaraForHomeWidget(Actor actor0, String s) {
        int v;
        switch((actor0 == null ? -1 : k8.c0.a[actor0.ordinal()])) {
            case 3: {
                v = 0x7F130DBD;  // string:tiara_click_layer1_widget_21 "2*1"
                break;
            }
            case 4: {
                v = 0x7F130DBE;  // string:tiara_click_layer1_widget_22 "2*2"
                break;
            }
            case 5: {
                v = 0x7F130DBF;  // string:tiara_click_layer1_widget_41 "4*1"
                break;
            }
            case 6: {
                v = 0x7F130DC0;  // string:tiara_click_layer1_widget_42 "4*2"
                break;
            }
            default: {
                return;
            }
        }
        q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
        MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113(this, v, s, d0);
        ((com.kakao.tiara.track.Event)d0.p()).track();
    }

    private static final H trackTiaraForHomeWidget$lambda$113(MusicBrowserActivity musicBrowserActivity0, int v, String s, q8.d d0) {
        kotlin.jvm.internal.q.g(d0, "$this$tiaraEventLogBuilder");
        MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$103(musicBrowserActivity0, ((q8.h)d0.b));
        q8.b b0 = (q8.b)d0.c;
        if(b0 == null) {
            q8.b b1 = new q8.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$107(musicBrowserActivity0, b1);
            d0.c = b1;
        }
        else {
            MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$107(musicBrowserActivity0, b0);
        }
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$110(musicBrowserActivity0, v, s, a1);
            d0.d = a1;
        }
        else {
            MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$110(musicBrowserActivity0, v, s, a0);
        }
        q8.c c0 = new q8.c();
        MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$112(c0);
        ((LinkedHashMap)d0.g).putAll(c0.a);
        return H.a;
    }

    private static final H trackTiaraForHomeWidget$lambda$113$lambda$103(MusicBrowserActivity musicBrowserActivity0, q8.h h0) {
        kotlin.jvm.internal.q.g(h0, "$this$track");
        String s = MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$103$lambda$102(musicBrowserActivity0);
        if(s == null) {
            s = "";
        }
        h0.a = s;
        return H.a;
    }

    private static final String trackTiaraForHomeWidget$lambda$113$lambda$103$lambda$102(MusicBrowserActivity musicBrowserActivity0) {
        return "페이지이동";
    }

    private static final H trackTiaraForHomeWidget$lambda$113$lambda$107(MusicBrowserActivity musicBrowserActivity0, q8.b b0) {
        kotlin.jvm.internal.q.g(b0, "$this$common");
        b0.c = MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$107$lambda$104();
        b0.a = MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$107$lambda$105(musicBrowserActivity0);
        b0.b = MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$107$lambda$106(musicBrowserActivity0);
        return H.a;
    }

    private static final ActionKind trackTiaraForHomeWidget$lambda$113$lambda$107$lambda$104() {
        return ActionKind.ClickContent;
    }

    private static final String trackTiaraForHomeWidget$lambda$113$lambda$107$lambda$105(MusicBrowserActivity musicBrowserActivity0) {
        return "위젯";
    }

    private static final String trackTiaraForHomeWidget$lambda$113$lambda$107$lambda$106(MusicBrowserActivity musicBrowserActivity0) {
        return "위젯_aos_바탕화면위젯";
    }

    private static final H trackTiaraForHomeWidget$lambda$113$lambda$110(MusicBrowserActivity musicBrowserActivity0, int v, String s, q8.a a0) {
        kotlin.jvm.internal.q.g(a0, "$this$click");
        a0.a = MusicBrowserActivity.trackTiaraForHomeWidget$lambda$113$lambda$110$lambda$108(musicBrowserActivity0, v);
        a0.g = s;
        return H.a;
    }

    private static final String trackTiaraForHomeWidget$lambda$113$lambda$110$lambda$108(MusicBrowserActivity musicBrowserActivity0, int v) {
        return musicBrowserActivity0.getString(v);
    }

    private static final String trackTiaraForHomeWidget$lambda$113$lambda$110$lambda$109(String s) [...] // Inlined contents

    private static final H trackTiaraForHomeWidget$lambda$113$lambda$112(q8.c c0) {
        kotlin.jvm.internal.q.g(c0, "$this$customProps");
        c0.a(new r5(15));
        return H.a;
    }

    private static final String trackTiaraForHomeWidget$lambda$113$lambda$112$lambda$111() [...] // Inlined contents

    private final void triggerPremiumDownload(List list0, List list1, String s) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            Playable playable0 = (Playable)object0;
            for(Object object1: list1) {
                String s1 = playable0.getContentId();
                kotlin.jvm.internal.q.f(s1, "getContentId(...)");
                if(s1.equalsIgnoreCase(((String)object1))) {
                    arrayList0.add(playable0);
                }
            }
        }
        k9.j.f(arrayList0);
    }

    private final void tryExtendDrmContents(Yb.h h0) {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getIO(), null, new p1(this, h0, null), 2, null);
    }

    public static void u(Uri uri0) {
        MusicBrowserActivity.handlePendingIntent$lambda$16$lambda$13(uri0);
    }

    @Override  // com.iloen.melon.Hilt_MusicBrowserActivity
    public void updateSystemUiFit(@NotNull com.iloen.melon.custom.f1 f10) {
        kotlin.jvm.internal.q.g(f10, "type");
        View view0 = this.mainContainer;
        if(view0 != null) {
            int v = f10.ordinal();
            if(v == 0) {
                M.n(view0, new com.kakao.emoticon.ui.widget.b(view0, 2));
                ScreenUtils.setAppearanceLightStatusBars(this.getWindow(), !ScreenUtils.isDarkMode(this.getBaseContext()));
            }
            else {
                switch(v) {
                    case 1: {
                        M.n(view0, new com.kakao.emoticon.ui.widget.b(view0, 3));
                        ScreenUtils.setAppearanceLightStatusBars(this.getWindow(), false);
                        break;
                    }
                    case 2: {
                        M.n(view0, new com.kakao.emoticon.ui.widget.b(view0, 4));
                        ScreenUtils.setAppearanceLightStatusBars(this.getWindow(), !ScreenUtils.isDarkMode(this.getBaseContext()));
                        break;
                    }
                    case 3: {
                        androidx.fragment.app.I i0 = this.getCurrentFragment();
                        c0 c00 = i0 instanceof c0 ? ((c0)i0) : null;
                        if(c00 != null) {
                            we.k k0 = c00.getCustomInsetHandling();
                            if(k0 != null) {
                                k0.invoke(view0);
                            }
                        }
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            view0.requestApplyInsets();
        }
    }

    private static final c2.B0 updateSystemUiFit$lambda$61$lambda$58(View view0, View view1, c2.B0 b00) {
        kotlin.jvm.internal.q.g(view1, "<unused var>");
        kotlin.jvm.internal.q.g(b00, "insets");
        S1.d d0 = b00.a.g(647);
        kotlin.jvm.internal.q.f(d0, "getInsets(...)");
        view0.setPadding(d0.a, d0.b, d0.c, d0.d);
        return b00;
    }

    private static final c2.B0 updateSystemUiFit$lambda$61$lambda$59(View view0, View view1, c2.B0 b00) {
        kotlin.jvm.internal.q.g(view1, "<unused var>");
        kotlin.jvm.internal.q.g(b00, "insets");
        S1.d d0 = b00.a.g(647);
        kotlin.jvm.internal.q.f(d0, "getInsets(...)");
        view0.setPadding(d0.a, 0, d0.c, d0.d);
        return b00;
    }

    private static final c2.B0 updateSystemUiFit$lambda$61$lambda$60(View view0, View view1, c2.B0 b00) {
        kotlin.jvm.internal.q.g(view1, "<unused var>");
        kotlin.jvm.internal.q.g(b00, "insets");
        S1.d d0 = b00.a.g(0x28F);
        kotlin.jvm.internal.q.f(d0, "getInsets(...)");
        view0.setPadding(d0.a, d0.b, d0.c, d0.d);
        return b00;
    }

    public static void v(MusicBrowserActivity musicBrowserActivity0, int v) {
        MusicBrowserActivity.selectTab$lambda$28(musicBrowserActivity0, v);
    }

    public static String x() [...] // 潜在的解密器
}

