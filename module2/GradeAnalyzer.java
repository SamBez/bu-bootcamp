import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {

    public static void main(String[] args) {
        
        int i = 0;
        int countA = 0, countB=0, countC = 0, countD = 0, countF = 0 ;  
        ArrayList<Integer> list = readScores("scores.txt");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (i < list.size()) {
            if(list.get(i) < min){
                min = list.get(i);
            } else if(list.get(i) > max){
                max = list.get(i);
            }
            if(list.get(i) >= 90){
                countA ++;
            } else if (list.get(i) >= 80 && list.get(i) <= 89 ){
                countB ++;
            } else if (list.get(i) >= 70 && list.get(i) <= 79 ){
                countC ++;
            } else if (list.get(i) >= 60 && list.get(i) <= 69 ){
                countD ++;
            } else {
                countF ++;
            }
            i++;
        }
        System.out.println("Min: "+ min);
        System.out.println("Max: "+ max);
        writeReport(list, calculateAverage(list), max, min, "report.txt");

    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();
 try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if(!line.trim().isEmpty()){
                    scores.add(Integer.parseInt(line.trim()));
                    System.out.println(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        } catch (NumberFormatException e ){
            System.out.println("Warning: Number Format Error");
        } catch (Exception e){
            System.out.println(e);
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()){
            return 0.0;
        } 
        int sum = 0, i = 0;
        while(i < scores.size()){
            sum= sum +scores.get(i);
            i++;
        }
        System.out.println(sum/scores.size());
        return  ((double)sum/ (double)scores.size());
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {

        // your code here
 try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)) ){
         writer.write(String.format("Average score: " + avg));
         writer.write(String.format("Highest score: " + high));   
         writer.write(String.format("Lowest score: " + low));

        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        } catch (Exception e){
            System.out.println(e);
        }
    }
} 