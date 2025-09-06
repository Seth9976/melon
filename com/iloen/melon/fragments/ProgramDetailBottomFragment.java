package com.iloen.melon.fragments;

import J8.K2;
import J8.f3;
import J8.r;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.CastProgramEpsdReq.Params;
import com.iloen.melon.net.v5x.request.CastProgramEpsdReq;
import com.iloen.melon.net.v5x.response.CastProgramEpsdRes.Response.CastList;
import com.iloen.melon.net.v5x.response.CastProgramEpsdRes.Response;
import com.iloen.melon.net.v5x.response.CastProgramEpsdRes;
import com.iloen.melon.player.playlist.search.b;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import ie.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000 $2\u00020\u0001:\u0004$%&\'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000F\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001A\u00020\u00142\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010\u001A\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0018\u001A\u00020\u0017H\u0014¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0016\u0010 \u001A\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010!¨\u0006("}, d2 = {"Lcom/iloen/melon/fragments/ProgramDetailBottomFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "getCacheKey", "()Ljava/lang/String;", "isScreenLandscapeSupported", "()Z", "procSeq", "Ljava/lang/String;", "section", "page", "Companion", "ProgramDetailAdapter", "SubTitleViewHolder", "ProgramItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ProgramDetailBottomFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/ProgramDetailBottomFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PROCSEQ", "newInstance", "Lcom/iloen/melon/fragments/ProgramDetailBottomFragment;", "procSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ProgramDetailBottomFragment newInstance(@NotNull String s) {
            q.g(s, "procSeq");
            ProgramDetailBottomFragment programDetailBottomFragment0 = new ProgramDetailBottomFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argProcSeq", s);
            programDetailBottomFragment0.setArguments(bundle0);
            return programDetailBottomFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00020\u00032\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/ProgramDetailBottomFragment$ProgramDetailAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/CastInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "Lcom/iloen/melon/net/v5x/response/CastProgramEpsdRes$Response$CastList;", "list", "<init>", "(Lcom/iloen/melon/fragments/ProgramDetailBottomFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "getHeaderViewItemCount", "()I", "VIEW_TYPE_SUBTITLE", "I", "VIEW_TYPE_LIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class ProgramDetailAdapter extends p {
        private final int VIEW_TYPE_LIST;
        private final int VIEW_TYPE_SUBTITLE;

        public ProgramDetailAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.VIEW_TYPE_LIST = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? this.VIEW_TYPE_SUBTITLE : this.VIEW_TYPE_LIST;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof ProgramItemViewHolder) {
                ProgramDetailBottomFragment programDetailBottomFragment0 = ProgramDetailBottomFragment.this;
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.CastProgramEpsdRes.Response.CastList");
                ((ProgramItemViewHolder)o00).getTitleTv().setText(((CastList)object0).castTitle);
                ((ProgramItemViewHolder)o00).getDateTv().setText(((CastList)object0).castDate);
                f3 f30 = ((ProgramItemViewHolder)o00).getThumbContainer();
                f30.a.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
                f30.a.setClipToOutline(true);
                if(((ProgramItemViewHolder)o00).getContext() != null) {
                    Glide.with(((ProgramItemViewHolder)o00).getContext()).load(((CastList)object0).castImgUrl).into(((ProgramItemViewHolder)o00).getThumbnailIv());
                }
                ((ProgramItemViewHolder)o00).getWrapperLayout().setOnClickListener(new b(((CastList)object0), this, programDetailBottomFragment0, v1, 2));
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$1(CastList castProgramEpsdRes$Response$CastList0, ProgramDetailAdapter programDetailBottomFragment$ProgramDetailAdapter0, ProgramDetailBottomFragment programDetailBottomFragment0, int v, View view0) {
            Navigator.INSTANCE.openCastEpisodeDetail(castProgramEpsdRes$Response$CastList0.castSeq);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = programDetailBottomFragment$ProgramDetailAdapter0.getMenuId();
            g0.d = ActionKind.ClickContent;
            g0.a = "페이지이동";
            g0.b = programDetailBottomFragment0.section;
            g0.c = programDetailBottomFragment0.page;
            g0.y = "전체회차";
            g0.z = "페이지이동";
            g0.E = castProgramEpsdRes$Response$CastList0.castImgUrl;
            g0.C = String.valueOf(v + 1);
            g0.e = castProgramEpsdRes$Response$CastList0.castSeq;
            g0.f = p8.b.a((castProgramEpsdRes$Response$CastList0.contsTypeCode == null ? "" : castProgramEpsdRes$Response$CastList0.contsTypeCode));
            g0.g = castProgramEpsdRes$Response$CastList0.castTitle;
            g0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_SUBTITLE) {
                ProgramDetailBottomFragment programDetailBottomFragment0 = ProgramDetailBottomFragment.this;
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D05C4, viewGroup0, false);  // layout:program_detail_listitem_subtitle
                if(view0 == null) {
                    throw new NullPointerException("rootView");
                }
                return new SubTitleViewHolder(programDetailBottomFragment0, new K2(((LinearLayout)view0)));
            }
            r r0 = r.a(LayoutInflater.from(this.getContext()), viewGroup0);
            return new ProgramItemViewHolder(ProgramDetailBottomFragment.this, r0);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0011\u001A\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001A\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001A\u001A\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0017\u001A\u0004\b\u001B\u0010\u0019R\u001B\u0010!\u001A\u00020\u001C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 R\u001B\u0010$\u001A\u00020\u001C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001E\u001A\u0004\b#\u0010 ¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/ProgramDetailBottomFragment$ProgramItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/r;", "bind", "<init>", "(Lcom/iloen/melon/fragments/ProgramDetailBottomFragment;LJ8/r;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/View;", "wrapperLayout", "Landroid/view/View;", "getWrapperLayout", "()Landroid/view/View;", "LJ8/f3;", "thumbContainer", "LJ8/f3;", "getThumbContainer", "()LJ8/f3;", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "dateTv", "getDateTv", "Landroid/widget/ImageView;", "thumbnailIv$delegate", "Lie/j;", "getThumbnailIv", "()Landroid/widget/ImageView;", "thumbnailIv", "defaultThumbnailIv$delegate", "getDefaultThumbnailIv", "defaultThumbnailIv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ProgramItemViewHolder extends O0 {
        @Nullable
        private final Context context;
        @NotNull
        private final TextView dateTv;
        @NotNull
        private final j defaultThumbnailIv$delegate;
        @NotNull
        private final f3 thumbContainer;
        @NotNull
        private final j thumbnailIv$delegate;
        @NotNull
        private final TextView titleTv;
        @NotNull
        private final View wrapperLayout;

        public ProgramItemViewHolder(@NotNull r r0) {
            q.g(r0, "bind");
            ProgramDetailBottomFragment.this = programDetailBottomFragment0;
            super(r0.a);
            Context context0 = r0.a.getContext();
            this.context = context0;
            this.wrapperLayout = r0.f;
            this.thumbContainer = r0.c;
            this.titleTv = r0.e;
            this.dateTv = r0.d;
            this.thumbnailIv$delegate = d3.g.Q(new C(this, 0));
            this.defaultThumbnailIv$delegate = d3.g.Q(new C(this, 1));
            if(context0 != null) {
                ViewUtils.setDefaultImage(this.getDefaultThumbnailIv(), context0.getResources().getDimensionPixelSize(0x7F07045D));  // dimen:thumb_program_cast
            }
        }

        public static MelonImageView a(ProgramItemViewHolder programDetailBottomFragment$ProgramItemViewHolder0) {
            return ProgramItemViewHolder.thumbnailIv_delegate$lambda$0(programDetailBottomFragment$ProgramItemViewHolder0);
        }

        public static ImageView b(ProgramItemViewHolder programDetailBottomFragment$ProgramItemViewHolder0) {
            return ProgramItemViewHolder.defaultThumbnailIv_delegate$lambda$1(programDetailBottomFragment$ProgramItemViewHolder0);
        }

        private static final ImageView defaultThumbnailIv_delegate$lambda$1(ProgramItemViewHolder programDetailBottomFragment$ProgramItemViewHolder0) {
            q.f(programDetailBottomFragment$ProgramItemViewHolder0.thumbContainer.c, "ivThumbDefault");
            return programDetailBottomFragment$ProgramItemViewHolder0.thumbContainer.c;
        }

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final TextView getDateTv() {
            return this.dateTv;
        }

        @NotNull
        public final ImageView getDefaultThumbnailIv() {
            return (ImageView)this.defaultThumbnailIv$delegate.getValue();
        }

        @NotNull
        public final f3 getThumbContainer() {
            return this.thumbContainer;
        }

        @NotNull
        public final ImageView getThumbnailIv() {
            Object object0 = this.thumbnailIv$delegate.getValue();
            q.f(object0, "getValue(...)");
            return (ImageView)object0;
        }

        @NotNull
        public final TextView getTitleTv() {
            return this.titleTv;
        }

        @NotNull
        public final View getWrapperLayout() {
            return this.wrapperLayout;
        }

        private static final MelonImageView thumbnailIv_delegate$lambda$0(ProgramItemViewHolder programDetailBottomFragment$ProgramItemViewHolder0) {
            return programDetailBottomFragment$ProgramItemViewHolder0.thumbContainer.b;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/ProgramDetailBottomFragment$SubTitleViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/K2;", "bind", "<init>", "(Lcom/iloen/melon/fragments/ProgramDetailBottomFragment;LJ8/K2;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SubTitleViewHolder extends O0 {
        public SubTitleViewHolder(@NotNull K2 k20) {
            q.g(k20, "bind");
            ProgramDetailBottomFragment.this = programDetailBottomFragment0;
            super(k20.a);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_PROCSEQ = "argProcSeq";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ProgramHomeBottomFragment";
    @NotNull
    private String page;
    private String procSeq;
    @NotNull
    private String section;

    static {
        ProgramDetailBottomFragment.Companion = new Companion(null);
        ProgramDetailBottomFragment.$stable = 8;
    }

    public ProgramDetailBottomFragment() {
        this.section = "";
        this.page = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new ProgramDetailAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        Uri.Builder uri$Builder0 = MelonContentUris.V0.buildUpon().appendPath("castlist");
        String s = this.procSeq;
        if(s != null) {
            return l1.e(uri$Builder0, s, "toString(...)");
        }
        q.m("procSeq");
        throw null;
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
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        Params castProgramEpsdReq$Params0 = new Params();
        castProgramEpsdReq$Params0.startIndex = i.b.equals(i0) ? 1 : this.getItemCount() + 1;
        castProgramEpsdReq$Params0.pageSize = 50;
        String s1 = this.procSeq;
        if(s1 != null) {
            castProgramEpsdReq$Params0.progSeq = s1;
            RequestBuilder.newInstance(new CastProgramEpsdReq(this.getContext(), castProgramEpsdReq$Params0)).listener(new y(this, i0, 2)).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        q.m("procSeq");
        throw null;
    }

    private static final void onFetchStart$lambda$0(ProgramDetailBottomFragment programDetailBottomFragment0, i i0, CastProgramEpsdRes castProgramEpsdRes0) {
        String s1;
        if(!programDetailBottomFragment0.prepareFetchComplete(castProgramEpsdRes0)) {
            return;
        }
        programDetailBottomFragment0.performFetchComplete(i0, castProgramEpsdRes0);
        programDetailBottomFragment0.mAdapter.notifyDataSetChanged();
        Response castProgramEpsdRes$Response0 = castProgramEpsdRes0.response;
        String s = "";
        if(castProgramEpsdRes$Response0 == null) {
            s1 = "";
        }
        else {
            s1 = castProgramEpsdRes$Response0.section;
            if(s1 == null) {
                s1 = "";
            }
        }
        programDetailBottomFragment0.section = s1;
        if(castProgramEpsdRes$Response0 != null) {
            String s2 = castProgramEpsdRes$Response0.page;
            if(s2 != null) {
                s = s2;
            }
        }
        programDetailBottomFragment0.page = s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        String s = bundle0.getString("argProcSeq");
        if(s == null) {
            s = "";
        }
        this.procSeq = s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = this.procSeq;
        if(s != null) {
            bundle0.putString("argProcSeq", s);
            return;
        }
        q.m("procSeq");
        throw null;
    }
}

