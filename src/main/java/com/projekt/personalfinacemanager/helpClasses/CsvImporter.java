package com.projekt.personalfinacemanager.helpClasses;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.projekt.personalfinacemanager.model.Transaktion;

import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvImporter {

   public static void readDataLineByLine(String file){
       try{
           FileReader fileReader = new FileReader(file);

              CSVReader csvReader = new CSVReader(fileReader);
              String[] nextRecord;

                while ((nextRecord = csvReader.readNext()) != null) {
                    for (String cell : nextRecord) {

                    }

           System.out.println();
                }
       }catch(Exception e){
           e.printStackTrace();
       }
   }

   public static void readAllDataAtOnce(String file){
       try{
           FileReader fileReader = new FileReader(file);

           CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();

              List<String[]> allData = csvReader.readAll();

              for (String[] row : allData){
                  for (String cell : row){

                  }
                  System.out.println();
              }


       }catch (Exception e){
           e.printStackTrace();
       }
   }
   public static List<Transaktion> readDataWithCustomSeparator(String file){
        List<Transaktion> transaktionListe = new ArrayList<>();
       DateTimeFormatter datumsFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
       try {
           FileReader fileReader = new FileReader(file);

           CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

              CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();

              List<String[]> allData = csvReader.readAll();

              for (String[] row : allData) {

                  if (row[4].contains("Buchungstag")) {
                      continue;
                  }

                  try {


                  LocalDate datum = LocalDate.parse(row[4], datumsFormat);

                  String name = row[6];
                  String zweck = row[10];
                  String beschreibung = (name.isEmpty() ? "Unbekannt" : name) + " | " + zweck;

                  if (beschreibung.length() > 250) {
                      beschreibung = beschreibung.substring(0, 250);
                  }

                  String betragString = row[11].replace(".", "").replace(",", ".");
                  BigDecimal betrag = new BigDecimal(betragString);

                  String typ = betrag.compareTo(BigDecimal.ZERO) < 0 ? "Ausgabe" : "Einnahme";

                  Transaktion t = new Transaktion(betrag, beschreibung, datum, typ, null);
                  transaktionListe.add(t);


                    } catch (Exception e) {
                        System.out.println("Fehler beim Verarbeiten der Zeile: " + String.join(";", row));
                        e.printStackTrace();
                    }

              }
       } catch (Exception e) {
              e.printStackTrace();
       }


return transaktionListe;
   }

}
