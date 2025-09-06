package com.iloen.melon.fragments.genre;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.GenreLabelAlbumlistReq.Params;
import com.iloen.melon.net.v5x.request.GenreLabelAlbumlistReq;
import com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 22\u00020\u0001:\u000223B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\bH\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\bH\u0016¢\u0006\u0004\b\u001E\u0010\u001CJ\u001D\u0010\"\u001A\b\u0012\u0002\b\u0003\u0018\u00010!2\u0006\u0010 \u001A\u00020\u001FH\u0014¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001A\u0004\u0018\u00010$H\u0014¢\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u000EH\u0004¢\u0006\u0004\b\'\u0010\u0003R\u0014\u0010)\u001A\u00020(8\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001A\u00020(8\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010,\u001A\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001A\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010-R\u0018\u00100\u001A\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelAlbumListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "buildTitleLayout", "", "START_INDEX", "I", "PAGE_SIZE", "labelSequence", "Ljava/lang/String;", "title", "Lcom/iloen/melon/custom/title/TitleBar;", "mTitleBarLayout", "Lcom/iloen/melon/custom/title/TitleBar;", "Companion", "GenreDetailLabelAlbumListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreDetailLabelAlbumListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelAlbumListFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_LABEL_SEQ", "ARG_TITLE", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailLabelAlbumListFragment;", "labelSeq", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailLabelAlbumListFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "labelSeq");
            q.g(s1, "title");
            GenreDetailLabelAlbumListFragment genreDetailLabelAlbumListFragment0 = new GenreDetailLabelAlbumListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argLabelSeq", s);
            bundle0.putString("argTitle", s1);
            genreDetailLabelAlbumListFragment0.setArguments(bundle0);
            return genreDetailLabelAlbumListFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0012\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelAlbumListFragment$GenreDetailLabelAlbumListAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/GenreLabelAlbumlistRes$RESPONSE$ALBUMLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelAlbumListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_ALBUM", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class GenreDetailLabelAlbumListAdapter extends p {
        private final int VIEW_TYPE_ALBUM;

        public GenreDetailLabelAlbumListAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreDetailLabelAlbumListFragment.this = genreDetailLabelAlbumListFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_ALBUM;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00 instanceof AlbumHolder) {
                GenreDetailLabelAlbumListFragment genreDetailLabelAlbumListFragment0 = GenreDetailLabelAlbumListFragment.this;
                Object object0 = this.getItem(v1);
                boolean z = ((ALBUMLIST)object0).canService;
                ViewUtils.setEnable(((AlbumHolder)o00).wrapperLayout, z);
                ViewUtils.setOnClickListener(((AlbumHolder)o00).btnPlayIv, new i(((ALBUMLIST)object0), genreDetailLabelAlbumListFragment0, v1, ((ALBUMLIST)object0), 1));
                if(z) {
                    e e0 = new e(4, ((ALBUMLIST)object0), genreDetailLabelAlbumListFragment0);
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, e0);
                }
                else {
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, null);
                }
                b b0 = new b(genreDetailLabelAlbumListFragment0, ((ALBUMLIST)object0), ((ALBUMLIST)object0), 1);
                ViewUtils.setOnLongClickListener(((AlbumHolder)o00).itemView, b0);
                ((AlbumHolder)o00).btnPlayIv.setImageResource((z ? 0x7F080309 : 0x7F0801F1));  // drawable:common_btn_play_01
                ImageView imageView0 = ((AlbumHolder)o00).thumbnailIv;
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(((ALBUMLIST)object0).albumImg).into(((AlbumHolder)o00).thumbnailIv);
                }
                ((AlbumHolder)o00).titleTv.setText(((ALBUMLIST)object0).albumName);
                ((AlbumHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((ALBUMLIST)object0).artistList));
                ((AlbumHolder)o00).issueTv.setText(((ALBUMLIST)object0).issueDate);
                ViewUtils.showWhen(((AlbumHolder)o00).ratingContainer, true);
                ((AlbumHolder)o00).ratingView.c(((ALBUMLIST)object0).totAvrgScore);
                ((AlbumHolder)o00).ratingText.setText(Float.toString(((ALBUMLIST)object0).totAvrgScore));
                ((AlbumHolder)o00).ratingUserCntTv.setText(StringUtils.getCountString(((ALBUMLIST)object0).ptcPnmPrco, 0x3B9AC9FF));
            }
        }

        private static final void onBindViewImpl$lambda$4$lambda$3$lambda$0(ALBUMLIST genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0, GenreDetailLabelAlbumListFragment genreDetailLabelAlbumListFragment0, int v, ALBUMLIST genreLabelAlbumlistRes$RESPONSE$ALBUMLIST1, View view0) {
            if(genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0.canService) {
                genreDetailLabelAlbumListFragment0.playAlbum(v);
                return;
            }
            genreDetailLabelAlbumListFragment0.showContextPopupAlbum(Playable.from(genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0, genreLabelAlbumlistRes$RESPONSE$ALBUMLIST1.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$4$lambda$3$lambda$1(ALBUMLIST genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0, GenreDetailLabelAlbumListFragment genreDetailLabelAlbumListFragment0, View view0) {
            if(!TextUtils.isEmpty(genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0.albumId)) {
                genreDetailLabelAlbumListFragment0.showAlbumInfoPage(genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0.albumId);
            }
        }

        private static final boolean onBindViewImpl$lambda$4$lambda$3$lambda$2(GenreDetailLabelAlbumListFragment genreDetailLabelAlbumListFragment0, ALBUMLIST genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0, ALBUMLIST genreLabelAlbumlistRes$RESPONSE$ALBUMLIST1, View view0) {
            genreDetailLabelAlbumListFragment0.showContextPopupAlbum(Playable.from(genreLabelAlbumlistRes$RESPONSE$ALBUMLIST0, genreLabelAlbumlistRes$RESPONSE$ALBUMLIST1.getMenuId(), null));
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false));  // layout:listitem_album
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_LABEL_SEQ;
    @NotNull
    private static final String ARG_TITLE;
    @NotNull
    public static final Companion Companion;
    private final int PAGE_SIZE;
    private final int START_INDEX;
    @NotNull
    private static final String TAG;
    private String labelSequence;
    @Nullable
    private TitleBar mTitleBarLayout;
    private String title;

    static {
        GenreDetailLabelAlbumListFragment.Companion = new Companion(null);
        GenreDetailLabelAlbumListFragment.$stable = 8;
        GenreDetailLabelAlbumListFragment.TAG = "GenreDetailLabelAlbumListFragment";
        GenreDetailLabelAlbumListFragment.ARG_LABEL_SEQ = "argLabelSeq";
        GenreDetailLabelAlbumListFragment.ARG_TITLE = "argTitle";
    }

    public GenreDetailLabelAlbumListFragment() {
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
    }

    public static final String access$getARG_LABEL_SEQ$cp() [...] // 潜在的解密器

    public static final String access$getARG_TITLE$cp() [...] // 潜在的解密器

    public final void buildTitleLayout() {
        View view0 = this.findViewById(0x7F0A0BAD);  // id:titlebar
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.title.TitleBar");
        this.mTitleBarLayout = (TitleBar)view0;
        ((TitleBar)view0).a(a.s(1));
        String s = this.title;
        if(s != null) {
            ((TitleBar)view0).setTitle(s);
            ((TitleBar)view0).f(true);
            return;
        }
        q.m("title");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new GenreDetailLabelAlbumListAdapter(this, context0, null);
        ((j)j00).setListContentType(2);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02E5, viewGroup0, false);  // layout:genre_label_albumlist
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s1 = this.labelSequence;
        if(s1 != null) {
            logU$Companion0.d("GenreDetailLabelAlbumListFragment", "onFetchStart() - labelSequence: " + s1);
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailLabelAlbumListFragment.GenreDetailLabelAlbumListAdapter");
            v9.i i1 = v9.i.b;
            if(i1.equals(i0)) {
                ((GenreDetailLabelAlbumListAdapter)j00).clear();
            }
            Params genreLabelAlbumlistReq$Params0 = new Params();
            String s2 = this.labelSequence;
            if(s2 != null) {
                genreLabelAlbumlistReq$Params0.labelSeq = s2;
                genreLabelAlbumlistReq$Params0.startIndex = i1.equals(i0) ? this.START_INDEX : ((GenreDetailLabelAlbumListAdapter)j00).getCount() + this.START_INDEX;
                genreLabelAlbumlistReq$Params0.pageSize = this.PAGE_SIZE;
                RequestBuilder.newInstance(new GenreLabelAlbumlistReq(this.getContext(), genreLabelAlbumlistReq$Params0)).tag("GenreDetailLabelAlbumListFragment").listener(new c(this, 1)).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            q.m("labelSequence");
            throw null;
        }
        q.m("labelSequence");
        throw null;
    }

    private static final void onFetchStart$lambda$1(GenreDetailLabelAlbumListFragment genreDetailLabelAlbumListFragment0, GenreLabelAlbumlistRes genreLabelAlbumlistRes0) {
        if(!genreDetailLabelAlbumListFragment0.prepareFetchComplete(genreLabelAlbumlistRes0)) {
            return;
        }
        genreDetailLabelAlbumListFragment0.performFetchComplete(genreLabelAlbumlistRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argLabelSeq");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.labelSequence = s;
        String s2 = bundle0.getString("argTitle");
        if(s2 != null) {
            s1 = s2;
        }
        this.title = s1;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = this.labelSequence;
        if(s != null) {
            bundle0.putString("argLabelSeq", s);
            String s1 = this.title;
            if(s1 != null) {
                bundle0.putString("argTitle", s1);
                return;
            }
            q.m("title");
            throw null;
        }
        q.m("labelSequence");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.buildTitleLayout();
    }
}

