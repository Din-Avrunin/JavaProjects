package GettingReadyForAmdocs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;

public class Duplicates {
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		String path = "C:\\Users\\dinav\\eclipse-workspace\\zzsa\\src\\GettingReadyForAmdocs\\FolderForMergingFilesAndDeletingDuplicates\\";
		File folder = new File(path);
		String res="";
		for (File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory())
			{
				String fileName = fileEntry.getPath();
				try {
					BufferedReader br = new BufferedReader (new FileReader(fileName));
					String line;
					while ((line = br.readLine()) != null)
					{
						hs.add(line);
					}
					br.close();
					BufferedWriter bw = new BufferedWriter(new FileWriter(path+"result\\new.txt"));
					res = hs.toString();
					res = res.substring(1, res.length()-1);
					res=res.replaceAll(",", "\n");
					res=res.replaceAll(" ", "");
					bw.write(res);
					bw.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}	
			}
		}	
		System.out.println(res);
	}

}


