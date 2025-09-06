package com.iloen.melon.fragments.newmusic;

import C8.b;
import De.I;
import K.m;
import Q0.k0;
import X0.i;
import X0.u;
import X0.x;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.analytics.ClickLog;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.NewAlbumListReq.Params;
import com.iloen.melon.net.v4x.request.NewAlbumListReq;
import com.iloen.melon.net.v4x.response.NewAlbumListRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v4x.response.NewAlbumListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.NewAlbumListRes;
import com.iloen.melon.net.v5x.request.NewMusicAlbumMyListReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import com.kakao.tiara.data.ActionKind;
import d5.s;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import r0.n;
import va.e0;
import we.o;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\n\u0010\u0007\u001A\u00060\u0006R\u00020\u0000H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ#\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\n\u0010\u0007\u001A\u00060\u0006R\u00020\u0000H\u0002\u00A2\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0012J-\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0019\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ+\u0010!\u001A\u00020 2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\fH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*R\"\u0010,\u001A\u00020+8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\u001A\u00104\u001A\b\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00105R\u001A\u00106\u001A\b\u0012\u0004\u0012\u00020 028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00105R\"\u00107\u001A\u00020 8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b7\u00108\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010>\u001A\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001A\u00020 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u00108R\u0016\u0010A\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010B\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lv9/i;", "type", "Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment$NewAlbumAdapter;", "adapter", "Lie/H;", "requestMyList", "(Lv9/i;Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment$NewAlbumAdapter;)V", "request", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lmb/k;", "loginUseCase", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "setLoginUseCase", "(Lmb/k;)V", "Landroidx/compose/runtime/b0;", "", "currentSortIndex", "Landroidx/compose/runtime/b0;", "isVisibleRefresh", "mIsSortBarVisible", "Z", "getMIsSortBarVisible", "()Z", "setMIsSortBarVisible", "(Z)V", "Lcom/iloen/melon/net/v4x/response/NewAlbumListRes;", "myListResponse", "Lcom/iloen/melon/net/v4x/response/NewAlbumListRes;", "isMyListAdded", "exAlbumId", "Ljava/lang/String;", "Companion", "NewAlbumAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NewAlbumFragment extends Hilt_NewAlbumFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SORT_TYPE", "SORT_ALL", "", "SORT_DOMESTIC", "SORT_OVERSEAS", "newInstance", "Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment;", "sortType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final NewAlbumFragment newInstance() {
            return this.newInstance(0);
        }

        @NotNull
        public final NewAlbumFragment newInstance(int v) {
            NewAlbumFragment newAlbumFragment0 = new NewAlbumFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argSortType", v);
            newAlbumFragment0.setArguments(bundle0);
            return newAlbumFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001DB\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J#\u0010\u0014\u001A\u0004\u0018\u00010\u00032\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001C\u0010\u001B¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment$NewAlbumAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/NewAlbumListRes$RESPONSE$ALBUMLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_ALBUM", "HeaderHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class NewAlbumAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment$NewAlbumAdapter$HeaderHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/newmusic/NewAlbumFragment$NewAlbumAdapter;Landroid/view/View;)V", "Landroidx/compose/ui/platform/ComposeView;", "filterLayoutComposeView", "Landroidx/compose/ui/platform/ComposeView;", "getFilterLayoutComposeView", "()Landroidx/compose/ui/platform/ComposeView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HeaderHolder extends O0 {
            @NotNull
            private final ComposeView filterLayoutComposeView;

            public HeaderHolder(@NotNull View view0) {
                q.g(view0, "view");
                NewAlbumAdapter.this = newAlbumFragment$NewAlbumAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A049F);  // id:filter_layout_compose
                q.f(view1, "findViewById(...)");
                this.filterLayoutComposeView = (ComposeView)view1;
            }

            @NotNull
            public final ComposeView getFilterLayoutComposeView() {
                return this.filterLayoutComposeView;
            }
        }

        private final int VIEW_TYPE_ALBUM;
        private final int VIEW_TYPE_HEADER;

        public NewAlbumAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            NewAlbumFragment.this = newAlbumFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ALBUM = 1;
        }

        // 检测为 Lambda 实现
        public static H b(NewAlbumFragment newAlbumFragment0, l l0, int v) [...]

        // 检测为 Lambda 实现
        public static H d(NewAlbumFragment newAlbumFragment0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, l l0, int v) [...]

        // 检测为 Lambda 实现
        public static H g(NewAlbumFragment newAlbumFragment0, int v) [...]

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return NewAlbumFragment.this.getMIsSortBarVisible();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_ALBUM : this.VIEW_TYPE_HEADER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_HEADER) {
                b b0 = new b(19.0f, 19.0f, 4);
                b0.e = new m0.b(0x8830F10D, (l l0, int v) -> NewAlbumAdapter.onBindViewImpl$lambda$2(NewAlbumFragment.this, l0, v), true);
                b0.f = new m0.b(-1775533490, (l l0, int v) -> NewAlbumAdapter.onBindViewImpl$lambda$6(NewAlbumFragment.this, this, l0, v), true);
                ((HeaderHolder)o00).getFilterLayoutComposeView().setContent(b0.a());
                return;
            }
            if(v2 == this.VIEW_TYPE_ALBUM) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.NewAlbumListRes.RESPONSE.ALBUMLIST");
                boolean z = ((ALBUMLIST)object0).canService;
                ViewUtils.setEnable(((AlbumHolder)o00).wrapperLayout, z);
                ViewUtils.setOnClickListener(((AlbumHolder)o00).btnPlayIv, (View view0) -> {
                    if(z) {
                        String s = this.getMenuId();
                        String s1 = ((ALBUMLIST)object0).albumId;
                        s s2 = new s();
                        s2.b = "3";
                        s2.c = s;
                        s2.e = "D23";
                        s2.h = "P2";
                        s2.j = "N10002";
                        s2.k = s1;
                        new ClickLog(s2).a();
                        NewAlbumFragment.this.playAlbum(v1);
                        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                        g0.I = NewAlbumFragment.this.mMelonTiaraProperty.c;
                        g0.d = ActionKind.PlayMusic;
                        g0.a = "음악재생";
                        g0.b = NewAlbumFragment.this.mMelonTiaraProperty.a;
                        g0.c = NewAlbumFragment.this.mMelonTiaraProperty.b;
                        g0.y = "앨범리스트";
                        g0.z = "음악재생";
                        g0.C = String.valueOf(v1 + 1);
                        g0.E = ((ALBUMLIST)object0).albumImg;
                        g0.e = ((ALBUMLIST)object0).albumId;
                        g0.f = "앨범";
                        g0.g = ((ALBUMLIST)object0).albumName;
                        g0.h = ProtocolUtils.getArtistNames(((ALBUMLIST)object0).artistList);
                        g0.a().track();
                        return;
                    }
                    NewAlbumFragment.this.showContextPopupAlbum(Playable.from(((ALBUMLIST)object0), this.getMenuId(), null));
                });
                if(z) {
                    com.iloen.melon.fragments.newmusic.g g0 = (View view0) -> if(!TextUtils.isEmpty(((ALBUMLIST)object0).albumId)) {
                        String s = this.getMenuId();
                        String s1 = ((ALBUMLIST)object0).albumId;
                        s s2 = new s();
                        s2.b = "3";
                        s2.c = s;
                        s2.e = "D23";
                        s2.h = "V1";
                        s2.j = "N10002";
                        s2.k = s1;
                        a.t(s2);
                        NewAlbumFragment.this.showAlbumInfoPage(((ALBUMLIST)object0).albumId);
                        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                        g0.I = NewAlbumFragment.this.mMelonTiaraProperty.c;
                        g0.d = ActionKind.ClickContent;
                        g0.a = "페이지이동";
                        g0.b = NewAlbumFragment.this.mMelonTiaraProperty.a;
                        g0.c = NewAlbumFragment.this.mMelonTiaraProperty.b;
                        g0.y = "앨범리스트";
                        g0.z = "페이지이동";
                        g0.C = String.valueOf(v1 + 1);
                        g0.E = ((ALBUMLIST)object0).albumImg;
                        g0.e = ((ALBUMLIST)object0).albumId;
                        g0.f = "앨범";
                        g0.g = ((ALBUMLIST)object0).albumName;
                        g0.h = ProtocolUtils.getArtistNames(((ALBUMLIST)object0).artistList);
                        g0.a().track();
                    };
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, g0);
                }
                else {
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, null);
                }
                h h0 = (View view0) -> {
                    NewAlbumFragment.this.showContextPopupAlbum(Playable.from(((ALBUMLIST)object0), this.getMenuId(), null));
                    return true;
                };
                ViewUtils.setOnLongClickListener(((AlbumHolder)o00).itemView, h0);
                String s = ProtocolUtils.getArtistNames(((ALBUMLIST)object0).artistList);
                String s1 = NewAlbumFragment.this.getResources().getString(0x7F130BA1, new Object[]{((ALBUMLIST)object0).albumName, s, ((ALBUMLIST)object0).totAvrgScore, ((ALBUMLIST)object0).ptcPnmPrco, ((ALBUMLIST)object0).issueDate});  // string:talkback_new_album_holder "%1$s, 아티스트 : %2$s, 평점 : 5점 중 %3$.1f점, 평점 참여자 : 
                                                                                                                                                                                                                                              // %4$s명, 발매일 : %5$s"
                q.f(s1, "getString(...)");
                ViewUtils.setContentDescriptionWithButtonClassName(((AlbumHolder)o00).itemView, s1);
                ((AlbumHolder)o00).btnPlayIv.setImageResource((z ? 0x7F080309 : 0x7F0801F1));  // drawable:common_btn_play_01
                ImageView imageView0 = ((AlbumHolder)o00).thumbnailIv;
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(((ALBUMLIST)object0).albumImg).into(((AlbumHolder)o00).thumbnailIv);
                }
                ((AlbumHolder)o00).titleTv.setText(((ALBUMLIST)object0).albumName);
                ((AlbumHolder)o00).artistTv.setText(s);
                ((AlbumHolder)o00).issueTv.setText(((ALBUMLIST)object0).issueDate);
                ViewUtils.showWhen(((AlbumHolder)o00).fanIv, ((ALBUMLIST)object0).isArtistFan);
                ViewUtils.showWhen(((AlbumHolder)o00).ratingContainer, true);
                ((AlbumHolder)o00).ratingView.c(((ALBUMLIST)object0).totAvrgScore);
                ((AlbumHolder)o00).ratingText.setText(String.valueOf(((ALBUMLIST)object0).totAvrgScore));
                ((AlbumHolder)o00).ratingUserCntTv.setText(StringUtils.getCountString(((ALBUMLIST)object0).ptcPnmPrco, 0x3B9AC9FF));
            }

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
            public final class com.iloen.melon.fragments.newmusic.NewAlbumFragment.NewAlbumAdapter.onBindViewImpl.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
                public com.iloen.melon.fragments.newmusic.NewAlbumFragment.NewAlbumAdapter.onBindViewImpl.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, NewAlbumFragment newAlbumFragment0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0) {
                }

                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                    m m0 = ((androidx.compose.runtime.p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                    }
                    i i0 = new i(this.$role);
                    com.iloen.melon.fragments.newmusic.NewAlbumFragment.NewAlbumAdapter.onBindViewImpl.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1.1 newAlbumFragment$NewAlbumAdapter$onBindViewImpl$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(NewAlbumFragment.this);
                            if(this.this$1$inlined.mAdapter instanceof NewAlbumAdapter) {
                                j0 j00 = this.this$1$inlined.mAdapter;
                                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.newmusic.NewAlbumFragment.NewAlbumAdapter");
                                ((NewAlbumAdapter)j00).clearCache(this.this$1$inlined.getCacheKey());
                            }
                            this.this$1$inlined.startFetch("refresh");
                            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                            g0.I = this.this$1$inlined.mMelonTiaraProperty.c;
                            g0.a = "페이지이동";
                            g0.b = this.this$1$inlined.mMelonTiaraProperty.a;
                            g0.c = this.this$1$inlined.mMelonTiaraProperty.b;
                            g0.y = "앨범리스트";
                            g0.z = "새로고침";
                            g0.a().track();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.$enabled, this.$onClickLabel, i0, newAlbumFragment$NewAlbumAdapter$onBindViewImpl$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return q1;
                }
            }

        }

        // 检测为 Lambda 实现
        private static final boolean onBindViewImpl$lambda$10(NewAlbumFragment newAlbumFragment0, ALBUMLIST newAlbumListRes$RESPONSE$ALBUMLIST0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, View view0) [...]

        private static final H onBindViewImpl$lambda$2(NewAlbumFragment newAlbumFragment0, l l0, int v) {
            if(((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2)) {
                b0 b00 = newAlbumFragment0.currentSortIndex;
                String[] arr_s = newAlbumFragment0.getResources().getStringArray(0x7F030032);  // array:sortingbar_area
                q.f(arr_s, "getStringArray(...)");
                boolean z = ((androidx.compose.runtime.p)l0).i(newAlbumFragment0);
                c c0 = ((androidx.compose.runtime.p)l0).N();
                if(z || c0 == k.a) {
                    c0 = (int v) -> NewAlbumAdapter.onBindViewImpl$lambda$2$lambda$1$lambda$0(newAlbumFragment0, v);
                    ((androidx.compose.runtime.p)l0).l0(c0);
                }
                x1.a.g(b00, arr_s, 1, 0.0f, 0.0f, c0, ((androidx.compose.runtime.p)l0), 0x180, 24);
                return H.a;
            }
            ((androidx.compose.runtime.p)l0).T();
            return H.a;
        }

        private static final H onBindViewImpl$lambda$2$lambda$1$lambda$0(NewAlbumFragment newAlbumFragment0, int v) {
            String s;
            if(((Number)newAlbumFragment0.currentSortIndex.getValue()).intValue() != v) {
                newAlbumFragment0.currentSortIndex.setValue(v);
                newAlbumFragment0.startFetch("sortbar change");
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = newAlbumFragment0.mMelonTiaraProperty.c;
                g0.a = "페이지이동";
                g0.b = newAlbumFragment0.mMelonTiaraProperty.a;
                g0.c = newAlbumFragment0.mMelonTiaraProperty.b;
                g0.y = "Pagemenu";
                g0.z = "페이지이동";
                switch(v) {
                    case 0: {
                        s = "전체";
                        break;
                    }
                    case 1: {
                        s = "국내";
                        break;
                    }
                    default: {
                        s = "해외";
                    }
                }
                g0.F = s;
                g0.a().track();
            }
            return H.a;
        }

        private static final H onBindViewImpl$lambda$6(NewAlbumFragment newAlbumFragment0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, l l0, int v) {
            boolean z = ((androidx.compose.runtime.p)l0).Q(v & 1, (v & 3) != 2);
            H h0 = H.a;
            if(z) {
                if(!((Boolean)newAlbumFragment0.isVisibleRefresh.getValue()).booleanValue()) {
                    return h0;
                }
                C0.c c0 = I.Q(0x7F08016B, ((androidx.compose.runtime.p)l0), 6);  // drawable:btn_common_refresh
                r0.q q0 = r0.a.a(androidx.compose.foundation.layout.a.n(n.a, 0.0f, 2.0f, 0.0f, 5.0f, 5), new com.iloen.melon.fragments.newmusic.NewAlbumFragment.NewAlbumAdapter.onBindViewImpl.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, newAlbumFragment0, newAlbumFragment$NewAlbumAdapter0));
                com.iloen.melon.fragments.newmusic.i i0 = ((androidx.compose.runtime.p)l0).N();
                if(i0 == k.a) {
                    i0 = (x x0) -> {
                        q.g(x0, "$this$semantics");
                        u.k(x0, 0);
                        return H.a;
                    };
                    ((androidx.compose.runtime.p)l0).l0(i0);
                }
                androidx.compose.foundation.q.c(c0, "", X0.n.c(q0, false, i0), null, null, 0.0f, null, ((androidx.compose.runtime.p)l0), 0, 120);
                return h0;
            }
            ((androidx.compose.runtime.p)l0).T();
            return h0;
        }

        // 检测为 Lambda 实现
        private static final H onBindViewImpl$lambda$6$lambda$5$lambda$4(x x0) [...]

        // 检测为 Lambda 实现
        private static final void onBindViewImpl$lambda$8(boolean z, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, ALBUMLIST newAlbumListRes$RESPONSE$ALBUMLIST0, NewAlbumFragment newAlbumFragment0, int v, View view0) [...]

        // 检测为 Lambda 实现
        private static final void onBindViewImpl$lambda$9(ALBUMLIST newAlbumListRes$RESPONSE$ALBUMLIST0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, NewAlbumFragment newAlbumFragment0, int v, View view0) [...]

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0572, viewGroup0, false);  // layout:new_album_header
                q.f(view0, "inflate(...)");
                return new HeaderHolder(this, view0);
            }
            return v == this.VIEW_TYPE_ALBUM ? new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false)) : null;  // layout:listitem_album
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_SORT_TYPE = "argSortType";
    @NotNull
    public static final Companion Companion = null;
    public static final int SORT_ALL = 0;
    public static final int SORT_DOMESTIC = 1;
    public static final int SORT_OVERSEAS = 2;
    @NotNull
    private static final String TAG = "NewAlbumFragment";
    @NotNull
    private final b0 currentSortIndex;
    @NotNull
    private String exAlbumId;
    private boolean isMyListAdded;
    @NotNull
    private final b0 isVisibleRefresh;
    @Inject
    public mb.k loginUseCase;
    private boolean mIsSortBarVisible;
    @Nullable
    private NewAlbumListRes myListResponse;

    static {
        NewAlbumFragment.Companion = new Companion(null);
        NewAlbumFragment.$stable = 8;
    }

    public NewAlbumFragment() {
        this.currentSortIndex = w.s(0);
        this.isVisibleRefresh = w.s(Boolean.FALSE);
        this.exAlbumId = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new NewAlbumAdapter(this, context0, null);
        ((j)j00).setListContentType(2);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.l0.buildUpon().appendQueryParameter("sortIndex", String.valueOf(((Number)this.currentSortIndex.getValue()).intValue())).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public final mb.k getLoginUseCase() {
        mb.k k0 = this.loginUseCase;
        if(k0 != null) {
            return k0;
        }
        q.m("loginUseCase");
        throw null;
    }

    public final boolean getMIsSortBarVisible() {
        return this.mIsSortBarVisible;
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
        return layoutInflater0.inflate(0x7F0D0571, viewGroup0, false);  // layout:new_album
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        q.g(i0, "type");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.newmusic.NewAlbumFragment.NewAlbumAdapter");
        if(v9.i.b.equals(i0)) {
            this.isVisibleRefresh.setValue(Boolean.FALSE);
            ((NewAlbumAdapter)j00).clear();
            this.isMyListAdded = false;
            if(((Number)this.currentSortIndex.getValue()).intValue() == 0 && ((e0)this.getLoginUseCase()).m()) {
                this.requestMyList(i0, ((NewAlbumAdapter)j00));
                return true;
            }
            this.request(i0, ((NewAlbumAdapter)j00));
            return true;
        }
        this.request(i0, ((NewAlbumAdapter)j00));
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        Integer integer0 = bundle0.getInt("argSortType");
        this.currentSortIndex.setValue(integer0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSortType", ((Number)this.currentSortIndex.getValue()).intValue());
    }

    private final void request(v9.i i0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0) {
        Params newAlbumListReq$Params0 = new Params();
        int v = newAlbumFragment$NewAlbumAdapter0.getCount();
        if(this.isMyListAdded) {
            --v;
        }
        newAlbumListReq$Params0.startIndex = v9.i.b.equals(i0) ? 1 : v + 1;
        newAlbumListReq$Params0.pageSize = 100;
        String s = "A";
        switch(((Number)this.currentSortIndex.getValue()).intValue()) {
            case 1: {
                s = "I";
                break;
            }
            case 2: {
                s = "O";
            }
        }
        newAlbumListReq$Params0.areaFlg = s;
        if(!TextUtils.isEmpty(this.exAlbumId)) {
            newAlbumListReq$Params0.exAlbumIds = this.exAlbumId;
        }
        RequestBuilder.newInstance(new NewAlbumListReq(this.getContext(), newAlbumListReq$Params0)).tag("NewAlbumFragment").listener(new com.iloen.melon.fragments.newmusic.b(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void request$lambda$7$lambda$6(NewAlbumFragment newAlbumFragment0, v9.i i0, NewAlbumListRes newAlbumListRes0) {
        Integer integer0;
        if(!newAlbumFragment0.prepareFetchComplete(newAlbumListRes0)) {
            return;
        }
        if(!newAlbumFragment0.mIsSortBarVisible) {
            newAlbumFragment0.mIsSortBarVisible = true;
        }
        if(newAlbumListRes0 == null) {
            integer0 = null;
        }
        else {
            RESPONSE newAlbumListRes$RESPONSE0 = newAlbumListRes0.response;
            if(newAlbumListRes$RESPONSE0 == null) {
                integer0 = null;
            }
            else {
                ArrayList arrayList0 = newAlbumListRes$RESPONSE0.albumlist;
                integer0 = arrayList0 == null ? null : arrayList0.size();
            }
        }
        if(integer0 != null && ((int)integer0) > 0) {
            newAlbumFragment0.isVisibleRefresh.setValue(Boolean.TRUE);
        }
        NewAlbumListRes newAlbumListRes1 = newAlbumFragment0.myListResponse;
        if(newAlbumListRes1 != null) {
            RESPONSE newAlbumListRes$RESPONSE1 = newAlbumListRes1.response;
            if(newAlbumListRes$RESPONSE1 != null) {
                ArrayList arrayList1 = newAlbumListRes$RESPONSE1.albumlist;
                if(arrayList1 != null) {
                    if(!arrayList1.isEmpty()) {
                        if(newAlbumListRes0 != null) {
                            RESPONSE newAlbumListRes$RESPONSE2 = newAlbumListRes0.response;
                            if(newAlbumListRes$RESPONSE2 != null) {
                                ArrayList arrayList2 = newAlbumListRes$RESPONSE2.albumlist;
                                if(arrayList2 != null) {
                                    Object object0 = arrayList1.get(0);
                                    ((ALBUMLIST)object0).isArtistFan = true;
                                    arrayList2.add(0, object0);
                                }
                            }
                        }
                        newAlbumFragment0.isMyListAdded = true;
                    }
                    newAlbumFragment0.myListResponse = null;
                }
            }
        }
        newAlbumFragment0.mMelonTiaraProperty = new p8.s(newAlbumListRes0.response.section, newAlbumListRes0.response.page, "", null);
        newAlbumFragment0.performFetchComplete(i0, newAlbumListRes0);
    }

    private final void requestMyList(v9.i i0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0) {
        RequestBuilder.newInstance(new NewMusicAlbumMyListReq(this.getContext())).tag("NewAlbumFragment@requestMyList").listener(new com.iloen.melon.fragments.newmusic.a(this, i0, newAlbumFragment$NewAlbumAdapter0)).errorListener(new com.iloen.melon.fragments.newmusic.a(this, i0, newAlbumFragment$NewAlbumAdapter0)).request();
    }

    private static final void requestMyList$lambda$2(NewAlbumFragment newAlbumFragment0, v9.i i0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, NewAlbumListRes newAlbumListRes0) {
        Cb.j.b(newAlbumListRes0.notification, false, 2);
        if(Cb.j.d(newAlbumListRes0)) {
            newAlbumFragment0.myListResponse = newAlbumListRes0;
            RESPONSE newAlbumListRes$RESPONSE0 = newAlbumListRes0.response;
            if(newAlbumListRes$RESPONSE0 != null) {
                ArrayList arrayList0 = newAlbumListRes$RESPONSE0.albumlist;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    String s = ((ALBUMLIST)arrayList0.get(0)).albumId;
                    if(s == null) {
                        s = "";
                    }
                    newAlbumFragment0.exAlbumId = s;
                }
            }
        }
        newAlbumFragment0.request(i0, newAlbumFragment$NewAlbumAdapter0);
    }

    private static final void requestMyList$lambda$3(NewAlbumFragment newAlbumFragment0, v9.i i0, NewAlbumAdapter newAlbumFragment$NewAlbumAdapter0, VolleyError volleyError0) {
        newAlbumFragment0.request(i0, newAlbumFragment$NewAlbumAdapter0);
    }

    public final void setLoginUseCase(@NotNull mb.k k0) {
        q.g(k0, "<set-?>");
        this.loginUseCase = k0;
    }

    public final void setMIsSortBarVisible(boolean z) {
        this.mIsSortBarVisible = z;
    }
}

