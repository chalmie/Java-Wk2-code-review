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
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("baka");
    Word secondWord = new Word("aho");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void getId_returnsWordId_true() {
    Word testWord = new Word("baka");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void clear_removesAllWordsFromMemory() {
    Word testWord = new Word("baka");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("baka");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word testWord = new Word("baka");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void addDefinition_addsDefinitionToWord() {
    Word testWord = new Word("baka");
    Definition testDefinition = new Definition("dummy");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

}
