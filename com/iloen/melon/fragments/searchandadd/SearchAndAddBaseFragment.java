package com.iloen.melon.fragments.searchandadd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.ListMarker;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.adapters.common.s;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.sns.model.SharablePlaylist;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u000FJ-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\rH\u0016\u00A2\u0006\u0004\b \u0010\u0003J\u0017\u0010\"\u001A\u00020\r2\u0006\u0010!\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b$\u0010\u0006J\u0017\u0010&\u001A\u00020\r2\u0006\u0010%\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b&\u0010#J5\u0010-\u001A\u00020\u00042\f\u0010(\u001A\b\u0012\u0002\b\u0003\u0018\u00010\'2\u0006\u0010)\u001A\u00020\u00172\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u000F\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b0\u00101J\u001F\u00105\u001A\u00020\r2\u0006\u00103\u001A\u0002022\u0006\u00104\u001A\u00020*H\u0014\u00A2\u0006\u0004\b5\u00106J\r\u00107\u001A\u00020\r\u00A2\u0006\u0004\b7\u0010\u0003J\r\u00108\u001A\u00020\u0004\u00A2\u0006\u0004\b8\u0010\u0006J\u000F\u00109\u001A\u00020\rH\u0004\u00A2\u0006\u0004\b9\u0010\u0003R\u0016\u0010:\u001A\u00020*8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001A\u00020*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010=\u001A\u00020*8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010?\u001A\u00020>8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020>8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010B\u001A\u00020>8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010D\u001A\u00020C8\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER(\u0010J\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010Fj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`G8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bH\u0010IR\u001E\u0010N\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010K8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bL\u0010M\u00A8\u0006P"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "checkContentMaxCount", "()Z", "Lcom/iloen/melon/playback/Playable;", "playable", "addResult", "(Lcom/iloen/melon/playback/Playable;)Z", "Landroid/os/Bundle;", "outState", "Lie/H;", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "onPause", "isVisible", "onFragmentVisibilityChanged", "(Z)V", "shouldShowMiniPlayer", "isOpen", "setScrollBottomMargin", "Landroidx/recyclerview/widget/j0;", "adapter", "childView", "", "rawPosition", "position", "onRecyclerViewItemLongClick", "(Landroidx/recyclerview/widget/j0;Landroid/view/View;II)Z", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "clearMarkedItems", "existMarkedItem", "clearData", "mSearchViewType", "I", "contentMaxCount", "mSortType", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseAdapter$OnItemEventListener;", "mSongItemEventListener", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseAdapter$OnItemEventListener;", "mMvItemEventListener", "mContentItemEventListener", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseAdapter$OnItemViewClickListener;", "mOnItemViewClickListener", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseAdapter$OnItemViewClickListener;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMarkedItems", "()Ljava/util/ArrayList;", "markedItems", "Lcom/iloen/melon/adapters/common/p;", "getMelonArrayAdapter", "()Lcom/iloen/melon/adapters/common/p;", "melonArrayAdapter", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SearchAndAddBaseFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SORT_TYPE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    protected static final String ARG_SORT_TYPE = "argSortType";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SearchAndAddBaseFragment";
    private int contentMaxCount;
    @NotNull
    protected OnItemEventListener mContentItemEventListener;
    @NotNull
    protected OnItemEventListener mMvItemEventListener;
    @NotNull
    protected OnItemViewClickListener mOnItemViewClickListener;
    protected int mSearchViewType;
    @NotNull
    protected OnItemEventListener mSongItemEventListener;
    protected int mSortType;

    static {
        SearchAndAddBaseFragment.Companion = new Companion(null);
        SearchAndAddBaseFragment.$stable = 8;
    }

    public SearchAndAddBaseFragment() {
        this.mSearchViewType = -1;
        this.contentMaxCount = -1;
        this.mSongItemEventListener = new m(this, 0);
        this.mMvItemEventListener = new m(this, 1);
        this.mContentItemEventListener = new m(this, 2);
        this.mOnItemViewClickListener = new m(this, 3);
    }

    private final boolean addResult(Playable playable0) {
        if(playable0 == null) {
            LogU.Companion.w("SearchAndAddBaseFragment", "addResult() invalid paramter");
            return false;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            LogU.Companion.w("SearchAndAddBaseFragment", "addResult() invalid activity");
            return false;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(playable0);
        Intent intent0 = new Intent();
        intent0.putParcelableArrayListExtra("argSearchResultValues", arrayList0);
        if(fragmentActivity0.getParent() == null) {
            fragmentActivity0.setResult(-1, intent0);
        }
        else {
            fragmentActivity0.getParent().setResult(-1, intent0);
        }
        fragmentActivity0.getOnBackPressedDispatcher().c();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        if(this.mSearchViewType != 4 && this.mSearchViewType != 5 && this.mSearchViewType != 6 && this.mSearchViewType != 7 && this.mSearchViewType != 9) {
            View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
            q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
            ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), 504);
            q.f(toolBar0, "initLayoutType(...)");
            return toolBar0;
        }
        View view1 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar1 = ToolBar.f(((ToolBar)view1), 506);
        q.f(toolBar1, "initLayoutType(...)");
        return toolBar1;
    }

    private final boolean checkContentMaxCount() {
        String s;
        if(this.contentMaxCount > 0 && (this.mAdapter != null && this.mAdapter instanceof ListMarker && ((ListMarker)this.mAdapter).isMarkedMode())) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.ListMarker");
            int v = ((ListMarker)j00).getMarkedCount();
            int v1 = this.contentMaxCount;
            if(v >= v1) {
                switch(this.mSearchViewType) {
                    case 3: {
                        s = this.getString(0x7F13088A);  // string:present_send_max_song_count "최대 50곡까지만 선물 가능합니다."
                        q.f(s, "getString(...)");
                        break;
                    }
                    case 4: {
                        s = this.getString(0x7F1300E1, new Object[]{v1});  // string:alert_max_n_msg_song_count "한번에 최대 %d곡까지 추가 가능합니다."
                        q.f(s, "getString(...)");
                        break;
                    }
                    case 7: {
                        s = this.getString(0x7F1300DF, new Object[]{v1});  // string:alert_max_n_msg_artist_count "한번에 최대 %d명까지 추가 가능합니다."
                        q.f(s, "getString(...)");
                        break;
                    }
                    default: {
                        s = this.getString(0x7F1300E0, new Object[]{v1});  // string:alert_max_n_msg_count "한번에 최대 %d개까지 추가 가능합니다."
                        q.f(s, "getString(...)");
                    }
                }
                l0 l00 = this.getChildFragmentManager();
                String s1 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
                return false;
            }
        }
        return true;
    }

    public final void clearData() {
        this.clearMarkedItems();
        p p0 = this.getMelonArrayAdapter();
        if(p0 != null) {
            p0.clear();
        }
    }

    public final void clearMarkedItems() {
        this.setSelectAllWithToolbar(false);
    }

    public final boolean existMarkedItem() {
        p p0 = this.getMelonArrayAdapter();
        List list0 = p0 == null ? null : p0.getMarkedItems();
        return list0 != null && list0.size() > 0;
    }

    private final ArrayList getMarkedItems() {
        j0 j00 = this.mAdapter;
        if(j00 != null && j00 instanceof s) {
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MetaInfoAdapter");
            Collection collection0 = ((s)j00).getMarkedPlayableItems();
            if(collection0 != null && !collection0.isEmpty()) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.addAll(collection0);
                return arrayList0;
            }
        }
        return null;
    }

    @Nullable
    public final p getMelonArrayAdapter() {
        j0 j00 = this.getAdapter();
        return j00 instanceof p ? ((p)j00) : null;
    }

    private static final boolean mContentItemEventListener$lambda$7(SearchAndAddBaseFragment searchAndAddBaseFragment0, Sharable sharable0) {
        if(sharable0 == null) {
            return false;
        }
        if(sharable0 instanceof SharablePlaylist) {
            if(!ProtocolUtils.parseBoolean(((SharablePlaylist)sharable0).j)) {
                return false;
            }
        }
        else if(sharable0 instanceof SharableDJCollection && !ProtocolUtils.parseBoolean(((SharableDJCollection)sharable0).i)) {
            return false;
        }
        ContsTypeCode contsTypeCode0 = sharable0.getContsTypeCode();
        String s = sharable0.getContentId();
        LogU.Companion.d("SearchAndAddBaseFragment", "onAdd() sharable : " + contsTypeCode0 + ", " + s);
        return searchAndAddBaseFragment0.checkContentMaxCount();
    }

    private static final boolean mMvItemEventListener$lambda$6(SearchAndAddBaseFragment searchAndAddBaseFragment0, Sharable sharable0) {
        if(sharable0 instanceof Playable) {
            LogU.Companion.d("SearchAndAddBaseFragment", "Mv onAdd() playable : Playable {orig=0,ctype=null,menuId=,cid=,duration=3600000,durLimit=-1,data=,uriString=,streamPath=, trackId= }");
            ContsTypeCode contsTypeCode0 = ((Playable)sharable0).getContsTypeCode();
            LogU.Companion.d("SearchAndAddBaseFragment", "Mv onAdd() sharable : " + contsTypeCode0 + ", " + "");
            return searchAndAddBaseFragment0.checkContentMaxCount();
        }
        return false;
    }

    private static final void mOnItemViewClickListener$lambda$8(SearchAndAddBaseFragment searchAndAddBaseFragment0, View view0, int v) {
        searchAndAddBaseFragment0.onItemClick(view0, v);
    }

    private static final boolean mSongItemEventListener$lambda$5(SearchAndAddBaseFragment searchAndAddBaseFragment0, Sharable sharable0) {
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(sharable0 instanceof Playable) {
            h0.a = sharable0;
            Y.w("Song onAdd() playable : ", "Playable {orig=0,ctype=null,menuId=,cid=,duration=3600000,durLimit=-1,data=,uriString=,streamPath=, trackId= }", LogU.Companion, "SearchAndAddBaseFragment");
            ContsTypeCode contsTypeCode0 = ((Playable)h0.a).getContsTypeCode();
            LogU.Companion.d("SearchAndAddBaseFragment", "Song onAdd() sharable : " + contsTypeCode0 + ", " + "");
            int v = searchAndAddBaseFragment0.mSearchViewType;
            if(v == 0) {
                b.x(searchAndAddBaseFragment0.getChildFragmentManager(), searchAndAddBaseFragment0.getString(0x7F1300D0), searchAndAddBaseFragment0.getString(0x7F1300B6), false, false, null, null, new l(searchAndAddBaseFragment0, h0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
                return true;
            }
            return v == 10 ? searchAndAddBaseFragment0.addResult(((Playable)h0.a)) : searchAndAddBaseFragment0.checkContentMaxCount();
        }
        return false;
    }

    private static final ie.H mSongItemEventListener$lambda$5$lambda$4(SearchAndAddBaseFragment searchAndAddBaseFragment0, H h0) {
        searchAndAddBaseFragment0.addResult(((Playable)h0.a));
        return ie.H.a;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02BF, viewGroup0, false);  // layout:fragment_search_and_add
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onFragmentVisibilityChanged(boolean z) {
        View view0;
        super.onFragmentVisibilityChanged(z);
        if(this.isFragmentValid() && !this.isFragmentVisible) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 == null) {
                view0 = null;
            }
            else {
                Window window0 = fragmentActivity0.getWindow();
                view0 = window0 == null ? null : window0.getCurrentFocus();
            }
            if(view0 != null) {
                InputMethodUtils.hideInputMethod(this.getContext(), view0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        View view0;
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            view0 = null;
        }
        else {
            Window window0 = fragmentActivity0.getWindow();
            view0 = window0 == null ? null : window0.getCurrentFocus();
        }
        if(view0 != null) {
            InputMethodUtils.hideInputMethod(this.getContext(), view0);
        }
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onRecyclerViewItemLongClick(@Nullable j0 j00, @NotNull View view0, int v, int v1) {
        q.g(view0, "childView");
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.mSearchViewType = bundle0.getInt("argSearchViewType");
        this.contentMaxCount = bundle0.getInt("argMaxContentCount");
        if(bundle0.containsKey("argSortType")) {
            this.mSortType = bundle0.getInt("argSortType");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSearchViewType", this.mSearchViewType);
        bundle0.putInt("argMaxContentCount", this.contentMaxCount);
        bundle0.putInt("argSortType", this.mSortType);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@NotNull ToolBarItem toolBar$ToolBarItem0, int v) {
        q.g(toolBar$ToolBarItem0, "item");
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Intent intent0 = new Intent();
            switch(v) {
                case 9: 
                case 14: {
                    ArrayList arrayList0 = this.getMarkedItems();
                    if(arrayList0 != null) {
                        intent0.putParcelableArrayListExtra("argSearchResultValues", arrayList0);
                    }
                    break;
                }
                case 15: {
                    Object object0 = this.getContentAdapter();
                    q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter<*>");
                    String s = ((SearchAndAddBaseAdapter)object0).getMarkedContsIds();
                    Object object1 = this.getContentAdapter();
                    q.e(object1, "null cannot be cast to non-null type com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter<*>");
                    MarkedContsInfo searchAndAddBaseAdapter$MarkedContsInfo0 = new MarkedContsInfo(s, ((SearchAndAddBaseAdapter)object1).getMarkedContsTypeCodes());
                    Object object2 = this.getContentAdapter();
                    if(object2 != null && object2 instanceof SearchAndAddBaseAdapter) {
                        intent0.putExtra("argSearchResultValues", searchAndAddBaseAdapter$MarkedContsInfo0);
                    }
                }
            }
            Activity activity0 = fragmentActivity0.getParent();
            if(activity0 == null) {
                fragmentActivity0.setResult(-1, intent0);
            }
            else {
                activity0.setResult(-1, intent0);
            }
            fragmentActivity0.finish();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            ViewUtils.showWhen(titleBar0, false);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void setScrollBottomMargin(boolean z) {
        if(this.isToolBarShowing()) {
            super.setScrollBottomMargin(z);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return this.mSearchViewType == 0;
    }
}

