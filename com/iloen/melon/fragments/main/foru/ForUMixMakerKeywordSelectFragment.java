package com.iloen.melon.fragments.main.foru;

import B.a;
import De.I;
import J8.K0;
import J8.L0;
import J8.M0;
import J8.N0;
import J8.Z0;
import J8.x;
import Tf.o;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.flexbox.FlexboxLayout;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.MixMakerPlaylistDetailFragment;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.ForuMixMakerKeywordSelectReq;
import com.iloen.melon.net.v6x.response.ForuMixMakerKeywordSelectRes.RESPONSE.RELTAGLIST;
import com.iloen.melon.net.v6x.response.ForuMixMakerKeywordSelectRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ForuMixMakerKeywordSelectRes;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewTreeObserverHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;

@Metadata(d1 = {"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\r\u0010\fJ\u000F\u0010\u000E\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0006J\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0013J+\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ!\u0010\u001F\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b!\u0010\u0003J\u000F\u0010\"\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\"\u0010\u0003J\u0017\u0010%\u001A\u00020\u00112\u0006\u0010$\u001A\u00020#H\u0016\u00A2\u0006\u0004\b%\u0010&J-\u0010,\u001A\u00020\n2\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010*\u001A\u0004\u0018\u00010)2\b\u0010+\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010/\u001A\u00020.H\u0014\u00A2\u0006\u0004\b/\u00100J\u001B\u00104\u001A\u0006\u0012\u0002\b\u0003032\u0006\u00102\u001A\u000201H\u0014\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b6\u0010\fR&\u0010:\u001A\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`98\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001A\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001A\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001A\u00020A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001A\u00020\n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001A\u00020\n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010ER\u0018\u0010H\u001A\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0011\u0010L\u001A\u00020<8F\u00A2\u0006\u0006\u001A\u0004\bJ\u0010K\u00A8\u0006O"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getSearchKeyword", "()Ljava/lang/String;", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "", "isScreenLandscapeSupported", "()Z", "shouldShowMiniPlayer", "getCacheKey", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onForeground", "onDestroyView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "onBackPressed", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "Lkotlin/collections/ArrayList;", "nowSelectedTagList", "Ljava/util/ArrayList;", "LJ8/Z0;", "_binding", "LJ8/Z0;", "recentDeletedTag", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "", "recentDeletedTagPosition", "I", "isLoading", "Z", "isGoingBack", "Lcom/iloen/melon/utils/ui/ViewTreeObserverHelper;", "observerHelper", "Lcom/iloen/melon/utils/ui/ViewTreeObserverHelper;", "getBinding", "()LJ8/Z0;", "binding", "Companion", "MixMakerKeywordSelectAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ForUMixMakerKeywordSelectFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\t\u001A\u00020\n2\u0016\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_NOW_SELECTED_TAG_LIST", "FETCH_REASON_AFTER_ADD", "FETCH_REASON_AFTER_DELETE", "newInstance", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment;", "nowSelectedTag", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "Lkotlin/collections/ArrayList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ForUMixMakerKeywordSelectFragment newInstance(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "nowSelectedTag");
            ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0 = new ForUMixMakerKeywordSelectFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelableArrayList("argNowSelectedTagList", arrayList0);
            forUMixMakerKeywordSelectFragment0.setArguments(bundle0);
            return forUMixMakerKeywordSelectFragment0;
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0082\u0004\u0018\u00002\u0016\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u000534567B;\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012*\u0010\t\u001A&\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u0003\u0018\u00010\u0007j\u0012\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u0003\u0018\u0001`\b\u00A2\u0006\u0004\b\n\u0010\u000BJ+\u0010\r\u001A\u00020\f2\u001A\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\bH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ)\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001D\u001A\u00020\u00132\b\u0010\u0018\u001A\u0004\u0018\u00010\f2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010\"\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\"\u0010#J!\u0010&\u001A\u00020\u00042\b\u0010$\u001A\u0004\u0018\u00010\u000F2\u0006\u0010%\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b&\u0010\'J\'\u0010*\u001A\u00020)2\u0006\u0010(\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020\u001F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020\u001F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001A\u00020\u001F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b/\u0010-R\u001A\u00100\u001A\u00020\u001F8\u0006X\u0086D\u00A2\u0006\f\n\u0004\b0\u0010-\u001A\u0004\b1\u00102\u00A8\u00068"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter$ServerDataWrapper;", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "makeSongListText", "(Ljava/util/ArrayList;)Ljava/lang/String;", "Landroid/view/ViewGroup;", "root", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "tag", "", "isLoading", "Landroid/view/View;", "getSelectedTagView", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/main/foru/SelectedTag;Z)Landroid/view/View;", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SELECTED", "I", "VIEW_TYPE_RELTAGLIST", "VIEW_TYPE_PREVIEW", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "()I", "SelectedKeywordHolder", "RelTagListHolder", "PreviewHolder", "LoadingHolder", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MixMakerKeywordSelectAdapter extends p {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter$LoadingHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/K0;", "itemBinding", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter;LJ8/K0;)V", "LJ8/K0;", "getItemBinding", "()LJ8/K0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LoadingHolder extends O0 {
            @NotNull
            private final K0 itemBinding;

            public LoadingHolder(@NotNull K0 k00) {
                q.g(k00, "itemBinding");
                MixMakerKeywordSelectAdapter.this = forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0;
                super(k00.a);
                this.itemBinding = k00;
                Glide.with(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getContext()).load(0x7F080715).into(new CustomTarget() {  // drawable:mix_loading
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    public void onResourceReady(Drawable drawable0, Transition transition0) {
                        q.g(drawable0, "resource");
                        ForUMixMakerKeywordSelectFragment.this.getItemBinding().b.setImageDrawable(drawable0);
                        if(drawable0 instanceof Animatable) {
                            ((Animatable)drawable0).start();
                            BottomTabBaseFragment bottomTabBaseFragment0 = ForUMixMakerKeywordSelectFragment.this.getCurrentTabContainerFragment();
                            new Handler(Looper.getMainLooper()).postDelayed(new j(ForUMixMakerKeywordSelectFragment.this, bottomTabBaseFragment0), 2500L);
                        }
                    }

                    @Override  // com.bumptech.glide.request.target.Target
                    public void onResourceReady(Object object0, Transition transition0) {
                        this.onResourceReady(((Drawable)object0), transition0);
                    }

                    private static final void onResourceReady$lambda$0(ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, BottomTabBaseFragment bottomTabBaseFragment0) {
                        if(!forUMixMakerKeywordSelectFragment0.isGoingBack) {
                            forUMixMakerKeywordSelectFragment0.isLoading = false;
                            String s = ForUMixMakerKeywordSelectFragment.access$getSearchKeyword(forUMixMakerKeywordSelectFragment0);
                            bottomTabBaseFragment0.addFragment(MixMakerPlaylistDetailFragment.Companion.newInstance(s, 2), null, null);
                        }
                    }
                });
            }

            @NotNull
            public final K0 getItemBinding() {
                return this.itemBinding;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter$PreviewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/L0;", "itemBinding", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter;LJ8/L0;)V", "LJ8/L0;", "getItemBinding", "()LJ8/L0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class PreviewHolder extends O0 {
            @NotNull
            private final L0 itemBinding;

            public PreviewHolder(@NotNull L0 l00) {
                q.g(l00, "itemBinding");
                MixMakerKeywordSelectAdapter.this = forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0;
                super(l00.a);
                this.itemBinding = l00;
                int v = ScreenUtils.dipToPixel(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getContext(), 100.0f);
                int v1 = ScreenUtils.dipToPixel(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getContext(), 132.0f);
                ViewUtils.setDefaultImage(((ImageView)l00.c.c), v, true);
                ViewUtils.setDefaultImage(((ImageView)l00.b.c), v1, true);
                ViewUtils.setDefaultImage(((ImageView)l00.d.c), v, true);
            }

            @NotNull
            public final L0 getItemBinding() {
                return this.itemBinding;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter$RelTagListHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/M0;", "itemBinding", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter;LJ8/M0;)V", "LJ8/M0;", "getItemBinding", "()LJ8/M0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class RelTagListHolder extends O0 {
            @NotNull
            private final M0 itemBinding;

            public RelTagListHolder(@NotNull M0 m00) {
                q.g(m00, "itemBinding");
                MixMakerKeywordSelectAdapter.this = forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0;
                super(m00.a);
                this.itemBinding = m00;
            }

            @NotNull
            public final M0 getItemBinding() {
                return this.itemBinding;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter$SelectedKeywordHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/N0;", "itemBinding", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter;LJ8/N0;)V", "LJ8/N0;", "getItemBinding", "()LJ8/N0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SelectedKeywordHolder extends O0 {
            @NotNull
            private final N0 itemBinding;

            public SelectedKeywordHolder(@NotNull N0 n00) {
                q.g(n00, "itemBinding");
                MixMakerKeywordSelectAdapter.this = forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0;
                super(n00.a);
                this.itemBinding = n00;
            }

            @NotNull
            public final N0 getItemBinding() {
                return this.itemBinding;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter$ServerDataWrapper;", "", "viewType", "", "data", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter;ILjava/lang/Object;)V", "getViewType", "()I", "getData", "()Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class ServerDataWrapper {
            @Nullable
            private final Object data;
            private final int viewType;

            public ServerDataWrapper(int v, @Nullable Object object0) {
                this.viewType = v;
                this.data = object0;
            }

            public ServerDataWrapper(int v, Object object0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
                if((v1 & 2) != 0) {
                    object0 = null;
                }
                this(v, object0);
            }

            @Nullable
            public final Object getData() {
                return this.data;
            }

            public final int getViewType() {
                return this.viewType;
            }
        }

        private final int VIEW_TYPE_LOADING;
        private final int VIEW_TYPE_PREVIEW;
        private final int VIEW_TYPE_RELTAGLIST;
        private final int VIEW_TYPE_SELECTED;

        public MixMakerKeywordSelectAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            ForUMixMakerKeywordSelectFragment.this = forUMixMakerKeywordSelectFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_SELECTED = 1;
            this.VIEW_TYPE_RELTAGLIST = 2;
            this.VIEW_TYPE_PREVIEW = 3;
            this.VIEW_TYPE_LOADING = 4;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return ((ServerDataWrapper)this.getItem(v1)).getViewType();
        }

        private final View getSelectedTagView(ViewGroup viewGroup0, SelectedTag selectedTag0, boolean z) {
            Context context0 = this.getContext();
            Object object0 = context0 == null ? null : context0.getSystemService("layout_inflater");
            q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
            View view0 = ((LayoutInflater)object0).inflate(0x7F0D051D, viewGroup0, false);  // layout:mix_maker_selected_keyword_item_layout
            View view1 = view0.findViewById(0x7F0A0D25);  // id:tv_text
            q.f(view1, "findViewById(...)");
            String s = selectedTag0.getEmoji();
            ((TextView)view1).setText((s == null || o.H0(s) ? selectedTag0.getTagName() : selectedTag0.getEmoji() + " " + selectedTag0.getTagName()));
            if(!z) {
                View view2 = view0.findViewById(0x7F0A061D);  // id:iv_delete
                view2.setVisibility(0);
                ((ConstraintLayout)view0).setMaxWidth(ScreenUtils.dipToPixel(view2.getContext(), 161.0f));
                view0.findViewById(0x7F0A0DBF).setOnClickListener(new h(view0, ForUMixMakerKeywordSelectFragment.this, this));  // id:view_click_area
                View view3 = view0.findViewById(0x7F0A061D);  // id:iv_delete
                q.f(view3, "findViewById(...)");
                view0.setOnTouchListener(new i(((TextView)view1), this, view3));
            }
            return view0;
        }

        public static View getSelectedTagView$default(MixMakerKeywordSelectAdapter forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0, ViewGroup viewGroup0, SelectedTag selectedTag0, boolean z, int v, Object object0) {
            if((v & 4) != 0) {
                z = false;
            }
            return forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getSelectedTagView(viewGroup0, selectedTag0, z);
        }

        private static final void getSelectedTagView$lambda$11(View view0, ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, MixMakerKeywordSelectAdapter forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0, View view1) {
            ViewParent viewParent0 = view0.getParent();
            q.e(viewParent0, "null cannot be cast to non-null type android.view.ViewGroup");
            int v = ((ViewGroup)viewParent0).indexOfChild(view0);
            ArrayList arrayList0 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
            if(arrayList0 != null) {
                if(v < arrayList0.size()) {
                    ArrayList arrayList1 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
                    if(arrayList1 != null) {
                        forUMixMakerKeywordSelectFragment0.recentDeletedTag = (SelectedTag)arrayList1.get(v);
                        forUMixMakerKeywordSelectFragment0.recentDeletedTagPosition = v;
                        ArrayList arrayList2 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
                        if(arrayList2 != null) {
                            arrayList2.remove(v);
                            forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.clearCache(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getCacheKey());
                            ArrayList arrayList3 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
                            if(arrayList3 != null) {
                                if(arrayList3.size() > 0) {
                                    forUMixMakerKeywordSelectFragment0.startFetch("after delete");
                                    return;
                                }
                                forUMixMakerKeywordSelectFragment0.performBackPress();
                                return;
                            }
                            q.m("nowSelectedTagList");
                            throw null;
                        }
                        q.m("nowSelectedTagList");
                        throw null;
                    }
                    q.m("nowSelectedTagList");
                    throw null;
                }
                return;
            }
            q.m("nowSelectedTagList");
            throw null;
        }

        private static final boolean getSelectedTagView$lambda$12(TextView textView0, MixMakerKeywordSelectAdapter forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0, View view0, View view1, MotionEvent motionEvent0) {
            switch(motionEvent0.getAction()) {
                case 0: {
                    textView0.setTextColor(ColorUtils.getColor(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getContext(), 0x7F0604B4));  // color:white500e_support_high_contrast
                    view0.setAlpha(0.5f);
                    return true;
                }
                case 1: {
                    textView0.setTextColor(ColorUtils.getColor(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getContext(), 0x7F0604A1));  // color:white000e
                    view0.setAlpha(1.0f);
                    view1.performClick();
                    return true;
                }
                case 2: {
                    break;
                }
                default: {
                    textView0.setTextColor(ColorUtils.getColor(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getContext(), 0x7F0604A1));  // color:white000e
                    view0.setAlpha(1.0f);
                    break;
                }
            }
            return false;
        }

        public final int getVIEW_TYPE_LOADING() {
            return this.VIEW_TYPE_LOADING;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable v9.i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ForuMixMakerKeywordSelectRes) {
                RESPONSE foruMixMakerKeywordSelectRes$RESPONSE0 = ((ForuMixMakerKeywordSelectRes)httpResponse0).response;
                if(foruMixMakerKeywordSelectRes$RESPONSE0 == null) {
                    return false;
                }
                this.setMenuId(foruMixMakerKeywordSelectRes$RESPONSE0.menuId);
                this.updateModifiedTime(this.getCacheKey());
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_SELECTED, null, 2, null));
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_RELTAGLIST, foruMixMakerKeywordSelectRes$RESPONSE0.relTagList));
                this.add(new ServerDataWrapper(this, this.VIEW_TYPE_PREVIEW, foruMixMakerKeywordSelectRes$RESPONSE0));
            }
            return true;
        }

        private final String makeSongListText(ArrayList arrayList0) {
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                StringBuilder stringBuilder0 = new StringBuilder();
                for(Object object0: arrayList0) {
                    stringBuilder0.append(((String)object0));
                    stringBuilder0.append(", ");
                }
                String s = stringBuilder0.substring(0, stringBuilder0.length() - 2);
                q.d(s);
                return s;
            }
            return "";
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            float f = 1.0f;
            boolean z = true;
            if(o00 instanceof SelectedKeywordHolder) {
                FlexboxLayout flexboxLayout0 = ((SelectedKeywordHolder)o00).getItemBinding().b;
                if(flexboxLayout0.getChildCount() > 0) {
                    flexboxLayout0.removeAllViews();
                }
                ArrayList arrayList0 = ForUMixMakerKeywordSelectFragment.this.nowSelectedTagList;
                if(arrayList0 != null) {
                    for(Object object0: arrayList0) {
                        flexboxLayout0.addView(MixMakerKeywordSelectAdapter.getSelectedTagView$default(this, flexboxLayout0, ((SelectedTag)object0), false, 4, null));
                    }
                    Context context0 = this.getContext();
                    Object object1 = context0 == null ? null : context0.getSystemService("layout_inflater");
                    q.e(object1, "null cannot be cast to non-null type android.view.LayoutInflater");
                    View view0 = ((LayoutInflater)object1).inflate(0x7F0D051A, flexboxLayout0, false);  // layout:mix_maker_add_item_layout
                    ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0 = ForUMixMakerKeywordSelectFragment.this;
                    ArrayList arrayList1 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
                    if(arrayList1 != null) {
                        if(arrayList1.size() < 3) {
                            z = false;
                        }
                        else {
                            f = 0.3f;
                        }
                        view0.setAlpha(f);
                        view0.setOnClickListener(new e(forUMixMakerKeywordSelectFragment0, z));
                        flexboxLayout0.addView(view0);
                        return;
                    }
                    q.m("nowSelectedTagList");
                    throw null;
                }
                q.m("nowSelectedTagList");
                throw null;
            }
            if(o00 instanceof RelTagListHolder) {
                Object object2 = this.getItem(v1);
                q.e(object2, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordSelectFragment.MixMakerKeywordSelectAdapter.ServerDataWrapper");
                Object object3 = ((ServerDataWrapper)object2).getData();
                q.e(object3, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.net.v6x.response.ForuMixMakerKeywordSelectRes.RESPONSE.RELTAGLIST>");
                MixMakerTagCollectionView mixMakerTagCollectionView0 = ((RelTagListHolder)o00).getItemBinding().b;
                ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment1 = ForUMixMakerKeywordSelectFragment.this;
                if(ScreenUtils.isTablet(mixMakerTagCollectionView0.getContext())) {
                    int v2 = ScreenUtils.dipToPixel(mixMakerTagCollectionView0.getContext(), 36.0f);
                    mixMakerTagCollectionView0.setPadding(v2, 0, v2, 0);
                    mixMakerTagCollectionView0.setRowWidth(ScreenUtils.getScreenWidth(mixMakerTagCollectionView0.getContext()) - v2 * 2);
                    mixMakerTagCollectionView0.setMaxRowCount(3);
                }
                mixMakerTagCollectionView0.setItemLayoutRes(0x7F0D051E);  // layout:mix_maker_unselected_keyword_item_layout
                mixMakerTagCollectionView0.setItems(((ArrayList)object3));
                mixMakerTagCollectionView0.setOnItemClickListener(new f(forUMixMakerKeywordSelectFragment1, ((ArrayList)object3), this));
                if(ForUMixMakerKeywordSelectFragment.this.observerHelper != null) {
                    ViewTreeObserverHelper viewTreeObserverHelper0 = ForUMixMakerKeywordSelectFragment.this.observerHelper;
                    if(viewTreeObserverHelper0 != null) {
                        viewTreeObserverHelper0.unregisterGlobalLayoutListener();
                    }
                    ForUMixMakerKeywordSelectFragment.this.observerHelper = null;
                }
                ViewTreeObserverHelper viewTreeObserverHelper1 = new ViewTreeObserverHelper();
                M0 m00 = ((RelTagListHolder)o00).getItemBinding();
                g g0 = new g(0, o00, this);
                viewTreeObserverHelper1.registerGlobalLayoutListener(m00.b, g0);
                ForUMixMakerKeywordSelectFragment.this.observerHelper = viewTreeObserverHelper1;
                return;
            }
            if(o00 instanceof PreviewHolder) {
                Object object4 = this.getItem(v1);
                q.e(object4, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordSelectFragment.MixMakerKeywordSelectAdapter.ServerDataWrapper");
                Object object5 = ((ServerDataWrapper)object4).getData();
                q.e(object5, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ForuMixMakerKeywordSelectRes.RESPONSE");
                L0 l00 = ((PreviewHolder)o00).getItemBinding();
                RequestManager requestManager0 = Glide.with(this.getContext());
                MelonTextView melonTextView0 = l00.e;
                BorderImageView borderImageView0 = (BorderImageView)l00.d.d;
                BorderImageView borderImageView1 = (BorderImageView)l00.b.d;
                requestManager0.clear(((BorderImageView)l00.c.d));
                Glide.with(this.getContext()).clear(borderImageView1);
                Glide.with(this.getContext()).clear(borderImageView0);
                ArrayList arrayList2 = ((RESPONSE)object5).songNameList;
                if(arrayList2 != null && arrayList2.size() > 2) {
                    ForUMixMakerKeywordSelectFragment.this.getBinding().b.setEnabled(true);
                    ForUMixMakerKeywordSelectFragment.this.getBinding().e.setAlpha(1.0f);
                    ArrayList arrayList3 = ((RESPONSE)object5).artistImgUrlList;
                    if(arrayList3.size() >= 1) {
                        Glide.with(this.getContext()).load(((String)arrayList3.get(0))).apply(RequestOptions.circleCropTransform()).into(borderImageView1);
                    }
                    if(arrayList3.size() >= 2) {
                        Glide.with(this.getContext()).load(((String)arrayList3.get(1))).apply(RequestOptions.circleCropTransform()).into(((BorderImageView)l00.c.d));
                    }
                    if(arrayList3.size() >= 3) {
                        Glide.with(this.getContext()).load(((String)arrayList3.get(2))).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
                    }
                    melonTextView0.setText(this.makeSongListText(((RESPONSE)object5).songNameList));
                    return;
                }
                melonTextView0.setText(ForUMixMakerKeywordSelectFragment.this.getString(0x7F13044C));  // string:for_u_mix_maker_empty_result "어울리는 선곡이 없어요.\n다른 키워드를 선택해 주세요."
                ForUMixMakerKeywordSelectFragment.this.getBinding().b.setEnabled(false);
                ForUMixMakerKeywordSelectFragment.this.getBinding().e.setAlpha(0.3f);
                return;
            }
            if(o00 instanceof LoadingHolder) {
                K0 k00 = ((LoadingHolder)o00).getItemBinding();
                if(ScreenUtils.isTablet(this.getContext())) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = k00.c.getLayoutParams();
                    q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ((LayoutParams)viewGroup$LayoutParams0).height = -1;
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = k00.d.getLayoutParams();
                    q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    ((LinearLayout.LayoutParams)viewGroup$LayoutParams1).topMargin = ScreenUtils.dipToPixel(this.getContext(), 30.0f);
                }
                FlexboxLayout flexboxLayout1 = k00.d;
                if(flexboxLayout1.getChildCount() > 0) {
                    flexboxLayout1.removeAllViews();
                }
                ArrayList arrayList4 = ForUMixMakerKeywordSelectFragment.this.nowSelectedTagList;
                if(arrayList4 != null) {
                    for(Object object6: arrayList4) {
                        flexboxLayout1.addView(this.getSelectedTagView(flexboxLayout1, ((SelectedTag)object6), true));
                    }
                    return;
                }
                q.m("nowSelectedTagList");
                throw null;
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$1(boolean z, ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, View view0) {
            if(z) {
                ToastManager.show(0x7F130450);  // string:for_u_mix_maker_keyword_over_toast "키워드는 최대 3개까지 추가 가능합니다."
                return;
            }
            MenuIdQueue.getInstance().setSkipAction(true);
            FragmentActivity fragmentActivity0 = forUMixMakerKeywordSelectFragment0.getActivity();
            BaseActivity baseActivity0 = fragmentActivity0 instanceof BaseActivity ? ((BaseActivity)fragmentActivity0) : null;
            if(baseActivity0 != null) {
                baseActivity0.navigateBack();
            }
            com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordPredictiveFragment.Companion forUMixMakerKeywordPredictiveFragment$Companion0 = ForUMixMakerKeywordPredictiveFragment.Companion;
            ArrayList arrayList0 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
            if(arrayList0 != null) {
                Navigator.open(forUMixMakerKeywordPredictiveFragment$Companion0.newInstance(arrayList0));
                return;
            }
            q.m("nowSelectedTagList");
            throw null;
        }

        private static final void onBindViewImpl$lambda$5$lambda$4(ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, ArrayList arrayList0, MixMakerKeywordSelectAdapter forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0, View view0, int v) {
            ArrayList arrayList1 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
            if(arrayList1 != null) {
                if(arrayList1.size() < 3) {
                    RELTAGLIST foruMixMakerKeywordSelectRes$RESPONSE$RELTAGLIST0 = (RELTAGLIST)arrayList0.get(v);
                    SelectedTag selectedTag0 = new SelectedTag(foruMixMakerKeywordSelectRes$RESPONSE$RELTAGLIST0.tagName, foruMixMakerKeywordSelectRes$RESPONSE$RELTAGLIST0.emoji);
                    ArrayList arrayList2 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
                    if(arrayList2 != null) {
                        arrayList2.add(selectedTag0);
                        MixMakerUtils.INSTANCE.addRecentSelectedTagHistory(selectedTag0);
                        forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.clearCache(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getCacheKey());
                        forUMixMakerKeywordSelectFragment0.startFetch("after add");
                        return;
                    }
                    q.m("nowSelectedTagList");
                    throw null;
                }
                ToastManager.show(0x7F130450);  // string:for_u_mix_maker_keyword_over_toast "키워드는 최대 3개까지 추가 가능합니다."
                return;
            }
            q.m("nowSelectedTagList");
            throw null;
        }

        private static final void onBindViewImpl$lambda$7$lambda$6(O0 o00, MixMakerKeywordSelectAdapter forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0) {
            int v = ((RelTagListHolder)o00).getItemBinding().b.getWidth();
            int v1 = ScreenUtils.getScreenWidth(forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0.getContext());
            if(v > v1) {
                ((RelTagListHolder)o00).getItemBinding().c.scrollTo(v / 2 - v1 / 2, 0);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
            int v1 = 0x7F0A0A60;  // id:selected_tag_flex
            if(v == this.VIEW_TYPE_SELECTED) {
                View view0 = layoutInflater0.inflate(0x7F0D0285, viewGroup0, false);  // layout:for_u_mix_maker_selected_keyword
                FlexboxLayout flexboxLayout0 = (FlexboxLayout)I.C(view0, 0x7F0A0A60);  // id:selected_tag_flex
                if(flexboxLayout0 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0A60));  // id:selected_tag_flex
                }
                return new SelectedKeywordHolder(this, new N0(((LinearLayout)view0), flexboxLayout0));
            }
            if(v == this.VIEW_TYPE_RELTAGLIST) {
                View view1 = layoutInflater0.inflate(0x7F0D0284, viewGroup0, false);  // layout:for_u_mix_maker_rel_tag_list
                int v2 = 0x7F0A0B25;  // id:tag_container
                MixMakerTagCollectionView mixMakerTagCollectionView0 = (MixMakerTagCollectionView)I.C(view1, 0x7F0A0B25);  // id:tag_container
                if(mixMakerTagCollectionView0 != null) {
                    v2 = 0x7F0A0B2E;  // id:tag_scroll
                    HorizontalScrollView horizontalScrollView0 = (HorizontalScrollView)I.C(view1, 0x7F0A0B2E);  // id:tag_scroll
                    if(horizontalScrollView0 != null) {
                        return new RelTagListHolder(this, new M0(((ConstraintLayout)view1), mixMakerTagCollectionView0, horizontalScrollView0));
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(v2));
            }
            if(v == this.VIEW_TYPE_PREVIEW) {
                View view2 = layoutInflater0.inflate(0x7F0D0283, viewGroup0, false);  // layout:for_u_mix_maker_preview
                int v3 = 0x7F0A023F;  // id:center_thumb
                View view3 = I.C(view2, 0x7F0A023F);  // id:center_thumb
                if(view3 != null) {
                    x x0 = x.b(view3);
                    v3 = 0x7F0A075E;  // id:left_thumb
                    View view4 = I.C(view2, 0x7F0A075E);  // id:left_thumb
                    if(view4 != null) {
                        x x1 = x.b(view4);
                        v3 = 0x7F0A09FD;  // id:right_thumb
                        View view5 = I.C(view2, 0x7F0A09FD);  // id:right_thumb
                        if(view5 != null) {
                            x x2 = x.b(view5);
                            v3 = 0x7F0A0D1A;  // id:tv_song_name_list
                            View view6 = I.C(view2, 0x7F0A0D1A);  // id:tv_song_name_list
                            if(((MelonTextView)view6) != null) {
                                return new PreviewHolder(this, new L0(((ConstraintLayout)view2), x0, x1, x2, ((MelonTextView)view6)));
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v3));
            }
            View view7 = layoutInflater0.inflate(0x7F0D0282, viewGroup0, false);  // layout:for_u_mix_maker_loading
            if(((Guideline)I.C(view7, 0x7F0A0509)) == null) {  // id:guideline
                v1 = 0x7F0A0509;  // id:guideline
            }
            else {
                ImageView imageView0 = (ImageView)I.C(view7, 0x7F0A0649);  // id:iv_loading
                if(imageView0 == null) {
                    v1 = 0x7F0A0649;  // id:iv_loading
                }
                else {
                    LinearLayout linearLayout0 = (LinearLayout)I.C(view7, 0x7F0A0A0C);  // id:root_layout
                    if(linearLayout0 == null) {
                        v1 = 0x7F0A0A0C;  // id:root_layout
                    }
                    else {
                        FlexboxLayout flexboxLayout1 = (FlexboxLayout)I.C(view7, 0x7F0A0A60);  // id:selected_tag_flex
                        if(flexboxLayout1 != null) {
                            return new LoadingHolder(this, new K0(((ConstraintLayout)view7), imageView0, linearLayout0, flexboxLayout1));
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view7.getResources().getResourceName(v1));
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_NOW_SELECTED_TAG_LIST = "argNowSelectedTagList";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String FETCH_REASON_AFTER_ADD = "after add";
    @NotNull
    private static final String FETCH_REASON_AFTER_DELETE = "after delete";
    @NotNull
    private static final String TAG = "ForUMixMakerKeywordSelectFragment";
    @Nullable
    private Z0 _binding;
    private boolean isGoingBack;
    private boolean isLoading;
    private ArrayList nowSelectedTagList;
    @Nullable
    private ViewTreeObserverHelper observerHelper;
    @Nullable
    private SelectedTag recentDeletedTag;
    private int recentDeletedTagPosition;

    static {
        ForUMixMakerKeywordSelectFragment.Companion = new Companion(null);
        ForUMixMakerKeywordSelectFragment.$stable = 8;
    }

    public ForUMixMakerKeywordSelectFragment() {
        this.recentDeletedTagPosition = -1;
    }

    public static final String access$getSearchKeyword(ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0) {
        return forUMixMakerKeywordSelectFragment0.getSearchKeyword();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new MixMakerKeywordSelectAdapter(this, context0, null);
    }

    @NotNull
    public final Z0 getBinding() {
        Z0 z00 = this._binding;
        q.d(z00);
        return z00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.B.buildUpon().build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
    }

    private final String getSearchKeyword() {
        ArrayList arrayList0 = this.nowSelectedTagList;
        if(arrayList0 != null) {
            if(arrayList0.isEmpty()) {
                return "";
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            ArrayList arrayList1 = this.nowSelectedTagList;
            if(arrayList1 != null) {
                for(Object object0: arrayList1) {
                    stringBuilder0.append(((SelectedTag)object0).getTagName());
                    stringBuilder0.append(", ");
                }
                if(stringBuilder0.length() >= 2) {
                    String s = stringBuilder0.substring(0, stringBuilder0.length() - 2);
                    q.d(s);
                    return s;
                }
                return "";
            }
            q.m("nowSelectedTagList");
            throw null;
        }
        q.m("nowSelectedTagList");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        this.isGoingBack = true;
        if(this.isLoading) {
            MenuIdQueue.getInstance().setSkipAction(true);
            FragmentActivity fragmentActivity0 = this.getActivity();
            BaseActivity baseActivity0 = fragmentActivity0 instanceof BaseActivity ? ((BaseActivity)fragmentActivity0) : null;
            if(baseActivity0 != null) {
                baseActivity0.navigateBack();
            }
            Companion forUMixMakerKeywordSelectFragment$Companion0 = ForUMixMakerKeywordSelectFragment.Companion;
            ArrayList arrayList0 = this.nowSelectedTagList;
            if(arrayList0 != null) {
                Navigator.open(forUMixMakerKeywordSelectFragment$Companion0.newInstance(arrayList0));
                return true;
            }
            q.m("nowSelectedTagList");
            throw null;
        }
        return super.onBackPressed();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        if(ScreenUtils.isTablet(this.getContext())) {
            this.getBinding().c.setImageResource(0x7F080652);  // drawable:img_mixmaker_top_bg_large
        }
        this.getAdapter().notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        Z0 z00 = this.getBinding();
        q.f(z00.d, "recyclerView");
        z00.d.setAdapter(this.mAdapter);
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(z00.d.getContext());
        z00.d.setLayoutManager(linearLayoutManager0);
        z00.d.setHasFixedSize(false);
        return z00.d;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02AC, viewGroup0, false);  // layout:fragment_for_u_mix_maker_keyword_select
        int v = 0x7F0A0301;  // id:complete_btn
        View view1 = I.C(view0, 0x7F0A0301);  // id:complete_btn
        if(((LinearLayout)view1) != null) {
            v = 0x7F0A05FE;  // id:iv_bg
            View view2 = I.C(view0, 0x7F0A05FE);  // id:iv_bg
            if(((ImageView)view2) != null) {
                v = 0x7F0A09D1;  // id:recycler_view
                View view3 = I.C(view0, 0x7F0A09D1);  // id:recycler_view
                if(((RecyclerView)view3) != null) {
                    v = 0x7F0A0C48;  // id:tv_complete
                    View view4 = I.C(view0, 0x7F0A0C48);  // id:tv_complete
                    if(((MelonTextView)view4) != null) {
                        this._binding = new Z0(((FrameLayout)view0), ((LinearLayout)view1), ((ImageView)view2), ((RecyclerView)view3), ((MelonTextView)view4));
                        Z0 z00 = this.getBinding();
                        q.f(z00.a, "getRoot(...)");
                        return z00.a;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
        ViewTreeObserverHelper viewTreeObserverHelper0 = this.observerHelper;
        if(viewTreeObserverHelper0 != null) {
            viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            this.observerHelper = null;
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        String s1 = this.getSearchKeyword();
        RequestBuilder.newInstance(new ForuMixMakerKeywordSelectReq(this.getContext(), s1)).tag(this.getRequestTag()).listener(new g(1, this, i0)).errorListener(new g(2, s, this)).request();
        return true;
    }

    private static final void onFetchStart$lambda$4(ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, v9.i i0, ForuMixMakerKeywordSelectRes foruMixMakerKeywordSelectRes0) {
        if(!forUMixMakerKeywordSelectFragment0.prepareFetchComplete(foruMixMakerKeywordSelectRes0)) {
            Z0 z00 = forUMixMakerKeywordSelectFragment0._binding;
            if(z00 != null) {
                z00.c.setVisibility(8);
            }
            Z0 z01 = forUMixMakerKeywordSelectFragment0._binding;
            if(z01 != null) {
                z01.b.setVisibility(8);
            }
            return;
        }
        Z0 z02 = forUMixMakerKeywordSelectFragment0._binding;
        if(z02 != null) {
            z02.c.setVisibility(0);
        }
        Z0 z03 = forUMixMakerKeywordSelectFragment0._binding;
        if(z03 != null) {
            z03.b.setVisibility(0);
        }
        if(foruMixMakerKeywordSelectRes0 != null) {
            RESPONSE foruMixMakerKeywordSelectRes$RESPONSE0 = foruMixMakerKeywordSelectRes0.response;
            if(foruMixMakerKeywordSelectRes$RESPONSE0 != null) {
                forUMixMakerKeywordSelectFragment0.mMelonTiaraProperty = new s(foruMixMakerKeywordSelectRes$RESPONSE0.section, foruMixMakerKeywordSelectRes$RESPONSE0.page, "", null);
            }
        }
        forUMixMakerKeywordSelectFragment0.performFetchComplete(i0, foruMixMakerKeywordSelectRes0);
    }

    private static final void onFetchStart$lambda$6(String s, ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, VolleyError volleyError0) {
        if(q.b(s, "after add")) {
            forUMixMakerKeywordSelectFragment0.showProgress(false);
            ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            ArrayList arrayList0 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
            if(arrayList0 != null) {
                arrayList0.remove(arrayList0.size() - 1);
                return;
            }
            q.m("nowSelectedTagList");
            throw null;
        }
        if(q.b(s, "after delete")) {
            forUMixMakerKeywordSelectFragment0.showProgress(false);
            ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            SelectedTag selectedTag0 = forUMixMakerKeywordSelectFragment0.recentDeletedTag;
            if(selectedTag0 != null) {
                int v = forUMixMakerKeywordSelectFragment0.recentDeletedTagPosition;
                if(v >= 0) {
                    ArrayList arrayList1 = forUMixMakerKeywordSelectFragment0.nowSelectedTagList;
                    if(arrayList1 != null) {
                        arrayList1.add(v, selectedTag0);
                        forUMixMakerKeywordSelectFragment0.recentDeletedTag = null;
                        forUMixMakerKeywordSelectFragment0.recentDeletedTagPosition = -1;
                        return;
                    }
                    q.m("nowSelectedTagList");
                    throw null;
                }
            }
            forUMixMakerKeywordSelectFragment0.recentDeletedTag = null;
            forUMixMakerKeywordSelectFragment0.recentDeletedTagPosition = -1;
            return;
        }
        Z0 z00 = forUMixMakerKeywordSelectFragment0._binding;
        if(z00 != null) {
            ImageView imageView0 = z00.c;
            if(imageView0 != null) {
                imageView0.setVisibility(8);
            }
        }
        Z0 z01 = forUMixMakerKeywordSelectFragment0._binding;
        if(z01 != null) {
            LinearLayout linearLayout0 = z01.b;
            if(linearLayout0 != null) {
                linearLayout0.setVisibility(8);
            }
        }
        j0 j00 = forUMixMakerKeywordSelectFragment0.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordSelectFragment.MixMakerKeywordSelectAdapter");
        ((MixMakerKeywordSelectAdapter)j00).clear();
        forUMixMakerKeywordSelectFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onForeground() {
        super.onForeground();
        FragmentActivity fragmentActivity0 = this.getActivity();
        ScreenUtils.setAppearanceLightStatusBars((fragmentActivity0 == null ? null : fragmentActivity0.getWindow()), !ScreenUtils.isDarkMode(this.getContext()));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        ArrayList arrayList0 = Gd.e.u(bundle0);
        if(arrayList0 == null) {
            arrayList0 = new ArrayList();
        }
        this.nowSelectedTagList = arrayList0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        ArrayList arrayList0 = this.nowSelectedTagList;
        if(arrayList0 != null) {
            bundle0.putParcelableArrayList("argNowSelectedTagList", arrayList0);
            return;
        }
        q.m("nowSelectedTagList");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setBackgroundColor(0);
            titleBar0.setTitle(this.getString(0x7F13044A));  // string:for_u_mix_maker "믹스메이커"
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = titleBar0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.getStatusBarHeight(titleBar0.getContext());
            titleBar0.requestLayout();
        }
        if(ScreenUtils.isTablet(this.getContext())) {
            this.getBinding().c.setImageResource(0x7F080652);  // drawable:img_mixmaker_top_bg_large
        }
        Z0 z00 = this.getBinding();
        d d0 = new d(this, 2);
        z00.b.setOnClickListener(d0);
    }

    private static final void onViewCreated$lambda$2(ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, View view0) {
        forUMixMakerKeywordSelectFragment0.getBinding().b.setVisibility(8);
        j0 j00 = forUMixMakerKeywordSelectFragment0.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordSelectFragment.MixMakerKeywordSelectAdapter");
        forUMixMakerKeywordSelectFragment0.isLoading = true;
        ((MixMakerKeywordSelectAdapter)j00).clear();
        forUMixMakerKeywordSelectFragment0.showMiniPlayer(false);
        ((MixMakerKeywordSelectAdapter)j00).add(new ServerDataWrapper(((MixMakerKeywordSelectAdapter)j00), ((MixMakerKeywordSelectAdapter)j00).getVIEW_TYPE_LOADING(), null, 2, null));
        ((MixMakerKeywordSelectAdapter)j00).notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return this.isLoading;
    }
}

