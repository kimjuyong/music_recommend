package kr.ac.kookmin.cs.oop.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import kr.ac.kookmin.cs.oop.project.model.Song;
import kr.ac.kookmin.cs.oop.project.recommender.Recommender;
import kr.ac.kookmin.cs.oop.project.recommender.impl.RandomRecommender;

public class Main {

    private final String[] studentIds;

    private Recommender musicRecommender;

    public Main(String filePath) {
        studentIds = extractStudentsIds(filePath);
        musicRecommender = new RandomRecommender(filePath);
    }

    /*
     * From the input file path that contains information about the song
     * preference list, it should extract unique students IDs and it should
     * return it as a String array. There are 36 unique student IDs and you
     * should return only the unique IDs.
     */
    private static String[] extractStudentsIds(String filePath) {
        File inputFile = new File(filePath);
        String[] studentIds = new String[37];
        String[] idd=new String[376];
        String ID=null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
            int i=0;
        	for (String line; (line = br.readLine()) != null;) {
        		
                
                String[] fieldValues = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            idd[i]=fieldValues[0];
                    i++;
               }
        	
        	for(int j=0;j<37;j++){
        		studentIds[j]=ID;
        		studentIds[0]=idd[0];
        	
        		loop1:for(int k=j*10;k<376;k++){
        		if(studentIds[j]==idd[k])
        		
        			continue loop1;
        		else	
                    ID=idd[k];
        		break;
        	    }
        		System.out.println(studentIds[j]);
        		}	
        	//System.out.println(studentIds[]);
        	
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return studentIds;
    }

    /*
     * A function to print out basic statistics about song and students
     */
    public void printStatistics() {
        musicRecommender.printSongStatistics();
        musicRecommender.printStudentStatistics();
    }

    /*
     * A function that calls recommend function that is implemented in different
     * classes
     */
    public void recommend() {
        for (String student : studentIds) {
            Song[] recommendedSongs = musicRecommender.recommend(student);
       //학생아이디와 노래 출력 여기서
        
        }
    }
    
    public static void main(String[] args) {
        Main runner = new Main("resource/oop-2016-song-project.csv");
        runner.printStatistics();
        runner.recommend();
    }
}
