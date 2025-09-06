package com.iloen.melon.fragments.artistchannel;

import De.I;
import J8.k;
import J8.m0;
import Tf.o;
import U4.x;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.constants.CType;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.ArtistCardRelayRollingView;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnData;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.OnViewHolderActionListener;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistAlbumHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistArtistNoteHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistBannerHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistDailyReportHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistFanCmtShareHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistFanLoungeHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistForestHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistGroupHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistHighlightHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistInfoHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistMagazineHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistMelonHallHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistMixUpHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistPhotoGridHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistPhotoLinearHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistRecommendTrackHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistSongListHeaderHolder.HeaderData;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistSongListHeaderHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistSpotlightHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistStationHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistTopicHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistVideoHolder;
import com.iloen.melon.fragments.comments.CmtHelper;
import com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder;
import com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder;
import com.iloen.melon.fragments.detail.viewholder.MagazineHolder;
import com.iloen.melon.fragments.detail.viewholder.MelonTabTitleHolder;
import com.iloen.melon.fragments.detail.viewholder.StationHolder;
import com.iloen.melon.fragments.detail.viewholder.VideoHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummReq.Params;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummReq;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList.Fields;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v5x.response.DetailBaseRes.SONG;
import com.iloen.melon.net.v6x.request.ArtistContentsListLikeAndCmtReq;
import com.iloen.melon.net.v6x.request.ArtistHomeBasicInfoReq;
import com.iloen.melon.net.v6x.request.ArtistHomeContentsReq;
import com.iloen.melon.net.v6x.request.ArtistTemperatureScoreNoticeReq;
import com.iloen.melon.net.v6x.request.ArtistTemperatureSummaryReq;
import com.iloen.melon.net.v6x.request.PromotionContentsBannerReq.Param;
import com.iloen.melon.net.v6x.request.PromotionContentsBannerReq;
import com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes.RESPONSE.USERACTIONLIST;
import com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.ARTISTDAILYREPORT;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.BILLIONSCLUBINFO.BillionsClubGrade;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.BILLIONSCLUBINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.FORESTARTISTINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.TITLESONG;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.ARTISTPICK;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.CREDITINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.DETAILINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.TOPICLIST;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes;
import com.iloen.melon.net.v6x.response.ArtistTemperatureScoreNoticeRes.RESPONSE.SCORENOTICEINFO;
import com.iloen.melon.net.v6x.response.ArtistTemperatureScoreNoticeRes;
import com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE.MEMORIALCARDRELAYLIST;
import com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Song;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableArtist;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.ImageUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.shortcut.ShortcutManager;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.ui.K1;
import com.melon.ui.k2;
import com.melon.ui.popup.b;
import com.melon.ui.v1;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import je.p;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.O;
import p8.f;
import p8.g;
import p8.s;
import pc.I0;
import r8.c;
import v9.h;
import v9.i;
import va.e0;
import we.n;
import z9.F;
import z9.j;
import zd.M;

@Metadata(d1 = {"\u0000\u00E2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \u00D6\u00012\u00020\u0001:\b\u00D6\u0001\u00D7\u0001\u00D8\u0001\u00D9\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u000FJ\u000F\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u000F\u0010\u001B\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0003J\u0017\u0010\u001E\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0019\u0010\"\u001A\u00020\u00062\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010(\u001A\u00020\u00062\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&H\u0016\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010,\u001A\u00020\u00062\u0006\u0010+\u001A\u00020*H\u0016\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b0\u0010/J\u000F\u00102\u001A\u000201H\u0016\u00A2\u0006\u0004\b2\u00103J\u0011\u00105\u001A\u0004\u0018\u000104H\u0014\u00A2\u0006\u0004\b5\u00106J\u001B\u0010:\u001A\u0006\u0012\u0002\b\u0003092\u0006\u00108\u001A\u000207H\u0014\u00A2\u0006\u0004\b:\u0010;J-\u0010A\u001A\u00020\u00042\b\u0010=\u001A\u0004\u0018\u00010<2\b\u0010?\u001A\u0004\u0018\u00010>2\b\u0010@\u001A\u0004\u0018\u00010\tH\u0014\u00A2\u0006\u0004\bA\u0010BJ\r\u0010C\u001A\u00020\u0004\u00A2\u0006\u0004\bC\u0010/J\u000F\u0010D\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bD\u0010\u000BJ\u000F\u0010E\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bE\u0010\u000BJ!\u0010H\u001A\u00020\u00062\b\u0010F\u001A\u0004\u0018\u00010\u001C2\u0006\u0010G\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bH\u0010IJ\u0013\u0010K\u001A\u00060JR\u00020\u0001H\u0016\u00A2\u0006\u0004\bK\u0010LJ\u0011\u0010N\u001A\u0004\u0018\u00010MH\u0014\u00A2\u0006\u0004\bN\u0010OJ7\u0010U\u001A\u00020\u00062\u0006\u0010P\u001A\u00020\u001C2\u0006\u0010Q\u001A\u00020\t2\u0006\u0010R\u001A\u00020\t2\u0006\u0010S\u001A\u00020\t2\u0006\u0010T\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bU\u0010VJ?\u0010X\u001A\u00020\u00062\u0006\u0010P\u001A\u00020\u001C2\u0006\u0010Q\u001A\u00020\t2\u0006\u0010R\u001A\u00020\t2\u0006\u0010S\u001A\u00020\t2\u0006\u0010T\u001A\u00020\t2\u0006\u0010W\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bX\u0010YJ7\u0010Z\u001A\u00020\u00062\u0006\u0010P\u001A\u00020\u001C2\u0006\u0010Q\u001A\u00020\t2\u0006\u0010R\u001A\u00020\t2\u0006\u0010S\u001A\u00020\t2\u0006\u0010T\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bZ\u0010VJ\u000F\u0010[\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b[\u0010\u0003J\u000F\u0010\\\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\\\u0010\u0003J\u000F\u0010]\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b]\u0010\u0003J\u000F\u0010^\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b^\u0010\u0003J\u000F\u0010_\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b_\u0010\u0003J\u0017\u0010`\u001A\u00020\u00062\u0006\u0010+\u001A\u00020*H\u0002\u00A2\u0006\u0004\b`\u0010-J\u001F\u0010e\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010d0c2\u0006\u0010b\u001A\u00020aH\u0002\u00A2\u0006\u0004\be\u0010fJ\u001F\u0010h\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010g0c2\u0006\u0010b\u001A\u00020aH\u0002\u00A2\u0006\u0004\bh\u0010fJ\u001F\u0010j\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010i0c2\u0006\u0010b\u001A\u00020aH\u0002\u00A2\u0006\u0004\bj\u0010fJ\u001F\u0010l\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010k0c2\u0006\u0010b\u001A\u00020aH\u0002\u00A2\u0006\u0004\bl\u0010fJ\u001F\u0010o\u001A\u00020n2\u0006\u0010b\u001A\u00020a2\u0006\u0010m\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bo\u0010pJ\'\u0010t\u001A\u00020n2\u0006\u0010b\u001A\u00020a2\u000E\u0010s\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010r0qH\u0002\u00A2\u0006\u0004\bt\u0010uJ\'\u0010v\u001A\u00020n2\u0006\u0010b\u001A\u00020a2\u000E\u0010s\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010r0qH\u0002\u00A2\u0006\u0004\bv\u0010uJ\u0017\u0010y\u001A\u00020\u00062\u0006\u0010x\u001A\u00020wH\u0002\u00A2\u0006\u0004\by\u0010zJ\u0017\u0010}\u001A\u00020\u00062\u0006\u0010|\u001A\u00020{H\u0002\u00A2\u0006\u0004\b}\u0010~J\u001B\u0010\u0081\u0001\u001A\u00020\u00062\u0007\u0010\u0080\u0001\u001A\u00020\u007FH\u0002\u00A2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001B\u0010\u0084\u0001\u001A\u00020\u00062\u0007\u0010\u0083\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J,\u0010\u0087\u0001\u001A\u000B\u0012\u0007\u0012\u0005\u0018\u00010\u0086\u00010c2\u0006\u0010b\u001A\u00020a2\u0007\u0010\u0083\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J,\u0010\u008A\u0001\u001A\u000B\u0012\u0007\u0012\u0005\u0018\u00010\u0089\u00010c2\u0006\u0010b\u001A\u00020a2\u0007\u0010\u0083\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0006\b\u008A\u0001\u0010\u0088\u0001J?\u0010\u0091\u0001\u001A\u00020\u00062\u001F\u0010\u008E\u0001\u001A\u001A\u0012\u0005\u0012\u00030\u008C\u0001\u0018\u00010\u008B\u0001j\f\u0012\u0005\u0012\u00030\u008C\u0001\u0018\u0001`\u008D\u00012\n\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u0001H\u0002\u00A2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\'\u0010\u0094\u0001\u001A\u00020\u00062\u0007\u0010\u0093\u0001\u001A\u00020\u001C2\n\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u0001H\u0002\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0011\u0010\u0096\u0001\u001A\u00020\u0006H\u0002\u00A2\u0006\u0005\b\u0096\u0001\u0010\u0003J\u0011\u0010\u0097\u0001\u001A\u00020\u0006H\u0002\u00A2\u0006\u0005\b\u0097\u0001\u0010\u0003J\u0011\u0010\u0098\u0001\u001A\u00020\u0006H\u0002\u00A2\u0006\u0005\b\u0098\u0001\u0010\u0003J\u0015\u0010\u009A\u0001\u001A\u0005\u0018\u00010\u0099\u0001H\u0002\u00A2\u0006\u0006\b\u009A\u0001\u0010\u009B\u0001J\u001A\u0010\u009D\u0001\u001A\u00020\u00062\u0007\u0010\u009C\u0001\u001A\u00020wH\u0002\u00A2\u0006\u0005\b\u009D\u0001\u0010zJ\u001B\u0010\u009F\u0001\u001A\u00020\u00062\u0007\u0010\u009E\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0006\b\u009F\u0001\u0010\u0085\u0001J\u001B\u0010\u00A0\u0001\u001A\u00020\u00062\u0007\u0010\u009E\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0006\b\u00A0\u0001\u0010\u0085\u0001R*\u0010\u00A2\u0001\u001A\u00030\u00A1\u00018\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u00A2\u0001\u0010\u00A3\u0001\u001A\u0006\b\u00A4\u0001\u0010\u00A5\u0001\"\u0006\b\u00A6\u0001\u0010\u00A7\u0001R\u001E\u0010\u00A9\u0001\u001A\u00070\u00A8\u0001R\u00020\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u00A9\u0001\u0010\u00AA\u0001R\u001A\u0010\u00AC\u0001\u001A\u00030\u00AB\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u00AC\u0001\u0010\u00AD\u0001R\u001B\u0010\u00AE\u0001\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AE\u0001\u0010\u00AF\u0001R\u0019\u0010\u0083\u0001\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u00B0\u0001R\u0019\u0010\u00B1\u0001\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B1\u0001\u0010\u00B0\u0001R\u0019\u0010\u00B2\u0001\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B2\u0001\u0010\u00B0\u0001R\u0019\u0010\u00B3\u0001\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B3\u0001\u0010\u00B4\u0001R\u0019\u0010\u00B5\u0001\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B5\u0001\u0010\u00B4\u0001R\u0019\u0010\u00B6\u0001\u001A\u00020\u001C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B6\u0001\u0010\u00B7\u0001R\u0019\u0010\u00B8\u0001\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B8\u0001\u0010\u00B4\u0001R\u0019\u0010\u00B9\u0001\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B9\u0001\u0010\u00B4\u0001R\u001C\u0010\u00BB\u0001\u001A\u0005\u0018\u00010\u00BA\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BB\u0001\u0010\u00BC\u0001R\u001C\u0010\u00BD\u0001\u001A\u0005\u0018\u00010\u00BA\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BD\u0001\u0010\u00BC\u0001R\u0019\u0010\u00BE\u0001\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BE\u0001\u0010\u00B0\u0001R\u0018\u0010\u00C0\u0001\u001A\u00030\u00BF\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C0\u0001\u0010\u00C1\u0001R\u0019\u0010\u00C2\u0001\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00C2\u0001\u0010\u00B4\u0001R\u0018\u0010\u00C4\u0001\u001A\u00030\u00C3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C4\u0001\u0010\u00C5\u0001R\u0018\u0010\u00C6\u0001\u001A\u00030\u00C3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C6\u0001\u0010\u00C5\u0001R \u0010\u00C8\u0001\u001A\u00030\u00C7\u00018\u0016X\u0096\u0004\u00A2\u0006\u0010\n\u0006\b\u00C8\u0001\u0010\u00C9\u0001\u001A\u0006\b\u00CA\u0001\u0010\u00CB\u0001R\u001C\u0010\u00CD\u0001\u001A\u0005\u0018\u00010\u00CC\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00CD\u0001\u0010\u00CE\u0001R\u0018\u0010\u00D2\u0001\u001A\u00030\u00CF\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00D0\u0001\u0010\u00D1\u0001R\u0017\u0010\u00D5\u0001\u001A\u00020\u001C8VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00D3\u0001\u0010\u00D4\u0001\u00A8\u0006\u00DA\u0001"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "<init>", "()V", "", "isVisible", "Lie/H;", "onFragmentVisibilityChanged", "(Z)V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onAppBarCollapsed", "onAppBarExpended", "", "offset", "onAppBarScrolling", "(I)V", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "infoCmtContsRes", "updateCommentCountView", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "useDrawHeaderWhenConfigurationChange", "()Z", "useBottomButton", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "isFan", "getContsId", "getContsTypeCode", "sumCount", "isLike", "updateLikeView", "(Ljava/lang/Integer;Z)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "getOnViewHolderActionListener", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "ordNum", "image", "metaId", "metaName", "metaAuthor", "songThumbClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cType", "songPlayClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "songMoreClickLog", "onStart", "onStop", "registerIsLoginFlow", "showMorePopup", "trackTiaraShowMorePopup", "updateLayoutMargin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes;", "requestBannerInfoAsync", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes;", "requestContentsAsync", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes;", "requestBasicInfoAsync", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes;", "requestSummaryAsync", "chnlSeq", "Lkotlinx/coroutines/Job;", "requestCmtInfoJob", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)Lkotlinx/coroutines/Job;", "", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$TOPICLIST;", "topicList", "requestTopicLikeJob", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;)Lkotlinx/coroutines/Job;", "requestTopicListLikeAndCmtJob", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE;", "res", "drawHeaderView", "(Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE;)V", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$ARTISTPICK;", "artistPick", "drawArtistPickLayout", "(Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$ARTISTPICK;)V", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$CREDITINFO;", "creditInfo", "drawCreditLayout", "(Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$CREDITINFO;)V", "artistId", "fetchFanAndTemperatureInfo", "(Ljava/lang/String;)V", "Lcom/iloen/melon/net/v4x/response/UserActionsRes;", "requestUserActionsAsync", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureScoreNoticeRes;", "requestTemperatureScoreNoticeAsync", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response$RelationList;", "Lkotlin/collections/ArrayList;", "relList", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureScoreNoticeRes$RESPONSE;", "scoreNoticeResponse", "updateFanAndTemperatureUi", "(Ljava/util/ArrayList;Lcom/iloen/melon/net/v6x/response/ArtistTemperatureScoreNoticeRes$RESPONSE;)V", "percent", "updateTemperatureUi", "(ILcom/iloen/melon/net/v6x/response/ArtistTemperatureScoreNoticeRes$RESPONSE;)V", "showCreateShortcutPopup", "insertExcludedArtist", "deleteExcludedArtist", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "response", "playTitleSong", "clickLayer1", "sendTiaraTemperature", "sendTiaraBillionsClub", "Lmb/k;", "loginUseCase", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "setLoginUseCase", "(Lmb/k;)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "detailAdapter", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "LJ8/k;", "headerBinding", "LJ8/k;", "bottomDivider", "Landroid/view/View;", "Ljava/lang/String;", "artistName", "artistImageUrl", "isAutoPlay", "Z", "isOwnArtist", "songListHeaderPosition", "I", "isConfettiShown", "isCollapsed", "LF8/o;", "titleItemBase", "LF8/o;", "whiteFixedTitleItemBase", "bbsChannelSeq", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$PopupHandler;", "popupHandler", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$PopupHandler;", "hasBillionsClubAlbum", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "subExceptionHandler", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "getBottomBtnData", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "Lcom/iloen/melon/custom/ArtistCardRelayRollingView;", "cardRelayRollingView", "Lcom/iloen/melon/custom/ArtistCardRelayRollingView;", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "getCommentAdapterPosition", "()I", "commentAdapterPosition", "Companion", "PopupHandler", "ArtistItemDecoration", "ArtistDetailAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailHomeFragment extends Hilt_ArtistDetailHomeFragment {
    @Metadata(d1 = {"\u0000\u00A6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002:\u0002\u0088\u0001B\'\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0018\u00010\u0005\u00A2\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ)\u0010 \u001A\u00020\u001F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b \u0010!J#\u0010%\u001A\u00020$2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b%\u0010&J#\u0010(\u001A\u00020\'2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b(\u0010)J#\u0010+\u001A\u00020*2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b+\u0010,J#\u0010.\u001A\u00020-2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b.\u0010/J#\u00101\u001A\u0002002\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b1\u00102J#\u00104\u001A\u0002032\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b4\u00105J#\u00107\u001A\u0002062\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b7\u00108J#\u0010:\u001A\u0002092\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b:\u0010;J#\u0010=\u001A\u00020<2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b=\u0010>J#\u0010@\u001A\u00020?2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b@\u0010AJ#\u0010C\u001A\u00020B2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bC\u0010DJ#\u0010F\u001A\u00020E2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bF\u0010GJ#\u0010I\u001A\u00020H2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bI\u0010JJ#\u0010L\u001A\u00020K2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bL\u0010MJ#\u0010O\u001A\u00020N2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bO\u0010PJ#\u0010R\u001A\u00020Q2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bR\u0010SJ#\u0010U\u001A\u00020T2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bU\u0010VJ#\u0010X\u001A\u00020W2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\bX\u0010YJ#\u0010[\u001A\u00020Z2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b[\u0010\\J#\u0010^\u001A\u00020]2\u0006\u0010\u0019\u001A\u00020\u00182\n\u0010#\u001A\u00060\"R\u00020\u0002H\u0016\u00A2\u0006\u0004\b^\u0010_J\u0019\u0010`\u001A\u00020\u001F2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b`\u0010aJ\r\u0010b\u001A\u00020\u001F\u00A2\u0006\u0004\bb\u0010cR$\u0010e\u001A\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\be\u0010f\u001A\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010l\u001A\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bl\u0010m\u001A\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010s\u001A\u0004\u0018\u00010r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bs\u0010t\u001A\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010z\u001A\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bz\u0010{\u001A\u0004\b|\u0010}\"\u0004\b~\u0010\u007FR\u001C\u0010\u0081\u0001\u001A\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0084\u0001\u001A\u00020\u00132\u0007\u0010\u0083\u0001\u001A\u00020\u00138\u0006@BX\u0086\u000E\u00A2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001\u00A8\u0006\u0089\u0001"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$ArtistDetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Landroid/content/Context;", "context", "", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Landroidx/recyclerview/widget/O0;", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolder;", "getArtistFanCmtShareHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistBannerHolder;", "getArtistBannerHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistBannerHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMixUpHolder;", "getArtistMixUpHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMixUpHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder;", "getArtistHighlightHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder;", "getArtistPhotoLinearHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoGridHolder;", "getArtistPhotoGridHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoGridHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistInfoHolder;", "getArtistInfoHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistInfoHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder;", "getArtistGroupHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistArtistNoteHolder;", "getArtistArtistNoteHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistArtistNoteHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "getVideoHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "getMagazineHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "getStationHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder;", "getArtistAlbumHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "getCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "getEmptyCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistDailyReportHolder;", "getArtistDailyReportHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistDailyReportHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistSongListHeaderHolder;", "getArtistSongListHeaderHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistSongListHeaderHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder;", "getMelonHallHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/MelonTabTitleHolder;", "getMelonTabTitleHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/MelonTabTitleHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder;", "getArtistTopicHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder;", "clearCache", "(Ljava/lang/String;)V", "updateFanCmtShareHolder", "()V", "Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes$RESPONSE;", "bannerRes", "Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes$RESPONSE;", "getBannerRes", "()Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes$RESPONSE;", "setBannerRes", "(Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes$RESPONSE;)V", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE;", "contentsRes", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE;", "getContentsRes", "()Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE;", "setContentsRes", "(Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE;)V", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes$RESPONSE;", "summaryRes", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes$RESPONSE;", "getSummaryRes", "()Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes$RESPONSE;", "setSummaryRes", "(Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes$RESPONSE;)V", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "cmtContsSumm", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "getCmtContsSumm", "()Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "setCmtContsSumm", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;)V", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE;", "basicRes", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE;", "value", "commentPosition", "I", "getCommentPosition", "()I", "CardRelayViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ArtistDetailAdapter extends DetailAdapter {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\f\u001A\u0004\b\u0019\u0010\u000E¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$ArtistDetailAdapter$CardRelayViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$ArtistDetailAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "titleContainer", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "getTitleContainer", "()Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "defaultCardLayout", "Landroid/view/View;", "getDefaultCardLayout", "()Landroid/view/View;", "loginLayout", "getLoginLayout", "Landroid/widget/TextView;", "tvLoginUserName", "Landroid/widget/TextView;", "getTvLoginUserName", "()Landroid/widget/TextView;", "tvLoginDesc", "getTvLoginDesc", "cardRelayEmptyView", "getCardRelayEmptyView", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class CardRelayViewHolder extends O0 {
            @NotNull
            private final View cardRelayEmptyView;
            @NotNull
            private final View defaultCardLayout;
            @NotNull
            private final View loginLayout;
            @NotNull
            private final MainTabTitleView titleContainer;
            @NotNull
            private final TextView tvLoginDesc;
            @NotNull
            private final TextView tvLoginUserName;

            public CardRelayViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistDetailAdapter.this = artistDetailHomeFragment$ArtistDetailAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A07CA);  // id:main_contents_title
                q.e(view1, "null cannot be cast to non-null type com.iloen.melon.fragments.main.common.MainTabTitleView");
                this.titleContainer = (MainTabTitleView)view1;
                View view2 = view0.findViewById(0x7F0A08BE);  // id:not_login_layout
                q.e(view2, "null cannot be cast to non-null type android.view.View");
                this.defaultCardLayout = view2;
                View view3 = view0.findViewById(0x7F0A07A9);  // id:login_layout
                q.e(view3, "null cannot be cast to non-null type android.view.View");
                this.loginLayout = view3;
                View view4 = view0.findViewById(0x7F0A0CA8);  // id:tv_login_user_name
                q.e(view4, "null cannot be cast to non-null type android.widget.TextView");
                this.tvLoginUserName = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A0CA6);  // id:tv_login_desc
                q.e(view5, "null cannot be cast to non-null type android.widget.TextView");
                this.tvLoginDesc = (TextView)view5;
                View view6 = view0.findViewById(0x7F0A0204);  // id:card_relay_empty_view
                q.e(view6, "null cannot be cast to non-null type android.view.View");
                this.cardRelayEmptyView = view6;
                View view7 = view0.findViewById(0x7F0A0205);  // id:card_relay_rolling_view
                q.e(view7, "null cannot be cast to non-null type com.iloen.melon.custom.ArtistCardRelayRollingView");
                ArtistDetailHomeFragment.this.cardRelayRollingView = (ArtistCardRelayRollingView)view7;
            }

            @NotNull
            public final View getCardRelayEmptyView() {
                return this.cardRelayEmptyView;
            }

            @NotNull
            public final View getDefaultCardLayout() {
                return this.defaultCardLayout;
            }

            @NotNull
            public final View getLoginLayout() {
                return this.loginLayout;
            }

            @NotNull
            public final MainTabTitleView getTitleContainer() {
                return this.titleContainer;
            }

            @NotNull
            public final TextView getTvLoginDesc() {
                return this.tvLoginDesc;
            }

            @NotNull
            public final TextView getTvLoginUserName() {
                return this.tvLoginUserName;
            }
        }

        @Nullable
        private RESPONSE bannerRes;
        @Nullable
        private com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE basicRes;
        @Nullable
        private CMTCONTSSUMM cmtContsSumm;
        private int commentPosition;
        @Nullable
        private com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE contentsRes;
        @Nullable
        private com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE summaryRes;

        public ArtistDetailAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.commentPosition = -1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void clearCache(@Nullable String s) {
            this.bannerRes = null;
            this.contentsRes = null;
            this.basicRes = null;
            super.clearCache(s);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistAlbumHolder getArtistAlbumHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistAlbumHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistArtistNoteHolder getArtistArtistNoteHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistArtistNoteHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistBannerHolder getArtistBannerHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistBannerHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistDailyReportHolder getArtistDailyReportHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistDailyReportHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistFanCmtShareHolder getArtistFanCmtShareHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistFanCmtShareHolder.Companion.newInstance(ArtistDetailHomeFragment.this.bbsChannelSeq, viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistGroupHolder getArtistGroupHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistGroupHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistHighlightHolder getArtistHighlightHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistHighlightHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistInfoHolder getArtistInfoHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistInfoHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistMixUpHolder getArtistMixUpHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistMixUpHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistPhotoGridHolder getArtistPhotoGridHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistPhotoGridHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistPhotoLinearHolder getArtistPhotoLinearHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistPhotoLinearHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistSongListHeaderHolder getArtistSongListHeaderHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistSongListHeaderHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistTopicHolder getArtistTopicHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistTopicHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Nullable
        public final RESPONSE getBannerRes() {
            return this.bannerRes;
        }

        @Nullable
        public final CMTCONTSSUMM getCmtContsSumm() {
            return this.cmtContsSumm;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public DetailCommentItemHolder getCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return DetailCommentItemHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        public final int getCommentPosition() {
            return this.commentPosition;
        }

        @Nullable
        public final com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE getContentsRes() {
            return this.contentsRes;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public EmptyCommentHolder getEmptyCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return EmptyCommentHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0, true);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public int getItemViewTypeImpl(int v, int v1) {
            AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)this.getItem(v1);
            Integer integer0 = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getItemViewType();
            if(integer0 != null && ((int)integer0) == 27) {
                return ScreenUtils.isTablet(this.getContext()) ? 26 : 27;
            }
            return super.getItemViewTypeImpl(v, v1);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public MagazineHolder getMagazineHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistMagazineHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public ArtistMelonHallHolder getMelonHallHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistMelonHallHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public MelonTabTitleHolder getMelonTabTitleHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return MelonTabTitleHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public StationHolder getStationHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistStationHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Nullable
        public final com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE getSummaryRes() {
            return this.summaryRes;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public VideoHolder getVideoHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return ArtistVideoHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            List list1;
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            List list0 = null;
            if(httpResponse0 instanceof ArtistHomeBasicInfoRes) {
                com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0 = ((ArtistHomeBasicInfoRes)httpResponse0).response;
                this.basicRes = artistHomeBasicInfoRes$RESPONSE0;
                ArtistDetailHomeFragment.this.mMenuId = artistHomeBasicInfoRes$RESPONSE0 == null ? null : artistHomeBasicInfoRes$RESPONSE0.menuId;
                this.updateModifiedTime(this.getCacheKey());
            }
            ArrayList arrayList0 = new ArrayList();
            com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE1 = this.basicRes;
            if(artistHomeBasicInfoRes$RESPONSE1 != null) {
                AdapterInViewHolder.Row adapterInViewHolder$Row0 = AdapterInViewHolder.Row.create(0x1F, new m(artistHomeBasicInfoRes$RESPONSE1, this.cmtContsSumm));
                adapterInViewHolder$Row0.setContentId(ArtistDetailHomeFragment.this.artistId);
                arrayList0.add(adapterInViewHolder$Row0);
            }
            if(this.bannerRes != null && (this.bannerRes.banners != null && !this.bannerRes.banners.isEmpty() == 1)) {
                AdapterInViewHolder.Row adapterInViewHolder$Row1 = AdapterInViewHolder.Row.create(33, this.bannerRes);
                adapterInViewHolder$Row1.setMenuId(ArtistDetailHomeFragment.this.mMenuId);
                arrayList0.add(adapterInViewHolder$Row1);
            }
            if(ProtocolUtils.parseBoolean((this.basicRes == null ? null : this.basicRes.mixUpButton))) {
                arrayList0.add(AdapterInViewHolder.Row.create(0x20, this.basicRes));
            }
            if(this.basicRes != null && (this.basicRes.fanLoungeLinkInfo != null && (this.basicRes.fanLoungeLinkInfo.linkurl != null && !o.H0(this.basicRes.fanLoungeLinkInfo.linkurl) == 1))) {
                arrayList0.add(AdapterInViewHolder.Row.create(1004, (this.basicRes == null ? null : this.basicRes.fanLoungeLinkInfo)));
            }
            if(ArtistDetailHomeFragment.this.isOwnArtist && (this.basicRes != null && (this.basicRes.artistDailyReport != null && (this.basicRes.artistDailyReport.topSongList != null && !this.basicRes.artistDailyReport.topSongList.isEmpty() == 1)))) {
                com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE2 = this.basicRes;
                if(artistHomeBasicInfoRes$RESPONSE2 == null) {
                    list1 = null;
                }
                else {
                    ARTISTDAILYREPORT artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT0 = artistHomeBasicInfoRes$RESPONSE2.artistDailyReport;
                    list1 = artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT0 == null ? null : artistHomeBasicInfoRes$RESPONSE$ARTISTDAILYREPORT0.topSongList;
                }
                arrayList0.add(AdapterInViewHolder.Row.create(34, list1));
            }
            if(ArtistDetailHomeFragment.this.isOwnArtist) {
                String s1 = this.getContext() == null ? null : "아티스트 팬톡";
                if(s1 != null) {
                    arrayList0.add(AdapterInViewHolder.Row.create(52, s1));
                }
                List list2 = this.contentsRes == null ? null : this.contentsRes.topicList;
                if(list2 != null && !list2.isEmpty() == 1) {
                    AdapterInViewHolder.Row adapterInViewHolder$Row2 = AdapterInViewHolder.Row.create(53, this.contentsRes);
                    adapterInViewHolder$Row2.setContentId(ArtistDetailHomeFragment.this.artistId);
                    arrayList0.add(adapterInViewHolder$Row2);
                }
                this.commentPosition = arrayList0.size();
            }
            if(this.contentsRes != null && (this.contentsRes.highlightList != null && !this.contentsRes.highlightList.isEmpty() == 1)) {
                arrayList0.add(AdapterInViewHolder.Row.create(30, (this.contentsRes == null ? null : this.contentsRes.highlightList)));
            }
            if(this.contentsRes != null && (this.contentsRes.songList != null && !this.contentsRes.songList.isEmpty() == 1)) {
                HeaderData artistSongListHeaderHolder$HeaderData0 = new HeaderData(null, 1, null);
                artistSongListHeaderHolder$HeaderData0.setArtistId(ArtistDetailHomeFragment.this.artistId);
                ArtistDetailHomeFragment.this.songListHeaderPosition = arrayList0.size();
                a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a0.a = 42;
                a0.b = artistSongListHeaderHolder$HeaderData0;
                a0.f = ArtistDetailHomeFragment.this.artistName;
                a0.c = ArtistDetailHomeFragment.this.mMenuId;
                arrayList0.add(new AdapterInViewHolder.Row(a0));
                com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE0 = this.contentsRes;
                if(artistHomeContentsRes$RESPONSE0 != null) {
                    List list3 = artistHomeContentsRes$RESPONSE0.songList;
                    if(list3 != null) {
                        ArtistDetailHomeFragment artistDetailHomeFragment0 = ArtistDetailHomeFragment.this;
                        for(Object object0: list3) {
                            a a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a1.a = 1;
                            a1.b = (SONG)object0;
                            a1.c = artistDetailHomeFragment0.mMenuId;
                            arrayList0.add(new AdapterInViewHolder.Row(a1));
                        }
                    }
                }
            }
            List list4 = this.basicRes == null ? null : this.basicRes.melonHallList;
            if(list4 != null && !list4.isEmpty()) {
                AdapterInViewHolder.Row adapterInViewHolder$Row3 = AdapterInViewHolder.Row.create(50, (this.basicRes == null ? null : this.basicRes.melonHallList), ArtistDetailHomeFragment.this.mMenuId);
                adapterInViewHolder$Row3.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row3.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                adapterInViewHolder$Row3.setViewAllLinkInfo(MelonLinkInfo.b((this.basicRes == null ? null : this.basicRes.melonHallLinkInfo)));
                arrayList0.add(adapterInViewHolder$Row3);
            }
            if(this.contentsRes != null && (this.contentsRes.recmTrackList != null && !this.contentsRes.recmTrackList.isEmpty() == 1)) {
                AdapterInViewHolder.Row adapterInViewHolder$Row4 = AdapterInViewHolder.Row.create(1001, (this.contentsRes == null ? null : this.contentsRes.recmTrackList), ArtistDetailHomeFragment.this.mMenuId);
                adapterInViewHolder$Row4.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row4.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                arrayList0.add(adapterInViewHolder$Row4);
            }
            if(this.contentsRes != null && (this.contentsRes.albumList != null && !this.contentsRes.albumList.isEmpty() == 1)) {
                AdapterInViewHolder.Row adapterInViewHolder$Row5 = AdapterInViewHolder.Row.create(24, (this.contentsRes == null ? null : this.contentsRes.albumList), ArtistDetailHomeFragment.this.mMenuId);
                adapterInViewHolder$Row5.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row5.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                arrayList0.add(adapterInViewHolder$Row5);
            }
            List list5 = this.contentsRes == null ? null : this.contentsRes.spotlightList;
            if(list5 != null && !list5.isEmpty() == 1) {
                arrayList0.add(AdapterInViewHolder.Row.create(1002, list5));
            }
            List list6 = this.contentsRes == null ? null : this.contentsRes.hiRisingList;
            if(list6 != null && !list6.isEmpty() == 1) {
                arrayList0.add(AdapterInViewHolder.Row.create(1005, list6));
            }
            List list7 = this.contentsRes == null ? null : this.contentsRes.videoList;
            if(list7 != null && !list7.isEmpty() == 1) {
                AdapterInViewHolder.Row adapterInViewHolder$Row6 = AdapterInViewHolder.Row.create(3, p.K0(3, list7), ArtistDetailHomeFragment.this.mMenuId);
                adapterInViewHolder$Row6.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row6.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                adapterInViewHolder$Row6.setViewAll(true);
                arrayList0.add(adapterInViewHolder$Row6);
            }
            List list8 = this.contentsRes == null ? null : this.contentsRes.photoList;
            if(list8 != null && !list8.isEmpty() == 1) {
                AdapterInViewHolder.Row adapterInViewHolder$Row7 = list8.size() > 5 ? AdapterInViewHolder.Row.create(27, list8) : AdapterInViewHolder.Row.create(26, list8);
                adapterInViewHolder$Row7.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row7.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                arrayList0.add(adapterInViewHolder$Row7);
            }
            com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE1 = this.contentsRes;
            if(artistHomeContentsRes$RESPONSE1 != null) {
                DETAILINFO artistHomeContentsRes$RESPONSE$DETAILINFO0 = artistHomeContentsRes$RESPONSE1.detailinfo;
                if(artistHomeContentsRes$RESPONSE$DETAILINFO0 != null) {
                    arrayList0.add(AdapterInViewHolder.Row.create(15, artistHomeContentsRes$RESPONSE1));
                    if(artistHomeContentsRes$RESPONSE$DETAILINFO0.memberList != null && !artistHomeContentsRes$RESPONSE$DETAILINFO0.memberList.isEmpty() == 1 || artistHomeContentsRes$RESPONSE$DETAILINFO0.groupList != null && !artistHomeContentsRes$RESPONSE$DETAILINFO0.groupList.isEmpty() == 1) {
                        arrayList0.add(AdapterInViewHolder.Row.create(16, artistHomeContentsRes$RESPONSE$DETAILINFO0));
                    }
                }
            }
            List list9 = this.contentsRes == null ? null : this.contentsRes.artistNoteList;
            if(list9 != null && !list9.isEmpty() == 1) {
                AdapterInViewHolder.Row adapterInViewHolder$Row8 = AdapterInViewHolder.Row.create(25, p.K0(3, list9));
                adapterInViewHolder$Row8.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row8.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                arrayList0.add(adapterInViewHolder$Row8);
            }
            List list10 = this.contentsRes == null ? null : this.contentsRes.stationList;
            if(list10 != null && !list10.isEmpty() == 1) {
                AdapterInViewHolder.Row adapterInViewHolder$Row9 = AdapterInViewHolder.Row.create(7, p.K0(3, list10), ArtistDetailHomeFragment.this.mMenuId);
                adapterInViewHolder$Row9.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row9.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                adapterInViewHolder$Row9.setViewAll(true);
                arrayList0.add(adapterInViewHolder$Row9);
            }
            List list11 = this.contentsRes == null ? null : this.contentsRes.magazineList;
            if(list11 != null && !list11.isEmpty() == 1) {
                AdapterInViewHolder.Row adapterInViewHolder$Row10 = AdapterInViewHolder.Row.create(5, p.K0(3, list11), ArtistDetailHomeFragment.this.mMenuId);
                adapterInViewHolder$Row10.setContentId(ArtistDetailHomeFragment.this.artistId);
                adapterInViewHolder$Row10.setContentOwner(ArtistDetailHomeFragment.this.artistName);
                arrayList0.add(adapterInViewHolder$Row10);
            }
            com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE artistTemperatureSummaryRes$RESPONSE0 = this.summaryRes;
            if(artistTemperatureSummaryRes$RESPONSE0 != null) {
                arrayList0.add(AdapterInViewHolder.Row.create(1000, artistTemperatureSummaryRes$RESPONSE0));
            }
            FORESTARTISTINFO artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0 = this.basicRes == null ? null : this.basicRes.forestArtistInfo;
            if(artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0 != null && (artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.participationAmount != null && !o.H0(artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.participationAmount) == 1)) {
                arrayList0.add(AdapterInViewHolder.Row.create(1003, artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0));
            }
            if(!ArtistDetailHomeFragment.this.isOwnArtist) {
                String s2 = this.getContext() == null ? null : "아티스트 팬톡";
                if(s2 != null) {
                    arrayList0.add(AdapterInViewHolder.Row.create(52, s2));
                }
                com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE2 = this.contentsRes;
                if(artistHomeContentsRes$RESPONSE2 != null) {
                    list0 = artistHomeContentsRes$RESPONSE2.topicList;
                }
                if(list0 != null && !list0.isEmpty() == 1) {
                    AdapterInViewHolder.Row adapterInViewHolder$Row11 = AdapterInViewHolder.Row.create(53, this.contentsRes);
                    adapterInViewHolder$Row11.setContentId(ArtistDetailHomeFragment.this.artistId);
                    arrayList0.add(adapterInViewHolder$Row11);
                }
                this.commentPosition = arrayList0.size();
            }
            this.addAll(arrayList0);
            return true;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            Integer integer0 = o00 == null ? null : o00.getItemViewType();
            if(integer0 != null && ((int)integer0) == 1000) {
                q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter.CardRelayViewHolder");
                AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)this.getItem(v1);
                Object object0 = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getItem();
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE");
                String s = ((com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE)object0).artistMemorialCardRelayCnt;
                if(s == null || s.length() == 0 || q.b(((com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE)object0).artistMemorialCardRelayCnt, "0")) {
                    ((CardRelayViewHolder)o00).getTitleContainer().setTitle(ArtistDetailHomeFragment.this.getString(0x7F13013A));  // string:artist_fan_list_card_relay_of_fan "팬들의 카드릴레이"
                }
                else {
                    ((CardRelayViewHolder)o00).getTitleContainer().setTitle(ArtistDetailHomeFragment.this.getString(0x7F13013A) + " " + ((com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE)object0).artistMemorialCardRelayCnt);  // string:artist_fan_list_card_relay_of_fan "팬들의 카드릴레이"
                }
                MainTabTitleView mainTabTitleView0 = ((CardRelayViewHolder)o00).getTitleContainer();
                mainTabTitleView0.setTitleClickable(true);
                mainTabTitleView0.getBinding().e.setOnClickListener(null);
                mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                    @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                    public void onViewAllButtonClick(View view0) {
                        q.g(view0, "view");
                        if(ArtistDetailHomeFragment.this.isLoginUser()) {
                            Navigator.open(ArtistDetailFanListFragment.Companion.newInstance(ArtistDetailHomeFragment.this.artistId, ArtistDetailHomeFragment.this.artistName));
                            f f0 = ArtistDetailHomeFragment.this.getTiaraEventBuilder();
                            if(f0 != null) {
                                f0.a = ArtistDetailHomeFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                                f0.y = ArtistDetailHomeFragment.this.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
                                f0.F = ArtistDetailHomeFragment.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                                f0.a().track();
                            }
                            return;
                        }
                        ArtistDetailHomeFragment.this.showLoginPopup();
                    }
                });
                ((CardRelayViewHolder)o00).getDefaultCardLayout().setVisibility(8);
                ((CardRelayViewHolder)o00).getLoginLayout().setVisibility(8);
                if(!ArtistDetailHomeFragment.this.isLoginUser() || StringUtils.getNumberFromString(((com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE)object0).activeMemorialCardCnt) <= 0) {
                    ((CardRelayViewHolder)o00).getDefaultCardLayout().setVisibility(0);
                    ((CardRelayViewHolder)o00).getDefaultCardLayout().setOnClickListener(new y(ArtistDetailHomeFragment.this, 1));
                    ViewUtils.setContentDescriptionWithButtonClassName(((CardRelayViewHolder)o00).getDefaultCardLayout(), ((TextView)((CardRelayViewHolder)o00).getDefaultCardLayout().findViewById(0x7F0A0D34)).getText());  // id:tv_title
                }
                else {
                    boolean z = !ScreenUtils.isTablet(this.getContext()) && !ScreenUtils.isPortrait(this.getContext());
                    ((CardRelayViewHolder)o00).getLoginLayout().setVisibility(0);
                    ((CardRelayViewHolder)o00).getTvLoginUserName().setText(StringUtils.getTrimmed("", (z ? 16 : 4)));
                    TextView textView0 = ((CardRelayViewHolder)o00).getTvLoginDesc();
                    String s1 = ArtistDetailHomeFragment.this.getString(0x7F130120);  // string:artist_detail_card_relay_login "님은 %1$s개의 카드를 가지고 있어요."
                    q.f(s1, "getString(...)");
                    Z.y(new Object[]{((com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE)object0).activeMemorialCardCnt}, 1, s1, textView0);
                    ((CardRelayViewHolder)o00).getLoginLayout().setOnClickListener(new y(ArtistDetailHomeFragment.this, 0));
                    ViewUtils.setContentDescriptionWithButtonClassName(((CardRelayViewHolder)o00).getLoginLayout(), ((CardRelayViewHolder)o00).getTvLoginUserName().getText() + ((CardRelayViewHolder)o00).getTvLoginDesc().getText());
                }
                ArrayList arrayList0 = ((com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE)object0).memorialCardRelayListList;
                int v2 = arrayList0 == null ? 0 : arrayList0.size();
                if(v2 != 0 && v2 != 1) {
                    ((CardRelayViewHolder)o00).getCardRelayEmptyView().setVisibility(8);
                    ArtistCardRelayRollingView artistCardRelayRollingView0 = ArtistDetailHomeFragment.this.cardRelayRollingView;
                    if(artistCardRelayRollingView0 != null) {
                        artistCardRelayRollingView0.setVisibility(0);
                    }
                    ArtistCardRelayRollingView artistCardRelayRollingView1 = ArtistDetailHomeFragment.this.cardRelayRollingView;
                    if(artistCardRelayRollingView1 != null) {
                        artistCardRelayRollingView1.setData(((com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE)object0).memorialCardRelayListList);
                    }
                    ArtistCardRelayRollingView artistCardRelayRollingView2 = ArtistDetailHomeFragment.this.cardRelayRollingView;
                    if(artistCardRelayRollingView2 != null) {
                        artistCardRelayRollingView2.setOnClickListener(new z(ArtistDetailHomeFragment.this));
                    }
                    ArtistCardRelayRollingView artistCardRelayRollingView3 = ArtistDetailHomeFragment.this.cardRelayRollingView;
                    if(artistCardRelayRollingView3 != null) {
                        artistCardRelayRollingView3.b();
                    }
                    return;
                }
                ArtistCardRelayRollingView artistCardRelayRollingView4 = ArtistDetailHomeFragment.this.cardRelayRollingView;
                if(artistCardRelayRollingView4 != null) {
                    artistCardRelayRollingView4.setVisibility(8);
                }
                ((CardRelayViewHolder)o00).getCardRelayEmptyView().setVisibility(0);
                ((CardRelayViewHolder)o00).getCardRelayEmptyView().setOnClickListener(new y(ArtistDetailHomeFragment.this, 2));
                return;
            }
            super.onBindViewImpl(o00, v, v1);
        }

        private static final void onBindViewImpl$lambda$20(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
            Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(artistDetailHomeFragment0.artistId));
            String s = artistDetailHomeFragment0.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
            q.f(s, "getString(...)");
            artistDetailHomeFragment0.sendTiaraTemperature(s);
        }

        private static final void onBindViewImpl$lambda$21(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
            if(artistDetailHomeFragment0.isLoginUser()) {
                Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(artistDetailHomeFragment0.artistId));
                String s = artistDetailHomeFragment0.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
                q.f(s, "getString(...)");
                artistDetailHomeFragment0.sendTiaraTemperature(s);
                return;
            }
            artistDetailHomeFragment0.showLoginPopup();
        }

        private static final void onBindViewImpl$lambda$22(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
            if(artistDetailHomeFragment0.isLoginUser()) {
                Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(artistDetailHomeFragment0.artistId));
                String s = artistDetailHomeFragment0.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
                q.f(s, "getString(...)");
                artistDetailHomeFragment0.sendTiaraTemperature(s);
                return;
            }
            artistDetailHomeFragment0.showLoginPopup();
        }

        private static final H onBindViewImpl$lambda$24(ArtistDetailHomeFragment artistDetailHomeFragment0, int v, Object object0) {
            q.g(object0, "item");
            if(artistDetailHomeFragment0.isLoginUser()) {
                if(q.b(((MEMORIALCARDRELAYLIST)object0).type, "FEW_CARD_RELAY")) {
                    Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(artistDetailHomeFragment0.artistId));
                    String s = artistDetailHomeFragment0.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
                    q.f(s, "getString(...)");
                    artistDetailHomeFragment0.sendTiaraTemperature(s);
                    return H.a;
                }
                Navigator.open(ArtistDetailFanListFragment.Companion.newInstance(artistDetailHomeFragment0.artistId, artistDetailHomeFragment0.artistName));
                f f0 = artistDetailHomeFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    f0.a = artistDetailHomeFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = artistDetailHomeFragment0.getString(0x7F130E9D);  // string:tiara_fanlist_layer1_card_relay "카드릴레이"
                    f0.F = artistDetailHomeFragment0.getString(0x7F130CC9);  // string:tiara_artist_copy_fan_list "팬리스트"
                    f0.a().track();
                    return H.a;
                }
            }
            else {
                artistDetailHomeFragment0.showLoginPopup();
            }
            return H.a;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            switch(v) {
                case 1000: {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D020F, viewGroup0, false);  // layout:detail_item_artist_channel_card_relay
                    q.f(view0, "inflate(...)");
                    return new CardRelayViewHolder(this, view0);
                }
                case 1001: {
                    OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0 = ArtistDetailHomeFragment.this.getOnViewHolderActionListener();
                    return ArtistRecommendTrackHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
                }
                case 1002: {
                    OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener1 = ArtistDetailHomeFragment.this.getOnViewHolderActionListener();
                    return ArtistSpotlightHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener1);
                }
                case 1003: {
                    OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener2 = ArtistDetailHomeFragment.this.getOnViewHolderActionListener();
                    return ArtistForestHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener2);
                }
                case 1004: {
                    OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener3 = ArtistDetailHomeFragment.this.getOnViewHolderActionListener();
                    return ArtistFanLoungeHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener3);
                }
                case 1005: {
                    OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener4 = ArtistDetailHomeFragment.this.getOnViewHolderActionListener();
                    return ArtistHiRisingHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener4);
                }
                default: {
                    return super.onCreateViewHolderImpl(viewGroup0, v);
                }
            }
        }

        public final void setBannerRes(@Nullable RESPONSE promotionContentsBannerRes$RESPONSE0) {
            this.bannerRes = promotionContentsBannerRes$RESPONSE0;
        }

        public final void setCmtContsSumm(@Nullable CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0) {
            this.cmtContsSumm = informCmtContsSummRes$result$CMTCONTSSUMM0;
        }

        public final void setContentsRes(@Nullable com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE0) {
            this.contentsRes = artistHomeContentsRes$RESPONSE0;
        }

        public final void setSummaryRes(@Nullable com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE artistTemperatureSummaryRes$RESPONSE0) {
            this.summaryRes = artistTemperatureSummaryRes$RESPONSE0;
        }

        public final void updateFanCmtShareHolder() {
            int v = this.getItemCount();
            for(int v1 = 0; v1 < v; ++v1) {
                if(this.getItemViewType(v1) == 0x1F) {
                    this.notifyItemChanged(v1);
                    return;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$ArtistItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "()V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ArtistItemDecoration extends r0 {
        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            Context context0 = view0.getContext();
            int v = recyclerView0.getChildAdapterPosition(view0);
            j0 j00 = recyclerView0.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
            if(v == ((ArtistDetailAdapter)j00).getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(context0, 30.0f);
                return;
            }
            boolean z = !ScreenUtils.isTablet(context0) && !ScreenUtils.isPortrait(context0);
            if(v == 0) {
                if(z) {
                    rect0.top = ScreenUtils.dipToPixel(context0, 2.0f);
                    return;
                }
                rect0.top = ScreenUtils.dipToPixel(context0, 17.0f);
                return;
            }
            AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)((ArtistDetailAdapter)j00).getItem(v);
            if(adapterInViewHolder$Row0 != null && adapterInViewHolder$Row0.getItemViewType() == 0x20) {
                rect0.top = v == 2 ? ScreenUtils.dipToPixel(context0, 28.0f) : ScreenUtils.dipToPixel(context0, 20.0f);
            }
            AdapterInViewHolder.Row adapterInViewHolder$Row1 = (AdapterInViewHolder.Row)((ArtistDetailAdapter)j00).getItem(v);
            if(adapterInViewHolder$Row1 != null && adapterInViewHolder$Row1.getItemViewType() == 1004) {
                AdapterInViewHolder.Row adapterInViewHolder$Row2 = (AdapterInViewHolder.Row)((ArtistDetailAdapter)j00).getItem(v - 1);
                Integer integer0 = adapterInViewHolder$Row2 == null ? null : adapterInViewHolder$Row2.getItemViewType();
                if(integer0 != null && ((int)integer0) == 0x1F) {
                    rect0.top = ScreenUtils.dipToPixel(context0, 20.0f);
                    return;
                }
                rect0.top = ScreenUtils.dipToPixel(context0, 16.0f);
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0005H\u0007J\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u0014H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$Companion;", "", "<init>", "()V", "TAG", "", "CACHE_KEY_SUB_NAME", "ARG_AUTO_PLAY", "ARG_IS_COLLAPSED", "viewTypeCardRelay", "", "viewTypeRecommendTrack", "viewTypeSpotlight", "viewTypeForest", "viewTypeFanLounge", "viewTypeHiRising", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment;", "artistId", "isAutoPlay", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailHomeFragment newInstance(@NotNull String s) {
            q.g(s, "artistId");
            return this.newInstance(s, false);
        }

        @NotNull
        public final ArtistDetailHomeFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "artistId");
            ArtistDetailHomeFragment artistDetailHomeFragment0 = new ArtistDetailHomeFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            bundle0.putBoolean("argAutoPlay", z);
            artistDetailHomeFragment0.setArguments(bundle0);
            return artistDetailHomeFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001A\u00020\b2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment$PopupHandler;", "Lcom/iloen/melon/custom/U0;", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment;", "ref", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment;)V", "Landroid/os/Message;", "msg", "Lie/H;", "handleMessage", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailHomeFragment;Landroid/os/Message;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class PopupHandler extends U0 {
        public PopupHandler(@Nullable ArtistDetailHomeFragment artistDetailHomeFragment0) {
            super(artistDetailHomeFragment0);
        }

        public void handleMessage(@Nullable ArtistDetailHomeFragment artistDetailHomeFragment0, @NotNull Message message0) {
            q.g(message0, "msg");
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((ArtistDetailHomeFragment)object0), message0);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[BillionsClubGrade.values().length];
            try {
                arr_v[BillionsClubGrade.D.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[BillionsClubGrade.G.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[BillionsClubGrade.S.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_AUTO_PLAY = "argAutoPlay";
    @NotNull
    private static final String ARG_IS_COLLAPSED = "argIsCollapsed";
    @NotNull
    private static final String CACHE_KEY_SUB_NAME = "home";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistDetailHomeFragment";
    @NotNull
    private String artistId;
    @NotNull
    private String artistImageUrl;
    @NotNull
    private String artistName;
    @NotNull
    private String bbsChannelSeq;
    @NotNull
    private final BottomBtnData bottomBtnData;
    @Nullable
    private View bottomDivider;
    @Nullable
    private ArtistCardRelayRollingView cardRelayRollingView;
    private DetailAdapter detailAdapter;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    private boolean hasBillionsClubAlbum;
    private k headerBinding;
    private boolean isAutoPlay;
    private boolean isCollapsed;
    private boolean isConfettiShown;
    private boolean isOwnArtist;
    @Inject
    public mb.k loginUseCase;
    @NotNull
    private final PopupHandler popupHandler;
    private int songListHeaderPosition;
    @NotNull
    private final CoroutineExceptionHandler subExceptionHandler;
    @Nullable
    private F8.o titleItemBase;
    private static final int viewTypeCardRelay = 1000;
    private static final int viewTypeFanLounge = 1004;
    private static final int viewTypeForest = 1003;
    private static final int viewTypeHiRising = 1005;
    private static final int viewTypeRecommendTrack = 1001;
    private static final int viewTypeSpotlight = 1002;
    @Nullable
    private F8.o whiteFixedTitleItemBase;

    static {
        ArtistDetailHomeFragment.Companion = new Companion(null);
        ArtistDetailHomeFragment.$stable = 8;
    }

    public ArtistDetailHomeFragment() {
        this.artistId = "";
        this.artistName = "";
        this.artistImageUrl = "";
        this.bbsChannelSeq = "";
        this.popupHandler = new PopupHandler(this);
        this.exceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                LogU.Companion.e("ArtistDetailHomeFragment", "onFetchStart() error, exceptionHandler " + throwable0.getMessage());
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.exceptionHandler.1.1(throwable0, ArtistDetailHomeFragment.this, null), 3, null);
            }
        };
        this.subExceptionHandler = new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                Y.w("subExceptionHandler message = ", throwable0.getMessage(), LogU.Companion, "ArtistDetailHomeFragment");
            }
        };
        this.bottomBtnData = new BottomBtnData(0.0f, null, null, 7, null);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment$exceptionHandler$1$1", f = "ArtistDetailHomeFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.exceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.exceptionHandler.1.1(Throwable throwable0, ArtistDetailHomeFragment artistDetailHomeFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.exceptionHandler.1.1(this.$throwable, ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.exceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    ArtistDetailHomeFragment.access$getMResponseErrorListener$p$s-791051513(ArtistDetailHomeFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                    TitleBar titleBar0 = ArtistDetailHomeFragment.access$getTitleBar(ArtistDetailHomeFragment.this);
                    if(titleBar0 != null) {
                        titleBar0.setVisibility(8);
                    }
                    k k0 = ArtistDetailHomeFragment.access$getHeaderBinding$p(ArtistDetailHomeFragment.this);
                    if(k0 != null) {
                        k0.a.setVisibility(8);
                        return H.a;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s-791051513(ArtistDetailHomeFragment artistDetailHomeFragment0) {
        return artistDetailHomeFragment0.mResponseErrorListener;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        ArtistDetailAdapter artistDetailHomeFragment$ArtistDetailAdapter0 = new ArtistDetailAdapter(this, context0, null);
        this.detailAdapter = artistDetailHomeFragment$ArtistDetailAdapter0;
        artistDetailHomeFragment$ArtistDetailAdapter0.setMarkedMode(true);
        DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0 = this.detailAdapter;
        if(detailSongMetaContentBaseFragment$DetailAdapter0 != null) {
            detailSongMetaContentBaseFragment$DetailAdapter0.setListContentType(1);
            j0 j00 = this.detailAdapter;
            if(j00 != null) {
                return j00;
            }
            q.m("detailAdapter");
            throw null;
        }
        q.m("detailAdapter");
        throw null;
    }

    private final void deleteExcludedArtist() {
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.deleteExcludedArtist.1(ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.deleteExcludedArtist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ArtistDetailHomeFragment.this.showProgress(true);
                        this.label = 1;
                        object0 = F.a.d(ArtistDetailHomeFragment.this.artistId, this);
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
                boolean z = ArtistDetailHomeFragment.this.isFragmentValid();
                H h0 = H.a;
                if(!z) {
                    return h0;
                }
                ArtistDetailHomeFragment.this.showProgress(false);
                if(((z9.k)object0) instanceof j) {
                    ToastManager.show(0x7F130134);  // string:artist_detail_toast_delete_excluded_artist "해당 아티스트가 추천에 포함됩니다."
                    return h0;
                }
                if(!(((z9.k)object0) instanceof z9.i)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                ToastManager.show(((z9.i)(((z9.k)object0))).a);
                return h0;
            }
        }, 3, null);
    }

    private final void drawArtistPickLayout(ARTISTPICK artistHomeContentsRes$RESPONSE$ARTISTPICK0) {
        k k0 = this.headerBinding;
        if(k0 != null) {
            k0.f.setVisibility(0);
            k k1 = this.headerBinding;
            if(k1 != null) {
                k1.g.playAnimation();
                k k2 = this.headerBinding;
                if(k2 != null) {
                    int v = ScreenUtils.dipToPixel(this.getContext(), 48.0f);
                    ViewUtils.setDefaultImage(((ImageView)k2.h.c), v, true);
                    k k3 = this.headerBinding;
                    if(k3 != null) {
                        Glide.with(((BorderImageView)k3.h.d)).load(artistHomeContentsRes$RESPONSE$ARTISTPICK0.artistPickThumbUrl).apply(RequestOptions.circleCropTransform()).into(((BorderImageView)k3.h.d));
                        k k4 = this.headerBinding;
                        if(k4 != null) {
                            com.iloen.melon.fragments.artistchannel.j j0 = new com.iloen.melon.fragments.artistchannel.j(4, artistHomeContentsRes$RESPONSE$ARTISTPICK0, this);
                            k4.g.setOnClickListener(j0);
                            return;
                        }
                        q.m("headerBinding");
                        throw null;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
            q.m("headerBinding");
            throw null;
        }
        q.m("headerBinding");
        throw null;
    }

    private static final void drawArtistPickLayout$lambda$20(ARTISTPICK artistHomeContentsRes$RESPONSE$ARTISTPICK0, ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        String s = artistHomeContentsRes$RESPONSE$ARTISTPICK0.artistId;
        q.f(s, "artistId");
        Navigator.open(com.iloen.melon.fragments.artistchannel.ArtistPickFragment.Companion.newInstance$default(ArtistPickFragment.Companion, s, null, null, 6, null));
        f f0 = artistDetailHomeFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistDetailHomeFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistDetailHomeFragment0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
            f0.F = artistDetailHomeFragment0.getString(0x7F130CC7);  // string:tiara_artist_copy_artist_pick "아티스트픽"
            f0.a().track();
        }
    }

    private final void drawCreditLayout(CREDITINFO artistHomeContentsRes$RESPONSE$CREDITINFO0) {
        boolean z = artistHomeContentsRes$RESPONSE$CREDITINFO0.releaseSongCount > 0;
        boolean z1 = artistHomeContentsRes$RESPONSE$CREDITINFO0.featSongCount > 0;
        boolean z2 = artistHomeContentsRes$RESPONSE$CREDITINFO0.lyricCompoSongCount > 0;
        if(z || z1 || z2) {
            k k0 = this.headerBinding;
            if(k0 == null) {
                q.m("headerBinding");
                throw null;
            }
            k0.m.setVisibility(0);
            k k1 = this.headerBinding;
            if(k1 == null) {
                q.m("headerBinding");
                throw null;
            }
            y y0 = new y(this, 7);
            k1.m.setOnClickListener(y0);
            StringBuilder stringBuilder0 = new StringBuilder();
            if(z) {
                k k2 = this.headerBinding;
                if(k2 != null) {
                    String s = this.getString(0x7F130112);  // string:artist_channel_release "발매곡 %1$s"
                    q.f(s, "getString(...)");
                    l1.D(new Object[]{StringUtils.getFormattedStringNumber(artistHomeContentsRes$RESPONSE$CREDITINFO0.releaseSongCount)}, 1, s, k2.w);
                    k k3 = this.headerBinding;
                    if(k3 != null) {
                        stringBuilder0.append(k3.w.getText());
                        stringBuilder0.append(", ");
                        goto label_27;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
        label_27:
            if(z1) {
                if(z) {
                    k k4 = this.headerBinding;
                    if(k4 != null) {
                        k4.p.setVisibility(0);
                        goto label_35;
                    }
                    q.m("headerBinding");
                    throw null;
                }
            label_35:
                k k5 = this.headerBinding;
                if(k5 != null) {
                    String s1 = this.getString(0x7F130103);  // string:artist_channel_feat "참여 %1$s"
                    q.f(s1, "getString(...)");
                    l1.D(new Object[]{StringUtils.getFormattedStringNumber(artistHomeContentsRes$RESPONSE$CREDITINFO0.featSongCount)}, 1, s1, k5.r);
                    k k6 = this.headerBinding;
                    if(k6 != null) {
                        stringBuilder0.append(k6.r.getText());
                        stringBuilder0.append(", ");
                        goto label_49;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
        label_49:
            if(z2) {
                if(z || z1) {
                    k k7 = this.headerBinding;
                    if(k7 != null) {
                        k7.q.setVisibility(0);
                        goto label_57;
                    }
                    q.m("headerBinding");
                    throw null;
                }
            label_57:
                k k8 = this.headerBinding;
                if(k8 != null) {
                    String s2 = this.getString(0x7F13010C);  // string:artist_channel_lyric_compose "작사/작곡 %1$s"
                    q.f(s2, "getString(...)");
                    l1.D(new Object[]{StringUtils.getFormattedStringNumber(artistHomeContentsRes$RESPONSE$CREDITINFO0.lyricCompoSongCount)}, 1, s2, k8.v);
                    k k9 = this.headerBinding;
                    if(k9 != null) {
                        stringBuilder0.append(k9.v.getText());
                        stringBuilder0.append(", ");
                        goto label_71;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
        label_71:
            stringBuilder0.append(this.getString(0x7F1300FC));  // string:artist "아티스트"
            stringBuilder0.append(" ");
            stringBuilder0.append(this.getString(0x7F1302FF));  // string:detail_info_button "상세정보"
            stringBuilder0.append(" ");
            stringBuilder0.append(this.getString(0x7F130B8B));  // string:talkback_move "이동"
            k k10 = this.headerBinding;
            if(k10 == null) {
                q.m("headerBinding");
                throw null;
            }
            ViewUtils.setContentDescriptionWithButtonClassName(k10.m, stringBuilder0);
            if(z2) {
                k k11 = this.headerBinding;
                if(k11 != null) {
                    CharSequence charSequence0 = k11.v.getText();
                    k k12 = this.headerBinding;
                    if(k12 != null) {
                        String s3 = this.getString(0x7F130102);  // string:artist_channel_ellipsis "%1$s…"
                        q.f(s3, "getString(...)");
                        l1.D(new Object[]{charSequence0}, 1, s3, k12.v);
                        return;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
            if(z1) {
                k k13 = this.headerBinding;
                if(k13 != null) {
                    CharSequence charSequence1 = k13.r.getText();
                    k k14 = this.headerBinding;
                    if(k14 != null) {
                        String s4 = this.getString(0x7F130102);  // string:artist_channel_ellipsis "%1$s…"
                        q.f(s4, "getString(...)");
                        l1.D(new Object[]{charSequence1}, 1, s4, k14.r);
                        return;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
            if(z) {
                k k15 = this.headerBinding;
                if(k15 != null) {
                    CharSequence charSequence2 = k15.w.getText();
                    k k16 = this.headerBinding;
                    if(k16 != null) {
                        String s5 = this.getString(0x7F130102);  // string:artist_channel_ellipsis "%1$s…"
                        q.f(s5, "getString(...)");
                        l1.D(new Object[]{charSequence2}, 1, s5, k16.w);
                        return;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
        }
    }

    private static final void drawCreditLayout$lambda$22(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        Navigator.open(ArtistDetailDetailInfoFragment.Companion.newInstance(artistDetailHomeFragment0.artistId, artistDetailHomeFragment0.artistName));
        f f0 = artistDetailHomeFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistDetailHomeFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistDetailHomeFragment0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
            f0.F = artistDetailHomeFragment0.getString(0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
            f0.a().track();
        }
    }

    private final void drawHeaderView(com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0) {
        int v;
        String s6;
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(0);
        }
        k k0 = this.headerBinding;
        if(k0 != null) {
            k0.a.setVisibility(0);
            k k1 = this.headerBinding;
            if(k1 != null) {
                Glide.with(k1.l).load(artistHomeBasicInfoRes$RESPONSE0.artistImgLarge).into(new CustomTarget() {
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    public void onResourceReady(Drawable drawable0, Transition transition0) {
                        q.g(drawable0, "resource");
                        this.setImageDrawable(drawable0);
                        k k0 = ArtistDetailHomeFragment.this.headerBinding;
                        if(k0 != null) {
                            k0.o.setVisibility(0);
                            return;
                        }
                        q.m("headerBinding");
                        throw null;
                    }

                    @Override  // com.bumptech.glide.request.target.Target
                    public void onResourceReady(Object object0, Transition transition0) {
                        this.onResourceReady(((Drawable)object0), transition0);
                    }
                });
                k1.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if(!TextUtils.isEmpty(artistHomeBasicInfoRes$RESPONSE0.artistImgLarge)) {
                    k k2 = this.headerBinding;
                    if(k2 != null) {
                        w w0 = new w(this, artistHomeBasicInfoRes$RESPONSE0);
                        k2.l.setOnClickListener(w0);
                        String s = this.getString(0x7F130AD3);  // string:talkback_artist_photo_move "%1$s, 포토 이동"
                        q.f(s, "getString(...)");
                        String s1 = String.format(s, Arrays.copyOf(new Object[]{this.artistName}, 1));
                        k2.l.setContentDescription(s1);
                        goto label_22;
                    }
                    q.m("headerBinding");
                    throw null;
                }
            label_22:
                k k3 = this.headerBinding;
                if(k3 != null) {
                    ViewUtils.setText(k3.i, this.artistName);
                    k k4 = this.headerBinding;
                    if(k4 != null) {
                        y y0 = new y(this, 8);
                        k4.y.setOnClickListener(y0);
                        if(this.isLoginUser()) {
                            this.fetchFanAndTemperatureInfo(this.artistId);
                        }
                        else {
                            k k5 = this.headerBinding;
                            if(k5 != null) {
                                k5.y.setVisibility(0);
                                k k6 = this.headerBinding;
                                if(k6 != null) {
                                    k6.z.setText("0");
                                    k k7 = this.headerBinding;
                                    if(k7 != null) {
                                        k7.n.setImageResource(0x7F080871);  // drawable:shape_circle_stroke_2dp_gray450s_8dp
                                        k k8 = this.headerBinding;
                                        if(k8 != null) {
                                            ConstraintLayout constraintLayout0 = k8.y;
                                            String s2 = this.getString(0x7F130C6D);  // string:talkback_temperature_degree "친밀도 %1$s도"
                                            q.f(s2, "getString(...)");
                                            k k9 = this.headerBinding;
                                            if(k9 != null) {
                                                ViewUtils.setContentDescriptionWithButtonClassName(constraintLayout0, x.l(String.format(s2, Arrays.copyOf(new Object[]{k9.z.getText()}, 1)), ", ", this.getString(0x7F130176), " ", this.getString(0x7F130B8B)));  // string:artist_temperature_title "나와의 친밀도"
                                                goto label_59;
                                            }
                                            q.m("headerBinding");
                                            throw null;
                                        }
                                        q.m("headerBinding");
                                        throw null;
                                    }
                                    q.m("headerBinding");
                                    throw null;
                                }
                                q.m("headerBinding");
                                throw null;
                            }
                            q.m("headerBinding");
                            throw null;
                        }
                    label_59:
                        if((artistHomeBasicInfoRes$RESPONSE0.fanAnniversaryInfo == null ? null : artistHomeBasicInfoRes$RESPONSE0.fanAnniversaryInfo.day) != null) {
                            k k10 = this.headerBinding;
                            if(k10 == null) {
                                q.m("headerBinding");
                                throw null;
                            }
                            k10.c.setVisibility(0);
                            k k11 = this.headerBinding;
                            if(k11 == null) {
                                q.m("headerBinding");
                                throw null;
                            }
                            MelonTextView melonTextView0 = k11.d;
                            String s3 = artistHomeBasicInfoRes$RESPONSE0.fanAnniversaryInfo.day;
                            String s4 = "";
                            if(s3 == null) {
                                s3 = "";
                            }
                            melonTextView0.setText(s3);
                            k k12 = this.headerBinding;
                            if(k12 == null) {
                                q.m("headerBinding");
                                throw null;
                            }
                            MelonTextView melonTextView1 = k12.e;
                            String s5 = artistHomeBasicInfoRes$RESPONSE0.fanAnniversaryInfo.text;
                            if(s5 != null) {
                                s4 = s5;
                            }
                            melonTextView1.setText(s4);
                            if(!this.isConfettiShown) {
                                k k13 = this.headerBinding;
                                if(k13 != null) {
                                    k13.b.setVisibility(0);
                                    com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.drawHeaderView.4.1 artistDetailHomeFragment$drawHeaderView$4$10 = (com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.drawHeaderView.4.1)Glide.with(k13.b).load(0x7F0800A2).into(new CustomTarget() {  // drawable:artist_channel_confetti_900kb
                                        @Override  // com.bumptech.glide.request.target.Target
                                        public void onLoadCleared(Drawable drawable0) {
                                        }

                                        public void onResourceReady(Drawable drawable0, Transition transition0) {
                                            q.g(drawable0, "resource");
                                            this.$it.setImageDrawable(drawable0);
                                            if(drawable0 instanceof WebpDrawable) {
                                                ((WebpDrawable)drawable0).setLoopCount(1);
                                                ((WebpDrawable)drawable0).start();
                                            }
                                        }

                                        @Override  // com.bumptech.glide.request.target.Target
                                        public void onResourceReady(Object object0, Transition transition0) {
                                            this.onResourceReady(((Drawable)object0), transition0);
                                        }
                                    });
                                    this.isConfettiShown = true;
                                    goto label_93;
                                }
                                q.m("headerBinding");
                                throw null;
                            }
                        }
                    label_93:
                        if(this.isAutoPlay) {
                            this.playTitleSong(artistHomeBasicInfoRes$RESPONSE0);
                        }
                        BILLIONSCLUBINFO artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO0 = artistHomeBasicInfoRes$RESPONSE0.billionsClubInfo;
                        if(artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO0 == null) {
                            s6 = null;
                        }
                        else {
                            LinkInfoBase linkInfoBase0 = artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO0.linkInfo;
                            s6 = linkInfoBase0 == null ? null : linkInfoBase0.linkurl;
                        }
                        if(s6 != null && s6.length() != 0) {
                            k k14 = this.headerBinding;
                            if(k14 != null) {
                                ImageView imageView0 = k14.j;
                                BillionsClubGrade artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO$BillionsClubGrade0 = artistHomeBasicInfoRes$RESPONSE0.billionsClubInfo == null ? null : artistHomeBasicInfoRes$RESPONSE0.billionsClubInfo.billionsClubGrade;
                                switch((artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO$BillionsClubGrade0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO$BillionsClubGrade0.ordinal()])) {
                                    case 1: {
                                        v = 0x7F0800A7;  // drawable:badge_billions_dia_30
                                        break;
                                    }
                                    case 2: {
                                        v = 0x7F0800A8;  // drawable:badge_billions_gold_30
                                        break;
                                    }
                                    case 3: {
                                        v = 0x7F0800A9;  // drawable:badge_billions_silver_30
                                        break;
                                    }
                                    default: {
                                        v = 0x7F0800A6;  // drawable:badge_billions_bronze_30
                                    }
                                }
                                imageView0.setImageResource(v);
                                k k15 = this.headerBinding;
                                if(k15 != null) {
                                    k15.k.setVisibility(0);
                                    w w1 = new w(artistHomeBasicInfoRes$RESPONSE0, this);
                                    k15.k.setOnClickListener(w1);
                                    goto label_128;
                                }
                                q.m("headerBinding");
                                throw null;
                            }
                            q.m("headerBinding");
                            throw null;
                        }
                    label_128:
                        Configuration configuration0 = this.requireContext().getResources().getConfiguration();
                        q.f(configuration0, "getConfiguration(...)");
                        this.updateLayoutMargin(configuration0);
                        return;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
            q.m("headerBinding");
            throw null;
        }
        q.m("headerBinding");
        throw null;
    }

    private static final void drawHeaderView$lambda$13$lambda$12(ArtistDetailHomeFragment artistDetailHomeFragment0, com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0, View view0) {
        Navigator.INSTANCE.openArtistImageWithPhoto(artistDetailHomeFragment0.artistId, "", artistHomeBasicInfoRes$RESPONSE0.artistImgLarge);
    }

    private static final void drawHeaderView$lambda$14(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        if(!artistDetailHomeFragment0.isLoginUser()) {
            artistDetailHomeFragment0.showLoginPopup();
            return;
        }
        Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(artistDetailHomeFragment0.artistId));
        String s = artistDetailHomeFragment0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
        q.f(s, "getString(...)");
        artistDetailHomeFragment0.sendTiaraTemperature(s);
    }

    private static final void drawHeaderView$lambda$17$lambda$16(com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0, ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b((artistHomeBasicInfoRes$RESPONSE0.billionsClubInfo == null ? null : artistHomeBasicInfoRes$RESPONSE0.billionsClubInfo.linkInfo)));
        String s = artistDetailHomeFragment0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
        q.f(s, "getString(...)");
        artistDetailHomeFragment0.sendTiaraBillionsClub(s);
    }

    private final void fetchFanAndTemperatureInfo(String s) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.getCoroutineContext()), null, null, new n(s, null) {
            final String $artistId;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                this.$artistId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.fetchFanAndTemperatureInfo.1(ArtistDetailHomeFragment.this, this.$artistId, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.fetchFanAndTemperatureInfo.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ArrayList arrayList1;
                UserActionsRes userActionsRes1;
                Deferred deferred3;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred2 = ArtistDetailHomeFragment.this.requestUserActionsAsync(coroutineScope0, this.$artistId);
                        deferred3 = ArtistDetailHomeFragment.this.requestTemperatureScoreNoticeAsync(coroutineScope0, this.$artistId);
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
                        this.L$3 = (UserActionsRes)object0;
                        this.label = 2;
                        Object object1 = deferred3.await(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        userActionsRes1 = (UserActionsRes)object0;
                        object0 = object1;
                        break;
                    }
                    case 2: {
                        userActionsRes1 = (UserActionsRes)this.L$3;
                        Deferred deferred5 = (Deferred)this.L$2;
                        Deferred deferred6 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        break;
                    }
                    case 3: {
                        ArrayList arrayList0 = (ArrayList)this.L$5;
                        ArtistTemperatureScoreNoticeRes artistTemperatureScoreNoticeRes0 = (ArtistTemperatureScoreNoticeRes)this.L$4;
                        UserActionsRes userActionsRes0 = (UserActionsRes)this.L$3;
                        Deferred deferred0 = (Deferred)this.L$2;
                        Deferred deferred1 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(!ArtistDetailHomeFragment.this.isFragmentValid() || userActionsRes1 == null) {
                    arrayList1 = null;
                }
                else {
                    Cb.j.b(userActionsRes1.notification, false, 2);
                    if(Cb.j.d(userActionsRes1)) {
                        Response userActionsRes$Response0 = userActionsRes1.response;
                        arrayList1 = userActionsRes$Response0 == null ? null : userActionsRes$Response0.relationList;
                    }
                    else {
                        arrayList1 = null;
                    }
                }
                com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.fetchFanAndTemperatureInfo.1.1 artistDetailHomeFragment$fetchFanAndTemperatureInfo$1$10 = new n(arrayList1, ((ArtistTemperatureScoreNoticeRes)object0), null) {
                    final ArrayList $relList;
                    final ArtistTemperatureScoreNoticeRes $temperatureScoreNoticeRes;
                    int label;

                    {
                        ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                        this.$relList = arrayList0;
                        this.$temperatureScoreNoticeRes = artistTemperatureScoreNoticeRes0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.fetchFanAndTemperatureInfo.1.1(ArtistDetailHomeFragment.this, this.$relList, this.$temperatureScoreNoticeRes, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.fetchFanAndTemperatureInfo.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        ArtistDetailHomeFragment.this.updateFanAndTemperatureUi(this.$relList, (this.$temperatureScoreNoticeRes == null ? null : this.$temperatureScoreNoticeRes.response));
                        return H.a;
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.label = 3;
                return BuildersKt.withContext(Dispatchers.getMain(), artistDetailHomeFragment$fetchFanAndTemperatureInfo$1$10, this) == a0 ? a0 : H.a;
            }
        }, 3, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public BottomBtnData getBottomBtnData() {
        return this.bottomBtnData;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.b.buildUpon().appendPath("home"), this.artistId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public int getCommentAdapterPosition() {
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
        return ((ArtistDetailAdapter)j00).getCommentPosition();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsId() {
        return this.artistId;
    }

    // 去混淆评级： 低(30)
    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsTypeCode() {
        q.f("N10006", "code(...)");
        return "N10006";
    }

    @Override  // com.iloen.melon.fragments.artistchannel.Hilt_ArtistDetailHomeFragment
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
    }

    @NotNull
    public final mb.k getLoginUseCase() {
        mb.k k0 = this.loginUseCase;
        if(k0 != null) {
            return k0;
        }
        q.m("loginUseCase");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public OnViewHolderActionListener getOnViewHolderActionListener() {
        return new OnViewHolderActionListener() {
            public static H a(com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.getOnViewHolderActionListener.1 artistDetailHomeFragment$getOnViewHolderActionListener$10, String s) {
                return com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.getOnViewHolderActionListener.1.onRequestFanListener$lambda$0(artistDetailHomeFragment$getOnViewHolderActionListener$10, s);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public boolean onCheckLoginListener() {
                if(!ArtistDetailHomeFragment.this.isLoginUser()) {
                    ArtistDetailHomeFragment.this.showLoginPopup();
                    return false;
                }
                return true;
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onItemLikeListener(String s, String s1, boolean z, int v) {
                q.g(s, "contsId");
                q.g(s1, "contsTypeCode");
                String s2 = ArtistDetailHomeFragment.this.getMenuId();
                com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.getOnViewHolderActionListener.1.onItemLikeListener.1 artistDetailHomeFragment$getOnViewHolderActionListener$1$onItemLikeListener$10 = new OnJobFinishListener() {
                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onJobComplete(String s, int v, boolean z) {
                        q.g(s, "errorMsg");
                        if(o.H0(s) && s1.isFragmentValid()) {
                            j0 j00 = s1.getAdapter();
                            ArtistTopicHolder artistTopicHolder0 = null;
                            ArtistDetailAdapter artistDetailHomeFragment$ArtistDetailAdapter0 = j00 instanceof ArtistDetailAdapter ? ((ArtistDetailAdapter)j00) : null;
                            if(artistDetailHomeFragment$ArtistDetailAdapter0 != null) {
                                int v1 = this.$itemPosition;
                                ArtistDetailHomeFragment artistDetailHomeFragment0 = s1;
                                if(q.b(v, "N10098")) {
                                    com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE0 = artistDetailHomeFragment$ArtistDetailAdapter0.getContentsRes();
                                    if(artistHomeContentsRes$RESPONSE0 != null) {
                                        List list0 = artistHomeContentsRes$RESPONSE0.topicList;
                                        if(list0 != null) {
                                            TOPICLIST artistHomeContentsRes$RESPONSE$TOPICLIST0 = (TOPICLIST)p.n0(v1, list0);
                                            if(artistHomeContentsRes$RESPONSE$TOPICLIST0 != null) {
                                                artistHomeContentsRes$RESPONSE$TOPICLIST0.isLike = z;
                                                artistHomeContentsRes$RESPONSE$TOPICLIST0.likeCnt = String.valueOf(v);
                                                int v2 = artistDetailHomeFragment$ArtistDetailAdapter0.getItemCount();
                                                for(int v3 = 0; v3 < v2; ++v3) {
                                                    if(53 == artistDetailHomeFragment$ArtistDetailAdapter0.getItemViewType(v3)) {
                                                        O0 o00 = artistDetailHomeFragment0.getRecyclerView().findViewHolderForAdapterPosition(v3);
                                                        if(o00 instanceof ArtistTopicHolder) {
                                                            artistTopicHolder0 = (ArtistTopicHolder)o00;
                                                        }
                                                        if(artistTopicHolder0 == null) {
                                                            break;
                                                        }
                                                        artistTopicHolder0.updateItem(v1);
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onStartAsyncTask() {
                    }
                };
                ArtistDetailHomeFragment.this.updateLike(s, s1, z, s2, artistDetailHomeFragment$getOnViewHolderActionListener$1$onItemLikeListener$10);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onPlayArtistMixUp() {
                String s = ArtistDetailHomeFragment.this.getMenuId();
                I0 i00 = new I0(ArtistDetailHomeFragment.this.artistId, ArtistDetailHomeFragment.this.artistName, ArtistDetailHomeFragment.this.getStatsElements());
                ArtistDetailHomeFragment.this.playMixUp(s, i00);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onPlaySongsListener(ArrayList arrayList0, boolean z) {
                q.g(arrayList0, "playableList");
                ArtistDetailHomeFragment.this.playSongs(arrayList0, z);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onRequestFanListener(String s, boolean z) {
                q.g(s, "artistId");
                if(z) {
                    if(!ArtistDetailHomeFragment.this.isLoginUser()) {
                        ArtistDetailHomeFragment.this.showLoginPopup();
                        return;
                    }
                    if(!NetUtils.isConnected()) {
                        ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                        return;
                    }
                    this.updateFan(s, true);
                    return;
                }
                if(!NetUtils.isConnected()) {
                    ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                    return;
                }
                b.x(ArtistDetailHomeFragment.this.getChildFragmentManager(), ArtistDetailHomeFragment.this.getString(0x7F1300D0), ArtistDetailHomeFragment.this.getString(0x7F130137), false, false, null, null, new A(this, s, 0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
            }

            private static final H onRequestFanListener$lambda$0(com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.getOnViewHolderActionListener.1 artistDetailHomeFragment$getOnViewHolderActionListener$10, String s) {
                artistDetailHomeFragment$getOnViewHolderActionListener$10.updateFan(s, false);
                return H.a;
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onShowSharePopupListener() {
                Sharable sharable0 = ArtistDetailHomeFragment.this.getSNSSharable();
                ArtistDetailHomeFragment.this.showSNSListPopup(sharable0);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public f onTiaraEventBuilder() {
                return ArtistDetailHomeFragment.this.getTiaraEventBuilder();
            }

            private final void updateFan(String s, boolean z) {
                String s1 = ArtistDetailHomeFragment.this.getMenuId();
                com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.getOnViewHolderActionListener.1.updateFan.1 artistDetailHomeFragment$getOnViewHolderActionListener$1$updateFan$10 = new OnJobFinishListener() {
                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onJobComplete(String s, int v, boolean z) {
                        q.g(s, "errorMsg");
                        if(!z.isFragmentValid()) {
                            return;
                        }
                        if(s.length() > 0) {
                            return;
                        }
                        if(s) {
                            z.showRecommendContentsPopup(this.$artistId, "A");
                            O.a(new UaLogDummyReq(z.getContext(), "recmChnlFanPopup"));
                        }
                        j0 j00 = z.getAdapter();
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
                        HttpResponse httpResponse0 = ((ArtistDetailAdapter)j00).getResponse();
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes");
                        ((ArtistHomeBasicInfoRes)httpResponse0).response.fanYN = s ? "Y" : "N";
                        ((ArtistHomeBasicInfoRes)httpResponse0).response.fanCnt = String.valueOf(v);
                        j0 j01 = z.getAdapter();
                        q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
                        ((ArtistDetailAdapter)j01).updateFanCmtShareHolder();
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onStartAsyncTask() {
                    }
                };
                ArtistDetailHomeFragment.this.updateFan(s, "N10006", z, s1, artistDetailHomeFragment$getOnViewHolderActionListener$1$updateFan$10);
            }
        };
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
        ArtistHomeBasicInfoRes artistHomeBasicInfoRes0 = (ArtistHomeBasicInfoRes)((ArtistDetailAdapter)j00).getResponse();
        com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0 = artistHomeBasicInfoRes0 == null ? null : artistHomeBasicInfoRes0.response;
        if(artistHomeBasicInfoRes$RESPONSE0 == null) {
            LogU.Companion.e("ArtistDetailHomeFragment", "getSNSSharable() >> mBasicInfoRes is null");
            return null;
        }
        H8.q q0 = new H8.q();  // 初始化器: Ljava/lang/Object;-><init>()V
        q0.b = artistHomeBasicInfoRes$RESPONSE0.artistName;
        q0.a = artistHomeBasicInfoRes$RESPONSE0.artistId;
        q0.g = "";
        q0.d = StringUtils.getCountString(artistHomeBasicInfoRes$RESPONSE0.fanCnt, 0x98967F);
        q0.e = artistHomeBasicInfoRes$RESPONSE0.postImg;
        q0.f = artistHomeBasicInfoRes$RESPONSE0.postEditImg;
        return new SharableArtist(q0);
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

    private final void insertExcludedArtist() {
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.insertExcludedArtist.1(ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.insertExcludedArtist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        object0 = F.a.f(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_10;
                    }
                    case 1: {
                        d5.n.D(object0);
                    label_10:
                        if(((Number)object0).intValue() >= 100) {
                            ToastManager.show(0x7F130962);  // string:setting_banned_contents_artist_limit "100명까지 제외 가능합니다. 제외한 아티스트 삭제 후 시도해주세요."
                            return h0;
                        }
                        ArtistDetailHomeFragment.this.showProgress(true);
                        this.label = 2;
                        object0 = F.q(1001, ArtistDetailHomeFragment.this.artistId, null, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_19;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                d5.n.D(object0);
            label_19:
                if(!ArtistDetailHomeFragment.this.isFragmentValid()) {
                    return h0;
                }
                ArtistDetailHomeFragment.this.showProgress(false);
                if(((z9.k)object0) instanceof j) {
                    ToastManager.show(0x7F130135);  // string:artist_detail_toast_insert_excluded_artist "해당 아티스트가 추천에서 제외되었습니다."
                    return h0;
                }
                if(!(((z9.k)object0) instanceof z9.i)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                ToastManager.show(((z9.i)(((z9.k)object0))).a);
                return h0;
            }
        }, 3, null);
    }

    public final boolean isFan() {
        j0 j00 = this.getAdapter();
        String s = null;
        ArtistDetailAdapter artistDetailHomeFragment$ArtistDetailAdapter0 = j00 instanceof ArtistDetailAdapter ? ((ArtistDetailAdapter)j00) : null;
        HttpResponse httpResponse0 = artistDetailHomeFragment$ArtistDetailAdapter0 == null ? null : artistDetailHomeFragment$ArtistDetailAdapter0.getResponse();
        ArtistHomeBasicInfoRes artistHomeBasicInfoRes0 = httpResponse0 instanceof ArtistHomeBasicInfoRes ? ((ArtistHomeBasicInfoRes)httpResponse0) : null;
        if(artistHomeBasicInfoRes0 != null) {
            com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0 = artistHomeBasicInfoRes0.response;
            if(artistHomeBasicInfoRes$RESPONSE0 != null) {
                s = artistHomeBasicInfoRes$RESPONSE0.fanYN;
            }
        }
        return ProtocolUtils.parseBoolean(s);
    }

    @NotNull
    public static final ArtistDetailHomeFragment newInstance(@NotNull String s) {
        return ArtistDetailHomeFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final ArtistDetailHomeFragment newInstance(@NotNull String s, boolean z) {
        return ArtistDetailHomeFragment.Companion.newInstance(s, z);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarCollapsed() {
        this.isCollapsed = true;
        if(!ScreenUtils.isDarkMode(this.getContext())) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            ScreenUtils.setAppearanceLightStatusBars((fragmentActivity0 == null ? null : fragmentActivity0.getWindow()), true);
            if(this.titleItemBase != null) {
                TitleBar titleBar0 = this.getTitleBar();
                if(titleBar0 != null) {
                    F8.o o0 = this.titleItemBase;
                    q.d(o0);
                    titleBar0.a(o0);
                }
            }
        }
        TitleBar titleBar1 = this.getTitleBar();
        if(titleBar1 != null) {
            titleBar1.setTitle(this.artistName);
        }
        View view0 = this.bottomDivider;
        if(view0 != null) {
            view0.setVisibility(0);
        }
        FrameLayout frameLayout0 = this.getDetailHeader();
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(4);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarExpended() {
        this.isCollapsed = false;
        if(!ScreenUtils.isDarkMode(this.getContext())) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            ScreenUtils.setAppearanceLightStatusBars((fragmentActivity0 == null ? null : fragmentActivity0.getWindow()), false);
            if(this.whiteFixedTitleItemBase != null) {
                TitleBar titleBar0 = this.getTitleBar();
                if(titleBar0 != null) {
                    F8.o o0 = this.whiteFixedTitleItemBase;
                    q.d(o0);
                    titleBar0.a(o0);
                }
            }
        }
        TitleBar titleBar1 = this.getTitleBar();
        if(titleBar1 != null) {
            titleBar1.setTitle("");
        }
        View view0 = this.bottomDivider;
        if(view0 != null) {
            view0.setVisibility(8);
        }
        FrameLayout frameLayout0 = this.getDetailHeader();
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(0);
        }
        k k0 = this.headerBinding;
        if(k0 != null) {
            k0.a.setAlpha(1.0f);
            return;
        }
        q.m("headerBinding");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarScrolling(int v) {
        float f3;
        float f = (float)Math.abs(v);
        k k0 = this.headerBinding;
        if(k0 != null) {
            int v1 = k0.a.getHeight();
            int v2 = ScreenUtils.dipToPixel(this.getContext(), 77.0f);
            int v3 = ScreenUtils.getStatusBarHeight(this.getContext());
            int v4 = this.getCollapseToolbarHeight();
            int v5 = ScreenUtils.getStatusBarHeight(this.getContext());
            float f1 = (float)(v1 - v2 - v3);
            float f2 = 0.0f;
            if(Float.compare(f, f1) >= 0) {
                f3 = (f - f1) / ((float)(v5 + v4));
                if(f3 > 1.0f) {
                    f3 = 1.0f;
                }
                if(f3 < 0.0f) {
                    f3 = 0.0f;
                }
            }
            else {
                f3 = 0.0f;
            }
            float f4 = 1.0f - f3 * 5.0f;
            if(f4 >= 0.0f) {
                f2 = f4;
            }
            k k1 = this.headerBinding;
            if(k1 != null) {
                k1.a.setAlpha(f2);
                return;
            }
            q.m("headerBinding");
            throw null;
        }
        q.m("headerBinding");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        if(ScreenUtils.isTablet(this.getContext())) {
            return;
        }
        this.updateLayoutMargin(configuration0);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0039, null, false);  // layout:artist_detail_header
        int v = 0x7F0A00A3;  // id:anniversary_iv
        View view1 = I.C(view0, 0x7F0A00A3);  // id:anniversary_iv
        if(((ImageView)view1) != null) {
            v = 0x7F0A00A4;  // id:anniversary_layout
            View view2 = I.C(view0, 0x7F0A00A4);  // id:anniversary_layout
            if(((LinearLayout)view2) != null) {
                v = 0x7F0A00A5;  // id:anniversary_number_tv
                View view3 = I.C(view0, 0x7F0A00A5);  // id:anniversary_number_tv
                if(((MelonTextView)view3) != null) {
                    v = 0x7F0A00A6;  // id:anniversary_unit_tv
                    View view4 = I.C(view0, 0x7F0A00A6);  // id:anniversary_unit_tv
                    if(((MelonTextView)view4) != null) {
                        v = 0x7F0A00BB;  // id:artist_pick_layout
                        View view5 = I.C(view0, 0x7F0A00BB);  // id:artist_pick_layout
                        if(((FrameLayout)view5) != null) {
                            v = 0x7F0A00BC;  // id:artist_pick_lottie
                            View view6 = I.C(view0, 0x7F0A00BC);  // id:artist_pick_lottie
                            if(((LottieAnimationView)view6) != null) {
                                v = 0x7F0A00BD;  // id:artist_pick_thumbnail
                                View view7 = I.C(view0, 0x7F0A00BD);  // id:artist_pick_thumbnail
                                if(view7 != null) {
                                    J8.x x0 = J8.x.b(view7);
                                    v = 0x7F0A00C2;  // id:artist_tv
                                    View view8 = I.C(view0, 0x7F0A00C2);  // id:artist_tv
                                    if(((MelonTextView)view8) != null) {
                                        v = 0x7F0A0108;  // id:billions_club_badge
                                        View view9 = I.C(view0, 0x7F0A0108);  // id:billions_club_badge
                                        if(((ImageView)view9) != null) {
                                            v = 0x7F0A0109;  // id:billions_club_layout
                                            View view10 = I.C(view0, 0x7F0A0109);  // id:billions_club_layout
                                            if(((LinearLayout)view10) != null) {
                                                v = 0x7F0A0353;  // id:cover_iv
                                                View view11 = I.C(view0, 0x7F0A0353);  // id:cover_iv
                                                if(((MelonImageView)view11) != null && ((ImageView)I.C(view0, 0x7F0A0360)) != null) {  // id:credit_arrow_iv
                                                    v = 0x7F0A0363;  // id:credit_layout
                                                    View view12 = I.C(view0, 0x7F0A0363);  // id:credit_layout
                                                    if(((LinearLayout)view12) != null) {
                                                        v = 0x7F0A039B;  // id:degree_iv
                                                        View view13 = I.C(view0, 0x7F0A039B);  // id:degree_iv
                                                        if(((ImageView)view13) != null) {
                                                            v = 0x7F0A03C6;  // id:dim_iv
                                                            View view14 = I.C(view0, 0x7F0A03C6);  // id:dim_iv
                                                            if(((ImageView)view14) != null) {
                                                                v = 0x7F0A03D2;  // id:divide_point_1
                                                                View view15 = I.C(view0, 0x7F0A03D2);  // id:divide_point_1
                                                                if(((ImageView)view15) != null) {
                                                                    v = 0x7F0A03D3;  // id:divide_point_2
                                                                    View view16 = I.C(view0, 0x7F0A03D3);  // id:divide_point_2
                                                                    if(((ImageView)view16) != null) {
                                                                        v = 0x7F0A0492;  // id:feat_tv
                                                                        View view17 = I.C(view0, 0x7F0A0492);  // id:feat_tv
                                                                        if(((MelonTextView)view17) != null) {
                                                                            v = 0x7F0A04E9;  // id:gap_tv
                                                                            View view18 = I.C(view0, 0x7F0A04E9);  // id:gap_tv
                                                                            if(((MelonTextView)view18) != null) {
                                                                                v = 0x7F0A04F6;  // id:gradation
                                                                                View view19 = I.C(view0, 0x7F0A04F6);  // id:gradation
                                                                                if(view19 != null) {
                                                                                    View view20 = I.C(view19, 0x7F0A04F8);  // id:gradient_artist_header_fifth
                                                                                    if(view20 == null || ((Guideline)I.C(view19, 0x7F0A090C)) == null || (((Guideline)I.C(view19, 0x7F0A090D)) == null || ((Guideline)I.C(view19, 0x7F0A090E)) == null) || ((Guideline)I.C(view19, 0x7F0A090F)) == null) {  // id:percent_14_guideline
                                                                                        throw new NullPointerException("Missing required view with ID: " + view19.getResources().getResourceName(0x7F0A04F8));  // id:gradient_artist_header_fifth
                                                                                    }
                                                                                    J8.b b0 = new J8.b(((ConstraintLayout)view19), view20, 1);
                                                                                    int v1 = 0x7F0A0523;  // id:half_guideline
                                                                                    if(((Guideline)I.C(view0, 0x7F0A0523)) != null) {  // id:half_guideline
                                                                                        v1 = 0x7F0A0579;  // id:info_layout
                                                                                        View view21 = I.C(view0, 0x7F0A0579);  // id:info_layout
                                                                                        if(((LinearLayout)view21) != null) {
                                                                                            v1 = 0x7F0A07BA;  // id:lyric_compose_tv
                                                                                            View view22 = I.C(view0, 0x7F0A07BA);  // id:lyric_compose_tv
                                                                                            if(((MelonTextView)view22) != null) {
                                                                                                v1 = 0x7F0A09E1;  // id:release_tv
                                                                                                View view23 = I.C(view0, 0x7F0A09E1);  // id:release_tv
                                                                                                if(((MelonTextView)view23) != null) {
                                                                                                    v1 = 0x7F0A0B41;  // id:temperature_arrow_iv
                                                                                                    View view24 = I.C(view0, 0x7F0A0B41);  // id:temperature_arrow_iv
                                                                                                    if(((ImageView)view24) != null) {
                                                                                                        v1 = 0x7F0A0B46;  // id:temperature_layout
                                                                                                        View view25 = I.C(view0, 0x7F0A0B46);  // id:temperature_layout
                                                                                                        if(((ConstraintLayout)view25) != null) {
                                                                                                            v1 = 0x7F0A0B47;  // id:temperature_tv
                                                                                                            View view26 = I.C(view0, 0x7F0A0B47);  // id:temperature_tv
                                                                                                            if(((MelonTextView)view26) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0B85)) != null) {  // id:thumbnail_layout
                                                                                                                return new k(((ConstraintLayout)view0), ((ImageView)view1), ((LinearLayout)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((FrameLayout)view5), ((LottieAnimationView)view6), x0, ((MelonTextView)view8), ((ImageView)view9), ((LinearLayout)view10), ((MelonImageView)view11), ((LinearLayout)view12), ((ImageView)view13), ((ImageView)view14), ((ImageView)view15), ((ImageView)view16), ((MelonTextView)view17), ((MelonTextView)view18), b0, ((LinearLayout)view21), ((MelonTextView)view22), ((MelonTextView)view23), ((ImageView)view24), ((ConstraintLayout)view25), ((MelonTextView)view26));
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    v = v1;
                                                                                    throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = super.onCreateRecyclerView();
        if(recyclerView0 != null) {
            recyclerView0.addItemDecoration(new ArtistItemDecoration());
            return recyclerView0;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.getCoroutineContext()), completableJob0.plus(this.exceptionHandler), null, new n(completableJob0, null) {
            final CompletableJob $supervisor;
            int I$0;
            private Object L$0;
            Object L$1;
            Object L$10;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                this.$supervisor = completableJob0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1(ArtistDetailHomeFragment.this, this.$supervisor, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                List list1;
                ArtistHomeContentsRes artistHomeContentsRes2;
                ArtistHomeBasicInfoRes artistHomeBasicInfoRes3;
                ArtistHomeContentsRes artistHomeContentsRes1;
                ArtistHomeBasicInfoRes artistHomeBasicInfoRes2;
                Object object4;
                Object object3;
                ArtistHomeBasicInfoRes artistHomeBasicInfoRes1;
                Deferred deferred12;
                Object object2;
                Deferred deferred9;
                Deferred deferred8;
                Object object1;
                Deferred deferred7;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred4 = ArtistDetailHomeFragment.this.requestBannerInfoAsync(coroutineScope0);
                        Deferred deferred5 = ArtistDetailHomeFragment.this.requestContentsAsync(coroutineScope0);
                        Deferred deferred6 = ArtistDetailHomeFragment.this.requestBasicInfoAsync(coroutineScope0);
                        deferred7 = ArtistDetailHomeFragment.this.requestSummaryAsync(coroutineScope0);
                        this.L$0 = coroutineScope0;
                        this.L$1 = null;
                        this.L$2 = deferred5;
                        this.L$3 = deferred6;
                        this.L$4 = deferred7;
                        this.label = 1;
                        object1 = deferred4.await(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        deferred8 = deferred5;
                        deferred9 = deferred6;
                        goto label_39;
                    }
                    case 1: {
                        Deferred deferred10 = (Deferred)this.L$4;
                        deferred9 = (Deferred)this.L$3;
                        deferred8 = (Deferred)this.L$2;
                        Deferred deferred11 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        deferred7 = deferred10;
                        object1 = object0;
                    label_39:
                        j0 j00 = ArtistDetailHomeFragment.this.getAdapter();
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
                        ((ArtistDetailAdapter)j00).setBannerRes((((PromotionContentsBannerRes)object1) == null ? null : ((PromotionContentsBannerRes)object1).response));
                        this.L$0 = coroutineScope0;
                        this.L$1 = null;
                        this.L$2 = deferred8;
                        this.L$3 = null;
                        this.L$4 = deferred7;
                        this.L$5 = null;
                        this.label = 2;
                        object2 = deferred9.await(this);
                        if(object2 == a0) {
                            return a0;
                        }
                        deferred12 = deferred8;
                        goto label_61;
                    }
                    case 2: {
                        PromotionContentsBannerRes promotionContentsBannerRes1 = (PromotionContentsBannerRes)this.L$5;
                        Deferred deferred13 = (Deferred)this.L$4;
                        Deferred deferred14 = (Deferred)this.L$3;
                        deferred12 = (Deferred)this.L$2;
                        Deferred deferred15 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        deferred7 = deferred13;
                        object2 = object0;
                    label_61:
                        artistHomeBasicInfoRes1 = (ArtistHomeBasicInfoRes)object2;
                        this.L$0 = coroutineScope0;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = deferred7;
                        this.L$5 = null;
                        this.L$6 = artistHomeBasicInfoRes1;
                        this.label = 3;
                        object3 = deferred12.await(this);
                        if(object3 == a0) {
                            return a0;
                        }
                        goto label_82;
                    }
                    case 3: {
                        artistHomeBasicInfoRes1 = (ArtistHomeBasicInfoRes)this.L$6;
                        PromotionContentsBannerRes promotionContentsBannerRes2 = (PromotionContentsBannerRes)this.L$5;
                        Deferred deferred16 = (Deferred)this.L$4;
                        Deferred deferred17 = (Deferred)this.L$3;
                        Deferred deferred18 = (Deferred)this.L$2;
                        Deferred deferred19 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        deferred7 = deferred16;
                        object3 = object0;
                    label_82:
                        this.L$0 = coroutineScope0;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = artistHomeBasicInfoRes1;
                        this.L$7 = (ArtistHomeContentsRes)object3;
                        this.label = 4;
                        object4 = deferred7.await(this);
                        if(object4 == a0) {
                            return a0;
                        }
                        artistHomeBasicInfoRes2 = artistHomeBasicInfoRes1;
                        artistHomeContentsRes1 = (ArtistHomeContentsRes)object3;
                        goto label_105;
                    }
                    case 4: {
                        artistHomeContentsRes1 = (ArtistHomeContentsRes)this.L$7;
                        artistHomeBasicInfoRes2 = (ArtistHomeBasicInfoRes)this.L$6;
                        PromotionContentsBannerRes promotionContentsBannerRes3 = (PromotionContentsBannerRes)this.L$5;
                        Deferred deferred20 = (Deferred)this.L$4;
                        Deferred deferred21 = (Deferred)this.L$3;
                        Deferred deferred22 = (Deferred)this.L$2;
                        Deferred deferred23 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        object4 = object0;
                    label_105:
                        j0 j01 = ArtistDetailHomeFragment.this.getAdapter();
                        q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
                        ((ArtistDetailAdapter)j01).setSummaryRes((((ArtistTemperatureSummaryRes)object4) == null ? null : ((ArtistTemperatureSummaryRes)object4).response));
                        if(artistHomeContentsRes1 != null) {
                            com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE0 = artistHomeContentsRes1.response;
                            if(artistHomeContentsRes$RESPONSE0 != null) {
                                String s = artistHomeContentsRes$RESPONSE0.fanTalkChnlSeq;
                                if(s != null) {
                                    Job job0 = ArtistDetailHomeFragment.this.requestCmtInfoJob(coroutineScope0, s);
                                    this.L$0 = coroutineScope0;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.L$6 = artistHomeBasicInfoRes2;
                                    this.L$7 = artistHomeContentsRes1;
                                    this.L$8 = null;
                                    this.L$9 = null;
                                    this.I$0 = 0;
                                    this.label = 5;
                                    if(job0.join(this) == a0) {
                                        return a0;
                                    }
                                }
                            }
                        }
                        artistHomeBasicInfoRes3 = artistHomeBasicInfoRes2;
                        goto label_146;
                    }
                    case 5: {
                        String s1 = (String)this.L$9;
                        ArtistTemperatureSummaryRes artistTemperatureSummaryRes1 = (ArtistTemperatureSummaryRes)this.L$8;
                        artistHomeContentsRes1 = (ArtistHomeContentsRes)this.L$7;
                        ArtistHomeBasicInfoRes artistHomeBasicInfoRes4 = (ArtistHomeBasicInfoRes)this.L$6;
                        PromotionContentsBannerRes promotionContentsBannerRes4 = (PromotionContentsBannerRes)this.L$5;
                        Deferred deferred24 = (Deferred)this.L$4;
                        Deferred deferred25 = (Deferred)this.L$3;
                        Deferred deferred26 = (Deferred)this.L$2;
                        Deferred deferred27 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        artistHomeBasicInfoRes3 = artistHomeBasicInfoRes4;
                    label_146:
                        com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.2 artistDetailHomeFragment$onFetchStart$1$20 = new n(artistHomeContentsRes1, artistHomeBasicInfoRes3, this.$supervisor, null) {
                            final ArtistHomeBasicInfoRes $artistHomeBasicInfoRes;
                            final ArtistHomeContentsRes $artistHomeContentsRes;
                            final CompletableJob $supervisor;
                            int label;

                            {
                                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                                this.$artistHomeContentsRes = artistHomeContentsRes0;
                                this.$artistHomeBasicInfoRes = artistHomeBasicInfoRes0;
                                this.$supervisor = completableJob0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.2(ArtistDetailHomeFragment.this, this.$artistHomeContentsRes, this.$artistHomeBasicInfoRes, this.$supervisor, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                String s;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                boolean z = ArtistDetailHomeFragment.this.prepareFetchComplete(this.$artistHomeContentsRes);
                                H h0 = H.a;
                                if(z && ArtistDetailHomeFragment.this.prepareFetchComplete(this.$artistHomeBasicInfoRes)) {
                                    com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0 = this.$artistHomeBasicInfoRes == null ? null : this.$artistHomeBasicInfoRes.response;
                                    com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE0 = this.$artistHomeContentsRes == null ? null : this.$artistHomeContentsRes.response;
                                    ArtistDetailHomeFragment artistDetailHomeFragment0 = ArtistDetailHomeFragment.this;
                                    if(artistHomeBasicInfoRes$RESPONSE0 == null) {
                                        s = null;
                                    }
                                    else {
                                        BILLIONSCLUBINFO artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO0 = artistHomeBasicInfoRes$RESPONSE0.billionsClubInfo;
                                        if(artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO0 == null) {
                                            s = null;
                                        }
                                        else {
                                            LinkInfoBase linkInfoBase0 = artistHomeBasicInfoRes$RESPONSE$BILLIONSCLUBINFO0.linkInfo;
                                            s = linkInfoBase0 == null ? null : linkInfoBase0.linkurl;
                                        }
                                    }
                                    artistDetailHomeFragment0.hasBillionsClubAlbum = (boolean)(1 ^ (s == null || s.length() == 0 ? 1 : 0));
                                    if(artistHomeBasicInfoRes$RESPONSE0 != null && artistHomeContentsRes$RESPONSE0 != null) {
                                        s s1 = new s(artistHomeBasicInfoRes$RESPONSE0.section, artistHomeBasicInfoRes$RESPONSE0.page, artistHomeBasicInfoRes$RESPONSE0.menuId, null);
                                        ArtistDetailHomeFragment.this.mMelonTiaraProperty = s1;
                                        String s2 = artistHomeBasicInfoRes$RESPONSE0.artistName;
                                        q.f(s2, "artistName");
                                        ArtistDetailHomeFragment.this.artistName = s2;
                                        ArtistDetailHomeFragment.this.isOwnArtist = ProtocolUtils.parseBoolean(artistHomeBasicInfoRes$RESPONSE0.artistYN);
                                        ArtistDetailHomeFragment.this.drawHeaderView(artistHomeBasicInfoRes$RESPONSE0);
                                        String s3 = artistHomeBasicInfoRes$RESPONSE0.artistImg;
                                        q.f(s3, "artistImg");
                                        ArtistDetailHomeFragment.this.artistImageUrl = s3;
                                        ARTISTPICK artistHomeContentsRes$RESPONSE$ARTISTPICK0 = artistHomeContentsRes$RESPONSE0.artistPick;
                                        if(artistHomeContentsRes$RESPONSE$ARTISTPICK0.artistPickSeq != null) {
                                            ArtistDetailHomeFragment.this.drawArtistPickLayout(artistHomeContentsRes$RESPONSE$ARTISTPICK0);
                                        }
                                        CREDITINFO artistHomeContentsRes$RESPONSE$CREDITINFO0 = artistHomeContentsRes$RESPONSE0.creditInfo;
                                        if(artistHomeContentsRes$RESPONSE$CREDITINFO0 != null) {
                                            ArtistDetailHomeFragment.this.drawCreditLayout(artistHomeContentsRes$RESPONSE$CREDITINFO0);
                                        }
                                        ArtistDetailHomeFragment.this.setSelectAllWithToolbar(false);
                                        ArtistDetailHomeFragment.this.performFetchComplete(i.b, this.$artistHomeBasicInfoRes);
                                        ArtistDetailHomeFragment.this.bbsChannelSeq = artistHomeContentsRes$RESPONSE0.fanTalkChnlSeq == null ? "" : artistHomeContentsRes$RESPONSE0.fanTalkChnlSeq;
                                        return h0;
                                    }
                                    TitleBar titleBar0 = ArtistDetailHomeFragment.this.getTitleBar();
                                    if(titleBar0 != null) {
                                        titleBar0.setVisibility(8);
                                    }
                                    k k0 = ArtistDetailHomeFragment.this.headerBinding;
                                    if(k0 != null) {
                                        k0.a.setVisibility(8);
                                        return h0;
                                    }
                                    q.m("headerBinding");
                                    throw null;
                                }
                                TitleBar titleBar1 = ArtistDetailHomeFragment.this.getTitleBar();
                                if(titleBar1 != null) {
                                    titleBar1.setVisibility(8);
                                }
                                k k1 = ArtistDetailHomeFragment.this.headerBinding;
                                if(k1 != null) {
                                    k1.a.setVisibility(8);
                                    DefaultImpls.cancel$default(this.$supervisor, null, 1, null);
                                    return h0;
                                }
                                q.m("headerBinding");
                                throw null;
                            }
                        };
                        this.L$0 = coroutineScope0;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = artistHomeContentsRes1;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.label = 6;
                        if(BuildersKt.withContext(Dispatchers.getMain(), artistDetailHomeFragment$onFetchStart$1$20, this) == a0) {
                            return a0;
                        }
                        artistHomeContentsRes2 = artistHomeContentsRes1;
                        goto label_170;
                    }
                    case 6: {
                        ArtistTemperatureSummaryRes artistTemperatureSummaryRes2 = (ArtistTemperatureSummaryRes)this.L$8;
                        artistHomeContentsRes2 = (ArtistHomeContentsRes)this.L$7;
                        ArtistHomeBasicInfoRes artistHomeBasicInfoRes5 = (ArtistHomeBasicInfoRes)this.L$6;
                        PromotionContentsBannerRes promotionContentsBannerRes5 = (PromotionContentsBannerRes)this.L$5;
                        Deferred deferred28 = (Deferred)this.L$4;
                        Deferred deferred29 = (Deferred)this.L$3;
                        Deferred deferred30 = (Deferred)this.L$2;
                        Deferred deferred31 = (Deferred)this.L$1;
                        d5.n.D(object0);
                    label_170:
                        if(artistHomeContentsRes2 == null) {
                            list1 = null;
                        }
                        else {
                            com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE1 = artistHomeContentsRes2.response;
                            list1 = artistHomeContentsRes$RESPONSE1 == null ? null : artistHomeContentsRes$RESPONSE1.topicList;
                        }
                        if(list1 != null && !list1.isEmpty() == 1) {
                            Job job1 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(list1, null) {
                                final List $topicList;
                                private Object L$0;
                                int label;

                                {
                                    ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                                    this.$topicList = list0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.3(ArtistDetailHomeFragment.this, this.$topicList, continuation0);
                                    continuation1.L$0 = object0;
                                    return continuation1;
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    ArtistDetailHomeFragment.this.requestTopicLikeJob(coroutineScope0, this.$topicList);
                                    ArtistDetailHomeFragment.this.requestTopicListLikeAndCmtJob(coroutineScope0, this.$topicList);
                                    return H.a;
                                }
                            }, 3, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.L$9 = null;
                            this.label = 7;
                            if(job1.join(this) == a0) {
                                return a0;
                            }
                            goto label_203;
                        }
                        goto label_227;
                    }
                    case 7: {
                        List list2 = (List)this.L$9;
                        ArtistTemperatureSummaryRes artistTemperatureSummaryRes3 = (ArtistTemperatureSummaryRes)this.L$8;
                        ArtistHomeContentsRes artistHomeContentsRes3 = (ArtistHomeContentsRes)this.L$7;
                        ArtistHomeBasicInfoRes artistHomeBasicInfoRes6 = (ArtistHomeBasicInfoRes)this.L$6;
                        PromotionContentsBannerRes promotionContentsBannerRes6 = (PromotionContentsBannerRes)this.L$5;
                        Deferred deferred32 = (Deferred)this.L$4;
                        Deferred deferred33 = (Deferred)this.L$3;
                        Deferred deferred34 = (Deferred)this.L$2;
                        Deferred deferred35 = (Deferred)this.L$1;
                        d5.n.D(object0);
                    label_203:
                        com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.4 artistDetailHomeFragment$onFetchStart$1$40 = new n(null) {
                            int label;

                            {
                                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.4(ArtistDetailHomeFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                j0 j00 = ArtistDetailHomeFragment.this.getAdapter();
                                if(j00 != null) {
                                    int v = j00.getItemCount();
                                    for(int v1 = 0; v1 < v; ++v1) {
                                        if(53 == j00.getItemViewType(v1)) {
                                            j00.notifyItemChanged(v1);
                                            return H.a;
                                        }
                                    }
                                    return H.a;
                                }
                                return null;
                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.label = 8;
                        if(BuildersKt.withContext(Dispatchers.getMain(), artistDetailHomeFragment$onFetchStart$1$40, this) == a0) {
                            return a0;
                        }
                        goto label_227;
                    }
                    case 8: {
                        break;
                    }
                    case 9: {
                        me.i i0 = (me.i)this.L$10;
                        List list0 = (List)this.L$9;
                        ArtistTemperatureSummaryRes artistTemperatureSummaryRes0 = (ArtistTemperatureSummaryRes)this.L$8;
                        ArtistHomeContentsRes artistHomeContentsRes0 = (ArtistHomeContentsRes)this.L$7;
                        ArtistHomeBasicInfoRes artistHomeBasicInfoRes0 = (ArtistHomeBasicInfoRes)this.L$6;
                        PromotionContentsBannerRes promotionContentsBannerRes0 = (PromotionContentsBannerRes)this.L$5;
                        Deferred deferred0 = (Deferred)this.L$4;
                        Deferred deferred1 = (Deferred)this.L$3;
                        Deferred deferred2 = (Deferred)this.L$2;
                        Deferred deferred3 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                List list3 = (List)this.L$9;
                ArtistTemperatureSummaryRes artistTemperatureSummaryRes4 = (ArtistTemperatureSummaryRes)this.L$8;
                ArtistHomeContentsRes artistHomeContentsRes4 = (ArtistHomeContentsRes)this.L$7;
                ArtistHomeBasicInfoRes artistHomeBasicInfoRes7 = (ArtistHomeBasicInfoRes)this.L$6;
                PromotionContentsBannerRes promotionContentsBannerRes7 = (PromotionContentsBannerRes)this.L$5;
                Deferred deferred36 = (Deferred)this.L$4;
                Deferred deferred37 = (Deferred)this.L$3;
                Deferred deferred38 = (Deferred)this.L$2;
                Deferred deferred39 = (Deferred)this.L$1;
                d5.n.D(object0);
            label_227:
                me.i i1 = Dispatchers.getMain().plus(ArtistDetailHomeFragment.this.subExceptionHandler);
                com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.5 artistDetailHomeFragment$onFetchStart$1$50 = new n(null) {
                    int label;

                    {
                        ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.5(ArtistDetailHomeFragment.this, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.onFetchStart.1.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        ArtistDetailHomeFragment.this.requestCommentApis(ArtistDetailHomeFragment.this.bbsChannelSeq, ArtistDetailHomeFragment.this.getContsId(), false);
                        return H.a;
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.L$9 = null;
                this.L$10 = null;
                this.label = 9;
                return BuildersKt.withContext(i1, artistDetailHomeFragment$onFetchStart$1$50, this) == a0 ? a0 : H.a;
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onFragmentVisibilityChanged(boolean z) {
        super.onFragmentVisibilityChanged(z);
        if(z) {
            if(this.isCollapsed) {
                this.onAppBarCollapsed();
            }
            else {
                this.onAppBarExpended();
            }
            ArtistCardRelayRollingView artistCardRelayRollingView0 = this.cardRelayRollingView;
            if(artistCardRelayRollingView0 != null) {
                artistCardRelayRollingView0.b();
            }
        }
        else {
            ArtistCardRelayRollingView artistCardRelayRollingView1 = this.cardRelayRollingView;
            if(artistCardRelayRollingView1 != null) {
                artistCardRelayRollingView1.c();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        String s = bundle0.getString("argItemId");
        if(s == null) {
            s = "";
        }
        this.artistId = s;
        this.isAutoPlay = bundle0.getBoolean("argAutoPlay", false);
        this.isCollapsed = bundle0.getBoolean("argIsCollapsed", false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.artistId);
        bundle0.putBoolean("argAutoPlay", this.isAutoPlay);
        bundle0.putBoolean("argIsCollapsed", this.isCollapsed);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onStart() {
        super.onStart();
        ArtistCardRelayRollingView artistCardRelayRollingView0 = this.cardRelayRollingView;
        if(artistCardRelayRollingView0 != null) {
            artistCardRelayRollingView0.b();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onStop() {
        super.onStop();
        ArtistCardRelayRollingView artistCardRelayRollingView0 = this.cardRelayRollingView;
        if(artistCardRelayRollingView0 != null) {
            artistCardRelayRollingView0.c();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Q4.a a0 = this.get_headerBinding();
        q.e(a0, "null cannot be cast to non-null type com.iloen.melon.databinding.ArtistDetailHeaderBinding");
        this.headerBinding = (k)a0;
        GradientDrawable.Orientation gradientDrawable$Orientation0 = GradientDrawable.Orientation.TOP_BOTTOM;
        int v = ScreenUtils.isDarkMode(this.getContext()) ? -435023342 : 0xE6FFFFFF;
        ((k)a0).t.c.setBackground(new GradientDrawable(gradientDrawable$Orientation0, new int[]{v, ColorUtils.getColor(this.getContext(), 0x7F0604AA)}));  // color:white000s_support_high_contrast
        this.getBinding().c.a.setVisibility(8);
        m0 m00 = this.getBinding();
        this.bottomDivider = m00.d;
        int v1 = ColorUtils.getColor(this.getContext(), 0x7F06014B);  // color:gray100s_support_high_contrast
        m00.d.setBackgroundColor(v1);
        View view1 = this.bottomDivider;
        if(view1 != null) {
            view1.setVisibility(8);
        }
        this.setTitleBar(((TitleBar)this.getBinding().h.c));
        F8.m m0 = new F8.m(2, false);
        F8.m m1 = new F8.m(0, false);
        F8.p p0 = new F8.p(1);
        p0.c = new y(this, 3);
        F8.p p1 = new F8.p(0);
        p1.c = new y(this, 4);
        String s = va.e.c(this.getString(0x7F130C8E), " ", this.getString(0x7F130B88));  // string:text_artist_channel "아티스트 채널"
        F8.I i0 = new F8.I(1);
        i0.h(s);
        i0.c = new y(this, 5);
        F8.I i1 = new F8.I(0);
        i1.d = s;
        i1.c = new y(this, 6);
        p0.g(m0);
        p0.g(i0);
        this.titleItemBase = p0;
        p1.g(m1);
        p1.g(i1);
        this.whiteFixedTitleItemBase = p1;
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            F8.o o0 = this.titleItemBase;
            q.d(o0);
            titleBar0.a(o0);
        }
        TitleBar titleBar1 = this.getTitleBar();
        if(titleBar1 != null) {
            titleBar1.setTitle("");
        }
        ArtistDetailAdapter artistDetailHomeFragment$ArtistDetailAdapter0 = (ArtistDetailAdapter)this.getAdapter();
        if(artistDetailHomeFragment$ArtistDetailAdapter0 != null && !artistDetailHomeFragment$ArtistDetailAdapter0.isExpired(this.getCacheKey(), 300000L)) {
            ArtistHomeBasicInfoRes artistHomeBasicInfoRes0 = (ArtistHomeBasicInfoRes)artistDetailHomeFragment$ArtistDetailAdapter0.getResponse();
            com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0 = artistHomeBasicInfoRes0 == null ? null : artistHomeBasicInfoRes0.response;
            com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE artistHomeContentsRes$RESPONSE0 = artistDetailHomeFragment$ArtistDetailAdapter0.getContentsRes();
            if(artistHomeBasicInfoRes$RESPONSE0 != null && artistHomeContentsRes$RESPONSE0 != null) {
                String s1 = artistHomeBasicInfoRes$RESPONSE0.artistName;
                q.f(s1, "artistName");
                this.artistName = s1;
                this.isOwnArtist = ProtocolUtils.parseBoolean(artistHomeBasicInfoRes$RESPONSE0.artistYN);
                String s2 = artistHomeBasicInfoRes$RESPONSE0.artistImg;
                q.f(s2, "artistImg");
                this.artistImageUrl = s2;
                this.drawHeaderView(artistHomeBasicInfoRes$RESPONSE0);
                ARTISTPICK artistHomeContentsRes$RESPONSE$ARTISTPICK0 = artistHomeContentsRes$RESPONSE0.artistPick;
                if(artistHomeContentsRes$RESPONSE$ARTISTPICK0.artistPickSeq != null) {
                    this.drawArtistPickLayout(artistHomeContentsRes$RESPONSE$ARTISTPICK0);
                }
                CREDITINFO artistHomeContentsRes$RESPONSE$CREDITINFO0 = artistHomeContentsRes$RESPONSE0.creditInfo;
                if(artistHomeContentsRes$RESPONSE$CREDITINFO0 != null) {
                    this.drawCreditLayout(artistHomeContentsRes$RESPONSE$CREDITINFO0);
                }
                this.setSelectAllWithToolbar(false);
            }
        }
        this.registerIsLoginFlow();
    }

    private static final void onViewCreated$lambda$2(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        artistDetailHomeFragment0.performBackPress();
    }

    private static final void onViewCreated$lambda$3(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        artistDetailHomeFragment0.performBackPress();
    }

    private static final void onViewCreated$lambda$4(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        artistDetailHomeFragment0.showMorePopup();
        artistDetailHomeFragment0.trackTiaraShowMorePopup();
    }

    private static final void onViewCreated$lambda$5(ArtistDetailHomeFragment artistDetailHomeFragment0, View view0) {
        artistDetailHomeFragment0.showMorePopup();
        artistDetailHomeFragment0.trackTiaraShowMorePopup();
    }

    private final void playTitleSong(com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0) {
        TITLESONG artistHomeBasicInfoRes$RESPONSE$TITLESONG0 = artistHomeBasicInfoRes$RESPONSE0.titleSong;
        if(artistHomeBasicInfoRes$RESPONSE$TITLESONG0 == null) {
            LogU.Companion.e("ArtistDetailHomeFragment", "playTitleSong() invalid response");
            return;
        }
        if(artistHomeBasicInfoRes$RESPONSE$TITLESONG0.songId != null && artistHomeBasicInfoRes$RESPONSE$TITLESONG0.songId.length() != 0) {
            String s = artistHomeBasicInfoRes$RESPONSE$TITLESONG0.songId;
            if(s != null) {
                String s1 = artistHomeBasicInfoRes$RESPONSE$TITLESONG0.getMenuId();
                if(s1 != null) {
                    FragmentActivity fragmentActivity0 = this.getActivity();
                    if(fragmentActivity0 != null) {
                        AddPlay addAction$AddPlay0 = new AddPlay(false);
                        q.f(CType.SONG, "SONG");
                        Song playDataForSeverContent$Song0 = new Song(s, CType.SONG, s1, null);
                        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(fragmentActivity0, new AddServerContent(addAction$AddPlay0, false, false, this.blockingProgressDialogManage, playDataForSeverContent$Song0, 6, null), false, 2, null);
                    }
                    this.isAutoPlay = false;
                    return;
                }
            }
            return;
        }
        LogU.Companion.e("ArtistDetailHomeFragment", "playTitleSong() invalid songId");
    }

    private final void registerIsLoginFlow() {
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.registerIsLoginFlow.1(ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.registerIsLoginFlow.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)ArtistDetailHomeFragment.this.getLoginUseCase()).n()), 1);
                        com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.registerIsLoginFlow.1.1 artistDetailHomeFragment$registerIsLoginFlow$1$10 = new n(null) {
                            boolean Z$0;
                            int label;

                            {
                                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.registerIsLoginFlow.1.1(ArtistDetailHomeFragment.this, continuation0);
                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.registerIsLoginFlow.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.Z$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                LogU logU0 = new LogU("ArtistDetailHomeFragment");
                                logU0.setCategory(Category.Login);
                                logU0.setUseThreadInfo(true);
                                LogU.debug$default(logU0, "ArtistDetailHomeFragment - isLogin: " + z, null, false, 6, null);
                                if(z && ArtistDetailHomeFragment.this.isFragmentValid()) {
                                    ArtistDetailHomeFragment.this.startFetch("logIn");
                                }
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(flow0, artistDetailHomeFragment$registerIsLoginFlow$1$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
    }

    private final Deferred requestBannerInfoAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestBannerInfoAsync.1(ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestBannerInfoAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Param promotionContentsBannerReq$Param0 = new Param();
                promotionContentsBannerReq$Param0.contsType = "N10006";
                promotionContentsBannerReq$Param0.contsId = ArtistDetailHomeFragment.this.artistId;
                try {
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    HttpResponse httpResponse0 = RequestBuilder.newInstance(new PromotionContentsBannerReq(ArtistDetailHomeFragment.this.getContext(), promotionContentsBannerReq$Param0)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.PromotionContentsBannerRes");
                    if(ArtistDetailHomeFragment.this.isFragmentValid()) {
                        Cb.j.b(((PromotionContentsBannerRes)httpResponse0).notification, false, 3);
                        if(Cb.j.d(((PromotionContentsBannerRes)httpResponse0))) {
                            j0 j00 = ArtistDetailHomeFragment.this.mAdapter;
                            ArtistDetailAdapter artistDetailHomeFragment$ArtistDetailAdapter0 = j00 instanceof ArtistDetailAdapter ? ((ArtistDetailAdapter)j00) : null;
                            if(artistDetailHomeFragment$ArtistDetailAdapter0 != null) {
                                artistDetailHomeFragment$ArtistDetailAdapter0.setBannerRes(((PromotionContentsBannerRes)httpResponse0).response);
                            }
                        }
                    }
                    return (PromotionContentsBannerRes)httpResponse0;
                }
                catch(Exception exception0) {
                }
                H0.b.w("requestBannerInfoAsync() exception, ", exception0.getMessage(), LogU.Companion, "ArtistDetailHomeFragment");
                return null;
            }
        }, 3, null);
    }

    private final Deferred requestBasicInfoAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestBasicInfoAsync.1(ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestBasicInfoAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistHomeBasicInfoReq(ArtistDetailHomeFragment.this.getContext(), ArtistDetailHomeFragment.this.artistId)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes");
                return (ArtistHomeBasicInfoRes)httpResponse0;
            }
        }, 3, null);
    }

    private final Job requestCmtInfoJob(CoroutineScope coroutineScope0, String s) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(s, null) {
            final String $chnlSeq;
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                this.$chnlSeq = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestCmtInfoJob.1(ArtistDetailHomeFragment.this, this.$chnlSeq, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestCmtInfoJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Params informCmtContsSummReq$Params0 = new Params();
                informCmtContsSummReq$Params0.chnlSeq = Integer.parseInt(this.$chnlSeq);
                informCmtContsSummReq$Params0.contsRefValue = ArtistDetailHomeFragment.this.artistId;
                Integer integer0 = CmtHelper.getLatestComment(Integer.parseInt(this.$chnlSeq), ArtistDetailHomeFragment.this.artistId);
                int v = integer0 == null ? -1 : ((int)integer0);
                try {
                    informCmtContsSummReq$Params0.latestCmtSeq = v;
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    HttpResponse httpResponse0 = RequestBuilder.newInstance(new InformCmtContsSummReq(ArtistDetailHomeFragment.this.getContext(), informCmtContsSummReq$Params0)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.InformCmtContsSummRes");
                    Cb.j.b(((InformCmtContsSummRes)httpResponse0).notification, false, 2);
                    if(Cb.j.d(((InformCmtContsSummRes)httpResponse0))) {
                        j0 j00 = ArtistDetailHomeFragment.this.getAdapter();
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
                        result informCmtContsSummRes$result0 = ((InformCmtContsSummRes)httpResponse0).result;
                        ((ArtistDetailAdapter)j00).setCmtContsSumm((informCmtContsSummRes$result0 == null ? null : informCmtContsSummRes$result0.cmtContsSumm));
                        return H.a;
                    }
                }
                catch(Exception exception0) {
                    H0.b.w("requestCmtInfoJob() exception, ", exception0.getMessage(), LogU.Companion, "ArtistDetailHomeFragment");
                }
                return H.a;
            }
        }, 3, null);
    }

    private final Deferred requestContentsAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestContentsAsync.1(ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestContentsAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistHomeContentsReq(ArtistDetailHomeFragment.this.getContext(), ArtistDetailHomeFragment.this.artistId)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistHomeContentsRes");
                if(ArtistDetailHomeFragment.this.isFragmentValid()) {
                    Cb.j.b(((ArtistHomeContentsRes)httpResponse0).notification, false, 3);
                    if(Cb.j.d(((ArtistHomeContentsRes)httpResponse0))) {
                        j0 j00 = ArtistDetailHomeFragment.this.mAdapter;
                        ArtistDetailAdapter artistDetailHomeFragment$ArtistDetailAdapter0 = j00 instanceof ArtistDetailAdapter ? ((ArtistDetailAdapter)j00) : null;
                        if(artistDetailHomeFragment$ArtistDetailAdapter0 != null) {
                            artistDetailHomeFragment$ArtistDetailAdapter0.setContentsRes(((ArtistHomeContentsRes)httpResponse0).response);
                        }
                    }
                }
                return (ArtistHomeContentsRes)httpResponse0;
            }
        }, 3, null);
    }

    private final Deferred requestSummaryAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestSummaryAsync.1(ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestSummaryAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    try {
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistTemperatureSummaryReq(ArtistDetailHomeFragment.this.getContext(), ArtistDetailHomeFragment.this.artistId)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes");
                        return (ArtistTemperatureSummaryRes)httpResponse0;
                    }
                    catch(Exception unused_ex) {
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    private final Deferred requestTemperatureScoreNoticeAsync(CoroutineScope coroutineScope0, String s) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(s, null) {
            final String $artistId;
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                this.$artistId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestTemperatureScoreNoticeAsync.1(ArtistDetailHomeFragment.this, this.$artistId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestTemperatureScoreNoticeAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    try {
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistTemperatureScoreNoticeReq(ArtistDetailHomeFragment.this.getContext(), this.$artistId)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistTemperatureScoreNoticeRes");
                        return (ArtistTemperatureScoreNoticeRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        H0.b.w("requestTemperatureScoreNoticeAsync() exception, ", exception0.getMessage(), LogU.Companion, "ArtistDetailHomeFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    private final Job requestTopicLikeJob(CoroutineScope coroutineScope0, List list0) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(this, null) {
            final List $topicList;
            int label;

            {
                this.$topicList = list0;
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestTopicLikeJob.1(this.$topicList, ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestTopicLikeJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s1;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                boolean z = ((e0)va.o.a()).m();
                H h0 = H.a;
                if(z) {
                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.$topicList));
                    for(Object object1: this.$topicList) {
                        TOPICLIST artistHomeContentsRes$RESPONSE$TOPICLIST0 = (TOPICLIST)object1;
                        if(artistHomeContentsRes$RESPONSE$TOPICLIST0 == null) {
                            s1 = "";
                        }
                        else {
                            String s = artistHomeContentsRes$RESPONSE$TOPICLIST0.topicSeq;
                            if(s != null) {
                                s1 = s;
                            }
                        }
                        arrayList0.add(s1);
                    }
                    String s2 = StringUtils.convertToCommaSeparatedText(new ArrayList(arrayList0));
                    com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0 = new com.iloen.melon.net.v4x.request.UserActionsReq.Params();
                    userActionsReq$Params0.fields = "like";
                    userActionsReq$Params0.contsTypeCode = "N10098";
                    userActionsReq$Params0.contsId = s2;
                    try {
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new UserActionsReq(ArtistDetailHomeFragment.this.getContext(), userActionsReq$Params0)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.UserActionsRes");
                        int v = 0;
                        Cb.j.b(((UserActionsRes)httpResponse0).notification, false, 2);
                        if(Cb.j.d(((UserActionsRes)httpResponse0))) {
                            Response userActionsRes$Response0 = ((UserActionsRes)httpResponse0).response;
                            if(userActionsRes$Response0 != null) {
                                ArrayList arrayList1 = userActionsRes$Response0.relationList;
                                if(arrayList1 != null) {
                                    List list0 = this.$topicList;
                                    for(Object object2: arrayList1) {
                                        if(v < 0) {
                                            e.k.O();
                                            throw null;
                                        }
                                        TOPICLIST artistHomeContentsRes$RESPONSE$TOPICLIST1 = (TOPICLIST)p.n0(v, list0);
                                        if(artistHomeContentsRes$RESPONSE$TOPICLIST1 != null) {
                                            artistHomeContentsRes$RESPONSE$TOPICLIST1.isLike = q.b(((RelationList)object2).fields.like, "Y");
                                        }
                                        ++v;
                                    }
                                }
                            }
                        }
                        return h0;
                    }
                    catch(Exception exception0) {
                    }
                }
                else {
                    return h0;
                }
                H0.b.w("requestTopicLikeJob() exception, ", exception0.getMessage(), LogU.Companion, "ArtistDetailHomeFragment");
                return h0;
            }
        }, 3, null);
    }

    private final Job requestTopicListLikeAndCmtJob(CoroutineScope coroutineScope0, List list0) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(this, null) {
            final List $topicList;
            int label;

            {
                this.$topicList = list0;
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestTopicListLikeAndCmtJob.1(this.$topicList, ArtistDetailHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestTopicListLikeAndCmtJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s1;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.$topicList));
                for(Object object1: this.$topicList) {
                    TOPICLIST artistHomeContentsRes$RESPONSE$TOPICLIST0 = (TOPICLIST)object1;
                    if(artistHomeContentsRes$RESPONSE$TOPICLIST0 == null) {
                        s1 = "";
                    }
                    else {
                        String s = artistHomeContentsRes$RESPONSE$TOPICLIST0.topicSeq;
                        if(s != null) {
                            s1 = s;
                        }
                    }
                    arrayList0.add(s1);
                }
                String s2 = StringUtils.convertToCommaSeparatedText(new ArrayList(arrayList0));
                com.iloen.melon.net.v6x.request.ArtistContentsListLikeAndCmtReq.Params artistContentsListLikeAndCmtReq$Params0 = new com.iloen.melon.net.v6x.request.ArtistContentsListLikeAndCmtReq.Params();
                artistContentsListLikeAndCmtReq$Params0.artistId = ArtistDetailHomeFragment.this.artistId;
                artistContentsListLikeAndCmtReq$Params0.contsIds = s2;
                artistContentsListLikeAndCmtReq$Params0.contsTypeCode = "N10098";
                try {
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistContentsListLikeAndCmtReq(ArtistDetailHomeFragment.this.getContext(), artistContentsListLikeAndCmtReq$Params0)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes");
                    int v = 0;
                    Cb.j.b(((ArtistContentsListLikeAndCmtRes)httpResponse0).notification, false, 2);
                    if(Cb.j.d(((ArtistContentsListLikeAndCmtRes)httpResponse0))) {
                        com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes.RESPONSE artistContentsListLikeAndCmtRes$RESPONSE0 = ((ArtistContentsListLikeAndCmtRes)httpResponse0).response;
                        if(artistContentsListLikeAndCmtRes$RESPONSE0 != null) {
                            List list0 = artistContentsListLikeAndCmtRes$RESPONSE0.userActionList;
                            if(list0 != null) {
                                List list1 = this.$topicList;
                                for(Object object2: list0) {
                                    if(v < 0) {
                                        e.k.O();
                                        throw null;
                                    }
                                    TOPICLIST artistHomeContentsRes$RESPONSE$TOPICLIST1 = (TOPICLIST)p.n0(v, list1);
                                    if(artistHomeContentsRes$RESPONSE$TOPICLIST1 != null) {
                                        artistHomeContentsRes$RESPONSE$TOPICLIST1.likeCnt = ((USERACTIONLIST)object2).likeCnt;
                                        artistHomeContentsRes$RESPONSE$TOPICLIST1.totalCmtCnt = ((USERACTIONLIST)object2).totalCmtCnt;
                                        artistHomeContentsRes$RESPONSE$TOPICLIST1.cmtList = ((USERACTIONLIST)object2).cmtList;
                                    }
                                    ++v;
                                }
                            }
                        }
                    }
                }
                catch(Exception exception0) {
                    H0.b.w("requestTopicListLikeAndCmtJob() exception, ", exception0.getMessage(), LogU.Companion, "ArtistDetailHomeFragment");
                }
                return H.a;
            }
        }, 3, null);
    }

    private final Deferred requestUserActionsAsync(CoroutineScope coroutineScope0, String s) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(s, null) {
            final String $artistId;
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                this.$artistId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestUserActionsAsync.1(ArtistDetailHomeFragment.this, this.$artistId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.requestUserActionsAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0 = new com.iloen.melon.net.v4x.request.UserActionsReq.Params();
                    userActionsReq$Params0.fields = "fan,temperature";
                    userActionsReq$Params0.contsTypeCode = "N10006";
                    userActionsReq$Params0.contsId = this.$artistId;
                    try {
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new UserActionsReq(ArtistDetailHomeFragment.this.getContext(), userActionsReq$Params0)).tag(ArtistDetailHomeFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.UserActionsRes");
                        return (UserActionsRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        H0.b.w("requestUserActionsAsync() exception, ", exception0.getMessage(), LogU.Companion, "ArtistDetailHomeFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    private final void sendTiaraBillionsClub(String s) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = s;
            f0.F = this.getString(0x7F130CC8);  // string:tiara_artist_copy_billions_club "빌리언스클럽"
            f0.a().track();
        }
    }

    private final void sendTiaraTemperature(String s) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = s;
            f0.F = this.getString(0x7F130CCF);  // string:tiara_artist_copy_temperature "친밀도"
            f0.a().track();
        }
    }

    public final void setLoginUseCase(@NotNull mb.k k0) {
        q.g(k0, "<set-?>");
        this.loginUseCase = k0;
    }

    private final void showCreateShortcutPopup() {
        com.iloen.melon.fragments.artistchannel.x x0 = new com.iloen.melon.fragments.artistchannel.x(this, 0);
        this.popupHandler.post(x0);
    }

    private static final void showCreateShortcutPopup$lambda$30(ArtistDetailHomeFragment artistDetailHomeFragment0) {
        if(!artistDetailHomeFragment0.isPossiblePopupShow()) {
            return;
        }
        l0 l00 = artistDetailHomeFragment0.getChildFragmentManager();
        String s = artistDetailHomeFragment0.getContext() == null ? null : "안내";
        String s1 = artistDetailHomeFragment0.getString(0x7F13010D);  // string:artist_channel_make_short_cut "%1$s 채널 바로가기를 생성하시겠습니까?"
        q.f(s1, "getString(...)");
        b.x(l00, s, String.format(s1, Arrays.copyOf(new Object[]{artistDetailHomeFragment0.artistName}, 1)), false, false, null, null, new com.iloen.melon.fragments.artistchannel.a(artistDetailHomeFragment0, 4), null, null, null, 0xEF8);
    }

    private static final H showCreateShortcutPopup$lambda$30$lambda$29(ArtistDetailHomeFragment artistDetailHomeFragment0) {
        Context context0 = artistDetailHomeFragment0.getContext();
        H h0 = H.a;
        if(context0 != null && !TextUtils.isEmpty(artistDetailHomeFragment0.artistName)) {
            k k0 = artistDetailHomeFragment0.headerBinding;
            if(k0 != null) {
                Drawable drawable0 = k0.l.getDrawable();
                Bitmap bitmap0 = drawable0 == null ? null : ImageUtils.convertGlideDrawableToBitmap(drawable0);
                LogU.Companion.d("ArtistDetailHomeFragment", "showCreateShortcutPopup() >> profileBitmap: " + bitmap0);
                if(bitmap0 == null) {
                    bitmap0 = ImageUtils.getResourceBitmapImpl(0x7F080609);  // drawable:icon_launcher_artist_01
                }
                Bitmap bitmap1 = ImageUtils.createCircledShortcutImage(artistDetailHomeFragment0.getContext(), bitmap0);
                Intent intent0 = new Intent(artistDetailHomeFragment0.getContext(), MusicBrowserActivity.class);
                intent0.setAction("android.intent.action.VIEW");
                intent0.addFlags(0x4000000);
                intent0.addFlags(0x10000000);
                intent0.setData(r8.f.b(c.b, artistDetailHomeFragment0.artistId, null));
                ShortcutManager.getInstance().requestShortcut(ShortcutManager.createShortcutInfo(("id_" + artistDetailHomeFragment0.artistName), artistDetailHomeFragment0.artistName, bitmap1, intent0));
                d3.g.a0("5", "D02", "A3");
                return h0;
            }
            q.m("headerBinding");
            throw null;
        }
        return h0;
    }

    private final void showMorePopup() {
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            Object L$0;
            int label;

            {
                ArtistDetailHomeFragment.this = artistDetailHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.showMorePopup.1(ArtistDetailHomeFragment.this, continuation0);
            }

            // 检测为 Lambda 实现
            public static H d(ArtistDetailHomeFragment artistDetailHomeFragment0, k2 k20) [...]

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.showMorePopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        if(ArtistDetailHomeFragment.this.isAdded() && ArtistDetailHomeFragment.this.isPossiblePopupShow()) {
                            boolean z = false;
                            ArtistDetailHomeFragment.this.setSelectAllWithToolbar(false);
                            FragmentActivity fragmentActivity0 = ArtistDetailHomeFragment.this.getActivity();
                            if(fragmentActivity0 != null) {
                                if(ArtistDetailHomeFragment.this.isLoginUser()) {
                                    this.L$0 = fragmentActivity0;
                                    this.label = 1;
                                    Object object1 = F.a.a(ArtistDetailHomeFragment.this.artistId, this);
                                    if(object1 == a0) {
                                        return a0;
                                    }
                                    z = ((Boolean)object1).booleanValue();
                                }
                                b.o(fragmentActivity0.getSupportFragmentManager(), new zd.e(ArtistDetailHomeFragment.this.artistName, ArtistDetailHomeFragment.this.artistImageUrl, z), (k2 k20) -> com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.showMorePopup.1.invokeSuspend$lambda$0(ArtistDetailHomeFragment.this, k20), 12);
                                return h0;
                            }
                        }
                        break;
                    }
                    case 1: {
                        FragmentActivity fragmentActivity1 = (FragmentActivity)this.L$0;
                        d5.n.D(object0);
                        b.o(fragmentActivity1.getSupportFragmentManager(), new zd.e(ArtistDetailHomeFragment.this.artistName, ArtistDetailHomeFragment.this.artistImageUrl, ((Boolean)object0).booleanValue()), (k2 k20) -> com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.showMorePopup.1.invokeSuspend$lambda$0(ArtistDetailHomeFragment.this, k20), 12);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return h0;
            }

            private static final H invokeSuspend$lambda$0(ArtistDetailHomeFragment artistDetailHomeFragment0, k2 k20) {
                if(q.b(k20, v1.a)) {
                    artistDetailHomeFragment0.showCreateShortcutPopup();
                    return H.a;
                }
                if(k20 instanceof K1) {
                    M m0 = ((K1)k20).b.a;
                    if(m0 == M.F0) {
                        artistDetailHomeFragment0.showCreateShortcutPopup();
                        return H.a;
                    }
                    if(m0 == M.n1) {
                        if(artistDetailHomeFragment0.isLoginUser()) {
                            artistDetailHomeFragment0.insertExcludedArtist();
                            return H.a;
                        }
                        artistDetailHomeFragment0.showLoginPopup();
                        return H.a;
                    }
                    if(m0 == M.m1) {
                        artistDetailHomeFragment0.deleteExcludedArtist();
                    }
                }
                return H.a;
            }
        }, 3, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songMoreClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130E0F);  // string:tiara_common_layer1_song "곡"
            f0.F = this.getString(0x7F130D56);  // string:tiara_click_copy_more_song "곡더보기"
            f0.c(v - this.songListHeaderPosition - 1);
            f0.e = s1;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = s2;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songPlayClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        q.g(s4, "cType");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getString(0x7F130E0F);  // string:tiara_common_layer1_song "곡"
            f0.c(v - this.songListHeaderPosition - 1);
            f0.e = s1;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = s2;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songThumbClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130E0F);  // string:tiara_common_layer1_song "곡"
            f0.c(v - this.songListHeaderPosition - 1);
            f0.e = s1;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = s2;
            f0.a().track();
        }
    }

    private final void trackTiaraShowMorePopup() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
            f0.F = this.getString(0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentCountView(@Nullable InformCmtContsSummRes informCmtContsSummRes0) {
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentListView(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment.ArtistDetailAdapter");
        int v = ((ArtistDetailAdapter)j00).getCommentPosition() <= -1 ? ((ArtistDetailAdapter)j00).getItemCount() : ((ArtistDetailAdapter)j00).getCommentPosition();
        CmtResViewModel cmtResViewModel0 = this.getCmtResViewModel(loadPgnRes0, listCmtRes0);
        ArrayList arrayList0 = cmtResViewModel0.result.cmtlist;
        q.f(arrayList0, "cmtlist");
        if(arrayList0.isEmpty()) {
            ((ArtistDetailAdapter)j00).add(v, AdapterInViewHolder.Row.create(44, H.a));
        }
        else {
            ((ArtistDetailAdapter)j00).add(v, AdapterInViewHolder.Row.create(9, cmtResViewModel0));
        }
        ((ArtistDetailAdapter)j00).notifyItemChanged(v);
    }

    private final void updateFanAndTemperatureUi(ArrayList arrayList0, com.iloen.melon.net.v6x.response.ArtistTemperatureScoreNoticeRes.RESPONSE artistTemperatureScoreNoticeRes$RESPONSE0) {
        com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0 = null;
        if(arrayList0 != null && this.artistId.length() != 0) {
            Object object0 = null;
            for(Object object1: arrayList0) {
                if(q.b(((RelationList)object1).contentsTypeCode, "N10006")) {
                    object0 = object1;
                    break;
                }
            }
            Fields userActionsRes$Response$RelationList$Fields0 = ((RelationList)object0) == null ? null : ((RelationList)object0).fields;
            if(userActionsRes$Response$RelationList$Fields0 != null) {
                LogU.Companion.i("ArtistDetailHomeFragment", "updateFanAndTemperatureUi() >> isFan: " + userActionsRes$Response$RelationList$Fields0.fan + ", temperature: " + userActionsRes$Response$RelationList$Fields0.temperature);
                ArtistDetailAdapter artistDetailHomeFragment$ArtistDetailAdapter0 = (ArtistDetailAdapter)this.getAdapter();
                if(artistDetailHomeFragment$ArtistDetailAdapter0 != null) {
                    ArtistHomeBasicInfoRes artistHomeBasicInfoRes0 = (ArtistHomeBasicInfoRes)artistDetailHomeFragment$ArtistDetailAdapter0.getResponse();
                    if(artistHomeBasicInfoRes0 != null) {
                        artistHomeBasicInfoRes$RESPONSE0 = artistHomeBasicInfoRes0.response;
                    }
                    if(artistHomeBasicInfoRes$RESPONSE0 != null) {
                        artistHomeBasicInfoRes$RESPONSE0.fanYN = userActionsRes$Response$RelationList$Fields0.fan;
                        artistDetailHomeFragment$ArtistDetailAdapter0.updateFanCmtShareHolder();
                    }
                }
                this.updateTemperatureUi(ProtocolUtils.parseInt(userActionsRes$Response$RelationList$Fields0.temperature, -1), artistTemperatureScoreNoticeRes$RESPONSE0);
                return;
            }
            k k0 = this.headerBinding;
            if(k0 != null) {
                q.f(k0.y, "temperatureLayout");
                k0.y.setVisibility(8);
                return;
            }
            q.m("headerBinding");
            throw null;
        }
        k k1 = this.headerBinding;
        if(k1 != null) {
            q.f(k1.y, "temperatureLayout");
            k1.y.setVisibility(8);
            return;
        }
        q.m("headerBinding");
        throw null;
    }

    private final void updateLayoutMargin(Configuration configuration0) {
        int v2;
        int v1;
        k k0 = this.headerBinding;
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = null;
        if(k0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = k0.l.getLayoutParams();
            int v = 0;
            if(configuration0.orientation == 2) {
                viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(this.getContext(), 260.0f);
                v1 = ScreenUtils.dipToPixel(this.getContext(), 36.0f);
                v2 = ScreenUtils.dipToPixel(this.getContext(), -31.0f);
                k k1 = this.headerBinding;
                if(k1 != null) {
                    k1.i.setMaxLines(1);
                    goto label_21;
                }
                q.m("headerBinding");
                throw null;
            }
            viewGroup$LayoutParams0.height = ScreenUtils.getScreenWidth(this.getContext());
            v2 = ScreenUtils.dipToPixel(this.getContext(), 4.0f);
            k k2 = this.headerBinding;
            if(k2 != null) {
                k2.i.setMaxLines(2);
                v1 = 0;
            label_21:
                k k3 = this.headerBinding;
                if(k3 != null) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = k3.i.getLayoutParams();
                    ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams1 = viewGroup$LayoutParams1 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1) : null;
                    if(viewGroup$MarginLayoutParams1 != null) {
                        viewGroup$MarginLayoutParams1.bottomMargin = v1;
                    }
                    k k4 = this.headerBinding;
                    if(k4 != null) {
                        ViewGroup.LayoutParams viewGroup$LayoutParams2 = k4.u.getLayoutParams();
                        if(viewGroup$LayoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)viewGroup$LayoutParams2;
                        }
                        if(viewGroup$MarginLayoutParams0 != null) {
                            viewGroup$MarginLayoutParams0.topMargin = v2;
                            if(this.hasBillionsClubAlbum && configuration0.orientation == 2) {
                                v = ViewUtilsKt.dpToPx(17.0f);
                            }
                            viewGroup$MarginLayoutParams0.bottomMargin = v;
                        }
                        this.getAdapter().notifyDataSetChanged();
                        return;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
            q.m("headerBinding");
            throw null;
        }
        q.m("headerBinding");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateLikeView(@Nullable Integer integer0, boolean z) {
    }

    private final void updateTemperatureUi(int v, com.iloen.melon.net.v6x.response.ArtistTemperatureScoreNoticeRes.RESPONSE artistTemperatureScoreNoticeRes$RESPONSE0) {
        int v4;
        if(!this.isOwnArtist && v >= 0) {
            int v1 = ResourceUtils.getFriendlyColorId(this.getContext(), v);
            k k0 = this.headerBinding;
            if(k0 != null) {
                k0.z.setText(String.valueOf(v));
                k k1 = this.headerBinding;
                if(k1 != null) {
                    k1.z.setTextColor(v1);
                    k k2 = this.headerBinding;
                    if(k2 != null) {
                        k2.n.setImageResource(ResourceUtils.INSTANCE.get8dpDegreeImageResId(v));
                        k k3 = this.headerBinding;
                        if(k3 != null) {
                            ColorStateList colorStateList0 = ColorStateList.valueOf(v1);
                            k3.x.setImageTintList(colorStateList0);
                            k k4 = this.headerBinding;
                            if(k4 != null) {
                                q.f(k4.y, "temperatureLayout");
                                k4.y.setVisibility(0);
                                StringBuilder stringBuilder0 = new StringBuilder();
                                Context context0 = this.getContext();
                                if(context0 != null) {
                                    stringBuilder0.append(context0.getString(0x7F130C6D, new Object[]{String.valueOf(v)}));  // string:talkback_temperature_degree "친밀도 %1$s도"
                                }
                                k k5 = this.headerBinding;
                                if(k5 != null) {
                                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = k5.y.getLayoutParams();
                                    q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                    int v2 = ScreenUtils.dipToPixel(this.getContext(), 15.0f);
                                    if(q.b((artistTemperatureScoreNoticeRes$RESPONSE0 == null ? null : artistTemperatureScoreNoticeRes$RESPONSE0.scoreNoticeYN), "Y")) {
                                        SCORENOTICEINFO artistTemperatureScoreNoticeRes$RESPONSE$SCORENOTICEINFO0 = artistTemperatureScoreNoticeRes$RESPONSE0.scoreNoticeInfo;
                                        if(artistTemperatureScoreNoticeRes$RESPONSE$SCORENOTICEINFO0 == null) {
                                            return;
                                        }
                                        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).setMargins(0, 0, v2, ScreenUtils.dipToPixel(this.getContext(), -10.0f));
                                        k k6 = this.headerBinding;
                                        if(k6 != null) {
                                            k6.s.setText(artistTemperatureScoreNoticeRes$RESPONSE$SCORENOTICEINFO0.scoreGap);
                                            if(q.b(artistTemperatureScoreNoticeRes$RESPONSE$SCORENOTICEINFO0.isPlus, "Y")) {
                                                k k7 = this.headerBinding;
                                                if(k7 != null) {
                                                    int v3 = ColorUtils.getColor(this.getContext(), 0x7F060447);  // color:pink600s
                                                    k7.s.setTextColor(v3);
                                                    k k8 = this.headerBinding;
                                                    if(k8 != null) {
                                                        k8.s.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DC, 0, 0, 0);  // drawable:ic_common_arrow_up
                                                        v4 = 0x7F130B0D;  // string:talkback_degree_increase "%1$s도 상승"
                                                        goto label_58;
                                                    }
                                                    q.m("headerBinding");
                                                    throw null;
                                                }
                                                q.m("headerBinding");
                                                throw null;
                                            }
                                            k k9 = this.headerBinding;
                                            if(k9 != null) {
                                                int v5 = ColorUtils.getColor(this.getContext(), 0x7F060046);  // color:blue400s_support_high_contrast
                                                k9.s.setTextColor(v5);
                                                k k10 = this.headerBinding;
                                                if(k10 != null) {
                                                    k10.s.setCompoundDrawablesWithIntrinsicBounds(0x7F0803D7, 0, 0, 0);  // drawable:ic_common_arrow_down
                                                    v4 = 0x7F130B0C;  // string:talkback_degree_degrease "%1$s도 하락"
                                                label_58:
                                                    k k11 = this.headerBinding;
                                                    if(k11 != null) {
                                                        q.f(k11.s, "gapTv");
                                                        k11.s.setVisibility(0);
                                                        Context context1 = this.getContext();
                                                        if(context1 == null) {
                                                            goto label_79;
                                                        }
                                                        stringBuilder0.append(", " + context1.getString(v4, new Object[]{artistTemperatureScoreNoticeRes$RESPONSE$SCORENOTICEINFO0.scoreGap}));
                                                        goto label_79;
                                                    }
                                                    q.m("headerBinding");
                                                    throw null;
                                                }
                                                q.m("headerBinding");
                                                throw null;
                                            }
                                            q.m("headerBinding");
                                            throw null;
                                        }
                                        q.m("headerBinding");
                                        throw null;
                                    }
                                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).setMargins(0, 0, v2, 0);
                                    k k12 = this.headerBinding;
                                    if(k12 != null) {
                                        q.f(k12.s, "gapTv");
                                        k12.s.setVisibility(8);
                                    label_79:
                                        if(this.getContext() != null) {
                                            stringBuilder0.append(",  나와의 친밀도 이동");
                                        }
                                        k k13 = this.headerBinding;
                                        if(k13 != null) {
                                            ViewUtils.setContentDescriptionWithButtonClassName(k13.y, stringBuilder0);
                                            return;
                                        }
                                        q.m("headerBinding");
                                        throw null;
                                    }
                                    q.m("headerBinding");
                                    throw null;
                                }
                                q.m("headerBinding");
                                throw null;
                            }
                            q.m("headerBinding");
                            throw null;
                        }
                        q.m("headerBinding");
                        throw null;
                    }
                    q.m("headerBinding");
                    throw null;
                }
                q.m("headerBinding");
                throw null;
            }
            q.m("headerBinding");
            throw null;
        }
        k k14 = this.headerBinding;
        if(k14 != null) {
            q.f(k14.y, "temperatureLayout");
            k14.y.setVisibility(8);
            return;
        }
        q.m("headerBinding");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public boolean useBottomButton() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public boolean useDrawHeaderWhenConfigurationChange() {
        return false;
    }

    public static void v0(ArtistDetailHomeFragment artistDetailHomeFragment0, com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE artistHomeBasicInfoRes$RESPONSE0, View view0) {
        ArtistDetailHomeFragment.drawHeaderView$lambda$17$lambda$16(artistHomeBasicInfoRes$RESPONSE0, artistDetailHomeFragment0, view0);
    }
}

