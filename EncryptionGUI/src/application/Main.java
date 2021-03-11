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
		String text = "An einem ganz normalen Schultag beabsichtigt unser ganz normaler Durchschnittsschüler, morgens mit dem Fahrrad zur Schule zu fahren.\r\n"
				+ "\r\n"
				+ "Ganz so normal ist dieser Tag nun doch nicht, denn es ist der erste Tag einer Woche, in der aufgrund einer verabredeten Wette testweise der Schulweg mit verschiedenen Verkehrsmitteln zurückgelegt werden soll, um zu beweisen -- nach Ansicht unseres wettenden Schülers zu widerlegen --, dass Wege unter zwei Kilometern Länge vorzugsweise zu Fuß zurückzulegen sein sollten. Ist natürlich völliger Unsinn, wie unser selbstbewusster Schüler meint, selbstverständlich ist ein Fahrzeug jedweder Art für moderne Schüler unverzichtbar, weil normale Füße viel zu langsam laufen.\r\n"
				+ "\r\n"
				+ "In dieser siegesgewissen Sicherheit steigt er also auf und fährt los, während es beginnt zu regnen. Macht nichts, sind ja nur ein paar Tropfen. Auf dem Gehweg fahrend wird er von einer schrecklich hysterischen Oma verscheucht und fährt nun weiter auf der Fahrbahn, was er eigentlich vermeiden wollte, weil dort die Autos so dicht vorbeirasen. Im dichten Abgasmeer dahinkeuchend fällt ihm zu spät eine wohl des nachts mutwillig zerbrochene Bierflasche auf, deren Reste er notgedrungen überfährt. Macht aber nichts, wird schon gutgehen, wie immer. Ein besonders eiliger LKW überholt noch schnell, bevor er rechts abbiegt und unseren Schüler fast begräbt, der sich jedoch mittels eines schnellen Sprunges auf den Gehweg retten kann, bevor sein Fahrrad unter den schweren Reifen verendet. Da steht er nun, schwitzend, durchnässt; und sein Fahrrad hätte sogar noch einen Platten gehabt, wenn es denn noch lebte. Und er kommt -- schlimm -- zu spät zum Unterricht.\r\n"
				+ "\r\n"
				+ "Na gut, das mit dem Fahrrad ist ja auch eher etwas für naive Idealisten. Sowieso viel zu anstrengend. Also steigt unser Schüler am nächsten Morgen besser in den Bus, wie er sich so denkt. Einfach aus der Haustür um die Ecke gelaufen, eingestiegen, bequem hingefahren, ausgestiegen, um die Ecke in die Schule, fertig. Tatsächlich funktioniert sein billiger Plan bis zur Haltestelle. Nun müsste um 32 der Bus erscheinen. Es wird 33, 35, 40 und kein Bus kommt. Eine mitwartende Dame erlöst sein Unverständnis dahingehend, der Bus sei bereits um 30 da gewesen. Schön, diese Überpünktlichkeit, sehr nützlich für Leute, die es noch eiliger hatten als unser Schüler. Endlich, da kommt der nächste Bus -- und fährt wegen Überfüllung einfach vorbei. Viele eine überzeugende Verspätungsentschuldigung konstruierende Gedankengänge später erscheint er um 52, der rettende nächste Bus. Eng ist´s darin, glitschig und stinkend, aber immerhin besser als laufen. Wenn jetzt an der vorletzten Haltestelle nicht noch ein Fahrerwechsel stattfinden würde, wäre unser armer Durchschnittsschüler schon um 08:10 Uhr rennend und schwitzend in seiner Schule angekommen, aber so dauert´s eben noch etwas länger; worauf es hinsichtlich des Grades der Schlimmheit schon nicht mehr ankommt.\r\n"
				+ "\r\n"
				+ "Ok, ist ja klar, wer fährt schon mit dem Bus. Das ist was für Leute, die endlos Zeit haben. Schüler dagegen haben´s immer eilig, ihre geliebte Schule nur ja überpünktlich zu erreichen. Am nächsten Morgen wird ein Elternteil männlicher Variante zwangsrekrutiert, seinen Nachwuchs standesgemäß im Mercedes 450 SEL 6,9 -- dem spießigen Garagenliebling des leider oftmals nicht weniger spießigen Herrn Obervaters -- zum Einsatzort zu chauffieren. Von einem solchen Auto darf wohl erwartet werden, dass man, kaum eingestiegen, auch schon wieder aussteigen kann, so schnell, komfortabel und ausgeruht sollte jedwedes Fahrtziel erreicht sein. Und nebenbei könnte man mit dieser Benzinschleuder zumindest vor seiner etwas bildungsferneren Mitschülerschaft ganz nett angeben, prognostiziert professionell unser ganz normaler Durchschnittsschüler. In dieser Überheblichkeit lässt er sich denn herab, auf dem Ledersofa im Heck Platz zu nehmen. Die Garage öffnet sich, der Luxusschlitten fährt vor -- und wird vom Müllwagen blockiert. Na gut, warten wir eben, die verlorene Zeit holen wir danach schon wieder rein. Nach vierminütiger konzentrierter Borduhr- Observation ist der Weg endlich frei. Sofort wird wird hektisch eingebogen, sogleich abgebogen und sofort -- angehalten. Denn der Ampelstau kennt im Berufsverkehr kein Erbarmen mit schicken Karren. Die Uhr erfährt eine Beachtung, um die sie manches Topmodel beneiden würde. Nach endlosen 11 Minuten ist der Weg endlich frei für den Chauffeur, die Kreuzung trotz Rotlichtes gerade noch unfallfrei passieren zu können. Und da ist sie auch schon, die nächste Ampelkreuzung. Die Autowracks des neuesten Unfalles liegen noch immer brennend herum, behindern den weiteren Schulweg in inakzeptabler Weise und verursachen den Verlust dreier weiterer Minuten. Der Durchschnittschüler rechnet schwitzend aus, dass die verbleibenden 800 Meter unter Berücksichtigung minimalst möglicher Beschleunigungszeit, maximalst wirkender Bremsanlage, explosionsartigen Aussteigens und raketenartigen Treppensteigens mit einer Geschwindigkeit von ca. 78 km/h zurückgelegt werden müssten, um heute noch pünktlich im Klassenzimmer zu erscheinen. Als jedoch ein Radfahrer mit seiner Jutetasche den rechten Aussenspiegel berührt und der Chauffeur außer Sinnes dem Auto entspringt, um den Schädiger zu verfolgen, vom Rad zu reißen und in dem offenkundigen Vorhaben, ihn zu lynchen ein paar letzte Worte mit ihm wechselt, bevor er allerdings von mehreren Passanten zu Boden geworfen wird, weiß unser Schüler : Es geht immer noch schlimmer. Diese Erkenntnis kostet ihn um 08:15 Uhr einen amtlichen Tadel seiner Lehrerin.\r\n"
				+ "\r\n"
				+ "So kann das nicht weitergehen, denkt sich unser Schüler. Am Ende würde es noch so weit kommen, zu Schule laufen zu müssen -- nein, das wäre das Ende. Am Ende des schlaflosen Schultages beschließt er -- zu allem entschlossen --, seinen entfernten Onkel, einen Piloten der Flugbereitschaft der Luftwaffe, anzurufen, um ihn zu bitten, auszuhelfen. Dieser Onkel legt seltsamerweise auf, nachdem er die Frage einfach nur mit einem Lachen beantwortet hat. Doch sogleich ereilt ihn ein rettender Einfall. \"In der Not hilft Dir Dein Freund und Helfer -- Deine Polizei\", hatte der Schüler mal in irgendeiner bescheuerten Schulsendung gehört. Er könnte doch morgen früh einfach bei den Bullen anrufen und behaupten, in seiner Schule sei ein Massaker geplant -- und nur er, der Durchschnittsschüler wisse, wie der Täter aussehe. Dann müssten nach seiner eiskalten Berechnung etwa fünf Minuten später mehrere Mannschaftswagen vor der Tür stehen, er könnte sich den schönsten zum Einsteigen aussuchen, sie würden gemeinsam mit Blaulicht nach wenigen Sekunden dort ankommen und er würde aussteigen und sich entschuldigen mit den Worten, er habe soeben bemerkt sich im Datum geirrt zu haben; eigentlich sei es schon für letzte Woche geplant gewesen, aber da ja bis heute gar nichts passiert sei, habe sich wohl jemand einen Scherz mit ihm erlaubt. Eine derart raffinierte Geschichte könnte ihm niemand verübeln; schließlich ist er noch ein unbescholtenes Kind, das weiß er genau.\r\n"
				+ "\r\n"
				+ "Gesagt, getan nach einer schlaflosen Nacht. Der Beamte am Telefon verhält sich jedoch unerwartet kritisch und legt besonderen Wert auf die Beantwortung der Frage nach dem Namen und der Adresse unseres Schülers. Wahrscheinlich nur damit sie wissen, wo sie klingeln sollen, denkt er noch bei sich, verschlingt kichernd ein paar Tüten Erdnussflips und wartet. Lange.\r\n"
				+ "\r\n"
				+ "Etwa eine Stunde später wird er von seinem ehemaligen Chauffeur äußerst ungehalten aus dem Schlafsessel gerissen und zur Rede gestellt. Es habe ein äußerst unangenehmes Gespräch mit dem Kontaktbereichsbeamten gegeben, das im Hinblick auf neuerdings neuartig aufzuziehende Erziehungssaiten zu äußerst unangenehmen Konsequenzen für seinen Sohn führen werde, verdeutlicht er, während er dessen Handy aus dem Fenster wirft. Unser Durchschnittsschüler, nicht sogleich sichtbar beeindruckt, zeigt sich erst einsichtig -- äußerst --, als die Musikanlage, der Fernseher, der PC, die Modellautosammlung und das coole zerlöcherte T-Shirt dem Handy folgen. Den Verlust des in den Laubhäcksler geratenen Shirts wird er in diesem Leben wohl kaum verkraften können, mutmaßt er schluchzend und schleppt sich schwitzend nach dem Ende der Generaldebatte mit letzter Kraft zu Fuß in sein Klassenzimmer. Zu allem Unglück hat er damit auch noch seine Wette verloren. Bis zum Ende seiner Schulzeit darf er nun bei jedem Wetter täglich hierher laufen; wie schrecklich schlimm.";
		//text = "AZ";
		String e =enc.encrypt(text);
		System.out.println(e);
		//enc.frequency(text);
		//Character[] array2 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		//enc.setKey(Arrays.asList(array2));
		String d = enc.decrypt(e);
		System.out.println(d);
		enc.setKey(enc.estimateKey(e));
		String de =enc.decrypt(e);
		System.out.println(de);
		launch(args);
	}
}
