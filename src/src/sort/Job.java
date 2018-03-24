package sort;

/**
 * @author Bilal Jaffry. 
 * @version JobADT version 1.0, 02/22/18
 */
public class Job implements Comparable<Job>{
	
		/**
		 * Intializes's global String variable for JobID.
		 */
		private String JobID;
		/**
		 *Intializes's global Integer variable for RunTime.
		 */
		private int RunTime;
		/**
		 * Sets up an empty Job constructor.
		 */
		public Job() {
			
		} 
		
		/**
		 * Proper constructor for jobs, passing in jobID and Runtime.
		 * @param JobID - string representing the jobID in the given a1_in.txt
		 * @param RunTime - integer representing the Runtime for specific job in a1_in.txt
		 */
		
		public Job(String JobID, int RunTime) {
			this.JobID = JobID;
			this.RunTime = RunTime;
		}
		/**
		 * Retrieves current job runtime.
		 * @return returns the the specific runtime for a given job.
		 */
		public int getRunTime() { 
			return RunTime;
		}
		/**
		 * Sets the current jobs runtime.
		 * @param newRuntime sets the runtime of specific job to parameter integer value.
		 */
		public void setRunTime(int newRuntime) {
			this.RunTime = newRuntime;
		}
		/**
		 * Retrieves current job jobID.
		 * @return returns the specific jobID for a given job.
		 */
		public String getJobID() {
			return JobID;
		}
	
		

		/**
		 * Compares two given jobs and returns interger values occordinly.
		 * @param j - the external job data type, being compared with current job.
		 */
		@Override
		public int compareTo(Job j)
		{
			Job job = j;
			if (this.getRunTime() < job.getRunTime()) {
				return -1;
			}  
			return 1;
		}


}
	
		
		
