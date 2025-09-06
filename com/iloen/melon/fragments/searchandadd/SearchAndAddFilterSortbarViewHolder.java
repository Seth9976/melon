package com.iloen.melon.fragments.searchandadd;

import a9.d;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.G;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.popup.SingleFilterListPopup;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import v9.j;

public class SearchAndAddFilterSortbarViewHolder extends O0 {
    public interface OnFilterListener {
        void onSelected(String arg1, int arg2);
    }

    public static final int TAB_LIKE = 1;
    public static final int TAB_MADEBYMYSELF;
    private FragmentActivity mActivity;
    private int mCurrentFilterIndex;
    private FilterDropDownView mFilterDropDownView;
    private ArrayList mFilterItems;
    private TextView mFilterTv;
    private String mFilterType;
    private MelonBaseFragment mFragment;
    private OnFilterListener mOnFilterListener;
    private boolean mShowFilter;
    private int mSortType;
    private SortingBarView mSortingBarView;
    private View mUnderline;

    public SearchAndAddFilterSortbarViewHolder(View view0, FragmentActivity fragmentActivity0, MelonBaseFragment melonBaseFragment0, int v, boolean z) {
        super(view0);
        this.mCurrentFilterIndex = 0;
        this.mActivity = fragmentActivity0;
        this.mFragment = melonBaseFragment0;
        view0.setBackgroundColor(ColorUtils.getColor(view0.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
        this.mShowFilter = z;
        this.mUnderline = view0.findViewById(0x7F0A0D6D);  // id:underline_short
        ViewUtils.showWhen(view0.findViewById(0x7F0A0D6B), false);  // id:underline
        ViewUtils.showWhen(this.mUnderline, z);
        FilterDropDownView filterDropDownView0 = (FilterDropDownView)view0.findViewById(0x7F0A04AA);  // id:filterdropdown
        this.mFilterDropDownView = filterDropDownView0;
        this.mFilterTv = (TextView)filterDropDownView0.findViewById(0x7F0A03FC);  // id:dropdown_text
        this.mSortingBarView = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        this.mFilterItems = this.makeFilterData(v);
        ViewUtils.showWhen(this.mFilterDropDownView, z);
        this.mFilterDropDownView.setOnDropDownListener(new G() {
            @Override  // com.iloen.melon.custom.G
            public void onClick(FilterDropDownView filterDropDownView0) {
                SingleFilterListPopup singleFilterListPopup0 = new SingleFilterListPopup(SearchAndAddFilterSortbarViewHolder.a(SearchAndAddFilterSortbarViewHolder.this), 0);
                singleFilterListPopup0.setFilterItem(SearchAndAddFilterSortbarViewHolder.c(SearchAndAddFilterSortbarViewHolder.this));
                singleFilterListPopup0.setFilterListener(new d() {
                    @Override  // a9.d
                    public void onSelected(int v) {
                        if(SearchAndAddFilterSortbarViewHolder.this.mCurrentFilterIndex != v) {
                            SearchAndAddFilterSortbarViewHolder.i(SearchAndAddFilterSortbarViewHolder.this, v);
                            if(SearchAndAddFilterSortbarViewHolder.this.mFilterItems != null) {
                                SearchAndAddFilterSortbarViewHolder.this.mFilterTv.setText(((j)SearchAndAddFilterSortbarViewHolder.this.mFilterItems.get(SearchAndAddFilterSortbarViewHolder.this.mCurrentFilterIndex)).b);
                                String s = ((j)SearchAndAddFilterSortbarViewHolder.this.mFilterItems.get(SearchAndAddFilterSortbarViewHolder.this.mCurrentFilterIndex)).c;
                                SearchAndAddFilterSortbarViewHolder.k(SearchAndAddFilterSortbarViewHolder.this, s, com.iloen.melon.fragments.searchandadd.SearchAndAddFilterSortbarViewHolder.1.this.val$tabType, com.iloen.melon.fragments.searchandadd.SearchAndAddFilterSortbarViewHolder.1.this.val$showFilter);
                            }
                        }
                    }
                });
                singleFilterListPopup0.setSelection(SearchAndAddFilterSortbarViewHolder.b(SearchAndAddFilterSortbarViewHolder.this));
                singleFilterListPopup0.setOnDismissListener(SearchAndAddFilterSortbarViewHolder.f(SearchAndAddFilterSortbarViewHolder.this).getDialogDismissListener());
                SearchAndAddFilterSortbarViewHolder.f(SearchAndAddFilterSortbarViewHolder.this).setRetainDialog(singleFilterListPopup0);
                singleFilterListPopup0.show();
            }
        });
        ArrayList arrayList0 = this.mFilterItems;
        if(arrayList0 != null) {
            this.mFilterTv.setText(((j)arrayList0.get(0)).b);
            this.initSortingBarViewItems(((j)this.mFilterItems.get(0)).c, v, z);
        }
        this.mSortingBarView.setOnSortSelectionListener(new d() {
            @Override  // a9.d
            public void onSelected(int v) {
                SearchAndAddFilterSortbarViewHolder.j(SearchAndAddFilterSortbarViewHolder.this, v);
                SearchAndAddFilterSortbarViewHolder.g(SearchAndAddFilterSortbarViewHolder.this).onSelected(SearchAndAddFilterSortbarViewHolder.this.mFilterType, SearchAndAddFilterSortbarViewHolder.h(SearchAndAddFilterSortbarViewHolder.this));
            }
        });
    }

    public static FragmentActivity a(SearchAndAddFilterSortbarViewHolder searchAndAddFilterSortbarViewHolder0) {
        return searchAndAddFilterSortbarViewHolder0.mActivity;
    }

    public static MelonBaseFragment f(SearchAndAddFilterSortbarViewHolder searchAndAddFilterSortbarViewHolder0) {
        return searchAndAddFilterSortbarViewHolder0.mFragment;
    }

    public static OnFilterListener g(SearchAndAddFilterSortbarViewHolder searchAndAddFilterSortbarViewHolder0) {
        return searchAndAddFilterSortbarViewHolder0.mOnFilterListener;
    }

    public static int getLayoutRsId() [...] // Inlined contents

    private String[] getSortingBarItems(String s, int v) {
        if(v == 0) {
            return MelonAppBase.instance.getContext().getResources().getStringArray(0x7F030043);  // array:sortingbar_myplaylist
        }
        if(v == 1) {
            if("M20002".equals(s)) {
                return MelonAppBase.instance.getContext().getResources().getStringArray(0x7F030037);  // array:sortingbar_djplaylist
            }
            return "M20004".equals(s) ? MelonAppBase.instance.getContext().getResources().getStringArray(0x7F030034) : MelonAppBase.instance.getContext().getResources().getStringArray(0x7F030046);  // array:sortingbar_artistplaylist
        }
        return null;
    }

    public static int h(SearchAndAddFilterSortbarViewHolder searchAndAddFilterSortbarViewHolder0) {
        return searchAndAddFilterSortbarViewHolder0.mSortType;
    }

    public static void i(SearchAndAddFilterSortbarViewHolder searchAndAddFilterSortbarViewHolder0, int v) {
        searchAndAddFilterSortbarViewHolder0.mCurrentFilterIndex = v;
    }

    private void initSortingBarViewItems(String s, int v, boolean z) {
        this.mFilterType = s;
        this.mSortType = 0;
        String[] arr_s = this.getSortingBarItems(s, v);
        SortingBarView sortingBarView0 = this.mSortingBarView;
        if(sortingBarView0 != null && arr_s != null && arr_s.length >= 2) {
            sortingBarView0.setItems(arr_s);
            if(arr_s.length != 2) {
                if(arr_s.length == 3) {
                    if(z) {
                        this.mSortingBarView.setSortBarStyle(5);
                    }
                    else {
                        this.mSortingBarView.setSortBarStyle(2);
                    }
                }
            }
            else if(z) {
                this.mSortingBarView.setSortBarStyle(4);
            }
            else {
                this.mSortingBarView.setSortBarStyle(1);
            }
            this.mSortingBarView.setSelection(0);
        }
    }

    public static void j(SearchAndAddFilterSortbarViewHolder searchAndAddFilterSortbarViewHolder0, int v) {
        searchAndAddFilterSortbarViewHolder0.mSortType = v;
    }

    public static void k(SearchAndAddFilterSortbarViewHolder searchAndAddFilterSortbarViewHolder0, String s, int v, boolean z) {
        searchAndAddFilterSortbarViewHolder0.initSortingBarViewItems(s, v, z);
    }

    private ArrayList makeFilterData(int v) {
        ArrayList arrayList0 = new ArrayList();
        if(v == 0) {
            arrayList0.add(this.makeFilterDataPlaylist());
            arrayList0.add(this.makeFilterDataDjPlaylist());
            return arrayList0;
        }
        if(v == 1) {
            arrayList0.add(this.makeFilterDataPlaylist());
            arrayList0.add(this.makeFilterDataDjPlaylist());
            arrayList0.add(this.makeFilterDataArtistPlaylist());
        }
        return arrayList0;
    }

    private j makeFilterDataArtistPlaylist() {
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.b = "아티스트 플레이리스트";
        j0.c = "M20004";
        return j0;
    }

    private j makeFilterDataDjPlaylist() {
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.b = "DJ플레이리스트";
        j0.c = "M20002";
        return j0;
    }

    private j makeFilterDataPlaylist() {
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.b = "플레이리스트";
        j0.c = "M20001";
        return j0;
    }

    public void setOnFilterListener(OnFilterListener searchAndAddFilterSortbarViewHolder$OnFilterListener0) {
        this.mOnFilterListener = searchAndAddFilterSortbarViewHolder$OnFilterListener0;
    }

    public void setSortbarVisibility(int v) {
        SortingBarView sortingBarView0 = this.mSortingBarView;
        if(sortingBarView0 != null) {
            sortingBarView0.setVisibility(v);
        }
        View view0 = this.mUnderline;
        if(view0 != null) {
            if(!this.mShowFilter) {
                v = 8;
            }
            view0.setVisibility(v);
        }
    }
}

