
package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ExpirationDate implements Serializable
{

    private String date;
    private Integer timezoneType;
    private String timezone;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4661228813349752965L;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTimezoneType() {
        return timezoneType;
    }

    public void setTimezoneType(Integer timezoneType) {
        this.timezoneType = timezoneType;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
