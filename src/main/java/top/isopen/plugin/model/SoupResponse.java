package top.isopen.plugin.model;

import java.util.List;

/**
 * @author TimeChaser
 * @since 2021/11/25 15:31
 */
public class SoupResponse {

    private int        status;
    private String     msg;
    private long       timestamp;
    private List<Soup> data;

    public SoupResponse() {
    }

    public SoupResponse(int status, String msg, long timestamp, List<Soup> data) {
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
        this.data = data;
    }

    public String getContent() {
        if (data == null || data.size() == 0) {
            return null;
        }
        return data.get(0).content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Soup> getData() {
        return data;
    }

    public void setData(List<Soup> data) {
        this.data = data;
    }

    public static class Soup {
        private int    id;
        private String content;

        public Soup() {
        }

        public Soup(int id, String content) {
            this.id = id;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
