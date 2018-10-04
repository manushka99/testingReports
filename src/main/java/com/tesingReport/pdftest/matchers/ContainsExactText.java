package com.tesingReport.pdftest.matchers;

import com.tesingReport.pdftest.PDF;
import org.hamcrest.Description;

public class ContainsExactText extends PDFMatcher {
  private final String substring;

  public ContainsExactText(String substring) {
    this.substring = substring;
  }

  @Override
  public boolean matchesSafely(PDF item) {
    return item.text.contains(substring);
  }

//  @Override
  protected void describeMismatchSafely(PDF item, Description mismatchDescription) {
    mismatchDescription.appendText("was \"").appendText(item.text).appendText("\"");
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("a PDF containing ").appendValue(substring);
  }
}
