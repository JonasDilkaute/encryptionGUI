package view;

import java.util.function.UnaryOperator;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import model.SymmetricEncryptor;

public class TextfieldBuilder2 {

	private boolean encryptionblocked;
	private boolean decryptionblocked;
	
	/**
	 * Creates a new TextFieldBuilder
	 * @param encryptor the SymmetricEncryptor
	 * @param encrypted the TextField containing the encrypted text
	 * @param decrypted the TextField containing the decrypted text
	 * @param key the the TextField containing the key
	 * @param numberKey whether the key TextField should be checked to only contain numbers or letters
	 */
	public TextfieldBuilder2(SymmetricEncryptor encryptor, TextField encrypted, TextField decrypted, TextField key,
			boolean numberKey) {

		decrypted.textProperty().addListener((obj, oldVal, newVal) -> {
			if (!(decryptionblocked || newVal.isEmpty() || key.getText().isEmpty())) {
				encryptionblocked = true;
				encrypted.setText(encryptor.encrypt(newVal, key.getText()));
				encryptionblocked = false;
			}
		});

		encrypted.textProperty().addListener((obj, oldVal, newVal) -> {
			if (!(encryptionblocked || newVal.isEmpty() || key.getText().isEmpty())) {
				decryptionblocked = true;
				decrypted.setText(encryptor.decrypt(newVal, key.getText()));
				decryptionblocked = false;
			}
		});

		key.textProperty().addListener((obj, oldVal, newVal) -> {
			if (!(newVal.isEmpty() || (encrypted.getText().isEmpty() && decrypted.getText().isEmpty()))) {
				decryptionblocked = encryptionblocked = true;
				if (decrypted.getText().isEmpty()) {
					decrypted.setText(encryptor.decrypt(encrypted.getText(), newVal));
				} else {
					encrypted.setText(encryptor.encrypt(decrypted.getText(), newVal));
				}

				decryptionblocked = encryptionblocked = false;
			}
		});
		
		UnaryOperator<Change> letterFilter = change1 -> {
			String newText = change1.getControlNewText();
			// newText.matches("^(?:[0-9]|[1-8][0-9]|9[0-9]|1[01][0-9]|12[0-8]|)$")
			if (newText.matches("([a-z][A-Z])*")) {
				change1.setText(change1.getText().toUpperCase());
				return change1;
			}
			return null;

		};
		
		UnaryOperator<Change> inputFilter = change2 -> {
			String newText = change2.getControlNewText();
			//change it!
			if (true) {
				change2.setText(change2.getText().toUpperCase());
				return change2;
			}
			return null;
		};
		
		if (numberKey) {
			key.setTextFormatter(new TextFormatter<String>(letterFilter));
		} else {
			key.setTextFormatter(new TextFormatter<String>(inputFilter));
		}
		
		decrypted.setTextFormatter(new TextFormatter<String>(inputFilter));
		encrypted.setTextFormatter(new TextFormatter<String>(inputFilter));

	}
}
