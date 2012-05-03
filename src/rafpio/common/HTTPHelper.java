package rafpio.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.webkit.URLUtil;

public class HTTPHelper {

    public static InputStream getInputStreamFromHTTPConnection(String url)
            throws IOException {

        final int CONNECTION_TIMEOUT = 10000;
        if (!URLUtil.isValidUrl(url)) {
            throw new MalformedURLException();
        }

        URI uri = URI.create(url);

        HttpGet request = new HttpGet(uri);
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams,
                CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParams, CONNECTION_TIMEOUT);
        request.setParams(httpParams);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(request);
        HttpEntity httpEntitity = response.getEntity();
        
        if(httpEntitity == null){
            throw new IOException();
        }
        return httpEntitity.getContent();
    }

    public static String getStringFromHTTPConnection(String url)
            throws IOException {
        final int CONNECTION_TIMEOUT = 10000;
        if (!URLUtil.isValidUrl(url)) {
            throw new MalformedURLException();
        }

        URI uri = URI.create(url);

        HttpGet request = new HttpGet(uri);
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams,
                CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpParams, CONNECTION_TIMEOUT);
        request.setParams(httpParams);
        HttpResponse response = new DefaultHttpClient().execute(request);
        HttpEntity httpEntitity = response.getEntity();

        if (httpEntitity == null) {
            throw new IOException();
        } else {
            return EntityUtils.toString(httpEntitity);
        }
    }
}
