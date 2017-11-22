
package com.kafka.admin.apps;

public interface App {

  void start();

  void stop();

  boolean isRunning();

  void awaitShutdown();
}
