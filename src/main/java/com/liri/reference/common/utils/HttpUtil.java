package com.liri.reference.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtil {

    private HttpUtil() {

    }

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String doGet(String url, String param, Map<String, String> requestProperty) {
        logger.debug("The begin of the method doGet");

        BufferedReader in = null;
        StringBuilder response = new StringBuilder();

        String urlName = url + "?" + param;

        try {

            URL realUrl = new URL(urlName);

            // 打开连接
            URLConnection connection = realUrl.openConnection();

            // 请求属性
            connection.addRequestProperty("encoding", "UTF-8");// 设置请求编码
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if (CollectionUtil.isNotEmpty(requestProperty)) {
                for (Map.Entry<String, String> entry : requestProperty.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            // 建立实际的连接
            connection.connect();

            // 获取所有响应头字段
            // Map<String, List<String>> map = connection.getHeaderFields();

            // 读取URL输入流来的响应内容
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }

        } catch (Exception e) {
            logger.error("****** doPost error:", e);
        } finally {
            try {
                // 关闭流
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("****** doPost error:", e);
            }
            logger.debug("The end of the method doGet");
        }
        return response.toString();
    }

    public static String doPost(String url, String param, Map<String, String> requestProperty) {

        logger.debug("The begin of the method doPost");

        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder response = new StringBuilder();

        try {

            URL realUrl = new URL(url);

            // 打开连接
            URLConnection connection = realUrl.openConnection();

            // 请求属性
            connection.addRequestProperty("encoding", "UTF-8");// 设置请求编码
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if (CollectionUtil.isNotEmpty(requestProperty)) {
                for (Map.Entry<String, String> entry : requestProperty.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            // 发送POST必须设置项
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 获取URL对象对应的输出流
            out = new PrintWriter(connection.getOutputStream());

            // 输出流中写入请求参数
            out.print(param);

            // 刷新输出缓冲区
            out.flush();

            // 读取URL输入流来的响应内容
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }

        } catch (Exception e) {
            logger.error("****** doPost error:" + url, e);
        } finally {
            try {
                // 关闭输出流与输入流
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("****** doPost error:", e);
            }
            logger.debug("The end of the method doPost");
        }
        return response.toString();
    }

    public static void main(String[] args) {

    }

}
