package mzaba.epamCourse.lectures.BLF.generics;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

class InputFileReader {
    private final String inputPath;

    InputFileReader(String inputPath){
        this.inputPath=inputPath;
    }

    ArrayList<PreAcademyStudent> readFile() {
        var inputList = new ArrayList<PreAcademyStudent>();
        try {
            File inputFile = new File(inputPath);
            InputStream inputStream = new FileInputStream(inputFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            inputList =  br.lines().map(line->line.split(","))
                    .map(data->PreAcademyStudent.newStudent(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3])))
                    .collect(Collectors.toCollection(ArrayList::new));
            br.close();
        } catch (IOException e) {
            System.err.println("Unable to read the input file.");
        }
        return inputList;
    }
}
