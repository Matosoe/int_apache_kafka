package br.com.fiap.util;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.common.serialization.Deserializer;

import br.com.fiap.model.BolsaFamilia;


/**
 * KafkaJsonDeserializer
 */
public class KafkaJsonDeserializer implements Deserializer<BolsaFamilia> {

    @Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public BolsaFamilia deserialize(String topic, byte[] data) {
		ObjectMapper  mapper = new ObjectMapper();
        BolsaFamilia object = null;
        
		try {
			object = mapper.readValue(data, BolsaFamilia.class);
		} catch (Exception exception) {
			System.out.println("Error in deserializing bytes " + exception);
		}
		return object;
	}

	@Override
	public void close() {
	}
}