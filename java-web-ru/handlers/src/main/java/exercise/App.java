package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        List<String> phones = Data.getPhones();


        app.get("/phones", context -> {
          context.json(Data.getPhones());
        });

        app.get("/domains", context -> {
           context.json(Data.getDomains());
        });
        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
