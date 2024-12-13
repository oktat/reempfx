package lan.zold.models;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* A fájl mentését megvalósító osztály */
public class FileHandler {
  /* Fájl mentése */
  public void w(Employee employee) {
    /*
     * A fájlt hibakezeléssel láttuk el, hogy legyen
     * normális kimenet, amit könnyen meg lehet érteni.
     */
    try {
      FileWriter fw = new FileWriter("test.txt", true);
      PrintWriter pw = new PrintWriter(fw);
      pw.print(employee.id); //Az id kiírása
      pw.print(":"); //Kettőspont kiírása
      pw.print(employee.name); //A név kiírása
      pw.print(":"); //Kettőspont kiírása
      pw.print(employee.city); //A helység kiírása
      pw.print(":"); //Kettőspont kiírása
      pw.println(employee.salary); //A fizetés kiírása
      /* Éredems mindkét objektumot lezárni */
      pw.close();
      fw.close();
    } catch (FileNotFoundException e) {
      System.err.println("Hiba! A fájl nem található!");
      System.err.println(e.getMessage());   
    } catch (IOException e) {
      System.err.println("Hiba! A fájl írása sikertelen!");
      System.err.println(e.getMessage());
    }// end try
  }
}
