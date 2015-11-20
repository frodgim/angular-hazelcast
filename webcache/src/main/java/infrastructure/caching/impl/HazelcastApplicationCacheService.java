package infrastructure.caching.impl;

import java.util.Collection;
import java.util.Properties;

import com.hazelcast.cache.CacheStatistics;
import com.hazelcast.cache.impl.CacheEventContext;
import com.hazelcast.cache.impl.CacheEventListener;
import com.hazelcast.cache.impl.CacheEventSet;
import com.hazelcast.cache.impl.CacheOperationProvider;
import com.hazelcast.cache.impl.CachePartitionSegment;
import com.hazelcast.cache.impl.CacheStatisticsImpl;
import com.hazelcast.cache.impl.ICacheRecordStore;
import com.hazelcast.cache.impl.ICacheService;
import com.hazelcast.config.CacheConfig;
import com.hazelcast.config.CacheSimpleConfig;
import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.nio.serialization.Data;
import com.hazelcast.spi.EventFilter;
import com.hazelcast.spi.NodeEngine;
import com.hazelcast.spi.Operation;
import com.hazelcast.spi.PartitionMigrationEvent;
import com.hazelcast.spi.PartitionReplicationEvent;

import infrastructure.caching.contracts.IApplicationCacheService;

public class HazelcastApplicationCacheService implements IApplicationCacheService {

	public <T> void put(String key, T element) {
		// TODO Auto-generated method stub
		
	}

	public <T> T get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
