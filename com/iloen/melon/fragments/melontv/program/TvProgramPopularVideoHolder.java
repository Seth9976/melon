package com.iloen.melon.fragments.melontv.program;

import Ad.n;
import Cb.k;
import U4.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.o;
import com.iloen.melon.custom.O;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.fragments.main.common.TabItemViewHolder;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.POPULARMVINFO;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001F2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0003\u001F !B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0014\u001A\u00020\u00102\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001D\u001A\b\u0018\u00010\u001CR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder;", "Lcom/iloen/melon/fragments/main/common/TabItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/ProgramHomeRes$RESPONSE$POPULARMVINFO;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "listner", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;)V", "Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$ViewHolder;", "viewHolder", "Lcom/melon/net/res/common/MvInfoBase;", "item", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$ViewHolder;Lcom/melon/net/res/common/MvInfoBase;I)V", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "getListner", "()Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$InnerRecyclerAdapter;", "Companion", "InnerRecyclerAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TvProgramPopularVideoHolder extends TabItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder;", "parent", "Landroid/view/ViewGroup;", "listener", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TvProgramPopularVideoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
            q.g(viewGroup0, "parent");
            q.g(tvProgramHomeFragment$TvProgramItemClickListener0, "listener");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D08C8, viewGroup0, false);  // layout:tvprogram_home_popular_video_layout
            q.d(view0);
            return new TvProgramPopularVideoHolder(view0, tvProgramHomeFragment$TvProgramItemClickListener0);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/o;", "Lcom/melon/net/res/common/MvInfoBase;", "Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$ViewHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "viewHolder", "initViewHolder", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$ViewHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$ViewHolder;II)V", "Landroid/view/LayoutInflater;", "mInflater", "Landroid/view/LayoutInflater;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends o {
        @NotNull
        private final LayoutInflater mInflater;

        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            LayoutInflater layoutInflater0 = LayoutInflater.from(context0);
            q.f(layoutInflater0, "from(...)");
            this.mInflater = layoutInflater0;
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((ViewHolder)o00));
        }

        public void initViewHolder(@NotNull ViewHolder tvProgramPopularVideoHolder$ViewHolder0) {
            q.g(tvProgramPopularVideoHolder$ViewHolder0, "viewHolder");
            tvProgramPopularVideoHolder$ViewHolder0.getThumbnail().setImageDrawable(null);
            tvProgramPopularVideoHolder$ViewHolder0.getPlayTime().setText("");
            tvProgramPopularVideoHolder$ViewHolder0.getTitle().setText("");
            tvProgramPopularVideoHolder$ViewHolder0.getArtist().setText("");
            tvProgramPopularVideoHolder$ViewHolder0.getDate().setText("");
            tvProgramPopularVideoHolder$ViewHolder0.getGrade19().setVisibility(8);
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder tvProgramPopularVideoHolder$ViewHolder0, int v, int v1) {
            q.g(tvProgramPopularVideoHolder$ViewHolder0, "viewHolder");
            this.initViewHolder(tvProgramPopularVideoHolder$ViewHolder0);
            MvInfoBase mvInfoBase0 = (MvInfoBase)this.getItem(v1);
            TvProgramPopularVideoHolder.this.bindItem(tvProgramPopularVideoHolder$ViewHolder0, mvInfoBase0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = this.mInflater.inflate(0x7F0D08C7, viewGroup0, false);  // layout:tvprogram_home_popular_video_item_layout
            q.f(view0, "inflate(...)");
            return new ViewHolder(view0);
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u001F\u0010\f\u001A\n \u000B*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001A\u0004\b\r\u0010\nR\u001F\u0010\u000F\u001A\n \u000B*\u0004\u0018\u00010\u000E0\u000E8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001A\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001A\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001A\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001A\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0017\u001A\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001A\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramPopularVideoHolder$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "thumbnail", "Landroid/widget/ImageView;", "getThumbnail", "()Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "grade19", "getGrade19", "Landroid/widget/TextView;", "playTime", "Landroid/widget/TextView;", "getPlayTime", "()Landroid/widget/TextView;", "title", "getTitle", "artist", "getArtist", "date", "getDate", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @NotNull
        private final TextView artist;
        @NotNull
        private final TextView date;
        private final ImageView grade19;
        private final TextView playTime;
        @NotNull
        private final ImageView thumbnail;
        @NotNull
        private final TextView title;

        public ViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            super(view0);
            View view1 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
            q.f(view1, "findViewById(...)");
            this.thumbnail = (ImageView)view1;
            this.grade19 = (ImageView)view0.findViewById(0x7F0A0633);  // id:iv_grade
            this.playTime = (TextView)view0.findViewById(0x7F0A0CE5);  // id:tv_playtime
            View view2 = view0.findViewById(0x7F0A0B8D);  // id:title
            q.f(view2, "findViewById(...)");
            this.title = (TextView)view2;
            View view3 = view0.findViewById(0x7F0A00B1);  // id:artist
            q.f(view3, "findViewById(...)");
            this.artist = (TextView)view3;
            View view4 = view0.findViewById(0x7F0A037A);  // id:date
            q.f(view4, "findViewById(...)");
            this.date = (TextView)view4;
        }

        @NotNull
        public final TextView getArtist() {
            return this.artist;
        }

        @NotNull
        public final TextView getDate() {
            return this.date;
        }

        public final ImageView getGrade19() {
            return this.grade19;
        }

        public final TextView getPlayTime() {
            return this.playTime;
        }

        @NotNull
        public final ImageView getThumbnail() {
            return this.thumbnail;
        }

        @NotNull
        public final TextView getTitle() {
            return this.title;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "TvProgramPopularVideoHolder";
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    @NotNull
    private final TvProgramItemClickListener listner;
    @Nullable
    private RecyclerView recyclerView;

    static {
        TvProgramPopularVideoHolder.Companion = new Companion(null);
        TvProgramPopularVideoHolder.$stable = 8;
    }

    public TvProgramPopularVideoHolder(@NotNull View view0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
        q.g(view0, "itemView");
        q.g(tvProgramHomeFragment$TvProgramItemClickListener0, "listner");
        super(view0);
        this.listner = tvProgramHomeFragment$TvProgramItemClickListener0;
        RecyclerView recyclerView0 = (RecyclerView)view0.findViewById(0x7F0A09CF);  // id:recycler_horizontal
        this.recyclerView = recyclerView0;
        if(recyclerView0 != null) {
            recyclerView0.setHasFixedSize(true);
        }
        RecyclerView recyclerView1 = this.recyclerView;
        if(recyclerView1 != null) {
            recyclerView1.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if(recyclerView2 != null) {
            recyclerView2.addItemDecoration(new O());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if(recyclerView3 != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(0, false));
        }
        view0.addOnAttachStateChangeListener(this);
        this.innerAdapter = new InnerRecyclerAdapter(this, this.getContext(), null);
    }

    private final void bindItem(ViewHolder tvProgramPopularVideoHolder$ViewHolder0, MvInfoBase mvInfoBase0, int v) {
        Context context0 = this.getContext();
        if(context0 != null && mvInfoBase0 != null) {
            Glide.with(context0).load(mvInfoBase0.mv169Img).into(tvProgramPopularVideoHolder$ViewHolder0.getThumbnail());
            tvProgramPopularVideoHolder$ViewHolder0.getGrade19().setVisibility((mvInfoBase0.isAdult ? 0 : 8));
            TextView textView0 = tvProgramPopularVideoHolder$ViewHolder0.getPlayTime();
            String s = mvInfoBase0.playTime;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            textView0.setText(k.f(s));
            tvProgramPopularVideoHolder$ViewHolder0.getTitle().setText(mvInfoBase0.mvName);
            tvProgramPopularVideoHolder$ViewHolder0.getArtist().setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(this.getContext(), mvInfoBase0.artistList, 1));
            tvProgramPopularVideoHolder$ViewHolder0.getDate().setText(mvInfoBase0.issueDate);
            n n0 = new n(this, mvInfoBase0, v, 13);
            tvProgramPopularVideoHolder$ViewHolder0.itemView.setOnClickListener(n0);
            String s2 = k.e(mvInfoBase0.playTime);
            List list0 = Tf.o.R0((mvInfoBase0.issueDate == null ? "" : mvInfoBase0.issueDate), new String[]{"."}, 0, 6);
            if(list0.size() == 3) {
                s1 = list0.get(0) + "년" + list0.get(1) + "월" + list0.get(2) + "일";
            }
            String s3 = mvInfoBase0.mvName;
            CharSequence charSequence0 = tvProgramPopularVideoHolder$ViewHolder0.getArtist().getText();
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(s3);
            stringBuilder0.append(", ");
            stringBuilder0.append(charSequence0);
            stringBuilder0.append(", ");
            stringBuilder0.append(s2);
            String s4 = x.m(stringBuilder0, ", ", s1);
            ViewUtils.setContentDescriptionWithClassName(tvProgramPopularVideoHolder$ViewHolder0.itemView, s4, "android.widget.Button", null);
        }
    }

    private static final void bindItem$lambda$3$lambda$2(TvProgramPopularVideoHolder tvProgramPopularVideoHolder0, MvInfoBase mvInfoBase0, int v, View view0) {
        tvProgramPopularVideoHolder0.listner.onClickPopularItemView(mvInfoBase0, v);
    }

    @NotNull
    public final TvProgramItemClickListener getListner() {
        return this.listner;
    }

    @NotNull
    public static final TvProgramPopularVideoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
        return TvProgramPopularVideoHolder.Companion.newInstance(viewGroup0, tvProgramHomeFragment$TvProgramItemClickListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        String s;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        POPULARMVINFO programHomeRes$RESPONSE$POPULARMVINFO0 = (POPULARMVINFO)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            if(programHomeRes$RESPONSE$POPULARMVINFO0 == null) {
                s = "";
            }
            else {
                s = programHomeRes$RESPONSE$POPULARMVINFO0.title;
                if(s == null) {
                    s = "";
                }
            }
            mainTabTitleView0.setTitle(s);
        }
        if(programHomeRes$RESPONSE$POPULARMVINFO0 != null) {
            ArrayList arrayList0 = programHomeRes$RESPONSE$POPULARMVINFO0.list;
            if(arrayList0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), arrayList0)) {
                RecyclerView recyclerView0 = this.recyclerView;
                if(recyclerView0 != null) {
                    recyclerView0.setAdapter(this.innerAdapter);
                }
                InnerRecyclerAdapter tvProgramPopularVideoHolder$InnerRecyclerAdapter0 = this.innerAdapter;
                if(tvProgramPopularVideoHolder$InnerRecyclerAdapter0 != null) {
                    tvProgramPopularVideoHolder$InnerRecyclerAdapter0.setItems(arrayList0);
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.main.common.TabItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

