package io.netty.util;

import U4.x;
import androidx.appcompat.app.o;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public final class AsciiString implements CharSequence, Comparable {
    static final class AsciiCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE;

        static {
            AsciiCaseInsensitiveCharEqualityComparator.INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();
        }

        @Override  // io.netty.util.AsciiString$CharEqualityComparator
        public boolean equals(char c, char c1) {
            return AsciiString.equalsIgnoreCase(c, c1);
        }
    }

    interface CharEqualityComparator {
        boolean equals(char arg1, char arg2);
    }

    static final class DefaultCharEqualityComparator implements CharEqualityComparator {
        static final DefaultCharEqualityComparator INSTANCE;

        static {
            DefaultCharEqualityComparator.INSTANCE = new DefaultCharEqualityComparator();
        }

        // 检测为 Lambda 实现
        @Override  // io.netty.util.AsciiString$CharEqualityComparator
        public boolean equals(char c, char c1) [...]
    }

    static final class GeneralCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE;

        static {
            GeneralCaseInsensitiveCharEqualityComparator.INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();
        }

        // 检测为 Lambda 实现
        @Override  // io.netty.util.AsciiString$CharEqualityComparator
        public boolean equals(char c, char c1) [...]
    }

    public static final HashingStrategy CASE_INSENSITIVE_HASHER = null;
    public static final HashingStrategy CASE_SENSITIVE_HASHER = null;
    public static final AsciiString EMPTY_STRING = null;
    public static final int INDEX_NOT_FOUND = -1;
    private static final char MAX_CHAR_VALUE = 'ÿ';
    private int hash;
    private final int length;
    private final int offset;
    private String string;
    private final byte[] value;

    static {
        AsciiString.EMPTY_STRING = AsciiString.cached("");
        AsciiString.CASE_INSENSITIVE_HASHER = new HashingStrategy() {
            public boolean equals(CharSequence charSequence0, CharSequence charSequence1) {
                return AsciiString.contentEqualsIgnoreCase(charSequence0, charSequence1);
            }

            @Override  // io.netty.util.HashingStrategy
            public boolean equals(Object object0, Object object1) {
                return this.equals(((CharSequence)object0), ((CharSequence)object1));
            }

            public int hashCode(CharSequence charSequence0) {
                return AsciiString.hashCode(charSequence0);
            }

            @Override  // io.netty.util.HashingStrategy
            public int hashCode(Object object0) {
                return this.hashCode(((CharSequence)object0));
            }
        };
        AsciiString.CASE_SENSITIVE_HASHER = new HashingStrategy() {
            public boolean equals(CharSequence charSequence0, CharSequence charSequence1) {
                return AsciiString.contentEquals(charSequence0, charSequence1);
            }

            @Override  // io.netty.util.HashingStrategy
            public boolean equals(Object object0, Object object1) {
                return this.equals(((CharSequence)object0), ((CharSequence)object1));
            }

            public int hashCode(CharSequence charSequence0) {
                return AsciiString.hashCode(charSequence0);
            }

            @Override  // io.netty.util.HashingStrategy
            public int hashCode(Object object0) {
                return this.hashCode(((CharSequence)object0));
            }
        };
    }

    public AsciiString(CharSequence charSequence0) {
        this(charSequence0, 0, charSequence0.length());
    }

    public AsciiString(CharSequence charSequence0, int v, int v1) {
        if(!MathUtil.isOutOfBounds(v, v1, charSequence0.length())) {
            this.value = PlatformDependent.allocateUninitializedArray(v1);
            int v2 = 0;
            while(v2 < v1) {
                this.value[v2] = AsciiString.c2b(charSequence0.charAt(v));
                ++v2;
                ++v;
            }
            this.offset = 0;
            this.length = v1;
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "expected: 0 <= start(", ") <= start + length(", ") <= value.length(");
        stringBuilder0.append(charSequence0.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public AsciiString(CharSequence charSequence0, Charset charset0) {
        this(charSequence0, charset0, 0, charSequence0.length());
    }

    public AsciiString(CharSequence charSequence0, Charset charset0, int v, int v1) {
        CharBuffer charBuffer0 = CharBuffer.wrap(charSequence0, v, v + v1);
        CharsetEncoder charsetEncoder0 = CharsetUtil.encoder(charset0);
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(((int)(charsetEncoder0.maxBytesPerChar() * ((float)v1))));
        charsetEncoder0.encode(charBuffer0, byteBuffer0, true);
        int v2 = byteBuffer0.arrayOffset();
        byte[] arr_b = Arrays.copyOfRange(byteBuffer0.array(), v2, byteBuffer0.position() + v2);
        this.value = arr_b;
        this.offset = 0;
        this.length = arr_b.length;
    }

    public AsciiString(ByteBuffer byteBuffer0) {
        this(byteBuffer0, true);
    }

    public AsciiString(ByteBuffer byteBuffer0, int v, int v1, boolean z) {
        if(!MathUtil.isOutOfBounds(v, v1, byteBuffer0.capacity())) {
            if(!byteBuffer0.hasArray()) {
                byte[] arr_b = PlatformDependent.allocateUninitializedArray(v1);
                this.value = arr_b;
                byteBuffer0.get(arr_b, 0, v1);
                byteBuffer0.position(byteBuffer0.position());
                this.offset = 0;
            }
            else if(z) {
                int v2 = byteBuffer0.arrayOffset();
                this.value = Arrays.copyOfRange(byteBuffer0.array(), v2 + v, v2 + v + v1);
                this.offset = 0;
            }
            else {
                this.value = byteBuffer0.array();
                this.offset = v;
            }
            this.length = v1;
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "expected: 0 <= start(", ") <= start + length(", ") <= value.capacity(");
        stringBuilder0.append(byteBuffer0.capacity());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public AsciiString(ByteBuffer byteBuffer0, boolean z) {
        this(byteBuffer0, byteBuffer0.position(), byteBuffer0.remaining(), z);
    }

    public AsciiString(byte[] arr_b) {
        this(arr_b, true);
    }

    public AsciiString(byte[] arr_b, int v, int v1, boolean z) {
        if(z) {
            byte[] arr_b1 = new byte[v1];
            System.arraycopy(arr_b, v, arr_b1, 0, v1);
            this.value = arr_b1;
            this.offset = 0;
        }
        else if(!MathUtil.isOutOfBounds(v, v1, arr_b.length)) {
            this.value = arr_b;
            this.offset = v;
        }
        else {
            throw new IndexOutOfBoundsException(o.q(o.t(v, v1, "expected: 0 <= start(", ") <= start + length(", ") <= value.length("), arr_b.length, ')'));
        }
        this.length = v1;
    }

    public AsciiString(byte[] arr_b, boolean z) {
        this(arr_b, 0, arr_b.length, z);
    }

    public AsciiString(char[] arr_c) {
        this(arr_c, 0, arr_c.length);
    }

    public AsciiString(char[] arr_c, int v, int v1) {
        if(MathUtil.isOutOfBounds(v, v1, arr_c.length)) {
            throw new IndexOutOfBoundsException(o.q(o.t(v, v1, "expected: 0 <= start(", ") <= start + length(", ") <= value.length("), arr_c.length, ')'));
        }
        this.value = PlatformDependent.allocateUninitializedArray(v1);
        int v2 = 0;
        while(v2 < v1) {
            this.value[v2] = AsciiString.c2b(arr_c[v]);
            ++v2;
            ++v;
        }
        this.offset = 0;
        this.length = v1;
    }

    public AsciiString(char[] arr_c, Charset charset0) {
        this(arr_c, charset0, 0, arr_c.length);
    }

    public AsciiString(char[] arr_c, Charset charset0, int v, int v1) {
        CharBuffer charBuffer0 = CharBuffer.wrap(arr_c, v, v1);
        CharsetEncoder charsetEncoder0 = CharsetUtil.encoder(charset0);
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(((int)(charsetEncoder0.maxBytesPerChar() * ((float)v1))));
        charsetEncoder0.encode(charBuffer0, byteBuffer0, true);
        int v2 = byteBuffer0.arrayOffset();
        byte[] arr_b = Arrays.copyOfRange(byteBuffer0.array(), v2, byteBuffer0.position() + v2);
        this.value = arr_b;
        this.offset = 0;
        this.length = arr_b.length;
    }

    public byte[] array() {
        return this.value;
    }

    public void arrayChanged() {
        this.string = null;
        this.hash = 0;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public static char b2c(byte b) {
        return (char)(b & 0xFF);
    }

    public byte byteAt(int v) {
        if(v >= 0 && v < this.length) {
            return PlatformDependent.getByte(this.value, v + this.offset);
        }
        StringBuilder stringBuilder0 = x.n(v, "index: ", " must be in the range [0,");
        throw new IndexOutOfBoundsException(x.g(this.length, ")", stringBuilder0));
    }

    public static byte c2b(char c) {
        if(c > 0xFF) {
            c = '?';
        }
        return (byte)c;
    }

    private static byte c2b0(char c) [...] // Inlined contents

    public static AsciiString cached(String s) {
        AsciiString asciiString0 = new AsciiString(s);
        asciiString0.string = s;
        return asciiString0;
    }

    @Override
    public char charAt(int v) {
        return AsciiString.b2c(this.byteAt(v));
    }

    public int compareTo(CharSequence charSequence0) {
        int v = 0;
        if(this == charSequence0) {
            return 0;
        }
        int v1 = this.length();
        int v2 = charSequence0.length();
        int v3 = Math.min(v1, v2);
        for(int v4 = this.arrayOffset(); v < v3; ++v4) {
            int v5 = AsciiString.b2c(this.value[v4]) - charSequence0.charAt(v);
            if(v5 != 0) {
                return v5;
            }
            ++v;
        }
        return v1 - v2;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((CharSequence)object0));
    }

    public AsciiString concat(CharSequence charSequence0) {
        int v = this.length();
        int v1 = charSequence0.length();
        if(v1 == 0) {
            return this;
        }
        if(charSequence0 instanceof AsciiString) {
            if(this.isEmpty()) {
                return (AsciiString)charSequence0;
            }
            byte[] arr_b = PlatformDependent.allocateUninitializedArray(v + v1);
            System.arraycopy(this.value, this.arrayOffset(), arr_b, 0, v);
            System.arraycopy(((AsciiString)charSequence0).value, ((AsciiString)charSequence0).arrayOffset(), arr_b, v, v1);
            return new AsciiString(arr_b, false);
        }
        if(this.isEmpty()) {
            return new AsciiString(charSequence0);
        }
        byte[] arr_b1 = PlatformDependent.allocateUninitializedArray(v1 + v);
        System.arraycopy(this.value, this.arrayOffset(), arr_b1, 0, v);
        for(int v2 = 0; v < arr_b1.length; ++v2) {
            arr_b1[v] = AsciiString.c2b(charSequence0.charAt(v2));
            ++v;
        }
        return new AsciiString(arr_b1, false);
    }

    public static boolean contains(CharSequence charSequence0, CharSequence charSequence1) {
        return AsciiString.contains(charSequence0, charSequence1, (char c, char c1) -> c == c1);
    }

    private static boolean contains(CharSequence charSequence0, CharSequence charSequence1, CharEqualityComparator asciiString$CharEqualityComparator0) {
        if(charSequence0 != null && charSequence1 != null && charSequence0.length() >= charSequence1.length()) {
            if(charSequence1.length() == 0) {
                return true;
            }
            int v1 = 0;
            for(int v = 0; v < charSequence0.length(); ++v) {
                if(asciiString$CharEqualityComparator0.equals(charSequence1.charAt(v1), charSequence0.charAt(v))) {
                    ++v1;
                    if(v1 == charSequence1.length()) {
                        return true;
                    }
                }
                else {
                    if(charSequence0.length() - v < charSequence1.length()) {
                        return false;
                    }
                    v1 = 0;
                }
            }
        }
        return false;
    }

    public boolean contains(CharSequence charSequence0) {
        return this.indexOf(charSequence0) >= 0;
    }

    public static boolean containsAllContentEqualsIgnoreCase(Collection collection0, Collection collection1) {
        for(Object object0: collection1) {
            if(!AsciiString.containsContentEqualsIgnoreCase(collection0, ((CharSequence)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public static boolean containsContentEqualsIgnoreCase(Collection collection0, CharSequence charSequence0) {
        for(Object object0: collection0) {
            if(AsciiString.contentEqualsIgnoreCase(charSequence0, ((CharSequence)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence0, CharSequence charSequence1) {
        return AsciiString.contains(charSequence0, charSequence1, (char c, char c1) -> c == c1 || AsciiString.toLowerCase(c) == AsciiString.toLowerCase(c1));
    }

    public static boolean contentEquals(CharSequence charSequence0, CharSequence charSequence1) {
        if(charSequence0 != null && charSequence1 != null) {
            if(charSequence0 instanceof AsciiString) {
                return ((AsciiString)charSequence0).contentEquals(charSequence1);
            }
            if(charSequence1 instanceof AsciiString) {
                return ((AsciiString)charSequence1).contentEquals(charSequence0);
            }
            if(charSequence0.length() != charSequence1.length()) {
                return false;
            }
            for(int v = 0; v < charSequence0.length(); ++v) {
                if(charSequence0.charAt(v) != charSequence1.charAt(v)) {
                    return false;
                }
            }
            return true;
        }
        return charSequence0 == charSequence1;
    }

    public boolean contentEquals(CharSequence charSequence0) {
        if(this == charSequence0) {
            return true;
        }
        if(charSequence0 != null && charSequence0.length() == this.length()) {
            if(charSequence0 instanceof AsciiString) {
                return this.equals(charSequence0);
            }
            int v = this.arrayOffset();
            for(int v1 = 0; v1 < charSequence0.length(); ++v1) {
                if(AsciiString.b2c(this.value[v]) != charSequence0.charAt(v1)) {
                    return false;
                }
                ++v;
            }
            return true;
        }
        return false;
    }

    public static boolean contentEqualsIgnoreCase(CharSequence charSequence0, CharSequence charSequence1) {
        if(charSequence0 != null && charSequence1 != null) {
            if(charSequence0 instanceof AsciiString) {
                return ((AsciiString)charSequence0).contentEqualsIgnoreCase(charSequence1);
            }
            if(charSequence1 instanceof AsciiString) {
                return ((AsciiString)charSequence1).contentEqualsIgnoreCase(charSequence0);
            }
            if(charSequence0.length() != charSequence1.length()) {
                return false;
            }
            for(int v = 0; v < charSequence0.length(); ++v) {
                if(!AsciiString.equalsIgnoreCase(charSequence0.charAt(v), charSequence1.charAt(v))) {
                    return false;
                }
            }
            return true;
        }
        return charSequence0 == charSequence1;
    }

    public boolean contentEqualsIgnoreCase(CharSequence charSequence0) {
        if(this == charSequence0) {
            return true;
        }
        if(charSequence0 != null && charSequence0.length() == this.length()) {
            if(charSequence0 instanceof AsciiString) {
                int v = this.arrayOffset();
                int v1 = ((AsciiString)charSequence0).arrayOffset();
                int v2 = this.length() + v;
                while(v < v2) {
                    if(!AsciiString.equalsIgnoreCase(this.value[v], ((AsciiString)charSequence0).value[v1])) {
                        return false;
                    }
                    ++v;
                    ++v1;
                }
                return true;
            }
            int v3 = this.arrayOffset();
            int v4 = this.length();
            for(int v5 = 0; v5 < v4; ++v5) {
                if(!AsciiString.equalsIgnoreCase(AsciiString.b2c(this.value[v3]), charSequence0.charAt(v5))) {
                    return false;
                }
                ++v3;
            }
            return true;
        }
        return false;
    }

    public void copy(int v, byte[] arr_b, int v1, int v2) {
        if(!MathUtil.isOutOfBounds(v, v2, this.length())) {
            Object object0 = ObjectUtil.checkNotNull(arr_b, "dst");
            System.arraycopy(this.value, v + this.offset, object0, v1, v2);
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v2, "expected: 0 <= srcIdx(", ") <= srcIdx + length(", ") <= srcLen(");
        stringBuilder0.append(this.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public void copy(int v, char[] arr_c, int v1, int v2) {
        ObjectUtil.checkNotNull(arr_c, "dst");
        if(!MathUtil.isOutOfBounds(v, v2, this.length())) {
            int v3 = v2 + v1;
            for(int v4 = this.arrayOffset() + v; v1 < v3; ++v4) {
                arr_c[v1] = AsciiString.b2c(this.value[v4]);
                ++v1;
            }
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v2, "expected: 0 <= srcIdx(", ") <= srcIdx + length(", ") <= srcLen(");
        stringBuilder0.append(this.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public boolean endsWith(CharSequence charSequence0) {
        int v = charSequence0.length();
        return this.regionMatches(this.length() - v, charSequence0, 0, v);
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == AsciiString.class) {
            return this == object0 ? true : this.length() == ((AsciiString)object0).length() && this.hashCode() == ((AsciiString)object0).hashCode() && PlatformDependent.equals(this.array(), this.arrayOffset(), ((AsciiString)object0).array(), ((AsciiString)object0).arrayOffset(), this.length());
        }
        return false;
    }

    private static boolean equalsIgnoreCase(byte b, byte b1) {
        return b == b1 || AsciiString.toLowerCase(b) == AsciiString.toLowerCase(b1);
    }

    // 检测为 Lambda 实现
    private static boolean equalsIgnoreCase(char c, char c1) [...]

    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        if(!MathUtil.isOutOfBounds(v, v1, this.length())) {
            return this.forEachByte0(v, v1, byteProcessor0);
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "expected: 0 <= index(", ") <= start + length(", ") <= length(");
        stringBuilder0.append(this.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public int forEachByte(ByteProcessor byteProcessor0) {
        return this.forEachByte0(0, this.length(), byteProcessor0);
    }

    private int forEachByte0(int v, int v1, ByteProcessor byteProcessor0) {
        int v2 = this.offset + v + v1;
        for(int v3 = this.offset + v; v3 < v2; ++v3) {
            if(!byteProcessor0.process(this.value[v3])) {
                return v3 - this.offset;
            }
        }
        return -1;
    }

    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        if(!MathUtil.isOutOfBounds(v, v1, this.length())) {
            return this.forEachByteDesc0(v, v1, byteProcessor0);
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "expected: 0 <= index(", ") <= start + length(", ") <= length(");
        stringBuilder0.append(this.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public int forEachByteDesc(ByteProcessor byteProcessor0) {
        return this.forEachByteDesc0(0, this.length(), byteProcessor0);
    }

    private int forEachByteDesc0(int v, int v1, ByteProcessor byteProcessor0) {
        int v2 = this.offset + v;
        for(int v3 = this.offset + v + v1 - 1; v3 >= v2; --v3) {
            if(!byteProcessor0.process(this.value[v3])) {
                return v3 - this.offset;
            }
        }
        return -1;
    }

    public static int hashCode(CharSequence charSequence0) {
        if(charSequence0 == null) {
            return 0;
        }
        return charSequence0 instanceof AsciiString ? charSequence0.hashCode() : PlatformDependent.hashCodeAscii(charSequence0);
    }

    @Override
    public int hashCode() {
        int v = this.hash;
        if(v == 0) {
            v = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
            this.hash = v;
        }
        return v;
    }

    public static int indexOf(CharSequence charSequence0, char c, int v) {
        if(charSequence0 instanceof String) {
            return ((String)charSequence0).indexOf(((int)c), v);
        }
        if(charSequence0 instanceof AsciiString) {
            return ((AsciiString)charSequence0).indexOf(c, v);
        }
        if(charSequence0 == null) {
            return -1;
        }
        int v1 = charSequence0.length();
        if(v < 0) {
            v = 0;
        }
        while(v < v1) {
            if(charSequence0.charAt(v) == c) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    public int indexOf(char c, int v) {
        if(c > 0xFF) {
            return -1;
        }
        if(v < 0) {
            v = 0;
        }
        int v1 = this.length + this.offset;
        for(int v2 = v + this.offset; v2 < v1; ++v2) {
            if(this.value[v2] == ((byte)c)) {
                return v2 - this.offset;
            }
        }
        return -1;
    }

    public int indexOf(CharSequence charSequence0) {
        return this.indexOf(charSequence0, 0);
    }

    public int indexOf(CharSequence charSequence0, int v) {
        int v1 = charSequence0.length();
        if(v < 0) {
            v = 0;
        }
        if(v1 <= 0) {
            return v >= this.length ? this.length : v;
        }
        if(v1 > this.length - v) {
            return -1;
        }
        int v2 = charSequence0.charAt(0);
        if(v2 > 0xFF) {
            return -1;
        }
        int v3 = this.length + this.offset - v1;
        for(int v4 = v + this.offset; v4 <= v3; ++v4) {
            if(this.value[v4] == ((byte)(((char)v2)))) {
                int v5 = v4;
                int v6 = 0;
                while(true) {
                    ++v6;
                    if(v6 >= v1 || AsciiString.b2c(this.value[v5 + 1]) != charSequence0.charAt(v6)) {
                        break;
                    }
                    ++v5;
                }
                if(v6 == v1) {
                    return v4 - this.offset;
                }
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence0, CharSequence charSequence1, int v) {
        if(charSequence0 != null && charSequence1 != null) {
            if(v < 0) {
                v = 0;
            }
            int v1 = charSequence1.length();
            int v2 = charSequence0.length() - v1 + 1;
            if(v > v2) {
                return -1;
            }
            if(v1 == 0) {
                return v;
            }
            for(int v3 = v; v3 < v2; ++v3) {
                if(AsciiString.regionMatches(charSequence0, true, v3, charSequence1, 0, v1)) {
                    return v3;
                }
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCaseAscii(CharSequence charSequence0, CharSequence charSequence1, int v) {
        if(charSequence0 != null && charSequence1 != null) {
            if(v < 0) {
                v = 0;
            }
            int v1 = charSequence1.length();
            int v2 = charSequence0.length() - v1 + 1;
            if(v > v2) {
                return -1;
            }
            if(v1 == 0) {
                return v;
            }
            for(int v3 = v; v3 < v2; ++v3) {
                if(AsciiString.regionMatchesAscii(charSequence0, true, v3, charSequence1, 0, v1)) {
                    return v3;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isEntireArrayUsed() {
        return this.offset == 0 && this.length == this.value.length;
    }

    private static boolean isLowerCase(byte b) {
        return b >= 97 && b <= 0x7A;
    }

    public static boolean isUpperCase(byte b) {
        return b >= 65 && b <= 90;
    }

    public static boolean isUpperCase(char c) {
        return c >= 65 && c <= 90;
    }

    public int lastIndexOf(CharSequence charSequence0) {
        return this.lastIndexOf(charSequence0, this.length);
    }

    public int lastIndexOf(CharSequence charSequence0, int v) {
        int v1 = charSequence0.length();
        int v2 = Math.min(v, this.length - v1);
        if(v2 < 0) {
            return -1;
        }
        if(v1 == 0) {
            return v2;
        }
        int v3 = charSequence0.charAt(0);
        if(v3 > 0xFF) {
            return -1;
        }
        for(int v4 = this.offset + v2; v4 >= this.offset; --v4) {
            if(this.value[v4] == ((byte)(((char)v3)))) {
                int v5 = 0;
                for(int v6 = v4; true; ++v6) {
                    ++v5;
                    if(v5 >= v1 || AsciiString.b2c(this.value[v6 + 1]) != charSequence0.charAt(v5)) {
                        break;
                    }
                }
                if(v5 == v1) {
                    return v4 - this.offset;
                }
            }
        }
        return -1;
    }

    @Override
    public int length() {
        return this.length;
    }

    public boolean matches(String s) {
        return Pattern.matches(s, this);
    }

    // 去混淆评级： 低(20)
    public static AsciiString of(CharSequence charSequence0) {
        return charSequence0 instanceof AsciiString ? ((AsciiString)charSequence0) : new AsciiString(charSequence0);
    }

    public boolean parseBoolean() {
        return this.length >= 1 && this.value[this.offset] != 0;
    }

    public char parseChar() {
        return this.parseChar(0);
    }

    public char parseChar(int v) {
        if(v + 1 >= this.length()) {
            throw new IndexOutOfBoundsException("2 bytes required to convert to character. index " + v + " would go out of bounds.");
        }
        int v1 = v + this.offset;
        return (char)(AsciiString.b2c(this.value[v1 + 1]) | AsciiString.b2c(this.value[v1]) << 8);
    }

    public double parseDouble() {
        return this.parseDouble(0, this.length());
    }

    public double parseDouble(int v, int v1) {
        return Double.parseDouble(this.toString(v, v1));
    }

    public float parseFloat() {
        return this.parseFloat(0, this.length());
    }

    public float parseFloat(int v, int v1) {
        return Float.parseFloat(this.toString(v, v1));
    }

    private int parseInt(int v, int v1, int v2, boolean z) {
        int v3 = v;
        int v4 = 0;
        while(v3 < v1) {
            int v5 = Character.digit(((char)(this.value[v3 + this.offset] & 0xFF)), v2);
            if(v5 == -1 || 0x80000000 / v2 > v4) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            int v6 = v4 * v2 - v5;
            if(v6 > v4) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            v4 = v6;
            ++v3;
        }
        if(!z) {
            if(-v4 < 0) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            return -v4;
        }
        return v4;
    }

    public int parseInt() {
        return this.parseInt(0, this.length(), 10);
    }

    public int parseInt(int v) {
        return this.parseInt(0, this.length(), v);
    }

    public int parseInt(int v, int v1) {
        return this.parseInt(v, v1, 10);
    }

    public int parseInt(int v, int v1, int v2) {
        if(v2 < 2 || v2 > 36 || v == v1) {
            throw new NumberFormatException();
        }
        if(this.byteAt(v) == 45) {
            if(v + 1 == v1) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            return this.parseInt(v + 1, v1, v2, true);
        }
        return this.parseInt(v, v1, v2, false);
    }

    private long parseLong(int v, int v1, int v2, boolean z) {
        int v3 = v;
        long v4 = 0L;
        while(v3 < v1) {
            int v5 = Character.digit(((char)(this.value[v3 + this.offset] & 0xFF)), v2);
            if(v5 == -1 || 0x8000000000000000L / ((long)v2) > v4) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            long v6 = v4 * ((long)v2) - ((long)v5);
            if(v6 > v4) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            v4 = v6;
            ++v3;
        }
        if(!z) {
            if(-v4 < 0L) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            return -v4;
        }
        return v4;
    }

    public long parseLong() {
        return this.parseLong(0, this.length(), 10);
    }

    public long parseLong(int v) {
        return this.parseLong(0, this.length(), v);
    }

    public long parseLong(int v, int v1) {
        return this.parseLong(v, v1, 10);
    }

    public long parseLong(int v, int v1, int v2) {
        if(v2 < 2 || v2 > 36 || v == v1) {
            throw new NumberFormatException();
        }
        if(this.byteAt(v) == 45) {
            if(v + 1 == v1) {
                throw new NumberFormatException(this.subSequence(v, v1, false).toString());
            }
            return this.parseLong(v + 1, v1, v2, true);
        }
        return this.parseLong(v, v1, v2, false);
    }

    public short parseShort() {
        return this.parseShort(0, this.length(), 10);
    }

    public short parseShort(int v) {
        return this.parseShort(0, this.length(), v);
    }

    public short parseShort(int v, int v1) {
        return this.parseShort(v, v1, 10);
    }

    public short parseShort(int v, int v1, int v2) {
        int v3 = this.parseInt(v, v1, v2);
        if(((short)v3) != v3) {
            throw new NumberFormatException(this.subSequence(v, v1, false).toString());
        }
        return (short)v3;
    }

    public static boolean regionMatches(CharSequence charSequence0, boolean z, int v, CharSequence charSequence1, int v1, int v2) {
        if(charSequence0 != null && charSequence1 != null) {
            if(charSequence0 instanceof String && charSequence1 instanceof String) {
                return ((String)charSequence0).regionMatches(z, v, ((String)charSequence1), v1, v2);
            }
            if(charSequence0 instanceof AsciiString) {
                return ((AsciiString)charSequence0).regionMatches(z, v, charSequence1, v1, v2);
            }
            return z ? AsciiString.regionMatchesCharSequences(charSequence0, v, charSequence1, v1, v2, (char c, char c1) -> Character.toUpperCase(c) == Character.toUpperCase(c1) || Character.toLowerCase(c) == Character.toLowerCase(c1)) : AsciiString.regionMatchesCharSequences(charSequence0, v, charSequence1, v1, v2, (char c, char c1) -> c == c1);
        }
        return false;
    }

    public boolean regionMatches(int v, CharSequence charSequence0, int v1, int v2) {
        ObjectUtil.checkNotNull(charSequence0, "string");
        if(v1 >= 0 && charSequence0.length() - v1 >= v2 && (v >= 0 && this.length() - v >= v2)) {
            if(v2 <= 0) {
                return true;
            }
            int v3 = v2 + v1;
            for(int v4 = this.arrayOffset() + v; v1 < v3; ++v4) {
                if(AsciiString.b2c(this.value[v4]) != charSequence0.charAt(v1)) {
                    return false;
                }
                ++v1;
            }
            return true;
        }
        return false;
    }

    public boolean regionMatches(boolean z, int v, CharSequence charSequence0, int v1, int v2) {
        if(!z) {
            return this.regionMatches(v, charSequence0, v1, v2);
        }
        ObjectUtil.checkNotNull(charSequence0, "string");
        if(v >= 0 && v2 <= this.length() - v && v1 >= 0 && v2 <= charSequence0.length() - v1) {
            int v3 = this.arrayOffset() + v;
            int v4 = v2 + v3;
            while(v3 < v4) {
                if(!AsciiString.equalsIgnoreCase(AsciiString.b2c(this.value[v3]), charSequence0.charAt(v1))) {
                    return false;
                }
                ++v1;
                ++v3;
            }
            return true;
        }
        return false;
    }

    public static boolean regionMatchesAscii(CharSequence charSequence0, boolean z, int v, CharSequence charSequence1, int v1, int v2) {
        if(charSequence0 != null && charSequence1 != null) {
            if(!z && charSequence0 instanceof String && charSequence1 instanceof String) {
                return ((String)charSequence0).regionMatches(false, v, ((String)charSequence1), v1, v2);
            }
            if(charSequence0 instanceof AsciiString) {
                return ((AsciiString)charSequence0).regionMatches(z, v, charSequence1, v1, v2);
            }
            return z ? AsciiString.regionMatchesCharSequences(charSequence0, v, charSequence1, v1, v2, (char c, char c1) -> c == c1 || AsciiString.toLowerCase(c) == AsciiString.toLowerCase(c1)) : AsciiString.regionMatchesCharSequences(charSequence0, v, charSequence1, v1, v2, (char c, char c1) -> c == c1);
        }
        return false;
    }

    private static boolean regionMatchesCharSequences(CharSequence charSequence0, int v, CharSequence charSequence1, int v1, int v2, CharEqualityComparator asciiString$CharEqualityComparator0) {
        if(v >= 0 && v2 <= charSequence0.length() - v && v1 >= 0 && v2 <= charSequence1.length() - v1) {
            int v3 = v2 + v;
            while(v < v3) {
                if(!asciiString$CharEqualityComparator0.equals(charSequence0.charAt(v), charSequence1.charAt(v1))) {
                    return false;
                }
                ++v;
                ++v1;
            }
            return true;
        }
        return false;
    }

    public AsciiString replace(char c, char c1) {
        if(c <= 0xFF) {
            byte b = AsciiString.c2b(c1);
            int v = this.offset;
            int v1 = this.length + v;
            while(v < v1) {
                if(this.value[v] == ((byte)c)) {
                    byte[] arr_b = PlatformDependent.allocateUninitializedArray(this.length());
                    System.arraycopy(this.value, this.offset, arr_b, 0, v - this.offset);
                    arr_b[v - this.offset] = b;
                    while(true) {
                        ++v;
                        if(v >= v1) {
                            break;
                        }
                        byte b1 = this.value[v];
                        int v2 = v - this.offset;
                        if(b1 == ((byte)c)) {
                            b1 = b;
                        }
                        arr_b[v2] = b1;
                    }
                    return new AsciiString(arr_b, false);
                }
                ++v;
            }
        }
        return this;
    }

    public AsciiString[] split(char c) {
        ArrayList arrayList0 = InternalThreadLocalMap.get().arrayList();
        int v = this.length();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            if(this.charAt(v1) == c) {
                if(v2 == v1) {
                    arrayList0.add(AsciiString.EMPTY_STRING);
                }
                else {
                    arrayList0.add(new AsciiString(this.value, this.arrayOffset() + v2, v1 - v2, false));
                }
                v2 = v1 + 1;
            }
        }
        if(v2 == 0) {
            arrayList0.add(this);
            return (AsciiString[])arrayList0.toArray(EmptyArrays.EMPTY_ASCII_STRINGS);
        }
        if(v2 != v) {
            arrayList0.add(new AsciiString(this.value, this.arrayOffset() + v2, v - v2, false));
            return (AsciiString[])arrayList0.toArray(EmptyArrays.EMPTY_ASCII_STRINGS);
        }
        for(int v3 = arrayList0.size() - 1; v3 >= 0 && ((AsciiString)arrayList0.get(v3)).isEmpty(); --v3) {
            arrayList0.remove(v3);
        }
        return (AsciiString[])arrayList0.toArray(EmptyArrays.EMPTY_ASCII_STRINGS);
    }

    public AsciiString[] split(String s, int v) {
        return AsciiString.toAsciiStringArray(Pattern.compile(s).split(this, v));
    }

    public boolean startsWith(CharSequence charSequence0) {
        return this.startsWith(charSequence0, 0);
    }

    public boolean startsWith(CharSequence charSequence0, int v) {
        return this.regionMatches(v, charSequence0, 0, charSequence0.length());
    }

    public AsciiString subSequence(int v) {
        return this.subSequence(v, this.length());
    }

    public AsciiString subSequence(int v, int v1) {
        return this.subSequence(v, v1, true);
    }

    public AsciiString subSequence(int v, int v1, boolean z) {
        int v2 = v1 - v;
        if(!MathUtil.isOutOfBounds(v, v2, this.length())) {
            if(v == 0 && v1 == this.length()) {
                return this;
            }
            return v1 == v ? AsciiString.EMPTY_STRING : new AsciiString(this.value, v + this.offset, v2, z);
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "expected: 0 <= start(", ") <= end (", ") <= length(");
        stringBuilder0.append(this.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    @Override
    public CharSequence subSequence(int v, int v1) {
        return this.subSequence(v, v1);
    }

    private static AsciiString[] toAsciiStringArray(String[] arr_s) {
        AsciiString[] arr_asciiString = new AsciiString[arr_s.length];
        for(int v = 0; v < arr_s.length; ++v) {
            arr_asciiString[v] = new AsciiString(arr_s[v]);
        }
        return arr_asciiString;
    }

    public byte[] toByteArray() {
        return this.toByteArray(0, this.length());
    }

    public byte[] toByteArray(int v, int v1) {
        return Arrays.copyOfRange(this.value, v + this.offset, v1 + this.offset);
    }

    public char[] toCharArray() {
        return this.toCharArray(0, this.length());
    }

    public char[] toCharArray(int v, int v1) {
        int v2 = v1 - v;
        if(v2 == 0) {
            return EmptyArrays.EMPTY_CHARS;
        }
        if(!MathUtil.isOutOfBounds(v, v2, this.length())) {
            char[] arr_c = new char[v2];
            int v3 = this.arrayOffset() + v;
            int v4 = 0;
            while(v4 < v2) {
                arr_c[v4] = AsciiString.b2c(this.value[v3]);
                ++v4;
                ++v3;
            }
            return arr_c;
        }
        StringBuilder stringBuilder0 = o.t(v, v2, "expected: 0 <= start(", ") <= srcIdx + length(", ") <= srcLen(");
        stringBuilder0.append(this.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    // 去混淆评级： 低(20)
    private static byte toLowerCase(byte b) {
        return AsciiString.isUpperCase(b) ? ((byte)(b + 0x20)) : b;
    }

    // 去混淆评级： 低(20)
    public static char toLowerCase(char c) {
        return AsciiString.isUpperCase(c) ? ((char)(c + 0x20)) : c;
    }

    public AsciiString toLowerCase() {
        int v = this.length();
        int v1 = this.arrayOffset();
        for(int v2 = this.arrayOffset(); v2 < v1 + v; ++v2) {
            int v3 = this.value[v2];
            if(v3 >= 65 && v3 <= 90) {
                byte[] arr_b = PlatformDependent.allocateUninitializedArray(this.length());
                int v4 = this.arrayOffset();
                int v5 = 0;
                while(v5 < arr_b.length) {
                    arr_b[v5] = AsciiString.toLowerCase(this.value[v4]);
                    ++v5;
                    ++v4;
                }
                return new AsciiString(arr_b, false);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        String s = this.string;
        if(s == null) {
            s = this.toString(0);
            this.string = s;
        }
        return s;
    }

    public String toString(int v) {
        return this.toString(v, this.length());
    }

    public String toString(int v, int v1) {
        int v2 = v1 - v;
        if(v2 == 0) {
            return "";
        }
        if(!MathUtil.isOutOfBounds(v, v2, this.length())) {
            return new String(this.value, 0, v + this.offset, v2);
        }
        StringBuilder stringBuilder0 = o.t(v, v2, "expected: 0 <= start(", ") <= srcIdx + length(", ") <= srcLen(");
        stringBuilder0.append(this.length());
        stringBuilder0.append(')');
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    // 去混淆评级： 低(20)
    private static byte toUpperCase(byte b) {
        return AsciiString.isLowerCase(b) ? ((byte)(b - 0x20)) : b;
    }

    public AsciiString toUpperCase() {
        int v = this.length();
        int v1 = this.arrayOffset();
        for(int v2 = this.arrayOffset(); v2 < v1 + v; ++v2) {
            int v3 = this.value[v2];
            if(v3 >= 97 && v3 <= 0x7A) {
                byte[] arr_b = PlatformDependent.allocateUninitializedArray(this.length());
                int v4 = this.arrayOffset();
                int v5 = 0;
                while(v5 < arr_b.length) {
                    arr_b[v5] = AsciiString.toUpperCase(this.value[v4]);
                    ++v5;
                    ++v4;
                }
                return new AsciiString(arr_b, false);
            }
        }
        return this;
    }

    public static CharSequence trim(CharSequence charSequence0) {
        if(charSequence0 instanceof AsciiString) {
            return ((AsciiString)charSequence0).trim();
        }
        if(charSequence0 instanceof String) {
            return ((String)charSequence0).trim();
        }
        int v = charSequence0.length();
        int v1;
        for(v1 = 0; v1 <= v - 1 && charSequence0.charAt(v1) <= 0x20; ++v1) {
        }
        int v2;
        for(v2 = v - 1; v2 >= v1 && charSequence0.charAt(v2) <= 0x20; --v2) {
        }
        return v1 != 0 || v2 != v - 1 ? charSequence0.subSequence(v1, v2) : charSequence0;
    }

    public AsciiString trim() {
        int v = this.arrayOffset();
        int v1 = this.length() + this.arrayOffset() - 1;
        while(v <= v1 && this.value[v] <= 0x20) {
            ++v;
        }
        int v2;
        for(v2 = v1; v2 >= v && this.value[v2] <= 0x20; --v2) {
        }
        return v != 0 || v2 != v1 ? new AsciiString(this.value, v, v2 - v + 1, false) : this;
    }
}

