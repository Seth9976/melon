package com.iloen.melon.fragments.detail;

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
import com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder.AlbumActionListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.AlbumContentsOtherVerReq.Params;
import com.iloen.melon.net.v6x.request.AlbumContentsOtherVerReq;
import com.iloen.melon.net.v6x.response.AlbumDetailContentsOtherVerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.AlbumDetailContentsOtherVerRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.AlbumInfoBase;
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

@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001.\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014¢\u0006\u0004\b\"\u0010#J-\u0010)\u001A\u00020\u00042\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\'\u001A\u0004\u0018\u00010&2\b\u0010(\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b)\u0010*R\u0016\u0010+\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010/\u001A\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001A\u0002018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/iloen/melon/fragments/detail/AlbumDetailContentsOtherVerFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "hasScrolledLine", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "albumId", "Ljava/lang/String;", "pageMetaName", "com/iloen/melon/fragments/detail/AlbumDetailContentsOtherVerFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/detail/AlbumDetailContentsOtherVerFragment$actionListener$1;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlbumDetailContentsOtherVerFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/detail/AlbumDetailContentsOtherVerFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/AlbumDetailContentsOtherVerFragment;", "albumId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AlbumDetailContentsOtherVerFragment newInstance(@Nullable String s) {
            AlbumDetailContentsOtherVerFragment albumDetailContentsOtherVerFragment0 = new AlbumDetailContentsOtherVerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argAlbumId", s);
            albumDetailContentsOtherVerFragment0.setArguments(bundle0);
            return albumDetailContentsOtherVerFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "AlbumDetailContentsOtherVerFragment";
    @NotNull
    private final com.iloen.melon.fragments.detail.AlbumDetailContentsOtherVerFragment.actionListener.1 actionListener;
    @NotNull
    private String albumId;
    @NotNull
    private String pageMetaName;

    static {
        AlbumDetailContentsOtherVerFragment.Companion = new Companion(null);
        AlbumDetailContentsOtherVerFragment.$stable = 8;
    }

    public AlbumDetailContentsOtherVerFragment() {
        this.albumId = "";
        this.pageMetaName = "";
        this.actionListener = new AlbumActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onClickAlbum(AlbumInfoBase albumInfoBase0, int v) {
                String s = albumInfoBase0 == null ? null : albumInfoBase0.albumId;
                if(s != null && s.length() != 0) {
                    AlbumDetailContentsOtherVerFragment.this.showAlbumInfoPage(s);
                    f f0 = AlbumDetailContentsOtherVerFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = AlbumDetailContentsOtherVerFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = AlbumDetailContentsOtherVerFragment.this.getString(0x7F130DD9);  // string:tiara_common_layer1_album_list "앨범리스트"
                    f0.C = String.valueOf(v + 1);
                    f0.e = albumInfoBase0.albumId;
                    f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                    f0.g = albumInfoBase0.albumName;
                    f0.h = ProtocolUtils.getArtistNames(albumInfoBase0.artistList);
                    f0.a().track();
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onLongClickAlbum(AlbumInfoBase albumInfoBase0, int v) {
                if(albumInfoBase0 == null) {
                    return;
                }
                Playable playable0 = Playable.from(albumInfoBase0, AlbumDetailContentsOtherVerFragment.this.getMenuId(), null);
                AlbumDetailContentsOtherVerFragment.access$showContextPopupAlbum(AlbumDetailContentsOtherVerFragment.this, playable0);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onPlayAlbum(AlbumInfoBase albumInfoBase0, int v) {
                if(albumInfoBase0 == null) {
                    return;
                }
                boolean z = albumInfoBase0.canService;
                Playable playable0 = Playable.from(albumInfoBase0, AlbumDetailContentsOtherVerFragment.this.getMenuId(), null);
                if(z) {
                    AlbumDetailContentsOtherVerFragment.this.playAlbum(playable0);
                    f f0 = AlbumDetailContentsOtherVerFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = AlbumDetailContentsOtherVerFragment.this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                    f0.d = ActionKind.PlayMusic;
                    f0.y = AlbumDetailContentsOtherVerFragment.this.getString(0x7F130DD9);  // string:tiara_common_layer1_album_list "앨범리스트"
                    f0.C = String.valueOf(v + 1);
                    f0.e = albumInfoBase0.albumId;
                    f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                    f0.g = albumInfoBase0.albumName;
                    f0.h = ProtocolUtils.getArtistNames(albumInfoBase0.artistList);
                    f0.a().track();
                    return;
                }
                AlbumDetailContentsOtherVerFragment.this.showContextPopupAlbum(playable0);
            }
        };
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new DetailContentsAlbumAdapter(context0, null, this.actionListener);
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.I = this.getMenuId();
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.albumId;
        f0.p = this.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
        f0.q = this.pageMetaName;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.a.buildUpon().appendPath("OTHER_VER"), this.albumId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
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
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsAlbumAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((DetailContentsAlbumAdapter)j00).clear();
        }
        Params albumContentsOtherVerReq$Params0 = new Params();
        albumContentsOtherVerReq$Params0.albumId = this.albumId;
        albumContentsOtherVerReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsAlbumAdapter)j00).getCount() + 1;
        albumContentsOtherVerReq$Params0.pageSize = 30;
        RequestBuilder.newInstance(new AlbumContentsOtherVerReq(this.getContext(), albumContentsOtherVerReq$Params0)).tag(this.getRequestTag()).listener(new a(3, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(AlbumDetailContentsOtherVerFragment albumDetailContentsOtherVerFragment0, i i0, AlbumDetailContentsOtherVerRes albumDetailContentsOtherVerRes0) {
        if(!albumDetailContentsOtherVerFragment0.prepareFetchComplete(albumDetailContentsOtherVerRes0)) {
            return;
        }
        RESPONSE albumDetailContentsOtherVerRes$RESPONSE0 = albumDetailContentsOtherVerRes0.response;
        albumDetailContentsOtherVerFragment0.mMelonTiaraProperty = new s(albumDetailContentsOtherVerRes$RESPONSE0.section, albumDetailContentsOtherVerRes$RESPONSE0.page, albumDetailContentsOtherVerRes$RESPONSE0.menuId, null);
        String s = albumDetailContentsOtherVerRes$RESPONSE0.pageMetaName;
        q.f(s, "pageMetaName");
        albumDetailContentsOtherVerFragment0.pageMetaName = s;
        albumDetailContentsOtherVerFragment0.performFetchComplete(i0, albumDetailContentsOtherVerRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.albumId = l1.g(bundle0, "inState", "argAlbumId", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argAlbumId", this.albumId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.a(B.a.s(1));
        titleBar0.setTitle(this.getString(0x7F130059));  // string:album_detail_contents_other_ver_title "이 앨범의 다른 버전"
    }
}

