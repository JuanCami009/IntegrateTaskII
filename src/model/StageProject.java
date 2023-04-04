package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StageProject {

    
    private Calendar initialDate;
    private Calendar finalDate;
    private DateFormat formatter;

    public StageProject(Calendar initialDate, Calendar finalDate){

        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
        
    
    }

    public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}		
        
}
