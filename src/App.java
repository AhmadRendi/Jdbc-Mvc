import controller.RegionController;
import tools.Connect;

public class App {

    public static void main(String[] args) throws Exception {
        RegionController regionController = new RegionController();

        regionController.getAll();
    }

}
