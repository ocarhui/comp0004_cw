package uk.ac.ucl.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class Model {
  private ArrayList<String> urls = new ArrayList<String>();

  public Model(){
    File dir = new File("./src/main/webapp/data");
    File[] directoryListing = dir.listFiles();

    for (File child : directoryListing) {
      if(child.getName().contains(".html") && !child.getName().equals("template.html")){
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
      ReadNote readNote = new ReadNote(urls.get(i));
      if(readNote.getNoteDetail().contains(searchString)
          || urls.get(i).toLowerCase().contains(searchString)){
        retValue.add(urls.get(i));
      }
    }

    return retValue;
  }

  public boolean addNotes(String noteNameIn, String imgPathIn, String urlPathIn, String noteDetailIn){
    boolean retValue = false;
    try {
      Note newNote = new Note(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
      urls.add(noteNameIn);
      retValue = true;
    } catch(Exception e){
      retValue = false;
    }
    return retValue;
  }

  public boolean deleteNote(String noteName) {
    boolean retValue = false;
    for (int i = 0; i < urls.size(); i++) {
      if (urls.get(i).toLowerCase().contains(noteName.toLowerCase())) {
        File targetFile = new File("./src/main/webapp/data/" + noteName + ".html");
        try{
          File imgFile = new File("./src/main/webapp/data/" + noteName + ".png");
          imgFile.delete();
        } finally {

          if (targetFile.delete()) {
            urls.remove(urls.get(i));
            retValue = true;
            break;
          }
        }
      }
    }
    return retValue;
  }

  public ReadNote editNote(String noteName){
    ReadNote note = new ReadNote(noteName);

    return note;
  }

  public ArrayList<String> sortByDescendingOrder(){
    Collections.sort(urls, new Comparator<String>(){
      public int compare(String s1, String s2){
        return s1.toLowerCase().compareTo(s2.toLowerCase());
      }
    });
    return urls;
  }

  public ArrayList<String> sortByAscendingOrder(){
    Collections.sort(urls, new Comparator<String>(){
      public int compare(String s1, String s2){
        return s2.toLowerCase().compareTo(s1.toLowerCase());
      }
    });
    return urls;
  }

  public void removeElementFromURL(String nameIn){
    for(int i = 0; i< urls.size(); i++){
      if(urls.get(i).toLowerCase().equals(nameIn.toLowerCase())){
        urls.remove(urls.get(i));
      }
    }
  }





  public static void main(String[] args){
    Model newModel = new Model();

    ArrayList<String> sortURL = newModel.sortByDescendingOrder();

    for(int i = 0; i<sortURL.size(); i++){
      System.out.println(sortURL.get(i));
    }

  }


}
