
package com.kafka.admin.topicfactory;

import java.util.Properties;



public interface TopicFactory {


  int createTopicIfNotExist(String zkUrl, String topic, int replicationFactor, double partitionToBrokerRatio, Properties topicProperties);

}
