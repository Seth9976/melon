package com.iloen.melon.fragments.detail;

import Bd.F;
import E9.u;
import F8.I;
import F8.o;
import J8.a3;
import J8.e3;
import J8.m0;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventHighlight;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnClickListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnData;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnInfo;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.OnViewHolderActionListener;
import com.iloen.melon.fragments.comments.CommentLatestList;
import com.iloen.melon.fragments.detail.ui.Gender;
import com.iloen.melon.fragments.detail.ui.GenderInfo;
import com.iloen.melon.fragments.detail.ui.ListeningAge;
import com.iloen.melon.fragments.detail.ui.ListeningUiState;
import com.iloen.melon.fragments.detail.viewholder.CreditHolder;
import com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder;
import com.iloen.melon.fragments.detail.viewholder.DetailCommonContentsHolder.ContentsData;
import com.iloen.melon.fragments.detail.viewholder.DetailCommonContentsHolder;
import com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder;
import com.iloen.melon.fragments.detail.viewholder.LyricHolder.LyricData;
import com.iloen.melon.fragments.detail.viewholder.LyricHolder;
import com.iloen.melon.fragments.detail.viewholder.MagazineHolder;
import com.iloen.melon.fragments.detail.viewholder.OtherSongHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistHolder;
import com.iloen.melon.fragments.detail.viewholder.SongHistoryHolder;
import com.iloen.melon.fragments.detail.viewholder.SongMagazineHolder;
import com.iloen.melon.fragments.detail.viewholder.SongPlaylistHolder;
import com.iloen.melon.fragments.detail.viewholder.SongStationHolder;
import com.iloen.melon.fragments.detail.viewholder.SongTicketHolder;
import com.iloen.melon.fragments.detail.viewholder.SongVideoHolder;
import com.iloen.melon.fragments.detail.viewholder.StReportHolder;
import com.iloen.melon.fragments.detail.viewholder.StationHolder;
import com.iloen.melon.fragments.detail.viewholder.StreamReportUiState;
import com.iloen.melon.fragments.detail.viewholder.TicketHolder;
import com.iloen.melon.fragments.detail.viewholder.VideoHolder;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.SongMoreInfoReq;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v4x.response.SongMoreInfoRes.RESPONSE.TIKTOK;
import com.iloen.melon.net.v4x.response.SongMoreInfoRes;
import com.iloen.melon.net.v6x.request.SongContentsListReq;
import com.iloen.melon.net.v6x.request.SongInfoReq;
import com.iloen.melon.net.v6x.request.SongLyricUpdtMsgCheckReq;
import com.iloen.melon.net.v6x.request.SongPersonalInfoReq;
import com.iloen.melon.net.v6x.response.SongContentsListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongContentsListRes;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.ALBUMINFO;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.SongAchievementInfo;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.StreamReportInfo;
import com.iloen.melon.net.v6x.response.SongInfoRes;
import com.iloen.melon.net.v6x.response.SongLyricUpdtMsgCheckRes;
import com.iloen.melon.net.v6x.response.SongPersonalInfoRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableSong;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.H1;
import com.melon.ui.K1;
import com.melon.ui.c2;
import com.melon.ui.h2;
import com.melon.ui.i2;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.ExtraProperties.Link;
import com.melon.ui.popup.context.more.l;
import com.melon.ui.w1;
import com.melon.ui.x1;
import d3.g;
import ie.H;
import ie.j;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mb.k;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.s;
import v9.i;
import va.e0;
import va.e;
import we.n;
import zd.M;

@Metadata(d1 = {"\u0000\u00D6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00BA\u00012\u00020\u00012\u00020\u0002:\u0006\u00BA\u0001\u00BB\u0001\u00BC\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\u0004J\u000F\u0010\n\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0012J!\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0004J\u000F\u0010\u001E\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0004J\u0017\u0010!\u001A\u00020\b2\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001A\u0004\u0018\u00010#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u001B\u0010)\u001A\u0006\u0012\u0002\b\u00030(2\u0006\u0010\'\u001A\u00020&H\u0014\u00A2\u0006\u0004\b)\u0010*J-\u00101\u001A\u00020\u00052\b\u0010,\u001A\u0004\u0018\u00010+2\b\u0010.\u001A\u0004\u0018\u00010-2\b\u00100\u001A\u0004\u0018\u00010/H\u0014\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020/H\u0016\u00A2\u0006\u0004\b3\u00104J\u000F\u00105\u001A\u00020/H\u0016\u00A2\u0006\u0004\b5\u00104J\u000F\u00106\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b6\u0010\u0004J\u000F\u00107\u001A\u00020/H\u0016\u00A2\u0006\u0004\b7\u00104J\u000F\u00108\u001A\u00020/H\u0016\u00A2\u0006\u0004\b8\u00104J!\u0010;\u001A\u00020\b2\b\u00109\u001A\u0004\u0018\u00010\u001F2\u0006\u0010:\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b;\u0010<J\u0019\u0010?\u001A\u00020\b2\b\u0010>\u001A\u0004\u0018\u00010=H\u0016\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010E\u001A\u00020\b2\u0006\u0010B\u001A\u00020A2\u0006\u0010D\u001A\u00020CH\u0016\u00A2\u0006\u0004\bE\u0010FJ\u0013\u0010H\u001A\u00060GR\u00020\u0001H\u0016\u00A2\u0006\u0004\bH\u0010IJ-\u0010N\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010L2\b\u0010J\u001A\u0004\u0018\u00010/2\b\u0010K\u001A\u0004\u0018\u00010/H\u0014\u00A2\u0006\u0004\bN\u0010OJ\u0019\u0010R\u001A\u00020\b2\b\u0010Q\u001A\u0004\u0018\u00010PH\u0014\u00A2\u0006\u0004\bR\u0010SJ\u0011\u0010U\u001A\u0004\u0018\u00010TH\u0014\u00A2\u0006\u0004\bU\u0010VJ\u000F\u0010W\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\bW\u0010\u0007J\u0017\u0010X\u001A\u00020\b2\u0006\u0010:\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001A\u00020\b2\u0006\u0010[\u001A\u00020ZH\u0007\u00A2\u0006\u0004\b\\\u0010]J\u001F\u0010`\u001A\u00020\b2\u0006\u0010^\u001A\u00020\u001F2\u0006\u0010_\u001A\u00020/H\u0002\u00A2\u0006\u0004\b`\u0010aJ\u000F\u0010b\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bb\u0010\u0004J\u000F\u0010c\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bc\u0010\u0004J\u0011\u0010e\u001A\u0004\u0018\u00010dH\u0002\u00A2\u0006\u0004\be\u0010fJ\u0017\u0010h\u001A\u00020\b2\u0006\u0010g\u001A\u00020dH\u0002\u00A2\u0006\u0004\bh\u0010iJ\u001F\u0010l\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010d0k2\u0006\u0010j\u001A\u00020/H\u0002\u00A2\u0006\u0004\bl\u0010mJ\u001F\u0010o\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010n0k2\u0006\u0010j\u001A\u00020/H\u0002\u00A2\u0006\u0004\bo\u0010mJ\'\u0010r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010q0k2\u0006\u0010j\u001A\u00020/2\u0006\u0010p\u001A\u00020/H\u0002\u00A2\u0006\u0004\br\u0010sJ/\u0010{\u001A\u00020z2\u0006\u0010u\u001A\u00020t2\b\u0010w\u001A\u0004\u0018\u00010v2\f\u0010y\u001A\b\u0012\u0004\u0012\u00020\b0xH\u0002\u00A2\u0006\u0004\b{\u0010|J\u001A\u0010\u007F\u001A\u00020\b2\b\u0010~\u001A\u0004\u0018\u00010}H\u0002\u00A2\u0006\u0005\b\u007F\u0010\u0080\u0001J&\u0010\u0084\u0001\u001A\u0016\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001j\n\u0012\u0005\u0012\u00030\u0082\u0001`\u0083\u0001H\u0002\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0015\u0010\u0087\u0001\u001A\u0005\u0018\u00010\u0086\u0001H\u0002\u00A2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J(\u0010\u008B\u0001\u001A\u00020\b2\t\u0010\u0089\u0001\u001A\u0004\u0018\u00010/2\t\u0010\u008A\u0001\u001A\u0004\u0018\u00010/H\u0002\u00A2\u0006\u0006\b\u008B\u0001\u0010\u008C\u0001R\u0018\u0010\u008E\u0001\u001A\u00030\u008D\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008E\u0001\u0010\u008F\u0001R*\u0010\u0091\u0001\u001A\u00030\u0090\u00018\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001A\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010j\u001A\u00020/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\bj\u0010\u0097\u0001R\u0019\u0010\u0098\u0001\u001A\u00020/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001R\u0019\u0010\u0099\u0001\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009A\u0001R\u001B\u0010\u009B\u0001\u001A\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009B\u0001\u0010\u0097\u0001R\u001C\u0010\u009D\u0001\u001A\u0005\u0018\u00010\u009C\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009D\u0001\u0010\u009E\u0001R\u0019\u0010\u009F\u0001\u001A\u00020/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009F\u0001\u0010\u0097\u0001R\u0018\u0010\u00A1\u0001\u001A\u00030\u00A0\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A1\u0001\u0010\u00A2\u0001R\u0018\u0010\u00A3\u0001\u001A\u00030\u00A0\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A3\u0001\u0010\u00A2\u0001R\u0019\u0010\u00A4\u0001\u001A\u00020\u00158\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u00A4\u0001\u0010\u00A5\u0001R\u001C\u0010\u00A7\u0001\u001A\u0005\u0018\u00010\u00A6\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A7\u0001\u0010\u00A8\u0001R\u001C\u0010\u00AA\u0001\u001A\u0005\u0018\u00010\u00A9\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AA\u0001\u0010\u00AB\u0001R!\u0010\u00B1\u0001\u001A\u00030\u00AC\u00018VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u00AD\u0001\u0010\u00AE\u0001\u001A\u0006\b\u00AF\u0001\u0010\u00B0\u0001R\u0018\u0010\u00B5\u0001\u001A\u00030\u00B2\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00B3\u0001\u0010\u00B4\u0001R\u001A\u0010\u00B9\u0001\u001A\u0005\u0018\u00010\u00B6\u00018BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00B7\u0001\u0010\u00B8\u0001\u00A8\u0006\u00BD\u0001"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailFragment;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "showSpaceViewBottomButtonParallax", "()Z", "Lie/H;", "onStart", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "onAppBarCollapsed", "onAppBarExpended", "", "offset", "onAppBarScrolling", "(I)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "getCacheKey", "()Ljava/lang/String;", "getDetailCacheKey", "updateHeaderView", "getContsId", "getContsTypeCode", "sumCount", "isLike", "updateLikeView", "(Ljava/lang/Integer;Z)V", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "infoCmtContsRes", "updateCommentCountView", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "getOnViewHolderActionListener", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "albumId", "albumName", "", "Lcom/iloen/melon/types/Song;", "onAddSongsToPlaylist", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", "userData", "onAddToNowPlayingList", "(Ljava/lang/Object;)V", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "shouldShowMiniPlayer", "likeClickLog", "(Z)V", "Lcom/iloen/melon/eventbus/EventHighlight;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventHighlight;)V", "popupType", "description", "showGuidePopup", "(ILjava/lang/String;)V", "registerIsLoginFlow", "initHeaderView", "Lcom/iloen/melon/net/v6x/response/SongInfoRes;", "fetchDetailCacheData", "()Lcom/iloen/melon/net/v6x/response/SongInfoRes;", "res", "drawHeaderView", "(Lcom/iloen/melon/net/v6x/response/SongInfoRes;)V", "songId", "Lkotlinx/coroutines/Deferred;", "requestSongInfoAsync", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/SongContentsListRes;", "requestSongContentsListAsync", "adultFlg", "Lcom/iloen/melon/net/v6x/response/SongPersonalInfoRes;", "requestSongPersonalInfoAsync", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE$StreamReportInfo;", "streamReportInfo", "Lcom/iloen/melon/net/v6x/response/SongPersonalInfoRes$RESPONSE;", "personalInfo", "Lkotlin/Function0;", "popupAction", "Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;", "getStreamReportUiState", "(Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE$StreamReportInfo;Lcom/iloen/melon/net/v6x/response/SongPersonalInfoRes$RESPONSE;Lwe/a;)Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;", "Lcom/iloen/melon/net/v4x/response/SongMoreInfoRes;", "response", "setMorePopupData", "(Lcom/iloen/melon/net/v4x/response/SongMoreInfoRes;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "Lkotlin/collections/ArrayList;", "getPlayableFromSongInfoRes", "()Ljava/util/ArrayList;", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "artistId", "artistName", "artistClickLog", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lmb/k;", "loginUseCase", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "setLoginUseCase", "(Lmb/k;)V", "Ljava/lang/String;", "songName", "isLiked", "Z", "likeCnt", "Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;", "songInfoRes", "Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;", "bbsChannelSeq", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "subExceptionHandler", "bottomDivider", "Landroid/view/View;", "Lcom/iloen/melon/custom/CheckableImageView;", "btnLiked", "Lcom/iloen/melon/custom/CheckableImageView;", "Landroid/widget/TextView;", "cntLiked", "Landroid/widget/TextView;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData$delegate", "Lie/j;", "getBottomBtnData", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "LJ8/a3;", "getHeaderBinding", "()LJ8/a3;", "headerBinding", "Companion", "ItemDecoration", "SongDetailAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongDetailFragment extends Hilt_SongDetailFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0007J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailFragment$Companion;", "", "<init>", "()V", "REQUEST_STATUS_SUCCESS", "", "REQUEST_STATUS_FAIL", "POPUP_GUIDE_STREAMING_REPORT", "", "POPUP_GUIDE_SONG_HISTORY", "newInstance", "Lcom/iloen/melon/fragments/detail/SongDetailFragment;", "songId", "showSnsPopup", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongDetailFragment newInstance(@NotNull String s) {
            q.g(s, "songId");
            return this.newInstance(s, false);
        }

        @NotNull
        public final SongDetailFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "songId");
            SongDetailFragment songDetailFragment0 = new SongDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            bundle0.putBoolean("argVisibleSnsPopup", z);
            songDetailFragment0.setArguments(bundle0);
            return songDetailFragment0;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailFragment$ItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "()V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ItemDecoration extends r0 {
        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            Context context0 = view0.getContext();
            int v = recyclerView0.getChildAdapterPosition(view0);
            j0 j00 = recyclerView0.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.SongDetailFragment.SongDetailAdapter");
            if(v == ((SongDetailAdapter)j00).getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(context0, 30.0f);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u00C8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B)\b\u0000\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0018\u00010\u0005\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u000B\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J#\u0010\"\u001A\u00020!2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b\"\u0010#J#\u0010%\u001A\u00020$2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b%\u0010&J#\u0010(\u001A\u00020\'2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b(\u0010)J#\u0010+\u001A\u00020*2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b+\u0010,J#\u0010.\u001A\u00020-2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b.\u0010/J#\u00101\u001A\u0002002\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b1\u00102J#\u00104\u001A\u0002032\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b4\u00105J#\u00107\u001A\u0002062\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b7\u00108J#\u0010:\u001A\u0002092\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b:\u0010;J#\u0010=\u001A\u00020<2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b=\u0010>J#\u0010@\u001A\u00020?2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\b@\u0010AJ#\u0010C\u001A\u00020B2\u0006\u0010\u001B\u001A\u00020\u001A2\n\u0010\u001D\u001A\u00060\u001CR\u00020\u0002H\u0016\u00A2\u0006\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\n8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001A\u00020\u000F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bG\u0010HR\"\u0010J\u001A\u00020I8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001A\u00020I8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bP\u0010K\u001A\u0004\bQ\u0010M\"\u0004\bR\u0010O\u00A8\u0006S"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailFragment$SongDetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Landroid/content/Context;", "context", "", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/SongDetailFragment;Landroid/content/Context;Ljava/util/List;)V", "Lcom/iloen/melon/net/v6x/response/SongContentsListRes$RESPONSE;", "response", "Lie/H;", "setSongContentsListRes", "(Lcom/iloen/melon/net/v6x/response/SongContentsListRes$RESPONSE;)V", "Lcom/iloen/melon/net/v6x/response/SongPersonalInfoRes$RESPONSE;", "setSongPersonalInfoRes", "(Lcom/iloen/melon/net/v6x/response/SongPersonalInfoRes$RESPONSE;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "Landroid/view/ViewGroup;", "parent", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder;", "getCommonContentsHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;", "getLyricHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "getVideoHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "getMagazineHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "getStationHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "getPlaylistHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder;", "getTicketHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryHolder;", "getSongHistoryHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder;", "getCreditHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/StReportHolder;", "getStReportHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/StReportHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder;", "getOtherSongHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "getCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "getEmptyCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "songContentsListRes", "Lcom/iloen/melon/net/v6x/response/SongContentsListRes$RESPONSE;", "songPersonalInfoRes", "Lcom/iloen/melon/net/v6x/response/SongPersonalInfoRes$RESPONSE;", "", "commonContentsViewPos", "I", "getCommonContentsViewPos", "()I", "setCommonContentsViewPos", "(I)V", "lyricViewPos", "getLyricViewPos", "setLyricViewPos", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class SongDetailAdapter extends DetailAdapter {
        private int commonContentsViewPos;
        private int lyricViewPos;
        private RESPONSE songContentsListRes;
        private com.iloen.melon.net.v6x.response.SongPersonalInfoRes.RESPONSE songPersonalInfoRes;

        public SongDetailAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.commonContentsViewPos = -1;
            this.lyricViewPos = -1;
        }

        public static H g(SongDetailFragment songDetailFragment0, com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0) {
            return SongDetailAdapter.handleResponse$lambda$2(songDetailFragment0, songInfoRes$RESPONSE0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public DetailCommentItemHolder getCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return DetailCommentItemHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public DetailCommonContentsHolder getCommonContentsHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return DetailCommonContentsHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        public final int getCommonContentsViewPos() {
            return this.commonContentsViewPos;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public CreditHolder getCreditHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return CreditHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public EmptyCommentHolder getEmptyCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder.Companion.newInstance$default(EmptyCommentHolder.Companion, viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0, false, 4, null);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public LyricHolder getLyricHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return LyricHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        public final int getLyricViewPos() {
            return this.lyricViewPos;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public MagazineHolder getMagazineHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongMagazineHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public OtherSongHolder getOtherSongHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return OtherSongHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistHolder getPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongPlaylistHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public SongHistoryHolder getSongHistoryHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongHistoryHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public StReportHolder getStReportHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return StReportHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public StationHolder getStationHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongStationHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public TicketHolder getTicketHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongTicketHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public VideoHolder getVideoHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongVideoHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        public static H h(SongDetailFragment songDetailFragment0, com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0) {
            return SongDetailAdapter.handleResponse$lambda$3(songDetailFragment0, songInfoRes$RESPONSE0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            String s2;
            boolean z;
            String s1;
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            if(httpResponse0 instanceof SongInfoRes) {
                ArrayList arrayList0 = new ArrayList();
                com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = ((SongInfoRes)httpResponse0).response;
                if(songInfoRes$RESPONSE0 != null) {
                    this.setMenuId(songInfoRes$RESPONSE0.menuId);
                    this.setHasMore(false);
                    this.updateModifiedTime(s);
                    if(songInfoRes$RESPONSE0.songInfo != null) {
                        ContentsData detailCommonContentsHolder$ContentsData0 = new ContentsData(null, false, null, null, 15, null);
                        detailCommonContentsHolder$ContentsData0.setSongInfo(songInfoRes$RESPONSE0);
                        detailCommonContentsHolder$ContentsData0.setLiked(SongDetailFragment.this.isLiked);
                        detailCommonContentsHolder$ContentsData0.setLikeCnt(SongDetailFragment.this.likeCnt);
                        detailCommonContentsHolder$ContentsData0.setCommentInfo(SongDetailFragment.this.getInformCmt());
                        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                        a0.a = 41;
                        a0.b = detailCommonContentsHolder$ContentsData0;
                        a0.e = SongDetailFragment.this.songId;
                        a0.c = this.getMenuId();
                        arrayList0.add(new AdapterInViewHolder.Row(a0));
                        this.commonContentsViewPos = arrayList0.size() - 1;
                        if(SongDetailFragment.this.isLoginUser()) {
                            com.iloen.melon.net.v6x.response.SongPersonalInfoRes.RESPONSE songPersonalInfoRes$RESPONSE0 = this.songPersonalInfoRes;
                            if(songPersonalInfoRes$RESPONSE0 == null) {
                                goto label_36;
                            }
                            else {
                                s1 = songPersonalInfoRes$RESPONSE0.highlightLine;
                                q.f(s1, "highlightLine");
                                com.iloen.melon.net.v6x.response.SongPersonalInfoRes.RESPONSE songPersonalInfoRes$RESPONSE1 = this.songPersonalInfoRes;
                                if(songPersonalInfoRes$RESPONSE1 != null) {
                                    z = songPersonalInfoRes$RESPONSE1.isLyricUpdate;
                                    s2 = songPersonalInfoRes$RESPONSE1.lyricUpdateMsg;
                                    q.f(s2, "lyricUpdateMsg");
                                    goto label_39;
                                }
                                q.m("songPersonalInfoRes");
                                throw null;
                            }
                        }
                        else {
                        label_36:
                            s1 = "";
                            z = false;
                            s2 = "";
                        }
                    label_39:
                        LyricData lyricHolder$LyricData0 = new LyricData(null, null, null, false, 15, null);
                        lyricHolder$LyricData0.setSongInfoRes(songInfoRes$RESPONSE0);
                        lyricHolder$LyricData0.setHighlightLine(s1);
                        lyricHolder$LyricData0.setLyricUpdateMsg(s2);
                        lyricHolder$LyricData0.setLyricUpdate(z);
                        a a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                        a1.a = 10;
                        a1.b = lyricHolder$LyricData0;
                        a1.e = SongDetailFragment.this.songId;
                        a1.c = this.getMenuId();
                        arrayList0.add(new AdapterInViewHolder.Row(a1));
                        this.lyricViewPos = arrayList0.size() - 1;
                    }
                    a a2 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a2.a = 11;
                    a2.b = songInfoRes$RESPONSE0;
                    a2.e = SongDetailFragment.this.songId;
                    a2.c = this.getMenuId();
                    l1.z(a2, arrayList0);
                    String s3 = songInfoRes$RESPONSE0.cPlanCode;
                    q.f(s3, "cPlanCode");
                    if(CPlan.Companion.isNormal(s3)) {
                        StreamReportInfo songInfoRes$RESPONSE$StreamReportInfo0 = songInfoRes$RESPONSE0.streamReportInfo;
                        if(songInfoRes$RESPONSE$StreamReportInfo0 != null) {
                            com.iloen.melon.net.v6x.response.SongPersonalInfoRes.RESPONSE songPersonalInfoRes$RESPONSE2 = this.songPersonalInfoRes == null ? null : this.songPersonalInfoRes;
                            P p0 = new P(0, SongDetailFragment.this, songInfoRes$RESPONSE0);
                            a a3 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a3.a = 45;
                            a3.b = SongDetailFragment.this.getStreamReportUiState(songInfoRes$RESPONSE$StreamReportInfo0, songPersonalInfoRes$RESPONSE2, p0);
                            a3.e = SongDetailFragment.this.songId;
                            a3.c = this.getMenuId();
                            l1.z(a3, arrayList0);
                        }
                        SongAchievementInfo songInfoRes$RESPONSE$SongAchievementInfo0 = songInfoRes$RESPONSE0.songAchievementInfo;
                        if(songInfoRes$RESPONSE$SongAchievementInfo0 != null) {
                            P p1 = new P(1, SongDetailFragment.this, songInfoRes$RESPONSE0);
                            a a4 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a4.a = 43;
                            a4.b = SongDetailFragmentKt.toSongHistoryUiState(songInfoRes$RESPONSE$SongAchievementInfo0, p1);
                            a4.e = SongDetailFragment.this.songId;
                            a4.c = this.getMenuId();
                            l1.z(a4, arrayList0);
                        }
                    }
                    else {
                        LogU.warn$default(SongDetailFragment.this.log, "handleResponse() CPlan: " + songInfoRes$RESPONSE0.cPlanCode, null, false, 6, null);
                    }
                    RESPONSE songContentsListRes$RESPONSE0 = this.songContentsListRes;
                    if(songContentsListRes$RESPONSE0 != null) {
                        if(songContentsListRes$RESPONSE0.otherVersionSongList != null && !songContentsListRes$RESPONSE0.otherVersionSongList.isEmpty() == 1) {
                            a a5 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a5.a = 0x2F;
                            RESPONSE songContentsListRes$RESPONSE1 = this.songContentsListRes;
                            if(songContentsListRes$RESPONSE1 != null) {
                                a5.b = songContentsListRes$RESPONSE1.otherVersionSongList;
                                a5.e = SongDetailFragment.this.songId;
                                RESPONSE songContentsListRes$RESPONSE2 = this.songContentsListRes;
                                if(songContentsListRes$RESPONSE2 != null) {
                                    a5.g = songContentsListRes$RESPONSE2.otherVersionAllButtonFlag;
                                    a5.c = SongDetailFragment.this.mMenuId;
                                    l1.z(a5, arrayList0);
                                    goto label_100;
                                }
                                q.m("songContentsListRes");
                                throw null;
                            }
                            q.m("songContentsListRes");
                            throw null;
                        }
                    label_100:
                        RESPONSE songContentsListRes$RESPONSE3 = this.songContentsListRes;
                        if(songContentsListRes$RESPONSE3 == null) {
                            q.m("songContentsListRes");
                            throw null;
                        }
                        if(songContentsListRes$RESPONSE3.similarSongList != null && !songContentsListRes$RESPONSE3.similarSongList.isEmpty() == 1) {
                            a a6 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a6.a = 46;
                            RESPONSE songContentsListRes$RESPONSE4 = this.songContentsListRes;
                            if(songContentsListRes$RESPONSE4 != null) {
                                a6.b = songContentsListRes$RESPONSE4.similarSongList;
                                a6.e = SongDetailFragment.this.songId;
                                RESPONSE songContentsListRes$RESPONSE5 = this.songContentsListRes;
                                if(songContentsListRes$RESPONSE5 != null) {
                                    a6.g = songContentsListRes$RESPONSE5.similarAllButtonFlag;
                                    a6.c = SongDetailFragment.this.mMenuId;
                                    l1.z(a6, arrayList0);
                                    goto label_119;
                                }
                                q.m("songContentsListRes");
                                throw null;
                            }
                            q.m("songContentsListRes");
                            throw null;
                        }
                    label_119:
                        RESPONSE songContentsListRes$RESPONSE6 = this.songContentsListRes;
                        if(songContentsListRes$RESPONSE6 == null) {
                            q.m("songContentsListRes");
                            throw null;
                        }
                        if(songContentsListRes$RESPONSE6.mvList != null && !songContentsListRes$RESPONSE6.mvList.isEmpty() == 1) {
                            a a7 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a7.a = 3;
                            RESPONSE songContentsListRes$RESPONSE7 = this.songContentsListRes;
                            if(songContentsListRes$RESPONSE7 != null) {
                                a7.b = songContentsListRes$RESPONSE7.mvList;
                                a7.e = SongDetailFragment.this.songId;
                                RESPONSE songContentsListRes$RESPONSE8 = this.songContentsListRes;
                                if(songContentsListRes$RESPONSE8 != null) {
                                    a7.g = songContentsListRes$RESPONSE8.mvAllButtonFlag;
                                    a7.c = SongDetailFragment.this.mMenuId;
                                    l1.z(a7, arrayList0);
                                    goto label_138;
                                }
                                q.m("songContentsListRes");
                                throw null;
                            }
                            q.m("songContentsListRes");
                            throw null;
                        }
                    label_138:
                        RESPONSE songContentsListRes$RESPONSE9 = this.songContentsListRes;
                        if(songContentsListRes$RESPONSE9 == null) {
                            q.m("songContentsListRes");
                            throw null;
                        }
                        if(songContentsListRes$RESPONSE9.magazineList != null && !songContentsListRes$RESPONSE9.magazineList.isEmpty() == 1) {
                            a a8 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a8.a = 5;
                            RESPONSE songContentsListRes$RESPONSE10 = this.songContentsListRes;
                            if(songContentsListRes$RESPONSE10 != null) {
                                a8.b = songContentsListRes$RESPONSE10.magazineList;
                                a8.e = SongDetailFragment.this.songId;
                                RESPONSE songContentsListRes$RESPONSE11 = this.songContentsListRes;
                                if(songContentsListRes$RESPONSE11 != null) {
                                    a8.g = songContentsListRes$RESPONSE11.magazineAllButtonFlag;
                                    a8.c = SongDetailFragment.this.mMenuId;
                                    l1.z(a8, arrayList0);
                                    goto label_157;
                                }
                                q.m("songContentsListRes");
                                throw null;
                            }
                            q.m("songContentsListRes");
                            throw null;
                        }
                    label_157:
                        RESPONSE songContentsListRes$RESPONSE12 = this.songContentsListRes;
                        if(songContentsListRes$RESPONSE12 == null) {
                            q.m("songContentsListRes");
                            throw null;
                        }
                        if(songContentsListRes$RESPONSE12.PLAYLISTList != null && !songContentsListRes$RESPONSE12.PLAYLISTList.isEmpty() == 1) {
                            a a9 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a9.a = 6;
                            RESPONSE songContentsListRes$RESPONSE13 = this.songContentsListRes;
                            if(songContentsListRes$RESPONSE13 != null) {
                                a9.b = songContentsListRes$RESPONSE13.PLAYLISTList;
                                a9.e = SongDetailFragment.this.songId;
                                RESPONSE songContentsListRes$RESPONSE14 = this.songContentsListRes;
                                if(songContentsListRes$RESPONSE14 != null) {
                                    a9.g = songContentsListRes$RESPONSE14.djplaylistAllButtonFlag;
                                    a9.c = SongDetailFragment.this.mMenuId;
                                    l1.z(a9, arrayList0);
                                    goto label_176;
                                }
                                q.m("songContentsListRes");
                                throw null;
                            }
                            q.m("songContentsListRes");
                            throw null;
                        }
                    label_176:
                        RESPONSE songContentsListRes$RESPONSE15 = this.songContentsListRes;
                        if(songContentsListRes$RESPONSE15 == null) {
                            q.m("songContentsListRes");
                            throw null;
                        }
                        if(songContentsListRes$RESPONSE15.stationList != null && !songContentsListRes$RESPONSE15.stationList.isEmpty() == 1) {
                            a a10 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a10.a = 7;
                            RESPONSE songContentsListRes$RESPONSE16 = this.songContentsListRes;
                            if(songContentsListRes$RESPONSE16 != null) {
                                a10.b = songContentsListRes$RESPONSE16.stationList;
                                a10.e = SongDetailFragment.this.songId;
                                RESPONSE songContentsListRes$RESPONSE17 = this.songContentsListRes;
                                if(songContentsListRes$RESPONSE17 != null) {
                                    a10.g = songContentsListRes$RESPONSE17.stationAllButtonFlag;
                                    a10.c = SongDetailFragment.this.mMenuId;
                                    l1.z(a10, arrayList0);
                                    goto label_195;
                                }
                                q.m("songContentsListRes");
                                throw null;
                            }
                            q.m("songContentsListRes");
                            throw null;
                        }
                    label_195:
                        RESPONSE songContentsListRes$RESPONSE18 = this.songContentsListRes;
                        if(songContentsListRes$RESPONSE18 == null) {
                            q.m("songContentsListRes");
                            throw null;
                        }
                        else if(songContentsListRes$RESPONSE18.ticketList != null && !songContentsListRes$RESPONSE18.ticketList.isEmpty() == 1) {
                            a a11 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                            a11.a = 8;
                            RESPONSE songContentsListRes$RESPONSE19 = this.songContentsListRes;
                            if(songContentsListRes$RESPONSE19 != null) {
                                a11.b = songContentsListRes$RESPONSE19.ticketList;
                                a11.e = SongDetailFragment.this.songId;
                                a11.c = SongDetailFragment.this.mMenuId;
                                l1.z(a11, arrayList0);
                                this.addAll(arrayList0);
                                return true;
                            }
                            q.m("songContentsListRes");
                            throw null;
                        }
                    }
                    this.addAll(arrayList0);
                }
            }
            return true;
        }

        private static final H handleResponse$lambda$2(SongDetailFragment songDetailFragment0, com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0) {
            songDetailFragment0.showGuidePopup(0, (songInfoRes$RESPONSE0.streamReportInfo.guide == null ? "" : songInfoRes$RESPONSE0.streamReportInfo.guide));
            return H.a;
        }

        private static final H handleResponse$lambda$3(SongDetailFragment songDetailFragment0, com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0) {
            songDetailFragment0.showGuidePopup(1, (songInfoRes$RESPONSE0.songAchievementInfo.guide == null ? "" : songInfoRes$RESPONSE0.songAchievementInfo.guide));
            return H.a;
        }

        public final void setCommonContentsViewPos(int v) {
            this.commonContentsViewPos = v;
        }

        public final void setLyricViewPos(int v) {
            this.lyricViewPos = v;
        }

        public final void setSongContentsListRes(@NotNull RESPONSE songContentsListRes$RESPONSE0) {
            q.g(songContentsListRes$RESPONSE0, "response");
            this.songContentsListRes = songContentsListRes$RESPONSE0;
        }

        public final void setSongPersonalInfoRes(@NotNull com.iloen.melon.net.v6x.response.SongPersonalInfoRes.RESPONSE songPersonalInfoRes$RESPONSE0) {
            q.g(songPersonalInfoRes$RESPONSE0, "response");
            this.songPersonalInfoRes = songPersonalInfoRes$RESPONSE0;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[24] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[25] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[27] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[58] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int POPUP_GUIDE_SONG_HISTORY = 1;
    private static final int POPUP_GUIDE_STREAMING_REPORT = 0;
    @NotNull
    public static final String REQUEST_STATUS_FAIL = "0";
    @NotNull
    public static final String REQUEST_STATUS_SUCCESS = "1";
    @NotNull
    private String bbsChannelSeq;
    @NotNull
    private final j bottomBtnData$delegate;
    private View bottomDivider;
    @Nullable
    private CheckableImageView btnLiked;
    @Nullable
    private TextView cntLiked;
    private boolean isLiked;
    @Nullable
    private String likeCnt;
    @NotNull
    private final LogU log;
    @Inject
    public k loginUseCase;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    @NotNull
    private String songId;
    @Nullable
    private com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes;
    @NotNull
    private String songName;
    @NotNull
    private final CoroutineExceptionHandler subExceptionHandler;

    static {
        SongDetailFragment.Companion = new Companion(null);
        SongDetailFragment.$stable = 8;
    }

    public SongDetailFragment() {
        this.log = LogU.Companion.create("SongDetailFragment", true, Category.UI);
        this.songId = "";
        this.songName = "";
        this.bbsChannelSeq = "";
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.SongDetailFragment.mainExceptionHandler.1.1(throwable0, SongDetailFragment.this, null), 3, null);
            }
        };
        this.subExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                LogU.debug$default(SongDetailFragment.access$getLog$p(SongDetailFragment.this), e.b("subExceptionHandler message = ", throwable0.getMessage()), null, false, 6, null);
            }
        };
        this.bottomBtnData$delegate = g.Q(new b(this, 6));

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/iloen/melon/fragments/detail/SongDetailFragment$bottomBtnData$2$1", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "Lie/H;", "onAddSongClick", "()V", "onPlaySongClick", "onMixUpPlayClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.detail.SongDetailFragment.bottomBtnData.2.1 implements BottomBtnClickListener {
            public com.iloen.melon.fragments.detail.SongDetailFragment.bottomBtnData.2.1(SongDetailFragment songDetailFragment0) {
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onAddSongClick() {
                SongDetailFragment.this.showContextMenuAddTo();
                if(SongDetailFragment.this.getContext() != null) {
                    f f0 = SongDetailFragment.access$getTiaraEventBuilder(SongDetailFragment.this);
                    if(f0 != null) {
                        f0.a = "선택";
                        f0.d = ActionKind.ClickContent;
                        f0.y = "곡정보";
                        f0.F = "곡담기";
                        f0.a().track();
                    }
                }
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onMixUpPlayClick() {
                com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = SongDetailFragment.this.songInfoRes;
                if(songInfoRes$RESPONSE0 != null) {
                    SongInfoBase songInfoBase0 = songInfoRes$RESPONSE0.songInfo;
                    if(songInfoBase0 != null) {
                        SongDetailFragment songDetailFragment0 = SongDetailFragment.this;
                        String s = songDetailFragment0.getMenuId();
                        String s1 = songInfoBase0.songId;
                        String s2 = "";
                        if(s1 == null) {
                            s1 = "";
                        }
                        String s3 = "음악재생";
                        songDetailFragment0.playMixUp(s, new pc.l1(s1, (songInfoBase0.songName == null ? "" : songInfoBase0.songName), songInfoBase0.getArtistId(), songDetailFragment0.getStatsElements()));
                        f f0 = songDetailFragment0.getTiaraEventBuilder();
                        if(f0 != null) {
                            if(songDetailFragment0.getContext() == null) {
                                s3 = "";
                            }
                            String s4 = "곡정보";
                            f0.a = s3;
                            f0.d = ActionKind.PlayMusic;
                            if(songDetailFragment0.getContext() == null) {
                                s4 = "";
                            }
                            f0.y = s4;
                            if(songDetailFragment0.getContext() != null) {
                                s2 = "믹스업";
                            }
                            f0.F = s2;
                            f0.e = songDetailFragment0.getContsId();
                            f0.f = Y.i(ContsTypeCode.SONG_MIXUP, "code(...)");
                            f0.g = songDetailFragment0.songName;
                            f0.W = "1000003099";
                            f0.a().track();
                        }
                    }
                }
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlayAllSongClick() {
                BottomBtnClickListener.super.onPlayAllSongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlaySongClick() {
                com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = SongDetailFragment.access$getSongInfoRes$p(SongDetailFragment.this);
                if(songInfoRes$RESPONSE0 != null) {
                    SongDetailFragment songDetailFragment0 = SongDetailFragment.this;
                    songDetailFragment0.playSong(Playable.from(songInfoRes$RESPONSE0.songInfo, songDetailFragment0.getMenuId(), null), true);
                    f f0 = SongDetailFragment.access$getTiaraEventBuilder(songDetailFragment0);
                    if(f0 != null) {
                        String s = "음악재생";
                        String s1 = "";
                        if(songDetailFragment0.getContext() == null) {
                            s = "";
                        }
                        String s2 = "곡정보";
                        f0.a = s;
                        f0.d = ActionKind.PlayMusic;
                        if(songDetailFragment0.getContext() == null) {
                            s2 = "";
                        }
                        f0.y = s2;
                        if(songDetailFragment0.getContext() != null) {
                            s1 = "곡재생";
                        }
                        f0.F = s1;
                        f0.a().track();
                    }
                }
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onShuffleSongClick() {
                BottomBtnClickListener.super.onShuffleSongClick();
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.detail.SongDetailFragment$mainExceptionHandler$1$1", f = "SongDetailFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.SongDetailFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.SongDetailFragment.mainExceptionHandler.1.1(Throwable throwable0, SongDetailFragment songDetailFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                SongDetailFragment.this = songDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.SongDetailFragment.mainExceptionHandler.1.1(this.$throwable, SongDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.SongDetailFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    LogU.debug$default(SongDetailFragment.access$getLog$p(SongDetailFragment.this), e.b("mainExceptionHandler message = ", this.$throwable.getMessage()), null, false, 6, null);
                    SongDetailFragment.this.showNetworkErrorHeaderView(true);
                    SongDetailFragment.access$getMResponseErrorListener$p$s690352726(SongDetailFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s690352726(SongDetailFragment songDetailFragment0) {
        return songDetailFragment0.mResponseErrorListener;
    }

    private final void artistClickLog(String s, String s1) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s2 = "페이지이동";
            String s3 = "";
            if(this.getContext() == null) {
                s2 = "";
            }
            String s4 = "곡정보";
            f0.a = s2;
            f0.d = ActionKind.ClickContent;
            if(this.getContext() == null) {
                s4 = "";
            }
            f0.y = s4;
            f0.e = s;
            if(this.getContext() != null) {
                s3 = "아티스트";
            }
            f0.f = s3;
            f0.g = s1;
            f0.a().track();
        }
    }

    private static final BottomBtnData bottomBtnData_delegate$lambda$2(SongDetailFragment songDetailFragment0) {
        return new BottomBtnData(10.0f, e.k.e(new BottomBtnInfo[]{new BottomBtnInfo(10003, 0.0f, null, 4, null), new BottomBtnInfo(10000, 0.0f, null, 4, null), new BottomBtnInfo(10004, 0.0f, null, 4, null)}), new com.iloen.melon.fragments.detail.SongDetailFragment.bottomBtnData.2.1(songDetailFragment0));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new SongDetailAdapter(this, context0, null);
    }

    private final void drawHeaderView(SongInfoRes songInfoRes0) {
        String s;
        com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = songInfoRes0.response;
        if(songInfoRes$RESPONSE0 != null) {
            a3 a30 = this.getHeaderBinding();
            if(a30 != null) {
                RelativeLayout relativeLayout0 = a30.c;
                MelonTextView melonTextView0 = a30.i;
                MelonImageView melonImageView0 = a30.d;
                ImageView imageView0 = a30.e;
                e3 e30 = a30.f;
                e3 e31 = a30.g;
                e3 e32 = a30.h;
                int v = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
                ViewUtils.setDefaultImage(e30.c, v, true);
                int v1 = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
                ViewUtils.setDefaultImage(e31.c, v1, true);
                int v2 = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
                ViewUtils.setDefaultImage(e32.c, v2, true);
                int v3 = 8;
                if(!MediaCodecInfoCompat.isAc4Supported() || !songInfoRes$RESPONSE0.isDolbyAtmos) {
                    imageView0.setVisibility(8);
                }
                else {
                    imageView0.setVisibility(0);
                }
                SongInfoBase songInfoBase0 = songInfoRes$RESPONSE0.songInfo;
                if(songInfoBase0 != null) {
                    this.bottomButtonEnable(songInfoBase0.canService);
                    Glide.with(melonImageView0).load(songInfoBase0.albumImg).into(melonImageView0);
                    ViewUtils.setOnClickListener(melonImageView0, new h(4, songInfoRes$RESPONSE0, songInfoBase0));
                    this.songName = songInfoBase0.songName == null ? "" : songInfoBase0.songName;
                    melonTextView0.setText(songInfoBase0.albumName);
                    if(this.songName.length() == 0) {
                        relativeLayout0.setVisibility(8);
                    }
                    else {
                        relativeLayout0.setVisibility(0);
                        this.setDescText(this.songName, "N10001");
                    }
                    MelonTextView melonTextView1 = a30.k;
                    if(songInfoBase0.isFlacAvail) {
                        v3 = 0;
                    }
                    melonTextView1.setVisibility(v3);
                    ViewUtils.setOnClickListener(melonTextView0, new N(0, this, songInfoRes$RESPONSE0));
                }
                if(songInfoRes$RESPONSE0.artistList != null && !songInfoRes$RESPONSE0.artistList.isEmpty()) {
                    if(songInfoRes$RESPONSE0.artistList.size() == 2) {
                        Context context0 = this.getContext();
                        s = MelonDetailInfoUtils.INSTANCE.getNamesFormat(context0, songInfoRes$RESPONSE0.artistList);
                    }
                    else {
                        Context context1 = this.getContext();
                        s = MelonDetailInfoUtils.INSTANCE.getArtistFormat(context1, songInfoRes$RESPONSE0.artistList);
                    }
                    a30.j.setText(s);
                    ArrayList arrayList0 = songInfoRes$RESPONSE0.artistList;
                    q.f(arrayList0, "artistList");
                    int v4 = 0;
                    for(Object object0: arrayList0) {
                        if(v4 >= 0) {
                            if(v4 == 0) {
                                Glide.with(e30.b).load(((ArtistInfoBase)object0).getArtistImg()).apply(RequestOptions.circleCropTransform()).into(e30.b);
                            }
                            if(v4 == 1) {
                                e31.a.setVisibility(0);
                                Glide.with(e31.b).load(((ArtistInfoBase)object0).getArtistImg()).apply(RequestOptions.circleCropTransform()).into(e31.b);
                            }
                            if(v4 == 2) {
                                e32.a.setVisibility(0);
                                Glide.with(e32.b).load(((ArtistInfoBase)object0).getArtistImg()).apply(RequestOptions.circleCropTransform()).into(e32.b);
                            }
                            ++v4;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    N n0 = new N(1, this, songInfoRes$RESPONSE0);
                    ViewUtils.setOnClickListener(a30.b, n0);
                }
            }
        }
    }

    private static final void drawHeaderView$lambda$21$lambda$11(com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0, SongInfoBase songInfoBase0, View view0) {
        String s;
        ALBUMINFO songInfoRes$RESPONSE$ALBUMINFO0 = songInfoRes$RESPONSE0.albumInfo;
        if(songInfoRes$RESPONSE$ALBUMINFO0 == null) {
            s = "";
        }
        else {
            s = songInfoRes$RESPONSE$ALBUMINFO0.albumImgLarge;
            if(s == null) {
                s = "";
            }
        }
        if(s.length() > 0) {
            Navigator.INSTANCE.openPhotoUrlWithTitle(s, songInfoBase0.albumName);
        }
    }

    private static final void drawHeaderView$lambda$21$lambda$13(com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0, SongDetailFragment songDetailFragment0, View view0) {
        String s4;
        String s1;
        ALBUMINFO songInfoRes$RESPONSE$ALBUMINFO0 = songInfoRes$RESPONSE0.albumInfo;
        String s = "";
        if(songInfoRes$RESPONSE$ALBUMINFO0 == null) {
            s1 = "";
        }
        else {
            s1 = songInfoRes$RESPONSE$ALBUMINFO0.albumId;
            if(s1 == null) {
                s1 = "";
            }
        }
        String s2 = "페이지이동";
        Navigator.openAlbumInfo(s1);
        f f0 = songDetailFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(songDetailFragment0.getContext() == null) {
                s2 = "";
            }
            String s3 = "곡정보";
            f0.a = s2;
            f0.d = ActionKind.ClickContent;
            if(songDetailFragment0.getContext() == null) {
                s3 = "";
            }
            f0.y = s3;
            ALBUMINFO songInfoRes$RESPONSE$ALBUMINFO1 = songInfoRes$RESPONSE0.albumInfo;
            if(songInfoRes$RESPONSE$ALBUMINFO1 == null) {
                s4 = "";
            }
            else {
                s4 = songInfoRes$RESPONSE$ALBUMINFO1.albumId;
                if(s4 == null) {
                    s4 = "";
                }
            }
            String s5 = "앨범";
            f0.e = s4;
            if(songDetailFragment0.getContext() == null) {
                s5 = "";
            }
            f0.f = s5;
            ALBUMINFO songInfoRes$RESPONSE$ALBUMINFO2 = songInfoRes$RESPONSE0.albumInfo;
            if(songInfoRes$RESPONSE$ALBUMINFO2 != null) {
                String s6 = songInfoRes$RESPONSE$ALBUMINFO2.albumName;
                if(s6 != null) {
                    s = s6;
                }
            }
            f0.g = s;
            f0.a().track();
        }
    }

    private static final void drawHeaderView$lambda$21$lambda$20(com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0, SongDetailFragment songDetailFragment0, View view0) {
        if(songInfoRes$RESPONSE0.artistList.size() > 1) {
            l0 l00 = songDetailFragment0.getChildFragmentManager();
            String s = Cb.i.k(songDetailFragment0, 0x7F130111);  // string:artist_channel_popup_artist_list_title "아티스트 선택"
            ArrayList arrayList0 = songInfoRes$RESPONSE0.artistList;
            q.f(arrayList0, "artistList");
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object0: arrayList0) {
                arrayList1.add(new m(((ArtistInfoBase)object0).getArtistId(), ((ArtistInfoBase)object0).getArtistName()));
            }
            com.melon.ui.popup.b.e(l00, s, arrayList1, 1, null, new com.iloen.melon.fragments.detail.f(songDetailFragment0, 4));
            return;
        }
        if(songInfoRes$RESPONSE0.artistList.size() == 1) {
            String s1 = ((ArtistInfoBase)songInfoRes$RESPONSE0.artistList.get(0)).getArtistId();
            String s2 = ((ArtistInfoBase)songInfoRes$RESPONSE0.artistList.get(0)).getArtistName();
            songDetailFragment0.showArtistInfoPage(s1);
            songDetailFragment0.artistClickLog(s1, s2);
        }
    }

    private static final H drawHeaderView$lambda$21$lambda$20$lambda$19(SongDetailFragment songDetailFragment0, xd.h h0) {
        q.g(h0, "action");
        if(h0 instanceof xd.g) {
            Navigator.openArtistInfo(((xd.g)h0).b);
            songDetailFragment0.artistClickLog(((xd.g)h0).b, ((xd.g)h0).c);
        }
        return H.a;
    }

    private final SongInfoRes fetchDetailCacheData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.getDetailCacheKey());
        if(cursor0 == null) {
            return null;
        }
        SongInfoRes songInfoRes0 = (SongInfoRes)com.iloen.melon.responsecache.a.d(cursor0, SongInfoRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        return songInfoRes0 == null ? null : songInfoRes0;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public BottomBtnData getBottomBtnData() {
        return (BottomBtnData)this.bottomBtnData$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.d.buildUpon(), this.songId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsId() {
        return this.songId;
    }

    // 去混淆评级： 低(30)
    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsTypeCode() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.detail.Hilt_SongDetailFragment, kotlinx.coroutines.CoroutineScope
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getDetailCacheKey() {
        return l1.e(MelonContentUris.d.buildUpon(), this.songId, "toString(...)");
    }

    private final a3 getHeaderBinding() {
        return (a3)this.get_headerBinding();
    }

    @NotNull
    public final k getLoginUseCase() {
        k k0 = this.loginUseCase;
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
            public static void a(Object object0) {
                com.iloen.melon.fragments.detail.SongDetailFragment.getOnViewHolderActionListener.1.onLyricUpdateMsgListener$lambda$0(object0);
            }

            public static void b(VolleyError volleyError0) {
                com.iloen.melon.fragments.detail.SongDetailFragment.getOnViewHolderActionListener.1.onLyricUpdateMsgListener$lambda$1(volleyError0);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onDownloadSong() {
                String s = SongDetailFragment.this.getMenuId();
                ArrayList arrayList0 = SongDetailFragment.this.getPlayableFromSongInfoRes();
                SongDetailFragment.this.downloadSongs(s, arrayList0);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onLikedListener(CheckableImageView checkableImageView0, TextView textView0) {
                q.g(checkableImageView0, "btnLiked");
                q.g(textView0, "cntLiked");
                SongDetailFragment.this.btnLiked = checkableImageView0;
                SongDetailFragment.this.cntLiked = textView0;
                SongDetailFragment.this.updateLikeInfoForSongAlbumDetail(checkableImageView0);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onLyricUpdateMsgListener(String s) {
                q.g(s, "songId");
                RequestBuilder.newInstance(new SongLyricUpdtMsgCheckReq(SongDetailFragment.this.getContext(), s)).tag("LyricHighLightFragment").listener(new com.google.android.exoplayer2.upstream.cache.a(18)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(19)).request();
            }

            private static final void onLyricUpdateMsgListener$lambda$0(Object object0) {
                if(object0 instanceof SongLyricUpdtMsgCheckRes && ((SongLyricUpdtMsgCheckRes)object0).isSuccessful()) {
                    if(q.b(((SongLyricUpdtMsgCheckRes)object0).response.status, "1")) {
                        MelonPrefs.getInstance().setBoolean("lyricUpdateMsgShown", true);
                        return;
                    }
                    MelonPrefs.getInstance().setBoolean("lyricUpdateMsgShown", false);
                }
            }

            private static final void onLyricUpdateMsgListener$lambda$1(VolleyError volleyError0) {
                MelonPrefs.getInstance().setBoolean("lyricUpdateMsgShown", false);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onMoveToScoll(int v) {
                SongDetailFragment.this.moveToScroll(v);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onPlayBtnListener(Playable playable0) {
                SongDetailFragment.this.playSong(playable0, true);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onShowSharePopupListener() {
                Sharable sharable0 = SongDetailFragment.this.getSNSSharable();
                SongDetailFragment.this.showSNSListPopup(sharable0);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public f onTiaraEventBuilder() {
                return SongDetailFragment.this.getTiaraEventBuilder();
            }
        };
    }

    private final ArrayList getPlayableFromSongInfoRes() {
        ArrayList arrayList0 = new ArrayList();
        com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = this.songInfoRes;
        if(songInfoRes$RESPONSE0 != null) {
            SongInfoBase songInfoBase0 = songInfoRes$RESPONSE0.songInfo;
            if(songInfoBase0 != null) {
                arrayList0.add(Playable.from(songInfoBase0, this.getMenuId(), null));
            }
        }
        return arrayList0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = this.songInfoRes;
        if(songInfoRes$RESPONSE0 == null) {
            return null;
        }
        if(songInfoRes$RESPONSE0 != null) {
            SongInfoBase songInfoBase0 = songInfoRes$RESPONSE0.songInfo;
            if(songInfoBase0 != null) {
                u u0 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
                u0.a = songInfoBase0.songId;
                u0.b = songInfoBase0.songName;
                u0.c = songInfoBase0.albumId;
                u0.d = songInfoBase0.albumImgLarge;
                u0.e = songInfoBase0.albumImgLarge;
                u0.f = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                return new SharableSong(u0);
            }
        }
        return null;
    }

    private final StreamReportUiState getStreamReportUiState(StreamReportInfo songInfoRes$RESPONSE$StreamReportInfo0, com.iloen.melon.net.v6x.response.SongPersonalInfoRes.RESPONSE songPersonalInfoRes$RESPONSE0, we.a a0) {
        String s10;
        int v3;
        int v1;
        int v;
        ListeningUiState listeningUiState0;
        if(songInfoRes$RESPONSE$StreamReportInfo0.genderPercent == null) {
            listeningUiState0 = ListeningUiState.Companion.getEmpty();
        }
        else if(songInfoRes$RESPONSE$StreamReportInfo0.agePercentList == null || songInfoRes$RESPONSE$StreamReportInfo0.agePercentList.isEmpty()) {
            listeningUiState0 = ListeningUiState.Companion.getEmpty();
        }
        else {
            String s = this.getString(0x7F130A80);  // string:song_detail_title_male "남성"
            String s1 = songInfoRes$RESPONSE$StreamReportInfo0.genderPercent.male == null ? "" : songInfoRes$RESPONSE$StreamReportInfo0.genderPercent.male;
            m m0 = new m(s, s1);
            String s2 = this.getString(0x7F130A76);  // string:song_detail_title_female "여성"
            String s3 = songInfoRes$RESPONSE$StreamReportInfo0.genderPercent.female == null ? "" : songInfoRes$RESPONSE$StreamReportInfo0.genderPercent.female;
            m m1 = new m(s2, s3);
            try {
                v = 0;
                v = Integer.parseInt(s1);
                v1 = 0;
            }
            catch(NumberFormatException unused_ex) {
            }
            try {
                v1 = Integer.parseInt(s3);
            }
            catch(NumberFormatException unused_ex) {
            }
            m m2 = v < v1 ? new m(m1, m0) : new m(m0, m1);
            m m3 = (m)m2.a;
            m m4 = (m)m2.b;
            ArrayList arrayList0 = new ArrayList();
            String[] arr_s = this.getResources().getStringArray(0x7F030012);  // array:listening_ages
            q.f(arr_s, "getStringArray(...)");
            if(songInfoRes$RESPONSE$StreamReportInfo0.agePercentList.size() == arr_s.length) {
                ArrayList arrayList1 = songInfoRes$RESPONSE$StreamReportInfo0.agePercentList;
                q.f(arrayList1, "agePercentList");
                int v2 = 0;
                for(Object object0: arrayList1) {
                    if(v2 >= 0) {
                        String s4 = (String)object0;
                        String s5 = arr_s[v2];
                        q.f(s5, "get(...)");
                        q.d(s4);
                        try {
                            v3 = 0;
                            v3 = Integer.parseInt(s4);
                        }
                        catch(NumberFormatException unused_ex) {
                        }
                        arrayList0.add(new ListeningAge(s5, v3));
                        ++v2;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
            }
            listeningUiState0 = new ListeningUiState(new GenderInfo(new Gender(((String)m3.a), ((String)m3.b)), new Gender(((String)m4.a), ((String)m4.b))), arrayList0);
        }
        String s6 = songInfoRes$RESPONSE$StreamReportInfo0.totalAllListenCount == null ? "" : songInfoRes$RESPONSE$StreamReportInfo0.totalAllListenCount;
        String s7 = songInfoRes$RESPONSE$StreamReportInfo0.totalAllListenerCount == null ? "" : songInfoRes$RESPONSE$StreamReportInfo0.totalAllListenerCount;
        String s8 = songInfoRes$RESPONSE$StreamReportInfo0.dailyListenerCount == null ? "" : songInfoRes$RESPONSE$StreamReportInfo0.dailyListenerCount;
        if(songPersonalInfoRes$RESPONSE0 == null) {
            s10 = "";
        }
        else {
            String s9 = songPersonalInfoRes$RESPONSE0.totalListenCnt;
            s10 = s9 == null ? "" : s9;
        }
        if(songPersonalInfoRes$RESPONSE0 != null) {
            String s11 = songPersonalInfoRes$RESPONSE0.firstListenDate;
            return s11 == null ? new StreamReportUiState(a0, s6, s7, s8, s10, "", listeningUiState0) : new StreamReportUiState(a0, s6, s7, s8, s10, s11, listeningUiState0);
        }
        return new StreamReportUiState(a0, s6, s7, s8, s10, "", listeningUiState0);
    }

    private final f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty != null) {
            String s = "곡";
            f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = this.mMelonTiaraProperty.a;
            f0.c = this.mMelonTiaraProperty.b;
            f0.o = this.getContsId();
            if(this.getContext() == null) {
                s = "";
            }
            f0.p = s;
            f0.q = this.songName;
            f0.I = this.mMelonTiaraProperty.c;
            return f0;
        }
        return null;
    }

    private final void initHeaderView() {
        m0 m00 = this.getBinding();
        this.bottomDivider = m00.d;
        m00.d.setVisibility(8);
        String s = this.getString(0x7F130A63);  // string:song "곡"
        q.f(s, "getString(...)");
        I i0 = new I(1, s);
        i0.c = new T(this, 5);
        TitleBar titleBar0 = this.getTitleBar();
        o o0 = B.a.s(7);
        o0.g(i0);
        titleBar0.a(o0);
        this.getTitleBar().setTitle("");
        int v = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
        int v1 = ScreenUtils.dipToPixel(this.getContext(), 0.5f);
        int v2 = ColorUtils.getColor(this.getContext(), 0x7F06014A);  // color:gray100a
        a3 a30 = this.getHeaderBinding();
        if(a30 != null) {
            ViewUtils.setDefaultImage(a30.f.c, v, true);
            ViewUtils.setDefaultImage(a30.g.c, v, true);
            ViewUtils.setDefaultImage(a30.h.c, v, true);
            a30.f.b.setBorderWidth(v1);
            a30.g.b.setBorderWidth(v1);
            a30.h.b.setBorderWidth(v1);
            a30.f.b.setBorderColor(v2);
            a30.g.b.setBorderColor(v2);
            a30.h.b.setBorderColor(v2);
        }
    }

    private static final void initHeaderView$lambda$7(SongDetailFragment songDetailFragment0, View view0) {
        if(songDetailFragment0.songInfoRes != null) {
            RequestBuilder.newInstance(new SongMoreInfoReq(songDetailFragment0.getContext(), songDetailFragment0.songId)).tag("DetailSongMetaContentBaseFragment").listener(new O(songDetailFragment0)).errorListener(new O(songDetailFragment0)).request();
        }
    }

    private static final void initHeaderView$lambda$7$lambda$6$lambda$4(SongDetailFragment songDetailFragment0, SongMoreInfoRes songMoreInfoRes0) {
        if(songDetailFragment0.isFragmentValid()) {
            if(songMoreInfoRes0 != null && songMoreInfoRes0.isSuccessful()) {
                songDetailFragment0.setMorePopupData(songMoreInfoRes0);
            }
            f f0 = songDetailFragment0.getTiaraEventBuilder();
            if(f0 != null) {
                String s = "페이지이동";
                String s1 = "";
                if(songDetailFragment0.getContext() == null) {
                    s = "";
                }
                String s2 = "GNB";
                f0.a = s;
                f0.d = ActionKind.ClickContent;
                if(songDetailFragment0.getContext() == null) {
                    s2 = "";
                }
                f0.y = s2;
                if(songDetailFragment0.getContext() != null) {
                    s1 = "상세정보";
                }
                f0.F = s1;
                f0.a().track();
            }
        }
    }

    private static final void initHeaderView$lambda$7$lambda$6$lambda$5(SongDetailFragment songDetailFragment0, VolleyError volleyError0) {
        if(songDetailFragment0.isFragmentValid()) {
            songDetailFragment0.setMorePopupData(null);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void likeClickLog(boolean z) {
        Context context0 = this.getContext();
        if(context0 != null) {
            f f0 = this.getTiaraEventBuilder();
            if(f0 != null) {
                f0.a = "좋아요";
                f0.d = ActionKind.Like;
                f0.y = "곡정보";
                f0.F = "좋아요";
                f0.U = context0.getString((z ? 0x7F130FCD : 0x7F130FCC));  // string:tiara_props_like "like"
                f0.a().track();
            }
        }
    }

    @NotNull
    public static final SongDetailFragment newInstance(@NotNull String s) {
        return SongDetailFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final SongDetailFragment newInstance(@NotNull String s, boolean z) {
        return SongDetailFragment.Companion.newInstance(s, z);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public List onAddSongsToPlaylist(@Nullable String s, @Nullable String s1) {
        return TextUtils.isEmpty(this.songId) ? null : e.k.z(Song.b(this.songId));
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAddToNowPlayingList(@Nullable Object object0) {
        this.playSongs(this.getPlayableFromSongInfoRes(), false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarCollapsed() {
        this.getTitleBar().setTitle(this.songName);
        this.getTitleBar().f(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarExpended() {
        this.getTitleBar().setTitle("");
        this.getTitleBar().f(true);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarScrolling(int v) {
        float f = (float)Math.abs(v);
        float f1 = 0.0f;
        if(!ScreenUtils.isLandscape(this.getContext()) && !ScreenUtils.isTablet(this.getContext())) {
            if(f > 0.0f) {
                this.getTitleBar().setTitle(this.songName);
                return;
            }
            if(f == 0.0f) {
                this.getTitleBar().f(false);
            }
            return;
        }
        a3 a30 = this.getHeaderBinding();
        if(a30 != null) {
            RelativeLayout relativeLayout0 = a30.c;
            if(relativeLayout0 != null) {
                f1 = (float)relativeLayout0.getHeight();
            }
        }
        if(Float.compare(f, f1) >= 0) {
            this.getTitleBar().setTitle(this.songName);
            View view0 = this.bottomDivider;
            if(view0 != null) {
                view0.setVisibility(8);
                this.getTitleBar().f(true);
                return;
            }
            q.m("bottomDivider");
            throw null;
        }
        this.getTitleBar().setTitle("");
        View view1 = this.bottomDivider;
        if(view1 != null) {
            view1.setVisibility(8);
            this.getTitleBar().f(false);
            return;
        }
        q.m("bottomDivider");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        Context context0 = this.getContext();
        if(!com.iloen.melon.responsecache.a.e(300000L, this.getDetailCacheKey(), context0)) {
            this.updateHeaderView();
            return;
        }
        this.onFetchStart(i.b, null, "");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D084A, null, false);  // layout:song_detail_header
        int v = 0x7F0A008E;  // id:album_thumb_container
        if(((FrameLayout)De.I.C(view0, 0x7F0A008E)) != null) {  // id:album_thumb_container
            v = 0x7F0A00B3;  // id:artist_container
            View view1 = De.I.C(view0, 0x7F0A00B3);  // id:artist_container
            if(((ConstraintLayout)view1) != null) {
                v = 0x7F0A03A7;  // id:desc_container
                View view2 = De.I.C(view0, 0x7F0A03A7);  // id:desc_container
                if(((RelativeLayout)view2) != null && ((MelonTextView)De.I.C(view0, 0x7F0A03A9)) != null && (((RelativeLayout)De.I.C(view0, 0x7F0A03AA)) != null && ((LinearLayout)De.I.C(view0, 0x7F0A03AB)) != null) && (((MelonTextView)De.I.C(view0, 0x7F0A03AC)) != null && ((RelativeLayout)De.I.C(view0, 0x7F0A03AD)) != null && ((ImageView)De.I.C(view0, 0x7F0A05EB)) != null)) {  // id:desc_long
                    v = 0x7F0A05ED;  // id:iv_album_thumb
                    View view3 = De.I.C(view0, 0x7F0A05ED);  // id:iv_album_thumb
                    if(((MelonImageView)view3) != null) {
                        v = 0x7F0A0626;  // id:iv_dolby
                        View view4 = De.I.C(view0, 0x7F0A0626);  // id:iv_dolby
                        if(((ImageView)view4) != null && ((FrameLayout)De.I.C(view0, 0x7F0A0B72)) != null) {  // id:thumb_container
                            v = 0x7F0A0B7A;  // id:thumb_layout1
                            View view5 = De.I.C(view0, 0x7F0A0B7A);  // id:thumb_layout1
                            if(view5 != null) {
                                e3 e30 = e3.a(view5);
                                v = 0x7F0A0B7B;  // id:thumb_layout2
                                View view6 = De.I.C(view0, 0x7F0A0B7B);  // id:thumb_layout2
                                if(view6 != null) {
                                    e3 e31 = e3.a(view6);
                                    v = 0x7F0A0B7C;  // id:thumb_layout3
                                    View view7 = De.I.C(view0, 0x7F0A0B7C);  // id:thumb_layout3
                                    if(view7 != null) {
                                        e3 e32 = e3.a(view7);
                                        v = 0x7F0A0C0F;  // id:tv_album_title
                                        View view8 = De.I.C(view0, 0x7F0A0C0F);  // id:tv_album_title
                                        if(((MelonTextView)view8) != null) {
                                            v = 0x7F0A0C12;  // id:tv_artist
                                            View view9 = De.I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                            if(((MelonTextView)view9) != null) {
                                                v = 0x7F0A0C7A;  // id:tv_flac
                                                View view10 = De.I.C(view0, 0x7F0A0C7A);  // id:tv_flac
                                                if(((MelonTextView)view10) != null) {
                                                    return new a3(((ConstraintLayout)view0), ((ConstraintLayout)view1), ((RelativeLayout)view2), ((MelonImageView)view3), ((ImageView)view4), e30, e31, e32, ((MelonTextView)view8), ((MelonTextView)view9), ((MelonTextView)view10));
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
            recyclerView0.addItemDecoration(new ItemDecoration());
            return recyclerView0;
        }
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventHighlight eventHighlight0) {
        q.g(eventHighlight0, "event");
        if(this.isLoginUser()) {
            boolean z = !this.isLoginUser();
            BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain().plus(this.subExceptionHandler), null, new n("", null) {
                final String $adultFlg;
                Object L$0;
                int label;

                {
                    SongDetailFragment.this = songDetailFragment0;
                    this.$adultFlg = s;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.detail.SongDetailFragment.onEventMainThread.1(SongDetailFragment.this, this.$adultFlg, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.detail.SongDetailFragment.onEventMainThread.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    Object object1 = null;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            q.d(this.$adultFlg);
                            Deferred deferred0 = SongDetailFragment.this.requestSongPersonalInfoAsync(SongDetailFragment.this.songId, this.$adultFlg);
                            this.L$0 = null;
                            this.label = 1;
                            object0 = deferred0.await(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            Deferred deferred1 = (Deferred)this.L$0;
                            d5.n.D(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    if(((SongPersonalInfoRes)object0) != null && ((SongPersonalInfoRes)object0).isSuccessful() && ((SongPersonalInfoRes)object0).response != null) {
                        j0 j00 = SongDetailFragment.this.mAdapter;
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.SongDetailFragment.SongDetailAdapter");
                        AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)((SongDetailAdapter)j00).getItem(((SongDetailAdapter)j00).getLyricViewPos());
                        if(adapterInViewHolder$Row0 != null && adapterInViewHolder$Row0.getItemViewType() == 10) {
                            AdapterInViewHolder.Row adapterInViewHolder$Row1 = (AdapterInViewHolder.Row)((SongDetailAdapter)j00).getItem(((SongDetailAdapter)j00).getLyricViewPos());
                            if(adapterInViewHolder$Row1 != null) {
                                object1 = adapterInViewHolder$Row1.getItem();
                            }
                            q.e(object1, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.viewholder.LyricHolder.LyricData");
                            String s = ((SongPersonalInfoRes)object0).response.highlightLine;
                            q.f(s, "highlightLine");
                            ((LyricData)object1).setHighlightLine(s);
                        }
                        ((SongDetailAdapter)j00).notifyItemChanged(((SongDetailAdapter)j00).getLyricViewPos());
                    }
                    return H.a;
                }
            }, 2, null);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable v9.h h0, @Nullable String s) {
        this.setFetchStart(true);
        this.isLoginUser();
        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(this, completableJob0.plus(this.mainExceptionHandler), null, new n(completableJob0, "", i0, null) {
            final String $adultFlg;
            final CompletableJob $supervisor;
            final i $type;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;

            {
                SongDetailFragment.this = songDetailFragment0;
                this.$supervisor = completableJob0;
                this.$adultFlg = s;
                this.$type = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1(SongDetailFragment.this, this.$supervisor, this.$adultFlg, this.$type, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                SongInfoRes songInfoRes0;
                Deferred deferred1;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred0 = SongDetailFragment.this.requestSongInfoAsync(SongDetailFragment.this.songId);
                        deferred1 = SongDetailFragment.this.requestSongContentsListAsync(SongDetailFragment.this.songId);
                        this.L$0 = null;
                        this.L$1 = deferred1;
                        this.label = 1;
                        object0 = deferred0.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_15;
                    }
                    case 1: {
                        deferred1 = (Deferred)this.L$1;
                        Deferred deferred2 = (Deferred)this.L$0;
                        d5.n.D(object0);
                    label_15:
                        me.i i0 = Dispatchers.getMain().plus(SongDetailFragment.this.mainExceptionHandler);
                        com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1.1 songDetailFragment$onFetchStart$1$10 = new n(((SongInfoRes)object0), this.$supervisor, deferred1, this.$adultFlg, this.$type, null) {
                            final String $adultFlg;
                            final Deferred $songContentsListDeferred;
                            final SongInfoRes $songInfoRes;
                            final CompletableJob $supervisor;
                            final i $type;
                            Object L$0;
                            Object L$1;
                            int label;

                            {
                                SongDetailFragment.this = songDetailFragment0;
                                this.$songInfoRes = songInfoRes0;
                                this.$supervisor = completableJob0;
                                this.$songContentsListDeferred = deferred0;
                                this.$adultFlg = s;
                                this.$type = i0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1.1(SongDetailFragment.this, this.$songInfoRes, this.$supervisor, this.$songContentsListDeferred, this.$adultFlg, this.$type, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                SongContentsListRes songContentsListRes1;
                                SongContentsListRes songContentsListRes0;
                                ne.a a0 = ne.a.a;
                                H h0 = H.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        if(!SongDetailFragment.this.prepareFetchComplete(this.$songInfoRes)) {
                                            SongDetailFragment.this.showNetworkErrorHeaderView(true);
                                            DefaultImpls.cancel$default(this.$supervisor, null, 1, null);
                                            return h0;
                                        }
                                        this.label = 1;
                                        object0 = this.$songContentsListDeferred.await(this);
                                        if(object0 == a0) {
                                            return a0;
                                        }
                                        goto label_14;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                    label_14:
                                        songContentsListRes0 = (SongContentsListRes)object0;
                                        SongInfoRes songInfoRes0 = this.$songInfoRes;
                                        if(songInfoRes0 != null) {
                                            com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = songInfoRes0.response;
                                            if(songInfoRes$RESPONSE0 != null) {
                                                s s0 = new s(songInfoRes$RESPONSE0.section, songInfoRes$RESPONSE0.page, songInfoRes$RESPONSE0.menuId, null);
                                                SongDetailFragment.this.mMelonTiaraProperty = s0;
                                                String s1 = songInfoRes$RESPONSE0.bbschannelseq;
                                                q.f(s1, "bbschannelseq");
                                                SongDetailFragment.this.bbsChannelSeq = s1;
                                            }
                                            Context context0 = SongDetailFragment.this.getContext();
                                            String s2 = SongDetailFragment.this.getDetailCacheKey();
                                            com.iloen.melon.responsecache.a.a(context0, this.$songInfoRes, s2);
                                            SongDetailFragment.this.songInfoRes = this.$songInfoRes.response;
                                            SongDetailFragment.this.drawHeaderView(this.$songInfoRes);
                                        }
                                        if(SongDetailFragment.this.isLoginUser()) {
                                            q.d(this.$adultFlg);
                                            Deferred deferred0 = SongDetailFragment.this.requestSongPersonalInfoAsync(SongDetailFragment.this.songId, this.$adultFlg);
                                            this.L$0 = songContentsListRes0;
                                            this.L$1 = null;
                                            this.label = 2;
                                            Object object1 = deferred0.await(this);
                                            if(object1 == a0) {
                                                return a0;
                                            }
                                            songContentsListRes1 = songContentsListRes0;
                                            object0 = object1;
                                            goto label_44;
                                        }
                                        goto label_51;
                                    }
                                    case 2: {
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                Deferred deferred1 = (Deferred)this.L$1;
                                songContentsListRes1 = (SongContentsListRes)this.L$0;
                                d5.n.D(object0);
                            label_44:
                                if(((SongPersonalInfoRes)object0) != null && ((SongPersonalInfoRes)object0).isSuccessful() && ((SongPersonalInfoRes)object0).response != null) {
                                    j0 j00 = SongDetailFragment.this.mAdapter;
                                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.SongDetailFragment.SongDetailAdapter");
                                    com.iloen.melon.net.v6x.response.SongPersonalInfoRes.RESPONSE songPersonalInfoRes$RESPONSE0 = ((SongPersonalInfoRes)object0).response;
                                    q.f(songPersonalInfoRes$RESPONSE0, "response");
                                    ((SongDetailAdapter)j00).setSongPersonalInfoRes(songPersonalInfoRes$RESPONSE0);
                                }
                                songContentsListRes0 = songContentsListRes1;
                            label_51:
                                if(songContentsListRes0 != null && songContentsListRes0.isSuccessful() && songContentsListRes0.response != null) {
                                    j0 j01 = SongDetailFragment.this.mAdapter;
                                    q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.SongDetailFragment.SongDetailAdapter");
                                    RESPONSE songContentsListRes$RESPONSE0 = songContentsListRes0.response;
                                    q.f(songContentsListRes$RESPONSE0, "response");
                                    ((SongDetailAdapter)j01).setSongContentsListRes(songContentsListRes$RESPONSE0);
                                }
                                SongDetailFragment.this.performFetchComplete(this.$type, this.$songInfoRes);
                                return h0;
                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = (SongInfoRes)object0;
                        this.L$3 = null;
                        this.label = 2;
                        if(BuildersKt.withContext(i0, songDetailFragment$onFetchStart$1$10, this) == a0) {
                            return a0;
                        }
                        songInfoRes0 = (SongInfoRes)object0;
                        goto label_30;
                    }
                    case 2: {
                        me.i i1 = (me.i)this.L$3;
                        songInfoRes0 = (SongInfoRes)this.L$2;
                        Deferred deferred3 = (Deferred)this.L$1;
                        Deferred deferred4 = (Deferred)this.L$0;
                        d5.n.D(object0);
                    label_30:
                        if(songInfoRes0 != null) {
                            SongDetailFragment.this.getLikeCountFromServerInRealTimeAndUpdateUi();
                        }
                        me.i i2 = Dispatchers.getMain().plus(SongDetailFragment.this.subExceptionHandler);
                        com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1.2 songDetailFragment$onFetchStart$1$20 = new n(songInfoRes0, null) {
                            final SongInfoRes $songInfoRes;
                            int label;

                            {
                                SongDetailFragment.this = songDetailFragment0;
                                this.$songInfoRes = songInfoRes0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1.2(SongDetailFragment.this, this.$songInfoRes, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.SongDetailFragment.onFetchStart.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                String s1;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                SongDetailFragment songDetailFragment0 = SongDetailFragment.this;
                                String s = songDetailFragment0.bbsChannelSeq;
                                SongInfoRes songInfoRes0 = this.$songInfoRes;
                                if(songInfoRes0 == null) {
                                    s1 = "";
                                }
                                else {
                                    com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0 = songInfoRes0.response;
                                    if(songInfoRes$RESPONSE0 == null) {
                                        s1 = "";
                                    }
                                    else {
                                        s1 = songInfoRes$RESPONSE0.bbsContsRefValue;
                                        if(s1 == null) {
                                            s1 = "";
                                        }
                                    }
                                }
                                CommentLatestList.requestCommentApis$default(songDetailFragment0, s, s1, false, 4, null);
                                return H.a;
                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        if(BuildersKt.withContext(i2, songDetailFragment$onFetchStart$1$20, this) == a0) {
                            return a0;
                        }
                        SongDetailFragment.this.setFetchStart(false);
                        return H.a;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                me.i i3 = (me.i)this.L$4;
                me.i i4 = (me.i)this.L$3;
                SongInfoRes songInfoRes1 = (SongInfoRes)this.L$2;
                Deferred deferred5 = (Deferred)this.L$1;
                Deferred deferred6 = (Deferred)this.L$0;
                d5.n.D(object0);
                SongDetailFragment.this.setFetchStart(false);
                return H.a;
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        String s = bundle0.getString("argItemId", "");
        q.f(s, "getString(...)");
        this.songId = s;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        if(Math.abs(this.getAppBarOffset()) > 0) {
            this.getTitleBar().setTitle(this.songName);
            this.getTitleBar().f(false);
            return;
        }
        this.getTitleBar().setTitle("");
        this.getTitleBar().f(true);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.songId);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onStart() {
        super.onStart();
        if(!this.isFetchStart()) {
            Context context0 = this.getContext();
            if(!com.iloen.melon.responsecache.a.e(300000L, this.getDetailCacheKey(), context0)) {
                this.updateHeaderView();
            }
        }
        this.setFetchStart(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initHeaderView();
        this.registerIsLoginFlow();
    }

    public static void r0(com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0, SongDetailFragment songDetailFragment0, View view0) {
        SongDetailFragment.drawHeaderView$lambda$21$lambda$20(songInfoRes$RESPONSE0, songDetailFragment0, view0);
    }

    private final void registerIsLoginFlow() {
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            int label;

            {
                SongDetailFragment.this = songDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.SongDetailFragment.registerIsLoginFlow.1(SongDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.SongDetailFragment.registerIsLoginFlow.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)SongDetailFragment.this.getLoginUseCase()).n()), 1);
                        com.iloen.melon.fragments.detail.SongDetailFragment.registerIsLoginFlow.1.1 songDetailFragment$registerIsLoginFlow$1$10 = new n(null) {
                            boolean Z$0;
                            int label;

                            {
                                SongDetailFragment.this = songDetailFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.detail.SongDetailFragment.registerIsLoginFlow.1.1(SongDetailFragment.this, continuation0);
                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.SongDetailFragment.registerIsLoginFlow.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.Z$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                LogU logU0 = new LogU("DetailSongMetaContentBaseFragment");
                                logU0.setCategory(Category.Login);
                                logU0.setUseThreadInfo(true);
                                LogU.debug$default(logU0, "DetailSongMetaContentBaseFragment - isLogin: " + z, null, false, 6, null);
                                if(z) {
                                    SongDetailFragment.this.startFetch("songdetail log-in");
                                }
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(flow0, songDetailFragment$registerIsLoginFlow$1$10, this) == a0 ? a0 : H.a;
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

    private final Deferred requestSongContentsListAsync(String s) {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new n(s, null) {
            final String $songId;
            int label;

            {
                SongDetailFragment.this = songDetailFragment0;
                this.$songId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.SongDetailFragment.requestSongContentsListAsync.1(SongDetailFragment.this, this.$songId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.SongDetailFragment.requestSongContentsListAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    try {
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new SongContentsListReq(SongDetailFragment.this.getContext(), this.$songId)).tag("DetailSongMetaContentBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.SongContentsListRes");
                        return (SongContentsListRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        H0.b.w("requestSongContentsListAsync() exception, ", exception0.getMessage(), LogU.Companion, "DetailSongMetaContentBaseFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    private final Deferred requestSongInfoAsync(String s) {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new n(s, null) {
            final String $songId;
            int label;

            {
                SongDetailFragment.this = songDetailFragment0;
                this.$songId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.SongDetailFragment.requestSongInfoAsync.1(SongDetailFragment.this, this.$songId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.SongDetailFragment.requestSongInfoAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new SongInfoReq(SongDetailFragment.this.getContext(), this.$songId)).tag("DetailSongMetaContentBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.SongInfoRes");
                return (SongInfoRes)httpResponse0;
            }
        }, 3, null);
    }

    private final Deferred requestSongPersonalInfoAsync(String s, String s1) {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new n(s, s1, null) {
            final String $adultFlg;
            final String $songId;
            int label;

            {
                SongDetailFragment.this = songDetailFragment0;
                this.$songId = s;
                this.$adultFlg = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.SongDetailFragment.requestSongPersonalInfoAsync.1(SongDetailFragment.this, this.$songId, this.$adultFlg, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.SongDetailFragment.requestSongPersonalInfoAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    try {
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new SongPersonalInfoReq(SongDetailFragment.this.getContext(), this.$songId, this.$adultFlg)).tag("DetailSongMetaContentBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.SongPersonalInfoRes");
                        return (SongPersonalInfoRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        H0.b.w("requestSongPersonalInfoAsync() exception, ", exception0.getMessage(), LogU.Companion, "DetailSongMetaContentBaseFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    public static void s0(SongDetailFragment songDetailFragment0, VolleyError volleyError0) {
        SongDetailFragment.initHeaderView$lambda$7$lambda$6$lambda$5(songDetailFragment0, volleyError0);
    }

    public final void setLoginUseCase(@NotNull k k0) {
        q.g(k0, "<set-?>");
        this.loginUseCase = k0;
    }

    private final void setMorePopupData(SongMoreInfoRes songMoreInfoRes0) {
        Link extraProperties$Link0 = null;
        SongInfoBase songInfoBase0 = this.songInfoRes == null ? null : this.songInfoRes.songInfo;
        if(songInfoBase0 == null) {
            LogU.error$default(this.log, "showMorePopup() >> Song Data is null", null, false, 6, null);
            return;
        }
        d5.s s0 = new d5.s();
        s0.b = "3";
        s0.c = songInfoBase0.getMenuId();
        s0.e = "D03";
        s0.h = "V17";
        com.iloen.melon.utils.a.t(s0);
        Playable playable0 = Playable.from(songInfoBase0, this.mMenuId, null);
        l0 l00 = this.getChildFragmentManager();
        q.d(playable0);
        boolean z = ((e0)this.getLoginUseCase()).j().getIsDj();
        if(songMoreInfoRes0 != null) {
            com.iloen.melon.net.v4x.response.SongMoreInfoRes.RESPONSE songMoreInfoRes$RESPONSE0 = songMoreInfoRes0.response;
            if(songMoreInfoRes$RESPONSE0 != null) {
                TIKTOK songMoreInfoRes$RESPONSE$TIKTOK0 = songMoreInfoRes$RESPONSE0.tiktok;
                if(songMoreInfoRes$RESPONSE$TIKTOK0 != null) {
                    extraProperties$Link0 = new Link(songMoreInfoRes$RESPONSE$TIKTOK0.linktype, songMoreInfoRes$RESPONSE$TIKTOK0.linkurl);
                }
            }
        }
        com.melon.ui.popup.b.o(l00, new l(playable0, z, extraProperties$Link0), new F(this, songInfoBase0, playable0, songMoreInfoRes0, 8), 12);
    }

    private static final H setMorePopupData$lambda$31(SongDetailFragment songDetailFragment0, SongInfoBase songInfoBase0, Playable playable0, SongMoreInfoRes songMoreInfoRes0, k2 k20) {
        q.g(k20, "clickEvent");
        H h0 = H.a;
        if(k20 instanceof K1) {
            switch(((K1)k20).b.a.ordinal()) {
                case 24: {
                    songDetailFragment0.playSongs(songDetailFragment0.getPlayableFromSongInfoRes(), false);
                    return h0;
                }
                case 25: {
                    if(!TextUtils.isEmpty(songDetailFragment0.songId)) {
                        songDetailFragment0.showPlaylistContextMenu(null, false);
                        return h0;
                    }
                    break;
                }
                case 27: {
                    if(!TextUtils.isEmpty(songDetailFragment0.songId)) {
                        songDetailFragment0.showDjPlaylistContextMenu(null, false);
                        return h0;
                    }
                    break;
                }
                case 58: {
                    songDetailFragment0.openPresentSendPage(null, songDetailFragment0.getPlayableFromSongInfoRes());
                    return h0;
                }
                default: {
                    return h0;
                }
            }
        }
        else {
            if(k20 instanceof h2) {
                Navigator.open(StreamingCardFragment.Companion.newInstance(songDetailFragment0.songId));
                return h0;
            }
            if(k20 instanceof H1) {
                if(!songDetailFragment0.isLoginUser()) {
                    songDetailFragment0.showLoginPopup();
                    return h0;
                }
                songDetailFragment0.showKakaoProfileMusicPopup(songDetailFragment0.songId, songInfoBase0.songName, songDetailFragment0.getMenuId());
                return h0;
            }
            if(k20 instanceof c2) {
                songDetailFragment0.shareData(playable0, "N10001");
                return h0;
            }
            if(k20 instanceof i2) {
                p8.O.a(new UaLogDummyReq(songDetailFragment0.getContext(), "songInfoTiktok"));
                q.d(songMoreInfoRes0);
                MelonLinkExecutor.open(songMoreInfoRes0.response.tiktok.linktype, songMoreInfoRes0.response.tiktok.linkurl);
                return h0;
            }
            if(k20 instanceof w1) {
                songDetailFragment0.showAlbumInfoPage(playable0);
                return h0;
            }
            if(k20 instanceof x1) {
                songDetailFragment0.showArtistInfoPage(playable0);
            }
        }
        return h0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }

    private final void showGuidePopup(int v, String s) {
        String s1 = v == 0 ? this.getString(0x7F130A6E) : this.getString(0x7F130A6D);  // string:song_detail_popup_streaming_report_info_title "스트리밍 리포트 안내"
        q.d(s1);
        l0 l00 = this.getChildFragmentManager();
        com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s1, s, false, true, false, null, null, null, null, null, 2024);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public boolean showSpaceViewBottomButtonParallax() {
        return true;
    }

    public static void t0(SongDetailFragment songDetailFragment0, SongMoreInfoRes songMoreInfoRes0) {
        SongDetailFragment.initHeaderView$lambda$7$lambda$6$lambda$4(songDetailFragment0, songMoreInfoRes0);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentCountView(@Nullable InformCmtContsSummRes informCmtContsSummRes0) {
        CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0;
        Object object0 = null;
        if(informCmtContsSummRes0 == null) {
            informCmtContsSummRes$result$CMTCONTSSUMM0 = null;
        }
        else {
            result informCmtContsSummRes$result0 = informCmtContsSummRes0.result;
            informCmtContsSummRes$result$CMTCONTSSUMM0 = informCmtContsSummRes$result0 == null ? null : informCmtContsSummRes$result0.cmtContsSumm;
        }
        this.setInformCmt(informCmtContsSummRes$result$CMTCONTSSUMM0);
        if(informCmtContsSummRes0 != null) {
            if(!informCmtContsSummRes0.isSuccessful()) {
                informCmtContsSummRes0 = null;
            }
            if(informCmtContsSummRes0 != null) {
                result informCmtContsSummRes$result1 = informCmtContsSummRes0.result;
                if(informCmtContsSummRes$result1 != null) {
                    CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM1 = informCmtContsSummRes$result1.cmtContsSumm;
                    if(informCmtContsSummRes$result$CMTCONTSSUMM1 != null) {
                        j0 j00 = this.mAdapter;
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.SongDetailFragment.SongDetailAdapter");
                        AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)((SongDetailAdapter)j00).getItem(((SongDetailAdapter)j00).getCommonContentsViewPos());
                        if(adapterInViewHolder$Row0 != null && adapterInViewHolder$Row0.getItemViewType() == 41) {
                            AdapterInViewHolder.Row adapterInViewHolder$Row1 = (AdapterInViewHolder.Row)((SongDetailAdapter)j00).getItem(((SongDetailAdapter)j00).getCommonContentsViewPos());
                            if(adapterInViewHolder$Row1 != null) {
                                object0 = adapterInViewHolder$Row1.getItem();
                            }
                            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.viewholder.DetailCommonContentsHolder.ContentsData");
                            ((ContentsData)object0).setCommentInfo(informCmtContsSummRes$result$CMTCONTSSUMM1);
                            ((SongDetailAdapter)j00).notifyItemChanged(((SongDetailAdapter)j00).getCommonContentsViewPos());
                        }
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentListView(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.SongDetailFragment.SongDetailAdapter");
        CmtResViewModel cmtResViewModel0 = this.getCmtResViewModel(loadPgnRes0, listCmtRes0);
        ArrayList arrayList0 = cmtResViewModel0.result.cmtlist;
        q.f(arrayList0, "cmtlist");
        if(arrayList0.isEmpty()) {
            ((SongDetailAdapter)j00).add(AdapterInViewHolder.Row.create(44, H.a));
        }
        else {
            ((SongDetailAdapter)j00).add(AdapterInViewHolder.Row.create(9, cmtResViewModel0));
        }
        ((SongDetailAdapter)j00).notifyItemChanged(((SongDetailAdapter)j00).getItemCount() - 1);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateHeaderView() {
        BuildersKt__Builders_commonKt.launch$default(this, SupervisorKt.SupervisorJob$default(null, 1, null), null, new n(null) {
            int label;

            {
                SongDetailFragment.this = songDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.SongDetailFragment.updateHeaderView.1(SongDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.SongDetailFragment.updateHeaderView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        me.i i0 = Dispatchers.getMain().plus(SongDetailFragment.this.mainExceptionHandler);
                        com.iloen.melon.fragments.detail.SongDetailFragment.updateHeaderView.1.1 songDetailFragment$updateHeaderView$1$10 = new n(null) {
                            int label;

                            {
                                SongDetailFragment.this = songDetailFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.SongDetailFragment.updateHeaderView.1.1(SongDetailFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.SongDetailFragment.updateHeaderView.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                SongInfoRes songInfoRes0 = SongDetailFragment.this.fetchDetailCacheData();
                                if(songInfoRes0 != null) {
                                    SongDetailFragment.this.drawHeaderView(songInfoRes0);
                                }
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return BuildersKt.withContext(i0, songDetailFragment$updateHeaderView$1$10, this) == a0 ? a0 : H.a;
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
        }, 2, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateLikeView(@Nullable Integer integer0, boolean z) {
        this.isLiked = z;
        com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes.RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = this.getRealTimeLikeInfoRes();
        if(myMusicLikeInformContentsLikeRes$RESPONSE0 != null) {
            myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn = this.isLiked ? "Y" : "N";
        }
        if(integer0 != null) {
            this.likeCnt = integer0.toString();
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.SongDetailFragment.SongDetailAdapter");
            AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)((SongDetailAdapter)j00).getItem(((SongDetailAdapter)j00).getCommonContentsViewPos());
            if(adapterInViewHolder$Row0 != null && adapterInViewHolder$Row0.getItemViewType() == 41) {
                AdapterInViewHolder.Row adapterInViewHolder$Row1 = (AdapterInViewHolder.Row)((SongDetailAdapter)j00).getItem(((SongDetailAdapter)j00).getCommonContentsViewPos());
                Object object0 = null;
                Object object1 = adapterInViewHolder$Row1 == null ? null : adapterInViewHolder$Row1.getItem();
                q.e(object1, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.viewholder.DetailCommonContentsHolder.ContentsData");
                ((ContentsData)object1).setLikeCnt(this.likeCnt);
                AdapterInViewHolder.Row adapterInViewHolder$Row2 = (AdapterInViewHolder.Row)((SongDetailAdapter)j00).getItem(((SongDetailAdapter)j00).getCommonContentsViewPos());
                if(adapterInViewHolder$Row2 != null) {
                    object0 = adapterInViewHolder$Row2.getItem();
                }
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.viewholder.DetailCommonContentsHolder.ContentsData");
                ((ContentsData)object0).setLiked(this.isLiked);
            }
            ((SongDetailAdapter)j00).notifyItemChanged(((SongDetailAdapter)j00).getCommonContentsViewPos());
            return;
        }
        CheckableImageView checkableImageView0 = this.btnLiked;
        if(checkableImageView0 != null) {
            checkableImageView0.setChecked(this.isLiked);
            String s = "";
            if(!this.isLiked) {
                if(this.getContext() != null) {
                    s = "좋아요 취소";
                }
            }
            else if(this.getContext() != null) {
                s = "좋아요 취소";
            }
            checkableImageView0.setContentDescription(s);
        }
    }

    public static void v0(SongDetailFragment songDetailFragment0, View view0) {
        SongDetailFragment.initHeaderView$lambda$7(songDetailFragment0, view0);
    }

    public static void w0(com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE songInfoRes$RESPONSE0, SongDetailFragment songDetailFragment0, View view0) {
        SongDetailFragment.drawHeaderView$lambda$21$lambda$13(songInfoRes$RESPONSE0, songDetailFragment0, view0);
    }

    public static H x0(SongDetailFragment songDetailFragment0, xd.h h0) {
        return SongDetailFragment.drawHeaderView$lambda$21$lambda$20$lambda$19(songDetailFragment0, h0);
    }
}

