import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void getName_returnsName_true() {
    Word testWord = new Word("baka");
    assertEquals("baka", testWord.getName());
  }

  @Test
  public void getId_returnsWordId_true() {
    Word testWord = new Word("baka");
    assertTrue(Word.all().size() == testWord.getId());
  }

}
