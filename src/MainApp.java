import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Administrator on 2017/4/20.
 */
public class MainApp extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        UIFrame uiFrame = new UIFrame();
        uiFrame.setUp(primaryStage);
        primaryStage.show();
    }
}
