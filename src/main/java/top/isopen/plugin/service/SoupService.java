package top.isopen.plugin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.isopen.plugin.model.SoupResponse;
import top.isopen.plugin.util.HttpClientHelper;

/**
 * @author TimeChaser
 * @since 2021/11/25 15:01
 */
public class SoupService {

    public static final String API = "https://api.nextrt.com/V1/Dutang";

    public String getContent() {
        String response = HttpClientHelper.sendGet(API);
        if (response == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        SoupResponse soupResponse = null;
        try {
            soupResponse = objectMapper.readValue(response, SoupResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return soupResponse != null ? soupResponse.getContent() : null;
    }
}
