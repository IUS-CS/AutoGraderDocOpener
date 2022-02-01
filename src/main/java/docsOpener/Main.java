package docsOpener;

import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String separator = System.getProperty("file.separator");

        //Creating a File object for directory
        // use "." for run directory
        File directoryPath = new File(System.getProperty("user.dir"));

        String[] directories = directoryPath.list((current, name) -> new File(current, name).isDirectory());

        if (directories == null){
            System.out.println("No Directories found to search for docs!");
        }

        assert directories != null;
        for (String directory:directories) {

            String pathName = directoryPath.getAbsoluteFile()+separator+ directory + separator + "docs" + separator+ "index.html";

            File htmlFile = new File( pathName);

            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            }catch(java.io.IOException ioe){
                System.out.println("Could not find the docs for: "+ pathName);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
