package com.iloen.melon.utils;

import H0.b;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView.BufferType;
import android.widget.TextView;
import b3.Z;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagParser {
    class InternalURLSpan extends ClickableSpan {
        public final String a;
        public final int b;
        public final TagParser c;

        public InternalURLSpan(String s, int v) {
            this.a = s;
            this.b = v;
        }

        @Override  // android.text.style.ClickableSpan
        public void onClick(View view0) {
            StringBuilder stringBuilder0 = new StringBuilder("InternalURLSpan >> onClick() >> TagName: ");
            String s = this.a;
            Z.x(stringBuilder0, s, "TagParser");
            OnTagClickListener tagParser$OnTagClickListener0 = TagParser.this.d;
            if(tagParser$OnTagClickListener0 != null) {
                tagParser$OnTagClickListener0.onTagClicked(s);
            }
        }

        @Override  // android.text.style.ClickableSpan
        public void updateDrawState(TextPaint textPaint0) {
            textPaint0.setColor(ColorUtils.getColor(TagParser.this.a, this.b));
        }
    }

    public interface OnParsedListener {
        void onParseFailed(int arg1, String arg2);

        void onParseSuccess(ArrayList arg1, SpannableString arg2, int arg3);
    }

    public interface OnTagClickListener {
        void onTagClicked(String arg1);
    }

    public static class TagPos implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public int begin;
        public int end;
        public String tagName;

        static {
            TagPos.CREATOR = new Parcelable.Creator() {  // 初始化器: Ljava/lang/Object;-><init>()V
                public TagPos createFromParcel(Parcel parcel0) {
                    TagPos tagParser$TagPos0 = new TagPos();  // 初始化器: Ljava/lang/Object;-><init>()V
                    tagParser$TagPos0.a = 0;
                    tagParser$TagPos0.begin = parcel0.readInt();
                    tagParser$TagPos0.end = parcel0.readInt();
                    tagParser$TagPos0.tagName = parcel0.readString();
                    tagParser$TagPos0.a = parcel0.readInt();
                    return tagParser$TagPos0;
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public TagPos[] newArray(int v) {
                    return new TagPos[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public TagPos(int v, int v1, String s) {
            this.a = 0;
            this.begin = v;
            this.end = v1;
            this.tagName = s;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isRepresent() {
            return this.a == 1;
        }

        public void setRepresent(boolean z) {
            this.a = z ? 1 : 0;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.begin);
            parcel0.writeInt(this.end);
            parcel0.writeString(this.tagName);
            parcel0.writeInt(this.a);
        }
    }

    public static final int RESULT_FAILED_TAG_NOT_EXIST = 0;
    public static final int RESULT_FAILED_UNKNOWN_ERROR = 1;
    public static final String TAG = "TagParser";
    public final Context a;
    public TextView b;
    public final OnParsedListener c;
    public OnTagClickListener d;
    public ArrayList e;
    public HashMap f;
    public int g;

    public TagParser(Context context0, OnParsedListener tagParser$OnParsedListener0) {
        this.a = context0;
        this.c = tagParser$OnParsedListener0;
    }

    public static String a(String s) {
        LogU.d("TagParser", "getUsableWord() >> Before word: " + s);
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = s.length();
        for(int v1 = 1; v1 <= v; ++v1) {
            String s1 = s.substring(v1 - 1, v1);
            if(!"#".equals(s1) && !"_".equals(s1) && !Pattern.matches("[0-9]", s1) && !Pattern.matches("[A-Z]", s1) && !Pattern.matches("[a-z]", s1) && !Pattern.matches("[ㄱ-힣]", s1)) {
                break;
            }
            stringBuilder0.append(s1);
        }
        LogU.d("TagParser", "getUsableWord() >> After word: " + stringBuilder0.toString());
        return stringBuilder0.toString();
    }

    // 去混淆评级： 低(30)
    public final boolean b(String s) {
        return !TextUtils.isEmpty(s) && (this.f == null || this.f.size() < 1 || this.f.containsKey(s.toLowerCase()));
    }

    public final void c(int v, String s) {
        synchronized(this) {
            if(this.a != null && !TextUtils.isEmpty(s)) {
                this.g = v;
                ArrayList arrayList0 = new ArrayList();
                int v2 = s.length();
                boolean z = false;
                int v3 = 0;
                int v4 = 0;
                while(v3 < v2) {
                    int v5 = s.indexOf("#", v4);
                    if(v5 > 0) {
                        String s1 = s.substring(v5 - 1, v5);
                        if(!" ".equals(s1) && !"\n".equals(s1)) {
                            v4 = v5 + 1;
                        }
                    }
                    else if(v5 == -1) {
                        break;
                    }
                    else {
                        if(v5 < v4) {
                            break;
                        }
                        int v6 = s.indexOf(" ", v5 + 1);
                        int v7 = s.indexOf("\n", v5 + 1);
                        if(v6 <= 0 && v7 <= 0 || v6 <= v7) {
                            v6 = v7;
                        }
                        int v8 = s.indexOf("#", v5 + 1);
                        if(v8 > -1 && v8 < v6) {
                            v6 = v8;
                        }
                        if(v6 > 0) {
                            String s2 = TagParser.a(s.substring(v5, v6));
                            int v9 = s2.length() + v5;
                            if(this.b(s2)) {
                                arrayList0.add(new TagPos(v5, v9, s2));
                            }
                            v4 = v9 + 1;
                        }
                        else {
                            goto label_33;
                        }
                    }
                    ++v3;
                    continue;
                label_33:
                    String s3 = TagParser.a(s.substring(v5, s.length()));
                    int v10 = s3.length();
                    if(!this.b(s3)) {
                        break;
                    }
                    arrayList0.add(new TagPos(v5, v10 + v5, s3));
                    if(true) {
                        break;
                    }
                }
                if(arrayList0.size() < 1) {
                    this.e = arrayList0;
                    this.c.onParseFailed(0, s);
                    return;
                }
                SpannableString spannableString0 = new SpannableString(s);
                int v11 = arrayList0.size();
                for(int v12 = 0; v12 < v11; ++v12) {
                    TagPos tagParser$TagPos0 = (TagPos)arrayList0.get(v12);
                    spannableString0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.a, 0x7F06017C)), tagParser$TagPos0.begin, tagParser$TagPos0.end, 33);  // color:green500s_support_high_contrast
                    spannableString0.setSpan(new InternalURLSpan(this, tagParser$TagPos0.tagName, 0x7F06017C), tagParser$TagPos0.begin, tagParser$TagPos0.end, 33);  // color:green500s_support_high_contrast
                }
                ArrayList arrayList1 = this.e;
                if(arrayList1 == null) {
                    this.c.onParseSuccess(arrayList0, spannableString0, this.g);
                }
                else {
                    if(arrayList0.size() >= 1 && arrayList0.size() == arrayList1.size()) {
                        for(int v13 = 0; true; ++v13) {
                            if(v13 >= arrayList0.size()) {
                                z = true;
                                break;
                            }
                            TagPos tagParser$TagPos1 = (TagPos)arrayList0.get(v13);
                            TagPos tagParser$TagPos2 = (TagPos)arrayList1.get(v13);
                            if(!tagParser$TagPos1.tagName.equals(tagParser$TagPos2.tagName)) {
                                break;
                            }
                        }
                    }
                    if(!z) {
                        this.c.onParseSuccess(arrayList0, spannableString0, this.g);
                    }
                }
                TextView textView0 = this.b;
                if(textView0 != null) {
                    textView0.setTextKeepState(spannableString0, TextView.BufferType.SPANNABLE);
                }
                this.e = arrayList0;
            }
        }
    }

    public static int checkTagCount(String s) {
        Matcher matcher0 = Pattern.compile("#([a-z0-9ㄱ-힣#_]+)", 2).matcher(s);
        int v;
        for(v = 0; matcher0.find(); ++v) {
        }
        return v;
    }

    public void clear() {
        if(this.e != null) {
            while(this.e.size() > 0) {
                this.e.remove(0);
            }
            this.e = null;
        }
    }

    public TagPos getTagByName(String s) {
        if(!TextUtils.isEmpty(s)) {
            for(Object object0: this.e) {
                TagPos tagParser$TagPos0 = (TagPos)object0;
                if(s.equals(tagParser$TagPos0.tagName)) {
                    return tagParser$TagPos0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public TagPos getTagInnerPos(int v) {
        if(this.e != null && this.e.size() > 0) {
            for(Object object0: this.e) {
                TagPos tagParser$TagPos0 = (TagPos)object0;
                if(v >= tagParser$TagPos0.begin && v <= tagParser$TagPos0.end) {
                    return tagParser$TagPos0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public void parse(String s) {
        this.parse(s, -1);
    }

    public void parse(String s, int v) {
        try {
            this.c(v, s);
        }
        catch(Exception exception0) {
            LogU.e("TagParser", exception0.toString());
            this.c.onParseFailed(1, null);
        }
    }

    public void setBinderView(TextView textView0) {
        this.b = textView0;
    }

    public void setTagCandidate(HashMap hashMap0) {
        this.f = hashMap0;
    }

    public void setTagClickListener(OnTagClickListener tagParser$OnTagClickListener0) {
        this.d = tagParser$OnTagClickListener0;
    }

    public void syncWithSpannable(Spannable spannable0) {
        if(spannable0 != null && !TextUtils.isEmpty(spannable0)) {
            Object[] arr_object = spannable0.getSpans(0, spannable0.length(), ForegroundColorSpan.class);
            for(int v = 0; v < arr_object.length; ++v) {
                spannable0.removeSpan(arr_object[v]);
            }
            if(this.e != null && this.e.size() >= 1) {
                try {
                    for(Object object0: this.e) {
                        spannable0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.a, 0x7F06017C)), ((TagPos)object0).begin, ((TagPos)object0).end, 33);  // color:green500s_support_high_contrast
                    }
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                    LogU.e("TagParser", "syncWithSpannable() >> Err: " + indexOutOfBoundsException0.toString());
                }
                catch(Exception exception0) {
                    b.v(exception0, new StringBuilder("syncWithSpannable() >> Err: "), "TagParser");
                }
            }
        }
    }
}

