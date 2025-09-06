package com.kakaoent.trevi.ad.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.net.NetworkRequest;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Global;
import com.kakaoent.trevi.ad.exception.TreviAdAirPlaneModeNetworkException;
import com.kakaoent.trevi.ad.exception.TreviAdException;
import com.kakaoent.trevi.ad.exception.TreviAdNotFoundNetworkException;
import java.util.ArrayList;
import java.util.Iterator;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u00017\b\u00C0\u0002\u0018\u00002\u00020\u0001:\u0001;B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\r\u0010\u0003J\u001B\u0010\u000E\u001A\u00020\t2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000BJ\u0019\u0010\u0011\u001A\u00020\t2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u001F\u0010\u000BR\u0014\u0010!\u001A\u00020 8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b!\u0010\"R\u001A\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00010#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001A\u0004\u0018\u00010\u001C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\u0016\u0010)\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010*R$\u0010,\u001A\u00020\t2\u0006\u0010+\u001A\u00020\t8\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b,\u0010.R\u0016\u0010/\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00101\u001A\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0019\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0019\u00103R\u0014\u00105\u001A\u0002048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001A\u0002078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b8\u00109R\u0011\u0010:\u001A\u00020\t8F\u00A2\u0006\u0006\u001A\u0004\b:\u0010.\u00A8\u0006<"}, d2 = {"Lcom/kakaoent/trevi/ad/util/NetworkManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/kakaoent/trevi/ad/exception/TreviAdException;", "checkConnect", "(Landroid/content/Context;)Lcom/kakaoent/trevi/ad/exception/TreviAdException;", "", "isWifiConnected", "(Landroid/content/Context;)Z", "Lie/H;", "updateNetworkState", "checkNetworkConnect", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "checkNetworkCapabilities", "(Landroid/net/NetworkCapabilities;)Z", "Landroid/net/Network;", "network", "checkNetwork", "(Landroid/net/Network;)V", "Lcom/kakaoent/trevi/ad/util/NetworkManager$State;", "preNetworkState", "networkState", "deliverNetworkState", "(Lcom/kakaoent/trevi/ad/util/NetworkManager$State;Lcom/kakaoent/trevi/ad/util/NetworkManager$State;)V", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "(Landroid/content/Context;)Landroid/net/ConnectivityManager;", "isAirplaneModeOn", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/ArrayList;", "listeners", "Ljava/util/ArrayList;", "connectivityManager", "Landroid/net/ConnectivityManager;", "", "wifiNetId", "I", "<set-?>", "isWifi", "Z", "()Z", "isNetworkConnected", "", "networkCapabilitiesString", "Ljava/lang/String;", "Lcom/kakaoent/trevi/ad/util/NetworkManager$State;", "Landroid/net/NetworkRequest;", "networkRequest", "Landroid/net/NetworkRequest;", "com/kakaoent/trevi/ad/util/NetworkManager$networkCallback$1", "networkCallback", "Lcom/kakaoent/trevi/ad/util/NetworkManager$networkCallback$1;", "isConnected", "State", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class NetworkManager {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/kakaoent/trevi/ad/util/NetworkManager$State;", "", "(Ljava/lang/String;I)V", "DISCONNECTED", "CONNECTED", "CONNECTED_WIFI", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static enum State {
        DISCONNECTED,
        CONNECTED,
        CONNECTED_WIFI;

        private static final a $ENTRIES;
        private static final State[] $VALUES;

        private static final State[] $values() [...] // Inlined contents

        static {
            State.$VALUES = arr_networkManager$State;
            q.g(arr_networkManager$State, "entries");
            State.$ENTRIES = new b(arr_networkManager$State);
        }
    }

    @NotNull
    public static final NetworkManager INSTANCE;
    @Nullable
    private static ConnectivityManager connectivityManager;
    @NotNull
    private static final Handler handler;
    private static boolean isNetworkConnected;
    private static boolean isWifi;
    @NotNull
    private static final ArrayList listeners;
    @NotNull
    private static final NetworkManager.networkCallback.1 networkCallback;
    @Nullable
    private static String networkCapabilitiesString;
    @NotNull
    private static final NetworkRequest networkRequest;
    @NotNull
    private static State networkState;
    private static int wifiNetId;

    static {
        NetworkManager.INSTANCE = new NetworkManager();
        NetworkManager.handler = new Handler(Looper.getMainLooper());
        NetworkManager.listeners = new ArrayList();
        NetworkManager.isNetworkConnected = true;
        NetworkManager.networkState = State.CONNECTED;
        NetworkRequest networkRequest0 = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
        q.f(networkRequest0, "build(...)");
        NetworkManager.networkRequest = networkRequest0;
        NetworkManager.networkCallback = new NetworkManager.networkCallback.1();
    }

    public static final void access$checkNetwork(NetworkManager networkManager0, Network network0) {
        networkManager0.checkNetwork(network0);
    }

    public static final void access$deliverNetworkState(NetworkManager networkManager0, State networkManager$State0, State networkManager$State1) {
        networkManager0.deliverNetworkState(networkManager$State0, networkManager$State1);
    }

    public static final State access$getNetworkState$p() {
        return NetworkManager.networkState;
    }

    public static final int access$getWifiNetId$p() [...] // 潜在的解密器

    public static final boolean access$isNetworkConnected$p() [...] // 潜在的解密器

    public static final void access$setWifi$p(boolean z) {
        NetworkManager.isWifi = z;
    }

    public static final void access$updateNetworkState(NetworkManager networkManager0) {
        networkManager0.updateNetworkState();
    }

    @Nullable
    public final TreviAdException checkConnect(@NotNull Context context0) {
        q.g(context0, "context");
        if(!this.isConnected()) {
            return this.isAirplaneModeOn(context0) ? new TreviAdAirPlaneModeNetworkException(null, 1, null) : new TreviAdNotFoundNetworkException(NetworkManager.networkCapabilitiesString);
        }
        return null;
    }

    private final void checkNetwork(Network network0) {
        ConnectivityManager connectivityManager0 = NetworkManager.connectivityManager;
        if(connectivityManager0 != null) {
            NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(network0);
            if(networkCapabilities0 != null) {
                if(networkCapabilities0.hasTransport(1)) {
                    boolean z = NetworkManager.INSTANCE.checkNetworkCapabilities(networkCapabilities0);
                    NetworkManager.isWifi = z;
                    if(z) {
                        NetworkManager.isNetworkConnected = true;
                        NetworkManager.wifiNetId = network0.hashCode();
                    }
                }
                NetworkManager.checkNetworkConnect$default(NetworkManager.INSTANCE, null, 1, null);
                TreviLog.INSTANCE.i("NetworkManager", "checkNetwork " + false + '(' + 0 + ") / " + false + "  >>" + networkCapabilities0);
            }
        }
    }

    private final boolean checkNetworkCapabilities(NetworkCapabilities networkCapabilities0) {
        return networkCapabilities0 == null ? false : networkCapabilities0.hasCapability(12);
    }

    private final boolean checkNetworkConnect(Context context0) {
        boolean z;
        if(context0 == null) {
            context0 = AppContextHolder.INSTANCE.getContext();
        }
        ConnectivityManager connectivityManager0 = this.getConnectivityManager(context0);
        if(connectivityManager0 == null) {
            z = false;
        }
        else {
            Network network0 = null;
            z = true;
            if(Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(connectivityManager0.getActiveNetwork());
                if(!NetworkManager.INSTANCE.checkNetworkCapabilities(networkCapabilities0)) {
                    Network[] arr_network = connectivityManager0.getAllNetworks();
                    q.f(arr_network, "getAllNetworks(...)");
                    for(int v1 = 0; v1 < arr_network.length; ++v1) {
                        Network network1 = arr_network[v1];
                        NetworkCapabilities networkCapabilities1 = connectivityManager0.getNetworkCapabilities(network1);
                        if(NetworkManager.INSTANCE.checkNetworkCapabilities(networkCapabilities1)) {
                            network0 = network1;
                            break;
                        }
                    }
                    if(network0 == null) {
                        z = false;
                    }
                }
            }
            else {
                Network[] arr_network1 = connectivityManager0.getAllNetworks();
                q.f(arr_network1, "getAllNetworks(...)");
                int v2 = 0;
                while(v2 < arr_network1.length) {
                    Network network2 = arr_network1[v2];
                    NetworkInfo networkInfo0 = connectivityManager0.getNetworkInfo(network2);
                    if(networkInfo0 == null || !networkInfo0.isConnectedOrConnecting()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager0.getNetworkCapabilities(network2);
                        if(!NetworkManager.INSTANCE.checkNetworkCapabilities(networkCapabilities2)) {
                            ++v2;
                            continue;
                        }
                    }
                    network0 = network2;
                    if(true) {
                        break;
                    }
                }
                if(network0 == null) {
                    z = false;
                }
            }
        }
        NetworkManager.isNetworkConnected = z;
        if(!z) {
            StringBuilder stringBuilder0 = new StringBuilder();
            ConnectivityManager connectivityManager1 = NetworkManager.connectivityManager;
            if(connectivityManager1 != null) {
                Network[] arr_network2 = connectivityManager1.getAllNetworks();
                q.f(arr_network2, "getAllNetworks(...)");
                for(int v = 0; v < arr_network2.length; ++v) {
                    Network network3 = arr_network2[v];
                    stringBuilder0.append(connectivityManager1.getNetworkInfo(network3));
                    stringBuilder0.append('\n');
                    stringBuilder0.append(connectivityManager1.getNetworkCapabilities(network3));
                    stringBuilder0.append('\n');
                }
                stringBuilder0.append("activeNetwork=" + connectivityManager1.getNetworkCapabilities(connectivityManager1.getActiveNetwork()));
                stringBuilder0.append('\n');
            }
            stringBuilder0.append("isWifi=" + false);
            stringBuilder0.append('\n');
            stringBuilder0.append("isNetworkConnected=" + false);
            stringBuilder0.append('\n');
            NetworkManager.networkCapabilitiesString = stringBuilder0.toString();
        }
        TreviLog.INSTANCE.i("NetworkManager", "checkNetworkConnect(" + z + ')');
        return z;
    }

    public static boolean checkNetworkConnect$default(NetworkManager networkManager0, Context context0, int v, Object object0) {
        if((v & 1) != 0) {
            context0 = null;
        }
        return networkManager0.checkNetworkConnect(context0);
    }

    private final void deliverNetworkState(State networkManager$State0, State networkManager$State1) {
        boolean z = false;
        boolean z1 = networkManager$State0 == State.DISCONNECTED && networkManager$State1 != State.DISCONNECTED || networkManager$State0 != State.DISCONNECTED && networkManager$State1 == State.DISCONNECTED;
        if(networkManager$State0 == State.CONNECTED_WIFI && networkManager$State1 != State.CONNECTED_WIFI || networkManager$State0 != State.CONNECTED_WIFI && networkManager$State1 == State.CONNECTED_WIFI) {
            z = true;
        }
        StringBuilder stringBuilder0 = Y.q("deliverNetworkState  >> ", " / ", z1, " / ", z);
        stringBuilder0.append(networkManager$State1);
        TreviLog.INSTANCE.e("NetworkManager", stringBuilder0.toString());
        if(z1) {
            A5.a a0 = new A5.a(6);
            NetworkManager.handler.post(a0);
        }
        if(z) {
            A5.a a1 = new A5.a(7);
            NetworkManager.handler.post(a1);
        }
    }

    private static final void deliverNetworkState$lambda$14() {
        Object object0 = NetworkManager.listeners.clone();
        q.e(object0, "null cannot be cast to non-null type java.util.ArrayList<com.kakaoent.trevi.ad.util.NetworkManager.NetworkListener>");
        Iterator iterator0 = ((ArrayList)object0).iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
    }

    private static final void deliverNetworkState$lambda$15() {
        Object object0 = NetworkManager.listeners.clone();
        q.e(object0, "null cannot be cast to non-null type java.util.ArrayList<com.kakaoent.trevi.ad.util.NetworkManager.NetworkListener>");
        Iterator iterator0 = ((ArrayList)object0).iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
    }

    private final ConnectivityManager getConnectivityManager(Context context0) {
        Object object0 = context0.getSystemService("connectivity");
        return object0 instanceof ConnectivityManager ? ((ConnectivityManager)object0) : null;
    }

    private final boolean isAirplaneModeOn(Context context0) {
        return Settings.Global.getInt(context0.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public final boolean isConnected() {
        return NetworkManager.checkNetworkConnect$default(this, null, 1, null);
    }

    public final boolean isWifi() [...] // 潜在的解密器

    public final boolean isWifiConnected(@NotNull Context context0) {
        q.g(context0, "context");
        Object object0 = context0.getSystemService("connectivity");
        q.e(object0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        Network[] arr_network = ((ConnectivityManager)object0).getAllNetworks();
        q.f(arr_network, "getAllNetworks(...)");
        for(int v = 0; v < arr_network.length; ++v) {
            NetworkCapabilities networkCapabilities0 = ((ConnectivityManager)object0).getNetworkCapabilities(arr_network[v]);
            if(networkCapabilities0 != null && networkCapabilities0.hasTransport(1)) {
                return true;
            }
        }
        return false;
    }

    private final void updateNetworkState() {
        NetworkManager.networkState = State.DISCONNECTED;
    }
}

