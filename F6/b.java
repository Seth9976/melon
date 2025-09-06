package f6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.google.android.material.badge.BadgeState.State;
import com.google.android.material.internal.B;
import d6.a;
import e1.n;
import java.io.IOException;
import java.util.Locale.Category;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

public final class b {
    public final BadgeState.State a;
    public final BadgeState.State b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final int i;
    public final int j;
    public final int k;

    public b(Context context0, BadgeState.State badgeState$State0) {
        int v2;
        AttributeSet attributeSet1;
        AttributeSet attributeSet0;
        this.b = new BadgeState.State();
        BadgeState.State badgeState$State1 = badgeState$State0 == null ? new BadgeState.State() : badgeState$State0;
        int v = badgeState$State1.a;
        if(v == 0) {
            attributeSet1 = null;
            v2 = 0;
        }
        else {
            try {
                XmlResourceParser xmlResourceParser0 = context0.getResources().getXml(v);
                do {
                    int v1 = xmlResourceParser0.next();
                }
                while(v1 != 1 && v1 != 2);
                if(v1 != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if(!TextUtils.equals(xmlResourceParser0.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <badge> start tag");
                }
                attributeSet0 = Xml.asAttributeSet(xmlResourceParser0);
            }
            catch(XmlPullParserException | IOException xmlPullParserException0) {
                Resources.NotFoundException resources$NotFoundException0 = new Resources.NotFoundException("Can\'t load badge resource ID #0x" + Integer.toHexString(v));
                resources$NotFoundException0.initCause(xmlPullParserException0);
                throw resources$NotFoundException0;
            }
            attributeSet1 = attributeSet0;
            v2 = attributeSet0.getStyleAttribute();
        }
        if(v2 == 0) {
            v2 = 0x7F140480;  // style:Widget.MaterialComponents.Badge
        }
        TypedArray typedArray0 = B.m(context0, attributeSet1, a.c, 0x7F04006F, v2, new int[0]);  // attr:badgeStyle
        Resources resources0 = context0.getResources();
        this.c = (float)typedArray0.getDimensionPixelSize(4, -1);
        this.i = context0.getResources().getDimensionPixelSize(0x7F07032C);  // dimen:mtrl_badge_horizontal_edge_offset
        this.j = context0.getResources().getDimensionPixelSize(0x7F07032F);  // dimen:mtrl_badge_text_horizontal_edge_offset
        this.d = (float)typedArray0.getDimensionPixelSize(14, -1);
        int v3 = 12;
        this.e = typedArray0.getDimension(12, resources0.getDimension(0x7F07015D));  // dimen:m3_badge_size
        this.g = typedArray0.getDimension(17, resources0.getDimension(0x7F070161));  // dimen:m3_badge_with_text_size
        this.f = typedArray0.getDimension(3, resources0.getDimension(0x7F07015D));  // dimen:m3_badge_size
        this.h = typedArray0.getDimension(13, resources0.getDimension(0x7F070161));  // dimen:m3_badge_with_text_size
        this.k = typedArray0.getInt(24, 1);
        BadgeState.State badgeState$State2 = this.b;
        badgeState$State2.i = badgeState$State1.i == -2 ? 0xFF : badgeState$State1.i;
        int v4 = badgeState$State1.k;
        if(v4 != -2) {
            badgeState$State2.k = v4;
        }
        else if(typedArray0.hasValue(23)) {
            this.b.k = typedArray0.getInt(23, 0);
        }
        else {
            this.b.k = -1;
        }
        String s = badgeState$State1.j;
        if(s != null) {
            this.b.j = s;
        }
        else if(typedArray0.hasValue(7)) {
            this.b.j = typedArray0.getString(7);
        }
        BadgeState.State badgeState$State3 = this.b;
        badgeState$State3.o = badgeState$State1.o;
        CharSequence charSequence0 = badgeState$State1.r;
        if(charSequence0 == null) {
            charSequence0 = "New notification";
        }
        badgeState$State3.r = charSequence0;
        this.b.w = badgeState$State1.w == 0 ? 0x7F110000 : badgeState$State1.w;  // plurals:mtrl_badge_content_description
        this.b.B = badgeState$State1.B == 0 ? 0x7F1306E3 : badgeState$State1.B;  // string:mtrl_exceed_max_badge_number_content_description "More than %1$d new notifications"
        this.b.E = Boolean.valueOf(badgeState$State1.E == null || badgeState$State1.E.booleanValue());
        this.b.l = badgeState$State1.l == -2 ? typedArray0.getInt(21, -2) : badgeState$State1.l;
        this.b.m = badgeState$State1.m == -2 ? typedArray0.getInt(22, -2) : badgeState$State1.m;
        this.b.e = (int)(badgeState$State1.e == null ? typedArray0.getResourceId(5, 0x7F1401D9) : ((int)badgeState$State1.e));  // style:ShapeAppearance.M3.Sys.Shape.Corner.Full
        this.b.f = (int)(badgeState$State1.f == null ? typedArray0.getResourceId(6, 0) : ((int)badgeState$State1.f));
        this.b.g = (int)(badgeState$State1.g == null ? typedArray0.getResourceId(15, 0x7F1401D9) : ((int)badgeState$State1.g));  // style:ShapeAppearance.M3.Sys.Shape.Corner.Full
        this.b.h = (int)(badgeState$State1.h == null ? typedArray0.getResourceId(16, 0) : ((int)badgeState$State1.h));
        this.b.b = (int)(badgeState$State1.b == null ? n.r(context0, typedArray0, 1).getDefaultColor() : ((int)badgeState$State1.b));
        this.b.d = (int)(badgeState$State1.d == null ? typedArray0.getResourceId(8, 0x7F140272) : ((int)badgeState$State1.d));  // style:TextAppearance.MaterialComponents.Badge
        Integer integer0 = badgeState$State1.c;
        if(integer0 != null) {
            this.b.c = integer0;
        }
        else if(typedArray0.hasValue(9)) {
            this.b.c = n.r(context0, typedArray0, 9).getDefaultColor();
        }
        else {
            int v5 = (int)this.b.d;
            TypedArray typedArray1 = context0.obtainStyledAttributes(v5, a.f0);
            typedArray1.getDimension(0, 0.0f);
            ColorStateList colorStateList0 = n.r(context0, typedArray1, 3);
            n.r(context0, typedArray1, 4);
            n.r(context0, typedArray1, 5);
            typedArray1.getInt(2, 0);
            typedArray1.getInt(1, 1);
            if(!typedArray1.hasValue(12)) {
                v3 = 10;
            }
            typedArray1.getResourceId(v3, 0);
            typedArray1.getString(v3);
            typedArray1.getBoolean(14, false);
            n.r(context0, typedArray1, 6);
            typedArray1.getFloat(7, 0.0f);
            typedArray1.getFloat(8, 0.0f);
            typedArray1.getFloat(9, 0.0f);
            typedArray1.recycle();
            TypedArray typedArray2 = context0.obtainStyledAttributes(v5, a.K);
            typedArray2.hasValue(0);
            typedArray2.getFloat(0, 0.0f);
            typedArray2.recycle();
            this.b.c = colorStateList0.getDefaultColor();
        }
        this.b.D = (int)(badgeState$State1.D == null ? typedArray0.getInt(2, 0x800035) : ((int)badgeState$State1.D));
        this.b.G = (int)(badgeState$State1.G == null ? typedArray0.getDimensionPixelSize(11, resources0.getDimensionPixelSize(0x7F07032D)) : ((int)badgeState$State1.G));  // dimen:mtrl_badge_long_text_horizontal_padding
        this.b.I = (int)(badgeState$State1.I == null ? typedArray0.getDimensionPixelSize(10, resources0.getDimensionPixelSize(0x7F070163)) : ((int)badgeState$State1.I));  // dimen:m3_badge_with_text_vertical_padding
        this.b.M = (int)(badgeState$State1.M == null ? typedArray0.getDimensionPixelOffset(18, 0) : ((int)badgeState$State1.M));
        this.b.N = (int)(badgeState$State1.N == null ? typedArray0.getDimensionPixelOffset(25, 0) : ((int)badgeState$State1.N));
        this.b.S = (int)(badgeState$State1.S == null ? typedArray0.getDimensionPixelOffset(19, ((int)this.b.M)) : ((int)badgeState$State1.S));
        this.b.T = (int)(badgeState$State1.T == null ? typedArray0.getDimensionPixelOffset(26, ((int)this.b.N)) : ((int)badgeState$State1.T));
        this.b.X = (int)(badgeState$State1.X == null ? typedArray0.getDimensionPixelOffset(20, 0) : ((int)badgeState$State1.X));
        this.b.V = (int)(badgeState$State1.V == null ? 0 : ((int)badgeState$State1.V));
        this.b.W = (int)(badgeState$State1.W == null ? 0 : ((int)badgeState$State1.W));
        this.b.Y = Boolean.valueOf((badgeState$State1.Y == null ? typedArray0.getBoolean(0, false) : badgeState$State1.Y.booleanValue()));
        typedArray0.recycle();
        Locale locale0 = badgeState$State1.n;
        this.b.n = locale0 == null ? Locale.getDefault(Locale.Category.FORMAT) : locale0;
        this.a = badgeState$State1;
    }
}

