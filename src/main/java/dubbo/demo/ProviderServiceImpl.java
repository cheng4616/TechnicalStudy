package dubbo.demo;

public class ProviderServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello," + name;
    }
}
