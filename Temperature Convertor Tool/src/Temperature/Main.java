package Temperature;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Tool Converter");
        primaryStage.show();

    }

    private MenuBar createMenu(){
        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newmenuItem = new MenuItem("New");

        newmenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitmenuItem = new MenuItem("Quit");

        quitmenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newmenuItem, separatorMenuItem , quitmenuItem);

        //Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alertdialog = new Alert(Alert.AlertType.WARNING);
        alertdialog.setTitle("My First Desktop App");
        alertdialog.setHeaderText("Learning JavaFX");
        alertdialog.setContentText("I am just Beginner but soon I will be pro and start developing and start developing awesome Java Games ");

        ButtonType yesbutton=new ButtonType("Yes");
        ButtonType nobutton=new ButtonType("No");

        alertdialog.getButtonTypes().setAll(yesbutton,nobutton);

        Optional<ButtonType> clickbutton =  alertdialog.showAndWait();

        if (clickbutton.isPresent() && clickbutton.get()==yesbutton){
            System.out.println("Yes clicked button");
        }
        else{
            System.out.println("No clicked button");
        }

    }
}

