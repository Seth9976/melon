package com.iloen.melon.fragments.detail;

import B.a;
import Tf.o;
import Tf.v;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.UnderlineTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventHighlight;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.SongLyricHighlightEditReq.Param;
import com.iloen.melon.net.v6x.request.SongLyricHighlightEditReq;
import com.iloen.melon.net.v6x.request.SongLyricHighlightInsertReq;
import com.iloen.melon.net.v6x.response.SongLyricHighlightEditRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongLyricHighlightEditRes;
import com.iloen.melon.net.v6x.response.SongLyricHighlightInsertRes;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u00BA\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0003XYZB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001AJ-\u0010\"\u001A\u00020\u00052\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010!\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010*\u001A\u00020)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J!\u00103\u001A\u00020\u00152\b\u00100\u001A\u0004\u0018\u00010/2\u0006\u00102\u001A\u000201H\u0014\u00A2\u0006\u0004\b3\u00104J\u000F\u00105\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b5\u0010\u0007J\u0017\u00106\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b6\u00107J\u0017\u0010:\u001A\u00020\u00152\u0006\u00109\u001A\u000208H\u0002\u00A2\u0006\u0004\b:\u0010;J\u001F\u0010@\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010?0>2\u0006\u0010=\u001A\u00020<H\u0002\u00A2\u0006\u0004\b@\u0010AJ\u0011\u0010C\u001A\u0004\u0018\u00010BH\u0002\u00A2\u0006\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010H\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010I\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010FR\u0016\u0010J\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010KR&\u0010N\u001A\u0012\u0012\u0004\u0012\u00020\b0Lj\b\u0012\u0004\u0012\u00020\b`M8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR&\u0010P\u001A\u0012\u0012\u0004\u0012\u00020\u00050Lj\b\u0012\u0004\u0012\u00020\u0005`M8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bP\u0010OR\u0014\u0010R\u001A\u00020Q8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001A\u00020T8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bU\u0010V\u00A8\u0006["}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "isScreenLandscapeSupported", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "shouldShowMiniPlayer", "initView", "(Landroid/view/View;)V", "Lcom/iloen/melon/net/v6x/response/SongLyricHighlightEditRes$RESPONSE;", "res", "setData", "(Lcom/iloen/melon/net/v6x/response/SongLyricHighlightEditRes$RESPONSE;)V", "Lcom/iloen/melon/net/v6x/request/SongLyricHighlightEditReq$Param;", "params", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/SongLyricHighlightEditRes;", "requestSongLyricHighlightEditAsync", "(Lcom/iloen/melon/net/v6x/request/SongLyricHighlightEditReq$Param;)Lkotlinx/coroutines/Deferred;", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "songId", "Ljava/lang/String;", "pageMetaId", "pageMetaName", "endpointUrl", "isEmptyHighlight", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lyricList", "Ljava/util/ArrayList;", "isHighlightLineList", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "HighLightAdapter", "DataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LyricHighLightFragment extends MetaContentBaseFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightFragment$Companion;", "", "<init>", "()V", "ARG_ENDPOINT_URL", "", "TAG", "STATUS_SUCCESS", "STATUS_FAIL", "ENDPOINT_SONG", "ENDPOINT_PLAYER", "HIGHLIGHT_PADDING", "", "newInstance", "Lcom/iloen/melon/fragments/detail/LyricHighLightFragment;", "songId", "endpointUrl", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LyricHighLightFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "songId");
            q.g(s1, "endpointUrl");
            LyricHighLightFragment lyricHighLightFragment0 = new LyricHighLightFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            bundle0.putString("argEndpointUrl", s1);
            lyricHighLightFragment0.setArguments(bundle0);
            return lyricHighLightFragment0;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00052\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightFragment$DataWrapper;", "", "lyric", "", "highlightLine", "", "<init>", "(Ljava/lang/String;Z)V", "getLyric", "()Ljava/lang/String;", "setLyric", "(Ljava/lang/String;)V", "getHighlightLine", "()Z", "setHighlightLine", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class DataWrapper {
        private boolean highlightLine;
        @NotNull
        private String lyric;

        public DataWrapper(@NotNull String s, boolean z) {
            q.g(s, "lyric");
            super();
            this.lyric = s;
            this.highlightLine = z;
        }

        @NotNull
        public final String component1() {
            return this.lyric;
        }

        public final boolean component2() {
            return this.highlightLine;
        }

        @NotNull
        public final DataWrapper copy(@NotNull String s, boolean z) {
            q.g(s, "lyric");
            return new DataWrapper(s, z);
        }

        public static DataWrapper copy$default(DataWrapper lyricHighLightFragment$DataWrapper0, String s, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                s = lyricHighLightFragment$DataWrapper0.lyric;
            }
            if((v & 2) != 0) {
                z = lyricHighLightFragment$DataWrapper0.highlightLine;
            }
            return lyricHighLightFragment$DataWrapper0.copy(s, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DataWrapper)) {
                return false;
            }
            return q.b(this.lyric, ((DataWrapper)object0).lyric) ? this.highlightLine == ((DataWrapper)object0).highlightLine : false;
        }

        public final boolean getHighlightLine() {
            return this.highlightLine;
        }

        @NotNull
        public final String getLyric() {
            return this.lyric;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.highlightLine) + this.lyric.hashCode() * 0x1F;
        }

        public final void setHighlightLine(boolean z) {
            this.highlightLine = z;
        }

        public final void setLyric(@NotNull String s) {
            q.g(s, "<set-?>");
            this.lyric = s;
        }

        @Override
        @NotNull
        public String toString() {
            return "DataWrapper(lyric=" + this.lyric + ", highlightLine=" + this.highlightLine + ")";
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001A\u00020\u00112\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001C\u001A\u00020\u00032\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u001B\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ)\u0010 \u001A\u00020\u001F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u0014H\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010#¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightFragment$HighLightAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/detail/LyricHighLightFragment$DataWrapper;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/LyricHighLightFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_ONBOADING", "I", "VIEW_TYPE_LYRIC", "LyricsViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class HighLightAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightFragment$HighLightAdapter$LyricsViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/detail/LyricHighLightFragment$HighLightAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/UnderlineTextView;", "kotlin.jvm.PlatformType", "tvLyrics", "Lcom/iloen/melon/custom/UnderlineTextView;", "getTvLyrics", "()Lcom/iloen/melon/custom/UnderlineTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LyricsViewHolder extends O0 {
            private final UnderlineTextView tvLyrics;

            public LyricsViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                HighLightAdapter.this = lyricHighLightFragment$HighLightAdapter0;
                super(view0);
                UnderlineTextView underlineTextView0 = (UnderlineTextView)view0.findViewById(0x7F0A0CA9);  // id:tv_lyric
                this.tvLyrics = underlineTextView0;
                underlineTextView0.setShadowLayer(10.0f, 0.0f, 0.0f, 0);
                underlineTextView0.setPadding(10, 10, 10, 10);
            }

            public final UnderlineTextView getTvLyrics() {
                return this.tvLyrics;
            }
        }

        private final int VIEW_TYPE_LYRIC;
        private final int VIEW_TYPE_ONBOADING;

        public HighLightAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            LyricHighLightFragment.this = lyricHighLightFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_LYRIC = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_LYRIC;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            String s2;
            if(httpResponse0 instanceof SongLyricHighlightEditRes) {
                this.setMenuId(((SongLyricHighlightEditRes)httpResponse0).getMenuId());
                LyricHighLightFragment lyricHighLightFragment0 = LyricHighLightFragment.this;
                RESPONSE songLyricHighlightEditRes$RESPONSE0 = ((SongLyricHighlightEditRes)httpResponse0).response;
                String s1 = "";
                if(songLyricHighlightEditRes$RESPONSE0 == null) {
                    s2 = "";
                }
                else {
                    s2 = songLyricHighlightEditRes$RESPONSE0.pageMetaId;
                    if(s2 == null) {
                        s2 = "";
                    }
                }
                lyricHighLightFragment0.pageMetaId = s2;
                LyricHighLightFragment lyricHighLightFragment1 = LyricHighLightFragment.this;
                RESPONSE songLyricHighlightEditRes$RESPONSE1 = ((SongLyricHighlightEditRes)httpResponse0).response;
                if(songLyricHighlightEditRes$RESPONSE1 != null) {
                    String s3 = songLyricHighlightEditRes$RESPONSE1.pageMetaName;
                    if(s3 != null) {
                        s1 = s3;
                    }
                }
                lyricHighLightFragment1.pageMetaName = s1;
                this.updateModifiedTime(this.getCacheKey());
                int v = LyricHighLightFragment.this.lyricList.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    Object object0 = LyricHighLightFragment.this.lyricList.get(v1);
                    q.f(object0, "get(...)");
                    Object object1 = LyricHighLightFragment.this.isHighlightLineList.get(v1);
                    q.f(object1, "get(...)");
                    this.add(new DataWrapper(((String)object0), ((Boolean)object1).booleanValue()));
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof LyricsViewHolder) {
                LyricHighLightFragment lyricHighLightFragment0 = LyricHighLightFragment.this;
                DataWrapper lyricHighLightFragment$DataWrapper0 = (DataWrapper)this.getItem(v1);
                if(lyricHighLightFragment$DataWrapper0.getHighlightLine()) {
                    ((LyricsViewHolder)o00).getTvLyrics().setText(lyricHighLightFragment$DataWrapper0.getLyric());
                    ((LyricsViewHolder)o00).getTvLyrics().setUnderlineColor(ColorUtils.getColor(this.getContext(), 0x7F0600A5));  // color:color_highlight
                    ((LyricsViewHolder)o00).getTvLyrics().setUnderlineWidth(ScreenUtils.dipToPixel(this.getContext(), 8.0f));
                }
                else {
                    ((LyricsViewHolder)o00).getTvLyrics().setText(lyricHighLightFragment$DataWrapper0.getLyric());
                    ((LyricsViewHolder)o00).getTvLyrics().setUnderlineColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                    ((LyricsViewHolder)o00).getTvLyrics().setUnderlineWidth(ScreenUtils.dipToPixel(this.getContext(), 0.0f));
                }
                ((LyricsViewHolder)o00).getTvLyrics().h();
                if(!o.H0(lyricHighLightFragment$DataWrapper0.getLyric())) {
                    ViewUtils.setOnClickListener(((LyricsViewHolder)o00).getTvLyrics(), new n(lyricHighLightFragment$DataWrapper0, lyricHighLightFragment0, v1, this));
                    ((LyricsViewHolder)o00).getTvLyrics().setPadding(0, ScreenUtils.dipToPixel(this.getContext(), 6.5f), 0, ScreenUtils.dipToPixel(this.getContext(), 6.5f));
                    return;
                }
                ((LyricsViewHolder)o00).getTvLyrics().setOnClickListener(null);
                ((LyricsViewHolder)o00).getTvLyrics().setPadding(0, ScreenUtils.dipToPixel(this.getContext(), 4.5f), 0, ScreenUtils.dipToPixel(this.getContext(), 4.5f));
            }
        }

        private static final void onBindViewImpl$lambda$4$lambda$3$lambda$2(DataWrapper lyricHighLightFragment$DataWrapper0, LyricHighLightFragment lyricHighLightFragment0, int v, HighLightAdapter lyricHighLightFragment$HighLightAdapter0, View view0) {
            lyricHighLightFragment$DataWrapper0.setHighlightLine(!lyricHighLightFragment$DataWrapper0.getHighlightLine());
            lyricHighLightFragment0.isHighlightLineList.set(v, Boolean.valueOf(lyricHighLightFragment$DataWrapper0.getHighlightLine()));
            lyricHighLightFragment$HighLightAdapter0.notifyItemChanged(v);
            if(lyricHighLightFragment$DataWrapper0.getHighlightLine()) {
                f f0 = lyricHighLightFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    f0.F = lyricHighLightFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                    f0.a().track();
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D022A, viewGroup0, false);  // layout:detail_song_highlight_lyric_item
            q.f(view0, "inflate(...)");
            return new LyricsViewHolder(this, view0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_ENDPOINT_URL = "argEndpointUrl";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String ENDPOINT_PLAYER = "player";
    @NotNull
    public static final String ENDPOINT_SONG = "song";
    private static final int HIGHLIGHT_PADDING = 10;
    @NotNull
    public static final String STATUS_FAIL = "0";
    @NotNull
    public static final String STATUS_SUCCESS = "1";
    @NotNull
    public static final String TAG = "LyricHighLightFragment";
    @NotNull
    private String endpointUrl;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    private boolean isEmptyHighlight;
    @NotNull
    private ArrayList isHighlightLineList;
    @NotNull
    private ArrayList lyricList;
    @NotNull
    private String pageMetaId;
    @NotNull
    private String pageMetaName;
    @NotNull
    private String songId;

    static {
        LyricHighLightFragment.Companion = new Companion(null);
        LyricHighLightFragment.$stable = 8;
    }

    public LyricHighLightFragment() {
        this.songId = "";
        this.pageMetaId = "";
        this.pageMetaName = "";
        this.endpointUrl = "";
        this.lyricList = new ArrayList();
        this.isHighlightLineList = new ArrayList();
        this.exceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.LyricHighLightFragment.exceptionHandler.1.1(throwable0, LyricHighLightFragment.this, null), 3, null);
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.detail.LyricHighLightFragment$exceptionHandler$1$1", f = "LyricHighLightFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.LyricHighLightFragment.exceptionHandler.1.1 extends oe.i implements we.n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.LyricHighLightFragment.exceptionHandler.1.1(Throwable throwable0, LyricHighLightFragment lyricHighLightFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                LyricHighLightFragment.this = lyricHighLightFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.LyricHighLightFragment.exceptionHandler.1.1(this.$throwable, LyricHighLightFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.LyricHighLightFragment.exceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    LyricHighLightFragment.access$getMResponseErrorListener$p$s1953874053(LyricHighLightFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s1953874053(LyricHighLightFragment lyricHighLightFragment0) {
        return lyricHighLightFragment0.mResponseErrorListener;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), 0x203);
        q.f(toolBar0, "initLayoutType(...)");
        return toolBar0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new HighLightAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.d.buildUpon().appendPath("highlightedit"), this.songId, "toString(...)");
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    private final f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty != null) {
            String s = "선택";
            f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
            String s1 = "";
            if(this.getContext() == null) {
                s = "";
            }
            String s2 = "가사리스트";
            f0.a = s;
            f0.b = this.mMelonTiaraProperty.a;
            f0.c = this.mMelonTiaraProperty.b;
            if(this.getContext() == null) {
                s2 = "";
            }
            f0.y = s2;
            f0.o = this.pageMetaId;
            if(this.getContext() != null) {
                s1 = "곡";
            }
            f0.p = s1;
            f0.q = this.pageMetaName;
            f0.I = this.mMelonTiaraProperty.c;
            return f0;
        }
        return null;
    }

    private final void initView(View view0) {
        View view1 = this.findViewById(0x7F0A0BAD);  // id:titlebar
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.title.TitleBar");
        ((TitleBar)view1).a(a.s(2));
        ((TitleBar)view1).setTitle(this.getString(0x7F130A7D));  // string:song_detail_title_lyric_highlight "가사 하이라이팅"
        ((TitleBar)view1).f(false);
        if(!MelonPrefs.getInstance().getBoolean("lyricHighlightingShown", false)) {
            ViewGroup viewGroup0 = (ViewGroup)view0.findViewById(0x7F0A08D5);  // id:onboading_container
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0613);  // id:iv_close
            viewGroup0.setVisibility(0);
            ViewUtils.setOnClickListener(imageView0, new T(viewGroup0, 3));
        }
        this.showToolBar();
    }

    private static final void initView$lambda$2(ViewGroup viewGroup0, View view0) {
        MelonPrefs.getInstance().setBoolean("lyricHighlightingShown", true);
        viewGroup0.setVisibility(8);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
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
        return layoutInflater0.inflate(0x7F0D0232, viewGroup0, false);  // layout:detail_song_lyrics_highlighting
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        boolean z = !this.isLoginUser();
        Param songLyricHighlightEditReq$Param0 = new Param();
        songLyricHighlightEditReq$Param0.songId = this.songId;
        songLyricHighlightEditReq$Param0.adultFlg = "";
        com.iloen.melon.fragments.detail.LyricHighLightFragment.onFetchStart.1 lyricHighLightFragment$onFetchStart$10 = new we.n(songLyricHighlightEditReq$Param0, null) {
            final Param $params;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                LyricHighLightFragment.this = lyricHighLightFragment0;
                this.$params = songLyricHighlightEditReq$Param0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.LyricHighLightFragment.onFetchStart.1(LyricHighLightFragment.this, this.$params, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.LyricHighLightFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred1 = LyricHighLightFragment.this.requestSongLyricHighlightEditAsync(this.$params);
                        this.L$0 = null;
                        this.label = 1;
                        object0 = deferred1.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        Deferred deferred2 = (Deferred)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        me.i i0 = (me.i)this.L$2;
                        SongLyricHighlightEditRes songLyricHighlightEditRes0 = (SongLyricHighlightEditRes)this.L$1;
                        Deferred deferred0 = (Deferred)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((SongLyricHighlightEditRes)object0) != null && ((SongLyricHighlightEditRes)object0).isSuccessful()) {
                    me.i i1 = Dispatchers.getMain().plus(LyricHighLightFragment.this.exceptionHandler);
                    com.iloen.melon.fragments.detail.LyricHighLightFragment.onFetchStart.1.1 lyricHighLightFragment$onFetchStart$1$10 = new we.n(((SongLyricHighlightEditRes)object0), null) {
                        final SongLyricHighlightEditRes $songLyricHighlightEditRes;
                        int label;

                        {
                            LyricHighLightFragment.this = lyricHighLightFragment0;
                            this.$songLyricHighlightEditRes = songLyricHighlightEditRes0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.detail.LyricHighLightFragment.onFetchStart.1.1(LyricHighLightFragment.this, this.$songLyricHighlightEditRes, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.detail.LyricHighLightFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            boolean z = LyricHighLightFragment.this.prepareFetchComplete(this.$songLyricHighlightEditRes);
                            H h0 = H.a;
                            if(!z) {
                                return h0;
                            }
                            RESPONSE songLyricHighlightEditRes$RESPONSE0 = this.$songLyricHighlightEditRes.response;
                            s s0 = new s(songLyricHighlightEditRes$RESPONSE0.section, songLyricHighlightEditRes$RESPONSE0.page, songLyricHighlightEditRes$RESPONSE0.menuId, null);
                            LyricHighLightFragment.this.mMelonTiaraProperty = s0;
                            LyricHighLightFragment.this.isEmptyHighlight = songLyricHighlightEditRes$RESPONSE0.hightlightLine == null || songLyricHighlightEditRes$RESPONSE0.hightlightLine.length() == 0;
                            LyricHighLightFragment.this.setData(songLyricHighlightEditRes$RESPONSE0);
                            LyricHighLightFragment.this.performFetchComplete(this.$songLyricHighlightEditRes);
                            return h0;
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                    if(BuildersKt.withContext(i1, lyricHighLightFragment$onFetchStart$1$10, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
        };
        BuildersKt__Builders_commonKt.launch$default(this, this.exceptionHandler, null, lyricHighLightFragment$onFetchStart$10, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.songId = l1.g(bundle0, "inState", "argItemId", "", "getString(...)");
        String s = bundle0.getString("argEndpointUrl", "");
        q.f(s, "getString(...)");
        this.endpointUrl = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.songId);
        bundle0.putString("argEndpointUrl", this.endpointUrl);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        if(30 == v) {
            if(this.isEmptyHighlight) {
                ArrayList arrayList0 = this.isHighlightLineList;
                if(arrayList0 == null || !arrayList0.isEmpty()) {
                    for(Object object0: arrayList0) {
                        if(!((Boolean)object0).booleanValue()) {
                            continue;
                        }
                        goto label_11;
                    }
                }
                ToastManager.show(0x7F1304A0);  // string:highlighting_toast_msg_do_lyric_select "가사를 선택해 주세요."
                return;
            }
        label_11:
            int v1 = 0;
            String s = "";
            for(Object object1: this.isHighlightLineList) {
                if(v1 >= 0) {
                    if(((Boolean)object1).booleanValue()) {
                        s = s.length() == 0 ? s + (v1 + 1) : s + "," + (v1 + 1);
                    }
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
            LogU.Companion.d("LyricHighLightFragment", "onToolBarClick choiceLine - " + s);
            boolean z = !this.isLoginUser();
            com.iloen.melon.net.v6x.request.SongLyricHighlightInsertReq.Param songLyricHighlightInsertReq$Param0 = new com.iloen.melon.net.v6x.request.SongLyricHighlightInsertReq.Param();
            songLyricHighlightInsertReq$Param0.songId = this.songId;
            songLyricHighlightInsertReq$Param0.adultFlg = "";
            songLyricHighlightInsertReq$Param0.choiceLine = s;
            RequestBuilder.newInstance(new SongLyricHighlightInsertReq(this.getContext(), songLyricHighlightInsertReq$Param0, this.endpointUrl)).tag("LyricHighLightFragment").listener(new com.iloen.melon.fragments.detail.e(this, 3)).errorListener(this.mResponseErrorListener).request();
        }
    }

    private static final void onToolBarClick$lambda$8(LyricHighLightFragment lyricHighLightFragment0, Object object0) {
        if(object0 instanceof SongLyricHighlightInsertRes && ((SongLyricHighlightInsertRes)object0).isSuccessful() && q.b(((SongLyricHighlightInsertRes)object0).response.status, "1")) {
            String s = "적용";
            f f0 = lyricHighLightFragment0.getTiaraEventBuilder();
            if(f0 != null) {
                if(lyricHighLightFragment0.getContext() == null) {
                    s = "";
                }
                f0.F = s;
                f0.a().track();
            }
            lyricHighLightFragment0.performBackPress();
            EventBusHelper.post(new EventHighlight());
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initView(view0);
    }

    private final Deferred requestSongLyricHighlightEditAsync(Param songLyricHighlightEditReq$Param0) {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new we.n(songLyricHighlightEditReq$Param0, null) {
            final Param $params;
            int label;

            {
                LyricHighLightFragment.this = lyricHighLightFragment0;
                this.$params = songLyricHighlightEditReq$Param0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.LyricHighLightFragment.requestSongLyricHighlightEditAsync.1(LyricHighLightFragment.this, this.$params, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.LyricHighLightFragment.requestSongLyricHighlightEditAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new SongLyricHighlightEditReq(LyricHighLightFragment.this.getContext(), this.$params, LyricHighLightFragment.this.endpointUrl)).tag("LyricHighLightFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.SongLyricHighlightEditRes");
                return (SongLyricHighlightEditRes)httpResponse0;
            }
        }, 3, null);
    }

    private final void setData(RESPONSE songLyricHighlightEditRes$RESPONSE0) {
        String s = songLyricHighlightEditRes$RESPONSE0.lyric;
        q.f(s, "lyric");
        if(s.length() == 0) {
            return;
        }
        String s1 = songLyricHighlightEditRes$RESPONSE0.lyric;
        q.f(s1, "lyric");
        List list0 = o.R0(s1, new String[]{"\n"}, 0, 6);
        this.lyricList.addAll(list0);
        String s2 = songLyricHighlightEditRes$RESPONSE0.hightlightLine;
        q.f(s2, "hightlightLine");
        List list1 = o.R0(s2, new String[]{","}, 0, 6);
        int v1 = list0.size();
        Boolean[] arr_boolean = new Boolean[v1];
        for(int v = 0; v < v1; ++v) {
            arr_boolean[v] = Boolean.FALSE;
        }
        for(Object object0: list1) {
            String s3 = (String)object0;
            Integer integer0 = v.t0(s3);
            if(integer0 == null) {
                LogU.Companion.d("LyricHighLightFragment", "setData() invalid number format - " + s3);
            }
            else if(((int)integer0) == 0) {
                LogU.Companion.d("LyricHighLightFragment", "setData() number cannot be zero - " + s3);
            }
            else if(((int)integer0) > v1) {
                LogU.Companion.d("LyricHighLightFragment", "setData() number cannot be exceed lyric size - " + s3);
            }
            else {
                arr_boolean[((int)integer0) - 1] = Boolean.TRUE;
            }
        }
        u.V(this.isHighlightLineList, arr_boolean);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

