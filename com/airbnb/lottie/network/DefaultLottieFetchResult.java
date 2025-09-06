package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import jeb.synthetic.TWR;

public class DefaultLottieFetchResult implements LottieFetchResult {
    private final HttpURLConnection connection;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection0) {
        this.connection = httpURLConnection0;
    }

    @Override  // com.airbnb.lottie.network.LottieFetchResult
    public InputStream bodyByteStream() {
        return this.connection.getInputStream();
    }

    @Override
    public void close() {
        this.connection.disconnect();
    }

    @Override  // com.airbnb.lottie.network.LottieFetchResult
    public String contentType() {
        return this.connection.getContentType();
    }

    @Override  // com.airbnb.lottie.network.LottieFetchResult
    public String error() {
        try {
            return this.isSuccessful() ? null : "Unable to fetch " + this.connection.getURL() + ". Failed with " + this.connection.getResponseCode() + "\n" + this.getErrorFromConnection(this.connection);
        }
        catch(IOException iOException0) {
            Logger.warning("get error failed ", iOException0);
            return iOException0.getMessage();
        }
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection0) {
        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(httpURLConnection0.getErrorStream()));
        StringBuilder stringBuilder0 = new StringBuilder();
        try {
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                stringBuilder0.append(s);
                stringBuilder0.append('\n');
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(bufferedReader0, throwable0);
            throw throwable0;
        }
        try {
            bufferedReader0.close();
        }
        catch(Exception unused_ex) {
        }
        return stringBuilder0.toString();
    }

    @Override  // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() {
        try {
            if(this.connection.getResponseCode() / 100 == 2) {
                return true;
            }
        }
        catch(IOException unused_ex) {
        }
        return false;
    }
}

