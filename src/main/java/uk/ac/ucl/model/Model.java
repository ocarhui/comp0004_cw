package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
  private static ArrayList<String> urls = new ArrayList<String>();

  public Model(){
    File dir = new File("./src/main/webapp/data");
    File[] directoryListing = dir.listFiles();

    for (File child : directoryListing) {
      if(child.getName().contains(".html")){
        urls.add(child.getName().substring(0,child.getName().length()-5));
      }
    }

  }

  public ArrayList<String> getNoteNames(){
    return urls;
  }

  public ArrayList<String> searchNotes(String searchString){
    ArrayList<String> retValue = new ArrayList<String>();
    searchString = searchString.toLowerCase();
    for(int i = 0; i< urls.size(); i++){
      if(urls.get(i).toLowerCase().contains(searchString)){
          retValue.add(urls.get(i));
      }
    }

    return retValue;
  }

  public boolean addNotes(String noteNameIn, String imgPathIn, String urlPathIn, String noteDetailIn){
    boolean retValue = false;
    try {
      Note newNote = new Note(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
      retValue = true;
    } catch(Exception e){
      retValue = false;
    }
    return retValue;
  }

  public static void main(String[] args){
    Model newModel = new Model();

    for(int i = 0; i<newModel.urls.size(); i++){
      System.out.println(newModel.urls.get(i));
    }

  }


}
