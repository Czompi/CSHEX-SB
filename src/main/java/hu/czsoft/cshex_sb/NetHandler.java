package hu.czsoft.cshex_sb;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.stream.Collectors;

public class NetHandler {
    public static String fromStream(InputStream inputStream) {
        return new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    public static String getString(URL url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        return fromStream(getStream(url));
    }

    public static String getString(String url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        return fromStream(getStream(url));
    }

    public static InputStream getStream(String url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        return getStream(new URL(url));
    }
    public static InputStream getStream(URL url) throws IOException, NoSuchAlgorithmException, KeyManagementException {

        // Create a trust manager that does not validate certificate chains
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(final X509Certificate[] chain, final String authType) {
            }

            @Override
            public void checkServerTrusted(final X509Certificate[] chain, final String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, null);
        // Create an ssl socket factory with our all-trusting manager
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier((urlHostName, session) -> true);

        URLConnection connection = url.openConnection();

        return (InputStream) connection.getContent();
    }
}
