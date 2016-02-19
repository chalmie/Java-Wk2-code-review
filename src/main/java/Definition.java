import java.util.ArrayList;


public class Definition {
  private static ArrayList<Definition> definitions = new ArrayList<Definition>();
  private String mExplanation;

  public Definition(String explanation) {
    mExplanation = explanation;
    definitions.add(this);
  }

  public String getExplanation() {
    return mExplanation;
  }

  public static ArrayList<Definition> all() {
    return definitions;
  }

}
