package com.iloen.melon.fragments.mymusic;

import Ac.v2;
import Dd.g0;
import Tf.o;
import U4.x;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.comments.CommentActionImplKt;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.LoadPgnReq.Params;
import com.iloen.melon.net.v3x.comments.LoadPgnReq;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.CommentMyListReq;
import com.iloen.melon.net.v6x.response.CommentMyListRes.RESPONSE.CMTLIST.LANDING;
import com.iloen.melon.net.v6x.response.CommentMyListRes.RESPONSE.CMTLIST;
import com.iloen.melon.net.v6x.response.CommentMyListRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.popup.b;
import d5.f;
import e1.u;
import ie.m;
import java.util.ArrayList;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J-\u0010\u001C\u001A\u00020\u001B2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u001C\u0010\u001DJ\u001B\u0010!\u001A\u0006\u0012\u0002\b\u00030 2\u0006\u0010\u001F\u001A\u00020\u001EH\u0014¢\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0014¢\u0006\u0004\b$\u0010%R\u0016\u0010&\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'¨\u0006*"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "tabType", "Ljava/lang/String;", "Companion", "CommentAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicMyCommentFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u00020\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ)\u0010\u001E\u001A\u00020\f2\b\u0010\u001D\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010!¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$CommentAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/CommentMyListRes$RESPONSE$CMTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "data", "Lie/H;", "moveReplyPage", "(Lcom/iloen/melon/net/v6x/response/CommentMyListRes$RESPONSE$CMTLIST;)V", "Lcom/iloen/melon/net/v6x/response/CommentMyListRes$RESPONSE$CMTLIST$LANDING;", "landing", "moveContsPage", "(Lcom/iloen/melon/net/v6x/response/CommentMyListRes$RESPONSE$CMTLIST$LANDING;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_COMMENT", "I", "VIEW_TYPE_COMMENT_NO_IMG", "CommentHolder", "CommentNoImgHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class CommentAdapter extends p {
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$CommentAdapter$CommentHolder;", "Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$CommentAdapter$CommentNoImgHolder;", "Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$CommentAdapter;", "Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment;", "view", "Landroid/view/View;", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$CommentAdapter;Landroid/view/View;)V", "thumbContainer", "getThumbContainer", "()Landroid/view/View;", "ivThumb", "Landroid/widget/ImageView;", "getIvThumb", "()Landroid/widget/ImageView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class CommentHolder extends CommentNoImgHolder {
            @NotNull
            private final ImageView ivThumb;
            @NotNull
            private final View thumbContainer;

            public CommentHolder(@NotNull View view0) {
                q.g(view0, "view");
                CommentAdapter.this = myMusicMyCommentFragment$CommentAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
                q.f(view1, "findViewById(...)");
                this.thumbContainer = view1;
                View view2 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
                q.f(view2, "findViewById(...)");
                this.ivThumb = (ImageView)view2;
            }

            @NotNull
            public final ImageView getIvThumb() {
                return this.ivThumb;
            }

            @NotNull
            public final View getThumbContainer() {
                return this.thumbContainer;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0092\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\nR\u0017\u0010\r\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001A\u0004\b\u000E\u0010\nR\u0017\u0010\u000F\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000F\u0010\b\u001A\u0004\b\u0010\u0010\nR\u0017\u0010\u0011\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$CommentAdapter$CommentNoImgHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$CommentAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "commentTv", "Landroid/widget/TextView;", "getCommentTv", "()Landroid/widget/TextView;", "channelTv", "getChannelTv", "contentsTv", "getContentsTv", "dateTv", "getDateTv", "centerCircle", "Landroid/view/View;", "getCenterCircle", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        class CommentNoImgHolder extends O0 {
            @NotNull
            private final View centerCircle;
            @NotNull
            private final TextView channelTv;
            @NotNull
            private final TextView commentTv;
            @NotNull
            private final TextView contentsTv;
            @NotNull
            private final TextView dateTv;

            public CommentNoImgHolder(@NotNull View view0) {
                q.g(view0, "view");
                CommentAdapter.this = myMusicMyCommentFragment$CommentAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A02FA);  // id:comment_tv
                q.f(view1, "findViewById(...)");
                this.commentTv = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A0245);  // id:channel_tv
                q.f(view2, "findViewById(...)");
                this.channelTv = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A0340);  // id:contents_tv
                q.f(view3, "findViewById(...)");
                this.contentsTv = (TextView)view3;
                View view4 = view0.findViewById(0x7F0A037E);  // id:date_tv
                q.f(view4, "findViewById(...)");
                this.dateTv = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A023A);  // id:center_circle
                q.f(view5, "findViewById(...)");
                this.centerCircle = view5;
            }

            @NotNull
            public final View getCenterCircle() {
                return this.centerCircle;
            }

            @NotNull
            public final TextView getChannelTv() {
                return this.channelTv;
            }

            @NotNull
            public final TextView getCommentTv() {
                return this.commentTv;
            }

            @NotNull
            public final TextView getContentsTv() {
                return this.contentsTv;
            }

            @NotNull
            public final TextView getDateTv() {
                return this.dateTv;
            }
        }

        private final int VIEW_TYPE_COMMENT;
        private final int VIEW_TYPE_COMMENT_NO_IMG;

        public CommentAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicMyCommentFragment.this = myMusicMyCommentFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_COMMENT = 1;
            this.VIEW_TYPE_COMMENT_NO_IMG = 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            LANDING commentMyListRes$RESPONSE$CMTLIST$LANDING0 = ((CMTLIST)this.getItem(v1)).landing;
            if(commentMyListRes$RESPONSE$CMTLIST$LANDING0 != null) {
                String s = commentMyListRes$RESPONSE$CMTLIST$LANDING0.contsTypeCode;
                q.f(s, "contsTypeCode");
                if(!o.H0(s)) {
                    String s1 = commentMyListRes$RESPONSE$CMTLIST$LANDING0.contsId;
                    q.f(s1, "contsId");
                    return o.H0(s1) ? this.VIEW_TYPE_COMMENT_NO_IMG : this.VIEW_TYPE_COMMENT;
                }
            }
            return this.VIEW_TYPE_COMMENT_NO_IMG;
        }

        private final void moveContsPage(LANDING commentMyListRes$RESPONSE$CMTLIST$LANDING0) {
            String s = commentMyListRes$RESPONSE$CMTLIST$LANDING0.contsId;
            MyMusicMyCommentFragment myMusicMyCommentFragment0 = MyMusicMyCommentFragment.this;
            String s1 = commentMyListRes$RESPONSE$CMTLIST$LANDING0.contsTypeCode;
            if(q.b(s1, "N10001")) {
                myMusicMyCommentFragment0.showSongInfoPage(s);
                return;
            }
            if(q.b(s1, "N10002")) {
                myMusicMyCommentFragment0.showAlbumInfoPage(s);
                return;
            }
            if(q.b(s1, "N10003")) {
                myMusicMyCommentFragment0.showMvInfoPage(s, this.getMenuId());
                return;
            }
            if(q.b(s1, "N10004")) {
                Navigator.openPhotoDetailView(s);
                return;
            }
            if(q.b(s1, "N10005")) {
                Navigator.INSTANCE.openPlaylistDetail(s);
                return;
            }
            if(q.b(s1, "N10006")) {
                Navigator.openArtistInfo(s);
                return;
            }
            if(q.b(s1, "N10007")) {
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                melonLinkInfo0.a = commentMyListRes$RESPONSE$CMTLIST$LANDING0.linkType;
                melonLinkInfo0.b = commentMyListRes$RESPONSE$CMTLIST$LANDING0.linkUrl;
                MelonLinkExecutor.open(melonLinkInfo0);
                return;
            }
            if(q.b(s1, "N10009")) {
                Navigator.openDjPlaylistDetail(s);
                return;
            }
            if(q.b(s1, "N10016")) {
                Navigator.INSTANCE.openArtistPlaylistDetail(s);
                return;
            }
            if(q.b(s1, "N10018")) {
                q.d(s);
                g0 g00 = new g0();
                Bundle bundle0 = Y.b("argMemberKey", s);
                bundle0.putBoolean("argIsMySelf", u.o(s) && s.equals(u.v(((e0)va.o.a()).j())));
                g00.setArguments(bundle0);
                Navigator.INSTANCE.open(g00);
                return;
            }
            if(q.b(s1, "N10022")) {
                Navigator.openMelGunsCollection();
                return;
            }
            if(q.b(s1, "N10029")) {
                Navigator.INSTANCE.openNowPlayingDetail(s);
                return;
            }
            if(q.b(s1, "N10059")) {
                l0 l00 = myMusicMyCommentFragment0.getChildFragmentManager();
                String s2 = null;
                String s3 = this.getContext() == null ? null : "안내";
                String s4 = this.getContext() == null ? null : "방금그곡 서비스는 종료되었습니다.";
                if(this.getContext() != null) {
                    s2 = "확인";
                }
                b.d(b.a, l00, s3, s4, false, false, false, s2, null, null, null, null, 0x7B8);
                return;
            }
            if(q.b(s1, "N10082")) {
                String s5 = this.getMenuId();
                Navigator.INSTANCE.openStationListen(s, s5);
                return;
            }
            ToastManager.showShort(0x7F1310D7);  // string:unknown_scheme "현재 버전에서 지원하지 않는 기능입니다. 앱 업데이트 후 사용해주세요."
        }

        private final void moveReplyPage(CMTLIST commentMyListRes$RESPONSE$CMTLIST0) {
            Params loadPgnReq$Params0 = new Params();
            Integer integer0 = Integer.valueOf(commentMyListRes$RESPONSE$CMTLIST0.chnlSeq);
            q.f(integer0, "valueOf(...)");
            loadPgnReq$Params0.chnlSeq = integer0.intValue();
            loadPgnReq$Params0.contsRefValue = commentMyListRes$RESPONSE$CMTLIST0.contsRefValue;
            RequestBuilder.newInstance(new LoadPgnReq(this.getContext(), loadPgnReq$Params0)).tag(MyMusicMyCommentFragment.this.getRequestTag()).listener(new Listener() {
                public void onResponse(LoadPgnRes loadPgnRes0) {
                    String s = null;
                    if((loadPgnRes0 == null ? null : loadPgnRes0.result) == null) {
                        if(loadPgnRes0 != null) {
                            s = loadPgnRes0.errormessage;
                        }
                        if(s == null) {
                            ToastManager.showShort(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                        }
                        else {
                            ToastManager.showShort(loadPgnRes0.errormessage);
                        }
                        commentMyListRes$RESPONSE$CMTLIST0.performFetchCompleteOnlyViews();
                        return;
                    }
                    Integer integer0 = Integer.valueOf(this.$data.chnlSeq);
                    q.f(integer0, "valueOf(...)");
                    String s1 = this.$data.contsRefValue;
                    q.f(s1, "contsRefValue");
                    int v = ProtocolUtils.parseInt(this.$data.viewCmtSeq, 0);
                    result loadPgnRes$result0 = loadPgnRes0.result;
                    q.f(loadPgnRes$result0, "result");
                    CommentConfig commentConfig0 = CommentActionImplKt.toUiModel(loadPgnRes$result0);
                    q.g(commentConfig0, "config");
                    v2 v20 = new v2();
                    v20.setArguments(f.j(new m[]{new m("key_cmt_seq", v), new m("key_channel_seq", integer0.intValue()), new m("key_content_ref_value", s1), new m("key_cmt_config", commentConfig0)}));
                    v20.m(commentMyListRes$RESPONSE$CMTLIST0.getParentFragment());
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((LoadPgnRes)object0));
                }
            }).errorListener(new W(0)).request();
        }

        private static final void moveReplyPage$lambda$3(VolleyError volleyError0) {
            ToastManager.showShort(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicMyCommentFragment.CommentAdapter.CommentNoImgHolder");
            CMTLIST commentMyListRes$RESPONSE$CMTLIST0 = (CMTLIST)this.getItem(v1);
            ViewUtils.setText(((CommentNoImgHolder)o00).getCommentTv(), commentMyListRes$RESPONSE$CMTLIST0.cmtCont);
            ViewUtils.setText(((CommentNoImgHolder)o00).getChannelTv(), commentMyListRes$RESPONSE$CMTLIST0.chnlName);
            String s = commentMyListRes$RESPONSE$CMTLIST0.contsTitle;
            q.f(s, "contsTitle");
            if(o.H0(s)) {
                ViewUtils.hideWhen(((CommentNoImgHolder)o00).getCenterCircle(), true);
                ViewUtils.hideWhen(((CommentNoImgHolder)o00).getContentsTv(), true);
            }
            else {
                ViewUtils.showWhen(((CommentNoImgHolder)o00).getCenterCircle(), true);
                ViewUtils.showWhen(((CommentNoImgHolder)o00).getContentsTv(), true);
                ViewUtils.setText(((CommentNoImgHolder)o00).getContentsTv(), commentMyListRes$RESPONSE$CMTLIST0.contsTitle);
            }
            ViewUtils.setText(((CommentNoImgHolder)o00).getDateTv(), commentMyListRes$RESPONSE$CMTLIST0.regDate);
            e e0 = new e(6, this, commentMyListRes$RESPONSE$CMTLIST0);
            ViewUtils.setOnClickListener(((CommentNoImgHolder)o00).itemView, e0);
            if(((CommentNoImgHolder)o00) instanceof CommentHolder) {
                LANDING commentMyListRes$RESPONSE$CMTLIST$LANDING0 = commentMyListRes$RESPONSE$CMTLIST0.landing;
                Glide.with(this.getContext()).load(commentMyListRes$RESPONSE$CMTLIST$LANDING0.thumbImg).into(((CommentHolder)(((CommentNoImgHolder)o00))).getIvThumb());
                ViewUtils.setOnClickListener(((CommentHolder)(((CommentNoImgHolder)o00))).getThumbContainer(), new e(7, this, commentMyListRes$RESPONSE$CMTLIST$LANDING0));
                ((CommentHolder)(((CommentNoImgHolder)o00))).getThumbContainer().setContentDescription(x.l(commentMyListRes$RESPONSE$CMTLIST0.chnlName, ", ", commentMyListRes$RESPONSE$CMTLIST0.contsTitle, " ", MyMusicMyCommentFragment.this.getString(0x7F130B8B)));  // string:talkback_move "이동"
            }
        }

        private static final void onBindViewImpl$lambda$0(CommentAdapter myMusicMyCommentFragment$CommentAdapter0, CMTLIST commentMyListRes$RESPONSE$CMTLIST0, View view0) {
            q.d(commentMyListRes$RESPONSE$CMTLIST0);
            myMusicMyCommentFragment$CommentAdapter0.moveReplyPage(commentMyListRes$RESPONSE$CMTLIST0);
        }

        private static final void onBindViewImpl$lambda$1(CommentAdapter myMusicMyCommentFragment$CommentAdapter0, LANDING commentMyListRes$RESPONSE$CMTLIST$LANDING0, View view0) {
            q.d(commentMyListRes$RESPONSE$CMTLIST$LANDING0);
            myMusicMyCommentFragment$CommentAdapter0.moveContsPage(commentMyListRes$RESPONSE$CMTLIST$LANDING0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_COMMENT) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D056C, viewGroup0, false);  // layout:mymusic_mycomment
                q.f(view0, "inflate(...)");
                return new CommentHolder(this, view0);
            }
            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D056D, viewGroup0, false);  // layout:mymusic_mycomment_no_img
            q.f(view1, "inflate(...)");
            return new CommentNoImgHolder(this, view1);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment$Companion;", "", "<init>", "()V", "TAG", "", "START_INDEX", "", "PAGE_SIZE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicMyCommentFragment;", "tabType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicMyCommentFragment newInstance(@NotNull String s) {
            q.g(s, "tabType");
            MyMusicMyCommentFragment myMusicMyCommentFragment0 = new MyMusicMyCommentFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argTabType", s);
            myMusicMyCommentFragment0.setArguments(bundle0);
            return myMusicMyCommentFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int PAGE_SIZE = 20;
    private static final int START_INDEX = 1;
    @NotNull
    private static final String TAG = "MyMusicMyCommentFragment";
    @NotNull
    private String tabType;

    static {
        MyMusicMyCommentFragment.Companion = new Companion(null);
        MyMusicMyCommentFragment.$stable = 8;
    }

    public MyMusicMyCommentFragment() {
        this.tabType = "comment";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new CommentAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.e0.buildUpon(), this.tabType, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(false);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).addItemDecoration(new r0() {
            @Override  // androidx.recyclerview.widget.r0
            public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                q.g(rect0, "outRect");
                q.g(view0, "view");
                q.g(recyclerView0, "parent");
                q.g(k00, "state");
                rect0.top = recyclerView0.getChildAdapterPosition(view0) == 0 ? ScreenUtils.dipToPixel(this.$this_apply.getContext(), 10.0f) : 0;
            }
        });
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
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicMyCommentFragment.CommentAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((CommentAdapter)j00).clear();
        }
        com.iloen.melon.net.v6x.request.CommentMyListReq.Params commentMyListReq$Params0 = new com.iloen.melon.net.v6x.request.CommentMyListReq.Params();
        commentMyListReq$Params0.startIndex = i1.equals(i0) ? 1 : ((CommentAdapter)j00).getCount() + 1;
        commentMyListReq$Params0.pageSize = 20;
        commentMyListReq$Params0.cmtLevel = q.b(this.tabType, "reply");
        RequestBuilder.newInstance(new CommentMyListReq(this.getContext(), commentMyListReq$Params0)).tag(this.getRequestTag()).listener(new g(this, i0, 21)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(MyMusicMyCommentFragment myMusicMyCommentFragment0, i i0, CommentMyListRes commentMyListRes0) {
        if(!myMusicMyCommentFragment0.prepareFetchComplete(commentMyListRes0)) {
            return;
        }
        myMusicMyCommentFragment0.performFetchComplete(i0, commentMyListRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argTabType");
        if(s == null) {
            s = "";
        }
        this.tabType = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argTabType", this.tabType);
    }
}

