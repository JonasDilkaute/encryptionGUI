package application;
	
import java.util.Arrays;

import controller.Controller;
import controller.TabSwitchController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.PermutationEncryption;
import view.GUITabPane;
import view.MoveHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	private GUITabPane tabPane = new GUITabPane();
	private TabSwitchController tabSwitchController;
	private Controller controller;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/application/MainGUIPane.fxml"));
	        
			tabSwitchController = new TabSwitchController(tabPane);
	        controller = new Controller();
	        tabPane.setContentPanes(ContentLoader.loadContent(controller));
	        
	        loader.setController(tabSwitchController);
	        
	        BorderPane root = (BorderPane) loader.load();	        
	        tabPane.setRootPane(root);
	        
	        tabSwitchController.init();
	        controller.init();
	               
	        new MoveHandler(root, primaryStage);
	        
			primaryStage.setScene(new Scene(root));
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Character[] array = {'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 'A'};
		PermutationEncryption enc =new PermutationEncryption(Arrays.asList(array));
		String text = "Bedingt durch die immer noch andauernde Corona Pandemie und die daraus folgenden Einschränkungen ist und wird es auch in der nächsten Zeit schwer möglich sein, finanzielle Mittel für unser Abitur im nächsten Jahr zu generieren. Gleichzeitig sind wir zuversichtlich, dass die Abitur-Feier im gewohnten Rahmen stattfinden kann. Es besteht also eine große Diskrepanz zwischen den möglichen Einnahmenquellen und den notwendigen Ausgaben. Daher wollen wir möglichst alle Möglichkeiten ausschöpfen und würden gerne in naher Zukunft wieder einen Brötchenverkauf anbieten.\r\n" + 
				"Wir sind uns jedoch der aktuellen Situation bewusst und möchten bestmögliche Vorkehrungen treffen, um die Gesundheit von allen Schülerinnen und Schülern und Lehrkräften zu schützen. Weil der Zeitraum bis zu den Osterferien vermutlich eine sensible Zeit darstellt, da sich der Unterricht und die Pausen mit mehr Klassen erst einspielen müssen, planen wir in dieser noch nichts.\r\n" + 
				"Um die Gesundheit aller bestmöglich zu schützen geht es darum alle Risikofaktoren so gering wie möglich zu halten.: Die Vermischung verschiedener Schülergruppen lässt sich durch eine dezentrale Verteilung vermeiden. Wir planen jeweils an den Sammelpunkten der einzelnen Klassen die Brötchen durch maximal zwei Personen zu verkaufen. Eine Vermischung der Gruppen geschieht so nicht. \r\n" + 
				"Für eine sichere Übergabe der Brötchen werden die für den Verkauf zuständigen Mitschüler FFP2 bzw. KN95 Masken und Einmalhandschuhe tragen und die Brötchen mit einer Zange übergeben, sodass auch der Mindestabstand gewährleistet werden kann. Des Weiteren werden die Brötchen beim Verkauf bereits in Papiertüten verpackt sein.\r\n" + 
				"Als weitere Schutzmaßnahmen möchten wir möglichst immer die gleichen Mitschüler zum Verkauf einsetzen und dies natürlich protokollieren. Durch gerade Preise und das Gebot möglichst passend zu zahlen werden zudem die Risken bei der Geldübergabe minimiert. Das Geld wird kontaktlos in einer bereitgestellten Geld-Dose gesammelt.\r\n" + 
				"";
		String e =enc.encrypt(text);
		System.out.println(e);
		enc.frequency(text);
		//String d = enc.decrypt(e);
		//System.out.println(d);
		enc.setKey(enc.estimateKey(e));
		String de =enc.decrypt(e);
		System.out.println(de);
		launch(args);
	}
}
