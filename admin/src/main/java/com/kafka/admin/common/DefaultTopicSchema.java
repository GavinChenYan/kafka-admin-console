
package com.kafka.admin.common;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;

import java.util.Arrays;

public class DefaultTopicSchema {

  public static final Field TOPIC_FIELD = new Field("topic", Schema.create(Schema.Type.STRING), null, null);

  public static final Field TIME_FIELD = new Field("time", Schema.create(Schema.Type.LONG), null, null);

  public static final Field INDEX_FIELD = new Field("index", Schema.create(Schema.Type.LONG), null, null);

  public static final Field PRODUCER_ID_FIELD = new Field("producerId", Schema.create(Schema.Type.STRING), null, null);

  public static final Field CONTENT_FIELD = new Field("content", Schema.create(Schema.Type.STRING), null, null);

  public static final Schema MESSAGE_V0;

  static {
    MESSAGE_V0 = Schema.createRecord("KafkaMonitorSchema", null, "kafka.monitor", false);
    MESSAGE_V0.setFields(Arrays.asList(TOPIC_FIELD, TIME_FIELD, INDEX_FIELD, PRODUCER_ID_FIELD, CONTENT_FIELD));
  }

}
