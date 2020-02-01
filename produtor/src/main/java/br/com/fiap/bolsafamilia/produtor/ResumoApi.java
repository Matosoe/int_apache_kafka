package br.com.fiap.bolsafamilia.produtor;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;

@RestController
@RequestMapping("/bolsafamilia")
public class ResumoApi {

    private final KafkaProducer kafkaProducer;

    public ResumoApi(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/resumos")
    public ResponseEntity<String> csvFile(@RequestBody String csvFile) {
        JSONObject pagamentoBolsaFamilia = new JSONObject();

        try {
            // Create an object of file reader class with CSV file as a parameter.
            FileReader filereader = new FileReader(csvFile);

            // create csvParser object with
            // custom seperator semi-colon
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            // create csvReader object with parameter
            // filereader and parser
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build();
            String[] nextRecord;

         // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                pagamentoBolsaFamilia.put("MES REFERENCIA", nextRecord[0]);
                pagamentoBolsaFamilia.put("MES COMPETENCIA", nextRecord[1]);
                pagamentoBolsaFamilia.put("UF",nextRecord[2]);
                pagamentoBolsaFamilia.put("CODIGO MUNICIPIO SIAFI",Integer.parseInt(nextRecord[3]));
                pagamentoBolsaFamilia.put("NOME MUNICIPIO", nextRecord[4]);
                pagamentoBolsaFamilia.put("NIS FAVORECIDO", nextRecord[5]);
                pagamentoBolsaFamilia.put("NOME FAVORECIDO", nextRecord[6]);
                pagamentoBolsaFamilia.put("VALOR PARCELA", Float.parseFloat(nextRecord[7].replace(',','.')));

                kafkaProducer.send(pagamentoBolsaFamilia.toJSONString());
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Arquivo lido e colocado no tópico bolsafamilia");
    }
}