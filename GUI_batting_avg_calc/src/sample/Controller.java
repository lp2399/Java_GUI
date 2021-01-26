package sample;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Controller {
    @FXML
    private  TextField txt_area;
    @FXML
    private TextField inputField_hits;
    @FXML
    private TextField inputField_atBat;
    @FXML
    private Button computeButton;
    @FXML
    private Button resetButton;
    @FXML
    private TextField text_area;

    @FXML
    public void initialize() {
        resetButton.setDisable(true);
        computeButton.setDisable(true);
        text_area.setEditable(false);
        txt_area.setEditable(false);
    }

    @FXML
    public void handleKeyRelease() {
        String inputField_one = inputField_hits.getText();
        String inputField_two = inputField_atBat.getText();
        boolean disableButton = (inputField_one.isEmpty() || inputField_one.trim().isEmpty()) && (inputField_two.isEmpty() || inputField_two.trim().isEmpty());
        computeButton.setDisable(disableButton);
    }

    @FXML
    public void onComputeButtonClicked(javafx.event.ActionEvent e) throws Exception{
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        if(e.getSource().equals(computeButton)) {
            String text_one = inputField_hits.getText();
            String text_two = inputField_atBat.getText();
            boolean flag = true;
            while (flag==true){
                try {
                    double hits = Double.parseDouble(text_one);
                    double at_bat = Double.parseDouble(text_two);
                    double result = hits/at_bat;
                    double formatted_result = Double.parseDouble((df.format(result))); // Don't know why it needs to parsed here if previously parsed on line 43, 44
                    text_area.setText(String.valueOf("Batting average: "+formatted_result));
                    flag = false;

                }catch (Exception ex) {
                    text_area.setText("Only enter Digits");
                    break;
                }
            }resetButton.setDisable(false);
        }
    }
    @FXML
    public void onResetButtonClicked(javafx.event.ActionEvent e){
        if(e.getSource().equals(resetButton)) inputField_hits.setText(""); inputField_atBat.setText(""); text_area.setText("");

    }
}
