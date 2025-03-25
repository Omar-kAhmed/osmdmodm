package nationalize;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Comparator;
import java.util.Optional;

/**
 * Stores the possible countries of origin for a last name.
 *
 * @param count the number of rows examined
 * @param name a last name for which the possible countries of origin are
 *             predicted
 * @param countries a list of the most likely countries of origin
 */
public record Nationality(long count, String name, @SerializedName("country") List<Country> countries) {


    /**
     * Associates a probability with a country of origin.
     *
     * @param countryId a two-letter country code
     * @param probability a probability, i.e., a number between 0 and 1
     */
    public record Country(String countryId, float probability) {}


    /**
     * {@return an optional wrapping the most likely country of origin for the
     * name}
     */
    public Optional<Country> getMostLikelyCountry() {
        return countries.stream().max(Comparator.comparingDouble(Country::probability));
    }
}
