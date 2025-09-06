package Ae;

import Q0.Z;
import Q6.a;
import android.os.Looper;
import android.view.Choreographer;
import h7.u0;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;
import javax.crypto.Cipher;

public final class b extends ThreadLocal {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override
    public final Object initialValue() {
        SecureRandom secureRandom0;
        Provider provider1;
        Provider provider0;
        switch(this.a) {
            case 0: {
                return new Random();
            }
            case 1: {
                try {
                    return (Cipher)R6.b.b.a.a();
                }
                catch(GeneralSecurityException generalSecurityException0) {
                    throw new IllegalStateException(generalSecurityException0);
                }
            }
            case 2: {
                Choreographer choreographer0 = Choreographer.getInstance();
                Looper looper0 = Looper.myLooper();
                if(looper0 == null) {
                    throw new IllegalStateException("no Looper on this thread");
                }
                Z z0 = new Z(choreographer0, u0.s(looper0));
                return z0.plus(z0.k);
            }
            default: {
                for(int v = 0; true; ++v) {
                    provider0 = null;
                    provider1 = null;
                    if(v >= 3) {
                        break;
                    }
                    Provider provider2 = Security.getProvider(a.a[v]);
                    if(provider2 != null) {
                        provider0 = provider2;
                        break;
                    }
                }
                if(provider0 == null) {
                    try {
                    label_15:
                        provider1 = (Provider)Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", null).invoke(null, null);
                    }
                    catch(ClassNotFoundException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | IllegalAccessException unused_ex) {
                    }
                    if(provider1 == null) {
                        secureRandom0 = new SecureRandom();
                    }
                    else {
                        try {
                            secureRandom0 = SecureRandom.getInstance("SHA1PRNG", provider1);
                            goto label_20;
                        }
                        catch(GeneralSecurityException unused_ex) {
                        }
                        secureRandom0 = new SecureRandom();
                        secureRandom0.nextLong();
                        return secureRandom0;
                    }
                }
                else {
                    try {
                        secureRandom0 = SecureRandom.getInstance("SHA1PRNG", provider0);
                        goto label_20;
                    }
                    catch(GeneralSecurityException unused_ex) {
                    }
                    goto label_15;
                }
            label_20:
                secureRandom0.nextLong();
                return secureRandom0;
            }
        }
    }
}

