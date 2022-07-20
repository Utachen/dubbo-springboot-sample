package file;

import com.example.ProviderApplication;
import com.example.utils.PrettyJsonUtil;
import com.hankcs.hanlp.restful.HanLPClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootTest(classes = ProviderApplication.class)
@RunWith(SpringRunner.class)
public class HanLPClentTest {

    @Test
    public void clientTest() throws IOException {

        String filePath = "D:\\code\\dubbo-springboot-sample\\dubbo-springboot-sample-provider\\src\\main\\resources\\file\\Newspaper2.txt";
        String text = fileReader(filePath);
        String preText = text.substring(0, 1000);
        HanLPClient client = new HanLPClient("https://hanlp.hankcs.com/api", "MTAyOEBiYnMuaGFubHAuY29tOlowTkxOOXgybENTdWo5bEc="); // Replace null with your auth
        //System.out.println(client.parse(text));
        //       System.out.println(client.keyphraseExtraction(text,100));
        Map<String, Double> tempResult = client.keyphraseExtraction(preText, 60);
        Map<String, Double> result = new HashMap<>();

        for (Map.Entry<String, Double> entry : tempResult.entrySet()) {
            if (entry.getKey().length() >= 8) {
                continue;
            }
            result.put(entry.getKey(), entry.getValue());
        }
        System.out.println(PrettyJsonUtil.getPretty(result));


    }




    public String fileReader(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        StringBuilder builder = new StringBuilder();

        try (Scanner scanner = new Scanner(path)) {
            System.out.println("Read text file using Scanner");
            //逐行读取
            while(scanner.hasNextLine()){
                //逐行处理
                String line = scanner.nextLine();
                builder.append(line);
            }
        }
        return builder.toString();

    }

}
