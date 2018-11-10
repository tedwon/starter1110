package io.vertx.starter;

import java.util.Date;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      final String msg = new Date() + " Hello from Vert.x!";
      req.response()
        .putHeader("content-type", "text/plain")
        .end(msg);
        System.out.println(msg);
    }).listen(8080, http -> {
      if (http.succeeded()) {
        startFuture.complete();
        System.out.println("HTTP server started on http://localhost:8080");
      } else {
        startFuture.fail(http.cause());
      }
    });
  }

}
