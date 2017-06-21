/**
 * <h1>Task1Mapper</h1>
 * Mapper class to filter out the invalid records from the input file.
 * This class will take input as (Key,Value) pair from a given file and will
 * produce the output as (Key,Value) pair.
 * */
package mapreduce.assignment4.task1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task1Mapper extends Mapper<LongWritable, Text, NullWritable, Text> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		//every line will be split based on '|' and will be stored in String array
		String[] lineArray = value.toString().split("\\|");
		//will check for not null and valid record
		if((lineArray.length > 0) && 
				(lineArray[0] != null) &&
				(lineArray[1] != null) &&
				(! lineArray[0].equalsIgnoreCase("NA")) &&
				(! lineArray[1].equalsIgnoreCase("NA"))
				) {
				context.write(NullWritable.get(), value);
			}
	}
}