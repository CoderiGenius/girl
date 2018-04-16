package com.imooc.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    @Getter @Setter
    public String cupSize;
    @Getter @Setter
    public String age;

    public String say(){
        return cupSize+age;
    }
}
