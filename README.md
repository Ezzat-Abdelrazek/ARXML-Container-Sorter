# Project Description
## Project Name: ARXML Container Sorter

The ARXML Container Sorter is a Java program designed to read an ARXML file, which contains a list of containers with unique IDs, and reorder them alphabetically by their "SHORT-NAME" sub-container. The program then writes the reordered containers to a new ARXML file.

ARXML (AUTomotive Open System ARchitecture) is an XML-based standard for describing the software architecture of automotive electronic systems. Containers in ARXML files represent software components, and their order can affect the behavior and performance of the system.

## Features
- Reads an ARXML file and validates if it has the correct file extension.
- Parses the ARXML file and extracts container information such as ID, SHORT-NAME, and LONG-NAME.
- Sorts the containers alphabetically by their SHORT-NAME using a custom sorting algorithm.
- Writes the reordered containers to a new ARXML file with "_mod" appended to the original file name.
- Outputs informative error messages for invalid ARXML files or empty files.

## Usage
1. Ensure you have Java installed on your system.
2. Compile the Java program using a Java compiler or an integrated development environment (IDE) of your choice.
3. Run the compiled Java program using the Java Virtual Machine (JVM) with the main class "Main" as the entry point.
4. Follow the program prompts to enter the ARXML file name that you want to process.
5. The program will validate the file extension and check if the file is empty. If the file is valid, it will parse the ARXML file and reorder the containers alphabetically by their SHORT-NAME.
6. The reordered containers will be written to a new ARXML file with "_mod" appended to the original file name.
7. The program will display a success message upon completion.

## Example ARXML File Format
```xml
<?xml version="1.0" encoding="UTF-8"?>
<AUTOSAR>
    <CONTAINER UUID="1">
        <SHORT-NAME>Container1</SHORT-NAME>
        <LONG-NAME>Container 1</LONG-NAME>
    </CONTAINER>
    <CONTAINER UUID="2">
        <SHORT-NAME>Container2</SHORT-NAME>
        <LONG-NAME>Container 2</LONG-NAME>
    </CONTAINER>
    ...
</AUTOSAR>
