package com.bingchen.growtokenserver.growtokenserver;

import java.util.Timer;

public class DBTimer {
    Timer timer;
    public DBTimer(int time){
        timer = new Timer();
        timer.schedule(new CallDBTimer(), time * 1000,1000 * 60 * 60);
    }
    
    public void stopTimer(){
    	timer.cancel();
    }
    
}

