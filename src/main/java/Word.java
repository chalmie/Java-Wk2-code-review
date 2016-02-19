import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> dictionary = new ArrayList<Word>();
  private String mName;
  private int mId;

  public Word(String name) {
    mName = name;
    dictionary.add(this);
    mId = dictionary.size();
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Word> all() {
    return dictionary;
  }

  public static void clear() {
    dictionary.clear();
  }

  public static Word find(int id) {
    try {
      return dictionary.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }


}
