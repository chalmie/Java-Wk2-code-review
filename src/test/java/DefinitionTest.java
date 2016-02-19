import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  // @Rule
  // public ClearRule clearRule = new ClearRule();

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition("dummy");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void task_instantiatesWithExplanation_true() {
    Definition testDefinition = new Definition("dummy");
    assertEquals("dummy", testDefinition.getExplanation());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("dummy");
    Definition secondDefinition = new Definition("dummy");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

}
