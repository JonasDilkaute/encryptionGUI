package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.CaesarEncryption;
import model.FrequencyData;
import model.PermutationEncryption;
import model.RSAEncryption;
import model.RsaKeyGenerator;
import model.VignereEncryption;
import view.AsymetricTextFieldBuilder;
import view.TableBuilder;
import view.TextFieldBuilder;
import view.TextfieldBuilder2;


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

	

    @FXML
    private TextArea plainTextArea;

    @FXML
    private TextArea encryptedTextArea;

    @FXML
    private TableView<?> analysisTable;

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
    
    private List<Character> key;

	/**
	 * sets up the application.
	 */
	public void init() {
		enc = new PermutationEncryption(new ArrayList<Character>());
		new TextFieldBuilder(new CaesarEncryption(1), caesarEncryptionField, caesarDecryptionField, caesarKeyField, true);	
		new TextFieldBuilder(new VignereEncryption(c),vigenereEncryptionField, vigenereDecryptionField, vigenereKeyField, false);	
		//new TextfieldBuilder2(new PermutationEncryption(new ArrayList<Character>()), permutationEncryptionField, permutationDecryptionField, permutationKeyField, true);
		//new TableBuilder<FrequencyData>(analysisTable, key);
		new AsymetricTextFieldBuilder(new RSAEncryption(), RSADecryptionField, RSAEncryptionField, new RsaKeyGenerator().generateRsaKeySet("Max Mustermann"));
	}
	
	@FXML
    void analyse(ActionEvent event) {
		key =enc.estimateKey(encryptedTextArea.getText());
		enc.setKey(key);
		keyTextField.setText(printKey());

    }

    @FXML
    void decrypt(ActionEvent event) {
    	key = buildKey();
    	enc.setKey(key);
    	plainTextArea.setText(enc.decrypt(encryptedTextArea.getText()));
    }

    @FXML
    void encrypt(ActionEvent event) {
    	key = buildKey();
    	enc.setKey(key);
    	encryptedTextArea.setText(enc.encrypt(plainTextArea.getText()));

    }

    @FXML
    void swap(ActionEvent event) {
    	
    	
    	enc.swapLetters(swapATextField.getText().charAt(0), swapBTextField.getText().charAt(0));
    	key = enc.getKey();
    	keyTextField.setText(printKey());
    	

    }
    
    private String printKey() {
    	String s ="";
    	for (Character c: key) {
    		s =s + c;
    	}
    	return s;
    }
	
    private List<Character> buildKey() {
    	List<Character> key = new ArrayList<Character>();
    	String text =keyTextField.getText();
    	if(text != null&&!text.isBlank()) {
    		text =text.toUpperCase();
    		
    		key = text.chars()
    			    .mapToObj(e->(char)e).collect(Collectors.toList());
    	}
    	return key;
    }
	
	/**
	 * Closes the application.
	 */
	@FXML 
	public void close() {
		System.exit(0);
	}
}
