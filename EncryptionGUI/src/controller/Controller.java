package controller;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import model.AutoCorrector;
import model.CaesarEncryption;
import model.FrequencyData;
import model.PermutationEncryption;
import model.PermutationKey;
import model.RSAEncryption;
import model.RsaKeyGenerator;
import model.VignereEncryption;
import view.AsymetricTextFieldBuilder;
import view.TextFieldBuilder;



/**
 * Class that represents the controller for this application.
 * 
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class Controller  {
	
	char[] c = {'A', 'B', 'C'};
	
	@FXML
	private TextField caesarDecryptionField, caesarEncryptionField, caesarKeyField, 
	vigenereDecryptionField, vigenereEncryptionField, vigenereKeyField, 
	RSADecryptionField, RSAEncryptionField;
	
	private boolean isHardMode = false;
	
	private AutoCorrector corrector;

	@FXML 
	private GridPane analyseBox;

    @FXML
    private TextArea plainTextArea;

    @FXML
    private TextArea encryptedTextArea;

    @FXML
    private TableView<FrequencyData> analysisTable;

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    @FXML
    private Button analyseButton;

    @FXML
    private Button swapButton;

    @FXML
    private TextField swapATextField, keyTextField;

    @FXML
    private TextField swapBTextField;
    
    private PermutationEncryption enc ;
    
    @FXML
    private Label frequencyLabel;
    
    //private List<Character> key = new ArrayList<Character>();
    
    
   
	/**
	 * sets up the application.
	 */
	public void init() {
		corrector = new AutoCorrector();
		enc = new PermutationEncryption(new PermutationKey());
		new TextFieldBuilder(new CaesarEncryption(1), caesarEncryptionField, caesarDecryptionField, caesarKeyField, true);	
		new TextFieldBuilder(new VignereEncryption(c),vigenereEncryptionField, vigenereDecryptionField, vigenereKeyField, false);	
		new AsymetricTextFieldBuilder(new RSAEncryption(), RSADecryptionField, RSAEncryptionField, new RsaKeyGenerator().generateRsaKeySet("Max Mustermann"));
	}
	
	@FXML
    void analyse(ActionEvent event) {
		if(!encryptedTextArea.getText().isBlank()) {
			enc.setPermutationKey(enc.estimateKey(encryptedTextArea.getText(), isHardMode));
			//here
			keyTextField.setText(printKey());
			List<Pair<Character,Integer>> list =enc.frequency(encryptedTextArea.getText());
			String s="";
			Collections.sort(list, Comparator.comparing(p->p.getValue()));
			Collections.reverse(list);
			for(Pair<Character,Integer> p: list) {
				Character c= p.getKey();
				Integer i = p.getValue();	
				s = s+ " "+c + " frequency: " + i + "\n" ;
			}
		frequencyLabel.setText(s);
		if(!isHardMode) {
			fillAnalysePane(plainTextArea.getText(), corrector.getSuggestions(plainTextArea.getText()));
		}
		
		}
		

    }
	
	
	private void fillAnalysePane (String text, Map<String, Map<Integer, String>> suggestions) {
		analyseBox.getChildren().clear();
		String[] words = text.split(" ");
		List<MenuButton> buttonList  = new ArrayList<MenuButton>();
		for(String word: words) {
			MenuButton button = new MenuButton(word);
			VBox vbox = new VBox();
			
			int fromPos = text.indexOf(word);
				String encrypted = encryptedTextArea.getText().substring(fromPos, fromPos+ word.length());
				
				button.setTooltip(new Tooltip(encrypted));
			if(suggestions.containsKey(word)) {
				Map<Integer, String> s = suggestions.get(word);
				HBox suggestionBox = new HBox();
				 
				
		
				for (Map.Entry<Integer, String> pair : s.entrySet()) {
					Button suggestion = new Button(pair.getValue());
					suggestion.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							System.out.println(pair.getValue());
							System.out.println(encrypted);
							replaceWord(pair.getValue(), encrypted);
							keyTextField.setText(printKey());
							decrypt(printKey());
							
							
							
						}
					});
					suggestionBox.getChildren().add(suggestion);
				}
				vbox.getChildren().add(suggestionBox);
		
		
				
			} 
			TextField replacementTF = new TextField();
			replacementTF.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent arg0) {
					if (arg0.getCode().equals(KeyCode.ENTER)) {
						System.out.println("dddtrt");
						replaceWord(replacementTF.getText(), encrypted);
						keyTextField.setText(printKey());
						
						decrypt(printKey());
						
			        }
					
				}
				
			});
			vbox.getChildren().add(replacementTF);
			
			
			CustomMenuItem item =new CustomMenuItem(vbox);
			item.setHideOnClick(false);
			button.getItems().add(item);
			buttonList.add(button);
			
		}
		//analyseBox.setGridLinesVisible(true);
        final int numCols = 5 ;
        final int numRows = 10 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            analyseBox.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            analyseBox.getRowConstraints().add(rowConst);         
        }
		
		
		int i=0;
		for(int y=0; y<10; y++) {
			for(int x=0; x<5; x++) {
				if(i < buttonList.size()) {
					MenuButton button = buttonList.get(i);
					analyseBox.add(button, x, y);
					i++;
				} else {
					return;
				}
				
			}
		}
		
	}
	
	private void replaceWord(String word, String encrypted) {
		word = word.toUpperCase();
		encrypted = encrypted.toUpperCase();
		
		char[] wchars = word.toCharArray();
		char[] echars = encrypted.toCharArray();
		for(int i=0; i<wchars.length;i++) {
			char w = wchars[i];
			char e = echars[i];
			
			enc.replace(w, e);
		}
	}
	

    @FXML
    void decrypt(ActionEvent event) {
    	enc.setPermutationKey(buildKey());
    	String t =enc.decrypt(encryptedTextArea.getText());
    	plainTextArea.setText(t);
    	if(!isHardMode) {
    		fillAnalysePane(t, corrector.getSuggestions(t));
    	}
    	
    	
    }
    
    private void decrypt(String key) {
    	
    	enc.setPermutationKey(buildKey());
    	String t =enc.decrypt(encryptedTextArea.getText());
    	plainTextArea.setText(t);
    	if(!isHardMode) {
    		fillAnalysePane(t, corrector.getSuggestions(t));
    	}
    	
    }

    @FXML
    void encrypt(ActionEvent event) {
    	enc.setPermutationKey(buildKey());
    	encryptedTextArea.setText(enc.encrypt(plainTextArea.getText()));

    }

    @FXML
    void swap(ActionEvent event) {
    	if(!swapATextField.getText().isBlank() && !swapBTextField.getText().isBlank()) {
    		String a = swapATextField.getText();
    		String b = swapBTextField.getText();
    		if((""+a.charAt(0)).matches("[A-Z]") && (""+b.charAt(0)).matches("[A-Z]")) {
    			enc.replace(swapATextField.getText().charAt(0), swapBTextField.getText().charAt(0));
    			keyTextField.setText(printKey());
    		} 		
    	} 
    }
    
    private String printKey() {
    	String s ="";
    	for (Character c: enc.getPermutationKey().getKey().values()) {
    		s =s + c;
    	}
    	return s;
    }
	
    private PermutationKey buildKey() {
    	 Map<Character, Character> keyMap = new HashMap<>();
    	String text =keyTextField.getText();
    	if(text != null&&!text.isBlank()) {
    		text =text.toUpperCase();
    		char[] chars = text.toCharArray();
    		for(int i=0;i<26;i++) {
    			Character c = chars[i];
    			keyMap.put((Character)(char) ( i +65) , c);
    		}
    	}
    	return new PermutationKey(keyMap);
    }
	
	/**
	 * Closes the application.
	 */
	@FXML 
	public void close() {
		System.exit(0);
	}
}
