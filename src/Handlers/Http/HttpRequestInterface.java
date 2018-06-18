package Handlers.Http;

import org.json.JSONObject;

public interface HttpRequestInterface {
    JSONObject requestSensors();
    int requestPredict();
}
