package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.getIcons().add(new Image("/theme/benU_logo.jpg"));
            primaryStage.setTitle("");
            Scene scene = new Scene(root, 340, 500);
            scene.getStylesheets().add("/theme/style.css");
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

