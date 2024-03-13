package org.example;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();
    public void downloadStatusImage(int code) {
        try {
            URL url = new URL(checker.getStatusImage(code));

            try (InputStream in = url.openStream();
                 OutputStream out = new FileOutputStream(code + ".jpg")) {
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Download failed fo status code:" + code);
        }
    }
}
