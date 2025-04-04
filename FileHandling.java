import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        String filename="sample.txt";
        //writing to a file
        System.out.println("enter the text to write to the file: ");
        String content=sc.nextLine();
        writeToFile(filename,content);

        //reading the file
        readFromFile(filename);

        //modifying the file
        System.out.println("enter the word to replace: ");
        String oldword=sc.next();
        System.out.println("enter the new word: ");
        String newword=sc.next();
        modifyFile(filename,oldword,newword);

        //reading the modified file
        readFromFile(filename);
        sc.close();
    }
    public static void writeToFile(String filename, String content) throws IOException{
        FileWriter fw= new FileWriter(filename);
        fw.write(content);
        fw.close();
        System.out.println("text wriiten successfully!");
    }
    public static void readFromFile(String filename) throws IOException{
        BufferedReader br= new BufferedReader(new FileReader(filename));
        String line=new String();
        while((line=br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
    public static void modifyFile(String filename, String oldword, String newword) throws IOException{
        BufferedReader br= new BufferedReader(new FileReader(filename));
        String content=new String(), line;
        while((line=br.readLine()) != null){
            content += line.replaceAll(oldword,newword) +"\n";
        }
        br.close();

        FileWriter fw= new FileWriter(filename);
        fw.write(content);
        fw.close();
        System.out.println("file modified successfully!");
    }
    
}
