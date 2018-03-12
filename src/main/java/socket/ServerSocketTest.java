package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月10日       TODO
 * </pre>
 */
public class ServerSocketTest {

    /** 服务器监听端口 */
    private static int SERVER_PORT = 8888;

    /** 线程数 */
    private static int THREAD_NUM = 10;

    public static void main(String[] args) {

        try {

            ExecutorService exec = Executors.newFixedThreadPool(THREAD_NUM);

            // 想操作系统注册serverSocket服务
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("serverSocket is started.");

            while (true) {
                // 启动socket监听，如果客户端有请求将其取出
                Socket socket = serverSocket.accept();
                System.out.println("socket detail Ip:" + socket.getInetAddress() + " port:" + socket.getPort());
                exec.execute(new HandlerThread(socket));
            }
        } catch (IOException e) {
            System.out.println("error:" + e);

        }

    }
}
