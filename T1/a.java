package t1;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import we.k;

public abstract class a {
    public static String a(List list0, String s, k k0, int v) {
        if((v & 1) != 0) {
            s = ", ";
        }
        if((v & 0x20) != 0) {
            k0 = null;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("");
        int v1 = list0.size();
        int v3 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            Object object0 = list0.get(v2);
            boolean z = true;
            ++v3;
            if(v3 > 1) {
                stringBuilder0.append(s);
            }
            if(k0 == null) {
                if(object0 != null) {
                    z = object0 instanceof CharSequence;
                }
                if(z) {
                    stringBuilder0.append(((CharSequence)object0));
                }
                else if(object0 instanceof Character) {
                    stringBuilder0.append(((Character)object0).charValue());
                }
                else {
                    stringBuilder0.append(String.valueOf(object0));
                }
            }
            else {
                stringBuilder0.append(((CharSequence)k0.invoke(object0)));
            }
        }
        stringBuilder0.append("");
        return stringBuilder0.toString();
    }

    public static final void b(@NotNull String s) {
        throw new UnsupportedOperationException(s);
    }
}

