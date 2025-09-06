package com.iloen.melon.adapters;

import W5.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.media3.session.H0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.popup.ContextListPopup.OnButtonClickListener;
import com.iloen.melon.popup.ContextListPopup.OnContextItemClickListener;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import n8.j;
import n8.k;
import n8.l;
import n8.n;
import n8.o;
import n8.p;
import v9.d;

public class PopupTextListAdapter extends j0 {
    public interface OnAddPositionSetListener {
        void g();
    }

    public final Context a;
    public final LayoutInflater b;
    public int c;
    public int d;
    public int e;
    public ArrayList f;
    public List g;
    public int h;
    public final HashMap i;
    public RecyclerItemClickListener.OnItemClickListener j;
    public OnContextItemClickListener k;
    public OnButtonClickListener l;

    public PopupTextListAdapter(Context context0) {
        this.a = null;
        this.b = null;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = null;
        this.g = null;
        this.h = -1;
        this.i = new HashMap();
        this.j = null;
        this.k = null;
        this.l = null;
        this.a = context0;
        this.b = LayoutInflater.from(context0);
        this.c = 0x7F0D05AB;  // layout:popup_listitem
        ColorUtils.getColor(context0, 0x7F06044E);  // color:primary_green
    }

    public final Object getItem(int v) {
        if(v >= 0) {
            if(this.e == 1) {
                return this.g == null || v >= this.g.size() || !((ContextItemInfo)this.g.get(v)).b ? null : this.g.get(v);
            }
            return this.f == null || v >= this.f.size() ? null : this.f.get(v);
        }
        return null;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        if(this.e == 1) {
            return this.g == null ? 0 : this.g.size();
        }
        return this.f == null ? 0 : this.f.size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final long getItemId(int v) {
        if(v >= 0) {
            if(this.e == 1) {
                return this.g == null || v >= this.g.size() ? -1L : ((long)((ContextItemInfo)this.g.get(v)).a.a);
            }
            return this.f == null || v >= this.f.size() ? -1L : ((long)((p)this.f.get(v)).a);
        }
        return -1L;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemViewType(int v) {
        Object object0 = this.getItem(v);
        if(object0 == null) {
            return -1;
        }
        if(object0 instanceof ContextItemInfo) {
            ContextItemType contextItemType0 = ((ContextItemInfo)object0).a;
            if(contextItemType0 == ContextItemType.p) {
                return 2;
            }
            if(contextItemType0 == ContextItemType.r) {
                return 8;
            }
            if(contextItemType0 == ContextItemType.s) {
                return 9;
            }
            if(contextItemType0 == ContextItemType.N) {
                return 4;
            }
            if(contextItemType0 == ContextItemType.O || contextItemType0 == ContextItemType.P) {
                return 6;
            }
            if(contextItemType0 == ContextItemType.q) {
                return 7;
            }
        }
        return v == this.getItemCount() - 1 ? 1 : 0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onBindViewHolder(O0 o00, int v) {
        if(o00 instanceof n) {
            int v1 = this.d == -1 ? 0x7F06048A : this.d;  // color:transparent
            ImageView imageView0 = ((n)o00).c;
            ImageView imageView1 = ((n)o00).b;
            TextView textView0 = ((n)o00).d;
            Context context0 = this.a;
            int v2 = ColorUtils.getColor(context0, v1);
            ((n)o00).a.setBackgroundColor(v2);
            int v3 = this.h;
            if(v3 != -1) {
                textView0.setTextColor(v3);
            }
            boolean z = true;
            switch(this.e) {
                case 0: {
                    ArrayList arrayList0 = this.f;
                    if(arrayList0 != null) {
                        p p0 = (p)arrayList0.get(v);
                        ((n)o00).itemView.setId(p0.a);
                        j j0 = new j(this, v, 0);
                        ViewUtils.setOnClickListener(((n)o00).itemView, j0);
                        if(p0.b <= 0) {
                            z = false;
                        }
                        ViewUtils.showWhen(imageView1, z);
                        int v4 = p0.b;
                        if(v4 > 0) {
                            imageView1.setImageResource(v4);
                        }
                        textView0.setText(p0.c);
                        ViewUtils.setContentDescriptionWithButtonClassName(((n)o00).itemView, p0.c);
                        return;
                    }
                    break;
                }
                case 1: {
                    List list0 = this.g;
                    if(list0 != null) {
                        ContextItemInfo contextItemInfo0 = (ContextItemInfo)list0.get(v);
                        if(contextItemInfo0 != null) {
                            boolean z1 = contextItemInfo0.b;
                            ((n)o00).itemView.setId(contextItemInfo0.a.a);
                            ContextItemType contextItemType0 = contextItemInfo0.a;
                            int v5 = z1 ? contextItemType0.d : contextItemType0.e;
                            ViewUtils.showWhen(imageView1, v5 > 0);
                            if(v5 > 0) {
                                imageView1.setImageResource(v5);
                            }
                            if(contextItemType0 instanceof d) {
                                textView0.setText(((d)contextItemType0).R);
                            }
                            else {
                                int v6 = contextItemType0.b;
                                if(v6 > 0) {
                                    textView0.setText(v6);
                                }
                            }
                            ViewUtils.setEnable(imageView1, z1, false, 0.18f);
                            ViewUtils.setEnable(textView0, z1, false, 0.18f);
                            ((n)o00).itemView.setClickable(z1);
                            if(z1) {
                                View view0 = ((n)o00).a;
                                if(view0 != null) {
                                    view0.setTag(contextItemInfo0.a);
                                }
                            }
                            ViewUtils.showWhen(((n)o00).e, false);
                            StringBuilder stringBuilder0 = new StringBuilder(textView0.getText());
                            ViewUtils.setContentDescriptionWithButtonClassName(((n)o00).itemView, stringBuilder0);
                            int v7 = this.getItemViewType(v);
                            if(v7 == 6) {
                                ViewUtils.showWhen(imageView0, true);
                                ViewUtils.setOnClickListener(imageView0, new j(this, v, 1));
                                if(context0 != null) {
                                    ViewUtils.setContentDescriptionWithButtonClassName(imageView0, "제외 콘텐츠 관리");
                                }
                            }
                            if(o00 instanceof o) {
                                AddPosition addPosition0 = AddPosition.c;
                                AddPosition addPosition1 = AddPosition.d;
                                switch(v7) {
                                    case 2: 
                                    case 7: {
                                        View view1 = ((o)o00).h;
                                        TextView textView1 = ((o)o00).i;
                                        if(((o)o00).a != null) {
                                            int v8 = context0.getResources().getDimensionPixelSize(0x7F0700AC);  // dimen:context_list_padding_left_right
                                            ((o)o00).a.setPadding(v8, 0, v8, 0);
                                        }
                                        if(textView1 != null) {
                                            ViewUtils.showWhen(textView1, true);
                                            AddPosition addPosition2 = MelonSettingInfo.getPlayListAddPosition();
                                            if(addPosition1 == addPosition2) {
                                                textView1.setText(0x7F130929);  // string:setting_addposition_after "재생 곡 뒤"
                                            }
                                            else if(addPosition0 == addPosition2) {
                                                textView1.setText(0x7F13092A);  // string:setting_addposition_end "맨 끝"
                                            }
                                            else {
                                                textView1.setText(0x7F13092B);  // string:setting_addposition_first "맨 처음"
                                            }
                                            ViewUtils.setOnClickListener(view1, new c(new H0(24, this, ((o)o00))));
                                            ViewUtils.setContentDescriptionWithButtonClassName(view1, textView1.getText());
                                        }
                                        break;
                                    }
                                    case 8: 
                                    case 9: {
                                        View view2 = ((o)o00).h;
                                        TextView textView2 = ((o)o00).i;
                                        if(((o)o00).a != null) {
                                            int v9 = context0.getResources().getDimensionPixelSize(0x7F0700AC);  // dimen:context_list_padding_left_right
                                            ((o)o00).a.setPadding(v9, 0, v9, 0);
                                        }
                                        if(textView2 != null) {
                                            ViewUtils.showWhen(textView2, true);
                                            AddPosition addPosition3 = v7 == 8 ? MelonSettingInfo.getNormalPlayListAddPosition() : MelonSettingInfo.getDjPlayListAddPosition();
                                            if(addPosition1 == addPosition3) {
                                                textView2.setText(0x7F130929);  // string:setting_addposition_after "재생 곡 뒤"
                                            }
                                            else if(addPosition0 == addPosition3) {
                                                textView2.setText(0x7F13092A);  // string:setting_addposition_end "맨 끝"
                                            }
                                            else {
                                                textView2.setText(0x7F13092B);  // string:setting_addposition_first "맨 처음"
                                            }
                                            ViewUtils.setOnClickListener(view2, new com.iloen.melon.adapters.d(v7, new e(this, v7, ((o)o00), 9)));
                                            ViewUtils.setContentDescriptionWithButtonClassName(view2, textView2.getText());
                                        }
                                    }
                                }
                                HashMap hashMap0 = this.i;
                                if(hashMap0.containsKey(contextItemType0)) {
                                    ((o)o00).j.setChecked(((Boolean)hashMap0.get(contextItemType0)).booleanValue());
                                    return;
                                }
                            }
                            else if(((n)o00) instanceof l && v7 == 4) {
                                TextView textView3 = ((l)o00).h;
                                View view3 = ((l)o00).j;
                                ViewUtils.showWhen(textView3, true);
                                ViewUtils.showWhen(((l)o00).i, false);
                                ViewUtils.showWhen(view3, true);
                                ViewUtils.showWhen(((l)o00).k, false);
                                ColorStateList colorStateList0 = ColorUtils.getColorStateList(context0, 0x7F060472);  // color:selector_gray850s_green500s
                                ((l)o00).d.setTextColor(colorStateList0);
                                ((l)o00).d.setSelected(false);
                                ((l)o00).h.setSelected(false);
                                if(contextItemInfo0.c != null && contextItemInfo0.c.a != null) {
                                    ViewUtils.setOnClickListener(view3, new k(this, contextItemInfo0));
                                    return;
                                }
                            }
                        }
                    }
                    break;
                }
                default: {
                    LogU.w("PopupTextListAdapter", "onBindViewHolder() invalid itemType.");
                }
            }
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        LayoutInflater layoutInflater0 = this.b;
        switch(v) {
            case 4: {
                View view0 = layoutInflater0.inflate(0x7F0D05AC, viewGroup0, false);  // layout:popup_listitem_nowplaylist
                O0 o00 = new l(this, view0);  // 初始化器: Ln8/n;-><init>(Lcom/iloen/melon/adapters/PopupTextListAdapter;Landroid/view/View;)V
                o00.h = (TextView)view0.findViewById(0x7F0A0B54);  // id:text_count
                o00.i = view0.findViewById(0x7F0A0678);  // id:iv_radio
                o00.j = view0.findViewById(0x7F0A0182);  // id:btn_play
                o00.k = view0.findViewById(0x7F0A065A);  // id:iv_nowplaying
                return o00;
            }
            case 2: 
            case 7: 
            case 8: 
            case 9: {
                View view1 = layoutInflater0.inflate(0x7F0D05AE, viewGroup0, false);  // layout:popup_listitem_with_right_button
                O0 o01 = new o(this, view1);  // 初始化器: Ln8/n;-><init>(Lcom/iloen/melon/adapters/PopupTextListAdapter;Landroid/view/View;)V
                o01.h = view1.findViewById(0x7F0A01A4);  // id:btn_right
                o01.i = (TextView)view1.findViewById(0x7F0A0C36);  // id:tv_check_button
                o01.j = (ToggleButton)view1.findViewById(0x7F0A0180);  // id:btn_on_off
                return o01;
            }
            default: {
                return new n(this, layoutInflater0.inflate(this.c, viewGroup0, false));
            }
        }
    }
}

