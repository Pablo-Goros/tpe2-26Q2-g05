package ar.edu.itba.pod.client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    static void main() {
        logger.info("hz-bike-rentals Client Starting ...");

        try {
            GroupConfig groupConfig = new GroupConfig().setName("g0").setPassword("g0-pass");

            ClientNetworkConfig clientNetworkConfig = new ClientNetworkConfig();
            clientNetworkConfig.addAddress("127.0.0.1");

            ClientConfig clientConfig = new ClientConfig().setGroupConfig(groupConfig).setNetworkConfig(clientNetworkConfig);

            HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(clientConfig);
        } finally {
            HazelcastClient.shutdownAll();
        }
    }

}
