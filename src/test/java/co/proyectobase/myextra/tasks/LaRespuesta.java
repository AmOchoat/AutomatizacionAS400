package co.proyectobase.myextra.tasks;

import co.proyectobase.myextra.interactions.Leer;
import co.proyectobase.myextra.userinterface.SQLPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Tasks;

public class LaRespuesta implements Question<String> {
    public static LaRespuesta es() {
        return new LaRespuesta();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Leer.elTextoEn(SQLPage.TITULO_SQL_PAGE);
    }
}
