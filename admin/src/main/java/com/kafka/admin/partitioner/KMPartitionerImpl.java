
package com.kafka.admin.partitioner;

import static org.apache.kafka.common.utils.Utils.murmur2;

public class KMPartitionerImpl implements KMPartitioner {

  public int partition(String key, int partitionNum) {
    byte[] keyBytes = key.getBytes();
    return toPositive(murmur2(keyBytes)) % partitionNum;
  }

  private static int toPositive(int number) {
    return number & 0x7fffffff;
  }
}
