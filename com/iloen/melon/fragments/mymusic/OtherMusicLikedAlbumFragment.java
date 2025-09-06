package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DetailContentsAlbumAdapter;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder.AlbumActionListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.LikeListAlbumBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeListAlbumReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListAlbumRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeListAlbumRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ui.ViewUtils;
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

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00013\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0012J-\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0019\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010\u001E\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u001A2\b\u0010\u0019\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ-\u0010&\u001A\u00020%2\b\u0010!\u001A\u0004\u0018\u00010 2\b\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010$\u001A\u0004\u0018\u00010\fH\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*J\u001B\u0010.\u001A\u0006\u0012\u0002\b\u00030-2\u0006\u0010,\u001A\u00020+H\u0014\u00A2\u0006\u0004\b.\u0010/R\u0016\u00100\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00101R\u0014\u00104\u001A\u0002038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001A\u0002068BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b7\u00108\u00A8\u0006;"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedAlbumFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lcom/melon/net/res/common/AlbumInfoBase;", "data", "", "position", "Lie/H;", "tiaraLogOpenAlbumDetail", "(Lcom/melon/net/res/common/AlbumInfoBase;I)V", "tiaraLogPlayAlbum", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "memberKey", "Ljava/lang/String;", "filterType", "com/iloen/melon/fragments/mymusic/OtherMusicLikedAlbumFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedAlbumFragment$actionListener$1;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OtherMusicLikedAlbumFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedAlbumFragment$Companion;", "", "<init>", "()V", "TAG", "", "START_INDEX", "", "PAGE_SIZE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedAlbumFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OtherMusicLikedAlbumFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            OtherMusicLikedAlbumFragment otherMusicLikedAlbumFragment0 = new OtherMusicLikedAlbumFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            otherMusicLikedAlbumFragment0.setArguments(bundle0);
            return otherMusicLikedAlbumFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int PAGE_SIZE = 100;
    private static final int START_INDEX = 1;
    @NotNull
    private static final String TAG = "OtherMusicLikedAlbumFragment";
    @NotNull
    private final com.iloen.melon.fragments.mymusic.OtherMusicLikedAlbumFragment.actionListener.1 actionListener;
    @NotNull
    private String filterType;
    @NotNull
    private String memberKey;

    static {
        OtherMusicLikedAlbumFragment.Companion = new Companion(null);
        OtherMusicLikedAlbumFragment.$stable = 8;
    }

    public OtherMusicLikedAlbumFragment() {
        this.memberKey = "";
        this.filterType = "NEW";
        this.actionListener = new AlbumActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onClickAlbum(AlbumInfoBase albumInfoBase0, int v) {
                if(albumInfoBase0 == null) {
                    return;
                }
                if(albumInfoBase0.albumId != null && albumInfoBase0.albumId.length() != 0) {
                    Playable playable0 = Playable.from(albumInfoBase0, OtherMusicLikedAlbumFragment.this.getMenuId(), null);
                    OtherMusicLikedAlbumFragment.this.showAlbumInfoPage(playable0);
                    OtherMusicLikedAlbumFragment.access$tiaraLogOpenAlbumDetail(OtherMusicLikedAlbumFragment.this, albumInfoBase0, v);
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onLongClickAlbum(AlbumInfoBase albumInfoBase0, int v) {
                Playable playable0 = Playable.from(albumInfoBase0, OtherMusicLikedAlbumFragment.this.getMenuId(), null);
                OtherMusicLikedAlbumFragment.access$showContextPopupAlbum(OtherMusicLikedAlbumFragment.this, playable0);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onPlayAlbum(AlbumInfoBase albumInfoBase0, int v) {
                if(albumInfoBase0 == null) {
                    return;
                }
                if(albumInfoBase0.canService) {
                    OtherMusicLikedAlbumFragment.access$playAlbum(OtherMusicLikedAlbumFragment.this, v);
                    OtherMusicLikedAlbumFragment.access$tiaraLogPlayAlbum(OtherMusicLikedAlbumFragment.this, albumInfoBase0, v);
                    return;
                }
                Playable playable0 = Playable.from(albumInfoBase0, OtherMusicLikedAlbumFragment.this.getMenuId(), null);
                OtherMusicLikedAlbumFragment.access$showContextPopupAlbum(OtherMusicLikedAlbumFragment.this, playable0);
            }
        };
    }

    public static final void access$playAlbum(OtherMusicLikedAlbumFragment otherMusicLikedAlbumFragment0, int v) {
        otherMusicLikedAlbumFragment0.playAlbum(v);
    }

    public static final void access$showContextPopupAlbum(OtherMusicLikedAlbumFragment otherMusicLikedAlbumFragment0, Playable playable0) {
        otherMusicLikedAlbumFragment0.showContextPopupAlbum(playable0);
    }

    public static final void access$tiaraLogOpenAlbumDetail(OtherMusicLikedAlbumFragment otherMusicLikedAlbumFragment0, AlbumInfoBase albumInfoBase0, int v) {
        otherMusicLikedAlbumFragment0.tiaraLogOpenAlbumDetail(albumInfoBase0, v);
    }

    public static final void access$tiaraLogPlayAlbum(OtherMusicLikedAlbumFragment otherMusicLikedAlbumFragment0, AlbumInfoBase albumInfoBase0, int v) {
        otherMusicLikedAlbumFragment0.tiaraLogPlayAlbum(albumInfoBase0, v);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new DetailContentsAlbumAdapter(context0, null, this.actionListener);
        ((j)j00).setListContentType(2);
        return j00;
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s0 = this.mMelonTiaraProperty;
        String s1 = null;
        f0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        f0.c = s1;
        f0.I = this.getMenuId();
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("album"), "targetMemberKey", this.memberKey, "toString(...)");
    }

    @NotNull
    public static final OtherMusicLikedAlbumFragment newInstance(@NotNull String s) {
        return OtherMusicLikedAlbumFragment.Companion.newInstance(s);
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
        return layoutInflater0.inflate(0x7F0D058E, viewGroup0, false);  // layout:othermusic_more
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsAlbumAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((DetailContentsAlbumAdapter)j00).clear();
        }
        Params likeListAlbumBaseReq$Params0 = new Params();
        likeListAlbumBaseReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsAlbumAdapter)j00).getCount() + 1;
        likeListAlbumBaseReq$Params0.pageSize = 100;
        likeListAlbumBaseReq$Params0.orderBy = this.filterType;
        likeListAlbumBaseReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListAlbumReq(this.getContext(), likeListAlbumBaseReq$Params0)).tag("OtherMusicLikedAlbumFragment").listener(new com.iloen.melon.fragments.mymusic.g(this, i0, 22)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(OtherMusicLikedAlbumFragment otherMusicLikedAlbumFragment0, i i0, MyMusicLikeListAlbumRes myMusicLikeListAlbumRes0) {
        if(!otherMusicLikedAlbumFragment0.prepareFetchComplete(myMusicLikeListAlbumRes0)) {
            return;
        }
        RESPONSE myMusicLikeListAlbumRes$RESPONSE0 = myMusicLikeListAlbumRes0 == null ? null : myMusicLikeListAlbumRes0.response;
        if(myMusicLikeListAlbumRes$RESPONSE0 != null) {
            otherMusicLikedAlbumFragment0.mMelonTiaraProperty = new s(myMusicLikeListAlbumRes$RESPONSE0.section, myMusicLikeListAlbumRes$RESPONSE0.page, myMusicLikeListAlbumRes$RESPONSE0.menuId, null);
        }
        otherMusicLikedAlbumFragment0.performFetchComplete(i0, myMusicLikeListAlbumRes0);
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

    private final void tiaraLogOpenAlbumDetail(AlbumInfoBase albumInfoBase0, int v) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = albumInfoBase0.albumId;
        f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
        f0.g = albumInfoBase0.albumName;
        f0.a().track();
    }

    private final void tiaraLogPlayAlbum(AlbumInfoBase albumInfoBase0, int v) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = albumInfoBase0.albumId;
        f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
        f0.g = albumInfoBase0.albumName;
        f0.a().track();
    }
}

