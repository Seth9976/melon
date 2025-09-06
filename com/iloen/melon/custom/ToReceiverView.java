package com.iloen.melon.custom;

import E8.a;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TargetMemberInfoBase;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;

public class ToReceiverView extends RelativeLayout {
    public static class Receiver implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;

        static {
            Receiver.CREATOR = new m1();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public static ArrayList a(ArrayList arrayList0) {
            if(arrayList0 != null && arrayList0.size() > 0) {
                ArrayList arrayList1 = new ArrayList();
                for(Object object0: arrayList0) {
                    String s = ((TargetMemberInfoBase)object0).targetmemberkey;
                    String s1 = ((TargetMemberInfoBase)object0).targetnickname;
                    String s2 = ((TargetMemberInfoBase)object0).targetpageimg;
                    String s3 = ProtocolUtils.convertStatusToWithdrawYn(((TargetMemberInfoBase)object0).targetmemberstatus);
                    Receiver toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
                    toReceiverView$Receiver0.a = s;
                    toReceiverView$Receiver0.b = null;
                    toReceiverView$Receiver0.c = s1;
                    toReceiverView$Receiver0.d = s2;
                    toReceiverView$Receiver0.e = s3;
                    arrayList1.add(toReceiverView$Receiver0);
                }
                return arrayList1;
            }
            return null;
        }

        public static String b(ArrayList arrayList0) {
            if(arrayList0 != null && arrayList0.size() > 0) {
                StringBuilder stringBuilder0 = new StringBuilder();
                for(Object object0: arrayList0) {
                    Receiver toReceiverView$Receiver0 = (Receiver)object0;
                    if(!TextUtils.isEmpty(toReceiverView$Receiver0.a)) {
                        stringBuilder0.append(toReceiverView$Receiver0.a);
                        stringBuilder0.append(",");
                    }
                }
                return l1.q(stringBuilder0, 1, 0);
            }
            return "";
        }

        public static String c(ArrayList arrayList0) {
            if(arrayList0 != null && arrayList0.size() > 0) {
                StringBuilder stringBuilder0 = new StringBuilder();
                for(Object object0: arrayList0) {
                    stringBuilder0.append(((TargetMemberInfoBase)object0).targetnickname);
                    stringBuilder0.append(", ");
                }
                return stringBuilder0.length() <= 1 ? stringBuilder0.substring(0, 0).toString() : stringBuilder0.substring(0, stringBuilder0.length() - 2).toString();
            }
            return null;
        }

        public static boolean d(ArrayList arrayList0) {
            return arrayList0 == null || arrayList0.size() <= 0 ? false : ProtocolUtils.parseBoolean(((TargetMemberInfoBase)arrayList0.get(0)).targetmemberstatus);
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public static boolean e(ArrayList arrayList0) {
            if(arrayList0 != null && arrayList0.size() > 0) {
                int v = arrayList0.size();
                int v1 = 0;
                for(Object object0: arrayList0) {
                    if(ProtocolUtils.parseBoolean(((Receiver)object0).e)) {
                        ++v1;
                    }
                }
                return v <= v1;
            }
            return false;
        }

        @Override
        public final boolean equals(Object object0) {
            if(object0 instanceof Receiver) {
                return TextUtils.isEmpty(this.a) || !this.a.equals(((Receiver)object0).a) ? !TextUtils.isEmpty(this.b) && this.b.equals(((Receiver)object0).b) : true;
            }
            return false;
        }

        @Override
        public final int hashCode() {
            int v = 0;
            int v1 = this.a == null ? 0 : this.a.hashCode();
            int v2 = this.b == null ? 0 : this.b.hashCode();
            String s = this.c;
            if(s != null) {
                v = s.hashCode();
            }
            return ((v1 + 0x1F) * 0x1F + v2) * 0x1F + v;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeString(this.a);
            parcel0.writeString(this.b);
            parcel0.writeString(this.c);
            parcel0.writeString(this.d);
            parcel0.writeString(this.e);
        }
    }

    public final ArrayList a;
    public final FlowLayout b;
    public final TextView c;
    public k1 d;
    public int e;

    public ToReceiverView(Context context0) {
        this(context0, null);
    }

    public ToReceiverView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ToReceiverView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new ArrayList();
        LayoutInflater.from(context0).inflate(this.getLayoutId(), this, true);
        this.b = (FlowLayout)this.findViewById(this.getUserLayout());
        this.c = (TextView)this.findViewById(this.getHintTextView());
        this.findViewById(this.getAddButton()).setOnClickListener(new a(this, 8));
    }

    public final void a(Receiver toReceiverView$Receiver0) {
        if(toReceiverView$Receiver0 != null) {
            ArrayList arrayList0 = this.a;
            if(!arrayList0.contains(toReceiverView$Receiver0)) {
                arrayList0.add(toReceiverView$Receiver0);
                TextView textView0 = this.c;
                if(textView0 != null) {
                    ViewUtils.showWhen(textView0, false);
                }
                M m0 = new M(ScreenUtils.dipToPixel(this.getContext(), this.getToUserViewHorizontalSpace()), ScreenUtils.dipToPixel(this.getContext(), this.getToUserViewVerticalSpace()));
                ToUserView toUserView0 = new ToUserView(this.getContext());  // 初始化器: Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
                toUserView0.a(this.getToUserViewLayoutId());
                toUserView0.setText((TextUtils.isEmpty(toReceiverView$Receiver0.c) ? StringUtils.getNonVisibleCenterPhoneNumber(toReceiverView$Receiver0.b) : toReceiverView$Receiver0.c));
                toUserView0.setTag(toReceiverView$Receiver0);
                toUserView0.setOnDeleteBtnClickListener(new i1(this));
                toUserView0.setOnContentClickListener(new j1(this, toReceiverView$Receiver0));
                FlowLayout flowLayout0 = this.b;
                if(flowLayout0 != null) {
                    flowLayout0.setVisibility(0);
                    this.b.addView(toUserView0, m0);
                }
            }
        }
    }

    public int getAddButton() {
        return 0x7F0A0072;  // id:add_button
    }

    public int getAllowCount() {
        return this.e - this.a.size();
    }

    public int getCount() {
        return this.a.size();
    }

    public String getDisplayNames() {
        ArrayList arrayList0 = this.a;
        if(arrayList0.size() > 0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: arrayList0) {
                stringBuilder0.append(((Receiver)object0).c);
                stringBuilder0.append(",");
            }
            return l1.q(stringBuilder0, 1, 0);
        }
        return "";
    }

    public int getHintTextView() {
        return 0x7F0A0532;  // id:hint
    }

    public int getLayoutId() {
        return 0x7F0D0895;  // layout:to_senders_view
    }

    public ArrayList getList() {
        return this.a;
    }

    public float getToUserViewHorizontalSpace() {
        return 4.0f;
    }

    public int getToUserViewLayoutId() {
        return -1;
    }

    public float getToUserViewVerticalSpace() {
        return 3.0f;
    }

    public int getUserLayout() {
        return 0x7F0A0D88;  // id:user_list
    }

    public void setHintText(int v) {
        TextView textView0 = this.c;
        if(textView0 != null) {
            textView0.setText(v);
        }
    }

    public void setHintText(String s) {
        TextView textView0 = this.c;
        if(textView0 != null) {
            textView0.setText(s);
        }
    }

    public void setMaxCount(int v) {
        this.e = v;
    }

    public void setOnAddDeleteClickListener(k1 k10) {
        this.d = k10;
    }
}

