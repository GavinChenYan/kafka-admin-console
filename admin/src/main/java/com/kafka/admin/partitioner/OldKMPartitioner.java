
package com.kafka.admin.partitioner;

public class OldKMPartitioner implements KMPartitioner {

  public int partition(String key, int partitionNum) {
    return Math.abs(key.hashCode()) % partitionNum;
  }
}
