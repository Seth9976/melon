package com.iloen.melon.fragments.searchandadd;

import a9.d;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.G;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.net.v4x.response.DjPopularListCateBaseRes.response.CATELIST;
import com.iloen.melon.popup.SingleFilterListPopup;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import v9.j;

public class SearchAndAddFilterViewHolder extends O0 {
    public interface OnFilterListener {
        void onSelected(String arg1);
    }

    private FragmentActivity mActivity;
    private int mCurrentFilterIndex;
    private FilterDropDownView mFilterDropDownView;
    private ArrayList mFilterItems;
    private TextView mFilterTv;
    private String mFilterType;
    private MelonBaseFragment mFragment;
    private OnFilterListener mOnFilterListener;
    private SortingBarView mSortingBarView;

    public SearchAndAddFilterViewHolder(View view0, FragmentActivity fragmentActivity0, MelonBaseFragment melonBaseFragment0) {
        super(view0);
        this.mCurrentFilterIndex = 0;
        this.mActivity = fragmentActivity0;
        this.mFragment = melonBaseFragment0;
        view0.setBackgroundColor(ColorUtils.getColor(view0.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
        ViewUtils.showWhen(view0.findViewById(0x7F0A0D6B), false);  // id:underline
        ViewUtils.showWhen(view0.findViewById(0x7F0A0D6D), false);  // id:underline_short
        FilterDropDownView filterDropDownView0 = (FilterDropDownView)view0.findViewById(0x7F0A04AA);  // id:filterdropdown
        this.mFilterDropDownView = filterDropDownView0;
        this.mFilterTv = (TextView)filterDropDownView0.findViewById(0x7F0A03FC);  // id:dropdown_text
        SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        this.mSortingBarView = sortingBarView0;
        ViewUtils.showWhen(sortingBarView0, false);
        this.mFilterDropDownView.setOnDropDownListener(new G() {
            @Override  // com.iloen.melon.custom.G
            public void onClick(FilterDropDownView filterDropDownView0) {
                SingleFilterListPopup singleFilterListPopup0 = new SingleFilterListPopup(SearchAndAddFilterViewHolder.this.mActivity, 0);
                singleFilterListPopup0.setFilterItem(SearchAndAddFilterViewHolder.this.mFilterItems);
                singleFilterListPopup0.setFilterListener(new d() {
                    @Override  // a9.d
                    public void onSelected(int v) {
                        if(SearchAndAddFilterViewHolder.this.mCurrentFilterIndex != v) {
                            SearchAndAddFilterViewHolder.this.mCurrentFilterIndex = v;
                            if(SearchAndAddFilterViewHolder.this.mFilterItems != null) {
                                SearchAndAddFilterViewHolder.this.mFilterTv.setText(((j)SearchAndAddFilterViewHolder.this.mFilterItems.get(SearchAndAddFilterViewHolder.this.mCurrentFilterIndex)).b);
                                String s = ((j)SearchAndAddFilterViewHolder.this.mFilterItems.get(SearchAndAddFilterViewHolder.this.mCurrentFilterIndex)).c;
                                SearchAndAddFilterViewHolder.this.mFilterType = s;
                                SearchAndAddFilterViewHolder.this.mOnFilterListener.onSelected(SearchAndAddFilterViewHolder.this.mFilterType);
                            }
                        }
                    }
                });
                singleFilterListPopup0.setSelection(SearchAndAddFilterViewHolder.this.mCurrentFilterIndex);
                singleFilterListPopup0.setOnDismissListener(SearchAndAddFilterViewHolder.this.mFragment.getDialogDismissListener());
                SearchAndAddFilterViewHolder.this.mFragment.setRetainDialog(singleFilterListPopup0);
                singleFilterListPopup0.show();
            }
        });
    }

    public static int getLayoutRsId() [...] // Inlined contents

    private ArrayList makeFilterData(ArrayList arrayList0) {
        if(arrayList0 == null) {
            return null;
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.b = ((CATELIST)object0).cateName;
            j0.c = ((CATELIST)object0).cateCode;
            arrayList1.add(j0);
        }
        return arrayList1;
    }

    public void setFilterItems(ArrayList arrayList0) {
        ArrayList arrayList1 = this.makeFilterData(arrayList0);
        this.mFilterItems = arrayList1;
        if(arrayList1 != null) {
            this.mFilterTv.setText(((j)arrayList1.get(this.mCurrentFilterIndex)).b);
        }
    }

    public void setOnFilterListener(OnFilterListener searchAndAddFilterViewHolder$OnFilterListener0) {
        this.mOnFilterListener = searchAndAddFilterViewHolder$OnFilterListener0;
    }
}

