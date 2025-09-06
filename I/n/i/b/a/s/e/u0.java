package i.n.i.b.a.s.e;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.security.crypto.MasterKey;
import java.io.File;
import java.io.IOException;

public final class U0 implements E1 {
    public final Context a;
    public final String b;
    public final MasterKey c;
    public boolean d;
    public static Boolean e;

    public U0(Context context0, Object object0, String s) {
        this.d = true;
        this.a = context0;
        this.b = s;
        this.c = (MasterKey)object0;
    }

    @Override  // i.n.i.b.a.s.e.E1
    public final D0 a() {
        return new V0(this.a, this.c);
    }

    @Override  // i.n.i.b.a.s.e.E1
    public final boolean b(W2 w20) {
        String s = w20.b.getPath();
        if(L7.F(w20.b) && s != null) {
            try {
                File file0 = new File(Uri.parse(this.b).getPath()).getCanonicalFile();
                File file1 = new File(s).getCanonicalFile();
                if(file0.exists() && file0.isDirectory()) {
                    while(true) {
                        file1 = file1.getParentFile();
                        if(file1 == null) {
                            break;
                        }
                        if(file0.equals(file1)) {
                            goto label_8;
                        }
                    }
                }
            }
            catch(IOException unused_ex) {
            }
            return false;
        label_8:
            synchronized(U0.class) {
                if(U0.e == null) {
                    try {
                        Class.forName("androidx.security.crypto.EncryptedFile");
                        U0.e = Boolean.TRUE;
                    }
                    catch(ClassNotFoundException unused_ex) {
                        U0.e = Boolean.FALSE;
                    }
                }
                boolean z = U0.e.booleanValue();
            }
            if(z) {
                return true;
            }
            if(!this.d) {
                return false;
            }
            this.d = false;
            Log.w("EncryptedFileDataSource", "Error while loading EncryptedFile. Please check dependency to androidx.security.crypto.EncryptedFile.");
            return false;
        }
        try {
        }
        catch(IOException unused_ex) {
        }
        return false;
    }
}

