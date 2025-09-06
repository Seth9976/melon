package a2;

import Gf.l;
import android.text.SpannableStringBuilder;

public final class b {
    public final boolean a;
    public static final String b;
    public static final String c;
    public static final b d;
    public static final b e;

    static {
        b.b = "‎";
        b.c = "\u200F";
        b.d = new b(false);
        b.e = new b(true);
    }

    public b(boolean z) {
        this.a = z;
    }

    public static int a(CharSequence charSequence0) {
        int v5;
        a a0 = new a(charSequence0);
        a0.c = 0;
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        while(true) {
            int v3 = a0.c;
            if(v3 >= a0.b || v != 0) {
                break;
            }
            CharSequence charSequence1 = a0.a;
            char c = charSequence1.charAt(v3);
            a0.d = c;
            if(Character.isHighSurrogate(c)) {
                int v4 = Character.codePointAt(charSequence1, a0.c);
                a0.c = Character.charCount(v4) + a0.c;
                v5 = Character.getDirectionality(v4);
            }
            else {
                ++a0.c;
                int v6 = a0.d;
                v5 = v6 < 0x700 ? a.e[v6] : Character.getDirectionality(((char)v6));
            }
        alab1:
            switch(v5) {
                case 0: {
                label_35:
                    if(v2 == 0) {
                        return -1;
                    }
                    break;
                }
                case 1: {
                label_37:
                    if(v2 == 0) {
                        return 1;
                    }
                    break;
                }
                default: {
                    if(v5 != 2) {
                        if(v5 == 9) {
                            continue;
                        }
                        switch(v5) {
                            case 14: 
                            case 15: {
                                ++v2;
                                v1 = -1;
                                continue;
                            }
                            case 16: 
                            case 17: {
                                ++v2;
                                v1 = 1;
                                continue;
                            }
                            case 18: {
                                --v2;
                                v1 = 0;
                                continue;
                            }
                            default: {
                                break alab1;
                            }
                        }
                        goto label_35;
                    }
                    goto label_37;
                }
            }
            v = v2;
        }
        if(v != 0) {
            if(v1 != 0) {
                return v1;
            }
            while(a0.c > 0) {
                switch(a0.a()) {
                    case 14: 
                    case 15: {
                        if(v == v2) {
                            return -1;
                        }
                        --v2;
                        continue;
                    }
                    case 16: 
                    case 17: {
                        if(v == v2) {
                            return 1;
                        }
                        --v2;
                        continue;
                    }
                    case 18: {
                        break;
                    }
                    default: {
                        continue;
                    }
                }
                ++v2;
            }
        }
        return 0;
    }

    public static int b(CharSequence charSequence0) {
        a a0 = new a(charSequence0);
        a0.c = a0.b;
        int v = 0;
    alab1:
        while(true) {
            int v1 = v;
        label_4:
            if(a0.c <= 0) {
                return 0;
            }
            switch(a0.a()) {
                case 0: {
                    if(v == 0) {
                        return -1;
                    }
                    if(v1 != 0) {
                        goto label_4;
                    }
                    break;
                }
                case 1: 
                case 2: {
                    if(v == 0) {
                        return 1;
                    }
                    if(v1 != 0) {
                        goto label_4;
                    }
                    break;
                }
                case 9: {
                    goto label_4;
                }
                case 14: 
                case 15: {
                    break alab1;
                }
                case 16: 
                case 17: {
                    goto label_19;
                }
                case 18: {
                    ++v;
                    goto label_4;
                }
                default: {
                    if(v1 != 0) {
                        goto label_4;
                    }
                }
            }
        }
        if(v1 == v) {
            return -1;
        }
        --v;
        goto label_4;
    label_19:
        if(v1 != v) {
            --v;
            goto label_4;
        }
        return 1;
    }

    public final SpannableStringBuilder c(CharSequence charSequence0) {
        String s1;
        l l0 = f.c;
        if(charSequence0 == null) {
            return null;
        }
        boolean z = l0.f(charSequence0, charSequence0.length());
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder();
        boolean z1 = (z ? f.b : f.a).f(charSequence0, charSequence0.length());
        String s = "";
        boolean z2 = this.a;
        if(z2 || !z1 && b.a(charSequence0) != 1) {
            s1 = !z2 || z1 && b.a(charSequence0) != -1 ? "" : "\u200F";
        }
        else {
            s1 = "‎";
        }
        spannableStringBuilder0.append(s1);
        if(z == z2) {
            spannableStringBuilder0.append(charSequence0);
        }
        else {
            spannableStringBuilder0.append(((char)(z ? 0x202B : 0x202A)));
            spannableStringBuilder0.append(charSequence0);
            spannableStringBuilder0.append('‬');
        }
        boolean z3 = (z ? f.b : f.a).f(charSequence0, charSequence0.length());
        if(!z2 && (z3 || b.b(charSequence0) == 1)) {
            s = "‎";
        }
        else if(z2 && (!z3 || b.b(charSequence0) == -1)) {
            s = "\u200F";
        }
        spannableStringBuilder0.append(s);
        return spannableStringBuilder0;
    }
}

