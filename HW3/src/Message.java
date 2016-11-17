import java.io.*;

public class Message {
	
	public String writeDecoded(String message, String name) throws IOException {
		char num =0;
		char[] check = {'0','1','2','3','4','5'};
		for(int i=0;i<name.length();i++) {//decides what to name the new output file based on the input file
			for(char x: check) {
				if(name.charAt(i)==x) {
					num = x;
					break;
				}
			}
		}
		String outfile = "decoded" + num + ".txt";
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile)));//creates the file to write to
		writer.write(message);//writes the message which was previously decoded and inputed
		writer.close();
		return outfile;
	}
	
}
