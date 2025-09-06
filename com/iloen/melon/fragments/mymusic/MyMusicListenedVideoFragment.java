package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicRecentListMvRecntReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicRecentListMvRecntReq;
import com.iloen.melon.net.v4x.response.MyMusicRecentListMvRecntRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.MvHolderDefaultImpl.OnClickListener;
import com.iloen.melon.viewholders.MvHolderDefaultImpl;
import com.melon.net.res.common.MvInfoBase.REPARTIST;
import com.melon.net.res.common.MvInfoBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001A\u001A\u00020\u00192\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b \u0010\u001EJ\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014¢\u0006\u0004\b\'\u0010(R\u0016\u0010)\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "memberKey", "Ljava/lang/String;", "Companion", "ListenedMvAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicListenedVideoFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicListenedVideoFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicListenedVideoFragment myMusicListenedVideoFragment0 = new MyMusicListenedVideoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicListenedVideoFragment0.setArguments(bundle0);
            return myMusicListenedVideoFragment0;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002&\'B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0017\u0010\u0016J!\u0010\u001B\u001A\u00020\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001A\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ)\u0010\u001E\u001A\u00020\r2\b\u0010\u001D\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010$\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment$ListenedMvAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/MvInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "guide", "Lie/H;", "setGuideText", "(Ljava/lang/String;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "getFooterViewItemCount", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_MV", "VIEW_TYPE_FOOTER", "tvGuide", "Ljava/lang/String;", "HeaderViewHolder", "FooterViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ListenedMvAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment$ListenedMvAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment$ListenedMvAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class FooterViewHolder extends O0 {
            @NotNull
            private final MelonTextView tvTitle;

            public FooterViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ListenedMvAdapter.this = myMusicListenedVideoFragment$ListenedMvAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view1, "findViewById(...)");
                this.tvTitle = (MelonTextView)view1;
            }

            @NotNull
            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment$ListenedMvAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedVideoFragment$ListenedMvAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/SortingBarView;", "headerView", "Lcom/iloen/melon/custom/SortingBarView;", "getHeaderView", "()Lcom/iloen/melon/custom/SortingBarView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HeaderViewHolder extends O0 {
            @NotNull
            private final SortingBarView headerView;

            public HeaderViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ListenedMvAdapter.this = myMusicListenedVideoFragment$ListenedMvAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                q.f(view1, "findViewById(...)");
                this.headerView = (SortingBarView)view1;
                ((SortingBarView)view1).setSortBarStyle(0);
                B b0 = new B(MyMusicListenedVideoFragment.this, 4);
                ((SortingBarView)view1).c(L.d, b0);
            }

            private static final void _init_$lambda$0(MyMusicListenedVideoFragment myMusicListenedVideoFragment0, View view0) {
                myMusicListenedVideoFragment0.playAll();
            }

            public static void a(MyMusicListenedVideoFragment myMusicListenedVideoFragment0, View view0) {
                HeaderViewHolder._init_$lambda$0(myMusicListenedVideoFragment0, view0);
            }

            @NotNull
            public final SortingBarView getHeaderView() {
                return this.headerView;
            }
        }

        private final int VIEW_TYPE_FOOTER;
        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_MV;
        @NotNull
        private String tvGuide;

        public ListenedMvAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicListenedVideoFragment.this = myMusicListenedVideoFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_MV = 2;
            this.VIEW_TYPE_FOOTER = 3;
            this.tvGuide = "";
        }

        public static boolean a(MvInfoBase mvInfoBase0, ListenedMvAdapter myMusicListenedVideoFragment$ListenedMvAdapter0, MyMusicListenedVideoFragment myMusicListenedVideoFragment0, View view0) {
            return ListenedMvAdapter.onBindViewImpl$lambda$0(mvInfoBase0, myMusicListenedVideoFragment$ListenedMvAdapter0, myMusicListenedVideoFragment0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getFooterViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getFooterCount() > 0 && v == this.getAvailableFooterPosition()) {
                return this.VIEW_TYPE_FOOTER;
            }
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_MV : this.VIEW_TYPE_HEADER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            MvInfoBase mvInfoBase0 = (MvInfoBase)this.getItem(v1);
            if(o00 instanceof MvHolderDefaultImpl) {
                if(mvInfoBase0 != null) {
                    ((MvHolderDefaultImpl)o00).bindView(mvInfoBase0, true, this.getMenuId(), v1);
                    ((MvHolderDefaultImpl)o00).setOnClickListener(new OnClickListener() {
                        @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                        public void playMusicVideo(int v) {
                            mvInfoBase0.playMv(v);
                        }

                        @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                        public void showContextPopup(Playable playable0) {
                            q.g(playable0, "playable");
                            REPARTIST mvInfoBase$REPARTIST0 = this.$data.repArtist;
                            if(mvInfoBase$REPARTIST0 != null && mvInfoBase$REPARTIST0.isBrandDjs) {
                                playable0.setArtist(mvInfoBase$REPARTIST0.getArtistId(), mvInfoBase$REPARTIST0.getArtistName());
                                playable0.setBrandDj(mvInfoBase$REPARTIST0.isBrandDjs);
                            }
                            mvInfoBase0.showContextPopupMv(playable0);
                        }
                    });
                    A a0 = new A(mvInfoBase0, this, MyMusicListenedVideoFragment.this, 4);
                    ViewUtils.setOnLongClickListener(((MvHolderDefaultImpl)o00).itemView, a0);
                }
            }
            else if(o00 instanceof FooterViewHolder) {
                if(!TextUtils.isEmpty(this.tvGuide)) {
                    ViewUtils.showWhen(((FooterViewHolder)o00).getTvTitle(), true);
                    ViewUtils.setText(((FooterViewHolder)o00).getTvTitle(), this.tvGuide);
                    return;
                }
                ViewUtils.hideWhen(((FooterViewHolder)o00).getTvTitle(), true);
            }
        }

        private static final boolean onBindViewImpl$lambda$0(MvInfoBase mvInfoBase0, ListenedMvAdapter myMusicListenedVideoFragment$ListenedMvAdapter0, MyMusicListenedVideoFragment myMusicListenedVideoFragment0, View view0) {
            Playable playable0 = Playable.from(mvInfoBase0, myMusicListenedVideoFragment$ListenedMvAdapter0.getMenuId(), null);
            REPARTIST mvInfoBase$REPARTIST0 = mvInfoBase0.repArtist;
            if(mvInfoBase$REPARTIST0 != null && mvInfoBase$REPARTIST0.isBrandDjs) {
                playable0.setArtist(mvInfoBase$REPARTIST0.getArtistId(), mvInfoBase$REPARTIST0.getArtistName());
                playable0.setBrandDj(mvInfoBase$REPARTIST0.isBrandDjs);
            }
            myMusicListenedVideoFragment0.showContextPopupMv(playable0);
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D085C, viewGroup0, false);  // layout:sortbar_standalone
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_FOOTER) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D056F, viewGroup0, false);  // layout:mymusic_recent_last
                q.f(view1, "inflate(...)");
                return new FooterViewHolder(this, view1);
            }
            return new MvHolderDefaultImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D04BB, viewGroup0, false));  // layout:listitem_video
        }

        public final void setGuideText(@NotNull String s) {
            q.g(s, "guide");
            this.tvGuide = s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MyMusicListenedVideoFragment";
    @NotNull
    private String memberKey;

    static {
        MyMusicListenedVideoFragment.Companion = new Companion(null);
        MyMusicListenedVideoFragment.$stable = 8;
    }

    public MyMusicListenedVideoFragment() {
        this.memberKey = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new ListenedMvAdapter(this, context0, null);
        ((j)j00).setListContentType(3);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.V.buildUpon().appendPath("video"), "targetMemberKey", this.memberKey, "toString(...)");
    }

    @NotNull
    public static final MyMusicListenedVideoFragment newInstance(@NotNull String s) {
        return MyMusicListenedVideoFragment.Companion.newInstance(s);
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
        return layoutInflater0.inflate(0x7F0D056B, viewGroup0, false);  // layout:mymusic_more
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        Params myMusicRecentListMvRecntReq$Params0 = new Params();
        myMusicRecentListMvRecntReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicRecentListMvRecntReq(this.getContext(), myMusicRecentListMvRecntReq$Params0)).tag("MyMusicListenedVideoFragment").listener(new g(this, i0, 20)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$2(MyMusicListenedVideoFragment myMusicListenedVideoFragment0, i i0, MyMusicRecentListMvRecntRes myMusicRecentListMvRecntRes0) {
        if(!myMusicListenedVideoFragment0.prepareFetchComplete(myMusicRecentListMvRecntRes0)) {
            return;
        }
        ArrayList arrayList0 = myMusicRecentListMvRecntRes0.response == null ? null : myMusicRecentListMvRecntRes0.response.mvlist;
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            j0 j00 = myMusicListenedVideoFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicListenedVideoFragment.ListenedMvAdapter");
            String s = myMusicRecentListMvRecntRes0.response.guidetext;
            q.f(s, "guidetext");
            ((ListenedMvAdapter)j00).setGuideText(s);
        }
        myMusicListenedVideoFragment0.performFetchComplete(i0, myMusicRecentListMvRecntRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        this.memberKey = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", this.memberKey);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }
}

