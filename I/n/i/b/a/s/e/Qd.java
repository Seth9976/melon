package i.n.i.b.a.s.e;

import java.util.Comparator;
import org.chromium.net.CronetProvider;

public final class qd implements Comparator {
    public final String a;

    public qd() {
        String s = null;
        try {
            s = (String)Class.forName("com.google.android.gms.net.CronetProviderInstaller").getDeclaredField("PROVIDER_NAME").get(null);
        }
        catch(ClassNotFoundException | NoSuchFieldException | IllegalAccessException unused_ex) {
        }
        this.a = s;
    }

    public final int a(CronetProvider cronetProvider0, CronetProvider cronetProvider1) {
        int v1;
        String s = cronetProvider0.getName();
        int v = 2;
        String s1 = this.a;
        if("App-Packaged-Cronet-Provider".equals(s)) {
            v1 = 1;
        }
        else {
            v1 = s1 == null || !s1.equals(s) ? -1 : 2;
        }
        String s2 = cronetProvider1.getName();
        if("App-Packaged-Cronet-Provider".equals(s2)) {
            v = 1;
        }
        else if(s1 == null || !s1.equals(s2)) {
            v = -1;
        }
        if(v1 != v) {
            return v1 - v;
        }
        String s3 = cronetProvider0.getVersion();
        String s4 = cronetProvider1.getVersion();
        if(s3 != null && s4 != null) {
            String[] arr_s = s3.split("\\.", -1);
            String[] arr_s1 = s4.split("\\.", -1);
            int v2 = Math.min(arr_s.length, arr_s1.length);
            for(int v3 = 0; v3 < v2; ++v3) {
                if(!arr_s[v3].equals(arr_s1[v3])) {
                    try {
                        return -(Integer.parseInt(arr_s[v3]) - Integer.parseInt(arr_s1[v3]));
                    }
                    catch(NumberFormatException unused_ex) {
                    }
                    break;
                }
            }
        }
        return 0;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        return this.a(((CronetProvider)object0), ((CronetProvider)object1));
    }
}

