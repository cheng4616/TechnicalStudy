package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月10日       TODO
 * </pre>
 */
public class HandlerThread implements Runnable {

    private Socket socket;

    HandlerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 得到一个输入流，获取客户端传递的信息
            InputStream input = socket.getInputStream();
            // 提高效率，将其转换为字符流
            InputStreamReader inputReader = new InputStreamReader(input);

            BufferedReader bufferedReader = new BufferedReader(inputReader);

            String temp = null;
            String info = "";
            while ((temp = bufferedReader.readLine()) != null) {
                info += temp;
                System.out.println("accept client request.");
                System.out.println("The Info:" + info + " client Ip:" + socket.getInetAddress());
            }
            // 关闭socket的输入流
            socket.shutdownInput();

            // 创建一个输出流，想客户端发送信息
            OutputStream output = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(output);
            StringBuilder str = new StringBuilder("server has received the info. The info is ");
            str.append(info);
            printWriter.print(str.toString());
            printWriter.flush();
            // 关闭socket的输出流
            socket.shutdownOutput();

            // 按顺序关闭I/O流
            printWriter.close();
            output.close();
            bufferedReader.close();
            inputReader.close();
            input.close();

            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
