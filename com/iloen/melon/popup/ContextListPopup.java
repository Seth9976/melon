package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.PopupTextListAdapter;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import java.util.ArrayList;

public class ContextListPopup extends TextListPopup implements ForegroundPopup {
    public interface OnButtonClickListener {
        void onClick(View arg1, ContextItemInfo arg2);
    }

    public interface OnContextItemClickListener {
        void onContextItemClick(ContextItemInfo arg1, ContextItemType arg2, Params arg3);
    }

    public interface OnMenuItemClickListener {
        void onItemClick(ContextItemInfo arg1, ContextItemType arg2, Params arg3);
    }

    public ArrayList g;
    public String h;

    public ContextListPopup(Activity activity0) {
        super(activity0);
        this.g = null;
        this.h = "";
        this.mAdapter = new PopupTextListAdapter(this.getContext());
    }

    @Override  // com.iloen.melon.popup.TextListPopup
    public j0 createAdapter(Context context0) {
        if(this.mAdapter == null) {
            ArrayList arrayList0 = this.g;
            PopupTextListAdapter popupTextListAdapter0 = new PopupTextListAdapter(context0);
            popupTextListAdapter0.g = arrayList0;
            popupTextListAdapter0.e = 1;
            this.mAdapter = popupTextListAdapter0;
        }
        this.mAdapter.d = this.getItemBgColor();
        this.mAdapter.h = this.getTextColor();
        this.mAdapter.notifyDataSetChanged();
        return this.mAdapter;
    }

    public String getTag() {
        return this.h;
    }

    public void setAdapter(PopupTextListAdapter popupTextListAdapter0) {
        this.mAdapter = popupTextListAdapter0;
    }

    public void setListItems(ArrayList arrayList0) {
        this.g = arrayList0;
        this.mAdapter.g = arrayList0;
        this.mAdapter.e = 1;
        this.mAdapter.notifyDataSetChanged();
    }

    public void setOnButtonClickListener(OnButtonClickListener contextListPopup$OnButtonClickListener0) {
        PopupTextListAdapter popupTextListAdapter0 = this.mAdapter;
        popupTextListAdapter0.l = new OnButtonClickListener() {
            public final OnButtonClickListener a;
            public final ContextListPopup b;

            {
                OnButtonClickListener contextListPopup$OnButtonClickListener0 = contextListPopup$OnButtonClickListener0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.b = contextListPopup0;
                this.a = contextListPopup$OnButtonClickListener0;
            }

            @Override  // com.iloen.melon.popup.ContextListPopup$OnButtonClickListener
            public void onClick(View view0, ContextItemInfo contextItemInfo0) {
                this.a.onClick(view0, contextItemInfo0);
                this.b.dismiss();
            }
        };
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener contextListPopup$OnMenuItemClickListener0) {
        PopupTextListAdapter popupTextListAdapter0 = this.mAdapter;
        popupTextListAdapter0.k = new OnContextItemClickListener() {
            public final OnMenuItemClickListener a;
            public final ContextListPopup b;

            {
                OnMenuItemClickListener contextListPopup$OnMenuItemClickListener0 = contextListPopup$OnMenuItemClickListener0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.b = contextListPopup0;
                this.a = contextListPopup$OnMenuItemClickListener0;
            }

            @Override  // com.iloen.melon.popup.ContextListPopup$OnContextItemClickListener
            public void onContextItemClick(ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
                this.a.onItemClick(contextItemInfo0, contextItemType0, contextItemInfo$Params0);
                this.b.dismiss();
            }
        };
    }

    public void setSubButtonState(ContextItemType contextItemType0, boolean z) {
        PopupTextListAdapter popupTextListAdapter0 = this.mAdapter;
        if(popupTextListAdapter0 != null) {
            popupTextListAdapter0.i.put(contextItemType0, Boolean.valueOf(z));
            popupTextListAdapter0.notifyDataSetChanged();
        }
    }

    public void setTag(String s) {
        this.h = s;
    }
}

