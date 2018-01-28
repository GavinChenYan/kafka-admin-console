
package com.kafka.admin.services.config;


import com.kafka.admin.consumer.MessageConsumer;
import com.networknt.config.Config;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class ConsumeServiceConfig extends AbstractConfig {

  private static final ConfigDef CONFIG;

  static String COMMON_CONFIG_NAME = "common";
  static CommonConfig commonConfig = (CommonConfig) Config.getInstance().getJsonObjectConfig(COMMON_CONFIG_NAME, CommonConfig.class);


  static {
    CONFIG = new ConfigDef().define(commonConfig.getZookeeperConnect(),
                                    ConfigDef.Type.STRING,
                                    ConfigDef.Importance.HIGH,
                                    commonConfig.getZookeeperConnectDoc())
                            .define(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,
                                    ConfigDef.Type.STRING,
                                    ConfigDef.Importance.HIGH,
                                    CommonClientConfigs.BOOTSTRAP_SERVERS_DOC)
                            .define(commonConfig.getTopicConfig(),
                                    ConfigDef.Type.STRING,
                                    ConfigDef.Importance.HIGH,
                                    commonConfig.getTopicDoc())
                            .define(commonConfig.getConsumerClassConfig(),
                                    ConfigDef.Type.STRING,
                                    MessageConsumer.class.getCanonicalName(),
                                    ConfigDef.Importance.LOW,
                                    commonConfig.getConsumerClassDoc())
                            .define(commonConfig.getLatencyPercentileMaxConfig(),
                                    ConfigDef.Type.INT,
                                    5000,
                                    ConfigDef.Importance.LOW,
                                    commonConfig.getLatencyPercentileMaxDoc())
                            .define(commonConfig.getLatencyPercentileGrauDoc(),
                                    ConfigDef.Type.INT,
                                    1,
                                    ConfigDef.Importance.LOW,
                                    commonConfig.getLatencyPercentileGrauDoc())
                            .define(commonConfig.getLatencySlaMsConfig(),
                                    ConfigDef.Type.INT,
                                    20000,
                                    ConfigDef.Importance.MEDIUM,
                                    commonConfig.getLatencySlaMsDoc());

  }

  public ConsumeServiceConfig(Map<?, ?> props) {
    super(CONFIG, props);
  }
}
