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
		String text = "An einem ganz normalen Schultag beabsichtigt unser ganz normaler Durchschnittssch�ler, morgens mit dem Fahrrad zur Schule zu fahren.\r\n" + 
				"\r\n" + 
				"Ganz so normal ist dieser Tag nun doch nicht, denn es ist der erste Tag einer Woche, in der aufgrund einer verabredeten Wette testweise der Schulweg mit verschiedenen Verkehrsmitteln zur�ckgelegt werden soll, um zu beweisen -- nach Ansicht unseres wettenden Sch�lers zu widerlegen --, dass Wege unter zwei Kilometern L�nge vorzugsweise zu Fu� zur�ckzulegen sein sollten. Ist nat�rlich v�lliger Unsinn, wie unser selbstbewusster Sch�ler meint, selbstverst�ndlich ist ein Fahrzeug jedweder Art f�r moderne Sch�ler unverzichtbar, weil normale F��e viel zu langsam laufen.\r\n" + 
				"\r\n" + 
				"In dieser siegesgewissen Sicherheit steigt er also auf und f�hrt los, w�hrend es beginnt zu regnen. Macht nichts, sind ja nur ein paar Tropfen. Auf dem Gehweg fahrend wird er von einer schrecklich hysterischen Oma verscheucht und f�hrt nun weiter auf der Fahrbahn, was er eigentlich vermeiden wollte, weil dort die Autos so dicht vorbeirasen. Im dichten Abgasmeer dahinkeuchend f�llt ihm zu sp�t eine wohl des nachts mutwillig zerbrochene Bierflasche auf, deren Reste er notgedrungen �berf�hrt. Macht aber nichts, wird schon gutgehen, wie immer. Ein besonders eiliger LKW �berholt noch schnell, bevor er rechts abbiegt und unseren Sch�ler fast begr�bt, der sich jedoch mittels eines schnellen Sprunges auf den Gehweg retten kann, bevor sein Fahrrad unter den schweren Reifen verendet. Da steht er nun, schwitzend, durchn�sst; und sein Fahrrad h�tte sogar noch einen Platten gehabt, wenn es denn noch lebte. Und er kommt -- schlimm -- zu sp�t zum Unterricht.\r\n" + 
				"\r\n" + 
				"Na gut, das mit dem Fahrrad ist ja auch eher etwas f�r naive Idealisten. Sowieso viel zu anstrengend. Also steigt unser Sch�ler am n�chsten Morgen besser in den Bus, wie er sich so denkt. Einfach aus der Haust�r um die Ecke gelaufen, eingestiegen, bequem hingefahren, ausgestiegen, um die Ecke in die Schule, fertig. Tats�chlich funktioniert sein billiger Plan bis zur Haltestelle. Nun m�sste um 32 der Bus erscheinen. Es wird 33, 35, 40 und kein Bus kommt. Eine mitwartende Dame erl�st sein Unverst�ndnis dahingehend, der Bus sei bereits um 30 da gewesen. Sch�n, diese �berp�nktlichkeit, sehr n�tzlich f�r Leute, die es noch eiliger hatten als unser Sch�ler. Endlich, da kommt der n�chste Bus -- und f�hrt wegen �berf�llung einfach vorbei. Viele eine �berzeugende Versp�tungsentschuldigung konstruierende Gedankeng�nge sp�ter erscheint er um 52, der rettende n�chste Bus. Eng ist�s darin, glitschig und stinkend, aber immerhin besser als laufen. Wenn jetzt an der vorletzten Haltestelle nicht noch ein Fahrerwechsel stattfinden w�rde, w�re unser armer Durchschnittssch�ler schon um 08:10 Uhr rennend und schwitzend in seiner Schule angekommen, aber so dauert�s eben noch etwas l�nger; worauf es hinsichtlich des Grades der Schlimmheit schon nicht mehr ankommt.\r\n" + 
				"\r\n" + 
				"Ok, ist ja klar, wer f�hrt schon mit dem Bus. Das ist was f�r Leute, die endlos Zeit haben. Sch�ler dagegen haben�s immer eilig, ihre geliebte Schule nur ja �berp�nktlich zu erreichen. Am n�chsten Morgen wird ein Elternteil m�nnlicher Variante zwangsrekrutiert, seinen Nachwuchs standesgem�� im Mercedes 450 SEL 6,9 -- dem spie�igen Garagenliebling des leider oftmals nicht weniger spie�igen Herrn Obervaters -- zum Einsatzort zu chauffieren. Von einem solchen Auto darf wohl erwartet werden, dass man, kaum eingestiegen, auch schon wieder aussteigen kann, so schnell, komfortabel und ausgeruht sollte jedwedes Fahrtziel erreicht sein. Und nebenbei k�nnte man mit dieser Benzinschleuder zumindest vor seiner etwas bildungsferneren Mitsch�lerschaft ganz nett angeben, prognostiziert professionell unser ganz normaler Durchschnittssch�ler. In dieser �berheblichkeit l�sst er sich denn herab, auf dem Ledersofa im Heck Platz zu nehmen. Die Garage �ffnet sich, der Luxusschlitten f�hrt vor -- und wird vom M�llwagen blockiert. Na gut, warten wir eben, die verlorene Zeit holen wir danach schon wieder rein. Nach viermin�tiger konzentrierter Borduhr- Observation ist der Weg endlich frei. Sofort wird wird hektisch eingebogen, sogleich abgebogen und sofort -- angehalten. Denn der Ampelstau kennt im Berufsverkehr kein Erbarmen mit schicken Karren. Die Uhr erf�hrt eine Beachtung, um die sie manches Topmodel beneiden w�rde. Nach endlosen 11 Minuten ist der Weg endlich frei f�r den Chauffeur, die Kreuzung trotz Rotlichtes gerade noch unfallfrei passieren zu k�nnen. Und da ist sie auch schon, die n�chste Ampelkreuzung. Die Autowracks des neuesten Unfalles liegen noch immer brennend herum, behindern den weiteren Schulweg in inakzeptabler Weise und verursachen den Verlust dreier weiterer Minuten. Der Durchschnittsch�ler rechnet schwitzend aus, dass die verbleibenden 800 Meter unter Ber�cksichtigung minimalst m�glicher Beschleunigungszeit, maximalst wirkender Bremsanlage, explosionsartigen Aussteigens und raketenartigen Treppensteigens mit einer Geschwindigkeit von ca. 78 km/h zur�ckgelegt werden m�ssten, um heute noch p�nktlich im Klassenzimmer zu erscheinen. Als jedoch ein Radfahrer mit seiner Jutetasche den rechten Aussenspiegel ber�hrt und der Chauffeur au�er Sinnes dem Auto entspringt, um den Sch�diger zu verfolgen, vom Rad zu rei�en und in dem offenkundigen Vorhaben, ihn zu lynchen ein paar letzte Worte mit ihm wechselt, bevor er allerdings von mehreren Passanten zu Boden geworfen wird, wei� unser Sch�ler : Es geht immer noch schlimmer. Diese Erkenntnis kostet ihn um 08:15 Uhr einen amtlichen Tadel seiner Lehrerin.\r\n" + 
				"\r\n" + 
				"So kann das nicht weitergehen, denkt sich unser Sch�ler. Am Ende w�rde es noch so weit kommen, zu Schule laufen zu m�ssen -- nein, das w�re das Ende. Am Ende des schlaflosen Schultages beschlie�t er -- zu allem entschlossen --, seinen entfernten Onkel, einen Piloten der Flugbereitschaft der Luftwaffe, anzurufen, um ihn zu bitten, auszuhelfen. Dieser Onkel legt seltsamerweise auf, nachdem er die Frage einfach nur mit einem Lachen beantwortet hat. Doch sogleich ereilt ihn ein rettender Einfall. \"In der Not hilft Dir Dein Freund und Helfer -- Deine Polizei\", hatte der Sch�ler mal in irgendeiner bescheuerten Schulsendung geh�rt. Er k�nnte doch morgen fr�h einfach bei den Bullen anrufen und behaupten, in seiner Schule sei ein Massaker geplant -- und nur er, der Durchschnittssch�ler wisse, wie der T�ter aussehe. Dann m�ssten nach seiner eiskalten Berechnung etwa f�nf Minuten sp�ter mehrere Mannschaftswagen vor der T�r stehen, er k�nnte sich den sch�nsten zum Einsteigen aussuchen, sie w�rden gemeinsam mit Blaulicht nach wenigen Sekunden dort ankommen und er w�rde aussteigen und sich entschuldigen mit den Worten, er habe soeben bemerkt sich im Datum geirrt zu haben; eigentlich sei es schon f�r letzte Woche geplant gewesen, aber da ja bis heute gar nichts passiert sei, habe sich wohl jemand einen Scherz mit ihm erlaubt. Eine derart raffinierte Geschichte k�nnte ihm niemand ver�beln; schlie�lich ist er noch ein unbescholtenes Kind, das wei� er genau.\r\n" + 
				"\r\n" + 
				"Gesagt, getan nach einer schlaflosen Nacht. Der Beamte am Telefon verh�lt sich jedoch unerwartet kritisch und legt besonderen Wert auf die Beantwortung der Frage nach dem Namen und der Adresse unseres Sch�lers. Wahrscheinlich nur damit sie wissen, wo sie klingeln sollen, denkt er noch bei sich, verschlingt kichernd ein paar T�ten Erdnussflips und wartet. Lange.\r\n" + 
				"\r\n" + 
				"Etwa eine Stunde sp�ter wird er von seinem ehemaligen Chauffeur �u�erst ungehalten aus dem Schlafsessel gerissen und zur Rede gestellt. Es habe ein �u�erst unangenehmes Gespr�ch mit dem Kontaktbereichsbeamten gegeben, das im Hinblick auf neuerdings neuartig aufzuziehende Erziehungssaiten zu �u�erst unangenehmen Konsequenzen f�r seinen Sohn f�hren werde, verdeutlicht er, w�hrend er dessen Handy aus dem Fenster wirft. Unser Durchschnittssch�ler, nicht sogleich sichtbar beeindruckt, zeigt sich erst einsichtig -- �u�erst --, als die Musikanlage, der Fernseher, der PC, die Modellautosammlung und das coole zerl�cherte T-Shirt dem Handy folgen. Den Verlust des in den Laubh�cksler geratenen Shirts wird er in diesem Leben wohl kaum verkraften k�nnen, mutma�t er schluchzend und schleppt sich schwitzend nach dem Ende der Generaldebatte mit letzter Kraft zu Fu� in sein Klassenzimmer. Zu allem Ungl�ck hat er damit auch noch seine Wette verloren. Bis zum Ende seiner Schulzeit darf er nun bei jedem Wetter t�glich hierher laufen; wie schrecklich schlimm.\r\n" + 
				"\r\n" + 
				"Am n�chsten Morgen l�uft er total normal los, zu nach seinem Empfinden nachtschlafender Zeit -- und kommt zu seiner eigenen Verwunderung seither nie wieder zu sp�t.\r\n" + 
				"\r\n" + 
				"- Beispiel Mediation -\r\n" + 
				"\r\n" + 
				"an das \"Evangelische Gebrauchtwarenhaus\"\r\n" + 
				"\r\n" + 
				"Leitung ...\r\n" + 
				"\r\n" + 
				"- via Telefax mehrfach -\r\n" + 
				"\r\n" + 
				"Reklamation eines defekten �Webpelzes�\r\n" + 
				"\r\n" + 
				"Sehr geehrte Frau P., sehr geehrter Herr M.;\r\n" + 
				"\r\n" + 
				"in o.a. Sache war von Ihrer Kundin, Frau M. aus ... Berlin, mehrfach erfolglos versucht worden, telefonisch mit Ihnen in kl�renden Kontakt zu treten, weshalb nun um Intervention meinerseits gebeten wurde. Eine auf meinen Namen ausgestellte Bevollm�chtigung erhalten Sie auf Anforderung unverz�glich.\r\n" + 
				"\r\n" + 
				"Am 11.07.2007 wurde in Ihren Gesch�ftsr�umen u.a. ein sogenannter Webpelz, wei�, zum Verkaufspreis von 15,- � erworben (� 433 I BGB). Auf dem Parkplatz wurde zuf�llig festgestellt, da� diese Jacke nicht etwa Staub, sondern vielmehr unabl�ssig wei�e, haarartige Flusen absonderte.\r\n" + 
				"\r\n" + 
				"Schon dieser Substanzverlust der Kaufsache stellt einen Mangel i.S. des � 434 I S. 2 Nr. 2 BGB dar, zus�tzlich besteht Gesundheitsgefahr, da� die Haare beim Tragen der Jacke in die Atemluft gelangen.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Dieser der K�uferin bei Vertragsschluss unbekannte Mangel musste ihr nicht bekannt gewesen sein. Einerseits war sie zuvor vom Verkaufspersonal nicht auf den Mangel hingewiesen worden und andererseits besteht -- gerade bei regelm��ig nicht �ber spezielle Kenntnisse verf�genden Privatpersonen -- im Gegensatz zur Rechtsauffassung Ihrer leitenden Verk�uferin Christel keine naheliegende Verpflichtung, �ber das Ma� normal sorgf�ltiger Warenpr�fung hinausgehend etwa �vorher zupfen� (Zitat) zu m�ssen. Zudem sollen ausweislich ihrer in den R�umlichkeiten aush�ngenden Information s�mtliche Wareneing�nge von den eigens hierf�r gemeinn�tzig besch�ftigten behinderten Mitarbeitern sortiert und \"gepr�ft\" werden.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Es durfte folglich trotz des Gebrauchtwarencharakters von wesentlicher Mangelfreiheit ausgegangen werden.\r\n" + 
				"\r\n" + 
				"Ein Haftungsausschlu� zu Ihren Gunsten existiert weder gesetzlich (z.B. � 445 BGB) noch mittels Allgemeiner Gesch�ftsbedingungen, er ergibt sich entgegen der Rechtsauffassung von Frau Christel auch nicht aus einem nach ihrer Ansicht geringen Verkaufspreis.\r\n" + 
				"\r\n" + 
				"Das R�cktrittsrecht (hier �Warenr�ckgabe / Geldr�ckgabe�) ergibt sich daher zul�ssig und begr�ndet aus � 437 Nr. 2 BGB.\r\n" + 
				"\r\n" + 
				"Ich m�chte Ihnen daher empfehlen, der Pflicht zur Vertragsr�ckabwicklung -- die sich in einem christlich orientierten Institut schon im Wege der Kulanz ergeben sollte -- unverz�glich nachzukommen. Schon zwei Male sollen von Ihrer mich beauftragenden Kundin gutgl�ubig Dinge gekauft worden sein (Fotoapparat, Uhrenradio), deren Defekte sich erst im Nachhinein herausstellten, jedoch unreklamiert blieben. Trotz aller verbliebenen Zufriedenheit mit Ihrer Verkaufsst�tte werden Sie wohl kaum auf weiteres nachsichtiges Verst�ndnis der Frau M. hoffen k�nnen, weshalb mangelnde positive Resonanz Ihrerseits nach dem 23.07.2007 zur Beauftragung der Rechtsanwaltssoziet�t (XY) zwecks Inanspruchnahme gerichtlichen Rechtsschutzes f�hren w�rde, wie sie mir versicherte.\r\n" + 
				"\r\n" + 
				"Das erscheint mir jedoch unn�tig, da Ihnen die eindeutige Rechtslage sicher ohnehin bekannt sein d�rfte. Bitte erw�gen sie daher, in dieser Sache vorfristig einzulenken, um nicht zus�tzliche Kosten entstehen zu lassen, die in keinem angemessenem Verh�ltnis zum Verkaufspreis des mangelhaften Artikels st�nden.\r\n" + 
				"\r\n" + 
				"In der Hoffnung auf positive Resonanz verbleibe ich mit f reundlichem Gru�e,\r\n" + 
				"\r\n" + 
				"(Mediator)\r\n" + 
				"\r\n" + 
				"Vier Tage sp�ter wurde der Pelz zur�ckgenommen.\r\n" + 
				"\r\n" + 
				"- Beispiel Verkaufs- Kleinanzeige -\r\n" + 
				"\r\n" + 
				"voll geile Vitrine;kein IKEA, keine Kommode, kein Auto, kein Gold\r\n" + 
				"\r\n" + 
				"Ey was los hier ?! Soll ich jetzt die Verwahrungskosten als Gesch�ftsf�hrung ohne Auftrag allen potentiellen K�ufern in Rechnung stellen, weil sie ganz vergessen haben, dass diese Vitrine zwangsweise zu kaufen ist ? Also los jetzt : Jetzt wird gekauft, bis das Auto / der Kreditrahmen platzt ! Ist doch alles f�r�n guten Zweck (Konjunkturbelebung -- Euro-Rettung -- Weltfrieden) -- Ausreden daher unstatthaft ! Wer diese Vitrine nicht will, hat nicht alle Schr�nke im Zimmer !! Nun los schon -- zum Nachtisch schnell ein kleines Vitrinchen to go in die Tasche gestopft ! Endlich alle selbstgebastelten Papierschiffe, defekten Weckerradios und antiken Brotscheiben eindrucksvoll der ganzen Welt pr�sentieren -- alle werden geschockt sein ! Denn durch die in die T�r integrierte e c h t durchsichtige Plexiglasscheibe bleibt der Vitrineninhalt sogar sichtbar ! Dank Beleuchtung kann nicht einmal die unliebsame Dunkelheit den Inhalt verschwinden lassen ! Und im unteren, uneinsehbaren Vitrinenteil k�nnen beruhigt die gehorteten Rolex- und Altgoldbest�nde aufbewahrt werden -- wei� ja niemand (= daher fast einbruchsicher) ! Also Widerstand zwecklos ! Alles sofort fallen, stehen und liegen lassen, hinrennen, Geldsack herwerfen,Vitrine abgrapschen, nach Hause schleppen -- und den Rest des Lebens damit GL�CKLICH sein !\r\n" + 
				"Ok -- f�r alle, denen Geld wichtiger ist als Gl�ck : Die Vitrine kann auch im Wege der Aktienmehrheits�bernahme erworben werden ! Auf Wunsch werden 10 rezessionsfeste Aktienanteile der Vitrine ausgegeben, deren R�ckkauf garantiert ausgeschlossen ist ! Stellt Euch vor, was die in ein paar Jahren renditem��ig wert sind � auch wenn�s die Vitrine l�ngst schon nicht mehr gibt ...\r\n" + 
				"Vitrine Buche, mit Beleuchtung, ca. 8 Jahre alt; drei Glaseinlegeb�den oben sowie unten ein separates Fach; Glasspiegelr�ckwand; bruchsicheres Plexiglas in der T�r. T�r massives Vollholz, Rest Furnier. Ca. 220h x 50b x 40t. Guter Zustand.\r\n" + 
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
