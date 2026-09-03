package composition;

import java.lang.System.Logger;

public class AuditLoggingApiClient implements ApiClient {
    private final ApiClient delegate;
    private final Logger log = LoggerFactory.getLogger(AuditLoggingApiClient.class);

    public AuditLoggingApiClient(ApiClient delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> T get(String url, Class<T> responseType) {
        long startTime = System.currentTimeMillis();
        try {
            T result = delegate.get(url, responseType);
            log.info("[HTTP GET SUCCESS] {} - Duration: {}ms", url, System.currentTimeMillis() - startTime);
            return result;
        } catch (Exception e) {
            log.error("[HTTP GET FAILED] {} - Duration {}ms - Error: {}", url, System.currentTimeMillis() - startTime,
                    e.getMessage());
            throw e;
        }
    }

    @Override
    public <T, R> R post(String url, T requestBody, Class<R> responseType) {
        long startTime = System.currentTimeMillis();
        try {
            R result = delegate.post(url, requestBody, responseType);
            log.info("[HTTP POST SUCCESS] {} - Duration: {}ms", url, System.currentTimeMillis() - startTime);
            return result;
        } catch (Exception e) {
            log.error("[HTTP POST FAILED] {} - Duration {}ms - Error: {}", url, System.currentTimeMillis() - startTime,
                    e.getMessage());
            throw e;
        }
    }
}
