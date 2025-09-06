package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import b3.Z;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MelonCategoryPopup extends MelonBaseListPopup {
    class CategoryPopupArrayAdapter extends ArrayAdapter {
        class ViewHolder {
            public View a;
            public TextView b;
            public ImageView c;

        }

        public final int a;
        public final List b;
        public final int c;
        public final MelonCategoryPopup d;

        public CategoryPopupArrayAdapter(Context context0, List list0, int v, int v1) {
            super(context0, 0x7F0D05A3);  // layout:popup_category_item
            this.c = v;
            this.b = list0;
            this.a = v1;
        }

        @Override  // android.widget.ArrayAdapter
        public int getCount() {
            return this.b == null ? 0 : this.b.size();
        }

        public Category getItem(int v) {
            return this.b == null ? null : ((Category)this.b.get(v));
        }

        @Override  // android.widget.ArrayAdapter
        public Object getItem(int v) {
            return this.getItem(v);
        }

        @Override  // android.widget.ArrayAdapter
        public View getView(int v, View view0, ViewGroup viewGroup0) {
            ViewHolder melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0;
            int v1 = this.a;
            if(view0 == null) {
                view0 = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(this.c, null);
                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0 = new ViewHolder();  // 初始化器: Ljava/lang/Object;-><init>()V
                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.a = view0.findViewById(0x7F0A0232);  // id:category_row
                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.b = (TextView)view0.findViewById(0x7F0A0233);  // id:category_title
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0231);  // id:category_right_image
                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.c = imageView0;
                if(v1 == 1) {
                    imageView0.setBackgroundResource(0x7F0802B2);  // drawable:btnw_popup_more_n
                    melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.c.setVisibility(8);
                }
                else {
                    imageView0.setBackgroundResource(0x7F08082C);  // drawable:selector_icon_age_n
                    melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.c.setVisibility(0);
                }
                view0.setTag(melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0);
            }
            else {
                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0 = (ViewHolder)view0.getTag();
            }
            Category category0 = (Category)this.b.get(v);
            if(category0 != null) {
                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.b.setText(category0.getName());
            }
            String s = category0.getId();
            MelonCategoryPopup melonCategoryPopup0 = MelonCategoryPopup.this;
            switch(melonCategoryPopup0.b) {
                case 1: {
                    if(melonCategoryPopup0.d != null && melonCategoryPopup0.d.equals(s)) {
                        melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.b.setTextColor(this.getContext().getResources().getColor(0x7F060074));  // color:category_text_on
                        return view0;
                    }
                    melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.b.setTextColor(this.getContext().getResources().getColor(0x7F060073));  // color:category_text_off
                    return view0;
                }
                case 2: {
                    switch(v1) {
                        case 1: {
                            if(melonCategoryPopup0.c != null && melonCategoryPopup0.c.equals(category0.getNum())) {
                                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.c.setVisibility(0);
                                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.b.setTextColor(this.getContext().getResources().getColor(0x7F060074));  // color:category_text_on
                                return view0;
                            }
                            melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.c.setVisibility(8);
                            melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.b.setTextColor(this.getContext().getResources().getColor(0x7F060073));  // color:category_text_off
                            return view0;
                        }
                        case 2: {
                            if(melonCategoryPopup0.d != null && melonCategoryPopup0.d.equals(s)) {
                                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.c.setVisibility(0);
                                melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.a.setSelected(true);
                                return view0;
                            }
                            melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.c.setVisibility(8);
                            melonCategoryPopup$CategoryPopupArrayAdapter$ViewHolder0.a.setSelected(false);
                            return view0;
                        }
                        default: {
                            return view0;
                        }
                    }
                }
                default: {
                    return view0;
                }
            }
        }
    }

    public final String a;
    public final int b;
    public String c;
    public final String d;
    public final int e;
    public final List f;
    public final HashMap g;
    public ListView h;
    public ListView i;
    public AdapterView.OnItemClickListener j;

    public MelonCategoryPopup(Activity activity0, String s, String s1) {
        super(activity0);
        this.c = "";
        this.d = "";
        int v = 0;
        this.e = 0;
        this.a = s;
        try {
            JSONObject jSONObject0 = new JSONObject(s1);
            LogU.d("MelonBaseListPopup", "MelonCategoryPopup() title:" + s + ", json:" + jSONObject0);
            int v1 = Integer.parseInt(jSONObject0.getString("cateDepth"));
            this.b = v1;
            if(jSONObject0.has("cateSelNum")) {
                this.c = jSONObject0.getString("cateSelNum");
            }
            if(jSONObject0.has("cateSelId")) {
                this.d = jSONObject0.getString("cateSelId");
            }
            if(this.f == null) {
                this.f = MelonCategoryPopup.a(null, jSONObject0);
            alab1:
                switch(v1) {
                    case 1: {
                        while(v < this.f.size()) {
                            String s2 = ((Category)this.f.get(v)).getId();
                            if(this.d.equals(s2)) {
                                this.e = v;
                                return;
                            }
                            ++v;
                        }
                        return;
                    }
                    case 2: {
                        this.g = new HashMap();
                        while(true) {
                            if(v >= this.f.size()) {
                                break alab1;
                            }
                            Category category0 = (Category)this.f.get(v);
                            String s3 = category0.getName();
                            String s4 = category0.getNum();
                            if(this.c.equals(s4)) {
                                this.e = v;
                            }
                            JSONObject jSONObject1 = category0.getJSONObjectChild();
                            if(jSONObject1 != null) {
                                ArrayList arrayList0 = MelonCategoryPopup.a(s4, jSONObject1);
                                this.g.put(s3, arrayList0);
                            }
                            ++v;
                        }
                    }
                    default: {
                        return;
                    }
                }
            }
            return;
        }
        catch(JSONException jSONException0) {
        }
        jSONException0.printStackTrace();
    }

    public MelonCategoryPopup(Activity activity0, String s, List list0) {
        super(activity0);
        this.c = "";
        this.d = "";
        this.e = 0;
        Z.w("MelonCategoryPopup() title : ", s, "MelonBaseListPopup");
        this.a = s;
        this.b = 1;
        this.f = list0;
    }

    public static ArrayList a(String s, JSONObject jSONObject0) {
        ArrayList arrayList0 = new ArrayList();
        try {
            JSONArray jSONArray0 = jSONObject0.getJSONArray("cateList");
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v);
                String s1 = null;
                String s2 = jSONObject1.has("cateId") ? jSONObject1.getString("cateId") : null;
                if(jSONObject1.has("cateName")) {
                    s1 = jSONObject1.getString("cateName");
                }
                Category category0 = new Category((jSONObject1.has("cateNum") ? jSONObject1.getString("cateNum") : s), s2, s1);
                if(jSONObject1.has("cateList")) {
                    category0.setJSONObjectChild(jSONObject1);
                }
                arrayList0.add(category0);
            }
            return arrayList0;
        }
        catch(JSONException jSONException0) {
        }
        LogU.d("MelonBaseListPopup", "setCategoryList() : " + jSONException0.toString());
        jSONException0.printStackTrace();
        return arrayList0;
    }

    public final void b(String s) {
        Object object0 = this.g.get(s);
        CategoryPopupArrayAdapter melonCategoryPopup$CategoryPopupArrayAdapter0 = new CategoryPopupArrayAdapter(this, this.getContext(), ((List)object0), 0x7F0D05A2, 2);  // layout:popup_category_1depth_list_item
        this.i.setAdapter(melonCategoryPopup$CategoryPopupArrayAdapter0);
        melonCategoryPopup$CategoryPopupArrayAdapter0.notifyDataSetChanged();
        int v1 = ((List)object0) == null ? 0 : ((List)object0).size();
        for(int v = 0; v < v1; ++v) {
            String s1 = ((Category)((List)object0).get(v)).getId();
            if(!TextUtils.isEmpty(s1) && s1.equals(this.d)) {
                this.i.setSelection(v);
                break;
            }
        }
        AdapterView.OnItemClickListener adapterView$OnItemClickListener0 = this.j;
        if(adapterView$OnItemClickListener0 != null) {
            this.i.setOnItemClickListener(adapterView$OnItemClickListener0);
        }
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.requestWindowFeature(1);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        switch(this.b) {
            case 1: {
                this.setContentView(0x7F0D05A4);  // layout:popup_category_list
                break;
            }
            case 2: {
                this.setContentView(0x7F0D05A5);  // layout:popup_category_list_2depth
            }
        }
        ((TextView)this.findViewById(0x7F0A0782)).setText(this.a);  // id:list_title
        ListView listView0 = (ListView)this.findViewById(0x7F0A0779);  // id:list
        this.h = listView0;
        listView0.setVisibility(0);
        ListView listView1 = (ListView)this.findViewById(0x7F0A0AFF);  // id:sublist
        this.i = listView1;
        if(listView1 != null) {
            listView1.setVisibility(0);
        }
        int v = this.e;
        List list0 = this.f;
        if(list0 != null) {
            CategoryPopupArrayAdapter melonCategoryPopup$CategoryPopupArrayAdapter0 = new CategoryPopupArrayAdapter(this, this.getContext(), this.f, 0x7F0D05A2, 1);  // layout:popup_category_1depth_list_item
            this.h.setAdapter(melonCategoryPopup$CategoryPopupArrayAdapter0);
            this.h.setSelection(v);
        }
        if(this.g != null) {
            this.b(((Category)list0.get(v)).getName());
            this.h.setOnItemClickListener(new MelonCategoryPopup.1(this));
            return;
        }
        AdapterView.OnItemClickListener adapterView$OnItemClickListener0 = this.j;
        if(adapterView$OnItemClickListener0 != null) {
            this.h.setOnItemClickListener(adapterView$OnItemClickListener0);
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener adapterView$OnItemClickListener0) {
        this.j = adapterView$OnItemClickListener0;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public boolean setPopupHeight() {
        Resources resources0 = this.getContext().getResources();
        int v = resources0.getDimensionPixelSize(0x7F070309);  // dimen:melon_popup_text_list_row_height
        if(v > 0) {
            List list0 = this.f;
            if(list0 != null) {
                this.mPopupHeight = list0.size() * v + ((int)(((float)resources0.getDimensionPixelSize(0x7F070304)) + ((float)ScreenUtils.dipToPixel(this.getContext(), 6.0f)) + 0.0f));  // dimen:melon_popup_list_title_height
                return true;
            }
        }
        this.mPopupHeight = this.getMaxPopupHeight(0.5f);
        return true;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    @NotNull
    public WindowManager.LayoutParams setWindowLayoutParams(WindowManager.LayoutParams windowManager$LayoutParams0) {
        return windowManager$LayoutParams0;
    }
}

