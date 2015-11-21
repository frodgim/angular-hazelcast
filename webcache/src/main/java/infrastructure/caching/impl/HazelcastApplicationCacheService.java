package infrastructure.caching.impl;

import org.springframework.stereotype.Component;

import infrastructure.caching.contracts.IApplicationCacheService;

@Component
public class HazelcastApplicationCacheService implements IApplicationCacheService {

	public <T> void put(String key, T element) {
		// TODO Auto-generated method stub
		
	}

	public <T> T get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
