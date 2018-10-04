package com.tesingReport.pdftest.matchers;

import com.tesingReport.pdftest.PDF;
import org.hamcrest.Description;

public class ContainsText extends PDFMatcher {
  private final String substring;

  public ContainsText(String substring) {
    this.substring = substring;
  }

  @Override
  public boolean matchesSafely(PDF item) {
    return reduceSpaces(item.text).contains(reduceSpaces(substring));
  }

//  @Override
  protected void describeMismatchSafely(PDF item, Description mismatchDescription) {
    mismatchDescription.appendText("was \"").appendText(reduceSpaces(item.text)).appendText("\"");
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("a PDF containing ").appendValue(reduceSpaces(substring));
  }
}
