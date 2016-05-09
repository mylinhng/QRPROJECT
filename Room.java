package main;

import java.util.Hashtable;

public class Room {
	private String room;

	public Room() {
		
	}
	
	public String get(String data)
	{
	
		room = null;
		// TODO extract the room number eg E2004 from the data passed in
		// Here you write the code to parse the data string and extract
		// the room
		
		
		String Saut = "[\n]+";
		String[] lines = data.split(Saut);
		
		String l0 = lines[0];
		String delims0 = "[:]+";
		String[] line0 = l0.split(delims0);

		String name0 = line0[0];  // Day in name0
		String value0 = line0[1]; // Tuesday in value0
		//System.out.println(value0);
		
		String l1 = lines[1];
		String delims1 = "[:]+";
		String[] line1 = l1.split(delims1);
		String name1 = line1[0];
		String value1 = new String();
		for(int i = 1; i<line1.length; i++){
			value1 = value1 +":"+ line1[i];
		}
		//System.out.println(value1);
		
		String l2 = lines[2];
		String delims2 = "[:]+";
		String[] line2 = l2.split(delims2);
		String name2 = line2[0];  // Subject in name2
		String value2 = line2[1]; // Software Engineering in value2
		//System.out.println(value2);
		
		String l3 = lines[3];
		String delims3 = "[:]+";
		String[] line3 = l3.split(delims3);
		String name3 = line3[0];  // Room in name3
		String value3 = line3[1]; // E2004 in value3
		//System.out.println(value3);
						
	    Hashtable table = new Hashtable();
	    table.put(name0, value0);
	    table.put(name1, value1);
	    table.put(name2, value2);
	    table.put(name3, value3);

	    System.out.println(table);
		
		room = value3 ; 
		return(room.trim()); 
	}

}