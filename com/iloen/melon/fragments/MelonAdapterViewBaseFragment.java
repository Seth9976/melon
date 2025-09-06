package com.iloen.melon.fragments;

import F8.B;
import F8.C;
import F8.c;
import F8.o;
import I9.b;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.android.volley.VolleyError;
import com.google.android.material.appbar.AppBarLayout;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.adapters.RecyclerItemClickListener.OnItemClickListener;
import com.iloen.melon.adapters.common.ListMarker;
import com.iloen.melon.adapters.common.RecyclerViewCursorAdapter;
import com.iloen.melon.adapters.common.d;
import com.iloen.melon.adapters.common.s;
import com.iloen.melon.adapters.common.u;
import com.iloen.melon.custom.RecyclerViewWithEmptyView;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.U;
import com.iloen.melon.custom.r1;
import com.iloen.melon.custom.s1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.SongInfoBase;
import h2.a;
import i9.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import v9.m;
import x8.f;

public abstract class MelonAdapterViewBaseFragment extends MelonBaseFragment implements AdapterView.OnItemClickListener, RecyclerItemClickListener.OnItemClickListener, CacheTag {
    class AddToLocalPlaylistTask extends f {
        private boolean bCursorCloseAfterAdd;
        private ArrayList checkedList;
        private Cursor cursor;
        private int id;

        private AddToLocalPlaylistTask() {
        }

        public AddToLocalPlaylistTask(int v) {
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        public Object backgroundWork(Void void0, Continuation continuation0) {
            Context context0 = MelonAdapterViewBaseFragment.this.getContext();
            int v = 0;
            if(context0 == null) {
                return 0;
            }
            if(this.cursor != null && !this.cursor.isClosed()) {
                v = MusicUtils.addToPlaylist(context0, this.cursor, this.checkedList, ((long)this.id));
            }
            if(v > 0) {
                Uri uri0 = i.b(this.id);
                context0.getContentResolver().notifyChange(uri0, MelonAdapterViewBaseFragment.this.mContentObserver);
            }
            if(this.bCursorCloseAfterAdd) {
                this.cursor.close();
            }
            return v;
        }

        public void postTask(Integer integer0) {
            MelonAdapterViewBaseFragment.this.showProgress(false);
            if(((int)integer0) == 0) {
                ToastManager.show(0x7F130506);  // string:localplaylist_alert_no_songs_to_be_added "추가할 곡이 없습니다."
                return;
            }
            if(((int)integer0) < 0) {
                ToastManager.showFormatted(0x7F130505, new Object[]{500});  // string:localplaylist_added_song_exceed_msg "로컬 플레이리스트에는 최대 %d곡까지 담기 가능합니다. 편집모드에서 
                                                                            // 수록곡을 수정하신 후 다시 시도해 주세요."
                return;
            }
            MelonAdapterViewBaseFragment.this.onAddSongsToLocalPlaylist();
            ToastManager.showFormatted(0x7F130504, new Object[]{integer0});  // string:localplaylist_added_n_items "%1$d곡을 로컬 플레이리스트에 추가하였습니다."
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Integer)object0));
        }

        @Override  // x8.f
        public void preTask() {
            MelonAdapterViewBaseFragment.this.showProgress(true);
        }

        public void setParams(Cursor cursor0, ArrayList arrayList0, int v, boolean z) {
            this.cursor = cursor0;
            this.checkedList = arrayList0;
            this.id = v;
            this.bCursorCloseAfterAdd = z;
        }
    }

    private static final String TAG = "MelonAdapterViewBaseFragment";
    private boolean isScrolledLineVisible;
    protected j0 mAdapter;
    private final ContentObserver mContentObserver;
    protected Object mDataSet;
    private MelonDb mDb;
    protected View mEmptyView;
    protected View mFooterView;
    protected AbsListView mListView;
    protected boolean mMarkedAll;
    protected RecyclerView mRecyclerView;
    protected ToolBar mToolBar;
    private A0 scrolledLineUpdateListener;

    public MelonAdapterViewBaseFragment() {
        this.mToolBar = null;
        this.mFooterView = null;
        this.isScrolledLineVisible = true;
        this.scrolledLineUpdateListener = new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                MelonAdapterViewBaseFragment melonAdapterViewBaseFragment0 = MelonAdapterViewBaseFragment.this;
                if(melonAdapterViewBaseFragment0.isFragmentVisible) {
                    melonAdapterViewBaseFragment0.isScrolledLineVisible = recyclerView0.canScrollVertically(-1);
                    MelonAdapterViewBaseFragment.this.showScrolledLine(MelonAdapterViewBaseFragment.this.isScrolledLineVisible);
                }
            }
        };
        this.mContentObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            @Override  // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override  // android.database.ContentObserver
            public void onChange(boolean z) {
                if(MelonAdapterViewBaseFragment.this.isFragmentValid()) {
                    Cursor cursor0 = MelonAdapterViewBaseFragment.this.fetchCursor();
                    MelonAdapterViewBaseFragment.this.changeCursor(cursor0);
                }
            }

            @Override  // android.database.ContentObserver
            public void onChange(boolean z, Uri uri0) {
                if(MelonAdapterViewBaseFragment.this.isFragmentValid()) {
                    Cursor cursor0 = MelonAdapterViewBaseFragment.this.fetchCursor();
                    MelonAdapterViewBaseFragment.this.changeCursor(cursor0);
                }
            }
        };
    }

    public static void C(MelonAdapterViewBaseFragment melonAdapterViewBaseFragment0, boolean z) {
        melonAdapterViewBaseFragment0.lambda$setScrollBottomMargin$1(z);
    }

    public static void G(MelonAdapterViewBaseFragment melonAdapterViewBaseFragment0) {
        melonAdapterViewBaseFragment0.setToolBarEditMode(false);
    }

    public void addListFooterView(View view0) {
        AbsListView absListView0 = this.getAbsListView();
        if(absListView0 != null) {
            ListAdapter listAdapter0 = (ListAdapter)absListView0.getAdapter();
            if(listAdapter0 != null && listAdapter0 instanceof HeaderViewListAdapter && absListView0 instanceof ListView) {
                ((ListView)absListView0).addFooterView(view0, null, false);
            }
        }
    }

    public void addListHeaderView(View view0) {
        AbsListView absListView0 = this.getAbsListView();
        if(absListView0 != null && absListView0 instanceof ListView) {
            ((ListView)absListView0).addHeaderView(view0);
        }
    }

    public void addListHeaderView(View view0, boolean z) {
        AbsListView absListView0 = this.getAbsListView();
        if(absListView0 != null && absListView0 instanceof ListView) {
            ((ListView)absListView0).addHeaderView(view0, null, z);
        }
    }

    public void addToLocalPlaylist(Cursor cursor0, ArrayList arrayList0, int v, boolean z) {
        if(arrayList0 != null) {
            LogU.d("MelonAdapterViewBaseFragment", "addToPlaylist size : " + arrayList0.size());
        }
        AddToLocalPlaylistTask melonAdapterViewBaseFragment$AddToLocalPlaylistTask0 = new AddToLocalPlaylistTask(this, 0);
        melonAdapterViewBaseFragment$AddToLocalPlaylistTask0.setParams(cursor0, arrayList0, v, z);
        melonAdapterViewBaseFragment$AddToLocalPlaylistTask0.execute(null);
    }

    public void addToLocalPlaylist(ArrayList arrayList0, int v) {
        int v1 = MusicUtils.addToPlaylist(arrayList0, ((long)v));
        if(v1 == 0) {
            ToastManager.show(0x7F130506);  // string:localplaylist_alert_no_songs_to_be_added "추가할 곡이 없습니다."
            return;
        }
        if(v1 < 0) {
            ToastManager.showFormatted(0x7F130505, new Object[]{500});  // string:localplaylist_added_song_exceed_msg "로컬 플레이리스트에는 최대 %d곡까지 담기 가능합니다. 편집모드에서 
                                                                        // 수록곡을 수정하신 후 다시 시도해 주세요."
            return;
        }
        this.onAddSongsToLocalPlaylist();
        ToastManager.showFormatted(0x7F130504, new Object[]{v1});  // string:localplaylist_added_n_items "%1$d곡을 로컬 플레이리스트에 추가하였습니다."
    }

    public ToolBar buildToolBar() {
        return null;
    }

    public void changeCursor(Cursor cursor0) {
        Object object0 = this.getContentAdapter();
        if(object0 instanceof RecyclerViewCursorAdapter) {
            ((RecyclerViewCursorAdapter)object0).changeCursor(cursor0);
            return;
        }
        if(object0 instanceof a) {
            ((a)object0).b(cursor0);
        }
    }

    private void closeMelonDb() {
        if(this.mDb != null) {
            LogU.v("MelonAdapterViewBaseFragment", "closeMelonDb() " + this);
            w9.a.a.d();
            this.mDb = null;
        }
    }

    public AbsListView createAbsListView(int v) {
        View view0 = this.findViewById(v);
        if(view0 instanceof AbsListView) {
            view0.setFadingEdgeLength(0);
            view0.setOverScrollMode(2);
            if(view0 instanceof ListView) {
                ((ListView)view0).setSelector(0x106000D);
                ((ListView)view0).setFooterDividersEnabled(false);
                ((ListView)view0).setOnItemClickListener(this);
            }
            this.mListView = (AbsListView)view0;
            this.createLoadingMoreFooterView();
            this.createEmptyOrErrorView();
        }
        return this.mListView;
    }

    public void createEmptyOrErrorView() {
        View view0 = this.findViewById(0x7F0A042C);  // id:empty_or_error_layout
        if(view0 != null) {
            AbsListView absListView0 = this.getAbsListView();
            if(absListView0 != null) {
                absListView0.setEmptyView(view0);
            }
        }
        else if(this.hasEmptyViewInAbsListView()) {
            AbsListView absListView1 = this.getAbsListView();
            if(absListView1 instanceof ListView) {
                view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0254, null, false);  // layout:empty_or_error_layout
                ((ListView)absListView1).addFooterView(view0, null, false);
            }
        }
        if(view0 != null) {
            ViewUtils.hideWhen(view0.findViewById(0x7F0A042B), true);  // id:empty_layout
            ViewUtils.hideWhen(view0.findViewById(0x7F0A08A5), true);  // id:network_error_layout
        }
        this.mEmptyView = view0;
    }

    public void createLoadingMoreFooterView() {
        LogU.v("MelonAdapterViewBaseFragment", "createLoadingMoreFooterView");
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0024, null, false);  // layout:adapter_loading_more_view
        this.mFooterView = view0;
        ViewUtils.hideWhen(view0.findViewById(0x7F0A079C), true);  // id:loading_more_container
        AbsListView absListView0 = this.getAbsListView();
        if(absListView0 instanceof ListView) {
            ((ListView)absListView0).addFooterView(this.mFooterView, null, false);
        }
    }

    public abstract j0 createRecyclerViewAdapter(Context arg1);

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean downloadAlbum(String s, String s1) {
        if(super.downloadAlbum(s, s1)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean downloadAlbumUnit(String s, String s1) {
        if(super.downloadAlbumUnit(s, s1)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean downloadFlacAlbumUnit(String s, String s1, String s2, boolean z) {
        return super.downloadFlacAlbumUnit(s, s1, s2, z);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean downloadFlacSongs(String s, String s1, List list0) {
        if(list0 != null && !list0.isEmpty()) {
            if(super.downloadFlacSongs(s, s1, list0)) {
                this.setSelectAllWithToolbar(false);
                return true;
            }
            return false;
        }
        LogU.w("MelonAdapterViewBaseFragment", "downloadSongs() invalid songIds");
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean downloadSongs(String s, List list0) {
        if(list0 != null && !list0.isEmpty()) {
            if(super.downloadSongs(s, list0)) {
                this.setSelectAllWithToolbar(false);
                return true;
            }
            return false;
        }
        LogU.w("MelonAdapterViewBaseFragment", "downloadSongs() invalid songIds");
        return false;
    }

    public Cursor fetchCursor() {
        if(this.getContext() == null) {
            LogU.w("MelonAdapterViewBaseFragment", "fetchCursor() invalid context");
            return null;
        }
        LogU.w("MelonAdapterViewBaseFragment", "fetchCursor() invalid key");
        return null;
    }

    public AbsListView getAbsListView() {
        return this.mListView;
    }

    public j0 getAdapter() {
        return this.mRecyclerView == null ? this.mAdapter : this.mRecyclerView.getAdapter();
    }

    public m getAllItemsWithoutRecommend() {
        return m.e;
    }

    public int getAvailableItemCount() {
        Object object0 = this.getContentAdapter();
        return object0 instanceof s ? ((s)object0).getServiceAvailableCount() : this.getItemCount();
    }

    public Object getContentAdapter() {
        j0 j00 = this.mAdapter;
        return j00 != null ? j00 : this.getListViewAdapter();
    }

    // 去混淆评级： 低(20)
    public Cursor getCursor() {
        return this.mAdapter instanceof RecyclerViewCursorAdapter ? ((RecyclerViewCursorAdapter)this.mAdapter).getCursor() : null;
    }

    public Object getDataSet() {
        if(this.mDataSet instanceof Cursor && ((Cursor)this.mDataSet).isClosed()) {
            LogU.w("MelonAdapterViewBaseFragment", "getDataSet() cursor already closed");
            this.mDataSet = null;
        }
        return this.mDataSet;
    }

    public int getItemCount() {
        Object object0 = this.getContentAdapter();
        if(object0 instanceof com.iloen.melon.adapters.common.i) {
            return ((com.iloen.melon.adapters.common.i)object0).getCount();
        }
        if(object0 instanceof ArrayAdapter) {
            return ((ArrayAdapter)object0).getCount();
        }
        if(object0 instanceof a) {
            return ((a)object0).getCount();
        }
        return object0 instanceof ListAdapter ? ((ListAdapter)object0).getCount() : 0;
    }

    public ListView getListView() {
        AbsListView absListView0 = this.getAbsListView();
        return absListView0 instanceof ListView ? ((ListView)absListView0) : null;
    }

    public ListAdapter getListViewAdapter() {
        AbsListView absListView0 = this.getAbsListView();
        if(absListView0 != null) {
            ListAdapter listAdapter0 = (ListAdapter)absListView0.getAdapter();
            return listAdapter0 instanceof HeaderViewListAdapter ? ((HeaderViewListAdapter)listAdapter0).getWrappedAdapter() : listAdapter0;
        }
        return null;
    }

    public int getMarkedItemCount() {
        Object object0 = this.getContentAdapter();
        return object0 instanceof ListMarker ? ((ListMarker)object0).getMarkedCount() : 0;
    }

    public m getMarkedList(boolean z) {
        if(this.getItemCount() == 0) {
            return m.e;
        }
        j0 j00 = this.getAdapter();
        if(j00 == null) {
            return m.e;
        }
        m m0 = new m();
        boolean z1 = true;
        if(!z) {
            if(j00 instanceof ListMarker) {
                for(Object object0: ((ListMarker)j00).getMarkedItems()) {
                    ((Integer)object0).getClass();
                    m0.d.add(((Integer)object0));
                }
            }
        }
        else if(j00 instanceof s) {
            List list0 = ((s)j00).getAllIndexItems();
            m0.d.addAll(list0);
        }
        else {
            int v = this.getItemCount();
            for(int v1 = 0; v1 < v; v1 = com.iloen.melon.utils.a.d(v1, v1, 1, m0.d)) {
            }
        }
        int v2 = m0.d.size();
        if(v2 != 0) {
            z1 = false;
        }
        m0.a = z1;
        LogU.v("MelonAdapterViewBaseFragment", "getMarkedList() marked:" + v2);
        return m0;
    }

    public MelonDb getMelonDb() {
        return this.mDb;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public int getRecyclerViewBottomPadding() [...] // Inlined contents

    public ToolBar getToolBar() {
        return this.mToolBar;
    }

    public List getWeakMarkedList() {
        List list0 = new ArrayList();
        if(this.getItemCount() != 0) {
            j0 j00 = this.getAdapter();
            if(j00 instanceof ListMarker) {
                int v = ((ListMarker)j00).getWeakMarked();
                if(v != -1) {
                    ((ArrayList)list0).add(v);
                    return list0;
                }
            }
        }
        return list0;
    }

    public boolean hasEmptyViewInAbsListView() {
        return true;
    }

    public boolean hasScrolledLine() {
        return false;
    }

    private final void hideToolBar(r1 r10) {
        if(this.mToolBar != null) {
            LogU.v("MelonAdapterViewBaseFragment", "hideToolBar()");
            this.mToolBar.setOnToolBarAnimationListener(r10);
            this.mToolBar.h(false);
        }
    }

    public final void hideToolBar() {
        LogU.v("MelonAdapterViewBaseFragment", "hideToolBar()");
        if(this.isToolBarShowing()) {
            this.hideToolBar(new r1() {
                @Override  // com.iloen.melon.custom.r1
                public void onToolBarAnimationEnd(boolean z) {
                    RecyclerView recyclerView0 = MelonAdapterViewBaseFragment.this.mRecyclerView;
                    if(recyclerView0 != null) {
                        recyclerView0.setNestedScrollingEnabled(true);
                    }
                }

                @Override  // com.iloen.melon.custom.r1
                public void onToolBarAnimationStart(boolean z) {
                    if(MelonAdapterViewBaseFragment.this.shouldShowMiniPlayer()) {
                        MelonAdapterViewBaseFragment.this.showMiniPlayer(true);
                    }
                    boolean z1 = MelonAdapterViewBaseFragment.this.shouldShowMiniPlayer();
                    MelonAdapterViewBaseFragment.this.setScrollBottomMargin(z1);
                }
            });
        }
    }

    public boolean isEditMode() {
        Object object0 = this.getContentAdapter();
        return object0 instanceof d ? ((d)object0).isInEditMode() : false;
    }

    public final boolean isToolBarShowing() {
        return this.mToolBar != null && this.mToolBar.getVisibility() == 0;
    }

    private void lambda$onFragmentVisibilityChanged$0() {
        Object object0 = this.getContentAdapter();
        if(object0 instanceof ListMarker && ((ListMarker)object0).isMarkedMode()) {
            this.setSelectAllWithToolbar(false);
        }
    }

    private void lambda$setScrollBottomMargin$1(boolean z) {
        int v = 0;
        if(this.isFragmentValid()) {
            if(z) {
                if(this.getActivity() instanceof U) {
                    int v1 = this.getResources().getDimensionPixelSize(0x7F070057);  // dimen:bottom_tab_height
                    v = this.getResources().getDimensionPixelSize(0x7F070315) + v1;  // dimen:mini_player_height
                }
                else {
                    v = this.getResources().getDimensionPixelSize(0x7F070464);  // dimen:toolbar_height
                }
            }
            RecyclerView recyclerView0 = this.mRecyclerView;
            if(recyclerView0 == null) {
                AbsListView absListView0 = this.mListView;
                if(absListView0 != null) {
                    absListView0.setPadding(0, absListView0.getPaddingTop(), 0, v);
                    this.mListView.setClipToPadding(false);
                }
            }
            else {
                recyclerView0.setPadding(0, recyclerView0.getPaddingTop(), 0, v);
                this.mRecyclerView.setClipToPadding(false);
            }
            j0 j00 = this.getAdapter();
            if(j00 instanceof u) {
                ((u)j00).setFooterClipToPaddingHeight(v);
                ((u)j00).updateParallaxFooterView();
            }
        }
    }

    public void onAddSongsToLocalPlaylist() {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToPlaylistComplete(String s, String s1, String s2, int v, VolleyError volleyError0) {
        this.setSelectAllWithToolbar(false);
    }

    public void onAfterCreateFooterView() {
    }

    public void onAppbarOffsetChanged(AppBarLayout appBarLayout0, int v, int v1) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean onBackPressed() {
        if(this.isEditMode()) {
            this.setEditMode(false, "");
            return true;
        }
        return super.onBackPressed();
    }

    public void onBeforeCreateFooterView() {
    }

    public boolean onBeforeEditButtonClick(boolean z, boolean z1) [...] // Inlined contents

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onCancelAddToPlaylist() {
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onCancelAddToToLocalPlaylist() {
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        if(this.hasScrolledLine()) {
            this.showScrolledLine(false);
        }
    }

    public void onContentChanged(Uri uri0) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.openMelonDb();
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.onRestoreInstanceState(bundle0);
        }
        this.mAdapter = this.createRecyclerViewAdapter(this.getContext());
    }

    public abstract RecyclerView onCreateRecyclerView();

    public boolean onCursorChanged(Cursor cursor0) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onDestroy() {
        super.onDestroy();
        Cursor cursor0 = this.getCursor();
        if(cursor0 != null && !cursor0.isClosed()) {
            cursor0.close();
        }
        if(this.getDataSet() instanceof Cursor) {
            Cursor cursor1 = (Cursor)this.getDataSet();
            if(!cursor1.isClosed()) {
                cursor1.close();
            }
        }
        this.closeMelonDb();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onDestroyView() {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.setAdapter(null);
            this.mRecyclerView.removeOnScrollListener(this.scrolledLineUpdateListener);
            this.mRecyclerView = null;
        }
        ToolBar toolBar0 = this.mToolBar;
        if(toolBar0 != null) {
            toolBar0.g = null;
            toolBar0.h = null;
            toolBar0.g();
            this.mToolBar = null;
        }
        super.onDestroyView();
    }

    public void onEditButtonClick(boolean z, boolean z1) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onFragmentVisibilityChanged(boolean z) {
        super.onFragmentVisibilityChanged(z);
        new Handler(Looper.getMainLooper()).post(new l(this, 3));
    }

    public void onHeaderItemClick(AdapterView adapterView0, View view0, int v, long v1, Object object0) {
        LogU.d("MelonAdapterViewBaseFragment", "onHeaderItemClick - pos:" + v + ", item:" + object0);
    }

    @Override  // com.iloen.melon.adapters.RecyclerItemClickListener$OnItemClickListener
    public final void onItemClick(View view0, int v) {
        j0 j00 = this.mAdapter;
        int v1 = j00 instanceof com.iloen.melon.adapters.common.i ? v - ((com.iloen.melon.adapters.common.i)j00).getHeaderCount() : v;
        LogU.v("MelonAdapterViewBaseFragment", "onItemClick() rawPosition: " + v + ", position:" + v1);
        if(!this.onRecyclerViewItemClick(j00, view0, v, v1) && j00 instanceof ListMarker && ((ListMarker)j00).isMarkedMode() && j00 instanceof com.iloen.melon.adapters.common.i) {
            this.setItemMarkWithBars(v1);
        }
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        int v3;
        ListAdapter listAdapter0 = this.getListViewAdapter();
        if(listAdapter0 == null) {
            LogU.w("MelonAdapterViewBaseFragment", "onItemClick() invalid adapter");
            return;
        }
        Object object0 = adapterView0.getAdapter().getItem(v);
        StringBuilder stringBuilder0 = Z.n(v, "onItemClick() position:", " id:", v1);
        stringBuilder0.append(", item:");
        stringBuilder0.append(object0);
        LogU.d("MelonAdapterViewBaseFragment", stringBuilder0.toString());
        if(adapterView0.getAdapter() instanceof HeaderViewListAdapter) {
            int v2 = ((HeaderViewListAdapter)adapterView0.getAdapter()).getHeadersCount();
            if(v < v2) {
                this.onHeaderItemClick(adapterView0, view0, v, v1, object0);
            }
            v3 = v - v2;
        }
        else {
            v3 = v;
        }
        if(v3 >= 0 && (listAdapter0 instanceof ListMarker && !this.onListItemClick(adapterView0, view0, v3, v1, object0) && ((ListMarker)listAdapter0).isMarkedMode())) {
            this.setItemMarkWithBars(v3);
        }
    }

    public final void onItemLongPress(View view0, int v) {
    }

    public boolean onListItemClick(AdapterView adapterView0, View view0, int v, long v1, Object object0) {
        LogU.d("MelonAdapterViewBaseFragment", "onListItemClick - pos:" + v + ", item:" + object0);
        return false;
    }

    public boolean onRecyclerViewItemClick(j0 j00, View view0, int v, int v1) {
        return false;
    }

    public boolean onRecyclerViewItemLongClick(j0 j00, View view0, int v, int v1) {
        return false;
    }

    public abstract void onRestoreInstanceState(Bundle arg1);

    // 检测为 Lambda 实现
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) [...]

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        RecyclerView recyclerView0 = this.onCreateRecyclerView();
        this.mRecyclerView = recyclerView0;
        if(recyclerView0 != null) {
            if(recyclerView0 instanceof RecyclerViewWithEmptyView) {
                View view1 = view0.findViewById(0x7F0A042C);  // id:empty_or_error_layout
                this.mEmptyView = view1;
                ((RecyclerViewWithEmptyView)this.mRecyclerView).setEmptyView(view1);
            }
            if(this.getActivity() instanceof MusicBrowserActivity && this.shouldShowMiniPlayer()) {
                this.setScrollBottomMargin(true);
            }
        }
        ToolBar toolBar0 = this.buildToolBar();
        this.mToolBar = toolBar0;
        if(toolBar0 != null) {
            toolBar0.setOnToolBarListener((ToolBarItem toolBar$ToolBarItem0, int v) -> {
            });
        }
        if(this.mRecyclerView != null && this.hasScrolledLine()) {
            this.showScrolledLine(this.isScrolledLineVisible);
            this.mRecyclerView.addOnScrollListener(this.scrolledLineUpdateListener);
        }

        class com.iloen.melon.fragments.MelonAdapterViewBaseFragment.1 implements s1 {
            @Override  // com.iloen.melon.custom.s1
            public void onToolBarItemClicked(ToolBarItem toolBar$ToolBarItem0, int v) {
                MelonAdapterViewBaseFragment.this.onToolBarClick(toolBar$ToolBarItem0, v);
            }
        }

    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void openLoginView(Uri uri0) {
        this.setSelectAllWithToolbar(false);
        super.openLoginView(uri0);
    }

    private void openMelonDb() {
        if(this.mDb == null) {
            LogU.v("MelonAdapterViewBaseFragment", "openMelonDb() " + this);
            this.mDb = w9.a.a.h();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean openPresentSendPage(Receiver toReceiverView$Receiver0, ArrayList arrayList0) {
        if(super.openPresentSendPage(toReceiverView$Receiver0, arrayList0)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    public boolean playMixSongs(ArrayList arrayList0) {
        return super.playSongs(arrayList0, true, false, false);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSong(Playable playable0, boolean z) {
        if(super.playSong(playable0, z)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSong(Playable playable0, boolean z, boolean z1, boolean z2) {
        if(super.playSong(playable0, z, z1, z2)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSong(String s, String s1) {
        if(super.playSong(s, s1)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSong(String s, String s1, boolean z) {
        if(super.playSong(s, s1, z)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSong(String s, String s1, boolean z, StatsElementsBase statsElementsBase0) {
        if(super.playSong(s, s1, z, statsElementsBase0)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSongs(ArrayList arrayList0, boolean z) {
        if(super.playSongs(arrayList0, z)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSongs(ArrayList arrayList0, boolean z, boolean z1) {
        if(super.playSongs(arrayList0, z, z1)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean playSongs(ArrayList arrayList0, boolean z, boolean z1, boolean z2) {
        if(super.playSongs(arrayList0, z, z1, z2)) {
            this.setSelectAllWithToolbar(false);
            return true;
        }
        return false;
    }

    public void removeListFooterView(View view0) {
        AbsListView absListView0 = this.getAbsListView();
        if(absListView0 != null) {
            ListAdapter listAdapter0 = (ListAdapter)absListView0.getAdapter();
            if(listAdapter0 != null && listAdapter0 instanceof HeaderViewListAdapter && absListView0 instanceof ListView) {
                ((ListView)absListView0).removeFooterView(view0);
            }
        }
    }

    public void removeListHeaderView(View view0) {
        AbsListView absListView0 = this.getAbsListView();
        if(absListView0 != null) {
            ListAdapter listAdapter0 = (ListAdapter)absListView0.getAdapter();
            if(listAdapter0 != null && listAdapter0 instanceof HeaderViewListAdapter && absListView0 instanceof ListView) {
                ((ListView)absListView0).removeHeaderView(view0);
            }
        }
    }

    public void setDataSet(v9.i i0, Object object0) {
        ArrayAdapter arrayAdapter0;
        if(!(object0 instanceof Cursor) || !this.onCursorChanged(((Cursor)object0))) {
            boolean z = v9.i.c.equals(i0);
            ListAdapter listAdapter0 = this.getListViewAdapter();
            if(listAdapter0 != null) {
                if(listAdapter0 instanceof ArrayAdapter) {
                    arrayAdapter0 = (ArrayAdapter)listAdapter0;
                    arrayAdapter0.setNotifyOnChange(false);
                }
                else {
                    arrayAdapter0 = null;
                }
                if(listAdapter0 instanceof a && !z) {
                    ((a)listAdapter0).b(null);
                }
                if(object0 != null) {
                    if(!(object0 instanceof Cursor)) {
                        if(listAdapter0 instanceof a) {
                            ((a)listAdapter0).b(((Cursor)object0));
                        }
                        else if(arrayAdapter0 == null) {
                            LogU.e("MelonAdapterViewBaseFragment", "setDataSet() " + object0 + ", this:" + this);
                            throw new IllegalStateException("Override setDataSet() for invalid adapter");
                        }
                        else if(object0 instanceof List) {
                            arrayAdapter0.clear();
                            arrayAdapter0.addAll(((List)object0));
                        }
                    }
                    else if(((Cursor)object0).isClosed()) {
                        LogU.e("MelonAdapterViewBaseFragment", "closed cursor has been nullified");
                    }
                }
                if(arrayAdapter0 != null) {
                    arrayAdapter0.notifyDataSetChanged();
                }
            }
        }
    }

    public final void setEditMode(boolean z, String s) {
        this.setEditMode(z, s, false, false);
    }

    public final void setEditMode(boolean z, String s, boolean z1, boolean z2) {
        I i0 = this.getParentFragment();
        if(i0 instanceof MelonPagerFragment) {
            ((MelonPagerFragment)i0).setEditMode(z, s, z1, z2, new c() {
                @Override  // F8.c
                public boolean onEditDoneClick() {
                    ((MelonPagerFragment)i0).setEditMode(false, null, null);
                    MelonAdapterViewBaseFragment.G(MelonAdapterViewBaseFragment.this);
                    MelonAdapterViewBaseFragment.this.onEditButtonClick(false, true);
                    return false;
                }
            });
        }
        else {
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                if(z) {
                    C c0 = z2 ? new C() : new B();  // 初始化器: Ljava/lang/Object;-><init>()V / 初始化器: Ljava/lang/Object;-><init>()V
                    o[] arr_o = {c0, new F8.m(2, false)};
                    o o0 = null;
                    for(int v = 0; v < 2; ++v) {
                        o o1 = arr_o[v];
                        if(o0 == null) {
                            o0 = o1;
                        }
                        else {
                            o0.g(o1);
                        }
                    }
                    titleBar0.g(s, o0, z1, new c() {
                        @Override  // F8.c
                        public boolean onEditDoneClick() {
                            MelonAdapterViewBaseFragment.G(MelonAdapterViewBaseFragment.this);
                            MelonAdapterViewBaseFragment.this.onEditButtonClick(false, true);
                            return false;
                        }
                    });
                    titleBar0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
                    titleBar0.f(true);
                }
                else {
                    titleBar0.h();
                }
            }
        }
        this.setToolBarEditMode(z);
        this.onEditButtonClick(z, false);
    }

    public void setFooterTopDivider(int v) {
        View view0 = this.mFooterView;
        if(view0 != null) {
            View view1 = view0.findViewById(0x7F0A04D8);  // id:footer_top_divider
            view1.setBackgroundColor(this.getContext().getResources().getColor(v));
            ViewUtils.showWhen(view1, v > 0);
        }
    }

    public void setFooterTopDivider(Drawable drawable0) {
        View view0 = this.mFooterView;
        if(view0 != null) {
            View view1 = view0.findViewById(0x7F0A04D8);  // id:footer_top_divider
            ViewUtils.setBackground(view1, drawable0);
            ViewUtils.showWhen(view1, drawable0 != null);
        }
    }

    public void setFooterTopDividerResource(int v) {
        View view0 = this.mFooterView;
        if(view0 != null) {
            View view1 = view0.findViewById(0x7F0A04D8);  // id:footer_top_divider
            view1.setBackgroundResource(v);
            ViewUtils.showWhen(view1, v > 0);
        }
    }

    public void setItemMarkWithBars(int v) {
        this.setItemMarkWithBars(this.getContentAdapter(), v, false);
    }

    public void setItemMarkWithBars(int v, boolean z) {
        this.setItemMarkWithBars(this.getContentAdapter(), v, z);
    }

    public void setItemMarkWithBars(Object object0, int v, boolean z) {
        if(!(object0 instanceof ListMarker)) {
            LogU.w("MelonAdapterViewBaseFragment", "setItemMarkWithBars() - invalid adapter");
            return;
        }
        LogU.v("MelonAdapterViewBaseFragment", "setItemMarkWithBars() position:" + v);
        if(v < 0) {
            LogU.w("MelonAdapterViewBaseFragment", "setItemMarkWithBars() - invalid position");
            return;
        }
        boolean z1 = true;
        ((ListMarker)object0).setMarked(v, !((ListMarker)object0).isMarked(v));
        int v1 = this.getAvailableItemCount();
        int v2 = ((ListMarker)object0).getMarkedCount();
        if(v1 > 0) {
            if(v2 <= 0) {
                if(this.mMarkedAll) {
                    this.toggleSelectAll();
                    return;
                }
            }
            else if(!this.mMarkedAll) {
                this.updateSelectAllButton(true);
                this.mMarkedAll = true;
            }
        }
        if(!z) {
            if(v2 <= 0) {
                z1 = false;
            }
            this.updateToolBar(z1);
        }
    }

    public void setListViewAdapter(ListAdapter listAdapter0) {
        if(listAdapter0 != null) {
            AbsListView absListView0 = this.getAbsListView();
            if(absListView0 != null && absListView0 instanceof ListView) {
                absListView0.setAdapter(listAdapter0);
            }
        }
    }

    public void setListViewBackground(int v) {
        ListView listView0 = this.getListView();
        LogU.v("MelonAdapterViewBaseFragment", "setListViewBackground() resId:" + v + ", listView:" + listView0);
        if(listView0 != null) {
            listView0.setBackgroundResource(v);
        }
        View view0 = this.mFooterView;
        if(view0 != null) {
            view0.setBackgroundResource(v);
        }
    }

    public void setListViewDivider(int v) {
        ListView listView0 = this.getListView();
        if(listView0 != null) {
            listView0.setDivider(this.getContext().getResources().getDrawable(v));
            this.setFooterTopDividerResource(v);
        }
    }

    public void setListViewDivider(int v, float f) {
        this.setListViewDivider(v);
        this.setListViewDividerHeight(ScreenUtils.dipToPixel(this.getContext(), f));
    }

    public void setListViewDivider(Drawable drawable0) {
        ListView listView0 = this.getListView();
        if(listView0 != null) {
            listView0.setDivider(drawable0);
            this.setFooterTopDivider(drawable0);
        }
    }

    public void setListViewDivider(Drawable drawable0, float f) {
        this.setListViewDivider(drawable0);
        this.setListViewDividerHeight(ScreenUtils.dipToPixel(this.getContext(), f));
    }

    public void setListViewDividerColor(int v) {
        ListView listView0 = this.getListView();
        if(listView0 != null) {
            listView0.setDivider(this.getContext().getResources().getDrawable(v));
            this.setFooterTopDivider(v);
        }
    }

    public void setListViewDividerColor(int v, float f) {
        this.setListViewDividerColor(v);
        this.setListViewDividerHeight(ScreenUtils.dipToPixel(this.getContext(), f));
    }

    public void setListViewDividerHeight(int v) {
        ListView listView0 = this.getListView();
        if(listView0 != null) {
            listView0.setDividerHeight(v);
        }
        View view0 = this.mFooterView;
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.findViewById(0x7F0A04D8).getLayoutParams();  // id:footer_top_divider
            if(viewGroup$LayoutParams0 != null) {
                viewGroup$LayoutParams0.height = v;
            }
        }
    }

    public void setScrollBottomMargin(boolean z) {
        this.setScrollBottomMargin(z, false);
    }

    public void setScrollBottomMargin(boolean z, boolean z1) {
        if(!this.isFragmentValid()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new b(this, z, 2));
    }

    public void setSelectAll(boolean z) {
        if(this.isFragmentValid() && this.getItemCount() != 0) {
            Object object0 = this.getContentAdapter();
            if(object0 instanceof ListMarker) {
                if(z) {
                    ((ListMarker)object0).setMarkedAll();
                    return;
                }
                ((ListMarker)object0).setUnmarkedAll();
            }
        }
    }

    public void setSelectAllWithToolbar(boolean z) {
        LogU.v("MelonAdapterViewBaseFragment", "setSelectAllWithToolbar() enabled:" + z);
        if(!this.isFragmentValid()) {
            return;
        }
        this.setSelectAll(z);
        this.updateSelectAllButton(z);
        this.updateToolBar(z);
        this.mMarkedAll = z;
    }

    public void setSelectAllWithoutToolbar(boolean z) {
        LogU.v("MelonAdapterViewBaseFragment", "setSelectAllWithoutToolbar() enabled:" + z);
        if(!this.isFragmentValid()) {
            return;
        }
        this.setSelectAll(z);
        this.updateSelectAllButton(z);
        this.mMarkedAll = z;
    }

    private final void setToolBarEditMode(boolean z) {
        LogU.v("MelonAdapterViewBaseFragment", "setToolBarEditMode() enabled:" + z);
        Object object0 = this.getContentAdapter();
        this.setSelectAllWithoutToolbar(false);
        this.showTabContainer(!z);
        if(z) {
            RecyclerView recyclerView0 = this.mRecyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setNestedScrollingEnabled(false);
            }
            I i0 = this.getParentFragment();
            if(i0 instanceof MelonPagerFragment) {
                ((MelonPagerFragment)i0).expandTitlebar();
            }
            this.hideMiniPlayerForToolBar();
            if(this.mToolBar == null) {
                this.setScrollBottomMargin(false);
            }
            else {
                this.setScrollBottomMargin(true, i0 instanceof MelonPagerFragment);
            }
            this.showToolBar(null);
            ToolBar toolBar0 = this.mToolBar;
            if(toolBar0 != null) {
                toolBar0.d();
                this.mToolBar.i(true);
            }
            if(object0 instanceof d) {
                ((d)object0).setEditMode(true);
            }
            return;
        }
        if(object0 instanceof d) {
            ((d)object0).setEditMode(false);
        }
        ToolBar toolBar1 = this.mToolBar;
        if(toolBar1 != null) {
            toolBar1.i(false);
            this.mToolBar.d();
        }
        this.hideToolBar();
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldShowMiniPlayer() {
        return this.isEditMode() ? false : super.shouldShowMiniPlayer();
    }

    public final void showAlbumInfoPage(SongInfoBase songInfoBase0) {
        this.showAlbumInfoPage(songInfoBase0.albumId);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void showAlbumInfoPage(String s) {
        this.setSelectAllWithToolbar(false);
        super.showAlbumInfoPage(s);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void showArtistInfoPage(String s) {
        this.setSelectAllWithToolbar(false);
        super.showArtistInfoPage(s);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void showMvInfoPage(String s, String s1) {
        this.setSelectAllWithToolbar(false);
        super.showMvInfoPage(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void showMvInfoPageBySongId(String s, String s1) {
        this.setSelectAllWithToolbar(false);
        super.showMvInfoPageBySongId(s, s1);
    }

    public void showScrolledLine(boolean z) {
        TitleBar titleBar0 = this.getTitleBar();
        if(z) {
            View view0 = titleBar0.g;
            if(view0 != null) {
                if(view0.getVisibility() == 0) {
                    return;
                }
                titleBar0.f(true);
                return;
            }
            q.m("titleUnderline");
            throw null;
        }
        View view1 = titleBar0.g;
        if(view1 != null) {
            if(view1.getVisibility() == 0) {
                titleBar0.f(false);
            }
            return;
        }
        q.m("titleUnderline");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void showSongInfoPage(String s) {
        this.setSelectAllWithToolbar(false);
        super.showSongInfoPage(s);
    }

    public void showTabContainer(boolean z) {
        I i0 = this.getParentFragment();
        if(i0 instanceof MelonPagerFragment) {
            ((MelonPagerFragment)i0).showTabContainer(z);
        }
    }

    private final void showToolBar(r1 r10) {
        if(this.mToolBar != null) {
            LogU.v("MelonAdapterViewBaseFragment", "showToolBar()");
            this.mToolBar.setOnToolBarAnimationListener(r10);
            this.mToolBar.h(true);
        }
    }

    public final void showToolBar() {
        LogU.v("MelonAdapterViewBaseFragment", "showToolBar()");
        this.showToolBar(new r1() {
            @Override  // com.iloen.melon.custom.r1
            public void onToolBarAnimationEnd(boolean z) {
                MelonAdapterViewBaseFragment.this.setScrollBottomMargin(true);
            }

            @Override  // com.iloen.melon.custom.r1
            public void onToolBarAnimationStart(boolean z) {
                MelonAdapterViewBaseFragment.this.hideMiniPlayerForToolBar();
            }
        });
    }

    public void toggleSelectAll() {
        if(this.getAvailableItemCount() > 0) {
            this.setSelectAllWithToolbar(!this.mMarkedAll);
        }
    }

    public void toolBarAnimationEnd(boolean z) {
    }

    public void toolBarAnimationStart(boolean z) {
    }

    public void updateSelectAllButton(boolean z) {
        if(this.isFragmentValid()) {
            View view0 = this.findViewById(0x7F0A04A2);  // id:filter_view_check_button
            if(view0 instanceof S) {
                ((S)view0).setChecked(z);
            }
        }
    }

    public void updateToolBar(boolean z) {
        if(this.isFragmentValid()) {
            ToolBar toolBar0 = this.mToolBar;
            int v = 0;
            boolean z1 = toolBar0 == null ? false : toolBar0.k;
            if(z) {
                if(toolBar0 != null) {
                    Object object0 = this.getContentAdapter();
                    if(object0 instanceof ListMarker) {
                        v = ((ListMarker)object0).getMarkedCount();
                    }
                    if(v > 0) {
                        this.mToolBar.l(v);
                    }
                    else {
                        this.mToolBar.d();
                    }
                }
                if(!z1) {
                    this.showToolBar();
                }
            }
            else {
                if(toolBar0 != null) {
                    toolBar0.d();
                }
                if(!z1) {
                    this.hideToolBar();
                }
            }
        }
    }
}

