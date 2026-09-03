package composition;

public interface ApiClient {
    <T> T get(String url, Class<T> responseType);

    <T, R> R post(String url, T requestBody, Class<R> responseType);
}
