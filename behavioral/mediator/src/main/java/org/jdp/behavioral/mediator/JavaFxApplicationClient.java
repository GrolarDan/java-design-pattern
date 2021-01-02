package org.jdp.behavioral.mediator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplicationClient extends Application {

  private ConfigurableApplicationContext applicationContext;

  @Override
  public void init() {
    String[] args = getParameters().getRaw().toArray(new String[0]);

    this.applicationContext = new SpringApplicationBuilder()
            .sources(SpringBootApplicationClient.class)
            .run(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    var slider = applicationContext.getBean(org.jdp.behavioral.mediator.Slider.class);
    var box = applicationContext.getBean(org.jdp.behavioral.mediator.TextBox.class);
    var label = applicationContext.getBean(org.jdp.behavioral.mediator.Label.class);

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setVgap(20);
    grid.setPadding(new Insets(25, 25, 25, 25));
    grid.add(label, 0, 0);
    grid.add(slider, 0, 1);
    grid.add(box, 0, 2);
    Scene scene = new Scene(grid, 500, 500);
    primaryStage.setTitle("Mediator Pattern");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Override
  public void stop() throws Exception {
    applicationContext.close();
    Platform.exit();
  }

}
