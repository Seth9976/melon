package com.iloen.melon.fragments.mymusic;

import B9.g;
import B9.h;
import B9.i;
import B9.j;
import B9.k;
import Tf.o;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.main.foru.ForUUtils;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v6x.request.ForUMixPlayReq.Params;
import com.iloen.melon.net.v6x.request.ForUMixPlayReq;
import com.iloen.melon.net.v6x.request.MyMusicRecentListPlylstRecntReq;
import com.iloen.melon.net.v6x.response.ForUMixPlayRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ForUMixPlayRes;
import com.iloen.melon.net.v6x.response.MyMusicRecentListPlylstRecntRes.RESPONSE.RECNTPLYLSTLIST;
import com.iloen.melon.net.v6x.response.MyMusicRecentListPlylstRecntRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.template.TemplateData.ArtistMixDataBuilder;
import com.iloen.melon.utils.template.TemplateImageLoader;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl.OnClickListener;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl;
import com.iloen.melon.viewholders.PlaylistNewHolderImpl;
import com.melon.net.res.common.DjPlayListInfoBase;
import e1.u;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001A\u001A\u00020\u00192\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b \u0010\u001EJ\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014¢\u0006\u0004\b\'\u0010(R\u0016\u0010)\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedPlaylistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "memberKey", "Ljava/lang/String;", "Companion", "ListenedPlaylistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicListenedPlaylistFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedPlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicListenedPlaylistFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicListenedPlaylistFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0 = new MyMusicListenedPlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicListenedPlaylistFragment0.setArguments(bundle0);
            return myMusicListenedPlaylistFragment0;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001A\u00020\u000F2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u000B¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0015H\u0014¢\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001F\u001A\u00020\u00032\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001E\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001F\u0010 J)\u0010\"\u001A\u00020\u000F2\b\u0010!\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010\'\u001A\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b\'\u0010%R\u0014\u0010(\u001A\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010%R\u0016\u0010)\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedPlaylistFragment$ListenedPlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/MyMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedPlaylistFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "contsId", "seedContsId", "seedContsTypeCode", "Lie/H;", "playForUSongList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "guide", "setGuideText", "(Ljava/lang/String;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getFooterViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_PLAYLIST", "I", "VIEW_TYPE_DJ_PLAYLIST", "VIEW_TYPE_MIX_PLAYLIST", "VIEW_TYPE_FOOTER", "tvGuide", "Ljava/lang/String;", "FooterViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ListenedPlaylistAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedPlaylistFragment$ListenedPlaylistAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedPlaylistFragment$ListenedPlaylistAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class FooterViewHolder extends O0 {
            @NotNull
            private final MelonTextView tvTitle;

            public FooterViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ListenedPlaylistAdapter.this = myMusicListenedPlaylistFragment$ListenedPlaylistAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view1, "findViewById(...)");
                this.tvTitle = (MelonTextView)view1;
            }

            @NotNull
            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        private final int VIEW_TYPE_DJ_PLAYLIST;
        private final int VIEW_TYPE_FOOTER;
        private final int VIEW_TYPE_MIX_PLAYLIST;
        private final int VIEW_TYPE_PLAYLIST;
        @NotNull
        private String tvGuide;

        public ListenedPlaylistAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicListenedPlaylistFragment.this = myMusicListenedPlaylistFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_PLAYLIST = 1;
            this.VIEW_TYPE_DJ_PLAYLIST = 2;
            this.VIEW_TYPE_MIX_PLAYLIST = 3;
            this.VIEW_TYPE_FOOTER = 4;
            this.tvGuide = "";
        }

        public static void b(RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, ListenedPlaylistAdapter myMusicListenedPlaylistFragment$ListenedPlaylistAdapter0, View view0, int v) {
            ListenedPlaylistAdapter.onBindViewImpl$lambda$0(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, myMusicListenedPlaylistFragment0, myMusicListenedPlaylistFragment$ListenedPlaylistAdapter0, view0, v);
        }

        public static void d(MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, VolleyError volleyError0) {
            ListenedPlaylistAdapter.playForUSongList$lambda$4(myMusicListenedPlaylistFragment0, volleyError0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getFooterViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getFooterCount() > 0 && v == this.getAvailableFooterPosition()) {
                return this.VIEW_TYPE_FOOTER;
            }
            RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0 = (RECNTPLYLSTLIST)this.getItem(v1);
            String s = myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0 == null ? null : myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.contsTypeCode;
            if(q.b(s, "N10009")) {
                return this.VIEW_TYPE_DJ_PLAYLIST;
            }
            return q.b(s, "N10078") ? this.VIEW_TYPE_MIX_PLAYLIST : this.VIEW_TYPE_PLAYLIST;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0 = (RECNTPLYLSTLIST)this.getItem(v1);
            if(!(o00 instanceof PlaylistNewHolderImpl)) {
                if(o00 instanceof DjPlaylistNewHolderImpl) {
                    ViewUtils.showWhen(((DjPlaylistNewHolderImpl)o00).moreIv, true);
                    ((DjPlaylistNewHolderImpl)o00).bindView(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, v1);
                    ((DjPlaylistNewHolderImpl)o00).setOnClickListener(new OnClickListener() {
                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickBody(DjPlayListInfoBase djPlayListInfoBase0) {
                            q.g(djPlayListInfoBase0, "data");
                            Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickTag1(String s) {
                            q.g(s, "tagSeq");
                            Navigator.openMelonDJTagHubDetail(s);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickTag2(String s) {
                            q.g(s, "tagSeq");
                            Navigator.openMelonDJTagHubDetail(s);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickThumbnail(DjPlayListInfoBase djPlayListInfoBase0) {
                            q.g(djPlayListInfoBase0, "data");
                            Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void playDjPlaylist(DjPlayListInfoBase djPlayListInfoBase0) {
                            q.g(djPlayListInfoBase0, "data");
                            String s = djPlayListInfoBase0.plylstseq;
                            String s1 = djPlayListInfoBase0.contsTypeCode;
                            String s2 = ListenedPlaylistAdapter.this.getMenuId();
                            this.playPlaylist(s, s1, s2, djPlayListInfoBase0.statsElements);
                        }
                    });
                    ((DjPlaylistNewHolderImpl)o00).setOnLongClickListener(new O(MyMusicListenedPlaylistFragment.this, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0));
                    ((DjPlaylistNewHolderImpl)o00).setOnMoreClickListener(new O(MyMusicListenedPlaylistFragment.this, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0));
                    return;
                }
                if(o00 instanceof k) {
                    ((k)o00).getClass();
                    if(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0 != null) {
                        if(q.b(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.contsTypeCode, "N10078") && !q.b(((k)o00).h, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.contsId) && !q.b(((k)o00).i, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.contsId)) {
                            new TemplateImageLoader(new ArtistMixDataBuilder(((k)o00).b, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainReplace, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainImgUrls, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainSubImgUrl, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.contsId, false, null, 0x40, null).build()).load(new g(0, ((k)o00), myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0));
                        }
                        else if(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainImgUrls != null && !myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainImgUrls.isEmpty() == 1) {
                            j j0 = (j)Glide.with(((k)o00).b).load(((String)myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainImgUrls.get(0))).into(new j(((k)o00), myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, ((k)o00).b));
                        }
                        String s = ForUUtils.replaceNicknameWithMarkup(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainTitle, "<b>MAINREPLACE</b>", myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.mainReplace, 22);
                        ViewUtils.setText(((k)o00).d, s);
                        ViewUtils.setText(((k)o00).e, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.writer);
                        h h0 = new h(((k)o00), myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, 0);
                        ViewUtils.setOnClickListener(((k)o00).itemView, h0);
                        h h1 = new h(((k)o00), myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, 1);
                        ViewUtils.setOnClickListener(((k)o00).c, h1);
                    }
                    ((k)o00).g = new i() {
                        @Override  // B9.i
                        public void clickBody(RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0) {
                            q.g(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, "data");
                            Navigator.INSTANCE.openMixPlaylist(MyMusicListenedPlaylistFragment.this, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.contsId, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.seedContsId, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.seedContsTypeCode);
                        }

                        @Override  // B9.i
                        public void playMixPlaylist(RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0) {
                            q.g(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, "data");
                            MyMusicListenedPlaylistFragment.this.playForUSongList(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.contsId, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.seedContsId, myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.seedContsTypeCode);
                        }
                    };
                    return;
                }
                if(o00 instanceof FooterViewHolder) {
                    if(!TextUtils.isEmpty(this.tvGuide)) {
                        ViewUtils.showWhen(((FooterViewHolder)o00).getTvTitle(), true);
                        ViewUtils.setText(((FooterViewHolder)o00).getTvTitle(), this.tvGuide);
                        return;
                    }
                    ViewUtils.hideWhen(((FooterViewHolder)o00).getTvTitle(), true);
                }
            }
            else if(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0 != null) {
                ViewUtils.showWhen(((PlaylistNewHolderImpl)o00).moreIv, true);
                ((PlaylistNewHolderImpl)o00).bindView(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, v1);
                ((PlaylistNewHolderImpl)o00).setOnClickListener(new com.iloen.melon.viewholders.PlaylistNewHolderImpl.OnClickListener() {
                    @Override  // com.iloen.melon.viewholders.PlaylistNewHolderImpl$OnClickListener
                    public void clickItemView(ArtistPlayListInfoBase artistPlayListInfoBase0) {
                        q.g(artistPlayListInfoBase0, "data");
                        if("Y".equals(artistPlayListInfoBase0.isartist)) {
                            Navigator.INSTANCE.openArtistPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                            return;
                        }
                        Navigator.INSTANCE.openPlaylistDetail(artistPlayListInfoBase0.plylstseq);
                    }

                    @Override  // com.iloen.melon.viewholders.PlaylistNewHolderImpl$OnClickListener
                    public void clickMore(ArtistPlayListInfoBase artistPlayListInfoBase0) {
                        q.g(artistPlayListInfoBase0, "data");
                        if("Y".equals(artistPlayListInfoBase0.isartist)) {
                            String s = ListenedPlaylistAdapter.this.getMenuId();
                            this.showContextPopupArtistPlaylist(artistPlayListInfoBase0, s);
                            return;
                        }
                        this.showContextPopupPlayList(artistPlayListInfoBase0);
                    }

                    @Override  // com.iloen.melon.viewholders.PlaylistNewHolderImpl$OnClickListener
                    public void playPlaylist(ArtistPlayListInfoBase artistPlayListInfoBase0) {
                        q.g(artistPlayListInfoBase0, "data");
                        String s = artistPlayListInfoBase0.plylstseq;
                        String s1 = artistPlayListInfoBase0.contsTypeCode;
                        String s2 = ListenedPlaylistAdapter.this.getMenuId();
                        this.playPlaylist(s, s1, s2, artistPlayListInfoBase0.statsElements);
                    }
                });
                ((PlaylistNewHolderImpl)o00).setOnLongClickListener(new E(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, MyMusicListenedPlaylistFragment.this, this, 2));
            }
        }

        private static final void onBindViewImpl$lambda$0(RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, ListenedPlaylistAdapter myMusicListenedPlaylistFragment$ListenedPlaylistAdapter0, View view0, int v) {
            if("Y".equals(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0.isartist)) {
                myMusicListenedPlaylistFragment0.showContextPopupArtistPlaylist(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, myMusicListenedPlaylistFragment$ListenedPlaylistAdapter0.getMenuId());
                return;
            }
            myMusicListenedPlaylistFragment0.showContextPopupPlayList(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0);
        }

        private static final void onBindViewImpl$lambda$1(MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, View view0, int v) {
            myMusicListenedPlaylistFragment0.showContextPopupPlayList(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0);
        }

        private static final void onBindViewImpl$lambda$2(MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, DjPlayListInfoBase djPlayListInfoBase0) {
            myMusicListenedPlaylistFragment0.showContextPopupPlayList(myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_FOOTER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D056F, viewGroup0, false);  // layout:mymusic_recent_last
                q.f(view0, "inflate(...)");
                return new FooterViewHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_DJ_PLAYLIST) {
                return new DjPlaylistNewHolderImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D048E, viewGroup0, false));  // layout:listitem_djplaylist_new
            }
            if(v == this.VIEW_TYPE_MIX_PLAYLIST) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D049B, viewGroup0, false);  // layout:listitem_mixplaylist
                q.f(view1, "inflate(...)");
                return new k(view1);
            }
            return new PlaylistNewHolderImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D049F, viewGroup0, false));  // layout:listitem_playlist_new
        }

        private final void playForUSongList(String s, String s1, String s2) {
            if(s != null && !o.H0(s) && s1 != null && !o.H0(s1) && s2 != null && !o.H0(s2)) {
                Params forUMixPlayReq$Params0 = new Params();
                forUMixPlayReq$Params0.contsId = s;
                forUMixPlayReq$Params0.seedContsId = s1;
                forUMixPlayReq$Params0.seedContsTypeCode = s2;
                forUMixPlayReq$Params0.menuId = this.getMenuId();
                RequestBuilder.newInstance(new ForUMixPlayReq(this.getContext(), forUMixPlayReq$Params0)).tag(MyMusicListenedPlaylistFragment.this.getRequestTag()).listener(new com.iloen.melon.fragments.mymusic.g(MyMusicListenedPlaylistFragment.this, this, 6)).errorListener(new B(MyMusicListenedPlaylistFragment.this, 3)).request();
            }
        }

        private static final void playForUSongList$lambda$3(MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, ListenedPlaylistAdapter myMusicListenedPlaylistFragment$ListenedPlaylistAdapter0, Object object0) {
            myMusicListenedPlaylistFragment0.showProgress(false);
            if(((ForUMixPlayRes)object0) != null) {
                RESPONSE forUMixPlayRes$RESPONSE0 = ((ForUMixPlayRes)object0).response;
                if(forUMixPlayRes$RESPONSE0 != null && Cb.j.c(((ForUMixPlayRes)object0).notification) && (forUMixPlayRes$RESPONSE0.songList != null && !forUMixPlayRes$RESPONSE0.songList.isEmpty())) {
                    myMusicListenedPlaylistFragment0.playSongs(Playable.getListFromSongBaseArrayOnlyCanService(forUMixPlayRes$RESPONSE0.songList, myMusicListenedPlaylistFragment$ListenedPlaylistAdapter0.getMenuId(), forUMixPlayRes$RESPONSE0.statsElements), true, false);
                }
            }
        }

        private static final void playForUSongList$lambda$4(MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, VolleyError volleyError0) {
            myMusicListenedPlaylistFragment0.showProgress(false);
        }

        public final void setGuideText(@NotNull String s) {
            q.g(s, "guide");
            this.tvGuide = s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MyMusicListenedPlaylistFragment";
    @NotNull
    private String memberKey;

    static {
        MyMusicListenedPlaylistFragment.Companion = new Companion(null);
        MyMusicListenedPlaylistFragment.$stable = 8;
    }

    public MyMusicListenedPlaylistFragment() {
        this.memberKey = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new ListenedPlaylistAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(4);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.V.buildUpon().appendPath("playlist"), "targetMemberKey", this.memberKey, "toString(...)");
    }

    @NotNull
    public static final MyMusicListenedPlaylistFragment newInstance(@NotNull String s) {
        return MyMusicListenedPlaylistFragment.Companion.newInstance(s);
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
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        RequestBuilder.newInstance(new MyMusicRecentListPlylstRecntReq(this.getContext(), u.v(((e0)va.o.a()).j()))).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.mymusic.g(this, i0, 18)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$0(MyMusicListenedPlaylistFragment myMusicListenedPlaylistFragment0, v9.i i0, MyMusicRecentListPlylstRecntRes myMusicRecentListPlylstRecntRes0) {
        if(!myMusicListenedPlaylistFragment0.prepareFetchComplete(myMusicRecentListPlylstRecntRes0)) {
            return;
        }
        ArrayList arrayList0 = myMusicRecentListPlylstRecntRes0.response == null ? null : myMusicRecentListPlylstRecntRes0.response.recntPlylstList;
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            j0 j00 = myMusicListenedPlaylistFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicListenedPlaylistFragment.ListenedPlaylistAdapter");
            String s = myMusicRecentListPlylstRecntRes0.response.guideText;
            q.f(s, "guideText");
            ((ListenedPlaylistAdapter)j00).setGuideText(s);
        }
        myMusicListenedPlaylistFragment0.performFetchComplete(i0, myMusicRecentListPlylstRecntRes0);
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
}

