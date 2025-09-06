package com.iloen.melon.fragments.main.foru;

import Ad.n;
import Gd.e;
import Tf.v;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.google.gson.o;
import com.google.gson.x;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonAdapterViewBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.ForUMixmakerKeywordPredictiveReq;
import com.iloen.melon.net.v6x.response.ForUMixmakerKeywordPredictiveRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v6x.response.ForUMixmakerKeywordPredictiveRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ForUMixmakerKeywordPredictiveRes;
import com.iloen.melon.net.v6x.response.SearchAutocompleteKwdRes.SearchAutoKeywordBase;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.popup.b;
import d3.g;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.a;

@Metadata(d1 = {"\u0000\u00AA\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\n*\u0002HQ\b\u0007\u0018\u0000 T2\u00020\u0001:\u0006TUVWXYB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ-\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0003J\u001B\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0018\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0011\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b \u0010!J\u0017\u0010$\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\"H\u0002\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010\'\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\"H\u0002\u00A2\u0006\u0004\b\'\u0010%J\u0017\u0010(\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\"H\u0002\u00A2\u0006\u0004\b(\u0010%J\u000F\u0010)\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b)\u0010\u0003J\u000F\u0010*\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b*\u0010\u0003J#\u0010-\u001A\b\u0012\u0004\u0012\u00020\"0+*\f\u0012\b\u0012\u00060,R\u00020\u00000+H\u0002\u00A2\u0006\u0004\b-\u0010.J1\u00101\u001A\u001A\u0012\b\u0012\u00060,R\u00020\u00000/j\f\u0012\b\u0012\u00060,R\u00020\u0000`0*\b\u0012\u0004\u0012\u00020\"0+H\u0002\u00A2\u0006\u0004\b1\u00102R&\u00104\u001A\u0012\u0012\u0004\u0012\u0002030/j\b\u0012\u0004\u0012\u000203`08\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001A\u00020\"8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R.\u00108\u001A\u001A\u0012\b\u0012\u00060,R\u00020\u00000/j\f\u0012\b\u0012\u00060,R\u00020\u0000`08\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00105R\u001C\u0010;\u001A\n :*\u0004\u0018\u000109098\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u001B\u0010B\u001A\u00020=8FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\b>\u0010?\u001A\u0004\b@\u0010AR\u001F\u0010G\u001A\u00060CR\u00020\u00008FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\bD\u0010?\u001A\u0004\bE\u0010FR\u0014\u0010I\u001A\u00020H8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001A\u00060KR\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001A\u00060NR\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001A\u00020Q8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bR\u0010S\u00A8\u0006Z"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment;", "Lcom/iloen/melon/fragments/MelonAdapterViewBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "onBackPressed", "()Z", "", "keyword", "requestAutoComplete", "(Ljava/lang/String;)V", "tagName", "performSearchDirect", "addRecentKeyword", "saveRecentKeyword", "getRecentKeyword", "", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchRecentKeyword;", "convertToStringList", "(Ljava/util/List;)Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "convertToRecentKeywordType", "(Ljava/util/List;)Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "nowSelectedTagList", "Ljava/util/ArrayList;", "inputText", "Ljava/lang/String;", "recentKeywordArray", "Lcom/google/gson/n;", "kotlin.jvm.PlatformType", "json", "Lcom/google/gson/n;", "Landroid/view/inputmethod/InputMethodManager;", "imm$delegate", "Lie/j;", "getImm", "()Landroid/view/inputmethod/InputMethodManager;", "imm", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;", "adapter$delegate", "getAdapter", "()Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;", "adapter", "com/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$scrollListener$1", "scrollListener", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$scrollListener$1;", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchEmptyRecentKeyword;", "emptyRecentKeyword", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchEmptyRecentKeyword;", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchTitle;", "titleItem", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchTitle;", "com/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$textWatcher$1", "textWatcher", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$textWatcher$1;", "Companion", "MixMakerKeywordPredictiveHistory", "SearchInputAdapter", "SearchTitle", "SearchEmptyRecentKeyword", "SearchRecentKeyword", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ForUMixMakerKeywordPredictiveFragment extends MelonAdapterViewBaseFragment {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001A\u00020\n2\u0018\b\u0002\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_NOW_SELECTED_TAG_LIST", "RECENT_KEYWORD_SIZE_MAX", "", "newInstance", "Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment;", "nowSelectedTagList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/main/foru/SelectedTag;", "Lkotlin/collections/ArrayList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ForUMixMakerKeywordPredictiveFragment newInstance(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "nowSelectedTagList");
            ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0 = new ForUMixMakerKeywordPredictiveFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelableArrayList("argNowSelectedTagList", arrayList0);
            forUMixMakerKeywordPredictiveFragment0.setArguments(bundle0);
            return forUMixMakerKeywordPredictiveFragment0;
        }

        public static ForUMixMakerKeywordPredictiveFragment newInstance$default(Companion forUMixMakerKeywordPredictiveFragment$Companion0, ArrayList arrayList0, int v, Object object0) {
            if((v & 1) != 0) {
                arrayList0 = new ArrayList();
            }
            return forUMixMakerKeywordPredictiveFragment$Companion0.newInstance(arrayList0);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory;", "", "list", "", "", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class MixMakerKeywordPredictiveHistory {
        @NotNull
        private final List list;

        public MixMakerKeywordPredictiveHistory(@NotNull List list0) {
            q.g(list0, "list");
            super();
            this.list = list0;
        }

        @NotNull
        public final List component1() {
            return this.list;
        }

        @NotNull
        public final MixMakerKeywordPredictiveHistory copy(@NotNull List list0) {
            q.g(list0, "list");
            return new MixMakerKeywordPredictiveHistory(list0);
        }

        public static MixMakerKeywordPredictiveHistory copy$default(MixMakerKeywordPredictiveHistory forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0.list;
            }
            return forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0.copy(list0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof MixMakerKeywordPredictiveHistory ? q.b(this.list, ((MixMakerKeywordPredictiveHistory)object0).list) : false;
        }

        @NotNull
        public final List getList() {
            return this.list;
        }

        @Override
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "MixMakerKeywordPredictiveHistory(list=" + this.list + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchEmptyRecentKeyword;", "Ls9/a;", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment;)V", "", "getContentType", "()I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SearchEmptyRecentKeyword implements a {
        @Override  // s9.a
        public int getContentType() {
            return 3;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005#$%&\'B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001A\u00020\u00152\b\u0010\u0013\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001A\u0010\u0019J\r\u0010\u001C\u001A\u00020\u001B¢\u0006\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010\u0019R\u001A\u0010!\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b!\u0010\u001F\u001A\u0004\b\"\u0010\u0019¨\u0006("}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Ls9/a;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment;Landroid/content/Context;Ljava/util/List;)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "getFooterCount", "()I", "getItemCount", "", "isListView", "()Z", "TYPE_EMPTY", "I", "getTYPE_EMPTY", "TYPE_FOOTER", "getTYPE_FOOTER", "SearchTitleViewHolder", "MixAutoComplicationViewHolder", "MixRecentKeywordViewHolder", "MixMakerEmptyRecentKeywordViewHolder", "SearchFooterViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class SearchInputAdapter extends y {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter$MixAutoComplicationViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "keywordTv", "Landroid/widget/TextView;", "getKeywordTv", "()Landroid/widget/TextView;", "addBtn", "Landroid/view/View;", "getAddBtn", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MixAutoComplicationViewHolder extends O0 {
            @NotNull
            private final View addBtn;
            @NotNull
            private final TextView keywordTv;

            public MixAutoComplicationViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                SearchInputAdapter.this = forUMixMakerKeywordPredictiveFragment$SearchInputAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A06CF);  // id:keyword
                q.f(view1, "findViewById(...)");
                this.keywordTv = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A0071);  // id:add_btn
                q.f(view2, "findViewById(...)");
                this.addBtn = view2;
                int v = ScreenUtils.dipToPixel(forUMixMakerKeywordPredictiveFragment$SearchInputAdapter0.getContext(), 49.0f);
                ConstraintLayout constraintLayout0 = (ConstraintLayout)view0.findViewById(0x7F0A00D8);  // id:auto_list_item
                if(constraintLayout0 != null) {
                    constraintLayout0.setMinHeight(v + 1);
                }
                int v1 = ScreenUtils.dipToPixel(forUMixMakerKeywordPredictiveFragment$SearchInputAdapter0.getContext(), 16.0f);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view2.getLayoutParams();
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).setMargins(0, 0, v1, 0);
            }

            @NotNull
            public final View getAddBtn() {
                return this.addBtn;
            }

            @NotNull
            public final TextView getKeywordTv() {
                return this.keywordTv;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter$MixMakerEmptyRecentKeywordViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "messageTv", "getMessageTv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MixMakerEmptyRecentKeywordViewHolder extends O0 {
            @NotNull
            private final TextView messageTv;
            @NotNull
            private final TextView titleTv;

            public MixMakerEmptyRecentKeywordViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                SearchInputAdapter.this = forUMixMakerKeywordPredictiveFragment$SearchInputAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0B8D);  // id:title
                q.f(view1, "findViewById(...)");
                this.titleTv = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A07FB);  // id:message
                q.f(view2, "findViewById(...)");
                this.messageTv = (TextView)view2;
                ((TextView)view1).setText(ForUMixMakerKeywordPredictiveFragment.this.getString(0x7F130456));  // string:for_u_mix_maker_recent_keyword "최근 믹스 키워드"
                ((TextView)view2).setText(ForUMixMakerKeywordPredictiveFragment.this.getString(0x7F13044B));  // string:for_u_mix_maker_empty_recent_keyword "최근 믹스 키워드가 없습니다."
            }

            @NotNull
            public final TextView getMessageTv() {
                return this.messageTv;
            }

            @NotNull
            public final TextView getTitleTv() {
                return this.titleTv;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000E¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter$MixRecentKeywordViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "keywordTv", "Landroid/widget/TextView;", "getKeywordTv", "()Landroid/widget/TextView;", "addBtn", "Landroid/view/View;", "getAddBtn", "()Landroid/view/View;", "deleteBtn", "getDeleteBtn", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MixRecentKeywordViewHolder extends O0 {
            @NotNull
            private final View addBtn;
            @NotNull
            private final View deleteBtn;
            @NotNull
            private final TextView keywordTv;

            public MixRecentKeywordViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                SearchInputAdapter.this = forUMixMakerKeywordPredictiveFragment$SearchInputAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A06CF);  // id:keyword
                q.f(view1, "findViewById(...)");
                this.keywordTv = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A0071);  // id:add_btn
                q.f(view2, "findViewById(...)");
                this.addBtn = view2;
                View view3 = view0.findViewById(0x7F0A039C);  // id:delete_btn
                q.f(view3, "findViewById(...)");
                this.deleteBtn = view3;
                view3.setVisibility(0);
            }

            @NotNull
            public final View getAddBtn() {
                return this.addBtn;
            }

            @NotNull
            public final View getDeleteBtn() {
                return this.deleteBtn;
            }

            @NotNull
            public final TextView getKeywordTv() {
                return this.keywordTv;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter$SearchFooterViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;Landroid/view/View;)V", "allRemoveBtn", "Landroid/view/View;", "getAllRemoveBtn", "()Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SearchFooterViewHolder extends O0 {
            @NotNull
            private final View allRemoveBtn;

            public SearchFooterViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                SearchInputAdapter.this = forUMixMakerKeywordPredictiveFragment$SearchInputAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0095);  // id:all_delete_btn
                q.f(view1, "findViewById(...)");
                this.allRemoveBtn = view1;
                view1.setOnClickListener(new d(ForUMixMakerKeywordPredictiveFragment.this, 0));
            }

            private static final void _init_$lambda$1(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, View view0) {
                b.x(forUMixMakerKeywordPredictiveFragment0.getChildFragmentManager(), forUMixMakerKeywordPredictiveFragment0.getString(0x7F1300D0), forUMixMakerKeywordPredictiveFragment0.getString(0x7F1308EB), false, false, null, null, new c(forUMixMakerKeywordPredictiveFragment0, 0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
            }

            @NotNull
            public final View getAllRemoveBtn() {
                return this.allRemoveBtn;
            }

            private static final H lambda$1$lambda$0(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0) {
                forUMixMakerKeywordPredictiveFragment0.recentKeywordArray.clear();
                forUMixMakerKeywordPredictiveFragment0.getAdapter().clear();
                forUMixMakerKeywordPredictiveFragment0.getAdapter().add(forUMixMakerKeywordPredictiveFragment0.emptyRecentKeyword);
                forUMixMakerKeywordPredictiveFragment0.getAdapter().notifyDataSetChanged();
                return H.a;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter$SearchTitleViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchInputAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SearchTitleViewHolder extends O0 {
            @NotNull
            private final TextView titleTv;

            public SearchTitleViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                SearchInputAdapter.this = forUMixMakerKeywordPredictiveFragment$SearchInputAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0B8D);  // id:title
                q.f(view1, "findViewById(...)");
                this.titleTv = (TextView)view1;
                ((TextView)view1).setText(ForUMixMakerKeywordPredictiveFragment.this.getString(0x7F130456));  // string:for_u_mix_maker_recent_keyword "최근 믹스 키워드"
            }

            @NotNull
            public final TextView getTitleTv() {
                return this.titleTv;
            }
        }

        private final int TYPE_EMPTY;
        private final int TYPE_FOOTER;

        public SearchInputAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.TYPE_EMPTY = -1;
            this.TYPE_FOOTER = 100;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public int getFooterCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.y
        public int getItemCount() {
            return this.getCount() + 1;
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            if(v == this.getCount()) {
                return this.TYPE_FOOTER;
            }
            List list0 = this.getList();
            a a0 = null;
            Object object0 = list0 == null ? null : list0.get(v);
            if(object0 instanceof a) {
                a0 = (a)object0;
            }
            return a0 == null ? this.TYPE_EMPTY : a0.getContentType();
        }

        public final int getTYPE_EMPTY() {
            return this.TYPE_EMPTY;
        }

        public final int getTYPE_FOOTER() {
            return this.TYPE_FOOTER;
        }

        public final boolean isListView() {
            List list0 = this.getList();
            q.f(list0, "getList(...)");
            ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0 = ForUMixMakerKeywordPredictiveFragment.this;
            for(Object object0: list0) {
                if(q.b(object0, forUMixMakerKeywordPredictiveFragment0.emptyRecentKeyword)) {
                    return object0 == null;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(@Nullable O0 o00, int v, int v1) {
            MelonEditText melonEditText0;
            String s4;
            boolean z = true;
            int v2 = 0;
            if(o00 instanceof MixAutoComplicationViewHolder) {
                if(v1 < this.getList().size()) {
                    Object object0 = this.getList().get(v1);
                    q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ForUMixmakerKeywordPredictiveRes.RESPONSE.TAGLIST");
                    int v3 = ForUMixMakerKeywordPredictiveFragment.this.inputText.length();
                    String s = ((TAGLIST)object0).tagName;
                    q.f(s, "tagName");
                    int v4 = ((TAGLIST)object0).tagName.length();
                    if(v3 <= v4) {
                        v4 = v3;
                    }
                    String s1 = s.substring(0, v4);
                    q.f(s1, "substring(...)");
                    if(v.j0(ForUMixMakerKeywordPredictiveFragment.this.inputText, s1, true)) {
                        String s2 = ((TAGLIST)object0).tagName;
                        q.f(s2, "tagName");
                        String s3 = s2.substring(v3);
                        q.f(s3, "substring(...)");
                        s4 = ResourceUtils.replaceFontColor(this.getContext(), "<b>" + s1 + "</b>" + s3, 0);
                    }
                    else {
                        s4 = ((TAGLIST)object0).tagName;
                    }
                    ((MixAutoComplicationViewHolder)o00).getKeywordTv().setText(Html.fromHtml(s4, 0));
                    ((MixAutoComplicationViewHolder)o00).getAddBtn().setOnClickListener(new com.iloen.melon.fragments.main.foru.b(ForUMixMakerKeywordPredictiveFragment.this, ((TAGLIST)object0), 0));
                }
            }
            else if(o00 instanceof MixRecentKeywordViewHolder) {
                if(v1 < this.getList().size()) {
                    Object object1 = this.getList().get(v1);
                    q.e(object1, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordPredictiveFragment.SearchRecentKeyword");
                    String s5 = ((SearchRecentKeyword)object1).getKeyword();
                    ((MixRecentKeywordViewHolder)o00).getKeywordTv().setText(s5);
                    ((MixRecentKeywordViewHolder)o00).getAddBtn().setOnClickListener(new com.iloen.melon.fragments.main.foru.b(ForUMixMakerKeywordPredictiveFragment.this, s5, 1));
                    x1.a.N(((MixRecentKeywordViewHolder)o00).getDeleteBtn(), new n(ForUMixMakerKeywordPredictiveFragment.this, v1, s5, 11));
                }
            }
            else if(o00 instanceof SearchFooterViewHolder) {
                Object object2 = null;
                List list0 = this.getList();
                q.f(list0, "getList(...)");
                Iterator iterator0 = list0.iterator();
                while(true) {
                    melonEditText0 = null;
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object3 = iterator0.next();
                    if(object3 instanceof SearchAutoKeywordBase) {
                        object2 = object3;
                        break;
                    }
                }
                View view0 = ForUMixMakerKeywordPredictiveFragment.this.findViewById(0x7F0A0587);  // id:input_text_layout
                if(view0 instanceof MelonEditText) {
                    melonEditText0 = (MelonEditText)view0;
                }
                if(melonEditText0 == null) {
                    z = false;
                }
                else {
                    Editable editable0 = melonEditText0.getText();
                    if(editable0 == null || editable0.length() <= 0) {
                        z = false;
                    }
                }
                if(object2 == null && !z) {
                    View view1 = ((SearchFooterViewHolder)o00).getAllRemoveBtn();
                    if(ForUMixMakerKeywordPredictiveFragment.this.recentKeywordArray.isEmpty()) {
                        v2 = 8;
                    }
                    view1.setVisibility(v2);
                    return;
                }
                ((SearchFooterViewHolder)o00).getAllRemoveBtn().setVisibility(8);
            }
        }

        private static final void onBindViewHolder$lambda$0(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, TAGLIST forUMixmakerKeywordPredictiveRes$RESPONSE$TAGLIST0, View view0) {
            String s = forUMixmakerKeywordPredictiveRes$RESPONSE$TAGLIST0.tagName;
            q.f(s, "tagName");
            forUMixMakerKeywordPredictiveFragment0.addRecentKeyword(s);
            String s1 = forUMixmakerKeywordPredictiveRes$RESPONSE$TAGLIST0.tagName;
            q.f(s1, "tagName");
            forUMixMakerKeywordPredictiveFragment0.performSearchDirect(s1);
        }

        private static final void onBindViewHolder$lambda$1(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, String s, View view0) {
            forUMixMakerKeywordPredictiveFragment0.performSearchDirect(s);
        }

        private static final void onBindViewHolder$lambda$3(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, int v, String s, View view0) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: forUMixMakerKeywordPredictiveFragment0.recentKeywordArray) {
                if(!q.b(((SearchRecentKeyword)object0).getKeyword(), s)) {
                    arrayList0.add(object0);
                }
            }
            if(arrayList0.isEmpty()) {
                forUMixMakerKeywordPredictiveFragment0.recentKeywordArray.clear();
                forUMixMakerKeywordPredictiveFragment0.getAdapter().clear();
                forUMixMakerKeywordPredictiveFragment0.getAdapter().add(forUMixMakerKeywordPredictiveFragment0.emptyRecentKeyword);
                forUMixMakerKeywordPredictiveFragment0.getAdapter().notifyDataSetChanged();
                return;
            }
            forUMixMakerKeywordPredictiveFragment0.recentKeywordArray = new ArrayList(arrayList0);
            forUMixMakerKeywordPredictiveFragment0.getAdapter().remove(v);
            forUMixMakerKeywordPredictiveFragment0.getAdapter().notifyItemRemoved(v);
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            switch(v) {
                case 0: {
                    View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0814, viewGroup0, false);  // layout:search_title_item
                    q.f(view1, "inflate(...)");
                    return new SearchTitleViewHolder(this, view1);
                }
                case 2: {
                    View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0519, viewGroup0, false);  // layout:mix_keyword_item_layout
                    q.f(view2, "inflate(...)");
                    return new MixRecentKeywordViewHolder(this, view2);
                }
                case 3: {
                    View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0280, viewGroup0, false);  // layout:for_u_mix_maker_empty_lastly_keyword_item
                    q.f(view3, "inflate(...)");
                    return new MixMakerEmptyRecentKeywordViewHolder(this, view3);
                }
                case 4: {
                    View view4 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0519, viewGroup0, false);  // layout:mix_keyword_item_layout
                    q.f(view4, "inflate(...)");
                    return new MixAutoComplicationViewHolder(this, view4);
                }
                default: {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D051B, viewGroup0, false);  // layout:mix_maker_input_footer_layout
                    q.f(view0, "inflate(...)");
                    return new SearchFooterViewHolder(this, view0);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchRecentKeyword;", "Ls9/a;", "", "keyword", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment;Ljava/lang/String;)V", "", "getContentType", "()I", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SearchRecentKeyword implements a {
        @NotNull
        private final String keyword;

        public SearchRecentKeyword(@NotNull String s) {
            q.g(s, "keyword");
            ForUMixMakerKeywordPredictiveFragment.this = forUMixMakerKeywordPredictiveFragment0;
            super();
            this.keyword = s;
        }

        @Override  // s9.a
        public int getContentType() {
            return 2;
        }

        @NotNull
        public final String getKeyword() {
            return this.keyword;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment$SearchTitle;", "Ls9/a;", "<init>", "(Lcom/iloen/melon/fragments/main/foru/ForUMixMakerKeywordPredictiveFragment;)V", "", "getContentType", "()I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SearchTitle implements a {
        @Override  // s9.a
        public int getContentType() {
            return 0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_NOW_SELECTED_TAG_LIST = "argNowSelectedTagList";
    @NotNull
    public static final Companion Companion = null;
    private static final int RECENT_KEYWORD_SIZE_MAX = 10;
    @NotNull
    public static final String TAG = "ForUMixMakerKeywordPredictiveFragment";
    @NotNull
    private final j adapter$delegate;
    @NotNull
    private final SearchEmptyRecentKeyword emptyRecentKeyword;
    @NotNull
    private final j imm$delegate;
    @NotNull
    private String inputText;
    private final com.google.gson.n json;
    private ArrayList nowSelectedTagList;
    @NotNull
    private ArrayList recentKeywordArray;
    @NotNull
    private final com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordPredictiveFragment.scrollListener.1 scrollListener;
    @NotNull
    private final com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordPredictiveFragment.textWatcher.1 textWatcher;
    @NotNull
    private final SearchTitle titleItem;

    static {
        ForUMixMakerKeywordPredictiveFragment.Companion = new Companion(null);
        ForUMixMakerKeywordPredictiveFragment.$stable = 8;
    }

    public ForUMixMakerKeywordPredictiveFragment() {
        this.inputText = "";
        this.recentKeywordArray = new ArrayList();
        this.json = new o().a();
        this.imm$delegate = g.Q(new c(this, 1));
        this.adapter$delegate = g.Q(new c(this, 2));
        this.scrollListener = new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                q.g(recyclerView0, "recyclerView");
                if(v == 1 && ForUMixMakerKeywordPredictiveFragment.this.getAdapter().isListView()) {
                    InputMethodManager inputMethodManager0 = ForUMixMakerKeywordPredictiveFragment.this.getImm();
                    View view0 = ForUMixMakerKeywordPredictiveFragment.access$findViewById(ForUMixMakerKeywordPredictiveFragment.this, 0x7F0A0587);  // id:input_text_layout
                    inputMethodManager0.hideSoftInputFromWindow((view0 == null ? null : view0.getWindowToken()), 0);
                }
                super.onScrollStateChanged(recyclerView0, v);
            }
        };
        this.emptyRecentKeyword = new SearchEmptyRecentKeyword(this);
        this.titleItem = new SearchTitle(this);
        this.textWatcher = new TextWatcher() {
            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
                View view0 = ForUMixMakerKeywordPredictiveFragment.access$findViewById(ForUMixMakerKeywordPredictiveFragment.this, 0x7F0A02C0);  // id:clear_btn
                if(editable0 != null && editable0.length() != 0) {
                    ForUMixMakerKeywordPredictiveFragment.access$setInputText$p(ForUMixMakerKeywordPredictiveFragment.this, editable0.toString());
                    ForUMixMakerKeywordPredictiveFragment.access$requestAutoComplete(ForUMixMakerKeywordPredictiveFragment.this, ForUMixMakerKeywordPredictiveFragment.access$getInputText$p(ForUMixMakerKeywordPredictiveFragment.this));
                    if(view0 != null) {
                        view0.setVisibility(0);
                    }
                    return;
                }
                if(view0 != null) {
                    view0.setVisibility(8);
                }
                ForUMixMakerKeywordPredictiveFragment.this.getAdapter().clear();
                if(ForUMixMakerKeywordPredictiveFragment.access$getRecentKeywordArray$p(ForUMixMakerKeywordPredictiveFragment.this).isEmpty()) {
                    ForUMixMakerKeywordPredictiveFragment.this.getAdapter().add(ForUMixMakerKeywordPredictiveFragment.access$getEmptyRecentKeyword$p(ForUMixMakerKeywordPredictiveFragment.this));
                    return;
                }
                ForUMixMakerKeywordPredictiveFragment.this.getAdapter().add(ForUMixMakerKeywordPredictiveFragment.access$getTitleItem$p(ForUMixMakerKeywordPredictiveFragment.this));
                ForUMixMakerKeywordPredictiveFragment.this.getAdapter().addAll(p.C0(ForUMixMakerKeywordPredictiveFragment.access$getRecentKeywordArray$p(ForUMixMakerKeywordPredictiveFragment.this)));
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }
        };
    }

    public static final SearchTitle access$getTitleItem$p(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0) {
        return forUMixMakerKeywordPredictiveFragment0.titleItem;
    }

    public static final void access$requestAutoComplete(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, String s) {
        forUMixMakerKeywordPredictiveFragment0.requestAutoComplete(s);
    }

    public static final void access$setInputText$p(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, String s) {
        forUMixMakerKeywordPredictiveFragment0.inputText = s;
    }

    private static final SearchInputAdapter adapter_delegate$lambda$1(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0) {
        return new SearchInputAdapter(forUMixMakerKeywordPredictiveFragment0, forUMixMakerKeywordPredictiveFragment0.getContext(), null);
    }

    private final void addRecentKeyword(String s) {
        ArrayList arrayList0 = this.recentKeywordArray;
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(!q.b(((SearchRecentKeyword)object0).getKeyword(), s)) {
                arrayList1.add(object0);
            }
        }
        this.recentKeywordArray.clear();
        this.recentKeywordArray.addAll(arrayList1);
        this.recentKeywordArray.add(new SearchRecentKeyword(this, s));
        while(this.recentKeywordArray.size() > 10) {
            this.recentKeywordArray.remove(0);
        }
    }

    private final ArrayList convertToRecentKeywordType(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            arrayList0.add(new SearchRecentKeyword(this, ((String)object0)));
        }
        return arrayList0;
    }

    private final List convertToStringList(List list0) {
        List list1 = new ArrayList();
        for(Object object0: list0) {
            ((ArrayList)list1).add(((SearchRecentKeyword)object0).getKeyword());
        }
        return list1;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = this.getAdapter();
        this.mEmptyView = null;
        return j00;
    }

    @NotNull
    public final SearchInputAdapter getAdapter() {
        return (SearchInputAdapter)this.adapter$delegate.getValue();
    }

    @NotNull
    public final InputMethodManager getImm() {
        return (InputMethodManager)this.imm$delegate.getValue();
    }

    private final void getRecentKeyword() {
        ArrayList arrayList0;
        String s = MelonPrefs.getInstance().getString("mixMakerKeywordHistory", "");
        if(s != null && s.length() != 0) {
            try {
                MixMakerKeywordPredictiveHistory forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0 = (MixMakerKeywordPredictiveHistory)this.json.e(s, MixMakerKeywordPredictiveHistory.class);
                if(forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0 == null) {
                    arrayList0 = new ArrayList();
                }
                else {
                    List list0 = forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0.getList();
                    if(list0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    else {
                        arrayList0 = this.convertToRecentKeywordType(list0);
                        if(arrayList0 == null) {
                            arrayList0 = new ArrayList();
                        }
                    }
                }
                this.recentKeywordArray = arrayList0;
            }
            catch(x x0) {
                this.recentKeywordArray = new ArrayList();
                StackTraceElement[] arr_stackTraceElement = x0.getStackTrace();
                LogU.Companion.e("ForUMixMakerKeywordPredictiveFragment", "getRecentKeyword(), JsonSyntaxException e = " + arr_stackTraceElement);
            }
            if(this.recentKeywordArray.isEmpty()) {
                return;
            }
            this.getAdapter().add(this.titleItem);
            this.getAdapter().addAll(p.C0(this.recentKeywordArray));
            this.getAdapter().notifyDataSetChanged();
        }
    }

    private static final InputMethodManager imm_delegate$lambda$0(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0) {
        Context context0 = forUMixMakerKeywordPredictiveFragment0.getContext();
        Object object0 = context0 == null ? null : context0.getSystemService("input_method");
        q.e(object0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager)object0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        ArrayList arrayList0 = this.nowSelectedTagList;
        if(arrayList0 != null) {
            if(!arrayList0.isEmpty()) {
                MenuIdQueue.getInstance().setSkipAction(true);
                FragmentActivity fragmentActivity0 = this.getActivity();
                BaseActivity baseActivity0 = fragmentActivity0 instanceof BaseActivity ? ((BaseActivity)fragmentActivity0) : null;
                if(baseActivity0 != null) {
                    baseActivity0.navigateBack();
                }
                com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordSelectFragment.Companion forUMixMakerKeywordSelectFragment$Companion0 = ForUMixMakerKeywordSelectFragment.Companion;
                ArrayList arrayList1 = this.nowSelectedTagList;
                if(arrayList1 != null) {
                    Navigator.open(forUMixMakerKeywordSelectFragment$Companion0.newInstance(arrayList1));
                    return true;
                }
                q.m("nowSelectedTagList");
                throw null;
            }
            return super.onBackPressed();
        }
        q.m("nowSelectedTagList");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        RecyclerView recyclerView0 = view0 instanceof RecyclerView ? ((RecyclerView)view0) : null;
        if(recyclerView0 != null) {
            recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordPredictiveFragment.SearchInputAdapter");
            recyclerView0.setAdapter(((SearchInputAdapter)j00));
            recyclerView0.setItemAnimator(null);
            recyclerView0.addOnScrollListener(this.scrollListener);
            return recyclerView0;
        }
        return null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0281, viewGroup0, false);  // layout:for_u_mix_maker_keyword_predictive
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        View view0 = this.findViewById(0x7F0A0587);  // id:input_text_layout
        RecyclerView recyclerView0 = null;
        MelonEditText melonEditText0 = view0 instanceof MelonEditText ? ((MelonEditText)view0) : null;
        this.getImm().hideSoftInputFromWindow((melonEditText0 == null ? null : melonEditText0.getWindowToken()), 0);
        if(melonEditText0 != null) {
            melonEditText0.removeTextChangedListener(this.textWatcher);
        }
        this.saveRecentKeyword();
        View view1 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        if(view1 instanceof RecyclerView) {
            recyclerView0 = (RecyclerView)view1;
        }
        if(recyclerView0 != null) {
            recyclerView0.removeOnScrollListener(this.scrollListener);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        ArrayList arrayList0 = e.u(bundle0);
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

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.setTitleBar(((TitleBar)view0.findViewById(0x7F0A0BAD)));  // id:titlebar
        this.getTitleBar().a(B.a.s(1));
        this.getTitleBar().setTitle((this.getContext() == null ? null : "믹스메이커"));
        MelonEditText melonEditText0 = (MelonEditText)view0.findViewById(0x7F0A0587);  // id:input_text_layout
        if(melonEditText0 != null) {
            melonEditText0.requestFocus();
            this.getImm().showSoftInput(melonEditText0, 0);
        }
        melonEditText0.addTextChangedListener(this.textWatcher);
        View view1 = view0.findViewById(0x7F0A02C0);  // id:clear_btn
        if(view1 != null) {
            view1.setOnClickListener(new d(melonEditText0, 1));
        }
        View view2 = view0.findViewById(0x7F0A0A39);  // id:search_btn
        if(view2 != null) {
            view2.setVisibility(8);
        }
        this.getRecentKeyword();
        if(this.recentKeywordArray.isEmpty()) {
            this.getAdapter().add(this.emptyRecentKeyword);
            this.getAdapter().notifyDataSetChanged();
        }
    }

    private static final void onViewCreated$lambda$4(MelonEditText melonEditText0, View view0) {
        if(melonEditText0 != null) {
            melonEditText0.setText("");
        }
    }

    private final void performSearchDirect(String s) {
        SelectedTag selectedTag0 = new SelectedTag(s, null, 2, null);
        ArrayList arrayList0 = this.nowSelectedTagList;
        if(arrayList0 != null) {
            arrayList0.add(selectedTag0);
            MixMakerUtils.INSTANCE.addRecentSelectedTagHistory(selectedTag0);
            MenuIdQueue.getInstance().setSkipAction(true);
            FragmentActivity fragmentActivity0 = this.getActivity();
            BaseActivity baseActivity0 = fragmentActivity0 instanceof BaseActivity ? ((BaseActivity)fragmentActivity0) : null;
            if(baseActivity0 != null) {
                baseActivity0.navigateBack();
            }
            com.iloen.melon.fragments.main.foru.ForUMixMakerKeywordSelectFragment.Companion forUMixMakerKeywordSelectFragment$Companion0 = ForUMixMakerKeywordSelectFragment.Companion;
            ArrayList arrayList1 = this.nowSelectedTagList;
            if(arrayList1 != null) {
                Navigator.open(forUMixMakerKeywordSelectFragment$Companion0.newInstance(arrayList1));
                return;
            }
            q.m("nowSelectedTagList");
            throw null;
        }
        q.m("nowSelectedTagList");
        throw null;
    }

    private final void requestAutoComplete(String s) {
        RequestBuilder.newInstance(new ForUMixmakerKeywordPredictiveReq(this.getContext(), s)).tag("ForUMixMakerKeywordPredictiveFragment").listener(new com.iloen.melon.fragments.main.foru.a(this)).request();
    }

    private static final void requestAutoComplete$lambda$2(ForUMixMakerKeywordPredictiveFragment forUMixMakerKeywordPredictiveFragment0, Object object0) {
        forUMixMakerKeywordPredictiveFragment0.getAdapter().clear();
        if(object0 instanceof ForUMixmakerKeywordPredictiveRes) {
            RESPONSE forUMixmakerKeywordPredictiveRes$RESPONSE0 = ((ForUMixmakerKeywordPredictiveRes)object0).response;
            if((forUMixmakerKeywordPredictiveRes$RESPONSE0 == null ? null : forUMixmakerKeywordPredictiveRes$RESPONSE0.tagList) != null) {
                forUMixMakerKeywordPredictiveFragment0.getAdapter().addAll(((ForUMixmakerKeywordPredictiveRes)object0).response.tagList);
            }
        }
        forUMixMakerKeywordPredictiveFragment0.getAdapter().notifyDataSetChanged();
    }

    private final void saveRecentKeyword() {
        MixMakerKeywordPredictiveHistory forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0 = new MixMakerKeywordPredictiveHistory(this.convertToStringList(this.recentKeywordArray));
        MelonPrefs.getInstance().setString("mixMakerKeywordHistory", this.json.l(forUMixMakerKeywordPredictiveFragment$MixMakerKeywordPredictiveHistory0, MixMakerKeywordPredictiveHistory.class));
    }
}

