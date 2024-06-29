package com.arian.example.demo;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public abstract class BaseTest implements WithAssertions {

   protected TestInfo testInfo;

   protected TestReporter testReporter;

   void beforeEachTest(final TestInfo testInfo, final TestReporter testReporter) {
      this.testInfo = testInfo;
      this.testReporter = testReporter;
      testReporter.publishEntry(String.format("DisplayNam:%s TestMethod:%s", testInfo.getDisplayName(), testInfo.getTestMethod()));
   }

}
