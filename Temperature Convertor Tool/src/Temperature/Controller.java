package Temperature;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> ChoiceBox;
    @FXML
    public TextField textField;
    @FXML
    public Button convertButton;

    private static final String C_to_F_Text="Celsius to Fahrenheit";
    private static final String F_to_C_Text ="Fahrenheit to Celsius";
    private boolean isC_to_F= true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ChoiceBox.getItems().add(C_to_F_Text);
        ChoiceBox.getItems().add(F_to_C_Text);

        ChoiceBox.setValue(C_to_F_Text);

        ChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(C_to_F_Text)){
                isC_to_F = true;
            }else {
                isC_to_F = false;
            }
        });

        convertButton.setOnAction(event -> {
            convert();
        });

    }

    private void convert() {
        String Input = textField.getText();

        float Temperature=0.0f;
        try{
            Temperature = Float.parseFloat(Input);
        }catch (Exception exception){
            warnUser();
            return;// no code execute
        }

        float newTemperature=0.0f;
        if(isC_to_F){
            newTemperature =(Temperature*9/5)+32;
        }else {
            newTemperature =(Temperature-32)*5/9;
        }
        display (newTemperature);
    }

    private void warnUser() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Temperature Valid");
        alert.setContentText("Please Entered Valid Temperature is: ");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit = isC_to_F? "F":"C";
        System.out.println("The new Temperature is: "+newTemperature +" "+unit);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new Temperature is: " +newTemperature +" "+ unit);
        alert.show();
    }



}
