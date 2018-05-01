package com.twofivezeroone;

import java.io.*;

public class CustomTaskHandler implements CustomRunnableTask {


    @Override
    public void largeForLoop() {

    }

    @Override
    public void readAndWrite() {
        write();
        read();
    }

    private void write() {
        // The name of the file to open.
        String fileName = "temp.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            print("Writing");
            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            print("Writing exception");
            ex.printStackTrace();
        }
    }

    private void read() {
        // The name of the file to open.
        String fileName = "temp.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            print("Reading start");
            while((line = bufferedReader.readLine()) != null) {
                print("Read line : " + line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (Exception ignored) {
            print("Reading exception");
        }
    }

    private void print(String data) {
        System.out.println("Log : " + data);
    }
}
