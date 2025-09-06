package com.iloen.melon.fragments.genre;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import java.util.List;
import java.util.regex.Pattern;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ-\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001AH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014¢\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0014¢\u0006\u0004\b%\u0010&R\u0016\u0010\'\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistPopupFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "mDesc", "Ljava/lang/String;", "Companion", "GenreArtistPopupAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreArtistPopupFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistPopupFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_DESC", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreArtistPopupFragment;", "title", "desc", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreArtistPopupFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "title");
            q.g(s1, "desc");
            GenreArtistPopupFragment genreArtistPopupFragment0 = new GenreArtistPopupFragment();
            Bundle bundle0 = Y.b("argFragmentTitle", s);
            bundle0.putString("argDesc", s1);
            genreArtistPopupFragment0.setArguments(bundle0);
            return genreArtistPopupFragment0;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001EB\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u0013\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistPopupFragment$GenreArtistPopupAdapter;", "Lcom/iloen/melon/adapters/common/y;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreArtistPopupFragment;Landroid/content/Context;Ljava/util/List;)V", "", "desc", "Lie/H;", "setDesc", "(Ljava/lang/String;)V", "viewHolder", "", "rawPosition", "position", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "getCount", "()I", "mDesc", "Ljava/lang/String;", "ArtistPopupHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class GenreArtistPopupAdapter extends y {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistPopupFragment$GenreArtistPopupAdapter$ArtistPopupHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreArtistPopupFragment$GenreArtistPopupAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ArtistPopupHolder extends O0 {
            @NotNull
            private final TextView descTv;

            public ArtistPopupHolder(@NotNull View view0) {
                q.g(view0, "view");
                GenreArtistPopupAdapter.this = genreArtistPopupFragment$GenreArtistPopupAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view1, "findViewById(...)");
                this.descTv = (TextView)view1;
            }

            @NotNull
            public final TextView getDescTv() {
                return this.descTv;
            }
        }

        @NotNull
        private String mDesc;

        public GenreArtistPopupAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreArtistPopupFragment.this = genreArtistPopupFragment0;
            super(context0, list0);
            this.mDesc = "";
        }

        @Override  // com.iloen.melon.adapters.common.y
        public int getCount() {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            TextView textView0 = ((ArtistPopupHolder)o00).getDescTv();
            String s = this.mDesc;
            Pattern pattern0 = Pattern.compile("\n");
            q.f(pattern0, "compile(...)");
            q.g(s, "input");
            String s1 = pattern0.matcher(s).replaceAll("<br>");
            q.f(s1, "replaceAll(...)");
            textView0.setText(Html.fromHtml(s1, 0));
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D02DF, viewGroup0, false);  // layout:genre_artist_popup_listitem
            q.f(view0, "inflate(...)");
            return new ArtistPopupHolder(this, view0);
        }

        public final void setDesc(@NotNull String s) {
            q.g(s, "desc");
            this.mDesc = s;
            this.notifyDataSetChanged();
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_DESC;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    @NotNull
    private String mDesc;

    static {
        GenreArtistPopupFragment.Companion = new Companion(null);
        GenreArtistPopupFragment.$stable = 8;
        GenreArtistPopupFragment.TAG = "GenreArtistPopupFragment";
        GenreArtistPopupFragment.ARG_DESC = "argDesc";
    }

    public GenreArtistPopupFragment() {
        this.mDesc = "";
    }

    public static final String access$getARG_DESC$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new GenreArtistPopupAdapter(this, context0, null);
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
        return layoutInflater0.inflate(0x7F0D02DE, viewGroup0, false);  // layout:genre_artist_popup
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.mTitle = bundle0.getString("argFragmentTitle");
        String s = bundle0.getString("argDesc");
        if(s == null) {
            s = "";
        }
        this.mDesc = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argFragmentTitle", this.mTitle);
        bundle0.putString("argDesc", this.mDesc);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.a(a.s(1));
        titleBar0.setTitle(this.mTitle);
        titleBar0.f(true);
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreArtistPopupFragment.GenreArtistPopupAdapter");
        String s = this.mDesc;
        int v = s.length() - 1;
        int v1 = 0;
        boolean z = false;
        while(v1 <= v) {
            boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
            if(z) {
                if(!z1) {
                    break;
                }
                --v;
            }
            else if(z1) {
                ++v1;
            }
            else {
                z = true;
            }
        }
        ((GenreArtistPopupAdapter)j00).setDesc(s.subSequence(v1, v + 1).toString());
    }
}

