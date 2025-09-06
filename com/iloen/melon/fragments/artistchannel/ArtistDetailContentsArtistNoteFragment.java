package com.iloen.melon.fragments.artistchannel;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DetailContentsArtistNoteAdapter;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsArtistNoteHolder.ArtistNoteActionListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ARTISTNOTE;
import com.iloen.melon.net.v6x.request.ArtistContentsArtistNoteListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsArtistNoteListReq;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsArtistNoteRes;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0005*\u0001.\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014¢\u0006\u0004\b\"\u0010#J-\u0010)\u001A\u00020\u00042\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\'\u001A\u0004\u0018\u00010&2\b\u0010(\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b)\u0010*R\u0016\u0010+\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010/\u001A\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsArtistNoteFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "hasScrolledLine", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "artistId", "Ljava/lang/String;", "artistName", "com/iloen/melon/fragments/artistchannel/ArtistDetailContentsArtistNoteFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsArtistNoteFragment$actionListener$1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailContentsArtistNoteFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00052\b\u0010\t\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsArtistNoteFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsArtistNoteFragment;", "artistId", "artistName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailContentsArtistNoteFragment newInstance(@Nullable String s, @Nullable String s1) {
            ArtistDetailContentsArtistNoteFragment artistDetailContentsArtistNoteFragment0 = new ArtistDetailContentsArtistNoteFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            bundle0.putString("argArtistName", s1);
            artistDetailContentsArtistNoteFragment0.setArguments(bundle0);
            return artistDetailContentsArtistNoteFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistDetailContentsArtistNoteFragment";
    @NotNull
    private final com.iloen.melon.fragments.artistchannel.ArtistDetailContentsArtistNoteFragment.actionListener.1 actionListener;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;

    static {
        ArtistDetailContentsArtistNoteFragment.Companion = new Companion(null);
        ArtistDetailContentsArtistNoteFragment.$stable = 8;
    }

    public ArtistDetailContentsArtistNoteFragment() {
        this.artistId = "";
        this.artistName = "";
        this.actionListener = new ArtistNoteActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsArtistNoteHolder$ArtistNoteActionListener
            public void onClickItem(ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v) {
                q.g(detailBaseRes$ARTISTNOTE0, "item");
                ArtistDetailContentsArtistNoteFragment.this.showAlbumInfoPage(detailBaseRes$ARTISTNOTE0.albumId);
                String s = ProtocolUtils.getArtistNames(detailBaseRes$ARTISTNOTE0.artistList);
                if(s == null || s.length() == 0) {
                    s = ArtistDetailContentsArtistNoteFragment.this.artistName;
                }
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = ArtistDetailContentsArtistNoteFragment.this.getMenuId();
                g0.a = ArtistDetailContentsArtistNoteFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                g0.b = ArtistDetailContentsArtistNoteFragment.this.mMelonTiaraProperty.a;
                g0.c = ArtistDetailContentsArtistNoteFragment.this.mMelonTiaraProperty.b;
                g0.d = ActionKind.ClickContent;
                g0.y = ArtistDetailContentsArtistNoteFragment.this.getString(0x7F130DE5);  // string:tiara_common_layer1_artist_note_list "아티스트노트리스트"
                g0.C = String.valueOf(v + 1);
                g0.e = detailBaseRes$ARTISTNOTE0.albumId;
                g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                g0.g = detailBaseRes$ARTISTNOTE0.albumName;
                g0.h = s;
                g0.o = ArtistDetailContentsArtistNoteFragment.this.artistId;
                g0.p = ArtistDetailContentsArtistNoteFragment.this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                g0.q = ArtistDetailContentsArtistNoteFragment.this.artistName;
                g0.a().track();
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsArtistNoteHolder$ArtistNoteActionListener
            public void onPlayItem(ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v) {
                q.g(detailBaseRes$ARTISTNOTE0, "item");
                String s = detailBaseRes$ARTISTNOTE0.albumId;
                String s1 = ArtistDetailContentsArtistNoteFragment.this.getMenuId();
                ArtistDetailContentsArtistNoteFragment.this.playAlbum(s, s1);
                String s2 = ProtocolUtils.getArtistNames(detailBaseRes$ARTISTNOTE0.artistList);
                if(s2 == null || s2.length() == 0) {
                    s2 = ArtistDetailContentsArtistNoteFragment.this.artistName;
                }
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = ArtistDetailContentsArtistNoteFragment.this.getMenuId();
                g0.a = ArtistDetailContentsArtistNoteFragment.this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                g0.b = ArtistDetailContentsArtistNoteFragment.this.mMelonTiaraProperty.a;
                g0.c = ArtistDetailContentsArtistNoteFragment.this.mMelonTiaraProperty.b;
                g0.d = ActionKind.PlayMusic;
                g0.y = ArtistDetailContentsArtistNoteFragment.this.getString(0x7F130DE5);  // string:tiara_common_layer1_artist_note_list "아티스트노트리스트"
                g0.C = String.valueOf(v + 1);
                g0.e = detailBaseRes$ARTISTNOTE0.albumId;
                g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                g0.g = detailBaseRes$ARTISTNOTE0.albumName;
                g0.h = s2;
                g0.o = ArtistDetailContentsArtistNoteFragment.this.artistId;
                g0.p = ArtistDetailContentsArtistNoteFragment.this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                g0.q = ArtistDetailContentsArtistNoteFragment.this.artistName;
                g0.a().track();
            }
        };
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new DetailContentsArtistNoteAdapter(context0, null, this.actionListener);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.b.buildUpon().appendPath("ARTIST_NOTE"), this.artistId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ArtistDetailContentsArtistNoteFragment newInstance(@Nullable String s, @Nullable String s1) {
        return ArtistDetailContentsArtistNoteFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        int v = ScreenUtils.dipToPixel(((RecyclerView)view0).getContext(), 16.0f);
        ((RecyclerView)view0).setPadding(((RecyclerView)view0).getPaddingLeft(), v, ((RecyclerView)view0).getPaddingRight(), ((RecyclerView)view0).getPaddingBottom());
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0206, viewGroup0, false);  // layout:detail_contents_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsArtistNoteAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((DetailContentsArtistNoteAdapter)j00).clear();
        }
        Params artistContentsArtistNoteListReq$Params0 = new Params();
        artistContentsArtistNoteListReq$Params0.artistId = this.artistId;
        artistContentsArtistNoteListReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsArtistNoteAdapter)j00).getCount() + 1;
        artistContentsArtistNoteListReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new ArtistContentsArtistNoteListReq(this.getContext(), artistContentsArtistNoteListReq$Params0)).tag(this.getRequestTag()).listener(new c(5, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(ArtistDetailContentsArtistNoteFragment artistDetailContentsArtistNoteFragment0, i i0, ArtistDetailContentsArtistNoteRes artistDetailContentsArtistNoteRes0) {
        if(!artistDetailContentsArtistNoteFragment0.prepareFetchComplete(artistDetailContentsArtistNoteRes0)) {
            return;
        }
        artistDetailContentsArtistNoteFragment0.mMelonTiaraProperty = new s(artistDetailContentsArtistNoteRes0.response.section, artistDetailContentsArtistNoteRes0.response.page, artistDetailContentsArtistNoteRes0.getMenuId(), null);
        artistDetailContentsArtistNoteFragment0.performFetchComplete(i0, artistDetailContentsArtistNoteRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.artistId = l1.g(bundle0, "inState", "argArtistId", "", "getString(...)");
        String s = bundle0.getString("argArtistName", "");
        q.f(s, "getString(...)");
        this.artistName = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argArtistName", this.artistName);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getString(0x7F130128));  // string:artist_detail_contents_artist_note_title "아티스트 노트"
        }
    }
}

