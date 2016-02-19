import java.util.ArrayList;


public class Definition {
  private static ArrayList<Definition> definitions = new ArrayList<Definition>();
  private String mExplanation;
  private int mId;

  public Definition(String explanation) {
    mExplanation = explanation;
    definitions.add(this);
    mId = definitions.size();
  }

  public String getExplanation() {
    return mExplanation;
  }

  public static ArrayList<Definition> all() {
    return definitions;
  }

  public static void clear() {
    definitions.clear();
  }

  public int getId() {
    return mId;
  }

  public static Definition find(int id) {
    try {
      return definitions.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

}
