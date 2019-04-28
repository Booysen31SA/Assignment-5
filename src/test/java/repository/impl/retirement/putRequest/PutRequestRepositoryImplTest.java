package repository.impl.retirement.putRequest;

import domain.retirement.PutRequest;
import factory.putRequestFactory.PutRequestFactory;
import org.junit.Before;
import org.junit.Test;
import Util.Misc;

import static org.junit.Assert.*;


public class PutRequestRepositoryImplTest {

    PutRequestRepositoryImpl put;

    @Before
    public void setUp() throws Exception {
        put = PutRequestRepositoryImpl.getPutRequest();
    }

    @Test
    public void create() {
        PutRequest putR = PutRequestFactory.requestAdd(216062241, Util.Misc.generateId() , "Matthew", "Booysen", 5000.0);

        put.create(putR);
        assertNotNull(put.getAll());
        System.out.println(put.getAll());
    }

    @Test
    public void update() {
        PutRequest putR = PutRequestFactory.requestAdd(216062245, Util.Misc.generateId() , "Matthew", "Booysen", 5000.0);

        put.create(putR);
        PutRequest updatePutR = PutRequestFactory.requestAdd(216062245, Util.Misc.generateId() , "Matthew", "Booysen", 8700.50);
        put.update(updatePutR);
        assertNotEquals(updatePutR, put.read(216062245));
        System.out.println(put.getAll());
    }

    @Test
    public void delete() {
        PutRequest putR = PutRequestFactory.requestAdd(216062245, Util.Misc.generateId() , "Matthew", "Booysen", 5000.0);

        put.create(putR);
        System.out.println(put.getAll());
        put.delete(216062241);
        assertNull(put.read(216062241));
        System.out.println(put.getAll());
    }

    @Test
    public void read() {
    }
}