package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
class Meeting {
    public int start;
    public int end;
    
    public Meeting(int start,int end){
        this.start = start;
        this.end = end;
        
    }
}
public class NMeetings {
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Meeting> ls = new ArrayList<>();
        for(int i = 0;i<n;i++){
            ls.add(new Meeting(start[i],end[i]));
        }
        Collections.sort(ls, (a,b)-> (a.end - b.end));
        int totalNumofMeetings = 1;
        int currEndTime = ls.get(0).end;
        for(int j=1;j<n;j++){
            if(ls.get(j).start>currEndTime){
                totalNumofMeetings++;
                currEndTime =ls.get(j).end;
            }
        }
        return totalNumofMeetings;
    }
}
