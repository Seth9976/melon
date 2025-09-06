package v9;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.types.TagInfo;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import com.melon.ui.popup.context.more.QualityData;
import kotlin.jvm.internal.q;
import zd.M;

public final class n implements Parcelable.Creator {
    public final int a;

    public n(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                melonLinkInfo0.a = parcel0.readString();
                melonLinkInfo0.b = parcel0.readString();
                melonLinkInfo0.c = parcel0.readString();
                melonLinkInfo0.d = parcel0.readString();
                melonLinkInfo0.e = parcel0.readString();
                melonLinkInfo0.f = parcel0.readString();
                melonLinkInfo0.g = parcel0.readString();
                melonLinkInfo0.h = parcel0.readString();
                parcel0.readStringArray(melonLinkInfo0.i);
                melonLinkInfo0.j = parcel0.readString();
                melonLinkInfo0.k = parcel0.readString();
                melonLinkInfo0.l = parcel0.readInt();
                melonLinkInfo0.m = parcel0.readString();
                melonLinkInfo0.n = parcel0.readString();
                melonLinkInfo0.o = parcel0.readString();
                melonLinkInfo0.r = parcel0.readBoolean();
                return melonLinkInfo0;
            }
            case 1: {
                TagInfo tagInfo0 = new TagInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                tagInfo0.b = "";
                tagInfo0.a = parcel0.readString();
                tagInfo0.b = parcel0.readString();
                return tagInfo0;
            }
            case 2: {
                q.g(parcel0, "parcel");
                M m0 = M.valueOf(parcel0.readString());
                int v = parcel0.readInt();
                Integer integer0 = parcel0.readInt() == 0 ? null : parcel0.readInt();
                String s2 = parcel0.readString();
                return parcel0.readInt() == 0 ? new MelonBottomSheetItem(m0, v, integer0, s2, false, ((ExtraProperties)parcel0.readParcelable(MelonBottomSheetItem.class.getClassLoader()))) : new MelonBottomSheetItem(m0, v, integer0, s2, true, ((ExtraProperties)parcel0.readParcelable(MelonBottomSheetItem.class.getClassLoader())));
            }
            default: {
                q.g(parcel0, "parcel");
                String s = parcel0.readString();
                String s1 = parcel0.readString();
                return parcel0.readInt() == 0 ? new QualityData(s, s1, false) : new QualityData(s, s1, true);
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new MelonLinkInfo[v];
            }
            case 1: {
                return new TagInfo[v];
            }
            case 2: {
                return new MelonBottomSheetItem[v];
            }
            default: {
                return new QualityData[v];
            }
        }
    }
}

