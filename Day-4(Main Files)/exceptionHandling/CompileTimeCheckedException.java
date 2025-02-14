package com.day4.exceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTimeCheckedException {
    public static void main(String[] args) {
        String filename="Read.txt";
        //code inside the try block
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filename));
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }
        //handle the exception by catch block
        catch (FileNotFoundException e){
            System.out.println("File not found exception: "+e.getMessage());
        }
        catch (IOException e){
            System.out.println("An error occured while reading the file: "+ e.getMessage());
        }

    }
}