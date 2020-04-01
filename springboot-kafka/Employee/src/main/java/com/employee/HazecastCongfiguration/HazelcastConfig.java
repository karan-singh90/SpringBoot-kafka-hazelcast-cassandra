package com.employee.HazecastCongfiguration;


import com.hazelcast.config.*;
import com.hazelcast.core.MapStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {
    @Autowired
    EmployeeMapstore mapstore;
    @Bean
    Config hazelCastConfig(){
        MapStoreConfig mapStoreConfig=new MapStoreConfig().setImplementation(mapstore)
                .setWriteDelaySeconds(10) //Write Through 0(Synchronous) sec..apart from that write behind (Asynchronous)
                .setInitialLoadMode(MapStoreConfig.InitialLoadMode.LAZY);

        MapConfig mapConfig= new MapConfig()
                .setName("employeescache")
                .setMaxSizeConfig(new MaxSizeConfig(300, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                .setEvictionPolicy(EvictionPolicy.LRU)
                .setTimeToLiveSeconds(200)
                .setMapStoreConfig(mapStoreConfig);

        Config config=new Config().setInstanceName("hazelcast-instance")
                .addMapConfig(mapConfig);

        return config;
    }

}
