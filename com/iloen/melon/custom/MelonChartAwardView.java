package com.iloen.melon.custom;

import A6.b;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import b3.Z;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE.MUSICAWARD.WEEKRANKLIST;
import com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes.RESPONSE.MUSICAWARD;
import com.iloen.melon.utils.image.MelonBlurTransformation;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000BR*\u0010\u0014\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f8F@BX\u0086\u000E¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/custom/MelonChartAwardView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "value", "o", "Ljava/lang/String;", "getCurrentAwardStatus", "()Ljava/lang/String;", "setCurrentAwardStatus", "(Ljava/lang/String;)V", "currentAwardStatus", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartAwardView extends LinearLayout {
    public final ViewGroup a;
    public final ViewGroup b;
    public final ViewGroup c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final ArrayList g;
    public final TextView h;
    public final TextView i;
    public final View j;
    public String k;
    public String l;
    public String m;
    public final View n;
    public String o;
    public final b r;
    public static final int w;

    public MelonChartAwardView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null);
    }

    public MelonChartAwardView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0);
    }

    public MelonChartAwardView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        ArrayList arrayList0 = new ArrayList();
        this.g = arrayList0;
        this.o = "P";
        this.r = new b(this, 27);
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04E1, this);  // layout:melon_chart_home_award
        this.h = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.i = (TextView)view0.findViewById(0x7F0A0D1E);  // id:tv_sub_title
        View view1 = view0.findViewById(0x7F0A00DC);  // id:award_item_1
        q.f(view1, "findViewById(...)");
        this.a = (ViewGroup)view1;
        View view2 = view0.findViewById(0x7F0A00DD);  // id:award_item_2
        q.f(view2, "findViewById(...)");
        this.b = (ViewGroup)view2;
        View view3 = view0.findViewById(0x7F0A00DE);  // id:award_item_3
        q.f(view3, "findViewById(...)");
        this.c = (ViewGroup)view3;
        View view4 = view0.findViewById(0x7F0A00DF);  // id:award_item_layout_1
        q.f(view4, "findViewById(...)");
        this.d = (FrameLayout)view4;
        View view5 = view0.findViewById(0x7F0A00E0);  // id:award_item_layout_2
        q.f(view5, "findViewById(...)");
        this.e = (FrameLayout)view5;
        View view6 = view0.findViewById(0x7F0A00E1);  // id:award_item_layout_3
        q.f(view6, "findViewById(...)");
        this.f = (FrameLayout)view6;
        this.j = view0.findViewById(0x7F0A00DB);  // id:award_grid_layout
        this.n = view0.findViewById(0x7F0A0DE4);  // id:vote_end_layout
        ViewGroup viewGroup0 = this.a;
        if(viewGroup0 != null) {
            arrayList0.add(viewGroup0);
            ViewGroup viewGroup1 = this.b;
            if(viewGroup1 != null) {
                arrayList0.add(viewGroup1);
                ViewGroup viewGroup2 = this.c;
                if(viewGroup2 != null) {
                    arrayList0.add(viewGroup2);
                    return;
                }
                q.m("awardItem3");
                throw null;
            }
            q.m("awardItem2");
            throw null;
        }
        q.m("awardItem1");
        throw null;
    }

    public final void a(MUSICAWARD chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0, String s, String s1, String s2) {
        q.g(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0, "item");
        q.g(s, "menuId");
        this.k = s;
        this.l = s1;
        this.m = s2;
        View view0 = this.j;
        if(view0 != null) {
            view0.setVisibility(8);
        }
        View view1 = this.n;
        if(view1 != null) {
            view1.setVisibility(8);
        }
        TextView textView0 = this.h;
        if(textView0 != null) {
            textView0.setText(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.title);
        }
        TextView textView1 = this.i;
        if(textView1 != null) {
            textView1.setText(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.subTitle);
        }
        String s3 = chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.weekStatus;
        if(s3 != null) {
            switch(s3.hashCode()) {
                case 65: {
                    if(s3.equals("A") && view1 != null) {
                        view1.setVisibility(0);
                    }
                    break;
                }
                case 80: {
                    if(s3.equals("P") && view0 != null) {
                        view0.setVisibility(0);
                    }
                    break;
                }
                case 82: {
                    if(s3.equals("R") && view0 != null) {
                        view0.setVisibility(0);
                    }
                }
            }
        }
        String s4 = chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.weekStatus;
        q.f(s4, "weekStatus");
        this.setCurrentAwardStatus(s4);
        ArrayList arrayList0 = chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.weekranklists;
        if(arrayList0 != null) {
            ArrayList arrayList1 = this.g;
            if(arrayList1.size() <= arrayList0.size()) {
                int v = 0;
                for(Object object0: arrayList1) {
                    Object object1 = chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.weekranklists.get(v);
                    q.f(object1, "get(...)");
                    WEEKRANKLIST chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0 = (WEEKRANKLIST)object1;
                    String s5 = chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD0.weekStatus;
                    q.f(s5, "weekStatus");
                    ImageView imageView0 = (ImageView)((ViewGroup)object0).findViewById(0x7F0A05FE);  // id:iv_bg
                    ImageView imageView1 = (ImageView)((ViewGroup)object0).findViewById(0x7F0A069A);  // id:iv_thumb
                    ImageView imageView2 = (ImageView)((ViewGroup)object0).findViewById(0x7F0A069E);  // id:iv_thumb_default
                    View view2 = ((ViewGroup)object0).findViewById(0x7F0A034F);  // id:cover_gradient
                    View view3 = ((ViewGroup)object0).findViewById(0x7F0A0350);  // id:cover_gradient_gray
                    TextView textView2 = (TextView)((ViewGroup)object0).findViewById(0x7F0A0CF3);  // id:tv_rank
                    TextView textView3 = (TextView)((ViewGroup)object0).findViewById(0x7F0A0D19);  // id:tv_song_name
                    TextView textView4 = (TextView)((ViewGroup)object0).findViewById(0x7F0A0C16);  // id:tv_artist_name
                    TextView textView5 = (TextView)((ViewGroup)object0).findViewById(0x7F0A0CD9);  // id:tv_percent
                    if(textView2 != null) {
                        textView2.setText(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.curRank);
                    }
                    if(textView3 != null) {
                        textView3.setText(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.songName);
                    }
                    if(textView4 != null) {
                        textView4.setText(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.artistName);
                    }
                    if(!TextUtils.isEmpty(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.votePer) && textView5 != null) {
                        Z.y(new Object[]{chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.votePer}, 1, "%s%%", textView5);
                    }
                    if(textView5 != null) {
                        textView5.setVisibility(0);
                    }
                    if(s5.equals("R") && textView5 != null) {
                        textView5.setVisibility(8);
                    }
                    LayoutParams constraintLayout$LayoutParams0 = null;
                    if(v > 0) {
                        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view2 == null ? null : view2.getLayoutParams();
                        LayoutParams constraintLayout$LayoutParams1 = viewGroup$LayoutParams0 instanceof LayoutParams ? ((LayoutParams)viewGroup$LayoutParams0) : null;
                        if(constraintLayout$LayoutParams1 != null) {
                            constraintLayout$LayoutParams1.S = 0.99f;
                        }
                        ViewGroup.LayoutParams viewGroup$LayoutParams1 = view3 == null ? null : view3.getLayoutParams();
                        if(viewGroup$LayoutParams1 instanceof LayoutParams) {
                            constraintLayout$LayoutParams0 = (LayoutParams)viewGroup$LayoutParams1;
                        }
                        if(constraintLayout$LayoutParams0 != null) {
                            constraintLayout$LayoutParams0.S = 0.99f;
                        }
                    }
                    MelonBlurTransformation melonBlurTransformation0 = new MelonBlurTransformation(Glide.get(this.getContext()).getBitmapPool(), 100, 4);
                    CenterCrop centerCrop0 = new CenterCrop();
                    Glide.with(this.getContext()).asBitmap().load(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.artistImgSmall).apply(new RequestOptions().transform(new Transformation[]{centerCrop0, melonBlurTransformation0})).into(new j0(this, view2, imageView0));
                    if(imageView1 != null) {
                        if(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.artistImgLarge == null || chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.artistImgLarge.length() <= 0) {
                            ViewUtils.setDefaultImage(imageView2, ScreenUtils.dipToPixel(this.getContext(), (v == 0 ? 212.0f : 108.0f)));
                        }
                        else {
                            q.d(Glide.with(imageView1).load(chartTopWeeklySongChartListRes$RESPONSE$MUSICAWARD$WEEKRANKLIST0.artistImgLarge).apply(RequestOptions.circleCropTransform()).into(imageView1));
                        }
                    }
                    ++v;
                }
            }
        }
        b b0 = this.r;
        if(textView0 != null) {
            textView0.setOnClickListener(b0);
        }
        if(view0 != null) {
            view0.setOnClickListener(b0);
        }
        if(view1 != null) {
            view1.setOnClickListener(b0);
        }
        this.b();
    }

    public final void b() {
        int v;
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = null;
        FrameLayout frameLayout0 = this.d;
        if(frameLayout0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout0.getLayoutParams();
            LinearLayout.LayoutParams linearLayout$LayoutParams1 = viewGroup$LayoutParams0 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams)viewGroup$LayoutParams0) : null;
            FrameLayout frameLayout1 = this.e;
            if(frameLayout1 != null) {
                ViewGroup.LayoutParams viewGroup$LayoutParams1 = frameLayout1.getLayoutParams();
                LinearLayout.LayoutParams linearLayout$LayoutParams2 = viewGroup$LayoutParams1 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams)viewGroup$LayoutParams1) : null;
                FrameLayout frameLayout2 = this.f;
                if(frameLayout2 != null) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams2 = frameLayout2.getLayoutParams();
                    if(viewGroup$LayoutParams2 instanceof LinearLayout.LayoutParams) {
                        linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)viewGroup$LayoutParams2;
                    }
                    Context context0 = this.getContext();
                    if(context0 == null) {
                        v = 0;
                    }
                    else {
                        Resources resources0 = context0.getResources();
                        v = resources0 == null ? 0 : resources0.getDimensionPixelSize(0x7F070089);  // dimen:chart_home_award_margin
                    }
                    int v1 = ScreenUtils.getScreenWidth(this.getContext()) - v;
                    int v2 = (int)(((float)v1) * 0.663f);
                    int v3 = (int)(((float)(ScreenUtils.isPortrait(this.getContext()) ? v1 : ScreenUtils.getScreenHeight(this.getContext()) - v)) * 0.675f);
                    int v4 = v1 - v2;
                    if(linearLayout$LayoutParams1 != null) {
                        linearLayout$LayoutParams1.width = v2;
                    }
                    if(linearLayout$LayoutParams1 != null) {
                        linearLayout$LayoutParams1.height = v3;
                    }
                    if(linearLayout$LayoutParams2 != null) {
                        linearLayout$LayoutParams2.width = v4;
                    }
                    if(linearLayout$LayoutParams2 != null) {
                        linearLayout$LayoutParams2.height = v3 / 2;
                    }
                    if(linearLayout$LayoutParams0 != null) {
                        linearLayout$LayoutParams0.width = v4;
                    }
                    if(linearLayout$LayoutParams0 != null) {
                        linearLayout$LayoutParams0.height = v3 - v3 / 2;
                    }
                    return;
                }
                q.m("awardItemLayout3");
                throw null;
            }
            q.m("awardItemLayout2");
            throw null;
        }
        q.m("awardItemLayout1");
        throw null;
    }

    @NotNull
    public final String getCurrentAwardStatus() {
        return this.o;
    }

    private final void setCurrentAwardStatus(String s) {
        this.o = s;
    }
}

