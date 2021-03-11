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
		String text = "Bedingt durch die immer noch andauernde Corona Pandemie und die daraus folgenden Einschr�nkungen ist und wird es auch in der n�chsten Zeit schwer m�glich sein, finanzielle Mittel f�r unser Abitur im n�chsten Jahr zu generieren. Gleichzeitig sind wir zuversichtlich, dass die Abitur-Feier im gewohnten Rahmen stattfinden kann. Es besteht also eine gro�e Diskrepanz zwischen den m�glichen Einnahmenquellen und den notwendigen Ausgaben. Daher wollen wir m�glichst alle M�glichkeiten aussch�pfen und w�rden gerne in naher Zukunft wieder einen Br�tchenverkauf anbieten.\r\n" + 
				"Wir sind uns jedoch der aktuellen Situation bewusst und m�chten bestm�gliche Vorkehrungen treffen, um die Gesundheit von allen Sch�lerinnen und Sch�lern und Lehrkr�ften zu sch�tzen. Weil der Zeitraum bis zu den Osterferien vermutlich eine sensible Zeit darstellt, da sich der Unterricht und die Pausen mit mehr Klassen erst einspielen m�ssen, planen wir in dieser noch nichts.\r\n" + 
				"Um die Gesundheit aller bestm�glich zu sch�tzen geht es darum alle Risikofaktoren so gering wie m�glich zu halten.: Die Vermischung verschiedener Sch�lergruppen l�sst sich durch eine dezentrale Verteilung vermeiden. Wir planen jeweils an den Sammelpunkten der einzelnen Klassen die Br�tchen durch maximal zwei Personen zu verkaufen. Eine Vermischung der Gruppen geschieht so nicht. \r\n" + 
				"F�r eine sichere �bergabe der Br�tchen werden die f�r den Verkauf zust�ndigen Mitsch�ler FFP2 bzw. KN95 Masken und Einmalhandschuhe tragen und die Br�tchen mit einer Zange �bergeben, sodass auch der Mindestabstand gew�hrleistet werden kann. Des Weiteren werden die Br�tchen beim Verkauf bereits in Papiert�ten verpackt sein.\r\n" + 
				"Als weitere Schutzma�nahmen m�chten wir m�glichst immer die gleichen Mitsch�ler zum Verkauf einsetzen und dies nat�rlich protokollieren. Durch gerade Preise und das Gebot m�glichst passend zu zahlen werden zudem die Risken bei der Geld�bergabe minimiert. Das Geld wird kontaktlos in einer bereitgestellten Geld-Dose gesammelt.\r\n" + 
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
