package br.com.grabriellpa.casesapi.v1.converter;

import br.com.grabriellpa.casesapi.v1.model.Row;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.io.input.ReaderInputStream;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

@Component
public class CsvConverter {

    /**
     * Gera um csv a partir de uma String e converte para um List<Row>
     *
     * @param content String no formato csv especifico que será convertida
     * @return Um List<Row>, que representa cada linha do CSV
     * @throws CsvValidationException Csv Exception
     * @throws IOException I/O exception
     */
    public List<Row> stringToObject(String content) throws CsvValidationException, IOException {
        CsvToBeanBuilder<Row> beanBuilder = new CsvToBeanBuilder<>(new InputStreamReader(new ReaderInputStream(new StringReader(content))));
        return beanBuilder.withType(Row.class).build().parse();

    }

}
