package com.iloen.melon.popup;

import U4.x;
import a9.d;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.U0;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.fragments.DetailTabPagerBaseFragment;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import v9.j;

public class SingleFilterListPopup extends AbsListPopup implements ForegroundPopup {
    public class FilterAdapter extends y {
        public int a;
        public final int b;
        public int c;
        public int d;
        public boolean e;
        public final boolean f;
        public final SingleFilterListPopup g;

        public FilterAdapter(Context context0, ArrayList arrayList0) {
            super(context0, arrayList0);
            boolean z = false;
            this.a = 0;
            this.b = -1;
            this.c = ColorUtils.getColor(this.getContext(), 0x7F060163);  // color:gray700s
            this.d = ColorUtils.getColor(this.getContext(), 0x7F06017C);  // color:green500s_support_high_contrast
            this.e = false;
            this.f = false;
            if(singleFilterListPopup0.mOption == 1) {
                z = true;
            }
            this.f = z;
            if(z) {
                this.c = ColorUtils.getColor(context0, 0x7F06003F);  // color:black_60
            }
        }

        public int getSelectedPosition() {
            return this.a;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            String s1;
            String s;
            j j0 = (j)this.getItem(v1);
            if(o00 instanceof FilterViewHolder) {
                boolean z = this.a == v1;
                int v2 = this.b;
                if(v2 != -1) {
                    ((FilterViewHolder)o00).a.setBackgroundColor(v2);
                }
                if(this.f) {
                    if(j0.b.endsWith("forward")) {
                        s = j0.b.replace("forward", "");
                        s1 = "(가나다)";
                    }
                    else if(j0.b.endsWith("reverse")) {
                        s = j0.b.replace("reverse", "");
                        s1 = "(다나가)";
                    }
                    else {
                        s = j0.b;
                        s1 = null;
                    }
                    Objects.requireNonNull(this.getContext());
                    ((FilterViewHolder)o00).b.setContentDescription(String.format("%s, 정렬 기준 닫기, 버튼", s));
                }
                else {
                    s = j0.b;
                    s1 = null;
                }
                CheckableTextView checkableTextView0 = ((FilterViewHolder)o00).d;
                TextView textView0 = ((FilterViewHolder)o00).c;
                ((FilterViewHolder)o00).b.setText(s);
                ((FilterViewHolder)o00).b.setSelected(z);
                int v3 = z ? this.d : this.c;
                ((FilterViewHolder)o00).b.setTextColor(v3);
                if(s1 == null) {
                    ViewUtils.showWhen(textView0, false);
                }
                else {
                    ViewUtils.showWhen(textView0, true);
                    textView0.setText(s1);
                    textView0.setSelected(z);
                    textView0.setTextColor(v3);
                }
                ViewUtils.showWhen(((FilterViewHolder)o00).e, z);
                ViewUtils.showWhen(checkableTextView0, this.e);
                j0.getClass();
                if(TextUtils.isEmpty(null)) {
                    ViewUtils.hideWhen(checkableTextView0, true);
                }
                else {
                    checkableTextView0.setText(null);
                    checkableTextView0.setChecked(z);
                }
                ViewUtils.showWhen(((FilterViewHolder)o00).f, "Y".equals(null));
                com.iloen.melon.popup.SingleFilterListPopup.FilterAdapter.1 singleFilterListPopup$FilterAdapter$10 = new View.OnClickListener() {
                    public final int a;
                    public final FilterAdapter b;

                    {
                        int v = v;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.b = singleFilterListPopup$FilterAdapter0;
                        this.a = v;
                    }

                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        SingleFilterListPopup.this.setSelection(this.a);
                        SingleFilterListPopup.this.dismiss();
                    }
                };
                ViewUtils.setOnClickListener(((FilterViewHolder)o00).itemView, singleFilterListPopup$FilterAdapter$10);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D084C, viewGroup0, false);  // layout:sort_single_filter_item
            return new FilterViewHolder(SingleFilterListPopup.this, view0);
        }

        public void setItemSelectedTextColor(int v) {
            this.d = ColorUtils.getColor(this.getContext(), v);
            this.notifyDataSetChanged();
        }

        public void setItemTextColor(int v) {
            this.c = ColorUtils.getColor(this.getContext(), v);
            this.notifyDataSetChanged();
        }

        public void setSelectedPosition(int v) {
            this.a = v;
            this.notifyDataSetChanged();
        }

        public void showCount() {
            this.e = true;
            this.notifyDataSetChanged();
        }
    }

    class FilterViewHolder extends O0 {
        public final View a;
        public final TextView b;
        public final TextView c;
        public final CheckableTextView d;
        public final ImageView e;
        public final TextView f;

        public FilterViewHolder(View view0) {
            super(view0);
            this.a = view0.findViewById(0x7F0A05A7);  // id:item_container
            this.b = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.c = (TextView)view0.findViewById(0x7F0A0C5E);  // id:tv_desc
            this.d = (CheckableTextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
            this.e = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
            this.f = (TextView)view0.findViewById(0x7F0A0CCA);  // id:tv_new
        }
    }

    public interface OnSectionedSortSelectionListener {
        void onSelected(int arg1, int arg2);
    }

    public static final class Option {
        public static final int NONE = 0;
        public static final int SORT_IN_MUSIC_PLAYLIST = 1;

    }

    public static class SectionedFilter {
        public int a;
        public int b;
        public ArrayList sectionContents;
        public String sectionName;

        public SectionedFilter(String s, ArrayList arrayList0) {
            this.sectionName = s;
            this.sectionContents = arrayList0;
        }

        public int getSectionLength() {
            return this.sectionContents == null ? 0 : this.sectionContents.size();
        }

        public int getSectionPosition() {
            return this.a;
        }

        public int getSectionPositionInFilter() {
            return this.b;
        }

        public void setSectionPosition(int v) {
            this.a = v;
        }

        public void setSectionPositionInFilter(int v) {
            this.b = v;
        }
    }

    class SectionedFilterAdapter extends j0 {
        class SectionViewHolder extends O0 {
            public final TextView a;

            public SectionViewHolder(View view0) {
                super(view0);
                this.a = (TextView)view0.findViewById(0x7F0A0D06);  // id:tv_section
            }
        }

        public final LayoutInflater a;
        public ArrayList b;
        public ArrayList c;
        public final ArrayList d;
        public boolean e;
        public int f;
        public final SingleFilterListPopup g;

        public SectionedFilterAdapter(Context context0) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = false;
            this.f = 0x7F060163;  // color:gray700s
            this.a = (LayoutInflater)context0.getSystemService("layout_inflater");
            this.d = new ArrayList();
        }

        public SectionedFilterAdapter(Context context0, ArrayList arrayList0) {
            this(context0);
            this.setItems(arrayList0);
        }

        public final int a(int v) {
            int v1 = 0;
            ArrayList arrayList0 = this.b;
            int v2 = -1;
            if(arrayList0 != null) {
                if(!this.e) {
                    v2 = 0;
                }
                for(Object object0: arrayList0) {
                    SectionedFilter singleFilterListPopup$SectionedFilter0 = (SectionedFilter)object0;
                    v2 += singleFilterListPopup$SectionedFilter0.getSectionLength() + 1;
                    if(v < v2) {
                        return singleFilterListPopup$SectionedFilter0.getSectionPosition();
                    }
                    if(v == v2) {
                        v1 = singleFilterListPopup$SectionedFilter0.getSectionPosition() + 1;
                    }
                }
                return v1;
            }
            return -1;
        }

        public final boolean b() {
            boolean z = this.b != null && !this.b.isEmpty() && TextUtils.isEmpty(((SectionedFilter)this.b.get(0)).sectionName);
            return this.d == null || this.d.isEmpty() || ((FilterAdapter)this.d.get(0)).getItemCount() != 1 ? z : true;
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            int v = this.getSectionItemCount() + this.getSectionCount();
            return this.e ? v - 1 : v;
        }

        // 去混淆评级： 低(20)
        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            return this.isSectionHeaderPosition(v) ? 100 : super.getItemViewType(v);
        }

        public int getPositionInSection(int v) {
            int v1 = this.a(v);
            return !this.e || v1 != 0 ? v - (((int)(((Integer)this.c.get(v1)))) + 1) : v;
        }

        public int getSectionCount() {
            return this.b == null ? 0 : this.b.size();
        }

        public int getSectionHeaderHeight() {
            return ScreenUtils.dipToPixel(SingleFilterListPopup.this.getContext(), 24.0f);
        }

        public int getSectionItemCount() {
            ArrayList arrayList0 = this.b;
            int v = 0;
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    v += ((SectionedFilter)object0).getSectionLength();
                }
            }
            return v;
        }

        public boolean isSectionHeaderPosition(int v) {
            int v1 = this.a(v);
            return ((int)(((Integer)this.c.get(v1)))) == v;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(O0 o00, int v) {
            if(o00 instanceof SectionViewHolder) {
                String s = ((SectionedFilter)this.b.get(this.a(v))).sectionName;
                ((SectionViewHolder)o00).a.setText(s);
                return;
            }
            int v1 = this.a(v);
            int v2 = this.getPositionInSection(v);
            ((FilterAdapter)this.d.get(v1)).onBindViewHolder(o00, v2, v2);
            com.iloen.melon.popup.SingleFilterListPopup.SectionedFilterAdapter.1 singleFilterListPopup$SectionedFilterAdapter$10 = new View.OnClickListener() {
                public final int a;
                public final SectionedFilterAdapter b;

                {
                    int v = v;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.b = singleFilterListPopup$SectionedFilterAdapter0;
                    this.a = v;
                }

                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    SingleFilterListPopup.b(SingleFilterListPopup.this, this.a);
                    SingleFilterListPopup.this.dismiss();
                }
            };
            ViewUtils.setOnClickListener(o00.itemView, singleFilterListPopup$SectionedFilterAdapter$10);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            if(v == 100) {
                return new SectionViewHolder(this, this.a.inflate(0x7F0D0279, viewGroup0, false));  // layout:filter_section_layout
            }
            View view0 = LayoutInflater.from(SingleFilterListPopup.this.getContext()).inflate(0x7F0D084C, viewGroup0, false);  // layout:sort_single_filter_item
            return new FilterViewHolder(SingleFilterListPopup.this, view0);
        }

        public void setItemTextColor(int v) {
            this.f = v;
            this.notifyDataSetChanged();
        }

        public void setItems(ArrayList arrayList0) {
            this.b = arrayList0;
            ArrayList arrayList1 = this.d;
            arrayList1.clear();
            for(Object object0: arrayList0) {
                Context context0 = SingleFilterListPopup.this.getContext();
                FilterAdapter singleFilterListPopup$FilterAdapter0 = new FilterAdapter(SingleFilterListPopup.this, context0, ((SectionedFilter)object0).sectionContents);
                singleFilterListPopup$FilterAdapter0.setItemTextColor(this.f);
                arrayList1.add(singleFilterListPopup$FilterAdapter0);
            }
            ArrayList arrayList2 = this.b;
            this.e = this.b();
            this.c = new ArrayList();
            if(arrayList2.size() > 0) {
                int v = this.e ? -1 : 0;
                this.c.add(v);
                for(int v1 = 0; v1 < arrayList2.size() - 1; v1 = a.d(v, v1, 1, this.c)) {
                    v += ((SectionedFilter)arrayList2.get(v1)).getSectionLength() + 1;
                }
            }
            for(int v2 = 0; v2 < arrayList2.size(); ++v2) {
                SectionedFilter singleFilterListPopup$SectionedFilter0 = (SectionedFilter)arrayList2.get(v2);
                singleFilterListPopup$SectionedFilter0.setSectionPosition(v2);
                if(!this.e) {
                    singleFilterListPopup$SectionedFilter0.setSectionPositionInFilter(((int)(((Integer)this.c.get(v2)))));
                }
                else if(v2 == 0) {
                    singleFilterListPopup$SectionedFilter0.setSectionPositionInFilter(0);
                }
                else {
                    singleFilterListPopup$SectionedFilter0.setSectionPositionInFilter(((int)(((Integer)this.c.get(v2)))));
                }
            }
            this.notifyDataSetChanged();
        }

        public void setSelectedPosition(int v, int v1) {
            ArrayList arrayList0 = this.d;
            if(arrayList0 != null) {
                ((FilterAdapter)arrayList0.get(v)).setSelectedPosition(v1);
                for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
                    if(v2 != v) {
                        ((FilterAdapter)arrayList0.get(v2)).setSelectedPosition(-1);
                    }
                }
                this.notifyDataSetChanged();
            }
        }
    }

    public static final class Theme {
        public static int BLACK_FIXED = 1;
        public static int DEFAULT;
        public static int WHITE;

    }

    public static final class Type {
        public static final int NORMAL = 0;
        public static final int NORMAL_WITH_COUNT = 2;
        public static final int SECTIONED = 1;

    }

    static class UiHandler extends U0 {
        public UiHandler(SingleFilterListPopup singleFilterListPopup0) {
            super(singleFilterListPopup0);
        }

        public void handleMessage(SingleFilterListPopup singleFilterListPopup0, Message message0) {
            if(message0.what != 1000) {
                return;
            }
            SingleFilterListPopup.c(singleFilterListPopup0);
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((SingleFilterListPopup)object0), message0);
        }
    }

    private final int MAX_DP_COUNT;
    private static final int REQUEST_FOCUS = 1000;
    public static final String SORT_CLEAR = "";
    public static final String SORT_FORWARD = "forward";
    public static final String SORT_REVERSE = "reverse";
    private static final String TAG = "SingleFilterListPopup";
    private FilterAdapter mAdapter;
    private float mAnimDelta;
    private int mCustomMargin;
    private int mFilterType;
    private UiHandler mHandler;
    private int mOption;
    private SectionedFilterAdapter mSectionedAdapter;
    private OnSectionedSortSelectionListener mSectionedSortSelectionListener;
    private d mSortSelectionListener;
    private int mTheme;
    private int mTopMargin;
    private int mTopMarginType;

    public SingleFilterListPopup(Activity activity0) {
        this(activity0, 0);
    }

    public SingleFilterListPopup(Activity activity0, int v) {
        this(activity0, v, -1);
    }

    public SingleFilterListPopup(Activity activity0, int v, int v1) {
        this(activity0, v, v1, 0);
    }

    public SingleFilterListPopup(Activity activity0, int v, int v1, int v2) {
        this(activity0, v, v1, 0, Theme.DEFAULT);
    }

    public SingleFilterListPopup(Activity activity0, int v, int v1, int v2, int v3) {
        super(activity0);
        this.mHandler = new UiHandler(this);
        this.MAX_DP_COUNT = 6;
        this.mAnimDelta = -1.0f;
        this.mAdapter = null;
        this.mSectionedAdapter = null;
        this.mSortSelectionListener = null;
        this.mSectionedSortSelectionListener = null;
        this.mTopMargin = 0;
        this.mCustomMargin = 0;
        this.mFilterType = v;
        this.mTopMarginType = v1;
        this.mOption = v2;
        this.mTheme = v3;
        if(v1 < 0) {
            this.mTopMarginType = MelonFragmentManager.getInstance().getCurrentFragment() instanceof MelonPagerFragment ? 1 : 2;
        }
        this.setDim(false);
        Context context0 = this.getContext();
        int v4 = (int)context0.getResources().getDimension(0x7F07046D);  // dimen:top_container_height
        int v5 = this.getTabLayoutHeight();
        this.mTopMargin = 0;
        switch(this.mTopMarginType) {
            case 0: {
                this.mTopMargin = v4;
                break;
            }
            case 1: {
                this.mTopMargin = v5;
                break;
            }
            case 3: {
                this.mTopMargin = context0.getResources().getDimensionPixelSize(0x7F070414);  // dimen:player_playlist_tab_height
                break;
            }
            case 4: {
                this.mTopMargin = context0.getResources().getDimensionPixelSize(0x7F0703F4);  // dimen:new_tab_container_height
                break;
            }
            default: {
                this.mTopMargin = v4 + v5;
            }
        }
        int v6 = this.mFilterType;
        if(v6 == 0) {
            this.mAdapter = new FilterAdapter(this, context0, null);
        }
        else if(v6 == 2) {
            FilterAdapter singleFilterListPopup$FilterAdapter0 = new FilterAdapter(this, context0, null);
            this.mAdapter = singleFilterListPopup$FilterAdapter0;
            singleFilterListPopup$FilterAdapter0.showCount();
        }
        else {
            this.mSectionedAdapter = new SectionedFilterAdapter(this, context0);
        }
        Context context1 = this.getContext();
        int v7 = this.mTheme;
        if(v7 == Theme.WHITE) {
            this.setBackgroundColor(ColorUtils.getColor(context1, 0x7F0604AA));  // color:white000s_support_high_contrast
            int v8 = this.mFilterType;
            if(v8 != 0 && v8 != 2) {
                if(v8 == 1) {
                    this.mSectionedAdapter.setItemTextColor(0x7F060163);  // color:gray700s
                }
                return;
            }
            this.mAdapter.setItemTextColor(0x7F060163);  // color:gray700s
            return;
        }
        if(v7 == Theme.BLACK_FIXED) {
            this.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06003D));  // color:black_45
            int v9 = this.mFilterType;
            if(v9 == 0 || v9 == 2) {
                this.mAdapter.setItemTextColor(0x7F0604C0);  // color:white_60
            }
            else if(v9 == 1) {
                this.mSectionedAdapter.setItemTextColor(0x7F0604C0);  // color:white_60
            }
            if(this.mFilterType == 0 || this.mFilterType == 2) {
                this.mAdapter.setItemSelectedTextColor(0x7F060019);  // color:accent_green
            }
            this.showBottomShadow(false);
            return;
        }
        LogU.d("SingleFilterListPopup", "setTheme() invalid theme.");
    }

    public static void b(SingleFilterListPopup singleFilterListPopup0, int v) {
        if(singleFilterListPopup0.mSectionedAdapter != null && singleFilterListPopup0.mSectionedAdapter.b != null && !singleFilterListPopup0.mSectionedAdapter.isSectionHeaderPosition(v)) {
            int v1 = singleFilterListPopup0.mSectionedAdapter.a(v);
            singleFilterListPopup0.mSectionedAdapter.setSelectedPosition(v1, singleFilterListPopup0.mSectionedAdapter.getPositionInSection(v));
            OnSectionedSortSelectionListener singleFilterListPopup$OnSectionedSortSelectionListener0 = singleFilterListPopup0.mSectionedSortSelectionListener;
            if(singleFilterListPopup$OnSectionedSortSelectionListener0 != null) {
                singleFilterListPopup$OnSectionedSortSelectionListener0.onSelected(v1, singleFilterListPopup0.mSectionedAdapter.getPositionInSection(v));
            }
        }
    }

    public static void c(SingleFilterListPopup singleFilterListPopup0) {
        LinearLayoutManager linearLayoutManager0 = singleFilterListPopup0.getLayoutManager();
        if(singleFilterListPopup0.getRecyclerView() != null) {
            FilterAdapter singleFilterListPopup$FilterAdapter0 = singleFilterListPopup0.mAdapter;
            if(singleFilterListPopup$FilterAdapter0 != null && linearLayoutManager0 != null && singleFilterListPopup0.mFilterType == 0) {
                int v = singleFilterListPopup$FilterAdapter0.getSelectedPosition();
                if(v > 0 || singleFilterListPopup0.isOverSize()) {
                    int v1 = linearLayoutManager0.findFirstCompletelyVisibleItemPosition();
                    int v2 = linearLayoutManager0.findLastCompletelyVisibleItemPosition();
                    int v3 = singleFilterListPopup0.getContext().getResources().getDimensionPixelSize(0x7F0702FE);  // dimen:melon_popup_filter_list_row_height
                    if(v1 > v || v2 <= v) {
                        int v4 = singleFilterListPopup0.mPopupHeight / 2 - v3;
                        LogU.d("SingleFilterListPopup", "updateCurrentPosition() recyclerView height: " + singleFilterListPopup0.mPopupHeight + ", offset: " + v4);
                        try {
                            linearLayoutManager0.scrollToPositionWithOffset(v, v4);
                        }
                        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                            LogU.d("SingleFilterListPopup", indexOutOfBoundsException0.toString());
                        }
                    }
                    StringBuilder stringBuilder0 = x.n(v, "updateCurrentPosition() recyclerView position: ", "/ size:");
                    stringBuilder0.append(singleFilterListPopup0.getItemCount());
                    stringBuilder0.append("/ visible item size:");
                    stringBuilder0.append(v2 - v1);
                    LogU.d("SingleFilterListPopup", stringBuilder0.toString());
                }
            }
        }
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public j0 createAdapter(Context context0) {
        int v = this.mFilterType;
        if(v == 0) {
            return this.mAdapter;
        }
        return v == 1 ? this.mSectionedAdapter : null;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public int getLayoutView() {
        return 0x7F0D084D;  // layout:sort_single_filter_layout
    }

    public int getTabLayoutHeight() {
        return (int)this.getContext().getResources().getDimension(0x7F07044F);  // dimen:tab_container_height
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public boolean isOverSize() {
        int v = this.mFilterType;
        if(v == 0) {
            return this.mAdapter == null ? false : this.mAdapter.getItemCount() > 6;
        }
        return v == 1 && (this.mSectionedAdapter != null && this.mSectionedAdapter.getItemCount() > 6);
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.mAnimDelta = TypedValue.applyDimension(0, ((float)this.mPopupHeight), this.getContext().getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-1, this.mPopupHeight);
        relativeLayout$LayoutParams0.width = -1;
        relativeLayout$LayoutParams0.height = this.mPopupHeight;
        this.getRecyclerView().setLayoutParams(relativeLayout$LayoutParams0);
        this.getProgress().setLayoutParams(relativeLayout$LayoutParams0);
        this.getEmptyView().setLayoutParams(relativeLayout$LayoutParams0);
        this.getRootView().setOnClickListener(new View.OnClickListener() {
            public final SingleFilterListPopup a;

            {
                this.a = singleFilterListPopup0;
            }

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                int v = view0.getId();
                SingleFilterListPopup singleFilterListPopup0 = this.a;
                if(v != singleFilterListPopup0.getRecyclerView().getId() && view0.getId() != singleFilterListPopup0.getProgress().getId() && view0.getId() != singleFilterListPopup0.getEmptyView().getId()) {
                    singleFilterListPopup0.dismiss();
                }
            }
        });
        View view0 = this.getRootView().findViewById(0x7F0A049B);  // id:filter_container
        if(view0 != null) {
            RelativeLayout.LayoutParams relativeLayout$LayoutParams1 = (RelativeLayout.LayoutParams)view0.getLayoutParams();
            relativeLayout$LayoutParams1.topMargin = this.mTopMargin + this.mCustomMargin;
            if(ScreenUtils.isTablet(this.getContext())) {
                relativeLayout$LayoutParams1.bottomMargin = ScreenUtils.getStatusBarHeight(this.getContext());
            }
        }
    }

    public void requestFocusCurrentPostion(int v) {
        if(this.mHandler.hasMessages(1000)) {
            this.mHandler.removeMessages(1000);
        }
        this.mHandler.sendEmptyMessageDelayed(1000, ((long)v));
    }

    public void setCustomMargin(int v) {
        this.mCustomMargin = v;
    }

    public void setFilterItem(ArrayList arrayList0) {
        this.mFilterType = 0;
        this.mAdapter.clear();
        this.mAdapter.addAll(arrayList0);
    }

    public void setFilterListener(d d0) {
        this.mSortSelectionListener = d0;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public boolean setPopupHeight() {
        int v = ScreenUtils.dipToPixel(this.getContext(), 300.0f);
        Resources resources0 = this.getContext().getResources();
        int v1 = resources0.getDimensionPixelSize(0x7F0702FE);  // dimen:melon_popup_filter_list_row_height
        int v2 = 0;
        if(this.mFilterType == 0 && (this.mAdapter != null && this.mAdapter.getItemCount() > 0)) {
            if(this.mOption == 1) {
                if(v1 > 0) {
                    int v3 = resources0.getDimensionPixelSize(0x7F0702FD);  // dimen:melon_popup_filter_list_last_row_height
                    for(v2 = this.mAdapter.getItemCount() * v1 + v3; v2 > v; v2 -= v1) {
                    }
                }
                this.mPopupHeight = v2;
                return true;
            }
            if(v1 > 0) {
                v2 = this.mAdapter.getItemCount() * v1;
                if(!TextUtils.isEmpty(this.getTitle())) {
                    v2 += this.getHeaderHeight();
                }
            }
            if(v2 <= v) {
                v = v2;
            }
            this.mPopupHeight = v;
            return true;
        }
        if(this.mFilterType == 1 && (this.mSectionedAdapter != null && this.mSectionedAdapter.getSectionCount() > 0)) {
            if(v1 > 0) {
                int v4 = this.mSectionedAdapter.getSectionItemCount();
                int v5 = this.mSectionedAdapter.getSectionHeaderHeight() * this.mSectionedAdapter.getSectionCount() + v1 * v4;
                if(this.mSectionedAdapter.b()) {
                    v5 -= this.mSectionedAdapter.getSectionHeaderHeight();
                }
                v2 = v5;
                if(!TextUtils.isEmpty(this.getTitle())) {
                    v2 += this.getHeaderHeight();
                }
            }
            if(v2 <= v) {
                v = v2;
            }
            this.mPopupHeight = v;
            return true;
        }
        this.mPopupHeight = v;
        return true;
    }

    public void setSectionedFilterItem(ArrayList arrayList0) {
        this.mFilterType = 1;
        this.mSectionedAdapter.setItems(arrayList0);
    }

    public void setSectionedFilterListener(OnSectionedSortSelectionListener singleFilterListPopup$OnSectionedSortSelectionListener0) {
        this.mSectionedSortSelectionListener = singleFilterListPopup$OnSectionedSortSelectionListener0;
    }

    public void setSelection(int v) {
        if(this.mFilterType == 0 && (this.mAdapter != null && this.mAdapter.getItemCount() > 0)) {
            this.mAdapter.setSelectedPosition(v);
            d d0 = this.mSortSelectionListener;
            if(d0 != null) {
                d0.onSelected(v);
            }
        }
    }

    public void setSelection(int v, int v1) {
        if(this.mFilterType == 1) {
            SectionedFilterAdapter singleFilterListPopup$SectionedFilterAdapter0 = this.mSectionedAdapter;
            if(singleFilterListPopup$SectionedFilterAdapter0 != null && singleFilterListPopup$SectionedFilterAdapter0.b != null) {
                singleFilterListPopup$SectionedFilterAdapter0.setSelectedPosition(v, v1);
                OnSectionedSortSelectionListener singleFilterListPopup$OnSectionedSortSelectionListener0 = this.mSectionedSortSelectionListener;
                if(singleFilterListPopup$OnSectionedSortSelectionListener0 != null) {
                    singleFilterListPopup$OnSectionedSortSelectionListener0.onSelected(v, v1);
                }
            }
        }
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    @NotNull
    public WindowManager.LayoutParams setWindowLayoutParams(WindowManager.LayoutParams windowManager$LayoutParams0) {
        windowManager$LayoutParams0.gravity = 0x30;
        windowManager$LayoutParams0.width = -1;
        windowManager$LayoutParams0.height = ScreenUtils.getScreenHeight(this.getContext());
        return windowManager$LayoutParams0;
    }

    @Override  // android.app.Dialog
    public void show() {
        this.show(true);
    }

    public void show(boolean z) {
        super.show();
        if(this.mOption == 1) {
            this.requestFocusCurrentPostion(100);
        }
        if(z) {
            I i0 = MelonFragmentManager.getInstance().getCurrentFragment();
            if(i0 instanceof MelonPagerFragment) {
                ((MelonPagerFragment)i0).collapseTitlebar();
                return;
            }
            if(i0 instanceof DetailTabPagerBaseFragment) {
                ((DetailTabPagerBaseFragment)i0).collapsedParallaxHeaderView(false);
                return;
            }
            if(i0 instanceof DetailMetaContentBaseFragment) {
                ((DetailMetaContentBaseFragment)i0).collapsedParallaxHeaderView(false);
            }
        }
    }
}

