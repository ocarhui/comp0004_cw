/**
 * Note class is for saving/transferring note into html file.
 *
 *
 */

package uk.ac.ucl.model;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.nio.file.Files;
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
                InputStream is = null;
                OutputStream os = null;
                String imgStyle = imgPath.substring(imgPath.length()-4,imgPath.length());
                try {
                    is = new FileInputStream(new File(imgPath));
                    os = new FileOutputStream(new File("./src/main/webapp/data/"+noteName+imgStyle));
                    imgPath = noteName+imgStyle;
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                } finally {
                    is.close();
                    os.close();
                }

                body = body + "<img src = '" + imgPath +"' name='img'></br>";
            }

            if(urlPath != null){
                body = body + "<a href='" + urlPath + "' name='url'>" + urlPath + "</a></br>";

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
}

