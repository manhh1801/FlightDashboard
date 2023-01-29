package project.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

import project.app.BackgroundFrame.BackgroundFrame;

public class Launcher extends Application
{
    public void start(Stage Stage_var) throws IOException
    {
        try {Class.forName("com.mysql.cj.jdbc.Driver");}
        catch(ClassNotFoundException c) {}
        BackgroundFrame BackgroundFrame_var=new BackgroundFrame();
        Scene Scene_var = new Scene(BackgroundFrame_var);
        Stage_var.initStyle(StageStyle.UNDECORATED);
        Stage_var.setScene(Scene_var);
        Stage_var.show();
    }

    public static void main(String[] args) {launch();}
}