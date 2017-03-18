import java.io.*;

public class logPoints {
	public static void reset() {
		int pointCurr;
		int highscore = Integer.MAX_VALUE;
		// The name of the file to open.
        String fileHigh = "highscore.txt";
        String fileScore = "studyBuddyLog.txt";
        
        String line = null;

        try {
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReaderHigh = new BufferedReader(new FileReader(fileHigh));
            
            line = bufferedReaderHigh.readLine();
            highscore = Integer.valueOf(line);

            // Always close files.
            bufferedReaderHigh.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileHigh + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileHigh + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        try {
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReaderScore = new BufferedReader(new FileReader(fileScore));
            
            line = bufferedReaderScore.readLine();
            pointCurr = Integer.valueOf(line);

            // Always close files.
            bufferedReaderScore.close();
            
            // Only update highscore if highscore
            if (pointCurr>highscore) {
            	 try {
                     // Always wrap FileWriter in BufferedWriter.
                     BufferedWriter bufferedWriterHigh = new BufferedWriter(new FileWriter(fileHigh));

                     bufferedWriterHigh.write(String.valueOf(pointCurr));

                     // Always close files.
                     bufferedWriterHigh.close();
                 }
                 catch(FileNotFoundException ex) {
                     System.out.println("Unable to open file '" + fileHigh + "'");                
                 }
                 catch(IOException ex) {
                     System.out.println("Error reading file '" + fileHigh + "'");                  
                     // Or we could just do this: 
                     // ex.printStackTrace();
                 }
            }

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriterScore = new BufferedWriter(new FileWriter(fileScore));

            // Note that write() does not automatically
            // append a newline character.
            for (int i=0; i<4;i++) {
            	bufferedWriterScore.write("0");
            	bufferedWriterScore.newLine();
            }

            // Always close files.
            bufferedWriterScore.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileHigh + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileHigh + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

	}
	
    public static void update(int seconds, int timeGoal) {
    	int pointCurr;
    	int pointIn = 0;
    	if (seconds>=timeGoal) {
    		pointIn = (int)Math.pow((timeGoal/60),2);
    	}

        // The name of the file to open.
        String fileName = "studyBuddyLog.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            line = bufferedReader.readLine();
            pointCurr = Integer.valueOf(line);

            // Always close files.
            bufferedReader.close();
            
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(String.valueOf(pointCurr+pointIn));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(pointIn));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(seconds));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(timeGoal));

            // Always close files.
            bufferedWriter.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
}

