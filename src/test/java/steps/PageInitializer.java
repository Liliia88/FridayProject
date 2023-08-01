package steps;

import pages.DockerPage;
import pages.TablePage;

public class PageInitializer {
    public static TablePage table;
    public static DockerPage docker;
    public static void initializePageObjects(){
        table = new TablePage();
        docker= new DockerPage();


    }

}
