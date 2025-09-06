package com.iloen.melon.fragments.detail;

import F8.I;
import F8.m;
import F8.o;
import F8.p;
import J8.m0;
import J8.n0;
import J8.z2;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnClickListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnData;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnInfo;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.OnViewHolderActionListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment;
import com.iloen.melon.fragments.main.foru.ForUUtils;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v6x.request.MixMakerCreateReq;
import com.iloen.melon.net.v6x.response.MixMakerCreateRes.RESPONSE.SONG;
import com.iloen.melon.net.v6x.response.MixMakerCreateRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MixMakerCreateRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.datastore.MixMakerPreferencesRepository;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.template.TemplateData.MixMakerPlaylistTemplateDataBuilder;
import com.iloen.melon.utils.template.TemplateImageLoader;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.F1;
import com.melon.ui.V1;
import com.melon.ui.k2;
import d3.g;
import e.k;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import pc.V0;
import v9.h;
import v9.i;
import we.n;
import zd.d0;

@Metadata(d1 = {"\u0000\u00FE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00A7\u00012\u00020\u00012\u00020\u0002:\u0004\u00A7\u0001\u00A8\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u000B\u0010\u0007J\u000F\u0010\f\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\f\u0010\nJ!\u0010\u0011\u001A\u00020\u00102\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000F\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0013\u0010\nJ\u000F\u0010\u0014\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0007J\u0015\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0013\u0010\u0016J\u0019\u0010\u0019\u001A\u00020\u00102\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0004J\u0017\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b!\u0010\u001AJ\u0017\u0010#\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b#\u0010\u001AJ!\u0010&\u001A\u00020\u00102\u0006\u0010%\u001A\u00020$2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b(\u0010\u0007J\u000F\u0010)\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b)\u0010\u0004J\u000F\u0010*\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b*\u0010\u0004J\u000F\u0010+\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b+\u0010\u0004J\u0017\u0010-\u001A\u00020\u00102\u0006\u0010,\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b-\u0010.J\u0019\u00101\u001A\u00020\u00102\b\u00100\u001A\u0004\u0018\u00010/H\u0016\u00A2\u0006\u0004\b1\u00102J\u001F\u00107\u001A\u00020\u00102\u0006\u00104\u001A\u0002032\u0006\u00106\u001A\u000205H\u0016\u00A2\u0006\u0004\b7\u00108J\u000F\u0010:\u001A\u000209H\u0016\u00A2\u0006\u0004\b:\u0010;J\u0011\u0010=\u001A\u0004\u0018\u00010<H\u0014\u00A2\u0006\u0004\b=\u0010>J\u001B\u0010B\u001A\u0006\u0012\u0002\b\u00030A2\u0006\u0010@\u001A\u00020?H\u0014\u00A2\u0006\u0004\bB\u0010CJ-\u0010I\u001A\u00020\u00052\b\u0010E\u001A\u0004\u0018\u00010D2\b\u0010G\u001A\u0004\u0018\u00010F2\b\u0010H\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\bI\u0010JJ\u000F\u0010K\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\bK\u0010\u0004J\u000F\u0010L\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\bL\u0010\u0004J\u0015\u0010O\u001A\b\u0012\u0004\u0012\u00020N0MH\u0016\u00A2\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001A\u00020\u00102\u0006\u0010Q\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\bR\u0010SJ\u0013\u0010U\u001A\u00060TR\u00020\u0001H\u0016\u00A2\u0006\u0004\bU\u0010VJ/\u0010[\u001A\u00020\u00102\u0006\u0010W\u001A\u00020\b2\u0006\u0010X\u001A\u00020\r2\u0006\u0010Y\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b[\u0010\\J/\u0010]\u001A\u00020\u00102\u0006\u0010W\u001A\u00020\b2\u0006\u0010X\u001A\u00020\r2\u0006\u0010Y\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b]\u0010\\J/\u0010^\u001A\u00020\u00102\u0006\u0010W\u001A\u00020\b2\u0006\u0010X\u001A\u00020\r2\u0006\u0010Y\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b^\u0010\\J7\u0010a\u001A\u00020\u00102\u0006\u0010X\u001A\u00020\r2\u0006\u0010_\u001A\u00020\b2\u0006\u0010Y\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\b2\u0006\u0010`\u001A\u00020\bH\u0016\u00A2\u0006\u0004\ba\u0010bJ7\u0010c\u001A\u00020\u00102\u0006\u0010X\u001A\u00020\r2\u0006\u0010_\u001A\u00020\b2\u0006\u0010Y\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\b2\u0006\u0010`\u001A\u00020\bH\u0016\u00A2\u0006\u0004\bc\u0010bJ?\u0010e\u001A\u00020\u00102\u0006\u0010X\u001A\u00020\r2\u0006\u0010_\u001A\u00020\b2\u0006\u0010Y\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\b2\u0006\u0010`\u001A\u00020\b2\u0006\u0010d\u001A\u00020\bH\u0016\u00A2\u0006\u0004\be\u0010fJ7\u0010g\u001A\u00020\u00102\u0006\u0010X\u001A\u00020\r2\u0006\u0010_\u001A\u00020\b2\u0006\u0010Y\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\b2\u0006\u0010`\u001A\u00020\bH\u0016\u00A2\u0006\u0004\bg\u0010bJ\u0011\u0010i\u001A\u0004\u0018\u00010hH\u0002\u00A2\u0006\u0004\bi\u0010jJ\u0011\u0010k\u001A\u0004\u0018\u00010hH\u0002\u00A2\u0006\u0004\bk\u0010jJ\u000F\u0010l\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\bl\u0010\u0004J\u0017\u0010o\u001A\u00020\u00102\u0006\u0010n\u001A\u00020mH\u0002\u00A2\u0006\u0004\bo\u0010pJ\u000F\u0010q\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\bq\u0010\u0004J\u000F\u0010r\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\br\u0010\u0004J\u001F\u0010v\u001A\u0012\u0012\u0004\u0012\u00020t0sj\b\u0012\u0004\u0012\u00020t`uH\u0002\u00A2\u0006\u0004\bv\u0010wJ\u0017\u0010x\u001A\u00020\u00102\u0006\u0010Q\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\bx\u0010SJ\u000F\u0010y\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\by\u0010\u0004J\u0017\u0010{\u001A\u00020\u00102\u0006\u0010z\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b{\u0010SJ\u0017\u0010|\u001A\u00020\u00102\u0006\u0010n\u001A\u00020mH\u0002\u00A2\u0006\u0004\b|\u0010pJ\u0011\u0010~\u001A\u0004\u0018\u00010}H\u0002\u00A2\u0006\u0004\b~\u0010\u007FJ\u0011\u0010\u0080\u0001\u001A\u00020\u0010H\u0002\u00A2\u0006\u0005\b\u0080\u0001\u0010\u0004J\u0011\u0010\u0081\u0001\u001A\u00020\u0010H\u0002\u00A2\u0006\u0005\b\u0081\u0001\u0010\u0004J\u0011\u0010\u0082\u0001\u001A\u00020\u0010H\u0002\u00A2\u0006\u0005\b\u0082\u0001\u0010\u0004R\u0019\u0010\u0083\u0001\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0084\u0001R\u0017\u0010\u0015\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0015\u0010\u0088\u0001R)\u0010\u0089\u0001\u001A\u0012\u0012\u0004\u0012\u00020N0sj\b\u0012\u0004\u0012\u00020N`u8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008A\u0001R\u001E\u0010\u008C\u0001\u001A\u00070\u008B\u0001R\u00020\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u008C\u0001\u0010\u008D\u0001R\u001C\u0010\u008F\u0001\u001A\u0005\u0018\u00010\u008E\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008F\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001A\u00020$8\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001C\u0010\u0094\u0001\u001A\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0097\u0001\u001A\u00030\u0096\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R!\u0010\u009E\u0001\u001A\u00030\u0099\u00018VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u009A\u0001\u0010\u009B\u0001\u001A\u0006\b\u009C\u0001\u0010\u009D\u0001R\u0018\u0010\u00A2\u0001\u001A\u00030\u009F\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00A0\u0001\u0010\u00A1\u0001R\u001A\u0010\u00A6\u0001\u001A\u0005\u0018\u00010\u00A3\u00018BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00A4\u0001\u0010\u00A5\u0001\u00A8\u0006\u00A9\u0001"}, d2 = {"Lcom/iloen/melon/fragments/detail/MixMakerPlaylistDetailFragment;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "showSpaceViewBottomButtonParallax", "()Z", "", "getContsId", "()Ljava/lang/String;", "isScreenLandscapeSupported", "getContsTypeCode", "", "sumCount", "isLike", "Lie/H;", "updateLikeView", "(Ljava/lang/Integer;Z)V", "getCacheKey", "shouldShowMiniPlayer", "isPersonalMode", "(Z)Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "inState", "onRestoreInstanceState", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "onDestroy", "onAppBarCollapsed", "onAppBarExpended", "offset", "onAppBarScrolling", "(I)V", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "infoCmtContsRes", "updateCommentCountView", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "updateHeaderView", "addAll", "", "Lcom/melon/net/res/common/SongInfoBase;", "getAllSongList", "()Ljava/util/List;", "checked", "updateSelectAllButton", "(Z)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "getOnViewHolderActionListener", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "setNum", "ordNum", "metaId", "metaName", "songItemInAlbumClickLog", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "songPlayInAlbumClickLog", "songMoreInAlbumClickLog", "image", "metaAuthor", "songThumbClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "songItemClickLog", "cType", "songPlayClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "songMoreClickLog", "Lcom/iloen/melon/net/v6x/response/MixMakerCreateRes;", "requestMixMakerPlaylist", "()Lcom/iloen/melon/net/v6x/response/MixMakerCreateRes;", "fetchDetailCacheData", "togglePersonalMode", "Lcom/iloen/melon/net/v6x/response/MixMakerCreateRes$RESPONSE;", "response", "drawHeaderView", "(Lcom/iloen/melon/net/v6x/response/MixMakerCreateRes$RESPONSE;)V", "showContextPopupDetail", "downloadAll", "Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "Lkotlin/collections/ArrayList;", "makePlayables", "()Ljava/util/ArrayList;", "updateSelectButton", "setSongListHeader", "isVisible", "showWhenSongListHeader", "setTiaraBaseInfo", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "personalSettingClickLog", "moreClickLog", "allSelectClickLog", "searchKeyword", "Ljava/lang/String;", "navigateBackCount", "I", "playlistTitle", "Z", "playSongList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "detailAdapter", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "LF8/o;", "titleItemBase", "LF8/o;", "bottomDivider", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "coverBitmap", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData$delegate", "Lie/j;", "getBottomBtnData", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "LJ8/z2;", "getHeaderBinding", "()LJ8/z2;", "headerBinding", "Companion", "MixMakerPlaylistDetail", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixMakerPlaylistDetailFragment extends DetailSongMetaContentBaseFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\fH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/detail/MixMakerPlaylistDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SEARCH_KEYWORD", "ARG_NAVIGATE_BACK_COUNT", "newInstance", "Lcom/iloen/melon/fragments/detail/MixMakerPlaylistDetailFragment;", "searchKeyword", "navigateBackCount", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MixMakerPlaylistDetailFragment newInstance(@NotNull String s, int v) {
            q.g(s, "searchKeyword");
            MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0 = new MixMakerPlaylistDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argSearchKeyword", s);
            bundle0.putInt("argNavigationBackCount", v);
            mixMakerPlaylistDetailFragment0.setArguments(bundle0);
            return mixMakerPlaylistDetailFragment0;
        }

        public static MixMakerPlaylistDetailFragment newInstance$default(Companion mixMakerPlaylistDetailFragment$Companion0, String s, int v, int v1, Object object0) {
            if((v1 & 2) != 0) {
                v = 1;
            }
            return mixMakerPlaylistDetailFragment$Companion0.newInstance(s, v);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B)\b\u0000\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/detail/MixMakerPlaylistDetailFragment$MixMakerPlaylistDetail;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Landroid/content/Context;", "context", "", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/MixMakerPlaylistDetailFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public class MixMakerPlaylistDetail extends DetailAdapter {
        public MixMakerPlaylistDetail(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            if(httpResponse0 instanceof MixMakerCreateRes) {
                ArrayList arrayList0 = new ArrayList();
                MixMakerPlaylistDetailFragment.this.playSongList.clear();
                ArrayList arrayList1 = ((MixMakerCreateRes)httpResponse0).response.songList;
                q.f(arrayList1, "songList");
                MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0 = MixMakerPlaylistDetailFragment.this;
                for(Object object0: arrayList1) {
                    a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a0.a = 1;
                    a0.b = (SONG)object0;
                    arrayList0.add(new AdapterInViewHolder.Row(a0));
                    mixMakerPlaylistDetailFragment0.playSongList.add(((SONG)object0));
                }
                this.addAll(arrayList0);
            }
            this.setHasMore(false);
            this.updateModifiedTime(s);
            return true;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_NAVIGATE_BACK_COUNT = "argNavigationBackCount";
    @NotNull
    private static final String ARG_SEARCH_KEYWORD = "argSearchKeyword";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MixMakerPlaylistDetailFragment";
    @NotNull
    private final j bottomBtnData$delegate;
    private View bottomDivider;
    @Nullable
    private Bitmap coverBitmap;
    private DetailAdapter detailAdapter;
    private boolean isPersonalMode;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    private int navigateBackCount;
    @NotNull
    private ArrayList playSongList;
    @NotNull
    private String playlistTitle;
    @NotNull
    private String searchKeyword;
    @Nullable
    private o titleItemBase;

    static {
        MixMakerPlaylistDetailFragment.Companion = new Companion(null);
        MixMakerPlaylistDetailFragment.$stable = 8;
    }

    public MixMakerPlaylistDetailFragment() {
        this.searchKeyword = "";
        this.navigateBackCount = 1;
        this.playlistTitle = "";
        this.isPersonalMode = this.isLoginUser();
        this.playSongList = new ArrayList();
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.mainExceptionHandler.1.1(throwable0, MixMakerPlaylistDetailFragment.this, null), 3, null);
            }
        };
        this.bottomBtnData$delegate = g.Q(new b(this, 3));

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/iloen/melon/fragments/detail/MixMakerPlaylistDetailFragment$bottomBtnData$2$1", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "Lie/H;", "onShuffleSongClick", "()V", "onPlayAllSongClick", "onMixUpPlayClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.bottomBtnData.2.1 implements BottomBtnClickListener {
            public com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.bottomBtnData.2.1(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onAddSongClick() {
                BottomBtnClickListener.super.onAddSongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onMixUpPlayClick() {
                String s = MixMakerPlaylistDetailFragment.this.getMenuId();
                ArrayList arrayList0 = MixMakerPlaylistDetailFragment.access$makePlayables(MixMakerPlaylistDetailFragment.this);
                V0 v00 = new V0(MixMakerPlaylistDetailFragment.this.getStatsElements(), MixMakerPlaylistDetailFragment.access$getPlaylistTitle$p(MixMakerPlaylistDetailFragment.this), MixMakerPlaylistDetailFragment.access$getPlaylistTitle$p(MixMakerPlaylistDetailFragment.this), arrayList0);
                MixMakerPlaylistDetailFragment.this.playMixUp(s, v00);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlayAllSongClick() {
                MixMakerPlaylistDetailFragment.access$playAll(MixMakerPlaylistDetailFragment.this);
                f f0 = MixMakerPlaylistDetailFragment.access$getTiaraEventBuilder(MixMakerPlaylistDetailFragment.this);
                if(f0 != null) {
                    String s = "음악재생";
                    MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0 = MixMakerPlaylistDetailFragment.this;
                    String s1 = "";
                    if(mixMakerPlaylistDetailFragment0.getContext() == null) {
                        s = "";
                    }
                    String s2 = "곡리스트";
                    f0.a = s;
                    if(mixMakerPlaylistDetailFragment0.getContext() == null) {
                        s2 = "";
                    }
                    f0.y = s2;
                    if(mixMakerPlaylistDetailFragment0.getContext() != null) {
                        s1 = "전체재생";
                    }
                    f0.F = s1;
                    f0.a().track();
                }
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlaySongClick() {
                BottomBtnClickListener.super.onPlaySongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onShuffleSongClick() {
                MixMakerPlaylistDetailFragment.access$playShuffleAll(MixMakerPlaylistDetailFragment.this);
                f f0 = MixMakerPlaylistDetailFragment.access$getTiaraEventBuilder(MixMakerPlaylistDetailFragment.this);
                if(f0 != null) {
                    String s = "음악재생";
                    MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0 = MixMakerPlaylistDetailFragment.this;
                    String s1 = "";
                    if(mixMakerPlaylistDetailFragment0.getContext() == null) {
                        s = "";
                    }
                    String s2 = "곡리스트";
                    f0.a = s;
                    if(mixMakerPlaylistDetailFragment0.getContext() == null) {
                        s2 = "";
                    }
                    f0.y = s2;
                    if(mixMakerPlaylistDetailFragment0.getContext() != null) {
                        s1 = "셔플재생";
                    }
                    f0.F = s1;
                    f0.a().track();
                }
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment$mainExceptionHandler$1$1", f = "MixMakerPlaylistDetailFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.mainExceptionHandler.1.1(Throwable throwable0, MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                MixMakerPlaylistDetailFragment.this = mixMakerPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.mainExceptionHandler.1.1(this.$throwable, MixMakerPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Throwable throwable0 = this.$throwable;
                if(throwable0 instanceof VolleyError) {
                    H0.b.w("mainExceptionHandler message: ", throwable0.getMessage(), LogU.Companion, "MixMakerPlaylistDetailFragment");
                    MixMakerPlaylistDetailFragment.this.showNetworkErrorHeaderView(true);
                    MixMakerPlaylistDetailFragment.access$getMResponseErrorListener$p$s1927414203(MixMakerPlaylistDetailFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s1927414203(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
        return mixMakerPlaylistDetailFragment0.mResponseErrorListener;
    }

    public static final String access$getPlaylistTitle$p(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
        return mixMakerPlaylistDetailFragment0.playlistTitle;
    }

    public static final f access$getTiaraEventBuilder(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
        return mixMakerPlaylistDetailFragment0.getTiaraEventBuilder();
    }

    public static final ArrayList access$makePlayables(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
        return mixMakerPlaylistDetailFragment0.makePlayables();
    }

    public static final void access$playAll(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
        mixMakerPlaylistDetailFragment0.playAll();
    }

    public static final void access$playShuffleAll(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
        mixMakerPlaylistDetailFragment0.playShuffleAll();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void addAll() {
        this.playSongs(this.makePlayables(), false, false);
    }

    private final void allSelectClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s = "선택";
            String s1 = "";
            if(this.getContext() == null) {
                s = "";
            }
            String s2 = "곡리스트";
            f0.a = s;
            if(this.getContext() == null) {
                s2 = "";
            }
            f0.y = s2;
            if(this.getContext() != null) {
                s1 = "전체선택";
            }
            f0.F = s1;
            f0.a().track();
        }
    }

    private static final BottomBtnData bottomBtnData_delegate$lambda$1(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0) {
        return new BottomBtnData(10.0f, k.e(new BottomBtnInfo[]{new BottomBtnInfo(10002, 0.0f, null, 4, null), new BottomBtnInfo(10001, 0.0f, null, 4, null), new BottomBtnInfo(10004, 0.0f, null, 4, null)}), new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.bottomBtnData.2.1(mixMakerPlaylistDetailFragment0));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0 = new MixMakerPlaylistDetail(this, context0, null);
        detailSongMetaContentBaseFragment$DetailAdapter0.setMarkedMode(true);
        detailSongMetaContentBaseFragment$DetailAdapter0.setListContentType(1);
        this.detailAdapter = detailSongMetaContentBaseFragment$DetailAdapter0;
        return detailSongMetaContentBaseFragment$DetailAdapter0;
    }

    private final void downloadAll() {
        this.downloadSongs(this.getMenuId(), this.makePlayables());
    }

    private final void drawHeaderView(RESPONSE mixMakerCreateRes$RESPONSE0) {
        z2 z20 = this.getHeaderBinding();
        if(z20 != null) {
            ConstraintLayout constraintLayout0 = z20.a;
            if(constraintLayout0 != null) {
                constraintLayout0.setVisibility(0);
            }
        }
        n0 n00 = this.getBottomButton();
        if(n00 != null) {
            n00.a.setVisibility(0);
        }
        o o0 = this.titleItemBase;
        if(o0 != null) {
            this.getTitleBar().a(o0);
        }
        z2 z21 = this.getHeaderBinding();
        if(z21 != null) {
            CoverView coverView0 = (CoverView)z21.a.findViewById(0x7F0A0355);  // id:cover_view
            MelonTextView melonTextView0 = (MelonTextView)z21.a.findViewById(0x7F0A0CE3);  // id:tv_playlist_name
            MelonTextView melonTextView1 = (MelonTextView)z21.a.findViewById(0x7F0A0CDB);  // id:tv_personal_desc
            MelonTextView melonTextView2 = (MelonTextView)z21.a.findViewById(0x7F0A0CDC);  // id:tv_personal_toggle_desc
            ConstraintLayout constraintLayout1 = (ConstraintLayout)z21.a.findViewById(0x7F0A0371);  // id:ctl_personal_toggle
            ImageView imageView0 = (ImageView)z21.a.findViewById(0x7F0A065E);  // id:iv_personal
            q.d(coverView0);
            TemplateImageLoader templateImageLoader0 = new TemplateImageLoader(new MixMakerPlaylistTemplateDataBuilder(coverView0, mixMakerCreateRes$RESPONSE0.albumImgList).build());
            coverView0.setImageBitmap(null);
            templateImageLoader0.load(new com.iloen.melon.fragments.detail.a(10, coverView0, this));
            coverView0.setOnClickListener(new s(templateImageLoader0, 1));
            ViewUtils.setContentDescriptionWithButtonClassName(coverView0, this.getString(0x7F130BFB));  // string:talkback_playlist_thumb_cover "플레이리스트 커버 크게보기"
            String s = ForUUtils.replaceNicknameWithMarkup(mixMakerCreateRes$RESPONSE0.personalComment, "<b>DETAILREPLACE</b>", "<b>" + mixMakerCreateRes$RESPONSE0.detailReplace + "</b>", 0x7FFFFFFE);
            Context context0 = this.getContext();
            boolean z = true;
            if(context0 != null) {
                SpannableString spannableString0 = new SpannableString(". " + mixMakerCreateRes$RESPONSE0.mainTitle);
                spannableString0.setSpan(new ImageSpan() {
                    {
                        super(context0, 0x7F0804BA, 0);  // drawable:ic_mixmaker_mix
                    }

                    @Override  // android.text.style.DynamicDrawableSpan
                    public void draw(Canvas canvas0, CharSequence charSequence0, int v, int v1, float f, int v2, int v3, int v4, Paint paint0) {
                        q.g(canvas0, "canvas");
                        q.g(paint0, "paint");
                        canvas0.save();
                        Paint.FontMetricsInt paint$FontMetricsInt0 = paint0.getFontMetricsInt();
                        canvas0.translate(f, ((float)(v3 + paint$FontMetricsInt0.descent - (paint$FontMetricsInt0.descent - paint$FontMetricsInt0.ascent) / 2 - (this.getDrawable().getBounds().bottom - this.getDrawable().getBounds().top) / 2)));
                        this.getDrawable().draw(canvas0);
                        canvas0.restore();
                    }

                    @Override  // android.text.style.DynamicDrawableSpan
                    public int getSize(Paint paint0, CharSequence charSequence0, int v, int v1, Paint.FontMetricsInt paint$FontMetricsInt0) {
                        q.g(paint0, "paint");
                        Rect rect0 = this.getDrawable().getBounds();
                        q.f(rect0, "getBounds(...)");
                        if(paint$FontMetricsInt0 != null) {
                            Paint.FontMetricsInt paint$FontMetricsInt1 = paint0.getFontMetricsInt();
                            int v2 = (paint$FontMetricsInt1.descent - paint$FontMetricsInt1.ascent) / 2 + paint$FontMetricsInt1.ascent;
                            int v3 = (rect0.bottom - rect0.top) / 2;
                            int v4 = v2 - v3;
                            paint$FontMetricsInt0.ascent = v4;
                            paint$FontMetricsInt0.top = v4;
                            int v5 = v2 + v3;
                            paint$FontMetricsInt0.bottom = v5;
                            paint$FontMetricsInt0.descent = v5;
                        }
                        return rect0.right;
                    }
                }, 0, 1, 33);
                melonTextView0.setText(spannableString0);
                melonTextView0.setContentDescription(this.getString(0x7F130AF0) + melonTextView0.getText());  // string:talkback_common_mix "믹스"
                androidx.window.layout.util.a.r(melonTextView0);
            }
            melonTextView1.setText(Html.fromHtml(ResourceUtils.replaceFontColor(this.getContext(), s, 0), 0));
            melonTextView1.setVisibility(0);
            String s1 = mixMakerCreateRes$RESPONSE0.totalSongCount;
            q.f(s1, "totalSongCount");
            if(Integer.parseInt(s1) <= 0) {
                z = false;
            }
            this.showWhenSongListHeader(z);
            this.setSongListHeader();
            n0 n01 = this.getBottomButton();
            if(n01 != null) {
                String s2 = this.getString(0x7F13083B, new Object[]{mixMakerCreateRes$RESPONSE0.totalSongCount});  // string:playlist_song_count "%s곡"
                n01.i.setText(s2);
                String s3 = mixMakerCreateRes$RESPONSE0.totalPlayTime;
                q.f(s3, "totalPlayTime");
                long v = Long.parseLong(s3);
                String s4 = StringUtils.INSTANCE.formatPlaylistTime(v * 1000L);
                n01.j.setText(s4);
            }
            imageView0.setImageResource((this.isPersonalMode ? 0x7F08027F : 0x7F08027E));  // drawable:btn_toggle_on
            constraintLayout1.setContentDescription(melonTextView2.getText().toString() + "," + this.getString((this.isPersonalMode ? 0x7F130BAD : 0x7F130BA9)) + "," + this.getString(0x7F130AF5));  // string:talkback_on "켜짐"
            if(constraintLayout1.isAccessibilityFocused()) {
                constraintLayout1.sendAccessibilityEvent(8);
            }
            constraintLayout1.setOnClickListener(new u(this, 1));
            constraintLayout1.setVisibility(0);
        }
    }

    private static final void drawHeaderView$lambda$15$lambda$10(CoverView coverView0, MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0, Bitmap bitmap0) {
        q.g(bitmap0, "bitmap");
        if(coverView0 != null) {
            coverView0.setImageBitmap(bitmap0);
        }
        mixMakerPlaylistDetailFragment0.coverBitmap = bitmap0;
    }

    private static final void drawHeaderView$lambda$15$lambda$11(TemplateImageLoader templateImageLoader0, View view0) {
        if(templateImageLoader0.isCachingSuccess()) {
            Navigator.openPhotoUrl(templateImageLoader0.getTemplateCacheKey());
        }
    }

    private static final void drawHeaderView$lambda$15$lambda$14(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0, View view0) {
        mixMakerPlaylistDetailFragment0.togglePersonalMode();
    }

    private final MixMakerCreateRes fetchDetailCacheData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.getCacheKey());
        if(cursor0 == null) {
            return null;
        }
        MixMakerCreateRes mixMakerCreateRes0 = (MixMakerCreateRes)com.iloen.melon.responsecache.a.d(cursor0, MixMakerCreateRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        return mixMakerCreateRes0 == null ? null : mixMakerCreateRes0;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public List getAllSongList() {
        return this.playSongList;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public BottomBtnData getBottomBtnData() {
        return (BottomBtnData)this.bottomBtnData$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = this.isPersonalMode ? "ON" : "OFF";
        String s1 = MelonContentUris.D.buildUpon().appendPath(this.playlistTitle).appendPath(s).build().toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    @NotNull
    public final String getCacheKey(boolean z) {
        String s = MelonContentUris.D.buildUpon().appendPath(this.playlistTitle).appendPath((z ? "ON" : "OFF")).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsId() {
        return "";
    }

    // 去混淆评级： 低(30)
    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsTypeCode() {
        q.f("N10078", "code(...)");
        return "N10078";
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment, kotlinx.coroutines.CoroutineScope
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    private final z2 getHeaderBinding() {
        return (z2)this.get_headerBinding();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public OnViewHolderActionListener getOnViewHolderActionListener() {
        return new OnViewHolderActionListener() {
            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onPerformBackPress() {
                MixMakerPlaylistDetailFragment.this.performBackPress();
            }
        };
    }

    private final f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty != null) {
            f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = this.mMelonTiaraProperty.a;
            f0.c = this.mMelonTiaraProperty.b;
            f0.I = this.mMelonTiaraProperty.c;
            return f0;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    private final ArrayList makePlayables() {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.playSongList) {
            arrayList0.add(Playable.from(((SongInfoBase)object0), this.getMenuId(), this.getStatsElements()));
        }
        return arrayList0;
    }

    private final void moreClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s = "페이지이동";
            String s1 = "";
            if(this.getContext() == null) {
                s = "";
            }
            String s2 = "GNB";
            f0.a = s;
            if(this.getContext() == null) {
                s2 = "";
            }
            f0.y = s2;
            if(this.getContext() != null) {
                s1 = "더보기";
            }
            f0.F = s1;
            f0.a().track();
        }
    }

    @NotNull
    public static final MixMakerPlaylistDetailFragment newInstance(@NotNull String s, int v) {
        return MixMakerPlaylistDetailFragment.Companion.newInstance(s, v);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarCollapsed() {
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.setTitle(this.playlistTitle);
        titleBar0.f(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarExpended() {
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.setTitle("");
        titleBar0.f(true);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarScrolling(int v) {
        float f = (float)Math.abs(v);
        if(f > 0.0f) {
            this.getTitleBar().setTitle(this.playlistTitle);
            return;
        }
        if(f == 0.0f) {
            this.getTitleBar().f(false);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        BaseActivity baseActivity0 = fragmentActivity0 instanceof BaseActivity ? ((BaseActivity)fragmentActivity0) : null;
        if(baseActivity0 != null) {
            baseActivity0.navigateBack(this.navigateBackCount);
        }
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        Context context0 = this.getContext();
        if(!com.iloen.melon.responsecache.a.e(300000L, this.getCacheKey(), context0)) {
            this.updateHeaderView();
            return;
        }
        this.onFetchStart(i.b, null, "");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(null) {
            int label;

            {
                MixMakerPlaylistDetailFragment.this = mixMakerPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onCreate.1(MixMakerPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onCreate.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return MixMakerPreferencesRepository.INSTANCE.add(MixMakerPlaylistDetailFragment.this.searchKeyword, this) == a0 ? a0 : H.a;
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

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        return z2.a(LayoutInflater.from(this.getContext()));
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = super.onCreateRecyclerView();
        if(recyclerView0 != null) {
            recyclerView0.addItemDecoration(new r0() {
                @Override  // androidx.recyclerview.widget.r0
                public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                    q.g(rect0, "outRect");
                    q.g(view0, "view");
                    q.g(recyclerView0, "parent");
                    q.g(k00, "state");
                    int v = recyclerView0.getChildAdapterPosition(view0);
                    j0 j00 = this.$this_apply.getAdapter();
                    if(v == (j00 == null ? 0 : j00.getItemCount()) - 1) {
                        rect0.bottom = ScreenUtils.dipToPixel(this.$this_apply.getContext(), 30.0f);
                    }
                }
            });
            return recyclerView0;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        super.onDestroy();
        com.iloen.melon.responsecache.a.c(this.getContext(), this.getCacheKey(true), true);
        com.iloen.melon.responsecache.a.c(this.getContext(), this.getCacheKey(false), true);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        this.setFetchStart(true);
        Context context0 = this.getContext();
        if(com.iloen.melon.responsecache.a.e(300000L, this.getCacheKey(), context0)) {
            BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO().plus(this.mainExceptionHandler), null, new n(i0, null) {
                final i $type;
                int label;

                {
                    MixMakerPlaylistDetailFragment.this = mixMakerPlaylistDetailFragment0;
                    this.$type = i0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1(MixMakerPlaylistDetailFragment.this, this.$type, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1.1 mixMakerPlaylistDetailFragment$onFetchStart$1$10 = new n(this.$type, null) {
                                final i $type;
                                Object L$0;
                                int label;

                                {
                                    MixMakerPlaylistDetailFragment.this = mixMakerPlaylistDetailFragment0;
                                    this.$type = i0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1.1(MixMakerPlaylistDetailFragment.this, this.$type, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    ne.a a0 = ne.a.a;
                                    switch(this.label) {
                                        case 0: {
                                            d5.n.D(object0);
                                            MixMakerCreateRes mixMakerCreateRes0 = MixMakerPlaylistDetailFragment.this.requestMixMakerPlaylist();
                                            if(mixMakerCreateRes0 != null) {
                                                Cb.j.b(mixMakerCreateRes0.notification, false, 3);
                                                if(Cb.j.d(mixMakerCreateRes0)) {
                                                    me.i i0 = Dispatchers.getMain().plus(MixMakerPlaylistDetailFragment.this.mainExceptionHandler);
                                                    com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1.1.2 mixMakerPlaylistDetailFragment$onFetchStart$1$1$20 = new n(mixMakerCreateRes0, this.$type, null) {
                                                        final MixMakerCreateRes $mixMakerCreateRes;
                                                        final i $type;
                                                        int label;

                                                        {
                                                            MixMakerPlaylistDetailFragment.this = mixMakerPlaylistDetailFragment0;
                                                            this.$mixMakerCreateRes = mixMakerCreateRes0;
                                                            this.$type = i0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1.1.2(MixMakerPlaylistDetailFragment.this, this.$mixMakerCreateRes, this.$type, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.onFetchStart.1.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            RESPONSE mixMakerCreateRes$RESPONSE0 = this.$mixMakerCreateRes.response;
                                                            q.f(mixMakerCreateRes$RESPONSE0, "response");
                                                            MixMakerPlaylistDetailFragment.this.setTiaraBaseInfo(mixMakerCreateRes$RESPONSE0);
                                                            String s = this.$mixMakerCreateRes.response.mainTitle;
                                                            q.f(s, "mainTitle");
                                                            MixMakerPlaylistDetailFragment.this.playlistTitle = s;
                                                            Context context0 = MixMakerPlaylistDetailFragment.this.getContext();
                                                            String s1 = MixMakerPlaylistDetailFragment.this.getCacheKey();
                                                            com.iloen.melon.responsecache.a.a(context0, this.$mixMakerCreateRes, s1);
                                                            RESPONSE mixMakerCreateRes$RESPONSE1 = this.$mixMakerCreateRes.response;
                                                            q.f(mixMakerCreateRes$RESPONSE1, "response");
                                                            MixMakerPlaylistDetailFragment.this.drawHeaderView(mixMakerCreateRes$RESPONSE1);
                                                            boolean z = MixMakerPlaylistDetailFragment.this.prepareFetchComplete(this.$mixMakerCreateRes);
                                                            H h0 = H.a;
                                                            if(!z) {
                                                                return h0;
                                                            }
                                                            MixMakerPlaylistDetailFragment.this.performFetchComplete(this.$type, this.$mixMakerCreateRes);
                                                            return h0;
                                                        }
                                                    };
                                                    this.L$0 = null;
                                                    this.label = 1;
                                                    if(BuildersKt.withContext(i0, mixMakerPlaylistDetailFragment$onFetchStart$1$1$20, this) == a0) {
                                                        return a0;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 1: {
                                            MixMakerCreateRes mixMakerCreateRes1 = (MixMakerCreateRes)this.L$0;
                                            d5.n.D(object0);
                                            break;
                                        }
                                        default: {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                    }
                                    MixMakerPlaylistDetailFragment.this.setFetchStart(false);
                                    return H.a;
                                }
                            };
                            this.label = 1;
                            return SupervisorKt.supervisorScope(mixMakerPlaylistDetailFragment$onFetchStart$1$10, this) == a0 ? a0 : H.a;
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
            return true;
        }
        MixMakerCreateRes mixMakerCreateRes0 = this.fetchDetailCacheData();
        if(mixMakerCreateRes0 != null) {
            RESPONSE mixMakerCreateRes$RESPONSE0 = mixMakerCreateRes0.response;
            q.f(mixMakerCreateRes$RESPONSE0, "response");
            this.setTiaraBaseInfo(mixMakerCreateRes$RESPONSE0);
            String s1 = mixMakerCreateRes0.response.mainTitle;
            q.f(s1, "mainTitle");
            this.playlistTitle = s1;
            RESPONSE mixMakerCreateRes$RESPONSE1 = mixMakerCreateRes0.response;
            q.f(mixMakerCreateRes$RESPONSE1, "response");
            this.drawHeaderView(mixMakerCreateRes$RESPONSE1);
            this.performFetchComplete(i0, mixMakerCreateRes0);
        }
        this.setFetchStart(false);
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        String s = bundle0.getString("argSearchKeyword", "");
        q.f(s, "getString(...)");
        this.searchKeyword = s;
        this.navigateBackCount = bundle0.getInt("argNavigationBackCount", 1);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argSearchKeyword", this.searchKeyword);
        bundle0.putInt("argNavigationBackCount", this.navigateBackCount);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onStart() {
        super.onStart();
        if(!this.isFetchStart()) {
            Context context0 = this.getContext();
            if(!com.iloen.melon.responsecache.a.e(300000L, this.getCacheKey(), context0)) {
                this.updateHeaderView();
                this.setSelectAllWithToolbar(false);
            }
        }
        this.setFetchStart(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        m0 m00 = this.getBinding();
        this.bottomDivider = m00.d;
        m00.d.setVisibility(8);
        p p0 = new p(1);
        I i0 = new I(1);
        i0.c = new u(this, 2);
        p0.g(new m(2, false));
        p0.g(i0);
        this.titleItemBase = p0;
    }

    private static final void onViewCreated$lambda$3$lambda$2(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0, View view0) {
        mixMakerPlaylistDetailFragment0.showContextPopupDetail();
        mixMakerPlaylistDetailFragment0.moreClickLog();
    }

    private final void personalSettingClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s = "페이지이동";
            String s1 = "";
            if(this.getContext() == null) {
                s = "";
            }
            String s2 = "소개";
            f0.a = s;
            if(this.getContext() == null) {
                s2 = "";
            }
            f0.y = s2;
            if(this.getContext() != null) {
                s1 = "내취향설정";
            }
            f0.F = s1;
            f0.a().track();
        }
    }

    private final MixMakerCreateRes requestMixMakerPlaylist() {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        String s = this.searchKeyword;
        return this.isPersonalMode ? ((MixMakerCreateRes)RequestBuilder.newInstance(new MixMakerCreateReq(this.getContext(), s, "ON")).tag("MixMakerPlaylistDetailFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0)) : ((MixMakerCreateRes)RequestBuilder.newInstance(new MixMakerCreateReq(this.getContext(), s, "OFF")).tag("MixMakerPlaylistDetailFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0));
    }

    private final void setSongListHeader() {
        n0 n00 = this.getBottomButton();
        if(n00 != null) {
            this.updateSelectButton(this.mMarkedAll);
            u u0 = new u(this, 0);
            n00.f.setOnClickListener(u0);
        }
    }

    private static final void setSongListHeader$lambda$20$lambda$19(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0, View view0) {
        mixMakerPlaylistDetailFragment0.toggleSelectAll();
        mixMakerPlaylistDetailFragment0.allSelectClickLog();
        mixMakerPlaylistDetailFragment0.updateSelectButton(mixMakerPlaylistDetailFragment0.mMarkedAll);
    }

    private final void setTiaraBaseInfo(RESPONSE mixMakerCreateRes$RESPONSE0) {
        String s = "ForU";
        this.mMenuId = mixMakerCreateRes$RESPONSE0.menuId;
        String s1 = "";
        if(this.getContext() == null) {
            s = "";
        }
        String s2 = this.getContext() == null ? "" : "ForU_믹스메이커메인";
        String s3 = mixMakerCreateRes$RESPONSE0.menuId;
        if(s3 != null) {
            s1 = s3;
        }
        this.mMelonTiaraProperty = new p8.s(s, s2, s1, null);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }

    private final void showContextPopupDetail() {
        if(this.isAdded() && this.isPossiblePopupShow() && !TextUtils.isEmpty(this.playlistTitle) && !this.playSongList.isEmpty()) {
            this.setSelectAllWithToolbar(false);
            String s = this.playlistTitle;
            String s1 = this.getString(0x7F1300EC);  // string:app_name "Melon"
            q.f(s1, "getString(...)");
            d0 d00 = new d0(s, s1, this.mMenuId, this.coverBitmap);
            com.melon.ui.popup.b.o(this.getChildFragmentManager(), d00, new com.iloen.melon.fragments.detail.f(this, 2), 12);
        }
    }

    private static final H showContextPopupDetail$lambda$16(MixMakerPlaylistDetailFragment mixMakerPlaylistDetailFragment0, k2 k20) {
        q.g(k20, "moreListPopupOnEvent");
        if(k20 instanceof F1) {
            mixMakerPlaylistDetailFragment0.downloadAll();
            return H.a;
        }
        if(k20 instanceof V1) {
            mixMakerPlaylistDetailFragment0.showContextMenuAddTo();
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public boolean showSpaceViewBottomButtonParallax() {
        return true;
    }

    private final void showWhenSongListHeader(boolean z) {
        n0 n00 = this.getBottomButton();
        ViewUtils.showWhen((n00 == null ? null : n00.g), z);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songItemClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s4 = "선택";
            String s5 = "";
            if(this.getContext() == null) {
                s4 = "";
            }
            String s6 = "곡리스트";
            f0.a = s4;
            f0.d = ActionKind.ClickContent;
            if(this.getContext() == null) {
                s6 = "";
            }
            String s7 = "곡선택";
            f0.y = s6;
            if(this.getContext() == null) {
                s7 = "";
            }
            f0.F = s7;
            f0.c(v);
            f0.e = s1;
            if(this.getContext() != null) {
                s5 = "곡";
            }
            f0.f = s5;
            f0.g = s2;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songItemInAlbumClickLog(@NotNull String s, int v, @NotNull String s1, @NotNull String s2) {
        q.g(s, "setNum");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s3 = "선택";
            String s4 = "";
            if(this.getContext() == null) {
                s3 = "";
            }
            String s5 = "곡리스트";
            f0.a = s3;
            f0.d = ActionKind.ClickContent;
            if(this.getContext() == null) {
                s5 = "";
            }
            f0.y = s5;
            f0.D = s;
            f0.c(v);
            f0.e = s1;
            if(this.getContext() != null) {
                s4 = "곡";
            }
            f0.f = s4;
            f0.g = s2;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songMoreClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s4 = "페이지이동";
            String s5 = "";
            if(this.getContext() == null) {
                s4 = "";
            }
            String s6 = "곡리스트";
            f0.a = s4;
            f0.d = ActionKind.ClickContent;
            if(this.getContext() == null) {
                s6 = "";
            }
            String s7 = "곡더보기";
            f0.y = s6;
            if(this.getContext() == null) {
                s7 = "";
            }
            f0.F = s7;
            f0.c(v);
            f0.e = s1;
            if(this.getContext() != null) {
                s5 = "곡";
            }
            f0.f = s5;
            f0.g = s2;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songMoreInAlbumClickLog(@NotNull String s, int v, @NotNull String s1, @NotNull String s2) {
        q.g(s, "setNum");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s3 = "페이지이동";
            String s4 = "";
            if(this.getContext() == null) {
                s3 = "";
            }
            String s5 = "곡리스트";
            f0.a = s3;
            f0.d = ActionKind.ClickContent;
            if(this.getContext() == null) {
                s5 = "";
            }
            String s6 = "곡더보기";
            f0.y = s5;
            if(this.getContext() == null) {
                s6 = "";
            }
            f0.F = s6;
            f0.D = s;
            f0.c(v);
            f0.e = s1;
            if(this.getContext() != null) {
                s4 = "곡";
            }
            f0.f = s4;
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
            String s5 = "음악재생";
            String s6 = "";
            if(this.getContext() == null) {
                s5 = "";
            }
            String s7 = "곡리스트";
            f0.a = s5;
            f0.d = ActionKind.PlayMusic;
            if(this.getContext() == null) {
                s7 = "";
            }
            String s8 = "음악재생";
            f0.y = s7;
            if(this.getContext() == null) {
                s8 = "";
            }
            f0.F = s8;
            f0.c(v);
            f0.e = s1;
            if(this.getContext() != null) {
                s6 = "곡";
            }
            f0.f = s6;
            f0.g = s2;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songPlayInAlbumClickLog(@NotNull String s, int v, @NotNull String s1, @NotNull String s2) {
        q.g(s, "setNum");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            String s3 = "음악재생";
            String s4 = "";
            if(this.getContext() == null) {
                s3 = "";
            }
            String s5 = "곡리스트";
            f0.a = s3;
            f0.d = ActionKind.PlayMusic;
            if(this.getContext() == null) {
                s5 = "";
            }
            f0.y = s5;
            f0.D = s;
            f0.c(v);
            f0.e = s1;
            if(this.getContext() != null) {
                s4 = "곡";
            }
            f0.f = s4;
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
            String s4 = "페이지이동";
            String s5 = "";
            if(this.getContext() == null) {
                s4 = "";
            }
            String s6 = "곡리스트";
            f0.a = s4;
            f0.d = ActionKind.ClickContent;
            if(this.getContext() == null) {
                s6 = "";
            }
            String s7 = "앨범페이지이동";
            f0.y = s6;
            if(this.getContext() == null) {
                s7 = "";
            }
            f0.F = s7;
            f0.c(v);
            f0.e = s1;
            if(this.getContext() != null) {
                s5 = "앨범";
            }
            f0.f = s5;
            f0.g = s2;
            f0.a().track();
        }
    }

    private final void togglePersonalMode() {
        if(!this.isPersonalMode && !this.isLoginUser()) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            l0 l00 = this.getChildFragmentManager();
            if(l00 == null || Y.z(MelonAppBase.Companion) || l00.T() || l00.K || fragmentActivity0 == null) {
                return;
            }
            l00.C();
            if(com.melon.ui.popup.b.b(l00, "showNeedLoginOneBtnPopup", null, new hd.i(fragmentActivity0, 27), 4) != null) {
                return;
            }
            e3.h.t("안내", "로그인 후 이용해 주세요.", null, false, null, null, null, null, false, false, null, false, null, 0xFFFC).show(l00, "showNeedLoginOneBtnPopup");
            return;
        }
        if(this.isFetchStart()) {
            return;
        }
        this.personalSettingClickLog();
        this.setSelectAllWithToolbar(false);
        this.isPersonalMode = !this.isPersonalMode;
        this.onFetchStart(i.b, null, "");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentCountView(@Nullable InformCmtContsSummRes informCmtContsSummRes0) {
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentListView(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateHeaderView() {
        BuildersKt__Builders_commonKt.launch$default(this, SupervisorKt.SupervisorJob$default(null, 1, null), null, new n(null) {
            int label;

            {
                MixMakerPlaylistDetailFragment.this = mixMakerPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.updateHeaderView.1(MixMakerPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.updateHeaderView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        me.i i0 = Dispatchers.getMain().plus(MixMakerPlaylistDetailFragment.this.mainExceptionHandler);
                        com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.updateHeaderView.1.1 mixMakerPlaylistDetailFragment$updateHeaderView$1$10 = new n(null) {
                            int label;

                            {
                                MixMakerPlaylistDetailFragment.this = mixMakerPlaylistDetailFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.updateHeaderView.1.1(MixMakerPlaylistDetailFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment.updateHeaderView.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                MixMakerCreateRes mixMakerCreateRes0 = MixMakerPlaylistDetailFragment.this.fetchDetailCacheData();
                                if(mixMakerCreateRes0 != null) {
                                    RESPONSE mixMakerCreateRes$RESPONSE0 = mixMakerCreateRes0.response;
                                    q.f(mixMakerCreateRes$RESPONSE0, "response");
                                    MixMakerPlaylistDetailFragment.this.drawHeaderView(mixMakerCreateRes$RESPONSE0);
                                }
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return BuildersKt.withContext(i0, mixMakerPlaylistDetailFragment$updateHeaderView$1$10, this) == a0 ? a0 : H.a;
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
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateSelectAllButton(boolean z) {
        if(!this.isFragmentValid()) {
            return;
        }
        this.updateSelectButton(z);
    }

    private final void updateSelectButton(boolean z) {
        n0 n00 = this.getBottomButton();
        if(n00 != null) {
            CheckableTextView checkableTextView0 = n00.b;
            if(z) {
                checkableTextView0.setText(this.getString(0x7F1310D9));  // string:unselect_selection "선택해제"
                checkableTextView0.setChecked(true);
                return;
            }
            checkableTextView0.setText(this.getString(0x7F130914));  // string:select_all "전체선택"
            checkableTextView0.setChecked(false);
        }
    }
}

