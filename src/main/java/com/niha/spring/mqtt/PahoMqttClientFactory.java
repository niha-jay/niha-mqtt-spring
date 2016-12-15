package com.niha.spring.mqtt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PahoMqttClientFactory {

    @Value("${mqtt.broker.connection.uri}")
    private String brokerUri;

    @Value("${mqtt.broker.connection.cleanSession}")
    private boolean cleanSession;

    private DefaultMqttPahoClientFactory mqttPahoClientFactory;

    @PostConstruct
    public void initializeMqttClient() {
        mqttPahoClientFactory = new DefaultMqttPahoClientFactory();
        mqttPahoClientFactory.setServerURIs(brokerUri);
        //mqttPahoClientFactory.setServerURIs("tcp://163.172.172.191:1883");
//        mqttPahoClientFactory.setServerURIs("ssl://163.172.172.191:1883");
        mqttPahoClientFactory.setCleanSession(cleanSession);
//        try {
//            mqttPahoClientFactory.setSocketFactory(SslUtil.getSocketFactory("/ca.crt", "/client.crt", "/client.key", "cbridge"));
//        } catch (Exception e) {
//            // TODO Handle exception
//            e.printStackTrace();
//        }
    }

    public MqttPahoClientFactory get() {
        return mqttPahoClientFactory;
    }
}
