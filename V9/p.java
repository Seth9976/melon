package v9;

import android.text.TextUtils;
import com.iloen.melon.utils.Predicate;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import va.e0;
import va.o;

public final class p implements Predicate {
    public final int a;

    public p(int v) {
        this.a = v;
        super();
    }

    @Override  // com.iloen.melon.utils.Predicate
    public final boolean test(Object object0) {
        switch(this.a) {
            case 0: {
                return "-1".equals(((String)object0));
            }
            case 1: {
                return "-2".equals(((String)object0));
            }
            case 2: {
                return "-3".equals(((String)object0));
            }
            case 3: {
                return !TextUtils.isEmpty(((String)object0)) && TextUtils.isDigitsOnly(((String)object0));
            }
            case 4: {
                return TextUtils.isEmpty(((String)object0));
            }
            case 5: {
                return "2727".equals(((String)object0));
            }
            case 6: {
                return !TextUtils.isEmpty(((String)object0)) && TextUtils.isDigitsOnly(((String)object0)) && !"2727".equals(((String)object0));
            }
            case 7: {
                String s1 = (String)object0;
                try {
                    if(Integer.parseInt(s1) <= -100000 && !u.v(((e0)o.a()).j()).equals(s1)) {
                        return true;
                    }
                }
                catch(Exception unused_ex) {
                    LogU.w("StringIds", "invalid userId: " + s1);
                }
                return false;
            }
            case 8: {
                String s2 = (String)object0;
                try {
                    if(Integer.parseInt(s2) > 0 && !u.v(((e0)o.a()).j()).equals(s2)) {
                        return true;
                    }
                }
                catch(Exception unused_ex) {
                    LogU.w("StringIds", "invalid userId: " + s2);
                }
                return false;
            }
            default: {
                String s = (String)object0;
                try {
                    if(Integer.parseInt(s) > 0 && u.v(((e0)o.a()).j()).equals(s)) {
                        return true;
                    }
                }
                catch(Exception unused_ex) {
                    LogU.w("StringIds", "invalid userId: " + s);
                }
                return false;
            }
        }
    }
}

