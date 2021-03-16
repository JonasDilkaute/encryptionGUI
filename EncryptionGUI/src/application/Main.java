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
		String text = "An einem ganz normalen Schultag beabsichtigt unser ganz normaler Durchschnittsschüler, morgens mit dem Fahrrad zur Schule zu fahren.\r\n" + 
				"\r\n" + 
				"Ganz so normal ist dieser Tag nun doch nicht, denn es ist der erste Tag einer Woche, in der aufgrund einer verabredeten Wette testweise der Schulweg mit verschiedenen Verkehrsmitteln zurückgelegt werden soll, um zu beweisen -- nach Ansicht unseres wettenden Schülers zu widerlegen --, dass Wege unter zwei Kilometern Länge vorzugsweise zu Fuß zurückzulegen sein sollten. Ist natürlich völliger Unsinn, wie unser selbstbewusster Schüler meint, selbstverständlich ist ein Fahrzeug jedweder Art für moderne Schüler unverzichtbar, weil normale Füße viel zu langsam laufen.\r\n" + 
				"\r\n" + 
				"In dieser siegesgewissen Sicherheit steigt er also auf und fährt los, während es beginnt zu regnen. Macht nichts, sind ja nur ein paar Tropfen. Auf dem Gehweg fahrend wird er von einer schrecklich hysterischen Oma verscheucht und fährt nun weiter auf der Fahrbahn, was er eigentlich vermeiden wollte, weil dort die Autos so dicht vorbeirasen. Im dichten Abgasmeer dahinkeuchend fällt ihm zu spät eine wohl des nachts mutwillig zerbrochene Bierflasche auf, deren Reste er notgedrungen überfährt. Macht aber nichts, wird schon gutgehen, wie immer. Ein besonders eiliger LKW überholt noch schnell, bevor er rechts abbiegt und unseren Schüler fast begräbt, der sich jedoch mittels eines schnellen Sprunges auf den Gehweg retten kann, bevor sein Fahrrad unter den schweren Reifen verendet. Da steht er nun, schwitzend, durchnässt; und sein Fahrrad hätte sogar noch einen Platten gehabt, wenn es denn noch lebte. Und er kommt -- schlimm -- zu spät zum Unterricht.\r\n" + 
				"\r\n" + 
				"Na gut, das mit dem Fahrrad ist ja auch eher etwas für naive Idealisten. Sowieso viel zu anstrengend. Also steigt unser Schüler am nächsten Morgen besser in den Bus, wie er sich so denkt. Einfach aus der Haustür um die Ecke gelaufen, eingestiegen, bequem hingefahren, ausgestiegen, um die Ecke in die Schule, fertig. Tatsächlich funktioniert sein billiger Plan bis zur Haltestelle. Nun müsste um 32 der Bus erscheinen. Es wird 33, 35, 40 und kein Bus kommt. Eine mitwartende Dame erlöst sein Unverständnis dahingehend, der Bus sei bereits um 30 da gewesen. Schön, diese Überpünktlichkeit, sehr nützlich für Leute, die es noch eiliger hatten als unser Schüler. Endlich, da kommt der nächste Bus -- und fährt wegen Überfüllung einfach vorbei. Viele eine überzeugende Verspätungsentschuldigung konstruierende Gedankengänge später erscheint er um 52, der rettende nächste Bus. Eng ist´s darin, glitschig und stinkend, aber immerhin besser als laufen. Wenn jetzt an der vorletzten Haltestelle nicht noch ein Fahrerwechsel stattfinden würde, wäre unser armer Durchschnittsschüler schon um 08:10 Uhr rennend und schwitzend in seiner Schule angekommen, aber so dauert´s eben noch etwas länger; worauf es hinsichtlich des Grades der Schlimmheit schon nicht mehr ankommt.\r\n" + 
				"\r\n" + 
				"Ok, ist ja klar, wer fährt schon mit dem Bus. Das ist was für Leute, die endlos Zeit haben. Schüler dagegen haben´s immer eilig, ihre geliebte Schule nur ja überpünktlich zu erreichen. Am nächsten Morgen wird ein Elternteil männlicher Variante zwangsrekrutiert, seinen Nachwuchs standesgemäß im Mercedes 450 SEL 6,9 -- dem spießigen Garagenliebling des leider oftmals nicht weniger spießigen Herrn Obervaters -- zum Einsatzort zu chauffieren. Von einem solchen Auto darf wohl erwartet werden, dass man, kaum eingestiegen, auch schon wieder aussteigen kann, so schnell, komfortabel und ausgeruht sollte jedwedes Fahrtziel erreicht sein. Und nebenbei könnte man mit dieser Benzinschleuder zumindest vor seiner etwas bildungsferneren Mitschülerschaft ganz nett angeben, prognostiziert professionell unser ganz normaler Durchschnittsschüler. In dieser Überheblichkeit lässt er sich denn herab, auf dem Ledersofa im Heck Platz zu nehmen. Die Garage öffnet sich, der Luxusschlitten fährt vor -- und wird vom Müllwagen blockiert. Na gut, warten wir eben, die verlorene Zeit holen wir danach schon wieder rein. Nach vierminütiger konzentrierter Borduhr- Observation ist der Weg endlich frei. Sofort wird wird hektisch eingebogen, sogleich abgebogen und sofort -- angehalten. Denn der Ampelstau kennt im Berufsverkehr kein Erbarmen mit schicken Karren. Die Uhr erfährt eine Beachtung, um die sie manches Topmodel beneiden würde. Nach endlosen 11 Minuten ist der Weg endlich frei für den Chauffeur, die Kreuzung trotz Rotlichtes gerade noch unfallfrei passieren zu können. Und da ist sie auch schon, die nächste Ampelkreuzung. Die Autowracks des neuesten Unfalles liegen noch immer brennend herum, behindern den weiteren Schulweg in inakzeptabler Weise und verursachen den Verlust dreier weiterer Minuten. Der Durchschnittschüler rechnet schwitzend aus, dass die verbleibenden 800 Meter unter Berücksichtigung minimalst möglicher Beschleunigungszeit, maximalst wirkender Bremsanlage, explosionsartigen Aussteigens und raketenartigen Treppensteigens mit einer Geschwindigkeit von ca. 78 km/h zurückgelegt werden müssten, um heute noch pünktlich im Klassenzimmer zu erscheinen. Als jedoch ein Radfahrer mit seiner Jutetasche den rechten Aussenspiegel berührt und der Chauffeur außer Sinnes dem Auto entspringt, um den Schädiger zu verfolgen, vom Rad zu reißen und in dem offenkundigen Vorhaben, ihn zu lynchen ein paar letzte Worte mit ihm wechselt, bevor er allerdings von mehreren Passanten zu Boden geworfen wird, weiß unser Schüler : Es geht immer noch schlimmer. Diese Erkenntnis kostet ihn um 08:15 Uhr einen amtlichen Tadel seiner Lehrerin.\r\n" + 
				"\r\n" + 
				"So kann das nicht weitergehen, denkt sich unser Schüler. Am Ende würde es noch so weit kommen, zu Schule laufen zu müssen -- nein, das wäre das Ende. Am Ende des schlaflosen Schultages beschließt er -- zu allem entschlossen --, seinen entfernten Onkel, einen Piloten der Flugbereitschaft der Luftwaffe, anzurufen, um ihn zu bitten, auszuhelfen. Dieser Onkel legt seltsamerweise auf, nachdem er die Frage einfach nur mit einem Lachen beantwortet hat. Doch sogleich ereilt ihn ein rettender Einfall. \"In der Not hilft Dir Dein Freund und Helfer -- Deine Polizei\", hatte der Schüler mal in irgendeiner bescheuerten Schulsendung gehört. Er könnte doch morgen früh einfach bei den Bullen anrufen und behaupten, in seiner Schule sei ein Massaker geplant -- und nur er, der Durchschnittsschüler wisse, wie der Täter aussehe. Dann müssten nach seiner eiskalten Berechnung etwa fünf Minuten später mehrere Mannschaftswagen vor der Tür stehen, er könnte sich den schönsten zum Einsteigen aussuchen, sie würden gemeinsam mit Blaulicht nach wenigen Sekunden dort ankommen und er würde aussteigen und sich entschuldigen mit den Worten, er habe soeben bemerkt sich im Datum geirrt zu haben; eigentlich sei es schon für letzte Woche geplant gewesen, aber da ja bis heute gar nichts passiert sei, habe sich wohl jemand einen Scherz mit ihm erlaubt. Eine derart raffinierte Geschichte könnte ihm niemand verübeln; schließlich ist er noch ein unbescholtenes Kind, das weiß er genau.\r\n" + 
				"\r\n" + 
				"Gesagt, getan nach einer schlaflosen Nacht. Der Beamte am Telefon verhält sich jedoch unerwartet kritisch und legt besonderen Wert auf die Beantwortung der Frage nach dem Namen und der Adresse unseres Schülers. Wahrscheinlich nur damit sie wissen, wo sie klingeln sollen, denkt er noch bei sich, verschlingt kichernd ein paar Tüten Erdnussflips und wartet. Lange.\r\n" + 
				"\r\n" + 
				"Etwa eine Stunde später wird er von seinem ehemaligen Chauffeur äußerst ungehalten aus dem Schlafsessel gerissen und zur Rede gestellt. Es habe ein äußerst unangenehmes Gespräch mit dem Kontaktbereichsbeamten gegeben, das im Hinblick auf neuerdings neuartig aufzuziehende Erziehungssaiten zu äußerst unangenehmen Konsequenzen für seinen Sohn führen werde, verdeutlicht er, während er dessen Handy aus dem Fenster wirft. Unser Durchschnittsschüler, nicht sogleich sichtbar beeindruckt, zeigt sich erst einsichtig -- äußerst --, als die Musikanlage, der Fernseher, der PC, die Modellautosammlung und das coole zerlöcherte T-Shirt dem Handy folgen. Den Verlust des in den Laubhäcksler geratenen Shirts wird er in diesem Leben wohl kaum verkraften können, mutmaßt er schluchzend und schleppt sich schwitzend nach dem Ende der Generaldebatte mit letzter Kraft zu Fuß in sein Klassenzimmer. Zu allem Unglück hat er damit auch noch seine Wette verloren. Bis zum Ende seiner Schulzeit darf er nun bei jedem Wetter täglich hierher laufen; wie schrecklich schlimm.\r\n" + 
				"\r\n" + 
				"Am nächsten Morgen läuft er total normal los, zu nach seinem Empfinden nachtschlafender Zeit -- und kommt zu seiner eigenen Verwunderung seither nie wieder zu spät.\r\n" + 
				"\r\n" + 
				"- Beispiel Mediation -\r\n" + 
				"\r\n" + 
				"an das \"Evangelische Gebrauchtwarenhaus\"\r\n" + 
				"\r\n" + 
				"Leitung ...\r\n" + 
				"\r\n" + 
				"- via Telefax mehrfach -\r\n" + 
				"\r\n" + 
				"Reklamation eines defekten “Webpelzes”\r\n" + 
				"\r\n" + 
				"Sehr geehrte Frau P., sehr geehrter Herr M.;\r\n" + 
				"\r\n" + 
				"in o.a. Sache war von Ihrer Kundin, Frau M. aus ... Berlin, mehrfach erfolglos versucht worden, telefonisch mit Ihnen in klärenden Kontakt zu treten, weshalb nun um Intervention meinerseits gebeten wurde. Eine auf meinen Namen ausgestellte Bevollmächtigung erhalten Sie auf Anforderung unverzüglich.\r\n" + 
				"\r\n" + 
				"Am 11.07.2007 wurde in Ihren Geschäftsräumen u.a. ein sogenannter Webpelz, weiß, zum Verkaufspreis von 15,- € erworben (§ 433 I BGB). Auf dem Parkplatz wurde zufällig festgestellt, daß diese Jacke nicht etwa Staub, sondern vielmehr unablässig weiße, haarartige Flusen absonderte.\r\n" + 
				"\r\n" + 
				"Schon dieser Substanzverlust der Kaufsache stellt einen Mangel i.S. des § 434 I S. 2 Nr. 2 BGB dar, zusätzlich besteht Gesundheitsgefahr, daß die Haare beim Tragen der Jacke in die Atemluft gelangen.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Dieser der Käuferin bei Vertragsschluss unbekannte Mangel musste ihr nicht bekannt gewesen sein. Einerseits war sie zuvor vom Verkaufspersonal nicht auf den Mangel hingewiesen worden und andererseits besteht -- gerade bei regelmäßig nicht über spezielle Kenntnisse verfügenden Privatpersonen -- im Gegensatz zur Rechtsauffassung Ihrer leitenden Verkäuferin Christel keine naheliegende Verpflichtung, über das Maß normal sorgfältiger Warenprüfung hinausgehend etwa “vorher zupfen” (Zitat) zu müssen. Zudem sollen ausweislich ihrer in den Räumlichkeiten aushängenden Information sämtliche Wareneingänge von den eigens hierfür gemeinnützig beschäftigten behinderten Mitarbeitern sortiert und \"geprüft\" werden.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Es durfte folglich trotz des Gebrauchtwarencharakters von wesentlicher Mangelfreiheit ausgegangen werden.\r\n" + 
				"\r\n" + 
				"Ein Haftungsausschluß zu Ihren Gunsten existiert weder gesetzlich (z.B. § 445 BGB) noch mittels Allgemeiner Geschäftsbedingungen, er ergibt sich entgegen der Rechtsauffassung von Frau Christel auch nicht aus einem nach ihrer Ansicht geringen Verkaufspreis.\r\n" + 
				"\r\n" + 
				"Das Rücktrittsrecht (hier “Warenrückgabe / Geldrückgabe”) ergibt sich daher zulässig und begründet aus § 437 Nr. 2 BGB.\r\n" + 
				"\r\n" + 
				"Ich möchte Ihnen daher empfehlen, der Pflicht zur Vertragsrückabwicklung -- die sich in einem christlich orientierten Institut schon im Wege der Kulanz ergeben sollte -- unverzüglich nachzukommen. Schon zwei Male sollen von Ihrer mich beauftragenden Kundin gutgläubig Dinge gekauft worden sein (Fotoapparat, Uhrenradio), deren Defekte sich erst im Nachhinein herausstellten, jedoch unreklamiert blieben. Trotz aller verbliebenen Zufriedenheit mit Ihrer Verkaufsstätte werden Sie wohl kaum auf weiteres nachsichtiges Verständnis der Frau M. hoffen können, weshalb mangelnde positive Resonanz Ihrerseits nach dem 23.07.2007 zur Beauftragung der Rechtsanwaltssozietät (XY) zwecks Inanspruchnahme gerichtlichen Rechtsschutzes führen würde, wie sie mir versicherte.\r\n" + 
				"\r\n" + 
				"Das erscheint mir jedoch unnötig, da Ihnen die eindeutige Rechtslage sicher ohnehin bekannt sein dürfte. Bitte erwägen sie daher, in dieser Sache vorfristig einzulenken, um nicht zusätzliche Kosten entstehen zu lassen, die in keinem angemessenem Verhältnis zum Verkaufspreis des mangelhaften Artikels stünden.\r\n" + 
				"\r\n" + 
				"In der Hoffnung auf positive Resonanz verbleibe ich mit f reundlichem Gruße,\r\n" + 
				"\r\n" + 
				"(Mediator)\r\n" + 
				"\r\n" + 
				"Vier Tage später wurde der Pelz zurückgenommen.\r\n" + 
				"\r\n" + 
				"- Beispiel Verkaufs- Kleinanzeige -\r\n" + 
				"\r\n" + 
				"voll geile Vitrine;kein IKEA, keine Kommode, kein Auto, kein Gold\r\n" + 
				"\r\n" + 
				"Ey was los hier ?! Soll ich jetzt die Verwahrungskosten als Geschäftsführung ohne Auftrag allen potentiellen Käufern in Rechnung stellen, weil sie ganz vergessen haben, dass diese Vitrine zwangsweise zu kaufen ist ? Also los jetzt : Jetzt wird gekauft, bis das Auto / der Kreditrahmen platzt ! Ist doch alles für´n guten Zweck (Konjunkturbelebung -- Euro-Rettung -- Weltfrieden) -- Ausreden daher unstatthaft ! Wer diese Vitrine nicht will, hat nicht alle Schränke im Zimmer !! Nun los schon -- zum Nachtisch schnell ein kleines Vitrinchen to go in die Tasche gestopft ! Endlich alle selbstgebastelten Papierschiffe, defekten Weckerradios und antiken Brotscheiben eindrucksvoll der ganzen Welt präsentieren -- alle werden geschockt sein ! Denn durch die in die Tür integrierte e c h t durchsichtige Plexiglasscheibe bleibt der Vitrineninhalt sogar sichtbar ! Dank Beleuchtung kann nicht einmal die unliebsame Dunkelheit den Inhalt verschwinden lassen ! Und im unteren, uneinsehbaren Vitrinenteil können beruhigt die gehorteten Rolex- und Altgoldbestände aufbewahrt werden -- weiß ja niemand (= daher fast einbruchsicher) ! Also Widerstand zwecklos ! Alles sofort fallen, stehen und liegen lassen, hinrennen, Geldsack herwerfen,Vitrine abgrapschen, nach Hause schleppen -- und den Rest des Lebens damit GLÜCKLICH sein !\r\n" + 
				"Ok -- für alle, denen Geld wichtiger ist als Glück : Die Vitrine kann auch im Wege der Aktienmehrheitsübernahme erworben werden ! Auf Wunsch werden 10 rezessionsfeste Aktienanteile der Vitrine ausgegeben, deren Rückkauf garantiert ausgeschlossen ist ! Stellt Euch vor, was die in ein paar Jahren renditemäßig wert sind – auch wenn´s die Vitrine längst schon nicht mehr gibt ...\r\n" + 
				"Vitrine Buche, mit Beleuchtung, ca. 8 Jahre alt; drei Glaseinlegeböden oben sowie unten ein separates Fach; Glasspiegelrückwand; bruchsicheres Plexiglas in der Tür. Tür massives Vollholz, Rest Furnier. Ca. 220h x 50b x 40t. Guter Zustand.\r\n" + 
				"Bitte schaut Euch auch meine anderen Angebote an.\r\n" + 
				"Danke !";		//text = "AZ";
		String e =enc.encrypt(text);
		System.out.println(e);
		//enc.frequency(text);
		//Character[] array2 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		//enc.setKey(Arrays.asList(array2));
		//System.out.println("-----decypt-----");
		//String d = enc.decrypt(e);
		//System.out.println(d);
		System.out.println("-----decypt estimste-----");
		enc.setKey(enc.estimateKey(e));
		//enc.swapLetters('C', 'B');
		String de =enc.decrypt(e);
		System.out.println(de);
		
		launch(args);
	}
}
