package kr.ac.kookmin.cs.oop.project.model;

/*
 * A class to store the information about each song entry
 * It should contain all the fields that are registered in the song list file
 * You have to declare fields and way to parse comma separated string to the Song class 
 */
public class Song extends Object{
//자바에서 생성돼는 모든 클래스는 object로 부터 자동으로 상속받음
	public String id;
	public String title;
	String singer;
	public String genre;
	String year;
	String albumName;
	String composer;
	String producer;
	String nation;
	String language;
	String musicLength;
	
	public Song(String entry) {//생성자
        String[] fieldValues = entry.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
      
       this.id=fieldValues[0];
       this.title=fieldValues[1];
       this.singer=fieldValues[2];
       this.genre=fieldValues[3];
       this.year=fieldValues[4];
       this.albumName=fieldValues[5];
       this.composer=fieldValues[6];
       this.producer=fieldValues[7];
       this.nation=fieldValues[8];
       this.language=fieldValues[9];
       this.musicLength=fieldValues[10];
        			
        		}
  
    @Override
    public String toString() {
    	
        return id+","+title+","+singer+","+genre+","+year+","+albumName+
        		","+composer+","+producer+","+nation+","+language+","+musicLength;
    }
}
