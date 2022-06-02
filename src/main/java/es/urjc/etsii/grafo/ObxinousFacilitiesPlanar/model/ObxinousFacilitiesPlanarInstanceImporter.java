package es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.model;

import es.urjc.etsii.grafo.io.InstanceImporter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ObxinousFacilitiesPlanarInstanceImporter extends InstanceImporter<ObxinousFacilitiesPlanarInstance> {

    @Override
    public ObxinousFacilitiesPlanarInstance importInstance(BufferedReader reader, String filename) throws IOException {
        // Create and return instance object from file data
        // TODO parse all data from the given reader however I want
        // TIP You may use a Scanner if you prefer it to a Buffered Reader:
        // Scanner sc = new Scanner(reader);
        Scanner sc = new Scanner(reader);
        String type = sc.nextLine().split("=")[1].trim();
        int n = Integer.parseInt(sc.nextLine().split("=")[1].trim());
        int m = Integer.parseInt(sc.nextLine().split("=")[1].trim());
        int p = Integer.parseInt(sc.nextLine().split("=")[1].trim());
        double [][] table = new double[n][m];
        String line = "";
        while(sc.hasNextLine() && !line.contains(type)){
            line = sc.nextLine();
        }
        int i = 0;
        line = "";
        while (sc.hasNextLine() && i < n){
            do{
                line = line.concat(sc.nextLine());
            }while(!line.contains("}"));
            String[] row = line.replaceAll("[{},]"," ").trim().split(" ");
            for (int j = 0; j< row.length; j++){
                table[i][j] = Double.parseDouble(row[j]);
            }
            if (i == n){
                i = 0 ;
            }else{
                i++;
            }
            line = "";
        }
        for (int l = 0; l< n; l++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Fila: " + l + "Columna: " + j + " " + table[l][j]);
            }
        }
        var instance = new ObxinousFacilitiesPlanarInstance(filename, n, m ,p, table);

        // IMPORTANT! Remember that instance data must be immutable from this point
        return instance;
    }
}
