package composition;

public class Main {
    public static void main(String[] args) {
        // Audit Logging + Caching wrapped around standard Spring client
        ApiClient client = new AuditLoggingApiClient(new CachingApiClient(new SpringApiClient(new RestTemplate())));
    }
}



