package com.iloen.melon.fragments.melontv;

import Cb.j;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.exoplayer2.upstream.cache.a;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UserActionsReq.Params;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.request.TvProgramSimpleListReq;
import com.iloen.melon.net.v6x.response.TvProgramSimpleListRes.Response.Program;
import com.iloen.melon.net.v6x.response.TvProgramSimpleListRes;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.f;
import v9.i;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 K2\u00020\u0001:\u0004LMNKB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\n\u0010\bJ-\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010!\u001A\u00020 2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010-\u001A\u00020\u00062\u0006\u0010,\u001A\u00020+H\u0014\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b/\u0010\u0003J\u001F\u00102\u001A\u00020\u00062\u0006\u00100\u001A\u00020\u001E2\u0006\u00101\u001A\u00020 H\u0002\u00A2\u0006\u0004\b2\u00103J\u001F\u00106\u001A\u00020\u00062\u0006\u00105\u001A\u0002042\u0006\u00100\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b6\u00107J\'\u00109\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u00102\u0006\u00105\u001A\u0002042\u0006\u00108\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b9\u0010:R\u0018\u0010;\u001A\u0004\u0018\u00010\u001E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001A\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001A\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u001A\u0010D\u001A\u00060CR\u00020\u00008\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001A\u00020+8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bH\u0010I\u00A8\u0006O"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "outState", "Lie/H;", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "which", "onShowLoginPopup", "(I)V", "setRecyclerViewDecoration", "programSeq", "isEpisode", "finishForResult", "(Ljava/lang/String;Z)V", "Lcom/iloen/melon/custom/AlphaControlCheckButton;", "likeBtn", "getLikeYNFromServer", "(Lcom/iloen/melon/custom/AlphaControlCheckButton;Ljava/lang/String;)V", "progSeq", "updateLikeInfo", "(Landroid/view/View;Lcom/iloen/melon/custom/AlphaControlCheckButton;Ljava/lang/String;)V", "menuSeq", "Ljava/lang/String;", "Landroidx/recyclerview/widget/GridLayoutManager;", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response;", "userActionsRes", "Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response;", "Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$MvItemDecoration;", "mvItemDecoration", "Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$MvItemDecoration;", "liveProgramListSize", "I", "getSpanCount", "()I", "spanCount", "Companion", "MvItemDecoration", "ProgramAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTvProgramSelectFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_MENUSEQ", "ARG_PROGRAM_SEQ_RESULT", "ARG_IS_EPISODE_RESULT", "SPAN_SIZE_2", "", "SPAN_SIZE_3", "VIEW_TYPE_SECTION", "VIEW_TYPE_LIVE", "VIEW_TYPE_END", "SEQ_ORIGINAL", "SEQ_MV", "SEQ_BROADCAST", "SEQ_ARTIST", "newInstance", "Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment;", "menuSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonTvProgramSelectFragment newInstance(@Nullable String s) {
            MelonTvProgramSelectFragment melonTvProgramSelectFragment0 = new MelonTvProgramSelectFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMenuSeq", s);
            melonTvProgramSelectFragment0.setArguments(bundle0);
            return melonTvProgramSelectFragment0;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0011\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$MvItemDecoration;", "Landroidx/recyclerview/widget/r0;", "", "spanCount", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment;I)V", "Lie/H;", "setRowCount", "(I)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "I", "space7", "space16", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MvItemDecoration extends r0 {
        private final int space16;
        private final int space7;
        private int spanCount;

        public MvItemDecoration(int v) {
            this.spanCount = v;
            this.space7 = ScreenUtils.dipToPixel(melonTvProgramSelectFragment0.getContext(), 7.0f);
            this.space16 = ScreenUtils.dipToPixel(melonTvProgramSelectFragment0.getContext(), 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            O0 o00 = recyclerView0.getChildViewHolder(view0);
            int v = recyclerView0.getChildAdapterPosition(view0);
            if(o00 instanceof EndProgViewHolder) {
                int v1 = 0;
                switch(this.spanCount) {
                    case 2: {
                        boolean z = (MelonTvProgramSelectFragment.this.liveProgramListSize % 2 + v) % 2 != 0;
                        rect0.right = z ? this.space16 : 0;
                        if(!z) {
                            v1 = this.space16;
                        }
                        rect0.left = v1;
                        break;
                    }
                    case 3: {
                        int v3 = (MelonTvProgramSelectFragment.this.liveProgramListSize % 3 + 2 + v) % 3;
                        rect0.right = v3 == 2 ? this.space16 : this.space7;
                        rect0.left = v3 == 0 ? this.space16 : this.space7;
                        return;
                    }
                    default: {
                        int v2 = (MelonTvProgramSelectFragment.this.liveProgramListSize % 3 + 2 + v) % 3;
                        rect0.right = v2 == 2 ? this.space16 : this.space7;
                        rect0.left = v2 == 0 ? this.space16 : this.space7;
                    }
                }
            }
        }

        public final void setRowCount(int v) {
            this.spanCount = v;
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0003&\'(B\u0011\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001A\u00020\u000F2\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001A\u00020\u00162\u000E\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010!\u001A\u00020\u00042\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u0019H\u0016¢\u0006\u0004\b!\u0010\"J\'\u0010$\u001A\u00020\u00162\u0006\u0010#\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ProgramAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ServerDataWrapper;", "Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment;Landroid/content/Context;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "Lcom/iloen/melon/net/v6x/response/TvProgramSimpleListRes$Response$Program;", "liveProgList", "endProgList", "Lie/H;", "setResponse", "(Ljava/util/List;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "SectionViewHolder", "LiveProgViewHolder", "EndProgViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ProgramAdapter extends p {
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0017\u0010\u000E\u001A\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001A\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ProgramAdapter$EndProgViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ProgramAdapter;Landroid/view/View;)V", "itemContainer", "Landroid/view/View;", "getItemContainer", "()Landroid/view/View;", "Landroid/widget/ImageView;", "ivDefaultThumb", "Landroid/widget/ImageView;", "Lcom/iloen/melon/custom/BorderImageView;", "ivThumb", "Lcom/iloen/melon/custom/BorderImageView;", "getIvThumb", "()Lcom/iloen/melon/custom/BorderImageView;", "Landroid/widget/TextView;", "progTitle", "Landroid/widget/TextView;", "getProgTitle", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class EndProgViewHolder extends O0 {
            @NotNull
            private final View itemContainer;
            @NotNull
            private final ImageView ivDefaultThumb;
            @NotNull
            private final BorderImageView ivThumb;
            @NotNull
            private final TextView progTitle;

            public EndProgViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                ProgramAdapter.this = melonTvProgramSelectFragment$ProgramAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A05A7);  // id:item_container
                q.f(view1, "findViewById(...)");
                this.itemContainer = view1;
                View view2 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                q.f(view2, "findViewById(...)");
                this.ivDefaultThumb = (ImageView)view2;
                ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(melonTvProgramSelectFragment$ProgramAdapter0.getContext(), 32.0f));
                View view3 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                q.f(view3, "findViewById(...)");
                this.ivThumb = (BorderImageView)view3;
                ((BorderImageView)view3).setBorderWidth(ScreenUtils.dipToPixel(melonTvProgramSelectFragment$ProgramAdapter0.getContext(), 0.5f));
                ((BorderImageView)view3).setBorderColor(ColorUtils.getColor(melonTvProgramSelectFragment$ProgramAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                View view4 = view0.findViewById(0x7F0A097A);  // id:program_title
                q.f(view4, "findViewById(...)");
                this.progTitle = (TextView)view4;
            }

            @NotNull
            public final View getItemContainer() {
                return this.itemContainer;
            }

            @NotNull
            public final BorderImageView getIvThumb() {
                return this.ivThumb;
            }

            @NotNull
            public final TextView getProgTitle() {
                return this.progTitle;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0017\u0010\u000E\u001A\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\f\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001A\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001B\u001A\u00020\u001A8\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u0017\u0010\u001F\u001A\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u0017\u001A\u0004\b \u0010\u0019R\u0017\u0010!\u001A\u00020\u00158\u0006¢\u0006\f\n\u0004\b!\u0010\u0017\u001A\u0004\b\"\u0010\u0019¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ProgramAdapter$LiveProgViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ProgramAdapter;Landroid/view/View;)V", "itemBtnContainer", "Landroid/view/View;", "getItemBtnContainer", "()Landroid/view/View;", "Landroid/widget/ImageView;", "ivDefaultThumb", "Landroid/widget/ImageView;", "Lcom/iloen/melon/custom/BorderImageView;", "ivThumb", "Lcom/iloen/melon/custom/BorderImageView;", "getIvThumb", "()Lcom/iloen/melon/custom/BorderImageView;", "ivNew", "getIvNew", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvHot", "Landroid/widget/TextView;", "getTvHot", "()Landroid/widget/TextView;", "Lcom/iloen/melon/custom/AlphaControlCheckButton;", "likeBtn", "Lcom/iloen/melon/custom/AlphaControlCheckButton;", "getLikeBtn", "()Lcom/iloen/melon/custom/AlphaControlCheckButton;", "progTitle", "getProgTitle", "progDesc", "getProgDesc", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LiveProgViewHolder extends O0 {
            @NotNull
            private final View itemBtnContainer;
            @NotNull
            private final ImageView ivDefaultThumb;
            @NotNull
            private final ImageView ivNew;
            @NotNull
            private final BorderImageView ivThumb;
            @NotNull
            private final AlphaControlCheckButton likeBtn;
            @NotNull
            private final TextView progDesc;
            @NotNull
            private final TextView progTitle;
            @NotNull
            private final TextView tvHot;

            public LiveProgViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                ProgramAdapter.this = melonTvProgramSelectFragment$ProgramAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A05A4);  // id:item_btn_container
                q.f(view1, "findViewById(...)");
                this.itemBtnContainer = view1;
                View view2 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                q.f(view2, "findViewById(...)");
                this.ivDefaultThumb = (ImageView)view2;
                ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(melonTvProgramSelectFragment$ProgramAdapter0.getContext(), 48.0f));
                View view3 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                q.f(view3, "findViewById(...)");
                this.ivThumb = (BorderImageView)view3;
                ((BorderImageView)view3).setBorderWidth(ScreenUtils.dipToPixel(melonTvProgramSelectFragment$ProgramAdapter0.getContext(), 0.5f));
                ((BorderImageView)view3).setBorderColor(ColorUtils.getColor(melonTvProgramSelectFragment$ProgramAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                View view4 = view0.findViewById(0x7F0A08AF);  // id:new_iv
                q.f(view4, "findViewById(...)");
                this.ivNew = (ImageView)view4;
                View view5 = view0.findViewById(0x7F0A063A);  // id:iv_like
                q.f(view5, "findViewById(...)");
                this.likeBtn = (AlphaControlCheckButton)view5;
                View view6 = view0.findViewById(0x7F0A0C8A);  // id:tv_hot
                q.f(view6, "findViewById(...)");
                this.tvHot = (TextView)view6;
                View view7 = view0.findViewById(0x7F0A0CEE);  // id:tv_program_name
                q.f(view7, "findViewById(...)");
                this.progTitle = (TextView)view7;
                View view8 = view0.findViewById(0x7F0A0CED);  // id:tv_program_desc
                q.f(view8, "findViewById(...)");
                this.progDesc = (TextView)view8;
            }

            @NotNull
            public final View getItemBtnContainer() {
                return this.itemBtnContainer;
            }

            @NotNull
            public final ImageView getIvNew() {
                return this.ivNew;
            }

            @NotNull
            public final BorderImageView getIvThumb() {
                return this.ivThumb;
            }

            @NotNull
            public final AlphaControlCheckButton getLikeBtn() {
                return this.likeBtn;
            }

            @NotNull
            public final TextView getProgDesc() {
                return this.progDesc;
            }

            @NotNull
            public final TextView getProgTitle() {
                return this.progTitle;
            }

            @NotNull
            public final TextView getTvHot() {
                return this.tvHot;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ProgramAdapter$SectionViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ProgramAdapter;Landroid/view/View;)V", "Landroid/widget/LinearLayout;", "sectionContainer", "Landroid/widget/LinearLayout;", "getSectionContainer", "()Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "setionTitle", "Landroid/widget/TextView;", "getSetionTitle", "()Landroid/widget/TextView;", "bottomLine", "Landroid/view/View;", "getBottomLine", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SectionViewHolder extends O0 {
            @NotNull
            private final View bottomLine;
            @NotNull
            private final LinearLayout sectionContainer;
            @NotNull
            private final TextView setionTitle;

            public SectionViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                ProgramAdapter.this = melonTvProgramSelectFragment$ProgramAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0A4E);  // id:section_container
                q.f(view1, "findViewById(...)");
                this.sectionContainer = (LinearLayout)view1;
                View view2 = view0.findViewById(0x7F0A0A50);  // id:section_title
                q.f(view2, "findViewById(...)");
                this.setionTitle = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A011F);  // id:bottom_line
                q.f(view3, "findViewById(...)");
                this.bottomLine = view3;
            }

            @NotNull
            public final View getBottomLine() {
                return this.bottomLine;
            }

            @NotNull
            public final LinearLayout getSectionContainer() {
                return this.sectionContainer;
            }

            @NotNull
            public final TextView getSetionTitle() {
                return this.setionTitle;
            }
        }

        public ProgramAdapter(@Nullable Context context0) {
            super(context0, null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
            return melonTvProgramSelectFragment$ServerDataWrapper0 == null ? 0 : melonTvProgramSelectFragment$ServerDataWrapper0.getViewType();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof TvProgramSimpleListRes) {
                this.setResponse(((TvProgramSimpleListRes)httpResponse0).response.progList, ((TvProgramSimpleListRes)httpResponse0).response.endProgList);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00 instanceof SectionViewHolder) {
                ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
                if(melonTvProgramSelectFragment$ServerDataWrapper0 != null) {
                    if(q.b(melonTvProgramSelectFragment$ServerDataWrapper0.getTitle(), MelonTvProgramSelectFragment.this.getString(0x7F13067E))) {  // string:melontv_program_select_end_title "종료된 방송"
                        ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((SectionViewHolder)o00).getSectionContainer().getLayoutParams();
                        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        ((SectionViewHolder)o00).getSectionContainer().setLayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams0));
                        ((SectionViewHolder)o00).getBottomLine().setVisibility(0);
                    }
                    else {
                        ViewGroup.LayoutParams viewGroup$LayoutParams1 = ((SectionViewHolder)o00).getSectionContainer().getLayoutParams();
                        q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        ((LinearLayout.LayoutParams)viewGroup$LayoutParams1).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                        ((SectionViewHolder)o00).getSectionContainer().setLayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams1));
                        ((SectionViewHolder)o00).getBottomLine().setVisibility(4);
                    }
                    ((SectionViewHolder)o00).getSetionTitle().setText(melonTvProgramSelectFragment$ServerDataWrapper0.getTitle());
                }
            }
            else if(o00 instanceof LiveProgViewHolder) {
                ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper1 = (ServerDataWrapper)this.getItem(v1);
                if(melonTvProgramSelectFragment$ServerDataWrapper1 != null) {
                    Program tvProgramSimpleListRes$Response$Program0 = melonTvProgramSelectFragment$ServerDataWrapper1.getLiveProgList();
                    if(tvProgramSimpleListRes$Response$Program0 != null) {
                        MelonTvProgramSelectFragment melonTvProgramSelectFragment0 = MelonTvProgramSelectFragment.this;
                        ViewUtils.setOnClickListener(((LiveProgViewHolder)o00).getItemBtnContainer(), new g(melonTvProgramSelectFragment0, tvProgramSimpleListRes$Response$Program0, 0));
                        Glide.with(this.getContext()).load(tvProgramSimpleListRes$Response$Program0.progThumbImgUrl).apply(RequestOptions.circleCropTransform()).into(((LiveProgViewHolder)o00).getIvThumb());
                        ViewUtils.showWhen(((LiveProgViewHolder)o00).getIvNew(), ProtocolUtils.parseBoolean(tvProgramSimpleListRes$Response$Program0.newYn));
                        ViewUtils.showWhen(((LiveProgViewHolder)o00).getTvHot(), ProtocolUtils.parseBoolean(tvProgramSimpleListRes$Response$Program0.hotYn));
                        ((LiveProgViewHolder)o00).getProgTitle().setText(tvProgramSimpleListRes$Response$Program0.progName);
                        ((LiveProgViewHolder)o00).getProgDesc().setText(tvProgramSimpleListRes$Response$Program0.progsImplDes);
                        if(!TextUtils.isEmpty(tvProgramSimpleListRes$Response$Program0.progSeq)) {
                            AlphaControlCheckButton alphaControlCheckButton0 = ((LiveProgViewHolder)o00).getLikeBtn();
                            String s = tvProgramSimpleListRes$Response$Program0.progSeq;
                            q.f(s, "progSeq");
                            melonTvProgramSelectFragment0.getLikeYNFromServer(alphaControlCheckButton0, s);
                        }
                        ViewUtils.setOnClickListener(((LiveProgViewHolder)o00).getLikeBtn(), new h(melonTvProgramSelectFragment0, o00, tvProgramSimpleListRes$Response$Program0, 0));
                    }
                }
            }
            else if(o00 instanceof EndProgViewHolder) {
                ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper2 = (ServerDataWrapper)this.getItem(v1);
                if(melonTvProgramSelectFragment$ServerDataWrapper2 != null) {
                    Program tvProgramSimpleListRes$Response$Program1 = melonTvProgramSelectFragment$ServerDataWrapper2.getEndProgList();
                    if(tvProgramSimpleListRes$Response$Program1 != null) {
                        Glide.with(this.getContext()).load(tvProgramSimpleListRes$Response$Program1.progThumbImgUrl).apply(RequestOptions.circleCropTransform()).into(((EndProgViewHolder)o00).getIvThumb());
                        ViewUtils.setText(((EndProgViewHolder)o00).getProgTitle(), tvProgramSimpleListRes$Response$Program1.progName);
                        ViewUtils.setOnClickListener(((EndProgViewHolder)o00).getItemContainer(), new g(MelonTvProgramSelectFragment.this, tvProgramSimpleListRes$Response$Program1, 1));
                    }
                }
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$0(MelonTvProgramSelectFragment melonTvProgramSelectFragment0, Program tvProgramSimpleListRes$Response$Program0, View view0) {
            String s = tvProgramSimpleListRes$Response$Program0.progSeq;
            q.f(s, "progSeq");
            melonTvProgramSelectFragment0.finishForResult(s, ProtocolUtils.parseBoolean(tvProgramSimpleListRes$Response$Program0.espdYn));
        }

        private static final void onBindViewImpl$lambda$2$lambda$1(MelonTvProgramSelectFragment melonTvProgramSelectFragment0, O0 o00, Program tvProgramSimpleListRes$Response$Program0, View view0) {
            if(!melonTvProgramSelectFragment0.isLoginUser()) {
                melonTvProgramSelectFragment0.showLoginPopup();
                return;
            }
            if(!((LiveProgViewHolder)o00).getLikeBtn().i) {
                q.d(view0);
                AlphaControlCheckButton alphaControlCheckButton0 = ((LiveProgViewHolder)o00).getLikeBtn();
                String s = tvProgramSimpleListRes$Response$Program0.progSeq;
                q.f(s, "progSeq");
                melonTvProgramSelectFragment0.updateLikeInfo(view0, alphaControlCheckButton0, s);
                return;
            }
            ToastManager.show(0x7F13067F);  // string:melontv_program_select_like_cancel_msg "좋아요 해제는 프로그램 상세 페이지에서 가능합니다."
        }

        private static final void onBindViewImpl$lambda$4$lambda$3(MelonTvProgramSelectFragment melonTvProgramSelectFragment0, Program tvProgramSimpleListRes$Response$Program0, View view0) {
            String s = tvProgramSimpleListRes$Response$Program0.progSeq;
            q.f(s, "progSeq");
            melonTvProgramSelectFragment0.finishForResult(s, ProtocolUtils.parseBoolean(tvProgramSimpleListRes$Response$Program0.espdYn));
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            switch(v) {
                case 10: {
                    View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04FA, viewGroup0, false);  // layout:melontv_program_select_item
                    q.f(view1, "inflate(...)");
                    return new SectionViewHolder(this, view1);
                }
                case 11: {
                    View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04F7, viewGroup0, false);  // layout:melontv_program_live_prog_item
                    q.f(view2, "inflate(...)");
                    return new LiveProgViewHolder(this, view2);
                }
                case 12: {
                    View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04EB, viewGroup0, false);  // layout:melontv_end_program_item
                    q.f(view3, "inflate(...)");
                    return new EndProgViewHolder(this, view3);
                }
                default: {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04FA, viewGroup0, false);  // layout:melontv_program_select_item
                    q.f(view0, "inflate(...)");
                    return new SectionViewHolder(this, view0);
                }
            }
        }

        public final void setResponse(@Nullable List list0, @Nullable List list1) {
            if(list0 != null && !list0.isEmpty()) {
                ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper0 = new ServerDataWrapper(MelonTvProgramSelectFragment.this);
                melonTvProgramSelectFragment$ServerDataWrapper0.setTitle(MelonTvProgramSelectFragment.this.getString(0x7F130680));  // string:melontv_program_select_live_title "진행중인 방송"
                melonTvProgramSelectFragment$ServerDataWrapper0.setViewType(10);
                this.add(melonTvProgramSelectFragment$ServerDataWrapper0);
                int v1 = list0.size();
                for(int v2 = 0; v2 < v1; ++v2) {
                    ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper1 = new ServerDataWrapper(MelonTvProgramSelectFragment.this);
                    melonTvProgramSelectFragment$ServerDataWrapper1.setLiveProgList(((Program)list0.get(v2)));
                    melonTvProgramSelectFragment$ServerDataWrapper1.setViewType(11);
                    this.add(melonTvProgramSelectFragment$ServerDataWrapper1);
                }
            }
            if(list1 != null && !list1.isEmpty()) {
                ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper2 = new ServerDataWrapper(MelonTvProgramSelectFragment.this);
                melonTvProgramSelectFragment$ServerDataWrapper2.setTitle(MelonTvProgramSelectFragment.this.getString(0x7F13067E));  // string:melontv_program_select_end_title "종료된 방송"
                melonTvProgramSelectFragment$ServerDataWrapper2.setViewType(10);
                this.add(melonTvProgramSelectFragment$ServerDataWrapper2);
                int v3 = list1.size();
                for(int v = 0; v < v3; ++v) {
                    ServerDataWrapper melonTvProgramSelectFragment$ServerDataWrapper3 = new ServerDataWrapper(MelonTvProgramSelectFragment.this);
                    melonTvProgramSelectFragment$ServerDataWrapper3.setEndProgList(((Program)list1.get(v)));
                    melonTvProgramSelectFragment$ServerDataWrapper3.setViewType(12);
                    this.add(melonTvProgramSelectFragment$ServerDataWrapper3);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment$ServerDataWrapper;", "", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvProgramSelectFragment;)V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "liveProgList", "Lcom/iloen/melon/net/v6x/response/TvProgramSimpleListRes$Response$Program;", "getLiveProgList", "()Lcom/iloen/melon/net/v6x/response/TvProgramSimpleListRes$Response$Program;", "setLiveProgList", "(Lcom/iloen/melon/net/v6x/response/TvProgramSimpleListRes$Response$Program;)V", "endProgList", "getEndProgList", "setEndProgList", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ServerDataWrapper {
        @Nullable
        private Program endProgList;
        @Nullable
        private Program liveProgList;
        @Nullable
        private String title;
        private int viewType;

        @Nullable
        public final Program getEndProgList() {
            return this.endProgList;
        }

        @Nullable
        public final Program getLiveProgList() {
            return this.liveProgList;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public final int getViewType() {
            return this.viewType;
        }

        public final void setEndProgList(@Nullable Program tvProgramSimpleListRes$Response$Program0) {
            this.endProgList = tvProgramSimpleListRes$Response$Program0;
        }

        public final void setLiveProgList(@Nullable Program tvProgramSimpleListRes$Response$Program0) {
            this.liveProgList = tvProgramSimpleListRes$Response$Program0;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        public final void setViewType(int v) {
            this.viewType = v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_IS_EPISODE_RESULT = "argIsEpisodeResult";
    @NotNull
    public static final String ARG_MENUSEQ = "argMenuSeq";
    @NotNull
    public static final String ARG_PROGRAM_SEQ_RESULT = "argProgramSeqResult";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String SEQ_ARTIST = "4";
    @NotNull
    public static final String SEQ_BROADCAST = "3";
    @NotNull
    public static final String SEQ_MV = "2";
    @NotNull
    public static final String SEQ_ORIGINAL = "1";
    private static final int SPAN_SIZE_2 = 2;
    private static final int SPAN_SIZE_3 = 3;
    @NotNull
    private static final String TAG = "MelonTvProgramSelectFragment";
    public static final int VIEW_TYPE_END = 12;
    public static final int VIEW_TYPE_LIVE = 11;
    public static final int VIEW_TYPE_SECTION = 10;
    @Nullable
    private GridLayoutManager gridLayoutManager;
    private int liveProgramListSize;
    @Nullable
    private String menuSeq;
    private MvItemDecoration mvItemDecoration;
    @Nullable
    private Response userActionsRes;

    static {
        MelonTvProgramSelectFragment.Companion = new Companion(null);
        MelonTvProgramSelectFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new ProgramAdapter(this, context0);
    }

    public static void e0(VolleyError volleyError0) {
        MelonTvProgramSelectFragment.getLikeYNFromServer$lambda$1(volleyError0);
    }

    private final void finishForResult(String s, boolean z) {
        if(TextUtils.isEmpty(s)) {
            return;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            this.performBackPress();
            return;
        }
        Intent intent0 = new Intent();
        intent0.putExtra("argProgramSeqResult", s);
        intent0.putExtra("argIsEpisodeResult", z);
        if(fragmentActivity0.getParent() == null) {
            fragmentActivity0.setResult(-1, intent0);
        }
        else {
            fragmentActivity0.getParent().setResult(-1, intent0);
        }
        fragmentActivity0.getOnBackPressedDispatcher().c();
    }

    private final void getLikeYNFromServer(AlphaControlCheckButton alphaControlCheckButton0, String s) {
        if(!this.isLoginUser() || TextUtils.isEmpty(s)) {
            return;
        }
        Params userActionsReq$Params0 = new Params();
        userActionsReq$Params0.fields = "like";
        userActionsReq$Params0.contsTypeCode = "N10044";
        userActionsReq$Params0.contsId = s;
        RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag("MelonTvProgramSelectFragment").listener(new Listener() {
            public void onResponse(UserActionsRes userActionsRes0) {
                if(userActionsRes0 != null && alphaControlCheckButton0.isFragmentValid()) {
                    j.b(userActionsRes0.notification, false, 3);
                    if(j.d(userActionsRes0)) {
                        alphaControlCheckButton0.userActionsRes = userActionsRes0.response;
                        Response userActionsRes$Response0 = alphaControlCheckButton0.userActionsRes;
                        if(userActionsRes$Response0 != null) {
                            this.$likeBtn.setChecked(MelonDetailInfoUtils.getUserActionLikeInfo(userActionsRes$Response0.relationList));
                            String s = alphaControlCheckButton0.getString((this.$likeBtn.i ? 0x7F130B62 : 0x7F130B63));  // string:talkback_like_turn_off "좋아요, 취소하기"
                            q.d(s);
                            ViewUtils.setContentDescriptionWithButtonClassName(this.$likeBtn, s);
                        }
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((UserActionsRes)object0));
            }
        }).errorListener(new a(24)).request();
    }

    private static final void getLikeYNFromServer$lambda$1(VolleyError volleyError0) {
        LogU.Companion.w("MelonTvProgramSelectFragment", volleyError0.toString());
    }

    // 去混淆评级： 低(20)
    private final int getSpanCount() {
        return ScreenUtils.isPortrait(this.getContext()) ? 2 : 3;
    }

    @NotNull
    public static final MelonTvProgramSelectFragment newInstance(@Nullable String s) {
        return MelonTvProgramSelectFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        boolean z = configuration0.orientation == 1;
        GridLayoutManager gridLayoutManager0 = this.gridLayoutManager;
        if(gridLayoutManager0 != null) {
            gridLayoutManager0.P(this.getSpanCount());
        }
        MvItemDecoration melonTvProgramSelectFragment$MvItemDecoration0 = this.mvItemDecoration;
        if(melonTvProgramSelectFragment$MvItemDecoration0 != null) {
            melonTvProgramSelectFragment$MvItemDecoration0.setRowCount((z ? 2 : 3));
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(false);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D04F9, viewGroup0, false);  // layout:melontv_program_select
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melontv.MelonTvProgramSelectFragment.ProgramAdapter");
        if(i.b.equals(i0)) {
            ((ProgramAdapter)j00).clear();
        }
        RequestBuilder.newInstance(new TvProgramSimpleListReq(this.getContext(), this.menuSeq)).tag(this.getRequestTag()).listener(new Listener() {
            public void onResponse(TvProgramSimpleListRes tvProgramSimpleListRes0) {
                int v;
                if(!i0.prepareFetchComplete(tvProgramSimpleListRes0)) {
                    return;
                }
                i0.performFetchComplete(this.$type, tvProgramSimpleListRes0);
                MelonTvProgramSelectFragment melonTvProgramSelectFragment0 = i0;
                if(tvProgramSimpleListRes0 == null) {
                    v = 0;
                }
                else {
                    com.iloen.melon.net.v6x.response.TvProgramSimpleListRes.Response tvProgramSimpleListRes$Response0 = tvProgramSimpleListRes0.response;
                    if(tvProgramSimpleListRes$Response0 == null) {
                        v = 0;
                    }
                    else {
                        List list0 = tvProgramSimpleListRes$Response0.progList;
                        v = list0 == null ? 0 : list0.size();
                    }
                }
                melonTvProgramSelectFragment0.liveProgramListSize = v;
                i0.setRecyclerViewDecoration();
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((TvProgramSimpleListRes)object0));
            }
        }).errorListener(new d(this, 3)).request();
        return true;
    }

    private static final void onFetchStart$lambda$0(MelonTvProgramSelectFragment melonTvProgramSelectFragment0, VolleyError volleyError0) {
        melonTvProgramSelectFragment0.mResponseErrorListener.onErrorResponse(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.menuSeq = bundle0.getString("argMenuSeq");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMenuSeq", this.menuSeq);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onShowLoginPopup(int v) {
        if(v == -1) {
            this.startActivity(new Intent("android.intent.action.VIEW", f.j));
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F130681));  // string:melontv_program_shortcut "프로그램 바로가기"
            titleBar0.f(true);
        }
    }

    private final void setRecyclerViewDecoration() {
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), this.getSpanCount());
        this.gridLayoutManager = gridLayoutManager0;
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                j0 j00 = MelonTvProgramSelectFragment.this.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melontv.MelonTvProgramSelectFragment.ProgramAdapter");
                switch(((ProgramAdapter)j00).getItemViewType(v)) {
                    case 10: 
                    case 11: {
                        return MelonTvProgramSelectFragment.this.getSpanCount();
                    }
                    default: {
                        return 1;
                    }
                }
            }
        };
        this.getRecyclerView().setLayoutManager(this.gridLayoutManager);
        this.mvItemDecoration = new MvItemDecoration(this, this.getSpanCount());
        RecyclerView recyclerView0 = this.getRecyclerView();
        MvItemDecoration melonTvProgramSelectFragment$MvItemDecoration0 = this.mvItemDecoration;
        if(melonTvProgramSelectFragment$MvItemDecoration0 != null) {
            recyclerView0.addItemDecoration(melonTvProgramSelectFragment$MvItemDecoration0);
            return;
        }
        q.m("mvItemDecoration");
        throw null;
    }

    private final void updateLikeInfo(View view0, AlphaControlCheckButton alphaControlCheckButton0, String s) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        if(this.userActionsRes == null) {
            return;
        }
        this.updateLike(s, "N10044", true, this.menuSeq, new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                int v1;
                MelonTvProgramSelectFragment melonTvProgramSelectFragment0;
                q.g(s, "errorMsg");
                if(alphaControlCheckButton0.isFragmentValid()) {
                    this.setEnabled(true);
                    this.setClickable(true);
                    if(alphaControlCheckButton0.userActionsRes != null && TextUtils.isEmpty(s)) {
                        Response userActionsRes$Response0 = alphaControlCheckButton0.userActionsRes;
                        MelonDetailInfoUtils.INSTANCE.setUserActionLikeInfo((userActionsRes$Response0 == null ? null : userActionsRes$Response0.relationList), z);
                        this.$likeBtn.setChecked(z);
                        com.iloen.melon.responsecache.a.c(alphaControlCheckButton0.getContext(), "", true);
                        if(this.$likeBtn.i) {
                            melonTvProgramSelectFragment0 = alphaControlCheckButton0;
                            v1 = 0x7F130B62;  // string:talkback_like_turn_off "좋아요, 취소하기"
                        }
                        else {
                            melonTvProgramSelectFragment0 = alphaControlCheckButton0;
                            v1 = 0x7F130B63;  // string:talkback_like_turn_on "좋아요, 선택하기"
                        }
                        String s1 = melonTvProgramSelectFragment0.getString(v1);
                        q.d(s1);
                        ViewUtils.setContentDescriptionWithButtonClassName(this.$likeBtn, s1);
                    }
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
                this.setEnabled(false);
                this.setClickable(false);
            }
        });
    }
}

