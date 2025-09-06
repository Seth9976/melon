package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public final class UdpDataSource extends BaseDataSource {
    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException0) {
            super(iOException0);
        }
    }

    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 8000;
    private InetAddress address;
    private MulticastSocket multicastSocket;
    private boolean opened;
    private final DatagramPacket packet;
    private final byte[] packetBuffer;
    private int packetRemaining;
    private DatagramSocket socket;
    private InetSocketAddress socketAddress;
    private final int socketTimeoutMillis;
    private Uri uri;

    public UdpDataSource() {
        this(2000);
    }

    public UdpDataSource(int v) {
        this(v, 8000);
    }

    public UdpDataSource(int v, int v1) {
        super(true);
        this.socketTimeoutMillis = v1;
        byte[] arr_b = new byte[v];
        this.packetBuffer = arr_b;
        this.packet = new DatagramPacket(arr_b, 0, v);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.uri = null;
        MulticastSocket multicastSocket0 = this.multicastSocket;
        if(multicastSocket0 != null) {
            try {
                multicastSocket0.leaveGroup(this.address);
            }
            catch(IOException unused_ex) {
            }
            this.multicastSocket = null;
        }
        DatagramSocket datagramSocket0 = this.socket;
        if(datagramSocket0 != null) {
            datagramSocket0.close();
            this.socket = null;
        }
        this.address = null;
        this.socketAddress = null;
        this.packetRemaining = 0;
        if(this.opened) {
            this.opened = false;
            this.transferEnded();
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        this.uri = dataSpec0.uri;
        String s = dataSpec0.uri.getHost();
        int v = this.uri.getPort();
        this.transferInitializing(dataSpec0);
        try {
            this.address = InetAddress.getByName(s);
            this.socketAddress = new InetSocketAddress(this.address, v);
            if(this.address.isMulticastAddress()) {
                MulticastSocket multicastSocket0 = new MulticastSocket(this.socketAddress);
                this.multicastSocket = multicastSocket0;
                multicastSocket0.joinGroup(this.address);
                this.socket = this.multicastSocket;
            }
            else {
                this.socket = new DatagramSocket(this.socketAddress);
            }
            goto label_16;
        }
        catch(IOException iOException0) {
        }
        throw new UdpDataSourceException(iOException0);
        try {
        label_16:
            this.socket.setSoTimeout(this.socketTimeoutMillis);
        }
        catch(SocketException socketException0) {
            throw new UdpDataSourceException(socketException0);
        }
        this.opened = true;
        this.transferStarted(dataSpec0);
        return -1L;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        if(this.packetRemaining == 0) {
            try {
                this.socket.receive(this.packet);
            }
            catch(IOException iOException0) {
                throw new UdpDataSourceException(iOException0);
            }
            int v2 = this.packet.getLength();
            this.packetRemaining = v2;
            this.bytesTransferred(v2);
        }
        int v3 = this.packet.getLength();
        int v4 = Math.min(this.packetRemaining, v1);
        System.arraycopy(this.packetBuffer, v3 - this.packetRemaining, arr_b, v, v4);
        this.packetRemaining -= v4;
        return v4;
    }
}

