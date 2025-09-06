package Tf;

import kotlin.jvm.internal.q;

public abstract class u extends t {
    public static final boolean e0(String s) {
        String s1;
        boolean z3;
        boolean z2;
        boolean z1;
        int v = s.length() - 1;
        int v1;
        for(v1 = 0; v1 <= v && s.charAt(v1) <= 0x20; ++v1) {
        }
        if(v1 > v) {
            return false;
        }
        while(v > v1 && s.charAt(v) <= 0x20) {
            --v;
        }
        if(s.charAt(v1) == 43 || s.charAt(v1) == 45) {
            ++v1;
        }
        if(v1 > v) {
            return false;
        }
        if(s.charAt(v1) == 0x30) {
            if(v1 + 1 > v) {
                return true;
            }
            if((s.charAt(v1 + 1) | 0x20) == 120) {
                int v2;
                for(v2 = v1 + 2; v2 <= v; ++v2) {
                    int v3 = s.charAt(v2);
                    if((v3 - 0x30 & 0xFFFF) >= 10 && ((v3 | 0x20) - 97 & 0xFFFF) >= 6) {
                        break;
                    }
                }
                boolean z = v1 + 2 != v2;
                if(v2 <= v) {
                    if(s.charAt(v2) == 46) {
                        int v4;
                        for(v4 = v2 + 1; v4 <= v; ++v4) {
                            int v5 = s.charAt(v4);
                            if((v5 - 0x30 & 0xFFFF) >= 10 && ((v5 | 0x20) - 97 & 0xFFFF) >= 6) {
                                break;
                            }
                        }
                        z1 = v2 + 1 != v4;
                        v2 = v4;
                    }
                    else {
                        z1 = false;
                    }
                    v1 = !z && !z1 ? -1 : v2;
                }
                else {
                    v1 = -1;
                }
                if(v1 != -1 && v1 <= v) {
                    z2 = true;
                    goto label_50;
                }
                return false;
            }
            else {
                z2 = false;
            }
        }
        else {
            z2 = false;
        }
    label_50:
        if(!z2) {
            int v6;
            for(v6 = v1; v6 <= v && (s.charAt(v6) - 0x30 & 0xFFFF) < 10; ++v6) {
            }
            if(v6 > v) {
                v1 = v6;
            }
            else {
                if(s.charAt(v6) == 46) {
                    int v7;
                    for(v7 = v6 + 1; v7 <= v && (s.charAt(v7) - 0x30 & 0xFFFF) < 10; ++v7) {
                    }
                    z3 = v6 + 1 == v7 ? false : true;
                }
                else {
                    v7 = v6;
                    z3 = false;
                }
                if(v1 != v6 || z3) {
                    v1 = v7;
                }
                else {
                    if(v == v7 + 2) {
                        s1 = "NaN";
                    }
                    else {
                        s1 = v == v7 + 7 ? "Infinity" : null;
                    }
                    if(s1 == null) {
                        v1 = -1;
                    }
                    else if(o.C0(s, s1, v7, false) == v7) {
                        v1 = v + 1;
                    }
                    else {
                        v1 = -1;
                    }
                }
            }
            if(v1 == -1) {
                return false;
            }
            if(v1 > v) {
                return true;
            }
        }
        int v8 = v1 + 1;
        int v9 = s.charAt(v1);
        if((v9 | 0x20) != (z2 ? 0x70 : 101)) {
            return !z2 && ((v9 | 0x20) == 100 || (v9 | 0x20) == 102) && v8 > v;
        }
        if(v8 > v) {
            return false;
        }
        if(s.charAt(v8) == 43 || s.charAt(v8) == 45) {
            v8 = v1 + 2;
            if(v8 > v) {
                return false;
            }
        }
        while(v8 <= v && (s.charAt(v8) - 0x30 & 0xFFFF) < 10) {
            ++v8;
        }
        return v8 <= v ? v8 == v && ((s.charAt(v8) | 0x20) == 100 || (s.charAt(v8) | 0x20) == 102) : true;
    }

    public static Double f0(String s) {
        q.g(s, "<this>");
        try {
            return u.e0(s) ? Double.parseDouble(s) : null;
        }
        catch(NumberFormatException unused_ex) {
        }
        return null;
    }

    public static Float g0(String s) {
        q.g(s, "<this>");
        try {
            return u.e0(s) ? Float.parseFloat(s) : null;
        }
        catch(NumberFormatException unused_ex) {
        }
        return null;
    }
}

