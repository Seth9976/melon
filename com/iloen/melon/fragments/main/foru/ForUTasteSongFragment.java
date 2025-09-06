package com.iloen.melon.fragments.main.foru;

import Cb.j;
import J8.h2;
import Md.f;
import Md.l;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.q0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.e;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.ForuTasteSongReq;
import com.iloen.melon.net.v6x.request.ForuTasteSubmitReq.Params;
import com.iloen.melon.net.v6x.request.ForuTasteSubmitReq;
import com.iloen.melon.net.v6x.response.ForuTasteSongRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v6x.response.ForuTasteSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ForuTasteSongRes;
import com.iloen.melon.net.v6x.response.ForuTasteSubmitRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 D2\u00020\u0001:\u0004DEFGB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\b\u0010\u0003J\u000F\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\f\u0010\u000BJ\u000F\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0013J+\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ!\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b!\u0010\u000BJ\u000F\u0010\"\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\"\u0010\u0003J-\u0010(\u001A\u00020\t2\b\u0010$\u001A\u0004\u0018\u00010#2\b\u0010&\u001A\u0004\u0018\u00010%2\b\u0010\'\u001A\u0004\u0018\u00010\rH\u0014\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b+\u0010,J\u001B\u00100\u001A\u0006\u0012\u0002\b\u00030/2\u0006\u0010.\u001A\u00020-H\u0014\u00A2\u0006\u0004\b0\u00101R\u0018\u00103\u001A\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00106R\u0016\u00109\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u0010:R$\u0010=\u001A\u00020;2\u0006\u0010<\u001A\u00020;8\u0002@BX\u0082\u000E\u00A2\u0006\f\n\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0011\u0010C\u001A\u0002028F\u00A2\u0006\u0006\u001A\u0004\bA\u0010B\u00A8\u0006H"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "updateCompleteTv", "updateTitleBar", "showExitPopup", "callSaveSetAll", "", "isScreenLandscapeSupported", "()Z", "shouldShowMiniPlayer", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "onDestroyView", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "LJ8/O0;", "_binding", "LJ8/O0;", "selectedArtistIds", "Ljava/lang/String;", "artistIds", "tagSeqs", "isForceClose", "Z", "Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$State;", "value", "appBarState", "Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$State;", "setAppBarState", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$State;)V", "getBinding", "()LJ8/O0;", "binding", "Companion", "State", "AppBarStateChangeListener", "ForUTasteSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ForUTasteSongFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$AppBarStateChangeListener;", "Lcom/google/android/material/appbar/e;", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment;)V", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "offset", "Lie/H;", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class AppBarStateChangeListener implements e {
        @Override  // com.google.android.material.appbar.e
        public void onOffsetChanged(@NotNull AppBarLayout appBarLayout0, int v) {
            State forUTasteSongFragment$State0;
            q.g(appBarLayout0, "appBarLayout");
            ForUTasteSongFragment forUTasteSongFragment0 = ForUTasteSongFragment.this;
            if(v == 0) {
                forUTasteSongFragment$State0 = State.EXPANDED;
            }
            else {
                forUTasteSongFragment$State0 = Math.abs(v) < appBarLayout0.getTotalScrollRange() ? State.IDLE : State.COLLAPSED;
            }
            forUTasteSongFragment0.setAppBarState(forUTasteSongFragment$State0);
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment;", "selectedArtistIds", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ForUTasteSongFragment newInstance(@NotNull String s) {
            q.g(s, "selectedArtistIds");
            ForUTasteSongFragment forUTasteSongFragment0 = new ForUTasteSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            bundle0.putBoolean("argIsLoginRequired", true);
            forUTasteSongFragment0.setArguments(bundle0);
            return forUTasteSongFragment0;
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001A\u00020\u00032\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001C\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ)\u0010 \u001A\u00020\u001B2\u001A\u0010\u001F\u001A\u0016\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u001E\u0018\u0001`\u0007¢\u0006\u0004\b \u0010!J\r\u0010\"\u001A\u00020\u0010¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\u000B¢\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020\u001BH\u0016¢\u0006\u0004\b&\u0010\'R\u001A\u0010)\u001A\b\u0012\u0004\u0012\u00020\u000B0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$ForUTasteSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/SongInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "songId", "", "isSelectedSong", "(Ljava/lang/String;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/net/v6x/response/ForuTasteSongRes$RESPONSE$SONGLIST;", "songList", "addAll", "(Ljava/util/ArrayList;)V", "getSelectedSongCount", "()I", "getSelectedSongIdsText", "()Ljava/lang/String;", "clear", "()V", "", "selectedSongIdSet", "Ljava/util/Set;", "VIEW_TYPE_SONG", "I", "SongHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ForUTasteSongAdapter extends p {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$ForUTasteSongAdapter$SongHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/h2;", "itemBinding", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$ForUTasteSongAdapter;LJ8/h2;)V", "LJ8/h2;", "getItemBinding", "()LJ8/h2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SongHolder extends O0 {
            @NotNull
            private final h2 itemBinding;

            public SongHolder(@NotNull h2 h20) {
                q.g(h20, "itemBinding");
                ForUTasteSongAdapter.this = forUTasteSongFragment$ForUTasteSongAdapter0;
                super(h20.a);
                this.itemBinding = h20;
                int v = ScreenUtils.dipToPixel(forUTasteSongFragment$ForUTasteSongAdapter0.getContext(), 44.0f);
                ViewUtils.setDefaultImage(h20.h.c, v);
                h20.d.setVisibility(8);
                h20.f.setVisibility(0);
            }

            @NotNull
            public final h2 getItemBinding() {
                return this.itemBinding;
            }
        }

        private final int VIEW_TYPE_SONG;
        @NotNull
        private final Set selectedSongIdSet;

        public ForUTasteSongAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            ForUTasteSongFragment.this = forUTasteSongFragment0;
            super(context0, arrayList0);
            this.selectedSongIdSet = new LinkedHashSet();
            this.VIEW_TYPE_SONG = 1;
        }

        public final void addAll(@Nullable ArrayList arrayList0) {
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    Set set0 = this.selectedSongIdSet;
                    String s = ((SONGLIST)object0).songId;
                    if(s == null) {
                        s = "";
                    }
                    set0.add(s);
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void clear() {
            this.selectedSongIdSet.clear();
            super.clear();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_SONG;
        }

        public final int getSelectedSongCount() {
            return this.selectedSongIdSet.size();
        }

        @NotNull
        public final String getSelectedSongIdsText() {
            if(this.selectedSongIdSet.isEmpty()) {
                return "";
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: this.selectedSongIdSet) {
                stringBuilder0.append(((String)object0));
                stringBuilder0.append(",");
            }
            String s = stringBuilder0.substring(0, stringBuilder0.length() - 1);
            q.d(s);
            return s;
        }

        private final boolean isSelectedSong(String s) {
            return this.selectedSongIdSet.contains(s);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            Object object0 = this.getItem(v1);
            q.e(object0, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteSongFragment.ForUTasteSongAdapter.SongHolder");
            h2 h20 = ((SongHolder)o00).getItemBinding();
            ForUTasteSongFragment forUTasteSongFragment0 = ForUTasteSongFragment.this;
            String s = ((SongInfoBase)object0).songId;
            if(s == null) {
                s = "";
            }
            boolean z = this.isSelectedSong(s);
            RequestBuilder requestBuilder0 = Glide.with(this.getContext()).load(((SongInfoBase)object0).albumImg);
            ImageView imageView0 = h20.f;
            requestBuilder0.into(h20.h.b);
            h20.n.setText(((SongInfoBase)object0).songName);
            String s1 = ProtocolUtils.getArtistNames(((SongInfoBase)object0).artistList);
            h20.j.setText(s1);
            if(z) {
                imageView0.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                MelonAppBase.Companion.getClass();
                imageView0.setContentDescription("선택 취소 버튼");
            }
            else {
                imageView0.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                MelonAppBase.Companion.getClass();
                imageView0.setContentDescription("선택 버튼");
            }
            s s2 = new s(z, this, forUTasteSongFragment0, ((SongInfoBase)object0), v);
            h20.a.setOnClickListener(s2);
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(boolean z, ForUTasteSongAdapter forUTasteSongFragment$ForUTasteSongAdapter0, ForUTasteSongFragment forUTasteSongFragment0, SongInfoBase songInfoBase0, int v, View view0) {
            if(!z) {
                forUTasteSongFragment$ForUTasteSongAdapter0.selectedSongIdSet.add((songInfoBase0.songId == null ? "" : songInfoBase0.songId));
            }
            else if(forUTasteSongFragment$ForUTasteSongAdapter0.getCount() - forUTasteSongFragment$ForUTasteSongAdapter0.getSelectedSongCount() >= 5) {
                ToastManager.show(forUTasteSongFragment0.getString(0x7F13045F));  // string:for_u_taste_song_over_toast "최대 5곡까지 제외 가능합니다."
            }
            else {
                String s = songInfoBase0.songId;
                N.a(forUTasteSongFragment$ForUTasteSongAdapter0.selectedSongIdSet).remove(s);
            }
            forUTasteSongFragment$ForUTasteSongAdapter0.notifyItemChanged(v);
            forUTasteSongFragment0.updateCompleteTv();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            return new SongHolder(this, h2.a(LayoutInflater.from(this.getContext()), null));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteSongFragment$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "EXPANDED", "COLLAPSED", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static enum State {
        IDLE,
        EXPANDED,
        COLLAPSED;

        private static final a $ENTRIES;
        private static final State[] $VALUES;

        private static final State[] $values() [...] // Inlined contents

        static {
            State.$VALUES = arr_forUTasteSongFragment$State;
            q.g(arr_forUTasteSongFragment$State, "entries");
            State.$ENTRIES = new b(arr_forUTasteSongFragment$State);
        }

        @NotNull
        public static a getEntries() {
            return State.$ENTRIES;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[State.values().length];
            try {
                arr_v[State.COLLAPSED.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ForUTasteSongFragment";
    @Nullable
    private J8.O0 _binding;
    @NotNull
    private State appBarState;
    @NotNull
    private String artistIds;
    private boolean isForceClose;
    @NotNull
    private String selectedArtistIds;
    @NotNull
    private String tagSeqs;

    static {
        ForUTasteSongFragment.Companion = new Companion(null);
        ForUTasteSongFragment.$stable = 8;
    }

    public ForUTasteSongFragment() {
        this.selectedArtistIds = "";
        this.artistIds = "";
        this.tagSeqs = "";
        this.appBarState = State.IDLE;
    }

    private final void callSaveSetAll() {
        this.showProgress(true);
        Params foruTasteSubmitReq$Params0 = new Params();
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteSongFragment.ForUTasteSongAdapter");
        foruTasteSubmitReq$Params0.songIds = ((ForUTasteSongAdapter)j00).getSelectedSongIdsText();
        foruTasteSubmitReq$Params0.tagSeqs = this.tagSeqs;
        foruTasteSubmitReq$Params0.artistIds = this.artistIds;
        com.iloen.melon.net.RequestBuilder.newInstance(new ForuTasteSubmitReq(this.getContext(), foruTasteSubmitReq$Params0)).tag(this.getRequestTag()).listener(new v(this, 1)).errorListener(new v(this, 2)).request();
    }

    private static final void callSaveSetAll$lambda$5(ForUTasteSongFragment forUTasteSongFragment0, Object object0) {
        forUTasteSongFragment0.showProgress(false);
        if(forUTasteSongFragment0.isFragmentValid() && object0 instanceof ForuTasteSubmitRes) {
            j.b(((ForuTasteSubmitRes)object0).notification, false, 3);
            if(j.d(((HttpResponse)object0))) {
                l.a(f.i);
                forUTasteSongFragment0.isForceClose = true;
                Navigator.INSTANCE.openMainForuAndClearStack();
                return;
            }
        }
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private static final void callSaveSetAll$lambda$6(ForUTasteSongFragment forUTasteSongFragment0, VolleyError volleyError0) {
        com.iloen.melon.utils.a.v("onErrorResponse() ", HttpResponse.Companion.getErrorMessage(volleyError0), LogU.Companion, "ForUTasteSongFragment");
        forUTasteSongFragment0.showProgress(false);
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new ForUTasteSongAdapter(this, context0, null);
        ((p)j00).setHeaderParallaxEnabled(true);
        ((p)j00).setHeaderParallaxHeight(ScreenUtils.dipToPixel(context0, 35.0f));
        ((p)j00).setFooterParallaxEnabled(true);
        ((p)j00).setFooterParallaxHeight(ScreenUtils.dipToPixel(context0, 90.0f));
        return j00;
    }

    @NotNull
    public final J8.O0 getBinding() {
        J8.O0 o00 = this._binding;
        q.d(o00);
        return o00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.r.buildUpon(), "selectedArtistIds", this.selectedArtistIds, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        boolean z = super.onBackPressed();
        if(this.isForceClose) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            BaseActivity baseActivity0 = fragmentActivity0 instanceof BaseActivity ? ((BaseActivity)fragmentActivity0) : null;
            if(baseActivity0 != null) {
                baseActivity0.navigateBack();
            }
            return z;
        }
        this.showExitPopup();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        J8.O0 o00 = this.getBinding();
        q.f(o00.g, "recyclerView");
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(o00.g.getContext());
        o00.g.setLayoutManager(linearLayoutManager0);
        o00.g.setAdapter(this.mAdapter);
        q0 q00 = o00.g.getItemAnimator();
        q.e(q00, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((androidx.recyclerview.widget.q)q00).g = false;
        o00.g.setHasFixedSize(true);
        return o00.g;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        this._binding = J8.O0.a(layoutInflater0, viewGroup0);
        J8.O0 o00 = this.getBinding();
        q.f(o00.a, "getRoot(...)");
        return o00.a;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteSongFragment.ForUTasteSongAdapter");
        ((ForUTasteSongAdapter)j00).clear();
        com.iloen.melon.net.RequestBuilder.newInstance(new ForuTasteSongReq(this.getContext(), this.selectedArtistIds)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.main.foru.f(this, ((ForUTasteSongAdapter)j00), i0)).errorListener(new v(this, 0)).request();
        return true;
    }

    private static final void onFetchStart$lambda$7(ForUTasteSongFragment forUTasteSongFragment0, ForUTasteSongAdapter forUTasteSongFragment$ForUTasteSongAdapter0, i i0, ForuTasteSongRes foruTasteSongRes0) {
        if(!forUTasteSongFragment0.prepareFetchComplete(foruTasteSongRes0)) {
            return;
        }
        RESPONSE foruTasteSongRes$RESPONSE0 = foruTasteSongRes0.response;
        String s = foruTasteSongRes$RESPONSE0.artistIds;
        q.f(s, "artistIds");
        forUTasteSongFragment0.artistIds = s;
        String s1 = foruTasteSongRes$RESPONSE0.tagSeqs;
        q.f(s1, "tagSeqs");
        forUTasteSongFragment0.tagSeqs = s1;
        forUTasteSongFragment$ForUTasteSongAdapter0.addAll(foruTasteSongRes$RESPONSE0.songList);
        forUTasteSongFragment0.performFetchComplete(i0, foruTasteSongRes0);
        forUTasteSongFragment0.updateCompleteTv();
    }

    private static final void onFetchStart$lambda$8(ForUTasteSongFragment forUTasteSongFragment0, VolleyError volleyError0) {
        forUTasteSongFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argItemId");
        if(s == null) {
            s = "";
        }
        this.selectedArtistIds = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.selectedArtistIds);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        J8.O0 o00 = this.getBinding();
        AppBarStateChangeListener forUTasteSongFragment$AppBarStateChangeListener0 = new AppBarStateChangeListener(this);
        o00.b.a(forUTasteSongFragment$AppBarStateChangeListener0);
        o00.b.setOutlineProvider(null);
        J8.O0 o01 = this.getBinding();
        String s = this.getString(0x7F13045D);  // string:for_u_taste_song_guide_1 "새로운 취향을 반영해\n믹스를 만들어드릴게요!"
        o01.d.setText(s);
        J8.O0 o02 = this.getBinding();
        String s1 = this.getString(0x7F13045E);  // string:for_u_taste_song_guide_2 "원하지 않는 곡은 5곡까지 제외할 수 있어요."
        o02.e.setText(s1);
        this.setTitleBar(((TitleBar)this.getBinding().h.c));
        this.getTitleBar().a(B.a.s(2));
        J8.O0 o03 = this.getBinding();
        d d0 = new d(this, 5);
        o03.c.setOnClickListener(d0);
        this.mEmptyView = (LinearLayout)this.getBinding().f.b;
        this.updateTitleBar();
        this.updateCompleteTv();
    }

    private static final void onViewCreated$lambda$1(ForUTasteSongFragment forUTasteSongFragment0, View view0) {
        forUTasteSongFragment0.callSaveSetAll();
    }

    private final void setAppBarState(State forUTasteSongFragment$State0) {
        if(this.appBarState != forUTasteSongFragment$State0) {
            this.appBarState = forUTasteSongFragment$State0;
            this.updateTitleBar();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private final void showExitPopup() {
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F13045A);  // string:for_u_taste_exit_popup_message "선택하신 취향 설정이 완료되지\n않았어요. 그래도 그만 둘까요?"
        String s1 = this.getString(0x7F13045C);  // string:for_u_taste_exit_popup_yes "그만 할래요"
        com.melon.ui.popup.b.x(l00, null, s, false, false, this.getString(0x7F13045B), s1, new com.iloen.melon.fragments.main.foru.q(this, 2), null, null, null, 3640);  // string:for_u_taste_exit_popup_no "계속 할게요"
    }

    private static final H showExitPopup$lambda$2(ForUTasteSongFragment forUTasteSongFragment0) {
        forUTasteSongFragment0.isForceClose = true;
        forUTasteSongFragment0.performBackPress();
        return H.a;
    }

    private final void updateCompleteTv() {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteSongFragment.ForUTasteSongAdapter");
        if(((ForUTasteSongAdapter)j00).getSelectedSongCount() >= 1) {
            this.getBinding().c.setVisibility(0);
            return;
        }
        this.getBinding().c.setVisibility(8);
    }

    private final void updateTitleBar() {
        if(WhenMappings.$EnumSwitchMapping$0[this.appBarState.ordinal()] == 1) {
            this.getTitleBar().setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
            this.getTitleBar().setTitle(this.getString(0x7F130460));  // string:for_u_taste_song_title "5곡까지 제외할 수 있어요."
            return;
        }
        this.getTitleBar().setBackgroundColor(0);
        this.getTitleBar().setTitle("");
    }
}

