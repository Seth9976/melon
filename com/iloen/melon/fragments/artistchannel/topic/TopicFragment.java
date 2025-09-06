package com.iloen.melon.fragments.artistchannel.topic;

import Cb.i;
import Cb.j;
import Cb.k;
import De.I;
import F8.m;
import J8.K1;
import J8.f3;
import J8.i3;
import J8.j3;
import J8.k3;
import J8.l3;
import J8.m3;
import J8.n3;
import J8.o3;
import J8.p3;
import J8.q3;
import J8.r3;
import J8.x;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import androidx.recyclerview.widget.w0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.fragments.comments.CmtBaseFragment.OnCmtRemoveListener;
import com.iloen.melon.fragments.comments.CmtBaseFragment.Param;
import com.iloen.melon.fragments.comments.CmtBaseFragment;
import com.iloen.melon.fragments.comments.CommentListRenewalViewHolder;
import com.iloen.melon.fragments.comments.LastItemSpacingDecoration;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.ListCmtReq;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnReq;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGINGINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.request.ArtistContentsArtistTopicInfoReq;
import com.iloen.melon.net.v6x.request.ArtistContentsInfoLikeAndCmtReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsInfoLikeAndCmtReq;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.ARTISTINFO;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICCONTENTSLIST;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICINFO;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes;
import com.iloen.melon.net.v6x.response.ArtistContentsInfoLikeAndCmtRes.RESPONSE.USERACTIONINFO;
import com.iloen.melon.net.v6x.response.ArtistContentsInfoLikeAndCmtRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableTopic;
import com.iloen.melon.sns.model.ShareLinkData;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import pe.a;
import pe.b;
import v9.c;
import v9.h;
import va.e0;
import va.o;
import we.n;

@Metadata(d1 = {"\u0000\u00DC\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 u2\u00020\u0001:\u0005uvwxyB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0010J-\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ!\u0010\u001F\u001A\u00020\t2\u0006\u0010\u001E\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\'\u0010.\u001A\u00020\u000E2\u0006\u0010*\u001A\u00020)2\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b.\u0010/J\u0017\u00102\u001A\u00020\t2\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b2\u00103J\u000F\u00105\u001A\u000204H\u0014\u00A2\u0006\u0004\b5\u00106JA\u0010=\u001A\u00020\t2\b\u00108\u001A\u0004\u0018\u0001072\b\u00109\u001A\u0004\u0018\u00010\u00042\b\u0010:\u001A\u0004\u0018\u00010\u00042\b\u0010;\u001A\u0004\u0018\u00010\u00042\b\u0010<\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b=\u0010>J]\u0010E\u001A\u00020\t2\b\u0010?\u001A\u0004\u0018\u00010\u00042\b\u00108\u001A\u0004\u0018\u0001072\b\u0010@\u001A\u0004\u0018\u00010\u00042\b\u00109\u001A\u0004\u0018\u00010\u00042\u0006\u0010A\u001A\u00020\u000E2\b\u0010B\u001A\u0004\u0018\u00010\u00042\b\u0010C\u001A\u0004\u0018\u00010\u00042\b\u0010D\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\bE\u0010FJ\u0011\u0010H\u001A\u0004\u0018\u00010GH\u0016\u00A2\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001A\u00020\t2\u0006\u0010K\u001A\u00020JH\u0002\u00A2\u0006\u0004\bL\u0010MJ\u001F\u0010R\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u0006\u0010O\u001A\u00020NH\u0002\u00A2\u0006\u0004\bR\u0010SJ\u001F\u0010U\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010T0P2\u0006\u0010O\u001A\u00020NH\u0002\u00A2\u0006\u0004\bU\u0010SJ\u001F\u0010W\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010V0P2\u0006\u0010O\u001A\u00020NH\u0002\u00A2\u0006\u0004\bW\u0010SJ\u001F\u0010Y\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010X0P2\u0006\u0010O\u001A\u00020NH\u0002\u00A2\u0006\u0004\bY\u0010SJ\u001F\u0010[\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010Z0P2\u0006\u0010O\u001A\u00020NH\u0002\u00A2\u0006\u0004\b[\u0010SJ\u0017\u0010]\u001A\u00020\t2\u0006\u0010\\\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b]\u0010\u0014R\u0016\u0010^\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b`\u0010_R\u0016\u0010a\u001A\u00020J8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001A\u00020J8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bc\u0010bR\u0016\u0010d\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bd\u0010_R \u0010g\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020f0e8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001A\u00020i8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010m\u001A\u00020l8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010r\u001A\u00020o8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bp\u0010qR\u0014\u0010t\u001A\u00020G8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bs\u0010I\u00A8\u0006z"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment;", "Lcom/iloen/melon/fragments/comments/CmtBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "isScreenLandscapeSupported", "()Z", "hasScrolledLine", "show", "showScrolledLine", "(Z)V", "isHeaderParallaxEnabled", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "copy", "metaId", "metaType", "metaName", "contentsItemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "actionName", "layer1", "isLike", "cmtSeq", "url", "nickName", "itemClickLog", "(Ljava/lang/String;Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "", "count", "updateCmtAllCount", "(I)V", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes;", "requestTopicInfoAsync", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v4x/response/UserActionsRes;", "requestUserActionAsync", "Lcom/iloen/melon/net/v6x/response/ArtistContentsInfoLikeAndCmtRes;", "requestLikeAndCmtAsync", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "requestLoadPgnAsync", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "requestListCmtAsync", "isLiked", "requestLikedAction", "artistId", "Ljava/lang/String;", "topicSeq", "nextPageNo", "I", "cmtAllCount", "artistName", "", "Landroid/graphics/Bitmap;", "blurViewBgMap", "Ljava/util/Map;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lcom/iloen/melon/fragments/comments/CmtBaseFragment$OnCmtRemoveListener;", "mOnCmtRemoveListener", "Lcom/iloen/melon/fragments/comments/CmtBaseFragment$OnCmtRemoveListener;", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "getBaseTiaraLogEventBuilder", "baseTiaraLogEventBuilder", "Companion", "Location", "TopicItemDecoration", "TopicAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TopicFragment extends CmtBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$Companion;", "", "<init>", "()V", "TAG", "", "VIEW_TYPE_UNKNOWN", "", "VIEW_TYPE_HEADER", "VIEW_TYPE_CONTENTS_IMAGE", "VIEW_TYPE_CONTENTS_TEXT", "VIEW_TYPE_CONTENTS_MV", "VIEW_TYPE_CONTENTS_SONG", "VIEW_TYPE_CONTENTS_LINK", "VIEW_TYPE_CONTENTS_UNSUPPORTED", "VIEW_TYPE_COMMENT_HEADER", "VIEW_TYPE_COMMENT", "VIEW_TYPE_COMMENT_EMPTY", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment;", "artistId", "topicSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TopicFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "artistId");
            q.g(s1, "topicSeq");
            TopicFragment topicFragment0 = new TopicFragment();
            Bundle bundle0 = Y.c("argArtistId", s, "argItemId", s1);
            bundle0.putSerializable("argCmtParam", new Param());
            topicFragment0.setArguments(bundle0);
            return topicFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$Location;", "", "<init>", "(Ljava/lang/String;I)V", "FULL", "LEFT", "RIGHT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum Location {
        FULL,
        LEFT,
        RIGHT;

        private static final a $ENTRIES;
        private static final Location[] $VALUES;

        private static final Location[] $values() [...] // Inlined contents

        static {
            Location.$VALUES = arr_topicFragment$Location;
            q.g(arr_topicFragment$Location, "entries");
            Location.$ENTRIES = new b(arr_topicFragment$Location);
        }

        @NotNull
        public static a getEntries() {
            return Location.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$ServerDataWrapper;", "", "viewType", "", "data", "location", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$Location;", "<init>", "(ILjava/lang/Object;Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$Location;)V", "getViewType", "()I", "getData", "()Ljava/lang/Object;", "getLocation", "()Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$Location;", "setLocation", "(Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$Location;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ServerDataWrapper {
        public static final int $stable = 8;
        @Nullable
        private final Object data;
        @NotNull
        private Location location;
        private final int viewType;

        public ServerDataWrapper(int v, @Nullable Object object0, @NotNull Location topicFragment$Location0) {
            q.g(topicFragment$Location0, "location");
            super();
            this.viewType = v;
            this.data = object0;
            this.location = topicFragment$Location0;
        }

        public ServerDataWrapper(int v, Object object0, Location topicFragment$Location0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v1 & 4) != 0) {
                topicFragment$Location0 = Location.FULL;
            }
            this(v, object0, topicFragment$Location0);
        }

        @Nullable
        public final Object getData() {
            return this.data;
        }

        @NotNull
        public final Location getLocation() {
            return this.location;
        }

        public final int getViewType() {
            return this.viewType;
        }

        public final void setLocation(@NotNull Location topicFragment$Location0) {
            q.g(topicFragment$Location0, "<set-?>");
            this.location = topicFragment$Location0;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003/01B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0019\u001A\u00020\u00182\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ!\u0010#\u001A\u0004\u0018\u00010\u00032\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020\u001BH\u0016¢\u0006\u0004\b#\u0010$J)\u0010&\u001A\u00020\f2\b\u0010%\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001BH\u0016¢\u0006\u0004\b&\u0010\'J\u0019\u0010(\u001A\u00020\f2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b(\u0010)R$\u0010*\u001A\u0004\u0018\u00010\n8F@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b,\u0010-\"\u0004\b.\u0010\u000E¨\u00062"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment;Landroid/content/Context;Ljava/util/List;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE;", "topicResponse", "Lie/H;", "addTopicInfo", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO;", "getTopicInfo", "()Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO;", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "vh", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "clearCache", "(Ljava/lang/String;)V", "topicInfoRes", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE;", "getTopicInfoRes", "()Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE;", "setTopicInfoRes", "HeaderViewHolder", "TopicCommentHeaderViewHolder", "TopicCommentEmptyViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class TopicAdapter extends p {
        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/r3;", "binding", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicAdapter;LJ8/r3;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO;", "item", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO;)V", "LJ8/r3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HeaderViewHolder extends O0 {
            @NotNull
            private final r3 binding;

            public HeaderViewHolder(@NotNull r3 r30) {
                q.g(r30, "binding");
                TopicAdapter.this = topicFragment$TopicAdapter0;
                super(r30.a);
                this.binding = r30;
            }

            // 检测为 Lambda 实现
            public static void a(TopicFragment topicFragment0, TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, TopicAdapter topicFragment$TopicAdapter0, View view0) [...]

            public static void b(TopicFragment topicFragment0, View view0) {
                HeaderViewHolder.bind$lambda$3(topicFragment0, view0);
            }

            public final void bind(@NotNull TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0) {
                String s1;
                q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, "item");
                this.binding.h.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.title);
                this.binding.d.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.dsPlyDate);
                this.binding.b.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.cmtDsPlyDate);
                this.binding.e.setChecked(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.isLike);
                MelonTextView melonTextView0 = this.binding.f;
                String s = artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.likeCnt;
                if(s == null) {
                    s1 = "0";
                }
                else {
                    Context context0 = TopicAdapter.this.getContext();
                    q.f(context0, "access$getContext(...)");
                    s1 = k.a(context0, s);
                    if(s1 == null) {
                        s1 = "0";
                    }
                }
                melonTextView0.setText(s1);
                Context context1 = TopicAdapter.this.getContext();
                q.f(context1, "access$getContext(...)");
                String s2 = k.a(context1, String.valueOf(TopicFragment.this.cmtAllCount));
                this.binding.c.setText(s2);
                e e0 = new e(0, artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, TopicFragment.this);
                this.binding.e.setOnClickListener(e0);
                f f0 = (View view0) -> HeaderViewHolder.bind$lambda$2(TopicFragment.this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, TopicAdapter.this, view0);
                this.binding.c.setOnClickListener(f0);
                g g0 = new g(TopicFragment.this, 0);
                this.binding.g.setOnClickListener(g0);
            }

            private static final void bind$lambda$0(TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, TopicFragment topicFragment0, View view0) {
                boolean z = artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.isLike;
                String s = topicFragment0.getString((z ? 0x7F130FCC : 0x7F130FCD));  // string:tiara_props_dislike "dislike"
                q.f(s, "getString(...)");
                if(i.l(topicFragment0.mMelonTiaraProperty)) {
                    p8.f f0 = topicFragment0.getBaseTiaraLogEventBuilder();
                    f0.a = topicFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                    f0.d = ActionKind.Like;
                    f0.y = topicFragment0.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.e = topicFragment0.topicSeq;
                    f0.U = s;
                    f0.a().track();
                }
                topicFragment0.requestLikedAction(z);
            }

            private static final void bind$lambda$2(TopicFragment topicFragment0, TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, TopicAdapter topicFragment$TopicAdapter0, View view0) {
                if(i.l(topicFragment0.mMelonTiaraProperty)) {
                    p8.f f0 = topicFragment0.getBaseTiaraLogEventBuilder();
                    f0.a = topicFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = topicFragment0.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.e = topicFragment0.topicSeq;
                    f0.a().track();
                }
                com.iloen.melon.fragments.comments.CmtListFragment.Param cmtListFragment$Param0 = new com.iloen.melon.fragments.comments.CmtListFragment.Param();
                cmtListFragment$Param0.chnlSeq = topicFragment0.mParam.chnlSeq;
                cmtListFragment$Param0.contsRefValue = topicFragment0.mParam.contsRefValue;
                cmtListFragment$Param0.showTitle = true;
                cmtListFragment$Param0.headerTitle = artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.title;
                cmtListFragment$Param0.isReadOnly = false;
                cmtListFragment$Param0.cacheKeyOfTargetPage = topicFragment$TopicAdapter0.getCacheKey();
                Navigator.INSTANCE.openCommentRenewalVersion(cmtListFragment$Param0);
            }

            private static final void bind$lambda$3(TopicFragment topicFragment0, View view0) {
                if(i.l(topicFragment0.mMelonTiaraProperty)) {
                    p8.f f0 = topicFragment0.getBaseTiaraLogEventBuilder();
                    f0.a = topicFragment0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                    f0.d = ActionKind.Follow;
                    f0.y = topicFragment0.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.F = topicFragment0.getString(0x7F130D99);  // string:tiara_click_copy_share "공유하기"
                    f0.e = topicFragment0.topicSeq;
                    f0.a().track();
                }
                topicFragment0.showSNSListPopup(topicFragment0.getSNSSharable());
            }

            public static void c(TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, TopicFragment topicFragment0, View view0) {
                HeaderViewHolder.bind$lambda$0(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, topicFragment0, view0);
            }
        }

        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicAdapter$TopicCommentEmptyViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/i3;", "binding", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicAdapter;LJ8/i3;)V", "", "isCmtAvail", "Lie/H;", "bind", "(Z)V", "LJ8/i3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class TopicCommentEmptyViewHolder extends O0 {
            @NotNull
            private final i3 binding;

            public TopicCommentEmptyViewHolder(@NotNull i3 i30) {
                q.g(i30, "binding");
                TopicAdapter.this = topicFragment$TopicAdapter0;
                super(i30.a);
                this.binding = i30;
            }

            public final void bind(boolean z) {
                MelonTextView melonTextView0 = this.binding.b;
                Context context0 = TopicAdapter.this.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getString((z ? 0x7F1302FE : 0x7F1301E0));  // string:detail_empty_comment_text "등록된 댓글이 없습니다.\n첫 댓글을 남겨보세요."
                melonTextView0.setText(charSequence0);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicAdapter$TopicCommentHeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/j3;", "binding", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicAdapter;LJ8/j3;)V", "Lie/H;", "bind", "()V", "LJ8/j3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class TopicCommentHeaderViewHolder extends O0 {
            @NotNull
            private final j3 binding;

            public TopicCommentHeaderViewHolder(@NotNull j3 j30) {
                q.g(j30, "binding");
                TopicAdapter.this = topicFragment$TopicAdapter0;
                super(j30.a);
                this.binding = j30;
            }

            public static void a(TopicFragment topicFragment0, TopicAdapter topicFragment$TopicAdapter0, View view0) {
                TopicCommentHeaderViewHolder.bind$lambda$0(topicFragment0, topicFragment$TopicAdapter0, view0);
            }

            public static void b(TopicFragment topicFragment0, View view0) {
                TopicCommentHeaderViewHolder.bind$lambda$1(topicFragment0, view0);
            }

            public final void bind() {
                l1.D(new Object[]{(TopicAdapter.this.getContext() == null ? null : "댓글"), StringUtils.getCountFormattedString(TopicFragment.this.cmtAllCount)}, 2, "%s %s", this.binding.b);
                e e0 = new e(TopicAdapter.this, TopicFragment.this);
                this.binding.c.setOnClickListener(e0);
                g g0 = new g(TopicFragment.this, 1);
                this.binding.d.setOnClickListener(g0);
            }

            private static final void bind$lambda$0(TopicFragment topicFragment0, TopicAdapter topicFragment$TopicAdapter0, View view0) {
                if(i.l(topicFragment0.mMelonTiaraProperty)) {
                    p8.f f0 = topicFragment0.getBaseTiaraLogEventBuilder();
                    f0.a = topicFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = topicFragment0.getString(0x7F130D14);  // string:tiara_click_copy_comment "댓글"
                    f0.F = topicFragment0.getString(0x7F130E35);  // string:tiara_common_layer2_refresh "새로고침"
                    f0.a().track();
                }
                j0 j00 = topicFragment0.getAdapter();
                TopicAdapter topicFragment$TopicAdapter1 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
                if(topicFragment$TopicAdapter1 != null) {
                    topicFragment$TopicAdapter1.clearCache(topicFragment$TopicAdapter0.getCacheKey());
                }
                topicFragment0.startFetch("refresh");
            }

            private static final void bind$lambda$1(TopicFragment topicFragment0, View view0) {
                if(i.l(topicFragment0.mMelonTiaraProperty)) {
                    p8.f f0 = topicFragment0.getBaseTiaraLogEventBuilder();
                    f0.a = topicFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = topicFragment0.getString(0x7F130D14);  // string:tiara_click_copy_comment "댓글"
                    f0.F = topicFragment0.getString(0x7F130DB4);  // string:tiara_click_copy_write "글쓰기"
                    f0.a().track();
                }
                if(!NetUtils.isConnected()) {
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    return;
                }
                if(!((e0)o.a()).m()) {
                    topicFragment0.showLoginPopup();
                    return;
                }
                LoadPgnRes loadPgnRes0 = topicFragment0.mLoadPgnRes;
                if(loadPgnRes0 != null && (loadPgnRes0.result != null && (loadPgnRes0.result.chnlinfo != null && loadPgnRes0.result.chnlinfo.checkArtistFanFlag))) {
                    LoadPgnRes loadPgnRes1 = topicFragment0.mLoadPgnRes;
                    if(loadPgnRes1 == null || (loadPgnRes1.result == null || (loadPgnRes1.result.myMemberInfo == null || !loadPgnRes1.result.myMemberInfo.artistFanFlag))) {
                        FragmentActivity fragmentActivity0 = topicFragment0.getActivity();
                        String s = null;
                        l0 l00 = fragmentActivity0 == null ? null : fragmentActivity0.getSupportFragmentManager();
                        String s1 = topicFragment0.getActivity() == null ? null : "안내";
                        if(topicFragment0.getActivity() != null) {
                            s = "글쓰기는 팬맺기 후에 가능합니다.";
                        }
                        com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
                        return;
                    }
                }
                topicFragment0.openCmtWriteView();
            }
        }

        @Nullable
        private RESPONSE topicInfoRes;

        public TopicAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            TopicFragment.this = topicFragment0;
            super(context0, list0);
        }

        private final void addTopicInfo(RESPONSE artistContentsArtistTopicInfoRes$RESPONSE0) {
            Location topicFragment$Location1;
            int v1;
            int v;
            TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 = artistContentsArtistTopicInfoRes$RESPONSE0.topicInfo;
            if(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 != null) {
                this.add(new ServerDataWrapper(0, artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, null, 4, null));
            }
            ArrayList arrayList0 = new ArrayList();
            List list0 = artistContentsArtistTopicInfoRes$RESPONSE0.topicContentsList;
            if(list0 != null) {
                for(Object object0: list0) {
                    String s = ((TOPICCONTENTSLIST)object0).contsTypeCode;
                    if(q.b(s, "T10001")) {
                        v = 1;
                    }
                    else {
                        if(q.b(s, "T10002")) {
                            v1 = 2;
                        }
                        else if(q.b(s, "T10003")) {
                            v = 3;
                            goto label_24;
                        }
                        else if(q.b(s, "T10004")) {
                            v1 = 4;
                        }
                        else {
                            v1 = q.b(s, "T10006") || q.b(s, "T10007") ? 5 : 49;
                        }
                        v = v1;
                    }
                label_24:
                    arrayList0.add(new ServerDataWrapper(v, ((TOPICCONTENTSLIST)object0), null, 4, null));
                }
            }
            int v2 = 0;
            for(Object object1: arrayList0) {
                Integer integer0 = null;
                if(v2 >= 0) {
                    if(e.k.A(new Integer[]{1, 3}).contains(((ServerDataWrapper)object1).getViewType())) {
                        ServerDataWrapper topicFragment$ServerDataWrapper0 = (ServerDataWrapper)je.p.n0(v2 - 1, arrayList0);
                        Integer integer1 = topicFragment$ServerDataWrapper0 == null ? null : topicFragment$ServerDataWrapper0.getViewType();
                        Location topicFragment$Location0 = topicFragment$ServerDataWrapper0 == null ? null : topicFragment$ServerDataWrapper0.getLocation();
                        ServerDataWrapper topicFragment$ServerDataWrapper1 = (ServerDataWrapper)je.p.n0(v2 + 1, arrayList0);
                        if(topicFragment$ServerDataWrapper1 != null) {
                            integer0 = topicFragment$ServerDataWrapper1.getViewType();
                        }
                        if((integer1 == null || ((ServerDataWrapper)object1).getViewType() != ((int)integer1)) && (integer0 != null && ((ServerDataWrapper)object1).getViewType() == ((int)integer0))) {
                            topicFragment$Location1 = Location.LEFT;
                        }
                        else if(integer1 == null || ((ServerDataWrapper)object1).getViewType() != ((int)integer1) || Location.LEFT != topicFragment$Location0) {
                            topicFragment$Location1 = integer1 == null || ((ServerDataWrapper)object1).getViewType() != ((int)integer1) || Location.RIGHT != topicFragment$Location0 || (integer0 == null || ((ServerDataWrapper)object1).getViewType() != ((int)integer0)) ? Location.FULL : Location.LEFT;
                        }
                        else {
                            topicFragment$Location1 = Location.RIGHT;
                        }
                        ((ServerDataWrapper)object1).setLocation(topicFragment$Location1);
                    }
                    ++v2;
                    continue;
                }
                e.k.O();
                throw null;
            }
            this.addAll(arrayList0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void clearCache(@Nullable String s) {
            TopicFragment.this.mLoadPgnRes = null;
            this.topicInfoRes = null;
            super.clearCache(s);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof cmtList) {
                return 51;
            }
            ServerDataWrapper topicFragment$ServerDataWrapper0 = object0 instanceof ServerDataWrapper ? ((ServerDataWrapper)object0) : null;
            return topicFragment$ServerDataWrapper0 == null ? -1 : topicFragment$ServerDataWrapper0.getViewType();
        }

        @Nullable
        public final TOPICINFO getTopicInfo() {
            RESPONSE artistContentsArtistTopicInfoRes$RESPONSE0 = this.getTopicInfoRes();
            return artistContentsArtistTopicInfoRes$RESPONSE0 == null ? null : artistContentsArtistTopicInfoRes$RESPONSE0.topicInfo;
        }

        @Nullable
        public final RESPONSE getTopicInfoRes() {
            HttpResponse httpResponse0 = this.getResponse();
            ArtistContentsArtistTopicInfoRes artistContentsArtistTopicInfoRes0 = httpResponse0 instanceof ArtistContentsArtistTopicInfoRes ? ((ArtistContentsArtistTopicInfoRes)httpResponse0) : null;
            if(artistContentsArtistTopicInfoRes0 != null) {
                return artistContentsArtistTopicInfoRes0.response == null ? this.topicInfoRes : artistContentsArtistTopicInfoRes0.response;
            }
            return this.topicInfoRes;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable v9.i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ListCmtRes && ((ListCmtRes)httpResponse0).result != null) {
                if(q.b(i0, v9.i.b)) {
                    RESPONSE artistContentsArtistTopicInfoRes$RESPONSE0 = this.getTopicInfoRes();
                    if(artistContentsArtistTopicInfoRes$RESPONSE0 != null) {
                        this.addTopicInfo(artistContentsArtistTopicInfoRes$RESPONSE0);
                    }
                    this.add(new ServerDataWrapper(50, null, null, 4, null));
                }
                ArrayList arrayList0 = ((ListCmtRes)httpResponse0).result.cmtlist;
                String s1 = "";
                boolean z = true;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    CmtResViewModel cmtResViewModel0 = new CmtResViewModel();
                    cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.toplist, TopicFragment.this.mParam.chnlSeq, TopicFragment.this.mParam.contsRefValue, TopicFragment.this.mParam.isReadOnly, TopicFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
                    cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.cmtlist, TopicFragment.this.mParam.chnlSeq, TopicFragment.this.mParam.contsRefValue, TopicFragment.this.mParam.isReadOnly, TopicFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
                    this.addAll(cmtResViewModel0.result.cmtlist);
                    if(((ListCmtRes)httpResponse0).result.pageinfo.pageno >= ((ListCmtRes)httpResponse0).result.paginginfo.nextpageno) {
                        z = false;
                    }
                    this.setHasMore(z);
                    RESPONSE artistContentsArtistTopicInfoRes$RESPONSE1 = this.getTopicInfoRes();
                    if(artistContentsArtistTopicInfoRes$RESPONSE1 != null) {
                        String s2 = artistContentsArtistTopicInfoRes$RESPONSE1.menuId;
                        if(s2 != null) {
                            s1 = s2;
                        }
                    }
                    this.setMenuId(s1);
                    this.updateModifiedTime(s);
                    return false;
                }
                RESPONSE artistContentsArtistTopicInfoRes$RESPONSE2 = this.getTopicInfoRes();
                if(artistContentsArtistTopicInfoRes$RESPONSE2 == null || (artistContentsArtistTopicInfoRes$RESPONSE2.topicInfo == null || !artistContentsArtistTopicInfoRes$RESPONSE2.topicInfo.isCmtAvail)) {
                    z = false;
                }
                this.add(new ServerDataWrapper(52, Boolean.valueOf(z), null, 4, null));
                this.setHasMore(false);
                RESPONSE artistContentsArtistTopicInfoRes$RESPONSE3 = this.getTopicInfoRes();
                if(artistContentsArtistTopicInfoRes$RESPONSE3 != null) {
                    String s3 = artistContentsArtistTopicInfoRes$RESPONSE3.menuId;
                    if(s3 != null) {
                        s1 = s3;
                    }
                }
                this.setMenuId(s1);
                this.updateModifiedTime(s);
                return false;
            }
            if(httpResponse0 instanceof ArtistContentsArtistTopicInfoRes) {
                RESPONSE artistContentsArtistTopicInfoRes$RESPONSE4 = ((ArtistContentsArtistTopicInfoRes)httpResponse0).response;
                if(artistContentsArtistTopicInfoRes$RESPONSE4 != null) {
                    this.addTopicInfo(artistContentsArtistTopicInfoRes$RESPONSE4);
                }
                this.setHasMore(false);
                this.setMenuId(((ArtistContentsArtistTopicInfoRes)httpResponse0).getMenuId());
                this.updateModifiedTime(s);
            }
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            Object object0 = this.getItem(v1);
            if(o00 instanceof HeaderViewHolder) {
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.topic.TopicFragment.ServerDataWrapper");
                Object object1 = ((ServerDataWrapper)object0).getData();
                q.e(object1, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICINFO");
                ((HeaderViewHolder)o00).bind(((TOPICINFO)object1));
                return;
            }
            if(o00 instanceof TopicContentsViewHolder) {
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.topic.TopicFragment.ServerDataWrapper");
                Object object2 = ((ServerDataWrapper)object0).getData();
                q.e(object2, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICCONTENTSLIST");
                ((TopicContentsViewHolder)o00).bind(((TOPICCONTENTSLIST)object2));
                ((TopicContentsViewHolder)o00).setOnViewHolderClickListener(new OnViewHolderClickListener() {
                    @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder$OnViewHolderClickListener
                    public void onPlayClick(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
                        q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
                        if(q.b("T10004", artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.contsTypeCode)) {
                            String s = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.songID;
                            String s1 = TopicFragment.this.getMenuId();
                            TopicFragment.this.playSong(s, s1);
                        }
                    }

                    @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder$OnViewHolderClickListener
                    public void onViewClick(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
                        q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
                        String s = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.contsTypeCode;
                        if(q.b(s, "T10001")) {
                            Navigator.openPhotoUrl(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.imageUrl);
                            return;
                        }
                        if(q.b(s, "T10003")) {
                            Navigator.openMvInfo$default(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.mvID, TopicFragment.this.getMenuId(), null, false, 12, null);
                            return;
                        }
                        if(q.b(s, "T10004")) {
                            Navigator.openAlbumInfo(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.albumID);
                            return;
                        }
                        if(!q.b(s, "T10006") && !q.b(s, "T10007")) {
                            return;
                        }
                        Navigator.openUrl(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkUrl, OpenType.Browser);
                    }
                });
                return;
            }
            if(o00 instanceof TopicCommentHeaderViewHolder) {
                ((TopicCommentHeaderViewHolder)o00).bind();
                return;
            }
            if(o00 instanceof CommentListRenewalViewHolder) {
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList");
                ((CommentListRenewalViewHolder)o00).bindView(((cmtList)object0), v, v1);
                return;
            }
            if(o00 instanceof TopicCommentEmptyViewHolder) {
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.topic.TopicFragment.ServerDataWrapper");
                Object object3 = ((ServerDataWrapper)object0).getData();
                q.e(object3, "null cannot be cast to non-null type kotlin.Boolean");
                ((TopicCommentEmptyViewHolder)o00).bind(((Boolean)object3).booleanValue());
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            int v1 = 0x7F0A0B8D;  // id:title
            if(v != 0) {
                int v2 = 0x7F0A0558;  // id:image
                switch(v) {
                    case 1: {
                        View view0 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A1, viewGroup0, false);  // layout:topic_contents_image
                        View view1 = I.C(view0, 0x7F0A0558);  // id:image
                        if(view1 == null) {
                            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0558));  // id:image
                        }
                        return new TopicContentsImageViewHolder(new k3(((ConstraintLayout)view0), f3.a(view1)));
                    }
                    case 2: {
                        View view2 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A6, viewGroup0, false);  // layout:topic_contents_text
                        MelonTextView melonTextView0 = (MelonTextView)I.C(view2, 0x7F0A0B49);  // id:text
                        if(melonTextView0 == null) {
                            throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(0x7F0A0B49));  // id:text
                        }
                        return new TopicContentsTextViewHolder(new p3(((LinearLayout)view2), melonTextView0));
                    }
                    case 3: {
                        View view3 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A4, viewGroup0, false);  // layout:topic_contents_mv
                        ImageView imageView0 = (ImageView)I.C(view3, 0x7F0A007A);  // id:adultBadge
                        if(imageView0 == null) {
                            v2 = 0x7F0A007A;  // id:adultBadge
                        }
                        else {
                            View view4 = I.C(view3, 0x7F0A0558);  // id:image
                            if(view4 != null) {
                                x x0 = x.c(view4);
                                v2 = 0x7F0A091C;  // id:playTime
                                MelonTextView melonTextView1 = (MelonTextView)I.C(view3, 0x7F0A091C);  // id:playTime
                                if(melonTextView1 != null) {
                                    return new TopicContentsMvViewHolder(new n3(((ConstraintLayout)view3), imageView0, x0, melonTextView1));
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: " + view3.getResources().getResourceName(v2));
                    }
                    case 4: {
                        View view5 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A5, viewGroup0, false);  // layout:topic_contents_song
                        View view6 = I.C(view5, 0x7F0A00B1);  // id:artist
                        if(((MelonTextView)view6) == null) {
                            v2 = 0x7F0A00B1;  // id:artist
                        }
                        else {
                            View view7 = I.C(view5, 0x7F0A00E6);  // id:background
                            if(view7 == null) {
                                v2 = 0x7F0A00E6;  // id:background
                            }
                            else {
                                f3 f30 = f3.a(view7);
                                View view8 = I.C(view5, 0x7F0A0558);  // id:image
                                if(view8 != null) {
                                    f3 f31 = f3.a(view8);
                                    v2 = 0x7F0A091B;  // id:play
                                    View view9 = I.C(view5, 0x7F0A091B);  // id:play
                                    if(((ImageView)view9) != null) {
                                        v2 = 0x7F0A0AA2;  // id:song
                                        View view10 = I.C(view5, 0x7F0A0AA2);  // id:song
                                        if(((MelonTextView)view10) != null) {
                                            o3 o30 = new o3(((ConstraintLayout)view5), ((MelonTextView)view6), f30, f31, ((ImageView)view9), ((MelonTextView)view10));
                                            D d0 = TopicFragment.this.getViewLifecycleOwner();
                                            q.f(d0, "getViewLifecycleOwner(...)");
                                            return new TopicContentsSongViewHolder(o30, TopicFragment.this.blurViewBgMap, d0);
                                        }
                                    }
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(v2));
                    }
                    case 5: {
                        if(ScreenUtils.isTablet(this.getContext())) {
                            View view11 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A3, viewGroup0, false);  // layout:topic_contents_link_tablet
                            View view12 = I.C(view11, 0x7F0A03A2);  // id:desc
                            if(((MelonTextView)view12) == null) {
                                v1 = 0x7F0A03A2;  // id:desc
                            }
                            else {
                                View view13 = I.C(view11, 0x7F0A053E);  // id:host
                                if(((MelonTextView)view13) == null) {
                                    v1 = 0x7F0A053E;  // id:host
                                }
                                else {
                                    View view14 = I.C(view11, 0x7F0A0558);  // id:image
                                    if(((FrameLayout)view14) == null) {
                                        v1 = 0x7F0A0558;  // id:image
                                    }
                                    else {
                                        View view15 = I.C(view11, 0x7F0A05DD);  // id:ivThumb
                                        if(((MelonImageView)view15) == null) {
                                            v1 = 0x7F0A05DD;  // id:ivThumb
                                        }
                                        else {
                                            View view16 = I.C(view11, 0x7F0A0776);  // id:linkText
                                            if(((MelonTextView)view16) == null) {
                                                v1 = 0x7F0A0776;  // id:linkText
                                            }
                                            else {
                                                View view17 = I.C(view11, 0x7F0A08C9);  // id:ogTagLayout
                                                if(((ConstraintLayout)view17) == null) {
                                                    v1 = 0x7F0A08C9;  // id:ogTagLayout
                                                }
                                                else {
                                                    View view18 = I.C(view11, 0x7F0A0AEF);  // id:stroke
                                                    if(view18 == null) {
                                                        v1 = 0x7F0A0AEF;  // id:stroke
                                                    }
                                                    else if(((LinearLayout)I.C(view11, 0x7F0A0B4D)) != null) {  // id:textLayout
                                                        View view19 = I.C(view11, 0x7F0A0B8D);  // id:title
                                                        if(((MelonTextView)view19) != null) {
                                                            return new TopicContentsLinkViewHolder(new m3(((FrameLayout)view11), ((MelonTextView)view12), ((MelonTextView)view13), ((FrameLayout)view14), ((MelonImageView)view15), ((MelonTextView)view16), ((ConstraintLayout)view17), view18, ((MelonTextView)view19)), TopicFragment.this);
                                                        }
                                                    }
                                                    else {
                                                        v1 = 0x7F0A0B4D;  // id:textLayout
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: " + view11.getResources().getResourceName(v1));
                        }
                        View view20 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A2, viewGroup0, false);  // layout:topic_contents_link
                        View view21 = I.C(view20, 0x7F0A03A2);  // id:desc
                        if(((MelonTextView)view21) == null) {
                            v1 = 0x7F0A03A2;  // id:desc
                        }
                        else {
                            View view22 = I.C(view20, 0x7F0A053E);  // id:host
                            if(((MelonTextView)view22) == null) {
                                v1 = 0x7F0A053E;  // id:host
                            }
                            else {
                                View view23 = I.C(view20, 0x7F0A0558);  // id:image
                                if(((FrameLayout)view23) == null) {
                                    v1 = 0x7F0A0558;  // id:image
                                }
                                else {
                                    View view24 = I.C(view20, 0x7F0A05DD);  // id:ivThumb
                                    if(((MelonImageView)view24) == null) {
                                        v1 = 0x7F0A05DD;  // id:ivThumb
                                    }
                                    else {
                                        View view25 = I.C(view20, 0x7F0A0776);  // id:linkText
                                        if(((MelonTextView)view25) == null) {
                                            v1 = 0x7F0A0776;  // id:linkText
                                        }
                                        else {
                                            View view26 = I.C(view20, 0x7F0A08C9);  // id:ogTagLayout
                                            if(((LinearLayout)view26) == null) {
                                                v1 = 0x7F0A08C9;  // id:ogTagLayout
                                            }
                                            else {
                                                View view27 = I.C(view20, 0x7F0A0AEF);  // id:stroke
                                                if(view27 == null) {
                                                    v1 = 0x7F0A0AEF;  // id:stroke
                                                }
                                                else {
                                                    View view28 = I.C(view20, 0x7F0A0B4D);  // id:textLayout
                                                    if(((LinearLayout)view28) == null) {
                                                        v1 = 0x7F0A0B4D;  // id:textLayout
                                                    }
                                                    else {
                                                        View view29 = I.C(view20, 0x7F0A0B8D);  // id:title
                                                        if(((MelonTextView)view29) != null) {
                                                            return new TopicContentsLinkViewHolder(new l3(((FrameLayout)view20), ((MelonTextView)view21), ((MelonTextView)view22), ((FrameLayout)view23), ((MelonImageView)view24), ((MelonTextView)view25), ((LinearLayout)view26), view27, ((LinearLayout)view28), ((MelonTextView)view29)), TopicFragment.this);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: " + view20.getResources().getResourceName(v1));
                    }
                    case 49: {
                        View view30 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A7, viewGroup0, false);  // layout:topic_contents_unsupported
                        MelonTextView melonTextView2 = (MelonTextView)I.C(view30, 0x7F0A0B49);  // id:text
                        if(melonTextView2 == null) {
                            throw new NullPointerException("Missing required view with ID: " + view30.getResources().getResourceName(0x7F0A0B49));  // id:text
                        }
                        return new TopicContentsUnknownViewHolder(new q3(((LinearLayout)view30), melonTextView2));
                    }
                    case 50: {
                        View view31 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A0, viewGroup0, false);  // layout:topic_comment_header
                        int v3 = 0x7F0A034A;  // id:count
                        MelonTextView melonTextView3 = (MelonTextView)I.C(view31, 0x7F0A034A);  // id:count
                        if(melonTextView3 != null) {
                            v3 = 0x7F0A09D6;  // id:refresh
                            ImageButton imageButton0 = (ImageButton)I.C(view31, 0x7F0A09D6);  // id:refresh
                            if(imageButton0 != null) {
                                v3 = 0x7F0A0DF6;  // id:write
                                ImageButton imageButton1 = (ImageButton)I.C(view31, 0x7F0A0DF6);  // id:write
                                if(imageButton1 != null) {
                                    return new TopicCommentHeaderViewHolder(this, new j3(((LinearLayout)view31), melonTextView3, imageButton0, imageButton1));
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: " + view31.getResources().getResourceName(v3));
                    }
                    case 51: {
                        return new CommentListRenewalViewHolder(K1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), TopicFragment.this);
                    }
                    case 52: {
                        View view32 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D089F, viewGroup0, false);  // layout:topic_comment_empty
                        MelonTextView melonTextView4 = (MelonTextView)I.C(view32, 0x7F0A0B49);  // id:text
                        if(melonTextView4 == null) {
                            throw new NullPointerException("Missing required view with ID: " + view32.getResources().getResourceName(0x7F0A0B49));  // id:text
                        }
                        return new TopicCommentEmptyViewHolder(this, new i3(((LinearLayout)view32), melonTextView4));
                    }
                    default: {
                        return null;
                    }
                }
            }
            View view33 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D08A8, viewGroup0, false);  // layout:topic_header
            View view34 = I.C(view33, 0x7F0A01F3);  // id:can_write_time
            if(((MelonTextView)view34) == null) {
                v1 = 0x7F0A01F3;  // id:can_write_time
            }
            else {
                View view35 = I.C(view33, 0x7F0A02EC);  // id:comment
                if(((MelonTextView)view35) == null) {
                    v1 = 0x7F0A02EC;  // id:comment
                }
                else {
                    View view36 = I.C(view33, 0x7F0A037A);  // id:date
                    if(((MelonTextView)view36) == null) {
                        v1 = 0x7F0A037A;  // id:date
                    }
                    else {
                        View view37 = I.C(view33, 0x7F0A0761);  // id:likeButton
                        if(((AlphaControlCheckButton)view37) == null) {
                            v1 = 0x7F0A0761;  // id:likeButton
                        }
                        else {
                            View view38 = I.C(view33, 0x7F0A0762);  // id:likeTv
                            if(((MelonTextView)view38) == null) {
                                v1 = 0x7F0A0762;  // id:likeTv
                            }
                            else {
                                View view39 = I.C(view33, 0x7F0A0A80);  // id:share
                                if(((ImageView)view39) == null) {
                                    v1 = 0x7F0A0A80;  // id:share
                                }
                                else {
                                    View view40 = I.C(view33, 0x7F0A0B8D);  // id:title
                                    if(((MelonTextView)view40) != null) {
                                        return new HeaderViewHolder(this, new r3(((ConstraintLayout)view33), ((MelonTextView)view34), ((MelonTextView)view35), ((MelonTextView)view36), ((AlphaControlCheckButton)view37), ((MelonTextView)view38), ((ImageView)view39), ((MelonTextView)view40)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view33.getResources().getResourceName(v1));
        }

        public final void setTopicInfoRes(@Nullable RESPONSE artistContentsArtistTopicInfoRes$RESPONSE0) {
            this.topicInfoRes = artistContentsArtistTopicInfoRes$RESPONSE0;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001A\u00020\u00112\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment$TopicItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/topic/TopicFragment;)V", "", "currentViewType", "underViewType", "getBottomMargin", "(II)I", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TopicItemDecoration extends r0 {
        private final int getBottomMargin(int v, int v1) {
            if(v1 == 50) {
                return ScreenUtils.dipToPixel(TopicFragment.this.getContext(), 40.0f);
            }
            return v1 == v ? ScreenUtils.dipToPixel(TopicFragment.this.getContext(), 12.0f) : ScreenUtils.dipToPixel(TopicFragment.this.getContext(), 30.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            float f = 20.0f;
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            j0 j00 = recyclerView0.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.topic.TopicFragment.TopicAdapter");
            int v = recyclerView0.getChildAdapterPosition(view0);
            int v1 = ((TopicAdapter)j00).getItemViewType(v);
            if(v1 > 49) {
                return;
            }
            if(ScreenUtils.isTablet(TopicFragment.this.getContext())) {
                Object object0 = ((TopicAdapter)j00).getItem(v);
                Location topicFragment$Location0 = null;
                ServerDataWrapper topicFragment$ServerDataWrapper0 = object0 instanceof ServerDataWrapper ? ((ServerDataWrapper)object0) : null;
                if(topicFragment$ServerDataWrapper0 != null) {
                    topicFragment$Location0 = topicFragment$ServerDataWrapper0.getLocation();
                }
                rect0.left = ScreenUtils.dipToPixel(TopicFragment.this.getContext(), (topicFragment$Location0 == Location.RIGHT ? 6.0f : 20.0f));
                Context context0 = TopicFragment.this.getContext();
                Location topicFragment$Location1 = Location.LEFT;
                if(topicFragment$Location0 == topicFragment$Location1) {
                    f = 6.0f;
                }
                rect0.right = ScreenUtils.dipToPixel(context0, f);
                rect0.bottom = this.getBottomMargin(v1, ((TopicAdapter)j00).getItemViewType((topicFragment$Location0 == topicFragment$Location1 ? v + 2 : v + 1)));
                return;
            }
            int v2 = ScreenUtils.dipToPixel(TopicFragment.this.getContext(), 20.0f);
            rect0.left = v2;
            rect0.right = v2;
            rect0.bottom = this.getBottomMargin(v1, ((TopicAdapter)j00).getItemViewType(v + 1));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TopicFragment";
    private static final int VIEW_TYPE_COMMENT = 51;
    private static final int VIEW_TYPE_COMMENT_EMPTY = 52;
    private static final int VIEW_TYPE_COMMENT_HEADER = 50;
    private static final int VIEW_TYPE_CONTENTS_IMAGE = 1;
    private static final int VIEW_TYPE_CONTENTS_LINK = 5;
    private static final int VIEW_TYPE_CONTENTS_MV = 3;
    private static final int VIEW_TYPE_CONTENTS_SONG = 4;
    private static final int VIEW_TYPE_CONTENTS_TEXT = 2;
    private static final int VIEW_TYPE_CONTENTS_UNSUPPORTED = 49;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_UNKNOWN = -1;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private final Map blurViewBgMap;
    private int cmtAllCount;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    @NotNull
    private final OnCmtRemoveListener mOnCmtRemoveListener;
    private int nextPageNo;
    @NotNull
    private String topicSeq;

    static {
        TopicFragment.Companion = new Companion(null);
        TopicFragment.$stable = 8;
    }

    public TopicFragment() {
        this.artistId = "";
        this.topicSeq = "";
        this.nextPageNo = 1;
        this.cmtAllCount = -1;
        this.artistName = "";
        this.blurViewBgMap = new LinkedHashMap();
        this.exceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                LogU.Companion.e("TopicFragment", "onFetchStart() error, exceptionHandler " + throwable0.getMessage());
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.exceptionHandler.1.1(throwable0, TopicFragment.this, null), 3, null);
            }
        };
        this.mOnCmtRemoveListener = new OnCmtRemoveListener() {
            @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment$OnCmtRemoveListener
            public void onDataChanged() {
            }

            @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment$OnCmtRemoveListener
            public void onRemoveItem() {
                TopicFragment.access$updateCmtAllCount(TopicFragment.this, TopicFragment.access$getCmtAllCount$p(TopicFragment.this) - 1);
                if(TopicFragment.access$getCmtAllCount$p(TopicFragment.this) <= 0) {
                    j0 j00 = TopicFragment.this.getAdapter();
                    TopicAdapter topicFragment$TopicAdapter0 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
                    if(topicFragment$TopicAdapter0 != null) {
                        TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 = topicFragment$TopicAdapter0.getTopicInfo();
                        topicFragment$TopicAdapter0.add(new ServerDataWrapper(52, Boolean.valueOf((artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 == null ? false : artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.isCmtAvail)), null, 4, null));
                        topicFragment$TopicAdapter0.notifyDataSetChanged();
                    }
                }
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.artistchannel.topic.TopicFragment$exceptionHandler$1$1", f = "TopicFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.artistchannel.topic.TopicFragment.exceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.artistchannel.topic.TopicFragment.exceptionHandler.1.1(Throwable throwable0, TopicFragment topicFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                TopicFragment.this = topicFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.exceptionHandler.1.1(this.$throwable, TopicFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.exceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    TopicFragment.access$getMResponseErrorListener$p$s-416897921(TopicFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                    TitleBar titleBar0 = TopicFragment.access$getTitleBar(TopicFragment.this);
                    if(titleBar0 != null) {
                        titleBar0.setVisibility(8);
                    }
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s-416897921(TopicFragment topicFragment0) {
        return topicFragment0.mResponseErrorListener;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment
    public void contentsItemClickLog(@Nullable ActionKind actionKind0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        if(q.b(s, (this.getContext() == null ? null : "프로필"))) {
            p8.f f0 = this.getTiaraEventBuilder();
            if(f0 != null) {
                f0.e = s1;
                f0.h = s3;
                f0.a().track();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new TopicAdapter(this, context0, null);
    }

    private final p8.f getBaseTiaraLogEventBuilder() {
        p8.f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        f0.I = this.getMenuId();
        s s0 = this.mMelonTiaraProperty;
        String s1 = null;
        f0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        f0.c = s1;
        f0.o = this.artistId;
        f0.p = this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
        f0.q = this.artistName;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.T0.buildUpon().appendPath(this.artistId), this.topicSeq, "toString(...)");
    }

    private final me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public Sharable getSNSSharable() {
        ShareLinkData shareLinkData0;
        String s1;
        String s;
        j0 j00 = this.getAdapter();
        TopicAdapter topicFragment$TopicAdapter0 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
        if(topicFragment$TopicAdapter0 == null) {
            s = null;
        }
        else {
            TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 = topicFragment$TopicAdapter0.getTopicInfo();
            s = artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 == null ? null : artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.title;
        }
        if(topicFragment$TopicAdapter0 == null) {
            s1 = null;
        }
        else {
            RESPONSE artistContentsArtistTopicInfoRes$RESPONSE0 = topicFragment$TopicAdapter0.getTopicInfoRes();
            if(artistContentsArtistTopicInfoRes$RESPONSE0 == null) {
                s1 = null;
            }
            else {
                ARTISTINFO artistContentsArtistTopicInfoRes$RESPONSE$ARTISTINFO0 = artistContentsArtistTopicInfoRes$RESPONSE0.artistInfo;
                s1 = artistContentsArtistTopicInfoRes$RESPONSE$ARTISTINFO0 == null ? null : artistContentsArtistTopicInfoRes$RESPONSE$ARTISTINFO0.artistImg;
            }
        }
        if(topicFragment$TopicAdapter0 == null) {
            shareLinkData0 = null;
        }
        else {
            RESPONSE artistContentsArtistTopicInfoRes$RESPONSE1 = topicFragment$TopicAdapter0.getTopicInfoRes();
            shareLinkData0 = artistContentsArtistTopicInfoRes$RESPONSE1 == null ? null : artistContentsArtistTopicInfoRes$RESPONSE1.snsInfo;
        }
        Sharable sharable0 = new SharableTopic();  // 初始化器: Ljava/lang/Object;-><init>()V
        sharable0.a = null;
        sharable0.b = null;
        sharable0.d = s;
        sharable0.e = s1;
        sharable0.f = shareLinkData0;
        return sharable0;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment
    @Nullable
    public p8.f getTiaraEventBuilder() {
        if(i.l(this.mMelonTiaraProperty)) {
            p8.f f0 = this.getBaseTiaraLogEventBuilder();
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130D14);  // string:tiara_click_copy_comment "댓글"
            return f0;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public boolean isHeaderParallaxEnabled() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment
    public void itemClickLog(@Nullable String s, @Nullable ActionKind actionKind0, @Nullable String s1, @Nullable String s2, boolean z, @Nullable String s3, @Nullable String s4, @Nullable String s5) {
        p8.f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            if(ActionKind.Like == actionKind0) {
                f0.F = this.getString((z ? 0x7F130D8B : 0x7F130D61));  // string:tiara_click_copy_recommend "추천"
                f0.e = s3;
                f0.a().track();
                return;
            }
            if(q.b(this.getString(0x7F130D17), s2) || q.b(this.getString(0x7F130D54), s2)) {  // string:tiara_click_copy_comment_reply "답글"
                f0.F = s2;
                f0.e = s3;
                f0.a().track();
            }
        }
    }

    @NotNull
    public static final TopicFragment newInstance(@NotNull String s, @NotNull String s1) {
        return TopicFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        LinearLayoutManager linearLayoutManager0;
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        j0 j00 = this.mAdapter;
        if(j00 != null) {
            RecyclerView recyclerView0 = this.getRecyclerView();
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(j00);
            }
        }
        RecyclerView recyclerView1 = this.getRecyclerView();
        if(recyclerView1 != null) {
            if(ScreenUtils.isTablet(this.getContext())) {
                linearLayoutManager0 = new GridLayoutManager(this.getContext(), 2);
                linearLayoutManager0.g = new androidx.recyclerview.widget.H() {
                    @Override  // androidx.recyclerview.widget.H
                    public int getSpanSize(int v) {
                        j0 j00 = TopicFragment.this.getAdapter();
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.topic.TopicFragment.TopicAdapter");
                        Object object0 = ((TopicAdapter)j00).getItem(v);
                        Location topicFragment$Location0 = null;
                        ServerDataWrapper topicFragment$ServerDataWrapper0 = object0 instanceof ServerDataWrapper ? ((ServerDataWrapper)object0) : null;
                        if(topicFragment$ServerDataWrapper0 != null) {
                            topicFragment$Location0 = topicFragment$ServerDataWrapper0.getLocation();
                        }
                        return Location.LEFT == topicFragment$Location0 || Location.RIGHT == topicFragment$Location0 ? 1 : 2;
                    }
                };
            }
            else {
                linearLayoutManager0 = new LinearLayoutManager(this.getContext());
            }
            recyclerView1.setLayoutManager(linearLayoutManager0);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        LinearLayoutManager linearLayoutManager0;
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        if(ScreenUtils.isTablet(((RecyclerView)view0).getContext())) {
            linearLayoutManager0 = new GridLayoutManager(((RecyclerView)view0).getContext(), 2);
            linearLayoutManager0.g = new androidx.recyclerview.widget.H() {
                @Override  // androidx.recyclerview.widget.H
                public int getSpanSize(int v) {
                    j0 j00 = this.$this_apply.getAdapter();
                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.topic.TopicFragment.TopicAdapter");
                    Object object0 = ((TopicAdapter)j00).getItem(v);
                    Location topicFragment$Location0 = null;
                    ServerDataWrapper topicFragment$ServerDataWrapper0 = object0 instanceof ServerDataWrapper ? ((ServerDataWrapper)object0) : null;
                    if(topicFragment$ServerDataWrapper0 != null) {
                        topicFragment$Location0 = topicFragment$ServerDataWrapper0.getLocation();
                    }
                    return Location.LEFT == topicFragment$Location0 || Location.RIGHT == topicFragment$Location0 ? 1 : 2;
                }
            };
        }
        else {
            linearLayoutManager0 = new LinearLayoutManager(((RecyclerView)view0).getContext());
        }
        ((RecyclerView)view0).setLayoutManager(linearLayoutManager0);
        ((RecyclerView)view0).setHasFixedSize(false);
        ((RecyclerView)view0).addItemDecoration(new LastItemSpacingDecoration());
        ((RecyclerView)view0).addItemDecoration(new TopicItemDecoration(this));
        ((RecyclerView)view0).addOnScrollListener(new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                q.g(recyclerView0, "recyclerView");
                if(TopicFragment.this.isFragmentVisible) {
                    w0 w00 = recyclerView0.getLayoutManager();
                    LinearLayoutManager linearLayoutManager0 = w00 instanceof LinearLayoutManager ? ((LinearLayoutManager)w00) : null;
                    if(linearLayoutManager0 != null) {
                        boolean z = linearLayoutManager0.findFirstCompletelyVisibleItemPosition() != 0 || v1 > 0;
                        TopicFragment.this.showScrolledLine(z);
                    }
                }
            }
        });
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02C6, viewGroup0, false);  // layout:fragment_topic
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        LogU.Companion.d("TopicFragment", "onFetchStart reason : " + s);
        if(v9.i.b.equals(i0)) {
            j0 j00 = this.getAdapter();
            TopicAdapter topicFragment$TopicAdapter0 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
            if(topicFragment$TopicAdapter0 != null) {
                topicFragment$TopicAdapter0.clear();
            }
        }
        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.getCoroutineContext()), completableJob0.plus(this.exceptionHandler), null, new n(this, completableJob0, null) {
            final CompletableJob $supervisor;
            final v9.i $type;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            {
                this.$type = i0;
                TopicFragment.this = topicFragment0;
                this.$supervisor = completableJob0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1(this.$type, TopicFragment.this, this.$supervisor, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                kotlin.jvm.internal.H h13;
                kotlin.jvm.internal.H h12;
                kotlin.jvm.internal.H h11;
                kotlin.jvm.internal.H h10;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        kotlin.jvm.internal.H h5 = H0.b.p(object0);
                        kotlin.jvm.internal.H h6 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        kotlin.jvm.internal.H h7 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        kotlin.jvm.internal.H h8 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        kotlin.jvm.internal.H h9 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        Job job0 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(h5, TopicFragment.this, h9, h6, h7, h8, null) {
                            final kotlin.jvm.internal.H $likeAndCmtRes;
                            final kotlin.jvm.internal.H $listCmtRes;
                            final kotlin.jvm.internal.H $loadPgnRes;
                            final kotlin.jvm.internal.H $topicInfoRes;
                            final v9.i $type;
                            final kotlin.jvm.internal.H $userActionRes;
                            private Object L$0;
                            Object L$1;
                            int label;

                            {
                                this.$type = i0;
                                this.$topicInfoRes = h0;
                                TopicFragment.this = topicFragment0;
                                this.$userActionRes = h1;
                                this.$likeAndCmtRes = h2;
                                this.$loadPgnRes = h3;
                                this.$listCmtRes = h4;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1(this.$type, this.$topicInfoRes, TopicFragment.this, this.$userActionRes, this.$likeAndCmtRes, this.$loadPgnRes, this.$listCmtRes, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                kotlin.jvm.internal.H h1;
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        if(v9.i.b.equals(this.$type)) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(TopicFragment.this, null) {
                                                final kotlin.jvm.internal.H $userActionRes;
                                                private Object L$0;
                                                Object L$1;
                                                int label;

                                                {
                                                    this.$userActionRes = h0;
                                                    TopicFragment.this = topicFragment0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1.1(this.$userActionRes, TopicFragment.this, continuation0);
                                                    continuation1.L$0 = object0;
                                                    return continuation1;
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    kotlin.jvm.internal.H h1;
                                                    CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                                    ne.a a0 = ne.a.a;
                                                    switch(this.label) {
                                                        case 0: {
                                                            d5.n.D(object0);
                                                            kotlin.jvm.internal.H h0 = this.$userActionRes;
                                                            Deferred deferred0 = TopicFragment.this.requestUserActionAsync(coroutineScope0);
                                                            this.L$0 = null;
                                                            this.L$1 = h0;
                                                            this.label = 1;
                                                            Object object1 = deferred0.await(this);
                                                            if(object1 == a0) {
                                                                return a0;
                                                            }
                                                            h1 = h0;
                                                            object0 = object1;
                                                            break;
                                                        }
                                                        case 1: {
                                                            h1 = (kotlin.jvm.internal.H)this.L$1;
                                                            d5.n.D(object0);
                                                            break;
                                                        }
                                                        default: {
                                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                        }
                                                    }
                                                    h1.a = object0;
                                                    return H.a;
                                                }
                                            }, 3, null).start();
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(TopicFragment.this, null) {
                                                final kotlin.jvm.internal.H $likeAndCmtRes;
                                                private Object L$0;
                                                Object L$1;
                                                int label;

                                                {
                                                    this.$likeAndCmtRes = h0;
                                                    TopicFragment.this = topicFragment0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1.2(this.$likeAndCmtRes, TopicFragment.this, continuation0);
                                                    continuation1.L$0 = object0;
                                                    return continuation1;
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    kotlin.jvm.internal.H h1;
                                                    CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                                    ne.a a0 = ne.a.a;
                                                    switch(this.label) {
                                                        case 0: {
                                                            d5.n.D(object0);
                                                            kotlin.jvm.internal.H h0 = this.$likeAndCmtRes;
                                                            Deferred deferred0 = TopicFragment.this.requestLikeAndCmtAsync(coroutineScope0);
                                                            this.L$0 = null;
                                                            this.L$1 = h0;
                                                            this.label = 1;
                                                            Object object1 = deferred0.await(this);
                                                            if(object1 == a0) {
                                                                return a0;
                                                            }
                                                            h1 = h0;
                                                            object0 = object1;
                                                            break;
                                                        }
                                                        case 1: {
                                                            h1 = (kotlin.jvm.internal.H)this.L$1;
                                                            d5.n.D(object0);
                                                            break;
                                                        }
                                                        default: {
                                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                        }
                                                    }
                                                    h1.a = object0;
                                                    return H.a;
                                                }
                                            }, 3, null).start();
                                            kotlin.jvm.internal.H h0 = this.$topicInfoRes;
                                            Deferred deferred0 = TopicFragment.this.requestTopicInfoAsync(coroutineScope0);
                                            this.L$0 = coroutineScope0;
                                            this.L$1 = h0;
                                            this.label = 1;
                                            Object object1 = deferred0.await(this);
                                            if(object1 == a0) {
                                                return a0;
                                            }
                                            h1 = h0;
                                            object0 = object1;
                                            goto label_21;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        h1 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                    label_21:
                                        h1.a = object0;
                                        ArtistContentsArtistTopicInfoRes artistContentsArtistTopicInfoRes0 = (ArtistContentsArtistTopicInfoRes)this.$topicInfoRes.a;
                                        if(artistContentsArtistTopicInfoRes0 != null) {
                                            RESPONSE artistContentsArtistTopicInfoRes$RESPONSE0 = artistContentsArtistTopicInfoRes0.response;
                                            if(artistContentsArtistTopicInfoRes$RESPONSE0 != null) {
                                                Param cmtBaseFragment$Param0 = TopicFragment.this.mParam;
                                                if(cmtBaseFragment$Param0 != null) {
                                                    cmtBaseFragment$Param0.chnlSeq = ProtocolUtils.parseInt(artistContentsArtistTopicInfoRes$RESPONSE0.topicChnlSeq, 0);
                                                    cmtBaseFragment$Param0.contsRefValue = artistContentsArtistTopicInfoRes$RESPONSE0.topicInfo.topicSeq;
                                                    cmtBaseFragment$Param0.isReadOnly = false;
                                                    cmtBaseFragment$Param0.theme = c.c;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(this.$loadPgnRes, TopicFragment.this, this.$listCmtRes, null) {
                                    final kotlin.jvm.internal.H $listCmtRes;
                                    final kotlin.jvm.internal.H $loadPgnRes;
                                    final v9.i $type;
                                    private Object L$0;
                                    Object L$1;
                                    int label;

                                    {
                                        this.$type = i0;
                                        this.$loadPgnRes = h0;
                                        TopicFragment.this = topicFragment0;
                                        this.$listCmtRes = h1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1.4(this.$type, this.$loadPgnRes, TopicFragment.this, this.$listCmtRes, continuation0);
                                        continuation1.L$0 = object0;
                                        return continuation1;
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.1.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        kotlin.jvm.internal.H h3;
                                        kotlin.jvm.internal.H h1;
                                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                        ne.a a0 = ne.a.a;
                                        H h0 = H.a;
                                        int v = 1;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                if(q.b(this.$type, v9.i.b)) {
                                                    h1 = this.$loadPgnRes;
                                                    Deferred deferred0 = TopicFragment.this.requestLoadPgnAsync(coroutineScope0);
                                                    this.L$0 = coroutineScope0;
                                                    this.L$1 = h1;
                                                    this.label = 1;
                                                    object0 = deferred0.await(this);
                                                    if(object0 == a0) {
                                                        return a0;
                                                    }
                                                    goto label_18;
                                                }
                                                else {
                                                    goto label_31;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                h1 = (kotlin.jvm.internal.H)this.L$1;
                                                d5.n.D(object0);
                                            label_18:
                                                h1.a = object0;
                                                Object object1 = this.$loadPgnRes.a;
                                                if((((LoadPgnRes)object1) == null ? null : ((LoadPgnRes)object1).result) != null && ((LoadPgnRes)object1) != null && ((LoadPgnRes)object1).isSuccessful()) {
                                                    TopicFragment.this.mLoadPgnRes = (LoadPgnRes)this.$loadPgnRes.a;
                                                    TopicFragment topicFragment0 = TopicFragment.this;
                                                    LoadPgnRes loadPgnRes0 = topicFragment0.mLoadPgnRes;
                                                    if(loadPgnRes0 != null) {
                                                        result loadPgnRes$result0 = loadPgnRes0.result;
                                                        if(loadPgnRes$result0 != null) {
                                                            PAGINGINFO loadPgnRes$result$PAGINGINFO0 = loadPgnRes$result0.paginginfo;
                                                            if(loadPgnRes$result$PAGINGINFO0 != null) {
                                                                v = loadPgnRes$result$PAGINGINFO0.firstpageno;
                                                            }
                                                        }
                                                    }
                                                    topicFragment0.nextPageNo = v;
                                                label_31:
                                                    kotlin.jvm.internal.H h2 = this.$listCmtRes;
                                                    Deferred deferred1 = TopicFragment.this.requestListCmtAsync(coroutineScope0);
                                                    this.L$0 = null;
                                                    this.L$1 = h2;
                                                    this.label = 2;
                                                    Object object2 = deferred1.await(this);
                                                    if(object2 == a0) {
                                                        return a0;
                                                    }
                                                    h3 = h2;
                                                    object0 = object2;
                                                    break;
                                                }
                                                return h0;
                                            }
                                            case 2: {
                                                h3 = (kotlin.jvm.internal.H)this.L$1;
                                                d5.n.D(object0);
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        h3.a = object0;
                                        return h0;
                                    }
                                }, 3, null).start();
                                return H.a;
                            }
                        }, 3, null);
                        this.L$0 = null;
                        this.L$1 = h5;
                        this.L$2 = h6;
                        this.L$3 = null;
                        this.L$4 = h8;
                        this.L$5 = h9;
                        this.label = 1;
                        if(job0.join(this) == a0) {
                            return a0;
                        }
                        h10 = h8;
                        h11 = h6;
                        h12 = h5;
                        h13 = h9;
                        break;
                    }
                    case 1: {
                        kotlin.jvm.internal.H h14 = (kotlin.jvm.internal.H)this.L$5;
                        kotlin.jvm.internal.H h15 = (kotlin.jvm.internal.H)this.L$4;
                        kotlin.jvm.internal.H h16 = (kotlin.jvm.internal.H)this.L$3;
                        kotlin.jvm.internal.H h17 = (kotlin.jvm.internal.H)this.L$2;
                        kotlin.jvm.internal.H h18 = (kotlin.jvm.internal.H)this.L$1;
                        d5.n.D(object0);
                        h13 = h14;
                        h10 = h15;
                        h11 = h17;
                        h12 = h18;
                        break;
                    }
                    case 2: {
                        kotlin.jvm.internal.H h0 = (kotlin.jvm.internal.H)this.L$5;
                        kotlin.jvm.internal.H h1 = (kotlin.jvm.internal.H)this.L$4;
                        kotlin.jvm.internal.H h2 = (kotlin.jvm.internal.H)this.L$3;
                        kotlin.jvm.internal.H h3 = (kotlin.jvm.internal.H)this.L$2;
                        kotlin.jvm.internal.H h4 = (kotlin.jvm.internal.H)this.L$1;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.2 topicFragment$onFetchStart$1$20 = new n(TopicFragment.this, h12, this.$supervisor, h10, h11, h13, null) {
                    final kotlin.jvm.internal.H $likeAndCmtRes;
                    final kotlin.jvm.internal.H $listCmtRes;
                    final CompletableJob $supervisor;
                    final kotlin.jvm.internal.H $topicInfoRes;
                    final v9.i $type;
                    final kotlin.jvm.internal.H $userActionRes;
                    int label;

                    {
                        this.$type = i0;
                        TopicFragment.this = topicFragment0;
                        this.$topicInfoRes = h0;
                        this.$supervisor = completableJob0;
                        this.$listCmtRes = h1;
                        this.$likeAndCmtRes = h2;
                        this.$userActionRes = h3;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.2(this.$type, TopicFragment.this, this.$topicInfoRes, this.$supervisor, this.$listCmtRes, this.$likeAndCmtRes, this.$userActionRes, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.onFetchStart.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        boolean z1;
                        String s2;
                        USERACTIONINFO artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO0;
                        String s1;
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        boolean z = q.b(this.$type, v9.i.b);
                        H h0 = H.a;
                        int v = 0;
                        int v1 = 1;
                        com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result0 = null;
                        if(z) {
                            if(TopicFragment.this.prepareFetchComplete(((HttpResponse)this.$topicInfoRes.a))) {
                                ArtistContentsArtistTopicInfoRes artistContentsArtistTopicInfoRes0 = (ArtistContentsArtistTopicInfoRes)this.$topicInfoRes.a;
                                if((artistContentsArtistTopicInfoRes0 == null ? null : artistContentsArtistTopicInfoRes0.response) != null) {
                                    TitleBar titleBar0 = TopicFragment.this.getTitleBar();
                                    if(titleBar0 != null) {
                                        titleBar0.setVisibility(0);
                                    }
                                    ArtistContentsArtistTopicInfoRes artistContentsArtistTopicInfoRes1 = (ArtistContentsArtistTopicInfoRes)this.$topicInfoRes.a;
                                    if(artistContentsArtistTopicInfoRes1 != null) {
                                        RESPONSE artistContentsArtistTopicInfoRes$RESPONSE0 = artistContentsArtistTopicInfoRes1.response;
                                        if(artistContentsArtistTopicInfoRes$RESPONSE0 != null) {
                                            TopicFragment topicFragment0 = TopicFragment.this;
                                            kotlin.jvm.internal.H h1 = this.$likeAndCmtRes;
                                            kotlin.jvm.internal.H h2 = this.$userActionRes;
                                            ARTISTINFO artistContentsArtistTopicInfoRes$RESPONSE$ARTISTINFO0 = artistContentsArtistTopicInfoRes$RESPONSE0.artistInfo;
                                            String s = "";
                                            if(artistContentsArtistTopicInfoRes$RESPONSE$ARTISTINFO0 == null) {
                                                s1 = "";
                                            }
                                            else {
                                                s1 = artistContentsArtistTopicInfoRes$RESPONSE$ARTISTINFO0.artistName;
                                                if(s1 == null) {
                                                    s1 = "";
                                                }
                                            }
                                            topicFragment0.artistName = s1;
                                            topicFragment0.mMelonTiaraProperty = new s(artistContentsArtistTopicInfoRes$RESPONSE0.section, artistContentsArtistTopicInfoRes$RESPONSE0.page, topicFragment0.getMenuId(), null);
                                            TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 = artistContentsArtistTopicInfoRes$RESPONSE0.topicInfo;
                                            if(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 != null) {
                                                ArtistContentsInfoLikeAndCmtRes artistContentsInfoLikeAndCmtRes0 = (ArtistContentsInfoLikeAndCmtRes)h1.a;
                                                if(artistContentsInfoLikeAndCmtRes0 == null) {
                                                    artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO0 = null;
                                                }
                                                else {
                                                    com.iloen.melon.net.v6x.response.ArtistContentsInfoLikeAndCmtRes.RESPONSE artistContentsInfoLikeAndCmtRes$RESPONSE0 = artistContentsInfoLikeAndCmtRes0.response;
                                                    artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO0 = artistContentsInfoLikeAndCmtRes$RESPONSE0 == null ? null : artistContentsInfoLikeAndCmtRes$RESPONSE0.userActionInfo;
                                                }
                                                if(i.l(artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO0)) {
                                                    ArtistContentsInfoLikeAndCmtRes artistContentsInfoLikeAndCmtRes1 = (ArtistContentsInfoLikeAndCmtRes)h1.a;
                                                    if(artistContentsInfoLikeAndCmtRes1 != null) {
                                                        j.b(artistContentsInfoLikeAndCmtRes1.notification, false, 2);
                                                        if(j.d(artistContentsInfoLikeAndCmtRes1)) {
                                                            ArtistContentsInfoLikeAndCmtRes artistContentsInfoLikeAndCmtRes2 = (ArtistContentsInfoLikeAndCmtRes)h1.a;
                                                            if(artistContentsInfoLikeAndCmtRes2 == null) {
                                                                s2 = "";
                                                            }
                                                            else {
                                                                com.iloen.melon.net.v6x.response.ArtistContentsInfoLikeAndCmtRes.RESPONSE artistContentsInfoLikeAndCmtRes$RESPONSE1 = artistContentsInfoLikeAndCmtRes2.response;
                                                                if(artistContentsInfoLikeAndCmtRes$RESPONSE1 == null) {
                                                                    s2 = "";
                                                                }
                                                                else {
                                                                    USERACTIONINFO artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO1 = artistContentsInfoLikeAndCmtRes$RESPONSE1.userActionInfo;
                                                                    if(artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO1 == null) {
                                                                        s2 = "";
                                                                    }
                                                                    else {
                                                                        s2 = artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO1.likeCnt;
                                                                        if(s2 == null) {
                                                                            s2 = "";
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.likeCnt = s2;
                                                            if(artistContentsInfoLikeAndCmtRes2 != null) {
                                                                com.iloen.melon.net.v6x.response.ArtistContentsInfoLikeAndCmtRes.RESPONSE artistContentsInfoLikeAndCmtRes$RESPONSE2 = artistContentsInfoLikeAndCmtRes2.response;
                                                                if(artistContentsInfoLikeAndCmtRes$RESPONSE2 != null) {
                                                                    USERACTIONINFO artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO2 = artistContentsInfoLikeAndCmtRes$RESPONSE2.userActionInfo;
                                                                    if(artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO2 != null) {
                                                                        String s3 = artistContentsInfoLikeAndCmtRes$RESPONSE$USERACTIONINFO2.totalCmtCnt;
                                                                        if(s3 != null) {
                                                                            s = s3;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.totalCmtCnt = s;
                                                        }
                                                    }
                                                }
                                                UserActionsRes userActionsRes0 = (UserActionsRes)h2.a;
                                                if(userActionsRes0 == null || (userActionsRes0.response == null || !userActionsRes0.response.isLike())) {
                                                    z1 = false;
                                                }
                                                else {
                                                    UserActionsRes userActionsRes1 = (UserActionsRes)h2.a;
                                                    if(userActionsRes1 == null) {
                                                        z1 = false;
                                                    }
                                                    else {
                                                        j.b(userActionsRes1.notification, false, 2);
                                                        z1 = j.d(userActionsRes1);
                                                    }
                                                }
                                                artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.isLike = z1;
                                            }
                                        }
                                    }
                                    ListCmtRes listCmtRes0 = (ListCmtRes)this.$listCmtRes.a;
                                    if((listCmtRes0 == null ? null : listCmtRes0.result) != null && listCmtRes0 != null && listCmtRes0.isSuccessful()) {
                                        TopicFragment topicFragment1 = TopicFragment.this;
                                        ListCmtRes listCmtRes1 = (ListCmtRes)this.$listCmtRes.a;
                                        if(listCmtRes1 != null) {
                                            com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result1 = listCmtRes1.result;
                                            if(listCmtRes$result1 != null) {
                                                PAGEINFO listCmtRes$result$PAGEINFO0 = listCmtRes$result1.pageinfo;
                                                if(listCmtRes$result$PAGEINFO0 != null) {
                                                    v = listCmtRes$result$PAGEINFO0.validcnt;
                                                }
                                            }
                                        }
                                        topicFragment1.updateCmtAllCount(v);
                                        TopicFragment topicFragment2 = TopicFragment.this;
                                        ListCmtRes listCmtRes2 = (ListCmtRes)this.$listCmtRes.a;
                                        if(listCmtRes2 != null) {
                                            com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result2 = listCmtRes2.result;
                                            if(listCmtRes$result2 != null) {
                                                com.iloen.melon.net.v3x.comments.ListCmtRes.result.PAGINGINFO listCmtRes$result$PAGINGINFO0 = listCmtRes$result2.paginginfo;
                                                if(listCmtRes$result$PAGINGINFO0 != null) {
                                                    v1 = listCmtRes$result$PAGINGINFO0.nextpageno;
                                                }
                                            }
                                        }
                                        topicFragment2.nextPageNo = v1;
                                        j0 j00 = TopicFragment.this.getAdapter();
                                        TopicAdapter topicFragment$TopicAdapter0 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
                                        if(topicFragment$TopicAdapter0 != null) {
                                            ArtistContentsArtistTopicInfoRes artistContentsArtistTopicInfoRes2 = (ArtistContentsArtistTopicInfoRes)this.$topicInfoRes.a;
                                            if(artistContentsArtistTopicInfoRes2 != null) {
                                                listCmtRes$result0 = artistContentsArtistTopicInfoRes2.response;
                                            }
                                            topicFragment$TopicAdapter0.setTopicInfoRes(((RESPONSE)listCmtRes$result0));
                                        }
                                        TopicFragment.this.performFetchComplete(((HttpResponse)this.$listCmtRes.a));
                                        return h0;
                                    }
                                    TopicFragment.this.performFetchComplete(((HttpResponse)this.$topicInfoRes.a));
                                    return h0;
                                }
                            }
                            TitleBar titleBar1 = TopicFragment.this.getTitleBar();
                            if(titleBar1 != null) {
                                titleBar1.setVisibility(8);
                            }
                            DefaultImpls.cancel$default(this.$supervisor, null, 1, null);
                            return h0;
                        }
                        ListCmtRes listCmtRes3 = (ListCmtRes)this.$listCmtRes.a;
                        if(listCmtRes3 != null) {
                            listCmtRes$result0 = listCmtRes3.result;
                        }
                        if(listCmtRes$result0 != null && listCmtRes3 != null && listCmtRes3.isSuccessful()) {
                            TopicFragment topicFragment3 = TopicFragment.this;
                            ListCmtRes listCmtRes4 = (ListCmtRes)this.$listCmtRes.a;
                            if(listCmtRes4 != null) {
                                com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result3 = listCmtRes4.result;
                                if(listCmtRes$result3 != null) {
                                    PAGEINFO listCmtRes$result$PAGEINFO1 = listCmtRes$result3.pageinfo;
                                    if(listCmtRes$result$PAGEINFO1 != null) {
                                        v = listCmtRes$result$PAGEINFO1.validcnt;
                                    }
                                }
                            }
                            topicFragment3.updateCmtAllCount(v);
                            TopicFragment topicFragment4 = TopicFragment.this;
                            ListCmtRes listCmtRes5 = (ListCmtRes)this.$listCmtRes.a;
                            if(listCmtRes5 != null) {
                                com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result4 = listCmtRes5.result;
                                if(listCmtRes$result4 != null) {
                                    com.iloen.melon.net.v3x.comments.ListCmtRes.result.PAGINGINFO listCmtRes$result$PAGINGINFO1 = listCmtRes$result4.paginginfo;
                                    if(listCmtRes$result$PAGINGINFO1 != null) {
                                        v1 = listCmtRes$result$PAGINGINFO1.nextpageno;
                                    }
                                }
                            }
                            topicFragment4.nextPageNo = v1;
                            TopicFragment.this.performFetchComplete(v9.i.c, ((HttpResponse)this.$listCmtRes.a));
                        }
                        return h0;
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.label = 2;
                return BuildersKt.withContext(Dispatchers.getMain(), topicFragment$onFetchStart$1$20, this) == a0 ? a0 : H.a;
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.artistId = l1.g(bundle0, "inState", "argArtistId", "", "getString(...)");
        String s = bundle0.getString("argItemId", "");
        q.f(s, "getString(...)");
        this.topicSeq = s;
        Serializable serializable0 = com.google.firebase.b.G(bundle0, "argCmtParam", Param.class);
        Param cmtBaseFragment$Param0 = serializable0 instanceof Param ? ((Param)serializable0) : null;
        this.mParam = cmtBaseFragment$Param0;
        if(cmtBaseFragment$Param0 != null) {
            cmtBaseFragment$Param0.cacheKeyOfCmtList = this.getCacheKey();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argItemId", this.topicSeq);
        bundle0.putSerializable("argCmtParam", this.mParam);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        F8.p p0 = new F8.p(1);
        p0.c = new g(this, 2);
        TitleBar titleBar0 = this.getTitleBar();
        p0.g(new m(2, false));
        titleBar0.a(p0);
        this.getTitleBar().setTitle(this.getString(0x7F1310F8));  // string:wageurwageul "와글와글"
        Q1.c.R(this, "comment_request_key", (String s, Bundle bundle0) -> TopicFragment.onViewCreated$lambda$2(this, s, bundle0));
        this.addOnCmtRemoveListener(this.mOnCmtRemoveListener);
    }

    private static final void onViewCreated$lambda$1(TopicFragment topicFragment0, View view0) {
        if(i.l(topicFragment0.mMelonTiaraProperty)) {
            p8.f f0 = topicFragment0.getBaseTiaraLogEventBuilder();
            f0.a = topicFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = topicFragment0.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
            f0.F = topicFragment0.getString(0x7F130DD4);  // string:tiara_common_back_button "뒤로가기"
            f0.e = topicFragment0.topicSeq;
            f0.a().track();
        }
        topicFragment0.performBackPress();
    }

    private static final H onViewCreated$lambda$2(TopicFragment topicFragment0, String s, Bundle bundle0) {
        q.g(s, "<unused var>");
        q.g(bundle0, "bundle");
        Serializable serializable0 = com.google.firebase.b.G(bundle0, "data", EventComment.class);
        topicFragment0.updateCmt((serializable0 instanceof EventComment ? ((EventComment)serializable0) : null));
        return H.a;
    }

    private final Deferred requestLikeAndCmtAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                TopicFragment.this = topicFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestLikeAndCmtAsync.1(TopicFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestLikeAndCmtAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    try {
                        Params artistContentsInfoLikeAndCmtReq$Params0 = new Params();
                        artistContentsInfoLikeAndCmtReq$Params0.artistId = TopicFragment.this.artistId;
                        artistContentsInfoLikeAndCmtReq$Params0.contsId = TopicFragment.this.topicSeq;
                        artistContentsInfoLikeAndCmtReq$Params0.contsTypeCode = "N10098";
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistContentsInfoLikeAndCmtReq(TopicFragment.this.getContext(), artistContentsInfoLikeAndCmtReq$Params0)).tag(TopicFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistContentsInfoLikeAndCmtRes");
                        return (ArtistContentsInfoLikeAndCmtRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        H0.b.w("requesLikeAndCmtAsync() exception, ", exception0.getMessage(), LogU.Companion, "TopicFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    private final void requestLikedAction(boolean z) {
        this.updateLike(this.topicSeq, "N10098", !z, this.getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                if(Tf.o.H0(s) && TopicFragment.this.isFragmentValid()) {
                    j0 j00 = TopicFragment.this.getAdapter();
                    TopicAdapter topicFragment$TopicAdapter0 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
                    if(topicFragment$TopicAdapter0 != null) {
                        TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 = topicFragment$TopicAdapter0.getTopicInfo();
                        if(artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0 != null) {
                            TopicFragment topicFragment0 = TopicFragment.this;
                            artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.isLike = z;
                            artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0.likeCnt = String.valueOf(v);
                            int v1 = topicFragment0.getAdapter().getItemCount();
                            for(int v2 = 0; v2 < v1; ++v2) {
                                if(topicFragment0.getAdapter().getItemViewType(v2) == 0) {
                                    topicFragment0.getAdapter().notifyItemChanged(v2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
            }
        });
    }

    private final Deferred requestListCmtAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                TopicFragment.this = topicFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestListCmtAsync.1(TopicFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestListCmtAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                PAGINGINFO loadPgnRes$result$PAGINGINFO0;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                try {
                    com.iloen.melon.net.v3x.comments.ListCmtReq.Params listCmtReq$Params0 = new com.iloen.melon.net.v3x.comments.ListCmtReq.Params();
                    TopicFragment topicFragment0 = TopicFragment.this;
                    listCmtReq$Params0.chnlSeq = topicFragment0.mParam.chnlSeq;
                    listCmtReq$Params0.contsRefValue = topicFragment0.mParam.contsRefValue;
                    listCmtReq$Params0.pageNo = topicFragment0.nextPageNo;
                    listCmtReq$Params0.pageSize = 15;
                    listCmtReq$Params0.sortType = 0;
                    listCmtReq$Params0.filterType = 0;
                    LoadPgnRes loadPgnRes0 = topicFragment0.mLoadPgnRes;
                    if(loadPgnRes0 == null) {
                        loadPgnRes$result$PAGINGINFO0 = null;
                    }
                    else {
                        result loadPgnRes$result0 = loadPgnRes0.result;
                        loadPgnRes$result$PAGINGINFO0 = loadPgnRes$result0 == null ? null : loadPgnRes$result0.paginginfo;
                    }
                    if(loadPgnRes$result$PAGINGINFO0 != null) {
                        listCmtReq$Params0.startSeq = topicFragment0.mLoadPgnRes.result.pageinfo.startseq;
                    }
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    HttpResponse httpResponse0 = RequestBuilder.newInstance(new ListCmtReq(TopicFragment.this.getContext(), listCmtReq$Params0)).tag(TopicFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.ListCmtRes");
                    return (ListCmtRes)httpResponse0;
                }
                catch(Exception exception0) {
                }
                H0.b.w("requestListCmtAsync() exception, ", exception0.getMessage(), LogU.Companion, "TopicFragment");
                return null;
            }
        }, 3, null);
    }

    private final Deferred requestLoadPgnAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                TopicFragment.this = topicFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestLoadPgnAsync.1(TopicFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestLoadPgnAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    try {
                        com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params0 = new com.iloen.melon.net.v3x.comments.LoadPgnReq.Params();
                        loadPgnReq$Params0.chnlSeq = TopicFragment.this.mParam.chnlSeq;
                        loadPgnReq$Params0.contsRefValue = TopicFragment.this.mParam.contsRefValue;
                        loadPgnReq$Params0.filterType = 0;
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new LoadPgnReq(TopicFragment.this.getContext(), loadPgnReq$Params0)).tag(TopicFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.LoadPgnRes");
                        return (LoadPgnRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        H0.b.w("requestLoadPgnAsync() exception, ", exception0.getMessage(), LogU.Companion, "TopicFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    private final Deferred requestTopicInfoAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                TopicFragment.this = topicFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestTopicInfoAsync.1(TopicFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestTopicInfoAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistContentsArtistTopicInfoReq(TopicFragment.this.getContext(), TopicFragment.this.artistId, TopicFragment.this.topicSeq)).tag(TopicFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes");
                return (ArtistContentsArtistTopicInfoRes)httpResponse0;
            }
        }, 3, null);
    }

    private final Deferred requestUserActionAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int label;

            {
                TopicFragment.this = topicFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestUserActionAsync.1(TopicFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.artistchannel.topic.TopicFragment.requestUserActionAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label == 0) {
                    d5.n.D(object0);
                    if(!TopicFragment.this.isLoginUser()) {
                        return null;
                    }
                    try {
                        com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0 = new com.iloen.melon.net.v4x.request.UserActionsReq.Params();
                        userActionsReq$Params0.fields = "like";
                        userActionsReq$Params0.contsTypeCode = "N10098";
                        userActionsReq$Params0.contsId = TopicFragment.this.topicSeq;
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new UserActionsReq(TopicFragment.this.getContext(), userActionsReq$Params0)).tag(TopicFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.UserActionsRes");
                        return (UserActionsRes)httpResponse0;
                    }
                    catch(Exception exception0) {
                        H0.b.w("requestUserActionAsync() exception, ", exception0.getMessage(), LogU.Companion, "TopicFragment");
                        return null;
                    }
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }, 3, null);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void showScrolledLine(boolean z) {
        this.getTitleBar().setTitleVisibility(z);
        super.showScrolledLine(z);
    }

    private final void updateCmtAllCount(int v) {
        this.cmtAllCount = v;
        if(v > 0) {
            j0 j00 = this.getAdapter();
            if(j00 != null) {
                int v1 = j00.getItemCount();
                for(int v2 = 0; v2 < v1; ++v2) {
                    int v3 = j00.getItemViewType(v2);
                    if(v3 == 0 || 50 == v3) {
                        j00.notifyItemChanged(v2);
                    }
                }
            }
        }
    }

    public static void x0(TopicFragment topicFragment0, View view0) {
        TopicFragment.onViewCreated$lambda$1(topicFragment0, view0);
    }

    // 检测为 Lambda 实现
    public static H y0(TopicFragment topicFragment0, String s, Bundle bundle0) [...]
}

