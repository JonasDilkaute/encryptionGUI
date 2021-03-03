package view;

import java.util.function.UnaryOperator;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import model.SymmetricEncryptor;

/**
 * Class that constructs and configures the TextFields.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class TextFieldBuilder {

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
	public TextFieldBuilder(SymmetricEncryptor encryptor, TextField encrypted, TextField decrypted, TextField key,
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
		
		UnaryOperator<Change> numberFilter = change1 -> {
			String newText = change1.getControlNewText();
			// newText.matches("^(?:[0-9]|[1-8][0-9]|9[0-9]|1[01][0-9]|12[0-8]|)$")
			if (newText.matches("^(?:[0-9]|1[0-9]|2[0-6]|)$")) {
				return change1;
			}
			return null;

		};
		
		UnaryOperator<Change> inputFilter = change2 -> {
			String newText = change2.getControlNewText();
			if (newText.matches("[a-zA-Z]*")) {
				change2.setText(change2.getText().toUpperCase());
				return change2;
			}
			return null;
		};
		
		if (numberKey) {
			key.setTextFormatter(new TextFormatter<String>(numberFilter));
		} else {
			key.setTextFormatter(new TextFormatter<String>(inputFilter));
		}
		
		decrypted.setTextFormatter(new TextFormatter<String>(inputFilter));
		encrypted.setTextFormatter(new TextFormatter<String>(inputFilter));

	}

}
