package exercise;
import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

       var app = Javalin.create(config ->{
           config.bundledPlugins.enableDevLogging();
       });
       return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.get("/welcome", context -> context.result("Welcome to Hexlet!"));
        app.start(7070);
    }
}
