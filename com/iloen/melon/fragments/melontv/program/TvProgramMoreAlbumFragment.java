package com.iloen.melon.fragments.melontv.program;

import B.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.request.ProgramMoreAlbumReq.OrderType;
import com.iloen.melon.net.v6x.request.ProgramMoreAlbumReq.Params;
import com.iloen.melon.net.v6x.request.ProgramMoreAlbumReq;
import com.iloen.melon.net.v6x.response.ProgramMoreAlbumRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.AlbumInfoBase;
import java.util.List;
import je.n;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 L2\u00020\u0001:\u0004MNOLB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\u0005\u001A\u00020\u0004H\u0003\u00A2\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b \u0010\u001EJ\u001B\u0010$\u001A\u0006\u0012\u0002\b\u00030#2\u0006\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010\'\u001A\u00020&H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b)\u0010*R\"\u0010+\u001A\u00020\u00178\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b+\u0010,\u001A\u0004\b-\u0010*\"\u0004\b.\u0010/R\"\u00101\u001A\u0002008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u00102\u001A\u0004\b3\u00104\"\u0004\b5\u00106R(\u00108\u001A\b\u0012\u0004\u0012\u00020\u0017078\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b8\u00109\u001A\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001A\u00020\u00178\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010,\u001A\u0004\b?\u0010*\"\u0004\b@\u0010/R\"\u0010B\u001A\u00020A8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bB\u0010C\u001A\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010K\u001A\u00020H8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bI\u0010J\u00A8\u0006P"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment;", "Lcom/iloen/melon/fragments/FetcherBaseFragment;", "<init>", "()V", "Lv9/i;", "type", "Lie/H;", "request", "(Lv9/i;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCacheKey", "()Ljava/lang/String;", "progSeq", "Ljava/lang/String;", "getProgSeq", "setProgSeq", "(Ljava/lang/String;)V", "Lcom/iloen/melon/net/v6x/request/ProgramMoreAlbumReq$OrderType;", "orderBy", "Lcom/iloen/melon/net/v6x/request/ProgramMoreAlbumReq$OrderType;", "getOrderBy", "()Lcom/iloen/melon/net/v6x/request/ProgramMoreAlbumReq$OrderType;", "setOrderBy", "(Lcom/iloen/melon/net/v6x/request/ProgramMoreAlbumReq$OrderType;)V", "", "filterList", "Ljava/util/List;", "getFilterList", "()Ljava/util/List;", "setFilterList", "(Ljava/util/List;)V", "progName", "getProgName", "setProgName", "Lp8/s;", "tiaraBase", "Lp8/s;", "getTiaraBase", "()Lp8/s;", "setTiaraBase", "(Lp8/s;)V", "Lp8/f;", "getTiaraBuilder", "()Lp8/f;", "tiaraBuilder", "Companion", "TvProgramRelativeAlbumAdapter", "FilterViewHolder", "TvProgramAlbumViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TvProgramMoreAlbumFragment extends FetcherBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PROGSEQ", "ARG_PROGNAME", "newInstance", "Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment;", "progSeq", "progName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TvProgramMoreAlbumFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "progSeq");
            q.g(s1, "progName");
            TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0 = new TvProgramMoreAlbumFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argProcSeq", s);
            bundle0.putString("argProgName", s1);
            tvProgramMoreAlbumFragment0.setArguments(bundle0);
            return tvProgramMoreAlbumFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment$FilterViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment;Landroid/view/View;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "orderByTextView", "Landroid/widget/TextView;", "getOrderByTextView", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class FilterViewHolder extends O0 {
        private final TextView orderByTextView;

        public FilterViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            TvProgramMoreAlbumFragment.this = tvProgramMoreAlbumFragment0;
            super(view0);
            TextView textView0 = (TextView)view0.findViewById(0x7F0A08E7);  // id:order_tv
            this.orderByTextView = textView0;
            if(textView0 != null) {
                textView0.setText(((CharSequence)tvProgramMoreAlbumFragment0.getFilterList().get(tvProgramMoreAlbumFragment0.getOrderBy().ordinal())));
            }
            view0.setOnClickListener(new b(1, tvProgramMoreAlbumFragment0, this));
        }

        private static final void _init_$lambda$2(TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, FilterViewHolder tvProgramMoreAlbumFragment$FilterViewHolder0, View view0) {
            if(tvProgramMoreAlbumFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = tvProgramMoreAlbumFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle("정렬");
                    bottomSingleFilterListPopup0.setFilterItem(tvProgramMoreAlbumFragment0.getFilterList(), tvProgramMoreAlbumFragment0.getOrderBy().ordinal());
                    bottomSingleFilterListPopup0.setFilterListener(new k(tvProgramMoreAlbumFragment0, tvProgramMoreAlbumFragment$FilterViewHolder0, 0));
                    bottomSingleFilterListPopup0.setOnDismissListener(tvProgramMoreAlbumFragment0.mDialogDismissListener);
                    tvProgramMoreAlbumFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        public final TextView getOrderByTextView() {
            return this.orderByTextView;
        }

        private static final void lambda$2$lambda$1$lambda$0(TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, FilterViewHolder tvProgramMoreAlbumFragment$FilterViewHolder0, int v) {
            OrderType programMoreAlbumReq$OrderType0 = OrderType.getType(v);
            if(tvProgramMoreAlbumFragment0.getOrderBy() != programMoreAlbumReq$OrderType0) {
                String s = (String)tvProgramMoreAlbumFragment0.getFilterList().get(v);
                q.d(programMoreAlbumReq$OrderType0);
                tvProgramMoreAlbumFragment0.setOrderBy(programMoreAlbumReq$OrderType0);
                TextView textView0 = tvProgramMoreAlbumFragment$FilterViewHolder0.orderByTextView;
                if(textView0 != null) {
                    textView0.setText(s);
                }
                tvProgramMoreAlbumFragment0.startFetch("filter change");
                f f0 = tvProgramMoreAlbumFragment0.getTiaraBuilder();
                f0.a = tvProgramMoreAlbumFragment0.getContext() == null ? null : "페이지이동";
                f0.F = s;
                f0.a().track();
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0011\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010R\u001F\u0010\u0013\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000E\u001A\u0004\b\u0014\u0010\u0010R\u001F\u0010\u0015\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment$TvProgramAlbumViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment;Landroid/view/View;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "albumImg", "Landroid/widget/ImageView;", "getAlbumImg", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "albumTitle", "Landroid/widget/TextView;", "getAlbumTitle", "()Landroid/widget/TextView;", "artist", "getArtist", "date", "getDate", "btnPlayIv", "Landroid/view/View;", "getBtnPlayIv", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TvProgramAlbumViewHolder extends O0 {
        private final ImageView albumImg;
        private final TextView albumTitle;
        private final TextView artist;
        private final View btnPlayIv;
        private final TextView date;

        public TvProgramAlbumViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            TvProgramMoreAlbumFragment.this = tvProgramMoreAlbumFragment0;
            super(view0);
            this.albumImg = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.albumTitle = (TextView)view0.findViewById(0x7F0A0B8D);  // id:title
            this.artist = (TextView)view0.findViewById(0x7F0A00B8);  // id:artist_name
            this.date = (TextView)view0.findViewById(0x7F0A037A);  // id:date
            this.btnPlayIv = view0.findViewById(0x7F0A091D);  // id:play_button
        }

        public final ImageView getAlbumImg() {
            return this.albumImg;
        }

        public final TextView getAlbumTitle() {
            return this.albumTitle;
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
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\u00032\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001B\u001A\u00020\u000B8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\rR\u001A\u0010\u001E\u001A\u00020\u000B8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001E\u0010\u001C\u001A\u0004\b\u001F\u0010\r¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "Lcom/melon/net/res/common/AlbumInfoBase;", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreAlbumFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "viewTypeAlbum", "I", "getViewTypeAlbum", "viewTypeFilter", "getViewTypeFilter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TvProgramRelativeAlbumAdapter extends p {
        private final int viewTypeAlbum;
        private final int viewTypeFilter;

        public TvProgramRelativeAlbumAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            TvProgramMoreAlbumFragment.this = tvProgramMoreAlbumFragment0;
            super(context0, list0);
            this.viewTypeFilter = 1;
        }

        public static void a(TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, AlbumInfoBase albumInfoBase0, TvProgramRelativeAlbumAdapter tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0, int v, View view0) {
            TvProgramRelativeAlbumAdapter.onBindViewImpl$lambda$0(albumInfoBase0, tvProgramMoreAlbumFragment0, tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0, v, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? this.viewTypeFilter : this.viewTypeAlbum;
        }

        public final int getViewTypeAlbum() {
            return this.viewTypeAlbum;
        }

        public final int getViewTypeFilter() {
            return this.viewTypeFilter;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof TvProgramAlbumViewHolder) {
                Object object0 = this.getItem(v1);
                AlbumInfoBase albumInfoBase0 = object0 instanceof AlbumInfoBase ? ((AlbumInfoBase)object0) : null;
                if(albumInfoBase0 != null) {
                    Glide.with(this.getContext()).load(albumInfoBase0.albumImg).into(((TvProgramAlbumViewHolder)o00).getAlbumImg());
                    ((TvProgramAlbumViewHolder)o00).getAlbumTitle().setText(albumInfoBase0.albumName);
                    ((TvProgramAlbumViewHolder)o00).getArtist().setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(this.getContext(), albumInfoBase0.artistList, 0x7FFFFFFF));
                    ((TvProgramAlbumViewHolder)o00).getDate().setText(albumInfoBase0.issueDate);
                    l l0 = new l(albumInfoBase0, TvProgramMoreAlbumFragment.this, this, v1, 0);
                    ((TvProgramAlbumViewHolder)o00).itemView.setOnClickListener(l0);
                    ((TvProgramAlbumViewHolder)o00).getBtnPlayIv().setOnClickListener(new l(TvProgramMoreAlbumFragment.this, albumInfoBase0, this, v1));
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(AlbumInfoBase albumInfoBase0, TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, TvProgramRelativeAlbumAdapter tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0, int v, View view0) {
            Navigator.openAlbumInfo(albumInfoBase0.albumId);
            f f0 = tvProgramMoreAlbumFragment0.getTiaraBuilder();
            f0.a = tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0.getContext() == null ? null : "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.C = String.valueOf(v);
            f0.e = albumInfoBase0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = albumInfoBase0.albumName;
            f0.a().track();
        }

        private static final void onBindViewImpl$lambda$1(TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, AlbumInfoBase albumInfoBase0, TvProgramRelativeAlbumAdapter tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0, int v, View view0) {
            tvProgramMoreAlbumFragment0.playAlbum(albumInfoBase0.albumId, tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0.getMenuId());
            f f0 = tvProgramMoreAlbumFragment0.getTiaraBuilder();
            f0.a = tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0.getContext() == null ? null : "음악재생";
            f0.d = ActionKind.PlayMusic;
            f0.C = String.valueOf(v);
            f0.e = albumInfoBase0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            f0.g = albumInfoBase0.albumName;
            f0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.viewTypeFilter) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08CC, viewGroup0, false);  // layout:tvprogram_morealbum_filter
                q.f(view0, "inflate(...)");
                return new FilterViewHolder(TvProgramMoreAlbumFragment.this, view0);
            }
            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08BF, viewGroup0, false);  // layout:tvprogram_album_item_layout
            q.f(view1, "inflate(...)");
            return new TvProgramAlbumViewHolder(TvProgramMoreAlbumFragment.this, view1);
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
    public static final String TAG = "TvProgramMoreAlbumFragment";
    public List filterList;
    @NotNull
    private OrderType orderBy;
    @NotNull
    private String progName;
    @NotNull
    private String progSeq;
    public s tiaraBase;

    static {
        TvProgramMoreAlbumFragment.Companion = new Companion(null);
        TvProgramMoreAlbumFragment.$stable = 8;
    }

    public TvProgramMoreAlbumFragment() {
        this.progSeq = "";
        this.orderBy = OrderType.NEW;
        this.progName = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new TvProgramRelativeAlbumAdapter(this, context0, null);
        ((p)j00).setHeaderParallaxEnabled(true);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.V0.buildUpon().appendPath("morealbum"), this.progSeq, "toString(...)");
    }

    @NotNull
    public final List getFilterList() {
        List list0 = this.filterList;
        if(list0 != null) {
            return list0;
        }
        q.m("filterList");
        throw null;
    }

    @NotNull
    public final OrderType getOrderBy() {
        return this.orderBy;
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
        f0.y = this.getContext() == null ? null : "리스트";
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
        return layoutInflater0.inflate(0x7F0D08CD, viewGroup0, false);  // layout:tvprogram_related_album_layout
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @Nullable h h0, @Nullable String s) {
        q.g(i0, "type");
        LogU.Companion.d("TvProgramMoreAlbumFragment", "onFetchStart");
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
        if(this.getTitleBar() != null) {
            this.getTitleBar().a(a.s(7));
            this.getTitleBar().setBackgroundColor(0);
            TitleBar titleBar0 = this.getTitleBar();
            Context context0 = this.getContext();
            titleBar0.setTitle((context0 == null || context0.getResources() == null ? null : "연관 앨범"));
        }
        String[] arr_s = this.getResources().getStringArray(0x7F03003F);  // array:sortingbar_melontv_more_album
        q.f(arr_s, "getStringArray(...)");
        this.setFilterList(n.N(arr_s));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void request(i i0) {
        Params programMoreAlbumReq$Params0 = new Params();
        programMoreAlbumReq$Params0.progSeq = this.progSeq;
        programMoreAlbumReq$Params0.orderBy = this.orderBy.getValue();
        RequestBuilder.newInstance(new ProgramMoreAlbumReq(this.getContext(), programMoreAlbumReq$Params0)).tag(this.getRequestTag()).listener(new k(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
    }

    public static void request$default(TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, i i0, int v, Object object0) {
        if((v & 1) != 0) {
            i0 = i.b;
        }
        tvProgramMoreAlbumFragment0.request(i0);
    }

    private static final void request$lambda$1(TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, i i0, ProgramMoreAlbumRes programMoreAlbumRes0) {
        if(tvProgramMoreAlbumFragment0.mAdapter != null && tvProgramMoreAlbumFragment0.mAdapter instanceof TvProgramRelativeAlbumAdapter) {
            if(!tvProgramMoreAlbumFragment0.prepareFetchComplete(programMoreAlbumRes0)) {
                return;
            }
            tvProgramMoreAlbumFragment0.performFetchComplete(i0, programMoreAlbumRes0);
            tvProgramMoreAlbumFragment0.mAdapter.notifyDataSetChanged();
        }
        tvProgramMoreAlbumFragment0.setTiaraBase(new s(programMoreAlbumRes0.response.section, programMoreAlbumRes0.response.page, programMoreAlbumRes0.response.menuId, null));
    }

    public final void setFilterList(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.filterList = list0;
    }

    public final void setOrderBy(@NotNull OrderType programMoreAlbumReq$OrderType0) {
        q.g(programMoreAlbumReq$OrderType0, "<set-?>");
        this.orderBy = programMoreAlbumReq$OrderType0;
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

