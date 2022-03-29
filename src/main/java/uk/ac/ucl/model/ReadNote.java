/**
 * ReadNote class is for reading note from html file, so that searching through html is possible.
 *
 *
 */

package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadNote {
    private String noteName;

    public String getNoteName() {
        return noteName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public String getNoteDetail() {
        return noteDetail;
    }

    private String imgPath = null;
    private String urlPath = null;
    private String noteDetail = null;

    public ReadNote(String noteNameIn){
        if(noteNameIn.equals("template")){

        } else {
            try {
                File fileObj = new File("./src/main/webapp/data/" + noteNameIn + ".html");
                Scanner reader = new Scanner(fileObj);

                noteName = noteNameIn;

                String readLine = reader.nextLine();

                if (readLine.contains("name='img'>")) {
                    imgPath = readLine.substring(readLine.lastIndexOf("img src = ") + 10, readLine.indexOf("name='img'>"));
                }

                if (readLine.contains("name='url'>")) {
                    urlPath = readLine.substring(readLine.lastIndexOf("name='url'>") + 11, readLine.indexOf("</a>"));
                }

                noteDetail = readLine.substring(readLine.lastIndexOf("<textarea wrap='hard'>") + 22, readLine.indexOf("</textarea>"));


                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
