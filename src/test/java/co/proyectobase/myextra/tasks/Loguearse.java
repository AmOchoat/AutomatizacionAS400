package co.proyectobase.myextra.tasks;

import co.proyectobase.myextra.interactions.Digitar;
import co.proyectobase.myextra.interactions.Escribir;
import co.proyectobase.myextra.interactions.Ir;
import co.proyectobase.myextra.model.Tecla;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

import static co.proyectobase.myextra.userinterface.LoginPage.*;

public class Loguearse implements Task {

    public static Loguearse enMyExtra() {
        return Tasks.instrumented(Loguearse.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Escribir.elTexto("").en(USUARIO));
        actor.attemptsTo(Escribir.elTexto("").en(PASSWORD));
        actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
        actor.attemptsTo(Ir.hastaVerTexto("").en(UBICACION));
    }
}
