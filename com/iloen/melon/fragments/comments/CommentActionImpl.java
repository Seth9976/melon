package com.iloen.melon.fragments.comments;

import Ac.V2;
import Ac.o4;
import Ac.v2;
import Uc.n;
import Zc.N;
import a9.a;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri.Builder;
import android.net.Uri;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.l0;
import androidx.media3.session.H0;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CancelRecmReq;
import com.iloen.melon.net.v3x.comments.CancelRecmRes.CancelResult.RecmInfo;
import com.iloen.melon.net.v3x.comments.CancelRecmRes.CancelResult;
import com.iloen.melon.net.v3x.comments.CancelRecmRes;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO;
import com.iloen.melon.net.v3x.comments.DeleteCmtReq.Params;
import com.iloen.melon.net.v3x.comments.DeleteCmtReq;
import com.iloen.melon.net.v3x.comments.DeleteCmtRes;
import com.iloen.melon.net.v3x.comments.InsertRecmReq;
import com.iloen.melon.net.v3x.comments.InsertRecmRes.InsertResult;
import com.iloen.melon.net.v3x.comments.InsertRecmRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.video.VideoInfoFragment;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.K1;
import com.melon.ui.W1;
import com.melon.ui.k2;
import com.melon.ui.popup.b;
import e1.u;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.HashMap;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.c;
import v9.i;
import va.e0;
import va.o;
import zd.M;
import zd.k;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH&\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0013J7\u0010\u001A\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0010J\u001F\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\u001F\u0010 \u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b \u0010\u001EJ\u001F\u0010!\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b!\u0010\u001EJ/\u0010$\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\u00142\u0006\u0010#\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010&\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b&\u0010\u001EJ\u0011\u0010(\u001A\u0004\u0018\u00010\'H\u0016\u00A2\u0006\u0004\b(\u0010)J!\u0010/\u001A\u00020.2\b\u0010+\u001A\u0004\u0018\u00010*2\b\u0010-\u001A\u0004\u0018\u00010,\u00A2\u0006\u0004\b/\u00100J\u0011\u00101\u001A\u0004\u0018\u00010\'H\u0002\u00A2\u0006\u0004\b1\u0010)J\u0017\u00102\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b2\u0010\u0013J7\u00103\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\b3\u0010\u001BJ\u000F\u00104\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b4\u0010\u0010J\u001F\u00105\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b5\u0010\u001EJ\u001F\u00106\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b6\u0010\u001EJ\u001F\u00107\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b7\u0010\u001EJ\u001F\u00108\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b8\u0010\u001EJ/\u0010;\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\b2\u0006\u0010:\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\u00142\u0006\u0010#\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\b;\u0010%J\u001F\u0010<\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b<\u0010\u001EJ\u0019\u0010=\u001A\u00020\u00142\b\u0010+\u001A\u0004\u0018\u00010*H\u0002\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010?\u001A\u00020\u000E2\u0006\u0010+\u001A\u00020*H\u0002\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010D\u001A\u00020B2\u0006\u0010A\u001A\u00020\b2\u0006\u0010C\u001A\u00020BH\u0002\u00A2\u0006\u0004\bD\u0010EJ/\u0010G\u001A\u00020\u000E2\u0006\u0010F\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bG\u0010HJ/\u0010I\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010F\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bI\u0010JJ/\u0010K\u001A\u00020\u000E2\u0006\u0010F\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bK\u0010HJ\u0019\u0010M\u001A\u00020\u000E2\b\u0010L\u001A\u0004\u0018\u00010BH\u0002\u00A2\u0006\u0004\bM\u0010NJ!\u0010P\u001A\u00020\u000E2\b\u0010L\u001A\u0004\u0018\u00010B2\u0006\u0010O\u001A\u00020BH\u0002\u00A2\u0006\u0004\bP\u0010QR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010RR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010SR\u0018\u0010+\u001A\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010TR\u0016\u0010U\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010VR6\u0010Z\u001A\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020X\u0018\u00010Wj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020X\u0018\u0001`Y8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010[\u00A8\u0006]"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentActionImpl;", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "Landroid/app/Activity;", "activity", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "fragment", "<init>", "(Landroid/app/Activity;Lcom/iloen/melon/fragments/MetaContentBaseFragment;)V", "", "adapterPos", "dataPos", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "getValidCommentInfoAdapterItem", "(II)Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "Lie/H;", "onOpenCommentListView", "()V", "Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;", "param", "(Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;)V", "", "recom", "Landroid/widget/TextView;", "view", "Lcom/iloen/melon/custom/RecommenderView;", "recommenderView", "onCommentRecommendListener", "(IIZLandroid/widget/TextView;Lcom/iloen/melon/custom/RecommenderView;)V", "onOpenCommentWriteView", "onOpenAdCommentView", "(II)V", "onOpenCommentEditView", "onCommentRemoveListener", "onCommentReportListener", "isEditable", "isFanTalk", "onShowContextPopupCommentMore", "(IIZZ)V", "onOpenUserView", "Lp8/f;", "onTiaraEventBuilder", "()Lp8/f;", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "cmtRes", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "getCmtResViewModel", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "getTiaraEventBuilder", "openCommentList", "updateRecommendState", "openCmtWriteView", "openAdcmtView", "openCmtEditView", "removeCmt", "reportCmt", "adapterposition", "dataposition", "showContextPopupCommentMore", "openUserView", "isLoadPgnResValid", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;)Z", "showBreakMemberGuidePopup", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;)V", "chnlSeq", "", "contsRef", "getCommentListCacheKey", "(ILjava/lang/String;)Ljava/lang/String;", "item", "requestCancelRecm", "(Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;ZLandroid/widget/TextView;Lcom/iloen/melon/custom/RecommenderView;)V", "updateRecommendActionView", "(ZLandroid/widget/TextView;Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;Lcom/iloen/melon/custom/RecommenderView;)V", "requestInsertRecm", "errormessage", "performCmtFetchErrorToast", "(Ljava/lang/String;)V", "status", "performCmtFetchErrorPopup", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "isRequestDone", "Z", "Ljava/util/HashMap;", "Lcom/iloen/melon/fragments/comments/CmtPositionInfo;", "Lkotlin/collections/HashMap;", "cmtPositionInfoHashMap", "Ljava/util/HashMap;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class CommentActionImpl implements OnViewHolderActionBaseListener {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentActionImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[92] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[93] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[83] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "CommentActionImpl";
    @NotNull
    private final Activity activity;
    @Nullable
    private HashMap cmtPositionInfoHashMap;
    @NotNull
    private final MetaContentBaseFragment fragment;
    private boolean isRequestDone;
    @Nullable
    private LoadPgnRes loadPgnRes;

    static {
        CommentActionImpl.Companion = new Companion(null);
        CommentActionImpl.$stable = 8;
    }

    public CommentActionImpl(@NotNull Activity activity0, @NotNull MetaContentBaseFragment metaContentBaseFragment0) {
        q.g(activity0, "activity");
        q.g(metaContentBaseFragment0, "fragment");
        super();
        this.activity = activity0;
        this.fragment = metaContentBaseFragment0;
        this.isRequestDone = true;
    }

    public static void e(CommentActionImpl commentActionImpl0, Params deleteCmtReq$Params0, DeleteCmtRes deleteCmtRes0) {
        CommentActionImpl.removeCmt$lambda$5$lambda$3(commentActionImpl0, deleteCmtReq$Params0, deleteCmtRes0);
    }

    @NotNull
    public final CmtResViewModel getCmtResViewModel(@Nullable LoadPgnRes loadPgnRes0, @Nullable ListCmtRes listCmtRes0) {
        boolean z;
        int v;
        ArrayList arrayList0;
        this.loadPgnRes = loadPgnRes0;
        CmtResViewModel cmtResViewModel0 = new CmtResViewModel();
        String s = null;
        if(listCmtRes0 == null) {
            arrayList0 = null;
        }
        else {
            result listCmtRes$result0 = listCmtRes0.result;
            arrayList0 = listCmtRes$result0 == null ? null : listCmtRes$result0.cmtlist;
        }
        if(loadPgnRes0 == null) {
            v = -1;
        }
        else {
            com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result0 = loadPgnRes0.result;
            if(loadPgnRes$result0 == null) {
                v = -1;
            }
            else {
                CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                v = loadPgnRes$result$CHNLINFO0 == null ? -1 : loadPgnRes$result$CHNLINFO0.chnlseq;
            }
        }
        if(listCmtRes0 != null) {
            result listCmtRes$result1 = listCmtRes0.result;
            if(listCmtRes$result1 != null) {
                PAGEINFO listCmtRes$result$PAGEINFO0 = listCmtRes$result1.pageinfo;
                if(listCmtRes$result$PAGEINFO0 != null) {
                    s = listCmtRes$result$PAGEINFO0.contsrefvalue;
                }
            }
        }
        if(loadPgnRes0 == null) {
            z = false;
        }
        else {
            com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result1 = loadPgnRes0.result;
            if(loadPgnRes$result1 == null) {
                z = false;
            }
            else {
                CHNLINFO loadPgnRes$result$CHNLINFO1 = loadPgnRes$result1.chnlinfo;
                z = loadPgnRes$result$CHNLINFO1 == null ? false : loadPgnRes$result$CHNLINFO1.reprtuseflag;
            }
        }
        cmtResViewModel0.databindCmtListBase(loadPgnRes0, arrayList0, v, s, false, z);
        return cmtResViewModel0;
    }

    private final String getCommentListCacheKey(int v, String s) {
        String s1 = MelonContentUris.g.buildUpon().appendPath("cmtlist").appendQueryParameter("chnlSeq", String.valueOf(v)).appendQueryParameter("contsRef", s).build().toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    private final f getTiaraEventBuilder() {
        s s0 = this.fragment.getTiaraProperty();
        if(s0 != null) {
            f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = s0.a;
            f0.c = s0.b;
            f0.I = s0.c;
            f0.c0 = s0.d;
            return f0;
        }
        return null;
    }

    @Nullable
    public abstract cmtList getValidCommentInfoAdapterItem(int arg1, int arg2);

    private final boolean isLoadPgnResValid(LoadPgnRes loadPgnRes0) {
        if(loadPgnRes0 != null) {
            return loadPgnRes0.result == null ? false : loadPgnRes0.result.chnlinfo != null && loadPgnRes0.result.spaminfo != null;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onAlbumPlayListener(@NotNull String s) {
        OnViewHolderActionBaseListener.super.onAlbumPlayListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onAllSelectListener(boolean z) {
        OnViewHolderActionBaseListener.super.onAllSelectListener(z);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public boolean onCheckLoginListener() {
        return OnViewHolderActionBaseListener.super.onCheckLoginListener();
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onCommentRecommendListener(int v, int v1, boolean z, @NotNull TextView textView0, @NotNull RecommenderView recommenderView0) {
        q.g(textView0, "view");
        q.g(recommenderView0, "recommenderView");
        this.updateRecommendState(v, v1, z, textView0, recommenderView0);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onCommentRemoveListener(int v, int v1) {
        this.removeCmt(v, v1);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onCommentReportListener(int v, int v1) {
        this.reportCmt(v, v1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onDownloadSong() {
        OnViewHolderActionBaseListener.super.onDownloadSong();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onItemLikeListener(@NotNull String s, @NotNull String s1, boolean z, int v) {
        OnViewHolderActionBaseListener.super.onItemLikeListener(s, s1, z, v);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onLikedListener(@NotNull CheckableImageView checkableImageView0, @NotNull TextView textView0) {
        OnViewHolderActionBaseListener.super.onLikedListener(checkableImageView0, textView0);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onLyricUpdateMsgListener(@NotNull String s) {
        OnViewHolderActionBaseListener.super.onLyricUpdateMsgListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onMoveToScoll(int v) {
        OnViewHolderActionBaseListener.super.onMoveToScoll(v);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenAdCommentView(int v, int v1) {
        this.openAdcmtView(v, v1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onOpenCastEpisodeDetailView(@Nullable String s) {
        OnViewHolderActionBaseListener.super.onOpenCastEpisodeDetailView(s);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentEditView(int v, int v1) {
        this.openCmtEditView(v, v1);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentListView() {
        LoadPgnRes loadPgnRes0 = this.loadPgnRes;
        if(loadPgnRes0 != null) {
            Param cmtListFragment$Param0 = new Param();
            cmtListFragment$Param0.chnlSeq = loadPgnRes0.result.pageinfo.chnlseq;
            cmtListFragment$Param0.contsRefValue = loadPgnRes0.result.pageinfo.contsrefvalue;
            cmtListFragment$Param0.theme = c.c;
            cmtListFragment$Param0.showTitle = true;
            cmtListFragment$Param0.cacheKeyOfTargetPage = "";
            this.openCommentList(cmtListFragment$Param0);
        }
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentListView(@NotNull Param cmtListFragment$Param0) {
        q.g(cmtListFragment$Param0, "param");
        this.openCommentList(cmtListFragment$Param0);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentWriteView() {
        String s;
        int v;
        if(this.fragment.getParentFragment() instanceof a) {
            if(!this.fragment.isLoginUser()) {
                this.fragment.showLoginPopup();
                return;
            }
            LoadPgnRes loadPgnRes0 = this.loadPgnRes;
            if(loadPgnRes0 != null) {
                Param cmtListFragment$Param0 = new Param();
                com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result0 = loadPgnRes0.result;
                if(loadPgnRes$result0 == null) {
                    v = -1;
                }
                else {
                    CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                    v = loadPgnRes$result$CHNLINFO0 == null ? -1 : loadPgnRes$result$CHNLINFO0.chnlseq;
                }
                cmtListFragment$Param0.chnlSeq = v;
                if(loadPgnRes$result0 == null) {
                    s = null;
                }
                else {
                    com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGEINFO loadPgnRes$result$PAGEINFO0 = loadPgnRes$result0.pageinfo;
                    s = loadPgnRes$result$PAGEINFO0 == null ? null : loadPgnRes$result$PAGEINFO0.contsrefvalue;
                }
                cmtListFragment$Param0.contsRefValue = s;
                cmtListFragment$Param0.theme = c.c;
                cmtListFragment$Param0.showTitle = true;
                cmtListFragment$Param0.cacheKeyOfTargetPage = "";
                this.openCommentList(cmtListFragment$Param0);
            }
            return;
        }
        this.openCmtWriteView();
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenUserView(int v, int v1) {
        this.openUserView(v, v1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPerformBackPress() {
        OnViewHolderActionBaseListener.super.onPerformBackPress();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayAlbumListener(@Nullable String s) {
        OnViewHolderActionBaseListener.super.onPlayAlbumListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayArtistMixUp() {
        OnViewHolderActionBaseListener.super.onPlayArtistMixUp();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayBtnListener(@Nullable Playable playable0) {
        OnViewHolderActionBaseListener.super.onPlayBtnListener(playable0);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayDjPlaylistListener(@Nullable String s, @Nullable String s1) {
        OnViewHolderActionBaseListener.super.onPlayDjPlaylistListener(s, s1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayForUSongListener(@Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0) {
        OnViewHolderActionBaseListener.super.onPlayForUSongListener(s, s1, statsElementsBase0);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayRadioCast(@Nullable String s) {
        OnViewHolderActionBaseListener.super.onPlayRadioCast(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlaySongListener(@Nullable String s) {
        OnViewHolderActionBaseListener.super.onPlaySongListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlaySongsListener(@NotNull ArrayList arrayList0, boolean z) {
        OnViewHolderActionBaseListener.super.onPlaySongsListener(arrayList0, z);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onRequestFanListener(@NotNull String s, boolean z) {
        OnViewHolderActionBaseListener.super.onRequestFanListener(s, z);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onSetBtnAll(@NotNull CheckableTextView checkableTextView0) {
        OnViewHolderActionBaseListener.super.onSetBtnAll(checkableTextView0);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onShowContextPopupCommentMore(int v, int v1, boolean z, boolean z1) {
        this.showContextPopupCommentMore(v, v1, z, z1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onShowNoFanPopupListener() {
        OnViewHolderActionBaseListener.super.onShowNoFanPopupListener();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onShowSharePopupListener() {
        OnViewHolderActionBaseListener.super.onShowSharePopupListener();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onSongListFooterRemoveCheck() {
        OnViewHolderActionBaseListener.super.onSongListFooterRemoveCheck();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public boolean onSongListMore() {
        return OnViewHolderActionBaseListener.super.onSongListMore();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onSongListViewAll() {
        OnViewHolderActionBaseListener.super.onSongListViewAll();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    @Nullable
    public f onTiaraEventBuilder() {
        return this.getTiaraEventBuilder();
    }

    private final void openAdcmtView(int v, int v1) {
        LoadPgnRes loadPgnRes0 = this.loadPgnRes;
        if(loadPgnRes0 != null && this.isLoadPgnResValid(loadPgnRes0) && this.fragment.isFragmentValid()) {
            if(loadPgnRes0.result != null && (loadPgnRes0.result.spaminfo != null && loadPgnRes0.result.spaminfo.breakmemberflag)) {
                this.showBreakMemberGuidePopup(loadPgnRes0);
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidCommentInfoAdapterItem(v, v1);
            if(cmtResViewModel$result$cmtList0 != null) {
                int v2 = cmtResViewModel$result$cmtList0.chnlseq;
                String s = cmtResViewModel$result$cmtList0.contsrefvalue;
                q.f(s, "contsrefvalue");
                int v3 = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
                com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result0 = loadPgnRes0.result;
                q.f(loadPgnRes$result0, "result");
                CommentConfig commentConfig0 = CommentActionImplKt.toUiModel(loadPgnRes$result0);
                q.g(commentConfig0, "config");
                v2 v20 = new v2();
                v20.setArguments(d5.f.j(new m[]{new m("key_cmt_seq", v3), new m("key_channel_seq", v2), new m("key_content_ref_value", s), new m("key_cmt_config", commentConfig0)}));
                v20.m(this.fragment.getParentFragment());
            }
        }
    }

    private final void openCmtEditView(int v, int v1) {
        LoadPgnRes loadPgnRes0 = this.loadPgnRes;
        if(loadPgnRes0 != null && this.isLoadPgnResValid(loadPgnRes0) && this.fragment.isFragmentValid()) {
            if(!((e0)o.a()).m()) {
                this.fragment.showLoginPopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidCommentInfoAdapterItem(v, v1);
            if(cmtResViewModel$result$cmtList0 != null) {
                int v2 = cmtResViewModel$result$cmtList0.chnlseq;
                String s = cmtResViewModel$result$cmtList0.contsrefvalue;
                q.f(s, "contsrefvalue");
                com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result0 = loadPgnRes0.result;
                q.f(loadPgnRes$result0, "result");
                Navigator.openCommentWrite(v2, s, CommentActionImplKt.toUiModel(loadPgnRes$result0), o4.b, cmtResViewModel$result$cmtList0.cmtinfo.cmtseq);
            }
        }
    }

    private final void openCmtWriteView() {
        LoadPgnRes loadPgnRes0 = this.loadPgnRes;
        if(loadPgnRes0 != null && this.isLoadPgnResValid(loadPgnRes0) && this.fragment.isFragmentValid()) {
            if(!this.fragment.isLoginUser()) {
                this.fragment.showLoginPopup();
                return;
            }
            com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result0 = loadPgnRes0.result;
            if(loadPgnRes$result0.chnlinfo.blindContsCmtWriteFlag) {
                l0 l00 = this.fragment.getChildFragmentManager();
                String s = this.fragment.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                b.d(b.a, l00, s, loadPgnRes0.result.chnlinfo.blindContsDsplyText, false, false, false, null, null, null, null, null, 2040);
                return;
            }
            if(loadPgnRes$result0.spaminfo.breakmemberflag) {
                this.showBreakMemberGuidePopup(loadPgnRes0);
                return;
            }
            CommentConfig commentConfig0 = CommentActionImplKt.toUiModel(loadPgnRes$result0);
            Navigator.openCommentWrite$default(commentConfig0.getChannelSeq(), commentConfig0.getContentRefValue(), commentConfig0, null, 0, 24, null);
        }
    }

    private final void openCommentList(Param cmtListFragment$Param0) {
        int v = cmtListFragment$Param0.chnlSeq;
        String s = cmtListFragment$Param0.contsRefValue;
        q.f(s, "contsRefValue");
        V2.a(s, null, v, false, 12).m(this.fragment.getParentFragment());
    }

    private final void openUserView(int v, int v1) {
        if(this.loadPgnRes != null && this.isLoadPgnResValid(this.loadPgnRes) && this.fragment.isFragmentValid()) {
            cmtList cmtResViewModel$result$cmtList0 = this.getValidCommentInfoAdapterItem(v, v1);
            if(cmtResViewModel$result$cmtList0 != null) {
                MEMBERINFO cmtSharedTypeRes$CmtListBase$MEMBERINFO0 = cmtResViewModel$result$cmtList0.memberinfo;
                if(cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistflag) {
                    Navigator.openArtistInfo(String.valueOf(cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistid));
                    return;
                }
                String s = cmtSharedTypeRes$CmtListBase$MEMBERINFO0.memberkey;
                if(!StringIds.a(s, StringIds.i)) {
                    if(StringIds.a(s, StringIds.j)) {
                        Navigator.openMelGunsCollection();
                        return;
                    }
                    Navigator.openUserMain(s);
                }
            }
        }
    }

    private final void performCmtFetchErrorPopup(String s, String s1) {
        String s2;
        if(s == null) {
            q.f("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.", "getString(...)");
            s2 = "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.";
        }
        else {
            s2 = s;
        }
        l0 l00 = this.fragment.getChildFragmentManager();
        String s3 = this.fragment.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        N n0 = new N(9, s1, this);
        b.d(b.a, l00, s3, s2, false, false, false, null, null, null, n0, null, 0x5F8);
    }

    private static final H performCmtFetchErrorPopup$lambda$13(String s, CommentActionImpl commentActionImpl0) {
        if("405".equals(s)) {
            Intent intent0 = new Intent("android.intent.action.VIEW", r8.f.l);
            commentActionImpl0.activity.startActivity(intent0);
        }
        return H.a;
    }

    private final void performCmtFetchErrorToast(String s) {
        if(s != null) {
            ToastManager.showShort(s);
            return;
        }
        ToastManager.showShort("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.");
    }

    private final void removeCmt(int v, int v1) {
        if(this.loadPgnRes != null && this.isLoadPgnResValid(this.loadPgnRes) && this.fragment.isFragmentValid()) {
            if(!((e0)o.a()).m()) {
                this.fragment.showLoginPopup();
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidCommentInfoAdapterItem(v, v1);
            if(cmtResViewModel$result$cmtList0 != null) {
                b.x(this.fragment.getChildFragmentManager(), "알림", "삭제하시겠습니까?\n다른 회원님들께서 작성하신 답글도 함께 삭제됩니다.", false, false, null, null, new N(10, cmtResViewModel$result$cmtList0, this), null, null, null, 0xEF8);
            }
        }
    }

    private static final H removeCmt$lambda$5(cmtList cmtResViewModel$result$cmtList0, CommentActionImpl commentActionImpl0) {
        Params deleteCmtReq$Params0 = new Params();
        deleteCmtReq$Params0.chnlSeq = cmtResViewModel$result$cmtList0.chnlseq;
        deleteCmtReq$Params0.contsRefValue = cmtResViewModel$result$cmtList0.contsrefvalue;
        deleteCmtReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        RequestBuilder.newInstance(new DeleteCmtReq(commentActionImpl0.activity, deleteCmtReq$Params0)).tag(commentActionImpl0.fragment.getRequestTag()).listener(new H0(8, commentActionImpl0, deleteCmtReq$Params0)).errorListener(new j(commentActionImpl0, 1)).request();
        return H.a;
    }

    private static final void removeCmt$lambda$5$lambda$3(CommentActionImpl commentActionImpl0, Params deleteCmtReq$Params0, DeleteCmtRes deleteCmtRes0) {
        if(deleteCmtRes0.isSuccessful()) {
            ToastManager.showShort("삭제되었습니다.");
            int v = deleteCmtReq$Params0.chnlSeq;
            String s = deleteCmtReq$Params0.contsRefValue;
            q.f(s, "contsRefValue");
            TimeExpiredCache.getInstance().remove(commentActionImpl0.getCommentListCacheKey(v, s));
            MetaContentBaseFragment metaContentBaseFragment0 = commentActionImpl0.fragment;
            if(metaContentBaseFragment0 instanceof VideoInfoFragment) {
                ((VideoInfoFragment)metaContentBaseFragment0).getViewModel().request(i.b);
                return;
            }
            metaContentBaseFragment0.startFetch("commentReload");
            return;
        }
        if("405".equals(deleteCmtRes0.status)) {
            String s1 = deleteCmtRes0.errormessage;
            String s2 = deleteCmtRes0.status;
            q.f(s2, "status");
            commentActionImpl0.performCmtFetchErrorPopup(s1, s2);
            return;
        }
        commentActionImpl0.performCmtFetchErrorToast(deleteCmtRes0.errormessage);
    }

    private static final void removeCmt$lambda$5$lambda$4(CommentActionImpl commentActionImpl0, VolleyError volleyError0) {
        ToastManager.show("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.");
    }

    private final void reportCmt(int v, int v1) {
        String s1;
        LoadPgnRes loadPgnRes0 = this.loadPgnRes;
        if(loadPgnRes0 != null && this.isLoadPgnResValid(loadPgnRes0) && this.fragment.isFragmentValid()) {
            if(!((e0)o.a()).m()) {
                this.fragment.showLoginPopup();
                return;
            }
            if(loadPgnRes0.result != null && (loadPgnRes0.result.spaminfo != null && loadPgnRes0.result.spaminfo.breakmemberflag)) {
                this.showBreakMemberGuidePopup(loadPgnRes0);
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidCommentInfoAdapterItem(v, v1);
            if(cmtResViewModel$result$cmtList0 != null) {
                com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result0 = loadPgnRes0.result;
                String s = null;
                if(loadPgnRes$result0 == null) {
                    s1 = null;
                }
                else {
                    CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                    s1 = loadPgnRes$result$CHNLINFO0 == null ? null : loadPgnRes$result$CHNLINFO0.reprtWindowUrl;
                }
                if(s1 != null && s1.length() != 0) {
                    int v2 = cmtResViewModel$result$cmtList0.chnlseq;
                    String s2 = cmtResViewModel$result$cmtList0.contsrefvalue;
                    q.f(s2, "contsrefvalue");
                    int v3 = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
                    if(this.cmtPositionInfoHashMap == null) {
                        this.cmtPositionInfoHashMap = new HashMap();
                    }
                    HashMap hashMap0 = this.cmtPositionInfoHashMap;
                    if(hashMap0 != null) {
                        q.f("", "getCacheKey(...)");
                        hashMap0.put(v3, new CmtPositionInfo(v2, v3, v, v1, ""));
                    }
                    com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result1 = loadPgnRes0.result;
                    if(loadPgnRes$result1 != null) {
                        CHNLINFO loadPgnRes$result$CHNLINFO1 = loadPgnRes$result1.chnlinfo;
                        if(loadPgnRes$result$CHNLINFO1 != null) {
                            s = loadPgnRes$result$CHNLINFO1.reprtWindowUrl;
                        }
                    }
                    Uri.Builder uri$Builder0 = Uri.parse(s).buildUpon().appendQueryParameter("templateType", "m.list").appendQueryParameter("cmtPocType", "m.web");
                    MelonAppBase.Companion.getClass();
                    Navigator.openUrl(uri$Builder0.appendQueryParameter("pocId", t.a().getMelonCpId()).appendQueryParameter("chnlSeq", String.valueOf(v2)).appendQueryParameter("contsRefValue", s2).appendQueryParameter("cmtSeq", String.valueOf(v3)).build().toString(), OpenType.FullScreenWithBar);
                }
            }
        }
    }

    private final void requestCancelRecm(cmtList cmtResViewModel$result$cmtList0, boolean z, TextView textView0, RecommenderView recommenderView0) {
        com.iloen.melon.net.v3x.comments.CancelRecmReq.Params cancelRecmReq$Params0 = new com.iloen.melon.net.v3x.comments.CancelRecmReq.Params();
        cancelRecmReq$Params0.chnlSeq = cmtResViewModel$result$cmtList0.chnlseq;
        cancelRecmReq$Params0.contsRefValue = cmtResViewModel$result$cmtList0.contsrefvalue;
        cancelRecmReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        cancelRecmReq$Params0.nonRecmFlag = !z;
        RequestBuilder.newInstance(new CancelRecmReq(this.activity, cancelRecmReq$Params0)).tag(this.fragment.getRequestTag()).listener(new com.iloen.melon.fragments.comments.i(this, cmtResViewModel$result$cmtList0, z, textView0, recommenderView0, 1)).errorListener(new j(this, 2)).request();
    }

    private static final void requestCancelRecm$lambda$10(CommentActionImpl commentActionImpl0, VolleyError volleyError0) {
        commentActionImpl0.isRequestDone = true;
        ToastManager.show("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.");
    }

    private static final void requestCancelRecm$lambda$9(CommentActionImpl commentActionImpl0, cmtList cmtResViewModel$result$cmtList0, boolean z, TextView textView0, RecommenderView recommenderView0, CancelRecmRes cancelRecmRes0) {
        commentActionImpl0.isRequestDone = true;
        if(commentActionImpl0.fragment.isFragmentValid() && cancelRecmRes0.isSuccessful()) {
            CancelResult cancelRecmRes$CancelResult0 = cancelRecmRes0.result;
            if(cancelRecmRes$CancelResult0 != null) {
                RecmInfo cancelRecmRes$CancelResult$RecmInfo0 = cancelRecmRes$CancelResult0.recmInfo;
                if(cancelRecmRes$CancelResult$RecmInfo0 != null) {
                    if(cancelRecmRes$CancelResult$RecmInfo0.message != null && cancelRecmRes$CancelResult$RecmInfo0.message.length() != 0) {
                        ToastManager.show(cancelRecmRes$CancelResult$RecmInfo0.message);
                    }
                    cmtResViewModel$result$cmtList0.cmtinfo.recmcnt += cancelRecmRes$CancelResult$RecmInfo0.recmChgCount;
                    cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag = cancelRecmRes$CancelResult$RecmInfo0.recmFlag;
                    cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt += cancelRecmRes$CancelResult$RecmInfo0.nonRecmChgCount;
                    cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag = cancelRecmRes$CancelResult$RecmInfo0.nonrecmflag;
                    cmtResViewModel$result$cmtList0.recommenderInfo = cancelRecmRes$CancelResult$RecmInfo0.recommenderInfo;
                    commentActionImpl0.updateRecommendActionView(z, textView0, cmtResViewModel$result$cmtList0, recommenderView0);
                }
            }
            return;
        }
        commentActionImpl0.performCmtFetchErrorToast(cancelRecmRes0.errormessage);
    }

    private final void requestInsertRecm(cmtList cmtResViewModel$result$cmtList0, boolean z, TextView textView0, RecommenderView recommenderView0) {
        com.iloen.melon.net.v3x.comments.InsertRecmReq.Params insertRecmReq$Params0 = new com.iloen.melon.net.v3x.comments.InsertRecmReq.Params();
        insertRecmReq$Params0.chnlSeq = cmtResViewModel$result$cmtList0.chnlseq;
        insertRecmReq$Params0.contsRefValue = cmtResViewModel$result$cmtList0.contsrefvalue;
        insertRecmReq$Params0.cmtSeq = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
        insertRecmReq$Params0.nonRecmFlag = !z;
        RequestBuilder.newInstance(new InsertRecmReq(this.activity, insertRecmReq$Params0)).tag(this.fragment.getRequestTag()).listener(new com.iloen.melon.fragments.comments.i(this, cmtResViewModel$result$cmtList0, z, textView0, recommenderView0, 0)).errorListener(new j(this, 0)).request();
    }

    private static final void requestInsertRecm$lambda$11(CommentActionImpl commentActionImpl0, cmtList cmtResViewModel$result$cmtList0, boolean z, TextView textView0, RecommenderView recommenderView0, InsertRecmRes insertRecmRes0) {
        commentActionImpl0.isRequestDone = true;
        if(commentActionImpl0.fragment.isFragmentValid() && insertRecmRes0.isSuccessful()) {
            InsertResult insertRecmRes$InsertResult0 = insertRecmRes0.result;
            if(insertRecmRes$InsertResult0 != null) {
                com.iloen.melon.net.v3x.comments.InsertRecmRes.InsertResult.RecmInfo insertRecmRes$InsertResult$RecmInfo0 = insertRecmRes$InsertResult0.recmInfo;
                if(insertRecmRes$InsertResult$RecmInfo0 != null) {
                    if(insertRecmRes$InsertResult$RecmInfo0.message != null && insertRecmRes$InsertResult$RecmInfo0.message.length() != 0) {
                        ToastManager.show(insertRecmRes$InsertResult$RecmInfo0.message);
                    }
                    cmtResViewModel$result$cmtList0.cmtinfo.recmcnt += insertRecmRes$InsertResult$RecmInfo0.recmChgCount;
                    cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag = insertRecmRes$InsertResult$RecmInfo0.recmFlag;
                    cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt += insertRecmRes$InsertResult$RecmInfo0.nonRecmChgCount;
                    cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag = insertRecmRes$InsertResult$RecmInfo0.nonrecmflag;
                    cmtResViewModel$result$cmtList0.recommenderInfo = insertRecmRes$InsertResult$RecmInfo0.recommenderInfo;
                    commentActionImpl0.updateRecommendActionView(z, textView0, cmtResViewModel$result$cmtList0, recommenderView0);
                }
            }
            return;
        }
        commentActionImpl0.performCmtFetchErrorToast(insertRecmRes0.errormessage);
    }

    private static final void requestInsertRecm$lambda$12(CommentActionImpl commentActionImpl0, VolleyError volleyError0) {
        commentActionImpl0.isRequestDone = true;
        ToastManager.show("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.");
    }

    private final void showBreakMemberGuidePopup(LoadPgnRes loadPgnRes0) {
        String s = loadPgnRes0.result.spaminfo.breakMemberGuideUrl;
        if(s != null && s.length() != 0) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.c = loadPgnRes0.result.spaminfo.breakMemberGuideAppSchme;
            MelonLinkExecutor.open(melonLinkInfo0);
            return;
        }
        l0 l00 = this.fragment.getChildFragmentManager();
        String s1 = this.fragment.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        b.d(b.a, l00, s1, loadPgnRes0.result.spaminfo.breakMemberGuideText, false, false, false, null, null, null, null, null, 2040);
    }

    private final void showContextPopupCommentMore(int v, int v1, boolean z, boolean z1) {
        l0 l00 = null;
        AppCompatActivity appCompatActivity0 = this.activity instanceof AppCompatActivity ? ((AppCompatActivity)this.activity) : null;
        if(appCompatActivity0 != null) {
            l00 = appCompatActivity0.getSupportFragmentManager();
        }
        b.o(l00, new k(z, false), new n(this, v, v1, 2), 12);
    }

    private static final H showContextPopupCommentMore$lambda$8$lambda$7(CommentActionImpl commentActionImpl0, int v, int v1, k2 k20) {
        q.g(k20, "onEvent");
        if(k20 instanceof W1) {
            commentActionImpl0.reportCmt(v, v1);
            return H.a;
        }
        if(k20 instanceof K1) {
            switch(WhenMappings.$EnumSwitchMapping$0[((K1)k20).b.a.ordinal()]) {
                case 1: {
                    commentActionImpl0.openCmtEditView(v, v1);
                    break;
                }
                case 2: {
                    commentActionImpl0.removeCmt(v, v1);
                    return H.a;
                }
                case 3: {
                    commentActionImpl0.reportCmt(v, v1);
                    return H.a;
                }
                default: {
                    return H.a;
                }
            }
        }
        return H.a;
    }

    private final void updateRecommendActionView(boolean z, TextView textView0, cmtList cmtResViewModel$result$cmtList0, RecommenderView recommenderView0) {
        c c0 = c.c;
        if(z) {
            textView0.setText(StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.recmcnt), 0xF423F));
            textView0.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtRecomCountIconResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag), 0, 0, 0);
            textView0.setTextColor(ColorUtils.getColor(this.fragment.getContext(), CmtResourceUtils.getCmtRecomCountColorResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag)));
        }
        else {
            textView0.setText(StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt), 0xF423F));
            textView0.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtNonRecomCountIconResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag), 0, 0, 0);
            textView0.setTextColor(ColorUtils.getColor(this.fragment.getContext(), CmtResourceUtils.getCmtNonRecomCountColorResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag)));
        }
        if(cmtResViewModel$result$cmtList0.recommenderInfo != null) {
            ViewUtils.showWhen(recommenderView0, true);
            recommenderView0.setProfileImage((cmtResViewModel$result$cmtList0.recommenderInfo == null ? null : cmtResViewModel$result$cmtList0.recommenderInfo.mypageimg));
            return;
        }
        ViewUtils.showWhen(recommenderView0, false);
    }

    private final void updateRecommendState(int v, int v1, boolean z, TextView textView0, RecommenderView recommenderView0) {
        LogU.Companion.d("CommentActionImpl", v + ", " + v1 + ", " + z);
        LoadPgnRes loadPgnRes0 = this.loadPgnRes;
        if(loadPgnRes0 != null && this.isLoadPgnResValid(loadPgnRes0) && this.fragment.isFragmentValid()) {
            if(!((e0)o.a()).m()) {
                this.fragment.showLoginPopup();
                return;
            }
            if(loadPgnRes0.result != null && (loadPgnRes0.result.spaminfo != null && loadPgnRes0.result.spaminfo.breakmemberflag)) {
                this.showBreakMemberGuidePopup(loadPgnRes0);
                return;
            }
            cmtList cmtResViewModel$result$cmtList0 = this.getValidCommentInfoAdapterItem(v, v1);
            if(cmtResViewModel$result$cmtList0 != null) {
                if(u.v(((e0)o.a()).j()).equals(cmtResViewModel$result$cmtList0.memberinfo.memberkey)) {
                    ToastManager.showShort("본인이 작성한 글은 추천 또는 비추천 할 수 없습니다.");
                    return;
                }
                if(this.isRequestDone) {
                    if((!z || !cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag) && (z || !cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag)) {
                        this.requestInsertRecm(cmtResViewModel$result$cmtList0, z, textView0, recommenderView0);
                    }
                    else {
                        this.requestCancelRecm(cmtResViewModel$result$cmtList0, z, textView0, recommenderView0);
                    }
                    this.isRequestDone = false;
                }
            }
        }
    }
}

