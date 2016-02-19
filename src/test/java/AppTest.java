import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Personal Dictionary");
  }

  @Test
  public void newWordIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#word").with("Baka");
    submit(".btn");
    click("a", withText("Baka"));
    assertThat(pageSource()).contains("Here are all of the definitions for Baka:");
  }

  // @Test
  // public void definitionIsDisplayedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#word").with("Baka");
  //   submit(".btn");
  //   click("a", withText("Baka"));
  //   fill("#definition").with("Dummy");
  //   submit(".btn");
  //   click("a", withText("Return to Main Page"));
  //   click("a", withText("Baka"));
  //   assertThat(pageSource()).contains("Dummy");
  // }

}
