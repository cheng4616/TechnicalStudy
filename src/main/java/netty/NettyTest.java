package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 *
 */
public class NettyTest {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(16);
        for (int i = 0; i < 16; i++) {
            byteBuf.writeByte(i + 1);
        }
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.print(byteBuf.getByte(i));
        }
    }


}
