package com.rajkumar.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Comparison {

    public static void main(String[] args) {
        File dir = new File("C:\\Users\\rajsrin2\\workspace\\me\\mce\\logstash6-eb-config\\configs\\templates\\uee");
        for(File file : dir.listFiles((x , n) -> n.toLowerCase().endsWith(".sql") && n.toLowerCase().startsWith("eam-devices-licenses-duplicate-batch"))) {
            System.out.print(file.getName().replace("eam-devices-licenses-duplicate-batch", "").replace(".sql", "")+",");

            try (Scanner f = new Scanner(file)) {
                while (f.hasNextLine()) {
                    String line = f.nextLine();
                    if(line.startsWith("FROM eblic.xxlic_device_Dim WHERE DEVICE_SOURCE_REF_ID between")) {
                        String[] s = line.split("FROM eblic.xxlic_device_Dim WHERE DEVICE_SOURCE_REF_ID between")[1].split(" and ");
                        for(String s1 : s) {
                            System.out.print(s1.trim()+",");
                        }
                        System.out.println();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
