
package com.kafka.admin.services.config;

import com.networknt.config.Config;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

import static org.apache.kafka.common.config.ConfigDef.Range.atLeast;

public class MultiClusterTopicManagementServiceConfig extends AbstractConfig {

  private static final ConfigDef CONFIG;

  static String COMMON_CONFIG_NAME = "common";
  static CommonConfig commonConfig = (CommonConfig) Config.getInstance().getJsonObjectConfig(COMMON_CONFIG_NAME, CommonConfig.class);

  static {
    CONFIG = new ConfigDef()
      .define(commonConfig.getTopicConfig(),
              ConfigDef.Type.STRING,
              ConfigDef.Importance.HIGH,
              commonConfig.getTopicDoc())
      .define(commonConfig.getRebalanceIntervalConfig(),
              ConfigDef.Type.INT,
              1000 * 60 * 10,
              atLeast(10),
              ConfigDef.Importance.LOW,
              commonConfig.getRebalanceIntervalDoc());
  }

  public MultiClusterTopicManagementServiceConfig(Map<?, ?> props) {
    super(CONFIG, props);
  }
}
