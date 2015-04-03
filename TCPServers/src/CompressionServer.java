import java.io.*;
import java.net.Socket;
import java.util.zip.*;


public class CompressionServer {

	static final int BUFFER = 2048;
	public static void main (String argv[]) {
		try {
			
			Socket socket = new Socket("WebServer", Integer.parseInt(argv[0]));

		    InputStream in = socket.getInputStream();
		    OutputStream out = socket.getOutputStream();
		    
		    
			BufferedInputStream origin = null;
			FileOutputStream dest = new FileOutputStream(fileOutput);
			ZipOutputStream out2 = new ZipOutputStream(new BufferedOutputStream(dest));
			//out.setMethod(ZipOutputStream.DEFLATED);
			byte data[] = new byte[BUFFER];
			// get a list of files from current directory
			System.out.println("Adding: "+ fileInput);
			FileInputStream fi = new FileInputStream(fileInput);
			origin = new BufferedInputStream(fi, BUFFER);
			ZipEntry entry = new ZipEntry(fileInput);
			out2.putNextEntry(entry);
			int count;
			while((count = origin.read(data, 0, 
					BUFFER)) != -1) {
				out.write(data, 0, count);
			}
			
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}