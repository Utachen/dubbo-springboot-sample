package file;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileServiceTest {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {


        try (FileInputStream inputStream = new FileInputStream("D:\\code\\dubbo-springboot-sample\\dubbo-springboot-sample-provider\\src\\main\\resources\\file\\prod.txt"); FileOutputStream fileOutputStream = new FileOutputStream("D:\\code\\dubbo-springboot-sample\\dubbo-springboot-sample-provider\\src\\main\\resources\\file\\output.txt")) {

            FileChannel inChannel = inputStream.getChannel();
            FileChannel outChannel = fileOutputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            while ((inChannel.read(buffer) != -1)) {
                buffer.flip();
                outChannel.write((buffer));
                buffer.clear();
            }
            System.out.println("done!");
        }

    }

}
