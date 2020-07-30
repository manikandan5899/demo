import java.util.Scanner;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class fileRetrival
{
	public static void listFiles()
	{
		File dir=new File(".");
		File[] files = dir.listFiles();
		Arrays.sort(files, (f1,f2) -> f1.compareTo(f2));
		for(File file: files)
		{
			if(!file.isHidden())
			{
				if(file.isDirectory())
				{	
				}
				else
				{
					System.out.println("FILE\t" + file.getName());
				}
			}
		}
	}
	public static void addFiles()
	{
				try 
				{
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter File Name:");
			String name=scan.nextLine();
			File myobj=new File(name);
			if(myobj.createNewFile())
			{
				System.out.println("File Created:" + myobj.getName());
			}
			else
			{
				System.out.println("File already exists");
			}
		}
				catch(IOException e)
				{
			System.out.println("Error");
			e.printStackTrace();
		}
	}
    public void findFile(String name,File file1)throws IOException
    {      
        File[] list = file1.listFiles();       
        if(list!=null)  
     {                          
        for(File file2 : list)
        {            
            if (file2.isDirectory())
            {
                findFile(name,file2);             
            }
            else if (name.equalsIgnoreCase(file2.getName()))
            {                                                              
                System.out.println("Found");                
                System.out.println("File found at : "+file2.getParentFile());
                System.out.println("Path diectory: "+file2.getAbsolutePath());                            
           }
        }
      }      
    }
    public void deleteFile()
    {
    	try  
    	{ 
    	System.out.println("enter file name:");
    	Scanner scan=new Scanner(System.in);
    	String s=scan.next();
    	File f= new File(s);       
    	if(f.delete())             
    	{  
    	System.out.println(f.getName() + " deleted");
    	}  
    	else  
    	{  
    	System.out.println("failed");  
    	}  
    	}  
    	catch(Exception e)  
    	{  
    	e.printStackTrace();
    	System.out.println("File not Found");
    	}  
    }
}


public class lockedMe {

	public static void main(String[] args) throws IOException {
		
		fileRetrival obj=new fileRetrival();
		 Scanner scan = new Scanner(System.in);
	  
	        System.out.println("***********************************\n************lockedme.com***********");
	        System.out.println("MENU:");
	        System.out.println("1.List files");
	        System.out.println("2.Business level Operations");
	        System.out.println("3.Close the Application");
	        int choice=scan.nextInt();
	        
	        switch(choice) {
	        case 1:
	        	obj.listFiles();
	        	break;
	        case 2:
	        	System.out.println("1.Add file");
	        	System.out.println("2.Delete file");
	        	System.out.println("3.Search file");
	        	System.out.println("4.Return to menu");
	        	int choice1=scan.nextInt();
	        	
	        	         switch(choice1) {
	        	         case 1:
	        	        	 obj.addFiles();
	        	        	 break;
	        	         case 2:
	        	        	 obj.deleteFile();
	        	        	 break;
	        	         case 3:
	        	        	 System.out.println("Enter the file to be searched.. " );
	        	 	        String name = scan.next();
	        	 	        String directory =".";
	        	 	        obj.findFile(name,new File(directory));
	        	         case 4:
	        	        	 break;
	        	        	 
	        	         }
	        case 3:
	        	System.exit(0);
	        	
	        }
		 }
	}
