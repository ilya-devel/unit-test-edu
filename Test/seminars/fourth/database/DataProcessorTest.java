package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    @Test
    void dataProcessorTest() {
        Database db = mock(Database.class);
        DataProcessor dbProc = new DataProcessor(db);

//        String query = "test";
//        List<String> fakeData = new ArrayList<>();
//        fakeData.add("Data1");
//        fakeData.add("Data2");
//        fakeData.add("Data3");
//
//        when(db.query(query)).thenReturn(fakeData);
//
//        assertThat(dbProc.processData(query)).isEqualTo(fakeData);

        when(db.query(anyString())).thenReturn(Arrays.asList("tmp1", "tmp2", "tmp3"));

        assertThat(dbProc.processData("llls"))
                .isNotEmpty().hasSize(3)
                .isEqualTo(Arrays.asList("tmp1", "tmp2", "tmp3"));

        verify(db, times(1)).query("llls");
    }

}