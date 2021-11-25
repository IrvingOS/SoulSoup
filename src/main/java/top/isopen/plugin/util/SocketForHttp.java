package top.isopen.plugin.util;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

/**
 * @author TimeChaser
 * @since 2021/11/25 14:38
 */
public class SocketForHttp {

    private final String         host;
    private       Socket         socket;
    private       BufferedReader bufferedReader;
    private       BufferedWriter bufferedWriter;

    public SocketForHttp(String host, int port) {
        this.host = host;
        try {
            this.socket = SSLSocketFactory.getDefault().createSocket(this.host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sentGet(String requestUrlPath) {
        StringBuilder response = new StringBuilder();
        OutputStreamWriter outputStreamWriter = null;
        InputStreamReader inputStreamReader = null;
        try {
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("GET " + requestUrlPath + " HTTP/1.1\r\n");
            bufferedWriter.write("Host: " + this.host + "\r\n");
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources(outputStreamWriter, inputStreamReader);
        }
        return response.toString();
    }

    public String sendPost(String requestUrlPath, String data) {
        StringBuilder response = new StringBuilder();
        OutputStreamWriter outputStreamWriter = null;
        InputStreamReader inputStreamReader = null;
        try {
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("POST " + requestUrlPath + " HTTP/1.1\r\n");
            bufferedWriter.write("Host: " + this.host + "\r\n");
            bufferedWriter.write("Content-Length: " + data.length() + "\r\n");
            bufferedWriter.write("Content-Type:  application/x-www-form-urlencoded\\r\\n");
            bufferedWriter.write("\r\n");
            bufferedWriter.write(data);
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            closeResources(outputStreamWriter, inputStreamReader);
        }
        return response.toString();
    }

    private void closeResources(OutputStreamWriter outputStreamWriter, InputStreamReader inputStreamReader) {
        try {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
