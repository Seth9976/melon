package com.iloen.melon.fragments.melontv.program;

import Cb.k;
import De.I;
import F8.m;
import F8.p;
import J8.u3;
import J8.v3;
import Tf.o;
import U4.x;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.iloen.melon.activity.ProgramSelectActivity;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.adapters.common.b;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.AppBarStateChangeListener.State;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.AppBarStateChangeListener;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;
import com.iloen.melon.net.v6x.request.ProgramHomeReq;
import com.iloen.melon.net.v6x.request.TvProgramBannerReq;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.BUTTONINFO;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.MVINFO.MVLIST;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.NEWMVINFO;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.PROGINFO;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ProgramHomeRes;
import com.iloen.melon.net.v6x.response.TvProgramBannerRes.Response.Banner;
import com.iloen.melon.net.v6x.response.TvProgramBannerRes.Response;
import com.iloen.melon.net.v6x.response.TvProgramBannerRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.SharableTvProgram;
import com.iloen.melon.sns.model.ShareLinkData;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TalkbackUtilKt;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.i;

@Metadata(d1 = {"\u0000\u00D6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u008D\u00012\u00020\u0001:\u0006\u008E\u0001\u008F\u0001\u008D\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0019J\u000F\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001A\u0004\u0018\u00010$H\u0014\u00A2\u0006\u0004\b%\u0010&J-\u0010-\u001A\u00020,2\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010*\u001A\u0004\u0018\u00010)2\b\u0010+\u001A\u0004\u0018\u00010\u0014H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0017\u00101\u001A\u00020\u00112\u0006\u00100\u001A\u00020/H\u0016\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b3\u0010\u0003J\u000F\u00104\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b4\u0010\u0003J\u000F\u00105\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b5\u0010\u0003J#\u00109\u001A\u00020\u00112\u0006\u00106\u001A\u00020,2\n\b\u0002\u00108\u001A\u0004\u0018\u000107H\u0002\u00A2\u0006\u0004\b9\u0010:R\"\u0010;\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b=\u0010\u0016\"\u0004\b>\u0010?R\"\u0010@\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b@\u0010<\u001A\u0004\bA\u0010\u0016\"\u0004\bB\u0010?R$\u0010D\u001A\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bD\u0010E\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001A\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bK\u0010L\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001A\u00020,8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bQ\u0010R\u001A\u0004\bQ\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001A\u00020V8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bW\u0010X\u001A\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001A\u00020]8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b^\u0010_\u001A\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001A\u00020d8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\be\u0010f\u001A\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010k\u001A\u00020\n8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bk\u0010l\u001A\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001A\u00020q8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\br\u0010s\u001A\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0017\u0010y\u001A\u00020x8\u0006\u00A2\u0006\f\n\u0004\by\u0010z\u001A\u0004\b{\u0010|R\u0017\u0010}\u001A\u00020x8\u0006\u00A2\u0006\f\n\u0004\b}\u0010z\u001A\u0004\b~\u0010|R\u0017\u0010\u007F\u001A\u0002078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u007F\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001A\u00030\u0081\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R)\u0010\u0087\u0001\u001A\u0014\u0012\u000F\u0012\r \u0086\u0001*\u0005\u0018\u00010\u0085\u00010\u0085\u00010\u0084\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008C\u0001\u001A\u00030\u0089\u00018BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u008A\u0001\u0010\u008B\u0001\u00A8\u0006\u0090\u0001"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "getCacheKey", "()Ljava/lang/String;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "setNetworkHeadView", "initHeaderContainer", "requestLikedAction", "isLiked", "", "count", "updateLikedView", "(ZLjava/lang/Integer;)V", "programSeq", "Ljava/lang/String;", "getProgramSeq", "setProgramSeq", "(Ljava/lang/String;)V", "programTitle", "getProgramTitle", "setProgramTitle", "Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes;", "bannerRes", "Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes;", "getBannerRes", "()Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes;", "setBannerRes", "(Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes;)V", "Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PROGINFO;", "programRes", "Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PROGINFO;", "getProgramRes", "()Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PROGINFO;", "setProgramRes", "(Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$PROGINFO;)V", "isLikedMark", "Z", "()Z", "setLikedMark", "(Z)V", "Landroid/widget/FrameLayout;", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "Landroid/widget/ImageView;", "headerLikedIcon", "Landroid/widget/ImageView;", "getHeaderLikedIcon", "()Landroid/widget/ImageView;", "setHeaderLikedIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "headerLikedCount", "Landroid/widget/TextView;", "getHeaderLikedCount", "()Landroid/widget/TextView;", "setHeaderLikedCount", "(Landroid/widget/TextView;)V", "likeBtn", "Landroid/view/View;", "getLikeBtn", "()Landroid/view/View;", "setLikeBtn", "(Landroid/view/View;)V", "Lp8/s;", "tiaraBase", "Lp8/s;", "getTiaraBase", "()Lp8/s;", "setTiaraBase", "(Lp8/s;)V", "LF8/o;", "titlebarCollapeStyle", "LF8/o;", "getTitlebarCollapeStyle", "()LF8/o;", "titlebarExpandStyle", "getTitlebarExpandStyle", "prevOrientation", "I", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Le/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "activityResult", "Le/b;", "Lp8/f;", "getTiaraBuilder", "()Lp8/f;", "tiaraBuilder", "Companion", "TvProgramHomeAdapter", "TvProgramItemClickListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TvProgramHomeFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PROGRAM_SEQ", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_GO_ALBUM_DETAIL", "TALKBACK_ACTION_PLAY_ALBUM", "newInstance", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment;", "programSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TvProgramHomeFragment newInstance(@Nullable String s) {
            TvProgramHomeFragment tvProgramHomeFragment0 = new TvProgramHomeFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argProgramSeq", s);
            tvProgramHomeFragment0.setArguments(bundle0);
            return tvProgramHomeFragment0;
        }
    }

    @Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\f*\u0001@\b\u0082\u0004\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001:\bCDEFGHIJB%\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0014\u0010\u0006\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u0018\u00010\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001A\u00020\t2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001A\u00020\u000F2\b\u0010\u0013\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001B\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0013\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\r2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ!\u0010#\u001A\u0004\u0018\u00010\"2\u0006\u0010!\u001A\u00020 2\u0006\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b#\u0010$J)\u0010)\u001A\u00020(2\b\u0010%\u001A\u0004\u0018\u00010\"2\u0006\u0010&\u001A\u00020\t2\u0006\u0010\'\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b)\u0010*J-\u0010.\u001A\u00020\r2\u0016\u0010\u0006\u001A\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-2\u0006\u0010\u001B\u001A\u00020\t\u00A2\u0006\u0004\b.\u0010/R\u0014\u00100\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00104\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b4\u00101R\u0014\u00105\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b5\u00101R\u0014\u00106\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b6\u00101R\u0014\u00107\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b7\u00101R\u0014\u00108\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b8\u00101R\u0014\u00109\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b9\u00101R\u0014\u0010:\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b:\u00101R\u0014\u0010;\u001A\u00020\t8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b;\u00101R\u0014\u0010<\u001A\u00020\r8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001A\u00020\r8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001A\u00020\r8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010A\u001A\u00020@8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bA\u0010B\u00A8\u0006K"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;", "Lcom/iloen/melon/adapters/common/b;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment;Landroid/content/Context;Ljava/util/List;)V", "", "viewType", "", "data", "", "fromHeader", "", "isShowAll", "makeRowData", "(ILjava/lang/Object;Ljava/lang/String;Z)Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "any", "isDetailSongItem", "(Ljava/lang/Object;)Z", "Lcom/melon/net/res/common/SongInfoBase;", "getDetailSongItem", "(Ljava/lang/Object;)Lcom/melon/net/res/common/SongInfoBase;", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/O0;", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/MvInfoBase;", "Lkotlin/collections/ArrayList;", "mergeMetaString", "(Ljava/util/ArrayList;I)Ljava/lang/String;", "VIEW_TYPE_ITEM_HEADER", "I", "VIEW_TYPE_BANNER", "VIEW_TYPE_NEW_VIDEO", "VIEW_TYPE_POPULAR_VIDEO", "VIEW_TYPE_RELATED_VIDEO", "VIEW_TYPE_RELATED_SONG", "VIEW_TYPE_RELATED_ALBUM", "VIEW_TYPE_RELATED_PLAYLIST", "VIEW_TYPE_SHOW_ALL", "VIEW_TYPE_NOTICE", "VIEW_TYPE_EMPTY", "HEADER_TYPE_RELATED_VIDEO", "Ljava/lang/String;", "HEADER_TYPE_RELATED_SONG", "HEADER_TYPE_RELATED_ALBUM", "com/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$itemClickListener$1", "itemClickListener", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$itemClickListener$1;", "ItemHeaderHolder", "ItemNewVideoHolder", "ItemRelatedVideoHolder", "ItemRelatedSongHolder", "ItemRelatedAlbumHolder", "ItemShowAllHolder", "NoticeViewHolder", "EmptyViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TvProgramHomeAdapter extends b {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/u3;", "binding", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;LJ8/u3;)V", "LJ8/u3;", "getBinding", "()LJ8/u3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class EmptyViewHolder extends O0 {
            @NotNull
            private final u3 binding;

            public EmptyViewHolder(@NotNull u3 u30) {
                q.g(u30, "binding");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(u30.a);
                this.binding = u30;
            }

            @NotNull
            public final u3 getBinding() {
                return this.binding;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\f\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$ItemHeaderHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "showAll", "Landroid/view/View;", "getShowAll", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemHeaderHolder extends O0 {
            private final View showAll;
            private final TextView title;

            public ItemHeaderHolder(@NotNull View view0) {
                q.g(view0, "view");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(view0);
                this.title = (TextView)view0.findViewById(0x7F0A0B8D);  // id:title
                this.showAll = view0.findViewById(0x7F0A0DBB);  // id:view_all
            }

            public final View getShowAll() {
                return this.showAll;
            }

            public final TextView getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$ItemNewVideoHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "playNewVideo", "Landroid/widget/TextView;", "getPlayNewVideo", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemNewVideoHolder extends O0 {
            private final TextView playNewVideo;

            public ItemNewVideoHolder(@NotNull View view0) {
                q.g(view0, "view");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(view0);
                this.playNewVideo = (TextView)view0.findViewById(0x7F0A091F);  // id:play_new_video
            }

            public final TextView getPlayNewVideo() {
                return this.playNewVideo;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0011\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010R\u001F\u0010\u0013\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000E\u001A\u0004\b\u0014\u0010\u0010R\u001F\u0010\u0015\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$ItemRelatedAlbumHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "thumbnail", "Landroid/widget/ImageView;", "getThumbnail", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "artist", "getArtist", "date", "getDate", "btnPlayIv", "Landroid/view/View;", "getBtnPlayIv", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemRelatedAlbumHolder extends O0 {
            private final TextView artist;
            private final View btnPlayIv;
            private final TextView date;
            private final ImageView thumbnail;
            private final TextView title;

            public ItemRelatedAlbumHolder(@NotNull View view0) {
                q.g(view0, "view");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(view0);
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                this.title = (TextView)view0.findViewById(0x7F0A0B8D);  // id:title
                this.artist = (TextView)view0.findViewById(0x7F0A00B8);  // id:artist_name
                this.date = (TextView)view0.findViewById(0x7F0A037A);  // id:date
                this.btnPlayIv = this.itemView.findViewById(0x7F0A091D);  // id:play_button
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = tvProgramHomeFragment$TvProgramHomeAdapter0.getContext().getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
            }

            public final TextView getArtist() {
                return this.artist;
            }

            public final View getBtnPlayIv() {
                return this.btnPlayIv;
            }

            public final TextView getDate() {
                return this.date;
            }

            public final ImageView getThumbnail() {
                return this.thumbnail;
            }

            public final TextView getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0011\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010R\u001F\u0010\u0013\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001A\u0004\b\u0014\u0010\u000BR\u001F\u0010\u0015\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u001F\u0010\u0019\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001A\u0004\b\u001A\u0010\u0018¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$ItemRelatedSongHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "thumbnail", "Landroid/widget/ImageView;", "getThumbnail", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "artist", "getArtist", "grade19", "getGrade19", "play", "Landroid/view/View;", "getPlay", "()Landroid/view/View;", "info", "getInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemRelatedSongHolder extends O0 {
            private final TextView artist;
            private final ImageView grade19;
            private final View info;
            private final View play;
            private final ImageView thumbnail;
            private final TextView title;

            public ItemRelatedSongHolder(@NotNull View view0) {
                q.g(view0, "view");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(view0);
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                this.title = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.artist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
                this.grade19 = (ImageView)view0.findViewById(0x7F0A063B);  // id:iv_list_19
                this.play = view0.findViewById(0x7F0A0182);  // id:btn_play
                this.info = view0.findViewById(0x7F0A0169);  // id:btn_info
            }

            public final TextView getArtist() {
                return this.artist;
            }

            public final ImageView getGrade19() {
                return this.grade19;
            }

            public final View getInfo() {
                return this.info;
            }

            public final View getPlay() {
                return this.play;
            }

            public final ImageView getThumbnail() {
                return this.thumbnail;
            }

            public final TextView getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\f\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001A\u0004\b\r\u0010\u000BR\u001F\u0010\u000F\u001A\n \u0007*\u0004\u0018\u00010\u000E0\u000E8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u001F\u0010\u0013\u001A\n \u0007*\u0004\u0018\u00010\u000E0\u000E8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001A\u0004\b\u0014\u0010\u0012R\u001F\u0010\u0015\u001A\n \u0007*\u0004\u0018\u00010\u000E0\u000E8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001A\u0004\b\u0016\u0010\u0012R\u001F\u0010\u0017\u001A\n \u0007*\u0004\u0018\u00010\u000E0\u000E8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001A\u0004\b\u0018\u0010\u0012R\u001F\u0010\u0019\u001A\n \u0007*\u0004\u0018\u00010\u000E0\u000E8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001A\u0004\b\u001A\u0010\u0012R\u001F\u0010\u001B\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$ItemRelatedVideoHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "thumbnail", "Landroid/widget/ImageView;", "getThumbnail", "()Landroid/widget/ImageView;", "grade19", "getGrade19", "Landroid/widget/TextView;", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "date", "getDate", "artist", "getArtist", "round", "getRound", "playtime", "getPlaytime", "roundDot", "Landroid/view/View;", "getRoundDot", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemRelatedVideoHolder extends O0 {
            private final TextView artist;
            private final TextView date;
            private final TextView desc;
            private final ImageView grade19;
            private final TextView playtime;
            private final TextView round;
            private final View roundDot;
            private final ImageView thumbnail;

            public ItemRelatedVideoHolder(@NotNull View view0) {
                q.g(view0, "view");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(view0);
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                this.grade19 = (ImageView)view0.findViewById(0x7F0A0633);  // id:iv_grade
                this.desc = (TextView)view0.findViewById(0x7F0A0890);  // id:mv_title
                this.date = (TextView)view0.findViewById(0x7F0A037E);  // id:date_tv
                this.artist = (TextView)view0.findViewById(0x7F0A00C2);  // id:artist_tv
                this.round = (TextView)view0.findViewById(0x7F0A0A13);  // id:round_text
                this.playtime = (TextView)view0.findViewById(0x7F0A0CE5);  // id:tv_playtime
                this.roundDot = this.itemView.findViewById(0x7F0A03E1);  // id:dot
            }

            public final TextView getArtist() {
                return this.artist;
            }

            public final TextView getDate() {
                return this.date;
            }

            public final TextView getDesc() {
                return this.desc;
            }

            public final ImageView getGrade19() {
                return this.grade19;
            }

            public final TextView getPlaytime() {
                return this.playtime;
            }

            public final TextView getRound() {
                return this.round;
            }

            public final View getRoundDot() {
                return this.roundDot;
            }

            public final ImageView getThumbnail() {
                return this.thumbnail;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$ItemShowAllHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "showAll", "Landroid/widget/TextView;", "getShowAll", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemShowAllHolder extends O0 {
            private final TextView showAll;

            public ItemShowAllHolder(@NotNull View view0) {
                q.g(view0, "view");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(view0);
                this.showAll = (TextView)view0.findViewById(0x7F0A0A8B);  // id:show_all_video
            }

            public final TextView getShowAll() {
                return this.showAll;
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u000E\u0010\rR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001A\u00020\u00128\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001A\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001E\u001A\u00020\u001D8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u001A\u0010\"\u001A\u00020\u001D8\u0006X\u0086D¢\u0006\f\n\u0004\b\"\u0010\u001F\u001A\u0004\b#\u0010!¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/v3;", "binding", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramHomeAdapter;LJ8/v3;)V", "", "desc", "setExpandedText", "(Ljava/lang/String;)Ljava/lang/String;", "text", "Lie/H;", "clickTextViewExpand", "(Ljava/lang/String;)V", "setText", "LJ8/v3;", "getBinding", "()LJ8/v3;", "", "isExpand", "Z", "()Z", "setExpand", "(Z)V", "Lcom/iloen/melon/custom/MelonTextView;", "noticeTv", "Lcom/iloen/melon/custom/MelonTextView;", "getNoticeTv", "()Lcom/iloen/melon/custom/MelonTextView;", "", "maxLineInExpended", "I", "getMaxLineInExpended", "()I", "maxLineInFolded", "getMaxLineInFolded", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class NoticeViewHolder extends O0 {
            @NotNull
            private final v3 binding;
            private boolean isExpand;
            private final int maxLineInExpended;
            private final int maxLineInFolded;
            @NotNull
            private final MelonTextView noticeTv;

            public NoticeViewHolder(@NotNull v3 v30) {
                q.g(v30, "binding");
                TvProgramHomeAdapter.this = tvProgramHomeFragment$TvProgramHomeAdapter0;
                super(v30.a);
                this.binding = v30;
                q.f(v30.d, "noticeTv");
                this.noticeTv = v30.d;
                this.maxLineInExpended = 0x7FFFFFFF;
                this.maxLineInFolded = 2;
            }

            // 检测为 Lambda 实现
            public static void a(NoticeViewHolder tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0) [...]

            public final void clickTextViewExpand(@NotNull String s) {
                q.g(s, "text");
                if(this.noticeTv.getLineCount() > 2) {
                    boolean z = this.isExpand;
                    this.isExpand = !z;
                    if(z) {
                        this.binding.d.setMaxLines(this.maxLineInFolded);
                        Spanned spanned1 = Html.fromHtml(s, 0);
                        this.binding.d.setText(spanned1);
                        this.binding.e.setVisibility(0);
                    }
                    else {
                        this.binding.d.setMaxLines(this.maxLineInExpended);
                        this.binding.e.setVisibility(8);
                        Spanned spanned0 = Html.fromHtml(this.setExpandedText(s), 0);
                        this.binding.d.setText(spanned0);
                    }
                    this.itemView.requestLayout();
                }
            }

            @NotNull
            public final v3 getBinding() {
                return this.binding;
            }

            public final int getMaxLineInExpended() {
                return this.maxLineInExpended;
            }

            public final int getMaxLineInFolded() {
                return this.maxLineInFolded;
            }

            @NotNull
            public final MelonTextView getNoticeTv() {
                return this.noticeTv;
            }

            public final boolean isExpand() {
                return this.isExpand;
            }

            public final void setExpand(boolean z) {
                this.isExpand = z;
            }

            private final String setExpandedText(String s) {
                return s + "<font color=\"#a6a6a6\"> 접기</font>";
            }

            public final void setText(@NotNull String s) {
                q.g(s, "desc");
                Spanned spanned0 = Html.fromHtml(s, 0);
                this.noticeTv.setText(spanned0);
                j j0 = () -> NoticeViewHolder.setText$lambda$0(this);
                this.noticeTv.post(j0);
            }

            private static final void setText$lambda$0(NoticeViewHolder tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0) {
                if(!tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0.isExpand) {
                    if(tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0.noticeTv.getLineCount() > 2) {
                        tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0.binding.e.setVisibility(0);
                        return;
                    }
                    tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0.binding.e.setVisibility(8);
                }
            }
        }

        @NotNull
        private final String HEADER_TYPE_RELATED_ALBUM;
        @NotNull
        private final String HEADER_TYPE_RELATED_SONG;
        @NotNull
        private final String HEADER_TYPE_RELATED_VIDEO;
        private final int VIEW_TYPE_BANNER;
        private final int VIEW_TYPE_EMPTY;
        private final int VIEW_TYPE_ITEM_HEADER;
        private final int VIEW_TYPE_NEW_VIDEO;
        private final int VIEW_TYPE_NOTICE;
        private final int VIEW_TYPE_POPULAR_VIDEO;
        private final int VIEW_TYPE_RELATED_ALBUM;
        private final int VIEW_TYPE_RELATED_PLAYLIST;
        private final int VIEW_TYPE_RELATED_SONG;
        private final int VIEW_TYPE_RELATED_VIDEO;
        private final int VIEW_TYPE_SHOW_ALL;
        @NotNull
        private final com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.TvProgramHomeAdapter.itemClickListener.1 itemClickListener;

        public TvProgramHomeAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            TvProgramHomeFragment.this = tvProgramHomeFragment0;
            super(context0, list0);
            this.VIEW_TYPE_BANNER = 1;
            this.VIEW_TYPE_NEW_VIDEO = 2;
            this.VIEW_TYPE_POPULAR_VIDEO = 3;
            this.VIEW_TYPE_RELATED_VIDEO = 4;
            this.VIEW_TYPE_RELATED_SONG = 5;
            this.VIEW_TYPE_RELATED_ALBUM = 6;
            this.VIEW_TYPE_RELATED_PLAYLIST = 7;
            this.VIEW_TYPE_SHOW_ALL = 8;
            this.VIEW_TYPE_NOTICE = 9;
            this.VIEW_TYPE_EMPTY = 10;
            this.HEADER_TYPE_RELATED_VIDEO = "VIDEO";
            this.HEADER_TYPE_RELATED_SONG = "SONG";
            this.HEADER_TYPE_RELATED_ALBUM = "ALBUM";
            this.itemClickListener = new TvProgramItemClickListener() {
                @Override  // com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment$TvProgramItemClickListener
                public void onClickPopularItemView(MvInfoBase mvInfoBase0, int v) {
                    q.g(mvInfoBase0, "mv");
                    Navigator.openMvInfo$default(mvInfoBase0.mvId, tvProgramHomeFragment0.getMenuId(), null, false, 12, null);
                    f f0 = context0.getTiaraBuilder();
                    f0.a = "영상재생";
                    f0.d = ActionKind.PlayVideo;
                    f0.y = "인기영상";
                    f0.C = String.valueOf(v + 1);
                    f0.e = mvInfoBase0.mvId;
                    f0.g = mvInfoBase0.mvName;
                    f0.f = Y.i(ContsTypeCode.VIDEO, "code(...)");
                    f0.a().track();
                }

                @Override  // com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment$TvProgramItemClickListener
                public void onClickRelatedPlaylistItemView(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    q.g(djPlayListInfoBase0, "playlist");
                    Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                    f f0 = context0.getTiaraBuilder();
                    f0.a = "페이지이동";
                    f0.d = ActionKind.ClickContent;
                    f0.y = "연관플레이리스트";
                    f0.C = String.valueOf(v + 1);
                    f0.g = djPlayListInfoBase0.plylsttitle;
                    f0.e = djPlayListInfoBase0.plylstseq;
                    f0.f = Y.i(ContsTypeCode.PLAYLIST, "code(...)");
                    f0.a().track();
                }

                @Override  // com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment$TvProgramItemClickListener
                public void onPlayRelatedPlaylist(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                    q.g(djPlayListInfoBase0, "playlist");
                    String s = djPlayListInfoBase0.plylstseq;
                    String s1 = djPlayListInfoBase0.contsTypeCode;
                    String s2 = tvProgramHomeFragment0.getMenuId();
                    context0.playPlaylist(s, s1, s2, djPlayListInfoBase0.statsElements);
                    f f0 = context0.getTiaraBuilder();
                    f0.a = "음악재생";
                    f0.d = ActionKind.PlayMusic;
                    f0.y = "연관플레이리스트";
                    f0.C = String.valueOf(v + 1);
                    f0.g = djPlayListInfoBase0.plylsttitle;
                    f0.e = djPlayListInfoBase0.plylstseq;
                    f0.f = Y.i(ContsTypeCode.PLAYLIST, "code(...)");
                    f0.a().track();
                }

                @Override  // com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment$TvProgramItemClickListener
                public void setBannerClickLog(Banner tvProgramBannerRes$Response$Banner0, int v) {
                    q.g(tvProgramBannerRes$Response$Banner0, "banner");
                    f f0 = context0.getTiaraBuilder();
                    f0.a = "페이지이동";
                    f0.d = ActionKind.ClickContent;
                    f0.y = "채널소개";
                    f0.C = String.valueOf(v + 1);
                    f0.e = tvProgramBannerRes$Response$Banner0.bannerSeq;
                    f0.g = tvProgramBannerRes$Response$Banner0.adminTitle;
                    f0.a().track();
                }
            };
        }

        public static void a(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$20$lambda$18(object0, tvProgramHomeFragment0, tvProgramHomeFragment$TvProgramHomeAdapter0, v, view0);
        }

        // 检测为 Lambda 实现
        public static H b(MelonTextView melonTextView0, NoticeViewHolder tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0, Object object0, int v) [...]

        public static void c(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$20$lambda$19(tvProgramHomeFragment0, object0, tvProgramHomeFragment$TvProgramHomeAdapter0, v, view0);
        }

        public static void d(TvProgramHomeFragment tvProgramHomeFragment0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, String s, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$5$lambda$4(tvProgramHomeFragment0, tvProgramHomeFragment$TvProgramHomeAdapter0, s, view0);
        }

        public static void e(NoticeViewHolder tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0, Object object0, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$26$lambda$25$lambda$24$lambda$23(tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0, object0, view0);
        }

        public static void f(TvProgramHomeFragment tvProgramHomeFragment0, Playable playable0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, Object object0, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$17$lambda$15(tvProgramHomeFragment0, playable0, tvProgramHomeFragment$TvProgramHomeAdapter0, v, object0, view0);
        }

        public static void g(TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, Object object0, TvProgramHomeFragment tvProgramHomeFragment0, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$22$lambda$21(tvProgramHomeFragment0, object0, tvProgramHomeFragment$TvProgramHomeAdapter0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.q
        @Nullable
        public SongInfoBase getDetailSongItem(@Nullable Object object0) {
            if(object0 instanceof AdapterInViewHolder.Row && ((AdapterInViewHolder.Row)object0).getItem() instanceof SongInfoBase) {
                Object object1 = ((AdapterInViewHolder.Row)object0).getItem();
                q.e(object1, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                return (SongInfoBase)object1;
            }
            return null;
        }

        public static void h(TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, Object object0, TvProgramHomeFragment tvProgramHomeFragment0, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$8$lambda$7(tvProgramHomeFragment$TvProgramHomeAdapter0, object0, tvProgramHomeFragment0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            ArrayList arrayList0 = new ArrayList();
            if(httpResponse0 instanceof ProgramHomeRes) {
                this.updateModifiedTime(s);
                RESPONSE programHomeRes$RESPONSE0 = ((ProgramHomeRes)httpResponse0).response;
                if(programHomeRes$RESPONSE0 == null) {
                    return true;
                }
                if(programHomeRes$RESPONSE0.notice != null && programHomeRes$RESPONSE0.notice.length() != 0) {
                    arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_NOTICE, programHomeRes$RESPONSE0.notice, null, false, 12, null));
                }
                TvProgramBannerRes tvProgramBannerRes0 = TvProgramHomeFragment.this.getBannerRes();
                if(tvProgramBannerRes0 != null) {
                    Collection collection0 = tvProgramBannerRes0.response.banners;
                    if(collection0 != null && !collection0.isEmpty()) {
                        arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_BANNER, null, null, false, 14, null));
                    }
                }
                ArrayList arrayList1 = programHomeRes$RESPONSE0.newMvInfo.list;
                if(arrayList1 != null && !arrayList1.isEmpty()) {
                    arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_NEW_VIDEO, programHomeRes$RESPONSE0.newMvInfo, null, false, 12, null));
                }
                ArrayList arrayList2 = programHomeRes$RESPONSE0.popularMvInfo.list;
                if(arrayList2 != null && !arrayList2.isEmpty()) {
                    arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_POPULAR_VIDEO, programHomeRes$RESPONSE0.popularMvInfo, null, false, 12, null));
                }
                ArrayList arrayList3 = programHomeRes$RESPONSE0.mvInfo.list;
                if(arrayList3 == null || arrayList3.isEmpty()) {
                    arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_EMPTY, null, null, false, 14, null));
                }
                else {
                    ArrayList arrayList4 = programHomeRes$RESPONSE0.mvInfo.list;
                    if(arrayList4 != null && arrayList4.size() > 0) {
                        arrayList0.add(this.makeRowData(this.VIEW_TYPE_ITEM_HEADER, programHomeRes$RESPONSE0.mvInfo.title, this.HEADER_TYPE_RELATED_VIDEO, programHomeRes$RESPONSE0.mvInfo.isMore));
                        ArrayList arrayList5 = programHomeRes$RESPONSE0.mvInfo.list;
                        q.f(arrayList5, "list");
                        for(Object object0: arrayList5) {
                            arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_RELATED_VIDEO, ((MVLIST)object0), null, false, 12, null));
                        }
                    }
                    ArrayList arrayList6 = programHomeRes$RESPONSE0.songInfo.list;
                    if(arrayList6 != null && arrayList6.size() > 0) {
                        arrayList0.add(this.makeRowData(this.VIEW_TYPE_ITEM_HEADER, programHomeRes$RESPONSE0.songInfo.title, this.HEADER_TYPE_RELATED_SONG, programHomeRes$RESPONSE0.songInfo.isMore));
                        ArrayList arrayList7 = programHomeRes$RESPONSE0.songInfo.list;
                        q.f(arrayList7, "list");
                        for(Object object1: arrayList7) {
                            arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_RELATED_SONG, ((SongInfoBase)object1), null, false, 12, null));
                        }
                    }
                    ArrayList arrayList8 = programHomeRes$RESPONSE0.albumInfo.list;
                    if(arrayList8 != null && arrayList8.size() > 0) {
                        arrayList0.add(this.makeRowData(this.VIEW_TYPE_ITEM_HEADER, programHomeRes$RESPONSE0.albumInfo.title, this.HEADER_TYPE_RELATED_ALBUM, programHomeRes$RESPONSE0.albumInfo.isMore));
                        ArrayList arrayList9 = programHomeRes$RESPONSE0.albumInfo.list;
                        q.f(arrayList9, "list");
                        for(Object object2: arrayList9) {
                            arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_RELATED_ALBUM, ((AlbumInfoBase)object2), null, false, 12, null));
                        }
                    }
                    ArrayList arrayList10 = programHomeRes$RESPONSE0.playlistInfo.list;
                    if(arrayList10 != null && arrayList10.size() > 0) {
                        arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_RELATED_PLAYLIST, programHomeRes$RESPONSE0.playlistInfo, null, false, 12, null));
                    }
                }
                arrayList0.add(TvProgramHomeAdapter.makeRowData$default(this, this.VIEW_TYPE_SHOW_ALL, programHomeRes$RESPONSE0.buttonInfo, null, false, 12, null));
            }
            this.addAll(arrayList0);
            return true;
        }

        public static void i(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$17$lambda$13(tvProgramHomeFragment0, object0, tvProgramHomeFragment$TvProgramHomeAdapter0, v, view0);
        }

        // 去混淆评级： 低(20)
        @Override  // com.iloen.melon.adapters.common.q
        public boolean isDetailSongItem(@Nullable Object object0) {
            return object0 instanceof AdapterInViewHolder.Row && ((AdapterInViewHolder.Row)object0).getItem() instanceof SongInfoBase;
        }

        public static void j(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$17$lambda$14(tvProgramHomeFragment0, object0, tvProgramHomeFragment$TvProgramHomeAdapter0, v, view0);
        }

        public static void k(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$11$lambda$9(object0, tvProgramHomeFragment$TvProgramHomeAdapter0, tvProgramHomeFragment0, v, view0);
        }

        public static void l(TvProgramHomeFragment tvProgramHomeFragment0, int v, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v1, Object object0, View view0) {
            TvProgramHomeAdapter.onBindViewImpl$lambda$17$lambda$12(tvProgramHomeFragment0, v, tvProgramHomeFragment$TvProgramHomeAdapter0, v1, object0, view0);
        }

        // 检测为 Lambda 实现
        public static boolean m(TvProgramHomeFragment tvProgramHomeFragment0, Playable playable0, View view0) [...]

        private final AdapterInViewHolder.Row makeRowData(int v, Object object0, String s, boolean z) {
            a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.a = v;
            a0.b = object0;
            a0.f = s;
            a0.g = z;
            return new AdapterInViewHolder.Row(a0);
        }

        public static AdapterInViewHolder.Row makeRowData$default(TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, Object object0, String s, boolean z, int v1, Object object1) {
            if((v1 & 2) != 0) {
                object0 = null;
            }
            if((v1 & 4) != 0) {
                s = null;
            }
            if((v1 & 8) != 0) {
                z = false;
            }
            return tvProgramHomeFragment$TvProgramHomeAdapter0.makeRowData(v, object0, s, z);
        }

        @NotNull
        public final String mergeMetaString(@NotNull ArrayList arrayList0, int v) {
            q.g(arrayList0, "list");
            StringBuilder stringBuilder0 = new StringBuilder();
            int v1 = 0;
            for(Object object0: arrayList0) {
                MvInfoBase mvInfoBase0 = (MvInfoBase)object0;
                if(v1 > 0) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append((v == 0 ? mvInfoBase0.mvId : mvInfoBase0.mvName));
                ++v1;
            }
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            return s;
        }

        @Override  // com.iloen.melon.adapters.common.b
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            super.onBindViewImpl(o00, v, v1);
            AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)this.getItem(v1);
            Object object0 = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getItem();
            String s = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getContentOwner();
            int v2 = 0;
            boolean z = adapterInViewHolder$Row0 != null && adapterInViewHolder$Row0.isViewAll();
            if(o00 instanceof ItemHeaderHolder) {
                TvProgramHomeFragment tvProgramHomeFragment0 = TvProgramHomeFragment.this;
                if(object0 instanceof String) {
                    ((ItemHeaderHolder)o00).getTitle().setText(((CharSequence)object0));
                    View view0 = ((ItemHeaderHolder)o00).getShowAll();
                    if(!z) {
                        v2 = 8;
                    }
                    view0.setVisibility(v2);
                    ((ItemHeaderHolder)o00).getShowAll().setOnClickListener(new e(tvProgramHomeFragment0, this, s, 0));
                }
            }
            else if(o00 instanceof ItemNewVideoHolder) {
                TvProgramHomeFragment tvProgramHomeFragment1 = TvProgramHomeFragment.this;
                if(object0 instanceof NEWMVINFO) {
                    ((ItemNewVideoHolder)o00).getPlayNewVideo().setText(((NEWMVINFO)object0).title);
                    ViewUtils.setContentDescriptionWithClassName(((ItemNewVideoHolder)o00).getPlayNewVideo(), ((NEWMVINFO)object0).title, "android.widget.Button", null);
                    com.iloen.melon.fragments.melontv.program.f f0 = new com.iloen.melon.fragments.melontv.program.f(this, ((NEWMVINFO)object0), tvProgramHomeFragment1);
                    ((ItemNewVideoHolder)o00).itemView.setOnClickListener(f0);
                }
            }
            else if(o00 instanceof ItemRelatedVideoHolder) {
                TvProgramHomeFragment tvProgramHomeFragment2 = TvProgramHomeFragment.this;
                if(object0 instanceof MVLIST) {
                    Glide.with(this.getContext()).load(((MVLIST)object0).mv169Img).into(((ItemRelatedVideoHolder)o00).getThumbnail());
                    ((ItemRelatedVideoHolder)o00).getGrade19().setVisibility((((MVLIST)object0).isAdult ? 0 : 8));
                    ((ItemRelatedVideoHolder)o00).getDesc().setText(((MVLIST)object0).mvName);
                    ((ItemRelatedVideoHolder)o00).getDate().setText(((MVLIST)object0).issueDate);
                    ((ItemRelatedVideoHolder)o00).getArtist().setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(this.getContext(), ((MVLIST)object0).artistList, 0x7FFFFFFF));
                    String s1 = ((MVLIST)object0).epsdNoName;
                    if(s1 == null || s1.length() == 0) {
                        ((ItemRelatedVideoHolder)o00).getRoundDot().setVisibility(8);
                    }
                    else {
                        ((ItemRelatedVideoHolder)o00).getRoundDot().setVisibility(0);
                    }
                    ((ItemRelatedVideoHolder)o00).getRound().setText(((MVLIST)object0).epsdNoName);
                    TextView textView0 = ((ItemRelatedVideoHolder)o00).getPlaytime();
                    String s2 = ((MVLIST)object0).playTime;
                    String s3 = "";
                    if(s2 == null) {
                        s2 = "";
                    }
                    textView0.setText(k.f(s2));
                    d d0 = new d(((MVLIST)object0), this, tvProgramHomeFragment2, v1);
                    ((ItemRelatedVideoHolder)o00).itemView.setOnClickListener(d0);
                    if(this.getContext() != null) {
                        String s4 = k.e(((MVLIST)object0).playTime);
                        String s5 = ((MVLIST)object0).issueDate;
                        if(s5 == null) {
                            s5 = "";
                        }
                        List list0 = o.R0(s5, new String[]{"."}, 0, 6);
                        if(list0.size() == 3) {
                            s3 = list0.get(0) + "년" + list0.get(1) + "월" + list0.get(2) + "일";
                        }
                        View view1 = tvProgramHomeFragment2.getLikeBtn();
                        String s6 = ((MVLIST)object0).mvName;
                        CharSequence charSequence0 = ((ItemRelatedVideoHolder)o00).getArtist().getText();
                        StringBuilder stringBuilder0 = new StringBuilder();
                        stringBuilder0.append(s6);
                        stringBuilder0.append(", ");
                        stringBuilder0.append(charSequence0);
                        stringBuilder0.append(", ");
                        stringBuilder0.append(s4);
                        ViewUtils.setContentDescriptionWithClassName(view1, x.m(stringBuilder0, ", ", s3), "android.widget.Button", null);
                    }
                }
            }
            else if(o00 instanceof ItemRelatedSongHolder) {
                TvProgramHomeFragment tvProgramHomeFragment3 = TvProgramHomeFragment.this;
                if(object0 instanceof SongInfoBase) {
                    if(this.isMarked(v1)) {
                        int v3 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                        ((ItemRelatedSongHolder)o00).itemView.setBackgroundColor(v3);
                    }
                    else {
                        int v4 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                        ((ItemRelatedSongHolder)o00).itemView.setBackgroundColor(v4);
                    }
                    h h0 = new h(tvProgramHomeFragment3, v, this, v1, ((SongInfoBase)object0), 0);
                    ((ItemRelatedSongHolder)o00).itemView.setOnClickListener(h0);
                    Playable playable0 = Playable.from(((SongInfoBase)object0), this.getMenuId(), null);
                    Glide.with(this.getContext()).load(((SongInfoBase)object0).getAlbumImgSmall()).into(((ItemRelatedSongHolder)o00).getThumbnail());
                    ((ItemRelatedSongHolder)o00).getTitle().setText(((SongInfoBase)object0).songName);
                    ((ItemRelatedSongHolder)o00).getArtist().setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(this.getContext(), ((SongInfoBase)object0).artistList, 0x7FFFFFFF));
                    ((ItemRelatedSongHolder)o00).getGrade19().setVisibility((((SongInfoBase)object0).isAdult ? 0 : 8));
                    ((ItemRelatedSongHolder)o00).getThumbnail().setOnClickListener(new d(tvProgramHomeFragment3, ((SongInfoBase)object0), this, v1, 3));
                    View view2 = ((ItemRelatedSongHolder)o00).getPlay();
                    if(!((SongInfoBase)object0).canService) {
                        v2 = 8;
                    }
                    view2.setVisibility(v2);
                    ((ItemRelatedSongHolder)o00).getPlay().setOnClickListener(new d(tvProgramHomeFragment3, ((SongInfoBase)object0), this, v1, 4));
                    ((ItemRelatedSongHolder)o00).getInfo().setOnClickListener(new com.iloen.melon.fragments.melontv.program.i(tvProgramHomeFragment3, playable0, this, v1, ((SongInfoBase)object0), 0));
                    c c0 = (View view0) -> TvProgramHomeAdapter.onBindViewImpl$lambda$17$lambda$16(tvProgramHomeFragment3, playable0, view0);
                    ((ItemRelatedSongHolder)o00).itemView.setOnLongClickListener(c0);
                    String s7 = TalkbackUtilKt.getTalkbackInfo(playable0, this.getContext());
                    ViewUtils.setContentDescriptionWithClassName(((ItemRelatedSongHolder)o00).itemView, s7, "android.widget.Button", null);
                }
            }
            else if(o00 instanceof ItemRelatedAlbumHolder) {
                TvProgramHomeFragment tvProgramHomeFragment4 = TvProgramHomeFragment.this;
                if(object0 instanceof AlbumInfoBase) {
                    Glide.with(this.getContext()).load(((AlbumInfoBase)object0).albumImg).into(((ItemRelatedAlbumHolder)o00).getThumbnail());
                    ((ItemRelatedAlbumHolder)o00).getTitle().setText(((AlbumInfoBase)object0).albumName);
                    ((ItemRelatedAlbumHolder)o00).getArtist().setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(this.getContext(), ((AlbumInfoBase)object0).artistList, 0x7FFFFFFF));
                    ((ItemRelatedAlbumHolder)o00).getDate().setText(((AlbumInfoBase)object0).issueDate);
                    d d1 = new d(((AlbumInfoBase)object0), tvProgramHomeFragment4, this, v1);
                    ((ItemRelatedAlbumHolder)o00).itemView.setOnClickListener(d1);
                    ((ItemRelatedAlbumHolder)o00).getBtnPlayIv().setOnClickListener(new d(tvProgramHomeFragment4, ((AlbumInfoBase)object0), this, v1, 1));
                    com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.TvProgramHomeAdapter.onBindViewImpl.5.3 tvProgramHomeFragment$TvProgramHomeAdapter$onBindViewImpl$5$30 = new View.AccessibilityDelegate() {
                        @Override  // android.view.View$AccessibilityDelegate
                        public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                            q.g(view0, "host");
                            q.g(accessibilityNodeInfo0, "info");
                            super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, "앨범 상세보기"));
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, "앨범 재생"));
                            Context context0 = object0.getContext();
                            accessibilityNodeInfo0.setContentDescription(TalkbackUtilKt.getTalkbackInfo(((AlbumInfoBase)tvProgramHomeFragment4), context0));
                            accessibilityNodeInfo0.setClassName("android.widget.Button");
                        }

                        @Override  // android.view.View$AccessibilityDelegate
                        public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                            q.g(view0, "host");
                            switch(v) {
                                case 100000001: {
                                    Navigator.openAlbumInfo(((AlbumInfoBase)tvProgramHomeFragment4).albumId);
                                    return true;
                                }
                                case 100000002: {
                                    String s = ((AlbumInfoBase)tvProgramHomeFragment4).albumId;
                                    String s1 = object0.getMenuId();
                                    TvProgramHomeFragment.this.playAlbum(s, s1);
                                    return true;
                                }
                                default: {
                                    return super.performAccessibilityAction(view0, v, bundle0);
                                }
                            }
                        }
                    };
                    ((ItemRelatedAlbumHolder)o00).itemView.setAccessibilityDelegate(tvProgramHomeFragment$TvProgramHomeAdapter$onBindViewImpl$5$30);
                }
            }
            else if(o00 instanceof ItemShowAllHolder) {
                TvProgramHomeFragment tvProgramHomeFragment5 = TvProgramHomeFragment.this;
                if(object0 instanceof BUTTONINFO) {
                    ((ItemShowAllHolder)o00).getShowAll().setText(((BUTTONINFO)object0).title);
                    com.iloen.melon.fragments.melontv.program.f f1 = new com.iloen.melon.fragments.melontv.program.f(tvProgramHomeFragment5, ((BUTTONINFO)object0), this);
                    ((ItemShowAllHolder)o00).itemView.setOnClickListener(f1);
                    ViewUtils.setContentDescriptionWithButtonClassName(((ItemShowAllHolder)o00).itemView, ((BUTTONINFO)object0).title);
                }
            }
            else if(o00 instanceof NoticeViewHolder) {
                if(object0 instanceof String) {
                    ((NoticeViewHolder)o00).setText(((String)object0));
                    MelonTextView melonTextView0 = ((NoticeViewHolder)o00).getNoticeTv();
                    a.a.C(melonTextView0, (int v) -> TvProgramHomeAdapter.onBindViewImpl$lambda$26$lambda$25$lambda$24(melonTextView0, ((NoticeViewHolder)o00), ((String)object0), v));
                }
            }
            else if(o00 instanceof TvProgramBannerViewHolder) {
                HttpResponse httpResponse0 = this.getResponse();
                if(httpResponse0 instanceof ProgramHomeRes) {
                    String s8 = ((ProgramHomeRes)httpResponse0).response.notice;
                    if(s8 == null || s8.length() == 0) {
                        v2 = 1;
                    }
                    ((TvProgramBannerViewHolder)o00).setTopMargin(((boolean)(v2 ^ 1)));
                }
            }
        }

        private static final void onBindViewImpl$lambda$11$lambda$9(Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, TvProgramHomeFragment tvProgramHomeFragment0, int v, View view0) {
            Navigator.openMvInfo$default(((MVLIST)object0).mvId, tvProgramHomeFragment$TvProgramHomeAdapter0.getMenuId(), null, false, 12, null);
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "영상재생";
            f0.d = ActionKind.PlayVideo;
            f0.y = "영상";
            f0.C = String.valueOf(v + 1);
            f0.e = ((MVLIST)object0).mvId;
            f0.f = Y.i(ContsTypeCode.VIDEO, "code(...)");
            f0.g = ((MVLIST)object0).mvName;
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$17$lambda$12(TvProgramHomeFragment tvProgramHomeFragment0, int v, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v1, Object object0, View view0) {
            tvProgramHomeFragment0.onItemClick(tvProgramHomeFragment0.getView(), v);
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "선택";
            f0.d = ActionKind.ClickContent;
            f0.y = "연관곡";
            f0.C = String.valueOf(v1 + 1);
            f0.e = ((SongInfoBase)object0).songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = ((SongInfoBase)object0).songName;
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$17$lambda$13(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            tvProgramHomeFragment0.showAlbumInfoPage(((SongInfoBase)object0));
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "연관곡";
            f0.C = String.valueOf(v + 1);
            f0.e = ((SongInfoBase)object0).albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = ((SongInfoBase)object0).albumName;
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$17$lambda$14(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            tvProgramHomeFragment0.playSong(((SongInfoBase)object0).songId, tvProgramHomeFragment$TvProgramHomeAdapter0.getMenuId());
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "음악재생";
            f0.d = ActionKind.PlayMusic;
            f0.y = "연관곡";
            f0.C = String.valueOf(v + 1);
            f0.e = ((SongInfoBase)object0).songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = ((SongInfoBase)object0).songName;
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$17$lambda$15(TvProgramHomeFragment tvProgramHomeFragment0, Playable playable0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, Object object0, View view0) {
            tvProgramHomeFragment0.showContextPopupSong(playable0);
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "연관곡";
            f0.C = String.valueOf(v + 1);
            f0.e = ((SongInfoBase)object0).songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = ((SongInfoBase)object0).songName;
            f0.a().track();
        }

        private static final boolean onBindViewImpl$lambda$17$lambda$16(TvProgramHomeFragment tvProgramHomeFragment0, Playable playable0, View view0) {
            tvProgramHomeFragment0.showContextPopupSongOrInstantPlay(playable0);
            return true;
        }

        private static final void onBindViewImpl$lambda$20$lambda$18(Object object0, TvProgramHomeFragment tvProgramHomeFragment0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            Navigator.openAlbumInfo(((AlbumInfoBase)object0).albumId);
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "연관앨범";
            f0.C = String.valueOf(v + 1);
            f0.e = ((AlbumInfoBase)object0).albumId;
            f0.g = ((AlbumInfoBase)object0).albumName;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$20$lambda$19(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, View view0) {
            tvProgramHomeFragment0.playAlbum(((AlbumInfoBase)object0).albumId, tvProgramHomeFragment$TvProgramHomeAdapter0.getMenuId());
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "음악재생";
            f0.d = ActionKind.PlayMusic;
            f0.y = "연관앨범";
            f0.C = String.valueOf(v + 1);
            f0.e = ((AlbumInfoBase)object0).albumId;
            f0.g = ((AlbumInfoBase)object0).albumName;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$22$lambda$21(TvProgramHomeFragment tvProgramHomeFragment0, Object object0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, View view0) {
            Intent intent0 = new Intent(tvProgramHomeFragment0.getActivity(), ProgramSelectActivity.class);
            intent0.putExtra("argMenuSeq", ((BUTTONINFO)object0).menuSeq);
            tvProgramHomeFragment0.activityResult.b(intent0);
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "페이지이동";
            f0.y = "프로그램전체보기";
            f0.F = ((BUTTONINFO)object0).title;
            f0.a().track();
        }

        private static final H onBindViewImpl$lambda$26$lambda$25$lambda$24(MelonTextView melonTextView0, NoticeViewHolder tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0, Object object0, int v) {
            if(v > 2) {
                melonTextView0.setOnClickListener(new com.iloen.melon.fragments.melontv.program.b(0, tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0, object0));
            }
            return H.a;
        }

        private static final void onBindViewImpl$lambda$26$lambda$25$lambda$24$lambda$23(NoticeViewHolder tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0, Object object0, View view0) {
            tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0.clickTextViewExpand(((String)object0));
        }

        private static final void onBindViewImpl$lambda$5$lambda$4(TvProgramHomeFragment tvProgramHomeFragment0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, String s, View view0) {
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "페이지이동";
            f0.F = "전체보기";
            if(q.b(s, tvProgramHomeFragment$TvProgramHomeAdapter0.HEADER_TYPE_RELATED_VIDEO)) {
                Navigator.open(TvProgramMoreVideoFragment.Companion.newInstance(tvProgramHomeFragment0.getProgramSeq(), tvProgramHomeFragment0.getProgramTitle()));
                f0.y = "영상";
                f0.a().track();
                return;
            }
            if(q.b(s, tvProgramHomeFragment$TvProgramHomeAdapter0.HEADER_TYPE_RELATED_SONG)) {
                Navigator.open(TvProgramMoreSongFragment.Companion.newInstance(tvProgramHomeFragment0.getProgramSeq(), tvProgramHomeFragment0.getProgramTitle()));
                f0.y = "연관곡";
                f0.a().track();
                return;
            }
            if(q.b(s, tvProgramHomeFragment$TvProgramHomeAdapter0.HEADER_TYPE_RELATED_ALBUM)) {
                Navigator.open(TvProgramMoreAlbumFragment.Companion.newInstance(tvProgramHomeFragment0.getProgramSeq(), tvProgramHomeFragment0.getProgramTitle()));
                f0.y = "연관앨범";
                f0.a().track();
            }
        }

        private static final void onBindViewImpl$lambda$8$lambda$7(TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, Object object0, TvProgramHomeFragment tvProgramHomeFragment0, View view0) {
            ArrayList arrayList0 = ((NEWMVINFO)object0).list;
            q.f(arrayList0, "list");
            String s = tvProgramHomeFragment$TvProgramHomeAdapter0.mergeMetaString(arrayList0, 0);
            ArrayList arrayList1 = ((NEWMVINFO)object0).list;
            q.f(arrayList1, "list");
            String s1 = tvProgramHomeFragment$TvProgramHomeAdapter0.mergeMetaString(arrayList1, 1);
            f f0 = tvProgramHomeFragment0.getTiaraBuilder();
            f0.a = "영상재생";
            f0.d = ActionKind.PlayVideo;
            f0.y = "채널소개";
            f0.e = s;
            f0.g = s1;
            f0.f = Y.i(ContsTypeCode.VIDEO, "code(...)");
            f0.a().track();
            ArrayList arrayList2 = ((NEWMVINFO)object0).list;
            q.f(arrayList2, "list");
            ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
            for(Object object1: arrayList2) {
                arrayList3.add(Playable.from(((MvInfoBase)object1), tvProgramHomeFragment$TvProgramHomeAdapter0.getMenuId(), null));
            }
            tvProgramHomeFragment0.playMvByMvId(new ArrayList(arrayList3));
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            List list0 = null;
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_ITEM_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08C3, viewGroup0, false);  // layout:tvprogram_home_header_item_layout
                q.f(view0, "inflate(...)");
                return new ItemHeaderHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_BANNER) {
                com.iloen.melon.fragments.melontv.program.TvProgramBannerViewHolder.Companion tvProgramBannerViewHolder$Companion0 = TvProgramBannerViewHolder.Companion;
                Context context0 = this.getContext();
                TvProgramBannerRes tvProgramBannerRes0 = TvProgramHomeFragment.this.getBannerRes();
                if(tvProgramBannerRes0 != null) {
                    Response tvProgramBannerRes$Response0 = tvProgramBannerRes0.response;
                    if(tvProgramBannerRes$Response0 != null) {
                        list0 = tvProgramBannerRes$Response0.banners;
                    }
                }
                return tvProgramBannerViewHolder$Companion0.newInstance(context0, viewGroup0, list0, this.itemClickListener);
            }
            if(v == this.VIEW_TYPE_NEW_VIDEO) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08C5, viewGroup0, false);  // layout:tvprogram_home_new_video_item_layout
                q.f(view1, "inflate(...)");
                return new ItemNewVideoHolder(this, view1);
            }
            if(v == this.VIEW_TYPE_POPULAR_VIDEO) {
                return TvProgramPopularVideoHolder.Companion.newInstance(viewGroup0, this.itemClickListener);
            }
            if(v == this.VIEW_TYPE_RELATED_VIDEO) {
                View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08CF, viewGroup0, false);  // layout:tvprogram_video_item_layout
                q.f(view2, "inflate(...)");
                return new ItemRelatedVideoHolder(this, view2);
            }
            if(v == this.VIEW_TYPE_RELATED_SONG) {
                View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04AE, viewGroup0, false);  // layout:listitem_song_new
                q.f(view3, "inflate(...)");
                return new ItemRelatedSongHolder(this, view3);
            }
            if(v == this.VIEW_TYPE_RELATED_ALBUM) {
                View view4 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08BF, viewGroup0, false);  // layout:tvprogram_album_item_layout
                q.f(view4, "inflate(...)");
                return new ItemRelatedAlbumHolder(this, view4);
            }
            if(v == this.VIEW_TYPE_RELATED_PLAYLIST) {
                return TvProgramRelatedPlaylistHolder.Companion.newInstance(viewGroup0, this.itemClickListener);
            }
            if(v == this.VIEW_TYPE_SHOW_ALL) {
                View view5 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08CA, viewGroup0, false);  // layout:tvprogram_home_show_all_item_layout
                q.f(view5, "inflate(...)");
                return new ItemShowAllHolder(this, view5);
            }
            if(v == this.VIEW_TYPE_NOTICE) {
                View view6 = TvProgramHomeFragment.this.getLayoutInflater().inflate(0x7F0D08C6, viewGroup0, false);  // layout:tvprogram_home_notice_item_layout
                int v1 = 0x7F0A03C2;  // id:devider
                View view7 = I.C(view6, 0x7F0A03C2);  // id:devider
                if(view7 != null) {
                    v1 = 0x7F0A0818;  // id:more_gradient
                    View view8 = I.C(view6, 0x7F0A0818);  // id:more_gradient
                    if(view8 != null && ((MelonTextView)I.C(view6, 0x7F0A081D)) != null) {  // id:more_tv
                        v1 = 0x7F0A08C1;  // id:notice_tv
                        View view9 = I.C(view6, 0x7F0A08C1);  // id:notice_tv
                        if(((MelonTextView)view9) != null) {
                            v1 = 0x7F0A0AE4;  // id:state_folded
                            View view10 = I.C(view6, 0x7F0A0AE4);  // id:state_folded
                            if(((Group)view10) != null) {
                                return new NoticeViewHolder(this, new v3(((ConstraintLayout)view6), view7, view8, ((MelonTextView)view9), ((Group)view10)));
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
            }
            if(v == this.VIEW_TYPE_EMPTY) {
                View view11 = TvProgramHomeFragment.this.getLayoutInflater().inflate(0x7F0D08C2, viewGroup0, false);  // layout:tvprogram_home_empty_item_layout
                if(((ImageView)I.C(view11, 0x7F0A042A)) == null) {  // id:empty_image
                    throw new NullPointerException("Missing required view with ID: " + view11.getResources().getResourceName(0x7F0A042A));  // id:empty_image
                }
                return new EmptyViewHolder(this, new u3(((ConstraintLayout)view11)));
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "", "Lcom/melon/net/res/common/MvInfoBase;", "mv", "", "index", "Lie/H;", "onClickPopularItemView", "(Lcom/melon/net/res/common/MvInfoBase;I)V", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "playlist", "onClickRelatedPlaylistItemView", "(Lcom/melon/net/res/common/DjPlayListInfoBase;I)V", "onPlayRelatedPlaylist", "Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes$Response$Banner;", "banner", "setBannerClickLog", "(Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes$Response$Banner;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface TvProgramItemClickListener {
        void onClickPopularItemView(@NotNull MvInfoBase arg1, int arg2);

        void onClickRelatedPlaylistItemView(@NotNull DjPlayListInfoBase arg1, int arg2);

        void onPlayRelatedPlaylist(@NotNull DjPlayListInfoBase arg1, int arg2);

        void setBannerClickLog(@NotNull Banner arg1, int arg2);
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_PROGRAM_SEQ = "argProgramSeq";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "TvProgramMainFragment";
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_GO_ALBUM_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_PLAY_ALBUM = 100000002;
    @NotNull
    private final e.b activityResult;
    @Nullable
    private TvProgramBannerRes bannerRes;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    public FrameLayout headerLayout;
    public TextView headerLikedCount;
    public ImageView headerLikedIcon;
    private boolean isLikedMark;
    public View likeBtn;
    private int prevOrientation;
    @Nullable
    private PROGINFO programRes;
    @NotNull
    private String programSeq;
    @NotNull
    private String programTitle;
    public s tiaraBase;
    @NotNull
    private final F8.o titlebarCollapeStyle;
    @NotNull
    private final F8.o titlebarExpandStyle;

    static {
        TvProgramHomeFragment.Companion = new Companion(null);
        TvProgramHomeFragment.$stable = 8;
    }

    public TvProgramHomeFragment() {
        this.programSeq = "";
        this.programTitle = "";
        this.titlebarCollapeStyle = B.a.s(7);
        p p0 = new p(0);
        p0.g(new m(2, false));
        this.titlebarExpandStyle = p0;
        this.exceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                H0.b.w("onFetchStart() error, exceptionHandler ", throwable0.getMessage(), LogU.Companion, "TvProgramMainFragment");
                BuildersKt__Builders_commonKt.launch$default(f0.f(TvProgramHomeFragment.this), Dispatchers.getMain(), null, new com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.exceptionHandler.1.1(throwable0, TvProgramHomeFragment.this, null), 2, null);
            }
        };
        e.b b0 = this.registerForActivityResult(new androidx.fragment.app.f0(2), new n(this));
        q.f(b0, "registerForActivityResult(...)");
        this.activityResult = b0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment$exceptionHandler$1$1", f = "TvProgramHomeFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.exceptionHandler.1.1 extends oe.i implements we.n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.exceptionHandler.1.1(Throwable throwable0, TvProgramHomeFragment tvProgramHomeFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                TvProgramHomeFragment.this = tvProgramHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.exceptionHandler.1.1(this.$throwable, TvProgramHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.exceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    TvProgramHomeFragment.this.mResponseErrorListener.onErrorResponse(((VolleyError)this.$throwable));
                    TvProgramHomeFragment.access$setNetworkHeadView(TvProgramHomeFragment.this);
                }
                return H.a;
            }
        }

    }

    private static final void activityResult$lambda$3(TvProgramHomeFragment tvProgramHomeFragment0, ActivityResult activityResult0) {
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                String s = intent0.getStringExtra("argProgramSeqResult");
                if(s != null && s.length() != 0) {
                    View view0 = tvProgramHomeFragment0.getView();
                    if(view0 != null) {
                        view0.post(() -> if(tvProgramHomeFragment0.isAdded() && !tvProgramHomeFragment0.getParentFragmentManager().T()) {
                            Navigator.open(TvProgramHomeFragment.Companion.newInstance(s));
                        });
                    }
                }
            }
        }
    }

    // 检测为 Lambda 实现
    private static final void activityResult$lambda$3$lambda$2$lambda$1(TvProgramHomeFragment tvProgramHomeFragment0, String s) [...]

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 1000);  // id:toolbar_layout
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new TvProgramHomeAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setMarkedMode(true);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(1);
        return j00;
    }

    @Nullable
    public final TvProgramBannerRes getBannerRes() {
        return this.bannerRes;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.f.buildUpon(), "progSeq", this.programSeq, "toString(...)");
    }

    @NotNull
    public final FrameLayout getHeaderLayout() {
        FrameLayout frameLayout0 = this.headerLayout;
        if(frameLayout0 != null) {
            return frameLayout0;
        }
        q.m("headerLayout");
        throw null;
    }

    @NotNull
    public final TextView getHeaderLikedCount() {
        TextView textView0 = this.headerLikedCount;
        if(textView0 != null) {
            return textView0;
        }
        q.m("headerLikedCount");
        throw null;
    }

    @NotNull
    public final ImageView getHeaderLikedIcon() {
        ImageView imageView0 = this.headerLikedIcon;
        if(imageView0 != null) {
            return imageView0;
        }
        q.m("headerLikedIcon");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
    }

    @NotNull
    public final View getLikeBtn() {
        View view0 = this.likeBtn;
        if(view0 != null) {
            return view0;
        }
        q.m("likeBtn");
        throw null;
    }

    @Nullable
    public final PROGINFO getProgramRes() {
        return this.programRes;
    }

    @NotNull
    public final String getProgramSeq() {
        return this.programSeq;
    }

    @NotNull
    public final String getProgramTitle() {
        return this.programTitle;
    }

    @NotNull
    public final s getTiaraBase() {
        s s0 = this.tiaraBase;
        if(s0 != null) {
            return s0;
        }
        q.m("tiaraBase");
        throw null;
    }

    private final f getTiaraBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.getTiaraBase().a;
        f0.c = this.getTiaraBase().b;
        f0.I = this.getTiaraBase().c;
        f0.o = this.programSeq;
        f0.q = this.programTitle;
        return f0;
    }

    @NotNull
    public final F8.o getTitlebarCollapeStyle() {
        return this.titlebarCollapeStyle;
    }

    @NotNull
    public final F8.o getTitlebarExpandStyle() {
        return this.titlebarExpandStyle;
    }

    private final void initHeaderContainer() {
        View view0 = this.findViewById(0x7F0A07D0);  // id:mainboard_layout
        q.e(view0, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.setHeaderLayout(((FrameLayout)view0));
        this.getHeaderLayout().removeAllViews();
        View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08C4, this.getHeaderLayout(), false);  // layout:tvprogram_home_mainboard
        this.getHeaderLayout().addView(view1);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getTitleBar().getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.getStatusBarHeight(this.getContext());
        View view2 = this.findViewById(0x7F0A02DD);  // id:collapsing_toolbar_layout
        int v = this.getResources().getDimensionPixelSize(0x7F07046D);  // dimen:top_container_height
        view2.setMinimumHeight(ScreenUtils.getStatusBarHeight(this.getContext()) + v);
        view1.findViewById(0x7F0A04F8).setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{(ScreenUtils.isDarkMode(this.getContext()) ? -435023342 : 0xE6FFFFFF), ColorUtils.getColor(this.getContext(), 0x7F0604AA)}));  // id:gradient_artist_header_fifth
        PROGINFO programHomeRes$RESPONSE$PROGINFO0 = this.programRes;
        if(programHomeRes$RESPONSE$PROGINFO0 != null) {
            ((ImageView)this.getHeaderLayout().findViewById(0x7F0A069E)).setImageResource(0x7F080791);  // id:iv_thumb_default
            View view3 = this.getHeaderLayout().findViewById(0x7F0A076E);  // id:liked_icon
            q.f(view3, "findViewById(...)");
            this.setHeaderLikedIcon(((ImageView)view3));
            View view4 = this.getHeaderLayout().findViewById(0x7F0A076D);  // id:liked_count
            q.f(view4, "findViewById(...)");
            this.setHeaderLikedCount(((TextView)view4));
            View view5 = this.getHeaderLayout().findViewById(0x7F0A0763);  // id:like_btn
            q.f(view5, "findViewById(...)");
            this.setLikeBtn(view5);
            Context context0 = this.getContext();
            if(context0 != null) {
                Glide.with(context0).load(programHomeRes$RESPONSE$PROGINFO0.progImagUrl).into(((ImageView)this.getHeaderLayout().findViewById(0x7F0A069A)));  // id:iv_thumb
                ((TextView)this.getHeaderLayout().findViewById(0x7F0A0B8D)).setText(programHomeRes$RESPONSE$PROGINFO0.progName);  // id:title
                ((TextView)this.getHeaderLayout().findViewById(0x7F0A03A2)).setText(programHomeRes$RESPONSE$PROGINFO0.progSimplDesc);  // id:desc
                this.getHeaderLikedCount().setText(StringUtils.getCountString(programHomeRes$RESPONSE$PROGINFO0.likedCnt, 0x1869F));
                this.getLikeBtn().setOnClickListener(new com.iloen.melon.fragments.melontv.program.p(this, 3));
                ((ImageView)this.getHeaderLayout().findViewById(0x7F0A0A80)).setOnClickListener(new com.iloen.melon.fragments.melontv.program.b(2, this, programHomeRes$RESPONSE$PROGINFO0));  // id:share
                TvProgramHomeFragment.updateLikedView$default(this, this.isLikedMark, null, 2, null);
            }
        }
    }

    private static final void initHeaderContainer$lambda$10$lambda$9$lambda$7(TvProgramHomeFragment tvProgramHomeFragment0, View view0) {
        tvProgramHomeFragment0.requestLikedAction();
    }

    private static final void initHeaderContainer$lambda$10$lambda$9$lambda$8(TvProgramHomeFragment tvProgramHomeFragment0, PROGINFO programHomeRes$RESPONSE$PROGINFO0, View view0) {
        String s = tvProgramHomeFragment0.programTitle;
        q.g(s, "title");
        String s1 = tvProgramHomeFragment0.programSeq;
        q.g(s1, "progSeq");
        String s2 = programHomeRes$RESPONSE$PROGINFO0.progImagUrl;
        q.f(s2, "progImagUrl");
        ShareLinkData shareLinkData0 = programHomeRes$RESPONSE$PROGINFO0.sharedLink;
        q.f(shareLinkData0, "sharedLink");
        SharableTvProgram sharableTvProgram0 = new SharableTvProgram();  // 初始化器: Ljava/lang/Object;-><init>()V
        sharableTvProgram0.a = s1;
        sharableTvProgram0.b = s;
        sharableTvProgram0.d = s2;
        sharableTvProgram0.e = shareLinkData0;
        f f0 = tvProgramHomeFragment0.getTiaraBuilder();
        f0.a = "공유";
        f0.d = ActionKind.ClickContent;
        f0.y = "채널소개";
        f0.g = tvProgramHomeFragment0.programTitle;
        f0.e = tvProgramHomeFragment0.programSeq;
        f0.a().track();
        tvProgramHomeFragment0.showSNSListPopup(sharableTvProgram0);
    }

    public final boolean isLikedMark() {
        return this.isLikedMark;
    }

    @NotNull
    public static final TvProgramHomeFragment newInstance(@Nullable String s) {
        return TvProgramHomeFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.initHeaderContainer();
        if(configuration0.orientation != this.prevOrientation) {
            RecyclerView recyclerView0 = this.mRecyclerView;
            if(recyclerView0 != null) {
                recyclerView0.scrollToPosition(0);
            }
            View view0 = this.getView();
            if(view0 != null) {
                AppBarLayout appBarLayout0 = (AppBarLayout)view0.findViewById(0x7F0A00AB);  // id:appbar_layout
                if(appBarLayout0 != null) {
                    appBarLayout0.setExpanded(true);
                }
            }
        }
        this.prevOrientation = configuration0.orientation;
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

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D04F5, viewGroup0, false);  // layout:melontv_program_home_layout
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable v9.h h0, @Nullable String s) {
        if(this.programSeq.length() == 0) {
            return false;
        }
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        RequestFuture requestFuture1 = RequestFuture.newFuture();
        RequestFuture requestFuture2 = RequestFuture.newFuture();
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain().plus(this.exceptionHandler), null, new we.n(i0, requestFuture0, requestFuture1, requestFuture2, null) {
            final RequestFuture $bannerFuture;
            final RequestFuture $isLikedFuture;
            final RequestFuture $mainFuture;
            final i $type;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            {
                TvProgramHomeFragment.this = tvProgramHomeFragment0;
                this.$type = i0;
                this.$mainFuture = requestFuture0;
                this.$bannerFuture = requestFuture1;
                this.$isLikedFuture = requestFuture2;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1(TvProgramHomeFragment.this, this.$type, this.$mainFuture, this.$bannerFuture, this.$isLikedFuture, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                MyMusicLikeInformContentsLikeRes myMusicLikeInformContentsLikeRes0;
                ProgramHomeRes programHomeRes1;
                TvProgramHomeFragment tvProgramHomeFragment0;
                Deferred deferred4;
                Deferred deferred3;
                Deferred deferred2;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(this.$mainFuture, null) {
                            final RequestFuture $mainFuture;
                            int label;

                            {
                                TvProgramHomeFragment.this = tvProgramHomeFragment0;
                                this.$mainFuture = requestFuture0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1.mainReq.1(TvProgramHomeFragment.this, this.$mainFuture, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1.mainReq.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                return RequestBuilder.newInstance(new ProgramHomeReq(TvProgramHomeFragment.this.getContext(), TvProgramHomeFragment.this.getProgramSeq())).tag(TvProgramHomeFragment.this.getRequestTag()).listener(this.$mainFuture).errorListener(TvProgramHomeFragment.this.mResponseErrorListener).requestSync(this.$mainFuture);
                            }
                        }, 2, null);
                        Deferred deferred1 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(this.$bannerFuture, null) {
                            final RequestFuture $bannerFuture;
                            int label;

                            {
                                TvProgramHomeFragment.this = tvProgramHomeFragment0;
                                this.$bannerFuture = requestFuture0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1.bannerReq.1(TvProgramHomeFragment.this, this.$bannerFuture, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1.bannerReq.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label == 0) {
                                    d5.n.D(object0);
                                    try {
                                        return RequestBuilder.newInstance(new TvProgramBannerReq(TvProgramHomeFragment.this.getContext(), TvProgramHomeFragment.this.getProgramSeq())).tag(TvProgramHomeFragment.this.getRequestTag()).listener(this.$bannerFuture).errorListener(this.$bannerFuture).requestSync(this.$bannerFuture);
                                    }
                                    catch(Exception unused_ex) {
                                        return null;
                                    }
                                }
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }, 2, null);
                        deferred2 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getIO(), null, new we.n(this.$isLikedFuture, null) {
                            final RequestFuture $isLikedFuture;
                            int label;

                            {
                                TvProgramHomeFragment.this = tvProgramHomeFragment0;
                                this.$isLikedFuture = requestFuture0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1.isLikedReq.1(TvProgramHomeFragment.this, this.$isLikedFuture, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.onFetchStart.1.isLikedReq.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label == 0) {
                                    d5.n.D(object0);
                                    try {
                                        Params myMusicLikeInformContentsLikeReq$Params0 = new Params();
                                        myMusicLikeInformContentsLikeReq$Params0.actTypeCode = "N20001";
                                        myMusicLikeInformContentsLikeReq$Params0.contsTypeCode = "N10044";
                                        myMusicLikeInformContentsLikeReq$Params0.contsId = TvProgramHomeFragment.this.getProgramSeq();
                                        return RequestBuilder.newInstance(new MyMusicLikeInformContentsLikeReq(TvProgramHomeFragment.this.getContext(), myMusicLikeInformContentsLikeReq$Params0)).tag(TvProgramHomeFragment.this.getRequestTag()).listener(this.$isLikedFuture).errorListener(this.$isLikedFuture).requestSync(this.$isLikedFuture);
                                    }
                                    catch(Exception unused_ex) {
                                        return null;
                                    }
                                }
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }, 2, null);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = deferred1;
                        this.L$3 = deferred2;
                        this.label = 1;
                        object0 = deferred0.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        deferred3 = deferred1;
                        deferred4 = deferred2;
                        goto label_23;
                    }
                    case 1: {
                        deferred2 = (Deferred)this.L$3;
                        deferred3 = (Deferred)this.L$2;
                        Deferred deferred5 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        deferred4 = deferred2;
                    label_23:
                        ProgramHomeRes programHomeRes0 = object0 instanceof ProgramHomeRes ? ((ProgramHomeRes)object0) : null;
                        tvProgramHomeFragment0 = TvProgramHomeFragment.this;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = deferred4;
                        this.L$4 = programHomeRes0;
                        this.L$5 = tvProgramHomeFragment0;
                        this.label = 2;
                        Object object1 = deferred3.await(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        programHomeRes1 = programHomeRes0;
                        object0 = object1;
                        goto label_43;
                    }
                    case 2: {
                        tvProgramHomeFragment0 = (TvProgramHomeFragment)this.L$5;
                        programHomeRes1 = (ProgramHomeRes)this.L$4;
                        deferred4 = (Deferred)this.L$3;
                        Deferred deferred6 = (Deferred)this.L$2;
                        Deferred deferred7 = (Deferred)this.L$1;
                        d5.n.D(object0);
                    label_43:
                        tvProgramHomeFragment0.setBannerRes((object0 instanceof TvProgramBannerRes ? ((TvProgramBannerRes)object0) : null));
                        if(TvProgramHomeFragment.this.isLoginUser()) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = programHomeRes1;
                            this.L$5 = null;
                            this.label = 3;
                            object0 = deferred4.await(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            myMusicLikeInformContentsLikeRes0 = object0 instanceof MyMusicLikeInformContentsLikeRes ? ((MyMusicLikeInformContentsLikeRes)object0) : null;
                        }
                        else {
                            myMusicLikeInformContentsLikeRes0 = null;
                        }
                        break;
                    }
                    case 3: {
                        ProgramHomeRes programHomeRes2 = (ProgramHomeRes)this.L$4;
                        Deferred deferred8 = (Deferred)this.L$3;
                        Deferred deferred9 = (Deferred)this.L$2;
                        Deferred deferred10 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        myMusicLikeInformContentsLikeRes0 = object0 instanceof MyMusicLikeInformContentsLikeRes ? ((MyMusicLikeInformContentsLikeRes)object0) : null;
                        programHomeRes1 = programHomeRes2;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(programHomeRes1 != null) {
                    String s = programHomeRes1.response.programInfo.progName;
                    q.f(s, "progName");
                    TvProgramHomeFragment.this.setProgramTitle(s);
                    TvProgramHomeFragment.this.setProgramRes(programHomeRes1.response.programInfo);
                    TvProgramHomeFragment.this.initHeaderContainer();
                    s s1 = new s(programHomeRes1.response.section, programHomeRes1.response.page, programHomeRes1.response.menuId, null);
                    TvProgramHomeFragment.this.setTiaraBase(s1);
                }
                if(myMusicLikeInformContentsLikeRes0 != null) {
                    com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes.RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = myMusicLikeInformContentsLikeRes0.response;
                    if(myMusicLikeInformContentsLikeRes$RESPONSE0 != null) {
                        boolean z = ProtocolUtils.parseBoolean(myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn);
                        Integer integer0 = new Integer(ProtocolUtils.parseInt(myMusicLikeInformContentsLikeRes$RESPONSE0.summcnt, 0));
                        TvProgramHomeFragment.this.updateLikedView(z, integer0);
                    }
                }
                boolean z1 = TvProgramHomeFragment.this.prepareFetchComplete(programHomeRes1);
                H h0 = H.a;
                if(!z1) {
                    TvProgramHomeFragment.this.setNetworkHeadView();
                    return h0;
                }
                TvProgramHomeFragment.this.performFetchComplete(this.$type, programHomeRes1);
                return h0;
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.programSeq = l1.g(bundle0, "inState", "argProgramSeq", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argProgramSeq", this.programSeq);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        int v;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Context context0 = this.getContext();
        if(context0 == null) {
            v = 0;
        }
        else {
            Resources resources0 = context0.getResources();
            if(resources0 == null) {
                v = 0;
            }
            else {
                Configuration configuration0 = resources0.getConfiguration();
                v = configuration0 == null ? 0 : configuration0.orientation;
            }
        }
        this.prevOrientation = v;
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(this.titlebarExpandStyle);
            titleBar0.setBackgroundColor(0);
        }
        ((AppBarLayout)view0.findViewById(0x7F0A00AB)).a(new AppBarStateChangeListener() {  // id:appbar_layout
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
            public static final class WhenMappings {
                public static final int[] $EnumSwitchMapping$0;

                static {
                    int[] arr_v = new int[State.values().length];
                    try {
                        arr_v[State.COLLAPSED.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError unused_ex) {
                    }
                    WhenMappings.$EnumSwitchMapping$0 = arr_v;
                }
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$AppBarStateChangeListener
            public void onStateChanged(AppBarLayout appBarLayout0, State detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0) {
                Window window0 = null;
                if((detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0.ordinal()]) == 1) {
                    if(!ScreenUtils.isDarkMode(TvProgramHomeFragment.this.getContext())) {
                        FragmentActivity fragmentActivity0 = TvProgramHomeFragment.this.getActivity();
                        if(fragmentActivity0 != null) {
                            window0 = fragmentActivity0.getWindow();
                        }
                        ScreenUtils.setAppearanceLightStatusBars(window0, true);
                    }
                    TvProgramHomeFragment.this.getHeaderLayout().setVisibility(4);
                    TvProgramHomeFragment.this.getTitleBar().a(TvProgramHomeFragment.this.getTitlebarCollapeStyle());
                    TvProgramHomeFragment.this.getTitleBar().setTitle(TvProgramHomeFragment.this.getProgramTitle());
                    TvProgramHomeFragment.this.getTitleBar().setBackgroundColor(ColorUtils.getColor(TvProgramHomeFragment.this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
                    return;
                }
                if(!ScreenUtils.isDarkMode(TvProgramHomeFragment.this.getContext())) {
                    FragmentActivity fragmentActivity1 = TvProgramHomeFragment.this.getActivity();
                    if(fragmentActivity1 != null) {
                        window0 = fragmentActivity1.getWindow();
                    }
                    ScreenUtils.setAppearanceLightStatusBars(window0, false);
                }
                TvProgramHomeFragment.this.getTitleBar().a(TvProgramHomeFragment.this.getTitlebarExpandStyle());
                TvProgramHomeFragment.this.getHeaderLayout().setVisibility(0);
                TvProgramHomeFragment.this.getTitleBar().setTitle("");
                TvProgramHomeFragment.this.getTitleBar().setBackgroundColor(ColorUtils.getColor(TvProgramHomeFragment.this.getContext(), 0x7F06048A));  // color:transparent
            }
        });
        this.initHeaderContainer();
    }

    private final void requestLikedAction() {
        if(this.getContext() != null) {
            String s = this.isLikedMark ? "dislike" : "like";
            q.d(s);
            f f0 = this.getTiaraBuilder();
            f0.a = "좋아요";
            f0.d = ActionKind.Like;
            f0.y = "채널소개";
            f0.g = this.programTitle;
            f0.e = this.programSeq;
            f0.U = s;
            f0.a().track();
        }
        this.updateLike(this.programSeq, "N10044", !this.isLikedMark, this.getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                TvProgramHomeFragment.this.getLikeBtn().setEnabled(true);
                TvProgramHomeFragment.this.getLikeBtn().setClickable(true);
                if(TextUtils.isEmpty(s) && TvProgramHomeFragment.this.isFragmentValid()) {
                    TvProgramHomeFragment.this.updateLikedView(z, v);
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
                TvProgramHomeFragment.this.getLikeBtn().setEnabled(false);
                TvProgramHomeFragment.this.getLikeBtn().setClickable(false);
            }
        });
    }

    public final void setBannerRes(@Nullable TvProgramBannerRes tvProgramBannerRes0) {
        this.bannerRes = tvProgramBannerRes0;
    }

    public final void setHeaderLayout(@NotNull FrameLayout frameLayout0) {
        q.g(frameLayout0, "<set-?>");
        this.headerLayout = frameLayout0;
    }

    public final void setHeaderLikedCount(@NotNull TextView textView0) {
        q.g(textView0, "<set-?>");
        this.headerLikedCount = textView0;
    }

    public final void setHeaderLikedIcon(@NotNull ImageView imageView0) {
        q.g(imageView0, "<set-?>");
        this.headerLikedIcon = imageView0;
    }

    public final void setLikeBtn(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.likeBtn = view0;
    }

    public final void setLikedMark(boolean z) {
        this.isLikedMark = z;
    }

    private final void setNetworkHeadView() {
        f0.f(this).a(new we.n(null) {
            int label;

            {
                TvProgramHomeFragment.this = tvProgramHomeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.setNetworkHeadView.1(TvProgramHomeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment.setNetworkHeadView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                TvProgramHomeFragment.this.getHeaderLayout().setVisibility(8);
                return H.a;
            }
        });
    }

    public final void setProgramRes(@Nullable PROGINFO programHomeRes$RESPONSE$PROGINFO0) {
        this.programRes = programHomeRes$RESPONSE$PROGINFO0;
    }

    public final void setProgramSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.programSeq = s;
    }

    public final void setProgramTitle(@NotNull String s) {
        q.g(s, "<set-?>");
        this.programTitle = s;
    }

    public final void setTiaraBase(@NotNull s s0) {
        q.g(s0, "<set-?>");
        this.tiaraBase = s0;
    }

    private final void updateLikedView(boolean z, Integer integer0) {
        String s;
        this.isLikedMark = z;
        this.getHeaderLikedIcon().setImageResource((z ? 0x7F08014B : 0x7F080148));  // drawable:btn_common_like_22_on
        if(integer0 != null) {
            this.getHeaderLikedCount().setText(StringUtils.getCountString(((int)integer0), 0x1869F));
            if(z) {
                Context context0 = this.getContext();
                s = context0 == null ? null : context0.getString(0x7F130B5E, new Object[]{integer0.toString()});  // string:talkback_like_off_with_cnt "좋아요, %1$s명, 좋아요 취소하기"
            }
            else {
                Context context1 = this.getContext();
                s = context1 == null ? null : context1.getString(0x7F130B61, new Object[]{integer0.toString()});  // string:talkback_like_on_with_cnt "좋아요, %1$s명, 좋아요 선택하기"
            }
            ViewUtils.setContentDescriptionWithClassName(this.getLikeBtn(), s, "android.widget.Button", null);
        }
    }

    public static void updateLikedView$default(TvProgramHomeFragment tvProgramHomeFragment0, boolean z, Integer integer0, int v, Object object0) {
        if((v & 2) != 0) {
            integer0 = null;
        }
        tvProgramHomeFragment0.updateLikedView(z, integer0);
    }
}

