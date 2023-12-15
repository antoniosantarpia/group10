/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package scientificcalculatorapp;


import exceptions.NullVariableException;
import exceptions.VarOutOfRangeException;
import exceptions.WrongCommandsException;
import exceptions.ZeroDivisionException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


/**
 *
 * @author Group_10
 */
public class ControllerFXML implements Initializable {
    
    private Deque<ComplexNumber> stack;
    private ObservableList<ComplexNumber> stackObs;
    private ObservableList<Character> variablesObs;
    private Calculator parser;
    private Alert alert;
    private Variables var;

    @FXML
    private ListView<ComplexNumber> stackView;
    @FXML
    private TextField displayField;
    @FXML
    private ComboBox<Character> variablesList;
    
   
   

    /**
     * Method to initialize Model and GUI
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
        
        
        alert = new Alert(Alert.AlertType.ERROR);

        stack = new LinkedList<>();

        stackObs = FXCollections.observableArrayList();
        
        var = new Variables(stack);
        
        parser = new Calculator(stack);

        stackView.setItems(stackObs);
        stackView.setCellFactory(sc -> {
            ListCell<ComplexNumber> cell = new ListCell<ComplexNumber>() {
               
                @Override
                protected void updateItem(ComplexNumber cn, boolean empty) {
                    super.updateItem(cn, empty);
                    if (empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        
                        DecimalFormat df = new DecimalFormat("#.###", DecimalFormatSymbols.getInstance(Locale.US));
        
                        double img = Double.parseDouble(df.format(cn.getImg()));
                        double re = Double.parseDouble(df.format(cn.getReal()));
                  
                        if(re == 0 && img == 0)
                            setText("0");
                        else if(re == 0 && img > 0)
                            setText(img + "j");
                        else if(re == 0 && img < 0)
                            setText(img + "j");
                        else if(re > 0 && img == 0)
                            setText(re + "");
                        else if(re > 0 && img > 0)
                            setText(re + "+" + img + "j");
                        else if(re > 0 && img < 0)
                            setText(re + "" + img + "j");
                        else if(re < 0 && img == 0)
                            setText(re + "");
                        else if(re < 0 && img > 0)
                            setText(re + "+" + img + "j");
                        else
                            setText(re + "" + img + "j");
                    }
                }
            };
            cell.setAlignment(Pos.CENTER);
            cell.setFont(Font.font("Arial", 16));
            return cell;
        });
       

       
      

        variablesObs = FXCollections.observableArrayList();

        for (int i = 0; i < 26; i++) {
            variablesObs.add((char) (i + 97));
        }

         variablesList.setItems(variablesObs);
         
        
         variablesList.setStyle("-fx-font: 15px \"Arial\";");
         
       
      

        displayField.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                displayField.end();
            }
        });
    }
    
     @FXML
    private void cancClick(ActionEvent event) {
        String text = displayField.getText();
        int index = text.lastIndexOf(" ");

        if (index != -1) {
            displayField.setText(text.substring(0, index));
        } else {
            displayField.setText("");
        }

    }
    
    
    
     @FXML
    private void deleteClick(ActionEvent event) {

         String text = displayField.getText();
       

        if (!text.isEmpty()) {
            displayField.setText(text.substring(0, text.length() - 1));
        }
       
    }
    
    
    
     @FXML
    private void oneClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "1");
    }

    @FXML
    private void twoClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "2");
    }

    @FXML
    private void threeClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "3");
    }
    
    @FXML
    private void fourClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "4");
    }

    @FXML
    private void fiveClick(ActionEvent x){
        displayField.setText(displayField.getText() + "5");
    }

    @FXML
    private void sixClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "6");
    }
    
    @FXML
    private void sevenClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "7");
    }

    @FXML
    private void eightClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "8");
    }

    @FXML
    private void nineClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "9");
    }

     @FXML
    private void zeroClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "0");
    }

    @FXML
    private void pointClick(ActionEvent x) {
        displayField.setText(displayField.getText() + ".");
    }

    @FXML
    private void jClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "j");
    }

    
    @FXML
    private void sumClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "+");
    }

    @FXML
    private void subClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "-");
    }

    @FXML
    private void divClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "/");
    }

    @FXML
    private void sqrtClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "sqrt");
    }

    @FXML
    private void invClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "+/-");
    }
    
    
    @FXML
    private void clearClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "clear");
    }

    @FXML
    private void dropClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "drop");
    }

    @FXML
    private void dupClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "dup");
    }

    @FXML
    private void swapClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "swap");
    }

    @FXML
    private void overClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "over");
    }

    @FXML
    private void prodClick(ActionEvent x) {
        displayField.setText(displayField.getText() + "*");
    }

    @FXML
    private void copyVarClick(ActionEvent x) {
        if(variablesList.getValue()!=null)
            try {
        displayField.setText(displayField.getText() + ">" + variablesList.getValue());
            }
        catch (NullVariableException ex){
            errorMessage("Variable Value Error", "Select a variable");   
        }
    }

    @FXML
    private void assignVarClick(ActionEvent x) {
        if(variablesList.getValue()!=null)
            try {
        displayField.setText(displayField.getText() + "<" + variablesList.getValue());
            }
        catch (NullVariableException ex){
            errorMessage("Variable Value Error", "Select a variable");   
        }
    }

    @FXML
    private void sumToVarClick(ActionEvent x) {
         if(variablesList.getValue()!=null)
            try {
         displayField.setText(displayField.getText() + "+" + variablesList.getValue());
            }
        catch (NullVariableException ex){
            errorMessage("Variable Value Error", "Select a variable");   
        }
        
    }

    @FXML
    private void subtractToVarClick(ActionEvent x) {
       if(variablesList.getValue()!=null)
            try {
         displayField.setText(displayField.getText() + "-" + variablesList.getValue());
            }
        catch (NullVariableException ex){
            errorMessage("Variable Value Error", "Select a variable");   
        }
    }


    @FXML
    private void enterClick(ActionEvent x) {
        CallParse();
    }
    
    @FXML
    private void enterTextField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            String inputText = displayField.getText();

       if (inputText.length() == 1 && Character.isLetter(inputText.charAt(0))) {
            char inputChar = Character.toLowerCase(inputText.charAt(0)); /* converts a character to lowercase */
            switch (inputChar) {
                case 'a':
                    variablesList.setValue('a');
                    break;
                case 'b':
                    variablesList.setValue('b');
                    break;
                case 'c':
                    variablesList.setValue('c');
                    break;
                case 'd':
                    variablesList.setValue('d');
                    break;
                case 'e':
                    variablesList.setValue('e');
                    break;
                case 'f':
                    variablesList.setValue('f');
                    break;
                case 'g':
                    variablesList.setValue('g');
                    break;
                case 'h':
                    variablesList.setValue('h');
                    break;    
                case 'i':
                    variablesList.setValue('i');
                    break;
                case 'k':
                    variablesList.setValue('k');
                    break;
                case 'l':
                    variablesList.setValue('l');
                    break;    
                case 'm':
                    variablesList.setValue('m');
                    break;
                case 'n':
                    variablesList.setValue('n');
                    break;
                case 'o':
                    variablesList.setValue('o');
                    break;
                case 'p':
                    variablesList.setValue('p');
                    break;
                case 'q':
                    variablesList.setValue('q');
                    break;
                case 'r':
                    variablesList.setValue('r');
                    break;
                case 's':
                    variablesList.setValue('s');
                    break;
                case 't':
                    variablesList.setValue('t');
                    break;
                case 'u':
                    variablesList.setValue('u');
                    break;
                case 'v':
                    variablesList.setValue('u');
                    break;
                case 'w':
                    variablesList.setValue('u');
                    break;
                case 'x':
                    variablesList.setValue('x');
                    break;
                case 'y':
                    variablesList.setValue('y');
                    break;
                case 'z':
                    variablesList.setValue('z');
                    break; 
            }
        }   
        CallParse();
        }
    }
    
   
    
    
   
    private void CallParse() {
        String input = displayField.getText().replaceAll("\\s", "");
        if (input.length() != 0) {

            try {
                parser.parse(input);
            } catch (WrongCommandsException ex) {
                errorMessage("Wrong command/s", "You inserted wrong command/s.\nEnter the correct operations.");
            } catch (EmptyStackException ex) {
                errorMessage("Not enough operands", "There are not enough operands for the selected operation.");
            } catch (ZeroDivisionException ex) {
                errorMessage("Division by 0", "Division Error");
            } catch (NullVariableException ex) {
                errorMessage("Variable Value Error", "The inserted variable hasn't a value");
            } catch (VarOutOfRangeException ex) {
                errorMessage("Variable out of range", "The inserted variable doesn't exist");
            }finally {
                stackObs.setAll(stack);
            }
        } else {
            warningMessage("Insert one or more operations", "You must insert one or more operations");
        }
        displayField.setText("");
    }
    
    /**
     * The warningDialog method is used to show a warning dialog
     */
    private void warningMessage(String header, String content){
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    /**
     * The errorDialog method is used to show an error dialog 
     */
    private void errorMessage(String header, String content){
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
 
}
