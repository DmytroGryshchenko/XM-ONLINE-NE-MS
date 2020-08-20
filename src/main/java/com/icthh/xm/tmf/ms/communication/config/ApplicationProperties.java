package com.icthh.xm.tmf.ms.communication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Communication.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private boolean timelinesEnabled;
    private boolean kafkaEnabled;
    private String kafkaSystemTopic;
    private String kafkaSystemQueue;

    public boolean isTimelinesEnabled() {
        return timelinesEnabled;
    }

    public void setTimelinesEnabled(boolean timelinesEnabled) {
        this.timelinesEnabled = timelinesEnabled;
    }

    public boolean isKafkaEnabled() {
        return kafkaEnabled;
    }

    public void setKafkaEnabled(boolean kafkaEnabled) {
        this.kafkaEnabled = kafkaEnabled;
    }

    public String getKafkaSystemTopic() {
        return kafkaSystemTopic;
    }

    public void setKafkaSystemTopic(String kafkaSystemTopic) {
        this.kafkaSystemTopic = kafkaSystemTopic;
    }

    public String getKafkaSystemQueue() {
        return kafkaSystemQueue;
    }

    public void setKafkaSystemQueue(String kafkaSystemQueue) {
        this.kafkaSystemQueue = kafkaSystemQueue;
    }
}
