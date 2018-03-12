package dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderServer {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring-dubbo-provider.xml"});
        ac.start();
        System.in.read();
    }
}
