package view;

import java.util.function.UnaryOperator;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import model.AsymmetricEncryptor;
import model.RsaKeySet;

/**
 * Class that builds the TextFields for asymmetric encryption
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class AsymetricTextFieldBuilder {

	private boolean encryptionblocked;
	private boolean decryptionblocked;
	
	/**
	 * Creates a new AsymmetricTextFieldBuilder and builds the TextsFields. 
	 * @param encryptor the AsymmetricEncryptor
	 * @param decrypted the decrypted TextField
	 * @param encrypted the encrypted TextField
	 * @param keySet the RSA keySet
	 */
	public AsymetricTextFieldBuilder(AsymmetricEncryptor encryptor, TextField decrypted, TextField encrypted, RsaKeySet keySet) {
		decrypted.textProperty().addListener((obj, oldVal, newVal) -> {
			if(!(decryptionblocked ||newVal.isEmpty() )) {
				encryptionblocked = true;
				encrypted.setText(encryptor.encrypt(newVal, keySet.getPublicKey()));
				encryptionblocked = false;
			}
		});
		
		encrypted.textProperty().addListener((obj, oldVal, newVal) -> {
			if(!(encryptionblocked ||newVal.isEmpty() )) {
				decryptionblocked = true;
				decrypted.setText(encryptor.decrypt(newVal, keySet.getPrivateKey()));
				decryptionblocked = false;
			}
		});
		
		UnaryOperator<Change> inputFilter = change -> {
			String newText = change.getControlNewText();
			if (newText.matches("[0-9]*")) {
				return change;
			}
			return null;
		};
		
		decrypted.setTextFormatter(new TextFormatter<Integer>(inputFilter));
		encrypted.setTextFormatter(new TextFormatter<Integer>(inputFilter));
	}
}
