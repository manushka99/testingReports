package com.tesingReport.pdftest.matchers;

import com.tesingReport.pdftest.PDF;
import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
import org.junit.internal.matchers.TypeSafeMatcher;


abstract class PDFMatcher extends TypeSafeMatcher<PDF> implements SelfDescribing {
  protected String reduceSpaces(String text) {
    return text.replaceAll("[\\s\\n\\r\u00a0]+", " ").trim();
  }

}
