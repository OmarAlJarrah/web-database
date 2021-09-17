package com.omar.demo.log;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
public class Log {
  private final Logger transactionLogger;
  private FileHandler transactionsFileHandler;

  public Log() {
    try {
      transactionsFileHandler = new FileHandler("transactions.log", true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    transactionLogger = Logger.getLogger(Log.class.getName());
    transactionLogger.addHandler(transactionsFileHandler);
  }

  public void logTransaction(String transaction) {
    transactionLogger.info(transaction);
  }
}
