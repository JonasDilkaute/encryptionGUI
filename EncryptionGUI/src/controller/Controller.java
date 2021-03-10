package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.CaesarEncryption;
import model.PermutationEncryption;
import model.RSAEncryption;
import model.RsaKeyGenerator;
import model.VignereEncryption;
import view.AsymetricTextFieldBuilder;
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
	permutationKeyField,permutationEncryptionField,permutationDecryptionField,
	RSADecryptionField, RSAEncryptionField;

	/**
	 * sets up the application.
	 */
	public void init() {
		new TextFieldBuilder(new CaesarEncryption(1), caesarEncryptionField, caesarDecryptionField, caesarKeyField, true);	
		new TextFieldBuilder(new VignereEncryption(c),vigenereEncryptionField, vigenereDecryptionField, vigenereKeyField, false);	
		new TextfieldBuilder2(new PermutationEncryption(""), permutationEncryptionField, permutationDecryptionField, permutationKeyField, true);
		new AsymetricTextFieldBuilder(new RSAEncryption(), RSADecryptionField, RSAEncryptionField, new RsaKeyGenerator().generateRsaKeySet("Max Mustermann"));
	}
	
	/**
	 * Closes the application.
	 */
	@FXML 
	public void close() {
		System.exit(0);
	}
}
