package interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutRest implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    String json =
        "{\"id\":123,\"category\":{\"id\":1,\"name\":\"animal\"},\"name\":\"michi3\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":2,\"name\":\"cat\"}],\"status\":\"available\"}\n";
    actor.attemptsTo(
        Put.to("v2/pet")
            .with(
                request ->
                    request
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .body(json)));
    System.out.println(SerenityRest.lastResponse().asString());
  }

  public static Performable on() {
    return Instrumented.instanceOf(PutRest.class).withProperties();
  }
}
