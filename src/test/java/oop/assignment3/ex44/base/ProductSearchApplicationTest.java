package oop.assignment3.ex44.base;

import com.google.gson.Gson;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ProductSearchApplicationTest {

    static Stream<Arguments> produceUserEnteredProductIndex(){
        return Stream.of(
            arguments("Widget", 0),
            arguments("Thing", 1),
            arguments("Doodad", 2),
            arguments("Laptop", 3),
            arguments("MacBook", -1));
    }

    static Stream<Arguments> generateOutputString(){
        return Stream.of(
            arguments("Name: Widget\nPrice: 25.00\nQuantity: 5", 0),
            arguments("Name: Thing\nPrice: 15.00\nQuantity: 5", 1),
            arguments("Name: Doodad\nPrice: 5.00\nQuantity: 10", 2),
            arguments("Name: Laptop\nPrice: 750.00\nQuantity: 20", 3));
    }

    static String json = "{\"products\": [ " +
        "{\"name\": \"Widget\", \"price\": 25.00, \"quantity\": 5 }, " +
        "{\"name\": \"Thing\", \"price\": 15.00,  \"quantity\": 5 }, " +
        "{\"name\": \"Doodad\", \"price\": 5.00,  \"quantity\": 10}," +
        "{\"name\": \"Laptop\", \"price\": 750.00, \"quantity\": 20}" +
        " ] }";

    // Gson Object
    Gson gson = new Gson();
    GeneralInfo gsonObject = gson.fromJson(json, GeneralInfo.class);

    @ParameterizedTest
    @MethodSource("produceUserEnteredProductIndex")
    public void test_validateUserEnteredProduct(String userInput, int expected){
        ProductSearchApplication app = new ProductSearchApplication();

        int actual = app.getProductIndexOnTheList(userInput, gsonObject);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("generateOutputString")
    public void test_generateOutputString(String expected, int index){
        ProductSearchApplication application = new ProductSearchApplication();

        String actual = application.printProductInformation(index, gsonObject);

        assertEquals(expected, actual);
    }

}