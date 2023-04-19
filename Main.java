import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //Check if file name has arxml extension
    public static boolean isARXMLFile(String fileName){
        boolean isArxml = false;
            for(int i = 0; i < fileName.length(); i++) {
                if(fileName.charAt(i) == '.') {
                    if(
                            fileName.charAt(i + 1) == 'a' &&
                            fileName.charAt(i + 2) == 'r' &&
                            fileName.charAt(i + 3) == 'x' &&
                            fileName.charAt(i + 4) == 'm' &&
                            fileName.charAt(i + 5) == 'l'
                    ) {
                        isArxml = true;
                        break;
                    }
                }
            }
        return isArxml;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Please Enter The ARXML File Name...");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();

            if(!isARXMLFile(fileName)) {
                throw new NotVaildAutosarFileException();
            }

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            String xml = "";

            if(reader.readLine() == null) {
                throw new EmptyAutosarFileException();
            }
            while((line = reader.readLine()) != null) {
                xml = xml.concat("\n" + line);
            }

            //Splitting The Containers
            String[] containers = xml.split("<CONTAINER");
            //Creating The Containers Array
            Container[] containersArr = new Container[containers.length - 1];
            //Filling The Container Array
            for(int i= 1; i < containers.length; i++) {

                String tempString = containers[i].trim().substring(6);
                String id = tempString.substring(0, tempString.indexOf("\""));

                String[] tempArr = containers[i].split("<SHORT-NAME>");
                String shortName = tempArr[1].substring(0, tempArr[1].indexOf("<"));

                tempArr = containers[i].split("<LONG-NAME>");
                String longName = tempArr[1].substring(0, tempArr[1].indexOf("<"));

                containersArr[i - 1] = new Container(id,shortName,longName);
            }

            //Sort The Array Based on Short Name
            Arrays.sort(containersArr, new SortByShortName());

            //Create Output file name
            String[] fileNameArr = fileName.split(".arxml");
            String outputFileName = fileNameArr[0] + "_mod.arxml";

            //Write File
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));


            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<AUTOSAR>");

            for(Container container: containersArr) {
               writer.write("\n\t<CONTAINER UUID=" + "\"" + container.getId() + "\""+ ">");
               writer.write("\n\t\t<SHORT-NAME>" + container.getShortName() + "</SHORT-NAME>");
               writer.write("\n\t\t<LONG-NAME>" + container.getLongName() + "</LONG-NAME>");
               writer.write("\n\t</CONTAINER>");


           }
            writer.write("\n</AUTOSAR>");
            writer.close();

            System.out.println("File Has been Written Successfully");

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch (NotVaildAutosarFileException e) {
            System.out.println("The Entered Name is not a valid arxml File Name");
        } catch (EmptyAutosarFileException e) {
            System.out.println("The arxml File is Empty");
        }
    }
}