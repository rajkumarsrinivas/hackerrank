package com.rajkumar.misc;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileParser {

    List<String> orc = new ArrayList<>(350000);
    List<String> extra_es = new ArrayList<>(100000);

    public void parse(FileReader fr) throws IOException {
        String line = null;

        BufferedReader bufferedReader =
                new BufferedReader(fr);

        while((line = bufferedReader.readLine()) != null) {
            orc.add(line);
        }

        bufferedReader.close();
        fr.close();
    }

    public void compare(FileReader fr, FileWriter fw) throws IOException {
        String line = null;

        FileWriter fw_orc=new FileWriter("C:\\Users\\rajsrin2\\Downloads\\output-oracle.csv");

        BufferedReader bufferedReader =
                new BufferedReader(fr);

        while((line = bufferedReader.readLine()) != null) {
                if(orc.contains(line)) {
                   orc.remove(line);
                } else {
                    fw.write(line+"\n");
                }
        }

        for(String sr: orc) {
            fw_orc.write(sr+"\n");
        }
        bufferedReader.close();
        fr.close();
        fw.close();
        fw_orc.close();
    }

    public static void main(String[] args) {
        FileParser p = new FileParser();
        FileReader fr=null;
        try
        {
            FileWriter fw=new FileWriter("C:\\Users\\rajsrin2\\Downloads\\output-license.csv");


            fr = new FileReader("C:\\Users\\rajsrin2\\Downloads\\oracle.csv");
            p.parse(fr);

            fr = new FileReader("C:\\Users\\rajsrin2\\Downloads\\oracle-2.csv");
            p.parse(fr);

            fr = new FileReader("C:\\Users\\rajsrin2\\Downloads\\oracle-3.csv");
            p.parse(fr);

            fr = new FileReader("C:\\Users\\rajsrin2\\Downloads\\oracle-4.csv");
            p.parse(fr);

            fr = new FileReader("C:\\Users\\rajsrin2\\Downloads\\oracle-5.csv");
            p.parse(fr);

            fr = new FileReader("C:\\Users\\rajsrin2\\Downloads\\elastic.csv");
            p.compare(fr , fw);

            fw.close();
        }
        catch (IOException foe)
        {
            System.out.println("File not found");
        }



        // close the file
    }
}
