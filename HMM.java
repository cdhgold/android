import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HMM implements Runnable{  
 
    public static void main(String[] args) {

        Thread t = new Thread(new HMM());

        //t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다.

        // 디폴트: 독립==> setDaemon(true): 데몬쓰레드로 (메인쓰레드 종료시 종속쓰레드는 작업 다 못끝내도 메인 쓰레드와 함께 종료된다.)

        t.start();
        //execBat(); 
       

        System.out.println("HMM Start...");

    }
    @Override
    public void run() {
        while(true)
        { 
			//이동전의 폴더
			String inFolder = "C:/cdh/cdh/test.edi";
			//이동후의 폴더
			String outFolder = "C:/Temp/cdh/test.edi";
			File f1 = new File(inFolder);
			  
			if(f1.exists())
			{
				if(fileMove(inFolder, outFolder )){
	
			        execBat();
				}
		        
		        
			}else
			{
				
				try {
					Thread.sleep(3 * 1000); // 12시간 3600*12*1000
					System.out.println("작업대기...");
					
				} catch (InterruptedException e) {
					 
					e.printStackTrace();
				}
			}
 
    		

        }

    }
  //파일을 이동하는 메소드
    private boolean fileMove(String inFileName, String outFileName) {
     
     try {
      FileInputStream fis = new FileInputStream(inFileName);
      FileOutputStream fos = new FileOutputStream(outFileName);
      
      int data = 0;
      while((data=fis.read())!=-1) {
       fos.write(data);
      }
      fis.close();
      fos.close();
      
      //복사한뒤 원본파일을 삭제함
      File fd = new File(inFileName);
      fd.delete();
     
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
     return true;
    }
    private static void execBat() {
	 
    	Runtime runtime = Runtime.getRuntime();
    	try {
			 Process p1 = runtime.exec("cmd /c start C:\\Temp\\cdh\\hmm.bat");
		    InputStream is = p1.getInputStream();
		    int i = 0;
		    while( (i = is.read() ) != -1) {
		        System.out.print((char)i);
		    }
    	} catch (IOException e) {
		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
 
    }
        
 

 
}
