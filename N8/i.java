package n8;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.melontv.f;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes;
import com.iloen.melon.net.v4x.response.MelonTvOriginalListRes.RESPONSE.MVLIST;
import com.iloen.melon.net.v4x.response.MelonTvOriginalListRes.RESPONSE.RECMPROGLIST;
import com.iloen.melon.net.v4x.response.MelonTvOriginalListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MelonTvOriginalListRes;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase;
import kb.D;

public final class i extends p {
    public boolean a;
    public f b;
    public String c;
    public f d;
    public LinearLayout e;

    public final void a(e e0, MvInfoBase mvInfoBase0) {
        if(mvInfoBase0 == null) {
            return;
        }
        TextView textView0 = e0.k;
        TextView textView1 = e0.i;
        ImageView imageView0 = e0.b;
        ImageView imageView1 = e0.g;
        ViewUtils.setEnable(e0.a, mvInfoBase0.canService);
        ViewUtils.showWhen(e0.c, mvInfoBase0.canService);
        if(mvInfoBase0.canService) {
            c c0 = new c(this, mvInfoBase0, 0);
            ViewUtils.setOnClickListener(e0.itemView, c0);
        }
        else {
            ViewUtils.setOnClickListener(e0.itemView, null);
        }
        c c1 = new c(this, mvInfoBase0, 1);
        ViewUtils.setOnClickListener(e0.itemView, c1);
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(mvInfoBase0.mv169Img).into(imageView0);
        }
        ViewUtils.setTimeForSecText(e0.e, mvInfoBase0.playTime);
        boolean z = false;
        ViewUtils.showWhen(e0.f, false);
        ViewUtils.hideWhen(e0.d, false);
        int v = ResourceUtils.getMvAdultGradeIcon(mvInfoBase0.adultGrade);
        if(v > 0) {
            z = true;
        }
        ViewUtils.showWhen(imageView1, z);
        if(v > 0) {
            imageView1.setImageResource(v);
        }
        else {
            imageView1.setImageDrawable(null);
        }
        e0.h.setText(mvInfoBase0.mvName);
        textView1.setText(ProtocolUtils.getArtistNames(mvInfoBase0.artistList));
        textView1.requestLayout();
        e0.j.setText(mvInfoBase0.issueDate);
        ViewUtils.showWhen(textView0, !TextUtils.isEmpty(mvInfoBase0.epsdName));
        textView0.setText(mvInfoBase0.epsdName);
        ViewUtils.setOnClickListener(e0.l, new c(this, mvInfoBase0, 2));
    }

    @Override  // com.iloen.melon.adapters.common.p
    public final int getHeaderViewItemCount() {
        return 1;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public final int getItemViewTypeImpl(int v, int v1) {
        if(v == this.getAvailableHeaderPosition()) {
            return 10;
        }
        g g0 = (g)this.getItem(v1);
        return g0 == null ? 12 : g0.a;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public final boolean handleResponse(String s, v9.i i0, HttpResponse httpResponse0) {
        int v = 0;
        if(httpResponse0 == null) {
            return false;
        }
        v9.i i1 = v9.i.b;
        if(httpResponse0 instanceof MelonTvOriginalListRes) {
            RESPONSE melonTvOriginalListRes$RESPONSE0 = ((MelonTvOriginalListRes)httpResponse0).response;
            this.setMenuId(melonTvOriginalListRes$RESPONSE0.menuId);
            this.setHasMore(true);
            if(i1.equals(i0) && (melonTvOriginalListRes$RESPONSE0.recmProgramList != null && melonTvOriginalListRes$RESPONSE0.recmProgramList.size() > 0)) {
                g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                this.a = true;
                g0.d = melonTvOriginalListRes$RESPONSE0.recmProgramList;
                g0.a = 11;
                g0.b = 15;
                this.add(g0);
            }
            if(melonTvOriginalListRes$RESPONSE0.mvList != null && melonTvOriginalListRes$RESPONSE0.mvList.size() > 0) {
                if(i1.equals(i0)) {
                    g g1 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                    g1.c = "멜론 오리지널 비디오";
                    g1.a = 14;
                    this.add(g1);
                }
                while(v < melonTvOriginalListRes$RESPONSE0.mvList.size()) {
                    g g2 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                    g2.f = (MVLIST)melonTvOriginalListRes$RESPONSE0.mvList.get(v);
                    g2.a = 12;
                    g2.b = 15;
                    this.add(g2);
                    ++v;
                }
                return true;
            }
        }
        else if(httpResponse0 instanceof MelonTvBroadcastListRes) {
            com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes.RESPONSE melonTvBroadcastListRes$RESPONSE0 = ((MelonTvBroadcastListRes)httpResponse0).response;
            this.setMenuId(melonTvBroadcastListRes$RESPONSE0.menuId);
            this.setHasMore(true);
            if(i1.equals(i0) && (melonTvBroadcastListRes$RESPONSE0.recmProgramList != null && melonTvBroadcastListRes$RESPONSE0.recmProgramList.size() > 0)) {
                g g3 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                this.a = true;
                g3.e = melonTvBroadcastListRes$RESPONSE0.recmProgramList;
                g3.a = 11;
                g3.b = 16;
                this.add(g3);
            }
            if(melonTvBroadcastListRes$RESPONSE0.mvList != null && melonTvBroadcastListRes$RESPONSE0.mvList.size() > 0) {
                if(i1.equals(i0)) {
                    g g4 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                    g4.c = "TV방송 비디오";
                    g4.a = 14;
                    this.add(g4);
                }
                while(v < melonTvBroadcastListRes$RESPONSE0.mvList.size()) {
                    g g5 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                    g5.g = (com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes.RESPONSE.MVLIST)melonTvBroadcastListRes$RESPONSE0.mvList.get(v);
                    g5.a = 12;
                    g5.b = 16;
                    this.add(g5);
                    ++v;
                }
            }
        }
        return true;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public final void onBindViewImpl(O0 o00, int v, int v1) {
        if(o00 instanceof d) {
            ((d)o00).a.setText(this.c);
            ((d)o00).a.setOnDropDownListener(new D(this, 17));
            return;
        }
        if(o00 instanceof n8.f) {
            g g0 = (g)this.getItem(v1);
            if(g0 != null && (this.e != null && this.e.getChildCount() <= 0)) {
                int v2 = g0.b;
                if(v2 == 15) {
                    if(g0.d == null) {
                        ViewUtils.hideWhen(((n8.f)o00).a, true);
                        return;
                    }
                    for(int v3 = 0; v3 < g0.d.size(); ++v3) {
                        LinearLayout linearLayout0 = (LinearLayout)LayoutInflater.from(this.getContext()).inflate(0x7F0D04FC, null);  // layout:melontv_recm_program_item
                        FrameLayout frameLayout0 = (FrameLayout)linearLayout0.findViewById(0x7F0A0979);  // id:program_thumb_container
                        ViewUtils.setDefaultImage(((ImageView)linearLayout0.findViewById(0x7F0A069C)), ScreenUtils.dipToPixel(this.getContext(), 90.0f));  // id:iv_thumb_circle_default
                        BorderImageView borderImageView0 = (BorderImageView)linearLayout0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                        borderImageView0.setBorderWidth(ScreenUtils.dipToPixel(this.getContext(), 0.5f));
                        borderImageView0.setBorderColor(ColorUtils.getColor(this.getContext(), 0x7F06014A));  // color:gray100a
                        ImageView imageView0 = (ImageView)linearLayout0.findViewById(0x7F0A0653);  // id:iv_new
                        View view0 = linearLayout0.findViewById(0x7F0A0C8A);  // id:tv_hot
                        ViewUtils.showWhen(imageView0, ProtocolUtils.parseBoolean(((RECMPROGLIST)g0.d.get(v3)).newYN));
                        ViewUtils.showWhen(((TextView)view0), ProtocolUtils.parseBoolean(((RECMPROGLIST)g0.d.get(v3)).hotYN));
                        Glide.with(this.getContext()).load(((RECMPROGLIST)g0.d.get(v3)).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
                        ViewUtils.setOnClickListener(borderImageView0, new a(g0, v3));
                        LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)frameLayout0.getLayoutParams();
                        if(v3 == 0) {
                            linearLayout$LayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        }
                        else if(v3 == g0.d.size() - 1) {
                            linearLayout$LayoutParams0.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        }
                        frameLayout0.setLayoutParams(linearLayout$LayoutParams0);
                        this.e.addView(linearLayout0);
                    }
                    return;
                }
                if(v2 == 16) {
                    if(g0.e == null) {
                        ViewUtils.hideWhen(((n8.f)o00).a, true);
                        return;
                    }
                    for(int v4 = 0; v4 < g0.e.size(); ++v4) {
                        LinearLayout linearLayout1 = (LinearLayout)LayoutInflater.from(this.getContext()).inflate(0x7F0D04FC, null);  // layout:melontv_recm_program_item
                        FrameLayout frameLayout1 = (FrameLayout)linearLayout1.findViewById(0x7F0A0979);  // id:program_thumb_container
                        ViewUtils.setDefaultImage(((ImageView)linearLayout1.findViewById(0x7F0A069C)), ScreenUtils.dipToPixel(this.getContext(), 90.0f));  // id:iv_thumb_circle_default
                        BorderImageView borderImageView1 = (BorderImageView)linearLayout1.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                        borderImageView1.setBorderWidth(ScreenUtils.dipToPixel(this.getContext(), 0.5f));
                        borderImageView1.setBorderColor(ColorUtils.getColor(this.getContext(), 0x7F06014A));  // color:gray100a
                        View view1 = linearLayout1.findViewById(0x7F0A0653);  // id:iv_new
                        View view2 = linearLayout1.findViewById(0x7F0A0C8A);  // id:tv_hot
                        ViewUtils.showWhen(((ImageView)view1), ProtocolUtils.parseBoolean(((com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes.RESPONSE.RECMPROGLIST)g0.e.get(v4)).newYN));
                        ViewUtils.showWhen(((TextView)view2), ProtocolUtils.parseBoolean(((com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes.RESPONSE.RECMPROGLIST)g0.e.get(v4)).hotYN));
                        Glide.with(this.getContext()).load(((com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes.RESPONSE.RECMPROGLIST)g0.e.get(v4)).progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(borderImageView1);
                        ViewUtils.setOnClickListener(borderImageView1, new b(g0, v4));
                        LinearLayout.LayoutParams linearLayout$LayoutParams1 = (LinearLayout.LayoutParams)frameLayout1.getLayoutParams();
                        if(v4 == 0) {
                            linearLayout$LayoutParams1.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        }
                        else if(v4 == g0.e.size() - 1) {
                            linearLayout$LayoutParams1.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        }
                        frameLayout1.setLayoutParams(linearLayout$LayoutParams1);
                        this.e.addView(linearLayout1);
                    }
                }
            }
        }
        else {
            if(o00 instanceof h) {
                g g1 = (g)this.getItem(v1);
                ((h)o00).a.setText(g1.c);
                return;
            }
            if(o00 instanceof e) {
                g g2 = (g)this.getItem(v1);
                if(g2 != null) {
                    int v5 = g2.b;
                    if(v5 == 15) {
                        this.a(((e)o00), g2.f);
                        return;
                    }
                    if(v5 == 16) {
                        this.a(((e)o00), g2.g);
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.adapters.common.p
    public final O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
        switch(v) {
            case 10: {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0269, viewGroup0, false);  // layout:filter_dropdown_view
                O0 o01 = new d(view1);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
                FilterDropDownView filterDropDownView0 = (FilterDropDownView)view1.findViewById(0x7F0A049E);  // id:filter_layout
                o01.a = filterDropDownView0;
                filterDropDownView0.setTextColor(ColorUtils.getColorStateList(this.getContext(), 0x7F060163));  // color:gray700s
                filterDropDownView0.setDropDownIcon(0x7F0805F3);  // drawable:ic_tv_filter
                ViewUtils.showWhen(view1.findViewById(0x7F0A0D6B), false);  // id:underline
                return o01;
            }
            case 11: {
                View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04F6, viewGroup0, false);  // layout:melontv_program_list_viewpager
                O0 o02 = new n8.f(view2);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
                o02.a = view2.findViewById(0x7F0A0978);  // id:program_list_container
                this.e = (LinearLayout)view2.findViewById(0x7F0A05A7);  // id:item_container
                return o02;
            }
            case 14: {
                View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04FB, viewGroup0, false);  // layout:melontv_program_title_item
                O0 o03 = new h(view3);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
                o03.a = (TextView)view3.findViewById(0x7F0A0A50);  // id:section_title
                return o03;
            }
            default: {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0500, viewGroup0, false);  // layout:melontv_today_fullitem
                O0 o00 = new e(view0);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
                o00.a = (RelativeLayout)view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
                RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(0x7F0A0BCE);  // id:top_container
                RelativeLayout relativeLayout1 = (RelativeLayout)view0.findViewById(0x7F0A0118);  // id:bottom_container
                o00.b = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                o00.c = (ImageView)view0.findViewById(0x7F0A0147);  // id:btn_center
                o00.d = (LinearLayout)view0.findViewById(0x7F0A0B7E);  // id:thumb_left_container
                MelonTextView melonTextView0 = (MelonTextView)view0.findViewById(0x7F0A0CDF);  // id:tv_play_time
                o00.e = melonTextView0;
                ViewUtils.showWhen(melonTextView0, true);
                o00.f = (MelonTextView)view0.findViewById(0x7F0A0D2F);  // id:tv_thumb_live
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A06A3);  // id:iv_thumb_recom
                ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A06A1);  // id:iv_thumb_grade
                o00.g = imageView1;
                ViewUtils.showWhen(imageView1, true);
                ImageView imageView2 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                TextView textView0 = (TextView)view0.findViewById(0x7F0A0CA3);  // id:tv_list_ranking
                o00.h = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                o00.i = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
                o00.j = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
                o00.k = (TextView)view0.findViewById(0x7F0A0CFF);  // id:tv_round
                o00.l = (ImageView)view0.findViewById(0x7F0A0169);  // id:btn_info
                return o00;
            }
        }
    }
}

