package com.iloen.melon.fragments.newmusic;

import android.content.Context;
import android.os.Bundle;
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
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.NewMovieListReq.Params;
import com.iloen.melon.net.v4x.request.NewMovieListReq;
import com.iloen.melon.net.v4x.response.NewMovieListRes.RESPONSE.MVLIST;
import com.iloen.melon.net.v4x.response.NewMovieListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.viewholders.MvHolderDefaultImpl.OnClickListener;
import com.iloen.melon.viewholders.MvHolderDefaultImpl;
import com.kakao.tiara.data.ActionKind;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000BJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001A\u001A\u00020\u00192\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u001A\u0010\u001BJ\u001B\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0014¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/newmusic/NewMvFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Companion", "NewMusicVideoAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NewMvFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/newmusic/NewMvFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/newmusic/NewMvFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final NewMvFragment newInstance() {
            return new NewMvFragment();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0012\u001A\u0004\u0018\u00010\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/newmusic/NewMvFragment$NewMusicVideoAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/NewMovieListRes$RESPONSE$MVLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/newmusic/NewMvFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_MV", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class NewMusicVideoAdapter extends p {
        private final int VIEW_TYPE_MV;

        public NewMusicVideoAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            NewMvFragment.this = newMvFragment0;
            super(context0, list0);
            this.VIEW_TYPE_MV = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_MV;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == this.VIEW_TYPE_MV) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.NewMovieListRes.RESPONSE.MVLIST");
                ((MvHolderDefaultImpl)o00).bindView(((MVLIST)object0), false, this.getMenuId(), v1);
                ((MvHolderDefaultImpl)o00).setOnClickListener(new OnClickListener() {
                    @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                    public void playMusicVideo(int v) {
                        ((MVLIST)object0).playMv(v);
                        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                        g0.I = ((MVLIST)object0).mMelonTiaraProperty.c;
                        g0.d = ActionKind.PlayVideo;
                        g0.a = "영상재생";
                        g0.b = ((MVLIST)object0).mMelonTiaraProperty.a;
                        g0.c = ((MVLIST)object0).mMelonTiaraProperty.b;
                        g0.y = "영상리스트";
                        g0.z = "영상재생";
                        g0.C = String.valueOf(v + 1);
                        g0.E = v1.mvImg;
                        g0.e = v1.mvId;
                        g0.f = "영상";
                        g0.g = v1.mvName;
                        g0.h = ProtocolUtils.getArtistNames(v1.artistList);
                        g0.a().track();
                    }

                    @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                    public void showContextPopup(Playable playable0) {
                        q.g(playable0, "playable");
                        ((MVLIST)object0).showContextPopupMv(playable0);
                        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                        g0.I = ((MVLIST)object0).mMelonTiaraProperty.c;
                        g0.d = ActionKind.ClickContent;
                        g0.a = "페이지이동";
                        g0.b = ((MVLIST)object0).mMelonTiaraProperty.a;
                        g0.c = ((MVLIST)object0).mMelonTiaraProperty.b;
                        g0.y = "영상리스트";
                        g0.z = "더보기";
                        g0.C = String.valueOf(this.$position + 1);
                        g0.E = v1.mvImg;
                        g0.e = v1.mvId;
                        g0.f = "영상";
                        g0.g = v1.mvName;
                        g0.h = ProtocolUtils.getArtistNames(v1.artistList);
                        g0.a().track();
                    }
                });
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            return v == this.VIEW_TYPE_MV ? new MvHolderDefaultImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D04BB, viewGroup0, false)) : null;  // layout:listitem_video
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "NewMvFragment";

    static {
        NewMvFragment.Companion = new Companion(null);
        NewMvFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new NewMusicVideoAdapter(this, context0, null);
        ((j)j00).setListContentType(3);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.m0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0574, viewGroup0, false);  // layout:new_music_video
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.newmusic.NewMvFragment.NewMusicVideoAdapter");
        Params newMovieListReq$Params0 = new Params();
        newMovieListReq$Params0.startIndex = i.b.equals(i0) ? 1 : ((NewMusicVideoAdapter)j00).getCount() + 1;
        newMovieListReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new NewMovieListReq(this.getContext(), newMovieListReq$Params0)).tag("NewMvFragment").listener(new b(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$0(NewMvFragment newMvFragment0, i i0, NewMovieListRes newMovieListRes0) {
        if(!newMvFragment0.prepareFetchComplete(newMovieListRes0)) {
            return;
        }
        newMvFragment0.mMelonTiaraProperty = new s(newMovieListRes0.response.section, newMovieListRes0.response.page, "", null);
        newMvFragment0.performFetchComplete(i0, newMovieListRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }
}

