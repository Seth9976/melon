package com.iloen.melon.fragments.main.foru;

import Cb.j;
import De.I;
import J8.j2;
import J8.x;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.Q0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.e;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.ForuTasteArtistReq;
import com.iloen.melon.net.v6x.request.ForuTasteArtistSimilarReq.Params;
import com.iloen.melon.net.v6x.request.ForuTasteArtistSimilarReq;
import com.iloen.melon.net.v6x.response.ForuTasteArtistRes;
import com.iloen.melon.net.v6x.response.ForuTasteArtistSimilarRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ForuTasteArtistSimilarRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.net.res.common.ArtistsInfoBase;
import d2.d;
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

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u0000 =2\u00020\u0001:\u0005=>?@AB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001E\u0010\nJ\u000F\u0010\u001F\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J-\u0010%\u001A\u00020\b2\b\u0010!\u001A\u0004\u0018\u00010 2\b\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010$\u001A\u0004\u0018\u00010\fH\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010-\u001A\u0006\u0012\u0002\b\u00030,2\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.R\u0018\u00100\u001A\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00103R$\u00106\u001A\u0002042\u0006\u00105\u001A\u0002048\u0002@BX\u0082\u000E\u00A2\u0006\f\n\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010<\u001A\u00020/8F\u00A2\u0006\u0006\u001A\u0004\b:\u0010;\u00A8\u0006B"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "updateCompleteTv", "updateTitleBar", "showExitPopup", "", "isScreenLandscapeSupported", "()Z", "shouldShowMiniPlayer", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "onDestroyView", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "LJ8/O0;", "_binding", "LJ8/O0;", "isForceClose", "Z", "Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$State;", "value", "appBarState", "Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$State;", "setAppBarState", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$State;)V", "getBinding", "()LJ8/O0;", "binding", "Companion", "State", "AppBarStateChangeListener", "GridItemDecoration", "ForUTasteArtistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ForUTasteArtistFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$AppBarStateChangeListener;", "Lcom/google/android/material/appbar/e;", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment;)V", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "offset", "Lie/H;", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class AppBarStateChangeListener implements e {
        @Override  // com.google.android.material.appbar.e
        public void onOffsetChanged(@NotNull AppBarLayout appBarLayout0, int v) {
            State forUTasteArtistFragment$State0;
            q.g(appBarLayout0, "appBarLayout");
            ForUTasteArtistFragment forUTasteArtistFragment0 = ForUTasteArtistFragment.this;
            if(v == 0) {
                forUTasteArtistFragment$State0 = State.EXPANDED;
            }
            else {
                forUTasteArtistFragment$State0 = Math.abs(v) < appBarLayout0.getTotalScrollRange() ? State.IDLE : State.COLLAPSED;
            }
            forUTasteArtistFragment0.setAppBarState(forUTasteArtistFragment$State0);
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$Companion;", "", "<init>", "()V", "TAG", "", "SPAN_COUNT", "", "newInstance", "Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ForUTasteArtistFragment newInstance() {
            ForUTasteArtistFragment forUTasteArtistFragment0 = new ForUTasteArtistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsLoginRequired", true);
            forUTasteArtistFragment0.setArguments(bundle0);
            return forUTasteArtistFragment0;
        }
    }

    @SuppressLint({"AccessibilityFocus"})
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010#\n\u0002\b\b\b\u0083\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0014\u001A\u00020\r2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\r0\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001D\u001A\u00020\u00032\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u001C\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ)\u0010 \u001A\u00020\u000F2\b\u0010\u001F\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u000BH\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001A\u00020\u000B¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\r¢\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020\u000FH\u0016¢\u0006\u0004\b&\u0010\'R\u001A\u0010)\u001A\b\u0012\u0004\u0012\u00020\r0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001A\u0010+\u001A\b\u0012\u0004\u0012\u00020\r0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u001A\u0010,\u001A\b\u0012\u0004\u0012\u00020\r0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010-\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$ForUTasteArtistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/ArtistsInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "clickedPosition", "", "artistId", "Lie/H;", "fetchSimilarArtist", "(ILjava/lang/String;)V", "", "set", "makeArtistIdsText", "(Ljava/util/Set;)Ljava/lang/String;", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "getNowSelectedArtistCount", "()I", "getNowSelectedArtistIdsText", "()Ljava/lang/String;", "clear", "()V", "", "nowSelectedArtistIdSet", "Ljava/util/Set;", "onceSelectedArtistIdSet", "addedArtistIdSet", "VIEW_TYPE_ARTIST", "I", "ArtistHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ForUTasteArtistAdapter extends p {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$ForUTasteArtistAdapter$ArtistHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/j2;", "itemBinding", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$ForUTasteArtistAdapter;LJ8/j2;)V", "LJ8/j2;", "getItemBinding", "()LJ8/j2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ArtistHolder extends O0 {
            @NotNull
            private final j2 itemBinding;

            public ArtistHolder(@NotNull j2 j20) {
                q.g(j20, "itemBinding");
                ForUTasteArtistAdapter.this = forUTasteArtistFragment$ForUTasteArtistAdapter0;
                super(j20.a);
                this.itemBinding = j20;
                int v = ScreenUtils.dipToPixel(forUTasteArtistFragment$ForUTasteArtistAdapter0.getContext(), 94.0f);
                ViewUtils.setDefaultImage(((ImageView)j20.e.c), v, true);
            }

            @NotNull
            public final j2 getItemBinding() {
                return this.itemBinding;
            }
        }

        private final int VIEW_TYPE_ARTIST;
        @NotNull
        private final Set addedArtistIdSet;
        @NotNull
        private final Set nowSelectedArtistIdSet;
        @NotNull
        private final Set onceSelectedArtistIdSet;

        public ForUTasteArtistAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            ForUTasteArtistFragment.this = forUTasteArtistFragment0;
            super(context0, arrayList0);
            this.nowSelectedArtistIdSet = new LinkedHashSet();
            this.onceSelectedArtistIdSet = new LinkedHashSet();
            this.addedArtistIdSet = new LinkedHashSet();
            this.VIEW_TYPE_ARTIST = 1;
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void clear() {
            this.nowSelectedArtistIdSet.clear();
            this.onceSelectedArtistIdSet.clear();
            this.addedArtistIdSet.clear();
            super.clear();
        }

        private final void fetchSimilarArtist(int v, String s) {
            Params foruTasteArtistSimilarReq$Params0 = new Params();
            foruTasteArtistSimilarReq$Params0.artistId = s;
            foruTasteArtistSimilarReq$Params0.exArtistIds = this.makeArtistIdsText(this.addedArtistIdSet);
            RequestBuilder.newInstance(new ForuTasteArtistSimilarReq(this.getContext(), foruTasteArtistSimilarReq$Params0)).tag(ForUTasteArtistFragment.this.getRequestTag()).listener(new t(ForUTasteArtistFragment.this, this, s, v)).errorListener(new u()).request();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        private static final void fetchSimilarArtist$lambda$7(ForUTasteArtistFragment forUTasteArtistFragment0, ForUTasteArtistAdapter forUTasteArtistFragment$ForUTasteArtistAdapter0, String s, int v, Object object0) {
            if(forUTasteArtistFragment0.isFragmentValid() && object0 instanceof ForuTasteArtistSimilarRes) {
                j.b(((ForuTasteArtistSimilarRes)object0).notification, false, 3);
                if(j.d(((HttpResponse)object0))) {
                    forUTasteArtistFragment$ForUTasteArtistAdapter0.onceSelectedArtistIdSet.add(s);
                    RESPONSE foruTasteArtistSimilarRes$RESPONSE0 = ((ForuTasteArtistSimilarRes)object0).response;
                    ArrayList arrayList0 = foruTasteArtistSimilarRes$RESPONSE0 == null ? null : foruTasteArtistSimilarRes$RESPONSE0.artistList;
                    if(arrayList0 != null && !arrayList0.isEmpty() == 1) {
                        for(Object object1: arrayList0) {
                            Set set0 = forUTasteArtistFragment$ForUTasteArtistAdapter0.addedArtistIdSet;
                            String s1 = ((ArtistsInfoBase)object1).getArtistId();
                            if(s1 == null) {
                                s1 = "";
                            }
                            set0.add(s1);
                        }
                        forUTasteArtistFragment$ForUTasteArtistAdapter0.addAll(v + 1, arrayList0, false);
                        forUTasteArtistFragment$ForUTasteArtistAdapter0.notifyItemRangeInserted(v + 1, arrayList0.size());
                        forUTasteArtistFragment0.getRecyclerView().post(new r(forUTasteArtistFragment0, v, 1));
                    }
                    return;
                }
            }
            ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }

        private static final void fetchSimilarArtist$lambda$7$lambda$6(ForUTasteArtistFragment forUTasteArtistFragment0, int v) {
            O0 o00 = forUTasteArtistFragment0.getRecyclerView().findViewHolderForAdapterPosition(v);
            if(o00 != null) {
                View view0 = o00.itemView;
                if(view0 != null) {
                    view0.performAccessibilityAction(0x40, null);
                }
            }
        }

        private static final void fetchSimilarArtist$lambda$8(VolleyError volleyError0) {
            String s = HttpResponse.Companion.getErrorMessage(volleyError0);
            LogU.Companion.w("ForUTasteArtistFragment", "onErrorResponse() " + s);
            ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_ARTIST;
        }

        public final int getNowSelectedArtistCount() {
            return this.nowSelectedArtistIdSet.size();
        }

        @NotNull
        public final String getNowSelectedArtistIdsText() {
            return this.makeArtistIdsText(this.nowSelectedArtistIdSet);
        }

        private final String makeArtistIdsText(Set set0) {
            if(set0.isEmpty()) {
                return "";
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: set0) {
                stringBuilder0.append(((String)object0));
                stringBuilder0.append(",");
            }
            String s = stringBuilder0.substring(0, stringBuilder0.length() - 1);
            q.d(s);
            return s;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            Object object0 = this.getItem(v1);
            q.e(object0, "null cannot be cast to non-null type com.melon.net.res.common.ArtistsInfoBase");
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteArtistFragment.ForUTasteArtistAdapter.ArtistHolder");
            j2 j20 = ((ArtistHolder)o00).getItemBinding();
            ForUTasteArtistFragment forUTasteArtistFragment0 = ForUTasteArtistFragment.this;
            boolean z = je.p.d0(this.nowSelectedArtistIdSet, ((ArtistsInfoBase)object0).getArtistId());
            com.bumptech.glide.RequestBuilder requestBuilder0 = Glide.with(this.getContext()).load(((ArtistsInfoBase)object0).getArtistImg()).apply(RequestOptions.circleCropTransform());
            LinearLayout linearLayout0 = j20.a;
            ImageView imageView0 = j20.c;
            ImageView imageView1 = j20.d;
            requestBuilder0.into(((BorderImageView)j20.e.d));
            MelonTextView melonTextView0 = j20.b;
            melonTextView0.setText(((ArtistsInfoBase)object0).getArtistName());
            if(z) {
                imageView1.setVisibility(0);
                imageView0.setVisibility(0);
                melonTextView0.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06017A));  // color:green500e_support_high_contrast
            }
            else {
                imageView1.setVisibility(8);
                imageView0.setVisibility(8);
                melonTextView0.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060169));  // color:gray850s
            }
            ViewUtils.setContentDescriptionWithButtonClassName(linearLayout0, (z ? va.e.c(forUTasteArtistFragment0.getString(0x7F130C44), ", ", ((ArtistsInfoBase)object0).getArtistName()) : ((ArtistsInfoBase)object0).getArtistName()));  // string:talkback_selected "선택됨"
            linearLayout0.setOnClickListener(new s(this, ((ArtistsInfoBase)object0), z, forUTasteArtistFragment0, v1));
        }

        private static final void onBindViewImpl$lambda$2$lambda$1(ForUTasteArtistAdapter forUTasteArtistFragment$ForUTasteArtistAdapter0, ArtistsInfoBase artistsInfoBase0, boolean z, ForUTasteArtistFragment forUTasteArtistFragment0, int v, View view0) {
            String s = "";
            int v1 = forUTasteArtistFragment$ForUTasteArtistAdapter0.getPosition(artistsInfoBase0);
            boolean z1 = true;
            if(z) {
                N.a(forUTasteArtistFragment$ForUTasteArtistAdapter0.nowSelectedArtistIdSet).remove(artistsInfoBase0.getArtistId());
            }
            else {
                if(forUTasteArtistFragment$ForUTasteArtistAdapter0.getNowSelectedArtistCount() >= 30) {
                    ToastManager.show(forUTasteArtistFragment0.getString(0x7F130458));  // string:for_u_taste_artist_over_toast "최대 30명까지 선택 가능합니다."
                    return;
                }
                if(je.p.d0(forUTasteArtistFragment$ForUTasteArtistAdapter0.onceSelectedArtistIdSet, artistsInfoBase0.getArtistId())) {
                    Set set0 = forUTasteArtistFragment$ForUTasteArtistAdapter0.nowSelectedArtistIdSet;
                    String s1 = artistsInfoBase0.getArtistId();
                    if(s1 != null) {
                        s = s1;
                    }
                    set0.add(s);
                }
                else {
                    forUTasteArtistFragment$ForUTasteArtistAdapter0.fetchSimilarArtist(v1, (artistsInfoBase0.getArtistId() == null ? "" : artistsInfoBase0.getArtistId()));
                    Set set1 = forUTasteArtistFragment$ForUTasteArtistAdapter0.nowSelectedArtistIdSet;
                    String s2 = artistsInfoBase0.getArtistId();
                    if(s2 != null) {
                        s = s2;
                    }
                    set1.add(s);
                    z1 = false;
                }
            }
            forUTasteArtistFragment$ForUTasteArtistAdapter0.notifyItemChanged(v1);
            if(z1) {
                forUTasteArtistFragment0.getRecyclerView().post(new r(forUTasteArtistFragment0, v, 0));
            }
            forUTasteArtistFragment0.updateCompleteTv();
        }

        private static final void onBindViewImpl$lambda$2$lambda$1$lambda$0(ForUTasteArtistFragment forUTasteArtistFragment0, int v) {
            O0 o00 = forUTasteArtistFragment0.getRecyclerView().findViewHolderForAdapterPosition(v);
            if(o00 != null) {
                View view0 = o00.itemView;
                if(view0 != null) {
                    view0.performAccessibilityAction(0x40, null);
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04B6, null, false);  // layout:listitem_taste_artist
            int v1 = 0x7F0A00C2;  // id:artist_tv
            View view1 = I.C(view0, 0x7F0A00C2);  // id:artist_tv
            if(((MelonTextView)view1) != null) {
                v1 = 0x7F0A0252;  // id:check_iv
                View view2 = I.C(view0, 0x7F0A0252);  // id:check_iv
                if(((ImageView)view2) != null && ((Guideline)I.C(view0, 0x7F0A0514)) != null && ((Guideline)I.C(view0, 0x7F0A0515)) != null) {  // id:guideline_check_iv_bottom
                    v1 = 0x7F0A0A5E;  // id:selected_dim_iv
                    View view3 = I.C(view0, 0x7F0A0A5E);  // id:selected_dim_iv
                    if(((ImageView)view3) != null) {
                        v1 = 0x7F0A0B79;  // id:thumb_layout
                        View view4 = I.C(view0, 0x7F0A0B79);  // id:thumb_layout
                        if(view4 != null) {
                            return new ArtistHolder(this, new j2(((LinearLayout)view0), ((MelonTextView)view1), ((ImageView)view2), ((ImageView)view3), x.b(view4)));
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$GridItemDecoration;", "Landroidx/recyclerview/widget/r0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "", "horizontalSpacing", "I", "getHorizontalSpacing", "()I", "topSpacing", "getTopSpacing", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class GridItemDecoration extends r0 {
        private final int horizontalSpacing;
        private final int topSpacing;

        public GridItemDecoration(@NotNull Context context0) {
            q.g(context0, "context");
            super();
            this.horizontalSpacing = ScreenUtils.dipToPixel(context0, 19.0f);
            this.topSpacing = ScreenUtils.dipToPixel(context0, 35.0f);
        }

        public final int getHorizontalSpacing() {
            return this.horizontalSpacing;
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            int v = recyclerView0.getChildAdapterPosition(view0);
            rect0.left = v % 3 * this.horizontalSpacing / 3;
            rect0.right = this.horizontalSpacing - (v % 3 + 1) * this.horizontalSpacing / 3;
            rect0.top = this.topSpacing;
        }

        public final int getTopSpacing() {
            return this.topSpacing;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUTasteArtistFragment$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "EXPANDED", "COLLAPSED", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static enum State {
        IDLE,
        EXPANDED,
        COLLAPSED;

        private static final a $ENTRIES;
        private static final State[] $VALUES;

        private static final State[] $values() [...] // Inlined contents

        static {
            State.$VALUES = arr_forUTasteArtistFragment$State;
            q.g(arr_forUTasteArtistFragment$State, "entries");
            State.$ENTRIES = new b(arr_forUTasteArtistFragment$State);
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
    private static final int SPAN_COUNT = 3;
    @NotNull
    private static final String TAG = "ForUTasteArtistFragment";
    @Nullable
    private J8.O0 _binding;
    @NotNull
    private State appBarState;
    private boolean isForceClose;

    static {
        ForUTasteArtistFragment.Companion = new Companion(null);
        ForUTasteArtistFragment.$stable = 8;
    }

    public ForUTasteArtistFragment() {
        this.appBarState = State.IDLE;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new ForUTasteArtistAdapter(this, context0, null);
        ((p)j00).setFooterParallaxEnabled(true);
        ((p)j00).setFooterParallaxHeight(ScreenUtils.dipToPixel(context0, 55.0f));
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
        String s = MelonContentUris.o.buildUpon().build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @NotNull
    public static final ForUTasteArtistFragment newInstance() {
        return ForUTasteArtistFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        boolean z = super.onBackPressed();
        if(this.isForceClose) {
            return z;
        }
        this.showExitPopup();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = this.getBinding().g;
        q.f(recyclerView0, "recyclerView");
        recyclerView0.setAdapter(this.mAdapter);
        recyclerView0.setLayoutManager(new GridLayoutManager(recyclerView0.getContext(), 3));
        Context context0 = recyclerView0.getContext();
        q.f(context0, "getContext(...)");
        recyclerView0.addItemDecoration(new GridItemDecoration(context0));
        recyclerView0.setHasFixedSize(false);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = recyclerView0.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            int v = ScreenUtils.dipToPixel(recyclerView0.getContext(), 20.0f);
            viewGroup$MarginLayoutParams0.setMarginStart(v);
            viewGroup$MarginLayoutParams0.setMarginEnd(v);
        }
        recyclerView0.setAccessibilityDelegateCompat(new Q0(/*ERROR_MISSING_ARG_0/*) {
            @Override  // androidx.recyclerview.widget.Q0
            public void onInitializeAccessibilityNodeInfo(View view0, d d0) {
                q.g(view0, "host");
                q.g(d0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.m(null);
            }
        });
        return recyclerView0;
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
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteArtistFragment.ForUTasteArtistAdapter");
        ((ForUTasteArtistAdapter)j00).clear();
        RequestBuilder.newInstance(new ForuTasteArtistReq(this.getContext())).tag(this.getRequestTag()).listener(new g(4, this, i0)).errorListener(new com.iloen.melon.fragments.main.foru.a(this)).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(ForUTasteArtistFragment forUTasteArtistFragment0, i i0, ForuTasteArtistRes foruTasteArtistRes0) {
        if(!forUTasteArtistFragment0.prepareFetchComplete(foruTasteArtistRes0)) {
            return;
        }
        forUTasteArtistFragment0.performFetchComplete(i0, foruTasteArtistRes0);
        forUTasteArtistFragment0.updateCompleteTv();
    }

    private static final void onFetchStart$lambda$4(ForUTasteArtistFragment forUTasteArtistFragment0, VolleyError volleyError0) {
        forUTasteArtistFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        J8.O0 o00 = this.getBinding();
        AppBarStateChangeListener forUTasteArtistFragment$AppBarStateChangeListener0 = new AppBarStateChangeListener(this);
        o00.b.a(forUTasteArtistFragment$AppBarStateChangeListener0);
        o00.b.setOutlineProvider(null);
        J8.O0 o01 = this.getBinding();
        String s = this.getString(0x7F130457);  // string:for_u_taste_artist_guide_1 "좋아하는 아티스트를\n선택해 주세요."
        o01.d.setText(s);
        J8.O0 o02 = this.getBinding();
        String s1 = this.getString(0x7F130459);  // string:for_u_taste_artist_title "5명 이상 선택해 주세요."
        o02.e.setText(s1);
        this.setTitleBar(((TitleBar)this.getBinding().h.c));
        this.getTitleBar().a(B.a.s(2));
        J8.O0 o03 = this.getBinding();
        com.iloen.melon.fragments.main.foru.d d0 = new com.iloen.melon.fragments.main.foru.d(this, 4);
        o03.c.setOnClickListener(d0);
        ViewUtilsKt.setAccessibilityButtonClassName(this.getBinding().c);
        this.mEmptyView = (LinearLayout)this.getBinding().f.b;
        this.updateTitleBar();
        this.updateCompleteTv();
    }

    private static final void onViewCreated$lambda$1(ForUTasteArtistFragment forUTasteArtistFragment0, View view0) {
        j0 j00 = forUTasteArtistFragment0.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteArtistFragment.ForUTasteArtistAdapter");
        String s = ((ForUTasteArtistAdapter)j00).getNowSelectedArtistIdsText();
        Navigator.open(ForUTasteSongFragment.Companion.newInstance(s));
    }

    private final void setAppBarState(State forUTasteArtistFragment$State0) {
        if(this.appBarState != forUTasteArtistFragment$State0) {
            this.appBarState = forUTasteArtistFragment$State0;
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
        com.melon.ui.popup.b.x(l00, null, s, false, false, this.getString(0x7F13045B), s1, new com.iloen.melon.fragments.main.foru.q(this, 1), null, null, null, 3640);  // string:for_u_taste_exit_popup_no "계속 할게요"
    }

    private static final H showExitPopup$lambda$2(ForUTasteArtistFragment forUTasteArtistFragment0) {
        forUTasteArtistFragment0.isForceClose = true;
        forUTasteArtistFragment0.performBackPress();
        return H.a;
    }

    private final void updateCompleteTv() {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUTasteArtistFragment.ForUTasteArtistAdapter");
        if(((ForUTasteArtistAdapter)j00).getNowSelectedArtistCount() >= 5) {
            this.getBinding().c.setVisibility(0);
            return;
        }
        this.getBinding().c.setVisibility(8);
    }

    private final void updateTitleBar() {
        if(WhenMappings.$EnumSwitchMapping$0[this.appBarState.ordinal()] == 1) {
            this.getTitleBar().setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
            this.getTitleBar().setTitle(this.getString(0x7F130459));  // string:for_u_taste_artist_title "5명 이상 선택해 주세요."
            return;
        }
        this.getTitleBar().setBackgroundColor(0);
        this.getTitleBar().setTitle("");
    }
}

