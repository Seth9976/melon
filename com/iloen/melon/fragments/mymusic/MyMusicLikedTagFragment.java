package com.iloen.melon.fragments.mymusic;

import B9.w;
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
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.ToggleView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.LikeListTagBaseReq.Params;
import com.iloen.melon.net.v5x.request.MyMusicLikeListTagReq;
import com.iloen.melon.net.v5x.response.LikeListTagBaseRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v5x.response.MyMusicLikeListTagRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.k;
import e1.u;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 82\u00020\u0001:\u000289B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001D\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001B\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020\u00068\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020\u00068\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u0010-R\u0016\u00102\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00100R$\u00106\u001A\u0012\u0012\u0004\u0012\u00020403j\b\u0012\u0004\u0012\u000204`58\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107\u00A8\u0006:"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedTagFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "setFilterData", "", "position", "", "getFilterTypeForServer", "(I)Ljava/lang/String;", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "START_INDEX", "I", "PAGE_SIZE", "filterType", "Ljava/lang/String;", "togglePos", "memberKey", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "filterList", "Ljava/util/ArrayList;", "Companion", "LikedTagAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicLikedTagFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedTagFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicLikedTagFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicLikedTagFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicLikedTagFragment myMusicLikedTagFragment0 = new MyMusicLikedTagFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicLikedTagFragment0.setArguments(bundle0);
            return myMusicLikedTagFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001EB+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\u00032\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001C¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedTagFragment$LikedTagAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/LikeListTagBaseRes$RESPONSE$TAGLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedTagFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_TAG", "HeaderViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LikedTagAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedTagFragment$LikedTagAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedTagFragment$LikedTagAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/ToggleView;", "toggleView", "Lcom/iloen/melon/custom/ToggleView;", "getToggleView", "()Lcom/iloen/melon/custom/ToggleView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HeaderViewHolder extends O0 {
            @NotNull
            private final ToggleView toggleView;

            public HeaderViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LikedTagAdapter.this = myMusicLikedTagFragment$LikedTagAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BBD);  // id:toggle_layout
                q.f(view1, "findViewById(...)");
                this.toggleView = (ToggleView)view1;
                String[] arr_s = MyMusicLikedTagFragment.this.getResources().getStringArray(0x7F030031);  // array:sorting_bar_tag
                q.f(arr_s, "getStringArray(...)");
                ((ToggleView)view1).e(k.A(Arrays.copyOf(arr_s, arr_s.length)), new B(MyMusicLikedTagFragment.this, 2));
                ((ToggleView)view1).setFilterPosition(MyMusicLikedTagFragment.this.togglePos);
            }

            private static final void _init_$lambda$0(MyMusicLikedTagFragment myMusicLikedTagFragment0, int v, String s) {
                myMusicLikedTagFragment0.filterType = myMusicLikedTagFragment0.getFilterTypeForServer(v);
                myMusicLikedTagFragment0.togglePos = v;
                myMusicLikedTagFragment0.startFetch("filter change");
            }

            public static void a(MyMusicLikedTagFragment myMusicLikedTagFragment0, int v, String s) {
                HeaderViewHolder._init_$lambda$0(myMusicLikedTagFragment0, v, s);
            }

            @NotNull
            public final ToggleView getToggleView() {
                return this.toggleView;
            }
        }

        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_TAG;

        public LikedTagAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicLikedTagFragment.this = myMusicLikedTagFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_TAG = 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_TAG : this.VIEW_TYPE_HEADER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof HeaderViewHolder) {
                ToggleView toggleView0 = ((HeaderViewHolder)o00).getToggleView();
                g g0 = new g(MyMusicLikedTagFragment.this, this, 5);
                toggleView0.c(L.f, g0);
                return;
            }
            if(o00 instanceof w) {
                TAGLIST likeListTagBaseRes$RESPONSE$TAGLIST0 = (TAGLIST)this.getItem(v1);
                if(likeListTagBaseRes$RESPONSE$TAGLIST0 != null) {
                    Context context0 = this.getContext();
                    ImageView imageView0 = ((w)o00).a;
                    if(imageView0 != null) {
                        Glide.with(context0).clear(imageView0);
                        Glide.with(context0).load(likeListTagBaseRes$RESPONSE$TAGLIST0.tagImg).into(imageView0);
                    }
                    com.iloen.melon.fragments.mymusic.w w0 = new com.iloen.melon.fragments.mymusic.w(likeListTagBaseRes$RESPONSE$TAGLIST0, 1);
                    ViewUtils.setOnClickListener(((w)o00).itemView, w0);
                    String s = context0.getString(0x7F130773, new Object[]{likeListTagBaseRes$RESPONSE$TAGLIST0.tagName});  // string:mymusic_like_tag_title "#%1$s"
                    ((w)o00).c.setText(s);
                    String s1 = context0.getString(0x7F130772, new Object[]{StringUtils.getCountString(likeListTagBaseRes$RESPONSE$TAGLIST0.plylstCnt, 0x3B9AC9FF)});  // string:mymusic_like_tag_playlist_count "관련 플레이리스트 %1$s"
                    ((w)o00).d.setText(s1);
                    String s2 = StringUtils.getCountString(likeListTagBaseRes$RESPONSE$TAGLIST0.summcnt, 0x3B9AC9FF);
                    ((w)o00).e.setText(s2);
                }
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(MyMusicLikedTagFragment myMusicLikedTagFragment0, LikedTagAdapter myMusicLikedTagFragment$LikedTagAdapter0, View view0) {
            MyMusicLikeEditFragment.newInstance("tag", myMusicLikedTagFragment0.filterType, myMusicLikedTagFragment$LikedTagAdapter0.getCacheKey()).open();
        }

        private static final void onBindViewImpl$lambda$3$lambda$2(TAGLIST likeListTagBaseRes$RESPONSE$TAGLIST0, View view0) {
            Navigator.openMelonDJTagHubDetail(likeListTagBaseRes$RESPONSE$TAGLIST0.tagSeq);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D089B, viewGroup0, false);  // layout:toggle_standalone
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(this, view0);
            }
            return new w(LayoutInflater.from(this.getContext()).inflate(0x7F0D04B5, viewGroup0, false));  // layout:listitem_tag
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MyMusicLikedTagFragment";
    @NotNull
    private final ArrayList filterList;
    @NotNull
    private String filterType;
    @NotNull
    private String memberKey;
    private int togglePos;

    static {
        MyMusicLikedTagFragment.Companion = new Companion(null);
        MyMusicLikedTagFragment.$stable = 8;
    }

    public MyMusicLikedTagFragment() {
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.filterType = "NEW";
        this.memberKey = "";
        this.filterList = new ArrayList();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LikedTagAdapter(this, context0, null);
        ((j)j00).setListContentType(8);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("tag").appendQueryParameter("filterType", this.filterType), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final String getFilterTypeForServer(int v) {
        v9.j j0 = (v9.j)je.p.n0(v, this.filterList);
        if(j0 != null) {
            return j0.c == null ? "" : j0.c;
        }
        return "";
    }

    @NotNull
    public static final MyMusicLikedTagFragment newInstance(@NotNull String s) {
        return MyMusicLikedTagFragment.Companion.newInstance(s);
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
        int v;
        i i1 = i.b;
        if(i1.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedTagFragment.LikedTagAdapter");
            ((LikedTagAdapter)j00).clear();
        }
        Params likeListTagBaseReq$Params0 = new Params();
        likeListTagBaseReq$Params0.orderBy = this.filterType;
        if(i1.equals(i0)) {
            v = 1;
        }
        else {
            j0 j01 = this.mAdapter;
            q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedTagFragment.LikedTagAdapter");
            v = ((LikedTagAdapter)j01).getCount() + 1;
        }
        likeListTagBaseReq$Params0.startIndex = v;
        likeListTagBaseReq$Params0.pageSize = this.PAGE_SIZE;
        likeListTagBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeListTagReq(this.getContext(), likeListTagBaseReq$Params0)).tag("MyMusicLikedTagFragment").listener(new g(this, i0, 16)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(MyMusicLikedTagFragment myMusicLikedTagFragment0, i i0, MyMusicLikeListTagRes myMusicLikeListTagRes0) {
        if(!myMusicLikedTagFragment0.prepareFetchComplete(myMusicLikeListTagRes0)) {
            return;
        }
        myMusicLikedTagFragment0.performFetchComplete(i0, myMusicLikeListTagRes0);
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

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.setFilterData();
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    private final void setFilterData() {
        v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.c = "NEW";
        this.filterList.add(j0);
        v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j1.c = "ALPHABET";
        this.filterList.add(j1);
    }
}

