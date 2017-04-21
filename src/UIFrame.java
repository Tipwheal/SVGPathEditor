import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;


/**
 * Created by Administrator on 2017/4/20.
 */
public class UIFrame {
    private AnchorPane mainPane;
    private DebugStage debugStage;

    public void setUp(Stage stage) {
        debugStage = new DebugStage();
        mainPane = new AnchorPane();
        mainPane.setPrefWidth(500);
        mainPane.setPrefHeight(500);
        addContent();
        stage.setScene(new Scene(mainPane));
    }

    private void addContent() {
        TextArea textArea = new TextArea();
        textArea.setLayoutX(40);
        textArea.setLayoutY(40);
        textArea.setPrefColumnCount(10);
        textArea.setPrefRowCount(5);
        debugStage.addDebug(textArea);
        TextField colorField = new TextField();
        colorField.setLayoutX(50);
        colorField.setLayoutY(100);
        debugStage.addDebug(colorField);
        AnchorPane shapePane = new AnchorPane();
        shapePane.setLayoutX(60);
        shapePane.setLayoutY(80);
        shapePane.setPrefHeight(100);
        shapePane.setPrefWidth(100);
        shapePane.setStyle("-fx-background-color: #456789");
        debugStage.addDebug(shapePane);
        SVGPath path = new SVGPath();
        path.setFill(Color.TRANSPARENT);
        path.setStroke(Color.WHITE);
        path.setStrokeWidth(1);
        shapePane.getChildren().add(path);
        mainPane.getChildren().addAll(textArea, shapePane, colorField);
        Button generate = new Button();
        generate.setLayoutX(100);
        generate.setLayoutY(300);
        generate.setText("生成");
        debugStage.addDebug(generate);
        generate.setOnAction(e -> {
            path.setContent(textArea.getText());
            if(colorField.getText().matches("([0-9|a-f|A-F]{6})|([0-9|a-f|A-F]{3})|([0-9|a-f|A-F]{8})")) {
                shapePane.setStyle("-fx-background-color: #" + colorField.getText());
            }
        });
        Button debugButton = new Button("调试");
        debugStage.addDebug(debugButton);
        debugButton.setLayoutY(400);
        debugButton.setOnAction(e -> {
            if (debugStage.isActive()) {
                debugStage.hide();
            } else {
                debugStage.show();
            }
        });
//        Button alignButton = new Button("对齐");
        mainPane.getChildren().addAll(generate, debugButton);
    }

}
