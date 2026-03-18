import org.dawone.textreporter.FactOfTheDayLineReader;
import org.dawone.textreporter.TextReporter;
import org.dawone.textreporter.WordProcessor;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TextReporterTest {
    @Test
    public void TextReporter_readLines_and_saveWords(){
        FactOfTheDayLineReader lectorLineas = Mockito.mock(FactOfTheDayLineReader.class);
        WordProcessor wordProcessor = new WordProcessor();
        TextReporter textReporter = new TextReporter(lectorLineas, wordProcessor);
        when(lectorLineas.readLines()).thenReturn(new String[]{"patata"," helado"});

        String palabraEsperada="patata";

        boolean resultadoActual = textReporter.reportIsWordUsed(palabraEsperada);


        Mockito.verify(lectorLineas).readLines();
        assertTrue(resultadoActual);

    };
}
