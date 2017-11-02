package kr.ac.kookmin.cs.oop.project.recommender;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import kr.ac.kookmin.cs.oop.project.model.Song;

public abstract class Recommender {

    protected final Song[] songs;

    public abstract Song[] recommend(String studentId);

    public Recommender(String filePath) {
        this.songs = buildSongObjects(filePath);
    }

    /*
     * Read the input file and fill the Song[] array
     */
    private Song[] buildSongObjects(String filePath) {
        Song[] songs = new Song[376];
        File inputFile = new File(filePath);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
            String line;
            for (int i = 0; (line = br.readLine()) != null; ++i) {
                Song song = new Song(line);
                //System.out.println(line);
                //�Է������� ���پ� �о�ͼ� line�� ���� �ᱹ ���� array�� ��
                // You have to create Song object using fieldValues and store
                // the Song object to songs array
           songs[i]=song;
          
          System.out.println(song);
          
            }
            
        } catch (FileNotFoundException| e) {
            e.printStackTrace();
            return null;
        }

        return songs;
    }

    /*
     * A function to print statistics about Song Title, Singer, Genre, ... You
     * have to implement it
     */
    int a=0;
    int b=0;
    int c=0;
    int d=0;
    public void printSongStatistics() {
    	for(int k=0;k<376;k++){
    		if((songs[k].genre).equals("�˾غ�")){
    	    	a++;
    	    }
    		if((songs[k].genre).equals("�߶��")){
    	    	b++;
        	}
    		if((songs[k].genre).equals("����")){
    	    	c++;
        	}
    		else{
    	    	d++;
        	}
    	}
    	System.out.println("�˾غ�:"+a+"��"+"�߶��:"+b+"��"+"����:"+c+"��"+"��Ÿ:"+d+"��");
    	
}

    /*
     * A function to print basic statistics for each student You have to
     * implement it
     */
    public void printStudentStatistics() {
    	
    	
    	
    	for(int j=0;j<376;j+=10){
    		
    	   System.out.println("�л�"+songs[j].id+"��"+songs[j].genre+"�帣�� ��´�");
    	
    	}
    }
}
