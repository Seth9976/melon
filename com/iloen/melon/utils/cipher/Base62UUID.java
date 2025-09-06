package com.iloen.melon.utils.cipher;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/utils/cipher/Base62UUID;", "", "", "randomUUID", "()Ljava/lang/String;", "Ljava/util/UUID;", "uuid", "encode", "(Ljava/util/UUID;)Ljava/lang/String;", "Ljava/math/BigInteger;", "hi", "lo", "pair", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/math/BigInteger;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class Base62UUID {
    public static final int $stable;
    @NotNull
    public static final Base62UUID INSTANCE;
    public static final BigInteger a;
    public static final BigInteger b;

    static {
        Base62UUID.INSTANCE = new Base62UUID();  // 初始化器: Ljava/lang/Object;-><init>()V
        Base62UUID.a = BigInteger.ONE.shiftLeft(0x40);
        Base62UUID.b = BigInteger.valueOf(62L);
        Base62UUID.$stable = 8;
    }

    @NotNull
    public final String encode(@NotNull UUID uUID0) {
        q.g(uUID0, "uuid");
        BigInteger bigInteger0 = BigInteger.valueOf(uUID0.getMostSignificantBits());
        q.f(bigInteger0, "valueOf(...)");
        BigInteger bigInteger1 = BigInteger.valueOf(uUID0.getLeastSignificantBits());
        q.f(bigInteger1, "valueOf(...)");
        BigInteger bigInteger2 = this.pair(bigInteger0, bigInteger1);
        if(bigInteger2.compareTo(BigInteger.ZERO) >= 0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            while(bigInteger2.compareTo(BigInteger.ZERO) > 0) {
                BigInteger[] arr_bigInteger = bigInteger2.divideAndRemainder(Base62UUID.b);
                BigInteger bigInteger3 = arr_bigInteger[0];
                q.f(bigInteger3, "get(...)");
                stringBuilder0.insert(0, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(arr_bigInteger[1].intValue()));
                bigInteger2 = bigInteger3;
            }
            if(stringBuilder0.length() == 0) {
                return "0";
            }
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            return s;
        }
        Arrays.copyOf(new Object[0], 0);
        throw new IllegalArgumentException("number must not be negative");
    }

    @NotNull
    public final BigInteger pair(@NotNull BigInteger bigInteger0, @NotNull BigInteger bigInteger1) {
        q.g(bigInteger0, "hi");
        q.g(bigInteger1, "lo");
        int v = bigInteger1.signum();
        BigInteger bigInteger2 = Base62UUID.a;
        if(v < 0) {
            bigInteger1 = bigInteger1.add(bigInteger2);
        }
        if(bigInteger0.signum() < 0) {
            bigInteger0 = bigInteger0.add(bigInteger2);
        }
        BigInteger bigInteger3 = bigInteger1.add(bigInteger0.multiply(bigInteger2));
        q.f(bigInteger3, "add(...)");
        return bigInteger3;
    }

    @NotNull
    public static final String randomUUID() {
        UUID uUID0 = UUID.randomUUID();
        q.f(uUID0, "randomUUID(...)");
        return Base62UUID.INSTANCE.encode(uUID0);
    }
}

