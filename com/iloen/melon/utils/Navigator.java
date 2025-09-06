package com.iloen.melon.utils;

import A8.M;
import Ac.V2;
import Ac.h4;
import Ac.o4;
import Cd.G;
import Dd.g0;
import Dd.n1;
import Dd.p;
import E9.h;
import Fd.D;
import Hd.J;
import Hd.T;
import Ic.k;
import Lc.j;
import Ld.i;
import M6.B;
import Ma.c;
import Ub.s;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import com.android.volley.Response.Listener;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.activity.PhotoDetailActivity;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonFragmentManager.FragmentAnimations;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment;
import com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment;
import com.iloen.melon.fragments.artistchannel.NowPlayingAddFragment.NowPlayingEditFragment;
import com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment;
import com.iloen.melon.fragments.artistchannel.topic.TopicFragment;
import com.iloen.melon.fragments.cashfriends.CashFriendsFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.CmtListFragment;
import com.iloen.melon.fragments.detail.AlbumDetailContentsStationFragment;
import com.iloen.melon.fragments.detail.ArtistPlaylistDetailContentsAllSongFragment;
import com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.BookletDetailViewFragment;
import com.iloen.melon.fragments.detail.DjPlaylistDetailContentsAllSongFragment;
import com.iloen.melon.fragments.detail.DjPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.LyricHighLightFragment;
import com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.ForUDetailParam;
import com.iloen.melon.fragments.detail.MixPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.PhotoDetailViewCommentFragment;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment;
import com.iloen.melon.fragments.detail.PlaylistDetailContentsAllSongFragment;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.fragments.detail.SongDetailContentsStationFragment;
import com.iloen.melon.fragments.detail.SongDetailFragment;
import com.iloen.melon.fragments.detail.StationEpisodeDetailFragment;
import com.iloen.melon.fragments.genre.Genre.More_Fragment_Type;
import com.iloen.melon.fragments.genre.GenreArtistDetailFragment;
import com.iloen.melon.fragments.genre.GenreDetailLabelFragment;
import com.iloen.melon.fragments.genre.GenreDetailMoreMasterPieceFragment;
import com.iloen.melon.fragments.genre.GenreDetailMoreTabFragment;
import com.iloen.melon.fragments.genre.GenreFragmentFactory;
import com.iloen.melon.fragments.main.foru.ForUMusicSettingFragment;
import com.iloen.melon.fragments.main.foru.ForUSelfRecommendSearchFragment;
import com.iloen.melon.fragments.main.foru.ForUUtils;
import com.iloen.melon.fragments.melonchart.MelonChartPagerFragment;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment;
import com.iloen.melon.fragments.melontv.MelonTvTabFragment;
import com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.fragments.mymusic.MyMusicTabFragment;
import com.iloen.melon.fragments.mymusic.SeriesFolderDetailFragment;
import com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment;
import com.iloen.melon.fragments.present.PresentSongSendFragment;
import com.iloen.melon.fragments.present.PresentSongSendFragmentKt;
import com.iloen.melon.fragments.settings.KakaoMelonLoginFragment;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment;
import com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment;
import com.iloen.melon.fragments.webview.MelonWebViewDefaultFragment;
import com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFirstDepthFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenBlankFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment.ParamItem;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenWithBackButtonFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenWithBarFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenWithMiniPlayerFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.net.v4x.request.GiftInsertGiftBoxKeyReq;
import com.iloen.melon.net.v4x.response.GiftInsertGiftBoxKeyRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.net.v6x.request.ArtistContentsPhotoListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsPhotoListReq;
import com.iloen.melon.net.v6x.request.ForUMixInformReq;
import com.iloen.melon.net.v6x.response.ArtistContentsPhotoListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistContentsPhotoListRes;
import com.iloen.melon.net.v6x.response.ForUMixInformRes;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Live;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MV;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Station;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.player.playlist.PlaylistMainFragment;
import com.iloen.melon.popup.H;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.network.UrlUtil;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.v3.CommentConfig;
import d3.g;
import d5.f;
import d5.w;
import d8.d;
import e1.F;
import e1.u;
import gd.A2;
import gd.F4;
import gd.I0;
import gd.J6;
import gd.Q7;
import gd.q6;
import gd.u1;
import hd.Y1;
import hd.s1;
import ie.m;
import ie.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jd.F1;
import jd.X0;
import k8.Y;
import k8.o;
import k8.t;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.guava.ListenableFutureKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;
import rd.P;
import td.b0;
import ud.C;
import va.e0;
import we.n;

@Metadata(d1 = {"\u0000\u00C2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u00C7\u0002\u0018\u00002\u00020\u0001:\u0002\u00B0\u0002JC\u0010\u000B\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0018\u0010\u0007\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\n\u00A2\u0006\u0004\b\u000F\u0010\u000EJ\u0017\u0010\u0012\u001A\u00020\n2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0012\u001A\u00020\n2\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001F\u0010\u001B\u001A\u00020\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u001E\u001A\u00020\u001D\u00A2\u0006\u0004\b\u001B\u0010\u001FJ\u0017\u0010!\u001A\u00020\n2\b\u0010 \u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001A\u00020\n2\b\u0010 \u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b#\u0010\"J\'\u0010#\u001A\u00020\n2\b\u0010 \u001A\u0004\u0018\u00010\u00022\u0006\u0010%\u001A\u00020$2\u0006\u0010&\u001A\u00020$\u00A2\u0006\u0004\b#\u0010\'J!\u0010)\u001A\u00020\n2\b\u0010 \u001A\u0004\u0018\u00010\u00022\b\u0010(\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b)\u0010*J=\u0010/\u001A\u00020\n2\u0006\u0010(\u001A\u00020\u00022\b\u0010+\u001A\u0004\u0018\u00010\u00022\b\u0010,\u001A\u0004\u0018\u00010\u00022\b\u0010-\u001A\u0004\u0018\u00010\u00022\b\u0010.\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b/\u00100J)\u00104\u001A\u00020\n2\b\u00101\u001A\u0004\u0018\u00010\u00022\b\u00102\u001A\u0004\u0018\u00010\u00022\u0006\u00103\u001A\u00020$\u00A2\u0006\u0004\b4\u00105J+\u00108\u001A\u00020\n2\b\u00101\u001A\u0004\u0018\u00010\u00022\b\u00106\u001A\u0004\u0018\u00010\u00022\b\u00107\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b8\u00109J5\u0010<\u001A\u00020\n2\b\u0010:\u001A\u0004\u0018\u00010\u00022\b\u00101\u001A\u0004\u0018\u00010\u00022\b\u0010;\u001A\u0004\u0018\u00010\u00022\b\u00106\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b<\u0010=J=\u0010>\u001A\u00020\n2\b\u0010:\u001A\u0004\u0018\u00010\u00022\b\u00101\u001A\u0004\u0018\u00010\u00022\b\u00106\u001A\u0004\u0018\u00010\u00022\b\u0010;\u001A\u0004\u0018\u00010\u00022\u0006\u0010%\u001A\u00020$\u00A2\u0006\u0004\b>\u0010?J\u0017\u0010<\u001A\u00020\n2\b\u0010:\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b<\u0010\"J!\u0010A\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010@\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\bA\u0010*J3\u0010E\u001A\u00020\n2\u0006\u0010B\u001A\u00020$2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010C\u001A\u0004\u0018\u00010\u00022\b\u0010D\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\bE\u0010FJ)\u0010E\u001A\u00020\n2\u0006\u0010B\u001A\u00020$2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010G\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\bE\u0010HJ\u0017\u0010I\u001A\u00020\n2\b\u0010:\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\bI\u0010\"J+\u0010L\u001A\u00020\n2\b\u0010:\u001A\u0004\u0018\u00010\u00022\b\u0010J\u001A\u0004\u0018\u00010\u00022\b\u0010K\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\bL\u00109J;\u0010R\u001A\u00020\n2\u001A\u0010P\u001A\u0016\u0012\u0004\u0012\u00020N\u0018\u00010Mj\n\u0012\u0004\u0012\u00020N\u0018\u0001`O2\b\u0010@\u001A\u0004\u0018\u00010\u00022\u0006\u0010Q\u001A\u00020\u001D\u00A2\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001A\u00020\n2\b\b\u0002\u0010T\u001A\u00020$\u00A2\u0006\u0004\bU\u0010VJ\r\u0010W\u001A\u00020\n\u00A2\u0006\u0004\bW\u0010\u000EJ\r\u0010X\u001A\u00020\n\u00A2\u0006\u0004\bX\u0010\u000EJ\u0019\u0010Z\u001A\u00020\n2\b\b\u0002\u0010Y\u001A\u00020\u001DH\u0007\u00A2\u0006\u0004\bZ\u0010[J\u0019\u0010\\\u001A\u00020\n2\b\b\u0002\u0010Y\u001A\u00020\u001DH\u0007\u00A2\u0006\u0004\b\\\u0010[J\r\u0010]\u001A\u00020\n\u00A2\u0006\u0004\b]\u0010\u000EJ\r\u0010^\u001A\u00020\n\u00A2\u0006\u0004\b^\u0010\u000EJ\u0019\u0010_\u001A\u00020\n2\b\b\u0002\u0010Y\u001A\u00020\u001DH\u0007\u00A2\u0006\u0004\b_\u0010[J\r\u0010`\u001A\u00020\n\u00A2\u0006\u0004\b`\u0010\u000EJ\u0015\u0010`\u001A\u00020\n2\u0006\u0010b\u001A\u00020a\u00A2\u0006\u0004\b`\u0010cJ\u0017\u0010`\u001A\u00020\n2\b\u0010e\u001A\u0004\u0018\u00010d\u00A2\u0006\u0004\b`\u0010fJ\r\u0010g\u001A\u00020\n\u00A2\u0006\u0004\bg\u0010\u000EJ\u0017\u0010g\u001A\u00020\n2\b\u0010h\u001A\u0004\u0018\u00010d\u00A2\u0006\u0004\bg\u0010fJ\r\u0010i\u001A\u00020\n\u00A2\u0006\u0004\bi\u0010\u000EJ\r\u0010j\u001A\u00020\n\u00A2\u0006\u0004\bj\u0010\u000EJ\r\u0010k\u001A\u00020\n\u00A2\u0006\u0004\bk\u0010\u000EJ\u0017\u0010m\u001A\u00020\n2\b\u0010l\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\bm\u0010\"J\r\u0010n\u001A\u00020\n\u00A2\u0006\u0004\bn\u0010\u000EJ\u001F\u0010q\u001A\u00020\n2\b\u0010o\u001A\u0004\u0018\u00010\u00022\u0006\u0010p\u001A\u00020$\u00A2\u0006\u0004\bq\u0010rJ-\u0010v\u001A\u00020\n2\b\u0010s\u001A\u0004\u0018\u00010\u00022\b\u0010t\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010u\u001A\u00020$H\u0007\u00A2\u0006\u0004\bv\u00105J\u0015\u0010v\u001A\u00020\n2\u0006\u0010x\u001A\u00020w\u00A2\u0006\u0004\bv\u0010yJ\u0015\u0010{\u001A\u00020\n2\u0006\u0010z\u001A\u00020\u001D\u00A2\u0006\u0004\b{\u0010[J\u001D\u0010{\u001A\u00020\n2\u0006\u0010z\u001A\u00020\u001D2\u0006\u0010|\u001A\u00020\u001D\u00A2\u0006\u0004\b{\u0010}J\u0015\u0010\u007F\u001A\u00020\n2\u0006\u0010~\u001A\u00020\u0002\u00A2\u0006\u0004\b\u007F\u0010\"J$\u0010\u0082\u0001\u001A\u00020\n2\u0007\u0010\u0080\u0001\u001A\u00020$2\t\b\u0002\u0010\u0081\u0001\u001A\u00020$\u00A2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J$\u0010\u0084\u0001\u001A\u00020\n2\u0007\u0010\u0080\u0001\u001A\u00020$2\t\b\u0002\u0010\u0081\u0001\u001A\u00020$\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0083\u0001J\u000F\u0010\u0085\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u0085\u0001\u0010\u000EJ$\u0010\u0086\u0001\u001A\u00020\n2\u0007\u0010\u0080\u0001\u001A\u00020$2\t\b\u0002\u0010\u0081\u0001\u001A\u00020$\u00A2\u0006\u0006\b\u0086\u0001\u0010\u0083\u0001J\u000F\u0010\u0087\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u0087\u0001\u0010\u000EJ$\u0010\u0088\u0001\u001A\u00020\n2\u0007\u0010\u0080\u0001\u001A\u00020$2\t\b\u0002\u0010\u0081\u0001\u001A\u00020$\u00A2\u0006\u0006\b\u0088\u0001\u0010\u0083\u0001J$\u0010\u0089\u0001\u001A\u00020\n2\u0007\u0010\u0080\u0001\u001A\u00020$2\t\b\u0002\u0010\u0081\u0001\u001A\u00020$\u00A2\u0006\u0006\b\u0089\u0001\u0010\u0083\u0001J\u000F\u0010\u008A\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u008A\u0001\u0010\u000EJ\u001A\u0010\u008C\u0001\u001A\u00020\n2\t\u0010\u008B\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u008C\u0001\u0010\"J\u001A\u0010\u008E\u0001\u001A\u00020\n2\t\u0010\u008D\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u008E\u0001\u0010\"J&\u0010\u0093\u0001\u001A\u00020\n2\n\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u00012\b\u0010\u0092\u0001\u001A\u00030\u0091\u0001\u00A2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001A\u0010\u0096\u0001\u001A\u00020\n2\t\u0010\u0095\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u0096\u0001\u0010\"J\u001A\u0010\u0098\u0001\u001A\u00020\n2\t\u0010\u0097\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u0098\u0001\u0010\"J\u0019\u0010\u0099\u0001\u001A\u00020\n2\b\u0010Y\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u0099\u0001\u0010\"J\u0018\u0010\u009B\u0001\u001A\u00020\n2\u0007\u0010\u009A\u0001\u001A\u00020\u001D\u00A2\u0006\u0005\b\u009B\u0001\u0010[J\u000F\u0010\u009C\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u009C\u0001\u0010\u000EJ0\u0010\u00A0\u0001\u001A\u00020\n2\t\u0010\u009D\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u009E\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u009F\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00A0\u0001\u00109J(\u0010\u00A3\u0001\u001A\u00020\n2\t\u0010\u00A1\u0001\u001A\u0004\u0018\u00010\u00022\t\b\u0002\u0010\u00A2\u0001\u001A\u00020\u001DH\u0007\u00A2\u0006\u0006\b\u00A3\u0001\u0010\u00A4\u0001J\u000F\u0010\u00A5\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00A5\u0001\u0010\u000EJ\u001A\u0010\u00A7\u0001\u001A\u00020\n2\t\u0010\u00A6\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00A7\u0001\u0010\"J\u001A\u0010\u00A9\u0001\u001A\u00020\n2\t\u0010\u00A8\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00A9\u0001\u0010\"J\u000F\u0010\u00AA\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00AA\u0001\u0010\u000EJ%\u0010\u00AD\u0001\u001A\u00020\n2\t\u0010\u00AB\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00AC\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00AD\u0001\u0010*JN\u0010\u00B4\u0001\u001A\u00020\n2\b\u0010\u00AF\u0001\u001A\u00030\u00AE\u00012\t\u0010\u00B0\u0001\u001A\u0004\u0018\u00010\u00022\u000B\b\u0002\u0010\u00B1\u0001\u001A\u0004\u0018\u00010\u00022\u000B\b\u0002\u0010\u00B2\u0001\u001A\u0004\u0018\u00010\u00022\u000B\b\u0002\u0010\u00B3\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0006\b\u00B4\u0001\u0010\u00B5\u0001J\u001A\u0010\u00B7\u0001\u001A\u00020\n2\t\u0010\u00B6\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00B7\u0001\u0010\"J\u000F\u0010\u00B8\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00B8\u0001\u0010\u000EJ\u000F\u0010\u00B9\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00B9\u0001\u0010\u000EJ\u000F\u0010\u00BA\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00BA\u0001\u0010\u000EJ%\u0010\u00BA\u0001\u001A\u00020\n2\t\u0010\u00BB\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00BC\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00BA\u0001\u0010*J\u000F\u0010\u00BD\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00BD\u0001\u0010\u000EJ\u001A\u0010\u00BD\u0001\u001A\u00020\n2\t\u0010\u00BE\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00BD\u0001\u0010\"J\u001A\u0010\u00C0\u0001\u001A\u00020\n2\t\u0010\u00BF\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00C0\u0001\u0010\"J\u001A\u0010\u00C2\u0001\u001A\u00020\n2\t\u0010\u00C1\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00C2\u0001\u0010\"J%\u0010\u00C4\u0001\u001A\u00020\n2\t\u0010\u00C1\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00C3\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00C4\u0001\u0010*J%\u0010\u00C5\u0001\u001A\u00020\n2\t\u0010\u00C1\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00C3\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00C5\u0001\u0010*J\u001A\u0010\u00C7\u0001\u001A\u00020\n2\t\u0010\u00C6\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00C7\u0001\u0010\"J\u001A\u0010\u00C9\u0001\u001A\u00020\n2\t\u0010\u00C8\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00C9\u0001\u0010\"J\u000F\u0010\u00CA\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00CA\u0001\u0010\u000EJ\u001A\u0010\u00CB\u0001\u001A\u00020\n2\t\u0010\u0097\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00CB\u0001\u0010\"J\u001C\u0010\u00CE\u0001\u001A\u00020\n2\n\u0010\u00CD\u0001\u001A\u0005\u0018\u00010\u00CC\u0001\u00A2\u0006\u0006\b\u00CE\u0001\u0010\u00CF\u0001J0\u0010\u00CE\u0001\u001A\u00020\n2\t\u0010\u00D0\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00D1\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00D2\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00CE\u0001\u00109J;\u0010\u00CE\u0001\u001A\u00020\n2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00142\t\u0010\u00D0\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00D1\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00D2\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0006\b\u00CE\u0001\u0010\u00D3\u0001J\u000F\u0010\u00D4\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00D4\u0001\u0010\u000EJ\u0019\u0010\u00D5\u0001\u001A\u00020\n2\b\u0010~\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00D5\u0001\u0010\"J\u001A\u0010\u00D6\u0001\u001A\u00020\n2\t\u0010\u00A6\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00D6\u0001\u0010\"J\u001A\u0010\u00D8\u0001\u001A\u00020\n2\t\u0010\u00D7\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00D8\u0001\u0010\"J%\u0010\u00DB\u0001\u001A\u00020\n2\t\u0010\u00D9\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00DA\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00DB\u0001\u0010*J2\u0010\u00DB\u0001\u001A\u00020\n2\t\u0010\u00D9\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00DA\u0001\u001A\u0004\u0018\u00010\u00022\n\u0010\u00DD\u0001\u001A\u0005\u0018\u00010\u00DC\u0001\u00A2\u0006\u0006\b\u00DB\u0001\u0010\u00DE\u0001J\u000F\u0010\u00DF\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00DF\u0001\u0010\u000EJ\u001A\u0010\u00E0\u0001\u001A\u00020\n2\t\u0010\u00D9\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00E0\u0001\u0010\"J$\u0010\u00E2\u0001\u001A\u00020\n2\t\u0010\u0097\u0001\u001A\u0004\u0018\u00010\u00022\u0007\u0010\u00E1\u0001\u001A\u00020\u001D\u00A2\u0006\u0006\b\u00E2\u0001\u0010\u00A4\u0001J\u001A\u0010\u00E4\u0001\u001A\u00020\n2\t\u0010\u00E3\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00E4\u0001\u0010\"J%\u0010\u00E6\u0001\u001A\u00020\n2\t\u0010\u00A6\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00E5\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00E6\u0001\u0010*J\u001A\u0010\u00E8\u0001\u001A\u00020\n2\t\u0010\u00E7\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00E8\u0001\u0010\"J$\u0010\u00EA\u0001\u001A\u00020\n2\b\u00101\u001A\u0004\u0018\u00010\u00022\t\u0010\u00E9\u0001\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0005\b\u00EA\u0001\u0010*J\u000F\u0010\u00EB\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00EB\u0001\u0010\u000EJ\u000F\u0010\u00EC\u0001\u001A\u00020\n\u00A2\u0006\u0005\b\u00EC\u0001\u0010\u000EJA\u0010\u000B\u001A\u00020\n2\b\u0010@\u001A\u0004\u0018\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\u0007\u0010\u00ED\u0001\u001A\u00020$H\u0007\u00A2\u0006\u0005\b\u000B\u0010\u00EE\u0001J6\u0010\u000B\u001A\u00020\n2\b\u0010@\u001A\u0004\u0018\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0007\u00A2\u0006\u0005\b\u000B\u0010\u00EF\u0001J,\u0010\u000B\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0007\u00A2\u0006\u0005\b\u000B\u0010\u00F0\u0001J\"\u0010\u000B\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0005\b\u000B\u0010\u00F1\u0001J\u001B\u0010\u00F2\u0001\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00F2\u0001\u0010\"J%\u0010\u00F2\u0001\u001A\u00020\n2\b\u0010@\u001A\u0004\u0018\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00F2\u0001\u0010*J%\u0010\u00F3\u0001\u001A\u00020\n2\b\u0010@\u001A\u0004\u0018\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00F3\u0001\u0010*J#\u0010\u00F6\u0001\u001A\u00020\n2\u0007\u0010\u00F4\u0001\u001A\u00020\u00022\u0007\u0010\u00F5\u0001\u001A\u00020\u0002H\u0007\u00A2\u0006\u0005\b\u00F6\u0001\u0010*J\u0011\u0010\u00F7\u0001\u001A\u00020\nH\u0007\u00A2\u0006\u0005\b\u00F7\u0001\u0010\u000EJ\u001B\u0010\u0012\u001A\u00020\n2\t\u0010\u00F8\u0001\u001A\u0004\u0018\u00010\u0014H\u0007\u00A2\u0006\u0005\b\u0012\u0010\u00F9\u0001J\u001B\u0010\u00FA\u0001\u001A\u00020\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0007\u00A2\u0006\u0005\b\u00FA\u0001\u0010\u001CJ\u001B\u0010\u00FB\u0001\u001A\u00020\n2\b\u0010+\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00FB\u0001\u0010\"J&\u0010\u00FD\u0001\u001A\u00020\n2\b\u0010 \u001A\u0004\u0018\u00010\u00022\t\u0010\u00FC\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00FD\u0001\u0010*J\u001A\u0010\u00FE\u0001\u001A\u00020\n2\u0007\u0010\u00A6\u0001\u001A\u00020\u0002H\u0007\u00A2\u0006\u0005\b\u00FE\u0001\u0010\"J\u001C\u0010\u00FF\u0001\u001A\u00020\n2\t\u0010\u00D7\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00FF\u0001\u0010\"J\u0019\u00104\u001A\u00020\n2\b\u00101\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b4\u0010\"JA\u0010\u0083\u0002\u001A\u00020\n2\t\u0010\u0080\u0002\u001A\u0004\u0018\u00010\u00022\t\u0010\u00DA\u0001\u001A\u0004\u0018\u00010\u00022\f\b\u0002\u0010\u0081\u0002\u001A\u0005\u0018\u00010\u00DC\u00012\t\b\u0002\u0010\u0082\u0002\u001A\u00020$H\u0007\u00A2\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002J\u0019\u0010E\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bE\u0010\"J\u0011\u0010\u0085\u0002\u001A\u00020\nH\u0007\u00A2\u0006\u0005\b\u0085\u0002\u0010\u000EJ\u001C\u0010\u0087\u0002\u001A\u00020\n2\t\u0010\u0086\u0002\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u0087\u0002\u0010\"J\u001C\u0010\u0087\u0002\u001A\u00020\n2\t\u0010\u0088\u0002\u001A\u0004\u0018\u00010\u0019H\u0007\u00A2\u0006\u0005\b\u0087\u0002\u0010\u001CJ\u001C\u0010\u008A\u0002\u001A\u00020\n2\t\u0010\u0089\u0002\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u008A\u0002\u0010\"J%\u0010\u008A\u0002\u001A\u00020\n2\t\u0010\u0089\u0002\u001A\u0004\u0018\u00010\u00022\u0007\u0010\u008B\u0002\u001A\u00020$H\u0007\u00A2\u0006\u0005\b\u008A\u0002\u0010rJ%\u0010\u008C\u0002\u001A\u00020\n2\t\u0010\u0089\u0002\u001A\u0004\u0018\u00010\u00022\u0007\u0010\u008B\u0002\u001A\u00020$H\u0007\u00A2\u0006\u0005\b\u008C\u0002\u0010rJ\u001B\u0010\u008D\u0002\u001A\u00020\n2\b\u0010x\u001A\u0004\u0018\u00010wH\u0007\u00A2\u0006\u0005\b\u008D\u0002\u0010yJE\u0010\u0092\u0002\u001A\u00020\n2\u0006\u0010J\u001A\u00020\u001D2\u0007\u0010\u008E\u0002\u001A\u00020\u00022\b\u0010\u0090\u0002\u001A\u00030\u008F\u00022\f\b\u0002\u0010\u00BB\u0001\u001A\u0005\u0018\u00010\u0091\u00022\b\b\u0002\u0010K\u001A\u00020\u001DH\u0007\u00A2\u0006\u0006\b\u0092\u0002\u0010\u0093\u0002J\u000F\u0010{\u001A\u00020\nH\u0007\u00A2\u0006\u0004\b{\u0010\u000EJ\u0011\u0010\u0094\u0002\u001A\u00020\nH\u0007\u00A2\u0006\u0005\b\u0094\u0002\u0010\u000EJ\u001C\u0010\u0095\u0002\u001A\u00020\n2\t\u0010\u008D\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u0095\u0002\u0010\"J\u0011\u0010\u0096\u0002\u001A\u00020\nH\u0007\u00A2\u0006\u0005\b\u0096\u0002\u0010\u000EJ\u001C\u0010\u0098\u0002\u001A\u00020\n2\t\u0010\u0097\u0002\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u0098\u0002\u0010\"J\u0011\u0010\u0098\u0001\u001A\u00020\nH\u0007\u00A2\u0006\u0005\b\u0098\u0001\u0010\u000EJ\u001C\u0010\u009A\u0002\u001A\u00020\n2\t\u0010\u0099\u0002\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u009A\u0002\u0010\"J\u0011\u0010\u009B\u0002\u001A\u00020\nH\u0007\u00A2\u0006\u0005\b\u009B\u0002\u0010\u000EJ\u0011\u0010\u009C\u0002\u001A\u00020\nH\u0007\u00A2\u0006\u0005\b\u009C\u0002\u0010\u000EJ\u001A\u0010\u009D\u0002\u001A\u00020\n2\u0007\u0010\u00B0\u0001\u001A\u00020\u0002H\u0007\u00A2\u0006\u0005\b\u009D\u0002\u0010\"J1\u0010\u00A0\u0002\u001A\u00020\n2\u001D\u0010\u009F\u0002\u001A\u0018\u0012\u0005\u0012\u00030\u009E\u0002\u0018\u00010Mj\u000B\u0012\u0005\u0012\u00030\u009E\u0002\u0018\u0001`OH\u0007\u00A2\u0006\u0006\b\u00A0\u0002\u0010\u00A1\u0002Ja\u0010\u00A0\u0002\u001A\u00020\n2\u000B\b\u0002\u0010\u00DA\u0001\u001A\u0004\u0018\u00010\u00022\u001F\b\u0002\u0010\u009F\u0002\u001A\u0018\u0012\u0005\u0012\u00030\u009E\u0002\u0018\u00010Mj\u000B\u0012\u0005\u0012\u00030\u009E\u0002\u0018\u0001`O2\u001F\b\u0002\u0010\u00A3\u0002\u001A\u0018\u0012\u0005\u0012\u00030\u00A2\u0002\u0018\u00010Mj\u000B\u0012\u0005\u0012\u00030\u00A2\u0002\u0018\u0001`OH\u0007\u00A2\u0006\u0006\b\u00A0\u0002\u0010\u00A4\u0002J\u001C\u0010\u00A5\u0002\u001A\u00020\n2\t\u0010\u00C6\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00A5\u0002\u0010\"J6\u0010\u00A7\u0002\u001A\u00020\n2\t\u0010\u0097\u0001\u001A\u0004\u0018\u00010\u00022\u000B\b\u0002\u0010\u009A\u0001\u001A\u0004\u0018\u00010\u00022\u000B\b\u0002\u0010\u00A6\u0002\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00A7\u0002\u00109J\'\u0010\u00A8\u0002\u001A\u00020\n2\t\u0010\u00D1\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u00D2\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u00A8\u0002\u0010*J\'\u0010\u00AA\u0002\u001A\u00020\n2\n\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u00012\u0007\u0010\u00A9\u0002\u001A\u00020$H\u0007\u00A2\u0006\u0006\b\u00AA\u0002\u0010\u00AB\u0002J?\u0010\u00AE\u0002\u001A\u00020\n2\t\u0010\u00AC\u0002\u001A\u0004\u0018\u00010\u00022\t\u0010\u00DA\u0001\u001A\u0004\u0018\u00010\u00022\u0007\u0010\u00AD\u0002\u001A\u00020$2\f\b\u0002\u0010\u00DD\u0001\u001A\u0005\u0018\u00010\u00DC\u0001H\u0007\u00A2\u0006\u0006\b\u00AE\u0002\u0010\u00AF\u0002\u00A8\u0006\u00B1\u0002"}, d2 = {"Lcom/iloen/melon/utils/Navigator;", "", "", "url", "Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;", "openType", "", "additionalHttpHeaders", "Lcom/iloen/melon/utils/NameValuePairList;", "params", "Lie/H;", "openUrl", "(Ljava/lang/String;Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;Ljava/util/Map;Lcom/iloen/melon/utils/NameValuePairList;)V", "openMelonSupportMain", "()V", "openMelonSupportWebViewError", "Landroidx/fragment/app/I;", "fragment", "open", "(Landroidx/fragment/app/I;)V", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "f", "Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;", "animations", "(Lcom/iloen/melon/fragments/MelonBaseFragment;Lcom/iloen/melon/fragments/MelonFragmentManager$FragmentAnimations;)V", "Landroid/net/Uri;", "returnUri", "openMelonLoginView", "(Landroid/net/Uri;)V", "", "loginFragmentCount", "(Landroid/net/Uri;I)V", "plId", "openPlaylistDetail", "(Ljava/lang/String;)V", "openArtistPlaylistDetail", "", "showSnsPopup", "openReview", "(Ljava/lang/String;ZZ)V", "plylstType", "openPlaylistEdit", "(Ljava/lang/String;Ljava/lang/String;)V", "plylstSeq", "plylstName", "totalPlayTime", "totalSongCount", "openPlaylistAllSong", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "artistId", "cType", "autoPlay", "openArtistInfo", "(Ljava/lang/String;Ljava/lang/String;Z)V", "artistName", "artistImagePath", "openArtistImageWithPhoto", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "photoId", "artistImg", "openPhotoInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "openPhotoInfoList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "title", "openPhotoUrlWithTitle", "isActivity", "descrption", "pvLogDummyAction", "openPhotoUrl", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "description", "(ZLjava/lang/String;Ljava/lang/String;)V", "openPhotoInfoReview", "channelSeq", "commentSeq", "openPhotoInfoReply", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/detail/BookletDetailViewFragment$BookletInfo;", "Lkotlin/collections/ArrayList;", "list", "position", "openBooklet", "(Ljava/util/ArrayList;Ljava/lang/String;I)V", "fullScreen", "openVideoPlayer", "(Z)V", "openMusicAlarmList", "openVoiceAlarm", "type", "openMusicPlayer", "(I)V", "openDjMalrangPlayer", "openMusicWavePlayer", "openCreateMusicWaveChannel", "openNowPlayer", "openNowPlayList", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)V", "Landroid/os/Bundle;", "args", "(Landroid/os/Bundle;)V", "openStationPlayer", "arguments", "openDownloadManager", "openLocalContentMv", "installGooglePlayService", "year", "openMyMusicMyChartSpecificMonth", "openMusicDna", "monthLog", "includeShortcuts", "openMusicDnaMonthlyLog", "(Ljava/lang/String;Z)V", "chnlSeq", "contsRefValue", "hasParentLink", "openCommentRenewalVersion", "Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;", "param", "(Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;)V", "tabIndex", "openMelonTvMain", "orderByIndex", "(II)V", "progSeq", "openMelonTvProgram", "clearAllStack", "isScrollTop", "openMainMusic", "(ZZ)V", "openMainForu", "openMainForuAndClearStack", "openMainSearch", "openMainSearchAndClearStack", "openMainLibrary", "openMainMenu", "openMainLibraryAndClearStack", "giftAuthKey", "openGiftBoxDetailByKey", "giftno", "openPresentSendDetail", "Landroid/content/Context;", "context", "Lcom/iloen/melon/net/v4x/request/DeviceInformDeviceCheckReq$CallerType;", "callerType", "openDeviceRegisterUrl", "(Landroid/content/Context;Lcom/iloen/melon/net/v4x/request/DeviceInformDeviceCheckReq$CallerType;)V", "seqNum", "openNoticePage", "keyword", "openMelonDJTagSearch", "openNewAlbum", "tab", "openChartWithTab", "openChartArtist", "ageType", "ageYear", "genre", "openChartAge", "sort", "filterIndex", "openPeriodChart", "(Ljava/lang/String;I)V", "openChartTheme", "songId", "openStreamingCard", "genreCode", "openChartGenre", "openChartHottrack", "hottrackCode", "filterCode", "openChartHottrackDetail", "Lcom/iloen/melon/fragments/genre/Genre$More_Fragment_Type;", "moreType", "gnrCode", "gnrContsSeq", "filterTypeFlg", "filterTypeCode", "openGenreMore", "(Lcom/iloen/melon/fragments/genre/Genre$More_Fragment_Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "labelSeq", "openGenreDetailLabel", "openMelonDJMain", "openMelonDJThemeGenre", "openMelonPowerDj", "mode", "orderBy", "openMelonDjPopular", "term", "seriesSeq", "openSeriesFolderDetail", "djBrandKey", "openMelonDjPartnerInfo", "nickName", "openMelonDjBrandPlaylist", "openMelonDjBrandRecmSong", "nowPlayingSeq", "openNowPlayingDetail", "gnrArtistSeq", "openGenreArtistDetail", "openForUMusicSetting", "openForUSelfRecommend", "Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment$ForUDetailParam;", "forUDetailParam", "openMixPlaylist", "(Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment$ForUDetailParam;)V", "contsId", "seedContsId", "seedContsTypeCode", "(Lcom/iloen/melon/fragments/MelonBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "openStation", "openStationProgram", "openSongStation", "albumId", "openAlbumStation", "castSeq", "menuId", "openStationListen", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "openStationPopularDetail", "openCastEpisodeDetail", "navigateBackCount", "openMixMakerPlaylistDetail", "query", "openCashFriendsOfferWall", "endpointUrl", "openLyricHighlight", "graphType", "openHot100Graph", "topicSeq", "openTopic", "openMusicWaveHome", "openMusicWaveSearch", "post", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;Lcom/iloen/melon/utils/NameValuePairList;Z)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;Lcom/iloen/melon/utils/NameValuePairList;)V", "(Ljava/lang/String;Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;Lcom/iloen/melon/utils/NameValuePairList;)V", "(Ljava/lang/String;Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;)V", "openUrlFullScreenView", "openUrlFullScreenWithMiniPlayerView", "agreeUrl", "headerToken", "showKakaoProfileAgreePage", "openMelonSupportPlayback", "baseFragment", "(Lcom/iloen/melon/fragments/MelonBaseFragment;)V", "openLoginView", "openDjPlaylistDetail", "dummyAction", "openDjPlaylistEdit", "openSongInfo", "openAlbumInfo", "mvId", "statsElementsBase", "isFullscreen", "openMvInfo", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Z)V", "openSoundSearch", "packageName", "openMarket", "uri", "memberKey", "openUserMain", "isWithdraw", "openUserMainIncludeSelf", "openComments", "contentRefValue", "Lcom/melon/net/res/v3/CommentConfig;", "config", "LAc/o4;", "openCommentWrite", "(ILjava/lang/String;Lcom/melon/net/res/v3/CommentConfig;LAc/o4;I)V", "openMainMusicAndClearStack", "openGiftBoxDetailById", "openMelGunsCollection", "tagSeq", "openMelonDJTagHubDetail", "contentId", "openPhotoDetailView", "openNewMusicMain", "openChartMain", "openGenreDetail", "Lcom/iloen/melon/custom/ToReceiverView$Receiver;", "receivers", "openPresentSongSendFragment", "(Ljava/util/ArrayList;)V", "Lcom/iloen/melon/playback/Playable;", "playableList", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "openNowPlayingEdit", "order", "openSearchKeyword", "openSimilarSongList", "isAgree", "openAuthLocationAgreeUrl", "(Landroid/content/Context;Z)V", "liveSeq", "isFullScreen", "openLive", "(Ljava/lang/String;Ljava/lang/String;ZLcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "UrlOpenInto", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class Navigator {
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0003-.,B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\r\u0010\n\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BR\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR$\u0010\u0013\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\r\u001A\u0004\b\u0011\u0010\u000F\"\u0004\b\u0012\u0010\u0005R4\u0010\u001B\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR$\u0010#\u001A\u0004\u0018\u00010\u001C8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001A\u00020$8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/iloen/melon/utils/Navigator$UrlOpenInto;", "", "", "url", "<init>", "(Ljava/lang/String;)V", "Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "builder", "(Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;)V", "Lie/H;", "open", "()V", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "c", "getTitle", "setTitle", "title", "", "d", "Ljava/util/Map;", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "setAdditionalHttpHeaders", "(Ljava/util/Map;)V", "additionalHttpHeaders", "Lcom/iloen/melon/utils/NameValuePairList;", "e", "Lcom/iloen/melon/utils/NameValuePairList;", "getParams", "()Lcom/iloen/melon/utils/NameValuePairList;", "setParams", "(Lcom/iloen/melon/utils/NameValuePairList;)V", "params", "", "f", "Z", "getPost", "()Z", "setPost", "(Z)V", "post", "Companion", "OpenType", "UrlOpenIntoBuilder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class UrlOpenInto {
        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00072\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/utils/Navigator$UrlOpenInto$Companion;", "", "", "url", "Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "newBuilder", "(Ljava/lang/String;)Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "", "openExternalActivity", "(Ljava/lang/String;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final UrlOpenIntoBuilder newBuilder(@Nullable String s) {
                return new UrlOpenIntoBuilder(s);
            }

            public final boolean openExternalActivity(@Nullable String s) {
                Intent intent0 = new Intent("android.intent.action.VIEW");
                intent0.setFlags(0x10000000);
                intent0.setData(Uri.parse(s));
                try {
                    MelonAppBase.Companion.getClass();
                    t.a().getContext().startActivity(intent0);
                    return true;
                }
                catch(ActivityNotFoundException activityNotFoundException0) {
                    LogU.Companion.w("Navigator", "openUrlLink() ActivityNotFoundException: " + activityNotFoundException0);
                    return false;
                }
                catch(SecurityException securityException0) {
                    LogU.Companion.w("Navigator", "openUrlLink() SecurityException: " + securityException0);
                    return false;
                }
                catch(Exception exception0) {
                    LogU.Companion.w("Navigator", "openUrlLink() Exception: " + exception0);
                    return false;
                }
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000B\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;", "", "DefaultWebViewWithMiniPlayer", "DefaultWebView", "FirstDepth", "FirstDepthExtension", "FullScreen", "FullScreenBlank", "FullScreenWithMiniPlayer", "FullScreenWithBackButton", "FullScreenWithBar", "Browser", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static enum OpenType {
            DefaultWebViewWithMiniPlayer,
            DefaultWebView,
            FirstDepth,
            FirstDepthExtension,
            FullScreen,
            FullScreenBlank,
            FullScreenWithMiniPlayer,
            FullScreenWithBackButton,
            FullScreenWithBar,
            Browser;

            public static final OpenType[] a;
            public static final b b;

            static {
                OpenType.a = arr_navigator$UrlOpenInto$OpenType;
                q.g(arr_navigator$UrlOpenInto$OpenType, "entries");
                OpenType.b = new b(arr_navigator$UrlOpenInto$OpenType);
            }

            @NotNull
            public static a getEntries() {
                return OpenType.b;
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00002\b\u0010\t\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\'\u0010\f\u001A\u00020\u00002\u0018\u0010\f\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000B¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u00002\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R$\u0010\t\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001A\u0004\b\"\u0010\u001A\"\u0004\b#\u0010\u0005R4\u0010\f\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000B8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R$\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0012\u001A\u00020\u00118\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b0\u00101\u001A\u0004\b2\u00103\"\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "", "", "url", "<init>", "(Ljava/lang/String;)V", "Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;", "openType", "(Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;)Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "title", "(Ljava/lang/String;)Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "", "additionalHttpHeaders", "(Ljava/util/Map;)Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "Lcom/iloen/melon/utils/NameValuePairList;", "params", "(Lcom/iloen/melon/utils/NameValuePairList;)Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "", "post", "(Z)Lcom/iloen/melon/utils/Navigator$UrlOpenInto$UrlOpenIntoBuilder;", "Lcom/iloen/melon/utils/Navigator$UrlOpenInto;", "build", "()Lcom/iloen/melon/utils/Navigator$UrlOpenInto;", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "b", "Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;", "getOpenType", "()Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;", "setOpenType", "(Lcom/iloen/melon/utils/Navigator$UrlOpenInto$OpenType;)V", "c", "getTitle", "setTitle", "d", "Ljava/util/Map;", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "setAdditionalHttpHeaders", "(Ljava/util/Map;)V", "e", "Lcom/iloen/melon/utils/NameValuePairList;", "getParams", "()Lcom/iloen/melon/utils/NameValuePairList;", "setParams", "(Lcom/iloen/melon/utils/NameValuePairList;)V", "f", "Z", "getPost", "()Z", "setPost", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class UrlOpenIntoBuilder {
            public static final int $stable = 8;
            public final String a;
            public OpenType b;
            public String c;
            public Map d;
            public NameValuePairList e;
            public boolean f;

            public UrlOpenIntoBuilder(@Nullable String s) {
                this.a = s;
                this.b = OpenType.DefaultWebViewWithMiniPlayer;
            }

            @NotNull
            public final UrlOpenIntoBuilder additionalHttpHeaders(@Nullable Map map0) {
                this.d = map0;
                return this;
            }

            @NotNull
            public final UrlOpenInto build() {
                return new UrlOpenInto(this);
            }

            @Nullable
            public final Map getAdditionalHttpHeaders() {
                return this.d;
            }

            @NotNull
            public final OpenType getOpenType() {
                return this.b;
            }

            @Nullable
            public final NameValuePairList getParams() {
                return this.e;
            }

            public final boolean getPost() {
                return this.f;
            }

            @Nullable
            public final String getTitle() {
                return this.c;
            }

            @Nullable
            public final String getUrl() {
                return this.a;
            }

            @NotNull
            public final UrlOpenIntoBuilder openType(@NotNull OpenType navigator$UrlOpenInto$OpenType0) {
                q.g(navigator$UrlOpenInto$OpenType0, "openType");
                this.b = navigator$UrlOpenInto$OpenType0;
                return this;
            }

            @NotNull
            public final UrlOpenIntoBuilder params(@Nullable NameValuePairList nameValuePairList0) {
                this.e = nameValuePairList0;
                return this;
            }

            @NotNull
            public final UrlOpenIntoBuilder post(boolean z) {
                this.f = z;
                return this;
            }

            public final void setAdditionalHttpHeaders(@Nullable Map map0) {
                this.d = map0;
            }

            public final void setOpenType(@NotNull OpenType navigator$UrlOpenInto$OpenType0) {
                q.g(navigator$UrlOpenInto$OpenType0, "<set-?>");
                this.b = navigator$UrlOpenInto$OpenType0;
            }

            public final void setParams(@Nullable NameValuePairList nameValuePairList0) {
                this.e = nameValuePairList0;
            }

            public final void setPost(boolean z) {
                this.f = z;
            }

            public final void setTitle(@Nullable String s) {
                this.c = s;
            }

            @NotNull
            public final UrlOpenIntoBuilder title(@Nullable String s) {
                this.c = s;
                return this;
            }
        }

        public static final int $stable;
        @NotNull
        public static final Companion Companion;
        public final String a;
        public final OpenType b;
        public String c;
        public Map d;
        public NameValuePairList e;
        public boolean f;

        static {
            UrlOpenInto.Companion = new Companion(null);
            UrlOpenInto.$stable = 8;
        }

        public UrlOpenInto(@NotNull UrlOpenIntoBuilder navigator$UrlOpenInto$UrlOpenIntoBuilder0) {
            q.g(navigator$UrlOpenInto$UrlOpenIntoBuilder0, "builder");
            this(navigator$UrlOpenInto$UrlOpenIntoBuilder0.getUrl());
            this.b = navigator$UrlOpenInto$UrlOpenIntoBuilder0.getOpenType();
            this.c = navigator$UrlOpenInto$UrlOpenIntoBuilder0.getTitle();
            this.d = navigator$UrlOpenInto$UrlOpenIntoBuilder0.getAdditionalHttpHeaders();
            this.e = navigator$UrlOpenInto$UrlOpenIntoBuilder0.getParams();
            this.f = navigator$UrlOpenInto$UrlOpenIntoBuilder0.getPost();
        }

        public UrlOpenInto(@Nullable String s) {
            this.a = s;
            this.b = OpenType.FullScreenWithMiniPlayer;
        }

        public static ParamItem a(UrlOpenInto navigator$UrlOpenInto0) {
            ParamItem melonWebViewFullScreenFragment$ParamItem0 = new ParamItem();
            melonWebViewFullScreenFragment$ParamItem0.title = navigator$UrlOpenInto0.c;
            melonWebViewFullScreenFragment$ParamItem0.url = navigator$UrlOpenInto0.a;
            melonWebViewFullScreenFragment$ParamItem0.params = navigator$UrlOpenInto0.e;
            melonWebViewFullScreenFragment$ParamItem0.additionalHttpHeaders = navigator$UrlOpenInto0.d;
            melonWebViewFullScreenFragment$ParamItem0.post = navigator$UrlOpenInto0.f;
            return melonWebViewFullScreenFragment$ParamItem0;
        }

        public static void b(MelonWebViewFragment melonWebViewFragment0) {
            MelonFragmentManager.getInstance().open(melonWebViewFragment0, null);
        }

        @Nullable
        public final Map getAdditionalHttpHeaders() {
            return this.d;
        }

        @Nullable
        public final NameValuePairList getParams() {
            return this.e;
        }

        public final boolean getPost() {
            return this.f;
        }

        @Nullable
        public final String getTitle() {
            return this.c;
        }

        @Nullable
        public final String getUrl() {
            return this.a;
        }

        public final void open() {
            MelonAppBase.Companion.getClass();
            if(!NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                return;
            }
            OpenType navigator$UrlOpenInto$OpenType0 = this.b;
            if(OpenType.FullScreen == navigator$UrlOpenInto$OpenType0) {
                MelonWebViewFullScreenFragment melonWebViewFullScreenFragment0 = MelonWebViewFullScreenFragment.newInstance(UrlOpenInto.a(this));
                q.f(melonWebViewFullScreenFragment0, "newInstance(...)");
                UrlOpenInto.b(melonWebViewFullScreenFragment0);
                return;
            }
            if(OpenType.FullScreenBlank == navigator$UrlOpenInto$OpenType0) {
                MelonWebViewFullScreenBlankFragment melonWebViewFullScreenBlankFragment0 = MelonWebViewFullScreenBlankFragment.newInstance(UrlOpenInto.a(this));
                q.f(melonWebViewFullScreenBlankFragment0, "newInstance(...)");
                UrlOpenInto.b(melonWebViewFullScreenBlankFragment0);
                return;
            }
            if(OpenType.FullScreenWithMiniPlayer == navigator$UrlOpenInto$OpenType0) {
                MelonWebViewFullScreenWithMiniPlayerFragment melonWebViewFullScreenWithMiniPlayerFragment0 = MelonWebViewFullScreenWithMiniPlayerFragment.newInstance(UrlOpenInto.a(this));
                q.f(melonWebViewFullScreenWithMiniPlayerFragment0, "newInstance(...)");
                UrlOpenInto.b(melonWebViewFullScreenWithMiniPlayerFragment0);
                return;
            }
            if(OpenType.FullScreenWithBackButton == navigator$UrlOpenInto$OpenType0) {
                ParamItem melonWebViewFullScreenFragment$ParamItem0 = UrlOpenInto.a(this);
                UrlOpenInto.b(MelonWebViewFullScreenWithBackButtonFragment.Companion.newInstance(melonWebViewFullScreenFragment$ParamItem0));
                return;
            }
            String s = this.a;
            if(OpenType.FullScreenWithBar == navigator$UrlOpenInto$OpenType0) {
                MelonWebViewFullScreenWithBarFragment melonWebViewFullScreenWithBarFragment0 = MelonWebViewFullScreenWithBarFragment.newInstance(s, true);
                q.f(melonWebViewFullScreenWithBarFragment0, "newInstance(...)");
                UrlOpenInto.b(melonWebViewFullScreenWithBarFragment0);
                return;
            }
            if(OpenType.Browser == navigator$UrlOpenInto$OpenType0) {
                UrlOpenInto.Companion.openExternalActivity(s);
                return;
            }
            if(OpenType.FirstDepthExtension == navigator$UrlOpenInto$OpenType0) {
                NameValuePairList nameValuePairList0 = this.e;
                if(nameValuePairList0 != null) {
                    com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.Companion melonWebViewDefaultMiniPlayerFragment$Companion0 = MelonWebViewDefaultMiniPlayerFragment.Companion;
                    if(s == null) {
                        s = "";
                    }
                    UrlOpenInto.b(melonWebViewDefaultMiniPlayerFragment$Companion0.newInstance(s, nameValuePairList0, this.f));
                    return;
                }
                UrlOpenInto.b(MelonWebViewDefaultMiniPlayerFragment.Companion.newInstance(s));
                return;
            }
            if(OpenType.FirstDepth == navigator$UrlOpenInto$OpenType0) {
                if(this.e != null) {
                    q.d(s);
                    UrlOpenInto.b(MelonWebViewFirstDepthFragment.Companion.newInstance(s, this.e, this.f));
                    return;
                }
                UrlOpenInto.b(MelonWebViewFirstDepthFragment.Companion.newInstance(s));
                return;
            }
            if(OpenType.DefaultWebView == navigator$UrlOpenInto$OpenType0) {
                if(this.e != null) {
                    q.d(s);
                    UrlOpenInto.b(MelonWebViewDefaultFragment.Companion.newInstance(s, this.e, this.f));
                    return;
                }
                UrlOpenInto.b(MelonWebViewDefaultFragment.Companion.newInstance(s));
                return;
            }
            if(this.e != null) {
                q.d(s);
                UrlOpenInto.b(MelonWebViewDefaultMiniPlayerFragment.Companion.newInstance(s, this.e, this.f));
                return;
            }
            UrlOpenInto.b(MelonWebViewDefaultMiniPlayerFragment.Companion.newInstance(s));
        }

        public final void setAdditionalHttpHeaders(@Nullable Map map0) {
            this.d = map0;
        }

        public final void setParams(@Nullable NameValuePairList nameValuePairList0) {
            this.e = nameValuePairList0;
        }

        public final void setPost(boolean z) {
            this.f = z;
        }

        public final void setTitle(@Nullable String s) {
            this.c = s;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Navigator INSTANCE;
    public static final LogU a;
    public static final CoroutineScope b;
    public static final r c;
    public static final r d;

    static {
        Navigator.INSTANCE = new Navigator();  // 初始化器: Ljava/lang/Object;-><init>()V
        Navigator.a = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "Navigator", false, null, 6, null);
        Navigator.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        Navigator.c = g.Q(new H(6));
        Navigator.d = g.Q(new H(7));
        Navigator.$stable = 8;
    }

    public static k8.a a() {
        MelonAppBase.Companion.getClass();
        return ((o)(((c)com.google.firebase.b.B(t.a().getContext(), c.class)))).d();
    }

    public static final s2 access$getPlaylistManager(Navigator navigator0) {
        navigator0.getClass();
        return (s2)Navigator.c.getValue();
    }

    public static void b(int v, boolean z, boolean z1) {
        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
        if(baseActivity0 != null) {
            baseActivity0.selectTab(v, z, z1);
            return;
        }
        LogU.Companion.w("Navigator", "openPhotoInfo() invalid activity");
    }

    public static void c(int v) {
        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
        if(baseActivity0 != null) {
            baseActivity0.selectTabAndClear(v);
            return;
        }
        LogU.Companion.w("Navigator", "openPhotoInfo() invalid activity");
    }

    public final void installGooglePlayService() {
        Navigator.openMarket("com.google.android.gms");
    }

    public static final void open(@Nullable MelonBaseFragment melonBaseFragment0) {
        MelonFragmentManager.getInstance().open(melonBaseFragment0);
    }

    public final void open(@Nullable I i0) {
        MelonFragmentManager.getInstance().open(i0);
    }

    public final void open(@Nullable MelonBaseFragment melonBaseFragment0, @Nullable FragmentAnimations melonFragmentManager$FragmentAnimations0) {
        MelonFragmentManager.getInstance().open(melonBaseFragment0, melonFragmentManager$FragmentAnimations0);
    }

    public static final void openAlbumInfo(@Nullable String s) {
        if(s != null && StringIds.a(s, StringIds.b)) {
            LogU.Companion.d("Navigator", "openAlbumInfo() albumId: " + s);
            k k0 = new k();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argAlbumId", s);
            bundle0.putBoolean("argAutoPlay", false);
            k0.setArguments(bundle0);
            Navigator.INSTANCE.open(k0);
            return;
        }
        LogU.Companion.w("Navigator", "openAlbumInfo() invalid albumId");
    }

    public final void openAlbumStation(@Nullable String s) {
        Navigator.open(AlbumDetailContentsStationFragment.Companion.newInstance(s));
    }

    public final void openArtistImageWithPhoto(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        Params artistContentsPhotoListReq$Params0 = new Params();
        artistContentsPhotoListReq$Params0.startIndex = 1;
        artistContentsPhotoListReq$Params0.pageSize = 10;
        artistContentsPhotoListReq$Params0.orderBy = "NEW";
        artistContentsPhotoListReq$Params0.artistId = s;
        RequestBuilder.newInstance(new ArtistContentsPhotoListReq(Y.a(MelonAppBase.Companion), artistContentsPhotoListReq$Params0)).tag("Navigator").listener(new Listener() {
            public final String a;
            public final String b;
            public final String c;

            {
                String s = s1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                String s1 = s2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = s;
                this.b = s1;
                this.c = s2;
            }

            public void onResponse(ArtistContentsPhotoListRes artistContentsPhotoListRes0) {
                if(artistContentsPhotoListRes0 != null && artistContentsPhotoListRes0.isSuccessful()) {
                    RESPONSE artistContentsPhotoListRes$RESPONSE0 = artistContentsPhotoListRes0.response;
                    if(artistContentsPhotoListRes$RESPONSE0 != null) {
                        ArrayList arrayList0 = new ArrayList();
                        List list0 = artistContentsPhotoListRes$RESPONSE0.photos;
                        if(list0 != null) {
                            for(Object object0: list0) {
                                arrayList0.add(new PhotoItem(((PHOTO)object0).photoId, this.a, this.b, this.c, null, 16, null));
                            }
                        }
                        PhotoItem photoDetailViewFragment$PhotoItem0 = new PhotoItem(null, this.a, this.b, this.c, null, 16, null);
                        boolean z = artistContentsPhotoListRes0.hasMore();
                        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = PhotoInfoList.Companion.buildArtistWithPhotoParams(photoDetailViewFragment$PhotoItem0, arrayList0, z, "NEW");
                        Navigator.open(com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion.newInstance$default(PhotoDetailViewFragment.Companion, photoDetailViewFragment$PhotoInfoList0, false, false, 6, null));
                        return;
                    }
                    LogU.Companion.e("Navigator", "openArtistImageWithPhoto$onResponse() res is null");
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ArtistContentsPhotoListRes)object0));
            }
        }).errorListener(new e(24)).request();
    }

    public static final void openArtistInfo(@Nullable String s) {
        if(!StringIds.a(s, StringIds.e)) {
            LogU.Companion.w("Navigator", "openArtistInfo() - invalid artistId");
            return;
        }
        q.d(s);
        Navigator.open(ArtistDetailHomeFragment.Companion.newInstance(s));
    }

    public final void openArtistInfo(@Nullable String s, @Nullable String s1, boolean z) {
        if(!StringIds.a(s, StringIds.e)) {
            LogU.Companion.w("Navigator", "openArtistInfo(autoPlay) - invalid artistId");
            return;
        }
        if("DETAIL".equals(s1)) {
            Navigator.open(ArtistDetailDetailInfoFragment.Companion.newInstance(s));
            return;
        }
        q.d(s);
        Navigator.open(ArtistDetailHomeFragment.Companion.newInstance(s, z));
    }

    public final void openArtistPlaylistDetail(@Nullable String s) {
        com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.Companion artistPlaylistDetailFragment$Companion0 = ArtistPlaylistDetailFragment.Companion;
        if(s == null) {
            s = "";
        }
        Navigator.open(artistPlaylistDetailFragment$Companion0.newInstance(s));
    }

    public final void openArtistPlaylistDetail(@Nullable String s, boolean z, boolean z1) {
        q.d(s);
        Navigator.open(ArtistPlaylistDetailFragment.Companion.newInstance(s, z));
    }

    public static final void openAuthLocationAgreeUrl(@Nullable Context context0, boolean z) {
        NameValuePairList nameValuePairList0 = new NameValuePairList();
        MelonAppBase.Companion.getClass();
        nameValuePairList0.add("cpId", t.a().getMelonCpId());
        nameValuePairList0.add("cpKey", t.a().getMelonCpKey());
        nameValuePairList0.add("memberKey", u.v(((e0)va.o.a()).j()));
        nameValuePairList0.add("v", AppUtils.getVersionName(context0));
        Navigator.openUrl((z ? M.I : M.H), OpenType.FullScreen, nameValuePairList0);
    }

    public final void openBooklet(@Nullable ArrayList arrayList0, @Nullable String s, int v) {
        BookletDetailViewFragment.newInstance(arrayList0, s, v).open();
    }

    public final void openCashFriendsOfferWall(@Nullable String s) {
        Navigator.open(CashFriendsFragment.Companion.newInstance(s));
    }

    public final void openCastEpisodeDetail(@Nullable String s) {
        q.d(s);
        Navigator.open(StationEpisodeDetailFragment.Companion.newInstance(s));
    }

    public final void openChartAge(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        Navigator.open(MelonChartPagerFragment.newInstance(3, ((int)"POP".equals(s2)), s, s1, ""));
    }

    public final void openChartArtist() {
        Navigator.open(MelonChartPagerFragment.newInstance(5));
    }

    public final void openChartGenre(@Nullable String s) {
        Navigator.open(MelonChartPagerFragment.newInstance(1, s));
    }

    public final void openChartHottrack() {
        Navigator.open(MelonChartPagerFragment.newInstance(4));
    }

    public final void openChartHottrackDetail(@Nullable String s, @Nullable String s1) {
        Navigator.open(MelonChartPagerFragment.newInstance(4, s, s1));
    }

    public static final void openChartMain() {
        Navigator.open(MelonChartPagerFragment.newInstance());
    }

    public final void openChartTheme() {
        Navigator.open(MelonChartPagerFragment.newInstance(2));
    }

    public final void openChartWithTab(int v) {
        Navigator.open(MelonChartPagerFragment.newInstance(v));
    }

    public final void openCommentRenewalVersion(@NotNull Param cmtListFragment$Param0) {
        q.g(cmtListFragment$Param0, "param");
        int v = cmtListFragment$Param0.chnlSeq;
        String s = cmtListFragment$Param0.contsRefValue;
        q.f(s, "contsRefValue");
        this.open(V2.a(s, null, v, cmtListFragment$Param0.hasParentLink, 4));
    }

    public final void openCommentRenewalVersion(@Nullable String s, @Nullable String s1) {
        Navigator.openCommentRenewalVersion$default(this, s, s1, false, 4, null);
    }

    public final void openCommentRenewalVersion(@Nullable String s, @Nullable String s1, boolean z) {
        Param cmtListFragment$Param0 = new Param();
        cmtListFragment$Param0.chnlSeq = StringUtils.getNumberFromString(s);
        cmtListFragment$Param0.contsRefValue = s1;
        cmtListFragment$Param0.showTitle = true;
        cmtListFragment$Param0.hasParentLink = z;
        this.openCommentRenewalVersion(cmtListFragment$Param0);
    }

    public static void openCommentRenewalVersion$default(Navigator navigator0, String s, String s1, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        navigator0.openCommentRenewalVersion(s, s1, z);
    }

    public static final void openCommentWrite(int v, @NotNull String s, @NotNull CommentConfig commentConfig0, @Nullable o4 o40, int v1) {
        q.g(s, "contentRefValue");
        q.g(commentConfig0, "config");
        h4 h40 = new h4();
        h40.setArguments(f.j(new m[]{new m("key_channel_seq", v), new m("key_content_ref_value", s), new m("key_cmt_config", commentConfig0), new m("key_cmt_mode", o40), new m("key_cmt_seq", v1)}));
        Navigator.INSTANCE.open(h40);
    }

    public static void openCommentWrite$default(int v, String s, CommentConfig commentConfig0, o4 o40, int v1, int v2, Object object0) {
        if((v2 & 8) != 0) {
            o40 = o4.a;
        }
        if((v2 & 16) != 0) {
            v1 = -1;
        }
        Navigator.openCommentWrite(v, s, commentConfig0, o40, v1);
    }

    public static final void openComments(@Nullable Param cmtListFragment$Param0) {
        Navigator.open(CmtListFragment.newInstance(cmtListFragment$Param0));
    }

    public final void openCreateMusicWaveChannel() {
        this.open(new F1());
    }

    public final void openDeviceRegisterUrl(@Nullable Context context0, @NotNull CallerType deviceInformDeviceCheckReq$CallerType0) {
        q.g(deviceInformDeviceCheckReq$CallerType0, "callerType");
        LogU.Companion.d("Navigator", "openDeviceRegisterUrl()");
        NameValuePairList nameValuePairList0 = new NameValuePairList();
        MelonAppBase.Companion.getClass();
        nameValuePairList0.add("cpId", t.a().getMelonCpId());
        nameValuePairList0.add("cpKey", t.a().getMelonCpKey());
        nameValuePairList0.add("memberKey", u.v(((e0)va.o.a()).j()));
        nameValuePairList0.add("openType", "A");
        nameValuePairList0.add("rType", deviceInformDeviceCheckReq$CallerType0.type());
        Navigator.openUrl(M.F, OpenType.DefaultWebView, nameValuePairList0);
    }

    public final void openDjMalrangPlayer() {
        Navigator.openDjMalrangPlayer$default(this, 0, 1, null);
    }

    public final void openDjMalrangPlayer(int v) {
        P p0 = new P();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("arg_display_type", v);
        p0.setArguments(bundle0);
        this.open(p0);
    }

    public static void openDjMalrangPlayer$default(Navigator navigator0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        navigator0.openDjMalrangPlayer(v);
    }

    public static final void openDjPlaylistDetail(@Nullable String s) {
        com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.Companion djPlaylistDetailFragment$Companion0 = DjPlaylistDetailFragment.Companion;
        if(s == null) {
            s = "";
        }
        Navigator.open(djPlaylistDetailFragment$Companion0.newInstance(s));
    }

    public static final void openDjPlaylistEdit(@Nullable String s, @Nullable String s1) {
        PlaylistMakeFragment playlistMakeFragment0 = PlaylistMakeFragment.newInstance(s, "M20002", s1);
        q.f(playlistMakeFragment0, "newInstance(...)");
        Navigator.open(playlistMakeFragment0);
    }

    public final void openDownloadManager() {
        this.open(new j());
    }

    public final void openForUMusicSetting() {
        Navigator.open(ForUMusicSettingFragment.newInstance());
    }

    public final void openForUSelfRecommend(@Nullable String s) {
        Navigator.open(ForUSelfRecommendSearchFragment.newInstance(s));
    }

    public final void openGenreArtistDetail(@Nullable String s) {
        q.d(s);
        Navigator.open(GenreArtistDetailFragment.Companion.newInstance(s));
    }

    public static final void openGenreDetail(@NotNull String s) {
        q.g(s, "gnrCode");
        if(!TextUtils.isEmpty(s)) {
            Mc.g g0 = new Mc.g();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            g0.setArguments(bundle0);
            Navigator.INSTANCE.open(g0);
        }
    }

    public final void openGenreDetailLabel(@Nullable String s) {
        q.d(s);
        Navigator.open(GenreDetailLabelFragment.Companion.newInstance(s));
    }

    public final void openGenreMore(@NotNull More_Fragment_Type genre$More_Fragment_Type0, @Nullable String s) {
        q.g(genre$More_Fragment_Type0, "moreType");
        Navigator.openGenreMore$default(this, genre$More_Fragment_Type0, s, null, null, null, 28, null);
    }

    public final void openGenreMore(@NotNull More_Fragment_Type genre$More_Fragment_Type0, @Nullable String s, @Nullable String s1) {
        q.g(genre$More_Fragment_Type0, "moreType");
        Navigator.openGenreMore$default(this, genre$More_Fragment_Type0, s, s1, null, null, 24, null);
    }

    public final void openGenreMore(@NotNull More_Fragment_Type genre$More_Fragment_Type0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
        q.g(genre$More_Fragment_Type0, "moreType");
        Navigator.openGenreMore$default(this, genre$More_Fragment_Type0, s, s1, s2, null, 16, null);
    }

    public final void openGenreMore(@NotNull More_Fragment_Type genre$More_Fragment_Type0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        q.g(genre$More_Fragment_Type0, "moreType");
        if(genre$More_Fragment_Type0 == More_Fragment_Type.GUI_MORE_INTRO) {
            GenreFragmentFactory.createMore(s, genre$More_Fragment_Type0).open();
            return;
        }
        if(genre$More_Fragment_Type0 == More_Fragment_Type.GUI_MORE_MASTERPIECE) {
            q.d(s);
            Navigator.open(GenreDetailMoreMasterPieceFragment.Companion.newInstance(s, s1));
            return;
        }
        q.d(s);
        Navigator.open(GenreDetailMoreTabFragment.Companion.newInstance(genre$More_Fragment_Type0, s, s1, s2, s3));
    }

    public static void openGenreMore$default(Navigator navigator0, More_Fragment_Type genre$More_Fragment_Type0, String s, String s1, String s2, String s3, int v, Object object0) {
        if((v & 4) != 0) {
            s1 = null;
        }
        if((v & 8) != 0) {
            s2 = null;
        }
        if((v & 16) != 0) {
            s3 = null;
        }
        navigator0.openGenreMore(genre$More_Fragment_Type0, s, s1, s2, s3);
    }

    public static final void openGiftBoxDetailById(@Nullable String s) {
        q.d(s);
        Cd.k k0 = new Cd.k();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argGiftNo", s);
        k0.setArguments(bundle0);
        Navigator.INSTANCE.open(k0);
    }

    public final void openGiftBoxDetailByKey(@Nullable String s) {
        RequestBuilder.newInstance(new GiftInsertGiftBoxKeyReq(Y.a(MelonAppBase.Companion), s)).tag("Navigator").listener(new com.iloen.melon.utils.Navigator.openGiftBoxDetailByKey.1()).errorListener(new e(25)).request();  // 初始化器: Ljava/lang/Object;-><init>()V

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/iloen/melon/utils/Navigator$openGiftBoxDetailByKey$1", "Lcom/android/volley/Response$Listener;", "Lcom/iloen/melon/net/v4x/response/GiftInsertGiftBoxKeyRes;", "response", "Lie/H;", "onResponse", "(Lcom/iloen/melon/net/v4x/response/GiftInsertGiftBoxKeyRes;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.utils.Navigator.openGiftBoxDetailByKey.1 implements Listener {
            public void onResponse(GiftInsertGiftBoxKeyRes giftInsertGiftBoxKeyRes0) {
                if(giftInsertGiftBoxKeyRes0 != null && giftInsertGiftBoxKeyRes0.isSuccessful()) {
                    Navigator.openGiftBoxDetailById(giftInsertGiftBoxKeyRes0.response.giftNo);
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((GiftInsertGiftBoxKeyRes)object0));
            }
        }

    }

    public final void openHot100Graph(@Nullable String s) {
        yc.b b0 = new yc.b();
        Bundle bundle0 = new Bundle();
        bundle0.putString("graph_type", s);
        b0.setArguments(bundle0);
        this.open(b0);
    }

    public static final void openLive(@Nullable String s, @Nullable String s1, boolean z) {
        Navigator.openLive$default(s, s1, z, null, 8, null);
    }

    public static final void openLive(@Nullable String s, @Nullable String s1, boolean z, @Nullable StatsElementsBase statsElementsBase0) {
        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
        VideoPlayAndOpen addAction$VideoPlayAndOpen0 = new VideoPlayAndOpen(z);
        if(s == null) {
            s = "";
        }
        if(s1 == null) {
            s1 = "";
        }
        Live playDataForSeverContent$Live0 = new Live(s, s1, statsElementsBase0);
        Navigator.INSTANCE.getClass();
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity0, new AddServerContent(addAction$VideoPlayAndOpen0, false, false, Navigator.a(), playDataForSeverContent$Live0, 6, null), false, 2, null);
    }

    public static void openLive$default(String s, String s1, boolean z, StatsElementsBase statsElementsBase0, int v, Object object0) {
        if((v & 8) != 0) {
            statsElementsBase0 = null;
        }
        Navigator.openLive(s, s1, z, statsElementsBase0);
    }

    public final void openLocalContentMv() {
        this.open(new Qc.f());
    }

    public static final void openLoginView(@Nullable Uri uri0) {
        q.d(uri0);
        Navigator.open(KakaoMelonLoginFragment.Companion.newInstance(uri0));
    }

    public final void openLyricHighlight(@Nullable String s, @Nullable String s1) {
        q.d(s);
        q.d(s1);
        Navigator.open(LyricHighLightFragment.Companion.newInstance(s, s1));
    }

    public final void openMainForu(boolean z, boolean z1) {
        Navigator.b(1, z, z1);
    }

    public static void openMainForu$default(Navigator navigator0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z1 = false;
        }
        navigator0.openMainForu(z, z1);
    }

    public final void openMainForuAndClearStack() {
        Navigator.c(1);
    }

    public final void openMainLibrary(boolean z, boolean z1) {
        Navigator.b(3, z, z1);
    }

    public static void openMainLibrary$default(Navigator navigator0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z1 = false;
        }
        navigator0.openMainLibrary(z, z1);
    }

    public final void openMainLibraryAndClearStack() {
        Navigator.c(3);
    }

    public final void openMainMenu(boolean z, boolean z1) {
        Navigator.b(4, z, z1);
    }

    public static void openMainMenu$default(Navigator navigator0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z1 = false;
        }
        navigator0.openMainMenu(z, z1);
    }

    public final void openMainMusic(boolean z, boolean z1) {
        Navigator.b(0, z, z1);
    }

    public static void openMainMusic$default(Navigator navigator0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z1 = false;
        }
        navigator0.openMainMusic(z, z1);
    }

    public static final void openMainMusicAndClearStack() {
        Navigator.INSTANCE.getClass();
        Navigator.c(0);
    }

    public final void openMainSearch(boolean z, boolean z1) {
        Navigator.b(2, z, z1);
    }

    public static void openMainSearch$default(Navigator navigator0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z1 = false;
        }
        navigator0.openMainSearch(z, z1);
    }

    public final void openMainSearchAndClearStack() {
        Navigator.c(2);
    }

    public static final void openMarket(@Nullable Uri uri0) {
        Intent intent0 = new Intent("android.intent.action.VIEW");
        intent0.setFlags(0x10000000);
        intent0.setData(uri0);
        try {
            MelonAppBase.Companion.getClass();
            t.a().getContext().startActivity(intent0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            LogU.Companion.w("Navigator", "openMarket() ActivityNotFoundException:" + activityNotFoundException0);
        }
    }

    public static final void openMarket(@Nullable String s) {
        Intent intent0 = new Intent("android.intent.action.VIEW");
        intent0.setFlags(0x10000000);
        intent0.setData(UrlUtil.INSTANCE.getAppMarketUri(s));
        try {
            MelonAppBase.Companion.getClass();
            t.a().getContext().startActivity(intent0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            LogU.Companion.w("Navigator", "openMarket() ActivityNotFoundException:" + activityNotFoundException0);
        }
    }

    public static final void openMelGunsCollection() {
        p p0 = new p();
        Navigator.INSTANCE.open(p0);
    }

    public final void openMelonDJMain() {
        this.open(new A2());
    }

    public static final void openMelonDJTagHubDetail(@Nullable String s) {
        q6 q60 = new q6();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argTagSeq", s);
        q60.setArguments(bundle0);
        Navigator.INSTANCE.open(q60);
    }

    public static final void openMelonDJTagSearch() {
        Navigator navigator0 = Navigator.INSTANCE;
        J6 j60 = new J6();
        Bundle bundle0 = new Bundle();
        if(!Tf.o.H0("")) {
            bundle0.putStringArrayList("argSelectedList", h.W(Tf.o.R0("", new String[]{","}, 0, 6)));
        }
        j60.setArguments(bundle0);
        navigator0.open(j60);
    }

    public final void openMelonDJTagSearch(@Nullable String s) {
        J6 j60 = new J6();
        Bundle bundle0 = new Bundle();
        if(s != null && !Tf.o.H0(s)) {
            bundle0.putStringArrayList("argSelectedList", h.W(Tf.o.R0(s, new String[]{","}, 0, 6)));
        }
        j60.setArguments(bundle0);
        this.open(j60);
    }

    public final void openMelonDJThemeGenre() {
        this.open(new Q7());
    }

    public final void openMelonDjBrandPlaylist(@Nullable String s, @Nullable String s1) {
        q.d(s);
        q.d(s1);
        I0 i00 = new I0();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argBrandDjKey", s);
        bundle0.putString("argTopMemberNm", s1);
        i00.setArguments(bundle0);
        this.open(i00);
    }

    public final void openMelonDjBrandRecmSong(@Nullable String s, @Nullable String s1) {
        q.d(s);
        u1 u10 = new u1();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argBrandDjKey", s);
        bundle0.putString("argBrandDjNickname", s1);
        u10.setArguments(bundle0);
        this.open(u10);
    }

    public final void openMelonDjPartnerInfo(@Nullable String s) {
        q.d(s);
        n1 n10 = new n1();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argMemberKey", s);
        n10.setArguments(bundle0);
        this.open(n10);
    }

    public final void openMelonDjPopular() {
        this.open(d.B("D"));
    }

    public final void openMelonDjPopular(@Nullable String s) {
        this.open(d.B(s));
    }

    public final void openMelonLoginView(@Nullable Uri uri0) {
        if(((o)(((Ma.g)Y.f(MelonAppBase.Companion, Ma.g.class)))).m().d()) {
            Navigator.open(LoginSimpleAccountFragment.Companion.newInstance(uri0));
            return;
        }
        Gd.g g0 = new Gd.g();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("returnUri", uri0);
        bundle0.putInt("argLoginFragmentCount", 0);
        g0.setArguments(bundle0);
        this.open(g0);
    }

    public final void openMelonLoginView(@Nullable Uri uri0, int v) {
        if(((o)(((Ma.g)Y.f(MelonAppBase.Companion, Ma.g.class)))).m().d()) {
            Navigator.open(LoginSimpleAccountFragment.Companion.newInstance(uri0, v));
            return;
        }
        Gd.g g0 = new Gd.g();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("returnUri", uri0);
        bundle0.putInt("argLoginFragmentCount", v);
        g0.setArguments(bundle0);
        this.open(g0);
    }

    public final void openMelonPowerDj() {
        this.open(new F4());
    }

    public final void openMelonPowerDj(@Nullable String s, @Nullable String s1) {
        int v1;
        F4 f40 = new F4();
        Bundle bundle0 = new Bundle();
        int v = 0;
        if(q.b(s, "OFFICIAL")) {
            v1 = 1;
        }
        else {
            v1 = q.b(s, "PARTNER") ? 2 : 0;
        }
        bundle0.putInt("argModeIndex", v1);
        if(s1 != null) {
            switch(s1) {
                case "asc": {
                    v = 2;
                    break;
                }
                case "popular": {
                    v = 1;
                }
            }
        }
        bundle0.putInt("argOrderByIndex", v);
        f40.setArguments(bundle0);
        this.open(f40);
    }

    public final void openMelonSupportMain() {
        Navigator.openUrl(M.X, OpenType.DefaultWebViewWithMiniPlayer);
    }

    public static final void openMelonSupportPlayback() {
        Navigator.openUrl(M.Y, OpenType.DefaultWebViewWithMiniPlayer);
    }

    public final void openMelonSupportWebViewError() {
        Navigator.openUrl(M.Z, OpenType.DefaultWebViewWithMiniPlayer);
    }

    public static final void openMelonTvMain() {
        Navigator.open(MelonTvTabFragment.newInstance());
    }

    public final void openMelonTvMain(int v) {
        Navigator.open(MelonTvTabFragment.newInstance(v));
    }

    public final void openMelonTvMain(int v, int v1) {
        Navigator.open(MelonTvTabFragment.newInstance(v, v1));
    }

    public final void openMelonTvProgram(@NotNull String s) {
        q.g(s, "progSeq");
        if(!StringIds.a(s, StringIds.b)) {
            LogU.Companion.w("Navigator", "openMelonTvProgram() invalid progSeq");
            return;
        }
        LogU.Companion.d("Navigator", "openMelonTvProgram() progSeq / episodeSeq : " + s);
        Navigator.open(TvProgramHomeFragment.Companion.newInstance(s));
    }

    public final void openMixMakerPlaylistDetail(@Nullable String s, int v) {
        q.d(s);
        Navigator.open(MixMakerPlaylistDetailFragment.Companion.newInstance(s, v));
    }

    public final void openMixPlaylist(@Nullable MelonBaseFragment melonBaseFragment0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(melonBaseFragment0 != null) {
            melonBaseFragment0.showProgress(true);
        }
        com.iloen.melon.net.v6x.request.ForUMixInformReq.Params forUMixInformReq$Params0 = new com.iloen.melon.net.v6x.request.ForUMixInformReq.Params();
        forUMixInformReq$Params0.contsId = s;
        forUMixInformReq$Params0.seedContsId = s1;
        forUMixInformReq$Params0.seedContsTypeCode = s2;
        RequestBuilder.newInstance(new ForUMixInformReq(Y.a(MelonAppBase.Companion), forUMixInformReq$Params0)).tag("Navigator").listener(new Listener() {
            public final MelonBaseFragment a;
            public final String b;

            {
                MelonBaseFragment melonBaseFragment0 = s1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = melonBaseFragment0;
                this.b = s;
            }

            // 去混淆评级： 低(26)
            public void onResponse(ForUMixInformRes forUMixInformRes0) {
                MelonBaseFragment melonBaseFragment0 = this.a;
                if(melonBaseFragment0 != null) {
                    melonBaseFragment0.showProgress(false);
                }
                if(forUMixInformRes0 != null && forUMixInformRes0.isSuccessful(true)) {
                    com.iloen.melon.net.v6x.response.ForUMixInformRes.RESPONSE forUMixInformRes$RESPONSE0 = forUMixInformRes0.response;
                    ForUUtils.getFirstUrlInList(forUMixInformRes$RESPONSE0.getDetailImgUrls());
                    ForUDetailParam mixPlaylistDetailFragment$ForUDetailParam0 = new ForUDetailParam().title("").desc("").detailText("").detailReplace("").updateDate("");
                    MelonAppBase.Companion.getClass();
                    ForUDetailParam mixPlaylistDetailFragment$ForUDetailParam1 = mixPlaylistDetailFragment$ForUDetailParam0.templateCoverCacheKey(ForUUtils.saveTemplateCoverToCache(t.a().getContext(), forUMixInformRes$RESPONSE0)).coverImgUrl(ForUUtils.getFirstUrlInList(forUMixInformRes$RESPONSE0.getDetailImgUrls())).contsId("").contsTypeCode("").songIds("").tagList(forUMixInformRes$RESPONSE0.getTags());
                    q.d(this.b);
                    Navigator.INSTANCE.openMixPlaylist(mixPlaylistDetailFragment$ForUDetailParam1.seedContsId(this.b).statsElements(forUMixInformRes$RESPONSE0.getStatsElements()));
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ForUMixInformRes)object0));
            }
        }).errorListener(new com.iloen.melon.fragments.radio.a(melonBaseFragment0, 2)).request();
    }

    public final void openMixPlaylist(@Nullable ForUDetailParam mixPlaylistDetailFragment$ForUDetailParam0) {
        q.d(mixPlaylistDetailFragment$ForUDetailParam0);
        MixPlaylistDetailFragment.Companion.newInstance(mixPlaylistDetailFragment$ForUDetailParam0).open();
    }

    public final void openMixPlaylist(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        this.openMixPlaylist(null, s, s1, s2);
    }

    public final void openMusicAlarmList() {
        Navigator.open(SettingMusicAlarmListFragment.Companion.newInstance());
    }

    public final void openMusicDna() {
        if(((e0)va.o.a()).m()) {
            this.open(new Y1());
            return;
        }
        Navigator.openLoginView(r8.f.i);
    }

    public final void openMusicDnaMonthlyLog(@Nullable String s, boolean z) {
        if(StringUtils.getNumberFromString(s) >= 202306) {
            q.d(s);
            s1 s10 = new s1();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMonth", s);
            bundle0.putBoolean("argIncludeShortcuts", z);
            s10.setArguments(bundle0);
            this.open(s10);
            return;
        }
        q.d(s);
        Navigator.open(MonthlyDnaLogFragment.Companion.newInstance(s, z));
    }

    public final void openMusicPlayer() {
        Navigator.openMusicPlayer$default(this, 0, 1, null);
    }

    public final void openMusicPlayer(int v) {
        b0 b00 = new b0();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("arg_display_type", v);
        b00.setArguments(bundle0);
        this.open(b00);
    }

    public static void openMusicPlayer$default(Navigator navigator0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        navigator0.openMusicPlayer(v);
    }

    public final void openMusicWaveHome() {
        Navigator.openUrl(M.h0, OpenType.DefaultWebViewWithMiniPlayer);
    }

    public final void openMusicWavePlayer() {
        com.iloen.melon.utils.Navigator.openMusicWavePlayer.1 navigator$openMusicWavePlayer$10 = new n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            public int r;

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.Navigator.openMusicWavePlayer.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.Navigator.openMusicWavePlayer.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        B b0 = ((d3)Navigator.access$getPlaylistManager(Navigator.INSTANCE)).o();
                        this.r = 1;
                        object0 = ListenableFutureKt.await(b0, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                MusicWaveChannelInfo musicWaveChannelInfo0 = ((rc.m)(((rc.a)object0))).c().c;
                if(musicWaveChannelInfo0 != null) {
                    String s = musicWaveChannelInfo0.getType();
                    String s1 = musicWaveChannelInfo0.getId();
                    q.g(s, "type");
                    q.g(s1, "id");
                    w.d = true;
                    X0 x00 = new X0();
                    Bundle bundle0 = Y.c("musicWaveType", s, "musicWaveId", s1);
                    bundle0.putString("argOriginMenuId", (musicWaveChannelInfo0.getOriginMenuId() == null ? "" : musicWaveChannelInfo0.getOriginMenuId()));
                    x00.setArguments(bundle0);
                    Navigator.INSTANCE.open(x00);
                    return ie.H.a;
                }
                LogU.error$default(Navigator.a, "openMusicWavePlayer() ignored because channelInfo is null", null, false, 6, null);
                return ie.H.a;
            }
        };
        BuildersKt__Builders_commonKt.launch$default(Navigator.b, null, null, navigator$openMusicWavePlayer$10, 3, null);
    }

    public final void openMusicWaveSearch() {
        Navigator.openUrl(M.i0, OpenType.DefaultWebViewWithMiniPlayer);
    }

    public static final void openMvInfo(@Nullable String s, @Nullable String s1) {
        Navigator.openMvInfo$default(s, s1, null, false, 12, null);
    }

    public static final void openMvInfo(@Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0) {
        Navigator.openMvInfo$default(s, s1, statsElementsBase0, false, 8, null);
    }

    public static final void openMvInfo(@Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0, boolean z) {
        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
        VideoPlayAndOpen addAction$VideoPlayAndOpen0 = new VideoPlayAndOpen(z);
        MV playDataForSeverContent$MV0 = new MV((s == null ? "" : s), null, (s1 == null ? "" : s1), statsElementsBase0, 2, null);
        Navigator.INSTANCE.getClass();
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity0, new AddServerContent(addAction$VideoPlayAndOpen0, false, false, Navigator.a(), playDataForSeverContent$MV0, 6, null), false, 2, null);
    }

    public static void openMvInfo$default(String s, String s1, StatsElementsBase statsElementsBase0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            statsElementsBase0 = null;
        }
        if((v & 8) != 0) {
            z = false;
        }
        Navigator.openMvInfo(s, s1, statsElementsBase0, z);
    }

    public final void openMyMusicMyChartSpecificMonth(@Nullable String s) {
        q.d(s);
        Navigator.open(MyMusicTabFragment.Companion.newInstance("mychart", s, 3));
    }

    public final void openNewAlbum(@Nullable String s) {
        int v = 0;
        if(!"ALL".equals(s)) {
            if("DOMESTIC".equals(s)) {
                v = 1;
            }
            else if("OVERSEAS".equals(s)) {
                v = 2;
            }
        }
        this.open(F.v(v, 2));
    }

    public static final void openNewMusicMain() {
        ld.b b0 = F.v(0, 7);
        Navigator.INSTANCE.open(b0);
    }

    public final void openNoticePage(@Nullable String s) {
        NameValuePairList nameValuePairList0;
        LogU.Companion.d("Navigator", "openNoticePage() seqNum:" + s);
        if(TextUtils.isEmpty(s)) {
            nameValuePairList0 = null;
        }
        else {
            nameValuePairList0 = new NameValuePairList();
            nameValuePairList0.add("ancmSeq", s);
        }
        Navigator.openUrl(M.x, OpenType.DefaultWebViewWithMiniPlayer, nameValuePairList0);
    }

    public final void openNowPlayList() {
        com.iloen.melon.utils.Navigator.openNowPlayList.1 navigator$openNowPlayList$10 = new n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            public int r;

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.Navigator.openNowPlayList.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.Navigator.openNowPlayList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        B b0 = ((d3)Navigator.access$getPlaylistManager(Navigator.INSTANCE)).h();
                        this.r = 1;
                        if(ListenableFutureKt.await(b0, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                Navigator.INSTANCE.openNowPlayList(PlaylistId.EMPTY);
                return ie.H.a;
            }
        };
        BuildersKt__Builders_commonKt.launch$default(Navigator.b, null, null, navigator$openNowPlayList$10, 3, null);
    }

    public final void openNowPlayList(@Nullable Bundle bundle0) {
        this.openNowPlayList();
    }

    // 去混淆评级： 低(20)
    public final void openNowPlayList(@NotNull PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
        this.open(new PlaylistMainFragment());
    }

    public final void openNowPlayer() {
        Navigator.openNowPlayer$default(this, 0, 1, null);
    }

    public final void openNowPlayer(int v) {
        com.iloen.melon.utils.Navigator.openNowPlayer.1 navigator$openNowPlayer$10 = new n(null) {
            public int r;
            public final int w;

            {
                this.w = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.Navigator.openNowPlayer.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.Navigator.openNowPlayer.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        B b0 = ((d3)Navigator.access$getPlaylistManager(Navigator.INSTANCE)).g();
                        this.r = 1;
                        object0 = ListenableFutureKt.await(b0, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                ((oc.H)object0).getId();
                boolean z = e.k.y(((oc.H)object0));
                ie.H h0 = ie.H.a;
                if(z) {
                    Navigator.INSTANCE.openNowPlayList();
                    return h0;
                }
                int v = this.w;
                if(((oc.H)object0) instanceof pc.d) {
                    if(d5.t.k(((pc.d)(((oc.H)object0))))) {
                        Navigator.INSTANCE.openDjMalrangPlayer(v);
                        return h0;
                    }
                    Navigator.INSTANCE.openMusicPlayer(v);
                    return h0;
                }
                Navigator.INSTANCE.openMusicPlayer(v);
                return h0;
            }
        };
        BuildersKt__Builders_commonKt.launch$default(Navigator.b, null, null, navigator$openNowPlayer$10, 3, null);
    }

    public static void openNowPlayer$default(Navigator navigator0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        navigator0.openNowPlayer(v);
    }

    public final void openNowPlayingDetail(@Nullable String s) {
        Navigator.open(NowPlayingDetailTabFragment.newInstance(s));
    }

    public static final void openNowPlayingEdit(@Nullable String s) {
        Navigator.open(NowPlayingEditFragment.newInstance(s));
    }

    public final void openPeriodChart(@Nullable String s) {
        Navigator.openPeriodChart$default(this, s, 0, 2, null);
    }

    public final void openPeriodChart(@Nullable String s, int v) {
        Navigator.open(MelonChartPagerFragment.newInstance(0, s, v));
    }

    public static void openPeriodChart$default(Navigator navigator0, String s, int v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = -1;
        }
        navigator0.openPeriodChart(s, v);
    }

    public static final void openPhotoDetailView(@Nullable String s) {
        q.d(s);
        Navigator.open(com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion.newInstance$default(PhotoDetailViewFragment.Companion, s, false, 2, null));
    }

    public final void openPhotoInfo(@Nullable String s) {
        q.d(s);
        com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion.newInstance$default(PhotoDetailViewFragment.Companion, s, false, 2, null).open();
    }

    public final void openPhotoInfo(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        this.openPhotoInfoList(s, s1, s3, s2, false);
    }

    public final void openPhotoInfoList(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, boolean z) {
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = PhotoInfoList.Companion.buildEtcParams(s, s1, s2, s3);
        PhotoDetailViewFragment.Companion.newInstance(photoDetailViewFragment$PhotoInfoList0, false, z).open();
    }

    public final void openPhotoInfoReply(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        Navigator.open(PhotoDetailViewCommentFragment.Companion.newInstance(s, true, s1, s2));
    }

    public final void openPhotoInfoReview(@Nullable String s) {
        com.iloen.melon.fragments.detail.PhotoDetailViewCommentFragment.Companion.newInstance$default(PhotoDetailViewCommentFragment.Companion, s, false, null, null, 14, null).open();
    }

    public static final void openPhotoUrl(@Nullable String s) {
        Navigator.INSTANCE.openPhotoUrl(false, s, null);
    }

    public final void openPhotoUrl(boolean z, @Nullable String s, @Nullable String s1) {
        this.openPhotoUrl(z, s, s1, null);
    }

    public final void openPhotoUrl(boolean z, @Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(z) {
            BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
            if(baseActivity0 == null) {
                LogU.Companion.w("Navigator", "openPhotoInfo() invalid activity");
                return;
            }
            Intent intent0 = new Intent(baseActivity0, PhotoDetailActivity.class);
            intent0.putExtra("argPhotoUrl", s);
            if(!TextUtils.isEmpty(s1)) {
                intent0.putExtra("argDescription", s1);
            }
            if(!TextUtils.isEmpty(s2)) {
                intent0.putExtra("argPvLogDummyAction", s2);
            }
            try {
                baseActivity0.startActivity(intent0);
            }
            catch(ActivityNotFoundException activityNotFoundException0) {
                LogU.Companion.w("Navigator", "openPhotoInfo() " + activityNotFoundException0);
            }
            return;
        }
        com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion.newInstance$default(PhotoDetailViewFragment.Companion, s, s1, "", s2, false, false, 0x30, null).open();
    }

    public final void openPhotoUrlWithTitle(@Nullable String s, @Nullable String s1) {
        PhotoDetailViewFragment.Companion.newInstance(s, "", s1, null, false, false).open();
    }

    public final void openPlaylistAllSong(@NotNull String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
        PlaylistDetailContentsAllSongFragment playlistDetailContentsAllSongFragment0;
        q.g(s, "plylstType");
        if("M20001".equals(s)) {
            playlistDetailContentsAllSongFragment0 = PlaylistDetailContentsAllSongFragment.Companion.newInstance(s1, s2, s3, s4);
        }
        else if("M20002".equals(s)) {
            playlistDetailContentsAllSongFragment0 = DjPlaylistDetailContentsAllSongFragment.Companion.newInstance(s1, s2, s3, s4);
        }
        else if("M20004".equals(s)) {
            playlistDetailContentsAllSongFragment0 = ArtistPlaylistDetailContentsAllSongFragment.Companion.newInstance(s1, s2, s3, s4);
        }
        else {
            playlistDetailContentsAllSongFragment0 = null;
        }
        if(playlistDetailContentsAllSongFragment0 != null) {
            Navigator.open(playlistDetailContentsAllSongFragment0);
        }
    }

    public final void openPlaylistDetail(@Nullable String s) {
        if(s == null) {
            s = "";
        }
        Kc.f f0 = new Kc.f();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argAlbumId", s);
        f0.setArguments(bundle0);
        this.open(f0);
    }

    public final void openPlaylistEdit(@Nullable String s, @Nullable String s1) {
        PlaylistMakeFragment playlistMakeFragment0 = PlaylistMakeFragment.newInstance(s, s1);
        q.f(playlistMakeFragment0, "newInstance(...)");
        Navigator.open(playlistMakeFragment0);
    }

    public final void openPresentSendDetail(@Nullable String s) {
        q.d(s);
        G g0 = new G();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argGiftNo", s);
        g0.setArguments(bundle0);
        this.open(g0);
    }

    public static final void openPresentSongSendFragment() {
        Navigator.openPresentSongSendFragment$default(null, null, null, 7, null);
    }

    public static final void openPresentSongSendFragment(@Nullable String s) {
        Navigator.openPresentSongSendFragment$default(s, null, null, 6, null);
    }

    public static final void openPresentSongSendFragment(@Nullable String s, @Nullable ArrayList arrayList0) {
        Navigator.openPresentSongSendFragment$default(s, arrayList0, null, 4, null);
    }

    public static final void openPresentSongSendFragment(@Nullable String s, @Nullable ArrayList arrayList0, @Nullable ArrayList arrayList1) {
        ArrayList arrayList2 = PresentSongSendFragmentKt.toPresentDataList(arrayList1);
        Navigator.open(PresentSongSendFragment.Companion.newInstance(s, arrayList0, arrayList2));
    }

    public static final void openPresentSongSendFragment(@Nullable ArrayList arrayList0) {
        Navigator.openPresentSongSendFragment(null, arrayList0, null);
    }

    public static void openPresentSongSendFragment$default(String s, ArrayList arrayList0, ArrayList arrayList1, int v, Object object0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            arrayList0 = null;
        }
        if((v & 4) != 0) {
            arrayList1 = null;
        }
        Navigator.openPresentSongSendFragment(s, arrayList0, arrayList1);
    }

    public static final void openSearchKeyword(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        D d0 = z6.f.q(8, s, s1, s2);
        Navigator.INSTANCE.open(d0);
    }

    public static void openSearchKeyword$default(String s, String s1, String s2, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        Navigator.openSearchKeyword(s, s1, s2);
    }

    public final void openSeriesFolderDetail(@Nullable String s) {
        Navigator.open(SeriesFolderDetailFragment.newInstance(s));
    }

    public static final void openSimilarSongList(@Nullable String s, @Nullable String s1) {
        Navigator.INSTANCE.openMixPlaylist(null, "35", s, s1);
    }

    public static final void openSongInfo(@NotNull String s) {
        q.g(s, "songId");
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.d("Navigator", "openSongInfo() invalid songId");
            return;
        }
        LogU.Companion.d("Navigator", "openSongInfo() songId:" + s);
        Navigator.open(SongDetailFragment.Companion.newInstance(s));
    }

    public final void openSongStation(@Nullable String s) {
        Navigator.open(SongDetailContentsStationFragment.Companion.newInstance(s));
    }

    public static final void openSoundSearch() {
        id.k k0 = new id.k();
        Navigator.INSTANCE.open(k0);
    }

    public final void openStation() {
        J j0 = new J();
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("argHasPersonalizedContent", true);
        j0.setArguments(bundle0);
        this.open(j0);
    }

    public final void openStationListen(@Nullable String s, @Nullable String s1) {
        if(((Ub.t)(((s)Navigator.d.getValue()))).g()) {
            ToastManager.show(0x7F1301B4);  // string:cast_not_support_external_device "연결중인 외부기기에서 재생이 불가능 합니다."
            return;
        }
        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
        AddPlay addAction$AddPlay0 = new AddPlay(false);
        if(s == null) {
            s = "";
        }
        if(s1 == null) {
            s1 = "";
        }
        Station playDataForSeverContent$Station0 = new Station(s, "", s1, null);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity0, new AddServerContent(addAction$AddPlay0, false, false, Navigator.a(), playDataForSeverContent$Station0, 6, null), false, 2, null);
    }

    public final void openStationListen(@Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0) {
        if(((Ub.t)(((s)Navigator.d.getValue()))).g()) {
            ToastManager.show(0x7F1301B4);  // string:cast_not_support_external_device "연결중인 외부기기에서 재생이 불가능 합니다."
            return;
        }
        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
        AddPlay addAction$AddPlay0 = new AddPlay(false);
        if(s == null) {
            s = "";
        }
        if(s1 == null) {
            s1 = "";
        }
        Station playDataForSeverContent$Station0 = new Station(s, "", s1, statsElementsBase0);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity0, new AddServerContent(addAction$AddPlay0, false, false, Navigator.a(), playDataForSeverContent$Station0, 6, null), false, 2, null);
    }

    public final void openStationPlayer() {
        this.open(new C());
    }

    public final void openStationPlayer(@Nullable Bundle bundle0) {
        q.d(bundle0);
        C c0 = new C();
        c0.setArguments(bundle0);
        this.open(c0);
    }

    public final void openStationPopularDetail() {
        this.open(new Xc.g());
    }

    public final void openStationProgram(@Nullable String s) {
        q.d(s);
        T t0 = new T();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argItemId", s);
        t0.setArguments(bundle0);
        this.open(t0);
    }

    public final void openStreamingCard(@Nullable String s) {
        if(!TextUtils.isEmpty(s)) {
            q.d(s);
            Navigator.open(StreamingCardFragment.Companion.newInstance(s));
        }
    }

    public final void openTopic(@Nullable String s, @Nullable String s1) {
        q.d(s);
        q.d(s1);
        Navigator.open(TopicFragment.Companion.newInstance(s, s1));
    }

    public static final void openUrl(@Nullable String s, @NotNull OpenType navigator$UrlOpenInto$OpenType0) {
        q.g(navigator$UrlOpenInto$OpenType0, "openType");
        Navigator.openUrl(null, s, navigator$UrlOpenInto$OpenType0, null, false);
    }

    public static final void openUrl(@Nullable String s, @NotNull OpenType navigator$UrlOpenInto$OpenType0, @Nullable NameValuePairList nameValuePairList0) {
        q.g(navigator$UrlOpenInto$OpenType0, "openType");
        Navigator.openUrl(null, s, navigator$UrlOpenInto$OpenType0, nameValuePairList0, nameValuePairList0 != null && nameValuePairList0.size() > 0);
    }

    public static final void openUrl(@Nullable String s, @Nullable String s1, @NotNull OpenType navigator$UrlOpenInto$OpenType0, @Nullable NameValuePairList nameValuePairList0) {
        q.g(navigator$UrlOpenInto$OpenType0, "openType");
        Navigator.openUrl(s, s1, navigator$UrlOpenInto$OpenType0, nameValuePairList0, nameValuePairList0 != null && nameValuePairList0.size() > 0);
    }

    public static final void openUrl(@Nullable String s, @Nullable String s1, @NotNull OpenType navigator$UrlOpenInto$OpenType0, @Nullable NameValuePairList nameValuePairList0, boolean z) {
        q.g(navigator$UrlOpenInto$OpenType0, "openType");
        UrlOpenInto.Companion.newBuilder(s1).title(s).openType(navigator$UrlOpenInto$OpenType0).params(nameValuePairList0).post(z).build().open();
    }

    public static final void openUrl(@Nullable String s, @Nullable String s1, @NotNull OpenType navigator$UrlOpenInto$OpenType0, boolean z) {
        q.g(navigator$UrlOpenInto$OpenType0, "openType");
        Navigator.openUrl$default(s, s1, navigator$UrlOpenInto$OpenType0, null, z, 8, null);
    }

    public final void openUrl(@Nullable String s, @NotNull OpenType navigator$UrlOpenInto$OpenType0, @Nullable Map map0, @Nullable NameValuePairList nameValuePairList0) {
        q.g(navigator$UrlOpenInto$OpenType0, "openType");
        UrlOpenInto.Companion.newBuilder(s).openType(navigator$UrlOpenInto$OpenType0).additionalHttpHeaders(map0).params(nameValuePairList0).build().open();
    }

    public static void openUrl$default(String s, String s1, OpenType navigator$UrlOpenInto$OpenType0, NameValuePairList nameValuePairList0, boolean z, int v, Object object0) {
        if((v & 8) != 0) {
            nameValuePairList0 = null;
        }
        Navigator.openUrl(s, s1, navigator$UrlOpenInto$OpenType0, nameValuePairList0, z);
    }

    public static final void openUrlFullScreenView(@Nullable String s) {
        Navigator.openUrl(null, s, OpenType.FullScreen, null, false);
    }

    public static final void openUrlFullScreenView(@Nullable String s, @Nullable String s1) {
        Navigator.openUrl(s, s1, OpenType.FullScreen, null, false);
    }

    public static final void openUrlFullScreenWithMiniPlayerView(@Nullable String s, @Nullable String s1) {
        Navigator.openUrl(s, s1, OpenType.DefaultWebViewWithMiniPlayer, null, false);
    }

    public static final void openUserMain(@Nullable String s) {
        Navigator.openUserMain(s, TextUtils.isEmpty(s));
    }

    public static final void openUserMain(@Nullable String s, boolean z) {
        boolean z1 = false;
        if(z) {
            l0 l00 = MelonFragmentManager.getInstance().getCurrentActivity().getSupportFragmentManager();
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, "", "", false, false, false, null, null, null, null, null, 2040);
            return;
        }
        if(StringIds.a(s, StringIds.i)) {
            Navigator.openMelGunsCollection();
            return;
        }
        if(StringIds.a(s, StringIds.f)) {
            Navigator.INSTANCE.openMelonDjPartnerInfo(s);
            return;
        }
        if(StringIds.a(s, StringIds.g)) {
            Navigator navigator0 = Navigator.INSTANCE;
            q.d(s);
            g0 g00 = new g0();
            Bundle bundle0 = Y.b("argMemberKey", s);
            if(u.o(s) && s.equals(u.v(((e0)va.o.a()).j()))) {
                z1 = true;
            }
            bundle0.putBoolean("argIsMySelf", z1);
            g00.setArguments(bundle0);
            navigator0.open(g00);
            return;
        }
        if(StringIds.a(s, StringIds.h)) {
            LogU.Companion.w("Navigator", "openUserMain() my own key");
            return;
        }
        LogU.Companion.w("Navigator", "openUserMain() invalid memberKey");
    }

    public static final void openUserMainIncludeSelf(@Nullable String s, boolean z) {
        boolean z1 = false;
        if(z) {
            l0 l00 = MelonFragmentManager.getInstance().getCurrentActivity().getSupportFragmentManager();
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, "", "", false, false, false, null, null, null, null, null, 2040);
            return;
        }
        if(StringIds.a(s, StringIds.i)) {
            Navigator.openMelGunsCollection();
            return;
        }
        if(StringIds.a(s, StringIds.f)) {
            Navigator.INSTANCE.openMelonDjPartnerInfo(s);
            return;
        }
        if(!StringIds.a(s, StringIds.g) && !StringIds.a(s, StringIds.h)) {
            LogU.Companion.w("Navigator", "openUserMain() invalid memberKey");
            return;
        }
        Navigator navigator0 = Navigator.INSTANCE;
        q.d(s);
        g0 g00 = new g0();
        Bundle bundle0 = Y.b("argMemberKey", s);
        if(u.o(s) && s.equals(u.v(((e0)va.o.a()).j()))) {
            z1 = true;
        }
        bundle0.putBoolean("argIsMySelf", z1);
        g00.setArguments(bundle0);
        navigator0.open(g00);
    }

    public final void openVideoPlayer(boolean z) {
        Intent intent0 = new Intent();
        Q1.c.Z(intent0, "com.iloen.melon.MUSICVIDEO_VIEWER", 2);
        intent0.setFlags(0x10000000);
        intent0.putExtra("argIsFullScreen", z);
        try {
            MelonAppBase.Companion.getClass();
            t.a().getContext().sendBroadcast(intent0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            LogU.Companion.w("Navigator", "openVideoPlayer() " + activityNotFoundException0);
        }
    }

    public static void openVideoPlayer$default(Navigator navigator0, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        navigator0.openVideoPlayer(z);
    }

    public final void openVoiceAlarm() {
        this.open(new i());
    }

    public static final void showKakaoProfileAgreePage(@NotNull String s, @NotNull String s1) {
        q.g(s, "agreeUrl");
        q.g(s1, "headerToken");
        LogU.Companion.d("Navigator", "showKakaoProfileAgreePage() >> agreeUrl: " + s + ", headerToken: " + s1);
        if(TextUtils.isEmpty(s) && TextUtils.isEmpty(s1)) {
            return;
        }
        HashMap hashMap0 = new HashMap();
        hashMap0.put("MT", s1);
        Navigator.INSTANCE.openUrl(s, OpenType.FullScreen, hashMap0, null);
    }
}

