import dao.AutorDAO;
import dao.AutorDAOSimple;
import dao.BuchDAO;
import dao.BuchDAOSimple;
import models.Book;

import java.util.List;
import java.util.Scanner;

public class BuecherSimple {
   static Scanner sc = new Scanner(System.in);
   
   static BuchDAO buchData = new BuchDAOSimple();
   static AutorDAO autorData = new AutorDAOSimple();
   
   public static void main(String[] args) {
      
      while( true ) {
         showMenu();
         
         String s = sc.nextLine();
         int choice = 0;
         
         try{
            choice =  Integer.parseInt(s);
            }
         catch(NumberFormatException n) {
            System.out.println("Falsche Eingabe: " + s);
            continue;
         }
         
         if( choice==9 )         
            break;
         
         switch (choice) {
         case 1:
            alleAutoren();
            break;
         case 2:
            alleBuecherTitel();
            break;
         case 3:
            alleBuecherAutor();
            break;
         case 4:
            neuesBuch();
            break;
         case 5:
            aendereBuch();
            break;
         case 6:
            loescheBuch();
            break;
         //...
         default:
            System.out.println("Falsche Eingabe: " + choice);
            break;
         }
      }
      System.out.println("Programmende. Besuchen Sie uns wieder ...");
   }
   
   private static void showMenu() {
      System.out.println("B U C H V E R W A L T U N G");
      System.out.println("---------------------------");
      System.out.println("Bitte wählen Sie aus (Zahl eingeben):\n");
      System.out.println("Alle Autoren anzeigen:                1");
      System.out.println("Alle Bücher anzeigen (nach Titel):    2");
      System.out.println("Alle Bücher anzeigen (nach Autoren):  3");
      System.out.println("Neues models.Book erfassen:                  4");
      System.out.println("models.Book ändern:                          5");
      System.out.println("models.Book löschen:                         6");
      System.out.println("\nProgramm beenden:                     9");
      System.out.print("\nIhre Auswahl: ");
   }
   
   private static void alleBuecherTitel() {
      System.out.println("\nnoch zu implementieren: alle Bücher anzeigen\n");
   }
   private static void alleBuecherAutor() {
      System.out.println("\nnoch zu implementieren: alle Bücher anzeigen\n");
   }
   private static void alleAutoren() {
      System.out.println("\nnoch zu implementieren: alle Autoren anzeigen\n");
   }
   private static void aendereBuch() {
      System.out.println("\nnoch zu implementieren: alle Bücher anzeigen\n");
   }
   private static void loescheBuch() {
      System.out.println("\nnoch zu implementieren: alle Bücher anzeigen\n");
   }
   private static void neuesBuch() {
      int bid=1;
      //automatisch Ermitteln: um 1 grösser als bisher erfasste grösste bid
      List<Book> buecher = buchData.getAll();
      for( Book b : buecher ) {
         if( b.getBookId()>= bid )
            bid = b.getBookId()+1;
      }
      
      //Titel abfragen
      String titel;
      while(true) {
         System.out.print("Bitte geben Sie einen Titel ein: ");
         titel = sc.nextLine().trim();
         if( titel.length()==0 )
            System.out.println("Falsche Eingabe. (Leerstring)");
         else
            break;
      }
      //Jahr abfragen
      int jahr;
      while(true) {
         System.out.print("Bitte geben Sie das Erscheinungsjahr ein: ");
         String jahrString = sc.nextLine().trim();
         try {
            jahr = Integer.parseInt( jahrString );
            break;
         } catch( NumberFormatException n) {
            System.out.println("Falsche Eingabe. Bitte Jahr als Zahl eingeben.");
         }
      }
      
    //Ort abfragen
      String ort="";
      
      Book b = new Book( bid, titel, jahr, ort);
      
      
     //Autoren abfragen (aus Autorenliste)
      // autorData.getAll()
      // mehrfach möglich
      //
      // b.addAuthor( a );
      //models.Book via dao persistieren
      buchData.insert( b );
      
      System.out.println("models.Book '" + b + "' erfolgreich erfasst.");
   }
}
