package com.iloen.melon.fragments.genre;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.GenreLabelIntroReq;
import com.iloen.melon.net.v5x.response.GenreLabelIntroRes.RESPONSE.INTRO;
import com.iloen.melon.net.v5x.response.GenreLabelIntroRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreLabelIntroRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 /2\u00020\u0001:\u0003/01B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\bH\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\bH\u0016¢\u0006\u0004\b\u001E\u0010\u001CJ\u000F\u0010\u001F\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001F\u0010 J\u001D\u0010$\u001A\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b$\u0010%J\u0011\u0010\'\u001A\u0004\u0018\u00010&H\u0014¢\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u000EH\u0004¢\u0006\u0004\b)\u0010\u0003R\u0016\u0010*\u001A\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001A\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelIntroFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "shouldShowMiniPlayer", "()Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "buildTitleLayout", "labelSeq", "Ljava/lang/String;", "Lcom/iloen/melon/custom/title/TitleBar;", "mTitleBarLayout", "Lcom/iloen/melon/custom/title/TitleBar;", "Companion", "GenreLabelIntroAdapter", "IntroItemHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreDetailLabelIntroFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelIntroFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_LABEL_SEQ", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailLabelIntroFragment;", "labelSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailLabelIntroFragment newInstance(@NotNull String s) {
            q.g(s, "labelSeq");
            GenreDetailLabelIntroFragment genreDetailLabelIntroFragment0 = new GenreDetailLabelIntroFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argLabelSeq", s);
            genreDetailLabelIntroFragment0.setArguments(bundle0);
            return genreDetailLabelIntroFragment0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelIntroFragment$GenreLabelIntroAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/GenreLabelIntroRes$RESPONSE$INTRO;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelIntroFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_INTRO", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class GenreLabelIntroAdapter extends p {
        private final int VIEW_TYPE_INTRO;

        public GenreLabelIntroAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreDetailLabelIntroFragment.this = genreDetailLabelIntroFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_INTRO;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 == null) {
                return false;
            }
            this.setMenuId(httpResponse0.getMenuId());
            ResponseBase responseBase0 = httpResponse0.getResponse();
            q.e(responseBase0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.GenreLabelIntroRes.RESPONSE");
            this.add(((RESPONSE)responseBase0).intro);
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00 instanceof IntroItemHolder) {
                INTRO genreLabelIntroRes$RESPONSE$INTRO0 = (INTRO)this.getItem(v1);
                ViewUtils.setText(((IntroItemHolder)o00).getTvTitle(), genreLabelIntroRes$RESPONSE$INTRO0.title);
                ViewUtils.setText(((IntroItemHolder)o00).getTvSubTitle(), genreLabelIntroRes$RESPONSE$INTRO0.subTitle);
                ViewUtils.setText(((IntroItemHolder)o00).getTvDesc(), genreLabelIntroRes$RESPONSE$INTRO0.desc);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D02E9, viewGroup0, false);  // layout:genre_label_intro_item
            q.f(view0, "inflate(...)");
            return new IntroItemHolder(GenreDetailLabelIntroFragment.this, view0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\f\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001A\u0004\b\r\u0010\u000BR\u001F\u0010\u000E\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\u000E\u0010\t\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelIntroFragment$IntroItemHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelIntroFragment;Landroid/view/View;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvSubTitle", "getTvSubTitle", "tvDesc", "getTvDesc", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class IntroItemHolder extends O0 {
        private final TextView tvDesc;
        private final TextView tvSubTitle;
        private final TextView tvTitle;

        public IntroItemHolder(@NotNull View view0) {
            q.g(view0, "view");
            GenreDetailLabelIntroFragment.this = genreDetailLabelIntroFragment0;
            super(view0);
            this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.tvSubTitle = (TextView)view0.findViewById(0x7F0A0D1E);  // id:tv_sub_title
            this.tvDesc = (TextView)view0.findViewById(0x7F0A0C5E);  // id:tv_desc
        }

        public final TextView getTvDesc() {
            return this.tvDesc;
        }

        public final TextView getTvSubTitle() {
            return this.tvSubTitle;
        }

        public final TextView getTvTitle() {
            return this.tvTitle;
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_LABEL_SEQ;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    private String labelSeq;
    @Nullable
    private TitleBar mTitleBarLayout;

    static {
        GenreDetailLabelIntroFragment.Companion = new Companion(null);
        GenreDetailLabelIntroFragment.$stable = 8;
        GenreDetailLabelIntroFragment.TAG = "GenreDetailLabelIntroFragment";
        GenreDetailLabelIntroFragment.ARG_LABEL_SEQ = "argLabelSeq";
    }

    public static final String access$getARG_LABEL_SEQ$cp() [...] // 潜在的解密器

    public final void buildTitleLayout() {
        View view0 = this.findViewById(0x7F0A0BAD);  // id:titlebar
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.title.TitleBar");
        this.mTitleBarLayout = (TitleBar)view0;
        ((TitleBar)view0).a(a.s(1));
        ((TitleBar)view0).setTitle(this.getString(0x7F13047B));  // string:genre_label_intro_title "레이블 소개"
        ((TitleBar)view0).f(true);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new GenreLabelIntroAdapter(this, context0, null);
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
        return layoutInflater0.inflate(0x7F0D02EA, viewGroup0, false);  // layout:genre_label_introduce
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s1 = this.labelSeq;
        if(s1 != null) {
            logU$Companion0.d("GenreDetailLabelIntroFragment", "onFetchStart() - labelSeq: " + s1);
            Context context0 = this.getContext();
            String s2 = this.labelSeq;
            if(s2 != null) {
                RequestBuilder.newInstance(new GenreLabelIntroReq(context0, s2)).tag("GenreDetailLabelIntroFragment").listener(new c(this, 4)).errorListener(this.mResponseErrorListener).request();
                return true;
            }
            q.m("labelSeq");
            throw null;
        }
        q.m("labelSeq");
        throw null;
    }

    private static final void onFetchStart$lambda$0(GenreDetailLabelIntroFragment genreDetailLabelIntroFragment0, GenreLabelIntroRes genreLabelIntroRes0) {
        if(!genreDetailLabelIntroFragment0.prepareFetchComplete(genreLabelIntroRes0)) {
            return;
        }
        genreDetailLabelIntroFragment0.performFetchComplete(genreLabelIntroRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argLabelSeq");
        if(s == null) {
            s = "";
        }
        this.labelSeq = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = this.labelSeq;
        if(s != null) {
            bundle0.putString("argLabelSeq", s);
            return;
        }
        q.m("labelSeq");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.buildTitleLayout();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

