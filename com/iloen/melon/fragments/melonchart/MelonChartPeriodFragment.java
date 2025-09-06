package com.iloen.melon.fragments.melonchart;

import B9.c;
import C8.b;
import Cc.N1;
import De.I;
import K.m;
import Q0.k0;
import Q0.t0;
import T.e;
import X0.x;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.L;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonChartAwardView;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.artistchannel.viewholder.f;
import com.iloen.melon.fragments.melonchart.ui.Hot100BannerKt;
import com.iloen.melon.fragments.settings.SettingBannedContentsFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.ChartHot100BannerReq;
import com.iloen.melon.net.v4x.request.NowChartBannerReq;
import com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response;
import com.iloen.melon.net.v4x.response.ChartHot100BannerRes;
import com.iloen.melon.net.v4x.response.NowChartBannerRes.Response.BANNERS;
import com.iloen.melon.net.v4x.response.NowChartBannerRes;
import com.iloen.melon.net.v5x.request.ChartTopDailySongChartListReq.Params;
import com.iloen.melon.net.v5x.request.ChartTopDailySongChartListReq;
import com.iloen.melon.net.v5x.request.ChartTopMonthlySongChartListReq;
import com.iloen.melon.net.v5x.request.ChartTopWeeklySongChartListReq;
import com.iloen.melon.net.v5x.response.ChartTopDailySongChartListRes;
import com.iloen.melon.net.v5x.response.ChartTopMonthlySongChartListRes;
import com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE.MUSICAWARD;
import com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes;
import com.iloen.melon.net.v6x.request.ChartHot100ListReq;
import com.iloen.melon.net.v6x.request.ChartMenuOrderReq;
import com.iloen.melon.net.v6x.request.ChartTop100ListReq;
import com.iloen.melon.net.v6x.response.ChartHot100ListRes;
import com.iloen.melon.net.v6x.response.ChartMenuOrderRes.RESPONSE.MENUORDER;
import com.iloen.melon.net.v6x.response.ChartMenuOrderRes;
import com.iloen.melon.net.v6x.response.ChartTop100ListRes.RESPONSE.STATSELEMENTS;
import com.iloen.melon.net.v6x.response.ChartTop100ListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ChartTop100ListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.color.DrawableColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.viewable.ViewableCheck.Builder;
import com.iloen.melon.utils.viewable.ViewableCheck;
import com.iloen.melon.viewholders.SongHolder;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import e1.u;
import i6.d;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import r0.n;
import v9.i;
import v9.j;
import va.e0;
import va.o;
import we.a;
import y0.k;

@Metadata(d1 = {"\u0000\u009A\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00B1\u00012\u00020\u0001:\u0004\u00B1\u0001\u00B2\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\'\u0010%\u001A\u00020\u00042\u0006\u0010!\u001A\u00020 2\u0006\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010*\u001A\u00020)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020)H\u0014\u00A2\u0006\u0004\b,\u0010+J\u001B\u00100\u001A\u0006\u0012\u0002\b\u00030/2\u0006\u0010.\u001A\u00020-H\u0014\u00A2\u0006\u0004\b0\u00101J\u000F\u00103\u001A\u000202H\u0014\u00A2\u0006\u0004\b3\u00104J\u0017\u00106\u001A\u00020\f2\u0006\u00105\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b6\u0010\u0017J\u000F\u00107\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b7\u0010\u0003J\u000F\u00108\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b8\u0010\u0003J\u0010\u00109\u001A\u00020\fH\u0082@\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010;\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b;\u0010\u0003J\u0017\u0010<\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\b<\u0010=J!\u0010@\u001A\u0004\u0018\u00010)2\u000E\u0010?\u001A\n\u0018\u00010\u0007j\u0004\u0018\u0001`>H\u0002\u00A2\u0006\u0004\b@\u0010AJ\u001F\u0010C\u001A\n\u0018\u00010\u0007j\u0004\u0018\u0001`>2\u0006\u0010B\u001A\u00020)H\u0002\u00A2\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bE\u0010=J\u0017\u0010F\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bF\u0010=J\u0017\u0010G\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bG\u0010=J\u0017\u0010H\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bH\u0010=J\u000F\u0010I\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bI\u0010\tJ\u000F\u0010J\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bJ\u0010\tJ\u000F\u0010L\u001A\u00020KH\u0002\u00A2\u0006\u0004\bL\u0010MJ\u0019\u0010P\u001A\u00020\f2\b\u0010O\u001A\u0004\u0018\u00010NH\u0002\u00A2\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001A\u00020\f2\u0006\u0010R\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bS\u0010\u0017J\u0017\u0010U\u001A\u00020\f2\u0006\u0010T\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bU\u0010VJ\u000F\u0010W\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bW\u0010\u0003J\u000F\u0010X\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bX\u0010\u0003J\u000F\u0010Y\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bY\u0010\u0003J\u000F\u0010Z\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bZ\u0010\u0003J\u000F\u0010[\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b[\u0010\u0003J\u000F\u0010\\\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\\\u0010\u0003J\u000F\u0010]\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b]\u0010\u0003J#\u0010`\u001A\u00020\f2\b\u0010^\u001A\u0004\u0018\u00010\u00072\b\u0010_\u001A\u0004\u0018\u00010\u0007H\u0002\u00A2\u0006\u0004\b`\u0010aJ#\u0010b\u001A\u00020\f2\b\u0010^\u001A\u0004\u0018\u00010\u00072\b\u0010_\u001A\u0004\u0018\u00010\u0007H\u0002\u00A2\u0006\u0004\bb\u0010aJ\u000F\u0010c\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bc\u0010\u0003J\u0017\u0010d\u001A\u00020\f2\u0006\u0010R\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bd\u0010\u0017J\u0017\u0010f\u001A\u00020\f2\u0006\u0010e\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bf\u0010\u0017J\u0017\u0010i\u001A\u00020\f2\u0006\u0010h\u001A\u00020gH\u0002\u00A2\u0006\u0004\bi\u0010jJ\u000F\u0010k\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bk\u0010\u0003J\u000F\u0010l\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bl\u0010\u0003R\u0014\u0010n\u001A\u00020m8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001A\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010s\u001A\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001A\u00020\u00188\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001A\u00020w8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010{\u001A\u00020z8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010}\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b}\u0010vR\u0018\u0010~\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b~\u0010vR\u0019\u0010\u0080\u0001\u001A\u00020\u007F8\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001C\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001E\u0010\u0086\u0001\u001A\t\u0012\u0004\u0012\u00020\u00040\u0085\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001E\u0010\u0088\u0001\u001A\t\u0012\u0004\u0012\u00020\u00070\u0085\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0087\u0001R\u001A\u0010\u0089\u0001\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0089\u0001\u0010vR\u001C\u0010\u008B\u0001\u001A\u0005\u0018\u00010\u008A\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008B\u0001\u0010\u008C\u0001R!\u0010\u008F\u0001\u001A\f\u0012\u0007\u0012\u0005\u0018\u00010\u008E\u00010\u008D\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008F\u0001\u0010\u0090\u0001R\u001C\u0010\u0092\u0001\u001A\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001B\u0010\u0094\u0001\u001A\u0004\u0018\u00010\u007F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0081\u0001R!\u0010\u0096\u0001\u001A\f\u0012\u0007\u0012\u0005\u0018\u00010\u0095\u00010\u008D\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0090\u0001R\u001C\u0010\u0097\u0001\u001A\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0093\u0001R\u001A\u0010\u0098\u0001\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0098\u0001\u0010vR\u001C\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0093\u0001R\u001A\u0010\u009A\u0001\u001A\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u009A\u0001\u0010tR)\u0010\u009D\u0001\u001A\u0012\u0012\r\u0012\u000B\u0012\u0004\u0012\u00020K\u0018\u00010\u009C\u00010\u009B\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009D\u0001\u0010\u009E\u0001R+\u0010\u00A1\u0001\u001A\u0014\u0012\u0004\u0012\u00020K0\u009F\u0001j\t\u0012\u0004\u0012\u00020K`\u00A0\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u00A1\u0001\u0010\u00A2\u0001R\u0019\u0010\u00A3\u0001\u001A\u00020)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A3\u0001\u0010\u00A4\u0001R\u0018\u0010\u00A5\u0001\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u00A5\u0001\u0010tR\u001C\u0010\u00A7\u0001\u001A\u0005\u0018\u00010\u00A6\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A7\u0001\u0010\u00A8\u0001R\u0018\u0010\u00AA\u0001\u001A\u00030\u00A9\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00AA\u0001\u0010\u00AB\u0001R7\u0010\u00AF\u0001\u001A\"\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u00AD\u00010\u00AC\u0001j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u00AD\u0001`\u00AE\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00AF\u0001\u0010\u00B0\u0001\u00A8\u0006\u00B3\u0001"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartPeriodFragment;", "Lcom/iloen/melon/fragments/melonchart/MelonChartBaseFragment;", "<init>", "()V", "", "isGenreExclude", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "enabled", "updateSelectAllButton", "(Z)V", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "InfoTime", "(Landroidx/compose/runtime/l;I)V", "DivisionPoint", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "show", "updateToolBar", "onPause", "onForeground", "requestAlyacFilterDataSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openChartInfo", "initScrollableAlyacFilter", "(Landroid/view/View;)V", "Lcom/iloen/melon/fragments/melonchart/SORT;", "sort", "convertSortToIndex", "(Ljava/lang/String;)Ljava/lang/Integer;", "index", "convertIndexToSort", "(I)Ljava/lang/String;", "initChartFilterLayout", "initChartReportFloatingButton", "initPromoBanner", "initHot100PromoBanner", "getChartFilterName", "getChartFilterCode", "Lv9/j;", "getCurrentChartFilterData", "()Lv9/j;", "Lcom/iloen/melon/net/v5x/response/ChartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD;", "musicAward", "updateWeeklyAwardView", "(Lcom/iloen/melon/net/v5x/response/ChartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD;)V", "isVisible", "setAllCheckButtonVisibility", "clickCopy", "playLog", "(Ljava/lang/String;)V", "requestTOP100ChartList", "requestHot100ChartList", "requestTopDailySong", "requestTopWeeklySong", "requestTopMonthlySong", "requestNowPromotionBanner", "requestHot100PromotionBanner", "bgColor", "imgUrl", "drawPromoBanner", "(Ljava/lang/String;Ljava/lang/String;)V", "drawHot100PromoBanner", "updateHeaderBanner", "updateHeaderLayout", "showToolbar", "setFloatingButton", "Lcom/melon/net/res/common/SongInfoBase;", "songInfo", "openChartReportBottomSheet", "(Lcom/melon/net/res/common/SongInfoBase;)V", "tiaraViewImpLogFlush", "tiaraViewImpMapFlush", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lcom/melon/net/res/common/LinkInfoBase;", "chartInfoData", "Lcom/melon/net/res/common/LinkInfoBase;", "chartInfoText", "Ljava/lang/String;", "headerContainer", "Landroid/view/View;", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "scrollableAlyacFilter", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "Lcom/iloen/melon/custom/MelonChartAwardView;", "chartAwardView", "Lcom/iloen/melon/custom/MelonChartAwardView;", "playShuffleButton", "playAllButton", "Landroidx/compose/ui/platform/ComposeView;", "filterLayoutComposeView", "Landroidx/compose/ui/platform/ComposeView;", "LC8/b;", "composableFilterLayout", "LC8/b;", "Landroidx/compose/runtime/b0;", "isCheckedAllSelect", "Landroidx/compose/runtime/b0;", "dropDownText", "promoBannerView", "Landroid/widget/ImageView;", "promoBannerIv", "Landroid/widget/ImageView;", "Landroidx/lifecycle/L;", "Lcom/iloen/melon/net/v4x/response/NowChartBannerRes$Response$BANNERS;", "top100PromoBannerLiveData", "Landroidx/lifecycle/L;", "Lcom/iloen/melon/utils/viewable/ViewableCheck;", "promoBannerViewableCheck", "Lcom/iloen/melon/utils/viewable/ViewableCheck;", "hot100PromoBannerComposeView", "Lcom/iloen/melon/net/v4x/response/ChartHot100BannerRes$Response$BANNERS;", "hot100PromoBannerLiveData", "hot100PromoBannerViewableCheck", "chartReportFloatingButton", "floatingButtonViewableCheck", "currentSort", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "alyacFilterDataList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "chartFilterDataList", "Ljava/util/ArrayList;", "currentChartFilterIndex", "I", "top100RangeCode", "Li6/d;", "chartReportBottomSheet", "Li6/d;", "Lcom/android/volley/Response$ErrorListener;", "responseErrorListener", "Lcom/android/volley/Response$ErrorListener;", "Ljava/util/HashMap;", "Lcom/kakao/tiara/data/ViewImpContent;", "Lkotlin/collections/HashMap;", "tiaraViewImpMap", "Ljava/util/HashMap;", "Companion", "Top100Adapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartPeriodFragment extends MelonChartBaseFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0002\u0010\u001BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u000EX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartPeriodFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SORT", "ARG_FILTER_INDEX", "SORT_TOP100", "SORT_HOT100", "SORT_DAILY", "SORT_WEEKLY", "SORT_MONTHLY", "FILTER_INDEX_D30", "", "FILTER_INDEX_D100", "FILTER_INDEX_MIN", "FILTER_INDEX_MAX", "DEFAULT_FILTER_INDEX", "FETCH_REASON_ALYAC_CHANGE", "FETCH_REASON_FILTER_CHANGE", "ADDITIONAL_HEIGHT", "", "newInstance", "Lcom/iloen/melon/fragments/melonchart/MelonChartPeriodFragment;", "sort", "filterIndex", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/iloen/melon/fragments/melonchart/MelonChartPeriodFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonChartPeriodFragment newInstance(@Nullable String s, @Nullable Integer integer0) {
            MelonChartPeriodFragment melonChartPeriodFragment0 = new MelonChartPeriodFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", u.v(((e0)o.a()).j()));
            if(s != null) {
                bundle0.putString("argSort", s);
            }
            if(integer0 != null && ((int)integer0) >= 0 && ((int)integer0) <= 1) {
                bundle0.putInt("argFilterIndex", ((int)integer0));
            }
            melonChartPeriodFragment0.setArguments(bundle0);
            return melonChartPeriodFragment0;
        }

        public static MelonChartPeriodFragment newInstance$default(Companion melonChartPeriodFragment$Companion0, String s, Integer integer0, int v, Object object0) {
            if((v & 2) != 0) {
                integer0 = null;
            }
            return melonChartPeriodFragment$Companion0.newInstance(s, integer0);
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartPeriodFragment$Top100Adapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartPeriodFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class Top100Adapter extends p {
        private final int VIEW_TYPE_SONG;

        public Top100Adapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonChartPeriodFragment.this = melonChartPeriodFragment0;
            super(context0, list0);
            this.VIEW_TYPE_SONG = 1;
        }

        public static void a(MelonChartPeriodFragment melonChartPeriodFragment0, int v, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v1, ChartSongInfoBase chartSongInfoBase0, View view0) {
            Top100Adapter.onBindViewImpl$lambda$3(melonChartPeriodFragment0, chartSongInfoBase0, melonChartPeriodFragment$Top100Adapter0, v, v1, view0);
        }

        // 检测为 Lambda 实现
        public static boolean b(MelonChartPeriodFragment melonChartPeriodFragment0, int v, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v1, ChartSongInfoBase chartSongInfoBase0, View view0) [...]

        public static void c(MelonChartPeriodFragment melonChartPeriodFragment0, int v, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v1, ChartSongInfoBase chartSongInfoBase0, View view0) {
            Top100Adapter.onBindViewImpl$lambda$0(melonChartPeriodFragment0, v, melonChartPeriodFragment$Top100Adapter0, v1, chartSongInfoBase0, view0);
        }

        public static void d(MelonChartPeriodFragment melonChartPeriodFragment0, ChartSongInfoBase chartSongInfoBase0, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v, View view0) {
            Top100Adapter.onBindViewImpl$lambda$2(melonChartPeriodFragment0, chartSongInfoBase0, melonChartPeriodFragment$Top100Adapter0, v, view0);
        }

        public static void e(ChartSongInfoBase chartSongInfoBase0, MelonChartPeriodFragment melonChartPeriodFragment0, int v, View view0) {
            Top100Adapter.onBindViewImpl$lambda$4(chartSongInfoBase0, melonChartPeriodFragment0, v, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_SONG;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            this.setMenuId(httpResponse0.getMenuId());
            this.updateModifiedTime(this.getCacheKey());
            if(httpResponse0 instanceof ChartTop100ListRes) {
                RESPONSE chartTop100ListRes$RESPONSE0 = ((ChartTop100ListRes)httpResponse0).response;
                if(chartTop100ListRes$RESPONSE0 != null && (chartTop100ListRes$RESPONSE0.songList != null && !chartTop100ListRes$RESPONSE0.songList.isEmpty() == 1)) {
                    this.addAll(((ChartTop100ListRes)httpResponse0).response.songList);
                    return true;
                }
            }
            else if(httpResponse0 instanceof ChartHot100ListRes) {
                com.iloen.melon.net.v6x.response.ChartHot100ListRes.RESPONSE chartHot100ListRes$RESPONSE0 = ((ChartHot100ListRes)httpResponse0).response;
                if(chartHot100ListRes$RESPONSE0 != null && (chartHot100ListRes$RESPONSE0.songList != null && !chartHot100ListRes$RESPONSE0.songList.isEmpty() == 1)) {
                    this.addAll(((ChartHot100ListRes)httpResponse0).response.songList);
                    return true;
                }
            }
            else if(httpResponse0 instanceof ChartTopDailySongChartListRes) {
                com.iloen.melon.net.v5x.response.ChartTopDailySongChartListRes.RESPONSE chartTopDailySongChartListRes$RESPONSE0 = ((ChartTopDailySongChartListRes)httpResponse0).response;
                if(chartTopDailySongChartListRes$RESPONSE0 != null && (chartTopDailySongChartListRes$RESPONSE0.chartList != null && !chartTopDailySongChartListRes$RESPONSE0.chartList.isEmpty() == 1)) {
                    this.addAll(((ChartTopDailySongChartListRes)httpResponse0).response.chartList);
                    return true;
                }
            }
            else if(httpResponse0 instanceof ChartTopWeeklySongChartListRes) {
                com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE chartTopWeeklySongChartListRes$RESPONSE0 = ((ChartTopWeeklySongChartListRes)httpResponse0).response;
                if(chartTopWeeklySongChartListRes$RESPONSE0 != null && (chartTopWeeklySongChartListRes$RESPONSE0.chartList != null && !chartTopWeeklySongChartListRes$RESPONSE0.chartList.isEmpty() == 1)) {
                    this.addAll(((ChartTopWeeklySongChartListRes)httpResponse0).response.chartList);
                    return true;
                }
            }
            else if(httpResponse0 instanceof ChartTopMonthlySongChartListRes) {
                com.iloen.melon.net.v5x.response.ChartTopMonthlySongChartListRes.RESPONSE chartTopMonthlySongChartListRes$RESPONSE0 = ((ChartTopMonthlySongChartListRes)httpResponse0).response;
                if(chartTopMonthlySongChartListRes$RESPONSE0 != null && (chartTopMonthlySongChartListRes$RESPONSE0.chartList != null && !chartTopMonthlySongChartListRes$RESPONSE0.chartList.isEmpty() == 1)) {
                    this.addAll(((ChartTopMonthlySongChartListRes)httpResponse0).response.chartList);
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            SongHolder songHolder0 = (SongHolder)o00;
            Object object0 = this.getItem(v1);
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.common.ChartSongInfoBase");
            boolean z = ((ChartSongInfoBase)object0).canService;
            ViewUtils.setEnable(songHolder0.wrapperLayout, z);
            if(z) {
                E e0 = new E(MelonChartPeriodFragment.this, v, this, v1, ((ChartSongInfoBase)object0));
                ViewUtils.setOnClickListener(songHolder0.itemView, e0);
                if(this.isMarked(v1)) {
                    int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                    songHolder0.itemView.setBackgroundColor(v2);
                }
                else {
                    int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    songHolder0.itemView.setBackgroundColor(v3);
                }
            }
            else {
                ViewUtils.setOnClickListener(songHolder0.itemView, null);
                int v4 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                songHolder0.itemView.setBackgroundColor(v4);
            }
            int v5 = q.b(MelonChartPeriodFragment.this.currentSort, "T") ? 15 : 14;
            F f0 = (View view0) -> Top100Adapter.onBindViewImpl$lambda$1(MelonChartPeriodFragment.this, ((ChartSongInfoBase)object0), this, v5, v1, view0);
            ViewUtils.setOnLongClickListener(songHolder0.itemView, f0);
            Glide.with(this.getContext()).load(((ChartSongInfoBase)object0).albumImg).into(songHolder0.thumbnailIv);
            ViewUtils.showWhen(songHolder0.btnPlay, z);
            ViewUtils.setOnClickListener(songHolder0.btnPlay, new h(MelonChartPeriodFragment.this, ((ChartSongInfoBase)object0), this, v1, 2));
            ViewUtils.showWhen(songHolder0.btnInfo, true);
            ViewUtils.setOnClickListener(songHolder0.btnInfo, new E(MelonChartPeriodFragment.this, ((ChartSongInfoBase)object0), this, v5, v1));
            ViewUtils.setOnClickListener(songHolder0.thumbContainer, new com.iloen.melon.fragments.melonchart.i(((ChartSongInfoBase)object0), MelonChartPeriodFragment.this, v1, 5));
            ViewUtils.setTextViewMarquee(songHolder0.titleTv, this.isMarqueeNeeded(v1));
            songHolder0.titleTv.setText(((ChartSongInfoBase)object0).songName);
            songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(((ChartSongInfoBase)object0).artistList));
            ViewUtils.showWhen(songHolder0.list19Iv, ((ChartSongInfoBase)object0).isAdult);
            ViewUtils.showWhen(songHolder0.listFreeIv, ((ChartSongInfoBase)object0).isFree);
            ViewUtils.showWhen(songHolder0.listHoldbackIv, ((ChartSongInfoBase)object0).isHoldback);
            songHolder0.updownLayout.setVisibility(0);
            songHolder0.listRankingTv.setText(((ChartSongInfoBase)object0).currentRank);
            songHolder0.listChangeTv.setVisibility(0);
            String s = ((ChartSongInfoBase)object0).rankType;
            if(s != null) {
                switch(s) {
                    case "DOWN": {
                        songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803D7, 0, 0, 0);  // drawable:ic_common_arrow_down
                        songHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060046));  // color:blue400s_support_high_contrast
                        songHolder0.listChangeTv.setText(((ChartSongInfoBase)object0).rankGap);
                        songHolder0.listChangeTv.setTextSize(1, 12.0f);
                        return;
                    }
                    case "NEW": {
                        songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        songHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060459));  // color:rank_new_color
                        songHolder0.listChangeTv.setText("NEW");
                        songHolder0.listChangeTv.setTextSize(1, 10.0f);
                        return;
                    }
                    case "NONE": {
                        songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DB, 0, 0, 0);  // drawable:ic_common_arrow_equal_tint
                        songHolder0.listChangeTv.setText("");
                        return;
                    }
                    case "UP": {
                        songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DC, 0, 0, 0);  // drawable:ic_common_arrow_up
                        songHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06045A));  // color:rank_up_color
                        songHolder0.listChangeTv.setText(((ChartSongInfoBase)object0).rankGap);
                        songHolder0.listChangeTv.setTextSize(1, 12.0f);
                        break;
                    }
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(MelonChartPeriodFragment melonChartPeriodFragment0, int v, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v1, ChartSongInfoBase chartSongInfoBase0, View view0) {
            melonChartPeriodFragment0.onItemClick(view0, v);
            if(melonChartPeriodFragment$Top100Adapter0.isMarked(v1)) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartPeriodFragment0.mMenuId;
                g0.a = "선택";
                s s0 = melonChartPeriodFragment0.mMelonTiaraProperty;
                String s1 = null;
                g0.b = s0 == null ? null : s0.a;
                s s2 = melonChartPeriodFragment0.mMelonTiaraProperty;
                if(s2 != null) {
                    s1 = s2.b;
                }
                g0.c = s1;
                g0.d = ActionKind.ClickContent;
                g0.y = "곡리스트";
                g0.F = "곡선택";
                g0.C = String.valueOf(v1 + 1);
                g0.e = chartSongInfoBase0.songId;
                g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                g0.g = chartSongInfoBase0.songName;
                g0.h = chartSongInfoBase0.getArtistNames();
                g0.a().track();
            }
        }

        private static final boolean onBindViewImpl$lambda$1(MelonChartPeriodFragment melonChartPeriodFragment0, ChartSongInfoBase chartSongInfoBase0, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v, int v1, View view0) {
            String s = null;
            melonChartPeriodFragment0.showContextPopupSongOrInstantPlay(Playable.from(chartSongInfoBase0, melonChartPeriodFragment$Top100Adapter0.getMenuId(), null), v);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartPeriodFragment0.mMenuId;
            g0.a = "페이지이동";
            s s1 = melonChartPeriodFragment0.mMelonTiaraProperty;
            g0.b = s1 == null ? null : s1.a;
            s s2 = melonChartPeriodFragment0.mMelonTiaraProperty;
            if(s2 != null) {
                s = s2.b;
            }
            g0.c = s;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.F = "더보기";
            g0.C = String.valueOf(v1 + 1);
            g0.e = chartSongInfoBase0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = chartSongInfoBase0.songName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
            return true;
        }

        private static final void onBindViewImpl$lambda$2(MelonChartPeriodFragment melonChartPeriodFragment0, ChartSongInfoBase chartSongInfoBase0, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v, View view0) {
            String s = null;
            melonChartPeriodFragment0.playSong(Playable.from(chartSongInfoBase0, melonChartPeriodFragment$Top100Adapter0.getMenuId(), null), true);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartPeriodFragment0.mMenuId;
            g0.a = "음악재생";
            s s1 = melonChartPeriodFragment0.mMelonTiaraProperty;
            g0.b = s1 == null ? null : s1.a;
            s s2 = melonChartPeriodFragment0.mMelonTiaraProperty;
            if(s2 != null) {
                s = s2.b;
            }
            g0.c = s;
            g0.d = ActionKind.PlayMusic;
            g0.y = "곡리스트";
            g0.F = "음악재생";
            g0.C = String.valueOf(v + 1);
            g0.e = chartSongInfoBase0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = chartSongInfoBase0.songName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$3(MelonChartPeriodFragment melonChartPeriodFragment0, ChartSongInfoBase chartSongInfoBase0, Top100Adapter melonChartPeriodFragment$Top100Adapter0, int v, int v1, View view0) {
            String s = null;
            melonChartPeriodFragment0.showContextPopupSong(Playable.from(chartSongInfoBase0, melonChartPeriodFragment$Top100Adapter0.getMenuId(), null), v);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartPeriodFragment0.mMenuId;
            g0.a = "페이지이동";
            s s1 = melonChartPeriodFragment0.mMelonTiaraProperty;
            g0.b = s1 == null ? null : s1.a;
            s s2 = melonChartPeriodFragment0.mMelonTiaraProperty;
            if(s2 != null) {
                s = s2.b;
            }
            g0.c = s;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.F = "더보기";
            g0.C = String.valueOf(v1 + 1);
            g0.e = chartSongInfoBase0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = chartSongInfoBase0.songName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$4(ChartSongInfoBase chartSongInfoBase0, MelonChartPeriodFragment melonChartPeriodFragment0, int v, View view0) {
            if(chartSongInfoBase0.albumId != null && chartSongInfoBase0.albumId.length() != 0) {
                melonChartPeriodFragment0.showAlbumInfoPage(chartSongInfoBase0.albumId);
            }
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartPeriodFragment0.mMenuId;
            g0.a = "페이지이동";
            s s0 = melonChartPeriodFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            s s2 = melonChartPeriodFragment0.mMelonTiaraProperty;
            if(s2 != null) {
                s1 = s2.b;
            }
            g0.c = s1;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.F = "앨범페이지이동";
            g0.C = String.valueOf(v + 1);
            g0.E = chartSongInfoBase0.albumImg;
            g0.e = chartSongInfoBase0.albumId;
            g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            g0.g = chartSongInfoBase0.albumName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false);  // layout:listitem_song
            q.f(view0, "inflate(...)");
            return new c(view0);
        }
    }

    public static final int $stable = 0;
    private static final float ADDITIONAL_HEIGHT = 48.0f;
    @NotNull
    private static final String ARG_FILTER_INDEX = "argFilterIndex";
    @NotNull
    private static final String ARG_SORT = "argSort";
    @NotNull
    public static final Companion Companion = null;
    public static final int DEFAULT_FILTER_INDEX = 1;
    @NotNull
    private static final String FETCH_REASON_ALYAC_CHANGE = "alyac change";
    @NotNull
    private static final String FETCH_REASON_FILTER_CHANGE = "filter change";
    public static final int FILTER_INDEX_D100 = 1;
    public static final int FILTER_INDEX_D30 = 0;
    private static final int FILTER_INDEX_MAX = 1;
    private static final int FILTER_INDEX_MIN = 0;
    @NotNull
    public static final String SORT_DAILY = "D";
    @NotNull
    public static final String SORT_HOT100 = "H";
    @NotNull
    public static final String SORT_MONTHLY = "M";
    @NotNull
    public static final String SORT_TOP100 = "T";
    @NotNull
    public static final String SORT_WEEKLY = "W";
    @NotNull
    private static final String TAG = "MelonChartPeriodFragment";
    @NotNull
    private MutableStateFlow alyacFilterDataList;
    private MelonChartAwardView chartAwardView;
    private ArrayList chartFilterDataList;
    @Nullable
    private LinkInfoBase chartInfoData;
    @Nullable
    private String chartInfoText;
    @Nullable
    private d chartReportBottomSheet;
    @Nullable
    private View chartReportFloatingButton;
    @Nullable
    private b composableFilterLayout;
    private int currentChartFilterIndex;
    @Nullable
    private String currentSort;
    @NotNull
    private final b0 dropDownText;
    private ComposeView filterLayoutComposeView;
    @Nullable
    private ViewableCheck floatingButtonViewableCheck;
    private View headerContainer;
    @Nullable
    private ComposeView hot100PromoBannerComposeView;
    @NotNull
    private final L hot100PromoBannerLiveData;
    @Nullable
    private ViewableCheck hot100PromoBannerViewableCheck;
    @NotNull
    private final b0 isCheckedAllSelect;
    @NotNull
    private final LogU log;
    @Nullable
    private View playAllButton;
    @Nullable
    private View playShuffleButton;
    @Nullable
    private ImageView promoBannerIv;
    @Nullable
    private View promoBannerView;
    @Nullable
    private ViewableCheck promoBannerViewableCheck;
    @NotNull
    private final ErrorListener responseErrorListener;
    private ScrollableAlyacFilter scrollableAlyacFilter;
    @NotNull
    private final HashMap tiaraViewImpMap;
    @NotNull
    private final L top100PromoBannerLiveData;
    @NotNull
    private String top100RangeCode;

    static {
        MelonChartPeriodFragment.Companion = new Companion(null);
        MelonChartPeriodFragment.$stable = 8;
    }

    public MelonChartPeriodFragment() {
        this.log = new LogU("MelonChartPeriodFragment");
        this.isCheckedAllSelect = w.s(Boolean.FALSE);
        this.dropDownText = w.s("");
        this.top100PromoBannerLiveData = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.hot100PromoBannerLiveData = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.alyacFilterDataList = StateFlowKt.MutableStateFlow(null);
        this.currentChartFilterIndex = 1;
        this.top100RangeCode = "";
        this.responseErrorListener = new G(this, 1);
        this.tiaraViewImpMap = new HashMap();
    }

    public static H A0(x x0) {
        return MelonChartPeriodFragment.InfoTime$lambda$63$lambda$62(x0);
    }

    public static H B0(MelonChartPeriodFragment melonChartPeriodFragment0, x x0) {
        return MelonChartPeriodFragment.InfoTime$lambda$65$lambda$64(melonChartPeriodFragment0, x0);
    }

    public static H D0(MelonChartPeriodFragment melonChartPeriodFragment0, BANNERS nowChartBannerRes$Response$BANNERS0) {
        return MelonChartPeriodFragment.initPromoBanner$lambda$26(melonChartPeriodFragment0, nowChartBannerRes$Response$BANNERS0);
    }

    public final void DivisionPoint(@Nullable l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0xBF08DB8);
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 1) != 0)) {
            M.c.d(((androidx.compose.runtime.p)l0), androidx.compose.foundation.layout.d.q(n.a, 6.0f));
            M.c.d(((androidx.compose.runtime.p)l0), androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.n(n.a, 2.0f), Cc.e0.T(((androidx.compose.runtime.p)l0), 0x7F060154), e.a));  // color:gray200s_support_high_contrast
            M.c.d(((androidx.compose.runtime.p)l0), androidx.compose.foundation.layout.d.q(n.a, 6.0f));
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.melonchart.w(this, v, 0);
        }
    }

    private static final H DivisionPoint$lambda$67(MelonChartPeriodFragment melonChartPeriodFragment0, int v, l l0, int v1) {
        melonChartPeriodFragment0.DivisionPoint(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static void G0(MelonChartPeriodFragment melonChartPeriodFragment0, View view0) {
        MelonChartPeriodFragment.initPromoBanner$lambda$25(melonChartPeriodFragment0, view0);
    }

    public static void H0(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTopWeeklySongChartListRes chartTopWeeklySongChartListRes0) {
        MelonChartPeriodFragment.requestTopWeeklySong$lambda$77(melonChartPeriodFragment0, chartTopWeeklySongChartListRes0);
    }

    // 检测为 Lambda 实现
    public static H I0(b0 b00, MelonChartPeriodFragment melonChartPeriodFragment0, ComposeView composeView0) [...]

    public final void InfoTime(@Nullable l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(206818020);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).i(this) ? 4 : 2) | v : v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            C0.c c0 = I.Q(0x7F080474, ((androidx.compose.runtime.p)l0), 6);  // drawable:ic_info_15
            k k0 = new k(Cc.e0.T(((androidx.compose.runtime.p)l0), 0x7F060165), 5);  // color:gray800s
            String s = H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F130AE2);  // string:talkback_chart_info "차트 안내"
            com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.InfoTime..inlined.noRippleClickable-YQRRFTQ.default.1 melonChartPeriodFragment$InfoTime$$inlined$noRippleClickable-YQRRFTQ$default$10 = new we.o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                    m m0 = ((androidx.compose.runtime.p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                    }
                    X0.i i0 = new X0.i(this);
                    com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.InfoTime..inlined.noRippleClickable-YQRRFTQ.default.1.1 melonChartPeriodFragment$InfoTime$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(MelonChartPeriodFragment.this);
                            MelonChartPeriodFragment.this.openChartInfo();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, melonChartPeriodFragment$InfoTime$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return q1;
                }
            };
            n n0 = n.a;
            r0.q q0 = r0.a.a(n0, melonChartPeriodFragment$InfoTime$$inlined$noRippleClickable-YQRRFTQ$default$10);
            f f0 = ((androidx.compose.runtime.p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if(f0 == v2) {
                f0 = new f(8);
                ((androidx.compose.runtime.p)l0).l0(f0);
            }
            androidx.compose.foundation.q.c(c0, s, X0.n.c(q0, false, f0), null, null, 0.0f, k0, ((androidx.compose.runtime.p)l0), 0, 56);
            M.c.d(((androidx.compose.runtime.p)l0), androidx.compose.foundation.layout.d.q(n0, 4.0f));
            String s1 = this.chartInfoText == null ? "" : this.chartInfoText;
            long v3 = Cc.e0.T(((androidx.compose.runtime.p)l0), 0x7F060165);  // color:gray800s
            boolean z = ((androidx.compose.runtime.p)l0).i(this);
            B b0 = ((androidx.compose.runtime.p)l0).N();
            if(z || b0 == v2) {
                b0 = new B(this, 2);
                ((androidx.compose.runtime.p)l0).l0(b0);
            }
            N1.b(s1, androidx.compose.foundation.q.q(X0.n.c(n0, false, b0), true, null), v3, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((androidx.compose.runtime.p)l0), 0xC00, 0, 0x1FFF0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.melonchart.w(this, v, 1);
        }
    }

    private static final H InfoTime$lambda$63$lambda$62(x x0) {
        q.g(x0, "$this$semantics");
        X0.u.k(x0, 0);
        return H.a;
    }

    private static final H InfoTime$lambda$65$lambda$64(MelonChartPeriodFragment melonChartPeriodFragment0, x x0) {
        q.g(x0, "$this$semantics");
        X0.u.h(x0, melonChartPeriodFragment0.chartInfoText + " " + (melonChartPeriodFragment0.getContext() == null ? null : "차트"));
        return H.a;
    }

    private static final H InfoTime$lambda$66(MelonChartPeriodFragment melonChartPeriodFragment0, int v, l l0, int v1) {
        melonChartPeriodFragment0.InfoTime(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static void K0(MelonChartPeriodFragment melonChartPeriodFragment0, View view0) {
        MelonChartPeriodFragment.onViewCreated$lambda$0(melonChartPeriodFragment0, view0);
    }

    public static H M0(MelonChartPeriodFragment melonChartPeriodFragment0, com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS0) {
        return MelonChartPeriodFragment.initHot100PromoBanner$lambda$36(melonChartPeriodFragment0, chartHot100BannerRes$Response$BANNERS0);
    }

    public static void N0(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTopMonthlySongChartListRes chartTopMonthlySongChartListRes0) {
        MelonChartPeriodFragment.requestTopMonthlySong$lambda$80(melonChartPeriodFragment0, chartTopMonthlySongChartListRes0);
    }

    // 检测为 Lambda 实现
    public static H O0(MelonChartPeriodFragment melonChartPeriodFragment0, ComposeView composeView0, l l0, int v) [...]

    public static void R0(MelonChartPeriodFragment melonChartPeriodFragment0, NowChartBannerRes nowChartBannerRes0) {
        MelonChartPeriodFragment.requestNowPromotionBanner$lambda$83(melonChartPeriodFragment0, nowChartBannerRes0);
    }

    public static void S0(MelonChartPeriodFragment melonChartPeriodFragment0, View view0) {
        MelonChartPeriodFragment.onViewCreated$lambda$1(melonChartPeriodFragment0, view0);
    }

    public static void W0(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTopDailySongChartListRes chartTopDailySongChartListRes0) {
        MelonChartPeriodFragment.requestTopDailySong$lambda$74(melonChartPeriodFragment0, chartTopDailySongChartListRes0);
    }

    public static void Y0(MelonChartPeriodFragment melonChartPeriodFragment0, ChartHot100ListRes chartHot100ListRes0) {
        MelonChartPeriodFragment.requestHot100ChartList$lambda$71(melonChartPeriodFragment0, chartHot100ListRes0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0265, null, false);  // layout:filter_chart_period
        q.f(view0, "inflate(...)");
        this.headerContainer = view0;
        return view0;
    }

    private final String convertIndexToSort(int v) {
        List list0 = (List)this.alyacFilterDataList.getValue();
        if(list0 != null) {
            j j0 = (j)je.p.n0(v, list0);
            return j0 == null ? null : j0.c;
        }
        return null;
    }

    private final Integer convertSortToIndex(String s) {
        List list0 = (List)this.alyacFilterDataList.getValue();
        if(list0 == null) {
            throw new NullPointerException();
        }
        int v = 0;
        Iterator iterator0 = list0.iterator();
        while(true) {
            if(!iterator0.hasNext()) {
                v = -1;
                break;
            }
            Object object0 = iterator0.next();
            if(q.b(((j)object0).c, s)) {
                break;
            }
            ++v;
        }
        Integer integer0 = v;
        return integer0 == null || ((int)integer0) != -1 ? integer0 : null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new Top100Adapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setMarkedMode(true);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(1);
        ((p)j00).setHasMore(false);
        return j00;
    }

    private final void drawHot100PromoBanner(String s, String s1) {
        int v = s == null || s.length() == 0 ? ColorUtils.getColor(this.getContext(), 0x7F0604A1) : ColorUtils.getColorFromHexStr(("#" + s));  // color:white000e
        DrawableColorUtils.changeDrawableInnerColor(this.promoBannerIv, v);
        ImageView imageView0 = this.promoBannerIv;
        if(imageView0 != null) {
            Glide.with(imageView0).load(s1).into(imageView0);
        }
    }

    private final void drawPromoBanner(String s, String s1) {
        int v = s == null || s.length() == 0 ? ColorUtils.getColor(this.getContext(), 0x7F0604A1) : ColorUtils.getColorFromHexStr(("#" + s));  // color:white000e
        DrawableColorUtils.changeDrawableInnerColor(this.promoBannerIv, v);
        ImageView imageView0 = this.promoBannerIv;
        if(imageView0 != null) {
            Glide.with(imageView0).load(s1).into(imageView0);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.n0.buildUpon().appendQueryParameter("sort", String.valueOf(this.currentSort)).appendQueryParameter("filterIndex", String.valueOf(this.currentChartFilterIndex)).appendQueryParameter("memberKey", u.v(((e0)o.a()).j())).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final String getChartFilterCode() {
        String s = this.getCurrentChartFilterData().c;
        q.f(s, "code");
        return s;
    }

    private final String getChartFilterName() {
        String s = this.getCurrentChartFilterData().b;
        q.f(s, "name");
        return s;
    }

    private final j getCurrentChartFilterData() {
        ArrayList arrayList0 = this.chartFilterDataList;
        if(arrayList0 != null) {
            int v = this.currentChartFilterIndex;
            if(v >= 0 && v < arrayList0.size()) {
                return arrayList0.get(v);
            }
            ArrayList arrayList1 = this.chartFilterDataList;
            if(arrayList1 != null) {
                return (j)je.p.k0(arrayList1);
            }
            q.m("chartFilterDataList");
            throw null;
        }
        q.m("chartFilterDataList");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        int v = 0;
        if(ScreenUtils.isOrientationPortrait(this.getContext())) {
            View view0 = this.headerContainer;
            if(view0 == null) {
                q.m("headerContainer");
                throw null;
            }
            else if(view0.getVisibility() == 0) {
                int v1 = ScreenUtils.getScreenWidth(this.getContext()) >= ScreenUtils.dipToPixel(this.getContext(), 300.0f) ? 0 : ScreenUtils.dipToPixel(this.getContext(), 48.0f);
                Context context0 = this.getContext();
                if(context0 != null) {
                    Resources resources0 = context0.getResources();
                    if(resources0 != null) {
                        v = resources0.getDimensionPixelSize(0x7F07008C);  // dimen:chart_parallax_header_fixed_height
                    }
                }
                return v + v1;
            }
        }
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        int v1;
        int v = 0;
        View view0 = this.headerContainer;
        if(view0 != null) {
            if(view0.getVisibility() == 0) {
                if(!q.b(this.currentSort, "W") || (this.chartAwardView == null || this.chartAwardView.getVisibility() != 0)) {
                    v1 = ScreenUtils.dipToPixel(this.getContext(), 168.0f);
                }
                else {
                    MelonChartAwardView melonChartAwardView0 = this.chartAwardView;
                    if(melonChartAwardView0 == null) {
                        q.m("chartAwardView");
                        throw null;
                    }
                    if(q.b(melonChartAwardView0.getCurrentAwardStatus(), "A")) {
                        v1 = ScreenUtils.dipToPixel(this.getContext(), 316.5f);
                    }
                    else {
                        Context context0 = this.getContext();
                        if(context0 != null) {
                            Resources resources0 = context0.getResources();
                            if(resources0 != null) {
                                v = resources0.getDimensionPixelSize(0x7F070089);  // dimen:chart_home_award_margin
                            }
                        }
                        int v2 = ScreenUtils.getScreenWidth(this.getContext()) - v;
                        if(!ScreenUtils.isPortrait(this.getContext())) {
                            v2 = ScreenUtils.getScreenHeight(this.getContext()) - v;
                        }
                        v1 = ((int)(((float)v2) * 0.675f)) + ScreenUtils.dipToPixel(this.getContext(), 221.5f);
                    }
                }
                if(this.promoBannerView != null && this.promoBannerView.getVisibility() == 0 || this.hot100PromoBannerComposeView != null && this.hot100PromoBannerComposeView.getVisibility() == 0) {
                    v1 += ScreenUtils.dipToPixel(this.getContext(), 80.0f);
                }
                return ScreenUtils.getScreenWidth(this.getContext()) >= ScreenUtils.dipToPixel(this.getContext(), 300.0f) ? v1 : ScreenUtils.dipToPixel(this.getContext(), 48.0f) + v1;
            }
            return 0;
        }
        q.m("headerContainer");
        throw null;
    }

    private final void initChartFilterLayout(View view0) {
        int v;
        Context context0 = this.getContext();
        if(context0 == null) {
            v = 0;
        }
        else {
            Resources resources0 = context0.getResources();
            v = resources0 == null ? 0 : ScreenUtils.pixelToDip(this.getContext(), ((int)resources0.getDimension(0x7F07008B)));  // dimen:chart_new_filter_layout_height
        }
        String s = "발매 30일";
        this.composableFilterLayout = new b(20.0f, 20.0f, ((float)v));
        View view1 = view0.findViewById(0x7F0A049F);  // id:filter_layout_compose
        q.f(view1, "findViewById(...)");
        this.filterLayoutComposeView = (ComposeView)view1;
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        Context context1 = this.getContext();
        String s1 = "";
        if(context1 == null || context1.getResources() == null) {
            s = "";
        }
        j0.b = s;
        j0.c = "D30";
        j j1 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        Context context2 = this.getContext();
        if(context2 != null && context2.getResources() != null) {
            s1 = "발매 100일";
        }
        j1.b = s1;
        j1.c = "D100";
        this.chartFilterDataList = e.k.e(new j[]{j0, j1});
    }

    private final void initChartReportFloatingButton(View view0) {
        View view1 = ((ViewStub)view0.findViewById(0x7F0A0AF3)).inflate();  // id:stub_floating_button
        this.chartReportFloatingButton = view1;
        if(view1 != null) {
            view1.setOnClickListener(new com.iloen.melon.fragments.melonchart.a(2, this, view1));
            Builder viewableCheck$Builder0 = new Builder(view1);
            viewableCheck$Builder0.setMinHeight(ScreenUtils.dipToPixel(view1.getContext(), 44.0f));
            viewableCheck$Builder0.setCallback(() -> {
                String s1;
                ArrayList arrayList0 = this.getMarkedList(false).d;
                q.f(arrayList0, "markedList");
                Integer integer0 = arrayList0.size() > 0 ? arrayList0.get(0) : 0;
                j0 j00 = this.getAdapter();
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.Top100Adapter");
                q.d(integer0);
                Object object0 = ((Top100Adapter)j00).getItem(((int)integer0));
                String s = null;
                SongInfoBase songInfoBase0 = object0 instanceof SongInfoBase ? ((SongInfoBase)object0) : null;
                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                if(songInfoBase0 == null) {
                    s1 = "";
                }
                else {
                    s1 = songInfoBase0.songName;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                logU$Companion0.d("MelonChartPeriodFragment", "floatingButtonViewableCheck#onViewable " + s1);
                if(songInfoBase0 != null) {
                    com.kakao.tiara.data.ViewImpContent.Builder viewImpContent$Builder0 = new com.kakao.tiara.data.ViewImpContent.Builder().impProvider("melon_admin").impType((view1.getContext() == null ? null : "vimp")).impArea(this.top100RangeCode).layer1((view1.getContext() == null ? null : "선택팝업"));
                    if(view1.getContext() != null) {
                        s = "차트리포트";
                    }
                    com.kakao.tiara.data.ViewImpContent.Builder viewImpContent$Builder1 = viewImpContent$Builder0.layer2(s).id(songInfoBase0.songId);
                    q.f("N10001", "code(...)");
                    ViewImpContent viewImpContent0 = viewImpContent$Builder1.type(p8.b.a("N10001")).name(songInfoBase0.songName).build();
                    q.f(viewImpContent0, "build(...)");
                    synchronized(this.tiaraViewImpMap) {
                        this.tiaraViewImpMap.put("floatingButton-" + songInfoBase0.songId, viewImpContent0);
                        return H.a;
                    }
                }
                return H.a;
            });
            this.floatingButtonViewableCheck = viewableCheck$Builder0.build();
        }
    }

    private static final void initChartReportFloatingButton$lambda$24$lambda$19(MelonChartPeriodFragment melonChartPeriodFragment0, View view0, View view1) {
        ArrayList arrayList0 = melonChartPeriodFragment0.getMarkedList(false).d;
        q.f(arrayList0, "markedList");
        Integer integer0 = arrayList0.size() > 0 ? arrayList0.get(0) : 0;
        j0 j00 = melonChartPeriodFragment0.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.Top100Adapter");
        q.d(integer0);
        Object object0 = ((Top100Adapter)j00).getItem(((int)integer0));
        String s = null;
        SongInfoBase songInfoBase0 = object0 instanceof SongInfoBase ? ((SongInfoBase)object0) : null;
        if(songInfoBase0 != null) {
            melonChartPeriodFragment0.setSelectAllWithToolbar(false);
            melonChartPeriodFragment0.openChartReportBottomSheet(songInfoBase0);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartPeriodFragment0.mMenuId;
            g0.a = "페이지이동";
            s s1 = melonChartPeriodFragment0.mMelonTiaraProperty;
            g0.b = s1 == null ? null : s1.a;
            if(s1 != null) {
                s = s1.b;
            }
            g0.c = s;
            g0.y = "선택팝업";
            g0.z = "차트리포트";
            g0.F = "차트리포트보기";
            g0.e = songInfoBase0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = songInfoBase0.songName;
            g0.h = songInfoBase0.getArtistNames();
            g0.a().track();
        }
    }

    // 检测为 Lambda 实现
    private static final H initChartReportFloatingButton$lambda$24$lambda$23$lambda$22(MelonChartPeriodFragment melonChartPeriodFragment0, View view0) [...]

    private final void initHot100PromoBanner(View view0) {
        ComposeView composeView0 = (ComposeView)view0.findViewById(0x7F0A0249);  // id:chart_hot100_banner_compose_view
        this.hot100PromoBannerComposeView = composeView0;
        if(composeView0 != null) {
            composeView0.setViewCompositionStrategy(t0.d);
            composeView0.setContent(new m0.b(-776594302, (l l0, int v) -> MelonChartPeriodFragment.initHot100PromoBanner$lambda$35$lambda$34(this, composeView0, l0, v), true));
        }
        D d0 = this.getViewLifecycleOwner();
        MelonChartPeriodFragmentKt.sam.androidx_lifecycle_Observer.0 melonChartPeriodFragmentKt$sam$androidx_lifecycle_Observer$00 = new MelonChartPeriodFragmentKt.sam.androidx_lifecycle_Observer.0(new B(this, 1));
        this.hot100PromoBannerLiveData.observe(d0, melonChartPeriodFragmentKt$sam$androidx_lifecycle_Observer$00);
        ComposeView composeView1 = this.hot100PromoBannerComposeView;
        if(composeView1 != null) {
            Builder viewableCheck$Builder0 = new Builder(composeView1);
            viewableCheck$Builder0.setCallback(new com.iloen.melon.fragments.melonchart.x(this, 5));
            this.hot100PromoBannerViewableCheck = viewableCheck$Builder0.build();
        }
    }

    private static final H initHot100PromoBanner$lambda$35$lambda$34(MelonChartPeriodFragment melonChartPeriodFragment0, ComposeView composeView0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            b0 b00 = e1.m.x(melonChartPeriodFragment0.hot100PromoBannerLiveData, ((androidx.compose.runtime.p)l0));
            com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS0 = (com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS)b00.getValue();
            String s = null;
            String s1 = chartHot100BannerRes$Response$BANNERS0 == null ? null : chartHot100BannerRes$Response$BANNERS0.text1;
            com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS1 = (com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS)b00.getValue();
            String s2 = chartHot100BannerRes$Response$BANNERS1 == null ? null : chartHot100BannerRes$Response$BANNERS1.text2;
            com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS2 = (com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS)b00.getValue();
            String s3 = chartHot100BannerRes$Response$BANNERS2 == null ? null : chartHot100BannerRes$Response$BANNERS2.imgUrl;
            com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS3 = (com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS)b00.getValue();
            String s4 = chartHot100BannerRes$Response$BANNERS3 == null ? null : chartHot100BannerRes$Response$BANNERS3.imgAltText;
            com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS4 = (com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS)b00.getValue();
            if(chartHot100BannerRes$Response$BANNERS4 != null) {
                s = chartHot100BannerRes$Response$BANNERS4.bgColor;
            }
            boolean z = ((androidx.compose.runtime.p)l0).g(b00);
            boolean z1 = ((androidx.compose.runtime.p)l0).i(melonChartPeriodFragment0);
            boolean z2 = ((androidx.compose.runtime.p)l0).i(composeView0);
            com.iloen.melon.fragments.melonchart.D d0 = ((androidx.compose.runtime.p)l0).N();
            if((z | z1 | z2) != 0 || d0 == androidx.compose.runtime.k.a) {
                d0 = () -> MelonChartPeriodFragment.initHot100PromoBanner$lambda$35$lambda$34$lambda$33$lambda$32(b00, melonChartPeriodFragment0, composeView0);
                ((androidx.compose.runtime.p)l0).l0(d0);
            }
            Hot100BannerKt.Hot100Banner(s1, s2, s3, s4, s, d0, ((androidx.compose.runtime.p)l0), 0, 0);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final H initHot100PromoBanner$lambda$35$lambda$34$lambda$33$lambda$32(b1 b10, MelonChartPeriodFragment melonChartPeriodFragment0, ComposeView composeView0) {
        com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS0 = (com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS)b10.getValue();
        if(chartHot100BannerRes$Response$BANNERS0 != null) {
            MelonLinkExecutor.open(MelonLinkInfo.b(chartHot100BannerRes$Response$BANNERS0));
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartPeriodFragment0.mMenuId;
            g0.a = "페이지이동";
            s s0 = melonChartPeriodFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            if(s0 != null) {
                s1 = s0.b;
            }
            g0.c = s1;
            g0.y = "배너";
            g0.z = "타켓배너";
            g0.E = chartHot100BannerRes$Response$BANNERS0.imgUrl;
            g0.e = chartHot100BannerRes$Response$BANNERS0.bannerSeq;
            g0.g = chartHot100BannerRes$Response$BANNERS0.adminTitle;
            g0.f = "배너";
            g0.a().track();
        }
        return H.a;
    }

    private static final H initHot100PromoBanner$lambda$36(MelonChartPeriodFragment melonChartPeriodFragment0, com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS0) {
        String s = null;
        if(q.b(melonChartPeriodFragment0.currentSort, "H")) {
            String s1 = chartHot100BannerRes$Response$BANNERS0 == null ? null : chartHot100BannerRes$Response$BANNERS0.bgColor;
            if(chartHot100BannerRes$Response$BANNERS0 != null) {
                s = chartHot100BannerRes$Response$BANNERS0.imgUrl;
            }
            melonChartPeriodFragment0.drawHot100PromoBanner(s1, s);
            ViewableCheck viewableCheck0 = melonChartPeriodFragment0.hot100PromoBannerViewableCheck;
            if(viewableCheck0 != null) {
                viewableCheck0.start();
            }
            String s2 = "배너";
            if(chartHot100BannerRes$Response$BANNERS0 != null && (chartHot100BannerRes$Response$BANNERS0.imgAltText != null && !Tf.o.H0(chartHot100BannerRes$Response$BANNERS0.imgAltText) == 1)) {
                s2 = chartHot100BannerRes$Response$BANNERS0.imgAltText;
            }
            else if(melonChartPeriodFragment0.getContext() == null) {
                s2 = "";
            }
            ViewUtils.setContentDescriptionWithButtonClassName(melonChartPeriodFragment0.promoBannerView, s2);
            melonChartPeriodFragment0.updateHeaderBanner();
        }
        return H.a;
    }

    private static final H initHot100PromoBanner$lambda$40$lambda$39$lambda$38(MelonChartPeriodFragment melonChartPeriodFragment0) {
        if(q.b(melonChartPeriodFragment0.currentSort, "H")) {
            com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS chartHot100BannerRes$Response$BANNERS0 = (com.iloen.melon.net.v4x.response.ChartHot100BannerRes.Response.BANNERS)melonChartPeriodFragment0.hot100PromoBannerLiveData.getValue();
            if(chartHot100BannerRes$Response$BANNERS0 == null) {
                return H.a;
            }
            ViewImpContent viewImpContent0 = new com.kakao.tiara.data.ViewImpContent.Builder().impProvider("melon_admin").impType((melonChartPeriodFragment0.getContext() == null ? null : "vimp")).impOrdNum("1").layer1("배너").layer2("타켓배너").id(chartHot100BannerRes$Response$BANNERS0.bannerSeq).type("배너").name(chartHot100BannerRes$Response$BANNERS0.adminTitle).build();
            q.f(viewImpContent0, "build(...)");
            synchronized(melonChartPeriodFragment0.tiaraViewImpMap) {
                melonChartPeriodFragment0.tiaraViewImpMap.put("hot100PromoBanner", viewImpContent0);
                return H.a;
            }
        }
        return H.a;
    }

    private final void initPromoBanner(View view0) {
        View view1 = view0.findViewById(0x7F0A00ED);  // id:banner
        this.promoBannerView = view1;
        ImageView imageView0 = view1 == null ? null : ((ImageView)view1.findViewById(0x7F0A00F1));  // id:banner_iv
        this.promoBannerIv = imageView0;
        if(imageView0 != null) {
            Drawable drawable0 = imageView0.getBackground();
            if(drawable0 != null) {
                drawable0.mutate();
            }
        }
        ViewUtils.setOnClickListener(this.promoBannerView, new A(this, 0));
        D d0 = this.getViewLifecycleOwner();
        MelonChartPeriodFragmentKt.sam.androidx_lifecycle_Observer.0 melonChartPeriodFragmentKt$sam$androidx_lifecycle_Observer$00 = new MelonChartPeriodFragmentKt.sam.androidx_lifecycle_Observer.0(new B(this, 0));
        this.top100PromoBannerLiveData.observe(d0, melonChartPeriodFragmentKt$sam$androidx_lifecycle_Observer$00);
        View view2 = this.promoBannerView;
        if(view2 != null) {
            Builder viewableCheck$Builder0 = new Builder(view2);
            viewableCheck$Builder0.setCallback(new com.iloen.melon.fragments.melonchart.x(this, 3));
            this.promoBannerViewableCheck = viewableCheck$Builder0.build();
        }
    }

    private static final void initPromoBanner$lambda$25(MelonChartPeriodFragment melonChartPeriodFragment0, View view0) {
        if(melonChartPeriodFragment0.top100PromoBannerLiveData.getValue() != null && q.b(melonChartPeriodFragment0.currentSort, "T")) {
            BANNERS nowChartBannerRes$Response$BANNERS0 = (BANNERS)melonChartPeriodFragment0.top100PromoBannerLiveData.getValue();
            if(nowChartBannerRes$Response$BANNERS0 != null) {
                MelonLinkExecutor.open(MelonLinkInfo.b(nowChartBannerRes$Response$BANNERS0));
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartPeriodFragment0.mMenuId;
                g0.a = "페이지이동";
                s s0 = melonChartPeriodFragment0.mMelonTiaraProperty;
                String s1 = null;
                g0.b = s0 == null ? null : s0.a;
                if(s0 != null) {
                    s1 = s0.b;
                }
                g0.c = s1;
                g0.y = "배너";
                g0.z = "타켓배너";
                g0.E = nowChartBannerRes$Response$BANNERS0.imgUrl;
                g0.e = nowChartBannerRes$Response$BANNERS0.bannerSeq;
                g0.g = nowChartBannerRes$Response$BANNERS0.adminTitle;
                g0.f = "배너";
                g0.a().track();
            }
        }
    }

    private static final H initPromoBanner$lambda$26(MelonChartPeriodFragment melonChartPeriodFragment0, BANNERS nowChartBannerRes$Response$BANNERS0) {
        String s = null;
        if(q.b(melonChartPeriodFragment0.currentSort, "T")) {
            String s1 = nowChartBannerRes$Response$BANNERS0 == null ? null : nowChartBannerRes$Response$BANNERS0.bgColor;
            if(nowChartBannerRes$Response$BANNERS0 != null) {
                s = nowChartBannerRes$Response$BANNERS0.imgUrl;
            }
            melonChartPeriodFragment0.drawPromoBanner(s1, s);
            ViewableCheck viewableCheck0 = melonChartPeriodFragment0.promoBannerViewableCheck;
            if(viewableCheck0 != null) {
                viewableCheck0.start();
            }
            String s2 = "배너";
            if(nowChartBannerRes$Response$BANNERS0 != null && (nowChartBannerRes$Response$BANNERS0.imgAltText != null && !Tf.o.H0(nowChartBannerRes$Response$BANNERS0.imgAltText) == 1)) {
                s2 = nowChartBannerRes$Response$BANNERS0.imgAltText;
            }
            else if(melonChartPeriodFragment0.getContext() == null) {
                s2 = "";
            }
            ViewUtils.setContentDescriptionWithButtonClassName(melonChartPeriodFragment0.promoBannerView, s2);
            melonChartPeriodFragment0.updateHeaderBanner();
        }
        return H.a;
    }

    private static final H initPromoBanner$lambda$30$lambda$29$lambda$28(MelonChartPeriodFragment melonChartPeriodFragment0) {
        if(q.b(melonChartPeriodFragment0.currentSort, "T")) {
            BANNERS nowChartBannerRes$Response$BANNERS0 = (BANNERS)melonChartPeriodFragment0.top100PromoBannerLiveData.getValue();
            if(nowChartBannerRes$Response$BANNERS0 == null) {
                return H.a;
            }
            ViewImpContent viewImpContent0 = new com.kakao.tiara.data.ViewImpContent.Builder().impProvider("melon_admin").impType((melonChartPeriodFragment0.getContext() == null ? null : "vimp")).impOrdNum("1").layer1("배너").layer2("타켓배너").id(nowChartBannerRes$Response$BANNERS0.bannerSeq).type("배너").name(nowChartBannerRes$Response$BANNERS0.adminTitle).build();
            q.f(viewImpContent0, "build(...)");
            synchronized(melonChartPeriodFragment0.tiaraViewImpMap) {
                melonChartPeriodFragment0.tiaraViewImpMap.put("promoBanner", viewImpContent0);
                return H.a;
            }
        }
        return H.a;
    }

    private final void initScrollableAlyacFilter(View view0) {
        View view1 = view0.findViewById(0x7F0A0A31);  // id:scrollable_alyac_filter
        q.f(view1, "findViewById(...)");
        this.scrollableAlyacFilter = (ScrollableAlyacFilter)view1;
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new we.n(null) {
            int label;

            {
                MelonChartPeriodFragment.this = melonChartPeriodFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.initScrollableAlyacFilter.1(MelonChartPeriodFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.initScrollableAlyacFilter.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.initScrollableAlyacFilter.1.1 melonChartPeriodFragment$initScrollableAlyacFilter$1$10 = new we.n(null) {
                            Object L$0;
                            int label;

                            {
                                MelonChartPeriodFragment.this = melonChartPeriodFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.initScrollableAlyacFilter.1.1(MelonChartPeriodFragment.this, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            public static void d(MelonChartPeriodFragment melonChartPeriodFragment0, int v) {
                                com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.initScrollableAlyacFilter.1.1.invokeSuspend$lambda$0(melonChartPeriodFragment0, v);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((List)object0), ((Continuation)object1));
                            }

                            public final Object invoke(List list0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.initScrollableAlyacFilter.1.1)this.create(list0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                int v;
                                List list0 = (List)this.L$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                if(list0 != null) {
                                    ScrollableAlyacFilter scrollableAlyacFilter0 = MelonChartPeriodFragment.this.scrollableAlyacFilter;
                                    if(scrollableAlyacFilter0 != null) {
                                        scrollableAlyacFilter0.d(list0);
                                        Integer integer0 = MelonChartPeriodFragment.this.convertSortToIndex(MelonChartPeriodFragment.this.currentSort);
                                        if(integer0 == null) {
                                            v = 0;
                                        }
                                        else {
                                            v = (int)integer0;
                                            if(v < 0) {
                                                v = 0;
                                            }
                                            int v1 = list0.size();
                                            if(v > v1 - 1) {
                                                v = v1 - 1;
                                            }
                                        }
                                        ScrollableAlyacFilter scrollableAlyacFilter1 = MelonChartPeriodFragment.this.scrollableAlyacFilter;
                                        if(scrollableAlyacFilter1 != null) {
                                            scrollableAlyacFilter1.setSelectedIndex(v);
                                            ScrollableAlyacFilter scrollableAlyacFilter2 = MelonChartPeriodFragment.this.scrollableAlyacFilter;
                                            if(scrollableAlyacFilter2 != null) {
                                                scrollableAlyacFilter2.setPadding(ScreenUtils.dipToPixel(MelonChartPeriodFragment.this.getContext(), 20.0f));
                                                ScrollableAlyacFilter scrollableAlyacFilter3 = MelonChartPeriodFragment.this.scrollableAlyacFilter;
                                                if(scrollableAlyacFilter3 != null) {
                                                    scrollableAlyacFilter3.e(new G(MelonChartPeriodFragment.this, 0), new E8.c());  // 初始化器: Ljava/lang/Object;-><init>()V
                                                    return H.a;
                                                }
                                                q.m("scrollableAlyacFilter");
                                                throw null;
                                            }
                                            q.m("scrollableAlyacFilter");
                                            throw null;
                                        }
                                        q.m("scrollableAlyacFilter");
                                        throw null;
                                    }
                                    q.m("scrollableAlyacFilter");
                                    throw null;
                                }
                                return H.a;
                            }

                            private static final void invokeSuspend$lambda$0(MelonChartPeriodFragment melonChartPeriodFragment0, int v) {
                                String s3;
                                Integer integer0 = melonChartPeriodFragment0.convertSortToIndex(melonChartPeriodFragment0.currentSort);
                                if(integer0 != null && ((int)integer0) == v) {
                                    return;
                                }
                                if(je.p.d0(e.k.A(new String[]{"T", "H"}), melonChartPeriodFragment0.currentSort)) {
                                    melonChartPeriodFragment0.tiaraViewImpLogFlush();
                                }
                                melonChartPeriodFragment0.currentSort = melonChartPeriodFragment0.convertIndexToSort(v);
                                melonChartPeriodFragment0.startFetch("alyac change");
                                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                                g0.I = melonChartPeriodFragment0.mMenuId;
                                g0.a = "페이지이동";
                                s s0 = melonChartPeriodFragment0.mMelonTiaraProperty;
                                String s1 = null;
                                g0.b = s0 == null ? null : s0.a;
                                s s2 = melonChartPeriodFragment0.mMelonTiaraProperty;
                                if(s2 != null) {
                                    s1 = s2.b;
                                }
                                g0.c = s1;
                                g0.y = "Pagemenu";
                                List list0 = (List)melonChartPeriodFragment0.alyacFilterDataList.getValue();
                                if(list0 == null) {
                                    s3 = "";
                                }
                                else {
                                    j j0 = (j)je.p.n0(v, list0);
                                    if(j0 == null) {
                                        s3 = "";
                                    }
                                    else {
                                        s3 = j0.b;
                                        if(s3 == null) {
                                            s3 = "";
                                        }
                                    }
                                }
                                g0.F = s3;
                                g0.a().track();
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(MelonChartPeriodFragment.this.alyacFilterDataList, melonChartPeriodFragment$initScrollableAlyacFilter$1$10, this) == a0 ? a0 : H.a;
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

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isGenreExclude() {
        return true;
    }

    @NotNull
    public static final MelonChartPeriodFragment newInstance(@Nullable String s, @Nullable Integer integer0) {
        return MelonChartPeriodFragment.Companion.newInstance(s, integer0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        MelonChartAwardView melonChartAwardView0 = this.chartAwardView;
        if(melonChartAwardView0 != null) {
            melonChartAwardView0.b();
            ScrollableAlyacFilter scrollableAlyacFilter0 = this.scrollableAlyacFilter;
            if(scrollableAlyacFilter0 != null) {
                Integer integer0 = this.convertSortToIndex(this.currentSort);
                scrollableAlyacFilter0.c((integer0 == null ? -1 : ((int)integer0)));
                this.onUpdateParallaxHeader();
                return;
            }
            q.m("scrollableAlyacFilter");
            throw null;
        }
        q.m("chartAwardView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        if(!s.equals("filter change")) {
            View view0 = this.promoBannerView;
            if(view0 != null) {
                view0.setVisibility(8);
            }
            ComposeView composeView0 = this.hot100PromoBannerComposeView;
            if(composeView0 != null) {
                composeView0.setVisibility(8);
            }
        }
        MelonChartAwardView melonChartAwardView0 = this.chartAwardView;
        if(melonChartAwardView0 != null) {
            melonChartAwardView0.setVisibility(8);
            this.setAllCheckButtonVisibility(false);
            this.chartInfoData = null;
            this.chartInfoText = "";
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.Top100Adapter");
            ((Top100Adapter)j00).clear();
            String s1 = this.currentSort;
            if(s1 != null) {
                switch(s1) {
                    case "D": {
                        this.requestTopDailySong();
                        return true;
                    }
                    case "H": {
                        this.requestHot100ChartList();
                        if(s.equals("alyac change")) {
                            this.requestHot100PromotionBanner();
                            return true;
                        }
                        break;
                    }
                    case "M": {
                        this.requestTopMonthlySong();
                        return true;
                    }
                    case "T": {
                        this.requestTOP100ChartList();
                        if(s.equals("alyac change")) {
                            this.requestNowPromotionBanner();
                            return true;
                        }
                        break;
                    }
                    case "W": {
                        this.requestTopWeeklySong();
                        return true;
                    }
                    default: {
                        return true;
                    }
                }
            }
            return true;
        }
        q.m("chartAwardView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onForeground() {
        super.onForeground();
        String s = this.currentSort;
        if(s != null) {
            switch(s) {
                case "H": {
                    this.requestHot100PromotionBanner();
                    ViewableCheck viewableCheck0 = this.hot100PromoBannerViewableCheck;
                    if(viewableCheck0 != null) {
                        viewableCheck0.start();
                        return;
                    }
                    break;
                }
                case "T": {
                    this.requestNowPromotionBanner();
                    ViewableCheck viewableCheck1 = this.promoBannerViewableCheck;
                    if(viewableCheck1 != null) {
                        viewableCheck1.start();
                        return;
                    }
                    break;
                }
                case "W": {
                    ResponseBase responseBase0 = this.mResponse;
                    if(responseBase0 instanceof com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE) {
                        q.e(responseBase0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE");
                        this.updateWeeklyAwardView(((com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE)responseBase0).musicAward);
                        return;
                    }
                    break;
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.melonchart.MelonChartBaseFragment
    public void onPause() {
        super.onPause();
        this.tiaraViewImpLogFlush();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.currentSort = bundle0.getString("argSort", null);
        this.currentChartFilterIndex = bundle0.getInt("argFilterIndex", 1);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argSort", this.currentSort);
        bundle0.putInt("argFilterIndex", this.currentChartFilterIndex);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
        this.initScrollableAlyacFilter(view0);
        View view1 = view0.findViewById(0x7F0A0246);  // id:chart_award_view
        q.f(view1, "findViewById(...)");
        this.chartAwardView = (MelonChartAwardView)view1;
        this.initPromoBanner(view0);
        this.initHot100PromoBanner(view0);
        this.initChartFilterLayout(view0);
        this.initChartReportFloatingButton(view0);
        View view2 = view0.findViewById(0x7F0A01BB);  // id:btn_shuffle
        this.playShuffleButton = view2;
        if(view2 != null) {
            view2.setOnClickListener(new A(this, 1));
        }
        View view3 = view0.findViewById(0x7F0A0183);  // id:btn_play_all
        this.playAllButton = view3;
        if(view3 != null) {
            view3.setOnClickListener(new A(this, 2));
        }
        this.setAllCheckButtonVisibility(this.getItemCount() > 0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new we.n(null) {
            int label;

            {
                MelonChartPeriodFragment.this = melonChartPeriodFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.onViewCreated.3(MelonChartPeriodFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.onViewCreated.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return MelonChartPeriodFragment.this.requestAlyacFilterDataSync(this) == a0 ? a0 : H.a;
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

    private static final void onViewCreated$lambda$0(MelonChartPeriodFragment melonChartPeriodFragment0, View view0) {
        melonChartPeriodFragment0.checkAndShowBanPopup();
        melonChartPeriodFragment0.playShuffleAll();
        String s = melonChartPeriodFragment0.getString(0x7F130E33);  // string:tiara_common_layer2_play_shuffle "셔플재생"
        q.f(s, "getString(...)");
        melonChartPeriodFragment0.playLog(s);
    }

    private static final void onViewCreated$lambda$1(MelonChartPeriodFragment melonChartPeriodFragment0, View view0) {
        melonChartPeriodFragment0.checkAndShowBanPopup();
        melonChartPeriodFragment0.playAll();
        String s = melonChartPeriodFragment0.getString(0x7F130E31);  // string:tiara_common_layer2_play_all "전체재생"
        q.f(s, "getString(...)");
        melonChartPeriodFragment0.playLog(s);
    }

    private final void openChartInfo() {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        LinkInfoBase linkInfoBase0 = this.chartInfoData;
        String s = null;
        melonLinkInfo0.a = linkInfoBase0 == null ? null : linkInfoBase0.linktype;
        if(linkInfoBase0 != null) {
            s = linkInfoBase0.linkurl;
        }
        melonLinkInfo0.b = s;
        MelonLinkExecutor.open(melonLinkInfo0);
    }

    private final void openChartReportBottomSheet(SongInfoBase songInfoBase0) {
        d d0 = this.chartReportBottomSheet;
        if(d0 != null) {
            d0.dismiss();
        }
        MelonChartReportBottomSheetFragment melonChartReportBottomSheetFragment0 = new MelonChartReportBottomSheetFragment((songInfoBase0.songId == null ? "" : songInfoBase0.songId));
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            l0 l00 = fragmentActivity0.getSupportFragmentManager();
            if(l00 != null) {
                melonChartReportBottomSheetFragment0.show(l00, "MelonChartReportBottomSheetFragment");
            }
        }
        this.chartReportBottomSheet = melonChartReportBottomSheetFragment0;
    }

    private final void playLog(String s) {
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = this.mMenuId;
        g0.a = "음악재생";
        s s1 = this.mMelonTiaraProperty;
        String s2 = null;
        g0.b = s1 == null ? null : s1.a;
        if(s1 != null) {
            s2 = s1.b;
        }
        g0.c = s2;
        g0.y = "곡리스트";
        g0.F = s;
        g0.a().track();
    }

    public static void r0(MelonChartPeriodFragment melonChartPeriodFragment0, ChartHot100BannerRes chartHot100BannerRes0) {
        MelonChartPeriodFragment.requestHot100PromotionBanner$lambda$86(melonChartPeriodFragment0, chartHot100BannerRes0);
    }

    private final Object requestAlyacFilterDataSync(Continuation continuation0) {
        List list0;
        com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.requestAlyacFilterDataSync.1 melonChartPeriodFragment$requestAlyacFilterDataSync$10;
        if(continuation0 instanceof com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.requestAlyacFilterDataSync.1) {
            melonChartPeriodFragment$requestAlyacFilterDataSync$10 = (com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.requestAlyacFilterDataSync.1)continuation0;
            int v = melonChartPeriodFragment$requestAlyacFilterDataSync$10.label;
            if((v & 0x80000000) == 0) {
                melonChartPeriodFragment$requestAlyacFilterDataSync$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.requestAlyacFilterDataSync(this);
                    }
                };
            }
            else {
                melonChartPeriodFragment$requestAlyacFilterDataSync$10.label = v ^ 0x80000000;
            }
        }
        else {
            melonChartPeriodFragment$requestAlyacFilterDataSync$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.requestAlyacFilterDataSync(this);
                }
            };
        }
        Object object0 = melonChartPeriodFragment$requestAlyacFilterDataSync$10.result;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(melonChartPeriodFragment$requestAlyacFilterDataSync$10.label) {
            case 0: {
                d5.n.D(object0);
                if(this.alyacFilterDataList.getValue() == null) {
                    try {
                        com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.requestAlyacFilterDataSync.newAlyacFilterDataList.res.1 melonChartPeriodFragment$requestAlyacFilterDataSync$newAlyacFilterDataList$res$10 = new we.n(RequestFuture.newFuture(), null) {
                            final RequestFuture $future;
                            int label;

                            {
                                MelonChartPeriodFragment.this = melonChartPeriodFragment0;
                                this.$future = requestFuture0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.requestAlyacFilterDataSync.newAlyacFilterDataList.res.1(MelonChartPeriodFragment.this, this.$future, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.requestAlyacFilterDataSync.newAlyacFilterDataList.res.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ChartMenuOrderReq(MelonChartPeriodFragment.this.getContext())).tag(MelonChartPeriodFragment.this.getRequestTag()).listener(this.$future).errorListener(this.$future).requestSync(this.$future);
                                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ChartMenuOrderRes");
                                return (ChartMenuOrderRes)httpResponse0;
                            }
                        };
                        melonChartPeriodFragment$requestAlyacFilterDataSync$10.L$0 = null;
                        melonChartPeriodFragment$requestAlyacFilterDataSync$10.label = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), melonChartPeriodFragment$requestAlyacFilterDataSync$newAlyacFilterDataList$res$10, melonChartPeriodFragment$requestAlyacFilterDataSync$10);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_24;
                    }
                    catch(CancellationException unused_ex) {
                        LogU.debug$default(this.log, "requestAlyacFilterDataSync cancelled()", null, false, 6, null);
                        return h0;
                    }
                    catch(Exception unused_ex) {
                        goto label_64;
                    }
                }
                break;
            }
            case 1: {
                RequestFuture requestFuture0 = (RequestFuture)melonChartPeriodFragment$requestAlyacFilterDataSync$10.L$0;
                try {
                    d5.n.D(object0);
                label_24:
                    JobKt.ensureActive(melonChartPeriodFragment$requestAlyacFilterDataSync$10.getContext());
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    MENUORDER chartMenuOrderRes$RESPONSE$MENUORDER0 = ((ChartMenuOrderRes)object0).response.menuOrder;
                    String s = chartMenuOrderRes$RESPONSE$MENUORDER0.top100Order;
                    q.f(s, "top100Order");
                    Integer integer0 = new Integer(Integer.parseInt(s));
                    j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j0.b = this.getString(0x7F1305FA);  // string:melon_chart_top100 "TOP100"
                    j0.c = "T";
                    linkedHashMap0.put(integer0, j0);
                    String s1 = chartMenuOrderRes$RESPONSE$MENUORDER0.hot100Order;
                    q.f(s1, "hot100Order");
                    Integer integer1 = new Integer(Integer.parseInt(s1));
                    j j1 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j1.b = this.getString(0x7F1305DE);  // string:melon_chart_hot_100 "HOT100"
                    j1.c = "H";
                    linkedHashMap0.put(integer1, j1);
                    j[] arr_j = new j[5];
                    Object object1 = linkedHashMap0.get(new Integer(1));
                    q.d(object1);
                    arr_j[0] = object1;
                    Object object2 = linkedHashMap0.get(new Integer(2));
                    q.d(object2);
                    arr_j[1] = object2;
                    j j2 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j2.b = this.getString(0x7F1305D5);  // string:melon_chart_daily "일간"
                    j2.c = "D";
                    arr_j[2] = j2;
                    j j3 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j3.b = this.getString(0x7F1305FD);  // string:melon_chart_weekly "주간"
                    j3.c = "W";
                    arr_j[3] = j3;
                    j j4 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j4.b = this.getString(0x7F1305EA);  // string:melon_chart_monthly "월간"
                    j4.c = "M";
                    arr_j[4] = j4;
                    list0 = e.k.A(arr_j);
                }
                catch(CancellationException unused_ex) {
                    LogU.debug$default(this.log, "requestAlyacFilterDataSync cancelled()", null, false, 6, null);
                    return h0;
                }
                catch(Exception unused_ex) {
                label_64:
                    if(JobKt.isActive(melonChartPeriodFragment$requestAlyacFilterDataSync$10.getContext())) {
                        j j5 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j5.b = this.getString(0x7F1305FA);  // string:melon_chart_top100 "TOP100"
                        j5.c = "T";
                        j j6 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j6.b = this.getString(0x7F1305DE);  // string:melon_chart_hot_100 "HOT100"
                        j6.c = "H";
                        j j7 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j7.b = this.getString(0x7F1305D5);  // string:melon_chart_daily "일간"
                        j7.c = "D";
                        j j8 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j8.b = this.getString(0x7F1305FD);  // string:melon_chart_weekly "주간"
                        j8.c = "W";
                        j j9 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j9.b = this.getString(0x7F1305EA);  // string:melon_chart_monthly "월간"
                        j9.c = "M";
                        list0 = e.k.A(new j[]{j5, j6, j7, j8, j9});
                        goto label_81;
                    }
                    break;
                }
            label_81:
                this.alyacFilterDataList.setValue(list0);
                if(this.currentSort == null) {
                    this.currentSort = ((j)list0.get(0)).c;
                    this.startFetch("alyac change");
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    private final void requestHot100ChartList() {
        RequestBuilder.newInstance(new ChartHot100ListReq(this.getContext(), this.getChartFilterCode())).tag(this.getRequestTag()).listener(new G(this, 7)).errorListener(this.responseErrorListener).request();
    }

    private static final void requestHot100ChartList$lambda$71(MelonChartPeriodFragment melonChartPeriodFragment0, ChartHot100ListRes chartHot100ListRes0) {
        if(!melonChartPeriodFragment0.prepareFetchComplete(chartHot100ListRes0)) {
            melonChartPeriodFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        if(chartHot100ListRes0 != null) {
            com.iloen.melon.net.v6x.response.ChartHot100ListRes.RESPONSE chartHot100ListRes$RESPONSE0 = chartHot100ListRes0.response;
            if(chartHot100ListRes$RESPONSE0 != null) {
                melonChartPeriodFragment0.chartInfoData = chartHot100ListRes$RESPONSE0.chartinfo;
                melonChartPeriodFragment0.chartInfoText = chartHot100ListRes$RESPONSE0.rankHour;
                if(chartHot100ListRes$RESPONSE0.songList != null && !chartHot100ListRes$RESPONSE0.songList.isEmpty() == 1) {
                    melonChartPeriodFragment0.setAllCheckButtonVisibility(true);
                    melonChartPeriodFragment0.updateHeaderLayout(true);
                }
                melonChartPeriodFragment0.mMelonTiaraProperty = new s(chartHot100ListRes$RESPONSE0.section, chartHot100ListRes$RESPONSE0.page, chartHot100ListRes0.getMenuId(), null);
            }
        }
        melonChartPeriodFragment0.performFetchComplete(i.b, chartHot100ListRes0);
    }

    private final void requestHot100PromotionBanner() {
        RequestBuilder.newInstance(new ChartHot100BannerReq(this.getContext())).tag(this.getRequestTag()).listener(new G(this, 8)).request();
    }

    private static final void requestHot100PromotionBanner$lambda$86(MelonChartPeriodFragment melonChartPeriodFragment0, ChartHot100BannerRes chartHot100BannerRes0) {
        if(melonChartPeriodFragment0.isFragmentValid() && chartHot100BannerRes0 != null) {
            Cb.j.b(chartHot100BannerRes0.notification, false, 2);
            if(Cb.j.d(chartHot100BannerRes0)) {
                j0 j00 = melonChartPeriodFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.Top100Adapter");
                Top100Adapter melonChartPeriodFragment$Top100Adapter0 = (Top100Adapter)j00;
                Response chartHot100BannerRes$Response0 = chartHot100BannerRes0.response;
                if((chartHot100BannerRes$Response0 == null ? null : chartHot100BannerRes$Response0.banners) != null) {
                    List list0 = chartHot100BannerRes$Response0.banners;
                    q.f(list0, "banners");
                    if(!list0.isEmpty()) {
                        Object object0 = chartHot100BannerRes$Response0.banners.get(0);
                        melonChartPeriodFragment0.hot100PromoBannerLiveData.setValue(object0);
                        return;
                    }
                }
                melonChartPeriodFragment0.hot100PromoBannerLiveData.setValue(null);
            }
        }
    }

    private final void requestNowPromotionBanner() {
        RequestBuilder.newInstance(new NowChartBannerReq(this.getContext())).tag(this.getRequestTag()).listener(new G(this, 3)).request();
    }

    private static final void requestNowPromotionBanner$lambda$83(MelonChartPeriodFragment melonChartPeriodFragment0, NowChartBannerRes nowChartBannerRes0) {
        if(melonChartPeriodFragment0.isFragmentValid() && nowChartBannerRes0 != null) {
            Cb.j.b(nowChartBannerRes0.notification, false, 2);
            if(Cb.j.d(nowChartBannerRes0)) {
                j0 j00 = melonChartPeriodFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.Top100Adapter");
                Top100Adapter melonChartPeriodFragment$Top100Adapter0 = (Top100Adapter)j00;
                com.iloen.melon.net.v4x.response.NowChartBannerRes.Response nowChartBannerRes$Response0 = nowChartBannerRes0.response;
                if((nowChartBannerRes$Response0 == null ? null : nowChartBannerRes$Response0.banners) != null) {
                    List list0 = nowChartBannerRes$Response0.banners;
                    q.f(list0, "banners");
                    if(!list0.isEmpty()) {
                        Object object0 = nowChartBannerRes$Response0.banners.get(0);
                        melonChartPeriodFragment0.top100PromoBannerLiveData.setValue(object0);
                        return;
                    }
                }
                melonChartPeriodFragment0.top100PromoBannerLiveData.setValue(null);
            }
        }
    }

    private final void requestTOP100ChartList() {
        RequestBuilder.newInstance(new ChartTop100ListReq(this.getContext())).tag(this.getRequestTag()).listener(new G(this, 6)).errorListener(this.responseErrorListener).request();
    }

    private static final void requestTOP100ChartList$lambda$69(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTop100ListRes chartTop100ListRes0) {
        String s;
        if(!melonChartPeriodFragment0.prepareFetchComplete(chartTop100ListRes0)) {
            melonChartPeriodFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        if(chartTop100ListRes0 != null) {
            RESPONSE chartTop100ListRes$RESPONSE0 = chartTop100ListRes0.response;
            if(chartTop100ListRes$RESPONSE0 != null) {
                STATSELEMENTS chartTop100ListRes$RESPONSE$STATSELEMENTS0 = chartTop100ListRes$RESPONSE0.statsElements;
                if(chartTop100ListRes$RESPONSE$STATSELEMENTS0 == null) {
                    s = "";
                }
                else {
                    s = chartTop100ListRes$RESPONSE$STATSELEMENTS0.rangeCode;
                    if(s == null) {
                        s = "";
                    }
                }
                melonChartPeriodFragment0.top100RangeCode = s;
                melonChartPeriodFragment0.chartInfoData = chartTop100ListRes$RESPONSE0.chartinfo;
                melonChartPeriodFragment0.chartInfoText = chartTop100ListRes$RESPONSE0.rankHour;
                if(chartTop100ListRes$RESPONSE0.songList != null && !chartTop100ListRes$RESPONSE0.songList.isEmpty() == 1) {
                    melonChartPeriodFragment0.setAllCheckButtonVisibility(true);
                    melonChartPeriodFragment0.updateHeaderLayout(true);
                }
                melonChartPeriodFragment0.mMelonTiaraProperty = new s(chartTop100ListRes$RESPONSE0.section, chartTop100ListRes$RESPONSE0.page, chartTop100ListRes0.getMenuId(), null);
            }
        }
        melonChartPeriodFragment0.performFetchComplete(i.b, chartTop100ListRes0);
    }

    private final void requestTopDailySong() {
        Params chartTopDailySongChartListReq$Params0 = new Params();
        chartTopDailySongChartListReq$Params0.startIndex = 1;
        chartTopDailySongChartListReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new ChartTopDailySongChartListReq(this.getContext(), chartTopDailySongChartListReq$Params0)).tag(this.getRequestTag()).listener(new G(this, 5)).errorListener(this.responseErrorListener).request();
    }

    private static final void requestTopDailySong$lambda$74(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTopDailySongChartListRes chartTopDailySongChartListRes0) {
        if(!melonChartPeriodFragment0.prepareFetchComplete(chartTopDailySongChartListRes0)) {
            melonChartPeriodFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        if(chartTopDailySongChartListRes0 != null) {
            com.iloen.melon.net.v5x.response.ChartTopDailySongChartListRes.RESPONSE chartTopDailySongChartListRes$RESPONSE0 = chartTopDailySongChartListRes0.response;
            if(chartTopDailySongChartListRes$RESPONSE0 != null) {
                melonChartPeriodFragment0.chartInfoData = chartTopDailySongChartListRes$RESPONSE0.chartinfo;
                melonChartPeriodFragment0.chartInfoText = melonChartPeriodFragment0.getString(0x7F1305B9);  // string:mc_artist_review "차트안내"
                if(chartTopDailySongChartListRes$RESPONSE0.chartList != null && !chartTopDailySongChartListRes$RESPONSE0.chartList.isEmpty() == 1) {
                    melonChartPeriodFragment0.setAllCheckButtonVisibility(true);
                    melonChartPeriodFragment0.updateHeaderLayout(true);
                }
                melonChartPeriodFragment0.mMelonTiaraProperty = new s(chartTopDailySongChartListRes$RESPONSE0.section, chartTopDailySongChartListRes$RESPONSE0.page, chartTopDailySongChartListRes0.getMenuId(), null);
            }
        }
        melonChartPeriodFragment0.performFetchComplete(i.b, chartTopDailySongChartListRes0);
    }

    private final void requestTopMonthlySong() {
        com.iloen.melon.net.v5x.request.ChartTopMonthlySongChartListReq.Params chartTopMonthlySongChartListReq$Params0 = new com.iloen.melon.net.v5x.request.ChartTopMonthlySongChartListReq.Params();
        chartTopMonthlySongChartListReq$Params0.startIndex = 1;
        chartTopMonthlySongChartListReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new ChartTopMonthlySongChartListReq(this.getContext(), chartTopMonthlySongChartListReq$Params0)).tag(this.getRequestTag()).listener(new G(this, 2)).errorListener(this.responseErrorListener).request();
    }

    private static final void requestTopMonthlySong$lambda$80(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTopMonthlySongChartListRes chartTopMonthlySongChartListRes0) {
        if(!melonChartPeriodFragment0.prepareFetchComplete(chartTopMonthlySongChartListRes0)) {
            melonChartPeriodFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        if(chartTopMonthlySongChartListRes0 != null) {
            com.iloen.melon.net.v5x.response.ChartTopMonthlySongChartListRes.RESPONSE chartTopMonthlySongChartListRes$RESPONSE0 = chartTopMonthlySongChartListRes0.response;
            if(chartTopMonthlySongChartListRes$RESPONSE0 != null) {
                melonChartPeriodFragment0.chartInfoData = chartTopMonthlySongChartListRes$RESPONSE0.chartinfo;
                melonChartPeriodFragment0.chartInfoText = melonChartPeriodFragment0.getString(0x7F1305B9);  // string:mc_artist_review "차트안내"
                if(chartTopMonthlySongChartListRes$RESPONSE0.chartList != null && !chartTopMonthlySongChartListRes$RESPONSE0.chartList.isEmpty() == 1) {
                    melonChartPeriodFragment0.setAllCheckButtonVisibility(true);
                    melonChartPeriodFragment0.updateHeaderLayout(true);
                }
                melonChartPeriodFragment0.mMelonTiaraProperty = new s(chartTopMonthlySongChartListRes$RESPONSE0.section, chartTopMonthlySongChartListRes$RESPONSE0.page, chartTopMonthlySongChartListRes0.getMenuId(), null);
            }
        }
        melonChartPeriodFragment0.performFetchComplete(i.b, chartTopMonthlySongChartListRes0);
    }

    private final void requestTopWeeklySong() {
        com.iloen.melon.net.v5x.request.ChartTopWeeklySongChartListReq.Params chartTopWeeklySongChartListReq$Params0 = new com.iloen.melon.net.v5x.request.ChartTopWeeklySongChartListReq.Params();
        chartTopWeeklySongChartListReq$Params0.startIndex = 1;
        chartTopWeeklySongChartListReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new ChartTopWeeklySongChartListReq(this.getContext(), chartTopWeeklySongChartListReq$Params0)).tag(this.getRequestTag()).listener(new G(this, 4)).errorListener(this.responseErrorListener).request();
    }

    private static final void requestTopWeeklySong$lambda$77(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTopWeeklySongChartListRes chartTopWeeklySongChartListRes0) {
        if(!melonChartPeriodFragment0.prepareFetchComplete(chartTopWeeklySongChartListRes0)) {
            melonChartPeriodFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        if(chartTopWeeklySongChartListRes0 != null) {
            com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE chartTopWeeklySongChartListRes$RESPONSE0 = chartTopWeeklySongChartListRes0.response;
            if(chartTopWeeklySongChartListRes$RESPONSE0 != null) {
                melonChartPeriodFragment0.updateWeeklyAwardView(chartTopWeeklySongChartListRes$RESPONSE0.musicAward);
                melonChartPeriodFragment0.chartInfoData = chartTopWeeklySongChartListRes$RESPONSE0.chartinfo;
                melonChartPeriodFragment0.chartInfoText = melonChartPeriodFragment0.getString(0x7F1305B9);  // string:mc_artist_review "차트안내"
                if(chartTopWeeklySongChartListRes$RESPONSE0.chartList != null && !chartTopWeeklySongChartListRes$RESPONSE0.chartList.isEmpty() == 1) {
                    melonChartPeriodFragment0.setAllCheckButtonVisibility(true);
                    melonChartPeriodFragment0.updateHeaderLayout(true);
                }
                melonChartPeriodFragment0.mMelonTiaraProperty = new s(chartTopWeeklySongChartListRes$RESPONSE0.section, chartTopWeeklySongChartListRes$RESPONSE0.page, chartTopWeeklySongChartListRes0.getMenuId(), null);
            }
        }
        melonChartPeriodFragment0.performFetchComplete(i.b, chartTopWeeklySongChartListRes0);
    }

    private static final void responseErrorListener$lambda$87(MelonChartPeriodFragment melonChartPeriodFragment0, VolleyError volleyError0) {
        melonChartPeriodFragment0.performFetchError(volleyError0);
        melonChartPeriodFragment0.mResponse = null;
        melonChartPeriodFragment0.updateHeaderLayout(false);
        melonChartPeriodFragment0.setAllCheckButtonVisibility(false);
    }

    public static void s0(MelonChartPeriodFragment melonChartPeriodFragment0, VolleyError volleyError0) {
        MelonChartPeriodFragment.responseErrorListener$lambda$87(melonChartPeriodFragment0, volleyError0);
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        m0.b b1;
        if(z) {
            View view0 = this.playShuffleButton;
            if(view0 != null) {
                view0.setVisibility(0);
            }
            View view1 = this.playAllButton;
            if(view1 != null) {
                view1.setVisibility(0);
            }
            b b0 = this.composableFilterLayout;
            if(b0 != null) {
                b0.d = new m0.b(0x363CFF80, new y(this, 0), true);
            }
            if(b0 != null) {
                String s = this.currentSort;
                if(q.b(s, "T")) {
                    b1 = new m0.b(1900058312, new y(this, 1), true);
                }
                else {
                    b1 = q.b(s, "H") ? new m0.b(0x674B0BB1, new y(this, 2), true) : new m0.b(0xD90CB051, new y(this, 3), true);
                }
                b0.f = b1;
            }
        }
        else {
            View view2 = this.playShuffleButton;
            if(view2 != null) {
                view2.setVisibility(4);
            }
            View view3 = this.playAllButton;
            if(view3 != null) {
                view3.setVisibility(4);
            }
            b b2 = this.composableFilterLayout;
            if(b2 != null) {
                b2.d = null;
            }
            if(b2 != null) {
                b2.f = null;
            }
        }
        b b3 = this.composableFilterLayout;
        if(b3 != null) {
            m0.b b4 = b3.a();
            ComposeView composeView0 = this.filterLayoutComposeView;
            if(composeView0 != null) {
                composeView0.setContent(b4);
                this.updateParallaxHeaderView();
                return;
            }
            q.m("filterLayoutComposeView");
            throw null;
        }
        this.updateParallaxHeaderView();

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.setAllCheckButtonVisibility.lambda.51..inlined.noRippleClickable-YQRRFTQ.default.1 implements we.o {
            public com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.setAllCheckButtonVisibility.lambda.51..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, MelonChartPeriodFragment melonChartPeriodFragment0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                m m0 = ((androidx.compose.runtime.p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                }
                X0.i i0 = new X0.i(this.$role);
                com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.setAllCheckButtonVisibility.lambda.51..inlined.noRippleClickable-YQRRFTQ.default.1.1 melonChartPeriodFragment$setAllCheckButtonVisibility$lambda$51$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(MelonChartPeriodFragment.this);
                        j0 j00 = MelonChartPeriodFragment.this.mAdapter;
                        Top100Adapter melonChartPeriodFragment$Top100Adapter0 = j00 instanceof Top100Adapter ? ((Top100Adapter)j00) : null;
                        if(melonChartPeriodFragment$Top100Adapter0 != null) {
                            melonChartPeriodFragment$Top100Adapter0.clearCache(MelonChartPeriodFragment.this.getCacheKey());
                        }
                        MelonChartPeriodFragment.this.startFetch("refresh");
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.$enabled, this.$onClickLabel, i0, melonChartPeriodFragment$setAllCheckButtonVisibility$lambda$51$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((androidx.compose.runtime.p)l0).p(false);
                return q1;
            }
        }

    }

    private static final H setAllCheckButtonVisibility$lambda$44(MelonChartPeriodFragment melonChartPeriodFragment0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            b0 b00 = melonChartPeriodFragment0.isCheckedAllSelect;
            boolean z = ((androidx.compose.runtime.p)l0).i(melonChartPeriodFragment0);
            com.iloen.melon.fragments.melonchart.x x0 = ((androidx.compose.runtime.p)l0).N();
            if(z || x0 == androidx.compose.runtime.k.a) {
                x0 = new com.iloen.melon.fragments.melonchart.x(melonChartPeriodFragment0, 4);
                ((androidx.compose.runtime.p)l0).l0(x0);
            }
            x1.a.f(b00, x0, ((androidx.compose.runtime.p)l0), 0);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$44$lambda$43$lambda$42(MelonChartPeriodFragment melonChartPeriodFragment0) {
        melonChartPeriodFragment0.toggleSelectAll();
        if(melonChartPeriodFragment0.mMarkedAll) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartPeriodFragment0.mMenuId;
            g0.a = "선택";
            s s0 = melonChartPeriodFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            if(s0 != null) {
                s1 = s0.b;
            }
            g0.c = s1;
            g0.y = "곡리스트";
            g0.F = "전체선택";
            g0.a().track();
        }
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$51(MelonChartPeriodFragment melonChartPeriodFragment0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            melonChartPeriodFragment0.InfoTime(((androidx.compose.runtime.p)l0), 0);
            melonChartPeriodFragment0.DivisionPoint(((androidx.compose.runtime.p)l0), 0);
            String s = H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F1305FB);  // string:melon_chart_top_100_genre_unselect "감상제외"
            boolean z = ((androidx.compose.runtime.p)l0).i(melonChartPeriodFragment0);
            com.iloen.melon.fragments.melonchart.x x0 = ((androidx.compose.runtime.p)l0).N();
            V v1 = androidx.compose.runtime.k.a;
            if(z || x0 == v1) {
                x0 = new com.iloen.melon.fragments.melonchart.x(melonChartPeriodFragment0, 0);
                ((androidx.compose.runtime.p)l0).l0(x0);
            }
            x1.a.c(0x7F080174, null, s, x0, ((androidx.compose.runtime.p)l0), 6);  // drawable:btn_common_setting_genre
            M.c.d(((androidx.compose.runtime.p)l0), androidx.compose.foundation.layout.d.q(n.a, 8.0f));
            C0.c c0 = I.Q(0x7F08024E, ((androidx.compose.runtime.p)l0), 6);  // drawable:btn_refresh_20
            com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.setAllCheckButtonVisibility.lambda.51..inlined.noRippleClickable-YQRRFTQ.default.1 melonChartPeriodFragment$setAllCheckButtonVisibility$lambda$51$$inlined$noRippleClickable-YQRRFTQ$default$10 = new com.iloen.melon.fragments.melonchart.MelonChartPeriodFragment.setAllCheckButtonVisibility.lambda.51..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, melonChartPeriodFragment0);
            r0.q q0 = r0.a.a(n.a, melonChartPeriodFragment$setAllCheckButtonVisibility$lambda$51$$inlined$noRippleClickable-YQRRFTQ$default$10);
            f f0 = ((androidx.compose.runtime.p)l0).N();
            if(f0 == v1) {
                f0 = new f(7);
                ((androidx.compose.runtime.p)l0).l0(f0);
            }
            androidx.compose.foundation.q.c(c0, "", X0.n.c(q0, false, f0), null, null, 0.0f, null, ((androidx.compose.runtime.p)l0), 0, 120);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$51$lambda$47$lambda$46(MelonChartPeriodFragment melonChartPeriodFragment0) {
        if(((e0)o.a()).m()) {
            Navigator.open(SettingBannedContentsFragment.Companion.newInstance(1));
        }
        else {
            com.melon.ui.popup.b.x(melonChartPeriodFragment0.getChildFragmentManager(), melonChartPeriodFragment0.getString(0x7F1300D0), melonChartPeriodFragment0.getString(0x7F130856), false, false, null, null, new Vb.i(27), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
        }
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = melonChartPeriodFragment0.mMenuId;
        g0.a = "페이지이동";
        s s0 = melonChartPeriodFragment0.mMelonTiaraProperty;
        String s1 = null;
        g0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        g0.c = s1;
        g0.y = "곡리스트";
        g0.F = "감상제외";
        g0.a().track();
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$51$lambda$47$lambda$46$lambda$45() {
        Navigator.openLoginView(r8.f.f);
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$51$lambda$50$lambda$49(x x0) {
        q.g(x0, "$this$semantics");
        X0.u.k(x0, 0);
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$56(MelonChartPeriodFragment melonChartPeriodFragment0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            melonChartPeriodFragment0.InfoTime(((androidx.compose.runtime.p)l0), 0);
            melonChartPeriodFragment0.DivisionPoint(((androidx.compose.runtime.p)l0), 0);
            String s = melonChartPeriodFragment0.getChartFilterName();
            melonChartPeriodFragment0.dropDownText.setValue(s);
            b0 b00 = melonChartPeriodFragment0.dropDownText;
            boolean z = ((androidx.compose.runtime.p)l0).i(melonChartPeriodFragment0);
            com.iloen.melon.fragments.melonchart.x x0 = ((androidx.compose.runtime.p)l0).N();
            if(z || x0 == androidx.compose.runtime.k.a) {
                x0 = new com.iloen.melon.fragments.melonchart.x(melonChartPeriodFragment0, 1);
                ((androidx.compose.runtime.p)l0).l0(x0);
            }
            x1.a.a(b00, x0, ((androidx.compose.runtime.p)l0), 0);
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$56$lambda$55$lambda$54(MelonChartPeriodFragment melonChartPeriodFragment0) {
        boolean z = melonChartPeriodFragment0.isRetainedPopupShowing();
        H h0 = H.a;
        if(!z) {
            com.iloen.melon.popup.CommonFilterPopup.Companion commonFilterPopup$Companion0 = CommonFilterPopup.Companion;
            ArrayList arrayList0 = melonChartPeriodFragment0.chartFilterDataList;
            if(arrayList0 == null) {
                q.m("chartFilterDataList");
                throw null;
            }
            CommonFilterPopup commonFilterPopup0 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(commonFilterPopup$Companion0, 0x7F1307D1, "LIST_TYPE_DEPTH_ONE_BASIC", arrayList0, melonChartPeriodFragment0.currentChartFilterIndex, 0, 0, new com.iloen.melon.fragments.melonchart.b(melonChartPeriodFragment0, 1), 0x30, null);  // string:order_by "정렬"
            FragmentActivity fragmentActivity0 = melonChartPeriodFragment0.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    commonFilterPopup0.setDismissFragment(melonChartPeriodFragment0);
                    commonFilterPopup0.show(l00, "ComposeBottomSheet");
                    return h0;
                }
            }
        }
        return h0;
    }

    private static final H setAllCheckButtonVisibility$lambda$56$lambda$55$lambda$54$lambda$52(MelonChartPeriodFragment melonChartPeriodFragment0, int v, int v1, int v2) {
        LogU.Companion.d("MelonChartPeriodFragment", "onFilterSelectionListener oneDepthIndex" + v + ", twoDepthIndex:" + v1);
        H h0 = H.a;
        if(melonChartPeriodFragment0.currentChartFilterIndex == v) {
            return h0;
        }
        melonChartPeriodFragment0.currentChartFilterIndex = v;
        String s = melonChartPeriodFragment0.getChartFilterName();
        melonChartPeriodFragment0.dropDownText.setValue(s);
        melonChartPeriodFragment0.startFetch("filter change");
        String s1 = melonChartPeriodFragment0.getChartFilterName();
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = melonChartPeriodFragment0.mMenuId;
        g0.a = "페이지이동";
        s s2 = melonChartPeriodFragment0.mMelonTiaraProperty;
        String s3 = null;
        g0.b = s2 == null ? null : s2.a;
        if(s2 != null) {
            s3 = s2.b;
        }
        g0.c = s3;
        g0.y = "곡리스트";
        g0.F = s1;
        g0.a().track();
        return h0;
    }

    private static final H setAllCheckButtonVisibility$lambda$59(MelonChartPeriodFragment melonChartPeriodFragment0, l l0, int v) {
        if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
            String s = H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F130AE2);  // string:talkback_chart_info "차트 안내"
            boolean z = ((androidx.compose.runtime.p)l0).i(melonChartPeriodFragment0);
            com.iloen.melon.fragments.melonchart.x x0 = ((androidx.compose.runtime.p)l0).N();
            if(z || x0 == androidx.compose.runtime.k.a) {
                x0 = new com.iloen.melon.fragments.melonchart.x(melonChartPeriodFragment0, 2);
                ((androidx.compose.runtime.p)l0).l0(x0);
            }
            x1.a.c(0x7F080474, null, s, x0, ((androidx.compose.runtime.p)l0), 6);  // drawable:ic_info_15
            return H.a;
        }
        ((androidx.compose.runtime.p)l0).T();
        return H.a;
    }

    private static final H setAllCheckButtonVisibility$lambda$59$lambda$58$lambda$57(MelonChartPeriodFragment melonChartPeriodFragment0) {
        melonChartPeriodFragment0.openChartInfo();
        return H.a;
    }

    private final void setFloatingButton(boolean z) {
        if(!z || this.getMarkedItemCount() != 1 || !q.b(this.currentSort, "T")) {
            View view1 = this.chartReportFloatingButton;
            if(view1 != null) {
                view1.setVisibility(8);
            }
            ViewableCheck viewableCheck1 = this.floatingButtonViewableCheck;
            if(viewableCheck1 != null) {
                viewableCheck1.stop();
            }
        }
        else {
            View view0 = this.chartReportFloatingButton;
            if(view0 != null) {
                view0.setVisibility(0);
            }
            ViewableCheck viewableCheck0 = this.floatingButtonViewableCheck;
            if(viewableCheck0 != null) {
                viewableCheck0.start();
            }
        }
    }

    private final void tiaraViewImpLogFlush() {
        this.tiaraViewImpMapFlush();
        ViewableCheck viewableCheck0 = this.promoBannerViewableCheck;
        if(viewableCheck0 != null) {
            viewableCheck0.stop();
        }
        ViewableCheck viewableCheck1 = this.hot100PromoBannerViewableCheck;
        if(viewableCheck1 != null) {
            viewableCheck1.stop();
        }
    }

    private final void tiaraViewImpMapFlush() {
        ContentList contentList0;
        HashMap hashMap0 = this.tiaraViewImpMap;
        __monitor_enter(hashMap0);
        try {
            if(!this.tiaraViewImpMap.isEmpty()) {
                contentList0 = new ContentList();
                Collection collection0 = this.tiaraViewImpMap.values();
                q.f(collection0, "<get-values>(...)");
                for(Object object0: collection0) {
                    contentList0.addContent(((ViewImpContent)object0));
                }
                this.tiaraViewImpMap.clear();
                goto label_16;
            }
            goto label_28;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(hashMap0);
        throw throwable0;
    label_16:
        __monitor_exit(hashMap0);
        p8.i i0 = new p8.i();  // 初始化器: Lp8/f;-><init>()V
        i0.I = this.mMenuId;
        s s0 = this.mMelonTiaraProperty;
        String s1 = null;
        i0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        i0.c = s1;
        i0.Z = contentList0;
        i0.a().track();
        return;
    label_28:
        __monitor_exit(hashMap0);
    }

    private final void updateHeaderBanner() {
        boolean z = false;
        if(q.b(this.currentSort, "T")) {
            ViewUtils.hideWhen(this.hot100PromoBannerComposeView, true);
            View view0 = this.promoBannerView;
            if(this.top100PromoBannerLiveData.getValue() != null) {
                z = true;
            }
            ViewUtils.showWhen(view0, z);
        }
        else if(q.b(this.currentSort, "H")) {
            ViewUtils.hideWhen(this.promoBannerView, true);
            ComposeView composeView0 = this.hot100PromoBannerComposeView;
            if(this.hot100PromoBannerLiveData.getValue() != null) {
                z = true;
            }
            ViewUtils.showWhen(composeView0, z);
        }
        this.onUpdateParallaxHeader();
    }

    private final void updateHeaderLayout(boolean z) {
        int v = 0;
        View view0 = this.headerContainer;
        if(view0 != null) {
            if(view0.getVisibility() == 0 != z) {
                View view1 = this.headerContainer;
                if(view1 != null) {
                    if(!z) {
                        v = 8;
                    }
                    view1.setVisibility(v);
                    this.onUpdateParallaxHeader();
                    return;
                }
                q.m("headerContainer");
                throw null;
            }
            return;
        }
        q.m("headerContainer");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateSelectAllButton(boolean z) {
        if(!this.isFragmentValid()) {
            return;
        }
        this.isCheckedAllSelect.setValue(Boolean.valueOf(z));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateToolBar(boolean z) {
        super.updateToolBar(z);
        this.setFloatingButton(z);
    }

    private final void updateWeeklyAwardView(MUSICAWARD chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0) {
        if(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0 != null && (chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.weekranklists != null && !chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.weekranklists.isEmpty() == 1)) {
            MelonChartAwardView melonChartAwardView0 = this.chartAwardView;
            if(melonChartAwardView0 != null) {
                melonChartAwardView0.setVisibility(0);
                MelonChartAwardView melonChartAwardView1 = this.chartAwardView;
                if(melonChartAwardView1 != null) {
                    String s = this.mMenuId;
                    q.f(s, "mMenuId");
                    melonChartAwardView1.a(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0, s, (this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.a), (this.mMelonTiaraProperty == null ? null : this.mMelonTiaraProperty.b));
                    MelonChartAwardView melonChartAwardView2 = this.chartAwardView;
                    if(melonChartAwardView2 != null) {
                        melonChartAwardView2.invalidate();
                        this.updateParallaxHeaderView();
                        return;
                    }
                    q.m("chartAwardView");
                    throw null;
                }
                q.m("chartAwardView");
                throw null;
            }
            q.m("chartAwardView");
            throw null;
        }
        MelonChartAwardView melonChartAwardView3 = this.chartAwardView;
        if(melonChartAwardView3 != null) {
            melonChartAwardView3.setVisibility(8);
            this.updateParallaxHeaderView();
            return;
        }
        q.m("chartAwardView");
        throw null;
    }

    public static void w0(MelonChartPeriodFragment melonChartPeriodFragment0, ChartTop100ListRes chartTop100ListRes0) {
        MelonChartPeriodFragment.requestTOP100ChartList$lambda$69(melonChartPeriodFragment0, chartTop100ListRes0);
    }

    public static H z0(x x0) {
        return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$51$lambda$50$lambda$49(x0);
    }
}

