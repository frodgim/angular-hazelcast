package infrastructure.caching.contracts;

public interface IApplicationCacheService {

	public <T> void put(String key, T element);
	
	public <T> T get(String key);
	
}
