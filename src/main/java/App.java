import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("words", Word.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String inputtedWord = request.queryParams("word");
      Word newWord = new Word(inputtedWord);

      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));


      model.put("word", word);
      model.put("definitions", word.getDefinitions());
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Word word = Word.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> definitions = word.getDefinitions();

      if (definitions == null) {
        definitions = new ArrayList<Definition>();
        request.session().attribute("definitions", definitions);
      }

      String explanation = request.queryParams("definition");
      Definition newDefinition = new Definition(explanation);

      definitions.add(newDefinition);

      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
