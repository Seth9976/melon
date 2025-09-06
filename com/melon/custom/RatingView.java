package com.melon.custom;

import Cb.k;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b3.Z;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000BJ\r\u0010\r\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000ER\"\u0010\u0012\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\n\u001A\u00020\t8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\"\u0010#\u001A\u00020\u001C8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001A\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/melon/custom/RatingView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "type", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getRating", "()F", "", "d", "Z", "isTouchable", "()Z", "setTouchable", "(Z)V", "e", "I", "getType", "()I", "setType", "(I)V", "", "f", "Ljava/lang/String;", "getPartInCnt", "()Ljava/lang/String;", "setPartInCnt", "(Ljava/lang/String;)V", "partInCnt", "Landroid/view/View;", "g", "Landroid/view/View;", "getRatingLayout", "()Landroid/view/View;", "setRatingLayout", "(Landroid/view/View;)V", "ratingLayout", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class RatingView extends LinearLayout {
    public float a;
    public final ImageView[] b;
    public int c;
    public boolean d;
    public int e;
    public String f;
    public View g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;

    static {
        RatingView.h = new int[]{0x7F080169, 0x7F08016A, 0x7F080168};  // drawable:btn_common_rating_fill_46
        RatingView.i = new int[]{0x7F08049A, 0x7F08049B, 0x7F080499};  // drawable:ic_list_star_full
        RatingView.j = new int[]{0x7F080179, 0x7F08017A, 0x7F080178};  // drawable:btn_common_star_fill_14
    }

    public RatingView(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.b = new ImageView[5];
        this.c = -1;
        this.d = true;
        this.f = "";
        this.e = 0;
        this.b(context0);
    }

    public RatingView(Context context0, int v) {
        q.g(context0, "context");
        super(context0);
        this.b = new ImageView[5];
        this.c = -1;
        this.d = true;
        this.f = "";
        this.e = v;
        this.b(context0);
    }

    public RatingView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.b = new ImageView[5];
        this.c = -1;
        this.d = true;
        this.f = "";
        this.e = 0;
        this.b(context0);
    }

    public RatingView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.b = new ImageView[5];
        this.c = -1;
        this.d = true;
        this.f = "";
        this.e = v;
        this.b(context0);
    }

    public RatingView(Context context0, String s) {
        q.g(context0, "context");
        q.g(s, "partInCnt");
        super(context0);
        this.b = new ImageView[5];
        this.c = -1;
        this.d = true;
        this.e = 3;
        this.f = s;
        this.b(context0);
    }

    public final void a(int v) {
        int[] arr_v;
        if(v != this.c) {
            if(v < 0) {
                v = 0;
            }
            else if(v > 10) {
                v = 10;
            }
            this.c = v;
            switch(this.e) {
                case 1: {
                    arr_v = RatingView.i;
                    break;
                }
                case 0: 
                case 3: {
                    arr_v = RatingView.h;
                    break;
                }
                default: {
                    arr_v = RatingView.j;
                }
            }
            int[] arr_v1 = new int[5];
            int v2 = arr_v[2];
            arr_v1[0] = v2;
            arr_v1[1] = v2;
            arr_v1[2] = v2;
            int v3 = arr_v[2];
            arr_v1[3] = v3;
            arr_v1[4] = v3;
            switch(v) {
                case 0: {
                    arr_v1[0] = v3;
                    break;
                }
                case 1: {
                    arr_v1[0] = arr_v[1];
                    break;
                }
                case 2: {
                    arr_v1[0] = arr_v[0];
                    break;
                }
                case 3: {
                    arr_v1[0] = arr_v[0];
                    arr_v1[1] = arr_v[1];
                    break;
                }
                case 4: {
                    arr_v1[0] = arr_v[0];
                    arr_v1[1] = arr_v[0];
                    break;
                }
                case 5: {
                    arr_v1[0] = arr_v[0];
                    arr_v1[1] = arr_v[0];
                    arr_v1[2] = arr_v[1];
                    break;
                }
                case 6: {
                    arr_v1[0] = arr_v[0];
                    int v4 = arr_v[0];
                    arr_v1[1] = v4;
                    arr_v1[2] = v4;
                    break;
                }
                case 7: {
                    arr_v1[0] = arr_v[0];
                    int v5 = arr_v[0];
                    arr_v1[1] = v5;
                    arr_v1[2] = v5;
                    arr_v1[3] = arr_v[1];
                    break;
                }
                case 8: {
                    arr_v1[0] = arr_v[0];
                    int v6 = arr_v[0];
                    arr_v1[1] = v6;
                    arr_v1[2] = v6;
                    arr_v1[3] = v6;
                    break;
                }
                case 9: {
                    arr_v1[0] = arr_v[0];
                    int v7 = arr_v[0];
                    arr_v1[1] = v7;
                    arr_v1[2] = v7;
                    arr_v1[3] = v7;
                    arr_v1[4] = arr_v[1];
                    break;
                }
                case 10: {
                    arr_v1[0] = arr_v[0];
                    int v8 = arr_v[0];
                    arr_v1[1] = v8;
                    arr_v1[2] = v8;
                    arr_v1[3] = v8;
                    arr_v1[4] = v8;
                }
            }
            for(int v1 = 0; v1 < 5; ++v1) {
                ImageView imageView0 = this.b[v1];
                if(imageView0 != null) {
                    imageView0.setImageResource(arr_v1[v1]);
                }
            }
        }
    }

    public final void b(Context context0) {
        float f;
        LinearLayout linearLayout0;
        Object object0 = context0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        switch(this.e) {
            case 0: {
                View view1 = ((LayoutInflater)object0).inflate(0x7F0D0621, null);  // layout:ratingview
                q.e(view1, "null cannot be cast to non-null type android.widget.LinearLayout");
                linearLayout0 = (LinearLayout)view1;
                break;
            }
            case 1: {
                View view2 = ((LayoutInflater)object0).inflate(0x7F0D0622, null);  // layout:ratingview_small
                q.e(view2, "null cannot be cast to non-null type android.widget.LinearLayout");
                linearLayout0 = (LinearLayout)view2;
                break;
            }
            case 3: {
                View view3 = ((LayoutInflater)object0).inflate(0x7F0D0624, null);  // layout:ratingview_with_partin
                q.e(view3, "null cannot be cast to non-null type android.widget.LinearLayout");
                linearLayout0 = (LinearLayout)view3;
                this.g = linearLayout0.findViewById(0x7F0A09BD);  // id:rating_layout
                TextView textView0 = (TextView)linearLayout0.findViewById(0x7F0A0CD7);  // id:tv_part_in_cnt
                String s = k.a(context0, this.f);
                q.f("%s명이 참여하였습니다.", "getString(...)");
                Z.y(new Object[]{s}, 1, "%s명이 참여하였습니다.", textView0);
                break;
            }
            default: {
                View view0 = ((LayoutInflater)object0).inflate(0x7F0D0623, null);  // layout:ratingview_small_detail
                q.e(view0, "null cannot be cast to non-null type android.widget.LinearLayout");
                linearLayout0 = (LinearLayout)view0;
            }
        }
        this.addView(linearLayout0);
        this.b[0] = linearLayout0.findViewById(0x7F0A09B7);  // id:rating1
        this.b[1] = linearLayout0.findViewById(0x7F0A09B8);  // id:rating2
        this.b[2] = linearLayout0.findViewById(0x7F0A09B9);  // id:rating3
        this.b[3] = linearLayout0.findViewById(0x7F0A09BA);  // id:rating4
        this.b[4] = linearLayout0.findViewById(0x7F0A09BB);  // id:rating5
        switch(this.e) {
            case 1: {
                f = 11.0f;
                break;
            }
            case 0: 
            case 3: {
                f = 46.0f;
                break;
            }
            default: {
                f = 14.0f;
            }
        }
        this.a = (float)(ScreenUtils.dipToPixel(context0, f) / 2 - 5);
        this.a(10);
    }

    @NotNull
    public final String getPartInCnt() {
        return this.f;
    }

    public final float getRating() {
        return this.c == 0 ? 0.0f : ((float)this.c) / 2.0f;
    }

    @Nullable
    public final View getRatingLayout() {
        return this.g;
    }

    public final int getType() {
        return this.e;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        q.g(motionEvent0, "event");
        if(!this.d) {
            return false;
        }
        int v = (int)(motionEvent0.getX() / this.a);
        if(v < 1) {
            v = 1;
        }
        this.a(v);
        return true;
    }

    public final void setPartInCnt(@NotNull String s) {
        q.g(s, "<set-?>");
        this.f = s;
    }

    public final void setRatingLayout(@Nullable View view0) {
        this.g = view0;
    }

    public final void setTouchable(boolean z) {
        this.d = z;
    }

    public final void setType(int v) {
        this.e = v;
    }
}

