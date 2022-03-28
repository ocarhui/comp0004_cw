package uk.ac.ucl.model;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Note {
    private String noteName;
    private String imgPath;
    private String urlPath;
    private String noteDetail;

    public Note(String noteNameIn, String imgPathIn, String urlPathIn, String noteDetailIn){
        noteName = noteNameIn;
        imgPath = imgPathIn;
        urlPath = urlPathIn;
        noteDetail = noteDetailIn;

        try{
            File templateFile = new File("./src/main/webapp/data/template.html");
            Scanner sc = new Scanner(templateFile);
            String fileStr = "";

            while(sc.hasNext()){
                fileStr = fileStr + sc.nextLine();
            }

            String title = noteNameIn;
            String body = "";

            if(imgPath != null){
                body = body + "<img src = '" + imgPath +"'></br>";
            }

            if(urlPath != null){
                body = body + "<a href='" + urlPath + "'>" + urlPath + "</a></br>";

            }

            body = body + "<textarea wrap='hard'>" + noteDetailIn + "</textarea>";

            fileStr = fileStr.replace("$title",title);

            fileStr = fileStr.replace("$body",body);

            System.out.println(fileStr);

            File newFile = new File("./src/main/webapp/data/" + noteName + ".html");
            FileWriter writer = new FileWriter(newFile);
            writer.write(fileStr);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String urlPath = "samsung.com";
        Note newNote = new Note("Here", null, urlPath, "This is the detail.");
    }
}

