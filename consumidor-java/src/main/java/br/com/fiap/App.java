package br.com.fiap;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import br.com.fiap.model.BolsaFamilia;
import br.com.fiap.util.ConsumerCreator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        runConsumer();
    }

    public static void runConsumer() {
        Consumer<String, BolsaFamilia> consumer = ConsumerCreator.createConsumer("localhost:9092", "consumer-group-2", "bolsafamilia2");

        BolsaFamilia maiorBolsaFamilia = null;

        while (true) {
			ConsumerRecords<String, BolsaFamilia> records = consumer.poll(0);
            if (records.count() != 0) {
                for(ConsumerRecord<String, BolsaFamilia> record: records) {
                    if (maiorBolsaFamilia == null || record.value().getValorParcela() > maiorBolsaFamilia.getValorParcela()) {
                        maiorBolsaFamilia = record.value();
                        System.out.println("MAIOR PARCELA:");
                        System.out.println("NIS FAVORECIDO: " + maiorBolsaFamilia.getNisFavorecido());
                        System.out.println("NOME FAVORECIDO: " + maiorBolsaFamilia.getNomeFavorecido());
                        System.out.println("VALOR PARCELA: " + maiorBolsaFamilia.getValorParcela());
                        System.out.println("NOME MUNICIPIO: " + maiorBolsaFamilia.getNomeFavorecido());
                        System.out.println("UF : " + maiorBolsaFamilia.getUF());
                    }
                }
            }
        }
    }
}
