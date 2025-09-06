package com.iloen.melon.fragments.main.common;

import U4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.o;
import b3.Z;
import com.iloen.melon.custom.CheckableTagView;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.List;
import k8.t1;

public class TagCollectionView extends LinearLayout {
    public interface OnTagClickListener {
        void onClick(View arg1, int arg2);
    }

    private static final String TAG = "TagCollectionView";
    private boolean isSingleChoice;
    private ArrayList mCheckedTagItemViews;
    protected ArrayList mChildItemViews;
    private LayoutInflater mInflater;
    private int mItemHorizontalSpacing;
    private int mItemLayoutRes;
    private int mItemVerticalSpacing;
    private int mMaxColumnCount;
    private int mMaxRowCount;
    private OnTagClickListener mOnClickListener;
    private ArrayList mRowContainer;
    private int mRowGravity;
    private int mRowIndex;
    private int mRowLayoutGravity;
    private int mRowWidth;
    private View mSelectedView;

    public TagCollectionView(Context context0) {
        this(context0, null);
    }

    public TagCollectionView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public TagCollectionView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.isSingleChoice = false;
        this.mMaxColumnCount = 1000;
        this.mRowIndex = 0;
        this.mItemLayoutRes = 0x7F0D0902;  // layout:view_selector_tag
        this.mChildItemViews = new ArrayList();
        this.mCheckedTagItemViews = new ArrayList();
        if(this.isInEditMode()) {
            return;
        }
        this.mInflater = (LayoutInflater)this.getContext().getSystemService("layout_inflater");
        this.initLayout();
        this.getAttrs(context0, attributeSet0);
    }

    private void cleanRowLayout() {
        this.mRowContainer.clear();
        this.mChildItemViews.clear();
        this.removeAllViews();
        this.mRowIndex = 0;
    }

    private void createRowLayout() {
        LinearLayout linearLayout0 = new LinearLayout(this.getContext());
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-2, -2);
        linearLayout$LayoutParams0.gravity = this.mRowLayoutGravity;
        if(this.getChildCount() > 0) {
            linearLayout$LayoutParams0.setMargins(0, this.mItemVerticalSpacing, 0, 0);
        }
        linearLayout0.setLayoutParams(linearLayout$LayoutParams0);
        this.mRowContainer.add(linearLayout0);
        this.addView(linearLayout0);
        LogU.d("TagCollectionView", "createRowLayout() > max row count : " + this.mRowContainer.size());
    }

    public static int getAllItemWidth(Context context0, int v, ArrayList arrayList0, int v1) {
        TextView textView0 = (TextView)((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(v, null, false);
        textView0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int v3 = 0;
        for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
            textView0.setText(((String)arrayList0.get(v2)));
            textView0.measure(0, 0);
            if(v2 > 1) {
                v3 += v1;
            }
            v3 += textView0.getMeasuredWidth();
        }
        Z.r(v3, "getAllItemWidth() totalWidth : ", "TagCollectionView");
        return v3;
    }

    public static int getAllItemWidthExtraSize(Context context0, int v, ArrayList arrayList0, int v1, int v2) {
        int v3 = TagCollectionView.getAllItemWidth(context0, v, arrayList0, v1) / v2;
        LogU.d("TagCollectionView", "getAllItemWidthExtraSize() row : " + v3);
        TextView textView0 = (TextView)((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(v, null, false);
        textView0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int v5 = 0;
        for(int v4 = 0; v4 < arrayList0.size(); ++v4) {
            String s = (String)arrayList0.get(v4);
            textView0.setText(s);
            textView0.measure(0, 0);
            int v6 = textView0.getMeasuredWidth();
            StringBuilder stringBuilder0 = o.t(v5, v6, "getAllItemWidthExtraSize() extraWidth : ", "     itemWidth : ", "     item : ");
            stringBuilder0.append(s);
            stringBuilder0.append("     total : ");
            int v7 = v5 + v6;
            stringBuilder0.append(v7);
            LogU.d("TagCollectionView", stringBuilder0.toString());
            if(v3 <= v7) {
                return v7;
            }
            v5 = v7 + v1;
        }
        return v5;
    }

    private void getAttrs(Context context0, AttributeSet attributeSet0) {
        this.setTypedArray(context0.obtainStyledAttributes(attributeSet0, t1.H));
    }

    public View getChildView(int v) {
        return this.mChildItemViews.size() > 0 || this.mChildItemViews.size() > v ? ((View)this.mChildItemViews.get(v)) : null;
    }

    public int getItemLayoutRes() {
        return this.mItemLayoutRes;
    }

    private int getRowLayoutCount() {
        LogU.i("TagCollectionView", "getRowLayoutCount() getChildViewCount : " + this.getChildCount());
        LogU.i("TagCollectionView", "getRowLayoutCount() get mRowContainer.size() : " + this.mRowContainer.size());
        return this.getChildCount();
    }

    private void initLayout() {
        this.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mRowContainer = new ArrayList();
        this.setOrientation(1);
    }

    public void onAttachItemView(ArrayList arrayList0) {
        if(arrayList0 != null && arrayList0.size() >= 0) {
            this.cleanRowLayout();
            if(this.getRowLayoutCount() <= 0) {
                this.createRowLayout();
            }
            for(int v = 0; v < arrayList0.size(); ++v) {
                Object object0 = arrayList0.get(v);
                ViewGroup viewGroup0 = (ViewGroup)this.mRowContainer.get(this.mRowIndex);
                View view0 = this.onCreateChildView(this.mInflater, viewGroup0, object0);
                view0.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(TagCollectionView.this.mOnClickListener != null) {
                            TagCollectionView.this.mOnClickListener.onClick(view0, v);
                        }
                    }
                });
                view0.measure(0, 0);
                ((LinearLayout)this.mRowContainer.get(this.mRowIndex)).measure(0, 0);
                int v1 = view0.getMeasuredWidth();
                if(v > 0) {
                    v1 += this.mItemHorizontalSpacing;
                }
                int v2 = ((LinearLayout)this.mRowContainer.get(this.mRowIndex)).getMeasuredWidth();
                StringBuilder stringBuilder0 = new StringBuilder("onAttachItemView() mRowWidth : ");
                x.x(stringBuilder0, this.mRowWidth, "     containerWidth : ", v2, "     itemWidth : ");
                stringBuilder0.append(v1);
                stringBuilder0.append("     item : ");
                stringBuilder0.append(object0);
                stringBuilder0.append("     total : ");
                int v3 = v2 + v1;
                Z.s(v3, "TagCollectionView", stringBuilder0);
                if(v3 <= this.mRowWidth) {
                    if(((LinearLayout)this.mRowContainer.get(this.mRowIndex)).getChildCount() >= this.mMaxColumnCount) {
                        if(this.mRowIndex >= this.mMaxRowCount - 1) {
                            break;
                        }
                        this.createRowLayout();
                        ++this.mRowIndex;
                    }
                }
                else if(((LinearLayout)this.mRowContainer.get(this.mRowIndex)).getChildCount() > 0) {
                    if(this.mRowIndex >= this.mMaxRowCount - 1) {
                        break;
                    }
                    this.createRowLayout();
                    ++this.mRowIndex;
                    LogU.d("TagCollectionView", "insert row index : " + this.mRowIndex + " : " + object0);
                }
                LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)view0.getLayoutParams();
                if(((LinearLayout)this.mRowContainer.get(this.mRowIndex)).getChildCount() <= 0) {
                    linearLayout$LayoutParams0.setMargins(0, 0, 0, 0);
                }
                else {
                    linearLayout$LayoutParams0.setMargins(this.mItemHorizontalSpacing, 0, 0, 0);
                }
                LogU.d("TagCollectionView", "insert row index : " + this.mRowIndex + "   item : " + object0);
                this.mChildItemViews.add(view0);
                ((LinearLayout)this.mRowContainer.get(this.mRowIndex)).addView(view0, linearLayout$LayoutParams0);
            }
            this.invalidate();
            return;
        }
        LogU.d("TagCollectionView", "item is null");
    }

    public View onCreateChildView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Object object0) {
        View view0 = layoutInflater0.inflate(this.getItemLayoutRes(), viewGroup0, false);
        if(view0 instanceof TextView) {
            view0.setTag(object0);
            ((TextView)view0).setText(object0.toString());
        }
        return view0;
    }

    @Override  // android.widget.LinearLayout
    public void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.mRowWidth < 0) {
            this.mRowWidth = this.getMeasuredWidth();
        }
    }

    public void onUpdateCheckedItem(String s) {
        for(int v = 0; v < this.mRowContainer.size(); ++v) {
            LinearLayout linearLayout0 = (LinearLayout)this.mRowContainer.get(v);
            for(int v1 = 0; v1 < linearLayout0.getChildCount(); ++v1) {
                CheckableTagView checkableTagView0 = (CheckableTagView)linearLayout0.getChildAt(v1);
                checkableTagView0.setChecked(checkableTagView0.getText().toString().equals(s));
            }
        }
    }

    public void onUpdateCheckedItems(List list0) {
        for(int v = 0; v < this.mRowContainer.size(); ++v) {
            LinearLayout linearLayout0 = (LinearLayout)this.mRowContainer.get(v);
            for(int v1 = 0; v1 < linearLayout0.getChildCount(); ++v1) {
                CheckableTagView checkableTagView0 = (CheckableTagView)linearLayout0.getChildAt(v1);
                checkableTagView0.setChecked(list0.contains(checkableTagView0.getText().toString()));
            }
        }
    }

    public void setItemHorizontalSpacing(int v) {
        if(v == -1) {
            this.mItemHorizontalSpacing = this.getResources().getDimensionPixelSize(0x7F070450);  // dimen:tag_collection_horizontal_spacing
            return;
        }
        this.mItemHorizontalSpacing = v;
    }

    public void setItemLayoutRes(int v) {
        if(v == -1) {
            v = 0x7F0D0902;  // layout:view_selector_tag
        }
        this.mItemLayoutRes = v;
    }

    public void setItemVerticalSpacing(int v) {
        if(v == -1) {
            this.mItemVerticalSpacing = this.getResources().getDimensionPixelSize(0x7F070451);  // dimen:tag_collection_vertical_spacing
            return;
        }
        this.mItemVerticalSpacing = v;
    }

    public void setItems(ArrayList arrayList0) {
        this.setItems(arrayList0, null);
    }

    public void setItems(ArrayList arrayList0, OnTagClickListener tagCollectionView$OnTagClickListener0) {
        this.onAttachItemView(arrayList0);
        this.mOnClickListener = tagCollectionView$OnTagClickListener0;
    }

    public void setMaxColumnCount(int v) {
        if(v == -1) {
            this.mMaxColumnCount = 1000;
            return;
        }
        this.mMaxColumnCount = v;
    }

    public void setMaxRowCount(int v) {
        if(v == -1) {
            this.mMaxRowCount = 1000;
            return;
        }
        this.mMaxRowCount = v;
    }

    public void setOnItemClickListener(OnTagClickListener tagCollectionView$OnTagClickListener0) {
        this.mOnClickListener = tagCollectionView$OnTagClickListener0;
    }

    public void setRowWidth(int v) {
        this.mRowWidth = v;
    }

    private void setTypedArray(TypedArray typedArray0) {
        this.mRowWidth = typedArray0.getDimensionPixelSize(4, -1);
        switch(typedArray0.getInt(5, -1)) {
            case 3: {
                this.mRowGravity = 3;
                break;
            }
            case 5: {
                this.mRowGravity = 5;
                break;
            }
            default: {
                this.mRowGravity = 17;
            }
        }
        switch(typedArray0.getInt(6, -1)) {
            case 3: {
                this.mRowLayoutGravity = 3;
                break;
            }
            case 5: {
                this.mRowLayoutGravity = 5;
                break;
            }
            default: {
                this.mRowLayoutGravity = 17;
            }
        }
        this.setMaxRowCount(typedArray0.getInt(3, -1));
        this.setMaxColumnCount(typedArray0.getInt(2, -1));
        this.setItemHorizontalSpacing(typedArray0.getDimensionPixelSize(0, -1));
        this.setItemVerticalSpacing(typedArray0.getDimensionPixelSize(1, -1));
        typedArray0.recycle();
    }
}

