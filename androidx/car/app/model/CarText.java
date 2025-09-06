package androidx.car.app.model;

import U4.x;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.car.app.utils.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class CarText {
    public static final class Builder {
        CharSequence mText;
        List mTextVariants;

        public Builder(CharSequence charSequence0) {
            this.mTextVariants = new ArrayList();
            Objects.requireNonNull(charSequence0);
            this.mText = charSequence0;
        }

        public Builder addVariant(CharSequence charSequence0) {
            List list0 = this.mTextVariants;
            Objects.requireNonNull(charSequence0);
            list0.add(charSequence0);
            return this;
        }

        public CarText build() {
            return new CarText(this);
        }
    }

    public static class SpanWrapper {
        private final CarSpan mCarSpan;
        private final int mEnd;
        private final int mFlags;
        private final int mStart;

        public SpanWrapper() {
            this.mStart = 0;
            this.mEnd = 0;
            this.mFlags = 0;
            this.mCarSpan = new CarSpan();
        }

        public SpanWrapper(Spanned spanned0, CarSpan carSpan0) {
            this.mStart = spanned0.getSpanStart(carSpan0);
            this.mEnd = spanned0.getSpanEnd(carSpan0);
            this.mFlags = spanned0.getSpanFlags(carSpan0);
            this.mCarSpan = carSpan0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof SpanWrapper ? this.mStart == ((SpanWrapper)object0).mStart && this.mEnd == ((SpanWrapper)object0).mEnd && this.mFlags == ((SpanWrapper)object0).mFlags && Objects.equals(this.mCarSpan, ((SpanWrapper)object0).mCarSpan) : false;
        }

        public CarSpan getCarSpan() {
            return this.mCarSpan;
        }

        public int getEnd() {
            return this.mEnd;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public int getStart() {
            return this.mStart;
        }

        @Override
        public int hashCode() {
            return Objects.hash(new Object[]{this.mStart, this.mEnd, this.mFlags, this.mCarSpan});
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("[");
            stringBuilder0.append(this.mCarSpan);
            stringBuilder0.append(": ");
            stringBuilder0.append(this.mStart);
            stringBuilder0.append(", ");
            stringBuilder0.append(this.mEnd);
            stringBuilder0.append(", flags: ");
            return x.g(this.mFlags, "]", stringBuilder0);
        }
    }

    private final List mSpans;
    private final List mSpansForVariants;
    private final String mText;
    private final List mTextVariants;

    private CarText() {
        this.mText = "";
        this.mSpans = Collections.EMPTY_LIST;
        this.mTextVariants = Collections.EMPTY_LIST;
        this.mSpansForVariants = Collections.EMPTY_LIST;
    }

    public CarText(Builder carText$Builder0) {
        this.mText = carText$Builder0.mText.toString();
        this.mSpans = CarText.getSpans(carText$Builder0.mText);
        List list0 = carText$Builder0.mTextVariants;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            CharSequence charSequence0 = (CharSequence)list0.get(v);
            arrayList0.add(charSequence0.toString());
            arrayList1.add(CarText.getSpans(charSequence0));
        }
        this.mTextVariants = g.g(arrayList0);
        this.mSpansForVariants = g.g(arrayList1);
    }

    public CarText(CharSequence charSequence0) {
        this.mText = charSequence0.toString();
        this.mSpans = CarText.getSpans(charSequence0);
        this.mTextVariants = Collections.EMPTY_LIST;
        this.mSpansForVariants = Collections.EMPTY_LIST;
    }

    public static CarText create(CharSequence charSequence0) {
        Objects.requireNonNull(charSequence0);
        return new CarText(charSequence0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarText ? Objects.equals(this.mText, ((CarText)object0).mText) && Objects.equals(this.mSpans, ((CarText)object0).mSpans) && Objects.equals(this.mTextVariants, ((CarText)object0).mTextVariants) && Objects.equals(this.mSpansForVariants, ((CarText)object0).mSpansForVariants) : false;
    }

    private static CharSequence getCharSequence(String s, List list0) {
        CharSequence charSequence0 = new SpannableString(s);
        if(list0 == null) {
            list0 = Collections.EMPTY_LIST;
        }
        for(Object object0: list0) {
            ((SpannableString)charSequence0).setSpan(((SpanWrapper)object0).getCarSpan(), ((SpanWrapper)object0).getStart(), ((SpanWrapper)object0).getEnd(), ((SpanWrapper)object0).getFlags());
        }
        return charSequence0;
    }

    private static List getSpans(CharSequence charSequence0) {
        ArrayList arrayList0 = new ArrayList();
        if(charSequence0 instanceof Spanned) {
            Object[] arr_object = ((Spanned)charSequence0).getSpans(0, charSequence0.length(), Object.class);
            for(int v = 0; v < arr_object.length; ++v) {
                Object object0 = arr_object[v];
                if(object0 instanceof CarSpan) {
                    arrayList0.add(new SpanWrapper(((Spanned)charSequence0), ((CarSpan)object0)));
                }
            }
        }
        return g.g(arrayList0);
    }

    public List getSpans() {
        return this.mSpans;
    }

    public List getSpansForVariants() {
        return this.mSpansForVariants;
    }

    public List getVariants() {
        if(this.mTextVariants.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < this.mTextVariants.size(); ++v) {
            arrayList0.add(CarText.getCharSequence(((String)this.mTextVariants.get(v)), ((List)this.mSpansForVariants.get(v))));
        }
        return Collections.unmodifiableList(arrayList0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mText, this.mSpans, this.mTextVariants, this.mSpansForVariants});
    }

    public boolean isEmpty() {
        return this.mText.isEmpty();
    }

    public static boolean isNullOrEmpty(CarText carText0) {
        return carText0 == null || carText0.isEmpty();
    }

    public CharSequence toCharSequence() {
        return CarText.getCharSequence(this.mText, this.mSpans);
    }

    // 去混淆评级： 中等(130)
    public static String toShortString(CarText carText0) {
        return carText0 == null ? null : "";
    }

    @Override
    public String toString() [...] // 潜在的解密器
}

