package com.iloen.melon.fragments.detail;

import De.I;
import F8.o;
import J8.d3;
import J8.e3;
import J8.f3;
import J8.m0;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.session.W0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SubscribeToggleButton;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnClickListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnData;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnInfo;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.OnViewHolderActionListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.CommentLatestList;
import com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder;
import com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder;
import com.iloen.melon.fragments.detail.viewholder.OtherCastHolder;
import com.iloen.melon.fragments.detail.viewholder.RecommendCastHolder;
import com.iloen.melon.fragments.detail.viewholder.RelateContentsHolder;
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
import com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;
import com.iloen.melon.net.v5x.request.MyMusicLikeListContentsLikeReq;
import com.iloen.melon.net.v5x.response.CastInfoBase.Creator;
import com.iloen.melon.net.v5x.response.CreatorInfoBase.ContsList;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.iloen.melon.net.v5x.response.MyMusicLikeListContentsLikeRes;
import com.iloen.melon.net.v6x.request.CastEpsdDetailReq;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.CastInfo.BUTTONINFO;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.CastInfo;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.OtherCastInfo;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.RecmStationInfo;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.RelatContsInfo;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.SongInfo.SongList;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.SongInfo;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.popup.LikeAnimationPopup;
import com.iloen.melon.sns.model.SharableCastEpisode;
import com.iloen.melon.sns.model.ShareLinkData;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.F1;
import com.melon.ui.K1;
import com.melon.ui.T1;
import com.melon.ui.V1;
import com.melon.ui.a2;
import com.melon.ui.j2;
import com.melon.ui.k2;
import d3.g;
import e.k;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.s;
import v9.h;
import v9.i;
import we.n;
import zd.M;

@Metadata(d1 = {"\u0000\u00A8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00C8\u00012\u00020\u0001:\u0006\u00C8\u0001\u00C9\u0001\u00CA\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u0017\u0010\u0010\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0014\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u000F\u0010\u001C\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0003J\u000F\u0010\u001F\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u0017\u0010\"\u001A\u00020\t2\u0006\u0010!\u001A\u00020 H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001A\u00020\t2\b\u0010%\u001A\u0004\u0018\u00010$H\u0016\u00A2\u0006\u0004\b&\u0010\'J\u001F\u0010,\u001A\u00020\t2\u0006\u0010)\u001A\u00020(2\u0006\u0010+\u001A\u00020*H\u0016\u00A2\u0006\u0004\b,\u0010-J\u0011\u0010/\u001A\u0004\u0018\u00010.H\u0014\u00A2\u0006\u0004\b/\u00100J\u001B\u00104\u001A\u0006\u0012\u0002\b\u0003032\u0006\u00102\u001A\u000201H\u0014\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b6\u0010\u0019J\u000F\u00107\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b7\u0010\u0019J-\u0010=\u001A\u00020\u00042\b\u00109\u001A\u0004\u0018\u0001082\b\u0010;\u001A\u0004\u0018\u00010:2\b\u0010<\u001A\u0004\u0018\u00010\u0017H\u0014\u00A2\u0006\u0004\b=\u0010>J!\u0010A\u001A\u00020\t2\b\u0010?\u001A\u0004\u0018\u00010 2\u0006\u0010@\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010C\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bC\u0010\u0003J\u000F\u0010D\u001A\u00020\tH\u0016\u00A2\u0006\u0004\bD\u0010\u0003J\u0015\u0010G\u001A\b\u0012\u0004\u0012\u00020F0EH\u0016\u00A2\u0006\u0004\bG\u0010HJ\u0013\u0010J\u001A\u00060IR\u00020\u0001H\u0016\u00A2\u0006\u0004\bJ\u0010KJ7\u0010Q\u001A\u00020\t2\u0006\u0010L\u001A\u00020 2\u0006\u0010M\u001A\u00020\u00172\u0006\u0010N\u001A\u00020\u00172\u0006\u0010O\u001A\u00020\u00172\u0006\u0010P\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\bQ\u0010RJ?\u0010T\u001A\u00020\t2\u0006\u0010L\u001A\u00020 2\u0006\u0010M\u001A\u00020\u00172\u0006\u0010N\u001A\u00020\u00172\u0006\u0010O\u001A\u00020\u00172\u0006\u0010P\u001A\u00020\u00172\u0006\u0010S\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\bT\u0010UJ7\u0010V\u001A\u00020\t2\u0006\u0010L\u001A\u00020 2\u0006\u0010M\u001A\u00020\u00172\u0006\u0010N\u001A\u00020\u00172\u0006\u0010O\u001A\u00020\u00172\u0006\u0010P\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\bV\u0010RJ\u000F\u0010W\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bW\u0010\u0003J\u000F\u0010X\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bX\u0010\u0003J\u0017\u0010[\u001A\u00020Z2\u0006\u0010Y\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001A\u00020^2\u0006\u0010]\u001A\u00020ZH\u0002\u00A2\u0006\u0004\b_\u0010`J\u0017\u0010b\u001A\u00020\t2\u0006\u0010a\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001A\u00020^2\u0006\u0010a\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001A\u00020^2\u0006\u0010f\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bg\u0010hJ\u001B\u0010k\u001A\u00020\t2\n\b\u0002\u0010j\u001A\u0004\u0018\u00010iH\u0002\u00A2\u0006\u0004\bk\u0010lJ\u000F\u0010m\u001A\u00020^H\u0002\u00A2\u0006\u0004\bm\u0010nJ\u0017\u0010q\u001A\u00020^2\u0006\u0010p\u001A\u00020oH\u0002\u00A2\u0006\u0004\bq\u0010rJ\u0017\u0010u\u001A\u00020\t2\u0006\u0010t\u001A\u00020sH\u0002\u00A2\u0006\u0004\bu\u0010vJ\u0017\u0010y\u001A\u00020^2\u0006\u0010x\u001A\u00020wH\u0002\u00A2\u0006\u0004\by\u0010zJ\u001F\u0010~\u001A\u00020\t2\u0006\u0010{\u001A\u00020\u00172\u0006\u0010}\u001A\u00020|H\u0002\u00A2\u0006\u0004\b~\u0010\u007FJ,\u0010~\u001A\u00020\t2\u0006\u0010{\u001A\u00020\u00172\n\u0010\u0081\u0001\u001A\u0005\u0018\u00010\u0080\u00012\u0006\u0010}\u001A\u00020|H\u0002\u00A2\u0006\u0005\b~\u0010\u0082\u0001J:\u0010~\u001A\u00020\t2\n\u0010\u0084\u0001\u001A\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0085\u0001\u001A\u00020\u00172\n\u0010\u0081\u0001\u001A\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0086\u0001\u001A\u00020 H\u0002\u00A2\u0006\u0005\b~\u0010\u0087\u0001JC\u0010~\u001A\u00020\t2\n\u0010\u0084\u0001\u001A\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0085\u0001\u001A\u00020\u00172\n\u0010\u0081\u0001\u001A\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0086\u0001\u001A\u00020 2\u0007\u0010\u0088\u0001\u001A\u00020 H\u0002\u00A2\u0006\u0005\b~\u0010\u0089\u0001J&\u0010\u008D\u0001\u001A\u0016\u0012\u0005\u0012\u00030\u008B\u00010\u008A\u0001j\n\u0012\u0005\u0012\u00030\u008B\u0001`\u008C\u0001H\u0002\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J\u0011\u0010\u008F\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0005\b\u008F\u0001\u0010\u0003J\u001E\u0010\u0092\u0001\u001A\u00020\t2\n\u0010\u0091\u0001\u001A\u0005\u0018\u00010\u0090\u0001H\u0002\u00A2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0011\u0010\u0094\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0005\b\u0094\u0001\u0010\u0003J\u0011\u0010\u0095\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0005\b\u0095\u0001\u0010\u0003J\u0011\u0010\u0096\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0005\b\u0096\u0001\u0010\u0003J\u0011\u0010\u0097\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0005\b\u0097\u0001\u0010\u0003R\u0018\u0010\u0099\u0001\u001A\u00030\u0098\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009A\u0001R\u001E\u0010\u009C\u0001\u001A\u00070\u009B\u0001R\u00020\u00008\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u009C\u0001\u0010\u009D\u0001R\u0017\u0010Y\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\bY\u0010\u009E\u0001R\u001B\u0010\u009F\u0001\u001A\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009F\u0001\u0010\u00A0\u0001R\u0019\u0010\u00A1\u0001\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A1\u0001\u0010\u009E\u0001R\u0019\u0010\u00A2\u0001\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A2\u0001\u0010\u009E\u0001R\u0019\u0010\u00A3\u0001\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A3\u0001\u0010\u009E\u0001R\u0019\u0010\u00A4\u0001\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A4\u0001\u0010\u009E\u0001R\u0019\u0010\u00A5\u0001\u001A\u00020 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A5\u0001\u0010\u00A6\u0001R*\u0010\u00A8\u0001\u001A\u00020\u00042\u0007\u0010\u00A7\u0001\u001A\u00020\u00048\u0002@BX\u0082\u000E\u00A2\u0006\u0010\n\u0006\b\u00A8\u0001\u0010\u00A9\u0001\"\u0006\b\u00AA\u0001\u0010\u00AB\u0001R(\u0010p\u001A\u00020o2\u0007\u0010\u00A7\u0001\u001A\u00020o8\u0002@BX\u0082\u000E\u00A2\u0006\u000F\n\u0005\bp\u0010\u00AC\u0001\"\u0006\b\u00AD\u0001\u0010\u00AE\u0001R(\u0010x\u001A\u00020w2\u0007\u0010\u00A7\u0001\u001A\u00020w8\u0002@BX\u0082\u000E\u00A2\u0006\u000F\n\u0005\bx\u0010\u00AF\u0001\"\u0006\b\u00B0\u0001\u0010\u00B1\u0001R)\u0010\u00B2\u0001\u001A\u0014\u0012\u0004\u0012\u00020F0\u008A\u0001j\t\u0012\u0004\u0012\u00020F`\u008C\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00B2\u0001\u0010\u00B3\u0001R!\u0010\u00B9\u0001\u001A\u00030\u00B4\u00018VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u00B5\u0001\u0010\u00B6\u0001\u001A\u0006\b\u00B7\u0001\u0010\u00B8\u0001R\u0018\u0010\u00BB\u0001\u001A\u00030\u00BA\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BB\u0001\u0010\u00BC\u0001R\u0018\u0010\u00BD\u0001\u001A\u00030\u00BA\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BD\u0001\u0010\u00BC\u0001R\u0018\u0010\u00C1\u0001\u001A\u00030\u00BE\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00BF\u0001\u0010\u00C0\u0001R\u0018\u0010}\u001A\u0004\u0018\u00010|8BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00C2\u0001\u0010\u00C3\u0001R\u001A\u0010\u00C7\u0001\u001A\u0005\u0018\u00010\u00C4\u00018BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00C5\u0001\u0010\u00C6\u0001\u00A8\u0006\u00CB\u0001"}, d2 = {"Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "<init>", "()V", "", "showSpaceViewBottomButtonParallax", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "getContsId", "()Ljava/lang/String;", "getContsTypeCode", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "onAppBarCollapsed", "onAppBarExpended", "", "offset", "onAppBarScrolling", "(I)V", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "infoCmtContsRes", "updateCommentCountView", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "getCacheKey", "getDetailCacheKey", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "sumCount", "isLike", "updateLikeView", "(Ljava/lang/Integer;Z)V", "updateHeaderView", "addAll", "", "Lcom/melon/net/res/common/SongInfoBase;", "getAllSongList", "()Ljava/util/List;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "getOnViewHolderActionListener", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "ordNum", "image", "metaId", "metaName", "metaAuthor", "songThumbClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cType", "songPlayClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "songMoreClickLog", "clickMoreButton", "showContextPopupCastDetail", "castSeq", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes;", "requestCastEpisodeDetail", "(Ljava/lang/String;)Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes;", "response", "Lkotlinx/coroutines/Job;", "drawHeaderView", "(Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes;)Lkotlinx/coroutines/Job;", "progSeq", "clickSubscribeProgram", "(Ljava/lang/String;)V", "requestSubscriptionProgram", "(Ljava/lang/String;)Lkotlinx/coroutines/Job;", "isSubscribe", "updateSubscriptionLayout", "(Z)Lkotlinx/coroutines/Job;", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "likeInfoListener", "clickCastLike", "(Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;)V", "requestCastLikeInfo", "()Lkotlinx/coroutines/Job;", "Lcom/iloen/melon/fragments/detail/Like;", "like", "updateLikeLayout", "(Lcom/iloen/melon/fragments/detail/Like;)Lkotlinx/coroutines/Job;", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastInfo;", "castInfo", "clickShareButton", "(Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastInfo;)V", "Lcom/iloen/melon/fragments/detail/Comment;", "comment", "updateCommentLayout", "(Lcom/iloen/melon/fragments/detail/Comment;)Lkotlinx/coroutines/Job;", "desc", "LJ8/d3;", "headerBinding", "setDescText", "(Ljava/lang/String;LJ8/d3;)V", "Landroid/text/SpannableString;", "spannableText", "(Ljava/lang/String;Landroid/text/SpannableString;LJ8/d3;)V", "Landroid/widget/TextView;", "textView", "text", "maxLine", "(Landroid/widget/TextView;Ljava/lang/String;Landroid/text/SpannableString;I)V", "count", "(Landroid/widget/TextView;Ljava/lang/String;Landroid/text/SpannableString;II)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "Lkotlin/collections/ArrayList;", "getAllSongPlayableList", "()Ljava/util/ArrayList;", "gnbMoreClickLog", "Lcom/iloen/melon/net/v5x/response/CastInfoBase$Creator;", "creators", "headerCreatorClickLog", "(Lcom/iloen/melon/net/v5x/response/CastInfoBase$Creator;)V", "headerProgramClickLog", "headerDescShowMoreClickLog", "headerCommentClickLog", "playStationClickLog", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment$StationEpisodeDetailAdapter;", "detailAdapter", "Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment$StationEpisodeDetailAdapter;", "Ljava/lang/String;", "castEpisodeDetailRes", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes;", "titleText", "castTitle", "programTitle", "programSeq", "songListHeaderPosition", "I", "value", "isSubscription", "Z", "setSubscription", "(Z)V", "Lcom/iloen/melon/fragments/detail/Like;", "setLike", "(Lcom/iloen/melon/fragments/detail/Like;)V", "Lcom/iloen/melon/fragments/detail/Comment;", "setComment", "(Lcom/iloen/melon/fragments/detail/Comment;)V", "playSongList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData$delegate", "Lie/j;", "getBottomBtnData", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "subExceptionHandler", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "getHeaderBinding", "()LJ8/d3;", "Lp8/f;", "getBaseTiaraEventBuilder", "()Lp8/f;", "baseTiaraEventBuilder", "Companion", "ItemDecoration", "StationEpisodeDetailAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StationEpisodeDetailFragment extends DetailSongMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "DISPLAY_COUNT_MIN", "", "newInstance", "Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment;", "castSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final StationEpisodeDetailFragment newInstance(@NotNull String s) {
            q.g(s, "castSeq");
            StationEpisodeDetailFragment stationEpisodeDetailFragment0 = new StationEpisodeDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            stationEpisodeDetailFragment0.setArguments(bundle0);
            return stationEpisodeDetailFragment0;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment$ItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "()V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.StationEpisodeDetailAdapter");
            if(v == ((StationEpisodeDetailAdapter)j00).getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(context0, 40.0f);
            }
        }
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\'\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u001C\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ#\u0010#\u001A\u00020\"2\u0006\u0010\u0014\u001A\u00020\u00132\n\u0010!\u001A\u00060 R\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010$J#\u0010&\u001A\u00020%2\u0006\u0010\u0014\u001A\u00020\u00132\n\u0010!\u001A\u00060 R\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\'R\u001A\u0010(\u001A\u00020\u00158\u0006X\u0086D¢\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+R\u001A\u0010,\u001A\u00020\u00158\u0006X\u0086D¢\u0006\f\n\u0004\b,\u0010)\u001A\u0004\b-\u0010+R\u001A\u0010.\u001A\u00020\u00158\u0006X\u0086D¢\u0006\f\n\u0004\b.\u0010)\u001A\u0004\b/\u0010+R\u001A\u00100\u001A\u00020\u00158\u0006X\u0086D¢\u0006\f\n\u0004\b0\u0010)\u001A\u0004\b1\u0010+¨\u00062"}, d2 = {"Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment$StationEpisodeDetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Landroid/content/Context;", "context", "", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/StationEpisodeDetailFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Landroidx/recyclerview/widget/O0;", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "getCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "getEmptyCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "viewTypeCastListHeader", "I", "getViewTypeCastListHeader", "()I", "viewTypeOtherCast", "getViewTypeOtherCast", "viewTypeRecmStation", "getViewTypeRecmStation", "viewTypeRelatContsInfo", "getViewTypeRelatContsInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class StationEpisodeDetailAdapter extends DetailAdapter {
        private final int viewTypeCastListHeader;
        private final int viewTypeOtherCast;
        private final int viewTypeRecmStation;
        private final int viewTypeRelatContsInfo;

        public StationEpisodeDetailAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.viewTypeCastListHeader = 1001;
            this.viewTypeOtherCast = 1002;
            this.viewTypeRecmStation = 1003;
            this.viewTypeRelatContsInfo = 1004;
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
        public EmptyCommentHolder getEmptyCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder.Companion.newInstance$default(EmptyCommentHolder.Companion, viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0, false, 4, null);
        }

        public final int getViewTypeCastListHeader() {
            return this.viewTypeCastListHeader;
        }

        public final int getViewTypeOtherCast() {
            return this.viewTypeOtherCast;
        }

        public final int getViewTypeRecmStation() {
            return this.viewTypeRecmStation;
        }

        public final int getViewTypeRelatContsInfo() {
            return this.viewTypeRelatContsInfo;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            CastEpsdDetailRes castEpsdDetailRes0 = httpResponse0 instanceof CastEpsdDetailRes ? ((CastEpsdDetailRes)httpResponse0) : null;
            if(castEpsdDetailRes0 == null) {
                return false;
            }
            Response castEpsdDetailRes$Response0 = castEpsdDetailRes0.response;
            if(castEpsdDetailRes$Response0 == null) {
                return false;
            }
            CastInfo castEpsdDetailRes$Response$CastInfo0 = castEpsdDetailRes$Response0.castInfo;
            if(castEpsdDetailRes$Response$CastInfo0 == null) {
                return false;
            }
            SongInfo castEpsdDetailRes$Response$SongInfo0 = castEpsdDetailRes$Response0.songInfo;
            if(castEpsdDetailRes$Response$SongInfo0 == null) {
                return false;
            }
            OtherCastInfo castEpsdDetailRes$Response$OtherCastInfo0 = castEpsdDetailRes$Response0.otherCastInfo;
            if(castEpsdDetailRes$Response$OtherCastInfo0 == null) {
                return false;
            }
            RecmStationInfo castEpsdDetailRes$Response$RecmStationInfo0 = castEpsdDetailRes$Response0.recmStationInfo;
            if(castEpsdDetailRes$Response$RecmStationInfo0 == null) {
                return false;
            }
            RelatContsInfo castEpsdDetailRes$Response$RelatContsInfo0 = castEpsdDetailRes$Response0.relatContsInfo;
            if(castEpsdDetailRes$Response$RelatContsInfo0 == null) {
                return false;
            }
            ArrayList arrayList0 = new ArrayList();
            StationEpisodeDetailFragment.this.playSongList.clear();
            this.setMenuId(castEpsdDetailRes0.getMenuId());
            this.setHasMore(false);
            this.updateModifiedTime(s);
            if(castEpsdDetailRes$Response$SongInfo0.songList != null && !castEpsdDetailRes$Response$SongInfo0.songList.isEmpty() == 1) {
                LogU.debug$default(StationEpisodeDetailFragment.this.log, "handleResponse() added songInfo", null, false, 6, null);
                a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a0.a = this.viewTypeCastListHeader;
                a0.b = castEpsdDetailRes$Response$SongInfo0.totalPlayTime;
                a0.e = StationEpisodeDetailFragment.this.getContsId();
                a0.c = this.getMenuId();
                arrayList0.add(new AdapterInViewHolder.Row(a0));
                StationEpisodeDetailFragment.this.songListHeaderPosition = arrayList0.size();
                ArrayList arrayList1 = castEpsdDetailRes$Response$SongInfo0.songList;
                q.f(arrayList1, "songList");
                StationEpisodeDetailFragment stationEpisodeDetailFragment0 = StationEpisodeDetailFragment.this;
                for(Object object0: arrayList1) {
                    SongList castEpsdDetailRes$Response$SongInfo$SongList0 = (SongList)object0;
                    a a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a1.a = 1;
                    a1.b = castEpsdDetailRes$Response$SongInfo$SongList0;
                    a1.e = castEpsdDetailRes$Response$CastInfo0.castSeq;
                    a1.c = this.getMenuId();
                    arrayList0.add(new AdapterInViewHolder.Row(a1));
                    if(q.b(castEpsdDetailRes$Response$SongInfo$SongList0.cType, "1") && castEpsdDetailRes$Response$SongInfo$SongList0.canService) {
                        stationEpisodeDetailFragment0.playSongList.add(castEpsdDetailRes$Response$SongInfo$SongList0);
                    }
                }
            }
            if(castEpsdDetailRes$Response$OtherCastInfo0.castList != null && !castEpsdDetailRes$Response$OtherCastInfo0.castList.isEmpty() == 1 && castEpsdDetailRes$Response$OtherCastInfo0.castList.size() >= 3) {
                LogU.debug$default(StationEpisodeDetailFragment.this.log, "handleResponse() added otherCastInfo", null, false, 6, null);
                a a2 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a2.a = this.viewTypeOtherCast;
                a2.b = castEpsdDetailRes$Response$OtherCastInfo0;
                a2.e = castEpsdDetailRes$Response$CastInfo0.progSeq;
                a2.g = true;
                a2.c = this.getMenuId();
                arrayList0.add(new AdapterInViewHolder.Row(a2));
            }
            if(castEpsdDetailRes$Response$RecmStationInfo0.castList != null && !castEpsdDetailRes$Response$RecmStationInfo0.castList.isEmpty() == 1) {
                LogU.debug$default(StationEpisodeDetailFragment.this.log, "handleResponse() added recmStationInfo", null, false, 6, null);
                a a3 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a3.a = this.viewTypeRecmStation;
                a3.b = castEpsdDetailRes$Response$RecmStationInfo0;
                a3.c = this.getMenuId();
                arrayList0.add(new AdapterInViewHolder.Row(a3));
            }
            if(castEpsdDetailRes$Response$RelatContsInfo0.relatContsList != null && !castEpsdDetailRes$Response$RelatContsInfo0.relatContsList.isEmpty() == 1) {
                LogU.debug$default(StationEpisodeDetailFragment.this.log, "handleResponse() added relatContsInfo", null, false, 6, null);
                a a4 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a4.a = this.viewTypeRelatContsInfo;
                a4.b = castEpsdDetailRes$Response$RelatContsInfo0;
                a4.c = this.getMenuId();
                arrayList0.add(new AdapterInViewHolder.Row(a4));
            }
            this.addAll(arrayList0);
            return true;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof SongListHeaderHolder) {
                AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)this.getItem(v1);
                Object object0 = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getItem();
                q.e(object0, "null cannot be cast to non-null type kotlin.String");
                ((SongListHeaderHolder)o00).getBinding().b.setText(((String)object0));
                return;
            }
            super.onBindViewImpl(o00, v, v1);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.viewTypeCastListHeader) {
                return SongListHeaderHolder.Companion.newInstance(viewGroup0);
            }
            if(v == this.viewTypeOtherCast) {
                OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0 = StationEpisodeDetailFragment.this.getOnViewHolderActionListener();
                return OtherCastHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
            }
            if(v == this.viewTypeRecmStation) {
                OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener1 = StationEpisodeDetailFragment.this.getOnViewHolderActionListener();
                return RecommendCastHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener1);
            }
            if(v == this.viewTypeRelatContsInfo) {
                OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener2 = StationEpisodeDetailFragment.this.getOnViewHolderActionListener();
                return RelateContentsHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener2);
            }
            return super.onCreateViewHolderImpl(viewGroup0, v);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int DISPLAY_COUNT_MIN = 3;
    @NotNull
    private static final String TAG = "StationEpisodeDetailFragment";
    @NotNull
    private final j bottomBtnData$delegate;
    @Nullable
    private CastEpsdDetailRes castEpisodeDetailRes;
    @NotNull
    private String castSeq;
    @NotNull
    private String castTitle;
    @NotNull
    private Comment comment;
    private StationEpisodeDetailAdapter detailAdapter;
    private boolean isSubscription;
    @NotNull
    private Like like;
    @NotNull
    private final LogU log;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    @NotNull
    private final ArrayList playSongList;
    @NotNull
    private String programSeq;
    @NotNull
    private String programTitle;
    private int songListHeaderPosition;
    @NotNull
    private final CoroutineExceptionHandler subExceptionHandler;
    @NotNull
    private String titleText;

    static {
        StationEpisodeDetailFragment.Companion = new Companion(null);
        StationEpisodeDetailFragment.$stable = 8;
    }

    public StationEpisodeDetailFragment() {
        this.log = Z.g("StationEpisodeDetailFragment", true);
        this.castSeq = "";
        this.titleText = "";
        this.castTitle = "";
        this.programTitle = "";
        this.programSeq = "";
        this.like = new Like(0, false, 3, null);
        this.comment = new Comment(0, false, false, 7, null);
        this.playSongList = new ArrayList();
        this.bottomBtnData$delegate = g.Q(new b(this, 7));
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.mainExceptionHandler.1.1(throwable0, StationEpisodeDetailFragment.this, null), 3, null);
            }
        };
        this.subExceptionHandler = new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                Y.w("subExceptionHandler message = ", throwable0.getMessage(), LogU.Companion, "StationEpisodeDetailFragment");
            }
        };

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/iloen/melon/fragments/detail/StationEpisodeDetailFragment$bottomBtnData$2$1", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "Lie/H;", "onPlayAllSongClick", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.bottomBtnData.2.1 implements BottomBtnClickListener {
            public com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.bottomBtnData.2.1(StationEpisodeDetailFragment stationEpisodeDetailFragment0) {
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onAddSongClick() {
                BottomBtnClickListener.super.onAddSongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onMixUpPlayClick() {
                BottomBtnClickListener.super.onMixUpPlayClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlayAllSongClick() {
                StationEpisodeDetailFragment.this.getOnViewHolderActionListener().onPlayRadioCast(StationEpisodeDetailFragment.access$getCastSeq$p(StationEpisodeDetailFragment.this));
                StationEpisodeDetailFragment.access$playStationClickLog(StationEpisodeDetailFragment.this);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlaySongClick() {
                BottomBtnClickListener.super.onPlaySongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onShuffleSongClick() {
                BottomBtnClickListener.super.onShuffleSongClick();
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.detail.StationEpisodeDetailFragment$mainExceptionHandler$1$1", f = "StationEpisodeDetailFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.mainExceptionHandler.1.1(Throwable throwable0, StationEpisodeDetailFragment stationEpisodeDetailFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.mainExceptionHandler.1.1(this.$throwable, StationEpisodeDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    LogU.error$default(StationEpisodeDetailFragment.access$getLog$p(StationEpisodeDetailFragment.this), va.e.b("mainExceptionHandler message: ", this.$throwable.getMessage()), null, false, 6, null);
                    StationEpisodeDetailFragment.this.showNetworkErrorHeaderView(true);
                    StationEpisodeDetailFragment.access$getMResponseErrorListener$p$s1245339624(StationEpisodeDetailFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s1245339624(StationEpisodeDetailFragment stationEpisodeDetailFragment0) {
        return stationEpisodeDetailFragment0.mResponseErrorListener;
    }

    public static final void access$playStationClickLog(StationEpisodeDetailFragment stationEpisodeDetailFragment0) {
        stationEpisodeDetailFragment0.playStationClickLog();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void addAll() {
        LogU.info$default(this.log, "addAll()", null, false, 6, null);
        ArrayList arrayList0 = this.getAllSongPlayableList();
        if(!arrayList0.isEmpty()) {
            AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(this.getActivity(), new AddPlayableList(null, Add.INSTANCE, false, false, false, null, arrayList0, 0x20, null), false, 2, null);
        }
    }

    private static final BottomBtnData bottomBtnData_delegate$lambda$1(StationEpisodeDetailFragment stationEpisodeDetailFragment0) {
        return new BottomBtnData(0.0f, k.e(new BottomBtnInfo[]{new BottomBtnInfo(10002, 0.0f, (stationEpisodeDetailFragment0.getContext() == null ? "" : "스테이션 재생"))}), new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.bottomBtnData.2.1(stationEpisodeDetailFragment0));
    }

    private final void clickCastLike(OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        LogU.info$default(this.log, "clickCastLike()", null, false, 6, null);
        if(!this.like.isLiked() && this.isLoginUser()) {
            new LikeAnimationPopup(this.getActivity()).show();
        }
        this.updateSubscribe(this.getContsId(), "N10082", !this.like.isLiked(), this.getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                if(!likeUpdateAsyncTask$OnJobFinishListener0.isFragmentValid()) {
                    return;
                }
                if(s.length() > 0) {
                    likeUpdateAsyncTask$OnJobFinishListener0.showErrorPopup(s, false);
                    return;
                }
                OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0 = this.$likeInfoListener;
                if(likeUpdateAsyncTask$OnJobFinishListener0 != null) {
                    likeUpdateAsyncTask$OnJobFinishListener0.onJobComplete(s, v, z);
                }
                Like like0 = new Like(v, z);
                likeUpdateAsyncTask$OnJobFinishListener0.setLike(like0);
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
            }
        });
    }

    public static void clickCastLike$default(StationEpisodeDetailFragment stationEpisodeDetailFragment0, OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0, int v, Object object0) {
        if((v & 1) != 0) {
            likeUpdateAsyncTask$OnJobFinishListener0 = null;
        }
        stationEpisodeDetailFragment0.clickCastLike(likeUpdateAsyncTask$OnJobFinishListener0);
    }

    private final void clickMoreButton() {
        LogU.info$default(this.log, "clickMoreButton()", null, false, 6, null);
        this.showContextPopupCastDetail();
        this.gnbMoreClickLog();
    }

    private final void clickShareButton(CastInfo castEpsdDetailRes$Response$CastInfo0) {
        LogU.info$default(this.log, "clickShareButton()", null, false, 6, null);
        String s = castEpsdDetailRes$Response$CastInfo0.castSeq;
        q.f(s, "castSeq");
        String s1 = castEpsdDetailRes$Response$CastInfo0.castTitle;
        q.f(s1, "castTitle");
        String s2 = castEpsdDetailRes$Response$CastInfo0.verticalImgUrl;
        q.f(s2, "verticalImgUrl");
        String s3 = CreatorInfoBase.getFirstNameAndNumber(this.getContext(), castEpsdDetailRes$Response$CastInfo0.creator);
        q.f(s3, "getFirstNameAndNumber(...)");
        ShareLinkData shareLinkData0 = castEpsdDetailRes$Response$CastInfo0.snsInfo;
        q.f(shareLinkData0, "snsInfo");
        SharableCastEpisode sharableCastEpisode0 = new SharableCastEpisode();  // 初始化器: Ljava/lang/Object;-><init>()V
        sharableCastEpisode0.a = s;
        sharableCastEpisode0.b = s1;
        sharableCastEpisode0.d = s2;
        sharableCastEpisode0.e = s3;
        sharableCastEpisode0.f = shareLinkData0;
        this.showSNSListPopup(sharableCastEpisode0);
    }

    private final void clickSubscribeProgram(String s) {
        this.updateSubscribe(s, "N10083", !this.isSubscription, this.getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                if(!StationEpisodeDetailFragment.this.isFragmentValid()) {
                    return;
                }
                if(s.length() > 0) {
                    StationEpisodeDetailFragment.this.showErrorPopup(s, false);
                    return;
                }
                StationEpisodeDetailFragment.this.setSubscription(z);
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        StationEpisodeDetailAdapter stationEpisodeDetailFragment$StationEpisodeDetailAdapter0 = new StationEpisodeDetailAdapter(this, context0, null);
        this.detailAdapter = stationEpisodeDetailFragment$StationEpisodeDetailAdapter0;
        return stationEpisodeDetailFragment$StationEpisodeDetailAdapter0;
    }

    private final Job drawHeaderView(CastEpsdDetailRes castEpsdDetailRes0) {
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), null, new n(castEpsdDetailRes0, null) {
            final CastEpsdDetailRes $response;
            int label;

            {
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                this.$response = castEpsdDetailRes0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1(StationEpisodeDetailFragment.this, this.$response, continuation0);
            }

            public static void d(CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$1(castEpsdDetailRes$Response$CastInfo0, view0);
            }

            public static void e(BUTTONINFO castEpsdDetailRes$Response$CastInfo$BUTTONINFO0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$5(castEpsdDetailRes$Response$CastInfo$BUTTONINFO0, view0);
            }

            public static void f(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$2(stationEpisodeDetailFragment0, castEpsdDetailRes$Response$CastInfo0, view0);
            }

            public static void g(StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$8(stationEpisodeDetailFragment0, view0);
            }

            public static void h(StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$7(stationEpisodeDetailFragment0, view0);
            }

            public static void i(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$4(castEpsdDetailRes$Response$CastInfo0, stationEpisodeDetailFragment0, view0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                LogU.info$default(StationEpisodeDetailFragment.this.log, "drawHeaderView()", null, false, 6, null);
                d3 d30 = StationEpisodeDetailFragment.this.getHeaderBinding();
                H h0 = H.a;
                if(d30 != null) {
                    e3 e30 = d30.x;
                    MelonTextView melonTextView0 = d30.g;
                    MelonTextView melonTextView1 = d30.r;
                    StationEpisodeDetailFragment stationEpisodeDetailFragment0 = StationEpisodeDetailFragment.this;
                    CastInfo castEpsdDetailRes$Response$CastInfo0 = this.$response.response.castInfo;
                    if(castEpsdDetailRes$Response$CastInfo0 != null) {
                        String s = castEpsdDetailRes$Response$CastInfo0.castTitle;
                        q.f(s, "castTitle");
                        stationEpisodeDetailFragment0.titleText = s;
                        Glide.with(d30.u.b).load(castEpsdDetailRes$Response$CastInfo0.verticalImgUrl).into(d30.u.b);
                        T t0 = new T(castEpsdDetailRes$Response$CastInfo0, 0);
                        ViewUtils.setOnClickListener(d30.w, t0);
                        d30.e.setText(castEpsdDetailRes$Response$CastInfo0.castTitle);
                        melonTextView0.setText(CreatorInfoBase.getCreatorNames(stationEpisodeDetailFragment0.getContext(), castEpsdDetailRes$Response$CastInfo0.creator));
                        ViewUtils.setOnClickListener(melonTextView0, new U(stationEpisodeDetailFragment0, castEpsdDetailRes$Response$CastInfo0, 0));
                        d30.d.setText(castEpsdDetailRes$Response$CastInfo0.castDate);
                        int v = ScreenUtils.dipToPixel(stationEpisodeDetailFragment0.getContext(), 32.0f);
                        ViewUtils.setDefaultImage(e30.c, v, true);
                        Glide.with(e30.b).load(castEpsdDetailRes$Response$CastInfo0.progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(e30.b);
                        d30.t.setText(castEpsdDetailRes$Response$CastInfo0.progTitle);
                        U u0 = new U(stationEpisodeDetailFragment0, castEpsdDetailRes$Response$CastInfo0);
                        ViewUtils.setOnClickListener(d30.s, u0);
                        String s1 = castEpsdDetailRes$Response$CastInfo0.castDesc;
                        q.f(s1, "castDesc");
                        stationEpisodeDetailFragment0.setDescText(s1, d30);
                        BUTTONINFO castEpsdDetailRes$Response$CastInfo$BUTTONINFO0 = castEpsdDetailRes$Response$CastInfo0.buttonInfo;
                        if(castEpsdDetailRes$Response$CastInfo$BUTTONINFO0 == null || (castEpsdDetailRes$Response$CastInfo$BUTTONINFO0.linkName == null || castEpsdDetailRes$Response$CastInfo$BUTTONINFO0.linkName.length() <= 0)) {
                            melonTextView1.setVisibility(8);
                        }
                        else {
                            melonTextView1.setVisibility(0);
                            melonTextView1.setText(castEpsdDetailRes$Response$CastInfo$BUTTONINFO0.linkName);
                            melonTextView1.setOnClickListener(new T(castEpsdDetailRes$Response$CastInfo$BUTTONINFO0, 1));
                        }
                        stationEpisodeDetailFragment0.updateSubscriptionLayout(stationEpisodeDetailFragment0.isSubscription);
                        String s2 = castEpsdDetailRes$Response$CastInfo0.progSeq;
                        q.f(s2, "progSeq");
                        stationEpisodeDetailFragment0.requestSubscriptionProgram(s2);
                        U u1 = new U(stationEpisodeDetailFragment0, castEpsdDetailRes$Response$CastInfo0, 2);
                        ViewUtils.setOnClickListener(d30.v, u1);
                        stationEpisodeDetailFragment0.updateLikeLayout(stationEpisodeDetailFragment0.like);
                        stationEpisodeDetailFragment0.requestCastLikeInfo();
                        V v1 = new V(stationEpisodeDetailFragment0, 0);
                        ViewUtils.setOnClickListener(d30.b, v1);
                        stationEpisodeDetailFragment0.updateCommentLayout(stationEpisodeDetailFragment0.comment);
                        V v2 = new V(stationEpisodeDetailFragment0, 1);
                        ViewUtils.setOnClickListener(d30.p, v2);
                        U u2 = new U(stationEpisodeDetailFragment0, castEpsdDetailRes$Response$CastInfo0, 3);
                        ViewUtils.setOnClickListener(d30.c, u2);
                    }
                }
                return h0;
            }

            private static final void invokeSuspend$lambda$10$lambda$1(CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                String s = castEpsdDetailRes$Response$CastInfo0.verticalImgUrl;
                q.f(s, "verticalImgUrl");
                if(s.length() > 0) {
                    Navigator.openPhotoUrl(castEpsdDetailRes$Response$CastInfo0.verticalImgUrl);
                }
            }

            private static final void invokeSuspend$lambda$10$lambda$2(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                stationEpisodeDetailFragment0.showMultiCreatorPopup(castEpsdDetailRes$Response$CastInfo0.creator);
                stationEpisodeDetailFragment0.headerCreatorClickLog(castEpsdDetailRes$Response$CastInfo0.creator);
            }

            private static final void invokeSuspend$lambda$10$lambda$4(CastInfo castEpsdDetailRes$Response$CastInfo0, StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
                String s = castEpsdDetailRes$Response$CastInfo0.progSeq;
                q.f(s, "progSeq");
                Hd.T t0 = new Hd.T();
                Bundle bundle0 = new Bundle();
                bundle0.putString("argItemId", s);
                t0.setArguments(bundle0);
                Navigator.INSTANCE.open(t0);
                stationEpisodeDetailFragment0.headerProgramClickLog();
            }

            private static final void invokeSuspend$lambda$10$lambda$5(BUTTONINFO castEpsdDetailRes$Response$CastInfo$BUTTONINFO0, View view0) {
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                melonLinkInfo0.a = castEpsdDetailRes$Response$CastInfo$BUTTONINFO0.linkType;
                melonLinkInfo0.b = castEpsdDetailRes$Response$CastInfo$BUTTONINFO0.linkUrl;
                MelonLinkExecutor.open(melonLinkInfo0);
            }

            private static final void invokeSuspend$lambda$10$lambda$6(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                String s = castEpsdDetailRes$Response$CastInfo0.progSeq;
                q.f(s, "progSeq");
                stationEpisodeDetailFragment0.clickSubscribeProgram(s);
            }

            private static final void invokeSuspend$lambda$10$lambda$7(StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
                StationEpisodeDetailFragment.clickCastLike$default(stationEpisodeDetailFragment0, null, 1, null);
            }

            private static final void invokeSuspend$lambda$10$lambda$8(StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
                stationEpisodeDetailFragment0.getOnViewHolderActionListener().onOpenCommentListView();
                stationEpisodeDetailFragment0.headerCommentClickLog();
            }

            private static final void invokeSuspend$lambda$10$lambda$9(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                stationEpisodeDetailFragment0.clickShareButton(castEpsdDetailRes$Response$CastInfo0);
            }

            public static void j(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$6(stationEpisodeDetailFragment0, castEpsdDetailRes$Response$CastInfo0, view0);
            }

            public static void k(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, View view0) {
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.drawHeaderView.1.invokeSuspend$lambda$10$lambda$9(stationEpisodeDetailFragment0, castEpsdDetailRes$Response$CastInfo0, view0);
            }
        }, 2, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public List getAllSongList() {
        return this.playSongList;
    }

    private final ArrayList getAllSongPlayableList() {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.getAllSongList()) {
            String s = this.getMenuId();
            StationEpisodeDetailAdapter stationEpisodeDetailFragment$StationEpisodeDetailAdapter0 = this.detailAdapter;
            if(stationEpisodeDetailFragment$StationEpisodeDetailAdapter0 != null) {
                arrayList0.add(Playable.from(((SongInfoBase)object0), s, stationEpisodeDetailFragment$StationEpisodeDetailAdapter0.getStatsElements()));
                continue;
            }
            q.m("detailAdapter");
            throw null;
        }
        return arrayList0;
    }

    private final f getBaseTiaraEventBuilder() {
        s s0 = this.mMelonTiaraProperty;
        if(s0 != null) {
            f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = s0.a;
            f0.c = s0.b;
            f0.I = s0.c;
            f0.o = this.castSeq;
            f0.p = "N10082";
            f0.q = this.titleText;
            f0.w = this.programTitle;
            f0.x = this.programSeq;
            return f0;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public BottomBtnData getBottomBtnData() {
        return (BottomBtnData)this.bottomBtnData$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.W0.buildUpon(), this.castSeq, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsId() {
        return this.castSeq;
    }

    // 去混淆评级： 低(30)
    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsTypeCode() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getDetailCacheKey() {
        return l1.e(MelonContentUris.W0.buildUpon(), this.castSeq, "toString(...)");
    }

    private final d3 getHeaderBinding() {
        return (d3)this.get_headerBinding();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public OnViewHolderActionListener getOnViewHolderActionListener() {
        return new OnViewHolderActionListener() {
            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onOpenCommentListView() {
                if(StationEpisodeDetailFragment.this.comment.getHasNew()) {
                    StationEpisodeDetailFragment.this.comment.setHasNew(false);
                }
                super.onOpenCommentListView();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onOpenCommentListView(Param cmtListFragment$Param0) {
                q.g(cmtListFragment$Param0, "param");
                if(StationEpisodeDetailFragment.this.comment.getHasNew()) {
                    StationEpisodeDetailFragment.this.comment.setHasNew(false);
                }
                super.onOpenCommentListView(cmtListFragment$Param0);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public f onTiaraEventBuilder() {
                return StationEpisodeDetailFragment.this.getBaseTiaraEventBuilder();
            }
        };
    }

    private final void gnbMoreClickLog() {
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "페이지이동";
            f0.y = "GNB";
            f0.F = "햄버거메뉴";
            f0.a().track();
        }
    }

    private final void headerCommentClickLog() {
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "페이지이동";
            f0.y = "프로그램회차정보";
            f0.F = "댓글";
            f0.a().track();
        }
    }

    private final void headerCreatorClickLog(Creator castInfoBase$Creator0) {
        if(castInfoBase$Creator0 != null) {
            f f0 = this.getBaseTiaraEventBuilder();
            if(f0 != null) {
                f0.a = "페이지이동";
                f0.d = ActionKind.ClickContent;
                f0.y = "프로그램회차정보";
                String s = castInfoBase$Creator0.contsTypeCode;
                String s1 = null;
                if(q.b(s, "N10006")) {
                    f0.e = castInfoBase$Creator0.contsList == null ? null : p.q0(castInfoBase$Creator0.contsList, null, null, null, new com.iloen.melon.fragments.artistchannel.viewholder.f(4), 0x1F);
                    f0.f = castInfoBase$Creator0.contsTypeCode;
                    ArrayList arrayList0 = castInfoBase$Creator0.contsList;
                    if(arrayList0 != null) {
                        s1 = p.q0(arrayList0, null, null, null, new com.iloen.melon.fragments.artistchannel.viewholder.f(5), 0x1F);
                    }
                    f0.g = s1;
                }
                else if(q.b(s, "N10018") || q.b(s, "N10080")) {
                    ArrayList arrayList1 = castInfoBase$Creator0.contsList;
                    if(arrayList1 != null) {
                        s1 = p.q0(arrayList1, null, null, null, new com.iloen.melon.fragments.artistchannel.viewholder.f(6), 0x1F);
                    }
                    f0.h = s1;
                }
                f0.a().track();
            }
        }
    }

    private static final CharSequence headerCreatorClickLog$lambda$25$lambda$22(ContsList creatorInfoBase$ContsList0) {
        CharSequence charSequence0 = creatorInfoBase$ContsList0.id;
        q.f(charSequence0, "id");
        return charSequence0;
    }

    private static final CharSequence headerCreatorClickLog$lambda$25$lambda$23(ContsList creatorInfoBase$ContsList0) {
        CharSequence charSequence0 = creatorInfoBase$ContsList0.name;
        q.f(charSequence0, "name");
        return charSequence0;
    }

    private static final CharSequence headerCreatorClickLog$lambda$25$lambda$24(ContsList creatorInfoBase$ContsList0) {
        CharSequence charSequence0 = creatorInfoBase$ContsList0.name;
        q.f(charSequence0, "name");
        return charSequence0;
    }

    private final void headerDescShowMoreClickLog() {
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "프로그램회차정보";
            f0.a().track();
        }
    }

    private final void headerProgramClickLog() {
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "프로그램회차정보";
            f0.e = this.programSeq;
            f0.f = "N10083";
            f0.g = this.programTitle;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarCollapsed() {
        LogU.info$default(this.log, "onAppBarCollapsed()", null, false, 6, null);
        this.getTitleBar().setTitle(this.titleText);
        this.getTitleBar().f(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarExpended() {
        LogU.info$default(this.log, "onAppBarExpended()", null, false, 6, null);
        this.getTitleBar().setTitle("");
        this.getTitleBar().f(true);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarScrolling(int v) {
        float f = (float)Math.abs(v);
        if(f > 0.0f) {
            this.getTitleBar().setTitle(this.titleText);
            return;
        }
        if(f == 0.0f) {
            this.getTitleBar().f(false);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.updateHeaderView();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0866, null, false);  // layout:station_episode_detail_header
        int v = 0x7F0A014E;  // id:btn_comment
        if(((ImageView)I.C(view0, 0x7F0A014E)) != null) {  // id:btn_comment
            v = 0x7F0A0170;  // id:btn_liked
            View view1 = I.C(view0, 0x7F0A0170);  // id:btn_liked
            if(((CheckableImageView)view1) != null) {
                v = 0x7F0A01B7;  // id:btn_share
                View view2 = I.C(view0, 0x7F0A01B7);  // id:btn_share
                if(((ImageView)view2) != null) {
                    v = 0x7F0A022A;  // id:cast_date
                    View view3 = I.C(view0, 0x7F0A022A);  // id:cast_date
                    if(((MelonTextView)view3) != null) {
                        v = 0x7F0A0230;  // id:cast_title
                        View view4 = I.C(view0, 0x7F0A0230);  // id:cast_title
                        if(((MelonTextView)view4) != null) {
                            v = 0x7F0A02F6;  // id:comment_cnt
                            View view5 = I.C(view0, 0x7F0A02F6);  // id:comment_cnt
                            if(((MelonTextView)view5) != null) {
                                v = 0x7F0A035F;  // id:creator
                                View view6 = I.C(view0, 0x7F0A035F);  // id:creator
                                if(((MelonTextView)view6) != null) {
                                    v = 0x7F0A03A7;  // id:desc_container
                                    View view7 = I.C(view0, 0x7F0A03A7);  // id:desc_container
                                    if(((RelativeLayout)view7) != null) {
                                        v = 0x7F0A03A9;  // id:desc_long
                                        View view8 = I.C(view0, 0x7F0A03A9);  // id:desc_long
                                        if(((MelonTextView)view8) != null) {
                                            v = 0x7F0A03AA;  // id:desc_long_container
                                            View view9 = I.C(view0, 0x7F0A03AA);  // id:desc_long_container
                                            if(((RelativeLayout)view9) != null) {
                                                v = 0x7F0A03AB;  // id:desc_more
                                                View view10 = I.C(view0, 0x7F0A03AB);  // id:desc_more
                                                if(((LinearLayout)view10) != null) {
                                                    v = 0x7F0A03AC;  // id:desc_short
                                                    View view11 = I.C(view0, 0x7F0A03AC);  // id:desc_short
                                                    if(((MelonTextView)view11) != null) {
                                                        v = 0x7F0A03AD;  // id:desc_short_container
                                                        View view12 = I.C(view0, 0x7F0A03AD);  // id:desc_short_container
                                                        if(((RelativeLayout)view12) != null) {
                                                            v = 0x7F0A0634;  // id:iv_hot
                                                            View view13 = I.C(view0, 0x7F0A0634);  // id:iv_hot
                                                            if(((ImageView)view13) != null) {
                                                                v = 0x7F0A0653;  // id:iv_new
                                                                View view14 = I.C(view0, 0x7F0A0653);  // id:iv_new
                                                                if(((ImageView)view14) != null && ((LinearLayout)I.C(view0, 0x7F0A0705)) != null) {  // id:layout_cast_title
                                                                    v = 0x7F0A070E;  // id:layout_comment
                                                                    View view15 = I.C(view0, 0x7F0A070E);  // id:layout_comment
                                                                    if(((LinearLayout)view15) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0711)) != null) {  // id:layout_content
                                                                        v = 0x7F0A076B;  // id:liked_cnt
                                                                        View view16 = I.C(view0, 0x7F0A076B);  // id:liked_cnt
                                                                        if(((MelonTextView)view16) != null) {
                                                                            v = 0x7F0A0778;  // id:link_url
                                                                            View view17 = I.C(view0, 0x7F0A0778);  // id:link_url
                                                                            if(((MelonTextView)view17) != null) {
                                                                                v = 0x7F0A08F5;  // id:owner_container
                                                                                View view18 = I.C(view0, 0x7F0A08F5);  // id:owner_container
                                                                                if(((LinearLayout)view18) != null) {
                                                                                    v = 0x7F0A097A;  // id:program_title
                                                                                    View view19 = I.C(view0, 0x7F0A097A);  // id:program_title
                                                                                    if(((MelonTextView)view19) != null) {
                                                                                        v = 0x7F0A0AE8;  // id:station_thumb
                                                                                        View view20 = I.C(view0, 0x7F0A0AE8);  // id:station_thumb
                                                                                        if(view20 != null) {
                                                                                            f3 f30 = f3.a(view20);
                                                                                            v = 0x7F0A0B02;  // id:subscribe_button
                                                                                            View view21 = I.C(view0, 0x7F0A0B02);  // id:subscribe_button
                                                                                            if(((SubscribeToggleButton)view21) != null && ((FrameLayout)I.C(view0, 0x7F0A0B72)) != null) {  // id:thumb_container
                                                                                                v = 0x7F0A0B75;  // id:thumb_cover
                                                                                                View view22 = I.C(view0, 0x7F0A0B75);  // id:thumb_cover
                                                                                                if(view22 != null) {
                                                                                                    v = 0x7F0A0B79;  // id:thumb_layout
                                                                                                    View view23 = I.C(view0, 0x7F0A0B79);  // id:thumb_layout
                                                                                                    if(view23 != null) {
                                                                                                        e3 e30 = e3.a(view23);
                                                                                                        v = 0x7F0A0DC4;  // id:view_dot
                                                                                                        View view24 = I.C(view0, 0x7F0A0DC4);  // id:view_dot
                                                                                                        if(view24 != null) {
                                                                                                            return new d3(((FrameLayout)view0), ((CheckableImageView)view1), ((ImageView)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((MelonTextView)view5), ((MelonTextView)view6), ((RelativeLayout)view7), ((MelonTextView)view8), ((RelativeLayout)view9), ((LinearLayout)view10), ((MelonTextView)view11), ((RelativeLayout)view12), ((ImageView)view13), ((ImageView)view14), ((LinearLayout)view15), ((MelonTextView)view16), ((MelonTextView)view17), ((LinearLayout)view18), ((MelonTextView)view19), f30, ((SubscribeToggleButton)view21), view22, e30, view24);
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

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        LogU.info$default(this.log, "onFetchStart() type: " + i0, null, false, 6, null);
        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(this, completableJob0.plus(this.mainExceptionHandler), null, new n(completableJob0, null) {
            final CompletableJob $supervisor;
            Object L$0;
            Object L$1;
            int label;

            {
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                this.$supervisor = completableJob0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1(StationEpisodeDetailFragment.this, this.$supervisor, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CastEpsdDetailRes castEpsdDetailRes1 = StationEpisodeDetailFragment.this.requestCastEpisodeDetail(StationEpisodeDetailFragment.this.castSeq);
                        me.i i1 = Dispatchers.getMain().plus(StationEpisodeDetailFragment.this.mainExceptionHandler);
                        com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1.1 stationEpisodeDetailFragment$onFetchStart$1$10 = new n(castEpsdDetailRes1, this.$supervisor, null) {
                            final CastEpsdDetailRes $castEpsdDetailRes;
                            final CompletableJob $supervisor;
                            int label;

                            {
                                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                                this.$castEpsdDetailRes = castEpsdDetailRes0;
                                this.$supervisor = completableJob0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1.1(StationEpisodeDetailFragment.this, this.$castEpsdDetailRes, this.$supervisor, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                boolean z = StationEpisodeDetailFragment.this.prepareFetchComplete(this.$castEpsdDetailRes);
                                H h0 = H.a;
                                if(!z) {
                                    StationEpisodeDetailFragment.this.showNetworkErrorHeaderView(true);
                                    DefaultImpls.cancel$default(this.$supervisor, null, 1, null);
                                    return h0;
                                }
                                StationEpisodeDetailFragment.this.castEpisodeDetailRes = this.$castEpsdDetailRes;
                                String s = this.$castEpsdDetailRes.getMenuId();
                                StationEpisodeDetailFragment.this.mMenuId = s;
                                s s1 = new s(this.$castEpsdDetailRes.response.section, this.$castEpsdDetailRes.response.page, this.$castEpsdDetailRes.getMenuId(), null);
                                StationEpisodeDetailFragment.this.mMelonTiaraProperty = s1;
                                CastInfo castEpsdDetailRes$Response$CastInfo0 = this.$castEpsdDetailRes.response.castInfo;
                                if(castEpsdDetailRes$Response$CastInfo0 != null) {
                                    String s2 = castEpsdDetailRes$Response$CastInfo0.castTitle;
                                    q.f(s2, "castTitle");
                                    StationEpisodeDetailFragment.this.castTitle = s2;
                                    String s3 = castEpsdDetailRes$Response$CastInfo0.progTitle;
                                    q.f(s3, "progTitle");
                                    StationEpisodeDetailFragment.this.programTitle = s3;
                                    String s4 = castEpsdDetailRes$Response$CastInfo0.progSeq;
                                    q.f(s4, "progSeq");
                                    StationEpisodeDetailFragment.this.programSeq = s4;
                                }
                                StationEpisodeDetailFragment.this.drawHeaderView(this.$castEpsdDetailRes);
                                StationEpisodeDetailFragment.this.performFetchComplete(i.b, this.$castEpsdDetailRes);
                                return h0;
                            }
                        };
                        this.L$0 = null;
                        this.label = 1;
                        if(BuildersKt.withContext(i1, stationEpisodeDetailFragment$onFetchStart$1$10, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        CastEpsdDetailRes castEpsdDetailRes2 = (CastEpsdDetailRes)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        me.i i0 = (me.i)this.L$1;
                        CastEpsdDetailRes castEpsdDetailRes0 = (CastEpsdDetailRes)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                me.i i2 = Dispatchers.getMain().plus(StationEpisodeDetailFragment.this.subExceptionHandler);
                com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1.2 stationEpisodeDetailFragment$onFetchStart$1$20 = new n(null) {
                    int label;

                    {
                        StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1.2(StationEpisodeDetailFragment.this, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.onFetchStart.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        CastEpsdDetailRes castEpsdDetailRes0 = StationEpisodeDetailFragment.this.castEpisodeDetailRes;
                        if(castEpsdDetailRes0 != null) {
                            Response castEpsdDetailRes$Response0 = castEpsdDetailRes0.response;
                            if(castEpsdDetailRes$Response0 != null) {
                                String s = castEpsdDetailRes$Response0.bbsChannelSeq;
                                q.f(s, "bbsChannelSeq");
                                String s1 = castEpsdDetailRes$Response0.bbsContsId;
                                q.f(s1, "bbsContsId");
                                CommentLatestList.requestCommentApis$default(StationEpisodeDetailFragment.this, s, s1, false, 4, null);
                            }
                        }
                        return H.a;
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                return BuildersKt.withContext(i2, stationEpisodeDetailFragment$onFetchStart$1$20, this) == a0 ? a0 : H.a;
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
        this.castSeq = s;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.castSeq);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        F8.I i0 = new F8.I(1);
        i0.c = new V(this, 2);
        TitleBar titleBar0 = this.getTitleBar();
        o o0 = B.a.s(7);
        o0.g(i0);
        titleBar0.a(o0);
        m0 m00 = this.getBinding();
        int v = ColorUtils.getColor(m00.d.getContext(), 0x7F06014B);  // color:gray100s_support_high_contrast
        m00.d.setBackgroundColor(v);
        m00.d.setVisibility(8);
        this.updateHeaderView();
    }

    private static final void onViewCreated$lambda$5$lambda$4(StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
        stationEpisodeDetailFragment0.clickMoreButton();
    }

    // 检测为 Lambda 实现
    public static H p0(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, k2 k20) [...]

    private final void playStationClickLog() {
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "음악재생";
            f0.d = ActionKind.PlayMusic;
            f0.y = "프로그램회차정보";
            f0.e = this.castSeq;
            f0.f = "N10082";
            f0.g = this.titleText;
            f0.a().track();
        }
    }

    public static void q0(d3 d30, LayoutParams constraintLayout$LayoutParams0, StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
        StationEpisodeDetailFragment.setDescText$lambda$16$lambda$15(d30, constraintLayout$LayoutParams0, stationEpisodeDetailFragment0, view0);
    }

    public static void r0(d3 d30, LayoutParams constraintLayout$LayoutParams0, StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
        StationEpisodeDetailFragment.setDescText$lambda$16$lambda$14(constraintLayout$LayoutParams0, stationEpisodeDetailFragment0, d30, view0);
    }

    private final CastEpsdDetailRes requestCastEpisodeDetail(String s) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new CastEpsdDetailReq(this.getContext(), s)).tag("StationEpisodeDetailFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.CastEpsdDetailRes");
        return (CastEpsdDetailRes)httpResponse0;
    }

    private final Job requestCastLikeInfo() {
        return BuildersKt__Builders_commonKt.launch$default(this, null, null, new n(null) {
            int label;

            {
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.requestCastLikeInfo.1(StationEpisodeDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.requestCastLikeInfo.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                H h0 = H.a;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                LogU.info$default(StationEpisodeDetailFragment.this.log, "requestCastLikeInfo()", null, false, 6, null);
                Params myMusicLikeInformContentsLikeReq$Params0 = new Params();
                myMusicLikeInformContentsLikeReq$Params0.contsId = StationEpisodeDetailFragment.this.getContsId();
                myMusicLikeInformContentsLikeReq$Params0.contsTypeCode = "N10082";
                myMusicLikeInformContentsLikeReq$Params0.actTypeCode = "N20001";
                try {
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    HttpResponse httpResponse0 = RequestBuilder.newInstance(new MyMusicLikeInformContentsLikeReq(StationEpisodeDetailFragment.this.getContext(), myMusicLikeInformContentsLikeReq$Params0)).tag(StationEpisodeDetailFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes");
                    if(StationEpisodeDetailFragmentKt.isValidResponse(((MyMusicLikeInformContentsLikeRes)httpResponse0))) {
                        RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = ((MyMusicLikeInformContentsLikeRes)httpResponse0).response;
                        if(myMusicLikeInformContentsLikeRes$RESPONSE0 == null) {
                            return h0;
                        }
                        String s = myMusicLikeInformContentsLikeRes$RESPONSE0.summcnt;
                        if(s == null) {
                            return h0;
                        }
                        String s1 = myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn;
                        if(s1 == null) {
                            return h0;
                        }
                        Like like0 = new Like(ProtocolUtils.parseInt(s, 0), ProtocolUtils.parseBoolean(s1));
                        StationEpisodeDetailFragment.this.setLike(like0);
                        return h0;
                    }
                }
                catch(Exception exception0) {
                    LogU.error$default(StationEpisodeDetailFragment.this.log, va.e.b("requestCastLikeInfo() error: ", exception0.getMessage()), null, false, 6, null);
                }
                return h0;
            }
        }, 3, null);
    }

    private final Job requestSubscriptionProgram(String s) {
        return BuildersKt__Builders_commonKt.launch$default(this, null, null, new n(s, null) {
            final String $progSeq;
            int label;

            {
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                this.$progSeq = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.requestSubscriptionProgram.1(StationEpisodeDetailFragment.this, this.$progSeq, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.requestSubscriptionProgram.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                LogU.info$default(StationEpisodeDetailFragment.this.log, "requestSubscriptionProgram() progSeq: " + this.$progSeq, null, false, 6, null);
                com.iloen.melon.net.v5x.request.MyMusicLikeListContentsLikeReq.Params myMusicLikeListContentsLikeReq$Params0 = new com.iloen.melon.net.v5x.request.MyMusicLikeListContentsLikeReq.Params();
                myMusicLikeListContentsLikeReq$Params0.contsTypeCode = "N10083";
                myMusicLikeListContentsLikeReq$Params0.contsIds = this.$progSeq;
                myMusicLikeListContentsLikeReq$Params0.actTypeCode = "N20001";
                try {
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    HttpResponse httpResponse0 = RequestBuilder.newInstance(new MyMusicLikeListContentsLikeReq(StationEpisodeDetailFragment.this.getContext(), myMusicLikeListContentsLikeReq$Params0)).tag(StationEpisodeDetailFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.MyMusicLikeListContentsLikeRes");
                    boolean z = StationEpisodeDetailFragmentKt.isSubscribeProgram(((MyMusicLikeListContentsLikeRes)httpResponse0));
                    StationEpisodeDetailFragment.this.setSubscription(z);
                }
                catch(Exception exception0) {
                    LogU.error$default(StationEpisodeDetailFragment.this.log, va.e.b("requestSubscriptionProgram() error: ", exception0.getMessage()), null, false, 6, null);
                }
                return H.a;
            }
        }, 3, null);
    }

    public static CharSequence s0(ContsList creatorInfoBase$ContsList0) {
        return StationEpisodeDetailFragment.headerCreatorClickLog$lambda$25$lambda$22(creatorInfoBase$ContsList0);
    }

    private final void setComment(Comment comment0) {
        if(q.b(this.comment, comment0)) {
            return;
        }
        LogU.debug$default(this.log, "comment() " + this.comment + " >> " + comment0, null, false, 6, null);
        this.comment = comment0;
        this.updateCommentLayout(comment0);
    }

    private final void setDescText(TextView textView0, String s, SpannableString spannableString0, int v) {
        if(textView0 != null) {
            textView0.setMaxLines(v + 1);
        }
        if(textView0 != null) {
            SpannableString spannableString1 = spannableString0 == null ? s : spannableString0;
            textView0.setText(spannableString1);
        }
        this.setDescText(textView0, s, spannableString0, v, 0);
    }

    private final void setDescText(TextView textView0, String s, SpannableString spannableString0, int v, int v1) {
        if(v1 > 5) {
            if(textView0 != null) {
                textView0.setMaxLines(v);
            }
        }
        else if(textView0 != null) {
            textView0.post(new W0(textView0, v, this, s, spannableString0, v1, 4));
        }
    }

    private final void setDescText(String s, d3 d30) {
        this.setDescText(s, null, d30);
    }

    private final void setDescText(String s, SpannableString spannableString0, d3 d30) {
        String s1;
        SpannableString spannableString1;
        if(s.length() == 0) {
            d30.h.setVisibility(8);
            return;
        }
        d30.h.setVisibility(0);
        int v = s.length();
        if(spannableString0 == null) {
            String s2 = va.e.h(s, this.getString(0x7F130333));  // string:dj_playlist_desc_fold " 접기"
            s1 = s2;
            spannableString1 = new SpannableString(s2);
        }
        else {
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(spannableString0).append(this.getString(0x7F130333));  // string:dj_playlist_desc_fold " 접기"
            q.f(spannableStringBuilder0, "append(...)");
            spannableString1 = SpannableString.valueOf(spannableStringBuilder0);
            s1 = s;
        }
        spannableString1.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06016D)), v, s1.length(), 33);  // color:gray900s
        d30.i.setText(spannableString1);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = d30.h.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        S s3 = new S(((LayoutParams)viewGroup$LayoutParams0), this, d30, 0);
        d30.j.setOnClickListener(s3);
        this.setDescText(d30.l, s, spannableString0, 2);
        S s4 = new S(d30, ((LayoutParams)viewGroup$LayoutParams0), this);
        d30.m.setOnClickListener(s4);
        ((LayoutParams)viewGroup$LayoutParams0).height = -2;
    }

    private static final void setDescText$lambda$16$lambda$14(LayoutParams constraintLayout$LayoutParams0, StationEpisodeDetailFragment stationEpisodeDetailFragment0, d3 d30, View view0) {
        constraintLayout$LayoutParams0.Q = ScreenUtils.dipToPixel(stationEpisodeDetailFragment0.getContext(), 40.0f);
        d30.m.setVisibility(0);
        d30.j.setVisibility(8);
    }

    private static final void setDescText$lambda$16$lambda$15(d3 d30, LayoutParams constraintLayout$LayoutParams0, StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
        if(d30.k.getVisibility() == 0) {
            constraintLayout$LayoutParams0.Q = 0x7FFFFFFF;
            d30.m.setVisibility(8);
            d30.j.setVisibility(0);
            stationEpisodeDetailFragment0.headerDescShowMoreClickLog();
        }
    }

    private static final void setDescText$lambda$17(TextView textView0, int v, StationEpisodeDetailFragment stationEpisodeDetailFragment0, String s, SpannableString spannableString0, int v1) {
        try {
            if(textView0.getLineCount() > v) {
                d3 d30 = stationEpisodeDetailFragment0.getHeaderBinding();
                if(d30 != null) {
                    LinearLayout linearLayout0 = d30.k;
                    if(linearLayout0 != null) {
                        linearLayout0.setVisibility(0);
                    }
                }
                int v2 = textView0.getLayout().getLineEnd(v - 1);
                if(v2 < s.length()) {
                    String s1 = s.substring(0, v2);
                    q.f(s1, "substring(...)");
                    SpannableString spannableString1 = spannableString0 == null ? s1 : spannableString0;
                    textView0.setText(spannableString1);
                    stationEpisodeDetailFragment0.setDescText(textView0, s1, spannableString0, v, v1 + 1);
                }
            }
            else {
                textView0.setMaxLines(v);
            }
        }
        catch(Exception unused_ex) {
        }
    }

    private final void setLike(Like like0) {
        if(q.b(this.like, like0)) {
            return;
        }
        LogU.debug$default(this.log, "like() " + this.like + " >> " + like0, null, false, 6, null);
        this.like = like0;
        this.updateLikeLayout(like0);
    }

    private final void setSubscription(boolean z) {
        boolean z1 = this.isSubscription;
        if(z1 == z) {
            return;
        }
        LogU.debug$default(this.log, "isSubscription() " + z1 + " >> " + z, null, false, 6, null);
        this.isSubscription = z;
        this.updateSubscriptionLayout(z);
    }

    private final void showContextPopupCastDetail() {
        LogU.info$default(this.log, "showContextPopupCastDetail()", null, false, 6, null);
        if(this.isFragmentValid() && this.isPossiblePopupShow()) {
            CastEpsdDetailRes castEpsdDetailRes0 = this.castEpisodeDetailRes;
            if(castEpsdDetailRes0 != null) {
                CastInfo castEpsdDetailRes$Response$CastInfo0 = castEpsdDetailRes0.response.castInfo;
                SongInfo castEpsdDetailRes$Response$SongInfo0 = castEpsdDetailRes0.response.songInfo;
                q.d(castEpsdDetailRes$Response$CastInfo0);
                String s = this.mMenuId;
                q.f(s, "mMenuId");
                boolean z = this.isSubscription;
                ArrayList arrayList0 = castEpsdDetailRes$Response$SongInfo0.songList;
                q.f(arrayList0, "songList");
                boolean z1 = false;
                if(!arrayList0.isEmpty()) {
                    for(Object object0: arrayList0) {
                        if(q.b(((SongList)object0).cType, "1")) {
                            z1 = true;
                            break;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                String s1 = CreatorInfoBase.getCreatorNames(this.getContext(), castEpsdDetailRes$Response$CastInfo0.creator);
                q.f(s1, "getCreatorNames(...)");
                zd.j j0 = new zd.j(castEpsdDetailRes$Response$CastInfo0, s, z, z1, s1);
                com.melon.ui.popup.b.o(this.getChildFragmentManager(), j0, (k2 k20) -> StationEpisodeDetailFragment.showContextPopupCastDetail$lambda$8(this, castEpsdDetailRes$Response$CastInfo0, k20), 12);
            }
        }
    }

    private static final H showContextPopupCastDetail$lambda$8(StationEpisodeDetailFragment stationEpisodeDetailFragment0, CastInfo castEpsdDetailRes$Response$CastInfo0, k2 k20) {
        q.g(k20, "moreListPopupOnEvent");
        if(k20 instanceof F1) {
            stationEpisodeDetailFragment0.downloadSongs(stationEpisodeDetailFragment0.getMenuId(), stationEpisodeDetailFragment0.getAllSongPlayableList());
            return H.a;
        }
        if(k20 instanceof V1) {
            stationEpisodeDetailFragment0.showContextMenuAddTo();
            return H.a;
        }
        if(k20 instanceof K1) {
            M m0 = ((K1)k20).b.a;
            if(m0 == M.e1 || m0 == M.f1) {
                String s = castEpsdDetailRes$Response$CastInfo0.progSeq;
                q.f(s, "progSeq");
                stationEpisodeDetailFragment0.clickSubscribeProgram(s);
                return H.a;
            }
            else if(m0 == M.o1) {
                stationEpisodeDetailFragment0.showMultiCreatorPopup(castEpsdDetailRes$Response$CastInfo0.creator);
                return H.a;
            }
        }
        else {
            if(k20 instanceof a2) {
                q.d(castEpsdDetailRes$Response$CastInfo0);
                stationEpisodeDetailFragment0.clickShareButton(castEpsdDetailRes$Response$CastInfo0);
                return H.a;
            }
            if(k20 instanceof T1) {
                String s1 = castEpsdDetailRes$Response$CastInfo0.progSeq;
                q.f(s1, "progSeq");
                Hd.T t0 = new Hd.T();
                Bundle bundle0 = new Bundle();
                bundle0.putString("argItemId", s1);
                t0.setArguments(bundle0);
                Navigator.INSTANCE.open(t0);
                return H.a;
            }
            if(k20 instanceof j2) {
                if(!stationEpisodeDetailFragment0.isLoginUser()) {
                    stationEpisodeDetailFragment0.showLoginPopup();
                }
                StationEpisodeDetailFragment.clickCastLike$default(stationEpisodeDetailFragment0, null, 1, null);
            }
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public boolean showSpaceViewBottomButtonParallax() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songMoreClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "회차구성";
            f0.c(v - this.songListHeaderPosition);
            f0.E = s;
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
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "음악재생";
            f0.d = ActionKind.PlayMusic;
            f0.y = "회차구성";
            f0.c(v - this.songListHeaderPosition);
            f0.E = s;
            f0.e = s1;
            if(s4.equals("1")) {
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            }
            else if(s4.equals("99")) {
                f0.f = "N10042";
            }
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
        f f0 = this.getBaseTiaraEventBuilder();
        if(f0 != null) {
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "회차구성";
            f0.c(v - this.songListHeaderPosition);
            f0.E = s;
            f0.e = s1;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = s2;
            f0.a().track();
        }
    }

    public static BottomBtnData t0(StationEpisodeDetailFragment stationEpisodeDetailFragment0) {
        return StationEpisodeDetailFragment.bottomBtnData_delegate$lambda$1(stationEpisodeDetailFragment0);
    }

    public static CharSequence u0(ContsList creatorInfoBase$ContsList0) {
        return StationEpisodeDetailFragment.headerCreatorClickLog$lambda$25$lambda$23(creatorInfoBase$ContsList0);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentCountView(@Nullable InformCmtContsSummRes informCmtContsSummRes0) {
        if(informCmtContsSummRes0 != null) {
            result informCmtContsSummRes$result0 = informCmtContsSummRes0.result;
            if(informCmtContsSummRes$result0 != null) {
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = informCmtContsSummRes$result0.cmtContsSumm;
                if(informCmtContsSummRes$result$CMTCONTSSUMM0 != null) {
                    this.setComment(new Comment(informCmtContsSummRes$result$CMTCONTSSUMM0.validCmtCnt, informCmtContsSummRes$result$CMTCONTSSUMM0.hotFlag, informCmtContsSummRes$result$CMTCONTSSUMM0.newFlag));
                }
            }
        }
    }

    private final Job updateCommentLayout(Comment comment0) {
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), null, new n(comment0, null) {
            final Comment $comment;
            int label;

            {
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                this.$comment = comment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.updateCommentLayout.1(StationEpisodeDetailFragment.this, this.$comment, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.updateCommentLayout.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                LogU.info$default(StationEpisodeDetailFragment.this.log, "updateCommentLayout() comment: " + this.$comment, null, false, 6, null);
                d3 d30 = StationEpisodeDetailFragment.this.getHeaderBinding();
                if(d30 != null) {
                    String s = this.$comment.getCount() == -1 ? "" : StringUtils.getCountString(this.$comment.getCount(), 0x1869F);
                    d30.f.setText(s);
                    int v = 8;
                    d30.n.setVisibility((this.$comment.getHasHot() ? 0 : 8));
                    ImageView imageView0 = d30.o;
                    if(this.$comment.getHasNew()) {
                        v = 0;
                    }
                    imageView0.setVisibility(v);
                }
                return H.a;
            }
        }, 2, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentListView(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.StationEpisodeDetailAdapter");
        CmtResViewModel cmtResViewModel0 = this.getCmtResViewModel(loadPgnRes0, listCmtRes0);
        ArrayList arrayList0 = cmtResViewModel0.result.cmtlist;
        q.f(arrayList0, "cmtlist");
        if(arrayList0.isEmpty()) {
            ((StationEpisodeDetailAdapter)j00).add(AdapterInViewHolder.Row.create(44, H.a));
        }
        else {
            ((StationEpisodeDetailAdapter)j00).add(AdapterInViewHolder.Row.create(9, cmtResViewModel0));
        }
        ((StationEpisodeDetailAdapter)j00).notifyItemChanged(((StationEpisodeDetailAdapter)j00).getItemCount() - 1);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateHeaderView() {
        CastEpsdDetailRes castEpsdDetailRes0 = this.castEpisodeDetailRes;
        if(castEpsdDetailRes0 != null) {
            this.drawHeaderView(castEpsdDetailRes0);
        }
    }

    private final Job updateLikeLayout(Like like0) {
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), null, new n(like0, null) {
            final Like $like;
            int label;

            {
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                this.$like = like0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.updateLikeLayout.1(StationEpisodeDetailFragment.this, this.$like, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.updateLikeLayout.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                LogU.info$default(StationEpisodeDetailFragment.this.log, "updateLikeLayout() like: " + this.$like, null, false, 6, null);
                d3 d30 = StationEpisodeDetailFragment.this.getHeaderBinding();
                if(d30 != null) {
                    String s = this.$like.getCount() == -1 ? "" : StringUtils.getCountString(this.$like.getCount(), 0x1869F);
                    d30.q.setText(s);
                    d30.b.setChecked(this.$like.isLiked());
                }
                return H.a;
            }
        }, 2, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateLikeView(@Nullable Integer integer0, boolean z) {
        this.setLike(new Like((integer0 == null ? -1 : ((int)integer0)), z));
    }

    private final Job updateSubscriptionLayout(boolean z) {
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), null, new n(z, null) {
            final boolean $isSubscribe;
            int label;

            {
                StationEpisodeDetailFragment.this = stationEpisodeDetailFragment0;
                this.$isSubscribe = z;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.updateSubscriptionLayout.1(StationEpisodeDetailFragment.this, this.$isSubscribe, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.StationEpisodeDetailFragment.updateSubscriptionLayout.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                LogU.info$default(StationEpisodeDetailFragment.this.log, "updateSubscriptionLayout() isSubscribe: " + this.$isSubscribe, null, false, 6, null);
                d3 d30 = StationEpisodeDetailFragment.this.getHeaderBinding();
                if(d30 != null) {
                    SubscribeToggleButton subscribeToggleButton0 = d30.v;
                    if(this.$isSubscribe) {
                        subscribeToggleButton0.setType(1);
                        return H.a;
                    }
                    subscribeToggleButton0.setType(0);
                }
                return H.a;
            }
        }, 2, null);
    }

    public static void v0(StationEpisodeDetailFragment stationEpisodeDetailFragment0, View view0) {
        StationEpisodeDetailFragment.onViewCreated$lambda$5$lambda$4(stationEpisodeDetailFragment0, view0);
    }

    public static void w0(TextView textView0, int v, StationEpisodeDetailFragment stationEpisodeDetailFragment0, String s, SpannableString spannableString0, int v1) {
        StationEpisodeDetailFragment.setDescText$lambda$17(textView0, v, stationEpisodeDetailFragment0, s, spannableString0, v1);
    }

    public static CharSequence x0(ContsList creatorInfoBase$ContsList0) {
        return StationEpisodeDetailFragment.headerCreatorClickLog$lambda$25$lambda$24(creatorInfoBase$ContsList0);
    }
}

