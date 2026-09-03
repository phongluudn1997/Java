package composition;

public class SpringApiClient implements ApiClient {
    private final RestTemplate restTemplate;

    public SpringApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> T get(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }

    @Override
    public <T, R> R post(String url, T requestBody, Class<R> responseType) {
        return restTemplate.postForObject(url, requestBody, responseType);
    }

}
