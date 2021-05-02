import java.util.*;
import java.io.File;
import java.io.IOException;

public class LockMe{
	public void StartScreen(){
		System.out.println("Welcome to LockMe!");
	    System.out.println("Your digital safe storage partner!");
	    for(int i =0;i<=40;i++) {
	    	System.out.print("*");
	    }
	}
	public void Menu(){
		System.out.println("\n\t MENU \n");
		System.out.println("1 -> Display sorted files in locker");
		System.out.println("2 -> Perform locker operations");
		System.out.println("3 -> Exit");
		System.out.println("Please enter your choice: ");
	}
	public void FileOperations() {
		System.out.println("\n\t MENU \n");
		System.out.println("1 -> Add files to locker");
		System.out.println("2 -> Delete files from locker");
		System.out.println("3 -> Search locker for a specific file");
		System.out.println("4 -> Return to main menu");
		System.out.println("Please enter your choice: ");
	}
	
	public static String [] FileSorter(String [] fileList) {
		int sizeofArray = fileList.length;
		for(int i = 0; i<sizeofArray-1; i++)   
		{  
			for (int j = i+1; j<sizeofArray; j++)   
			{  
			//compares each elements of the array to all the remaining elements  
			if(fileList[i].compareTo(fileList[j])>0)   
			{  
			//swapping array elements  
			String temp = fileList[i];  
			fileList[i] = fileList[j];  
			fileList[j] = temp;  
			}  
			}  
			}  
			//prints the sorted array in ascending order  
			return(fileList);  
			}  
	
	
	
    public static void main(String args[]){
    	//Variables
    	int response;
    	int file_response;
    	int directory_counter;
    	boolean return2mainMenu;
        String lockerPath ;
        String [] FileList; 
        
        
        // Objects
    	Scanner scan = new Scanner(System.in);
    	LockMe locker = new LockMe();
    	
    	
    	//Start of Process
    	//Initialize the path
    	do {
	        System.out.println("Enter LockerName :");
	        String lockerName = scan.next();
	        File setDirectory = new File(lockerName);
	        if(setDirectory.exists()) {
	        	System.out.println("Name already taken try again");
	        	directory_counter = 0;
	        	lockerPath = " ";
	        }
	        else {
	        	setDirectory.mkdir();
	        	lockerPath = setDirectory.getAbsolutePath();
	        	directory_counter=1;
	        }
    	}while(directory_counter==0);
    	System.out.println(lockerPath);
    	File file = new File(lockerPath);
    	
        do {
        	locker.StartScreen();
            locker.Menu();
        	int choice = scan.nextInt();
        	switch(choice) {
            case 1:{
            	System.out.println("Loading...\n");
            	FileList = file.list();
            	if(FileList.length==0) {
        			System.out.println("No files present !!!");
        		}
            	else {
            		System.out.println("The files present in the locker are:");
            		String [] sortedFiles = LockMe.FileSorter(FileList);
            		for(String filename : sortedFiles) {
            			System.out.println(filename);                		
                	}
        		}
            	System.out.println("Do you wish to return to main menu ? (Y/N)");
            	char exit_choice = scan.next().charAt(0);
            	System.out.println(exit_choice);
            	if(exit_choice == 'Y' || exit_choice == 'y') {
            		response = 1;
            	}
            	else {
            		System.out.println("Thank you for using LockMe.");
            		response = 0;
            	}
            	break;
            }
            case 2:{
            	do {
	            	System.out.println("Files Operations");
	            	locker.FileOperations();
            	
	            	int choice2 = scan.nextInt();
	            	switch(choice2) {
	            	case 1:{
	            		System.out.println("Add file to locker.");
	            		System.out.println("Path of locker directory:\n"+lockerPath);
	            		System.out.println("Enter valid filename:");
	            		String file_name = scan.next();
	            		File addingFile = new File(lockerPath+"\\"+file_name);
	            		try {
	            		if (addingFile.createNewFile()) {
	            	        System.out.println("File created: " + addingFile.getName());
	            	      }
	            		else {
	            	        System.out.println("File already exists.");
	            	      }
	            		}
	            		catch (IOException e) {
	            		      System.out.println("An error occurred.");
	            		      e.printStackTrace();
	            		}
	            		System.out.println("Do you wish to return to main menu ? (Y/N)");
	                	char exit_choice = scan.next().charAt(0);
	            		if (exit_choice == 'Y'||exit_choice == 'y') {
	            			return2mainMenu = true;
	            			file_response = 0;
	            		}
	            		else {
	            			return2mainMenu = false;
	            			System.out.println("\n");
	            			file_response = 1;
	            		}
	            		
	            		break;
	            	}
	            	case 2:{
	            		System.out.println("Delete file to locker.");
	            		System.out.println("Path of locker directory:\n"+lockerPath);
	            		System.out.println("Enter filename to be deleted:");
	            		String file_name = scan.next();
	            		File addingFile = new File(lockerPath+"\\"+file_name);
	            		
	            		if (addingFile.delete()) {
	            	        System.out.println("File deleted: " + addingFile.getName());
	            	      }
	            		else {
	            	        System.out.println("File does not exists.");
	            	      }
	            		
	            		
	            		System.out.println("Do you wish to return to main menu ? (Y/N)");
	                	char exit_choice = scan.next().charAt(0);
	            		if (exit_choice == 'Y'||exit_choice == 'y') {
	            			return2mainMenu = true;
	            			file_response = 0;
	            		}
	            		else {
	            			return2mainMenu = false;
	            			System.out.println("\n");
	            			file_response = 1;
	            		}
	            		
	            		break;
	            	}
	            	case 3:{
	            		System.out.println("Search the locker for a file.");
	            		System.out.println("Path of locker directory:\n"+lockerPath);
	            		System.out.println("Enter filename to be searched:");
	            		String file_name = scan.next();
	            		File fileSearch = new File(lockerPath+"\\"+file_name);
	            		if(fileSearch.exists()) {
	            			System.out.println("File "+file_name+" is present in Locker.");
	            		}
	            		else {
	            			System.out.println("File not found.");
	            		}
	            		System.out.println("Do you wish to return to main menu ? (Y/N)");
	                	char exit_choice = scan.next().charAt(0);
	            		if (exit_choice == 'Y'||exit_choice == 'y') {
	            			return2mainMenu = true;
	            			file_response = 0;
	            		}
	            		else {
	            			return2mainMenu = false;
	            			System.out.println("\n");
	            			file_response = 1;
	            		}
	            		
	            		break;
	            	}
	            	case 4:{
	            		System.out.println("Returning to main menu.");
	            		return2mainMenu = true;
	            		file_response = 0;
	            		break;
	            	}
	            	default :{
	            		System.out.println("Entered an Invalid choice.Please try again !");
	            		locker.FileOperations();
	            		file_response=1;
	            		return2mainMenu = false;
	            		break;
	            	}
	            	}
            	}while(file_response==1);
            	if(return2mainMenu==true){
            		response = 1;
            	}
            	else {
            		response = 0;
            	}
            	break;
            }
            case 3:{
            	System.out.println("Exit");
            	System.out.println("Thank you for using LockMe.");
            	response = 0;
            	break;
            }
            default : {
            	System.out.println("Please try again");
            	locker.Menu();
            	response = 1;
            	break;
            }
            }        	
        }while(response == 1);
        
        //End of process
        //Close off all connections.
        scan.close();
        }
        
        
}