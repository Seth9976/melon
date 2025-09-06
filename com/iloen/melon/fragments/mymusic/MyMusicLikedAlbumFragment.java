package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.content.res.Resources;
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
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.ToggleView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeListAlbumReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSameAlbumReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSameAlbumReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListAlbumRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameAlbumRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import com.melon.net.res.common.AlbumInfoBase;
import e.k;
import e1.u;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002=>B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ-\u0010\"\u001A\u00020\u001A2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010!\u001A\u0004\u0018\u00010\tH\u0014\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u00020\u00052\u0006\u0010\'\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b(\u0010&J\u000F\u0010*\u001A\u00020)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u001B\u0010/\u001A\u0006\u0012\u0002\b\u00030.2\u0006\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b/\u00100R\u0014\u00101\u001A\u00020\u00078\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001A\u00020\u00078\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b3\u00102R$\u00107\u001A\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`68\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u00102R\u0016\u0010:\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010;\u00A8\u0006?"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedAlbumFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/fragments/mymusic/OnCheckMyself;", "<init>", "()V", "Lie/H;", "setFilterData", "", "position", "", "getFilterTypeForServer", "(I)Ljava/lang/String;", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "isMyself", "()Z", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "START_INDEX", "I", "PAGE_SIZE", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "filterList", "Ljava/util/ArrayList;", "togglePos", "memberKey", "Ljava/lang/String;", "filterType", "Companion", "LikedAlbumAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicLikedAlbumFragment extends MetaContentBaseFragment implements OnCheckMyself {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedAlbumFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicLikedAlbumFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicLikedAlbumFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0 = new MyMusicLikedAlbumFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicLikedAlbumFragment0.setArguments(bundle0);
            return myMusicLikedAlbumFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001EB+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\u00032\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001C¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedAlbumFragment$LikedAlbumAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/AlbumInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedAlbumFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_ALBUM", "HeaderViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LikedAlbumAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedAlbumFragment$LikedAlbumAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedAlbumFragment$LikedAlbumAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/ToggleView;", "toggleView", "Lcom/iloen/melon/custom/ToggleView;", "getToggleView", "()Lcom/iloen/melon/custom/ToggleView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HeaderViewHolder extends O0 {
            @NotNull
            private final ToggleView toggleView;

            public HeaderViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                int v;
                Resources resources0;
                LikedAlbumAdapter.this = myMusicLikedAlbumFragment$LikedAlbumAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BBD);  // id:toggle_layout
                q.f(view1, "findViewById(...)");
                this.toggleView = (ToggleView)view1;
                if(MyMusicLikedAlbumFragment.this.isMyself()) {
                    resources0 = MyMusicLikedAlbumFragment.this.getResources();
                    v = 0x7F03001E;  // array:my_music_like_filter_type
                }
                else {
                    resources0 = MyMusicLikedAlbumFragment.this.getResources();
                    v = 0x7F030021;  // array:other_music_like
                }
                String[] arr_s = resources0.getStringArray(v);
                q.d(arr_s);
                ((ToggleView)view1).e(k.A(Arrays.copyOf(arr_s, arr_s.length)), new B(MyMusicLikedAlbumFragment.this, 0));
                ((ToggleView)view1).setFilterPosition(MyMusicLikedAlbumFragment.this.togglePos);
            }

            private static final void _init_$lambda$0(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, int v, String s) {
                myMusicLikedAlbumFragment0.filterType = myMusicLikedAlbumFragment0.getFilterTypeForServer(v);
                myMusicLikedAlbumFragment0.togglePos = v;
                myMusicLikedAlbumFragment0.startFetch("filter change");
            }

            public static void a(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, int v, String s) {
                HeaderViewHolder._init_$lambda$0(myMusicLikedAlbumFragment0, v, s);
            }

            @NotNull
            public final ToggleView getToggleView() {
                return this.toggleView;
            }
        }

        private final int VIEW_TYPE_ALBUM;
        private final int VIEW_TYPE_HEADER;

        public LikedAlbumAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicLikedAlbumFragment.this = myMusicLikedAlbumFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_ALBUM = 2;
        }

        public static void a(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, AlbumInfoBase albumInfoBase0, LikedAlbumAdapter myMusicLikedAlbumFragment$LikedAlbumAdapter0, View view0) {
            LikedAlbumAdapter.onBindViewImpl$lambda$5$lambda$3(albumInfoBase0, myMusicLikedAlbumFragment0, myMusicLikedAlbumFragment$LikedAlbumAdapter0, view0);
        }

        public static boolean d(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, AlbumInfoBase albumInfoBase0, LikedAlbumAdapter myMusicLikedAlbumFragment$LikedAlbumAdapter0, View view0) {
            return LikedAlbumAdapter.onBindViewImpl$lambda$5$lambda$4(myMusicLikedAlbumFragment0, albumInfoBase0, myMusicLikedAlbumFragment$LikedAlbumAdapter0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return MyMusicLikedAlbumFragment.this.isMyself() && this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_ALBUM : this.VIEW_TYPE_HEADER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof HeaderViewHolder) {
                MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0 = MyMusicLikedAlbumFragment.this;
                if(myMusicLikedAlbumFragment0.isMyself()) {
                    ToggleView toggleView0 = ((HeaderViewHolder)o00).getToggleView();
                    g g0 = new g(myMusicLikedAlbumFragment0, this, 2);
                    toggleView0.c(L.f, g0);
                    return;
                }
                ((HeaderViewHolder)o00).getToggleView().setRightLayout(null);
                return;
            }
            if(o00 instanceof AlbumHolder) {
                MyMusicLikedAlbumFragment myMusicLikedAlbumFragment1 = MyMusicLikedAlbumFragment.this;
                Object object0 = this.getItem(v1);
                if(((AlbumInfoBase)object0) != null) {
                    boolean z = ((AlbumInfoBase)object0).canService;
                    ViewUtils.setEnable(((AlbumHolder)o00).wrapperLayout, z);
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).btnPlayIv, new y(z, myMusicLikedAlbumFragment1, v1, ((AlbumInfoBase)object0), this));
                    if(z) {
                        ((AlbumHolder)o00).btnPlayIv.setVisibility(0);
                        z z1 = new z(((AlbumInfoBase)object0), myMusicLikedAlbumFragment1, this, 0);
                        ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, z1);
                    }
                    else {
                        ((AlbumHolder)o00).btnPlayIv.setVisibility(8);
                        ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, null);
                    }
                    A a0 = new A(myMusicLikedAlbumFragment1, ((AlbumInfoBase)object0), this, 0);
                    ViewUtils.setOnLongClickListener(((AlbumHolder)o00).itemView, a0);
                    ImageView imageView0 = ((AlbumHolder)o00).thumbnailIv;
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(((AlbumInfoBase)object0).albumImg).into(((AlbumHolder)o00).thumbnailIv);
                    }
                    ((AlbumHolder)o00).titleTv.setText(((AlbumInfoBase)object0).albumName);
                    ((AlbumHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((AlbumInfoBase)object0).artistList));
                    ((AlbumHolder)o00).issueTv.setText(((AlbumInfoBase)object0).issueDate);
                    ViewUtils.showWhen(((AlbumHolder)o00).ratingContainer, true);
                    ((AlbumHolder)o00).ratingView.c(((AlbumInfoBase)object0).totAvrgScore);
                    ((AlbumHolder)o00).ratingText.setText(String.valueOf(((AlbumInfoBase)object0).totAvrgScore));
                    ((AlbumHolder)o00).ratingUserCntTv.setText(StringUtils.getCountString(((AlbumInfoBase)object0).ptcPnmPrco, 0x3B9AC9FF));
                }
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, LikedAlbumAdapter myMusicLikedAlbumFragment$LikedAlbumAdapter0, View view0) {
            MyMusicLikeEditFragment.newInstance("album", myMusicLikedAlbumFragment0.filterType, myMusicLikedAlbumFragment$LikedAlbumAdapter0.getCacheKey()).open();
        }

        private static final void onBindViewImpl$lambda$5$lambda$2(boolean z, MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, int v, AlbumInfoBase albumInfoBase0, LikedAlbumAdapter myMusicLikedAlbumFragment$LikedAlbumAdapter0, View view0) {
            if(z) {
                myMusicLikedAlbumFragment0.playAlbum(v);
                return;
            }
            myMusicLikedAlbumFragment0.showContextPopupAlbum(Playable.from(albumInfoBase0, myMusicLikedAlbumFragment$LikedAlbumAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$5$lambda$3(AlbumInfoBase albumInfoBase0, MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, LikedAlbumAdapter myMusicLikedAlbumFragment$LikedAlbumAdapter0, View view0) {
            if(albumInfoBase0.albumId != null && albumInfoBase0.albumId.length() != 0) {
                myMusicLikedAlbumFragment0.showAlbumInfoPage(Playable.from(albumInfoBase0, myMusicLikedAlbumFragment$LikedAlbumAdapter0.getMenuId(), null));
            }
        }

        private static final boolean onBindViewImpl$lambda$5$lambda$4(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, AlbumInfoBase albumInfoBase0, LikedAlbumAdapter myMusicLikedAlbumFragment$LikedAlbumAdapter0, View view0) {
            myMusicLikedAlbumFragment0.showContextPopupAlbum(Playable.from(albumInfoBase0, myMusicLikedAlbumFragment$LikedAlbumAdapter0.getMenuId(), null));
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D089B, viewGroup0, false);  // layout:toggle_standalone
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(this, view0);
            }
            return new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false));  // layout:listitem_album
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MyMusicLikedAlbumFragment";
    @NotNull
    private final ArrayList filterList;
    @NotNull
    private String filterType;
    @NotNull
    private String memberKey;
    private int togglePos;

    static {
        MyMusicLikedAlbumFragment.Companion = new Companion(null);
        MyMusicLikedAlbumFragment.$stable = 8;
    }

    public MyMusicLikedAlbumFragment() {
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.filterList = new ArrayList();
        this.memberKey = "";
        this.filterType = "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LikedAlbumAdapter(this, context0, null);
        ((j)j00).setListContentType(2);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("album").appendQueryParameter("filterType", this.filterType), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final String getFilterTypeForServer(int v) {
        v9.j j0 = (v9.j)je.p.n0(v, this.filterList);
        if(j0 != null) {
            return j0.c == null ? "" : j0.c;
        }
        return "";
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.mymusic.OnCheckMyself
    public boolean isMyself() {
        return TextUtils.isEmpty(this.memberKey) || q.b(this.memberKey, u.v(((e0)o.a()).j()));
    }

    @NotNull
    public static final MyMusicLikedAlbumFragment newInstance(@NotNull String s) {
        return MyMusicLikedAlbumFragment.Companion.newInstance(s);
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
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        int v1;
        int v;
        i i1 = i.b;
        if(i1.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedAlbumFragment.LikedAlbumAdapter");
            ((LikedAlbumAdapter)j00).clear();
        }
        if(q.b(this.filterType, "LIKE_ME")) {
            Params myMusicLikeListSameAlbumReq$Params0 = new Params();
            if(i1.equals(i0)) {
                v = this.START_INDEX;
            }
            else {
                j0 j01 = this.mAdapter;
                q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedAlbumFragment.LikedAlbumAdapter");
                v = ((LikedAlbumAdapter)j01).getCount() + 1;
            }
            myMusicLikeListSameAlbumReq$Params0.startIndex = v;
            myMusicLikeListSameAlbumReq$Params0.pageSize = this.PAGE_SIZE;
            myMusicLikeListSameAlbumReq$Params0.targetMemberKey = this.memberKey;
            RequestBuilder.newInstance(new MyMusicLikeListSameAlbumReq(this.getContext(), myMusicLikeListSameAlbumReq$Params0)).tag("MyMusicLikedAlbumFragment").listener(new x(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        com.iloen.melon.net.v4x.request.LikeListAlbumBaseReq.Params likeListAlbumBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListAlbumBaseReq.Params();
        if(i1.equals(i0)) {
            v1 = this.START_INDEX;
        }
        else {
            j0 j02 = this.mAdapter;
            q.e(j02, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedAlbumFragment.LikedAlbumAdapter");
            v1 = ((LikedAlbumAdapter)j02).getCount() + 1;
        }
        likeListAlbumBaseReq$Params0.startIndex = v1;
        likeListAlbumBaseReq$Params0.pageSize = this.PAGE_SIZE;
        likeListAlbumBaseReq$Params0.orderBy = this.filterType;
        likeListAlbumBaseReq$Params0.targetMemberKey = this.isMyself() ? u.v(((e0)o.a()).j()) : this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListAlbumReq(this.getContext(), likeListAlbumBaseReq$Params0)).tag("MyMusicLikedAlbumFragment").listener(new x(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, i i0, MyMusicLikeListSameAlbumRes myMusicLikeListSameAlbumRes0) {
        if(!myMusicLikedAlbumFragment0.prepareFetchComplete(myMusicLikeListSameAlbumRes0)) {
            return;
        }
        myMusicLikedAlbumFragment0.performFetchComplete(i0, myMusicLikeListSameAlbumRes0);
    }

    private static final void onFetchStart$lambda$3(MyMusicLikedAlbumFragment myMusicLikedAlbumFragment0, i i0, MyMusicLikeListAlbumRes myMusicLikeListAlbumRes0) {
        if(!myMusicLikedAlbumFragment0.prepareFetchComplete(myMusicLikeListAlbumRes0)) {
            return;
        }
        myMusicLikedAlbumFragment0.performFetchComplete(i0, myMusicLikeListAlbumRes0);
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
        this.setFilterData();
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    private final void setFilterData() {
        if(this.isMyself()) {
            v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.c = "NEW";
            this.filterList.add(j0);
            v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j1.c = "ALPHABET";
            this.filterList.add(j1);
            v9.j j2 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j2.c = "ARTIST";
            this.filterList.add(j2);
            return;
        }
        v9.j j3 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j3.c = "NEW";
        this.filterList.add(j3);
        v9.j j4 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j4.c = "LIKE_ME";
        this.filterList.add(j4);
    }
}

