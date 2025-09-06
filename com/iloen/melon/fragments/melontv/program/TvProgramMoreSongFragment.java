package com.iloen.melon.fragments.melontv.program;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.I;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.request.ProgramMoreSongReq.Params;
import com.iloen.melon.net.v6x.request.ProgramMoreSongReq;
import com.iloen.melon.net.v6x.response.ProgramMoreSongRes.Response.EpsdList;
import com.iloen.melon.net.v6x.response.ProgramMoreSongRes.Response.YearList;
import com.iloen.melon.net.v6x.response.ProgramMoreSongRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.j;

@Metadata(d1 = {"\u0000\u00B2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 {2\u00020\u0001:\u0003|}{B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0013J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001B\u0010\u001C\u001A\u0006\u0012\u0002\b\u00030\u001B2\u0006\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J-\u0010\'\u001A\u00020&2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010$\u001A\u0004\u0018\u00010#2\b\u0010%\u001A\u0004\u0018\u00010\u0016H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u0011\u0010*\u001A\u0004\u0018\u00010)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u001F\u0010.\u001A\u00020\u000E2\u0006\u0010,\u001A\u00020\u00162\u0006\u0010-\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b.\u0010/J\u0017\u00101\u001A\u00020\u000E2\u0006\u00100\u001A\u00020&H\u0002\u00A2\u0006\u0004\b1\u00102J\u001B\u00103\u001A\u00020\u000E2\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010!H\u0002\u00A2\u0006\u0004\b3\u00104J)\u0010:\u001A\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9*\b\u0012\u0004\u0012\u00020605H\u0002\u00A2\u0006\u0004\b:\u0010;J)\u0010=\u001A\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9*\b\u0012\u0004\u0012\u00020<05H\u0002\u00A2\u0006\u0004\b=\u0010;R\"\u0010>\u001A\u00020\u00168\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010?\u001A\u0004\b@\u0010\u0018\"\u0004\bA\u0010BR2\u0010C\u001A\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`98\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bC\u0010D\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001A\u00020I8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001A\u00020\n8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bP\u0010Q\u001A\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001A\u00020V8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bW\u0010X\u001A\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001A\u00020V8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b]\u0010X\u001A\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\"\u0010`\u001A\u00020\n8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b`\u0010Q\u001A\u0004\ba\u0010S\"\u0004\bb\u0010UR\"\u0010c\u001A\u00020\n8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bc\u0010Q\u001A\u0004\bd\u0010S\"\u0004\be\u0010UR\"\u0010g\u001A\u00020f8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bg\u0010h\u001A\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010m\u001A\u00020\u00168\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bm\u0010?\u001A\u0004\bn\u0010\u0018\"\u0004\bo\u0010BR\"\u0010q\u001A\u00020p8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bq\u0010r\u001A\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0014\u0010z\u001A\u00020w8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bx\u0010y\u00A8\u0006~"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreSongFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "actionName", "copy", "buildPlayBtnTiaraLog", "(Ljava/lang/String;Ljava/lang/String;)V", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "request", "(Lv9/i;)V", "", "Lcom/iloen/melon/net/v6x/response/ProgramMoreSongRes$Response$YearList;", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "convertFilterList", "(Ljava/util/List;)Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ProgramMoreSongRes$Response$EpsdList;", "convertFilterItemList", "progSeq", "Ljava/lang/String;", "getProgSeq", "setProgSeq", "(Ljava/lang/String;)V", "epsdList", "Ljava/util/ArrayList;", "getEpsdList", "()Ljava/util/ArrayList;", "setEpsdList", "(Ljava/util/ArrayList;)V", "Lcom/iloen/melon/custom/FilterLayout;", "filterLayout", "Lcom/iloen/melon/custom/FilterLayout;", "getFilterLayout", "()Lcom/iloen/melon/custom/FilterLayout;", "setFilterLayout", "(Lcom/iloen/melon/custom/FilterLayout;)V", "filterContainer", "Landroid/view/View;", "getFilterContainer", "()Landroid/view/View;", "setFilterContainer", "(Landroid/view/View;)V", "", "filterYearPosition", "I", "getFilterYearPosition", "()I", "setFilterYearPosition", "(I)V", "filterRoundPosition", "getFilterRoundPosition", "setFilterRoundPosition", "playShuffleButton", "getPlayShuffleButton", "setPlayShuffleButton", "playAllButton", "getPlayAllButton", "setPlayAllButton", "Landroid/widget/TextView;", "orderButton", "Landroid/widget/TextView;", "getOrderButton", "()Landroid/widget/TextView;", "setOrderButton", "(Landroid/widget/TextView;)V", "progName", "getProgName", "setProgName", "Lp8/s;", "tiaraBase", "Lp8/s;", "getTiaraBase", "()Lp8/s;", "setTiaraBase", "(Lp8/s;)V", "Lp8/f;", "getTiaraBuilder", "()Lp8/f;", "tiaraBuilder", "Companion", "TvProgramRelativeSongAdapter", "RelativeSongViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TvProgramMoreSongFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PROGSEQ", "ARG_PROGNAME", "newInstance", "Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreSongFragment;", "progSeq", "progName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TvProgramMoreSongFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "progSeq");
            q.g(s1, "progName");
            TvProgramMoreSongFragment tvProgramMoreSongFragment0 = new TvProgramMoreSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argProcSeq", s);
            bundle0.putString("argProgName", s1);
            tvProgramMoreSongFragment0.setArguments(bundle0);
            return tvProgramMoreSongFragment0;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0011\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010R\u001F\u0010\u0013\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001A\u0004\b\u0014\u0010\u000BR\u001F\u0010\u0015\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u001F\u0010\u0019\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001A\u0004\b\u001A\u0010\u0018¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreSongFragment$RelativeSongViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreSongFragment;Landroid/view/View;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "albumImg", "Landroid/widget/ImageView;", "getAlbumImg", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "songTitle", "Landroid/widget/TextView;", "getSongTitle", "()Landroid/widget/TextView;", "artist", "getArtist", "grade19", "getGrade19", "btnPlay", "Landroid/view/View;", "getBtnPlay", "()Landroid/view/View;", "btnInfo", "getBtnInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class RelativeSongViewHolder extends O0 {
        private final ImageView albumImg;
        private final TextView artist;
        private final View btnInfo;
        private final View btnPlay;
        private final ImageView grade19;
        private final TextView songTitle;

        public RelativeSongViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            TvProgramMoreSongFragment.this = tvProgramMoreSongFragment0;
            super(view0);
            this.albumImg = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.songTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.artist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
            this.grade19 = (ImageView)view0.findViewById(0x7F0A063B);  // id:iv_list_19
            this.btnPlay = view0.findViewById(0x7F0A0182);  // id:btn_play
            this.btnInfo = view0.findViewById(0x7F0A0169);  // id:btn_info
        }

        public final ImageView getAlbumImg() {
            return this.albumImg;
        }

        public final TextView getArtist() {
            return this.artist;
        }

        public final View getBtnInfo() {
            return this.btnInfo;
        }

        public final View getBtnPlay() {
            return this.btnPlay;
        }

        public final ImageView getGrade19() {
            return this.grade19;
        }

        public final TextView getSongTitle() {
            return this.songTitle;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00020\u00032\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u000B8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreSongFragment$TvProgramRelativeSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "Lcom/melon/net/res/common/SongInfoBase;", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreSongFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "viewTypeSong", "I", "getViewTypeSong", "()I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TvProgramRelativeSongAdapter extends p {
        private final int viewTypeSong;

        public TvProgramRelativeSongAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            TvProgramMoreSongFragment.this = tvProgramMoreSongFragment0;
            super(context0, list0);
            this.viewTypeSong = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.viewTypeSong;
        }

        public final int getViewTypeSong() {
            return this.viewTypeSong;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof RelativeSongViewHolder) {
                if(this.isMarked(v1)) {
                    int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                    ((RelativeSongViewHolder)o00).itemView.setBackgroundColor(v2);
                }
                else {
                    int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    ((RelativeSongViewHolder)o00).itemView.setBackgroundColor(v3);
                }
                Object object0 = this.getItem(v1);
                SongInfoBase songInfoBase0 = object0 instanceof SongInfoBase ? ((SongInfoBase)object0) : null;
                if(songInfoBase0 != null) {
                    Glide.with(this.getContext()).load(songInfoBase0.getAlbumImgSmall()).into(((RelativeSongViewHolder)o00).getAlbumImg());
                    ((RelativeSongViewHolder)o00).getSongTitle().setText(songInfoBase0.songName);
                    ((RelativeSongViewHolder)o00).getArtist().setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(this.getContext(), songInfoBase0.artistList, 0x7FFFFFFF));
                    ((RelativeSongViewHolder)o00).getGrade19().setVisibility((songInfoBase0.isAdult ? 0 : 8));
                    h h0 = new h(TvProgramMoreSongFragment.this, v, this, v1, songInfoBase0, 1);
                    ((RelativeSongViewHolder)o00).itemView.setOnClickListener(h0);
                    com.iloen.melon.fragments.melontv.program.q q0 = new com.iloen.melon.fragments.melontv.program.q(TvProgramMoreSongFragment.this, songInfoBase0, this);
                    ((RelativeSongViewHolder)o00).itemView.setOnLongClickListener(q0);
                    ViewUtils.showWhen(((RelativeSongViewHolder)o00).getBtnPlay(), songInfoBase0.canService);
                    ((RelativeSongViewHolder)o00).getBtnPlay().setOnClickListener(new r(TvProgramMoreSongFragment.this, songInfoBase0, this, v1, 0));
                    Playable playable0 = Playable.from(songInfoBase0, this.getMenuId(), null);
                    ((RelativeSongViewHolder)o00).getBtnInfo().setOnClickListener(new i(TvProgramMoreSongFragment.this, playable0, this, v1, songInfoBase0, 1));
                    ((RelativeSongViewHolder)o00).getAlbumImg().setOnClickListener(new r(TvProgramMoreSongFragment.this, songInfoBase0, this, v1, 1));
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(TvProgramMoreSongFragment tvProgramMoreSongFragment0, int v, TvProgramRelativeSongAdapter tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0, int v1, SongInfoBase songInfoBase0, View view0) {
            tvProgramMoreSongFragment0.onItemClick(tvProgramMoreSongFragment0.getView(), v);
            f f0 = tvProgramMoreSongFragment0.getTiaraBuilder();
            String s = null;
            f0.a = tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() == null ? null : "선택";
            f0.d = ActionKind.ClickContent;
            if(tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() != null) {
                s = "리스트";
            }
            f0.y = s;
            f0.C = String.valueOf(v1 + 1);
            f0.e = songInfoBase0.songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = songInfoBase0.songName;
            f0.a().track();
        }

        private static final boolean onBindViewImpl$lambda$1(TvProgramMoreSongFragment tvProgramMoreSongFragment0, SongInfoBase songInfoBase0, TvProgramRelativeSongAdapter tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0, View view0) {
            tvProgramMoreSongFragment0.showContextPopupSongOrInstantPlay(Playable.from(songInfoBase0, tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getMenuId(), null));
            return true;
        }

        private static final void onBindViewImpl$lambda$2(TvProgramMoreSongFragment tvProgramMoreSongFragment0, SongInfoBase songInfoBase0, TvProgramRelativeSongAdapter tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0, int v, View view0) {
            tvProgramMoreSongFragment0.playSong(songInfoBase0.songId, tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getMenuId());
            f f0 = tvProgramMoreSongFragment0.getTiaraBuilder();
            String s = null;
            f0.a = tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() == null ? null : "음악재생";
            f0.d = ActionKind.PlayMusic;
            if(tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() != null) {
                s = "리스트";
            }
            f0.y = s;
            f0.C = String.valueOf(v + 1);
            f0.e = songInfoBase0.songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = songInfoBase0.songName;
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$3(TvProgramMoreSongFragment tvProgramMoreSongFragment0, Playable playable0, TvProgramRelativeSongAdapter tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0, int v, SongInfoBase songInfoBase0, View view0) {
            tvProgramMoreSongFragment0.showContextPopupSong(playable0);
            f f0 = tvProgramMoreSongFragment0.getTiaraBuilder();
            String s = null;
            f0.a = tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() == null ? null : "페이지이동";
            f0.d = ActionKind.ClickContent;
            if(tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() != null) {
                s = "리스트";
            }
            f0.y = s;
            f0.C = String.valueOf(v + 1);
            f0.e = songInfoBase0.songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = songInfoBase0.songName;
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$4(TvProgramMoreSongFragment tvProgramMoreSongFragment0, SongInfoBase songInfoBase0, TvProgramRelativeSongAdapter tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0, int v, View view0) {
            tvProgramMoreSongFragment0.showAlbumInfoPage(songInfoBase0);
            f f0 = tvProgramMoreSongFragment0.getTiaraBuilder();
            String s = null;
            f0.a = tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() == null ? null : "페이지이동";
            f0.d = ActionKind.ClickContent;
            if(tvProgramMoreSongFragment$TvProgramRelativeSongAdapter0.getContext() != null) {
                s = "리스트";
            }
            f0.y = s;
            f0.C = String.valueOf(v + 1);
            f0.e = songInfoBase0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = songInfoBase0.albumName;
            f0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            View view0 = View.inflate(this.getContext(), 0x7F0D04AE, null);  // layout:listitem_song_new
            q.f(view0, "inflate(...)");
            return new RelativeSongViewHolder(TvProgramMoreSongFragment.this, view0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_PROGNAME = "argProgName";
    @NotNull
    public static final String ARG_PROGSEQ = "argProcSeq";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "TvProgramMoreSongFragment";
    @NotNull
    private ArrayList epsdList;
    public View filterContainer;
    public FilterLayout filterLayout;
    private int filterRoundPosition;
    private int filterYearPosition;
    public TextView orderButton;
    public View playAllButton;
    public View playShuffleButton;
    @NotNull
    private String progName;
    @NotNull
    private String progSeq;
    public s tiaraBase;

    static {
        TvProgramMoreSongFragment.Companion = new Companion(null);
        TvProgramMoreSongFragment.$stable = 8;
    }

    public TvProgramMoreSongFragment() {
        this.progSeq = "";
        this.epsdList = new ArrayList();
        this.progName = "";
    }

    private final void buildPlayBtnTiaraLog(String s, String s1) {
        if(this.tiaraBase != null) {
            f f0 = this.getTiaraBuilder();
            f0.a = s;
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getContext() == null ? null : "리스트";
            f0.F = s1;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 1000);  // id:toolbar_layout
    }

    private final ArrayList convertFilterItemList(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.a = ((EpsdList)object0).epsdName;
            j0.b = ((EpsdList)object0).epsdName;
            j0.c = ((EpsdList)object0).cnpckSeq;
            arrayList0.add(j0);
        }
        return arrayList0;
    }

    private final ArrayList convertFilterList(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.a = ((YearList)object0).year;
            j0.b = ((YearList)object0).year;
            List list1 = ((YearList)object0).epsdList;
            q.f(list1, "epsdList");
            j0.e = this.convertFilterItemList(list1);
            arrayList0.add(j0);
        }
        return arrayList0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new TvProgramRelativeSongAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setMarkedMode(true);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(1);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.V0.buildUpon().appendPath("moresong"), this.progSeq, "toString(...)");
    }

    @NotNull
    public final ArrayList getEpsdList() {
        return this.epsdList;
    }

    @NotNull
    public final View getFilterContainer() {
        View view0 = this.filterContainer;
        if(view0 != null) {
            return view0;
        }
        q.m("filterContainer");
        throw null;
    }

    @NotNull
    public final FilterLayout getFilterLayout() {
        FilterLayout filterLayout0 = this.filterLayout;
        if(filterLayout0 != null) {
            return filterLayout0;
        }
        q.m("filterLayout");
        throw null;
    }

    public final int getFilterRoundPosition() {
        return this.filterRoundPosition;
    }

    public final int getFilterYearPosition() {
        return this.filterYearPosition;
    }

    @NotNull
    public final TextView getOrderButton() {
        TextView textView0 = this.orderButton;
        if(textView0 != null) {
            return textView0;
        }
        q.m("orderButton");
        throw null;
    }

    @NotNull
    public final View getPlayAllButton() {
        View view0 = this.playAllButton;
        if(view0 != null) {
            return view0;
        }
        q.m("playAllButton");
        throw null;
    }

    @NotNull
    public final View getPlayShuffleButton() {
        View view0 = this.playShuffleButton;
        if(view0 != null) {
            return view0;
        }
        q.m("playShuffleButton");
        throw null;
    }

    @NotNull
    public final String getProgName() {
        return this.progName;
    }

    @NotNull
    public final String getProgSeq() {
        return this.progSeq;
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
        f0.o = this.progSeq;
        f0.q = this.progName;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D3);  // id:recyclerview
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setItemAnimator(null);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D08CE, viewGroup0, false);  // layout:tvprogram_related_song_layout
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        this.request(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argProcSeq");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.progSeq = s;
        String s2 = bundle0.getString("argProgName");
        if(s2 != null) {
            s1 = s2;
        }
        this.progName = s1;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argProcSeq", this.progSeq);
        bundle0.putString("argProgName", this.progName);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        CharSequence charSequence0 = null;
        if(this.getTitleBar() != null) {
            this.getTitleBar().a(a.s(7));
            this.getTitleBar().setBackgroundColor(0);
            TitleBar titleBar0 = this.getTitleBar();
            Context context0 = this.getContext();
            titleBar0.setTitle((context0 == null || context0.getResources() == null ? null : "연관 곡"));
        }
        View view1 = view0.findViewById(0x7F0A01BB);  // id:btn_shuffle
        q.f(view1, "findViewById(...)");
        this.setPlayShuffleButton(view1);
        View view2 = view0.findViewById(0x7F0A0183);  // id:btn_play_all
        q.f(view2, "findViewById(...)");
        this.setPlayAllButton(view2);
        View view3 = view0.findViewById(0x7F0A049E);  // id:filter_layout
        q.f(view3, "findViewById(...)");
        this.setFilterLayout(((FilterLayout)view3));
        View view4 = view0.findViewById(0x7F0A049B);  // id:filter_container
        q.f(view4, "findViewById(...)");
        this.setFilterContainer(view4);
        View view5 = view0.findViewById(0x7F0A0499);  // id:filter_btn
        q.f(view5, "findViewById(...)");
        this.setOrderButton(((TextView)view5));
        if(this.epsdList.isEmpty()) {
            TextView textView0 = this.getOrderButton();
            Context context1 = this.getContext();
            if(context1 != null && context1.getResources() != null) {
                charSequence0 = "전곡";
            }
            textView0.setText(charSequence0);
        }
        else {
            this.getOrderButton().setText(((j)((j)this.epsdList.get(this.filterYearPosition)).e.get(this.filterRoundPosition)).a);
            this.setAllCheckButtonVisibility(true);
        }
        this.getOrderButton().setOnClickListener(new com.iloen.melon.fragments.melontv.program.p(this, 0));
        this.getPlayAllButton().setOnClickListener(new com.iloen.melon.fragments.melontv.program.p(this, 1));
        this.getPlayShuffleButton().setOnClickListener(new com.iloen.melon.fragments.melontv.program.p(this, 2));
    }

    private static final void onViewCreated$lambda$2(TvProgramMoreSongFragment tvProgramMoreSongFragment0, View view0) {
        if(!tvProgramMoreSongFragment0.isRetainedPopupShowing()) {
            ArrayList arrayList0 = tvProgramMoreSongFragment0.epsdList;
            int v = tvProgramMoreSongFragment0.filterYearPosition;
            int v1 = tvProgramMoreSongFragment0.filterRoundPosition;
            m m0 = new m(tvProgramMoreSongFragment0);
            CommonFilterPopup commonFilterPopup0 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(CommonFilterPopup.Companion, 0x7F130213, "LIST_TYPE_DEPTH_TWO_HORIZONTAL", arrayList0, v, v1, 0, m0, 0x20, null);  // string:common_filter_popup_title_episode "회차"
            FragmentActivity fragmentActivity0 = tvProgramMoreSongFragment0.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    commonFilterPopup0.setDismissFragment(tvProgramMoreSongFragment0);
                    commonFilterPopup0.show(l00, "ComposeBottomSheet");
                }
            }
        }
    }

    private static final H onViewCreated$lambda$2$lambda$0(TvProgramMoreSongFragment tvProgramMoreSongFragment0, int v, int v1, int v2) {
        H h0 = H.a;
        if(v != tvProgramMoreSongFragment0.filterYearPosition || v1 != tvProgramMoreSongFragment0.filterRoundPosition) {
            tvProgramMoreSongFragment0.filterYearPosition = v;
            tvProgramMoreSongFragment0.filterRoundPosition = v1;
            String s = ((j)((j)tvProgramMoreSongFragment0.epsdList.get(v)).e.get(tvProgramMoreSongFragment0.filterRoundPosition)).a;
            tvProgramMoreSongFragment0.getOrderButton().setText(s);
            tvProgramMoreSongFragment0.startFetch("filter change");
            if(tvProgramMoreSongFragment0.tiaraBase != null) {
                f f0 = tvProgramMoreSongFragment0.getTiaraBuilder();
                String s1 = null;
                f0.a = tvProgramMoreSongFragment0.getContext() == null ? null : "페이지이동";
                if(tvProgramMoreSongFragment0.getContext() != null) {
                    s1 = "리스트";
                }
                f0.y = s1;
                f0.F = s;
                f0.a().track();
            }
        }
        return h0;
    }

    private static final void onViewCreated$lambda$4(TvProgramMoreSongFragment tvProgramMoreSongFragment0, View view0) {
        tvProgramMoreSongFragment0.playAll();
        if(tvProgramMoreSongFragment0.tiaraBase != null) {
            Context context0 = tvProgramMoreSongFragment0.getContext();
            if(context0 != null) {
                tvProgramMoreSongFragment0.buildPlayBtnTiaraLog("음악재생", l1.m("음악재생", "getString(...)", context0, 0x7F130CF9, "getString(...)"));  // string:tiara_click_copy_all_play "전체재생"
            }
        }
    }

    private static final void onViewCreated$lambda$6(TvProgramMoreSongFragment tvProgramMoreSongFragment0, View view0) {
        tvProgramMoreSongFragment0.playSongs(true, true, true);
        if(tvProgramMoreSongFragment0.tiaraBase != null) {
            Context context0 = tvProgramMoreSongFragment0.getContext();
            if(context0 != null) {
                tvProgramMoreSongFragment0.buildPlayBtnTiaraLog("음악재생", l1.m("음악재생", "getString(...)", context0, 0x7F130D9C, "getString(...)"));  // string:tiara_click_copy_shuffle_play "셔플재생"
            }
        }
    }

    private final void request(v9.i i0) {
        j0 j00 = this.mAdapter;
        if(j00 != null && j00 instanceof TvProgramRelativeSongAdapter) {
            v9.i i1 = v9.i.b;
            if(i1.equals(i0)) {
                ((TvProgramRelativeSongAdapter)j00).clear();
                this.getRecyclerView().scrollToPosition(0);
            }
            Params programMoreSongReq$Params0 = new Params();
            programMoreSongReq$Params0.progSeq = this.progSeq;
            if(!this.epsdList.isEmpty()) {
                programMoreSongReq$Params0.cnpckSeq = ((j)((j)this.epsdList.get(this.filterYearPosition)).e.get(this.filterRoundPosition)).c;
            }
            programMoreSongReq$Params0.startIndex = q.b(i0, i1) ? 1 : ((TvProgramRelativeSongAdapter)j00).getCount() + 1;
            RequestBuilder.newInstance(new ProgramMoreSongReq(this.getContext(), programMoreSongReq$Params0)).tag(this.getRequestTag()).listener(new o(this, i0, j00, 0)).errorListener(new n(this)).request();
        }
    }

    public static void request$default(TvProgramMoreSongFragment tvProgramMoreSongFragment0, v9.i i0, int v, Object object0) {
        if((v & 1) != 0) {
            i0 = v9.i.b;
        }
        tvProgramMoreSongFragment0.request(i0);
    }

    private static final void request$lambda$12$lambda$10(TvProgramMoreSongFragment tvProgramMoreSongFragment0, v9.i i0, j0 j00, ProgramMoreSongRes programMoreSongRes0) {
        if(!tvProgramMoreSongFragment0.prepareFetchComplete(programMoreSongRes0)) {
            return;
        }
        tvProgramMoreSongFragment0.performFetchComplete(i0, programMoreSongRes0);
        ((TvProgramRelativeSongAdapter)j00).notifyDataSetChanged();
        List list0 = programMoreSongRes0.response.yearLists;
        q.f(list0, "yearLists");
        if(!list0.isEmpty()) {
            List list1 = programMoreSongRes0.response.yearLists;
            q.f(list1, "yearLists");
            tvProgramMoreSongFragment0.epsdList = tvProgramMoreSongFragment0.convertFilterList(list1);
        }
        tvProgramMoreSongFragment0.setAllCheckButtonVisibility(true);
        tvProgramMoreSongFragment0.setTiaraBase(new s(programMoreSongRes0.response.section, programMoreSongRes0.response.page, programMoreSongRes0.response.menuId, null));
    }

    private static final void request$lambda$12$lambda$11(TvProgramMoreSongFragment tvProgramMoreSongFragment0, VolleyError volleyError0) {
        tvProgramMoreSongFragment0.mResponseErrorListener.onErrorResponse(volleyError0);
        tvProgramMoreSongFragment0.setAllCheckButtonVisibility(false);
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        l1.B("setAllCheckButtonVisibility isVisible: ", z, LogU.Companion, "TvProgramMoreSongFragment");
        if(z) {
            this.getPlayShuffleButton().setVisibility(0);
            this.getPlayAllButton().setVisibility(0);
            if(this.epsdList.isEmpty()) {
                this.getOrderButton().setVisibility(8);
            }
            else {
                this.getOrderButton().setVisibility(0);
            }
            FilterLayout filterLayout0 = this.getFilterLayout();
            n n0 = new n(this);
            filterLayout0.b(I.e, n0);
            return;
        }
        this.getPlayShuffleButton().setVisibility(8);
        this.getPlayAllButton().setVisibility(8);
        this.getOrderButton().setVisibility(8);
        this.getFilterLayout().setOnCheckedListener(null);
        this.getFilterLayout().setLeftButton(null);
    }

    private static final void setAllCheckButtonVisibility$lambda$7(TvProgramMoreSongFragment tvProgramMoreSongFragment0, S s0, boolean z) {
        tvProgramMoreSongFragment0.toggleSelectAll();
        if(tvProgramMoreSongFragment0.tiaraBase != null) {
            f f0 = tvProgramMoreSongFragment0.getTiaraBuilder();
            String s1 = null;
            f0.a = tvProgramMoreSongFragment0.getContext() == null ? null : "선택";
            f0.d = ActionKind.ClickContent;
            f0.y = tvProgramMoreSongFragment0.getContext() == null ? null : "리스트";
            if(tvProgramMoreSongFragment0.getContext() != null) {
                s1 = "전체선택";
            }
            f0.F = s1;
            f0.a().track();
        }
    }

    public final void setEpsdList(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<set-?>");
        this.epsdList = arrayList0;
    }

    public final void setFilterContainer(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.filterContainer = view0;
    }

    public final void setFilterLayout(@NotNull FilterLayout filterLayout0) {
        q.g(filterLayout0, "<set-?>");
        this.filterLayout = filterLayout0;
    }

    public final void setFilterRoundPosition(int v) {
        this.filterRoundPosition = v;
    }

    public final void setFilterYearPosition(int v) {
        this.filterYearPosition = v;
    }

    public final void setOrderButton(@NotNull TextView textView0) {
        q.g(textView0, "<set-?>");
        this.orderButton = textView0;
    }

    public final void setPlayAllButton(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.playAllButton = view0;
    }

    public final void setPlayShuffleButton(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.playShuffleButton = view0;
    }

    public final void setProgName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.progName = s;
    }

    public final void setProgSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.progSeq = s;
    }

    public final void setTiaraBase(@NotNull s s0) {
        q.g(s0, "<set-?>");
        this.tiaraBase = s0;
    }
}

