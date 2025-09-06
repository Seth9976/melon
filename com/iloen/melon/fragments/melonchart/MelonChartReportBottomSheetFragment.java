package com.iloen.melon.fragments.melonchart;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.B;
import com.iloen.melon.adapters.common.e;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.ChartReportReq;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.FOOTBUTTON;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.LISTENERDATA;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.RANKCHART;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.SONGINFO;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.YESTERCHARTINFO;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response;
import com.iloen.melon.net.v6x.response.ChartReportRes;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.track.Event;
import d3.g;
import ie.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.a;
import q8.b;
import q8.c;
import q8.d;
import q8.f;
import v9.h;
import v9.i;
import v9.o;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\nR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment;", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;", "", "songId", "<init>", "(Ljava/lang/String;)V", "Landroid/content/DialogInterface;", "it", "Lie/H;", "initCloseButton", "(Landroid/content/DialogInterface;)V", "Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment;", "newFragment", "()Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment;", "", "getPeekHeight", "()I", "onDialogShow", "Ljava/lang/String;", "getSongId", "()Ljava/lang/String;", "Companion", "ChartReportFragment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartReportBottomSheetFragment extends MelonBottomSheetBaseFragment {
    @Metadata(d1 = {"\u0000\u00A8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\b*\u0002X[\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0004^_`aB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\b\u0010\u0006J\u000F\u0010\t\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001B\u0010 \u001A\u0006\u0012\u0002\b\u00030\u001F2\u0006\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b#\u0010$J-\u0010*\u001A\u00020\u00042\b\u0010&\u001A\u0004\u0018\u00010%2\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010)\u001A\u0004\u0018\u00010\u000FH\u0014\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010-\u001A\u00020\f2\u0006\u0010,\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b-\u0010.J\u0015\u00100\u001A\u00020\f2\u0006\u0010/\u001A\u00020\u000F\u00A2\u0006\u0004\b0\u00101J\u0017\u00102\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b2\u00103J\u0017\u00106\u001A\u00020\f2\u0006\u00105\u001A\u000204H\u0002\u00A2\u0006\u0004\b6\u00107J\u001F\u00109\u001A\u00020\u00042\u000E\u00105\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u000308H\u0002\u00A2\u0006\u0004\b9\u0010:J\u0019\u0010=\u001A\u00020\f2\b\u0010<\u001A\u0004\u0018\u00010;H\u0002\u00A2\u0006\u0004\b=\u0010>R\u0016\u0010?\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010@R\u0018\u0010C\u001A\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001A\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001A\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010GR\u0018\u0010I\u001A\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001A\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010JR\u0018\u0010L\u001A\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010GR\u0018\u0010M\u001A\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bM\u0010GR\u0018\u0010N\u001A\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010GR\u0018\u0010P\u001A\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bP\u0010QR\u001B\u0010W\u001A\u00020R8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bS\u0010T\u001A\u0004\bU\u0010VR\u0014\u0010Y\u001A\u00020X8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001A\u00020[8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\\\u0010]\u00A8\u0006b"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "shouldIgnoreForegroundEvent", "()Z", "shouldIgnoreSetOrientation", "ignoreUpdateVideoScreen", "shouldShowMiniPlayer", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "show", "showProgress", "(Z)V", "copy", "trackTiaraLog", "(Ljava/lang/String;)V", "initTopTitleView", "(Landroid/view/View;)V", "Lcom/iloen/melon/adapters/common/e;", "adapter", "setEmptyAndErrorView", "(Lcom/iloen/melon/adapters/common/e;)V", "Lcom/iloen/melon/adapters/common/y;", "canScrollToTop", "(Lcom/iloen/melon/adapters/common/y;)Z", "Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response;", "res", "setTopTitleView", "(Lcom/iloen/melon/net/v6x/response/ChartReportRes$Response;)V", "songId", "Ljava/lang/String;", "firstArtistId", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "topTitleMotionLayout", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroid/widget/TextView;", "tvRank", "Landroid/widget/TextView;", "tvRankChange", "ivRankChangeNone", "Landroid/view/View;", "songDetailLandingArea", "tvTitle", "tvArtist", "tvTime", "Landroid/widget/ImageView;", "ivThumb", "Landroid/widget/ImageView;", "", "animScroll$delegate", "Lie/j;", "getAnimScroll", "()F", "animScroll", "com/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$recyclerViewScrollListener$1", "recyclerViewScrollListener", "Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$recyclerViewScrollListener$1;", "com/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$actionListener$1;", "Companion", "Type", "ServerDataWrapper", "ChartReportAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ChartReportFragment extends MetaContentBaseFragment {
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ-\u0010\u0013\u001A\u00020\u00122\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001D\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\'\u0010!\u001A\u00020 2\u0006\u0010\u001F\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/melonchart/ChartReportActionListener;", "actionListener", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/melonchart/ChartReportActionListener;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/melonchart/ChartReportActionListener;", "ViewType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        static final class ChartReportAdapter extends p {
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter$ViewType;", "", "<init>", "()V", "UNKNOWN", "", "TOP_LISTENER", "LISTENER_DATA", "RANK_CHART", "YESTER_CHART_INFO", "FOOT_BUTTON", "LISTENER_CHART_LAND", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class ViewType {
                public static final int $stable = 0;
                public static final int FOOT_BUTTON = 5;
                @NotNull
                public static final ViewType INSTANCE = null;
                public static final int LISTENER_CHART_LAND = 6;
                public static final int LISTENER_DATA = 2;
                public static final int RANK_CHART = 3;
                public static final int TOP_LISTENER = 1;
                public static final int UNKNOWN = -1;
                public static final int YESTER_CHART_INFO = 4;

                static {
                    ViewType.INSTANCE = new ViewType();
                }
            }

            @NotNull
            private final ChartReportActionListener actionListener;

            public ChartReportAdapter(@NotNull Context context0, @Nullable List list0, @NotNull ChartReportActionListener chartReportActionListener0) {
                q.g(context0, "context");
                q.g(chartReportActionListener0, "actionListener");
                super(context0, list0);
                this.actionListener = chartReportActionListener0;
            }

            @Override  // com.iloen.melon.adapters.common.p
            public int getItemViewTypeImpl(int v, int v1) {
                ServerDataWrapper melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
                if("LISTENER_CHART".equals((melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 == null ? null : melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0.getSubType()))) {
                    return ScreenUtils.isPortrait(this.getContext()) ? 1 : 6;
                }
                return melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 == null ? -1 : melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0.getViewType();
            }

            @Override  // com.iloen.melon.adapters.common.p
            public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
                if(httpResponse0 instanceof ChartReportRes) {
                    Response chartReportRes$Response0 = ((ChartReportRes)httpResponse0).response;
                    if(chartReportRes$Response0 == null) {
                        return true;
                    }
                    ArrayList arrayList0 = new ArrayList();
                    this.setHasMore(false);
                    this.setMenuId(chartReportRes$Response0.menuId);
                    this.updateModifiedTime(s);
                    SONGINFO chartReportRes$Response$SONGINFO0 = chartReportRes$Response0.songInfo;
                    if(chartReportRes$Response$SONGINFO0 != null || chartReportRes$Response0.listenerChart != null) {
                        arrayList0.add(new ServerDataWrapper(1, "LISTENER_CHART", new ListenerChartData(chartReportRes$Response0.listenerChart, chartReportRes$Response$SONGINFO0)));
                    }
                    LISTENERDATA chartReportRes$Response$LISTENERDATA0 = chartReportRes$Response0.listenerData;
                    if(chartReportRes$Response$LISTENERDATA0 != null) {
                        q.f(chartReportRes$Response$LISTENERDATA0, "listenerData");
                        arrayList0.add(new ServerDataWrapper(2, "LISTENER_DATA", chartReportRes$Response$LISTENERDATA0));
                    }
                    RANKCHART chartReportRes$Response$RANKCHART0 = chartReportRes$Response0.rankChart;
                    if(chartReportRes$Response$RANKCHART0 != null) {
                        q.f(chartReportRes$Response$RANKCHART0, "rankChart");
                        arrayList0.add(new ServerDataWrapper(3, "RANK_CHART", chartReportRes$Response$RANKCHART0));
                    }
                    YESTERCHARTINFO chartReportRes$Response$YESTERCHARTINFO0 = chartReportRes$Response0.yesterChartInfo;
                    if(chartReportRes$Response$YESTERCHARTINFO0 != null) {
                        q.f(chartReportRes$Response$YESTERCHARTINFO0, "yesterChartInfo");
                        arrayList0.add(new ServerDataWrapper(4, "YESTER_CHART_INFO", chartReportRes$Response$YESTERCHARTINFO0));
                    }
                    FOOTBUTTON chartReportRes$Response$FOOTBUTTON0 = chartReportRes$Response0.footButton;
                    if(chartReportRes$Response$FOOTBUTTON0 != null) {
                        q.f(chartReportRes$Response$FOOTBUTTON0, "footButton");
                        arrayList0.add(new ServerDataWrapper(5, "FOOT_BUTTON", chartReportRes$Response$FOOTBUTTON0));
                    }
                    this.addAll(arrayList0);
                }
                return true;
            }

            @Override  // com.iloen.melon.adapters.common.p
            public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
                q.g(o00, "viewHolder");
                ServerDataWrapper melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
                RANKCHART chartReportRes$Response$RANKCHART0 = null;
                if(o00 instanceof RankChartHolder) {
                    Object object0 = melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 == null ? null : melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0.getData();
                    if(object0 instanceof RANKCHART) {
                        chartReportRes$Response$RANKCHART0 = (RANKCHART)object0;
                    }
                    ((RankChartHolder)o00).bind(chartReportRes$Response$RANKCHART0);
                    return;
                }
                if(o00 instanceof TopListenerHolder) {
                    Object object1 = melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 == null ? null : melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0.getData();
                    if(object1 instanceof ListenerChartData) {
                        chartReportRes$Response$RANKCHART0 = (ListenerChartData)object1;
                    }
                    ((TopListenerHolder)o00).bind(((ListenerChartData)chartReportRes$Response$RANKCHART0));
                    return;
                }
                if(o00 instanceof ListenerDataHolder) {
                    Object object2 = melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 == null ? null : melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0.getData();
                    if(object2 instanceof LISTENERDATA) {
                        chartReportRes$Response$RANKCHART0 = (LISTENERDATA)object2;
                    }
                    if(chartReportRes$Response$RANKCHART0 != null) {
                        ((ListenerDataHolder)o00).bind(((LISTENERDATA)chartReportRes$Response$RANKCHART0));
                    }
                }
                else if(o00 instanceof FootButtonHolder) {
                    Object object3 = melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 == null ? null : melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0.getData();
                    if(object3 instanceof FOOTBUTTON) {
                        chartReportRes$Response$RANKCHART0 = (FOOTBUTTON)object3;
                    }
                    if(chartReportRes$Response$RANKCHART0 != null) {
                        ((FootButtonHolder)o00).bind(((FOOTBUTTON)chartReportRes$Response$RANKCHART0));
                    }
                }
                else if(o00 instanceof YesterdayDataHolder) {
                    Object object4 = melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0 == null ? null : melonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper0.getData();
                    if(object4 instanceof YESTERCHARTINFO) {
                        chartReportRes$Response$RANKCHART0 = (YESTERCHARTINFO)object4;
                    }
                    if(chartReportRes$Response$RANKCHART0 != null) {
                        ((YesterdayDataHolder)o00).bind(((YESTERCHARTINFO)chartReportRes$Response$RANKCHART0));
                    }
                }
            }

            @Override  // com.iloen.melon.adapters.common.p
            @Nullable
            public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
                q.g(viewGroup0, "parent");
                switch(v) {
                    case 2: {
                        return ListenerDataHolder.Companion.newInstance(viewGroup0);
                    }
                    case 3: {
                        return RankChartHolder.Companion.newInstance(viewGroup0);
                    }
                    case 4: {
                        return YesterdayDataHolder.Companion.newInstance(viewGroup0);
                    }
                    case 5: {
                        return FootButtonHolder.Companion.newInstance(viewGroup0, this.actionListener);
                    }
                    case 1: 
                    case 6: {
                        return TopListenerHolder.Companion.newInstance(viewGroup0);
                    }
                    default: {
                        return null;
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment;", "songId", "", "TEXT_SIZE_10", "", "TEXT_SIZE_12", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final ChartReportFragment newInstance(@NotNull String s) {
                q.g(s, "songId");
                ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0 = new ChartReportFragment();
                Bundle bundle0 = new Bundle();
                bundle0.putString("argItemId", s);
                melonChartReportBottomSheetFragment$ChartReportFragment0.setArguments(bundle0);
                return melonChartReportBottomSheetFragment$ChartReportFragment0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$ServerDataWrapper;", "", "viewType", "", "subType", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "getViewType", "()I", "getSubType", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        static final class ServerDataWrapper {
            @NotNull
            private final Object data;
            @NotNull
            private final String subType;
            private final int viewType;

            public ServerDataWrapper(int v, @NotNull String s, @NotNull Object object0) {
                q.g(s, "subType");
                q.g(object0, "data");
                super();
                this.viewType = v;
                this.subType = s;
                this.data = object0;
            }

            @NotNull
            public final Object getData() {
                return this.data;
            }

            @NotNull
            public final String getSubType() {
                return this.subType;
            }

            public final int getViewType() {
                return this.viewType;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$ChartReportFragment$Type;", "", "<init>", "()V", "LISTENER_CHART", "", "LISTENER_DATA", "RANK_CHART", "YESTER_CHART_INFO", "FOOT_BUTTON", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Type {
            public static final int $stable = 0;
            @NotNull
            public static final String FOOT_BUTTON = "FOOT_BUTTON";
            @NotNull
            public static final Type INSTANCE = null;
            @NotNull
            public static final String LISTENER_CHART = "LISTENER_CHART";
            @NotNull
            public static final String LISTENER_DATA = "LISTENER_DATA";
            @NotNull
            public static final String RANK_CHART = "RANK_CHART";
            @NotNull
            public static final String YESTER_CHART_INFO = "YESTER_CHART_INFO";

            static {
                Type.INSTANCE = new Type();
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final Companion Companion = null;
        private static final float TEXT_SIZE_10 = 10.0f;
        private static final float TEXT_SIZE_12 = 12.0f;
        @NotNull
        private final com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.ChartReportFragment.actionListener.1 actionListener;
        @NotNull
        private final j animScroll$delegate;
        @NotNull
        private String firstArtistId;
        @Nullable
        private View ivRankChangeNone;
        @Nullable
        private ImageView ivThumb;
        @NotNull
        private final com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.ChartReportFragment.recyclerViewScrollListener.1 recyclerViewScrollListener;
        @Nullable
        private View songDetailLandingArea;
        @NotNull
        private String songId;
        @Nullable
        private MotionLayout topTitleMotionLayout;
        @Nullable
        private TextView tvArtist;
        @Nullable
        private TextView tvRank;
        @Nullable
        private TextView tvRankChange;
        @Nullable
        private TextView tvTime;
        @Nullable
        private TextView tvTitle;

        static {
            ChartReportFragment.Companion = new Companion(null);
            ChartReportFragment.$stable = 8;
        }

        public ChartReportFragment() {
            this.songId = "";
            this.firstArtistId = "";
            this.animScroll$delegate = g.Q(new x(this, 6));
            this.recyclerViewScrollListener = new A0() {
                @Override  // androidx.recyclerview.widget.A0
                public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                    q.g(recyclerView0, "recyclerView");
                    super.onScrolled(recyclerView0, v, v1);
                    MotionLayout motionLayout0 = ChartReportFragment.access$getTopTitleMotionLayout$p(ChartReportFragment.this);
                    if(motionLayout0 != null) {
                        float f = ((float)recyclerView0.computeVerticalScrollOffset()) / ChartReportFragment.access$getAnimScroll(ChartReportFragment.this);
                        if(f > 1.0f) {
                            f = 1.0f;
                        }
                        motionLayout0.setProgress(f);
                    }
                }
            };
            this.actionListener = new ChartReportActionListener() {
                @Override  // com.iloen.melon.fragments.melonchart.ChartReportActionListener
                public void loadNewSong(String s, boolean z) {
                    q.g(s, "newSongId");
                    j0 j00 = ChartReportFragment.this.getAdapter();
                    B b0 = j00 instanceof B ? ((B)j00) : null;
                    if(b0 != null) {
                        b0.clearCache(ChartReportFragment.this.getCacheKey());
                    }
                    ChartReportFragment.access$setSongId$p(ChartReportFragment.this, s);
                    ChartReportFragment.this.startFetch("newSong");
                    String s1 = ChartReportFragment.this.getString((z ? 0x7F130CF1 : 0x7F130CEF));  // string:tiara_chart_report_move_next_copy "다음곡리포트보기"
                    q.d(s1);
                    ChartReportFragment.this.trackTiaraLog(s1);
                }
            };
        }

        public static final float access$getAnimScroll(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.getAnimScroll();
        }

        public static final MotionLayout access$getTopTitleMotionLayout$p(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.topTitleMotionLayout;
        }

        public static final void access$setSongId$p(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, String s) {
            melonChartReportBottomSheetFragment$ChartReportFragment0.songId = s;
        }

        private static final float animScroll_delegate$lambda$7(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return (float)ScreenUtils.dipToPixel(melonChartReportBottomSheetFragment$ChartReportFragment0.getContext(), 200.0f);
        }

        private final boolean canScrollToTop(y y0) {
            return !y0.isEmpty() && this.getRecyclerView().computeVerticalScrollOffset() != 0;
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        @NotNull
        public j0 createRecyclerViewAdapter(@NotNull Context context0) {
            q.g(context0, "context");
            j0 j00 = new ChartReportAdapter(context0, null, this.actionListener);
            this.setEmptyAndErrorView(((e)j00));
            return j00;
        }

        public static boolean f0(View view0, MotionEvent motionEvent0) {
            return true;
        }

        public static void g0(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, View view0) {
            ChartReportFragment.initTopTitleView$lambda$2(melonChartReportBottomSheetFragment$ChartReportFragment0, view0);
        }

        private final float getAnimScroll() {
            return ((Number)this.animScroll$delegate.getValue()).floatValue();
        }

        @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
        @NotNull
        public String getCacheKey() {
            return l1.f(MelonContentUris.u0.buildUpon(), "songId", this.songId, "toString(...)");
        }

        // 检测为 Lambda 实现
        public static void h0(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, ChartReportAdapter melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0, String s, i i0, ChartReportRes chartReportRes0) [...]

        @Override  // com.iloen.melon.fragments.MelonBaseFragment
        public boolean ignoreUpdateVideoScreen() {
            return true;
        }

        private final void initTopTitleView(View view0) {
            view0.setOnTouchListener(new com.google.android.material.search.e(1));
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
            MelonAppBase.Companion.getClass();
            ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(t.a().getContext(), 36.0f), true);
            H h0 = new H(this, 0);
            View view1 = view0.findViewById(0x7F0A067D);  // id:iv_refresh_full
            if(view1 != null) {
                view1.setOnClickListener(h0);
            }
            View view2 = view0.findViewById(0x7F0A067E);  // id:iv_refresh_scroll
            if(view2 != null) {
                view2.setOnClickListener(h0);
            }
            ImageView imageView1 = this.ivThumb;
            if(imageView1 != null) {
                imageView1.setContentDescription(this.getString(0x7F130B3A));  // string:talkback_go_to_artist_channel_button "아티스트 채널 가기"
            }
            ImageView imageView2 = this.ivThumb;
            if(imageView2 != null) {
                imageView2.setOnClickListener(new H(this, 1));
            }
            View view3 = view0.findViewById(0x7F0A0AA8);  // id:song_detail_landing_area
            this.songDetailLandingArea = view3;
            if(view3 != null) {
                view3.setOnClickListener(new H(this, 2));
            }
        }

        private static final boolean initTopTitleView$lambda$1(View view0, MotionEvent motionEvent0) [...] // Inlined contents

        private static final void initTopTitleView$lambda$2(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, View view0) {
            j0 j00 = melonChartReportBottomSheetFragment$ChartReportFragment0.getAdapter();
            B b0 = j00 instanceof B ? ((B)j00) : null;
            if(b0 != null) {
                b0.clearCache(melonChartReportBottomSheetFragment$ChartReportFragment0.getCacheKey());
            }
            melonChartReportBottomSheetFragment$ChartReportFragment0.startFetch("refresh");
        }

        private static final void initTopTitleView$lambda$3(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, View view0) {
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(melonChartReportBottomSheetFragment$ChartReportFragment0);
            melonChartReportBottomSheetFragment$ChartReportFragment0.showArtistInfoPage(melonChartReportBottomSheetFragment$ChartReportFragment0.firstArtistId);
        }

        private static final void initTopTitleView$lambda$4(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, View view0) {
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(melonChartReportBottomSheetFragment$ChartReportFragment0);
            melonChartReportBottomSheetFragment$ChartReportFragment0.showSongInfoPage(melonChartReportBottomSheetFragment$ChartReportFragment0.songId);
        }

        public static void j0(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, View view0) {
            ChartReportFragment.initTopTitleView$lambda$3(melonChartReportBottomSheetFragment$ChartReportFragment0, view0);
        }

        public static void k0(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, View view0) {
            ChartReportFragment.initTopTitleView$lambda$4(melonChartReportBottomSheetFragment$ChartReportFragment0, view0);
        }

        public static void l0(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, ChartReportAdapter melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0, VolleyError volleyError0) {
            ChartReportFragment.onFetchStart$lambda$9(melonChartReportBottomSheetFragment$ChartReportFragment0, melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0, volleyError0);
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        @NotNull
        public RecyclerView onCreateRecyclerView() {
            View view0 = this.findViewById(0x7F0A09CE);  // id:recycler_bottom_sheet
            q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            ((RecyclerView)view0).setAdapter(this.mAdapter);
            ((RecyclerView)view0).setHasFixedSize(false);
            ((RecyclerView)view0).addOnScrollListener(this.recyclerViewScrollListener);
            ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(/*ERROR_MISSING_ARG_0/*) {
                private final Map childSizesMap;

                {
                    this.childSizesMap = new LinkedHashMap();
                }

                @Override  // androidx.recyclerview.widget.LinearLayoutManager
                public int computeVerticalScrollOffset(K0 k00) {
                    q.g(k00, "state");
                    if(this.getChildCount() == 0) {
                        return 0;
                    }
                    int v = this.findFirstVisibleItemPosition();
                    View view0 = this.findViewByPosition(v);
                    if(view0 == null) {
                        return 0;
                    }
                    int v1 = -((int)view0.getY());
                    for(int v2 = 0; v2 < v; ++v2) {
                        Integer integer0 = (Integer)this.childSizesMap.get(v2);
                        v1 += (integer0 == null ? 0 : ((int)integer0));
                    }
                    return v1;
                }

                @Override  // androidx.recyclerview.widget.LinearLayoutManager
                public void onLayoutCompleted(K0 k00) {
                    super.onLayoutCompleted(k00);
                    int v = this.getChildCount();
                    for(int v1 = 0; v1 < v; ++v1) {
                        View view0 = this.getChildAt(v1);
                        if(view0 != null) {
                            Integer integer0 = this.getPosition(view0);
                            Integer integer1 = view0.getHeight();
                            this.childSizesMap.put(integer0, integer1);
                        }
                    }
                }
            });
            return (RecyclerView)view0;
        }

        @Override  // androidx.fragment.app.I
        @Nullable
        public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
            q.g(layoutInflater0, "inflater");
            return layoutInflater0.inflate(0x7F0D029E, viewGroup0, false);  // layout:fragment_chart_report_bottomsheet
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.ChartReportFragment.ChartReportAdapter");
            RequestBuilder.newInstance(new ChartReportReq(this.getContext(), this.songId)).tag(this.getRequestTag()).listener((ChartReportRes chartReportRes0) -> ChartReportFragment.onFetchStart$lambda$8(this, ((ChartReportAdapter)j00), s, i0, chartReportRes0)).errorListener(new J(this, ((ChartReportAdapter)j00), 0)).request();
            return true;
        }

        private static final void onFetchStart$lambda$8(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, ChartReportAdapter melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0, String s, i i0, ChartReportRes chartReportRes0) {
            List list0;
            Response chartReportRes$Response0 = null;
            if(!melonChartReportBottomSheetFragment$ChartReportFragment0.prepareFetchComplete(chartReportRes0)) {
                melonChartReportBottomSheetFragment$ChartReportFragment0.setTopTitleView(null);
                melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0.clear();
                return;
            }
            if(q.b(s, "newSong") && melonChartReportBottomSheetFragment$ChartReportFragment0.canScrollToTop(melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0)) {
                melonChartReportBottomSheetFragment$ChartReportFragment0.mRecyclerView.smoothScrollToPosition(0);
            }
            if(chartReportRes0 == null) {
                list0 = null;
            }
            else {
                Response chartReportRes$Response1 = chartReportRes0.response;
                if(chartReportRes$Response1 == null) {
                    list0 = null;
                }
                else {
                    SONGINFO chartReportRes$Response$SONGINFO0 = chartReportRes$Response1.songInfo;
                    list0 = chartReportRes$Response$SONGINFO0 == null ? null : chartReportRes$Response$SONGINFO0.artistList;
                }
            }
            String s1 = ProtocolUtils.getFirstArtistId(list0);
            q.f(s1, "getFirstArtistId(...)");
            melonChartReportBottomSheetFragment$ChartReportFragment0.firstArtistId = s1;
            if(chartReportRes0 != null) {
                chartReportRes$Response0 = chartReportRes0.response;
            }
            melonChartReportBottomSheetFragment$ChartReportFragment0.setTopTitleView(chartReportRes$Response0);
            melonChartReportBottomSheetFragment$ChartReportFragment0.performFetchComplete(i0, chartReportRes0);
        }

        private static final void onFetchStart$lambda$9(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, ChartReportAdapter melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0, VolleyError volleyError0) {
            melonChartReportBottomSheetFragment$ChartReportFragment0.setTopTitleView(null);
            melonChartReportBottomSheetFragment$ChartReportFragment$ChartReportAdapter0.clear();
            melonChartReportBottomSheetFragment$ChartReportFragment0.performFetchError(volleyError0);
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public void onRestoreInstanceState(@NotNull Bundle bundle0) {
            q.g(bundle0, "inState");
            String s = bundle0.getString("argItemId");
            if(s == null) {
                s = "";
            }
            this.songId = s;
        }

        @Override  // com.iloen.melon.fragments.FetcherBaseFragment
        public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
            q.g(view0, "view");
            super.onViewCreated(view0, bundle0);
            this.topTitleMotionLayout = (MotionLayout)view0.findViewById(0x7F0A0823);  // id:motion_layout
            this.tvRank = (TextView)view0.findViewById(0x7F0A0CA3);  // id:tv_list_ranking
            this.tvRankChange = (TextView)view0.findViewById(0x7F0A0C9C);  // id:tv_list_change
            this.ivRankChangeNone = view0.findViewById(0x7F0A063C);  // id:iv_list_change_none
            this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.tvArtist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
            this.tvTime = (TextView)view0.findViewById(0x7F0A0D30);  // id:tv_time
            this.ivThumb = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
            MotionLayout motionLayout0 = this.topTitleMotionLayout;
            if(motionLayout0 != null) {
                this.initTopTitleView(motionLayout0);
            }
        }

        private final void setEmptyAndErrorView(e e0) {
            o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
            o0.c = -1;
            o0.e = -1;
            o0.h = -1;
            o0.i = -1;
            o0.b = 0x7F06048A;  // color:transparent
            e0.setErrorViewInfo(o0);
            v9.e e1 = new v9.e();  // 初始化器: Ljava/lang/Object;-><init>()V
            e1.e = -1;
            e1.g = -1;
            e1.i = -1;
            e1.k = -1;
            e1.l = -1;
            e1.d = 0x7F06048A;  // color:transparent
            e0.setEmptyViewInfo(e1);
        }

        private final void setTopTitleView(Response chartReportRes$Response0) {
            String s2;
            if(chartReportRes$Response0 == null) {
                MotionLayout motionLayout1 = this.topTitleMotionLayout;
                if(motionLayout1 != null) {
                    motionLayout1.setVisibility(8);
                }
            }
            else {
                MotionLayout motionLayout0 = this.topTitleMotionLayout;
                if(motionLayout0 != null) {
                    motionLayout0.setVisibility(0);
                }
                ImageView imageView0 = this.ivThumb;
                String s = null;
                if(imageView0 != null) {
                    Glide.with(imageView0).load(ProtocolUtils.getFirstArtistImg((chartReportRes$Response0.songInfo == null ? null : chartReportRes$Response0.songInfo.artistList))).apply(RequestOptions.circleCropTransform()).into(imageView0);
                }
                SONGINFO chartReportRes$Response$SONGINFO0 = chartReportRes$Response0.songInfo;
                String s1 = "";
                if(chartReportRes$Response$SONGINFO0 == null) {
                    s2 = "";
                }
                else {
                    s2 = chartReportRes$Response$SONGINFO0.songName;
                    if(s2 == null) {
                        s2 = "";
                    }
                }
                String s3 = ProtocolUtils.getArtistNames((chartReportRes$Response$SONGINFO0 == null ? null : chartReportRes$Response$SONGINFO0.artistList));
                if(s3 != null) {
                    s1 = s3;
                }
                TextView textView0 = this.tvTitle;
                if(textView0 != null) {
                    textView0.setText(s2);
                }
                TextView textView1 = this.tvArtist;
                if(textView1 != null) {
                    textView1.setText(s1);
                }
                View view0 = this.songDetailLandingArea;
                String s4 = this.getString(0x7F130AE3);  // string:talkback_chart_report_song "%1$s, %2$s, 곡정보페이지 이동"
                q.f(s4, "getString(...)");
                ViewUtils.setContentDescriptionWithButtonClassName(view0, String.format(s4, Arrays.copyOf(new Object[]{s2, s1}, 2)));
                TextView textView2 = this.tvRank;
                if(textView2 != null) {
                    textView2.setText((chartReportRes$Response0.songInfo == null ? null : chartReportRes$Response0.songInfo.currentRank));
                }
                String s5 = chartReportRes$Response0.songInfo == null ? null : chartReportRes$Response0.songInfo.rankType;
                if(s5 == null) {
                label_82:
                    TextView textView7 = this.tvRankChange;
                    if(textView7 != null) {
                        textView7.setVisibility(4);
                    }
                    View view5 = this.ivRankChangeNone;
                    if(view5 != null) {
                        view5.setVisibility(4);
                    }
                }
                else {
                    switch(s5) {
                        case "DOWN": {
                            View view3 = this.ivRankChangeNone;
                            if(view3 != null) {
                                view3.setVisibility(4);
                            }
                            TextView textView5 = this.tvRankChange;
                            if(textView5 != null) {
                                textView5.setVisibility(0);
                                textView5.setCompoundDrawablesWithIntrinsicBounds(0x7F0803D7, 0, 0, 0);  // drawable:ic_common_arrow_down
                                textView5.setTextColor(ColorUtils.getColor(textView5.getContext(), 0x7F060046));  // color:blue400s_support_high_contrast
                                SONGINFO chartReportRes$Response$SONGINFO2 = chartReportRes$Response0.songInfo;
                                if(chartReportRes$Response$SONGINFO2 != null) {
                                    s = chartReportRes$Response$SONGINFO2.rankGap;
                                }
                                textView5.setText(s);
                                textView5.setTextSize(1, 12.0f);
                            }
                            break;
                        }
                        case "NEW": {
                            View view2 = this.ivRankChangeNone;
                            if(view2 != null) {
                                view2.setVisibility(4);
                            }
                            TextView textView4 = this.tvRankChange;
                            if(textView4 != null) {
                                textView4.setVisibility(0);
                                textView4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                                textView4.setTextColor(ColorUtils.getColor(textView4.getContext(), 0x7F060459));  // color:rank_new_color
                                textView4.setText("NEW");
                                textView4.setTextSize(1, 10.0f);
                            }
                            break;
                        }
                        case "NONE": {
                            TextView textView6 = this.tvRankChange;
                            if(textView6 != null) {
                                textView6.setVisibility(4);
                            }
                            View view4 = this.ivRankChangeNone;
                            if(view4 != null) {
                                view4.setVisibility(0);
                            }
                            break;
                        }
                        case "UP": {
                            View view1 = this.ivRankChangeNone;
                            if(view1 != null) {
                                view1.setVisibility(4);
                            }
                            TextView textView3 = this.tvRankChange;
                            if(textView3 != null) {
                                textView3.setVisibility(0);
                                textView3.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DC, 0, 0, 0);  // drawable:ic_common_arrow_up
                                textView3.setTextColor(ColorUtils.getColor(textView3.getContext(), 0x7F06045A));  // color:rank_up_color
                                SONGINFO chartReportRes$Response$SONGINFO1 = chartReportRes$Response0.songInfo;
                                if(chartReportRes$Response$SONGINFO1 != null) {
                                    s = chartReportRes$Response$SONGINFO1.rankGap;
                                }
                                textView3.setText(s);
                                textView3.setTextSize(1, 12.0f);
                            }
                            break;
                        }
                        default: {
                            goto label_82;
                        }
                    }
                }
                TextView textView8 = this.tvTime;
                if(textView8 != null) {
                    textView8.setText(chartReportRes$Response0.recentTime);
                }
            }
        }

        @Override  // com.iloen.melon.fragments.MelonBaseFragment
        public boolean shouldIgnoreForegroundEvent() {
            return true;
        }

        @Override  // com.iloen.melon.fragments.MelonBaseFragment
        public boolean shouldIgnoreSetOrientation() {
            return true;
        }

        @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
        public boolean shouldShowMiniPlayer() {
            return false;
        }

        @Override  // com.iloen.melon.fragments.MelonBaseFragment
        public void showProgress(boolean z) {
            ViewUtils.showWhen(this.findViewById(0x7F0A097E), z);  // id:progress
        }

        public final void trackTiaraLog(@NotNull String s) {
            q.g(s, "copy");
            j0 j00 = this.getAdapter();
            String s1 = null;
            p p0 = j00 instanceof p ? ((p)j00) : null;
            if(p0 != null) {
                s1 = p0.getMenuId();
            }
            if(s1 == null) {
                s1 = "";
            }
            d d0 = new d();  // 初始化器: LQb/h;-><init>()V
            ChartReportFragment.trackTiaraLog$lambda$28(s1, this, s, d0);
            ((Event)d0.p()).track();
        }

        private static final ie.H trackTiaraLog$lambda$28(String s, ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, String s1, d d0) {
            q.g(d0, "$this$tiaraEventLogBuilder");
            c c0 = new c();
            ChartReportFragment.trackTiaraLog$lambda$28$lambda$15(s, c0);
            ((LinkedHashMap)d0.g).putAll(c0.a);
            ChartReportFragment.trackTiaraLog$lambda$28$lambda$17(melonChartReportBottomSheetFragment$ChartReportFragment0, ((q8.h)d0.b));
            b b0 = (b)d0.c;
            if(b0 == null) {
                b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                ChartReportFragment.trackTiaraLog$lambda$28$lambda$20(melonChartReportBottomSheetFragment$ChartReportFragment0, b1);
                d0.c = b1;
            }
            else {
                ChartReportFragment.trackTiaraLog$lambda$28$lambda$20(melonChartReportBottomSheetFragment$ChartReportFragment0, b0);
            }
            a a0 = (a)d0.d;
            if(a0 == null) {
                a a1 = new a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                ChartReportFragment.trackTiaraLog$lambda$28$lambda$23(melonChartReportBottomSheetFragment$ChartReportFragment0, s1, a1);
                d0.d = a1;
            }
            else {
                ChartReportFragment.trackTiaraLog$lambda$28$lambda$23(melonChartReportBottomSheetFragment$ChartReportFragment0, s1, a0);
            }
            f f0 = (f)d0.e;
            if(f0 != null) {
                ChartReportFragment.trackTiaraLog$lambda$28$lambda$27(melonChartReportBottomSheetFragment$ChartReportFragment0, f0);
                return ie.H.a;
            }
            f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
            ChartReportFragment.trackTiaraLog$lambda$28$lambda$27(melonChartReportBottomSheetFragment$ChartReportFragment0, f1);
            d0.e = f1;
            return ie.H.a;
        }

        private static final ie.H trackTiaraLog$lambda$28$lambda$15(String s, c c0) {
            q.g(c0, "$this$customProps");
            c0.a.put("menuid", s);
            return ie.H.a;
        }

        private static final String trackTiaraLog$lambda$28$lambda$15$lambda$14(String s) [...] // Inlined contents

        private static final ie.H trackTiaraLog$lambda$28$lambda$17(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, q8.h h0) {
            q.g(h0, "$this$track");
            String s = ChartReportFragment.trackTiaraLog$lambda$28$lambda$17$lambda$16(melonChartReportBottomSheetFragment$ChartReportFragment0);
            if(s == null) {
                s = "";
            }
            h0.a = s;
            return ie.H.a;
        }

        private static final String trackTiaraLog$lambda$28$lambda$17$lambda$16(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        }

        private static final ie.H trackTiaraLog$lambda$28$lambda$20(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, b b0) {
            q.g(b0, "$this$common");
            b0.a = ChartReportFragment.trackTiaraLog$lambda$28$lambda$20$lambda$18(melonChartReportBottomSheetFragment$ChartReportFragment0);
            b0.b = ChartReportFragment.trackTiaraLog$lambda$28$lambda$20$lambda$19(melonChartReportBottomSheetFragment$ChartReportFragment0);
            return ie.H.a;
        }

        private static final String trackTiaraLog$lambda$28$lambda$20$lambda$18(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.getString(0x7F130F24);  // string:tiara_music_layer1_melonchart "멜론차트"
        }

        private static final String trackTiaraLog$lambda$28$lambda$20$lambda$19(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.getString(0x7F130CF2);  // string:tiara_chart_report_page "멜론차트_TOP100차트리포트"
        }

        private static final ie.H trackTiaraLog$lambda$28$lambda$23(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, String s, a a0) {
            q.g(a0, "$this$click");
            a0.a = ChartReportFragment.trackTiaraLog$lambda$28$lambda$23$lambda$21(melonChartReportBottomSheetFragment$ChartReportFragment0);
            a0.g = s;
            return ie.H.a;
        }

        private static final String trackTiaraLog$lambda$28$lambda$23$lambda$21(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.getString(0x7F130CF0);  // string:tiara_chart_report_move_layout1 "리포트이동"
        }

        private static final String trackTiaraLog$lambda$28$lambda$23$lambda$22(String s) [...] // Inlined contents

        private static final ie.H trackTiaraLog$lambda$28$lambda$27(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0, f f0) {
            q.g(f0, "$this$eventMeta");
            f0.a = ChartReportFragment.trackTiaraLog$lambda$28$lambda$27$lambda$24(melonChartReportBottomSheetFragment$ChartReportFragment0);
            f0.b = ChartReportFragment.trackTiaraLog$lambda$28$lambda$27$lambda$25(melonChartReportBottomSheetFragment$ChartReportFragment0);
            f0.c = ChartReportFragment.trackTiaraLog$lambda$28$lambda$27$lambda$26(melonChartReportBottomSheetFragment$ChartReportFragment0);
            return ie.H.a;
        }

        private static final String trackTiaraLog$lambda$28$lambda$27$lambda$24(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.songId;
        }

        private static final String trackTiaraLog$lambda$28$lambda$27$lambda$25(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
        }

        // 去混淆评级： 低(20)
        private static final String trackTiaraLog$lambda$28$lambda$27$lambda$26(ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0) {
            return melonChartReportBottomSheetFragment$ChartReportFragment0.tvTitle == null ? "null" : String.valueOf(melonChartReportBottomSheetFragment$ChartReportFragment0.tvTitle.getText());
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartReportBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "FETCH_REASON_NEW_SONG", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.Companion {
        private com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.Companion() {
        }

        public com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.Companion Companion = null;
    @NotNull
    private static final String FETCH_REASON_NEW_SONG = "newSong";
    @NotNull
    public static final String TAG = "MelonChartReportBottomSheetFragment";
    @NotNull
    private final String songId;

    static {
        MelonChartReportBottomSheetFragment.Companion = new com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.Companion(null);
        MelonChartReportBottomSheetFragment.$stable = 8;
    }

    public MelonChartReportBottomSheetFragment(@NotNull String s) {
        q.g(s, "songId");
        super();
        this.songId = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public int getPeekHeight() {
        return (int)(((double)ScreenUtils.getScreenHeight(this.getContext())) * 0.8);
    }

    @NotNull
    public final String getSongId() {
        return this.songId;
    }

    private final void initCloseButton(DialogInterface dialogInterface0) {
        FrameLayout frameLayout0 = null;
        BottomSheetDialog bottomSheetDialog0 = dialogInterface0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialogInterface0) : null;
        if(bottomSheetDialog0 != null) {
            frameLayout0 = (FrameLayout)bottomSheetDialog0.findViewById(0x7F0A031A);  // id:container
        }
        if(frameLayout0 != null && this.getContext() != null) {
            this.getLayoutInflater().inflate(0x7F0D005F, frameLayout0);  // layout:bottomsheet_fragment_close_button
            View view0 = frameLayout0.findViewById(0x7F0A02CA);  // id:close_btn
            if(view0 != null) {
                view0.setOnClickListener(new com.iloen.melon.fragments.melonchart.j(this, 3));
            }
        }
    }

    private static final void initCloseButton$lambda$1$lambda$0(MelonChartReportBottomSheetFragment melonChartReportBottomSheetFragment0, View view0) {
        I i0 = melonChartReportBottomSheetFragment0.getChildFragmentManager().D(0x7F0A04DD);  // id:fragment_container
        ChartReportFragment melonChartReportBottomSheetFragment$ChartReportFragment0 = i0 instanceof ChartReportFragment ? ((ChartReportFragment)i0) : null;
        if(melonChartReportBottomSheetFragment$ChartReportFragment0 != null) {
            String s = melonChartReportBottomSheetFragment0.getString(0x7F130D12);  // string:tiara_click_copy_close "닫기"
            q.f(s, "getString(...)");
            melonChartReportBottomSheetFragment$ChartReportFragment0.trackTiaraLog(s);
        }
        melonChartReportBottomSheetFragment0.dismiss();
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public I newFragment() {
        return this.newFragment();
    }

    @NotNull
    public ChartReportFragment newFragment() {
        return ChartReportFragment.Companion.newInstance(this.songId);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public void onDialogShow(@NotNull DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "it");
        super.onDialogShow(dialogInterface0);
        this.initCloseButton(dialogInterface0);
        BottomSheetBehavior bottomSheetBehavior0 = this.getBehavior();
        if(bottomSheetBehavior0 != null) {
            bottomSheetBehavior0.f0 = true;
        }
    }
}

