package com.iloen.melon.fragments.news;

import Ac.v2;
import F8.p;
import Hd.F0;
import W5.e;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.comments.CommentActionImplKt;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolder.OnStateChangeListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.LoadPgnReq;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.FeedLogsDeleteFeedLogReq.Params;
import com.iloen.melon.net.v6x.request.FeedLogsDeleteFeedLogReq;
import com.iloen.melon.net.v6x.request.FeedLogsListReq;
import com.iloen.melon.net.v6x.request.FeedLogsResetCountReq;
import com.iloen.melon.net.v6x.response.FeedLogsListRes.FEEDLOGLIST;
import com.iloen.melon.net.v6x.response.FeedLogsListRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.FamilyAppHelper;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.B1;
import com.melon.ui.k2;
import com.melon.ui.popup.b;
import d5.f;
import gd.w5;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;
import zd.x;

@Metadata(d1 = {"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000E\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\fJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\r\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u00132\b\u0010\r\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001B\u0010\u001C\u001A\u0006\u0012\u0002\b\u00030\u001B2\u0006\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J-\u0010\'\u001A\u00020&2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010$\u001A\u0004\u0018\u00010#2\b\u0010%\u001A\u0004\u0018\u00010\u0005H\u0014\u00A2\u0006\u0004\b\'\u0010(J!\u0010-\u001A\u00020\n2\u0006\u0010*\u001A\u00020)2\b\u0010,\u001A\u0004\u0018\u00010+H\u0016\u00A2\u0006\u0004\b-\u0010.J!\u0010/\u001A\u00020\n2\u0006\u0010*\u001A\u00020)2\b\u0010,\u001A\u0004\u0018\u00010+H\u0016\u00A2\u0006\u0004\b/\u0010.J!\u00100\u001A\u00020\n2\u0006\u0010*\u001A\u00020)2\b\u0010,\u001A\u0004\u0018\u00010+H\u0016\u00A2\u0006\u0004\b0\u0010.J!\u00101\u001A\u00020\n2\u0006\u0010*\u001A\u00020)2\b\u0010,\u001A\u0004\u0018\u00010+H\u0016\u00A2\u0006\u0004\b1\u0010.J\u001F\u00105\u001A\u00020\n2\u0006\u00102\u001A\u00020\u00052\u0006\u00104\u001A\u000203H\u0016\u00A2\u0006\u0004\b5\u00106J\u0017\u00109\u001A\u00020\n2\u0006\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010;\u001A\u00020\n2\u0006\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\b;\u0010:J\u000F\u0010<\u001A\u00020&H\u0016\u00A2\u0006\u0004\b<\u0010=J\u000F\u0010>\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b>\u0010\u0004J\u000F\u0010?\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b?\u0010\u0004J\u0017\u0010@\u001A\u00020\n2\u0006\u0010,\u001A\u00020+H\u0002\u00A2\u0006\u0004\b@\u0010AJ\u001F\u0010C\u001A\u00020\n2\u0006\u0010*\u001A\u00020)2\u0006\u0010B\u001A\u00020+H\u0002\u00A2\u0006\u0004\bC\u0010.J\u001F\u0010E\u001A\u00020\n2\u0006\u0010D\u001A\u00020)2\u0006\u0010B\u001A\u00020+H\u0002\u00A2\u0006\u0004\bE\u0010.J\u000F\u0010F\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bF\u0010\u0004J/\u0010K\u001A\u00020\n2\u0006\u0010G\u001A\u00020)2\u0006\u0010H\u001A\u00020\u00052\u0006\u0010I\u001A\u00020\u00052\u0006\u0010J\u001A\u00020&H\u0002\u00A2\u0006\u0004\bK\u0010LJ\u000F\u0010M\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bM\u0010\u0004J\u000F\u0010N\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bN\u0010\u0004J\u000F\u0010O\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bO\u0010\u0004J\u0017\u0010P\u001A\u00020\n2\u0006\u0010,\u001A\u00020+H\u0002\u00A2\u0006\u0004\bP\u0010AR\u0018\u0010Q\u001A\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010<\u001A\u00020&8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010SR0\u0010V\u001A\u001E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002030Tj\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000203`U8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bV\u0010WR$\u0010Z\u001A\u0012\u0012\u0004\u0012\u0002070Xj\b\u0012\u0004\u0012\u000207`Y8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bZ\u0010[\u00A8\u0006]"}, d2 = {"Lcom/iloen/melon/fragments/news/FeedLogsListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/fragments/news/OnActionListener;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "", "position", "Lcom/iloen/melon/net/v6x/response/FeedLogsListRes$FEEDLOGLIST;", "feedLogsInfo", "onProfileClickListener", "(ILcom/iloen/melon/net/v6x/response/FeedLogsListRes$FEEDLOGLIST;)V", "onMessageClickListener", "onContentsClickListener", "onMessageLongClickListener", "key", "Lcom/kakao/tiara/data/ViewImpContent;", "viewImpContent", "onImpLogListener", "(Ljava/lang/String;Lcom/kakao/tiara/data/ViewImpContent;)V", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "listener", "addOnStateChangeListener", "(Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;)V", "removeOnStateChangeListener", "isForegroundFragment", "()Z", "onStart", "onStop", "openContentsPage", "(Lcom/iloen/melon/net/v6x/response/FeedLogsListRes$FEEDLOGLIST;)V", "item", "openContextListPopup", "pos", "deleteItem", "fetchFeedLogCountReset", "orderNum", "clickCopy", "metaId", "isTodayLog", "sendClickLog", "(ILjava/lang/String;Ljava/lang/String;Z)V", "startViewableCheck", "stopViewableCheck", "tiaraViewImpMapFlush", "moveReplyPage", "lastIndexKey", "Ljava/lang/String;", "Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "tiaraViewImpMap", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onStateChangeListenerHashSet", "Ljava/util/HashSet;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FeedLogsListFragment extends MetaContentBaseFragment implements OnActionListener {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/news/FeedLogsListFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/news/FeedLogsListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final FeedLogsListFragment newInstance() {
            FeedLogsListFragment feedLogsListFragment0 = new FeedLogsListFragment();
            feedLogsListFragment0.setArguments(new Bundle());
            return feedLogsListFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "FeedLogsListFragment";
    private boolean isForegroundFragment;
    @Nullable
    private String lastIndexKey;
    @NotNull
    private final HashSet onStateChangeListenerHashSet;
    @NotNull
    private final HashMap tiaraViewImpMap;

    static {
        FeedLogsListFragment.Companion = new Companion(null);
        FeedLogsListFragment.$stable = 8;
    }

    public FeedLogsListFragment() {
        this.tiaraViewImpMap = new HashMap();
        this.onStateChangeListenerHashSet = new HashSet();
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void addOnStateChangeListener(@NotNull OnStateChangeListener viewableCheckViewHolder$OnStateChangeListener0) {
        q.g(viewableCheckViewHolder$OnStateChangeListener0, "listener");
        synchronized(this.onStateChangeListenerHashSet) {
            this.onStateChangeListenerHashSet.add(viewableCheckViewHolder$OnStateChangeListener0);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new FeedLogsListAdapter(context0, null);
        ((FeedLogsListAdapter)j00).setActionListener(this);
        return j00;
    }

    public static void d0(Object object0) {
    }

    private final void deleteItem(int v, FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        Params feedLogsDeleteFeedLogReq$Params0 = new Params();
        feedLogsDeleteFeedLogReq$Params0.rowKey = feedLogsListRes$FEEDLOGLIST0.rowKey;
        RequestBuilder.newInstance(new FeedLogsDeleteFeedLogReq(this.getContext(), feedLogsDeleteFeedLogReq$Params0)).tag("FeedLogsListFragment").listener(new e(this, feedLogsListRes$FEEDLOGLIST0, v, 8)).errorListener(new com.iloen.melon.fragments.musicmessage.e(6)).request();
    }

    private static final void deleteItem$lambda$14(FeedLogsListFragment feedLogsListFragment0, FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0, int v, FeedLogsListRes feedLogsListRes0) {
        if(feedLogsListRes0.isSuccessful() && feedLogsListFragment0.isFragmentValid()) {
            ToastManager.showShort(0x7F130435);  // string:feed_logs_deleted "소식이 삭제되었습니다."
            j0 j00 = feedLogsListFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.news.FeedLogsListAdapter");
            ((FeedLogsListAdapter)j00).remove(feedLogsListRes$FEEDLOGLIST0);
            j0 j01 = feedLogsListFragment0.mAdapter;
            q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.news.FeedLogsListAdapter");
            if(((FeedLogsListAdapter)j01).getCount() == 0 || v == 1) {
                feedLogsListFragment0.startFetch(i.b);
            }
        }
    }

    private static final void deleteItem$lambda$15(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public static void e0(VolleyError volleyError0) {
        FeedLogsListFragment.deleteItem$lambda$15(volleyError0);
    }

    public static void f0(FeedLogsListFragment feedLogsListFragment0, FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0, int v, FeedLogsListRes feedLogsListRes0) {
        FeedLogsListFragment.deleteItem$lambda$14(feedLogsListFragment0, feedLogsListRes$FEEDLOGLIST0, v, feedLogsListRes0);
    }

    private final void fetchFeedLogCountReset() {
        RequestBuilder.newInstance(new FeedLogsResetCountReq(this.getContext())).listener(new com.iloen.melon.fragments.musicmessage.e(4)).request();
    }

    private static final void fetchFeedLogCountReset$lambda$16(Object object0) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.k0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public static void h0(FeedLogsListFragment feedLogsListFragment0, View view0) {
        FeedLogsListFragment.onViewCreated$lambda$1$lambda$0(feedLogsListFragment0, view0);
    }

    public static void i0(VolleyError volleyError0) {
        FeedLogsListFragment.moveReplyPage$lambda$21(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public boolean isForegroundFragment() {
        return this.isForegroundFragment;
    }

    private final void moveReplyPage(FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params0 = new com.iloen.melon.net.v3x.comments.LoadPgnReq.Params();
        Integer integer0 = Integer.valueOf(feedLogsListRes$FEEDLOGLIST0.chnlSeq);
        q.f(integer0, "valueOf(...)");
        loadPgnReq$Params0.chnlSeq = integer0.intValue();
        loadPgnReq$Params0.contsRefValue = feedLogsListRes$FEEDLOGLIST0.contsId;
        RequestBuilder.newInstance(new LoadPgnReq(this.getContext(), loadPgnReq$Params0)).tag("FeedLogsListFragment").listener(new Listener() {
            public void onResponse(LoadPgnRes loadPgnRes0) {
                String s = null;
                if((loadPgnRes0 == null ? null : loadPgnRes0.result) == null) {
                    if(loadPgnRes0 != null) {
                        s = loadPgnRes0.errormessage;
                    }
                    if(s == null) {
                        ToastManager.showShort(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    }
                    else {
                        ToastManager.showShort(loadPgnRes0.errormessage);
                    }
                    feedLogsListRes$FEEDLOGLIST0.performFetchCompleteOnlyViews();
                    return;
                }
                String s1 = !"3A0005".equals(this.$feedLogsInfo.actTypeCode) || !"REPL".equals(this.$feedLogsInfo.actType) ? this.$feedLogsInfo.cmtSeq : this.$feedLogsInfo.parentCmtSeq;
                Integer integer0 = Integer.valueOf(this.$feedLogsInfo.chnlSeq);
                q.f(integer0, "valueOf(...)");
                String s2 = this.$feedLogsInfo.contsId;
                q.f(s2, "contsId");
                int v = ProtocolUtils.parseInt(s1, 0);
                result loadPgnRes$result0 = loadPgnRes0.result;
                q.f(loadPgnRes$result0, "result");
                CommentConfig commentConfig0 = CommentActionImplKt.toUiModel(loadPgnRes$result0);
                q.g(commentConfig0, "config");
                v2 v20 = new v2();
                v20.setArguments(f.j(new m[]{new m("key_cmt_seq", v), new m("key_channel_seq", integer0.intValue()), new m("key_content_ref_value", s2), new m("key_cmt_config", commentConfig0)}));
                v20.m(feedLogsListRes$FEEDLOGLIST0.getParentFragment());
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((LoadPgnRes)object0));
            }
        }).errorListener(new com.iloen.melon.fragments.musicmessage.e(5)).request();
    }

    private static final void moveReplyPage$lambda$21(VolleyError volleyError0) {
        ToastManager.showShort(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    @NotNull
    public static final FeedLogsListFragment newInstance() {
        return FeedLogsListFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.news.OnActionListener
    public void onContentsClickListener(int v, @Nullable FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        if(feedLogsListRes$FEEDLOGLIST0 != null && !q.b(feedLogsListRes$FEEDLOGLIST0.feedType, "M2") && !q.b(feedLogsListRes$FEEDLOGLIST0.feedType, "M10")) {
            String s = feedLogsListRes$FEEDLOGLIST0.feedType;
            if(s == null) {
                this.openContentsPage(feedLogsListRes$FEEDLOGLIST0);
            }
            else {
                switch(s) {
                    case "K1": {
                        Navigator.INSTANCE.openMusicDnaMonthlyLog(feedLogsListRes$FEEDLOGLIST0.logMonth, true);
                        break;
                    }
                    case "M1": {
                        w5 w50 = new w5();
                        Navigator.INSTANCE.open(w50);
                        break;
                    }
                    case "M12": 
                    case "M13": {
                        if(feedLogsListRes$FEEDLOGLIST0.inboxSeq != null && feedLogsListRes$FEEDLOGLIST0.inboxSeq.length() != 0) {
                            this.openMusicMessagePage(null, feedLogsListRes$FEEDLOGLIST0.inboxSeq, "N");
                        }
                        break;
                    }
                    case "M9": {
                        Navigator.openGiftBoxDetailById(feedLogsListRes$FEEDLOGLIST0.giftNo);
                        break;
                    }
                    case "W1": 
                    case "W2": {
                        MelonLinkExecutor.open(feedLogsListRes$FEEDLOGLIST0.linkType, feedLogsListRes$FEEDLOGLIST0.linkUrl);
                        break;
                    }
                    default: {
                        this.openContentsPage(feedLogsListRes$FEEDLOGLIST0);
                    }
                }
            }
            String s1 = this.getString(0x7F130EA2);  // string:tiara_feedlogs_copy_news "소식"
            q.f(s1, "getString(...)");
            String s2 = feedLogsListRes$FEEDLOGLIST0.feedType;
            q.f(s2, "feedType");
            this.sendClickLog(v, s1, s2, feedLogsListRes$FEEDLOGLIST0.isToday());
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.fetchFeedLogCountReset();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02A9, viewGroup0, false);  // layout:fragment_detail_basic
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        i i1 = i.b;
        if(i1.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.news.FeedLogsListAdapter");
            ((FeedLogsListAdapter)j00).clear();
        }
        com.iloen.melon.net.v6x.request.FeedLogsListReq.Params feedLogsListReq$Params0 = new com.iloen.melon.net.v6x.request.FeedLogsListReq.Params();
        feedLogsListReq$Params0.pageSize = 20;
        feedLogsListReq$Params0.lastIndexKey = i1.equals(i0) ? null : this.lastIndexKey;
        feedLogsListReq$Params0.isReset = "N";
        RequestBuilder.newInstance(new FeedLogsListReq(this.getContext(), feedLogsListReq$Params0)).tag("FeedLogsListFragment").listener(new Listener() {
            public void onResponse(FeedLogsListRes feedLogsListRes0) {
                if(!i0.prepareFetchComplete(feedLogsListRes0)) {
                    return;
                }
                if((feedLogsListRes0 == null ? null : feedLogsListRes0.response) != null) {
                    i0.lastIndexKey = feedLogsListRes0.response.lastIndexKey;
                    s s0 = new s(feedLogsListRes0.response.section, feedLogsListRes0.response.page, feedLogsListRes0.response.menuId, null);
                    i0.mMelonTiaraProperty = s0;
                }
                i0.performFetchComplete(this.$type, feedLogsListRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((FeedLogsListRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void onImpLogListener(@NotNull String s, @NotNull ViewImpContent viewImpContent0) {
        q.g(s, "key");
        q.g(viewImpContent0, "viewImpContent");
        synchronized(this.tiaraViewImpMap) {
            ViewImpContent viewImpContent1 = (ViewImpContent)this.tiaraViewImpMap.put(s, viewImpContent0);
        }
    }

    @Override  // com.iloen.melon.fragments.news.OnActionListener
    public void onMessageClickListener(int v, @Nullable FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        if(feedLogsListRes$FEEDLOGLIST0 != null && !q.b(feedLogsListRes$FEEDLOGLIST0.feedType, "M2") && !q.b(feedLogsListRes$FEEDLOGLIST0.feedType, "M10")) {
            String s = feedLogsListRes$FEEDLOGLIST0.feedType;
            if(s != null) {
                switch(s) {
                    case "M6": 
                    case "M7": 
                    case "M8": {
                        this.moveReplyPage(feedLogsListRes$FEEDLOGLIST0);
                        String s1 = this.getString(0x7F130EA2);  // string:tiara_feedlogs_copy_news "소식"
                        q.f(s1, "getString(...)");
                        String s2 = feedLogsListRes$FEEDLOGLIST0.feedType;
                        q.f(s2, "feedType");
                        this.sendClickLog(v, s1, s2, feedLogsListRes$FEEDLOGLIST0.isToday());
                        return;
                    }
                }
            }
            this.onContentsClickListener(v, feedLogsListRes$FEEDLOGLIST0);
        }
    }

    @Override  // com.iloen.melon.fragments.news.OnActionListener
    public void onMessageLongClickListener(int v, @Nullable FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        if(feedLogsListRes$FEEDLOGLIST0 != null) {
            this.openContextListPopup(v, feedLogsListRes$FEEDLOGLIST0);
        }
    }

    @Override  // com.iloen.melon.fragments.news.OnActionListener
    public void onProfileClickListener(int v, @Nullable FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        if(feedLogsListRes$FEEDLOGLIST0 == null) {
            return;
        }
        String s = feedLogsListRes$FEEDLOGLIST0.profileLandType;
        if(s != null) {
            switch(s) {
                case "A": {
                    Navigator.openArtistInfo(feedLogsListRes$FEEDLOGLIST0.profileId);
                    break;
                }
                case "C": {
                    Navigator.INSTANCE.openStationProgram(feedLogsListRes$FEEDLOGLIST0.profileId);
                    break;
                }
                case "U": {
                    Navigator.openUserMain(feedLogsListRes$FEEDLOGLIST0.profileId);
                }
            }
        }
        String s1 = this.getString(0x7F130EA3);  // string:tiara_feedlogs_copy_profile "프로필"
        q.f(s1, "getString(...)");
        String s2 = feedLogsListRes$FEEDLOGLIST0.feedType;
        q.f(s2, "feedType");
        this.sendClickLog(v, s1, s2, feedLogsListRes$FEEDLOGLIST0.isToday());
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        this.isForegroundFragment = true;
        this.startViewableCheck();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        this.isForegroundFragment = false;
        this.tiaraViewImpMapFlush();
        this.stopViewableCheck();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        p p0 = new p(1);
        p0.c = new com.iloen.melon.fragments.detail.viewholder.p(this, 6);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            p0.g(new F8.m(2, false));
            titleBar0.a(p0);
            titleBar0.setTitle(this.getString(0x7F130788));  // string:news "소식"
            titleBar0.f(true);
        }
    }

    private static final void onViewCreated$lambda$1$lambda$0(FeedLogsListFragment feedLogsListFragment0, View view0) {
        feedLogsListFragment0.performBackPress();
    }

    private final void openContentsPage(FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        ContsTypeCode contsTypeCode0 = ContsTypeCode.valueOf(feedLogsListRes$FEEDLOGLIST0.contsTypeCode);
        if(q.b(contsTypeCode0, ContsTypeCode.SONG)) {
            String s = feedLogsListRes$FEEDLOGLIST0.contsId;
            q.f(s, "contsId");
            Navigator.openSongInfo(s);
            return;
        }
        ContsTypeCode contsTypeCode1 = ContsTypeCode.PHOTO;
        if(q.b(contsTypeCode0, contsTypeCode1)) {
            Navigator.INSTANCE.openPhotoInfo(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.ALBUM)) {
            Navigator.openAlbumInfo(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.MELON_MAGAZINE)) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.a = feedLogsListRes$FEEDLOGLIST0.linkType;
            melonLinkInfo0.b = feedLogsListRes$FEEDLOGLIST0.linkUrl;
            MelonLinkExecutor.open(melonLinkInfo0);
            return;
        }
        if(q.b(contsTypeCode0, contsTypeCode1)) {
            Navigator.openPhotoDetailView(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.ARTIST_PLAYLIST)) {
            Navigator.INSTANCE.openArtistPlaylistDetail(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.PLAYLIST)) {
            Navigator.INSTANCE.openPlaylistDetail(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.NOW_PLAYING)) {
            Navigator.INSTANCE.openNowPlayingDetail(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.ARTIST)) {
            Navigator.openArtistInfo(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.VIDEO)) {
            this.showMvInfoPage(feedLogsListRes$FEEDLOGLIST0.contsId, this.mMenuId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.DJ_PLAYLIST)) {
            Navigator.openDjPlaylistDetail(feedLogsListRes$FEEDLOGLIST0.contsId);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.TICKET)) {
            MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
            melonLinkInfo1.a = feedLogsListRes$FEEDLOGLIST0.linkType;
            melonLinkInfo1.b = feedLogsListRes$FEEDLOGLIST0.linkUrl;
            FamilyAppHelper.getFamilyApp(v9.f.a).openApp(melonLinkInfo1);
            return;
        }
        if(q.b(contsTypeCode0, ContsTypeCode.RADIO_CAST)) {
            if(!TextUtils.isEmpty(feedLogsListRes$FEEDLOGLIST0.contsId)) {
                if(TextUtils.isEmpty(this.mMenuId)) {
                    this.mMenuId = "1000002296";
                }
                Navigator.INSTANCE.openCastEpisodeDetail(feedLogsListRes$FEEDLOGLIST0.contsId);
            }
            return;
        }
        MelonLinkInfo melonLinkInfo2 = new MelonLinkInfo();
        melonLinkInfo2.a = feedLogsListRes$FEEDLOGLIST0.linkType;
        melonLinkInfo2.b = feedLogsListRes$FEEDLOGLIST0.linkUrl;
        MelonLinkExecutor.open(melonLinkInfo2);
    }

    private final void openContextListPopup(int v, FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0) {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.r);
        b.t(this.getChildFragmentManager(), arrayList0, new F0(this, v, feedLogsListRes$FEEDLOGLIST0, 12));
    }

    private static final H openContextListPopup$lambda$12(FeedLogsListFragment feedLogsListFragment0, int v, FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0, k2 k20) {
        q.g(k20, "event");
        if(k20 instanceof B1) {
            feedLogsListFragment0.deleteItem(v, feedLogsListRes$FEEDLOGLIST0);
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void removeOnStateChangeListener(@NotNull OnStateChangeListener viewableCheckViewHolder$OnStateChangeListener0) {
        q.g(viewableCheckViewHolder$OnStateChangeListener0, "listener");
        synchronized(this.onStateChangeListenerHashSet) {
            this.onStateChangeListenerHashSet.remove(viewableCheckViewHolder$OnStateChangeListener0);
        }
    }

    private final void sendClickLog(int v, String s, String s1, boolean z) {
        if(s.length() > 0) {
            String s2 = z ? this.getString(0x7F130EA1) : this.getString(0x7F130EA0);  // string:tiara_feed_logs_layer1_today "오늘소식"
            q.d(s2);
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.news.FeedLogsListAdapter");
            int v1 = ((FeedLogsListAdapter)j00).getDataPosition(v, z);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = this.mMelonTiaraProperty.c;
            g0.a = "페이지이동";
            g0.b = this.mMelonTiaraProperty.a;
            g0.c = this.mMelonTiaraProperty.b;
            g0.d = ActionKind.ClickContent;
            g0.y = s2;
            g0.C = String.valueOf(v1 + 1);
            g0.F = s;
            g0.e = s1;
            g0.H = "melon_recommend";
            g0.a().track();
        }
    }

    private final void startViewableCheck() {
        synchronized(this.onStateChangeListenerHashSet) {
            Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                ((OnStateChangeListener)object0).onStart();
            }
        }
    }

    private final void stopViewableCheck() {
        synchronized(this.onStateChangeListenerHashSet) {
            Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                ((OnStateChangeListener)object0).onStop();
            }
        }
    }

    private final void tiaraViewImpMapFlush() {
        HashMap hashMap0 = this.tiaraViewImpMap;
        __monitor_enter(hashMap0);
        try {
            if(!this.tiaraViewImpMap.isEmpty()) {
                ContentList contentList0 = new ContentList();
                for(Object object0: this.tiaraViewImpMap.values()) {
                    contentList0.addContent(((ViewImpContent)object0));
                }
                this.tiaraViewImpMap.clear();
                p8.i i0 = new p8.i();  // 初始化器: Lp8/f;-><init>()V
                i0.b = this.mMelonTiaraProperty.a;
                i0.c = this.mMelonTiaraProperty.b;
                i0.I = this.mMelonTiaraProperty.c;
                i0.Z = contentList0;
                i0.a().track();
                goto label_20;
            }
            goto label_22;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(hashMap0);
        throw throwable0;
    label_20:
        __monitor_exit(hashMap0);
        return;
    label_22:
        __monitor_exit(hashMap0);
    }
}

