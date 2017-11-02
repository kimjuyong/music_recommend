package kr.ac.kookmin.cs.oop.project.recommender.impl;

import kr.ac.kookmin.cs.oop.project.model.Song;
import kr.ac.kookmin.cs.oop.project.recommender.Recommender;

/*
 * A song recommender that simply relies on random algorithm.
 * Recommend whatever you want to
 */
public class RandomRecommender extends Recommender {

    public RandomRecommender(String filePath) {
        super(filePath);
    }

    /*
     * Write your own recommender module. You can remove the for loop and write
     * your custom logic
     */
    
    
    
    @Override
    public Song[] recommend(String studentId) {
    	
    	
    	int i=0;
    	Song[] song2=new Song[10];
    	Song[] song1=new Song[376];
        for (Song song : this.songs) {
        	
        	song1[i]=song;
        	
        	i++;
        }
        
        for(int t=0;t<10;t++){
        	int random=(int)(Math.random()*376);
        	if(183<=random&&random<=192)
        	{
        		continue;
        	}
        	song2[t]=song1[random];
        }
        return song2;
    	
    }
    }
