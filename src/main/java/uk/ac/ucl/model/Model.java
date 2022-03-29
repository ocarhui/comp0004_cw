/**
 * Model class is for modelling note and readNote and provide easy access from servlet and jsp.
 *
 *
 */

package uk.ac.ucl.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

  /**
   * @return Arraylist of note names
   */
  public ArrayList<String> getNoteNames(){
    return urls;
  }

  /**
   * Search for the target note with the same name or having the content
   * @param searchString The search string
   * @return Arraylist containing the match notes
   */
  public ArrayList<String> searchNotes(String searchString){
    ArrayList<String> retValue = new ArrayList<String>();
    searchString = searchString.toLowerCase();
    for(int i = 0; i< urls.size(); i++){
      ReadNote readNote = new ReadNote(urls.get(i));
      if(readNote.getNoteDetail().toLowerCase().contains(searchString)
          || urls.get(i).toLowerCase().contains(searchString)){
        retValue.add(urls.get(i));
      }
    }

    return retValue;
  }

  /**
   * Turn note from different fields into note html format.
   * @param noteNameIn name of Note
   * @param imgPathIn image attachment to the Note
   * @param urlPathIn url attachment to the Note
   * @param noteDetailIn note details
   * @return true for successfully added, false for error
   */
  public boolean addNotes(String noteNameIn, String imgPathIn, String urlPathIn, String noteDetailIn){
    boolean retValue = false;
    boolean ifHasSame = false;

    for(int i=0; i<urls.size(); i++){
      if(noteNameIn.toLowerCase().equals(urls.get(i).toLowerCase())){
        ifHasSame = true;
        break;
      }
    }

    if(ifHasSame==false) {
      try {
        Note newNote = new Note(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
        urls.add(noteNameIn);
        retValue = true;
      } catch (Exception e) {
        retValue = false;
      }
    }
    return retValue;
  }

  public boolean saveEditNote(String originalNoteNameIn, String noteNameIn, String imgPathIn, String urlPathIn, String noteDetailIn){
    boolean retValue = false;
    boolean ifHasSame = false;

    if(imgPathIn.equals("") || imgPathIn.equals("null"))
      imgPathIn = null;

    if(urlPathIn.equals("") || urlPathIn.equals("null"))
      urlPathIn = null;

    originalNoteNameIn = originalNoteNameIn.substring(0,originalNoteNameIn.length()-1);
    if(originalNoteNameIn.toLowerCase().equals(noteNameIn.toLowerCase())){
      try {
        Note newNote = new Note(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
        urls.add(noteNameIn);
        retValue = true;
      } catch (Exception e) {
        retValue = false;
      }
    } else {
      for(int i=0; i<urls.size(); i++){
        if(noteNameIn.toLowerCase().equals(urls.get(i).toLowerCase())){
          ifHasSame = true;
          break;
        }
      }

      if(ifHasSame==false) {
        try {
          deleteNote(originalNoteNameIn);
          Note newNote = new Note(noteNameIn, imgPathIn, urlPathIn, noteDetailIn);
          urls.add(noteNameIn);
          retValue = true;
        } catch (Exception e) {
          retValue = false;
        }
      }
    }

    return retValue;
  }

  /**
   * Delete note
   * @param noteName name of Note
   * @return true for successfully deleted, false for error
   */
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

  /**
   * read the data inside the note to Edit
   * @param noteName name of Note
   * @return a ReadNote which contains all the parameters of the note.
   */
  public ReadNote editNote(String noteName){
    ReadNote note = new ReadNote(noteName);

    return note;
  }

  /**
   * Sort the note list in descending order.
   * @return a sorted list
   */
  public ArrayList<String> sortByDescendingOrder(){
    Collections.sort(urls, new Comparator<String>(){
      public int compare(String s1, String s2){
        return s1.toLowerCase().compareTo(s2.toLowerCase());
      }
    });
    return urls;
  }

  /**
   * Sort the note list in ascending order.
   * @return a sorted list
   */
  public ArrayList<String> sortByAscendingOrder(){
    Collections.sort(urls, new Comparator<String>(){
      public int compare(String s1, String s2){
        return s2.toLowerCase().compareTo(s1.toLowerCase());
      }
    });
    return urls;
  }
}
